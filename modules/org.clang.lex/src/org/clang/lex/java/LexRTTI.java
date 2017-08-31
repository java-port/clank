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
package org.clang.lex.java;

import org.clang.lex.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class LexRTTI {
  /*package*/LexRTTI() {}

  public static boolean isa_DefMacroDirective(DefMacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(DefMacroDirective.class, From);
  }

  public static DefMacroDirective cast_DefMacroDirective(DefMacroDirective/*P*/ From) {
    assert isa_DefMacroDirective(From);
    return llvm.cast(DefMacroDirective.class, From);
  }

  public static DefMacroDirective cast_or_null_DefMacroDirective(DefMacroDirective/*P*/ From) {
    return (From == null) ? null : cast_DefMacroDirective(From);
  }

  public static DefMacroDirective dyn_cast_DefMacroDirective(DefMacroDirective/*P*/ From) {
    assert From != null;
    return isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static DefMacroDirective dyn_cast_or_null_DefMacroDirective(DefMacroDirective/*P*/ From) {
    return (From != null) && isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static boolean isa_DefMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DefMacroDirective.class, From.$star());
  }

  public static DefMacroDirective cast_DefMacroDirective(type$ptr<?>/*P*/ From) {
    assert isa_DefMacroDirective(From);
    return llvm.cast(DefMacroDirective.class, From.$star());
  }

  public static DefMacroDirective cast_or_null_DefMacroDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DefMacroDirective(From);
  }

  public static DefMacroDirective dyn_cast_DefMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static DefMacroDirective dyn_cast_or_null_DefMacroDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static boolean isa_DefMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DefMacroDirective.class, From.$deref());
  }

  public static DefMacroDirective cast_DefMacroDirective(type$ref<?>/*P*/ From) {
    assert isa_DefMacroDirective(From);
    return llvm.cast(DefMacroDirective.class, From.$deref());
  }

  public static DefMacroDirective cast_or_null_DefMacroDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DefMacroDirective(From);
  }

  public static DefMacroDirective dyn_cast_DefMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static DefMacroDirective dyn_cast_or_null_DefMacroDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static boolean isa_DefMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(DefMacroDirective.class, From);
  }

  public static DefMacroDirective cast_DefMacroDirective(MacroDirective/*P*/ From) {
    assert isa_DefMacroDirective(From);
    return llvm.cast(DefMacroDirective.class, From);
  }

  public static DefMacroDirective cast_or_null_DefMacroDirective(MacroDirective/*P*/ From) {
    return (From == null) ? null : cast_DefMacroDirective(From);
  }

  public static DefMacroDirective dyn_cast_DefMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static DefMacroDirective dyn_cast_or_null_DefMacroDirective(MacroDirective/*P*/ From) {
    return (From != null) && isa_DefMacroDirective(From) ? cast_DefMacroDirective(From) : null;
  }

  public static boolean isa_InclusionDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InclusionDirective.class, From.$deref());
  }

  public static InclusionDirective cast_InclusionDirective(type$ref<?>/*P*/ From) {
    assert isa_InclusionDirective(From);
    return llvm.cast(InclusionDirective.class, From.$deref());
  }

  public static InclusionDirective cast_or_null_InclusionDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InclusionDirective(From);
  }

  public static InclusionDirective dyn_cast_InclusionDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static InclusionDirective dyn_cast_or_null_InclusionDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static boolean isa_InclusionDirective(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return llvm.isa(InclusionDirective.class, From);
  }

  public static InclusionDirective cast_InclusionDirective(PreprocessedEntity/*P*/ From) {
    assert isa_InclusionDirective(From);
    return llvm.cast(InclusionDirective.class, From);
  }

  public static InclusionDirective cast_or_null_InclusionDirective(PreprocessedEntity/*P*/ From) {
    return (From == null) ? null : cast_InclusionDirective(From);
  }

  public static InclusionDirective dyn_cast_InclusionDirective(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static InclusionDirective dyn_cast_or_null_InclusionDirective(PreprocessedEntity/*P*/ From) {
    return (From != null) && isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static boolean isa_InclusionDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InclusionDirective.class, From.$star());
  }

  public static InclusionDirective cast_InclusionDirective(type$ptr<?>/*P*/ From) {
    assert isa_InclusionDirective(From);
    return llvm.cast(InclusionDirective.class, From.$star());
  }

  public static InclusionDirective cast_or_null_InclusionDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InclusionDirective(From);
  }

  public static InclusionDirective dyn_cast_InclusionDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static InclusionDirective dyn_cast_or_null_InclusionDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InclusionDirective(From) ? cast_InclusionDirective(From) : null;
  }

  public static boolean isa_MacroDefinitionRecord(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MacroDefinitionRecord.class, From.$deref());
  }

  public static MacroDefinitionRecord cast_MacroDefinitionRecord(type$ref<?>/*P*/ From) {
    assert isa_MacroDefinitionRecord(From);
    return llvm.cast(MacroDefinitionRecord.class, From.$deref());
  }

  public static MacroDefinitionRecord cast_or_null_MacroDefinitionRecord(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MacroDefinitionRecord(From);
  }

  public static MacroDefinitionRecord dyn_cast_MacroDefinitionRecord(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static MacroDefinitionRecord dyn_cast_or_null_MacroDefinitionRecord(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static boolean isa_MacroDefinitionRecord(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MacroDefinitionRecord.class, From.$star());
  }

  public static MacroDefinitionRecord cast_MacroDefinitionRecord(type$ptr<?>/*P*/ From) {
    assert isa_MacroDefinitionRecord(From);
    return llvm.cast(MacroDefinitionRecord.class, From.$star());
  }

  public static MacroDefinitionRecord cast_or_null_MacroDefinitionRecord(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MacroDefinitionRecord(From);
  }

  public static MacroDefinitionRecord dyn_cast_MacroDefinitionRecord(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static MacroDefinitionRecord dyn_cast_or_null_MacroDefinitionRecord(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static boolean isa_MacroDefinitionRecord(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return llvm.isa(MacroDefinitionRecord.class, From);
  }

  public static MacroDefinitionRecord cast_MacroDefinitionRecord(PreprocessedEntity/*P*/ From) {
    assert isa_MacroDefinitionRecord(From);
    return llvm.cast(MacroDefinitionRecord.class, From);
  }

  public static MacroDefinitionRecord cast_or_null_MacroDefinitionRecord(PreprocessedEntity/*P*/ From) {
    return (From == null) ? null : cast_MacroDefinitionRecord(From);
  }

  public static MacroDefinitionRecord dyn_cast_MacroDefinitionRecord(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static MacroDefinitionRecord dyn_cast_or_null_MacroDefinitionRecord(PreprocessedEntity/*P*/ From) {
    return (From != null) && isa_MacroDefinitionRecord(From) ? cast_MacroDefinitionRecord(From) : null;
  }

  public static boolean isa_MacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(MacroDirective.class, From);
  }

  public static MacroDirective cast_MacroDirective(MacroDirective/*P*/ From) {
    assert isa_MacroDirective(From);
    return llvm.cast(MacroDirective.class, From);
  }

  public static MacroDirective cast_or_null_MacroDirective(MacroDirective/*P*/ From) {
    return (From == null) ? null : cast_MacroDirective(From);
  }

  public static MacroDirective dyn_cast_MacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static MacroDirective dyn_cast_or_null_MacroDirective(MacroDirective/*P*/ From) {
    return (From != null) && isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static boolean isa_MacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MacroDirective.class, From.$star());
  }

  public static MacroDirective cast_MacroDirective(type$ptr<?>/*P*/ From) {
    assert isa_MacroDirective(From);
    return llvm.cast(MacroDirective.class, From.$star());
  }

  public static MacroDirective cast_or_null_MacroDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MacroDirective(From);
  }

  public static MacroDirective dyn_cast_MacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static MacroDirective dyn_cast_or_null_MacroDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static boolean isa_MacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MacroDirective.class, From.$deref());
  }

  public static MacroDirective cast_MacroDirective(type$ref<?>/*P*/ From) {
    assert isa_MacroDirective(From);
    return llvm.cast(MacroDirective.class, From.$deref());
  }

  public static MacroDirective cast_or_null_MacroDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MacroDirective(From);
  }

  public static MacroDirective dyn_cast_MacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static MacroDirective dyn_cast_or_null_MacroDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MacroDirective(From) ? cast_MacroDirective(From) : null;
  }

  public static boolean isa_MacroExpansion(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return llvm.isa(MacroExpansion.class, From);
  }

  public static MacroExpansion cast_MacroExpansion(PreprocessedEntity/*P*/ From) {
    assert isa_MacroExpansion(From);
    return llvm.cast(MacroExpansion.class, From);
  }

  public static MacroExpansion cast_or_null_MacroExpansion(PreprocessedEntity/*P*/ From) {
    return (From == null) ? null : cast_MacroExpansion(From);
  }

  public static MacroExpansion dyn_cast_MacroExpansion(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static MacroExpansion dyn_cast_or_null_MacroExpansion(PreprocessedEntity/*P*/ From) {
    return (From != null) && isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static boolean isa_MacroExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MacroExpansion.class, From.$star());
  }

  public static MacroExpansion cast_MacroExpansion(type$ptr<?>/*P*/ From) {
    assert isa_MacroExpansion(From);
    return llvm.cast(MacroExpansion.class, From.$star());
  }

  public static MacroExpansion cast_or_null_MacroExpansion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MacroExpansion(From);
  }

  public static MacroExpansion dyn_cast_MacroExpansion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static MacroExpansion dyn_cast_or_null_MacroExpansion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static boolean isa_MacroExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MacroExpansion.class, From.$deref());
  }

  public static MacroExpansion cast_MacroExpansion(type$ref<?>/*P*/ From) {
    assert isa_MacroExpansion(From);
    return llvm.cast(MacroExpansion.class, From.$deref());
  }

  public static MacroExpansion cast_or_null_MacroExpansion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MacroExpansion(From);
  }

  public static MacroExpansion dyn_cast_MacroExpansion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static MacroExpansion dyn_cast_or_null_MacroExpansion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MacroExpansion(From) ? cast_MacroExpansion(From) : null;
  }

  public static boolean isa_PreprocessedEntity(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PreprocessedEntity.class, From.$star());
  }

  public static PreprocessedEntity cast_PreprocessedEntity(type$ptr<?>/*P*/ From) {
    assert isa_PreprocessedEntity(From);
    return llvm.cast(PreprocessedEntity.class, From.$star());
  }

  public static PreprocessedEntity cast_or_null_PreprocessedEntity(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PreprocessedEntity(From);
  }

  public static PreprocessedEntity dyn_cast_PreprocessedEntity(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static PreprocessedEntity dyn_cast_or_null_PreprocessedEntity(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static boolean isa_PreprocessedEntity(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return llvm.isa(PreprocessedEntity.class, From);
  }

  public static PreprocessedEntity cast_PreprocessedEntity(PreprocessedEntity/*P*/ From) {
    assert isa_PreprocessedEntity(From);
    return llvm.cast(PreprocessedEntity.class, From);
  }

  public static PreprocessedEntity cast_or_null_PreprocessedEntity(PreprocessedEntity/*P*/ From) {
    return (From == null) ? null : cast_PreprocessedEntity(From);
  }

  public static PreprocessedEntity dyn_cast_PreprocessedEntity(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static PreprocessedEntity dyn_cast_or_null_PreprocessedEntity(PreprocessedEntity/*P*/ From) {
    return (From != null) && isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static boolean isa_PreprocessedEntity(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PreprocessedEntity.class, From.$deref());
  }

  public static PreprocessedEntity cast_PreprocessedEntity(type$ref<?>/*P*/ From) {
    assert isa_PreprocessedEntity(From);
    return llvm.cast(PreprocessedEntity.class, From.$deref());
  }

  public static PreprocessedEntity cast_or_null_PreprocessedEntity(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PreprocessedEntity(From);
  }

  public static PreprocessedEntity dyn_cast_PreprocessedEntity(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static PreprocessedEntity dyn_cast_or_null_PreprocessedEntity(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PreprocessedEntity(From) ? cast_PreprocessedEntity(From) : null;
  }

  public static boolean isa_PreprocessingDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PreprocessingDirective.class, From.$deref());
  }

  public static PreprocessingDirective cast_PreprocessingDirective(type$ref<?>/*P*/ From) {
    assert isa_PreprocessingDirective(From);
    return llvm.cast(PreprocessingDirective.class, From.$deref());
  }

  public static PreprocessingDirective cast_or_null_PreprocessingDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PreprocessingDirective(From);
  }

  public static PreprocessingDirective dyn_cast_PreprocessingDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static PreprocessingDirective dyn_cast_or_null_PreprocessingDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static boolean isa_PreprocessingDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PreprocessingDirective.class, From.$star());
  }

  public static PreprocessingDirective cast_PreprocessingDirective(type$ptr<?>/*P*/ From) {
    assert isa_PreprocessingDirective(From);
    return llvm.cast(PreprocessingDirective.class, From.$star());
  }

  public static PreprocessingDirective cast_or_null_PreprocessingDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PreprocessingDirective(From);
  }

  public static PreprocessingDirective dyn_cast_PreprocessingDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static PreprocessingDirective dyn_cast_or_null_PreprocessingDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static boolean isa_PreprocessingDirective(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return llvm.isa(PreprocessingDirective.class, From);
  }

  public static PreprocessingDirective cast_PreprocessingDirective(PreprocessedEntity/*P*/ From) {
    assert isa_PreprocessingDirective(From);
    return llvm.cast(PreprocessingDirective.class, From);
  }

  public static PreprocessingDirective cast_or_null_PreprocessingDirective(PreprocessedEntity/*P*/ From) {
    return (From == null) ? null : cast_PreprocessingDirective(From);
  }

  public static PreprocessingDirective dyn_cast_PreprocessingDirective(PreprocessedEntity/*P*/ From) {
    assert From != null;
    return isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static PreprocessingDirective dyn_cast_or_null_PreprocessingDirective(PreprocessedEntity/*P*/ From) {
    return (From != null) && isa_PreprocessingDirective(From) ? cast_PreprocessingDirective(From) : null;
  }

  public static boolean isa_UndefMacroDirective(UndefMacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(UndefMacroDirective.class, From);
  }

  public static UndefMacroDirective cast_UndefMacroDirective(UndefMacroDirective/*P*/ From) {
    assert isa_UndefMacroDirective(From);
    return llvm.cast(UndefMacroDirective.class, From);
  }

  public static UndefMacroDirective cast_or_null_UndefMacroDirective(UndefMacroDirective/*P*/ From) {
    return (From == null) ? null : cast_UndefMacroDirective(From);
  }

  public static UndefMacroDirective dyn_cast_UndefMacroDirective(UndefMacroDirective/*P*/ From) {
    assert From != null;
    return isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static UndefMacroDirective dyn_cast_or_null_UndefMacroDirective(UndefMacroDirective/*P*/ From) {
    return (From != null) && isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static boolean isa_UndefMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(UndefMacroDirective.class, From);
  }

  public static UndefMacroDirective cast_UndefMacroDirective(MacroDirective/*P*/ From) {
    assert isa_UndefMacroDirective(From);
    return llvm.cast(UndefMacroDirective.class, From);
  }

  public static UndefMacroDirective cast_or_null_UndefMacroDirective(MacroDirective/*P*/ From) {
    return (From == null) ? null : cast_UndefMacroDirective(From);
  }

  public static UndefMacroDirective dyn_cast_UndefMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static UndefMacroDirective dyn_cast_or_null_UndefMacroDirective(MacroDirective/*P*/ From) {
    return (From != null) && isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static boolean isa_UndefMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UndefMacroDirective.class, From.$deref());
  }

  public static UndefMacroDirective cast_UndefMacroDirective(type$ref<?>/*P*/ From) {
    assert isa_UndefMacroDirective(From);
    return llvm.cast(UndefMacroDirective.class, From.$deref());
  }

  public static UndefMacroDirective cast_or_null_UndefMacroDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UndefMacroDirective(From);
  }

  public static UndefMacroDirective dyn_cast_UndefMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static UndefMacroDirective dyn_cast_or_null_UndefMacroDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static boolean isa_UndefMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UndefMacroDirective.class, From.$star());
  }

  public static UndefMacroDirective cast_UndefMacroDirective(type$ptr<?>/*P*/ From) {
    assert isa_UndefMacroDirective(From);
    return llvm.cast(UndefMacroDirective.class, From.$star());
  }

  public static UndefMacroDirective cast_or_null_UndefMacroDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UndefMacroDirective(From);
  }

  public static UndefMacroDirective dyn_cast_UndefMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static UndefMacroDirective dyn_cast_or_null_UndefMacroDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UndefMacroDirective(From) ? cast_UndefMacroDirective(From) : null;
  }

  public static boolean isa_VisibilityMacroDirective(VisibilityMacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(VisibilityMacroDirective.class, From);
  }

  public static VisibilityMacroDirective cast_VisibilityMacroDirective(VisibilityMacroDirective/*P*/ From) {
    assert isa_VisibilityMacroDirective(From);
    return llvm.cast(VisibilityMacroDirective.class, From);
  }

  public static VisibilityMacroDirective cast_or_null_VisibilityMacroDirective(VisibilityMacroDirective/*P*/ From) {
    return (From == null) ? null : cast_VisibilityMacroDirective(From);
  }

  public static VisibilityMacroDirective dyn_cast_VisibilityMacroDirective(VisibilityMacroDirective/*P*/ From) {
    assert From != null;
    return isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static VisibilityMacroDirective dyn_cast_or_null_VisibilityMacroDirective(VisibilityMacroDirective/*P*/ From) {
    return (From != null) && isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static boolean isa_VisibilityMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VisibilityMacroDirective.class, From.$deref());
  }

  public static VisibilityMacroDirective cast_VisibilityMacroDirective(type$ref<?>/*P*/ From) {
    assert isa_VisibilityMacroDirective(From);
    return llvm.cast(VisibilityMacroDirective.class, From.$deref());
  }

  public static VisibilityMacroDirective cast_or_null_VisibilityMacroDirective(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VisibilityMacroDirective(From);
  }

  public static VisibilityMacroDirective dyn_cast_VisibilityMacroDirective(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static VisibilityMacroDirective dyn_cast_or_null_VisibilityMacroDirective(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static boolean isa_VisibilityMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return llvm.isa(VisibilityMacroDirective.class, From);
  }

  public static VisibilityMacroDirective cast_VisibilityMacroDirective(MacroDirective/*P*/ From) {
    assert isa_VisibilityMacroDirective(From);
    return llvm.cast(VisibilityMacroDirective.class, From);
  }

  public static VisibilityMacroDirective cast_or_null_VisibilityMacroDirective(MacroDirective/*P*/ From) {
    return (From == null) ? null : cast_VisibilityMacroDirective(From);
  }

  public static VisibilityMacroDirective dyn_cast_VisibilityMacroDirective(MacroDirective/*P*/ From) {
    assert From != null;
    return isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static VisibilityMacroDirective dyn_cast_or_null_VisibilityMacroDirective(MacroDirective/*P*/ From) {
    return (From != null) && isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static boolean isa_VisibilityMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VisibilityMacroDirective.class, From.$star());
  }

  public static VisibilityMacroDirective cast_VisibilityMacroDirective(type$ptr<?>/*P*/ From) {
    assert isa_VisibilityMacroDirective(From);
    return llvm.cast(VisibilityMacroDirective.class, From.$star());
  }

  public static VisibilityMacroDirective cast_or_null_VisibilityMacroDirective(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VisibilityMacroDirective(From);
  }

  public static VisibilityMacroDirective dyn_cast_VisibilityMacroDirective(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }

  public static VisibilityMacroDirective dyn_cast_or_null_VisibilityMacroDirective(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VisibilityMacroDirective(From) ? cast_VisibilityMacroDirective(From) : null;
  }
}
