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
package org.clang.analysis.java;

import org.clang.analysis.*;
import org.clang.analysis.analyses.analyze_format_string.ConversionSpecifier;
import org.clang.analysis.analyses.analyze_printf.PrintfConversionSpecifier;
import org.clang.analysis.analyses.analyze_scanf.ScanfConversionSpecifier;
import org.clank.support.aliases.*;
import org.clang.analysis.analyses.threadSafety.lexpr.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.llvm.support.llvm;

public class AnalysisRTTI {
  /*package*/AnalysisRTTI() {}

  public static boolean isa_BlockInvocationContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockInvocationContext.class, From.$deref());
  }

  public static BlockInvocationContext cast_BlockInvocationContext(type$ref<?>/*P*/ From) {
    assert isa_BlockInvocationContext(From);
    return llvm.cast(BlockInvocationContext.class, From.$deref());
  }

  public static BlockInvocationContext cast_or_null_BlockInvocationContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockInvocationContext(From);
  }

  public static BlockInvocationContext dyn_cast_BlockInvocationContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static BlockInvocationContext dyn_cast_or_null_BlockInvocationContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static boolean isa_BlockInvocationContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockInvocationContext.class, From.$star());
  }

  public static BlockInvocationContext cast_BlockInvocationContext(type$ptr<?>/*P*/ From) {
    assert isa_BlockInvocationContext(From);
    return llvm.cast(BlockInvocationContext.class, From.$star());
  }

  public static BlockInvocationContext cast_or_null_BlockInvocationContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockInvocationContext(From);
  }

  public static BlockInvocationContext dyn_cast_BlockInvocationContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static BlockInvocationContext dyn_cast_or_null_BlockInvocationContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static boolean isa_BlockInvocationContext(LocationContext/*P*/ From) {
    assert From != null;
    return llvm.isa(BlockInvocationContext.class, From);
  }

  public static BlockInvocationContext cast_BlockInvocationContext(LocationContext/*P*/ From) {
    assert isa_BlockInvocationContext(From);
    return llvm.cast(BlockInvocationContext.class, From);
  }

  public static BlockInvocationContext cast_or_null_BlockInvocationContext(LocationContext/*P*/ From) {
    return (From == null) ? null : cast_BlockInvocationContext(From);
  }

  public static BlockInvocationContext dyn_cast_BlockInvocationContext(LocationContext/*P*/ From) {
    assert From != null;
    return isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static BlockInvocationContext dyn_cast_or_null_BlockInvocationContext(LocationContext/*P*/ From) {
    return (From != null) && isa_BlockInvocationContext(From) ? cast_BlockInvocationContext(From) : null;
  }

  public static boolean isa_LocationContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LocationContext.class, From.$star());
  }

  public static LocationContext cast_LocationContext(type$ptr<?>/*P*/ From) {
    assert isa_LocationContext(From);
    return llvm.cast(LocationContext.class, From.$star());
  }

  public static LocationContext cast_or_null_LocationContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LocationContext(From);
  }

  public static LocationContext dyn_cast_LocationContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static LocationContext dyn_cast_or_null_LocationContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static boolean isa_LocationContext(LocationContext/*P*/ From) {
    assert From != null;
    return llvm.isa(LocationContext.class, From);
  }

  public static LocationContext cast_LocationContext(LocationContext/*P*/ From) {
    assert isa_LocationContext(From);
    return llvm.cast(LocationContext.class, From);
  }

  public static LocationContext cast_or_null_LocationContext(LocationContext/*P*/ From) {
    return (From == null) ? null : cast_LocationContext(From);
  }

  public static LocationContext dyn_cast_LocationContext(LocationContext/*P*/ From) {
    assert From != null;
    return isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static LocationContext dyn_cast_or_null_LocationContext(LocationContext/*P*/ From) {
    return (From != null) && isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static boolean isa_LocationContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LocationContext.class, From.$deref());
  }

  public static LocationContext cast_LocationContext(type$ref<?>/*P*/ From) {
    assert isa_LocationContext(From);
    return llvm.cast(LocationContext.class, From.$deref());
  }

  public static LocationContext cast_or_null_LocationContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LocationContext(From);
  }

  public static LocationContext dyn_cast_LocationContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static LocationContext dyn_cast_or_null_LocationContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LocationContext(From) ? cast_LocationContext(From) : null;
  }

  public static boolean isa_ScopeContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ScopeContext.class, From.$deref());
  }

  public static ScopeContext cast_ScopeContext(type$ref<?>/*P*/ From) {
    assert isa_ScopeContext(From);
    return llvm.cast(ScopeContext.class, From.$deref());
  }

  public static ScopeContext cast_or_null_ScopeContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ScopeContext(From);
  }

  public static ScopeContext dyn_cast_ScopeContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static ScopeContext dyn_cast_or_null_ScopeContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static boolean isa_ScopeContext(LocationContext/*P*/ From) {
    assert From != null;
    return llvm.isa(ScopeContext.class, From);
  }

  public static ScopeContext cast_ScopeContext(LocationContext/*P*/ From) {
    assert isa_ScopeContext(From);
    return llvm.cast(ScopeContext.class, From);
  }

  public static ScopeContext cast_or_null_ScopeContext(LocationContext/*P*/ From) {
    return (From == null) ? null : cast_ScopeContext(From);
  }

  public static ScopeContext dyn_cast_ScopeContext(LocationContext/*P*/ From) {
    assert From != null;
    return isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static ScopeContext dyn_cast_or_null_ScopeContext(LocationContext/*P*/ From) {
    return (From != null) && isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static boolean isa_ScopeContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ScopeContext.class, From.$star());
  }

  public static ScopeContext cast_ScopeContext(type$ptr<?>/*P*/ From) {
    assert isa_ScopeContext(From);
    return llvm.cast(ScopeContext.class, From.$star());
  }

  public static ScopeContext cast_or_null_ScopeContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ScopeContext(From);
  }

  public static ScopeContext dyn_cast_ScopeContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static ScopeContext dyn_cast_or_null_ScopeContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ScopeContext(From) ? cast_ScopeContext(From) : null;
  }

  public static boolean isa_StackFrameContext(LocationContext/*P*/ From) {
    assert From != null;
    return llvm.isa(StackFrameContext.class, From);
  }

  public static StackFrameContext cast_StackFrameContext(LocationContext/*P*/ From) {
    assert isa_StackFrameContext(From);
    return llvm.cast(StackFrameContext.class, From);
  }

  public static StackFrameContext cast_or_null_StackFrameContext(LocationContext/*P*/ From) {
    return (From == null) ? null : cast_StackFrameContext(From);
  }

  public static StackFrameContext dyn_cast_StackFrameContext(LocationContext/*P*/ From) {
    assert From != null;
    return isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static StackFrameContext dyn_cast_or_null_StackFrameContext(LocationContext/*P*/ From) {
    return (From != null) && isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static boolean isa_StackFrameContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StackFrameContext.class, From.$star());
  }

  public static StackFrameContext cast_StackFrameContext(type$ptr<?>/*P*/ From) {
    assert isa_StackFrameContext(From);
    return llvm.cast(StackFrameContext.class, From.$star());
  }

  public static StackFrameContext cast_or_null_StackFrameContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StackFrameContext(From);
  }

  public static StackFrameContext dyn_cast_StackFrameContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static StackFrameContext dyn_cast_or_null_StackFrameContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static boolean isa_StackFrameContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StackFrameContext.class, From.$deref());
  }

  public static StackFrameContext cast_StackFrameContext(type$ref<?>/*P*/ From) {
    assert isa_StackFrameContext(From);
    return llvm.cast(StackFrameContext.class, From.$deref());
  }

  public static StackFrameContext cast_or_null_StackFrameContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StackFrameContext(From);
  }

  public static StackFrameContext dyn_cast_StackFrameContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static StackFrameContext dyn_cast_or_null_StackFrameContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StackFrameContext(From) ? cast_StackFrameContext(From) : null;
  }

  public static boolean isa_ConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return llvm.isa(ConversionSpecifier.class, From);
  }

  public static ConversionSpecifier cast_ConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert isa_ConversionSpecifier(From);
    return llvm.cast(ConversionSpecifier.class, From);
  }

  public static ConversionSpecifier cast_or_null_ConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From == null) ? null : cast_ConversionSpecifier(From);
  }

  public static ConversionSpecifier dyn_cast_ConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static ConversionSpecifier dyn_cast_or_null_ConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From != null) && isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static boolean isa_ConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConversionSpecifier.class, From.$deref());
  }

  public static ConversionSpecifier cast_ConversionSpecifier(type$ref<?>/*P*/ From) {
    assert isa_ConversionSpecifier(From);
    return llvm.cast(ConversionSpecifier.class, From.$deref());
  }

  public static ConversionSpecifier cast_or_null_ConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConversionSpecifier(From);
  }

  public static ConversionSpecifier dyn_cast_ConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static ConversionSpecifier dyn_cast_or_null_ConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static boolean isa_ConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConversionSpecifier.class, From.$star());
  }

  public static ConversionSpecifier cast_ConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert isa_ConversionSpecifier(From);
    return llvm.cast(ConversionSpecifier.class, From.$star());
  }

  public static ConversionSpecifier cast_or_null_ConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConversionSpecifier(From);
  }

  public static ConversionSpecifier dyn_cast_ConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static ConversionSpecifier dyn_cast_or_null_ConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConversionSpecifier(From) ? cast_ConversionSpecifier(From) : null;
  }

  public static boolean isa_PrintfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PrintfConversionSpecifier.class, From.$star());
  }

  public static PrintfConversionSpecifier cast_PrintfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert isa_PrintfConversionSpecifier(From);
    return llvm.cast(PrintfConversionSpecifier.class, From.$star());
  }

  public static PrintfConversionSpecifier cast_or_null_PrintfConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PrintfConversionSpecifier(From);
  }

  public static PrintfConversionSpecifier dyn_cast_PrintfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static PrintfConversionSpecifier dyn_cast_or_null_PrintfConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static boolean isa_PrintfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PrintfConversionSpecifier.class, From.$deref());
  }

  public static PrintfConversionSpecifier cast_PrintfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert isa_PrintfConversionSpecifier(From);
    return llvm.cast(PrintfConversionSpecifier.class, From.$deref());
  }

  public static PrintfConversionSpecifier cast_or_null_PrintfConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PrintfConversionSpecifier(From);
  }

  public static PrintfConversionSpecifier dyn_cast_PrintfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static PrintfConversionSpecifier dyn_cast_or_null_PrintfConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static boolean isa_PrintfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return PrintfConversionSpecifier.classof(From);
  }

  public static PrintfConversionSpecifier cast_PrintfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert isa_PrintfConversionSpecifier(From);
    return (From instanceof PrintfConversionSpecifier) ? (PrintfConversionSpecifier) From : new PrintfConversionSpecifier(From);
  }

  public static PrintfConversionSpecifier cast_or_null_PrintfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From == null) ? null : cast_PrintfConversionSpecifier(From);
  }

  public static PrintfConversionSpecifier dyn_cast_PrintfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static PrintfConversionSpecifier dyn_cast_or_null_PrintfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From != null) && isa_PrintfConversionSpecifier(From) ? cast_PrintfConversionSpecifier(From) : null;
  }

  public static boolean isa_ScanfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return ScanfConversionSpecifier.classof(From);
  }

  public static ScanfConversionSpecifier cast_ScanfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert isa_ScanfConversionSpecifier(From);
    return (From instanceof ScanfConversionSpecifier) ? (ScanfConversionSpecifier) From : new ScanfConversionSpecifier(From);
  }

  public static ScanfConversionSpecifier cast_or_null_ScanfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From == null) ? null : cast_ScanfConversionSpecifier(From);
  }

  public static ScanfConversionSpecifier dyn_cast_ScanfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    assert From != null;
    return isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static ScanfConversionSpecifier dyn_cast_or_null_ScanfConversionSpecifier(ConversionSpecifier/*P*/ From) {
    return (From != null) && isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static boolean isa_ScanfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ScanfConversionSpecifier.class, From.$star());
  }

  public static ScanfConversionSpecifier cast_ScanfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert isa_ScanfConversionSpecifier(From);
    return llvm.cast(ScanfConversionSpecifier.class, From.$star());
  }

  public static ScanfConversionSpecifier cast_or_null_ScanfConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ScanfConversionSpecifier(From);
  }

  public static ScanfConversionSpecifier dyn_cast_ScanfConversionSpecifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static ScanfConversionSpecifier dyn_cast_or_null_ScanfConversionSpecifier(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static boolean isa_ScanfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ScanfConversionSpecifier.class, From.$deref());
  }

  public static ScanfConversionSpecifier cast_ScanfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert isa_ScanfConversionSpecifier(From);
    return llvm.cast(ScanfConversionSpecifier.class, From.$deref());
  }

  public static ScanfConversionSpecifier cast_or_null_ScanfConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ScanfConversionSpecifier(From);
  }

  public static ScanfConversionSpecifier dyn_cast_ScanfConversionSpecifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static ScanfConversionSpecifier dyn_cast_or_null_ScanfConversionSpecifier(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ScanfConversionSpecifier(From) ? cast_ScanfConversionSpecifier(From) : null;
  }

  public static boolean isa_And(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(And.class, From.$star());
  }

  public static And cast_And(type$ptr<?>/*P*/ From) {
    assert isa_And(From);
    return llvm.cast(And.class, From.$star());
  }

  public static And cast_or_null_And(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_And(From);
  }

  public static And dyn_cast_And(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_And(From) ? cast_And(From) : null;
  }

  public static And dyn_cast_or_null_And(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_And(From) ? cast_And(From) : null;
  }

  public static boolean isa_And(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(And.class, From.$deref());
  }

  public static And cast_And(type$ref<?>/*P*/ From) {
    assert isa_And(From);
    return llvm.cast(And.class, From.$deref());
  }

  public static And cast_or_null_And(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_And(From);
  }

  public static And dyn_cast_And(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_And(From) ? cast_And(From) : null;
  }

  public static And dyn_cast_or_null_And(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_And(From) ? cast_And(From) : null;
  }

  public static boolean isa_And(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(And.class, From);
  }

  public static And cast_And(LExpr/*P*/ From) {
    assert isa_And(From);
    return llvm.cast(And.class, From);
  }

  public static And cast_or_null_And(LExpr/*P*/ From) {
    return (From == null) ? null : cast_And(From);
  }

  public static And dyn_cast_And(LExpr/*P*/ From) {
    assert From != null;
    return isa_And(From) ? cast_And(From) : null;
  }

  public static And dyn_cast_or_null_And(LExpr/*P*/ From) {
    return (From != null) && isa_And(From) ? cast_And(From) : null;
  }

  public static boolean isa_BinOp(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(BinOp.class, From);
  }

  public static BinOp cast_BinOp(LExpr/*P*/ From) {
    assert isa_BinOp(From);
    return llvm.cast(BinOp.class, From);
  }

  public static BinOp cast_or_null_BinOp(LExpr/*P*/ From) {
    return (From == null) ? null : cast_BinOp(From);
  }

  public static BinOp dyn_cast_BinOp(LExpr/*P*/ From) {
    assert From != null;
    return isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static BinOp dyn_cast_or_null_BinOp(LExpr/*P*/ From) {
    return (From != null) && isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static boolean isa_BinOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinOp.class, From.$deref());
  }

  public static BinOp cast_BinOp(type$ref<?>/*P*/ From) {
    assert isa_BinOp(From);
    return llvm.cast(BinOp.class, From.$deref());
  }

  public static BinOp cast_or_null_BinOp(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinOp(From);
  }

  public static BinOp dyn_cast_BinOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static BinOp dyn_cast_or_null_BinOp(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static boolean isa_BinOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinOp.class, From.$star());
  }

  public static BinOp cast_BinOp(type$ptr<?>/*P*/ From) {
    assert isa_BinOp(From);
    return llvm.cast(BinOp.class, From.$star());
  }

  public static BinOp cast_or_null_BinOp(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinOp(From);
  }

  public static BinOp dyn_cast_BinOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static BinOp dyn_cast_or_null_BinOp(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinOp(From) ? cast_BinOp(From) : null;
  }

  public static boolean isa_LExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LExpr.class, From.$star());
  }

  public static LExpr cast_LExpr(type$ptr<?>/*P*/ From) {
    assert isa_LExpr(From);
    return llvm.cast(LExpr.class, From.$star());
  }

  public static LExpr cast_or_null_LExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LExpr(From);
  }

  public static LExpr dyn_cast_LExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static LExpr dyn_cast_or_null_LExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static boolean isa_LExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LExpr.class, From.$deref());
  }

  public static LExpr cast_LExpr(type$ref<?>/*P*/ From) {
    assert isa_LExpr(From);
    return llvm.cast(LExpr.class, From.$deref());
  }

  public static LExpr cast_or_null_LExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LExpr(From);
  }

  public static LExpr dyn_cast_LExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static LExpr dyn_cast_or_null_LExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static boolean isa_LExpr(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(LExpr.class, From);
  }

  public static LExpr cast_LExpr(LExpr/*P*/ From) {
    assert isa_LExpr(From);
    return llvm.cast(LExpr.class, From);
  }

  public static LExpr cast_or_null_LExpr(LExpr/*P*/ From) {
    return (From == null) ? null : cast_LExpr(From);
  }

  public static LExpr dyn_cast_LExpr(LExpr/*P*/ From) {
    assert From != null;
    return isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static LExpr dyn_cast_or_null_LExpr(LExpr/*P*/ From) {
    return (From != null) && isa_LExpr(From) ? cast_LExpr(From) : null;
  }

  public static boolean isa_Not(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Not.class, From.$deref());
  }

  public static Not cast_Not(type$ref<?>/*P*/ From) {
    assert isa_Not(From);
    return llvm.cast(Not.class, From.$deref());
  }

  public static Not cast_or_null_Not(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Not(From);
  }

  public static Not dyn_cast_Not(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Not(From) ? cast_Not(From) : null;
  }

  public static Not dyn_cast_or_null_Not(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Not(From) ? cast_Not(From) : null;
  }

  public static boolean isa_Not(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Not.class, From);
  }

  public static Not cast_Not(LExpr/*P*/ From) {
    assert isa_Not(From);
    return llvm.cast(Not.class, From);
  }

  public static Not cast_or_null_Not(LExpr/*P*/ From) {
    return (From == null) ? null : cast_Not(From);
  }

  public static Not dyn_cast_Not(LExpr/*P*/ From) {
    assert From != null;
    return isa_Not(From) ? cast_Not(From) : null;
  }

  public static Not dyn_cast_or_null_Not(LExpr/*P*/ From) {
    return (From != null) && isa_Not(From) ? cast_Not(From) : null;
  }

  public static boolean isa_Not(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Not.class, From.$star());
  }

  public static Not cast_Not(type$ptr<?>/*P*/ From) {
    assert isa_Not(From);
    return llvm.cast(Not.class, From.$star());
  }

  public static Not cast_or_null_Not(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Not(From);
  }

  public static Not dyn_cast_Not(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Not(From) ? cast_Not(From) : null;
  }

  public static Not dyn_cast_or_null_Not(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Not(From) ? cast_Not(From) : null;
  }

  public static boolean isa_Or(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Or.class, From.$star());
  }

  public static Or cast_Or(type$ptr<?>/*P*/ From) {
    assert isa_Or(From);
    return llvm.cast(Or.class, From.$star());
  }

  public static Or cast_or_null_Or(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Or(From);
  }

  public static Or dyn_cast_Or(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Or(From) ? cast_Or(From) : null;
  }

  public static Or dyn_cast_or_null_Or(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Or(From) ? cast_Or(From) : null;
  }

  public static boolean isa_Or(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Or.class, From);
  }

  public static Or cast_Or(LExpr/*P*/ From) {
    assert isa_Or(From);
    return llvm.cast(Or.class, From);
  }

  public static Or cast_or_null_Or(LExpr/*P*/ From) {
    return (From == null) ? null : cast_Or(From);
  }

  public static Or dyn_cast_Or(LExpr/*P*/ From) {
    assert From != null;
    return isa_Or(From) ? cast_Or(From) : null;
  }

  public static Or dyn_cast_or_null_Or(LExpr/*P*/ From) {
    return (From != null) && isa_Or(From) ? cast_Or(From) : null;
  }

  public static boolean isa_Or(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Or.class, From.$deref());
  }

  public static Or cast_Or(type$ref<?>/*P*/ From) {
    assert isa_Or(From);
    return llvm.cast(Or.class, From.$deref());
  }

  public static Or cast_or_null_Or(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Or(From);
  }

  public static Or dyn_cast_Or(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Or(From) ? cast_Or(From) : null;
  }

  public static Or dyn_cast_or_null_Or(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Or(From) ? cast_Or(From) : null;
  }

  public static boolean isa_Terminal(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Terminal.class, From.$deref());
  }

  public static Terminal cast_Terminal(type$ref<?>/*P*/ From) {
    assert isa_Terminal(From);
    return llvm.cast(Terminal.class, From.$deref());
  }

  public static Terminal cast_or_null_Terminal(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Terminal(From);
  }

  public static Terminal dyn_cast_Terminal(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static Terminal dyn_cast_or_null_Terminal(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static boolean isa_Terminal(LExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Terminal.class, From);
  }

  public static Terminal cast_Terminal(LExpr/*P*/ From) {
    assert isa_Terminal(From);
    return llvm.cast(Terminal.class, From);
  }

  public static Terminal cast_or_null_Terminal(LExpr/*P*/ From) {
    return (From == null) ? null : cast_Terminal(From);
  }

  public static Terminal dyn_cast_Terminal(LExpr/*P*/ From) {
    assert From != null;
    return isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static Terminal dyn_cast_or_null_Terminal(LExpr/*P*/ From) {
    return (From != null) && isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static boolean isa_Terminal(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Terminal.class, From.$star());
  }

  public static Terminal cast_Terminal(type$ptr<?>/*P*/ From) {
    assert isa_Terminal(From);
    return llvm.cast(Terminal.class, From.$star());
  }

  public static Terminal cast_or_null_Terminal(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Terminal(From);
  }

  public static Terminal dyn_cast_Terminal(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static Terminal dyn_cast_or_null_Terminal(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Terminal(From) ? cast_Terminal(From) : null;
  }

  public static boolean isa_Alloc(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Alloc.class, From.$star());
  }

  public static Alloc cast_Alloc(type$ptr<?>/*P*/ From) {
    assert isa_Alloc(From);
    return llvm.cast(Alloc.class, From.$star());
  }

  public static Alloc cast_or_null_Alloc(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Alloc(From);
  }

  public static Alloc dyn_cast_Alloc(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static Alloc dyn_cast_or_null_Alloc(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static boolean isa_Alloc(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Alloc.class, From);
  }

  public static Alloc cast_Alloc(SExpr/*P*/ From) {
    assert isa_Alloc(From);
    return llvm.cast(Alloc.class, From);
  }

  public static Alloc cast_or_null_Alloc(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Alloc(From);
  }

  public static Alloc dyn_cast_Alloc(SExpr/*P*/ From) {
    assert From != null;
    return isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static Alloc dyn_cast_or_null_Alloc(SExpr/*P*/ From) {
    return (From != null) && isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static boolean isa_Alloc(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Alloc.class, From.$deref());
  }

  public static Alloc cast_Alloc(type$ref<?>/*P*/ From) {
    assert isa_Alloc(From);
    return llvm.cast(Alloc.class, From.$deref());
  }

  public static Alloc cast_or_null_Alloc(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Alloc(From);
  }

  public static Alloc dyn_cast_Alloc(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static Alloc dyn_cast_or_null_Alloc(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Alloc(From) ? cast_Alloc(From) : null;
  }

  public static boolean isa_Apply(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Apply.class, From);
  }

  public static Apply cast_Apply(SExpr/*P*/ From) {
    assert isa_Apply(From);
    return llvm.cast(Apply.class, From);
  }

  public static Apply cast_or_null_Apply(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Apply(From);
  }

  public static Apply dyn_cast_Apply(SExpr/*P*/ From) {
    assert From != null;
    return isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static Apply dyn_cast_or_null_Apply(SExpr/*P*/ From) {
    return (From != null) && isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static boolean isa_Apply(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Apply.class, From.$deref());
  }

  public static Apply cast_Apply(type$ref<?>/*P*/ From) {
    assert isa_Apply(From);
    return llvm.cast(Apply.class, From.$deref());
  }

  public static Apply cast_or_null_Apply(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Apply(From);
  }

  public static Apply dyn_cast_Apply(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static Apply dyn_cast_or_null_Apply(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static boolean isa_Apply(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Apply.class, From.$star());
  }

  public static Apply cast_Apply(type$ptr<?>/*P*/ From) {
    assert isa_Apply(From);
    return llvm.cast(Apply.class, From.$star());
  }

  public static Apply cast_or_null_Apply(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Apply(From);
  }

  public static Apply dyn_cast_Apply(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static Apply dyn_cast_or_null_Apply(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Apply(From) ? cast_Apply(From) : null;
  }

  public static boolean isa_ArrayAdd(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArrayAdd.class, From.$star());
  }

  public static ArrayAdd cast_ArrayAdd(type$ptr<?>/*P*/ From) {
    assert isa_ArrayAdd(From);
    return llvm.cast(ArrayAdd.class, From.$star());
  }

  public static ArrayAdd cast_or_null_ArrayAdd(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArrayAdd(From);
  }

  public static ArrayAdd dyn_cast_ArrayAdd(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static ArrayAdd dyn_cast_or_null_ArrayAdd(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static boolean isa_ArrayAdd(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(ArrayAdd.class, From);
  }

  public static ArrayAdd cast_ArrayAdd(SExpr/*P*/ From) {
    assert isa_ArrayAdd(From);
    return llvm.cast(ArrayAdd.class, From);
  }

  public static ArrayAdd cast_or_null_ArrayAdd(SExpr/*P*/ From) {
    return (From == null) ? null : cast_ArrayAdd(From);
  }

  public static ArrayAdd dyn_cast_ArrayAdd(SExpr/*P*/ From) {
    assert From != null;
    return isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static ArrayAdd dyn_cast_or_null_ArrayAdd(SExpr/*P*/ From) {
    return (From != null) && isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static boolean isa_ArrayAdd(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArrayAdd.class, From.$deref());
  }

  public static ArrayAdd cast_ArrayAdd(type$ref<?>/*P*/ From) {
    assert isa_ArrayAdd(From);
    return llvm.cast(ArrayAdd.class, From.$deref());
  }

  public static ArrayAdd cast_or_null_ArrayAdd(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArrayAdd(From);
  }

  public static ArrayAdd dyn_cast_ArrayAdd(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static ArrayAdd dyn_cast_or_null_ArrayAdd(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArrayAdd(From) ? cast_ArrayAdd(From) : null;
  }

  public static boolean isa_ArrayIndex(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArrayIndex.class, From.$star());
  }

  public static ArrayIndex cast_ArrayIndex(type$ptr<?>/*P*/ From) {
    assert isa_ArrayIndex(From);
    return llvm.cast(ArrayIndex.class, From.$star());
  }

  public static ArrayIndex cast_or_null_ArrayIndex(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArrayIndex(From);
  }

  public static ArrayIndex dyn_cast_ArrayIndex(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static ArrayIndex dyn_cast_or_null_ArrayIndex(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static boolean isa_ArrayIndex(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArrayIndex.class, From.$deref());
  }

  public static ArrayIndex cast_ArrayIndex(type$ref<?>/*P*/ From) {
    assert isa_ArrayIndex(From);
    return llvm.cast(ArrayIndex.class, From.$deref());
  }

  public static ArrayIndex cast_or_null_ArrayIndex(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArrayIndex(From);
  }

  public static ArrayIndex dyn_cast_ArrayIndex(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static ArrayIndex dyn_cast_or_null_ArrayIndex(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static boolean isa_ArrayIndex(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(ArrayIndex.class, From);
  }

  public static ArrayIndex cast_ArrayIndex(SExpr/*P*/ From) {
    assert isa_ArrayIndex(From);
    return llvm.cast(ArrayIndex.class, From);
  }

  public static ArrayIndex cast_or_null_ArrayIndex(SExpr/*P*/ From) {
    return (From == null) ? null : cast_ArrayIndex(From);
  }

  public static ArrayIndex dyn_cast_ArrayIndex(SExpr/*P*/ From) {
    assert From != null;
    return isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static ArrayIndex dyn_cast_or_null_ArrayIndex(SExpr/*P*/ From) {
    return (From != null) && isa_ArrayIndex(From) ? cast_ArrayIndex(From) : null;
  }

  public static boolean isa_BasicBlock(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(BasicBlock.class, From);
  }

  public static BasicBlock cast_BasicBlock(SExpr/*P*/ From) {
    assert isa_BasicBlock(From);
    return llvm.cast(BasicBlock.class, From);
  }

  public static BasicBlock cast_or_null_BasicBlock(SExpr/*P*/ From) {
    return (From == null) ? null : cast_BasicBlock(From);
  }

  public static BasicBlock dyn_cast_BasicBlock(SExpr/*P*/ From) {
    assert From != null;
    return isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static BasicBlock dyn_cast_or_null_BasicBlock(SExpr/*P*/ From) {
    return (From != null) && isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static boolean isa_BasicBlock(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BasicBlock.class, From.$star());
  }

  public static BasicBlock cast_BasicBlock(type$ptr<?>/*P*/ From) {
    assert isa_BasicBlock(From);
    return llvm.cast(BasicBlock.class, From.$star());
  }

  public static BasicBlock cast_or_null_BasicBlock(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BasicBlock(From);
  }

  public static BasicBlock dyn_cast_BasicBlock(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static BasicBlock dyn_cast_or_null_BasicBlock(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static boolean isa_BasicBlock(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BasicBlock.class, From.$deref());
  }

  public static BasicBlock cast_BasicBlock(type$ref<?>/*P*/ From) {
    assert isa_BasicBlock(From);
    return llvm.cast(BasicBlock.class, From.$deref());
  }

  public static BasicBlock cast_or_null_BasicBlock(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BasicBlock(From);
  }

  public static BasicBlock dyn_cast_BasicBlock(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static BasicBlock dyn_cast_or_null_BasicBlock(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static boolean isa_BinaryOp(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(BinaryOp.class, From);
  }

  public static BinaryOp cast_BinaryOp(SExpr/*P*/ From) {
    assert isa_BinaryOp(From);
    return llvm.cast(BinaryOp.class, From);
  }

  public static BinaryOp cast_or_null_BinaryOp(SExpr/*P*/ From) {
    return (From == null) ? null : cast_BinaryOp(From);
  }

  public static BinaryOp dyn_cast_BinaryOp(SExpr/*P*/ From) {
    assert From != null;
    return isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static BinaryOp dyn_cast_or_null_BinaryOp(SExpr/*P*/ From) {
    return (From != null) && isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static boolean isa_BinaryOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinaryOp.class, From.$star());
  }

  public static BinaryOp cast_BinaryOp(type$ptr<?>/*P*/ From) {
    assert isa_BinaryOp(From);
    return llvm.cast(BinaryOp.class, From.$star());
  }

  public static BinaryOp cast_or_null_BinaryOp(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinaryOp(From);
  }

  public static BinaryOp dyn_cast_BinaryOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static BinaryOp dyn_cast_or_null_BinaryOp(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static boolean isa_BinaryOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinaryOp.class, From.$deref());
  }

  public static BinaryOp cast_BinaryOp(type$ref<?>/*P*/ From) {
    assert isa_BinaryOp(From);
    return llvm.cast(BinaryOp.class, From.$deref());
  }

  public static BinaryOp cast_or_null_BinaryOp(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinaryOp(From);
  }

  public static BinaryOp dyn_cast_BinaryOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static BinaryOp dyn_cast_or_null_BinaryOp(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinaryOp(From) ? cast_BinaryOp(From) : null;
  }

  public static boolean isa_Branch(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Branch.class, From.$star());
  }

  public static Branch cast_Branch(type$ptr<?>/*P*/ From) {
    assert isa_Branch(From);
    return llvm.cast(Branch.class, From.$star());
  }

  public static Branch cast_or_null_Branch(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Branch(From);
  }

  public static Branch dyn_cast_Branch(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static Branch dyn_cast_or_null_Branch(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static boolean isa_Branch(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Branch.class, From.$deref());
  }

  public static Branch cast_Branch(type$ref<?>/*P*/ From) {
    assert isa_Branch(From);
    return llvm.cast(Branch.class, From.$deref());
  }

  public static Branch cast_or_null_Branch(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Branch(From);
  }

  public static Branch dyn_cast_Branch(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static Branch dyn_cast_or_null_Branch(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static boolean isa_Branch(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Branch.class, From);
  }

  public static Branch cast_Branch(SExpr/*P*/ From) {
    assert isa_Branch(From);
    return llvm.cast(Branch.class, From);
  }

  public static Branch cast_or_null_Branch(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Branch(From);
  }

  public static Branch dyn_cast_Branch(SExpr/*P*/ From) {
    assert From != null;
    return isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static Branch dyn_cast_or_null_Branch(SExpr/*P*/ From) {
    return (From != null) && isa_Branch(From) ? cast_Branch(From) : null;
  }

  public static boolean isa_Call(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Call.class, From);
  }

  public static Call cast_Call(SExpr/*P*/ From) {
    assert isa_Call(From);
    return llvm.cast(Call.class, From);
  }

  public static Call cast_or_null_Call(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Call(From);
  }

  public static Call dyn_cast_Call(SExpr/*P*/ From) {
    assert From != null;
    return isa_Call(From) ? cast_Call(From) : null;
  }

  public static Call dyn_cast_or_null_Call(SExpr/*P*/ From) {
    return (From != null) && isa_Call(From) ? cast_Call(From) : null;
  }

  public static boolean isa_Call(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Call.class, From.$star());
  }

  public static Call cast_Call(type$ptr<?>/*P*/ From) {
    assert isa_Call(From);
    return llvm.cast(Call.class, From.$star());
  }

  public static Call cast_or_null_Call(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Call(From);
  }

  public static Call dyn_cast_Call(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Call(From) ? cast_Call(From) : null;
  }

  public static Call dyn_cast_or_null_Call(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Call(From) ? cast_Call(From) : null;
  }

  public static boolean isa_Call(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Call.class, From.$deref());
  }

  public static Call cast_Call(type$ref<?>/*P*/ From) {
    assert isa_Call(From);
    return llvm.cast(Call.class, From.$deref());
  }

  public static Call cast_or_null_Call(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Call(From);
  }

  public static Call dyn_cast_Call(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Call(From) ? cast_Call(From) : null;
  }

  public static Call dyn_cast_or_null_Call(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Call(From) ? cast_Call(From) : null;
  }

  public static boolean isa_Cast(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Cast.class, From.$deref());
  }

  public static Cast cast_Cast(type$ref<?>/*P*/ From) {
    assert isa_Cast(From);
    return llvm.cast(Cast.class, From.$deref());
  }

  public static Cast cast_or_null_Cast(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Cast(From);
  }

  public static Cast dyn_cast_Cast(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static Cast dyn_cast_or_null_Cast(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static boolean isa_Cast(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Cast.class, From.$star());
  }

  public static Cast cast_Cast(type$ptr<?>/*P*/ From) {
    assert isa_Cast(From);
    return llvm.cast(Cast.class, From.$star());
  }

  public static Cast cast_or_null_Cast(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Cast(From);
  }

  public static Cast dyn_cast_Cast(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static Cast dyn_cast_or_null_Cast(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static boolean isa_Cast(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Cast.class, From);
  }

  public static Cast cast_Cast(SExpr/*P*/ From) {
    assert isa_Cast(From);
    return llvm.cast(Cast.class, From);
  }

  public static Cast cast_or_null_Cast(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Cast(From);
  }

  public static Cast dyn_cast_Cast(SExpr/*P*/ From) {
    assert From != null;
    return isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static Cast dyn_cast_or_null_Cast(SExpr/*P*/ From) {
    return (From != null) && isa_Cast(From) ? cast_Cast(From) : null;
  }

  public static boolean isa_Code(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Code.class, From.$star());
  }

  public static Code cast_Code(type$ptr<?>/*P*/ From) {
    assert isa_Code(From);
    return llvm.cast(Code.class, From.$star());
  }

  public static Code cast_or_null_Code(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Code(From);
  }

  public static Code dyn_cast_Code(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Code(From) ? cast_Code(From) : null;
  }

  public static Code dyn_cast_or_null_Code(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Code(From) ? cast_Code(From) : null;
  }

  public static boolean isa_Code(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Code.class, From);
  }

  public static Code cast_Code(SExpr/*P*/ From) {
    assert isa_Code(From);
    return llvm.cast(Code.class, From);
  }

  public static Code cast_or_null_Code(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Code(From);
  }

  public static Code dyn_cast_Code(SExpr/*P*/ From) {
    assert From != null;
    return isa_Code(From) ? cast_Code(From) : null;
  }

  public static Code dyn_cast_or_null_Code(SExpr/*P*/ From) {
    return (From != null) && isa_Code(From) ? cast_Code(From) : null;
  }

  public static boolean isa_Code(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Code.class, From.$deref());
  }

  public static Code cast_Code(type$ref<?>/*P*/ From) {
    assert isa_Code(From);
    return llvm.cast(Code.class, From.$deref());
  }

  public static Code cast_or_null_Code(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Code(From);
  }

  public static Code dyn_cast_Code(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Code(From) ? cast_Code(From) : null;
  }

  public static Code dyn_cast_or_null_Code(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Code(From) ? cast_Code(From) : null;
  }

  public static boolean isa_Field(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Field.class, From.$deref());
  }

  public static Field cast_Field(type$ref<?>/*P*/ From) {
    assert isa_Field(From);
    return llvm.cast(Field.class, From.$deref());
  }

  public static Field cast_or_null_Field(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Field(From);
  }

  public static Field dyn_cast_Field(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Field(From) ? cast_Field(From) : null;
  }

  public static Field dyn_cast_or_null_Field(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Field(From) ? cast_Field(From) : null;
  }

  public static boolean isa_Field(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Field.class, From);
  }

  public static Field cast_Field(SExpr/*P*/ From) {
    assert isa_Field(From);
    return llvm.cast(Field.class, From);
  }

  public static Field cast_or_null_Field(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Field(From);
  }

  public static Field dyn_cast_Field(SExpr/*P*/ From) {
    assert From != null;
    return isa_Field(From) ? cast_Field(From) : null;
  }

  public static Field dyn_cast_or_null_Field(SExpr/*P*/ From) {
    return (From != null) && isa_Field(From) ? cast_Field(From) : null;
  }

  public static boolean isa_Field(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Field.class, From.$star());
  }

  public static Field cast_Field(type$ptr<?>/*P*/ From) {
    assert isa_Field(From);
    return llvm.cast(Field.class, From.$star());
  }

  public static Field cast_or_null_Field(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Field(From);
  }

  public static Field dyn_cast_Field(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Field(From) ? cast_Field(From) : null;
  }

  public static Field dyn_cast_or_null_Field(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Field(From) ? cast_Field(From) : null;
  }

  public static boolean isa_Function(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Function.class, From.$deref());
  }

  public static Function cast_Function(type$ref<?>/*P*/ From) {
    assert isa_Function(From);
    return llvm.cast(Function.class, From.$deref());
  }

  public static Function cast_or_null_Function(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Function(From);
  }

  public static Function dyn_cast_Function(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Function(From) ? cast_Function(From) : null;
  }

  public static Function dyn_cast_or_null_Function(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Function(From) ? cast_Function(From) : null;
  }

  public static boolean isa_Function(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Function.class, From.$star());
  }

  public static Function cast_Function(type$ptr<?>/*P*/ From) {
    assert isa_Function(From);
    return llvm.cast(Function.class, From.$star());
  }

  public static Function cast_or_null_Function(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Function(From);
  }

  public static Function dyn_cast_Function(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Function(From) ? cast_Function(From) : null;
  }

  public static Function dyn_cast_or_null_Function(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Function(From) ? cast_Function(From) : null;
  }

  public static boolean isa_Function(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Function.class, From);
  }

  public static Function cast_Function(SExpr/*P*/ From) {
    assert isa_Function(From);
    return llvm.cast(Function.class, From);
  }

  public static Function cast_or_null_Function(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Function(From);
  }

  public static Function dyn_cast_Function(SExpr/*P*/ From) {
    assert From != null;
    return isa_Function(From) ? cast_Function(From) : null;
  }

  public static Function dyn_cast_or_null_Function(SExpr/*P*/ From) {
    return (From != null) && isa_Function(From) ? cast_Function(From) : null;
  }

  public static boolean isa_Future(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Future.class, From);
  }

  public static Future cast_Future(SExpr/*P*/ From) {
    assert isa_Future(From);
    return llvm.cast(Future.class, From);
  }

  public static Future cast_or_null_Future(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Future(From);
  }

  public static Future dyn_cast_Future(SExpr/*P*/ From) {
    assert From != null;
    return isa_Future(From) ? cast_Future(From) : null;
  }

  public static Future dyn_cast_or_null_Future(SExpr/*P*/ From) {
    return (From != null) && isa_Future(From) ? cast_Future(From) : null;
  }

  public static boolean isa_Future(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Future.class, From.$star());
  }

  public static Future cast_Future(type$ptr<?>/*P*/ From) {
    assert isa_Future(From);
    return llvm.cast(Future.class, From.$star());
  }

  public static Future cast_or_null_Future(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Future(From);
  }

  public static Future dyn_cast_Future(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Future(From) ? cast_Future(From) : null;
  }

  public static Future dyn_cast_or_null_Future(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Future(From) ? cast_Future(From) : null;
  }

  public static boolean isa_Future(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Future.class, From.$deref());
  }

  public static Future cast_Future(type$ref<?>/*P*/ From) {
    assert isa_Future(From);
    return llvm.cast(Future.class, From.$deref());
  }

  public static Future cast_or_null_Future(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Future(From);
  }

  public static Future dyn_cast_Future(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Future(From) ? cast_Future(From) : null;
  }

  public static Future dyn_cast_or_null_Future(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Future(From) ? cast_Future(From) : null;
  }

  public static boolean isa_Goto(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Goto.class, From.$deref());
  }

  public static Goto cast_Goto(type$ref<?>/*P*/ From) {
    assert isa_Goto(From);
    return llvm.cast(Goto.class, From.$deref());
  }

  public static Goto cast_or_null_Goto(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Goto(From);
  }

  public static Goto dyn_cast_Goto(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static Goto dyn_cast_or_null_Goto(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static boolean isa_Goto(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Goto.class, From);
  }

  public static Goto cast_Goto(SExpr/*P*/ From) {
    assert isa_Goto(From);
    return llvm.cast(Goto.class, From);
  }

  public static Goto cast_or_null_Goto(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Goto(From);
  }

  public static Goto dyn_cast_Goto(SExpr/*P*/ From) {
    assert From != null;
    return isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static Goto dyn_cast_or_null_Goto(SExpr/*P*/ From) {
    return (From != null) && isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static boolean isa_Goto(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Goto.class, From.$star());
  }

  public static Goto cast_Goto(type$ptr<?>/*P*/ From) {
    assert isa_Goto(From);
    return llvm.cast(Goto.class, From.$star());
  }

  public static Goto cast_or_null_Goto(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Goto(From);
  }

  public static Goto dyn_cast_Goto(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static Goto dyn_cast_or_null_Goto(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Goto(From) ? cast_Goto(From) : null;
  }

  public static boolean isa_Identifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Identifier.class, From.$star());
  }

  public static Identifier cast_Identifier(type$ptr<?>/*P*/ From) {
    assert isa_Identifier(From);
    return llvm.cast(Identifier.class, From.$star());
  }

  public static Identifier cast_or_null_Identifier(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Identifier(From);
  }

  public static Identifier dyn_cast_Identifier(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static Identifier dyn_cast_or_null_Identifier(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static boolean isa_Identifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Identifier.class, From.$deref());
  }

  public static Identifier cast_Identifier(type$ref<?>/*P*/ From) {
    assert isa_Identifier(From);
    return llvm.cast(Identifier.class, From.$deref());
  }

  public static Identifier cast_or_null_Identifier(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Identifier(From);
  }

  public static Identifier dyn_cast_Identifier(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static Identifier dyn_cast_or_null_Identifier(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static boolean isa_Identifier(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Identifier.class, From);
  }

  public static Identifier cast_Identifier(SExpr/*P*/ From) {
    assert isa_Identifier(From);
    return llvm.cast(Identifier.class, From);
  }

  public static Identifier cast_or_null_Identifier(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Identifier(From);
  }

  public static Identifier dyn_cast_Identifier(SExpr/*P*/ From) {
    assert From != null;
    return isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static Identifier dyn_cast_or_null_Identifier(SExpr/*P*/ From) {
    return (From != null) && isa_Identifier(From) ? cast_Identifier(From) : null;
  }

  public static boolean isa_IfThenElse(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IfThenElse.class, From.$star());
  }

  public static IfThenElse cast_IfThenElse(type$ptr<?>/*P*/ From) {
    assert isa_IfThenElse(From);
    return llvm.cast(IfThenElse.class, From.$star());
  }

  public static IfThenElse cast_or_null_IfThenElse(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IfThenElse(From);
  }

  public static IfThenElse dyn_cast_IfThenElse(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static IfThenElse dyn_cast_or_null_IfThenElse(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static boolean isa_IfThenElse(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(IfThenElse.class, From);
  }

  public static IfThenElse cast_IfThenElse(SExpr/*P*/ From) {
    assert isa_IfThenElse(From);
    return llvm.cast(IfThenElse.class, From);
  }

  public static IfThenElse cast_or_null_IfThenElse(SExpr/*P*/ From) {
    return (From == null) ? null : cast_IfThenElse(From);
  }

  public static IfThenElse dyn_cast_IfThenElse(SExpr/*P*/ From) {
    assert From != null;
    return isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static IfThenElse dyn_cast_or_null_IfThenElse(SExpr/*P*/ From) {
    return (From != null) && isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static boolean isa_IfThenElse(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IfThenElse.class, From.$deref());
  }

  public static IfThenElse cast_IfThenElse(type$ref<?>/*P*/ From) {
    assert isa_IfThenElse(From);
    return llvm.cast(IfThenElse.class, From.$deref());
  }

  public static IfThenElse cast_or_null_IfThenElse(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IfThenElse(From);
  }

  public static IfThenElse dyn_cast_IfThenElse(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static IfThenElse dyn_cast_or_null_IfThenElse(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IfThenElse(From) ? cast_IfThenElse(From) : null;
  }

  public static boolean isa_Let(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Let.class, From.$deref());
  }

  public static Let cast_Let(type$ref<?>/*P*/ From) {
    assert isa_Let(From);
    return llvm.cast(Let.class, From.$deref());
  }

  public static Let cast_or_null_Let(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Let(From);
  }

  public static Let dyn_cast_Let(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Let(From) ? cast_Let(From) : null;
  }

  public static Let dyn_cast_or_null_Let(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Let(From) ? cast_Let(From) : null;
  }

  public static boolean isa_Let(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Let.class, From);
  }

  public static Let cast_Let(SExpr/*P*/ From) {
    assert isa_Let(From);
    return llvm.cast(Let.class, From);
  }

  public static Let cast_or_null_Let(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Let(From);
  }

  public static Let dyn_cast_Let(SExpr/*P*/ From) {
    assert From != null;
    return isa_Let(From) ? cast_Let(From) : null;
  }

  public static Let dyn_cast_or_null_Let(SExpr/*P*/ From) {
    return (From != null) && isa_Let(From) ? cast_Let(From) : null;
  }

  public static boolean isa_Let(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Let.class, From.$star());
  }

  public static Let cast_Let(type$ptr<?>/*P*/ From) {
    assert isa_Let(From);
    return llvm.cast(Let.class, From.$star());
  }

  public static Let cast_or_null_Let(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Let(From);
  }

  public static Let dyn_cast_Let(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Let(From) ? cast_Let(From) : null;
  }

  public static Let dyn_cast_or_null_Let(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Let(From) ? cast_Let(From) : null;
  }

  public static boolean isa_Literal(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Literal.class, From.$star());
  }

  public static Literal cast_Literal(type$ptr<?>/*P*/ From) {
    assert isa_Literal(From);
    return llvm.cast(Literal.class, From.$star());
  }

  public static Literal cast_or_null_Literal(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Literal(From);
  }

  public static Literal dyn_cast_Literal(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static Literal dyn_cast_or_null_Literal(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static boolean isa_Literal(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Literal.class, From);
  }

  public static Literal cast_Literal(SExpr/*P*/ From) {
    assert isa_Literal(From);
    return llvm.cast(Literal.class, From);
  }

  public static Literal cast_or_null_Literal(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Literal(From);
  }

  public static Literal dyn_cast_Literal(SExpr/*P*/ From) {
    assert From != null;
    return isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static Literal dyn_cast_or_null_Literal(SExpr/*P*/ From) {
    return (From != null) && isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static boolean isa_Literal(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Literal.class, From.$deref());
  }

  public static Literal cast_Literal(type$ref<?>/*P*/ From) {
    assert isa_Literal(From);
    return llvm.cast(Literal.class, From.$deref());
  }

  public static Literal cast_or_null_Literal(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Literal(From);
  }

  public static Literal dyn_cast_Literal(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static Literal dyn_cast_or_null_Literal(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Literal(From) ? cast_Literal(From) : null;
  }

  public static boolean isa_LiteralPtr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LiteralPtr.class, From.$deref());
  }

  public static LiteralPtr cast_LiteralPtr(type$ref<?>/*P*/ From) {
    assert isa_LiteralPtr(From);
    return llvm.cast(LiteralPtr.class, From.$deref());
  }

  public static LiteralPtr cast_or_null_LiteralPtr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LiteralPtr(From);
  }

  public static LiteralPtr dyn_cast_LiteralPtr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static LiteralPtr dyn_cast_or_null_LiteralPtr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static boolean isa_LiteralPtr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LiteralPtr.class, From.$star());
  }

  public static LiteralPtr cast_LiteralPtr(type$ptr<?>/*P*/ From) {
    assert isa_LiteralPtr(From);
    return llvm.cast(LiteralPtr.class, From.$star());
  }

  public static LiteralPtr cast_or_null_LiteralPtr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LiteralPtr(From);
  }

  public static LiteralPtr dyn_cast_LiteralPtr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static LiteralPtr dyn_cast_or_null_LiteralPtr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static boolean isa_LiteralPtr(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(LiteralPtr.class, From);
  }

  public static LiteralPtr cast_LiteralPtr(SExpr/*P*/ From) {
    assert isa_LiteralPtr(From);
    return llvm.cast(LiteralPtr.class, From);
  }

  public static LiteralPtr cast_or_null_LiteralPtr(SExpr/*P*/ From) {
    return (From == null) ? null : cast_LiteralPtr(From);
  }

  public static LiteralPtr dyn_cast_LiteralPtr(SExpr/*P*/ From) {
    assert From != null;
    return isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static LiteralPtr dyn_cast_or_null_LiteralPtr(SExpr/*P*/ From) {
    return (From != null) && isa_LiteralPtr(From) ? cast_LiteralPtr(From) : null;
  }

  public static boolean isa_LiteralT(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LiteralT.class, From.$deref());
  }

  public static LiteralT cast_LiteralT(type$ref<?>/*P*/ From) {
    assert isa_LiteralT(From);
    return llvm.cast(LiteralT.class, From.$deref());
  }

  public static LiteralT cast_or_null_LiteralT(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LiteralT(From);
  }

  public static LiteralT dyn_cast_LiteralT(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static LiteralT dyn_cast_or_null_LiteralT(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static boolean isa_LiteralT(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LiteralT.class, From.$star());
  }

  public static LiteralT cast_LiteralT(type$ptr<?>/*P*/ From) {
    assert isa_LiteralT(From);
    return llvm.cast(LiteralT.class, From.$star());
  }

  public static LiteralT cast_or_null_LiteralT(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LiteralT(From);
  }

  public static LiteralT dyn_cast_LiteralT(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static LiteralT dyn_cast_or_null_LiteralT(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static boolean isa_LiteralT(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(LiteralT.class, From);
  }

  public static LiteralT cast_LiteralT(SExpr/*P*/ From) {
    assert isa_LiteralT(From);
    return llvm.cast(LiteralT.class, From);
  }

  public static LiteralT cast_or_null_LiteralT(SExpr/*P*/ From) {
    return (From == null) ? null : cast_LiteralT(From);
  }

  public static LiteralT dyn_cast_LiteralT(SExpr/*P*/ From) {
    assert From != null;
    return isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static LiteralT dyn_cast_or_null_LiteralT(SExpr/*P*/ From) {
    return (From != null) && isa_LiteralT(From) ? cast_LiteralT(From) : null;
  }

  public static boolean isa_Load(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Load.class, From.$deref());
  }

  public static Load cast_Load(type$ref<?>/*P*/ From) {
    assert isa_Load(From);
    return llvm.cast(Load.class, From.$deref());
  }

  public static Load cast_or_null_Load(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Load(From);
  }

  public static Load dyn_cast_Load(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Load(From) ? cast_Load(From) : null;
  }

  public static Load dyn_cast_or_null_Load(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Load(From) ? cast_Load(From) : null;
  }

  public static boolean isa_Load(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Load.class, From.$star());
  }

  public static Load cast_Load(type$ptr<?>/*P*/ From) {
    assert isa_Load(From);
    return llvm.cast(Load.class, From.$star());
  }

  public static Load cast_or_null_Load(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Load(From);
  }

  public static Load dyn_cast_Load(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Load(From) ? cast_Load(From) : null;
  }

  public static Load dyn_cast_or_null_Load(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Load(From) ? cast_Load(From) : null;
  }

  public static boolean isa_Load(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Load.class, From);
  }

  public static Load cast_Load(SExpr/*P*/ From) {
    assert isa_Load(From);
    return llvm.cast(Load.class, From);
  }

  public static Load cast_or_null_Load(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Load(From);
  }

  public static Load dyn_cast_Load(SExpr/*P*/ From) {
    assert From != null;
    return isa_Load(From) ? cast_Load(From) : null;
  }

  public static Load dyn_cast_or_null_Load(SExpr/*P*/ From) {
    return (From != null) && isa_Load(From) ? cast_Load(From) : null;
  }

  public static boolean isa_Phi(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Phi.class, From.$deref());
  }

  public static Phi cast_Phi(type$ref<?>/*P*/ From) {
    assert isa_Phi(From);
    return llvm.cast(Phi.class, From.$deref());
  }

  public static Phi cast_or_null_Phi(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Phi(From);
  }

  public static Phi dyn_cast_Phi(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static Phi dyn_cast_or_null_Phi(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static boolean isa_Phi(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Phi.class, From.$star());
  }

  public static Phi cast_Phi(type$ptr<?>/*P*/ From) {
    assert isa_Phi(From);
    return llvm.cast(Phi.class, From.$star());
  }

  public static Phi cast_or_null_Phi(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Phi(From);
  }

  public static Phi dyn_cast_Phi(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static Phi dyn_cast_or_null_Phi(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static boolean isa_Phi(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Phi.class, From);
  }

  public static Phi cast_Phi(SExpr/*P*/ From) {
    assert isa_Phi(From);
    return llvm.cast(Phi.class, From);
  }

  public static Phi cast_or_null_Phi(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Phi(From);
  }

  public static Phi dyn_cast_Phi(SExpr/*P*/ From) {
    assert From != null;
    return isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static Phi dyn_cast_or_null_Phi(SExpr/*P*/ From) {
    return (From != null) && isa_Phi(From) ? cast_Phi(From) : null;
  }

  public static boolean isa_Project(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Project.class, From.$star());
  }

  public static Project cast_Project(type$ptr<?>/*P*/ From) {
    assert isa_Project(From);
    return llvm.cast(Project.class, From.$star());
  }

  public static Project cast_or_null_Project(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Project(From);
  }

  public static Project dyn_cast_Project(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Project(From) ? cast_Project(From) : null;
  }

  public static Project dyn_cast_or_null_Project(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Project(From) ? cast_Project(From) : null;
  }

  public static boolean isa_Project(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Project.class, From.$deref());
  }

  public static Project cast_Project(type$ref<?>/*P*/ From) {
    assert isa_Project(From);
    return llvm.cast(Project.class, From.$deref());
  }

  public static Project cast_or_null_Project(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Project(From);
  }

  public static Project dyn_cast_Project(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Project(From) ? cast_Project(From) : null;
  }

  public static Project dyn_cast_or_null_Project(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Project(From) ? cast_Project(From) : null;
  }

  public static boolean isa_Project(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Project.class, From);
  }

  public static Project cast_Project(SExpr/*P*/ From) {
    assert isa_Project(From);
    return llvm.cast(Project.class, From);
  }

  public static Project cast_or_null_Project(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Project(From);
  }

  public static Project dyn_cast_Project(SExpr/*P*/ From) {
    assert From != null;
    return isa_Project(From) ? cast_Project(From) : null;
  }

  public static Project dyn_cast_or_null_Project(SExpr/*P*/ From) {
    return (From != null) && isa_Project(From) ? cast_Project(From) : null;
  }

  public static boolean isa_Return(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Return.class, From.$star());
  }

  public static Return cast_Return(type$ptr<?>/*P*/ From) {
    assert isa_Return(From);
    return llvm.cast(Return.class, From.$star());
  }

  public static Return cast_or_null_Return(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Return(From);
  }

  public static Return dyn_cast_Return(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Return(From) ? cast_Return(From) : null;
  }

  public static Return dyn_cast_or_null_Return(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Return(From) ? cast_Return(From) : null;
  }

  public static boolean isa_Return(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Return.class, From);
  }

  public static Return cast_Return(SExpr/*P*/ From) {
    assert isa_Return(From);
    return llvm.cast(Return.class, From);
  }

  public static Return cast_or_null_Return(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Return(From);
  }

  public static Return dyn_cast_Return(SExpr/*P*/ From) {
    assert From != null;
    return isa_Return(From) ? cast_Return(From) : null;
  }

  public static Return dyn_cast_or_null_Return(SExpr/*P*/ From) {
    return (From != null) && isa_Return(From) ? cast_Return(From) : null;
  }

  public static boolean isa_Return(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Return.class, From.$deref());
  }

  public static Return cast_Return(type$ref<?>/*P*/ From) {
    assert isa_Return(From);
    return llvm.cast(Return.class, From.$deref());
  }

  public static Return cast_or_null_Return(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Return(From);
  }

  public static Return dyn_cast_Return(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Return(From) ? cast_Return(From) : null;
  }

  public static Return dyn_cast_or_null_Return(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Return(From) ? cast_Return(From) : null;
  }

  public static boolean isa_SApply(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SApply.class, From.$deref());
  }

  public static SApply cast_SApply(type$ref<?>/*P*/ From) {
    assert isa_SApply(From);
    return llvm.cast(SApply.class, From.$deref());
  }

  public static SApply cast_or_null_SApply(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SApply(From);
  }

  public static SApply dyn_cast_SApply(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static SApply dyn_cast_or_null_SApply(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static boolean isa_SApply(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SApply.class, From.$star());
  }

  public static SApply cast_SApply(type$ptr<?>/*P*/ From) {
    assert isa_SApply(From);
    return llvm.cast(SApply.class, From.$star());
  }

  public static SApply cast_or_null_SApply(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SApply(From);
  }

  public static SApply dyn_cast_SApply(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static SApply dyn_cast_or_null_SApply(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static boolean isa_SApply(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SApply.class, From);
  }

  public static SApply cast_SApply(SExpr/*P*/ From) {
    assert isa_SApply(From);
    return llvm.cast(SApply.class, From);
  }

  public static SApply cast_or_null_SApply(SExpr/*P*/ From) {
    return (From == null) ? null : cast_SApply(From);
  }

  public static SApply dyn_cast_SApply(SExpr/*P*/ From) {
    assert From != null;
    return isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static SApply dyn_cast_or_null_SApply(SExpr/*P*/ From) {
    return (From != null) && isa_SApply(From) ? cast_SApply(From) : null;
  }

  public static boolean isa_SCFG(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SCFG.class, From);
  }

  public static SCFG cast_SCFG(SExpr/*P*/ From) {
    assert isa_SCFG(From);
    return llvm.cast(SCFG.class, From);
  }

  public static SCFG cast_or_null_SCFG(SExpr/*P*/ From) {
    return (From == null) ? null : cast_SCFG(From);
  }

  public static SCFG dyn_cast_SCFG(SExpr/*P*/ From) {
    assert From != null;
    return isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static SCFG dyn_cast_or_null_SCFG(SExpr/*P*/ From) {
    return (From != null) && isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static boolean isa_SCFG(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SCFG.class, From.$star());
  }

  public static SCFG cast_SCFG(type$ptr<?>/*P*/ From) {
    assert isa_SCFG(From);
    return llvm.cast(SCFG.class, From.$star());
  }

  public static SCFG cast_or_null_SCFG(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SCFG(From);
  }

  public static SCFG dyn_cast_SCFG(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static SCFG dyn_cast_or_null_SCFG(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static boolean isa_SCFG(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SCFG.class, From.$deref());
  }

  public static SCFG cast_SCFG(type$ref<?>/*P*/ From) {
    assert isa_SCFG(From);
    return llvm.cast(SCFG.class, From.$deref());
  }

  public static SCFG cast_or_null_SCFG(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SCFG(From);
  }

  public static SCFG dyn_cast_SCFG(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static SCFG dyn_cast_or_null_SCFG(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SCFG(From) ? cast_SCFG(From) : null;
  }

  public static boolean isa_SExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SExpr.class, From.$deref());
  }

  public static SExpr cast_SExpr(type$ref<?>/*P*/ From) {
    assert isa_SExpr(From);
    return llvm.cast(SExpr.class, From.$deref());
  }

  public static SExpr cast_or_null_SExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SExpr(From);
  }

  public static SExpr dyn_cast_SExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static SExpr dyn_cast_or_null_SExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static boolean isa_SExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SExpr.class, From.$star());
  }

  public static SExpr cast_SExpr(type$ptr<?>/*P*/ From) {
    assert isa_SExpr(From);
    return llvm.cast(SExpr.class, From.$star());
  }

  public static SExpr cast_or_null_SExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SExpr(From);
  }

  public static SExpr dyn_cast_SExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static SExpr dyn_cast_or_null_SExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static boolean isa_SExpr(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SExpr.class, From);
  }

  public static SExpr cast_SExpr(SExpr/*P*/ From) {
    assert isa_SExpr(From);
    return llvm.cast(SExpr.class, From);
  }

  public static SExpr cast_or_null_SExpr(SExpr/*P*/ From) {
    return (From == null) ? null : cast_SExpr(From);
  }

  public static SExpr dyn_cast_SExpr(SExpr/*P*/ From) {
    assert From != null;
    return isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static SExpr dyn_cast_or_null_SExpr(SExpr/*P*/ From) {
    return (From != null) && isa_SExpr(From) ? cast_SExpr(From) : null;
  }

  public static boolean isa_SFunction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SFunction.class, From.$star());
  }

  public static SFunction cast_SFunction(type$ptr<?>/*P*/ From) {
    assert isa_SFunction(From);
    return llvm.cast(SFunction.class, From.$star());
  }

  public static SFunction cast_or_null_SFunction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SFunction(From);
  }

  public static SFunction dyn_cast_SFunction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static SFunction dyn_cast_or_null_SFunction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static boolean isa_SFunction(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SFunction.class, From);
  }

  public static SFunction cast_SFunction(SExpr/*P*/ From) {
    assert isa_SFunction(From);
    return llvm.cast(SFunction.class, From);
  }

  public static SFunction cast_or_null_SFunction(SExpr/*P*/ From) {
    return (From == null) ? null : cast_SFunction(From);
  }

  public static SFunction dyn_cast_SFunction(SExpr/*P*/ From) {
    assert From != null;
    return isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static SFunction dyn_cast_or_null_SFunction(SExpr/*P*/ From) {
    return (From != null) && isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static boolean isa_SFunction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SFunction.class, From.$deref());
  }

  public static SFunction cast_SFunction(type$ref<?>/*P*/ From) {
    assert isa_SFunction(From);
    return llvm.cast(SFunction.class, From.$deref());
  }

  public static SFunction cast_or_null_SFunction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SFunction(From);
  }

  public static SFunction dyn_cast_SFunction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static SFunction dyn_cast_or_null_SFunction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SFunction(From) ? cast_SFunction(From) : null;
  }

  public static boolean isa_Store(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Store.class, From.$deref());
  }

  public static Store cast_Store(type$ref<?>/*P*/ From) {
    assert isa_Store(From);
    return llvm.cast(Store.class, From.$deref());
  }

  public static Store cast_or_null_Store(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Store(From);
  }

  public static Store dyn_cast_Store(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Store(From) ? cast_Store(From) : null;
  }

  public static Store dyn_cast_or_null_Store(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Store(From) ? cast_Store(From) : null;
  }

  public static boolean isa_Store(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Store.class, From);
  }

  public static Store cast_Store(SExpr/*P*/ From) {
    assert isa_Store(From);
    return llvm.cast(Store.class, From);
  }

  public static Store cast_or_null_Store(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Store(From);
  }

  public static Store dyn_cast_Store(SExpr/*P*/ From) {
    assert From != null;
    return isa_Store(From) ? cast_Store(From) : null;
  }

  public static Store dyn_cast_or_null_Store(SExpr/*P*/ From) {
    return (From != null) && isa_Store(From) ? cast_Store(From) : null;
  }

  public static boolean isa_Store(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Store.class, From.$star());
  }

  public static Store cast_Store(type$ptr<?>/*P*/ From) {
    assert isa_Store(From);
    return llvm.cast(Store.class, From.$star());
  }

  public static Store cast_or_null_Store(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Store(From);
  }

  public static Store dyn_cast_Store(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Store(From) ? cast_Store(From) : null;
  }

  public static Store dyn_cast_or_null_Store(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Store(From) ? cast_Store(From) : null;
  }

  public static boolean isa_Terminator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Terminator.class, From.$star());
  }

  public static Terminator cast_Terminator(type$ptr<?>/*P*/ From) {
    assert isa_Terminator(From);
    return llvm.cast(Terminator.class, From.$star());
  }

  public static Terminator cast_or_null_Terminator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Terminator(From);
  }

  public static Terminator dyn_cast_Terminator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static Terminator dyn_cast_or_null_Terminator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static boolean isa_Terminator(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Terminator.class, From);
  }

  public static Terminator cast_Terminator(SExpr/*P*/ From) {
    assert isa_Terminator(From);
    return llvm.cast(Terminator.class, From);
  }

  public static Terminator cast_or_null_Terminator(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Terminator(From);
  }

  public static Terminator dyn_cast_Terminator(SExpr/*P*/ From) {
    assert From != null;
    return isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static Terminator dyn_cast_or_null_Terminator(SExpr/*P*/ From) {
    return (From != null) && isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static boolean isa_Terminator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Terminator.class, From.$deref());
  }

  public static Terminator cast_Terminator(type$ref<?>/*P*/ From) {
    assert isa_Terminator(From);
    return llvm.cast(Terminator.class, From.$deref());
  }

  public static Terminator cast_or_null_Terminator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Terminator(From);
  }

  public static Terminator dyn_cast_Terminator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static Terminator dyn_cast_or_null_Terminator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Terminator(From) ? cast_Terminator(From) : null;
  }

  public static boolean isa_UnaryOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryOp.class, From.$star());
  }

  public static UnaryOp cast_UnaryOp(type$ptr<?>/*P*/ From) {
    assert isa_UnaryOp(From);
    return llvm.cast(UnaryOp.class, From.$star());
  }

  public static UnaryOp cast_or_null_UnaryOp(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryOp(From);
  }

  public static UnaryOp dyn_cast_UnaryOp(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static UnaryOp dyn_cast_or_null_UnaryOp(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static boolean isa_UnaryOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryOp.class, From.$deref());
  }

  public static UnaryOp cast_UnaryOp(type$ref<?>/*P*/ From) {
    assert isa_UnaryOp(From);
    return llvm.cast(UnaryOp.class, From.$deref());
  }

  public static UnaryOp cast_or_null_UnaryOp(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryOp(From);
  }

  public static UnaryOp dyn_cast_UnaryOp(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static UnaryOp dyn_cast_or_null_UnaryOp(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static boolean isa_UnaryOp(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(UnaryOp.class, From);
  }

  public static UnaryOp cast_UnaryOp(SExpr/*P*/ From) {
    assert isa_UnaryOp(From);
    return llvm.cast(UnaryOp.class, From);
  }

  public static UnaryOp cast_or_null_UnaryOp(SExpr/*P*/ From) {
    return (From == null) ? null : cast_UnaryOp(From);
  }

  public static UnaryOp dyn_cast_UnaryOp(SExpr/*P*/ From) {
    assert From != null;
    return isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static UnaryOp dyn_cast_or_null_UnaryOp(SExpr/*P*/ From) {
    return (From != null) && isa_UnaryOp(From) ? cast_UnaryOp(From) : null;
  }

  public static boolean isa_Undefined(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Undefined.class, From.$star());
  }

  public static Undefined cast_Undefined(type$ptr<?>/*P*/ From) {
    assert isa_Undefined(From);
    return llvm.cast(Undefined.class, From.$star());
  }

  public static Undefined cast_or_null_Undefined(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Undefined(From);
  }

  public static Undefined dyn_cast_Undefined(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static Undefined dyn_cast_or_null_Undefined(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static boolean isa_Undefined(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Undefined.class, From.$deref());
  }

  public static Undefined cast_Undefined(type$ref<?>/*P*/ From) {
    assert isa_Undefined(From);
    return llvm.cast(Undefined.class, From.$deref());
  }

  public static Undefined cast_or_null_Undefined(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Undefined(From);
  }

  public static Undefined dyn_cast_Undefined(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static Undefined dyn_cast_or_null_Undefined(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static boolean isa_Undefined(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Undefined.class, From);
  }

  public static Undefined cast_Undefined(SExpr/*P*/ From) {
    assert isa_Undefined(From);
    return llvm.cast(Undefined.class, From);
  }

  public static Undefined cast_or_null_Undefined(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Undefined(From);
  }

  public static Undefined dyn_cast_Undefined(SExpr/*P*/ From) {
    assert From != null;
    return isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static Undefined dyn_cast_or_null_Undefined(SExpr/*P*/ From) {
    return (From != null) && isa_Undefined(From) ? cast_Undefined(From) : null;
  }

  public static boolean isa_Variable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Variable.class, From.$deref());
  }

  public static Variable cast_Variable(type$ref<?>/*P*/ From) {
    assert isa_Variable(From);
    return llvm.cast(Variable.class, From.$deref());
  }

  public static Variable cast_or_null_Variable(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Variable(From);
  }

  public static Variable dyn_cast_Variable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static Variable dyn_cast_or_null_Variable(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static boolean isa_Variable(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Variable.class, From);
  }

  public static Variable cast_Variable(SExpr/*P*/ From) {
    assert isa_Variable(From);
    return llvm.cast(Variable.class, From);
  }

  public static Variable cast_or_null_Variable(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Variable(From);
  }

  public static Variable dyn_cast_Variable(SExpr/*P*/ From) {
    assert From != null;
    return isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static Variable dyn_cast_or_null_Variable(SExpr/*P*/ From) {
    return (From != null) && isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static boolean isa_Variable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Variable.class, From.$star());
  }

  public static Variable cast_Variable(type$ptr<?>/*P*/ From) {
    assert isa_Variable(From);
    return llvm.cast(Variable.class, From.$star());
  }

  public static Variable cast_or_null_Variable(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Variable(From);
  }

  public static Variable dyn_cast_Variable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static Variable dyn_cast_or_null_Variable(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Variable(From) ? cast_Variable(From) : null;
  }

  public static boolean isa_Wildcard(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Wildcard.class, From.$deref());
  }

  public static Wildcard cast_Wildcard(type$ref<?>/*P*/ From) {
    assert isa_Wildcard(From);
    return llvm.cast(Wildcard.class, From.$deref());
  }

  public static Wildcard cast_or_null_Wildcard(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Wildcard(From);
  }

  public static Wildcard dyn_cast_Wildcard(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }

  public static Wildcard dyn_cast_or_null_Wildcard(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }

  public static boolean isa_Wildcard(SExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(Wildcard.class, From);
  }

  public static Wildcard cast_Wildcard(SExpr/*P*/ From) {
    assert isa_Wildcard(From);
    return llvm.cast(Wildcard.class, From);
  }

  public static Wildcard cast_or_null_Wildcard(SExpr/*P*/ From) {
    return (From == null) ? null : cast_Wildcard(From);
  }

  public static Wildcard dyn_cast_Wildcard(SExpr/*P*/ From) {
    assert From != null;
    return isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }

  public static Wildcard dyn_cast_or_null_Wildcard(SExpr/*P*/ From) {
    return (From != null) && isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }

  public static boolean isa_Wildcard(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Wildcard.class, From.$star());
  }

  public static Wildcard cast_Wildcard(type$ptr<?>/*P*/ From) {
    assert isa_Wildcard(From);
    return llvm.cast(Wildcard.class, From.$star());
  }

  public static Wildcard cast_or_null_Wildcard(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Wildcard(From);
  }

  public static Wildcard dyn_cast_Wildcard(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }

  public static Wildcard dyn_cast_or_null_Wildcard(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Wildcard(From) ? cast_Wildcard(From) : null;
  }
}
