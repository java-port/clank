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

public class AstStorageRTTI {
  /*package*/AstStorageRTTI() {}

  public static boolean isa_APFloatStorage(Stmt/*P*/ From) {
    assert From != null;
    return llvm.isa(APFloatStorage.class, From);
  }

  public static APFloatStorage cast_APFloatStorage(Stmt/*P*/ From) {
    assert isa_APFloatStorage(From);
    return llvm.cast(APFloatStorage.class, From);
  }

  public static APFloatStorage cast_or_null_APFloatStorage(Stmt/*P*/ From) {
    return (From == null) ? null : cast_APFloatStorage(From);
  }

  public static APFloatStorage dyn_cast_APFloatStorage(Stmt/*P*/ From) {
    assert From != null;
    return isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static APFloatStorage dyn_cast_or_null_APFloatStorage(Stmt/*P*/ From) {
    return (From != null) && isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static boolean isa_APFloatStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(APFloatStorage.class, From.$star());
  }

  public static APFloatStorage cast_APFloatStorage(type$ptr<?>/*P*/ From) {
    assert isa_APFloatStorage(From);
    return llvm.cast(APFloatStorage.class, From.$star());
  }

  public static APFloatStorage cast_or_null_APFloatStorage(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_APFloatStorage(From);
  }

  public static APFloatStorage dyn_cast_APFloatStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static APFloatStorage dyn_cast_or_null_APFloatStorage(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static boolean isa_APFloatStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(APFloatStorage.class, From.$deref());
  }

  public static APFloatStorage cast_APFloatStorage(type$ref<?>/*P*/ From) {
    assert isa_APFloatStorage(From);
    return llvm.cast(APFloatStorage.class, From.$deref());
  }

  public static APFloatStorage cast_or_null_APFloatStorage(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_APFloatStorage(From);
  }

  public static APFloatStorage dyn_cast_APFloatStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static APFloatStorage dyn_cast_or_null_APFloatStorage(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_APFloatStorage(From) ? cast_APFloatStorage(From) : null;
  }

  public static boolean isa_APIntStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(APIntStorage.class, From.$deref());
  }

  public static APIntStorage cast_APIntStorage(type$ref<?>/*P*/ From) {
    assert isa_APIntStorage(From);
    return llvm.cast(APIntStorage.class, From.$deref());
  }

  public static APIntStorage cast_or_null_APIntStorage(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_APIntStorage(From);
  }

  public static APIntStorage dyn_cast_APIntStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static APIntStorage dyn_cast_or_null_APIntStorage(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static boolean isa_APIntStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(APIntStorage.class, From.$star());
  }

  public static APIntStorage cast_APIntStorage(type$ptr<?>/*P*/ From) {
    assert isa_APIntStorage(From);
    return llvm.cast(APIntStorage.class, From.$star());
  }

  public static APIntStorage cast_or_null_APIntStorage(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_APIntStorage(From);
  }

  public static APIntStorage dyn_cast_APIntStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static APIntStorage dyn_cast_or_null_APIntStorage(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static boolean isa_APIntStorage(Stmt/*P*/ From) {
    assert From != null;
    return llvm.isa(APIntStorage.class, From);
  }

  public static APIntStorage cast_APIntStorage(Stmt/*P*/ From) {
    assert isa_APIntStorage(From);
    return llvm.cast(APIntStorage.class, From);
  }

  public static APIntStorage cast_or_null_APIntStorage(Stmt/*P*/ From) {
    return (From == null) ? null : cast_APIntStorage(From);
  }

  public static APIntStorage dyn_cast_APIntStorage(Stmt/*P*/ From) {
    assert From != null;
    return isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static APIntStorage dyn_cast_or_null_APIntStorage(Stmt/*P*/ From) {
    return (From != null) && isa_APIntStorage(From) ? cast_APIntStorage(From) : null;
  }

  public static boolean isa_APNumericStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(APNumericStorage.class, From.$deref());
  }

  public static APNumericStorage cast_APNumericStorage(type$ref<?>/*P*/ From) {
    assert isa_APNumericStorage(From);
    return llvm.cast(APNumericStorage.class, From.$deref());
  }

  public static APNumericStorage cast_or_null_APNumericStorage(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_APNumericStorage(From);
  }

  public static APNumericStorage dyn_cast_APNumericStorage(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }

  public static APNumericStorage dyn_cast_or_null_APNumericStorage(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }

  public static boolean isa_APNumericStorage(Stmt/*P*/ From) {
    assert From != null;
    return llvm.isa(APNumericStorage.class, From);
  }

  public static APNumericStorage cast_APNumericStorage(Stmt/*P*/ From) {
    assert isa_APNumericStorage(From);
    return llvm.cast(APNumericStorage.class, From);
  }

  public static APNumericStorage cast_or_null_APNumericStorage(Stmt/*P*/ From) {
    return (From == null) ? null : cast_APNumericStorage(From);
  }

  public static APNumericStorage dyn_cast_APNumericStorage(Stmt/*P*/ From) {
    assert From != null;
    return isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }

  public static APNumericStorage dyn_cast_or_null_APNumericStorage(Stmt/*P*/ From) {
    return (From != null) && isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }

  public static boolean isa_APNumericStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(APNumericStorage.class, From.$star());
  }

  public static APNumericStorage cast_APNumericStorage(type$ptr<?>/*P*/ From) {
    assert isa_APNumericStorage(From);
    return llvm.cast(APNumericStorage.class, From.$star());
  }

  public static APNumericStorage cast_or_null_APNumericStorage(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_APNumericStorage(From);
  }

  public static APNumericStorage dyn_cast_APNumericStorage(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }

  public static APNumericStorage dyn_cast_or_null_APNumericStorage(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_APNumericStorage(From) ? cast_APNumericStorage(From) : null;
  }
}
