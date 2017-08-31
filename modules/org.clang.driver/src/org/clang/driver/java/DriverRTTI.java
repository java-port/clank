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
package org.clang.driver.java;

import org.clang.driver.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class DriverRTTI {
  /*package*/DriverRTTI() {}

  public static boolean isa_Action(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Action.class, From.$deref());
  }

  public static Action cast_Action(type$ref<?>/*P*/ From) {
    assert isa_Action(From);
    return llvm.cast(Action.class, From.$deref());
  }

  public static Action cast_or_null_Action(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Action(From);
  }

  public static Action dyn_cast_Action(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Action(From) ? cast_Action(From) : null;
  }

  public static Action dyn_cast_or_null_Action(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Action(From) ? cast_Action(From) : null;
  }

  public static boolean isa_Action(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Action.class, From.$star());
  }

  public static Action cast_Action(type$ptr<?>/*P*/ From) {
    assert isa_Action(From);
    return llvm.cast(Action.class, From.$star());
  }

  public static Action cast_or_null_Action(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Action(From);
  }

  public static Action dyn_cast_Action(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Action(From) ? cast_Action(From) : null;
  }

  public static Action dyn_cast_or_null_Action(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Action(From) ? cast_Action(From) : null;
  }

  public static boolean isa_Action(Action/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Action cast_Action(Action/*P*/ From) {
    assert isa_Action(From);
    return (Action) From;
  }

  public static Action cast_or_null_Action(Action/*P*/ From) {
    return (From == null) ? null : cast_Action(From);
  }

  public static Action dyn_cast_Action(Action/*P*/ From) {
    assert From != null;
    return isa_Action(From) ? cast_Action(From) : null;
  }

  public static Action dyn_cast_or_null_Action(Action/*P*/ From) {
    return (From != null) && isa_Action(From) ? cast_Action(From) : null;
  }

  public static boolean isa_AnalyzeJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AnalyzeJobAction.class, From.$deref());
  }

  public static AnalyzeJobAction cast_AnalyzeJobAction(type$ref<?>/*P*/ From) {
    assert isa_AnalyzeJobAction(From);
    return llvm.cast(AnalyzeJobAction.class, From.$deref());
  }

  public static AnalyzeJobAction cast_or_null_AnalyzeJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AnalyzeJobAction(From);
  }

  public static AnalyzeJobAction dyn_cast_AnalyzeJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static AnalyzeJobAction dyn_cast_or_null_AnalyzeJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static boolean isa_AnalyzeJobAction(Action/*P*/ From) {
    assert From != null;
    return AnalyzeJobAction.classof(From);
  }

  public static AnalyzeJobAction cast_AnalyzeJobAction(Action/*P*/ From) {
    assert isa_AnalyzeJobAction(From);
    return (AnalyzeJobAction) From;
  }

  public static AnalyzeJobAction cast_or_null_AnalyzeJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_AnalyzeJobAction(From);
  }

  public static AnalyzeJobAction dyn_cast_AnalyzeJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static AnalyzeJobAction dyn_cast_or_null_AnalyzeJobAction(Action/*P*/ From) {
    return (From != null) && isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static boolean isa_AnalyzeJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AnalyzeJobAction.class, From.$star());
  }

  public static AnalyzeJobAction cast_AnalyzeJobAction(type$ptr<?>/*P*/ From) {
    assert isa_AnalyzeJobAction(From);
    return llvm.cast(AnalyzeJobAction.class, From.$star());
  }

  public static AnalyzeJobAction cast_or_null_AnalyzeJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AnalyzeJobAction(From);
  }

  public static AnalyzeJobAction dyn_cast_AnalyzeJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static AnalyzeJobAction dyn_cast_or_null_AnalyzeJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AnalyzeJobAction(From) ? cast_AnalyzeJobAction(From) : null;
  }

  public static boolean isa_AssembleJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AssembleJobAction.class, From.$deref());
  }

  public static AssembleJobAction cast_AssembleJobAction(type$ref<?>/*P*/ From) {
    assert isa_AssembleJobAction(From);
    return llvm.cast(AssembleJobAction.class, From.$deref());
  }

  public static AssembleJobAction cast_or_null_AssembleJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AssembleJobAction(From);
  }

  public static AssembleJobAction dyn_cast_AssembleJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static AssembleJobAction dyn_cast_or_null_AssembleJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static boolean isa_AssembleJobAction(Action/*P*/ From) {
    assert From != null;
    return AssembleJobAction.classof(From);
  }

  public static AssembleJobAction cast_AssembleJobAction(Action/*P*/ From) {
    assert isa_AssembleJobAction(From);
    return (AssembleJobAction) From;
  }

  public static AssembleJobAction cast_or_null_AssembleJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_AssembleJobAction(From);
  }

  public static AssembleJobAction dyn_cast_AssembleJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static AssembleJobAction dyn_cast_or_null_AssembleJobAction(Action/*P*/ From) {
    return (From != null) && isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static boolean isa_AssembleJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AssembleJobAction.class, From.$star());
  }

  public static AssembleJobAction cast_AssembleJobAction(type$ptr<?>/*P*/ From) {
    assert isa_AssembleJobAction(From);
    return llvm.cast(AssembleJobAction.class, From.$star());
  }

  public static AssembleJobAction cast_or_null_AssembleJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AssembleJobAction(From);
  }

  public static AssembleJobAction dyn_cast_AssembleJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static AssembleJobAction dyn_cast_or_null_AssembleJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AssembleJobAction(From) ? cast_AssembleJobAction(From) : null;
  }

  public static boolean isa_BackendJobAction(Action/*P*/ From) {
    assert From != null;
    return BackendJobAction.classof(From);
  }

  public static BackendJobAction cast_BackendJobAction(Action/*P*/ From) {
    assert isa_BackendJobAction(From);
    return (BackendJobAction) From;
  }

  public static BackendJobAction cast_or_null_BackendJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_BackendJobAction(From);
  }

  public static BackendJobAction dyn_cast_BackendJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static BackendJobAction dyn_cast_or_null_BackendJobAction(Action/*P*/ From) {
    return (From != null) && isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static boolean isa_BackendJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BackendJobAction.class, From.$star());
  }

  public static BackendJobAction cast_BackendJobAction(type$ptr<?>/*P*/ From) {
    assert isa_BackendJobAction(From);
    return llvm.cast(BackendJobAction.class, From.$star());
  }

  public static BackendJobAction cast_or_null_BackendJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BackendJobAction(From);
  }

  public static BackendJobAction dyn_cast_BackendJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static BackendJobAction dyn_cast_or_null_BackendJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static boolean isa_BackendJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BackendJobAction.class, From.$deref());
  }

  public static BackendJobAction cast_BackendJobAction(type$ref<?>/*P*/ From) {
    assert isa_BackendJobAction(From);
    return llvm.cast(BackendJobAction.class, From.$deref());
  }

  public static BackendJobAction cast_or_null_BackendJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BackendJobAction(From);
  }

  public static BackendJobAction dyn_cast_BackendJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static BackendJobAction dyn_cast_or_null_BackendJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BackendJobAction(From) ? cast_BackendJobAction(From) : null;
  }

  public static boolean isa_BindArchAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BindArchAction.class, From.$deref());
  }

  public static BindArchAction cast_BindArchAction(type$ref<?>/*P*/ From) {
    assert isa_BindArchAction(From);
    return llvm.cast(BindArchAction.class, From.$deref());
  }

  public static BindArchAction cast_or_null_BindArchAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BindArchAction(From);
  }

  public static BindArchAction dyn_cast_BindArchAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static BindArchAction dyn_cast_or_null_BindArchAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static boolean isa_BindArchAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BindArchAction.class, From.$star());
  }

  public static BindArchAction cast_BindArchAction(type$ptr<?>/*P*/ From) {
    assert isa_BindArchAction(From);
    return llvm.cast(BindArchAction.class, From.$star());
  }

  public static BindArchAction cast_or_null_BindArchAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BindArchAction(From);
  }

  public static BindArchAction dyn_cast_BindArchAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static BindArchAction dyn_cast_or_null_BindArchAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static boolean isa_BindArchAction(Action/*P*/ From) {
    assert From != null;
    return BindArchAction.classof(From);
  }

  public static BindArchAction cast_BindArchAction(Action/*P*/ From) {
    assert isa_BindArchAction(From);
    return (BindArchAction) From;
  }

  public static BindArchAction cast_or_null_BindArchAction(Action/*P*/ From) {
    return (From == null) ? null : cast_BindArchAction(From);
  }

  public static BindArchAction dyn_cast_BindArchAction(Action/*P*/ From) {
    assert From != null;
    return isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static BindArchAction dyn_cast_or_null_BindArchAction(Action/*P*/ From) {
    return (From != null) && isa_BindArchAction(From) ? cast_BindArchAction(From) : null;
  }

  public static boolean isa_CompileJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompileJobAction.class, From.$deref());
  }

  public static CompileJobAction cast_CompileJobAction(type$ref<?>/*P*/ From) {
    assert isa_CompileJobAction(From);
    return llvm.cast(CompileJobAction.class, From.$deref());
  }

  public static CompileJobAction cast_or_null_CompileJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompileJobAction(From);
  }

  public static CompileJobAction dyn_cast_CompileJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static CompileJobAction dyn_cast_or_null_CompileJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static boolean isa_CompileJobAction(Action/*P*/ From) {
    assert From != null;
    return CompileJobAction.classof(From);
  }

  public static CompileJobAction cast_CompileJobAction(Action/*P*/ From) {
    assert isa_CompileJobAction(From);
    return (CompileJobAction) From;
  }

  public static CompileJobAction cast_or_null_CompileJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_CompileJobAction(From);
  }

  public static CompileJobAction dyn_cast_CompileJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static CompileJobAction dyn_cast_or_null_CompileJobAction(Action/*P*/ From) {
    return (From != null) && isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static boolean isa_CompileJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompileJobAction.class, From.$star());
  }

  public static CompileJobAction cast_CompileJobAction(type$ptr<?>/*P*/ From) {
    assert isa_CompileJobAction(From);
    return llvm.cast(CompileJobAction.class, From.$star());
  }

  public static CompileJobAction cast_or_null_CompileJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompileJobAction(From);
  }

  public static CompileJobAction dyn_cast_CompileJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static CompileJobAction dyn_cast_or_null_CompileJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompileJobAction(From) ? cast_CompileJobAction(From) : null;
  }

  public static boolean isa_DsymutilJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DsymutilJobAction.class, From.$star());
  }

  public static DsymutilJobAction cast_DsymutilJobAction(type$ptr<?>/*P*/ From) {
    assert isa_DsymutilJobAction(From);
    return llvm.cast(DsymutilJobAction.class, From.$star());
  }

  public static DsymutilJobAction cast_or_null_DsymutilJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DsymutilJobAction(From);
  }

  public static DsymutilJobAction dyn_cast_DsymutilJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static DsymutilJobAction dyn_cast_or_null_DsymutilJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static boolean isa_DsymutilJobAction(Action/*P*/ From) {
    assert From != null;
    return DsymutilJobAction.classof(From);
  }

  public static DsymutilJobAction cast_DsymutilJobAction(Action/*P*/ From) {
    assert isa_DsymutilJobAction(From);
    return (DsymutilJobAction) From;
  }

  public static DsymutilJobAction cast_or_null_DsymutilJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_DsymutilJobAction(From);
  }

  public static DsymutilJobAction dyn_cast_DsymutilJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static DsymutilJobAction dyn_cast_or_null_DsymutilJobAction(Action/*P*/ From) {
    return (From != null) && isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static boolean isa_DsymutilJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DsymutilJobAction.class, From.$deref());
  }

  public static DsymutilJobAction cast_DsymutilJobAction(type$ref<?>/*P*/ From) {
    assert isa_DsymutilJobAction(From);
    return llvm.cast(DsymutilJobAction.class, From.$deref());
  }

  public static DsymutilJobAction cast_or_null_DsymutilJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DsymutilJobAction(From);
  }

  public static DsymutilJobAction dyn_cast_DsymutilJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static DsymutilJobAction dyn_cast_or_null_DsymutilJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DsymutilJobAction(From) ? cast_DsymutilJobAction(From) : null;
  }

  public static boolean isa_InputAction(Action/*P*/ From) {
    assert From != null;
    return InputAction.classof(From);
  }

  public static InputAction cast_InputAction(Action/*P*/ From) {
    assert isa_InputAction(From);
    return (InputAction) From;
  }

  public static InputAction cast_or_null_InputAction(Action/*P*/ From) {
    return (From == null) ? null : cast_InputAction(From);
  }

  public static InputAction dyn_cast_InputAction(Action/*P*/ From) {
    assert From != null;
    return isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static InputAction dyn_cast_or_null_InputAction(Action/*P*/ From) {
    return (From != null) && isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static boolean isa_InputAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InputAction.class, From.$star());
  }

  public static InputAction cast_InputAction(type$ptr<?>/*P*/ From) {
    assert isa_InputAction(From);
    return llvm.cast(InputAction.class, From.$star());
  }

  public static InputAction cast_or_null_InputAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InputAction(From);
  }

  public static InputAction dyn_cast_InputAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static InputAction dyn_cast_or_null_InputAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static boolean isa_InputAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InputAction.class, From.$deref());
  }

  public static InputAction cast_InputAction(type$ref<?>/*P*/ From) {
    assert isa_InputAction(From);
    return llvm.cast(InputAction.class, From.$deref());
  }

  public static InputAction cast_or_null_InputAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InputAction(From);
  }

  public static InputAction dyn_cast_InputAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static InputAction dyn_cast_or_null_InputAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InputAction(From) ? cast_InputAction(From) : null;
  }

  public static boolean isa_JobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(JobAction.class, From.$star());
  }

  public static JobAction cast_JobAction(type$ptr<?>/*P*/ From) {
    assert isa_JobAction(From);
    return llvm.cast(JobAction.class, From.$star());
  }

  public static JobAction cast_or_null_JobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_JobAction(From);
  }

  public static JobAction dyn_cast_JobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static JobAction dyn_cast_or_null_JobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static boolean isa_JobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(JobAction.class, From.$deref());
  }

  public static JobAction cast_JobAction(type$ref<?>/*P*/ From) {
    assert isa_JobAction(From);
    return llvm.cast(JobAction.class, From.$deref());
  }

  public static JobAction cast_or_null_JobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_JobAction(From);
  }

  public static JobAction dyn_cast_JobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static JobAction dyn_cast_or_null_JobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static boolean isa_JobAction(Action/*P*/ From) {
    assert From != null;
    return JobAction.classof(From);
  }

  public static JobAction cast_JobAction(Action/*P*/ From) {
    assert isa_JobAction(From);
    return (JobAction) From;
  }

  public static JobAction cast_or_null_JobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_JobAction(From);
  }

  public static JobAction dyn_cast_JobAction(Action/*P*/ From) {
    assert From != null;
    return isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static JobAction dyn_cast_or_null_JobAction(Action/*P*/ From) {
    return (From != null) && isa_JobAction(From) ? cast_JobAction(From) : null;
  }

  public static boolean isa_LinkJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LinkJobAction.class, From.$star());
  }

  public static LinkJobAction cast_LinkJobAction(type$ptr<?>/*P*/ From) {
    assert isa_LinkJobAction(From);
    return llvm.cast(LinkJobAction.class, From.$star());
  }

  public static LinkJobAction cast_or_null_LinkJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LinkJobAction(From);
  }

  public static LinkJobAction dyn_cast_LinkJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static LinkJobAction dyn_cast_or_null_LinkJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static boolean isa_LinkJobAction(Action/*P*/ From) {
    assert From != null;
    return LinkJobAction.classof(From);
  }

  public static LinkJobAction cast_LinkJobAction(Action/*P*/ From) {
    assert isa_LinkJobAction(From);
    return (LinkJobAction) From;
  }

  public static LinkJobAction cast_or_null_LinkJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_LinkJobAction(From);
  }

  public static LinkJobAction dyn_cast_LinkJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static LinkJobAction dyn_cast_or_null_LinkJobAction(Action/*P*/ From) {
    return (From != null) && isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static boolean isa_LinkJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LinkJobAction.class, From.$deref());
  }

  public static LinkJobAction cast_LinkJobAction(type$ref<?>/*P*/ From) {
    assert isa_LinkJobAction(From);
    return llvm.cast(LinkJobAction.class, From.$deref());
  }

  public static LinkJobAction cast_or_null_LinkJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LinkJobAction(From);
  }

  public static LinkJobAction dyn_cast_LinkJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static LinkJobAction dyn_cast_or_null_LinkJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LinkJobAction(From) ? cast_LinkJobAction(From) : null;
  }

  public static boolean isa_LipoJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LipoJobAction.class, From.$deref());
  }

  public static LipoJobAction cast_LipoJobAction(type$ref<?>/*P*/ From) {
    assert isa_LipoJobAction(From);
    return llvm.cast(LipoJobAction.class, From.$deref());
  }

  public static LipoJobAction cast_or_null_LipoJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LipoJobAction(From);
  }

  public static LipoJobAction dyn_cast_LipoJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static LipoJobAction dyn_cast_or_null_LipoJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static boolean isa_LipoJobAction(Action/*P*/ From) {
    assert From != null;
    return LipoJobAction.classof(From);
  }

  public static LipoJobAction cast_LipoJobAction(Action/*P*/ From) {
    assert isa_LipoJobAction(From);
    return (LipoJobAction) From;
  }

  public static LipoJobAction cast_or_null_LipoJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_LipoJobAction(From);
  }

  public static LipoJobAction dyn_cast_LipoJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static LipoJobAction dyn_cast_or_null_LipoJobAction(Action/*P*/ From) {
    return (From != null) && isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static boolean isa_LipoJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LipoJobAction.class, From.$star());
  }

  public static LipoJobAction cast_LipoJobAction(type$ptr<?>/*P*/ From) {
    assert isa_LipoJobAction(From);
    return llvm.cast(LipoJobAction.class, From.$star());
  }

  public static LipoJobAction cast_or_null_LipoJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LipoJobAction(From);
  }

  public static LipoJobAction dyn_cast_LipoJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static LipoJobAction dyn_cast_or_null_LipoJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LipoJobAction(From) ? cast_LipoJobAction(From) : null;
  }

  public static boolean isa_MigrateJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MigrateJobAction.class, From.$star());
  }

  public static MigrateJobAction cast_MigrateJobAction(type$ptr<?>/*P*/ From) {
    assert isa_MigrateJobAction(From);
    return llvm.cast(MigrateJobAction.class, From.$star());
  }

  public static MigrateJobAction cast_or_null_MigrateJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MigrateJobAction(From);
  }

  public static MigrateJobAction dyn_cast_MigrateJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static MigrateJobAction dyn_cast_or_null_MigrateJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static boolean isa_MigrateJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MigrateJobAction.class, From.$deref());
  }

  public static MigrateJobAction cast_MigrateJobAction(type$ref<?>/*P*/ From) {
    assert isa_MigrateJobAction(From);
    return llvm.cast(MigrateJobAction.class, From.$deref());
  }

  public static MigrateJobAction cast_or_null_MigrateJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MigrateJobAction(From);
  }

  public static MigrateJobAction dyn_cast_MigrateJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static MigrateJobAction dyn_cast_or_null_MigrateJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static boolean isa_MigrateJobAction(Action/*P*/ From) {
    assert From != null;
    return MigrateJobAction.classof(From);
  }

  public static MigrateJobAction cast_MigrateJobAction(Action/*P*/ From) {
    assert isa_MigrateJobAction(From);
    return (MigrateJobAction) From;
  }

  public static MigrateJobAction cast_or_null_MigrateJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_MigrateJobAction(From);
  }

  public static MigrateJobAction dyn_cast_MigrateJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static MigrateJobAction dyn_cast_or_null_MigrateJobAction(Action/*P*/ From) {
    return (From != null) && isa_MigrateJobAction(From) ? cast_MigrateJobAction(From) : null;
  }

  public static boolean isa_OffloadAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OffloadAction.class, From.$star());
  }

  public static OffloadAction cast_OffloadAction(type$ptr<?>/*P*/ From) {
    assert isa_OffloadAction(From);
    return llvm.cast(OffloadAction.class, From.$star());
  }

  public static OffloadAction cast_or_null_OffloadAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OffloadAction(From);
  }

  public static OffloadAction dyn_cast_OffloadAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static OffloadAction dyn_cast_or_null_OffloadAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static boolean isa_OffloadAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OffloadAction.class, From.$deref());
  }

  public static OffloadAction cast_OffloadAction(type$ref<?>/*P*/ From) {
    assert isa_OffloadAction(From);
    return llvm.cast(OffloadAction.class, From.$deref());
  }

  public static OffloadAction cast_or_null_OffloadAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OffloadAction(From);
  }

  public static OffloadAction dyn_cast_OffloadAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static OffloadAction dyn_cast_or_null_OffloadAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static boolean isa_OffloadAction(Action/*P*/ From) {
    assert From != null;
    return OffloadAction.classof(From);
  }

  public static OffloadAction cast_OffloadAction(Action/*P*/ From) {
    assert isa_OffloadAction(From);
    return (OffloadAction) From;
  }

  public static OffloadAction cast_or_null_OffloadAction(Action/*P*/ From) {
    return (From == null) ? null : cast_OffloadAction(From);
  }

  public static OffloadAction dyn_cast_OffloadAction(Action/*P*/ From) {
    assert From != null;
    return isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static OffloadAction dyn_cast_or_null_OffloadAction(Action/*P*/ From) {
    return (From != null) && isa_OffloadAction(From) ? cast_OffloadAction(From) : null;
  }

  public static boolean isa_PrecompileJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PrecompileJobAction.class, From.$deref());
  }

  public static PrecompileJobAction cast_PrecompileJobAction(type$ref<?>/*P*/ From) {
    assert isa_PrecompileJobAction(From);
    return llvm.cast(PrecompileJobAction.class, From.$deref());
  }

  public static PrecompileJobAction cast_or_null_PrecompileJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PrecompileJobAction(From);
  }

  public static PrecompileJobAction dyn_cast_PrecompileJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static PrecompileJobAction dyn_cast_or_null_PrecompileJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static boolean isa_PrecompileJobAction(Action/*P*/ From) {
    assert From != null;
    return PrecompileJobAction.classof(From);
  }

  public static PrecompileJobAction cast_PrecompileJobAction(Action/*P*/ From) {
    assert isa_PrecompileJobAction(From);
    return (PrecompileJobAction) From;
  }

  public static PrecompileJobAction cast_or_null_PrecompileJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_PrecompileJobAction(From);
  }

  public static PrecompileJobAction dyn_cast_PrecompileJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static PrecompileJobAction dyn_cast_or_null_PrecompileJobAction(Action/*P*/ From) {
    return (From != null) && isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static boolean isa_PrecompileJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PrecompileJobAction.class, From.$star());
  }

  public static PrecompileJobAction cast_PrecompileJobAction(type$ptr<?>/*P*/ From) {
    assert isa_PrecompileJobAction(From);
    return llvm.cast(PrecompileJobAction.class, From.$star());
  }

  public static PrecompileJobAction cast_or_null_PrecompileJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PrecompileJobAction(From);
  }

  public static PrecompileJobAction dyn_cast_PrecompileJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static PrecompileJobAction dyn_cast_or_null_PrecompileJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PrecompileJobAction(From) ? cast_PrecompileJobAction(From) : null;
  }

  public static boolean isa_PreprocessJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PreprocessJobAction.class, From.$deref());
  }

  public static PreprocessJobAction cast_PreprocessJobAction(type$ref<?>/*P*/ From) {
    assert isa_PreprocessJobAction(From);
    return llvm.cast(PreprocessJobAction.class, From.$deref());
  }

  public static PreprocessJobAction cast_or_null_PreprocessJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PreprocessJobAction(From);
  }

  public static PreprocessJobAction dyn_cast_PreprocessJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static PreprocessJobAction dyn_cast_or_null_PreprocessJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static boolean isa_PreprocessJobAction(Action/*P*/ From) {
    assert From != null;
    return PreprocessJobAction.classof(From);
  }

  public static PreprocessJobAction cast_PreprocessJobAction(Action/*P*/ From) {
    assert isa_PreprocessJobAction(From);
    return (PreprocessJobAction) From;
  }

  public static PreprocessJobAction cast_or_null_PreprocessJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_PreprocessJobAction(From);
  }

  public static PreprocessJobAction dyn_cast_PreprocessJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static PreprocessJobAction dyn_cast_or_null_PreprocessJobAction(Action/*P*/ From) {
    return (From != null) && isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static boolean isa_PreprocessJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PreprocessJobAction.class, From.$star());
  }

  public static PreprocessJobAction cast_PreprocessJobAction(type$ptr<?>/*P*/ From) {
    assert isa_PreprocessJobAction(From);
    return llvm.cast(PreprocessJobAction.class, From.$star());
  }

  public static PreprocessJobAction cast_or_null_PreprocessJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PreprocessJobAction(From);
  }

  public static PreprocessJobAction dyn_cast_PreprocessJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static PreprocessJobAction dyn_cast_or_null_PreprocessJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PreprocessJobAction(From) ? cast_PreprocessJobAction(From) : null;
  }

  public static boolean isa_VerifyDebugInfoJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerifyDebugInfoJobAction.class, From.$deref());
  }

  public static VerifyDebugInfoJobAction cast_VerifyDebugInfoJobAction(type$ref<?>/*P*/ From) {
    assert isa_VerifyDebugInfoJobAction(From);
    return llvm.cast(VerifyDebugInfoJobAction.class, From.$deref());
  }

  public static VerifyDebugInfoJobAction cast_or_null_VerifyDebugInfoJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerifyDebugInfoJobAction(From);
  }

  public static VerifyDebugInfoJobAction dyn_cast_VerifyDebugInfoJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static VerifyDebugInfoJobAction dyn_cast_or_null_VerifyDebugInfoJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static boolean isa_VerifyDebugInfoJobAction(Action/*P*/ From) {
    assert From != null;
    return VerifyDebugInfoJobAction.classof(From);
  }

  public static VerifyDebugInfoJobAction cast_VerifyDebugInfoJobAction(Action/*P*/ From) {
    assert isa_VerifyDebugInfoJobAction(From);
    return (VerifyDebugInfoJobAction) From;
  }

  public static VerifyDebugInfoJobAction cast_or_null_VerifyDebugInfoJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_VerifyDebugInfoJobAction(From);
  }

  public static VerifyDebugInfoJobAction dyn_cast_VerifyDebugInfoJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static VerifyDebugInfoJobAction dyn_cast_or_null_VerifyDebugInfoJobAction(Action/*P*/ From) {
    return (From != null) && isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static boolean isa_VerifyDebugInfoJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerifyDebugInfoJobAction.class, From.$star());
  }

  public static VerifyDebugInfoJobAction cast_VerifyDebugInfoJobAction(type$ptr<?>/*P*/ From) {
    assert isa_VerifyDebugInfoJobAction(From);
    return llvm.cast(VerifyDebugInfoJobAction.class, From.$star());
  }

  public static VerifyDebugInfoJobAction cast_or_null_VerifyDebugInfoJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerifyDebugInfoJobAction(From);
  }

  public static VerifyDebugInfoJobAction dyn_cast_VerifyDebugInfoJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static VerifyDebugInfoJobAction dyn_cast_or_null_VerifyDebugInfoJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerifyDebugInfoJobAction(From) ? cast_VerifyDebugInfoJobAction(From) : null;
  }

  public static boolean isa_VerifyJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerifyJobAction.class, From.$star());
  }

  public static VerifyJobAction cast_VerifyJobAction(type$ptr<?>/*P*/ From) {
    assert isa_VerifyJobAction(From);
    return llvm.cast(VerifyJobAction.class, From.$star());
  }

  public static VerifyJobAction cast_or_null_VerifyJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerifyJobAction(From);
  }

  public static VerifyJobAction dyn_cast_VerifyJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static VerifyJobAction dyn_cast_or_null_VerifyJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static boolean isa_VerifyJobAction(Action/*P*/ From) {
    assert From != null;
    return VerifyJobAction.classof(From);
  }

  public static VerifyJobAction cast_VerifyJobAction(Action/*P*/ From) {
    assert isa_VerifyJobAction(From);
    return (VerifyJobAction) From;
  }

  public static VerifyJobAction cast_or_null_VerifyJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_VerifyJobAction(From);
  }

  public static VerifyJobAction dyn_cast_VerifyJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static VerifyJobAction dyn_cast_or_null_VerifyJobAction(Action/*P*/ From) {
    return (From != null) && isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static boolean isa_VerifyJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerifyJobAction.class, From.$deref());
  }

  public static VerifyJobAction cast_VerifyJobAction(type$ref<?>/*P*/ From) {
    assert isa_VerifyJobAction(From);
    return llvm.cast(VerifyJobAction.class, From.$deref());
  }

  public static VerifyJobAction cast_or_null_VerifyJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerifyJobAction(From);
  }

  public static VerifyJobAction dyn_cast_VerifyJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static VerifyJobAction dyn_cast_or_null_VerifyJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerifyJobAction(From) ? cast_VerifyJobAction(From) : null;
  }

  public static boolean isa_VerifyPCHJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VerifyPCHJobAction.class, From.$deref());
  }

  public static VerifyPCHJobAction cast_VerifyPCHJobAction(type$ref<?>/*P*/ From) {
    assert isa_VerifyPCHJobAction(From);
    return llvm.cast(VerifyPCHJobAction.class, From.$deref());
  }

  public static VerifyPCHJobAction cast_or_null_VerifyPCHJobAction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VerifyPCHJobAction(From);
  }

  public static VerifyPCHJobAction dyn_cast_VerifyPCHJobAction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }

  public static VerifyPCHJobAction dyn_cast_or_null_VerifyPCHJobAction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }

  public static boolean isa_VerifyPCHJobAction(Action/*P*/ From) {
    assert From != null;
    return VerifyPCHJobAction.classof(From);
  }

  public static VerifyPCHJobAction cast_VerifyPCHJobAction(Action/*P*/ From) {
    assert isa_VerifyPCHJobAction(From);
    return (VerifyPCHJobAction) From;
  }

  public static VerifyPCHJobAction cast_or_null_VerifyPCHJobAction(Action/*P*/ From) {
    return (From == null) ? null : cast_VerifyPCHJobAction(From);
  }

  public static VerifyPCHJobAction dyn_cast_VerifyPCHJobAction(Action/*P*/ From) {
    assert From != null;
    return isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }

  public static VerifyPCHJobAction dyn_cast_or_null_VerifyPCHJobAction(Action/*P*/ From) {
    return (From != null) && isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }

  public static boolean isa_VerifyPCHJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VerifyPCHJobAction.class, From.$star());
  }

  public static VerifyPCHJobAction cast_VerifyPCHJobAction(type$ptr<?>/*P*/ From) {
    assert isa_VerifyPCHJobAction(From);
    return llvm.cast(VerifyPCHJobAction.class, From.$star());
  }

  public static VerifyPCHJobAction cast_or_null_VerifyPCHJobAction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VerifyPCHJobAction(From);
  }

  public static VerifyPCHJobAction dyn_cast_VerifyPCHJobAction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }

  public static VerifyPCHJobAction dyn_cast_or_null_VerifyPCHJobAction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VerifyPCHJobAction(From) ? cast_VerifyPCHJobAction(From) : null;
  }
}
