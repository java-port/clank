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
package org.llvm.analysis.java;

import org.llvm.analysis.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class AnalysisRTTI {
  /*package*/AnalysisRTTI() {}

  public static boolean isa_SCEV(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEV.class, From.$star());
  }

  public static SCEV cast_SCEV(type$ptr<?>/*P*/ From) {
    assert isa_SCEV(From);
    return llvm.cast(SCEV.class, From.$star());
  }

  public static SCEV cast_or_null_SCEV(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEV(From);
  }

  public static SCEV dyn_cast_SCEV(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static SCEV dyn_cast_or_null_SCEV(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static boolean isa_SCEV(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEV.class, From.$deref());
  }

  public static SCEV cast_SCEV(type$ref<?>/*P*/ From) {
    assert isa_SCEV(From);
    return llvm.cast(SCEV.class, From.$deref());
  }

  public static SCEV cast_or_null_SCEV(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEV(From);
  }

  public static SCEV dyn_cast_SCEV(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static SCEV dyn_cast_or_null_SCEV(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static boolean isa_SCEV(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEV.class, From);
  }

  public static SCEV cast_SCEV(SCEV/*P*/ From) {
    assert isa_SCEV(From);
    return llvm.cast(SCEV.class, From);
  }

  public static SCEV cast_or_null_SCEV(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEV(From);
  }

  public static SCEV dyn_cast_SCEV(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static SCEV dyn_cast_or_null_SCEV(SCEV/*P*/ From) {
    return (From != null) && isa_SCEV(From) ? cast_SCEV(From) : null;
  }

  public static boolean isa_SCEVAddExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVAddExpr.class, From);
  }

  public static SCEVAddExpr cast_SCEVAddExpr(SCEV/*P*/ From) {
    assert isa_SCEVAddExpr(From);
    return llvm.cast(SCEVAddExpr.class, From);
  }

  public static SCEVAddExpr cast_or_null_SCEVAddExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVAddExpr(From);
  }

  public static SCEVAddExpr dyn_cast_SCEVAddExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static SCEVAddExpr dyn_cast_or_null_SCEVAddExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static boolean isa_SCEVAddExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVAddExpr.class, From.$deref());
  }

  public static SCEVAddExpr cast_SCEVAddExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVAddExpr(From);
    return llvm.cast(SCEVAddExpr.class, From.$deref());
  }

  public static SCEVAddExpr cast_or_null_SCEVAddExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVAddExpr(From);
  }

  public static SCEVAddExpr dyn_cast_SCEVAddExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static SCEVAddExpr dyn_cast_or_null_SCEVAddExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static boolean isa_SCEVAddExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVAddExpr.class, From.$star());
  }

  public static SCEVAddExpr cast_SCEVAddExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVAddExpr(From);
    return llvm.cast(SCEVAddExpr.class, From.$star());
  }

  public static SCEVAddExpr cast_or_null_SCEVAddExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVAddExpr(From);
  }

  public static SCEVAddExpr dyn_cast_SCEVAddExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static SCEVAddExpr dyn_cast_or_null_SCEVAddExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVAddExpr(From) ? cast_SCEVAddExpr(From) : null;
  }

  public static boolean isa_SCEVAddRecExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVAddRecExpr.class, From);
  }

  public static SCEVAddRecExpr cast_SCEVAddRecExpr(SCEV/*P*/ From) {
    assert isa_SCEVAddRecExpr(From);
    return llvm.cast(SCEVAddRecExpr.class, From);
  }

  public static SCEVAddRecExpr cast_or_null_SCEVAddRecExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVAddRecExpr(From);
  }

  public static SCEVAddRecExpr dyn_cast_SCEVAddRecExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static SCEVAddRecExpr dyn_cast_or_null_SCEVAddRecExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static boolean isa_SCEVAddRecExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVAddRecExpr.class, From.$deref());
  }

  public static SCEVAddRecExpr cast_SCEVAddRecExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVAddRecExpr(From);
    return llvm.cast(SCEVAddRecExpr.class, From.$deref());
  }

  public static SCEVAddRecExpr cast_or_null_SCEVAddRecExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVAddRecExpr(From);
  }

  public static SCEVAddRecExpr dyn_cast_SCEVAddRecExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static SCEVAddRecExpr dyn_cast_or_null_SCEVAddRecExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static boolean isa_SCEVAddRecExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVAddRecExpr.class, From.$star());
  }

  public static SCEVAddRecExpr cast_SCEVAddRecExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVAddRecExpr(From);
    return llvm.cast(SCEVAddRecExpr.class, From.$star());
  }

  public static SCEVAddRecExpr cast_or_null_SCEVAddRecExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVAddRecExpr(From);
  }

  public static SCEVAddRecExpr dyn_cast_SCEVAddRecExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static SCEVAddRecExpr dyn_cast_or_null_SCEVAddRecExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVAddRecExpr(From) ? cast_SCEVAddRecExpr(From) : null;
  }

  public static boolean isa_SCEVCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVCastExpr.class, From.$star());
  }

  public static SCEVCastExpr cast_SCEVCastExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVCastExpr(From);
    return llvm.cast(SCEVCastExpr.class, From.$star());
  }

  public static SCEVCastExpr cast_or_null_SCEVCastExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVCastExpr(From);
  }

  public static SCEVCastExpr dyn_cast_SCEVCastExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static SCEVCastExpr dyn_cast_or_null_SCEVCastExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static boolean isa_SCEVCastExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVCastExpr.class, From);
  }

  public static SCEVCastExpr cast_SCEVCastExpr(SCEV/*P*/ From) {
    assert isa_SCEVCastExpr(From);
    return llvm.cast(SCEVCastExpr.class, From);
  }

  public static SCEVCastExpr cast_or_null_SCEVCastExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVCastExpr(From);
  }

  public static SCEVCastExpr dyn_cast_SCEVCastExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static SCEVCastExpr dyn_cast_or_null_SCEVCastExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static boolean isa_SCEVCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVCastExpr.class, From.$deref());
  }

  public static SCEVCastExpr cast_SCEVCastExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVCastExpr(From);
    return llvm.cast(SCEVCastExpr.class, From.$deref());
  }

  public static SCEVCastExpr cast_or_null_SCEVCastExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVCastExpr(From);
  }

  public static SCEVCastExpr dyn_cast_SCEVCastExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static SCEVCastExpr dyn_cast_or_null_SCEVCastExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVCastExpr(From) ? cast_SCEVCastExpr(From) : null;
  }

  public static boolean isa_SCEVCommutativeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVCommutativeExpr.class, From.$star());
  }

  public static SCEVCommutativeExpr cast_SCEVCommutativeExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVCommutativeExpr(From);
    return llvm.cast(SCEVCommutativeExpr.class, From.$star());
  }

  public static SCEVCommutativeExpr cast_or_null_SCEVCommutativeExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVCommutativeExpr(From);
  }

  public static SCEVCommutativeExpr dyn_cast_SCEVCommutativeExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static SCEVCommutativeExpr dyn_cast_or_null_SCEVCommutativeExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static boolean isa_SCEVCommutativeExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVCommutativeExpr.class, From);
  }

  public static SCEVCommutativeExpr cast_SCEVCommutativeExpr(SCEV/*P*/ From) {
    assert isa_SCEVCommutativeExpr(From);
    return llvm.cast(SCEVCommutativeExpr.class, From);
  }

  public static SCEVCommutativeExpr cast_or_null_SCEVCommutativeExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVCommutativeExpr(From);
  }

  public static SCEVCommutativeExpr dyn_cast_SCEVCommutativeExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static SCEVCommutativeExpr dyn_cast_or_null_SCEVCommutativeExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static boolean isa_SCEVCommutativeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVCommutativeExpr.class, From.$deref());
  }

  public static SCEVCommutativeExpr cast_SCEVCommutativeExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVCommutativeExpr(From);
    return llvm.cast(SCEVCommutativeExpr.class, From.$deref());
  }

  public static SCEVCommutativeExpr cast_or_null_SCEVCommutativeExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVCommutativeExpr(From);
  }

  public static SCEVCommutativeExpr dyn_cast_SCEVCommutativeExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static SCEVCommutativeExpr dyn_cast_or_null_SCEVCommutativeExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVCommutativeExpr(From) ? cast_SCEVCommutativeExpr(From) : null;
  }

  public static boolean isa_SCEVConstant(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVConstant.class, From.$star());
  }

  public static SCEVConstant cast_SCEVConstant(type$ptr<?>/*P*/ From) {
    assert isa_SCEVConstant(From);
    return llvm.cast(SCEVConstant.class, From.$star());
  }

  public static SCEVConstant cast_or_null_SCEVConstant(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVConstant(From);
  }

  public static SCEVConstant dyn_cast_SCEVConstant(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static SCEVConstant dyn_cast_or_null_SCEVConstant(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static boolean isa_SCEVConstant(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVConstant.class, From);
  }

  public static SCEVConstant cast_SCEVConstant(SCEV/*P*/ From) {
    assert isa_SCEVConstant(From);
    return llvm.cast(SCEVConstant.class, From);
  }

  public static SCEVConstant cast_or_null_SCEVConstant(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVConstant(From);
  }

  public static SCEVConstant dyn_cast_SCEVConstant(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static SCEVConstant dyn_cast_or_null_SCEVConstant(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static boolean isa_SCEVConstant(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVConstant.class, From.$deref());
  }

  public static SCEVConstant cast_SCEVConstant(type$ref<?>/*P*/ From) {
    assert isa_SCEVConstant(From);
    return llvm.cast(SCEVConstant.class, From.$deref());
  }

  public static SCEVConstant cast_or_null_SCEVConstant(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVConstant(From);
  }

  public static SCEVConstant dyn_cast_SCEVConstant(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static SCEVConstant dyn_cast_or_null_SCEVConstant(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVConstant(From) ? cast_SCEVConstant(From) : null;
  }

  public static boolean isa_SCEVCouldNotCompute(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVCouldNotCompute.class, From.$star());
  }

  public static SCEVCouldNotCompute cast_SCEVCouldNotCompute(type$ptr<?>/*P*/ From) {
    assert isa_SCEVCouldNotCompute(From);
    return llvm.cast(SCEVCouldNotCompute.class, From.$star());
  }

  public static SCEVCouldNotCompute cast_or_null_SCEVCouldNotCompute(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVCouldNotCompute(From);
  }

  public static SCEVCouldNotCompute dyn_cast_SCEVCouldNotCompute(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static SCEVCouldNotCompute dyn_cast_or_null_SCEVCouldNotCompute(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static boolean isa_SCEVCouldNotCompute(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVCouldNotCompute.class, From);
  }

  public static SCEVCouldNotCompute cast_SCEVCouldNotCompute(SCEV/*P*/ From) {
    assert isa_SCEVCouldNotCompute(From);
    return llvm.cast(SCEVCouldNotCompute.class, From);
  }

  public static SCEVCouldNotCompute cast_or_null_SCEVCouldNotCompute(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVCouldNotCompute(From);
  }

  public static SCEVCouldNotCompute dyn_cast_SCEVCouldNotCompute(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static SCEVCouldNotCompute dyn_cast_or_null_SCEVCouldNotCompute(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static boolean isa_SCEVCouldNotCompute(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVCouldNotCompute.class, From.$deref());
  }

  public static SCEVCouldNotCompute cast_SCEVCouldNotCompute(type$ref<?>/*P*/ From) {
    assert isa_SCEVCouldNotCompute(From);
    return llvm.cast(SCEVCouldNotCompute.class, From.$deref());
  }

  public static SCEVCouldNotCompute cast_or_null_SCEVCouldNotCompute(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVCouldNotCompute(From);
  }

  public static SCEVCouldNotCompute dyn_cast_SCEVCouldNotCompute(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static SCEVCouldNotCompute dyn_cast_or_null_SCEVCouldNotCompute(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVCouldNotCompute(From) ? cast_SCEVCouldNotCompute(From) : null;
  }

  public static boolean isa_SCEVEqualPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVEqualPredicate.class, From);
  }

  public static SCEVEqualPredicate cast_SCEVEqualPredicate(SCEVPredicate/*P*/ From) {
    assert isa_SCEVEqualPredicate(From);
    return llvm.cast(SCEVEqualPredicate.class, From);
  }

  public static SCEVEqualPredicate cast_or_null_SCEVEqualPredicate(SCEVPredicate/*P*/ From) {
    return (From == null) ? null : cast_SCEVEqualPredicate(From);
  }

  public static SCEVEqualPredicate dyn_cast_SCEVEqualPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static SCEVEqualPredicate dyn_cast_or_null_SCEVEqualPredicate(SCEVPredicate/*P*/ From) {
    return (From != null) && isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static boolean isa_SCEVEqualPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVEqualPredicate.class, From.$star());
  }

  public static SCEVEqualPredicate cast_SCEVEqualPredicate(type$ptr<?>/*P*/ From) {
    assert isa_SCEVEqualPredicate(From);
    return llvm.cast(SCEVEqualPredicate.class, From.$star());
  }

  public static SCEVEqualPredicate cast_or_null_SCEVEqualPredicate(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVEqualPredicate(From);
  }

  public static SCEVEqualPredicate dyn_cast_SCEVEqualPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static SCEVEqualPredicate dyn_cast_or_null_SCEVEqualPredicate(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static boolean isa_SCEVEqualPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVEqualPredicate.class, From.$deref());
  }

  public static SCEVEqualPredicate cast_SCEVEqualPredicate(type$ref<?>/*P*/ From) {
    assert isa_SCEVEqualPredicate(From);
    return llvm.cast(SCEVEqualPredicate.class, From.$deref());
  }

  public static SCEVEqualPredicate cast_or_null_SCEVEqualPredicate(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVEqualPredicate(From);
  }

  public static SCEVEqualPredicate dyn_cast_SCEVEqualPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static SCEVEqualPredicate dyn_cast_or_null_SCEVEqualPredicate(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVEqualPredicate(From) ? cast_SCEVEqualPredicate(From) : null;
  }

  public static boolean isa_SCEVMulExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVMulExpr.class, From.$star());
  }

  public static SCEVMulExpr cast_SCEVMulExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVMulExpr(From);
    return llvm.cast(SCEVMulExpr.class, From.$star());
  }

  public static SCEVMulExpr cast_or_null_SCEVMulExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVMulExpr(From);
  }

  public static SCEVMulExpr dyn_cast_SCEVMulExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static SCEVMulExpr dyn_cast_or_null_SCEVMulExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static boolean isa_SCEVMulExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVMulExpr.class, From);
  }

  public static SCEVMulExpr cast_SCEVMulExpr(SCEV/*P*/ From) {
    assert isa_SCEVMulExpr(From);
    return llvm.cast(SCEVMulExpr.class, From);
  }

  public static SCEVMulExpr cast_or_null_SCEVMulExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVMulExpr(From);
  }

  public static SCEVMulExpr dyn_cast_SCEVMulExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static SCEVMulExpr dyn_cast_or_null_SCEVMulExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static boolean isa_SCEVMulExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVMulExpr.class, From.$deref());
  }

  public static SCEVMulExpr cast_SCEVMulExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVMulExpr(From);
    return llvm.cast(SCEVMulExpr.class, From.$deref());
  }

  public static SCEVMulExpr cast_or_null_SCEVMulExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVMulExpr(From);
  }

  public static SCEVMulExpr dyn_cast_SCEVMulExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static SCEVMulExpr dyn_cast_or_null_SCEVMulExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVMulExpr(From) ? cast_SCEVMulExpr(From) : null;
  }

  public static boolean isa_SCEVNAryExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVNAryExpr.class, From);
  }

  public static SCEVNAryExpr cast_SCEVNAryExpr(SCEV/*P*/ From) {
    assert isa_SCEVNAryExpr(From);
    return llvm.cast(SCEVNAryExpr.class, From);
  }

  public static SCEVNAryExpr cast_or_null_SCEVNAryExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVNAryExpr(From);
  }

  public static SCEVNAryExpr dyn_cast_SCEVNAryExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static SCEVNAryExpr dyn_cast_or_null_SCEVNAryExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static boolean isa_SCEVNAryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVNAryExpr.class, From.$star());
  }

  public static SCEVNAryExpr cast_SCEVNAryExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVNAryExpr(From);
    return llvm.cast(SCEVNAryExpr.class, From.$star());
  }

  public static SCEVNAryExpr cast_or_null_SCEVNAryExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVNAryExpr(From);
  }

  public static SCEVNAryExpr dyn_cast_SCEVNAryExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static SCEVNAryExpr dyn_cast_or_null_SCEVNAryExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static boolean isa_SCEVNAryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVNAryExpr.class, From.$deref());
  }

  public static SCEVNAryExpr cast_SCEVNAryExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVNAryExpr(From);
    return llvm.cast(SCEVNAryExpr.class, From.$deref());
  }

  public static SCEVNAryExpr cast_or_null_SCEVNAryExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVNAryExpr(From);
  }

  public static SCEVNAryExpr dyn_cast_SCEVNAryExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static SCEVNAryExpr dyn_cast_or_null_SCEVNAryExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVNAryExpr(From) ? cast_SCEVNAryExpr(From) : null;
  }

  public static boolean isa_SCEVPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVPredicate.class, From.$star());
  }

  public static SCEVPredicate cast_SCEVPredicate(type$ptr<?>/*P*/ From) {
    assert isa_SCEVPredicate(From);
    return llvm.cast(SCEVPredicate.class, From.$star());
  }

  public static SCEVPredicate cast_or_null_SCEVPredicate(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVPredicate(From);
  }

  public static SCEVPredicate dyn_cast_SCEVPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static SCEVPredicate dyn_cast_or_null_SCEVPredicate(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static boolean isa_SCEVPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVPredicate.class, From);
  }

  public static SCEVPredicate cast_SCEVPredicate(SCEVPredicate/*P*/ From) {
    assert isa_SCEVPredicate(From);
    return llvm.cast(SCEVPredicate.class, From);
  }

  public static SCEVPredicate cast_or_null_SCEVPredicate(SCEVPredicate/*P*/ From) {
    return (From == null) ? null : cast_SCEVPredicate(From);
  }

  public static SCEVPredicate dyn_cast_SCEVPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static SCEVPredicate dyn_cast_or_null_SCEVPredicate(SCEVPredicate/*P*/ From) {
    return (From != null) && isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static boolean isa_SCEVPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVPredicate.class, From.$deref());
  }

  public static SCEVPredicate cast_SCEVPredicate(type$ref<?>/*P*/ From) {
    assert isa_SCEVPredicate(From);
    return llvm.cast(SCEVPredicate.class, From.$deref());
  }

  public static SCEVPredicate cast_or_null_SCEVPredicate(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVPredicate(From);
  }

  public static SCEVPredicate dyn_cast_SCEVPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static SCEVPredicate dyn_cast_or_null_SCEVPredicate(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVPredicate(From) ? cast_SCEVPredicate(From) : null;
  }

  public static boolean isa_SCEVSMaxExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVSMaxExpr.class, From.$star());
  }

  public static SCEVSMaxExpr cast_SCEVSMaxExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVSMaxExpr(From);
    return llvm.cast(SCEVSMaxExpr.class, From.$star());
  }

  public static SCEVSMaxExpr cast_or_null_SCEVSMaxExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVSMaxExpr(From);
  }

  public static SCEVSMaxExpr dyn_cast_SCEVSMaxExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static SCEVSMaxExpr dyn_cast_or_null_SCEVSMaxExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static boolean isa_SCEVSMaxExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVSMaxExpr.class, From);
  }

  public static SCEVSMaxExpr cast_SCEVSMaxExpr(SCEV/*P*/ From) {
    assert isa_SCEVSMaxExpr(From);
    return llvm.cast(SCEVSMaxExpr.class, From);
  }

  public static SCEVSMaxExpr cast_or_null_SCEVSMaxExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVSMaxExpr(From);
  }

  public static SCEVSMaxExpr dyn_cast_SCEVSMaxExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static SCEVSMaxExpr dyn_cast_or_null_SCEVSMaxExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static boolean isa_SCEVSMaxExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVSMaxExpr.class, From.$deref());
  }

  public static SCEVSMaxExpr cast_SCEVSMaxExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVSMaxExpr(From);
    return llvm.cast(SCEVSMaxExpr.class, From.$deref());
  }

  public static SCEVSMaxExpr cast_or_null_SCEVSMaxExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVSMaxExpr(From);
  }

  public static SCEVSMaxExpr dyn_cast_SCEVSMaxExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static SCEVSMaxExpr dyn_cast_or_null_SCEVSMaxExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVSMaxExpr(From) ? cast_SCEVSMaxExpr(From) : null;
  }

  public static boolean isa_SCEVSignExtendExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVSignExtendExpr.class, From);
  }

  public static SCEVSignExtendExpr cast_SCEVSignExtendExpr(SCEV/*P*/ From) {
    assert isa_SCEVSignExtendExpr(From);
    return llvm.cast(SCEVSignExtendExpr.class, From);
  }

  public static SCEVSignExtendExpr cast_or_null_SCEVSignExtendExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVSignExtendExpr(From);
  }

  public static SCEVSignExtendExpr dyn_cast_SCEVSignExtendExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static SCEVSignExtendExpr dyn_cast_or_null_SCEVSignExtendExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static boolean isa_SCEVSignExtendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVSignExtendExpr.class, From.$deref());
  }

  public static SCEVSignExtendExpr cast_SCEVSignExtendExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVSignExtendExpr(From);
    return llvm.cast(SCEVSignExtendExpr.class, From.$deref());
  }

  public static SCEVSignExtendExpr cast_or_null_SCEVSignExtendExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVSignExtendExpr(From);
  }

  public static SCEVSignExtendExpr dyn_cast_SCEVSignExtendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static SCEVSignExtendExpr dyn_cast_or_null_SCEVSignExtendExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static boolean isa_SCEVSignExtendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVSignExtendExpr.class, From.$star());
  }

  public static SCEVSignExtendExpr cast_SCEVSignExtendExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVSignExtendExpr(From);
    return llvm.cast(SCEVSignExtendExpr.class, From.$star());
  }

  public static SCEVSignExtendExpr cast_or_null_SCEVSignExtendExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVSignExtendExpr(From);
  }

  public static SCEVSignExtendExpr dyn_cast_SCEVSignExtendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static SCEVSignExtendExpr dyn_cast_or_null_SCEVSignExtendExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVSignExtendExpr(From) ? cast_SCEVSignExtendExpr(From) : null;
  }

  public static boolean isa_SCEVTruncateExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVTruncateExpr.class, From.$star());
  }

  public static SCEVTruncateExpr cast_SCEVTruncateExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVTruncateExpr(From);
    return llvm.cast(SCEVTruncateExpr.class, From.$star());
  }

  public static SCEVTruncateExpr cast_or_null_SCEVTruncateExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVTruncateExpr(From);
  }

  public static SCEVTruncateExpr dyn_cast_SCEVTruncateExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static SCEVTruncateExpr dyn_cast_or_null_SCEVTruncateExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static boolean isa_SCEVTruncateExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVTruncateExpr.class, From.$deref());
  }

  public static SCEVTruncateExpr cast_SCEVTruncateExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVTruncateExpr(From);
    return llvm.cast(SCEVTruncateExpr.class, From.$deref());
  }

  public static SCEVTruncateExpr cast_or_null_SCEVTruncateExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVTruncateExpr(From);
  }

  public static SCEVTruncateExpr dyn_cast_SCEVTruncateExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static SCEVTruncateExpr dyn_cast_or_null_SCEVTruncateExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static boolean isa_SCEVTruncateExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVTruncateExpr.class, From);
  }

  public static SCEVTruncateExpr cast_SCEVTruncateExpr(SCEV/*P*/ From) {
    assert isa_SCEVTruncateExpr(From);
    return llvm.cast(SCEVTruncateExpr.class, From);
  }

  public static SCEVTruncateExpr cast_or_null_SCEVTruncateExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVTruncateExpr(From);
  }

  public static SCEVTruncateExpr dyn_cast_SCEVTruncateExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static SCEVTruncateExpr dyn_cast_or_null_SCEVTruncateExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVTruncateExpr(From) ? cast_SCEVTruncateExpr(From) : null;
  }

  public static boolean isa_SCEVUDivExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVUDivExpr.class, From);
  }

  public static SCEVUDivExpr cast_SCEVUDivExpr(SCEV/*P*/ From) {
    assert isa_SCEVUDivExpr(From);
    return llvm.cast(SCEVUDivExpr.class, From);
  }

  public static SCEVUDivExpr cast_or_null_SCEVUDivExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVUDivExpr(From);
  }

  public static SCEVUDivExpr dyn_cast_SCEVUDivExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static SCEVUDivExpr dyn_cast_or_null_SCEVUDivExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static boolean isa_SCEVUDivExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVUDivExpr.class, From.$star());
  }

  public static SCEVUDivExpr cast_SCEVUDivExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVUDivExpr(From);
    return llvm.cast(SCEVUDivExpr.class, From.$star());
  }

  public static SCEVUDivExpr cast_or_null_SCEVUDivExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVUDivExpr(From);
  }

  public static SCEVUDivExpr dyn_cast_SCEVUDivExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static SCEVUDivExpr dyn_cast_or_null_SCEVUDivExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static boolean isa_SCEVUDivExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVUDivExpr.class, From.$deref());
  }

  public static SCEVUDivExpr cast_SCEVUDivExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVUDivExpr(From);
    return llvm.cast(SCEVUDivExpr.class, From.$deref());
  }

  public static SCEVUDivExpr cast_or_null_SCEVUDivExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVUDivExpr(From);
  }

  public static SCEVUDivExpr dyn_cast_SCEVUDivExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static SCEVUDivExpr dyn_cast_or_null_SCEVUDivExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVUDivExpr(From) ? cast_SCEVUDivExpr(From) : null;
  }

  public static boolean isa_SCEVUMaxExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVUMaxExpr.class, From);
  }

  public static SCEVUMaxExpr cast_SCEVUMaxExpr(SCEV/*P*/ From) {
    assert isa_SCEVUMaxExpr(From);
    return llvm.cast(SCEVUMaxExpr.class, From);
  }

  public static SCEVUMaxExpr cast_or_null_SCEVUMaxExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVUMaxExpr(From);
  }

  public static SCEVUMaxExpr dyn_cast_SCEVUMaxExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static SCEVUMaxExpr dyn_cast_or_null_SCEVUMaxExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static boolean isa_SCEVUMaxExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVUMaxExpr.class, From.$star());
  }

  public static SCEVUMaxExpr cast_SCEVUMaxExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVUMaxExpr(From);
    return llvm.cast(SCEVUMaxExpr.class, From.$star());
  }

  public static SCEVUMaxExpr cast_or_null_SCEVUMaxExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVUMaxExpr(From);
  }

  public static SCEVUMaxExpr dyn_cast_SCEVUMaxExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static SCEVUMaxExpr dyn_cast_or_null_SCEVUMaxExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static boolean isa_SCEVUMaxExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVUMaxExpr.class, From.$deref());
  }

  public static SCEVUMaxExpr cast_SCEVUMaxExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVUMaxExpr(From);
    return llvm.cast(SCEVUMaxExpr.class, From.$deref());
  }

  public static SCEVUMaxExpr cast_or_null_SCEVUMaxExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVUMaxExpr(From);
  }

  public static SCEVUMaxExpr dyn_cast_SCEVUMaxExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static SCEVUMaxExpr dyn_cast_or_null_SCEVUMaxExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVUMaxExpr(From) ? cast_SCEVUMaxExpr(From) : null;
  }

  public static boolean isa_SCEVUnionPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVUnionPredicate.class, From.$star());
  }

  public static SCEVUnionPredicate cast_SCEVUnionPredicate(type$ptr<?>/*P*/ From) {
    assert isa_SCEVUnionPredicate(From);
    return llvm.cast(SCEVUnionPredicate.class, From.$star());
  }

  public static SCEVUnionPredicate cast_or_null_SCEVUnionPredicate(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVUnionPredicate(From);
  }

  public static SCEVUnionPredicate dyn_cast_SCEVUnionPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static SCEVUnionPredicate dyn_cast_or_null_SCEVUnionPredicate(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static boolean isa_SCEVUnionPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVUnionPredicate.class, From);
  }

  public static SCEVUnionPredicate cast_SCEVUnionPredicate(SCEVPredicate/*P*/ From) {
    assert isa_SCEVUnionPredicate(From);
    return llvm.cast(SCEVUnionPredicate.class, From);
  }

  public static SCEVUnionPredicate cast_or_null_SCEVUnionPredicate(SCEVPredicate/*P*/ From) {
    return (From == null) ? null : cast_SCEVUnionPredicate(From);
  }

  public static SCEVUnionPredicate dyn_cast_SCEVUnionPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static SCEVUnionPredicate dyn_cast_or_null_SCEVUnionPredicate(SCEVPredicate/*P*/ From) {
    return (From != null) && isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static boolean isa_SCEVUnionPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVUnionPredicate.class, From.$deref());
  }

  public static SCEVUnionPredicate cast_SCEVUnionPredicate(type$ref<?>/*P*/ From) {
    assert isa_SCEVUnionPredicate(From);
    return llvm.cast(SCEVUnionPredicate.class, From.$deref());
  }

  public static SCEVUnionPredicate cast_or_null_SCEVUnionPredicate(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVUnionPredicate(From);
  }

  public static SCEVUnionPredicate dyn_cast_SCEVUnionPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static SCEVUnionPredicate dyn_cast_or_null_SCEVUnionPredicate(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVUnionPredicate(From) ? cast_SCEVUnionPredicate(From) : null;
  }

  public static boolean isa_SCEVUnknown(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVUnknown.class, From.$deref());
  }

  public static SCEVUnknown cast_SCEVUnknown(type$ref<?>/*P*/ From) {
    assert isa_SCEVUnknown(From);
    return llvm.cast(SCEVUnknown.class, From.$deref());
  }

  public static SCEVUnknown cast_or_null_SCEVUnknown(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVUnknown(From);
  }

  public static SCEVUnknown dyn_cast_SCEVUnknown(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static SCEVUnknown dyn_cast_or_null_SCEVUnknown(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static boolean isa_SCEVUnknown(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVUnknown.class, From);
  }

  public static SCEVUnknown cast_SCEVUnknown(SCEV/*P*/ From) {
    assert isa_SCEVUnknown(From);
    return llvm.cast(SCEVUnknown.class, From);
  }

  public static SCEVUnknown cast_or_null_SCEVUnknown(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVUnknown(From);
  }

  public static SCEVUnknown dyn_cast_SCEVUnknown(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static SCEVUnknown dyn_cast_or_null_SCEVUnknown(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static boolean isa_SCEVUnknown(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVUnknown.class, From.$star());
  }

  public static SCEVUnknown cast_SCEVUnknown(type$ptr<?>/*P*/ From) {
    assert isa_SCEVUnknown(From);
    return llvm.cast(SCEVUnknown.class, From.$star());
  }

  public static SCEVUnknown cast_or_null_SCEVUnknown(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVUnknown(From);
  }

  public static SCEVUnknown dyn_cast_SCEVUnknown(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static SCEVUnknown dyn_cast_or_null_SCEVUnknown(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVUnknown(From) ? cast_SCEVUnknown(From) : null;
  }

  public static boolean isa_SCEVWrapPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVWrapPredicate.class, From.$star());
  }

  public static SCEVWrapPredicate cast_SCEVWrapPredicate(type$ptr<?>/*P*/ From) {
    assert isa_SCEVWrapPredicate(From);
    return llvm.cast(SCEVWrapPredicate.class, From.$star());
  }

  public static SCEVWrapPredicate cast_or_null_SCEVWrapPredicate(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVWrapPredicate(From);
  }

  public static SCEVWrapPredicate dyn_cast_SCEVWrapPredicate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static SCEVWrapPredicate dyn_cast_or_null_SCEVWrapPredicate(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static boolean isa_SCEVWrapPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVWrapPredicate.class, From);
  }

  public static SCEVWrapPredicate cast_SCEVWrapPredicate(SCEVPredicate/*P*/ From) {
    assert isa_SCEVWrapPredicate(From);
    return llvm.cast(SCEVWrapPredicate.class, From);
  }

  public static SCEVWrapPredicate cast_or_null_SCEVWrapPredicate(SCEVPredicate/*P*/ From) {
    return (From == null) ? null : cast_SCEVWrapPredicate(From);
  }

  public static SCEVWrapPredicate dyn_cast_SCEVWrapPredicate(SCEVPredicate/*P*/ From) {
    assert From != null;
    return isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static SCEVWrapPredicate dyn_cast_or_null_SCEVWrapPredicate(SCEVPredicate/*P*/ From) {
    return (From != null) && isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static boolean isa_SCEVWrapPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVWrapPredicate.class, From.$deref());
  }

  public static SCEVWrapPredicate cast_SCEVWrapPredicate(type$ref<?>/*P*/ From) {
    assert isa_SCEVWrapPredicate(From);
    return llvm.cast(SCEVWrapPredicate.class, From.$deref());
  }

  public static SCEVWrapPredicate cast_or_null_SCEVWrapPredicate(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVWrapPredicate(From);
  }

  public static SCEVWrapPredicate dyn_cast_SCEVWrapPredicate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static SCEVWrapPredicate dyn_cast_or_null_SCEVWrapPredicate(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVWrapPredicate(From) ? cast_SCEVWrapPredicate(From) : null;
  }

  public static boolean isa_SCEVZeroExtendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCEVZeroExtendExpr.class, From.$deref());
  }

  public static SCEVZeroExtendExpr cast_SCEVZeroExtendExpr(type$ref<?>/*P*/ From) {
    assert isa_SCEVZeroExtendExpr(From);
    return llvm.cast(SCEVZeroExtendExpr.class, From.$deref());
  }

  public static SCEVZeroExtendExpr cast_or_null_SCEVZeroExtendExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCEVZeroExtendExpr(From);
  }

  public static SCEVZeroExtendExpr dyn_cast_SCEVZeroExtendExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }

  public static SCEVZeroExtendExpr dyn_cast_or_null_SCEVZeroExtendExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }

  public static boolean isa_SCEVZeroExtendExpr(SCEV/*P*/ From) {
    assert From != null;
    return llvm.isa(SCEVZeroExtendExpr.class, From);
  }

  public static SCEVZeroExtendExpr cast_SCEVZeroExtendExpr(SCEV/*P*/ From) {
    assert isa_SCEVZeroExtendExpr(From);
    return llvm.cast(SCEVZeroExtendExpr.class, From);
  }

  public static SCEVZeroExtendExpr cast_or_null_SCEVZeroExtendExpr(SCEV/*P*/ From) {
    return (From == null) ? null : cast_SCEVZeroExtendExpr(From);
  }

  public static SCEVZeroExtendExpr dyn_cast_SCEVZeroExtendExpr(SCEV/*P*/ From) {
    assert From != null;
    return isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }

  public static SCEVZeroExtendExpr dyn_cast_or_null_SCEVZeroExtendExpr(SCEV/*P*/ From) {
    return (From != null) && isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }

  public static boolean isa_SCEVZeroExtendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCEVZeroExtendExpr.class, From.$star());
  }

  public static SCEVZeroExtendExpr cast_SCEVZeroExtendExpr(type$ptr<?>/*P*/ From) {
    assert isa_SCEVZeroExtendExpr(From);
    return llvm.cast(SCEVZeroExtendExpr.class, From.$star());
  }

  public static SCEVZeroExtendExpr cast_or_null_SCEVZeroExtendExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCEVZeroExtendExpr(From);
  }

  public static SCEVZeroExtendExpr dyn_cast_SCEVZeroExtendExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }

  public static SCEVZeroExtendExpr dyn_cast_or_null_SCEVZeroExtendExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCEVZeroExtendExpr(From) ? cast_SCEVZeroExtendExpr(From) : null;
  }
}
