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

public class AstStatementsRTTI {
  /*package*/AstStatementsRTTI() {}

  public static boolean isa_AsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AsmStmt.class, From.$deref());
  }

  public static AsmStmt cast_AsmStmt(type$ref<?>/*P*/ From) {
    assert isa_AsmStmt(From);
    return llvm.cast(AsmStmt.class, From.$deref());
  }

  public static AsmStmt cast_or_null_AsmStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AsmStmt(From);
  }

  public static AsmStmt dyn_cast_AsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static AsmStmt dyn_cast_or_null_AsmStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static boolean isa_AsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AsmStmt.class, From.$star());
  }

  public static AsmStmt cast_AsmStmt(type$ptr<?>/*P*/ From) {
    assert isa_AsmStmt(From);
    return llvm.cast(AsmStmt.class, From.$star());
  }

  public static AsmStmt cast_or_null_AsmStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AsmStmt(From);
  }

  public static AsmStmt dyn_cast_AsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static AsmStmt dyn_cast_or_null_AsmStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static boolean isa_AsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return AsmStmt.classof(From);
  }

  public static AsmStmt cast_AsmStmt(Stmt/*P*/ From) {
    assert isa_AsmStmt(From);
    return (AsmStmt) From;
  }

  public static AsmStmt cast_or_null_AsmStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AsmStmt(From);
  }

  public static AsmStmt dyn_cast_AsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static AsmStmt dyn_cast_or_null_AsmStmt(Stmt/*P*/ From) {
    return (From != null) && isa_AsmStmt(From) ? cast_AsmStmt(From) : null;
  }

  public static boolean isa_AttributedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AttributedStmt.class, From.$deref());
  }

  public static AttributedStmt cast_AttributedStmt(type$ref<?>/*P*/ From) {
    assert isa_AttributedStmt(From);
    return llvm.cast(AttributedStmt.class, From.$deref());
  }

  public static AttributedStmt cast_or_null_AttributedStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AttributedStmt(From);
  }

  public static AttributedStmt dyn_cast_AttributedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static AttributedStmt dyn_cast_or_null_AttributedStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static boolean isa_AttributedStmt(Stmt/*P*/ From) {
    assert From != null;
    return AttributedStmt.classof(From);
  }

  public static AttributedStmt cast_AttributedStmt(Stmt/*P*/ From) {
    assert isa_AttributedStmt(From);
    return (AttributedStmt) From;
  }

  public static AttributedStmt cast_or_null_AttributedStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AttributedStmt(From);
  }

  public static AttributedStmt dyn_cast_AttributedStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static AttributedStmt dyn_cast_or_null_AttributedStmt(Stmt/*P*/ From) {
    return (From != null) && isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static boolean isa_AttributedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AttributedStmt.class, From.$star());
  }

  public static AttributedStmt cast_AttributedStmt(type$ptr<?>/*P*/ From) {
    assert isa_AttributedStmt(From);
    return llvm.cast(AttributedStmt.class, From.$star());
  }

  public static AttributedStmt cast_or_null_AttributedStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AttributedStmt(From);
  }

  public static AttributedStmt dyn_cast_AttributedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static AttributedStmt dyn_cast_or_null_AttributedStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AttributedStmt(From) ? cast_AttributedStmt(From) : null;
  }

  public static boolean isa_BreakStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BreakStmt.class, From.$star());
  }

  public static BreakStmt cast_BreakStmt(type$ptr<?>/*P*/ From) {
    assert isa_BreakStmt(From);
    return llvm.cast(BreakStmt.class, From.$star());
  }

  public static BreakStmt cast_or_null_BreakStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BreakStmt(From);
  }

  public static BreakStmt dyn_cast_BreakStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static BreakStmt dyn_cast_or_null_BreakStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static boolean isa_BreakStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BreakStmt.class, From.$deref());
  }

  public static BreakStmt cast_BreakStmt(type$ref<?>/*P*/ From) {
    assert isa_BreakStmt(From);
    return llvm.cast(BreakStmt.class, From.$deref());
  }

  public static BreakStmt cast_or_null_BreakStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BreakStmt(From);
  }

  public static BreakStmt dyn_cast_BreakStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static BreakStmt dyn_cast_or_null_BreakStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static boolean isa_BreakStmt(Stmt/*P*/ From) {
    assert From != null;
    return BreakStmt.classof(From);
  }

  public static BreakStmt cast_BreakStmt(Stmt/*P*/ From) {
    assert isa_BreakStmt(From);
    return (BreakStmt) From;
  }

  public static BreakStmt cast_or_null_BreakStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_BreakStmt(From);
  }

  public static BreakStmt dyn_cast_BreakStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static BreakStmt dyn_cast_or_null_BreakStmt(Stmt/*P*/ From) {
    return (From != null) && isa_BreakStmt(From) ? cast_BreakStmt(From) : null;
  }

  public static boolean isa_CXXCatchStmt(Stmt/*P*/ From) {
    assert From != null;
    return CXXCatchStmt.classof(From);
  }

  public static CXXCatchStmt cast_CXXCatchStmt(Stmt/*P*/ From) {
    assert isa_CXXCatchStmt(From);
    return (CXXCatchStmt) From;
  }

  public static CXXCatchStmt cast_or_null_CXXCatchStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXCatchStmt(From);
  }

  public static CXXCatchStmt dyn_cast_CXXCatchStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static CXXCatchStmt dyn_cast_or_null_CXXCatchStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static boolean isa_CXXCatchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXCatchStmt.class, From.$star());
  }

  public static CXXCatchStmt cast_CXXCatchStmt(type$ptr<?>/*P*/ From) {
    assert isa_CXXCatchStmt(From);
    return llvm.cast(CXXCatchStmt.class, From.$star());
  }

  public static CXXCatchStmt cast_or_null_CXXCatchStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXCatchStmt(From);
  }

  public static CXXCatchStmt dyn_cast_CXXCatchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static CXXCatchStmt dyn_cast_or_null_CXXCatchStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static boolean isa_CXXCatchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXCatchStmt.class, From.$deref());
  }

  public static CXXCatchStmt cast_CXXCatchStmt(type$ref<?>/*P*/ From) {
    assert isa_CXXCatchStmt(From);
    return llvm.cast(CXXCatchStmt.class, From.$deref());
  }

  public static CXXCatchStmt cast_or_null_CXXCatchStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXCatchStmt(From);
  }

  public static CXXCatchStmt dyn_cast_CXXCatchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static CXXCatchStmt dyn_cast_or_null_CXXCatchStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXCatchStmt(From) ? cast_CXXCatchStmt(From) : null;
  }

  public static boolean isa_CXXForRangeStmt(Stmt/*P*/ From) {
    assert From != null;
    return CXXForRangeStmt.classof(From);
  }

  public static CXXForRangeStmt cast_CXXForRangeStmt(Stmt/*P*/ From) {
    assert isa_CXXForRangeStmt(From);
    return (CXXForRangeStmt) From;
  }

  public static CXXForRangeStmt cast_or_null_CXXForRangeStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXForRangeStmt(From);
  }

  public static CXXForRangeStmt dyn_cast_CXXForRangeStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static CXXForRangeStmt dyn_cast_or_null_CXXForRangeStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static boolean isa_CXXForRangeStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXForRangeStmt.class, From.$deref());
  }

  public static CXXForRangeStmt cast_CXXForRangeStmt(type$ref<?>/*P*/ From) {
    assert isa_CXXForRangeStmt(From);
    return llvm.cast(CXXForRangeStmt.class, From.$deref());
  }

  public static CXXForRangeStmt cast_or_null_CXXForRangeStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXForRangeStmt(From);
  }

  public static CXXForRangeStmt dyn_cast_CXXForRangeStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static CXXForRangeStmt dyn_cast_or_null_CXXForRangeStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static boolean isa_CXXForRangeStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXForRangeStmt.class, From.$star());
  }

  public static CXXForRangeStmt cast_CXXForRangeStmt(type$ptr<?>/*P*/ From) {
    assert isa_CXXForRangeStmt(From);
    return llvm.cast(CXXForRangeStmt.class, From.$star());
  }

  public static CXXForRangeStmt cast_or_null_CXXForRangeStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXForRangeStmt(From);
  }

  public static CXXForRangeStmt dyn_cast_CXXForRangeStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static CXXForRangeStmt dyn_cast_or_null_CXXForRangeStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXForRangeStmt(From) ? cast_CXXForRangeStmt(From) : null;
  }

  public static boolean isa_CXXTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return CXXTryStmt.classof(From);
  }

  public static CXXTryStmt cast_CXXTryStmt(Stmt/*P*/ From) {
    assert isa_CXXTryStmt(From);
    return (CXXTryStmt) From;
  }

  public static CXXTryStmt cast_or_null_CXXTryStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXTryStmt(From);
  }

  public static CXXTryStmt dyn_cast_CXXTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static CXXTryStmt dyn_cast_or_null_CXXTryStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static boolean isa_CXXTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXTryStmt.class, From.$star());
  }

  public static CXXTryStmt cast_CXXTryStmt(type$ptr<?>/*P*/ From) {
    assert isa_CXXTryStmt(From);
    return llvm.cast(CXXTryStmt.class, From.$star());
  }

  public static CXXTryStmt cast_or_null_CXXTryStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXTryStmt(From);
  }

  public static CXXTryStmt dyn_cast_CXXTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static CXXTryStmt dyn_cast_or_null_CXXTryStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static boolean isa_CXXTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXTryStmt.class, From.$deref());
  }

  public static CXXTryStmt cast_CXXTryStmt(type$ref<?>/*P*/ From) {
    assert isa_CXXTryStmt(From);
    return llvm.cast(CXXTryStmt.class, From.$deref());
  }

  public static CXXTryStmt cast_or_null_CXXTryStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXTryStmt(From);
  }

  public static CXXTryStmt dyn_cast_CXXTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static CXXTryStmt dyn_cast_or_null_CXXTryStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXTryStmt(From) ? cast_CXXTryStmt(From) : null;
  }

  public static boolean isa_CapturedStmt(Stmt/*P*/ From) {
    assert From != null;
    return CapturedStmt.classof(From);
  }

  public static CapturedStmt cast_CapturedStmt(Stmt/*P*/ From) {
    assert isa_CapturedStmt(From);
    return (CapturedStmt) From;
  }

  public static CapturedStmt cast_or_null_CapturedStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CapturedStmt(From);
  }

  public static CapturedStmt dyn_cast_CapturedStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static CapturedStmt dyn_cast_or_null_CapturedStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static boolean isa_CapturedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapturedStmt.class, From.$star());
  }

  public static CapturedStmt cast_CapturedStmt(type$ptr<?>/*P*/ From) {
    assert isa_CapturedStmt(From);
    return llvm.cast(CapturedStmt.class, From.$star());
  }

  public static CapturedStmt cast_or_null_CapturedStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapturedStmt(From);
  }

  public static CapturedStmt dyn_cast_CapturedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static CapturedStmt dyn_cast_or_null_CapturedStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static boolean isa_CapturedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapturedStmt.class, From.$deref());
  }

  public static CapturedStmt cast_CapturedStmt(type$ref<?>/*P*/ From) {
    assert isa_CapturedStmt(From);
    return llvm.cast(CapturedStmt.class, From.$deref());
  }

  public static CapturedStmt cast_or_null_CapturedStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapturedStmt(From);
  }

  public static CapturedStmt dyn_cast_CapturedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static CapturedStmt dyn_cast_or_null_CapturedStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapturedStmt(From) ? cast_CapturedStmt(From) : null;
  }

  public static boolean isa_CaseStmt(Stmt/*P*/ From) {
    assert From != null;
    return CaseStmt.classof(From);
  }

  public static CaseStmt cast_CaseStmt(Stmt/*P*/ From) {
    assert isa_CaseStmt(From);
    return (CaseStmt) From;
  }

  public static CaseStmt cast_or_null_CaseStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CaseStmt(From);
  }

  public static CaseStmt dyn_cast_CaseStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static CaseStmt dyn_cast_or_null_CaseStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static boolean isa_CaseStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CaseStmt.class, From.$star());
  }

  public static CaseStmt cast_CaseStmt(type$ptr<?>/*P*/ From) {
    assert isa_CaseStmt(From);
    return llvm.cast(CaseStmt.class, From.$star());
  }

  public static CaseStmt cast_or_null_CaseStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CaseStmt(From);
  }

  public static CaseStmt dyn_cast_CaseStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static CaseStmt dyn_cast_or_null_CaseStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static boolean isa_CaseStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CaseStmt.class, From.$deref());
  }

  public static CaseStmt cast_CaseStmt(type$ref<?>/*P*/ From) {
    assert isa_CaseStmt(From);
    return llvm.cast(CaseStmt.class, From.$deref());
  }

  public static CaseStmt cast_or_null_CaseStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CaseStmt(From);
  }

  public static CaseStmt dyn_cast_CaseStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static CaseStmt dyn_cast_or_null_CaseStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CaseStmt(From) ? cast_CaseStmt(From) : null;
  }

  public static boolean isa_CompoundStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompoundStmt.class, From.$deref());
  }

  public static CompoundStmt cast_CompoundStmt(type$ref<?>/*P*/ From) {
    assert isa_CompoundStmt(From);
    return llvm.cast(CompoundStmt.class, From.$deref());
  }

  public static CompoundStmt cast_or_null_CompoundStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompoundStmt(From);
  }

  public static CompoundStmt dyn_cast_CompoundStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static CompoundStmt dyn_cast_or_null_CompoundStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static boolean isa_CompoundStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompoundStmt.class, From.$star());
  }

  public static CompoundStmt cast_CompoundStmt(type$ptr<?>/*P*/ From) {
    assert isa_CompoundStmt(From);
    return llvm.cast(CompoundStmt.class, From.$star());
  }

  public static CompoundStmt cast_or_null_CompoundStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompoundStmt(From);
  }

  public static CompoundStmt dyn_cast_CompoundStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static CompoundStmt dyn_cast_or_null_CompoundStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static boolean isa_CompoundStmt(Stmt/*P*/ From) {
    assert From != null;
    return CompoundStmt.classof(From);
  }

  public static CompoundStmt cast_CompoundStmt(Stmt/*P*/ From) {
    assert isa_CompoundStmt(From);
    return (CompoundStmt) From;
  }

  public static CompoundStmt cast_or_null_CompoundStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CompoundStmt(From);
  }

  public static CompoundStmt dyn_cast_CompoundStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static CompoundStmt dyn_cast_or_null_CompoundStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CompoundStmt(From) ? cast_CompoundStmt(From) : null;
  }

  public static boolean isa_ContinueStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ContinueStmt.class, From.$deref());
  }

  public static ContinueStmt cast_ContinueStmt(type$ref<?>/*P*/ From) {
    assert isa_ContinueStmt(From);
    return llvm.cast(ContinueStmt.class, From.$deref());
  }

  public static ContinueStmt cast_or_null_ContinueStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ContinueStmt(From);
  }

  public static ContinueStmt dyn_cast_ContinueStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static ContinueStmt dyn_cast_or_null_ContinueStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static boolean isa_ContinueStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ContinueStmt.class, From.$star());
  }

  public static ContinueStmt cast_ContinueStmt(type$ptr<?>/*P*/ From) {
    assert isa_ContinueStmt(From);
    return llvm.cast(ContinueStmt.class, From.$star());
  }

  public static ContinueStmt cast_or_null_ContinueStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ContinueStmt(From);
  }

  public static ContinueStmt dyn_cast_ContinueStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static ContinueStmt dyn_cast_or_null_ContinueStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static boolean isa_ContinueStmt(Stmt/*P*/ From) {
    assert From != null;
    return ContinueStmt.classof(From);
  }

  public static ContinueStmt cast_ContinueStmt(Stmt/*P*/ From) {
    assert isa_ContinueStmt(From);
    return (ContinueStmt) From;
  }

  public static ContinueStmt cast_or_null_ContinueStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ContinueStmt(From);
  }

  public static ContinueStmt dyn_cast_ContinueStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static ContinueStmt dyn_cast_or_null_ContinueStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ContinueStmt(From) ? cast_ContinueStmt(From) : null;
  }

  public static boolean isa_CoreturnStmt(Stmt/*P*/ From) {
    assert From != null;
    return CoreturnStmt.classof(From);
  }

  public static CoreturnStmt cast_CoreturnStmt(Stmt/*P*/ From) {
    assert isa_CoreturnStmt(From);
    return (CoreturnStmt) From;
  }

  public static CoreturnStmt cast_or_null_CoreturnStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CoreturnStmt(From);
  }

  public static CoreturnStmt dyn_cast_CoreturnStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static CoreturnStmt dyn_cast_or_null_CoreturnStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static boolean isa_CoreturnStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CoreturnStmt.class, From.$deref());
  }

  public static CoreturnStmt cast_CoreturnStmt(type$ref<?>/*P*/ From) {
    assert isa_CoreturnStmt(From);
    return llvm.cast(CoreturnStmt.class, From.$deref());
  }

  public static CoreturnStmt cast_or_null_CoreturnStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CoreturnStmt(From);
  }

  public static CoreturnStmt dyn_cast_CoreturnStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static CoreturnStmt dyn_cast_or_null_CoreturnStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static boolean isa_CoreturnStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CoreturnStmt.class, From.$star());
  }

  public static CoreturnStmt cast_CoreturnStmt(type$ptr<?>/*P*/ From) {
    assert isa_CoreturnStmt(From);
    return llvm.cast(CoreturnStmt.class, From.$star());
  }

  public static CoreturnStmt cast_or_null_CoreturnStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CoreturnStmt(From);
  }

  public static CoreturnStmt dyn_cast_CoreturnStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static CoreturnStmt dyn_cast_or_null_CoreturnStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CoreturnStmt(From) ? cast_CoreturnStmt(From) : null;
  }

  public static boolean isa_CoroutineBodyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CoroutineBodyStmt.class, From.$star());
  }

  public static CoroutineBodyStmt cast_CoroutineBodyStmt(type$ptr<?>/*P*/ From) {
    assert isa_CoroutineBodyStmt(From);
    return llvm.cast(CoroutineBodyStmt.class, From.$star());
  }

  public static CoroutineBodyStmt cast_or_null_CoroutineBodyStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CoroutineBodyStmt(From);
  }

  public static CoroutineBodyStmt dyn_cast_CoroutineBodyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static CoroutineBodyStmt dyn_cast_or_null_CoroutineBodyStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static boolean isa_CoroutineBodyStmt(Stmt/*P*/ From) {
    assert From != null;
    return CoroutineBodyStmt.classof(From);
  }

  public static CoroutineBodyStmt cast_CoroutineBodyStmt(Stmt/*P*/ From) {
    assert isa_CoroutineBodyStmt(From);
    return (CoroutineBodyStmt) From;
  }

  public static CoroutineBodyStmt cast_or_null_CoroutineBodyStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CoroutineBodyStmt(From);
  }

  public static CoroutineBodyStmt dyn_cast_CoroutineBodyStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static CoroutineBodyStmt dyn_cast_or_null_CoroutineBodyStmt(Stmt/*P*/ From) {
    return (From != null) && isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static boolean isa_CoroutineBodyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CoroutineBodyStmt.class, From.$deref());
  }

  public static CoroutineBodyStmt cast_CoroutineBodyStmt(type$ref<?>/*P*/ From) {
    assert isa_CoroutineBodyStmt(From);
    return llvm.cast(CoroutineBodyStmt.class, From.$deref());
  }

  public static CoroutineBodyStmt cast_or_null_CoroutineBodyStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CoroutineBodyStmt(From);
  }

  public static CoroutineBodyStmt dyn_cast_CoroutineBodyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static CoroutineBodyStmt dyn_cast_or_null_CoroutineBodyStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CoroutineBodyStmt(From) ? cast_CoroutineBodyStmt(From) : null;
  }

  public static boolean isa_DeclStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeclStmt.class, From.$deref());
  }

  public static DeclStmt cast_DeclStmt(type$ref<?>/*P*/ From) {
    assert isa_DeclStmt(From);
    return llvm.cast(DeclStmt.class, From.$deref());
  }

  public static DeclStmt cast_or_null_DeclStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeclStmt(From);
  }

  public static DeclStmt dyn_cast_DeclStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static DeclStmt dyn_cast_or_null_DeclStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static boolean isa_DeclStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeclStmt.class, From.$star());
  }

  public static DeclStmt cast_DeclStmt(type$ptr<?>/*P*/ From) {
    assert isa_DeclStmt(From);
    return llvm.cast(DeclStmt.class, From.$star());
  }

  public static DeclStmt cast_or_null_DeclStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeclStmt(From);
  }

  public static DeclStmt dyn_cast_DeclStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static DeclStmt dyn_cast_or_null_DeclStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static boolean isa_DeclStmt(Stmt/*P*/ From) {
    assert From != null;
    return DeclStmt.classof(From);
  }

  public static DeclStmt cast_DeclStmt(Stmt/*P*/ From) {
    assert isa_DeclStmt(From);
    return (DeclStmt) From;
  }

  public static DeclStmt cast_or_null_DeclStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DeclStmt(From);
  }

  public static DeclStmt dyn_cast_DeclStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static DeclStmt dyn_cast_or_null_DeclStmt(Stmt/*P*/ From) {
    return (From != null) && isa_DeclStmt(From) ? cast_DeclStmt(From) : null;
  }

  public static boolean isa_DefaultStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DefaultStmt.class, From.$star());
  }

  public static DefaultStmt cast_DefaultStmt(type$ptr<?>/*P*/ From) {
    assert isa_DefaultStmt(From);
    return llvm.cast(DefaultStmt.class, From.$star());
  }

  public static DefaultStmt cast_or_null_DefaultStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DefaultStmt(From);
  }

  public static DefaultStmt dyn_cast_DefaultStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static DefaultStmt dyn_cast_or_null_DefaultStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static boolean isa_DefaultStmt(Stmt/*P*/ From) {
    assert From != null;
    return DefaultStmt.classof(From);
  }

  public static DefaultStmt cast_DefaultStmt(Stmt/*P*/ From) {
    assert isa_DefaultStmt(From);
    return (DefaultStmt) From;
  }

  public static DefaultStmt cast_or_null_DefaultStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DefaultStmt(From);
  }

  public static DefaultStmt dyn_cast_DefaultStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static DefaultStmt dyn_cast_or_null_DefaultStmt(Stmt/*P*/ From) {
    return (From != null) && isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static boolean isa_DefaultStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DefaultStmt.class, From.$deref());
  }

  public static DefaultStmt cast_DefaultStmt(type$ref<?>/*P*/ From) {
    assert isa_DefaultStmt(From);
    return llvm.cast(DefaultStmt.class, From.$deref());
  }

  public static DefaultStmt cast_or_null_DefaultStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DefaultStmt(From);
  }

  public static DefaultStmt dyn_cast_DefaultStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static DefaultStmt dyn_cast_or_null_DefaultStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DefaultStmt(From) ? cast_DefaultStmt(From) : null;
  }

  public static boolean isa_DoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DoStmt.class, From.$star());
  }

  public static DoStmt cast_DoStmt(type$ptr<?>/*P*/ From) {
    assert isa_DoStmt(From);
    return llvm.cast(DoStmt.class, From.$star());
  }

  public static DoStmt cast_or_null_DoStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DoStmt(From);
  }

  public static DoStmt dyn_cast_DoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static DoStmt dyn_cast_or_null_DoStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static boolean isa_DoStmt(Stmt/*P*/ From) {
    assert From != null;
    return DoStmt.classof(From);
  }

  public static DoStmt cast_DoStmt(Stmt/*P*/ From) {
    assert isa_DoStmt(From);
    return (DoStmt) From;
  }

  public static DoStmt cast_or_null_DoStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DoStmt(From);
  }

  public static DoStmt dyn_cast_DoStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static DoStmt dyn_cast_or_null_DoStmt(Stmt/*P*/ From) {
    return (From != null) && isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static boolean isa_DoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DoStmt.class, From.$deref());
  }

  public static DoStmt cast_DoStmt(type$ref<?>/*P*/ From) {
    assert isa_DoStmt(From);
    return llvm.cast(DoStmt.class, From.$deref());
  }

  public static DoStmt cast_or_null_DoStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DoStmt(From);
  }

  public static DoStmt dyn_cast_DoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static DoStmt dyn_cast_or_null_DoStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DoStmt(From) ? cast_DoStmt(From) : null;
  }

  public static boolean isa_ForStmt(Stmt/*P*/ From) {
    assert From != null;
    return ForStmt.classof(From);
  }

  public static ForStmt cast_ForStmt(Stmt/*P*/ From) {
    assert isa_ForStmt(From);
    return (ForStmt) From;
  }

  public static ForStmt cast_or_null_ForStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ForStmt(From);
  }

  public static ForStmt dyn_cast_ForStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static ForStmt dyn_cast_or_null_ForStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static boolean isa_ForStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ForStmt.class, From.$deref());
  }

  public static ForStmt cast_ForStmt(type$ref<?>/*P*/ From) {
    assert isa_ForStmt(From);
    return llvm.cast(ForStmt.class, From.$deref());
  }

  public static ForStmt cast_or_null_ForStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ForStmt(From);
  }

  public static ForStmt dyn_cast_ForStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static ForStmt dyn_cast_or_null_ForStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static boolean isa_ForStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ForStmt.class, From.$star());
  }

  public static ForStmt cast_ForStmt(type$ptr<?>/*P*/ From) {
    assert isa_ForStmt(From);
    return llvm.cast(ForStmt.class, From.$star());
  }

  public static ForStmt cast_or_null_ForStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ForStmt(From);
  }

  public static ForStmt dyn_cast_ForStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static ForStmt dyn_cast_or_null_ForStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ForStmt(From) ? cast_ForStmt(From) : null;
  }

  public static boolean isa_GCCAsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return GCCAsmStmt.classof(From);
  }

  public static GCCAsmStmt cast_GCCAsmStmt(Stmt/*P*/ From) {
    assert isa_GCCAsmStmt(From);
    return (GCCAsmStmt) From;
  }

  public static GCCAsmStmt cast_or_null_GCCAsmStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_GCCAsmStmt(From);
  }

  public static GCCAsmStmt dyn_cast_GCCAsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static GCCAsmStmt dyn_cast_or_null_GCCAsmStmt(Stmt/*P*/ From) {
    return (From != null) && isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static boolean isa_GCCAsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GCCAsmStmt.class, From.$star());
  }

  public static GCCAsmStmt cast_GCCAsmStmt(type$ptr<?>/*P*/ From) {
    assert isa_GCCAsmStmt(From);
    return llvm.cast(GCCAsmStmt.class, From.$star());
  }

  public static GCCAsmStmt cast_or_null_GCCAsmStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GCCAsmStmt(From);
  }

  public static GCCAsmStmt dyn_cast_GCCAsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static GCCAsmStmt dyn_cast_or_null_GCCAsmStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static boolean isa_GCCAsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GCCAsmStmt.class, From.$deref());
  }

  public static GCCAsmStmt cast_GCCAsmStmt(type$ref<?>/*P*/ From) {
    assert isa_GCCAsmStmt(From);
    return llvm.cast(GCCAsmStmt.class, From.$deref());
  }

  public static GCCAsmStmt cast_or_null_GCCAsmStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GCCAsmStmt(From);
  }

  public static GCCAsmStmt dyn_cast_GCCAsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static GCCAsmStmt dyn_cast_or_null_GCCAsmStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GCCAsmStmt(From) ? cast_GCCAsmStmt(From) : null;
  }

  public static boolean isa_GotoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GotoStmt.class, From.$deref());
  }

  public static GotoStmt cast_GotoStmt(type$ref<?>/*P*/ From) {
    assert isa_GotoStmt(From);
    return llvm.cast(GotoStmt.class, From.$deref());
  }

  public static GotoStmt cast_or_null_GotoStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GotoStmt(From);
  }

  public static GotoStmt dyn_cast_GotoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static GotoStmt dyn_cast_or_null_GotoStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static boolean isa_GotoStmt(Stmt/*P*/ From) {
    assert From != null;
    return GotoStmt.classof(From);
  }

  public static GotoStmt cast_GotoStmt(Stmt/*P*/ From) {
    assert isa_GotoStmt(From);
    return (GotoStmt) From;
  }

  public static GotoStmt cast_or_null_GotoStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_GotoStmt(From);
  }

  public static GotoStmt dyn_cast_GotoStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static GotoStmt dyn_cast_or_null_GotoStmt(Stmt/*P*/ From) {
    return (From != null) && isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static boolean isa_GotoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GotoStmt.class, From.$star());
  }

  public static GotoStmt cast_GotoStmt(type$ptr<?>/*P*/ From) {
    assert isa_GotoStmt(From);
    return llvm.cast(GotoStmt.class, From.$star());
  }

  public static GotoStmt cast_or_null_GotoStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GotoStmt(From);
  }

  public static GotoStmt dyn_cast_GotoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static GotoStmt dyn_cast_or_null_GotoStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GotoStmt(From) ? cast_GotoStmt(From) : null;
  }

  public static boolean isa_IfStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IfStmt.class, From.$deref());
  }

  public static IfStmt cast_IfStmt(type$ref<?>/*P*/ From) {
    assert isa_IfStmt(From);
    return llvm.cast(IfStmt.class, From.$deref());
  }

  public static IfStmt cast_or_null_IfStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IfStmt(From);
  }

  public static IfStmt dyn_cast_IfStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static IfStmt dyn_cast_or_null_IfStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static boolean isa_IfStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IfStmt.class, From.$star());
  }

  public static IfStmt cast_IfStmt(type$ptr<?>/*P*/ From) {
    assert isa_IfStmt(From);
    return llvm.cast(IfStmt.class, From.$star());
  }

  public static IfStmt cast_or_null_IfStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IfStmt(From);
  }

  public static IfStmt dyn_cast_IfStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static IfStmt dyn_cast_or_null_IfStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static boolean isa_IfStmt(Stmt/*P*/ From) {
    assert From != null;
    return IfStmt.classof(From);
  }

  public static IfStmt cast_IfStmt(Stmt/*P*/ From) {
    assert isa_IfStmt(From);
    return (IfStmt) From;
  }

  public static IfStmt cast_or_null_IfStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_IfStmt(From);
  }

  public static IfStmt dyn_cast_IfStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static IfStmt dyn_cast_or_null_IfStmt(Stmt/*P*/ From) {
    return (From != null) && isa_IfStmt(From) ? cast_IfStmt(From) : null;
  }

  public static boolean isa_IndirectGotoStmt(Stmt/*P*/ From) {
    assert From != null;
    return IndirectGotoStmt.classof(From);
  }

  public static IndirectGotoStmt cast_IndirectGotoStmt(Stmt/*P*/ From) {
    assert isa_IndirectGotoStmt(From);
    return (IndirectGotoStmt) From;
  }

  public static IndirectGotoStmt cast_or_null_IndirectGotoStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_IndirectGotoStmt(From);
  }

  public static IndirectGotoStmt dyn_cast_IndirectGotoStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static IndirectGotoStmt dyn_cast_or_null_IndirectGotoStmt(Stmt/*P*/ From) {
    return (From != null) && isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static boolean isa_IndirectGotoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IndirectGotoStmt.class, From.$deref());
  }

  public static IndirectGotoStmt cast_IndirectGotoStmt(type$ref<?>/*P*/ From) {
    assert isa_IndirectGotoStmt(From);
    return llvm.cast(IndirectGotoStmt.class, From.$deref());
  }

  public static IndirectGotoStmt cast_or_null_IndirectGotoStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IndirectGotoStmt(From);
  }

  public static IndirectGotoStmt dyn_cast_IndirectGotoStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static IndirectGotoStmt dyn_cast_or_null_IndirectGotoStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static boolean isa_IndirectGotoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IndirectGotoStmt.class, From.$star());
  }

  public static IndirectGotoStmt cast_IndirectGotoStmt(type$ptr<?>/*P*/ From) {
    assert isa_IndirectGotoStmt(From);
    return llvm.cast(IndirectGotoStmt.class, From.$star());
  }

  public static IndirectGotoStmt cast_or_null_IndirectGotoStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IndirectGotoStmt(From);
  }

  public static IndirectGotoStmt dyn_cast_IndirectGotoStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static IndirectGotoStmt dyn_cast_or_null_IndirectGotoStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IndirectGotoStmt(From) ? cast_IndirectGotoStmt(From) : null;
  }

  public static boolean isa_LabelStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LabelStmt.class, From.$star());
  }

  public static LabelStmt cast_LabelStmt(type$ptr<?>/*P*/ From) {
    assert isa_LabelStmt(From);
    return llvm.cast(LabelStmt.class, From.$star());
  }

  public static LabelStmt cast_or_null_LabelStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LabelStmt(From);
  }

  public static LabelStmt dyn_cast_LabelStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static LabelStmt dyn_cast_or_null_LabelStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static boolean isa_LabelStmt(Stmt/*P*/ From) {
    assert From != null;
    return LabelStmt.classof(From);
  }

  public static LabelStmt cast_LabelStmt(Stmt/*P*/ From) {
    assert isa_LabelStmt(From);
    return (LabelStmt) From;
  }

  public static LabelStmt cast_or_null_LabelStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_LabelStmt(From);
  }

  public static LabelStmt dyn_cast_LabelStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static LabelStmt dyn_cast_or_null_LabelStmt(Stmt/*P*/ From) {
    return (From != null) && isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static boolean isa_LabelStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LabelStmt.class, From.$deref());
  }

  public static LabelStmt cast_LabelStmt(type$ref<?>/*P*/ From) {
    assert isa_LabelStmt(From);
    return llvm.cast(LabelStmt.class, From.$deref());
  }

  public static LabelStmt cast_or_null_LabelStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LabelStmt(From);
  }

  public static LabelStmt dyn_cast_LabelStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static LabelStmt dyn_cast_or_null_LabelStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LabelStmt(From) ? cast_LabelStmt(From) : null;
  }

  public static boolean isa_MSAsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSAsmStmt.class, From.$deref());
  }

  public static MSAsmStmt cast_MSAsmStmt(type$ref<?>/*P*/ From) {
    assert isa_MSAsmStmt(From);
    return llvm.cast(MSAsmStmt.class, From.$deref());
  }

  public static MSAsmStmt cast_or_null_MSAsmStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSAsmStmt(From);
  }

  public static MSAsmStmt dyn_cast_MSAsmStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static MSAsmStmt dyn_cast_or_null_MSAsmStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static boolean isa_MSAsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSAsmStmt.class, From.$star());
  }

  public static MSAsmStmt cast_MSAsmStmt(type$ptr<?>/*P*/ From) {
    assert isa_MSAsmStmt(From);
    return llvm.cast(MSAsmStmt.class, From.$star());
  }

  public static MSAsmStmt cast_or_null_MSAsmStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSAsmStmt(From);
  }

  public static MSAsmStmt dyn_cast_MSAsmStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static MSAsmStmt dyn_cast_or_null_MSAsmStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static boolean isa_MSAsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return MSAsmStmt.classof(From);
  }

  public static MSAsmStmt cast_MSAsmStmt(Stmt/*P*/ From) {
    assert isa_MSAsmStmt(From);
    return (MSAsmStmt) From;
  }

  public static MSAsmStmt cast_or_null_MSAsmStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MSAsmStmt(From);
  }

  public static MSAsmStmt dyn_cast_MSAsmStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static MSAsmStmt dyn_cast_or_null_MSAsmStmt(Stmt/*P*/ From) {
    return (From != null) && isa_MSAsmStmt(From) ? cast_MSAsmStmt(From) : null;
  }

  public static boolean isa_MSDependentExistsStmt(Stmt/*P*/ From) {
    assert From != null;
    return MSDependentExistsStmt.classof(From);
  }

  public static MSDependentExistsStmt cast_MSDependentExistsStmt(Stmt/*P*/ From) {
    assert isa_MSDependentExistsStmt(From);
    return (MSDependentExistsStmt) From;
  }

  public static MSDependentExistsStmt cast_or_null_MSDependentExistsStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MSDependentExistsStmt(From);
  }

  public static MSDependentExistsStmt dyn_cast_MSDependentExistsStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static MSDependentExistsStmt dyn_cast_or_null_MSDependentExistsStmt(Stmt/*P*/ From) {
    return (From != null) && isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static boolean isa_MSDependentExistsStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSDependentExistsStmt.class, From.$star());
  }

  public static MSDependentExistsStmt cast_MSDependentExistsStmt(type$ptr<?>/*P*/ From) {
    assert isa_MSDependentExistsStmt(From);
    return llvm.cast(MSDependentExistsStmt.class, From.$star());
  }

  public static MSDependentExistsStmt cast_or_null_MSDependentExistsStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSDependentExistsStmt(From);
  }

  public static MSDependentExistsStmt dyn_cast_MSDependentExistsStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static MSDependentExistsStmt dyn_cast_or_null_MSDependentExistsStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static boolean isa_MSDependentExistsStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSDependentExistsStmt.class, From.$deref());
  }

  public static MSDependentExistsStmt cast_MSDependentExistsStmt(type$ref<?>/*P*/ From) {
    assert isa_MSDependentExistsStmt(From);
    return llvm.cast(MSDependentExistsStmt.class, From.$deref());
  }

  public static MSDependentExistsStmt cast_or_null_MSDependentExistsStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSDependentExistsStmt(From);
  }

  public static MSDependentExistsStmt dyn_cast_MSDependentExistsStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static MSDependentExistsStmt dyn_cast_or_null_MSDependentExistsStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSDependentExistsStmt(From) ? cast_MSDependentExistsStmt(From) : null;
  }

  public static boolean isa_NullStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NullStmt.class, From.$star());
  }

  public static NullStmt cast_NullStmt(type$ptr<?>/*P*/ From) {
    assert isa_NullStmt(From);
    return llvm.cast(NullStmt.class, From.$star());
  }

  public static NullStmt cast_or_null_NullStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NullStmt(From);
  }

  public static NullStmt dyn_cast_NullStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static NullStmt dyn_cast_or_null_NullStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static boolean isa_NullStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NullStmt.class, From.$deref());
  }

  public static NullStmt cast_NullStmt(type$ref<?>/*P*/ From) {
    assert isa_NullStmt(From);
    return llvm.cast(NullStmt.class, From.$deref());
  }

  public static NullStmt cast_or_null_NullStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NullStmt(From);
  }

  public static NullStmt dyn_cast_NullStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static NullStmt dyn_cast_or_null_NullStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static boolean isa_NullStmt(Stmt/*P*/ From) {
    assert From != null;
    return NullStmt.classof(From);
  }

  public static NullStmt cast_NullStmt(Stmt/*P*/ From) {
    assert isa_NullStmt(From);
    return (NullStmt) From;
  }

  public static NullStmt cast_or_null_NullStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_NullStmt(From);
  }

  public static NullStmt dyn_cast_NullStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static NullStmt dyn_cast_or_null_NullStmt(Stmt/*P*/ From) {
    return (From != null) && isa_NullStmt(From) ? cast_NullStmt(From) : null;
  }

  public static boolean isa_ObjCAtCatchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtCatchStmt.class, From.$deref());
  }

  public static ObjCAtCatchStmt cast_ObjCAtCatchStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtCatchStmt(From);
    return llvm.cast(ObjCAtCatchStmt.class, From.$deref());
  }

  public static ObjCAtCatchStmt cast_or_null_ObjCAtCatchStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtCatchStmt(From);
  }

  public static ObjCAtCatchStmt dyn_cast_ObjCAtCatchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static ObjCAtCatchStmt dyn_cast_or_null_ObjCAtCatchStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static boolean isa_ObjCAtCatchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtCatchStmt.class, From.$star());
  }

  public static ObjCAtCatchStmt cast_ObjCAtCatchStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtCatchStmt(From);
    return llvm.cast(ObjCAtCatchStmt.class, From.$star());
  }

  public static ObjCAtCatchStmt cast_or_null_ObjCAtCatchStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtCatchStmt(From);
  }

  public static ObjCAtCatchStmt dyn_cast_ObjCAtCatchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static ObjCAtCatchStmt dyn_cast_or_null_ObjCAtCatchStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static boolean isa_ObjCAtCatchStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAtCatchStmt.classof(From);
  }

  public static ObjCAtCatchStmt cast_ObjCAtCatchStmt(Stmt/*P*/ From) {
    assert isa_ObjCAtCatchStmt(From);
    return (ObjCAtCatchStmt) From;
  }

  public static ObjCAtCatchStmt cast_or_null_ObjCAtCatchStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtCatchStmt(From);
  }

  public static ObjCAtCatchStmt dyn_cast_ObjCAtCatchStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static ObjCAtCatchStmt dyn_cast_or_null_ObjCAtCatchStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAtCatchStmt(From) ? cast_ObjCAtCatchStmt(From) : null;
  }

  public static boolean isa_ObjCAtFinallyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtFinallyStmt.class, From.$deref());
  }

  public static ObjCAtFinallyStmt cast_ObjCAtFinallyStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtFinallyStmt(From);
    return llvm.cast(ObjCAtFinallyStmt.class, From.$deref());
  }

  public static ObjCAtFinallyStmt cast_or_null_ObjCAtFinallyStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtFinallyStmt(From);
  }

  public static ObjCAtFinallyStmt dyn_cast_ObjCAtFinallyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static ObjCAtFinallyStmt dyn_cast_or_null_ObjCAtFinallyStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static boolean isa_ObjCAtFinallyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtFinallyStmt.class, From.$star());
  }

  public static ObjCAtFinallyStmt cast_ObjCAtFinallyStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtFinallyStmt(From);
    return llvm.cast(ObjCAtFinallyStmt.class, From.$star());
  }

  public static ObjCAtFinallyStmt cast_or_null_ObjCAtFinallyStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtFinallyStmt(From);
  }

  public static ObjCAtFinallyStmt dyn_cast_ObjCAtFinallyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static ObjCAtFinallyStmt dyn_cast_or_null_ObjCAtFinallyStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static boolean isa_ObjCAtFinallyStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAtFinallyStmt.classof(From);
  }

  public static ObjCAtFinallyStmt cast_ObjCAtFinallyStmt(Stmt/*P*/ From) {
    assert isa_ObjCAtFinallyStmt(From);
    return (ObjCAtFinallyStmt) From;
  }

  public static ObjCAtFinallyStmt cast_or_null_ObjCAtFinallyStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtFinallyStmt(From);
  }

  public static ObjCAtFinallyStmt dyn_cast_ObjCAtFinallyStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static ObjCAtFinallyStmt dyn_cast_or_null_ObjCAtFinallyStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAtFinallyStmt(From) ? cast_ObjCAtFinallyStmt(From) : null;
  }

  public static boolean isa_ObjCAtSynchronizedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtSynchronizedStmt.class, From.$star());
  }

  public static ObjCAtSynchronizedStmt cast_ObjCAtSynchronizedStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtSynchronizedStmt(From);
    return llvm.cast(ObjCAtSynchronizedStmt.class, From.$star());
  }

  public static ObjCAtSynchronizedStmt cast_or_null_ObjCAtSynchronizedStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtSynchronizedStmt(From);
  }

  public static ObjCAtSynchronizedStmt dyn_cast_ObjCAtSynchronizedStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static ObjCAtSynchronizedStmt dyn_cast_or_null_ObjCAtSynchronizedStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static boolean isa_ObjCAtSynchronizedStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAtSynchronizedStmt.classof(From);
  }

  public static ObjCAtSynchronizedStmt cast_ObjCAtSynchronizedStmt(Stmt/*P*/ From) {
    assert isa_ObjCAtSynchronizedStmt(From);
    return (ObjCAtSynchronizedStmt) From;
  }

  public static ObjCAtSynchronizedStmt cast_or_null_ObjCAtSynchronizedStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtSynchronizedStmt(From);
  }

  public static ObjCAtSynchronizedStmt dyn_cast_ObjCAtSynchronizedStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static ObjCAtSynchronizedStmt dyn_cast_or_null_ObjCAtSynchronizedStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static boolean isa_ObjCAtSynchronizedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtSynchronizedStmt.class, From.$deref());
  }

  public static ObjCAtSynchronizedStmt cast_ObjCAtSynchronizedStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtSynchronizedStmt(From);
    return llvm.cast(ObjCAtSynchronizedStmt.class, From.$deref());
  }

  public static ObjCAtSynchronizedStmt cast_or_null_ObjCAtSynchronizedStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtSynchronizedStmt(From);
  }

  public static ObjCAtSynchronizedStmt dyn_cast_ObjCAtSynchronizedStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static ObjCAtSynchronizedStmt dyn_cast_or_null_ObjCAtSynchronizedStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtSynchronizedStmt(From) ? cast_ObjCAtSynchronizedStmt(From) : null;
  }

  public static boolean isa_ObjCAtThrowStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAtThrowStmt.classof(From);
  }

  public static ObjCAtThrowStmt cast_ObjCAtThrowStmt(Stmt/*P*/ From) {
    assert isa_ObjCAtThrowStmt(From);
    return (ObjCAtThrowStmt) From;
  }

  public static ObjCAtThrowStmt cast_or_null_ObjCAtThrowStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtThrowStmt(From);
  }

  public static ObjCAtThrowStmt dyn_cast_ObjCAtThrowStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static ObjCAtThrowStmt dyn_cast_or_null_ObjCAtThrowStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static boolean isa_ObjCAtThrowStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtThrowStmt.class, From.$deref());
  }

  public static ObjCAtThrowStmt cast_ObjCAtThrowStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtThrowStmt(From);
    return llvm.cast(ObjCAtThrowStmt.class, From.$deref());
  }

  public static ObjCAtThrowStmt cast_or_null_ObjCAtThrowStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtThrowStmt(From);
  }

  public static ObjCAtThrowStmt dyn_cast_ObjCAtThrowStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static ObjCAtThrowStmt dyn_cast_or_null_ObjCAtThrowStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static boolean isa_ObjCAtThrowStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtThrowStmt.class, From.$star());
  }

  public static ObjCAtThrowStmt cast_ObjCAtThrowStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtThrowStmt(From);
    return llvm.cast(ObjCAtThrowStmt.class, From.$star());
  }

  public static ObjCAtThrowStmt cast_or_null_ObjCAtThrowStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtThrowStmt(From);
  }

  public static ObjCAtThrowStmt dyn_cast_ObjCAtThrowStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static ObjCAtThrowStmt dyn_cast_or_null_ObjCAtThrowStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtThrowStmt(From) ? cast_ObjCAtThrowStmt(From) : null;
  }

  public static boolean isa_ObjCAtTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAtTryStmt.class, From.$deref());
  }

  public static ObjCAtTryStmt cast_ObjCAtTryStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAtTryStmt(From);
    return llvm.cast(ObjCAtTryStmt.class, From.$deref());
  }

  public static ObjCAtTryStmt cast_or_null_ObjCAtTryStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAtTryStmt(From);
  }

  public static ObjCAtTryStmt dyn_cast_ObjCAtTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static ObjCAtTryStmt dyn_cast_or_null_ObjCAtTryStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static boolean isa_ObjCAtTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAtTryStmt.classof(From);
  }

  public static ObjCAtTryStmt cast_ObjCAtTryStmt(Stmt/*P*/ From) {
    assert isa_ObjCAtTryStmt(From);
    return (ObjCAtTryStmt) From;
  }

  public static ObjCAtTryStmt cast_or_null_ObjCAtTryStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAtTryStmt(From);
  }

  public static ObjCAtTryStmt dyn_cast_ObjCAtTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static ObjCAtTryStmt dyn_cast_or_null_ObjCAtTryStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static boolean isa_ObjCAtTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAtTryStmt.class, From.$star());
  }

  public static ObjCAtTryStmt cast_ObjCAtTryStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAtTryStmt(From);
    return llvm.cast(ObjCAtTryStmt.class, From.$star());
  }

  public static ObjCAtTryStmt cast_or_null_ObjCAtTryStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAtTryStmt(From);
  }

  public static ObjCAtTryStmt dyn_cast_ObjCAtTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static ObjCAtTryStmt dyn_cast_or_null_ObjCAtTryStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAtTryStmt(From) ? cast_ObjCAtTryStmt(From) : null;
  }

  public static boolean isa_ObjCAutoreleasePoolStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAutoreleasePoolStmt.class, From.$deref());
  }

  public static ObjCAutoreleasePoolStmt cast_ObjCAutoreleasePoolStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCAutoreleasePoolStmt(From);
    return llvm.cast(ObjCAutoreleasePoolStmt.class, From.$deref());
  }

  public static ObjCAutoreleasePoolStmt cast_or_null_ObjCAutoreleasePoolStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAutoreleasePoolStmt(From);
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_ObjCAutoreleasePoolStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_or_null_ObjCAutoreleasePoolStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static boolean isa_ObjCAutoreleasePoolStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAutoreleasePoolStmt.classof(From);
  }

  public static ObjCAutoreleasePoolStmt cast_ObjCAutoreleasePoolStmt(Stmt/*P*/ From) {
    assert isa_ObjCAutoreleasePoolStmt(From);
    return (ObjCAutoreleasePoolStmt) From;
  }

  public static ObjCAutoreleasePoolStmt cast_or_null_ObjCAutoreleasePoolStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAutoreleasePoolStmt(From);
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_ObjCAutoreleasePoolStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_or_null_ObjCAutoreleasePoolStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static boolean isa_ObjCAutoreleasePoolStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAutoreleasePoolStmt.class, From.$star());
  }

  public static ObjCAutoreleasePoolStmt cast_ObjCAutoreleasePoolStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAutoreleasePoolStmt(From);
    return llvm.cast(ObjCAutoreleasePoolStmt.class, From.$star());
  }

  public static ObjCAutoreleasePoolStmt cast_or_null_ObjCAutoreleasePoolStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAutoreleasePoolStmt(From);
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_ObjCAutoreleasePoolStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static ObjCAutoreleasePoolStmt dyn_cast_or_null_ObjCAutoreleasePoolStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAutoreleasePoolStmt(From) ? cast_ObjCAutoreleasePoolStmt(From) : null;
  }

  public static boolean isa_ObjCForCollectionStmt(Stmt/*P*/ From) {
    assert From != null;
    return ObjCForCollectionStmt.classof(From);
  }

  public static ObjCForCollectionStmt cast_ObjCForCollectionStmt(Stmt/*P*/ From) {
    assert isa_ObjCForCollectionStmt(From);
    return (ObjCForCollectionStmt) From;
  }

  public static ObjCForCollectionStmt cast_or_null_ObjCForCollectionStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCForCollectionStmt(From);
  }

  public static ObjCForCollectionStmt dyn_cast_ObjCForCollectionStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static ObjCForCollectionStmt dyn_cast_or_null_ObjCForCollectionStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static boolean isa_ObjCForCollectionStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCForCollectionStmt.class, From.$deref());
  }

  public static ObjCForCollectionStmt cast_ObjCForCollectionStmt(type$ref<?>/*P*/ From) {
    assert isa_ObjCForCollectionStmt(From);
    return llvm.cast(ObjCForCollectionStmt.class, From.$deref());
  }

  public static ObjCForCollectionStmt cast_or_null_ObjCForCollectionStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCForCollectionStmt(From);
  }

  public static ObjCForCollectionStmt dyn_cast_ObjCForCollectionStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static ObjCForCollectionStmt dyn_cast_or_null_ObjCForCollectionStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static boolean isa_ObjCForCollectionStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCForCollectionStmt.class, From.$star());
  }

  public static ObjCForCollectionStmt cast_ObjCForCollectionStmt(type$ptr<?>/*P*/ From) {
    assert isa_ObjCForCollectionStmt(From);
    return llvm.cast(ObjCForCollectionStmt.class, From.$star());
  }

  public static ObjCForCollectionStmt cast_or_null_ObjCForCollectionStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCForCollectionStmt(From);
  }

  public static ObjCForCollectionStmt dyn_cast_ObjCForCollectionStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static ObjCForCollectionStmt dyn_cast_or_null_ObjCForCollectionStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCForCollectionStmt(From) ? cast_ObjCForCollectionStmt(From) : null;
  }

  public static boolean isa_ReturnStmt(Stmt/*P*/ From) {
    assert From != null;
    return ReturnStmt.classof(From);
  }

  public static ReturnStmt cast_ReturnStmt(Stmt/*P*/ From) {
    assert isa_ReturnStmt(From);
    return (ReturnStmt) From;
  }

  public static ReturnStmt cast_or_null_ReturnStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ReturnStmt(From);
  }

  public static ReturnStmt dyn_cast_ReturnStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static ReturnStmt dyn_cast_or_null_ReturnStmt(Stmt/*P*/ From) {
    return (From != null) && isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static boolean isa_ReturnStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReturnStmt.class, From.$star());
  }

  public static ReturnStmt cast_ReturnStmt(type$ptr<?>/*P*/ From) {
    assert isa_ReturnStmt(From);
    return llvm.cast(ReturnStmt.class, From.$star());
  }

  public static ReturnStmt cast_or_null_ReturnStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReturnStmt(From);
  }

  public static ReturnStmt dyn_cast_ReturnStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static ReturnStmt dyn_cast_or_null_ReturnStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static boolean isa_ReturnStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReturnStmt.class, From.$deref());
  }

  public static ReturnStmt cast_ReturnStmt(type$ref<?>/*P*/ From) {
    assert isa_ReturnStmt(From);
    return llvm.cast(ReturnStmt.class, From.$deref());
  }

  public static ReturnStmt cast_or_null_ReturnStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReturnStmt(From);
  }

  public static ReturnStmt dyn_cast_ReturnStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static ReturnStmt dyn_cast_or_null_ReturnStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReturnStmt(From) ? cast_ReturnStmt(From) : null;
  }

  public static boolean isa_SEHExceptStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SEHExceptStmt.class, From.$deref());
  }

  public static SEHExceptStmt cast_SEHExceptStmt(type$ref<?>/*P*/ From) {
    assert isa_SEHExceptStmt(From);
    return llvm.cast(SEHExceptStmt.class, From.$deref());
  }

  public static SEHExceptStmt cast_or_null_SEHExceptStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SEHExceptStmt(From);
  }

  public static SEHExceptStmt dyn_cast_SEHExceptStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static SEHExceptStmt dyn_cast_or_null_SEHExceptStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static boolean isa_SEHExceptStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SEHExceptStmt.class, From.$star());
  }

  public static SEHExceptStmt cast_SEHExceptStmt(type$ptr<?>/*P*/ From) {
    assert isa_SEHExceptStmt(From);
    return llvm.cast(SEHExceptStmt.class, From.$star());
  }

  public static SEHExceptStmt cast_or_null_SEHExceptStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SEHExceptStmt(From);
  }

  public static SEHExceptStmt dyn_cast_SEHExceptStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static SEHExceptStmt dyn_cast_or_null_SEHExceptStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static boolean isa_SEHExceptStmt(Stmt/*P*/ From) {
    assert From != null;
    return SEHExceptStmt.classof(From);
  }

  public static SEHExceptStmt cast_SEHExceptStmt(Stmt/*P*/ From) {
    assert isa_SEHExceptStmt(From);
    return (SEHExceptStmt) From;
  }

  public static SEHExceptStmt cast_or_null_SEHExceptStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SEHExceptStmt(From);
  }

  public static SEHExceptStmt dyn_cast_SEHExceptStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static SEHExceptStmt dyn_cast_or_null_SEHExceptStmt(Stmt/*P*/ From) {
    return (From != null) && isa_SEHExceptStmt(From) ? cast_SEHExceptStmt(From) : null;
  }

  public static boolean isa_SEHFinallyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SEHFinallyStmt.class, From.$star());
  }

  public static SEHFinallyStmt cast_SEHFinallyStmt(type$ptr<?>/*P*/ From) {
    assert isa_SEHFinallyStmt(From);
    return llvm.cast(SEHFinallyStmt.class, From.$star());
  }

  public static SEHFinallyStmt cast_or_null_SEHFinallyStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SEHFinallyStmt(From);
  }

  public static SEHFinallyStmt dyn_cast_SEHFinallyStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static SEHFinallyStmt dyn_cast_or_null_SEHFinallyStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static boolean isa_SEHFinallyStmt(Stmt/*P*/ From) {
    assert From != null;
    return SEHFinallyStmt.classof(From);
  }

  public static SEHFinallyStmt cast_SEHFinallyStmt(Stmt/*P*/ From) {
    assert isa_SEHFinallyStmt(From);
    return (SEHFinallyStmt) From;
  }

  public static SEHFinallyStmt cast_or_null_SEHFinallyStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SEHFinallyStmt(From);
  }

  public static SEHFinallyStmt dyn_cast_SEHFinallyStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static SEHFinallyStmt dyn_cast_or_null_SEHFinallyStmt(Stmt/*P*/ From) {
    return (From != null) && isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static boolean isa_SEHFinallyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SEHFinallyStmt.class, From.$deref());
  }

  public static SEHFinallyStmt cast_SEHFinallyStmt(type$ref<?>/*P*/ From) {
    assert isa_SEHFinallyStmt(From);
    return llvm.cast(SEHFinallyStmt.class, From.$deref());
  }

  public static SEHFinallyStmt cast_or_null_SEHFinallyStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SEHFinallyStmt(From);
  }

  public static SEHFinallyStmt dyn_cast_SEHFinallyStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static SEHFinallyStmt dyn_cast_or_null_SEHFinallyStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SEHFinallyStmt(From) ? cast_SEHFinallyStmt(From) : null;
  }

  public static boolean isa_SEHLeaveStmt(Stmt/*P*/ From) {
    assert From != null;
    return SEHLeaveStmt.classof(From);
  }

  public static SEHLeaveStmt cast_SEHLeaveStmt(Stmt/*P*/ From) {
    assert isa_SEHLeaveStmt(From);
    return (SEHLeaveStmt) From;
  }

  public static SEHLeaveStmt cast_or_null_SEHLeaveStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SEHLeaveStmt(From);
  }

  public static SEHLeaveStmt dyn_cast_SEHLeaveStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static SEHLeaveStmt dyn_cast_or_null_SEHLeaveStmt(Stmt/*P*/ From) {
    return (From != null) && isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static boolean isa_SEHLeaveStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SEHLeaveStmt.class, From.$star());
  }

  public static SEHLeaveStmt cast_SEHLeaveStmt(type$ptr<?>/*P*/ From) {
    assert isa_SEHLeaveStmt(From);
    return llvm.cast(SEHLeaveStmt.class, From.$star());
  }

  public static SEHLeaveStmt cast_or_null_SEHLeaveStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SEHLeaveStmt(From);
  }

  public static SEHLeaveStmt dyn_cast_SEHLeaveStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static SEHLeaveStmt dyn_cast_or_null_SEHLeaveStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static boolean isa_SEHLeaveStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SEHLeaveStmt.class, From.$deref());
  }

  public static SEHLeaveStmt cast_SEHLeaveStmt(type$ref<?>/*P*/ From) {
    assert isa_SEHLeaveStmt(From);
    return llvm.cast(SEHLeaveStmt.class, From.$deref());
  }

  public static SEHLeaveStmt cast_or_null_SEHLeaveStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SEHLeaveStmt(From);
  }

  public static SEHLeaveStmt dyn_cast_SEHLeaveStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static SEHLeaveStmt dyn_cast_or_null_SEHLeaveStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SEHLeaveStmt(From) ? cast_SEHLeaveStmt(From) : null;
  }

  public static boolean isa_SEHTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return SEHTryStmt.classof(From);
  }

  public static SEHTryStmt cast_SEHTryStmt(Stmt/*P*/ From) {
    assert isa_SEHTryStmt(From);
    return (SEHTryStmt) From;
  }

  public static SEHTryStmt cast_or_null_SEHTryStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SEHTryStmt(From);
  }

  public static SEHTryStmt dyn_cast_SEHTryStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static SEHTryStmt dyn_cast_or_null_SEHTryStmt(Stmt/*P*/ From) {
    return (From != null) && isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static boolean isa_SEHTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SEHTryStmt.class, From.$star());
  }

  public static SEHTryStmt cast_SEHTryStmt(type$ptr<?>/*P*/ From) {
    assert isa_SEHTryStmt(From);
    return llvm.cast(SEHTryStmt.class, From.$star());
  }

  public static SEHTryStmt cast_or_null_SEHTryStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SEHTryStmt(From);
  }

  public static SEHTryStmt dyn_cast_SEHTryStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static SEHTryStmt dyn_cast_or_null_SEHTryStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static boolean isa_SEHTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SEHTryStmt.class, From.$deref());
  }

  public static SEHTryStmt cast_SEHTryStmt(type$ref<?>/*P*/ From) {
    assert isa_SEHTryStmt(From);
    return llvm.cast(SEHTryStmt.class, From.$deref());
  }

  public static SEHTryStmt cast_or_null_SEHTryStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SEHTryStmt(From);
  }

  public static SEHTryStmt dyn_cast_SEHTryStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static SEHTryStmt dyn_cast_or_null_SEHTryStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SEHTryStmt(From) ? cast_SEHTryStmt(From) : null;
  }

  public static boolean isa_Stmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Stmt.class, From.$deref());
  }

  public static Stmt cast_Stmt(type$ref<?>/*P*/ From) {
    assert isa_Stmt(From);
    return llvm.cast(Stmt.class, From.$deref());
  }

  public static Stmt cast_or_null_Stmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Stmt(From);
  }

  public static Stmt dyn_cast_Stmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static Stmt dyn_cast_or_null_Stmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static boolean isa_Stmt(Stmt/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Stmt cast_Stmt(Stmt/*P*/ From) {
    assert isa_Stmt(From);
    return (Stmt) From;
  }

  public static Stmt cast_or_null_Stmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_Stmt(From);
  }

  public static Stmt dyn_cast_Stmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static Stmt dyn_cast_or_null_Stmt(Stmt/*P*/ From) {
    return (From != null) && isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static boolean isa_Stmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Stmt.class, From.$star());
  }

  public static Stmt cast_Stmt(type$ptr<?>/*P*/ From) {
    assert isa_Stmt(From);
    return llvm.cast(Stmt.class, From.$star());
  }

  public static Stmt cast_or_null_Stmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Stmt(From);
  }

  public static Stmt dyn_cast_Stmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static Stmt dyn_cast_or_null_Stmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Stmt(From) ? cast_Stmt(From) : null;
  }

  public static boolean isa_SwitchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwitchStmt.class, From.$deref());
  }

  public static SwitchStmt cast_SwitchStmt(type$ref<?>/*P*/ From) {
    assert isa_SwitchStmt(From);
    return llvm.cast(SwitchStmt.class, From.$deref());
  }

  public static SwitchStmt cast_or_null_SwitchStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwitchStmt(From);
  }

  public static SwitchStmt dyn_cast_SwitchStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static SwitchStmt dyn_cast_or_null_SwitchStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static boolean isa_SwitchStmt(Stmt/*P*/ From) {
    assert From != null;
    return SwitchStmt.classof(From);
  }

  public static SwitchStmt cast_SwitchStmt(Stmt/*P*/ From) {
    assert isa_SwitchStmt(From);
    return (SwitchStmt) From;
  }

  public static SwitchStmt cast_or_null_SwitchStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SwitchStmt(From);
  }

  public static SwitchStmt dyn_cast_SwitchStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static SwitchStmt dyn_cast_or_null_SwitchStmt(Stmt/*P*/ From) {
    return (From != null) && isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static boolean isa_SwitchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwitchStmt.class, From.$star());
  }

  public static SwitchStmt cast_SwitchStmt(type$ptr<?>/*P*/ From) {
    assert isa_SwitchStmt(From);
    return llvm.cast(SwitchStmt.class, From.$star());
  }

  public static SwitchStmt cast_or_null_SwitchStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwitchStmt(From);
  }

  public static SwitchStmt dyn_cast_SwitchStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static SwitchStmt dyn_cast_or_null_SwitchStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwitchStmt(From) ? cast_SwitchStmt(From) : null;
  }

  public static boolean isa_WhileStmt(Stmt/*P*/ From) {
    assert From != null;
    return WhileStmt.classof(From);
  }

  public static WhileStmt cast_WhileStmt(Stmt/*P*/ From) {
    assert isa_WhileStmt(From);
    return (WhileStmt) From;
  }

  public static WhileStmt cast_or_null_WhileStmt(Stmt/*P*/ From) {
    return (From == null) ? null : cast_WhileStmt(From);
  }

  public static WhileStmt dyn_cast_WhileStmt(Stmt/*P*/ From) {
    assert From != null;
    return isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }

  public static WhileStmt dyn_cast_or_null_WhileStmt(Stmt/*P*/ From) {
    return (From != null) && isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }

  public static boolean isa_WhileStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WhileStmt.class, From.$star());
  }

  public static WhileStmt cast_WhileStmt(type$ptr<?>/*P*/ From) {
    assert isa_WhileStmt(From);
    return llvm.cast(WhileStmt.class, From.$star());
  }

  public static WhileStmt cast_or_null_WhileStmt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WhileStmt(From);
  }

  public static WhileStmt dyn_cast_WhileStmt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }

  public static WhileStmt dyn_cast_or_null_WhileStmt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }

  public static boolean isa_WhileStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WhileStmt.class, From.$deref());
  }

  public static WhileStmt cast_WhileStmt(type$ref<?>/*P*/ From) {
    assert isa_WhileStmt(From);
    return llvm.cast(WhileStmt.class, From.$deref());
  }

  public static WhileStmt cast_or_null_WhileStmt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WhileStmt(From);
  }

  public static WhileStmt dyn_cast_WhileStmt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }

  public static WhileStmt dyn_cast_or_null_WhileStmt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WhileStmt(From) ? cast_WhileStmt(From) : null;
  }
}
