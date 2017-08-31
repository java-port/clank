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
package org.clang.sema.java;

import org.clang.ast.*;
import org.clang.sema.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class SemaRTTI {
  /*package*/SemaRTTI() {}

  public static boolean isa_BlockScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockScopeInfo.class, From.$star());
  }

  public static BlockScopeInfo cast_BlockScopeInfo(type$ptr<?>/*P*/ From) {
    assert isa_BlockScopeInfo(From);
    return llvm.cast(BlockScopeInfo.class, From.$star());
  }

  public static BlockScopeInfo cast_or_null_BlockScopeInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockScopeInfo(From);
  }

  public static BlockScopeInfo dyn_cast_BlockScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static BlockScopeInfo dyn_cast_or_null_BlockScopeInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static boolean isa_BlockScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(BlockScopeInfo.class, From);
  }

  public static BlockScopeInfo cast_BlockScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert isa_BlockScopeInfo(From);
    return llvm.cast(BlockScopeInfo.class, From);
  }

  public static BlockScopeInfo cast_or_null_BlockScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From == null) ? null : cast_BlockScopeInfo(From);
  }

  public static BlockScopeInfo dyn_cast_BlockScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static BlockScopeInfo dyn_cast_or_null_BlockScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From != null) && isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static boolean isa_BlockScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockScopeInfo.class, From.$deref());
  }

  public static BlockScopeInfo cast_BlockScopeInfo(type$ref<?>/*P*/ From) {
    assert isa_BlockScopeInfo(From);
    return llvm.cast(BlockScopeInfo.class, From.$deref());
  }

  public static BlockScopeInfo cast_or_null_BlockScopeInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockScopeInfo(From);
  }

  public static BlockScopeInfo dyn_cast_BlockScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static BlockScopeInfo dyn_cast_or_null_BlockScopeInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockScopeInfo(From) ? cast_BlockScopeInfo(From) : null;
  }

  public static boolean isa_CapturedRegionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(CapturedRegionScopeInfo.class, From);
  }

  public static CapturedRegionScopeInfo cast_CapturedRegionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert isa_CapturedRegionScopeInfo(From);
    return llvm.cast(CapturedRegionScopeInfo.class, From);
  }

  public static CapturedRegionScopeInfo cast_or_null_CapturedRegionScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From == null) ? null : cast_CapturedRegionScopeInfo(From);
  }

  public static CapturedRegionScopeInfo dyn_cast_CapturedRegionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static CapturedRegionScopeInfo dyn_cast_or_null_CapturedRegionScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From != null) && isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static boolean isa_CapturedRegionScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapturedRegionScopeInfo.class, From.$star());
  }

  public static CapturedRegionScopeInfo cast_CapturedRegionScopeInfo(type$ptr<?>/*P*/ From) {
    assert isa_CapturedRegionScopeInfo(From);
    return llvm.cast(CapturedRegionScopeInfo.class, From.$star());
  }

  public static CapturedRegionScopeInfo cast_or_null_CapturedRegionScopeInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapturedRegionScopeInfo(From);
  }

  public static CapturedRegionScopeInfo dyn_cast_CapturedRegionScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static CapturedRegionScopeInfo dyn_cast_or_null_CapturedRegionScopeInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static boolean isa_CapturedRegionScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapturedRegionScopeInfo.class, From.$deref());
  }

  public static CapturedRegionScopeInfo cast_CapturedRegionScopeInfo(type$ref<?>/*P*/ From) {
    assert isa_CapturedRegionScopeInfo(From);
    return llvm.cast(CapturedRegionScopeInfo.class, From.$deref());
  }

  public static CapturedRegionScopeInfo cast_or_null_CapturedRegionScopeInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapturedRegionScopeInfo(From);
  }

  public static CapturedRegionScopeInfo dyn_cast_CapturedRegionScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static CapturedRegionScopeInfo dyn_cast_or_null_CapturedRegionScopeInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapturedRegionScopeInfo(From) ? cast_CapturedRegionScopeInfo(From) : null;
  }

  public static boolean isa_CapturingScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(CapturingScopeInfo.class, From);
  }

  public static CapturingScopeInfo cast_CapturingScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert isa_CapturingScopeInfo(From);
    return llvm.cast(CapturingScopeInfo.class, From);
  }

  public static CapturingScopeInfo cast_or_null_CapturingScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From == null) ? null : cast_CapturingScopeInfo(From);
  }

  public static CapturingScopeInfo dyn_cast_CapturingScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static CapturingScopeInfo dyn_cast_or_null_CapturingScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From != null) && isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static boolean isa_CapturingScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapturingScopeInfo.class, From.$deref());
  }

  public static CapturingScopeInfo cast_CapturingScopeInfo(type$ref<?>/*P*/ From) {
    assert isa_CapturingScopeInfo(From);
    return llvm.cast(CapturingScopeInfo.class, From.$deref());
  }

  public static CapturingScopeInfo cast_or_null_CapturingScopeInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapturingScopeInfo(From);
  }

  public static CapturingScopeInfo dyn_cast_CapturingScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static CapturingScopeInfo dyn_cast_or_null_CapturingScopeInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static boolean isa_CapturingScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapturingScopeInfo.class, From.$star());
  }

  public static CapturingScopeInfo cast_CapturingScopeInfo(type$ptr<?>/*P*/ From) {
    assert isa_CapturingScopeInfo(From);
    return llvm.cast(CapturingScopeInfo.class, From.$star());
  }

  public static CapturingScopeInfo cast_or_null_CapturingScopeInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapturingScopeInfo(From);
  }

  public static CapturingScopeInfo dyn_cast_CapturingScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static CapturingScopeInfo dyn_cast_or_null_CapturingScopeInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapturingScopeInfo(From) ? cast_CapturingScopeInfo(From) : null;
  }

  public static boolean isa_ExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExternalSemaSource.class, From.$star());
  }

  public static ExternalSemaSource cast_ExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert isa_ExternalSemaSource(From);
    return llvm.cast(ExternalSemaSource.class, From.$star());
  }

  public static ExternalSemaSource cast_or_null_ExternalSemaSource(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExternalSemaSource(From);
  }

  public static ExternalSemaSource dyn_cast_ExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static ExternalSemaSource dyn_cast_or_null_ExternalSemaSource(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static boolean isa_ExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert From != null;
    return llvm.isa(ExternalSemaSource.class, From);
  }

  public static ExternalSemaSource cast_ExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert isa_ExternalSemaSource(From);
    return llvm.cast(ExternalSemaSource.class, From);
  }

  public static ExternalSemaSource cast_or_null_ExternalSemaSource(ExternalASTSource/*P*/ From) {
    return (From == null) ? null : cast_ExternalSemaSource(From);
  }

  public static ExternalSemaSource dyn_cast_ExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert From != null;
    return isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static ExternalSemaSource dyn_cast_or_null_ExternalSemaSource(ExternalASTSource/*P*/ From) {
    return (From != null) && isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static boolean isa_ExternalSemaSource(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExternalSemaSource.class, From.$deref());
  }

  public static ExternalSemaSource cast_ExternalSemaSource(type$ref<?>/*P*/ From) {
    assert isa_ExternalSemaSource(From);
    return llvm.cast(ExternalSemaSource.class, From.$deref());
  }

  public static ExternalSemaSource cast_or_null_ExternalSemaSource(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExternalSemaSource(From);
  }

  public static ExternalSemaSource dyn_cast_ExternalSemaSource(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static ExternalSemaSource dyn_cast_or_null_ExternalSemaSource(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExternalSemaSource(From) ? cast_ExternalSemaSource(From) : null;
  }

  public static boolean isa_FunctionScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionScopeInfo.class, From.$star());
  }

  public static FunctionScopeInfo cast_FunctionScopeInfo(type$ptr<?>/*P*/ From) {
    assert isa_FunctionScopeInfo(From);
    return llvm.cast(FunctionScopeInfo.class, From.$star());
  }

  public static FunctionScopeInfo cast_or_null_FunctionScopeInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionScopeInfo(From);
  }

  public static FunctionScopeInfo dyn_cast_FunctionScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static FunctionScopeInfo dyn_cast_or_null_FunctionScopeInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static boolean isa_FunctionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(FunctionScopeInfo.class, From);
  }

  public static FunctionScopeInfo cast_FunctionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert isa_FunctionScopeInfo(From);
    return llvm.cast(FunctionScopeInfo.class, From);
  }

  public static FunctionScopeInfo cast_or_null_FunctionScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From == null) ? null : cast_FunctionScopeInfo(From);
  }

  public static FunctionScopeInfo dyn_cast_FunctionScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static FunctionScopeInfo dyn_cast_or_null_FunctionScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From != null) && isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static boolean isa_FunctionScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionScopeInfo.class, From.$deref());
  }

  public static FunctionScopeInfo cast_FunctionScopeInfo(type$ref<?>/*P*/ From) {
    assert isa_FunctionScopeInfo(From);
    return llvm.cast(FunctionScopeInfo.class, From.$deref());
  }

  public static FunctionScopeInfo cast_or_null_FunctionScopeInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionScopeInfo(From);
  }

  public static FunctionScopeInfo dyn_cast_FunctionScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static FunctionScopeInfo dyn_cast_or_null_FunctionScopeInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionScopeInfo(From) ? cast_FunctionScopeInfo(From) : null;
  }

  public static boolean isa_LambdaScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LambdaScopeInfo.class, From.$deref());
  }

  public static LambdaScopeInfo cast_LambdaScopeInfo(type$ref<?>/*P*/ From) {
    assert isa_LambdaScopeInfo(From);
    return llvm.cast(LambdaScopeInfo.class, From.$deref());
  }

  public static LambdaScopeInfo cast_or_null_LambdaScopeInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LambdaScopeInfo(From);
  }

  public static LambdaScopeInfo dyn_cast_LambdaScopeInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static LambdaScopeInfo dyn_cast_or_null_LambdaScopeInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static boolean isa_LambdaScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LambdaScopeInfo.class, From.$star());
  }

  public static LambdaScopeInfo cast_LambdaScopeInfo(type$ptr<?>/*P*/ From) {
    assert isa_LambdaScopeInfo(From);
    return llvm.cast(LambdaScopeInfo.class, From.$star());
  }

  public static LambdaScopeInfo cast_or_null_LambdaScopeInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LambdaScopeInfo(From);
  }

  public static LambdaScopeInfo dyn_cast_LambdaScopeInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static LambdaScopeInfo dyn_cast_or_null_LambdaScopeInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static boolean isa_LambdaScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(LambdaScopeInfo.class, From);
  }

  public static LambdaScopeInfo cast_LambdaScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert isa_LambdaScopeInfo(From);
    return llvm.cast(LambdaScopeInfo.class, From);
  }

  public static LambdaScopeInfo cast_or_null_LambdaScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From == null) ? null : cast_LambdaScopeInfo(From);
  }

  public static LambdaScopeInfo dyn_cast_LambdaScopeInfo(FunctionScopeInfo/*P*/ From) {
    assert From != null;
    return isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static LambdaScopeInfo dyn_cast_or_null_LambdaScopeInfo(FunctionScopeInfo/*P*/ From) {
    return (From != null) && isa_LambdaScopeInfo(From) ? cast_LambdaScopeInfo(From) : null;
  }

  public static boolean isa_MultiplexExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert From != null;
    return llvm.isa(MultiplexExternalSemaSource.class, From);
  }

  public static MultiplexExternalSemaSource cast_MultiplexExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert isa_MultiplexExternalSemaSource(From);
    return llvm.cast(MultiplexExternalSemaSource.class, From);
  }

  public static MultiplexExternalSemaSource cast_or_null_MultiplexExternalSemaSource(ExternalASTSource/*P*/ From) {
    return (From == null) ? null : cast_MultiplexExternalSemaSource(From);
  }

  public static MultiplexExternalSemaSource dyn_cast_MultiplexExternalSemaSource(ExternalASTSource/*P*/ From) {
    assert From != null;
    return isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static MultiplexExternalSemaSource dyn_cast_or_null_MultiplexExternalSemaSource(ExternalASTSource/*P*/ From) {
    return (From != null) && isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static boolean isa_MultiplexExternalSemaSource(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MultiplexExternalSemaSource.class, From.$deref());
  }

  public static MultiplexExternalSemaSource cast_MultiplexExternalSemaSource(type$ref<?>/*P*/ From) {
    assert isa_MultiplexExternalSemaSource(From);
    return llvm.cast(MultiplexExternalSemaSource.class, From.$deref());
  }

  public static MultiplexExternalSemaSource cast_or_null_MultiplexExternalSemaSource(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MultiplexExternalSemaSource(From);
  }

  public static MultiplexExternalSemaSource dyn_cast_MultiplexExternalSemaSource(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static MultiplexExternalSemaSource dyn_cast_or_null_MultiplexExternalSemaSource(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static boolean isa_MultiplexExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MultiplexExternalSemaSource.class, From.$star());
  }

  public static MultiplexExternalSemaSource cast_MultiplexExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert isa_MultiplexExternalSemaSource(From);
    return llvm.cast(MultiplexExternalSemaSource.class, From.$star());
  }

  public static MultiplexExternalSemaSource cast_or_null_MultiplexExternalSemaSource(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MultiplexExternalSemaSource(From);
  }

  public static MultiplexExternalSemaSource dyn_cast_MultiplexExternalSemaSource(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static MultiplexExternalSemaSource dyn_cast_or_null_MultiplexExternalSemaSource(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static boolean isa_MultiplexExternalSemaSource(MultiplexExternalSemaSource/*P*/ From) {
    assert From != null;
    return llvm.isa(MultiplexExternalSemaSource.class, From);
  }

  public static MultiplexExternalSemaSource cast_MultiplexExternalSemaSource(MultiplexExternalSemaSource/*P*/ From) {
    assert isa_MultiplexExternalSemaSource(From);
    return llvm.cast(MultiplexExternalSemaSource.class, From);
  }

  public static MultiplexExternalSemaSource cast_or_null_MultiplexExternalSemaSource(MultiplexExternalSemaSource/*P*/ From) {
    return (From == null) ? null : cast_MultiplexExternalSemaSource(From);
  }

  public static MultiplexExternalSemaSource dyn_cast_MultiplexExternalSemaSource(MultiplexExternalSemaSource/*P*/ From) {
    assert From != null;
    return isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static MultiplexExternalSemaSource dyn_cast_or_null_MultiplexExternalSemaSource(MultiplexExternalSemaSource/*P*/ From) {
    return (From != null) && isa_MultiplexExternalSemaSource(From) ? cast_MultiplexExternalSemaSource(From) : null;
  }

  public static boolean isa_SemaConsumer(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SemaConsumer.class, From.$star());
  }

  public static SemaConsumer cast_SemaConsumer(type$ptr<?>/*P*/ From) {
    assert isa_SemaConsumer(From);
    return llvm.cast(SemaConsumer.class, From.$star());
  }

  public static SemaConsumer cast_or_null_SemaConsumer(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SemaConsumer(From);
  }

  public static SemaConsumer dyn_cast_SemaConsumer(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }

  public static SemaConsumer dyn_cast_or_null_SemaConsumer(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }

  public static boolean isa_SemaConsumer(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SemaConsumer.class, From.$deref());
  }

  public static SemaConsumer cast_SemaConsumer(type$ref<?>/*P*/ From) {
    assert isa_SemaConsumer(From);
    return llvm.cast(SemaConsumer.class, From.$deref());
  }

  public static SemaConsumer cast_or_null_SemaConsumer(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SemaConsumer(From);
  }

  public static SemaConsumer dyn_cast_SemaConsumer(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }

  public static SemaConsumer dyn_cast_or_null_SemaConsumer(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }

  public static boolean isa_SemaConsumer(ASTConsumer/*P*/ From) {
    assert From != null;
    return llvm.isa(SemaConsumer.class, From);
  }

  public static SemaConsumer cast_SemaConsumer(ASTConsumer/*P*/ From) {
    assert isa_SemaConsumer(From);
    return llvm.cast(SemaConsumer.class, From);
  }

  public static SemaConsumer cast_or_null_SemaConsumer(ASTConsumer/*P*/ From) {
    return (From == null) ? null : cast_SemaConsumer(From);
  }

  public static SemaConsumer dyn_cast_SemaConsumer(ASTConsumer/*P*/ From) {
    assert From != null;
    return isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }

  public static SemaConsumer dyn_cast_or_null_SemaConsumer(ASTConsumer/*P*/ From) {
    return (From != null) && isa_SemaConsumer(From) ? cast_SemaConsumer(From) : null;
  }
}
