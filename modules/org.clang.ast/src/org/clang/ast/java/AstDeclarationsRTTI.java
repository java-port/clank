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

public class AstDeclarationsRTTI extends AstJavaFixedRTTI {
  /*package*/AstDeclarationsRTTI() {}

  public static boolean isa_AccessSpecDecl(Decl/*P*/ From) {
    assert From != null;
    return AccessSpecDecl.classof(From);
  }

  public static AccessSpecDecl cast_AccessSpecDecl(Decl/*P*/ From) {
    assert isa_AccessSpecDecl(From);
    return (AccessSpecDecl) From;
  }

  public static AccessSpecDecl cast_or_null_AccessSpecDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_AccessSpecDecl(From);
  }

  public static AccessSpecDecl dyn_cast_AccessSpecDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static AccessSpecDecl dyn_cast_or_null_AccessSpecDecl(Decl/*P*/ From) {
    return (From != null) && isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static boolean isa_AccessSpecDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AccessSpecDecl.class, From.$deref());
  }

  public static AccessSpecDecl cast_AccessSpecDecl(type$ref<?>/*P*/ From) {
    assert isa_AccessSpecDecl(From);
    return llvm.cast(AccessSpecDecl.class, From.$deref());
  }

  public static AccessSpecDecl cast_or_null_AccessSpecDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AccessSpecDecl(From);
  }

  public static AccessSpecDecl dyn_cast_AccessSpecDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static AccessSpecDecl dyn_cast_or_null_AccessSpecDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static boolean isa_AccessSpecDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AccessSpecDecl.class, From.$star());
  }

  public static AccessSpecDecl cast_AccessSpecDecl(type$ptr<?>/*P*/ From) {
    assert isa_AccessSpecDecl(From);
    return llvm.cast(AccessSpecDecl.class, From.$star());
  }

  public static AccessSpecDecl cast_or_null_AccessSpecDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AccessSpecDecl(From);
  }

  public static AccessSpecDecl dyn_cast_AccessSpecDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static AccessSpecDecl dyn_cast_or_null_AccessSpecDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AccessSpecDecl(From) ? cast_AccessSpecDecl(From) : null;
  }

  public static boolean isa_BlockDecl(Decl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(Decl/*P*/ From) {
    assert isa_BlockDecl(From);
    return (BlockDecl) From;
  }

  public static BlockDecl cast_or_null_BlockDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(Decl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockDecl.class, From.$star());
  }

  public static BlockDecl cast_BlockDecl(type$ptr<?>/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From.$star());
  }

  public static BlockDecl cast_or_null_BlockDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(DeclContext/*P*/ From) {
    assert From != null;
    return BlockDecl.classofKind(From.getDeclKind());
  }

  public static BlockDecl cast_BlockDecl(DeclContext/*P*/ From) {
    assert isa_BlockDecl(From);
    return (BlockDecl) From;
  }

  public static BlockDecl cast_or_null_BlockDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockDecl.class, From.$deref());
  }

  public static BlockDecl cast_BlockDecl(type$ref<?>/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From.$deref());
  }

  public static BlockDecl cast_or_null_BlockDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BuiltinTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BuiltinTemplateDecl.class, From.$deref());
  }

  public static BuiltinTemplateDecl cast_BuiltinTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_BuiltinTemplateDecl(From);
    return llvm.cast(BuiltinTemplateDecl.class, From.$deref());
  }

  public static BuiltinTemplateDecl cast_or_null_BuiltinTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BuiltinTemplateDecl(From);
  }

  public static BuiltinTemplateDecl dyn_cast_BuiltinTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static BuiltinTemplateDecl dyn_cast_or_null_BuiltinTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static boolean isa_BuiltinTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return BuiltinTemplateDecl.classof(From);
  }

  public static BuiltinTemplateDecl cast_BuiltinTemplateDecl(Decl/*P*/ From) {
    assert isa_BuiltinTemplateDecl(From);
    return (BuiltinTemplateDecl) From;
  }

  public static BuiltinTemplateDecl cast_or_null_BuiltinTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_BuiltinTemplateDecl(From);
  }

  public static BuiltinTemplateDecl dyn_cast_BuiltinTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static BuiltinTemplateDecl dyn_cast_or_null_BuiltinTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static boolean isa_BuiltinTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BuiltinTemplateDecl.class, From.$star());
  }

  public static BuiltinTemplateDecl cast_BuiltinTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_BuiltinTemplateDecl(From);
    return llvm.cast(BuiltinTemplateDecl.class, From.$star());
  }

  public static BuiltinTemplateDecl cast_or_null_BuiltinTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BuiltinTemplateDecl(From);
  }

  public static BuiltinTemplateDecl dyn_cast_BuiltinTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static BuiltinTemplateDecl dyn_cast_or_null_BuiltinTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BuiltinTemplateDecl(From) ? cast_BuiltinTemplateDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXConstructorDecl.class, From.$star());
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(type$ptr<?>/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From.$star());
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(Decl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(Decl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return (CXXConstructorDecl) From;
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(Decl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXConstructorDecl.class, From.$deref());
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(type$ref<?>/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From.$deref());
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classofKind(From.getDeclKind());
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(DeclContext/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return (CXXConstructorDecl) From;
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(Decl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(Decl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return (CXXConversionDecl) From;
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(Decl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXConversionDecl.class, From.$deref());
  }

  public static CXXConversionDecl cast_CXXConversionDecl(type$ref<?>/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From.$deref());
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classofKind(From.getDeclKind());
  }

  public static CXXConversionDecl cast_CXXConversionDecl(DeclContext/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return (CXXConversionDecl) From;
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXConversionDecl.class, From.$star());
  }

  public static CXXConversionDecl cast_CXXConversionDecl(type$ptr<?>/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From.$star());
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classofKind(From.getDeclKind());
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(DeclContext/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return (CXXDestructorDecl) From;
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDestructorDecl.class, From.$star());
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(type$ptr<?>/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From.$star());
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(Decl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(Decl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return (CXXDestructorDecl) From;
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(Decl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDestructorDecl.class, From.$deref());
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(type$ref<?>/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From.$deref());
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXMethodDecl.class, From.$star());
  }

  public static CXXMethodDecl cast_CXXMethodDecl(type$ptr<?>/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From.$star());
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(Decl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(Decl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return (CXXMethodDecl) From;
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(Decl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classofKind(From.getDeclKind());
  }

  public static CXXMethodDecl cast_CXXMethodDecl(DeclContext/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return (CXXMethodDecl) From;
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXMethodDecl.class, From.$deref());
  }

  public static CXXMethodDecl cast_CXXMethodDecl(type$ref<?>/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From.$deref());
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXRecordDecl.class, From.$deref());
  }

  public static CXXRecordDecl cast_CXXRecordDecl(type$ref<?>/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From.$deref());
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXRecordDecl.class, From.$star());
  }

  public static CXXRecordDecl cast_CXXRecordDecl(type$ptr<?>/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From.$star());
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(Decl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(Decl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return (CXXRecordDecl) From;
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(Decl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classofKind(From.getDeclKind());
  }

  public static CXXRecordDecl cast_CXXRecordDecl(DeclContext/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return (CXXRecordDecl) From;
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapturedDecl.class, From.$deref());
  }

  public static CapturedDecl cast_CapturedDecl(type$ref<?>/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From.$deref());
  }

  public static CapturedDecl cast_or_null_CapturedDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(Decl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(Decl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return (CapturedDecl) From;
  }

  public static CapturedDecl cast_or_null_CapturedDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(Decl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapturedDecl.class, From.$star());
  }

  public static CapturedDecl cast_CapturedDecl(type$ptr<?>/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From.$star());
  }

  public static CapturedDecl cast_or_null_CapturedDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(DeclContext/*P*/ From) {
    assert From != null;
    return CapturedDecl.classofKind(From.getDeclKind());
  }

  public static CapturedDecl cast_CapturedDecl(DeclContext/*P*/ From) {
    assert isa_CapturedDecl(From);
    return (CapturedDecl) From;
  }

  public static CapturedDecl cast_or_null_CapturedDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_ClassScopeFunctionSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ClassScopeFunctionSpecializationDecl.class, From.$star());
  }

  public static ClassScopeFunctionSpecializationDecl cast_ClassScopeFunctionSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert isa_ClassScopeFunctionSpecializationDecl(From);
    return llvm.cast(ClassScopeFunctionSpecializationDecl.class, From.$star());
  }

  public static ClassScopeFunctionSpecializationDecl cast_or_null_ClassScopeFunctionSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ClassScopeFunctionSpecializationDecl(From);
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_ClassScopeFunctionSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_or_null_ClassScopeFunctionSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassScopeFunctionSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ClassScopeFunctionSpecializationDecl.class, From.$deref());
  }

  public static ClassScopeFunctionSpecializationDecl cast_ClassScopeFunctionSpecializationDecl(type$ref<?>/*P*/ From) {
    assert isa_ClassScopeFunctionSpecializationDecl(From);
    return llvm.cast(ClassScopeFunctionSpecializationDecl.class, From.$deref());
  }

  public static ClassScopeFunctionSpecializationDecl cast_or_null_ClassScopeFunctionSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ClassScopeFunctionSpecializationDecl(From);
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_ClassScopeFunctionSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_or_null_ClassScopeFunctionSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassScopeFunctionSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return ClassScopeFunctionSpecializationDecl.classof(From);
  }

  public static ClassScopeFunctionSpecializationDecl cast_ClassScopeFunctionSpecializationDecl(Decl/*P*/ From) {
    assert isa_ClassScopeFunctionSpecializationDecl(From);
    return (ClassScopeFunctionSpecializationDecl) From;
  }

  public static ClassScopeFunctionSpecializationDecl cast_or_null_ClassScopeFunctionSpecializationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ClassScopeFunctionSpecializationDecl(From);
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_ClassScopeFunctionSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static ClassScopeFunctionSpecializationDecl dyn_cast_or_null_ClassScopeFunctionSpecializationDecl(Decl/*P*/ From) {
    return (From != null) && isa_ClassScopeFunctionSpecializationDecl(From) ? cast_ClassScopeFunctionSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ClassTemplateDecl.class, From.$star());
  }

  public static ClassTemplateDecl cast_ClassTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_ClassTemplateDecl(From);
    return llvm.cast(ClassTemplateDecl.class, From.$star());
  }

  public static ClassTemplateDecl cast_or_null_ClassTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ClassTemplateDecl(From);
  }

  public static ClassTemplateDecl dyn_cast_ClassTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static ClassTemplateDecl dyn_cast_or_null_ClassTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static boolean isa_ClassTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return ClassTemplateDecl.classof(From);
  }

  public static ClassTemplateDecl cast_ClassTemplateDecl(Decl/*P*/ From) {
    assert isa_ClassTemplateDecl(From);
    return (ClassTemplateDecl) From;
  }

  public static ClassTemplateDecl cast_or_null_ClassTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateDecl(From);
  }

  public static ClassTemplateDecl dyn_cast_ClassTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static ClassTemplateDecl dyn_cast_or_null_ClassTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static boolean isa_ClassTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ClassTemplateDecl.class, From.$deref());
  }

  public static ClassTemplateDecl cast_ClassTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_ClassTemplateDecl(From);
    return llvm.cast(ClassTemplateDecl.class, From.$deref());
  }

  public static ClassTemplateDecl cast_or_null_ClassTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ClassTemplateDecl(From);
  }

  public static ClassTemplateDecl dyn_cast_ClassTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static ClassTemplateDecl dyn_cast_or_null_ClassTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ClassTemplateDecl(From) ? cast_ClassTemplateDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ClassTemplatePartialSpecializationDecl.class, From.$star());
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From.$star());
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ClassTemplatePartialSpecializationDecl.class, From.$deref());
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From.$deref());
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return (ClassTemplatePartialSpecializationDecl) From;
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classofKind(From.getDeclKind());
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(DeclContext/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return (ClassTemplatePartialSpecializationDecl) From;
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ClassTemplateSpecializationDecl.class, From.$deref());
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From.$deref());
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(Decl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return (ClassTemplateSpecializationDecl) From;
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(Decl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ClassTemplateSpecializationDecl.class, From.$star());
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From.$star());
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classofKind(From.getDeclKind());
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(DeclContext/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return (ClassTemplateSpecializationDecl) From;
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ConstructorUsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstructorUsingShadowDecl.class, From.$star());
  }

  public static ConstructorUsingShadowDecl cast_ConstructorUsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert isa_ConstructorUsingShadowDecl(From);
    return llvm.cast(ConstructorUsingShadowDecl.class, From.$star());
  }

  public static ConstructorUsingShadowDecl cast_or_null_ConstructorUsingShadowDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstructorUsingShadowDecl(From);
  }

  public static ConstructorUsingShadowDecl dyn_cast_ConstructorUsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static ConstructorUsingShadowDecl dyn_cast_or_null_ConstructorUsingShadowDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static boolean isa_ConstructorUsingShadowDecl(Decl/*P*/ From) {
    assert From != null;
    return ConstructorUsingShadowDecl.classof(From);
  }

  public static ConstructorUsingShadowDecl cast_ConstructorUsingShadowDecl(Decl/*P*/ From) {
    assert isa_ConstructorUsingShadowDecl(From);
    return (ConstructorUsingShadowDecl) From;
  }

  public static ConstructorUsingShadowDecl cast_or_null_ConstructorUsingShadowDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ConstructorUsingShadowDecl(From);
  }

  public static ConstructorUsingShadowDecl dyn_cast_ConstructorUsingShadowDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static ConstructorUsingShadowDecl dyn_cast_or_null_ConstructorUsingShadowDecl(Decl/*P*/ From) {
    return (From != null) && isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static boolean isa_ConstructorUsingShadowDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstructorUsingShadowDecl.class, From.$deref());
  }

  public static ConstructorUsingShadowDecl cast_ConstructorUsingShadowDecl(type$ref<?>/*P*/ From) {
    assert isa_ConstructorUsingShadowDecl(From);
    return llvm.cast(ConstructorUsingShadowDecl.class, From.$deref());
  }

  public static ConstructorUsingShadowDecl cast_or_null_ConstructorUsingShadowDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstructorUsingShadowDecl(From);
  }

  public static ConstructorUsingShadowDecl dyn_cast_ConstructorUsingShadowDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static ConstructorUsingShadowDecl dyn_cast_or_null_ConstructorUsingShadowDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstructorUsingShadowDecl(From) ? cast_ConstructorUsingShadowDecl(From) : null;
  }

  public static boolean isa_Decl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Decl.class, From.$deref());
  }

  public static Decl cast_Decl(type$ref<?>/*P*/ From) {
    assert isa_Decl(From);
    return llvm.cast(Decl.class, From.$deref());
  }

  public static Decl cast_or_null_Decl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(DeclContext/*P*/ From) {
    assert From != null;
    return Decl.classofKind(From.getDeclKind());
  }

  public static Decl cast_Decl(DeclContext/*P*/ From) {
    assert isa_Decl(From);
    return llvm.cast(Decl.class, From);
  }

  public static Decl cast_or_null_Decl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(DeclContext/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(Decl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(Decl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(Decl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(Decl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(Decl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Decl.class, From.$star());
  }

  public static Decl cast_Decl(type$ptr<?>/*P*/ From) {
    assert isa_Decl(From);
    return llvm.cast(Decl.class, From.$star());
  }

  public static Decl cast_or_null_Decl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classofKind(From.getDeclKind());
  }

  public static DeclaratorDecl cast_DeclaratorDecl(DeclContext/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeclaratorDecl.class, From.$deref());
  }

  public static DeclaratorDecl cast_DeclaratorDecl(type$ref<?>/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From.$deref());
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(Decl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(Decl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return (DeclaratorDecl) From;
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(Decl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeclaratorDecl.class, From.$star());
  }

  public static DeclaratorDecl cast_DeclaratorDecl(type$ptr<?>/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From.$star());
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_EmptyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EmptyDecl.class, From.$star());
  }

  public static EmptyDecl cast_EmptyDecl(type$ptr<?>/*P*/ From) {
    assert isa_EmptyDecl(From);
    return llvm.cast(EmptyDecl.class, From.$star());
  }

  public static EmptyDecl cast_or_null_EmptyDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EmptyDecl(From);
  }

  public static EmptyDecl dyn_cast_EmptyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static EmptyDecl dyn_cast_or_null_EmptyDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static boolean isa_EmptyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EmptyDecl.class, From.$deref());
  }

  public static EmptyDecl cast_EmptyDecl(type$ref<?>/*P*/ From) {
    assert isa_EmptyDecl(From);
    return llvm.cast(EmptyDecl.class, From.$deref());
  }

  public static EmptyDecl cast_or_null_EmptyDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EmptyDecl(From);
  }

  public static EmptyDecl dyn_cast_EmptyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static EmptyDecl dyn_cast_or_null_EmptyDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static boolean isa_EmptyDecl(Decl/*P*/ From) {
    assert From != null;
    return EmptyDecl.classof(From);
  }

  public static EmptyDecl cast_EmptyDecl(Decl/*P*/ From) {
    assert isa_EmptyDecl(From);
    return (EmptyDecl) From;
  }

  public static EmptyDecl cast_or_null_EmptyDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_EmptyDecl(From);
  }

  public static EmptyDecl dyn_cast_EmptyDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static EmptyDecl dyn_cast_or_null_EmptyDecl(Decl/*P*/ From) {
    return (From != null) && isa_EmptyDecl(From) ? cast_EmptyDecl(From) : null;
  }

  public static boolean isa_EnumConstantDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EnumConstantDecl.class, From.$deref());
  }

  public static EnumConstantDecl cast_EnumConstantDecl(type$ref<?>/*P*/ From) {
    assert isa_EnumConstantDecl(From);
    return llvm.cast(EnumConstantDecl.class, From.$deref());
  }

  public static EnumConstantDecl cast_or_null_EnumConstantDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EnumConstantDecl(From);
  }

  public static EnumConstantDecl dyn_cast_EnumConstantDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static EnumConstantDecl dyn_cast_or_null_EnumConstantDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static boolean isa_EnumConstantDecl(Decl/*P*/ From) {
    assert From != null;
    return EnumConstantDecl.classof(From);
  }

  public static EnumConstantDecl cast_EnumConstantDecl(Decl/*P*/ From) {
    assert isa_EnumConstantDecl(From);
    return (EnumConstantDecl) From;
  }

  public static EnumConstantDecl cast_or_null_EnumConstantDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_EnumConstantDecl(From);
  }

  public static EnumConstantDecl dyn_cast_EnumConstantDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static EnumConstantDecl dyn_cast_or_null_EnumConstantDecl(Decl/*P*/ From) {
    return (From != null) && isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static boolean isa_EnumConstantDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EnumConstantDecl.class, From.$star());
  }

  public static EnumConstantDecl cast_EnumConstantDecl(type$ptr<?>/*P*/ From) {
    assert isa_EnumConstantDecl(From);
    return llvm.cast(EnumConstantDecl.class, From.$star());
  }

  public static EnumConstantDecl cast_or_null_EnumConstantDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EnumConstantDecl(From);
  }

  public static EnumConstantDecl dyn_cast_EnumConstantDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static EnumConstantDecl dyn_cast_or_null_EnumConstantDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EnumConstantDecl(From) ? cast_EnumConstantDecl(From) : null;
  }

  public static boolean isa_EnumDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EnumDecl.class, From.$deref());
  }

  public static EnumDecl cast_EnumDecl(type$ref<?>/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From.$deref());
  }

  public static EnumDecl cast_or_null_EnumDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(Decl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(Decl/*P*/ From) {
    assert isa_EnumDecl(From);
    return (EnumDecl) From;
  }

  public static EnumDecl cast_or_null_EnumDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(Decl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EnumDecl.class, From.$star());
  }

  public static EnumDecl cast_EnumDecl(type$ptr<?>/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From.$star());
  }

  public static EnumDecl cast_or_null_EnumDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(DeclContext/*P*/ From) {
    assert From != null;
    return EnumDecl.classofKind(From.getDeclKind());
  }

  public static EnumDecl cast_EnumDecl(DeclContext/*P*/ From) {
    assert isa_EnumDecl(From);
    return (EnumDecl) From;
  }

  public static EnumDecl cast_or_null_EnumDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(Decl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(Decl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return (ExternCContextDecl) From;
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(Decl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExternCContextDecl.class, From.$deref());
  }

  public static ExternCContextDecl cast_ExternCContextDecl(type$ref<?>/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From.$deref());
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classofKind(From.getDeclKind());
  }

  public static ExternCContextDecl cast_ExternCContextDecl(DeclContext/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return (ExternCContextDecl) From;
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExternCContextDecl.class, From.$star());
  }

  public static ExternCContextDecl cast_ExternCContextDecl(type$ptr<?>/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From.$star());
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_FieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FieldDecl.class, From.$star());
  }

  public static FieldDecl cast_FieldDecl(type$ptr<?>/*P*/ From) {
    assert isa_FieldDecl(From);
    return llvm.cast(FieldDecl.class, From.$star());
  }

  public static FieldDecl cast_or_null_FieldDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FieldDecl(From);
  }

  public static FieldDecl dyn_cast_FieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static FieldDecl dyn_cast_or_null_FieldDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static boolean isa_FieldDecl(Decl/*P*/ From) {
    assert From != null;
    return FieldDecl.classof(From);
  }

  public static FieldDecl cast_FieldDecl(Decl/*P*/ From) {
    assert isa_FieldDecl(From);
    return (FieldDecl) From;
  }

  public static FieldDecl cast_or_null_FieldDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FieldDecl(From);
  }

  public static FieldDecl dyn_cast_FieldDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static FieldDecl dyn_cast_or_null_FieldDecl(Decl/*P*/ From) {
    return (From != null) && isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static boolean isa_FieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FieldDecl.class, From.$deref());
  }

  public static FieldDecl cast_FieldDecl(type$ref<?>/*P*/ From) {
    assert isa_FieldDecl(From);
    return llvm.cast(FieldDecl.class, From.$deref());
  }

  public static FieldDecl cast_or_null_FieldDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FieldDecl(From);
  }

  public static FieldDecl dyn_cast_FieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static FieldDecl dyn_cast_or_null_FieldDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FieldDecl(From) ? cast_FieldDecl(From) : null;
  }

  public static boolean isa_FileScopeAsmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FileScopeAsmDecl.class, From.$deref());
  }

  public static FileScopeAsmDecl cast_FileScopeAsmDecl(type$ref<?>/*P*/ From) {
    assert isa_FileScopeAsmDecl(From);
    return llvm.cast(FileScopeAsmDecl.class, From.$deref());
  }

  public static FileScopeAsmDecl cast_or_null_FileScopeAsmDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FileScopeAsmDecl(From);
  }

  public static FileScopeAsmDecl dyn_cast_FileScopeAsmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static FileScopeAsmDecl dyn_cast_or_null_FileScopeAsmDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static boolean isa_FileScopeAsmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FileScopeAsmDecl.class, From.$star());
  }

  public static FileScopeAsmDecl cast_FileScopeAsmDecl(type$ptr<?>/*P*/ From) {
    assert isa_FileScopeAsmDecl(From);
    return llvm.cast(FileScopeAsmDecl.class, From.$star());
  }

  public static FileScopeAsmDecl cast_or_null_FileScopeAsmDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FileScopeAsmDecl(From);
  }

  public static FileScopeAsmDecl dyn_cast_FileScopeAsmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static FileScopeAsmDecl dyn_cast_or_null_FileScopeAsmDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static boolean isa_FileScopeAsmDecl(Decl/*P*/ From) {
    assert From != null;
    return FileScopeAsmDecl.classof(From);
  }

  public static FileScopeAsmDecl cast_FileScopeAsmDecl(Decl/*P*/ From) {
    assert isa_FileScopeAsmDecl(From);
    return (FileScopeAsmDecl) From;
  }

  public static FileScopeAsmDecl cast_or_null_FileScopeAsmDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FileScopeAsmDecl(From);
  }

  public static FileScopeAsmDecl dyn_cast_FileScopeAsmDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static FileScopeAsmDecl dyn_cast_or_null_FileScopeAsmDecl(Decl/*P*/ From) {
    return (From != null) && isa_FileScopeAsmDecl(From) ? cast_FileScopeAsmDecl(From) : null;
  }

  public static boolean isa_FriendDecl(Decl/*P*/ From) {
    assert From != null;
    return FriendDecl.classof(From);
  }

  public static FriendDecl cast_FriendDecl(Decl/*P*/ From) {
    assert isa_FriendDecl(From);
    return (FriendDecl) From;
  }

  public static FriendDecl cast_or_null_FriendDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FriendDecl(From);
  }

  public static FriendDecl dyn_cast_FriendDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static FriendDecl dyn_cast_or_null_FriendDecl(Decl/*P*/ From) {
    return (From != null) && isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static boolean isa_FriendDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FriendDecl.class, From.$star());
  }

  public static FriendDecl cast_FriendDecl(type$ptr<?>/*P*/ From) {
    assert isa_FriendDecl(From);
    return llvm.cast(FriendDecl.class, From.$star());
  }

  public static FriendDecl cast_or_null_FriendDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FriendDecl(From);
  }

  public static FriendDecl dyn_cast_FriendDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static FriendDecl dyn_cast_or_null_FriendDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static boolean isa_FriendDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FriendDecl.class, From.$deref());
  }

  public static FriendDecl cast_FriendDecl(type$ref<?>/*P*/ From) {
    assert isa_FriendDecl(From);
    return llvm.cast(FriendDecl.class, From.$deref());
  }

  public static FriendDecl cast_or_null_FriendDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FriendDecl(From);
  }

  public static FriendDecl dyn_cast_FriendDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static FriendDecl dyn_cast_or_null_FriendDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FriendDecl(From) ? cast_FriendDecl(From) : null;
  }

  public static boolean isa_FriendTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return FriendTemplateDecl.classof(From);
  }

  public static FriendTemplateDecl cast_FriendTemplateDecl(Decl/*P*/ From) {
    assert isa_FriendTemplateDecl(From);
    return (FriendTemplateDecl) From;
  }

  public static FriendTemplateDecl cast_or_null_FriendTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FriendTemplateDecl(From);
  }

  public static FriendTemplateDecl dyn_cast_FriendTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static FriendTemplateDecl dyn_cast_or_null_FriendTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static boolean isa_FriendTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FriendTemplateDecl.class, From.$deref());
  }

  public static FriendTemplateDecl cast_FriendTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_FriendTemplateDecl(From);
    return llvm.cast(FriendTemplateDecl.class, From.$deref());
  }

  public static FriendTemplateDecl cast_or_null_FriendTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FriendTemplateDecl(From);
  }

  public static FriendTemplateDecl dyn_cast_FriendTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static FriendTemplateDecl dyn_cast_or_null_FriendTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static boolean isa_FriendTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FriendTemplateDecl.class, From.$star());
  }

  public static FriendTemplateDecl cast_FriendTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_FriendTemplateDecl(From);
    return llvm.cast(FriendTemplateDecl.class, From.$star());
  }

  public static FriendTemplateDecl cast_or_null_FriendTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FriendTemplateDecl(From);
  }

  public static FriendTemplateDecl dyn_cast_FriendTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static FriendTemplateDecl dyn_cast_or_null_FriendTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FriendTemplateDecl(From) ? cast_FriendTemplateDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(Decl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(Decl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return (FunctionDecl) From;
  }

  public static FunctionDecl cast_or_null_FunctionDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(Decl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionDecl.class, From.$deref());
  }

  public static FunctionDecl cast_FunctionDecl(type$ref<?>/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From.$deref());
  }

  public static FunctionDecl cast_or_null_FunctionDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionDecl.class, From.$star());
  }

  public static FunctionDecl cast_FunctionDecl(type$ptr<?>/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From.$star());
  }

  public static FunctionDecl cast_or_null_FunctionDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return FunctionDecl.classofKind(From.getDeclKind());
  }

  public static FunctionDecl cast_FunctionDecl(DeclContext/*P*/ From) {
    assert isa_FunctionDecl(From);
    return (FunctionDecl) From;
  }

  public static FunctionDecl cast_or_null_FunctionDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionTemplateDecl.class, From.$star());
  }

  public static FunctionTemplateDecl cast_FunctionTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_FunctionTemplateDecl(From);
    return llvm.cast(FunctionTemplateDecl.class, From.$star());
  }

  public static FunctionTemplateDecl cast_or_null_FunctionTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionTemplateDecl(From);
  }

  public static FunctionTemplateDecl dyn_cast_FunctionTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static FunctionTemplateDecl dyn_cast_or_null_FunctionTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static boolean isa_FunctionTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionTemplateDecl.class, From.$deref());
  }

  public static FunctionTemplateDecl cast_FunctionTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_FunctionTemplateDecl(From);
    return llvm.cast(FunctionTemplateDecl.class, From.$deref());
  }

  public static FunctionTemplateDecl cast_or_null_FunctionTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionTemplateDecl(From);
  }

  public static FunctionTemplateDecl dyn_cast_FunctionTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static FunctionTemplateDecl dyn_cast_or_null_FunctionTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static boolean isa_FunctionTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return FunctionTemplateDecl.classof(From);
  }

  public static FunctionTemplateDecl cast_FunctionTemplateDecl(Decl/*P*/ From) {
    assert isa_FunctionTemplateDecl(From);
    return (FunctionTemplateDecl) From;
  }

  public static FunctionTemplateDecl cast_or_null_FunctionTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_FunctionTemplateDecl(From);
  }

  public static FunctionTemplateDecl dyn_cast_FunctionTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static FunctionTemplateDecl dyn_cast_or_null_FunctionTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_FunctionTemplateDecl(From) ? cast_FunctionTemplateDecl(From) : null;
  }

  public static boolean isa_ImplicitParamDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ImplicitParamDecl.class, From.$star());
  }

  public static ImplicitParamDecl cast_ImplicitParamDecl(type$ptr<?>/*P*/ From) {
    assert isa_ImplicitParamDecl(From);
    return llvm.cast(ImplicitParamDecl.class, From.$star());
  }

  public static ImplicitParamDecl cast_or_null_ImplicitParamDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ImplicitParamDecl(From);
  }

  public static ImplicitParamDecl dyn_cast_ImplicitParamDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static ImplicitParamDecl dyn_cast_or_null_ImplicitParamDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static boolean isa_ImplicitParamDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ImplicitParamDecl.class, From.$deref());
  }

  public static ImplicitParamDecl cast_ImplicitParamDecl(type$ref<?>/*P*/ From) {
    assert isa_ImplicitParamDecl(From);
    return llvm.cast(ImplicitParamDecl.class, From.$deref());
  }

  public static ImplicitParamDecl cast_or_null_ImplicitParamDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ImplicitParamDecl(From);
  }

  public static ImplicitParamDecl dyn_cast_ImplicitParamDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static ImplicitParamDecl dyn_cast_or_null_ImplicitParamDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static boolean isa_ImplicitParamDecl(Decl/*P*/ From) {
    assert From != null;
    return ImplicitParamDecl.classof(From);
  }

  public static ImplicitParamDecl cast_ImplicitParamDecl(Decl/*P*/ From) {
    assert isa_ImplicitParamDecl(From);
    return (ImplicitParamDecl) From;
  }

  public static ImplicitParamDecl cast_or_null_ImplicitParamDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ImplicitParamDecl(From);
  }

  public static ImplicitParamDecl dyn_cast_ImplicitParamDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static ImplicitParamDecl dyn_cast_or_null_ImplicitParamDecl(Decl/*P*/ From) {
    return (From != null) && isa_ImplicitParamDecl(From) ? cast_ImplicitParamDecl(From) : null;
  }

  public static boolean isa_ImportDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ImportDecl.class, From.$deref());
  }

  public static ImportDecl cast_ImportDecl(type$ref<?>/*P*/ From) {
    assert isa_ImportDecl(From);
    return llvm.cast(ImportDecl.class, From.$deref());
  }

  public static ImportDecl cast_or_null_ImportDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ImportDecl(From);
  }

  public static ImportDecl dyn_cast_ImportDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static ImportDecl dyn_cast_or_null_ImportDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static boolean isa_ImportDecl(Decl/*P*/ From) {
    assert From != null;
    return ImportDecl.classof(From);
  }

  public static ImportDecl cast_ImportDecl(Decl/*P*/ From) {
    assert isa_ImportDecl(From);
    return (ImportDecl) From;
  }

  public static ImportDecl cast_or_null_ImportDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ImportDecl(From);
  }

  public static ImportDecl dyn_cast_ImportDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static ImportDecl dyn_cast_or_null_ImportDecl(Decl/*P*/ From) {
    return (From != null) && isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static boolean isa_ImportDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ImportDecl.class, From.$star());
  }

  public static ImportDecl cast_ImportDecl(type$ptr<?>/*P*/ From) {
    assert isa_ImportDecl(From);
    return llvm.cast(ImportDecl.class, From.$star());
  }

  public static ImportDecl cast_or_null_ImportDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ImportDecl(From);
  }

  public static ImportDecl dyn_cast_ImportDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static ImportDecl dyn_cast_or_null_ImportDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ImportDecl(From) ? cast_ImportDecl(From) : null;
  }

  public static boolean isa_IndirectFieldDecl(Decl/*P*/ From) {
    assert From != null;
    return IndirectFieldDecl.classof(From);
  }

  public static IndirectFieldDecl cast_IndirectFieldDecl(Decl/*P*/ From) {
    assert isa_IndirectFieldDecl(From);
    return (IndirectFieldDecl) From;
  }

  public static IndirectFieldDecl cast_or_null_IndirectFieldDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_IndirectFieldDecl(From);
  }

  public static IndirectFieldDecl dyn_cast_IndirectFieldDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static IndirectFieldDecl dyn_cast_or_null_IndirectFieldDecl(Decl/*P*/ From) {
    return (From != null) && isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static boolean isa_IndirectFieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IndirectFieldDecl.class, From.$deref());
  }

  public static IndirectFieldDecl cast_IndirectFieldDecl(type$ref<?>/*P*/ From) {
    assert isa_IndirectFieldDecl(From);
    return llvm.cast(IndirectFieldDecl.class, From.$deref());
  }

  public static IndirectFieldDecl cast_or_null_IndirectFieldDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IndirectFieldDecl(From);
  }

  public static IndirectFieldDecl dyn_cast_IndirectFieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static IndirectFieldDecl dyn_cast_or_null_IndirectFieldDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static boolean isa_IndirectFieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IndirectFieldDecl.class, From.$star());
  }

  public static IndirectFieldDecl cast_IndirectFieldDecl(type$ptr<?>/*P*/ From) {
    assert isa_IndirectFieldDecl(From);
    return llvm.cast(IndirectFieldDecl.class, From.$star());
  }

  public static IndirectFieldDecl cast_or_null_IndirectFieldDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IndirectFieldDecl(From);
  }

  public static IndirectFieldDecl dyn_cast_IndirectFieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static IndirectFieldDecl dyn_cast_or_null_IndirectFieldDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IndirectFieldDecl(From) ? cast_IndirectFieldDecl(From) : null;
  }

  public static boolean isa_LabelDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LabelDecl.class, From.$star());
  }

  public static LabelDecl cast_LabelDecl(type$ptr<?>/*P*/ From) {
    assert isa_LabelDecl(From);
    return llvm.cast(LabelDecl.class, From.$star());
  }

  public static LabelDecl cast_or_null_LabelDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LabelDecl(From);
  }

  public static LabelDecl dyn_cast_LabelDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static LabelDecl dyn_cast_or_null_LabelDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static boolean isa_LabelDecl(Decl/*P*/ From) {
    assert From != null;
    return LabelDecl.classof(From);
  }

  public static LabelDecl cast_LabelDecl(Decl/*P*/ From) {
    assert isa_LabelDecl(From);
    return (LabelDecl) From;
  }

  public static LabelDecl cast_or_null_LabelDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_LabelDecl(From);
  }

  public static LabelDecl dyn_cast_LabelDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static LabelDecl dyn_cast_or_null_LabelDecl(Decl/*P*/ From) {
    return (From != null) && isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static boolean isa_LabelDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LabelDecl.class, From.$deref());
  }

  public static LabelDecl cast_LabelDecl(type$ref<?>/*P*/ From) {
    assert isa_LabelDecl(From);
    return llvm.cast(LabelDecl.class, From.$deref());
  }

  public static LabelDecl cast_or_null_LabelDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LabelDecl(From);
  }

  public static LabelDecl dyn_cast_LabelDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static LabelDecl dyn_cast_or_null_LabelDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LabelDecl(From) ? cast_LabelDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(Decl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(Decl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return (LinkageSpecDecl) From;
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(Decl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LinkageSpecDecl.class, From.$deref());
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(type$ref<?>/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From.$deref());
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(DeclContext/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classofKind(From.getDeclKind());
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(DeclContext/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return (LinkageSpecDecl) From;
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LinkageSpecDecl.class, From.$star());
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(type$ptr<?>/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From.$star());
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_MSPropertyDecl(Decl/*P*/ From) {
    assert From != null;
    return MSPropertyDecl.classof(From);
  }

  public static MSPropertyDecl cast_MSPropertyDecl(Decl/*P*/ From) {
    assert isa_MSPropertyDecl(From);
    return (MSPropertyDecl) From;
  }

  public static MSPropertyDecl cast_or_null_MSPropertyDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_MSPropertyDecl(From);
  }

  public static MSPropertyDecl dyn_cast_MSPropertyDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static MSPropertyDecl dyn_cast_or_null_MSPropertyDecl(Decl/*P*/ From) {
    return (From != null) && isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static boolean isa_MSPropertyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSPropertyDecl.class, From.$deref());
  }

  public static MSPropertyDecl cast_MSPropertyDecl(type$ref<?>/*P*/ From) {
    assert isa_MSPropertyDecl(From);
    return llvm.cast(MSPropertyDecl.class, From.$deref());
  }

  public static MSPropertyDecl cast_or_null_MSPropertyDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSPropertyDecl(From);
  }

  public static MSPropertyDecl dyn_cast_MSPropertyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static MSPropertyDecl dyn_cast_or_null_MSPropertyDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static boolean isa_MSPropertyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSPropertyDecl.class, From.$star());
  }

  public static MSPropertyDecl cast_MSPropertyDecl(type$ptr<?>/*P*/ From) {
    assert isa_MSPropertyDecl(From);
    return llvm.cast(MSPropertyDecl.class, From.$star());
  }

  public static MSPropertyDecl cast_or_null_MSPropertyDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSPropertyDecl(From);
  }

  public static MSPropertyDecl dyn_cast_MSPropertyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static MSPropertyDecl dyn_cast_or_null_MSPropertyDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSPropertyDecl(From) ? cast_MSPropertyDecl(From) : null;
  }

  public static boolean isa_NamedDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NamedDecl.class, From.$deref());
  }

  public static NamedDecl cast_NamedDecl(type$ref<?>/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From.$deref());
  }

  public static NamedDecl cast_or_null_NamedDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(Decl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(Decl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(Decl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(DeclContext/*P*/ From) {
    assert From != null;
    return NamedDecl.classofKind(From.getDeclKind());
  }

  public static NamedDecl cast_NamedDecl(DeclContext/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NamedDecl.class, From.$star());
  }

  public static NamedDecl cast_NamedDecl(type$ptr<?>/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From.$star());
  }

  public static NamedDecl cast_or_null_NamedDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamespaceAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NamespaceAliasDecl.class, From.$deref());
  }

  public static NamespaceAliasDecl cast_NamespaceAliasDecl(type$ref<?>/*P*/ From) {
    assert isa_NamespaceAliasDecl(From);
    return llvm.cast(NamespaceAliasDecl.class, From.$deref());
  }

  public static NamespaceAliasDecl cast_or_null_NamespaceAliasDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NamespaceAliasDecl(From);
  }

  public static NamespaceAliasDecl dyn_cast_NamespaceAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static NamespaceAliasDecl dyn_cast_or_null_NamespaceAliasDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static boolean isa_NamespaceAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return NamespaceAliasDecl.classof(From);
  }

  public static NamespaceAliasDecl cast_NamespaceAliasDecl(Decl/*P*/ From) {
    assert isa_NamespaceAliasDecl(From);
    return (NamespaceAliasDecl) From;
  }

  public static NamespaceAliasDecl cast_or_null_NamespaceAliasDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceAliasDecl(From);
  }

  public static NamespaceAliasDecl dyn_cast_NamespaceAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static NamespaceAliasDecl dyn_cast_or_null_NamespaceAliasDecl(Decl/*P*/ From) {
    return (From != null) && isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static boolean isa_NamespaceAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NamespaceAliasDecl.class, From.$star());
  }

  public static NamespaceAliasDecl cast_NamespaceAliasDecl(type$ptr<?>/*P*/ From) {
    assert isa_NamespaceAliasDecl(From);
    return llvm.cast(NamespaceAliasDecl.class, From.$star());
  }

  public static NamespaceAliasDecl cast_or_null_NamespaceAliasDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NamespaceAliasDecl(From);
  }

  public static NamespaceAliasDecl dyn_cast_NamespaceAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static NamespaceAliasDecl dyn_cast_or_null_NamespaceAliasDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NamespaceAliasDecl(From) ? cast_NamespaceAliasDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NamespaceDecl.class, From.$star());
  }

  public static NamespaceDecl cast_NamespaceDecl(type$ptr<?>/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From.$star());
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(DeclContext/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classofKind(From.getDeclKind());
  }

  public static NamespaceDecl cast_NamespaceDecl(DeclContext/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return (NamespaceDecl) From;
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(Decl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(Decl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return (NamespaceDecl) From;
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(Decl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NamespaceDecl.class, From.$deref());
  }

  public static NamespaceDecl cast_NamespaceDecl(type$ref<?>/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From.$deref());
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NonTypeTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NonTypeTemplateParmDecl.class, From.$deref());
  }

  public static NonTypeTemplateParmDecl cast_NonTypeTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert isa_NonTypeTemplateParmDecl(From);
    return llvm.cast(NonTypeTemplateParmDecl.class, From.$deref());
  }

  public static NonTypeTemplateParmDecl cast_or_null_NonTypeTemplateParmDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NonTypeTemplateParmDecl(From);
  }

  public static NonTypeTemplateParmDecl dyn_cast_NonTypeTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static NonTypeTemplateParmDecl dyn_cast_or_null_NonTypeTemplateParmDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static boolean isa_NonTypeTemplateParmDecl(Decl/*P*/ From) {
    assert From != null;
    return NonTypeTemplateParmDecl.classof(From);
  }

  public static NonTypeTemplateParmDecl cast_NonTypeTemplateParmDecl(Decl/*P*/ From) {
    assert isa_NonTypeTemplateParmDecl(From);
    return (NonTypeTemplateParmDecl) From;
  }

  public static NonTypeTemplateParmDecl cast_or_null_NonTypeTemplateParmDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_NonTypeTemplateParmDecl(From);
  }

  public static NonTypeTemplateParmDecl dyn_cast_NonTypeTemplateParmDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static NonTypeTemplateParmDecl dyn_cast_or_null_NonTypeTemplateParmDecl(Decl/*P*/ From) {
    return (From != null) && isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static boolean isa_NonTypeTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NonTypeTemplateParmDecl.class, From.$star());
  }

  public static NonTypeTemplateParmDecl cast_NonTypeTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert isa_NonTypeTemplateParmDecl(From);
    return llvm.cast(NonTypeTemplateParmDecl.class, From.$star());
  }

  public static NonTypeTemplateParmDecl cast_or_null_NonTypeTemplateParmDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NonTypeTemplateParmDecl(From);
  }

  public static NonTypeTemplateParmDecl dyn_cast_NonTypeTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static NonTypeTemplateParmDecl dyn_cast_or_null_NonTypeTemplateParmDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NonTypeTemplateParmDecl(From) ? cast_NonTypeTemplateParmDecl(From) : null;
  }

  public static boolean isa_OMPCapturedExprDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCapturedExprDecl.class, From.$deref());
  }

  public static OMPCapturedExprDecl cast_OMPCapturedExprDecl(type$ref<?>/*P*/ From) {
    assert isa_OMPCapturedExprDecl(From);
    return llvm.cast(OMPCapturedExprDecl.class, From.$deref());
  }

  public static OMPCapturedExprDecl cast_or_null_OMPCapturedExprDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCapturedExprDecl(From);
  }

  public static OMPCapturedExprDecl dyn_cast_OMPCapturedExprDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static OMPCapturedExprDecl dyn_cast_or_null_OMPCapturedExprDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static boolean isa_OMPCapturedExprDecl(Decl/*P*/ From) {
    assert From != null;
    return OMPCapturedExprDecl.classof(From);
  }

  public static OMPCapturedExprDecl cast_OMPCapturedExprDecl(Decl/*P*/ From) {
    assert isa_OMPCapturedExprDecl(From);
    return (OMPCapturedExprDecl) From;
  }

  public static OMPCapturedExprDecl cast_or_null_OMPCapturedExprDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_OMPCapturedExprDecl(From);
  }

  public static OMPCapturedExprDecl dyn_cast_OMPCapturedExprDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static OMPCapturedExprDecl dyn_cast_or_null_OMPCapturedExprDecl(Decl/*P*/ From) {
    return (From != null) && isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static boolean isa_OMPCapturedExprDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCapturedExprDecl.class, From.$star());
  }

  public static OMPCapturedExprDecl cast_OMPCapturedExprDecl(type$ptr<?>/*P*/ From) {
    assert isa_OMPCapturedExprDecl(From);
    return llvm.cast(OMPCapturedExprDecl.class, From.$star());
  }

  public static OMPCapturedExprDecl cast_or_null_OMPCapturedExprDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCapturedExprDecl(From);
  }

  public static OMPCapturedExprDecl dyn_cast_OMPCapturedExprDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static OMPCapturedExprDecl dyn_cast_or_null_OMPCapturedExprDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCapturedExprDecl(From) ? cast_OMPCapturedExprDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDeclareReductionDecl.class, From.$star());
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(type$ptr<?>/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From.$star());
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(Decl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(Decl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return (OMPDeclareReductionDecl) From;
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(Decl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDeclareReductionDecl.class, From.$deref());
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(type$ref<?>/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From.$deref());
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classofKind(From.getDeclKind());
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(DeclContext/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return (OMPDeclareReductionDecl) From;
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPThreadPrivateDecl.class, From.$deref());
  }

  public static OMPThreadPrivateDecl cast_OMPThreadPrivateDecl(type$ref<?>/*P*/ From) {
    assert isa_OMPThreadPrivateDecl(From);
    return llvm.cast(OMPThreadPrivateDecl.class, From.$deref());
  }

  public static OMPThreadPrivateDecl cast_or_null_OMPThreadPrivateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPThreadPrivateDecl(From);
  }

  public static OMPThreadPrivateDecl dyn_cast_OMPThreadPrivateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static OMPThreadPrivateDecl dyn_cast_or_null_OMPThreadPrivateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDecl(Decl/*P*/ From) {
    assert From != null;
    return OMPThreadPrivateDecl.classof(From);
  }

  public static OMPThreadPrivateDecl cast_OMPThreadPrivateDecl(Decl/*P*/ From) {
    assert isa_OMPThreadPrivateDecl(From);
    return (OMPThreadPrivateDecl) From;
  }

  public static OMPThreadPrivateDecl cast_or_null_OMPThreadPrivateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_OMPThreadPrivateDecl(From);
  }

  public static OMPThreadPrivateDecl dyn_cast_OMPThreadPrivateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static OMPThreadPrivateDecl dyn_cast_or_null_OMPThreadPrivateDecl(Decl/*P*/ From) {
    return (From != null) && isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPThreadPrivateDecl.class, From.$star());
  }

  public static OMPThreadPrivateDecl cast_OMPThreadPrivateDecl(type$ptr<?>/*P*/ From) {
    assert isa_OMPThreadPrivateDecl(From);
    return llvm.cast(OMPThreadPrivateDecl.class, From.$star());
  }

  public static OMPThreadPrivateDecl cast_or_null_OMPThreadPrivateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPThreadPrivateDecl(From);
  }

  public static OMPThreadPrivateDecl dyn_cast_OMPThreadPrivateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static OMPThreadPrivateDecl dyn_cast_or_null_OMPThreadPrivateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPThreadPrivateDecl(From) ? cast_OMPThreadPrivateDecl(From) : null;
  }

  public static boolean isa_ObjCAtDefsFieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtDefsFieldDecl.class, From.$deref());
  }

  public static ObjCAtDefsFieldDecl cast_ObjCAtDefsFieldDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtDefsFieldDecl(From);
    return llvm.cast(ObjCAtDefsFieldDecl.class, From.$deref());
  }

  public static ObjCAtDefsFieldDecl cast_or_null_ObjCAtDefsFieldDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtDefsFieldDecl(From);
  }

  public static ObjCAtDefsFieldDecl dyn_cast_ObjCAtDefsFieldDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static ObjCAtDefsFieldDecl dyn_cast_or_null_ObjCAtDefsFieldDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static boolean isa_ObjCAtDefsFieldDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCAtDefsFieldDecl.classof(From);
  }

  public static ObjCAtDefsFieldDecl cast_ObjCAtDefsFieldDecl(Decl/*P*/ From) {
    assert isa_ObjCAtDefsFieldDecl(From);
    return (ObjCAtDefsFieldDecl) From;
  }

  public static ObjCAtDefsFieldDecl cast_or_null_ObjCAtDefsFieldDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtDefsFieldDecl(From);
  }

  public static ObjCAtDefsFieldDecl dyn_cast_ObjCAtDefsFieldDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static ObjCAtDefsFieldDecl dyn_cast_or_null_ObjCAtDefsFieldDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static boolean isa_ObjCAtDefsFieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtDefsFieldDecl.class, From.$star());
  }

  public static ObjCAtDefsFieldDecl cast_ObjCAtDefsFieldDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtDefsFieldDecl(From);
    return llvm.cast(ObjCAtDefsFieldDecl.class, From.$star());
  }

  public static ObjCAtDefsFieldDecl cast_or_null_ObjCAtDefsFieldDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtDefsFieldDecl(From);
  }

  public static ObjCAtDefsFieldDecl dyn_cast_ObjCAtDefsFieldDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static ObjCAtDefsFieldDecl dyn_cast_or_null_ObjCAtDefsFieldDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtDefsFieldDecl(From) ? cast_ObjCAtDefsFieldDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCCategoryDecl.class, From.$star());
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From.$star());
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCCategoryDecl.class, From.$deref());
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From.$deref());
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(Decl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return (ObjCCategoryDecl) From;
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classofKind(From.getDeclKind());
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(DeclContext/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return (ObjCCategoryDecl) From;
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCCategoryImplDecl.class, From.$star());
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From.$star());
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCCategoryImplDecl.class, From.$deref());
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From.$deref());
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(Decl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return (ObjCCategoryImplDecl) From;
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classofKind(From.getDeclKind());
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(DeclContext/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return (ObjCCategoryImplDecl) From;
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCompatibleAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCCompatibleAliasDecl.classof(From);
  }

  public static ObjCCompatibleAliasDecl cast_ObjCCompatibleAliasDecl(Decl/*P*/ From) {
    assert isa_ObjCCompatibleAliasDecl(From);
    return (ObjCCompatibleAliasDecl) From;
  }

  public static ObjCCompatibleAliasDecl cast_or_null_ObjCCompatibleAliasDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCompatibleAliasDecl(From);
  }

  public static ObjCCompatibleAliasDecl dyn_cast_ObjCCompatibleAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static ObjCCompatibleAliasDecl dyn_cast_or_null_ObjCCompatibleAliasDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static boolean isa_ObjCCompatibleAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCCompatibleAliasDecl.class, From.$star());
  }

  public static ObjCCompatibleAliasDecl cast_ObjCCompatibleAliasDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCCompatibleAliasDecl(From);
    return llvm.cast(ObjCCompatibleAliasDecl.class, From.$star());
  }

  public static ObjCCompatibleAliasDecl cast_or_null_ObjCCompatibleAliasDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCCompatibleAliasDecl(From);
  }

  public static ObjCCompatibleAliasDecl dyn_cast_ObjCCompatibleAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static ObjCCompatibleAliasDecl dyn_cast_or_null_ObjCCompatibleAliasDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static boolean isa_ObjCCompatibleAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCCompatibleAliasDecl.class, From.$deref());
  }

  public static ObjCCompatibleAliasDecl cast_ObjCCompatibleAliasDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCCompatibleAliasDecl(From);
    return llvm.cast(ObjCCompatibleAliasDecl.class, From.$deref());
  }

  public static ObjCCompatibleAliasDecl cast_or_null_ObjCCompatibleAliasDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCCompatibleAliasDecl(From);
  }

  public static ObjCCompatibleAliasDecl dyn_cast_ObjCCompatibleAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static ObjCCompatibleAliasDecl dyn_cast_or_null_ObjCCompatibleAliasDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCCompatibleAliasDecl(From) ? cast_ObjCCompatibleAliasDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCContainerDecl.class, From.$deref());
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From.$deref());
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classofKind(From.getDeclKind());
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(DeclContext/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return (ObjCContainerDecl) From;
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(Decl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return (ObjCContainerDecl) From;
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCContainerDecl.class, From.$star());
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From.$star());
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCImplDecl.class, From.$star());
  }

  public static ObjCImplDecl cast_ObjCImplDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From.$star());
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCImplDecl.class, From.$deref());
  }

  public static ObjCImplDecl cast_ObjCImplDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From.$deref());
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classofKind(From.getDeclKind());
  }

  public static ObjCImplDecl cast_ObjCImplDecl(DeclContext/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return (ObjCImplDecl) From;
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(Decl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return (ObjCImplDecl) From;
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCImplementationDecl.class, From.$deref());
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From.$deref());
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classofKind(From.getDeclKind());
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(DeclContext/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return (ObjCImplementationDecl) From;
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(Decl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return (ObjCImplementationDecl) From;
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCImplementationDecl.class, From.$star());
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From.$star());
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classofKind(From.getDeclKind());
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(DeclContext/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return (ObjCInterfaceDecl) From;
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCInterfaceDecl.class, From.$star());
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From.$star());
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCInterfaceDecl.class, From.$deref());
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From.$deref());
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(Decl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return (ObjCInterfaceDecl) From;
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCIvarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIvarDecl.class, From.$star());
  }

  public static ObjCIvarDecl cast_ObjCIvarDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIvarDecl(From);
    return llvm.cast(ObjCIvarDecl.class, From.$star());
  }

  public static ObjCIvarDecl cast_or_null_ObjCIvarDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIvarDecl(From);
  }

  public static ObjCIvarDecl dyn_cast_ObjCIvarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static ObjCIvarDecl dyn_cast_or_null_ObjCIvarDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static boolean isa_ObjCIvarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIvarDecl.class, From.$deref());
  }

  public static ObjCIvarDecl cast_ObjCIvarDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCIvarDecl(From);
    return llvm.cast(ObjCIvarDecl.class, From.$deref());
  }

  public static ObjCIvarDecl cast_or_null_ObjCIvarDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIvarDecl(From);
  }

  public static ObjCIvarDecl dyn_cast_ObjCIvarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static ObjCIvarDecl dyn_cast_or_null_ObjCIvarDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static boolean isa_ObjCIvarDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCIvarDecl.classof(From);
  }

  public static ObjCIvarDecl cast_ObjCIvarDecl(Decl/*P*/ From) {
    assert isa_ObjCIvarDecl(From);
    return (ObjCIvarDecl) From;
  }

  public static ObjCIvarDecl cast_or_null_ObjCIvarDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCIvarDecl(From);
  }

  public static ObjCIvarDecl dyn_cast_ObjCIvarDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static ObjCIvarDecl dyn_cast_or_null_ObjCIvarDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCIvarDecl(From) ? cast_ObjCIvarDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCMethodDecl.class, From.$star());
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From.$star());
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(Decl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return (ObjCMethodDecl) From;
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classofKind(From.getDeclKind());
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(DeclContext/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return (ObjCMethodDecl) From;
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCMethodDecl.class, From.$deref());
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From.$deref());
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCPropertyDecl.class, From.$deref());
  }

  public static ObjCPropertyDecl cast_ObjCPropertyDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCPropertyDecl(From);
    return llvm.cast(ObjCPropertyDecl.class, From.$deref());
  }

  public static ObjCPropertyDecl cast_or_null_ObjCPropertyDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCPropertyDecl(From);
  }

  public static ObjCPropertyDecl dyn_cast_ObjCPropertyDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static ObjCPropertyDecl dyn_cast_or_null_ObjCPropertyDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCPropertyDecl.classof(From);
  }

  public static ObjCPropertyDecl cast_ObjCPropertyDecl(Decl/*P*/ From) {
    assert isa_ObjCPropertyDecl(From);
    return (ObjCPropertyDecl) From;
  }

  public static ObjCPropertyDecl cast_or_null_ObjCPropertyDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCPropertyDecl(From);
  }

  public static ObjCPropertyDecl dyn_cast_ObjCPropertyDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static ObjCPropertyDecl dyn_cast_or_null_ObjCPropertyDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCPropertyDecl.class, From.$star());
  }

  public static ObjCPropertyDecl cast_ObjCPropertyDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCPropertyDecl(From);
    return llvm.cast(ObjCPropertyDecl.class, From.$star());
  }

  public static ObjCPropertyDecl cast_or_null_ObjCPropertyDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCPropertyDecl(From);
  }

  public static ObjCPropertyDecl dyn_cast_ObjCPropertyDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static ObjCPropertyDecl dyn_cast_or_null_ObjCPropertyDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCPropertyDecl(From) ? cast_ObjCPropertyDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCPropertyImplDecl.class, From.$star());
  }

  public static ObjCPropertyImplDecl cast_ObjCPropertyImplDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCPropertyImplDecl(From);
    return llvm.cast(ObjCPropertyImplDecl.class, From.$star());
  }

  public static ObjCPropertyImplDecl cast_or_null_ObjCPropertyImplDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCPropertyImplDecl(From);
  }

  public static ObjCPropertyImplDecl dyn_cast_ObjCPropertyImplDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static ObjCPropertyImplDecl dyn_cast_or_null_ObjCPropertyImplDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCPropertyImplDecl.class, From.$deref());
  }

  public static ObjCPropertyImplDecl cast_ObjCPropertyImplDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCPropertyImplDecl(From);
    return llvm.cast(ObjCPropertyImplDecl.class, From.$deref());
  }

  public static ObjCPropertyImplDecl cast_or_null_ObjCPropertyImplDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCPropertyImplDecl(From);
  }

  public static ObjCPropertyImplDecl dyn_cast_ObjCPropertyImplDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static ObjCPropertyImplDecl dyn_cast_or_null_ObjCPropertyImplDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static boolean isa_ObjCPropertyImplDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCPropertyImplDecl.classof(From);
  }

  public static ObjCPropertyImplDecl cast_ObjCPropertyImplDecl(Decl/*P*/ From) {
    assert isa_ObjCPropertyImplDecl(From);
    return (ObjCPropertyImplDecl) From;
  }

  public static ObjCPropertyImplDecl cast_or_null_ObjCPropertyImplDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCPropertyImplDecl(From);
  }

  public static ObjCPropertyImplDecl dyn_cast_ObjCPropertyImplDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static ObjCPropertyImplDecl dyn_cast_or_null_ObjCPropertyImplDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCPropertyImplDecl(From) ? cast_ObjCPropertyImplDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(Decl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return (ObjCProtocolDecl) From;
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCProtocolDecl.class, From.$deref());
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From.$deref());
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classofKind(From.getDeclKind());
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(DeclContext/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return (ObjCProtocolDecl) From;
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCProtocolDecl.class, From.$star());
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From.$star());
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCTypeParamDecl(Decl/*P*/ From) {
    assert From != null;
    return ObjCTypeParamDecl.classof(From);
  }

  public static ObjCTypeParamDecl cast_ObjCTypeParamDecl(Decl/*P*/ From) {
    assert isa_ObjCTypeParamDecl(From);
    return (ObjCTypeParamDecl) From;
  }

  public static ObjCTypeParamDecl cast_or_null_ObjCTypeParamDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ObjCTypeParamDecl(From);
  }

  public static ObjCTypeParamDecl dyn_cast_ObjCTypeParamDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static ObjCTypeParamDecl dyn_cast_or_null_ObjCTypeParamDecl(Decl/*P*/ From) {
    return (From != null) && isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static boolean isa_ObjCTypeParamDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCTypeParamDecl.class, From.$deref());
  }

  public static ObjCTypeParamDecl cast_ObjCTypeParamDecl(type$ref<?>/*P*/ From) {
    assert isa_ObjCTypeParamDecl(From);
    return llvm.cast(ObjCTypeParamDecl.class, From.$deref());
  }

  public static ObjCTypeParamDecl cast_or_null_ObjCTypeParamDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCTypeParamDecl(From);
  }

  public static ObjCTypeParamDecl dyn_cast_ObjCTypeParamDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static ObjCTypeParamDecl dyn_cast_or_null_ObjCTypeParamDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static boolean isa_ObjCTypeParamDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCTypeParamDecl.class, From.$star());
  }

  public static ObjCTypeParamDecl cast_ObjCTypeParamDecl(type$ptr<?>/*P*/ From) {
    assert isa_ObjCTypeParamDecl(From);
    return llvm.cast(ObjCTypeParamDecl.class, From.$star());
  }

  public static ObjCTypeParamDecl cast_or_null_ObjCTypeParamDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCTypeParamDecl(From);
  }

  public static ObjCTypeParamDecl dyn_cast_ObjCTypeParamDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static ObjCTypeParamDecl dyn_cast_or_null_ObjCTypeParamDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCTypeParamDecl(From) ? cast_ObjCTypeParamDecl(From) : null;
  }

  public static boolean isa_ParmVarDecl(Decl/*P*/ From) {
    assert From != null;
    return ParmVarDecl.classof(From);
  }

  public static ParmVarDecl cast_ParmVarDecl(Decl/*P*/ From) {
    assert isa_ParmVarDecl(From);
    return (ParmVarDecl) From;
  }

  public static ParmVarDecl cast_or_null_ParmVarDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ParmVarDecl(From);
  }

  public static ParmVarDecl dyn_cast_ParmVarDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static ParmVarDecl dyn_cast_or_null_ParmVarDecl(Decl/*P*/ From) {
    return (From != null) && isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static boolean isa_ParmVarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParmVarDecl.class, From.$star());
  }

  public static ParmVarDecl cast_ParmVarDecl(type$ptr<?>/*P*/ From) {
    assert isa_ParmVarDecl(From);
    return llvm.cast(ParmVarDecl.class, From.$star());
  }

  public static ParmVarDecl cast_or_null_ParmVarDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParmVarDecl(From);
  }

  public static ParmVarDecl dyn_cast_ParmVarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static ParmVarDecl dyn_cast_or_null_ParmVarDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static boolean isa_ParmVarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParmVarDecl.class, From.$deref());
  }

  public static ParmVarDecl cast_ParmVarDecl(type$ref<?>/*P*/ From) {
    assert isa_ParmVarDecl(From);
    return llvm.cast(ParmVarDecl.class, From.$deref());
  }

  public static ParmVarDecl cast_or_null_ParmVarDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParmVarDecl(From);
  }

  public static ParmVarDecl dyn_cast_ParmVarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static ParmVarDecl dyn_cast_or_null_ParmVarDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParmVarDecl(From) ? cast_ParmVarDecl(From) : null;
  }

  public static boolean isa_PragmaCommentDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PragmaCommentDecl.class, From.$deref());
  }

  public static PragmaCommentDecl cast_PragmaCommentDecl(type$ref<?>/*P*/ From) {
    assert isa_PragmaCommentDecl(From);
    return llvm.cast(PragmaCommentDecl.class, From.$deref());
  }

  public static PragmaCommentDecl cast_or_null_PragmaCommentDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PragmaCommentDecl(From);
  }

  public static PragmaCommentDecl dyn_cast_PragmaCommentDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static PragmaCommentDecl dyn_cast_or_null_PragmaCommentDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static boolean isa_PragmaCommentDecl(Decl/*P*/ From) {
    assert From != null;
    return PragmaCommentDecl.classof(From);
  }

  public static PragmaCommentDecl cast_PragmaCommentDecl(Decl/*P*/ From) {
    assert isa_PragmaCommentDecl(From);
    return (PragmaCommentDecl) From;
  }

  public static PragmaCommentDecl cast_or_null_PragmaCommentDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_PragmaCommentDecl(From);
  }

  public static PragmaCommentDecl dyn_cast_PragmaCommentDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static PragmaCommentDecl dyn_cast_or_null_PragmaCommentDecl(Decl/*P*/ From) {
    return (From != null) && isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static boolean isa_PragmaCommentDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PragmaCommentDecl.class, From.$star());
  }

  public static PragmaCommentDecl cast_PragmaCommentDecl(type$ptr<?>/*P*/ From) {
    assert isa_PragmaCommentDecl(From);
    return llvm.cast(PragmaCommentDecl.class, From.$star());
  }

  public static PragmaCommentDecl cast_or_null_PragmaCommentDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PragmaCommentDecl(From);
  }

  public static PragmaCommentDecl dyn_cast_PragmaCommentDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static PragmaCommentDecl dyn_cast_or_null_PragmaCommentDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PragmaCommentDecl(From) ? cast_PragmaCommentDecl(From) : null;
  }

  public static boolean isa_PragmaDetectMismatchDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PragmaDetectMismatchDecl.class, From.$star());
  }

  public static PragmaDetectMismatchDecl cast_PragmaDetectMismatchDecl(type$ptr<?>/*P*/ From) {
    assert isa_PragmaDetectMismatchDecl(From);
    return llvm.cast(PragmaDetectMismatchDecl.class, From.$star());
  }

  public static PragmaDetectMismatchDecl cast_or_null_PragmaDetectMismatchDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PragmaDetectMismatchDecl(From);
  }

  public static PragmaDetectMismatchDecl dyn_cast_PragmaDetectMismatchDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static PragmaDetectMismatchDecl dyn_cast_or_null_PragmaDetectMismatchDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static boolean isa_PragmaDetectMismatchDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PragmaDetectMismatchDecl.class, From.$deref());
  }

  public static PragmaDetectMismatchDecl cast_PragmaDetectMismatchDecl(type$ref<?>/*P*/ From) {
    assert isa_PragmaDetectMismatchDecl(From);
    return llvm.cast(PragmaDetectMismatchDecl.class, From.$deref());
  }

  public static PragmaDetectMismatchDecl cast_or_null_PragmaDetectMismatchDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PragmaDetectMismatchDecl(From);
  }

  public static PragmaDetectMismatchDecl dyn_cast_PragmaDetectMismatchDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static PragmaDetectMismatchDecl dyn_cast_or_null_PragmaDetectMismatchDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static boolean isa_PragmaDetectMismatchDecl(Decl/*P*/ From) {
    assert From != null;
    return PragmaDetectMismatchDecl.classof(From);
  }

  public static PragmaDetectMismatchDecl cast_PragmaDetectMismatchDecl(Decl/*P*/ From) {
    assert isa_PragmaDetectMismatchDecl(From);
    return (PragmaDetectMismatchDecl) From;
  }

  public static PragmaDetectMismatchDecl cast_or_null_PragmaDetectMismatchDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_PragmaDetectMismatchDecl(From);
  }

  public static PragmaDetectMismatchDecl dyn_cast_PragmaDetectMismatchDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static PragmaDetectMismatchDecl dyn_cast_or_null_PragmaDetectMismatchDecl(Decl/*P*/ From) {
    return (From != null) && isa_PragmaDetectMismatchDecl(From) ? cast_PragmaDetectMismatchDecl(From) : null;
  }

  public static boolean isa_RecordDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RecordDecl.class, From.$deref());
  }

  public static RecordDecl cast_RecordDecl(type$ref<?>/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From.$deref());
  }

  public static RecordDecl cast_or_null_RecordDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(Decl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(Decl/*P*/ From) {
    assert isa_RecordDecl(From);
    return (RecordDecl) From;
  }

  public static RecordDecl cast_or_null_RecordDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(Decl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RecordDecl.class, From.$star());
  }

  public static RecordDecl cast_RecordDecl(type$ptr<?>/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From.$star());
  }

  public static RecordDecl cast_or_null_RecordDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(DeclContext/*P*/ From) {
    assert From != null;
    return RecordDecl.classofKind(From.getDeclKind());
  }

  public static RecordDecl cast_RecordDecl(DeclContext/*P*/ From) {
    assert isa_RecordDecl(From);
    return (RecordDecl) From;
  }

  public static RecordDecl cast_or_null_RecordDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RedeclarableTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RedeclarableTemplateDecl.class, From.$star());
  }

  public static RedeclarableTemplateDecl cast_RedeclarableTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_RedeclarableTemplateDecl(From);
    return llvm.cast(RedeclarableTemplateDecl.class, From.$star());
  }

  public static RedeclarableTemplateDecl cast_or_null_RedeclarableTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RedeclarableTemplateDecl(From);
  }

  public static RedeclarableTemplateDecl dyn_cast_RedeclarableTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static RedeclarableTemplateDecl dyn_cast_or_null_RedeclarableTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static boolean isa_RedeclarableTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RedeclarableTemplateDecl.class, From.$deref());
  }

  public static RedeclarableTemplateDecl cast_RedeclarableTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_RedeclarableTemplateDecl(From);
    return llvm.cast(RedeclarableTemplateDecl.class, From.$deref());
  }

  public static RedeclarableTemplateDecl cast_or_null_RedeclarableTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RedeclarableTemplateDecl(From);
  }

  public static RedeclarableTemplateDecl dyn_cast_RedeclarableTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static RedeclarableTemplateDecl dyn_cast_or_null_RedeclarableTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static boolean isa_RedeclarableTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return RedeclarableTemplateDecl.classof(From);
  }

  public static RedeclarableTemplateDecl cast_RedeclarableTemplateDecl(Decl/*P*/ From) {
    assert isa_RedeclarableTemplateDecl(From);
    return (RedeclarableTemplateDecl) From;
  }

  public static RedeclarableTemplateDecl cast_or_null_RedeclarableTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_RedeclarableTemplateDecl(From);
  }

  public static RedeclarableTemplateDecl dyn_cast_RedeclarableTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static RedeclarableTemplateDecl dyn_cast_or_null_RedeclarableTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_RedeclarableTemplateDecl(From) ? cast_RedeclarableTemplateDecl(From) : null;
  }

  public static boolean isa_StaticAssertDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StaticAssertDecl.class, From.$star());
  }

  public static StaticAssertDecl cast_StaticAssertDecl(type$ptr<?>/*P*/ From) {
    assert isa_StaticAssertDecl(From);
    return llvm.cast(StaticAssertDecl.class, From.$star());
  }

  public static StaticAssertDecl cast_or_null_StaticAssertDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StaticAssertDecl(From);
  }

  public static StaticAssertDecl dyn_cast_StaticAssertDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static StaticAssertDecl dyn_cast_or_null_StaticAssertDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static boolean isa_StaticAssertDecl(Decl/*P*/ From) {
    assert From != null;
    return StaticAssertDecl.classof(From);
  }

  public static StaticAssertDecl cast_StaticAssertDecl(Decl/*P*/ From) {
    assert isa_StaticAssertDecl(From);
    return (StaticAssertDecl) From;
  }

  public static StaticAssertDecl cast_or_null_StaticAssertDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_StaticAssertDecl(From);
  }

  public static StaticAssertDecl dyn_cast_StaticAssertDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static StaticAssertDecl dyn_cast_or_null_StaticAssertDecl(Decl/*P*/ From) {
    return (From != null) && isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static boolean isa_StaticAssertDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StaticAssertDecl.class, From.$deref());
  }

  public static StaticAssertDecl cast_StaticAssertDecl(type$ref<?>/*P*/ From) {
    assert isa_StaticAssertDecl(From);
    return llvm.cast(StaticAssertDecl.class, From.$deref());
  }

  public static StaticAssertDecl cast_or_null_StaticAssertDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StaticAssertDecl(From);
  }

  public static StaticAssertDecl dyn_cast_StaticAssertDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static StaticAssertDecl dyn_cast_or_null_StaticAssertDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StaticAssertDecl(From) ? cast_StaticAssertDecl(From) : null;
  }

  public static boolean isa_TagDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TagDecl.class, From.$star());
  }

  public static TagDecl cast_TagDecl(type$ptr<?>/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From.$star());
  }

  public static TagDecl cast_or_null_TagDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TagDecl.class, From.$deref());
  }

  public static TagDecl cast_TagDecl(type$ref<?>/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From.$deref());
  }

  public static TagDecl cast_or_null_TagDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(DeclContext/*P*/ From) {
    assert From != null;
    return TagDecl.classofKind(From.getDeclKind());
  }

  public static TagDecl cast_TagDecl(DeclContext/*P*/ From) {
    assert isa_TagDecl(From);
    return (TagDecl) From;
  }

  public static TagDecl cast_or_null_TagDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(Decl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(Decl/*P*/ From) {
    assert isa_TagDecl(From);
    return (TagDecl) From;
  }

  public static TagDecl cast_or_null_TagDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(Decl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return TemplateDecl.classof(From);
  }

  public static TemplateDecl cast_TemplateDecl(Decl/*P*/ From) {
    assert isa_TemplateDecl(From);
    return (TemplateDecl) From;
  }

  public static TemplateDecl cast_or_null_TemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TemplateDecl(From);
  }

  public static TemplateDecl dyn_cast_TemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static TemplateDecl dyn_cast_or_null_TemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static boolean isa_TemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TemplateDecl.class, From.$deref());
  }

  public static TemplateDecl cast_TemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_TemplateDecl(From);
    return llvm.cast(TemplateDecl.class, From.$deref());
  }

  public static TemplateDecl cast_or_null_TemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TemplateDecl(From);
  }

  public static TemplateDecl dyn_cast_TemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static TemplateDecl dyn_cast_or_null_TemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static boolean isa_TemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TemplateDecl.class, From.$star());
  }

  public static TemplateDecl cast_TemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_TemplateDecl(From);
    return llvm.cast(TemplateDecl.class, From.$star());
  }

  public static TemplateDecl cast_or_null_TemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TemplateDecl(From);
  }

  public static TemplateDecl dyn_cast_TemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static TemplateDecl dyn_cast_or_null_TemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TemplateDecl(From) ? cast_TemplateDecl(From) : null;
  }

  public static boolean isa_TemplateTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TemplateTemplateParmDecl.class, From.$deref());
  }

  public static TemplateTemplateParmDecl cast_TemplateTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert isa_TemplateTemplateParmDecl(From);
    return llvm.cast(TemplateTemplateParmDecl.class, From.$deref());
  }

  public static TemplateTemplateParmDecl cast_or_null_TemplateTemplateParmDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TemplateTemplateParmDecl(From);
  }

  public static TemplateTemplateParmDecl dyn_cast_TemplateTemplateParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static TemplateTemplateParmDecl dyn_cast_or_null_TemplateTemplateParmDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static boolean isa_TemplateTemplateParmDecl(Decl/*P*/ From) {
    assert From != null;
    return TemplateTemplateParmDecl.classof(From);
  }

  public static TemplateTemplateParmDecl cast_TemplateTemplateParmDecl(Decl/*P*/ From) {
    assert isa_TemplateTemplateParmDecl(From);
    return (TemplateTemplateParmDecl) From;
  }

  public static TemplateTemplateParmDecl cast_or_null_TemplateTemplateParmDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TemplateTemplateParmDecl(From);
  }

  public static TemplateTemplateParmDecl dyn_cast_TemplateTemplateParmDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static TemplateTemplateParmDecl dyn_cast_or_null_TemplateTemplateParmDecl(Decl/*P*/ From) {
    return (From != null) && isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static boolean isa_TemplateTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TemplateTemplateParmDecl.class, From.$star());
  }

  public static TemplateTemplateParmDecl cast_TemplateTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert isa_TemplateTemplateParmDecl(From);
    return llvm.cast(TemplateTemplateParmDecl.class, From.$star());
  }

  public static TemplateTemplateParmDecl cast_or_null_TemplateTemplateParmDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TemplateTemplateParmDecl(From);
  }

  public static TemplateTemplateParmDecl dyn_cast_TemplateTemplateParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static TemplateTemplateParmDecl dyn_cast_or_null_TemplateTemplateParmDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TemplateTemplateParmDecl(From) ? cast_TemplateTemplateParmDecl(From) : null;
  }

  public static boolean isa_TemplateTypeParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TemplateTypeParmDecl.class, From.$star());
  }

  public static TemplateTypeParmDecl cast_TemplateTypeParmDecl(type$ptr<?>/*P*/ From) {
    assert isa_TemplateTypeParmDecl(From);
    return llvm.cast(TemplateTypeParmDecl.class, From.$star());
  }

  public static TemplateTypeParmDecl cast_or_null_TemplateTypeParmDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TemplateTypeParmDecl(From);
  }

  public static TemplateTypeParmDecl dyn_cast_TemplateTypeParmDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static TemplateTypeParmDecl dyn_cast_or_null_TemplateTypeParmDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static boolean isa_TemplateTypeParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TemplateTypeParmDecl.class, From.$deref());
  }

  public static TemplateTypeParmDecl cast_TemplateTypeParmDecl(type$ref<?>/*P*/ From) {
    assert isa_TemplateTypeParmDecl(From);
    return llvm.cast(TemplateTypeParmDecl.class, From.$deref());
  }

  public static TemplateTypeParmDecl cast_or_null_TemplateTypeParmDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TemplateTypeParmDecl(From);
  }

  public static TemplateTypeParmDecl dyn_cast_TemplateTypeParmDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static TemplateTypeParmDecl dyn_cast_or_null_TemplateTypeParmDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static boolean isa_TemplateTypeParmDecl(Decl/*P*/ From) {
    assert From != null;
    return TemplateTypeParmDecl.classof(From);
  }

  public static TemplateTypeParmDecl cast_TemplateTypeParmDecl(Decl/*P*/ From) {
    assert isa_TemplateTypeParmDecl(From);
    return (TemplateTypeParmDecl) From;
  }

  public static TemplateTypeParmDecl cast_or_null_TemplateTypeParmDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TemplateTypeParmDecl(From);
  }

  public static TemplateTypeParmDecl dyn_cast_TemplateTypeParmDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static TemplateTypeParmDecl dyn_cast_or_null_TemplateTypeParmDecl(Decl/*P*/ From) {
    return (From != null) && isa_TemplateTypeParmDecl(From) ? cast_TemplateTypeParmDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TranslationUnitDecl.class, From.$deref());
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(type$ref<?>/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From.$deref());
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(Decl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(Decl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return (TranslationUnitDecl) From;
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(Decl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(DeclContext/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classofKind(From.getDeclKind());
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(DeclContext/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return (TranslationUnitDecl) From;
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TranslationUnitDecl.class, From.$star());
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(type$ptr<?>/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From.$star());
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TypeAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeAliasDecl.class, From.$deref());
  }

  public static TypeAliasDecl cast_TypeAliasDecl(type$ref<?>/*P*/ From) {
    assert isa_TypeAliasDecl(From);
    return llvm.cast(TypeAliasDecl.class, From.$deref());
  }

  public static TypeAliasDecl cast_or_null_TypeAliasDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeAliasDecl(From);
  }

  public static TypeAliasDecl dyn_cast_TypeAliasDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static TypeAliasDecl dyn_cast_or_null_TypeAliasDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static boolean isa_TypeAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeAliasDecl.class, From.$star());
  }

  public static TypeAliasDecl cast_TypeAliasDecl(type$ptr<?>/*P*/ From) {
    assert isa_TypeAliasDecl(From);
    return llvm.cast(TypeAliasDecl.class, From.$star());
  }

  public static TypeAliasDecl cast_or_null_TypeAliasDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeAliasDecl(From);
  }

  public static TypeAliasDecl dyn_cast_TypeAliasDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static TypeAliasDecl dyn_cast_or_null_TypeAliasDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static boolean isa_TypeAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return TypeAliasDecl.classof(From);
  }

  public static TypeAliasDecl cast_TypeAliasDecl(Decl/*P*/ From) {
    assert isa_TypeAliasDecl(From);
    return (TypeAliasDecl) From;
  }

  public static TypeAliasDecl cast_or_null_TypeAliasDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TypeAliasDecl(From);
  }

  public static TypeAliasDecl dyn_cast_TypeAliasDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static TypeAliasDecl dyn_cast_or_null_TypeAliasDecl(Decl/*P*/ From) {
    return (From != null) && isa_TypeAliasDecl(From) ? cast_TypeAliasDecl(From) : null;
  }

  public static boolean isa_TypeAliasTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return TypeAliasTemplateDecl.classof(From);
  }

  public static TypeAliasTemplateDecl cast_TypeAliasTemplateDecl(Decl/*P*/ From) {
    assert isa_TypeAliasTemplateDecl(From);
    return (TypeAliasTemplateDecl) From;
  }

  public static TypeAliasTemplateDecl cast_or_null_TypeAliasTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TypeAliasTemplateDecl(From);
  }

  public static TypeAliasTemplateDecl dyn_cast_TypeAliasTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static TypeAliasTemplateDecl dyn_cast_or_null_TypeAliasTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static boolean isa_TypeAliasTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeAliasTemplateDecl.class, From.$deref());
  }

  public static TypeAliasTemplateDecl cast_TypeAliasTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_TypeAliasTemplateDecl(From);
    return llvm.cast(TypeAliasTemplateDecl.class, From.$deref());
  }

  public static TypeAliasTemplateDecl cast_or_null_TypeAliasTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeAliasTemplateDecl(From);
  }

  public static TypeAliasTemplateDecl dyn_cast_TypeAliasTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static TypeAliasTemplateDecl dyn_cast_or_null_TypeAliasTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static boolean isa_TypeAliasTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeAliasTemplateDecl.class, From.$star());
  }

  public static TypeAliasTemplateDecl cast_TypeAliasTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_TypeAliasTemplateDecl(From);
    return llvm.cast(TypeAliasTemplateDecl.class, From.$star());
  }

  public static TypeAliasTemplateDecl cast_or_null_TypeAliasTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeAliasTemplateDecl(From);
  }

  public static TypeAliasTemplateDecl dyn_cast_TypeAliasTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static TypeAliasTemplateDecl dyn_cast_or_null_TypeAliasTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeAliasTemplateDecl(From) ? cast_TypeAliasTemplateDecl(From) : null;
  }

  public static boolean isa_TypeDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeDecl.class, From.$star());
  }

  public static TypeDecl cast_TypeDecl(type$ptr<?>/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From.$star());
  }

  public static TypeDecl cast_or_null_TypeDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeDecl.class, From.$deref());
  }

  public static TypeDecl cast_TypeDecl(type$ref<?>/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From.$deref());
  }

  public static TypeDecl cast_or_null_TypeDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(Decl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(Decl/*P*/ From) {
    assert isa_TypeDecl(From);
    return (TypeDecl) From;
  }

  public static TypeDecl cast_or_null_TypeDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(Decl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(DeclContext/*P*/ From) {
    assert From != null;
    return TypeDecl.classofKind(From.getDeclKind());
  }

  public static TypeDecl cast_TypeDecl(DeclContext/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypedefDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypedefDecl.class, From.$star());
  }

  public static TypedefDecl cast_TypedefDecl(type$ptr<?>/*P*/ From) {
    assert isa_TypedefDecl(From);
    return llvm.cast(TypedefDecl.class, From.$star());
  }

  public static TypedefDecl cast_or_null_TypedefDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypedefDecl(From);
  }

  public static TypedefDecl dyn_cast_TypedefDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static TypedefDecl dyn_cast_or_null_TypedefDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static boolean isa_TypedefDecl(Decl/*P*/ From) {
    assert From != null;
    return TypedefDecl.classof(From);
  }

  public static TypedefDecl cast_TypedefDecl(Decl/*P*/ From) {
    assert isa_TypedefDecl(From);
    return (TypedefDecl) From;
  }

  public static TypedefDecl cast_or_null_TypedefDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TypedefDecl(From);
  }

  public static TypedefDecl dyn_cast_TypedefDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static TypedefDecl dyn_cast_or_null_TypedefDecl(Decl/*P*/ From) {
    return (From != null) && isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static boolean isa_TypedefDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypedefDecl.class, From.$deref());
  }

  public static TypedefDecl cast_TypedefDecl(type$ref<?>/*P*/ From) {
    assert isa_TypedefDecl(From);
    return llvm.cast(TypedefDecl.class, From.$deref());
  }

  public static TypedefDecl cast_or_null_TypedefDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypedefDecl(From);
  }

  public static TypedefDecl dyn_cast_TypedefDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static TypedefDecl dyn_cast_or_null_TypedefDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypedefDecl(From) ? cast_TypedefDecl(From) : null;
  }

  public static boolean isa_TypedefNameDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypedefNameDecl.class, From.$star());
  }

  public static TypedefNameDecl cast_TypedefNameDecl(type$ptr<?>/*P*/ From) {
    assert isa_TypedefNameDecl(From);
    return llvm.cast(TypedefNameDecl.class, From.$star());
  }

  public static TypedefNameDecl cast_or_null_TypedefNameDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypedefNameDecl(From);
  }

  public static TypedefNameDecl dyn_cast_TypedefNameDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static TypedefNameDecl dyn_cast_or_null_TypedefNameDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static boolean isa_TypedefNameDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypedefNameDecl.class, From.$deref());
  }

  public static TypedefNameDecl cast_TypedefNameDecl(type$ref<?>/*P*/ From) {
    assert isa_TypedefNameDecl(From);
    return llvm.cast(TypedefNameDecl.class, From.$deref());
  }

  public static TypedefNameDecl cast_or_null_TypedefNameDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypedefNameDecl(From);
  }

  public static TypedefNameDecl dyn_cast_TypedefNameDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static TypedefNameDecl dyn_cast_or_null_TypedefNameDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static boolean isa_TypedefNameDecl(Decl/*P*/ From) {
    assert From != null;
    return TypedefNameDecl.classof(From);
  }

  public static TypedefNameDecl cast_TypedefNameDecl(Decl/*P*/ From) {
    assert isa_TypedefNameDecl(From);
    return (TypedefNameDecl) From;
  }

  public static TypedefNameDecl cast_or_null_TypedefNameDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_TypedefNameDecl(From);
  }

  public static TypedefNameDecl dyn_cast_TypedefNameDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static TypedefNameDecl dyn_cast_or_null_TypedefNameDecl(Decl/*P*/ From) {
    return (From != null) && isa_TypedefNameDecl(From) ? cast_TypedefNameDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingTypenameDecl(Decl/*P*/ From) {
    assert From != null;
    return UnresolvedUsingTypenameDecl.classof(From);
  }

  public static UnresolvedUsingTypenameDecl cast_UnresolvedUsingTypenameDecl(Decl/*P*/ From) {
    assert isa_UnresolvedUsingTypenameDecl(From);
    return (UnresolvedUsingTypenameDecl) From;
  }

  public static UnresolvedUsingTypenameDecl cast_or_null_UnresolvedUsingTypenameDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_UnresolvedUsingTypenameDecl(From);
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_UnresolvedUsingTypenameDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_or_null_UnresolvedUsingTypenameDecl(Decl/*P*/ From) {
    return (From != null) && isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingTypenameDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnresolvedUsingTypenameDecl.class, From.$deref());
  }

  public static UnresolvedUsingTypenameDecl cast_UnresolvedUsingTypenameDecl(type$ref<?>/*P*/ From) {
    assert isa_UnresolvedUsingTypenameDecl(From);
    return llvm.cast(UnresolvedUsingTypenameDecl.class, From.$deref());
  }

  public static UnresolvedUsingTypenameDecl cast_or_null_UnresolvedUsingTypenameDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnresolvedUsingTypenameDecl(From);
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_UnresolvedUsingTypenameDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_or_null_UnresolvedUsingTypenameDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingTypenameDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnresolvedUsingTypenameDecl.class, From.$star());
  }

  public static UnresolvedUsingTypenameDecl cast_UnresolvedUsingTypenameDecl(type$ptr<?>/*P*/ From) {
    assert isa_UnresolvedUsingTypenameDecl(From);
    return llvm.cast(UnresolvedUsingTypenameDecl.class, From.$star());
  }

  public static UnresolvedUsingTypenameDecl cast_or_null_UnresolvedUsingTypenameDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnresolvedUsingTypenameDecl(From);
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_UnresolvedUsingTypenameDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static UnresolvedUsingTypenameDecl dyn_cast_or_null_UnresolvedUsingTypenameDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnresolvedUsingTypenameDecl(From) ? cast_UnresolvedUsingTypenameDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingValueDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnresolvedUsingValueDecl.class, From.$deref());
  }

  public static UnresolvedUsingValueDecl cast_UnresolvedUsingValueDecl(type$ref<?>/*P*/ From) {
    assert isa_UnresolvedUsingValueDecl(From);
    return llvm.cast(UnresolvedUsingValueDecl.class, From.$deref());
  }

  public static UnresolvedUsingValueDecl cast_or_null_UnresolvedUsingValueDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnresolvedUsingValueDecl(From);
  }

  public static UnresolvedUsingValueDecl dyn_cast_UnresolvedUsingValueDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static UnresolvedUsingValueDecl dyn_cast_or_null_UnresolvedUsingValueDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingValueDecl(Decl/*P*/ From) {
    assert From != null;
    return UnresolvedUsingValueDecl.classof(From);
  }

  public static UnresolvedUsingValueDecl cast_UnresolvedUsingValueDecl(Decl/*P*/ From) {
    assert isa_UnresolvedUsingValueDecl(From);
    return (UnresolvedUsingValueDecl) From;
  }

  public static UnresolvedUsingValueDecl cast_or_null_UnresolvedUsingValueDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_UnresolvedUsingValueDecl(From);
  }

  public static UnresolvedUsingValueDecl dyn_cast_UnresolvedUsingValueDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static UnresolvedUsingValueDecl dyn_cast_or_null_UnresolvedUsingValueDecl(Decl/*P*/ From) {
    return (From != null) && isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static boolean isa_UnresolvedUsingValueDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnresolvedUsingValueDecl.class, From.$star());
  }

  public static UnresolvedUsingValueDecl cast_UnresolvedUsingValueDecl(type$ptr<?>/*P*/ From) {
    assert isa_UnresolvedUsingValueDecl(From);
    return llvm.cast(UnresolvedUsingValueDecl.class, From.$star());
  }

  public static UnresolvedUsingValueDecl cast_or_null_UnresolvedUsingValueDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnresolvedUsingValueDecl(From);
  }

  public static UnresolvedUsingValueDecl dyn_cast_UnresolvedUsingValueDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static UnresolvedUsingValueDecl dyn_cast_or_null_UnresolvedUsingValueDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnresolvedUsingValueDecl(From) ? cast_UnresolvedUsingValueDecl(From) : null;
  }

  public static boolean isa_UsingDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UsingDecl.class, From.$star());
  }

  public static UsingDecl cast_UsingDecl(type$ptr<?>/*P*/ From) {
    assert isa_UsingDecl(From);
    return llvm.cast(UsingDecl.class, From.$star());
  }

  public static UsingDecl cast_or_null_UsingDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UsingDecl(From);
  }

  public static UsingDecl dyn_cast_UsingDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static UsingDecl dyn_cast_or_null_UsingDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static boolean isa_UsingDecl(Decl/*P*/ From) {
    assert From != null;
    return UsingDecl.classof(From);
  }

  public static UsingDecl cast_UsingDecl(Decl/*P*/ From) {
    assert isa_UsingDecl(From);
    return (UsingDecl) From;
  }

  public static UsingDecl cast_or_null_UsingDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_UsingDecl(From);
  }

  public static UsingDecl dyn_cast_UsingDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static UsingDecl dyn_cast_or_null_UsingDecl(Decl/*P*/ From) {
    return (From != null) && isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static boolean isa_UsingDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UsingDecl.class, From.$deref());
  }

  public static UsingDecl cast_UsingDecl(type$ref<?>/*P*/ From) {
    assert isa_UsingDecl(From);
    return llvm.cast(UsingDecl.class, From.$deref());
  }

  public static UsingDecl cast_or_null_UsingDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UsingDecl(From);
  }

  public static UsingDecl dyn_cast_UsingDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static UsingDecl dyn_cast_or_null_UsingDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UsingDecl(From) ? cast_UsingDecl(From) : null;
  }

  public static boolean isa_UsingDirectiveDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UsingDirectiveDecl.class, From.$deref());
  }

  public static UsingDirectiveDecl cast_UsingDirectiveDecl(type$ref<?>/*P*/ From) {
    assert isa_UsingDirectiveDecl(From);
    return llvm.cast(UsingDirectiveDecl.class, From.$deref());
  }

  public static UsingDirectiveDecl cast_or_null_UsingDirectiveDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UsingDirectiveDecl(From);
  }

  public static UsingDirectiveDecl dyn_cast_UsingDirectiveDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static UsingDirectiveDecl dyn_cast_or_null_UsingDirectiveDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static boolean isa_UsingDirectiveDecl(Decl/*P*/ From) {
    assert From != null;
    return UsingDirectiveDecl.classof(From);
  }

  public static UsingDirectiveDecl cast_UsingDirectiveDecl(Decl/*P*/ From) {
    assert isa_UsingDirectiveDecl(From);
    return (UsingDirectiveDecl) From;
  }

  public static UsingDirectiveDecl cast_or_null_UsingDirectiveDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_UsingDirectiveDecl(From);
  }

  public static UsingDirectiveDecl dyn_cast_UsingDirectiveDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static UsingDirectiveDecl dyn_cast_or_null_UsingDirectiveDecl(Decl/*P*/ From) {
    return (From != null) && isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static boolean isa_UsingDirectiveDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UsingDirectiveDecl.class, From.$star());
  }

  public static UsingDirectiveDecl cast_UsingDirectiveDecl(type$ptr<?>/*P*/ From) {
    assert isa_UsingDirectiveDecl(From);
    return llvm.cast(UsingDirectiveDecl.class, From.$star());
  }

  public static UsingDirectiveDecl cast_or_null_UsingDirectiveDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UsingDirectiveDecl(From);
  }

  public static UsingDirectiveDecl dyn_cast_UsingDirectiveDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static UsingDirectiveDecl dyn_cast_or_null_UsingDirectiveDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UsingDirectiveDecl(From) ? cast_UsingDirectiveDecl(From) : null;
  }

  public static boolean isa_UsingShadowDecl(Decl/*P*/ From) {
    assert From != null;
    return UsingShadowDecl.classof(From);
  }

  public static UsingShadowDecl cast_UsingShadowDecl(Decl/*P*/ From) {
    assert isa_UsingShadowDecl(From);
    return (UsingShadowDecl) From;
  }

  public static UsingShadowDecl cast_or_null_UsingShadowDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_UsingShadowDecl(From);
  }

  public static UsingShadowDecl dyn_cast_UsingShadowDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static UsingShadowDecl dyn_cast_or_null_UsingShadowDecl(Decl/*P*/ From) {
    return (From != null) && isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static boolean isa_UsingShadowDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UsingShadowDecl.class, From.$deref());
  }

  public static UsingShadowDecl cast_UsingShadowDecl(type$ref<?>/*P*/ From) {
    assert isa_UsingShadowDecl(From);
    return llvm.cast(UsingShadowDecl.class, From.$deref());
  }

  public static UsingShadowDecl cast_or_null_UsingShadowDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UsingShadowDecl(From);
  }

  public static UsingShadowDecl dyn_cast_UsingShadowDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static UsingShadowDecl dyn_cast_or_null_UsingShadowDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static boolean isa_UsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UsingShadowDecl.class, From.$star());
  }

  public static UsingShadowDecl cast_UsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert isa_UsingShadowDecl(From);
    return llvm.cast(UsingShadowDecl.class, From.$star());
  }

  public static UsingShadowDecl cast_or_null_UsingShadowDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UsingShadowDecl(From);
  }

  public static UsingShadowDecl dyn_cast_UsingShadowDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static UsingShadowDecl dyn_cast_or_null_UsingShadowDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UsingShadowDecl(From) ? cast_UsingShadowDecl(From) : null;
  }

  public static boolean isa_ValueDecl(DeclContext/*P*/ From) {
    assert From != null;
    return ValueDecl.classofKind(From.getDeclKind());
  }

  public static ValueDecl cast_ValueDecl(DeclContext/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(DeclContext/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(DeclContext/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(DeclContext/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(Decl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(Decl/*P*/ From) {
    assert isa_ValueDecl(From);
    return (ValueDecl) From;
  }

  public static ValueDecl cast_or_null_ValueDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(Decl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ValueDecl.class, From.$star());
  }

  public static ValueDecl cast_ValueDecl(type$ptr<?>/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From.$star());
  }

  public static ValueDecl cast_or_null_ValueDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ValueDecl.class, From.$deref());
  }

  public static ValueDecl cast_ValueDecl(type$ref<?>/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From.$deref());
  }

  public static ValueDecl cast_or_null_ValueDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_VarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VarDecl.class, From.$deref());
  }

  public static VarDecl cast_VarDecl(type$ref<?>/*P*/ From) {
    assert isa_VarDecl(From);
    return llvm.cast(VarDecl.class, From.$deref());
  }

  public static VarDecl cast_or_null_VarDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VarDecl(From);
  }

  public static VarDecl dyn_cast_VarDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static VarDecl dyn_cast_or_null_VarDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static boolean isa_VarDecl(Decl/*P*/ From) {
    assert From != null;
    return VarDecl.classof(From);
  }

  public static VarDecl cast_VarDecl(Decl/*P*/ From) {
    assert isa_VarDecl(From);
    return (VarDecl) From;
  }

  public static VarDecl cast_or_null_VarDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_VarDecl(From);
  }

  public static VarDecl dyn_cast_VarDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static VarDecl dyn_cast_or_null_VarDecl(Decl/*P*/ From) {
    return (From != null) && isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static boolean isa_VarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VarDecl.class, From.$star());
  }

  public static VarDecl cast_VarDecl(type$ptr<?>/*P*/ From) {
    assert isa_VarDecl(From);
    return llvm.cast(VarDecl.class, From.$star());
  }

  public static VarDecl cast_or_null_VarDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VarDecl(From);
  }

  public static VarDecl dyn_cast_VarDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static VarDecl dyn_cast_or_null_VarDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VarDecl(From) ? cast_VarDecl(From) : null;
  }

  public static boolean isa_VarTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VarTemplateDecl.class, From.$star());
  }

  public static VarTemplateDecl cast_VarTemplateDecl(type$ptr<?>/*P*/ From) {
    assert isa_VarTemplateDecl(From);
    return llvm.cast(VarTemplateDecl.class, From.$star());
  }

  public static VarTemplateDecl cast_or_null_VarTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VarTemplateDecl(From);
  }

  public static VarTemplateDecl dyn_cast_VarTemplateDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static VarTemplateDecl dyn_cast_or_null_VarTemplateDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static boolean isa_VarTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VarTemplateDecl.class, From.$deref());
  }

  public static VarTemplateDecl cast_VarTemplateDecl(type$ref<?>/*P*/ From) {
    assert isa_VarTemplateDecl(From);
    return llvm.cast(VarTemplateDecl.class, From.$deref());
  }

  public static VarTemplateDecl cast_or_null_VarTemplateDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VarTemplateDecl(From);
  }

  public static VarTemplateDecl dyn_cast_VarTemplateDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static VarTemplateDecl dyn_cast_or_null_VarTemplateDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static boolean isa_VarTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return VarTemplateDecl.classof(From);
  }

  public static VarTemplateDecl cast_VarTemplateDecl(Decl/*P*/ From) {
    assert isa_VarTemplateDecl(From);
    return (VarTemplateDecl) From;
  }

  public static VarTemplateDecl cast_or_null_VarTemplateDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_VarTemplateDecl(From);
  }

  public static VarTemplateDecl dyn_cast_VarTemplateDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static VarTemplateDecl dyn_cast_or_null_VarTemplateDecl(Decl/*P*/ From) {
    return (From != null) && isa_VarTemplateDecl(From) ? cast_VarTemplateDecl(From) : null;
  }

  public static boolean isa_VarTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return VarTemplatePartialSpecializationDecl.classof(From);
  }

  public static VarTemplatePartialSpecializationDecl cast_VarTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert isa_VarTemplatePartialSpecializationDecl(From);
    return (VarTemplatePartialSpecializationDecl) From;
  }

  public static VarTemplatePartialSpecializationDecl cast_or_null_VarTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_VarTemplatePartialSpecializationDecl(From);
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_VarTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_or_null_VarTemplatePartialSpecializationDecl(Decl/*P*/ From) {
    return (From != null) && isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_VarTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VarTemplatePartialSpecializationDecl.class, From.$deref());
  }

  public static VarTemplatePartialSpecializationDecl cast_VarTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert isa_VarTemplatePartialSpecializationDecl(From);
    return llvm.cast(VarTemplatePartialSpecializationDecl.class, From.$deref());
  }

  public static VarTemplatePartialSpecializationDecl cast_or_null_VarTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VarTemplatePartialSpecializationDecl(From);
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_VarTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_or_null_VarTemplatePartialSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_VarTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VarTemplatePartialSpecializationDecl.class, From.$star());
  }

  public static VarTemplatePartialSpecializationDecl cast_VarTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert isa_VarTemplatePartialSpecializationDecl(From);
    return llvm.cast(VarTemplatePartialSpecializationDecl.class, From.$star());
  }

  public static VarTemplatePartialSpecializationDecl cast_or_null_VarTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VarTemplatePartialSpecializationDecl(From);
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_VarTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static VarTemplatePartialSpecializationDecl dyn_cast_or_null_VarTemplatePartialSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VarTemplatePartialSpecializationDecl(From) ? cast_VarTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_VarTemplateSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return VarTemplateSpecializationDecl.classof(From);
  }

  public static VarTemplateSpecializationDecl cast_VarTemplateSpecializationDecl(Decl/*P*/ From) {
    assert isa_VarTemplateSpecializationDecl(From);
    return (VarTemplateSpecializationDecl) From;
  }

  public static VarTemplateSpecializationDecl cast_or_null_VarTemplateSpecializationDecl(Decl/*P*/ From) {
    return (From == null) ? null : cast_VarTemplateSpecializationDecl(From);
  }

  public static VarTemplateSpecializationDecl dyn_cast_VarTemplateSpecializationDecl(Decl/*P*/ From) {
    assert From != null;
    return isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }

  public static VarTemplateSpecializationDecl dyn_cast_or_null_VarTemplateSpecializationDecl(Decl/*P*/ From) {
    return (From != null) && isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_VarTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VarTemplateSpecializationDecl.class, From.$deref());
  }

  public static VarTemplateSpecializationDecl cast_VarTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert isa_VarTemplateSpecializationDecl(From);
    return llvm.cast(VarTemplateSpecializationDecl.class, From.$deref());
  }

  public static VarTemplateSpecializationDecl cast_or_null_VarTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VarTemplateSpecializationDecl(From);
  }

  public static VarTemplateSpecializationDecl dyn_cast_VarTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }

  public static VarTemplateSpecializationDecl dyn_cast_or_null_VarTemplateSpecializationDecl(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_VarTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VarTemplateSpecializationDecl.class, From.$star());
  }

  public static VarTemplateSpecializationDecl cast_VarTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert isa_VarTemplateSpecializationDecl(From);
    return llvm.cast(VarTemplateSpecializationDecl.class, From.$star());
  }

  public static VarTemplateSpecializationDecl cast_or_null_VarTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VarTemplateSpecializationDecl(From);
  }

  public static VarTemplateSpecializationDecl dyn_cast_VarTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }

  public static VarTemplateSpecializationDecl dyn_cast_or_null_VarTemplateSpecializationDecl(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VarTemplateSpecializationDecl(From) ? cast_VarTemplateSpecializationDecl(From) : null;
  }
}
