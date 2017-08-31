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
import org.clang.ast.comments.*;
import org.clang.ast.impl.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class AstRTTI {
  /*package*/AstRTTI() {}

  public static boolean isa_AbstractConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return AbstractConditionalOperator.classof(From);
  }

  public static AbstractConditionalOperator cast_AbstractConditionalOperator(Stmt/*P*/ From) {
    assert isa_AbstractConditionalOperator(From);
    return (AbstractConditionalOperator) From;
  }

  public static AbstractConditionalOperator cast_or_null_AbstractConditionalOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AbstractConditionalOperator(From);
  }

  public static AbstractConditionalOperator dyn_cast_AbstractConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static AbstractConditionalOperator dyn_cast_or_null_AbstractConditionalOperator(Stmt/*P*/ From) {
    return (From != null) && isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static boolean isa_AbstractConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AbstractConditionalOperator.class, From.$star());
  }

  public static AbstractConditionalOperator cast_AbstractConditionalOperator(type$ptr<?>/*P*/ From) {
    assert isa_AbstractConditionalOperator(From);
    return llvm.cast(AbstractConditionalOperator.class, From.$star());
  }

  public static AbstractConditionalOperator cast_or_null_AbstractConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AbstractConditionalOperator(From);
  }

  public static AbstractConditionalOperator dyn_cast_AbstractConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static AbstractConditionalOperator dyn_cast_or_null_AbstractConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static boolean isa_AbstractConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AbstractConditionalOperator.class, From.$deref());
  }

  public static AbstractConditionalOperator cast_AbstractConditionalOperator(type$ref<?>/*P*/ From) {
    assert isa_AbstractConditionalOperator(From);
    return llvm.cast(AbstractConditionalOperator.class, From.$deref());
  }

  public static AbstractConditionalOperator cast_or_null_AbstractConditionalOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AbstractConditionalOperator(From);
  }

  public static AbstractConditionalOperator dyn_cast_AbstractConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static AbstractConditionalOperator dyn_cast_or_null_AbstractConditionalOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AbstractConditionalOperator(From) ? cast_AbstractConditionalOperator(From) : null;
  }

  public static boolean isa_BinaryConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinaryConditionalOperator.class, From.$deref());
  }

  public static BinaryConditionalOperator cast_BinaryConditionalOperator(type$ref<?>/*P*/ From) {
    assert isa_BinaryConditionalOperator(From);
    return llvm.cast(BinaryConditionalOperator.class, From.$deref());
  }

  public static BinaryConditionalOperator cast_or_null_BinaryConditionalOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinaryConditionalOperator(From);
  }

  public static BinaryConditionalOperator dyn_cast_BinaryConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static BinaryConditionalOperator dyn_cast_or_null_BinaryConditionalOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static boolean isa_BinaryConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinaryConditionalOperator.class, From.$star());
  }

  public static BinaryConditionalOperator cast_BinaryConditionalOperator(type$ptr<?>/*P*/ From) {
    assert isa_BinaryConditionalOperator(From);
    return llvm.cast(BinaryConditionalOperator.class, From.$star());
  }

  public static BinaryConditionalOperator cast_or_null_BinaryConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinaryConditionalOperator(From);
  }

  public static BinaryConditionalOperator dyn_cast_BinaryConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static BinaryConditionalOperator dyn_cast_or_null_BinaryConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static boolean isa_BinaryConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return BinaryConditionalOperator.classof(From);
  }

  public static BinaryConditionalOperator cast_BinaryConditionalOperator(Stmt/*P*/ From) {
    assert isa_BinaryConditionalOperator(From);
    return (BinaryConditionalOperator) From;
  }

  public static BinaryConditionalOperator cast_or_null_BinaryConditionalOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_BinaryConditionalOperator(From);
  }

  public static BinaryConditionalOperator dyn_cast_BinaryConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static BinaryConditionalOperator dyn_cast_or_null_BinaryConditionalOperator(Stmt/*P*/ From) {
    return (From != null) && isa_BinaryConditionalOperator(From) ? cast_BinaryConditionalOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinaryOperator.class, From.$deref());
  }

  public static BinaryOperator cast_BinaryOperator(type$ref<?>/*P*/ From) {
    assert isa_BinaryOperator(From);
    return llvm.cast(BinaryOperator.class, From.$deref());
  }

  public static BinaryOperator cast_or_null_BinaryOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinaryOperator.class, From.$star());
  }

  public static BinaryOperator cast_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert isa_BinaryOperator(From);
    return llvm.cast(BinaryOperator.class, From.$star());
  }

  public static BinaryOperator cast_or_null_BinaryOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(Stmt/*P*/ From) {
    assert From != null;
    return BinaryOperator.classof(From);
  }

  public static BinaryOperator cast_BinaryOperator(Stmt/*P*/ From) {
    assert isa_BinaryOperator(From);
    return (BinaryOperator) From;
  }

  public static BinaryOperator cast_or_null_BinaryOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(Stmt/*P*/ From) {
    return (From != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_CharacterLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CharacterLiteral.class, From.$deref());
  }

  public static CharacterLiteral cast_CharacterLiteral(type$ref<?>/*P*/ From) {
    assert isa_CharacterLiteral(From);
    return llvm.cast(CharacterLiteral.class, From.$deref());
  }

  public static CharacterLiteral cast_or_null_CharacterLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CharacterLiteral(From);
  }

  public static CharacterLiteral dyn_cast_CharacterLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static CharacterLiteral dyn_cast_or_null_CharacterLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static boolean isa_CharacterLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CharacterLiteral.class, From.$star());
  }

  public static CharacterLiteral cast_CharacterLiteral(type$ptr<?>/*P*/ From) {
    assert isa_CharacterLiteral(From);
    return llvm.cast(CharacterLiteral.class, From.$star());
  }

  public static CharacterLiteral cast_or_null_CharacterLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CharacterLiteral(From);
  }

  public static CharacterLiteral dyn_cast_CharacterLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static CharacterLiteral dyn_cast_or_null_CharacterLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static boolean isa_CharacterLiteral(Stmt/*P*/ From) {
    assert From != null;
    return CharacterLiteral.classof(From);
  }

  public static CharacterLiteral cast_CharacterLiteral(Stmt/*P*/ From) {
    assert isa_CharacterLiteral(From);
    return (CharacterLiteral) From;
  }

  public static CharacterLiteral cast_or_null_CharacterLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CharacterLiteral(From);
  }

  public static CharacterLiteral dyn_cast_CharacterLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static CharacterLiteral dyn_cast_or_null_CharacterLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_CharacterLiteral(From) ? cast_CharacterLiteral(From) : null;
  }

  public static boolean isa_CompoundAssignOperator(Stmt/*P*/ From) {
    assert From != null;
    return CompoundAssignOperator.classof(From);
  }

  public static CompoundAssignOperator cast_CompoundAssignOperator(Stmt/*P*/ From) {
    assert isa_CompoundAssignOperator(From);
    return (CompoundAssignOperator) From;
  }

  public static CompoundAssignOperator cast_or_null_CompoundAssignOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CompoundAssignOperator(From);
  }

  public static CompoundAssignOperator dyn_cast_CompoundAssignOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static CompoundAssignOperator dyn_cast_or_null_CompoundAssignOperator(Stmt/*P*/ From) {
    return (From != null) && isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static boolean isa_CompoundAssignOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompoundAssignOperator.class, From.$star());
  }

  public static CompoundAssignOperator cast_CompoundAssignOperator(type$ptr<?>/*P*/ From) {
    assert isa_CompoundAssignOperator(From);
    return llvm.cast(CompoundAssignOperator.class, From.$star());
  }

  public static CompoundAssignOperator cast_or_null_CompoundAssignOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompoundAssignOperator(From);
  }

  public static CompoundAssignOperator dyn_cast_CompoundAssignOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static CompoundAssignOperator dyn_cast_or_null_CompoundAssignOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static boolean isa_CompoundAssignOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompoundAssignOperator.class, From.$deref());
  }

  public static CompoundAssignOperator cast_CompoundAssignOperator(type$ref<?>/*P*/ From) {
    assert isa_CompoundAssignOperator(From);
    return llvm.cast(CompoundAssignOperator.class, From.$deref());
  }

  public static CompoundAssignOperator cast_or_null_CompoundAssignOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompoundAssignOperator(From);
  }

  public static CompoundAssignOperator dyn_cast_CompoundAssignOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static CompoundAssignOperator dyn_cast_or_null_CompoundAssignOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompoundAssignOperator(From) ? cast_CompoundAssignOperator(From) : null;
  }

  public static boolean isa_ConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConditionalOperator.class, From.$deref());
  }

  public static ConditionalOperator cast_ConditionalOperator(type$ref<?>/*P*/ From) {
    assert isa_ConditionalOperator(From);
    return llvm.cast(ConditionalOperator.class, From.$deref());
  }

  public static ConditionalOperator cast_or_null_ConditionalOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConditionalOperator(From);
  }

  public static ConditionalOperator dyn_cast_ConditionalOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static ConditionalOperator dyn_cast_or_null_ConditionalOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static boolean isa_ConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConditionalOperator.class, From.$star());
  }

  public static ConditionalOperator cast_ConditionalOperator(type$ptr<?>/*P*/ From) {
    assert isa_ConditionalOperator(From);
    return llvm.cast(ConditionalOperator.class, From.$star());
  }

  public static ConditionalOperator cast_or_null_ConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConditionalOperator(From);
  }

  public static ConditionalOperator dyn_cast_ConditionalOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static ConditionalOperator dyn_cast_or_null_ConditionalOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static boolean isa_ConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return ConditionalOperator.classof(From);
  }

  public static ConditionalOperator cast_ConditionalOperator(Stmt/*P*/ From) {
    assert isa_ConditionalOperator(From);
    return (ConditionalOperator) From;
  }

  public static ConditionalOperator cast_or_null_ConditionalOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ConditionalOperator(From);
  }

  public static ConditionalOperator dyn_cast_ConditionalOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static ConditionalOperator dyn_cast_or_null_ConditionalOperator(Stmt/*P*/ From) {
    return (From != null) && isa_ConditionalOperator(From) ? cast_ConditionalOperator(From) : null;
  }

  public static boolean isa_DeclContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeclContext.class, From.$star());
  }

  public static DeclContext cast_DeclContext(type$ptr<?>/*P*/ From) {
    assert isa_DeclContext(From);
    return llvm.cast(DeclContext.class, From.$star());
  }

  public static DeclContext cast_or_null_DeclContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(DeclContext/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(DeclContext/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(DeclContext/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(DeclContext/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(Decl/*P*/ From) {
    assert From != null;
    return DeclContext.classof(From);
  }

  public static DeclContext cast_DeclContext(Decl/*P*/ From) {
    assert isa_DeclContext(From);
    return llvm.cast(DeclContext.class, From);
  }

  public static DeclContext cast_or_null_DeclContext(Decl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(Decl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(Decl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeclContext.class, From.$deref());
  }

  public static DeclContext cast_DeclContext(type$ref<?>/*P*/ From) {
    assert isa_DeclContext(From);
    return llvm.cast(DeclContext.class, From.$deref());
  }

  public static DeclContext cast_or_null_DeclContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_ExprWithCleanups(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExprWithCleanups.class, From.$deref());
  }

  public static ExprWithCleanups cast_ExprWithCleanups(type$ref<?>/*P*/ From) {
    assert isa_ExprWithCleanups(From);
    return llvm.cast(ExprWithCleanups.class, From.$deref());
  }

  public static ExprWithCleanups cast_or_null_ExprWithCleanups(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExprWithCleanups(From);
  }

  public static ExprWithCleanups dyn_cast_ExprWithCleanups(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static ExprWithCleanups dyn_cast_or_null_ExprWithCleanups(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static boolean isa_ExprWithCleanups(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExprWithCleanups.class, From.$star());
  }

  public static ExprWithCleanups cast_ExprWithCleanups(type$ptr<?>/*P*/ From) {
    assert isa_ExprWithCleanups(From);
    return llvm.cast(ExprWithCleanups.class, From.$star());
  }

  public static ExprWithCleanups cast_or_null_ExprWithCleanups(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExprWithCleanups(From);
  }

  public static ExprWithCleanups dyn_cast_ExprWithCleanups(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static ExprWithCleanups dyn_cast_or_null_ExprWithCleanups(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static boolean isa_ExprWithCleanups(Stmt/*P*/ From) {
    assert From != null;
    return ExprWithCleanups.classof(From);
  }

  public static ExprWithCleanups cast_ExprWithCleanups(Stmt/*P*/ From) {
    assert isa_ExprWithCleanups(From);
    return (ExprWithCleanups) From;
  }

  public static ExprWithCleanups cast_or_null_ExprWithCleanups(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ExprWithCleanups(From);
  }

  public static ExprWithCleanups dyn_cast_ExprWithCleanups(Stmt/*P*/ From) {
    assert From != null;
    return isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static ExprWithCleanups dyn_cast_or_null_ExprWithCleanups(Stmt/*P*/ From) {
    return (From != null) && isa_ExprWithCleanups(From) ? cast_ExprWithCleanups(From) : null;
  }

  public static boolean isa_FloatingLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FloatingLiteral.class, From.$star());
  }

  public static FloatingLiteral cast_FloatingLiteral(type$ptr<?>/*P*/ From) {
    assert isa_FloatingLiteral(From);
    return llvm.cast(FloatingLiteral.class, From.$star());
  }

  public static FloatingLiteral cast_or_null_FloatingLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FloatingLiteral(From);
  }

  public static FloatingLiteral dyn_cast_FloatingLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static FloatingLiteral dyn_cast_or_null_FloatingLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static boolean isa_FloatingLiteral(Stmt/*P*/ From) {
    assert From != null;
    return FloatingLiteral.classof(From);
  }

  public static FloatingLiteral cast_FloatingLiteral(Stmt/*P*/ From) {
    assert isa_FloatingLiteral(From);
    return (FloatingLiteral) From;
  }

  public static FloatingLiteral cast_or_null_FloatingLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_FloatingLiteral(From);
  }

  public static FloatingLiteral dyn_cast_FloatingLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static FloatingLiteral dyn_cast_or_null_FloatingLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static boolean isa_FloatingLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FloatingLiteral.class, From.$deref());
  }

  public static FloatingLiteral cast_FloatingLiteral(type$ref<?>/*P*/ From) {
    assert isa_FloatingLiteral(From);
    return llvm.cast(FloatingLiteral.class, From.$deref());
  }

  public static FloatingLiteral cast_or_null_FloatingLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FloatingLiteral(From);
  }

  public static FloatingLiteral dyn_cast_FloatingLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static FloatingLiteral dyn_cast_or_null_FloatingLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FloatingLiteral(From) ? cast_FloatingLiteral(From) : null;
  }

  public static boolean isa_ImaginaryLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ImaginaryLiteral.class, From.$deref());
  }

  public static ImaginaryLiteral cast_ImaginaryLiteral(type$ref<?>/*P*/ From) {
    assert isa_ImaginaryLiteral(From);
    return llvm.cast(ImaginaryLiteral.class, From.$deref());
  }

  public static ImaginaryLiteral cast_or_null_ImaginaryLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ImaginaryLiteral(From);
  }

  public static ImaginaryLiteral dyn_cast_ImaginaryLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static ImaginaryLiteral dyn_cast_or_null_ImaginaryLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static boolean isa_ImaginaryLiteral(Stmt/*P*/ From) {
    assert From != null;
    return ImaginaryLiteral.classof(From);
  }

  public static ImaginaryLiteral cast_ImaginaryLiteral(Stmt/*P*/ From) {
    assert isa_ImaginaryLiteral(From);
    return (ImaginaryLiteral) From;
  }

  public static ImaginaryLiteral cast_or_null_ImaginaryLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ImaginaryLiteral(From);
  }

  public static ImaginaryLiteral dyn_cast_ImaginaryLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static ImaginaryLiteral dyn_cast_or_null_ImaginaryLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static boolean isa_ImaginaryLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ImaginaryLiteral.class, From.$star());
  }

  public static ImaginaryLiteral cast_ImaginaryLiteral(type$ptr<?>/*P*/ From) {
    assert isa_ImaginaryLiteral(From);
    return llvm.cast(ImaginaryLiteral.class, From.$star());
  }

  public static ImaginaryLiteral cast_or_null_ImaginaryLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ImaginaryLiteral(From);
  }

  public static ImaginaryLiteral dyn_cast_ImaginaryLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static ImaginaryLiteral dyn_cast_or_null_ImaginaryLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ImaginaryLiteral(From) ? cast_ImaginaryLiteral(From) : null;
  }

  public static boolean isa_IntegerLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntegerLiteral.class, From.$deref());
  }

  public static IntegerLiteral cast_IntegerLiteral(type$ref<?>/*P*/ From) {
    assert isa_IntegerLiteral(From);
    return llvm.cast(IntegerLiteral.class, From.$deref());
  }

  public static IntegerLiteral cast_or_null_IntegerLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntegerLiteral(From);
  }

  public static IntegerLiteral dyn_cast_IntegerLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static IntegerLiteral dyn_cast_or_null_IntegerLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static boolean isa_IntegerLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntegerLiteral.class, From.$star());
  }

  public static IntegerLiteral cast_IntegerLiteral(type$ptr<?>/*P*/ From) {
    assert isa_IntegerLiteral(From);
    return llvm.cast(IntegerLiteral.class, From.$star());
  }

  public static IntegerLiteral cast_or_null_IntegerLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntegerLiteral(From);
  }

  public static IntegerLiteral dyn_cast_IntegerLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static IntegerLiteral dyn_cast_or_null_IntegerLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static boolean isa_IntegerLiteral(Stmt/*P*/ From) {
    assert From != null;
    return IntegerLiteral.classof(From);
  }

  public static IntegerLiteral cast_IntegerLiteral(Stmt/*P*/ From) {
    assert isa_IntegerLiteral(From);
    return (IntegerLiteral) From;
  }

  public static IntegerLiteral cast_or_null_IntegerLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_IntegerLiteral(From);
  }

  public static IntegerLiteral dyn_cast_IntegerLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static IntegerLiteral dyn_cast_or_null_IntegerLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_IntegerLiteral(From) ? cast_IntegerLiteral(From) : null;
  }

  public static boolean isa_ItaniumMangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ItaniumMangleContext.class, From.$star());
  }

  public static ItaniumMangleContext cast_ItaniumMangleContext(type$ptr<?>/*P*/ From) {
    assert isa_ItaniumMangleContext(From);
    return llvm.cast(ItaniumMangleContext.class, From.$star());
  }

  public static ItaniumMangleContext cast_or_null_ItaniumMangleContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ItaniumMangleContext(From);
  }

  public static ItaniumMangleContext dyn_cast_ItaniumMangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static ItaniumMangleContext dyn_cast_or_null_ItaniumMangleContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static boolean isa_ItaniumMangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ItaniumMangleContext.class, From.$deref());
  }

  public static ItaniumMangleContext cast_ItaniumMangleContext(type$ref<?>/*P*/ From) {
    assert isa_ItaniumMangleContext(From);
    return llvm.cast(ItaniumMangleContext.class, From.$deref());
  }

  public static ItaniumMangleContext cast_or_null_ItaniumMangleContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ItaniumMangleContext(From);
  }

  public static ItaniumMangleContext dyn_cast_ItaniumMangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static ItaniumMangleContext dyn_cast_or_null_ItaniumMangleContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static boolean isa_ItaniumMangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return ItaniumMangleContext.classof(From);
  }

  public static ItaniumMangleContext cast_ItaniumMangleContext(MangleContext/*P*/ From) {
    assert isa_ItaniumMangleContext(From);
    return (ItaniumMangleContext) From;
  }

  public static ItaniumMangleContext cast_or_null_ItaniumMangleContext(MangleContext/*P*/ From) {
    return (From == null) ? null : cast_ItaniumMangleContext(From);
  }

  public static ItaniumMangleContext dyn_cast_ItaniumMangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static ItaniumMangleContext dyn_cast_or_null_ItaniumMangleContext(MangleContext/*P*/ From) {
    return (From != null) && isa_ItaniumMangleContext(From) ? cast_ItaniumMangleContext(From) : null;
  }

  public static boolean isa_ItaniumVTableContext(VTableContextBase/*P*/ From) {
    assert From != null;
    return ItaniumVTableContext.classof(From);
  }

  public static ItaniumVTableContext cast_ItaniumVTableContext(VTableContextBase/*P*/ From) {
    assert isa_ItaniumVTableContext(From);
    return (ItaniumVTableContext) From;
  }

  public static ItaniumVTableContext cast_or_null_ItaniumVTableContext(VTableContextBase/*P*/ From) {
    return (From == null) ? null : cast_ItaniumVTableContext(From);
  }

  public static ItaniumVTableContext dyn_cast_ItaniumVTableContext(VTableContextBase/*P*/ From) {
    assert From != null;
    return isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static ItaniumVTableContext dyn_cast_or_null_ItaniumVTableContext(VTableContextBase/*P*/ From) {
    return (From != null) && isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static boolean isa_ItaniumVTableContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ItaniumVTableContext.class, From.$star());
  }

  public static ItaniumVTableContext cast_ItaniumVTableContext(type$ptr<?>/*P*/ From) {
    assert isa_ItaniumVTableContext(From);
    return llvm.cast(ItaniumVTableContext.class, From.$star());
  }

  public static ItaniumVTableContext cast_or_null_ItaniumVTableContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ItaniumVTableContext(From);
  }

  public static ItaniumVTableContext dyn_cast_ItaniumVTableContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static ItaniumVTableContext dyn_cast_or_null_ItaniumVTableContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static boolean isa_ItaniumVTableContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ItaniumVTableContext.class, From.$deref());
  }

  public static ItaniumVTableContext cast_ItaniumVTableContext(type$ref<?>/*P*/ From) {
    assert isa_ItaniumVTableContext(From);
    return llvm.cast(ItaniumVTableContext.class, From.$deref());
  }

  public static ItaniumVTableContext cast_or_null_ItaniumVTableContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ItaniumVTableContext(From);
  }

  public static ItaniumVTableContext dyn_cast_ItaniumVTableContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static ItaniumVTableContext dyn_cast_or_null_ItaniumVTableContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ItaniumVTableContext(From) ? cast_ItaniumVTableContext(From) : null;
  }

  public static boolean isa_MangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MangleContext.class, From.$star());
  }

  public static MangleContext cast_MangleContext(type$ptr<?>/*P*/ From) {
    assert isa_MangleContext(From);
    return llvm.cast(MangleContext.class, From.$star());
  }

  public static MangleContext cast_or_null_MangleContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MangleContext(From);
  }

  public static MangleContext dyn_cast_MangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static MangleContext dyn_cast_or_null_MangleContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static boolean isa_MangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MangleContext.class, From.$deref());
  }

  public static MangleContext cast_MangleContext(type$ref<?>/*P*/ From) {
    assert isa_MangleContext(From);
    return llvm.cast(MangleContext.class, From.$deref());
  }

  public static MangleContext cast_or_null_MangleContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MangleContext(From);
  }

  public static MangleContext dyn_cast_MangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static MangleContext dyn_cast_or_null_MangleContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static boolean isa_MangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return true;
  }

  public static MangleContext cast_MangleContext(MangleContext/*P*/ From) {
    assert isa_MangleContext(From);
    return (MangleContext) From;
  }

  public static MangleContext cast_or_null_MangleContext(MangleContext/*P*/ From) {
    return (From == null) ? null : cast_MangleContext(From);
  }

  public static MangleContext dyn_cast_MangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static MangleContext dyn_cast_or_null_MangleContext(MangleContext/*P*/ From) {
    return (From != null) && isa_MangleContext(From) ? cast_MangleContext(From) : null;
  }

  public static boolean isa_MicrosoftMangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MicrosoftMangleContext.class, From.$star());
  }

  public static MicrosoftMangleContext cast_MicrosoftMangleContext(type$ptr<?>/*P*/ From) {
    assert isa_MicrosoftMangleContext(From);
    return llvm.cast(MicrosoftMangleContext.class, From.$star());
  }

  public static MicrosoftMangleContext cast_or_null_MicrosoftMangleContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MicrosoftMangleContext(From);
  }

  public static MicrosoftMangleContext dyn_cast_MicrosoftMangleContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static MicrosoftMangleContext dyn_cast_or_null_MicrosoftMangleContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static boolean isa_MicrosoftMangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MicrosoftMangleContext.class, From.$deref());
  }

  public static MicrosoftMangleContext cast_MicrosoftMangleContext(type$ref<?>/*P*/ From) {
    assert isa_MicrosoftMangleContext(From);
    return llvm.cast(MicrosoftMangleContext.class, From.$deref());
  }

  public static MicrosoftMangleContext cast_or_null_MicrosoftMangleContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MicrosoftMangleContext(From);
  }

  public static MicrosoftMangleContext dyn_cast_MicrosoftMangleContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static MicrosoftMangleContext dyn_cast_or_null_MicrosoftMangleContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static boolean isa_MicrosoftMangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return MicrosoftMangleContext.classof(From);
  }

  public static MicrosoftMangleContext cast_MicrosoftMangleContext(MangleContext/*P*/ From) {
    assert isa_MicrosoftMangleContext(From);
    return (MicrosoftMangleContext) From;
  }

  public static MicrosoftMangleContext cast_or_null_MicrosoftMangleContext(MangleContext/*P*/ From) {
    return (From == null) ? null : cast_MicrosoftMangleContext(From);
  }

  public static MicrosoftMangleContext dyn_cast_MicrosoftMangleContext(MangleContext/*P*/ From) {
    assert From != null;
    return isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static MicrosoftMangleContext dyn_cast_or_null_MicrosoftMangleContext(MangleContext/*P*/ From) {
    return (From != null) && isa_MicrosoftMangleContext(From) ? cast_MicrosoftMangleContext(From) : null;
  }

  public static boolean isa_MicrosoftVTableContext(VTableContextBase/*P*/ From) {
    assert From != null;
    return MicrosoftVTableContext.classof(From);
  }

  public static MicrosoftVTableContext cast_MicrosoftVTableContext(VTableContextBase/*P*/ From) {
    assert isa_MicrosoftVTableContext(From);
    return (MicrosoftVTableContext) From;
  }

  public static MicrosoftVTableContext cast_or_null_MicrosoftVTableContext(VTableContextBase/*P*/ From) {
    return (From == null) ? null : cast_MicrosoftVTableContext(From);
  }

  public static MicrosoftVTableContext dyn_cast_MicrosoftVTableContext(VTableContextBase/*P*/ From) {
    assert From != null;
    return isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static MicrosoftVTableContext dyn_cast_or_null_MicrosoftVTableContext(VTableContextBase/*P*/ From) {
    return (From != null) && isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static boolean isa_MicrosoftVTableContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MicrosoftVTableContext.class, From.$star());
  }

  public static MicrosoftVTableContext cast_MicrosoftVTableContext(type$ptr<?>/*P*/ From) {
    assert isa_MicrosoftVTableContext(From);
    return llvm.cast(MicrosoftVTableContext.class, From.$star());
  }

  public static MicrosoftVTableContext cast_or_null_MicrosoftVTableContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MicrosoftVTableContext(From);
  }

  public static MicrosoftVTableContext dyn_cast_MicrosoftVTableContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static MicrosoftVTableContext dyn_cast_or_null_MicrosoftVTableContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static boolean isa_MicrosoftVTableContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MicrosoftVTableContext.class, From.$deref());
  }

  public static MicrosoftVTableContext cast_MicrosoftVTableContext(type$ref<?>/*P*/ From) {
    assert isa_MicrosoftVTableContext(From);
    return llvm.cast(MicrosoftVTableContext.class, From.$deref());
  }

  public static MicrosoftVTableContext cast_or_null_MicrosoftVTableContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MicrosoftVTableContext(From);
  }

  public static MicrosoftVTableContext dyn_cast_MicrosoftVTableContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static MicrosoftVTableContext dyn_cast_or_null_MicrosoftVTableContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MicrosoftVTableContext(From) ? cast_MicrosoftVTableContext(From) : null;
  }

  public static boolean isa_OMPAlignedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPAlignedClause.class, From.$deref());
  }

  public static OMPAlignedClause cast_OMPAlignedClause(type$ref<?>/*P*/ From) {
    assert isa_OMPAlignedClause(From);
    return llvm.cast(OMPAlignedClause.class, From.$deref());
  }

  public static OMPAlignedClause cast_or_null_OMPAlignedClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPAlignedClause(From);
  }

  public static OMPAlignedClause dyn_cast_OMPAlignedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static OMPAlignedClause dyn_cast_or_null_OMPAlignedClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static boolean isa_OMPAlignedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPAlignedClause.class, From.$star());
  }

  public static OMPAlignedClause cast_OMPAlignedClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPAlignedClause(From);
    return llvm.cast(OMPAlignedClause.class, From.$star());
  }

  public static OMPAlignedClause cast_or_null_OMPAlignedClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPAlignedClause(From);
  }

  public static OMPAlignedClause dyn_cast_OMPAlignedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static OMPAlignedClause dyn_cast_or_null_OMPAlignedClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static boolean isa_OMPAlignedClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPAlignedClause.classof(From);
  }

  public static OMPAlignedClause cast_OMPAlignedClause(OMPClause/*P*/ From) {
    assert isa_OMPAlignedClause(From);
    return (OMPAlignedClause) From;
  }

  public static OMPAlignedClause cast_or_null_OMPAlignedClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPAlignedClause(From);
  }

  public static OMPAlignedClause dyn_cast_OMPAlignedClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static OMPAlignedClause dyn_cast_or_null_OMPAlignedClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPAlignedClause(From) ? cast_OMPAlignedClause(From) : null;
  }

  public static boolean isa_OMPAtomicDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPAtomicDirective.class, From.$star());
  }

  public static OMPAtomicDirective cast_OMPAtomicDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPAtomicDirective(From);
    return llvm.cast(OMPAtomicDirective.class, From.$star());
  }

  public static OMPAtomicDirective cast_or_null_OMPAtomicDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPAtomicDirective(From);
  }

  public static OMPAtomicDirective dyn_cast_OMPAtomicDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static OMPAtomicDirective dyn_cast_or_null_OMPAtomicDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static boolean isa_OMPAtomicDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPAtomicDirective.classof(From);
  }

  public static OMPAtomicDirective cast_OMPAtomicDirective(Stmt/*P*/ From) {
    assert isa_OMPAtomicDirective(From);
    return (OMPAtomicDirective) From;
  }

  public static OMPAtomicDirective cast_or_null_OMPAtomicDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPAtomicDirective(From);
  }

  public static OMPAtomicDirective dyn_cast_OMPAtomicDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static OMPAtomicDirective dyn_cast_or_null_OMPAtomicDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static boolean isa_OMPAtomicDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPAtomicDirective.class, From.$deref());
  }

  public static OMPAtomicDirective cast_OMPAtomicDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPAtomicDirective(From);
    return llvm.cast(OMPAtomicDirective.class, From.$deref());
  }

  public static OMPAtomicDirective cast_or_null_OMPAtomicDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPAtomicDirective(From);
  }

  public static OMPAtomicDirective dyn_cast_OMPAtomicDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static OMPAtomicDirective dyn_cast_or_null_OMPAtomicDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPAtomicDirective(From) ? cast_OMPAtomicDirective(From) : null;
  }

  public static boolean isa_OMPBarrierDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPBarrierDirective.class, From.$deref());
  }

  public static OMPBarrierDirective cast_OMPBarrierDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPBarrierDirective(From);
    return llvm.cast(OMPBarrierDirective.class, From.$deref());
  }

  public static OMPBarrierDirective cast_or_null_OMPBarrierDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPBarrierDirective(From);
  }

  public static OMPBarrierDirective dyn_cast_OMPBarrierDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static OMPBarrierDirective dyn_cast_or_null_OMPBarrierDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static boolean isa_OMPBarrierDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPBarrierDirective.class, From.$star());
  }

  public static OMPBarrierDirective cast_OMPBarrierDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPBarrierDirective(From);
    return llvm.cast(OMPBarrierDirective.class, From.$star());
  }

  public static OMPBarrierDirective cast_or_null_OMPBarrierDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPBarrierDirective(From);
  }

  public static OMPBarrierDirective dyn_cast_OMPBarrierDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static OMPBarrierDirective dyn_cast_or_null_OMPBarrierDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static boolean isa_OMPBarrierDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPBarrierDirective.classof(From);
  }

  public static OMPBarrierDirective cast_OMPBarrierDirective(Stmt/*P*/ From) {
    assert isa_OMPBarrierDirective(From);
    return (OMPBarrierDirective) From;
  }

  public static OMPBarrierDirective cast_or_null_OMPBarrierDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPBarrierDirective(From);
  }

  public static OMPBarrierDirective dyn_cast_OMPBarrierDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static OMPBarrierDirective dyn_cast_or_null_OMPBarrierDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPBarrierDirective(From) ? cast_OMPBarrierDirective(From) : null;
  }

  public static boolean isa_OMPCancelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCancelDirective.class, From.$star());
  }

  public static OMPCancelDirective cast_OMPCancelDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPCancelDirective(From);
    return llvm.cast(OMPCancelDirective.class, From.$star());
  }

  public static OMPCancelDirective cast_or_null_OMPCancelDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCancelDirective(From);
  }

  public static OMPCancelDirective dyn_cast_OMPCancelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static OMPCancelDirective dyn_cast_or_null_OMPCancelDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static boolean isa_OMPCancelDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPCancelDirective.classof(From);
  }

  public static OMPCancelDirective cast_OMPCancelDirective(Stmt/*P*/ From) {
    assert isa_OMPCancelDirective(From);
    return (OMPCancelDirective) From;
  }

  public static OMPCancelDirective cast_or_null_OMPCancelDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPCancelDirective(From);
  }

  public static OMPCancelDirective dyn_cast_OMPCancelDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static OMPCancelDirective dyn_cast_or_null_OMPCancelDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static boolean isa_OMPCancelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCancelDirective.class, From.$deref());
  }

  public static OMPCancelDirective cast_OMPCancelDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPCancelDirective(From);
    return llvm.cast(OMPCancelDirective.class, From.$deref());
  }

  public static OMPCancelDirective cast_or_null_OMPCancelDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCancelDirective(From);
  }

  public static OMPCancelDirective dyn_cast_OMPCancelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static OMPCancelDirective dyn_cast_or_null_OMPCancelDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCancelDirective(From) ? cast_OMPCancelDirective(From) : null;
  }

  public static boolean isa_OMPCancellationPointDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCancellationPointDirective.class, From.$deref());
  }

  public static OMPCancellationPointDirective cast_OMPCancellationPointDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPCancellationPointDirective(From);
    return llvm.cast(OMPCancellationPointDirective.class, From.$deref());
  }

  public static OMPCancellationPointDirective cast_or_null_OMPCancellationPointDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCancellationPointDirective(From);
  }

  public static OMPCancellationPointDirective dyn_cast_OMPCancellationPointDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static OMPCancellationPointDirective dyn_cast_or_null_OMPCancellationPointDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static boolean isa_OMPCancellationPointDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCancellationPointDirective.class, From.$star());
  }

  public static OMPCancellationPointDirective cast_OMPCancellationPointDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPCancellationPointDirective(From);
    return llvm.cast(OMPCancellationPointDirective.class, From.$star());
  }

  public static OMPCancellationPointDirective cast_or_null_OMPCancellationPointDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCancellationPointDirective(From);
  }

  public static OMPCancellationPointDirective dyn_cast_OMPCancellationPointDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static OMPCancellationPointDirective dyn_cast_or_null_OMPCancellationPointDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static boolean isa_OMPCancellationPointDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPCancellationPointDirective.classof(From);
  }

  public static OMPCancellationPointDirective cast_OMPCancellationPointDirective(Stmt/*P*/ From) {
    assert isa_OMPCancellationPointDirective(From);
    return (OMPCancellationPointDirective) From;
  }

  public static OMPCancellationPointDirective cast_or_null_OMPCancellationPointDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPCancellationPointDirective(From);
  }

  public static OMPCancellationPointDirective dyn_cast_OMPCancellationPointDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static OMPCancellationPointDirective dyn_cast_or_null_OMPCancellationPointDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPCancellationPointDirective(From) ? cast_OMPCancellationPointDirective(From) : null;
  }

  public static boolean isa_OMPCaptureClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCaptureClause.class, From.$star());
  }

  public static OMPCaptureClause cast_OMPCaptureClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPCaptureClause(From);
    return llvm.cast(OMPCaptureClause.class, From.$star());
  }

  public static OMPCaptureClause cast_or_null_OMPCaptureClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCaptureClause(From);
  }

  public static OMPCaptureClause dyn_cast_OMPCaptureClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static OMPCaptureClause dyn_cast_or_null_OMPCaptureClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static boolean isa_OMPCaptureClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPCaptureClause.classof(From);
  }

  public static OMPCaptureClause cast_OMPCaptureClause(OMPClause/*P*/ From) {
    assert isa_OMPCaptureClause(From);
    return (OMPCaptureClause) From;
  }

  public static OMPCaptureClause cast_or_null_OMPCaptureClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPCaptureClause(From);
  }

  public static OMPCaptureClause dyn_cast_OMPCaptureClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static OMPCaptureClause dyn_cast_or_null_OMPCaptureClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static boolean isa_OMPCaptureClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCaptureClause.class, From.$deref());
  }

  public static OMPCaptureClause cast_OMPCaptureClause(type$ref<?>/*P*/ From) {
    assert isa_OMPCaptureClause(From);
    return llvm.cast(OMPCaptureClause.class, From.$deref());
  }

  public static OMPCaptureClause cast_or_null_OMPCaptureClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCaptureClause(From);
  }

  public static OMPCaptureClause dyn_cast_OMPCaptureClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static OMPCaptureClause dyn_cast_or_null_OMPCaptureClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCaptureClause(From) ? cast_OMPCaptureClause(From) : null;
  }

  public static boolean isa_OMPClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPClause.class, From.$deref());
  }

  public static OMPClause cast_OMPClause(type$ref<?>/*P*/ From) {
    assert isa_OMPClause(From);
    return llvm.cast(OMPClause.class, From.$deref());
  }

  public static OMPClause cast_or_null_OMPClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPClause(From);
  }

  public static OMPClause dyn_cast_OMPClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static OMPClause dyn_cast_or_null_OMPClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static boolean isa_OMPClause(OMPClause/*P*/ From) {
    assert From != null;
    return true;
  }

  public static OMPClause cast_OMPClause(OMPClause/*P*/ From) {
    assert isa_OMPClause(From);
    return (OMPClause) From;
  }

  public static OMPClause cast_or_null_OMPClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPClause(From);
  }

  public static OMPClause dyn_cast_OMPClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static OMPClause dyn_cast_or_null_OMPClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static boolean isa_OMPClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPClause.class, From.$star());
  }

  public static OMPClause cast_OMPClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPClause(From);
    return llvm.cast(OMPClause.class, From.$star());
  }

  public static OMPClause cast_or_null_OMPClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPClause(From);
  }

  public static OMPClause dyn_cast_OMPClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static OMPClause dyn_cast_or_null_OMPClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPClause(From) ? cast_OMPClause(From) : null;
  }

  public static boolean isa_OMPCollapseClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPCollapseClause.classof(From);
  }

  public static OMPCollapseClause cast_OMPCollapseClause(OMPClause/*P*/ From) {
    assert isa_OMPCollapseClause(From);
    return (OMPCollapseClause) From;
  }

  public static OMPCollapseClause cast_or_null_OMPCollapseClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPCollapseClause(From);
  }

  public static OMPCollapseClause dyn_cast_OMPCollapseClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static OMPCollapseClause dyn_cast_or_null_OMPCollapseClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static boolean isa_OMPCollapseClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCollapseClause.class, From.$star());
  }

  public static OMPCollapseClause cast_OMPCollapseClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPCollapseClause(From);
    return llvm.cast(OMPCollapseClause.class, From.$star());
  }

  public static OMPCollapseClause cast_or_null_OMPCollapseClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCollapseClause(From);
  }

  public static OMPCollapseClause dyn_cast_OMPCollapseClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static OMPCollapseClause dyn_cast_or_null_OMPCollapseClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static boolean isa_OMPCollapseClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCollapseClause.class, From.$deref());
  }

  public static OMPCollapseClause cast_OMPCollapseClause(type$ref<?>/*P*/ From) {
    assert isa_OMPCollapseClause(From);
    return llvm.cast(OMPCollapseClause.class, From.$deref());
  }

  public static OMPCollapseClause cast_or_null_OMPCollapseClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCollapseClause(From);
  }

  public static OMPCollapseClause dyn_cast_OMPCollapseClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static OMPCollapseClause dyn_cast_or_null_OMPCollapseClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCollapseClause(From) ? cast_OMPCollapseClause(From) : null;
  }

  public static boolean isa_OMPCopyinClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCopyinClause.class, From.$star());
  }

  public static OMPCopyinClause cast_OMPCopyinClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPCopyinClause(From);
    return llvm.cast(OMPCopyinClause.class, From.$star());
  }

  public static OMPCopyinClause cast_or_null_OMPCopyinClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCopyinClause(From);
  }

  public static OMPCopyinClause dyn_cast_OMPCopyinClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static OMPCopyinClause dyn_cast_or_null_OMPCopyinClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static boolean isa_OMPCopyinClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPCopyinClause.classof(From);
  }

  public static OMPCopyinClause cast_OMPCopyinClause(OMPClause/*P*/ From) {
    assert isa_OMPCopyinClause(From);
    return (OMPCopyinClause) From;
  }

  public static OMPCopyinClause cast_or_null_OMPCopyinClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPCopyinClause(From);
  }

  public static OMPCopyinClause dyn_cast_OMPCopyinClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static OMPCopyinClause dyn_cast_or_null_OMPCopyinClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static boolean isa_OMPCopyinClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCopyinClause.class, From.$deref());
  }

  public static OMPCopyinClause cast_OMPCopyinClause(type$ref<?>/*P*/ From) {
    assert isa_OMPCopyinClause(From);
    return llvm.cast(OMPCopyinClause.class, From.$deref());
  }

  public static OMPCopyinClause cast_or_null_OMPCopyinClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCopyinClause(From);
  }

  public static OMPCopyinClause dyn_cast_OMPCopyinClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static OMPCopyinClause dyn_cast_or_null_OMPCopyinClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCopyinClause(From) ? cast_OMPCopyinClause(From) : null;
  }

  public static boolean isa_OMPCopyprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCopyprivateClause.class, From.$star());
  }

  public static OMPCopyprivateClause cast_OMPCopyprivateClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPCopyprivateClause(From);
    return llvm.cast(OMPCopyprivateClause.class, From.$star());
  }

  public static OMPCopyprivateClause cast_or_null_OMPCopyprivateClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCopyprivateClause(From);
  }

  public static OMPCopyprivateClause dyn_cast_OMPCopyprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static OMPCopyprivateClause dyn_cast_or_null_OMPCopyprivateClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static boolean isa_OMPCopyprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPCopyprivateClause.classof(From);
  }

  public static OMPCopyprivateClause cast_OMPCopyprivateClause(OMPClause/*P*/ From) {
    assert isa_OMPCopyprivateClause(From);
    return (OMPCopyprivateClause) From;
  }

  public static OMPCopyprivateClause cast_or_null_OMPCopyprivateClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPCopyprivateClause(From);
  }

  public static OMPCopyprivateClause dyn_cast_OMPCopyprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static OMPCopyprivateClause dyn_cast_or_null_OMPCopyprivateClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static boolean isa_OMPCopyprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCopyprivateClause.class, From.$deref());
  }

  public static OMPCopyprivateClause cast_OMPCopyprivateClause(type$ref<?>/*P*/ From) {
    assert isa_OMPCopyprivateClause(From);
    return llvm.cast(OMPCopyprivateClause.class, From.$deref());
  }

  public static OMPCopyprivateClause cast_or_null_OMPCopyprivateClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCopyprivateClause(From);
  }

  public static OMPCopyprivateClause dyn_cast_OMPCopyprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static OMPCopyprivateClause dyn_cast_or_null_OMPCopyprivateClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCopyprivateClause(From) ? cast_OMPCopyprivateClause(From) : null;
  }

  public static boolean isa_OMPCriticalDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCriticalDirective.class, From.$star());
  }

  public static OMPCriticalDirective cast_OMPCriticalDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPCriticalDirective(From);
    return llvm.cast(OMPCriticalDirective.class, From.$star());
  }

  public static OMPCriticalDirective cast_or_null_OMPCriticalDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCriticalDirective(From);
  }

  public static OMPCriticalDirective dyn_cast_OMPCriticalDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static OMPCriticalDirective dyn_cast_or_null_OMPCriticalDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static boolean isa_OMPCriticalDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPCriticalDirective.classof(From);
  }

  public static OMPCriticalDirective cast_OMPCriticalDirective(Stmt/*P*/ From) {
    assert isa_OMPCriticalDirective(From);
    return (OMPCriticalDirective) From;
  }

  public static OMPCriticalDirective cast_or_null_OMPCriticalDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPCriticalDirective(From);
  }

  public static OMPCriticalDirective dyn_cast_OMPCriticalDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static OMPCriticalDirective dyn_cast_or_null_OMPCriticalDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static boolean isa_OMPCriticalDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCriticalDirective.class, From.$deref());
  }

  public static OMPCriticalDirective cast_OMPCriticalDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPCriticalDirective(From);
    return llvm.cast(OMPCriticalDirective.class, From.$deref());
  }

  public static OMPCriticalDirective cast_or_null_OMPCriticalDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCriticalDirective(From);
  }

  public static OMPCriticalDirective dyn_cast_OMPCriticalDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static OMPCriticalDirective dyn_cast_or_null_OMPCriticalDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCriticalDirective(From) ? cast_OMPCriticalDirective(From) : null;
  }

  public static boolean isa_OMPDefaultClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDefaultClause.class, From.$star());
  }

  public static OMPDefaultClause cast_OMPDefaultClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPDefaultClause(From);
    return llvm.cast(OMPDefaultClause.class, From.$star());
  }

  public static OMPDefaultClause cast_or_null_OMPDefaultClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDefaultClause(From);
  }

  public static OMPDefaultClause dyn_cast_OMPDefaultClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static OMPDefaultClause dyn_cast_or_null_OMPDefaultClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static boolean isa_OMPDefaultClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDefaultClause.class, From.$deref());
  }

  public static OMPDefaultClause cast_OMPDefaultClause(type$ref<?>/*P*/ From) {
    assert isa_OMPDefaultClause(From);
    return llvm.cast(OMPDefaultClause.class, From.$deref());
  }

  public static OMPDefaultClause cast_or_null_OMPDefaultClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDefaultClause(From);
  }

  public static OMPDefaultClause dyn_cast_OMPDefaultClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static OMPDefaultClause dyn_cast_or_null_OMPDefaultClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static boolean isa_OMPDefaultClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPDefaultClause.classof(From);
  }

  public static OMPDefaultClause cast_OMPDefaultClause(OMPClause/*P*/ From) {
    assert isa_OMPDefaultClause(From);
    return (OMPDefaultClause) From;
  }

  public static OMPDefaultClause cast_or_null_OMPDefaultClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPDefaultClause(From);
  }

  public static OMPDefaultClause dyn_cast_OMPDefaultClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static OMPDefaultClause dyn_cast_or_null_OMPDefaultClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPDefaultClause(From) ? cast_OMPDefaultClause(From) : null;
  }

  public static boolean isa_OMPDefaultmapClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDefaultmapClause.class, From.$star());
  }

  public static OMPDefaultmapClause cast_OMPDefaultmapClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPDefaultmapClause(From);
    return llvm.cast(OMPDefaultmapClause.class, From.$star());
  }

  public static OMPDefaultmapClause cast_or_null_OMPDefaultmapClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDefaultmapClause(From);
  }

  public static OMPDefaultmapClause dyn_cast_OMPDefaultmapClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static OMPDefaultmapClause dyn_cast_or_null_OMPDefaultmapClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static boolean isa_OMPDefaultmapClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDefaultmapClause.class, From.$deref());
  }

  public static OMPDefaultmapClause cast_OMPDefaultmapClause(type$ref<?>/*P*/ From) {
    assert isa_OMPDefaultmapClause(From);
    return llvm.cast(OMPDefaultmapClause.class, From.$deref());
  }

  public static OMPDefaultmapClause cast_or_null_OMPDefaultmapClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDefaultmapClause(From);
  }

  public static OMPDefaultmapClause dyn_cast_OMPDefaultmapClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static OMPDefaultmapClause dyn_cast_or_null_OMPDefaultmapClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static boolean isa_OMPDefaultmapClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPDefaultmapClause.classof(From);
  }

  public static OMPDefaultmapClause cast_OMPDefaultmapClause(OMPClause/*P*/ From) {
    assert isa_OMPDefaultmapClause(From);
    return (OMPDefaultmapClause) From;
  }

  public static OMPDefaultmapClause cast_or_null_OMPDefaultmapClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPDefaultmapClause(From);
  }

  public static OMPDefaultmapClause dyn_cast_OMPDefaultmapClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static OMPDefaultmapClause dyn_cast_or_null_OMPDefaultmapClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPDefaultmapClause(From) ? cast_OMPDefaultmapClause(From) : null;
  }

  public static boolean isa_OMPDependClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDependClause.class, From.$deref());
  }

  public static OMPDependClause cast_OMPDependClause(type$ref<?>/*P*/ From) {
    assert isa_OMPDependClause(From);
    return llvm.cast(OMPDependClause.class, From.$deref());
  }

  public static OMPDependClause cast_or_null_OMPDependClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDependClause(From);
  }

  public static OMPDependClause dyn_cast_OMPDependClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static OMPDependClause dyn_cast_or_null_OMPDependClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static boolean isa_OMPDependClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPDependClause.classof(From);
  }

  public static OMPDependClause cast_OMPDependClause(OMPClause/*P*/ From) {
    assert isa_OMPDependClause(From);
    return (OMPDependClause) From;
  }

  public static OMPDependClause cast_or_null_OMPDependClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPDependClause(From);
  }

  public static OMPDependClause dyn_cast_OMPDependClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static OMPDependClause dyn_cast_or_null_OMPDependClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static boolean isa_OMPDependClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDependClause.class, From.$star());
  }

  public static OMPDependClause cast_OMPDependClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPDependClause(From);
    return llvm.cast(OMPDependClause.class, From.$star());
  }

  public static OMPDependClause cast_or_null_OMPDependClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDependClause(From);
  }

  public static OMPDependClause dyn_cast_OMPDependClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static OMPDependClause dyn_cast_or_null_OMPDependClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDependClause(From) ? cast_OMPDependClause(From) : null;
  }

  public static boolean isa_OMPDeviceClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPDeviceClause.classof(From);
  }

  public static OMPDeviceClause cast_OMPDeviceClause(OMPClause/*P*/ From) {
    assert isa_OMPDeviceClause(From);
    return (OMPDeviceClause) From;
  }

  public static OMPDeviceClause cast_or_null_OMPDeviceClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPDeviceClause(From);
  }

  public static OMPDeviceClause dyn_cast_OMPDeviceClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static OMPDeviceClause dyn_cast_or_null_OMPDeviceClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static boolean isa_OMPDeviceClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDeviceClause.class, From.$star());
  }

  public static OMPDeviceClause cast_OMPDeviceClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPDeviceClause(From);
    return llvm.cast(OMPDeviceClause.class, From.$star());
  }

  public static OMPDeviceClause cast_or_null_OMPDeviceClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDeviceClause(From);
  }

  public static OMPDeviceClause dyn_cast_OMPDeviceClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static OMPDeviceClause dyn_cast_or_null_OMPDeviceClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static boolean isa_OMPDeviceClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDeviceClause.class, From.$deref());
  }

  public static OMPDeviceClause cast_OMPDeviceClause(type$ref<?>/*P*/ From) {
    assert isa_OMPDeviceClause(From);
    return llvm.cast(OMPDeviceClause.class, From.$deref());
  }

  public static OMPDeviceClause cast_or_null_OMPDeviceClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDeviceClause(From);
  }

  public static OMPDeviceClause dyn_cast_OMPDeviceClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static OMPDeviceClause dyn_cast_or_null_OMPDeviceClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDeviceClause(From) ? cast_OMPDeviceClause(From) : null;
  }

  public static boolean isa_OMPDistScheduleClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDistScheduleClause.class, From.$star());
  }

  public static OMPDistScheduleClause cast_OMPDistScheduleClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPDistScheduleClause(From);
    return llvm.cast(OMPDistScheduleClause.class, From.$star());
  }

  public static OMPDistScheduleClause cast_or_null_OMPDistScheduleClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDistScheduleClause(From);
  }

  public static OMPDistScheduleClause dyn_cast_OMPDistScheduleClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static OMPDistScheduleClause dyn_cast_or_null_OMPDistScheduleClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static boolean isa_OMPDistScheduleClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDistScheduleClause.class, From.$deref());
  }

  public static OMPDistScheduleClause cast_OMPDistScheduleClause(type$ref<?>/*P*/ From) {
    assert isa_OMPDistScheduleClause(From);
    return llvm.cast(OMPDistScheduleClause.class, From.$deref());
  }

  public static OMPDistScheduleClause cast_or_null_OMPDistScheduleClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDistScheduleClause(From);
  }

  public static OMPDistScheduleClause dyn_cast_OMPDistScheduleClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static OMPDistScheduleClause dyn_cast_or_null_OMPDistScheduleClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static boolean isa_OMPDistScheduleClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPDistScheduleClause.classof(From);
  }

  public static OMPDistScheduleClause cast_OMPDistScheduleClause(OMPClause/*P*/ From) {
    assert isa_OMPDistScheduleClause(From);
    return (OMPDistScheduleClause) From;
  }

  public static OMPDistScheduleClause cast_or_null_OMPDistScheduleClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPDistScheduleClause(From);
  }

  public static OMPDistScheduleClause dyn_cast_OMPDistScheduleClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static OMPDistScheduleClause dyn_cast_or_null_OMPDistScheduleClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPDistScheduleClause(From) ? cast_OMPDistScheduleClause(From) : null;
  }

  public static boolean isa_OMPDistributeDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDistributeDirective.class, From.$deref());
  }

  public static OMPDistributeDirective cast_OMPDistributeDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPDistributeDirective(From);
    return llvm.cast(OMPDistributeDirective.class, From.$deref());
  }

  public static OMPDistributeDirective cast_or_null_OMPDistributeDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDistributeDirective(From);
  }

  public static OMPDistributeDirective dyn_cast_OMPDistributeDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static OMPDistributeDirective dyn_cast_or_null_OMPDistributeDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static boolean isa_OMPDistributeDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPDistributeDirective.classof(From);
  }

  public static OMPDistributeDirective cast_OMPDistributeDirective(Stmt/*P*/ From) {
    assert isa_OMPDistributeDirective(From);
    return (OMPDistributeDirective) From;
  }

  public static OMPDistributeDirective cast_or_null_OMPDistributeDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPDistributeDirective(From);
  }

  public static OMPDistributeDirective dyn_cast_OMPDistributeDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static OMPDistributeDirective dyn_cast_or_null_OMPDistributeDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static boolean isa_OMPDistributeDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDistributeDirective.class, From.$star());
  }

  public static OMPDistributeDirective cast_OMPDistributeDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPDistributeDirective(From);
    return llvm.cast(OMPDistributeDirective.class, From.$star());
  }

  public static OMPDistributeDirective cast_or_null_OMPDistributeDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDistributeDirective(From);
  }

  public static OMPDistributeDirective dyn_cast_OMPDistributeDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static OMPDistributeDirective dyn_cast_or_null_OMPDistributeDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDistributeDirective(From) ? cast_OMPDistributeDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDistributeParallelForDirective.class, From.$deref());
  }

  public static OMPDistributeParallelForDirective cast_OMPDistributeParallelForDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPDistributeParallelForDirective(From);
    return llvm.cast(OMPDistributeParallelForDirective.class, From.$deref());
  }

  public static OMPDistributeParallelForDirective cast_or_null_OMPDistributeParallelForDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDistributeParallelForDirective(From);
  }

  public static OMPDistributeParallelForDirective dyn_cast_OMPDistributeParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static OMPDistributeParallelForDirective dyn_cast_or_null_OMPDistributeParallelForDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPDistributeParallelForDirective.classof(From);
  }

  public static OMPDistributeParallelForDirective cast_OMPDistributeParallelForDirective(Stmt/*P*/ From) {
    assert isa_OMPDistributeParallelForDirective(From);
    return (OMPDistributeParallelForDirective) From;
  }

  public static OMPDistributeParallelForDirective cast_or_null_OMPDistributeParallelForDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPDistributeParallelForDirective(From);
  }

  public static OMPDistributeParallelForDirective dyn_cast_OMPDistributeParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static OMPDistributeParallelForDirective dyn_cast_or_null_OMPDistributeParallelForDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDistributeParallelForDirective.class, From.$star());
  }

  public static OMPDistributeParallelForDirective cast_OMPDistributeParallelForDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPDistributeParallelForDirective(From);
    return llvm.cast(OMPDistributeParallelForDirective.class, From.$star());
  }

  public static OMPDistributeParallelForDirective cast_or_null_OMPDistributeParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDistributeParallelForDirective(From);
  }

  public static OMPDistributeParallelForDirective dyn_cast_OMPDistributeParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static OMPDistributeParallelForDirective dyn_cast_or_null_OMPDistributeParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDistributeParallelForDirective(From) ? cast_OMPDistributeParallelForDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDistributeParallelForSimdDirective.class, From.$star());
  }

  public static OMPDistributeParallelForSimdDirective cast_OMPDistributeParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPDistributeParallelForSimdDirective(From);
    return llvm.cast(OMPDistributeParallelForSimdDirective.class, From.$star());
  }

  public static OMPDistributeParallelForSimdDirective cast_or_null_OMPDistributeParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDistributeParallelForSimdDirective(From);
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_OMPDistributeParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_or_null_OMPDistributeParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPDistributeParallelForSimdDirective.classof(From);
  }

  public static OMPDistributeParallelForSimdDirective cast_OMPDistributeParallelForSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPDistributeParallelForSimdDirective(From);
    return (OMPDistributeParallelForSimdDirective) From;
  }

  public static OMPDistributeParallelForSimdDirective cast_or_null_OMPDistributeParallelForSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPDistributeParallelForSimdDirective(From);
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_OMPDistributeParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_or_null_OMPDistributeParallelForSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPDistributeParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDistributeParallelForSimdDirective.class, From.$deref());
  }

  public static OMPDistributeParallelForSimdDirective cast_OMPDistributeParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPDistributeParallelForSimdDirective(From);
    return llvm.cast(OMPDistributeParallelForSimdDirective.class, From.$deref());
  }

  public static OMPDistributeParallelForSimdDirective cast_or_null_OMPDistributeParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDistributeParallelForSimdDirective(From);
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_OMPDistributeParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static OMPDistributeParallelForSimdDirective dyn_cast_or_null_OMPDistributeParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDistributeParallelForSimdDirective(From) ? cast_OMPDistributeParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPDistributeSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDistributeSimdDirective.class, From.$deref());
  }

  public static OMPDistributeSimdDirective cast_OMPDistributeSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPDistributeSimdDirective(From);
    return llvm.cast(OMPDistributeSimdDirective.class, From.$deref());
  }

  public static OMPDistributeSimdDirective cast_or_null_OMPDistributeSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDistributeSimdDirective(From);
  }

  public static OMPDistributeSimdDirective dyn_cast_OMPDistributeSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static OMPDistributeSimdDirective dyn_cast_or_null_OMPDistributeSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static boolean isa_OMPDistributeSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPDistributeSimdDirective.classof(From);
  }

  public static OMPDistributeSimdDirective cast_OMPDistributeSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPDistributeSimdDirective(From);
    return (OMPDistributeSimdDirective) From;
  }

  public static OMPDistributeSimdDirective cast_or_null_OMPDistributeSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPDistributeSimdDirective(From);
  }

  public static OMPDistributeSimdDirective dyn_cast_OMPDistributeSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static OMPDistributeSimdDirective dyn_cast_or_null_OMPDistributeSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static boolean isa_OMPDistributeSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDistributeSimdDirective.class, From.$star());
  }

  public static OMPDistributeSimdDirective cast_OMPDistributeSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPDistributeSimdDirective(From);
    return llvm.cast(OMPDistributeSimdDirective.class, From.$star());
  }

  public static OMPDistributeSimdDirective cast_or_null_OMPDistributeSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDistributeSimdDirective(From);
  }

  public static OMPDistributeSimdDirective dyn_cast_OMPDistributeSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static OMPDistributeSimdDirective dyn_cast_or_null_OMPDistributeSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDistributeSimdDirective(From) ? cast_OMPDistributeSimdDirective(From) : null;
  }

  public static boolean isa_OMPExecutableDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPExecutableDirective.class, From.$deref());
  }

  public static OMPExecutableDirective cast_OMPExecutableDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPExecutableDirective(From);
    return llvm.cast(OMPExecutableDirective.class, From.$deref());
  }

  public static OMPExecutableDirective cast_or_null_OMPExecutableDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPExecutableDirective(From);
  }

  public static OMPExecutableDirective dyn_cast_OMPExecutableDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static OMPExecutableDirective dyn_cast_or_null_OMPExecutableDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static boolean isa_OMPExecutableDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPExecutableDirective.classof(From);
  }

  public static OMPExecutableDirective cast_OMPExecutableDirective(Stmt/*P*/ From) {
    assert isa_OMPExecutableDirective(From);
    return (OMPExecutableDirective) From;
  }

  public static OMPExecutableDirective cast_or_null_OMPExecutableDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPExecutableDirective(From);
  }

  public static OMPExecutableDirective dyn_cast_OMPExecutableDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static OMPExecutableDirective dyn_cast_or_null_OMPExecutableDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static boolean isa_OMPExecutableDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPExecutableDirective.class, From.$star());
  }

  public static OMPExecutableDirective cast_OMPExecutableDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPExecutableDirective(From);
    return llvm.cast(OMPExecutableDirective.class, From.$star());
  }

  public static OMPExecutableDirective cast_or_null_OMPExecutableDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPExecutableDirective(From);
  }

  public static OMPExecutableDirective dyn_cast_OMPExecutableDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static OMPExecutableDirective dyn_cast_or_null_OMPExecutableDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPExecutableDirective(From) ? cast_OMPExecutableDirective(From) : null;
  }

  public static boolean isa_OMPFinalClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPFinalClause.class, From.$star());
  }

  public static OMPFinalClause cast_OMPFinalClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPFinalClause(From);
    return llvm.cast(OMPFinalClause.class, From.$star());
  }

  public static OMPFinalClause cast_or_null_OMPFinalClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPFinalClause(From);
  }

  public static OMPFinalClause dyn_cast_OMPFinalClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static OMPFinalClause dyn_cast_or_null_OMPFinalClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static boolean isa_OMPFinalClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPFinalClause.class, From.$deref());
  }

  public static OMPFinalClause cast_OMPFinalClause(type$ref<?>/*P*/ From) {
    assert isa_OMPFinalClause(From);
    return llvm.cast(OMPFinalClause.class, From.$deref());
  }

  public static OMPFinalClause cast_or_null_OMPFinalClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPFinalClause(From);
  }

  public static OMPFinalClause dyn_cast_OMPFinalClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static OMPFinalClause dyn_cast_or_null_OMPFinalClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static boolean isa_OMPFinalClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPFinalClause.classof(From);
  }

  public static OMPFinalClause cast_OMPFinalClause(OMPClause/*P*/ From) {
    assert isa_OMPFinalClause(From);
    return (OMPFinalClause) From;
  }

  public static OMPFinalClause cast_or_null_OMPFinalClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPFinalClause(From);
  }

  public static OMPFinalClause dyn_cast_OMPFinalClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static OMPFinalClause dyn_cast_or_null_OMPFinalClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPFinalClause(From) ? cast_OMPFinalClause(From) : null;
  }

  public static boolean isa_OMPFirstprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPFirstprivateClause.class, From.$star());
  }

  public static OMPFirstprivateClause cast_OMPFirstprivateClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPFirstprivateClause(From);
    return llvm.cast(OMPFirstprivateClause.class, From.$star());
  }

  public static OMPFirstprivateClause cast_or_null_OMPFirstprivateClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPFirstprivateClause(From);
  }

  public static OMPFirstprivateClause dyn_cast_OMPFirstprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static OMPFirstprivateClause dyn_cast_or_null_OMPFirstprivateClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static boolean isa_OMPFirstprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPFirstprivateClause.classof(From);
  }

  public static OMPFirstprivateClause cast_OMPFirstprivateClause(OMPClause/*P*/ From) {
    assert isa_OMPFirstprivateClause(From);
    return (OMPFirstprivateClause) From;
  }

  public static OMPFirstprivateClause cast_or_null_OMPFirstprivateClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPFirstprivateClause(From);
  }

  public static OMPFirstprivateClause dyn_cast_OMPFirstprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static OMPFirstprivateClause dyn_cast_or_null_OMPFirstprivateClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static boolean isa_OMPFirstprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPFirstprivateClause.class, From.$deref());
  }

  public static OMPFirstprivateClause cast_OMPFirstprivateClause(type$ref<?>/*P*/ From) {
    assert isa_OMPFirstprivateClause(From);
    return llvm.cast(OMPFirstprivateClause.class, From.$deref());
  }

  public static OMPFirstprivateClause cast_or_null_OMPFirstprivateClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPFirstprivateClause(From);
  }

  public static OMPFirstprivateClause dyn_cast_OMPFirstprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static OMPFirstprivateClause dyn_cast_or_null_OMPFirstprivateClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPFirstprivateClause(From) ? cast_OMPFirstprivateClause(From) : null;
  }

  public static boolean isa_OMPFlushClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPFlushClause.class, From.$deref());
  }

  public static OMPFlushClause cast_OMPFlushClause(type$ref<?>/*P*/ From) {
    assert isa_OMPFlushClause(From);
    return llvm.cast(OMPFlushClause.class, From.$deref());
  }

  public static OMPFlushClause cast_or_null_OMPFlushClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPFlushClause(From);
  }

  public static OMPFlushClause dyn_cast_OMPFlushClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static OMPFlushClause dyn_cast_or_null_OMPFlushClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static boolean isa_OMPFlushClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPFlushClause.class, From.$star());
  }

  public static OMPFlushClause cast_OMPFlushClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPFlushClause(From);
    return llvm.cast(OMPFlushClause.class, From.$star());
  }

  public static OMPFlushClause cast_or_null_OMPFlushClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPFlushClause(From);
  }

  public static OMPFlushClause dyn_cast_OMPFlushClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static OMPFlushClause dyn_cast_or_null_OMPFlushClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static boolean isa_OMPFlushClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPFlushClause.classof(From);
  }

  public static OMPFlushClause cast_OMPFlushClause(OMPClause/*P*/ From) {
    assert isa_OMPFlushClause(From);
    return (OMPFlushClause) From;
  }

  public static OMPFlushClause cast_or_null_OMPFlushClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPFlushClause(From);
  }

  public static OMPFlushClause dyn_cast_OMPFlushClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static OMPFlushClause dyn_cast_or_null_OMPFlushClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPFlushClause(From) ? cast_OMPFlushClause(From) : null;
  }

  public static boolean isa_OMPFlushDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPFlushDirective.class, From.$star());
  }

  public static OMPFlushDirective cast_OMPFlushDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPFlushDirective(From);
    return llvm.cast(OMPFlushDirective.class, From.$star());
  }

  public static OMPFlushDirective cast_or_null_OMPFlushDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPFlushDirective(From);
  }

  public static OMPFlushDirective dyn_cast_OMPFlushDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static OMPFlushDirective dyn_cast_or_null_OMPFlushDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static boolean isa_OMPFlushDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPFlushDirective.class, From.$deref());
  }

  public static OMPFlushDirective cast_OMPFlushDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPFlushDirective(From);
    return llvm.cast(OMPFlushDirective.class, From.$deref());
  }

  public static OMPFlushDirective cast_or_null_OMPFlushDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPFlushDirective(From);
  }

  public static OMPFlushDirective dyn_cast_OMPFlushDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static OMPFlushDirective dyn_cast_or_null_OMPFlushDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static boolean isa_OMPFlushDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPFlushDirective.classof(From);
  }

  public static OMPFlushDirective cast_OMPFlushDirective(Stmt/*P*/ From) {
    assert isa_OMPFlushDirective(From);
    return (OMPFlushDirective) From;
  }

  public static OMPFlushDirective cast_or_null_OMPFlushDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPFlushDirective(From);
  }

  public static OMPFlushDirective dyn_cast_OMPFlushDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static OMPFlushDirective dyn_cast_or_null_OMPFlushDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPFlushDirective(From) ? cast_OMPFlushDirective(From) : null;
  }

  public static boolean isa_OMPForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPForDirective.class, From.$star());
  }

  public static OMPForDirective cast_OMPForDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPForDirective(From);
    return llvm.cast(OMPForDirective.class, From.$star());
  }

  public static OMPForDirective cast_or_null_OMPForDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPForDirective(From);
  }

  public static OMPForDirective dyn_cast_OMPForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static OMPForDirective dyn_cast_or_null_OMPForDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static boolean isa_OMPForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPForDirective.class, From.$deref());
  }

  public static OMPForDirective cast_OMPForDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPForDirective(From);
    return llvm.cast(OMPForDirective.class, From.$deref());
  }

  public static OMPForDirective cast_or_null_OMPForDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPForDirective(From);
  }

  public static OMPForDirective dyn_cast_OMPForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static OMPForDirective dyn_cast_or_null_OMPForDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static boolean isa_OMPForDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPForDirective.classof(From);
  }

  public static OMPForDirective cast_OMPForDirective(Stmt/*P*/ From) {
    assert isa_OMPForDirective(From);
    return (OMPForDirective) From;
  }

  public static OMPForDirective cast_or_null_OMPForDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPForDirective(From);
  }

  public static OMPForDirective dyn_cast_OMPForDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static OMPForDirective dyn_cast_or_null_OMPForDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPForDirective(From) ? cast_OMPForDirective(From) : null;
  }

  public static boolean isa_OMPForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPForSimdDirective.classof(From);
  }

  public static OMPForSimdDirective cast_OMPForSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPForSimdDirective(From);
    return (OMPForSimdDirective) From;
  }

  public static OMPForSimdDirective cast_or_null_OMPForSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPForSimdDirective(From);
  }

  public static OMPForSimdDirective dyn_cast_OMPForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static OMPForSimdDirective dyn_cast_or_null_OMPForSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static boolean isa_OMPForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPForSimdDirective.class, From.$deref());
  }

  public static OMPForSimdDirective cast_OMPForSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPForSimdDirective(From);
    return llvm.cast(OMPForSimdDirective.class, From.$deref());
  }

  public static OMPForSimdDirective cast_or_null_OMPForSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPForSimdDirective(From);
  }

  public static OMPForSimdDirective dyn_cast_OMPForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static OMPForSimdDirective dyn_cast_or_null_OMPForSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static boolean isa_OMPForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPForSimdDirective.class, From.$star());
  }

  public static OMPForSimdDirective cast_OMPForSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPForSimdDirective(From);
    return llvm.cast(OMPForSimdDirective.class, From.$star());
  }

  public static OMPForSimdDirective cast_or_null_OMPForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPForSimdDirective(From);
  }

  public static OMPForSimdDirective dyn_cast_OMPForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static OMPForSimdDirective dyn_cast_or_null_OMPForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPForSimdDirective(From) ? cast_OMPForSimdDirective(From) : null;
  }

  public static boolean isa_OMPFromClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPFromClause.class, From.$star());
  }

  public static OMPFromClause cast_OMPFromClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPFromClause(From);
    return llvm.cast(OMPFromClause.class, From.$star());
  }

  public static OMPFromClause cast_or_null_OMPFromClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPFromClause(From);
  }

  public static OMPFromClause dyn_cast_OMPFromClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static OMPFromClause dyn_cast_or_null_OMPFromClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static boolean isa_OMPFromClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPFromClause.classof(From);
  }

  public static OMPFromClause cast_OMPFromClause(OMPClause/*P*/ From) {
    assert isa_OMPFromClause(From);
    return (OMPFromClause) From;
  }

  public static OMPFromClause cast_or_null_OMPFromClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPFromClause(From);
  }

  public static OMPFromClause dyn_cast_OMPFromClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static OMPFromClause dyn_cast_or_null_OMPFromClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static boolean isa_OMPFromClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPFromClause.class, From.$deref());
  }

  public static OMPFromClause cast_OMPFromClause(type$ref<?>/*P*/ From) {
    assert isa_OMPFromClause(From);
    return llvm.cast(OMPFromClause.class, From.$deref());
  }

  public static OMPFromClause cast_or_null_OMPFromClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPFromClause(From);
  }

  public static OMPFromClause dyn_cast_OMPFromClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static OMPFromClause dyn_cast_or_null_OMPFromClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPFromClause(From) ? cast_OMPFromClause(From) : null;
  }

  public static boolean isa_OMPGrainsizeClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPGrainsizeClause.classof(From);
  }

  public static OMPGrainsizeClause cast_OMPGrainsizeClause(OMPClause/*P*/ From) {
    assert isa_OMPGrainsizeClause(From);
    return (OMPGrainsizeClause) From;
  }

  public static OMPGrainsizeClause cast_or_null_OMPGrainsizeClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPGrainsizeClause(From);
  }

  public static OMPGrainsizeClause dyn_cast_OMPGrainsizeClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static OMPGrainsizeClause dyn_cast_or_null_OMPGrainsizeClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static boolean isa_OMPGrainsizeClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPGrainsizeClause.class, From.$star());
  }

  public static OMPGrainsizeClause cast_OMPGrainsizeClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPGrainsizeClause(From);
    return llvm.cast(OMPGrainsizeClause.class, From.$star());
  }

  public static OMPGrainsizeClause cast_or_null_OMPGrainsizeClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPGrainsizeClause(From);
  }

  public static OMPGrainsizeClause dyn_cast_OMPGrainsizeClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static OMPGrainsizeClause dyn_cast_or_null_OMPGrainsizeClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static boolean isa_OMPGrainsizeClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPGrainsizeClause.class, From.$deref());
  }

  public static OMPGrainsizeClause cast_OMPGrainsizeClause(type$ref<?>/*P*/ From) {
    assert isa_OMPGrainsizeClause(From);
    return llvm.cast(OMPGrainsizeClause.class, From.$deref());
  }

  public static OMPGrainsizeClause cast_or_null_OMPGrainsizeClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPGrainsizeClause(From);
  }

  public static OMPGrainsizeClause dyn_cast_OMPGrainsizeClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static OMPGrainsizeClause dyn_cast_or_null_OMPGrainsizeClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPGrainsizeClause(From) ? cast_OMPGrainsizeClause(From) : null;
  }

  public static boolean isa_OMPHintClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPHintClause.class, From.$star());
  }

  public static OMPHintClause cast_OMPHintClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPHintClause(From);
    return llvm.cast(OMPHintClause.class, From.$star());
  }

  public static OMPHintClause cast_or_null_OMPHintClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPHintClause(From);
  }

  public static OMPHintClause dyn_cast_OMPHintClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static OMPHintClause dyn_cast_or_null_OMPHintClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static boolean isa_OMPHintClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPHintClause.classof(From);
  }

  public static OMPHintClause cast_OMPHintClause(OMPClause/*P*/ From) {
    assert isa_OMPHintClause(From);
    return (OMPHintClause) From;
  }

  public static OMPHintClause cast_or_null_OMPHintClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPHintClause(From);
  }

  public static OMPHintClause dyn_cast_OMPHintClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static OMPHintClause dyn_cast_or_null_OMPHintClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static boolean isa_OMPHintClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPHintClause.class, From.$deref());
  }

  public static OMPHintClause cast_OMPHintClause(type$ref<?>/*P*/ From) {
    assert isa_OMPHintClause(From);
    return llvm.cast(OMPHintClause.class, From.$deref());
  }

  public static OMPHintClause cast_or_null_OMPHintClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPHintClause(From);
  }

  public static OMPHintClause dyn_cast_OMPHintClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static OMPHintClause dyn_cast_or_null_OMPHintClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPHintClause(From) ? cast_OMPHintClause(From) : null;
  }

  public static boolean isa_OMPIfClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPIfClause.classof(From);
  }

  public static OMPIfClause cast_OMPIfClause(OMPClause/*P*/ From) {
    assert isa_OMPIfClause(From);
    return (OMPIfClause) From;
  }

  public static OMPIfClause cast_or_null_OMPIfClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPIfClause(From);
  }

  public static OMPIfClause dyn_cast_OMPIfClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static OMPIfClause dyn_cast_or_null_OMPIfClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static boolean isa_OMPIfClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPIfClause.class, From.$star());
  }

  public static OMPIfClause cast_OMPIfClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPIfClause(From);
    return llvm.cast(OMPIfClause.class, From.$star());
  }

  public static OMPIfClause cast_or_null_OMPIfClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPIfClause(From);
  }

  public static OMPIfClause dyn_cast_OMPIfClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static OMPIfClause dyn_cast_or_null_OMPIfClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static boolean isa_OMPIfClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPIfClause.class, From.$deref());
  }

  public static OMPIfClause cast_OMPIfClause(type$ref<?>/*P*/ From) {
    assert isa_OMPIfClause(From);
    return llvm.cast(OMPIfClause.class, From.$deref());
  }

  public static OMPIfClause cast_or_null_OMPIfClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPIfClause(From);
  }

  public static OMPIfClause dyn_cast_OMPIfClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static OMPIfClause dyn_cast_or_null_OMPIfClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPIfClause(From) ? cast_OMPIfClause(From) : null;
  }

  public static boolean isa_OMPIsDevicePtrClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPIsDevicePtrClause.class, From.$deref());
  }

  public static OMPIsDevicePtrClause cast_OMPIsDevicePtrClause(type$ref<?>/*P*/ From) {
    assert isa_OMPIsDevicePtrClause(From);
    return llvm.cast(OMPIsDevicePtrClause.class, From.$deref());
  }

  public static OMPIsDevicePtrClause cast_or_null_OMPIsDevicePtrClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPIsDevicePtrClause(From);
  }

  public static OMPIsDevicePtrClause dyn_cast_OMPIsDevicePtrClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static OMPIsDevicePtrClause dyn_cast_or_null_OMPIsDevicePtrClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPIsDevicePtrClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPIsDevicePtrClause.classof(From);
  }

  public static OMPIsDevicePtrClause cast_OMPIsDevicePtrClause(OMPClause/*P*/ From) {
    assert isa_OMPIsDevicePtrClause(From);
    return (OMPIsDevicePtrClause) From;
  }

  public static OMPIsDevicePtrClause cast_or_null_OMPIsDevicePtrClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPIsDevicePtrClause(From);
  }

  public static OMPIsDevicePtrClause dyn_cast_OMPIsDevicePtrClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static OMPIsDevicePtrClause dyn_cast_or_null_OMPIsDevicePtrClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPIsDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPIsDevicePtrClause.class, From.$star());
  }

  public static OMPIsDevicePtrClause cast_OMPIsDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPIsDevicePtrClause(From);
    return llvm.cast(OMPIsDevicePtrClause.class, From.$star());
  }

  public static OMPIsDevicePtrClause cast_or_null_OMPIsDevicePtrClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPIsDevicePtrClause(From);
  }

  public static OMPIsDevicePtrClause dyn_cast_OMPIsDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static OMPIsDevicePtrClause dyn_cast_or_null_OMPIsDevicePtrClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPIsDevicePtrClause(From) ? cast_OMPIsDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPLastprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPLastprivateClause.class, From.$deref());
  }

  public static OMPLastprivateClause cast_OMPLastprivateClause(type$ref<?>/*P*/ From) {
    assert isa_OMPLastprivateClause(From);
    return llvm.cast(OMPLastprivateClause.class, From.$deref());
  }

  public static OMPLastprivateClause cast_or_null_OMPLastprivateClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPLastprivateClause(From);
  }

  public static OMPLastprivateClause dyn_cast_OMPLastprivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static OMPLastprivateClause dyn_cast_or_null_OMPLastprivateClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static boolean isa_OMPLastprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPLastprivateClause.classof(From);
  }

  public static OMPLastprivateClause cast_OMPLastprivateClause(OMPClause/*P*/ From) {
    assert isa_OMPLastprivateClause(From);
    return (OMPLastprivateClause) From;
  }

  public static OMPLastprivateClause cast_or_null_OMPLastprivateClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPLastprivateClause(From);
  }

  public static OMPLastprivateClause dyn_cast_OMPLastprivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static OMPLastprivateClause dyn_cast_or_null_OMPLastprivateClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static boolean isa_OMPLastprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPLastprivateClause.class, From.$star());
  }

  public static OMPLastprivateClause cast_OMPLastprivateClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPLastprivateClause(From);
    return llvm.cast(OMPLastprivateClause.class, From.$star());
  }

  public static OMPLastprivateClause cast_or_null_OMPLastprivateClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPLastprivateClause(From);
  }

  public static OMPLastprivateClause dyn_cast_OMPLastprivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static OMPLastprivateClause dyn_cast_or_null_OMPLastprivateClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPLastprivateClause(From) ? cast_OMPLastprivateClause(From) : null;
  }

  public static boolean isa_OMPLinearClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPLinearClause.class, From.$deref());
  }

  public static OMPLinearClause cast_OMPLinearClause(type$ref<?>/*P*/ From) {
    assert isa_OMPLinearClause(From);
    return llvm.cast(OMPLinearClause.class, From.$deref());
  }

  public static OMPLinearClause cast_or_null_OMPLinearClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPLinearClause(From);
  }

  public static OMPLinearClause dyn_cast_OMPLinearClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static OMPLinearClause dyn_cast_or_null_OMPLinearClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static boolean isa_OMPLinearClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPLinearClause.classof(From);
  }

  public static OMPLinearClause cast_OMPLinearClause(OMPClause/*P*/ From) {
    assert isa_OMPLinearClause(From);
    return (OMPLinearClause) From;
  }

  public static OMPLinearClause cast_or_null_OMPLinearClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPLinearClause(From);
  }

  public static OMPLinearClause dyn_cast_OMPLinearClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static OMPLinearClause dyn_cast_or_null_OMPLinearClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static boolean isa_OMPLinearClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPLinearClause.class, From.$star());
  }

  public static OMPLinearClause cast_OMPLinearClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPLinearClause(From);
    return llvm.cast(OMPLinearClause.class, From.$star());
  }

  public static OMPLinearClause cast_or_null_OMPLinearClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPLinearClause(From);
  }

  public static OMPLinearClause dyn_cast_OMPLinearClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static OMPLinearClause dyn_cast_or_null_OMPLinearClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPLinearClause(From) ? cast_OMPLinearClause(From) : null;
  }

  public static boolean isa_OMPLoopDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPLoopDirective.class, From.$star());
  }

  public static OMPLoopDirective cast_OMPLoopDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPLoopDirective(From);
    return llvm.cast(OMPLoopDirective.class, From.$star());
  }

  public static OMPLoopDirective cast_or_null_OMPLoopDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPLoopDirective(From);
  }

  public static OMPLoopDirective dyn_cast_OMPLoopDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static OMPLoopDirective dyn_cast_or_null_OMPLoopDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static boolean isa_OMPLoopDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPLoopDirective.class, From.$deref());
  }

  public static OMPLoopDirective cast_OMPLoopDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPLoopDirective(From);
    return llvm.cast(OMPLoopDirective.class, From.$deref());
  }

  public static OMPLoopDirective cast_or_null_OMPLoopDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPLoopDirective(From);
  }

  public static OMPLoopDirective dyn_cast_OMPLoopDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static OMPLoopDirective dyn_cast_or_null_OMPLoopDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static boolean isa_OMPLoopDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPLoopDirective.classof(From);
  }

  public static OMPLoopDirective cast_OMPLoopDirective(Stmt/*P*/ From) {
    assert isa_OMPLoopDirective(From);
    return (OMPLoopDirective) From;
  }

  public static OMPLoopDirective cast_or_null_OMPLoopDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPLoopDirective(From);
  }

  public static OMPLoopDirective dyn_cast_OMPLoopDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static OMPLoopDirective dyn_cast_or_null_OMPLoopDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPLoopDirective(From) ? cast_OMPLoopDirective(From) : null;
  }

  public static boolean isa_OMPMapClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPMapClause.class, From.$star());
  }

  public static OMPMapClause cast_OMPMapClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPMapClause(From);
    return llvm.cast(OMPMapClause.class, From.$star());
  }

  public static OMPMapClause cast_or_null_OMPMapClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPMapClause(From);
  }

  public static OMPMapClause dyn_cast_OMPMapClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static OMPMapClause dyn_cast_or_null_OMPMapClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static boolean isa_OMPMapClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPMapClause.class, From.$deref());
  }

  public static OMPMapClause cast_OMPMapClause(type$ref<?>/*P*/ From) {
    assert isa_OMPMapClause(From);
    return llvm.cast(OMPMapClause.class, From.$deref());
  }

  public static OMPMapClause cast_or_null_OMPMapClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPMapClause(From);
  }

  public static OMPMapClause dyn_cast_OMPMapClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static OMPMapClause dyn_cast_or_null_OMPMapClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static boolean isa_OMPMapClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPMapClause.classof(From);
  }

  public static OMPMapClause cast_OMPMapClause(OMPClause/*P*/ From) {
    assert isa_OMPMapClause(From);
    return (OMPMapClause) From;
  }

  public static OMPMapClause cast_or_null_OMPMapClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPMapClause(From);
  }

  public static OMPMapClause dyn_cast_OMPMapClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static OMPMapClause dyn_cast_or_null_OMPMapClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPMapClause(From) ? cast_OMPMapClause(From) : null;
  }

  public static boolean isa_OMPMappableExprListClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPMappableExprListClause.class, From.$deref());
  }

  public static OMPMappableExprListClause cast_OMPMappableExprListClause(type$ref<?>/*P*/ From) {
    assert isa_OMPMappableExprListClause(From);
    return llvm.cast(OMPMappableExprListClause.class, From.$deref());
  }

  public static OMPMappableExprListClause cast_or_null_OMPMappableExprListClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPMappableExprListClause(From);
  }

  public static OMPMappableExprListClause dyn_cast_OMPMappableExprListClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static OMPMappableExprListClause dyn_cast_or_null_OMPMappableExprListClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static boolean isa_OMPMappableExprListClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPMappableExprListClause.classof(From);
  }

  public static OMPMappableExprListClause cast_OMPMappableExprListClause(OMPClause/*P*/ From) {
    assert isa_OMPMappableExprListClause(From);
    return (OMPMappableExprListClause) From;
  }

  public static OMPMappableExprListClause cast_or_null_OMPMappableExprListClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPMappableExprListClause(From);
  }

  public static OMPMappableExprListClause dyn_cast_OMPMappableExprListClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static OMPMappableExprListClause dyn_cast_or_null_OMPMappableExprListClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static boolean isa_OMPMappableExprListClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPMappableExprListClause.class, From.$star());
  }

  public static OMPMappableExprListClause cast_OMPMappableExprListClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPMappableExprListClause(From);
    return llvm.cast(OMPMappableExprListClause.class, From.$star());
  }

  public static OMPMappableExprListClause cast_or_null_OMPMappableExprListClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPMappableExprListClause(From);
  }

  public static OMPMappableExprListClause dyn_cast_OMPMappableExprListClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static OMPMappableExprListClause dyn_cast_or_null_OMPMappableExprListClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPMappableExprListClause(From) ? cast_OMPMappableExprListClause(From) : null;
  }

  public static boolean isa_OMPMasterDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPMasterDirective.class, From.$deref());
  }

  public static OMPMasterDirective cast_OMPMasterDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPMasterDirective(From);
    return llvm.cast(OMPMasterDirective.class, From.$deref());
  }

  public static OMPMasterDirective cast_or_null_OMPMasterDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPMasterDirective(From);
  }

  public static OMPMasterDirective dyn_cast_OMPMasterDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static OMPMasterDirective dyn_cast_or_null_OMPMasterDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static boolean isa_OMPMasterDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPMasterDirective.class, From.$star());
  }

  public static OMPMasterDirective cast_OMPMasterDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPMasterDirective(From);
    return llvm.cast(OMPMasterDirective.class, From.$star());
  }

  public static OMPMasterDirective cast_or_null_OMPMasterDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPMasterDirective(From);
  }

  public static OMPMasterDirective dyn_cast_OMPMasterDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static OMPMasterDirective dyn_cast_or_null_OMPMasterDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static boolean isa_OMPMasterDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPMasterDirective.classof(From);
  }

  public static OMPMasterDirective cast_OMPMasterDirective(Stmt/*P*/ From) {
    assert isa_OMPMasterDirective(From);
    return (OMPMasterDirective) From;
  }

  public static OMPMasterDirective cast_or_null_OMPMasterDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPMasterDirective(From);
  }

  public static OMPMasterDirective dyn_cast_OMPMasterDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static OMPMasterDirective dyn_cast_or_null_OMPMasterDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPMasterDirective(From) ? cast_OMPMasterDirective(From) : null;
  }

  public static boolean isa_OMPMergeableClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPMergeableClause.class, From.$star());
  }

  public static OMPMergeableClause cast_OMPMergeableClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPMergeableClause(From);
    return llvm.cast(OMPMergeableClause.class, From.$star());
  }

  public static OMPMergeableClause cast_or_null_OMPMergeableClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPMergeableClause(From);
  }

  public static OMPMergeableClause dyn_cast_OMPMergeableClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static OMPMergeableClause dyn_cast_or_null_OMPMergeableClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static boolean isa_OMPMergeableClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPMergeableClause.class, From.$deref());
  }

  public static OMPMergeableClause cast_OMPMergeableClause(type$ref<?>/*P*/ From) {
    assert isa_OMPMergeableClause(From);
    return llvm.cast(OMPMergeableClause.class, From.$deref());
  }

  public static OMPMergeableClause cast_or_null_OMPMergeableClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPMergeableClause(From);
  }

  public static OMPMergeableClause dyn_cast_OMPMergeableClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static OMPMergeableClause dyn_cast_or_null_OMPMergeableClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static boolean isa_OMPMergeableClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPMergeableClause.classof(From);
  }

  public static OMPMergeableClause cast_OMPMergeableClause(OMPClause/*P*/ From) {
    assert isa_OMPMergeableClause(From);
    return (OMPMergeableClause) From;
  }

  public static OMPMergeableClause cast_or_null_OMPMergeableClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPMergeableClause(From);
  }

  public static OMPMergeableClause dyn_cast_OMPMergeableClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static OMPMergeableClause dyn_cast_or_null_OMPMergeableClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPMergeableClause(From) ? cast_OMPMergeableClause(From) : null;
  }

  public static boolean isa_OMPNogroupClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPNogroupClause.classof(From);
  }

  public static OMPNogroupClause cast_OMPNogroupClause(OMPClause/*P*/ From) {
    assert isa_OMPNogroupClause(From);
    return (OMPNogroupClause) From;
  }

  public static OMPNogroupClause cast_or_null_OMPNogroupClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPNogroupClause(From);
  }

  public static OMPNogroupClause dyn_cast_OMPNogroupClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static OMPNogroupClause dyn_cast_or_null_OMPNogroupClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static boolean isa_OMPNogroupClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPNogroupClause.class, From.$deref());
  }

  public static OMPNogroupClause cast_OMPNogroupClause(type$ref<?>/*P*/ From) {
    assert isa_OMPNogroupClause(From);
    return llvm.cast(OMPNogroupClause.class, From.$deref());
  }

  public static OMPNogroupClause cast_or_null_OMPNogroupClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPNogroupClause(From);
  }

  public static OMPNogroupClause dyn_cast_OMPNogroupClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static OMPNogroupClause dyn_cast_or_null_OMPNogroupClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static boolean isa_OMPNogroupClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPNogroupClause.class, From.$star());
  }

  public static OMPNogroupClause cast_OMPNogroupClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPNogroupClause(From);
    return llvm.cast(OMPNogroupClause.class, From.$star());
  }

  public static OMPNogroupClause cast_or_null_OMPNogroupClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPNogroupClause(From);
  }

  public static OMPNogroupClause dyn_cast_OMPNogroupClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static OMPNogroupClause dyn_cast_or_null_OMPNogroupClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPNogroupClause(From) ? cast_OMPNogroupClause(From) : null;
  }

  public static boolean isa_OMPNowaitClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPNowaitClause.class, From.$deref());
  }

  public static OMPNowaitClause cast_OMPNowaitClause(type$ref<?>/*P*/ From) {
    assert isa_OMPNowaitClause(From);
    return llvm.cast(OMPNowaitClause.class, From.$deref());
  }

  public static OMPNowaitClause cast_or_null_OMPNowaitClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPNowaitClause(From);
  }

  public static OMPNowaitClause dyn_cast_OMPNowaitClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static OMPNowaitClause dyn_cast_or_null_OMPNowaitClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static boolean isa_OMPNowaitClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPNowaitClause.classof(From);
  }

  public static OMPNowaitClause cast_OMPNowaitClause(OMPClause/*P*/ From) {
    assert isa_OMPNowaitClause(From);
    return (OMPNowaitClause) From;
  }

  public static OMPNowaitClause cast_or_null_OMPNowaitClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPNowaitClause(From);
  }

  public static OMPNowaitClause dyn_cast_OMPNowaitClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static OMPNowaitClause dyn_cast_or_null_OMPNowaitClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static boolean isa_OMPNowaitClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPNowaitClause.class, From.$star());
  }

  public static OMPNowaitClause cast_OMPNowaitClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPNowaitClause(From);
    return llvm.cast(OMPNowaitClause.class, From.$star());
  }

  public static OMPNowaitClause cast_or_null_OMPNowaitClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPNowaitClause(From);
  }

  public static OMPNowaitClause dyn_cast_OMPNowaitClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static OMPNowaitClause dyn_cast_or_null_OMPNowaitClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPNowaitClause(From) ? cast_OMPNowaitClause(From) : null;
  }

  public static boolean isa_OMPNumTasksClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPNumTasksClause.classof(From);
  }

  public static OMPNumTasksClause cast_OMPNumTasksClause(OMPClause/*P*/ From) {
    assert isa_OMPNumTasksClause(From);
    return (OMPNumTasksClause) From;
  }

  public static OMPNumTasksClause cast_or_null_OMPNumTasksClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPNumTasksClause(From);
  }

  public static OMPNumTasksClause dyn_cast_OMPNumTasksClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static OMPNumTasksClause dyn_cast_or_null_OMPNumTasksClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static boolean isa_OMPNumTasksClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPNumTasksClause.class, From.$deref());
  }

  public static OMPNumTasksClause cast_OMPNumTasksClause(type$ref<?>/*P*/ From) {
    assert isa_OMPNumTasksClause(From);
    return llvm.cast(OMPNumTasksClause.class, From.$deref());
  }

  public static OMPNumTasksClause cast_or_null_OMPNumTasksClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPNumTasksClause(From);
  }

  public static OMPNumTasksClause dyn_cast_OMPNumTasksClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static OMPNumTasksClause dyn_cast_or_null_OMPNumTasksClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static boolean isa_OMPNumTasksClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPNumTasksClause.class, From.$star());
  }

  public static OMPNumTasksClause cast_OMPNumTasksClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPNumTasksClause(From);
    return llvm.cast(OMPNumTasksClause.class, From.$star());
  }

  public static OMPNumTasksClause cast_or_null_OMPNumTasksClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPNumTasksClause(From);
  }

  public static OMPNumTasksClause dyn_cast_OMPNumTasksClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static OMPNumTasksClause dyn_cast_or_null_OMPNumTasksClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPNumTasksClause(From) ? cast_OMPNumTasksClause(From) : null;
  }

  public static boolean isa_OMPNumTeamsClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPNumTeamsClause.classof(From);
  }

  public static OMPNumTeamsClause cast_OMPNumTeamsClause(OMPClause/*P*/ From) {
    assert isa_OMPNumTeamsClause(From);
    return (OMPNumTeamsClause) From;
  }

  public static OMPNumTeamsClause cast_or_null_OMPNumTeamsClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPNumTeamsClause(From);
  }

  public static OMPNumTeamsClause dyn_cast_OMPNumTeamsClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static OMPNumTeamsClause dyn_cast_or_null_OMPNumTeamsClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static boolean isa_OMPNumTeamsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPNumTeamsClause.class, From.$star());
  }

  public static OMPNumTeamsClause cast_OMPNumTeamsClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPNumTeamsClause(From);
    return llvm.cast(OMPNumTeamsClause.class, From.$star());
  }

  public static OMPNumTeamsClause cast_or_null_OMPNumTeamsClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPNumTeamsClause(From);
  }

  public static OMPNumTeamsClause dyn_cast_OMPNumTeamsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static OMPNumTeamsClause dyn_cast_or_null_OMPNumTeamsClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static boolean isa_OMPNumTeamsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPNumTeamsClause.class, From.$deref());
  }

  public static OMPNumTeamsClause cast_OMPNumTeamsClause(type$ref<?>/*P*/ From) {
    assert isa_OMPNumTeamsClause(From);
    return llvm.cast(OMPNumTeamsClause.class, From.$deref());
  }

  public static OMPNumTeamsClause cast_or_null_OMPNumTeamsClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPNumTeamsClause(From);
  }

  public static OMPNumTeamsClause dyn_cast_OMPNumTeamsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static OMPNumTeamsClause dyn_cast_or_null_OMPNumTeamsClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPNumTeamsClause(From) ? cast_OMPNumTeamsClause(From) : null;
  }

  public static boolean isa_OMPNumThreadsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPNumThreadsClause.class, From.$star());
  }

  public static OMPNumThreadsClause cast_OMPNumThreadsClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPNumThreadsClause(From);
    return llvm.cast(OMPNumThreadsClause.class, From.$star());
  }

  public static OMPNumThreadsClause cast_or_null_OMPNumThreadsClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPNumThreadsClause(From);
  }

  public static OMPNumThreadsClause dyn_cast_OMPNumThreadsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static OMPNumThreadsClause dyn_cast_or_null_OMPNumThreadsClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static boolean isa_OMPNumThreadsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPNumThreadsClause.class, From.$deref());
  }

  public static OMPNumThreadsClause cast_OMPNumThreadsClause(type$ref<?>/*P*/ From) {
    assert isa_OMPNumThreadsClause(From);
    return llvm.cast(OMPNumThreadsClause.class, From.$deref());
  }

  public static OMPNumThreadsClause cast_or_null_OMPNumThreadsClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPNumThreadsClause(From);
  }

  public static OMPNumThreadsClause dyn_cast_OMPNumThreadsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static OMPNumThreadsClause dyn_cast_or_null_OMPNumThreadsClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static boolean isa_OMPNumThreadsClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPNumThreadsClause.classof(From);
  }

  public static OMPNumThreadsClause cast_OMPNumThreadsClause(OMPClause/*P*/ From) {
    assert isa_OMPNumThreadsClause(From);
    return (OMPNumThreadsClause) From;
  }

  public static OMPNumThreadsClause cast_or_null_OMPNumThreadsClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPNumThreadsClause(From);
  }

  public static OMPNumThreadsClause dyn_cast_OMPNumThreadsClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static OMPNumThreadsClause dyn_cast_or_null_OMPNumThreadsClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPNumThreadsClause(From) ? cast_OMPNumThreadsClause(From) : null;
  }

  public static boolean isa_OMPOrderedClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPOrderedClause.classof(From);
  }

  public static OMPOrderedClause cast_OMPOrderedClause(OMPClause/*P*/ From) {
    assert isa_OMPOrderedClause(From);
    return (OMPOrderedClause) From;
  }

  public static OMPOrderedClause cast_or_null_OMPOrderedClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPOrderedClause(From);
  }

  public static OMPOrderedClause dyn_cast_OMPOrderedClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static OMPOrderedClause dyn_cast_or_null_OMPOrderedClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static boolean isa_OMPOrderedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPOrderedClause.class, From.$deref());
  }

  public static OMPOrderedClause cast_OMPOrderedClause(type$ref<?>/*P*/ From) {
    assert isa_OMPOrderedClause(From);
    return llvm.cast(OMPOrderedClause.class, From.$deref());
  }

  public static OMPOrderedClause cast_or_null_OMPOrderedClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPOrderedClause(From);
  }

  public static OMPOrderedClause dyn_cast_OMPOrderedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static OMPOrderedClause dyn_cast_or_null_OMPOrderedClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static boolean isa_OMPOrderedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPOrderedClause.class, From.$star());
  }

  public static OMPOrderedClause cast_OMPOrderedClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPOrderedClause(From);
    return llvm.cast(OMPOrderedClause.class, From.$star());
  }

  public static OMPOrderedClause cast_or_null_OMPOrderedClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPOrderedClause(From);
  }

  public static OMPOrderedClause dyn_cast_OMPOrderedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static OMPOrderedClause dyn_cast_or_null_OMPOrderedClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPOrderedClause(From) ? cast_OMPOrderedClause(From) : null;
  }

  public static boolean isa_OMPOrderedDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPOrderedDirective.classof(From);
  }

  public static OMPOrderedDirective cast_OMPOrderedDirective(Stmt/*P*/ From) {
    assert isa_OMPOrderedDirective(From);
    return (OMPOrderedDirective) From;
  }

  public static OMPOrderedDirective cast_or_null_OMPOrderedDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPOrderedDirective(From);
  }

  public static OMPOrderedDirective dyn_cast_OMPOrderedDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static OMPOrderedDirective dyn_cast_or_null_OMPOrderedDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static boolean isa_OMPOrderedDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPOrderedDirective.class, From.$star());
  }

  public static OMPOrderedDirective cast_OMPOrderedDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPOrderedDirective(From);
    return llvm.cast(OMPOrderedDirective.class, From.$star());
  }

  public static OMPOrderedDirective cast_or_null_OMPOrderedDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPOrderedDirective(From);
  }

  public static OMPOrderedDirective dyn_cast_OMPOrderedDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static OMPOrderedDirective dyn_cast_or_null_OMPOrderedDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static boolean isa_OMPOrderedDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPOrderedDirective.class, From.$deref());
  }

  public static OMPOrderedDirective cast_OMPOrderedDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPOrderedDirective(From);
    return llvm.cast(OMPOrderedDirective.class, From.$deref());
  }

  public static OMPOrderedDirective cast_or_null_OMPOrderedDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPOrderedDirective(From);
  }

  public static OMPOrderedDirective dyn_cast_OMPOrderedDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static OMPOrderedDirective dyn_cast_or_null_OMPOrderedDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPOrderedDirective(From) ? cast_OMPOrderedDirective(From) : null;
  }

  public static boolean isa_OMPParallelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPParallelDirective.class, From.$deref());
  }

  public static OMPParallelDirective cast_OMPParallelDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPParallelDirective(From);
    return llvm.cast(OMPParallelDirective.class, From.$deref());
  }

  public static OMPParallelDirective cast_or_null_OMPParallelDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPParallelDirective(From);
  }

  public static OMPParallelDirective dyn_cast_OMPParallelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static OMPParallelDirective dyn_cast_or_null_OMPParallelDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static boolean isa_OMPParallelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPParallelDirective.class, From.$star());
  }

  public static OMPParallelDirective cast_OMPParallelDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPParallelDirective(From);
    return llvm.cast(OMPParallelDirective.class, From.$star());
  }

  public static OMPParallelDirective cast_or_null_OMPParallelDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPParallelDirective(From);
  }

  public static OMPParallelDirective dyn_cast_OMPParallelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static OMPParallelDirective dyn_cast_or_null_OMPParallelDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static boolean isa_OMPParallelDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPParallelDirective.classof(From);
  }

  public static OMPParallelDirective cast_OMPParallelDirective(Stmt/*P*/ From) {
    assert isa_OMPParallelDirective(From);
    return (OMPParallelDirective) From;
  }

  public static OMPParallelDirective cast_or_null_OMPParallelDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPParallelDirective(From);
  }

  public static OMPParallelDirective dyn_cast_OMPParallelDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static OMPParallelDirective dyn_cast_or_null_OMPParallelDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPParallelDirective(From) ? cast_OMPParallelDirective(From) : null;
  }

  public static boolean isa_OMPParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPParallelForDirective.classof(From);
  }

  public static OMPParallelForDirective cast_OMPParallelForDirective(Stmt/*P*/ From) {
    assert isa_OMPParallelForDirective(From);
    return (OMPParallelForDirective) From;
  }

  public static OMPParallelForDirective cast_or_null_OMPParallelForDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPParallelForDirective(From);
  }

  public static OMPParallelForDirective dyn_cast_OMPParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static OMPParallelForDirective dyn_cast_or_null_OMPParallelForDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static boolean isa_OMPParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPParallelForDirective.class, From.$deref());
  }

  public static OMPParallelForDirective cast_OMPParallelForDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPParallelForDirective(From);
    return llvm.cast(OMPParallelForDirective.class, From.$deref());
  }

  public static OMPParallelForDirective cast_or_null_OMPParallelForDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPParallelForDirective(From);
  }

  public static OMPParallelForDirective dyn_cast_OMPParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static OMPParallelForDirective dyn_cast_or_null_OMPParallelForDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static boolean isa_OMPParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPParallelForDirective.class, From.$star());
  }

  public static OMPParallelForDirective cast_OMPParallelForDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPParallelForDirective(From);
    return llvm.cast(OMPParallelForDirective.class, From.$star());
  }

  public static OMPParallelForDirective cast_or_null_OMPParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPParallelForDirective(From);
  }

  public static OMPParallelForDirective dyn_cast_OMPParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static OMPParallelForDirective dyn_cast_or_null_OMPParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPParallelForDirective(From) ? cast_OMPParallelForDirective(From) : null;
  }

  public static boolean isa_OMPParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPParallelForSimdDirective.class, From.$star());
  }

  public static OMPParallelForSimdDirective cast_OMPParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPParallelForSimdDirective(From);
    return llvm.cast(OMPParallelForSimdDirective.class, From.$star());
  }

  public static OMPParallelForSimdDirective cast_or_null_OMPParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPParallelForSimdDirective(From);
  }

  public static OMPParallelForSimdDirective dyn_cast_OMPParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static OMPParallelForSimdDirective dyn_cast_or_null_OMPParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPParallelForSimdDirective.classof(From);
  }

  public static OMPParallelForSimdDirective cast_OMPParallelForSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPParallelForSimdDirective(From);
    return (OMPParallelForSimdDirective) From;
  }

  public static OMPParallelForSimdDirective cast_or_null_OMPParallelForSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPParallelForSimdDirective(From);
  }

  public static OMPParallelForSimdDirective dyn_cast_OMPParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static OMPParallelForSimdDirective dyn_cast_or_null_OMPParallelForSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPParallelForSimdDirective.class, From.$deref());
  }

  public static OMPParallelForSimdDirective cast_OMPParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPParallelForSimdDirective(From);
    return llvm.cast(OMPParallelForSimdDirective.class, From.$deref());
  }

  public static OMPParallelForSimdDirective cast_or_null_OMPParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPParallelForSimdDirective(From);
  }

  public static OMPParallelForSimdDirective dyn_cast_OMPParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static OMPParallelForSimdDirective dyn_cast_or_null_OMPParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPParallelForSimdDirective(From) ? cast_OMPParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPParallelSectionsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPParallelSectionsDirective.class, From.$star());
  }

  public static OMPParallelSectionsDirective cast_OMPParallelSectionsDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPParallelSectionsDirective(From);
    return llvm.cast(OMPParallelSectionsDirective.class, From.$star());
  }

  public static OMPParallelSectionsDirective cast_or_null_OMPParallelSectionsDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPParallelSectionsDirective(From);
  }

  public static OMPParallelSectionsDirective dyn_cast_OMPParallelSectionsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static OMPParallelSectionsDirective dyn_cast_or_null_OMPParallelSectionsDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static boolean isa_OMPParallelSectionsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPParallelSectionsDirective.class, From.$deref());
  }

  public static OMPParallelSectionsDirective cast_OMPParallelSectionsDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPParallelSectionsDirective(From);
    return llvm.cast(OMPParallelSectionsDirective.class, From.$deref());
  }

  public static OMPParallelSectionsDirective cast_or_null_OMPParallelSectionsDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPParallelSectionsDirective(From);
  }

  public static OMPParallelSectionsDirective dyn_cast_OMPParallelSectionsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static OMPParallelSectionsDirective dyn_cast_or_null_OMPParallelSectionsDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static boolean isa_OMPParallelSectionsDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPParallelSectionsDirective.classof(From);
  }

  public static OMPParallelSectionsDirective cast_OMPParallelSectionsDirective(Stmt/*P*/ From) {
    assert isa_OMPParallelSectionsDirective(From);
    return (OMPParallelSectionsDirective) From;
  }

  public static OMPParallelSectionsDirective cast_or_null_OMPParallelSectionsDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPParallelSectionsDirective(From);
  }

  public static OMPParallelSectionsDirective dyn_cast_OMPParallelSectionsDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static OMPParallelSectionsDirective dyn_cast_or_null_OMPParallelSectionsDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPParallelSectionsDirective(From) ? cast_OMPParallelSectionsDirective(From) : null;
  }

  public static boolean isa_OMPPriorityClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPPriorityClause.class, From.$deref());
  }

  public static OMPPriorityClause cast_OMPPriorityClause(type$ref<?>/*P*/ From) {
    assert isa_OMPPriorityClause(From);
    return llvm.cast(OMPPriorityClause.class, From.$deref());
  }

  public static OMPPriorityClause cast_or_null_OMPPriorityClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPPriorityClause(From);
  }

  public static OMPPriorityClause dyn_cast_OMPPriorityClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static OMPPriorityClause dyn_cast_or_null_OMPPriorityClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static boolean isa_OMPPriorityClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPPriorityClause.class, From.$star());
  }

  public static OMPPriorityClause cast_OMPPriorityClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPPriorityClause(From);
    return llvm.cast(OMPPriorityClause.class, From.$star());
  }

  public static OMPPriorityClause cast_or_null_OMPPriorityClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPPriorityClause(From);
  }

  public static OMPPriorityClause dyn_cast_OMPPriorityClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static OMPPriorityClause dyn_cast_or_null_OMPPriorityClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static boolean isa_OMPPriorityClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPPriorityClause.classof(From);
  }

  public static OMPPriorityClause cast_OMPPriorityClause(OMPClause/*P*/ From) {
    assert isa_OMPPriorityClause(From);
    return (OMPPriorityClause) From;
  }

  public static OMPPriorityClause cast_or_null_OMPPriorityClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPPriorityClause(From);
  }

  public static OMPPriorityClause dyn_cast_OMPPriorityClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static OMPPriorityClause dyn_cast_or_null_OMPPriorityClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPPriorityClause(From) ? cast_OMPPriorityClause(From) : null;
  }

  public static boolean isa_OMPPrivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPPrivateClause.classof(From);
  }

  public static OMPPrivateClause cast_OMPPrivateClause(OMPClause/*P*/ From) {
    assert isa_OMPPrivateClause(From);
    return (OMPPrivateClause) From;
  }

  public static OMPPrivateClause cast_or_null_OMPPrivateClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPPrivateClause(From);
  }

  public static OMPPrivateClause dyn_cast_OMPPrivateClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static OMPPrivateClause dyn_cast_or_null_OMPPrivateClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static boolean isa_OMPPrivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPPrivateClause.class, From.$star());
  }

  public static OMPPrivateClause cast_OMPPrivateClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPPrivateClause(From);
    return llvm.cast(OMPPrivateClause.class, From.$star());
  }

  public static OMPPrivateClause cast_or_null_OMPPrivateClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPPrivateClause(From);
  }

  public static OMPPrivateClause dyn_cast_OMPPrivateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static OMPPrivateClause dyn_cast_or_null_OMPPrivateClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static boolean isa_OMPPrivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPPrivateClause.class, From.$deref());
  }

  public static OMPPrivateClause cast_OMPPrivateClause(type$ref<?>/*P*/ From) {
    assert isa_OMPPrivateClause(From);
    return llvm.cast(OMPPrivateClause.class, From.$deref());
  }

  public static OMPPrivateClause cast_or_null_OMPPrivateClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPPrivateClause(From);
  }

  public static OMPPrivateClause dyn_cast_OMPPrivateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static OMPPrivateClause dyn_cast_or_null_OMPPrivateClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPPrivateClause(From) ? cast_OMPPrivateClause(From) : null;
  }

  public static boolean isa_OMPProcBindClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPProcBindClause.classof(From);
  }

  public static OMPProcBindClause cast_OMPProcBindClause(OMPClause/*P*/ From) {
    assert isa_OMPProcBindClause(From);
    return (OMPProcBindClause) From;
  }

  public static OMPProcBindClause cast_or_null_OMPProcBindClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPProcBindClause(From);
  }

  public static OMPProcBindClause dyn_cast_OMPProcBindClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static OMPProcBindClause dyn_cast_or_null_OMPProcBindClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static boolean isa_OMPProcBindClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPProcBindClause.class, From.$star());
  }

  public static OMPProcBindClause cast_OMPProcBindClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPProcBindClause(From);
    return llvm.cast(OMPProcBindClause.class, From.$star());
  }

  public static OMPProcBindClause cast_or_null_OMPProcBindClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPProcBindClause(From);
  }

  public static OMPProcBindClause dyn_cast_OMPProcBindClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static OMPProcBindClause dyn_cast_or_null_OMPProcBindClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static boolean isa_OMPProcBindClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPProcBindClause.class, From.$deref());
  }

  public static OMPProcBindClause cast_OMPProcBindClause(type$ref<?>/*P*/ From) {
    assert isa_OMPProcBindClause(From);
    return llvm.cast(OMPProcBindClause.class, From.$deref());
  }

  public static OMPProcBindClause cast_or_null_OMPProcBindClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPProcBindClause(From);
  }

  public static OMPProcBindClause dyn_cast_OMPProcBindClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static OMPProcBindClause dyn_cast_or_null_OMPProcBindClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPProcBindClause(From) ? cast_OMPProcBindClause(From) : null;
  }

  public static boolean isa_OMPReadClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPReadClause.classof(From);
  }

  public static OMPReadClause cast_OMPReadClause(OMPClause/*P*/ From) {
    assert isa_OMPReadClause(From);
    return (OMPReadClause) From;
  }

  public static OMPReadClause cast_or_null_OMPReadClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPReadClause(From);
  }

  public static OMPReadClause dyn_cast_OMPReadClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static OMPReadClause dyn_cast_or_null_OMPReadClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static boolean isa_OMPReadClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPReadClause.class, From.$star());
  }

  public static OMPReadClause cast_OMPReadClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPReadClause(From);
    return llvm.cast(OMPReadClause.class, From.$star());
  }

  public static OMPReadClause cast_or_null_OMPReadClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPReadClause(From);
  }

  public static OMPReadClause dyn_cast_OMPReadClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static OMPReadClause dyn_cast_or_null_OMPReadClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static boolean isa_OMPReadClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPReadClause.class, From.$deref());
  }

  public static OMPReadClause cast_OMPReadClause(type$ref<?>/*P*/ From) {
    assert isa_OMPReadClause(From);
    return llvm.cast(OMPReadClause.class, From.$deref());
  }

  public static OMPReadClause cast_or_null_OMPReadClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPReadClause(From);
  }

  public static OMPReadClause dyn_cast_OMPReadClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static OMPReadClause dyn_cast_or_null_OMPReadClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPReadClause(From) ? cast_OMPReadClause(From) : null;
  }

  public static boolean isa_OMPReductionClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPReductionClause.classof(From);
  }

  public static OMPReductionClause cast_OMPReductionClause(OMPClause/*P*/ From) {
    assert isa_OMPReductionClause(From);
    return (OMPReductionClause) From;
  }

  public static OMPReductionClause cast_or_null_OMPReductionClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPReductionClause(From);
  }

  public static OMPReductionClause dyn_cast_OMPReductionClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static OMPReductionClause dyn_cast_or_null_OMPReductionClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static boolean isa_OMPReductionClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPReductionClause.class, From.$star());
  }

  public static OMPReductionClause cast_OMPReductionClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPReductionClause(From);
    return llvm.cast(OMPReductionClause.class, From.$star());
  }

  public static OMPReductionClause cast_or_null_OMPReductionClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPReductionClause(From);
  }

  public static OMPReductionClause dyn_cast_OMPReductionClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static OMPReductionClause dyn_cast_or_null_OMPReductionClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static boolean isa_OMPReductionClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPReductionClause.class, From.$deref());
  }

  public static OMPReductionClause cast_OMPReductionClause(type$ref<?>/*P*/ From) {
    assert isa_OMPReductionClause(From);
    return llvm.cast(OMPReductionClause.class, From.$deref());
  }

  public static OMPReductionClause cast_or_null_OMPReductionClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPReductionClause(From);
  }

  public static OMPReductionClause dyn_cast_OMPReductionClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static OMPReductionClause dyn_cast_or_null_OMPReductionClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPReductionClause(From) ? cast_OMPReductionClause(From) : null;
  }

  public static boolean isa_OMPSIMDClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSIMDClause.class, From.$deref());
  }

  public static OMPSIMDClause cast_OMPSIMDClause(type$ref<?>/*P*/ From) {
    assert isa_OMPSIMDClause(From);
    return llvm.cast(OMPSIMDClause.class, From.$deref());
  }

  public static OMPSIMDClause cast_or_null_OMPSIMDClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSIMDClause(From);
  }

  public static OMPSIMDClause dyn_cast_OMPSIMDClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static OMPSIMDClause dyn_cast_or_null_OMPSIMDClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static boolean isa_OMPSIMDClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPSIMDClause.classof(From);
  }

  public static OMPSIMDClause cast_OMPSIMDClause(OMPClause/*P*/ From) {
    assert isa_OMPSIMDClause(From);
    return (OMPSIMDClause) From;
  }

  public static OMPSIMDClause cast_or_null_OMPSIMDClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPSIMDClause(From);
  }

  public static OMPSIMDClause dyn_cast_OMPSIMDClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static OMPSIMDClause dyn_cast_or_null_OMPSIMDClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static boolean isa_OMPSIMDClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSIMDClause.class, From.$star());
  }

  public static OMPSIMDClause cast_OMPSIMDClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPSIMDClause(From);
    return llvm.cast(OMPSIMDClause.class, From.$star());
  }

  public static OMPSIMDClause cast_or_null_OMPSIMDClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSIMDClause(From);
  }

  public static OMPSIMDClause dyn_cast_OMPSIMDClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static OMPSIMDClause dyn_cast_or_null_OMPSIMDClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSIMDClause(From) ? cast_OMPSIMDClause(From) : null;
  }

  public static boolean isa_OMPSafelenClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSafelenClause.class, From.$deref());
  }

  public static OMPSafelenClause cast_OMPSafelenClause(type$ref<?>/*P*/ From) {
    assert isa_OMPSafelenClause(From);
    return llvm.cast(OMPSafelenClause.class, From.$deref());
  }

  public static OMPSafelenClause cast_or_null_OMPSafelenClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSafelenClause(From);
  }

  public static OMPSafelenClause dyn_cast_OMPSafelenClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static OMPSafelenClause dyn_cast_or_null_OMPSafelenClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static boolean isa_OMPSafelenClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSafelenClause.class, From.$star());
  }

  public static OMPSafelenClause cast_OMPSafelenClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPSafelenClause(From);
    return llvm.cast(OMPSafelenClause.class, From.$star());
  }

  public static OMPSafelenClause cast_or_null_OMPSafelenClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSafelenClause(From);
  }

  public static OMPSafelenClause dyn_cast_OMPSafelenClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static OMPSafelenClause dyn_cast_or_null_OMPSafelenClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static boolean isa_OMPSafelenClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPSafelenClause.classof(From);
  }

  public static OMPSafelenClause cast_OMPSafelenClause(OMPClause/*P*/ From) {
    assert isa_OMPSafelenClause(From);
    return (OMPSafelenClause) From;
  }

  public static OMPSafelenClause cast_or_null_OMPSafelenClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPSafelenClause(From);
  }

  public static OMPSafelenClause dyn_cast_OMPSafelenClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static OMPSafelenClause dyn_cast_or_null_OMPSafelenClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPSafelenClause(From) ? cast_OMPSafelenClause(From) : null;
  }

  public static boolean isa_OMPScheduleClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPScheduleClause.class, From.$star());
  }

  public static OMPScheduleClause cast_OMPScheduleClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPScheduleClause(From);
    return llvm.cast(OMPScheduleClause.class, From.$star());
  }

  public static OMPScheduleClause cast_or_null_OMPScheduleClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPScheduleClause(From);
  }

  public static OMPScheduleClause dyn_cast_OMPScheduleClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static OMPScheduleClause dyn_cast_or_null_OMPScheduleClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static boolean isa_OMPScheduleClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPScheduleClause.class, From.$deref());
  }

  public static OMPScheduleClause cast_OMPScheduleClause(type$ref<?>/*P*/ From) {
    assert isa_OMPScheduleClause(From);
    return llvm.cast(OMPScheduleClause.class, From.$deref());
  }

  public static OMPScheduleClause cast_or_null_OMPScheduleClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPScheduleClause(From);
  }

  public static OMPScheduleClause dyn_cast_OMPScheduleClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static OMPScheduleClause dyn_cast_or_null_OMPScheduleClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static boolean isa_OMPScheduleClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPScheduleClause.classof(From);
  }

  public static OMPScheduleClause cast_OMPScheduleClause(OMPClause/*P*/ From) {
    assert isa_OMPScheduleClause(From);
    return (OMPScheduleClause) From;
  }

  public static OMPScheduleClause cast_or_null_OMPScheduleClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPScheduleClause(From);
  }

  public static OMPScheduleClause dyn_cast_OMPScheduleClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static OMPScheduleClause dyn_cast_or_null_OMPScheduleClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPScheduleClause(From) ? cast_OMPScheduleClause(From) : null;
  }

  public static boolean isa_OMPSectionDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSectionDirective.class, From.$deref());
  }

  public static OMPSectionDirective cast_OMPSectionDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPSectionDirective(From);
    return llvm.cast(OMPSectionDirective.class, From.$deref());
  }

  public static OMPSectionDirective cast_or_null_OMPSectionDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSectionDirective(From);
  }

  public static OMPSectionDirective dyn_cast_OMPSectionDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static OMPSectionDirective dyn_cast_or_null_OMPSectionDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static boolean isa_OMPSectionDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPSectionDirective.classof(From);
  }

  public static OMPSectionDirective cast_OMPSectionDirective(Stmt/*P*/ From) {
    assert isa_OMPSectionDirective(From);
    return (OMPSectionDirective) From;
  }

  public static OMPSectionDirective cast_or_null_OMPSectionDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPSectionDirective(From);
  }

  public static OMPSectionDirective dyn_cast_OMPSectionDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static OMPSectionDirective dyn_cast_or_null_OMPSectionDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static boolean isa_OMPSectionDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSectionDirective.class, From.$star());
  }

  public static OMPSectionDirective cast_OMPSectionDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPSectionDirective(From);
    return llvm.cast(OMPSectionDirective.class, From.$star());
  }

  public static OMPSectionDirective cast_or_null_OMPSectionDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSectionDirective(From);
  }

  public static OMPSectionDirective dyn_cast_OMPSectionDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static OMPSectionDirective dyn_cast_or_null_OMPSectionDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSectionDirective(From) ? cast_OMPSectionDirective(From) : null;
  }

  public static boolean isa_OMPSectionsDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPSectionsDirective.classof(From);
  }

  public static OMPSectionsDirective cast_OMPSectionsDirective(Stmt/*P*/ From) {
    assert isa_OMPSectionsDirective(From);
    return (OMPSectionsDirective) From;
  }

  public static OMPSectionsDirective cast_or_null_OMPSectionsDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPSectionsDirective(From);
  }

  public static OMPSectionsDirective dyn_cast_OMPSectionsDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static OMPSectionsDirective dyn_cast_or_null_OMPSectionsDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static boolean isa_OMPSectionsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSectionsDirective.class, From.$star());
  }

  public static OMPSectionsDirective cast_OMPSectionsDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPSectionsDirective(From);
    return llvm.cast(OMPSectionsDirective.class, From.$star());
  }

  public static OMPSectionsDirective cast_or_null_OMPSectionsDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSectionsDirective(From);
  }

  public static OMPSectionsDirective dyn_cast_OMPSectionsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static OMPSectionsDirective dyn_cast_or_null_OMPSectionsDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static boolean isa_OMPSectionsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSectionsDirective.class, From.$deref());
  }

  public static OMPSectionsDirective cast_OMPSectionsDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPSectionsDirective(From);
    return llvm.cast(OMPSectionsDirective.class, From.$deref());
  }

  public static OMPSectionsDirective cast_or_null_OMPSectionsDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSectionsDirective(From);
  }

  public static OMPSectionsDirective dyn_cast_OMPSectionsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static OMPSectionsDirective dyn_cast_or_null_OMPSectionsDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSectionsDirective(From) ? cast_OMPSectionsDirective(From) : null;
  }

  public static boolean isa_OMPSeqCstClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSeqCstClause.class, From.$star());
  }

  public static OMPSeqCstClause cast_OMPSeqCstClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPSeqCstClause(From);
    return llvm.cast(OMPSeqCstClause.class, From.$star());
  }

  public static OMPSeqCstClause cast_or_null_OMPSeqCstClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSeqCstClause(From);
  }

  public static OMPSeqCstClause dyn_cast_OMPSeqCstClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static OMPSeqCstClause dyn_cast_or_null_OMPSeqCstClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static boolean isa_OMPSeqCstClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSeqCstClause.class, From.$deref());
  }

  public static OMPSeqCstClause cast_OMPSeqCstClause(type$ref<?>/*P*/ From) {
    assert isa_OMPSeqCstClause(From);
    return llvm.cast(OMPSeqCstClause.class, From.$deref());
  }

  public static OMPSeqCstClause cast_or_null_OMPSeqCstClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSeqCstClause(From);
  }

  public static OMPSeqCstClause dyn_cast_OMPSeqCstClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static OMPSeqCstClause dyn_cast_or_null_OMPSeqCstClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static boolean isa_OMPSeqCstClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPSeqCstClause.classof(From);
  }

  public static OMPSeqCstClause cast_OMPSeqCstClause(OMPClause/*P*/ From) {
    assert isa_OMPSeqCstClause(From);
    return (OMPSeqCstClause) From;
  }

  public static OMPSeqCstClause cast_or_null_OMPSeqCstClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPSeqCstClause(From);
  }

  public static OMPSeqCstClause dyn_cast_OMPSeqCstClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static OMPSeqCstClause dyn_cast_or_null_OMPSeqCstClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPSeqCstClause(From) ? cast_OMPSeqCstClause(From) : null;
  }

  public static boolean isa_OMPSharedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSharedClause.class, From.$deref());
  }

  public static OMPSharedClause cast_OMPSharedClause(type$ref<?>/*P*/ From) {
    assert isa_OMPSharedClause(From);
    return llvm.cast(OMPSharedClause.class, From.$deref());
  }

  public static OMPSharedClause cast_or_null_OMPSharedClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSharedClause(From);
  }

  public static OMPSharedClause dyn_cast_OMPSharedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static OMPSharedClause dyn_cast_or_null_OMPSharedClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static boolean isa_OMPSharedClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPSharedClause.classof(From);
  }

  public static OMPSharedClause cast_OMPSharedClause(OMPClause/*P*/ From) {
    assert isa_OMPSharedClause(From);
    return (OMPSharedClause) From;
  }

  public static OMPSharedClause cast_or_null_OMPSharedClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPSharedClause(From);
  }

  public static OMPSharedClause dyn_cast_OMPSharedClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static OMPSharedClause dyn_cast_or_null_OMPSharedClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static boolean isa_OMPSharedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSharedClause.class, From.$star());
  }

  public static OMPSharedClause cast_OMPSharedClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPSharedClause(From);
    return llvm.cast(OMPSharedClause.class, From.$star());
  }

  public static OMPSharedClause cast_or_null_OMPSharedClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSharedClause(From);
  }

  public static OMPSharedClause dyn_cast_OMPSharedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static OMPSharedClause dyn_cast_or_null_OMPSharedClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSharedClause(From) ? cast_OMPSharedClause(From) : null;
  }

  public static boolean isa_OMPSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSimdDirective.class, From.$deref());
  }

  public static OMPSimdDirective cast_OMPSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPSimdDirective(From);
    return llvm.cast(OMPSimdDirective.class, From.$deref());
  }

  public static OMPSimdDirective cast_or_null_OMPSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSimdDirective(From);
  }

  public static OMPSimdDirective dyn_cast_OMPSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static OMPSimdDirective dyn_cast_or_null_OMPSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static boolean isa_OMPSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPSimdDirective.classof(From);
  }

  public static OMPSimdDirective cast_OMPSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPSimdDirective(From);
    return (OMPSimdDirective) From;
  }

  public static OMPSimdDirective cast_or_null_OMPSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPSimdDirective(From);
  }

  public static OMPSimdDirective dyn_cast_OMPSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static OMPSimdDirective dyn_cast_or_null_OMPSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static boolean isa_OMPSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSimdDirective.class, From.$star());
  }

  public static OMPSimdDirective cast_OMPSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPSimdDirective(From);
    return llvm.cast(OMPSimdDirective.class, From.$star());
  }

  public static OMPSimdDirective cast_or_null_OMPSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSimdDirective(From);
  }

  public static OMPSimdDirective dyn_cast_OMPSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static OMPSimdDirective dyn_cast_or_null_OMPSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSimdDirective(From) ? cast_OMPSimdDirective(From) : null;
  }

  public static boolean isa_OMPSimdlenClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPSimdlenClause.classof(From);
  }

  public static OMPSimdlenClause cast_OMPSimdlenClause(OMPClause/*P*/ From) {
    assert isa_OMPSimdlenClause(From);
    return (OMPSimdlenClause) From;
  }

  public static OMPSimdlenClause cast_or_null_OMPSimdlenClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPSimdlenClause(From);
  }

  public static OMPSimdlenClause dyn_cast_OMPSimdlenClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static OMPSimdlenClause dyn_cast_or_null_OMPSimdlenClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static boolean isa_OMPSimdlenClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSimdlenClause.class, From.$star());
  }

  public static OMPSimdlenClause cast_OMPSimdlenClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPSimdlenClause(From);
    return llvm.cast(OMPSimdlenClause.class, From.$star());
  }

  public static OMPSimdlenClause cast_or_null_OMPSimdlenClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSimdlenClause(From);
  }

  public static OMPSimdlenClause dyn_cast_OMPSimdlenClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static OMPSimdlenClause dyn_cast_or_null_OMPSimdlenClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static boolean isa_OMPSimdlenClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSimdlenClause.class, From.$deref());
  }

  public static OMPSimdlenClause cast_OMPSimdlenClause(type$ref<?>/*P*/ From) {
    assert isa_OMPSimdlenClause(From);
    return llvm.cast(OMPSimdlenClause.class, From.$deref());
  }

  public static OMPSimdlenClause cast_or_null_OMPSimdlenClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSimdlenClause(From);
  }

  public static OMPSimdlenClause dyn_cast_OMPSimdlenClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static OMPSimdlenClause dyn_cast_or_null_OMPSimdlenClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSimdlenClause(From) ? cast_OMPSimdlenClause(From) : null;
  }

  public static boolean isa_OMPSingleDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPSingleDirective.class, From.$deref());
  }

  public static OMPSingleDirective cast_OMPSingleDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPSingleDirective(From);
    return llvm.cast(OMPSingleDirective.class, From.$deref());
  }

  public static OMPSingleDirective cast_or_null_OMPSingleDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPSingleDirective(From);
  }

  public static OMPSingleDirective dyn_cast_OMPSingleDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static OMPSingleDirective dyn_cast_or_null_OMPSingleDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static boolean isa_OMPSingleDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPSingleDirective.classof(From);
  }

  public static OMPSingleDirective cast_OMPSingleDirective(Stmt/*P*/ From) {
    assert isa_OMPSingleDirective(From);
    return (OMPSingleDirective) From;
  }

  public static OMPSingleDirective cast_or_null_OMPSingleDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPSingleDirective(From);
  }

  public static OMPSingleDirective dyn_cast_OMPSingleDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static OMPSingleDirective dyn_cast_or_null_OMPSingleDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static boolean isa_OMPSingleDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPSingleDirective.class, From.$star());
  }

  public static OMPSingleDirective cast_OMPSingleDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPSingleDirective(From);
    return llvm.cast(OMPSingleDirective.class, From.$star());
  }

  public static OMPSingleDirective cast_or_null_OMPSingleDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPSingleDirective(From);
  }

  public static OMPSingleDirective dyn_cast_OMPSingleDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static OMPSingleDirective dyn_cast_or_null_OMPSingleDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPSingleDirective(From) ? cast_OMPSingleDirective(From) : null;
  }

  public static boolean isa_OMPTargetDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetDataDirective.class, From.$deref());
  }

  public static OMPTargetDataDirective cast_OMPTargetDataDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetDataDirective(From);
    return llvm.cast(OMPTargetDataDirective.class, From.$deref());
  }

  public static OMPTargetDataDirective cast_or_null_OMPTargetDataDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetDataDirective(From);
  }

  public static OMPTargetDataDirective dyn_cast_OMPTargetDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static OMPTargetDataDirective dyn_cast_or_null_OMPTargetDataDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetDataDirective.class, From.$star());
  }

  public static OMPTargetDataDirective cast_OMPTargetDataDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetDataDirective(From);
    return llvm.cast(OMPTargetDataDirective.class, From.$star());
  }

  public static OMPTargetDataDirective cast_or_null_OMPTargetDataDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetDataDirective(From);
  }

  public static OMPTargetDataDirective dyn_cast_OMPTargetDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static OMPTargetDataDirective dyn_cast_or_null_OMPTargetDataDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetDataDirective.classof(From);
  }

  public static OMPTargetDataDirective cast_OMPTargetDataDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetDataDirective(From);
    return (OMPTargetDataDirective) From;
  }

  public static OMPTargetDataDirective cast_or_null_OMPTargetDataDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetDataDirective(From);
  }

  public static OMPTargetDataDirective dyn_cast_OMPTargetDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static OMPTargetDataDirective dyn_cast_or_null_OMPTargetDataDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetDataDirective(From) ? cast_OMPTargetDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetDirective.class, From.$deref());
  }

  public static OMPTargetDirective cast_OMPTargetDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetDirective(From);
    return llvm.cast(OMPTargetDirective.class, From.$deref());
  }

  public static OMPTargetDirective cast_or_null_OMPTargetDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetDirective(From);
  }

  public static OMPTargetDirective dyn_cast_OMPTargetDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static OMPTargetDirective dyn_cast_or_null_OMPTargetDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static boolean isa_OMPTargetDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetDirective.classof(From);
  }

  public static OMPTargetDirective cast_OMPTargetDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetDirective(From);
    return (OMPTargetDirective) From;
  }

  public static OMPTargetDirective cast_or_null_OMPTargetDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetDirective(From);
  }

  public static OMPTargetDirective dyn_cast_OMPTargetDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static OMPTargetDirective dyn_cast_or_null_OMPTargetDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static boolean isa_OMPTargetDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetDirective.class, From.$star());
  }

  public static OMPTargetDirective cast_OMPTargetDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetDirective(From);
    return llvm.cast(OMPTargetDirective.class, From.$star());
  }

  public static OMPTargetDirective cast_or_null_OMPTargetDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetDirective(From);
  }

  public static OMPTargetDirective dyn_cast_OMPTargetDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static OMPTargetDirective dyn_cast_or_null_OMPTargetDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetDirective(From) ? cast_OMPTargetDirective(From) : null;
  }

  public static boolean isa_OMPTargetEnterDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetEnterDataDirective.classof(From);
  }

  public static OMPTargetEnterDataDirective cast_OMPTargetEnterDataDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetEnterDataDirective(From);
    return (OMPTargetEnterDataDirective) From;
  }

  public static OMPTargetEnterDataDirective cast_or_null_OMPTargetEnterDataDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetEnterDataDirective(From);
  }

  public static OMPTargetEnterDataDirective dyn_cast_OMPTargetEnterDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static OMPTargetEnterDataDirective dyn_cast_or_null_OMPTargetEnterDataDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetEnterDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetEnterDataDirective.class, From.$star());
  }

  public static OMPTargetEnterDataDirective cast_OMPTargetEnterDataDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetEnterDataDirective(From);
    return llvm.cast(OMPTargetEnterDataDirective.class, From.$star());
  }

  public static OMPTargetEnterDataDirective cast_or_null_OMPTargetEnterDataDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetEnterDataDirective(From);
  }

  public static OMPTargetEnterDataDirective dyn_cast_OMPTargetEnterDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static OMPTargetEnterDataDirective dyn_cast_or_null_OMPTargetEnterDataDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetEnterDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetEnterDataDirective.class, From.$deref());
  }

  public static OMPTargetEnterDataDirective cast_OMPTargetEnterDataDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetEnterDataDirective(From);
    return llvm.cast(OMPTargetEnterDataDirective.class, From.$deref());
  }

  public static OMPTargetEnterDataDirective cast_or_null_OMPTargetEnterDataDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetEnterDataDirective(From);
  }

  public static OMPTargetEnterDataDirective dyn_cast_OMPTargetEnterDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static OMPTargetEnterDataDirective dyn_cast_or_null_OMPTargetEnterDataDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetEnterDataDirective(From) ? cast_OMPTargetEnterDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetExitDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetExitDataDirective.class, From.$star());
  }

  public static OMPTargetExitDataDirective cast_OMPTargetExitDataDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetExitDataDirective(From);
    return llvm.cast(OMPTargetExitDataDirective.class, From.$star());
  }

  public static OMPTargetExitDataDirective cast_or_null_OMPTargetExitDataDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetExitDataDirective(From);
  }

  public static OMPTargetExitDataDirective dyn_cast_OMPTargetExitDataDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static OMPTargetExitDataDirective dyn_cast_or_null_OMPTargetExitDataDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetExitDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetExitDataDirective.classof(From);
  }

  public static OMPTargetExitDataDirective cast_OMPTargetExitDataDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetExitDataDirective(From);
    return (OMPTargetExitDataDirective) From;
  }

  public static OMPTargetExitDataDirective cast_or_null_OMPTargetExitDataDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetExitDataDirective(From);
  }

  public static OMPTargetExitDataDirective dyn_cast_OMPTargetExitDataDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static OMPTargetExitDataDirective dyn_cast_or_null_OMPTargetExitDataDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetExitDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetExitDataDirective.class, From.$deref());
  }

  public static OMPTargetExitDataDirective cast_OMPTargetExitDataDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetExitDataDirective(From);
    return llvm.cast(OMPTargetExitDataDirective.class, From.$deref());
  }

  public static OMPTargetExitDataDirective cast_or_null_OMPTargetExitDataDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetExitDataDirective(From);
  }

  public static OMPTargetExitDataDirective dyn_cast_OMPTargetExitDataDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static OMPTargetExitDataDirective dyn_cast_or_null_OMPTargetExitDataDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetExitDataDirective(From) ? cast_OMPTargetExitDataDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetParallelDirective.class, From.$star());
  }

  public static OMPTargetParallelDirective cast_OMPTargetParallelDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetParallelDirective(From);
    return llvm.cast(OMPTargetParallelDirective.class, From.$star());
  }

  public static OMPTargetParallelDirective cast_or_null_OMPTargetParallelDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetParallelDirective(From);
  }

  public static OMPTargetParallelDirective dyn_cast_OMPTargetParallelDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static OMPTargetParallelDirective dyn_cast_or_null_OMPTargetParallelDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetParallelDirective.class, From.$deref());
  }

  public static OMPTargetParallelDirective cast_OMPTargetParallelDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetParallelDirective(From);
    return llvm.cast(OMPTargetParallelDirective.class, From.$deref());
  }

  public static OMPTargetParallelDirective cast_or_null_OMPTargetParallelDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetParallelDirective(From);
  }

  public static OMPTargetParallelDirective dyn_cast_OMPTargetParallelDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static OMPTargetParallelDirective dyn_cast_or_null_OMPTargetParallelDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetParallelDirective.classof(From);
  }

  public static OMPTargetParallelDirective cast_OMPTargetParallelDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetParallelDirective(From);
    return (OMPTargetParallelDirective) From;
  }

  public static OMPTargetParallelDirective cast_or_null_OMPTargetParallelDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetParallelDirective(From);
  }

  public static OMPTargetParallelDirective dyn_cast_OMPTargetParallelDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static OMPTargetParallelDirective dyn_cast_or_null_OMPTargetParallelDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetParallelDirective(From) ? cast_OMPTargetParallelDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetParallelForDirective.classof(From);
  }

  public static OMPTargetParallelForDirective cast_OMPTargetParallelForDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetParallelForDirective(From);
    return (OMPTargetParallelForDirective) From;
  }

  public static OMPTargetParallelForDirective cast_or_null_OMPTargetParallelForDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetParallelForDirective(From);
  }

  public static OMPTargetParallelForDirective dyn_cast_OMPTargetParallelForDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static OMPTargetParallelForDirective dyn_cast_or_null_OMPTargetParallelForDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetParallelForDirective.class, From.$star());
  }

  public static OMPTargetParallelForDirective cast_OMPTargetParallelForDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetParallelForDirective(From);
    return llvm.cast(OMPTargetParallelForDirective.class, From.$star());
  }

  public static OMPTargetParallelForDirective cast_or_null_OMPTargetParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetParallelForDirective(From);
  }

  public static OMPTargetParallelForDirective dyn_cast_OMPTargetParallelForDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static OMPTargetParallelForDirective dyn_cast_or_null_OMPTargetParallelForDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetParallelForDirective.class, From.$deref());
  }

  public static OMPTargetParallelForDirective cast_OMPTargetParallelForDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetParallelForDirective(From);
    return llvm.cast(OMPTargetParallelForDirective.class, From.$deref());
  }

  public static OMPTargetParallelForDirective cast_or_null_OMPTargetParallelForDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetParallelForDirective(From);
  }

  public static OMPTargetParallelForDirective dyn_cast_OMPTargetParallelForDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static OMPTargetParallelForDirective dyn_cast_or_null_OMPTargetParallelForDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetParallelForDirective(From) ? cast_OMPTargetParallelForDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetParallelForSimdDirective.class, From.$deref());
  }

  public static OMPTargetParallelForSimdDirective cast_OMPTargetParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetParallelForSimdDirective(From);
    return llvm.cast(OMPTargetParallelForSimdDirective.class, From.$deref());
  }

  public static OMPTargetParallelForSimdDirective cast_or_null_OMPTargetParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetParallelForSimdDirective(From);
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_OMPTargetParallelForSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_or_null_OMPTargetParallelForSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetParallelForSimdDirective.classof(From);
  }

  public static OMPTargetParallelForSimdDirective cast_OMPTargetParallelForSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetParallelForSimdDirective(From);
    return (OMPTargetParallelForSimdDirective) From;
  }

  public static OMPTargetParallelForSimdDirective cast_or_null_OMPTargetParallelForSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetParallelForSimdDirective(From);
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_OMPTargetParallelForSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_or_null_OMPTargetParallelForSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPTargetParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetParallelForSimdDirective.class, From.$star());
  }

  public static OMPTargetParallelForSimdDirective cast_OMPTargetParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetParallelForSimdDirective(From);
    return llvm.cast(OMPTargetParallelForSimdDirective.class, From.$star());
  }

  public static OMPTargetParallelForSimdDirective cast_or_null_OMPTargetParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetParallelForSimdDirective(From);
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_OMPTargetParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static OMPTargetParallelForSimdDirective dyn_cast_or_null_OMPTargetParallelForSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetParallelForSimdDirective(From) ? cast_OMPTargetParallelForSimdDirective(From) : null;
  }

  public static boolean isa_OMPTargetUpdateDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTargetUpdateDirective.class, From.$deref());
  }

  public static OMPTargetUpdateDirective cast_OMPTargetUpdateDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTargetUpdateDirective(From);
    return llvm.cast(OMPTargetUpdateDirective.class, From.$deref());
  }

  public static OMPTargetUpdateDirective cast_or_null_OMPTargetUpdateDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTargetUpdateDirective(From);
  }

  public static OMPTargetUpdateDirective dyn_cast_OMPTargetUpdateDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static OMPTargetUpdateDirective dyn_cast_or_null_OMPTargetUpdateDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static boolean isa_OMPTargetUpdateDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTargetUpdateDirective.classof(From);
  }

  public static OMPTargetUpdateDirective cast_OMPTargetUpdateDirective(Stmt/*P*/ From) {
    assert isa_OMPTargetUpdateDirective(From);
    return (OMPTargetUpdateDirective) From;
  }

  public static OMPTargetUpdateDirective cast_or_null_OMPTargetUpdateDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTargetUpdateDirective(From);
  }

  public static OMPTargetUpdateDirective dyn_cast_OMPTargetUpdateDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static OMPTargetUpdateDirective dyn_cast_or_null_OMPTargetUpdateDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static boolean isa_OMPTargetUpdateDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTargetUpdateDirective.class, From.$star());
  }

  public static OMPTargetUpdateDirective cast_OMPTargetUpdateDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTargetUpdateDirective(From);
    return llvm.cast(OMPTargetUpdateDirective.class, From.$star());
  }

  public static OMPTargetUpdateDirective cast_or_null_OMPTargetUpdateDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTargetUpdateDirective(From);
  }

  public static OMPTargetUpdateDirective dyn_cast_OMPTargetUpdateDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static OMPTargetUpdateDirective dyn_cast_or_null_OMPTargetUpdateDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTargetUpdateDirective(From) ? cast_OMPTargetUpdateDirective(From) : null;
  }

  public static boolean isa_OMPTaskDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskDirective.classof(From);
  }

  public static OMPTaskDirective cast_OMPTaskDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskDirective(From);
    return (OMPTaskDirective) From;
  }

  public static OMPTaskDirective cast_or_null_OMPTaskDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskDirective(From);
  }

  public static OMPTaskDirective dyn_cast_OMPTaskDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static OMPTaskDirective dyn_cast_or_null_OMPTaskDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static boolean isa_OMPTaskDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskDirective.class, From.$deref());
  }

  public static OMPTaskDirective cast_OMPTaskDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskDirective(From);
    return llvm.cast(OMPTaskDirective.class, From.$deref());
  }

  public static OMPTaskDirective cast_or_null_OMPTaskDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskDirective(From);
  }

  public static OMPTaskDirective dyn_cast_OMPTaskDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static OMPTaskDirective dyn_cast_or_null_OMPTaskDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static boolean isa_OMPTaskDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskDirective.class, From.$star());
  }

  public static OMPTaskDirective cast_OMPTaskDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskDirective(From);
    return llvm.cast(OMPTaskDirective.class, From.$star());
  }

  public static OMPTaskDirective cast_or_null_OMPTaskDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskDirective(From);
  }

  public static OMPTaskDirective dyn_cast_OMPTaskDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static OMPTaskDirective dyn_cast_or_null_OMPTaskDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskDirective(From) ? cast_OMPTaskDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskLoopDirective.class, From.$deref());
  }

  public static OMPTaskLoopDirective cast_OMPTaskLoopDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskLoopDirective(From);
    return llvm.cast(OMPTaskLoopDirective.class, From.$deref());
  }

  public static OMPTaskLoopDirective cast_or_null_OMPTaskLoopDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskLoopDirective(From);
  }

  public static OMPTaskLoopDirective dyn_cast_OMPTaskLoopDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static OMPTaskLoopDirective dyn_cast_or_null_OMPTaskLoopDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskLoopDirective.classof(From);
  }

  public static OMPTaskLoopDirective cast_OMPTaskLoopDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskLoopDirective(From);
    return (OMPTaskLoopDirective) From;
  }

  public static OMPTaskLoopDirective cast_or_null_OMPTaskLoopDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskLoopDirective(From);
  }

  public static OMPTaskLoopDirective dyn_cast_OMPTaskLoopDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static OMPTaskLoopDirective dyn_cast_or_null_OMPTaskLoopDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskLoopDirective.class, From.$star());
  }

  public static OMPTaskLoopDirective cast_OMPTaskLoopDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskLoopDirective(From);
    return llvm.cast(OMPTaskLoopDirective.class, From.$star());
  }

  public static OMPTaskLoopDirective cast_or_null_OMPTaskLoopDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskLoopDirective(From);
  }

  public static OMPTaskLoopDirective dyn_cast_OMPTaskLoopDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static OMPTaskLoopDirective dyn_cast_or_null_OMPTaskLoopDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskLoopDirective(From) ? cast_OMPTaskLoopDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskLoopSimdDirective.classof(From);
  }

  public static OMPTaskLoopSimdDirective cast_OMPTaskLoopSimdDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskLoopSimdDirective(From);
    return (OMPTaskLoopSimdDirective) From;
  }

  public static OMPTaskLoopSimdDirective cast_or_null_OMPTaskLoopSimdDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskLoopSimdDirective(From);
  }

  public static OMPTaskLoopSimdDirective dyn_cast_OMPTaskLoopSimdDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static OMPTaskLoopSimdDirective dyn_cast_or_null_OMPTaskLoopSimdDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskLoopSimdDirective.class, From.$deref());
  }

  public static OMPTaskLoopSimdDirective cast_OMPTaskLoopSimdDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskLoopSimdDirective(From);
    return llvm.cast(OMPTaskLoopSimdDirective.class, From.$deref());
  }

  public static OMPTaskLoopSimdDirective cast_or_null_OMPTaskLoopSimdDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskLoopSimdDirective(From);
  }

  public static OMPTaskLoopSimdDirective dyn_cast_OMPTaskLoopSimdDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static OMPTaskLoopSimdDirective dyn_cast_or_null_OMPTaskLoopSimdDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static boolean isa_OMPTaskLoopSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskLoopSimdDirective.class, From.$star());
  }

  public static OMPTaskLoopSimdDirective cast_OMPTaskLoopSimdDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskLoopSimdDirective(From);
    return llvm.cast(OMPTaskLoopSimdDirective.class, From.$star());
  }

  public static OMPTaskLoopSimdDirective cast_or_null_OMPTaskLoopSimdDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskLoopSimdDirective(From);
  }

  public static OMPTaskLoopSimdDirective dyn_cast_OMPTaskLoopSimdDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static OMPTaskLoopSimdDirective dyn_cast_or_null_OMPTaskLoopSimdDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskLoopSimdDirective(From) ? cast_OMPTaskLoopSimdDirective(From) : null;
  }

  public static boolean isa_OMPTaskgroupDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskgroupDirective.class, From.$deref());
  }

  public static OMPTaskgroupDirective cast_OMPTaskgroupDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskgroupDirective(From);
    return llvm.cast(OMPTaskgroupDirective.class, From.$deref());
  }

  public static OMPTaskgroupDirective cast_or_null_OMPTaskgroupDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskgroupDirective(From);
  }

  public static OMPTaskgroupDirective dyn_cast_OMPTaskgroupDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static OMPTaskgroupDirective dyn_cast_or_null_OMPTaskgroupDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static boolean isa_OMPTaskgroupDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskgroupDirective.classof(From);
  }

  public static OMPTaskgroupDirective cast_OMPTaskgroupDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskgroupDirective(From);
    return (OMPTaskgroupDirective) From;
  }

  public static OMPTaskgroupDirective cast_or_null_OMPTaskgroupDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskgroupDirective(From);
  }

  public static OMPTaskgroupDirective dyn_cast_OMPTaskgroupDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static OMPTaskgroupDirective dyn_cast_or_null_OMPTaskgroupDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static boolean isa_OMPTaskgroupDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskgroupDirective.class, From.$star());
  }

  public static OMPTaskgroupDirective cast_OMPTaskgroupDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskgroupDirective(From);
    return llvm.cast(OMPTaskgroupDirective.class, From.$star());
  }

  public static OMPTaskgroupDirective cast_or_null_OMPTaskgroupDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskgroupDirective(From);
  }

  public static OMPTaskgroupDirective dyn_cast_OMPTaskgroupDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static OMPTaskgroupDirective dyn_cast_or_null_OMPTaskgroupDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskgroupDirective(From) ? cast_OMPTaskgroupDirective(From) : null;
  }

  public static boolean isa_OMPTaskwaitDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskwaitDirective.class, From.$star());
  }

  public static OMPTaskwaitDirective cast_OMPTaskwaitDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskwaitDirective(From);
    return llvm.cast(OMPTaskwaitDirective.class, From.$star());
  }

  public static OMPTaskwaitDirective cast_or_null_OMPTaskwaitDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskwaitDirective(From);
  }

  public static OMPTaskwaitDirective dyn_cast_OMPTaskwaitDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static OMPTaskwaitDirective dyn_cast_or_null_OMPTaskwaitDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static boolean isa_OMPTaskwaitDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskwaitDirective.classof(From);
  }

  public static OMPTaskwaitDirective cast_OMPTaskwaitDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskwaitDirective(From);
    return (OMPTaskwaitDirective) From;
  }

  public static OMPTaskwaitDirective cast_or_null_OMPTaskwaitDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskwaitDirective(From);
  }

  public static OMPTaskwaitDirective dyn_cast_OMPTaskwaitDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static OMPTaskwaitDirective dyn_cast_or_null_OMPTaskwaitDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static boolean isa_OMPTaskwaitDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskwaitDirective.class, From.$deref());
  }

  public static OMPTaskwaitDirective cast_OMPTaskwaitDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskwaitDirective(From);
    return llvm.cast(OMPTaskwaitDirective.class, From.$deref());
  }

  public static OMPTaskwaitDirective cast_or_null_OMPTaskwaitDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskwaitDirective(From);
  }

  public static OMPTaskwaitDirective dyn_cast_OMPTaskwaitDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static OMPTaskwaitDirective dyn_cast_or_null_OMPTaskwaitDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskwaitDirective(From) ? cast_OMPTaskwaitDirective(From) : null;
  }

  public static boolean isa_OMPTaskyieldDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTaskyieldDirective.class, From.$deref());
  }

  public static OMPTaskyieldDirective cast_OMPTaskyieldDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTaskyieldDirective(From);
    return llvm.cast(OMPTaskyieldDirective.class, From.$deref());
  }

  public static OMPTaskyieldDirective cast_or_null_OMPTaskyieldDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTaskyieldDirective(From);
  }

  public static OMPTaskyieldDirective dyn_cast_OMPTaskyieldDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static OMPTaskyieldDirective dyn_cast_or_null_OMPTaskyieldDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static boolean isa_OMPTaskyieldDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTaskyieldDirective.class, From.$star());
  }

  public static OMPTaskyieldDirective cast_OMPTaskyieldDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTaskyieldDirective(From);
    return llvm.cast(OMPTaskyieldDirective.class, From.$star());
  }

  public static OMPTaskyieldDirective cast_or_null_OMPTaskyieldDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTaskyieldDirective(From);
  }

  public static OMPTaskyieldDirective dyn_cast_OMPTaskyieldDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static OMPTaskyieldDirective dyn_cast_or_null_OMPTaskyieldDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static boolean isa_OMPTaskyieldDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTaskyieldDirective.classof(From);
  }

  public static OMPTaskyieldDirective cast_OMPTaskyieldDirective(Stmt/*P*/ From) {
    assert isa_OMPTaskyieldDirective(From);
    return (OMPTaskyieldDirective) From;
  }

  public static OMPTaskyieldDirective cast_or_null_OMPTaskyieldDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTaskyieldDirective(From);
  }

  public static OMPTaskyieldDirective dyn_cast_OMPTaskyieldDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static OMPTaskyieldDirective dyn_cast_or_null_OMPTaskyieldDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTaskyieldDirective(From) ? cast_OMPTaskyieldDirective(From) : null;
  }

  public static boolean isa_OMPTeamsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPTeamsDirective.class, From.$star());
  }

  public static OMPTeamsDirective cast_OMPTeamsDirective(type$ptr<?>/*P*/ From) {
    assert isa_OMPTeamsDirective(From);
    return llvm.cast(OMPTeamsDirective.class, From.$star());
  }

  public static OMPTeamsDirective cast_or_null_OMPTeamsDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPTeamsDirective(From);
  }

  public static OMPTeamsDirective dyn_cast_OMPTeamsDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static OMPTeamsDirective dyn_cast_or_null_OMPTeamsDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static boolean isa_OMPTeamsDirective(Stmt/*P*/ From) {
    assert From != null;
    return OMPTeamsDirective.classof(From);
  }

  public static OMPTeamsDirective cast_OMPTeamsDirective(Stmt/*P*/ From) {
    assert isa_OMPTeamsDirective(From);
    return (OMPTeamsDirective) From;
  }

  public static OMPTeamsDirective cast_or_null_OMPTeamsDirective(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPTeamsDirective(From);
  }

  public static OMPTeamsDirective dyn_cast_OMPTeamsDirective(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static OMPTeamsDirective dyn_cast_or_null_OMPTeamsDirective(Stmt/*P*/ From) {
    return (From != null) && isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static boolean isa_OMPTeamsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPTeamsDirective.class, From.$deref());
  }

  public static OMPTeamsDirective cast_OMPTeamsDirective(type$ref<?>/*P*/ From) {
    assert isa_OMPTeamsDirective(From);
    return llvm.cast(OMPTeamsDirective.class, From.$deref());
  }

  public static OMPTeamsDirective cast_or_null_OMPTeamsDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPTeamsDirective(From);
  }

  public static OMPTeamsDirective dyn_cast_OMPTeamsDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static OMPTeamsDirective dyn_cast_or_null_OMPTeamsDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPTeamsDirective(From) ? cast_OMPTeamsDirective(From) : null;
  }

  public static boolean isa_OMPThreadLimitClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPThreadLimitClause.classof(From);
  }

  public static OMPThreadLimitClause cast_OMPThreadLimitClause(OMPClause/*P*/ From) {
    assert isa_OMPThreadLimitClause(From);
    return (OMPThreadLimitClause) From;
  }

  public static OMPThreadLimitClause cast_or_null_OMPThreadLimitClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPThreadLimitClause(From);
  }

  public static OMPThreadLimitClause dyn_cast_OMPThreadLimitClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static OMPThreadLimitClause dyn_cast_or_null_OMPThreadLimitClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static boolean isa_OMPThreadLimitClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPThreadLimitClause.class, From.$star());
  }

  public static OMPThreadLimitClause cast_OMPThreadLimitClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPThreadLimitClause(From);
    return llvm.cast(OMPThreadLimitClause.class, From.$star());
  }

  public static OMPThreadLimitClause cast_or_null_OMPThreadLimitClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPThreadLimitClause(From);
  }

  public static OMPThreadLimitClause dyn_cast_OMPThreadLimitClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static OMPThreadLimitClause dyn_cast_or_null_OMPThreadLimitClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static boolean isa_OMPThreadLimitClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPThreadLimitClause.class, From.$deref());
  }

  public static OMPThreadLimitClause cast_OMPThreadLimitClause(type$ref<?>/*P*/ From) {
    assert isa_OMPThreadLimitClause(From);
    return llvm.cast(OMPThreadLimitClause.class, From.$deref());
  }

  public static OMPThreadLimitClause cast_or_null_OMPThreadLimitClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPThreadLimitClause(From);
  }

  public static OMPThreadLimitClause dyn_cast_OMPThreadLimitClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static OMPThreadLimitClause dyn_cast_or_null_OMPThreadLimitClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPThreadLimitClause(From) ? cast_OMPThreadLimitClause(From) : null;
  }

  public static boolean isa_OMPThreadsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPThreadsClause.class, From.$star());
  }

  public static OMPThreadsClause cast_OMPThreadsClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPThreadsClause(From);
    return llvm.cast(OMPThreadsClause.class, From.$star());
  }

  public static OMPThreadsClause cast_or_null_OMPThreadsClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPThreadsClause(From);
  }

  public static OMPThreadsClause dyn_cast_OMPThreadsClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static OMPThreadsClause dyn_cast_or_null_OMPThreadsClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static boolean isa_OMPThreadsClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPThreadsClause.classof(From);
  }

  public static OMPThreadsClause cast_OMPThreadsClause(OMPClause/*P*/ From) {
    assert isa_OMPThreadsClause(From);
    return (OMPThreadsClause) From;
  }

  public static OMPThreadsClause cast_or_null_OMPThreadsClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPThreadsClause(From);
  }

  public static OMPThreadsClause dyn_cast_OMPThreadsClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static OMPThreadsClause dyn_cast_or_null_OMPThreadsClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static boolean isa_OMPThreadsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPThreadsClause.class, From.$deref());
  }

  public static OMPThreadsClause cast_OMPThreadsClause(type$ref<?>/*P*/ From) {
    assert isa_OMPThreadsClause(From);
    return llvm.cast(OMPThreadsClause.class, From.$deref());
  }

  public static OMPThreadsClause cast_or_null_OMPThreadsClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPThreadsClause(From);
  }

  public static OMPThreadsClause dyn_cast_OMPThreadsClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static OMPThreadsClause dyn_cast_or_null_OMPThreadsClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPThreadsClause(From) ? cast_OMPThreadsClause(From) : null;
  }

  public static boolean isa_OMPToClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPToClause.class, From.$star());
  }

  public static OMPToClause cast_OMPToClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPToClause(From);
    return llvm.cast(OMPToClause.class, From.$star());
  }

  public static OMPToClause cast_or_null_OMPToClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPToClause(From);
  }

  public static OMPToClause dyn_cast_OMPToClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static OMPToClause dyn_cast_or_null_OMPToClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static boolean isa_OMPToClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPToClause.classof(From);
  }

  public static OMPToClause cast_OMPToClause(OMPClause/*P*/ From) {
    assert isa_OMPToClause(From);
    return (OMPToClause) From;
  }

  public static OMPToClause cast_or_null_OMPToClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPToClause(From);
  }

  public static OMPToClause dyn_cast_OMPToClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static OMPToClause dyn_cast_or_null_OMPToClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static boolean isa_OMPToClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPToClause.class, From.$deref());
  }

  public static OMPToClause cast_OMPToClause(type$ref<?>/*P*/ From) {
    assert isa_OMPToClause(From);
    return llvm.cast(OMPToClause.class, From.$deref());
  }

  public static OMPToClause cast_or_null_OMPToClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPToClause(From);
  }

  public static OMPToClause dyn_cast_OMPToClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static OMPToClause dyn_cast_or_null_OMPToClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPToClause(From) ? cast_OMPToClause(From) : null;
  }

  public static boolean isa_OMPUntiedClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPUntiedClause.classof(From);
  }

  public static OMPUntiedClause cast_OMPUntiedClause(OMPClause/*P*/ From) {
    assert isa_OMPUntiedClause(From);
    return (OMPUntiedClause) From;
  }

  public static OMPUntiedClause cast_or_null_OMPUntiedClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPUntiedClause(From);
  }

  public static OMPUntiedClause dyn_cast_OMPUntiedClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static OMPUntiedClause dyn_cast_or_null_OMPUntiedClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static boolean isa_OMPUntiedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPUntiedClause.class, From.$star());
  }

  public static OMPUntiedClause cast_OMPUntiedClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPUntiedClause(From);
    return llvm.cast(OMPUntiedClause.class, From.$star());
  }

  public static OMPUntiedClause cast_or_null_OMPUntiedClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPUntiedClause(From);
  }

  public static OMPUntiedClause dyn_cast_OMPUntiedClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static OMPUntiedClause dyn_cast_or_null_OMPUntiedClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static boolean isa_OMPUntiedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPUntiedClause.class, From.$deref());
  }

  public static OMPUntiedClause cast_OMPUntiedClause(type$ref<?>/*P*/ From) {
    assert isa_OMPUntiedClause(From);
    return llvm.cast(OMPUntiedClause.class, From.$deref());
  }

  public static OMPUntiedClause cast_or_null_OMPUntiedClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPUntiedClause(From);
  }

  public static OMPUntiedClause dyn_cast_OMPUntiedClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static OMPUntiedClause dyn_cast_or_null_OMPUntiedClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPUntiedClause(From) ? cast_OMPUntiedClause(From) : null;
  }

  public static boolean isa_OMPUpdateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPUpdateClause.class, From.$star());
  }

  public static OMPUpdateClause cast_OMPUpdateClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPUpdateClause(From);
    return llvm.cast(OMPUpdateClause.class, From.$star());
  }

  public static OMPUpdateClause cast_or_null_OMPUpdateClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPUpdateClause(From);
  }

  public static OMPUpdateClause dyn_cast_OMPUpdateClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static OMPUpdateClause dyn_cast_or_null_OMPUpdateClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static boolean isa_OMPUpdateClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPUpdateClause.classof(From);
  }

  public static OMPUpdateClause cast_OMPUpdateClause(OMPClause/*P*/ From) {
    assert isa_OMPUpdateClause(From);
    return (OMPUpdateClause) From;
  }

  public static OMPUpdateClause cast_or_null_OMPUpdateClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPUpdateClause(From);
  }

  public static OMPUpdateClause dyn_cast_OMPUpdateClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static OMPUpdateClause dyn_cast_or_null_OMPUpdateClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static boolean isa_OMPUpdateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPUpdateClause.class, From.$deref());
  }

  public static OMPUpdateClause cast_OMPUpdateClause(type$ref<?>/*P*/ From) {
    assert isa_OMPUpdateClause(From);
    return llvm.cast(OMPUpdateClause.class, From.$deref());
  }

  public static OMPUpdateClause cast_or_null_OMPUpdateClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPUpdateClause(From);
  }

  public static OMPUpdateClause dyn_cast_OMPUpdateClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static OMPUpdateClause dyn_cast_or_null_OMPUpdateClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPUpdateClause(From) ? cast_OMPUpdateClause(From) : null;
  }

  public static boolean isa_OMPUseDevicePtrClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPUseDevicePtrClause.class, From.$deref());
  }

  public static OMPUseDevicePtrClause cast_OMPUseDevicePtrClause(type$ref<?>/*P*/ From) {
    assert isa_OMPUseDevicePtrClause(From);
    return llvm.cast(OMPUseDevicePtrClause.class, From.$deref());
  }

  public static OMPUseDevicePtrClause cast_or_null_OMPUseDevicePtrClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPUseDevicePtrClause(From);
  }

  public static OMPUseDevicePtrClause dyn_cast_OMPUseDevicePtrClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static OMPUseDevicePtrClause dyn_cast_or_null_OMPUseDevicePtrClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPUseDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPUseDevicePtrClause.class, From.$star());
  }

  public static OMPUseDevicePtrClause cast_OMPUseDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPUseDevicePtrClause(From);
    return llvm.cast(OMPUseDevicePtrClause.class, From.$star());
  }

  public static OMPUseDevicePtrClause cast_or_null_OMPUseDevicePtrClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPUseDevicePtrClause(From);
  }

  public static OMPUseDevicePtrClause dyn_cast_OMPUseDevicePtrClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static OMPUseDevicePtrClause dyn_cast_or_null_OMPUseDevicePtrClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPUseDevicePtrClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPUseDevicePtrClause.classof(From);
  }

  public static OMPUseDevicePtrClause cast_OMPUseDevicePtrClause(OMPClause/*P*/ From) {
    assert isa_OMPUseDevicePtrClause(From);
    return (OMPUseDevicePtrClause) From;
  }

  public static OMPUseDevicePtrClause cast_or_null_OMPUseDevicePtrClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPUseDevicePtrClause(From);
  }

  public static OMPUseDevicePtrClause dyn_cast_OMPUseDevicePtrClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static OMPUseDevicePtrClause dyn_cast_or_null_OMPUseDevicePtrClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPUseDevicePtrClause(From) ? cast_OMPUseDevicePtrClause(From) : null;
  }

  public static boolean isa_OMPVarListClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPVarListClause.class, From.$deref());
  }

  public static OMPVarListClause cast_OMPVarListClause(type$ref<?>/*P*/ From) {
    assert isa_OMPVarListClause(From);
    return llvm.cast(OMPVarListClause.class, From.$deref());
  }

  public static OMPVarListClause cast_or_null_OMPVarListClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPVarListClause(From);
  }

  public static OMPVarListClause dyn_cast_OMPVarListClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static OMPVarListClause dyn_cast_or_null_OMPVarListClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static boolean isa_OMPVarListClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPVarListClause.class, From.$star());
  }

  public static OMPVarListClause cast_OMPVarListClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPVarListClause(From);
    return llvm.cast(OMPVarListClause.class, From.$star());
  }

  public static OMPVarListClause cast_or_null_OMPVarListClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPVarListClause(From);
  }

  public static OMPVarListClause dyn_cast_OMPVarListClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static OMPVarListClause dyn_cast_or_null_OMPVarListClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static boolean isa_OMPVarListClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPVarListClause.classof(From);
  }

  public static OMPVarListClause cast_OMPVarListClause(OMPClause/*P*/ From) {
    assert isa_OMPVarListClause(From);
    return (OMPVarListClause) From;
  }

  public static OMPVarListClause cast_or_null_OMPVarListClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPVarListClause(From);
  }

  public static OMPVarListClause dyn_cast_OMPVarListClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static OMPVarListClause dyn_cast_or_null_OMPVarListClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPVarListClause(From) ? cast_OMPVarListClause(From) : null;
  }

  public static boolean isa_OMPWriteClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPWriteClause.class, From.$deref());
  }

  public static OMPWriteClause cast_OMPWriteClause(type$ref<?>/*P*/ From) {
    assert isa_OMPWriteClause(From);
    return llvm.cast(OMPWriteClause.class, From.$deref());
  }

  public static OMPWriteClause cast_or_null_OMPWriteClause(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPWriteClause(From);
  }

  public static OMPWriteClause dyn_cast_OMPWriteClause(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static OMPWriteClause dyn_cast_or_null_OMPWriteClause(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static boolean isa_OMPWriteClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPWriteClause.class, From.$star());
  }

  public static OMPWriteClause cast_OMPWriteClause(type$ptr<?>/*P*/ From) {
    assert isa_OMPWriteClause(From);
    return llvm.cast(OMPWriteClause.class, From.$star());
  }

  public static OMPWriteClause cast_or_null_OMPWriteClause(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPWriteClause(From);
  }

  public static OMPWriteClause dyn_cast_OMPWriteClause(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static OMPWriteClause dyn_cast_or_null_OMPWriteClause(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static boolean isa_OMPWriteClause(OMPClause/*P*/ From) {
    assert From != null;
    return OMPWriteClause.classof(From);
  }

  public static OMPWriteClause cast_OMPWriteClause(OMPClause/*P*/ From) {
    assert isa_OMPWriteClause(From);
    return (OMPWriteClause) From;
  }

  public static OMPWriteClause cast_or_null_OMPWriteClause(OMPClause/*P*/ From) {
    return (From == null) ? null : cast_OMPWriteClause(From);
  }

  public static OMPWriteClause dyn_cast_OMPWriteClause(OMPClause/*P*/ From) {
    assert From != null;
    return isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static OMPWriteClause dyn_cast_or_null_OMPWriteClause(OMPClause/*P*/ From) {
    return (From != null) && isa_OMPWriteClause(From) ? cast_OMPWriteClause(From) : null;
  }

  public static boolean isa_ObjCArrayLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCArrayLiteral.class, From.$deref());
  }

  public static ObjCArrayLiteral cast_ObjCArrayLiteral(type$ref<?>/*P*/ From) {
    assert isa_ObjCArrayLiteral(From);
    return llvm.cast(ObjCArrayLiteral.class, From.$deref());
  }

  public static ObjCArrayLiteral cast_or_null_ObjCArrayLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCArrayLiteral(From);
  }

  public static ObjCArrayLiteral dyn_cast_ObjCArrayLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static ObjCArrayLiteral dyn_cast_or_null_ObjCArrayLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static boolean isa_ObjCArrayLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCArrayLiteral.class, From.$star());
  }

  public static ObjCArrayLiteral cast_ObjCArrayLiteral(type$ptr<?>/*P*/ From) {
    assert isa_ObjCArrayLiteral(From);
    return llvm.cast(ObjCArrayLiteral.class, From.$star());
  }

  public static ObjCArrayLiteral cast_or_null_ObjCArrayLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCArrayLiteral(From);
  }

  public static ObjCArrayLiteral dyn_cast_ObjCArrayLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static ObjCArrayLiteral dyn_cast_or_null_ObjCArrayLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static boolean isa_ObjCArrayLiteral(Stmt/*P*/ From) {
    assert From != null;
    return ObjCArrayLiteral.classof(From);
  }

  public static ObjCArrayLiteral cast_ObjCArrayLiteral(Stmt/*P*/ From) {
    assert isa_ObjCArrayLiteral(From);
    return (ObjCArrayLiteral) From;
  }

  public static ObjCArrayLiteral cast_or_null_ObjCArrayLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCArrayLiteral(From);
  }

  public static ObjCArrayLiteral dyn_cast_ObjCArrayLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static ObjCArrayLiteral dyn_cast_or_null_ObjCArrayLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCArrayLiteral(From) ? cast_ObjCArrayLiteral(From) : null;
  }

  public static boolean isa_ObjCDictionaryLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCDictionaryLiteral.class, From.$deref());
  }

  public static ObjCDictionaryLiteral cast_ObjCDictionaryLiteral(type$ref<?>/*P*/ From) {
    assert isa_ObjCDictionaryLiteral(From);
    return llvm.cast(ObjCDictionaryLiteral.class, From.$deref());
  }

  public static ObjCDictionaryLiteral cast_or_null_ObjCDictionaryLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCDictionaryLiteral(From);
  }

  public static ObjCDictionaryLiteral dyn_cast_ObjCDictionaryLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static ObjCDictionaryLiteral dyn_cast_or_null_ObjCDictionaryLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static boolean isa_ObjCDictionaryLiteral(Stmt/*P*/ From) {
    assert From != null;
    return ObjCDictionaryLiteral.classof(From);
  }

  public static ObjCDictionaryLiteral cast_ObjCDictionaryLiteral(Stmt/*P*/ From) {
    assert isa_ObjCDictionaryLiteral(From);
    return (ObjCDictionaryLiteral) From;
  }

  public static ObjCDictionaryLiteral cast_or_null_ObjCDictionaryLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCDictionaryLiteral(From);
  }

  public static ObjCDictionaryLiteral dyn_cast_ObjCDictionaryLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static ObjCDictionaryLiteral dyn_cast_or_null_ObjCDictionaryLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static boolean isa_ObjCDictionaryLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCDictionaryLiteral.class, From.$star());
  }

  public static ObjCDictionaryLiteral cast_ObjCDictionaryLiteral(type$ptr<?>/*P*/ From) {
    assert isa_ObjCDictionaryLiteral(From);
    return llvm.cast(ObjCDictionaryLiteral.class, From.$star());
  }

  public static ObjCDictionaryLiteral cast_or_null_ObjCDictionaryLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCDictionaryLiteral(From);
  }

  public static ObjCDictionaryLiteral dyn_cast_ObjCDictionaryLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static ObjCDictionaryLiteral dyn_cast_or_null_ObjCDictionaryLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCDictionaryLiteral(From) ? cast_ObjCDictionaryLiteral(From) : null;
  }

  public static boolean isa_ObjCObjectTypeImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCObjectTypeImpl.class, From.$deref());
  }

  public static ObjCObjectTypeImpl cast_ObjCObjectTypeImpl(type$ref<?>/*P*/ From) {
    assert isa_ObjCObjectTypeImpl(From);
    return llvm.cast(ObjCObjectTypeImpl.class, From.$deref());
  }

  public static ObjCObjectTypeImpl cast_or_null_ObjCObjectTypeImpl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCObjectTypeImpl(From);
  }

  public static ObjCObjectTypeImpl dyn_cast_ObjCObjectTypeImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static ObjCObjectTypeImpl dyn_cast_or_null_ObjCObjectTypeImpl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static boolean isa_ObjCObjectTypeImpl(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl cast_ObjCObjectTypeImpl(CanQual<? extends Type>/*P*/ From) {
    return cast_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl cast_or_null_ObjCObjectTypeImpl(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl dyn_cast_ObjCObjectTypeImpl(CanQual<? extends Type>/*P*/ From) {
    return isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static ObjCObjectTypeImpl dyn_cast_or_null_ObjCObjectTypeImpl(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static boolean isa_ObjCObjectTypeImpl(Type/*P*/ From) {
    assert From != null;
    return ObjCObjectTypeImpl.classof(From);
  }

  public static ObjCObjectTypeImpl cast_ObjCObjectTypeImpl(Type/*P*/ From) {
    assert isa_ObjCObjectTypeImpl(From);
    return (ObjCObjectTypeImpl) From;
  }

  public static ObjCObjectTypeImpl cast_or_null_ObjCObjectTypeImpl(Type/*P*/ From) {
    return (From == null) ? null : cast_ObjCObjectTypeImpl(From);
  }

  public static ObjCObjectTypeImpl dyn_cast_ObjCObjectTypeImpl(Type/*P*/ From) {
    assert From != null;
    return isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static ObjCObjectTypeImpl dyn_cast_or_null_ObjCObjectTypeImpl(Type/*P*/ From) {
    return (From != null) && isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static boolean isa_ObjCObjectTypeImpl(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl cast_ObjCObjectTypeImpl(QualType/*P*/ From) {
    return cast_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl cast_or_null_ObjCObjectTypeImpl(QualType/*P*/ From) {
    return cast_or_null_ObjCObjectTypeImpl(From.getTypePtr());
  }

  public static ObjCObjectTypeImpl dyn_cast_ObjCObjectTypeImpl(QualType/*P*/ From) {
    return isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static ObjCObjectTypeImpl dyn_cast_or_null_ObjCObjectTypeImpl(QualType/*P*/ From) {
    return (From != null) && isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static boolean isa_ObjCObjectTypeImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCObjectTypeImpl.class, From.$star());
  }

  public static ObjCObjectTypeImpl cast_ObjCObjectTypeImpl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCObjectTypeImpl(From);
    return llvm.cast(ObjCObjectTypeImpl.class, From.$star());
  }

  public static ObjCObjectTypeImpl cast_or_null_ObjCObjectTypeImpl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCObjectTypeImpl(From);
  }

  public static ObjCObjectTypeImpl dyn_cast_ObjCObjectTypeImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static ObjCObjectTypeImpl dyn_cast_or_null_ObjCObjectTypeImpl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCObjectTypeImpl(From) ? cast_ObjCObjectTypeImpl(From) : null;
  }

  public static boolean isa_ObjCStringLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCStringLiteral.class, From.$deref());
  }

  public static ObjCStringLiteral cast_ObjCStringLiteral(type$ref<?>/*P*/ From) {
    assert isa_ObjCStringLiteral(From);
    return llvm.cast(ObjCStringLiteral.class, From.$deref());
  }

  public static ObjCStringLiteral cast_or_null_ObjCStringLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCStringLiteral(From);
  }

  public static ObjCStringLiteral dyn_cast_ObjCStringLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static ObjCStringLiteral dyn_cast_or_null_ObjCStringLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static boolean isa_ObjCStringLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCStringLiteral.class, From.$star());
  }

  public static ObjCStringLiteral cast_ObjCStringLiteral(type$ptr<?>/*P*/ From) {
    assert isa_ObjCStringLiteral(From);
    return llvm.cast(ObjCStringLiteral.class, From.$star());
  }

  public static ObjCStringLiteral cast_or_null_ObjCStringLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCStringLiteral(From);
  }

  public static ObjCStringLiteral dyn_cast_ObjCStringLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static ObjCStringLiteral dyn_cast_or_null_ObjCStringLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static boolean isa_ObjCStringLiteral(Stmt/*P*/ From) {
    assert From != null;
    return ObjCStringLiteral.classof(From);
  }

  public static ObjCStringLiteral cast_ObjCStringLiteral(Stmt/*P*/ From) {
    assert isa_ObjCStringLiteral(From);
    return (ObjCStringLiteral) From;
  }

  public static ObjCStringLiteral cast_or_null_ObjCStringLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCStringLiteral(From);
  }

  public static ObjCStringLiteral dyn_cast_ObjCStringLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static ObjCStringLiteral dyn_cast_or_null_ObjCStringLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCStringLiteral(From) ? cast_ObjCStringLiteral(From) : null;
  }

  public static boolean isa_StringLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StringLiteral.class, From.$star());
  }

  public static StringLiteral cast_StringLiteral(type$ptr<?>/*P*/ From) {
    assert isa_StringLiteral(From);
    return llvm.cast(StringLiteral.class, From.$star());
  }

  public static StringLiteral cast_or_null_StringLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StringLiteral(From);
  }

  public static StringLiteral dyn_cast_StringLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static StringLiteral dyn_cast_or_null_StringLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static boolean isa_StringLiteral(Stmt/*P*/ From) {
    assert From != null;
    return StringLiteral.classof(From);
  }

  public static StringLiteral cast_StringLiteral(Stmt/*P*/ From) {
    assert isa_StringLiteral(From);
    return (StringLiteral) From;
  }

  public static StringLiteral cast_or_null_StringLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_StringLiteral(From);
  }

  public static StringLiteral dyn_cast_StringLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static StringLiteral dyn_cast_or_null_StringLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static boolean isa_StringLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StringLiteral.class, From.$deref());
  }

  public static StringLiteral cast_StringLiteral(type$ref<?>/*P*/ From) {
    assert isa_StringLiteral(From);
    return llvm.cast(StringLiteral.class, From.$deref());
  }

  public static StringLiteral cast_or_null_StringLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StringLiteral(From);
  }

  public static StringLiteral dyn_cast_StringLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static StringLiteral dyn_cast_or_null_StringLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StringLiteral(From) ? cast_StringLiteral(From) : null;
  }

  public static boolean isa_SwitchCase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwitchCase.class, From.$star());
  }

  public static SwitchCase cast_SwitchCase(type$ptr<?>/*P*/ From) {
    assert isa_SwitchCase(From);
    return llvm.cast(SwitchCase.class, From.$star());
  }

  public static SwitchCase cast_or_null_SwitchCase(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwitchCase(From);
  }

  public static SwitchCase dyn_cast_SwitchCase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static SwitchCase dyn_cast_or_null_SwitchCase(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static boolean isa_SwitchCase(Stmt/*P*/ From) {
    assert From != null;
    return SwitchCase.classof(From);
  }

  public static SwitchCase cast_SwitchCase(Stmt/*P*/ From) {
    assert isa_SwitchCase(From);
    return (SwitchCase) From;
  }

  public static SwitchCase cast_or_null_SwitchCase(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SwitchCase(From);
  }

  public static SwitchCase dyn_cast_SwitchCase(Stmt/*P*/ From) {
    assert From != null;
    return isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static SwitchCase dyn_cast_or_null_SwitchCase(Stmt/*P*/ From) {
    return (From != null) && isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static boolean isa_SwitchCase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwitchCase.class, From.$deref());
  }

  public static SwitchCase cast_SwitchCase(type$ref<?>/*P*/ From) {
    assert isa_SwitchCase(From);
    return llvm.cast(SwitchCase.class, From.$deref());
  }

  public static SwitchCase cast_or_null_SwitchCase(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwitchCase(From);
  }

  public static SwitchCase dyn_cast_SwitchCase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static SwitchCase dyn_cast_or_null_SwitchCase(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwitchCase(From) ? cast_SwitchCase(From) : null;
  }

  public static boolean isa_TypeWithKeyword(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeWithKeyword.class, From.$star());
  }

  public static TypeWithKeyword cast_TypeWithKeyword(type$ptr<?>/*P*/ From) {
    assert isa_TypeWithKeyword(From);
    return llvm.cast(TypeWithKeyword.class, From.$star());
  }

  public static TypeWithKeyword cast_or_null_TypeWithKeyword(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeWithKeyword(From);
  }

  public static TypeWithKeyword dyn_cast_TypeWithKeyword(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static TypeWithKeyword dyn_cast_or_null_TypeWithKeyword(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static boolean isa_TypeWithKeyword(CanQual<? extends Type>/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword cast_TypeWithKeyword(CanQual<? extends Type>/*P*/ From) {
    return cast_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword cast_or_null_TypeWithKeyword(CanQual<? extends Type>/*P*/ From) {
    return cast_or_null_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword dyn_cast_TypeWithKeyword(CanQual<? extends Type>/*P*/ From) {
    return isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static TypeWithKeyword dyn_cast_or_null_TypeWithKeyword(CanQual<? extends Type>/*P*/ From) {
    return (From != null) && isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static boolean isa_TypeWithKeyword(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeWithKeyword.class, From.$deref());
  }

  public static TypeWithKeyword cast_TypeWithKeyword(type$ref<?>/*P*/ From) {
    assert isa_TypeWithKeyword(From);
    return llvm.cast(TypeWithKeyword.class, From.$deref());
  }

  public static TypeWithKeyword cast_or_null_TypeWithKeyword(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeWithKeyword(From);
  }

  public static TypeWithKeyword dyn_cast_TypeWithKeyword(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static TypeWithKeyword dyn_cast_or_null_TypeWithKeyword(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static boolean isa_TypeWithKeyword(Type/*P*/ From) {
    assert From != null;
    return llvm.isa(TypeWithKeyword.class, From);
  }

  public static TypeWithKeyword cast_TypeWithKeyword(Type/*P*/ From) {
    assert isa_TypeWithKeyword(From);
    return (TypeWithKeyword) From;
  }

  public static TypeWithKeyword cast_or_null_TypeWithKeyword(Type/*P*/ From) {
    return (From == null) ? null : cast_TypeWithKeyword(From);
  }

  public static TypeWithKeyword dyn_cast_TypeWithKeyword(Type/*P*/ From) {
    assert From != null;
    return isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static TypeWithKeyword dyn_cast_or_null_TypeWithKeyword(Type/*P*/ From) {
    return (From != null) && isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static boolean isa_TypeWithKeyword(QualType/*P*/ From) {
    assert From != null && From.getTypePtr() != null;
    return isa_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword cast_TypeWithKeyword(QualType/*P*/ From) {
    return cast_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword cast_or_null_TypeWithKeyword(QualType/*P*/ From) {
    return cast_or_null_TypeWithKeyword(From.getTypePtr());
  }

  public static TypeWithKeyword dyn_cast_TypeWithKeyword(QualType/*P*/ From) {
    return isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static TypeWithKeyword dyn_cast_or_null_TypeWithKeyword(QualType/*P*/ From) {
    return (From != null) && isa_TypeWithKeyword(From) ? cast_TypeWithKeyword(From) : null;
  }

  public static boolean isa_UnaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryOperator.class, From.$star());
  }

  public static UnaryOperator cast_UnaryOperator(type$ptr<?>/*P*/ From) {
    assert isa_UnaryOperator(From);
    return llvm.cast(UnaryOperator.class, From.$star());
  }

  public static UnaryOperator cast_or_null_UnaryOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryOperator(From);
  }

  public static UnaryOperator dyn_cast_UnaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static UnaryOperator dyn_cast_or_null_UnaryOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static boolean isa_UnaryOperator(Stmt/*P*/ From) {
    assert From != null;
    return UnaryOperator.classof(From);
  }

  public static UnaryOperator cast_UnaryOperator(Stmt/*P*/ From) {
    assert isa_UnaryOperator(From);
    return (UnaryOperator) From;
  }

  public static UnaryOperator cast_or_null_UnaryOperator(Stmt/*P*/ From) {
    return (From == null) ? null : cast_UnaryOperator(From);
  }

  public static UnaryOperator dyn_cast_UnaryOperator(Stmt/*P*/ From) {
    assert From != null;
    return isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static UnaryOperator dyn_cast_or_null_UnaryOperator(Stmt/*P*/ From) {
    return (From != null) && isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static boolean isa_UnaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryOperator.class, From.$deref());
  }

  public static UnaryOperator cast_UnaryOperator(type$ref<?>/*P*/ From) {
    assert isa_UnaryOperator(From);
    return llvm.cast(UnaryOperator.class, From.$deref());
  }

  public static UnaryOperator cast_or_null_UnaryOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryOperator(From);
  }

  public static UnaryOperator dyn_cast_UnaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static UnaryOperator dyn_cast_or_null_UnaryOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryOperator(From) ? cast_UnaryOperator(From) : null;
  }

  public static boolean isa_UserDefinedLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UserDefinedLiteral.class, From.$star());
  }

  public static UserDefinedLiteral cast_UserDefinedLiteral(type$ptr<?>/*P*/ From) {
    assert isa_UserDefinedLiteral(From);
    return llvm.cast(UserDefinedLiteral.class, From.$star());
  }

  public static UserDefinedLiteral cast_or_null_UserDefinedLiteral(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UserDefinedLiteral(From);
  }

  public static UserDefinedLiteral dyn_cast_UserDefinedLiteral(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static UserDefinedLiteral dyn_cast_or_null_UserDefinedLiteral(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static boolean isa_UserDefinedLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UserDefinedLiteral.class, From.$deref());
  }

  public static UserDefinedLiteral cast_UserDefinedLiteral(type$ref<?>/*P*/ From) {
    assert isa_UserDefinedLiteral(From);
    return llvm.cast(UserDefinedLiteral.class, From.$deref());
  }

  public static UserDefinedLiteral cast_or_null_UserDefinedLiteral(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UserDefinedLiteral(From);
  }

  public static UserDefinedLiteral dyn_cast_UserDefinedLiteral(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static UserDefinedLiteral dyn_cast_or_null_UserDefinedLiteral(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static boolean isa_UserDefinedLiteral(Stmt/*P*/ From) {
    assert From != null;
    return UserDefinedLiteral.classof(From);
  }

  public static UserDefinedLiteral cast_UserDefinedLiteral(Stmt/*P*/ From) {
    assert isa_UserDefinedLiteral(From);
    return (UserDefinedLiteral) From;
  }

  public static UserDefinedLiteral cast_or_null_UserDefinedLiteral(Stmt/*P*/ From) {
    return (From == null) ? null : cast_UserDefinedLiteral(From);
  }

  public static UserDefinedLiteral dyn_cast_UserDefinedLiteral(Stmt/*P*/ From) {
    assert From != null;
    return isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static UserDefinedLiteral dyn_cast_or_null_UserDefinedLiteral(Stmt/*P*/ From) {
    return (From != null) && isa_UserDefinedLiteral(From) ? cast_UserDefinedLiteral(From) : null;
  }

  public static boolean isa_VTableContextBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VTableContextBase.class, From.$deref());
  }

  public static VTableContextBase cast_VTableContextBase(type$ref<?>/*P*/ From) {
    assert isa_VTableContextBase(From);
    return llvm.cast(VTableContextBase.class, From.$deref());
  }

  public static VTableContextBase cast_or_null_VTableContextBase(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VTableContextBase(From);
  }

  public static VTableContextBase dyn_cast_VTableContextBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static VTableContextBase dyn_cast_or_null_VTableContextBase(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static boolean isa_VTableContextBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VTableContextBase.class, From.$star());
  }

  public static VTableContextBase cast_VTableContextBase(type$ptr<?>/*P*/ From) {
    assert isa_VTableContextBase(From);
    return llvm.cast(VTableContextBase.class, From.$star());
  }

  public static VTableContextBase cast_or_null_VTableContextBase(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VTableContextBase(From);
  }

  public static VTableContextBase dyn_cast_VTableContextBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static VTableContextBase dyn_cast_or_null_VTableContextBase(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static boolean isa_VTableContextBase(VTableContextBase/*P*/ From) {
    assert From != null;
    return true;
  }

  public static VTableContextBase cast_VTableContextBase(VTableContextBase/*P*/ From) {
    assert isa_VTableContextBase(From);
    return (VTableContextBase) From;
  }

  public static VTableContextBase cast_or_null_VTableContextBase(VTableContextBase/*P*/ From) {
    return (From == null) ? null : cast_VTableContextBase(From);
  }

  public static VTableContextBase dyn_cast_VTableContextBase(VTableContextBase/*P*/ From) {
    assert From != null;
    return isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static VTableContextBase dyn_cast_or_null_VTableContextBase(VTableContextBase/*P*/ From) {
    return (From != null) && isa_VTableContextBase(From) ? cast_VTableContextBase(From) : null;
  }

  public static boolean isa_BlockCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockCommandComment.class, From.$deref());
  }

  public static BlockCommandComment cast_BlockCommandComment(type$ref<?>/*P*/ From) {
    assert isa_BlockCommandComment(From);
    return llvm.cast(BlockCommandComment.class, From.$deref());
  }

  public static BlockCommandComment cast_or_null_BlockCommandComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockCommandComment(From);
  }

  public static BlockCommandComment dyn_cast_BlockCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static BlockCommandComment dyn_cast_or_null_BlockCommandComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static boolean isa_BlockCommandComment(Comment/*P*/ From) {
    assert From != null;
    return BlockCommandComment.classof(From);
  }

  public static BlockCommandComment cast_BlockCommandComment(Comment/*P*/ From) {
    assert isa_BlockCommandComment(From);
    return (BlockCommandComment) From;
  }

  public static BlockCommandComment cast_or_null_BlockCommandComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_BlockCommandComment(From);
  }

  public static BlockCommandComment dyn_cast_BlockCommandComment(Comment/*P*/ From) {
    assert From != null;
    return isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static BlockCommandComment dyn_cast_or_null_BlockCommandComment(Comment/*P*/ From) {
    return (From != null) && isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static boolean isa_BlockCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockCommandComment.class, From.$star());
  }

  public static BlockCommandComment cast_BlockCommandComment(type$ptr<?>/*P*/ From) {
    assert isa_BlockCommandComment(From);
    return llvm.cast(BlockCommandComment.class, From.$star());
  }

  public static BlockCommandComment cast_or_null_BlockCommandComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockCommandComment(From);
  }

  public static BlockCommandComment dyn_cast_BlockCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static BlockCommandComment dyn_cast_or_null_BlockCommandComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockCommandComment(From) ? cast_BlockCommandComment(From) : null;
  }

  public static boolean isa_BlockContentComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockContentComment.class, From.$deref());
  }

  public static BlockContentComment cast_BlockContentComment(type$ref<?>/*P*/ From) {
    assert isa_BlockContentComment(From);
    return llvm.cast(BlockContentComment.class, From.$deref());
  }

  public static BlockContentComment cast_or_null_BlockContentComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockContentComment(From);
  }

  public static BlockContentComment dyn_cast_BlockContentComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static BlockContentComment dyn_cast_or_null_BlockContentComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static boolean isa_BlockContentComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockContentComment.class, From.$star());
  }

  public static BlockContentComment cast_BlockContentComment(type$ptr<?>/*P*/ From) {
    assert isa_BlockContentComment(From);
    return llvm.cast(BlockContentComment.class, From.$star());
  }

  public static BlockContentComment cast_or_null_BlockContentComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockContentComment(From);
  }

  public static BlockContentComment dyn_cast_BlockContentComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static BlockContentComment dyn_cast_or_null_BlockContentComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static boolean isa_BlockContentComment(Comment/*P*/ From) {
    assert From != null;
    return BlockContentComment.classof(From);
  }

  public static BlockContentComment cast_BlockContentComment(Comment/*P*/ From) {
    assert isa_BlockContentComment(From);
    return (BlockContentComment) From;
  }

  public static BlockContentComment cast_or_null_BlockContentComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_BlockContentComment(From);
  }

  public static BlockContentComment dyn_cast_BlockContentComment(Comment/*P*/ From) {
    assert From != null;
    return isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static BlockContentComment dyn_cast_or_null_BlockContentComment(Comment/*P*/ From) {
    return (From != null) && isa_BlockContentComment(From) ? cast_BlockContentComment(From) : null;
  }

  public static boolean isa_Comment(Comment/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Comment cast_Comment(Comment/*P*/ From) {
    assert isa_Comment(From);
    return (Comment) From;
  }

  public static Comment cast_or_null_Comment(Comment/*P*/ From) {
    return (From == null) ? null : cast_Comment(From);
  }

  public static Comment dyn_cast_Comment(Comment/*P*/ From) {
    assert From != null;
    return isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static Comment dyn_cast_or_null_Comment(Comment/*P*/ From) {
    return (From != null) && isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static boolean isa_Comment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Comment.class, From.$deref());
  }

  public static Comment cast_Comment(type$ref<?>/*P*/ From) {
    assert isa_Comment(From);
    return llvm.cast(Comment.class, From.$deref());
  }

  public static Comment cast_or_null_Comment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Comment(From);
  }

  public static Comment dyn_cast_Comment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static Comment dyn_cast_or_null_Comment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static boolean isa_Comment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Comment.class, From.$star());
  }

  public static Comment cast_Comment(type$ptr<?>/*P*/ From) {
    assert isa_Comment(From);
    return llvm.cast(Comment.class, From.$star());
  }

  public static Comment cast_or_null_Comment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Comment(From);
  }

  public static Comment dyn_cast_Comment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static Comment dyn_cast_or_null_Comment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Comment(From) ? cast_Comment(From) : null;
  }

  public static boolean isa_FullComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FullComment.class, From.$star());
  }

  public static FullComment cast_FullComment(type$ptr<?>/*P*/ From) {
    assert isa_FullComment(From);
    return llvm.cast(FullComment.class, From.$star());
  }

  public static FullComment cast_or_null_FullComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FullComment(From);
  }

  public static FullComment dyn_cast_FullComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static FullComment dyn_cast_or_null_FullComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static boolean isa_FullComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FullComment.class, From.$deref());
  }

  public static FullComment cast_FullComment(type$ref<?>/*P*/ From) {
    assert isa_FullComment(From);
    return llvm.cast(FullComment.class, From.$deref());
  }

  public static FullComment cast_or_null_FullComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FullComment(From);
  }

  public static FullComment dyn_cast_FullComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static FullComment dyn_cast_or_null_FullComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static boolean isa_FullComment(Comment/*P*/ From) {
    assert From != null;
    return FullComment.classof(From);
  }

  public static FullComment cast_FullComment(Comment/*P*/ From) {
    assert isa_FullComment(From);
    return (FullComment) From;
  }

  public static FullComment cast_or_null_FullComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_FullComment(From);
  }

  public static FullComment dyn_cast_FullComment(Comment/*P*/ From) {
    assert From != null;
    return isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static FullComment dyn_cast_or_null_FullComment(Comment/*P*/ From) {
    return (From != null) && isa_FullComment(From) ? cast_FullComment(From) : null;
  }

  public static boolean isa_HTMLEndTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(HTMLEndTagComment.class, From.$deref());
  }

  public static HTMLEndTagComment cast_HTMLEndTagComment(type$ref<?>/*P*/ From) {
    assert isa_HTMLEndTagComment(From);
    return llvm.cast(HTMLEndTagComment.class, From.$deref());
  }

  public static HTMLEndTagComment cast_or_null_HTMLEndTagComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_HTMLEndTagComment(From);
  }

  public static HTMLEndTagComment dyn_cast_HTMLEndTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static HTMLEndTagComment dyn_cast_or_null_HTMLEndTagComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static boolean isa_HTMLEndTagComment(Comment/*P*/ From) {
    assert From != null;
    return HTMLEndTagComment.classof(From);
  }

  public static HTMLEndTagComment cast_HTMLEndTagComment(Comment/*P*/ From) {
    assert isa_HTMLEndTagComment(From);
    return (HTMLEndTagComment) From;
  }

  public static HTMLEndTagComment cast_or_null_HTMLEndTagComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_HTMLEndTagComment(From);
  }

  public static HTMLEndTagComment dyn_cast_HTMLEndTagComment(Comment/*P*/ From) {
    assert From != null;
    return isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static HTMLEndTagComment dyn_cast_or_null_HTMLEndTagComment(Comment/*P*/ From) {
    return (From != null) && isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static boolean isa_HTMLEndTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(HTMLEndTagComment.class, From.$star());
  }

  public static HTMLEndTagComment cast_HTMLEndTagComment(type$ptr<?>/*P*/ From) {
    assert isa_HTMLEndTagComment(From);
    return llvm.cast(HTMLEndTagComment.class, From.$star());
  }

  public static HTMLEndTagComment cast_or_null_HTMLEndTagComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_HTMLEndTagComment(From);
  }

  public static HTMLEndTagComment dyn_cast_HTMLEndTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static HTMLEndTagComment dyn_cast_or_null_HTMLEndTagComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_HTMLEndTagComment(From) ? cast_HTMLEndTagComment(From) : null;
  }

  public static boolean isa_HTMLStartTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(HTMLStartTagComment.class, From.$deref());
  }

  public static HTMLStartTagComment cast_HTMLStartTagComment(type$ref<?>/*P*/ From) {
    assert isa_HTMLStartTagComment(From);
    return llvm.cast(HTMLStartTagComment.class, From.$deref());
  }

  public static HTMLStartTagComment cast_or_null_HTMLStartTagComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_HTMLStartTagComment(From);
  }

  public static HTMLStartTagComment dyn_cast_HTMLStartTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static HTMLStartTagComment dyn_cast_or_null_HTMLStartTagComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static boolean isa_HTMLStartTagComment(Comment/*P*/ From) {
    assert From != null;
    return HTMLStartTagComment.classof(From);
  }

  public static HTMLStartTagComment cast_HTMLStartTagComment(Comment/*P*/ From) {
    assert isa_HTMLStartTagComment(From);
    return (HTMLStartTagComment) From;
  }

  public static HTMLStartTagComment cast_or_null_HTMLStartTagComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_HTMLStartTagComment(From);
  }

  public static HTMLStartTagComment dyn_cast_HTMLStartTagComment(Comment/*P*/ From) {
    assert From != null;
    return isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static HTMLStartTagComment dyn_cast_or_null_HTMLStartTagComment(Comment/*P*/ From) {
    return (From != null) && isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static boolean isa_HTMLStartTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(HTMLStartTagComment.class, From.$star());
  }

  public static HTMLStartTagComment cast_HTMLStartTagComment(type$ptr<?>/*P*/ From) {
    assert isa_HTMLStartTagComment(From);
    return llvm.cast(HTMLStartTagComment.class, From.$star());
  }

  public static HTMLStartTagComment cast_or_null_HTMLStartTagComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_HTMLStartTagComment(From);
  }

  public static HTMLStartTagComment dyn_cast_HTMLStartTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static HTMLStartTagComment dyn_cast_or_null_HTMLStartTagComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_HTMLStartTagComment(From) ? cast_HTMLStartTagComment(From) : null;
  }

  public static boolean isa_HTMLTagComment(Comment/*P*/ From) {
    assert From != null;
    return HTMLTagComment.classof(From);
  }

  public static HTMLTagComment cast_HTMLTagComment(Comment/*P*/ From) {
    assert isa_HTMLTagComment(From);
    return (HTMLTagComment) From;
  }

  public static HTMLTagComment cast_or_null_HTMLTagComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_HTMLTagComment(From);
  }

  public static HTMLTagComment dyn_cast_HTMLTagComment(Comment/*P*/ From) {
    assert From != null;
    return isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static HTMLTagComment dyn_cast_or_null_HTMLTagComment(Comment/*P*/ From) {
    return (From != null) && isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static boolean isa_HTMLTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(HTMLTagComment.class, From.$deref());
  }

  public static HTMLTagComment cast_HTMLTagComment(type$ref<?>/*P*/ From) {
    assert isa_HTMLTagComment(From);
    return llvm.cast(HTMLTagComment.class, From.$deref());
  }

  public static HTMLTagComment cast_or_null_HTMLTagComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_HTMLTagComment(From);
  }

  public static HTMLTagComment dyn_cast_HTMLTagComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static HTMLTagComment dyn_cast_or_null_HTMLTagComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static boolean isa_HTMLTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(HTMLTagComment.class, From.$star());
  }

  public static HTMLTagComment cast_HTMLTagComment(type$ptr<?>/*P*/ From) {
    assert isa_HTMLTagComment(From);
    return llvm.cast(HTMLTagComment.class, From.$star());
  }

  public static HTMLTagComment cast_or_null_HTMLTagComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_HTMLTagComment(From);
  }

  public static HTMLTagComment dyn_cast_HTMLTagComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static HTMLTagComment dyn_cast_or_null_HTMLTagComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_HTMLTagComment(From) ? cast_HTMLTagComment(From) : null;
  }

  public static boolean isa_InlineCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InlineCommandComment.class, From.$deref());
  }

  public static InlineCommandComment cast_InlineCommandComment(type$ref<?>/*P*/ From) {
    assert isa_InlineCommandComment(From);
    return llvm.cast(InlineCommandComment.class, From.$deref());
  }

  public static InlineCommandComment cast_or_null_InlineCommandComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InlineCommandComment(From);
  }

  public static InlineCommandComment dyn_cast_InlineCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static InlineCommandComment dyn_cast_or_null_InlineCommandComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static boolean isa_InlineCommandComment(Comment/*P*/ From) {
    assert From != null;
    return InlineCommandComment.classof(From);
  }

  public static InlineCommandComment cast_InlineCommandComment(Comment/*P*/ From) {
    assert isa_InlineCommandComment(From);
    return (InlineCommandComment) From;
  }

  public static InlineCommandComment cast_or_null_InlineCommandComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_InlineCommandComment(From);
  }

  public static InlineCommandComment dyn_cast_InlineCommandComment(Comment/*P*/ From) {
    assert From != null;
    return isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static InlineCommandComment dyn_cast_or_null_InlineCommandComment(Comment/*P*/ From) {
    return (From != null) && isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static boolean isa_InlineCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InlineCommandComment.class, From.$star());
  }

  public static InlineCommandComment cast_InlineCommandComment(type$ptr<?>/*P*/ From) {
    assert isa_InlineCommandComment(From);
    return llvm.cast(InlineCommandComment.class, From.$star());
  }

  public static InlineCommandComment cast_or_null_InlineCommandComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InlineCommandComment(From);
  }

  public static InlineCommandComment dyn_cast_InlineCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static InlineCommandComment dyn_cast_or_null_InlineCommandComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InlineCommandComment(From) ? cast_InlineCommandComment(From) : null;
  }

  public static boolean isa_InlineContentComment(Comment/*P*/ From) {
    assert From != null;
    return InlineContentComment.classof(From);
  }

  public static InlineContentComment cast_InlineContentComment(Comment/*P*/ From) {
    assert isa_InlineContentComment(From);
    return (InlineContentComment) From;
  }

  public static InlineContentComment cast_or_null_InlineContentComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_InlineContentComment(From);
  }

  public static InlineContentComment dyn_cast_InlineContentComment(Comment/*P*/ From) {
    assert From != null;
    return isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static InlineContentComment dyn_cast_or_null_InlineContentComment(Comment/*P*/ From) {
    return (From != null) && isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static boolean isa_InlineContentComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InlineContentComment.class, From.$star());
  }

  public static InlineContentComment cast_InlineContentComment(type$ptr<?>/*P*/ From) {
    assert isa_InlineContentComment(From);
    return llvm.cast(InlineContentComment.class, From.$star());
  }

  public static InlineContentComment cast_or_null_InlineContentComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InlineContentComment(From);
  }

  public static InlineContentComment dyn_cast_InlineContentComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static InlineContentComment dyn_cast_or_null_InlineContentComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static boolean isa_InlineContentComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InlineContentComment.class, From.$deref());
  }

  public static InlineContentComment cast_InlineContentComment(type$ref<?>/*P*/ From) {
    assert isa_InlineContentComment(From);
    return llvm.cast(InlineContentComment.class, From.$deref());
  }

  public static InlineContentComment cast_or_null_InlineContentComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InlineContentComment(From);
  }

  public static InlineContentComment dyn_cast_InlineContentComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static InlineContentComment dyn_cast_or_null_InlineContentComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InlineContentComment(From) ? cast_InlineContentComment(From) : null;
  }

  public static boolean isa_ParagraphComment(Comment/*P*/ From) {
    assert From != null;
    return ParagraphComment.classof(From);
  }

  public static ParagraphComment cast_ParagraphComment(Comment/*P*/ From) {
    assert isa_ParagraphComment(From);
    return (ParagraphComment) From;
  }

  public static ParagraphComment cast_or_null_ParagraphComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_ParagraphComment(From);
  }

  public static ParagraphComment dyn_cast_ParagraphComment(Comment/*P*/ From) {
    assert From != null;
    return isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static ParagraphComment dyn_cast_or_null_ParagraphComment(Comment/*P*/ From) {
    return (From != null) && isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static boolean isa_ParagraphComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParagraphComment.class, From.$star());
  }

  public static ParagraphComment cast_ParagraphComment(type$ptr<?>/*P*/ From) {
    assert isa_ParagraphComment(From);
    return llvm.cast(ParagraphComment.class, From.$star());
  }

  public static ParagraphComment cast_or_null_ParagraphComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParagraphComment(From);
  }

  public static ParagraphComment dyn_cast_ParagraphComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static ParagraphComment dyn_cast_or_null_ParagraphComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static boolean isa_ParagraphComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParagraphComment.class, From.$deref());
  }

  public static ParagraphComment cast_ParagraphComment(type$ref<?>/*P*/ From) {
    assert isa_ParagraphComment(From);
    return llvm.cast(ParagraphComment.class, From.$deref());
  }

  public static ParagraphComment cast_or_null_ParagraphComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParagraphComment(From);
  }

  public static ParagraphComment dyn_cast_ParagraphComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static ParagraphComment dyn_cast_or_null_ParagraphComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParagraphComment(From) ? cast_ParagraphComment(From) : null;
  }

  public static boolean isa_ParamCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParamCommandComment.class, From.$deref());
  }

  public static ParamCommandComment cast_ParamCommandComment(type$ref<?>/*P*/ From) {
    assert isa_ParamCommandComment(From);
    return llvm.cast(ParamCommandComment.class, From.$deref());
  }

  public static ParamCommandComment cast_or_null_ParamCommandComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParamCommandComment(From);
  }

  public static ParamCommandComment dyn_cast_ParamCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static ParamCommandComment dyn_cast_or_null_ParamCommandComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static boolean isa_ParamCommandComment(Comment/*P*/ From) {
    assert From != null;
    return ParamCommandComment.classof(From);
  }

  public static ParamCommandComment cast_ParamCommandComment(Comment/*P*/ From) {
    assert isa_ParamCommandComment(From);
    return (ParamCommandComment) From;
  }

  public static ParamCommandComment cast_or_null_ParamCommandComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_ParamCommandComment(From);
  }

  public static ParamCommandComment dyn_cast_ParamCommandComment(Comment/*P*/ From) {
    assert From != null;
    return isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static ParamCommandComment dyn_cast_or_null_ParamCommandComment(Comment/*P*/ From) {
    return (From != null) && isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static boolean isa_ParamCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParamCommandComment.class, From.$star());
  }

  public static ParamCommandComment cast_ParamCommandComment(type$ptr<?>/*P*/ From) {
    assert isa_ParamCommandComment(From);
    return llvm.cast(ParamCommandComment.class, From.$star());
  }

  public static ParamCommandComment cast_or_null_ParamCommandComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParamCommandComment(From);
  }

  public static ParamCommandComment dyn_cast_ParamCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static ParamCommandComment dyn_cast_or_null_ParamCommandComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParamCommandComment(From) ? cast_ParamCommandComment(From) : null;
  }

  public static boolean isa_TParamCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TParamCommandComment.class, From.$star());
  }

  public static TParamCommandComment cast_TParamCommandComment(type$ptr<?>/*P*/ From) {
    assert isa_TParamCommandComment(From);
    return llvm.cast(TParamCommandComment.class, From.$star());
  }

  public static TParamCommandComment cast_or_null_TParamCommandComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TParamCommandComment(From);
  }

  public static TParamCommandComment dyn_cast_TParamCommandComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static TParamCommandComment dyn_cast_or_null_TParamCommandComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static boolean isa_TParamCommandComment(Comment/*P*/ From) {
    assert From != null;
    return TParamCommandComment.classof(From);
  }

  public static TParamCommandComment cast_TParamCommandComment(Comment/*P*/ From) {
    assert isa_TParamCommandComment(From);
    return (TParamCommandComment) From;
  }

  public static TParamCommandComment cast_or_null_TParamCommandComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_TParamCommandComment(From);
  }

  public static TParamCommandComment dyn_cast_TParamCommandComment(Comment/*P*/ From) {
    assert From != null;
    return isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static TParamCommandComment dyn_cast_or_null_TParamCommandComment(Comment/*P*/ From) {
    return (From != null) && isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static boolean isa_TParamCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TParamCommandComment.class, From.$deref());
  }

  public static TParamCommandComment cast_TParamCommandComment(type$ref<?>/*P*/ From) {
    assert isa_TParamCommandComment(From);
    return llvm.cast(TParamCommandComment.class, From.$deref());
  }

  public static TParamCommandComment cast_or_null_TParamCommandComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TParamCommandComment(From);
  }

  public static TParamCommandComment dyn_cast_TParamCommandComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static TParamCommandComment dyn_cast_or_null_TParamCommandComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TParamCommandComment(From) ? cast_TParamCommandComment(From) : null;
  }

  public static boolean isa_TextComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TextComment.class, From.$deref());
  }

  public static TextComment cast_TextComment(type$ref<?>/*P*/ From) {
    assert isa_TextComment(From);
    return llvm.cast(TextComment.class, From.$deref());
  }

  public static TextComment cast_or_null_TextComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TextComment(From);
  }

  public static TextComment dyn_cast_TextComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static TextComment dyn_cast_or_null_TextComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static boolean isa_TextComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TextComment.class, From.$star());
  }

  public static TextComment cast_TextComment(type$ptr<?>/*P*/ From) {
    assert isa_TextComment(From);
    return llvm.cast(TextComment.class, From.$star());
  }

  public static TextComment cast_or_null_TextComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TextComment(From);
  }

  public static TextComment dyn_cast_TextComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static TextComment dyn_cast_or_null_TextComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static boolean isa_TextComment(Comment/*P*/ From) {
    assert From != null;
    return TextComment.classof(From);
  }

  public static TextComment cast_TextComment(Comment/*P*/ From) {
    assert isa_TextComment(From);
    return (TextComment) From;
  }

  public static TextComment cast_or_null_TextComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_TextComment(From);
  }

  public static TextComment dyn_cast_TextComment(Comment/*P*/ From) {
    assert From != null;
    return isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static TextComment dyn_cast_or_null_TextComment(Comment/*P*/ From) {
    return (From != null) && isa_TextComment(From) ? cast_TextComment(From) : null;
  }

  public static boolean isa_VerbatimBlockComment(Comment/*P*/ From) {
    assert From != null;
    return VerbatimBlockComment.classof(From);
  }

  public static VerbatimBlockComment cast_VerbatimBlockComment(Comment/*P*/ From) {
    assert isa_VerbatimBlockComment(From);
    return (VerbatimBlockComment) From;
  }

  public static VerbatimBlockComment cast_or_null_VerbatimBlockComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_VerbatimBlockComment(From);
  }

  public static VerbatimBlockComment dyn_cast_VerbatimBlockComment(Comment/*P*/ From) {
    assert From != null;
    return isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static VerbatimBlockComment dyn_cast_or_null_VerbatimBlockComment(Comment/*P*/ From) {
    return (From != null) && isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static boolean isa_VerbatimBlockComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerbatimBlockComment.class, From.$star());
  }

  public static VerbatimBlockComment cast_VerbatimBlockComment(type$ptr<?>/*P*/ From) {
    assert isa_VerbatimBlockComment(From);
    return llvm.cast(VerbatimBlockComment.class, From.$star());
  }

  public static VerbatimBlockComment cast_or_null_VerbatimBlockComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerbatimBlockComment(From);
  }

  public static VerbatimBlockComment dyn_cast_VerbatimBlockComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static VerbatimBlockComment dyn_cast_or_null_VerbatimBlockComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static boolean isa_VerbatimBlockComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerbatimBlockComment.class, From.$deref());
  }

  public static VerbatimBlockComment cast_VerbatimBlockComment(type$ref<?>/*P*/ From) {
    assert isa_VerbatimBlockComment(From);
    return llvm.cast(VerbatimBlockComment.class, From.$deref());
  }

  public static VerbatimBlockComment cast_or_null_VerbatimBlockComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerbatimBlockComment(From);
  }

  public static VerbatimBlockComment dyn_cast_VerbatimBlockComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static VerbatimBlockComment dyn_cast_or_null_VerbatimBlockComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerbatimBlockComment(From) ? cast_VerbatimBlockComment(From) : null;
  }

  public static boolean isa_VerbatimBlockLineComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerbatimBlockLineComment.class, From.$deref());
  }

  public static VerbatimBlockLineComment cast_VerbatimBlockLineComment(type$ref<?>/*P*/ From) {
    assert isa_VerbatimBlockLineComment(From);
    return llvm.cast(VerbatimBlockLineComment.class, From.$deref());
  }

  public static VerbatimBlockLineComment cast_or_null_VerbatimBlockLineComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerbatimBlockLineComment(From);
  }

  public static VerbatimBlockLineComment dyn_cast_VerbatimBlockLineComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static VerbatimBlockLineComment dyn_cast_or_null_VerbatimBlockLineComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static boolean isa_VerbatimBlockLineComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerbatimBlockLineComment.class, From.$star());
  }

  public static VerbatimBlockLineComment cast_VerbatimBlockLineComment(type$ptr<?>/*P*/ From) {
    assert isa_VerbatimBlockLineComment(From);
    return llvm.cast(VerbatimBlockLineComment.class, From.$star());
  }

  public static VerbatimBlockLineComment cast_or_null_VerbatimBlockLineComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerbatimBlockLineComment(From);
  }

  public static VerbatimBlockLineComment dyn_cast_VerbatimBlockLineComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static VerbatimBlockLineComment dyn_cast_or_null_VerbatimBlockLineComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static boolean isa_VerbatimBlockLineComment(Comment/*P*/ From) {
    assert From != null;
    return VerbatimBlockLineComment.classof(From);
  }

  public static VerbatimBlockLineComment cast_VerbatimBlockLineComment(Comment/*P*/ From) {
    assert isa_VerbatimBlockLineComment(From);
    return (VerbatimBlockLineComment) From;
  }

  public static VerbatimBlockLineComment cast_or_null_VerbatimBlockLineComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_VerbatimBlockLineComment(From);
  }

  public static VerbatimBlockLineComment dyn_cast_VerbatimBlockLineComment(Comment/*P*/ From) {
    assert From != null;
    return isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static VerbatimBlockLineComment dyn_cast_or_null_VerbatimBlockLineComment(Comment/*P*/ From) {
    return (From != null) && isa_VerbatimBlockLineComment(From) ? cast_VerbatimBlockLineComment(From) : null;
  }

  public static boolean isa_VerbatimLineComment(Comment/*P*/ From) {
    assert From != null;
    return VerbatimLineComment.classof(From);
  }

  public static VerbatimLineComment cast_VerbatimLineComment(Comment/*P*/ From) {
    assert isa_VerbatimLineComment(From);
    return (VerbatimLineComment) From;
  }

  public static VerbatimLineComment cast_or_null_VerbatimLineComment(Comment/*P*/ From) {
    return (From == null) ? null : cast_VerbatimLineComment(From);
  }

  public static VerbatimLineComment dyn_cast_VerbatimLineComment(Comment/*P*/ From) {
    assert From != null;
    return isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static VerbatimLineComment dyn_cast_or_null_VerbatimLineComment(Comment/*P*/ From) {
    return (From != null) && isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static boolean isa_VerbatimLineComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerbatimLineComment.class, From.$star());
  }

  public static VerbatimLineComment cast_VerbatimLineComment(type$ptr<?>/*P*/ From) {
    assert isa_VerbatimLineComment(From);
    return llvm.cast(VerbatimLineComment.class, From.$star());
  }

  public static VerbatimLineComment cast_or_null_VerbatimLineComment(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerbatimLineComment(From);
  }

  public static VerbatimLineComment dyn_cast_VerbatimLineComment(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static VerbatimLineComment dyn_cast_or_null_VerbatimLineComment(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static boolean isa_VerbatimLineComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerbatimLineComment.class, From.$deref());
  }

  public static VerbatimLineComment cast_VerbatimLineComment(type$ref<?>/*P*/ From) {
    assert isa_VerbatimLineComment(From);
    return llvm.cast(VerbatimLineComment.class, From.$deref());
  }

  public static VerbatimLineComment cast_or_null_VerbatimLineComment(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerbatimLineComment(From);
  }

  public static VerbatimLineComment dyn_cast_VerbatimLineComment(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static VerbatimLineComment dyn_cast_or_null_VerbatimLineComment(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerbatimLineComment(From) ? cast_VerbatimLineComment(From) : null;
  }

  public static boolean isa_ItaniumMangleContextImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ItaniumMangleContextImpl.class, From.$deref());
  }

  public static ItaniumMangleContextImpl cast_ItaniumMangleContextImpl(type$ref<?>/*P*/ From) {
    assert isa_ItaniumMangleContextImpl(From);
    return llvm.cast(ItaniumMangleContextImpl.class, From.$deref());
  }

  public static ItaniumMangleContextImpl cast_or_null_ItaniumMangleContextImpl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ItaniumMangleContextImpl(From);
  }

  public static ItaniumMangleContextImpl dyn_cast_ItaniumMangleContextImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static ItaniumMangleContextImpl dyn_cast_or_null_ItaniumMangleContextImpl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static boolean isa_ItaniumMangleContextImpl(MangleContext/*P*/ From) {
    assert From != null;
    return ItaniumMangleContextImpl.classof(From);
  }

  public static ItaniumMangleContextImpl cast_ItaniumMangleContextImpl(MangleContext/*P*/ From) {
    assert isa_ItaniumMangleContextImpl(From);
    return (ItaniumMangleContextImpl) From;
  }

  public static ItaniumMangleContextImpl cast_or_null_ItaniumMangleContextImpl(MangleContext/*P*/ From) {
    return (From == null) ? null : cast_ItaniumMangleContextImpl(From);
  }

  public static ItaniumMangleContextImpl dyn_cast_ItaniumMangleContextImpl(MangleContext/*P*/ From) {
    assert From != null;
    return isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static ItaniumMangleContextImpl dyn_cast_or_null_ItaniumMangleContextImpl(MangleContext/*P*/ From) {
    return (From != null) && isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static boolean isa_ItaniumMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ItaniumMangleContextImpl.class, From.$star());
  }

  public static ItaniumMangleContextImpl cast_ItaniumMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert isa_ItaniumMangleContextImpl(From);
    return llvm.cast(ItaniumMangleContextImpl.class, From.$star());
  }

  public static ItaniumMangleContextImpl cast_or_null_ItaniumMangleContextImpl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ItaniumMangleContextImpl(From);
  }

  public static ItaniumMangleContextImpl dyn_cast_ItaniumMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static ItaniumMangleContextImpl dyn_cast_or_null_ItaniumMangleContextImpl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ItaniumMangleContextImpl(From) ? cast_ItaniumMangleContextImpl(From) : null;
  }

  public static boolean isa_MicrosoftMangleContextImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MicrosoftMangleContextImpl.class, From.$deref());
  }

  public static MicrosoftMangleContextImpl cast_MicrosoftMangleContextImpl(type$ref<?>/*P*/ From) {
    assert isa_MicrosoftMangleContextImpl(From);
    return llvm.cast(MicrosoftMangleContextImpl.class, From.$deref());
  }

  public static MicrosoftMangleContextImpl cast_or_null_MicrosoftMangleContextImpl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MicrosoftMangleContextImpl(From);
  }

  public static MicrosoftMangleContextImpl dyn_cast_MicrosoftMangleContextImpl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }

  public static MicrosoftMangleContextImpl dyn_cast_or_null_MicrosoftMangleContextImpl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }

  public static boolean isa_MicrosoftMangleContextImpl(MangleContext/*P*/ From) {
    assert From != null;
    return MicrosoftMangleContextImpl.classof(From);
  }

  public static MicrosoftMangleContextImpl cast_MicrosoftMangleContextImpl(MangleContext/*P*/ From) {
    assert isa_MicrosoftMangleContextImpl(From);
    return (MicrosoftMangleContextImpl) From;
  }

  public static MicrosoftMangleContextImpl cast_or_null_MicrosoftMangleContextImpl(MangleContext/*P*/ From) {
    return (From == null) ? null : cast_MicrosoftMangleContextImpl(From);
  }

  public static MicrosoftMangleContextImpl dyn_cast_MicrosoftMangleContextImpl(MangleContext/*P*/ From) {
    assert From != null;
    return isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }

  public static MicrosoftMangleContextImpl dyn_cast_or_null_MicrosoftMangleContextImpl(MangleContext/*P*/ From) {
    return (From != null) && isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }

  public static boolean isa_MicrosoftMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MicrosoftMangleContextImpl.class, From.$star());
  }

  public static MicrosoftMangleContextImpl cast_MicrosoftMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert isa_MicrosoftMangleContextImpl(From);
    return llvm.cast(MicrosoftMangleContextImpl.class, From.$star());
  }

  public static MicrosoftMangleContextImpl cast_or_null_MicrosoftMangleContextImpl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MicrosoftMangleContextImpl(From);
  }

  public static MicrosoftMangleContextImpl dyn_cast_MicrosoftMangleContextImpl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }

  public static MicrosoftMangleContextImpl dyn_cast_or_null_MicrosoftMangleContextImpl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MicrosoftMangleContextImpl(From) ? cast_MicrosoftMangleContextImpl(From) : null;
  }
}
