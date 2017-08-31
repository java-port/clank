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
package org.llvm.ir.java;

import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class IrRTTI extends IRManualRTTI {
  /*package*/IrRTTI() {}

  public static boolean isa_AShrOperator(Instruction/*P*/ From) {
    assert From != null;
    return AShrOperator.classof(From);
  }

  public static AShrOperator cast_AShrOperator(Instruction/*P*/ From) {
    assert isa_AShrOperator(From);
    return llvm.cast(AShrOperator.class, From);
  }

  public static AShrOperator cast_or_null_AShrOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AShrOperator(From);
  }

  public static AShrOperator dyn_cast_AShrOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(Instruction/*P*/ From) {
    return (From != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AShrOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AShrOperator.class, From.$deref());
  }

  public static AShrOperator cast_AShrOperator(type$ref<?>/*P*/ From) {
    assert isa_AShrOperator(From);
    return llvm.cast(AShrOperator.class, From.$deref());
  }

  public static AShrOperator cast_or_null_AShrOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AShrOperator(From);
  }

  public static AShrOperator dyn_cast_AShrOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AShrOperator(Value/*P*/ From) {
    assert From != null;
    return AShrOperator.classof(From);
  }

  public static AShrOperator cast_AShrOperator(Value/*P*/ From) {
    assert isa_AShrOperator(From);
    return llvm.cast(AShrOperator.class, From);
  }

  public static AShrOperator cast_or_null_AShrOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_AShrOperator(From);
  }

  public static AShrOperator dyn_cast_AShrOperator(Value/*P*/ From) {
    assert From != null;
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(Value/*P*/ From) {
    return (From != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AShrOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return AShrOperator.classof(From);
  }

  public static AShrOperator cast_AShrOperator(ConstantExpr/*P*/ From) {
    assert isa_AShrOperator(From);
    return llvm.cast(AShrOperator.class, From);
  }

  public static AShrOperator cast_or_null_AShrOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_AShrOperator(From);
  }

  public static AShrOperator dyn_cast_AShrOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AShrOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AShrOperator.class, From.$star());
  }

  public static AShrOperator cast_AShrOperator(type$ptr<?>/*P*/ From) {
    assert isa_AShrOperator(From);
    return llvm.cast(AShrOperator.class, From.$star());
  }

  public static AShrOperator cast_or_null_AShrOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AShrOperator(From);
  }

  public static AShrOperator dyn_cast_AShrOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AShrOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AShrOperator(From.get());
  }

  public static AShrOperator cast_AShrOperator(Use/*P*/ From) {
    return cast_AShrOperator(From.get());
  }

  public static AShrOperator cast_or_null_AShrOperator(Use/*P*/ From) {
    return cast_or_null_AShrOperator(From.get());
  }

  public static AShrOperator dyn_cast_AShrOperator(Use/*P*/ From) {
    return isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static AShrOperator dyn_cast_or_null_AShrOperator(Use/*P*/ From) {
    return (From != null) && isa_AShrOperator(From) ? cast_AShrOperator(From) : null;
  }

  public static boolean isa_AddOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AddOperator.class, From.$star());
  }

  public static AddOperator cast_AddOperator(type$ptr<?>/*P*/ From) {
    assert isa_AddOperator(From);
    return llvm.cast(AddOperator.class, From.$star());
  }

  public static AddOperator cast_or_null_AddOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AddOperator(From);
  }

  public static AddOperator dyn_cast_AddOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddOperator(Instruction/*P*/ From) {
    assert From != null;
    return AddOperator.classof(From);
  }

  public static AddOperator cast_AddOperator(Instruction/*P*/ From) {
    assert isa_AddOperator(From);
    return llvm.cast(AddOperator.class, From);
  }

  public static AddOperator cast_or_null_AddOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AddOperator(From);
  }

  public static AddOperator dyn_cast_AddOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(Instruction/*P*/ From) {
    return (From != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return AddOperator.classof(From);
  }

  public static AddOperator cast_AddOperator(ConstantExpr/*P*/ From) {
    assert isa_AddOperator(From);
    return llvm.cast(AddOperator.class, From);
  }

  public static AddOperator cast_or_null_AddOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_AddOperator(From);
  }

  public static AddOperator dyn_cast_AddOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddOperator(Value/*P*/ From) {
    assert From != null;
    return AddOperator.classof(From);
  }

  public static AddOperator cast_AddOperator(Value/*P*/ From) {
    assert isa_AddOperator(From);
    return llvm.cast(AddOperator.class, From);
  }

  public static AddOperator cast_or_null_AddOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_AddOperator(From);
  }

  public static AddOperator dyn_cast_AddOperator(Value/*P*/ From) {
    assert From != null;
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(Value/*P*/ From) {
    return (From != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AddOperator(From.get());
  }

  public static AddOperator cast_AddOperator(Use/*P*/ From) {
    return cast_AddOperator(From.get());
  }

  public static AddOperator cast_or_null_AddOperator(Use/*P*/ From) {
    return cast_or_null_AddOperator(From.get());
  }

  public static AddOperator dyn_cast_AddOperator(Use/*P*/ From) {
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(Use/*P*/ From) {
    return (From != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AddOperator.class, From.$deref());
  }

  public static AddOperator cast_AddOperator(type$ref<?>/*P*/ From) {
    assert isa_AddOperator(From);
    return llvm.cast(AddOperator.class, From.$deref());
  }

  public static AddOperator cast_or_null_AddOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AddOperator(From);
  }

  public static AddOperator dyn_cast_AddOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static AddOperator dyn_cast_or_null_AddOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AddOperator(From) ? cast_AddOperator(From) : null;
  }

  public static boolean isa_AddrSpaceCastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AddrSpaceCastInst.class, From.$star());
  }

  public static AddrSpaceCastInst cast_AddrSpaceCastInst(type$ptr<?>/*P*/ From) {
    assert isa_AddrSpaceCastInst(From);
    return llvm.cast(AddrSpaceCastInst.class, From.$star());
  }

  public static AddrSpaceCastInst cast_or_null_AddrSpaceCastInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AddrSpaceCastInst(From);
  }

  public static AddrSpaceCastInst dyn_cast_AddrSpaceCastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static AddrSpaceCastInst dyn_cast_or_null_AddrSpaceCastInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static boolean isa_AddrSpaceCastInst(Instruction/*P*/ From) {
    assert From != null;
    return AddrSpaceCastInst.classof(From);
  }

  public static AddrSpaceCastInst cast_AddrSpaceCastInst(Instruction/*P*/ From) {
    assert isa_AddrSpaceCastInst(From);
    return llvm.cast(AddrSpaceCastInst.class, From);
  }

  public static AddrSpaceCastInst cast_or_null_AddrSpaceCastInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AddrSpaceCastInst(From);
  }

  public static AddrSpaceCastInst dyn_cast_AddrSpaceCastInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static AddrSpaceCastInst dyn_cast_or_null_AddrSpaceCastInst(Instruction/*P*/ From) {
    return (From != null) && isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static boolean isa_AddrSpaceCastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AddrSpaceCastInst.class, From.$deref());
  }

  public static AddrSpaceCastInst cast_AddrSpaceCastInst(type$ref<?>/*P*/ From) {
    assert isa_AddrSpaceCastInst(From);
    return llvm.cast(AddrSpaceCastInst.class, From.$deref());
  }

  public static AddrSpaceCastInst cast_or_null_AddrSpaceCastInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AddrSpaceCastInst(From);
  }

  public static AddrSpaceCastInst dyn_cast_AddrSpaceCastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static AddrSpaceCastInst dyn_cast_or_null_AddrSpaceCastInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static boolean isa_AddrSpaceCastInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AddrSpaceCastInst(From.get());
  }

  public static AddrSpaceCastInst cast_AddrSpaceCastInst(Use/*P*/ From) {
    return cast_AddrSpaceCastInst(From.get());
  }

  public static AddrSpaceCastInst cast_or_null_AddrSpaceCastInst(Use/*P*/ From) {
    return cast_or_null_AddrSpaceCastInst(From.get());
  }

  public static AddrSpaceCastInst dyn_cast_AddrSpaceCastInst(Use/*P*/ From) {
    return isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static AddrSpaceCastInst dyn_cast_or_null_AddrSpaceCastInst(Use/*P*/ From) {
    return (From != null) && isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static boolean isa_AddrSpaceCastInst(Value/*P*/ From) {
    assert From != null;
    return AddrSpaceCastInst.classof(From);
  }

  public static AddrSpaceCastInst cast_AddrSpaceCastInst(Value/*P*/ From) {
    assert isa_AddrSpaceCastInst(From);
    return (AddrSpaceCastInst) From;
  }

  public static AddrSpaceCastInst cast_or_null_AddrSpaceCastInst(Value/*P*/ From) {
    return (From == null) ? null : cast_AddrSpaceCastInst(From);
  }

  public static AddrSpaceCastInst dyn_cast_AddrSpaceCastInst(Value/*P*/ From) {
    assert From != null;
    return isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static AddrSpaceCastInst dyn_cast_or_null_AddrSpaceCastInst(Value/*P*/ From) {
    return (From != null) && isa_AddrSpaceCastInst(From) ? cast_AddrSpaceCastInst(From) : null;
  }

  public static boolean isa_AliasSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AliasSummary.class, From.$star());
  }

  public static AliasSummary cast_AliasSummary(type$ptr<?>/*P*/ From) {
    assert isa_AliasSummary(From);
    return llvm.cast(AliasSummary.class, From.$star());
  }

  public static AliasSummary cast_or_null_AliasSummary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AliasSummary(From);
  }

  public static AliasSummary dyn_cast_AliasSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static AliasSummary dyn_cast_or_null_AliasSummary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static boolean isa_AliasSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AliasSummary.class, From.$deref());
  }

  public static AliasSummary cast_AliasSummary(type$ref<?>/*P*/ From) {
    assert isa_AliasSummary(From);
    return llvm.cast(AliasSummary.class, From.$deref());
  }

  public static AliasSummary cast_or_null_AliasSummary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AliasSummary(From);
  }

  public static AliasSummary dyn_cast_AliasSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static AliasSummary dyn_cast_or_null_AliasSummary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static boolean isa_AliasSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return AliasSummary.classof(From);
  }

  public static AliasSummary cast_AliasSummary(GlobalValueSummary/*P*/ From) {
    assert isa_AliasSummary(From);
    return (AliasSummary) From;
  }

  public static AliasSummary cast_or_null_AliasSummary(GlobalValueSummary/*P*/ From) {
    return (From == null) ? null : cast_AliasSummary(From);
  }

  public static AliasSummary dyn_cast_AliasSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static AliasSummary dyn_cast_or_null_AliasSummary(GlobalValueSummary/*P*/ From) {
    return (From != null) && isa_AliasSummary(From) ? cast_AliasSummary(From) : null;
  }

  public static boolean isa_AllocaInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AllocaInst(From.get());
  }

  public static AllocaInst cast_AllocaInst(Use/*P*/ From) {
    return cast_AllocaInst(From.get());
  }

  public static AllocaInst cast_or_null_AllocaInst(Use/*P*/ From) {
    return cast_or_null_AllocaInst(From.get());
  }

  public static AllocaInst dyn_cast_AllocaInst(Use/*P*/ From) {
    return isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static AllocaInst dyn_cast_or_null_AllocaInst(Use/*P*/ From) {
    return (From != null) && isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static boolean isa_AllocaInst(Value/*P*/ From) {
    assert From != null;
    return AllocaInst.classof(From);
  }

  public static AllocaInst cast_AllocaInst(Value/*P*/ From) {
    assert isa_AllocaInst(From);
    return (AllocaInst) From;
  }

  public static AllocaInst cast_or_null_AllocaInst(Value/*P*/ From) {
    return (From == null) ? null : cast_AllocaInst(From);
  }

  public static AllocaInst dyn_cast_AllocaInst(Value/*P*/ From) {
    assert From != null;
    return isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static AllocaInst dyn_cast_or_null_AllocaInst(Value/*P*/ From) {
    return (From != null) && isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static boolean isa_AllocaInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AllocaInst.class, From.$star());
  }

  public static AllocaInst cast_AllocaInst(type$ptr<?>/*P*/ From) {
    assert isa_AllocaInst(From);
    return llvm.cast(AllocaInst.class, From.$star());
  }

  public static AllocaInst cast_or_null_AllocaInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AllocaInst(From);
  }

  public static AllocaInst dyn_cast_AllocaInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static AllocaInst dyn_cast_or_null_AllocaInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static boolean isa_AllocaInst(Instruction/*P*/ From) {
    assert From != null;
    return AllocaInst.classof(From);
  }

  public static AllocaInst cast_AllocaInst(Instruction/*P*/ From) {
    assert isa_AllocaInst(From);
    return llvm.cast(AllocaInst.class, From);
  }

  public static AllocaInst cast_or_null_AllocaInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AllocaInst(From);
  }

  public static AllocaInst dyn_cast_AllocaInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static AllocaInst dyn_cast_or_null_AllocaInst(Instruction/*P*/ From) {
    return (From != null) && isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static boolean isa_AllocaInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AllocaInst.class, From.$deref());
  }

  public static AllocaInst cast_AllocaInst(type$ref<?>/*P*/ From) {
    assert isa_AllocaInst(From);
    return llvm.cast(AllocaInst.class, From.$deref());
  }

  public static AllocaInst cast_or_null_AllocaInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AllocaInst(From);
  }

  public static AllocaInst dyn_cast_AllocaInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static AllocaInst dyn_cast_or_null_AllocaInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AllocaInst(From) ? cast_AllocaInst(From) : null;
  }

  public static boolean isa_Argument(Value/*P*/ From) {
    assert From != null;
    return Argument.classof(From);
  }

  public static Argument cast_Argument(Value/*P*/ From) {
    assert isa_Argument(From);
    return (Argument) From;
  }

  public static Argument cast_or_null_Argument(Value/*P*/ From) {
    return (From == null) ? null : cast_Argument(From);
  }

  public static Argument dyn_cast_Argument(Value/*P*/ From) {
    assert From != null;
    return isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static Argument dyn_cast_or_null_Argument(Value/*P*/ From) {
    return (From != null) && isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static boolean isa_Argument(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Argument(From.get());
  }

  public static Argument cast_Argument(Use/*P*/ From) {
    return cast_Argument(From.get());
  }

  public static Argument cast_or_null_Argument(Use/*P*/ From) {
    return cast_or_null_Argument(From.get());
  }

  public static Argument dyn_cast_Argument(Use/*P*/ From) {
    return isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static Argument dyn_cast_or_null_Argument(Use/*P*/ From) {
    return (From != null) && isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static boolean isa_Argument(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Argument.class, From.$deref());
  }

  public static Argument cast_Argument(type$ref<?>/*P*/ From) {
    assert isa_Argument(From);
    return llvm.cast(Argument.class, From.$deref());
  }

  public static Argument cast_or_null_Argument(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Argument(From);
  }

  public static Argument dyn_cast_Argument(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static Argument dyn_cast_or_null_Argument(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static boolean isa_Argument(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Argument.class, From.$star());
  }

  public static Argument cast_Argument(type$ptr<?>/*P*/ From) {
    assert isa_Argument(From);
    return llvm.cast(Argument.class, From.$star());
  }

  public static Argument cast_or_null_Argument(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Argument(From);
  }

  public static Argument dyn_cast_Argument(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static Argument dyn_cast_or_null_Argument(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Argument(From) ? cast_Argument(From) : null;
  }

  public static boolean isa_ArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArrayType.class, From.$deref());
  }

  public static ArrayType cast_ArrayType(type$ref<?>/*P*/ From) {
    assert isa_ArrayType(From);
    return llvm.cast(ArrayType.class, From.$deref());
  }

  public static ArrayType cast_or_null_ArrayType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(Type/*P*/ From) {
    assert From != null;
    return ArrayType.classof(From);
  }

  public static ArrayType cast_ArrayType(Type/*P*/ From) {
    assert isa_ArrayType(From);
    return (ArrayType) From;
  }

  public static ArrayType cast_or_null_ArrayType(Type/*P*/ From) {
    return (From == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(Type/*P*/ From) {
    assert From != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(Type/*P*/ From) {
    return (From != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_ArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArrayType.class, From.$star());
  }

  public static ArrayType cast_ArrayType(type$ptr<?>/*P*/ From) {
    assert isa_ArrayType(From);
    return llvm.cast(ArrayType.class, From.$star());
  }

  public static ArrayType cast_or_null_ArrayType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArrayType(From);
  }

  public static ArrayType dyn_cast_ArrayType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static ArrayType dyn_cast_or_null_ArrayType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArrayType(From) ? cast_ArrayType(From) : null;
  }

  public static boolean isa_AtomicCmpXchgInst(Value/*P*/ From) {
    assert From != null;
    return AtomicCmpXchgInst.classof(From);
  }

  public static AtomicCmpXchgInst cast_AtomicCmpXchgInst(Value/*P*/ From) {
    assert isa_AtomicCmpXchgInst(From);
    return (AtomicCmpXchgInst) From;
  }

  public static AtomicCmpXchgInst cast_or_null_AtomicCmpXchgInst(Value/*P*/ From) {
    return (From == null) ? null : cast_AtomicCmpXchgInst(From);
  }

  public static AtomicCmpXchgInst dyn_cast_AtomicCmpXchgInst(Value/*P*/ From) {
    assert From != null;
    return isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static AtomicCmpXchgInst dyn_cast_or_null_AtomicCmpXchgInst(Value/*P*/ From) {
    return (From != null) && isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static boolean isa_AtomicCmpXchgInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AtomicCmpXchgInst(From.get());
  }

  public static AtomicCmpXchgInst cast_AtomicCmpXchgInst(Use/*P*/ From) {
    return cast_AtomicCmpXchgInst(From.get());
  }

  public static AtomicCmpXchgInst cast_or_null_AtomicCmpXchgInst(Use/*P*/ From) {
    return cast_or_null_AtomicCmpXchgInst(From.get());
  }

  public static AtomicCmpXchgInst dyn_cast_AtomicCmpXchgInst(Use/*P*/ From) {
    return isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static AtomicCmpXchgInst dyn_cast_or_null_AtomicCmpXchgInst(Use/*P*/ From) {
    return (From != null) && isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static boolean isa_AtomicCmpXchgInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AtomicCmpXchgInst.class, From.$star());
  }

  public static AtomicCmpXchgInst cast_AtomicCmpXchgInst(type$ptr<?>/*P*/ From) {
    assert isa_AtomicCmpXchgInst(From);
    return llvm.cast(AtomicCmpXchgInst.class, From.$star());
  }

  public static AtomicCmpXchgInst cast_or_null_AtomicCmpXchgInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AtomicCmpXchgInst(From);
  }

  public static AtomicCmpXchgInst dyn_cast_AtomicCmpXchgInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static AtomicCmpXchgInst dyn_cast_or_null_AtomicCmpXchgInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static boolean isa_AtomicCmpXchgInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AtomicCmpXchgInst.class, From.$deref());
  }

  public static AtomicCmpXchgInst cast_AtomicCmpXchgInst(type$ref<?>/*P*/ From) {
    assert isa_AtomicCmpXchgInst(From);
    return llvm.cast(AtomicCmpXchgInst.class, From.$deref());
  }

  public static AtomicCmpXchgInst cast_or_null_AtomicCmpXchgInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AtomicCmpXchgInst(From);
  }

  public static AtomicCmpXchgInst dyn_cast_AtomicCmpXchgInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static AtomicCmpXchgInst dyn_cast_or_null_AtomicCmpXchgInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static boolean isa_AtomicCmpXchgInst(Instruction/*P*/ From) {
    assert From != null;
    return AtomicCmpXchgInst.classof(From);
  }

  public static AtomicCmpXchgInst cast_AtomicCmpXchgInst(Instruction/*P*/ From) {
    assert isa_AtomicCmpXchgInst(From);
    return llvm.cast(AtomicCmpXchgInst.class, From);
  }

  public static AtomicCmpXchgInst cast_or_null_AtomicCmpXchgInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AtomicCmpXchgInst(From);
  }

  public static AtomicCmpXchgInst dyn_cast_AtomicCmpXchgInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static AtomicCmpXchgInst dyn_cast_or_null_AtomicCmpXchgInst(Instruction/*P*/ From) {
    return (From != null) && isa_AtomicCmpXchgInst(From) ? cast_AtomicCmpXchgInst(From) : null;
  }

  public static boolean isa_AtomicRMWInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_AtomicRMWInst(From.get());
  }

  public static AtomicRMWInst cast_AtomicRMWInst(Use/*P*/ From) {
    return cast_AtomicRMWInst(From.get());
  }

  public static AtomicRMWInst cast_or_null_AtomicRMWInst(Use/*P*/ From) {
    return cast_or_null_AtomicRMWInst(From.get());
  }

  public static AtomicRMWInst dyn_cast_AtomicRMWInst(Use/*P*/ From) {
    return isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static AtomicRMWInst dyn_cast_or_null_AtomicRMWInst(Use/*P*/ From) {
    return (From != null) && isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static boolean isa_AtomicRMWInst(Value/*P*/ From) {
    assert From != null;
    return AtomicRMWInst.classof(From);
  }

  public static AtomicRMWInst cast_AtomicRMWInst(Value/*P*/ From) {
    assert isa_AtomicRMWInst(From);
    return (AtomicRMWInst) From;
  }

  public static AtomicRMWInst cast_or_null_AtomicRMWInst(Value/*P*/ From) {
    return (From == null) ? null : cast_AtomicRMWInst(From);
  }

  public static AtomicRMWInst dyn_cast_AtomicRMWInst(Value/*P*/ From) {
    assert From != null;
    return isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static AtomicRMWInst dyn_cast_or_null_AtomicRMWInst(Value/*P*/ From) {
    return (From != null) && isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static boolean isa_AtomicRMWInst(Instruction/*P*/ From) {
    assert From != null;
    return AtomicRMWInst.classof(From);
  }

  public static AtomicRMWInst cast_AtomicRMWInst(Instruction/*P*/ From) {
    assert isa_AtomicRMWInst(From);
    return llvm.cast(AtomicRMWInst.class, From);
  }

  public static AtomicRMWInst cast_or_null_AtomicRMWInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_AtomicRMWInst(From);
  }

  public static AtomicRMWInst dyn_cast_AtomicRMWInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static AtomicRMWInst dyn_cast_or_null_AtomicRMWInst(Instruction/*P*/ From) {
    return (From != null) && isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static boolean isa_AtomicRMWInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AtomicRMWInst.class, From.$deref());
  }

  public static AtomicRMWInst cast_AtomicRMWInst(type$ref<?>/*P*/ From) {
    assert isa_AtomicRMWInst(From);
    return llvm.cast(AtomicRMWInst.class, From.$deref());
  }

  public static AtomicRMWInst cast_or_null_AtomicRMWInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AtomicRMWInst(From);
  }

  public static AtomicRMWInst dyn_cast_AtomicRMWInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static AtomicRMWInst dyn_cast_or_null_AtomicRMWInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static boolean isa_AtomicRMWInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AtomicRMWInst.class, From.$star());
  }

  public static AtomicRMWInst cast_AtomicRMWInst(type$ptr<?>/*P*/ From) {
    assert isa_AtomicRMWInst(From);
    return llvm.cast(AtomicRMWInst.class, From.$star());
  }

  public static AtomicRMWInst cast_or_null_AtomicRMWInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AtomicRMWInst(From);
  }

  public static AtomicRMWInst dyn_cast_AtomicRMWInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
  }

  public static AtomicRMWInst dyn_cast_or_null_AtomicRMWInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AtomicRMWInst(From) ? cast_AtomicRMWInst(From) : null;
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

  public static boolean isa_BasicBlock(Value/*P*/ From) {
    assert From != null;
    return BasicBlock.classof(From);
  }

  public static BasicBlock cast_BasicBlock(Value/*P*/ From) {
    assert isa_BasicBlock(From);
    return (BasicBlock) From;
  }

  public static BasicBlock cast_or_null_BasicBlock(Value/*P*/ From) {
    return (From == null) ? null : cast_BasicBlock(From);
  }

  public static BasicBlock dyn_cast_BasicBlock(Value/*P*/ From) {
    assert From != null;
    return isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static BasicBlock dyn_cast_or_null_BasicBlock(Value/*P*/ From) {
    return (From != null) && isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static boolean isa_BasicBlock(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BasicBlock(From.get());
  }

  public static BasicBlock cast_BasicBlock(Use/*P*/ From) {
    return cast_BasicBlock(From.get());
  }

  public static BasicBlock cast_or_null_BasicBlock(Use/*P*/ From) {
    return cast_or_null_BasicBlock(From.get());
  }

  public static BasicBlock dyn_cast_BasicBlock(Use/*P*/ From) {
    return isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
  }

  public static BasicBlock dyn_cast_or_null_BasicBlock(Use/*P*/ From) {
    return (From != null) && isa_BasicBlock(From) ? cast_BasicBlock(From) : null;
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

  public static boolean isa_BinaryOperator(Value/*P*/ From) {
    assert From != null;
    return BinaryOperator.classof(From);
  }

  public static BinaryOperator cast_BinaryOperator(Value/*P*/ From) {
    assert isa_BinaryOperator(From);
    return (BinaryOperator) From;
  }

  public static BinaryOperator cast_or_null_BinaryOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(Value/*P*/ From) {
    assert From != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(Value/*P*/ From) {
    return (From != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BinaryOperator(From.get());
  }

  public static BinaryOperator cast_BinaryOperator(Use/*P*/ From) {
    return cast_BinaryOperator(From.get());
  }

  public static BinaryOperator cast_or_null_BinaryOperator(Use/*P*/ From) {
    return cast_or_null_BinaryOperator(From.get());
  }

  public static BinaryOperator dyn_cast_BinaryOperator(Use/*P*/ From) {
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(Use/*P*/ From) {
    return (From != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinaryOperator.class, From.$deref());
  }

  public static BinaryOperator cast_BinaryOperator(type$ref<?>/*P*/ From) {
    assert isa_BinaryOperator(From);
    return llvm.cast(BinaryOperator.class, From.$deref());
  }

  public static BinaryOperator cast_or_null_BinaryOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinaryOperator.class, From.$star());
  }

  public static BinaryOperator cast_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert isa_BinaryOperator(From);
    return llvm.cast(BinaryOperator.class, From.$star());
  }

  public static BinaryOperator cast_or_null_BinaryOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BinaryOperator(Instruction/*P*/ From) {
    assert From != null;
    return BinaryOperator.classof(From);
  }

  public static BinaryOperator cast_BinaryOperator(Instruction/*P*/ From) {
    assert isa_BinaryOperator(From);
    return llvm.cast(BinaryOperator.class, From);
  }

  public static BinaryOperator cast_or_null_BinaryOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_BinaryOperator(From);
  }

  public static BinaryOperator dyn_cast_BinaryOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static BinaryOperator dyn_cast_or_null_BinaryOperator(Instruction/*P*/ From) {
    return (From != null) && isa_BinaryOperator(From) ? cast_BinaryOperator(From) : null;
  }

  public static boolean isa_BitCastInst(Instruction/*P*/ From) {
    assert From != null;
    return BitCastInst.classof(From);
  }

  public static BitCastInst cast_BitCastInst(Instruction/*P*/ From) {
    assert isa_BitCastInst(From);
    return llvm.cast(BitCastInst.class, From);
  }

  public static BitCastInst cast_or_null_BitCastInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_BitCastInst(From);
  }

  public static BitCastInst dyn_cast_BitCastInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static BitCastInst dyn_cast_or_null_BitCastInst(Instruction/*P*/ From) {
    return (From != null) && isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static boolean isa_BitCastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BitCastInst.class, From.$deref());
  }

  public static BitCastInst cast_BitCastInst(type$ref<?>/*P*/ From) {
    assert isa_BitCastInst(From);
    return llvm.cast(BitCastInst.class, From.$deref());
  }

  public static BitCastInst cast_or_null_BitCastInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BitCastInst(From);
  }

  public static BitCastInst dyn_cast_BitCastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static BitCastInst dyn_cast_or_null_BitCastInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static boolean isa_BitCastInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BitCastInst(From.get());
  }

  public static BitCastInst cast_BitCastInst(Use/*P*/ From) {
    return cast_BitCastInst(From.get());
  }

  public static BitCastInst cast_or_null_BitCastInst(Use/*P*/ From) {
    return cast_or_null_BitCastInst(From.get());
  }

  public static BitCastInst dyn_cast_BitCastInst(Use/*P*/ From) {
    return isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static BitCastInst dyn_cast_or_null_BitCastInst(Use/*P*/ From) {
    return (From != null) && isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static boolean isa_BitCastInst(Value/*P*/ From) {
    assert From != null;
    return BitCastInst.classof(From);
  }

  public static BitCastInst cast_BitCastInst(Value/*P*/ From) {
    assert isa_BitCastInst(From);
    return (BitCastInst) From;
  }

  public static BitCastInst cast_or_null_BitCastInst(Value/*P*/ From) {
    return (From == null) ? null : cast_BitCastInst(From);
  }

  public static BitCastInst dyn_cast_BitCastInst(Value/*P*/ From) {
    assert From != null;
    return isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static BitCastInst dyn_cast_or_null_BitCastInst(Value/*P*/ From) {
    return (From != null) && isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static boolean isa_BitCastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BitCastInst.class, From.$star());
  }

  public static BitCastInst cast_BitCastInst(type$ptr<?>/*P*/ From) {
    assert isa_BitCastInst(From);
    return llvm.cast(BitCastInst.class, From.$star());
  }

  public static BitCastInst cast_or_null_BitCastInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BitCastInst(From);
  }

  public static BitCastInst dyn_cast_BitCastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static BitCastInst dyn_cast_or_null_BitCastInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BitCastInst(From) ? cast_BitCastInst(From) : null;
  }

  public static boolean isa_BitCastOperator(Instruction/*P*/ From) {
    assert From != null;
    return BitCastOperator.classof(From);
  }

  public static BitCastOperator cast_BitCastOperator(Instruction/*P*/ From) {
    assert isa_BitCastOperator(From);
    return llvm.cast(BitCastOperator.class, From);
  }

  public static BitCastOperator cast_or_null_BitCastOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_BitCastOperator(From);
  }

  public static BitCastOperator dyn_cast_BitCastOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(Instruction/*P*/ From) {
    return (From != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BitCastOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BitCastOperator.class, From.$deref());
  }

  public static BitCastOperator cast_BitCastOperator(type$ref<?>/*P*/ From) {
    assert isa_BitCastOperator(From);
    return llvm.cast(BitCastOperator.class, From.$deref());
  }

  public static BitCastOperator cast_or_null_BitCastOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BitCastOperator(From);
  }

  public static BitCastOperator dyn_cast_BitCastOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BitCastOperator(Value/*P*/ From) {
    assert From != null;
    return BitCastOperator.classof(From);
  }

  public static BitCastOperator cast_BitCastOperator(Value/*P*/ From) {
    assert isa_BitCastOperator(From);
    return llvm.cast(BitCastOperator.class, From);
  }

  public static BitCastOperator cast_or_null_BitCastOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_BitCastOperator(From);
  }

  public static BitCastOperator dyn_cast_BitCastOperator(Value/*P*/ From) {
    assert From != null;
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(Value/*P*/ From) {
    return (From != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BitCastOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return BitCastOperator.classof(From);
  }

  public static BitCastOperator cast_BitCastOperator(ConstantExpr/*P*/ From) {
    assert isa_BitCastOperator(From);
    return llvm.cast(BitCastOperator.class, From);
  }

  public static BitCastOperator cast_or_null_BitCastOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_BitCastOperator(From);
  }

  public static BitCastOperator dyn_cast_BitCastOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BitCastOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BitCastOperator.class, From.$star());
  }

  public static BitCastOperator cast_BitCastOperator(type$ptr<?>/*P*/ From) {
    assert isa_BitCastOperator(From);
    return llvm.cast(BitCastOperator.class, From.$star());
  }

  public static BitCastOperator cast_or_null_BitCastOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BitCastOperator(From);
  }

  public static BitCastOperator dyn_cast_BitCastOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BitCastOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BitCastOperator(From.get());
  }

  public static BitCastOperator cast_BitCastOperator(Use/*P*/ From) {
    return cast_BitCastOperator(From.get());
  }

  public static BitCastOperator cast_or_null_BitCastOperator(Use/*P*/ From) {
    return cast_or_null_BitCastOperator(From.get());
  }

  public static BitCastOperator dyn_cast_BitCastOperator(Use/*P*/ From) {
    return isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static BitCastOperator dyn_cast_or_null_BitCastOperator(Use/*P*/ From) {
    return (From != null) && isa_BitCastOperator(From) ? cast_BitCastOperator(From) : null;
  }

  public static boolean isa_BlockAddress(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BlockAddress(From.get());
  }

  public static BlockAddress cast_BlockAddress(Use/*P*/ From) {
    return cast_BlockAddress(From.get());
  }

  public static BlockAddress cast_or_null_BlockAddress(Use/*P*/ From) {
    return cast_or_null_BlockAddress(From.get());
  }

  public static BlockAddress dyn_cast_BlockAddress(Use/*P*/ From) {
    return isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static BlockAddress dyn_cast_or_null_BlockAddress(Use/*P*/ From) {
    return (From != null) && isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static boolean isa_BlockAddress(Value/*P*/ From) {
    assert From != null;
    return BlockAddress.classof(From);
  }

  public static BlockAddress cast_BlockAddress(Value/*P*/ From) {
    assert isa_BlockAddress(From);
    return (BlockAddress) From;
  }

  public static BlockAddress cast_or_null_BlockAddress(Value/*P*/ From) {
    return (From == null) ? null : cast_BlockAddress(From);
  }

  public static BlockAddress dyn_cast_BlockAddress(Value/*P*/ From) {
    assert From != null;
    return isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static BlockAddress dyn_cast_or_null_BlockAddress(Value/*P*/ From) {
    return (From != null) && isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static boolean isa_BlockAddress(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlockAddress.class, From.$deref());
  }

  public static BlockAddress cast_BlockAddress(type$ref<?>/*P*/ From) {
    assert isa_BlockAddress(From);
    return llvm.cast(BlockAddress.class, From.$deref());
  }

  public static BlockAddress cast_or_null_BlockAddress(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlockAddress(From);
  }

  public static BlockAddress dyn_cast_BlockAddress(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static BlockAddress dyn_cast_or_null_BlockAddress(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static boolean isa_BlockAddress(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlockAddress.class, From.$star());
  }

  public static BlockAddress cast_BlockAddress(type$ptr<?>/*P*/ From) {
    assert isa_BlockAddress(From);
    return llvm.cast(BlockAddress.class, From.$star());
  }

  public static BlockAddress cast_or_null_BlockAddress(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlockAddress(From);
  }

  public static BlockAddress dyn_cast_BlockAddress(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static BlockAddress dyn_cast_or_null_BlockAddress(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlockAddress(From) ? cast_BlockAddress(From) : null;
  }

  public static boolean isa_BranchInst(Value/*P*/ From) {
    assert From != null;
    return BranchInst.classof(From);
  }

  public static BranchInst cast_BranchInst(Value/*P*/ From) {
    assert isa_BranchInst(From);
    return (BranchInst) From;
  }

  public static BranchInst cast_or_null_BranchInst(Value/*P*/ From) {
    return (From == null) ? null : cast_BranchInst(From);
  }

  public static BranchInst dyn_cast_BranchInst(Value/*P*/ From) {
    assert From != null;
    return isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static BranchInst dyn_cast_or_null_BranchInst(Value/*P*/ From) {
    return (From != null) && isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static boolean isa_BranchInst(Instruction/*P*/ From) {
    assert From != null;
    return BranchInst.classof(From);
  }

  public static BranchInst cast_BranchInst(Instruction/*P*/ From) {
    assert isa_BranchInst(From);
    return llvm.cast(BranchInst.class, From);
  }

  public static BranchInst cast_or_null_BranchInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_BranchInst(From);
  }

  public static BranchInst dyn_cast_BranchInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static BranchInst dyn_cast_or_null_BranchInst(Instruction/*P*/ From) {
    return (From != null) && isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static boolean isa_BranchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BranchInst.class, From.$star());
  }

  public static BranchInst cast_BranchInst(type$ptr<?>/*P*/ From) {
    assert isa_BranchInst(From);
    return llvm.cast(BranchInst.class, From.$star());
  }

  public static BranchInst cast_or_null_BranchInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BranchInst(From);
  }

  public static BranchInst dyn_cast_BranchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static BranchInst dyn_cast_or_null_BranchInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static boolean isa_BranchInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BranchInst(From.get());
  }

  public static BranchInst cast_BranchInst(Use/*P*/ From) {
    return cast_BranchInst(From.get());
  }

  public static BranchInst cast_or_null_BranchInst(Use/*P*/ From) {
    return cast_or_null_BranchInst(From.get());
  }

  public static BranchInst dyn_cast_BranchInst(Use/*P*/ From) {
    return isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static BranchInst dyn_cast_or_null_BranchInst(Use/*P*/ From) {
    return (From != null) && isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static boolean isa_BranchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BranchInst.class, From.$deref());
  }

  public static BranchInst cast_BranchInst(type$ref<?>/*P*/ From) {
    assert isa_BranchInst(From);
    return llvm.cast(BranchInst.class, From.$deref());
  }

  public static BranchInst cast_or_null_BranchInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BranchInst(From);
  }

  public static BranchInst dyn_cast_BranchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static BranchInst dyn_cast_or_null_BranchInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BranchInst(From) ? cast_BranchInst(From) : null;
  }

  public static boolean isa_CallInst(Value/*P*/ From) {
    assert From != null;
    return CallInst.classof(From);
  }

  public static CallInst cast_CallInst(Value/*P*/ From) {
    assert isa_CallInst(From);
    return (CallInst) From;
  }

  public static CallInst cast_or_null_CallInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CallInst(From);
  }

  public static CallInst dyn_cast_CallInst(Value/*P*/ From) {
    assert From != null;
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(Value/*P*/ From) {
    return (From != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CallInst(CallInst/*P*/ From) {
    assert From != null;
    return true;
  }

  public static CallInst cast_CallInst(CallInst/*P*/ From) {
    assert isa_CallInst(From);
    return (CallInst) From;
  }

  public static CallInst cast_or_null_CallInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_CallInst(From);
  }

  public static CallInst dyn_cast_CallInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(CallInst/*P*/ From) {
    return (From != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CallInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CallInst.class, From.$deref());
  }

  public static CallInst cast_CallInst(type$ref<?>/*P*/ From) {
    assert isa_CallInst(From);
    return llvm.cast(CallInst.class, From.$deref());
  }

  public static CallInst cast_or_null_CallInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CallInst(From);
  }

  public static CallInst dyn_cast_CallInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CallInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CallInst(From.get());
  }

  public static CallInst cast_CallInst(Use/*P*/ From) {
    return cast_CallInst(From.get());
  }

  public static CallInst cast_or_null_CallInst(Use/*P*/ From) {
    return cast_or_null_CallInst(From.get());
  }

  public static CallInst dyn_cast_CallInst(Use/*P*/ From) {
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(Use/*P*/ From) {
    return (From != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CallInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CallInst.class, From.$star());
  }

  public static CallInst cast_CallInst(type$ptr<?>/*P*/ From) {
    assert isa_CallInst(From);
    return llvm.cast(CallInst.class, From.$star());
  }

  public static CallInst cast_or_null_CallInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CallInst(From);
  }

  public static CallInst dyn_cast_CallInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CallInst(Instruction/*P*/ From) {
    assert From != null;
    return CallInst.classof(From);
  }

  public static CallInst cast_CallInst(Instruction/*P*/ From) {
    assert isa_CallInst(From);
    return llvm.cast(CallInst.class, From);
  }

  public static CallInst cast_or_null_CallInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CallInst(From);
  }

  public static CallInst dyn_cast_CallInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static CallInst dyn_cast_or_null_CallInst(Instruction/*P*/ From) {
    return (From != null) && isa_CallInst(From) ? cast_CallInst(From) : null;
  }

  public static boolean isa_CastInst(Instruction/*P*/ From) {
    assert From != null;
    return CastInst.classof(From);
  }

  public static CastInst cast_CastInst(Instruction/*P*/ From) {
    assert isa_CastInst(From);
    return llvm.cast(CastInst.class, From);
  }

  public static CastInst cast_or_null_CastInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CastInst(From);
  }

  public static CastInst dyn_cast_CastInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static CastInst dyn_cast_or_null_CastInst(Instruction/*P*/ From) {
    return (From != null) && isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static boolean isa_CastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CastInst.class, From.$deref());
  }

  public static CastInst cast_CastInst(type$ref<?>/*P*/ From) {
    assert isa_CastInst(From);
    return llvm.cast(CastInst.class, From.$deref());
  }

  public static CastInst cast_or_null_CastInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CastInst(From);
  }

  public static CastInst dyn_cast_CastInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static CastInst dyn_cast_or_null_CastInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static boolean isa_CastInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CastInst(From.get());
  }

  public static CastInst cast_CastInst(Use/*P*/ From) {
    return cast_CastInst(From.get());
  }

  public static CastInst cast_or_null_CastInst(Use/*P*/ From) {
    return cast_or_null_CastInst(From.get());
  }

  public static CastInst dyn_cast_CastInst(Use/*P*/ From) {
    return isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static CastInst dyn_cast_or_null_CastInst(Use/*P*/ From) {
    return (From != null) && isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static boolean isa_CastInst(Value/*P*/ From) {
    assert From != null;
    return CastInst.classof(From);
  }

  public static CastInst cast_CastInst(Value/*P*/ From) {
    assert isa_CastInst(From);
    return (CastInst) From;
  }

  public static CastInst cast_or_null_CastInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CastInst(From);
  }

  public static CastInst dyn_cast_CastInst(Value/*P*/ From) {
    assert From != null;
    return isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static CastInst dyn_cast_or_null_CastInst(Value/*P*/ From) {
    return (From != null) && isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static boolean isa_CastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CastInst.class, From.$star());
  }

  public static CastInst cast_CastInst(type$ptr<?>/*P*/ From) {
    assert isa_CastInst(From);
    return llvm.cast(CastInst.class, From.$star());
  }

  public static CastInst cast_or_null_CastInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CastInst(From);
  }

  public static CastInst dyn_cast_CastInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static CastInst dyn_cast_or_null_CastInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CastInst(From) ? cast_CastInst(From) : null;
  }

  public static boolean isa_CatchPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CatchPadInst.class, From.$star());
  }

  public static CatchPadInst cast_CatchPadInst(type$ptr<?>/*P*/ From) {
    assert isa_CatchPadInst(From);
    return llvm.cast(CatchPadInst.class, From.$star());
  }

  public static CatchPadInst cast_or_null_CatchPadInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CatchPadInst(From);
  }

  public static CatchPadInst dyn_cast_CatchPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static CatchPadInst dyn_cast_or_null_CatchPadInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static boolean isa_CatchPadInst(Value/*P*/ From) {
    assert From != null;
    return CatchPadInst.classof(From);
  }

  public static CatchPadInst cast_CatchPadInst(Value/*P*/ From) {
    assert isa_CatchPadInst(From);
    return (CatchPadInst) From;
  }

  public static CatchPadInst cast_or_null_CatchPadInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CatchPadInst(From);
  }

  public static CatchPadInst dyn_cast_CatchPadInst(Value/*P*/ From) {
    assert From != null;
    return isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static CatchPadInst dyn_cast_or_null_CatchPadInst(Value/*P*/ From) {
    return (From != null) && isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static boolean isa_CatchPadInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CatchPadInst(From.get());
  }

  public static CatchPadInst cast_CatchPadInst(Use/*P*/ From) {
    return cast_CatchPadInst(From.get());
  }

  public static CatchPadInst cast_or_null_CatchPadInst(Use/*P*/ From) {
    return cast_or_null_CatchPadInst(From.get());
  }

  public static CatchPadInst dyn_cast_CatchPadInst(Use/*P*/ From) {
    return isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static CatchPadInst dyn_cast_or_null_CatchPadInst(Use/*P*/ From) {
    return (From != null) && isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static boolean isa_CatchPadInst(Instruction/*P*/ From) {
    assert From != null;
    return CatchPadInst.classof(From);
  }

  public static CatchPadInst cast_CatchPadInst(Instruction/*P*/ From) {
    assert isa_CatchPadInst(From);
    return llvm.cast(CatchPadInst.class, From);
  }

  public static CatchPadInst cast_or_null_CatchPadInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CatchPadInst(From);
  }

  public static CatchPadInst dyn_cast_CatchPadInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static CatchPadInst dyn_cast_or_null_CatchPadInst(Instruction/*P*/ From) {
    return (From != null) && isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static boolean isa_CatchPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CatchPadInst.class, From.$deref());
  }

  public static CatchPadInst cast_CatchPadInst(type$ref<?>/*P*/ From) {
    assert isa_CatchPadInst(From);
    return llvm.cast(CatchPadInst.class, From.$deref());
  }

  public static CatchPadInst cast_or_null_CatchPadInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CatchPadInst(From);
  }

  public static CatchPadInst dyn_cast_CatchPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static CatchPadInst dyn_cast_or_null_CatchPadInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CatchPadInst(From) ? cast_CatchPadInst(From) : null;
  }

  public static boolean isa_CatchReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CatchReturnInst.class, From.$deref());
  }

  public static CatchReturnInst cast_CatchReturnInst(type$ref<?>/*P*/ From) {
    assert isa_CatchReturnInst(From);
    return llvm.cast(CatchReturnInst.class, From.$deref());
  }

  public static CatchReturnInst cast_or_null_CatchReturnInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CatchReturnInst(From);
  }

  public static CatchReturnInst dyn_cast_CatchReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static CatchReturnInst dyn_cast_or_null_CatchReturnInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static boolean isa_CatchReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CatchReturnInst.class, From.$star());
  }

  public static CatchReturnInst cast_CatchReturnInst(type$ptr<?>/*P*/ From) {
    assert isa_CatchReturnInst(From);
    return llvm.cast(CatchReturnInst.class, From.$star());
  }

  public static CatchReturnInst cast_or_null_CatchReturnInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CatchReturnInst(From);
  }

  public static CatchReturnInst dyn_cast_CatchReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static CatchReturnInst dyn_cast_or_null_CatchReturnInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static boolean isa_CatchReturnInst(Value/*P*/ From) {
    assert From != null;
    return CatchReturnInst.classof(From);
  }

  public static CatchReturnInst cast_CatchReturnInst(Value/*P*/ From) {
    assert isa_CatchReturnInst(From);
    return (CatchReturnInst) From;
  }

  public static CatchReturnInst cast_or_null_CatchReturnInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CatchReturnInst(From);
  }

  public static CatchReturnInst dyn_cast_CatchReturnInst(Value/*P*/ From) {
    assert From != null;
    return isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static CatchReturnInst dyn_cast_or_null_CatchReturnInst(Value/*P*/ From) {
    return (From != null) && isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static boolean isa_CatchReturnInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CatchReturnInst(From.get());
  }

  public static CatchReturnInst cast_CatchReturnInst(Use/*P*/ From) {
    return cast_CatchReturnInst(From.get());
  }

  public static CatchReturnInst cast_or_null_CatchReturnInst(Use/*P*/ From) {
    return cast_or_null_CatchReturnInst(From.get());
  }

  public static CatchReturnInst dyn_cast_CatchReturnInst(Use/*P*/ From) {
    return isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static CatchReturnInst dyn_cast_or_null_CatchReturnInst(Use/*P*/ From) {
    return (From != null) && isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static boolean isa_CatchReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return CatchReturnInst.classof(From);
  }

  public static CatchReturnInst cast_CatchReturnInst(Instruction/*P*/ From) {
    assert isa_CatchReturnInst(From);
    return llvm.cast(CatchReturnInst.class, From);
  }

  public static CatchReturnInst cast_or_null_CatchReturnInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CatchReturnInst(From);
  }

  public static CatchReturnInst dyn_cast_CatchReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static CatchReturnInst dyn_cast_or_null_CatchReturnInst(Instruction/*P*/ From) {
    return (From != null) && isa_CatchReturnInst(From) ? cast_CatchReturnInst(From) : null;
  }

  public static boolean isa_CatchSwitchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CatchSwitchInst.class, From.$deref());
  }

  public static CatchSwitchInst cast_CatchSwitchInst(type$ref<?>/*P*/ From) {
    assert isa_CatchSwitchInst(From);
    return llvm.cast(CatchSwitchInst.class, From.$deref());
  }

  public static CatchSwitchInst cast_or_null_CatchSwitchInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CatchSwitchInst(From);
  }

  public static CatchSwitchInst dyn_cast_CatchSwitchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static CatchSwitchInst dyn_cast_or_null_CatchSwitchInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static boolean isa_CatchSwitchInst(Instruction/*P*/ From) {
    assert From != null;
    return CatchSwitchInst.classof(From);
  }

  public static CatchSwitchInst cast_CatchSwitchInst(Instruction/*P*/ From) {
    assert isa_CatchSwitchInst(From);
    return llvm.cast(CatchSwitchInst.class, From);
  }

  public static CatchSwitchInst cast_or_null_CatchSwitchInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CatchSwitchInst(From);
  }

  public static CatchSwitchInst dyn_cast_CatchSwitchInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static CatchSwitchInst dyn_cast_or_null_CatchSwitchInst(Instruction/*P*/ From) {
    return (From != null) && isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static boolean isa_CatchSwitchInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CatchSwitchInst(From.get());
  }

  public static CatchSwitchInst cast_CatchSwitchInst(Use/*P*/ From) {
    return cast_CatchSwitchInst(From.get());
  }

  public static CatchSwitchInst cast_or_null_CatchSwitchInst(Use/*P*/ From) {
    return cast_or_null_CatchSwitchInst(From.get());
  }

  public static CatchSwitchInst dyn_cast_CatchSwitchInst(Use/*P*/ From) {
    return isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static CatchSwitchInst dyn_cast_or_null_CatchSwitchInst(Use/*P*/ From) {
    return (From != null) && isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static boolean isa_CatchSwitchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CatchSwitchInst.class, From.$star());
  }

  public static CatchSwitchInst cast_CatchSwitchInst(type$ptr<?>/*P*/ From) {
    assert isa_CatchSwitchInst(From);
    return llvm.cast(CatchSwitchInst.class, From.$star());
  }

  public static CatchSwitchInst cast_or_null_CatchSwitchInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CatchSwitchInst(From);
  }

  public static CatchSwitchInst dyn_cast_CatchSwitchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static CatchSwitchInst dyn_cast_or_null_CatchSwitchInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static boolean isa_CatchSwitchInst(Value/*P*/ From) {
    assert From != null;
    return CatchSwitchInst.classof(From);
  }

  public static CatchSwitchInst cast_CatchSwitchInst(Value/*P*/ From) {
    assert isa_CatchSwitchInst(From);
    return (CatchSwitchInst) From;
  }

  public static CatchSwitchInst cast_or_null_CatchSwitchInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CatchSwitchInst(From);
  }

  public static CatchSwitchInst dyn_cast_CatchSwitchInst(Value/*P*/ From) {
    assert From != null;
    return isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static CatchSwitchInst dyn_cast_or_null_CatchSwitchInst(Value/*P*/ From) {
    return (From != null) && isa_CatchSwitchInst(From) ? cast_CatchSwitchInst(From) : null;
  }

  public static boolean isa_CleanupPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CleanupPadInst.class, From.$deref());
  }

  public static CleanupPadInst cast_CleanupPadInst(type$ref<?>/*P*/ From) {
    assert isa_CleanupPadInst(From);
    return llvm.cast(CleanupPadInst.class, From.$deref());
  }

  public static CleanupPadInst cast_or_null_CleanupPadInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CleanupPadInst(From);
  }

  public static CleanupPadInst dyn_cast_CleanupPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static CleanupPadInst dyn_cast_or_null_CleanupPadInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static boolean isa_CleanupPadInst(Instruction/*P*/ From) {
    assert From != null;
    return CleanupPadInst.classof(From);
  }

  public static CleanupPadInst cast_CleanupPadInst(Instruction/*P*/ From) {
    assert isa_CleanupPadInst(From);
    return llvm.cast(CleanupPadInst.class, From);
  }

  public static CleanupPadInst cast_or_null_CleanupPadInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CleanupPadInst(From);
  }

  public static CleanupPadInst dyn_cast_CleanupPadInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static CleanupPadInst dyn_cast_or_null_CleanupPadInst(Instruction/*P*/ From) {
    return (From != null) && isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static boolean isa_CleanupPadInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CleanupPadInst(From.get());
  }

  public static CleanupPadInst cast_CleanupPadInst(Use/*P*/ From) {
    return cast_CleanupPadInst(From.get());
  }

  public static CleanupPadInst cast_or_null_CleanupPadInst(Use/*P*/ From) {
    return cast_or_null_CleanupPadInst(From.get());
  }

  public static CleanupPadInst dyn_cast_CleanupPadInst(Use/*P*/ From) {
    return isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static CleanupPadInst dyn_cast_or_null_CleanupPadInst(Use/*P*/ From) {
    return (From != null) && isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static boolean isa_CleanupPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CleanupPadInst.class, From.$star());
  }

  public static CleanupPadInst cast_CleanupPadInst(type$ptr<?>/*P*/ From) {
    assert isa_CleanupPadInst(From);
    return llvm.cast(CleanupPadInst.class, From.$star());
  }

  public static CleanupPadInst cast_or_null_CleanupPadInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CleanupPadInst(From);
  }

  public static CleanupPadInst dyn_cast_CleanupPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static CleanupPadInst dyn_cast_or_null_CleanupPadInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static boolean isa_CleanupPadInst(Value/*P*/ From) {
    assert From != null;
    return CleanupPadInst.classof(From);
  }

  public static CleanupPadInst cast_CleanupPadInst(Value/*P*/ From) {
    assert isa_CleanupPadInst(From);
    return (CleanupPadInst) From;
  }

  public static CleanupPadInst cast_or_null_CleanupPadInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CleanupPadInst(From);
  }

  public static CleanupPadInst dyn_cast_CleanupPadInst(Value/*P*/ From) {
    assert From != null;
    return isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static CleanupPadInst dyn_cast_or_null_CleanupPadInst(Value/*P*/ From) {
    return (From != null) && isa_CleanupPadInst(From) ? cast_CleanupPadInst(From) : null;
  }

  public static boolean isa_CleanupReturnInst(Value/*P*/ From) {
    assert From != null;
    return CleanupReturnInst.classof(From);
  }

  public static CleanupReturnInst cast_CleanupReturnInst(Value/*P*/ From) {
    assert isa_CleanupReturnInst(From);
    return (CleanupReturnInst) From;
  }

  public static CleanupReturnInst cast_or_null_CleanupReturnInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CleanupReturnInst(From);
  }

  public static CleanupReturnInst dyn_cast_CleanupReturnInst(Value/*P*/ From) {
    assert From != null;
    return isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static CleanupReturnInst dyn_cast_or_null_CleanupReturnInst(Value/*P*/ From) {
    return (From != null) && isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static boolean isa_CleanupReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CleanupReturnInst.class, From.$star());
  }

  public static CleanupReturnInst cast_CleanupReturnInst(type$ptr<?>/*P*/ From) {
    assert isa_CleanupReturnInst(From);
    return llvm.cast(CleanupReturnInst.class, From.$star());
  }

  public static CleanupReturnInst cast_or_null_CleanupReturnInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CleanupReturnInst(From);
  }

  public static CleanupReturnInst dyn_cast_CleanupReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static CleanupReturnInst dyn_cast_or_null_CleanupReturnInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static boolean isa_CleanupReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return CleanupReturnInst.classof(From);
  }

  public static CleanupReturnInst cast_CleanupReturnInst(Instruction/*P*/ From) {
    assert isa_CleanupReturnInst(From);
    return llvm.cast(CleanupReturnInst.class, From);
  }

  public static CleanupReturnInst cast_or_null_CleanupReturnInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CleanupReturnInst(From);
  }

  public static CleanupReturnInst dyn_cast_CleanupReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static CleanupReturnInst dyn_cast_or_null_CleanupReturnInst(Instruction/*P*/ From) {
    return (From != null) && isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static boolean isa_CleanupReturnInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CleanupReturnInst(From.get());
  }

  public static CleanupReturnInst cast_CleanupReturnInst(Use/*P*/ From) {
    return cast_CleanupReturnInst(From.get());
  }

  public static CleanupReturnInst cast_or_null_CleanupReturnInst(Use/*P*/ From) {
    return cast_or_null_CleanupReturnInst(From.get());
  }

  public static CleanupReturnInst dyn_cast_CleanupReturnInst(Use/*P*/ From) {
    return isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static CleanupReturnInst dyn_cast_or_null_CleanupReturnInst(Use/*P*/ From) {
    return (From != null) && isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static boolean isa_CleanupReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CleanupReturnInst.class, From.$deref());
  }

  public static CleanupReturnInst cast_CleanupReturnInst(type$ref<?>/*P*/ From) {
    assert isa_CleanupReturnInst(From);
    return llvm.cast(CleanupReturnInst.class, From.$deref());
  }

  public static CleanupReturnInst cast_or_null_CleanupReturnInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CleanupReturnInst(From);
  }

  public static CleanupReturnInst dyn_cast_CleanupReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static CleanupReturnInst dyn_cast_or_null_CleanupReturnInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CleanupReturnInst(From) ? cast_CleanupReturnInst(From) : null;
  }

  public static boolean isa_CmpInst(Value/*P*/ From) {
    assert From != null;
    return CmpInst.classof(From);
  }

  public static CmpInst cast_CmpInst(Value/*P*/ From) {
    assert isa_CmpInst(From);
    return (CmpInst) From;
  }

  public static CmpInst cast_or_null_CmpInst(Value/*P*/ From) {
    return (From == null) ? null : cast_CmpInst(From);
  }

  public static CmpInst dyn_cast_CmpInst(Value/*P*/ From) {
    assert From != null;
    return isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static CmpInst dyn_cast_or_null_CmpInst(Value/*P*/ From) {
    return (From != null) && isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static boolean isa_CmpInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CmpInst(From.get());
  }

  public static CmpInst cast_CmpInst(Use/*P*/ From) {
    return cast_CmpInst(From.get());
  }

  public static CmpInst cast_or_null_CmpInst(Use/*P*/ From) {
    return cast_or_null_CmpInst(From.get());
  }

  public static CmpInst dyn_cast_CmpInst(Use/*P*/ From) {
    return isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static CmpInst dyn_cast_or_null_CmpInst(Use/*P*/ From) {
    return (From != null) && isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static boolean isa_CmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CmpInst.class, From.$deref());
  }

  public static CmpInst cast_CmpInst(type$ref<?>/*P*/ From) {
    assert isa_CmpInst(From);
    return llvm.cast(CmpInst.class, From.$deref());
  }

  public static CmpInst cast_or_null_CmpInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CmpInst(From);
  }

  public static CmpInst dyn_cast_CmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static CmpInst dyn_cast_or_null_CmpInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static boolean isa_CmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CmpInst.class, From.$star());
  }

  public static CmpInst cast_CmpInst(type$ptr<?>/*P*/ From) {
    assert isa_CmpInst(From);
    return llvm.cast(CmpInst.class, From.$star());
  }

  public static CmpInst cast_or_null_CmpInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CmpInst(From);
  }

  public static CmpInst dyn_cast_CmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static CmpInst dyn_cast_or_null_CmpInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static boolean isa_CmpInst(Instruction/*P*/ From) {
    assert From != null;
    return CmpInst.classof(From);
  }

  public static CmpInst cast_CmpInst(Instruction/*P*/ From) {
    assert isa_CmpInst(From);
    return llvm.cast(CmpInst.class, From);
  }

  public static CmpInst cast_or_null_CmpInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_CmpInst(From);
  }

  public static CmpInst dyn_cast_CmpInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static CmpInst dyn_cast_or_null_CmpInst(Instruction/*P*/ From) {
    return (From != null) && isa_CmpInst(From) ? cast_CmpInst(From) : null;
  }

  public static boolean isa_CompositeType(Type/*P*/ From) {
    assert From != null;
    return CompositeType.classof(From);
  }

  public static CompositeType cast_CompositeType(Type/*P*/ From) {
    assert isa_CompositeType(From);
    return (CompositeType) From;
  }

  public static CompositeType cast_or_null_CompositeType(Type/*P*/ From) {
    return (From == null) ? null : cast_CompositeType(From);
  }

  public static CompositeType dyn_cast_CompositeType(Type/*P*/ From) {
    assert From != null;
    return isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static CompositeType dyn_cast_or_null_CompositeType(Type/*P*/ From) {
    return (From != null) && isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static boolean isa_CompositeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompositeType.class, From.$star());
  }

  public static CompositeType cast_CompositeType(type$ptr<?>/*P*/ From) {
    assert isa_CompositeType(From);
    return llvm.cast(CompositeType.class, From.$star());
  }

  public static CompositeType cast_or_null_CompositeType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompositeType(From);
  }

  public static CompositeType dyn_cast_CompositeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static CompositeType dyn_cast_or_null_CompositeType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static boolean isa_CompositeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompositeType.class, From.$deref());
  }

  public static CompositeType cast_CompositeType(type$ref<?>/*P*/ From) {
    assert isa_CompositeType(From);
    return llvm.cast(CompositeType.class, From.$deref());
  }

  public static CompositeType cast_or_null_CompositeType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompositeType(From);
  }

  public static CompositeType dyn_cast_CompositeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static CompositeType dyn_cast_or_null_CompositeType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompositeType(From) ? cast_CompositeType(From) : null;
  }

  public static boolean isa_ConcreteOperator(ConstantExpr/*P*/ From) {
    //assert From != null;
    //return ConcreteOperator.classof(From);
    throw new UnsupportedOperationException("ConcreteOperator uses Opc template parameter. Not supported yet.");
  }

  public static ConcreteOperator cast_ConcreteOperator(ConstantExpr/*P*/ From) {
    assert isa_ConcreteOperator(From);
    return llvm.cast(ConcreteOperator.class, From);
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_ConcreteOperator(From);
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_ConcreteOperator(Value/*P*/ From) {
    //assert From != null;
    //return ConcreteOperator.classof(From);
    throw new UnsupportedOperationException("ConcreteOperator uses Opc template parameter. Not supported yet.");
  }

  public static ConcreteOperator cast_ConcreteOperator(Value/*P*/ From) {
    assert isa_ConcreteOperator(From);
    return llvm.cast(ConcreteOperator.class, From);
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_ConcreteOperator(From);
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(Value/*P*/ From) {
    assert From != null;
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(Value/*P*/ From) {
    return (From != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_ConcreteOperator(Instruction/*P*/ From) {
    //assert From != null;
    //return ConcreteOperator.classof(From);
    throw new UnsupportedOperationException("ConcreteOperator uses Opc template parameter. Not supported yet.");
  }

  public static ConcreteOperator cast_ConcreteOperator(Instruction/*P*/ From) {
    assert isa_ConcreteOperator(From);
    return llvm.cast(ConcreteOperator.class, From);
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ConcreteOperator(From);
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(Instruction/*P*/ From) {
    return (From != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_ConcreteOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConcreteOperator.class, From.$star());
  }

  public static ConcreteOperator cast_ConcreteOperator(type$ptr<?>/*P*/ From) {
    assert isa_ConcreteOperator(From);
    return llvm.cast(ConcreteOperator.class, From.$star());
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConcreteOperator(From);
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_ConcreteOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConcreteOperator(From.get());
  }

  public static ConcreteOperator cast_ConcreteOperator(Use/*P*/ From) {
    return cast_ConcreteOperator(From.get());
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(Use/*P*/ From) {
    return cast_or_null_ConcreteOperator(From.get());
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(Use/*P*/ From) {
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(Use/*P*/ From) {
    return (From != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_ConcreteOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConcreteOperator.class, From.$deref());
  }

  public static ConcreteOperator cast_ConcreteOperator(type$ref<?>/*P*/ From) {
    assert isa_ConcreteOperator(From);
    return llvm.cast(ConcreteOperator.class, From.$deref());
  }

  public static ConcreteOperator cast_or_null_ConcreteOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConcreteOperator(From);
  }

  public static ConcreteOperator dyn_cast_ConcreteOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static ConcreteOperator dyn_cast_or_null_ConcreteOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConcreteOperator(From) ? cast_ConcreteOperator(From) : null;
  }

  public static boolean isa_Constant(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Constant.class, From.$star());
  }

  public static Constant cast_Constant(type$ptr<?>/*P*/ From) {
    assert isa_Constant(From);
    return llvm.cast(Constant.class, From.$star());
  }

  public static Constant cast_or_null_Constant(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Constant(From);
  }

  public static Constant dyn_cast_Constant(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static Constant dyn_cast_or_null_Constant(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static boolean isa_Constant(Value/*P*/ From) {
    assert From != null;
    return Constant.classof(From);
  }

  public static Constant cast_Constant(Value/*P*/ From) {
    assert isa_Constant(From);
    return (Constant) From;
  }

  public static Constant cast_or_null_Constant(Value/*P*/ From) {
    return (From == null) ? null : cast_Constant(From);
  }

  public static Constant dyn_cast_Constant(Value/*P*/ From) {
    assert From != null;
    return isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static Constant dyn_cast_or_null_Constant(Value/*P*/ From) {
    return (From != null) && isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static boolean isa_Constant(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Constant.class, From.$deref());
  }

  public static Constant cast_Constant(type$ref<?>/*P*/ From) {
    assert isa_Constant(From);
    return llvm.cast(Constant.class, From.$deref());
  }

  public static Constant cast_or_null_Constant(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Constant(From);
  }

  public static Constant dyn_cast_Constant(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static Constant dyn_cast_or_null_Constant(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static boolean isa_Constant(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Constant(From.get());
  }

  public static Constant cast_Constant(Use/*P*/ From) {
    return cast_Constant(From.get());
  }

  public static Constant cast_or_null_Constant(Use/*P*/ From) {
    return cast_or_null_Constant(From.get());
  }

  public static Constant dyn_cast_Constant(Use/*P*/ From) {
    return isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static Constant dyn_cast_or_null_Constant(Use/*P*/ From) {
    return (From != null) && isa_Constant(From) ? cast_Constant(From) : null;
  }

  public static boolean isa_ConstantAggregate(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantAggregate(From.get());
  }

  public static ConstantAggregate cast_ConstantAggregate(Use/*P*/ From) {
    return cast_ConstantAggregate(From.get());
  }

  public static ConstantAggregate cast_or_null_ConstantAggregate(Use/*P*/ From) {
    return cast_or_null_ConstantAggregate(From.get());
  }

  public static ConstantAggregate dyn_cast_ConstantAggregate(Use/*P*/ From) {
    return isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static ConstantAggregate dyn_cast_or_null_ConstantAggregate(Use/*P*/ From) {
    return (From != null) && isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static boolean isa_ConstantAggregate(Value/*P*/ From) {
    assert From != null;
    return ConstantAggregate.classof(From);
  }

  public static ConstantAggregate cast_ConstantAggregate(Value/*P*/ From) {
    assert isa_ConstantAggregate(From);
    return (ConstantAggregate) From;
  }

  public static ConstantAggregate cast_or_null_ConstantAggregate(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantAggregate(From);
  }

  public static ConstantAggregate dyn_cast_ConstantAggregate(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static ConstantAggregate dyn_cast_or_null_ConstantAggregate(Value/*P*/ From) {
    return (From != null) && isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static boolean isa_ConstantAggregate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantAggregate.class, From.$star());
  }

  public static ConstantAggregate cast_ConstantAggregate(type$ptr<?>/*P*/ From) {
    assert isa_ConstantAggregate(From);
    return llvm.cast(ConstantAggregate.class, From.$star());
  }

  public static ConstantAggregate cast_or_null_ConstantAggregate(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantAggregate(From);
  }

  public static ConstantAggregate dyn_cast_ConstantAggregate(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static ConstantAggregate dyn_cast_or_null_ConstantAggregate(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static boolean isa_ConstantAggregate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantAggregate.class, From.$deref());
  }

  public static ConstantAggregate cast_ConstantAggregate(type$ref<?>/*P*/ From) {
    assert isa_ConstantAggregate(From);
    return llvm.cast(ConstantAggregate.class, From.$deref());
  }

  public static ConstantAggregate cast_or_null_ConstantAggregate(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantAggregate(From);
  }

  public static ConstantAggregate dyn_cast_ConstantAggregate(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static ConstantAggregate dyn_cast_or_null_ConstantAggregate(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantAggregate(From) ? cast_ConstantAggregate(From) : null;
  }

  public static boolean isa_ConstantAggregateZero(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantAggregateZero.class, From.$star());
  }

  public static ConstantAggregateZero cast_ConstantAggregateZero(type$ptr<?>/*P*/ From) {
    assert isa_ConstantAggregateZero(From);
    return llvm.cast(ConstantAggregateZero.class, From.$star());
  }

  public static ConstantAggregateZero cast_or_null_ConstantAggregateZero(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantAggregateZero(From);
  }

  public static ConstantAggregateZero dyn_cast_ConstantAggregateZero(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static ConstantAggregateZero dyn_cast_or_null_ConstantAggregateZero(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static boolean isa_ConstantAggregateZero(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantAggregateZero.class, From.$deref());
  }

  public static ConstantAggregateZero cast_ConstantAggregateZero(type$ref<?>/*P*/ From) {
    assert isa_ConstantAggregateZero(From);
    return llvm.cast(ConstantAggregateZero.class, From.$deref());
  }

  public static ConstantAggregateZero cast_or_null_ConstantAggregateZero(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantAggregateZero(From);
  }

  public static ConstantAggregateZero dyn_cast_ConstantAggregateZero(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static ConstantAggregateZero dyn_cast_or_null_ConstantAggregateZero(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static boolean isa_ConstantAggregateZero(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantAggregateZero(From.get());
  }

  public static ConstantAggregateZero cast_ConstantAggregateZero(Use/*P*/ From) {
    return cast_ConstantAggregateZero(From.get());
  }

  public static ConstantAggregateZero cast_or_null_ConstantAggregateZero(Use/*P*/ From) {
    return cast_or_null_ConstantAggregateZero(From.get());
  }

  public static ConstantAggregateZero dyn_cast_ConstantAggregateZero(Use/*P*/ From) {
    return isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static ConstantAggregateZero dyn_cast_or_null_ConstantAggregateZero(Use/*P*/ From) {
    return (From != null) && isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static boolean isa_ConstantAggregateZero(Value/*P*/ From) {
    assert From != null;
    return ConstantAggregateZero.classof(From);
  }

  public static ConstantAggregateZero cast_ConstantAggregateZero(Value/*P*/ From) {
    assert isa_ConstantAggregateZero(From);
    return (ConstantAggregateZero) From;
  }

  public static ConstantAggregateZero cast_or_null_ConstantAggregateZero(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantAggregateZero(From);
  }

  public static ConstantAggregateZero dyn_cast_ConstantAggregateZero(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static ConstantAggregateZero dyn_cast_or_null_ConstantAggregateZero(Value/*P*/ From) {
    return (From != null) && isa_ConstantAggregateZero(From) ? cast_ConstantAggregateZero(From) : null;
  }

  public static boolean isa_ConstantArray(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantArray(From.get());
  }

  public static ConstantArray cast_ConstantArray(Use/*P*/ From) {
    return cast_ConstantArray(From.get());
  }

  public static ConstantArray cast_or_null_ConstantArray(Use/*P*/ From) {
    return cast_or_null_ConstantArray(From.get());
  }

  public static ConstantArray dyn_cast_ConstantArray(Use/*P*/ From) {
    return isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static ConstantArray dyn_cast_or_null_ConstantArray(Use/*P*/ From) {
    return (From != null) && isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static boolean isa_ConstantArray(Value/*P*/ From) {
    assert From != null;
    return ConstantArray.classof(From);
  }

  public static ConstantArray cast_ConstantArray(Value/*P*/ From) {
    assert isa_ConstantArray(From);
    return (ConstantArray) From;
  }

  public static ConstantArray cast_or_null_ConstantArray(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantArray(From);
  }

  public static ConstantArray dyn_cast_ConstantArray(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static ConstantArray dyn_cast_or_null_ConstantArray(Value/*P*/ From) {
    return (From != null) && isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static boolean isa_ConstantArray(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantArray.class, From.$star());
  }

  public static ConstantArray cast_ConstantArray(type$ptr<?>/*P*/ From) {
    assert isa_ConstantArray(From);
    return llvm.cast(ConstantArray.class, From.$star());
  }

  public static ConstantArray cast_or_null_ConstantArray(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantArray(From);
  }

  public static ConstantArray dyn_cast_ConstantArray(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static ConstantArray dyn_cast_or_null_ConstantArray(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static boolean isa_ConstantArray(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantArray.class, From.$deref());
  }

  public static ConstantArray cast_ConstantArray(type$ref<?>/*P*/ From) {
    assert isa_ConstantArray(From);
    return llvm.cast(ConstantArray.class, From.$deref());
  }

  public static ConstantArray cast_or_null_ConstantArray(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantArray(From);
  }

  public static ConstantArray dyn_cast_ConstantArray(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static ConstantArray dyn_cast_or_null_ConstantArray(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantArray(From) ? cast_ConstantArray(From) : null;
  }

  public static boolean isa_ConstantAsMetadata(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantAsMetadata(From.get());
  }

  public static ConstantAsMetadata cast_ConstantAsMetadata(MDOperand/*P*/ From) {
    return cast_ConstantAsMetadata(From.get());
  }

  public static ConstantAsMetadata cast_or_null_ConstantAsMetadata(MDOperand/*P*/ From) {
    return cast_or_null_ConstantAsMetadata(From.get());
  }

  public static ConstantAsMetadata dyn_cast_ConstantAsMetadata(MDOperand/*P*/ From) {
    return isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static ConstantAsMetadata dyn_cast_or_null_ConstantAsMetadata(MDOperand/*P*/ From) {
    return (From != null) && isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static boolean isa_ConstantAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantAsMetadata.class, From.$deref());
  }

  public static ConstantAsMetadata cast_ConstantAsMetadata(type$ref<?>/*P*/ From) {
    assert isa_ConstantAsMetadata(From);
    return llvm.cast(ConstantAsMetadata.class, From.$deref());
  }

  public static ConstantAsMetadata cast_or_null_ConstantAsMetadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantAsMetadata(From);
  }

  public static ConstantAsMetadata dyn_cast_ConstantAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static ConstantAsMetadata dyn_cast_or_null_ConstantAsMetadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static boolean isa_ConstantAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return ConstantAsMetadata.classof(From);
  }

  public static ConstantAsMetadata cast_ConstantAsMetadata(Metadata/*P*/ From) {
    assert isa_ConstantAsMetadata(From);
    return (ConstantAsMetadata) From;
  }

  public static ConstantAsMetadata cast_or_null_ConstantAsMetadata(Metadata/*P*/ From) {
    return (From == null) ? null : cast_ConstantAsMetadata(From);
  }

  public static ConstantAsMetadata dyn_cast_ConstantAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static ConstantAsMetadata dyn_cast_or_null_ConstantAsMetadata(Metadata/*P*/ From) {
    return (From != null) && isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static boolean isa_ConstantAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantAsMetadata.class, From.$star());
  }

  public static ConstantAsMetadata cast_ConstantAsMetadata(type$ptr<?>/*P*/ From) {
    assert isa_ConstantAsMetadata(From);
    return llvm.cast(ConstantAsMetadata.class, From.$star());
  }

  public static ConstantAsMetadata cast_or_null_ConstantAsMetadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantAsMetadata(From);
  }

  public static ConstantAsMetadata dyn_cast_ConstantAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static ConstantAsMetadata dyn_cast_or_null_ConstantAsMetadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantAsMetadata(From) ? cast_ConstantAsMetadata(From) : null;
  }

  public static boolean isa_ConstantData(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantData.class, From.$star());
  }

  public static ConstantData cast_ConstantData(type$ptr<?>/*P*/ From) {
    assert isa_ConstantData(From);
    return llvm.cast(ConstantData.class, From.$star());
  }

  public static ConstantData cast_or_null_ConstantData(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantData(From);
  }

  public static ConstantData dyn_cast_ConstantData(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static ConstantData dyn_cast_or_null_ConstantData(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static boolean isa_ConstantData(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantData(From.get());
  }

  public static ConstantData cast_ConstantData(Use/*P*/ From) {
    return cast_ConstantData(From.get());
  }

  public static ConstantData cast_or_null_ConstantData(Use/*P*/ From) {
    return cast_or_null_ConstantData(From.get());
  }

  public static ConstantData dyn_cast_ConstantData(Use/*P*/ From) {
    return isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static ConstantData dyn_cast_or_null_ConstantData(Use/*P*/ From) {
    return (From != null) && isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static boolean isa_ConstantData(Value/*P*/ From) {
    assert From != null;
    return ConstantData.classof(From);
  }

  public static ConstantData cast_ConstantData(Value/*P*/ From) {
    assert isa_ConstantData(From);
    return (ConstantData) From;
  }

  public static ConstantData cast_or_null_ConstantData(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantData(From);
  }

  public static ConstantData dyn_cast_ConstantData(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static ConstantData dyn_cast_or_null_ConstantData(Value/*P*/ From) {
    return (From != null) && isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static boolean isa_ConstantData(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantData.class, From.$deref());
  }

  public static ConstantData cast_ConstantData(type$ref<?>/*P*/ From) {
    assert isa_ConstantData(From);
    return llvm.cast(ConstantData.class, From.$deref());
  }

  public static ConstantData cast_or_null_ConstantData(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantData(From);
  }

  public static ConstantData dyn_cast_ConstantData(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static ConstantData dyn_cast_or_null_ConstantData(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantData(From) ? cast_ConstantData(From) : null;
  }

  public static boolean isa_ConstantDataArray(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantDataArray.class, From.$deref());
  }

  public static ConstantDataArray cast_ConstantDataArray(type$ref<?>/*P*/ From) {
    assert isa_ConstantDataArray(From);
    return llvm.cast(ConstantDataArray.class, From.$deref());
  }

  public static ConstantDataArray cast_or_null_ConstantDataArray(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantDataArray(From);
  }

  public static ConstantDataArray dyn_cast_ConstantDataArray(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static ConstantDataArray dyn_cast_or_null_ConstantDataArray(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static boolean isa_ConstantDataArray(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantDataArray(From.get());
  }

  public static ConstantDataArray cast_ConstantDataArray(Use/*P*/ From) {
    return cast_ConstantDataArray(From.get());
  }

  public static ConstantDataArray cast_or_null_ConstantDataArray(Use/*P*/ From) {
    return cast_or_null_ConstantDataArray(From.get());
  }

  public static ConstantDataArray dyn_cast_ConstantDataArray(Use/*P*/ From) {
    return isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static ConstantDataArray dyn_cast_or_null_ConstantDataArray(Use/*P*/ From) {
    return (From != null) && isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static boolean isa_ConstantDataArray(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantDataArray.class, From.$star());
  }

  public static ConstantDataArray cast_ConstantDataArray(type$ptr<?>/*P*/ From) {
    assert isa_ConstantDataArray(From);
    return llvm.cast(ConstantDataArray.class, From.$star());
  }

  public static ConstantDataArray cast_or_null_ConstantDataArray(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantDataArray(From);
  }

  public static ConstantDataArray dyn_cast_ConstantDataArray(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static ConstantDataArray dyn_cast_or_null_ConstantDataArray(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static boolean isa_ConstantDataArray(Value/*P*/ From) {
    assert From != null;
    return ConstantDataArray.classof(From);
  }

  public static ConstantDataArray cast_ConstantDataArray(Value/*P*/ From) {
    assert isa_ConstantDataArray(From);
    return (ConstantDataArray) From;
  }

  public static ConstantDataArray cast_or_null_ConstantDataArray(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantDataArray(From);
  }

  public static ConstantDataArray dyn_cast_ConstantDataArray(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static ConstantDataArray dyn_cast_or_null_ConstantDataArray(Value/*P*/ From) {
    return (From != null) && isa_ConstantDataArray(From) ? cast_ConstantDataArray(From) : null;
  }

  public static boolean isa_ConstantDataSequential(Value/*P*/ From) {
    assert From != null;
    return ConstantDataSequential.classof(From);
  }

  public static ConstantDataSequential cast_ConstantDataSequential(Value/*P*/ From) {
    assert isa_ConstantDataSequential(From);
    return (ConstantDataSequential) From;
  }

  public static ConstantDataSequential cast_or_null_ConstantDataSequential(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantDataSequential(From);
  }

  public static ConstantDataSequential dyn_cast_ConstantDataSequential(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static ConstantDataSequential dyn_cast_or_null_ConstantDataSequential(Value/*P*/ From) {
    return (From != null) && isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static boolean isa_ConstantDataSequential(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantDataSequential(From.get());
  }

  public static ConstantDataSequential cast_ConstantDataSequential(Use/*P*/ From) {
    return cast_ConstantDataSequential(From.get());
  }

  public static ConstantDataSequential cast_or_null_ConstantDataSequential(Use/*P*/ From) {
    return cast_or_null_ConstantDataSequential(From.get());
  }

  public static ConstantDataSequential dyn_cast_ConstantDataSequential(Use/*P*/ From) {
    return isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static ConstantDataSequential dyn_cast_or_null_ConstantDataSequential(Use/*P*/ From) {
    return (From != null) && isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static boolean isa_ConstantDataSequential(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantDataSequential.class, From.$deref());
  }

  public static ConstantDataSequential cast_ConstantDataSequential(type$ref<?>/*P*/ From) {
    assert isa_ConstantDataSequential(From);
    return llvm.cast(ConstantDataSequential.class, From.$deref());
  }

  public static ConstantDataSequential cast_or_null_ConstantDataSequential(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantDataSequential(From);
  }

  public static ConstantDataSequential dyn_cast_ConstantDataSequential(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static ConstantDataSequential dyn_cast_or_null_ConstantDataSequential(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static boolean isa_ConstantDataSequential(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantDataSequential.class, From.$star());
  }

  public static ConstantDataSequential cast_ConstantDataSequential(type$ptr<?>/*P*/ From) {
    assert isa_ConstantDataSequential(From);
    return llvm.cast(ConstantDataSequential.class, From.$star());
  }

  public static ConstantDataSequential cast_or_null_ConstantDataSequential(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantDataSequential(From);
  }

  public static ConstantDataSequential dyn_cast_ConstantDataSequential(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static ConstantDataSequential dyn_cast_or_null_ConstantDataSequential(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantDataSequential(From) ? cast_ConstantDataSequential(From) : null;
  }

  public static boolean isa_ConstantDataVector(Value/*P*/ From) {
    assert From != null;
    return ConstantDataVector.classof(From);
  }

  public static ConstantDataVector cast_ConstantDataVector(Value/*P*/ From) {
    assert isa_ConstantDataVector(From);
    return (ConstantDataVector) From;
  }

  public static ConstantDataVector cast_or_null_ConstantDataVector(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantDataVector(From);
  }

  public static ConstantDataVector dyn_cast_ConstantDataVector(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static ConstantDataVector dyn_cast_or_null_ConstantDataVector(Value/*P*/ From) {
    return (From != null) && isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static boolean isa_ConstantDataVector(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantDataVector.class, From.$deref());
  }

  public static ConstantDataVector cast_ConstantDataVector(type$ref<?>/*P*/ From) {
    assert isa_ConstantDataVector(From);
    return llvm.cast(ConstantDataVector.class, From.$deref());
  }

  public static ConstantDataVector cast_or_null_ConstantDataVector(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantDataVector(From);
  }

  public static ConstantDataVector dyn_cast_ConstantDataVector(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static ConstantDataVector dyn_cast_or_null_ConstantDataVector(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static boolean isa_ConstantDataVector(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantDataVector.class, From.$star());
  }

  public static ConstantDataVector cast_ConstantDataVector(type$ptr<?>/*P*/ From) {
    assert isa_ConstantDataVector(From);
    return llvm.cast(ConstantDataVector.class, From.$star());
  }

  public static ConstantDataVector cast_or_null_ConstantDataVector(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantDataVector(From);
  }

  public static ConstantDataVector dyn_cast_ConstantDataVector(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static ConstantDataVector dyn_cast_or_null_ConstantDataVector(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static boolean isa_ConstantDataVector(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantDataVector(From.get());
  }

  public static ConstantDataVector cast_ConstantDataVector(Use/*P*/ From) {
    return cast_ConstantDataVector(From.get());
  }

  public static ConstantDataVector cast_or_null_ConstantDataVector(Use/*P*/ From) {
    return cast_or_null_ConstantDataVector(From.get());
  }

  public static ConstantDataVector dyn_cast_ConstantDataVector(Use/*P*/ From) {
    return isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static ConstantDataVector dyn_cast_or_null_ConstantDataVector(Use/*P*/ From) {
    return (From != null) && isa_ConstantDataVector(From) ? cast_ConstantDataVector(From) : null;
  }

  public static boolean isa_ConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantExpr(From.get());
  }

  public static ConstantExpr cast_ConstantExpr(Use/*P*/ From) {
    return cast_ConstantExpr(From.get());
  }

  public static ConstantExpr cast_or_null_ConstantExpr(Use/*P*/ From) {
    return cast_or_null_ConstantExpr(From.get());
  }

  public static ConstantExpr dyn_cast_ConstantExpr(Use/*P*/ From) {
    return isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static ConstantExpr dyn_cast_or_null_ConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static boolean isa_ConstantExpr(Value/*P*/ From) {
    assert From != null;
    return ConstantExpr.classof(From);
  }

  public static ConstantExpr cast_ConstantExpr(Value/*P*/ From) {
    assert isa_ConstantExpr(From);
    return (ConstantExpr) From;
  }

  public static ConstantExpr cast_or_null_ConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantExpr(From);
  }

  public static ConstantExpr dyn_cast_ConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static ConstantExpr dyn_cast_or_null_ConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static boolean isa_ConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ConstantExpr cast_ConstantExpr(ConstantExpr/*P*/ From) {
    assert isa_ConstantExpr(From);
    return (ConstantExpr) From;
  }

  public static ConstantExpr cast_or_null_ConstantExpr(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_ConstantExpr(From);
  }

  public static ConstantExpr dyn_cast_ConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static ConstantExpr dyn_cast_or_null_ConstantExpr(ConstantExpr/*P*/ From) {
    return (From != null) && isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static boolean isa_ConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantExpr.class, From.$star());
  }

  public static ConstantExpr cast_ConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_ConstantExpr(From);
    return llvm.cast(ConstantExpr.class, From.$star());
  }

  public static ConstantExpr cast_or_null_ConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantExpr(From);
  }

  public static ConstantExpr dyn_cast_ConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static ConstantExpr dyn_cast_or_null_ConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static boolean isa_ConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantExpr.class, From.$deref());
  }

  public static ConstantExpr cast_ConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_ConstantExpr(From);
    return llvm.cast(ConstantExpr.class, From.$deref());
  }

  public static ConstantExpr cast_or_null_ConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantExpr(From);
  }

  public static ConstantExpr dyn_cast_ConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static ConstantExpr dyn_cast_or_null_ConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantExpr(From) ? cast_ConstantExpr(From) : null;
  }

  public static boolean isa_ConstantFP(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantFP(From.get());
  }

  public static ConstantFP cast_ConstantFP(Use/*P*/ From) {
    return cast_ConstantFP(From.get());
  }

  public static ConstantFP cast_or_null_ConstantFP(Use/*P*/ From) {
    return cast_or_null_ConstantFP(From.get());
  }

  public static ConstantFP dyn_cast_ConstantFP(Use/*P*/ From) {
    return isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static ConstantFP dyn_cast_or_null_ConstantFP(Use/*P*/ From) {
    return (From != null) && isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static boolean isa_ConstantFP(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantFP.class, From.$deref());
  }

  public static ConstantFP cast_ConstantFP(type$ref<?>/*P*/ From) {
    assert isa_ConstantFP(From);
    return llvm.cast(ConstantFP.class, From.$deref());
  }

  public static ConstantFP cast_or_null_ConstantFP(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantFP(From);
  }

  public static ConstantFP dyn_cast_ConstantFP(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static ConstantFP dyn_cast_or_null_ConstantFP(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static boolean isa_ConstantFP(Value/*P*/ From) {
    assert From != null;
    return ConstantFP.classof(From);
  }

  public static ConstantFP cast_ConstantFP(Value/*P*/ From) {
    assert isa_ConstantFP(From);
    return (ConstantFP) From;
  }

  public static ConstantFP cast_or_null_ConstantFP(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantFP(From);
  }

  public static ConstantFP dyn_cast_ConstantFP(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static ConstantFP dyn_cast_or_null_ConstantFP(Value/*P*/ From) {
    return (From != null) && isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static boolean isa_ConstantFP(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantFP.class, From.$star());
  }

  public static ConstantFP cast_ConstantFP(type$ptr<?>/*P*/ From) {
    assert isa_ConstantFP(From);
    return llvm.cast(ConstantFP.class, From.$star());
  }

  public static ConstantFP cast_or_null_ConstantFP(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantFP(From);
  }

  public static ConstantFP dyn_cast_ConstantFP(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static ConstantFP dyn_cast_or_null_ConstantFP(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantFP(From) ? cast_ConstantFP(From) : null;
  }

  public static boolean isa_ConstantInt(Value/*P*/ From) {
    assert From != null;
    return ConstantInt.classof(From);
  }

  public static ConstantInt cast_ConstantInt(Value/*P*/ From) {
    assert isa_ConstantInt(From);
    return (ConstantInt) From;
  }

  public static ConstantInt cast_or_null_ConstantInt(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantInt(From);
  }

  public static ConstantInt dyn_cast_ConstantInt(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static ConstantInt dyn_cast_or_null_ConstantInt(Value/*P*/ From) {
    return (From != null) && isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static boolean isa_ConstantInt(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantInt(From.get());
  }

  public static ConstantInt cast_ConstantInt(Use/*P*/ From) {
    return cast_ConstantInt(From.get());
  }

  public static ConstantInt cast_or_null_ConstantInt(Use/*P*/ From) {
    return cast_or_null_ConstantInt(From.get());
  }

  public static ConstantInt dyn_cast_ConstantInt(Use/*P*/ From) {
    return isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static ConstantInt dyn_cast_or_null_ConstantInt(Use/*P*/ From) {
    return (From != null) && isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static boolean isa_ConstantInt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantInt.class, From.$star());
  }

  public static ConstantInt cast_ConstantInt(type$ptr<?>/*P*/ From) {
    assert isa_ConstantInt(From);
    return llvm.cast(ConstantInt.class, From.$star());
  }

  public static ConstantInt cast_or_null_ConstantInt(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantInt(From);
  }

  public static ConstantInt dyn_cast_ConstantInt(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static ConstantInt dyn_cast_or_null_ConstantInt(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static boolean isa_ConstantInt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantInt.class, From.$deref());
  }

  public static ConstantInt cast_ConstantInt(type$ref<?>/*P*/ From) {
    assert isa_ConstantInt(From);
    return llvm.cast(ConstantInt.class, From.$deref());
  }

  public static ConstantInt cast_or_null_ConstantInt(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantInt(From);
  }

  public static ConstantInt dyn_cast_ConstantInt(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static ConstantInt dyn_cast_or_null_ConstantInt(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantInt(From) ? cast_ConstantInt(From) : null;
  }

  public static boolean isa_ConstantPointerNull(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantPointerNull.class, From.$deref());
  }

  public static ConstantPointerNull cast_ConstantPointerNull(type$ref<?>/*P*/ From) {
    assert isa_ConstantPointerNull(From);
    return llvm.cast(ConstantPointerNull.class, From.$deref());
  }

  public static ConstantPointerNull cast_or_null_ConstantPointerNull(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantPointerNull(From);
  }

  public static ConstantPointerNull dyn_cast_ConstantPointerNull(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static ConstantPointerNull dyn_cast_or_null_ConstantPointerNull(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static boolean isa_ConstantPointerNull(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantPointerNull.class, From.$star());
  }

  public static ConstantPointerNull cast_ConstantPointerNull(type$ptr<?>/*P*/ From) {
    assert isa_ConstantPointerNull(From);
    return llvm.cast(ConstantPointerNull.class, From.$star());
  }

  public static ConstantPointerNull cast_or_null_ConstantPointerNull(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantPointerNull(From);
  }

  public static ConstantPointerNull dyn_cast_ConstantPointerNull(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static ConstantPointerNull dyn_cast_or_null_ConstantPointerNull(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static boolean isa_ConstantPointerNull(Value/*P*/ From) {
    assert From != null;
    return ConstantPointerNull.classof(From);
  }

  public static ConstantPointerNull cast_ConstantPointerNull(Value/*P*/ From) {
    assert isa_ConstantPointerNull(From);
    return (ConstantPointerNull) From;
  }

  public static ConstantPointerNull cast_or_null_ConstantPointerNull(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantPointerNull(From);
  }

  public static ConstantPointerNull dyn_cast_ConstantPointerNull(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static ConstantPointerNull dyn_cast_or_null_ConstantPointerNull(Value/*P*/ From) {
    return (From != null) && isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static boolean isa_ConstantPointerNull(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantPointerNull(From.get());
  }

  public static ConstantPointerNull cast_ConstantPointerNull(Use/*P*/ From) {
    return cast_ConstantPointerNull(From.get());
  }

  public static ConstantPointerNull cast_or_null_ConstantPointerNull(Use/*P*/ From) {
    return cast_or_null_ConstantPointerNull(From.get());
  }

  public static ConstantPointerNull dyn_cast_ConstantPointerNull(Use/*P*/ From) {
    return isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static ConstantPointerNull dyn_cast_or_null_ConstantPointerNull(Use/*P*/ From) {
    return (From != null) && isa_ConstantPointerNull(From) ? cast_ConstantPointerNull(From) : null;
  }

  public static boolean isa_ConstantStruct(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantStruct(From.get());
  }

  public static ConstantStruct cast_ConstantStruct(Use/*P*/ From) {
    return cast_ConstantStruct(From.get());
  }

  public static ConstantStruct cast_or_null_ConstantStruct(Use/*P*/ From) {
    return cast_or_null_ConstantStruct(From.get());
  }

  public static ConstantStruct dyn_cast_ConstantStruct(Use/*P*/ From) {
    return isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static ConstantStruct dyn_cast_or_null_ConstantStruct(Use/*P*/ From) {
    return (From != null) && isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static boolean isa_ConstantStruct(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantStruct.class, From.$deref());
  }

  public static ConstantStruct cast_ConstantStruct(type$ref<?>/*P*/ From) {
    assert isa_ConstantStruct(From);
    return llvm.cast(ConstantStruct.class, From.$deref());
  }

  public static ConstantStruct cast_or_null_ConstantStruct(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantStruct(From);
  }

  public static ConstantStruct dyn_cast_ConstantStruct(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static ConstantStruct dyn_cast_or_null_ConstantStruct(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static boolean isa_ConstantStruct(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantStruct.class, From.$star());
  }

  public static ConstantStruct cast_ConstantStruct(type$ptr<?>/*P*/ From) {
    assert isa_ConstantStruct(From);
    return llvm.cast(ConstantStruct.class, From.$star());
  }

  public static ConstantStruct cast_or_null_ConstantStruct(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantStruct(From);
  }

  public static ConstantStruct dyn_cast_ConstantStruct(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static ConstantStruct dyn_cast_or_null_ConstantStruct(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static boolean isa_ConstantStruct(Value/*P*/ From) {
    assert From != null;
    return ConstantStruct.classof(From);
  }

  public static ConstantStruct cast_ConstantStruct(Value/*P*/ From) {
    assert isa_ConstantStruct(From);
    return (ConstantStruct) From;
  }

  public static ConstantStruct cast_or_null_ConstantStruct(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantStruct(From);
  }

  public static ConstantStruct dyn_cast_ConstantStruct(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static ConstantStruct dyn_cast_or_null_ConstantStruct(Value/*P*/ From) {
    return (From != null) && isa_ConstantStruct(From) ? cast_ConstantStruct(From) : null;
  }

  public static boolean isa_ConstantTokenNone(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantTokenNone.class, From.$deref());
  }

  public static ConstantTokenNone cast_ConstantTokenNone(type$ref<?>/*P*/ From) {
    assert isa_ConstantTokenNone(From);
    return llvm.cast(ConstantTokenNone.class, From.$deref());
  }

  public static ConstantTokenNone cast_or_null_ConstantTokenNone(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantTokenNone(From);
  }

  public static ConstantTokenNone dyn_cast_ConstantTokenNone(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static ConstantTokenNone dyn_cast_or_null_ConstantTokenNone(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static boolean isa_ConstantTokenNone(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantTokenNone(From.get());
  }

  public static ConstantTokenNone cast_ConstantTokenNone(Use/*P*/ From) {
    return cast_ConstantTokenNone(From.get());
  }

  public static ConstantTokenNone cast_or_null_ConstantTokenNone(Use/*P*/ From) {
    return cast_or_null_ConstantTokenNone(From.get());
  }

  public static ConstantTokenNone dyn_cast_ConstantTokenNone(Use/*P*/ From) {
    return isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static ConstantTokenNone dyn_cast_or_null_ConstantTokenNone(Use/*P*/ From) {
    return (From != null) && isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static boolean isa_ConstantTokenNone(Value/*P*/ From) {
    assert From != null;
    return ConstantTokenNone.classof(From);
  }

  public static ConstantTokenNone cast_ConstantTokenNone(Value/*P*/ From) {
    assert isa_ConstantTokenNone(From);
    return (ConstantTokenNone) From;
  }

  public static ConstantTokenNone cast_or_null_ConstantTokenNone(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantTokenNone(From);
  }

  public static ConstantTokenNone dyn_cast_ConstantTokenNone(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static ConstantTokenNone dyn_cast_or_null_ConstantTokenNone(Value/*P*/ From) {
    return (From != null) && isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static boolean isa_ConstantTokenNone(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantTokenNone.class, From.$star());
  }

  public static ConstantTokenNone cast_ConstantTokenNone(type$ptr<?>/*P*/ From) {
    assert isa_ConstantTokenNone(From);
    return llvm.cast(ConstantTokenNone.class, From.$star());
  }

  public static ConstantTokenNone cast_or_null_ConstantTokenNone(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantTokenNone(From);
  }

  public static ConstantTokenNone dyn_cast_ConstantTokenNone(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static ConstantTokenNone dyn_cast_or_null_ConstantTokenNone(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantTokenNone(From) ? cast_ConstantTokenNone(From) : null;
  }

  public static boolean isa_ConstantVector(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstantVector.class, From.$star());
  }

  public static ConstantVector cast_ConstantVector(type$ptr<?>/*P*/ From) {
    assert isa_ConstantVector(From);
    return llvm.cast(ConstantVector.class, From.$star());
  }

  public static ConstantVector cast_or_null_ConstantVector(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstantVector(From);
  }

  public static ConstantVector dyn_cast_ConstantVector(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static ConstantVector dyn_cast_or_null_ConstantVector(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static boolean isa_ConstantVector(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ConstantVector(From.get());
  }

  public static ConstantVector cast_ConstantVector(Use/*P*/ From) {
    return cast_ConstantVector(From.get());
  }

  public static ConstantVector cast_or_null_ConstantVector(Use/*P*/ From) {
    return cast_or_null_ConstantVector(From.get());
  }

  public static ConstantVector dyn_cast_ConstantVector(Use/*P*/ From) {
    return isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static ConstantVector dyn_cast_or_null_ConstantVector(Use/*P*/ From) {
    return (From != null) && isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static boolean isa_ConstantVector(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstantVector.class, From.$deref());
  }

  public static ConstantVector cast_ConstantVector(type$ref<?>/*P*/ From) {
    assert isa_ConstantVector(From);
    return llvm.cast(ConstantVector.class, From.$deref());
  }

  public static ConstantVector cast_or_null_ConstantVector(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstantVector(From);
  }

  public static ConstantVector dyn_cast_ConstantVector(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static ConstantVector dyn_cast_or_null_ConstantVector(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static boolean isa_ConstantVector(Value/*P*/ From) {
    assert From != null;
    return ConstantVector.classof(From);
  }

  public static ConstantVector cast_ConstantVector(Value/*P*/ From) {
    assert isa_ConstantVector(From);
    return (ConstantVector) From;
  }

  public static ConstantVector cast_or_null_ConstantVector(Value/*P*/ From) {
    return (From == null) ? null : cast_ConstantVector(From);
  }

  public static ConstantVector dyn_cast_ConstantVector(Value/*P*/ From) {
    assert From != null;
    return isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static ConstantVector dyn_cast_or_null_ConstantVector(Value/*P*/ From) {
    return (From != null) && isa_ConstantVector(From) ? cast_ConstantVector(From) : null;
  }

  public static boolean isa_DIBasicType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIBasicType.class, From.$star());
  }

  public static DIBasicType cast_DIBasicType(type$ptr<?>/*P*/ From) {
    assert isa_DIBasicType(From);
    return llvm.cast(DIBasicType.class, From.$star());
  }

  public static DIBasicType cast_or_null_DIBasicType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIBasicType(From);
  }

  public static DIBasicType dyn_cast_DIBasicType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static DIBasicType dyn_cast_or_null_DIBasicType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static boolean isa_DIBasicType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIBasicType.class, From.$deref());
  }

  public static DIBasicType cast_DIBasicType(type$ref<?>/*P*/ From) {
    assert isa_DIBasicType(From);
    return llvm.cast(DIBasicType.class, From.$deref());
  }

  public static DIBasicType cast_or_null_DIBasicType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIBasicType(From);
  }

  public static DIBasicType dyn_cast_DIBasicType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static DIBasicType dyn_cast_or_null_DIBasicType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static boolean isa_DIBasicType(Metadata/*P*/ From) {
    assert From != null;
    return DIBasicType.classof(From);
  }

  public static DIBasicType cast_DIBasicType(Metadata/*P*/ From) {
    assert isa_DIBasicType(From);
    return (DIBasicType) From;
  }

  public static DIBasicType cast_or_null_DIBasicType(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIBasicType(From);
  }

  public static DIBasicType dyn_cast_DIBasicType(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static DIBasicType dyn_cast_or_null_DIBasicType(Metadata/*P*/ From) {
    return (From != null) && isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static boolean isa_DIBasicType(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIBasicType(From.get());
  }

  public static DIBasicType cast_DIBasicType(MDOperand/*P*/ From) {
    return cast_DIBasicType(From.get());
  }

  public static DIBasicType cast_or_null_DIBasicType(MDOperand/*P*/ From) {
    return cast_or_null_DIBasicType(From.get());
  }

  public static DIBasicType dyn_cast_DIBasicType(MDOperand/*P*/ From) {
    return isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static DIBasicType dyn_cast_or_null_DIBasicType(MDOperand/*P*/ From) {
    return (From != null) && isa_DIBasicType(From) ? cast_DIBasicType(From) : null;
  }

  public static boolean isa_DICompileUnit(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DICompileUnit.class, From.$star());
  }

  public static DICompileUnit cast_DICompileUnit(type$ptr<?>/*P*/ From) {
    assert isa_DICompileUnit(From);
    return llvm.cast(DICompileUnit.class, From.$star());
  }

  public static DICompileUnit cast_or_null_DICompileUnit(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DICompileUnit(From);
  }

  public static DICompileUnit dyn_cast_DICompileUnit(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static DICompileUnit dyn_cast_or_null_DICompileUnit(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static boolean isa_DICompileUnit(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DICompileUnit(From.get());
  }

  public static DICompileUnit cast_DICompileUnit(MDOperand/*P*/ From) {
    return cast_DICompileUnit(From.get());
  }

  public static DICompileUnit cast_or_null_DICompileUnit(MDOperand/*P*/ From) {
    return cast_or_null_DICompileUnit(From.get());
  }

  public static DICompileUnit dyn_cast_DICompileUnit(MDOperand/*P*/ From) {
    return isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static DICompileUnit dyn_cast_or_null_DICompileUnit(MDOperand/*P*/ From) {
    return (From != null) && isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static boolean isa_DICompileUnit(Metadata/*P*/ From) {
    assert From != null;
    return DICompileUnit.classof(From);
  }

  public static DICompileUnit cast_DICompileUnit(Metadata/*P*/ From) {
    assert isa_DICompileUnit(From);
    return (DICompileUnit) From;
  }

  public static DICompileUnit cast_or_null_DICompileUnit(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DICompileUnit(From);
  }

  public static DICompileUnit dyn_cast_DICompileUnit(Metadata/*P*/ From) {
    assert From != null;
    return isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static DICompileUnit dyn_cast_or_null_DICompileUnit(Metadata/*P*/ From) {
    return (From != null) && isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static boolean isa_DICompileUnit(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DICompileUnit.class, From.$deref());
  }

  public static DICompileUnit cast_DICompileUnit(type$ref<?>/*P*/ From) {
    assert isa_DICompileUnit(From);
    return llvm.cast(DICompileUnit.class, From.$deref());
  }

  public static DICompileUnit cast_or_null_DICompileUnit(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DICompileUnit(From);
  }

  public static DICompileUnit dyn_cast_DICompileUnit(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static DICompileUnit dyn_cast_or_null_DICompileUnit(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DICompileUnit(From) ? cast_DICompileUnit(From) : null;
  }

  public static boolean isa_DICompositeType(Metadata/*P*/ From) {
    assert From != null;
    return DICompositeType.classof(From);
  }

  public static DICompositeType cast_DICompositeType(Metadata/*P*/ From) {
    assert isa_DICompositeType(From);
    return (DICompositeType) From;
  }

  public static DICompositeType cast_or_null_DICompositeType(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DICompositeType(From);
  }

  public static DICompositeType dyn_cast_DICompositeType(Metadata/*P*/ From) {
    assert From != null;
    return isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static DICompositeType dyn_cast_or_null_DICompositeType(Metadata/*P*/ From) {
    return (From != null) && isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static boolean isa_DICompositeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DICompositeType.class, From.$star());
  }

  public static DICompositeType cast_DICompositeType(type$ptr<?>/*P*/ From) {
    assert isa_DICompositeType(From);
    return llvm.cast(DICompositeType.class, From.$star());
  }

  public static DICompositeType cast_or_null_DICompositeType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DICompositeType(From);
  }

  public static DICompositeType dyn_cast_DICompositeType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static DICompositeType dyn_cast_or_null_DICompositeType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static boolean isa_DICompositeType(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DICompositeType(From.get());
  }

  public static DICompositeType cast_DICompositeType(MDOperand/*P*/ From) {
    return cast_DICompositeType(From.get());
  }

  public static DICompositeType cast_or_null_DICompositeType(MDOperand/*P*/ From) {
    return cast_or_null_DICompositeType(From.get());
  }

  public static DICompositeType dyn_cast_DICompositeType(MDOperand/*P*/ From) {
    return isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static DICompositeType dyn_cast_or_null_DICompositeType(MDOperand/*P*/ From) {
    return (From != null) && isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static boolean isa_DICompositeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DICompositeType.class, From.$deref());
  }

  public static DICompositeType cast_DICompositeType(type$ref<?>/*P*/ From) {
    assert isa_DICompositeType(From);
    return llvm.cast(DICompositeType.class, From.$deref());
  }

  public static DICompositeType cast_or_null_DICompositeType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DICompositeType(From);
  }

  public static DICompositeType dyn_cast_DICompositeType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static DICompositeType dyn_cast_or_null_DICompositeType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DICompositeType(From) ? cast_DICompositeType(From) : null;
  }

  public static boolean isa_DIDerivedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIDerivedType.class, From.$deref());
  }

  public static DIDerivedType cast_DIDerivedType(type$ref<?>/*P*/ From) {
    assert isa_DIDerivedType(From);
    return llvm.cast(DIDerivedType.class, From.$deref());
  }

  public static DIDerivedType cast_or_null_DIDerivedType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIDerivedType(From);
  }

  public static DIDerivedType dyn_cast_DIDerivedType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static DIDerivedType dyn_cast_or_null_DIDerivedType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static boolean isa_DIDerivedType(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIDerivedType(From.get());
  }

  public static DIDerivedType cast_DIDerivedType(MDOperand/*P*/ From) {
    return cast_DIDerivedType(From.get());
  }

  public static DIDerivedType cast_or_null_DIDerivedType(MDOperand/*P*/ From) {
    return cast_or_null_DIDerivedType(From.get());
  }

  public static DIDerivedType dyn_cast_DIDerivedType(MDOperand/*P*/ From) {
    return isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static DIDerivedType dyn_cast_or_null_DIDerivedType(MDOperand/*P*/ From) {
    return (From != null) && isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static boolean isa_DIDerivedType(Metadata/*P*/ From) {
    assert From != null;
    return DIDerivedType.classof(From);
  }

  public static DIDerivedType cast_DIDerivedType(Metadata/*P*/ From) {
    assert isa_DIDerivedType(From);
    return (DIDerivedType) From;
  }

  public static DIDerivedType cast_or_null_DIDerivedType(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIDerivedType(From);
  }

  public static DIDerivedType dyn_cast_DIDerivedType(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static DIDerivedType dyn_cast_or_null_DIDerivedType(Metadata/*P*/ From) {
    return (From != null) && isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static boolean isa_DIDerivedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIDerivedType.class, From.$star());
  }

  public static DIDerivedType cast_DIDerivedType(type$ptr<?>/*P*/ From) {
    assert isa_DIDerivedType(From);
    return llvm.cast(DIDerivedType.class, From.$star());
  }

  public static DIDerivedType cast_or_null_DIDerivedType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIDerivedType(From);
  }

  public static DIDerivedType dyn_cast_DIDerivedType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static DIDerivedType dyn_cast_or_null_DIDerivedType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIDerivedType(From) ? cast_DIDerivedType(From) : null;
  }

  public static boolean isa_DIEnumerator(Metadata/*P*/ From) {
    assert From != null;
    return DIEnumerator.classof(From);
  }

  public static DIEnumerator cast_DIEnumerator(Metadata/*P*/ From) {
    assert isa_DIEnumerator(From);
    return (DIEnumerator) From;
  }

  public static DIEnumerator cast_or_null_DIEnumerator(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIEnumerator(From);
  }

  public static DIEnumerator dyn_cast_DIEnumerator(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static DIEnumerator dyn_cast_or_null_DIEnumerator(Metadata/*P*/ From) {
    return (From != null) && isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static boolean isa_DIEnumerator(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIEnumerator(From.get());
  }

  public static DIEnumerator cast_DIEnumerator(MDOperand/*P*/ From) {
    return cast_DIEnumerator(From.get());
  }

  public static DIEnumerator cast_or_null_DIEnumerator(MDOperand/*P*/ From) {
    return cast_or_null_DIEnumerator(From.get());
  }

  public static DIEnumerator dyn_cast_DIEnumerator(MDOperand/*P*/ From) {
    return isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static DIEnumerator dyn_cast_or_null_DIEnumerator(MDOperand/*P*/ From) {
    return (From != null) && isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static boolean isa_DIEnumerator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIEnumerator.class, From.$star());
  }

  public static DIEnumerator cast_DIEnumerator(type$ptr<?>/*P*/ From) {
    assert isa_DIEnumerator(From);
    return llvm.cast(DIEnumerator.class, From.$star());
  }

  public static DIEnumerator cast_or_null_DIEnumerator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIEnumerator(From);
  }

  public static DIEnumerator dyn_cast_DIEnumerator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static DIEnumerator dyn_cast_or_null_DIEnumerator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static boolean isa_DIEnumerator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIEnumerator.class, From.$deref());
  }

  public static DIEnumerator cast_DIEnumerator(type$ref<?>/*P*/ From) {
    assert isa_DIEnumerator(From);
    return llvm.cast(DIEnumerator.class, From.$deref());
  }

  public static DIEnumerator cast_or_null_DIEnumerator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIEnumerator(From);
  }

  public static DIEnumerator dyn_cast_DIEnumerator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static DIEnumerator dyn_cast_or_null_DIEnumerator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIEnumerator(From) ? cast_DIEnumerator(From) : null;
  }

  public static boolean isa_DIExpression(Metadata/*P*/ From) {
    assert From != null;
    return DIExpression.classof(From);
  }

  public static DIExpression cast_DIExpression(Metadata/*P*/ From) {
    assert isa_DIExpression(From);
    return (DIExpression) From;
  }

  public static DIExpression cast_or_null_DIExpression(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIExpression(From);
  }

  public static DIExpression dyn_cast_DIExpression(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static DIExpression dyn_cast_or_null_DIExpression(Metadata/*P*/ From) {
    return (From != null) && isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static boolean isa_DIExpression(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIExpression.class, From.$star());
  }

  public static DIExpression cast_DIExpression(type$ptr<?>/*P*/ From) {
    assert isa_DIExpression(From);
    return llvm.cast(DIExpression.class, From.$star());
  }

  public static DIExpression cast_or_null_DIExpression(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIExpression(From);
  }

  public static DIExpression dyn_cast_DIExpression(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static DIExpression dyn_cast_or_null_DIExpression(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static boolean isa_DIExpression(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIExpression.class, From.$deref());
  }

  public static DIExpression cast_DIExpression(type$ref<?>/*P*/ From) {
    assert isa_DIExpression(From);
    return llvm.cast(DIExpression.class, From.$deref());
  }

  public static DIExpression cast_or_null_DIExpression(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIExpression(From);
  }

  public static DIExpression dyn_cast_DIExpression(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static DIExpression dyn_cast_or_null_DIExpression(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static boolean isa_DIExpression(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIExpression(From.get());
  }

  public static DIExpression cast_DIExpression(MDOperand/*P*/ From) {
    return cast_DIExpression(From.get());
  }

  public static DIExpression cast_or_null_DIExpression(MDOperand/*P*/ From) {
    return cast_or_null_DIExpression(From.get());
  }

  public static DIExpression dyn_cast_DIExpression(MDOperand/*P*/ From) {
    return isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static DIExpression dyn_cast_or_null_DIExpression(MDOperand/*P*/ From) {
    return (From != null) && isa_DIExpression(From) ? cast_DIExpression(From) : null;
  }

  public static boolean isa_DIFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIFile.class, From.$star());
  }

  public static DIFile cast_DIFile(type$ptr<?>/*P*/ From) {
    assert isa_DIFile(From);
    return llvm.cast(DIFile.class, From.$star());
  }

  public static DIFile cast_or_null_DIFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIFile(From);
  }

  public static DIFile dyn_cast_DIFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static DIFile dyn_cast_or_null_DIFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static boolean isa_DIFile(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIFile(From.get());
  }

  public static DIFile cast_DIFile(MDOperand/*P*/ From) {
    return cast_DIFile(From.get());
  }

  public static DIFile cast_or_null_DIFile(MDOperand/*P*/ From) {
    return cast_or_null_DIFile(From.get());
  }

  public static DIFile dyn_cast_DIFile(MDOperand/*P*/ From) {
    return isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static DIFile dyn_cast_or_null_DIFile(MDOperand/*P*/ From) {
    return (From != null) && isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static boolean isa_DIFile(Metadata/*P*/ From) {
    assert From != null;
    return DIFile.classof(From);
  }

  public static DIFile cast_DIFile(Metadata/*P*/ From) {
    assert isa_DIFile(From);
    return (DIFile) From;
  }

  public static DIFile cast_or_null_DIFile(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIFile(From);
  }

  public static DIFile dyn_cast_DIFile(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static DIFile dyn_cast_or_null_DIFile(Metadata/*P*/ From) {
    return (From != null) && isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static boolean isa_DIFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIFile.class, From.$deref());
  }

  public static DIFile cast_DIFile(type$ref<?>/*P*/ From) {
    assert isa_DIFile(From);
    return llvm.cast(DIFile.class, From.$deref());
  }

  public static DIFile cast_or_null_DIFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIFile(From);
  }

  public static DIFile dyn_cast_DIFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static DIFile dyn_cast_or_null_DIFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIFile(From) ? cast_DIFile(From) : null;
  }

  public static boolean isa_DIGlobalVariable(Metadata/*P*/ From) {
    assert From != null;
    return DIGlobalVariable.classof(From);
  }

  public static DIGlobalVariable cast_DIGlobalVariable(Metadata/*P*/ From) {
    assert isa_DIGlobalVariable(From);
    return (DIGlobalVariable) From;
  }

  public static DIGlobalVariable cast_or_null_DIGlobalVariable(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIGlobalVariable(From);
  }

  public static DIGlobalVariable dyn_cast_DIGlobalVariable(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static DIGlobalVariable dyn_cast_or_null_DIGlobalVariable(Metadata/*P*/ From) {
    return (From != null) && isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static boolean isa_DIGlobalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIGlobalVariable.class, From.$star());
  }

  public static DIGlobalVariable cast_DIGlobalVariable(type$ptr<?>/*P*/ From) {
    assert isa_DIGlobalVariable(From);
    return llvm.cast(DIGlobalVariable.class, From.$star());
  }

  public static DIGlobalVariable cast_or_null_DIGlobalVariable(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIGlobalVariable(From);
  }

  public static DIGlobalVariable dyn_cast_DIGlobalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static DIGlobalVariable dyn_cast_or_null_DIGlobalVariable(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static boolean isa_DIGlobalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIGlobalVariable.class, From.$deref());
  }

  public static DIGlobalVariable cast_DIGlobalVariable(type$ref<?>/*P*/ From) {
    assert isa_DIGlobalVariable(From);
    return llvm.cast(DIGlobalVariable.class, From.$deref());
  }

  public static DIGlobalVariable cast_or_null_DIGlobalVariable(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIGlobalVariable(From);
  }

  public static DIGlobalVariable dyn_cast_DIGlobalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static DIGlobalVariable dyn_cast_or_null_DIGlobalVariable(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static boolean isa_DIGlobalVariable(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIGlobalVariable(From.get());
  }

  public static DIGlobalVariable cast_DIGlobalVariable(MDOperand/*P*/ From) {
    return cast_DIGlobalVariable(From.get());
  }

  public static DIGlobalVariable cast_or_null_DIGlobalVariable(MDOperand/*P*/ From) {
    return cast_or_null_DIGlobalVariable(From.get());
  }

  public static DIGlobalVariable dyn_cast_DIGlobalVariable(MDOperand/*P*/ From) {
    return isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static DIGlobalVariable dyn_cast_or_null_DIGlobalVariable(MDOperand/*P*/ From) {
    return (From != null) && isa_DIGlobalVariable(From) ? cast_DIGlobalVariable(From) : null;
  }

  public static boolean isa_DIImportedEntity(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIImportedEntity.class, From.$deref());
  }

  public static DIImportedEntity cast_DIImportedEntity(type$ref<?>/*P*/ From) {
    assert isa_DIImportedEntity(From);
    return llvm.cast(DIImportedEntity.class, From.$deref());
  }

  public static DIImportedEntity cast_or_null_DIImportedEntity(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIImportedEntity(From);
  }

  public static DIImportedEntity dyn_cast_DIImportedEntity(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static DIImportedEntity dyn_cast_or_null_DIImportedEntity(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static boolean isa_DIImportedEntity(Metadata/*P*/ From) {
    assert From != null;
    return DIImportedEntity.classof(From);
  }

  public static DIImportedEntity cast_DIImportedEntity(Metadata/*P*/ From) {
    assert isa_DIImportedEntity(From);
    return (DIImportedEntity) From;
  }

  public static DIImportedEntity cast_or_null_DIImportedEntity(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIImportedEntity(From);
  }

  public static DIImportedEntity dyn_cast_DIImportedEntity(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static DIImportedEntity dyn_cast_or_null_DIImportedEntity(Metadata/*P*/ From) {
    return (From != null) && isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static boolean isa_DIImportedEntity(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIImportedEntity(From.get());
  }

  public static DIImportedEntity cast_DIImportedEntity(MDOperand/*P*/ From) {
    return cast_DIImportedEntity(From.get());
  }

  public static DIImportedEntity cast_or_null_DIImportedEntity(MDOperand/*P*/ From) {
    return cast_or_null_DIImportedEntity(From.get());
  }

  public static DIImportedEntity dyn_cast_DIImportedEntity(MDOperand/*P*/ From) {
    return isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static DIImportedEntity dyn_cast_or_null_DIImportedEntity(MDOperand/*P*/ From) {
    return (From != null) && isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static boolean isa_DIImportedEntity(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIImportedEntity.class, From.$star());
  }

  public static DIImportedEntity cast_DIImportedEntity(type$ptr<?>/*P*/ From) {
    assert isa_DIImportedEntity(From);
    return llvm.cast(DIImportedEntity.class, From.$star());
  }

  public static DIImportedEntity cast_or_null_DIImportedEntity(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIImportedEntity(From);
  }

  public static DIImportedEntity dyn_cast_DIImportedEntity(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static DIImportedEntity dyn_cast_or_null_DIImportedEntity(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIImportedEntity(From) ? cast_DIImportedEntity(From) : null;
  }

  public static boolean isa_DILexicalBlock(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILexicalBlock.class, From.$deref());
  }

  public static DILexicalBlock cast_DILexicalBlock(type$ref<?>/*P*/ From) {
    assert isa_DILexicalBlock(From);
    return llvm.cast(DILexicalBlock.class, From.$deref());
  }

  public static DILexicalBlock cast_or_null_DILexicalBlock(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILexicalBlock(From);
  }

  public static DILexicalBlock dyn_cast_DILexicalBlock(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static DILexicalBlock dyn_cast_or_null_DILexicalBlock(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static boolean isa_DILexicalBlock(Metadata/*P*/ From) {
    assert From != null;
    return DILexicalBlock.classof(From);
  }

  public static DILexicalBlock cast_DILexicalBlock(Metadata/*P*/ From) {
    assert isa_DILexicalBlock(From);
    return (DILexicalBlock) From;
  }

  public static DILexicalBlock cast_or_null_DILexicalBlock(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILexicalBlock(From);
  }

  public static DILexicalBlock dyn_cast_DILexicalBlock(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static DILexicalBlock dyn_cast_or_null_DILexicalBlock(Metadata/*P*/ From) {
    return (From != null) && isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static boolean isa_DILexicalBlock(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILexicalBlock(From.get());
  }

  public static DILexicalBlock cast_DILexicalBlock(MDOperand/*P*/ From) {
    return cast_DILexicalBlock(From.get());
  }

  public static DILexicalBlock cast_or_null_DILexicalBlock(MDOperand/*P*/ From) {
    return cast_or_null_DILexicalBlock(From.get());
  }

  public static DILexicalBlock dyn_cast_DILexicalBlock(MDOperand/*P*/ From) {
    return isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static DILexicalBlock dyn_cast_or_null_DILexicalBlock(MDOperand/*P*/ From) {
    return (From != null) && isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static boolean isa_DILexicalBlock(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILexicalBlock.class, From.$star());
  }

  public static DILexicalBlock cast_DILexicalBlock(type$ptr<?>/*P*/ From) {
    assert isa_DILexicalBlock(From);
    return llvm.cast(DILexicalBlock.class, From.$star());
  }

  public static DILexicalBlock cast_or_null_DILexicalBlock(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILexicalBlock(From);
  }

  public static DILexicalBlock dyn_cast_DILexicalBlock(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static DILexicalBlock dyn_cast_or_null_DILexicalBlock(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILexicalBlock(From) ? cast_DILexicalBlock(From) : null;
  }

  public static boolean isa_DILexicalBlockBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILexicalBlockBase.class, From.$deref());
  }

  public static DILexicalBlockBase cast_DILexicalBlockBase(type$ref<?>/*P*/ From) {
    assert isa_DILexicalBlockBase(From);
    return llvm.cast(DILexicalBlockBase.class, From.$deref());
  }

  public static DILexicalBlockBase cast_or_null_DILexicalBlockBase(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILexicalBlockBase(From);
  }

  public static DILexicalBlockBase dyn_cast_DILexicalBlockBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static DILexicalBlockBase dyn_cast_or_null_DILexicalBlockBase(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static boolean isa_DILexicalBlockBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILexicalBlockBase.class, From.$star());
  }

  public static DILexicalBlockBase cast_DILexicalBlockBase(type$ptr<?>/*P*/ From) {
    assert isa_DILexicalBlockBase(From);
    return llvm.cast(DILexicalBlockBase.class, From.$star());
  }

  public static DILexicalBlockBase cast_or_null_DILexicalBlockBase(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILexicalBlockBase(From);
  }

  public static DILexicalBlockBase dyn_cast_DILexicalBlockBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static DILexicalBlockBase dyn_cast_or_null_DILexicalBlockBase(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static boolean isa_DILexicalBlockBase(Metadata/*P*/ From) {
    assert From != null;
    return DILexicalBlockBase.classof(From);
  }

  public static DILexicalBlockBase cast_DILexicalBlockBase(Metadata/*P*/ From) {
    assert isa_DILexicalBlockBase(From);
    return (DILexicalBlockBase) From;
  }

  public static DILexicalBlockBase cast_or_null_DILexicalBlockBase(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILexicalBlockBase(From);
  }

  public static DILexicalBlockBase dyn_cast_DILexicalBlockBase(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static DILexicalBlockBase dyn_cast_or_null_DILexicalBlockBase(Metadata/*P*/ From) {
    return (From != null) && isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static boolean isa_DILexicalBlockBase(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILexicalBlockBase(From.get());
  }

  public static DILexicalBlockBase cast_DILexicalBlockBase(MDOperand/*P*/ From) {
    return cast_DILexicalBlockBase(From.get());
  }

  public static DILexicalBlockBase cast_or_null_DILexicalBlockBase(MDOperand/*P*/ From) {
    return cast_or_null_DILexicalBlockBase(From.get());
  }

  public static DILexicalBlockBase dyn_cast_DILexicalBlockBase(MDOperand/*P*/ From) {
    return isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static DILexicalBlockBase dyn_cast_or_null_DILexicalBlockBase(MDOperand/*P*/ From) {
    return (From != null) && isa_DILexicalBlockBase(From) ? cast_DILexicalBlockBase(From) : null;
  }

  public static boolean isa_DILexicalBlockFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILexicalBlockFile.class, From.$star());
  }

  public static DILexicalBlockFile cast_DILexicalBlockFile(type$ptr<?>/*P*/ From) {
    assert isa_DILexicalBlockFile(From);
    return llvm.cast(DILexicalBlockFile.class, From.$star());
  }

  public static DILexicalBlockFile cast_or_null_DILexicalBlockFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILexicalBlockFile(From);
  }

  public static DILexicalBlockFile dyn_cast_DILexicalBlockFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static DILexicalBlockFile dyn_cast_or_null_DILexicalBlockFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static boolean isa_DILexicalBlockFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILexicalBlockFile.class, From.$deref());
  }

  public static DILexicalBlockFile cast_DILexicalBlockFile(type$ref<?>/*P*/ From) {
    assert isa_DILexicalBlockFile(From);
    return llvm.cast(DILexicalBlockFile.class, From.$deref());
  }

  public static DILexicalBlockFile cast_or_null_DILexicalBlockFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILexicalBlockFile(From);
  }

  public static DILexicalBlockFile dyn_cast_DILexicalBlockFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static DILexicalBlockFile dyn_cast_or_null_DILexicalBlockFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static boolean isa_DILexicalBlockFile(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILexicalBlockFile(From.get());
  }

  public static DILexicalBlockFile cast_DILexicalBlockFile(MDOperand/*P*/ From) {
    return cast_DILexicalBlockFile(From.get());
  }

  public static DILexicalBlockFile cast_or_null_DILexicalBlockFile(MDOperand/*P*/ From) {
    return cast_or_null_DILexicalBlockFile(From.get());
  }

  public static DILexicalBlockFile dyn_cast_DILexicalBlockFile(MDOperand/*P*/ From) {
    return isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static DILexicalBlockFile dyn_cast_or_null_DILexicalBlockFile(MDOperand/*P*/ From) {
    return (From != null) && isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static boolean isa_DILexicalBlockFile(Metadata/*P*/ From) {
    assert From != null;
    return DILexicalBlockFile.classof(From);
  }

  public static DILexicalBlockFile cast_DILexicalBlockFile(Metadata/*P*/ From) {
    assert isa_DILexicalBlockFile(From);
    return (DILexicalBlockFile) From;
  }

  public static DILexicalBlockFile cast_or_null_DILexicalBlockFile(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILexicalBlockFile(From);
  }

  public static DILexicalBlockFile dyn_cast_DILexicalBlockFile(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static DILexicalBlockFile dyn_cast_or_null_DILexicalBlockFile(Metadata/*P*/ From) {
    return (From != null) && isa_DILexicalBlockFile(From) ? cast_DILexicalBlockFile(From) : null;
  }

  public static boolean isa_DILocalScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILocalScope.class, From.$deref());
  }

  public static DILocalScope cast_DILocalScope(type$ref<?>/*P*/ From) {
    assert isa_DILocalScope(From);
    return llvm.cast(DILocalScope.class, From.$deref());
  }

  public static DILocalScope cast_or_null_DILocalScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILocalScope(From);
  }

  public static DILocalScope dyn_cast_DILocalScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static DILocalScope dyn_cast_or_null_DILocalScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static boolean isa_DILocalScope(Metadata/*P*/ From) {
    assert From != null;
    return DILocalScope.classof(From);
  }

  public static DILocalScope cast_DILocalScope(Metadata/*P*/ From) {
    assert isa_DILocalScope(From);
    return (DILocalScope) From;
  }

  public static DILocalScope cast_or_null_DILocalScope(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILocalScope(From);
  }

  public static DILocalScope dyn_cast_DILocalScope(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static DILocalScope dyn_cast_or_null_DILocalScope(Metadata/*P*/ From) {
    return (From != null) && isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static boolean isa_DILocalScope(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILocalScope(From.get());
  }

  public static DILocalScope cast_DILocalScope(MDOperand/*P*/ From) {
    return cast_DILocalScope(From.get());
  }

  public static DILocalScope cast_or_null_DILocalScope(MDOperand/*P*/ From) {
    return cast_or_null_DILocalScope(From.get());
  }

  public static DILocalScope dyn_cast_DILocalScope(MDOperand/*P*/ From) {
    return isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static DILocalScope dyn_cast_or_null_DILocalScope(MDOperand/*P*/ From) {
    return (From != null) && isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static boolean isa_DILocalScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILocalScope.class, From.$star());
  }

  public static DILocalScope cast_DILocalScope(type$ptr<?>/*P*/ From) {
    assert isa_DILocalScope(From);
    return llvm.cast(DILocalScope.class, From.$star());
  }

  public static DILocalScope cast_or_null_DILocalScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILocalScope(From);
  }

  public static DILocalScope dyn_cast_DILocalScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static DILocalScope dyn_cast_or_null_DILocalScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILocalScope(From) ? cast_DILocalScope(From) : null;
  }

  public static boolean isa_DILocalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILocalVariable.class, From.$deref());
  }

  public static DILocalVariable cast_DILocalVariable(type$ref<?>/*P*/ From) {
    assert isa_DILocalVariable(From);
    return llvm.cast(DILocalVariable.class, From.$deref());
  }

  public static DILocalVariable cast_or_null_DILocalVariable(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILocalVariable(From);
  }

  public static DILocalVariable dyn_cast_DILocalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static DILocalVariable dyn_cast_or_null_DILocalVariable(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static boolean isa_DILocalVariable(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILocalVariable(From.get());
  }

  public static DILocalVariable cast_DILocalVariable(MDOperand/*P*/ From) {
    return cast_DILocalVariable(From.get());
  }

  public static DILocalVariable cast_or_null_DILocalVariable(MDOperand/*P*/ From) {
    return cast_or_null_DILocalVariable(From.get());
  }

  public static DILocalVariable dyn_cast_DILocalVariable(MDOperand/*P*/ From) {
    return isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static DILocalVariable dyn_cast_or_null_DILocalVariable(MDOperand/*P*/ From) {
    return (From != null) && isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static boolean isa_DILocalVariable(Metadata/*P*/ From) {
    assert From != null;
    return DILocalVariable.classof(From);
  }

  public static DILocalVariable cast_DILocalVariable(Metadata/*P*/ From) {
    assert isa_DILocalVariable(From);
    return (DILocalVariable) From;
  }

  public static DILocalVariable cast_or_null_DILocalVariable(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILocalVariable(From);
  }

  public static DILocalVariable dyn_cast_DILocalVariable(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static DILocalVariable dyn_cast_or_null_DILocalVariable(Metadata/*P*/ From) {
    return (From != null) && isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static boolean isa_DILocalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILocalVariable.class, From.$star());
  }

  public static DILocalVariable cast_DILocalVariable(type$ptr<?>/*P*/ From) {
    assert isa_DILocalVariable(From);
    return llvm.cast(DILocalVariable.class, From.$star());
  }

  public static DILocalVariable cast_or_null_DILocalVariable(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILocalVariable(From);
  }

  public static DILocalVariable dyn_cast_DILocalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static DILocalVariable dyn_cast_or_null_DILocalVariable(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILocalVariable(From) ? cast_DILocalVariable(From) : null;
  }

  public static boolean isa_DILocation(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DILocation.class, From.$star());
  }

  public static DILocation cast_DILocation(type$ptr<?>/*P*/ From) {
    assert isa_DILocation(From);
    return llvm.cast(DILocation.class, From.$star());
  }

  public static DILocation cast_or_null_DILocation(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DILocation(From);
  }

  public static DILocation dyn_cast_DILocation(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation dyn_cast_or_null_DILocation(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static boolean isa_DILocation(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DILocation.class, From.$deref());
  }

  public static DILocation cast_DILocation(type$ref<?>/*P*/ From) {
    assert isa_DILocation(From);
    return llvm.cast(DILocation.class, From.$deref());
  }

  public static DILocation cast_or_null_DILocation(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DILocation(From);
  }

  public static DILocation dyn_cast_DILocation(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation dyn_cast_or_null_DILocation(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static boolean isa_DILocation(Metadata/*P*/ From) {
    assert From != null;
    return DILocation.classof(From);
  }

  public static DILocation cast_DILocation(Metadata/*P*/ From) {
    assert isa_DILocation(From);
    return (DILocation) From;
  }

  public static DILocation cast_or_null_DILocation(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DILocation(From);
  }

  public static DILocation dyn_cast_DILocation(Metadata/*P*/ From) {
    assert From != null;
    return isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation dyn_cast_or_null_DILocation(Metadata/*P*/ From) {
    return (From != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static boolean isa_DILocation(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DILocation(From.get());
  }

  public static DILocation cast_DILocation(MDOperand/*P*/ From) {
    return cast_DILocation(From.get());
  }

  public static DILocation cast_or_null_DILocation(MDOperand/*P*/ From) {
    return cast_or_null_DILocation(From.get());
  }

  public static DILocation dyn_cast_DILocation(MDOperand/*P*/ From) {
    return isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation dyn_cast_or_null_DILocation(MDOperand/*P*/ From) {
    return (From != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static boolean isa_DIMacro(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIMacro(From.get());
  }

  public static DIMacro cast_DIMacro(MDOperand/*P*/ From) {
    return cast_DIMacro(From.get());
  }

  public static DIMacro cast_or_null_DIMacro(MDOperand/*P*/ From) {
    return cast_or_null_DIMacro(From.get());
  }

  public static DIMacro dyn_cast_DIMacro(MDOperand/*P*/ From) {
    return isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static DIMacro dyn_cast_or_null_DIMacro(MDOperand/*P*/ From) {
    return (From != null) && isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static boolean isa_DIMacro(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIMacro.class, From.$deref());
  }

  public static DIMacro cast_DIMacro(type$ref<?>/*P*/ From) {
    assert isa_DIMacro(From);
    return llvm.cast(DIMacro.class, From.$deref());
  }

  public static DIMacro cast_or_null_DIMacro(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIMacro(From);
  }

  public static DIMacro dyn_cast_DIMacro(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static DIMacro dyn_cast_or_null_DIMacro(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static boolean isa_DIMacro(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIMacro.class, From.$star());
  }

  public static DIMacro cast_DIMacro(type$ptr<?>/*P*/ From) {
    assert isa_DIMacro(From);
    return llvm.cast(DIMacro.class, From.$star());
  }

  public static DIMacro cast_or_null_DIMacro(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIMacro(From);
  }

  public static DIMacro dyn_cast_DIMacro(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static DIMacro dyn_cast_or_null_DIMacro(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static boolean isa_DIMacro(Metadata/*P*/ From) {
    assert From != null;
    return DIMacro.classof(From);
  }

  public static DIMacro cast_DIMacro(Metadata/*P*/ From) {
    assert isa_DIMacro(From);
    return (DIMacro) From;
  }

  public static DIMacro cast_or_null_DIMacro(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIMacro(From);
  }

  public static DIMacro dyn_cast_DIMacro(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static DIMacro dyn_cast_or_null_DIMacro(Metadata/*P*/ From) {
    return (From != null) && isa_DIMacro(From) ? cast_DIMacro(From) : null;
  }

  public static boolean isa_DIMacroFile(Metadata/*P*/ From) {
    assert From != null;
    return DIMacroFile.classof(From);
  }

  public static DIMacroFile cast_DIMacroFile(Metadata/*P*/ From) {
    assert isa_DIMacroFile(From);
    return (DIMacroFile) From;
  }

  public static DIMacroFile cast_or_null_DIMacroFile(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIMacroFile(From);
  }

  public static DIMacroFile dyn_cast_DIMacroFile(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static DIMacroFile dyn_cast_or_null_DIMacroFile(Metadata/*P*/ From) {
    return (From != null) && isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static boolean isa_DIMacroFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIMacroFile.class, From.$star());
  }

  public static DIMacroFile cast_DIMacroFile(type$ptr<?>/*P*/ From) {
    assert isa_DIMacroFile(From);
    return llvm.cast(DIMacroFile.class, From.$star());
  }

  public static DIMacroFile cast_or_null_DIMacroFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIMacroFile(From);
  }

  public static DIMacroFile dyn_cast_DIMacroFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static DIMacroFile dyn_cast_or_null_DIMacroFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static boolean isa_DIMacroFile(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIMacroFile(From.get());
  }

  public static DIMacroFile cast_DIMacroFile(MDOperand/*P*/ From) {
    return cast_DIMacroFile(From.get());
  }

  public static DIMacroFile cast_or_null_DIMacroFile(MDOperand/*P*/ From) {
    return cast_or_null_DIMacroFile(From.get());
  }

  public static DIMacroFile dyn_cast_DIMacroFile(MDOperand/*P*/ From) {
    return isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static DIMacroFile dyn_cast_or_null_DIMacroFile(MDOperand/*P*/ From) {
    return (From != null) && isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static boolean isa_DIMacroFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIMacroFile.class, From.$deref());
  }

  public static DIMacroFile cast_DIMacroFile(type$ref<?>/*P*/ From) {
    assert isa_DIMacroFile(From);
    return llvm.cast(DIMacroFile.class, From.$deref());
  }

  public static DIMacroFile cast_or_null_DIMacroFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIMacroFile(From);
  }

  public static DIMacroFile dyn_cast_DIMacroFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static DIMacroFile dyn_cast_or_null_DIMacroFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIMacroFile(From) ? cast_DIMacroFile(From) : null;
  }

  public static boolean isa_DIMacroNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIMacroNode.class, From.$deref());
  }

  public static DIMacroNode cast_DIMacroNode(type$ref<?>/*P*/ From) {
    assert isa_DIMacroNode(From);
    return llvm.cast(DIMacroNode.class, From.$deref());
  }

  public static DIMacroNode cast_or_null_DIMacroNode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIMacroNode(From);
  }

  public static DIMacroNode dyn_cast_DIMacroNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static DIMacroNode dyn_cast_or_null_DIMacroNode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static boolean isa_DIMacroNode(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIMacroNode(From.get());
  }

  public static DIMacroNode cast_DIMacroNode(MDOperand/*P*/ From) {
    return cast_DIMacroNode(From.get());
  }

  public static DIMacroNode cast_or_null_DIMacroNode(MDOperand/*P*/ From) {
    return cast_or_null_DIMacroNode(From.get());
  }

  public static DIMacroNode dyn_cast_DIMacroNode(MDOperand/*P*/ From) {
    return isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static DIMacroNode dyn_cast_or_null_DIMacroNode(MDOperand/*P*/ From) {
    return (From != null) && isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static boolean isa_DIMacroNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIMacroNode.class, From.$star());
  }

  public static DIMacroNode cast_DIMacroNode(type$ptr<?>/*P*/ From) {
    assert isa_DIMacroNode(From);
    return llvm.cast(DIMacroNode.class, From.$star());
  }

  public static DIMacroNode cast_or_null_DIMacroNode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIMacroNode(From);
  }

  public static DIMacroNode dyn_cast_DIMacroNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static DIMacroNode dyn_cast_or_null_DIMacroNode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static boolean isa_DIMacroNode(Metadata/*P*/ From) {
    assert From != null;
    return DIMacroNode.classof(From);
  }

  public static DIMacroNode cast_DIMacroNode(Metadata/*P*/ From) {
    assert isa_DIMacroNode(From);
    return (DIMacroNode) From;
  }

  public static DIMacroNode cast_or_null_DIMacroNode(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIMacroNode(From);
  }

  public static DIMacroNode dyn_cast_DIMacroNode(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static DIMacroNode dyn_cast_or_null_DIMacroNode(Metadata/*P*/ From) {
    return (From != null) && isa_DIMacroNode(From) ? cast_DIMacroNode(From) : null;
  }

  public static boolean isa_DIModule(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIModule.class, From.$star());
  }

  public static DIModule cast_DIModule(type$ptr<?>/*P*/ From) {
    assert isa_DIModule(From);
    return llvm.cast(DIModule.class, From.$star());
  }

  public static DIModule cast_or_null_DIModule(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIModule(From);
  }

  public static DIModule dyn_cast_DIModule(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static DIModule dyn_cast_or_null_DIModule(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static boolean isa_DIModule(Metadata/*P*/ From) {
    assert From != null;
    return DIModule.classof(From);
  }

  public static DIModule cast_DIModule(Metadata/*P*/ From) {
    assert isa_DIModule(From);
    return (DIModule) From;
  }

  public static DIModule cast_or_null_DIModule(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIModule(From);
  }

  public static DIModule dyn_cast_DIModule(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static DIModule dyn_cast_or_null_DIModule(Metadata/*P*/ From) {
    return (From != null) && isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static boolean isa_DIModule(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIModule(From.get());
  }

  public static DIModule cast_DIModule(MDOperand/*P*/ From) {
    return cast_DIModule(From.get());
  }

  public static DIModule cast_or_null_DIModule(MDOperand/*P*/ From) {
    return cast_or_null_DIModule(From.get());
  }

  public static DIModule dyn_cast_DIModule(MDOperand/*P*/ From) {
    return isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static DIModule dyn_cast_or_null_DIModule(MDOperand/*P*/ From) {
    return (From != null) && isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static boolean isa_DIModule(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIModule.class, From.$deref());
  }

  public static DIModule cast_DIModule(type$ref<?>/*P*/ From) {
    assert isa_DIModule(From);
    return llvm.cast(DIModule.class, From.$deref());
  }

  public static DIModule cast_or_null_DIModule(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIModule(From);
  }

  public static DIModule dyn_cast_DIModule(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static DIModule dyn_cast_or_null_DIModule(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIModule(From) ? cast_DIModule(From) : null;
  }

  public static boolean isa_DINamespace(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DINamespace.class, From.$deref());
  }

  public static DINamespace cast_DINamespace(type$ref<?>/*P*/ From) {
    assert isa_DINamespace(From);
    return llvm.cast(DINamespace.class, From.$deref());
  }

  public static DINamespace cast_or_null_DINamespace(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DINamespace(From);
  }

  public static DINamespace dyn_cast_DINamespace(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static DINamespace dyn_cast_or_null_DINamespace(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static boolean isa_DINamespace(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DINamespace(From.get());
  }

  public static DINamespace cast_DINamespace(MDOperand/*P*/ From) {
    return cast_DINamespace(From.get());
  }

  public static DINamespace cast_or_null_DINamespace(MDOperand/*P*/ From) {
    return cast_or_null_DINamespace(From.get());
  }

  public static DINamespace dyn_cast_DINamespace(MDOperand/*P*/ From) {
    return isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static DINamespace dyn_cast_or_null_DINamespace(MDOperand/*P*/ From) {
    return (From != null) && isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static boolean isa_DINamespace(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DINamespace.class, From.$star());
  }

  public static DINamespace cast_DINamespace(type$ptr<?>/*P*/ From) {
    assert isa_DINamespace(From);
    return llvm.cast(DINamespace.class, From.$star());
  }

  public static DINamespace cast_or_null_DINamespace(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DINamespace(From);
  }

  public static DINamespace dyn_cast_DINamespace(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static DINamespace dyn_cast_or_null_DINamespace(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static boolean isa_DINamespace(Metadata/*P*/ From) {
    assert From != null;
    return DINamespace.classof(From);
  }

  public static DINamespace cast_DINamespace(Metadata/*P*/ From) {
    assert isa_DINamespace(From);
    return (DINamespace) From;
  }

  public static DINamespace cast_or_null_DINamespace(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DINamespace(From);
  }

  public static DINamespace dyn_cast_DINamespace(Metadata/*P*/ From) {
    assert From != null;
    return isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static DINamespace dyn_cast_or_null_DINamespace(Metadata/*P*/ From) {
    return (From != null) && isa_DINamespace(From) ? cast_DINamespace(From) : null;
  }

  public static boolean isa_DINode(Metadata/*P*/ From) {
    assert From != null;
    return DINode.classof(From);
  }

  public static DINode cast_DINode(Metadata/*P*/ From) {
    assert isa_DINode(From);
    return (DINode) From;
  }

  public static DINode cast_or_null_DINode(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DINode(From);
  }

  public static DINode dyn_cast_DINode(Metadata/*P*/ From) {
    assert From != null;
    return isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static DINode dyn_cast_or_null_DINode(Metadata/*P*/ From) {
    return (From != null) && isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static boolean isa_DINode(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DINode(From.get());
  }

  public static DINode cast_DINode(MDOperand/*P*/ From) {
    return cast_DINode(From.get());
  }

  public static DINode cast_or_null_DINode(MDOperand/*P*/ From) {
    return cast_or_null_DINode(From.get());
  }

  public static DINode dyn_cast_DINode(MDOperand/*P*/ From) {
    return isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static DINode dyn_cast_or_null_DINode(MDOperand/*P*/ From) {
    return (From != null) && isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static boolean isa_DINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DINode.class, From.$deref());
  }

  public static DINode cast_DINode(type$ref<?>/*P*/ From) {
    assert isa_DINode(From);
    return llvm.cast(DINode.class, From.$deref());
  }

  public static DINode cast_or_null_DINode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DINode(From);
  }

  public static DINode dyn_cast_DINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static DINode dyn_cast_or_null_DINode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static boolean isa_DINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DINode.class, From.$star());
  }

  public static DINode cast_DINode(type$ptr<?>/*P*/ From) {
    assert isa_DINode(From);
    return llvm.cast(DINode.class, From.$star());
  }

  public static DINode cast_or_null_DINode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DINode(From);
  }

  public static DINode dyn_cast_DINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static DINode dyn_cast_or_null_DINode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DINode(From) ? cast_DINode(From) : null;
  }

  public static boolean isa_DIObjCProperty(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIObjCProperty.class, From.$deref());
  }

  public static DIObjCProperty cast_DIObjCProperty(type$ref<?>/*P*/ From) {
    assert isa_DIObjCProperty(From);
    return llvm.cast(DIObjCProperty.class, From.$deref());
  }

  public static DIObjCProperty cast_or_null_DIObjCProperty(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIObjCProperty(From);
  }

  public static DIObjCProperty dyn_cast_DIObjCProperty(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static DIObjCProperty dyn_cast_or_null_DIObjCProperty(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static boolean isa_DIObjCProperty(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIObjCProperty(From.get());
  }

  public static DIObjCProperty cast_DIObjCProperty(MDOperand/*P*/ From) {
    return cast_DIObjCProperty(From.get());
  }

  public static DIObjCProperty cast_or_null_DIObjCProperty(MDOperand/*P*/ From) {
    return cast_or_null_DIObjCProperty(From.get());
  }

  public static DIObjCProperty dyn_cast_DIObjCProperty(MDOperand/*P*/ From) {
    return isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static DIObjCProperty dyn_cast_or_null_DIObjCProperty(MDOperand/*P*/ From) {
    return (From != null) && isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static boolean isa_DIObjCProperty(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIObjCProperty.class, From.$star());
  }

  public static DIObjCProperty cast_DIObjCProperty(type$ptr<?>/*P*/ From) {
    assert isa_DIObjCProperty(From);
    return llvm.cast(DIObjCProperty.class, From.$star());
  }

  public static DIObjCProperty cast_or_null_DIObjCProperty(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIObjCProperty(From);
  }

  public static DIObjCProperty dyn_cast_DIObjCProperty(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static DIObjCProperty dyn_cast_or_null_DIObjCProperty(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static boolean isa_DIObjCProperty(Metadata/*P*/ From) {
    assert From != null;
    return DIObjCProperty.classof(From);
  }

  public static DIObjCProperty cast_DIObjCProperty(Metadata/*P*/ From) {
    assert isa_DIObjCProperty(From);
    return (DIObjCProperty) From;
  }

  public static DIObjCProperty cast_or_null_DIObjCProperty(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIObjCProperty(From);
  }

  public static DIObjCProperty dyn_cast_DIObjCProperty(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static DIObjCProperty dyn_cast_or_null_DIObjCProperty(Metadata/*P*/ From) {
    return (From != null) && isa_DIObjCProperty(From) ? cast_DIObjCProperty(From) : null;
  }

  public static boolean isa_DIScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIScope.class, From.$deref());
  }

  public static DIScope cast_DIScope(type$ref<?>/*P*/ From) {
    assert isa_DIScope(From);
    return llvm.cast(DIScope.class, From.$deref());
  }

  public static DIScope cast_or_null_DIScope(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIScope(From);
  }

  public static DIScope dyn_cast_DIScope(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static DIScope dyn_cast_or_null_DIScope(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static boolean isa_DIScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIScope.class, From.$star());
  }

  public static DIScope cast_DIScope(type$ptr<?>/*P*/ From) {
    assert isa_DIScope(From);
    return llvm.cast(DIScope.class, From.$star());
  }

  public static DIScope cast_or_null_DIScope(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIScope(From);
  }

  public static DIScope dyn_cast_DIScope(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static DIScope dyn_cast_or_null_DIScope(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static boolean isa_DIScope(Metadata/*P*/ From) {
    assert From != null;
    return DIScope.classof(From);
  }

  public static DIScope cast_DIScope(Metadata/*P*/ From) {
    assert isa_DIScope(From);
    return (DIScope) From;
  }

  public static DIScope cast_or_null_DIScope(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIScope(From);
  }

  public static DIScope dyn_cast_DIScope(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static DIScope dyn_cast_or_null_DIScope(Metadata/*P*/ From) {
    return (From != null) && isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static boolean isa_DIScope(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIScope(From.get());
  }

  public static DIScope cast_DIScope(MDOperand/*P*/ From) {
    return cast_DIScope(From.get());
  }

  public static DIScope cast_or_null_DIScope(MDOperand/*P*/ From) {
    return cast_or_null_DIScope(From.get());
  }

  public static DIScope dyn_cast_DIScope(MDOperand/*P*/ From) {
    return isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static DIScope dyn_cast_or_null_DIScope(MDOperand/*P*/ From) {
    return (From != null) && isa_DIScope(From) ? cast_DIScope(From) : null;
  }

  public static boolean isa_DISubprogram(Metadata/*P*/ From) {
    assert From != null;
    return DISubprogram.classof(From);
  }

  public static DISubprogram cast_DISubprogram(Metadata/*P*/ From) {
    assert isa_DISubprogram(From);
    return (DISubprogram) From;
  }

  public static DISubprogram cast_or_null_DISubprogram(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DISubprogram(From);
  }

  public static DISubprogram dyn_cast_DISubprogram(Metadata/*P*/ From) {
    assert From != null;
    return isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static DISubprogram dyn_cast_or_null_DISubprogram(Metadata/*P*/ From) {
    return (From != null) && isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static boolean isa_DISubprogram(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DISubprogram(From.get());
  }

  public static DISubprogram cast_DISubprogram(MDOperand/*P*/ From) {
    return cast_DISubprogram(From.get());
  }

  public static DISubprogram cast_or_null_DISubprogram(MDOperand/*P*/ From) {
    return cast_or_null_DISubprogram(From.get());
  }

  public static DISubprogram dyn_cast_DISubprogram(MDOperand/*P*/ From) {
    return isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static DISubprogram dyn_cast_or_null_DISubprogram(MDOperand/*P*/ From) {
    return (From != null) && isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static boolean isa_DISubprogram(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DISubprogram.class, From.$deref());
  }

  public static DISubprogram cast_DISubprogram(type$ref<?>/*P*/ From) {
    assert isa_DISubprogram(From);
    return llvm.cast(DISubprogram.class, From.$deref());
  }

  public static DISubprogram cast_or_null_DISubprogram(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DISubprogram(From);
  }

  public static DISubprogram dyn_cast_DISubprogram(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static DISubprogram dyn_cast_or_null_DISubprogram(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static boolean isa_DISubprogram(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DISubprogram.class, From.$star());
  }

  public static DISubprogram cast_DISubprogram(type$ptr<?>/*P*/ From) {
    assert isa_DISubprogram(From);
    return llvm.cast(DISubprogram.class, From.$star());
  }

  public static DISubprogram cast_or_null_DISubprogram(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DISubprogram(From);
  }

  public static DISubprogram dyn_cast_DISubprogram(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static DISubprogram dyn_cast_or_null_DISubprogram(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DISubprogram(From) ? cast_DISubprogram(From) : null;
  }

  public static boolean isa_DISubrange(Metadata/*P*/ From) {
    assert From != null;
    return DISubrange.classof(From);
  }

  public static DISubrange cast_DISubrange(Metadata/*P*/ From) {
    assert isa_DISubrange(From);
    return (DISubrange) From;
  }

  public static DISubrange cast_or_null_DISubrange(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DISubrange(From);
  }

  public static DISubrange dyn_cast_DISubrange(Metadata/*P*/ From) {
    assert From != null;
    return isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static DISubrange dyn_cast_or_null_DISubrange(Metadata/*P*/ From) {
    return (From != null) && isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static boolean isa_DISubrange(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DISubrange.class, From.$deref());
  }

  public static DISubrange cast_DISubrange(type$ref<?>/*P*/ From) {
    assert isa_DISubrange(From);
    return llvm.cast(DISubrange.class, From.$deref());
  }

  public static DISubrange cast_or_null_DISubrange(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DISubrange(From);
  }

  public static DISubrange dyn_cast_DISubrange(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static DISubrange dyn_cast_or_null_DISubrange(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static boolean isa_DISubrange(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DISubrange.class, From.$star());
  }

  public static DISubrange cast_DISubrange(type$ptr<?>/*P*/ From) {
    assert isa_DISubrange(From);
    return llvm.cast(DISubrange.class, From.$star());
  }

  public static DISubrange cast_or_null_DISubrange(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DISubrange(From);
  }

  public static DISubrange dyn_cast_DISubrange(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static DISubrange dyn_cast_or_null_DISubrange(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static boolean isa_DISubrange(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DISubrange(From.get());
  }

  public static DISubrange cast_DISubrange(MDOperand/*P*/ From) {
    return cast_DISubrange(From.get());
  }

  public static DISubrange cast_or_null_DISubrange(MDOperand/*P*/ From) {
    return cast_or_null_DISubrange(From.get());
  }

  public static DISubrange dyn_cast_DISubrange(MDOperand/*P*/ From) {
    return isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static DISubrange dyn_cast_or_null_DISubrange(MDOperand/*P*/ From) {
    return (From != null) && isa_DISubrange(From) ? cast_DISubrange(From) : null;
  }

  public static boolean isa_DISubroutineType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DISubroutineType.class, From.$star());
  }

  public static DISubroutineType cast_DISubroutineType(type$ptr<?>/*P*/ From) {
    assert isa_DISubroutineType(From);
    return llvm.cast(DISubroutineType.class, From.$star());
  }

  public static DISubroutineType cast_or_null_DISubroutineType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DISubroutineType(From);
  }

  public static DISubroutineType dyn_cast_DISubroutineType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static DISubroutineType dyn_cast_or_null_DISubroutineType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static boolean isa_DISubroutineType(Metadata/*P*/ From) {
    assert From != null;
    return DISubroutineType.classof(From);
  }

  public static DISubroutineType cast_DISubroutineType(Metadata/*P*/ From) {
    assert isa_DISubroutineType(From);
    return (DISubroutineType) From;
  }

  public static DISubroutineType cast_or_null_DISubroutineType(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DISubroutineType(From);
  }

  public static DISubroutineType dyn_cast_DISubroutineType(Metadata/*P*/ From) {
    assert From != null;
    return isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static DISubroutineType dyn_cast_or_null_DISubroutineType(Metadata/*P*/ From) {
    return (From != null) && isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static boolean isa_DISubroutineType(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DISubroutineType(From.get());
  }

  public static DISubroutineType cast_DISubroutineType(MDOperand/*P*/ From) {
    return cast_DISubroutineType(From.get());
  }

  public static DISubroutineType cast_or_null_DISubroutineType(MDOperand/*P*/ From) {
    return cast_or_null_DISubroutineType(From.get());
  }

  public static DISubroutineType dyn_cast_DISubroutineType(MDOperand/*P*/ From) {
    return isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static DISubroutineType dyn_cast_or_null_DISubroutineType(MDOperand/*P*/ From) {
    return (From != null) && isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static boolean isa_DISubroutineType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DISubroutineType.class, From.$deref());
  }

  public static DISubroutineType cast_DISubroutineType(type$ref<?>/*P*/ From) {
    assert isa_DISubroutineType(From);
    return llvm.cast(DISubroutineType.class, From.$deref());
  }

  public static DISubroutineType cast_or_null_DISubroutineType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DISubroutineType(From);
  }

  public static DISubroutineType dyn_cast_DISubroutineType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static DISubroutineType dyn_cast_or_null_DISubroutineType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DISubroutineType(From) ? cast_DISubroutineType(From) : null;
  }

  public static boolean isa_DITemplateParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DITemplateParameter.class, From.$deref());
  }

  public static DITemplateParameter cast_DITemplateParameter(type$ref<?>/*P*/ From) {
    assert isa_DITemplateParameter(From);
    return llvm.cast(DITemplateParameter.class, From.$deref());
  }

  public static DITemplateParameter cast_or_null_DITemplateParameter(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DITemplateParameter(From);
  }

  public static DITemplateParameter dyn_cast_DITemplateParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static DITemplateParameter dyn_cast_or_null_DITemplateParameter(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static boolean isa_DITemplateParameter(Metadata/*P*/ From) {
    assert From != null;
    return DITemplateParameter.classof(From);
  }

  public static DITemplateParameter cast_DITemplateParameter(Metadata/*P*/ From) {
    assert isa_DITemplateParameter(From);
    return (DITemplateParameter) From;
  }

  public static DITemplateParameter cast_or_null_DITemplateParameter(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DITemplateParameter(From);
  }

  public static DITemplateParameter dyn_cast_DITemplateParameter(Metadata/*P*/ From) {
    assert From != null;
    return isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static DITemplateParameter dyn_cast_or_null_DITemplateParameter(Metadata/*P*/ From) {
    return (From != null) && isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static boolean isa_DITemplateParameter(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DITemplateParameter(From.get());
  }

  public static DITemplateParameter cast_DITemplateParameter(MDOperand/*P*/ From) {
    return cast_DITemplateParameter(From.get());
  }

  public static DITemplateParameter cast_or_null_DITemplateParameter(MDOperand/*P*/ From) {
    return cast_or_null_DITemplateParameter(From.get());
  }

  public static DITemplateParameter dyn_cast_DITemplateParameter(MDOperand/*P*/ From) {
    return isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static DITemplateParameter dyn_cast_or_null_DITemplateParameter(MDOperand/*P*/ From) {
    return (From != null) && isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static boolean isa_DITemplateParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DITemplateParameter.class, From.$star());
  }

  public static DITemplateParameter cast_DITemplateParameter(type$ptr<?>/*P*/ From) {
    assert isa_DITemplateParameter(From);
    return llvm.cast(DITemplateParameter.class, From.$star());
  }

  public static DITemplateParameter cast_or_null_DITemplateParameter(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DITemplateParameter(From);
  }

  public static DITemplateParameter dyn_cast_DITemplateParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static DITemplateParameter dyn_cast_or_null_DITemplateParameter(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DITemplateParameter(From) ? cast_DITemplateParameter(From) : null;
  }

  public static boolean isa_DITemplateTypeParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DITemplateTypeParameter.class, From.$star());
  }

  public static DITemplateTypeParameter cast_DITemplateTypeParameter(type$ptr<?>/*P*/ From) {
    assert isa_DITemplateTypeParameter(From);
    return llvm.cast(DITemplateTypeParameter.class, From.$star());
  }

  public static DITemplateTypeParameter cast_or_null_DITemplateTypeParameter(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DITemplateTypeParameter(From);
  }

  public static DITemplateTypeParameter dyn_cast_DITemplateTypeParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static DITemplateTypeParameter dyn_cast_or_null_DITemplateTypeParameter(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static boolean isa_DITemplateTypeParameter(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DITemplateTypeParameter(From.get());
  }

  public static DITemplateTypeParameter cast_DITemplateTypeParameter(MDOperand/*P*/ From) {
    return cast_DITemplateTypeParameter(From.get());
  }

  public static DITemplateTypeParameter cast_or_null_DITemplateTypeParameter(MDOperand/*P*/ From) {
    return cast_or_null_DITemplateTypeParameter(From.get());
  }

  public static DITemplateTypeParameter dyn_cast_DITemplateTypeParameter(MDOperand/*P*/ From) {
    return isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static DITemplateTypeParameter dyn_cast_or_null_DITemplateTypeParameter(MDOperand/*P*/ From) {
    return (From != null) && isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static boolean isa_DITemplateTypeParameter(Metadata/*P*/ From) {
    assert From != null;
    return DITemplateTypeParameter.classof(From);
  }

  public static DITemplateTypeParameter cast_DITemplateTypeParameter(Metadata/*P*/ From) {
    assert isa_DITemplateTypeParameter(From);
    return (DITemplateTypeParameter) From;
  }

  public static DITemplateTypeParameter cast_or_null_DITemplateTypeParameter(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DITemplateTypeParameter(From);
  }

  public static DITemplateTypeParameter dyn_cast_DITemplateTypeParameter(Metadata/*P*/ From) {
    assert From != null;
    return isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static DITemplateTypeParameter dyn_cast_or_null_DITemplateTypeParameter(Metadata/*P*/ From) {
    return (From != null) && isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static boolean isa_DITemplateTypeParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DITemplateTypeParameter.class, From.$deref());
  }

  public static DITemplateTypeParameter cast_DITemplateTypeParameter(type$ref<?>/*P*/ From) {
    assert isa_DITemplateTypeParameter(From);
    return llvm.cast(DITemplateTypeParameter.class, From.$deref());
  }

  public static DITemplateTypeParameter cast_or_null_DITemplateTypeParameter(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DITemplateTypeParameter(From);
  }

  public static DITemplateTypeParameter dyn_cast_DITemplateTypeParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static DITemplateTypeParameter dyn_cast_or_null_DITemplateTypeParameter(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DITemplateTypeParameter(From) ? cast_DITemplateTypeParameter(From) : null;
  }

  public static boolean isa_DITemplateValueParameter(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DITemplateValueParameter(From.get());
  }

  public static DITemplateValueParameter cast_DITemplateValueParameter(MDOperand/*P*/ From) {
    return cast_DITemplateValueParameter(From.get());
  }

  public static DITemplateValueParameter cast_or_null_DITemplateValueParameter(MDOperand/*P*/ From) {
    return cast_or_null_DITemplateValueParameter(From.get());
  }

  public static DITemplateValueParameter dyn_cast_DITemplateValueParameter(MDOperand/*P*/ From) {
    return isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static DITemplateValueParameter dyn_cast_or_null_DITemplateValueParameter(MDOperand/*P*/ From) {
    return (From != null) && isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static boolean isa_DITemplateValueParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DITemplateValueParameter.class, From.$deref());
  }

  public static DITemplateValueParameter cast_DITemplateValueParameter(type$ref<?>/*P*/ From) {
    assert isa_DITemplateValueParameter(From);
    return llvm.cast(DITemplateValueParameter.class, From.$deref());
  }

  public static DITemplateValueParameter cast_or_null_DITemplateValueParameter(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DITemplateValueParameter(From);
  }

  public static DITemplateValueParameter dyn_cast_DITemplateValueParameter(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static DITemplateValueParameter dyn_cast_or_null_DITemplateValueParameter(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static boolean isa_DITemplateValueParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DITemplateValueParameter.class, From.$star());
  }

  public static DITemplateValueParameter cast_DITemplateValueParameter(type$ptr<?>/*P*/ From) {
    assert isa_DITemplateValueParameter(From);
    return llvm.cast(DITemplateValueParameter.class, From.$star());
  }

  public static DITemplateValueParameter cast_or_null_DITemplateValueParameter(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DITemplateValueParameter(From);
  }

  public static DITemplateValueParameter dyn_cast_DITemplateValueParameter(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static DITemplateValueParameter dyn_cast_or_null_DITemplateValueParameter(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static boolean isa_DITemplateValueParameter(Metadata/*P*/ From) {
    assert From != null;
    return DITemplateValueParameter.classof(From);
  }

  public static DITemplateValueParameter cast_DITemplateValueParameter(Metadata/*P*/ From) {
    assert isa_DITemplateValueParameter(From);
    return (DITemplateValueParameter) From;
  }

  public static DITemplateValueParameter cast_or_null_DITemplateValueParameter(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DITemplateValueParameter(From);
  }

  public static DITemplateValueParameter dyn_cast_DITemplateValueParameter(Metadata/*P*/ From) {
    assert From != null;
    return isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static DITemplateValueParameter dyn_cast_or_null_DITemplateValueParameter(Metadata/*P*/ From) {
    return (From != null) && isa_DITemplateValueParameter(From) ? cast_DITemplateValueParameter(From) : null;
  }

  public static boolean isa_DIType(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIType(From.get());
  }

  public static DIType cast_DIType(MDOperand/*P*/ From) {
    return cast_DIType(From.get());
  }

  public static DIType cast_or_null_DIType(MDOperand/*P*/ From) {
    return cast_or_null_DIType(From.get());
  }

  public static DIType dyn_cast_DIType(MDOperand/*P*/ From) {
    return isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static DIType dyn_cast_or_null_DIType(MDOperand/*P*/ From) {
    return (From != null) && isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static boolean isa_DIType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIType.class, From.$deref());
  }

  public static DIType cast_DIType(type$ref<?>/*P*/ From) {
    assert isa_DIType(From);
    return llvm.cast(DIType.class, From.$deref());
  }

  public static DIType cast_or_null_DIType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIType(From);
  }

  public static DIType dyn_cast_DIType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static DIType dyn_cast_or_null_DIType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static boolean isa_DIType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIType.class, From.$star());
  }

  public static DIType cast_DIType(type$ptr<?>/*P*/ From) {
    assert isa_DIType(From);
    return llvm.cast(DIType.class, From.$star());
  }

  public static DIType cast_or_null_DIType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIType(From);
  }

  public static DIType dyn_cast_DIType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static DIType dyn_cast_or_null_DIType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static boolean isa_DIType(Metadata/*P*/ From) {
    assert From != null;
    return DIType.classof(From);
  }

  public static DIType cast_DIType(Metadata/*P*/ From) {
    assert isa_DIType(From);
    return (DIType) From;
  }

  public static DIType cast_or_null_DIType(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIType(From);
  }

  public static DIType dyn_cast_DIType(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static DIType dyn_cast_or_null_DIType(Metadata/*P*/ From) {
    return (From != null) && isa_DIType(From) ? cast_DIType(From) : null;
  }

  public static boolean isa_DIVariable(Metadata/*P*/ From) {
    assert From != null;
    return DIVariable.classof(From);
  }

  public static DIVariable cast_DIVariable(Metadata/*P*/ From) {
    assert isa_DIVariable(From);
    return (DIVariable) From;
  }

  public static DIVariable cast_or_null_DIVariable(Metadata/*P*/ From) {
    return (From == null) ? null : cast_DIVariable(From);
  }

  public static DIVariable dyn_cast_DIVariable(Metadata/*P*/ From) {
    assert From != null;
    return isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static DIVariable dyn_cast_or_null_DIVariable(Metadata/*P*/ From) {
    return (From != null) && isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static boolean isa_DIVariable(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DIVariable(From.get());
  }

  public static DIVariable cast_DIVariable(MDOperand/*P*/ From) {
    return cast_DIVariable(From.get());
  }

  public static DIVariable cast_or_null_DIVariable(MDOperand/*P*/ From) {
    return cast_or_null_DIVariable(From.get());
  }

  public static DIVariable dyn_cast_DIVariable(MDOperand/*P*/ From) {
    return isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static DIVariable dyn_cast_or_null_DIVariable(MDOperand/*P*/ From) {
    return (From != null) && isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static boolean isa_DIVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIVariable.class, From.$star());
  }

  public static DIVariable cast_DIVariable(type$ptr<?>/*P*/ From) {
    assert isa_DIVariable(From);
    return llvm.cast(DIVariable.class, From.$star());
  }

  public static DIVariable cast_or_null_DIVariable(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIVariable(From);
  }

  public static DIVariable dyn_cast_DIVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static DIVariable dyn_cast_or_null_DIVariable(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static boolean isa_DIVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIVariable.class, From.$deref());
  }

  public static DIVariable cast_DIVariable(type$ref<?>/*P*/ From) {
    assert isa_DIVariable(From);
    return llvm.cast(DIVariable.class, From.$deref());
  }

  public static DIVariable cast_or_null_DIVariable(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIVariable(From);
  }

  public static DIVariable dyn_cast_DIVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static DIVariable dyn_cast_or_null_DIVariable(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIVariable(From) ? cast_DIVariable(From) : null;
  }

  public static boolean isa_DbgDeclareInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DbgDeclareInst(From.get());
  }

  public static DbgDeclareInst cast_DbgDeclareInst(Use/*P*/ From) {
    return cast_DbgDeclareInst(From.get());
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(Use/*P*/ From) {
    return cast_or_null_DbgDeclareInst(From.get());
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(Use/*P*/ From) {
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(Use/*P*/ From) {
    return (From != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(CallInst/*P*/ From) {
    assert From != null;
    return DbgDeclareInst.classof(From);
  }

  public static DbgDeclareInst cast_DbgDeclareInst(CallInst/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return (DbgDeclareInst) From;
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(CallInst/*P*/ From) {
    return (From != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(Instruction/*P*/ From) {
    assert From != null;
    return DbgDeclareInst.classof(From);
  }

  public static DbgDeclareInst cast_DbgDeclareInst(Instruction/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return llvm.cast(DbgDeclareInst.class, From);
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(Instruction/*P*/ From) {
    return (From != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return DbgDeclareInst.classof(From);
  }

  public static DbgDeclareInst cast_DbgDeclareInst(IntrinsicInst/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return (DbgDeclareInst) From;
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DbgDeclareInst.class, From.$deref());
  }

  public static DbgDeclareInst cast_DbgDeclareInst(type$ref<?>/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return llvm.cast(DbgDeclareInst.class, From.$deref());
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DbgDeclareInst.class, From.$star());
  }

  public static DbgDeclareInst cast_DbgDeclareInst(type$ptr<?>/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return llvm.cast(DbgDeclareInst.class, From.$star());
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgDeclareInst(Value/*P*/ From) {
    assert From != null;
    return DbgDeclareInst.classof(From);
  }

  public static DbgDeclareInst cast_DbgDeclareInst(Value/*P*/ From) {
    assert isa_DbgDeclareInst(From);
    return (DbgDeclareInst) From;
  }

  public static DbgDeclareInst cast_or_null_DbgDeclareInst(Value/*P*/ From) {
    return (From == null) ? null : cast_DbgDeclareInst(From);
  }

  public static DbgDeclareInst dyn_cast_DbgDeclareInst(Value/*P*/ From) {
    assert From != null;
    return isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static DbgDeclareInst dyn_cast_or_null_DbgDeclareInst(Value/*P*/ From) {
    return (From != null) && isa_DbgDeclareInst(From) ? cast_DbgDeclareInst(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(Instruction/*P*/ From) {
    assert From != null;
    return DbgInfoIntrinsic.classof(From);
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(Instruction/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return llvm.cast(DbgInfoIntrinsic.class, From);
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(Instruction/*P*/ From) {
    return (From == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(Instruction/*P*/ From) {
    assert From != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(Instruction/*P*/ From) {
    return (From != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DbgInfoIntrinsic.class, From.$deref());
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(type$ref<?>/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return llvm.cast(DbgInfoIntrinsic.class, From.$deref());
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(CallInst/*P*/ From) {
    assert From != null;
    return DbgInfoIntrinsic.classof(From);
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(CallInst/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return (DbgInfoIntrinsic) From;
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(CallInst/*P*/ From) {
    return (From == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(CallInst/*P*/ From) {
    assert From != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(CallInst/*P*/ From) {
    return (From != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(IntrinsicInst/*P*/ From) {
    assert From != null;
    return DbgInfoIntrinsic.classof(From);
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(IntrinsicInst/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return (DbgInfoIntrinsic) From;
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DbgInfoIntrinsic.class, From.$star());
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(type$ptr<?>/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return llvm.cast(DbgInfoIntrinsic.class, From.$star());
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DbgInfoIntrinsic(From.get());
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(Use/*P*/ From) {
    return cast_DbgInfoIntrinsic(From.get());
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(Use/*P*/ From) {
    return cast_or_null_DbgInfoIntrinsic(From.get());
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(Use/*P*/ From) {
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(Use/*P*/ From) {
    return (From != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgInfoIntrinsic(Value/*P*/ From) {
    assert From != null;
    return DbgInfoIntrinsic.classof(From);
  }

  public static DbgInfoIntrinsic cast_DbgInfoIntrinsic(Value/*P*/ From) {
    assert isa_DbgInfoIntrinsic(From);
    return (DbgInfoIntrinsic) From;
  }

  public static DbgInfoIntrinsic cast_or_null_DbgInfoIntrinsic(Value/*P*/ From) {
    return (From == null) ? null : cast_DbgInfoIntrinsic(From);
  }

  public static DbgInfoIntrinsic dyn_cast_DbgInfoIntrinsic(Value/*P*/ From) {
    assert From != null;
    return isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static DbgInfoIntrinsic dyn_cast_or_null_DbgInfoIntrinsic(Value/*P*/ From) {
    return (From != null) && isa_DbgInfoIntrinsic(From) ? cast_DbgInfoIntrinsic(From) : null;
  }

  public static boolean isa_DbgValueInst(Value/*P*/ From) {
    assert From != null;
    return DbgValueInst.classof(From);
  }

  public static DbgValueInst cast_DbgValueInst(Value/*P*/ From) {
    assert isa_DbgValueInst(From);
    return (DbgValueInst) From;
  }

  public static DbgValueInst cast_or_null_DbgValueInst(Value/*P*/ From) {
    return (From == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(Value/*P*/ From) {
    assert From != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(Value/*P*/ From) {
    return (From != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_DbgValueInst(From.get());
  }

  public static DbgValueInst cast_DbgValueInst(Use/*P*/ From) {
    return cast_DbgValueInst(From.get());
  }

  public static DbgValueInst cast_or_null_DbgValueInst(Use/*P*/ From) {
    return cast_or_null_DbgValueInst(From.get());
  }

  public static DbgValueInst dyn_cast_DbgValueInst(Use/*P*/ From) {
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(Use/*P*/ From) {
    return (From != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DbgValueInst.class, From.$deref());
  }

  public static DbgValueInst cast_DbgValueInst(type$ref<?>/*P*/ From) {
    assert isa_DbgValueInst(From);
    return llvm.cast(DbgValueInst.class, From.$deref());
  }

  public static DbgValueInst cast_or_null_DbgValueInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return DbgValueInst.classof(From);
  }

  public static DbgValueInst cast_DbgValueInst(IntrinsicInst/*P*/ From) {
    assert isa_DbgValueInst(From);
    return (DbgValueInst) From;
  }

  public static DbgValueInst cast_or_null_DbgValueInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(Instruction/*P*/ From) {
    assert From != null;
    return DbgValueInst.classof(From);
  }

  public static DbgValueInst cast_DbgValueInst(Instruction/*P*/ From) {
    assert isa_DbgValueInst(From);
    return llvm.cast(DbgValueInst.class, From);
  }

  public static DbgValueInst cast_or_null_DbgValueInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(Instruction/*P*/ From) {
    return (From != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DbgValueInst.class, From.$star());
  }

  public static DbgValueInst cast_DbgValueInst(type$ptr<?>/*P*/ From) {
    assert isa_DbgValueInst(From);
    return llvm.cast(DbgValueInst.class, From.$star());
  }

  public static DbgValueInst cast_or_null_DbgValueInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DbgValueInst(CallInst/*P*/ From) {
    assert From != null;
    return DbgValueInst.classof(From);
  }

  public static DbgValueInst cast_DbgValueInst(CallInst/*P*/ From) {
    assert isa_DbgValueInst(From);
    return (DbgValueInst) From;
  }

  public static DbgValueInst cast_or_null_DbgValueInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_DbgValueInst(From);
  }

  public static DbgValueInst dyn_cast_DbgValueInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static DbgValueInst dyn_cast_or_null_DbgValueInst(CallInst/*P*/ From) {
    return (From != null) && isa_DbgValueInst(From) ? cast_DbgValueInst(From) : null;
  }

  public static boolean isa_DiagnosticInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfo.class, From.$deref());
  }

  public static DiagnosticInfo cast_DiagnosticInfo(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfo(From);
    return llvm.cast(DiagnosticInfo.class, From.$deref());
  }

  public static DiagnosticInfo cast_or_null_DiagnosticInfo(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfo(From);
  }

  public static DiagnosticInfo dyn_cast_DiagnosticInfo(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static DiagnosticInfo dyn_cast_or_null_DiagnosticInfo(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static boolean isa_DiagnosticInfo(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DiagnosticInfo cast_DiagnosticInfo(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfo(From);
    return (DiagnosticInfo) From;
  }

  public static DiagnosticInfo cast_or_null_DiagnosticInfo(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfo(From);
  }

  public static DiagnosticInfo dyn_cast_DiagnosticInfo(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static DiagnosticInfo dyn_cast_or_null_DiagnosticInfo(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static boolean isa_DiagnosticInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfo.class, From.$star());
  }

  public static DiagnosticInfo cast_DiagnosticInfo(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfo(From);
    return llvm.cast(DiagnosticInfo.class, From.$star());
  }

  public static DiagnosticInfo cast_or_null_DiagnosticInfo(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfo(From);
  }

  public static DiagnosticInfo dyn_cast_DiagnosticInfo(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static DiagnosticInfo dyn_cast_or_null_DiagnosticInfo(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfo(From) ? cast_DiagnosticInfo(From) : null;
  }

  public static boolean isa_DiagnosticInfoDebugMetadataVersion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoDebugMetadataVersion.class, From.$star());
  }

  public static DiagnosticInfoDebugMetadataVersion cast_DiagnosticInfoDebugMetadataVersion(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoDebugMetadataVersion(From);
    return llvm.cast(DiagnosticInfoDebugMetadataVersion.class, From.$star());
  }

  public static DiagnosticInfoDebugMetadataVersion cast_or_null_DiagnosticInfoDebugMetadataVersion(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoDebugMetadataVersion(From);
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_DiagnosticInfoDebugMetadataVersion(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_or_null_DiagnosticInfoDebugMetadataVersion(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static boolean isa_DiagnosticInfoDebugMetadataVersion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoDebugMetadataVersion.class, From.$deref());
  }

  public static DiagnosticInfoDebugMetadataVersion cast_DiagnosticInfoDebugMetadataVersion(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoDebugMetadataVersion(From);
    return llvm.cast(DiagnosticInfoDebugMetadataVersion.class, From.$deref());
  }

  public static DiagnosticInfoDebugMetadataVersion cast_or_null_DiagnosticInfoDebugMetadataVersion(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoDebugMetadataVersion(From);
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_DiagnosticInfoDebugMetadataVersion(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_or_null_DiagnosticInfoDebugMetadataVersion(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static boolean isa_DiagnosticInfoDebugMetadataVersion(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoDebugMetadataVersion.classof(From);
  }

  public static DiagnosticInfoDebugMetadataVersion cast_DiagnosticInfoDebugMetadataVersion(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoDebugMetadataVersion(From);
    return (DiagnosticInfoDebugMetadataVersion) From;
  }

  public static DiagnosticInfoDebugMetadataVersion cast_or_null_DiagnosticInfoDebugMetadataVersion(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoDebugMetadataVersion(From);
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_DiagnosticInfoDebugMetadataVersion(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static DiagnosticInfoDebugMetadataVersion dyn_cast_or_null_DiagnosticInfoDebugMetadataVersion(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoDebugMetadataVersion(From) ? cast_DiagnosticInfoDebugMetadataVersion(From) : null;
  }

  public static boolean isa_DiagnosticInfoIgnoringInvalidDebugMetadata(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoIgnoringInvalidDebugMetadata.classof(From);
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_DiagnosticInfoIgnoringInvalidDebugMetadata(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
    return (DiagnosticInfoIgnoringInvalidDebugMetadata) From;
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_DiagnosticInfoIgnoringInvalidDebugMetadata(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static boolean isa_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoIgnoringInvalidDebugMetadata.class, From.$deref());
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
    return llvm.cast(DiagnosticInfoIgnoringInvalidDebugMetadata.class, From.$deref());
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static boolean isa_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoIgnoringInvalidDebugMetadata.class, From.$star());
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
    return llvm.cast(DiagnosticInfoIgnoringInvalidDebugMetadata.class, From.$star());
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From);
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static DiagnosticInfoIgnoringInvalidDebugMetadata dyn_cast_or_null_DiagnosticInfoIgnoringInvalidDebugMetadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoIgnoringInvalidDebugMetadata(From) ? cast_DiagnosticInfoIgnoringInvalidDebugMetadata(From) : null;
  }

  public static boolean isa_DiagnosticInfoInlineAsm(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoInlineAsm.class, From.$star());
  }

  public static DiagnosticInfoInlineAsm cast_DiagnosticInfoInlineAsm(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoInlineAsm(From);
    return llvm.cast(DiagnosticInfoInlineAsm.class, From.$star());
  }

  public static DiagnosticInfoInlineAsm cast_or_null_DiagnosticInfoInlineAsm(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoInlineAsm(From);
  }

  public static DiagnosticInfoInlineAsm dyn_cast_DiagnosticInfoInlineAsm(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static DiagnosticInfoInlineAsm dyn_cast_or_null_DiagnosticInfoInlineAsm(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static boolean isa_DiagnosticInfoInlineAsm(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoInlineAsm.class, From.$deref());
  }

  public static DiagnosticInfoInlineAsm cast_DiagnosticInfoInlineAsm(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoInlineAsm(From);
    return llvm.cast(DiagnosticInfoInlineAsm.class, From.$deref());
  }

  public static DiagnosticInfoInlineAsm cast_or_null_DiagnosticInfoInlineAsm(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoInlineAsm(From);
  }

  public static DiagnosticInfoInlineAsm dyn_cast_DiagnosticInfoInlineAsm(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static DiagnosticInfoInlineAsm dyn_cast_or_null_DiagnosticInfoInlineAsm(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static boolean isa_DiagnosticInfoInlineAsm(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoInlineAsm.classof(From);
  }

  public static DiagnosticInfoInlineAsm cast_DiagnosticInfoInlineAsm(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoInlineAsm(From);
    return (DiagnosticInfoInlineAsm) From;
  }

  public static DiagnosticInfoInlineAsm cast_or_null_DiagnosticInfoInlineAsm(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoInlineAsm(From);
  }

  public static DiagnosticInfoInlineAsm dyn_cast_DiagnosticInfoInlineAsm(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static DiagnosticInfoInlineAsm dyn_cast_or_null_DiagnosticInfoInlineAsm(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoInlineAsm(From) ? cast_DiagnosticInfoInlineAsm(From) : null;
  }

  public static boolean isa_DiagnosticInfoMIRParser(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoMIRParser.class, From.$deref());
  }

  public static DiagnosticInfoMIRParser cast_DiagnosticInfoMIRParser(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoMIRParser(From);
    return llvm.cast(DiagnosticInfoMIRParser.class, From.$deref());
  }

  public static DiagnosticInfoMIRParser cast_or_null_DiagnosticInfoMIRParser(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoMIRParser(From);
  }

  public static DiagnosticInfoMIRParser dyn_cast_DiagnosticInfoMIRParser(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static DiagnosticInfoMIRParser dyn_cast_or_null_DiagnosticInfoMIRParser(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static boolean isa_DiagnosticInfoMIRParser(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoMIRParser.class, From.$star());
  }

  public static DiagnosticInfoMIRParser cast_DiagnosticInfoMIRParser(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoMIRParser(From);
    return llvm.cast(DiagnosticInfoMIRParser.class, From.$star());
  }

  public static DiagnosticInfoMIRParser cast_or_null_DiagnosticInfoMIRParser(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoMIRParser(From);
  }

  public static DiagnosticInfoMIRParser dyn_cast_DiagnosticInfoMIRParser(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static DiagnosticInfoMIRParser dyn_cast_or_null_DiagnosticInfoMIRParser(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static boolean isa_DiagnosticInfoMIRParser(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoMIRParser.classof(From);
  }

  public static DiagnosticInfoMIRParser cast_DiagnosticInfoMIRParser(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoMIRParser(From);
    return (DiagnosticInfoMIRParser) From;
  }

  public static DiagnosticInfoMIRParser cast_or_null_DiagnosticInfoMIRParser(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoMIRParser(From);
  }

  public static DiagnosticInfoMIRParser dyn_cast_DiagnosticInfoMIRParser(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static DiagnosticInfoMIRParser dyn_cast_or_null_DiagnosticInfoMIRParser(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoMIRParser(From) ? cast_DiagnosticInfoMIRParser(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationBase.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationBase cast_DiagnosticInfoOptimizationBase(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationBase(From);
    return llvm.cast(DiagnosticInfoOptimizationBase.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationBase cast_or_null_DiagnosticInfoOptimizationBase(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationBase(From);
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_DiagnosticInfoOptimizationBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_or_null_DiagnosticInfoOptimizationBase(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationBase.class, From.$star());
  }

  public static DiagnosticInfoOptimizationBase cast_DiagnosticInfoOptimizationBase(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationBase(From);
    return llvm.cast(DiagnosticInfoOptimizationBase.class, From.$star());
  }

  public static DiagnosticInfoOptimizationBase cast_or_null_DiagnosticInfoOptimizationBase(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationBase(From);
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_DiagnosticInfoOptimizationBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_or_null_DiagnosticInfoOptimizationBase(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationBase(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationBase.classof(From);
  }

  public static DiagnosticInfoOptimizationBase cast_DiagnosticInfoOptimizationBase(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationBase(From);
    return (DiagnosticInfoOptimizationBase) From;
  }

  public static DiagnosticInfoOptimizationBase cast_or_null_DiagnosticInfoOptimizationBase(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationBase(From);
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_DiagnosticInfoOptimizationBase(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static DiagnosticInfoOptimizationBase dyn_cast_or_null_DiagnosticInfoOptimizationBase(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationBase(From) ? cast_DiagnosticInfoOptimizationBase(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationFailure(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationFailure.class, From.$star());
  }

  public static DiagnosticInfoOptimizationFailure cast_DiagnosticInfoOptimizationFailure(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationFailure(From);
    return llvm.cast(DiagnosticInfoOptimizationFailure.class, From.$star());
  }

  public static DiagnosticInfoOptimizationFailure cast_or_null_DiagnosticInfoOptimizationFailure(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationFailure(From);
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_DiagnosticInfoOptimizationFailure(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_or_null_DiagnosticInfoOptimizationFailure(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationFailure(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationFailure.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationFailure cast_DiagnosticInfoOptimizationFailure(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationFailure(From);
    return llvm.cast(DiagnosticInfoOptimizationFailure.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationFailure cast_or_null_DiagnosticInfoOptimizationFailure(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationFailure(From);
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_DiagnosticInfoOptimizationFailure(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_or_null_DiagnosticInfoOptimizationFailure(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationFailure(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationFailure.classof(From);
  }

  public static DiagnosticInfoOptimizationFailure cast_DiagnosticInfoOptimizationFailure(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationFailure(From);
    return (DiagnosticInfoOptimizationFailure) From;
  }

  public static DiagnosticInfoOptimizationFailure cast_or_null_DiagnosticInfoOptimizationFailure(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationFailure(From);
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_DiagnosticInfoOptimizationFailure(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static DiagnosticInfoOptimizationFailure dyn_cast_or_null_DiagnosticInfoOptimizationFailure(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationFailure(From) ? cast_DiagnosticInfoOptimizationFailure(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemark(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemark.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemark cast_DiagnosticInfoOptimizationRemark(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemark(From);
    return llvm.cast(DiagnosticInfoOptimizationRemark.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemark cast_or_null_DiagnosticInfoOptimizationRemark(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationRemark(From);
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_DiagnosticInfoOptimizationRemark(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_or_null_DiagnosticInfoOptimizationRemark(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemark(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationRemark.classof(From);
  }

  public static DiagnosticInfoOptimizationRemark cast_DiagnosticInfoOptimizationRemark(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemark(From);
    return (DiagnosticInfoOptimizationRemark) From;
  }

  public static DiagnosticInfoOptimizationRemark cast_or_null_DiagnosticInfoOptimizationRemark(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationRemark(From);
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_DiagnosticInfoOptimizationRemark(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_or_null_DiagnosticInfoOptimizationRemark(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemark(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemark.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemark cast_DiagnosticInfoOptimizationRemark(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemark(From);
    return llvm.cast(DiagnosticInfoOptimizationRemark.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemark cast_or_null_DiagnosticInfoOptimizationRemark(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationRemark(From);
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_DiagnosticInfoOptimizationRemark(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static DiagnosticInfoOptimizationRemark dyn_cast_or_null_DiagnosticInfoOptimizationRemark(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationRemark(From) ? cast_DiagnosticInfoOptimizationRemark(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysis(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysis.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_DiagnosticInfoOptimizationRemarkAnalysis(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysis(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysis.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysis(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_DiagnosticInfoOptimizationRemarkAnalysis(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysis(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationRemarkAnalysis.classof(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_DiagnosticInfoOptimizationRemarkAnalysis(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysis(From);
    return (DiagnosticInfoOptimizationRemarkAnalysis) From;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysis(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_DiagnosticInfoOptimizationRemarkAnalysis(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysis(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysis.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_DiagnosticInfoOptimizationRemarkAnalysis(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysis(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysis.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysis(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_DiagnosticInfoOptimizationRemarkAnalysis(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysis dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysis(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysis(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysis(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysisAliasing.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysisAliasing.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysisAliasing.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysisAliasing.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationRemarkAnalysisAliasing.classof(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
    return (DiagnosticInfoOptimizationRemarkAnalysisAliasing) From;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisAliasing dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysisFPCommute.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysisFPCommute.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkAnalysisFPCommute.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkAnalysisFPCommute.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationRemarkAnalysisFPCommute.classof(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
    return (DiagnosticInfoOptimizationRemarkAnalysisFPCommute) From;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From);
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkAnalysisFPCommute dyn_cast_or_null_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) ? cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkMissed(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoOptimizationRemarkMissed.classof(From);
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_DiagnosticInfoOptimizationRemarkMissed(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkMissed(From);
    return (DiagnosticInfoOptimizationRemarkMissed) From;
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_or_null_DiagnosticInfoOptimizationRemarkMissed(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoOptimizationRemarkMissed(From);
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_DiagnosticInfoOptimizationRemarkMissed(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_or_null_DiagnosticInfoOptimizationRemarkMissed(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkMissed(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkMissed.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_DiagnosticInfoOptimizationRemarkMissed(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkMissed(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkMissed.class, From.$star());
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_or_null_DiagnosticInfoOptimizationRemarkMissed(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoOptimizationRemarkMissed(From);
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_DiagnosticInfoOptimizationRemarkMissed(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_or_null_DiagnosticInfoOptimizationRemarkMissed(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static boolean isa_DiagnosticInfoOptimizationRemarkMissed(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoOptimizationRemarkMissed.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_DiagnosticInfoOptimizationRemarkMissed(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoOptimizationRemarkMissed(From);
    return llvm.cast(DiagnosticInfoOptimizationRemarkMissed.class, From.$deref());
  }

  public static DiagnosticInfoOptimizationRemarkMissed cast_or_null_DiagnosticInfoOptimizationRemarkMissed(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoOptimizationRemarkMissed(From);
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_DiagnosticInfoOptimizationRemarkMissed(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static DiagnosticInfoOptimizationRemarkMissed dyn_cast_or_null_DiagnosticInfoOptimizationRemarkMissed(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoOptimizationRemarkMissed(From) ? cast_DiagnosticInfoOptimizationRemarkMissed(From) : null;
  }

  public static boolean isa_DiagnosticInfoPGOProfile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoPGOProfile.class, From.$star());
  }

  public static DiagnosticInfoPGOProfile cast_DiagnosticInfoPGOProfile(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoPGOProfile(From);
    return llvm.cast(DiagnosticInfoPGOProfile.class, From.$star());
  }

  public static DiagnosticInfoPGOProfile cast_or_null_DiagnosticInfoPGOProfile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoPGOProfile(From);
  }

  public static DiagnosticInfoPGOProfile dyn_cast_DiagnosticInfoPGOProfile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static DiagnosticInfoPGOProfile dyn_cast_or_null_DiagnosticInfoPGOProfile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoPGOProfile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoPGOProfile.class, From.$deref());
  }

  public static DiagnosticInfoPGOProfile cast_DiagnosticInfoPGOProfile(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoPGOProfile(From);
    return llvm.cast(DiagnosticInfoPGOProfile.class, From.$deref());
  }

  public static DiagnosticInfoPGOProfile cast_or_null_DiagnosticInfoPGOProfile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoPGOProfile(From);
  }

  public static DiagnosticInfoPGOProfile dyn_cast_DiagnosticInfoPGOProfile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static DiagnosticInfoPGOProfile dyn_cast_or_null_DiagnosticInfoPGOProfile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoPGOProfile(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoPGOProfile.classof(From);
  }

  public static DiagnosticInfoPGOProfile cast_DiagnosticInfoPGOProfile(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoPGOProfile(From);
    return (DiagnosticInfoPGOProfile) From;
  }

  public static DiagnosticInfoPGOProfile cast_or_null_DiagnosticInfoPGOProfile(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoPGOProfile(From);
  }

  public static DiagnosticInfoPGOProfile dyn_cast_DiagnosticInfoPGOProfile(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static DiagnosticInfoPGOProfile dyn_cast_or_null_DiagnosticInfoPGOProfile(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoPGOProfile(From) ? cast_DiagnosticInfoPGOProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoResourceLimit(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoResourceLimit.classof(From);
  }

  public static DiagnosticInfoResourceLimit cast_DiagnosticInfoResourceLimit(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoResourceLimit(From);
    return (DiagnosticInfoResourceLimit) From;
  }

  public static DiagnosticInfoResourceLimit cast_or_null_DiagnosticInfoResourceLimit(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoResourceLimit(From);
  }

  public static DiagnosticInfoResourceLimit dyn_cast_DiagnosticInfoResourceLimit(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static DiagnosticInfoResourceLimit dyn_cast_or_null_DiagnosticInfoResourceLimit(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static boolean isa_DiagnosticInfoResourceLimit(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoResourceLimit.class, From.$deref());
  }

  public static DiagnosticInfoResourceLimit cast_DiagnosticInfoResourceLimit(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoResourceLimit(From);
    return llvm.cast(DiagnosticInfoResourceLimit.class, From.$deref());
  }

  public static DiagnosticInfoResourceLimit cast_or_null_DiagnosticInfoResourceLimit(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoResourceLimit(From);
  }

  public static DiagnosticInfoResourceLimit dyn_cast_DiagnosticInfoResourceLimit(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static DiagnosticInfoResourceLimit dyn_cast_or_null_DiagnosticInfoResourceLimit(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static boolean isa_DiagnosticInfoResourceLimit(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoResourceLimit.class, From.$star());
  }

  public static DiagnosticInfoResourceLimit cast_DiagnosticInfoResourceLimit(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoResourceLimit(From);
    return llvm.cast(DiagnosticInfoResourceLimit.class, From.$star());
  }

  public static DiagnosticInfoResourceLimit cast_or_null_DiagnosticInfoResourceLimit(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoResourceLimit(From);
  }

  public static DiagnosticInfoResourceLimit dyn_cast_DiagnosticInfoResourceLimit(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static DiagnosticInfoResourceLimit dyn_cast_or_null_DiagnosticInfoResourceLimit(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoResourceLimit(From) ? cast_DiagnosticInfoResourceLimit(From) : null;
  }

  public static boolean isa_DiagnosticInfoSampleProfile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoSampleProfile.class, From.$deref());
  }

  public static DiagnosticInfoSampleProfile cast_DiagnosticInfoSampleProfile(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoSampleProfile(From);
    return llvm.cast(DiagnosticInfoSampleProfile.class, From.$deref());
  }

  public static DiagnosticInfoSampleProfile cast_or_null_DiagnosticInfoSampleProfile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoSampleProfile(From);
  }

  public static DiagnosticInfoSampleProfile dyn_cast_DiagnosticInfoSampleProfile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static DiagnosticInfoSampleProfile dyn_cast_or_null_DiagnosticInfoSampleProfile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoSampleProfile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoSampleProfile.class, From.$star());
  }

  public static DiagnosticInfoSampleProfile cast_DiagnosticInfoSampleProfile(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoSampleProfile(From);
    return llvm.cast(DiagnosticInfoSampleProfile.class, From.$star());
  }

  public static DiagnosticInfoSampleProfile cast_or_null_DiagnosticInfoSampleProfile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoSampleProfile(From);
  }

  public static DiagnosticInfoSampleProfile dyn_cast_DiagnosticInfoSampleProfile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static DiagnosticInfoSampleProfile dyn_cast_or_null_DiagnosticInfoSampleProfile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoSampleProfile(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoSampleProfile.classof(From);
  }

  public static DiagnosticInfoSampleProfile cast_DiagnosticInfoSampleProfile(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoSampleProfile(From);
    return (DiagnosticInfoSampleProfile) From;
  }

  public static DiagnosticInfoSampleProfile cast_or_null_DiagnosticInfoSampleProfile(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoSampleProfile(From);
  }

  public static DiagnosticInfoSampleProfile dyn_cast_DiagnosticInfoSampleProfile(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static DiagnosticInfoSampleProfile dyn_cast_or_null_DiagnosticInfoSampleProfile(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoSampleProfile(From) ? cast_DiagnosticInfoSampleProfile(From) : null;
  }

  public static boolean isa_DiagnosticInfoStackSize(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoStackSize.class, From.$deref());
  }

  public static DiagnosticInfoStackSize cast_DiagnosticInfoStackSize(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoStackSize(From);
    return llvm.cast(DiagnosticInfoStackSize.class, From.$deref());
  }

  public static DiagnosticInfoStackSize cast_or_null_DiagnosticInfoStackSize(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoStackSize(From);
  }

  public static DiagnosticInfoStackSize dyn_cast_DiagnosticInfoStackSize(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static DiagnosticInfoStackSize dyn_cast_or_null_DiagnosticInfoStackSize(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static boolean isa_DiagnosticInfoStackSize(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoStackSize.classof(From);
  }

  public static DiagnosticInfoStackSize cast_DiagnosticInfoStackSize(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoStackSize(From);
    return (DiagnosticInfoStackSize) From;
  }

  public static DiagnosticInfoStackSize cast_or_null_DiagnosticInfoStackSize(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoStackSize(From);
  }

  public static DiagnosticInfoStackSize dyn_cast_DiagnosticInfoStackSize(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static DiagnosticInfoStackSize dyn_cast_or_null_DiagnosticInfoStackSize(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static boolean isa_DiagnosticInfoStackSize(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoStackSize.class, From.$star());
  }

  public static DiagnosticInfoStackSize cast_DiagnosticInfoStackSize(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoStackSize(From);
    return llvm.cast(DiagnosticInfoStackSize.class, From.$star());
  }

  public static DiagnosticInfoStackSize cast_or_null_DiagnosticInfoStackSize(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoStackSize(From);
  }

  public static DiagnosticInfoStackSize dyn_cast_DiagnosticInfoStackSize(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static DiagnosticInfoStackSize dyn_cast_or_null_DiagnosticInfoStackSize(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoStackSize(From) ? cast_DiagnosticInfoStackSize(From) : null;
  }

  public static boolean isa_DiagnosticInfoUnsupported(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoUnsupported.class, From.$star());
  }

  public static DiagnosticInfoUnsupported cast_DiagnosticInfoUnsupported(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoUnsupported(From);
    return llvm.cast(DiagnosticInfoUnsupported.class, From.$star());
  }

  public static DiagnosticInfoUnsupported cast_or_null_DiagnosticInfoUnsupported(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoUnsupported(From);
  }

  public static DiagnosticInfoUnsupported dyn_cast_DiagnosticInfoUnsupported(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static DiagnosticInfoUnsupported dyn_cast_or_null_DiagnosticInfoUnsupported(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static boolean isa_DiagnosticInfoUnsupported(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return DiagnosticInfoUnsupported.classof(From);
  }

  public static DiagnosticInfoUnsupported cast_DiagnosticInfoUnsupported(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoUnsupported(From);
    return (DiagnosticInfoUnsupported) From;
  }

  public static DiagnosticInfoUnsupported cast_or_null_DiagnosticInfoUnsupported(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoUnsupported(From);
  }

  public static DiagnosticInfoUnsupported dyn_cast_DiagnosticInfoUnsupported(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static DiagnosticInfoUnsupported dyn_cast_or_null_DiagnosticInfoUnsupported(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static boolean isa_DiagnosticInfoUnsupported(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoUnsupported.class, From.$deref());
  }

  public static DiagnosticInfoUnsupported cast_DiagnosticInfoUnsupported(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoUnsupported(From);
    return llvm.cast(DiagnosticInfoUnsupported.class, From.$deref());
  }

  public static DiagnosticInfoUnsupported cast_or_null_DiagnosticInfoUnsupported(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoUnsupported(From);
  }

  public static DiagnosticInfoUnsupported dyn_cast_DiagnosticInfoUnsupported(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static DiagnosticInfoUnsupported dyn_cast_or_null_DiagnosticInfoUnsupported(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoUnsupported(From) ? cast_DiagnosticInfoUnsupported(From) : null;
  }

  public static boolean isa_DiagnosticInfoWithDebugLocBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DiagnosticInfoWithDebugLocBase.class, From.$star());
  }

  public static DiagnosticInfoWithDebugLocBase cast_DiagnosticInfoWithDebugLocBase(type$ptr<?>/*P*/ From) {
    assert isa_DiagnosticInfoWithDebugLocBase(From);
    return llvm.cast(DiagnosticInfoWithDebugLocBase.class, From.$star());
  }

  public static DiagnosticInfoWithDebugLocBase cast_or_null_DiagnosticInfoWithDebugLocBase(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DiagnosticInfoWithDebugLocBase(From);
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_DiagnosticInfoWithDebugLocBase(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_or_null_DiagnosticInfoWithDebugLocBase(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static boolean isa_DiagnosticInfoWithDebugLocBase(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return llvm.isa(DiagnosticInfoWithDebugLocBase.class, From);
  }

  public static DiagnosticInfoWithDebugLocBase cast_DiagnosticInfoWithDebugLocBase(DiagnosticInfo/*P*/ From) {
    assert isa_DiagnosticInfoWithDebugLocBase(From);
    return (DiagnosticInfoWithDebugLocBase) From;
  }

  public static DiagnosticInfoWithDebugLocBase cast_or_null_DiagnosticInfoWithDebugLocBase(DiagnosticInfo/*P*/ From) {
    return (From == null) ? null : cast_DiagnosticInfoWithDebugLocBase(From);
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_DiagnosticInfoWithDebugLocBase(DiagnosticInfo/*P*/ From) {
    assert From != null;
    return isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_or_null_DiagnosticInfoWithDebugLocBase(DiagnosticInfo/*P*/ From) {
    return (From != null) && isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static boolean isa_DiagnosticInfoWithDebugLocBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DiagnosticInfoWithDebugLocBase.class, From.$deref());
  }

  public static DiagnosticInfoWithDebugLocBase cast_DiagnosticInfoWithDebugLocBase(type$ref<?>/*P*/ From) {
    assert isa_DiagnosticInfoWithDebugLocBase(From);
    return llvm.cast(DiagnosticInfoWithDebugLocBase.class, From.$deref());
  }

  public static DiagnosticInfoWithDebugLocBase cast_or_null_DiagnosticInfoWithDebugLocBase(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DiagnosticInfoWithDebugLocBase(From);
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_DiagnosticInfoWithDebugLocBase(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static DiagnosticInfoWithDebugLocBase dyn_cast_or_null_DiagnosticInfoWithDebugLocBase(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DiagnosticInfoWithDebugLocBase(From) ? cast_DiagnosticInfoWithDebugLocBase(From) : null;
  }

  public static boolean isa_ExtractElementInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ExtractElementInst(From.get());
  }

  public static ExtractElementInst cast_ExtractElementInst(Use/*P*/ From) {
    return cast_ExtractElementInst(From.get());
  }

  public static ExtractElementInst cast_or_null_ExtractElementInst(Use/*P*/ From) {
    return cast_or_null_ExtractElementInst(From.get());
  }

  public static ExtractElementInst dyn_cast_ExtractElementInst(Use/*P*/ From) {
    return isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static ExtractElementInst dyn_cast_or_null_ExtractElementInst(Use/*P*/ From) {
    return (From != null) && isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static boolean isa_ExtractElementInst(Instruction/*P*/ From) {
    assert From != null;
    return ExtractElementInst.classof(From);
  }

  public static ExtractElementInst cast_ExtractElementInst(Instruction/*P*/ From) {
    assert isa_ExtractElementInst(From);
    return llvm.cast(ExtractElementInst.class, From);
  }

  public static ExtractElementInst cast_or_null_ExtractElementInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ExtractElementInst(From);
  }

  public static ExtractElementInst dyn_cast_ExtractElementInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static ExtractElementInst dyn_cast_or_null_ExtractElementInst(Instruction/*P*/ From) {
    return (From != null) && isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static boolean isa_ExtractElementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtractElementInst.class, From.$deref());
  }

  public static ExtractElementInst cast_ExtractElementInst(type$ref<?>/*P*/ From) {
    assert isa_ExtractElementInst(From);
    return llvm.cast(ExtractElementInst.class, From.$deref());
  }

  public static ExtractElementInst cast_or_null_ExtractElementInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtractElementInst(From);
  }

  public static ExtractElementInst dyn_cast_ExtractElementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static ExtractElementInst dyn_cast_or_null_ExtractElementInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static boolean isa_ExtractElementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtractElementInst.class, From.$star());
  }

  public static ExtractElementInst cast_ExtractElementInst(type$ptr<?>/*P*/ From) {
    assert isa_ExtractElementInst(From);
    return llvm.cast(ExtractElementInst.class, From.$star());
  }

  public static ExtractElementInst cast_or_null_ExtractElementInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtractElementInst(From);
  }

  public static ExtractElementInst dyn_cast_ExtractElementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static ExtractElementInst dyn_cast_or_null_ExtractElementInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static boolean isa_ExtractElementInst(Value/*P*/ From) {
    assert From != null;
    return ExtractElementInst.classof(From);
  }

  public static ExtractElementInst cast_ExtractElementInst(Value/*P*/ From) {
    assert isa_ExtractElementInst(From);
    return (ExtractElementInst) From;
  }

  public static ExtractElementInst cast_or_null_ExtractElementInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ExtractElementInst(From);
  }

  public static ExtractElementInst dyn_cast_ExtractElementInst(Value/*P*/ From) {
    assert From != null;
    return isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static ExtractElementInst dyn_cast_or_null_ExtractElementInst(Value/*P*/ From) {
    return (From != null) && isa_ExtractElementInst(From) ? cast_ExtractElementInst(From) : null;
  }

  public static boolean isa_ExtractValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtractValueInst.class, From.$star());
  }

  public static ExtractValueInst cast_ExtractValueInst(type$ptr<?>/*P*/ From) {
    assert isa_ExtractValueInst(From);
    return llvm.cast(ExtractValueInst.class, From.$star());
  }

  public static ExtractValueInst cast_or_null_ExtractValueInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtractValueInst(From);
  }

  public static ExtractValueInst dyn_cast_ExtractValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static ExtractValueInst dyn_cast_or_null_ExtractValueInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static boolean isa_ExtractValueInst(Value/*P*/ From) {
    assert From != null;
    return ExtractValueInst.classof(From);
  }

  public static ExtractValueInst cast_ExtractValueInst(Value/*P*/ From) {
    assert isa_ExtractValueInst(From);
    return (ExtractValueInst) From;
  }

  public static ExtractValueInst cast_or_null_ExtractValueInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ExtractValueInst(From);
  }

  public static ExtractValueInst dyn_cast_ExtractValueInst(Value/*P*/ From) {
    assert From != null;
    return isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static ExtractValueInst dyn_cast_or_null_ExtractValueInst(Value/*P*/ From) {
    return (From != null) && isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static boolean isa_ExtractValueInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ExtractValueInst(From.get());
  }

  public static ExtractValueInst cast_ExtractValueInst(Use/*P*/ From) {
    return cast_ExtractValueInst(From.get());
  }

  public static ExtractValueInst cast_or_null_ExtractValueInst(Use/*P*/ From) {
    return cast_or_null_ExtractValueInst(From.get());
  }

  public static ExtractValueInst dyn_cast_ExtractValueInst(Use/*P*/ From) {
    return isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static ExtractValueInst dyn_cast_or_null_ExtractValueInst(Use/*P*/ From) {
    return (From != null) && isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static boolean isa_ExtractValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtractValueInst.class, From.$deref());
  }

  public static ExtractValueInst cast_ExtractValueInst(type$ref<?>/*P*/ From) {
    assert isa_ExtractValueInst(From);
    return llvm.cast(ExtractValueInst.class, From.$deref());
  }

  public static ExtractValueInst cast_or_null_ExtractValueInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtractValueInst(From);
  }

  public static ExtractValueInst dyn_cast_ExtractValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static ExtractValueInst dyn_cast_or_null_ExtractValueInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static boolean isa_ExtractValueInst(Instruction/*P*/ From) {
    assert From != null;
    return ExtractValueInst.classof(From);
  }

  public static ExtractValueInst cast_ExtractValueInst(Instruction/*P*/ From) {
    assert isa_ExtractValueInst(From);
    return llvm.cast(ExtractValueInst.class, From);
  }

  public static ExtractValueInst cast_or_null_ExtractValueInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ExtractValueInst(From);
  }

  public static ExtractValueInst dyn_cast_ExtractValueInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static ExtractValueInst dyn_cast_or_null_ExtractValueInst(Instruction/*P*/ From) {
    return (From != null) && isa_ExtractValueInst(From) ? cast_ExtractValueInst(From) : null;
  }

  public static boolean isa_FCmpInst(Instruction/*P*/ From) {
    assert From != null;
    return FCmpInst.classof(From);
  }

  public static FCmpInst cast_FCmpInst(Instruction/*P*/ From) {
    assert isa_FCmpInst(From);
    return llvm.cast(FCmpInst.class, From);
  }

  public static FCmpInst cast_or_null_FCmpInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FCmpInst(From);
  }

  public static FCmpInst dyn_cast_FCmpInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static FCmpInst dyn_cast_or_null_FCmpInst(Instruction/*P*/ From) {
    return (From != null) && isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static boolean isa_FCmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FCmpInst.class, From.$deref());
  }

  public static FCmpInst cast_FCmpInst(type$ref<?>/*P*/ From) {
    assert isa_FCmpInst(From);
    return llvm.cast(FCmpInst.class, From.$deref());
  }

  public static FCmpInst cast_or_null_FCmpInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FCmpInst(From);
  }

  public static FCmpInst dyn_cast_FCmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static FCmpInst dyn_cast_or_null_FCmpInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static boolean isa_FCmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FCmpInst.class, From.$star());
  }

  public static FCmpInst cast_FCmpInst(type$ptr<?>/*P*/ From) {
    assert isa_FCmpInst(From);
    return llvm.cast(FCmpInst.class, From.$star());
  }

  public static FCmpInst cast_or_null_FCmpInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FCmpInst(From);
  }

  public static FCmpInst dyn_cast_FCmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static FCmpInst dyn_cast_or_null_FCmpInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static boolean isa_FCmpInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FCmpInst(From.get());
  }

  public static FCmpInst cast_FCmpInst(Use/*P*/ From) {
    return cast_FCmpInst(From.get());
  }

  public static FCmpInst cast_or_null_FCmpInst(Use/*P*/ From) {
    return cast_or_null_FCmpInst(From.get());
  }

  public static FCmpInst dyn_cast_FCmpInst(Use/*P*/ From) {
    return isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static FCmpInst dyn_cast_or_null_FCmpInst(Use/*P*/ From) {
    return (From != null) && isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static boolean isa_FCmpInst(Value/*P*/ From) {
    assert From != null;
    return FCmpInst.classof(From);
  }

  public static FCmpInst cast_FCmpInst(Value/*P*/ From) {
    assert isa_FCmpInst(From);
    return (FCmpInst) From;
  }

  public static FCmpInst cast_or_null_FCmpInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FCmpInst(From);
  }

  public static FCmpInst dyn_cast_FCmpInst(Value/*P*/ From) {
    assert From != null;
    return isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static FCmpInst dyn_cast_or_null_FCmpInst(Value/*P*/ From) {
    return (From != null) && isa_FCmpInst(From) ? cast_FCmpInst(From) : null;
  }

  public static boolean isa_FPExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FPExtInst.class, From.$deref());
  }

  public static FPExtInst cast_FPExtInst(type$ref<?>/*P*/ From) {
    assert isa_FPExtInst(From);
    return llvm.cast(FPExtInst.class, From.$deref());
  }

  public static FPExtInst cast_or_null_FPExtInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FPExtInst(From);
  }

  public static FPExtInst dyn_cast_FPExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static FPExtInst dyn_cast_or_null_FPExtInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static boolean isa_FPExtInst(Instruction/*P*/ From) {
    assert From != null;
    return FPExtInst.classof(From);
  }

  public static FPExtInst cast_FPExtInst(Instruction/*P*/ From) {
    assert isa_FPExtInst(From);
    return llvm.cast(FPExtInst.class, From);
  }

  public static FPExtInst cast_or_null_FPExtInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FPExtInst(From);
  }

  public static FPExtInst dyn_cast_FPExtInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static FPExtInst dyn_cast_or_null_FPExtInst(Instruction/*P*/ From) {
    return (From != null) && isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static boolean isa_FPExtInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FPExtInst(From.get());
  }

  public static FPExtInst cast_FPExtInst(Use/*P*/ From) {
    return cast_FPExtInst(From.get());
  }

  public static FPExtInst cast_or_null_FPExtInst(Use/*P*/ From) {
    return cast_or_null_FPExtInst(From.get());
  }

  public static FPExtInst dyn_cast_FPExtInst(Use/*P*/ From) {
    return isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static FPExtInst dyn_cast_or_null_FPExtInst(Use/*P*/ From) {
    return (From != null) && isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static boolean isa_FPExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FPExtInst.class, From.$star());
  }

  public static FPExtInst cast_FPExtInst(type$ptr<?>/*P*/ From) {
    assert isa_FPExtInst(From);
    return llvm.cast(FPExtInst.class, From.$star());
  }

  public static FPExtInst cast_or_null_FPExtInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FPExtInst(From);
  }

  public static FPExtInst dyn_cast_FPExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static FPExtInst dyn_cast_or_null_FPExtInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static boolean isa_FPExtInst(Value/*P*/ From) {
    assert From != null;
    return FPExtInst.classof(From);
  }

  public static FPExtInst cast_FPExtInst(Value/*P*/ From) {
    assert isa_FPExtInst(From);
    return (FPExtInst) From;
  }

  public static FPExtInst cast_or_null_FPExtInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FPExtInst(From);
  }

  public static FPExtInst dyn_cast_FPExtInst(Value/*P*/ From) {
    assert From != null;
    return isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static FPExtInst dyn_cast_or_null_FPExtInst(Value/*P*/ From) {
    return (From != null) && isa_FPExtInst(From) ? cast_FPExtInst(From) : null;
  }

  public static boolean isa_FPMathOperator(Instruction/*P*/ From) {
    assert From != null;
    return FPMathOperator.classof(From);
  }

  public static FPMathOperator cast_FPMathOperator(Instruction/*P*/ From) {
    assert isa_FPMathOperator(From);
    return llvm.cast(FPMathOperator.class, From);
  }

  public static FPMathOperator cast_or_null_FPMathOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FPMathOperator(From);
  }

  public static FPMathOperator dyn_cast_FPMathOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(Instruction/*P*/ From) {
    return (From != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPMathOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FPMathOperator.class, From.$deref());
  }

  public static FPMathOperator cast_FPMathOperator(type$ref<?>/*P*/ From) {
    assert isa_FPMathOperator(From);
    return llvm.cast(FPMathOperator.class, From.$deref());
  }

  public static FPMathOperator cast_or_null_FPMathOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FPMathOperator(From);
  }

  public static FPMathOperator dyn_cast_FPMathOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPMathOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FPMathOperator(From.get());
  }

  public static FPMathOperator cast_FPMathOperator(Use/*P*/ From) {
    return cast_FPMathOperator(From.get());
  }

  public static FPMathOperator cast_or_null_FPMathOperator(Use/*P*/ From) {
    return cast_or_null_FPMathOperator(From.get());
  }

  public static FPMathOperator dyn_cast_FPMathOperator(Use/*P*/ From) {
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(Use/*P*/ From) {
    return (From != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPMathOperator(Value/*P*/ From) {
    assert From != null;
    return FPMathOperator.classof(From);
  }

  public static FPMathOperator cast_FPMathOperator(Value/*P*/ From) {
    assert isa_FPMathOperator(From);
    return (FPMathOperator) From;
  }

  public static FPMathOperator cast_or_null_FPMathOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_FPMathOperator(From);
  }

  public static FPMathOperator dyn_cast_FPMathOperator(Value/*P*/ From) {
    assert From != null;
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(Value/*P*/ From) {
    return (From != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPMathOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return FPMathOperator.classof(From);
  }

  public static FPMathOperator cast_FPMathOperator(ConstantExpr/*P*/ From) {
    assert isa_FPMathOperator(From);
    return llvm.cast(FPMathOperator.class, From);
  }

  public static FPMathOperator cast_or_null_FPMathOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_FPMathOperator(From);
  }

  public static FPMathOperator dyn_cast_FPMathOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPMathOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FPMathOperator.class, From.$star());
  }

  public static FPMathOperator cast_FPMathOperator(type$ptr<?>/*P*/ From) {
    assert isa_FPMathOperator(From);
    return llvm.cast(FPMathOperator.class, From.$star());
  }

  public static FPMathOperator cast_or_null_FPMathOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FPMathOperator(From);
  }

  public static FPMathOperator dyn_cast_FPMathOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static FPMathOperator dyn_cast_or_null_FPMathOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FPMathOperator(From) ? cast_FPMathOperator(From) : null;
  }

  public static boolean isa_FPToSIInst(Value/*P*/ From) {
    assert From != null;
    return FPToSIInst.classof(From);
  }

  public static FPToSIInst cast_FPToSIInst(Value/*P*/ From) {
    assert isa_FPToSIInst(From);
    return (FPToSIInst) From;
  }

  public static FPToSIInst cast_or_null_FPToSIInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FPToSIInst(From);
  }

  public static FPToSIInst dyn_cast_FPToSIInst(Value/*P*/ From) {
    assert From != null;
    return isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static FPToSIInst dyn_cast_or_null_FPToSIInst(Value/*P*/ From) {
    return (From != null) && isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static boolean isa_FPToSIInst(Instruction/*P*/ From) {
    assert From != null;
    return FPToSIInst.classof(From);
  }

  public static FPToSIInst cast_FPToSIInst(Instruction/*P*/ From) {
    assert isa_FPToSIInst(From);
    return llvm.cast(FPToSIInst.class, From);
  }

  public static FPToSIInst cast_or_null_FPToSIInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FPToSIInst(From);
  }

  public static FPToSIInst dyn_cast_FPToSIInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static FPToSIInst dyn_cast_or_null_FPToSIInst(Instruction/*P*/ From) {
    return (From != null) && isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static boolean isa_FPToSIInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FPToSIInst.class, From.$star());
  }

  public static FPToSIInst cast_FPToSIInst(type$ptr<?>/*P*/ From) {
    assert isa_FPToSIInst(From);
    return llvm.cast(FPToSIInst.class, From.$star());
  }

  public static FPToSIInst cast_or_null_FPToSIInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FPToSIInst(From);
  }

  public static FPToSIInst dyn_cast_FPToSIInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static FPToSIInst dyn_cast_or_null_FPToSIInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static boolean isa_FPToSIInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FPToSIInst(From.get());
  }

  public static FPToSIInst cast_FPToSIInst(Use/*P*/ From) {
    return cast_FPToSIInst(From.get());
  }

  public static FPToSIInst cast_or_null_FPToSIInst(Use/*P*/ From) {
    return cast_or_null_FPToSIInst(From.get());
  }

  public static FPToSIInst dyn_cast_FPToSIInst(Use/*P*/ From) {
    return isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static FPToSIInst dyn_cast_or_null_FPToSIInst(Use/*P*/ From) {
    return (From != null) && isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static boolean isa_FPToSIInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FPToSIInst.class, From.$deref());
  }

  public static FPToSIInst cast_FPToSIInst(type$ref<?>/*P*/ From) {
    assert isa_FPToSIInst(From);
    return llvm.cast(FPToSIInst.class, From.$deref());
  }

  public static FPToSIInst cast_or_null_FPToSIInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FPToSIInst(From);
  }

  public static FPToSIInst dyn_cast_FPToSIInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static FPToSIInst dyn_cast_or_null_FPToSIInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FPToSIInst(From) ? cast_FPToSIInst(From) : null;
  }

  public static boolean isa_FPToUIInst(Instruction/*P*/ From) {
    assert From != null;
    return FPToUIInst.classof(From);
  }

  public static FPToUIInst cast_FPToUIInst(Instruction/*P*/ From) {
    assert isa_FPToUIInst(From);
    return llvm.cast(FPToUIInst.class, From);
  }

  public static FPToUIInst cast_or_null_FPToUIInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FPToUIInst(From);
  }

  public static FPToUIInst dyn_cast_FPToUIInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static FPToUIInst dyn_cast_or_null_FPToUIInst(Instruction/*P*/ From) {
    return (From != null) && isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static boolean isa_FPToUIInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FPToUIInst.class, From.$star());
  }

  public static FPToUIInst cast_FPToUIInst(type$ptr<?>/*P*/ From) {
    assert isa_FPToUIInst(From);
    return llvm.cast(FPToUIInst.class, From.$star());
  }

  public static FPToUIInst cast_or_null_FPToUIInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FPToUIInst(From);
  }

  public static FPToUIInst dyn_cast_FPToUIInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static FPToUIInst dyn_cast_or_null_FPToUIInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static boolean isa_FPToUIInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FPToUIInst(From.get());
  }

  public static FPToUIInst cast_FPToUIInst(Use/*P*/ From) {
    return cast_FPToUIInst(From.get());
  }

  public static FPToUIInst cast_or_null_FPToUIInst(Use/*P*/ From) {
    return cast_or_null_FPToUIInst(From.get());
  }

  public static FPToUIInst dyn_cast_FPToUIInst(Use/*P*/ From) {
    return isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static FPToUIInst dyn_cast_or_null_FPToUIInst(Use/*P*/ From) {
    return (From != null) && isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static boolean isa_FPToUIInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FPToUIInst.class, From.$deref());
  }

  public static FPToUIInst cast_FPToUIInst(type$ref<?>/*P*/ From) {
    assert isa_FPToUIInst(From);
    return llvm.cast(FPToUIInst.class, From.$deref());
  }

  public static FPToUIInst cast_or_null_FPToUIInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FPToUIInst(From);
  }

  public static FPToUIInst dyn_cast_FPToUIInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static FPToUIInst dyn_cast_or_null_FPToUIInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static boolean isa_FPToUIInst(Value/*P*/ From) {
    assert From != null;
    return FPToUIInst.classof(From);
  }

  public static FPToUIInst cast_FPToUIInst(Value/*P*/ From) {
    assert isa_FPToUIInst(From);
    return (FPToUIInst) From;
  }

  public static FPToUIInst cast_or_null_FPToUIInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FPToUIInst(From);
  }

  public static FPToUIInst dyn_cast_FPToUIInst(Value/*P*/ From) {
    assert From != null;
    return isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static FPToUIInst dyn_cast_or_null_FPToUIInst(Value/*P*/ From) {
    return (From != null) && isa_FPToUIInst(From) ? cast_FPToUIInst(From) : null;
  }

  public static boolean isa_FPTruncInst(Instruction/*P*/ From) {
    assert From != null;
    return FPTruncInst.classof(From);
  }

  public static FPTruncInst cast_FPTruncInst(Instruction/*P*/ From) {
    assert isa_FPTruncInst(From);
    return llvm.cast(FPTruncInst.class, From);
  }

  public static FPTruncInst cast_or_null_FPTruncInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FPTruncInst(From);
  }

  public static FPTruncInst dyn_cast_FPTruncInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static FPTruncInst dyn_cast_or_null_FPTruncInst(Instruction/*P*/ From) {
    return (From != null) && isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static boolean isa_FPTruncInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FPTruncInst.class, From.$deref());
  }

  public static FPTruncInst cast_FPTruncInst(type$ref<?>/*P*/ From) {
    assert isa_FPTruncInst(From);
    return llvm.cast(FPTruncInst.class, From.$deref());
  }

  public static FPTruncInst cast_or_null_FPTruncInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FPTruncInst(From);
  }

  public static FPTruncInst dyn_cast_FPTruncInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static FPTruncInst dyn_cast_or_null_FPTruncInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static boolean isa_FPTruncInst(Value/*P*/ From) {
    assert From != null;
    return FPTruncInst.classof(From);
  }

  public static FPTruncInst cast_FPTruncInst(Value/*P*/ From) {
    assert isa_FPTruncInst(From);
    return (FPTruncInst) From;
  }

  public static FPTruncInst cast_or_null_FPTruncInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FPTruncInst(From);
  }

  public static FPTruncInst dyn_cast_FPTruncInst(Value/*P*/ From) {
    assert From != null;
    return isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static FPTruncInst dyn_cast_or_null_FPTruncInst(Value/*P*/ From) {
    return (From != null) && isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static boolean isa_FPTruncInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FPTruncInst.class, From.$star());
  }

  public static FPTruncInst cast_FPTruncInst(type$ptr<?>/*P*/ From) {
    assert isa_FPTruncInst(From);
    return llvm.cast(FPTruncInst.class, From.$star());
  }

  public static FPTruncInst cast_or_null_FPTruncInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FPTruncInst(From);
  }

  public static FPTruncInst dyn_cast_FPTruncInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static FPTruncInst dyn_cast_or_null_FPTruncInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static boolean isa_FPTruncInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FPTruncInst(From.get());
  }

  public static FPTruncInst cast_FPTruncInst(Use/*P*/ From) {
    return cast_FPTruncInst(From.get());
  }

  public static FPTruncInst cast_or_null_FPTruncInst(Use/*P*/ From) {
    return cast_or_null_FPTruncInst(From.get());
  }

  public static FPTruncInst dyn_cast_FPTruncInst(Use/*P*/ From) {
    return isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static FPTruncInst dyn_cast_or_null_FPTruncInst(Use/*P*/ From) {
    return (From != null) && isa_FPTruncInst(From) ? cast_FPTruncInst(From) : null;
  }

  public static boolean isa_FenceInst(Instruction/*P*/ From) {
    assert From != null;
    return FenceInst.classof(From);
  }

  public static FenceInst cast_FenceInst(Instruction/*P*/ From) {
    assert isa_FenceInst(From);
    return llvm.cast(FenceInst.class, From);
  }

  public static FenceInst cast_or_null_FenceInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FenceInst(From);
  }

  public static FenceInst dyn_cast_FenceInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static FenceInst dyn_cast_or_null_FenceInst(Instruction/*P*/ From) {
    return (From != null) && isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static boolean isa_FenceInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FenceInst.class, From.$star());
  }

  public static FenceInst cast_FenceInst(type$ptr<?>/*P*/ From) {
    assert isa_FenceInst(From);
    return llvm.cast(FenceInst.class, From.$star());
  }

  public static FenceInst cast_or_null_FenceInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FenceInst(From);
  }

  public static FenceInst dyn_cast_FenceInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static FenceInst dyn_cast_or_null_FenceInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static boolean isa_FenceInst(Value/*P*/ From) {
    assert From != null;
    return FenceInst.classof(From);
  }

  public static FenceInst cast_FenceInst(Value/*P*/ From) {
    assert isa_FenceInst(From);
    return (FenceInst) From;
  }

  public static FenceInst cast_or_null_FenceInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FenceInst(From);
  }

  public static FenceInst dyn_cast_FenceInst(Value/*P*/ From) {
    assert From != null;
    return isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static FenceInst dyn_cast_or_null_FenceInst(Value/*P*/ From) {
    return (From != null) && isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static boolean isa_FenceInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FenceInst(From.get());
  }

  public static FenceInst cast_FenceInst(Use/*P*/ From) {
    return cast_FenceInst(From.get());
  }

  public static FenceInst cast_or_null_FenceInst(Use/*P*/ From) {
    return cast_or_null_FenceInst(From.get());
  }

  public static FenceInst dyn_cast_FenceInst(Use/*P*/ From) {
    return isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static FenceInst dyn_cast_or_null_FenceInst(Use/*P*/ From) {
    return (From != null) && isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static boolean isa_FenceInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FenceInst.class, From.$deref());
  }

  public static FenceInst cast_FenceInst(type$ref<?>/*P*/ From) {
    assert isa_FenceInst(From);
    return llvm.cast(FenceInst.class, From.$deref());
  }

  public static FenceInst cast_or_null_FenceInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FenceInst(From);
  }

  public static FenceInst dyn_cast_FenceInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static FenceInst dyn_cast_or_null_FenceInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FenceInst(From) ? cast_FenceInst(From) : null;
  }

  public static boolean isa_FuncletPadInst(Value/*P*/ From) {
    assert From != null;
    return FuncletPadInst.classof(From);
  }

  public static FuncletPadInst cast_FuncletPadInst(Value/*P*/ From) {
    assert isa_FuncletPadInst(From);
    return (FuncletPadInst) From;
  }

  public static FuncletPadInst cast_or_null_FuncletPadInst(Value/*P*/ From) {
    return (From == null) ? null : cast_FuncletPadInst(From);
  }

  public static FuncletPadInst dyn_cast_FuncletPadInst(Value/*P*/ From) {
    assert From != null;
    return isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static FuncletPadInst dyn_cast_or_null_FuncletPadInst(Value/*P*/ From) {
    return (From != null) && isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static boolean isa_FuncletPadInst(Instruction/*P*/ From) {
    assert From != null;
    return FuncletPadInst.classof(From);
  }

  public static FuncletPadInst cast_FuncletPadInst(Instruction/*P*/ From) {
    assert isa_FuncletPadInst(From);
    return llvm.cast(FuncletPadInst.class, From);
  }

  public static FuncletPadInst cast_or_null_FuncletPadInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_FuncletPadInst(From);
  }

  public static FuncletPadInst dyn_cast_FuncletPadInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static FuncletPadInst dyn_cast_or_null_FuncletPadInst(Instruction/*P*/ From) {
    return (From != null) && isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static boolean isa_FuncletPadInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_FuncletPadInst(From.get());
  }

  public static FuncletPadInst cast_FuncletPadInst(Use/*P*/ From) {
    return cast_FuncletPadInst(From.get());
  }

  public static FuncletPadInst cast_or_null_FuncletPadInst(Use/*P*/ From) {
    return cast_or_null_FuncletPadInst(From.get());
  }

  public static FuncletPadInst dyn_cast_FuncletPadInst(Use/*P*/ From) {
    return isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static FuncletPadInst dyn_cast_or_null_FuncletPadInst(Use/*P*/ From) {
    return (From != null) && isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static boolean isa_FuncletPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FuncletPadInst.class, From.$deref());
  }

  public static FuncletPadInst cast_FuncletPadInst(type$ref<?>/*P*/ From) {
    assert isa_FuncletPadInst(From);
    return llvm.cast(FuncletPadInst.class, From.$deref());
  }

  public static FuncletPadInst cast_or_null_FuncletPadInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FuncletPadInst(From);
  }

  public static FuncletPadInst dyn_cast_FuncletPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static FuncletPadInst dyn_cast_or_null_FuncletPadInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static boolean isa_FuncletPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FuncletPadInst.class, From.$star());
  }

  public static FuncletPadInst cast_FuncletPadInst(type$ptr<?>/*P*/ From) {
    assert isa_FuncletPadInst(From);
    return llvm.cast(FuncletPadInst.class, From.$star());
  }

  public static FuncletPadInst cast_or_null_FuncletPadInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FuncletPadInst(From);
  }

  public static FuncletPadInst dyn_cast_FuncletPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
  }

  public static FuncletPadInst dyn_cast_or_null_FuncletPadInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FuncletPadInst(From) ? cast_FuncletPadInst(From) : null;
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

  public static boolean isa_Function(Value/*P*/ From) {
    assert From != null;
    return Function.classof(From);
  }

  public static Function cast_Function(Value/*P*/ From) {
    assert isa_Function(From);
    return (Function) From;
  }

  public static Function cast_or_null_Function(Value/*P*/ From) {
    return (From == null) ? null : cast_Function(From);
  }

  public static Function dyn_cast_Function(Value/*P*/ From) {
    assert From != null;
    return isa_Function(From) ? cast_Function(From) : null;
  }

  public static Function dyn_cast_or_null_Function(Value/*P*/ From) {
    return (From != null) && isa_Function(From) ? cast_Function(From) : null;
  }

  public static boolean isa_Function(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Function(From.get());
  }

  public static Function cast_Function(Use/*P*/ From) {
    return cast_Function(From.get());
  }

  public static Function cast_or_null_Function(Use/*P*/ From) {
    return cast_or_null_Function(From.get());
  }

  public static Function dyn_cast_Function(Use/*P*/ From) {
    return isa_Function(From) ? cast_Function(From) : null;
  }

  public static Function dyn_cast_or_null_Function(Use/*P*/ From) {
    return (From != null) && isa_Function(From) ? cast_Function(From) : null;
  }

  public static boolean isa_FunctionSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return FunctionSummary.classof(From);
  }

  public static FunctionSummary cast_FunctionSummary(GlobalValueSummary/*P*/ From) {
    assert isa_FunctionSummary(From);
    return (FunctionSummary) From;
  }

  public static FunctionSummary cast_or_null_FunctionSummary(GlobalValueSummary/*P*/ From) {
    return (From == null) ? null : cast_FunctionSummary(From);
  }

  public static FunctionSummary dyn_cast_FunctionSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static FunctionSummary dyn_cast_or_null_FunctionSummary(GlobalValueSummary/*P*/ From) {
    return (From != null) && isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static boolean isa_FunctionSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionSummary.class, From.$star());
  }

  public static FunctionSummary cast_FunctionSummary(type$ptr<?>/*P*/ From) {
    assert isa_FunctionSummary(From);
    return llvm.cast(FunctionSummary.class, From.$star());
  }

  public static FunctionSummary cast_or_null_FunctionSummary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionSummary(From);
  }

  public static FunctionSummary dyn_cast_FunctionSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static FunctionSummary dyn_cast_or_null_FunctionSummary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static boolean isa_FunctionSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionSummary.class, From.$deref());
  }

  public static FunctionSummary cast_FunctionSummary(type$ref<?>/*P*/ From) {
    assert isa_FunctionSummary(From);
    return llvm.cast(FunctionSummary.class, From.$deref());
  }

  public static FunctionSummary cast_or_null_FunctionSummary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionSummary(From);
  }

  public static FunctionSummary dyn_cast_FunctionSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static FunctionSummary dyn_cast_or_null_FunctionSummary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionSummary(From) ? cast_FunctionSummary(From) : null;
  }

  public static boolean isa_FunctionType(Type/*P*/ From) {
    assert From != null;
    return FunctionType.classof(From);
  }

  public static FunctionType cast_FunctionType(Type/*P*/ From) {
    assert isa_FunctionType(From);
    return (FunctionType) From;
  }

  public static FunctionType cast_or_null_FunctionType(Type/*P*/ From) {
    return (From == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(Type/*P*/ From) {
    assert From != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(Type/*P*/ From) {
    return (From != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FunctionType.class, From.$deref());
  }

  public static FunctionType cast_FunctionType(type$ref<?>/*P*/ From) {
    assert isa_FunctionType(From);
    return llvm.cast(FunctionType.class, From.$deref());
  }

  public static FunctionType cast_or_null_FunctionType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_FunctionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FunctionType.class, From.$star());
  }

  public static FunctionType cast_FunctionType(type$ptr<?>/*P*/ From) {
    assert isa_FunctionType(From);
    return llvm.cast(FunctionType.class, From.$star());
  }

  public static FunctionType cast_or_null_FunctionType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FunctionType(From);
  }

  public static FunctionType dyn_cast_FunctionType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static FunctionType dyn_cast_or_null_FunctionType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FunctionType(From) ? cast_FunctionType(From) : null;
  }

  public static boolean isa_GCProjectionInst(Value/*P*/ From) {
    assert From != null;
    return GCProjectionInst.classof(From);
  }

  public static GCProjectionInst cast_GCProjectionInst(Value/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return (GCProjectionInst) From;
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(Value/*P*/ From) {
    return (From == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(Value/*P*/ From) {
    assert From != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(Value/*P*/ From) {
    return (From != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(Instruction/*P*/ From) {
    assert From != null;
    return GCProjectionInst.classof(From);
  }

  public static GCProjectionInst cast_GCProjectionInst(Instruction/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return llvm.cast(GCProjectionInst.class, From);
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(Instruction/*P*/ From) {
    return (From != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(CallInst/*P*/ From) {
    assert From != null;
    return GCProjectionInst.classof(From);
  }

  public static GCProjectionInst cast_GCProjectionInst(CallInst/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return (GCProjectionInst) From;
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(CallInst/*P*/ From) {
    return (From != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return GCProjectionInst.classof(From);
  }

  public static GCProjectionInst cast_GCProjectionInst(IntrinsicInst/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return (GCProjectionInst) From;
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GCProjectionInst.class, From.$star());
  }

  public static GCProjectionInst cast_GCProjectionInst(type$ptr<?>/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return llvm.cast(GCProjectionInst.class, From.$star());
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GCProjectionInst.class, From.$deref());
  }

  public static GCProjectionInst cast_GCProjectionInst(type$ref<?>/*P*/ From) {
    assert isa_GCProjectionInst(From);
    return llvm.cast(GCProjectionInst.class, From.$deref());
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GCProjectionInst(From);
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCProjectionInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GCProjectionInst(From.get());
  }

  public static GCProjectionInst cast_GCProjectionInst(Use/*P*/ From) {
    return cast_GCProjectionInst(From.get());
  }

  public static GCProjectionInst cast_or_null_GCProjectionInst(Use/*P*/ From) {
    return cast_or_null_GCProjectionInst(From.get());
  }

  public static GCProjectionInst dyn_cast_GCProjectionInst(Use/*P*/ From) {
    return isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static GCProjectionInst dyn_cast_or_null_GCProjectionInst(Use/*P*/ From) {
    return (From != null) && isa_GCProjectionInst(From) ? cast_GCProjectionInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(Instruction/*P*/ From) {
    assert From != null;
    return GCRelocateInst.classof(From);
  }

  public static GCRelocateInst cast_GCRelocateInst(Instruction/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return llvm.cast(GCRelocateInst.class, From);
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(Instruction/*P*/ From) {
    return (From != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(CallInst/*P*/ From) {
    assert From != null;
    return GCRelocateInst.classof(From);
  }

  public static GCRelocateInst cast_GCRelocateInst(CallInst/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return (GCRelocateInst) From;
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(CallInst/*P*/ From) {
    return (From != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return GCRelocateInst.classof(From);
  }

  public static GCRelocateInst cast_GCRelocateInst(IntrinsicInst/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return (GCRelocateInst) From;
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GCRelocateInst.class, From.$star());
  }

  public static GCRelocateInst cast_GCRelocateInst(type$ptr<?>/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return llvm.cast(GCRelocateInst.class, From.$star());
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(Value/*P*/ From) {
    assert From != null;
    return GCRelocateInst.classof(From);
  }

  public static GCRelocateInst cast_GCRelocateInst(Value/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return (GCRelocateInst) From;
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(Value/*P*/ From) {
    return (From == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(Value/*P*/ From) {
    assert From != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(Value/*P*/ From) {
    return (From != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GCRelocateInst(From.get());
  }

  public static GCRelocateInst cast_GCRelocateInst(Use/*P*/ From) {
    return cast_GCRelocateInst(From.get());
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(Use/*P*/ From) {
    return cast_or_null_GCRelocateInst(From.get());
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(Use/*P*/ From) {
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(Use/*P*/ From) {
    return (From != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCRelocateInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GCRelocateInst.class, From.$deref());
  }

  public static GCRelocateInst cast_GCRelocateInst(type$ref<?>/*P*/ From) {
    assert isa_GCRelocateInst(From);
    return llvm.cast(GCRelocateInst.class, From.$deref());
  }

  public static GCRelocateInst cast_or_null_GCRelocateInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GCRelocateInst(From);
  }

  public static GCRelocateInst dyn_cast_GCRelocateInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static GCRelocateInst dyn_cast_or_null_GCRelocateInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GCRelocateInst(From) ? cast_GCRelocateInst(From) : null;
  }

  public static boolean isa_GCResultInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GCResultInst.class, From.$deref());
  }

  public static GCResultInst cast_GCResultInst(type$ref<?>/*P*/ From) {
    assert isa_GCResultInst(From);
    return llvm.cast(GCResultInst.class, From.$deref());
  }

  public static GCResultInst cast_or_null_GCResultInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GCResultInst.class, From.$star());
  }

  public static GCResultInst cast_GCResultInst(type$ptr<?>/*P*/ From) {
    assert isa_GCResultInst(From);
    return llvm.cast(GCResultInst.class, From.$star());
  }

  public static GCResultInst cast_or_null_GCResultInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(Value/*P*/ From) {
    assert From != null;
    return GCResultInst.classof(From);
  }

  public static GCResultInst cast_GCResultInst(Value/*P*/ From) {
    assert isa_GCResultInst(From);
    return (GCResultInst) From;
  }

  public static GCResultInst cast_or_null_GCResultInst(Value/*P*/ From) {
    return (From == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(Value/*P*/ From) {
    assert From != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(Value/*P*/ From) {
    return (From != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GCResultInst(From.get());
  }

  public static GCResultInst cast_GCResultInst(Use/*P*/ From) {
    return cast_GCResultInst(From.get());
  }

  public static GCResultInst cast_or_null_GCResultInst(Use/*P*/ From) {
    return cast_or_null_GCResultInst(From.get());
  }

  public static GCResultInst dyn_cast_GCResultInst(Use/*P*/ From) {
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(Use/*P*/ From) {
    return (From != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(CallInst/*P*/ From) {
    assert From != null;
    return GCResultInst.classof(From);
  }

  public static GCResultInst cast_GCResultInst(CallInst/*P*/ From) {
    assert isa_GCResultInst(From);
    return (GCResultInst) From;
  }

  public static GCResultInst cast_or_null_GCResultInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(CallInst/*P*/ From) {
    return (From != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(Instruction/*P*/ From) {
    assert From != null;
    return GCResultInst.classof(From);
  }

  public static GCResultInst cast_GCResultInst(Instruction/*P*/ From) {
    assert isa_GCResultInst(From);
    return llvm.cast(GCResultInst.class, From);
  }

  public static GCResultInst cast_or_null_GCResultInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(Instruction/*P*/ From) {
    return (From != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GCResultInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return GCResultInst.classof(From);
  }

  public static GCResultInst cast_GCResultInst(IntrinsicInst/*P*/ From) {
    assert isa_GCResultInst(From);
    return (GCResultInst) From;
  }

  public static GCResultInst cast_or_null_GCResultInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_GCResultInst(From);
  }

  public static GCResultInst dyn_cast_GCResultInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static GCResultInst dyn_cast_or_null_GCResultInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_GCResultInst(From) ? cast_GCResultInst(From) : null;
  }

  public static boolean isa_GEPOperator(Instruction/*P*/ From) {
    assert From != null;
    return GEPOperator.classof(From);
  }

  public static GEPOperator cast_GEPOperator(Instruction/*P*/ From) {
    assert isa_GEPOperator(From);
    return llvm.cast(GEPOperator.class, From);
  }

  public static GEPOperator cast_or_null_GEPOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_GEPOperator(From);
  }

  public static GEPOperator dyn_cast_GEPOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(Instruction/*P*/ From) {
    return (From != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GEPOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GEPOperator.class, From.$star());
  }

  public static GEPOperator cast_GEPOperator(type$ptr<?>/*P*/ From) {
    assert isa_GEPOperator(From);
    return llvm.cast(GEPOperator.class, From.$star());
  }

  public static GEPOperator cast_or_null_GEPOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GEPOperator(From);
  }

  public static GEPOperator dyn_cast_GEPOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GEPOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GEPOperator(From.get());
  }

  public static GEPOperator cast_GEPOperator(Use/*P*/ From) {
    return cast_GEPOperator(From.get());
  }

  public static GEPOperator cast_or_null_GEPOperator(Use/*P*/ From) {
    return cast_or_null_GEPOperator(From.get());
  }

  public static GEPOperator dyn_cast_GEPOperator(Use/*P*/ From) {
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(Use/*P*/ From) {
    return (From != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GEPOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return GEPOperator.classof(From);
  }

  public static GEPOperator cast_GEPOperator(ConstantExpr/*P*/ From) {
    assert isa_GEPOperator(From);
    return llvm.cast(GEPOperator.class, From);
  }

  public static GEPOperator cast_or_null_GEPOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_GEPOperator(From);
  }

  public static GEPOperator dyn_cast_GEPOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GEPOperator(Value/*P*/ From) {
    assert From != null;
    return GEPOperator.classof(From);
  }

  public static GEPOperator cast_GEPOperator(Value/*P*/ From) {
    assert isa_GEPOperator(From);
    return llvm.cast(GEPOperator.class, From);
  }

  public static GEPOperator cast_or_null_GEPOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_GEPOperator(From);
  }

  public static GEPOperator dyn_cast_GEPOperator(Value/*P*/ From) {
    assert From != null;
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(Value/*P*/ From) {
    return (From != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GEPOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GEPOperator.class, From.$deref());
  }

  public static GEPOperator cast_GEPOperator(type$ref<?>/*P*/ From) {
    assert isa_GEPOperator(From);
    return llvm.cast(GEPOperator.class, From.$deref());
  }

  public static GEPOperator cast_or_null_GEPOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GEPOperator(From);
  }

  public static GEPOperator dyn_cast_GEPOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static GEPOperator dyn_cast_or_null_GEPOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GEPOperator(From) ? cast_GEPOperator(From) : null;
  }

  public static boolean isa_GenericDINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GenericDINode.class, From.$star());
  }

  public static GenericDINode cast_GenericDINode(type$ptr<?>/*P*/ From) {
    assert isa_GenericDINode(From);
    return llvm.cast(GenericDINode.class, From.$star());
  }

  public static GenericDINode cast_or_null_GenericDINode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GenericDINode(From);
  }

  public static GenericDINode dyn_cast_GenericDINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static GenericDINode dyn_cast_or_null_GenericDINode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static boolean isa_GenericDINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GenericDINode.class, From.$deref());
  }

  public static GenericDINode cast_GenericDINode(type$ref<?>/*P*/ From) {
    assert isa_GenericDINode(From);
    return llvm.cast(GenericDINode.class, From.$deref());
  }

  public static GenericDINode cast_or_null_GenericDINode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GenericDINode(From);
  }

  public static GenericDINode dyn_cast_GenericDINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static GenericDINode dyn_cast_or_null_GenericDINode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static boolean isa_GenericDINode(Metadata/*P*/ From) {
    assert From != null;
    return GenericDINode.classof(From);
  }

  public static GenericDINode cast_GenericDINode(Metadata/*P*/ From) {
    assert isa_GenericDINode(From);
    return (GenericDINode) From;
  }

  public static GenericDINode cast_or_null_GenericDINode(Metadata/*P*/ From) {
    return (From == null) ? null : cast_GenericDINode(From);
  }

  public static GenericDINode dyn_cast_GenericDINode(Metadata/*P*/ From) {
    assert From != null;
    return isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static GenericDINode dyn_cast_or_null_GenericDINode(Metadata/*P*/ From) {
    return (From != null) && isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static boolean isa_GenericDINode(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GenericDINode(From.get());
  }

  public static GenericDINode cast_GenericDINode(MDOperand/*P*/ From) {
    return cast_GenericDINode(From.get());
  }

  public static GenericDINode cast_or_null_GenericDINode(MDOperand/*P*/ From) {
    return cast_or_null_GenericDINode(From.get());
  }

  public static GenericDINode dyn_cast_GenericDINode(MDOperand/*P*/ From) {
    return isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static GenericDINode dyn_cast_or_null_GenericDINode(MDOperand/*P*/ From) {
    return (From != null) && isa_GenericDINode(From) ? cast_GenericDINode(From) : null;
  }

  public static boolean isa_GetElementPtrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GetElementPtrInst.class, From.$star());
  }

  public static GetElementPtrInst cast_GetElementPtrInst(type$ptr<?>/*P*/ From) {
    assert isa_GetElementPtrInst(From);
    return llvm.cast(GetElementPtrInst.class, From.$star());
  }

  public static GetElementPtrInst cast_or_null_GetElementPtrInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GetElementPtrInst(From);
  }

  public static GetElementPtrInst dyn_cast_GetElementPtrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static GetElementPtrInst dyn_cast_or_null_GetElementPtrInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static boolean isa_GetElementPtrInst(Value/*P*/ From) {
    assert From != null;
    return GetElementPtrInst.classof(From);
  }

  public static GetElementPtrInst cast_GetElementPtrInst(Value/*P*/ From) {
    assert isa_GetElementPtrInst(From);
    return (GetElementPtrInst) From;
  }

  public static GetElementPtrInst cast_or_null_GetElementPtrInst(Value/*P*/ From) {
    return (From == null) ? null : cast_GetElementPtrInst(From);
  }

  public static GetElementPtrInst dyn_cast_GetElementPtrInst(Value/*P*/ From) {
    assert From != null;
    return isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static GetElementPtrInst dyn_cast_or_null_GetElementPtrInst(Value/*P*/ From) {
    return (From != null) && isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static boolean isa_GetElementPtrInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GetElementPtrInst(From.get());
  }

  public static GetElementPtrInst cast_GetElementPtrInst(Use/*P*/ From) {
    return cast_GetElementPtrInst(From.get());
  }

  public static GetElementPtrInst cast_or_null_GetElementPtrInst(Use/*P*/ From) {
    return cast_or_null_GetElementPtrInst(From.get());
  }

  public static GetElementPtrInst dyn_cast_GetElementPtrInst(Use/*P*/ From) {
    return isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static GetElementPtrInst dyn_cast_or_null_GetElementPtrInst(Use/*P*/ From) {
    return (From != null) && isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static boolean isa_GetElementPtrInst(Instruction/*P*/ From) {
    assert From != null;
    return GetElementPtrInst.classof(From);
  }

  public static GetElementPtrInst cast_GetElementPtrInst(Instruction/*P*/ From) {
    assert isa_GetElementPtrInst(From);
    return llvm.cast(GetElementPtrInst.class, From);
  }

  public static GetElementPtrInst cast_or_null_GetElementPtrInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_GetElementPtrInst(From);
  }

  public static GetElementPtrInst dyn_cast_GetElementPtrInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static GetElementPtrInst dyn_cast_or_null_GetElementPtrInst(Instruction/*P*/ From) {
    return (From != null) && isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static boolean isa_GetElementPtrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GetElementPtrInst.class, From.$deref());
  }

  public static GetElementPtrInst cast_GetElementPtrInst(type$ref<?>/*P*/ From) {
    assert isa_GetElementPtrInst(From);
    return llvm.cast(GetElementPtrInst.class, From.$deref());
  }

  public static GetElementPtrInst cast_or_null_GetElementPtrInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GetElementPtrInst(From);
  }

  public static GetElementPtrInst dyn_cast_GetElementPtrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static GetElementPtrInst dyn_cast_or_null_GetElementPtrInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GetElementPtrInst(From) ? cast_GetElementPtrInst(From) : null;
  }

  public static boolean isa_GlobalAlias(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalAlias.class, From.$deref());
  }

  public static GlobalAlias cast_GlobalAlias(type$ref<?>/*P*/ From) {
    assert isa_GlobalAlias(From);
    return llvm.cast(GlobalAlias.class, From.$deref());
  }

  public static GlobalAlias cast_or_null_GlobalAlias(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalAlias(From);
  }

  public static GlobalAlias dyn_cast_GlobalAlias(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static GlobalAlias dyn_cast_or_null_GlobalAlias(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static boolean isa_GlobalAlias(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalAlias(From.get());
  }

  public static GlobalAlias cast_GlobalAlias(Use/*P*/ From) {
    return cast_GlobalAlias(From.get());
  }

  public static GlobalAlias cast_or_null_GlobalAlias(Use/*P*/ From) {
    return cast_or_null_GlobalAlias(From.get());
  }

  public static GlobalAlias dyn_cast_GlobalAlias(Use/*P*/ From) {
    return isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static GlobalAlias dyn_cast_or_null_GlobalAlias(Use/*P*/ From) {
    return (From != null) && isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static boolean isa_GlobalAlias(Value/*P*/ From) {
    assert From != null;
    return GlobalAlias.classof(From);
  }

  public static GlobalAlias cast_GlobalAlias(Value/*P*/ From) {
    assert isa_GlobalAlias(From);
    return (GlobalAlias) From;
  }

  public static GlobalAlias cast_or_null_GlobalAlias(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalAlias(From);
  }

  public static GlobalAlias dyn_cast_GlobalAlias(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static GlobalAlias dyn_cast_or_null_GlobalAlias(Value/*P*/ From) {
    return (From != null) && isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static boolean isa_GlobalAlias(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalAlias.class, From.$star());
  }

  public static GlobalAlias cast_GlobalAlias(type$ptr<?>/*P*/ From) {
    assert isa_GlobalAlias(From);
    return llvm.cast(GlobalAlias.class, From.$star());
  }

  public static GlobalAlias cast_or_null_GlobalAlias(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalAlias(From);
  }

  public static GlobalAlias dyn_cast_GlobalAlias(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static GlobalAlias dyn_cast_or_null_GlobalAlias(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalAlias(From) ? cast_GlobalAlias(From) : null;
  }

  public static boolean isa_GlobalIFunc(Value/*P*/ From) {
    assert From != null;
    return GlobalIFunc.classof(From);
  }

  public static GlobalIFunc cast_GlobalIFunc(Value/*P*/ From) {
    assert isa_GlobalIFunc(From);
    return (GlobalIFunc) From;
  }

  public static GlobalIFunc cast_or_null_GlobalIFunc(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalIFunc(From);
  }

  public static GlobalIFunc dyn_cast_GlobalIFunc(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static GlobalIFunc dyn_cast_or_null_GlobalIFunc(Value/*P*/ From) {
    return (From != null) && isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static boolean isa_GlobalIFunc(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalIFunc(From.get());
  }

  public static GlobalIFunc cast_GlobalIFunc(Use/*P*/ From) {
    return cast_GlobalIFunc(From.get());
  }

  public static GlobalIFunc cast_or_null_GlobalIFunc(Use/*P*/ From) {
    return cast_or_null_GlobalIFunc(From.get());
  }

  public static GlobalIFunc dyn_cast_GlobalIFunc(Use/*P*/ From) {
    return isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static GlobalIFunc dyn_cast_or_null_GlobalIFunc(Use/*P*/ From) {
    return (From != null) && isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static boolean isa_GlobalIFunc(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalIFunc.class, From.$star());
  }

  public static GlobalIFunc cast_GlobalIFunc(type$ptr<?>/*P*/ From) {
    assert isa_GlobalIFunc(From);
    return llvm.cast(GlobalIFunc.class, From.$star());
  }

  public static GlobalIFunc cast_or_null_GlobalIFunc(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalIFunc(From);
  }

  public static GlobalIFunc dyn_cast_GlobalIFunc(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static GlobalIFunc dyn_cast_or_null_GlobalIFunc(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static boolean isa_GlobalIFunc(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalIFunc.class, From.$deref());
  }

  public static GlobalIFunc cast_GlobalIFunc(type$ref<?>/*P*/ From) {
    assert isa_GlobalIFunc(From);
    return llvm.cast(GlobalIFunc.class, From.$deref());
  }

  public static GlobalIFunc cast_or_null_GlobalIFunc(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalIFunc(From);
  }

  public static GlobalIFunc dyn_cast_GlobalIFunc(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static GlobalIFunc dyn_cast_or_null_GlobalIFunc(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalIFunc(From) ? cast_GlobalIFunc(From) : null;
  }

  public static boolean isa_GlobalIndirectSymbol(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalIndirectSymbol(From.get());
  }

  public static GlobalIndirectSymbol cast_GlobalIndirectSymbol(Use/*P*/ From) {
    return cast_GlobalIndirectSymbol(From.get());
  }

  public static GlobalIndirectSymbol cast_or_null_GlobalIndirectSymbol(Use/*P*/ From) {
    return cast_or_null_GlobalIndirectSymbol(From.get());
  }

  public static GlobalIndirectSymbol dyn_cast_GlobalIndirectSymbol(Use/*P*/ From) {
    return isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static GlobalIndirectSymbol dyn_cast_or_null_GlobalIndirectSymbol(Use/*P*/ From) {
    return (From != null) && isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static boolean isa_GlobalIndirectSymbol(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalIndirectSymbol.class, From.$deref());
  }

  public static GlobalIndirectSymbol cast_GlobalIndirectSymbol(type$ref<?>/*P*/ From) {
    assert isa_GlobalIndirectSymbol(From);
    return llvm.cast(GlobalIndirectSymbol.class, From.$deref());
  }

  public static GlobalIndirectSymbol cast_or_null_GlobalIndirectSymbol(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalIndirectSymbol(From);
  }

  public static GlobalIndirectSymbol dyn_cast_GlobalIndirectSymbol(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static GlobalIndirectSymbol dyn_cast_or_null_GlobalIndirectSymbol(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static boolean isa_GlobalIndirectSymbol(Value/*P*/ From) {
    assert From != null;
    return GlobalIndirectSymbol.classof(From);
  }

  public static GlobalIndirectSymbol cast_GlobalIndirectSymbol(Value/*P*/ From) {
    assert isa_GlobalIndirectSymbol(From);
    return (GlobalIndirectSymbol) From;
  }

  public static GlobalIndirectSymbol cast_or_null_GlobalIndirectSymbol(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalIndirectSymbol(From);
  }

  public static GlobalIndirectSymbol dyn_cast_GlobalIndirectSymbol(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static GlobalIndirectSymbol dyn_cast_or_null_GlobalIndirectSymbol(Value/*P*/ From) {
    return (From != null) && isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static boolean isa_GlobalIndirectSymbol(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalIndirectSymbol.class, From.$star());
  }

  public static GlobalIndirectSymbol cast_GlobalIndirectSymbol(type$ptr<?>/*P*/ From) {
    assert isa_GlobalIndirectSymbol(From);
    return llvm.cast(GlobalIndirectSymbol.class, From.$star());
  }

  public static GlobalIndirectSymbol cast_or_null_GlobalIndirectSymbol(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalIndirectSymbol(From);
  }

  public static GlobalIndirectSymbol dyn_cast_GlobalIndirectSymbol(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static GlobalIndirectSymbol dyn_cast_or_null_GlobalIndirectSymbol(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalIndirectSymbol(From) ? cast_GlobalIndirectSymbol(From) : null;
  }

  public static boolean isa_GlobalObject(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalObject.class, From.$star());
  }

  public static GlobalObject cast_GlobalObject(type$ptr<?>/*P*/ From) {
    assert isa_GlobalObject(From);
    return llvm.cast(GlobalObject.class, From.$star());
  }

  public static GlobalObject cast_or_null_GlobalObject(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalObject(From);
  }

  public static GlobalObject dyn_cast_GlobalObject(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static GlobalObject dyn_cast_or_null_GlobalObject(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static boolean isa_GlobalObject(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalObject.class, From.$deref());
  }

  public static GlobalObject cast_GlobalObject(type$ref<?>/*P*/ From) {
    assert isa_GlobalObject(From);
    return llvm.cast(GlobalObject.class, From.$deref());
  }

  public static GlobalObject cast_or_null_GlobalObject(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalObject(From);
  }

  public static GlobalObject dyn_cast_GlobalObject(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static GlobalObject dyn_cast_or_null_GlobalObject(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static boolean isa_GlobalObject(Value/*P*/ From) {
    assert From != null;
    return GlobalObject.classof(From);
  }

  public static GlobalObject cast_GlobalObject(Value/*P*/ From) {
    assert isa_GlobalObject(From);
    return (GlobalObject) From;
  }

  public static GlobalObject cast_or_null_GlobalObject(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalObject(From);
  }

  public static GlobalObject dyn_cast_GlobalObject(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static GlobalObject dyn_cast_or_null_GlobalObject(Value/*P*/ From) {
    return (From != null) && isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static boolean isa_GlobalObject(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalObject(From.get());
  }

  public static GlobalObject cast_GlobalObject(Use/*P*/ From) {
    return cast_GlobalObject(From.get());
  }

  public static GlobalObject cast_or_null_GlobalObject(Use/*P*/ From) {
    return cast_or_null_GlobalObject(From.get());
  }

  public static GlobalObject dyn_cast_GlobalObject(Use/*P*/ From) {
    return isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static GlobalObject dyn_cast_or_null_GlobalObject(Use/*P*/ From) {
    return (From != null) && isa_GlobalObject(From) ? cast_GlobalObject(From) : null;
  }

  public static boolean isa_GlobalValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalValue.class, From.$deref());
  }

  public static GlobalValue cast_GlobalValue(type$ref<?>/*P*/ From) {
    assert isa_GlobalValue(From);
    return llvm.cast(GlobalValue.class, From.$deref());
  }

  public static GlobalValue cast_or_null_GlobalValue(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalValue(From);
  }

  public static GlobalValue dyn_cast_GlobalValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static GlobalValue dyn_cast_or_null_GlobalValue(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static boolean isa_GlobalValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalValue.class, From.$star());
  }

  public static GlobalValue cast_GlobalValue(type$ptr<?>/*P*/ From) {
    assert isa_GlobalValue(From);
    return llvm.cast(GlobalValue.class, From.$star());
  }

  public static GlobalValue cast_or_null_GlobalValue(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalValue(From);
  }

  public static GlobalValue dyn_cast_GlobalValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static GlobalValue dyn_cast_or_null_GlobalValue(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static boolean isa_GlobalValue(Value/*P*/ From) {
    assert From != null;
    return GlobalValue.classof(From);
  }

  public static GlobalValue cast_GlobalValue(Value/*P*/ From) {
    assert isa_GlobalValue(From);
    return (GlobalValue) From;
  }

  public static GlobalValue cast_or_null_GlobalValue(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalValue(From);
  }

  public static GlobalValue dyn_cast_GlobalValue(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static GlobalValue dyn_cast_or_null_GlobalValue(Value/*P*/ From) {
    return (From != null) && isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static boolean isa_GlobalValue(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalValue(From.get());
  }

  public static GlobalValue cast_GlobalValue(Use/*P*/ From) {
    return cast_GlobalValue(From.get());
  }

  public static GlobalValue cast_or_null_GlobalValue(Use/*P*/ From) {
    return cast_or_null_GlobalValue(From.get());
  }

  public static GlobalValue dyn_cast_GlobalValue(Use/*P*/ From) {
    return isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static GlobalValue dyn_cast_or_null_GlobalValue(Use/*P*/ From) {
    return (From != null) && isa_GlobalValue(From) ? cast_GlobalValue(From) : null;
  }

  public static boolean isa_GlobalValueSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalValueSummary.class, From.$deref());
  }

  public static GlobalValueSummary cast_GlobalValueSummary(type$ref<?>/*P*/ From) {
    assert isa_GlobalValueSummary(From);
    return llvm.cast(GlobalValueSummary.class, From.$deref());
  }

  public static GlobalValueSummary cast_or_null_GlobalValueSummary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalValueSummary(From);
  }

  public static GlobalValueSummary dyn_cast_GlobalValueSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static GlobalValueSummary dyn_cast_or_null_GlobalValueSummary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static boolean isa_GlobalValueSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return true;
  }

  public static GlobalValueSummary cast_GlobalValueSummary(GlobalValueSummary/*P*/ From) {
    assert isa_GlobalValueSummary(From);
    return (GlobalValueSummary) From;
  }

  public static GlobalValueSummary cast_or_null_GlobalValueSummary(GlobalValueSummary/*P*/ From) {
    return (From == null) ? null : cast_GlobalValueSummary(From);
  }

  public static GlobalValueSummary dyn_cast_GlobalValueSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static GlobalValueSummary dyn_cast_or_null_GlobalValueSummary(GlobalValueSummary/*P*/ From) {
    return (From != null) && isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static boolean isa_GlobalValueSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalValueSummary.class, From.$star());
  }

  public static GlobalValueSummary cast_GlobalValueSummary(type$ptr<?>/*P*/ From) {
    assert isa_GlobalValueSummary(From);
    return llvm.cast(GlobalValueSummary.class, From.$star());
  }

  public static GlobalValueSummary cast_or_null_GlobalValueSummary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalValueSummary(From);
  }

  public static GlobalValueSummary dyn_cast_GlobalValueSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static GlobalValueSummary dyn_cast_or_null_GlobalValueSummary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalValueSummary(From) ? cast_GlobalValueSummary(From) : null;
  }

  public static boolean isa_GlobalVarSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalVarSummary.class, From.$star());
  }

  public static GlobalVarSummary cast_GlobalVarSummary(type$ptr<?>/*P*/ From) {
    assert isa_GlobalVarSummary(From);
    return llvm.cast(GlobalVarSummary.class, From.$star());
  }

  public static GlobalVarSummary cast_or_null_GlobalVarSummary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalVarSummary(From);
  }

  public static GlobalVarSummary dyn_cast_GlobalVarSummary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static GlobalVarSummary dyn_cast_or_null_GlobalVarSummary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static boolean isa_GlobalVarSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return GlobalVarSummary.classof(From);
  }

  public static GlobalVarSummary cast_GlobalVarSummary(GlobalValueSummary/*P*/ From) {
    assert isa_GlobalVarSummary(From);
    return (GlobalVarSummary) From;
  }

  public static GlobalVarSummary cast_or_null_GlobalVarSummary(GlobalValueSummary/*P*/ From) {
    return (From == null) ? null : cast_GlobalVarSummary(From);
  }

  public static GlobalVarSummary dyn_cast_GlobalVarSummary(GlobalValueSummary/*P*/ From) {
    assert From != null;
    return isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static GlobalVarSummary dyn_cast_or_null_GlobalVarSummary(GlobalValueSummary/*P*/ From) {
    return (From != null) && isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static boolean isa_GlobalVarSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalVarSummary.class, From.$deref());
  }

  public static GlobalVarSummary cast_GlobalVarSummary(type$ref<?>/*P*/ From) {
    assert isa_GlobalVarSummary(From);
    return llvm.cast(GlobalVarSummary.class, From.$deref());
  }

  public static GlobalVarSummary cast_or_null_GlobalVarSummary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalVarSummary(From);
  }

  public static GlobalVarSummary dyn_cast_GlobalVarSummary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static GlobalVarSummary dyn_cast_or_null_GlobalVarSummary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalVarSummary(From) ? cast_GlobalVarSummary(From) : null;
  }

  public static boolean isa_GlobalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GlobalVariable.class, From.$deref());
  }

  public static GlobalVariable cast_GlobalVariable(type$ref<?>/*P*/ From) {
    assert isa_GlobalVariable(From);
    return llvm.cast(GlobalVariable.class, From.$deref());
  }

  public static GlobalVariable cast_or_null_GlobalVariable(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GlobalVariable(From);
  }

  public static GlobalVariable dyn_cast_GlobalVariable(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static GlobalVariable dyn_cast_or_null_GlobalVariable(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static boolean isa_GlobalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GlobalVariable.class, From.$star());
  }

  public static GlobalVariable cast_GlobalVariable(type$ptr<?>/*P*/ From) {
    assert isa_GlobalVariable(From);
    return llvm.cast(GlobalVariable.class, From.$star());
  }

  public static GlobalVariable cast_or_null_GlobalVariable(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GlobalVariable(From);
  }

  public static GlobalVariable dyn_cast_GlobalVariable(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static GlobalVariable dyn_cast_or_null_GlobalVariable(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static boolean isa_GlobalVariable(Value/*P*/ From) {
    assert From != null;
    return GlobalVariable.classof(From);
  }

  public static GlobalVariable cast_GlobalVariable(Value/*P*/ From) {
    assert isa_GlobalVariable(From);
    return (GlobalVariable) From;
  }

  public static GlobalVariable cast_or_null_GlobalVariable(Value/*P*/ From) {
    return (From == null) ? null : cast_GlobalVariable(From);
  }

  public static GlobalVariable dyn_cast_GlobalVariable(Value/*P*/ From) {
    assert From != null;
    return isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static GlobalVariable dyn_cast_or_null_GlobalVariable(Value/*P*/ From) {
    return (From != null) && isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static boolean isa_GlobalVariable(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GlobalVariable(From.get());
  }

  public static GlobalVariable cast_GlobalVariable(Use/*P*/ From) {
    return cast_GlobalVariable(From.get());
  }

  public static GlobalVariable cast_or_null_GlobalVariable(Use/*P*/ From) {
    return cast_or_null_GlobalVariable(From.get());
  }

  public static GlobalVariable dyn_cast_GlobalVariable(Use/*P*/ From) {
    return isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static GlobalVariable dyn_cast_or_null_GlobalVariable(Use/*P*/ From) {
    return (From != null) && isa_GlobalVariable(From) ? cast_GlobalVariable(From) : null;
  }

  public static boolean isa_ICmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ICmpInst.class, From.$deref());
  }

  public static ICmpInst cast_ICmpInst(type$ref<?>/*P*/ From) {
    assert isa_ICmpInst(From);
    return llvm.cast(ICmpInst.class, From.$deref());
  }

  public static ICmpInst cast_or_null_ICmpInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ICmpInst(From);
  }

  public static ICmpInst dyn_cast_ICmpInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static ICmpInst dyn_cast_or_null_ICmpInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static boolean isa_ICmpInst(Instruction/*P*/ From) {
    assert From != null;
    return ICmpInst.classof(From);
  }

  public static ICmpInst cast_ICmpInst(Instruction/*P*/ From) {
    assert isa_ICmpInst(From);
    return llvm.cast(ICmpInst.class, From);
  }

  public static ICmpInst cast_or_null_ICmpInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ICmpInst(From);
  }

  public static ICmpInst dyn_cast_ICmpInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static ICmpInst dyn_cast_or_null_ICmpInst(Instruction/*P*/ From) {
    return (From != null) && isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static boolean isa_ICmpInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ICmpInst(From.get());
  }

  public static ICmpInst cast_ICmpInst(Use/*P*/ From) {
    return cast_ICmpInst(From.get());
  }

  public static ICmpInst cast_or_null_ICmpInst(Use/*P*/ From) {
    return cast_or_null_ICmpInst(From.get());
  }

  public static ICmpInst dyn_cast_ICmpInst(Use/*P*/ From) {
    return isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static ICmpInst dyn_cast_or_null_ICmpInst(Use/*P*/ From) {
    return (From != null) && isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static boolean isa_ICmpInst(Value/*P*/ From) {
    assert From != null;
    return ICmpInst.classof(From);
  }

  public static ICmpInst cast_ICmpInst(Value/*P*/ From) {
    assert isa_ICmpInst(From);
    return (ICmpInst) From;
  }

  public static ICmpInst cast_or_null_ICmpInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ICmpInst(From);
  }

  public static ICmpInst dyn_cast_ICmpInst(Value/*P*/ From) {
    assert From != null;
    return isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static ICmpInst dyn_cast_or_null_ICmpInst(Value/*P*/ From) {
    return (From != null) && isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static boolean isa_ICmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ICmpInst.class, From.$star());
  }

  public static ICmpInst cast_ICmpInst(type$ptr<?>/*P*/ From) {
    assert isa_ICmpInst(From);
    return llvm.cast(ICmpInst.class, From.$star());
  }

  public static ICmpInst cast_or_null_ICmpInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ICmpInst(From);
  }

  public static ICmpInst dyn_cast_ICmpInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static ICmpInst dyn_cast_or_null_ICmpInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ICmpInst(From) ? cast_ICmpInst(From) : null;
  }

  public static boolean isa_IndirectBrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IndirectBrInst.class, From.$star());
  }

  public static IndirectBrInst cast_IndirectBrInst(type$ptr<?>/*P*/ From) {
    assert isa_IndirectBrInst(From);
    return llvm.cast(IndirectBrInst.class, From.$star());
  }

  public static IndirectBrInst cast_or_null_IndirectBrInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IndirectBrInst(From);
  }

  public static IndirectBrInst dyn_cast_IndirectBrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static IndirectBrInst dyn_cast_or_null_IndirectBrInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static boolean isa_IndirectBrInst(Instruction/*P*/ From) {
    assert From != null;
    return IndirectBrInst.classof(From);
  }

  public static IndirectBrInst cast_IndirectBrInst(Instruction/*P*/ From) {
    assert isa_IndirectBrInst(From);
    return llvm.cast(IndirectBrInst.class, From);
  }

  public static IndirectBrInst cast_or_null_IndirectBrInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_IndirectBrInst(From);
  }

  public static IndirectBrInst dyn_cast_IndirectBrInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static IndirectBrInst dyn_cast_or_null_IndirectBrInst(Instruction/*P*/ From) {
    return (From != null) && isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static boolean isa_IndirectBrInst(Value/*P*/ From) {
    assert From != null;
    return IndirectBrInst.classof(From);
  }

  public static IndirectBrInst cast_IndirectBrInst(Value/*P*/ From) {
    assert isa_IndirectBrInst(From);
    return (IndirectBrInst) From;
  }

  public static IndirectBrInst cast_or_null_IndirectBrInst(Value/*P*/ From) {
    return (From == null) ? null : cast_IndirectBrInst(From);
  }

  public static IndirectBrInst dyn_cast_IndirectBrInst(Value/*P*/ From) {
    assert From != null;
    return isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static IndirectBrInst dyn_cast_or_null_IndirectBrInst(Value/*P*/ From) {
    return (From != null) && isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static boolean isa_IndirectBrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IndirectBrInst.class, From.$deref());
  }

  public static IndirectBrInst cast_IndirectBrInst(type$ref<?>/*P*/ From) {
    assert isa_IndirectBrInst(From);
    return llvm.cast(IndirectBrInst.class, From.$deref());
  }

  public static IndirectBrInst cast_or_null_IndirectBrInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IndirectBrInst(From);
  }

  public static IndirectBrInst dyn_cast_IndirectBrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static IndirectBrInst dyn_cast_or_null_IndirectBrInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static boolean isa_IndirectBrInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_IndirectBrInst(From.get());
  }

  public static IndirectBrInst cast_IndirectBrInst(Use/*P*/ From) {
    return cast_IndirectBrInst(From.get());
  }

  public static IndirectBrInst cast_or_null_IndirectBrInst(Use/*P*/ From) {
    return cast_or_null_IndirectBrInst(From.get());
  }

  public static IndirectBrInst dyn_cast_IndirectBrInst(Use/*P*/ From) {
    return isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static IndirectBrInst dyn_cast_or_null_IndirectBrInst(Use/*P*/ From) {
    return (From != null) && isa_IndirectBrInst(From) ? cast_IndirectBrInst(From) : null;
  }

  public static boolean isa_InlineAsm(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InlineAsm(From.get());
  }

  public static InlineAsm cast_InlineAsm(Use/*P*/ From) {
    return cast_InlineAsm(From.get());
  }

  public static InlineAsm cast_or_null_InlineAsm(Use/*P*/ From) {
    return cast_or_null_InlineAsm(From.get());
  }

  public static InlineAsm dyn_cast_InlineAsm(Use/*P*/ From) {
    return isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static InlineAsm dyn_cast_or_null_InlineAsm(Use/*P*/ From) {
    return (From != null) && isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static boolean isa_InlineAsm(Value/*P*/ From) {
    assert From != null;
    return InlineAsm.classof(From);
  }

  public static InlineAsm cast_InlineAsm(Value/*P*/ From) {
    assert isa_InlineAsm(From);
    return (InlineAsm) From;
  }

  public static InlineAsm cast_or_null_InlineAsm(Value/*P*/ From) {
    return (From == null) ? null : cast_InlineAsm(From);
  }

  public static InlineAsm dyn_cast_InlineAsm(Value/*P*/ From) {
    assert From != null;
    return isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static InlineAsm dyn_cast_or_null_InlineAsm(Value/*P*/ From) {
    return (From != null) && isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static boolean isa_InlineAsm(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InlineAsm.class, From.$star());
  }

  public static InlineAsm cast_InlineAsm(type$ptr<?>/*P*/ From) {
    assert isa_InlineAsm(From);
    return llvm.cast(InlineAsm.class, From.$star());
  }

  public static InlineAsm cast_or_null_InlineAsm(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InlineAsm(From);
  }

  public static InlineAsm dyn_cast_InlineAsm(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static InlineAsm dyn_cast_or_null_InlineAsm(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static boolean isa_InlineAsm(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InlineAsm.class, From.$deref());
  }

  public static InlineAsm cast_InlineAsm(type$ref<?>/*P*/ From) {
    assert isa_InlineAsm(From);
    return llvm.cast(InlineAsm.class, From.$deref());
  }

  public static InlineAsm cast_or_null_InlineAsm(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InlineAsm(From);
  }

  public static InlineAsm dyn_cast_InlineAsm(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static InlineAsm dyn_cast_or_null_InlineAsm(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InlineAsm(From) ? cast_InlineAsm(From) : null;
  }

  public static boolean isa_InsertElementInst(Instruction/*P*/ From) {
    assert From != null;
    return InsertElementInst.classof(From);
  }

  public static InsertElementInst cast_InsertElementInst(Instruction/*P*/ From) {
    assert isa_InsertElementInst(From);
    return llvm.cast(InsertElementInst.class, From);
  }

  public static InsertElementInst cast_or_null_InsertElementInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_InsertElementInst(From);
  }

  public static InsertElementInst dyn_cast_InsertElementInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static InsertElementInst dyn_cast_or_null_InsertElementInst(Instruction/*P*/ From) {
    return (From != null) && isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static boolean isa_InsertElementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InsertElementInst.class, From.$deref());
  }

  public static InsertElementInst cast_InsertElementInst(type$ref<?>/*P*/ From) {
    assert isa_InsertElementInst(From);
    return llvm.cast(InsertElementInst.class, From.$deref());
  }

  public static InsertElementInst cast_or_null_InsertElementInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InsertElementInst(From);
  }

  public static InsertElementInst dyn_cast_InsertElementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static InsertElementInst dyn_cast_or_null_InsertElementInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static boolean isa_InsertElementInst(Value/*P*/ From) {
    assert From != null;
    return InsertElementInst.classof(From);
  }

  public static InsertElementInst cast_InsertElementInst(Value/*P*/ From) {
    assert isa_InsertElementInst(From);
    return (InsertElementInst) From;
  }

  public static InsertElementInst cast_or_null_InsertElementInst(Value/*P*/ From) {
    return (From == null) ? null : cast_InsertElementInst(From);
  }

  public static InsertElementInst dyn_cast_InsertElementInst(Value/*P*/ From) {
    assert From != null;
    return isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static InsertElementInst dyn_cast_or_null_InsertElementInst(Value/*P*/ From) {
    return (From != null) && isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static boolean isa_InsertElementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InsertElementInst.class, From.$star());
  }

  public static InsertElementInst cast_InsertElementInst(type$ptr<?>/*P*/ From) {
    assert isa_InsertElementInst(From);
    return llvm.cast(InsertElementInst.class, From.$star());
  }

  public static InsertElementInst cast_or_null_InsertElementInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InsertElementInst(From);
  }

  public static InsertElementInst dyn_cast_InsertElementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static InsertElementInst dyn_cast_or_null_InsertElementInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static boolean isa_InsertElementInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InsertElementInst(From.get());
  }

  public static InsertElementInst cast_InsertElementInst(Use/*P*/ From) {
    return cast_InsertElementInst(From.get());
  }

  public static InsertElementInst cast_or_null_InsertElementInst(Use/*P*/ From) {
    return cast_or_null_InsertElementInst(From.get());
  }

  public static InsertElementInst dyn_cast_InsertElementInst(Use/*P*/ From) {
    return isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static InsertElementInst dyn_cast_or_null_InsertElementInst(Use/*P*/ From) {
    return (From != null) && isa_InsertElementInst(From) ? cast_InsertElementInst(From) : null;
  }

  public static boolean isa_InsertValueInst(Value/*P*/ From) {
    assert From != null;
    return InsertValueInst.classof(From);
  }

  public static InsertValueInst cast_InsertValueInst(Value/*P*/ From) {
    assert isa_InsertValueInst(From);
    return (InsertValueInst) From;
  }

  public static InsertValueInst cast_or_null_InsertValueInst(Value/*P*/ From) {
    return (From == null) ? null : cast_InsertValueInst(From);
  }

  public static InsertValueInst dyn_cast_InsertValueInst(Value/*P*/ From) {
    assert From != null;
    return isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static InsertValueInst dyn_cast_or_null_InsertValueInst(Value/*P*/ From) {
    return (From != null) && isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static boolean isa_InsertValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InsertValueInst.class, From.$star());
  }

  public static InsertValueInst cast_InsertValueInst(type$ptr<?>/*P*/ From) {
    assert isa_InsertValueInst(From);
    return llvm.cast(InsertValueInst.class, From.$star());
  }

  public static InsertValueInst cast_or_null_InsertValueInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InsertValueInst(From);
  }

  public static InsertValueInst dyn_cast_InsertValueInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static InsertValueInst dyn_cast_or_null_InsertValueInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static boolean isa_InsertValueInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InsertValueInst(From.get());
  }

  public static InsertValueInst cast_InsertValueInst(Use/*P*/ From) {
    return cast_InsertValueInst(From.get());
  }

  public static InsertValueInst cast_or_null_InsertValueInst(Use/*P*/ From) {
    return cast_or_null_InsertValueInst(From.get());
  }

  public static InsertValueInst dyn_cast_InsertValueInst(Use/*P*/ From) {
    return isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static InsertValueInst dyn_cast_or_null_InsertValueInst(Use/*P*/ From) {
    return (From != null) && isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static boolean isa_InsertValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InsertValueInst.class, From.$deref());
  }

  public static InsertValueInst cast_InsertValueInst(type$ref<?>/*P*/ From) {
    assert isa_InsertValueInst(From);
    return llvm.cast(InsertValueInst.class, From.$deref());
  }

  public static InsertValueInst cast_or_null_InsertValueInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InsertValueInst(From);
  }

  public static InsertValueInst dyn_cast_InsertValueInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static InsertValueInst dyn_cast_or_null_InsertValueInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static boolean isa_InsertValueInst(Instruction/*P*/ From) {
    assert From != null;
    return InsertValueInst.classof(From);
  }

  public static InsertValueInst cast_InsertValueInst(Instruction/*P*/ From) {
    assert isa_InsertValueInst(From);
    return llvm.cast(InsertValueInst.class, From);
  }

  public static InsertValueInst cast_or_null_InsertValueInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_InsertValueInst(From);
  }

  public static InsertValueInst dyn_cast_InsertValueInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static InsertValueInst dyn_cast_or_null_InsertValueInst(Instruction/*P*/ From) {
    return (From != null) && isa_InsertValueInst(From) ? cast_InsertValueInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return InstrProfIncrementInst.classof(From);
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(IntrinsicInst/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return (InstrProfIncrementInst) From;
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InstrProfIncrementInst.class, From.$star());
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(type$ptr<?>/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return llvm.cast(InstrProfIncrementInst.class, From.$star());
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InstrProfIncrementInst(From.get());
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(Use/*P*/ From) {
    return cast_InstrProfIncrementInst(From.get());
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(Use/*P*/ From) {
    return cast_or_null_InstrProfIncrementInst(From.get());
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(Use/*P*/ From) {
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(Use/*P*/ From) {
    return (From != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InstrProfIncrementInst.class, From.$deref());
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(type$ref<?>/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return llvm.cast(InstrProfIncrementInst.class, From.$deref());
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(Value/*P*/ From) {
    assert From != null;
    return InstrProfIncrementInst.classof(From);
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(Value/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return (InstrProfIncrementInst) From;
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(Value/*P*/ From) {
    return (From == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(Value/*P*/ From) {
    assert From != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(Value/*P*/ From) {
    return (From != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(Instruction/*P*/ From) {
    assert From != null;
    return InstrProfIncrementInst.classof(From);
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(Instruction/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return llvm.cast(InstrProfIncrementInst.class, From);
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(Instruction/*P*/ From) {
    return (From != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfIncrementInst(CallInst/*P*/ From) {
    assert From != null;
    return InstrProfIncrementInst.classof(From);
  }

  public static InstrProfIncrementInst cast_InstrProfIncrementInst(CallInst/*P*/ From) {
    assert isa_InstrProfIncrementInst(From);
    return (InstrProfIncrementInst) From;
  }

  public static InstrProfIncrementInst cast_or_null_InstrProfIncrementInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_InstrProfIncrementInst(From);
  }

  public static InstrProfIncrementInst dyn_cast_InstrProfIncrementInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static InstrProfIncrementInst dyn_cast_or_null_InstrProfIncrementInst(CallInst/*P*/ From) {
    return (From != null) && isa_InstrProfIncrementInst(From) ? cast_InstrProfIncrementInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InstrProfValueProfileInst.class, From.$deref());
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(type$ref<?>/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return llvm.cast(InstrProfValueProfileInst.class, From.$deref());
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(Instruction/*P*/ From) {
    assert From != null;
    return InstrProfValueProfileInst.classof(From);
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(Instruction/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return llvm.cast(InstrProfValueProfileInst.class, From);
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(Instruction/*P*/ From) {
    return (From != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return InstrProfValueProfileInst.classof(From);
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(IntrinsicInst/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return (InstrProfValueProfileInst) From;
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InstrProfValueProfileInst(From.get());
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(Use/*P*/ From) {
    return cast_InstrProfValueProfileInst(From.get());
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(Use/*P*/ From) {
    return cast_or_null_InstrProfValueProfileInst(From.get());
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(Use/*P*/ From) {
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(Use/*P*/ From) {
    return (From != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(Value/*P*/ From) {
    assert From != null;
    return InstrProfValueProfileInst.classof(From);
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(Value/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return (InstrProfValueProfileInst) From;
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(Value/*P*/ From) {
    return (From == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(Value/*P*/ From) {
    assert From != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(Value/*P*/ From) {
    return (From != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(CallInst/*P*/ From) {
    assert From != null;
    return InstrProfValueProfileInst.classof(From);
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(CallInst/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return (InstrProfValueProfileInst) From;
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(CallInst/*P*/ From) {
    return (From != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_InstrProfValueProfileInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InstrProfValueProfileInst.class, From.$star());
  }

  public static InstrProfValueProfileInst cast_InstrProfValueProfileInst(type$ptr<?>/*P*/ From) {
    assert isa_InstrProfValueProfileInst(From);
    return llvm.cast(InstrProfValueProfileInst.class, From.$star());
  }

  public static InstrProfValueProfileInst cast_or_null_InstrProfValueProfileInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InstrProfValueProfileInst(From);
  }

  public static InstrProfValueProfileInst dyn_cast_InstrProfValueProfileInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static InstrProfValueProfileInst dyn_cast_or_null_InstrProfValueProfileInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InstrProfValueProfileInst(From) ? cast_InstrProfValueProfileInst(From) : null;
  }

  public static boolean isa_Instruction(Value/*P*/ From) {
    assert From != null;
    return Instruction.classof(From);
  }

  public static Instruction cast_Instruction(Value/*P*/ From) {
    assert isa_Instruction(From);
    return (Instruction) From;
  }

  public static Instruction cast_or_null_Instruction(Value/*P*/ From) {
    return (From == null) ? null : cast_Instruction(From);
  }

  public static Instruction dyn_cast_Instruction(Value/*P*/ From) {
    assert From != null;
    return isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static Instruction dyn_cast_or_null_Instruction(Value/*P*/ From) {
    return (From != null) && isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static boolean isa_Instruction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Instruction.class, From.$star());
  }

  public static Instruction cast_Instruction(type$ptr<?>/*P*/ From) {
    assert isa_Instruction(From);
    return llvm.cast(Instruction.class, From.$star());
  }

  public static Instruction cast_or_null_Instruction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Instruction(From);
  }

  public static Instruction dyn_cast_Instruction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static Instruction dyn_cast_or_null_Instruction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static boolean isa_Instruction(Instruction/*P*/ From) {
    assert From != null;
    return Instruction.classof(From);
  }

  public static Instruction cast_Instruction(Instruction/*P*/ From) {
    assert isa_Instruction(From);
    return llvm.cast(Instruction.class, From);
  }

  public static Instruction cast_or_null_Instruction(Instruction/*P*/ From) {
    return (From == null) ? null : cast_Instruction(From);
  }

  public static Instruction dyn_cast_Instruction(Instruction/*P*/ From) {
    assert From != null;
    return isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static Instruction dyn_cast_or_null_Instruction(Instruction/*P*/ From) {
    return (From != null) && isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static boolean isa_Instruction(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Instruction(From.get());
  }

  public static Instruction cast_Instruction(Use/*P*/ From) {
    return cast_Instruction(From.get());
  }

  public static Instruction cast_or_null_Instruction(Use/*P*/ From) {
    return cast_or_null_Instruction(From.get());
  }

  public static Instruction dyn_cast_Instruction(Use/*P*/ From) {
    return isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static Instruction dyn_cast_or_null_Instruction(Use/*P*/ From) {
    return (From != null) && isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static boolean isa_Instruction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Instruction.class, From.$deref());
  }

  public static Instruction cast_Instruction(type$ref<?>/*P*/ From) {
    assert isa_Instruction(From);
    return llvm.cast(Instruction.class, From.$deref());
  }

  public static Instruction cast_or_null_Instruction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Instruction(From);
  }

  public static Instruction dyn_cast_Instruction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static Instruction dyn_cast_or_null_Instruction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Instruction(From) ? cast_Instruction(From) : null;
  }

  public static boolean isa_IntToPtrInst(Value/*P*/ From) {
    assert From != null;
    return IntToPtrInst.classof(From);
  }

  public static IntToPtrInst cast_IntToPtrInst(Value/*P*/ From) {
    assert isa_IntToPtrInst(From);
    return (IntToPtrInst) From;
  }

  public static IntToPtrInst cast_or_null_IntToPtrInst(Value/*P*/ From) {
    return (From == null) ? null : cast_IntToPtrInst(From);
  }

  public static IntToPtrInst dyn_cast_IntToPtrInst(Value/*P*/ From) {
    assert From != null;
    return isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static IntToPtrInst dyn_cast_or_null_IntToPtrInst(Value/*P*/ From) {
    return (From != null) && isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static boolean isa_IntToPtrInst(Instruction/*P*/ From) {
    assert From != null;
    return IntToPtrInst.classof(From);
  }

  public static IntToPtrInst cast_IntToPtrInst(Instruction/*P*/ From) {
    assert isa_IntToPtrInst(From);
    return llvm.cast(IntToPtrInst.class, From);
  }

  public static IntToPtrInst cast_or_null_IntToPtrInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_IntToPtrInst(From);
  }

  public static IntToPtrInst dyn_cast_IntToPtrInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static IntToPtrInst dyn_cast_or_null_IntToPtrInst(Instruction/*P*/ From) {
    return (From != null) && isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static boolean isa_IntToPtrInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_IntToPtrInst(From.get());
  }

  public static IntToPtrInst cast_IntToPtrInst(Use/*P*/ From) {
    return cast_IntToPtrInst(From.get());
  }

  public static IntToPtrInst cast_or_null_IntToPtrInst(Use/*P*/ From) {
    return cast_or_null_IntToPtrInst(From.get());
  }

  public static IntToPtrInst dyn_cast_IntToPtrInst(Use/*P*/ From) {
    return isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static IntToPtrInst dyn_cast_or_null_IntToPtrInst(Use/*P*/ From) {
    return (From != null) && isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static boolean isa_IntToPtrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntToPtrInst.class, From.$deref());
  }

  public static IntToPtrInst cast_IntToPtrInst(type$ref<?>/*P*/ From) {
    assert isa_IntToPtrInst(From);
    return llvm.cast(IntToPtrInst.class, From.$deref());
  }

  public static IntToPtrInst cast_or_null_IntToPtrInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntToPtrInst(From);
  }

  public static IntToPtrInst dyn_cast_IntToPtrInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static IntToPtrInst dyn_cast_or_null_IntToPtrInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static boolean isa_IntToPtrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntToPtrInst.class, From.$star());
  }

  public static IntToPtrInst cast_IntToPtrInst(type$ptr<?>/*P*/ From) {
    assert isa_IntToPtrInst(From);
    return llvm.cast(IntToPtrInst.class, From.$star());
  }

  public static IntToPtrInst cast_or_null_IntToPtrInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntToPtrInst(From);
  }

  public static IntToPtrInst dyn_cast_IntToPtrInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static IntToPtrInst dyn_cast_or_null_IntToPtrInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntToPtrInst(From) ? cast_IntToPtrInst(From) : null;
  }

  public static boolean isa_IntegerType(Type/*P*/ From) {
    assert From != null;
    return IntegerType.classof(From);
  }

  public static IntegerType cast_IntegerType(Type/*P*/ From) {
    assert isa_IntegerType(From);
    return (IntegerType) From;
  }

  public static IntegerType cast_or_null_IntegerType(Type/*P*/ From) {
    return (From == null) ? null : cast_IntegerType(From);
  }

  public static IntegerType dyn_cast_IntegerType(Type/*P*/ From) {
    assert From != null;
    return isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static IntegerType dyn_cast_or_null_IntegerType(Type/*P*/ From) {
    return (From != null) && isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static boolean isa_IntegerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntegerType.class, From.$star());
  }

  public static IntegerType cast_IntegerType(type$ptr<?>/*P*/ From) {
    assert isa_IntegerType(From);
    return llvm.cast(IntegerType.class, From.$star());
  }

  public static IntegerType cast_or_null_IntegerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntegerType(From);
  }

  public static IntegerType dyn_cast_IntegerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static IntegerType dyn_cast_or_null_IntegerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static boolean isa_IntegerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntegerType.class, From.$deref());
  }

  public static IntegerType cast_IntegerType(type$ref<?>/*P*/ From) {
    assert isa_IntegerType(From);
    return llvm.cast(IntegerType.class, From.$deref());
  }

  public static IntegerType cast_or_null_IntegerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntegerType(From);
  }

  public static IntegerType dyn_cast_IntegerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static IntegerType dyn_cast_or_null_IntegerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntegerType(From) ? cast_IntegerType(From) : null;
  }

  public static boolean isa_IntrinsicInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntrinsicInst.class, From.$star());
  }

  public static IntrinsicInst cast_IntrinsicInst(type$ptr<?>/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return llvm.cast(IntrinsicInst.class, From.$star());
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(Value/*P*/ From) {
    assert From != null;
    return IntrinsicInst.classof(From);
  }

  public static IntrinsicInst cast_IntrinsicInst(Value/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return (IntrinsicInst) From;
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(Value/*P*/ From) {
    return (From == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(Value/*P*/ From) {
    assert From != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(Value/*P*/ From) {
    return (From != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(CallInst/*P*/ From) {
    assert From != null;
    return IntrinsicInst.classof(From);
  }

  public static IntrinsicInst cast_IntrinsicInst(CallInst/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return (IntrinsicInst) From;
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(CallInst/*P*/ From) {
    return (From != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntrinsicInst.class, From.$deref());
  }

  public static IntrinsicInst cast_IntrinsicInst(type$ref<?>/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return llvm.cast(IntrinsicInst.class, From.$deref());
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(Instruction/*P*/ From) {
    assert From != null;
    return IntrinsicInst.classof(From);
  }

  public static IntrinsicInst cast_IntrinsicInst(Instruction/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return llvm.cast(IntrinsicInst.class, From);
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(Instruction/*P*/ From) {
    return (From != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return true;
  }

  public static IntrinsicInst cast_IntrinsicInst(IntrinsicInst/*P*/ From) {
    assert isa_IntrinsicInst(From);
    return (IntrinsicInst) From;
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_IntrinsicInst(From);
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_IntrinsicInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_IntrinsicInst(From.get());
  }

  public static IntrinsicInst cast_IntrinsicInst(Use/*P*/ From) {
    return cast_IntrinsicInst(From.get());
  }

  public static IntrinsicInst cast_or_null_IntrinsicInst(Use/*P*/ From) {
    return cast_or_null_IntrinsicInst(From.get());
  }

  public static IntrinsicInst dyn_cast_IntrinsicInst(Use/*P*/ From) {
    return isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static IntrinsicInst dyn_cast_or_null_IntrinsicInst(Use/*P*/ From) {
    return (From != null) && isa_IntrinsicInst(From) ? cast_IntrinsicInst(From) : null;
  }

  public static boolean isa_InvokeInst(Instruction/*P*/ From) {
    assert From != null;
    return InvokeInst.classof(From);
  }

  public static InvokeInst cast_InvokeInst(Instruction/*P*/ From) {
    assert isa_InvokeInst(From);
    return llvm.cast(InvokeInst.class, From);
  }

  public static InvokeInst cast_or_null_InvokeInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_InvokeInst(From);
  }

  public static InvokeInst dyn_cast_InvokeInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static InvokeInst dyn_cast_or_null_InvokeInst(Instruction/*P*/ From) {
    return (From != null) && isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static boolean isa_InvokeInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InvokeInst.class, From.$deref());
  }

  public static InvokeInst cast_InvokeInst(type$ref<?>/*P*/ From) {
    assert isa_InvokeInst(From);
    return llvm.cast(InvokeInst.class, From.$deref());
  }

  public static InvokeInst cast_or_null_InvokeInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InvokeInst(From);
  }

  public static InvokeInst dyn_cast_InvokeInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static InvokeInst dyn_cast_or_null_InvokeInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static boolean isa_InvokeInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InvokeInst.class, From.$star());
  }

  public static InvokeInst cast_InvokeInst(type$ptr<?>/*P*/ From) {
    assert isa_InvokeInst(From);
    return llvm.cast(InvokeInst.class, From.$star());
  }

  public static InvokeInst cast_or_null_InvokeInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InvokeInst(From);
  }

  public static InvokeInst dyn_cast_InvokeInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static InvokeInst dyn_cast_or_null_InvokeInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static boolean isa_InvokeInst(Value/*P*/ From) {
    assert From != null;
    return InvokeInst.classof(From);
  }

  public static InvokeInst cast_InvokeInst(Value/*P*/ From) {
    assert isa_InvokeInst(From);
    return (InvokeInst) From;
  }

  public static InvokeInst cast_or_null_InvokeInst(Value/*P*/ From) {
    return (From == null) ? null : cast_InvokeInst(From);
  }

  public static InvokeInst dyn_cast_InvokeInst(Value/*P*/ From) {
    assert From != null;
    return isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static InvokeInst dyn_cast_or_null_InvokeInst(Value/*P*/ From) {
    return (From != null) && isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static boolean isa_InvokeInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InvokeInst(From.get());
  }

  public static InvokeInst cast_InvokeInst(Use/*P*/ From) {
    return cast_InvokeInst(From.get());
  }

  public static InvokeInst cast_or_null_InvokeInst(Use/*P*/ From) {
    return cast_or_null_InvokeInst(From.get());
  }

  public static InvokeInst dyn_cast_InvokeInst(Use/*P*/ From) {
    return isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static InvokeInst dyn_cast_or_null_InvokeInst(Use/*P*/ From) {
    return (From != null) && isa_InvokeInst(From) ? cast_InvokeInst(From) : null;
  }

  public static boolean isa_LShrOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LShrOperator.class, From.$deref());
  }

  public static LShrOperator cast_LShrOperator(type$ref<?>/*P*/ From) {
    assert isa_LShrOperator(From);
    return llvm.cast(LShrOperator.class, From.$deref());
  }

  public static LShrOperator cast_or_null_LShrOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LShrOperator(From);
  }

  public static LShrOperator dyn_cast_LShrOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LShrOperator(Instruction/*P*/ From) {
    assert From != null;
    return LShrOperator.classof(From);
  }

  public static LShrOperator cast_LShrOperator(Instruction/*P*/ From) {
    assert isa_LShrOperator(From);
    return llvm.cast(LShrOperator.class, From);
  }

  public static LShrOperator cast_or_null_LShrOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_LShrOperator(From);
  }

  public static LShrOperator dyn_cast_LShrOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(Instruction/*P*/ From) {
    return (From != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LShrOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_LShrOperator(From.get());
  }

  public static LShrOperator cast_LShrOperator(Use/*P*/ From) {
    return cast_LShrOperator(From.get());
  }

  public static LShrOperator cast_or_null_LShrOperator(Use/*P*/ From) {
    return cast_or_null_LShrOperator(From.get());
  }

  public static LShrOperator dyn_cast_LShrOperator(Use/*P*/ From) {
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(Use/*P*/ From) {
    return (From != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LShrOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LShrOperator.class, From.$star());
  }

  public static LShrOperator cast_LShrOperator(type$ptr<?>/*P*/ From) {
    assert isa_LShrOperator(From);
    return llvm.cast(LShrOperator.class, From.$star());
  }

  public static LShrOperator cast_or_null_LShrOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LShrOperator(From);
  }

  public static LShrOperator dyn_cast_LShrOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LShrOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return LShrOperator.classof(From);
  }

  public static LShrOperator cast_LShrOperator(ConstantExpr/*P*/ From) {
    assert isa_LShrOperator(From);
    return llvm.cast(LShrOperator.class, From);
  }

  public static LShrOperator cast_or_null_LShrOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_LShrOperator(From);
  }

  public static LShrOperator dyn_cast_LShrOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LShrOperator(Value/*P*/ From) {
    assert From != null;
    return LShrOperator.classof(From);
  }

  public static LShrOperator cast_LShrOperator(Value/*P*/ From) {
    assert isa_LShrOperator(From);
    return llvm.cast(LShrOperator.class, From);
  }

  public static LShrOperator cast_or_null_LShrOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_LShrOperator(From);
  }

  public static LShrOperator dyn_cast_LShrOperator(Value/*P*/ From) {
    assert From != null;
    return isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static LShrOperator dyn_cast_or_null_LShrOperator(Value/*P*/ From) {
    return (From != null) && isa_LShrOperator(From) ? cast_LShrOperator(From) : null;
  }

  public static boolean isa_LandingPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LandingPadInst.class, From.$star());
  }

  public static LandingPadInst cast_LandingPadInst(type$ptr<?>/*P*/ From) {
    assert isa_LandingPadInst(From);
    return llvm.cast(LandingPadInst.class, From.$star());
  }

  public static LandingPadInst cast_or_null_LandingPadInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LandingPadInst(From);
  }

  public static LandingPadInst dyn_cast_LandingPadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static LandingPadInst dyn_cast_or_null_LandingPadInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static boolean isa_LandingPadInst(Instruction/*P*/ From) {
    assert From != null;
    return LandingPadInst.classof(From);
  }

  public static LandingPadInst cast_LandingPadInst(Instruction/*P*/ From) {
    assert isa_LandingPadInst(From);
    return llvm.cast(LandingPadInst.class, From);
  }

  public static LandingPadInst cast_or_null_LandingPadInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_LandingPadInst(From);
  }

  public static LandingPadInst dyn_cast_LandingPadInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static LandingPadInst dyn_cast_or_null_LandingPadInst(Instruction/*P*/ From) {
    return (From != null) && isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static boolean isa_LandingPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LandingPadInst.class, From.$deref());
  }

  public static LandingPadInst cast_LandingPadInst(type$ref<?>/*P*/ From) {
    assert isa_LandingPadInst(From);
    return llvm.cast(LandingPadInst.class, From.$deref());
  }

  public static LandingPadInst cast_or_null_LandingPadInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LandingPadInst(From);
  }

  public static LandingPadInst dyn_cast_LandingPadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static LandingPadInst dyn_cast_or_null_LandingPadInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static boolean isa_LandingPadInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_LandingPadInst(From.get());
  }

  public static LandingPadInst cast_LandingPadInst(Use/*P*/ From) {
    return cast_LandingPadInst(From.get());
  }

  public static LandingPadInst cast_or_null_LandingPadInst(Use/*P*/ From) {
    return cast_or_null_LandingPadInst(From.get());
  }

  public static LandingPadInst dyn_cast_LandingPadInst(Use/*P*/ From) {
    return isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static LandingPadInst dyn_cast_or_null_LandingPadInst(Use/*P*/ From) {
    return (From != null) && isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static boolean isa_LandingPadInst(Value/*P*/ From) {
    assert From != null;
    return LandingPadInst.classof(From);
  }

  public static LandingPadInst cast_LandingPadInst(Value/*P*/ From) {
    assert isa_LandingPadInst(From);
    return (LandingPadInst) From;
  }

  public static LandingPadInst cast_or_null_LandingPadInst(Value/*P*/ From) {
    return (From == null) ? null : cast_LandingPadInst(From);
  }

  public static LandingPadInst dyn_cast_LandingPadInst(Value/*P*/ From) {
    assert From != null;
    return isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static LandingPadInst dyn_cast_or_null_LandingPadInst(Value/*P*/ From) {
    return (From != null) && isa_LandingPadInst(From) ? cast_LandingPadInst(From) : null;
  }

  public static boolean isa_LoadInst(Value/*P*/ From) {
    assert From != null;
    return LoadInst.classof(From);
  }

  public static LoadInst cast_LoadInst(Value/*P*/ From) {
    assert isa_LoadInst(From);
    return (LoadInst) From;
  }

  public static LoadInst cast_or_null_LoadInst(Value/*P*/ From) {
    return (From == null) ? null : cast_LoadInst(From);
  }

  public static LoadInst dyn_cast_LoadInst(Value/*P*/ From) {
    assert From != null;
    return isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static LoadInst dyn_cast_or_null_LoadInst(Value/*P*/ From) {
    return (From != null) && isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static boolean isa_LoadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LoadInst.class, From.$deref());
  }

  public static LoadInst cast_LoadInst(type$ref<?>/*P*/ From) {
    assert isa_LoadInst(From);
    return llvm.cast(LoadInst.class, From.$deref());
  }

  public static LoadInst cast_or_null_LoadInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LoadInst(From);
  }

  public static LoadInst dyn_cast_LoadInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static LoadInst dyn_cast_or_null_LoadInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static boolean isa_LoadInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_LoadInst(From.get());
  }

  public static LoadInst cast_LoadInst(Use/*P*/ From) {
    return cast_LoadInst(From.get());
  }

  public static LoadInst cast_or_null_LoadInst(Use/*P*/ From) {
    return cast_or_null_LoadInst(From.get());
  }

  public static LoadInst dyn_cast_LoadInst(Use/*P*/ From) {
    return isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static LoadInst dyn_cast_or_null_LoadInst(Use/*P*/ From) {
    return (From != null) && isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static boolean isa_LoadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LoadInst.class, From.$star());
  }

  public static LoadInst cast_LoadInst(type$ptr<?>/*P*/ From) {
    assert isa_LoadInst(From);
    return llvm.cast(LoadInst.class, From.$star());
  }

  public static LoadInst cast_or_null_LoadInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LoadInst(From);
  }

  public static LoadInst dyn_cast_LoadInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static LoadInst dyn_cast_or_null_LoadInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static boolean isa_LoadInst(Instruction/*P*/ From) {
    assert From != null;
    return LoadInst.classof(From);
  }

  public static LoadInst cast_LoadInst(Instruction/*P*/ From) {
    assert isa_LoadInst(From);
    return llvm.cast(LoadInst.class, From);
  }

  public static LoadInst cast_or_null_LoadInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_LoadInst(From);
  }

  public static LoadInst dyn_cast_LoadInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static LoadInst dyn_cast_or_null_LoadInst(Instruction/*P*/ From) {
    return (From != null) && isa_LoadInst(From) ? cast_LoadInst(From) : null;
  }

  public static boolean isa_LocalAsMetadata(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_LocalAsMetadata(From.get());
  }

  public static LocalAsMetadata cast_LocalAsMetadata(MDOperand/*P*/ From) {
    return cast_LocalAsMetadata(From.get());
  }

  public static LocalAsMetadata cast_or_null_LocalAsMetadata(MDOperand/*P*/ From) {
    return cast_or_null_LocalAsMetadata(From.get());
  }

  public static LocalAsMetadata dyn_cast_LocalAsMetadata(MDOperand/*P*/ From) {
    return isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static LocalAsMetadata dyn_cast_or_null_LocalAsMetadata(MDOperand/*P*/ From) {
    return (From != null) && isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static boolean isa_LocalAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return LocalAsMetadata.classof(From);
  }

  public static LocalAsMetadata cast_LocalAsMetadata(Metadata/*P*/ From) {
    assert isa_LocalAsMetadata(From);
    return (LocalAsMetadata) From;
  }

  public static LocalAsMetadata cast_or_null_LocalAsMetadata(Metadata/*P*/ From) {
    return (From == null) ? null : cast_LocalAsMetadata(From);
  }

  public static LocalAsMetadata dyn_cast_LocalAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static LocalAsMetadata dyn_cast_or_null_LocalAsMetadata(Metadata/*P*/ From) {
    return (From != null) && isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static boolean isa_LocalAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LocalAsMetadata.class, From.$star());
  }

  public static LocalAsMetadata cast_LocalAsMetadata(type$ptr<?>/*P*/ From) {
    assert isa_LocalAsMetadata(From);
    return llvm.cast(LocalAsMetadata.class, From.$star());
  }

  public static LocalAsMetadata cast_or_null_LocalAsMetadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LocalAsMetadata(From);
  }

  public static LocalAsMetadata dyn_cast_LocalAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static LocalAsMetadata dyn_cast_or_null_LocalAsMetadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static boolean isa_LocalAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LocalAsMetadata.class, From.$deref());
  }

  public static LocalAsMetadata cast_LocalAsMetadata(type$ref<?>/*P*/ From) {
    assert isa_LocalAsMetadata(From);
    return llvm.cast(LocalAsMetadata.class, From.$deref());
  }

  public static LocalAsMetadata cast_or_null_LocalAsMetadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LocalAsMetadata(From);
  }

  public static LocalAsMetadata dyn_cast_LocalAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static LocalAsMetadata dyn_cast_or_null_LocalAsMetadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LocalAsMetadata(From) ? cast_LocalAsMetadata(From) : null;
  }

  public static boolean isa_MDNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MDNode.class, From.$star());
  }

  public static MDNode cast_MDNode(type$ptr<?>/*P*/ From) {
    assert isa_MDNode(From);
    return llvm.cast(MDNode.class, From.$star());
  }

  public static MDNode cast_or_null_MDNode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MDNode(From);
  }

  public static MDNode dyn_cast_MDNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode dyn_cast_or_null_MDNode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static boolean isa_MDNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MDNode.class, From.$deref());
  }

  public static MDNode cast_MDNode(type$ref<?>/*P*/ From) {
    assert isa_MDNode(From);
    return llvm.cast(MDNode.class, From.$deref());
  }

  public static MDNode cast_or_null_MDNode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MDNode(From);
  }

  public static MDNode dyn_cast_MDNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode dyn_cast_or_null_MDNode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static boolean isa_MDNode(Metadata/*P*/ From) {
    assert From != null;
    return MDNode.classof(From);
  }

  public static MDNode cast_MDNode(Metadata/*P*/ From) {
    assert isa_MDNode(From);
    return (MDNode) From;
  }

  public static MDNode cast_or_null_MDNode(Metadata/*P*/ From) {
    return (From == null) ? null : cast_MDNode(From);
  }

  public static MDNode dyn_cast_MDNode(Metadata/*P*/ From) {
    assert From != null;
    return isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode dyn_cast_or_null_MDNode(Metadata/*P*/ From) {
    return (From != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static boolean isa_MDNode(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MDNode(From.get());
  }

  public static MDNode cast_MDNode(MDOperand/*P*/ From) {
    return cast_MDNode(From.get());
  }

  public static MDNode cast_or_null_MDNode(MDOperand/*P*/ From) {
    return cast_or_null_MDNode(From.get());
  }

  public static MDNode dyn_cast_MDNode(MDOperand/*P*/ From) {
    return isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode dyn_cast_or_null_MDNode(MDOperand/*P*/ From) {
    return (From != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static boolean isa_MDString(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MDString(From.get());
  }

  public static MDString cast_MDString(MDOperand/*P*/ From) {
    return cast_MDString(From.get());
  }

  public static MDString cast_or_null_MDString(MDOperand/*P*/ From) {
    return cast_or_null_MDString(From.get());
  }

  public static MDString dyn_cast_MDString(MDOperand/*P*/ From) {
    return isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static MDString dyn_cast_or_null_MDString(MDOperand/*P*/ From) {
    return (From != null) && isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static boolean isa_MDString(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MDString.class, From.$deref());
  }

  public static MDString cast_MDString(type$ref<?>/*P*/ From) {
    assert isa_MDString(From);
    return llvm.cast(MDString.class, From.$deref());
  }

  public static MDString cast_or_null_MDString(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MDString(From);
  }

  public static MDString dyn_cast_MDString(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static MDString dyn_cast_or_null_MDString(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static boolean isa_MDString(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MDString.class, From.$star());
  }

  public static MDString cast_MDString(type$ptr<?>/*P*/ From) {
    assert isa_MDString(From);
    return llvm.cast(MDString.class, From.$star());
  }

  public static MDString cast_or_null_MDString(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MDString(From);
  }

  public static MDString dyn_cast_MDString(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static MDString dyn_cast_or_null_MDString(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static boolean isa_MDString(Metadata/*P*/ From) {
    assert From != null;
    return MDString.classof(From);
  }

  public static MDString cast_MDString(Metadata/*P*/ From) {
    assert isa_MDString(From);
    return (MDString) From;
  }

  public static MDString cast_or_null_MDString(Metadata/*P*/ From) {
    return (From == null) ? null : cast_MDString(From);
  }

  public static MDString dyn_cast_MDString(Metadata/*P*/ From) {
    assert From != null;
    return isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static MDString dyn_cast_or_null_MDString(Metadata/*P*/ From) {
    return (From != null) && isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static boolean isa_MDTuple(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MDTuple.class, From.$deref());
  }

  public static MDTuple cast_MDTuple(type$ref<?>/*P*/ From) {
    assert isa_MDTuple(From);
    return llvm.cast(MDTuple.class, From.$deref());
  }

  public static MDTuple cast_or_null_MDTuple(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MDTuple(From);
  }

  public static MDTuple dyn_cast_MDTuple(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static MDTuple dyn_cast_or_null_MDTuple(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static boolean isa_MDTuple(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MDTuple(From.get());
  }

  public static MDTuple cast_MDTuple(MDOperand/*P*/ From) {
    return cast_MDTuple(From.get());
  }

  public static MDTuple cast_or_null_MDTuple(MDOperand/*P*/ From) {
    return cast_or_null_MDTuple(From.get());
  }

  public static MDTuple dyn_cast_MDTuple(MDOperand/*P*/ From) {
    return isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static MDTuple dyn_cast_or_null_MDTuple(MDOperand/*P*/ From) {
    return (From != null) && isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static boolean isa_MDTuple(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MDTuple.class, From.$star());
  }

  public static MDTuple cast_MDTuple(type$ptr<?>/*P*/ From) {
    assert isa_MDTuple(From);
    return llvm.cast(MDTuple.class, From.$star());
  }

  public static MDTuple cast_or_null_MDTuple(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MDTuple(From);
  }

  public static MDTuple dyn_cast_MDTuple(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static MDTuple dyn_cast_or_null_MDTuple(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static boolean isa_MDTuple(Metadata/*P*/ From) {
    assert From != null;
    return MDTuple.classof(From);
  }

  public static MDTuple cast_MDTuple(Metadata/*P*/ From) {
    assert isa_MDTuple(From);
    return (MDTuple) From;
  }

  public static MDTuple cast_or_null_MDTuple(Metadata/*P*/ From) {
    return (From == null) ? null : cast_MDTuple(From);
  }

  public static MDTuple dyn_cast_MDTuple(Metadata/*P*/ From) {
    assert From != null;
    return isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static MDTuple dyn_cast_or_null_MDTuple(Metadata/*P*/ From) {
    return (From != null) && isa_MDTuple(From) ? cast_MDTuple(From) : null;
  }

  public static boolean isa_MemCpyInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return MemCpyInst.classof(From);
  }

  public static MemCpyInst cast_MemCpyInst(IntrinsicInst/*P*/ From) {
    assert isa_MemCpyInst(From);
    return (MemCpyInst) From;
  }

  public static MemCpyInst cast_or_null_MemCpyInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(CallInst/*P*/ From) {
    assert From != null;
    return MemCpyInst.classof(From);
  }

  public static MemCpyInst cast_MemCpyInst(CallInst/*P*/ From) {
    assert isa_MemCpyInst(From);
    return (MemCpyInst) From;
  }

  public static MemCpyInst cast_or_null_MemCpyInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(CallInst/*P*/ From) {
    return (From != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(Instruction/*P*/ From) {
    assert From != null;
    return MemCpyInst.classof(From);
  }

  public static MemCpyInst cast_MemCpyInst(Instruction/*P*/ From) {
    assert isa_MemCpyInst(From);
    return llvm.cast(MemCpyInst.class, From);
  }

  public static MemCpyInst cast_or_null_MemCpyInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(Instruction/*P*/ From) {
    return (From != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MemCpyInst(From.get());
  }

  public static MemCpyInst cast_MemCpyInst(Use/*P*/ From) {
    return cast_MemCpyInst(From.get());
  }

  public static MemCpyInst cast_or_null_MemCpyInst(Use/*P*/ From) {
    return cast_or_null_MemCpyInst(From.get());
  }

  public static MemCpyInst dyn_cast_MemCpyInst(Use/*P*/ From) {
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(Use/*P*/ From) {
    return (From != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(Value/*P*/ From) {
    assert From != null;
    return MemCpyInst.classof(From);
  }

  public static MemCpyInst cast_MemCpyInst(Value/*P*/ From) {
    assert isa_MemCpyInst(From);
    return (MemCpyInst) From;
  }

  public static MemCpyInst cast_or_null_MemCpyInst(Value/*P*/ From) {
    return (From == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(Value/*P*/ From) {
    assert From != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(Value/*P*/ From) {
    return (From != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemCpyInst.class, From.$star());
  }

  public static MemCpyInst cast_MemCpyInst(type$ptr<?>/*P*/ From) {
    assert isa_MemCpyInst(From);
    return llvm.cast(MemCpyInst.class, From.$star());
  }

  public static MemCpyInst cast_or_null_MemCpyInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemCpyInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemCpyInst.class, From.$deref());
  }

  public static MemCpyInst cast_MemCpyInst(type$ref<?>/*P*/ From) {
    assert isa_MemCpyInst(From);
    return llvm.cast(MemCpyInst.class, From.$deref());
  }

  public static MemCpyInst cast_or_null_MemCpyInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemCpyInst(From);
  }

  public static MemCpyInst dyn_cast_MemCpyInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static MemCpyInst dyn_cast_or_null_MemCpyInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemCpyInst(From) ? cast_MemCpyInst(From) : null;
  }

  public static boolean isa_MemIntrinsic(CallInst/*P*/ From) {
    assert From != null;
    return MemIntrinsic.classof(From);
  }

  public static MemIntrinsic cast_MemIntrinsic(CallInst/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return (MemIntrinsic) From;
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(CallInst/*P*/ From) {
    return (From == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(CallInst/*P*/ From) {
    assert From != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(CallInst/*P*/ From) {
    return (From != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(Value/*P*/ From) {
    assert From != null;
    return MemIntrinsic.classof(From);
  }

  public static MemIntrinsic cast_MemIntrinsic(Value/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return (MemIntrinsic) From;
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(Value/*P*/ From) {
    return (From == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(Value/*P*/ From) {
    assert From != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(Value/*P*/ From) {
    return (From != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(Instruction/*P*/ From) {
    assert From != null;
    return MemIntrinsic.classof(From);
  }

  public static MemIntrinsic cast_MemIntrinsic(Instruction/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return llvm.cast(MemIntrinsic.class, From);
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(Instruction/*P*/ From) {
    assert From != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(Instruction/*P*/ From) {
    return (From != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(IntrinsicInst/*P*/ From) {
    assert From != null;
    return MemIntrinsic.classof(From);
  }

  public static MemIntrinsic cast_MemIntrinsic(IntrinsicInst/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return (MemIntrinsic) From;
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemIntrinsic.class, From.$star());
  }

  public static MemIntrinsic cast_MemIntrinsic(type$ptr<?>/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return llvm.cast(MemIntrinsic.class, From.$star());
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MemIntrinsic(From.get());
  }

  public static MemIntrinsic cast_MemIntrinsic(Use/*P*/ From) {
    return cast_MemIntrinsic(From.get());
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(Use/*P*/ From) {
    return cast_or_null_MemIntrinsic(From.get());
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(Use/*P*/ From) {
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(Use/*P*/ From) {
    return (From != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemIntrinsic(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemIntrinsic.class, From.$deref());
  }

  public static MemIntrinsic cast_MemIntrinsic(type$ref<?>/*P*/ From) {
    assert isa_MemIntrinsic(From);
    return llvm.cast(MemIntrinsic.class, From.$deref());
  }

  public static MemIntrinsic cast_or_null_MemIntrinsic(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemIntrinsic(From);
  }

  public static MemIntrinsic dyn_cast_MemIntrinsic(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static MemIntrinsic dyn_cast_or_null_MemIntrinsic(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemIntrinsic(From) ? cast_MemIntrinsic(From) : null;
  }

  public static boolean isa_MemMoveInst(CallInst/*P*/ From) {
    assert From != null;
    return MemMoveInst.classof(From);
  }

  public static MemMoveInst cast_MemMoveInst(CallInst/*P*/ From) {
    assert isa_MemMoveInst(From);
    return (MemMoveInst) From;
  }

  public static MemMoveInst cast_or_null_MemMoveInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(CallInst/*P*/ From) {
    return (From != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(Value/*P*/ From) {
    assert From != null;
    return MemMoveInst.classof(From);
  }

  public static MemMoveInst cast_MemMoveInst(Value/*P*/ From) {
    assert isa_MemMoveInst(From);
    return (MemMoveInst) From;
  }

  public static MemMoveInst cast_or_null_MemMoveInst(Value/*P*/ From) {
    return (From == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(Value/*P*/ From) {
    assert From != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(Value/*P*/ From) {
    return (From != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MemMoveInst(From.get());
  }

  public static MemMoveInst cast_MemMoveInst(Use/*P*/ From) {
    return cast_MemMoveInst(From.get());
  }

  public static MemMoveInst cast_or_null_MemMoveInst(Use/*P*/ From) {
    return cast_or_null_MemMoveInst(From.get());
  }

  public static MemMoveInst dyn_cast_MemMoveInst(Use/*P*/ From) {
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(Use/*P*/ From) {
    return (From != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemMoveInst.class, From.$deref());
  }

  public static MemMoveInst cast_MemMoveInst(type$ref<?>/*P*/ From) {
    assert isa_MemMoveInst(From);
    return llvm.cast(MemMoveInst.class, From.$deref());
  }

  public static MemMoveInst cast_or_null_MemMoveInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return MemMoveInst.classof(From);
  }

  public static MemMoveInst cast_MemMoveInst(IntrinsicInst/*P*/ From) {
    assert isa_MemMoveInst(From);
    return (MemMoveInst) From;
  }

  public static MemMoveInst cast_or_null_MemMoveInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemMoveInst.class, From.$star());
  }

  public static MemMoveInst cast_MemMoveInst(type$ptr<?>/*P*/ From) {
    assert isa_MemMoveInst(From);
    return llvm.cast(MemMoveInst.class, From.$star());
  }

  public static MemMoveInst cast_or_null_MemMoveInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemMoveInst(Instruction/*P*/ From) {
    assert From != null;
    return MemMoveInst.classof(From);
  }

  public static MemMoveInst cast_MemMoveInst(Instruction/*P*/ From) {
    assert isa_MemMoveInst(From);
    return llvm.cast(MemMoveInst.class, From);
  }

  public static MemMoveInst cast_or_null_MemMoveInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MemMoveInst(From);
  }

  public static MemMoveInst dyn_cast_MemMoveInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static MemMoveInst dyn_cast_or_null_MemMoveInst(Instruction/*P*/ From) {
    return (From != null) && isa_MemMoveInst(From) ? cast_MemMoveInst(From) : null;
  }

  public static boolean isa_MemSetInst(Value/*P*/ From) {
    assert From != null;
    return MemSetInst.classof(From);
  }

  public static MemSetInst cast_MemSetInst(Value/*P*/ From) {
    assert isa_MemSetInst(From);
    return (MemSetInst) From;
  }

  public static MemSetInst cast_or_null_MemSetInst(Value/*P*/ From) {
    return (From == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(Value/*P*/ From) {
    assert From != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(Value/*P*/ From) {
    return (From != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MemSetInst(From.get());
  }

  public static MemSetInst cast_MemSetInst(Use/*P*/ From) {
    return cast_MemSetInst(From.get());
  }

  public static MemSetInst cast_or_null_MemSetInst(Use/*P*/ From) {
    return cast_or_null_MemSetInst(From.get());
  }

  public static MemSetInst dyn_cast_MemSetInst(Use/*P*/ From) {
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(Use/*P*/ From) {
    return (From != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemSetInst.class, From.$deref());
  }

  public static MemSetInst cast_MemSetInst(type$ref<?>/*P*/ From) {
    assert isa_MemSetInst(From);
    return llvm.cast(MemSetInst.class, From.$deref());
  }

  public static MemSetInst cast_or_null_MemSetInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return MemSetInst.classof(From);
  }

  public static MemSetInst cast_MemSetInst(IntrinsicInst/*P*/ From) {
    assert isa_MemSetInst(From);
    return (MemSetInst) From;
  }

  public static MemSetInst cast_or_null_MemSetInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemSetInst.class, From.$star());
  }

  public static MemSetInst cast_MemSetInst(type$ptr<?>/*P*/ From) {
    assert isa_MemSetInst(From);
    return llvm.cast(MemSetInst.class, From.$star());
  }

  public static MemSetInst cast_or_null_MemSetInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(CallInst/*P*/ From) {
    assert From != null;
    return MemSetInst.classof(From);
  }

  public static MemSetInst cast_MemSetInst(CallInst/*P*/ From) {
    assert isa_MemSetInst(From);
    return (MemSetInst) From;
  }

  public static MemSetInst cast_or_null_MemSetInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(CallInst/*P*/ From) {
    return (From != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemSetInst(Instruction/*P*/ From) {
    assert From != null;
    return MemSetInst.classof(From);
  }

  public static MemSetInst cast_MemSetInst(Instruction/*P*/ From) {
    assert isa_MemSetInst(From);
    return llvm.cast(MemSetInst.class, From);
  }

  public static MemSetInst cast_or_null_MemSetInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MemSetInst(From);
  }

  public static MemSetInst dyn_cast_MemSetInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static MemSetInst dyn_cast_or_null_MemSetInst(Instruction/*P*/ From) {
    return (From != null) && isa_MemSetInst(From) ? cast_MemSetInst(From) : null;
  }

  public static boolean isa_MemTransferInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MemTransferInst(From.get());
  }

  public static MemTransferInst cast_MemTransferInst(Use/*P*/ From) {
    return cast_MemTransferInst(From.get());
  }

  public static MemTransferInst cast_or_null_MemTransferInst(Use/*P*/ From) {
    return cast_or_null_MemTransferInst(From.get());
  }

  public static MemTransferInst dyn_cast_MemTransferInst(Use/*P*/ From) {
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(Use/*P*/ From) {
    return (From != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(Value/*P*/ From) {
    assert From != null;
    return MemTransferInst.classof(From);
  }

  public static MemTransferInst cast_MemTransferInst(Value/*P*/ From) {
    assert isa_MemTransferInst(From);
    return (MemTransferInst) From;
  }

  public static MemTransferInst cast_or_null_MemTransferInst(Value/*P*/ From) {
    return (From == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(Value/*P*/ From) {
    assert From != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(Value/*P*/ From) {
    return (From != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return MemTransferInst.classof(From);
  }

  public static MemTransferInst cast_MemTransferInst(IntrinsicInst/*P*/ From) {
    assert isa_MemTransferInst(From);
    return (MemTransferInst) From;
  }

  public static MemTransferInst cast_or_null_MemTransferInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MemTransferInst.class, From.$deref());
  }

  public static MemTransferInst cast_MemTransferInst(type$ref<?>/*P*/ From) {
    assert isa_MemTransferInst(From);
    return llvm.cast(MemTransferInst.class, From.$deref());
  }

  public static MemTransferInst cast_or_null_MemTransferInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MemTransferInst.class, From.$star());
  }

  public static MemTransferInst cast_MemTransferInst(type$ptr<?>/*P*/ From) {
    assert isa_MemTransferInst(From);
    return llvm.cast(MemTransferInst.class, From.$star());
  }

  public static MemTransferInst cast_or_null_MemTransferInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(Instruction/*P*/ From) {
    assert From != null;
    return MemTransferInst.classof(From);
  }

  public static MemTransferInst cast_MemTransferInst(Instruction/*P*/ From) {
    assert isa_MemTransferInst(From);
    return llvm.cast(MemTransferInst.class, From);
  }

  public static MemTransferInst cast_or_null_MemTransferInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(Instruction/*P*/ From) {
    return (From != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_MemTransferInst(CallInst/*P*/ From) {
    assert From != null;
    return MemTransferInst.classof(From);
  }

  public static MemTransferInst cast_MemTransferInst(CallInst/*P*/ From) {
    assert isa_MemTransferInst(From);
    return (MemTransferInst) From;
  }

  public static MemTransferInst cast_or_null_MemTransferInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_MemTransferInst(From);
  }

  public static MemTransferInst dyn_cast_MemTransferInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static MemTransferInst dyn_cast_or_null_MemTransferInst(CallInst/*P*/ From) {
    return (From != null) && isa_MemTransferInst(From) ? cast_MemTransferInst(From) : null;
  }

  public static boolean isa_Metadata(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Metadata(From.get());
  }

  public static Metadata cast_Metadata(MDOperand/*P*/ From) {
    return cast_Metadata(From.get());
  }

  public static Metadata cast_or_null_Metadata(MDOperand/*P*/ From) {
    return cast_or_null_Metadata(From.get());
  }

  public static Metadata dyn_cast_Metadata(MDOperand/*P*/ From) {
    return isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static Metadata dyn_cast_or_null_Metadata(MDOperand/*P*/ From) {
    return (From != null) && isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static boolean isa_Metadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Metadata.class, From.$deref());
  }

  public static Metadata cast_Metadata(type$ref<?>/*P*/ From) {
    assert isa_Metadata(From);
    return llvm.cast(Metadata.class, From.$deref());
  }

  public static Metadata cast_or_null_Metadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Metadata(From);
  }

  public static Metadata dyn_cast_Metadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static Metadata dyn_cast_or_null_Metadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static boolean isa_Metadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Metadata.class, From.$star());
  }

  public static Metadata cast_Metadata(type$ptr<?>/*P*/ From) {
    assert isa_Metadata(From);
    return llvm.cast(Metadata.class, From.$star());
  }

  public static Metadata cast_or_null_Metadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Metadata(From);
  }

  public static Metadata dyn_cast_Metadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static Metadata dyn_cast_or_null_Metadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static boolean isa_Metadata(Metadata/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Metadata cast_Metadata(Metadata/*P*/ From) {
    assert isa_Metadata(From);
    return (Metadata) From;
  }

  public static Metadata cast_or_null_Metadata(Metadata/*P*/ From) {
    return (From == null) ? null : cast_Metadata(From);
  }

  public static Metadata dyn_cast_Metadata(Metadata/*P*/ From) {
    assert From != null;
    return isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static Metadata dyn_cast_or_null_Metadata(Metadata/*P*/ From) {
    return (From != null) && isa_Metadata(From) ? cast_Metadata(From) : null;
  }

  public static boolean isa_MetadataAsValue(Value/*P*/ From) {
    assert From != null;
    return MetadataAsValue.classof(From);
  }

  public static MetadataAsValue cast_MetadataAsValue(Value/*P*/ From) {
    assert isa_MetadataAsValue(From);
    return (MetadataAsValue) From;
  }

  public static MetadataAsValue cast_or_null_MetadataAsValue(Value/*P*/ From) {
    return (From == null) ? null : cast_MetadataAsValue(From);
  }

  public static MetadataAsValue dyn_cast_MetadataAsValue(Value/*P*/ From) {
    assert From != null;
    return isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static MetadataAsValue dyn_cast_or_null_MetadataAsValue(Value/*P*/ From) {
    return (From != null) && isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static boolean isa_MetadataAsValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MetadataAsValue.class, From.$star());
  }

  public static MetadataAsValue cast_MetadataAsValue(type$ptr<?>/*P*/ From) {
    assert isa_MetadataAsValue(From);
    return llvm.cast(MetadataAsValue.class, From.$star());
  }

  public static MetadataAsValue cast_or_null_MetadataAsValue(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MetadataAsValue(From);
  }

  public static MetadataAsValue dyn_cast_MetadataAsValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static MetadataAsValue dyn_cast_or_null_MetadataAsValue(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static boolean isa_MetadataAsValue(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MetadataAsValue(From.get());
  }

  public static MetadataAsValue cast_MetadataAsValue(Use/*P*/ From) {
    return cast_MetadataAsValue(From.get());
  }

  public static MetadataAsValue cast_or_null_MetadataAsValue(Use/*P*/ From) {
    return cast_or_null_MetadataAsValue(From.get());
  }

  public static MetadataAsValue dyn_cast_MetadataAsValue(Use/*P*/ From) {
    return isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static MetadataAsValue dyn_cast_or_null_MetadataAsValue(Use/*P*/ From) {
    return (From != null) && isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static boolean isa_MetadataAsValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MetadataAsValue.class, From.$deref());
  }

  public static MetadataAsValue cast_MetadataAsValue(type$ref<?>/*P*/ From) {
    assert isa_MetadataAsValue(From);
    return llvm.cast(MetadataAsValue.class, From.$deref());
  }

  public static MetadataAsValue cast_or_null_MetadataAsValue(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MetadataAsValue(From);
  }

  public static MetadataAsValue dyn_cast_MetadataAsValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static MetadataAsValue dyn_cast_or_null_MetadataAsValue(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MetadataAsValue(From) ? cast_MetadataAsValue(From) : null;
  }

  public static boolean isa_MulOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MulOperator.class, From.$star());
  }

  public static MulOperator cast_MulOperator(type$ptr<?>/*P*/ From) {
    assert isa_MulOperator(From);
    return llvm.cast(MulOperator.class, From.$star());
  }

  public static MulOperator cast_or_null_MulOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MulOperator(From);
  }

  public static MulOperator dyn_cast_MulOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_MulOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_MulOperator(From.get());
  }

  public static MulOperator cast_MulOperator(Use/*P*/ From) {
    return cast_MulOperator(From.get());
  }

  public static MulOperator cast_or_null_MulOperator(Use/*P*/ From) {
    return cast_or_null_MulOperator(From.get());
  }

  public static MulOperator dyn_cast_MulOperator(Use/*P*/ From) {
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(Use/*P*/ From) {
    return (From != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_MulOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MulOperator.class, From.$deref());
  }

  public static MulOperator cast_MulOperator(type$ref<?>/*P*/ From) {
    assert isa_MulOperator(From);
    return llvm.cast(MulOperator.class, From.$deref());
  }

  public static MulOperator cast_or_null_MulOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MulOperator(From);
  }

  public static MulOperator dyn_cast_MulOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_MulOperator(Value/*P*/ From) {
    assert From != null;
    return MulOperator.classof(From);
  }

  public static MulOperator cast_MulOperator(Value/*P*/ From) {
    assert isa_MulOperator(From);
    return llvm.cast(MulOperator.class, From);
  }

  public static MulOperator cast_or_null_MulOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_MulOperator(From);
  }

  public static MulOperator dyn_cast_MulOperator(Value/*P*/ From) {
    assert From != null;
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(Value/*P*/ From) {
    return (From != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_MulOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return MulOperator.classof(From);
  }

  public static MulOperator cast_MulOperator(ConstantExpr/*P*/ From) {
    assert isa_MulOperator(From);
    return llvm.cast(MulOperator.class, From);
  }

  public static MulOperator cast_or_null_MulOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_MulOperator(From);
  }

  public static MulOperator dyn_cast_MulOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_MulOperator(Instruction/*P*/ From) {
    assert From != null;
    return MulOperator.classof(From);
  }

  public static MulOperator cast_MulOperator(Instruction/*P*/ From) {
    assert isa_MulOperator(From);
    return llvm.cast(MulOperator.class, From);
  }

  public static MulOperator cast_or_null_MulOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_MulOperator(From);
  }

  public static MulOperator dyn_cast_MulOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static MulOperator dyn_cast_or_null_MulOperator(Instruction/*P*/ From) {
    return (From != null) && isa_MulOperator(From) ? cast_MulOperator(From) : null;
  }

  public static boolean isa_Operator(Instruction/*P*/ From) {
    assert From != null;
    return Operator.classof(From);
  }

  public static Operator cast_Operator(Instruction/*P*/ From) {
    assert isa_Operator(From);
    return llvm.cast(Operator.class, From);
  }

  public static Operator cast_or_null_Operator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_Operator(From);
  }

  public static Operator dyn_cast_Operator(Instruction/*P*/ From) {
    assert From != null;
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(Instruction/*P*/ From) {
    return (From != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_Operator(ConstantExpr/*P*/ From) {
    assert From != null;
    return Operator.classof(From);
  }

  public static Operator cast_Operator(ConstantExpr/*P*/ From) {
    assert isa_Operator(From);
    return llvm.cast(Operator.class, From);
  }

  public static Operator cast_or_null_Operator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_Operator(From);
  }

  public static Operator dyn_cast_Operator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_Operator(Value/*P*/ From) {
    assert From != null;
    return Operator.classof(From);
  }

  public static Operator cast_Operator(Value/*P*/ From) {
    assert isa_Operator(From);
    return (Operator) From;
  }

  public static Operator cast_or_null_Operator(Value/*P*/ From) {
    return (From == null) ? null : cast_Operator(From);
  }

  public static Operator dyn_cast_Operator(Value/*P*/ From) {
    assert From != null;
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(Value/*P*/ From) {
    return (From != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_Operator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Operator(From.get());
  }

  public static Operator cast_Operator(Use/*P*/ From) {
    return cast_Operator(From.get());
  }

  public static Operator cast_or_null_Operator(Use/*P*/ From) {
    return cast_or_null_Operator(From.get());
  }

  public static Operator dyn_cast_Operator(Use/*P*/ From) {
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(Use/*P*/ From) {
    return (From != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_Operator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Operator.class, From.$deref());
  }

  public static Operator cast_Operator(type$ref<?>/*P*/ From) {
    assert isa_Operator(From);
    return llvm.cast(Operator.class, From.$deref());
  }

  public static Operator cast_or_null_Operator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Operator(From);
  }

  public static Operator dyn_cast_Operator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_Operator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Operator.class, From.$star());
  }

  public static Operator cast_Operator(type$ptr<?>/*P*/ From) {
    assert isa_Operator(From);
    return llvm.cast(Operator.class, From.$star());
  }

  public static Operator cast_or_null_Operator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Operator(From);
  }

  public static Operator dyn_cast_Operator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static Operator dyn_cast_or_null_Operator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Operator(From) ? cast_Operator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_OverflowingBinaryOperator(From.get());
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(Use/*P*/ From) {
    return cast_OverflowingBinaryOperator(From.get());
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(Use/*P*/ From) {
    return cast_or_null_OverflowingBinaryOperator(From.get());
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(Use/*P*/ From) {
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(Use/*P*/ From) {
    return (From != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return OverflowingBinaryOperator.classof(From);
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(ConstantExpr/*P*/ From) {
    assert isa_OverflowingBinaryOperator(From);
    return llvm.cast(OverflowingBinaryOperator.class, From);
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_OverflowingBinaryOperator(From);
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(Value/*P*/ From) {
    assert From != null;
    return OverflowingBinaryOperator.classof(From);
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(Value/*P*/ From) {
    assert isa_OverflowingBinaryOperator(From);
    return (OverflowingBinaryOperator) From;
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_OverflowingBinaryOperator(From);
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(Value/*P*/ From) {
    assert From != null;
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(Value/*P*/ From) {
    return (From != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OverflowingBinaryOperator.class, From.$star());
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(type$ptr<?>/*P*/ From) {
    assert isa_OverflowingBinaryOperator(From);
    return llvm.cast(OverflowingBinaryOperator.class, From.$star());
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OverflowingBinaryOperator(From);
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OverflowingBinaryOperator.class, From.$deref());
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(type$ref<?>/*P*/ From) {
    assert isa_OverflowingBinaryOperator(From);
    return llvm.cast(OverflowingBinaryOperator.class, From.$deref());
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OverflowingBinaryOperator(From);
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_OverflowingBinaryOperator(Instruction/*P*/ From) {
    assert From != null;
    return OverflowingBinaryOperator.classof(From);
  }

  public static OverflowingBinaryOperator cast_OverflowingBinaryOperator(Instruction/*P*/ From) {
    assert isa_OverflowingBinaryOperator(From);
    return llvm.cast(OverflowingBinaryOperator.class, From);
  }

  public static OverflowingBinaryOperator cast_or_null_OverflowingBinaryOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_OverflowingBinaryOperator(From);
  }

  public static OverflowingBinaryOperator dyn_cast_OverflowingBinaryOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static OverflowingBinaryOperator dyn_cast_or_null_OverflowingBinaryOperator(Instruction/*P*/ From) {
    return (From != null) && isa_OverflowingBinaryOperator(From) ? cast_OverflowingBinaryOperator(From) : null;
  }

  public static boolean isa_PHINode(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_PHINode(From.get());
  }

  public static PHINode cast_PHINode(Use/*P*/ From) {
    return cast_PHINode(From.get());
  }

  public static PHINode cast_or_null_PHINode(Use/*P*/ From) {
    return cast_or_null_PHINode(From.get());
  }

  public static PHINode dyn_cast_PHINode(Use/*P*/ From) {
    return isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static PHINode dyn_cast_or_null_PHINode(Use/*P*/ From) {
    return (From != null) && isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static boolean isa_PHINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PHINode.class, From.$deref());
  }

  public static PHINode cast_PHINode(type$ref<?>/*P*/ From) {
    assert isa_PHINode(From);
    return llvm.cast(PHINode.class, From.$deref());
  }

  public static PHINode cast_or_null_PHINode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PHINode(From);
  }

  public static PHINode dyn_cast_PHINode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static PHINode dyn_cast_or_null_PHINode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static boolean isa_PHINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PHINode.class, From.$star());
  }

  public static PHINode cast_PHINode(type$ptr<?>/*P*/ From) {
    assert isa_PHINode(From);
    return llvm.cast(PHINode.class, From.$star());
  }

  public static PHINode cast_or_null_PHINode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PHINode(From);
  }

  public static PHINode dyn_cast_PHINode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static PHINode dyn_cast_or_null_PHINode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static boolean isa_PHINode(Value/*P*/ From) {
    assert From != null;
    return PHINode.classof(From);
  }

  public static PHINode cast_PHINode(Value/*P*/ From) {
    assert isa_PHINode(From);
    return (PHINode) From;
  }

  public static PHINode cast_or_null_PHINode(Value/*P*/ From) {
    return (From == null) ? null : cast_PHINode(From);
  }

  public static PHINode dyn_cast_PHINode(Value/*P*/ From) {
    assert From != null;
    return isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static PHINode dyn_cast_or_null_PHINode(Value/*P*/ From) {
    return (From != null) && isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static boolean isa_PHINode(Instruction/*P*/ From) {
    assert From != null;
    return PHINode.classof(From);
  }

  public static PHINode cast_PHINode(Instruction/*P*/ From) {
    assert isa_PHINode(From);
    return llvm.cast(PHINode.class, From);
  }

  public static PHINode cast_or_null_PHINode(Instruction/*P*/ From) {
    return (From == null) ? null : cast_PHINode(From);
  }

  public static PHINode dyn_cast_PHINode(Instruction/*P*/ From) {
    assert From != null;
    return isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static PHINode dyn_cast_or_null_PHINode(Instruction/*P*/ From) {
    return (From != null) && isa_PHINode(From) ? cast_PHINode(From) : null;
  }

  public static boolean isa_PointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PointerType.class, From.$deref());
  }

  public static PointerType cast_PointerType(type$ref<?>/*P*/ From) {
    assert isa_PointerType(From);
    return llvm.cast(PointerType.class, From.$deref());
  }

  public static PointerType cast_or_null_PointerType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PointerType.class, From.$star());
  }

  public static PointerType cast_PointerType(type$ptr<?>/*P*/ From) {
    assert isa_PointerType(From);
    return llvm.cast(PointerType.class, From.$star());
  }

  public static PointerType cast_or_null_PointerType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PointerType(Type/*P*/ From) {
    assert From != null;
    return PointerType.classof(From);
  }

  public static PointerType cast_PointerType(Type/*P*/ From) {
    assert isa_PointerType(From);
    return (PointerType) From;
  }

  public static PointerType cast_or_null_PointerType(Type/*P*/ From) {
    return (From == null) ? null : cast_PointerType(From);
  }

  public static PointerType dyn_cast_PointerType(Type/*P*/ From) {
    assert From != null;
    return isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static PointerType dyn_cast_or_null_PointerType(Type/*P*/ From) {
    return (From != null) && isa_PointerType(From) ? cast_PointerType(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return PossiblyExactOperator.classof(From);
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(ConstantExpr/*P*/ From) {
    assert isa_PossiblyExactOperator(From);
    return llvm.cast(PossiblyExactOperator.class, From);
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_PossiblyExactOperator(From);
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(Value/*P*/ From) {
    assert From != null;
    return PossiblyExactOperator.classof(From);
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(Value/*P*/ From) {
    assert isa_PossiblyExactOperator(From);
    return (PossiblyExactOperator) From;
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_PossiblyExactOperator(From);
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(Value/*P*/ From) {
    assert From != null;
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(Value/*P*/ From) {
    return (From != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_PossiblyExactOperator(From.get());
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(Use/*P*/ From) {
    return cast_PossiblyExactOperator(From.get());
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(Use/*P*/ From) {
    return cast_or_null_PossiblyExactOperator(From.get());
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(Use/*P*/ From) {
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(Use/*P*/ From) {
    return (From != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PossiblyExactOperator.class, From.$deref());
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(type$ref<?>/*P*/ From) {
    assert isa_PossiblyExactOperator(From);
    return llvm.cast(PossiblyExactOperator.class, From.$deref());
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PossiblyExactOperator(From);
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(Instruction/*P*/ From) {
    assert From != null;
    return PossiblyExactOperator.classof(From);
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(Instruction/*P*/ From) {
    assert isa_PossiblyExactOperator(From);
    return llvm.cast(PossiblyExactOperator.class, From);
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_PossiblyExactOperator(From);
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(Instruction/*P*/ From) {
    return (From != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PossiblyExactOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PossiblyExactOperator.class, From.$star());
  }

  public static PossiblyExactOperator cast_PossiblyExactOperator(type$ptr<?>/*P*/ From) {
    assert isa_PossiblyExactOperator(From);
    return llvm.cast(PossiblyExactOperator.class, From.$star());
  }

  public static PossiblyExactOperator cast_or_null_PossiblyExactOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PossiblyExactOperator(From);
  }

  public static PossiblyExactOperator dyn_cast_PossiblyExactOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static PossiblyExactOperator dyn_cast_or_null_PossiblyExactOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PossiblyExactOperator(From) ? cast_PossiblyExactOperator(From) : null;
  }

  public static boolean isa_PtrToIntInst(Instruction/*P*/ From) {
    assert From != null;
    return PtrToIntInst.classof(From);
  }

  public static PtrToIntInst cast_PtrToIntInst(Instruction/*P*/ From) {
    assert isa_PtrToIntInst(From);
    return llvm.cast(PtrToIntInst.class, From);
  }

  public static PtrToIntInst cast_or_null_PtrToIntInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_PtrToIntInst(From);
  }

  public static PtrToIntInst dyn_cast_PtrToIntInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static PtrToIntInst dyn_cast_or_null_PtrToIntInst(Instruction/*P*/ From) {
    return (From != null) && isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static boolean isa_PtrToIntInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PtrToIntInst.class, From.$deref());
  }

  public static PtrToIntInst cast_PtrToIntInst(type$ref<?>/*P*/ From) {
    assert isa_PtrToIntInst(From);
    return llvm.cast(PtrToIntInst.class, From.$deref());
  }

  public static PtrToIntInst cast_or_null_PtrToIntInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PtrToIntInst(From);
  }

  public static PtrToIntInst dyn_cast_PtrToIntInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static PtrToIntInst dyn_cast_or_null_PtrToIntInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static boolean isa_PtrToIntInst(Value/*P*/ From) {
    assert From != null;
    return PtrToIntInst.classof(From);
  }

  public static PtrToIntInst cast_PtrToIntInst(Value/*P*/ From) {
    assert isa_PtrToIntInst(From);
    return (PtrToIntInst) From;
  }

  public static PtrToIntInst cast_or_null_PtrToIntInst(Value/*P*/ From) {
    return (From == null) ? null : cast_PtrToIntInst(From);
  }

  public static PtrToIntInst dyn_cast_PtrToIntInst(Value/*P*/ From) {
    assert From != null;
    return isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static PtrToIntInst dyn_cast_or_null_PtrToIntInst(Value/*P*/ From) {
    return (From != null) && isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static boolean isa_PtrToIntInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_PtrToIntInst(From.get());
  }

  public static PtrToIntInst cast_PtrToIntInst(Use/*P*/ From) {
    return cast_PtrToIntInst(From.get());
  }

  public static PtrToIntInst cast_or_null_PtrToIntInst(Use/*P*/ From) {
    return cast_or_null_PtrToIntInst(From.get());
  }

  public static PtrToIntInst dyn_cast_PtrToIntInst(Use/*P*/ From) {
    return isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static PtrToIntInst dyn_cast_or_null_PtrToIntInst(Use/*P*/ From) {
    return (From != null) && isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static boolean isa_PtrToIntInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PtrToIntInst.class, From.$star());
  }

  public static PtrToIntInst cast_PtrToIntInst(type$ptr<?>/*P*/ From) {
    assert isa_PtrToIntInst(From);
    return llvm.cast(PtrToIntInst.class, From.$star());
  }

  public static PtrToIntInst cast_or_null_PtrToIntInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PtrToIntInst(From);
  }

  public static PtrToIntInst dyn_cast_PtrToIntInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static PtrToIntInst dyn_cast_or_null_PtrToIntInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PtrToIntInst(From) ? cast_PtrToIntInst(From) : null;
  }

  public static boolean isa_PtrToIntOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return PtrToIntOperator.classof(From);
  }

  public static PtrToIntOperator cast_PtrToIntOperator(ConstantExpr/*P*/ From) {
    assert isa_PtrToIntOperator(From);
    return llvm.cast(PtrToIntOperator.class, From);
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_PtrToIntOperator(From);
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_PtrToIntOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PtrToIntOperator.class, From.$star());
  }

  public static PtrToIntOperator cast_PtrToIntOperator(type$ptr<?>/*P*/ From) {
    assert isa_PtrToIntOperator(From);
    return llvm.cast(PtrToIntOperator.class, From.$star());
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PtrToIntOperator(From);
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_PtrToIntOperator(Instruction/*P*/ From) {
    assert From != null;
    return PtrToIntOperator.classof(From);
  }

  public static PtrToIntOperator cast_PtrToIntOperator(Instruction/*P*/ From) {
    assert isa_PtrToIntOperator(From);
    return llvm.cast(PtrToIntOperator.class, From);
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_PtrToIntOperator(From);
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(Instruction/*P*/ From) {
    return (From != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_PtrToIntOperator(Value/*P*/ From) {
    assert From != null;
    return PtrToIntOperator.classof(From);
  }

  public static PtrToIntOperator cast_PtrToIntOperator(Value/*P*/ From) {
    assert isa_PtrToIntOperator(From);
    return llvm.cast(PtrToIntOperator.class, From);
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_PtrToIntOperator(From);
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(Value/*P*/ From) {
    assert From != null;
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(Value/*P*/ From) {
    return (From != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_PtrToIntOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_PtrToIntOperator(From.get());
  }

  public static PtrToIntOperator cast_PtrToIntOperator(Use/*P*/ From) {
    return cast_PtrToIntOperator(From.get());
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(Use/*P*/ From) {
    return cast_or_null_PtrToIntOperator(From.get());
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(Use/*P*/ From) {
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(Use/*P*/ From) {
    return (From != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_PtrToIntOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PtrToIntOperator.class, From.$deref());
  }

  public static PtrToIntOperator cast_PtrToIntOperator(type$ref<?>/*P*/ From) {
    assert isa_PtrToIntOperator(From);
    return llvm.cast(PtrToIntOperator.class, From.$deref());
  }

  public static PtrToIntOperator cast_or_null_PtrToIntOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PtrToIntOperator(From);
  }

  public static PtrToIntOperator dyn_cast_PtrToIntOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static PtrToIntOperator dyn_cast_or_null_PtrToIntOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PtrToIntOperator(From) ? cast_PtrToIntOperator(From) : null;
  }

  public static boolean isa_ResumeInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ResumeInst.class, From.$deref());
  }

  public static ResumeInst cast_ResumeInst(type$ref<?>/*P*/ From) {
    assert isa_ResumeInst(From);
    return llvm.cast(ResumeInst.class, From.$deref());
  }

  public static ResumeInst cast_or_null_ResumeInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ResumeInst(From);
  }

  public static ResumeInst dyn_cast_ResumeInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static ResumeInst dyn_cast_or_null_ResumeInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static boolean isa_ResumeInst(Instruction/*P*/ From) {
    assert From != null;
    return ResumeInst.classof(From);
  }

  public static ResumeInst cast_ResumeInst(Instruction/*P*/ From) {
    assert isa_ResumeInst(From);
    return llvm.cast(ResumeInst.class, From);
  }

  public static ResumeInst cast_or_null_ResumeInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ResumeInst(From);
  }

  public static ResumeInst dyn_cast_ResumeInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static ResumeInst dyn_cast_or_null_ResumeInst(Instruction/*P*/ From) {
    return (From != null) && isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static boolean isa_ResumeInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ResumeInst(From.get());
  }

  public static ResumeInst cast_ResumeInst(Use/*P*/ From) {
    return cast_ResumeInst(From.get());
  }

  public static ResumeInst cast_or_null_ResumeInst(Use/*P*/ From) {
    return cast_or_null_ResumeInst(From.get());
  }

  public static ResumeInst dyn_cast_ResumeInst(Use/*P*/ From) {
    return isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static ResumeInst dyn_cast_or_null_ResumeInst(Use/*P*/ From) {
    return (From != null) && isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static boolean isa_ResumeInst(Value/*P*/ From) {
    assert From != null;
    return ResumeInst.classof(From);
  }

  public static ResumeInst cast_ResumeInst(Value/*P*/ From) {
    assert isa_ResumeInst(From);
    return (ResumeInst) From;
  }

  public static ResumeInst cast_or_null_ResumeInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ResumeInst(From);
  }

  public static ResumeInst dyn_cast_ResumeInst(Value/*P*/ From) {
    assert From != null;
    return isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static ResumeInst dyn_cast_or_null_ResumeInst(Value/*P*/ From) {
    return (From != null) && isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static boolean isa_ResumeInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ResumeInst.class, From.$star());
  }

  public static ResumeInst cast_ResumeInst(type$ptr<?>/*P*/ From) {
    assert isa_ResumeInst(From);
    return llvm.cast(ResumeInst.class, From.$star());
  }

  public static ResumeInst cast_or_null_ResumeInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ResumeInst(From);
  }

  public static ResumeInst dyn_cast_ResumeInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static ResumeInst dyn_cast_or_null_ResumeInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ResumeInst(From) ? cast_ResumeInst(From) : null;
  }

  public static boolean isa_ReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return ReturnInst.classof(From);
  }

  public static ReturnInst cast_ReturnInst(Instruction/*P*/ From) {
    assert isa_ReturnInst(From);
    return llvm.cast(ReturnInst.class, From);
  }

  public static ReturnInst cast_or_null_ReturnInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ReturnInst(From);
  }

  public static ReturnInst dyn_cast_ReturnInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static ReturnInst dyn_cast_or_null_ReturnInst(Instruction/*P*/ From) {
    return (From != null) && isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static boolean isa_ReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReturnInst.class, From.$star());
  }

  public static ReturnInst cast_ReturnInst(type$ptr<?>/*P*/ From) {
    assert isa_ReturnInst(From);
    return llvm.cast(ReturnInst.class, From.$star());
  }

  public static ReturnInst cast_or_null_ReturnInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReturnInst(From);
  }

  public static ReturnInst dyn_cast_ReturnInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static ReturnInst dyn_cast_or_null_ReturnInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static boolean isa_ReturnInst(Value/*P*/ From) {
    assert From != null;
    return ReturnInst.classof(From);
  }

  public static ReturnInst cast_ReturnInst(Value/*P*/ From) {
    assert isa_ReturnInst(From);
    return (ReturnInst) From;
  }

  public static ReturnInst cast_or_null_ReturnInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ReturnInst(From);
  }

  public static ReturnInst dyn_cast_ReturnInst(Value/*P*/ From) {
    assert From != null;
    return isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static ReturnInst dyn_cast_or_null_ReturnInst(Value/*P*/ From) {
    return (From != null) && isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static boolean isa_ReturnInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ReturnInst(From.get());
  }

  public static ReturnInst cast_ReturnInst(Use/*P*/ From) {
    return cast_ReturnInst(From.get());
  }

  public static ReturnInst cast_or_null_ReturnInst(Use/*P*/ From) {
    return cast_or_null_ReturnInst(From.get());
  }

  public static ReturnInst dyn_cast_ReturnInst(Use/*P*/ From) {
    return isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static ReturnInst dyn_cast_or_null_ReturnInst(Use/*P*/ From) {
    return (From != null) && isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static boolean isa_ReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReturnInst.class, From.$deref());
  }

  public static ReturnInst cast_ReturnInst(type$ref<?>/*P*/ From) {
    assert isa_ReturnInst(From);
    return llvm.cast(ReturnInst.class, From.$deref());
  }

  public static ReturnInst cast_or_null_ReturnInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReturnInst(From);
  }

  public static ReturnInst dyn_cast_ReturnInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static ReturnInst dyn_cast_or_null_ReturnInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReturnInst(From) ? cast_ReturnInst(From) : null;
  }

  public static boolean isa_SDivOperator(Instruction/*P*/ From) {
    assert From != null;
    return SDivOperator.classof(From);
  }

  public static SDivOperator cast_SDivOperator(Instruction/*P*/ From) {
    assert isa_SDivOperator(From);
    return llvm.cast(SDivOperator.class, From);
  }

  public static SDivOperator cast_or_null_SDivOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SDivOperator(From);
  }

  public static SDivOperator dyn_cast_SDivOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(Instruction/*P*/ From) {
    return (From != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SDivOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SDivOperator(From.get());
  }

  public static SDivOperator cast_SDivOperator(Use/*P*/ From) {
    return cast_SDivOperator(From.get());
  }

  public static SDivOperator cast_or_null_SDivOperator(Use/*P*/ From) {
    return cast_or_null_SDivOperator(From.get());
  }

  public static SDivOperator dyn_cast_SDivOperator(Use/*P*/ From) {
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(Use/*P*/ From) {
    return (From != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SDivOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SDivOperator.class, From.$deref());
  }

  public static SDivOperator cast_SDivOperator(type$ref<?>/*P*/ From) {
    assert isa_SDivOperator(From);
    return llvm.cast(SDivOperator.class, From.$deref());
  }

  public static SDivOperator cast_or_null_SDivOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SDivOperator(From);
  }

  public static SDivOperator dyn_cast_SDivOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SDivOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return SDivOperator.classof(From);
  }

  public static SDivOperator cast_SDivOperator(ConstantExpr/*P*/ From) {
    assert isa_SDivOperator(From);
    return llvm.cast(SDivOperator.class, From);
  }

  public static SDivOperator cast_or_null_SDivOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_SDivOperator(From);
  }

  public static SDivOperator dyn_cast_SDivOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SDivOperator(Value/*P*/ From) {
    assert From != null;
    return SDivOperator.classof(From);
  }

  public static SDivOperator cast_SDivOperator(Value/*P*/ From) {
    assert isa_SDivOperator(From);
    return llvm.cast(SDivOperator.class, From);
  }

  public static SDivOperator cast_or_null_SDivOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_SDivOperator(From);
  }

  public static SDivOperator dyn_cast_SDivOperator(Value/*P*/ From) {
    assert From != null;
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(Value/*P*/ From) {
    return (From != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SDivOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SDivOperator.class, From.$star());
  }

  public static SDivOperator cast_SDivOperator(type$ptr<?>/*P*/ From) {
    assert isa_SDivOperator(From);
    return llvm.cast(SDivOperator.class, From.$star());
  }

  public static SDivOperator cast_or_null_SDivOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SDivOperator(From);
  }

  public static SDivOperator dyn_cast_SDivOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static SDivOperator dyn_cast_or_null_SDivOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SDivOperator(From) ? cast_SDivOperator(From) : null;
  }

  public static boolean isa_SExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SExtInst.class, From.$star());
  }

  public static SExtInst cast_SExtInst(type$ptr<?>/*P*/ From) {
    assert isa_SExtInst(From);
    return llvm.cast(SExtInst.class, From.$star());
  }

  public static SExtInst cast_or_null_SExtInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SExtInst(From);
  }

  public static SExtInst dyn_cast_SExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static SExtInst dyn_cast_or_null_SExtInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static boolean isa_SExtInst(Instruction/*P*/ From) {
    assert From != null;
    return SExtInst.classof(From);
  }

  public static SExtInst cast_SExtInst(Instruction/*P*/ From) {
    assert isa_SExtInst(From);
    return llvm.cast(SExtInst.class, From);
  }

  public static SExtInst cast_or_null_SExtInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SExtInst(From);
  }

  public static SExtInst dyn_cast_SExtInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static SExtInst dyn_cast_or_null_SExtInst(Instruction/*P*/ From) {
    return (From != null) && isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static boolean isa_SExtInst(Value/*P*/ From) {
    assert From != null;
    return SExtInst.classof(From);
  }

  public static SExtInst cast_SExtInst(Value/*P*/ From) {
    assert isa_SExtInst(From);
    return (SExtInst) From;
  }

  public static SExtInst cast_or_null_SExtInst(Value/*P*/ From) {
    return (From == null) ? null : cast_SExtInst(From);
  }

  public static SExtInst dyn_cast_SExtInst(Value/*P*/ From) {
    assert From != null;
    return isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static SExtInst dyn_cast_or_null_SExtInst(Value/*P*/ From) {
    return (From != null) && isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static boolean isa_SExtInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SExtInst(From.get());
  }

  public static SExtInst cast_SExtInst(Use/*P*/ From) {
    return cast_SExtInst(From.get());
  }

  public static SExtInst cast_or_null_SExtInst(Use/*P*/ From) {
    return cast_or_null_SExtInst(From.get());
  }

  public static SExtInst dyn_cast_SExtInst(Use/*P*/ From) {
    return isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static SExtInst dyn_cast_or_null_SExtInst(Use/*P*/ From) {
    return (From != null) && isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static boolean isa_SExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SExtInst.class, From.$deref());
  }

  public static SExtInst cast_SExtInst(type$ref<?>/*P*/ From) {
    assert isa_SExtInst(From);
    return llvm.cast(SExtInst.class, From.$deref());
  }

  public static SExtInst cast_or_null_SExtInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SExtInst(From);
  }

  public static SExtInst dyn_cast_SExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static SExtInst dyn_cast_or_null_SExtInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SExtInst(From) ? cast_SExtInst(From) : null;
  }

  public static boolean isa_SIToFPInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SIToFPInst.class, From.$star());
  }

  public static SIToFPInst cast_SIToFPInst(type$ptr<?>/*P*/ From) {
    assert isa_SIToFPInst(From);
    return llvm.cast(SIToFPInst.class, From.$star());
  }

  public static SIToFPInst cast_or_null_SIToFPInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SIToFPInst(From);
  }

  public static SIToFPInst dyn_cast_SIToFPInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static SIToFPInst dyn_cast_or_null_SIToFPInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static boolean isa_SIToFPInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SIToFPInst(From.get());
  }

  public static SIToFPInst cast_SIToFPInst(Use/*P*/ From) {
    return cast_SIToFPInst(From.get());
  }

  public static SIToFPInst cast_or_null_SIToFPInst(Use/*P*/ From) {
    return cast_or_null_SIToFPInst(From.get());
  }

  public static SIToFPInst dyn_cast_SIToFPInst(Use/*P*/ From) {
    return isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static SIToFPInst dyn_cast_or_null_SIToFPInst(Use/*P*/ From) {
    return (From != null) && isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static boolean isa_SIToFPInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SIToFPInst.class, From.$deref());
  }

  public static SIToFPInst cast_SIToFPInst(type$ref<?>/*P*/ From) {
    assert isa_SIToFPInst(From);
    return llvm.cast(SIToFPInst.class, From.$deref());
  }

  public static SIToFPInst cast_or_null_SIToFPInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SIToFPInst(From);
  }

  public static SIToFPInst dyn_cast_SIToFPInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static SIToFPInst dyn_cast_or_null_SIToFPInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static boolean isa_SIToFPInst(Value/*P*/ From) {
    assert From != null;
    return SIToFPInst.classof(From);
  }

  public static SIToFPInst cast_SIToFPInst(Value/*P*/ From) {
    assert isa_SIToFPInst(From);
    return (SIToFPInst) From;
  }

  public static SIToFPInst cast_or_null_SIToFPInst(Value/*P*/ From) {
    return (From == null) ? null : cast_SIToFPInst(From);
  }

  public static SIToFPInst dyn_cast_SIToFPInst(Value/*P*/ From) {
    assert From != null;
    return isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static SIToFPInst dyn_cast_or_null_SIToFPInst(Value/*P*/ From) {
    return (From != null) && isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static boolean isa_SIToFPInst(Instruction/*P*/ From) {
    assert From != null;
    return SIToFPInst.classof(From);
  }

  public static SIToFPInst cast_SIToFPInst(Instruction/*P*/ From) {
    assert isa_SIToFPInst(From);
    return llvm.cast(SIToFPInst.class, From);
  }

  public static SIToFPInst cast_or_null_SIToFPInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SIToFPInst(From);
  }

  public static SIToFPInst dyn_cast_SIToFPInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static SIToFPInst dyn_cast_or_null_SIToFPInst(Instruction/*P*/ From) {
    return (From != null) && isa_SIToFPInst(From) ? cast_SIToFPInst(From) : null;
  }

  public static boolean isa_SelectInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SelectInst(From.get());
  }

  public static SelectInst cast_SelectInst(Use/*P*/ From) {
    return cast_SelectInst(From.get());
  }

  public static SelectInst cast_or_null_SelectInst(Use/*P*/ From) {
    return cast_or_null_SelectInst(From.get());
  }

  public static SelectInst dyn_cast_SelectInst(Use/*P*/ From) {
    return isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static SelectInst dyn_cast_or_null_SelectInst(Use/*P*/ From) {
    return (From != null) && isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static boolean isa_SelectInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SelectInst.class, From.$deref());
  }

  public static SelectInst cast_SelectInst(type$ref<?>/*P*/ From) {
    assert isa_SelectInst(From);
    return llvm.cast(SelectInst.class, From.$deref());
  }

  public static SelectInst cast_or_null_SelectInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SelectInst(From);
  }

  public static SelectInst dyn_cast_SelectInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static SelectInst dyn_cast_or_null_SelectInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static boolean isa_SelectInst(Value/*P*/ From) {
    assert From != null;
    return SelectInst.classof(From);
  }

  public static SelectInst cast_SelectInst(Value/*P*/ From) {
    assert isa_SelectInst(From);
    return (SelectInst) From;
  }

  public static SelectInst cast_or_null_SelectInst(Value/*P*/ From) {
    return (From == null) ? null : cast_SelectInst(From);
  }

  public static SelectInst dyn_cast_SelectInst(Value/*P*/ From) {
    assert From != null;
    return isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static SelectInst dyn_cast_or_null_SelectInst(Value/*P*/ From) {
    return (From != null) && isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static boolean isa_SelectInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SelectInst.class, From.$star());
  }

  public static SelectInst cast_SelectInst(type$ptr<?>/*P*/ From) {
    assert isa_SelectInst(From);
    return llvm.cast(SelectInst.class, From.$star());
  }

  public static SelectInst cast_or_null_SelectInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SelectInst(From);
  }

  public static SelectInst dyn_cast_SelectInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static SelectInst dyn_cast_or_null_SelectInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static boolean isa_SelectInst(Instruction/*P*/ From) {
    assert From != null;
    return SelectInst.classof(From);
  }

  public static SelectInst cast_SelectInst(Instruction/*P*/ From) {
    assert isa_SelectInst(From);
    return llvm.cast(SelectInst.class, From);
  }

  public static SelectInst cast_or_null_SelectInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SelectInst(From);
  }

  public static SelectInst dyn_cast_SelectInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static SelectInst dyn_cast_or_null_SelectInst(Instruction/*P*/ From) {
    return (From != null) && isa_SelectInst(From) ? cast_SelectInst(From) : null;
  }

  public static boolean isa_SequentialType(Type/*P*/ From) {
    assert From != null;
    return SequentialType.classof(From);
  }

  public static SequentialType cast_SequentialType(Type/*P*/ From) {
    assert isa_SequentialType(From);
    return (SequentialType) From;
  }

  public static SequentialType cast_or_null_SequentialType(Type/*P*/ From) {
    return (From == null) ? null : cast_SequentialType(From);
  }

  public static SequentialType dyn_cast_SequentialType(Type/*P*/ From) {
    assert From != null;
    return isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static SequentialType dyn_cast_or_null_SequentialType(Type/*P*/ From) {
    return (From != null) && isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static boolean isa_SequentialType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SequentialType.class, From.$star());
  }

  public static SequentialType cast_SequentialType(type$ptr<?>/*P*/ From) {
    assert isa_SequentialType(From);
    return llvm.cast(SequentialType.class, From.$star());
  }

  public static SequentialType cast_or_null_SequentialType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SequentialType(From);
  }

  public static SequentialType dyn_cast_SequentialType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static SequentialType dyn_cast_or_null_SequentialType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static boolean isa_SequentialType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SequentialType.class, From.$deref());
  }

  public static SequentialType cast_SequentialType(type$ref<?>/*P*/ From) {
    assert isa_SequentialType(From);
    return llvm.cast(SequentialType.class, From.$deref());
  }

  public static SequentialType cast_or_null_SequentialType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SequentialType(From);
  }

  public static SequentialType dyn_cast_SequentialType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static SequentialType dyn_cast_or_null_SequentialType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SequentialType(From) ? cast_SequentialType(From) : null;
  }

  public static boolean isa_ShlOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return ShlOperator.classof(From);
  }

  public static ShlOperator cast_ShlOperator(ConstantExpr/*P*/ From) {
    assert isa_ShlOperator(From);
    return llvm.cast(ShlOperator.class, From);
  }

  public static ShlOperator cast_or_null_ShlOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_ShlOperator(From);
  }

  public static ShlOperator dyn_cast_ShlOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShlOperator(Value/*P*/ From) {
    assert From != null;
    return ShlOperator.classof(From);
  }

  public static ShlOperator cast_ShlOperator(Value/*P*/ From) {
    assert isa_ShlOperator(From);
    return llvm.cast(ShlOperator.class, From);
  }

  public static ShlOperator cast_or_null_ShlOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_ShlOperator(From);
  }

  public static ShlOperator dyn_cast_ShlOperator(Value/*P*/ From) {
    assert From != null;
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(Value/*P*/ From) {
    return (From != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShlOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ShlOperator(From.get());
  }

  public static ShlOperator cast_ShlOperator(Use/*P*/ From) {
    return cast_ShlOperator(From.get());
  }

  public static ShlOperator cast_or_null_ShlOperator(Use/*P*/ From) {
    return cast_or_null_ShlOperator(From.get());
  }

  public static ShlOperator dyn_cast_ShlOperator(Use/*P*/ From) {
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(Use/*P*/ From) {
    return (From != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShlOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ShlOperator.class, From.$star());
  }

  public static ShlOperator cast_ShlOperator(type$ptr<?>/*P*/ From) {
    assert isa_ShlOperator(From);
    return llvm.cast(ShlOperator.class, From.$star());
  }

  public static ShlOperator cast_or_null_ShlOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ShlOperator(From);
  }

  public static ShlOperator dyn_cast_ShlOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShlOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ShlOperator.class, From.$deref());
  }

  public static ShlOperator cast_ShlOperator(type$ref<?>/*P*/ From) {
    assert isa_ShlOperator(From);
    return llvm.cast(ShlOperator.class, From.$deref());
  }

  public static ShlOperator cast_or_null_ShlOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ShlOperator(From);
  }

  public static ShlOperator dyn_cast_ShlOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShlOperator(Instruction/*P*/ From) {
    assert From != null;
    return ShlOperator.classof(From);
  }

  public static ShlOperator cast_ShlOperator(Instruction/*P*/ From) {
    assert isa_ShlOperator(From);
    return llvm.cast(ShlOperator.class, From);
  }

  public static ShlOperator cast_or_null_ShlOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ShlOperator(From);
  }

  public static ShlOperator dyn_cast_ShlOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static ShlOperator dyn_cast_or_null_ShlOperator(Instruction/*P*/ From) {
    return (From != null) && isa_ShlOperator(From) ? cast_ShlOperator(From) : null;
  }

  public static boolean isa_ShuffleVectorInst(Value/*P*/ From) {
    assert From != null;
    return ShuffleVectorInst.classof(From);
  }

  public static ShuffleVectorInst cast_ShuffleVectorInst(Value/*P*/ From) {
    assert isa_ShuffleVectorInst(From);
    return (ShuffleVectorInst) From;
  }

  public static ShuffleVectorInst cast_or_null_ShuffleVectorInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ShuffleVectorInst(From);
  }

  public static ShuffleVectorInst dyn_cast_ShuffleVectorInst(Value/*P*/ From) {
    assert From != null;
    return isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static ShuffleVectorInst dyn_cast_or_null_ShuffleVectorInst(Value/*P*/ From) {
    return (From != null) && isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static boolean isa_ShuffleVectorInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ShuffleVectorInst.class, From.$star());
  }

  public static ShuffleVectorInst cast_ShuffleVectorInst(type$ptr<?>/*P*/ From) {
    assert isa_ShuffleVectorInst(From);
    return llvm.cast(ShuffleVectorInst.class, From.$star());
  }

  public static ShuffleVectorInst cast_or_null_ShuffleVectorInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ShuffleVectorInst(From);
  }

  public static ShuffleVectorInst dyn_cast_ShuffleVectorInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static ShuffleVectorInst dyn_cast_or_null_ShuffleVectorInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static boolean isa_ShuffleVectorInst(Instruction/*P*/ From) {
    assert From != null;
    return ShuffleVectorInst.classof(From);
  }

  public static ShuffleVectorInst cast_ShuffleVectorInst(Instruction/*P*/ From) {
    assert isa_ShuffleVectorInst(From);
    return llvm.cast(ShuffleVectorInst.class, From);
  }

  public static ShuffleVectorInst cast_or_null_ShuffleVectorInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ShuffleVectorInst(From);
  }

  public static ShuffleVectorInst dyn_cast_ShuffleVectorInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static ShuffleVectorInst dyn_cast_or_null_ShuffleVectorInst(Instruction/*P*/ From) {
    return (From != null) && isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static boolean isa_ShuffleVectorInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ShuffleVectorInst(From.get());
  }

  public static ShuffleVectorInst cast_ShuffleVectorInst(Use/*P*/ From) {
    return cast_ShuffleVectorInst(From.get());
  }

  public static ShuffleVectorInst cast_or_null_ShuffleVectorInst(Use/*P*/ From) {
    return cast_or_null_ShuffleVectorInst(From.get());
  }

  public static ShuffleVectorInst dyn_cast_ShuffleVectorInst(Use/*P*/ From) {
    return isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static ShuffleVectorInst dyn_cast_or_null_ShuffleVectorInst(Use/*P*/ From) {
    return (From != null) && isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static boolean isa_ShuffleVectorInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ShuffleVectorInst.class, From.$deref());
  }

  public static ShuffleVectorInst cast_ShuffleVectorInst(type$ref<?>/*P*/ From) {
    assert isa_ShuffleVectorInst(From);
    return llvm.cast(ShuffleVectorInst.class, From.$deref());
  }

  public static ShuffleVectorInst cast_or_null_ShuffleVectorInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ShuffleVectorInst(From);
  }

  public static ShuffleVectorInst dyn_cast_ShuffleVectorInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static ShuffleVectorInst dyn_cast_or_null_ShuffleVectorInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ShuffleVectorInst(From) ? cast_ShuffleVectorInst(From) : null;
  }

  public static boolean isa_StoreInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_StoreInst(From.get());
  }

  public static StoreInst cast_StoreInst(Use/*P*/ From) {
    return cast_StoreInst(From.get());
  }

  public static StoreInst cast_or_null_StoreInst(Use/*P*/ From) {
    return cast_or_null_StoreInst(From.get());
  }

  public static StoreInst dyn_cast_StoreInst(Use/*P*/ From) {
    return isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static StoreInst dyn_cast_or_null_StoreInst(Use/*P*/ From) {
    return (From != null) && isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static boolean isa_StoreInst(Value/*P*/ From) {
    assert From != null;
    return StoreInst.classof(From);
  }

  public static StoreInst cast_StoreInst(Value/*P*/ From) {
    assert isa_StoreInst(From);
    return (StoreInst) From;
  }

  public static StoreInst cast_or_null_StoreInst(Value/*P*/ From) {
    return (From == null) ? null : cast_StoreInst(From);
  }

  public static StoreInst dyn_cast_StoreInst(Value/*P*/ From) {
    assert From != null;
    return isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static StoreInst dyn_cast_or_null_StoreInst(Value/*P*/ From) {
    return (From != null) && isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static boolean isa_StoreInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StoreInst.class, From.$deref());
  }

  public static StoreInst cast_StoreInst(type$ref<?>/*P*/ From) {
    assert isa_StoreInst(From);
    return llvm.cast(StoreInst.class, From.$deref());
  }

  public static StoreInst cast_or_null_StoreInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StoreInst(From);
  }

  public static StoreInst dyn_cast_StoreInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static StoreInst dyn_cast_or_null_StoreInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static boolean isa_StoreInst(Instruction/*P*/ From) {
    assert From != null;
    return StoreInst.classof(From);
  }

  public static StoreInst cast_StoreInst(Instruction/*P*/ From) {
    assert isa_StoreInst(From);
    return llvm.cast(StoreInst.class, From);
  }

  public static StoreInst cast_or_null_StoreInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_StoreInst(From);
  }

  public static StoreInst dyn_cast_StoreInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static StoreInst dyn_cast_or_null_StoreInst(Instruction/*P*/ From) {
    return (From != null) && isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static boolean isa_StoreInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StoreInst.class, From.$star());
  }

  public static StoreInst cast_StoreInst(type$ptr<?>/*P*/ From) {
    assert isa_StoreInst(From);
    return llvm.cast(StoreInst.class, From.$star());
  }

  public static StoreInst cast_or_null_StoreInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StoreInst(From);
  }

  public static StoreInst dyn_cast_StoreInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static StoreInst dyn_cast_or_null_StoreInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StoreInst(From) ? cast_StoreInst(From) : null;
  }

  public static boolean isa_StructType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StructType.class, From.$deref());
  }

  public static StructType cast_StructType(type$ref<?>/*P*/ From) {
    assert isa_StructType(From);
    return llvm.cast(StructType.class, From.$deref());
  }

  public static StructType cast_or_null_StructType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StructType(From);
  }

  public static StructType dyn_cast_StructType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static StructType dyn_cast_or_null_StructType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static boolean isa_StructType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StructType.class, From.$star());
  }

  public static StructType cast_StructType(type$ptr<?>/*P*/ From) {
    assert isa_StructType(From);
    return llvm.cast(StructType.class, From.$star());
  }

  public static StructType cast_or_null_StructType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StructType(From);
  }

  public static StructType dyn_cast_StructType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static StructType dyn_cast_or_null_StructType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static boolean isa_StructType(Type/*P*/ From) {
    assert From != null;
    return StructType.classof(From);
  }

  public static StructType cast_StructType(Type/*P*/ From) {
    assert isa_StructType(From);
    return (StructType) From;
  }

  public static StructType cast_or_null_StructType(Type/*P*/ From) {
    return (From == null) ? null : cast_StructType(From);
  }

  public static StructType dyn_cast_StructType(Type/*P*/ From) {
    assert From != null;
    return isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static StructType dyn_cast_or_null_StructType(Type/*P*/ From) {
    return (From != null) && isa_StructType(From) ? cast_StructType(From) : null;
  }

  public static boolean isa_SubOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return SubOperator.classof(From);
  }

  public static SubOperator cast_SubOperator(ConstantExpr/*P*/ From) {
    assert isa_SubOperator(From);
    return llvm.cast(SubOperator.class, From);
  }

  public static SubOperator cast_or_null_SubOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_SubOperator(From);
  }

  public static SubOperator dyn_cast_SubOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SubOperator(Value/*P*/ From) {
    assert From != null;
    return SubOperator.classof(From);
  }

  public static SubOperator cast_SubOperator(Value/*P*/ From) {
    assert isa_SubOperator(From);
    return llvm.cast(SubOperator.class, From);
  }

  public static SubOperator cast_or_null_SubOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_SubOperator(From);
  }

  public static SubOperator dyn_cast_SubOperator(Value/*P*/ From) {
    assert From != null;
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(Value/*P*/ From) {
    return (From != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SubOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SubOperator(From.get());
  }

  public static SubOperator cast_SubOperator(Use/*P*/ From) {
    return cast_SubOperator(From.get());
  }

  public static SubOperator cast_or_null_SubOperator(Use/*P*/ From) {
    return cast_or_null_SubOperator(From.get());
  }

  public static SubOperator dyn_cast_SubOperator(Use/*P*/ From) {
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(Use/*P*/ From) {
    return (From != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SubOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SubOperator.class, From.$deref());
  }

  public static SubOperator cast_SubOperator(type$ref<?>/*P*/ From) {
    assert isa_SubOperator(From);
    return llvm.cast(SubOperator.class, From.$deref());
  }

  public static SubOperator cast_or_null_SubOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SubOperator(From);
  }

  public static SubOperator dyn_cast_SubOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SubOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SubOperator.class, From.$star());
  }

  public static SubOperator cast_SubOperator(type$ptr<?>/*P*/ From) {
    assert isa_SubOperator(From);
    return llvm.cast(SubOperator.class, From.$star());
  }

  public static SubOperator cast_or_null_SubOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SubOperator(From);
  }

  public static SubOperator dyn_cast_SubOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SubOperator(Instruction/*P*/ From) {
    assert From != null;
    return SubOperator.classof(From);
  }

  public static SubOperator cast_SubOperator(Instruction/*P*/ From) {
    assert isa_SubOperator(From);
    return llvm.cast(SubOperator.class, From);
  }

  public static SubOperator cast_or_null_SubOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SubOperator(From);
  }

  public static SubOperator dyn_cast_SubOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static SubOperator dyn_cast_or_null_SubOperator(Instruction/*P*/ From) {
    return (From != null) && isa_SubOperator(From) ? cast_SubOperator(From) : null;
  }

  public static boolean isa_SwitchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwitchInst.class, From.$deref());
  }

  public static SwitchInst cast_SwitchInst(type$ref<?>/*P*/ From) {
    assert isa_SwitchInst(From);
    return llvm.cast(SwitchInst.class, From.$deref());
  }

  public static SwitchInst cast_or_null_SwitchInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwitchInst(From);
  }

  public static SwitchInst dyn_cast_SwitchInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static SwitchInst dyn_cast_or_null_SwitchInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static boolean isa_SwitchInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SwitchInst(From.get());
  }

  public static SwitchInst cast_SwitchInst(Use/*P*/ From) {
    return cast_SwitchInst(From.get());
  }

  public static SwitchInst cast_or_null_SwitchInst(Use/*P*/ From) {
    return cast_or_null_SwitchInst(From.get());
  }

  public static SwitchInst dyn_cast_SwitchInst(Use/*P*/ From) {
    return isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static SwitchInst dyn_cast_or_null_SwitchInst(Use/*P*/ From) {
    return (From != null) && isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static boolean isa_SwitchInst(Value/*P*/ From) {
    assert From != null;
    return SwitchInst.classof(From);
  }

  public static SwitchInst cast_SwitchInst(Value/*P*/ From) {
    assert isa_SwitchInst(From);
    return (SwitchInst) From;
  }

  public static SwitchInst cast_or_null_SwitchInst(Value/*P*/ From) {
    return (From == null) ? null : cast_SwitchInst(From);
  }

  public static SwitchInst dyn_cast_SwitchInst(Value/*P*/ From) {
    assert From != null;
    return isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static SwitchInst dyn_cast_or_null_SwitchInst(Value/*P*/ From) {
    return (From != null) && isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static boolean isa_SwitchInst(Instruction/*P*/ From) {
    assert From != null;
    return SwitchInst.classof(From);
  }

  public static SwitchInst cast_SwitchInst(Instruction/*P*/ From) {
    assert isa_SwitchInst(From);
    return llvm.cast(SwitchInst.class, From);
  }

  public static SwitchInst cast_or_null_SwitchInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_SwitchInst(From);
  }

  public static SwitchInst dyn_cast_SwitchInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static SwitchInst dyn_cast_or_null_SwitchInst(Instruction/*P*/ From) {
    return (From != null) && isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static boolean isa_SwitchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwitchInst.class, From.$star());
  }

  public static SwitchInst cast_SwitchInst(type$ptr<?>/*P*/ From) {
    assert isa_SwitchInst(From);
    return llvm.cast(SwitchInst.class, From.$star());
  }

  public static SwitchInst cast_or_null_SwitchInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwitchInst(From);
  }

  public static SwitchInst dyn_cast_SwitchInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static SwitchInst dyn_cast_or_null_SwitchInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwitchInst(From) ? cast_SwitchInst(From) : null;
  }

  public static boolean isa_TerminatorInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TerminatorInst.class, From.$star());
  }

  public static TerminatorInst cast_TerminatorInst(type$ptr<?>/*P*/ From) {
    assert isa_TerminatorInst(From);
    return llvm.cast(TerminatorInst.class, From.$star());
  }

  public static TerminatorInst cast_or_null_TerminatorInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TerminatorInst(From);
  }

  public static TerminatorInst dyn_cast_TerminatorInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static TerminatorInst dyn_cast_or_null_TerminatorInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static boolean isa_TerminatorInst(Value/*P*/ From) {
    assert From != null;
    return TerminatorInst.classof(From);
  }

  public static TerminatorInst cast_TerminatorInst(Value/*P*/ From) {
    assert isa_TerminatorInst(From);
    return (TerminatorInst) From;
  }

  public static TerminatorInst cast_or_null_TerminatorInst(Value/*P*/ From) {
    return (From == null) ? null : cast_TerminatorInst(From);
  }

  public static TerminatorInst dyn_cast_TerminatorInst(Value/*P*/ From) {
    assert From != null;
    return isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static TerminatorInst dyn_cast_or_null_TerminatorInst(Value/*P*/ From) {
    return (From != null) && isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static boolean isa_TerminatorInst(Instruction/*P*/ From) {
    assert From != null;
    return TerminatorInst.classof(From);
  }

  public static TerminatorInst cast_TerminatorInst(Instruction/*P*/ From) {
    assert isa_TerminatorInst(From);
    return llvm.cast(TerminatorInst.class, From);
  }

  public static TerminatorInst cast_or_null_TerminatorInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_TerminatorInst(From);
  }

  public static TerminatorInst dyn_cast_TerminatorInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static TerminatorInst dyn_cast_or_null_TerminatorInst(Instruction/*P*/ From) {
    return (From != null) && isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static boolean isa_TerminatorInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TerminatorInst.class, From.$deref());
  }

  public static TerminatorInst cast_TerminatorInst(type$ref<?>/*P*/ From) {
    assert isa_TerminatorInst(From);
    return llvm.cast(TerminatorInst.class, From.$deref());
  }

  public static TerminatorInst cast_or_null_TerminatorInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TerminatorInst(From);
  }

  public static TerminatorInst dyn_cast_TerminatorInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static TerminatorInst dyn_cast_or_null_TerminatorInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static boolean isa_TerminatorInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_TerminatorInst(From.get());
  }

  public static TerminatorInst cast_TerminatorInst(Use/*P*/ From) {
    return cast_TerminatorInst(From.get());
  }

  public static TerminatorInst cast_or_null_TerminatorInst(Use/*P*/ From) {
    return cast_or_null_TerminatorInst(From.get());
  }

  public static TerminatorInst dyn_cast_TerminatorInst(Use/*P*/ From) {
    return isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static TerminatorInst dyn_cast_or_null_TerminatorInst(Use/*P*/ From) {
    return (From != null) && isa_TerminatorInst(From) ? cast_TerminatorInst(From) : null;
  }

  public static boolean isa_TruncInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TruncInst.class, From.$star());
  }

  public static TruncInst cast_TruncInst(type$ptr<?>/*P*/ From) {
    assert isa_TruncInst(From);
    return llvm.cast(TruncInst.class, From.$star());
  }

  public static TruncInst cast_or_null_TruncInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TruncInst(From);
  }

  public static TruncInst dyn_cast_TruncInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static TruncInst dyn_cast_or_null_TruncInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static boolean isa_TruncInst(Instruction/*P*/ From) {
    assert From != null;
    return TruncInst.classof(From);
  }

  public static TruncInst cast_TruncInst(Instruction/*P*/ From) {
    assert isa_TruncInst(From);
    return llvm.cast(TruncInst.class, From);
  }

  public static TruncInst cast_or_null_TruncInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_TruncInst(From);
  }

  public static TruncInst dyn_cast_TruncInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static TruncInst dyn_cast_or_null_TruncInst(Instruction/*P*/ From) {
    return (From != null) && isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static boolean isa_TruncInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TruncInst.class, From.$deref());
  }

  public static TruncInst cast_TruncInst(type$ref<?>/*P*/ From) {
    assert isa_TruncInst(From);
    return llvm.cast(TruncInst.class, From.$deref());
  }

  public static TruncInst cast_or_null_TruncInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TruncInst(From);
  }

  public static TruncInst dyn_cast_TruncInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static TruncInst dyn_cast_or_null_TruncInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static boolean isa_TruncInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_TruncInst(From.get());
  }

  public static TruncInst cast_TruncInst(Use/*P*/ From) {
    return cast_TruncInst(From.get());
  }

  public static TruncInst cast_or_null_TruncInst(Use/*P*/ From) {
    return cast_or_null_TruncInst(From.get());
  }

  public static TruncInst dyn_cast_TruncInst(Use/*P*/ From) {
    return isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static TruncInst dyn_cast_or_null_TruncInst(Use/*P*/ From) {
    return (From != null) && isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static boolean isa_TruncInst(Value/*P*/ From) {
    assert From != null;
    return TruncInst.classof(From);
  }

  public static TruncInst cast_TruncInst(Value/*P*/ From) {
    assert isa_TruncInst(From);
    return (TruncInst) From;
  }

  public static TruncInst cast_or_null_TruncInst(Value/*P*/ From) {
    return (From == null) ? null : cast_TruncInst(From);
  }

  public static TruncInst dyn_cast_TruncInst(Value/*P*/ From) {
    assert From != null;
    return isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static TruncInst dyn_cast_or_null_TruncInst(Value/*P*/ From) {
    return (From != null) && isa_TruncInst(From) ? cast_TruncInst(From) : null;
  }

  public static boolean isa_Type(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Type.class, From.$deref());
  }

  public static Type cast_Type(type$ref<?>/*P*/ From) {
    assert isa_Type(From);
    return llvm.cast(Type.class, From.$deref());
  }

  public static Type cast_or_null_Type(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Type.class, From.$star());
  }

  public static Type cast_Type(type$ptr<?>/*P*/ From) {
    assert isa_Type(From);
    return llvm.cast(Type.class, From.$star());
  }

  public static Type cast_or_null_Type(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_Type(Type/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Type cast_Type(Type/*P*/ From) {
    assert isa_Type(From);
    return (Type) From;
  }

  public static Type cast_or_null_Type(Type/*P*/ From) {
    return (From == null) ? null : cast_Type(From);
  }

  public static Type dyn_cast_Type(Type/*P*/ From) {
    assert From != null;
    return isa_Type(From) ? cast_Type(From) : null;
  }

  public static Type dyn_cast_or_null_Type(Type/*P*/ From) {
    return (From != null) && isa_Type(From) ? cast_Type(From) : null;
  }

  public static boolean isa_UDivOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UDivOperator.class, From.$star());
  }

  public static UDivOperator cast_UDivOperator(type$ptr<?>/*P*/ From) {
    assert isa_UDivOperator(From);
    return llvm.cast(UDivOperator.class, From.$star());
  }

  public static UDivOperator cast_or_null_UDivOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UDivOperator(From);
  }

  public static UDivOperator dyn_cast_UDivOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UDivOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UDivOperator.class, From.$deref());
  }

  public static UDivOperator cast_UDivOperator(type$ref<?>/*P*/ From) {
    assert isa_UDivOperator(From);
    return llvm.cast(UDivOperator.class, From.$deref());
  }

  public static UDivOperator cast_or_null_UDivOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UDivOperator(From);
  }

  public static UDivOperator dyn_cast_UDivOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UDivOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UDivOperator(From.get());
  }

  public static UDivOperator cast_UDivOperator(Use/*P*/ From) {
    return cast_UDivOperator(From.get());
  }

  public static UDivOperator cast_or_null_UDivOperator(Use/*P*/ From) {
    return cast_or_null_UDivOperator(From.get());
  }

  public static UDivOperator dyn_cast_UDivOperator(Use/*P*/ From) {
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(Use/*P*/ From) {
    return (From != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UDivOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return UDivOperator.classof(From);
  }

  public static UDivOperator cast_UDivOperator(ConstantExpr/*P*/ From) {
    assert isa_UDivOperator(From);
    return llvm.cast(UDivOperator.class, From);
  }

  public static UDivOperator cast_or_null_UDivOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_UDivOperator(From);
  }

  public static UDivOperator dyn_cast_UDivOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UDivOperator(Value/*P*/ From) {
    assert From != null;
    return UDivOperator.classof(From);
  }

  public static UDivOperator cast_UDivOperator(Value/*P*/ From) {
    assert isa_UDivOperator(From);
    return llvm.cast(UDivOperator.class, From);
  }

  public static UDivOperator cast_or_null_UDivOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_UDivOperator(From);
  }

  public static UDivOperator dyn_cast_UDivOperator(Value/*P*/ From) {
    assert From != null;
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(Value/*P*/ From) {
    return (From != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UDivOperator(Instruction/*P*/ From) {
    assert From != null;
    return UDivOperator.classof(From);
  }

  public static UDivOperator cast_UDivOperator(Instruction/*P*/ From) {
    assert isa_UDivOperator(From);
    return llvm.cast(UDivOperator.class, From);
  }

  public static UDivOperator cast_or_null_UDivOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_UDivOperator(From);
  }

  public static UDivOperator dyn_cast_UDivOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static UDivOperator dyn_cast_or_null_UDivOperator(Instruction/*P*/ From) {
    return (From != null) && isa_UDivOperator(From) ? cast_UDivOperator(From) : null;
  }

  public static boolean isa_UIToFPInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UIToFPInst.class, From.$star());
  }

  public static UIToFPInst cast_UIToFPInst(type$ptr<?>/*P*/ From) {
    assert isa_UIToFPInst(From);
    return llvm.cast(UIToFPInst.class, From.$star());
  }

  public static UIToFPInst cast_or_null_UIToFPInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UIToFPInst(From);
  }

  public static UIToFPInst dyn_cast_UIToFPInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static UIToFPInst dyn_cast_or_null_UIToFPInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static boolean isa_UIToFPInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UIToFPInst(From.get());
  }

  public static UIToFPInst cast_UIToFPInst(Use/*P*/ From) {
    return cast_UIToFPInst(From.get());
  }

  public static UIToFPInst cast_or_null_UIToFPInst(Use/*P*/ From) {
    return cast_or_null_UIToFPInst(From.get());
  }

  public static UIToFPInst dyn_cast_UIToFPInst(Use/*P*/ From) {
    return isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static UIToFPInst dyn_cast_or_null_UIToFPInst(Use/*P*/ From) {
    return (From != null) && isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static boolean isa_UIToFPInst(Value/*P*/ From) {
    assert From != null;
    return UIToFPInst.classof(From);
  }

  public static UIToFPInst cast_UIToFPInst(Value/*P*/ From) {
    assert isa_UIToFPInst(From);
    return (UIToFPInst) From;
  }

  public static UIToFPInst cast_or_null_UIToFPInst(Value/*P*/ From) {
    return (From == null) ? null : cast_UIToFPInst(From);
  }

  public static UIToFPInst dyn_cast_UIToFPInst(Value/*P*/ From) {
    assert From != null;
    return isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static UIToFPInst dyn_cast_or_null_UIToFPInst(Value/*P*/ From) {
    return (From != null) && isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static boolean isa_UIToFPInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UIToFPInst.class, From.$deref());
  }

  public static UIToFPInst cast_UIToFPInst(type$ref<?>/*P*/ From) {
    assert isa_UIToFPInst(From);
    return llvm.cast(UIToFPInst.class, From.$deref());
  }

  public static UIToFPInst cast_or_null_UIToFPInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UIToFPInst(From);
  }

  public static UIToFPInst dyn_cast_UIToFPInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static UIToFPInst dyn_cast_or_null_UIToFPInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static boolean isa_UIToFPInst(Instruction/*P*/ From) {
    assert From != null;
    return UIToFPInst.classof(From);
  }

  public static UIToFPInst cast_UIToFPInst(Instruction/*P*/ From) {
    assert isa_UIToFPInst(From);
    return llvm.cast(UIToFPInst.class, From);
  }

  public static UIToFPInst cast_or_null_UIToFPInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_UIToFPInst(From);
  }

  public static UIToFPInst dyn_cast_UIToFPInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static UIToFPInst dyn_cast_or_null_UIToFPInst(Instruction/*P*/ From) {
    return (From != null) && isa_UIToFPInst(From) ? cast_UIToFPInst(From) : null;
  }

  public static boolean isa_UnaryInstruction(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UnaryInstruction(From.get());
  }

  public static UnaryInstruction cast_UnaryInstruction(Use/*P*/ From) {
    return cast_UnaryInstruction(From.get());
  }

  public static UnaryInstruction cast_or_null_UnaryInstruction(Use/*P*/ From) {
    return cast_or_null_UnaryInstruction(From.get());
  }

  public static UnaryInstruction dyn_cast_UnaryInstruction(Use/*P*/ From) {
    return isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static UnaryInstruction dyn_cast_or_null_UnaryInstruction(Use/*P*/ From) {
    return (From != null) && isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static boolean isa_UnaryInstruction(Value/*P*/ From) {
    assert From != null;
    return UnaryInstruction.classof(From);
  }

  public static UnaryInstruction cast_UnaryInstruction(Value/*P*/ From) {
    assert isa_UnaryInstruction(From);
    return (UnaryInstruction) From;
  }

  public static UnaryInstruction cast_or_null_UnaryInstruction(Value/*P*/ From) {
    return (From == null) ? null : cast_UnaryInstruction(From);
  }

  public static UnaryInstruction dyn_cast_UnaryInstruction(Value/*P*/ From) {
    assert From != null;
    return isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static UnaryInstruction dyn_cast_or_null_UnaryInstruction(Value/*P*/ From) {
    return (From != null) && isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static boolean isa_UnaryInstruction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryInstruction.class, From.$deref());
  }

  public static UnaryInstruction cast_UnaryInstruction(type$ref<?>/*P*/ From) {
    assert isa_UnaryInstruction(From);
    return llvm.cast(UnaryInstruction.class, From.$deref());
  }

  public static UnaryInstruction cast_or_null_UnaryInstruction(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryInstruction(From);
  }

  public static UnaryInstruction dyn_cast_UnaryInstruction(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static UnaryInstruction dyn_cast_or_null_UnaryInstruction(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static boolean isa_UnaryInstruction(Instruction/*P*/ From) {
    assert From != null;
    return UnaryInstruction.classof(From);
  }

  public static UnaryInstruction cast_UnaryInstruction(Instruction/*P*/ From) {
    assert isa_UnaryInstruction(From);
    return llvm.cast(UnaryInstruction.class, From);
  }

  public static UnaryInstruction cast_or_null_UnaryInstruction(Instruction/*P*/ From) {
    return (From == null) ? null : cast_UnaryInstruction(From);
  }

  public static UnaryInstruction dyn_cast_UnaryInstruction(Instruction/*P*/ From) {
    assert From != null;
    return isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static UnaryInstruction dyn_cast_or_null_UnaryInstruction(Instruction/*P*/ From) {
    return (From != null) && isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static boolean isa_UnaryInstruction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryInstruction.class, From.$star());
  }

  public static UnaryInstruction cast_UnaryInstruction(type$ptr<?>/*P*/ From) {
    assert isa_UnaryInstruction(From);
    return llvm.cast(UnaryInstruction.class, From.$star());
  }

  public static UnaryInstruction cast_or_null_UnaryInstruction(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryInstruction(From);
  }

  public static UnaryInstruction dyn_cast_UnaryInstruction(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static UnaryInstruction dyn_cast_or_null_UnaryInstruction(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryInstruction(From) ? cast_UnaryInstruction(From) : null;
  }

  public static boolean isa_UndefValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UndefValue.class, From.$deref());
  }

  public static UndefValue cast_UndefValue(type$ref<?>/*P*/ From) {
    assert isa_UndefValue(From);
    return llvm.cast(UndefValue.class, From.$deref());
  }

  public static UndefValue cast_or_null_UndefValue(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UndefValue(From);
  }

  public static UndefValue dyn_cast_UndefValue(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static UndefValue dyn_cast_or_null_UndefValue(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static boolean isa_UndefValue(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UndefValue(From.get());
  }

  public static UndefValue cast_UndefValue(Use/*P*/ From) {
    return cast_UndefValue(From.get());
  }

  public static UndefValue cast_or_null_UndefValue(Use/*P*/ From) {
    return cast_or_null_UndefValue(From.get());
  }

  public static UndefValue dyn_cast_UndefValue(Use/*P*/ From) {
    return isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static UndefValue dyn_cast_or_null_UndefValue(Use/*P*/ From) {
    return (From != null) && isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static boolean isa_UndefValue(Value/*P*/ From) {
    assert From != null;
    return UndefValue.classof(From);
  }

  public static UndefValue cast_UndefValue(Value/*P*/ From) {
    assert isa_UndefValue(From);
    return (UndefValue) From;
  }

  public static UndefValue cast_or_null_UndefValue(Value/*P*/ From) {
    return (From == null) ? null : cast_UndefValue(From);
  }

  public static UndefValue dyn_cast_UndefValue(Value/*P*/ From) {
    assert From != null;
    return isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static UndefValue dyn_cast_or_null_UndefValue(Value/*P*/ From) {
    return (From != null) && isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static boolean isa_UndefValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UndefValue.class, From.$star());
  }

  public static UndefValue cast_UndefValue(type$ptr<?>/*P*/ From) {
    assert isa_UndefValue(From);
    return llvm.cast(UndefValue.class, From.$star());
  }

  public static UndefValue cast_or_null_UndefValue(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UndefValue(From);
  }

  public static UndefValue dyn_cast_UndefValue(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static UndefValue dyn_cast_or_null_UndefValue(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UndefValue(From) ? cast_UndefValue(From) : null;
  }

  public static boolean isa_UnreachableInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnreachableInst.class, From.$star());
  }

  public static UnreachableInst cast_UnreachableInst(type$ptr<?>/*P*/ From) {
    assert isa_UnreachableInst(From);
    return llvm.cast(UnreachableInst.class, From.$star());
  }

  public static UnreachableInst cast_or_null_UnreachableInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnreachableInst(From);
  }

  public static UnreachableInst dyn_cast_UnreachableInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static UnreachableInst dyn_cast_or_null_UnreachableInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static boolean isa_UnreachableInst(Instruction/*P*/ From) {
    assert From != null;
    return UnreachableInst.classof(From);
  }

  public static UnreachableInst cast_UnreachableInst(Instruction/*P*/ From) {
    assert isa_UnreachableInst(From);
    return llvm.cast(UnreachableInst.class, From);
  }

  public static UnreachableInst cast_or_null_UnreachableInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_UnreachableInst(From);
  }

  public static UnreachableInst dyn_cast_UnreachableInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static UnreachableInst dyn_cast_or_null_UnreachableInst(Instruction/*P*/ From) {
    return (From != null) && isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static boolean isa_UnreachableInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnreachableInst.class, From.$deref());
  }

  public static UnreachableInst cast_UnreachableInst(type$ref<?>/*P*/ From) {
    assert isa_UnreachableInst(From);
    return llvm.cast(UnreachableInst.class, From.$deref());
  }

  public static UnreachableInst cast_or_null_UnreachableInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnreachableInst(From);
  }

  public static UnreachableInst dyn_cast_UnreachableInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static UnreachableInst dyn_cast_or_null_UnreachableInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static boolean isa_UnreachableInst(Value/*P*/ From) {
    assert From != null;
    return UnreachableInst.classof(From);
  }

  public static UnreachableInst cast_UnreachableInst(Value/*P*/ From) {
    assert isa_UnreachableInst(From);
    return (UnreachableInst) From;
  }

  public static UnreachableInst cast_or_null_UnreachableInst(Value/*P*/ From) {
    return (From == null) ? null : cast_UnreachableInst(From);
  }

  public static UnreachableInst dyn_cast_UnreachableInst(Value/*P*/ From) {
    assert From != null;
    return isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static UnreachableInst dyn_cast_or_null_UnreachableInst(Value/*P*/ From) {
    return (From != null) && isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static boolean isa_UnreachableInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UnreachableInst(From.get());
  }

  public static UnreachableInst cast_UnreachableInst(Use/*P*/ From) {
    return cast_UnreachableInst(From.get());
  }

  public static UnreachableInst cast_or_null_UnreachableInst(Use/*P*/ From) {
    return cast_or_null_UnreachableInst(From.get());
  }

  public static UnreachableInst dyn_cast_UnreachableInst(Use/*P*/ From) {
    return isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static UnreachableInst dyn_cast_or_null_UnreachableInst(Use/*P*/ From) {
    return (From != null) && isa_UnreachableInst(From) ? cast_UnreachableInst(From) : null;
  }

  public static boolean isa_User(Value/*P*/ From) {
    assert From != null;
    return User.classof(From);
  }

  public static User cast_User(Value/*P*/ From) {
    assert isa_User(From);
    return (User) From;
  }

  public static User cast_or_null_User(Value/*P*/ From) {
    return (From == null) ? null : cast_User(From);
  }

  public static User dyn_cast_User(Value/*P*/ From) {
    assert From != null;
    return isa_User(From) ? cast_User(From) : null;
  }

  public static User dyn_cast_or_null_User(Value/*P*/ From) {
    return (From != null) && isa_User(From) ? cast_User(From) : null;
  }

  public static boolean isa_User(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_User(From.get());
  }

  public static User cast_User(Use/*P*/ From) {
    return cast_User(From.get());
  }

  public static User cast_or_null_User(Use/*P*/ From) {
    return cast_or_null_User(From.get());
  }

  public static User dyn_cast_User(Use/*P*/ From) {
    return isa_User(From) ? cast_User(From) : null;
  }

  public static User dyn_cast_or_null_User(Use/*P*/ From) {
    return (From != null) && isa_User(From) ? cast_User(From) : null;
  }

  public static boolean isa_User(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(User.class, From.$deref());
  }

  public static User cast_User(type$ref<?>/*P*/ From) {
    assert isa_User(From);
    return llvm.cast(User.class, From.$deref());
  }

  public static User cast_or_null_User(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_User(From);
  }

  public static User dyn_cast_User(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_User(From) ? cast_User(From) : null;
  }

  public static User dyn_cast_or_null_User(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_User(From) ? cast_User(From) : null;
  }

  public static boolean isa_User(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(User.class, From.$star());
  }

  public static User cast_User(type$ptr<?>/*P*/ From) {
    assert isa_User(From);
    return llvm.cast(User.class, From.$star());
  }

  public static User cast_or_null_User(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_User(From);
  }

  public static User dyn_cast_User(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_User(From) ? cast_User(From) : null;
  }

  public static User dyn_cast_or_null_User(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_User(From) ? cast_User(From) : null;
  }

  public static boolean isa_VAArgInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VAArgInst.class, From.$deref());
  }

  public static VAArgInst cast_VAArgInst(type$ref<?>/*P*/ From) {
    assert isa_VAArgInst(From);
    return llvm.cast(VAArgInst.class, From.$deref());
  }

  public static VAArgInst cast_or_null_VAArgInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VAArgInst(From);
  }

  public static VAArgInst dyn_cast_VAArgInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static VAArgInst dyn_cast_or_null_VAArgInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static boolean isa_VAArgInst(Instruction/*P*/ From) {
    assert From != null;
    return VAArgInst.classof(From);
  }

  public static VAArgInst cast_VAArgInst(Instruction/*P*/ From) {
    assert isa_VAArgInst(From);
    return llvm.cast(VAArgInst.class, From);
  }

  public static VAArgInst cast_or_null_VAArgInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_VAArgInst(From);
  }

  public static VAArgInst dyn_cast_VAArgInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static VAArgInst dyn_cast_or_null_VAArgInst(Instruction/*P*/ From) {
    return (From != null) && isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static boolean isa_VAArgInst(Value/*P*/ From) {
    assert From != null;
    return VAArgInst.classof(From);
  }

  public static VAArgInst cast_VAArgInst(Value/*P*/ From) {
    assert isa_VAArgInst(From);
    return (VAArgInst) From;
  }

  public static VAArgInst cast_or_null_VAArgInst(Value/*P*/ From) {
    return (From == null) ? null : cast_VAArgInst(From);
  }

  public static VAArgInst dyn_cast_VAArgInst(Value/*P*/ From) {
    assert From != null;
    return isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static VAArgInst dyn_cast_or_null_VAArgInst(Value/*P*/ From) {
    return (From != null) && isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static boolean isa_VAArgInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VAArgInst.class, From.$star());
  }

  public static VAArgInst cast_VAArgInst(type$ptr<?>/*P*/ From) {
    assert isa_VAArgInst(From);
    return llvm.cast(VAArgInst.class, From.$star());
  }

  public static VAArgInst cast_or_null_VAArgInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VAArgInst(From);
  }

  public static VAArgInst dyn_cast_VAArgInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static VAArgInst dyn_cast_or_null_VAArgInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static boolean isa_VAArgInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_VAArgInst(From.get());
  }

  public static VAArgInst cast_VAArgInst(Use/*P*/ From) {
    return cast_VAArgInst(From.get());
  }

  public static VAArgInst cast_or_null_VAArgInst(Use/*P*/ From) {
    return cast_or_null_VAArgInst(From.get());
  }

  public static VAArgInst dyn_cast_VAArgInst(Use/*P*/ From) {
    return isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static VAArgInst dyn_cast_or_null_VAArgInst(Use/*P*/ From) {
    return (From != null) && isa_VAArgInst(From) ? cast_VAArgInst(From) : null;
  }

  public static boolean isa_VACopyInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VACopyInst.class, From.$star());
  }

  public static VACopyInst cast_VACopyInst(type$ptr<?>/*P*/ From) {
    assert isa_VACopyInst(From);
    return llvm.cast(VACopyInst.class, From.$star());
  }

  public static VACopyInst cast_or_null_VACopyInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return VACopyInst.classof(From);
  }

  public static VACopyInst cast_VACopyInst(IntrinsicInst/*P*/ From) {
    assert isa_VACopyInst(From);
    return (VACopyInst) From;
  }

  public static VACopyInst cast_or_null_VACopyInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(Value/*P*/ From) {
    assert From != null;
    return VACopyInst.classof(From);
  }

  public static VACopyInst cast_VACopyInst(Value/*P*/ From) {
    assert isa_VACopyInst(From);
    return (VACopyInst) From;
  }

  public static VACopyInst cast_or_null_VACopyInst(Value/*P*/ From) {
    return (From == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(Value/*P*/ From) {
    assert From != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(Value/*P*/ From) {
    return (From != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_VACopyInst(From.get());
  }

  public static VACopyInst cast_VACopyInst(Use/*P*/ From) {
    return cast_VACopyInst(From.get());
  }

  public static VACopyInst cast_or_null_VACopyInst(Use/*P*/ From) {
    return cast_or_null_VACopyInst(From.get());
  }

  public static VACopyInst dyn_cast_VACopyInst(Use/*P*/ From) {
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(Use/*P*/ From) {
    return (From != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VACopyInst.class, From.$deref());
  }

  public static VACopyInst cast_VACopyInst(type$ref<?>/*P*/ From) {
    assert isa_VACopyInst(From);
    return llvm.cast(VACopyInst.class, From.$deref());
  }

  public static VACopyInst cast_or_null_VACopyInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(CallInst/*P*/ From) {
    assert From != null;
    return VACopyInst.classof(From);
  }

  public static VACopyInst cast_VACopyInst(CallInst/*P*/ From) {
    assert isa_VACopyInst(From);
    return (VACopyInst) From;
  }

  public static VACopyInst cast_or_null_VACopyInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(CallInst/*P*/ From) {
    return (From != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VACopyInst(Instruction/*P*/ From) {
    assert From != null;
    return VACopyInst.classof(From);
  }

  public static VACopyInst cast_VACopyInst(Instruction/*P*/ From) {
    assert isa_VACopyInst(From);
    return llvm.cast(VACopyInst.class, From);
  }

  public static VACopyInst cast_or_null_VACopyInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_VACopyInst(From);
  }

  public static VACopyInst dyn_cast_VACopyInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static VACopyInst dyn_cast_or_null_VACopyInst(Instruction/*P*/ From) {
    return (From != null) && isa_VACopyInst(From) ? cast_VACopyInst(From) : null;
  }

  public static boolean isa_VAEndInst(Value/*P*/ From) {
    assert From != null;
    return VAEndInst.classof(From);
  }

  public static VAEndInst cast_VAEndInst(Value/*P*/ From) {
    assert isa_VAEndInst(From);
    return (VAEndInst) From;
  }

  public static VAEndInst cast_or_null_VAEndInst(Value/*P*/ From) {
    return (From == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(Value/*P*/ From) {
    assert From != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(Value/*P*/ From) {
    return (From != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(CallInst/*P*/ From) {
    assert From != null;
    return VAEndInst.classof(From);
  }

  public static VAEndInst cast_VAEndInst(CallInst/*P*/ From) {
    assert isa_VAEndInst(From);
    return (VAEndInst) From;
  }

  public static VAEndInst cast_or_null_VAEndInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(CallInst/*P*/ From) {
    return (From != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_VAEndInst(From.get());
  }

  public static VAEndInst cast_VAEndInst(Use/*P*/ From) {
    return cast_VAEndInst(From.get());
  }

  public static VAEndInst cast_or_null_VAEndInst(Use/*P*/ From) {
    return cast_or_null_VAEndInst(From.get());
  }

  public static VAEndInst dyn_cast_VAEndInst(Use/*P*/ From) {
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(Use/*P*/ From) {
    return (From != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VAEndInst.class, From.$deref());
  }

  public static VAEndInst cast_VAEndInst(type$ref<?>/*P*/ From) {
    assert isa_VAEndInst(From);
    return llvm.cast(VAEndInst.class, From.$deref());
  }

  public static VAEndInst cast_or_null_VAEndInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return VAEndInst.classof(From);
  }

  public static VAEndInst cast_VAEndInst(IntrinsicInst/*P*/ From) {
    assert isa_VAEndInst(From);
    return (VAEndInst) From;
  }

  public static VAEndInst cast_or_null_VAEndInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(Instruction/*P*/ From) {
    assert From != null;
    return VAEndInst.classof(From);
  }

  public static VAEndInst cast_VAEndInst(Instruction/*P*/ From) {
    assert isa_VAEndInst(From);
    return llvm.cast(VAEndInst.class, From);
  }

  public static VAEndInst cast_or_null_VAEndInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(Instruction/*P*/ From) {
    return (From != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAEndInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VAEndInst.class, From.$star());
  }

  public static VAEndInst cast_VAEndInst(type$ptr<?>/*P*/ From) {
    assert isa_VAEndInst(From);
    return llvm.cast(VAEndInst.class, From.$star());
  }

  public static VAEndInst cast_or_null_VAEndInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VAEndInst(From);
  }

  public static VAEndInst dyn_cast_VAEndInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static VAEndInst dyn_cast_or_null_VAEndInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VAEndInst(From) ? cast_VAEndInst(From) : null;
  }

  public static boolean isa_VAStartInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return VAStartInst.classof(From);
  }

  public static VAStartInst cast_VAStartInst(IntrinsicInst/*P*/ From) {
    assert isa_VAStartInst(From);
    return (VAStartInst) From;
  }

  public static VAStartInst cast_or_null_VAStartInst(IntrinsicInst/*P*/ From) {
    return (From == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(IntrinsicInst/*P*/ From) {
    assert From != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(IntrinsicInst/*P*/ From) {
    return (From != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(CallInst/*P*/ From) {
    assert From != null;
    return VAStartInst.classof(From);
  }

  public static VAStartInst cast_VAStartInst(CallInst/*P*/ From) {
    assert isa_VAStartInst(From);
    return (VAStartInst) From;
  }

  public static VAStartInst cast_or_null_VAStartInst(CallInst/*P*/ From) {
    return (From == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(CallInst/*P*/ From) {
    assert From != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(CallInst/*P*/ From) {
    return (From != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(Instruction/*P*/ From) {
    assert From != null;
    return VAStartInst.classof(From);
  }

  public static VAStartInst cast_VAStartInst(Instruction/*P*/ From) {
    assert isa_VAStartInst(From);
    return llvm.cast(VAStartInst.class, From);
  }

  public static VAStartInst cast_or_null_VAStartInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(Instruction/*P*/ From) {
    return (From != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_VAStartInst(From.get());
  }

  public static VAStartInst cast_VAStartInst(Use/*P*/ From) {
    return cast_VAStartInst(From.get());
  }

  public static VAStartInst cast_or_null_VAStartInst(Use/*P*/ From) {
    return cast_or_null_VAStartInst(From.get());
  }

  public static VAStartInst dyn_cast_VAStartInst(Use/*P*/ From) {
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(Use/*P*/ From) {
    return (From != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(Value/*P*/ From) {
    assert From != null;
    return VAStartInst.classof(From);
  }

  public static VAStartInst cast_VAStartInst(Value/*P*/ From) {
    assert isa_VAStartInst(From);
    return (VAStartInst) From;
  }

  public static VAStartInst cast_or_null_VAStartInst(Value/*P*/ From) {
    return (From == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(Value/*P*/ From) {
    assert From != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(Value/*P*/ From) {
    return (From != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VAStartInst.class, From.$star());
  }

  public static VAStartInst cast_VAStartInst(type$ptr<?>/*P*/ From) {
    assert isa_VAStartInst(From);
    return llvm.cast(VAStartInst.class, From.$star());
  }

  public static VAStartInst cast_or_null_VAStartInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_VAStartInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VAStartInst.class, From.$deref());
  }

  public static VAStartInst cast_VAStartInst(type$ref<?>/*P*/ From) {
    assert isa_VAStartInst(From);
    return llvm.cast(VAStartInst.class, From.$deref());
  }

  public static VAStartInst cast_or_null_VAStartInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VAStartInst(From);
  }

  public static VAStartInst dyn_cast_VAStartInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static VAStartInst dyn_cast_or_null_VAStartInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VAStartInst(From) ? cast_VAStartInst(From) : null;
  }

  public static boolean isa_Value(Value/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Value cast_Value(Value/*P*/ From) {
    assert isa_Value(From);
    return (Value) From;
  }

  public static Value cast_or_null_Value(Value/*P*/ From) {
    return (From == null) ? null : cast_Value(From);
  }

  public static Value dyn_cast_Value(Value/*P*/ From) {
    assert From != null;
    return isa_Value(From) ? cast_Value(From) : null;
  }

  public static Value dyn_cast_or_null_Value(Value/*P*/ From) {
    return (From != null) && isa_Value(From) ? cast_Value(From) : null;
  }

  public static boolean isa_Value(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Value.class, From.$deref());
  }

  public static Value cast_Value(type$ref<?>/*P*/ From) {
    assert isa_Value(From);
    return llvm.cast(Value.class, From.$deref());
  }

  public static Value cast_or_null_Value(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Value(From);
  }

  public static Value dyn_cast_Value(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Value(From) ? cast_Value(From) : null;
  }

  public static Value dyn_cast_or_null_Value(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Value(From) ? cast_Value(From) : null;
  }

  public static boolean isa_Value(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Value.class, From.$star());
  }

  public static Value cast_Value(type$ptr<?>/*P*/ From) {
    assert isa_Value(From);
    return llvm.cast(Value.class, From.$star());
  }

  public static Value cast_or_null_Value(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Value(From);
  }

  public static Value dyn_cast_Value(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Value(From) ? cast_Value(From) : null;
  }

  public static Value dyn_cast_or_null_Value(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Value(From) ? cast_Value(From) : null;
  }

  public static boolean isa_Value(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_Value(From.get());
  }

  public static Value cast_Value(Use/*P*/ From) {
    return cast_Value(From.get());
  }

  public static Value cast_or_null_Value(Use/*P*/ From) {
    return cast_or_null_Value(From.get());
  }

  public static Value dyn_cast_Value(Use/*P*/ From) {
    return isa_Value(From) ? cast_Value(From) : null;
  }

  public static Value dyn_cast_or_null_Value(Use/*P*/ From) {
    return (From != null) && isa_Value(From) ? cast_Value(From) : null;
  }

  public static boolean isa_ValueAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return ValueAsMetadata.classof(From);
  }

  public static ValueAsMetadata cast_ValueAsMetadata(Metadata/*P*/ From) {
    assert isa_ValueAsMetadata(From);
    return (ValueAsMetadata) From;
  }

  public static ValueAsMetadata cast_or_null_ValueAsMetadata(Metadata/*P*/ From) {
    return (From == null) ? null : cast_ValueAsMetadata(From);
  }

  public static ValueAsMetadata dyn_cast_ValueAsMetadata(Metadata/*P*/ From) {
    assert From != null;
    return isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static ValueAsMetadata dyn_cast_or_null_ValueAsMetadata(Metadata/*P*/ From) {
    return (From != null) && isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static boolean isa_ValueAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ValueAsMetadata.class, From.$star());
  }

  public static ValueAsMetadata cast_ValueAsMetadata(type$ptr<?>/*P*/ From) {
    assert isa_ValueAsMetadata(From);
    return llvm.cast(ValueAsMetadata.class, From.$star());
  }

  public static ValueAsMetadata cast_or_null_ValueAsMetadata(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ValueAsMetadata(From);
  }

  public static ValueAsMetadata dyn_cast_ValueAsMetadata(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static ValueAsMetadata dyn_cast_or_null_ValueAsMetadata(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static boolean isa_ValueAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ValueAsMetadata.class, From.$deref());
  }

  public static ValueAsMetadata cast_ValueAsMetadata(type$ref<?>/*P*/ From) {
    assert isa_ValueAsMetadata(From);
    return llvm.cast(ValueAsMetadata.class, From.$deref());
  }

  public static ValueAsMetadata cast_or_null_ValueAsMetadata(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ValueAsMetadata(From);
  }

  public static ValueAsMetadata dyn_cast_ValueAsMetadata(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static ValueAsMetadata dyn_cast_or_null_ValueAsMetadata(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static boolean isa_ValueAsMetadata(MDOperand/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ValueAsMetadata(From.get());
  }

  public static ValueAsMetadata cast_ValueAsMetadata(MDOperand/*P*/ From) {
    return cast_ValueAsMetadata(From.get());
  }

  public static ValueAsMetadata cast_or_null_ValueAsMetadata(MDOperand/*P*/ From) {
    return cast_or_null_ValueAsMetadata(From.get());
  }

  public static ValueAsMetadata dyn_cast_ValueAsMetadata(MDOperand/*P*/ From) {
    return isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static ValueAsMetadata dyn_cast_or_null_ValueAsMetadata(MDOperand/*P*/ From) {
    return (From != null) && isa_ValueAsMetadata(From) ? cast_ValueAsMetadata(From) : null;
  }

  public static boolean isa_VectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VectorType.class, From.$deref());
  }

  public static VectorType cast_VectorType(type$ref<?>/*P*/ From) {
    assert isa_VectorType(From);
    return llvm.cast(VectorType.class, From.$deref());
  }

  public static VectorType cast_or_null_VectorType(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(Type/*P*/ From) {
    assert From != null;
    return VectorType.classof(From);
  }

  public static VectorType cast_VectorType(Type/*P*/ From) {
    assert isa_VectorType(From);
    return (VectorType) From;
  }

  public static VectorType cast_or_null_VectorType(Type/*P*/ From) {
    return (From == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(Type/*P*/ From) {
    assert From != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(Type/*P*/ From) {
    return (From != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_VectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VectorType.class, From.$star());
  }

  public static VectorType cast_VectorType(type$ptr<?>/*P*/ From) {
    assert isa_VectorType(From);
    return llvm.cast(VectorType.class, From.$star());
  }

  public static VectorType cast_or_null_VectorType(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VectorType(From);
  }

  public static VectorType dyn_cast_VectorType(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static VectorType dyn_cast_or_null_VectorType(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VectorType(From) ? cast_VectorType(From) : null;
  }

  public static boolean isa_ZExtInst(Instruction/*P*/ From) {
    assert From != null;
    return ZExtInst.classof(From);
  }

  public static ZExtInst cast_ZExtInst(Instruction/*P*/ From) {
    assert isa_ZExtInst(From);
    return llvm.cast(ZExtInst.class, From);
  }

  public static ZExtInst cast_or_null_ZExtInst(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ZExtInst(From);
  }

  public static ZExtInst dyn_cast_ZExtInst(Instruction/*P*/ From) {
    assert From != null;
    return isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static ZExtInst dyn_cast_or_null_ZExtInst(Instruction/*P*/ From) {
    return (From != null) && isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static boolean isa_ZExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ZExtInst.class, From.$deref());
  }

  public static ZExtInst cast_ZExtInst(type$ref<?>/*P*/ From) {
    assert isa_ZExtInst(From);
    return llvm.cast(ZExtInst.class, From.$deref());
  }

  public static ZExtInst cast_or_null_ZExtInst(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ZExtInst(From);
  }

  public static ZExtInst dyn_cast_ZExtInst(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static ZExtInst dyn_cast_or_null_ZExtInst(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static boolean isa_ZExtInst(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ZExtInst(From.get());
  }

  public static ZExtInst cast_ZExtInst(Use/*P*/ From) {
    return cast_ZExtInst(From.get());
  }

  public static ZExtInst cast_or_null_ZExtInst(Use/*P*/ From) {
    return cast_or_null_ZExtInst(From.get());
  }

  public static ZExtInst dyn_cast_ZExtInst(Use/*P*/ From) {
    return isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static ZExtInst dyn_cast_or_null_ZExtInst(Use/*P*/ From) {
    return (From != null) && isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static boolean isa_ZExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ZExtInst.class, From.$star());
  }

  public static ZExtInst cast_ZExtInst(type$ptr<?>/*P*/ From) {
    assert isa_ZExtInst(From);
    return llvm.cast(ZExtInst.class, From.$star());
  }

  public static ZExtInst cast_or_null_ZExtInst(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ZExtInst(From);
  }

  public static ZExtInst dyn_cast_ZExtInst(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static ZExtInst dyn_cast_or_null_ZExtInst(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static boolean isa_ZExtInst(Value/*P*/ From) {
    assert From != null;
    return ZExtInst.classof(From);
  }

  public static ZExtInst cast_ZExtInst(Value/*P*/ From) {
    assert isa_ZExtInst(From);
    return (ZExtInst) From;
  }

  public static ZExtInst cast_or_null_ZExtInst(Value/*P*/ From) {
    return (From == null) ? null : cast_ZExtInst(From);
  }

  public static ZExtInst dyn_cast_ZExtInst(Value/*P*/ From) {
    assert From != null;
    return isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static ZExtInst dyn_cast_or_null_ZExtInst(Value/*P*/ From) {
    return (From != null) && isa_ZExtInst(From) ? cast_ZExtInst(From) : null;
  }

  public static boolean isa_ZExtOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ZExtOperator.class, From.$star());
  }

  public static ZExtOperator cast_ZExtOperator(type$ptr<?>/*P*/ From) {
    assert isa_ZExtOperator(From);
    return llvm.cast(ZExtOperator.class, From.$star());
  }

  public static ZExtOperator cast_or_null_ZExtOperator(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ZExtOperator(From);
  }

  public static ZExtOperator dyn_cast_ZExtOperator(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_ZExtOperator(Instruction/*P*/ From) {
    assert From != null;
    return ZExtOperator.classof(From);
  }

  public static ZExtOperator cast_ZExtOperator(Instruction/*P*/ From) {
    assert isa_ZExtOperator(From);
    return llvm.cast(ZExtOperator.class, From);
  }

  public static ZExtOperator cast_or_null_ZExtOperator(Instruction/*P*/ From) {
    return (From == null) ? null : cast_ZExtOperator(From);
  }

  public static ZExtOperator dyn_cast_ZExtOperator(Instruction/*P*/ From) {
    assert From != null;
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(Instruction/*P*/ From) {
    return (From != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_ZExtOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ZExtOperator.class, From.$deref());
  }

  public static ZExtOperator cast_ZExtOperator(type$ref<?>/*P*/ From) {
    assert isa_ZExtOperator(From);
    return llvm.cast(ZExtOperator.class, From.$deref());
  }

  public static ZExtOperator cast_or_null_ZExtOperator(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ZExtOperator(From);
  }

  public static ZExtOperator dyn_cast_ZExtOperator(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_ZExtOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return ZExtOperator.classof(From);
  }

  public static ZExtOperator cast_ZExtOperator(ConstantExpr/*P*/ From) {
    assert isa_ZExtOperator(From);
    return llvm.cast(ZExtOperator.class, From);
  }

  public static ZExtOperator cast_or_null_ZExtOperator(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_ZExtOperator(From);
  }

  public static ZExtOperator dyn_cast_ZExtOperator(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(ConstantExpr/*P*/ From) {
    return (From != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_ZExtOperator(Value/*P*/ From) {
    assert From != null;
    return ZExtOperator.classof(From);
  }

  public static ZExtOperator cast_ZExtOperator(Value/*P*/ From) {
    assert isa_ZExtOperator(From);
    return llvm.cast(ZExtOperator.class, From);
  }

  public static ZExtOperator cast_or_null_ZExtOperator(Value/*P*/ From) {
    return (From == null) ? null : cast_ZExtOperator(From);
  }

  public static ZExtOperator dyn_cast_ZExtOperator(Value/*P*/ From) {
    assert From != null;
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(Value/*P*/ From) {
    return (From != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_ZExtOperator(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ZExtOperator(From.get());
  }

  public static ZExtOperator cast_ZExtOperator(Use/*P*/ From) {
    return cast_ZExtOperator(From.get());
  }

  public static ZExtOperator cast_or_null_ZExtOperator(Use/*P*/ From) {
    return cast_or_null_ZExtOperator(From.get());
  }

  public static ZExtOperator dyn_cast_ZExtOperator(Use/*P*/ From) {
    return isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static ZExtOperator dyn_cast_or_null_ZExtOperator(Use/*P*/ From) {
    return (From != null) && isa_ZExtOperator(From) ? cast_ZExtOperator(From) : null;
  }

  public static boolean isa_BinaryConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BinaryConstantExpr.class, From.$deref());
  }

  public static BinaryConstantExpr cast_BinaryConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_BinaryConstantExpr(From);
    return llvm.cast(BinaryConstantExpr.class, From.$deref());
  }

  public static BinaryConstantExpr cast_or_null_BinaryConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BinaryConstantExpr(From);
  }

  public static BinaryConstantExpr dyn_cast_BinaryConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static BinaryConstantExpr dyn_cast_or_null_BinaryConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static boolean isa_BinaryConstantExpr(Value/*P*/ From) {
    assert From != null;
    return BinaryConstantExpr.classof(From);
  }

  public static BinaryConstantExpr cast_BinaryConstantExpr(Value/*P*/ From) {
    assert isa_BinaryConstantExpr(From);
    return (BinaryConstantExpr) From;
  }

  public static BinaryConstantExpr cast_or_null_BinaryConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_BinaryConstantExpr(From);
  }

  public static BinaryConstantExpr dyn_cast_BinaryConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static BinaryConstantExpr dyn_cast_or_null_BinaryConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static boolean isa_BinaryConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_BinaryConstantExpr(From.get());
  }

  public static BinaryConstantExpr cast_BinaryConstantExpr(Use/*P*/ From) {
    return cast_BinaryConstantExpr(From.get());
  }

  public static BinaryConstantExpr cast_or_null_BinaryConstantExpr(Use/*P*/ From) {
    return cast_or_null_BinaryConstantExpr(From.get());
  }

  public static BinaryConstantExpr dyn_cast_BinaryConstantExpr(Use/*P*/ From) {
    return isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static BinaryConstantExpr dyn_cast_or_null_BinaryConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static boolean isa_BinaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BinaryConstantExpr.class, From.$star());
  }

  public static BinaryConstantExpr cast_BinaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_BinaryConstantExpr(From);
    return llvm.cast(BinaryConstantExpr.class, From.$star());
  }

  public static BinaryConstantExpr cast_or_null_BinaryConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BinaryConstantExpr(From);
  }

  public static BinaryConstantExpr dyn_cast_BinaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static BinaryConstantExpr dyn_cast_or_null_BinaryConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BinaryConstantExpr(From) ? cast_BinaryConstantExpr(From) : null;
  }

  public static boolean isa_CompareConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CompareConstantExpr.class, From.$star());
  }

  public static CompareConstantExpr cast_CompareConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_CompareConstantExpr(From);
    return llvm.cast(CompareConstantExpr.class, From.$star());
  }

  public static CompareConstantExpr cast_or_null_CompareConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CompareConstantExpr(From);
  }

  public static CompareConstantExpr dyn_cast_CompareConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static CompareConstantExpr dyn_cast_or_null_CompareConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static boolean isa_CompareConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return CompareConstantExpr.classof(From);
  }

  public static CompareConstantExpr cast_CompareConstantExpr(ConstantExpr/*P*/ From) {
    assert isa_CompareConstantExpr(From);
    return (CompareConstantExpr) From;
  }

  public static CompareConstantExpr cast_or_null_CompareConstantExpr(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_CompareConstantExpr(From);
  }

  public static CompareConstantExpr dyn_cast_CompareConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static CompareConstantExpr dyn_cast_or_null_CompareConstantExpr(ConstantExpr/*P*/ From) {
    return (From != null) && isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static boolean isa_CompareConstantExpr(Value/*P*/ From) {
    assert From != null;
    return CompareConstantExpr.classof(From);
  }

  public static CompareConstantExpr cast_CompareConstantExpr(Value/*P*/ From) {
    assert isa_CompareConstantExpr(From);
    return (CompareConstantExpr) From;
  }

  public static CompareConstantExpr cast_or_null_CompareConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_CompareConstantExpr(From);
  }

  public static CompareConstantExpr dyn_cast_CompareConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static CompareConstantExpr dyn_cast_or_null_CompareConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static boolean isa_CompareConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_CompareConstantExpr(From.get());
  }

  public static CompareConstantExpr cast_CompareConstantExpr(Use/*P*/ From) {
    return cast_CompareConstantExpr(From.get());
  }

  public static CompareConstantExpr cast_or_null_CompareConstantExpr(Use/*P*/ From) {
    return cast_or_null_CompareConstantExpr(From.get());
  }

  public static CompareConstantExpr dyn_cast_CompareConstantExpr(Use/*P*/ From) {
    return isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static CompareConstantExpr dyn_cast_or_null_CompareConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static boolean isa_CompareConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CompareConstantExpr.class, From.$deref());
  }

  public static CompareConstantExpr cast_CompareConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_CompareConstantExpr(From);
    return llvm.cast(CompareConstantExpr.class, From.$deref());
  }

  public static CompareConstantExpr cast_or_null_CompareConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CompareConstantExpr(From);
  }

  public static CompareConstantExpr dyn_cast_CompareConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static CompareConstantExpr dyn_cast_or_null_CompareConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CompareConstantExpr(From) ? cast_CompareConstantExpr(From) : null;
  }

  public static boolean isa_ExtractElementConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ExtractElementConstantExpr(From.get());
  }

  public static ExtractElementConstantExpr cast_ExtractElementConstantExpr(Use/*P*/ From) {
    return cast_ExtractElementConstantExpr(From.get());
  }

  public static ExtractElementConstantExpr cast_or_null_ExtractElementConstantExpr(Use/*P*/ From) {
    return cast_or_null_ExtractElementConstantExpr(From.get());
  }

  public static ExtractElementConstantExpr dyn_cast_ExtractElementConstantExpr(Use/*P*/ From) {
    return isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static ExtractElementConstantExpr dyn_cast_or_null_ExtractElementConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static boolean isa_ExtractElementConstantExpr(Value/*P*/ From) {
    assert From != null;
    return ExtractElementConstantExpr.classof(From);
  }

  public static ExtractElementConstantExpr cast_ExtractElementConstantExpr(Value/*P*/ From) {
    assert isa_ExtractElementConstantExpr(From);
    return (ExtractElementConstantExpr) From;
  }

  public static ExtractElementConstantExpr cast_or_null_ExtractElementConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_ExtractElementConstantExpr(From);
  }

  public static ExtractElementConstantExpr dyn_cast_ExtractElementConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static ExtractElementConstantExpr dyn_cast_or_null_ExtractElementConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static boolean isa_ExtractElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtractElementConstantExpr.class, From.$star());
  }

  public static ExtractElementConstantExpr cast_ExtractElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_ExtractElementConstantExpr(From);
    return llvm.cast(ExtractElementConstantExpr.class, From.$star());
  }

  public static ExtractElementConstantExpr cast_or_null_ExtractElementConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtractElementConstantExpr(From);
  }

  public static ExtractElementConstantExpr dyn_cast_ExtractElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static ExtractElementConstantExpr dyn_cast_or_null_ExtractElementConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static boolean isa_ExtractElementConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtractElementConstantExpr.class, From.$deref());
  }

  public static ExtractElementConstantExpr cast_ExtractElementConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_ExtractElementConstantExpr(From);
    return llvm.cast(ExtractElementConstantExpr.class, From.$deref());
  }

  public static ExtractElementConstantExpr cast_or_null_ExtractElementConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtractElementConstantExpr(From);
  }

  public static ExtractElementConstantExpr dyn_cast_ExtractElementConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static ExtractElementConstantExpr dyn_cast_or_null_ExtractElementConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtractElementConstantExpr(From) ? cast_ExtractElementConstantExpr(From) : null;
  }

  public static boolean isa_ExtractValueConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExtractValueConstantExpr.class, From.$deref());
  }

  public static ExtractValueConstantExpr cast_ExtractValueConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_ExtractValueConstantExpr(From);
    return llvm.cast(ExtractValueConstantExpr.class, From.$deref());
  }

  public static ExtractValueConstantExpr cast_or_null_ExtractValueConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExtractValueConstantExpr(From);
  }

  public static ExtractValueConstantExpr dyn_cast_ExtractValueConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static ExtractValueConstantExpr dyn_cast_or_null_ExtractValueConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static boolean isa_ExtractValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExtractValueConstantExpr.class, From.$star());
  }

  public static ExtractValueConstantExpr cast_ExtractValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_ExtractValueConstantExpr(From);
    return llvm.cast(ExtractValueConstantExpr.class, From.$star());
  }

  public static ExtractValueConstantExpr cast_or_null_ExtractValueConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExtractValueConstantExpr(From);
  }

  public static ExtractValueConstantExpr dyn_cast_ExtractValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static ExtractValueConstantExpr dyn_cast_or_null_ExtractValueConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static boolean isa_ExtractValueConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return ExtractValueConstantExpr.classof(From);
  }

  public static ExtractValueConstantExpr cast_ExtractValueConstantExpr(ConstantExpr/*P*/ From) {
    assert isa_ExtractValueConstantExpr(From);
    return (ExtractValueConstantExpr) From;
  }

  public static ExtractValueConstantExpr cast_or_null_ExtractValueConstantExpr(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_ExtractValueConstantExpr(From);
  }

  public static ExtractValueConstantExpr dyn_cast_ExtractValueConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static ExtractValueConstantExpr dyn_cast_or_null_ExtractValueConstantExpr(ConstantExpr/*P*/ From) {
    return (From != null) && isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static boolean isa_ExtractValueConstantExpr(Value/*P*/ From) {
    assert From != null;
    return ExtractValueConstantExpr.classof(From);
  }

  public static ExtractValueConstantExpr cast_ExtractValueConstantExpr(Value/*P*/ From) {
    assert isa_ExtractValueConstantExpr(From);
    return (ExtractValueConstantExpr) From;
  }

  public static ExtractValueConstantExpr cast_or_null_ExtractValueConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_ExtractValueConstantExpr(From);
  }

  public static ExtractValueConstantExpr dyn_cast_ExtractValueConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static ExtractValueConstantExpr dyn_cast_or_null_ExtractValueConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static boolean isa_ExtractValueConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ExtractValueConstantExpr(From.get());
  }

  public static ExtractValueConstantExpr cast_ExtractValueConstantExpr(Use/*P*/ From) {
    return cast_ExtractValueConstantExpr(From.get());
  }

  public static ExtractValueConstantExpr cast_or_null_ExtractValueConstantExpr(Use/*P*/ From) {
    return cast_or_null_ExtractValueConstantExpr(From.get());
  }

  public static ExtractValueConstantExpr dyn_cast_ExtractValueConstantExpr(Use/*P*/ From) {
    return isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static ExtractValueConstantExpr dyn_cast_or_null_ExtractValueConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_ExtractValueConstantExpr(From) ? cast_ExtractValueConstantExpr(From) : null;
  }

  public static boolean isa_GetElementPtrConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GetElementPtrConstantExpr.class, From.$star());
  }

  public static GetElementPtrConstantExpr cast_GetElementPtrConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_GetElementPtrConstantExpr(From);
    return llvm.cast(GetElementPtrConstantExpr.class, From.$star());
  }

  public static GetElementPtrConstantExpr cast_or_null_GetElementPtrConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GetElementPtrConstantExpr(From);
  }

  public static GetElementPtrConstantExpr dyn_cast_GetElementPtrConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static GetElementPtrConstantExpr dyn_cast_or_null_GetElementPtrConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static boolean isa_GetElementPtrConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_GetElementPtrConstantExpr(From.get());
  }

  public static GetElementPtrConstantExpr cast_GetElementPtrConstantExpr(Use/*P*/ From) {
    return cast_GetElementPtrConstantExpr(From.get());
  }

  public static GetElementPtrConstantExpr cast_or_null_GetElementPtrConstantExpr(Use/*P*/ From) {
    return cast_or_null_GetElementPtrConstantExpr(From.get());
  }

  public static GetElementPtrConstantExpr dyn_cast_GetElementPtrConstantExpr(Use/*P*/ From) {
    return isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static GetElementPtrConstantExpr dyn_cast_or_null_GetElementPtrConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static boolean isa_GetElementPtrConstantExpr(Value/*P*/ From) {
    assert From != null;
    return GetElementPtrConstantExpr.classof(From);
  }

  public static GetElementPtrConstantExpr cast_GetElementPtrConstantExpr(Value/*P*/ From) {
    assert isa_GetElementPtrConstantExpr(From);
    return (GetElementPtrConstantExpr) From;
  }

  public static GetElementPtrConstantExpr cast_or_null_GetElementPtrConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_GetElementPtrConstantExpr(From);
  }

  public static GetElementPtrConstantExpr dyn_cast_GetElementPtrConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static GetElementPtrConstantExpr dyn_cast_or_null_GetElementPtrConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static boolean isa_GetElementPtrConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GetElementPtrConstantExpr.class, From.$deref());
  }

  public static GetElementPtrConstantExpr cast_GetElementPtrConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_GetElementPtrConstantExpr(From);
    return llvm.cast(GetElementPtrConstantExpr.class, From.$deref());
  }

  public static GetElementPtrConstantExpr cast_or_null_GetElementPtrConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GetElementPtrConstantExpr(From);
  }

  public static GetElementPtrConstantExpr dyn_cast_GetElementPtrConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static GetElementPtrConstantExpr dyn_cast_or_null_GetElementPtrConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static boolean isa_GetElementPtrConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return GetElementPtrConstantExpr.classof(From);
  }

  public static GetElementPtrConstantExpr cast_GetElementPtrConstantExpr(ConstantExpr/*P*/ From) {
    assert isa_GetElementPtrConstantExpr(From);
    return (GetElementPtrConstantExpr) From;
  }

  public static GetElementPtrConstantExpr cast_or_null_GetElementPtrConstantExpr(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_GetElementPtrConstantExpr(From);
  }

  public static GetElementPtrConstantExpr dyn_cast_GetElementPtrConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static GetElementPtrConstantExpr dyn_cast_or_null_GetElementPtrConstantExpr(ConstantExpr/*P*/ From) {
    return (From != null) && isa_GetElementPtrConstantExpr(From) ? cast_GetElementPtrConstantExpr(From) : null;
  }

  public static boolean isa_InsertElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InsertElementConstantExpr.class, From.$star());
  }

  public static InsertElementConstantExpr cast_InsertElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_InsertElementConstantExpr(From);
    return llvm.cast(InsertElementConstantExpr.class, From.$star());
  }

  public static InsertElementConstantExpr cast_or_null_InsertElementConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InsertElementConstantExpr(From);
  }

  public static InsertElementConstantExpr dyn_cast_InsertElementConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static InsertElementConstantExpr dyn_cast_or_null_InsertElementConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static boolean isa_InsertElementConstantExpr(Value/*P*/ From) {
    assert From != null;
    return InsertElementConstantExpr.classof(From);
  }

  public static InsertElementConstantExpr cast_InsertElementConstantExpr(Value/*P*/ From) {
    assert isa_InsertElementConstantExpr(From);
    return (InsertElementConstantExpr) From;
  }

  public static InsertElementConstantExpr cast_or_null_InsertElementConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_InsertElementConstantExpr(From);
  }

  public static InsertElementConstantExpr dyn_cast_InsertElementConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static InsertElementConstantExpr dyn_cast_or_null_InsertElementConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static boolean isa_InsertElementConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InsertElementConstantExpr(From.get());
  }

  public static InsertElementConstantExpr cast_InsertElementConstantExpr(Use/*P*/ From) {
    return cast_InsertElementConstantExpr(From.get());
  }

  public static InsertElementConstantExpr cast_or_null_InsertElementConstantExpr(Use/*P*/ From) {
    return cast_or_null_InsertElementConstantExpr(From.get());
  }

  public static InsertElementConstantExpr dyn_cast_InsertElementConstantExpr(Use/*P*/ From) {
    return isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static InsertElementConstantExpr dyn_cast_or_null_InsertElementConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static boolean isa_InsertElementConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InsertElementConstantExpr.class, From.$deref());
  }

  public static InsertElementConstantExpr cast_InsertElementConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_InsertElementConstantExpr(From);
    return llvm.cast(InsertElementConstantExpr.class, From.$deref());
  }

  public static InsertElementConstantExpr cast_or_null_InsertElementConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InsertElementConstantExpr(From);
  }

  public static InsertElementConstantExpr dyn_cast_InsertElementConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static InsertElementConstantExpr dyn_cast_or_null_InsertElementConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InsertElementConstantExpr(From) ? cast_InsertElementConstantExpr(From) : null;
  }

  public static boolean isa_InsertValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InsertValueConstantExpr.class, From.$star());
  }

  public static InsertValueConstantExpr cast_InsertValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_InsertValueConstantExpr(From);
    return llvm.cast(InsertValueConstantExpr.class, From.$star());
  }

  public static InsertValueConstantExpr cast_or_null_InsertValueConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InsertValueConstantExpr(From);
  }

  public static InsertValueConstantExpr dyn_cast_InsertValueConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static InsertValueConstantExpr dyn_cast_or_null_InsertValueConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static boolean isa_InsertValueConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_InsertValueConstantExpr(From.get());
  }

  public static InsertValueConstantExpr cast_InsertValueConstantExpr(Use/*P*/ From) {
    return cast_InsertValueConstantExpr(From.get());
  }

  public static InsertValueConstantExpr cast_or_null_InsertValueConstantExpr(Use/*P*/ From) {
    return cast_or_null_InsertValueConstantExpr(From.get());
  }

  public static InsertValueConstantExpr dyn_cast_InsertValueConstantExpr(Use/*P*/ From) {
    return isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static InsertValueConstantExpr dyn_cast_or_null_InsertValueConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static boolean isa_InsertValueConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InsertValueConstantExpr.class, From.$deref());
  }

  public static InsertValueConstantExpr cast_InsertValueConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_InsertValueConstantExpr(From);
    return llvm.cast(InsertValueConstantExpr.class, From.$deref());
  }

  public static InsertValueConstantExpr cast_or_null_InsertValueConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InsertValueConstantExpr(From);
  }

  public static InsertValueConstantExpr dyn_cast_InsertValueConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static InsertValueConstantExpr dyn_cast_or_null_InsertValueConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static boolean isa_InsertValueConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return InsertValueConstantExpr.classof(From);
  }

  public static InsertValueConstantExpr cast_InsertValueConstantExpr(ConstantExpr/*P*/ From) {
    assert isa_InsertValueConstantExpr(From);
    return (InsertValueConstantExpr) From;
  }

  public static InsertValueConstantExpr cast_or_null_InsertValueConstantExpr(ConstantExpr/*P*/ From) {
    return (From == null) ? null : cast_InsertValueConstantExpr(From);
  }

  public static InsertValueConstantExpr dyn_cast_InsertValueConstantExpr(ConstantExpr/*P*/ From) {
    assert From != null;
    return isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static InsertValueConstantExpr dyn_cast_or_null_InsertValueConstantExpr(ConstantExpr/*P*/ From) {
    return (From != null) && isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static boolean isa_InsertValueConstantExpr(Value/*P*/ From) {
    assert From != null;
    return InsertValueConstantExpr.classof(From);
  }

  public static InsertValueConstantExpr cast_InsertValueConstantExpr(Value/*P*/ From) {
    assert isa_InsertValueConstantExpr(From);
    return (InsertValueConstantExpr) From;
  }

  public static InsertValueConstantExpr cast_or_null_InsertValueConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_InsertValueConstantExpr(From);
  }

  public static InsertValueConstantExpr dyn_cast_InsertValueConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static InsertValueConstantExpr dyn_cast_or_null_InsertValueConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_InsertValueConstantExpr(From) ? cast_InsertValueConstantExpr(From) : null;
  }

  public static boolean isa_SelectConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SelectConstantExpr.class, From.$star());
  }

  public static SelectConstantExpr cast_SelectConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_SelectConstantExpr(From);
    return llvm.cast(SelectConstantExpr.class, From.$star());
  }

  public static SelectConstantExpr cast_or_null_SelectConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SelectConstantExpr(From);
  }

  public static SelectConstantExpr dyn_cast_SelectConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static SelectConstantExpr dyn_cast_or_null_SelectConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static boolean isa_SelectConstantExpr(Value/*P*/ From) {
    assert From != null;
    return SelectConstantExpr.classof(From);
  }

  public static SelectConstantExpr cast_SelectConstantExpr(Value/*P*/ From) {
    assert isa_SelectConstantExpr(From);
    return (SelectConstantExpr) From;
  }

  public static SelectConstantExpr cast_or_null_SelectConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_SelectConstantExpr(From);
  }

  public static SelectConstantExpr dyn_cast_SelectConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static SelectConstantExpr dyn_cast_or_null_SelectConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static boolean isa_SelectConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_SelectConstantExpr(From.get());
  }

  public static SelectConstantExpr cast_SelectConstantExpr(Use/*P*/ From) {
    return cast_SelectConstantExpr(From.get());
  }

  public static SelectConstantExpr cast_or_null_SelectConstantExpr(Use/*P*/ From) {
    return cast_or_null_SelectConstantExpr(From.get());
  }

  public static SelectConstantExpr dyn_cast_SelectConstantExpr(Use/*P*/ From) {
    return isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static SelectConstantExpr dyn_cast_or_null_SelectConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static boolean isa_SelectConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SelectConstantExpr.class, From.$deref());
  }

  public static SelectConstantExpr cast_SelectConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_SelectConstantExpr(From);
    return llvm.cast(SelectConstantExpr.class, From.$deref());
  }

  public static SelectConstantExpr cast_or_null_SelectConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SelectConstantExpr(From);
  }

  public static SelectConstantExpr dyn_cast_SelectConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static SelectConstantExpr dyn_cast_or_null_SelectConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SelectConstantExpr(From) ? cast_SelectConstantExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ShuffleVectorConstantExpr.class, From.$deref());
  }

  public static ShuffleVectorConstantExpr cast_ShuffleVectorConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_ShuffleVectorConstantExpr(From);
    return llvm.cast(ShuffleVectorConstantExpr.class, From.$deref());
  }

  public static ShuffleVectorConstantExpr cast_or_null_ShuffleVectorConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ShuffleVectorConstantExpr(From);
  }

  public static ShuffleVectorConstantExpr dyn_cast_ShuffleVectorConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static ShuffleVectorConstantExpr dyn_cast_or_null_ShuffleVectorConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_ShuffleVectorConstantExpr(From.get());
  }

  public static ShuffleVectorConstantExpr cast_ShuffleVectorConstantExpr(Use/*P*/ From) {
    return cast_ShuffleVectorConstantExpr(From.get());
  }

  public static ShuffleVectorConstantExpr cast_or_null_ShuffleVectorConstantExpr(Use/*P*/ From) {
    return cast_or_null_ShuffleVectorConstantExpr(From.get());
  }

  public static ShuffleVectorConstantExpr dyn_cast_ShuffleVectorConstantExpr(Use/*P*/ From) {
    return isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static ShuffleVectorConstantExpr dyn_cast_or_null_ShuffleVectorConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ShuffleVectorConstantExpr.class, From.$star());
  }

  public static ShuffleVectorConstantExpr cast_ShuffleVectorConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_ShuffleVectorConstantExpr(From);
    return llvm.cast(ShuffleVectorConstantExpr.class, From.$star());
  }

  public static ShuffleVectorConstantExpr cast_or_null_ShuffleVectorConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ShuffleVectorConstantExpr(From);
  }

  public static ShuffleVectorConstantExpr dyn_cast_ShuffleVectorConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static ShuffleVectorConstantExpr dyn_cast_or_null_ShuffleVectorConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static boolean isa_ShuffleVectorConstantExpr(Value/*P*/ From) {
    assert From != null;
    return ShuffleVectorConstantExpr.classof(From);
  }

  public static ShuffleVectorConstantExpr cast_ShuffleVectorConstantExpr(Value/*P*/ From) {
    assert isa_ShuffleVectorConstantExpr(From);
    return (ShuffleVectorConstantExpr) From;
  }

  public static ShuffleVectorConstantExpr cast_or_null_ShuffleVectorConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_ShuffleVectorConstantExpr(From);
  }

  public static ShuffleVectorConstantExpr dyn_cast_ShuffleVectorConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static ShuffleVectorConstantExpr dyn_cast_or_null_ShuffleVectorConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_ShuffleVectorConstantExpr(From) ? cast_ShuffleVectorConstantExpr(From) : null;
  }

  public static boolean isa_UnaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnaryConstantExpr.class, From.$star());
  }

  public static UnaryConstantExpr cast_UnaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert isa_UnaryConstantExpr(From);
    return llvm.cast(UnaryConstantExpr.class, From.$star());
  }

  public static UnaryConstantExpr cast_or_null_UnaryConstantExpr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnaryConstantExpr(From);
  }

  public static UnaryConstantExpr dyn_cast_UnaryConstantExpr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static UnaryConstantExpr dyn_cast_or_null_UnaryConstantExpr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static boolean isa_UnaryConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnaryConstantExpr.class, From.$deref());
  }

  public static UnaryConstantExpr cast_UnaryConstantExpr(type$ref<?>/*P*/ From) {
    assert isa_UnaryConstantExpr(From);
    return llvm.cast(UnaryConstantExpr.class, From.$deref());
  }

  public static UnaryConstantExpr cast_or_null_UnaryConstantExpr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnaryConstantExpr(From);
  }

  public static UnaryConstantExpr dyn_cast_UnaryConstantExpr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static UnaryConstantExpr dyn_cast_or_null_UnaryConstantExpr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static boolean isa_UnaryConstantExpr(Value/*P*/ From) {
    assert From != null;
    return UnaryConstantExpr.classof(From);
  }

  public static UnaryConstantExpr cast_UnaryConstantExpr(Value/*P*/ From) {
    assert isa_UnaryConstantExpr(From);
    return (UnaryConstantExpr) From;
  }

  public static UnaryConstantExpr cast_or_null_UnaryConstantExpr(Value/*P*/ From) {
    return (From == null) ? null : cast_UnaryConstantExpr(From);
  }

  public static UnaryConstantExpr dyn_cast_UnaryConstantExpr(Value/*P*/ From) {
    assert From != null;
    return isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static UnaryConstantExpr dyn_cast_or_null_UnaryConstantExpr(Value/*P*/ From) {
    return (From != null) && isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static boolean isa_UnaryConstantExpr(Use/*P*/ From) {
    assert From != null && From.get() != null;
    return isa_UnaryConstantExpr(From.get());
  }

  public static UnaryConstantExpr cast_UnaryConstantExpr(Use/*P*/ From) {
    return cast_UnaryConstantExpr(From.get());
  }

  public static UnaryConstantExpr cast_or_null_UnaryConstantExpr(Use/*P*/ From) {
    return cast_or_null_UnaryConstantExpr(From.get());
  }

  public static UnaryConstantExpr dyn_cast_UnaryConstantExpr(Use/*P*/ From) {
    return isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }

  public static UnaryConstantExpr dyn_cast_or_null_UnaryConstantExpr(Use/*P*/ From) {
    return (From != null) && isa_UnaryConstantExpr(From) ? cast_UnaryConstantExpr(From) : null;
  }
}
