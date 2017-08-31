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
package org.clang.codegen.java;

import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.impl.CGOpenMPRuntime.OffloadEntriesInfoManagerTy.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.target.impl.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class CodegenRTTI {
  /*package*/CodegenRTTI() {}

  public static boolean isa_ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(ABIInfo.class, From);
  }

  public static ABIInfo cast_ABIInfo(ABIInfo/*P*/ From) {
    assert isa_ABIInfo(From);
    return llvm.cast(ABIInfo.class, From);
  }

  public static ABIInfo cast_or_null_ABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_ABIInfo(From);
  }

  public static ABIInfo dyn_cast_ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static ABIInfo dyn_cast_or_null_ABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static boolean isa_ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ABIInfo.class, From.$deref());
  }

  public static ABIInfo cast_ABIInfo(type$ref<?>/*P*/ From) {
    assert isa_ABIInfo(From);
    return llvm.cast(ABIInfo.class, From.$deref());
  }

  public static ABIInfo cast_or_null_ABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ABIInfo(From);
  }

  public static ABIInfo dyn_cast_ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static ABIInfo dyn_cast_or_null_ABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static boolean isa_ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ABIInfo.class, From.$star());
  }

  public static ABIInfo cast_ABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_ABIInfo(From);
    return llvm.cast(ABIInfo.class, From.$star());
  }

  public static ABIInfo cast_or_null_ABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ABIInfo(From);
  }

  public static ABIInfo dyn_cast_ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static ABIInfo dyn_cast_or_null_ABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ABIInfo(From) ? cast_ABIInfo(From) : null;
  }

  public static boolean isa_OffloadEntryInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OffloadEntryInfo.class, From.$star());
  }

  public static OffloadEntryInfo cast_OffloadEntryInfo(type$ptr<?>/*P*/ From) {
    assert isa_OffloadEntryInfo(From);
    return llvm.cast(OffloadEntryInfo.class, From.$star());
  }

  public static OffloadEntryInfo cast_or_null_OffloadEntryInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OffloadEntryInfo(From);
  }

  public static OffloadEntryInfo dyn_cast_OffloadEntryInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static OffloadEntryInfo dyn_cast_or_null_OffloadEntryInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static boolean isa_OffloadEntryInfoTargetRegion(OffloadEntryInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(OffloadEntryInfoTargetRegion.class, From);
  }

  public static OffloadEntryInfoTargetRegion cast_OffloadEntryInfoTargetRegion(OffloadEntryInfo/*P*/ From) {
    assert isa_OffloadEntryInfoTargetRegion(From);
    return llvm.cast(OffloadEntryInfoTargetRegion.class, From);
  }

  public static OffloadEntryInfoTargetRegion cast_or_null_OffloadEntryInfoTargetRegion(OffloadEntryInfo/*P*/ From) {
    return (From == null) ? null : cast_OffloadEntryInfoTargetRegion(From);
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_OffloadEntryInfoTargetRegion(OffloadEntryInfo/*P*/ From) {
    assert From != null;
    return isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_or_null_OffloadEntryInfoTargetRegion(OffloadEntryInfo/*P*/ From) {
    return (From != null) && isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static boolean isa_OffloadEntryInfoTargetRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OffloadEntryInfoTargetRegion.class, From.$deref());
  }

  public static OffloadEntryInfoTargetRegion cast_OffloadEntryInfoTargetRegion(type$ref<?>/*P*/ From) {
    assert isa_OffloadEntryInfoTargetRegion(From);
    return llvm.cast(OffloadEntryInfoTargetRegion.class, From.$deref());
  }

  public static OffloadEntryInfoTargetRegion cast_or_null_OffloadEntryInfoTargetRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OffloadEntryInfoTargetRegion(From);
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_OffloadEntryInfoTargetRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_or_null_OffloadEntryInfoTargetRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static boolean isa_OffloadEntryInfoTargetRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OffloadEntryInfoTargetRegion.class, From.$star());
  }

  public static OffloadEntryInfoTargetRegion cast_OffloadEntryInfoTargetRegion(type$ptr<?>/*P*/ From) {
    assert isa_OffloadEntryInfoTargetRegion(From);
    return llvm.cast(OffloadEntryInfoTargetRegion.class, From.$star());
  }

  public static OffloadEntryInfoTargetRegion cast_or_null_OffloadEntryInfoTargetRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OffloadEntryInfoTargetRegion(From);
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_OffloadEntryInfoTargetRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static OffloadEntryInfoTargetRegion dyn_cast_or_null_OffloadEntryInfoTargetRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OffloadEntryInfoTargetRegion(From) ? cast_OffloadEntryInfoTargetRegion(From) : null;
  }

  public static boolean isa_OffloadEntryInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OffloadEntryInfo.class, From.$deref());
  }

  public static OffloadEntryInfo cast_OffloadEntryInfo(type$ref<?>/*P*/ From) {
    assert isa_OffloadEntryInfo(From);
    return llvm.cast(OffloadEntryInfo.class, From.$deref());
  }

  public static OffloadEntryInfo cast_or_null_OffloadEntryInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OffloadEntryInfo(From);
  }

  public static OffloadEntryInfo dyn_cast_OffloadEntryInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static OffloadEntryInfo dyn_cast_or_null_OffloadEntryInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static boolean isa_OffloadEntryInfo(OffloadEntryInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(OffloadEntryInfo.class, From);
  }

  public static OffloadEntryInfo cast_OffloadEntryInfo(OffloadEntryInfo/*P*/ From) {
    assert isa_OffloadEntryInfo(From);
    return llvm.cast(OffloadEntryInfo.class, From);
  }

  public static OffloadEntryInfo cast_or_null_OffloadEntryInfo(OffloadEntryInfo/*P*/ From) {
    return (From == null) ? null : cast_OffloadEntryInfo(From);
  }

  public static OffloadEntryInfo dyn_cast_OffloadEntryInfo(OffloadEntryInfo/*P*/ From) {
    assert From != null;
    return isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static OffloadEntryInfo dyn_cast_or_null_OffloadEntryInfo(OffloadEntryInfo/*P*/ From) {
    return (From != null) && isa_OffloadEntryInfo(From) ? cast_OffloadEntryInfo(From) : null;
  }

  public static boolean isa_EHCatchScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHCatchScope.class, From);
  }

  public static EHCatchScope cast_EHCatchScope(EHScope/*P*/ From) {
    assert isa_EHCatchScope(From);
    return llvm.cast(EHCatchScope.class, From);
  }

  public static EHCatchScope cast_or_null_EHCatchScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHCatchScope(From);
  }

  public static EHCatchScope dyn_cast_EHCatchScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static EHCatchScope dyn_cast_or_null_EHCatchScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static boolean isa_EHCatchScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHCatchScope.class, From.$deref());
  }

  public static EHCatchScope cast_EHCatchScope(type$ref<?>/*P*/ From) {
    assert isa_EHCatchScope(From);
    return llvm.cast(EHCatchScope.class, From.$deref());
  }

  public static EHCatchScope cast_or_null_EHCatchScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHCatchScope(From);
  }

  public static EHCatchScope dyn_cast_EHCatchScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static EHCatchScope dyn_cast_or_null_EHCatchScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static boolean isa_EHCatchScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHCatchScope.class, From.$star());
  }

  public static EHCatchScope cast_EHCatchScope(type$ptr<?>/*P*/ From) {
    assert isa_EHCatchScope(From);
    return llvm.cast(EHCatchScope.class, From.$star());
  }

  public static EHCatchScope cast_or_null_EHCatchScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHCatchScope(From);
  }

  public static EHCatchScope dyn_cast_EHCatchScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static EHCatchScope dyn_cast_or_null_EHCatchScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHCatchScope(From) ? cast_EHCatchScope(From) : null;
  }

  public static boolean isa_EHCleanupScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHCleanupScope.class, From);
  }

  public static EHCleanupScope cast_EHCleanupScope(EHScope/*P*/ From) {
    assert isa_EHCleanupScope(From);
    return llvm.cast(EHCleanupScope.class, From);
  }

  public static EHCleanupScope cast_or_null_EHCleanupScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHCleanupScope(From);
  }

  public static EHCleanupScope dyn_cast_EHCleanupScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static EHCleanupScope dyn_cast_or_null_EHCleanupScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static boolean isa_EHCleanupScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHCleanupScope.class, From.$deref());
  }

  public static EHCleanupScope cast_EHCleanupScope(type$ref<?>/*P*/ From) {
    assert isa_EHCleanupScope(From);
    return llvm.cast(EHCleanupScope.class, From.$deref());
  }

  public static EHCleanupScope cast_or_null_EHCleanupScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHCleanupScope(From);
  }

  public static EHCleanupScope dyn_cast_EHCleanupScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static EHCleanupScope dyn_cast_or_null_EHCleanupScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static boolean isa_EHCleanupScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHCleanupScope.class, From.$star());
  }

  public static EHCleanupScope cast_EHCleanupScope(type$ptr<?>/*P*/ From) {
    assert isa_EHCleanupScope(From);
    return llvm.cast(EHCleanupScope.class, From.$star());
  }

  public static EHCleanupScope cast_or_null_EHCleanupScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHCleanupScope(From);
  }

  public static EHCleanupScope dyn_cast_EHCleanupScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static EHCleanupScope dyn_cast_or_null_EHCleanupScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHCleanupScope(From) ? cast_EHCleanupScope(From) : null;
  }

  public static boolean isa_EHFilterScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHFilterScope.class, From);
  }

  public static EHFilterScope cast_EHFilterScope(EHScope/*P*/ From) {
    assert isa_EHFilterScope(From);
    return llvm.cast(EHFilterScope.class, From);
  }

  public static EHFilterScope cast_or_null_EHFilterScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHFilterScope(From);
  }

  public static EHFilterScope dyn_cast_EHFilterScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static EHFilterScope dyn_cast_or_null_EHFilterScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static boolean isa_EHFilterScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHFilterScope.class, From.$star());
  }

  public static EHFilterScope cast_EHFilterScope(type$ptr<?>/*P*/ From) {
    assert isa_EHFilterScope(From);
    return llvm.cast(EHFilterScope.class, From.$star());
  }

  public static EHFilterScope cast_or_null_EHFilterScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHFilterScope(From);
  }

  public static EHFilterScope dyn_cast_EHFilterScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static EHFilterScope dyn_cast_or_null_EHFilterScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static boolean isa_EHFilterScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHFilterScope.class, From.$deref());
  }

  public static EHFilterScope cast_EHFilterScope(type$ref<?>/*P*/ From) {
    assert isa_EHFilterScope(From);
    return llvm.cast(EHFilterScope.class, From.$deref());
  }

  public static EHFilterScope cast_or_null_EHFilterScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHFilterScope(From);
  }

  public static EHFilterScope dyn_cast_EHFilterScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static EHFilterScope dyn_cast_or_null_EHFilterScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHFilterScope(From) ? cast_EHFilterScope(From) : null;
  }

  public static boolean isa_EHPadEndScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHPadEndScope.class, From.$deref());
  }

  public static EHPadEndScope cast_EHPadEndScope(type$ref<?>/*P*/ From) {
    assert isa_EHPadEndScope(From);
    return llvm.cast(EHPadEndScope.class, From.$deref());
  }

  public static EHPadEndScope cast_or_null_EHPadEndScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHPadEndScope(From);
  }

  public static EHPadEndScope dyn_cast_EHPadEndScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static EHPadEndScope dyn_cast_or_null_EHPadEndScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static boolean isa_EHPadEndScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHPadEndScope.class, From);
  }

  public static EHPadEndScope cast_EHPadEndScope(EHScope/*P*/ From) {
    assert isa_EHPadEndScope(From);
    return llvm.cast(EHPadEndScope.class, From);
  }

  public static EHPadEndScope cast_or_null_EHPadEndScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHPadEndScope(From);
  }

  public static EHPadEndScope dyn_cast_EHPadEndScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static EHPadEndScope dyn_cast_or_null_EHPadEndScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static boolean isa_EHPadEndScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHPadEndScope.class, From.$star());
  }

  public static EHPadEndScope cast_EHPadEndScope(type$ptr<?>/*P*/ From) {
    assert isa_EHPadEndScope(From);
    return llvm.cast(EHPadEndScope.class, From.$star());
  }

  public static EHPadEndScope cast_or_null_EHPadEndScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHPadEndScope(From);
  }

  public static EHPadEndScope dyn_cast_EHPadEndScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static EHPadEndScope dyn_cast_or_null_EHPadEndScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHPadEndScope(From) ? cast_EHPadEndScope(From) : null;
  }

  public static boolean isa_EHScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHScope.class, From);
  }

  public static EHScope cast_EHScope(EHScope/*P*/ From) {
    assert isa_EHScope(From);
    return llvm.cast(EHScope.class, From);
  }

  public static EHScope cast_or_null_EHScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHScope(From);
  }

  public static EHScope dyn_cast_EHScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static EHScope dyn_cast_or_null_EHScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static boolean isa_EHScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHScope.class, From.$deref());
  }

  public static EHScope cast_EHScope(type$ref<?>/*P*/ From) {
    assert isa_EHScope(From);
    return llvm.cast(EHScope.class, From.$deref());
  }

  public static EHScope cast_or_null_EHScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHScope(From);
  }

  public static EHScope dyn_cast_EHScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static EHScope dyn_cast_or_null_EHScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static boolean isa_EHScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHScope.class, From.$star());
  }

  public static EHScope cast_EHScope(type$ptr<?>/*P*/ From) {
    assert isa_EHScope(From);
    return llvm.cast(EHScope.class, From.$star());
  }

  public static EHScope cast_or_null_EHScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHScope(From);
  }

  public static EHScope dyn_cast_EHScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static EHScope dyn_cast_or_null_EHScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHScope(From) ? cast_EHScope(From) : null;
  }

  public static boolean isa_EHTerminateScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EHTerminateScope.class, From.$deref());
  }

  public static EHTerminateScope cast_EHTerminateScope(type$ref<?>/*P*/ From) {
    assert isa_EHTerminateScope(From);
    return llvm.cast(EHTerminateScope.class, From.$deref());
  }

  public static EHTerminateScope cast_or_null_EHTerminateScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EHTerminateScope(From);
  }

  public static EHTerminateScope dyn_cast_EHTerminateScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static EHTerminateScope dyn_cast_or_null_EHTerminateScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static boolean isa_EHTerminateScope(EHScope/*P*/ From) {
    assert From != null;
    return llvm.isa(EHTerminateScope.class, From);
  }

  public static EHTerminateScope cast_EHTerminateScope(EHScope/*P*/ From) {
    assert isa_EHTerminateScope(From);
    return llvm.cast(EHTerminateScope.class, From);
  }

  public static EHTerminateScope cast_or_null_EHTerminateScope(EHScope/*P*/ From) {
    return (From == null) ? null : cast_EHTerminateScope(From);
  }

  public static EHTerminateScope dyn_cast_EHTerminateScope(EHScope/*P*/ From) {
    assert From != null;
    return isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static EHTerminateScope dyn_cast_or_null_EHTerminateScope(EHScope/*P*/ From) {
    return (From != null) && isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static boolean isa_EHTerminateScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EHTerminateScope.class, From.$star());
  }

  public static EHTerminateScope cast_EHTerminateScope(type$ptr<?>/*P*/ From) {
    assert isa_EHTerminateScope(From);
    return llvm.cast(EHTerminateScope.class, From.$star());
  }

  public static EHTerminateScope cast_or_null_EHTerminateScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EHTerminateScope(From);
  }

  public static EHTerminateScope dyn_cast_EHTerminateScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static EHTerminateScope dyn_cast_or_null_EHTerminateScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EHTerminateScope(From) ? cast_EHTerminateScope(From) : null;
  }

  public static boolean isa_SwiftABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwiftABIInfo.class, From.$deref());
  }

  public static SwiftABIInfo cast_SwiftABIInfo(type$ref<?>/*P*/ From) {
    assert isa_SwiftABIInfo(From);
    return llvm.cast(SwiftABIInfo.class, From.$deref());
  }

  public static SwiftABIInfo cast_or_null_SwiftABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwiftABIInfo(From);
  }

  public static SwiftABIInfo dyn_cast_SwiftABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static SwiftABIInfo dyn_cast_or_null_SwiftABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static boolean isa_SwiftABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwiftABIInfo.class, From.$star());
  }

  public static SwiftABIInfo cast_SwiftABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_SwiftABIInfo(From);
    return llvm.cast(SwiftABIInfo.class, From.$star());
  }

  public static SwiftABIInfo cast_or_null_SwiftABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwiftABIInfo(From);
  }

  public static SwiftABIInfo dyn_cast_SwiftABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static SwiftABIInfo dyn_cast_or_null_SwiftABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static boolean isa_SwiftABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(SwiftABIInfo.class, From);
  }

  public static SwiftABIInfo cast_SwiftABIInfo(ABIInfo/*P*/ From) {
    assert isa_SwiftABIInfo(From);
    return llvm.cast(SwiftABIInfo.class, From);
  }

  public static SwiftABIInfo cast_or_null_SwiftABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_SwiftABIInfo(From);
  }

  public static SwiftABIInfo dyn_cast_SwiftABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static SwiftABIInfo dyn_cast_or_null_SwiftABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_SwiftABIInfo(From) ? cast_SwiftABIInfo(From) : null;
  }

  public static boolean isa_ComplexExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return llvm.isa(ComplexExpansion.class, From);
  }

  public static ComplexExpansion cast_ComplexExpansion(TypeExpansion/*P*/ From) {
    assert isa_ComplexExpansion(From);
    return llvm.cast(ComplexExpansion.class, From);
  }

  public static ComplexExpansion cast_or_null_ComplexExpansion(TypeExpansion/*P*/ From) {
    return (From == null) ? null : cast_ComplexExpansion(From);
  }

  public static ComplexExpansion dyn_cast_ComplexExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static ComplexExpansion dyn_cast_or_null_ComplexExpansion(TypeExpansion/*P*/ From) {
    return (From != null) && isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static boolean isa_ComplexExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ComplexExpansion.class, From.$deref());
  }

  public static ComplexExpansion cast_ComplexExpansion(type$ref<?>/*P*/ From) {
    assert isa_ComplexExpansion(From);
    return llvm.cast(ComplexExpansion.class, From.$deref());
  }

  public static ComplexExpansion cast_or_null_ComplexExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ComplexExpansion(From);
  }

  public static ComplexExpansion dyn_cast_ComplexExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static ComplexExpansion dyn_cast_or_null_ComplexExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static boolean isa_ComplexExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ComplexExpansion.class, From.$star());
  }

  public static ComplexExpansion cast_ComplexExpansion(type$ptr<?>/*P*/ From) {
    assert isa_ComplexExpansion(From);
    return llvm.cast(ComplexExpansion.class, From.$star());
  }

  public static ComplexExpansion cast_or_null_ComplexExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ComplexExpansion(From);
  }

  public static ComplexExpansion dyn_cast_ComplexExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static ComplexExpansion dyn_cast_or_null_ComplexExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ComplexExpansion(From) ? cast_ComplexExpansion(From) : null;
  }

  public static boolean isa_ConstantArrayExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantArrayExpansion.class, From.$deref());
  }

  public static ConstantArrayExpansion cast_ConstantArrayExpansion(type$ref<?>/*P*/ From) {
    assert isa_ConstantArrayExpansion(From);
    return llvm.cast(ConstantArrayExpansion.class, From.$deref());
  }

  public static ConstantArrayExpansion cast_or_null_ConstantArrayExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantArrayExpansion(From);
  }

  public static ConstantArrayExpansion dyn_cast_ConstantArrayExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static ConstantArrayExpansion dyn_cast_or_null_ConstantArrayExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static boolean isa_ConstantArrayExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantArrayExpansion.class, From.$star());
  }

  public static ConstantArrayExpansion cast_ConstantArrayExpansion(type$ptr<?>/*P*/ From) {
    assert isa_ConstantArrayExpansion(From);
    return llvm.cast(ConstantArrayExpansion.class, From.$star());
  }

  public static ConstantArrayExpansion cast_or_null_ConstantArrayExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantArrayExpansion(From);
  }

  public static ConstantArrayExpansion dyn_cast_ConstantArrayExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static ConstantArrayExpansion dyn_cast_or_null_ConstantArrayExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static boolean isa_ConstantArrayExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return llvm.isa(ConstantArrayExpansion.class, From);
  }

  public static ConstantArrayExpansion cast_ConstantArrayExpansion(TypeExpansion/*P*/ From) {
    assert isa_ConstantArrayExpansion(From);
    return llvm.cast(ConstantArrayExpansion.class, From);
  }

  public static ConstantArrayExpansion cast_or_null_ConstantArrayExpansion(TypeExpansion/*P*/ From) {
    return (From == null) ? null : cast_ConstantArrayExpansion(From);
  }

  public static ConstantArrayExpansion dyn_cast_ConstantArrayExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static ConstantArrayExpansion dyn_cast_or_null_ConstantArrayExpansion(TypeExpansion/*P*/ From) {
    return (From != null) && isa_ConstantArrayExpansion(From) ? cast_ConstantArrayExpansion(From) : null;
  }

  public static boolean isa_NoExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoExpansion.class, From.$star());
  }

  public static NoExpansion cast_NoExpansion(type$ptr<?>/*P*/ From) {
    assert isa_NoExpansion(From);
    return llvm.cast(NoExpansion.class, From.$star());
  }

  public static NoExpansion cast_or_null_NoExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoExpansion(From);
  }

  public static NoExpansion dyn_cast_NoExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static NoExpansion dyn_cast_or_null_NoExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static boolean isa_NoExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return llvm.isa(NoExpansion.class, From);
  }

  public static NoExpansion cast_NoExpansion(TypeExpansion/*P*/ From) {
    assert isa_NoExpansion(From);
    return llvm.cast(NoExpansion.class, From);
  }

  public static NoExpansion cast_or_null_NoExpansion(TypeExpansion/*P*/ From) {
    return (From == null) ? null : cast_NoExpansion(From);
  }

  public static NoExpansion dyn_cast_NoExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static NoExpansion dyn_cast_or_null_NoExpansion(TypeExpansion/*P*/ From) {
    return (From != null) && isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static boolean isa_NoExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoExpansion.class, From.$deref());
  }

  public static NoExpansion cast_NoExpansion(type$ref<?>/*P*/ From) {
    assert isa_NoExpansion(From);
    return llvm.cast(NoExpansion.class, From.$deref());
  }

  public static NoExpansion cast_or_null_NoExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoExpansion(From);
  }

  public static NoExpansion dyn_cast_NoExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static NoExpansion dyn_cast_or_null_NoExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoExpansion(From) ? cast_NoExpansion(From) : null;
  }

  public static boolean isa_RecordExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return llvm.isa(RecordExpansion.class, From);
  }

  public static RecordExpansion cast_RecordExpansion(TypeExpansion/*P*/ From) {
    assert isa_RecordExpansion(From);
    return llvm.cast(RecordExpansion.class, From);
  }

  public static RecordExpansion cast_or_null_RecordExpansion(TypeExpansion/*P*/ From) {
    return (From == null) ? null : cast_RecordExpansion(From);
  }

  public static RecordExpansion dyn_cast_RecordExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static RecordExpansion dyn_cast_or_null_RecordExpansion(TypeExpansion/*P*/ From) {
    return (From != null) && isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static boolean isa_RecordExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RecordExpansion.class, From.$deref());
  }

  public static RecordExpansion cast_RecordExpansion(type$ref<?>/*P*/ From) {
    assert isa_RecordExpansion(From);
    return llvm.cast(RecordExpansion.class, From.$deref());
  }

  public static RecordExpansion cast_or_null_RecordExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RecordExpansion(From);
  }

  public static RecordExpansion dyn_cast_RecordExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static RecordExpansion dyn_cast_or_null_RecordExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static boolean isa_RecordExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RecordExpansion.class, From.$star());
  }

  public static RecordExpansion cast_RecordExpansion(type$ptr<?>/*P*/ From) {
    assert isa_RecordExpansion(From);
    return llvm.cast(RecordExpansion.class, From.$star());
  }

  public static RecordExpansion cast_or_null_RecordExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RecordExpansion(From);
  }

  public static RecordExpansion dyn_cast_RecordExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static RecordExpansion dyn_cast_or_null_RecordExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RecordExpansion(From) ? cast_RecordExpansion(From) : null;
  }

  public static boolean isa_TypeExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeExpansion.class, From.$star());
  }

  public static TypeExpansion cast_TypeExpansion(type$ptr<?>/*P*/ From) {
    assert isa_TypeExpansion(From);
    return llvm.cast(TypeExpansion.class, From.$star());
  }

  public static TypeExpansion cast_or_null_TypeExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeExpansion(From);
  }

  public static TypeExpansion dyn_cast_TypeExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static TypeExpansion dyn_cast_or_null_TypeExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static boolean isa_TypeExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return llvm.isa(TypeExpansion.class, From);
  }

  public static TypeExpansion cast_TypeExpansion(TypeExpansion/*P*/ From) {
    assert isa_TypeExpansion(From);
    return llvm.cast(TypeExpansion.class, From);
  }

  public static TypeExpansion cast_or_null_TypeExpansion(TypeExpansion/*P*/ From) {
    return (From == null) ? null : cast_TypeExpansion(From);
  }

  public static TypeExpansion dyn_cast_TypeExpansion(TypeExpansion/*P*/ From) {
    assert From != null;
    return isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static TypeExpansion dyn_cast_or_null_TypeExpansion(TypeExpansion/*P*/ From) {
    return (From != null) && isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static boolean isa_TypeExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeExpansion.class, From.$deref());
  }

  public static TypeExpansion cast_TypeExpansion(type$ref<?>/*P*/ From) {
    assert isa_TypeExpansion(From);
    return llvm.cast(TypeExpansion.class, From.$deref());
  }

  public static TypeExpansion cast_or_null_TypeExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeExpansion(From);
  }

  public static TypeExpansion dyn_cast_TypeExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static TypeExpansion dyn_cast_or_null_TypeExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeExpansion(From) ? cast_TypeExpansion(From) : null;
  }

  public static boolean isa_AArch64ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AArch64ABIInfo.class, From.$star());
  }

  public static AArch64ABIInfo cast_AArch64ABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_AArch64ABIInfo(From);
    return llvm.cast(AArch64ABIInfo.class, From.$star());
  }

  public static AArch64ABIInfo cast_or_null_AArch64ABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AArch64ABIInfo(From);
  }

  public static AArch64ABIInfo dyn_cast_AArch64ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static AArch64ABIInfo dyn_cast_or_null_AArch64ABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static boolean isa_AArch64ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AArch64ABIInfo.class, From.$deref());
  }

  public static AArch64ABIInfo cast_AArch64ABIInfo(type$ref<?>/*P*/ From) {
    assert isa_AArch64ABIInfo(From);
    return llvm.cast(AArch64ABIInfo.class, From.$deref());
  }

  public static AArch64ABIInfo cast_or_null_AArch64ABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AArch64ABIInfo(From);
  }

  public static AArch64ABIInfo dyn_cast_AArch64ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static AArch64ABIInfo dyn_cast_or_null_AArch64ABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static boolean isa_AArch64ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(AArch64ABIInfo.class, From);
  }

  public static AArch64ABIInfo cast_AArch64ABIInfo(ABIInfo/*P*/ From) {
    assert isa_AArch64ABIInfo(From);
    return llvm.cast(AArch64ABIInfo.class, From);
  }

  public static AArch64ABIInfo cast_or_null_AArch64ABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_AArch64ABIInfo(From);
  }

  public static AArch64ABIInfo dyn_cast_AArch64ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static AArch64ABIInfo dyn_cast_or_null_AArch64ABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_AArch64ABIInfo(From) ? cast_AArch64ABIInfo(From) : null;
  }

  public static boolean isa_ARMABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ARMABIInfo.class, From.$deref());
  }

  public static ARMABIInfo cast_ARMABIInfo(type$ref<?>/*P*/ From) {
    assert isa_ARMABIInfo(From);
    return llvm.cast(ARMABIInfo.class, From.$deref());
  }

  public static ARMABIInfo cast_or_null_ARMABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ARMABIInfo(From);
  }

  public static ARMABIInfo dyn_cast_ARMABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static ARMABIInfo dyn_cast_or_null_ARMABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static boolean isa_ARMABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ARMABIInfo.class, From.$star());
  }

  public static ARMABIInfo cast_ARMABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_ARMABIInfo(From);
    return llvm.cast(ARMABIInfo.class, From.$star());
  }

  public static ARMABIInfo cast_or_null_ARMABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ARMABIInfo(From);
  }

  public static ARMABIInfo dyn_cast_ARMABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static ARMABIInfo dyn_cast_or_null_ARMABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static boolean isa_ARMABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(ARMABIInfo.class, From);
  }

  public static ARMABIInfo cast_ARMABIInfo(ABIInfo/*P*/ From) {
    assert isa_ARMABIInfo(From);
    return llvm.cast(ARMABIInfo.class, From);
  }

  public static ARMABIInfo cast_or_null_ARMABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_ARMABIInfo(From);
  }

  public static ARMABIInfo dyn_cast_ARMABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static ARMABIInfo dyn_cast_or_null_ARMABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_ARMABIInfo(From) ? cast_ARMABIInfo(From) : null;
  }

  public static boolean isa_SystemZABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(SystemZABIInfo.class, From);
  }

  public static SystemZABIInfo cast_SystemZABIInfo(ABIInfo/*P*/ From) {
    assert isa_SystemZABIInfo(From);
    return llvm.cast(SystemZABIInfo.class, From);
  }

  public static SystemZABIInfo cast_or_null_SystemZABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_SystemZABIInfo(From);
  }

  public static SystemZABIInfo dyn_cast_SystemZABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static SystemZABIInfo dyn_cast_or_null_SystemZABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static boolean isa_SystemZABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SystemZABIInfo.class, From.$deref());
  }

  public static SystemZABIInfo cast_SystemZABIInfo(type$ref<?>/*P*/ From) {
    assert isa_SystemZABIInfo(From);
    return llvm.cast(SystemZABIInfo.class, From.$deref());
  }

  public static SystemZABIInfo cast_or_null_SystemZABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SystemZABIInfo(From);
  }

  public static SystemZABIInfo dyn_cast_SystemZABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static SystemZABIInfo dyn_cast_or_null_SystemZABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static boolean isa_SystemZABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SystemZABIInfo.class, From.$star());
  }

  public static SystemZABIInfo cast_SystemZABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_SystemZABIInfo(From);
    return llvm.cast(SystemZABIInfo.class, From.$star());
  }

  public static SystemZABIInfo cast_or_null_SystemZABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SystemZABIInfo(From);
  }

  public static SystemZABIInfo dyn_cast_SystemZABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static SystemZABIInfo dyn_cast_or_null_SystemZABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SystemZABIInfo(From) ? cast_SystemZABIInfo(From) : null;
  }

  public static boolean isa_X86_32ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(X86_32ABIInfo.class, From.$star());
  }

  public static X86_32ABIInfo cast_X86_32ABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_X86_32ABIInfo(From);
    return llvm.cast(X86_32ABIInfo.class, From.$star());
  }

  public static X86_32ABIInfo cast_or_null_X86_32ABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_X86_32ABIInfo(From);
  }

  public static X86_32ABIInfo dyn_cast_X86_32ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static X86_32ABIInfo dyn_cast_or_null_X86_32ABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static boolean isa_X86_32ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(X86_32ABIInfo.class, From);
  }

  public static X86_32ABIInfo cast_X86_32ABIInfo(ABIInfo/*P*/ From) {
    assert isa_X86_32ABIInfo(From);
    return llvm.cast(X86_32ABIInfo.class, From);
  }

  public static X86_32ABIInfo cast_or_null_X86_32ABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_X86_32ABIInfo(From);
  }

  public static X86_32ABIInfo dyn_cast_X86_32ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static X86_32ABIInfo dyn_cast_or_null_X86_32ABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static boolean isa_X86_32ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(X86_32ABIInfo.class, From.$deref());
  }

  public static X86_32ABIInfo cast_X86_32ABIInfo(type$ref<?>/*P*/ From) {
    assert isa_X86_32ABIInfo(From);
    return llvm.cast(X86_32ABIInfo.class, From.$deref());
  }

  public static X86_32ABIInfo cast_or_null_X86_32ABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_X86_32ABIInfo(From);
  }

  public static X86_32ABIInfo dyn_cast_X86_32ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static X86_32ABIInfo dyn_cast_or_null_X86_32ABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_X86_32ABIInfo(From) ? cast_X86_32ABIInfo(From) : null;
  }

  public static boolean isa_X86_64ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(X86_64ABIInfo.class, From);
  }

  public static X86_64ABIInfo cast_X86_64ABIInfo(ABIInfo/*P*/ From) {
    assert isa_X86_64ABIInfo(From);
    return llvm.cast(X86_64ABIInfo.class, From);
  }

  public static X86_64ABIInfo cast_or_null_X86_64ABIInfo(ABIInfo/*P*/ From) {
    return (From == null) ? null : cast_X86_64ABIInfo(From);
  }

  public static X86_64ABIInfo dyn_cast_X86_64ABIInfo(ABIInfo/*P*/ From) {
    assert From != null;
    return isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }

  public static X86_64ABIInfo dyn_cast_or_null_X86_64ABIInfo(ABIInfo/*P*/ From) {
    return (From != null) && isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }

  public static boolean isa_X86_64ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(X86_64ABIInfo.class, From.$deref());
  }

  public static X86_64ABIInfo cast_X86_64ABIInfo(type$ref<?>/*P*/ From) {
    assert isa_X86_64ABIInfo(From);
    return llvm.cast(X86_64ABIInfo.class, From.$deref());
  }

  public static X86_64ABIInfo cast_or_null_X86_64ABIInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_X86_64ABIInfo(From);
  }

  public static X86_64ABIInfo dyn_cast_X86_64ABIInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }

  public static X86_64ABIInfo dyn_cast_or_null_X86_64ABIInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }

  public static boolean isa_X86_64ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(X86_64ABIInfo.class, From.$star());
  }

  public static X86_64ABIInfo cast_X86_64ABIInfo(type$ptr<?>/*P*/ From) {
    assert isa_X86_64ABIInfo(From);
    return llvm.cast(X86_64ABIInfo.class, From.$star());
  }

  public static X86_64ABIInfo cast_or_null_X86_64ABIInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_X86_64ABIInfo(From);
  }

  public static X86_64ABIInfo dyn_cast_X86_64ABIInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }

  public static X86_64ABIInfo dyn_cast_or_null_X86_64ABIInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_X86_64ABIInfo(From) ? cast_X86_64ABIInfo(From) : null;
  }
  
  public static CGOpenMPInlinedRegionInfo cast_CGOpenMPInlinedRegionInfo(CodeGenFunction_NestedClasses.CGCapturedStmtInfo From) {
    assert isa_CGOpenMPInlinedRegionInfo(From);
    return llvm.cast(CGOpenMPInlinedRegionInfo.class, From);
  }

  private static boolean isa_CGOpenMPInlinedRegionInfo(CodeGenFunction_NestedClasses.CGCapturedStmtInfo From) {
    return From instanceof CGOpenMPInlinedRegionInfo;
  }

  public static CGOpenMPRegionInfo dyn_cast_or_null_CGOpenMPRegionInfo(CodeGenFunction.CGCapturedStmtInfo/*P*/ From) {
    return (From != null) && isa_CGOpenMPRegionInfo(From) ? cast_CGOpenMPRegionInfo(From) : null;
  }

  public static CGOpenMPRegionInfo cast_CGOpenMPRegionInfo(Object From) {
    assert isa_CGOpenMPRegionInfo(From);
    return llvm.cast(CGOpenMPRegionInfo.class, From);
  }

  private static boolean isa_CGOpenMPRegionInfo(Object From) {
    return From instanceof CGOpenMPRegionInfo;
  }

  public static ConstantAddress dyn_cast_or_null_CGOpenMPRegionInfo(Object From) {
    return (From != null) && isa_ConstantAddress(From) ? cast_ConstantAddress(From) : null;
  }

  public static ConstantAddress cast_ConstantAddress(Object From) {
    assert isa_ConstantAddress(From);
    return llvm.cast(ConstantAddress.class, From);
  }

  private static boolean isa_ConstantAddress(Object From) {
    return From instanceof ConstantAddress;
  }  
}
