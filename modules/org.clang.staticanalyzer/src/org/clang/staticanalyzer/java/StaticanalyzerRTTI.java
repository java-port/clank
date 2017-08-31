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
package org.clang.staticanalyzer.java;

import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class StaticanalyzerRTTI {
  /*package*/StaticanalyzerRTTI() {}

  public static boolean isa_BugReporter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BugReporter.class, From.$deref());
  }

  public static BugReporter cast_BugReporter(type$ref<?>/*P*/ From) {
    assert isa_BugReporter(From);
    return llvm.cast(BugReporter.class, From.$deref());
  }

  public static BugReporter cast_or_null_BugReporter(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BugReporter(From);
  }

  public static BugReporter dyn_cast_BugReporter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static BugReporter dyn_cast_or_null_BugReporter(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static boolean isa_BugReporter(BugReporter/*P*/ From) {
    assert From != null;
    return llvm.isa(BugReporter.class, From);
  }

  public static BugReporter cast_BugReporter(BugReporter/*P*/ From) {
    assert isa_BugReporter(From);
    return llvm.cast(BugReporter.class, From);
  }

  public static BugReporter cast_or_null_BugReporter(BugReporter/*P*/ From) {
    return (From == null) ? null : cast_BugReporter(From);
  }

  public static BugReporter dyn_cast_BugReporter(BugReporter/*P*/ From) {
    assert From != null;
    return isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static BugReporter dyn_cast_or_null_BugReporter(BugReporter/*P*/ From) {
    return (From != null) && isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static boolean isa_BugReporter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BugReporter.class, From.$star());
  }

  public static BugReporter cast_BugReporter(type$ptr<?>/*P*/ From) {
    assert isa_BugReporter(From);
    return llvm.cast(BugReporter.class, From.$star());
  }

  public static BugReporter cast_or_null_BugReporter(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BugReporter(From);
  }

  public static BugReporter dyn_cast_BugReporter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static BugReporter dyn_cast_or_null_BugReporter(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BugReporter(From) ? cast_BugReporter(From) : null;
  }

  public static boolean isa_GRBugReporter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GRBugReporter.class, From.$star());
  }

  public static GRBugReporter cast_GRBugReporter(type$ptr<?>/*P*/ From) {
    assert isa_GRBugReporter(From);
    return llvm.cast(GRBugReporter.class, From.$star());
  }

  public static GRBugReporter cast_or_null_GRBugReporter(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GRBugReporter(From);
  }

  public static GRBugReporter dyn_cast_GRBugReporter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static GRBugReporter dyn_cast_or_null_GRBugReporter(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static boolean isa_GRBugReporter(BugReporter/*P*/ From) {
    assert From != null;
    return llvm.isa(GRBugReporter.class, From);
  }

  public static GRBugReporter cast_GRBugReporter(BugReporter/*P*/ From) {
    assert isa_GRBugReporter(From);
    return llvm.cast(GRBugReporter.class, From);
  }

  public static GRBugReporter cast_or_null_GRBugReporter(BugReporter/*P*/ From) {
    return (From == null) ? null : cast_GRBugReporter(From);
  }

  public static GRBugReporter dyn_cast_GRBugReporter(BugReporter/*P*/ From) {
    assert From != null;
    return isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static GRBugReporter dyn_cast_or_null_GRBugReporter(BugReporter/*P*/ From) {
    return (From != null) && isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static boolean isa_GRBugReporter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GRBugReporter.class, From.$deref());
  }

  public static GRBugReporter cast_GRBugReporter(type$ref<?>/*P*/ From) {
    assert isa_GRBugReporter(From);
    return llvm.cast(GRBugReporter.class, From.$deref());
  }

  public static GRBugReporter cast_or_null_GRBugReporter(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GRBugReporter(From);
  }

  public static GRBugReporter dyn_cast_GRBugReporter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static GRBugReporter dyn_cast_or_null_GRBugReporter(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GRBugReporter(From) ? cast_GRBugReporter(From) : null;
  }

  public static boolean isa_PathDiagnosticCallPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticCallPiece.class, From.$deref());
  }

  public static PathDiagnosticCallPiece cast_PathDiagnosticCallPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticCallPiece(From);
    return llvm.cast(PathDiagnosticCallPiece.class, From.$deref());
  }

  public static PathDiagnosticCallPiece cast_or_null_PathDiagnosticCallPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticCallPiece(From);
  }

  public static PathDiagnosticCallPiece dyn_cast_PathDiagnosticCallPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static PathDiagnosticCallPiece dyn_cast_or_null_PathDiagnosticCallPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticCallPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticCallPiece.class, From);
  }

  public static PathDiagnosticCallPiece cast_PathDiagnosticCallPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticCallPiece(From);
    return llvm.cast(PathDiagnosticCallPiece.class, From);
  }

  public static PathDiagnosticCallPiece cast_or_null_PathDiagnosticCallPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticCallPiece(From);
  }

  public static PathDiagnosticCallPiece dyn_cast_PathDiagnosticCallPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static PathDiagnosticCallPiece dyn_cast_or_null_PathDiagnosticCallPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticCallPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticCallPiece.class, From.$star());
  }

  public static PathDiagnosticCallPiece cast_PathDiagnosticCallPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticCallPiece(From);
    return llvm.cast(PathDiagnosticCallPiece.class, From.$star());
  }

  public static PathDiagnosticCallPiece cast_or_null_PathDiagnosticCallPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticCallPiece(From);
  }

  public static PathDiagnosticCallPiece dyn_cast_PathDiagnosticCallPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static PathDiagnosticCallPiece dyn_cast_or_null_PathDiagnosticCallPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticCallPiece(From) ? cast_PathDiagnosticCallPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticControlFlowPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticControlFlowPiece.class, From.$deref());
  }

  public static PathDiagnosticControlFlowPiece cast_PathDiagnosticControlFlowPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticControlFlowPiece(From);
    return llvm.cast(PathDiagnosticControlFlowPiece.class, From.$deref());
  }

  public static PathDiagnosticControlFlowPiece cast_or_null_PathDiagnosticControlFlowPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticControlFlowPiece(From);
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_PathDiagnosticControlFlowPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_or_null_PathDiagnosticControlFlowPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticControlFlowPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticControlFlowPiece.class, From);
  }

  public static PathDiagnosticControlFlowPiece cast_PathDiagnosticControlFlowPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticControlFlowPiece(From);
    return llvm.cast(PathDiagnosticControlFlowPiece.class, From);
  }

  public static PathDiagnosticControlFlowPiece cast_or_null_PathDiagnosticControlFlowPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticControlFlowPiece(From);
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_PathDiagnosticControlFlowPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_or_null_PathDiagnosticControlFlowPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticControlFlowPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticControlFlowPiece.class, From.$star());
  }

  public static PathDiagnosticControlFlowPiece cast_PathDiagnosticControlFlowPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticControlFlowPiece(From);
    return llvm.cast(PathDiagnosticControlFlowPiece.class, From.$star());
  }

  public static PathDiagnosticControlFlowPiece cast_or_null_PathDiagnosticControlFlowPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticControlFlowPiece(From);
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_PathDiagnosticControlFlowPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static PathDiagnosticControlFlowPiece dyn_cast_or_null_PathDiagnosticControlFlowPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticControlFlowPiece(From) ? cast_PathDiagnosticControlFlowPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticEventPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticEventPiece.class, From.$deref());
  }

  public static PathDiagnosticEventPiece cast_PathDiagnosticEventPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticEventPiece(From);
    return llvm.cast(PathDiagnosticEventPiece.class, From.$deref());
  }

  public static PathDiagnosticEventPiece cast_or_null_PathDiagnosticEventPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticEventPiece(From);
  }

  public static PathDiagnosticEventPiece dyn_cast_PathDiagnosticEventPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static PathDiagnosticEventPiece dyn_cast_or_null_PathDiagnosticEventPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticEventPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticEventPiece.class, From);
  }

  public static PathDiagnosticEventPiece cast_PathDiagnosticEventPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticEventPiece(From);
    return llvm.cast(PathDiagnosticEventPiece.class, From);
  }

  public static PathDiagnosticEventPiece cast_or_null_PathDiagnosticEventPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticEventPiece(From);
  }

  public static PathDiagnosticEventPiece dyn_cast_PathDiagnosticEventPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static PathDiagnosticEventPiece dyn_cast_or_null_PathDiagnosticEventPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticEventPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticEventPiece.class, From.$star());
  }

  public static PathDiagnosticEventPiece cast_PathDiagnosticEventPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticEventPiece(From);
    return llvm.cast(PathDiagnosticEventPiece.class, From.$star());
  }

  public static PathDiagnosticEventPiece cast_or_null_PathDiagnosticEventPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticEventPiece(From);
  }

  public static PathDiagnosticEventPiece dyn_cast_PathDiagnosticEventPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static PathDiagnosticEventPiece dyn_cast_or_null_PathDiagnosticEventPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticEventPiece(From) ? cast_PathDiagnosticEventPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticMacroPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticMacroPiece.class, From.$star());
  }

  public static PathDiagnosticMacroPiece cast_PathDiagnosticMacroPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticMacroPiece(From);
    return llvm.cast(PathDiagnosticMacroPiece.class, From.$star());
  }

  public static PathDiagnosticMacroPiece cast_or_null_PathDiagnosticMacroPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticMacroPiece(From);
  }

  public static PathDiagnosticMacroPiece dyn_cast_PathDiagnosticMacroPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static PathDiagnosticMacroPiece dyn_cast_or_null_PathDiagnosticMacroPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticMacroPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticMacroPiece.class, From);
  }

  public static PathDiagnosticMacroPiece cast_PathDiagnosticMacroPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticMacroPiece(From);
    return llvm.cast(PathDiagnosticMacroPiece.class, From);
  }

  public static PathDiagnosticMacroPiece cast_or_null_PathDiagnosticMacroPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticMacroPiece(From);
  }

  public static PathDiagnosticMacroPiece dyn_cast_PathDiagnosticMacroPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static PathDiagnosticMacroPiece dyn_cast_or_null_PathDiagnosticMacroPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticMacroPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticMacroPiece.class, From.$deref());
  }

  public static PathDiagnosticMacroPiece cast_PathDiagnosticMacroPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticMacroPiece(From);
    return llvm.cast(PathDiagnosticMacroPiece.class, From.$deref());
  }

  public static PathDiagnosticMacroPiece cast_or_null_PathDiagnosticMacroPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticMacroPiece(From);
  }

  public static PathDiagnosticMacroPiece dyn_cast_PathDiagnosticMacroPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static PathDiagnosticMacroPiece dyn_cast_or_null_PathDiagnosticMacroPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticMacroPiece(From) ? cast_PathDiagnosticMacroPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticPiece.class, From.$star());
  }

  public static PathDiagnosticPiece cast_PathDiagnosticPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticPiece(From);
    return llvm.cast(PathDiagnosticPiece.class, From.$star());
  }

  public static PathDiagnosticPiece cast_or_null_PathDiagnosticPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticPiece(From);
  }

  public static PathDiagnosticPiece dyn_cast_PathDiagnosticPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static PathDiagnosticPiece dyn_cast_or_null_PathDiagnosticPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticPiece.class, From);
  }

  public static PathDiagnosticPiece cast_PathDiagnosticPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticPiece(From);
    return llvm.cast(PathDiagnosticPiece.class, From);
  }

  public static PathDiagnosticPiece cast_or_null_PathDiagnosticPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticPiece(From);
  }

  public static PathDiagnosticPiece dyn_cast_PathDiagnosticPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static PathDiagnosticPiece dyn_cast_or_null_PathDiagnosticPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticPiece.class, From.$deref());
  }

  public static PathDiagnosticPiece cast_PathDiagnosticPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticPiece(From);
    return llvm.cast(PathDiagnosticPiece.class, From.$deref());
  }

  public static PathDiagnosticPiece cast_or_null_PathDiagnosticPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticPiece(From);
  }

  public static PathDiagnosticPiece dyn_cast_PathDiagnosticPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static PathDiagnosticPiece dyn_cast_or_null_PathDiagnosticPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticPiece(From) ? cast_PathDiagnosticPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticSpotPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PathDiagnosticSpotPiece.class, From.$deref());
  }

  public static PathDiagnosticSpotPiece cast_PathDiagnosticSpotPiece(type$ref<?>/*P*/ From) {
    assert isa_PathDiagnosticSpotPiece(From);
    return llvm.cast(PathDiagnosticSpotPiece.class, From.$deref());
  }

  public static PathDiagnosticSpotPiece cast_or_null_PathDiagnosticSpotPiece(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PathDiagnosticSpotPiece(From);
  }

  public static PathDiagnosticSpotPiece dyn_cast_PathDiagnosticSpotPiece(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static PathDiagnosticSpotPiece dyn_cast_or_null_PathDiagnosticSpotPiece(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticSpotPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return llvm.isa(PathDiagnosticSpotPiece.class, From);
  }

  public static PathDiagnosticSpotPiece cast_PathDiagnosticSpotPiece(PathDiagnosticPiece/*P*/ From) {
    assert isa_PathDiagnosticSpotPiece(From);
    return llvm.cast(PathDiagnosticSpotPiece.class, From);
  }

  public static PathDiagnosticSpotPiece cast_or_null_PathDiagnosticSpotPiece(PathDiagnosticPiece/*P*/ From) {
    return (From == null) ? null : cast_PathDiagnosticSpotPiece(From);
  }

  public static PathDiagnosticSpotPiece dyn_cast_PathDiagnosticSpotPiece(PathDiagnosticPiece/*P*/ From) {
    assert From != null;
    return isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static PathDiagnosticSpotPiece dyn_cast_or_null_PathDiagnosticSpotPiece(PathDiagnosticPiece/*P*/ From) {
    return (From != null) && isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static boolean isa_PathDiagnosticSpotPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PathDiagnosticSpotPiece.class, From.$star());
  }

  public static PathDiagnosticSpotPiece cast_PathDiagnosticSpotPiece(type$ptr<?>/*P*/ From) {
    assert isa_PathDiagnosticSpotPiece(From);
    return llvm.cast(PathDiagnosticSpotPiece.class, From.$star());
  }

  public static PathDiagnosticSpotPiece cast_or_null_PathDiagnosticSpotPiece(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PathDiagnosticSpotPiece(From);
  }

  public static PathDiagnosticSpotPiece dyn_cast_PathDiagnosticSpotPiece(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static PathDiagnosticSpotPiece dyn_cast_or_null_PathDiagnosticSpotPiece(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PathDiagnosticSpotPiece(From) ? cast_PathDiagnosticSpotPiece(From) : null;
  }

  public static boolean isa_AllocaRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AllocaRegion.class, From.$star());
  }

  public static AllocaRegion cast_AllocaRegion(type$ptr<?>/*P*/ From) {
    assert isa_AllocaRegion(From);
    return llvm.cast(AllocaRegion.class, From.$star());
  }

  public static AllocaRegion cast_or_null_AllocaRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AllocaRegion(From);
  }

  public static AllocaRegion dyn_cast_AllocaRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static AllocaRegion dyn_cast_or_null_AllocaRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static boolean isa_AllocaRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AllocaRegion.class, From.$deref());
  }

  public static AllocaRegion cast_AllocaRegion(type$ref<?>/*P*/ From) {
    assert isa_AllocaRegion(From);
    return llvm.cast(AllocaRegion.class, From.$deref());
  }

  public static AllocaRegion cast_or_null_AllocaRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AllocaRegion(From);
  }

  public static AllocaRegion dyn_cast_AllocaRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static AllocaRegion dyn_cast_or_null_AllocaRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static boolean isa_AllocaRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(AllocaRegion.class, From);
  }

  public static AllocaRegion cast_AllocaRegion(MemRegion/*P*/ From) {
    assert isa_AllocaRegion(From);
    return llvm.cast(AllocaRegion.class, From);
  }

  public static AllocaRegion cast_or_null_AllocaRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_AllocaRegion(From);
  }

  public static AllocaRegion dyn_cast_AllocaRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static AllocaRegion dyn_cast_or_null_AllocaRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_AllocaRegion(From) ? cast_AllocaRegion(From) : null;
  }

  public static boolean isa_AnyFunctionCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(AnyFunctionCall.class, From);
  }

  public static AnyFunctionCall cast_AnyFunctionCall(CallEvent/*P*/ From) {
    assert isa_AnyFunctionCall(From);
    return llvm.cast(AnyFunctionCall.class, From);
  }

  public static AnyFunctionCall cast_or_null_AnyFunctionCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_AnyFunctionCall(From);
  }

  public static AnyFunctionCall dyn_cast_AnyFunctionCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static AnyFunctionCall dyn_cast_or_null_AnyFunctionCall(CallEvent/*P*/ From) {
    return (From != null) && isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static boolean isa_AnyFunctionCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AnyFunctionCall.class, From.$deref());
  }

  public static AnyFunctionCall cast_AnyFunctionCall(type$ref<?>/*P*/ From) {
    assert isa_AnyFunctionCall(From);
    return llvm.cast(AnyFunctionCall.class, From.$deref());
  }

  public static AnyFunctionCall cast_or_null_AnyFunctionCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AnyFunctionCall(From);
  }

  public static AnyFunctionCall dyn_cast_AnyFunctionCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static AnyFunctionCall dyn_cast_or_null_AnyFunctionCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static boolean isa_AnyFunctionCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AnyFunctionCall.class, From.$star());
  }

  public static AnyFunctionCall cast_AnyFunctionCall(type$ptr<?>/*P*/ From) {
    assert isa_AnyFunctionCall(From);
    return llvm.cast(AnyFunctionCall.class, From.$star());
  }

  public static AnyFunctionCall cast_or_null_AnyFunctionCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AnyFunctionCall(From);
  }

  public static AnyFunctionCall dyn_cast_AnyFunctionCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static AnyFunctionCall dyn_cast_or_null_AnyFunctionCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AnyFunctionCall(From) ? cast_AnyFunctionCall(From) : null;
  }

  public static boolean isa_BinarySymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(BinarySymExpr.class, From);
  }

  public static BinarySymExpr cast_BinarySymExpr(SymExpr/*P*/ From) {
    assert isa_BinarySymExpr(From);
    return llvm.cast(BinarySymExpr.class, From);
  }

  public static BinarySymExpr cast_or_null_BinarySymExpr(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_BinarySymExpr(From);
  }

  public static BinarySymExpr dyn_cast_BinarySymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static BinarySymExpr dyn_cast_or_null_BinarySymExpr(SymExpr/*P*/ From) {
    return (From != null) && isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static boolean isa_BinarySymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinarySymExpr.class, From.$deref());
  }

  public static BinarySymExpr cast_BinarySymExpr(type$ref<?>/*P*/ From) {
    assert isa_BinarySymExpr(From);
    return llvm.cast(BinarySymExpr.class, From.$deref());
  }

  public static BinarySymExpr cast_or_null_BinarySymExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinarySymExpr(From);
  }

  public static BinarySymExpr dyn_cast_BinarySymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static BinarySymExpr dyn_cast_or_null_BinarySymExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static boolean isa_BinarySymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinarySymExpr.class, From.$star());
  }

  public static BinarySymExpr cast_BinarySymExpr(type$ptr<?>/*P*/ From) {
    assert isa_BinarySymExpr(From);
    return llvm.cast(BinarySymExpr.class, From.$star());
  }

  public static BinarySymExpr cast_or_null_BinarySymExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinarySymExpr(From);
  }

  public static BinarySymExpr dyn_cast_BinarySymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static BinarySymExpr dyn_cast_or_null_BinarySymExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinarySymExpr(From) ? cast_BinarySymExpr(From) : null;
  }

  public static boolean isa_BlockCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockCall.class, From.$star());
  }

  public static BlockCall cast_BlockCall(type$ptr<?>/*P*/ From) {
    assert isa_BlockCall(From);
    return llvm.cast(BlockCall.class, From.$star());
  }

  public static BlockCall cast_or_null_BlockCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockCall(From);
  }

  public static BlockCall dyn_cast_BlockCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static BlockCall dyn_cast_or_null_BlockCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static boolean isa_BlockCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockCall.class, From.$deref());
  }

  public static BlockCall cast_BlockCall(type$ref<?>/*P*/ From) {
    assert isa_BlockCall(From);
    return llvm.cast(BlockCall.class, From.$deref());
  }

  public static BlockCall cast_or_null_BlockCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockCall(From);
  }

  public static BlockCall dyn_cast_BlockCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static BlockCall dyn_cast_or_null_BlockCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static boolean isa_BlockCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(BlockCall.class, From);
  }

  public static BlockCall cast_BlockCall(CallEvent/*P*/ From) {
    assert isa_BlockCall(From);
    return llvm.cast(BlockCall.class, From);
  }

  public static BlockCall cast_or_null_BlockCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_BlockCall(From);
  }

  public static BlockCall dyn_cast_BlockCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static BlockCall dyn_cast_or_null_BlockCall(CallEvent/*P*/ From) {
    return (From != null) && isa_BlockCall(From) ? cast_BlockCall(From) : null;
  }

  public static boolean isa_BlockCodeRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockCodeRegion.class, From.$star());
  }

  public static BlockCodeRegion cast_BlockCodeRegion(type$ptr<?>/*P*/ From) {
    assert isa_BlockCodeRegion(From);
    return llvm.cast(BlockCodeRegion.class, From.$star());
  }

  public static BlockCodeRegion cast_or_null_BlockCodeRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockCodeRegion(From);
  }

  public static BlockCodeRegion dyn_cast_BlockCodeRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static BlockCodeRegion dyn_cast_or_null_BlockCodeRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static boolean isa_BlockCodeRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(BlockCodeRegion.class, From);
  }

  public static BlockCodeRegion cast_BlockCodeRegion(MemRegion/*P*/ From) {
    assert isa_BlockCodeRegion(From);
    return llvm.cast(BlockCodeRegion.class, From);
  }

  public static BlockCodeRegion cast_or_null_BlockCodeRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_BlockCodeRegion(From);
  }

  public static BlockCodeRegion dyn_cast_BlockCodeRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static BlockCodeRegion dyn_cast_or_null_BlockCodeRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static boolean isa_BlockCodeRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockCodeRegion.class, From.$deref());
  }

  public static BlockCodeRegion cast_BlockCodeRegion(type$ref<?>/*P*/ From) {
    assert isa_BlockCodeRegion(From);
    return llvm.cast(BlockCodeRegion.class, From.$deref());
  }

  public static BlockCodeRegion cast_or_null_BlockCodeRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockCodeRegion(From);
  }

  public static BlockCodeRegion dyn_cast_BlockCodeRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static BlockCodeRegion dyn_cast_or_null_BlockCodeRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockCodeRegion(From) ? cast_BlockCodeRegion(From) : null;
  }

  public static boolean isa_BlockDataRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockDataRegion.class, From.$deref());
  }

  public static BlockDataRegion cast_BlockDataRegion(type$ref<?>/*P*/ From) {
    assert isa_BlockDataRegion(From);
    return llvm.cast(BlockDataRegion.class, From.$deref());
  }

  public static BlockDataRegion cast_or_null_BlockDataRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockDataRegion(From);
  }

  public static BlockDataRegion dyn_cast_BlockDataRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static BlockDataRegion dyn_cast_or_null_BlockDataRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static boolean isa_BlockDataRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(BlockDataRegion.class, From);
  }

  public static BlockDataRegion cast_BlockDataRegion(MemRegion/*P*/ From) {
    assert isa_BlockDataRegion(From);
    return llvm.cast(BlockDataRegion.class, From);
  }

  public static BlockDataRegion cast_or_null_BlockDataRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_BlockDataRegion(From);
  }

  public static BlockDataRegion dyn_cast_BlockDataRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static BlockDataRegion dyn_cast_or_null_BlockDataRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static boolean isa_BlockDataRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockDataRegion.class, From.$star());
  }

  public static BlockDataRegion cast_BlockDataRegion(type$ptr<?>/*P*/ From) {
    assert isa_BlockDataRegion(From);
    return llvm.cast(BlockDataRegion.class, From.$star());
  }

  public static BlockDataRegion cast_or_null_BlockDataRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockDataRegion(From);
  }

  public static BlockDataRegion dyn_cast_BlockDataRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static BlockDataRegion dyn_cast_or_null_BlockDataRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockDataRegion(From) ? cast_BlockDataRegion(From) : null;
  }

  public static boolean isa_CXXAllocatorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXAllocatorCall.class, From.$star());
  }

  public static CXXAllocatorCall cast_CXXAllocatorCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXAllocatorCall(From);
    return llvm.cast(CXXAllocatorCall.class, From.$star());
  }

  public static CXXAllocatorCall cast_or_null_CXXAllocatorCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXAllocatorCall(From);
  }

  public static CXXAllocatorCall dyn_cast_CXXAllocatorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static CXXAllocatorCall dyn_cast_or_null_CXXAllocatorCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static boolean isa_CXXAllocatorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXAllocatorCall.class, From.$deref());
  }

  public static CXXAllocatorCall cast_CXXAllocatorCall(type$ref<?>/*P*/ From) {
    assert isa_CXXAllocatorCall(From);
    return llvm.cast(CXXAllocatorCall.class, From.$deref());
  }

  public static CXXAllocatorCall cast_or_null_CXXAllocatorCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXAllocatorCall(From);
  }

  public static CXXAllocatorCall dyn_cast_CXXAllocatorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static CXXAllocatorCall dyn_cast_or_null_CXXAllocatorCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static boolean isa_CXXAllocatorCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXAllocatorCall.class, From);
  }

  public static CXXAllocatorCall cast_CXXAllocatorCall(CallEvent/*P*/ From) {
    assert isa_CXXAllocatorCall(From);
    return llvm.cast(CXXAllocatorCall.class, From);
  }

  public static CXXAllocatorCall cast_or_null_CXXAllocatorCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXAllocatorCall(From);
  }

  public static CXXAllocatorCall dyn_cast_CXXAllocatorCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static CXXAllocatorCall dyn_cast_or_null_CXXAllocatorCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXAllocatorCall(From) ? cast_CXXAllocatorCall(From) : null;
  }

  public static boolean isa_CXXBaseObjectRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXBaseObjectRegion.class, From.$deref());
  }

  public static CXXBaseObjectRegion cast_CXXBaseObjectRegion(type$ref<?>/*P*/ From) {
    assert isa_CXXBaseObjectRegion(From);
    return llvm.cast(CXXBaseObjectRegion.class, From.$deref());
  }

  public static CXXBaseObjectRegion cast_or_null_CXXBaseObjectRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXBaseObjectRegion(From);
  }

  public static CXXBaseObjectRegion dyn_cast_CXXBaseObjectRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static CXXBaseObjectRegion dyn_cast_or_null_CXXBaseObjectRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static boolean isa_CXXBaseObjectRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXBaseObjectRegion.class, From.$star());
  }

  public static CXXBaseObjectRegion cast_CXXBaseObjectRegion(type$ptr<?>/*P*/ From) {
    assert isa_CXXBaseObjectRegion(From);
    return llvm.cast(CXXBaseObjectRegion.class, From.$star());
  }

  public static CXXBaseObjectRegion cast_or_null_CXXBaseObjectRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXBaseObjectRegion(From);
  }

  public static CXXBaseObjectRegion dyn_cast_CXXBaseObjectRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static CXXBaseObjectRegion dyn_cast_or_null_CXXBaseObjectRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static boolean isa_CXXBaseObjectRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXBaseObjectRegion.class, From);
  }

  public static CXXBaseObjectRegion cast_CXXBaseObjectRegion(MemRegion/*P*/ From) {
    assert isa_CXXBaseObjectRegion(From);
    return llvm.cast(CXXBaseObjectRegion.class, From);
  }

  public static CXXBaseObjectRegion cast_or_null_CXXBaseObjectRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CXXBaseObjectRegion(From);
  }

  public static CXXBaseObjectRegion dyn_cast_CXXBaseObjectRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static CXXBaseObjectRegion dyn_cast_or_null_CXXBaseObjectRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CXXBaseObjectRegion(From) ? cast_CXXBaseObjectRegion(From) : null;
  }

  public static boolean isa_CXXConstructorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXConstructorCall.class, From.$star());
  }

  public static CXXConstructorCall cast_CXXConstructorCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXConstructorCall(From);
    return llvm.cast(CXXConstructorCall.class, From.$star());
  }

  public static CXXConstructorCall cast_or_null_CXXConstructorCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXConstructorCall(From);
  }

  public static CXXConstructorCall dyn_cast_CXXConstructorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static CXXConstructorCall dyn_cast_or_null_CXXConstructorCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static boolean isa_CXXConstructorCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXConstructorCall.class, From);
  }

  public static CXXConstructorCall cast_CXXConstructorCall(CallEvent/*P*/ From) {
    assert isa_CXXConstructorCall(From);
    return llvm.cast(CXXConstructorCall.class, From);
  }

  public static CXXConstructorCall cast_or_null_CXXConstructorCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorCall(From);
  }

  public static CXXConstructorCall dyn_cast_CXXConstructorCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static CXXConstructorCall dyn_cast_or_null_CXXConstructorCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static boolean isa_CXXConstructorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXConstructorCall.class, From.$deref());
  }

  public static CXXConstructorCall cast_CXXConstructorCall(type$ref<?>/*P*/ From) {
    assert isa_CXXConstructorCall(From);
    return llvm.cast(CXXConstructorCall.class, From.$deref());
  }

  public static CXXConstructorCall cast_or_null_CXXConstructorCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXConstructorCall(From);
  }

  public static CXXConstructorCall dyn_cast_CXXConstructorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static CXXConstructorCall dyn_cast_or_null_CXXConstructorCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXConstructorCall(From) ? cast_CXXConstructorCall(From) : null;
  }

  public static boolean isa_CXXDestructorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXDestructorCall.class, From.$deref());
  }

  public static CXXDestructorCall cast_CXXDestructorCall(type$ref<?>/*P*/ From) {
    assert isa_CXXDestructorCall(From);
    return llvm.cast(CXXDestructorCall.class, From.$deref());
  }

  public static CXXDestructorCall cast_or_null_CXXDestructorCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXDestructorCall(From);
  }

  public static CXXDestructorCall dyn_cast_CXXDestructorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static CXXDestructorCall dyn_cast_or_null_CXXDestructorCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static boolean isa_CXXDestructorCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXDestructorCall.class, From);
  }

  public static CXXDestructorCall cast_CXXDestructorCall(CallEvent/*P*/ From) {
    assert isa_CXXDestructorCall(From);
    return llvm.cast(CXXDestructorCall.class, From);
  }

  public static CXXDestructorCall cast_or_null_CXXDestructorCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorCall(From);
  }

  public static CXXDestructorCall dyn_cast_CXXDestructorCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static CXXDestructorCall dyn_cast_or_null_CXXDestructorCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static boolean isa_CXXDestructorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXDestructorCall.class, From.$star());
  }

  public static CXXDestructorCall cast_CXXDestructorCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXDestructorCall(From);
    return llvm.cast(CXXDestructorCall.class, From.$star());
  }

  public static CXXDestructorCall cast_or_null_CXXDestructorCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXDestructorCall(From);
  }

  public static CXXDestructorCall dyn_cast_CXXDestructorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static CXXDestructorCall dyn_cast_or_null_CXXDestructorCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXDestructorCall(From) ? cast_CXXDestructorCall(From) : null;
  }

  public static boolean isa_CXXInstanceCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXInstanceCall.class, From.$deref());
  }

  public static CXXInstanceCall cast_CXXInstanceCall(type$ref<?>/*P*/ From) {
    assert isa_CXXInstanceCall(From);
    return llvm.cast(CXXInstanceCall.class, From.$deref());
  }

  public static CXXInstanceCall cast_or_null_CXXInstanceCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXInstanceCall(From);
  }

  public static CXXInstanceCall dyn_cast_CXXInstanceCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static CXXInstanceCall dyn_cast_or_null_CXXInstanceCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static boolean isa_CXXInstanceCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXInstanceCall.class, From);
  }

  public static CXXInstanceCall cast_CXXInstanceCall(CallEvent/*P*/ From) {
    assert isa_CXXInstanceCall(From);
    return llvm.cast(CXXInstanceCall.class, From);
  }

  public static CXXInstanceCall cast_or_null_CXXInstanceCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXInstanceCall(From);
  }

  public static CXXInstanceCall dyn_cast_CXXInstanceCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static CXXInstanceCall dyn_cast_or_null_CXXInstanceCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static boolean isa_CXXInstanceCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXInstanceCall.class, From.$star());
  }

  public static CXXInstanceCall cast_CXXInstanceCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXInstanceCall(From);
    return llvm.cast(CXXInstanceCall.class, From.$star());
  }

  public static CXXInstanceCall cast_or_null_CXXInstanceCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXInstanceCall(From);
  }

  public static CXXInstanceCall dyn_cast_CXXInstanceCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static CXXInstanceCall dyn_cast_or_null_CXXInstanceCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXInstanceCall(From) ? cast_CXXInstanceCall(From) : null;
  }

  public static boolean isa_CXXMemberCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXMemberCall.class, From.$star());
  }

  public static CXXMemberCall cast_CXXMemberCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXMemberCall(From);
    return llvm.cast(CXXMemberCall.class, From.$star());
  }

  public static CXXMemberCall cast_or_null_CXXMemberCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXMemberCall(From);
  }

  public static CXXMemberCall dyn_cast_CXXMemberCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static CXXMemberCall dyn_cast_or_null_CXXMemberCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static boolean isa_CXXMemberCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXMemberCall.class, From);
  }

  public static CXXMemberCall cast_CXXMemberCall(CallEvent/*P*/ From) {
    assert isa_CXXMemberCall(From);
    return llvm.cast(CXXMemberCall.class, From);
  }

  public static CXXMemberCall cast_or_null_CXXMemberCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXMemberCall(From);
  }

  public static CXXMemberCall dyn_cast_CXXMemberCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static CXXMemberCall dyn_cast_or_null_CXXMemberCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static boolean isa_CXXMemberCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXMemberCall.class, From.$deref());
  }

  public static CXXMemberCall cast_CXXMemberCall(type$ref<?>/*P*/ From) {
    assert isa_CXXMemberCall(From);
    return llvm.cast(CXXMemberCall.class, From.$deref());
  }

  public static CXXMemberCall cast_or_null_CXXMemberCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXMemberCall(From);
  }

  public static CXXMemberCall dyn_cast_CXXMemberCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static CXXMemberCall dyn_cast_or_null_CXXMemberCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXMemberCall(From) ? cast_CXXMemberCall(From) : null;
  }

  public static boolean isa_CXXMemberOperatorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXMemberOperatorCall.class, From.$star());
  }

  public static CXXMemberOperatorCall cast_CXXMemberOperatorCall(type$ptr<?>/*P*/ From) {
    assert isa_CXXMemberOperatorCall(From);
    return llvm.cast(CXXMemberOperatorCall.class, From.$star());
  }

  public static CXXMemberOperatorCall cast_or_null_CXXMemberOperatorCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXMemberOperatorCall(From);
  }

  public static CXXMemberOperatorCall dyn_cast_CXXMemberOperatorCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static CXXMemberOperatorCall dyn_cast_or_null_CXXMemberOperatorCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static boolean isa_CXXMemberOperatorCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXMemberOperatorCall.class, From);
  }

  public static CXXMemberOperatorCall cast_CXXMemberOperatorCall(CallEvent/*P*/ From) {
    assert isa_CXXMemberOperatorCall(From);
    return llvm.cast(CXXMemberOperatorCall.class, From);
  }

  public static CXXMemberOperatorCall cast_or_null_CXXMemberOperatorCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CXXMemberOperatorCall(From);
  }

  public static CXXMemberOperatorCall dyn_cast_CXXMemberOperatorCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static CXXMemberOperatorCall dyn_cast_or_null_CXXMemberOperatorCall(CallEvent/*P*/ From) {
    return (From != null) && isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static boolean isa_CXXMemberOperatorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXMemberOperatorCall.class, From.$deref());
  }

  public static CXXMemberOperatorCall cast_CXXMemberOperatorCall(type$ref<?>/*P*/ From) {
    assert isa_CXXMemberOperatorCall(From);
    return llvm.cast(CXXMemberOperatorCall.class, From.$deref());
  }

  public static CXXMemberOperatorCall cast_or_null_CXXMemberOperatorCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXMemberOperatorCall(From);
  }

  public static CXXMemberOperatorCall dyn_cast_CXXMemberOperatorCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static CXXMemberOperatorCall dyn_cast_or_null_CXXMemberOperatorCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXMemberOperatorCall(From) ? cast_CXXMemberOperatorCall(From) : null;
  }

  public static boolean isa_CXXTempObjectRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXTempObjectRegion.class, From.$deref());
  }

  public static CXXTempObjectRegion cast_CXXTempObjectRegion(type$ref<?>/*P*/ From) {
    assert isa_CXXTempObjectRegion(From);
    return llvm.cast(CXXTempObjectRegion.class, From.$deref());
  }

  public static CXXTempObjectRegion cast_or_null_CXXTempObjectRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXTempObjectRegion(From);
  }

  public static CXXTempObjectRegion dyn_cast_CXXTempObjectRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static CXXTempObjectRegion dyn_cast_or_null_CXXTempObjectRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static boolean isa_CXXTempObjectRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXTempObjectRegion.class, From);
  }

  public static CXXTempObjectRegion cast_CXXTempObjectRegion(MemRegion/*P*/ From) {
    assert isa_CXXTempObjectRegion(From);
    return llvm.cast(CXXTempObjectRegion.class, From);
  }

  public static CXXTempObjectRegion cast_or_null_CXXTempObjectRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CXXTempObjectRegion(From);
  }

  public static CXXTempObjectRegion dyn_cast_CXXTempObjectRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static CXXTempObjectRegion dyn_cast_or_null_CXXTempObjectRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static boolean isa_CXXTempObjectRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXTempObjectRegion.class, From.$star());
  }

  public static CXXTempObjectRegion cast_CXXTempObjectRegion(type$ptr<?>/*P*/ From) {
    assert isa_CXXTempObjectRegion(From);
    return llvm.cast(CXXTempObjectRegion.class, From.$star());
  }

  public static CXXTempObjectRegion cast_or_null_CXXTempObjectRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXTempObjectRegion(From);
  }

  public static CXXTempObjectRegion dyn_cast_CXXTempObjectRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static CXXTempObjectRegion dyn_cast_or_null_CXXTempObjectRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXTempObjectRegion(From) ? cast_CXXTempObjectRegion(From) : null;
  }

  public static boolean isa_CXXThisRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXXThisRegion.class, From.$deref());
  }

  public static CXXThisRegion cast_CXXThisRegion(type$ref<?>/*P*/ From) {
    assert isa_CXXThisRegion(From);
    return llvm.cast(CXXThisRegion.class, From.$deref());
  }

  public static CXXThisRegion cast_or_null_CXXThisRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXXThisRegion(From);
  }

  public static CXXThisRegion dyn_cast_CXXThisRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static CXXThisRegion dyn_cast_or_null_CXXThisRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static boolean isa_CXXThisRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CXXThisRegion.class, From);
  }

  public static CXXThisRegion cast_CXXThisRegion(MemRegion/*P*/ From) {
    assert isa_CXXThisRegion(From);
    return llvm.cast(CXXThisRegion.class, From);
  }

  public static CXXThisRegion cast_or_null_CXXThisRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CXXThisRegion(From);
  }

  public static CXXThisRegion dyn_cast_CXXThisRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static CXXThisRegion dyn_cast_or_null_CXXThisRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static boolean isa_CXXThisRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXXThisRegion.class, From.$star());
  }

  public static CXXThisRegion cast_CXXThisRegion(type$ptr<?>/*P*/ From) {
    assert isa_CXXThisRegion(From);
    return llvm.cast(CXXThisRegion.class, From.$star());
  }

  public static CXXThisRegion cast_or_null_CXXThisRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXXThisRegion(From);
  }

  public static CXXThisRegion dyn_cast_CXXThisRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static CXXThisRegion dyn_cast_or_null_CXXThisRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXXThisRegion(From) ? cast_CXXThisRegion(From) : null;
  }

  public static boolean isa_CallEvent(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CallEvent.class, From.$deref());
  }

  public static CallEvent cast_CallEvent(type$ref<?>/*P*/ From) {
    assert isa_CallEvent(From);
    return llvm.cast(CallEvent.class, From.$deref());
  }

  public static CallEvent cast_or_null_CallEvent(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CallEvent(From);
  }

  public static CallEvent dyn_cast_CallEvent(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static CallEvent dyn_cast_or_null_CallEvent(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static boolean isa_CallEvent(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(CallEvent.class, From);
  }

  public static CallEvent cast_CallEvent(CallEvent/*P*/ From) {
    assert isa_CallEvent(From);
    return llvm.cast(CallEvent.class, From);
  }

  public static CallEvent cast_or_null_CallEvent(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_CallEvent(From);
  }

  public static CallEvent dyn_cast_CallEvent(CallEvent/*P*/ From) {
    assert From != null;
    return isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static CallEvent dyn_cast_or_null_CallEvent(CallEvent/*P*/ From) {
    return (From != null) && isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static boolean isa_CallEvent(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CallEvent.class, From.$star());
  }

  public static CallEvent cast_CallEvent(type$ptr<?>/*P*/ From) {
    assert isa_CallEvent(From);
    return llvm.cast(CallEvent.class, From.$star());
  }

  public static CallEvent cast_or_null_CallEvent(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CallEvent(From);
  }

  public static CallEvent dyn_cast_CallEvent(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static CallEvent dyn_cast_or_null_CallEvent(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CallEvent(From) ? cast_CallEvent(From) : null;
  }

  public static boolean isa_CodeSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CodeSpaceRegion.class, From);
  }

  public static CodeSpaceRegion cast_CodeSpaceRegion(MemRegion/*P*/ From) {
    assert isa_CodeSpaceRegion(From);
    return llvm.cast(CodeSpaceRegion.class, From);
  }

  public static CodeSpaceRegion cast_or_null_CodeSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CodeSpaceRegion(From);
  }

  public static CodeSpaceRegion dyn_cast_CodeSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static CodeSpaceRegion dyn_cast_or_null_CodeSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static boolean isa_CodeSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CodeSpaceRegion.class, From.$deref());
  }

  public static CodeSpaceRegion cast_CodeSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_CodeSpaceRegion(From);
    return llvm.cast(CodeSpaceRegion.class, From.$deref());
  }

  public static CodeSpaceRegion cast_or_null_CodeSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CodeSpaceRegion(From);
  }

  public static CodeSpaceRegion dyn_cast_CodeSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static CodeSpaceRegion dyn_cast_or_null_CodeSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static boolean isa_CodeSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CodeSpaceRegion.class, From.$star());
  }

  public static CodeSpaceRegion cast_CodeSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_CodeSpaceRegion(From);
    return llvm.cast(CodeSpaceRegion.class, From.$star());
  }

  public static CodeSpaceRegion cast_or_null_CodeSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CodeSpaceRegion(From);
  }

  public static CodeSpaceRegion dyn_cast_CodeSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static CodeSpaceRegion dyn_cast_or_null_CodeSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CodeSpaceRegion(From) ? cast_CodeSpaceRegion(From) : null;
  }

  public static boolean isa_CodeTextRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CodeTextRegion.class, From.$star());
  }

  public static CodeTextRegion cast_CodeTextRegion(type$ptr<?>/*P*/ From) {
    assert isa_CodeTextRegion(From);
    return llvm.cast(CodeTextRegion.class, From.$star());
  }

  public static CodeTextRegion cast_or_null_CodeTextRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CodeTextRegion(From);
  }

  public static CodeTextRegion dyn_cast_CodeTextRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static CodeTextRegion dyn_cast_or_null_CodeTextRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static boolean isa_CodeTextRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CodeTextRegion.class, From);
  }

  public static CodeTextRegion cast_CodeTextRegion(MemRegion/*P*/ From) {
    assert isa_CodeTextRegion(From);
    return llvm.cast(CodeTextRegion.class, From);
  }

  public static CodeTextRegion cast_or_null_CodeTextRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CodeTextRegion(From);
  }

  public static CodeTextRegion dyn_cast_CodeTextRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static CodeTextRegion dyn_cast_or_null_CodeTextRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static boolean isa_CodeTextRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CodeTextRegion.class, From.$deref());
  }

  public static CodeTextRegion cast_CodeTextRegion(type$ref<?>/*P*/ From) {
    assert isa_CodeTextRegion(From);
    return llvm.cast(CodeTextRegion.class, From.$deref());
  }

  public static CodeTextRegion cast_or_null_CodeTextRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CodeTextRegion(From);
  }

  public static CodeTextRegion dyn_cast_CodeTextRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static CodeTextRegion dyn_cast_or_null_CodeTextRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CodeTextRegion(From) ? cast_CodeTextRegion(From) : null;
  }

  public static boolean isa_CompoundLiteralRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompoundLiteralRegion.class, From.$star());
  }

  public static CompoundLiteralRegion cast_CompoundLiteralRegion(type$ptr<?>/*P*/ From) {
    assert isa_CompoundLiteralRegion(From);
    return llvm.cast(CompoundLiteralRegion.class, From.$star());
  }

  public static CompoundLiteralRegion cast_or_null_CompoundLiteralRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompoundLiteralRegion(From);
  }

  public static CompoundLiteralRegion dyn_cast_CompoundLiteralRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static CompoundLiteralRegion dyn_cast_or_null_CompoundLiteralRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static boolean isa_CompoundLiteralRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompoundLiteralRegion.class, From.$deref());
  }

  public static CompoundLiteralRegion cast_CompoundLiteralRegion(type$ref<?>/*P*/ From) {
    assert isa_CompoundLiteralRegion(From);
    return llvm.cast(CompoundLiteralRegion.class, From.$deref());
  }

  public static CompoundLiteralRegion cast_or_null_CompoundLiteralRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompoundLiteralRegion(From);
  }

  public static CompoundLiteralRegion dyn_cast_CompoundLiteralRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static CompoundLiteralRegion dyn_cast_or_null_CompoundLiteralRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static boolean isa_CompoundLiteralRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(CompoundLiteralRegion.class, From);
  }

  public static CompoundLiteralRegion cast_CompoundLiteralRegion(MemRegion/*P*/ From) {
    assert isa_CompoundLiteralRegion(From);
    return llvm.cast(CompoundLiteralRegion.class, From);
  }

  public static CompoundLiteralRegion cast_or_null_CompoundLiteralRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_CompoundLiteralRegion(From);
  }

  public static CompoundLiteralRegion dyn_cast_CompoundLiteralRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static CompoundLiteralRegion dyn_cast_or_null_CompoundLiteralRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_CompoundLiteralRegion(From) ? cast_CompoundLiteralRegion(From) : null;
  }

  public static boolean isa_DeclRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(DeclRegion.class, From);
  }

  public static DeclRegion cast_DeclRegion(MemRegion/*P*/ From) {
    assert isa_DeclRegion(From);
    return llvm.cast(DeclRegion.class, From);
  }

  public static DeclRegion cast_or_null_DeclRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_DeclRegion(From);
  }

  public static DeclRegion dyn_cast_DeclRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static DeclRegion dyn_cast_or_null_DeclRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static boolean isa_DeclRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeclRegion.class, From.$deref());
  }

  public static DeclRegion cast_DeclRegion(type$ref<?>/*P*/ From) {
    assert isa_DeclRegion(From);
    return llvm.cast(DeclRegion.class, From.$deref());
  }

  public static DeclRegion cast_or_null_DeclRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeclRegion(From);
  }

  public static DeclRegion dyn_cast_DeclRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static DeclRegion dyn_cast_or_null_DeclRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static boolean isa_DeclRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeclRegion.class, From.$star());
  }

  public static DeclRegion cast_DeclRegion(type$ptr<?>/*P*/ From) {
    assert isa_DeclRegion(From);
    return llvm.cast(DeclRegion.class, From.$star());
  }

  public static DeclRegion cast_or_null_DeclRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeclRegion(From);
  }

  public static DeclRegion dyn_cast_DeclRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static DeclRegion dyn_cast_or_null_DeclRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeclRegion(From) ? cast_DeclRegion(From) : null;
  }

  public static boolean isa_ElementRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ElementRegion.class, From.$star());
  }

  public static ElementRegion cast_ElementRegion(type$ptr<?>/*P*/ From) {
    assert isa_ElementRegion(From);
    return llvm.cast(ElementRegion.class, From.$star());
  }

  public static ElementRegion cast_or_null_ElementRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ElementRegion(From);
  }

  public static ElementRegion dyn_cast_ElementRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static ElementRegion dyn_cast_or_null_ElementRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static boolean isa_ElementRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ElementRegion.class, From.$deref());
  }

  public static ElementRegion cast_ElementRegion(type$ref<?>/*P*/ From) {
    assert isa_ElementRegion(From);
    return llvm.cast(ElementRegion.class, From.$deref());
  }

  public static ElementRegion cast_or_null_ElementRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ElementRegion(From);
  }

  public static ElementRegion dyn_cast_ElementRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static ElementRegion dyn_cast_or_null_ElementRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static boolean isa_ElementRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(ElementRegion.class, From);
  }

  public static ElementRegion cast_ElementRegion(MemRegion/*P*/ From) {
    assert isa_ElementRegion(From);
    return llvm.cast(ElementRegion.class, From);
  }

  public static ElementRegion cast_or_null_ElementRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_ElementRegion(From);
  }

  public static ElementRegion dyn_cast_ElementRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static ElementRegion dyn_cast_or_null_ElementRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_ElementRegion(From) ? cast_ElementRegion(From) : null;
  }

  public static boolean isa_FieldRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(FieldRegion.class, From);
  }

  public static FieldRegion cast_FieldRegion(MemRegion/*P*/ From) {
    assert isa_FieldRegion(From);
    return llvm.cast(FieldRegion.class, From);
  }

  public static FieldRegion cast_or_null_FieldRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_FieldRegion(From);
  }

  public static FieldRegion dyn_cast_FieldRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static FieldRegion dyn_cast_or_null_FieldRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static boolean isa_FieldRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FieldRegion.class, From.$deref());
  }

  public static FieldRegion cast_FieldRegion(type$ref<?>/*P*/ From) {
    assert isa_FieldRegion(From);
    return llvm.cast(FieldRegion.class, From.$deref());
  }

  public static FieldRegion cast_or_null_FieldRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FieldRegion(From);
  }

  public static FieldRegion dyn_cast_FieldRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static FieldRegion dyn_cast_or_null_FieldRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static boolean isa_FieldRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FieldRegion.class, From.$star());
  }

  public static FieldRegion cast_FieldRegion(type$ptr<?>/*P*/ From) {
    assert isa_FieldRegion(From);
    return llvm.cast(FieldRegion.class, From.$star());
  }

  public static FieldRegion cast_or_null_FieldRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FieldRegion(From);
  }

  public static FieldRegion dyn_cast_FieldRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static FieldRegion dyn_cast_or_null_FieldRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FieldRegion(From) ? cast_FieldRegion(From) : null;
  }

  public static boolean isa_FunctionCodeRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionCodeRegion.class, From.$star());
  }

  public static FunctionCodeRegion cast_FunctionCodeRegion(type$ptr<?>/*P*/ From) {
    assert isa_FunctionCodeRegion(From);
    return llvm.cast(FunctionCodeRegion.class, From.$star());
  }

  public static FunctionCodeRegion cast_or_null_FunctionCodeRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionCodeRegion(From);
  }

  public static FunctionCodeRegion dyn_cast_FunctionCodeRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static FunctionCodeRegion dyn_cast_or_null_FunctionCodeRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static boolean isa_FunctionCodeRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionCodeRegion.class, From.$deref());
  }

  public static FunctionCodeRegion cast_FunctionCodeRegion(type$ref<?>/*P*/ From) {
    assert isa_FunctionCodeRegion(From);
    return llvm.cast(FunctionCodeRegion.class, From.$deref());
  }

  public static FunctionCodeRegion cast_or_null_FunctionCodeRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionCodeRegion(From);
  }

  public static FunctionCodeRegion dyn_cast_FunctionCodeRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static FunctionCodeRegion dyn_cast_or_null_FunctionCodeRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static boolean isa_FunctionCodeRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(FunctionCodeRegion.class, From);
  }

  public static FunctionCodeRegion cast_FunctionCodeRegion(MemRegion/*P*/ From) {
    assert isa_FunctionCodeRegion(From);
    return llvm.cast(FunctionCodeRegion.class, From);
  }

  public static FunctionCodeRegion cast_or_null_FunctionCodeRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_FunctionCodeRegion(From);
  }

  public static FunctionCodeRegion dyn_cast_FunctionCodeRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static FunctionCodeRegion dyn_cast_or_null_FunctionCodeRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_FunctionCodeRegion(From) ? cast_FunctionCodeRegion(From) : null;
  }

  public static boolean isa_GlobalImmutableSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalImmutableSpaceRegion.class, From.$star());
  }

  public static GlobalImmutableSpaceRegion cast_GlobalImmutableSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_GlobalImmutableSpaceRegion(From);
    return llvm.cast(GlobalImmutableSpaceRegion.class, From.$star());
  }

  public static GlobalImmutableSpaceRegion cast_or_null_GlobalImmutableSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalImmutableSpaceRegion(From);
  }

  public static GlobalImmutableSpaceRegion dyn_cast_GlobalImmutableSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static GlobalImmutableSpaceRegion dyn_cast_or_null_GlobalImmutableSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalImmutableSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalImmutableSpaceRegion.class, From.$deref());
  }

  public static GlobalImmutableSpaceRegion cast_GlobalImmutableSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_GlobalImmutableSpaceRegion(From);
    return llvm.cast(GlobalImmutableSpaceRegion.class, From.$deref());
  }

  public static GlobalImmutableSpaceRegion cast_or_null_GlobalImmutableSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalImmutableSpaceRegion(From);
  }

  public static GlobalImmutableSpaceRegion dyn_cast_GlobalImmutableSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static GlobalImmutableSpaceRegion dyn_cast_or_null_GlobalImmutableSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalImmutableSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(GlobalImmutableSpaceRegion.class, From);
  }

  public static GlobalImmutableSpaceRegion cast_GlobalImmutableSpaceRegion(MemRegion/*P*/ From) {
    assert isa_GlobalImmutableSpaceRegion(From);
    return llvm.cast(GlobalImmutableSpaceRegion.class, From);
  }

  public static GlobalImmutableSpaceRegion cast_or_null_GlobalImmutableSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_GlobalImmutableSpaceRegion(From);
  }

  public static GlobalImmutableSpaceRegion dyn_cast_GlobalImmutableSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static GlobalImmutableSpaceRegion dyn_cast_or_null_GlobalImmutableSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_GlobalImmutableSpaceRegion(From) ? cast_GlobalImmutableSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalInternalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalInternalSpaceRegion.class, From.$deref());
  }

  public static GlobalInternalSpaceRegion cast_GlobalInternalSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_GlobalInternalSpaceRegion(From);
    return llvm.cast(GlobalInternalSpaceRegion.class, From.$deref());
  }

  public static GlobalInternalSpaceRegion cast_or_null_GlobalInternalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalInternalSpaceRegion(From);
  }

  public static GlobalInternalSpaceRegion dyn_cast_GlobalInternalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static GlobalInternalSpaceRegion dyn_cast_or_null_GlobalInternalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalInternalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(GlobalInternalSpaceRegion.class, From);
  }

  public static GlobalInternalSpaceRegion cast_GlobalInternalSpaceRegion(MemRegion/*P*/ From) {
    assert isa_GlobalInternalSpaceRegion(From);
    return llvm.cast(GlobalInternalSpaceRegion.class, From);
  }

  public static GlobalInternalSpaceRegion cast_or_null_GlobalInternalSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_GlobalInternalSpaceRegion(From);
  }

  public static GlobalInternalSpaceRegion dyn_cast_GlobalInternalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static GlobalInternalSpaceRegion dyn_cast_or_null_GlobalInternalSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalInternalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalInternalSpaceRegion.class, From.$star());
  }

  public static GlobalInternalSpaceRegion cast_GlobalInternalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_GlobalInternalSpaceRegion(From);
    return llvm.cast(GlobalInternalSpaceRegion.class, From.$star());
  }

  public static GlobalInternalSpaceRegion cast_or_null_GlobalInternalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalInternalSpaceRegion(From);
  }

  public static GlobalInternalSpaceRegion dyn_cast_GlobalInternalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static GlobalInternalSpaceRegion dyn_cast_or_null_GlobalInternalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalInternalSpaceRegion(From) ? cast_GlobalInternalSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalSystemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalSystemSpaceRegion.class, From.$star());
  }

  public static GlobalSystemSpaceRegion cast_GlobalSystemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_GlobalSystemSpaceRegion(From);
    return llvm.cast(GlobalSystemSpaceRegion.class, From.$star());
  }

  public static GlobalSystemSpaceRegion cast_or_null_GlobalSystemSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalSystemSpaceRegion(From);
  }

  public static GlobalSystemSpaceRegion dyn_cast_GlobalSystemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static GlobalSystemSpaceRegion dyn_cast_or_null_GlobalSystemSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalSystemSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalSystemSpaceRegion.class, From.$deref());
  }

  public static GlobalSystemSpaceRegion cast_GlobalSystemSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_GlobalSystemSpaceRegion(From);
    return llvm.cast(GlobalSystemSpaceRegion.class, From.$deref());
  }

  public static GlobalSystemSpaceRegion cast_or_null_GlobalSystemSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalSystemSpaceRegion(From);
  }

  public static GlobalSystemSpaceRegion dyn_cast_GlobalSystemSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static GlobalSystemSpaceRegion dyn_cast_or_null_GlobalSystemSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalSystemSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(GlobalSystemSpaceRegion.class, From);
  }

  public static GlobalSystemSpaceRegion cast_GlobalSystemSpaceRegion(MemRegion/*P*/ From) {
    assert isa_GlobalSystemSpaceRegion(From);
    return llvm.cast(GlobalSystemSpaceRegion.class, From);
  }

  public static GlobalSystemSpaceRegion cast_or_null_GlobalSystemSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_GlobalSystemSpaceRegion(From);
  }

  public static GlobalSystemSpaceRegion dyn_cast_GlobalSystemSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static GlobalSystemSpaceRegion dyn_cast_or_null_GlobalSystemSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_GlobalSystemSpaceRegion(From) ? cast_GlobalSystemSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(GlobalsSpaceRegion.class, From);
  }

  public static GlobalsSpaceRegion cast_GlobalsSpaceRegion(MemRegion/*P*/ From) {
    assert isa_GlobalsSpaceRegion(From);
    return llvm.cast(GlobalsSpaceRegion.class, From);
  }

  public static GlobalsSpaceRegion cast_or_null_GlobalsSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_GlobalsSpaceRegion(From);
  }

  public static GlobalsSpaceRegion dyn_cast_GlobalsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static GlobalsSpaceRegion dyn_cast_or_null_GlobalsSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalsSpaceRegion.class, From.$deref());
  }

  public static GlobalsSpaceRegion cast_GlobalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_GlobalsSpaceRegion(From);
    return llvm.cast(GlobalsSpaceRegion.class, From.$deref());
  }

  public static GlobalsSpaceRegion cast_or_null_GlobalsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalsSpaceRegion(From);
  }

  public static GlobalsSpaceRegion dyn_cast_GlobalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static GlobalsSpaceRegion dyn_cast_or_null_GlobalsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static boolean isa_GlobalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalsSpaceRegion.class, From.$star());
  }

  public static GlobalsSpaceRegion cast_GlobalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_GlobalsSpaceRegion(From);
    return llvm.cast(GlobalsSpaceRegion.class, From.$star());
  }

  public static GlobalsSpaceRegion cast_or_null_GlobalsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalsSpaceRegion(From);
  }

  public static GlobalsSpaceRegion dyn_cast_GlobalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static GlobalsSpaceRegion dyn_cast_or_null_GlobalsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalsSpaceRegion(From) ? cast_GlobalsSpaceRegion(From) : null;
  }

  public static boolean isa_HeapSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(HeapSpaceRegion.class, From.$star());
  }

  public static HeapSpaceRegion cast_HeapSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_HeapSpaceRegion(From);
    return llvm.cast(HeapSpaceRegion.class, From.$star());
  }

  public static HeapSpaceRegion cast_or_null_HeapSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_HeapSpaceRegion(From);
  }

  public static HeapSpaceRegion dyn_cast_HeapSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static HeapSpaceRegion dyn_cast_or_null_HeapSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static boolean isa_HeapSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(HeapSpaceRegion.class, From);
  }

  public static HeapSpaceRegion cast_HeapSpaceRegion(MemRegion/*P*/ From) {
    assert isa_HeapSpaceRegion(From);
    return llvm.cast(HeapSpaceRegion.class, From);
  }

  public static HeapSpaceRegion cast_or_null_HeapSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_HeapSpaceRegion(From);
  }

  public static HeapSpaceRegion dyn_cast_HeapSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static HeapSpaceRegion dyn_cast_or_null_HeapSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static boolean isa_HeapSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(HeapSpaceRegion.class, From.$deref());
  }

  public static HeapSpaceRegion cast_HeapSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_HeapSpaceRegion(From);
    return llvm.cast(HeapSpaceRegion.class, From.$deref());
  }

  public static HeapSpaceRegion cast_or_null_HeapSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_HeapSpaceRegion(From);
  }

  public static HeapSpaceRegion dyn_cast_HeapSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static HeapSpaceRegion dyn_cast_or_null_HeapSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_HeapSpaceRegion(From) ? cast_HeapSpaceRegion(From) : null;
  }

  public static boolean isa_IntSymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntSymExpr.class, From.$deref());
  }

  public static IntSymExpr cast_IntSymExpr(type$ref<?>/*P*/ From) {
    assert isa_IntSymExpr(From);
    return llvm.cast(IntSymExpr.class, From.$deref());
  }

  public static IntSymExpr cast_or_null_IntSymExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntSymExpr(From);
  }

  public static IntSymExpr dyn_cast_IntSymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static IntSymExpr dyn_cast_or_null_IntSymExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static boolean isa_IntSymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(IntSymExpr.class, From);
  }

  public static IntSymExpr cast_IntSymExpr(SymExpr/*P*/ From) {
    assert isa_IntSymExpr(From);
    return llvm.cast(IntSymExpr.class, From);
  }

  public static IntSymExpr cast_or_null_IntSymExpr(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_IntSymExpr(From);
  }

  public static IntSymExpr dyn_cast_IntSymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static IntSymExpr dyn_cast_or_null_IntSymExpr(SymExpr/*P*/ From) {
    return (From != null) && isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static boolean isa_IntSymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntSymExpr.class, From.$star());
  }

  public static IntSymExpr cast_IntSymExpr(type$ptr<?>/*P*/ From) {
    assert isa_IntSymExpr(From);
    return llvm.cast(IntSymExpr.class, From.$star());
  }

  public static IntSymExpr cast_or_null_IntSymExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntSymExpr(From);
  }

  public static IntSymExpr dyn_cast_IntSymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static IntSymExpr dyn_cast_or_null_IntSymExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntSymExpr(From) ? cast_IntSymExpr(From) : null;
  }

  public static boolean isa_MemRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemRegion.class, From.$deref());
  }

  public static MemRegion cast_MemRegion(type$ref<?>/*P*/ From) {
    assert isa_MemRegion(From);
    return llvm.cast(MemRegion.class, From.$deref());
  }

  public static MemRegion cast_or_null_MemRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemRegion(From);
  }

  public static MemRegion dyn_cast_MemRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static MemRegion dyn_cast_or_null_MemRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static boolean isa_MemRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(MemRegion.class, From);
  }

  public static MemRegion cast_MemRegion(MemRegion/*P*/ From) {
    assert isa_MemRegion(From);
    return llvm.cast(MemRegion.class, From);
  }

  public static MemRegion cast_or_null_MemRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_MemRegion(From);
  }

  public static MemRegion dyn_cast_MemRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static MemRegion dyn_cast_or_null_MemRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static boolean isa_MemRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemRegion.class, From.$star());
  }

  public static MemRegion cast_MemRegion(type$ptr<?>/*P*/ From) {
    assert isa_MemRegion(From);
    return llvm.cast(MemRegion.class, From.$star());
  }

  public static MemRegion cast_or_null_MemRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemRegion(From);
  }

  public static MemRegion dyn_cast_MemRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static MemRegion dyn_cast_or_null_MemRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemRegion(From) ? cast_MemRegion(From) : null;
  }

  public static boolean isa_MemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemSpaceRegion.class, From.$star());
  }

  public static MemSpaceRegion cast_MemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_MemSpaceRegion(From);
    return llvm.cast(MemSpaceRegion.class, From.$star());
  }

  public static MemSpaceRegion cast_or_null_MemSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemSpaceRegion(From);
  }

  public static MemSpaceRegion dyn_cast_MemSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static MemSpaceRegion dyn_cast_or_null_MemSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static boolean isa_MemSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(MemSpaceRegion.class, From);
  }

  public static MemSpaceRegion cast_MemSpaceRegion(MemRegion/*P*/ From) {
    assert isa_MemSpaceRegion(From);
    return llvm.cast(MemSpaceRegion.class, From);
  }

  public static MemSpaceRegion cast_or_null_MemSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_MemSpaceRegion(From);
  }

  public static MemSpaceRegion dyn_cast_MemSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static MemSpaceRegion dyn_cast_or_null_MemSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static boolean isa_MemSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemSpaceRegion.class, From.$deref());
  }

  public static MemSpaceRegion cast_MemSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_MemSpaceRegion(From);
    return llvm.cast(MemSpaceRegion.class, From.$deref());
  }

  public static MemSpaceRegion cast_or_null_MemSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemSpaceRegion(From);
  }

  public static MemSpaceRegion dyn_cast_MemSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static MemSpaceRegion dyn_cast_or_null_MemSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemSpaceRegion(From) ? cast_MemSpaceRegion(From) : null;
  }

  public static boolean isa_NonStaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NonStaticGlobalSpaceRegion.class, From.$deref());
  }

  public static NonStaticGlobalSpaceRegion cast_NonStaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_NonStaticGlobalSpaceRegion(From);
    return llvm.cast(NonStaticGlobalSpaceRegion.class, From.$deref());
  }

  public static NonStaticGlobalSpaceRegion cast_or_null_NonStaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NonStaticGlobalSpaceRegion(From);
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_NonStaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_or_null_NonStaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_NonStaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(NonStaticGlobalSpaceRegion.class, From);
  }

  public static NonStaticGlobalSpaceRegion cast_NonStaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert isa_NonStaticGlobalSpaceRegion(From);
    return llvm.cast(NonStaticGlobalSpaceRegion.class, From);
  }

  public static NonStaticGlobalSpaceRegion cast_or_null_NonStaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_NonStaticGlobalSpaceRegion(From);
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_NonStaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_or_null_NonStaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_NonStaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NonStaticGlobalSpaceRegion.class, From.$star());
  }

  public static NonStaticGlobalSpaceRegion cast_NonStaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_NonStaticGlobalSpaceRegion(From);
    return llvm.cast(NonStaticGlobalSpaceRegion.class, From.$star());
  }

  public static NonStaticGlobalSpaceRegion cast_or_null_NonStaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NonStaticGlobalSpaceRegion(From);
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_NonStaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static NonStaticGlobalSpaceRegion dyn_cast_or_null_NonStaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NonStaticGlobalSpaceRegion(From) ? cast_NonStaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_ObjCIvarRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIvarRegion.class, From.$deref());
  }

  public static ObjCIvarRegion cast_ObjCIvarRegion(type$ref<?>/*P*/ From) {
    assert isa_ObjCIvarRegion(From);
    return llvm.cast(ObjCIvarRegion.class, From.$deref());
  }

  public static ObjCIvarRegion cast_or_null_ObjCIvarRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIvarRegion(From);
  }

  public static ObjCIvarRegion dyn_cast_ObjCIvarRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static ObjCIvarRegion dyn_cast_or_null_ObjCIvarRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static boolean isa_ObjCIvarRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIvarRegion.class, From.$star());
  }

  public static ObjCIvarRegion cast_ObjCIvarRegion(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIvarRegion(From);
    return llvm.cast(ObjCIvarRegion.class, From.$star());
  }

  public static ObjCIvarRegion cast_or_null_ObjCIvarRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIvarRegion(From);
  }

  public static ObjCIvarRegion dyn_cast_ObjCIvarRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static ObjCIvarRegion dyn_cast_or_null_ObjCIvarRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static boolean isa_ObjCIvarRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(ObjCIvarRegion.class, From);
  }

  public static ObjCIvarRegion cast_ObjCIvarRegion(MemRegion/*P*/ From) {
    assert isa_ObjCIvarRegion(From);
    return llvm.cast(ObjCIvarRegion.class, From);
  }

  public static ObjCIvarRegion cast_or_null_ObjCIvarRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_ObjCIvarRegion(From);
  }

  public static ObjCIvarRegion dyn_cast_ObjCIvarRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static ObjCIvarRegion dyn_cast_or_null_ObjCIvarRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_ObjCIvarRegion(From) ? cast_ObjCIvarRegion(From) : null;
  }

  public static boolean isa_ObjCMethodCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCMethodCall.class, From.$deref());
  }

  public static ObjCMethodCall cast_ObjCMethodCall(type$ref<?>/*P*/ From) {
    assert isa_ObjCMethodCall(From);
    return llvm.cast(ObjCMethodCall.class, From.$deref());
  }

  public static ObjCMethodCall cast_or_null_ObjCMethodCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCMethodCall(From);
  }

  public static ObjCMethodCall dyn_cast_ObjCMethodCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static ObjCMethodCall dyn_cast_or_null_ObjCMethodCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static boolean isa_ObjCMethodCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCMethodCall.class, From.$star());
  }

  public static ObjCMethodCall cast_ObjCMethodCall(type$ptr<?>/*P*/ From) {
    assert isa_ObjCMethodCall(From);
    return llvm.cast(ObjCMethodCall.class, From.$star());
  }

  public static ObjCMethodCall cast_or_null_ObjCMethodCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCMethodCall(From);
  }

  public static ObjCMethodCall dyn_cast_ObjCMethodCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static ObjCMethodCall dyn_cast_or_null_ObjCMethodCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static boolean isa_ObjCMethodCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(ObjCMethodCall.class, From);
  }

  public static ObjCMethodCall cast_ObjCMethodCall(CallEvent/*P*/ From) {
    assert isa_ObjCMethodCall(From);
    return llvm.cast(ObjCMethodCall.class, From);
  }

  public static ObjCMethodCall cast_or_null_ObjCMethodCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodCall(From);
  }

  public static ObjCMethodCall dyn_cast_ObjCMethodCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static ObjCMethodCall dyn_cast_or_null_ObjCMethodCall(CallEvent/*P*/ From) {
    return (From != null) && isa_ObjCMethodCall(From) ? cast_ObjCMethodCall(From) : null;
  }

  public static boolean isa_ObjCStringRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCStringRegion.class, From.$star());
  }

  public static ObjCStringRegion cast_ObjCStringRegion(type$ptr<?>/*P*/ From) {
    assert isa_ObjCStringRegion(From);
    return llvm.cast(ObjCStringRegion.class, From.$star());
  }

  public static ObjCStringRegion cast_or_null_ObjCStringRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCStringRegion(From);
  }

  public static ObjCStringRegion dyn_cast_ObjCStringRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static ObjCStringRegion dyn_cast_or_null_ObjCStringRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static boolean isa_ObjCStringRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(ObjCStringRegion.class, From);
  }

  public static ObjCStringRegion cast_ObjCStringRegion(MemRegion/*P*/ From) {
    assert isa_ObjCStringRegion(From);
    return llvm.cast(ObjCStringRegion.class, From);
  }

  public static ObjCStringRegion cast_or_null_ObjCStringRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_ObjCStringRegion(From);
  }

  public static ObjCStringRegion dyn_cast_ObjCStringRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static ObjCStringRegion dyn_cast_or_null_ObjCStringRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static boolean isa_ObjCStringRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCStringRegion.class, From.$deref());
  }

  public static ObjCStringRegion cast_ObjCStringRegion(type$ref<?>/*P*/ From) {
    assert isa_ObjCStringRegion(From);
    return llvm.cast(ObjCStringRegion.class, From.$deref());
  }

  public static ObjCStringRegion cast_or_null_ObjCStringRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCStringRegion(From);
  }

  public static ObjCStringRegion dyn_cast_ObjCStringRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static ObjCStringRegion dyn_cast_or_null_ObjCStringRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCStringRegion(From) ? cast_ObjCStringRegion(From) : null;
  }

  public static boolean isa_SimpleFunctionCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SimpleFunctionCall.class, From.$star());
  }

  public static SimpleFunctionCall cast_SimpleFunctionCall(type$ptr<?>/*P*/ From) {
    assert isa_SimpleFunctionCall(From);
    return llvm.cast(SimpleFunctionCall.class, From.$star());
  }

  public static SimpleFunctionCall cast_or_null_SimpleFunctionCall(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SimpleFunctionCall(From);
  }

  public static SimpleFunctionCall dyn_cast_SimpleFunctionCall(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static SimpleFunctionCall dyn_cast_or_null_SimpleFunctionCall(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static boolean isa_SimpleFunctionCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SimpleFunctionCall.class, From.$deref());
  }

  public static SimpleFunctionCall cast_SimpleFunctionCall(type$ref<?>/*P*/ From) {
    assert isa_SimpleFunctionCall(From);
    return llvm.cast(SimpleFunctionCall.class, From.$deref());
  }

  public static SimpleFunctionCall cast_or_null_SimpleFunctionCall(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SimpleFunctionCall(From);
  }

  public static SimpleFunctionCall dyn_cast_SimpleFunctionCall(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static SimpleFunctionCall dyn_cast_or_null_SimpleFunctionCall(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static boolean isa_SimpleFunctionCall(CallEvent/*P*/ From) {
    assert From != null;
    return llvm.isa(SimpleFunctionCall.class, From);
  }

  public static SimpleFunctionCall cast_SimpleFunctionCall(CallEvent/*P*/ From) {
    assert isa_SimpleFunctionCall(From);
    return llvm.cast(SimpleFunctionCall.class, From);
  }

  public static SimpleFunctionCall cast_or_null_SimpleFunctionCall(CallEvent/*P*/ From) {
    return (From == null) ? null : cast_SimpleFunctionCall(From);
  }

  public static SimpleFunctionCall dyn_cast_SimpleFunctionCall(CallEvent/*P*/ From) {
    assert From != null;
    return isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static SimpleFunctionCall dyn_cast_or_null_SimpleFunctionCall(CallEvent/*P*/ From) {
    return (From != null) && isa_SimpleFunctionCall(From) ? cast_SimpleFunctionCall(From) : null;
  }

  public static boolean isa_StackArgumentsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StackArgumentsSpaceRegion.class, From.$star());
  }

  public static StackArgumentsSpaceRegion cast_StackArgumentsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_StackArgumentsSpaceRegion(From);
    return llvm.cast(StackArgumentsSpaceRegion.class, From.$star());
  }

  public static StackArgumentsSpaceRegion cast_or_null_StackArgumentsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StackArgumentsSpaceRegion(From);
  }

  public static StackArgumentsSpaceRegion dyn_cast_StackArgumentsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static StackArgumentsSpaceRegion dyn_cast_or_null_StackArgumentsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static boolean isa_StackArgumentsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StackArgumentsSpaceRegion.class, From.$deref());
  }

  public static StackArgumentsSpaceRegion cast_StackArgumentsSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_StackArgumentsSpaceRegion(From);
    return llvm.cast(StackArgumentsSpaceRegion.class, From.$deref());
  }

  public static StackArgumentsSpaceRegion cast_or_null_StackArgumentsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StackArgumentsSpaceRegion(From);
  }

  public static StackArgumentsSpaceRegion dyn_cast_StackArgumentsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static StackArgumentsSpaceRegion dyn_cast_or_null_StackArgumentsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static boolean isa_StackArgumentsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(StackArgumentsSpaceRegion.class, From);
  }

  public static StackArgumentsSpaceRegion cast_StackArgumentsSpaceRegion(MemRegion/*P*/ From) {
    assert isa_StackArgumentsSpaceRegion(From);
    return llvm.cast(StackArgumentsSpaceRegion.class, From);
  }

  public static StackArgumentsSpaceRegion cast_or_null_StackArgumentsSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_StackArgumentsSpaceRegion(From);
  }

  public static StackArgumentsSpaceRegion dyn_cast_StackArgumentsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static StackArgumentsSpaceRegion dyn_cast_or_null_StackArgumentsSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_StackArgumentsSpaceRegion(From) ? cast_StackArgumentsSpaceRegion(From) : null;
  }

  public static boolean isa_StackLocalsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(StackLocalsSpaceRegion.class, From);
  }

  public static StackLocalsSpaceRegion cast_StackLocalsSpaceRegion(MemRegion/*P*/ From) {
    assert isa_StackLocalsSpaceRegion(From);
    return llvm.cast(StackLocalsSpaceRegion.class, From);
  }

  public static StackLocalsSpaceRegion cast_or_null_StackLocalsSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_StackLocalsSpaceRegion(From);
  }

  public static StackLocalsSpaceRegion dyn_cast_StackLocalsSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static StackLocalsSpaceRegion dyn_cast_or_null_StackLocalsSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static boolean isa_StackLocalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StackLocalsSpaceRegion.class, From.$star());
  }

  public static StackLocalsSpaceRegion cast_StackLocalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_StackLocalsSpaceRegion(From);
    return llvm.cast(StackLocalsSpaceRegion.class, From.$star());
  }

  public static StackLocalsSpaceRegion cast_or_null_StackLocalsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StackLocalsSpaceRegion(From);
  }

  public static StackLocalsSpaceRegion dyn_cast_StackLocalsSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static StackLocalsSpaceRegion dyn_cast_or_null_StackLocalsSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static boolean isa_StackLocalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StackLocalsSpaceRegion.class, From.$deref());
  }

  public static StackLocalsSpaceRegion cast_StackLocalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_StackLocalsSpaceRegion(From);
    return llvm.cast(StackLocalsSpaceRegion.class, From.$deref());
  }

  public static StackLocalsSpaceRegion cast_or_null_StackLocalsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StackLocalsSpaceRegion(From);
  }

  public static StackLocalsSpaceRegion dyn_cast_StackLocalsSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static StackLocalsSpaceRegion dyn_cast_or_null_StackLocalsSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StackLocalsSpaceRegion(From) ? cast_StackLocalsSpaceRegion(From) : null;
  }

  public static boolean isa_StackSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StackSpaceRegion.class, From.$star());
  }

  public static StackSpaceRegion cast_StackSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_StackSpaceRegion(From);
    return llvm.cast(StackSpaceRegion.class, From.$star());
  }

  public static StackSpaceRegion cast_or_null_StackSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StackSpaceRegion(From);
  }

  public static StackSpaceRegion dyn_cast_StackSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static StackSpaceRegion dyn_cast_or_null_StackSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static boolean isa_StackSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(StackSpaceRegion.class, From);
  }

  public static StackSpaceRegion cast_StackSpaceRegion(MemRegion/*P*/ From) {
    assert isa_StackSpaceRegion(From);
    return llvm.cast(StackSpaceRegion.class, From);
  }

  public static StackSpaceRegion cast_or_null_StackSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_StackSpaceRegion(From);
  }

  public static StackSpaceRegion dyn_cast_StackSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static StackSpaceRegion dyn_cast_or_null_StackSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static boolean isa_StackSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StackSpaceRegion.class, From.$deref());
  }

  public static StackSpaceRegion cast_StackSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_StackSpaceRegion(From);
    return llvm.cast(StackSpaceRegion.class, From.$deref());
  }

  public static StackSpaceRegion cast_or_null_StackSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StackSpaceRegion(From);
  }

  public static StackSpaceRegion dyn_cast_StackSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static StackSpaceRegion dyn_cast_or_null_StackSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StackSpaceRegion(From) ? cast_StackSpaceRegion(From) : null;
  }

  public static boolean isa_StaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(StaticGlobalSpaceRegion.class, From);
  }

  public static StaticGlobalSpaceRegion cast_StaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert isa_StaticGlobalSpaceRegion(From);
    return llvm.cast(StaticGlobalSpaceRegion.class, From);
  }

  public static StaticGlobalSpaceRegion cast_or_null_StaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_StaticGlobalSpaceRegion(From);
  }

  public static StaticGlobalSpaceRegion dyn_cast_StaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static StaticGlobalSpaceRegion dyn_cast_or_null_StaticGlobalSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_StaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StaticGlobalSpaceRegion.class, From.$star());
  }

  public static StaticGlobalSpaceRegion cast_StaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_StaticGlobalSpaceRegion(From);
    return llvm.cast(StaticGlobalSpaceRegion.class, From.$star());
  }

  public static StaticGlobalSpaceRegion cast_or_null_StaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StaticGlobalSpaceRegion(From);
  }

  public static StaticGlobalSpaceRegion dyn_cast_StaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static StaticGlobalSpaceRegion dyn_cast_or_null_StaticGlobalSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_StaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StaticGlobalSpaceRegion.class, From.$deref());
  }

  public static StaticGlobalSpaceRegion cast_StaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_StaticGlobalSpaceRegion(From);
    return llvm.cast(StaticGlobalSpaceRegion.class, From.$deref());
  }

  public static StaticGlobalSpaceRegion cast_or_null_StaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StaticGlobalSpaceRegion(From);
  }

  public static StaticGlobalSpaceRegion dyn_cast_StaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static StaticGlobalSpaceRegion dyn_cast_or_null_StaticGlobalSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StaticGlobalSpaceRegion(From) ? cast_StaticGlobalSpaceRegion(From) : null;
  }

  public static boolean isa_StringRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StringRegion.class, From.$star());
  }

  public static StringRegion cast_StringRegion(type$ptr<?>/*P*/ From) {
    assert isa_StringRegion(From);
    return llvm.cast(StringRegion.class, From.$star());
  }

  public static StringRegion cast_or_null_StringRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StringRegion(From);
  }

  public static StringRegion dyn_cast_StringRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static StringRegion dyn_cast_or_null_StringRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static boolean isa_StringRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(StringRegion.class, From);
  }

  public static StringRegion cast_StringRegion(MemRegion/*P*/ From) {
    assert isa_StringRegion(From);
    return llvm.cast(StringRegion.class, From);
  }

  public static StringRegion cast_or_null_StringRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_StringRegion(From);
  }

  public static StringRegion dyn_cast_StringRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static StringRegion dyn_cast_or_null_StringRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static boolean isa_StringRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StringRegion.class, From.$deref());
  }

  public static StringRegion cast_StringRegion(type$ref<?>/*P*/ From) {
    assert isa_StringRegion(From);
    return llvm.cast(StringRegion.class, From.$deref());
  }

  public static StringRegion cast_or_null_StringRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StringRegion(From);
  }

  public static StringRegion dyn_cast_StringRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static StringRegion dyn_cast_or_null_StringRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StringRegion(From) ? cast_StringRegion(From) : null;
  }

  public static boolean isa_SubRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubRegion.class, From.$deref());
  }

  public static SubRegion cast_SubRegion(type$ref<?>/*P*/ From) {
    assert isa_SubRegion(From);
    return llvm.cast(SubRegion.class, From.$deref());
  }

  public static SubRegion cast_or_null_SubRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubRegion(From);
  }

  public static SubRegion dyn_cast_SubRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static SubRegion dyn_cast_or_null_SubRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static boolean isa_SubRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(SubRegion.class, From);
  }

  public static SubRegion cast_SubRegion(MemRegion/*P*/ From) {
    assert isa_SubRegion(From);
    return llvm.cast(SubRegion.class, From);
  }

  public static SubRegion cast_or_null_SubRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_SubRegion(From);
  }

  public static SubRegion dyn_cast_SubRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static SubRegion dyn_cast_or_null_SubRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static boolean isa_SubRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubRegion.class, From.$star());
  }

  public static SubRegion cast_SubRegion(type$ptr<?>/*P*/ From) {
    assert isa_SubRegion(From);
    return llvm.cast(SubRegion.class, From.$star());
  }

  public static SubRegion cast_or_null_SubRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubRegion(From);
  }

  public static SubRegion dyn_cast_SubRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static SubRegion dyn_cast_or_null_SubRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubRegion(From) ? cast_SubRegion(From) : null;
  }

  public static boolean isa_SymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymExpr.class, From.$star());
  }

  public static SymExpr cast_SymExpr(type$ptr<?>/*P*/ From) {
    assert isa_SymExpr(From);
    return llvm.cast(SymExpr.class, From.$star());
  }

  public static SymExpr cast_or_null_SymExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymExpr(From);
  }

  public static SymExpr dyn_cast_SymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static SymExpr dyn_cast_or_null_SymExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static boolean isa_SymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymExpr.class, From);
  }

  public static SymExpr cast_SymExpr(SymExpr/*P*/ From) {
    assert isa_SymExpr(From);
    return llvm.cast(SymExpr.class, From);
  }

  public static SymExpr cast_or_null_SymExpr(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymExpr(From);
  }

  public static SymExpr dyn_cast_SymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static SymExpr dyn_cast_or_null_SymExpr(SymExpr/*P*/ From) {
    return (From != null) && isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static boolean isa_SymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymExpr.class, From.$deref());
  }

  public static SymExpr cast_SymExpr(type$ref<?>/*P*/ From) {
    assert isa_SymExpr(From);
    return llvm.cast(SymExpr.class, From.$deref());
  }

  public static SymExpr cast_or_null_SymExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymExpr(From);
  }

  public static SymExpr dyn_cast_SymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static SymExpr dyn_cast_or_null_SymExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymExpr(From) ? cast_SymExpr(From) : null;
  }

  public static boolean isa_SymIntExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymIntExpr.class, From.$star());
  }

  public static SymIntExpr cast_SymIntExpr(type$ptr<?>/*P*/ From) {
    assert isa_SymIntExpr(From);
    return llvm.cast(SymIntExpr.class, From.$star());
  }

  public static SymIntExpr cast_or_null_SymIntExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymIntExpr(From);
  }

  public static SymIntExpr dyn_cast_SymIntExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static SymIntExpr dyn_cast_or_null_SymIntExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static boolean isa_SymIntExpr(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymIntExpr.class, From);
  }

  public static SymIntExpr cast_SymIntExpr(SymExpr/*P*/ From) {
    assert isa_SymIntExpr(From);
    return llvm.cast(SymIntExpr.class, From);
  }

  public static SymIntExpr cast_or_null_SymIntExpr(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymIntExpr(From);
  }

  public static SymIntExpr dyn_cast_SymIntExpr(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static SymIntExpr dyn_cast_or_null_SymIntExpr(SymExpr/*P*/ From) {
    return (From != null) && isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static boolean isa_SymIntExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymIntExpr.class, From.$deref());
  }

  public static SymIntExpr cast_SymIntExpr(type$ref<?>/*P*/ From) {
    assert isa_SymIntExpr(From);
    return llvm.cast(SymIntExpr.class, From.$deref());
  }

  public static SymIntExpr cast_or_null_SymIntExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymIntExpr(From);
  }

  public static SymIntExpr dyn_cast_SymIntExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static SymIntExpr dyn_cast_or_null_SymIntExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymIntExpr(From) ? cast_SymIntExpr(From) : null;
  }

  public static boolean isa_SymSymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymSymExpr.class, From.$star());
  }

  public static SymSymExpr cast_SymSymExpr(type$ptr<?>/*P*/ From) {
    assert isa_SymSymExpr(From);
    return llvm.cast(SymSymExpr.class, From.$star());
  }

  public static SymSymExpr cast_or_null_SymSymExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymSymExpr(From);
  }

  public static SymSymExpr dyn_cast_SymSymExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static SymSymExpr dyn_cast_or_null_SymSymExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static boolean isa_SymSymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymSymExpr.class, From);
  }

  public static SymSymExpr cast_SymSymExpr(SymExpr/*P*/ From) {
    assert isa_SymSymExpr(From);
    return llvm.cast(SymSymExpr.class, From);
  }

  public static SymSymExpr cast_or_null_SymSymExpr(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymSymExpr(From);
  }

  public static SymSymExpr dyn_cast_SymSymExpr(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static SymSymExpr dyn_cast_or_null_SymSymExpr(SymExpr/*P*/ From) {
    return (From != null) && isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static boolean isa_SymSymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymSymExpr.class, From.$deref());
  }

  public static SymSymExpr cast_SymSymExpr(type$ref<?>/*P*/ From) {
    assert isa_SymSymExpr(From);
    return llvm.cast(SymSymExpr.class, From.$deref());
  }

  public static SymSymExpr cast_or_null_SymSymExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymSymExpr(From);
  }

  public static SymSymExpr dyn_cast_SymSymExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static SymSymExpr dyn_cast_or_null_SymSymExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymSymExpr(From) ? cast_SymSymExpr(From) : null;
  }

  public static boolean isa_SymbolCast(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolCast.class, From.$deref());
  }

  public static SymbolCast cast_SymbolCast(type$ref<?>/*P*/ From) {
    assert isa_SymbolCast(From);
    return llvm.cast(SymbolCast.class, From.$deref());
  }

  public static SymbolCast cast_or_null_SymbolCast(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolCast(From);
  }

  public static SymbolCast dyn_cast_SymbolCast(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static SymbolCast dyn_cast_or_null_SymbolCast(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static boolean isa_SymbolCast(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolCast.class, From);
  }

  public static SymbolCast cast_SymbolCast(SymExpr/*P*/ From) {
    assert isa_SymbolCast(From);
    return llvm.cast(SymbolCast.class, From);
  }

  public static SymbolCast cast_or_null_SymbolCast(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolCast(From);
  }

  public static SymbolCast dyn_cast_SymbolCast(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static SymbolCast dyn_cast_or_null_SymbolCast(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static boolean isa_SymbolCast(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolCast.class, From.$star());
  }

  public static SymbolCast cast_SymbolCast(type$ptr<?>/*P*/ From) {
    assert isa_SymbolCast(From);
    return llvm.cast(SymbolCast.class, From.$star());
  }

  public static SymbolCast cast_or_null_SymbolCast(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolCast(From);
  }

  public static SymbolCast dyn_cast_SymbolCast(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static SymbolCast dyn_cast_or_null_SymbolCast(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolCast(From) ? cast_SymbolCast(From) : null;
  }

  public static boolean isa_SymbolConjured(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolConjured.class, From.$star());
  }

  public static SymbolConjured cast_SymbolConjured(type$ptr<?>/*P*/ From) {
    assert isa_SymbolConjured(From);
    return llvm.cast(SymbolConjured.class, From.$star());
  }

  public static SymbolConjured cast_or_null_SymbolConjured(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolConjured(From);
  }

  public static SymbolConjured dyn_cast_SymbolConjured(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static SymbolConjured dyn_cast_or_null_SymbolConjured(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static boolean isa_SymbolConjured(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolConjured.class, From);
  }

  public static SymbolConjured cast_SymbolConjured(SymExpr/*P*/ From) {
    assert isa_SymbolConjured(From);
    return llvm.cast(SymbolConjured.class, From);
  }

  public static SymbolConjured cast_or_null_SymbolConjured(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolConjured(From);
  }

  public static SymbolConjured dyn_cast_SymbolConjured(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static SymbolConjured dyn_cast_or_null_SymbolConjured(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static boolean isa_SymbolConjured(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolConjured.class, From.$deref());
  }

  public static SymbolConjured cast_SymbolConjured(type$ref<?>/*P*/ From) {
    assert isa_SymbolConjured(From);
    return llvm.cast(SymbolConjured.class, From.$deref());
  }

  public static SymbolConjured cast_or_null_SymbolConjured(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolConjured(From);
  }

  public static SymbolConjured dyn_cast_SymbolConjured(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static SymbolConjured dyn_cast_or_null_SymbolConjured(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolConjured(From) ? cast_SymbolConjured(From) : null;
  }

  public static boolean isa_SymbolData(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolData.class, From.$star());
  }

  public static SymbolData cast_SymbolData(type$ptr<?>/*P*/ From) {
    assert isa_SymbolData(From);
    return llvm.cast(SymbolData.class, From.$star());
  }

  public static SymbolData cast_or_null_SymbolData(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolData(From);
  }

  public static SymbolData dyn_cast_SymbolData(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static SymbolData dyn_cast_or_null_SymbolData(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static boolean isa_SymbolData(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolData.class, From);
  }

  public static SymbolData cast_SymbolData(SymExpr/*P*/ From) {
    assert isa_SymbolData(From);
    return llvm.cast(SymbolData.class, From);
  }

  public static SymbolData cast_or_null_SymbolData(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolData(From);
  }

  public static SymbolData dyn_cast_SymbolData(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static SymbolData dyn_cast_or_null_SymbolData(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static boolean isa_SymbolData(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolData.class, From.$deref());
  }

  public static SymbolData cast_SymbolData(type$ref<?>/*P*/ From) {
    assert isa_SymbolData(From);
    return llvm.cast(SymbolData.class, From.$deref());
  }

  public static SymbolData cast_or_null_SymbolData(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolData(From);
  }

  public static SymbolData dyn_cast_SymbolData(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static SymbolData dyn_cast_or_null_SymbolData(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolData(From) ? cast_SymbolData(From) : null;
  }

  public static boolean isa_SymbolDerived(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolDerived.class, From.$deref());
  }

  public static SymbolDerived cast_SymbolDerived(type$ref<?>/*P*/ From) {
    assert isa_SymbolDerived(From);
    return llvm.cast(SymbolDerived.class, From.$deref());
  }

  public static SymbolDerived cast_or_null_SymbolDerived(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolDerived(From);
  }

  public static SymbolDerived dyn_cast_SymbolDerived(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static SymbolDerived dyn_cast_or_null_SymbolDerived(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static boolean isa_SymbolDerived(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolDerived.class, From.$star());
  }

  public static SymbolDerived cast_SymbolDerived(type$ptr<?>/*P*/ From) {
    assert isa_SymbolDerived(From);
    return llvm.cast(SymbolDerived.class, From.$star());
  }

  public static SymbolDerived cast_or_null_SymbolDerived(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolDerived(From);
  }

  public static SymbolDerived dyn_cast_SymbolDerived(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static SymbolDerived dyn_cast_or_null_SymbolDerived(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static boolean isa_SymbolDerived(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolDerived.class, From);
  }

  public static SymbolDerived cast_SymbolDerived(SymExpr/*P*/ From) {
    assert isa_SymbolDerived(From);
    return llvm.cast(SymbolDerived.class, From);
  }

  public static SymbolDerived cast_or_null_SymbolDerived(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolDerived(From);
  }

  public static SymbolDerived dyn_cast_SymbolDerived(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static SymbolDerived dyn_cast_or_null_SymbolDerived(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolDerived(From) ? cast_SymbolDerived(From) : null;
  }

  public static boolean isa_SymbolExtent(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolExtent.class, From.$deref());
  }

  public static SymbolExtent cast_SymbolExtent(type$ref<?>/*P*/ From) {
    assert isa_SymbolExtent(From);
    return llvm.cast(SymbolExtent.class, From.$deref());
  }

  public static SymbolExtent cast_or_null_SymbolExtent(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolExtent(From);
  }

  public static SymbolExtent dyn_cast_SymbolExtent(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static SymbolExtent dyn_cast_or_null_SymbolExtent(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static boolean isa_SymbolExtent(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolExtent.class, From);
  }

  public static SymbolExtent cast_SymbolExtent(SymExpr/*P*/ From) {
    assert isa_SymbolExtent(From);
    return llvm.cast(SymbolExtent.class, From);
  }

  public static SymbolExtent cast_or_null_SymbolExtent(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolExtent(From);
  }

  public static SymbolExtent dyn_cast_SymbolExtent(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static SymbolExtent dyn_cast_or_null_SymbolExtent(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static boolean isa_SymbolExtent(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolExtent.class, From.$star());
  }

  public static SymbolExtent cast_SymbolExtent(type$ptr<?>/*P*/ From) {
    assert isa_SymbolExtent(From);
    return llvm.cast(SymbolExtent.class, From.$star());
  }

  public static SymbolExtent cast_or_null_SymbolExtent(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolExtent(From);
  }

  public static SymbolExtent dyn_cast_SymbolExtent(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static SymbolExtent dyn_cast_or_null_SymbolExtent(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolExtent(From) ? cast_SymbolExtent(From) : null;
  }

  public static boolean isa_SymbolMetadata(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolMetadata.class, From);
  }

  public static SymbolMetadata cast_SymbolMetadata(SymExpr/*P*/ From) {
    assert isa_SymbolMetadata(From);
    return llvm.cast(SymbolMetadata.class, From);
  }

  public static SymbolMetadata cast_or_null_SymbolMetadata(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolMetadata(From);
  }

  public static SymbolMetadata dyn_cast_SymbolMetadata(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static SymbolMetadata dyn_cast_or_null_SymbolMetadata(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static boolean isa_SymbolMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolMetadata.class, From.$star());
  }

  public static SymbolMetadata cast_SymbolMetadata(type$ptr<?>/*P*/ From) {
    assert isa_SymbolMetadata(From);
    return llvm.cast(SymbolMetadata.class, From.$star());
  }

  public static SymbolMetadata cast_or_null_SymbolMetadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolMetadata(From);
  }

  public static SymbolMetadata dyn_cast_SymbolMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static SymbolMetadata dyn_cast_or_null_SymbolMetadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static boolean isa_SymbolMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolMetadata.class, From.$deref());
  }

  public static SymbolMetadata cast_SymbolMetadata(type$ref<?>/*P*/ From) {
    assert isa_SymbolMetadata(From);
    return llvm.cast(SymbolMetadata.class, From.$deref());
  }

  public static SymbolMetadata cast_or_null_SymbolMetadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolMetadata(From);
  }

  public static SymbolMetadata dyn_cast_SymbolMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static SymbolMetadata dyn_cast_or_null_SymbolMetadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolMetadata(From) ? cast_SymbolMetadata(From) : null;
  }

  public static boolean isa_SymbolRegionValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolRegionValue.class, From.$star());
  }

  public static SymbolRegionValue cast_SymbolRegionValue(type$ptr<?>/*P*/ From) {
    assert isa_SymbolRegionValue(From);
    return llvm.cast(SymbolRegionValue.class, From.$star());
  }

  public static SymbolRegionValue cast_or_null_SymbolRegionValue(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolRegionValue(From);
  }

  public static SymbolRegionValue dyn_cast_SymbolRegionValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static SymbolRegionValue dyn_cast_or_null_SymbolRegionValue(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static boolean isa_SymbolRegionValue(SymExpr/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolRegionValue.class, From);
  }

  public static SymbolRegionValue cast_SymbolRegionValue(SymExpr/*P*/ From) {
    assert isa_SymbolRegionValue(From);
    return llvm.cast(SymbolRegionValue.class, From);
  }

  public static SymbolRegionValue cast_or_null_SymbolRegionValue(SymExpr/*P*/ From) {
    return (From == null) ? null : cast_SymbolRegionValue(From);
  }

  public static SymbolRegionValue dyn_cast_SymbolRegionValue(SymExpr/*P*/ From) {
    assert From != null;
    return isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static SymbolRegionValue dyn_cast_or_null_SymbolRegionValue(SymExpr/*P*/ From) {
    return (From != null) && isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static boolean isa_SymbolRegionValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolRegionValue.class, From.$deref());
  }

  public static SymbolRegionValue cast_SymbolRegionValue(type$ref<?>/*P*/ From) {
    assert isa_SymbolRegionValue(From);
    return llvm.cast(SymbolRegionValue.class, From.$deref());
  }

  public static SymbolRegionValue cast_or_null_SymbolRegionValue(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolRegionValue(From);
  }

  public static SymbolRegionValue dyn_cast_SymbolRegionValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static SymbolRegionValue dyn_cast_or_null_SymbolRegionValue(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolRegionValue(From) ? cast_SymbolRegionValue(From) : null;
  }

  public static boolean isa_SymbolicRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolicRegion.class, From.$star());
  }

  public static SymbolicRegion cast_SymbolicRegion(type$ptr<?>/*P*/ From) {
    assert isa_SymbolicRegion(From);
    return llvm.cast(SymbolicRegion.class, From.$star());
  }

  public static SymbolicRegion cast_or_null_SymbolicRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolicRegion(From);
  }

  public static SymbolicRegion dyn_cast_SymbolicRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static SymbolicRegion dyn_cast_or_null_SymbolicRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static boolean isa_SymbolicRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolicRegion.class, From);
  }

  public static SymbolicRegion cast_SymbolicRegion(MemRegion/*P*/ From) {
    assert isa_SymbolicRegion(From);
    return llvm.cast(SymbolicRegion.class, From);
  }

  public static SymbolicRegion cast_or_null_SymbolicRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_SymbolicRegion(From);
  }

  public static SymbolicRegion dyn_cast_SymbolicRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static SymbolicRegion dyn_cast_or_null_SymbolicRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static boolean isa_SymbolicRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolicRegion.class, From.$deref());
  }

  public static SymbolicRegion cast_SymbolicRegion(type$ref<?>/*P*/ From) {
    assert isa_SymbolicRegion(From);
    return llvm.cast(SymbolicRegion.class, From.$deref());
  }

  public static SymbolicRegion cast_or_null_SymbolicRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolicRegion(From);
  }

  public static SymbolicRegion dyn_cast_SymbolicRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static SymbolicRegion dyn_cast_or_null_SymbolicRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolicRegion(From) ? cast_SymbolicRegion(From) : null;
  }

  public static boolean isa_TypedRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(TypedRegion.class, From);
  }

  public static TypedRegion cast_TypedRegion(MemRegion/*P*/ From) {
    assert isa_TypedRegion(From);
    return llvm.cast(TypedRegion.class, From);
  }

  public static TypedRegion cast_or_null_TypedRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_TypedRegion(From);
  }

  public static TypedRegion dyn_cast_TypedRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static TypedRegion dyn_cast_or_null_TypedRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static boolean isa_TypedRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypedRegion.class, From.$deref());
  }

  public static TypedRegion cast_TypedRegion(type$ref<?>/*P*/ From) {
    assert isa_TypedRegion(From);
    return llvm.cast(TypedRegion.class, From.$deref());
  }

  public static TypedRegion cast_or_null_TypedRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypedRegion(From);
  }

  public static TypedRegion dyn_cast_TypedRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static TypedRegion dyn_cast_or_null_TypedRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static boolean isa_TypedRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypedRegion.class, From.$star());
  }

  public static TypedRegion cast_TypedRegion(type$ptr<?>/*P*/ From) {
    assert isa_TypedRegion(From);
    return llvm.cast(TypedRegion.class, From.$star());
  }

  public static TypedRegion cast_or_null_TypedRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypedRegion(From);
  }

  public static TypedRegion dyn_cast_TypedRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static TypedRegion dyn_cast_or_null_TypedRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypedRegion(From) ? cast_TypedRegion(From) : null;
  }

  public static boolean isa_TypedValueRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypedValueRegion.class, From.$deref());
  }

  public static TypedValueRegion cast_TypedValueRegion(type$ref<?>/*P*/ From) {
    assert isa_TypedValueRegion(From);
    return llvm.cast(TypedValueRegion.class, From.$deref());
  }

  public static TypedValueRegion cast_or_null_TypedValueRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypedValueRegion(From);
  }

  public static TypedValueRegion dyn_cast_TypedValueRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static TypedValueRegion dyn_cast_or_null_TypedValueRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static boolean isa_TypedValueRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(TypedValueRegion.class, From);
  }

  public static TypedValueRegion cast_TypedValueRegion(MemRegion/*P*/ From) {
    assert isa_TypedValueRegion(From);
    return llvm.cast(TypedValueRegion.class, From);
  }

  public static TypedValueRegion cast_or_null_TypedValueRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_TypedValueRegion(From);
  }

  public static TypedValueRegion dyn_cast_TypedValueRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static TypedValueRegion dyn_cast_or_null_TypedValueRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static boolean isa_TypedValueRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypedValueRegion.class, From.$star());
  }

  public static TypedValueRegion cast_TypedValueRegion(type$ptr<?>/*P*/ From) {
    assert isa_TypedValueRegion(From);
    return llvm.cast(TypedValueRegion.class, From.$star());
  }

  public static TypedValueRegion cast_or_null_TypedValueRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypedValueRegion(From);
  }

  public static TypedValueRegion dyn_cast_TypedValueRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static TypedValueRegion dyn_cast_or_null_TypedValueRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypedValueRegion(From) ? cast_TypedValueRegion(From) : null;
  }

  public static boolean isa_UnknownSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnknownSpaceRegion.class, From.$deref());
  }

  public static UnknownSpaceRegion cast_UnknownSpaceRegion(type$ref<?>/*P*/ From) {
    assert isa_UnknownSpaceRegion(From);
    return llvm.cast(UnknownSpaceRegion.class, From.$deref());
  }

  public static UnknownSpaceRegion cast_or_null_UnknownSpaceRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnknownSpaceRegion(From);
  }

  public static UnknownSpaceRegion dyn_cast_UnknownSpaceRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static UnknownSpaceRegion dyn_cast_or_null_UnknownSpaceRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static boolean isa_UnknownSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnknownSpaceRegion.class, From.$star());
  }

  public static UnknownSpaceRegion cast_UnknownSpaceRegion(type$ptr<?>/*P*/ From) {
    assert isa_UnknownSpaceRegion(From);
    return llvm.cast(UnknownSpaceRegion.class, From.$star());
  }

  public static UnknownSpaceRegion cast_or_null_UnknownSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnknownSpaceRegion(From);
  }

  public static UnknownSpaceRegion dyn_cast_UnknownSpaceRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static UnknownSpaceRegion dyn_cast_or_null_UnknownSpaceRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static boolean isa_UnknownSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(UnknownSpaceRegion.class, From);
  }

  public static UnknownSpaceRegion cast_UnknownSpaceRegion(MemRegion/*P*/ From) {
    assert isa_UnknownSpaceRegion(From);
    return llvm.cast(UnknownSpaceRegion.class, From);
  }

  public static UnknownSpaceRegion cast_or_null_UnknownSpaceRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_UnknownSpaceRegion(From);
  }

  public static UnknownSpaceRegion dyn_cast_UnknownSpaceRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static UnknownSpaceRegion dyn_cast_or_null_UnknownSpaceRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_UnknownSpaceRegion(From) ? cast_UnknownSpaceRegion(From) : null;
  }

  public static boolean isa_VarRegion(MemRegion/*P*/ From) {
    assert From != null;
    return llvm.isa(VarRegion.class, From);
  }

  public static VarRegion cast_VarRegion(MemRegion/*P*/ From) {
    assert isa_VarRegion(From);
    return llvm.cast(VarRegion.class, From);
  }

  public static VarRegion cast_or_null_VarRegion(MemRegion/*P*/ From) {
    return (From == null) ? null : cast_VarRegion(From);
  }

  public static VarRegion dyn_cast_VarRegion(MemRegion/*P*/ From) {
    assert From != null;
    return isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }

  public static VarRegion dyn_cast_or_null_VarRegion(MemRegion/*P*/ From) {
    return (From != null) && isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }

  public static boolean isa_VarRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VarRegion.class, From.$deref());
  }

  public static VarRegion cast_VarRegion(type$ref<?>/*P*/ From) {
    assert isa_VarRegion(From);
    return llvm.cast(VarRegion.class, From.$deref());
  }

  public static VarRegion cast_or_null_VarRegion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VarRegion(From);
  }

  public static VarRegion dyn_cast_VarRegion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }

  public static VarRegion dyn_cast_or_null_VarRegion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }

  public static boolean isa_VarRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VarRegion.class, From.$star());
  }

  public static VarRegion cast_VarRegion(type$ptr<?>/*P*/ From) {
    assert isa_VarRegion(From);
    return llvm.cast(VarRegion.class, From.$star());
  }

  public static VarRegion cast_or_null_VarRegion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VarRegion(From);
  }

  public static VarRegion dyn_cast_VarRegion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }

  public static VarRegion dyn_cast_or_null_VarRegion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VarRegion(From) ? cast_VarRegion(From) : null;
  }
}
