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
package org.clang.ast.java;

import org.clang.ast.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class AstTypesRTTI {
  /*package*/AstTypesRTTI() {}

  public static boolean isa_AdjustedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AdjustedType.class, From.$deref());
  }

  public static AdjustedType cast_AdjustedType(type$ref<?>/*P*/ From) {
    assert isa_AdjustedType(From);
    return llvm.cast(AdjustedType.class, From.$deref());
  }

  public static AdjustedType cast_or_null_AdjustedType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AdjustedType(From);
  }

  public static AdjustedType dyn_cast_AdjustedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static AdjustedType dyn_cast_or_null_AdjustedType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static boolean isa_AdjustedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AdjustedType.class, From.$star());
  }

  public static AdjustedType cast_AdjustedType(type$ptr<?>/*P*/ From) {
    assert isa_AdjustedType(From);
    return llvm.cast(AdjustedType.class, From.$star());
  }

  public static AdjustedType cast_or_null_AdjustedType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AdjustedType(From);
  }

  public static AdjustedType dyn_cast_AdjustedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static AdjustedType dyn_cast_or_null_AdjustedType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static boolean isa_AdjustedType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType cast_AdjustedType(QualType/*P*/ From) {
    return cast_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType cast_or_null_AdjustedType(QualType/*P*/ From) {
    return cast_or_null_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType dyn_cast_AdjustedType(QualType/*P*/ From) {
    return isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static AdjustedType dyn_cast_or_null_AdjustedType(QualType/*P*/ From) {
    return (From != null) && isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static boolean isa_AdjustedType(Type/*P*/ From) {
    assert From != null;
    return AdjustedType.classof(From);
  }

  public static AdjustedType cast_AdjustedType(Type/*P*/ From) {
    assert isa_AdjustedType(From);
    return (AdjustedType) From;
  }

  public static AdjustedType cast_or_null_AdjustedType(Type/*P*/ From) {
    return (From == null) ? null : cast_AdjustedType(From);
  }

  public static AdjustedType dyn_cast_AdjustedType(Type/*P*/ From) {
    assert From != null;
    return isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static AdjustedType dyn_cast_or_null_AdjustedType(Type/*P*/ From) {
    return (From != null) && isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static boolean isa_AdjustedType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType cast_AdjustedType(CanQual<? extends Type>/*P*/ From) {
    return cast_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType cast_or_null_AdjustedType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_AdjustedType(From.getTypePtr());
  }

  public static AdjustedType dyn_cast_AdjustedType(CanQual<? extends Type>/*P*/ From) {
    return isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static AdjustedType dyn_cast_or_null_AdjustedType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_AdjustedType(From) ? cast_AdjustedType(From) : null;
  }

  public static boolean isa_ArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArrayType.class, From.$deref());
  }

  public static ArrayType cast_ArrayType(type$ref<?>/*P*/ From) {
    assert isa_ArrayType(From);
    return llvm.cast(ArrayType.class, From.$deref());
  }

  public static ArrayType cast_or_null_ArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(Type/*P*/ From) {
    assert From != null;
    return ArrayType.classof(From);
  }

  public static ArrayType cast_ArrayType(Type/*P*/ From) {
    assert isa_ArrayType(From);
    return (ArrayType) From;
  }

  public static ArrayType cast_or_null_ArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(Type/*P*/ From) {
    return (From != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ArrayType(From.getTypePtr());
  }

  public static ArrayType cast_ArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_ArrayType(From.getTypePtr());
  }

  public static ArrayType cast_or_null_ArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ArrayType(From.getTypePtr());
  }

  public static ArrayType dyn_cast_ArrayType(CanQual<? extends Type>/*P*/ From) {
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ArrayType(From.getTypePtr());
  }

  public static ArrayType cast_ArrayType(QualType/*P*/ From) {
    return cast_ArrayType(From.getTypePtr());
  }

  public static ArrayType cast_or_null_ArrayType(QualType/*P*/ From) {
    return cast_or_null_ArrayType(From.getTypePtr());
  }

  public static ArrayType dyn_cast_ArrayType(QualType/*P*/ From) {
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(QualType/*P*/ From) {
    return (From != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArrayType.class, From.$star());
  }

  public static ArrayType cast_ArrayType(type$ptr<?>/*P*/ From) {
    assert isa_ArrayType(From);
    return llvm.cast(ArrayType.class, From.$star());
  }

  public static ArrayType cast_or_null_ArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_AtomicType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AtomicType(From.getTypePtr());
  }

  public static AtomicType cast_AtomicType(CanQual<? extends Type>/*P*/ From) {
    return cast_AtomicType(From.getTypePtr());
  }

  public static AtomicType cast_or_null_AtomicType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_AtomicType(From.getTypePtr());
  }

  public static AtomicType dyn_cast_AtomicType(CanQual<? extends Type>/*P*/ From) {
    return isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static AtomicType dyn_cast_or_null_AtomicType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static boolean isa_AtomicType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AtomicType.class, From.$deref());
  }

  public static AtomicType cast_AtomicType(type$ref<?>/*P*/ From) {
    assert isa_AtomicType(From);
    return llvm.cast(AtomicType.class, From.$deref());
  }

  public static AtomicType cast_or_null_AtomicType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AtomicType(From);
  }

  public static AtomicType dyn_cast_AtomicType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static AtomicType dyn_cast_or_null_AtomicType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static boolean isa_AtomicType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AtomicType(From.getTypePtr());
  }

  public static AtomicType cast_AtomicType(QualType/*P*/ From) {
    return cast_AtomicType(From.getTypePtr());
  }

  public static AtomicType cast_or_null_AtomicType(QualType/*P*/ From) {
    return cast_or_null_AtomicType(From.getTypePtr());
  }

  public static AtomicType dyn_cast_AtomicType(QualType/*P*/ From) {
    return isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static AtomicType dyn_cast_or_null_AtomicType(QualType/*P*/ From) {
    return (From != null) && isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static boolean isa_AtomicType(Type/*P*/ From) {
    assert From != null;
    return AtomicType.classof(From);
  }

  public static AtomicType cast_AtomicType(Type/*P*/ From) {
    assert isa_AtomicType(From);
    return (AtomicType) From;
  }

  public static AtomicType cast_or_null_AtomicType(Type/*P*/ From) {
    return (From == null) ? null : cast_AtomicType(From);
  }

  public static AtomicType dyn_cast_AtomicType(Type/*P*/ From) {
    assert From != null;
    return isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static AtomicType dyn_cast_or_null_AtomicType(Type/*P*/ From) {
    return (From != null) && isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static boolean isa_AtomicType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AtomicType.class, From.$star());
  }

  public static AtomicType cast_AtomicType(type$ptr<?>/*P*/ From) {
    assert isa_AtomicType(From);
    return llvm.cast(AtomicType.class, From.$star());
  }

  public static AtomicType cast_or_null_AtomicType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AtomicType(From);
  }

  public static AtomicType dyn_cast_AtomicType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static AtomicType dyn_cast_or_null_AtomicType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AtomicType(From) ? cast_AtomicType(From) : null;
  }

  public static boolean isa_AttributedType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AttributedType(From.getTypePtr());
  }

  public static AttributedType cast_AttributedType(QualType/*P*/ From) {
    return cast_AttributedType(From.getTypePtr());
  }

  public static AttributedType cast_or_null_AttributedType(QualType/*P*/ From) {
    return cast_or_null_AttributedType(From.getTypePtr());
  }

  public static AttributedType dyn_cast_AttributedType(QualType/*P*/ From) {
    return isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static AttributedType dyn_cast_or_null_AttributedType(QualType/*P*/ From) {
    return (From != null) && isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static boolean isa_AttributedType(Type/*P*/ From) {
    assert From != null;
    return AttributedType.classof(From);
  }

  public static AttributedType cast_AttributedType(Type/*P*/ From) {
    assert isa_AttributedType(From);
    return (AttributedType) From;
  }

  public static AttributedType cast_or_null_AttributedType(Type/*P*/ From) {
    return (From == null) ? null : cast_AttributedType(From);
  }

  public static AttributedType dyn_cast_AttributedType(Type/*P*/ From) {
    assert From != null;
    return isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static AttributedType dyn_cast_or_null_AttributedType(Type/*P*/ From) {
    return (From != null) && isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static boolean isa_AttributedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AttributedType.class, From.$deref());
  }

  public static AttributedType cast_AttributedType(type$ref<?>/*P*/ From) {
    assert isa_AttributedType(From);
    return llvm.cast(AttributedType.class, From.$deref());
  }

  public static AttributedType cast_or_null_AttributedType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AttributedType(From);
  }

  public static AttributedType dyn_cast_AttributedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static AttributedType dyn_cast_or_null_AttributedType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static boolean isa_AttributedType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AttributedType(From.getTypePtr());
  }

  public static AttributedType cast_AttributedType(CanQual<? extends Type>/*P*/ From) {
    return cast_AttributedType(From.getTypePtr());
  }

  public static AttributedType cast_or_null_AttributedType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_AttributedType(From.getTypePtr());
  }

  public static AttributedType dyn_cast_AttributedType(CanQual<? extends Type>/*P*/ From) {
    return isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static AttributedType dyn_cast_or_null_AttributedType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static boolean isa_AttributedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AttributedType.class, From.$star());
  }

  public static AttributedType cast_AttributedType(type$ptr<?>/*P*/ From) {
    assert isa_AttributedType(From);
    return llvm.cast(AttributedType.class, From.$star());
  }

  public static AttributedType cast_or_null_AttributedType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AttributedType(From);
  }

  public static AttributedType dyn_cast_AttributedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static AttributedType dyn_cast_or_null_AttributedType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AttributedType(From) ? cast_AttributedType(From) : null;
  }

  public static boolean isa_AutoType(Type/*P*/ From) {
    assert From != null;
    return AutoType.classof(From);
  }

  public static AutoType cast_AutoType(Type/*P*/ From) {
    assert isa_AutoType(From);
    return (AutoType) From;
  }

  public static AutoType cast_or_null_AutoType(Type/*P*/ From) {
    return (From == null) ? null : cast_AutoType(From);
  }

  public static AutoType dyn_cast_AutoType(Type/*P*/ From) {
    assert From != null;
    return isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static AutoType dyn_cast_or_null_AutoType(Type/*P*/ From) {
    return (From != null) && isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static boolean isa_AutoType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AutoType(From.getTypePtr());
  }

  public static AutoType cast_AutoType(QualType/*P*/ From) {
    return cast_AutoType(From.getTypePtr());
  }

  public static AutoType cast_or_null_AutoType(QualType/*P*/ From) {
    return cast_or_null_AutoType(From.getTypePtr());
  }

  public static AutoType dyn_cast_AutoType(QualType/*P*/ From) {
    return isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static AutoType dyn_cast_or_null_AutoType(QualType/*P*/ From) {
    return (From != null) && isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static boolean isa_AutoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AutoType.class, From.$star());
  }

  public static AutoType cast_AutoType(type$ptr<?>/*P*/ From) {
    assert isa_AutoType(From);
    return llvm.cast(AutoType.class, From.$star());
  }

  public static AutoType cast_or_null_AutoType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AutoType(From);
  }

  public static AutoType dyn_cast_AutoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static AutoType dyn_cast_or_null_AutoType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static boolean isa_AutoType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_AutoType(From.getTypePtr());
  }

  public static AutoType cast_AutoType(CanQual<? extends Type>/*P*/ From) {
    return cast_AutoType(From.getTypePtr());
  }

  public static AutoType cast_or_null_AutoType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_AutoType(From.getTypePtr());
  }

  public static AutoType dyn_cast_AutoType(CanQual<? extends Type>/*P*/ From) {
    return isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static AutoType dyn_cast_or_null_AutoType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static boolean isa_AutoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AutoType.class, From.$deref());
  }

  public static AutoType cast_AutoType(type$ref<?>/*P*/ From) {
    assert isa_AutoType(From);
    return llvm.cast(AutoType.class, From.$deref());
  }

  public static AutoType cast_or_null_AutoType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AutoType(From);
  }

  public static AutoType dyn_cast_AutoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static AutoType dyn_cast_or_null_AutoType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AutoType(From) ? cast_AutoType(From) : null;
  }

  public static boolean isa_BlockPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockPointerType.class, From.$deref());
  }

  public static BlockPointerType cast_BlockPointerType(type$ref<?>/*P*/ From) {
    assert isa_BlockPointerType(From);
    return llvm.cast(BlockPointerType.class, From.$deref());
  }

  public static BlockPointerType cast_or_null_BlockPointerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockPointerType(From);
  }

  public static BlockPointerType dyn_cast_BlockPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static BlockPointerType dyn_cast_or_null_BlockPointerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static boolean isa_BlockPointerType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType cast_BlockPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType cast_or_null_BlockPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType dyn_cast_BlockPointerType(CanQual<? extends Type>/*P*/ From) {
    return isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static BlockPointerType dyn_cast_or_null_BlockPointerType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static boolean isa_BlockPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockPointerType.class, From.$star());
  }

  public static BlockPointerType cast_BlockPointerType(type$ptr<?>/*P*/ From) {
    assert isa_BlockPointerType(From);
    return llvm.cast(BlockPointerType.class, From.$star());
  }

  public static BlockPointerType cast_or_null_BlockPointerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockPointerType(From);
  }

  public static BlockPointerType dyn_cast_BlockPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static BlockPointerType dyn_cast_or_null_BlockPointerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static boolean isa_BlockPointerType(Type/*P*/ From) {
    assert From != null;
    return BlockPointerType.classof(From);
  }

  public static BlockPointerType cast_BlockPointerType(Type/*P*/ From) {
    assert isa_BlockPointerType(From);
    return (BlockPointerType) From;
  }

  public static BlockPointerType cast_or_null_BlockPointerType(Type/*P*/ From) {
    return (From == null) ? null : cast_BlockPointerType(From);
  }

  public static BlockPointerType dyn_cast_BlockPointerType(Type/*P*/ From) {
    assert From != null;
    return isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static BlockPointerType dyn_cast_or_null_BlockPointerType(Type/*P*/ From) {
    return (From != null) && isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static boolean isa_BlockPointerType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType cast_BlockPointerType(QualType/*P*/ From) {
    return cast_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType cast_or_null_BlockPointerType(QualType/*P*/ From) {
    return cast_or_null_BlockPointerType(From.getTypePtr());
  }

  public static BlockPointerType dyn_cast_BlockPointerType(QualType/*P*/ From) {
    return isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static BlockPointerType dyn_cast_or_null_BlockPointerType(QualType/*P*/ From) {
    return (From != null) && isa_BlockPointerType(From) ? cast_BlockPointerType(From) : null;
  }

  public static boolean isa_BuiltinType(Type/*P*/ From) {
    assert From != null;
    return BuiltinType.classof(From);
  }

  public static BuiltinType cast_BuiltinType(Type/*P*/ From) {
    assert isa_BuiltinType(From);
    return (BuiltinType) From;
  }

  public static BuiltinType cast_or_null_BuiltinType(Type/*P*/ From) {
    return (From == null) ? null : cast_BuiltinType(From);
  }

  public static BuiltinType dyn_cast_BuiltinType(Type/*P*/ From) {
    assert From != null;
    return isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static BuiltinType dyn_cast_or_null_BuiltinType(Type/*P*/ From) {
    return (From != null) && isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static boolean isa_BuiltinType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType cast_BuiltinType(QualType/*P*/ From) {
    return cast_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType cast_or_null_BuiltinType(QualType/*P*/ From) {
    return cast_or_null_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType dyn_cast_BuiltinType(QualType/*P*/ From) {
    return isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static BuiltinType dyn_cast_or_null_BuiltinType(QualType/*P*/ From) {
    return (From != null) && isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static boolean isa_BuiltinType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BuiltinType.class, From.$star());
  }

  public static BuiltinType cast_BuiltinType(type$ptr<?>/*P*/ From) {
    assert isa_BuiltinType(From);
    return llvm.cast(BuiltinType.class, From.$star());
  }

  public static BuiltinType cast_or_null_BuiltinType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BuiltinType(From);
  }

  public static BuiltinType dyn_cast_BuiltinType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static BuiltinType dyn_cast_or_null_BuiltinType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static boolean isa_BuiltinType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType cast_BuiltinType(CanQual<? extends Type>/*P*/ From) {
    return cast_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType cast_or_null_BuiltinType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_BuiltinType(From.getTypePtr());
  }

  public static BuiltinType dyn_cast_BuiltinType(CanQual<? extends Type>/*P*/ From) {
    return isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static BuiltinType dyn_cast_or_null_BuiltinType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static boolean isa_BuiltinType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BuiltinType.class, From.$deref());
  }

  public static BuiltinType cast_BuiltinType(type$ref<?>/*P*/ From) {
    assert isa_BuiltinType(From);
    return llvm.cast(BuiltinType.class, From.$deref());
  }

  public static BuiltinType cast_or_null_BuiltinType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BuiltinType(From);
  }

  public static BuiltinType dyn_cast_BuiltinType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static BuiltinType dyn_cast_or_null_BuiltinType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BuiltinType(From) ? cast_BuiltinType(From) : null;
  }

  public static boolean isa_ComplexType(Type/*P*/ From) {
    assert From != null;
    return ComplexType.classof(From);
  }

  public static ComplexType cast_ComplexType(Type/*P*/ From) {
    assert isa_ComplexType(From);
    return (ComplexType) From;
  }

  public static ComplexType cast_or_null_ComplexType(Type/*P*/ From) {
    return (From == null) ? null : cast_ComplexType(From);
  }

  public static ComplexType dyn_cast_ComplexType(Type/*P*/ From) {
    assert From != null;
    return isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static ComplexType dyn_cast_or_null_ComplexType(Type/*P*/ From) {
    return (From != null) && isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static boolean isa_ComplexType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ComplexType.class, From.$star());
  }

  public static ComplexType cast_ComplexType(type$ptr<?>/*P*/ From) {
    assert isa_ComplexType(From);
    return llvm.cast(ComplexType.class, From.$star());
  }

  public static ComplexType cast_or_null_ComplexType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ComplexType(From);
  }

  public static ComplexType dyn_cast_ComplexType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static ComplexType dyn_cast_or_null_ComplexType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static boolean isa_ComplexType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ComplexType(From.getTypePtr());
  }

  public static ComplexType cast_ComplexType(QualType/*P*/ From) {
    return cast_ComplexType(From.getTypePtr());
  }

  public static ComplexType cast_or_null_ComplexType(QualType/*P*/ From) {
    return cast_or_null_ComplexType(From.getTypePtr());
  }

  public static ComplexType dyn_cast_ComplexType(QualType/*P*/ From) {
    return isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static ComplexType dyn_cast_or_null_ComplexType(QualType/*P*/ From) {
    return (From != null) && isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static boolean isa_ComplexType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ComplexType.class, From.$deref());
  }

  public static ComplexType cast_ComplexType(type$ref<?>/*P*/ From) {
    assert isa_ComplexType(From);
    return llvm.cast(ComplexType.class, From.$deref());
  }

  public static ComplexType cast_or_null_ComplexType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ComplexType(From);
  }

  public static ComplexType dyn_cast_ComplexType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static ComplexType dyn_cast_or_null_ComplexType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static boolean isa_ComplexType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ComplexType(From.getTypePtr());
  }

  public static ComplexType cast_ComplexType(CanQual<? extends Type>/*P*/ From) {
    return cast_ComplexType(From.getTypePtr());
  }

  public static ComplexType cast_or_null_ComplexType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ComplexType(From.getTypePtr());
  }

  public static ComplexType dyn_cast_ComplexType(CanQual<? extends Type>/*P*/ From) {
    return isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static ComplexType dyn_cast_or_null_ComplexType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ComplexType(From) ? cast_ComplexType(From) : null;
  }

  public static boolean isa_ConstantArrayType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType cast_ConstantArrayType(QualType/*P*/ From) {
    return cast_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType cast_or_null_ConstantArrayType(QualType/*P*/ From) {
    return cast_or_null_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType dyn_cast_ConstantArrayType(QualType/*P*/ From) {
    return isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static ConstantArrayType dyn_cast_or_null_ConstantArrayType(QualType/*P*/ From) {
    return (From != null) && isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static boolean isa_ConstantArrayType(Type/*P*/ From) {
    assert From != null;
    return ConstantArrayType.classof(From);
  }

  public static ConstantArrayType cast_ConstantArrayType(Type/*P*/ From) {
    assert isa_ConstantArrayType(From);
    return (ConstantArrayType) From;
  }

  public static ConstantArrayType cast_or_null_ConstantArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_ConstantArrayType(From);
  }

  public static ConstantArrayType dyn_cast_ConstantArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static ConstantArrayType dyn_cast_or_null_ConstantArrayType(Type/*P*/ From) {
    return (From != null) && isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static boolean isa_ConstantArrayType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType cast_ConstantArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType cast_or_null_ConstantArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ConstantArrayType(From.getTypePtr());
  }

  public static ConstantArrayType dyn_cast_ConstantArrayType(CanQual<? extends Type>/*P*/ From) {
    return isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static ConstantArrayType dyn_cast_or_null_ConstantArrayType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static boolean isa_ConstantArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantArrayType.class, From.$star());
  }

  public static ConstantArrayType cast_ConstantArrayType(type$ptr<?>/*P*/ From) {
    assert isa_ConstantArrayType(From);
    return llvm.cast(ConstantArrayType.class, From.$star());
  }

  public static ConstantArrayType cast_or_null_ConstantArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantArrayType(From);
  }

  public static ConstantArrayType dyn_cast_ConstantArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static ConstantArrayType dyn_cast_or_null_ConstantArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static boolean isa_ConstantArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantArrayType.class, From.$deref());
  }

  public static ConstantArrayType cast_ConstantArrayType(type$ref<?>/*P*/ From) {
    assert isa_ConstantArrayType(From);
    return llvm.cast(ConstantArrayType.class, From.$deref());
  }

  public static ConstantArrayType cast_or_null_ConstantArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantArrayType(From);
  }

  public static ConstantArrayType dyn_cast_ConstantArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static ConstantArrayType dyn_cast_or_null_ConstantArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantArrayType(From) ? cast_ConstantArrayType(From) : null;
  }

  public static boolean isa_DecayedType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DecayedType(From.getTypePtr());
  }

  public static DecayedType cast_DecayedType(CanQual<? extends Type>/*P*/ From) {
    return cast_DecayedType(From.getTypePtr());
  }

  public static DecayedType cast_or_null_DecayedType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DecayedType(From.getTypePtr());
  }

  public static DecayedType dyn_cast_DecayedType(CanQual<? extends Type>/*P*/ From) {
    return isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static DecayedType dyn_cast_or_null_DecayedType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static boolean isa_DecayedType(Type/*P*/ From) {
    assert From != null;
    return DecayedType.classof(From);
  }

  public static DecayedType cast_DecayedType(Type/*P*/ From) {
    assert isa_DecayedType(From);
    return (DecayedType) From;
  }

  public static DecayedType cast_or_null_DecayedType(Type/*P*/ From) {
    return (From == null) ? null : cast_DecayedType(From);
  }

  public static DecayedType dyn_cast_DecayedType(Type/*P*/ From) {
    assert From != null;
    return isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static DecayedType dyn_cast_or_null_DecayedType(Type/*P*/ From) {
    return (From != null) && isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static boolean isa_DecayedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DecayedType.class, From.$star());
  }

  public static DecayedType cast_DecayedType(type$ptr<?>/*P*/ From) {
    assert isa_DecayedType(From);
    return llvm.cast(DecayedType.class, From.$star());
  }

  public static DecayedType cast_or_null_DecayedType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DecayedType(From);
  }

  public static DecayedType dyn_cast_DecayedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static DecayedType dyn_cast_or_null_DecayedType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static boolean isa_DecayedType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DecayedType(From.getTypePtr());
  }

  public static DecayedType cast_DecayedType(QualType/*P*/ From) {
    return cast_DecayedType(From.getTypePtr());
  }

  public static DecayedType cast_or_null_DecayedType(QualType/*P*/ From) {
    return cast_or_null_DecayedType(From.getTypePtr());
  }

  public static DecayedType dyn_cast_DecayedType(QualType/*P*/ From) {
    return isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static DecayedType dyn_cast_or_null_DecayedType(QualType/*P*/ From) {
    return (From != null) && isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static boolean isa_DecayedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DecayedType.class, From.$deref());
  }

  public static DecayedType cast_DecayedType(type$ref<?>/*P*/ From) {
    assert isa_DecayedType(From);
    return llvm.cast(DecayedType.class, From.$deref());
  }

  public static DecayedType cast_or_null_DecayedType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DecayedType(From);
  }

  public static DecayedType dyn_cast_DecayedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static DecayedType dyn_cast_or_null_DecayedType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DecayedType(From) ? cast_DecayedType(From) : null;
  }

  public static boolean isa_DecltypeType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType cast_DecltypeType(QualType/*P*/ From) {
    return cast_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType cast_or_null_DecltypeType(QualType/*P*/ From) {
    return cast_or_null_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType dyn_cast_DecltypeType(QualType/*P*/ From) {
    return isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static DecltypeType dyn_cast_or_null_DecltypeType(QualType/*P*/ From) {
    return (From != null) && isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static boolean isa_DecltypeType(Type/*P*/ From) {
    assert From != null;
    return DecltypeType.classof(From);
  }

  public static DecltypeType cast_DecltypeType(Type/*P*/ From) {
    assert isa_DecltypeType(From);
    return (DecltypeType) From;
  }

  public static DecltypeType cast_or_null_DecltypeType(Type/*P*/ From) {
    return (From == null) ? null : cast_DecltypeType(From);
  }

  public static DecltypeType dyn_cast_DecltypeType(Type/*P*/ From) {
    assert From != null;
    return isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static DecltypeType dyn_cast_or_null_DecltypeType(Type/*P*/ From) {
    return (From != null) && isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static boolean isa_DecltypeType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType cast_DecltypeType(CanQual<? extends Type>/*P*/ From) {
    return cast_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType cast_or_null_DecltypeType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DecltypeType(From.getTypePtr());
  }

  public static DecltypeType dyn_cast_DecltypeType(CanQual<? extends Type>/*P*/ From) {
    return isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static DecltypeType dyn_cast_or_null_DecltypeType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static boolean isa_DecltypeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DecltypeType.class, From.$star());
  }

  public static DecltypeType cast_DecltypeType(type$ptr<?>/*P*/ From) {
    assert isa_DecltypeType(From);
    return llvm.cast(DecltypeType.class, From.$star());
  }

  public static DecltypeType cast_or_null_DecltypeType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DecltypeType(From);
  }

  public static DecltypeType dyn_cast_DecltypeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static DecltypeType dyn_cast_or_null_DecltypeType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static boolean isa_DecltypeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DecltypeType.class, From.$deref());
  }

  public static DecltypeType cast_DecltypeType(type$ref<?>/*P*/ From) {
    assert isa_DecltypeType(From);
    return llvm.cast(DecltypeType.class, From.$deref());
  }

  public static DecltypeType cast_or_null_DecltypeType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DecltypeType(From);
  }

  public static DecltypeType dyn_cast_DecltypeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static DecltypeType dyn_cast_or_null_DecltypeType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DecltypeType(From) ? cast_DecltypeType(From) : null;
  }

  public static boolean isa_DependentDecltypeType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType cast_DependentDecltypeType(QualType/*P*/ From) {
    return cast_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType cast_or_null_DependentDecltypeType(QualType/*P*/ From) {
    return cast_or_null_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType dyn_cast_DependentDecltypeType(QualType/*P*/ From) {
    return isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static DependentDecltypeType dyn_cast_or_null_DependentDecltypeType(QualType/*P*/ From) {
    return (From != null) && isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static boolean isa_DependentDecltypeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentDecltypeType.class, From.$star());
  }

  public static DependentDecltypeType cast_DependentDecltypeType(type$ptr<?>/*P*/ From) {
    assert isa_DependentDecltypeType(From);
    return llvm.cast(DependentDecltypeType.class, From.$star());
  }

  public static DependentDecltypeType cast_or_null_DependentDecltypeType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentDecltypeType(From);
  }

  public static DependentDecltypeType dyn_cast_DependentDecltypeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static DependentDecltypeType dyn_cast_or_null_DependentDecltypeType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static boolean isa_DependentDecltypeType(Type/*P*/ From) {
    assert From != null;
    return DependentDecltypeType.classof(From);
  }

  public static DependentDecltypeType cast_DependentDecltypeType(Type/*P*/ From) {
    assert isa_DependentDecltypeType(From);
    return (DependentDecltypeType) From;
  }

  public static DependentDecltypeType cast_or_null_DependentDecltypeType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentDecltypeType(From);
  }

  public static DependentDecltypeType dyn_cast_DependentDecltypeType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static DependentDecltypeType dyn_cast_or_null_DependentDecltypeType(Type/*P*/ From) {
    return (From != null) && isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static boolean isa_DependentDecltypeType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType cast_DependentDecltypeType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType cast_or_null_DependentDecltypeType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentDecltypeType(From.getTypePtr());
  }

  public static DependentDecltypeType dyn_cast_DependentDecltypeType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static DependentDecltypeType dyn_cast_or_null_DependentDecltypeType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static boolean isa_DependentDecltypeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentDecltypeType.class, From.$deref());
  }

  public static DependentDecltypeType cast_DependentDecltypeType(type$ref<?>/*P*/ From) {
    assert isa_DependentDecltypeType(From);
    return llvm.cast(DependentDecltypeType.class, From.$deref());
  }

  public static DependentDecltypeType cast_or_null_DependentDecltypeType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentDecltypeType(From);
  }

  public static DependentDecltypeType dyn_cast_DependentDecltypeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static DependentDecltypeType dyn_cast_or_null_DependentDecltypeType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentDecltypeType(From) ? cast_DependentDecltypeType(From) : null;
  }

  public static boolean isa_DependentNameType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType cast_DependentNameType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType cast_or_null_DependentNameType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType dyn_cast_DependentNameType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static DependentNameType dyn_cast_or_null_DependentNameType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static boolean isa_DependentNameType(Type/*P*/ From) {
    assert From != null;
    return DependentNameType.classof(From);
  }

  public static DependentNameType cast_DependentNameType(Type/*P*/ From) {
    assert isa_DependentNameType(From);
    return (DependentNameType) From;
  }

  public static DependentNameType cast_or_null_DependentNameType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentNameType(From);
  }

  public static DependentNameType dyn_cast_DependentNameType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static DependentNameType dyn_cast_or_null_DependentNameType(Type/*P*/ From) {
    return (From != null) && isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static boolean isa_DependentNameType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentNameType.class, From.$star());
  }

  public static DependentNameType cast_DependentNameType(type$ptr<?>/*P*/ From) {
    assert isa_DependentNameType(From);
    return llvm.cast(DependentNameType.class, From.$star());
  }

  public static DependentNameType cast_or_null_DependentNameType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentNameType(From);
  }

  public static DependentNameType dyn_cast_DependentNameType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static DependentNameType dyn_cast_or_null_DependentNameType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static boolean isa_DependentNameType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentNameType.class, From.$deref());
  }

  public static DependentNameType cast_DependentNameType(type$ref<?>/*P*/ From) {
    assert isa_DependentNameType(From);
    return llvm.cast(DependentNameType.class, From.$deref());
  }

  public static DependentNameType cast_or_null_DependentNameType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentNameType(From);
  }

  public static DependentNameType dyn_cast_DependentNameType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static DependentNameType dyn_cast_or_null_DependentNameType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static boolean isa_DependentNameType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType cast_DependentNameType(QualType/*P*/ From) {
    return cast_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType cast_or_null_DependentNameType(QualType/*P*/ From) {
    return cast_or_null_DependentNameType(From.getTypePtr());
  }

  public static DependentNameType dyn_cast_DependentNameType(QualType/*P*/ From) {
    return isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static DependentNameType dyn_cast_or_null_DependentNameType(QualType/*P*/ From) {
    return (From != null) && isa_DependentNameType(From) ? cast_DependentNameType(From) : null;
  }

  public static boolean isa_DependentSizedArrayType(Type/*P*/ From) {
    assert From != null;
    return DependentSizedArrayType.classof(From);
  }

  public static DependentSizedArrayType cast_DependentSizedArrayType(Type/*P*/ From) {
    assert isa_DependentSizedArrayType(From);
    return (DependentSizedArrayType) From;
  }

  public static DependentSizedArrayType cast_or_null_DependentSizedArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentSizedArrayType(From);
  }

  public static DependentSizedArrayType dyn_cast_DependentSizedArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static DependentSizedArrayType dyn_cast_or_null_DependentSizedArrayType(Type/*P*/ From) {
    return (From != null) && isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static boolean isa_DependentSizedArrayType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType cast_DependentSizedArrayType(QualType/*P*/ From) {
    return cast_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType cast_or_null_DependentSizedArrayType(QualType/*P*/ From) {
    return cast_or_null_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType dyn_cast_DependentSizedArrayType(QualType/*P*/ From) {
    return isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static DependentSizedArrayType dyn_cast_or_null_DependentSizedArrayType(QualType/*P*/ From) {
    return (From != null) && isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static boolean isa_DependentSizedArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentSizedArrayType.class, From.$deref());
  }

  public static DependentSizedArrayType cast_DependentSizedArrayType(type$ref<?>/*P*/ From) {
    assert isa_DependentSizedArrayType(From);
    return llvm.cast(DependentSizedArrayType.class, From.$deref());
  }

  public static DependentSizedArrayType cast_or_null_DependentSizedArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentSizedArrayType(From);
  }

  public static DependentSizedArrayType dyn_cast_DependentSizedArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static DependentSizedArrayType dyn_cast_or_null_DependentSizedArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static boolean isa_DependentSizedArrayType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType cast_DependentSizedArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType cast_or_null_DependentSizedArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentSizedArrayType(From.getTypePtr());
  }

  public static DependentSizedArrayType dyn_cast_DependentSizedArrayType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static DependentSizedArrayType dyn_cast_or_null_DependentSizedArrayType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static boolean isa_DependentSizedArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentSizedArrayType.class, From.$star());
  }

  public static DependentSizedArrayType cast_DependentSizedArrayType(type$ptr<?>/*P*/ From) {
    assert isa_DependentSizedArrayType(From);
    return llvm.cast(DependentSizedArrayType.class, From.$star());
  }

  public static DependentSizedArrayType cast_or_null_DependentSizedArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentSizedArrayType(From);
  }

  public static DependentSizedArrayType dyn_cast_DependentSizedArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static DependentSizedArrayType dyn_cast_or_null_DependentSizedArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentSizedArrayType(From) ? cast_DependentSizedArrayType(From) : null;
  }

  public static boolean isa_DependentSizedExtVectorType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType cast_DependentSizedExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType cast_or_null_DependentSizedExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType dyn_cast_DependentSizedExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static DependentSizedExtVectorType dyn_cast_or_null_DependentSizedExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static boolean isa_DependentSizedExtVectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentSizedExtVectorType.class, From.$star());
  }

  public static DependentSizedExtVectorType cast_DependentSizedExtVectorType(type$ptr<?>/*P*/ From) {
    assert isa_DependentSizedExtVectorType(From);
    return llvm.cast(DependentSizedExtVectorType.class, From.$star());
  }

  public static DependentSizedExtVectorType cast_or_null_DependentSizedExtVectorType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentSizedExtVectorType(From);
  }

  public static DependentSizedExtVectorType dyn_cast_DependentSizedExtVectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static DependentSizedExtVectorType dyn_cast_or_null_DependentSizedExtVectorType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static boolean isa_DependentSizedExtVectorType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType cast_DependentSizedExtVectorType(QualType/*P*/ From) {
    return cast_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType cast_or_null_DependentSizedExtVectorType(QualType/*P*/ From) {
    return cast_or_null_DependentSizedExtVectorType(From.getTypePtr());
  }

  public static DependentSizedExtVectorType dyn_cast_DependentSizedExtVectorType(QualType/*P*/ From) {
    return isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static DependentSizedExtVectorType dyn_cast_or_null_DependentSizedExtVectorType(QualType/*P*/ From) {
    return (From != null) && isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static boolean isa_DependentSizedExtVectorType(Type/*P*/ From) {
    assert From != null;
    return DependentSizedExtVectorType.classof(From);
  }

  public static DependentSizedExtVectorType cast_DependentSizedExtVectorType(Type/*P*/ From) {
    assert isa_DependentSizedExtVectorType(From);
    return (DependentSizedExtVectorType) From;
  }

  public static DependentSizedExtVectorType cast_or_null_DependentSizedExtVectorType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentSizedExtVectorType(From);
  }

  public static DependentSizedExtVectorType dyn_cast_DependentSizedExtVectorType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static DependentSizedExtVectorType dyn_cast_or_null_DependentSizedExtVectorType(Type/*P*/ From) {
    return (From != null) && isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static boolean isa_DependentSizedExtVectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentSizedExtVectorType.class, From.$deref());
  }

  public static DependentSizedExtVectorType cast_DependentSizedExtVectorType(type$ref<?>/*P*/ From) {
    assert isa_DependentSizedExtVectorType(From);
    return llvm.cast(DependentSizedExtVectorType.class, From.$deref());
  }

  public static DependentSizedExtVectorType cast_or_null_DependentSizedExtVectorType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentSizedExtVectorType(From);
  }

  public static DependentSizedExtVectorType dyn_cast_DependentSizedExtVectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static DependentSizedExtVectorType dyn_cast_or_null_DependentSizedExtVectorType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentSizedExtVectorType(From) ? cast_DependentSizedExtVectorType(From) : null;
  }

  public static boolean isa_DependentTemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentTemplateSpecializationType.class, From.$deref());
  }

  public static DependentTemplateSpecializationType cast_DependentTemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert isa_DependentTemplateSpecializationType(From);
    return llvm.cast(DependentTemplateSpecializationType.class, From.$deref());
  }

  public static DependentTemplateSpecializationType cast_or_null_DependentTemplateSpecializationType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentTemplateSpecializationType(From);
  }

  public static DependentTemplateSpecializationType dyn_cast_DependentTemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static DependentTemplateSpecializationType dyn_cast_or_null_DependentTemplateSpecializationType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static boolean isa_DependentTemplateSpecializationType(Type/*P*/ From) {
    assert From != null;
    return DependentTemplateSpecializationType.classof(From);
  }

  public static DependentTemplateSpecializationType cast_DependentTemplateSpecializationType(Type/*P*/ From) {
    assert isa_DependentTemplateSpecializationType(From);
    return (DependentTemplateSpecializationType) From;
  }

  public static DependentTemplateSpecializationType cast_or_null_DependentTemplateSpecializationType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentTemplateSpecializationType(From);
  }

  public static DependentTemplateSpecializationType dyn_cast_DependentTemplateSpecializationType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static DependentTemplateSpecializationType dyn_cast_or_null_DependentTemplateSpecializationType(Type/*P*/ From) {
    return (From != null) && isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static boolean isa_DependentTemplateSpecializationType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType cast_DependentTemplateSpecializationType(QualType/*P*/ From) {
    return cast_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType cast_or_null_DependentTemplateSpecializationType(QualType/*P*/ From) {
    return cast_or_null_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType dyn_cast_DependentTemplateSpecializationType(QualType/*P*/ From) {
    return isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static DependentTemplateSpecializationType dyn_cast_or_null_DependentTemplateSpecializationType(QualType/*P*/ From) {
    return (From != null) && isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static boolean isa_DependentTemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType cast_DependentTemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType cast_or_null_DependentTemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentTemplateSpecializationType(From.getTypePtr());
  }

  public static DependentTemplateSpecializationType dyn_cast_DependentTemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static DependentTemplateSpecializationType dyn_cast_or_null_DependentTemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static boolean isa_DependentTemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentTemplateSpecializationType.class, From.$star());
  }

  public static DependentTemplateSpecializationType cast_DependentTemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert isa_DependentTemplateSpecializationType(From);
    return llvm.cast(DependentTemplateSpecializationType.class, From.$star());
  }

  public static DependentTemplateSpecializationType cast_or_null_DependentTemplateSpecializationType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentTemplateSpecializationType(From);
  }

  public static DependentTemplateSpecializationType dyn_cast_DependentTemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static DependentTemplateSpecializationType dyn_cast_or_null_DependentTemplateSpecializationType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentTemplateSpecializationType(From) ? cast_DependentTemplateSpecializationType(From) : null;
  }

  public static boolean isa_DependentTypeOfExprType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentTypeOfExprType.class, From.$deref());
  }

  public static DependentTypeOfExprType cast_DependentTypeOfExprType(type$ref<?>/*P*/ From) {
    assert isa_DependentTypeOfExprType(From);
    return llvm.cast(DependentTypeOfExprType.class, From.$deref());
  }

  public static DependentTypeOfExprType cast_or_null_DependentTypeOfExprType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentTypeOfExprType(From);
  }

  public static DependentTypeOfExprType dyn_cast_DependentTypeOfExprType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static DependentTypeOfExprType dyn_cast_or_null_DependentTypeOfExprType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static boolean isa_DependentTypeOfExprType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType cast_DependentTypeOfExprType(QualType/*P*/ From) {
    return cast_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType cast_or_null_DependentTypeOfExprType(QualType/*P*/ From) {
    return cast_or_null_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType dyn_cast_DependentTypeOfExprType(QualType/*P*/ From) {
    return isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static DependentTypeOfExprType dyn_cast_or_null_DependentTypeOfExprType(QualType/*P*/ From) {
    return (From != null) && isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static boolean isa_DependentTypeOfExprType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentTypeOfExprType.class, From.$star());
  }

  public static DependentTypeOfExprType cast_DependentTypeOfExprType(type$ptr<?>/*P*/ From) {
    assert isa_DependentTypeOfExprType(From);
    return llvm.cast(DependentTypeOfExprType.class, From.$star());
  }

  public static DependentTypeOfExprType cast_or_null_DependentTypeOfExprType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentTypeOfExprType(From);
  }

  public static DependentTypeOfExprType dyn_cast_DependentTypeOfExprType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static DependentTypeOfExprType dyn_cast_or_null_DependentTypeOfExprType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static boolean isa_DependentTypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType cast_DependentTypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType cast_or_null_DependentTypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentTypeOfExprType(From.getTypePtr());
  }

  public static DependentTypeOfExprType dyn_cast_DependentTypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static DependentTypeOfExprType dyn_cast_or_null_DependentTypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static boolean isa_DependentTypeOfExprType(Type/*P*/ From) {
    assert From != null;
    return DependentTypeOfExprType.classof(From);
  }

  public static DependentTypeOfExprType cast_DependentTypeOfExprType(Type/*P*/ From) {
    assert isa_DependentTypeOfExprType(From);
    return (DependentTypeOfExprType) From;
  }

  public static DependentTypeOfExprType cast_or_null_DependentTypeOfExprType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentTypeOfExprType(From);
  }

  public static DependentTypeOfExprType dyn_cast_DependentTypeOfExprType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static DependentTypeOfExprType dyn_cast_or_null_DependentTypeOfExprType(Type/*P*/ From) {
    return (From != null) && isa_DependentTypeOfExprType(From) ? cast_DependentTypeOfExprType(From) : null;
  }

  public static boolean isa_DependentUnaryTransformType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentUnaryTransformType.class, From.$deref());
  }

  public static DependentUnaryTransformType cast_DependentUnaryTransformType(type$ref<?>/*P*/ From) {
    assert isa_DependentUnaryTransformType(From);
    return llvm.cast(DependentUnaryTransformType.class, From.$deref());
  }

  public static DependentUnaryTransformType cast_or_null_DependentUnaryTransformType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentUnaryTransformType(From);
  }

  public static DependentUnaryTransformType dyn_cast_DependentUnaryTransformType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static DependentUnaryTransformType dyn_cast_or_null_DependentUnaryTransformType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static boolean isa_DependentUnaryTransformType(Type/*P*/ From) {
    assert From != null;
    return DependentUnaryTransformType.classof(From);
  }

  public static DependentUnaryTransformType cast_DependentUnaryTransformType(Type/*P*/ From) {
    assert isa_DependentUnaryTransformType(From);
    return (DependentUnaryTransformType) From;
  }

  public static DependentUnaryTransformType cast_or_null_DependentUnaryTransformType(Type/*P*/ From) {
    return (From == null) ? null : cast_DependentUnaryTransformType(From);
  }

  public static DependentUnaryTransformType dyn_cast_DependentUnaryTransformType(Type/*P*/ From) {
    assert From != null;
    return isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static DependentUnaryTransformType dyn_cast_or_null_DependentUnaryTransformType(Type/*P*/ From) {
    return (From != null) && isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static boolean isa_DependentUnaryTransformType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType cast_DependentUnaryTransformType(QualType/*P*/ From) {
    return cast_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType cast_or_null_DependentUnaryTransformType(QualType/*P*/ From) {
    return cast_or_null_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType dyn_cast_DependentUnaryTransformType(QualType/*P*/ From) {
    return isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static DependentUnaryTransformType dyn_cast_or_null_DependentUnaryTransformType(QualType/*P*/ From) {
    return (From != null) && isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static boolean isa_DependentUnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType cast_DependentUnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return cast_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType cast_or_null_DependentUnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_DependentUnaryTransformType(From.getTypePtr());
  }

  public static DependentUnaryTransformType dyn_cast_DependentUnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static DependentUnaryTransformType dyn_cast_or_null_DependentUnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static boolean isa_DependentUnaryTransformType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentUnaryTransformType.class, From.$star());
  }

  public static DependentUnaryTransformType cast_DependentUnaryTransformType(type$ptr<?>/*P*/ From) {
    assert isa_DependentUnaryTransformType(From);
    return llvm.cast(DependentUnaryTransformType.class, From.$star());
  }

  public static DependentUnaryTransformType cast_or_null_DependentUnaryTransformType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentUnaryTransformType(From);
  }

  public static DependentUnaryTransformType dyn_cast_DependentUnaryTransformType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static DependentUnaryTransformType dyn_cast_or_null_DependentUnaryTransformType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentUnaryTransformType(From) ? cast_DependentUnaryTransformType(From) : null;
  }

  public static boolean isa_ElaboratedType(Type/*P*/ From) {
    assert From != null;
    return ElaboratedType.classof(From);
  }

  public static ElaboratedType cast_ElaboratedType(Type/*P*/ From) {
    assert isa_ElaboratedType(From);
    return (ElaboratedType) From;
  }

  public static ElaboratedType cast_or_null_ElaboratedType(Type/*P*/ From) {
    return (From == null) ? null : cast_ElaboratedType(From);
  }

  public static ElaboratedType dyn_cast_ElaboratedType(Type/*P*/ From) {
    assert From != null;
    return isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static ElaboratedType dyn_cast_or_null_ElaboratedType(Type/*P*/ From) {
    return (From != null) && isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static boolean isa_ElaboratedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ElaboratedType.class, From.$star());
  }

  public static ElaboratedType cast_ElaboratedType(type$ptr<?>/*P*/ From) {
    assert isa_ElaboratedType(From);
    return llvm.cast(ElaboratedType.class, From.$star());
  }

  public static ElaboratedType cast_or_null_ElaboratedType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ElaboratedType(From);
  }

  public static ElaboratedType dyn_cast_ElaboratedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static ElaboratedType dyn_cast_or_null_ElaboratedType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static boolean isa_ElaboratedType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType cast_ElaboratedType(CanQual<? extends Type>/*P*/ From) {
    return cast_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType cast_or_null_ElaboratedType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType dyn_cast_ElaboratedType(CanQual<? extends Type>/*P*/ From) {
    return isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static ElaboratedType dyn_cast_or_null_ElaboratedType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static boolean isa_ElaboratedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ElaboratedType.class, From.$deref());
  }

  public static ElaboratedType cast_ElaboratedType(type$ref<?>/*P*/ From) {
    assert isa_ElaboratedType(From);
    return llvm.cast(ElaboratedType.class, From.$deref());
  }

  public static ElaboratedType cast_or_null_ElaboratedType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ElaboratedType(From);
  }

  public static ElaboratedType dyn_cast_ElaboratedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static ElaboratedType dyn_cast_or_null_ElaboratedType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static boolean isa_ElaboratedType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType cast_ElaboratedType(QualType/*P*/ From) {
    return cast_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType cast_or_null_ElaboratedType(QualType/*P*/ From) {
    return cast_or_null_ElaboratedType(From.getTypePtr());
  }

  public static ElaboratedType dyn_cast_ElaboratedType(QualType/*P*/ From) {
    return isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static ElaboratedType dyn_cast_or_null_ElaboratedType(QualType/*P*/ From) {
    return (From != null) && isa_ElaboratedType(From) ? cast_ElaboratedType(From) : null;
  }

  public static boolean isa_EnumType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_EnumType(From.getTypePtr());
  }

  public static EnumType cast_EnumType(QualType/*P*/ From) {
    return cast_EnumType(From.getTypePtr());
  }

  public static EnumType cast_or_null_EnumType(QualType/*P*/ From) {
    return cast_or_null_EnumType(From.getTypePtr());
  }

  public static EnumType dyn_cast_EnumType(QualType/*P*/ From) {
    return isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static EnumType dyn_cast_or_null_EnumType(QualType/*P*/ From) {
    return (From != null) && isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static boolean isa_EnumType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EnumType.class, From.$deref());
  }

  public static EnumType cast_EnumType(type$ref<?>/*P*/ From) {
    assert isa_EnumType(From);
    return llvm.cast(EnumType.class, From.$deref());
  }

  public static EnumType cast_or_null_EnumType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EnumType(From);
  }

  public static EnumType dyn_cast_EnumType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static EnumType dyn_cast_or_null_EnumType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static boolean isa_EnumType(Type/*P*/ From) {
    assert From != null;
    return EnumType.classof(From);
  }

  public static EnumType cast_EnumType(Type/*P*/ From) {
    assert isa_EnumType(From);
    return (EnumType) From;
  }

  public static EnumType cast_or_null_EnumType(Type/*P*/ From) {
    return (From == null) ? null : cast_EnumType(From);
  }

  public static EnumType dyn_cast_EnumType(Type/*P*/ From) {
    assert From != null;
    return isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static EnumType dyn_cast_or_null_EnumType(Type/*P*/ From) {
    return (From != null) && isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static boolean isa_EnumType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_EnumType(From.getTypePtr());
  }

  public static EnumType cast_EnumType(CanQual<? extends Type>/*P*/ From) {
    return cast_EnumType(From.getTypePtr());
  }

  public static EnumType cast_or_null_EnumType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_EnumType(From.getTypePtr());
  }

  public static EnumType dyn_cast_EnumType(CanQual<? extends Type>/*P*/ From) {
    return isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static EnumType dyn_cast_or_null_EnumType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static boolean isa_EnumType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EnumType.class, From.$star());
  }

  public static EnumType cast_EnumType(type$ptr<?>/*P*/ From) {
    assert isa_EnumType(From);
    return llvm.cast(EnumType.class, From.$star());
  }

  public static EnumType cast_or_null_EnumType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EnumType(From);
  }

  public static EnumType dyn_cast_EnumType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static EnumType dyn_cast_or_null_EnumType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EnumType(From) ? cast_EnumType(From) : null;
  }

  public static boolean isa_ExtVectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtVectorType.class, From.$deref());
  }

  public static ExtVectorType cast_ExtVectorType(type$ref<?>/*P*/ From) {
    assert isa_ExtVectorType(From);
    return llvm.cast(ExtVectorType.class, From.$deref());
  }

  public static ExtVectorType cast_or_null_ExtVectorType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtVectorType(From);
  }

  public static ExtVectorType dyn_cast_ExtVectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static ExtVectorType dyn_cast_or_null_ExtVectorType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static boolean isa_ExtVectorType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType cast_ExtVectorType(QualType/*P*/ From) {
    return cast_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType cast_or_null_ExtVectorType(QualType/*P*/ From) {
    return cast_or_null_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType dyn_cast_ExtVectorType(QualType/*P*/ From) {
    return isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static ExtVectorType dyn_cast_or_null_ExtVectorType(QualType/*P*/ From) {
    return (From != null) && isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static boolean isa_ExtVectorType(Type/*P*/ From) {
    assert From != null;
    return ExtVectorType.classof(From);
  }

  public static ExtVectorType cast_ExtVectorType(Type/*P*/ From) {
    assert isa_ExtVectorType(From);
    return (ExtVectorType) From;
  }

  public static ExtVectorType cast_or_null_ExtVectorType(Type/*P*/ From) {
    return (From == null) ? null : cast_ExtVectorType(From);
  }

  public static ExtVectorType dyn_cast_ExtVectorType(Type/*P*/ From) {
    assert From != null;
    return isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static ExtVectorType dyn_cast_or_null_ExtVectorType(Type/*P*/ From) {
    return (From != null) && isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static boolean isa_ExtVectorType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType cast_ExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType cast_or_null_ExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ExtVectorType(From.getTypePtr());
  }

  public static ExtVectorType dyn_cast_ExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static ExtVectorType dyn_cast_or_null_ExtVectorType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static boolean isa_ExtVectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtVectorType.class, From.$star());
  }

  public static ExtVectorType cast_ExtVectorType(type$ptr<?>/*P*/ From) {
    assert isa_ExtVectorType(From);
    return llvm.cast(ExtVectorType.class, From.$star());
  }

  public static ExtVectorType cast_or_null_ExtVectorType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtVectorType(From);
  }

  public static ExtVectorType dyn_cast_ExtVectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static ExtVectorType dyn_cast_or_null_ExtVectorType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtVectorType(From) ? cast_ExtVectorType(From) : null;
  }

  public static boolean isa_FunctionNoProtoType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType cast_FunctionNoProtoType(QualType/*P*/ From) {
    return cast_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType cast_or_null_FunctionNoProtoType(QualType/*P*/ From) {
    return cast_or_null_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType dyn_cast_FunctionNoProtoType(QualType/*P*/ From) {
    return isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static FunctionNoProtoType dyn_cast_or_null_FunctionNoProtoType(QualType/*P*/ From) {
    return (From != null) && isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static boolean isa_FunctionNoProtoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionNoProtoType.class, From.$star());
  }

  public static FunctionNoProtoType cast_FunctionNoProtoType(type$ptr<?>/*P*/ From) {
    assert isa_FunctionNoProtoType(From);
    return llvm.cast(FunctionNoProtoType.class, From.$star());
  }

  public static FunctionNoProtoType cast_or_null_FunctionNoProtoType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionNoProtoType(From);
  }

  public static FunctionNoProtoType dyn_cast_FunctionNoProtoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static FunctionNoProtoType dyn_cast_or_null_FunctionNoProtoType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static boolean isa_FunctionNoProtoType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType cast_FunctionNoProtoType(CanQual<? extends Type>/*P*/ From) {
    return cast_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType cast_or_null_FunctionNoProtoType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_FunctionNoProtoType(From.getTypePtr());
  }

  public static FunctionNoProtoType dyn_cast_FunctionNoProtoType(CanQual<? extends Type>/*P*/ From) {
    return isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static FunctionNoProtoType dyn_cast_or_null_FunctionNoProtoType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static boolean isa_FunctionNoProtoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionNoProtoType.class, From.$deref());
  }

  public static FunctionNoProtoType cast_FunctionNoProtoType(type$ref<?>/*P*/ From) {
    assert isa_FunctionNoProtoType(From);
    return llvm.cast(FunctionNoProtoType.class, From.$deref());
  }

  public static FunctionNoProtoType cast_or_null_FunctionNoProtoType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionNoProtoType(From);
  }

  public static FunctionNoProtoType dyn_cast_FunctionNoProtoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static FunctionNoProtoType dyn_cast_or_null_FunctionNoProtoType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static boolean isa_FunctionNoProtoType(Type/*P*/ From) {
    assert From != null;
    return FunctionNoProtoType.classof(From);
  }

  public static FunctionNoProtoType cast_FunctionNoProtoType(Type/*P*/ From) {
    assert isa_FunctionNoProtoType(From);
    return (FunctionNoProtoType) From;
  }

  public static FunctionNoProtoType cast_or_null_FunctionNoProtoType(Type/*P*/ From) {
    return (From == null) ? null : cast_FunctionNoProtoType(From);
  }

  public static FunctionNoProtoType dyn_cast_FunctionNoProtoType(Type/*P*/ From) {
    assert From != null;
    return isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static FunctionNoProtoType dyn_cast_or_null_FunctionNoProtoType(Type/*P*/ From) {
    return (From != null) && isa_FunctionNoProtoType(From) ? cast_FunctionNoProtoType(From) : null;
  }

  public static boolean isa_FunctionProtoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionProtoType.class, From.$deref());
  }

  public static FunctionProtoType cast_FunctionProtoType(type$ref<?>/*P*/ From) {
    assert isa_FunctionProtoType(From);
    return llvm.cast(FunctionProtoType.class, From.$deref());
  }

  public static FunctionProtoType cast_or_null_FunctionProtoType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionProtoType(From);
  }

  public static FunctionProtoType dyn_cast_FunctionProtoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static FunctionProtoType dyn_cast_or_null_FunctionProtoType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static boolean isa_FunctionProtoType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType cast_FunctionProtoType(CanQual<? extends Type>/*P*/ From) {
    return cast_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType cast_or_null_FunctionProtoType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType dyn_cast_FunctionProtoType(CanQual<? extends Type>/*P*/ From) {
    return isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static FunctionProtoType dyn_cast_or_null_FunctionProtoType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static boolean isa_FunctionProtoType(Type/*P*/ From) {
    assert From != null;
    return FunctionProtoType.classof(From);
  }

  public static FunctionProtoType cast_FunctionProtoType(Type/*P*/ From) {
    assert isa_FunctionProtoType(From);
    return (FunctionProtoType) From;
  }

  public static FunctionProtoType cast_or_null_FunctionProtoType(Type/*P*/ From) {
    return (From == null) ? null : cast_FunctionProtoType(From);
  }

  public static FunctionProtoType dyn_cast_FunctionProtoType(Type/*P*/ From) {
    assert From != null;
    return isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static FunctionProtoType dyn_cast_or_null_FunctionProtoType(Type/*P*/ From) {
    return (From != null) && isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static boolean isa_FunctionProtoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionProtoType.class, From.$star());
  }

  public static FunctionProtoType cast_FunctionProtoType(type$ptr<?>/*P*/ From) {
    assert isa_FunctionProtoType(From);
    return llvm.cast(FunctionProtoType.class, From.$star());
  }

  public static FunctionProtoType cast_or_null_FunctionProtoType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionProtoType(From);
  }

  public static FunctionProtoType dyn_cast_FunctionProtoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static FunctionProtoType dyn_cast_or_null_FunctionProtoType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static boolean isa_FunctionProtoType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType cast_FunctionProtoType(QualType/*P*/ From) {
    return cast_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType cast_or_null_FunctionProtoType(QualType/*P*/ From) {
    return cast_or_null_FunctionProtoType(From.getTypePtr());
  }

  public static FunctionProtoType dyn_cast_FunctionProtoType(QualType/*P*/ From) {
    return isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static FunctionProtoType dyn_cast_or_null_FunctionProtoType(QualType/*P*/ From) {
    return (From != null) && isa_FunctionProtoType(From) ? cast_FunctionProtoType(From) : null;
  }

  public static boolean isa_FunctionType(Type/*P*/ From) {
    assert From != null;
    return FunctionType.classof(From);
  }

  public static FunctionType cast_FunctionType(Type/*P*/ From) {
    assert isa_FunctionType(From);
    return (FunctionType) From;
  }

  public static FunctionType cast_or_null_FunctionType(Type/*P*/ From) {
    return (From == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(Type/*P*/ From) {
    assert From != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(Type/*P*/ From) {
    return (From != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionType(From.getTypePtr());
  }

  public static FunctionType cast_FunctionType(QualType/*P*/ From) {
    return cast_FunctionType(From.getTypePtr());
  }

  public static FunctionType cast_or_null_FunctionType(QualType/*P*/ From) {
    return cast_or_null_FunctionType(From.getTypePtr());
  }

  public static FunctionType dyn_cast_FunctionType(QualType/*P*/ From) {
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(QualType/*P*/ From) {
    return (From != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionType.class, From.$deref());
  }

  public static FunctionType cast_FunctionType(type$ref<?>/*P*/ From) {
    assert isa_FunctionType(From);
    return llvm.cast(FunctionType.class, From.$deref());
  }

  public static FunctionType cast_or_null_FunctionType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_FunctionType(From.getTypePtr());
  }

  public static FunctionType cast_FunctionType(CanQual<? extends Type>/*P*/ From) {
    return cast_FunctionType(From.getTypePtr());
  }

  public static FunctionType cast_or_null_FunctionType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_FunctionType(From.getTypePtr());
  }

  public static FunctionType dyn_cast_FunctionType(CanQual<? extends Type>/*P*/ From) {
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionType.class, From.$star());
  }

  public static FunctionType cast_FunctionType(type$ptr<?>/*P*/ From) {
    assert isa_FunctionType(From);
    return llvm.cast(FunctionType.class, From.$star());
  }

  public static FunctionType cast_or_null_FunctionType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_IncompleteArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IncompleteArrayType.class, From.$star());
  }

  public static IncompleteArrayType cast_IncompleteArrayType(type$ptr<?>/*P*/ From) {
    assert isa_IncompleteArrayType(From);
    return llvm.cast(IncompleteArrayType.class, From.$star());
  }

  public static IncompleteArrayType cast_or_null_IncompleteArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IncompleteArrayType(From);
  }

  public static IncompleteArrayType dyn_cast_IncompleteArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static IncompleteArrayType dyn_cast_or_null_IncompleteArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static boolean isa_IncompleteArrayType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType cast_IncompleteArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType cast_or_null_IncompleteArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType dyn_cast_IncompleteArrayType(CanQual<? extends Type>/*P*/ From) {
    return isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static IncompleteArrayType dyn_cast_or_null_IncompleteArrayType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static boolean isa_IncompleteArrayType(Type/*P*/ From) {
    assert From != null;
    return IncompleteArrayType.classof(From);
  }

  public static IncompleteArrayType cast_IncompleteArrayType(Type/*P*/ From) {
    assert isa_IncompleteArrayType(From);
    return (IncompleteArrayType) From;
  }

  public static IncompleteArrayType cast_or_null_IncompleteArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_IncompleteArrayType(From);
  }

  public static IncompleteArrayType dyn_cast_IncompleteArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static IncompleteArrayType dyn_cast_or_null_IncompleteArrayType(Type/*P*/ From) {
    return (From != null) && isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static boolean isa_IncompleteArrayType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType cast_IncompleteArrayType(QualType/*P*/ From) {
    return cast_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType cast_or_null_IncompleteArrayType(QualType/*P*/ From) {
    return cast_or_null_IncompleteArrayType(From.getTypePtr());
  }

  public static IncompleteArrayType dyn_cast_IncompleteArrayType(QualType/*P*/ From) {
    return isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static IncompleteArrayType dyn_cast_or_null_IncompleteArrayType(QualType/*P*/ From) {
    return (From != null) && isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static boolean isa_IncompleteArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IncompleteArrayType.class, From.$deref());
  }

  public static IncompleteArrayType cast_IncompleteArrayType(type$ref<?>/*P*/ From) {
    assert isa_IncompleteArrayType(From);
    return llvm.cast(IncompleteArrayType.class, From.$deref());
  }

  public static IncompleteArrayType cast_or_null_IncompleteArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IncompleteArrayType(From);
  }

  public static IncompleteArrayType dyn_cast_IncompleteArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static IncompleteArrayType dyn_cast_or_null_IncompleteArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IncompleteArrayType(From) ? cast_IncompleteArrayType(From) : null;
  }

  public static boolean isa_InjectedClassNameType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InjectedClassNameType.class, From.$star());
  }

  public static InjectedClassNameType cast_InjectedClassNameType(type$ptr<?>/*P*/ From) {
    assert isa_InjectedClassNameType(From);
    return llvm.cast(InjectedClassNameType.class, From.$star());
  }

  public static InjectedClassNameType cast_or_null_InjectedClassNameType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InjectedClassNameType(From);
  }

  public static InjectedClassNameType dyn_cast_InjectedClassNameType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static InjectedClassNameType dyn_cast_or_null_InjectedClassNameType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static boolean isa_InjectedClassNameType(Type/*P*/ From) {
    assert From != null;
    return InjectedClassNameType.classof(From);
  }

  public static InjectedClassNameType cast_InjectedClassNameType(Type/*P*/ From) {
    assert isa_InjectedClassNameType(From);
    return (InjectedClassNameType) From;
  }

  public static InjectedClassNameType cast_or_null_InjectedClassNameType(Type/*P*/ From) {
    return (From == null) ? null : cast_InjectedClassNameType(From);
  }

  public static InjectedClassNameType dyn_cast_InjectedClassNameType(Type/*P*/ From) {
    assert From != null;
    return isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static InjectedClassNameType dyn_cast_or_null_InjectedClassNameType(Type/*P*/ From) {
    return (From != null) && isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static boolean isa_InjectedClassNameType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType cast_InjectedClassNameType(QualType/*P*/ From) {
    return cast_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType cast_or_null_InjectedClassNameType(QualType/*P*/ From) {
    return cast_or_null_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType dyn_cast_InjectedClassNameType(QualType/*P*/ From) {
    return isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static InjectedClassNameType dyn_cast_or_null_InjectedClassNameType(QualType/*P*/ From) {
    return (From != null) && isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static boolean isa_InjectedClassNameType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType cast_InjectedClassNameType(CanQual<? extends Type>/*P*/ From) {
    return cast_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType cast_or_null_InjectedClassNameType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_InjectedClassNameType(From.getTypePtr());
  }

  public static InjectedClassNameType dyn_cast_InjectedClassNameType(CanQual<? extends Type>/*P*/ From) {
    return isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static InjectedClassNameType dyn_cast_or_null_InjectedClassNameType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static boolean isa_InjectedClassNameType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InjectedClassNameType.class, From.$deref());
  }

  public static InjectedClassNameType cast_InjectedClassNameType(type$ref<?>/*P*/ From) {
    assert isa_InjectedClassNameType(From);
    return llvm.cast(InjectedClassNameType.class, From.$deref());
  }

  public static InjectedClassNameType cast_or_null_InjectedClassNameType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InjectedClassNameType(From);
  }

  public static InjectedClassNameType dyn_cast_InjectedClassNameType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static InjectedClassNameType dyn_cast_or_null_InjectedClassNameType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InjectedClassNameType(From) ? cast_InjectedClassNameType(From) : null;
  }

  public static boolean isa_LValueReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LValueReferenceType.class, From.$deref());
  }

  public static LValueReferenceType cast_LValueReferenceType(type$ref<?>/*P*/ From) {
    assert isa_LValueReferenceType(From);
    return llvm.cast(LValueReferenceType.class, From.$deref());
  }

  public static LValueReferenceType cast_or_null_LValueReferenceType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LValueReferenceType(From);
  }

  public static LValueReferenceType dyn_cast_LValueReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static LValueReferenceType dyn_cast_or_null_LValueReferenceType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static boolean isa_LValueReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LValueReferenceType.class, From.$star());
  }

  public static LValueReferenceType cast_LValueReferenceType(type$ptr<?>/*P*/ From) {
    assert isa_LValueReferenceType(From);
    return llvm.cast(LValueReferenceType.class, From.$star());
  }

  public static LValueReferenceType cast_or_null_LValueReferenceType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LValueReferenceType(From);
  }

  public static LValueReferenceType dyn_cast_LValueReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static LValueReferenceType dyn_cast_or_null_LValueReferenceType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static boolean isa_LValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType cast_LValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType cast_or_null_LValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType dyn_cast_LValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static LValueReferenceType dyn_cast_or_null_LValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static boolean isa_LValueReferenceType(Type/*P*/ From) {
    assert From != null;
    return LValueReferenceType.classof(From);
  }

  public static LValueReferenceType cast_LValueReferenceType(Type/*P*/ From) {
    assert isa_LValueReferenceType(From);
    return (LValueReferenceType) From;
  }

  public static LValueReferenceType cast_or_null_LValueReferenceType(Type/*P*/ From) {
    return (From == null) ? null : cast_LValueReferenceType(From);
  }

  public static LValueReferenceType dyn_cast_LValueReferenceType(Type/*P*/ From) {
    assert From != null;
    return isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static LValueReferenceType dyn_cast_or_null_LValueReferenceType(Type/*P*/ From) {
    return (From != null) && isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static boolean isa_LValueReferenceType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType cast_LValueReferenceType(QualType/*P*/ From) {
    return cast_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType cast_or_null_LValueReferenceType(QualType/*P*/ From) {
    return cast_or_null_LValueReferenceType(From.getTypePtr());
  }

  public static LValueReferenceType dyn_cast_LValueReferenceType(QualType/*P*/ From) {
    return isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static LValueReferenceType dyn_cast_or_null_LValueReferenceType(QualType/*P*/ From) {
    return (From != null) && isa_LValueReferenceType(From) ? cast_LValueReferenceType(From) : null;
  }

  public static boolean isa_LocInfoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LocInfoType.class, From.$deref());
  }

  public static LocInfoType cast_LocInfoType(type$ref<?>/*P*/ From) {
    assert isa_LocInfoType(From);
    return llvm.cast(LocInfoType.class, From.$deref());
  }

  public static LocInfoType cast_or_null_LocInfoType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LocInfoType(From);
  }

  public static LocInfoType dyn_cast_LocInfoType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static LocInfoType dyn_cast_or_null_LocInfoType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static boolean isa_LocInfoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LocInfoType.class, From.$star());
  }

  public static LocInfoType cast_LocInfoType(type$ptr<?>/*P*/ From) {
    assert isa_LocInfoType(From);
    return llvm.cast(LocInfoType.class, From.$star());
  }

  public static LocInfoType cast_or_null_LocInfoType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LocInfoType(From);
  }

  public static LocInfoType dyn_cast_LocInfoType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static LocInfoType dyn_cast_or_null_LocInfoType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static boolean isa_LocInfoType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType cast_LocInfoType(QualType/*P*/ From) {
    return cast_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType cast_or_null_LocInfoType(QualType/*P*/ From) {
    return cast_or_null_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType dyn_cast_LocInfoType(QualType/*P*/ From) {
    return isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static LocInfoType dyn_cast_or_null_LocInfoType(QualType/*P*/ From) {
    return (From != null) && isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static boolean isa_LocInfoType(Type/*P*/ From) {
    assert From != null;
    return LocInfoType.classof(From);
  }

  public static LocInfoType cast_LocInfoType(Type/*P*/ From) {
    assert isa_LocInfoType(From);
    return (LocInfoType) From;
  }

  public static LocInfoType cast_or_null_LocInfoType(Type/*P*/ From) {
    return (From == null) ? null : cast_LocInfoType(From);
  }

  public static LocInfoType dyn_cast_LocInfoType(Type/*P*/ From) {
    assert From != null;
    return isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static LocInfoType dyn_cast_or_null_LocInfoType(Type/*P*/ From) {
    return (From != null) && isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static boolean isa_LocInfoType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType cast_LocInfoType(CanQual<? extends Type>/*P*/ From) {
    return cast_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType cast_or_null_LocInfoType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_LocInfoType(From.getTypePtr());
  }

  public static LocInfoType dyn_cast_LocInfoType(CanQual<? extends Type>/*P*/ From) {
    return isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static LocInfoType dyn_cast_or_null_LocInfoType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_LocInfoType(From) ? cast_LocInfoType(From) : null;
  }

  public static boolean isa_MemberPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemberPointerType.class, From.$star());
  }

  public static MemberPointerType cast_MemberPointerType(type$ptr<?>/*P*/ From) {
    assert isa_MemberPointerType(From);
    return llvm.cast(MemberPointerType.class, From.$star());
  }

  public static MemberPointerType cast_or_null_MemberPointerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemberPointerType(From);
  }

  public static MemberPointerType dyn_cast_MemberPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static MemberPointerType dyn_cast_or_null_MemberPointerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static boolean isa_MemberPointerType(Type/*P*/ From) {
    assert From != null;
    return MemberPointerType.classof(From);
  }

  public static MemberPointerType cast_MemberPointerType(Type/*P*/ From) {
    assert isa_MemberPointerType(From);
    return (MemberPointerType) From;
  }

  public static MemberPointerType cast_or_null_MemberPointerType(Type/*P*/ From) {
    return (From == null) ? null : cast_MemberPointerType(From);
  }

  public static MemberPointerType dyn_cast_MemberPointerType(Type/*P*/ From) {
    assert From != null;
    return isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static MemberPointerType dyn_cast_or_null_MemberPointerType(Type/*P*/ From) {
    return (From != null) && isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static boolean isa_MemberPointerType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType cast_MemberPointerType(QualType/*P*/ From) {
    return cast_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType cast_or_null_MemberPointerType(QualType/*P*/ From) {
    return cast_or_null_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType dyn_cast_MemberPointerType(QualType/*P*/ From) {
    return isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static MemberPointerType dyn_cast_or_null_MemberPointerType(QualType/*P*/ From) {
    return (From != null) && isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static boolean isa_MemberPointerType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType cast_MemberPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType cast_or_null_MemberPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_MemberPointerType(From.getTypePtr());
  }

  public static MemberPointerType dyn_cast_MemberPointerType(CanQual<? extends Type>/*P*/ From) {
    return isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static MemberPointerType dyn_cast_or_null_MemberPointerType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static boolean isa_MemberPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemberPointerType.class, From.$deref());
  }

  public static MemberPointerType cast_MemberPointerType(type$ref<?>/*P*/ From) {
    assert isa_MemberPointerType(From);
    return llvm.cast(MemberPointerType.class, From.$deref());
  }

  public static MemberPointerType cast_or_null_MemberPointerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemberPointerType(From);
  }

  public static MemberPointerType dyn_cast_MemberPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static MemberPointerType dyn_cast_or_null_MemberPointerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemberPointerType(From) ? cast_MemberPointerType(From) : null;
  }

  public static boolean isa_ObjCInterfaceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCInterfaceType.class, From.$deref());
  }

  public static ObjCInterfaceType cast_ObjCInterfaceType(type$ref<?>/*P*/ From) {
    assert isa_ObjCInterfaceType(From);
    return llvm.cast(ObjCInterfaceType.class, From.$deref());
  }

  public static ObjCInterfaceType cast_or_null_ObjCInterfaceType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCInterfaceType(From);
  }

  public static ObjCInterfaceType dyn_cast_ObjCInterfaceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static ObjCInterfaceType dyn_cast_or_null_ObjCInterfaceType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static boolean isa_ObjCInterfaceType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType cast_ObjCInterfaceType(QualType/*P*/ From) {
    return cast_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType cast_or_null_ObjCInterfaceType(QualType/*P*/ From) {
    return cast_or_null_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType dyn_cast_ObjCInterfaceType(QualType/*P*/ From) {
    return isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static ObjCInterfaceType dyn_cast_or_null_ObjCInterfaceType(QualType/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static boolean isa_ObjCInterfaceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCInterfaceType.class, From.$star());
  }

  public static ObjCInterfaceType cast_ObjCInterfaceType(type$ptr<?>/*P*/ From) {
    assert isa_ObjCInterfaceType(From);
    return llvm.cast(ObjCInterfaceType.class, From.$star());
  }

  public static ObjCInterfaceType cast_or_null_ObjCInterfaceType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCInterfaceType(From);
  }

  public static ObjCInterfaceType dyn_cast_ObjCInterfaceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static ObjCInterfaceType dyn_cast_or_null_ObjCInterfaceType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static boolean isa_ObjCInterfaceType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType cast_ObjCInterfaceType(CanQual<? extends Type>/*P*/ From) {
    return cast_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType cast_or_null_ObjCInterfaceType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ObjCInterfaceType(From.getTypePtr());
  }

  public static ObjCInterfaceType dyn_cast_ObjCInterfaceType(CanQual<? extends Type>/*P*/ From) {
    return isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static ObjCInterfaceType dyn_cast_or_null_ObjCInterfaceType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static boolean isa_ObjCInterfaceType(Type/*P*/ From) {
    assert From != null;
    return ObjCInterfaceType.classof(From);
  }

  public static ObjCInterfaceType cast_ObjCInterfaceType(Type/*P*/ From) {
    assert isa_ObjCInterfaceType(From);
    return (ObjCInterfaceType) From;
  }

  public static ObjCInterfaceType cast_or_null_ObjCInterfaceType(Type/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceType(From);
  }

  public static ObjCInterfaceType dyn_cast_ObjCInterfaceType(Type/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static ObjCInterfaceType dyn_cast_or_null_ObjCInterfaceType(Type/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceType(From) ? cast_ObjCInterfaceType(From) : null;
  }

  public static boolean isa_ObjCObjectPointerType(Type/*P*/ From) {
    assert From != null;
    return ObjCObjectPointerType.classof(From);
  }

  public static ObjCObjectPointerType cast_ObjCObjectPointerType(Type/*P*/ From) {
    assert isa_ObjCObjectPointerType(From);
    return (ObjCObjectPointerType) From;
  }

  public static ObjCObjectPointerType cast_or_null_ObjCObjectPointerType(Type/*P*/ From) {
    return (From == null) ? null : cast_ObjCObjectPointerType(From);
  }

  public static ObjCObjectPointerType dyn_cast_ObjCObjectPointerType(Type/*P*/ From) {
    assert From != null;
    return isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static ObjCObjectPointerType dyn_cast_or_null_ObjCObjectPointerType(Type/*P*/ From) {
    return (From != null) && isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static boolean isa_ObjCObjectPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCObjectPointerType.class, From.$star());
  }

  public static ObjCObjectPointerType cast_ObjCObjectPointerType(type$ptr<?>/*P*/ From) {
    assert isa_ObjCObjectPointerType(From);
    return llvm.cast(ObjCObjectPointerType.class, From.$star());
  }

  public static ObjCObjectPointerType cast_or_null_ObjCObjectPointerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCObjectPointerType(From);
  }

  public static ObjCObjectPointerType dyn_cast_ObjCObjectPointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static ObjCObjectPointerType dyn_cast_or_null_ObjCObjectPointerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static boolean isa_ObjCObjectPointerType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType cast_ObjCObjectPointerType(QualType/*P*/ From) {
    return cast_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType cast_or_null_ObjCObjectPointerType(QualType/*P*/ From) {
    return cast_or_null_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType dyn_cast_ObjCObjectPointerType(QualType/*P*/ From) {
    return isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static ObjCObjectPointerType dyn_cast_or_null_ObjCObjectPointerType(QualType/*P*/ From) {
    return (From != null) && isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static boolean isa_ObjCObjectPointerType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType cast_ObjCObjectPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType cast_or_null_ObjCObjectPointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ObjCObjectPointerType(From.getTypePtr());
  }

  public static ObjCObjectPointerType dyn_cast_ObjCObjectPointerType(CanQual<? extends Type>/*P*/ From) {
    return isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static ObjCObjectPointerType dyn_cast_or_null_ObjCObjectPointerType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static boolean isa_ObjCObjectPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCObjectPointerType.class, From.$deref());
  }

  public static ObjCObjectPointerType cast_ObjCObjectPointerType(type$ref<?>/*P*/ From) {
    assert isa_ObjCObjectPointerType(From);
    return llvm.cast(ObjCObjectPointerType.class, From.$deref());
  }

  public static ObjCObjectPointerType cast_or_null_ObjCObjectPointerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCObjectPointerType(From);
  }

  public static ObjCObjectPointerType dyn_cast_ObjCObjectPointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static ObjCObjectPointerType dyn_cast_or_null_ObjCObjectPointerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCObjectPointerType(From) ? cast_ObjCObjectPointerType(From) : null;
  }

  public static boolean isa_ObjCObjectType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType cast_ObjCObjectType(CanQual<? extends Type>/*P*/ From) {
    return cast_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType cast_or_null_ObjCObjectType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType dyn_cast_ObjCObjectType(CanQual<? extends Type>/*P*/ From) {
    return isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static ObjCObjectType dyn_cast_or_null_ObjCObjectType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static boolean isa_ObjCObjectType(Type/*P*/ From) {
    assert From != null;
    return ObjCObjectType.classof(From);
  }

  public static ObjCObjectType cast_ObjCObjectType(Type/*P*/ From) {
    assert isa_ObjCObjectType(From);
    return (ObjCObjectType) From;
  }

  public static ObjCObjectType cast_or_null_ObjCObjectType(Type/*P*/ From) {
    return (From == null) ? null : cast_ObjCObjectType(From);
  }

  public static ObjCObjectType dyn_cast_ObjCObjectType(Type/*P*/ From) {
    assert From != null;
    return isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static ObjCObjectType dyn_cast_or_null_ObjCObjectType(Type/*P*/ From) {
    return (From != null) && isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static boolean isa_ObjCObjectType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType cast_ObjCObjectType(QualType/*P*/ From) {
    return cast_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType cast_or_null_ObjCObjectType(QualType/*P*/ From) {
    return cast_or_null_ObjCObjectType(From.getTypePtr());
  }

  public static ObjCObjectType dyn_cast_ObjCObjectType(QualType/*P*/ From) {
    return isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static ObjCObjectType dyn_cast_or_null_ObjCObjectType(QualType/*P*/ From) {
    return (From != null) && isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static boolean isa_ObjCObjectType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCObjectType.class, From.$star());
  }

  public static ObjCObjectType cast_ObjCObjectType(type$ptr<?>/*P*/ From) {
    assert isa_ObjCObjectType(From);
    return llvm.cast(ObjCObjectType.class, From.$star());
  }

  public static ObjCObjectType cast_or_null_ObjCObjectType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCObjectType(From);
  }

  public static ObjCObjectType dyn_cast_ObjCObjectType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static ObjCObjectType dyn_cast_or_null_ObjCObjectType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static boolean isa_ObjCObjectType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCObjectType.class, From.$deref());
  }

  public static ObjCObjectType cast_ObjCObjectType(type$ref<?>/*P*/ From) {
    assert isa_ObjCObjectType(From);
    return llvm.cast(ObjCObjectType.class, From.$deref());
  }

  public static ObjCObjectType cast_or_null_ObjCObjectType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCObjectType(From);
  }

  public static ObjCObjectType dyn_cast_ObjCObjectType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static ObjCObjectType dyn_cast_or_null_ObjCObjectType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCObjectType(From) ? cast_ObjCObjectType(From) : null;
  }

  public static boolean isa_PackExpansionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PackExpansionType.class, From.$deref());
  }

  public static PackExpansionType cast_PackExpansionType(type$ref<?>/*P*/ From) {
    assert isa_PackExpansionType(From);
    return llvm.cast(PackExpansionType.class, From.$deref());
  }

  public static PackExpansionType cast_or_null_PackExpansionType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PackExpansionType(From);
  }

  public static PackExpansionType dyn_cast_PackExpansionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static PackExpansionType dyn_cast_or_null_PackExpansionType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static boolean isa_PackExpansionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PackExpansionType.class, From.$star());
  }

  public static PackExpansionType cast_PackExpansionType(type$ptr<?>/*P*/ From) {
    assert isa_PackExpansionType(From);
    return llvm.cast(PackExpansionType.class, From.$star());
  }

  public static PackExpansionType cast_or_null_PackExpansionType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PackExpansionType(From);
  }

  public static PackExpansionType dyn_cast_PackExpansionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static PackExpansionType dyn_cast_or_null_PackExpansionType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static boolean isa_PackExpansionType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType cast_PackExpansionType(CanQual<? extends Type>/*P*/ From) {
    return cast_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType cast_or_null_PackExpansionType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType dyn_cast_PackExpansionType(CanQual<? extends Type>/*P*/ From) {
    return isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static PackExpansionType dyn_cast_or_null_PackExpansionType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static boolean isa_PackExpansionType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType cast_PackExpansionType(QualType/*P*/ From) {
    return cast_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType cast_or_null_PackExpansionType(QualType/*P*/ From) {
    return cast_or_null_PackExpansionType(From.getTypePtr());
  }

  public static PackExpansionType dyn_cast_PackExpansionType(QualType/*P*/ From) {
    return isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static PackExpansionType dyn_cast_or_null_PackExpansionType(QualType/*P*/ From) {
    return (From != null) && isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static boolean isa_PackExpansionType(Type/*P*/ From) {
    assert From != null;
    return PackExpansionType.classof(From);
  }

  public static PackExpansionType cast_PackExpansionType(Type/*P*/ From) {
    assert isa_PackExpansionType(From);
    return (PackExpansionType) From;
  }

  public static PackExpansionType cast_or_null_PackExpansionType(Type/*P*/ From) {
    return (From == null) ? null : cast_PackExpansionType(From);
  }

  public static PackExpansionType dyn_cast_PackExpansionType(Type/*P*/ From) {
    assert From != null;
    return isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static PackExpansionType dyn_cast_or_null_PackExpansionType(Type/*P*/ From) {
    return (From != null) && isa_PackExpansionType(From) ? cast_PackExpansionType(From) : null;
  }

  public static boolean isa_ParenType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParenType.class, From.$deref());
  }

  public static ParenType cast_ParenType(type$ref<?>/*P*/ From) {
    assert isa_ParenType(From);
    return llvm.cast(ParenType.class, From.$deref());
  }

  public static ParenType cast_or_null_ParenType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParenType(From);
  }

  public static ParenType dyn_cast_ParenType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static ParenType dyn_cast_or_null_ParenType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static boolean isa_ParenType(Type/*P*/ From) {
    assert From != null;
    return ParenType.classof(From);
  }

  public static ParenType cast_ParenType(Type/*P*/ From) {
    assert isa_ParenType(From);
    return (ParenType) From;
  }

  public static ParenType cast_or_null_ParenType(Type/*P*/ From) {
    return (From == null) ? null : cast_ParenType(From);
  }

  public static ParenType dyn_cast_ParenType(Type/*P*/ From) {
    assert From != null;
    return isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static ParenType dyn_cast_or_null_ParenType(Type/*P*/ From) {
    return (From != null) && isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static boolean isa_ParenType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParenType.class, From.$star());
  }

  public static ParenType cast_ParenType(type$ptr<?>/*P*/ From) {
    assert isa_ParenType(From);
    return llvm.cast(ParenType.class, From.$star());
  }

  public static ParenType cast_or_null_ParenType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParenType(From);
  }

  public static ParenType dyn_cast_ParenType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static ParenType dyn_cast_or_null_ParenType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static boolean isa_ParenType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ParenType(From.getTypePtr());
  }

  public static ParenType cast_ParenType(QualType/*P*/ From) {
    return cast_ParenType(From.getTypePtr());
  }

  public static ParenType cast_or_null_ParenType(QualType/*P*/ From) {
    return cast_or_null_ParenType(From.getTypePtr());
  }

  public static ParenType dyn_cast_ParenType(QualType/*P*/ From) {
    return isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static ParenType dyn_cast_or_null_ParenType(QualType/*P*/ From) {
    return (From != null) && isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static boolean isa_ParenType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ParenType(From.getTypePtr());
  }

  public static ParenType cast_ParenType(CanQual<? extends Type>/*P*/ From) {
    return cast_ParenType(From.getTypePtr());
  }

  public static ParenType cast_or_null_ParenType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ParenType(From.getTypePtr());
  }

  public static ParenType dyn_cast_ParenType(CanQual<? extends Type>/*P*/ From) {
    return isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static ParenType dyn_cast_or_null_ParenType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ParenType(From) ? cast_ParenType(From) : null;
  }

  public static boolean isa_PipeType(Type/*P*/ From) {
    assert From != null;
    return PipeType.classof(From);
  }

  public static PipeType cast_PipeType(Type/*P*/ From) {
    assert isa_PipeType(From);
    return (PipeType) From;
  }

  public static PipeType cast_or_null_PipeType(Type/*P*/ From) {
    return (From == null) ? null : cast_PipeType(From);
  }

  public static PipeType dyn_cast_PipeType(Type/*P*/ From) {
    assert From != null;
    return isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static PipeType dyn_cast_or_null_PipeType(Type/*P*/ From) {
    return (From != null) && isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static boolean isa_PipeType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PipeType(From.getTypePtr());
  }

  public static PipeType cast_PipeType(QualType/*P*/ From) {
    return cast_PipeType(From.getTypePtr());
  }

  public static PipeType cast_or_null_PipeType(QualType/*P*/ From) {
    return cast_or_null_PipeType(From.getTypePtr());
  }

  public static PipeType dyn_cast_PipeType(QualType/*P*/ From) {
    return isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static PipeType dyn_cast_or_null_PipeType(QualType/*P*/ From) {
    return (From != null) && isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static boolean isa_PipeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PipeType.class, From.$deref());
  }

  public static PipeType cast_PipeType(type$ref<?>/*P*/ From) {
    assert isa_PipeType(From);
    return llvm.cast(PipeType.class, From.$deref());
  }

  public static PipeType cast_or_null_PipeType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PipeType(From);
  }

  public static PipeType dyn_cast_PipeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static PipeType dyn_cast_or_null_PipeType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static boolean isa_PipeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PipeType.class, From.$star());
  }

  public static PipeType cast_PipeType(type$ptr<?>/*P*/ From) {
    assert isa_PipeType(From);
    return llvm.cast(PipeType.class, From.$star());
  }

  public static PipeType cast_or_null_PipeType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PipeType(From);
  }

  public static PipeType dyn_cast_PipeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static PipeType dyn_cast_or_null_PipeType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static boolean isa_PipeType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PipeType(From.getTypePtr());
  }

  public static PipeType cast_PipeType(CanQual<? extends Type>/*P*/ From) {
    return cast_PipeType(From.getTypePtr());
  }

  public static PipeType cast_or_null_PipeType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_PipeType(From.getTypePtr());
  }

  public static PipeType dyn_cast_PipeType(CanQual<? extends Type>/*P*/ From) {
    return isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static PipeType dyn_cast_or_null_PipeType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_PipeType(From) ? cast_PipeType(From) : null;
  }

  public static boolean isa_PointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PointerType.class, From.$deref());
  }

  public static PointerType cast_PointerType(type$ref<?>/*P*/ From) {
    assert isa_PointerType(From);
    return llvm.cast(PointerType.class, From.$deref());
  }

  public static PointerType cast_or_null_PointerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PointerType(From.getTypePtr());
  }

  public static PointerType cast_PointerType(QualType/*P*/ From) {
    return cast_PointerType(From.getTypePtr());
  }

  public static PointerType cast_or_null_PointerType(QualType/*P*/ From) {
    return cast_or_null_PointerType(From.getTypePtr());
  }

  public static PointerType dyn_cast_PointerType(QualType/*P*/ From) {
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(QualType/*P*/ From) {
    return (From != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PointerType.class, From.$star());
  }

  public static PointerType cast_PointerType(type$ptr<?>/*P*/ From) {
    assert isa_PointerType(From);
    return llvm.cast(PointerType.class, From.$star());
  }

  public static PointerType cast_or_null_PointerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(Type/*P*/ From) {
    assert From != null;
    return PointerType.classof(From);
  }

  public static PointerType cast_PointerType(Type/*P*/ From) {
    assert isa_PointerType(From);
    return (PointerType) From;
  }

  public static PointerType cast_or_null_PointerType(Type/*P*/ From) {
    return (From == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(Type/*P*/ From) {
    assert From != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(Type/*P*/ From) {
    return (From != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_PointerType(From.getTypePtr());
  }

  public static PointerType cast_PointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_PointerType(From.getTypePtr());
  }

  public static PointerType cast_or_null_PointerType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_PointerType(From.getTypePtr());
  }

  public static PointerType dyn_cast_PointerType(CanQual<? extends Type>/*P*/ From) {
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_RValueReferenceType(Type/*P*/ From) {
    assert From != null;
    return RValueReferenceType.classof(From);
  }

  public static RValueReferenceType cast_RValueReferenceType(Type/*P*/ From) {
    assert isa_RValueReferenceType(From);
    return (RValueReferenceType) From;
  }

  public static RValueReferenceType cast_or_null_RValueReferenceType(Type/*P*/ From) {
    return (From == null) ? null : cast_RValueReferenceType(From);
  }

  public static RValueReferenceType dyn_cast_RValueReferenceType(Type/*P*/ From) {
    assert From != null;
    return isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static RValueReferenceType dyn_cast_or_null_RValueReferenceType(Type/*P*/ From) {
    return (From != null) && isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static boolean isa_RValueReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RValueReferenceType.class, From.$star());
  }

  public static RValueReferenceType cast_RValueReferenceType(type$ptr<?>/*P*/ From) {
    assert isa_RValueReferenceType(From);
    return llvm.cast(RValueReferenceType.class, From.$star());
  }

  public static RValueReferenceType cast_or_null_RValueReferenceType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RValueReferenceType(From);
  }

  public static RValueReferenceType dyn_cast_RValueReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static RValueReferenceType dyn_cast_or_null_RValueReferenceType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static boolean isa_RValueReferenceType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType cast_RValueReferenceType(QualType/*P*/ From) {
    return cast_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType cast_or_null_RValueReferenceType(QualType/*P*/ From) {
    return cast_or_null_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType dyn_cast_RValueReferenceType(QualType/*P*/ From) {
    return isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static RValueReferenceType dyn_cast_or_null_RValueReferenceType(QualType/*P*/ From) {
    return (From != null) && isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static boolean isa_RValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType cast_RValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType cast_or_null_RValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_RValueReferenceType(From.getTypePtr());
  }

  public static RValueReferenceType dyn_cast_RValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static RValueReferenceType dyn_cast_or_null_RValueReferenceType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static boolean isa_RValueReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RValueReferenceType.class, From.$deref());
  }

  public static RValueReferenceType cast_RValueReferenceType(type$ref<?>/*P*/ From) {
    assert isa_RValueReferenceType(From);
    return llvm.cast(RValueReferenceType.class, From.$deref());
  }

  public static RValueReferenceType cast_or_null_RValueReferenceType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RValueReferenceType(From);
  }

  public static RValueReferenceType dyn_cast_RValueReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static RValueReferenceType dyn_cast_or_null_RValueReferenceType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RValueReferenceType(From) ? cast_RValueReferenceType(From) : null;
  }

  public static boolean isa_RecordType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_RecordType(From.getTypePtr());
  }

  public static RecordType cast_RecordType(QualType/*P*/ From) {
    return cast_RecordType(From.getTypePtr());
  }

  public static RecordType cast_or_null_RecordType(QualType/*P*/ From) {
    return cast_or_null_RecordType(From.getTypePtr());
  }

  public static RecordType dyn_cast_RecordType(QualType/*P*/ From) {
    return isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static RecordType dyn_cast_or_null_RecordType(QualType/*P*/ From) {
    return (From != null) && isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static boolean isa_RecordType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RecordType.class, From.$deref());
  }

  public static RecordType cast_RecordType(type$ref<?>/*P*/ From) {
    assert isa_RecordType(From);
    return llvm.cast(RecordType.class, From.$deref());
  }

  public static RecordType cast_or_null_RecordType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RecordType(From);
  }

  public static RecordType dyn_cast_RecordType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static RecordType dyn_cast_or_null_RecordType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static boolean isa_RecordType(Type/*P*/ From) {
    assert From != null;
    return RecordType.classof(From);
  }

  public static RecordType cast_RecordType(Type/*P*/ From) {
    assert isa_RecordType(From);
    return (RecordType) From;
  }

  public static RecordType cast_or_null_RecordType(Type/*P*/ From) {
    return (From == null) ? null : cast_RecordType(From);
  }

  public static RecordType dyn_cast_RecordType(Type/*P*/ From) {
    assert From != null;
    return isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static RecordType dyn_cast_or_null_RecordType(Type/*P*/ From) {
    return (From != null) && isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static boolean isa_RecordType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_RecordType(From.getTypePtr());
  }

  public static RecordType cast_RecordType(CanQual<? extends Type>/*P*/ From) {
    return cast_RecordType(From.getTypePtr());
  }

  public static RecordType cast_or_null_RecordType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_RecordType(From.getTypePtr());
  }

  public static RecordType dyn_cast_RecordType(CanQual<? extends Type>/*P*/ From) {
    return isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static RecordType dyn_cast_or_null_RecordType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static boolean isa_RecordType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RecordType.class, From.$star());
  }

  public static RecordType cast_RecordType(type$ptr<?>/*P*/ From) {
    assert isa_RecordType(From);
    return llvm.cast(RecordType.class, From.$star());
  }

  public static RecordType cast_or_null_RecordType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RecordType(From);
  }

  public static RecordType dyn_cast_RecordType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static RecordType dyn_cast_or_null_RecordType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RecordType(From) ? cast_RecordType(From) : null;
  }

  public static boolean isa_ReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReferenceType.class, From.$deref());
  }

  public static ReferenceType cast_ReferenceType(type$ref<?>/*P*/ From) {
    assert isa_ReferenceType(From);
    return llvm.cast(ReferenceType.class, From.$deref());
  }

  public static ReferenceType cast_or_null_ReferenceType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReferenceType(From);
  }

  public static ReferenceType dyn_cast_ReferenceType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static ReferenceType dyn_cast_or_null_ReferenceType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static boolean isa_ReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReferenceType.class, From.$star());
  }

  public static ReferenceType cast_ReferenceType(type$ptr<?>/*P*/ From) {
    assert isa_ReferenceType(From);
    return llvm.cast(ReferenceType.class, From.$star());
  }

  public static ReferenceType cast_or_null_ReferenceType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReferenceType(From);
  }

  public static ReferenceType dyn_cast_ReferenceType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static ReferenceType dyn_cast_or_null_ReferenceType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static boolean isa_ReferenceType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType cast_ReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType cast_or_null_ReferenceType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType dyn_cast_ReferenceType(CanQual<? extends Type>/*P*/ From) {
    return isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static ReferenceType dyn_cast_or_null_ReferenceType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static boolean isa_ReferenceType(Type/*P*/ From) {
    assert From != null;
    return ReferenceType.classof(From);
  }

  public static ReferenceType cast_ReferenceType(Type/*P*/ From) {
    assert isa_ReferenceType(From);
    return (ReferenceType) From;
  }

  public static ReferenceType cast_or_null_ReferenceType(Type/*P*/ From) {
    return (From == null) ? null : cast_ReferenceType(From);
  }

  public static ReferenceType dyn_cast_ReferenceType(Type/*P*/ From) {
    assert From != null;
    return isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static ReferenceType dyn_cast_or_null_ReferenceType(Type/*P*/ From) {
    return (From != null) && isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static boolean isa_ReferenceType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType cast_ReferenceType(QualType/*P*/ From) {
    return cast_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType cast_or_null_ReferenceType(QualType/*P*/ From) {
    return cast_or_null_ReferenceType(From.getTypePtr());
  }

  public static ReferenceType dyn_cast_ReferenceType(QualType/*P*/ From) {
    return isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static ReferenceType dyn_cast_or_null_ReferenceType(QualType/*P*/ From) {
    return (From != null) && isa_ReferenceType(From) ? cast_ReferenceType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmPackType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubstTemplateTypeParmPackType.class, From.$deref());
  }

  public static SubstTemplateTypeParmPackType cast_SubstTemplateTypeParmPackType(type$ref<?>/*P*/ From) {
    assert isa_SubstTemplateTypeParmPackType(From);
    return llvm.cast(SubstTemplateTypeParmPackType.class, From.$deref());
  }

  public static SubstTemplateTypeParmPackType cast_or_null_SubstTemplateTypeParmPackType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubstTemplateTypeParmPackType(From);
  }

  public static SubstTemplateTypeParmPackType dyn_cast_SubstTemplateTypeParmPackType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static SubstTemplateTypeParmPackType dyn_cast_or_null_SubstTemplateTypeParmPackType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmPackType(Type/*P*/ From) {
    assert From != null;
    return SubstTemplateTypeParmPackType.classof(From);
  }

  public static SubstTemplateTypeParmPackType cast_SubstTemplateTypeParmPackType(Type/*P*/ From) {
    assert isa_SubstTemplateTypeParmPackType(From);
    return (SubstTemplateTypeParmPackType) From;
  }

  public static SubstTemplateTypeParmPackType cast_or_null_SubstTemplateTypeParmPackType(Type/*P*/ From) {
    return (From == null) ? null : cast_SubstTemplateTypeParmPackType(From);
  }

  public static SubstTemplateTypeParmPackType dyn_cast_SubstTemplateTypeParmPackType(Type/*P*/ From) {
    assert From != null;
    return isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static SubstTemplateTypeParmPackType dyn_cast_or_null_SubstTemplateTypeParmPackType(Type/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmPackType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType cast_SubstTemplateTypeParmPackType(QualType/*P*/ From) {
    return cast_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType cast_or_null_SubstTemplateTypeParmPackType(QualType/*P*/ From) {
    return cast_or_null_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType dyn_cast_SubstTemplateTypeParmPackType(QualType/*P*/ From) {
    return isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static SubstTemplateTypeParmPackType dyn_cast_or_null_SubstTemplateTypeParmPackType(QualType/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmPackType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubstTemplateTypeParmPackType.class, From.$star());
  }

  public static SubstTemplateTypeParmPackType cast_SubstTemplateTypeParmPackType(type$ptr<?>/*P*/ From) {
    assert isa_SubstTemplateTypeParmPackType(From);
    return llvm.cast(SubstTemplateTypeParmPackType.class, From.$star());
  }

  public static SubstTemplateTypeParmPackType cast_or_null_SubstTemplateTypeParmPackType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubstTemplateTypeParmPackType(From);
  }

  public static SubstTemplateTypeParmPackType dyn_cast_SubstTemplateTypeParmPackType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static SubstTemplateTypeParmPackType dyn_cast_or_null_SubstTemplateTypeParmPackType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmPackType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType cast_SubstTemplateTypeParmPackType(CanQual<? extends Type>/*P*/ From) {
    return cast_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType cast_or_null_SubstTemplateTypeParmPackType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_SubstTemplateTypeParmPackType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmPackType dyn_cast_SubstTemplateTypeParmPackType(CanQual<? extends Type>/*P*/ From) {
    return isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static SubstTemplateTypeParmPackType dyn_cast_or_null_SubstTemplateTypeParmPackType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmPackType(From) ? cast_SubstTemplateTypeParmPackType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubstTemplateTypeParmType.class, From.$deref());
  }

  public static SubstTemplateTypeParmType cast_SubstTemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert isa_SubstTemplateTypeParmType(From);
    return llvm.cast(SubstTemplateTypeParmType.class, From.$deref());
  }

  public static SubstTemplateTypeParmType cast_or_null_SubstTemplateTypeParmType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubstTemplateTypeParmType(From);
  }

  public static SubstTemplateTypeParmType dyn_cast_SubstTemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static SubstTemplateTypeParmType dyn_cast_or_null_SubstTemplateTypeParmType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType cast_SubstTemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return cast_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType cast_or_null_SubstTemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType dyn_cast_SubstTemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static SubstTemplateTypeParmType dyn_cast_or_null_SubstTemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmType(Type/*P*/ From) {
    assert From != null;
    return SubstTemplateTypeParmType.classof(From);
  }

  public static SubstTemplateTypeParmType cast_SubstTemplateTypeParmType(Type/*P*/ From) {
    assert isa_SubstTemplateTypeParmType(From);
    return (SubstTemplateTypeParmType) From;
  }

  public static SubstTemplateTypeParmType cast_or_null_SubstTemplateTypeParmType(Type/*P*/ From) {
    return (From == null) ? null : cast_SubstTemplateTypeParmType(From);
  }

  public static SubstTemplateTypeParmType dyn_cast_SubstTemplateTypeParmType(Type/*P*/ From) {
    assert From != null;
    return isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static SubstTemplateTypeParmType dyn_cast_or_null_SubstTemplateTypeParmType(Type/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubstTemplateTypeParmType.class, From.$star());
  }

  public static SubstTemplateTypeParmType cast_SubstTemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert isa_SubstTemplateTypeParmType(From);
    return llvm.cast(SubstTemplateTypeParmType.class, From.$star());
  }

  public static SubstTemplateTypeParmType cast_or_null_SubstTemplateTypeParmType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubstTemplateTypeParmType(From);
  }

  public static SubstTemplateTypeParmType dyn_cast_SubstTemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static SubstTemplateTypeParmType dyn_cast_or_null_SubstTemplateTypeParmType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static boolean isa_SubstTemplateTypeParmType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType cast_SubstTemplateTypeParmType(QualType/*P*/ From) {
    return cast_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType cast_or_null_SubstTemplateTypeParmType(QualType/*P*/ From) {
    return cast_or_null_SubstTemplateTypeParmType(From.getTypePtr());
  }

  public static SubstTemplateTypeParmType dyn_cast_SubstTemplateTypeParmType(QualType/*P*/ From) {
    return isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static SubstTemplateTypeParmType dyn_cast_or_null_SubstTemplateTypeParmType(QualType/*P*/ From) {
    return (From != null) && isa_SubstTemplateTypeParmType(From) ? cast_SubstTemplateTypeParmType(From) : null;
  }

  public static boolean isa_TagType(Type/*P*/ From) {
    assert From != null;
    return TagType.classof(From);
  }

  public static TagType cast_TagType(Type/*P*/ From) {
    assert isa_TagType(From);
    return (TagType) From;
  }

  public static TagType cast_or_null_TagType(Type/*P*/ From) {
    return (From == null) ? null : cast_TagType(From);
  }

  public static TagType dyn_cast_TagType(Type/*P*/ From) {
    assert From != null;
    return isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static TagType dyn_cast_or_null_TagType(Type/*P*/ From) {
    return (From != null) && isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static boolean isa_TagType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TagType.class, From.$star());
  }

  public static TagType cast_TagType(type$ptr<?>/*P*/ From) {
    assert isa_TagType(From);
    return llvm.cast(TagType.class, From.$star());
  }

  public static TagType cast_or_null_TagType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TagType(From);
  }

  public static TagType dyn_cast_TagType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static TagType dyn_cast_or_null_TagType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static boolean isa_TagType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TagType(From.getTypePtr());
  }

  public static TagType cast_TagType(QualType/*P*/ From) {
    return cast_TagType(From.getTypePtr());
  }

  public static TagType cast_or_null_TagType(QualType/*P*/ From) {
    return cast_or_null_TagType(From.getTypePtr());
  }

  public static TagType dyn_cast_TagType(QualType/*P*/ From) {
    return isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static TagType dyn_cast_or_null_TagType(QualType/*P*/ From) {
    return (From != null) && isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static boolean isa_TagType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TagType(From.getTypePtr());
  }

  public static TagType cast_TagType(CanQual<? extends Type>/*P*/ From) {
    return cast_TagType(From.getTypePtr());
  }

  public static TagType cast_or_null_TagType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TagType(From.getTypePtr());
  }

  public static TagType dyn_cast_TagType(CanQual<? extends Type>/*P*/ From) {
    return isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static TagType dyn_cast_or_null_TagType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static boolean isa_TagType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TagType.class, From.$deref());
  }

  public static TagType cast_TagType(type$ref<?>/*P*/ From) {
    assert isa_TagType(From);
    return llvm.cast(TagType.class, From.$deref());
  }

  public static TagType cast_or_null_TagType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TagType(From);
  }

  public static TagType dyn_cast_TagType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static TagType dyn_cast_or_null_TagType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TagType(From) ? cast_TagType(From) : null;
  }

  public static boolean isa_TemplateSpecializationType(Type/*P*/ From) {
    assert From != null;
    return TemplateSpecializationType.classof(From);
  }

  public static TemplateSpecializationType cast_TemplateSpecializationType(Type/*P*/ From) {
    assert isa_TemplateSpecializationType(From);
    return (TemplateSpecializationType) From;
  }

  public static TemplateSpecializationType cast_or_null_TemplateSpecializationType(Type/*P*/ From) {
    return (From == null) ? null : cast_TemplateSpecializationType(From);
  }

  public static TemplateSpecializationType dyn_cast_TemplateSpecializationType(Type/*P*/ From) {
    assert From != null;
    return isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static TemplateSpecializationType dyn_cast_or_null_TemplateSpecializationType(Type/*P*/ From) {
    return (From != null) && isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static boolean isa_TemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType cast_TemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return cast_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType cast_or_null_TemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType dyn_cast_TemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static TemplateSpecializationType dyn_cast_or_null_TemplateSpecializationType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static boolean isa_TemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TemplateSpecializationType.class, From.$star());
  }

  public static TemplateSpecializationType cast_TemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert isa_TemplateSpecializationType(From);
    return llvm.cast(TemplateSpecializationType.class, From.$star());
  }

  public static TemplateSpecializationType cast_or_null_TemplateSpecializationType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TemplateSpecializationType(From);
  }

  public static TemplateSpecializationType dyn_cast_TemplateSpecializationType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static TemplateSpecializationType dyn_cast_or_null_TemplateSpecializationType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static boolean isa_TemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TemplateSpecializationType.class, From.$deref());
  }

  public static TemplateSpecializationType cast_TemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert isa_TemplateSpecializationType(From);
    return llvm.cast(TemplateSpecializationType.class, From.$deref());
  }

  public static TemplateSpecializationType cast_or_null_TemplateSpecializationType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TemplateSpecializationType(From);
  }

  public static TemplateSpecializationType dyn_cast_TemplateSpecializationType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static TemplateSpecializationType dyn_cast_or_null_TemplateSpecializationType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static boolean isa_TemplateSpecializationType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType cast_TemplateSpecializationType(QualType/*P*/ From) {
    return cast_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType cast_or_null_TemplateSpecializationType(QualType/*P*/ From) {
    return cast_or_null_TemplateSpecializationType(From.getTypePtr());
  }

  public static TemplateSpecializationType dyn_cast_TemplateSpecializationType(QualType/*P*/ From) {
    return isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static TemplateSpecializationType dyn_cast_or_null_TemplateSpecializationType(QualType/*P*/ From) {
    return (From != null) && isa_TemplateSpecializationType(From) ? cast_TemplateSpecializationType(From) : null;
  }

  public static boolean isa_TemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType cast_TemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return cast_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType cast_or_null_TemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType dyn_cast_TemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static TemplateTypeParmType dyn_cast_or_null_TemplateTypeParmType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static boolean isa_TemplateTypeParmType(Type/*P*/ From) {
    assert From != null;
    return TemplateTypeParmType.classof(From);
  }

  public static TemplateTypeParmType cast_TemplateTypeParmType(Type/*P*/ From) {
    assert isa_TemplateTypeParmType(From);
    return (TemplateTypeParmType) From;
  }

  public static TemplateTypeParmType cast_or_null_TemplateTypeParmType(Type/*P*/ From) {
    return (From == null) ? null : cast_TemplateTypeParmType(From);
  }

  public static TemplateTypeParmType dyn_cast_TemplateTypeParmType(Type/*P*/ From) {
    assert From != null;
    return isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static TemplateTypeParmType dyn_cast_or_null_TemplateTypeParmType(Type/*P*/ From) {
    return (From != null) && isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static boolean isa_TemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TemplateTypeParmType.class, From.$star());
  }

  public static TemplateTypeParmType cast_TemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert isa_TemplateTypeParmType(From);
    return llvm.cast(TemplateTypeParmType.class, From.$star());
  }

  public static TemplateTypeParmType cast_or_null_TemplateTypeParmType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TemplateTypeParmType(From);
  }

  public static TemplateTypeParmType dyn_cast_TemplateTypeParmType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static TemplateTypeParmType dyn_cast_or_null_TemplateTypeParmType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static boolean isa_TemplateTypeParmType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType cast_TemplateTypeParmType(QualType/*P*/ From) {
    return cast_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType cast_or_null_TemplateTypeParmType(QualType/*P*/ From) {
    return cast_or_null_TemplateTypeParmType(From.getTypePtr());
  }

  public static TemplateTypeParmType dyn_cast_TemplateTypeParmType(QualType/*P*/ From) {
    return isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static TemplateTypeParmType dyn_cast_or_null_TemplateTypeParmType(QualType/*P*/ From) {
    return (From != null) && isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static boolean isa_TemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TemplateTypeParmType.class, From.$deref());
  }

  public static TemplateTypeParmType cast_TemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert isa_TemplateTypeParmType(From);
    return llvm.cast(TemplateTypeParmType.class, From.$deref());
  }

  public static TemplateTypeParmType cast_or_null_TemplateTypeParmType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TemplateTypeParmType(From);
  }

  public static TemplateTypeParmType dyn_cast_TemplateTypeParmType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static TemplateTypeParmType dyn_cast_or_null_TemplateTypeParmType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TemplateTypeParmType(From) ? cast_TemplateTypeParmType(From) : null;
  }

  public static boolean isa_Type(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Type.class, From.$deref());
  }

  public static Type cast_Type(type$ref<?>/*P*/ From) {
    assert isa_Type(From);
    return llvm.cast(Type.class, From.$deref());
  }

  public static Type cast_or_null_Type(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_Type(From.getTypePtr());
  }

  public static Type cast_Type(CanQual<? extends Type>/*P*/ From) {
    return cast_Type(From.getTypePtr());
  }

  public static Type cast_or_null_Type(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_Type(From.getTypePtr());
  }

  public static Type dyn_cast_Type(CanQual<? extends Type>/*P*/ From) {
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Type.class, From.$star());
  }

  public static Type cast_Type(type$ptr<?>/*P*/ From) {
    assert isa_Type(From);
    return llvm.cast(Type.class, From.$star());
  }

  public static Type cast_or_null_Type(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_Type(From.getTypePtr());
  }

  public static Type cast_Type(QualType/*P*/ From) {
    return cast_Type(From.getTypePtr());
  }

  public static Type cast_or_null_Type(QualType/*P*/ From) {
    return cast_or_null_Type(From.getTypePtr());
  }

  public static Type dyn_cast_Type(QualType/*P*/ From) {
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(QualType/*P*/ From) {
    return (From != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(Type/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Type cast_Type(Type/*P*/ From) {
    assert isa_Type(From);
    return (Type) From;
  }

  public static Type cast_or_null_Type(Type/*P*/ From) {
    return (From == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(Type/*P*/ From) {
    assert From != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(Type/*P*/ From) {
    return (From != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_TypeOfExprType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType cast_TypeOfExprType(QualType/*P*/ From) {
    return cast_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType cast_or_null_TypeOfExprType(QualType/*P*/ From) {
    return cast_or_null_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType dyn_cast_TypeOfExprType(QualType/*P*/ From) {
    return isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static TypeOfExprType dyn_cast_or_null_TypeOfExprType(QualType/*P*/ From) {
    return (From != null) && isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static boolean isa_TypeOfExprType(Type/*P*/ From) {
    assert From != null;
    return TypeOfExprType.classof(From);
  }

  public static TypeOfExprType cast_TypeOfExprType(Type/*P*/ From) {
    assert isa_TypeOfExprType(From);
    return (TypeOfExprType) From;
  }

  public static TypeOfExprType cast_or_null_TypeOfExprType(Type/*P*/ From) {
    return (From == null) ? null : cast_TypeOfExprType(From);
  }

  public static TypeOfExprType dyn_cast_TypeOfExprType(Type/*P*/ From) {
    assert From != null;
    return isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static TypeOfExprType dyn_cast_or_null_TypeOfExprType(Type/*P*/ From) {
    return (From != null) && isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static boolean isa_TypeOfExprType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeOfExprType.class, From.$star());
  }

  public static TypeOfExprType cast_TypeOfExprType(type$ptr<?>/*P*/ From) {
    assert isa_TypeOfExprType(From);
    return llvm.cast(TypeOfExprType.class, From.$star());
  }

  public static TypeOfExprType cast_or_null_TypeOfExprType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeOfExprType(From);
  }

  public static TypeOfExprType dyn_cast_TypeOfExprType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static TypeOfExprType dyn_cast_or_null_TypeOfExprType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static boolean isa_TypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType cast_TypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return cast_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType cast_or_null_TypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TypeOfExprType(From.getTypePtr());
  }

  public static TypeOfExprType dyn_cast_TypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static TypeOfExprType dyn_cast_or_null_TypeOfExprType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static boolean isa_TypeOfExprType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeOfExprType.class, From.$deref());
  }

  public static TypeOfExprType cast_TypeOfExprType(type$ref<?>/*P*/ From) {
    assert isa_TypeOfExprType(From);
    return llvm.cast(TypeOfExprType.class, From.$deref());
  }

  public static TypeOfExprType cast_or_null_TypeOfExprType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeOfExprType(From);
  }

  public static TypeOfExprType dyn_cast_TypeOfExprType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static TypeOfExprType dyn_cast_or_null_TypeOfExprType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeOfExprType(From) ? cast_TypeOfExprType(From) : null;
  }

  public static boolean isa_TypeOfType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeOfType.class, From.$deref());
  }

  public static TypeOfType cast_TypeOfType(type$ref<?>/*P*/ From) {
    assert isa_TypeOfType(From);
    return llvm.cast(TypeOfType.class, From.$deref());
  }

  public static TypeOfType cast_or_null_TypeOfType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeOfType(From);
  }

  public static TypeOfType dyn_cast_TypeOfType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static TypeOfType dyn_cast_or_null_TypeOfType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static boolean isa_TypeOfType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType cast_TypeOfType(QualType/*P*/ From) {
    return cast_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType cast_or_null_TypeOfType(QualType/*P*/ From) {
    return cast_or_null_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType dyn_cast_TypeOfType(QualType/*P*/ From) {
    return isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static TypeOfType dyn_cast_or_null_TypeOfType(QualType/*P*/ From) {
    return (From != null) && isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static boolean isa_TypeOfType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType cast_TypeOfType(CanQual<? extends Type>/*P*/ From) {
    return cast_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType cast_or_null_TypeOfType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TypeOfType(From.getTypePtr());
  }

  public static TypeOfType dyn_cast_TypeOfType(CanQual<? extends Type>/*P*/ From) {
    return isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static TypeOfType dyn_cast_or_null_TypeOfType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static boolean isa_TypeOfType(Type/*P*/ From) {
    assert From != null;
    return TypeOfType.classof(From);
  }

  public static TypeOfType cast_TypeOfType(Type/*P*/ From) {
    assert isa_TypeOfType(From);
    return (TypeOfType) From;
  }

  public static TypeOfType cast_or_null_TypeOfType(Type/*P*/ From) {
    return (From == null) ? null : cast_TypeOfType(From);
  }

  public static TypeOfType dyn_cast_TypeOfType(Type/*P*/ From) {
    assert From != null;
    return isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static TypeOfType dyn_cast_or_null_TypeOfType(Type/*P*/ From) {
    return (From != null) && isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static boolean isa_TypeOfType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeOfType.class, From.$star());
  }

  public static TypeOfType cast_TypeOfType(type$ptr<?>/*P*/ From) {
    assert isa_TypeOfType(From);
    return llvm.cast(TypeOfType.class, From.$star());
  }

  public static TypeOfType cast_or_null_TypeOfType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeOfType(From);
  }

  public static TypeOfType dyn_cast_TypeOfType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static TypeOfType dyn_cast_or_null_TypeOfType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeOfType(From) ? cast_TypeOfType(From) : null;
  }

  public static boolean isa_TypedefType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypedefType(From.getTypePtr());
  }

  public static TypedefType cast_TypedefType(CanQual<? extends Type>/*P*/ From) {
    return cast_TypedefType(From.getTypePtr());
  }

  public static TypedefType cast_or_null_TypedefType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TypedefType(From.getTypePtr());
  }

  public static TypedefType dyn_cast_TypedefType(CanQual<? extends Type>/*P*/ From) {
    return isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static TypedefType dyn_cast_or_null_TypedefType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static boolean isa_TypedefType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypedefType.class, From.$star());
  }

  public static TypedefType cast_TypedefType(type$ptr<?>/*P*/ From) {
    assert isa_TypedefType(From);
    return llvm.cast(TypedefType.class, From.$star());
  }

  public static TypedefType cast_or_null_TypedefType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypedefType(From);
  }

  public static TypedefType dyn_cast_TypedefType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static TypedefType dyn_cast_or_null_TypedefType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static boolean isa_TypedefType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypedefType.class, From.$deref());
  }

  public static TypedefType cast_TypedefType(type$ref<?>/*P*/ From) {
    assert isa_TypedefType(From);
    return llvm.cast(TypedefType.class, From.$deref());
  }

  public static TypedefType cast_or_null_TypedefType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypedefType(From);
  }

  public static TypedefType dyn_cast_TypedefType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static TypedefType dyn_cast_or_null_TypedefType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static boolean isa_TypedefType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypedefType(From.getTypePtr());
  }

  public static TypedefType cast_TypedefType(QualType/*P*/ From) {
    return cast_TypedefType(From.getTypePtr());
  }

  public static TypedefType cast_or_null_TypedefType(QualType/*P*/ From) {
    return cast_or_null_TypedefType(From.getTypePtr());
  }

  public static TypedefType dyn_cast_TypedefType(QualType/*P*/ From) {
    return isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static TypedefType dyn_cast_or_null_TypedefType(QualType/*P*/ From) {
    return (From != null) && isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static boolean isa_TypedefType(Type/*P*/ From) {
    assert From != null;
    return TypedefType.classof(From);
  }

  public static TypedefType cast_TypedefType(Type/*P*/ From) {
    assert isa_TypedefType(From);
    return (TypedefType) From;
  }

  public static TypedefType cast_or_null_TypedefType(Type/*P*/ From) {
    return (From == null) ? null : cast_TypedefType(From);
  }

  public static TypedefType dyn_cast_TypedefType(Type/*P*/ From) {
    assert From != null;
    return isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static TypedefType dyn_cast_or_null_TypedefType(Type/*P*/ From) {
    return (From != null) && isa_TypedefType(From) ? cast_TypedefType(From) : null;
  }

  public static boolean isa_UnaryTransformType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType cast_UnaryTransformType(QualType/*P*/ From) {
    return cast_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType cast_or_null_UnaryTransformType(QualType/*P*/ From) {
    return cast_or_null_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType dyn_cast_UnaryTransformType(QualType/*P*/ From) {
    return isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static UnaryTransformType dyn_cast_or_null_UnaryTransformType(QualType/*P*/ From) {
    return (From != null) && isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static boolean isa_UnaryTransformType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryTransformType.class, From.$star());
  }

  public static UnaryTransformType cast_UnaryTransformType(type$ptr<?>/*P*/ From) {
    assert isa_UnaryTransformType(From);
    return llvm.cast(UnaryTransformType.class, From.$star());
  }

  public static UnaryTransformType cast_or_null_UnaryTransformType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryTransformType(From);
  }

  public static UnaryTransformType dyn_cast_UnaryTransformType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static UnaryTransformType dyn_cast_or_null_UnaryTransformType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static boolean isa_UnaryTransformType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryTransformType.class, From.$deref());
  }

  public static UnaryTransformType cast_UnaryTransformType(type$ref<?>/*P*/ From) {
    assert isa_UnaryTransformType(From);
    return llvm.cast(UnaryTransformType.class, From.$deref());
  }

  public static UnaryTransformType cast_or_null_UnaryTransformType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryTransformType(From);
  }

  public static UnaryTransformType dyn_cast_UnaryTransformType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static UnaryTransformType dyn_cast_or_null_UnaryTransformType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static boolean isa_UnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType cast_UnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return cast_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType cast_or_null_UnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_UnaryTransformType(From.getTypePtr());
  }

  public static UnaryTransformType dyn_cast_UnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static UnaryTransformType dyn_cast_or_null_UnaryTransformType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static boolean isa_UnaryTransformType(Type/*P*/ From) {
    assert From != null;
    return UnaryTransformType.classof(From);
  }

  public static UnaryTransformType cast_UnaryTransformType(Type/*P*/ From) {
    assert isa_UnaryTransformType(From);
    return (UnaryTransformType) From;
  }

  public static UnaryTransformType cast_or_null_UnaryTransformType(Type/*P*/ From) {
    return (From == null) ? null : cast_UnaryTransformType(From);
  }

  public static UnaryTransformType dyn_cast_UnaryTransformType(Type/*P*/ From) {
    assert From != null;
    return isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static UnaryTransformType dyn_cast_or_null_UnaryTransformType(Type/*P*/ From) {
    return (From != null) && isa_UnaryTransformType(From) ? cast_UnaryTransformType(From) : null;
  }

  public static boolean isa_UnresolvedUsingType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnresolvedUsingType.class, From.$deref());
  }

  public static UnresolvedUsingType cast_UnresolvedUsingType(type$ref<?>/*P*/ From) {
    assert isa_UnresolvedUsingType(From);
    return llvm.cast(UnresolvedUsingType.class, From.$deref());
  }

  public static UnresolvedUsingType cast_or_null_UnresolvedUsingType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnresolvedUsingType(From);
  }

  public static UnresolvedUsingType dyn_cast_UnresolvedUsingType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static UnresolvedUsingType dyn_cast_or_null_UnresolvedUsingType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static boolean isa_UnresolvedUsingType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType cast_UnresolvedUsingType(QualType/*P*/ From) {
    return cast_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType cast_or_null_UnresolvedUsingType(QualType/*P*/ From) {
    return cast_or_null_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType dyn_cast_UnresolvedUsingType(QualType/*P*/ From) {
    return isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static UnresolvedUsingType dyn_cast_or_null_UnresolvedUsingType(QualType/*P*/ From) {
    return (From != null) && isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static boolean isa_UnresolvedUsingType(Type/*P*/ From) {
    assert From != null;
    return UnresolvedUsingType.classof(From);
  }

  public static UnresolvedUsingType cast_UnresolvedUsingType(Type/*P*/ From) {
    assert isa_UnresolvedUsingType(From);
    return (UnresolvedUsingType) From;
  }

  public static UnresolvedUsingType cast_or_null_UnresolvedUsingType(Type/*P*/ From) {
    return (From == null) ? null : cast_UnresolvedUsingType(From);
  }

  public static UnresolvedUsingType dyn_cast_UnresolvedUsingType(Type/*P*/ From) {
    assert From != null;
    return isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static UnresolvedUsingType dyn_cast_or_null_UnresolvedUsingType(Type/*P*/ From) {
    return (From != null) && isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static boolean isa_UnresolvedUsingType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnresolvedUsingType.class, From.$star());
  }

  public static UnresolvedUsingType cast_UnresolvedUsingType(type$ptr<?>/*P*/ From) {
    assert isa_UnresolvedUsingType(From);
    return llvm.cast(UnresolvedUsingType.class, From.$star());
  }

  public static UnresolvedUsingType cast_or_null_UnresolvedUsingType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnresolvedUsingType(From);
  }

  public static UnresolvedUsingType dyn_cast_UnresolvedUsingType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static UnresolvedUsingType dyn_cast_or_null_UnresolvedUsingType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static boolean isa_UnresolvedUsingType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType cast_UnresolvedUsingType(CanQual<? extends Type>/*P*/ From) {
    return cast_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType cast_or_null_UnresolvedUsingType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_UnresolvedUsingType(From.getTypePtr());
  }

  public static UnresolvedUsingType dyn_cast_UnresolvedUsingType(CanQual<? extends Type>/*P*/ From) {
    return isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static UnresolvedUsingType dyn_cast_or_null_UnresolvedUsingType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_UnresolvedUsingType(From) ? cast_UnresolvedUsingType(From) : null;
  }

  public static boolean isa_VariableArrayType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType cast_VariableArrayType(QualType/*P*/ From) {
    return cast_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType cast_or_null_VariableArrayType(QualType/*P*/ From) {
    return cast_or_null_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType dyn_cast_VariableArrayType(QualType/*P*/ From) {
    return isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static VariableArrayType dyn_cast_or_null_VariableArrayType(QualType/*P*/ From) {
    return (From != null) && isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static boolean isa_VariableArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VariableArrayType.class, From.$star());
  }

  public static VariableArrayType cast_VariableArrayType(type$ptr<?>/*P*/ From) {
    assert isa_VariableArrayType(From);
    return llvm.cast(VariableArrayType.class, From.$star());
  }

  public static VariableArrayType cast_or_null_VariableArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VariableArrayType(From);
  }

  public static VariableArrayType dyn_cast_VariableArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static VariableArrayType dyn_cast_or_null_VariableArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static boolean isa_VariableArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VariableArrayType.class, From.$deref());
  }

  public static VariableArrayType cast_VariableArrayType(type$ref<?>/*P*/ From) {
    assert isa_VariableArrayType(From);
    return llvm.cast(VariableArrayType.class, From.$deref());
  }

  public static VariableArrayType cast_or_null_VariableArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VariableArrayType(From);
  }

  public static VariableArrayType dyn_cast_VariableArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static VariableArrayType dyn_cast_or_null_VariableArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static boolean isa_VariableArrayType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType cast_VariableArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType cast_or_null_VariableArrayType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_VariableArrayType(From.getTypePtr());
  }

  public static VariableArrayType dyn_cast_VariableArrayType(CanQual<? extends Type>/*P*/ From) {
    return isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static VariableArrayType dyn_cast_or_null_VariableArrayType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static boolean isa_VariableArrayType(Type/*P*/ From) {
    assert From != null;
    return VariableArrayType.classof(From);
  }

  public static VariableArrayType cast_VariableArrayType(Type/*P*/ From) {
    assert isa_VariableArrayType(From);
    return (VariableArrayType) From;
  }

  public static VariableArrayType cast_or_null_VariableArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_VariableArrayType(From);
  }

  public static VariableArrayType dyn_cast_VariableArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static VariableArrayType dyn_cast_or_null_VariableArrayType(Type/*P*/ From) {
    return (From != null) && isa_VariableArrayType(From) ? cast_VariableArrayType(From) : null;
  }

  public static boolean isa_VectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VectorType.class, From.$deref());
  }

  public static VectorType cast_VectorType(type$ref<?>/*P*/ From) {
    assert isa_VectorType(From);
    return llvm.cast(VectorType.class, From.$deref());
  }

  public static VectorType cast_or_null_VectorType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_VectorType(From.getTypePtr());
  }

  public static VectorType cast_VectorType(QualType/*P*/ From) {
    return cast_VectorType(From.getTypePtr());
  }

  public static VectorType cast_or_null_VectorType(QualType/*P*/ From) {
    return cast_or_null_VectorType(From.getTypePtr());
  }

  public static VectorType dyn_cast_VectorType(QualType/*P*/ From) {
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(QualType/*P*/ From) {
    return (From != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_VectorType(From.getTypePtr());
  }

  public static VectorType cast_VectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_VectorType(From.getTypePtr());
  }

  public static VectorType cast_or_null_VectorType(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_VectorType(From.getTypePtr());
  }

  public static VectorType dyn_cast_VectorType(CanQual<? extends Type>/*P*/ From) {
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(Type/*P*/ From) {
    assert From != null;
    return VectorType.classof(From);
  }

  public static VectorType cast_VectorType(Type/*P*/ From) {
    assert isa_VectorType(From);
    return (VectorType) From;
  }

  public static VectorType cast_or_null_VectorType(Type/*P*/ From) {
    return (From == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(Type/*P*/ From) {
    assert From != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(Type/*P*/ From) {
    return (From != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VectorType.class, From.$star());
  }

  public static VectorType cast_VectorType(type$ptr<?>/*P*/ From) {
    assert isa_VectorType(From);
    return llvm.cast(VectorType.class, From.$star());
  }

  public static VectorType cast_or_null_VectorType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }
}
