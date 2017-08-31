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

public class AstExpressionsRTTI {
  /*package*/AstExpressionsRTTI() {}

  public static boolean isa_AddrLabelExpr(Stmt/*P*/ From) {
    assert From != null;
    return AddrLabelExpr.classof(From);
  }

  public static AddrLabelExpr cast_AddrLabelExpr(Stmt/*P*/ From) {
    assert isa_AddrLabelExpr(From);
    return (AddrLabelExpr) From;
  }

  public static AddrLabelExpr cast_or_null_AddrLabelExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AddrLabelExpr(From);
  }

  public static AddrLabelExpr dyn_cast_AddrLabelExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static AddrLabelExpr dyn_cast_or_null_AddrLabelExpr(Stmt/*P*/ From) {
    return (From != null) && isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static boolean isa_AddrLabelExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AddrLabelExpr.class, From.$star());
  }

  public static AddrLabelExpr cast_AddrLabelExpr(type$ptr<?>/*P*/ From) {
    assert isa_AddrLabelExpr(From);
    return llvm.cast(AddrLabelExpr.class, From.$star());
  }

  public static AddrLabelExpr cast_or_null_AddrLabelExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AddrLabelExpr(From);
  }

  public static AddrLabelExpr dyn_cast_AddrLabelExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static AddrLabelExpr dyn_cast_or_null_AddrLabelExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static boolean isa_AddrLabelExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AddrLabelExpr.class, From.$deref());
  }

  public static AddrLabelExpr cast_AddrLabelExpr(type$ref<?>/*P*/ From) {
    assert isa_AddrLabelExpr(From);
    return llvm.cast(AddrLabelExpr.class, From.$deref());
  }

  public static AddrLabelExpr cast_or_null_AddrLabelExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AddrLabelExpr(From);
  }

  public static AddrLabelExpr dyn_cast_AddrLabelExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static AddrLabelExpr dyn_cast_or_null_AddrLabelExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AddrLabelExpr(From) ? cast_AddrLabelExpr(From) : null;
  }

  public static boolean isa_ArraySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArraySubscriptExpr.class, From.$star());
  }

  public static ArraySubscriptExpr cast_ArraySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert isa_ArraySubscriptExpr(From);
    return llvm.cast(ArraySubscriptExpr.class, From.$star());
  }

  public static ArraySubscriptExpr cast_or_null_ArraySubscriptExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArraySubscriptExpr(From);
  }

  public static ArraySubscriptExpr dyn_cast_ArraySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static ArraySubscriptExpr dyn_cast_or_null_ArraySubscriptExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static boolean isa_ArraySubscriptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArraySubscriptExpr.class, From.$deref());
  }

  public static ArraySubscriptExpr cast_ArraySubscriptExpr(type$ref<?>/*P*/ From) {
    assert isa_ArraySubscriptExpr(From);
    return llvm.cast(ArraySubscriptExpr.class, From.$deref());
  }

  public static ArraySubscriptExpr cast_or_null_ArraySubscriptExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArraySubscriptExpr(From);
  }

  public static ArraySubscriptExpr dyn_cast_ArraySubscriptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static ArraySubscriptExpr dyn_cast_or_null_ArraySubscriptExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static boolean isa_ArraySubscriptExpr(Stmt/*P*/ From) {
    assert From != null;
    return ArraySubscriptExpr.classof(From);
  }

  public static ArraySubscriptExpr cast_ArraySubscriptExpr(Stmt/*P*/ From) {
    assert isa_ArraySubscriptExpr(From);
    return (ArraySubscriptExpr) From;
  }

  public static ArraySubscriptExpr cast_or_null_ArraySubscriptExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ArraySubscriptExpr(From);
  }

  public static ArraySubscriptExpr dyn_cast_ArraySubscriptExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static ArraySubscriptExpr dyn_cast_or_null_ArraySubscriptExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ArraySubscriptExpr(From) ? cast_ArraySubscriptExpr(From) : null;
  }

  public static boolean isa_ArrayTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArrayTypeTraitExpr.class, From.$deref());
  }

  public static ArrayTypeTraitExpr cast_ArrayTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert isa_ArrayTypeTraitExpr(From);
    return llvm.cast(ArrayTypeTraitExpr.class, From.$deref());
  }

  public static ArrayTypeTraitExpr cast_or_null_ArrayTypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArrayTypeTraitExpr(From);
  }

  public static ArrayTypeTraitExpr dyn_cast_ArrayTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static ArrayTypeTraitExpr dyn_cast_or_null_ArrayTypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static boolean isa_ArrayTypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return ArrayTypeTraitExpr.classof(From);
  }

  public static ArrayTypeTraitExpr cast_ArrayTypeTraitExpr(Stmt/*P*/ From) {
    assert isa_ArrayTypeTraitExpr(From);
    return (ArrayTypeTraitExpr) From;
  }

  public static ArrayTypeTraitExpr cast_or_null_ArrayTypeTraitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ArrayTypeTraitExpr(From);
  }

  public static ArrayTypeTraitExpr dyn_cast_ArrayTypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static ArrayTypeTraitExpr dyn_cast_or_null_ArrayTypeTraitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static boolean isa_ArrayTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArrayTypeTraitExpr.class, From.$star());
  }

  public static ArrayTypeTraitExpr cast_ArrayTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert isa_ArrayTypeTraitExpr(From);
    return llvm.cast(ArrayTypeTraitExpr.class, From.$star());
  }

  public static ArrayTypeTraitExpr cast_or_null_ArrayTypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArrayTypeTraitExpr(From);
  }

  public static ArrayTypeTraitExpr dyn_cast_ArrayTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static ArrayTypeTraitExpr dyn_cast_or_null_ArrayTypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArrayTypeTraitExpr(From) ? cast_ArrayTypeTraitExpr(From) : null;
  }

  public static boolean isa_AsTypeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AsTypeExpr.class, From.$star());
  }

  public static AsTypeExpr cast_AsTypeExpr(type$ptr<?>/*P*/ From) {
    assert isa_AsTypeExpr(From);
    return llvm.cast(AsTypeExpr.class, From.$star());
  }

  public static AsTypeExpr cast_or_null_AsTypeExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AsTypeExpr(From);
  }

  public static AsTypeExpr dyn_cast_AsTypeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static AsTypeExpr dyn_cast_or_null_AsTypeExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static boolean isa_AsTypeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AsTypeExpr.class, From.$deref());
  }

  public static AsTypeExpr cast_AsTypeExpr(type$ref<?>/*P*/ From) {
    assert isa_AsTypeExpr(From);
    return llvm.cast(AsTypeExpr.class, From.$deref());
  }

  public static AsTypeExpr cast_or_null_AsTypeExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AsTypeExpr(From);
  }

  public static AsTypeExpr dyn_cast_AsTypeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static AsTypeExpr dyn_cast_or_null_AsTypeExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static boolean isa_AsTypeExpr(Stmt/*P*/ From) {
    assert From != null;
    return AsTypeExpr.classof(From);
  }

  public static AsTypeExpr cast_AsTypeExpr(Stmt/*P*/ From) {
    assert isa_AsTypeExpr(From);
    return (AsTypeExpr) From;
  }

  public static AsTypeExpr cast_or_null_AsTypeExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AsTypeExpr(From);
  }

  public static AsTypeExpr dyn_cast_AsTypeExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static AsTypeExpr dyn_cast_or_null_AsTypeExpr(Stmt/*P*/ From) {
    return (From != null) && isa_AsTypeExpr(From) ? cast_AsTypeExpr(From) : null;
  }

  public static boolean isa_AtomicExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AtomicExpr.class, From.$deref());
  }

  public static AtomicExpr cast_AtomicExpr(type$ref<?>/*P*/ From) {
    assert isa_AtomicExpr(From);
    return llvm.cast(AtomicExpr.class, From.$deref());
  }

  public static AtomicExpr cast_or_null_AtomicExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AtomicExpr(From);
  }

  public static AtomicExpr dyn_cast_AtomicExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static AtomicExpr dyn_cast_or_null_AtomicExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static boolean isa_AtomicExpr(Stmt/*P*/ From) {
    assert From != null;
    return AtomicExpr.classof(From);
  }

  public static AtomicExpr cast_AtomicExpr(Stmt/*P*/ From) {
    assert isa_AtomicExpr(From);
    return (AtomicExpr) From;
  }

  public static AtomicExpr cast_or_null_AtomicExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_AtomicExpr(From);
  }

  public static AtomicExpr dyn_cast_AtomicExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static AtomicExpr dyn_cast_or_null_AtomicExpr(Stmt/*P*/ From) {
    return (From != null) && isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static boolean isa_AtomicExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AtomicExpr.class, From.$star());
  }

  public static AtomicExpr cast_AtomicExpr(type$ptr<?>/*P*/ From) {
    assert isa_AtomicExpr(From);
    return llvm.cast(AtomicExpr.class, From.$star());
  }

  public static AtomicExpr cast_or_null_AtomicExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AtomicExpr(From);
  }

  public static AtomicExpr dyn_cast_AtomicExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static AtomicExpr dyn_cast_or_null_AtomicExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AtomicExpr(From) ? cast_AtomicExpr(From) : null;
  }

  public static boolean isa_BlockExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockExpr.class, From.$star());
  }

  public static BlockExpr cast_BlockExpr(type$ptr<?>/*P*/ From) {
    assert isa_BlockExpr(From);
    return llvm.cast(BlockExpr.class, From.$star());
  }

  public static BlockExpr cast_or_null_BlockExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockExpr(From);
  }

  public static BlockExpr dyn_cast_BlockExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static BlockExpr dyn_cast_or_null_BlockExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static boolean isa_BlockExpr(Stmt/*P*/ From) {
    assert From != null;
    return BlockExpr.classof(From);
  }

  public static BlockExpr cast_BlockExpr(Stmt/*P*/ From) {
    assert isa_BlockExpr(From);
    return (BlockExpr) From;
  }

  public static BlockExpr cast_or_null_BlockExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_BlockExpr(From);
  }

  public static BlockExpr dyn_cast_BlockExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static BlockExpr dyn_cast_or_null_BlockExpr(Stmt/*P*/ From) {
    return (From != null) && isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static boolean isa_BlockExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockExpr.class, From.$deref());
  }

  public static BlockExpr cast_BlockExpr(type$ref<?>/*P*/ From) {
    assert isa_BlockExpr(From);
    return llvm.cast(BlockExpr.class, From.$deref());
  }

  public static BlockExpr cast_or_null_BlockExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockExpr(From);
  }

  public static BlockExpr dyn_cast_BlockExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static BlockExpr dyn_cast_or_null_BlockExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockExpr(From) ? cast_BlockExpr(From) : null;
  }

  public static boolean isa_CStyleCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CStyleCastExpr.class, From.$deref());
  }

  public static CStyleCastExpr cast_CStyleCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CStyleCastExpr(From);
    return llvm.cast(CStyleCastExpr.class, From.$deref());
  }

  public static CStyleCastExpr cast_or_null_CStyleCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CStyleCastExpr(From);
  }

  public static CStyleCastExpr dyn_cast_CStyleCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static CStyleCastExpr dyn_cast_or_null_CStyleCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static boolean isa_CStyleCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CStyleCastExpr.class, From.$star());
  }

  public static CStyleCastExpr cast_CStyleCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CStyleCastExpr(From);
    return llvm.cast(CStyleCastExpr.class, From.$star());
  }

  public static CStyleCastExpr cast_or_null_CStyleCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CStyleCastExpr(From);
  }

  public static CStyleCastExpr dyn_cast_CStyleCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static CStyleCastExpr dyn_cast_or_null_CStyleCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static boolean isa_CStyleCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CStyleCastExpr.classof(From);
  }

  public static CStyleCastExpr cast_CStyleCastExpr(Stmt/*P*/ From) {
    assert isa_CStyleCastExpr(From);
    return (CStyleCastExpr) From;
  }

  public static CStyleCastExpr cast_or_null_CStyleCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CStyleCastExpr(From);
  }

  public static CStyleCastExpr dyn_cast_CStyleCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static CStyleCastExpr dyn_cast_or_null_CStyleCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CStyleCastExpr(From) ? cast_CStyleCastExpr(From) : null;
  }

  public static boolean isa_CUDAKernelCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDAKernelCallExpr.class, From.$deref());
  }

  public static CUDAKernelCallExpr cast_CUDAKernelCallExpr(type$ref<?>/*P*/ From) {
    assert isa_CUDAKernelCallExpr(From);
    return llvm.cast(CUDAKernelCallExpr.class, From.$deref());
  }

  public static CUDAKernelCallExpr cast_or_null_CUDAKernelCallExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDAKernelCallExpr(From);
  }

  public static CUDAKernelCallExpr dyn_cast_CUDAKernelCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static CUDAKernelCallExpr dyn_cast_or_null_CUDAKernelCallExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static boolean isa_CUDAKernelCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return CUDAKernelCallExpr.classof(From);
  }

  public static CUDAKernelCallExpr cast_CUDAKernelCallExpr(Stmt/*P*/ From) {
    assert isa_CUDAKernelCallExpr(From);
    return (CUDAKernelCallExpr) From;
  }

  public static CUDAKernelCallExpr cast_or_null_CUDAKernelCallExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CUDAKernelCallExpr(From);
  }

  public static CUDAKernelCallExpr dyn_cast_CUDAKernelCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static CUDAKernelCallExpr dyn_cast_or_null_CUDAKernelCallExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static boolean isa_CUDAKernelCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDAKernelCallExpr.class, From.$star());
  }

  public static CUDAKernelCallExpr cast_CUDAKernelCallExpr(type$ptr<?>/*P*/ From) {
    assert isa_CUDAKernelCallExpr(From);
    return llvm.cast(CUDAKernelCallExpr.class, From.$star());
  }

  public static CUDAKernelCallExpr cast_or_null_CUDAKernelCallExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDAKernelCallExpr(From);
  }

  public static CUDAKernelCallExpr dyn_cast_CUDAKernelCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static CUDAKernelCallExpr dyn_cast_or_null_CUDAKernelCallExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDAKernelCallExpr(From) ? cast_CUDAKernelCallExpr(From) : null;
  }

  public static boolean isa_CXXBindTemporaryExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXBindTemporaryExpr.classof(From);
  }

  public static CXXBindTemporaryExpr cast_CXXBindTemporaryExpr(Stmt/*P*/ From) {
    assert isa_CXXBindTemporaryExpr(From);
    return (CXXBindTemporaryExpr) From;
  }

  public static CXXBindTemporaryExpr cast_or_null_CXXBindTemporaryExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXBindTemporaryExpr(From);
  }

  public static CXXBindTemporaryExpr dyn_cast_CXXBindTemporaryExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static CXXBindTemporaryExpr dyn_cast_or_null_CXXBindTemporaryExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static boolean isa_CXXBindTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXBindTemporaryExpr.class, From.$star());
  }

  public static CXXBindTemporaryExpr cast_CXXBindTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXBindTemporaryExpr(From);
    return llvm.cast(CXXBindTemporaryExpr.class, From.$star());
  }

  public static CXXBindTemporaryExpr cast_or_null_CXXBindTemporaryExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXBindTemporaryExpr(From);
  }

  public static CXXBindTemporaryExpr dyn_cast_CXXBindTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static CXXBindTemporaryExpr dyn_cast_or_null_CXXBindTemporaryExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static boolean isa_CXXBindTemporaryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXBindTemporaryExpr.class, From.$deref());
  }

  public static CXXBindTemporaryExpr cast_CXXBindTemporaryExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXBindTemporaryExpr(From);
    return llvm.cast(CXXBindTemporaryExpr.class, From.$deref());
  }

  public static CXXBindTemporaryExpr cast_or_null_CXXBindTemporaryExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXBindTemporaryExpr(From);
  }

  public static CXXBindTemporaryExpr dyn_cast_CXXBindTemporaryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static CXXBindTemporaryExpr dyn_cast_or_null_CXXBindTemporaryExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXBindTemporaryExpr(From) ? cast_CXXBindTemporaryExpr(From) : null;
  }

  public static boolean isa_CXXBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXBoolLiteralExpr.class, From.$deref());
  }

  public static CXXBoolLiteralExpr cast_CXXBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXBoolLiteralExpr(From);
    return llvm.cast(CXXBoolLiteralExpr.class, From.$deref());
  }

  public static CXXBoolLiteralExpr cast_or_null_CXXBoolLiteralExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXBoolLiteralExpr(From);
  }

  public static CXXBoolLiteralExpr dyn_cast_CXXBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static CXXBoolLiteralExpr dyn_cast_or_null_CXXBoolLiteralExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static boolean isa_CXXBoolLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXBoolLiteralExpr.classof(From);
  }

  public static CXXBoolLiteralExpr cast_CXXBoolLiteralExpr(Stmt/*P*/ From) {
    assert isa_CXXBoolLiteralExpr(From);
    return (CXXBoolLiteralExpr) From;
  }

  public static CXXBoolLiteralExpr cast_or_null_CXXBoolLiteralExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXBoolLiteralExpr(From);
  }

  public static CXXBoolLiteralExpr dyn_cast_CXXBoolLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static CXXBoolLiteralExpr dyn_cast_or_null_CXXBoolLiteralExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static boolean isa_CXXBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXBoolLiteralExpr.class, From.$star());
  }

  public static CXXBoolLiteralExpr cast_CXXBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXBoolLiteralExpr(From);
    return llvm.cast(CXXBoolLiteralExpr.class, From.$star());
  }

  public static CXXBoolLiteralExpr cast_or_null_CXXBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXBoolLiteralExpr(From);
  }

  public static CXXBoolLiteralExpr dyn_cast_CXXBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static CXXBoolLiteralExpr dyn_cast_or_null_CXXBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXBoolLiteralExpr(From) ? cast_CXXBoolLiteralExpr(From) : null;
  }

  public static boolean isa_CXXConstCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXConstCastExpr.class, From.$deref());
  }

  public static CXXConstCastExpr cast_CXXConstCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXConstCastExpr(From);
    return llvm.cast(CXXConstCastExpr.class, From.$deref());
  }

  public static CXXConstCastExpr cast_or_null_CXXConstCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXConstCastExpr(From);
  }

  public static CXXConstCastExpr dyn_cast_CXXConstCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static CXXConstCastExpr dyn_cast_or_null_CXXConstCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static boolean isa_CXXConstCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXConstCastExpr.classof(From);
  }

  public static CXXConstCastExpr cast_CXXConstCastExpr(Stmt/*P*/ From) {
    assert isa_CXXConstCastExpr(From);
    return (CXXConstCastExpr) From;
  }

  public static CXXConstCastExpr cast_or_null_CXXConstCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXConstCastExpr(From);
  }

  public static CXXConstCastExpr dyn_cast_CXXConstCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static CXXConstCastExpr dyn_cast_or_null_CXXConstCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static boolean isa_CXXConstCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXConstCastExpr.class, From.$star());
  }

  public static CXXConstCastExpr cast_CXXConstCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXConstCastExpr(From);
    return llvm.cast(CXXConstCastExpr.class, From.$star());
  }

  public static CXXConstCastExpr cast_or_null_CXXConstCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXConstCastExpr(From);
  }

  public static CXXConstCastExpr dyn_cast_CXXConstCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static CXXConstCastExpr dyn_cast_or_null_CXXConstCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXConstCastExpr(From) ? cast_CXXConstCastExpr(From) : null;
  }

  public static boolean isa_CXXConstructExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXConstructExpr.class, From.$star());
  }

  public static CXXConstructExpr cast_CXXConstructExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXConstructExpr(From);
    return llvm.cast(CXXConstructExpr.class, From.$star());
  }

  public static CXXConstructExpr cast_or_null_CXXConstructExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXConstructExpr(From);
  }

  public static CXXConstructExpr dyn_cast_CXXConstructExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static CXXConstructExpr dyn_cast_or_null_CXXConstructExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static boolean isa_CXXConstructExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXConstructExpr.class, From.$deref());
  }

  public static CXXConstructExpr cast_CXXConstructExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXConstructExpr(From);
    return llvm.cast(CXXConstructExpr.class, From.$deref());
  }

  public static CXXConstructExpr cast_or_null_CXXConstructExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXConstructExpr(From);
  }

  public static CXXConstructExpr dyn_cast_CXXConstructExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static CXXConstructExpr dyn_cast_or_null_CXXConstructExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static boolean isa_CXXConstructExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXConstructExpr.classof(From);
  }

  public static CXXConstructExpr cast_CXXConstructExpr(Stmt/*P*/ From) {
    assert isa_CXXConstructExpr(From);
    return (CXXConstructExpr) From;
  }

  public static CXXConstructExpr cast_or_null_CXXConstructExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructExpr(From);
  }

  public static CXXConstructExpr dyn_cast_CXXConstructExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static CXXConstructExpr dyn_cast_or_null_CXXConstructExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXConstructExpr(From) ? cast_CXXConstructExpr(From) : null;
  }

  public static boolean isa_CXXDefaultArgExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDefaultArgExpr.class, From.$star());
  }

  public static CXXDefaultArgExpr cast_CXXDefaultArgExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXDefaultArgExpr(From);
    return llvm.cast(CXXDefaultArgExpr.class, From.$star());
  }

  public static CXXDefaultArgExpr cast_or_null_CXXDefaultArgExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDefaultArgExpr(From);
  }

  public static CXXDefaultArgExpr dyn_cast_CXXDefaultArgExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static CXXDefaultArgExpr dyn_cast_or_null_CXXDefaultArgExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static boolean isa_CXXDefaultArgExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXDefaultArgExpr.classof(From);
  }

  public static CXXDefaultArgExpr cast_CXXDefaultArgExpr(Stmt/*P*/ From) {
    assert isa_CXXDefaultArgExpr(From);
    return (CXXDefaultArgExpr) From;
  }

  public static CXXDefaultArgExpr cast_or_null_CXXDefaultArgExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXDefaultArgExpr(From);
  }

  public static CXXDefaultArgExpr dyn_cast_CXXDefaultArgExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static CXXDefaultArgExpr dyn_cast_or_null_CXXDefaultArgExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static boolean isa_CXXDefaultArgExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDefaultArgExpr.class, From.$deref());
  }

  public static CXXDefaultArgExpr cast_CXXDefaultArgExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXDefaultArgExpr(From);
    return llvm.cast(CXXDefaultArgExpr.class, From.$deref());
  }

  public static CXXDefaultArgExpr cast_or_null_CXXDefaultArgExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDefaultArgExpr(From);
  }

  public static CXXDefaultArgExpr dyn_cast_CXXDefaultArgExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static CXXDefaultArgExpr dyn_cast_or_null_CXXDefaultArgExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDefaultArgExpr(From) ? cast_CXXDefaultArgExpr(From) : null;
  }

  public static boolean isa_CXXDefaultInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDefaultInitExpr.class, From.$deref());
  }

  public static CXXDefaultInitExpr cast_CXXDefaultInitExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXDefaultInitExpr(From);
    return llvm.cast(CXXDefaultInitExpr.class, From.$deref());
  }

  public static CXXDefaultInitExpr cast_or_null_CXXDefaultInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDefaultInitExpr(From);
  }

  public static CXXDefaultInitExpr dyn_cast_CXXDefaultInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static CXXDefaultInitExpr dyn_cast_or_null_CXXDefaultInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static boolean isa_CXXDefaultInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDefaultInitExpr.class, From.$star());
  }

  public static CXXDefaultInitExpr cast_CXXDefaultInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXDefaultInitExpr(From);
    return llvm.cast(CXXDefaultInitExpr.class, From.$star());
  }

  public static CXXDefaultInitExpr cast_or_null_CXXDefaultInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDefaultInitExpr(From);
  }

  public static CXXDefaultInitExpr dyn_cast_CXXDefaultInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static CXXDefaultInitExpr dyn_cast_or_null_CXXDefaultInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static boolean isa_CXXDefaultInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXDefaultInitExpr.classof(From);
  }

  public static CXXDefaultInitExpr cast_CXXDefaultInitExpr(Stmt/*P*/ From) {
    assert isa_CXXDefaultInitExpr(From);
    return (CXXDefaultInitExpr) From;
  }

  public static CXXDefaultInitExpr cast_or_null_CXXDefaultInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXDefaultInitExpr(From);
  }

  public static CXXDefaultInitExpr dyn_cast_CXXDefaultInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static CXXDefaultInitExpr dyn_cast_or_null_CXXDefaultInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXDefaultInitExpr(From) ? cast_CXXDefaultInitExpr(From) : null;
  }

  public static boolean isa_CXXDeleteExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDeleteExpr.class, From.$deref());
  }

  public static CXXDeleteExpr cast_CXXDeleteExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXDeleteExpr(From);
    return llvm.cast(CXXDeleteExpr.class, From.$deref());
  }

  public static CXXDeleteExpr cast_or_null_CXXDeleteExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDeleteExpr(From);
  }

  public static CXXDeleteExpr dyn_cast_CXXDeleteExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static CXXDeleteExpr dyn_cast_or_null_CXXDeleteExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static boolean isa_CXXDeleteExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDeleteExpr.class, From.$star());
  }

  public static CXXDeleteExpr cast_CXXDeleteExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXDeleteExpr(From);
    return llvm.cast(CXXDeleteExpr.class, From.$star());
  }

  public static CXXDeleteExpr cast_or_null_CXXDeleteExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDeleteExpr(From);
  }

  public static CXXDeleteExpr dyn_cast_CXXDeleteExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static CXXDeleteExpr dyn_cast_or_null_CXXDeleteExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static boolean isa_CXXDeleteExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXDeleteExpr.classof(From);
  }

  public static CXXDeleteExpr cast_CXXDeleteExpr(Stmt/*P*/ From) {
    assert isa_CXXDeleteExpr(From);
    return (CXXDeleteExpr) From;
  }

  public static CXXDeleteExpr cast_or_null_CXXDeleteExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXDeleteExpr(From);
  }

  public static CXXDeleteExpr dyn_cast_CXXDeleteExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static CXXDeleteExpr dyn_cast_or_null_CXXDeleteExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXDeleteExpr(From) ? cast_CXXDeleteExpr(From) : null;
  }

  public static boolean isa_CXXDependentScopeMemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXDependentScopeMemberExpr.classof(From);
  }

  public static CXXDependentScopeMemberExpr cast_CXXDependentScopeMemberExpr(Stmt/*P*/ From) {
    assert isa_CXXDependentScopeMemberExpr(From);
    return (CXXDependentScopeMemberExpr) From;
  }

  public static CXXDependentScopeMemberExpr cast_or_null_CXXDependentScopeMemberExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXDependentScopeMemberExpr(From);
  }

  public static CXXDependentScopeMemberExpr dyn_cast_CXXDependentScopeMemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static CXXDependentScopeMemberExpr dyn_cast_or_null_CXXDependentScopeMemberExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static boolean isa_CXXDependentScopeMemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDependentScopeMemberExpr.class, From.$deref());
  }

  public static CXXDependentScopeMemberExpr cast_CXXDependentScopeMemberExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXDependentScopeMemberExpr(From);
    return llvm.cast(CXXDependentScopeMemberExpr.class, From.$deref());
  }

  public static CXXDependentScopeMemberExpr cast_or_null_CXXDependentScopeMemberExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDependentScopeMemberExpr(From);
  }

  public static CXXDependentScopeMemberExpr dyn_cast_CXXDependentScopeMemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static CXXDependentScopeMemberExpr dyn_cast_or_null_CXXDependentScopeMemberExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static boolean isa_CXXDependentScopeMemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDependentScopeMemberExpr.class, From.$star());
  }

  public static CXXDependentScopeMemberExpr cast_CXXDependentScopeMemberExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXDependentScopeMemberExpr(From);
    return llvm.cast(CXXDependentScopeMemberExpr.class, From.$star());
  }

  public static CXXDependentScopeMemberExpr cast_or_null_CXXDependentScopeMemberExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDependentScopeMemberExpr(From);
  }

  public static CXXDependentScopeMemberExpr dyn_cast_CXXDependentScopeMemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static CXXDependentScopeMemberExpr dyn_cast_or_null_CXXDependentScopeMemberExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDependentScopeMemberExpr(From) ? cast_CXXDependentScopeMemberExpr(From) : null;
  }

  public static boolean isa_CXXDynamicCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXDynamicCastExpr.classof(From);
  }

  public static CXXDynamicCastExpr cast_CXXDynamicCastExpr(Stmt/*P*/ From) {
    assert isa_CXXDynamicCastExpr(From);
    return (CXXDynamicCastExpr) From;
  }

  public static CXXDynamicCastExpr cast_or_null_CXXDynamicCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXDynamicCastExpr(From);
  }

  public static CXXDynamicCastExpr dyn_cast_CXXDynamicCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static CXXDynamicCastExpr dyn_cast_or_null_CXXDynamicCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static boolean isa_CXXDynamicCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDynamicCastExpr.class, From.$star());
  }

  public static CXXDynamicCastExpr cast_CXXDynamicCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXDynamicCastExpr(From);
    return llvm.cast(CXXDynamicCastExpr.class, From.$star());
  }

  public static CXXDynamicCastExpr cast_or_null_CXXDynamicCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDynamicCastExpr(From);
  }

  public static CXXDynamicCastExpr dyn_cast_CXXDynamicCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static CXXDynamicCastExpr dyn_cast_or_null_CXXDynamicCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static boolean isa_CXXDynamicCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDynamicCastExpr.class, From.$deref());
  }

  public static CXXDynamicCastExpr cast_CXXDynamicCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXDynamicCastExpr(From);
    return llvm.cast(CXXDynamicCastExpr.class, From.$deref());
  }

  public static CXXDynamicCastExpr cast_or_null_CXXDynamicCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDynamicCastExpr(From);
  }

  public static CXXDynamicCastExpr dyn_cast_CXXDynamicCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static CXXDynamicCastExpr dyn_cast_or_null_CXXDynamicCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDynamicCastExpr(From) ? cast_CXXDynamicCastExpr(From) : null;
  }

  public static boolean isa_CXXFoldExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXFoldExpr.classof(From);
  }

  public static CXXFoldExpr cast_CXXFoldExpr(Stmt/*P*/ From) {
    assert isa_CXXFoldExpr(From);
    return (CXXFoldExpr) From;
  }

  public static CXXFoldExpr cast_or_null_CXXFoldExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXFoldExpr(From);
  }

  public static CXXFoldExpr dyn_cast_CXXFoldExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static CXXFoldExpr dyn_cast_or_null_CXXFoldExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static boolean isa_CXXFoldExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXFoldExpr.class, From.$deref());
  }

  public static CXXFoldExpr cast_CXXFoldExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXFoldExpr(From);
    return llvm.cast(CXXFoldExpr.class, From.$deref());
  }

  public static CXXFoldExpr cast_or_null_CXXFoldExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXFoldExpr(From);
  }

  public static CXXFoldExpr dyn_cast_CXXFoldExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static CXXFoldExpr dyn_cast_or_null_CXXFoldExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static boolean isa_CXXFoldExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXFoldExpr.class, From.$star());
  }

  public static CXXFoldExpr cast_CXXFoldExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXFoldExpr(From);
    return llvm.cast(CXXFoldExpr.class, From.$star());
  }

  public static CXXFoldExpr cast_or_null_CXXFoldExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXFoldExpr(From);
  }

  public static CXXFoldExpr dyn_cast_CXXFoldExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static CXXFoldExpr dyn_cast_or_null_CXXFoldExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXFoldExpr(From) ? cast_CXXFoldExpr(From) : null;
  }

  public static boolean isa_CXXFunctionalCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXFunctionalCastExpr.class, From.$deref());
  }

  public static CXXFunctionalCastExpr cast_CXXFunctionalCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXFunctionalCastExpr(From);
    return llvm.cast(CXXFunctionalCastExpr.class, From.$deref());
  }

  public static CXXFunctionalCastExpr cast_or_null_CXXFunctionalCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXFunctionalCastExpr(From);
  }

  public static CXXFunctionalCastExpr dyn_cast_CXXFunctionalCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static CXXFunctionalCastExpr dyn_cast_or_null_CXXFunctionalCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static boolean isa_CXXFunctionalCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXFunctionalCastExpr.class, From.$star());
  }

  public static CXXFunctionalCastExpr cast_CXXFunctionalCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXFunctionalCastExpr(From);
    return llvm.cast(CXXFunctionalCastExpr.class, From.$star());
  }

  public static CXXFunctionalCastExpr cast_or_null_CXXFunctionalCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXFunctionalCastExpr(From);
  }

  public static CXXFunctionalCastExpr dyn_cast_CXXFunctionalCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static CXXFunctionalCastExpr dyn_cast_or_null_CXXFunctionalCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static boolean isa_CXXFunctionalCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXFunctionalCastExpr.classof(From);
  }

  public static CXXFunctionalCastExpr cast_CXXFunctionalCastExpr(Stmt/*P*/ From) {
    assert isa_CXXFunctionalCastExpr(From);
    return (CXXFunctionalCastExpr) From;
  }

  public static CXXFunctionalCastExpr cast_or_null_CXXFunctionalCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXFunctionalCastExpr(From);
  }

  public static CXXFunctionalCastExpr dyn_cast_CXXFunctionalCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static CXXFunctionalCastExpr dyn_cast_or_null_CXXFunctionalCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXFunctionalCastExpr(From) ? cast_CXXFunctionalCastExpr(From) : null;
  }

  public static boolean isa_CXXInheritedCtorInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXInheritedCtorInitExpr.class, From.$star());
  }

  public static CXXInheritedCtorInitExpr cast_CXXInheritedCtorInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXInheritedCtorInitExpr(From);
    return llvm.cast(CXXInheritedCtorInitExpr.class, From.$star());
  }

  public static CXXInheritedCtorInitExpr cast_or_null_CXXInheritedCtorInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXInheritedCtorInitExpr(From);
  }

  public static CXXInheritedCtorInitExpr dyn_cast_CXXInheritedCtorInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static CXXInheritedCtorInitExpr dyn_cast_or_null_CXXInheritedCtorInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static boolean isa_CXXInheritedCtorInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXInheritedCtorInitExpr.class, From.$deref());
  }

  public static CXXInheritedCtorInitExpr cast_CXXInheritedCtorInitExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXInheritedCtorInitExpr(From);
    return llvm.cast(CXXInheritedCtorInitExpr.class, From.$deref());
  }

  public static CXXInheritedCtorInitExpr cast_or_null_CXXInheritedCtorInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXInheritedCtorInitExpr(From);
  }

  public static CXXInheritedCtorInitExpr dyn_cast_CXXInheritedCtorInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static CXXInheritedCtorInitExpr dyn_cast_or_null_CXXInheritedCtorInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static boolean isa_CXXInheritedCtorInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXInheritedCtorInitExpr.classof(From);
  }

  public static CXXInheritedCtorInitExpr cast_CXXInheritedCtorInitExpr(Stmt/*P*/ From) {
    assert isa_CXXInheritedCtorInitExpr(From);
    return (CXXInheritedCtorInitExpr) From;
  }

  public static CXXInheritedCtorInitExpr cast_or_null_CXXInheritedCtorInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXInheritedCtorInitExpr(From);
  }

  public static CXXInheritedCtorInitExpr dyn_cast_CXXInheritedCtorInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static CXXInheritedCtorInitExpr dyn_cast_or_null_CXXInheritedCtorInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXInheritedCtorInitExpr(From) ? cast_CXXInheritedCtorInitExpr(From) : null;
  }

  public static boolean isa_CXXMemberCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXMemberCallExpr.classof(From);
  }

  public static CXXMemberCallExpr cast_CXXMemberCallExpr(Stmt/*P*/ From) {
    assert isa_CXXMemberCallExpr(From);
    return (CXXMemberCallExpr) From;
  }

  public static CXXMemberCallExpr cast_or_null_CXXMemberCallExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXMemberCallExpr(From);
  }

  public static CXXMemberCallExpr dyn_cast_CXXMemberCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static CXXMemberCallExpr dyn_cast_or_null_CXXMemberCallExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static boolean isa_CXXMemberCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXMemberCallExpr.class, From.$star());
  }

  public static CXXMemberCallExpr cast_CXXMemberCallExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXMemberCallExpr(From);
    return llvm.cast(CXXMemberCallExpr.class, From.$star());
  }

  public static CXXMemberCallExpr cast_or_null_CXXMemberCallExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXMemberCallExpr(From);
  }

  public static CXXMemberCallExpr dyn_cast_CXXMemberCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static CXXMemberCallExpr dyn_cast_or_null_CXXMemberCallExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static boolean isa_CXXMemberCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXMemberCallExpr.class, From.$deref());
  }

  public static CXXMemberCallExpr cast_CXXMemberCallExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXMemberCallExpr(From);
    return llvm.cast(CXXMemberCallExpr.class, From.$deref());
  }

  public static CXXMemberCallExpr cast_or_null_CXXMemberCallExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXMemberCallExpr(From);
  }

  public static CXXMemberCallExpr dyn_cast_CXXMemberCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static CXXMemberCallExpr dyn_cast_or_null_CXXMemberCallExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXMemberCallExpr(From) ? cast_CXXMemberCallExpr(From) : null;
  }

  public static boolean isa_CXXNamedCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXNamedCastExpr.class, From.$star());
  }

  public static CXXNamedCastExpr cast_CXXNamedCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXNamedCastExpr(From);
    return llvm.cast(CXXNamedCastExpr.class, From.$star());
  }

  public static CXXNamedCastExpr cast_or_null_CXXNamedCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXNamedCastExpr(From);
  }

  public static CXXNamedCastExpr dyn_cast_CXXNamedCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static CXXNamedCastExpr dyn_cast_or_null_CXXNamedCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static boolean isa_CXXNamedCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXNamedCastExpr.classof(From);
  }

  public static CXXNamedCastExpr cast_CXXNamedCastExpr(Stmt/*P*/ From) {
    assert isa_CXXNamedCastExpr(From);
    return (CXXNamedCastExpr) From;
  }

  public static CXXNamedCastExpr cast_or_null_CXXNamedCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXNamedCastExpr(From);
  }

  public static CXXNamedCastExpr dyn_cast_CXXNamedCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static CXXNamedCastExpr dyn_cast_or_null_CXXNamedCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static boolean isa_CXXNamedCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXNamedCastExpr.class, From.$deref());
  }

  public static CXXNamedCastExpr cast_CXXNamedCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXNamedCastExpr(From);
    return llvm.cast(CXXNamedCastExpr.class, From.$deref());
  }

  public static CXXNamedCastExpr cast_or_null_CXXNamedCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXNamedCastExpr(From);
  }

  public static CXXNamedCastExpr dyn_cast_CXXNamedCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static CXXNamedCastExpr dyn_cast_or_null_CXXNamedCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXNamedCastExpr(From) ? cast_CXXNamedCastExpr(From) : null;
  }

  public static boolean isa_CXXNewExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXNewExpr.class, From.$deref());
  }

  public static CXXNewExpr cast_CXXNewExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXNewExpr(From);
    return llvm.cast(CXXNewExpr.class, From.$deref());
  }

  public static CXXNewExpr cast_or_null_CXXNewExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXNewExpr(From);
  }

  public static CXXNewExpr dyn_cast_CXXNewExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static CXXNewExpr dyn_cast_or_null_CXXNewExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static boolean isa_CXXNewExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXNewExpr.class, From.$star());
  }

  public static CXXNewExpr cast_CXXNewExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXNewExpr(From);
    return llvm.cast(CXXNewExpr.class, From.$star());
  }

  public static CXXNewExpr cast_or_null_CXXNewExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXNewExpr(From);
  }

  public static CXXNewExpr dyn_cast_CXXNewExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static CXXNewExpr dyn_cast_or_null_CXXNewExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static boolean isa_CXXNewExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXNewExpr.classof(From);
  }

  public static CXXNewExpr cast_CXXNewExpr(Stmt/*P*/ From) {
    assert isa_CXXNewExpr(From);
    return (CXXNewExpr) From;
  }

  public static CXXNewExpr cast_or_null_CXXNewExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXNewExpr(From);
  }

  public static CXXNewExpr dyn_cast_CXXNewExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static CXXNewExpr dyn_cast_or_null_CXXNewExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXNewExpr(From) ? cast_CXXNewExpr(From) : null;
  }

  public static boolean isa_CXXNoexceptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXNoexceptExpr.class, From.$star());
  }

  public static CXXNoexceptExpr cast_CXXNoexceptExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXNoexceptExpr(From);
    return llvm.cast(CXXNoexceptExpr.class, From.$star());
  }

  public static CXXNoexceptExpr cast_or_null_CXXNoexceptExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXNoexceptExpr(From);
  }

  public static CXXNoexceptExpr dyn_cast_CXXNoexceptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static CXXNoexceptExpr dyn_cast_or_null_CXXNoexceptExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static boolean isa_CXXNoexceptExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXNoexceptExpr.classof(From);
  }

  public static CXXNoexceptExpr cast_CXXNoexceptExpr(Stmt/*P*/ From) {
    assert isa_CXXNoexceptExpr(From);
    return (CXXNoexceptExpr) From;
  }

  public static CXXNoexceptExpr cast_or_null_CXXNoexceptExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXNoexceptExpr(From);
  }

  public static CXXNoexceptExpr dyn_cast_CXXNoexceptExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static CXXNoexceptExpr dyn_cast_or_null_CXXNoexceptExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static boolean isa_CXXNoexceptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXNoexceptExpr.class, From.$deref());
  }

  public static CXXNoexceptExpr cast_CXXNoexceptExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXNoexceptExpr(From);
    return llvm.cast(CXXNoexceptExpr.class, From.$deref());
  }

  public static CXXNoexceptExpr cast_or_null_CXXNoexceptExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXNoexceptExpr(From);
  }

  public static CXXNoexceptExpr dyn_cast_CXXNoexceptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static CXXNoexceptExpr dyn_cast_or_null_CXXNoexceptExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXNoexceptExpr(From) ? cast_CXXNoexceptExpr(From) : null;
  }

  public static boolean isa_CXXNullPtrLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXNullPtrLiteralExpr.classof(From);
  }

  public static CXXNullPtrLiteralExpr cast_CXXNullPtrLiteralExpr(Stmt/*P*/ From) {
    assert isa_CXXNullPtrLiteralExpr(From);
    return (CXXNullPtrLiteralExpr) From;
  }

  public static CXXNullPtrLiteralExpr cast_or_null_CXXNullPtrLiteralExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXNullPtrLiteralExpr(From);
  }

  public static CXXNullPtrLiteralExpr dyn_cast_CXXNullPtrLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static CXXNullPtrLiteralExpr dyn_cast_or_null_CXXNullPtrLiteralExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static boolean isa_CXXNullPtrLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXNullPtrLiteralExpr.class, From.$star());
  }

  public static CXXNullPtrLiteralExpr cast_CXXNullPtrLiteralExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXNullPtrLiteralExpr(From);
    return llvm.cast(CXXNullPtrLiteralExpr.class, From.$star());
  }

  public static CXXNullPtrLiteralExpr cast_or_null_CXXNullPtrLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXNullPtrLiteralExpr(From);
  }

  public static CXXNullPtrLiteralExpr dyn_cast_CXXNullPtrLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static CXXNullPtrLiteralExpr dyn_cast_or_null_CXXNullPtrLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static boolean isa_CXXNullPtrLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXNullPtrLiteralExpr.class, From.$deref());
  }

  public static CXXNullPtrLiteralExpr cast_CXXNullPtrLiteralExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXNullPtrLiteralExpr(From);
    return llvm.cast(CXXNullPtrLiteralExpr.class, From.$deref());
  }

  public static CXXNullPtrLiteralExpr cast_or_null_CXXNullPtrLiteralExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXNullPtrLiteralExpr(From);
  }

  public static CXXNullPtrLiteralExpr dyn_cast_CXXNullPtrLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static CXXNullPtrLiteralExpr dyn_cast_or_null_CXXNullPtrLiteralExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXNullPtrLiteralExpr(From) ? cast_CXXNullPtrLiteralExpr(From) : null;
  }

  public static boolean isa_CXXOperatorCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXOperatorCallExpr.class, From.$star());
  }

  public static CXXOperatorCallExpr cast_CXXOperatorCallExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXOperatorCallExpr(From);
    return llvm.cast(CXXOperatorCallExpr.class, From.$star());
  }

  public static CXXOperatorCallExpr cast_or_null_CXXOperatorCallExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXOperatorCallExpr(From);
  }

  public static CXXOperatorCallExpr dyn_cast_CXXOperatorCallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static CXXOperatorCallExpr dyn_cast_or_null_CXXOperatorCallExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static boolean isa_CXXOperatorCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXOperatorCallExpr.classof(From);
  }

  public static CXXOperatorCallExpr cast_CXXOperatorCallExpr(Stmt/*P*/ From) {
    assert isa_CXXOperatorCallExpr(From);
    return (CXXOperatorCallExpr) From;
  }

  public static CXXOperatorCallExpr cast_or_null_CXXOperatorCallExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXOperatorCallExpr(From);
  }

  public static CXXOperatorCallExpr dyn_cast_CXXOperatorCallExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static CXXOperatorCallExpr dyn_cast_or_null_CXXOperatorCallExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static boolean isa_CXXOperatorCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXOperatorCallExpr.class, From.$deref());
  }

  public static CXXOperatorCallExpr cast_CXXOperatorCallExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXOperatorCallExpr(From);
    return llvm.cast(CXXOperatorCallExpr.class, From.$deref());
  }

  public static CXXOperatorCallExpr cast_or_null_CXXOperatorCallExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXOperatorCallExpr(From);
  }

  public static CXXOperatorCallExpr dyn_cast_CXXOperatorCallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static CXXOperatorCallExpr dyn_cast_or_null_CXXOperatorCallExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXOperatorCallExpr(From) ? cast_CXXOperatorCallExpr(From) : null;
  }

  public static boolean isa_CXXPseudoDestructorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXPseudoDestructorExpr.class, From.$star());
  }

  public static CXXPseudoDestructorExpr cast_CXXPseudoDestructorExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXPseudoDestructorExpr(From);
    return llvm.cast(CXXPseudoDestructorExpr.class, From.$star());
  }

  public static CXXPseudoDestructorExpr cast_or_null_CXXPseudoDestructorExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXPseudoDestructorExpr(From);
  }

  public static CXXPseudoDestructorExpr dyn_cast_CXXPseudoDestructorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static CXXPseudoDestructorExpr dyn_cast_or_null_CXXPseudoDestructorExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static boolean isa_CXXPseudoDestructorExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXPseudoDestructorExpr.classof(From);
  }

  public static CXXPseudoDestructorExpr cast_CXXPseudoDestructorExpr(Stmt/*P*/ From) {
    assert isa_CXXPseudoDestructorExpr(From);
    return (CXXPseudoDestructorExpr) From;
  }

  public static CXXPseudoDestructorExpr cast_or_null_CXXPseudoDestructorExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXPseudoDestructorExpr(From);
  }

  public static CXXPseudoDestructorExpr dyn_cast_CXXPseudoDestructorExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static CXXPseudoDestructorExpr dyn_cast_or_null_CXXPseudoDestructorExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static boolean isa_CXXPseudoDestructorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXPseudoDestructorExpr.class, From.$deref());
  }

  public static CXXPseudoDestructorExpr cast_CXXPseudoDestructorExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXPseudoDestructorExpr(From);
    return llvm.cast(CXXPseudoDestructorExpr.class, From.$deref());
  }

  public static CXXPseudoDestructorExpr cast_or_null_CXXPseudoDestructorExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXPseudoDestructorExpr(From);
  }

  public static CXXPseudoDestructorExpr dyn_cast_CXXPseudoDestructorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static CXXPseudoDestructorExpr dyn_cast_or_null_CXXPseudoDestructorExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXPseudoDestructorExpr(From) ? cast_CXXPseudoDestructorExpr(From) : null;
  }

  public static boolean isa_CXXReinterpretCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXReinterpretCastExpr.class, From.$deref());
  }

  public static CXXReinterpretCastExpr cast_CXXReinterpretCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXReinterpretCastExpr(From);
    return llvm.cast(CXXReinterpretCastExpr.class, From.$deref());
  }

  public static CXXReinterpretCastExpr cast_or_null_CXXReinterpretCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXReinterpretCastExpr(From);
  }

  public static CXXReinterpretCastExpr dyn_cast_CXXReinterpretCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static CXXReinterpretCastExpr dyn_cast_or_null_CXXReinterpretCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static boolean isa_CXXReinterpretCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXReinterpretCastExpr.class, From.$star());
  }

  public static CXXReinterpretCastExpr cast_CXXReinterpretCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXReinterpretCastExpr(From);
    return llvm.cast(CXXReinterpretCastExpr.class, From.$star());
  }

  public static CXXReinterpretCastExpr cast_or_null_CXXReinterpretCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXReinterpretCastExpr(From);
  }

  public static CXXReinterpretCastExpr dyn_cast_CXXReinterpretCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static CXXReinterpretCastExpr dyn_cast_or_null_CXXReinterpretCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static boolean isa_CXXReinterpretCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXReinterpretCastExpr.classof(From);
  }

  public static CXXReinterpretCastExpr cast_CXXReinterpretCastExpr(Stmt/*P*/ From) {
    assert isa_CXXReinterpretCastExpr(From);
    return (CXXReinterpretCastExpr) From;
  }

  public static CXXReinterpretCastExpr cast_or_null_CXXReinterpretCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXReinterpretCastExpr(From);
  }

  public static CXXReinterpretCastExpr dyn_cast_CXXReinterpretCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static CXXReinterpretCastExpr dyn_cast_or_null_CXXReinterpretCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXReinterpretCastExpr(From) ? cast_CXXReinterpretCastExpr(From) : null;
  }

  public static boolean isa_CXXScalarValueInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXScalarValueInitExpr.classof(From);
  }

  public static CXXScalarValueInitExpr cast_CXXScalarValueInitExpr(Stmt/*P*/ From) {
    assert isa_CXXScalarValueInitExpr(From);
    return (CXXScalarValueInitExpr) From;
  }

  public static CXXScalarValueInitExpr cast_or_null_CXXScalarValueInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXScalarValueInitExpr(From);
  }

  public static CXXScalarValueInitExpr dyn_cast_CXXScalarValueInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static CXXScalarValueInitExpr dyn_cast_or_null_CXXScalarValueInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static boolean isa_CXXScalarValueInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXScalarValueInitExpr.class, From.$deref());
  }

  public static CXXScalarValueInitExpr cast_CXXScalarValueInitExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXScalarValueInitExpr(From);
    return llvm.cast(CXXScalarValueInitExpr.class, From.$deref());
  }

  public static CXXScalarValueInitExpr cast_or_null_CXXScalarValueInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXScalarValueInitExpr(From);
  }

  public static CXXScalarValueInitExpr dyn_cast_CXXScalarValueInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static CXXScalarValueInitExpr dyn_cast_or_null_CXXScalarValueInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static boolean isa_CXXScalarValueInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXScalarValueInitExpr.class, From.$star());
  }

  public static CXXScalarValueInitExpr cast_CXXScalarValueInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXScalarValueInitExpr(From);
    return llvm.cast(CXXScalarValueInitExpr.class, From.$star());
  }

  public static CXXScalarValueInitExpr cast_or_null_CXXScalarValueInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXScalarValueInitExpr(From);
  }

  public static CXXScalarValueInitExpr dyn_cast_CXXScalarValueInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static CXXScalarValueInitExpr dyn_cast_or_null_CXXScalarValueInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXScalarValueInitExpr(From) ? cast_CXXScalarValueInitExpr(From) : null;
  }

  public static boolean isa_CXXStaticCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXStaticCastExpr.class, From.$deref());
  }

  public static CXXStaticCastExpr cast_CXXStaticCastExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXStaticCastExpr(From);
    return llvm.cast(CXXStaticCastExpr.class, From.$deref());
  }

  public static CXXStaticCastExpr cast_or_null_CXXStaticCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXStaticCastExpr(From);
  }

  public static CXXStaticCastExpr dyn_cast_CXXStaticCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static CXXStaticCastExpr dyn_cast_or_null_CXXStaticCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static boolean isa_CXXStaticCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXStaticCastExpr.classof(From);
  }

  public static CXXStaticCastExpr cast_CXXStaticCastExpr(Stmt/*P*/ From) {
    assert isa_CXXStaticCastExpr(From);
    return (CXXStaticCastExpr) From;
  }

  public static CXXStaticCastExpr cast_or_null_CXXStaticCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXStaticCastExpr(From);
  }

  public static CXXStaticCastExpr dyn_cast_CXXStaticCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static CXXStaticCastExpr dyn_cast_or_null_CXXStaticCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static boolean isa_CXXStaticCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXStaticCastExpr.class, From.$star());
  }

  public static CXXStaticCastExpr cast_CXXStaticCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXStaticCastExpr(From);
    return llvm.cast(CXXStaticCastExpr.class, From.$star());
  }

  public static CXXStaticCastExpr cast_or_null_CXXStaticCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXStaticCastExpr(From);
  }

  public static CXXStaticCastExpr dyn_cast_CXXStaticCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static CXXStaticCastExpr dyn_cast_or_null_CXXStaticCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXStaticCastExpr(From) ? cast_CXXStaticCastExpr(From) : null;
  }

  public static boolean isa_CXXStdInitializerListExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXStdInitializerListExpr.classof(From);
  }

  public static CXXStdInitializerListExpr cast_CXXStdInitializerListExpr(Stmt/*P*/ From) {
    assert isa_CXXStdInitializerListExpr(From);
    return (CXXStdInitializerListExpr) From;
  }

  public static CXXStdInitializerListExpr cast_or_null_CXXStdInitializerListExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXStdInitializerListExpr(From);
  }

  public static CXXStdInitializerListExpr dyn_cast_CXXStdInitializerListExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static CXXStdInitializerListExpr dyn_cast_or_null_CXXStdInitializerListExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static boolean isa_CXXStdInitializerListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXStdInitializerListExpr.class, From.$star());
  }

  public static CXXStdInitializerListExpr cast_CXXStdInitializerListExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXStdInitializerListExpr(From);
    return llvm.cast(CXXStdInitializerListExpr.class, From.$star());
  }

  public static CXXStdInitializerListExpr cast_or_null_CXXStdInitializerListExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXStdInitializerListExpr(From);
  }

  public static CXXStdInitializerListExpr dyn_cast_CXXStdInitializerListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static CXXStdInitializerListExpr dyn_cast_or_null_CXXStdInitializerListExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static boolean isa_CXXStdInitializerListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXStdInitializerListExpr.class, From.$deref());
  }

  public static CXXStdInitializerListExpr cast_CXXStdInitializerListExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXStdInitializerListExpr(From);
    return llvm.cast(CXXStdInitializerListExpr.class, From.$deref());
  }

  public static CXXStdInitializerListExpr cast_or_null_CXXStdInitializerListExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXStdInitializerListExpr(From);
  }

  public static CXXStdInitializerListExpr dyn_cast_CXXStdInitializerListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static CXXStdInitializerListExpr dyn_cast_or_null_CXXStdInitializerListExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXStdInitializerListExpr(From) ? cast_CXXStdInitializerListExpr(From) : null;
  }

  public static boolean isa_CXXTemporaryObjectExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXTemporaryObjectExpr.class, From.$star());
  }

  public static CXXTemporaryObjectExpr cast_CXXTemporaryObjectExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXTemporaryObjectExpr(From);
    return llvm.cast(CXXTemporaryObjectExpr.class, From.$star());
  }

  public static CXXTemporaryObjectExpr cast_or_null_CXXTemporaryObjectExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXTemporaryObjectExpr(From);
  }

  public static CXXTemporaryObjectExpr dyn_cast_CXXTemporaryObjectExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static CXXTemporaryObjectExpr dyn_cast_or_null_CXXTemporaryObjectExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static boolean isa_CXXTemporaryObjectExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXTemporaryObjectExpr.classof(From);
  }

  public static CXXTemporaryObjectExpr cast_CXXTemporaryObjectExpr(Stmt/*P*/ From) {
    assert isa_CXXTemporaryObjectExpr(From);
    return (CXXTemporaryObjectExpr) From;
  }

  public static CXXTemporaryObjectExpr cast_or_null_CXXTemporaryObjectExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXTemporaryObjectExpr(From);
  }

  public static CXXTemporaryObjectExpr dyn_cast_CXXTemporaryObjectExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static CXXTemporaryObjectExpr dyn_cast_or_null_CXXTemporaryObjectExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static boolean isa_CXXTemporaryObjectExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXTemporaryObjectExpr.class, From.$deref());
  }

  public static CXXTemporaryObjectExpr cast_CXXTemporaryObjectExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXTemporaryObjectExpr(From);
    return llvm.cast(CXXTemporaryObjectExpr.class, From.$deref());
  }

  public static CXXTemporaryObjectExpr cast_or_null_CXXTemporaryObjectExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXTemporaryObjectExpr(From);
  }

  public static CXXTemporaryObjectExpr dyn_cast_CXXTemporaryObjectExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static CXXTemporaryObjectExpr dyn_cast_or_null_CXXTemporaryObjectExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXTemporaryObjectExpr(From) ? cast_CXXTemporaryObjectExpr(From) : null;
  }

  public static boolean isa_CXXThisExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXThisExpr.class, From.$deref());
  }

  public static CXXThisExpr cast_CXXThisExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXThisExpr(From);
    return llvm.cast(CXXThisExpr.class, From.$deref());
  }

  public static CXXThisExpr cast_or_null_CXXThisExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXThisExpr(From);
  }

  public static CXXThisExpr dyn_cast_CXXThisExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static CXXThisExpr dyn_cast_or_null_CXXThisExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static boolean isa_CXXThisExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXThisExpr.class, From.$star());
  }

  public static CXXThisExpr cast_CXXThisExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXThisExpr(From);
    return llvm.cast(CXXThisExpr.class, From.$star());
  }

  public static CXXThisExpr cast_or_null_CXXThisExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXThisExpr(From);
  }

  public static CXXThisExpr dyn_cast_CXXThisExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static CXXThisExpr dyn_cast_or_null_CXXThisExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static boolean isa_CXXThisExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXThisExpr.classof(From);
  }

  public static CXXThisExpr cast_CXXThisExpr(Stmt/*P*/ From) {
    assert isa_CXXThisExpr(From);
    return (CXXThisExpr) From;
  }

  public static CXXThisExpr cast_or_null_CXXThisExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXThisExpr(From);
  }

  public static CXXThisExpr dyn_cast_CXXThisExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static CXXThisExpr dyn_cast_or_null_CXXThisExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXThisExpr(From) ? cast_CXXThisExpr(From) : null;
  }

  public static boolean isa_CXXThrowExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXThrowExpr.classof(From);
  }

  public static CXXThrowExpr cast_CXXThrowExpr(Stmt/*P*/ From) {
    assert isa_CXXThrowExpr(From);
    return (CXXThrowExpr) From;
  }

  public static CXXThrowExpr cast_or_null_CXXThrowExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXThrowExpr(From);
  }

  public static CXXThrowExpr dyn_cast_CXXThrowExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static CXXThrowExpr dyn_cast_or_null_CXXThrowExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static boolean isa_CXXThrowExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXThrowExpr.class, From.$deref());
  }

  public static CXXThrowExpr cast_CXXThrowExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXThrowExpr(From);
    return llvm.cast(CXXThrowExpr.class, From.$deref());
  }

  public static CXXThrowExpr cast_or_null_CXXThrowExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXThrowExpr(From);
  }

  public static CXXThrowExpr dyn_cast_CXXThrowExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static CXXThrowExpr dyn_cast_or_null_CXXThrowExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static boolean isa_CXXThrowExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXThrowExpr.class, From.$star());
  }

  public static CXXThrowExpr cast_CXXThrowExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXThrowExpr(From);
    return llvm.cast(CXXThrowExpr.class, From.$star());
  }

  public static CXXThrowExpr cast_or_null_CXXThrowExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXThrowExpr(From);
  }

  public static CXXThrowExpr dyn_cast_CXXThrowExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static CXXThrowExpr dyn_cast_or_null_CXXThrowExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXThrowExpr(From) ? cast_CXXThrowExpr(From) : null;
  }

  public static boolean isa_CXXTypeidExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXTypeidExpr.class, From.$deref());
  }

  public static CXXTypeidExpr cast_CXXTypeidExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXTypeidExpr(From);
    return llvm.cast(CXXTypeidExpr.class, From.$deref());
  }

  public static CXXTypeidExpr cast_or_null_CXXTypeidExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXTypeidExpr(From);
  }

  public static CXXTypeidExpr dyn_cast_CXXTypeidExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static CXXTypeidExpr dyn_cast_or_null_CXXTypeidExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static boolean isa_CXXTypeidExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXTypeidExpr.classof(From);
  }

  public static CXXTypeidExpr cast_CXXTypeidExpr(Stmt/*P*/ From) {
    assert isa_CXXTypeidExpr(From);
    return (CXXTypeidExpr) From;
  }

  public static CXXTypeidExpr cast_or_null_CXXTypeidExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXTypeidExpr(From);
  }

  public static CXXTypeidExpr dyn_cast_CXXTypeidExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static CXXTypeidExpr dyn_cast_or_null_CXXTypeidExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static boolean isa_CXXTypeidExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXTypeidExpr.class, From.$star());
  }

  public static CXXTypeidExpr cast_CXXTypeidExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXTypeidExpr(From);
    return llvm.cast(CXXTypeidExpr.class, From.$star());
  }

  public static CXXTypeidExpr cast_or_null_CXXTypeidExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXTypeidExpr(From);
  }

  public static CXXTypeidExpr dyn_cast_CXXTypeidExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static CXXTypeidExpr dyn_cast_or_null_CXXTypeidExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXTypeidExpr(From) ? cast_CXXTypeidExpr(From) : null;
  }

  public static boolean isa_CXXUnresolvedConstructExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXUnresolvedConstructExpr.class, From.$deref());
  }

  public static CXXUnresolvedConstructExpr cast_CXXUnresolvedConstructExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXUnresolvedConstructExpr(From);
    return llvm.cast(CXXUnresolvedConstructExpr.class, From.$deref());
  }

  public static CXXUnresolvedConstructExpr cast_or_null_CXXUnresolvedConstructExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXUnresolvedConstructExpr(From);
  }

  public static CXXUnresolvedConstructExpr dyn_cast_CXXUnresolvedConstructExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static CXXUnresolvedConstructExpr dyn_cast_or_null_CXXUnresolvedConstructExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static boolean isa_CXXUnresolvedConstructExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXUnresolvedConstructExpr.classof(From);
  }

  public static CXXUnresolvedConstructExpr cast_CXXUnresolvedConstructExpr(Stmt/*P*/ From) {
    assert isa_CXXUnresolvedConstructExpr(From);
    return (CXXUnresolvedConstructExpr) From;
  }

  public static CXXUnresolvedConstructExpr cast_or_null_CXXUnresolvedConstructExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXUnresolvedConstructExpr(From);
  }

  public static CXXUnresolvedConstructExpr dyn_cast_CXXUnresolvedConstructExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static CXXUnresolvedConstructExpr dyn_cast_or_null_CXXUnresolvedConstructExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static boolean isa_CXXUnresolvedConstructExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXUnresolvedConstructExpr.class, From.$star());
  }

  public static CXXUnresolvedConstructExpr cast_CXXUnresolvedConstructExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXUnresolvedConstructExpr(From);
    return llvm.cast(CXXUnresolvedConstructExpr.class, From.$star());
  }

  public static CXXUnresolvedConstructExpr cast_or_null_CXXUnresolvedConstructExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXUnresolvedConstructExpr(From);
  }

  public static CXXUnresolvedConstructExpr dyn_cast_CXXUnresolvedConstructExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static CXXUnresolvedConstructExpr dyn_cast_or_null_CXXUnresolvedConstructExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXUnresolvedConstructExpr(From) ? cast_CXXUnresolvedConstructExpr(From) : null;
  }

  public static boolean isa_CXXUuidofExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXUuidofExpr.class, From.$star());
  }

  public static CXXUuidofExpr cast_CXXUuidofExpr(type$ptr<?>/*P*/ From) {
    assert isa_CXXUuidofExpr(From);
    return llvm.cast(CXXUuidofExpr.class, From.$star());
  }

  public static CXXUuidofExpr cast_or_null_CXXUuidofExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXUuidofExpr(From);
  }

  public static CXXUuidofExpr dyn_cast_CXXUuidofExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static CXXUuidofExpr dyn_cast_or_null_CXXUuidofExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static boolean isa_CXXUuidofExpr(Stmt/*P*/ From) {
    assert From != null;
    return CXXUuidofExpr.classof(From);
  }

  public static CXXUuidofExpr cast_CXXUuidofExpr(Stmt/*P*/ From) {
    assert isa_CXXUuidofExpr(From);
    return (CXXUuidofExpr) From;
  }

  public static CXXUuidofExpr cast_or_null_CXXUuidofExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CXXUuidofExpr(From);
  }

  public static CXXUuidofExpr dyn_cast_CXXUuidofExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static CXXUuidofExpr dyn_cast_or_null_CXXUuidofExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static boolean isa_CXXUuidofExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXUuidofExpr.class, From.$deref());
  }

  public static CXXUuidofExpr cast_CXXUuidofExpr(type$ref<?>/*P*/ From) {
    assert isa_CXXUuidofExpr(From);
    return llvm.cast(CXXUuidofExpr.class, From.$deref());
  }

  public static CXXUuidofExpr cast_or_null_CXXUuidofExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXUuidofExpr(From);
  }

  public static CXXUuidofExpr dyn_cast_CXXUuidofExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static CXXUuidofExpr dyn_cast_or_null_CXXUuidofExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXUuidofExpr(From) ? cast_CXXUuidofExpr(From) : null;
  }

  public static boolean isa_CallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CallExpr.class, From.$deref());
  }

  public static CallExpr cast_CallExpr(type$ref<?>/*P*/ From) {
    assert isa_CallExpr(From);
    return llvm.cast(CallExpr.class, From.$deref());
  }

  public static CallExpr cast_or_null_CallExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CallExpr(From);
  }

  public static CallExpr dyn_cast_CallExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static CallExpr dyn_cast_or_null_CallExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static boolean isa_CallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CallExpr.class, From.$star());
  }

  public static CallExpr cast_CallExpr(type$ptr<?>/*P*/ From) {
    assert isa_CallExpr(From);
    return llvm.cast(CallExpr.class, From.$star());
  }

  public static CallExpr cast_or_null_CallExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CallExpr(From);
  }

  public static CallExpr dyn_cast_CallExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static CallExpr dyn_cast_or_null_CallExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static boolean isa_CallExpr(Stmt/*P*/ From) {
    assert From != null;
    return CallExpr.classof(From);
  }

  public static CallExpr cast_CallExpr(Stmt/*P*/ From) {
    assert isa_CallExpr(From);
    return (CallExpr) From;
  }

  public static CallExpr cast_or_null_CallExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CallExpr(From);
  }

  public static CallExpr dyn_cast_CallExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static CallExpr dyn_cast_or_null_CallExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CallExpr(From) ? cast_CallExpr(From) : null;
  }

  public static boolean isa_CastExpr(Stmt/*P*/ From) {
    assert From != null;
    return CastExpr.classof(From);
  }

  public static CastExpr cast_CastExpr(Stmt/*P*/ From) {
    assert isa_CastExpr(From);
    return (CastExpr) From;
  }

  public static CastExpr cast_or_null_CastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CastExpr(From);
  }

  public static CastExpr dyn_cast_CastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static CastExpr dyn_cast_or_null_CastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static boolean isa_CastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CastExpr.class, From.$star());
  }

  public static CastExpr cast_CastExpr(type$ptr<?>/*P*/ From) {
    assert isa_CastExpr(From);
    return llvm.cast(CastExpr.class, From.$star());
  }

  public static CastExpr cast_or_null_CastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CastExpr(From);
  }

  public static CastExpr dyn_cast_CastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static CastExpr dyn_cast_or_null_CastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static boolean isa_CastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CastExpr.class, From.$deref());
  }

  public static CastExpr cast_CastExpr(type$ref<?>/*P*/ From) {
    assert isa_CastExpr(From);
    return llvm.cast(CastExpr.class, From.$deref());
  }

  public static CastExpr cast_or_null_CastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CastExpr(From);
  }

  public static CastExpr dyn_cast_CastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static CastExpr dyn_cast_or_null_CastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CastExpr(From) ? cast_CastExpr(From) : null;
  }

  public static boolean isa_ChooseExpr(Stmt/*P*/ From) {
    assert From != null;
    return ChooseExpr.classof(From);
  }

  public static ChooseExpr cast_ChooseExpr(Stmt/*P*/ From) {
    assert isa_ChooseExpr(From);
    return (ChooseExpr) From;
  }

  public static ChooseExpr cast_or_null_ChooseExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ChooseExpr(From);
  }

  public static ChooseExpr dyn_cast_ChooseExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static ChooseExpr dyn_cast_or_null_ChooseExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static boolean isa_ChooseExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ChooseExpr.class, From.$star());
  }

  public static ChooseExpr cast_ChooseExpr(type$ptr<?>/*P*/ From) {
    assert isa_ChooseExpr(From);
    return llvm.cast(ChooseExpr.class, From.$star());
  }

  public static ChooseExpr cast_or_null_ChooseExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ChooseExpr(From);
  }

  public static ChooseExpr dyn_cast_ChooseExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static ChooseExpr dyn_cast_or_null_ChooseExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static boolean isa_ChooseExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ChooseExpr.class, From.$deref());
  }

  public static ChooseExpr cast_ChooseExpr(type$ref<?>/*P*/ From) {
    assert isa_ChooseExpr(From);
    return llvm.cast(ChooseExpr.class, From.$deref());
  }

  public static ChooseExpr cast_or_null_ChooseExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ChooseExpr(From);
  }

  public static ChooseExpr dyn_cast_ChooseExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static ChooseExpr dyn_cast_or_null_ChooseExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ChooseExpr(From) ? cast_ChooseExpr(From) : null;
  }

  public static boolean isa_CoawaitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CoawaitExpr.class, From.$star());
  }

  public static CoawaitExpr cast_CoawaitExpr(type$ptr<?>/*P*/ From) {
    assert isa_CoawaitExpr(From);
    return llvm.cast(CoawaitExpr.class, From.$star());
  }

  public static CoawaitExpr cast_or_null_CoawaitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CoawaitExpr(From);
  }

  public static CoawaitExpr dyn_cast_CoawaitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static CoawaitExpr dyn_cast_or_null_CoawaitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static boolean isa_CoawaitExpr(Stmt/*P*/ From) {
    assert From != null;
    return CoawaitExpr.classof(From);
  }

  public static CoawaitExpr cast_CoawaitExpr(Stmt/*P*/ From) {
    assert isa_CoawaitExpr(From);
    return (CoawaitExpr) From;
  }

  public static CoawaitExpr cast_or_null_CoawaitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CoawaitExpr(From);
  }

  public static CoawaitExpr dyn_cast_CoawaitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static CoawaitExpr dyn_cast_or_null_CoawaitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static boolean isa_CoawaitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CoawaitExpr.class, From.$deref());
  }

  public static CoawaitExpr cast_CoawaitExpr(type$ref<?>/*P*/ From) {
    assert isa_CoawaitExpr(From);
    return llvm.cast(CoawaitExpr.class, From.$deref());
  }

  public static CoawaitExpr cast_or_null_CoawaitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CoawaitExpr(From);
  }

  public static CoawaitExpr dyn_cast_CoawaitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static CoawaitExpr dyn_cast_or_null_CoawaitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CoawaitExpr(From) ? cast_CoawaitExpr(From) : null;
  }

  public static boolean isa_CompoundLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return CompoundLiteralExpr.classof(From);
  }

  public static CompoundLiteralExpr cast_CompoundLiteralExpr(Stmt/*P*/ From) {
    assert isa_CompoundLiteralExpr(From);
    return (CompoundLiteralExpr) From;
  }

  public static CompoundLiteralExpr cast_or_null_CompoundLiteralExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CompoundLiteralExpr(From);
  }

  public static CompoundLiteralExpr dyn_cast_CompoundLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static CompoundLiteralExpr dyn_cast_or_null_CompoundLiteralExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static boolean isa_CompoundLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompoundLiteralExpr.class, From.$star());
  }

  public static CompoundLiteralExpr cast_CompoundLiteralExpr(type$ptr<?>/*P*/ From) {
    assert isa_CompoundLiteralExpr(From);
    return llvm.cast(CompoundLiteralExpr.class, From.$star());
  }

  public static CompoundLiteralExpr cast_or_null_CompoundLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompoundLiteralExpr(From);
  }

  public static CompoundLiteralExpr dyn_cast_CompoundLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static CompoundLiteralExpr dyn_cast_or_null_CompoundLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static boolean isa_CompoundLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompoundLiteralExpr.class, From.$deref());
  }

  public static CompoundLiteralExpr cast_CompoundLiteralExpr(type$ref<?>/*P*/ From) {
    assert isa_CompoundLiteralExpr(From);
    return llvm.cast(CompoundLiteralExpr.class, From.$deref());
  }

  public static CompoundLiteralExpr cast_or_null_CompoundLiteralExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompoundLiteralExpr(From);
  }

  public static CompoundLiteralExpr dyn_cast_CompoundLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static CompoundLiteralExpr dyn_cast_or_null_CompoundLiteralExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompoundLiteralExpr(From) ? cast_CompoundLiteralExpr(From) : null;
  }

  public static boolean isa_ConvertVectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConvertVectorExpr.class, From.$star());
  }

  public static ConvertVectorExpr cast_ConvertVectorExpr(type$ptr<?>/*P*/ From) {
    assert isa_ConvertVectorExpr(From);
    return llvm.cast(ConvertVectorExpr.class, From.$star());
  }

  public static ConvertVectorExpr cast_or_null_ConvertVectorExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConvertVectorExpr(From);
  }

  public static ConvertVectorExpr dyn_cast_ConvertVectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static ConvertVectorExpr dyn_cast_or_null_ConvertVectorExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static boolean isa_ConvertVectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return ConvertVectorExpr.classof(From);
  }

  public static ConvertVectorExpr cast_ConvertVectorExpr(Stmt/*P*/ From) {
    assert isa_ConvertVectorExpr(From);
    return (ConvertVectorExpr) From;
  }

  public static ConvertVectorExpr cast_or_null_ConvertVectorExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ConvertVectorExpr(From);
  }

  public static ConvertVectorExpr dyn_cast_ConvertVectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static ConvertVectorExpr dyn_cast_or_null_ConvertVectorExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static boolean isa_ConvertVectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConvertVectorExpr.class, From.$deref());
  }

  public static ConvertVectorExpr cast_ConvertVectorExpr(type$ref<?>/*P*/ From) {
    assert isa_ConvertVectorExpr(From);
    return llvm.cast(ConvertVectorExpr.class, From.$deref());
  }

  public static ConvertVectorExpr cast_or_null_ConvertVectorExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConvertVectorExpr(From);
  }

  public static ConvertVectorExpr dyn_cast_ConvertVectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static ConvertVectorExpr dyn_cast_or_null_ConvertVectorExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConvertVectorExpr(From) ? cast_ConvertVectorExpr(From) : null;
  }

  public static boolean isa_CoroutineSuspendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CoroutineSuspendExpr.class, From.$deref());
  }

  public static CoroutineSuspendExpr cast_CoroutineSuspendExpr(type$ref<?>/*P*/ From) {
    assert isa_CoroutineSuspendExpr(From);
    return llvm.cast(CoroutineSuspendExpr.class, From.$deref());
  }

  public static CoroutineSuspendExpr cast_or_null_CoroutineSuspendExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CoroutineSuspendExpr(From);
  }

  public static CoroutineSuspendExpr dyn_cast_CoroutineSuspendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static CoroutineSuspendExpr dyn_cast_or_null_CoroutineSuspendExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static boolean isa_CoroutineSuspendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CoroutineSuspendExpr.class, From.$star());
  }

  public static CoroutineSuspendExpr cast_CoroutineSuspendExpr(type$ptr<?>/*P*/ From) {
    assert isa_CoroutineSuspendExpr(From);
    return llvm.cast(CoroutineSuspendExpr.class, From.$star());
  }

  public static CoroutineSuspendExpr cast_or_null_CoroutineSuspendExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CoroutineSuspendExpr(From);
  }

  public static CoroutineSuspendExpr dyn_cast_CoroutineSuspendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static CoroutineSuspendExpr dyn_cast_or_null_CoroutineSuspendExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static boolean isa_CoroutineSuspendExpr(Stmt/*P*/ From) {
    assert From != null;
    return CoroutineSuspendExpr.classof(From);
  }

  public static CoroutineSuspendExpr cast_CoroutineSuspendExpr(Stmt/*P*/ From) {
    assert isa_CoroutineSuspendExpr(From);
    return (CoroutineSuspendExpr) From;
  }

  public static CoroutineSuspendExpr cast_or_null_CoroutineSuspendExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CoroutineSuspendExpr(From);
  }

  public static CoroutineSuspendExpr dyn_cast_CoroutineSuspendExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static CoroutineSuspendExpr dyn_cast_or_null_CoroutineSuspendExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CoroutineSuspendExpr(From) ? cast_CoroutineSuspendExpr(From) : null;
  }

  public static boolean isa_CoyieldExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CoyieldExpr.class, From.$star());
  }

  public static CoyieldExpr cast_CoyieldExpr(type$ptr<?>/*P*/ From) {
    assert isa_CoyieldExpr(From);
    return llvm.cast(CoyieldExpr.class, From.$star());
  }

  public static CoyieldExpr cast_or_null_CoyieldExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CoyieldExpr(From);
  }

  public static CoyieldExpr dyn_cast_CoyieldExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static CoyieldExpr dyn_cast_or_null_CoyieldExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static boolean isa_CoyieldExpr(Stmt/*P*/ From) {
    assert From != null;
    return CoyieldExpr.classof(From);
  }

  public static CoyieldExpr cast_CoyieldExpr(Stmt/*P*/ From) {
    assert isa_CoyieldExpr(From);
    return (CoyieldExpr) From;
  }

  public static CoyieldExpr cast_or_null_CoyieldExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_CoyieldExpr(From);
  }

  public static CoyieldExpr dyn_cast_CoyieldExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static CoyieldExpr dyn_cast_or_null_CoyieldExpr(Stmt/*P*/ From) {
    return (From != null) && isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static boolean isa_CoyieldExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CoyieldExpr.class, From.$deref());
  }

  public static CoyieldExpr cast_CoyieldExpr(type$ref<?>/*P*/ From) {
    assert isa_CoyieldExpr(From);
    return llvm.cast(CoyieldExpr.class, From.$deref());
  }

  public static CoyieldExpr cast_or_null_CoyieldExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CoyieldExpr(From);
  }

  public static CoyieldExpr dyn_cast_CoyieldExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static CoyieldExpr dyn_cast_or_null_CoyieldExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CoyieldExpr(From) ? cast_CoyieldExpr(From) : null;
  }

  public static boolean isa_DeclRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeclRefExpr.class, From.$star());
  }

  public static DeclRefExpr cast_DeclRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_DeclRefExpr(From);
    return llvm.cast(DeclRefExpr.class, From.$star());
  }

  public static DeclRefExpr cast_or_null_DeclRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeclRefExpr(From);
  }

  public static DeclRefExpr dyn_cast_DeclRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static DeclRefExpr dyn_cast_or_null_DeclRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static boolean isa_DeclRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return DeclRefExpr.classof(From);
  }

  public static DeclRefExpr cast_DeclRefExpr(Stmt/*P*/ From) {
    assert isa_DeclRefExpr(From);
    return (DeclRefExpr) From;
  }

  public static DeclRefExpr cast_or_null_DeclRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DeclRefExpr(From);
  }

  public static DeclRefExpr dyn_cast_DeclRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static DeclRefExpr dyn_cast_or_null_DeclRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static boolean isa_DeclRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeclRefExpr.class, From.$deref());
  }

  public static DeclRefExpr cast_DeclRefExpr(type$ref<?>/*P*/ From) {
    assert isa_DeclRefExpr(From);
    return llvm.cast(DeclRefExpr.class, From.$deref());
  }

  public static DeclRefExpr cast_or_null_DeclRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeclRefExpr(From);
  }

  public static DeclRefExpr dyn_cast_DeclRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static DeclRefExpr dyn_cast_or_null_DeclRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeclRefExpr(From) ? cast_DeclRefExpr(From) : null;
  }

  public static boolean isa_DependentScopeDeclRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return DependentScopeDeclRefExpr.classof(From);
  }

  public static DependentScopeDeclRefExpr cast_DependentScopeDeclRefExpr(Stmt/*P*/ From) {
    assert isa_DependentScopeDeclRefExpr(From);
    return (DependentScopeDeclRefExpr) From;
  }

  public static DependentScopeDeclRefExpr cast_or_null_DependentScopeDeclRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DependentScopeDeclRefExpr(From);
  }

  public static DependentScopeDeclRefExpr dyn_cast_DependentScopeDeclRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static DependentScopeDeclRefExpr dyn_cast_or_null_DependentScopeDeclRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static boolean isa_DependentScopeDeclRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DependentScopeDeclRefExpr.class, From.$star());
  }

  public static DependentScopeDeclRefExpr cast_DependentScopeDeclRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_DependentScopeDeclRefExpr(From);
    return llvm.cast(DependentScopeDeclRefExpr.class, From.$star());
  }

  public static DependentScopeDeclRefExpr cast_or_null_DependentScopeDeclRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DependentScopeDeclRefExpr(From);
  }

  public static DependentScopeDeclRefExpr dyn_cast_DependentScopeDeclRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static DependentScopeDeclRefExpr dyn_cast_or_null_DependentScopeDeclRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static boolean isa_DependentScopeDeclRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DependentScopeDeclRefExpr.class, From.$deref());
  }

  public static DependentScopeDeclRefExpr cast_DependentScopeDeclRefExpr(type$ref<?>/*P*/ From) {
    assert isa_DependentScopeDeclRefExpr(From);
    return llvm.cast(DependentScopeDeclRefExpr.class, From.$deref());
  }

  public static DependentScopeDeclRefExpr cast_or_null_DependentScopeDeclRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DependentScopeDeclRefExpr(From);
  }

  public static DependentScopeDeclRefExpr dyn_cast_DependentScopeDeclRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static DependentScopeDeclRefExpr dyn_cast_or_null_DependentScopeDeclRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DependentScopeDeclRefExpr(From) ? cast_DependentScopeDeclRefExpr(From) : null;
  }

  public static boolean isa_DesignatedInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DesignatedInitExpr.class, From.$deref());
  }

  public static DesignatedInitExpr cast_DesignatedInitExpr(type$ref<?>/*P*/ From) {
    assert isa_DesignatedInitExpr(From);
    return llvm.cast(DesignatedInitExpr.class, From.$deref());
  }

  public static DesignatedInitExpr cast_or_null_DesignatedInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DesignatedInitExpr(From);
  }

  public static DesignatedInitExpr dyn_cast_DesignatedInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static DesignatedInitExpr dyn_cast_or_null_DesignatedInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static boolean isa_DesignatedInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return DesignatedInitExpr.classof(From);
  }

  public static DesignatedInitExpr cast_DesignatedInitExpr(Stmt/*P*/ From) {
    assert isa_DesignatedInitExpr(From);
    return (DesignatedInitExpr) From;
  }

  public static DesignatedInitExpr cast_or_null_DesignatedInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DesignatedInitExpr(From);
  }

  public static DesignatedInitExpr dyn_cast_DesignatedInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static DesignatedInitExpr dyn_cast_or_null_DesignatedInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static boolean isa_DesignatedInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DesignatedInitExpr.class, From.$star());
  }

  public static DesignatedInitExpr cast_DesignatedInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_DesignatedInitExpr(From);
    return llvm.cast(DesignatedInitExpr.class, From.$star());
  }

  public static DesignatedInitExpr cast_or_null_DesignatedInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DesignatedInitExpr(From);
  }

  public static DesignatedInitExpr dyn_cast_DesignatedInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static DesignatedInitExpr dyn_cast_or_null_DesignatedInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DesignatedInitExpr(From) ? cast_DesignatedInitExpr(From) : null;
  }

  public static boolean isa_DesignatedInitUpdateExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DesignatedInitUpdateExpr.class, From.$deref());
  }

  public static DesignatedInitUpdateExpr cast_DesignatedInitUpdateExpr(type$ref<?>/*P*/ From) {
    assert isa_DesignatedInitUpdateExpr(From);
    return llvm.cast(DesignatedInitUpdateExpr.class, From.$deref());
  }

  public static DesignatedInitUpdateExpr cast_or_null_DesignatedInitUpdateExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DesignatedInitUpdateExpr(From);
  }

  public static DesignatedInitUpdateExpr dyn_cast_DesignatedInitUpdateExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static DesignatedInitUpdateExpr dyn_cast_or_null_DesignatedInitUpdateExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static boolean isa_DesignatedInitUpdateExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DesignatedInitUpdateExpr.class, From.$star());
  }

  public static DesignatedInitUpdateExpr cast_DesignatedInitUpdateExpr(type$ptr<?>/*P*/ From) {
    assert isa_DesignatedInitUpdateExpr(From);
    return llvm.cast(DesignatedInitUpdateExpr.class, From.$star());
  }

  public static DesignatedInitUpdateExpr cast_or_null_DesignatedInitUpdateExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DesignatedInitUpdateExpr(From);
  }

  public static DesignatedInitUpdateExpr dyn_cast_DesignatedInitUpdateExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static DesignatedInitUpdateExpr dyn_cast_or_null_DesignatedInitUpdateExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static boolean isa_DesignatedInitUpdateExpr(Stmt/*P*/ From) {
    assert From != null;
    return DesignatedInitUpdateExpr.classof(From);
  }

  public static DesignatedInitUpdateExpr cast_DesignatedInitUpdateExpr(Stmt/*P*/ From) {
    assert isa_DesignatedInitUpdateExpr(From);
    return (DesignatedInitUpdateExpr) From;
  }

  public static DesignatedInitUpdateExpr cast_or_null_DesignatedInitUpdateExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_DesignatedInitUpdateExpr(From);
  }

  public static DesignatedInitUpdateExpr dyn_cast_DesignatedInitUpdateExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static DesignatedInitUpdateExpr dyn_cast_or_null_DesignatedInitUpdateExpr(Stmt/*P*/ From) {
    return (From != null) && isa_DesignatedInitUpdateExpr(From) ? cast_DesignatedInitUpdateExpr(From) : null;
  }

  public static boolean isa_ExplicitCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return ExplicitCastExpr.classof(From);
  }

  public static ExplicitCastExpr cast_ExplicitCastExpr(Stmt/*P*/ From) {
    assert isa_ExplicitCastExpr(From);
    return (ExplicitCastExpr) From;
  }

  public static ExplicitCastExpr cast_or_null_ExplicitCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ExplicitCastExpr(From);
  }

  public static ExplicitCastExpr dyn_cast_ExplicitCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static ExplicitCastExpr dyn_cast_or_null_ExplicitCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static boolean isa_ExplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExplicitCastExpr.class, From.$star());
  }

  public static ExplicitCastExpr cast_ExplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_ExplicitCastExpr(From);
    return llvm.cast(ExplicitCastExpr.class, From.$star());
  }

  public static ExplicitCastExpr cast_or_null_ExplicitCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExplicitCastExpr(From);
  }

  public static ExplicitCastExpr dyn_cast_ExplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static ExplicitCastExpr dyn_cast_or_null_ExplicitCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static boolean isa_ExplicitCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExplicitCastExpr.class, From.$deref());
  }

  public static ExplicitCastExpr cast_ExplicitCastExpr(type$ref<?>/*P*/ From) {
    assert isa_ExplicitCastExpr(From);
    return llvm.cast(ExplicitCastExpr.class, From.$deref());
  }

  public static ExplicitCastExpr cast_or_null_ExplicitCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExplicitCastExpr(From);
  }

  public static ExplicitCastExpr dyn_cast_ExplicitCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static ExplicitCastExpr dyn_cast_or_null_ExplicitCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExplicitCastExpr(From) ? cast_ExplicitCastExpr(From) : null;
  }

  public static boolean isa_Expr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Expr.class, From.$star());
  }

  public static Expr cast_Expr(type$ptr<?>/*P*/ From) {
    assert isa_Expr(From);
    return llvm.cast(Expr.class, From.$star());
  }

  public static Expr cast_or_null_Expr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Expr(From);
  }

  public static Expr dyn_cast_Expr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static Expr dyn_cast_or_null_Expr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static boolean isa_Expr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Expr.class, From.$deref());
  }

  public static Expr cast_Expr(type$ref<?>/*P*/ From) {
    assert isa_Expr(From);
    return llvm.cast(Expr.class, From.$deref());
  }

  public static Expr cast_or_null_Expr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Expr(From);
  }

  public static Expr dyn_cast_Expr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static Expr dyn_cast_or_null_Expr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static boolean isa_Expr(Stmt/*P*/ From) {
    assert From != null;
    return Expr.classof(From);
  }

  public static Expr cast_Expr(Stmt/*P*/ From) {
    assert isa_Expr(From);
    return (Expr) From;
  }

  public static Expr cast_or_null_Expr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_Expr(From);
  }

  public static Expr dyn_cast_Expr(Stmt/*P*/ From) {
    assert From != null;
    return isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static Expr dyn_cast_or_null_Expr(Stmt/*P*/ From) {
    return (From != null) && isa_Expr(From) ? cast_Expr(From) : null;
  }

  public static boolean isa_ExpressionTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExpressionTraitExpr.class, From.$deref());
  }

  public static ExpressionTraitExpr cast_ExpressionTraitExpr(type$ref<?>/*P*/ From) {
    assert isa_ExpressionTraitExpr(From);
    return llvm.cast(ExpressionTraitExpr.class, From.$deref());
  }

  public static ExpressionTraitExpr cast_or_null_ExpressionTraitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExpressionTraitExpr(From);
  }

  public static ExpressionTraitExpr dyn_cast_ExpressionTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static ExpressionTraitExpr dyn_cast_or_null_ExpressionTraitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static boolean isa_ExpressionTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExpressionTraitExpr.class, From.$star());
  }

  public static ExpressionTraitExpr cast_ExpressionTraitExpr(type$ptr<?>/*P*/ From) {
    assert isa_ExpressionTraitExpr(From);
    return llvm.cast(ExpressionTraitExpr.class, From.$star());
  }

  public static ExpressionTraitExpr cast_or_null_ExpressionTraitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExpressionTraitExpr(From);
  }

  public static ExpressionTraitExpr dyn_cast_ExpressionTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static ExpressionTraitExpr dyn_cast_or_null_ExpressionTraitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static boolean isa_ExpressionTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return ExpressionTraitExpr.classof(From);
  }

  public static ExpressionTraitExpr cast_ExpressionTraitExpr(Stmt/*P*/ From) {
    assert isa_ExpressionTraitExpr(From);
    return (ExpressionTraitExpr) From;
  }

  public static ExpressionTraitExpr cast_or_null_ExpressionTraitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ExpressionTraitExpr(From);
  }

  public static ExpressionTraitExpr dyn_cast_ExpressionTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static ExpressionTraitExpr dyn_cast_or_null_ExpressionTraitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ExpressionTraitExpr(From) ? cast_ExpressionTraitExpr(From) : null;
  }

  public static boolean isa_ExtVectorElementExpr(Stmt/*P*/ From) {
    assert From != null;
    return ExtVectorElementExpr.classof(From);
  }

  public static ExtVectorElementExpr cast_ExtVectorElementExpr(Stmt/*P*/ From) {
    assert isa_ExtVectorElementExpr(From);
    return (ExtVectorElementExpr) From;
  }

  public static ExtVectorElementExpr cast_or_null_ExtVectorElementExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ExtVectorElementExpr(From);
  }

  public static ExtVectorElementExpr dyn_cast_ExtVectorElementExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static ExtVectorElementExpr dyn_cast_or_null_ExtVectorElementExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static boolean isa_ExtVectorElementExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtVectorElementExpr.class, From.$star());
  }

  public static ExtVectorElementExpr cast_ExtVectorElementExpr(type$ptr<?>/*P*/ From) {
    assert isa_ExtVectorElementExpr(From);
    return llvm.cast(ExtVectorElementExpr.class, From.$star());
  }

  public static ExtVectorElementExpr cast_or_null_ExtVectorElementExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtVectorElementExpr(From);
  }

  public static ExtVectorElementExpr dyn_cast_ExtVectorElementExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static ExtVectorElementExpr dyn_cast_or_null_ExtVectorElementExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static boolean isa_ExtVectorElementExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtVectorElementExpr.class, From.$deref());
  }

  public static ExtVectorElementExpr cast_ExtVectorElementExpr(type$ref<?>/*P*/ From) {
    assert isa_ExtVectorElementExpr(From);
    return llvm.cast(ExtVectorElementExpr.class, From.$deref());
  }

  public static ExtVectorElementExpr cast_or_null_ExtVectorElementExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtVectorElementExpr(From);
  }

  public static ExtVectorElementExpr dyn_cast_ExtVectorElementExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static ExtVectorElementExpr dyn_cast_or_null_ExtVectorElementExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtVectorElementExpr(From) ? cast_ExtVectorElementExpr(From) : null;
  }

  public static boolean isa_FunctionParmPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionParmPackExpr.class, From.$star());
  }

  public static FunctionParmPackExpr cast_FunctionParmPackExpr(type$ptr<?>/*P*/ From) {
    assert isa_FunctionParmPackExpr(From);
    return llvm.cast(FunctionParmPackExpr.class, From.$star());
  }

  public static FunctionParmPackExpr cast_or_null_FunctionParmPackExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionParmPackExpr(From);
  }

  public static FunctionParmPackExpr dyn_cast_FunctionParmPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static FunctionParmPackExpr dyn_cast_or_null_FunctionParmPackExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static boolean isa_FunctionParmPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return FunctionParmPackExpr.classof(From);
  }

  public static FunctionParmPackExpr cast_FunctionParmPackExpr(Stmt/*P*/ From) {
    assert isa_FunctionParmPackExpr(From);
    return (FunctionParmPackExpr) From;
  }

  public static FunctionParmPackExpr cast_or_null_FunctionParmPackExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_FunctionParmPackExpr(From);
  }

  public static FunctionParmPackExpr dyn_cast_FunctionParmPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static FunctionParmPackExpr dyn_cast_or_null_FunctionParmPackExpr(Stmt/*P*/ From) {
    return (From != null) && isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static boolean isa_FunctionParmPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionParmPackExpr.class, From.$deref());
  }

  public static FunctionParmPackExpr cast_FunctionParmPackExpr(type$ref<?>/*P*/ From) {
    assert isa_FunctionParmPackExpr(From);
    return llvm.cast(FunctionParmPackExpr.class, From.$deref());
  }

  public static FunctionParmPackExpr cast_or_null_FunctionParmPackExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionParmPackExpr(From);
  }

  public static FunctionParmPackExpr dyn_cast_FunctionParmPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static FunctionParmPackExpr dyn_cast_or_null_FunctionParmPackExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionParmPackExpr(From) ? cast_FunctionParmPackExpr(From) : null;
  }

  public static boolean isa_GNUNullExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GNUNullExpr.class, From.$star());
  }

  public static GNUNullExpr cast_GNUNullExpr(type$ptr<?>/*P*/ From) {
    assert isa_GNUNullExpr(From);
    return llvm.cast(GNUNullExpr.class, From.$star());
  }

  public static GNUNullExpr cast_or_null_GNUNullExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GNUNullExpr(From);
  }

  public static GNUNullExpr dyn_cast_GNUNullExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static GNUNullExpr dyn_cast_or_null_GNUNullExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static boolean isa_GNUNullExpr(Stmt/*P*/ From) {
    assert From != null;
    return GNUNullExpr.classof(From);
  }

  public static GNUNullExpr cast_GNUNullExpr(Stmt/*P*/ From) {
    assert isa_GNUNullExpr(From);
    return (GNUNullExpr) From;
  }

  public static GNUNullExpr cast_or_null_GNUNullExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_GNUNullExpr(From);
  }

  public static GNUNullExpr dyn_cast_GNUNullExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static GNUNullExpr dyn_cast_or_null_GNUNullExpr(Stmt/*P*/ From) {
    return (From != null) && isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static boolean isa_GNUNullExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GNUNullExpr.class, From.$deref());
  }

  public static GNUNullExpr cast_GNUNullExpr(type$ref<?>/*P*/ From) {
    assert isa_GNUNullExpr(From);
    return llvm.cast(GNUNullExpr.class, From.$deref());
  }

  public static GNUNullExpr cast_or_null_GNUNullExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GNUNullExpr(From);
  }

  public static GNUNullExpr dyn_cast_GNUNullExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static GNUNullExpr dyn_cast_or_null_GNUNullExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GNUNullExpr(From) ? cast_GNUNullExpr(From) : null;
  }

  public static boolean isa_GenericSelectionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GenericSelectionExpr.class, From.$deref());
  }

  public static GenericSelectionExpr cast_GenericSelectionExpr(type$ref<?>/*P*/ From) {
    assert isa_GenericSelectionExpr(From);
    return llvm.cast(GenericSelectionExpr.class, From.$deref());
  }

  public static GenericSelectionExpr cast_or_null_GenericSelectionExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GenericSelectionExpr(From);
  }

  public static GenericSelectionExpr dyn_cast_GenericSelectionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static GenericSelectionExpr dyn_cast_or_null_GenericSelectionExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static boolean isa_GenericSelectionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GenericSelectionExpr.class, From.$star());
  }

  public static GenericSelectionExpr cast_GenericSelectionExpr(type$ptr<?>/*P*/ From) {
    assert isa_GenericSelectionExpr(From);
    return llvm.cast(GenericSelectionExpr.class, From.$star());
  }

  public static GenericSelectionExpr cast_or_null_GenericSelectionExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GenericSelectionExpr(From);
  }

  public static GenericSelectionExpr dyn_cast_GenericSelectionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static GenericSelectionExpr dyn_cast_or_null_GenericSelectionExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static boolean isa_GenericSelectionExpr(Stmt/*P*/ From) {
    assert From != null;
    return GenericSelectionExpr.classof(From);
  }

  public static GenericSelectionExpr cast_GenericSelectionExpr(Stmt/*P*/ From) {
    assert isa_GenericSelectionExpr(From);
    return (GenericSelectionExpr) From;
  }

  public static GenericSelectionExpr cast_or_null_GenericSelectionExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_GenericSelectionExpr(From);
  }

  public static GenericSelectionExpr dyn_cast_GenericSelectionExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static GenericSelectionExpr dyn_cast_or_null_GenericSelectionExpr(Stmt/*P*/ From) {
    return (From != null) && isa_GenericSelectionExpr(From) ? cast_GenericSelectionExpr(From) : null;
  }

  public static boolean isa_ImplicitCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return ImplicitCastExpr.classof(From);
  }

  public static ImplicitCastExpr cast_ImplicitCastExpr(Stmt/*P*/ From) {
    assert isa_ImplicitCastExpr(From);
    return (ImplicitCastExpr) From;
  }

  public static ImplicitCastExpr cast_or_null_ImplicitCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ImplicitCastExpr(From);
  }

  public static ImplicitCastExpr dyn_cast_ImplicitCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static ImplicitCastExpr dyn_cast_or_null_ImplicitCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static boolean isa_ImplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ImplicitCastExpr.class, From.$star());
  }

  public static ImplicitCastExpr cast_ImplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_ImplicitCastExpr(From);
    return llvm.cast(ImplicitCastExpr.class, From.$star());
  }

  public static ImplicitCastExpr cast_or_null_ImplicitCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ImplicitCastExpr(From);
  }

  public static ImplicitCastExpr dyn_cast_ImplicitCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static ImplicitCastExpr dyn_cast_or_null_ImplicitCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static boolean isa_ImplicitCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ImplicitCastExpr.class, From.$deref());
  }

  public static ImplicitCastExpr cast_ImplicitCastExpr(type$ref<?>/*P*/ From) {
    assert isa_ImplicitCastExpr(From);
    return llvm.cast(ImplicitCastExpr.class, From.$deref());
  }

  public static ImplicitCastExpr cast_or_null_ImplicitCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ImplicitCastExpr(From);
  }

  public static ImplicitCastExpr dyn_cast_ImplicitCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static ImplicitCastExpr dyn_cast_or_null_ImplicitCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ImplicitCastExpr(From) ? cast_ImplicitCastExpr(From) : null;
  }

  public static boolean isa_ImplicitValueInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return ImplicitValueInitExpr.classof(From);
  }

  public static ImplicitValueInitExpr cast_ImplicitValueInitExpr(Stmt/*P*/ From) {
    assert isa_ImplicitValueInitExpr(From);
    return (ImplicitValueInitExpr) From;
  }

  public static ImplicitValueInitExpr cast_or_null_ImplicitValueInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ImplicitValueInitExpr(From);
  }

  public static ImplicitValueInitExpr dyn_cast_ImplicitValueInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static ImplicitValueInitExpr dyn_cast_or_null_ImplicitValueInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static boolean isa_ImplicitValueInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ImplicitValueInitExpr.class, From.$deref());
  }

  public static ImplicitValueInitExpr cast_ImplicitValueInitExpr(type$ref<?>/*P*/ From) {
    assert isa_ImplicitValueInitExpr(From);
    return llvm.cast(ImplicitValueInitExpr.class, From.$deref());
  }

  public static ImplicitValueInitExpr cast_or_null_ImplicitValueInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ImplicitValueInitExpr(From);
  }

  public static ImplicitValueInitExpr dyn_cast_ImplicitValueInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static ImplicitValueInitExpr dyn_cast_or_null_ImplicitValueInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static boolean isa_ImplicitValueInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ImplicitValueInitExpr.class, From.$star());
  }

  public static ImplicitValueInitExpr cast_ImplicitValueInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_ImplicitValueInitExpr(From);
    return llvm.cast(ImplicitValueInitExpr.class, From.$star());
  }

  public static ImplicitValueInitExpr cast_or_null_ImplicitValueInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ImplicitValueInitExpr(From);
  }

  public static ImplicitValueInitExpr dyn_cast_ImplicitValueInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static ImplicitValueInitExpr dyn_cast_or_null_ImplicitValueInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ImplicitValueInitExpr(From) ? cast_ImplicitValueInitExpr(From) : null;
  }

  public static boolean isa_InitListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InitListExpr.class, From.$star());
  }

  public static InitListExpr cast_InitListExpr(type$ptr<?>/*P*/ From) {
    assert isa_InitListExpr(From);
    return llvm.cast(InitListExpr.class, From.$star());
  }

  public static InitListExpr cast_or_null_InitListExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InitListExpr(From);
  }

  public static InitListExpr dyn_cast_InitListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static InitListExpr dyn_cast_or_null_InitListExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static boolean isa_InitListExpr(Stmt/*P*/ From) {
    assert From != null;
    return InitListExpr.classof(From);
  }

  public static InitListExpr cast_InitListExpr(Stmt/*P*/ From) {
    assert isa_InitListExpr(From);
    return (InitListExpr) From;
  }

  public static InitListExpr cast_or_null_InitListExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_InitListExpr(From);
  }

  public static InitListExpr dyn_cast_InitListExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static InitListExpr dyn_cast_or_null_InitListExpr(Stmt/*P*/ From) {
    return (From != null) && isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static boolean isa_InitListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InitListExpr.class, From.$deref());
  }

  public static InitListExpr cast_InitListExpr(type$ref<?>/*P*/ From) {
    assert isa_InitListExpr(From);
    return llvm.cast(InitListExpr.class, From.$deref());
  }

  public static InitListExpr cast_or_null_InitListExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InitListExpr(From);
  }

  public static InitListExpr dyn_cast_InitListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static InitListExpr dyn_cast_or_null_InitListExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InitListExpr(From) ? cast_InitListExpr(From) : null;
  }

  public static boolean isa_LambdaExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LambdaExpr.class, From.$deref());
  }

  public static LambdaExpr cast_LambdaExpr(type$ref<?>/*P*/ From) {
    assert isa_LambdaExpr(From);
    return llvm.cast(LambdaExpr.class, From.$deref());
  }

  public static LambdaExpr cast_or_null_LambdaExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LambdaExpr(From);
  }

  public static LambdaExpr dyn_cast_LambdaExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static LambdaExpr dyn_cast_or_null_LambdaExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static boolean isa_LambdaExpr(Stmt/*P*/ From) {
    assert From != null;
    return LambdaExpr.classof(From);
  }

  public static LambdaExpr cast_LambdaExpr(Stmt/*P*/ From) {
    assert isa_LambdaExpr(From);
    return (LambdaExpr) From;
  }

  public static LambdaExpr cast_or_null_LambdaExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_LambdaExpr(From);
  }

  public static LambdaExpr dyn_cast_LambdaExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static LambdaExpr dyn_cast_or_null_LambdaExpr(Stmt/*P*/ From) {
    return (From != null) && isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static boolean isa_LambdaExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LambdaExpr.class, From.$star());
  }

  public static LambdaExpr cast_LambdaExpr(type$ptr<?>/*P*/ From) {
    assert isa_LambdaExpr(From);
    return llvm.cast(LambdaExpr.class, From.$star());
  }

  public static LambdaExpr cast_or_null_LambdaExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LambdaExpr(From);
  }

  public static LambdaExpr dyn_cast_LambdaExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static LambdaExpr dyn_cast_or_null_LambdaExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LambdaExpr(From) ? cast_LambdaExpr(From) : null;
  }

  public static boolean isa_MSPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSPropertyRefExpr.class, From.$star());
  }

  public static MSPropertyRefExpr cast_MSPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_MSPropertyRefExpr(From);
    return llvm.cast(MSPropertyRefExpr.class, From.$star());
  }

  public static MSPropertyRefExpr cast_or_null_MSPropertyRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSPropertyRefExpr(From);
  }

  public static MSPropertyRefExpr dyn_cast_MSPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static MSPropertyRefExpr dyn_cast_or_null_MSPropertyRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static boolean isa_MSPropertyRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return MSPropertyRefExpr.classof(From);
  }

  public static MSPropertyRefExpr cast_MSPropertyRefExpr(Stmt/*P*/ From) {
    assert isa_MSPropertyRefExpr(From);
    return (MSPropertyRefExpr) From;
  }

  public static MSPropertyRefExpr cast_or_null_MSPropertyRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MSPropertyRefExpr(From);
  }

  public static MSPropertyRefExpr dyn_cast_MSPropertyRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static MSPropertyRefExpr dyn_cast_or_null_MSPropertyRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static boolean isa_MSPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSPropertyRefExpr.class, From.$deref());
  }

  public static MSPropertyRefExpr cast_MSPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert isa_MSPropertyRefExpr(From);
    return llvm.cast(MSPropertyRefExpr.class, From.$deref());
  }

  public static MSPropertyRefExpr cast_or_null_MSPropertyRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSPropertyRefExpr(From);
  }

  public static MSPropertyRefExpr dyn_cast_MSPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static MSPropertyRefExpr dyn_cast_or_null_MSPropertyRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSPropertyRefExpr(From) ? cast_MSPropertyRefExpr(From) : null;
  }

  public static boolean isa_MSPropertySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSPropertySubscriptExpr.class, From.$star());
  }

  public static MSPropertySubscriptExpr cast_MSPropertySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert isa_MSPropertySubscriptExpr(From);
    return llvm.cast(MSPropertySubscriptExpr.class, From.$star());
  }

  public static MSPropertySubscriptExpr cast_or_null_MSPropertySubscriptExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSPropertySubscriptExpr(From);
  }

  public static MSPropertySubscriptExpr dyn_cast_MSPropertySubscriptExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static MSPropertySubscriptExpr dyn_cast_or_null_MSPropertySubscriptExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static boolean isa_MSPropertySubscriptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSPropertySubscriptExpr.class, From.$deref());
  }

  public static MSPropertySubscriptExpr cast_MSPropertySubscriptExpr(type$ref<?>/*P*/ From) {
    assert isa_MSPropertySubscriptExpr(From);
    return llvm.cast(MSPropertySubscriptExpr.class, From.$deref());
  }

  public static MSPropertySubscriptExpr cast_or_null_MSPropertySubscriptExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSPropertySubscriptExpr(From);
  }

  public static MSPropertySubscriptExpr dyn_cast_MSPropertySubscriptExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static MSPropertySubscriptExpr dyn_cast_or_null_MSPropertySubscriptExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static boolean isa_MSPropertySubscriptExpr(Stmt/*P*/ From) {
    assert From != null;
    return MSPropertySubscriptExpr.classof(From);
  }

  public static MSPropertySubscriptExpr cast_MSPropertySubscriptExpr(Stmt/*P*/ From) {
    assert isa_MSPropertySubscriptExpr(From);
    return (MSPropertySubscriptExpr) From;
  }

  public static MSPropertySubscriptExpr cast_or_null_MSPropertySubscriptExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MSPropertySubscriptExpr(From);
  }

  public static MSPropertySubscriptExpr dyn_cast_MSPropertySubscriptExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static MSPropertySubscriptExpr dyn_cast_or_null_MSPropertySubscriptExpr(Stmt/*P*/ From) {
    return (From != null) && isa_MSPropertySubscriptExpr(From) ? cast_MSPropertySubscriptExpr(From) : null;
  }

  public static boolean isa_MaterializeTemporaryExpr(Stmt/*P*/ From) {
    assert From != null;
    return MaterializeTemporaryExpr.classof(From);
  }

  public static MaterializeTemporaryExpr cast_MaterializeTemporaryExpr(Stmt/*P*/ From) {
    assert isa_MaterializeTemporaryExpr(From);
    return (MaterializeTemporaryExpr) From;
  }

  public static MaterializeTemporaryExpr cast_or_null_MaterializeTemporaryExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MaterializeTemporaryExpr(From);
  }

  public static MaterializeTemporaryExpr dyn_cast_MaterializeTemporaryExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static MaterializeTemporaryExpr dyn_cast_or_null_MaterializeTemporaryExpr(Stmt/*P*/ From) {
    return (From != null) && isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static boolean isa_MaterializeTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MaterializeTemporaryExpr.class, From.$star());
  }

  public static MaterializeTemporaryExpr cast_MaterializeTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert isa_MaterializeTemporaryExpr(From);
    return llvm.cast(MaterializeTemporaryExpr.class, From.$star());
  }

  public static MaterializeTemporaryExpr cast_or_null_MaterializeTemporaryExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MaterializeTemporaryExpr(From);
  }

  public static MaterializeTemporaryExpr dyn_cast_MaterializeTemporaryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static MaterializeTemporaryExpr dyn_cast_or_null_MaterializeTemporaryExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static boolean isa_MaterializeTemporaryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MaterializeTemporaryExpr.class, From.$deref());
  }

  public static MaterializeTemporaryExpr cast_MaterializeTemporaryExpr(type$ref<?>/*P*/ From) {
    assert isa_MaterializeTemporaryExpr(From);
    return llvm.cast(MaterializeTemporaryExpr.class, From.$deref());
  }

  public static MaterializeTemporaryExpr cast_or_null_MaterializeTemporaryExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MaterializeTemporaryExpr(From);
  }

  public static MaterializeTemporaryExpr dyn_cast_MaterializeTemporaryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static MaterializeTemporaryExpr dyn_cast_or_null_MaterializeTemporaryExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MaterializeTemporaryExpr(From) ? cast_MaterializeTemporaryExpr(From) : null;
  }

  public static boolean isa_MemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemberExpr.class, From.$deref());
  }

  public static MemberExpr cast_MemberExpr(type$ref<?>/*P*/ From) {
    assert isa_MemberExpr(From);
    return llvm.cast(MemberExpr.class, From.$deref());
  }

  public static MemberExpr cast_or_null_MemberExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemberExpr(From);
  }

  public static MemberExpr dyn_cast_MemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static MemberExpr dyn_cast_or_null_MemberExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static boolean isa_MemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return MemberExpr.classof(From);
  }

  public static MemberExpr cast_MemberExpr(Stmt/*P*/ From) {
    assert isa_MemberExpr(From);
    return (MemberExpr) From;
  }

  public static MemberExpr cast_or_null_MemberExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_MemberExpr(From);
  }

  public static MemberExpr dyn_cast_MemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static MemberExpr dyn_cast_or_null_MemberExpr(Stmt/*P*/ From) {
    return (From != null) && isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static boolean isa_MemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemberExpr.class, From.$star());
  }

  public static MemberExpr cast_MemberExpr(type$ptr<?>/*P*/ From) {
    assert isa_MemberExpr(From);
    return llvm.cast(MemberExpr.class, From.$star());
  }

  public static MemberExpr cast_or_null_MemberExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemberExpr(From);
  }

  public static MemberExpr dyn_cast_MemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static MemberExpr dyn_cast_or_null_MemberExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemberExpr(From) ? cast_MemberExpr(From) : null;
  }

  public static boolean isa_NoInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoInitExpr.class, From.$star());
  }

  public static NoInitExpr cast_NoInitExpr(type$ptr<?>/*P*/ From) {
    assert isa_NoInitExpr(From);
    return llvm.cast(NoInitExpr.class, From.$star());
  }

  public static NoInitExpr cast_or_null_NoInitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoInitExpr(From);
  }

  public static NoInitExpr dyn_cast_NoInitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static NoInitExpr dyn_cast_or_null_NoInitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static boolean isa_NoInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return NoInitExpr.classof(From);
  }

  public static NoInitExpr cast_NoInitExpr(Stmt/*P*/ From) {
    assert isa_NoInitExpr(From);
    return (NoInitExpr) From;
  }

  public static NoInitExpr cast_or_null_NoInitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_NoInitExpr(From);
  }

  public static NoInitExpr dyn_cast_NoInitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static NoInitExpr dyn_cast_or_null_NoInitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static boolean isa_NoInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoInitExpr.class, From.$deref());
  }

  public static NoInitExpr cast_NoInitExpr(type$ref<?>/*P*/ From) {
    assert isa_NoInitExpr(From);
    return llvm.cast(NoInitExpr.class, From.$deref());
  }

  public static NoInitExpr cast_or_null_NoInitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoInitExpr(From);
  }

  public static NoInitExpr dyn_cast_NoInitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static NoInitExpr dyn_cast_or_null_NoInitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoInitExpr(From) ? cast_NoInitExpr(From) : null;
  }

  public static boolean isa_OMPArraySectionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPArraySectionExpr.class, From.$deref());
  }

  public static OMPArraySectionExpr cast_OMPArraySectionExpr(type$ref<?>/*P*/ From) {
    assert isa_OMPArraySectionExpr(From);
    return llvm.cast(OMPArraySectionExpr.class, From.$deref());
  }

  public static OMPArraySectionExpr cast_or_null_OMPArraySectionExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPArraySectionExpr(From);
  }

  public static OMPArraySectionExpr dyn_cast_OMPArraySectionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static OMPArraySectionExpr dyn_cast_or_null_OMPArraySectionExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static boolean isa_OMPArraySectionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPArraySectionExpr.class, From.$star());
  }

  public static OMPArraySectionExpr cast_OMPArraySectionExpr(type$ptr<?>/*P*/ From) {
    assert isa_OMPArraySectionExpr(From);
    return llvm.cast(OMPArraySectionExpr.class, From.$star());
  }

  public static OMPArraySectionExpr cast_or_null_OMPArraySectionExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPArraySectionExpr(From);
  }

  public static OMPArraySectionExpr dyn_cast_OMPArraySectionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static OMPArraySectionExpr dyn_cast_or_null_OMPArraySectionExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static boolean isa_OMPArraySectionExpr(Stmt/*P*/ From) {
    assert From != null;
    return OMPArraySectionExpr.classof(From);
  }

  public static OMPArraySectionExpr cast_OMPArraySectionExpr(Stmt/*P*/ From) {
    assert isa_OMPArraySectionExpr(From);
    return (OMPArraySectionExpr) From;
  }

  public static OMPArraySectionExpr cast_or_null_OMPArraySectionExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OMPArraySectionExpr(From);
  }

  public static OMPArraySectionExpr dyn_cast_OMPArraySectionExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static OMPArraySectionExpr dyn_cast_or_null_OMPArraySectionExpr(Stmt/*P*/ From) {
    return (From != null) && isa_OMPArraySectionExpr(From) ? cast_OMPArraySectionExpr(From) : null;
  }

  public static boolean isa_ObjCAvailabilityCheckExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCAvailabilityCheckExpr.classof(From);
  }

  public static ObjCAvailabilityCheckExpr cast_ObjCAvailabilityCheckExpr(Stmt/*P*/ From) {
    assert isa_ObjCAvailabilityCheckExpr(From);
    return (ObjCAvailabilityCheckExpr) From;
  }

  public static ObjCAvailabilityCheckExpr cast_or_null_ObjCAvailabilityCheckExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCAvailabilityCheckExpr(From);
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_ObjCAvailabilityCheckExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_or_null_ObjCAvailabilityCheckExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static boolean isa_ObjCAvailabilityCheckExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCAvailabilityCheckExpr.class, From.$star());
  }

  public static ObjCAvailabilityCheckExpr cast_ObjCAvailabilityCheckExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCAvailabilityCheckExpr(From);
    return llvm.cast(ObjCAvailabilityCheckExpr.class, From.$star());
  }

  public static ObjCAvailabilityCheckExpr cast_or_null_ObjCAvailabilityCheckExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCAvailabilityCheckExpr(From);
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_ObjCAvailabilityCheckExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_or_null_ObjCAvailabilityCheckExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static boolean isa_ObjCAvailabilityCheckExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCAvailabilityCheckExpr.class, From.$deref());
  }

  public static ObjCAvailabilityCheckExpr cast_ObjCAvailabilityCheckExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCAvailabilityCheckExpr(From);
    return llvm.cast(ObjCAvailabilityCheckExpr.class, From.$deref());
  }

  public static ObjCAvailabilityCheckExpr cast_or_null_ObjCAvailabilityCheckExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCAvailabilityCheckExpr(From);
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_ObjCAvailabilityCheckExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static ObjCAvailabilityCheckExpr dyn_cast_or_null_ObjCAvailabilityCheckExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCAvailabilityCheckExpr(From) ? cast_ObjCAvailabilityCheckExpr(From) : null;
  }

  public static boolean isa_ObjCBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBoolLiteralExpr.class, From.$star());
  }

  public static ObjCBoolLiteralExpr cast_ObjCBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBoolLiteralExpr(From);
    return llvm.cast(ObjCBoolLiteralExpr.class, From.$star());
  }

  public static ObjCBoolLiteralExpr cast_or_null_ObjCBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBoolLiteralExpr(From);
  }

  public static ObjCBoolLiteralExpr dyn_cast_ObjCBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static ObjCBoolLiteralExpr dyn_cast_or_null_ObjCBoolLiteralExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static boolean isa_ObjCBoolLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCBoolLiteralExpr.classof(From);
  }

  public static ObjCBoolLiteralExpr cast_ObjCBoolLiteralExpr(Stmt/*P*/ From) {
    assert isa_ObjCBoolLiteralExpr(From);
    return (ObjCBoolLiteralExpr) From;
  }

  public static ObjCBoolLiteralExpr cast_or_null_ObjCBoolLiteralExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCBoolLiteralExpr(From);
  }

  public static ObjCBoolLiteralExpr dyn_cast_ObjCBoolLiteralExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static ObjCBoolLiteralExpr dyn_cast_or_null_ObjCBoolLiteralExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static boolean isa_ObjCBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBoolLiteralExpr.class, From.$deref());
  }

  public static ObjCBoolLiteralExpr cast_ObjCBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBoolLiteralExpr(From);
    return llvm.cast(ObjCBoolLiteralExpr.class, From.$deref());
  }

  public static ObjCBoolLiteralExpr cast_or_null_ObjCBoolLiteralExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBoolLiteralExpr(From);
  }

  public static ObjCBoolLiteralExpr dyn_cast_ObjCBoolLiteralExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static ObjCBoolLiteralExpr dyn_cast_or_null_ObjCBoolLiteralExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBoolLiteralExpr(From) ? cast_ObjCBoolLiteralExpr(From) : null;
  }

  public static boolean isa_ObjCBoxedExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBoxedExpr.class, From.$star());
  }

  public static ObjCBoxedExpr cast_ObjCBoxedExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBoxedExpr(From);
    return llvm.cast(ObjCBoxedExpr.class, From.$star());
  }

  public static ObjCBoxedExpr cast_or_null_ObjCBoxedExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBoxedExpr(From);
  }

  public static ObjCBoxedExpr dyn_cast_ObjCBoxedExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static ObjCBoxedExpr dyn_cast_or_null_ObjCBoxedExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static boolean isa_ObjCBoxedExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCBoxedExpr.classof(From);
  }

  public static ObjCBoxedExpr cast_ObjCBoxedExpr(Stmt/*P*/ From) {
    assert isa_ObjCBoxedExpr(From);
    return (ObjCBoxedExpr) From;
  }

  public static ObjCBoxedExpr cast_or_null_ObjCBoxedExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCBoxedExpr(From);
  }

  public static ObjCBoxedExpr dyn_cast_ObjCBoxedExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static ObjCBoxedExpr dyn_cast_or_null_ObjCBoxedExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static boolean isa_ObjCBoxedExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBoxedExpr.class, From.$deref());
  }

  public static ObjCBoxedExpr cast_ObjCBoxedExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBoxedExpr(From);
    return llvm.cast(ObjCBoxedExpr.class, From.$deref());
  }

  public static ObjCBoxedExpr cast_or_null_ObjCBoxedExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBoxedExpr(From);
  }

  public static ObjCBoxedExpr dyn_cast_ObjCBoxedExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static ObjCBoxedExpr dyn_cast_or_null_ObjCBoxedExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBoxedExpr(From) ? cast_ObjCBoxedExpr(From) : null;
  }

  public static boolean isa_ObjCBridgedCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCBridgedCastExpr.classof(From);
  }

  public static ObjCBridgedCastExpr cast_ObjCBridgedCastExpr(Stmt/*P*/ From) {
    assert isa_ObjCBridgedCastExpr(From);
    return (ObjCBridgedCastExpr) From;
  }

  public static ObjCBridgedCastExpr cast_or_null_ObjCBridgedCastExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCBridgedCastExpr(From);
  }

  public static ObjCBridgedCastExpr dyn_cast_ObjCBridgedCastExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static ObjCBridgedCastExpr dyn_cast_or_null_ObjCBridgedCastExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static boolean isa_ObjCBridgedCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBridgedCastExpr.class, From.$deref());
  }

  public static ObjCBridgedCastExpr cast_ObjCBridgedCastExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBridgedCastExpr(From);
    return llvm.cast(ObjCBridgedCastExpr.class, From.$deref());
  }

  public static ObjCBridgedCastExpr cast_or_null_ObjCBridgedCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBridgedCastExpr(From);
  }

  public static ObjCBridgedCastExpr dyn_cast_ObjCBridgedCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static ObjCBridgedCastExpr dyn_cast_or_null_ObjCBridgedCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static boolean isa_ObjCBridgedCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBridgedCastExpr.class, From.$star());
  }

  public static ObjCBridgedCastExpr cast_ObjCBridgedCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBridgedCastExpr(From);
    return llvm.cast(ObjCBridgedCastExpr.class, From.$star());
  }

  public static ObjCBridgedCastExpr cast_or_null_ObjCBridgedCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBridgedCastExpr(From);
  }

  public static ObjCBridgedCastExpr dyn_cast_ObjCBridgedCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static ObjCBridgedCastExpr dyn_cast_or_null_ObjCBridgedCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBridgedCastExpr(From) ? cast_ObjCBridgedCastExpr(From) : null;
  }

  public static boolean isa_ObjCEncodeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCEncodeExpr.class, From.$deref());
  }

  public static ObjCEncodeExpr cast_ObjCEncodeExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCEncodeExpr(From);
    return llvm.cast(ObjCEncodeExpr.class, From.$deref());
  }

  public static ObjCEncodeExpr cast_or_null_ObjCEncodeExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCEncodeExpr(From);
  }

  public static ObjCEncodeExpr dyn_cast_ObjCEncodeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static ObjCEncodeExpr dyn_cast_or_null_ObjCEncodeExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static boolean isa_ObjCEncodeExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCEncodeExpr.classof(From);
  }

  public static ObjCEncodeExpr cast_ObjCEncodeExpr(Stmt/*P*/ From) {
    assert isa_ObjCEncodeExpr(From);
    return (ObjCEncodeExpr) From;
  }

  public static ObjCEncodeExpr cast_or_null_ObjCEncodeExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCEncodeExpr(From);
  }

  public static ObjCEncodeExpr dyn_cast_ObjCEncodeExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static ObjCEncodeExpr dyn_cast_or_null_ObjCEncodeExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static boolean isa_ObjCEncodeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCEncodeExpr.class, From.$star());
  }

  public static ObjCEncodeExpr cast_ObjCEncodeExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCEncodeExpr(From);
    return llvm.cast(ObjCEncodeExpr.class, From.$star());
  }

  public static ObjCEncodeExpr cast_or_null_ObjCEncodeExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCEncodeExpr(From);
  }

  public static ObjCEncodeExpr dyn_cast_ObjCEncodeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static ObjCEncodeExpr dyn_cast_or_null_ObjCEncodeExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCEncodeExpr(From) ? cast_ObjCEncodeExpr(From) : null;
  }

  public static boolean isa_ObjCIndirectCopyRestoreExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIndirectCopyRestoreExpr.class, From.$deref());
  }

  public static ObjCIndirectCopyRestoreExpr cast_ObjCIndirectCopyRestoreExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCIndirectCopyRestoreExpr(From);
    return llvm.cast(ObjCIndirectCopyRestoreExpr.class, From.$deref());
  }

  public static ObjCIndirectCopyRestoreExpr cast_or_null_ObjCIndirectCopyRestoreExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIndirectCopyRestoreExpr(From);
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_ObjCIndirectCopyRestoreExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_or_null_ObjCIndirectCopyRestoreExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static boolean isa_ObjCIndirectCopyRestoreExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIndirectCopyRestoreExpr.class, From.$star());
  }

  public static ObjCIndirectCopyRestoreExpr cast_ObjCIndirectCopyRestoreExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIndirectCopyRestoreExpr(From);
    return llvm.cast(ObjCIndirectCopyRestoreExpr.class, From.$star());
  }

  public static ObjCIndirectCopyRestoreExpr cast_or_null_ObjCIndirectCopyRestoreExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIndirectCopyRestoreExpr(From);
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_ObjCIndirectCopyRestoreExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_or_null_ObjCIndirectCopyRestoreExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static boolean isa_ObjCIndirectCopyRestoreExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCIndirectCopyRestoreExpr.classof(From);
  }

  public static ObjCIndirectCopyRestoreExpr cast_ObjCIndirectCopyRestoreExpr(Stmt/*P*/ From) {
    assert isa_ObjCIndirectCopyRestoreExpr(From);
    return (ObjCIndirectCopyRestoreExpr) From;
  }

  public static ObjCIndirectCopyRestoreExpr cast_or_null_ObjCIndirectCopyRestoreExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCIndirectCopyRestoreExpr(From);
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_ObjCIndirectCopyRestoreExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static ObjCIndirectCopyRestoreExpr dyn_cast_or_null_ObjCIndirectCopyRestoreExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCIndirectCopyRestoreExpr(From) ? cast_ObjCIndirectCopyRestoreExpr(From) : null;
  }

  public static boolean isa_ObjCIsaExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIsaExpr.class, From.$deref());
  }

  public static ObjCIsaExpr cast_ObjCIsaExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCIsaExpr(From);
    return llvm.cast(ObjCIsaExpr.class, From.$deref());
  }

  public static ObjCIsaExpr cast_or_null_ObjCIsaExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIsaExpr(From);
  }

  public static ObjCIsaExpr dyn_cast_ObjCIsaExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static ObjCIsaExpr dyn_cast_or_null_ObjCIsaExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static boolean isa_ObjCIsaExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCIsaExpr.classof(From);
  }

  public static ObjCIsaExpr cast_ObjCIsaExpr(Stmt/*P*/ From) {
    assert isa_ObjCIsaExpr(From);
    return (ObjCIsaExpr) From;
  }

  public static ObjCIsaExpr cast_or_null_ObjCIsaExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCIsaExpr(From);
  }

  public static ObjCIsaExpr dyn_cast_ObjCIsaExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static ObjCIsaExpr dyn_cast_or_null_ObjCIsaExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static boolean isa_ObjCIsaExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIsaExpr.class, From.$star());
  }

  public static ObjCIsaExpr cast_ObjCIsaExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIsaExpr(From);
    return llvm.cast(ObjCIsaExpr.class, From.$star());
  }

  public static ObjCIsaExpr cast_or_null_ObjCIsaExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIsaExpr(From);
  }

  public static ObjCIsaExpr dyn_cast_ObjCIsaExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static ObjCIsaExpr dyn_cast_or_null_ObjCIsaExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIsaExpr(From) ? cast_ObjCIsaExpr(From) : null;
  }

  public static boolean isa_ObjCIvarRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIvarRefExpr.class, From.$deref());
  }

  public static ObjCIvarRefExpr cast_ObjCIvarRefExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCIvarRefExpr(From);
    return llvm.cast(ObjCIvarRefExpr.class, From.$deref());
  }

  public static ObjCIvarRefExpr cast_or_null_ObjCIvarRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIvarRefExpr(From);
  }

  public static ObjCIvarRefExpr dyn_cast_ObjCIvarRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static ObjCIvarRefExpr dyn_cast_or_null_ObjCIvarRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static boolean isa_ObjCIvarRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCIvarRefExpr.classof(From);
  }

  public static ObjCIvarRefExpr cast_ObjCIvarRefExpr(Stmt/*P*/ From) {
    assert isa_ObjCIvarRefExpr(From);
    return (ObjCIvarRefExpr) From;
  }

  public static ObjCIvarRefExpr cast_or_null_ObjCIvarRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCIvarRefExpr(From);
  }

  public static ObjCIvarRefExpr dyn_cast_ObjCIvarRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static ObjCIvarRefExpr dyn_cast_or_null_ObjCIvarRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static boolean isa_ObjCIvarRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIvarRefExpr.class, From.$star());
  }

  public static ObjCIvarRefExpr cast_ObjCIvarRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIvarRefExpr(From);
    return llvm.cast(ObjCIvarRefExpr.class, From.$star());
  }

  public static ObjCIvarRefExpr cast_or_null_ObjCIvarRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIvarRefExpr(From);
  }

  public static ObjCIvarRefExpr dyn_cast_ObjCIvarRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static ObjCIvarRefExpr dyn_cast_or_null_ObjCIvarRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIvarRefExpr(From) ? cast_ObjCIvarRefExpr(From) : null;
  }

  public static boolean isa_ObjCMessageExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCMessageExpr.class, From.$star());
  }

  public static ObjCMessageExpr cast_ObjCMessageExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCMessageExpr(From);
    return llvm.cast(ObjCMessageExpr.class, From.$star());
  }

  public static ObjCMessageExpr cast_or_null_ObjCMessageExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCMessageExpr(From);
  }

  public static ObjCMessageExpr dyn_cast_ObjCMessageExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static ObjCMessageExpr dyn_cast_or_null_ObjCMessageExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static boolean isa_ObjCMessageExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCMessageExpr.class, From.$deref());
  }

  public static ObjCMessageExpr cast_ObjCMessageExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCMessageExpr(From);
    return llvm.cast(ObjCMessageExpr.class, From.$deref());
  }

  public static ObjCMessageExpr cast_or_null_ObjCMessageExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCMessageExpr(From);
  }

  public static ObjCMessageExpr dyn_cast_ObjCMessageExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static ObjCMessageExpr dyn_cast_or_null_ObjCMessageExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static boolean isa_ObjCMessageExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCMessageExpr.classof(From);
  }

  public static ObjCMessageExpr cast_ObjCMessageExpr(Stmt/*P*/ From) {
    assert isa_ObjCMessageExpr(From);
    return (ObjCMessageExpr) From;
  }

  public static ObjCMessageExpr cast_or_null_ObjCMessageExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCMessageExpr(From);
  }

  public static ObjCMessageExpr dyn_cast_ObjCMessageExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static ObjCMessageExpr dyn_cast_or_null_ObjCMessageExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCMessageExpr(From) ? cast_ObjCMessageExpr(From) : null;
  }

  public static boolean isa_ObjCPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCPropertyRefExpr.class, From.$deref());
  }

  public static ObjCPropertyRefExpr cast_ObjCPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCPropertyRefExpr(From);
    return llvm.cast(ObjCPropertyRefExpr.class, From.$deref());
  }

  public static ObjCPropertyRefExpr cast_or_null_ObjCPropertyRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCPropertyRefExpr(From);
  }

  public static ObjCPropertyRefExpr dyn_cast_ObjCPropertyRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static ObjCPropertyRefExpr dyn_cast_or_null_ObjCPropertyRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static boolean isa_ObjCPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCPropertyRefExpr.class, From.$star());
  }

  public static ObjCPropertyRefExpr cast_ObjCPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCPropertyRefExpr(From);
    return llvm.cast(ObjCPropertyRefExpr.class, From.$star());
  }

  public static ObjCPropertyRefExpr cast_or_null_ObjCPropertyRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCPropertyRefExpr(From);
  }

  public static ObjCPropertyRefExpr dyn_cast_ObjCPropertyRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static ObjCPropertyRefExpr dyn_cast_or_null_ObjCPropertyRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static boolean isa_ObjCPropertyRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCPropertyRefExpr.classof(From);
  }

  public static ObjCPropertyRefExpr cast_ObjCPropertyRefExpr(Stmt/*P*/ From) {
    assert isa_ObjCPropertyRefExpr(From);
    return (ObjCPropertyRefExpr) From;
  }

  public static ObjCPropertyRefExpr cast_or_null_ObjCPropertyRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCPropertyRefExpr(From);
  }

  public static ObjCPropertyRefExpr dyn_cast_ObjCPropertyRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static ObjCPropertyRefExpr dyn_cast_or_null_ObjCPropertyRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCPropertyRefExpr(From) ? cast_ObjCPropertyRefExpr(From) : null;
  }

  public static boolean isa_ObjCProtocolExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCProtocolExpr.classof(From);
  }

  public static ObjCProtocolExpr cast_ObjCProtocolExpr(Stmt/*P*/ From) {
    assert isa_ObjCProtocolExpr(From);
    return (ObjCProtocolExpr) From;
  }

  public static ObjCProtocolExpr cast_or_null_ObjCProtocolExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolExpr(From);
  }

  public static ObjCProtocolExpr dyn_cast_ObjCProtocolExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static ObjCProtocolExpr dyn_cast_or_null_ObjCProtocolExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static boolean isa_ObjCProtocolExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCProtocolExpr.class, From.$star());
  }

  public static ObjCProtocolExpr cast_ObjCProtocolExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCProtocolExpr(From);
    return llvm.cast(ObjCProtocolExpr.class, From.$star());
  }

  public static ObjCProtocolExpr cast_or_null_ObjCProtocolExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCProtocolExpr(From);
  }

  public static ObjCProtocolExpr dyn_cast_ObjCProtocolExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static ObjCProtocolExpr dyn_cast_or_null_ObjCProtocolExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static boolean isa_ObjCProtocolExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCProtocolExpr.class, From.$deref());
  }

  public static ObjCProtocolExpr cast_ObjCProtocolExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCProtocolExpr(From);
    return llvm.cast(ObjCProtocolExpr.class, From.$deref());
  }

  public static ObjCProtocolExpr cast_or_null_ObjCProtocolExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCProtocolExpr(From);
  }

  public static ObjCProtocolExpr dyn_cast_ObjCProtocolExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static ObjCProtocolExpr dyn_cast_or_null_ObjCProtocolExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCProtocolExpr(From) ? cast_ObjCProtocolExpr(From) : null;
  }

  public static boolean isa_ObjCSelectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCSelectorExpr.classof(From);
  }

  public static ObjCSelectorExpr cast_ObjCSelectorExpr(Stmt/*P*/ From) {
    assert isa_ObjCSelectorExpr(From);
    return (ObjCSelectorExpr) From;
  }

  public static ObjCSelectorExpr cast_or_null_ObjCSelectorExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCSelectorExpr(From);
  }

  public static ObjCSelectorExpr dyn_cast_ObjCSelectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static ObjCSelectorExpr dyn_cast_or_null_ObjCSelectorExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static boolean isa_ObjCSelectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCSelectorExpr.class, From.$deref());
  }

  public static ObjCSelectorExpr cast_ObjCSelectorExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCSelectorExpr(From);
    return llvm.cast(ObjCSelectorExpr.class, From.$deref());
  }

  public static ObjCSelectorExpr cast_or_null_ObjCSelectorExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCSelectorExpr(From);
  }

  public static ObjCSelectorExpr dyn_cast_ObjCSelectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static ObjCSelectorExpr dyn_cast_or_null_ObjCSelectorExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static boolean isa_ObjCSelectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCSelectorExpr.class, From.$star());
  }

  public static ObjCSelectorExpr cast_ObjCSelectorExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCSelectorExpr(From);
    return llvm.cast(ObjCSelectorExpr.class, From.$star());
  }

  public static ObjCSelectorExpr cast_or_null_ObjCSelectorExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCSelectorExpr(From);
  }

  public static ObjCSelectorExpr dyn_cast_ObjCSelectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static ObjCSelectorExpr dyn_cast_or_null_ObjCSelectorExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCSelectorExpr(From) ? cast_ObjCSelectorExpr(From) : null;
  }

  public static boolean isa_ObjCSubscriptRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return ObjCSubscriptRefExpr.classof(From);
  }

  public static ObjCSubscriptRefExpr cast_ObjCSubscriptRefExpr(Stmt/*P*/ From) {
    assert isa_ObjCSubscriptRefExpr(From);
    return (ObjCSubscriptRefExpr) From;
  }

  public static ObjCSubscriptRefExpr cast_or_null_ObjCSubscriptRefExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ObjCSubscriptRefExpr(From);
  }

  public static ObjCSubscriptRefExpr dyn_cast_ObjCSubscriptRefExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static ObjCSubscriptRefExpr dyn_cast_or_null_ObjCSubscriptRefExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static boolean isa_ObjCSubscriptRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCSubscriptRefExpr.class, From.$star());
  }

  public static ObjCSubscriptRefExpr cast_ObjCSubscriptRefExpr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCSubscriptRefExpr(From);
    return llvm.cast(ObjCSubscriptRefExpr.class, From.$star());
  }

  public static ObjCSubscriptRefExpr cast_or_null_ObjCSubscriptRefExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCSubscriptRefExpr(From);
  }

  public static ObjCSubscriptRefExpr dyn_cast_ObjCSubscriptRefExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static ObjCSubscriptRefExpr dyn_cast_or_null_ObjCSubscriptRefExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static boolean isa_ObjCSubscriptRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCSubscriptRefExpr.class, From.$deref());
  }

  public static ObjCSubscriptRefExpr cast_ObjCSubscriptRefExpr(type$ref<?>/*P*/ From) {
    assert isa_ObjCSubscriptRefExpr(From);
    return llvm.cast(ObjCSubscriptRefExpr.class, From.$deref());
  }

  public static ObjCSubscriptRefExpr cast_or_null_ObjCSubscriptRefExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCSubscriptRefExpr(From);
  }

  public static ObjCSubscriptRefExpr dyn_cast_ObjCSubscriptRefExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static ObjCSubscriptRefExpr dyn_cast_or_null_ObjCSubscriptRefExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCSubscriptRefExpr(From) ? cast_ObjCSubscriptRefExpr(From) : null;
  }

  public static boolean isa_OffsetOfExpr(Stmt/*P*/ From) {
    assert From != null;
    return OffsetOfExpr.classof(From);
  }

  public static OffsetOfExpr cast_OffsetOfExpr(Stmt/*P*/ From) {
    assert isa_OffsetOfExpr(From);
    return (OffsetOfExpr) From;
  }

  public static OffsetOfExpr cast_or_null_OffsetOfExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OffsetOfExpr(From);
  }

  public static OffsetOfExpr dyn_cast_OffsetOfExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static OffsetOfExpr dyn_cast_or_null_OffsetOfExpr(Stmt/*P*/ From) {
    return (From != null) && isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static boolean isa_OffsetOfExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OffsetOfExpr.class, From.$deref());
  }

  public static OffsetOfExpr cast_OffsetOfExpr(type$ref<?>/*P*/ From) {
    assert isa_OffsetOfExpr(From);
    return llvm.cast(OffsetOfExpr.class, From.$deref());
  }

  public static OffsetOfExpr cast_or_null_OffsetOfExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OffsetOfExpr(From);
  }

  public static OffsetOfExpr dyn_cast_OffsetOfExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static OffsetOfExpr dyn_cast_or_null_OffsetOfExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static boolean isa_OffsetOfExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OffsetOfExpr.class, From.$star());
  }

  public static OffsetOfExpr cast_OffsetOfExpr(type$ptr<?>/*P*/ From) {
    assert isa_OffsetOfExpr(From);
    return llvm.cast(OffsetOfExpr.class, From.$star());
  }

  public static OffsetOfExpr cast_or_null_OffsetOfExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OffsetOfExpr(From);
  }

  public static OffsetOfExpr dyn_cast_OffsetOfExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static OffsetOfExpr dyn_cast_or_null_OffsetOfExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OffsetOfExpr(From) ? cast_OffsetOfExpr(From) : null;
  }

  public static boolean isa_OpaqueValueExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OpaqueValueExpr.class, From.$star());
  }

  public static OpaqueValueExpr cast_OpaqueValueExpr(type$ptr<?>/*P*/ From) {
    assert isa_OpaqueValueExpr(From);
    return llvm.cast(OpaqueValueExpr.class, From.$star());
  }

  public static OpaqueValueExpr cast_or_null_OpaqueValueExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OpaqueValueExpr(From);
  }

  public static OpaqueValueExpr dyn_cast_OpaqueValueExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static OpaqueValueExpr dyn_cast_or_null_OpaqueValueExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static boolean isa_OpaqueValueExpr(Stmt/*P*/ From) {
    assert From != null;
    return OpaqueValueExpr.classof(From);
  }

  public static OpaqueValueExpr cast_OpaqueValueExpr(Stmt/*P*/ From) {
    assert isa_OpaqueValueExpr(From);
    return (OpaqueValueExpr) From;
  }

  public static OpaqueValueExpr cast_or_null_OpaqueValueExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OpaqueValueExpr(From);
  }

  public static OpaqueValueExpr dyn_cast_OpaqueValueExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static OpaqueValueExpr dyn_cast_or_null_OpaqueValueExpr(Stmt/*P*/ From) {
    return (From != null) && isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static boolean isa_OpaqueValueExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OpaqueValueExpr.class, From.$deref());
  }

  public static OpaqueValueExpr cast_OpaqueValueExpr(type$ref<?>/*P*/ From) {
    assert isa_OpaqueValueExpr(From);
    return llvm.cast(OpaqueValueExpr.class, From.$deref());
  }

  public static OpaqueValueExpr cast_or_null_OpaqueValueExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OpaqueValueExpr(From);
  }

  public static OpaqueValueExpr dyn_cast_OpaqueValueExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static OpaqueValueExpr dyn_cast_or_null_OpaqueValueExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OpaqueValueExpr(From) ? cast_OpaqueValueExpr(From) : null;
  }

  public static boolean isa_OverloadExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OverloadExpr.class, From.$deref());
  }

  public static OverloadExpr cast_OverloadExpr(type$ref<?>/*P*/ From) {
    assert isa_OverloadExpr(From);
    return llvm.cast(OverloadExpr.class, From.$deref());
  }

  public static OverloadExpr cast_or_null_OverloadExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OverloadExpr(From);
  }

  public static OverloadExpr dyn_cast_OverloadExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static OverloadExpr dyn_cast_or_null_OverloadExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static boolean isa_OverloadExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OverloadExpr.class, From.$star());
  }

  public static OverloadExpr cast_OverloadExpr(type$ptr<?>/*P*/ From) {
    assert isa_OverloadExpr(From);
    return llvm.cast(OverloadExpr.class, From.$star());
  }

  public static OverloadExpr cast_or_null_OverloadExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OverloadExpr(From);
  }

  public static OverloadExpr dyn_cast_OverloadExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static OverloadExpr dyn_cast_or_null_OverloadExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static boolean isa_OverloadExpr(Stmt/*P*/ From) {
    assert From != null;
    return OverloadExpr.classof(From);
  }

  public static OverloadExpr cast_OverloadExpr(Stmt/*P*/ From) {
    assert isa_OverloadExpr(From);
    return (OverloadExpr) From;
  }

  public static OverloadExpr cast_or_null_OverloadExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_OverloadExpr(From);
  }

  public static OverloadExpr dyn_cast_OverloadExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static OverloadExpr dyn_cast_or_null_OverloadExpr(Stmt/*P*/ From) {
    return (From != null) && isa_OverloadExpr(From) ? cast_OverloadExpr(From) : null;
  }

  public static boolean isa_PackExpansionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PackExpansionExpr.class, From.$deref());
  }

  public static PackExpansionExpr cast_PackExpansionExpr(type$ref<?>/*P*/ From) {
    assert isa_PackExpansionExpr(From);
    return llvm.cast(PackExpansionExpr.class, From.$deref());
  }

  public static PackExpansionExpr cast_or_null_PackExpansionExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PackExpansionExpr(From);
  }

  public static PackExpansionExpr dyn_cast_PackExpansionExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static PackExpansionExpr dyn_cast_or_null_PackExpansionExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static boolean isa_PackExpansionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PackExpansionExpr.class, From.$star());
  }

  public static PackExpansionExpr cast_PackExpansionExpr(type$ptr<?>/*P*/ From) {
    assert isa_PackExpansionExpr(From);
    return llvm.cast(PackExpansionExpr.class, From.$star());
  }

  public static PackExpansionExpr cast_or_null_PackExpansionExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PackExpansionExpr(From);
  }

  public static PackExpansionExpr dyn_cast_PackExpansionExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static PackExpansionExpr dyn_cast_or_null_PackExpansionExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static boolean isa_PackExpansionExpr(Stmt/*P*/ From) {
    assert From != null;
    return PackExpansionExpr.classof(From);
  }

  public static PackExpansionExpr cast_PackExpansionExpr(Stmt/*P*/ From) {
    assert isa_PackExpansionExpr(From);
    return (PackExpansionExpr) From;
  }

  public static PackExpansionExpr cast_or_null_PackExpansionExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_PackExpansionExpr(From);
  }

  public static PackExpansionExpr dyn_cast_PackExpansionExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static PackExpansionExpr dyn_cast_or_null_PackExpansionExpr(Stmt/*P*/ From) {
    return (From != null) && isa_PackExpansionExpr(From) ? cast_PackExpansionExpr(From) : null;
  }

  public static boolean isa_ParenExpr(Stmt/*P*/ From) {
    assert From != null;
    return ParenExpr.classof(From);
  }

  public static ParenExpr cast_ParenExpr(Stmt/*P*/ From) {
    assert isa_ParenExpr(From);
    return (ParenExpr) From;
  }

  public static ParenExpr cast_or_null_ParenExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ParenExpr(From);
  }

  public static ParenExpr dyn_cast_ParenExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static ParenExpr dyn_cast_or_null_ParenExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static boolean isa_ParenExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParenExpr.class, From.$deref());
  }

  public static ParenExpr cast_ParenExpr(type$ref<?>/*P*/ From) {
    assert isa_ParenExpr(From);
    return llvm.cast(ParenExpr.class, From.$deref());
  }

  public static ParenExpr cast_or_null_ParenExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParenExpr(From);
  }

  public static ParenExpr dyn_cast_ParenExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static ParenExpr dyn_cast_or_null_ParenExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static boolean isa_ParenExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParenExpr.class, From.$star());
  }

  public static ParenExpr cast_ParenExpr(type$ptr<?>/*P*/ From) {
    assert isa_ParenExpr(From);
    return llvm.cast(ParenExpr.class, From.$star());
  }

  public static ParenExpr cast_or_null_ParenExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParenExpr(From);
  }

  public static ParenExpr dyn_cast_ParenExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static ParenExpr dyn_cast_or_null_ParenExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParenExpr(From) ? cast_ParenExpr(From) : null;
  }

  public static boolean isa_ParenListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParenListExpr.class, From.$star());
  }

  public static ParenListExpr cast_ParenListExpr(type$ptr<?>/*P*/ From) {
    assert isa_ParenListExpr(From);
    return llvm.cast(ParenListExpr.class, From.$star());
  }

  public static ParenListExpr cast_or_null_ParenListExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParenListExpr(From);
  }

  public static ParenListExpr dyn_cast_ParenListExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static ParenListExpr dyn_cast_or_null_ParenListExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static boolean isa_ParenListExpr(Stmt/*P*/ From) {
    assert From != null;
    return ParenListExpr.classof(From);
  }

  public static ParenListExpr cast_ParenListExpr(Stmt/*P*/ From) {
    assert isa_ParenListExpr(From);
    return (ParenListExpr) From;
  }

  public static ParenListExpr cast_or_null_ParenListExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ParenListExpr(From);
  }

  public static ParenListExpr dyn_cast_ParenListExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static ParenListExpr dyn_cast_or_null_ParenListExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static boolean isa_ParenListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParenListExpr.class, From.$deref());
  }

  public static ParenListExpr cast_ParenListExpr(type$ref<?>/*P*/ From) {
    assert isa_ParenListExpr(From);
    return llvm.cast(ParenListExpr.class, From.$deref());
  }

  public static ParenListExpr cast_or_null_ParenListExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParenListExpr(From);
  }

  public static ParenListExpr dyn_cast_ParenListExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static ParenListExpr dyn_cast_or_null_ParenListExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParenListExpr(From) ? cast_ParenListExpr(From) : null;
  }

  public static boolean isa_PredefinedExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PredefinedExpr.class, From.$deref());
  }

  public static PredefinedExpr cast_PredefinedExpr(type$ref<?>/*P*/ From) {
    assert isa_PredefinedExpr(From);
    return llvm.cast(PredefinedExpr.class, From.$deref());
  }

  public static PredefinedExpr cast_or_null_PredefinedExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PredefinedExpr(From);
  }

  public static PredefinedExpr dyn_cast_PredefinedExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static PredefinedExpr dyn_cast_or_null_PredefinedExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static boolean isa_PredefinedExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PredefinedExpr.class, From.$star());
  }

  public static PredefinedExpr cast_PredefinedExpr(type$ptr<?>/*P*/ From) {
    assert isa_PredefinedExpr(From);
    return llvm.cast(PredefinedExpr.class, From.$star());
  }

  public static PredefinedExpr cast_or_null_PredefinedExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PredefinedExpr(From);
  }

  public static PredefinedExpr dyn_cast_PredefinedExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static PredefinedExpr dyn_cast_or_null_PredefinedExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static boolean isa_PredefinedExpr(Stmt/*P*/ From) {
    assert From != null;
    return PredefinedExpr.classof(From);
  }

  public static PredefinedExpr cast_PredefinedExpr(Stmt/*P*/ From) {
    assert isa_PredefinedExpr(From);
    return (PredefinedExpr) From;
  }

  public static PredefinedExpr cast_or_null_PredefinedExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_PredefinedExpr(From);
  }

  public static PredefinedExpr dyn_cast_PredefinedExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static PredefinedExpr dyn_cast_or_null_PredefinedExpr(Stmt/*P*/ From) {
    return (From != null) && isa_PredefinedExpr(From) ? cast_PredefinedExpr(From) : null;
  }

  public static boolean isa_PseudoObjectExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PseudoObjectExpr.class, From.$deref());
  }

  public static PseudoObjectExpr cast_PseudoObjectExpr(type$ref<?>/*P*/ From) {
    assert isa_PseudoObjectExpr(From);
    return llvm.cast(PseudoObjectExpr.class, From.$deref());
  }

  public static PseudoObjectExpr cast_or_null_PseudoObjectExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PseudoObjectExpr(From);
  }

  public static PseudoObjectExpr dyn_cast_PseudoObjectExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static PseudoObjectExpr dyn_cast_or_null_PseudoObjectExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static boolean isa_PseudoObjectExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PseudoObjectExpr.class, From.$star());
  }

  public static PseudoObjectExpr cast_PseudoObjectExpr(type$ptr<?>/*P*/ From) {
    assert isa_PseudoObjectExpr(From);
    return llvm.cast(PseudoObjectExpr.class, From.$star());
  }

  public static PseudoObjectExpr cast_or_null_PseudoObjectExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PseudoObjectExpr(From);
  }

  public static PseudoObjectExpr dyn_cast_PseudoObjectExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static PseudoObjectExpr dyn_cast_or_null_PseudoObjectExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static boolean isa_PseudoObjectExpr(Stmt/*P*/ From) {
    assert From != null;
    return PseudoObjectExpr.classof(From);
  }

  public static PseudoObjectExpr cast_PseudoObjectExpr(Stmt/*P*/ From) {
    assert isa_PseudoObjectExpr(From);
    return (PseudoObjectExpr) From;
  }

  public static PseudoObjectExpr cast_or_null_PseudoObjectExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_PseudoObjectExpr(From);
  }

  public static PseudoObjectExpr dyn_cast_PseudoObjectExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static PseudoObjectExpr dyn_cast_or_null_PseudoObjectExpr(Stmt/*P*/ From) {
    return (From != null) && isa_PseudoObjectExpr(From) ? cast_PseudoObjectExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return ShuffleVectorExpr.classof(From);
  }

  public static ShuffleVectorExpr cast_ShuffleVectorExpr(Stmt/*P*/ From) {
    assert isa_ShuffleVectorExpr(From);
    return (ShuffleVectorExpr) From;
  }

  public static ShuffleVectorExpr cast_or_null_ShuffleVectorExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_ShuffleVectorExpr(From);
  }

  public static ShuffleVectorExpr dyn_cast_ShuffleVectorExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static ShuffleVectorExpr dyn_cast_or_null_ShuffleVectorExpr(Stmt/*P*/ From) {
    return (From != null) && isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ShuffleVectorExpr.class, From.$star());
  }

  public static ShuffleVectorExpr cast_ShuffleVectorExpr(type$ptr<?>/*P*/ From) {
    assert isa_ShuffleVectorExpr(From);
    return llvm.cast(ShuffleVectorExpr.class, From.$star());
  }

  public static ShuffleVectorExpr cast_or_null_ShuffleVectorExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ShuffleVectorExpr(From);
  }

  public static ShuffleVectorExpr dyn_cast_ShuffleVectorExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static ShuffleVectorExpr dyn_cast_or_null_ShuffleVectorExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ShuffleVectorExpr.class, From.$deref());
  }

  public static ShuffleVectorExpr cast_ShuffleVectorExpr(type$ref<?>/*P*/ From) {
    assert isa_ShuffleVectorExpr(From);
    return llvm.cast(ShuffleVectorExpr.class, From.$deref());
  }

  public static ShuffleVectorExpr cast_or_null_ShuffleVectorExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ShuffleVectorExpr(From);
  }

  public static ShuffleVectorExpr dyn_cast_ShuffleVectorExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static ShuffleVectorExpr dyn_cast_or_null_ShuffleVectorExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ShuffleVectorExpr(From) ? cast_ShuffleVectorExpr(From) : null;
  }

  public static boolean isa_SizeOfPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return SizeOfPackExpr.classof(From);
  }

  public static SizeOfPackExpr cast_SizeOfPackExpr(Stmt/*P*/ From) {
    assert isa_SizeOfPackExpr(From);
    return (SizeOfPackExpr) From;
  }

  public static SizeOfPackExpr cast_or_null_SizeOfPackExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SizeOfPackExpr(From);
  }

  public static SizeOfPackExpr dyn_cast_SizeOfPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static SizeOfPackExpr dyn_cast_or_null_SizeOfPackExpr(Stmt/*P*/ From) {
    return (From != null) && isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static boolean isa_SizeOfPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SizeOfPackExpr.class, From.$star());
  }

  public static SizeOfPackExpr cast_SizeOfPackExpr(type$ptr<?>/*P*/ From) {
    assert isa_SizeOfPackExpr(From);
    return llvm.cast(SizeOfPackExpr.class, From.$star());
  }

  public static SizeOfPackExpr cast_or_null_SizeOfPackExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SizeOfPackExpr(From);
  }

  public static SizeOfPackExpr dyn_cast_SizeOfPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static SizeOfPackExpr dyn_cast_or_null_SizeOfPackExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static boolean isa_SizeOfPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SizeOfPackExpr.class, From.$deref());
  }

  public static SizeOfPackExpr cast_SizeOfPackExpr(type$ref<?>/*P*/ From) {
    assert isa_SizeOfPackExpr(From);
    return llvm.cast(SizeOfPackExpr.class, From.$deref());
  }

  public static SizeOfPackExpr cast_or_null_SizeOfPackExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SizeOfPackExpr(From);
  }

  public static SizeOfPackExpr dyn_cast_SizeOfPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static SizeOfPackExpr dyn_cast_or_null_SizeOfPackExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SizeOfPackExpr(From) ? cast_SizeOfPackExpr(From) : null;
  }

  public static boolean isa_StmtExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StmtExpr.class, From.$star());
  }

  public static StmtExpr cast_StmtExpr(type$ptr<?>/*P*/ From) {
    assert isa_StmtExpr(From);
    return llvm.cast(StmtExpr.class, From.$star());
  }

  public static StmtExpr cast_or_null_StmtExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StmtExpr(From);
  }

  public static StmtExpr dyn_cast_StmtExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static StmtExpr dyn_cast_or_null_StmtExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static boolean isa_StmtExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StmtExpr.class, From.$deref());
  }

  public static StmtExpr cast_StmtExpr(type$ref<?>/*P*/ From) {
    assert isa_StmtExpr(From);
    return llvm.cast(StmtExpr.class, From.$deref());
  }

  public static StmtExpr cast_or_null_StmtExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StmtExpr(From);
  }

  public static StmtExpr dyn_cast_StmtExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static StmtExpr dyn_cast_or_null_StmtExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static boolean isa_StmtExpr(Stmt/*P*/ From) {
    assert From != null;
    return StmtExpr.classof(From);
  }

  public static StmtExpr cast_StmtExpr(Stmt/*P*/ From) {
    assert isa_StmtExpr(From);
    return (StmtExpr) From;
  }

  public static StmtExpr cast_or_null_StmtExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_StmtExpr(From);
  }

  public static StmtExpr dyn_cast_StmtExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static StmtExpr dyn_cast_or_null_StmtExpr(Stmt/*P*/ From) {
    return (From != null) && isa_StmtExpr(From) ? cast_StmtExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubstNonTypeTemplateParmExpr.class, From.$deref());
  }

  public static SubstNonTypeTemplateParmExpr cast_SubstNonTypeTemplateParmExpr(type$ref<?>/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmExpr(From);
    return llvm.cast(SubstNonTypeTemplateParmExpr.class, From.$deref());
  }

  public static SubstNonTypeTemplateParmExpr cast_or_null_SubstNonTypeTemplateParmExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubstNonTypeTemplateParmExpr(From);
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_SubstNonTypeTemplateParmExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_or_null_SubstNonTypeTemplateParmExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubstNonTypeTemplateParmExpr.class, From.$star());
  }

  public static SubstNonTypeTemplateParmExpr cast_SubstNonTypeTemplateParmExpr(type$ptr<?>/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmExpr(From);
    return llvm.cast(SubstNonTypeTemplateParmExpr.class, From.$star());
  }

  public static SubstNonTypeTemplateParmExpr cast_or_null_SubstNonTypeTemplateParmExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubstNonTypeTemplateParmExpr(From);
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_SubstNonTypeTemplateParmExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_or_null_SubstNonTypeTemplateParmExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmExpr(Stmt/*P*/ From) {
    assert From != null;
    return SubstNonTypeTemplateParmExpr.classof(From);
  }

  public static SubstNonTypeTemplateParmExpr cast_SubstNonTypeTemplateParmExpr(Stmt/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmExpr(From);
    return (SubstNonTypeTemplateParmExpr) From;
  }

  public static SubstNonTypeTemplateParmExpr cast_or_null_SubstNonTypeTemplateParmExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SubstNonTypeTemplateParmExpr(From);
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_SubstNonTypeTemplateParmExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmExpr dyn_cast_or_null_SubstNonTypeTemplateParmExpr(Stmt/*P*/ From) {
    return (From != null) && isa_SubstNonTypeTemplateParmExpr(From) ? cast_SubstNonTypeTemplateParmExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubstNonTypeTemplateParmPackExpr.class, From.$deref());
  }

  public static SubstNonTypeTemplateParmPackExpr cast_SubstNonTypeTemplateParmPackExpr(type$ref<?>/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmPackExpr(From);
    return llvm.cast(SubstNonTypeTemplateParmPackExpr.class, From.$deref());
  }

  public static SubstNonTypeTemplateParmPackExpr cast_or_null_SubstNonTypeTemplateParmPackExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubstNonTypeTemplateParmPackExpr(From);
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_SubstNonTypeTemplateParmPackExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_or_null_SubstNonTypeTemplateParmPackExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubstNonTypeTemplateParmPackExpr.class, From.$star());
  }

  public static SubstNonTypeTemplateParmPackExpr cast_SubstNonTypeTemplateParmPackExpr(type$ptr<?>/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmPackExpr(From);
    return llvm.cast(SubstNonTypeTemplateParmPackExpr.class, From.$star());
  }

  public static SubstNonTypeTemplateParmPackExpr cast_or_null_SubstNonTypeTemplateParmPackExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubstNonTypeTemplateParmPackExpr(From);
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_SubstNonTypeTemplateParmPackExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_or_null_SubstNonTypeTemplateParmPackExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static boolean isa_SubstNonTypeTemplateParmPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return SubstNonTypeTemplateParmPackExpr.classof(From);
  }

  public static SubstNonTypeTemplateParmPackExpr cast_SubstNonTypeTemplateParmPackExpr(Stmt/*P*/ From) {
    assert isa_SubstNonTypeTemplateParmPackExpr(From);
    return (SubstNonTypeTemplateParmPackExpr) From;
  }

  public static SubstNonTypeTemplateParmPackExpr cast_or_null_SubstNonTypeTemplateParmPackExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_SubstNonTypeTemplateParmPackExpr(From);
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_SubstNonTypeTemplateParmPackExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static SubstNonTypeTemplateParmPackExpr dyn_cast_or_null_SubstNonTypeTemplateParmPackExpr(Stmt/*P*/ From) {
    return (From != null) && isa_SubstNonTypeTemplateParmPackExpr(From) ? cast_SubstNonTypeTemplateParmPackExpr(From) : null;
  }

  public static boolean isa_TypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return TypeTraitExpr.classof(From);
  }

  public static TypeTraitExpr cast_TypeTraitExpr(Stmt/*P*/ From) {
    assert isa_TypeTraitExpr(From);
    return (TypeTraitExpr) From;
  }

  public static TypeTraitExpr cast_or_null_TypeTraitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_TypeTraitExpr(From);
  }

  public static TypeTraitExpr dyn_cast_TypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static TypeTraitExpr dyn_cast_or_null_TypeTraitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static boolean isa_TypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeTraitExpr.class, From.$star());
  }

  public static TypeTraitExpr cast_TypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert isa_TypeTraitExpr(From);
    return llvm.cast(TypeTraitExpr.class, From.$star());
  }

  public static TypeTraitExpr cast_or_null_TypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeTraitExpr(From);
  }

  public static TypeTraitExpr dyn_cast_TypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static TypeTraitExpr dyn_cast_or_null_TypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static boolean isa_TypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeTraitExpr.class, From.$deref());
  }

  public static TypeTraitExpr cast_TypeTraitExpr(type$ref<?>/*P*/ From) {
    assert isa_TypeTraitExpr(From);
    return llvm.cast(TypeTraitExpr.class, From.$deref());
  }

  public static TypeTraitExpr cast_or_null_TypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeTraitExpr(From);
  }

  public static TypeTraitExpr dyn_cast_TypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static TypeTraitExpr dyn_cast_or_null_TypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeTraitExpr(From) ? cast_TypeTraitExpr(From) : null;
  }

  public static boolean isa_TypoExpr(Stmt/*P*/ From) {
    assert From != null;
    return TypoExpr.classof(From);
  }

  public static TypoExpr cast_TypoExpr(Stmt/*P*/ From) {
    assert isa_TypoExpr(From);
    return (TypoExpr) From;
  }

  public static TypoExpr cast_or_null_TypoExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_TypoExpr(From);
  }

  public static TypoExpr dyn_cast_TypoExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static TypoExpr dyn_cast_or_null_TypoExpr(Stmt/*P*/ From) {
    return (From != null) && isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static boolean isa_TypoExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypoExpr.class, From.$star());
  }

  public static TypoExpr cast_TypoExpr(type$ptr<?>/*P*/ From) {
    assert isa_TypoExpr(From);
    return llvm.cast(TypoExpr.class, From.$star());
  }

  public static TypoExpr cast_or_null_TypoExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypoExpr(From);
  }

  public static TypoExpr dyn_cast_TypoExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static TypoExpr dyn_cast_or_null_TypoExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static boolean isa_TypoExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypoExpr.class, From.$deref());
  }

  public static TypoExpr cast_TypoExpr(type$ref<?>/*P*/ From) {
    assert isa_TypoExpr(From);
    return llvm.cast(TypoExpr.class, From.$deref());
  }

  public static TypoExpr cast_or_null_TypoExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypoExpr(From);
  }

  public static TypoExpr dyn_cast_TypoExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static TypoExpr dyn_cast_or_null_TypoExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypoExpr(From) ? cast_TypoExpr(From) : null;
  }

  public static boolean isa_UnaryExprOrTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryExprOrTypeTraitExpr.class, From.$star());
  }

  public static UnaryExprOrTypeTraitExpr cast_UnaryExprOrTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert isa_UnaryExprOrTypeTraitExpr(From);
    return llvm.cast(UnaryExprOrTypeTraitExpr.class, From.$star());
  }

  public static UnaryExprOrTypeTraitExpr cast_or_null_UnaryExprOrTypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryExprOrTypeTraitExpr(From);
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_UnaryExprOrTypeTraitExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_or_null_UnaryExprOrTypeTraitExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static boolean isa_UnaryExprOrTypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return UnaryExprOrTypeTraitExpr.classof(From);
  }

  public static UnaryExprOrTypeTraitExpr cast_UnaryExprOrTypeTraitExpr(Stmt/*P*/ From) {
    assert isa_UnaryExprOrTypeTraitExpr(From);
    return (UnaryExprOrTypeTraitExpr) From;
  }

  public static UnaryExprOrTypeTraitExpr cast_or_null_UnaryExprOrTypeTraitExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_UnaryExprOrTypeTraitExpr(From);
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_UnaryExprOrTypeTraitExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_or_null_UnaryExprOrTypeTraitExpr(Stmt/*P*/ From) {
    return (From != null) && isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static boolean isa_UnaryExprOrTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryExprOrTypeTraitExpr.class, From.$deref());
  }

  public static UnaryExprOrTypeTraitExpr cast_UnaryExprOrTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert isa_UnaryExprOrTypeTraitExpr(From);
    return llvm.cast(UnaryExprOrTypeTraitExpr.class, From.$deref());
  }

  public static UnaryExprOrTypeTraitExpr cast_or_null_UnaryExprOrTypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryExprOrTypeTraitExpr(From);
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_UnaryExprOrTypeTraitExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static UnaryExprOrTypeTraitExpr dyn_cast_or_null_UnaryExprOrTypeTraitExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryExprOrTypeTraitExpr(From) ? cast_UnaryExprOrTypeTraitExpr(From) : null;
  }

  public static boolean isa_UnresolvedLookupExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnresolvedLookupExpr.class, From.$deref());
  }

  public static UnresolvedLookupExpr cast_UnresolvedLookupExpr(type$ref<?>/*P*/ From) {
    assert isa_UnresolvedLookupExpr(From);
    return llvm.cast(UnresolvedLookupExpr.class, From.$deref());
  }

  public static UnresolvedLookupExpr cast_or_null_UnresolvedLookupExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnresolvedLookupExpr(From);
  }

  public static UnresolvedLookupExpr dyn_cast_UnresolvedLookupExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static UnresolvedLookupExpr dyn_cast_or_null_UnresolvedLookupExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static boolean isa_UnresolvedLookupExpr(Stmt/*P*/ From) {
    assert From != null;
    return UnresolvedLookupExpr.classof(From);
  }

  public static UnresolvedLookupExpr cast_UnresolvedLookupExpr(Stmt/*P*/ From) {
    assert isa_UnresolvedLookupExpr(From);
    return (UnresolvedLookupExpr) From;
  }

  public static UnresolvedLookupExpr cast_or_null_UnresolvedLookupExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_UnresolvedLookupExpr(From);
  }

  public static UnresolvedLookupExpr dyn_cast_UnresolvedLookupExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static UnresolvedLookupExpr dyn_cast_or_null_UnresolvedLookupExpr(Stmt/*P*/ From) {
    return (From != null) && isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static boolean isa_UnresolvedLookupExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnresolvedLookupExpr.class, From.$star());
  }

  public static UnresolvedLookupExpr cast_UnresolvedLookupExpr(type$ptr<?>/*P*/ From) {
    assert isa_UnresolvedLookupExpr(From);
    return llvm.cast(UnresolvedLookupExpr.class, From.$star());
  }

  public static UnresolvedLookupExpr cast_or_null_UnresolvedLookupExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnresolvedLookupExpr(From);
  }

  public static UnresolvedLookupExpr dyn_cast_UnresolvedLookupExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static UnresolvedLookupExpr dyn_cast_or_null_UnresolvedLookupExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnresolvedLookupExpr(From) ? cast_UnresolvedLookupExpr(From) : null;
  }

  public static boolean isa_UnresolvedMemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnresolvedMemberExpr.class, From.$star());
  }

  public static UnresolvedMemberExpr cast_UnresolvedMemberExpr(type$ptr<?>/*P*/ From) {
    assert isa_UnresolvedMemberExpr(From);
    return llvm.cast(UnresolvedMemberExpr.class, From.$star());
  }

  public static UnresolvedMemberExpr cast_or_null_UnresolvedMemberExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnresolvedMemberExpr(From);
  }

  public static UnresolvedMemberExpr dyn_cast_UnresolvedMemberExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static UnresolvedMemberExpr dyn_cast_or_null_UnresolvedMemberExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static boolean isa_UnresolvedMemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnresolvedMemberExpr.class, From.$deref());
  }

  public static UnresolvedMemberExpr cast_UnresolvedMemberExpr(type$ref<?>/*P*/ From) {
    assert isa_UnresolvedMemberExpr(From);
    return llvm.cast(UnresolvedMemberExpr.class, From.$deref());
  }

  public static UnresolvedMemberExpr cast_or_null_UnresolvedMemberExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnresolvedMemberExpr(From);
  }

  public static UnresolvedMemberExpr dyn_cast_UnresolvedMemberExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static UnresolvedMemberExpr dyn_cast_or_null_UnresolvedMemberExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static boolean isa_UnresolvedMemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return UnresolvedMemberExpr.classof(From);
  }

  public static UnresolvedMemberExpr cast_UnresolvedMemberExpr(Stmt/*P*/ From) {
    assert isa_UnresolvedMemberExpr(From);
    return (UnresolvedMemberExpr) From;
  }

  public static UnresolvedMemberExpr cast_or_null_UnresolvedMemberExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_UnresolvedMemberExpr(From);
  }

  public static UnresolvedMemberExpr dyn_cast_UnresolvedMemberExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static UnresolvedMemberExpr dyn_cast_or_null_UnresolvedMemberExpr(Stmt/*P*/ From) {
    return (From != null) && isa_UnresolvedMemberExpr(From) ? cast_UnresolvedMemberExpr(From) : null;
  }

  public static boolean isa_VAArgExpr(Stmt/*P*/ From) {
    assert From != null;
    return VAArgExpr.classof(From);
  }

  public static VAArgExpr cast_VAArgExpr(Stmt/*P*/ From) {
    assert isa_VAArgExpr(From);
    return (VAArgExpr) From;
  }

  public static VAArgExpr cast_or_null_VAArgExpr(Stmt/*P*/ From) {
    return (From == null) ? null : cast_VAArgExpr(From);
  }

  public static VAArgExpr dyn_cast_VAArgExpr(Stmt/*P*/ From) {
    assert From != null;
    return isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }

  public static VAArgExpr dyn_cast_or_null_VAArgExpr(Stmt/*P*/ From) {
    return (From != null) && isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }

  public static boolean isa_VAArgExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VAArgExpr.class, From.$deref());
  }

  public static VAArgExpr cast_VAArgExpr(type$ref<?>/*P*/ From) {
    assert isa_VAArgExpr(From);
    return llvm.cast(VAArgExpr.class, From.$deref());
  }

  public static VAArgExpr cast_or_null_VAArgExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VAArgExpr(From);
  }

  public static VAArgExpr dyn_cast_VAArgExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }

  public static VAArgExpr dyn_cast_or_null_VAArgExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }

  public static boolean isa_VAArgExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VAArgExpr.class, From.$star());
  }

  public static VAArgExpr cast_VAArgExpr(type$ptr<?>/*P*/ From) {
    assert isa_VAArgExpr(From);
    return llvm.cast(VAArgExpr.class, From.$star());
  }

  public static VAArgExpr cast_or_null_VAArgExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VAArgExpr(From);
  }

  public static VAArgExpr dyn_cast_VAArgExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }

  public static VAArgExpr dyn_cast_or_null_VAArgExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VAArgExpr(From) ? cast_VAArgExpr(From) : null;
  }
}
