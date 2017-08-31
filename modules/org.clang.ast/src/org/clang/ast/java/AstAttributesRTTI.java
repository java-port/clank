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

public class AstAttributesRTTI {
  /*package*/AstAttributesRTTI() {}

  public static boolean isa_AMDGPUNumSGPRAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AMDGPUNumSGPRAttr.class, From.$deref());
  }

  public static AMDGPUNumSGPRAttr cast_AMDGPUNumSGPRAttr(type$ref<?>/*P*/ From) {
    assert isa_AMDGPUNumSGPRAttr(From);
    return llvm.cast(AMDGPUNumSGPRAttr.class, From.$deref());
  }

  public static AMDGPUNumSGPRAttr cast_or_null_AMDGPUNumSGPRAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AMDGPUNumSGPRAttr(From);
  }

  public static AMDGPUNumSGPRAttr dyn_cast_AMDGPUNumSGPRAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static AMDGPUNumSGPRAttr dyn_cast_or_null_AMDGPUNumSGPRAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static boolean isa_AMDGPUNumSGPRAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AMDGPUNumSGPRAttr.class, From.$star());
  }

  public static AMDGPUNumSGPRAttr cast_AMDGPUNumSGPRAttr(type$ptr<?>/*P*/ From) {
    assert isa_AMDGPUNumSGPRAttr(From);
    return llvm.cast(AMDGPUNumSGPRAttr.class, From.$star());
  }

  public static AMDGPUNumSGPRAttr cast_or_null_AMDGPUNumSGPRAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AMDGPUNumSGPRAttr(From);
  }

  public static AMDGPUNumSGPRAttr dyn_cast_AMDGPUNumSGPRAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static AMDGPUNumSGPRAttr dyn_cast_or_null_AMDGPUNumSGPRAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static boolean isa_AMDGPUNumSGPRAttr(Attr/*P*/ From) {
    assert From != null;
    return AMDGPUNumSGPRAttr.classof(From);
  }

  public static AMDGPUNumSGPRAttr cast_AMDGPUNumSGPRAttr(Attr/*P*/ From) {
    assert isa_AMDGPUNumSGPRAttr(From);
    return (AMDGPUNumSGPRAttr) From;
  }

  public static AMDGPUNumSGPRAttr cast_or_null_AMDGPUNumSGPRAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AMDGPUNumSGPRAttr(From);
  }

  public static AMDGPUNumSGPRAttr dyn_cast_AMDGPUNumSGPRAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static AMDGPUNumSGPRAttr dyn_cast_or_null_AMDGPUNumSGPRAttr(Attr/*P*/ From) {
    return (From != null) && isa_AMDGPUNumSGPRAttr(From) ? cast_AMDGPUNumSGPRAttr(From) : null;
  }

  public static boolean isa_AMDGPUNumVGPRAttr(Attr/*P*/ From) {
    assert From != null;
    return AMDGPUNumVGPRAttr.classof(From);
  }

  public static AMDGPUNumVGPRAttr cast_AMDGPUNumVGPRAttr(Attr/*P*/ From) {
    assert isa_AMDGPUNumVGPRAttr(From);
    return (AMDGPUNumVGPRAttr) From;
  }

  public static AMDGPUNumVGPRAttr cast_or_null_AMDGPUNumVGPRAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AMDGPUNumVGPRAttr(From);
  }

  public static AMDGPUNumVGPRAttr dyn_cast_AMDGPUNumVGPRAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static AMDGPUNumVGPRAttr dyn_cast_or_null_AMDGPUNumVGPRAttr(Attr/*P*/ From) {
    return (From != null) && isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static boolean isa_AMDGPUNumVGPRAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AMDGPUNumVGPRAttr.class, From.$star());
  }

  public static AMDGPUNumVGPRAttr cast_AMDGPUNumVGPRAttr(type$ptr<?>/*P*/ From) {
    assert isa_AMDGPUNumVGPRAttr(From);
    return llvm.cast(AMDGPUNumVGPRAttr.class, From.$star());
  }

  public static AMDGPUNumVGPRAttr cast_or_null_AMDGPUNumVGPRAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AMDGPUNumVGPRAttr(From);
  }

  public static AMDGPUNumVGPRAttr dyn_cast_AMDGPUNumVGPRAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static AMDGPUNumVGPRAttr dyn_cast_or_null_AMDGPUNumVGPRAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static boolean isa_AMDGPUNumVGPRAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AMDGPUNumVGPRAttr.class, From.$deref());
  }

  public static AMDGPUNumVGPRAttr cast_AMDGPUNumVGPRAttr(type$ref<?>/*P*/ From) {
    assert isa_AMDGPUNumVGPRAttr(From);
    return llvm.cast(AMDGPUNumVGPRAttr.class, From.$deref());
  }

  public static AMDGPUNumVGPRAttr cast_or_null_AMDGPUNumVGPRAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AMDGPUNumVGPRAttr(From);
  }

  public static AMDGPUNumVGPRAttr dyn_cast_AMDGPUNumVGPRAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static AMDGPUNumVGPRAttr dyn_cast_or_null_AMDGPUNumVGPRAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AMDGPUNumVGPRAttr(From) ? cast_AMDGPUNumVGPRAttr(From) : null;
  }

  public static boolean isa_ARMInterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ARMInterruptAttr.class, From.$star());
  }

  public static ARMInterruptAttr cast_ARMInterruptAttr(type$ptr<?>/*P*/ From) {
    assert isa_ARMInterruptAttr(From);
    return llvm.cast(ARMInterruptAttr.class, From.$star());
  }

  public static ARMInterruptAttr cast_or_null_ARMInterruptAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ARMInterruptAttr(From);
  }

  public static ARMInterruptAttr dyn_cast_ARMInterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static ARMInterruptAttr dyn_cast_or_null_ARMInterruptAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static boolean isa_ARMInterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return ARMInterruptAttr.classof(From);
  }

  public static ARMInterruptAttr cast_ARMInterruptAttr(Attr/*P*/ From) {
    assert isa_ARMInterruptAttr(From);
    return (ARMInterruptAttr) From;
  }

  public static ARMInterruptAttr cast_or_null_ARMInterruptAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ARMInterruptAttr(From);
  }

  public static ARMInterruptAttr dyn_cast_ARMInterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static ARMInterruptAttr dyn_cast_or_null_ARMInterruptAttr(Attr/*P*/ From) {
    return (From != null) && isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static boolean isa_ARMInterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ARMInterruptAttr.class, From.$deref());
  }

  public static ARMInterruptAttr cast_ARMInterruptAttr(type$ref<?>/*P*/ From) {
    assert isa_ARMInterruptAttr(From);
    return llvm.cast(ARMInterruptAttr.class, From.$deref());
  }

  public static ARMInterruptAttr cast_or_null_ARMInterruptAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ARMInterruptAttr(From);
  }

  public static ARMInterruptAttr dyn_cast_ARMInterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static ARMInterruptAttr dyn_cast_or_null_ARMInterruptAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ARMInterruptAttr(From) ? cast_ARMInterruptAttr(From) : null;
  }

  public static boolean isa_AbiTagAttr(Attr/*P*/ From) {
    assert From != null;
    return AbiTagAttr.classof(From);
  }

  public static AbiTagAttr cast_AbiTagAttr(Attr/*P*/ From) {
    assert isa_AbiTagAttr(From);
    return (AbiTagAttr) From;
  }

  public static AbiTagAttr cast_or_null_AbiTagAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AbiTagAttr(From);
  }

  public static AbiTagAttr dyn_cast_AbiTagAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static AbiTagAttr dyn_cast_or_null_AbiTagAttr(Attr/*P*/ From) {
    return (From != null) && isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static boolean isa_AbiTagAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AbiTagAttr.class, From.$star());
  }

  public static AbiTagAttr cast_AbiTagAttr(type$ptr<?>/*P*/ From) {
    assert isa_AbiTagAttr(From);
    return llvm.cast(AbiTagAttr.class, From.$star());
  }

  public static AbiTagAttr cast_or_null_AbiTagAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AbiTagAttr(From);
  }

  public static AbiTagAttr dyn_cast_AbiTagAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static AbiTagAttr dyn_cast_or_null_AbiTagAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static boolean isa_AbiTagAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AbiTagAttr.class, From.$deref());
  }

  public static AbiTagAttr cast_AbiTagAttr(type$ref<?>/*P*/ From) {
    assert isa_AbiTagAttr(From);
    return llvm.cast(AbiTagAttr.class, From.$deref());
  }

  public static AbiTagAttr cast_or_null_AbiTagAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AbiTagAttr(From);
  }

  public static AbiTagAttr dyn_cast_AbiTagAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static AbiTagAttr dyn_cast_or_null_AbiTagAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AbiTagAttr(From) ? cast_AbiTagAttr(From) : null;
  }

  public static boolean isa_AcquireCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return AcquireCapabilityAttr.classof(From);
  }

  public static AcquireCapabilityAttr cast_AcquireCapabilityAttr(Attr/*P*/ From) {
    assert isa_AcquireCapabilityAttr(From);
    return (AcquireCapabilityAttr) From;
  }

  public static AcquireCapabilityAttr cast_or_null_AcquireCapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AcquireCapabilityAttr(From);
  }

  public static AcquireCapabilityAttr dyn_cast_AcquireCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static AcquireCapabilityAttr dyn_cast_or_null_AcquireCapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_AcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AcquireCapabilityAttr.class, From.$star());
  }

  public static AcquireCapabilityAttr cast_AcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_AcquireCapabilityAttr(From);
    return llvm.cast(AcquireCapabilityAttr.class, From.$star());
  }

  public static AcquireCapabilityAttr cast_or_null_AcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AcquireCapabilityAttr(From);
  }

  public static AcquireCapabilityAttr dyn_cast_AcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static AcquireCapabilityAttr dyn_cast_or_null_AcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_AcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AcquireCapabilityAttr.class, From.$deref());
  }

  public static AcquireCapabilityAttr cast_AcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_AcquireCapabilityAttr(From);
    return llvm.cast(AcquireCapabilityAttr.class, From.$deref());
  }

  public static AcquireCapabilityAttr cast_or_null_AcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AcquireCapabilityAttr(From);
  }

  public static AcquireCapabilityAttr dyn_cast_AcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static AcquireCapabilityAttr dyn_cast_or_null_AcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AcquireCapabilityAttr(From) ? cast_AcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_AcquiredAfterAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AcquiredAfterAttr.class, From.$deref());
  }

  public static AcquiredAfterAttr cast_AcquiredAfterAttr(type$ref<?>/*P*/ From) {
    assert isa_AcquiredAfterAttr(From);
    return llvm.cast(AcquiredAfterAttr.class, From.$deref());
  }

  public static AcquiredAfterAttr cast_or_null_AcquiredAfterAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AcquiredAfterAttr(From);
  }

  public static AcquiredAfterAttr dyn_cast_AcquiredAfterAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static AcquiredAfterAttr dyn_cast_or_null_AcquiredAfterAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static boolean isa_AcquiredAfterAttr(Attr/*P*/ From) {
    assert From != null;
    return AcquiredAfterAttr.classof(From);
  }

  public static AcquiredAfterAttr cast_AcquiredAfterAttr(Attr/*P*/ From) {
    assert isa_AcquiredAfterAttr(From);
    return (AcquiredAfterAttr) From;
  }

  public static AcquiredAfterAttr cast_or_null_AcquiredAfterAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AcquiredAfterAttr(From);
  }

  public static AcquiredAfterAttr dyn_cast_AcquiredAfterAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static AcquiredAfterAttr dyn_cast_or_null_AcquiredAfterAttr(Attr/*P*/ From) {
    return (From != null) && isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static boolean isa_AcquiredAfterAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AcquiredAfterAttr.class, From.$star());
  }

  public static AcquiredAfterAttr cast_AcquiredAfterAttr(type$ptr<?>/*P*/ From) {
    assert isa_AcquiredAfterAttr(From);
    return llvm.cast(AcquiredAfterAttr.class, From.$star());
  }

  public static AcquiredAfterAttr cast_or_null_AcquiredAfterAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AcquiredAfterAttr(From);
  }

  public static AcquiredAfterAttr dyn_cast_AcquiredAfterAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static AcquiredAfterAttr dyn_cast_or_null_AcquiredAfterAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AcquiredAfterAttr(From) ? cast_AcquiredAfterAttr(From) : null;
  }

  public static boolean isa_AcquiredBeforeAttr(Attr/*P*/ From) {
    assert From != null;
    return AcquiredBeforeAttr.classof(From);
  }

  public static AcquiredBeforeAttr cast_AcquiredBeforeAttr(Attr/*P*/ From) {
    assert isa_AcquiredBeforeAttr(From);
    return (AcquiredBeforeAttr) From;
  }

  public static AcquiredBeforeAttr cast_or_null_AcquiredBeforeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AcquiredBeforeAttr(From);
  }

  public static AcquiredBeforeAttr dyn_cast_AcquiredBeforeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static AcquiredBeforeAttr dyn_cast_or_null_AcquiredBeforeAttr(Attr/*P*/ From) {
    return (From != null) && isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static boolean isa_AcquiredBeforeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AcquiredBeforeAttr.class, From.$star());
  }

  public static AcquiredBeforeAttr cast_AcquiredBeforeAttr(type$ptr<?>/*P*/ From) {
    assert isa_AcquiredBeforeAttr(From);
    return llvm.cast(AcquiredBeforeAttr.class, From.$star());
  }

  public static AcquiredBeforeAttr cast_or_null_AcquiredBeforeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AcquiredBeforeAttr(From);
  }

  public static AcquiredBeforeAttr dyn_cast_AcquiredBeforeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static AcquiredBeforeAttr dyn_cast_or_null_AcquiredBeforeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static boolean isa_AcquiredBeforeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AcquiredBeforeAttr.class, From.$deref());
  }

  public static AcquiredBeforeAttr cast_AcquiredBeforeAttr(type$ref<?>/*P*/ From) {
    assert isa_AcquiredBeforeAttr(From);
    return llvm.cast(AcquiredBeforeAttr.class, From.$deref());
  }

  public static AcquiredBeforeAttr cast_or_null_AcquiredBeforeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AcquiredBeforeAttr(From);
  }

  public static AcquiredBeforeAttr dyn_cast_AcquiredBeforeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static AcquiredBeforeAttr dyn_cast_or_null_AcquiredBeforeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AcquiredBeforeAttr(From) ? cast_AcquiredBeforeAttr(From) : null;
  }

  public static boolean isa_AliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AliasAttr.class, From.$star());
  }

  public static AliasAttr cast_AliasAttr(type$ptr<?>/*P*/ From) {
    assert isa_AliasAttr(From);
    return llvm.cast(AliasAttr.class, From.$star());
  }

  public static AliasAttr cast_or_null_AliasAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AliasAttr(From);
  }

  public static AliasAttr dyn_cast_AliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static AliasAttr dyn_cast_or_null_AliasAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static boolean isa_AliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AliasAttr.class, From.$deref());
  }

  public static AliasAttr cast_AliasAttr(type$ref<?>/*P*/ From) {
    assert isa_AliasAttr(From);
    return llvm.cast(AliasAttr.class, From.$deref());
  }

  public static AliasAttr cast_or_null_AliasAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AliasAttr(From);
  }

  public static AliasAttr dyn_cast_AliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static AliasAttr dyn_cast_or_null_AliasAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static boolean isa_AliasAttr(Attr/*P*/ From) {
    assert From != null;
    return AliasAttr.classof(From);
  }

  public static AliasAttr cast_AliasAttr(Attr/*P*/ From) {
    assert isa_AliasAttr(From);
    return (AliasAttr) From;
  }

  public static AliasAttr cast_or_null_AliasAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AliasAttr(From);
  }

  public static AliasAttr dyn_cast_AliasAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static AliasAttr dyn_cast_or_null_AliasAttr(Attr/*P*/ From) {
    return (From != null) && isa_AliasAttr(From) ? cast_AliasAttr(From) : null;
  }

  public static boolean isa_AlignMac68kAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AlignMac68kAttr.class, From.$deref());
  }

  public static AlignMac68kAttr cast_AlignMac68kAttr(type$ref<?>/*P*/ From) {
    assert isa_AlignMac68kAttr(From);
    return llvm.cast(AlignMac68kAttr.class, From.$deref());
  }

  public static AlignMac68kAttr cast_or_null_AlignMac68kAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AlignMac68kAttr(From);
  }

  public static AlignMac68kAttr dyn_cast_AlignMac68kAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static AlignMac68kAttr dyn_cast_or_null_AlignMac68kAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static boolean isa_AlignMac68kAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AlignMac68kAttr.class, From.$star());
  }

  public static AlignMac68kAttr cast_AlignMac68kAttr(type$ptr<?>/*P*/ From) {
    assert isa_AlignMac68kAttr(From);
    return llvm.cast(AlignMac68kAttr.class, From.$star());
  }

  public static AlignMac68kAttr cast_or_null_AlignMac68kAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AlignMac68kAttr(From);
  }

  public static AlignMac68kAttr dyn_cast_AlignMac68kAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static AlignMac68kAttr dyn_cast_or_null_AlignMac68kAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static boolean isa_AlignMac68kAttr(Attr/*P*/ From) {
    assert From != null;
    return AlignMac68kAttr.classof(From);
  }

  public static AlignMac68kAttr cast_AlignMac68kAttr(Attr/*P*/ From) {
    assert isa_AlignMac68kAttr(From);
    return (AlignMac68kAttr) From;
  }

  public static AlignMac68kAttr cast_or_null_AlignMac68kAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AlignMac68kAttr(From);
  }

  public static AlignMac68kAttr dyn_cast_AlignMac68kAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static AlignMac68kAttr dyn_cast_or_null_AlignMac68kAttr(Attr/*P*/ From) {
    return (From != null) && isa_AlignMac68kAttr(From) ? cast_AlignMac68kAttr(From) : null;
  }

  public static boolean isa_AlignValueAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AlignValueAttr.class, From.$star());
  }

  public static AlignValueAttr cast_AlignValueAttr(type$ptr<?>/*P*/ From) {
    assert isa_AlignValueAttr(From);
    return llvm.cast(AlignValueAttr.class, From.$star());
  }

  public static AlignValueAttr cast_or_null_AlignValueAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AlignValueAttr(From);
  }

  public static AlignValueAttr dyn_cast_AlignValueAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static AlignValueAttr dyn_cast_or_null_AlignValueAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static boolean isa_AlignValueAttr(Attr/*P*/ From) {
    assert From != null;
    return AlignValueAttr.classof(From);
  }

  public static AlignValueAttr cast_AlignValueAttr(Attr/*P*/ From) {
    assert isa_AlignValueAttr(From);
    return (AlignValueAttr) From;
  }

  public static AlignValueAttr cast_or_null_AlignValueAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AlignValueAttr(From);
  }

  public static AlignValueAttr dyn_cast_AlignValueAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static AlignValueAttr dyn_cast_or_null_AlignValueAttr(Attr/*P*/ From) {
    return (From != null) && isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static boolean isa_AlignValueAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AlignValueAttr.class, From.$deref());
  }

  public static AlignValueAttr cast_AlignValueAttr(type$ref<?>/*P*/ From) {
    assert isa_AlignValueAttr(From);
    return llvm.cast(AlignValueAttr.class, From.$deref());
  }

  public static AlignValueAttr cast_or_null_AlignValueAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AlignValueAttr(From);
  }

  public static AlignValueAttr dyn_cast_AlignValueAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static AlignValueAttr dyn_cast_or_null_AlignValueAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AlignValueAttr(From) ? cast_AlignValueAttr(From) : null;
  }

  public static boolean isa_AlignedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AlignedAttr.class, From.$deref());
  }

  public static AlignedAttr cast_AlignedAttr(type$ref<?>/*P*/ From) {
    assert isa_AlignedAttr(From);
    return llvm.cast(AlignedAttr.class, From.$deref());
  }

  public static AlignedAttr cast_or_null_AlignedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AlignedAttr(From);
  }

  public static AlignedAttr dyn_cast_AlignedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static AlignedAttr dyn_cast_or_null_AlignedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static boolean isa_AlignedAttr(Attr/*P*/ From) {
    assert From != null;
    return AlignedAttr.classof(From);
  }

  public static AlignedAttr cast_AlignedAttr(Attr/*P*/ From) {
    assert isa_AlignedAttr(From);
    return (AlignedAttr) From;
  }

  public static AlignedAttr cast_or_null_AlignedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AlignedAttr(From);
  }

  public static AlignedAttr dyn_cast_AlignedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static AlignedAttr dyn_cast_or_null_AlignedAttr(Attr/*P*/ From) {
    return (From != null) && isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static boolean isa_AlignedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AlignedAttr.class, From.$star());
  }

  public static AlignedAttr cast_AlignedAttr(type$ptr<?>/*P*/ From) {
    assert isa_AlignedAttr(From);
    return llvm.cast(AlignedAttr.class, From.$star());
  }

  public static AlignedAttr cast_or_null_AlignedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AlignedAttr(From);
  }

  public static AlignedAttr dyn_cast_AlignedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static AlignedAttr dyn_cast_or_null_AlignedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AlignedAttr(From) ? cast_AlignedAttr(From) : null;
  }

  public static boolean isa_AlwaysInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AlwaysInlineAttr.class, From.$star());
  }

  public static AlwaysInlineAttr cast_AlwaysInlineAttr(type$ptr<?>/*P*/ From) {
    assert isa_AlwaysInlineAttr(From);
    return llvm.cast(AlwaysInlineAttr.class, From.$star());
  }

  public static AlwaysInlineAttr cast_or_null_AlwaysInlineAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AlwaysInlineAttr(From);
  }

  public static AlwaysInlineAttr dyn_cast_AlwaysInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static AlwaysInlineAttr dyn_cast_or_null_AlwaysInlineAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static boolean isa_AlwaysInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AlwaysInlineAttr.class, From.$deref());
  }

  public static AlwaysInlineAttr cast_AlwaysInlineAttr(type$ref<?>/*P*/ From) {
    assert isa_AlwaysInlineAttr(From);
    return llvm.cast(AlwaysInlineAttr.class, From.$deref());
  }

  public static AlwaysInlineAttr cast_or_null_AlwaysInlineAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AlwaysInlineAttr(From);
  }

  public static AlwaysInlineAttr dyn_cast_AlwaysInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static AlwaysInlineAttr dyn_cast_or_null_AlwaysInlineAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static boolean isa_AlwaysInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return AlwaysInlineAttr.classof(From);
  }

  public static AlwaysInlineAttr cast_AlwaysInlineAttr(Attr/*P*/ From) {
    assert isa_AlwaysInlineAttr(From);
    return (AlwaysInlineAttr) From;
  }

  public static AlwaysInlineAttr cast_or_null_AlwaysInlineAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AlwaysInlineAttr(From);
  }

  public static AlwaysInlineAttr dyn_cast_AlwaysInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static AlwaysInlineAttr dyn_cast_or_null_AlwaysInlineAttr(Attr/*P*/ From) {
    return (From != null) && isa_AlwaysInlineAttr(From) ? cast_AlwaysInlineAttr(From) : null;
  }

  public static boolean isa_AnalyzerNoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return AnalyzerNoReturnAttr.classof(From);
  }

  public static AnalyzerNoReturnAttr cast_AnalyzerNoReturnAttr(Attr/*P*/ From) {
    assert isa_AnalyzerNoReturnAttr(From);
    return (AnalyzerNoReturnAttr) From;
  }

  public static AnalyzerNoReturnAttr cast_or_null_AnalyzerNoReturnAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AnalyzerNoReturnAttr(From);
  }

  public static AnalyzerNoReturnAttr dyn_cast_AnalyzerNoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static AnalyzerNoReturnAttr dyn_cast_or_null_AnalyzerNoReturnAttr(Attr/*P*/ From) {
    return (From != null) && isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static boolean isa_AnalyzerNoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AnalyzerNoReturnAttr.class, From.$deref());
  }

  public static AnalyzerNoReturnAttr cast_AnalyzerNoReturnAttr(type$ref<?>/*P*/ From) {
    assert isa_AnalyzerNoReturnAttr(From);
    return llvm.cast(AnalyzerNoReturnAttr.class, From.$deref());
  }

  public static AnalyzerNoReturnAttr cast_or_null_AnalyzerNoReturnAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AnalyzerNoReturnAttr(From);
  }

  public static AnalyzerNoReturnAttr dyn_cast_AnalyzerNoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static AnalyzerNoReturnAttr dyn_cast_or_null_AnalyzerNoReturnAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static boolean isa_AnalyzerNoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AnalyzerNoReturnAttr.class, From.$star());
  }

  public static AnalyzerNoReturnAttr cast_AnalyzerNoReturnAttr(type$ptr<?>/*P*/ From) {
    assert isa_AnalyzerNoReturnAttr(From);
    return llvm.cast(AnalyzerNoReturnAttr.class, From.$star());
  }

  public static AnalyzerNoReturnAttr cast_or_null_AnalyzerNoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AnalyzerNoReturnAttr(From);
  }

  public static AnalyzerNoReturnAttr dyn_cast_AnalyzerNoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static AnalyzerNoReturnAttr dyn_cast_or_null_AnalyzerNoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AnalyzerNoReturnAttr(From) ? cast_AnalyzerNoReturnAttr(From) : null;
  }

  public static boolean isa_AnnotateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AnnotateAttr.class, From.$deref());
  }

  public static AnnotateAttr cast_AnnotateAttr(type$ref<?>/*P*/ From) {
    assert isa_AnnotateAttr(From);
    return llvm.cast(AnnotateAttr.class, From.$deref());
  }

  public static AnnotateAttr cast_or_null_AnnotateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AnnotateAttr(From);
  }

  public static AnnotateAttr dyn_cast_AnnotateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static AnnotateAttr dyn_cast_or_null_AnnotateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static boolean isa_AnnotateAttr(Attr/*P*/ From) {
    assert From != null;
    return AnnotateAttr.classof(From);
  }

  public static AnnotateAttr cast_AnnotateAttr(Attr/*P*/ From) {
    assert isa_AnnotateAttr(From);
    return (AnnotateAttr) From;
  }

  public static AnnotateAttr cast_or_null_AnnotateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AnnotateAttr(From);
  }

  public static AnnotateAttr dyn_cast_AnnotateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static AnnotateAttr dyn_cast_or_null_AnnotateAttr(Attr/*P*/ From) {
    return (From != null) && isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static boolean isa_AnnotateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AnnotateAttr.class, From.$star());
  }

  public static AnnotateAttr cast_AnnotateAttr(type$ptr<?>/*P*/ From) {
    assert isa_AnnotateAttr(From);
    return llvm.cast(AnnotateAttr.class, From.$star());
  }

  public static AnnotateAttr cast_or_null_AnnotateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AnnotateAttr(From);
  }

  public static AnnotateAttr dyn_cast_AnnotateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static AnnotateAttr dyn_cast_or_null_AnnotateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AnnotateAttr(From) ? cast_AnnotateAttr(From) : null;
  }

  public static boolean isa_AnyX86InterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AnyX86InterruptAttr.class, From.$star());
  }

  public static AnyX86InterruptAttr cast_AnyX86InterruptAttr(type$ptr<?>/*P*/ From) {
    assert isa_AnyX86InterruptAttr(From);
    return llvm.cast(AnyX86InterruptAttr.class, From.$star());
  }

  public static AnyX86InterruptAttr cast_or_null_AnyX86InterruptAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AnyX86InterruptAttr(From);
  }

  public static AnyX86InterruptAttr dyn_cast_AnyX86InterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static AnyX86InterruptAttr dyn_cast_or_null_AnyX86InterruptAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static boolean isa_AnyX86InterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return AnyX86InterruptAttr.classof(From);
  }

  public static AnyX86InterruptAttr cast_AnyX86InterruptAttr(Attr/*P*/ From) {
    assert isa_AnyX86InterruptAttr(From);
    return (AnyX86InterruptAttr) From;
  }

  public static AnyX86InterruptAttr cast_or_null_AnyX86InterruptAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AnyX86InterruptAttr(From);
  }

  public static AnyX86InterruptAttr dyn_cast_AnyX86InterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static AnyX86InterruptAttr dyn_cast_or_null_AnyX86InterruptAttr(Attr/*P*/ From) {
    return (From != null) && isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static boolean isa_AnyX86InterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AnyX86InterruptAttr.class, From.$deref());
  }

  public static AnyX86InterruptAttr cast_AnyX86InterruptAttr(type$ref<?>/*P*/ From) {
    assert isa_AnyX86InterruptAttr(From);
    return llvm.cast(AnyX86InterruptAttr.class, From.$deref());
  }

  public static AnyX86InterruptAttr cast_or_null_AnyX86InterruptAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AnyX86InterruptAttr(From);
  }

  public static AnyX86InterruptAttr dyn_cast_AnyX86InterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static AnyX86InterruptAttr dyn_cast_or_null_AnyX86InterruptAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AnyX86InterruptAttr(From) ? cast_AnyX86InterruptAttr(From) : null;
  }

  public static boolean isa_ArcWeakrefUnavailableAttr(Attr/*P*/ From) {
    assert From != null;
    return ArcWeakrefUnavailableAttr.classof(From);
  }

  public static ArcWeakrefUnavailableAttr cast_ArcWeakrefUnavailableAttr(Attr/*P*/ From) {
    assert isa_ArcWeakrefUnavailableAttr(From);
    return (ArcWeakrefUnavailableAttr) From;
  }

  public static ArcWeakrefUnavailableAttr cast_or_null_ArcWeakrefUnavailableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ArcWeakrefUnavailableAttr(From);
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_ArcWeakrefUnavailableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_or_null_ArcWeakrefUnavailableAttr(Attr/*P*/ From) {
    return (From != null) && isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static boolean isa_ArcWeakrefUnavailableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArcWeakrefUnavailableAttr.class, From.$deref());
  }

  public static ArcWeakrefUnavailableAttr cast_ArcWeakrefUnavailableAttr(type$ref<?>/*P*/ From) {
    assert isa_ArcWeakrefUnavailableAttr(From);
    return llvm.cast(ArcWeakrefUnavailableAttr.class, From.$deref());
  }

  public static ArcWeakrefUnavailableAttr cast_or_null_ArcWeakrefUnavailableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArcWeakrefUnavailableAttr(From);
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_ArcWeakrefUnavailableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_or_null_ArcWeakrefUnavailableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static boolean isa_ArcWeakrefUnavailableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArcWeakrefUnavailableAttr.class, From.$star());
  }

  public static ArcWeakrefUnavailableAttr cast_ArcWeakrefUnavailableAttr(type$ptr<?>/*P*/ From) {
    assert isa_ArcWeakrefUnavailableAttr(From);
    return llvm.cast(ArcWeakrefUnavailableAttr.class, From.$star());
  }

  public static ArcWeakrefUnavailableAttr cast_or_null_ArcWeakrefUnavailableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArcWeakrefUnavailableAttr(From);
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_ArcWeakrefUnavailableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static ArcWeakrefUnavailableAttr dyn_cast_or_null_ArcWeakrefUnavailableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArcWeakrefUnavailableAttr(From) ? cast_ArcWeakrefUnavailableAttr(From) : null;
  }

  public static boolean isa_ArgumentWithTypeTagAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ArgumentWithTypeTagAttr.class, From.$deref());
  }

  public static ArgumentWithTypeTagAttr cast_ArgumentWithTypeTagAttr(type$ref<?>/*P*/ From) {
    assert isa_ArgumentWithTypeTagAttr(From);
    return llvm.cast(ArgumentWithTypeTagAttr.class, From.$deref());
  }

  public static ArgumentWithTypeTagAttr cast_or_null_ArgumentWithTypeTagAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ArgumentWithTypeTagAttr(From);
  }

  public static ArgumentWithTypeTagAttr dyn_cast_ArgumentWithTypeTagAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static ArgumentWithTypeTagAttr dyn_cast_or_null_ArgumentWithTypeTagAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static boolean isa_ArgumentWithTypeTagAttr(Attr/*P*/ From) {
    assert From != null;
    return ArgumentWithTypeTagAttr.classof(From);
  }

  public static ArgumentWithTypeTagAttr cast_ArgumentWithTypeTagAttr(Attr/*P*/ From) {
    assert isa_ArgumentWithTypeTagAttr(From);
    return (ArgumentWithTypeTagAttr) From;
  }

  public static ArgumentWithTypeTagAttr cast_or_null_ArgumentWithTypeTagAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ArgumentWithTypeTagAttr(From);
  }

  public static ArgumentWithTypeTagAttr dyn_cast_ArgumentWithTypeTagAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static ArgumentWithTypeTagAttr dyn_cast_or_null_ArgumentWithTypeTagAttr(Attr/*P*/ From) {
    return (From != null) && isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static boolean isa_ArgumentWithTypeTagAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ArgumentWithTypeTagAttr.class, From.$star());
  }

  public static ArgumentWithTypeTagAttr cast_ArgumentWithTypeTagAttr(type$ptr<?>/*P*/ From) {
    assert isa_ArgumentWithTypeTagAttr(From);
    return llvm.cast(ArgumentWithTypeTagAttr.class, From.$star());
  }

  public static ArgumentWithTypeTagAttr cast_or_null_ArgumentWithTypeTagAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ArgumentWithTypeTagAttr(From);
  }

  public static ArgumentWithTypeTagAttr dyn_cast_ArgumentWithTypeTagAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static ArgumentWithTypeTagAttr dyn_cast_or_null_ArgumentWithTypeTagAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ArgumentWithTypeTagAttr(From) ? cast_ArgumentWithTypeTagAttr(From) : null;
  }

  public static boolean isa_AsmLabelAttr(Attr/*P*/ From) {
    assert From != null;
    return AsmLabelAttr.classof(From);
  }

  public static AsmLabelAttr cast_AsmLabelAttr(Attr/*P*/ From) {
    assert isa_AsmLabelAttr(From);
    return (AsmLabelAttr) From;
  }

  public static AsmLabelAttr cast_or_null_AsmLabelAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AsmLabelAttr(From);
  }

  public static AsmLabelAttr dyn_cast_AsmLabelAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static AsmLabelAttr dyn_cast_or_null_AsmLabelAttr(Attr/*P*/ From) {
    return (From != null) && isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static boolean isa_AsmLabelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AsmLabelAttr.class, From.$deref());
  }

  public static AsmLabelAttr cast_AsmLabelAttr(type$ref<?>/*P*/ From) {
    assert isa_AsmLabelAttr(From);
    return llvm.cast(AsmLabelAttr.class, From.$deref());
  }

  public static AsmLabelAttr cast_or_null_AsmLabelAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AsmLabelAttr(From);
  }

  public static AsmLabelAttr dyn_cast_AsmLabelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static AsmLabelAttr dyn_cast_or_null_AsmLabelAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static boolean isa_AsmLabelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AsmLabelAttr.class, From.$star());
  }

  public static AsmLabelAttr cast_AsmLabelAttr(type$ptr<?>/*P*/ From) {
    assert isa_AsmLabelAttr(From);
    return llvm.cast(AsmLabelAttr.class, From.$star());
  }

  public static AsmLabelAttr cast_or_null_AsmLabelAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AsmLabelAttr(From);
  }

  public static AsmLabelAttr dyn_cast_AsmLabelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static AsmLabelAttr dyn_cast_or_null_AsmLabelAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AsmLabelAttr(From) ? cast_AsmLabelAttr(From) : null;
  }

  public static boolean isa_AssertCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AssertCapabilityAttr.class, From.$deref());
  }

  public static AssertCapabilityAttr cast_AssertCapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_AssertCapabilityAttr(From);
    return llvm.cast(AssertCapabilityAttr.class, From.$deref());
  }

  public static AssertCapabilityAttr cast_or_null_AssertCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AssertCapabilityAttr(From);
  }

  public static AssertCapabilityAttr dyn_cast_AssertCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static AssertCapabilityAttr dyn_cast_or_null_AssertCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static boolean isa_AssertCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return AssertCapabilityAttr.classof(From);
  }

  public static AssertCapabilityAttr cast_AssertCapabilityAttr(Attr/*P*/ From) {
    assert isa_AssertCapabilityAttr(From);
    return (AssertCapabilityAttr) From;
  }

  public static AssertCapabilityAttr cast_or_null_AssertCapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AssertCapabilityAttr(From);
  }

  public static AssertCapabilityAttr dyn_cast_AssertCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static AssertCapabilityAttr dyn_cast_or_null_AssertCapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static boolean isa_AssertCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AssertCapabilityAttr.class, From.$star());
  }

  public static AssertCapabilityAttr cast_AssertCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_AssertCapabilityAttr(From);
    return llvm.cast(AssertCapabilityAttr.class, From.$star());
  }

  public static AssertCapabilityAttr cast_or_null_AssertCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AssertCapabilityAttr(From);
  }

  public static AssertCapabilityAttr dyn_cast_AssertCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static AssertCapabilityAttr dyn_cast_or_null_AssertCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AssertCapabilityAttr(From) ? cast_AssertCapabilityAttr(From) : null;
  }

  public static boolean isa_AssertExclusiveLockAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AssertExclusiveLockAttr.class, From.$deref());
  }

  public static AssertExclusiveLockAttr cast_AssertExclusiveLockAttr(type$ref<?>/*P*/ From) {
    assert isa_AssertExclusiveLockAttr(From);
    return llvm.cast(AssertExclusiveLockAttr.class, From.$deref());
  }

  public static AssertExclusiveLockAttr cast_or_null_AssertExclusiveLockAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AssertExclusiveLockAttr(From);
  }

  public static AssertExclusiveLockAttr dyn_cast_AssertExclusiveLockAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static AssertExclusiveLockAttr dyn_cast_or_null_AssertExclusiveLockAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static boolean isa_AssertExclusiveLockAttr(Attr/*P*/ From) {
    assert From != null;
    return AssertExclusiveLockAttr.classof(From);
  }

  public static AssertExclusiveLockAttr cast_AssertExclusiveLockAttr(Attr/*P*/ From) {
    assert isa_AssertExclusiveLockAttr(From);
    return (AssertExclusiveLockAttr) From;
  }

  public static AssertExclusiveLockAttr cast_or_null_AssertExclusiveLockAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AssertExclusiveLockAttr(From);
  }

  public static AssertExclusiveLockAttr dyn_cast_AssertExclusiveLockAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static AssertExclusiveLockAttr dyn_cast_or_null_AssertExclusiveLockAttr(Attr/*P*/ From) {
    return (From != null) && isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static boolean isa_AssertExclusiveLockAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AssertExclusiveLockAttr.class, From.$star());
  }

  public static AssertExclusiveLockAttr cast_AssertExclusiveLockAttr(type$ptr<?>/*P*/ From) {
    assert isa_AssertExclusiveLockAttr(From);
    return llvm.cast(AssertExclusiveLockAttr.class, From.$star());
  }

  public static AssertExclusiveLockAttr cast_or_null_AssertExclusiveLockAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AssertExclusiveLockAttr(From);
  }

  public static AssertExclusiveLockAttr dyn_cast_AssertExclusiveLockAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static AssertExclusiveLockAttr dyn_cast_or_null_AssertExclusiveLockAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AssertExclusiveLockAttr(From) ? cast_AssertExclusiveLockAttr(From) : null;
  }

  public static boolean isa_AssertSharedLockAttr(Attr/*P*/ From) {
    assert From != null;
    return AssertSharedLockAttr.classof(From);
  }

  public static AssertSharedLockAttr cast_AssertSharedLockAttr(Attr/*P*/ From) {
    assert isa_AssertSharedLockAttr(From);
    return (AssertSharedLockAttr) From;
  }

  public static AssertSharedLockAttr cast_or_null_AssertSharedLockAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AssertSharedLockAttr(From);
  }

  public static AssertSharedLockAttr dyn_cast_AssertSharedLockAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static AssertSharedLockAttr dyn_cast_or_null_AssertSharedLockAttr(Attr/*P*/ From) {
    return (From != null) && isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static boolean isa_AssertSharedLockAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AssertSharedLockAttr.class, From.$star());
  }

  public static AssertSharedLockAttr cast_AssertSharedLockAttr(type$ptr<?>/*P*/ From) {
    assert isa_AssertSharedLockAttr(From);
    return llvm.cast(AssertSharedLockAttr.class, From.$star());
  }

  public static AssertSharedLockAttr cast_or_null_AssertSharedLockAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AssertSharedLockAttr(From);
  }

  public static AssertSharedLockAttr dyn_cast_AssertSharedLockAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static AssertSharedLockAttr dyn_cast_or_null_AssertSharedLockAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static boolean isa_AssertSharedLockAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AssertSharedLockAttr.class, From.$deref());
  }

  public static AssertSharedLockAttr cast_AssertSharedLockAttr(type$ref<?>/*P*/ From) {
    assert isa_AssertSharedLockAttr(From);
    return llvm.cast(AssertSharedLockAttr.class, From.$deref());
  }

  public static AssertSharedLockAttr cast_or_null_AssertSharedLockAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AssertSharedLockAttr(From);
  }

  public static AssertSharedLockAttr dyn_cast_AssertSharedLockAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static AssertSharedLockAttr dyn_cast_or_null_AssertSharedLockAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AssertSharedLockAttr(From) ? cast_AssertSharedLockAttr(From) : null;
  }

  public static boolean isa_AssumeAlignedAttr(Attr/*P*/ From) {
    assert From != null;
    return AssumeAlignedAttr.classof(From);
  }

  public static AssumeAlignedAttr cast_AssumeAlignedAttr(Attr/*P*/ From) {
    assert isa_AssumeAlignedAttr(From);
    return (AssumeAlignedAttr) From;
  }

  public static AssumeAlignedAttr cast_or_null_AssumeAlignedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AssumeAlignedAttr(From);
  }

  public static AssumeAlignedAttr dyn_cast_AssumeAlignedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static AssumeAlignedAttr dyn_cast_or_null_AssumeAlignedAttr(Attr/*P*/ From) {
    return (From != null) && isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static boolean isa_AssumeAlignedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AssumeAlignedAttr.class, From.$star());
  }

  public static AssumeAlignedAttr cast_AssumeAlignedAttr(type$ptr<?>/*P*/ From) {
    assert isa_AssumeAlignedAttr(From);
    return llvm.cast(AssumeAlignedAttr.class, From.$star());
  }

  public static AssumeAlignedAttr cast_or_null_AssumeAlignedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AssumeAlignedAttr(From);
  }

  public static AssumeAlignedAttr dyn_cast_AssumeAlignedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static AssumeAlignedAttr dyn_cast_or_null_AssumeAlignedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static boolean isa_AssumeAlignedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AssumeAlignedAttr.class, From.$deref());
  }

  public static AssumeAlignedAttr cast_AssumeAlignedAttr(type$ref<?>/*P*/ From) {
    assert isa_AssumeAlignedAttr(From);
    return llvm.cast(AssumeAlignedAttr.class, From.$deref());
  }

  public static AssumeAlignedAttr cast_or_null_AssumeAlignedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AssumeAlignedAttr(From);
  }

  public static AssumeAlignedAttr dyn_cast_AssumeAlignedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static AssumeAlignedAttr dyn_cast_or_null_AssumeAlignedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AssumeAlignedAttr(From) ? cast_AssumeAlignedAttr(From) : null;
  }

  public static boolean isa_Attr(Attr/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Attr cast_Attr(Attr/*P*/ From) {
    assert isa_Attr(From);
    return (Attr) From;
  }

  public static Attr cast_or_null_Attr(Attr/*P*/ From) {
    return (From == null) ? null : cast_Attr(From);
  }

  public static Attr dyn_cast_Attr(Attr/*P*/ From) {
    assert From != null;
    return isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static Attr dyn_cast_or_null_Attr(Attr/*P*/ From) {
    return (From != null) && isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static boolean isa_Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Attr.class, From.$deref());
  }

  public static Attr cast_Attr(type$ref<?>/*P*/ From) {
    assert isa_Attr(From);
    return llvm.cast(Attr.class, From.$deref());
  }

  public static Attr cast_or_null_Attr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Attr(From);
  }

  public static Attr dyn_cast_Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static Attr dyn_cast_or_null_Attr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static boolean isa_Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Attr.class, From.$star());
  }

  public static Attr cast_Attr(type$ptr<?>/*P*/ From) {
    assert isa_Attr(From);
    return llvm.cast(Attr.class, From.$star());
  }

  public static Attr cast_or_null_Attr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Attr(From);
  }

  public static Attr dyn_cast_Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static Attr dyn_cast_or_null_Attr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Attr(From) ? cast_Attr(From) : null;
  }

  public static boolean isa_AvailabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(AvailabilityAttr.class, From.$star());
  }

  public static AvailabilityAttr cast_AvailabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_AvailabilityAttr(From);
    return llvm.cast(AvailabilityAttr.class, From.$star());
  }

  public static AvailabilityAttr cast_or_null_AvailabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_AvailabilityAttr(From);
  }

  public static AvailabilityAttr dyn_cast_AvailabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static AvailabilityAttr dyn_cast_or_null_AvailabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static boolean isa_AvailabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(AvailabilityAttr.class, From.$deref());
  }

  public static AvailabilityAttr cast_AvailabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_AvailabilityAttr(From);
    return llvm.cast(AvailabilityAttr.class, From.$deref());
  }

  public static AvailabilityAttr cast_or_null_AvailabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_AvailabilityAttr(From);
  }

  public static AvailabilityAttr dyn_cast_AvailabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static AvailabilityAttr dyn_cast_or_null_AvailabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static boolean isa_AvailabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return AvailabilityAttr.classof(From);
  }

  public static AvailabilityAttr cast_AvailabilityAttr(Attr/*P*/ From) {
    assert isa_AvailabilityAttr(From);
    return (AvailabilityAttr) From;
  }

  public static AvailabilityAttr cast_or_null_AvailabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_AvailabilityAttr(From);
  }

  public static AvailabilityAttr dyn_cast_AvailabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static AvailabilityAttr dyn_cast_or_null_AvailabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_AvailabilityAttr(From) ? cast_AvailabilityAttr(From) : null;
  }

  public static boolean isa_BlocksAttr(Attr/*P*/ From) {
    assert From != null;
    return BlocksAttr.classof(From);
  }

  public static BlocksAttr cast_BlocksAttr(Attr/*P*/ From) {
    assert isa_BlocksAttr(From);
    return (BlocksAttr) From;
  }

  public static BlocksAttr cast_or_null_BlocksAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_BlocksAttr(From);
  }

  public static BlocksAttr dyn_cast_BlocksAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static BlocksAttr dyn_cast_or_null_BlocksAttr(Attr/*P*/ From) {
    return (From != null) && isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static boolean isa_BlocksAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(BlocksAttr.class, From.$star());
  }

  public static BlocksAttr cast_BlocksAttr(type$ptr<?>/*P*/ From) {
    assert isa_BlocksAttr(From);
    return llvm.cast(BlocksAttr.class, From.$star());
  }

  public static BlocksAttr cast_or_null_BlocksAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_BlocksAttr(From);
  }

  public static BlocksAttr dyn_cast_BlocksAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static BlocksAttr dyn_cast_or_null_BlocksAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static boolean isa_BlocksAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(BlocksAttr.class, From.$deref());
  }

  public static BlocksAttr cast_BlocksAttr(type$ref<?>/*P*/ From) {
    assert isa_BlocksAttr(From);
    return llvm.cast(BlocksAttr.class, From.$deref());
  }

  public static BlocksAttr cast_or_null_BlocksAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_BlocksAttr(From);
  }

  public static BlocksAttr dyn_cast_BlocksAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static BlocksAttr dyn_cast_or_null_BlocksAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_BlocksAttr(From) ? cast_BlocksAttr(From) : null;
  }

  public static boolean isa_C11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(C11NoReturnAttr.class, From.$deref());
  }

  public static C11NoReturnAttr cast_C11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert isa_C11NoReturnAttr(From);
    return llvm.cast(C11NoReturnAttr.class, From.$deref());
  }

  public static C11NoReturnAttr cast_or_null_C11NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_C11NoReturnAttr(From);
  }

  public static C11NoReturnAttr dyn_cast_C11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static C11NoReturnAttr dyn_cast_or_null_C11NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static boolean isa_C11NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return C11NoReturnAttr.classof(From);
  }

  public static C11NoReturnAttr cast_C11NoReturnAttr(Attr/*P*/ From) {
    assert isa_C11NoReturnAttr(From);
    return (C11NoReturnAttr) From;
  }

  public static C11NoReturnAttr cast_or_null_C11NoReturnAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_C11NoReturnAttr(From);
  }

  public static C11NoReturnAttr dyn_cast_C11NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static C11NoReturnAttr dyn_cast_or_null_C11NoReturnAttr(Attr/*P*/ From) {
    return (From != null) && isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static boolean isa_C11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(C11NoReturnAttr.class, From.$star());
  }

  public static C11NoReturnAttr cast_C11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert isa_C11NoReturnAttr(From);
    return llvm.cast(C11NoReturnAttr.class, From.$star());
  }

  public static C11NoReturnAttr cast_or_null_C11NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_C11NoReturnAttr(From);
  }

  public static C11NoReturnAttr dyn_cast_C11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static C11NoReturnAttr dyn_cast_or_null_C11NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_C11NoReturnAttr(From) ? cast_C11NoReturnAttr(From) : null;
  }

  public static boolean isa_CDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return CDeclAttr.classof(From);
  }

  public static CDeclAttr cast_CDeclAttr(Attr/*P*/ From) {
    assert isa_CDeclAttr(From);
    return (CDeclAttr) From;
  }

  public static CDeclAttr cast_or_null_CDeclAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CDeclAttr(From);
  }

  public static CDeclAttr dyn_cast_CDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static CDeclAttr dyn_cast_or_null_CDeclAttr(Attr/*P*/ From) {
    return (From != null) && isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static boolean isa_CDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CDeclAttr.class, From.$star());
  }

  public static CDeclAttr cast_CDeclAttr(type$ptr<?>/*P*/ From) {
    assert isa_CDeclAttr(From);
    return llvm.cast(CDeclAttr.class, From.$star());
  }

  public static CDeclAttr cast_or_null_CDeclAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CDeclAttr(From);
  }

  public static CDeclAttr dyn_cast_CDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static CDeclAttr dyn_cast_or_null_CDeclAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static boolean isa_CDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CDeclAttr.class, From.$deref());
  }

  public static CDeclAttr cast_CDeclAttr(type$ref<?>/*P*/ From) {
    assert isa_CDeclAttr(From);
    return llvm.cast(CDeclAttr.class, From.$deref());
  }

  public static CDeclAttr cast_or_null_CDeclAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CDeclAttr(From);
  }

  public static CDeclAttr dyn_cast_CDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static CDeclAttr dyn_cast_or_null_CDeclAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CDeclAttr(From) ? cast_CDeclAttr(From) : null;
  }

  public static boolean isa_CFAuditedTransferAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CFAuditedTransferAttr.class, From.$deref());
  }

  public static CFAuditedTransferAttr cast_CFAuditedTransferAttr(type$ref<?>/*P*/ From) {
    assert isa_CFAuditedTransferAttr(From);
    return llvm.cast(CFAuditedTransferAttr.class, From.$deref());
  }

  public static CFAuditedTransferAttr cast_or_null_CFAuditedTransferAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CFAuditedTransferAttr(From);
  }

  public static CFAuditedTransferAttr dyn_cast_CFAuditedTransferAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static CFAuditedTransferAttr dyn_cast_or_null_CFAuditedTransferAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static boolean isa_CFAuditedTransferAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CFAuditedTransferAttr.class, From.$star());
  }

  public static CFAuditedTransferAttr cast_CFAuditedTransferAttr(type$ptr<?>/*P*/ From) {
    assert isa_CFAuditedTransferAttr(From);
    return llvm.cast(CFAuditedTransferAttr.class, From.$star());
  }

  public static CFAuditedTransferAttr cast_or_null_CFAuditedTransferAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CFAuditedTransferAttr(From);
  }

  public static CFAuditedTransferAttr dyn_cast_CFAuditedTransferAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static CFAuditedTransferAttr dyn_cast_or_null_CFAuditedTransferAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static boolean isa_CFAuditedTransferAttr(Attr/*P*/ From) {
    assert From != null;
    return CFAuditedTransferAttr.classof(From);
  }

  public static CFAuditedTransferAttr cast_CFAuditedTransferAttr(Attr/*P*/ From) {
    assert isa_CFAuditedTransferAttr(From);
    return (CFAuditedTransferAttr) From;
  }

  public static CFAuditedTransferAttr cast_or_null_CFAuditedTransferAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CFAuditedTransferAttr(From);
  }

  public static CFAuditedTransferAttr dyn_cast_CFAuditedTransferAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static CFAuditedTransferAttr dyn_cast_or_null_CFAuditedTransferAttr(Attr/*P*/ From) {
    return (From != null) && isa_CFAuditedTransferAttr(From) ? cast_CFAuditedTransferAttr(From) : null;
  }

  public static boolean isa_CFConsumedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CFConsumedAttr.class, From.$star());
  }

  public static CFConsumedAttr cast_CFConsumedAttr(type$ptr<?>/*P*/ From) {
    assert isa_CFConsumedAttr(From);
    return llvm.cast(CFConsumedAttr.class, From.$star());
  }

  public static CFConsumedAttr cast_or_null_CFConsumedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CFConsumedAttr(From);
  }

  public static CFConsumedAttr dyn_cast_CFConsumedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static CFConsumedAttr dyn_cast_or_null_CFConsumedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static boolean isa_CFConsumedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CFConsumedAttr.class, From.$deref());
  }

  public static CFConsumedAttr cast_CFConsumedAttr(type$ref<?>/*P*/ From) {
    assert isa_CFConsumedAttr(From);
    return llvm.cast(CFConsumedAttr.class, From.$deref());
  }

  public static CFConsumedAttr cast_or_null_CFConsumedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CFConsumedAttr(From);
  }

  public static CFConsumedAttr dyn_cast_CFConsumedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static CFConsumedAttr dyn_cast_or_null_CFConsumedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static boolean isa_CFConsumedAttr(Attr/*P*/ From) {
    assert From != null;
    return CFConsumedAttr.classof(From);
  }

  public static CFConsumedAttr cast_CFConsumedAttr(Attr/*P*/ From) {
    assert isa_CFConsumedAttr(From);
    return (CFConsumedAttr) From;
  }

  public static CFConsumedAttr cast_or_null_CFConsumedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CFConsumedAttr(From);
  }

  public static CFConsumedAttr dyn_cast_CFConsumedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static CFConsumedAttr dyn_cast_or_null_CFConsumedAttr(Attr/*P*/ From) {
    return (From != null) && isa_CFConsumedAttr(From) ? cast_CFConsumedAttr(From) : null;
  }

  public static boolean isa_CFReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CFReturnsNotRetainedAttr.class, From.$star());
  }

  public static CFReturnsNotRetainedAttr cast_CFReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert isa_CFReturnsNotRetainedAttr(From);
    return llvm.cast(CFReturnsNotRetainedAttr.class, From.$star());
  }

  public static CFReturnsNotRetainedAttr cast_or_null_CFReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CFReturnsNotRetainedAttr(From);
  }

  public static CFReturnsNotRetainedAttr dyn_cast_CFReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static CFReturnsNotRetainedAttr dyn_cast_or_null_CFReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_CFReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CFReturnsNotRetainedAttr.class, From.$deref());
  }

  public static CFReturnsNotRetainedAttr cast_CFReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert isa_CFReturnsNotRetainedAttr(From);
    return llvm.cast(CFReturnsNotRetainedAttr.class, From.$deref());
  }

  public static CFReturnsNotRetainedAttr cast_or_null_CFReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CFReturnsNotRetainedAttr(From);
  }

  public static CFReturnsNotRetainedAttr dyn_cast_CFReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static CFReturnsNotRetainedAttr dyn_cast_or_null_CFReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_CFReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return CFReturnsNotRetainedAttr.classof(From);
  }

  public static CFReturnsNotRetainedAttr cast_CFReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert isa_CFReturnsNotRetainedAttr(From);
    return (CFReturnsNotRetainedAttr) From;
  }

  public static CFReturnsNotRetainedAttr cast_or_null_CFReturnsNotRetainedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CFReturnsNotRetainedAttr(From);
  }

  public static CFReturnsNotRetainedAttr dyn_cast_CFReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static CFReturnsNotRetainedAttr dyn_cast_or_null_CFReturnsNotRetainedAttr(Attr/*P*/ From) {
    return (From != null) && isa_CFReturnsNotRetainedAttr(From) ? cast_CFReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_CFReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CFReturnsRetainedAttr.class, From.$star());
  }

  public static CFReturnsRetainedAttr cast_CFReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert isa_CFReturnsRetainedAttr(From);
    return llvm.cast(CFReturnsRetainedAttr.class, From.$star());
  }

  public static CFReturnsRetainedAttr cast_or_null_CFReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CFReturnsRetainedAttr(From);
  }

  public static CFReturnsRetainedAttr dyn_cast_CFReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static CFReturnsRetainedAttr dyn_cast_or_null_CFReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_CFReturnsRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return CFReturnsRetainedAttr.classof(From);
  }

  public static CFReturnsRetainedAttr cast_CFReturnsRetainedAttr(Attr/*P*/ From) {
    assert isa_CFReturnsRetainedAttr(From);
    return (CFReturnsRetainedAttr) From;
  }

  public static CFReturnsRetainedAttr cast_or_null_CFReturnsRetainedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CFReturnsRetainedAttr(From);
  }

  public static CFReturnsRetainedAttr dyn_cast_CFReturnsRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static CFReturnsRetainedAttr dyn_cast_or_null_CFReturnsRetainedAttr(Attr/*P*/ From) {
    return (From != null) && isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_CFReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CFReturnsRetainedAttr.class, From.$deref());
  }

  public static CFReturnsRetainedAttr cast_CFReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert isa_CFReturnsRetainedAttr(From);
    return llvm.cast(CFReturnsRetainedAttr.class, From.$deref());
  }

  public static CFReturnsRetainedAttr cast_or_null_CFReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CFReturnsRetainedAttr(From);
  }

  public static CFReturnsRetainedAttr dyn_cast_CFReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static CFReturnsRetainedAttr dyn_cast_or_null_CFReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CFReturnsRetainedAttr(From) ? cast_CFReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_CFUnknownTransferAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CFUnknownTransferAttr.class, From.$deref());
  }

  public static CFUnknownTransferAttr cast_CFUnknownTransferAttr(type$ref<?>/*P*/ From) {
    assert isa_CFUnknownTransferAttr(From);
    return llvm.cast(CFUnknownTransferAttr.class, From.$deref());
  }

  public static CFUnknownTransferAttr cast_or_null_CFUnknownTransferAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CFUnknownTransferAttr(From);
  }

  public static CFUnknownTransferAttr dyn_cast_CFUnknownTransferAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static CFUnknownTransferAttr dyn_cast_or_null_CFUnknownTransferAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static boolean isa_CFUnknownTransferAttr(Attr/*P*/ From) {
    assert From != null;
    return CFUnknownTransferAttr.classof(From);
  }

  public static CFUnknownTransferAttr cast_CFUnknownTransferAttr(Attr/*P*/ From) {
    assert isa_CFUnknownTransferAttr(From);
    return (CFUnknownTransferAttr) From;
  }

  public static CFUnknownTransferAttr cast_or_null_CFUnknownTransferAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CFUnknownTransferAttr(From);
  }

  public static CFUnknownTransferAttr dyn_cast_CFUnknownTransferAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static CFUnknownTransferAttr dyn_cast_or_null_CFUnknownTransferAttr(Attr/*P*/ From) {
    return (From != null) && isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static boolean isa_CFUnknownTransferAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CFUnknownTransferAttr.class, From.$star());
  }

  public static CFUnknownTransferAttr cast_CFUnknownTransferAttr(type$ptr<?>/*P*/ From) {
    assert isa_CFUnknownTransferAttr(From);
    return llvm.cast(CFUnknownTransferAttr.class, From.$star());
  }

  public static CFUnknownTransferAttr cast_or_null_CFUnknownTransferAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CFUnknownTransferAttr(From);
  }

  public static CFUnknownTransferAttr dyn_cast_CFUnknownTransferAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static CFUnknownTransferAttr dyn_cast_or_null_CFUnknownTransferAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CFUnknownTransferAttr(From) ? cast_CFUnknownTransferAttr(From) : null;
  }

  public static boolean isa_CUDAConstantAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDAConstantAttr.class, From.$deref());
  }

  public static CUDAConstantAttr cast_CUDAConstantAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDAConstantAttr(From);
    return llvm.cast(CUDAConstantAttr.class, From.$deref());
  }

  public static CUDAConstantAttr cast_or_null_CUDAConstantAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDAConstantAttr(From);
  }

  public static CUDAConstantAttr dyn_cast_CUDAConstantAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static CUDAConstantAttr dyn_cast_or_null_CUDAConstantAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static boolean isa_CUDAConstantAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDAConstantAttr.classof(From);
  }

  public static CUDAConstantAttr cast_CUDAConstantAttr(Attr/*P*/ From) {
    assert isa_CUDAConstantAttr(From);
    return (CUDAConstantAttr) From;
  }

  public static CUDAConstantAttr cast_or_null_CUDAConstantAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDAConstantAttr(From);
  }

  public static CUDAConstantAttr dyn_cast_CUDAConstantAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static CUDAConstantAttr dyn_cast_or_null_CUDAConstantAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static boolean isa_CUDAConstantAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDAConstantAttr.class, From.$star());
  }

  public static CUDAConstantAttr cast_CUDAConstantAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDAConstantAttr(From);
    return llvm.cast(CUDAConstantAttr.class, From.$star());
  }

  public static CUDAConstantAttr cast_or_null_CUDAConstantAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDAConstantAttr(From);
  }

  public static CUDAConstantAttr dyn_cast_CUDAConstantAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static CUDAConstantAttr dyn_cast_or_null_CUDAConstantAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDAConstantAttr(From) ? cast_CUDAConstantAttr(From) : null;
  }

  public static boolean isa_CUDADeviceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDADeviceAttr.class, From.$deref());
  }

  public static CUDADeviceAttr cast_CUDADeviceAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDADeviceAttr(From);
    return llvm.cast(CUDADeviceAttr.class, From.$deref());
  }

  public static CUDADeviceAttr cast_or_null_CUDADeviceAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDADeviceAttr(From);
  }

  public static CUDADeviceAttr dyn_cast_CUDADeviceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static CUDADeviceAttr dyn_cast_or_null_CUDADeviceAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static boolean isa_CUDADeviceAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDADeviceAttr.classof(From);
  }

  public static CUDADeviceAttr cast_CUDADeviceAttr(Attr/*P*/ From) {
    assert isa_CUDADeviceAttr(From);
    return (CUDADeviceAttr) From;
  }

  public static CUDADeviceAttr cast_or_null_CUDADeviceAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDADeviceAttr(From);
  }

  public static CUDADeviceAttr dyn_cast_CUDADeviceAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static CUDADeviceAttr dyn_cast_or_null_CUDADeviceAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static boolean isa_CUDADeviceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDADeviceAttr.class, From.$star());
  }

  public static CUDADeviceAttr cast_CUDADeviceAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDADeviceAttr(From);
    return llvm.cast(CUDADeviceAttr.class, From.$star());
  }

  public static CUDADeviceAttr cast_or_null_CUDADeviceAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDADeviceAttr(From);
  }

  public static CUDADeviceAttr dyn_cast_CUDADeviceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static CUDADeviceAttr dyn_cast_or_null_CUDADeviceAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDADeviceAttr(From) ? cast_CUDADeviceAttr(From) : null;
  }

  public static boolean isa_CUDAGlobalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDAGlobalAttr.class, From.$deref());
  }

  public static CUDAGlobalAttr cast_CUDAGlobalAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDAGlobalAttr(From);
    return llvm.cast(CUDAGlobalAttr.class, From.$deref());
  }

  public static CUDAGlobalAttr cast_or_null_CUDAGlobalAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDAGlobalAttr(From);
  }

  public static CUDAGlobalAttr dyn_cast_CUDAGlobalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static CUDAGlobalAttr dyn_cast_or_null_CUDAGlobalAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static boolean isa_CUDAGlobalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDAGlobalAttr.class, From.$star());
  }

  public static CUDAGlobalAttr cast_CUDAGlobalAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDAGlobalAttr(From);
    return llvm.cast(CUDAGlobalAttr.class, From.$star());
  }

  public static CUDAGlobalAttr cast_or_null_CUDAGlobalAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDAGlobalAttr(From);
  }

  public static CUDAGlobalAttr dyn_cast_CUDAGlobalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static CUDAGlobalAttr dyn_cast_or_null_CUDAGlobalAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static boolean isa_CUDAGlobalAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDAGlobalAttr.classof(From);
  }

  public static CUDAGlobalAttr cast_CUDAGlobalAttr(Attr/*P*/ From) {
    assert isa_CUDAGlobalAttr(From);
    return (CUDAGlobalAttr) From;
  }

  public static CUDAGlobalAttr cast_or_null_CUDAGlobalAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDAGlobalAttr(From);
  }

  public static CUDAGlobalAttr dyn_cast_CUDAGlobalAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static CUDAGlobalAttr dyn_cast_or_null_CUDAGlobalAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDAGlobalAttr(From) ? cast_CUDAGlobalAttr(From) : null;
  }

  public static boolean isa_CUDAHostAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDAHostAttr.classof(From);
  }

  public static CUDAHostAttr cast_CUDAHostAttr(Attr/*P*/ From) {
    assert isa_CUDAHostAttr(From);
    return (CUDAHostAttr) From;
  }

  public static CUDAHostAttr cast_or_null_CUDAHostAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDAHostAttr(From);
  }

  public static CUDAHostAttr dyn_cast_CUDAHostAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static CUDAHostAttr dyn_cast_or_null_CUDAHostAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static boolean isa_CUDAHostAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDAHostAttr.class, From.$star());
  }

  public static CUDAHostAttr cast_CUDAHostAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDAHostAttr(From);
    return llvm.cast(CUDAHostAttr.class, From.$star());
  }

  public static CUDAHostAttr cast_or_null_CUDAHostAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDAHostAttr(From);
  }

  public static CUDAHostAttr dyn_cast_CUDAHostAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static CUDAHostAttr dyn_cast_or_null_CUDAHostAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static boolean isa_CUDAHostAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDAHostAttr.class, From.$deref());
  }

  public static CUDAHostAttr cast_CUDAHostAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDAHostAttr(From);
    return llvm.cast(CUDAHostAttr.class, From.$deref());
  }

  public static CUDAHostAttr cast_or_null_CUDAHostAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDAHostAttr(From);
  }

  public static CUDAHostAttr dyn_cast_CUDAHostAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static CUDAHostAttr dyn_cast_or_null_CUDAHostAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDAHostAttr(From) ? cast_CUDAHostAttr(From) : null;
  }

  public static boolean isa_CUDAInvalidTargetAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDAInvalidTargetAttr.classof(From);
  }

  public static CUDAInvalidTargetAttr cast_CUDAInvalidTargetAttr(Attr/*P*/ From) {
    assert isa_CUDAInvalidTargetAttr(From);
    return (CUDAInvalidTargetAttr) From;
  }

  public static CUDAInvalidTargetAttr cast_or_null_CUDAInvalidTargetAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDAInvalidTargetAttr(From);
  }

  public static CUDAInvalidTargetAttr dyn_cast_CUDAInvalidTargetAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static CUDAInvalidTargetAttr dyn_cast_or_null_CUDAInvalidTargetAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static boolean isa_CUDAInvalidTargetAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDAInvalidTargetAttr.class, From.$star());
  }

  public static CUDAInvalidTargetAttr cast_CUDAInvalidTargetAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDAInvalidTargetAttr(From);
    return llvm.cast(CUDAInvalidTargetAttr.class, From.$star());
  }

  public static CUDAInvalidTargetAttr cast_or_null_CUDAInvalidTargetAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDAInvalidTargetAttr(From);
  }

  public static CUDAInvalidTargetAttr dyn_cast_CUDAInvalidTargetAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static CUDAInvalidTargetAttr dyn_cast_or_null_CUDAInvalidTargetAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static boolean isa_CUDAInvalidTargetAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDAInvalidTargetAttr.class, From.$deref());
  }

  public static CUDAInvalidTargetAttr cast_CUDAInvalidTargetAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDAInvalidTargetAttr(From);
    return llvm.cast(CUDAInvalidTargetAttr.class, From.$deref());
  }

  public static CUDAInvalidTargetAttr cast_or_null_CUDAInvalidTargetAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDAInvalidTargetAttr(From);
  }

  public static CUDAInvalidTargetAttr dyn_cast_CUDAInvalidTargetAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static CUDAInvalidTargetAttr dyn_cast_or_null_CUDAInvalidTargetAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDAInvalidTargetAttr(From) ? cast_CUDAInvalidTargetAttr(From) : null;
  }

  public static boolean isa_CUDALaunchBoundsAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDALaunchBoundsAttr.classof(From);
  }

  public static CUDALaunchBoundsAttr cast_CUDALaunchBoundsAttr(Attr/*P*/ From) {
    assert isa_CUDALaunchBoundsAttr(From);
    return (CUDALaunchBoundsAttr) From;
  }

  public static CUDALaunchBoundsAttr cast_or_null_CUDALaunchBoundsAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDALaunchBoundsAttr(From);
  }

  public static CUDALaunchBoundsAttr dyn_cast_CUDALaunchBoundsAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static CUDALaunchBoundsAttr dyn_cast_or_null_CUDALaunchBoundsAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static boolean isa_CUDALaunchBoundsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDALaunchBoundsAttr.class, From.$star());
  }

  public static CUDALaunchBoundsAttr cast_CUDALaunchBoundsAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDALaunchBoundsAttr(From);
    return llvm.cast(CUDALaunchBoundsAttr.class, From.$star());
  }

  public static CUDALaunchBoundsAttr cast_or_null_CUDALaunchBoundsAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDALaunchBoundsAttr(From);
  }

  public static CUDALaunchBoundsAttr dyn_cast_CUDALaunchBoundsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static CUDALaunchBoundsAttr dyn_cast_or_null_CUDALaunchBoundsAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static boolean isa_CUDALaunchBoundsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDALaunchBoundsAttr.class, From.$deref());
  }

  public static CUDALaunchBoundsAttr cast_CUDALaunchBoundsAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDALaunchBoundsAttr(From);
    return llvm.cast(CUDALaunchBoundsAttr.class, From.$deref());
  }

  public static CUDALaunchBoundsAttr cast_or_null_CUDALaunchBoundsAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDALaunchBoundsAttr(From);
  }

  public static CUDALaunchBoundsAttr dyn_cast_CUDALaunchBoundsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static CUDALaunchBoundsAttr dyn_cast_or_null_CUDALaunchBoundsAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDALaunchBoundsAttr(From) ? cast_CUDALaunchBoundsAttr(From) : null;
  }

  public static boolean isa_CUDASharedAttr(Attr/*P*/ From) {
    assert From != null;
    return CUDASharedAttr.classof(From);
  }

  public static CUDASharedAttr cast_CUDASharedAttr(Attr/*P*/ From) {
    assert isa_CUDASharedAttr(From);
    return (CUDASharedAttr) From;
  }

  public static CUDASharedAttr cast_or_null_CUDASharedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CUDASharedAttr(From);
  }

  public static CUDASharedAttr dyn_cast_CUDASharedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static CUDASharedAttr dyn_cast_or_null_CUDASharedAttr(Attr/*P*/ From) {
    return (From != null) && isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static boolean isa_CUDASharedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CUDASharedAttr.class, From.$star());
  }

  public static CUDASharedAttr cast_CUDASharedAttr(type$ptr<?>/*P*/ From) {
    assert isa_CUDASharedAttr(From);
    return llvm.cast(CUDASharedAttr.class, From.$star());
  }

  public static CUDASharedAttr cast_or_null_CUDASharedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CUDASharedAttr(From);
  }

  public static CUDASharedAttr dyn_cast_CUDASharedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static CUDASharedAttr dyn_cast_or_null_CUDASharedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static boolean isa_CUDASharedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CUDASharedAttr.class, From.$deref());
  }

  public static CUDASharedAttr cast_CUDASharedAttr(type$ref<?>/*P*/ From) {
    assert isa_CUDASharedAttr(From);
    return llvm.cast(CUDASharedAttr.class, From.$deref());
  }

  public static CUDASharedAttr cast_or_null_CUDASharedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CUDASharedAttr(From);
  }

  public static CUDASharedAttr dyn_cast_CUDASharedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static CUDASharedAttr dyn_cast_or_null_CUDASharedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CUDASharedAttr(From) ? cast_CUDASharedAttr(From) : null;
  }

  public static boolean isa_CXX11NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return CXX11NoReturnAttr.classof(From);
  }

  public static CXX11NoReturnAttr cast_CXX11NoReturnAttr(Attr/*P*/ From) {
    assert isa_CXX11NoReturnAttr(From);
    return (CXX11NoReturnAttr) From;
  }

  public static CXX11NoReturnAttr cast_or_null_CXX11NoReturnAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CXX11NoReturnAttr(From);
  }

  public static CXX11NoReturnAttr dyn_cast_CXX11NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static CXX11NoReturnAttr dyn_cast_or_null_CXX11NoReturnAttr(Attr/*P*/ From) {
    return (From != null) && isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static boolean isa_CXX11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CXX11NoReturnAttr.class, From.$star());
  }

  public static CXX11NoReturnAttr cast_CXX11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert isa_CXX11NoReturnAttr(From);
    return llvm.cast(CXX11NoReturnAttr.class, From.$star());
  }

  public static CXX11NoReturnAttr cast_or_null_CXX11NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CXX11NoReturnAttr(From);
  }

  public static CXX11NoReturnAttr dyn_cast_CXX11NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static CXX11NoReturnAttr dyn_cast_or_null_CXX11NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static boolean isa_CXX11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CXX11NoReturnAttr.class, From.$deref());
  }

  public static CXX11NoReturnAttr cast_CXX11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert isa_CXX11NoReturnAttr(From);
    return llvm.cast(CXX11NoReturnAttr.class, From.$deref());
  }

  public static CXX11NoReturnAttr cast_or_null_CXX11NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CXX11NoReturnAttr(From);
  }

  public static CXX11NoReturnAttr dyn_cast_CXX11NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static CXX11NoReturnAttr dyn_cast_or_null_CXX11NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CXX11NoReturnAttr(From) ? cast_CXX11NoReturnAttr(From) : null;
  }

  public static boolean isa_CallableWhenAttr(Attr/*P*/ From) {
    assert From != null;
    return CallableWhenAttr.classof(From);
  }

  public static CallableWhenAttr cast_CallableWhenAttr(Attr/*P*/ From) {
    assert isa_CallableWhenAttr(From);
    return (CallableWhenAttr) From;
  }

  public static CallableWhenAttr cast_or_null_CallableWhenAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CallableWhenAttr(From);
  }

  public static CallableWhenAttr dyn_cast_CallableWhenAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static CallableWhenAttr dyn_cast_or_null_CallableWhenAttr(Attr/*P*/ From) {
    return (From != null) && isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static boolean isa_CallableWhenAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CallableWhenAttr.class, From.$star());
  }

  public static CallableWhenAttr cast_CallableWhenAttr(type$ptr<?>/*P*/ From) {
    assert isa_CallableWhenAttr(From);
    return llvm.cast(CallableWhenAttr.class, From.$star());
  }

  public static CallableWhenAttr cast_or_null_CallableWhenAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CallableWhenAttr(From);
  }

  public static CallableWhenAttr dyn_cast_CallableWhenAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static CallableWhenAttr dyn_cast_or_null_CallableWhenAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static boolean isa_CallableWhenAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CallableWhenAttr.class, From.$deref());
  }

  public static CallableWhenAttr cast_CallableWhenAttr(type$ref<?>/*P*/ From) {
    assert isa_CallableWhenAttr(From);
    return llvm.cast(CallableWhenAttr.class, From.$deref());
  }

  public static CallableWhenAttr cast_or_null_CallableWhenAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CallableWhenAttr(From);
  }

  public static CallableWhenAttr dyn_cast_CallableWhenAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static CallableWhenAttr dyn_cast_or_null_CallableWhenAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CallableWhenAttr(From) ? cast_CallableWhenAttr(From) : null;
  }

  public static boolean isa_CapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapabilityAttr.class, From.$deref());
  }

  public static CapabilityAttr cast_CapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_CapabilityAttr(From);
    return llvm.cast(CapabilityAttr.class, From.$deref());
  }

  public static CapabilityAttr cast_or_null_CapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapabilityAttr(From);
  }

  public static CapabilityAttr dyn_cast_CapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static CapabilityAttr dyn_cast_or_null_CapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static boolean isa_CapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapabilityAttr.class, From.$star());
  }

  public static CapabilityAttr cast_CapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_CapabilityAttr(From);
    return llvm.cast(CapabilityAttr.class, From.$star());
  }

  public static CapabilityAttr cast_or_null_CapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapabilityAttr(From);
  }

  public static CapabilityAttr dyn_cast_CapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static CapabilityAttr dyn_cast_or_null_CapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static boolean isa_CapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return CapabilityAttr.classof(From);
  }

  public static CapabilityAttr cast_CapabilityAttr(Attr/*P*/ From) {
    assert isa_CapabilityAttr(From);
    return (CapabilityAttr) From;
  }

  public static CapabilityAttr cast_or_null_CapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CapabilityAttr(From);
  }

  public static CapabilityAttr dyn_cast_CapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static CapabilityAttr dyn_cast_or_null_CapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_CapabilityAttr(From) ? cast_CapabilityAttr(From) : null;
  }

  public static boolean isa_CapturedRecordAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CapturedRecordAttr.class, From.$deref());
  }

  public static CapturedRecordAttr cast_CapturedRecordAttr(type$ref<?>/*P*/ From) {
    assert isa_CapturedRecordAttr(From);
    return llvm.cast(CapturedRecordAttr.class, From.$deref());
  }

  public static CapturedRecordAttr cast_or_null_CapturedRecordAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CapturedRecordAttr(From);
  }

  public static CapturedRecordAttr dyn_cast_CapturedRecordAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static CapturedRecordAttr dyn_cast_or_null_CapturedRecordAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static boolean isa_CapturedRecordAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CapturedRecordAttr.class, From.$star());
  }

  public static CapturedRecordAttr cast_CapturedRecordAttr(type$ptr<?>/*P*/ From) {
    assert isa_CapturedRecordAttr(From);
    return llvm.cast(CapturedRecordAttr.class, From.$star());
  }

  public static CapturedRecordAttr cast_or_null_CapturedRecordAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CapturedRecordAttr(From);
  }

  public static CapturedRecordAttr dyn_cast_CapturedRecordAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static CapturedRecordAttr dyn_cast_or_null_CapturedRecordAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static boolean isa_CapturedRecordAttr(Attr/*P*/ From) {
    assert From != null;
    return CapturedRecordAttr.classof(From);
  }

  public static CapturedRecordAttr cast_CapturedRecordAttr(Attr/*P*/ From) {
    assert isa_CapturedRecordAttr(From);
    return (CapturedRecordAttr) From;
  }

  public static CapturedRecordAttr cast_or_null_CapturedRecordAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CapturedRecordAttr(From);
  }

  public static CapturedRecordAttr dyn_cast_CapturedRecordAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static CapturedRecordAttr dyn_cast_or_null_CapturedRecordAttr(Attr/*P*/ From) {
    return (From != null) && isa_CapturedRecordAttr(From) ? cast_CapturedRecordAttr(From) : null;
  }

  public static boolean isa_CarriesDependencyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CarriesDependencyAttr.class, From.$deref());
  }

  public static CarriesDependencyAttr cast_CarriesDependencyAttr(type$ref<?>/*P*/ From) {
    assert isa_CarriesDependencyAttr(From);
    return llvm.cast(CarriesDependencyAttr.class, From.$deref());
  }

  public static CarriesDependencyAttr cast_or_null_CarriesDependencyAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CarriesDependencyAttr(From);
  }

  public static CarriesDependencyAttr dyn_cast_CarriesDependencyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static CarriesDependencyAttr dyn_cast_or_null_CarriesDependencyAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static boolean isa_CarriesDependencyAttr(Attr/*P*/ From) {
    assert From != null;
    return CarriesDependencyAttr.classof(From);
  }

  public static CarriesDependencyAttr cast_CarriesDependencyAttr(Attr/*P*/ From) {
    assert isa_CarriesDependencyAttr(From);
    return (CarriesDependencyAttr) From;
  }

  public static CarriesDependencyAttr cast_or_null_CarriesDependencyAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CarriesDependencyAttr(From);
  }

  public static CarriesDependencyAttr dyn_cast_CarriesDependencyAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static CarriesDependencyAttr dyn_cast_or_null_CarriesDependencyAttr(Attr/*P*/ From) {
    return (From != null) && isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static boolean isa_CarriesDependencyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CarriesDependencyAttr.class, From.$star());
  }

  public static CarriesDependencyAttr cast_CarriesDependencyAttr(type$ptr<?>/*P*/ From) {
    assert isa_CarriesDependencyAttr(From);
    return llvm.cast(CarriesDependencyAttr.class, From.$star());
  }

  public static CarriesDependencyAttr cast_or_null_CarriesDependencyAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CarriesDependencyAttr(From);
  }

  public static CarriesDependencyAttr dyn_cast_CarriesDependencyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static CarriesDependencyAttr dyn_cast_or_null_CarriesDependencyAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CarriesDependencyAttr(From) ? cast_CarriesDependencyAttr(From) : null;
  }

  public static boolean isa_CleanupAttr(Attr/*P*/ From) {
    assert From != null;
    return CleanupAttr.classof(From);
  }

  public static CleanupAttr cast_CleanupAttr(Attr/*P*/ From) {
    assert isa_CleanupAttr(From);
    return (CleanupAttr) From;
  }

  public static CleanupAttr cast_or_null_CleanupAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CleanupAttr(From);
  }

  public static CleanupAttr dyn_cast_CleanupAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static CleanupAttr dyn_cast_or_null_CleanupAttr(Attr/*P*/ From) {
    return (From != null) && isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static boolean isa_CleanupAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CleanupAttr.class, From.$star());
  }

  public static CleanupAttr cast_CleanupAttr(type$ptr<?>/*P*/ From) {
    assert isa_CleanupAttr(From);
    return llvm.cast(CleanupAttr.class, From.$star());
  }

  public static CleanupAttr cast_or_null_CleanupAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CleanupAttr(From);
  }

  public static CleanupAttr dyn_cast_CleanupAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static CleanupAttr dyn_cast_or_null_CleanupAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static boolean isa_CleanupAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CleanupAttr.class, From.$deref());
  }

  public static CleanupAttr cast_CleanupAttr(type$ref<?>/*P*/ From) {
    assert isa_CleanupAttr(From);
    return llvm.cast(CleanupAttr.class, From.$deref());
  }

  public static CleanupAttr cast_or_null_CleanupAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CleanupAttr(From);
  }

  public static CleanupAttr dyn_cast_CleanupAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static CleanupAttr dyn_cast_or_null_CleanupAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CleanupAttr(From) ? cast_CleanupAttr(From) : null;
  }

  public static boolean isa_ColdAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ColdAttr.class, From.$star());
  }

  public static ColdAttr cast_ColdAttr(type$ptr<?>/*P*/ From) {
    assert isa_ColdAttr(From);
    return llvm.cast(ColdAttr.class, From.$star());
  }

  public static ColdAttr cast_or_null_ColdAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ColdAttr(From);
  }

  public static ColdAttr dyn_cast_ColdAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static ColdAttr dyn_cast_or_null_ColdAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static boolean isa_ColdAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ColdAttr.class, From.$deref());
  }

  public static ColdAttr cast_ColdAttr(type$ref<?>/*P*/ From) {
    assert isa_ColdAttr(From);
    return llvm.cast(ColdAttr.class, From.$deref());
  }

  public static ColdAttr cast_or_null_ColdAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ColdAttr(From);
  }

  public static ColdAttr dyn_cast_ColdAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static ColdAttr dyn_cast_or_null_ColdAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static boolean isa_ColdAttr(Attr/*P*/ From) {
    assert From != null;
    return ColdAttr.classof(From);
  }

  public static ColdAttr cast_ColdAttr(Attr/*P*/ From) {
    assert isa_ColdAttr(From);
    return (ColdAttr) From;
  }

  public static ColdAttr cast_or_null_ColdAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ColdAttr(From);
  }

  public static ColdAttr dyn_cast_ColdAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static ColdAttr dyn_cast_or_null_ColdAttr(Attr/*P*/ From) {
    return (From != null) && isa_ColdAttr(From) ? cast_ColdAttr(From) : null;
  }

  public static boolean isa_CommonAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(CommonAttr.class, From.$deref());
  }

  public static CommonAttr cast_CommonAttr(type$ref<?>/*P*/ From) {
    assert isa_CommonAttr(From);
    return llvm.cast(CommonAttr.class, From.$deref());
  }

  public static CommonAttr cast_or_null_CommonAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_CommonAttr(From);
  }

  public static CommonAttr dyn_cast_CommonAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static CommonAttr dyn_cast_or_null_CommonAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static boolean isa_CommonAttr(Attr/*P*/ From) {
    assert From != null;
    return CommonAttr.classof(From);
  }

  public static CommonAttr cast_CommonAttr(Attr/*P*/ From) {
    assert isa_CommonAttr(From);
    return (CommonAttr) From;
  }

  public static CommonAttr cast_or_null_CommonAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_CommonAttr(From);
  }

  public static CommonAttr dyn_cast_CommonAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static CommonAttr dyn_cast_or_null_CommonAttr(Attr/*P*/ From) {
    return (From != null) && isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static boolean isa_CommonAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(CommonAttr.class, From.$star());
  }

  public static CommonAttr cast_CommonAttr(type$ptr<?>/*P*/ From) {
    assert isa_CommonAttr(From);
    return llvm.cast(CommonAttr.class, From.$star());
  }

  public static CommonAttr cast_or_null_CommonAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_CommonAttr(From);
  }

  public static CommonAttr dyn_cast_CommonAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static CommonAttr dyn_cast_or_null_CommonAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_CommonAttr(From) ? cast_CommonAttr(From) : null;
  }

  public static boolean isa_ConstAttr(Attr/*P*/ From) {
    assert From != null;
    return ConstAttr.classof(From);
  }

  public static ConstAttr cast_ConstAttr(Attr/*P*/ From) {
    assert isa_ConstAttr(From);
    return (ConstAttr) From;
  }

  public static ConstAttr cast_or_null_ConstAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ConstAttr(From);
  }

  public static ConstAttr dyn_cast_ConstAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static ConstAttr dyn_cast_or_null_ConstAttr(Attr/*P*/ From) {
    return (From != null) && isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static boolean isa_ConstAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstAttr.class, From.$star());
  }

  public static ConstAttr cast_ConstAttr(type$ptr<?>/*P*/ From) {
    assert isa_ConstAttr(From);
    return llvm.cast(ConstAttr.class, From.$star());
  }

  public static ConstAttr cast_or_null_ConstAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstAttr(From);
  }

  public static ConstAttr dyn_cast_ConstAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static ConstAttr dyn_cast_or_null_ConstAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static boolean isa_ConstAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstAttr.class, From.$deref());
  }

  public static ConstAttr cast_ConstAttr(type$ref<?>/*P*/ From) {
    assert isa_ConstAttr(From);
    return llvm.cast(ConstAttr.class, From.$deref());
  }

  public static ConstAttr cast_or_null_ConstAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstAttr(From);
  }

  public static ConstAttr dyn_cast_ConstAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static ConstAttr dyn_cast_or_null_ConstAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstAttr(From) ? cast_ConstAttr(From) : null;
  }

  public static boolean isa_ConstructorAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConstructorAttr.class, From.$star());
  }

  public static ConstructorAttr cast_ConstructorAttr(type$ptr<?>/*P*/ From) {
    assert isa_ConstructorAttr(From);
    return llvm.cast(ConstructorAttr.class, From.$star());
  }

  public static ConstructorAttr cast_or_null_ConstructorAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConstructorAttr(From);
  }

  public static ConstructorAttr dyn_cast_ConstructorAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static ConstructorAttr dyn_cast_or_null_ConstructorAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static boolean isa_ConstructorAttr(Attr/*P*/ From) {
    assert From != null;
    return ConstructorAttr.classof(From);
  }

  public static ConstructorAttr cast_ConstructorAttr(Attr/*P*/ From) {
    assert isa_ConstructorAttr(From);
    return (ConstructorAttr) From;
  }

  public static ConstructorAttr cast_or_null_ConstructorAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ConstructorAttr(From);
  }

  public static ConstructorAttr dyn_cast_ConstructorAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static ConstructorAttr dyn_cast_or_null_ConstructorAttr(Attr/*P*/ From) {
    return (From != null) && isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static boolean isa_ConstructorAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConstructorAttr.class, From.$deref());
  }

  public static ConstructorAttr cast_ConstructorAttr(type$ref<?>/*P*/ From) {
    assert isa_ConstructorAttr(From);
    return llvm.cast(ConstructorAttr.class, From.$deref());
  }

  public static ConstructorAttr cast_or_null_ConstructorAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConstructorAttr(From);
  }

  public static ConstructorAttr dyn_cast_ConstructorAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static ConstructorAttr dyn_cast_or_null_ConstructorAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConstructorAttr(From) ? cast_ConstructorAttr(From) : null;
  }

  public static boolean isa_ConsumableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConsumableAttr.class, From.$deref());
  }

  public static ConsumableAttr cast_ConsumableAttr(type$ref<?>/*P*/ From) {
    assert isa_ConsumableAttr(From);
    return llvm.cast(ConsumableAttr.class, From.$deref());
  }

  public static ConsumableAttr cast_or_null_ConsumableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConsumableAttr(From);
  }

  public static ConsumableAttr dyn_cast_ConsumableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static ConsumableAttr dyn_cast_or_null_ConsumableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static boolean isa_ConsumableAttr(Attr/*P*/ From) {
    assert From != null;
    return ConsumableAttr.classof(From);
  }

  public static ConsumableAttr cast_ConsumableAttr(Attr/*P*/ From) {
    assert isa_ConsumableAttr(From);
    return (ConsumableAttr) From;
  }

  public static ConsumableAttr cast_or_null_ConsumableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ConsumableAttr(From);
  }

  public static ConsumableAttr dyn_cast_ConsumableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static ConsumableAttr dyn_cast_or_null_ConsumableAttr(Attr/*P*/ From) {
    return (From != null) && isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static boolean isa_ConsumableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConsumableAttr.class, From.$star());
  }

  public static ConsumableAttr cast_ConsumableAttr(type$ptr<?>/*P*/ From) {
    assert isa_ConsumableAttr(From);
    return llvm.cast(ConsumableAttr.class, From.$star());
  }

  public static ConsumableAttr cast_or_null_ConsumableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConsumableAttr(From);
  }

  public static ConsumableAttr dyn_cast_ConsumableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static ConsumableAttr dyn_cast_or_null_ConsumableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConsumableAttr(From) ? cast_ConsumableAttr(From) : null;
  }

  public static boolean isa_ConsumableAutoCastAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConsumableAutoCastAttr.class, From.$star());
  }

  public static ConsumableAutoCastAttr cast_ConsumableAutoCastAttr(type$ptr<?>/*P*/ From) {
    assert isa_ConsumableAutoCastAttr(From);
    return llvm.cast(ConsumableAutoCastAttr.class, From.$star());
  }

  public static ConsumableAutoCastAttr cast_or_null_ConsumableAutoCastAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConsumableAutoCastAttr(From);
  }

  public static ConsumableAutoCastAttr dyn_cast_ConsumableAutoCastAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static ConsumableAutoCastAttr dyn_cast_or_null_ConsumableAutoCastAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static boolean isa_ConsumableAutoCastAttr(Attr/*P*/ From) {
    assert From != null;
    return ConsumableAutoCastAttr.classof(From);
  }

  public static ConsumableAutoCastAttr cast_ConsumableAutoCastAttr(Attr/*P*/ From) {
    assert isa_ConsumableAutoCastAttr(From);
    return (ConsumableAutoCastAttr) From;
  }

  public static ConsumableAutoCastAttr cast_or_null_ConsumableAutoCastAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ConsumableAutoCastAttr(From);
  }

  public static ConsumableAutoCastAttr dyn_cast_ConsumableAutoCastAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static ConsumableAutoCastAttr dyn_cast_or_null_ConsumableAutoCastAttr(Attr/*P*/ From) {
    return (From != null) && isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static boolean isa_ConsumableAutoCastAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConsumableAutoCastAttr.class, From.$deref());
  }

  public static ConsumableAutoCastAttr cast_ConsumableAutoCastAttr(type$ref<?>/*P*/ From) {
    assert isa_ConsumableAutoCastAttr(From);
    return llvm.cast(ConsumableAutoCastAttr.class, From.$deref());
  }

  public static ConsumableAutoCastAttr cast_or_null_ConsumableAutoCastAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConsumableAutoCastAttr(From);
  }

  public static ConsumableAutoCastAttr dyn_cast_ConsumableAutoCastAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static ConsumableAutoCastAttr dyn_cast_or_null_ConsumableAutoCastAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConsumableAutoCastAttr(From) ? cast_ConsumableAutoCastAttr(From) : null;
  }

  public static boolean isa_ConsumableSetOnReadAttr(Attr/*P*/ From) {
    assert From != null;
    return ConsumableSetOnReadAttr.classof(From);
  }

  public static ConsumableSetOnReadAttr cast_ConsumableSetOnReadAttr(Attr/*P*/ From) {
    assert isa_ConsumableSetOnReadAttr(From);
    return (ConsumableSetOnReadAttr) From;
  }

  public static ConsumableSetOnReadAttr cast_or_null_ConsumableSetOnReadAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ConsumableSetOnReadAttr(From);
  }

  public static ConsumableSetOnReadAttr dyn_cast_ConsumableSetOnReadAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static ConsumableSetOnReadAttr dyn_cast_or_null_ConsumableSetOnReadAttr(Attr/*P*/ From) {
    return (From != null) && isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static boolean isa_ConsumableSetOnReadAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ConsumableSetOnReadAttr.class, From.$star());
  }

  public static ConsumableSetOnReadAttr cast_ConsumableSetOnReadAttr(type$ptr<?>/*P*/ From) {
    assert isa_ConsumableSetOnReadAttr(From);
    return llvm.cast(ConsumableSetOnReadAttr.class, From.$star());
  }

  public static ConsumableSetOnReadAttr cast_or_null_ConsumableSetOnReadAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ConsumableSetOnReadAttr(From);
  }

  public static ConsumableSetOnReadAttr dyn_cast_ConsumableSetOnReadAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static ConsumableSetOnReadAttr dyn_cast_or_null_ConsumableSetOnReadAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static boolean isa_ConsumableSetOnReadAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ConsumableSetOnReadAttr.class, From.$deref());
  }

  public static ConsumableSetOnReadAttr cast_ConsumableSetOnReadAttr(type$ref<?>/*P*/ From) {
    assert isa_ConsumableSetOnReadAttr(From);
    return llvm.cast(ConsumableSetOnReadAttr.class, From.$deref());
  }

  public static ConsumableSetOnReadAttr cast_or_null_ConsumableSetOnReadAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ConsumableSetOnReadAttr(From);
  }

  public static ConsumableSetOnReadAttr dyn_cast_ConsumableSetOnReadAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static ConsumableSetOnReadAttr dyn_cast_or_null_ConsumableSetOnReadAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ConsumableSetOnReadAttr(From) ? cast_ConsumableSetOnReadAttr(From) : null;
  }

  public static boolean isa_DLLExportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DLLExportAttr.class, From.$star());
  }

  public static DLLExportAttr cast_DLLExportAttr(type$ptr<?>/*P*/ From) {
    assert isa_DLLExportAttr(From);
    return llvm.cast(DLLExportAttr.class, From.$star());
  }

  public static DLLExportAttr cast_or_null_DLLExportAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DLLExportAttr(From);
  }

  public static DLLExportAttr dyn_cast_DLLExportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static DLLExportAttr dyn_cast_or_null_DLLExportAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static boolean isa_DLLExportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DLLExportAttr.class, From.$deref());
  }

  public static DLLExportAttr cast_DLLExportAttr(type$ref<?>/*P*/ From) {
    assert isa_DLLExportAttr(From);
    return llvm.cast(DLLExportAttr.class, From.$deref());
  }

  public static DLLExportAttr cast_or_null_DLLExportAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DLLExportAttr(From);
  }

  public static DLLExportAttr dyn_cast_DLLExportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static DLLExportAttr dyn_cast_or_null_DLLExportAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static boolean isa_DLLExportAttr(Attr/*P*/ From) {
    assert From != null;
    return DLLExportAttr.classof(From);
  }

  public static DLLExportAttr cast_DLLExportAttr(Attr/*P*/ From) {
    assert isa_DLLExportAttr(From);
    return (DLLExportAttr) From;
  }

  public static DLLExportAttr cast_or_null_DLLExportAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_DLLExportAttr(From);
  }

  public static DLLExportAttr dyn_cast_DLLExportAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static DLLExportAttr dyn_cast_or_null_DLLExportAttr(Attr/*P*/ From) {
    return (From != null) && isa_DLLExportAttr(From) ? cast_DLLExportAttr(From) : null;
  }

  public static boolean isa_DLLImportAttr(Attr/*P*/ From) {
    assert From != null;
    return DLLImportAttr.classof(From);
  }

  public static DLLImportAttr cast_DLLImportAttr(Attr/*P*/ From) {
    assert isa_DLLImportAttr(From);
    return (DLLImportAttr) From;
  }

  public static DLLImportAttr cast_or_null_DLLImportAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_DLLImportAttr(From);
  }

  public static DLLImportAttr dyn_cast_DLLImportAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static DLLImportAttr dyn_cast_or_null_DLLImportAttr(Attr/*P*/ From) {
    return (From != null) && isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static boolean isa_DLLImportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DLLImportAttr.class, From.$star());
  }

  public static DLLImportAttr cast_DLLImportAttr(type$ptr<?>/*P*/ From) {
    assert isa_DLLImportAttr(From);
    return llvm.cast(DLLImportAttr.class, From.$star());
  }

  public static DLLImportAttr cast_or_null_DLLImportAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DLLImportAttr(From);
  }

  public static DLLImportAttr dyn_cast_DLLImportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static DLLImportAttr dyn_cast_or_null_DLLImportAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static boolean isa_DLLImportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DLLImportAttr.class, From.$deref());
  }

  public static DLLImportAttr cast_DLLImportAttr(type$ref<?>/*P*/ From) {
    assert isa_DLLImportAttr(From);
    return llvm.cast(DLLImportAttr.class, From.$deref());
  }

  public static DLLImportAttr cast_or_null_DLLImportAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DLLImportAttr(From);
  }

  public static DLLImportAttr dyn_cast_DLLImportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static DLLImportAttr dyn_cast_or_null_DLLImportAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DLLImportAttr(From) ? cast_DLLImportAttr(From) : null;
  }

  public static boolean isa_DeprecatedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DeprecatedAttr.class, From.$star());
  }

  public static DeprecatedAttr cast_DeprecatedAttr(type$ptr<?>/*P*/ From) {
    assert isa_DeprecatedAttr(From);
    return llvm.cast(DeprecatedAttr.class, From.$star());
  }

  public static DeprecatedAttr cast_or_null_DeprecatedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DeprecatedAttr(From);
  }

  public static DeprecatedAttr dyn_cast_DeprecatedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static DeprecatedAttr dyn_cast_or_null_DeprecatedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static boolean isa_DeprecatedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DeprecatedAttr.class, From.$deref());
  }

  public static DeprecatedAttr cast_DeprecatedAttr(type$ref<?>/*P*/ From) {
    assert isa_DeprecatedAttr(From);
    return llvm.cast(DeprecatedAttr.class, From.$deref());
  }

  public static DeprecatedAttr cast_or_null_DeprecatedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DeprecatedAttr(From);
  }

  public static DeprecatedAttr dyn_cast_DeprecatedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static DeprecatedAttr dyn_cast_or_null_DeprecatedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static boolean isa_DeprecatedAttr(Attr/*P*/ From) {
    assert From != null;
    return DeprecatedAttr.classof(From);
  }

  public static DeprecatedAttr cast_DeprecatedAttr(Attr/*P*/ From) {
    assert isa_DeprecatedAttr(From);
    return (DeprecatedAttr) From;
  }

  public static DeprecatedAttr cast_or_null_DeprecatedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_DeprecatedAttr(From);
  }

  public static DeprecatedAttr dyn_cast_DeprecatedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static DeprecatedAttr dyn_cast_or_null_DeprecatedAttr(Attr/*P*/ From) {
    return (From != null) && isa_DeprecatedAttr(From) ? cast_DeprecatedAttr(From) : null;
  }

  public static boolean isa_DestructorAttr(Attr/*P*/ From) {
    assert From != null;
    return DestructorAttr.classof(From);
  }

  public static DestructorAttr cast_DestructorAttr(Attr/*P*/ From) {
    assert isa_DestructorAttr(From);
    return (DestructorAttr) From;
  }

  public static DestructorAttr cast_or_null_DestructorAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_DestructorAttr(From);
  }

  public static DestructorAttr dyn_cast_DestructorAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static DestructorAttr dyn_cast_or_null_DestructorAttr(Attr/*P*/ From) {
    return (From != null) && isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static boolean isa_DestructorAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DestructorAttr.class, From.$star());
  }

  public static DestructorAttr cast_DestructorAttr(type$ptr<?>/*P*/ From) {
    assert isa_DestructorAttr(From);
    return llvm.cast(DestructorAttr.class, From.$star());
  }

  public static DestructorAttr cast_or_null_DestructorAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DestructorAttr(From);
  }

  public static DestructorAttr dyn_cast_DestructorAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static DestructorAttr dyn_cast_or_null_DestructorAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static boolean isa_DestructorAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DestructorAttr.class, From.$deref());
  }

  public static DestructorAttr cast_DestructorAttr(type$ref<?>/*P*/ From) {
    assert isa_DestructorAttr(From);
    return llvm.cast(DestructorAttr.class, From.$deref());
  }

  public static DestructorAttr cast_or_null_DestructorAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DestructorAttr(From);
  }

  public static DestructorAttr dyn_cast_DestructorAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static DestructorAttr dyn_cast_or_null_DestructorAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DestructorAttr(From) ? cast_DestructorAttr(From) : null;
  }

  public static boolean isa_DisableTailCallsAttr(Attr/*P*/ From) {
    assert From != null;
    return DisableTailCallsAttr.classof(From);
  }

  public static DisableTailCallsAttr cast_DisableTailCallsAttr(Attr/*P*/ From) {
    assert isa_DisableTailCallsAttr(From);
    return (DisableTailCallsAttr) From;
  }

  public static DisableTailCallsAttr cast_or_null_DisableTailCallsAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_DisableTailCallsAttr(From);
  }

  public static DisableTailCallsAttr dyn_cast_DisableTailCallsAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static DisableTailCallsAttr dyn_cast_or_null_DisableTailCallsAttr(Attr/*P*/ From) {
    return (From != null) && isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static boolean isa_DisableTailCallsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DisableTailCallsAttr.class, From.$star());
  }

  public static DisableTailCallsAttr cast_DisableTailCallsAttr(type$ptr<?>/*P*/ From) {
    assert isa_DisableTailCallsAttr(From);
    return llvm.cast(DisableTailCallsAttr.class, From.$star());
  }

  public static DisableTailCallsAttr cast_or_null_DisableTailCallsAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DisableTailCallsAttr(From);
  }

  public static DisableTailCallsAttr dyn_cast_DisableTailCallsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static DisableTailCallsAttr dyn_cast_or_null_DisableTailCallsAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static boolean isa_DisableTailCallsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DisableTailCallsAttr.class, From.$deref());
  }

  public static DisableTailCallsAttr cast_DisableTailCallsAttr(type$ref<?>/*P*/ From) {
    assert isa_DisableTailCallsAttr(From);
    return llvm.cast(DisableTailCallsAttr.class, From.$deref());
  }

  public static DisableTailCallsAttr cast_or_null_DisableTailCallsAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DisableTailCallsAttr(From);
  }

  public static DisableTailCallsAttr dyn_cast_DisableTailCallsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static DisableTailCallsAttr dyn_cast_or_null_DisableTailCallsAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DisableTailCallsAttr(From) ? cast_DisableTailCallsAttr(From) : null;
  }

  public static boolean isa_EmptyBasesAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EmptyBasesAttr.class, From.$deref());
  }

  public static EmptyBasesAttr cast_EmptyBasesAttr(type$ref<?>/*P*/ From) {
    assert isa_EmptyBasesAttr(From);
    return llvm.cast(EmptyBasesAttr.class, From.$deref());
  }

  public static EmptyBasesAttr cast_or_null_EmptyBasesAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EmptyBasesAttr(From);
  }

  public static EmptyBasesAttr dyn_cast_EmptyBasesAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static EmptyBasesAttr dyn_cast_or_null_EmptyBasesAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static boolean isa_EmptyBasesAttr(Attr/*P*/ From) {
    assert From != null;
    return EmptyBasesAttr.classof(From);
  }

  public static EmptyBasesAttr cast_EmptyBasesAttr(Attr/*P*/ From) {
    assert isa_EmptyBasesAttr(From);
    return (EmptyBasesAttr) From;
  }

  public static EmptyBasesAttr cast_or_null_EmptyBasesAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_EmptyBasesAttr(From);
  }

  public static EmptyBasesAttr dyn_cast_EmptyBasesAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static EmptyBasesAttr dyn_cast_or_null_EmptyBasesAttr(Attr/*P*/ From) {
    return (From != null) && isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static boolean isa_EmptyBasesAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EmptyBasesAttr.class, From.$star());
  }

  public static EmptyBasesAttr cast_EmptyBasesAttr(type$ptr<?>/*P*/ From) {
    assert isa_EmptyBasesAttr(From);
    return llvm.cast(EmptyBasesAttr.class, From.$star());
  }

  public static EmptyBasesAttr cast_or_null_EmptyBasesAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EmptyBasesAttr(From);
  }

  public static EmptyBasesAttr dyn_cast_EmptyBasesAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static EmptyBasesAttr dyn_cast_or_null_EmptyBasesAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EmptyBasesAttr(From) ? cast_EmptyBasesAttr(From) : null;
  }

  public static boolean isa_EnableIfAttr(Attr/*P*/ From) {
    assert From != null;
    return EnableIfAttr.classof(From);
  }

  public static EnableIfAttr cast_EnableIfAttr(Attr/*P*/ From) {
    assert isa_EnableIfAttr(From);
    return (EnableIfAttr) From;
  }

  public static EnableIfAttr cast_or_null_EnableIfAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_EnableIfAttr(From);
  }

  public static EnableIfAttr dyn_cast_EnableIfAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static EnableIfAttr dyn_cast_or_null_EnableIfAttr(Attr/*P*/ From) {
    return (From != null) && isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static boolean isa_EnableIfAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(EnableIfAttr.class, From.$deref());
  }

  public static EnableIfAttr cast_EnableIfAttr(type$ref<?>/*P*/ From) {
    assert isa_EnableIfAttr(From);
    return llvm.cast(EnableIfAttr.class, From.$deref());
  }

  public static EnableIfAttr cast_or_null_EnableIfAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_EnableIfAttr(From);
  }

  public static EnableIfAttr dyn_cast_EnableIfAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static EnableIfAttr dyn_cast_or_null_EnableIfAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static boolean isa_EnableIfAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(EnableIfAttr.class, From.$star());
  }

  public static EnableIfAttr cast_EnableIfAttr(type$ptr<?>/*P*/ From) {
    assert isa_EnableIfAttr(From);
    return llvm.cast(EnableIfAttr.class, From.$star());
  }

  public static EnableIfAttr cast_or_null_EnableIfAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_EnableIfAttr(From);
  }

  public static EnableIfAttr dyn_cast_EnableIfAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static EnableIfAttr dyn_cast_or_null_EnableIfAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_EnableIfAttr(From) ? cast_EnableIfAttr(From) : null;
  }

  public static boolean isa_ExclusiveTrylockFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return ExclusiveTrylockFunctionAttr.classof(From);
  }

  public static ExclusiveTrylockFunctionAttr cast_ExclusiveTrylockFunctionAttr(Attr/*P*/ From) {
    assert isa_ExclusiveTrylockFunctionAttr(From);
    return (ExclusiveTrylockFunctionAttr) From;
  }

  public static ExclusiveTrylockFunctionAttr cast_or_null_ExclusiveTrylockFunctionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ExclusiveTrylockFunctionAttr(From);
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_ExclusiveTrylockFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_or_null_ExclusiveTrylockFunctionAttr(Attr/*P*/ From) {
    return (From != null) && isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_ExclusiveTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ExclusiveTrylockFunctionAttr.class, From.$star());
  }

  public static ExclusiveTrylockFunctionAttr cast_ExclusiveTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert isa_ExclusiveTrylockFunctionAttr(From);
    return llvm.cast(ExclusiveTrylockFunctionAttr.class, From.$star());
  }

  public static ExclusiveTrylockFunctionAttr cast_or_null_ExclusiveTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ExclusiveTrylockFunctionAttr(From);
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_ExclusiveTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_or_null_ExclusiveTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_ExclusiveTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ExclusiveTrylockFunctionAttr.class, From.$deref());
  }

  public static ExclusiveTrylockFunctionAttr cast_ExclusiveTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert isa_ExclusiveTrylockFunctionAttr(From);
    return llvm.cast(ExclusiveTrylockFunctionAttr.class, From.$deref());
  }

  public static ExclusiveTrylockFunctionAttr cast_or_null_ExclusiveTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ExclusiveTrylockFunctionAttr(From);
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_ExclusiveTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static ExclusiveTrylockFunctionAttr dyn_cast_or_null_ExclusiveTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ExclusiveTrylockFunctionAttr(From) ? cast_ExclusiveTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_FallThroughAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FallThroughAttr.class, From.$deref());
  }

  public static FallThroughAttr cast_FallThroughAttr(type$ref<?>/*P*/ From) {
    assert isa_FallThroughAttr(From);
    return llvm.cast(FallThroughAttr.class, From.$deref());
  }

  public static FallThroughAttr cast_or_null_FallThroughAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FallThroughAttr(From);
  }

  public static FallThroughAttr dyn_cast_FallThroughAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static FallThroughAttr dyn_cast_or_null_FallThroughAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static boolean isa_FallThroughAttr(Attr/*P*/ From) {
    assert From != null;
    return FallThroughAttr.classof(From);
  }

  public static FallThroughAttr cast_FallThroughAttr(Attr/*P*/ From) {
    assert isa_FallThroughAttr(From);
    return (FallThroughAttr) From;
  }

  public static FallThroughAttr cast_or_null_FallThroughAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FallThroughAttr(From);
  }

  public static FallThroughAttr dyn_cast_FallThroughAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static FallThroughAttr dyn_cast_or_null_FallThroughAttr(Attr/*P*/ From) {
    return (From != null) && isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static boolean isa_FallThroughAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FallThroughAttr.class, From.$star());
  }

  public static FallThroughAttr cast_FallThroughAttr(type$ptr<?>/*P*/ From) {
    assert isa_FallThroughAttr(From);
    return llvm.cast(FallThroughAttr.class, From.$star());
  }

  public static FallThroughAttr cast_or_null_FallThroughAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FallThroughAttr(From);
  }

  public static FallThroughAttr dyn_cast_FallThroughAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static FallThroughAttr dyn_cast_or_null_FallThroughAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FallThroughAttr(From) ? cast_FallThroughAttr(From) : null;
  }

  public static boolean isa_FastCallAttr(Attr/*P*/ From) {
    assert From != null;
    return FastCallAttr.classof(From);
  }

  public static FastCallAttr cast_FastCallAttr(Attr/*P*/ From) {
    assert isa_FastCallAttr(From);
    return (FastCallAttr) From;
  }

  public static FastCallAttr cast_or_null_FastCallAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FastCallAttr(From);
  }

  public static FastCallAttr dyn_cast_FastCallAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static FastCallAttr dyn_cast_or_null_FastCallAttr(Attr/*P*/ From) {
    return (From != null) && isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static boolean isa_FastCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FastCallAttr.class, From.$star());
  }

  public static FastCallAttr cast_FastCallAttr(type$ptr<?>/*P*/ From) {
    assert isa_FastCallAttr(From);
    return llvm.cast(FastCallAttr.class, From.$star());
  }

  public static FastCallAttr cast_or_null_FastCallAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FastCallAttr(From);
  }

  public static FastCallAttr dyn_cast_FastCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static FastCallAttr dyn_cast_or_null_FastCallAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static boolean isa_FastCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FastCallAttr.class, From.$deref());
  }

  public static FastCallAttr cast_FastCallAttr(type$ref<?>/*P*/ From) {
    assert isa_FastCallAttr(From);
    return llvm.cast(FastCallAttr.class, From.$deref());
  }

  public static FastCallAttr cast_or_null_FastCallAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FastCallAttr(From);
  }

  public static FastCallAttr dyn_cast_FastCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static FastCallAttr dyn_cast_or_null_FastCallAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FastCallAttr(From) ? cast_FastCallAttr(From) : null;
  }

  public static boolean isa_FinalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FinalAttr.class, From.$deref());
  }

  public static FinalAttr cast_FinalAttr(type$ref<?>/*P*/ From) {
    assert isa_FinalAttr(From);
    return llvm.cast(FinalAttr.class, From.$deref());
  }

  public static FinalAttr cast_or_null_FinalAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FinalAttr(From);
  }

  public static FinalAttr dyn_cast_FinalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static FinalAttr dyn_cast_or_null_FinalAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static boolean isa_FinalAttr(Attr/*P*/ From) {
    assert From != null;
    return FinalAttr.classof(From);
  }

  public static FinalAttr cast_FinalAttr(Attr/*P*/ From) {
    assert isa_FinalAttr(From);
    return (FinalAttr) From;
  }

  public static FinalAttr cast_or_null_FinalAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FinalAttr(From);
  }

  public static FinalAttr dyn_cast_FinalAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static FinalAttr dyn_cast_or_null_FinalAttr(Attr/*P*/ From) {
    return (From != null) && isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static boolean isa_FinalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FinalAttr.class, From.$star());
  }

  public static FinalAttr cast_FinalAttr(type$ptr<?>/*P*/ From) {
    assert isa_FinalAttr(From);
    return llvm.cast(FinalAttr.class, From.$star());
  }

  public static FinalAttr cast_or_null_FinalAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FinalAttr(From);
  }

  public static FinalAttr dyn_cast_FinalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static FinalAttr dyn_cast_or_null_FinalAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FinalAttr(From) ? cast_FinalAttr(From) : null;
  }

  public static boolean isa_FlagEnumAttr(Attr/*P*/ From) {
    assert From != null;
    return FlagEnumAttr.classof(From);
  }

  public static FlagEnumAttr cast_FlagEnumAttr(Attr/*P*/ From) {
    assert isa_FlagEnumAttr(From);
    return (FlagEnumAttr) From;
  }

  public static FlagEnumAttr cast_or_null_FlagEnumAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FlagEnumAttr(From);
  }

  public static FlagEnumAttr dyn_cast_FlagEnumAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static FlagEnumAttr dyn_cast_or_null_FlagEnumAttr(Attr/*P*/ From) {
    return (From != null) && isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static boolean isa_FlagEnumAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FlagEnumAttr.class, From.$star());
  }

  public static FlagEnumAttr cast_FlagEnumAttr(type$ptr<?>/*P*/ From) {
    assert isa_FlagEnumAttr(From);
    return llvm.cast(FlagEnumAttr.class, From.$star());
  }

  public static FlagEnumAttr cast_or_null_FlagEnumAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FlagEnumAttr(From);
  }

  public static FlagEnumAttr dyn_cast_FlagEnumAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static FlagEnumAttr dyn_cast_or_null_FlagEnumAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static boolean isa_FlagEnumAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FlagEnumAttr.class, From.$deref());
  }

  public static FlagEnumAttr cast_FlagEnumAttr(type$ref<?>/*P*/ From) {
    assert isa_FlagEnumAttr(From);
    return llvm.cast(FlagEnumAttr.class, From.$deref());
  }

  public static FlagEnumAttr cast_or_null_FlagEnumAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FlagEnumAttr(From);
  }

  public static FlagEnumAttr dyn_cast_FlagEnumAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static FlagEnumAttr dyn_cast_or_null_FlagEnumAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FlagEnumAttr(From) ? cast_FlagEnumAttr(From) : null;
  }

  public static boolean isa_FlattenAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FlattenAttr.class, From.$star());
  }

  public static FlattenAttr cast_FlattenAttr(type$ptr<?>/*P*/ From) {
    assert isa_FlattenAttr(From);
    return llvm.cast(FlattenAttr.class, From.$star());
  }

  public static FlattenAttr cast_or_null_FlattenAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FlattenAttr(From);
  }

  public static FlattenAttr dyn_cast_FlattenAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static FlattenAttr dyn_cast_or_null_FlattenAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static boolean isa_FlattenAttr(Attr/*P*/ From) {
    assert From != null;
    return FlattenAttr.classof(From);
  }

  public static FlattenAttr cast_FlattenAttr(Attr/*P*/ From) {
    assert isa_FlattenAttr(From);
    return (FlattenAttr) From;
  }

  public static FlattenAttr cast_or_null_FlattenAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FlattenAttr(From);
  }

  public static FlattenAttr dyn_cast_FlattenAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static FlattenAttr dyn_cast_or_null_FlattenAttr(Attr/*P*/ From) {
    return (From != null) && isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static boolean isa_FlattenAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FlattenAttr.class, From.$deref());
  }

  public static FlattenAttr cast_FlattenAttr(type$ref<?>/*P*/ From) {
    assert isa_FlattenAttr(From);
    return llvm.cast(FlattenAttr.class, From.$deref());
  }

  public static FlattenAttr cast_or_null_FlattenAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FlattenAttr(From);
  }

  public static FlattenAttr dyn_cast_FlattenAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static FlattenAttr dyn_cast_or_null_FlattenAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FlattenAttr(From) ? cast_FlattenAttr(From) : null;
  }

  public static boolean isa_FormatArgAttr(Attr/*P*/ From) {
    assert From != null;
    return FormatArgAttr.classof(From);
  }

  public static FormatArgAttr cast_FormatArgAttr(Attr/*P*/ From) {
    assert isa_FormatArgAttr(From);
    return (FormatArgAttr) From;
  }

  public static FormatArgAttr cast_or_null_FormatArgAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FormatArgAttr(From);
  }

  public static FormatArgAttr dyn_cast_FormatArgAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static FormatArgAttr dyn_cast_or_null_FormatArgAttr(Attr/*P*/ From) {
    return (From != null) && isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static boolean isa_FormatArgAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FormatArgAttr.class, From.$star());
  }

  public static FormatArgAttr cast_FormatArgAttr(type$ptr<?>/*P*/ From) {
    assert isa_FormatArgAttr(From);
    return llvm.cast(FormatArgAttr.class, From.$star());
  }

  public static FormatArgAttr cast_or_null_FormatArgAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FormatArgAttr(From);
  }

  public static FormatArgAttr dyn_cast_FormatArgAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static FormatArgAttr dyn_cast_or_null_FormatArgAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static boolean isa_FormatArgAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FormatArgAttr.class, From.$deref());
  }

  public static FormatArgAttr cast_FormatArgAttr(type$ref<?>/*P*/ From) {
    assert isa_FormatArgAttr(From);
    return llvm.cast(FormatArgAttr.class, From.$deref());
  }

  public static FormatArgAttr cast_or_null_FormatArgAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FormatArgAttr(From);
  }

  public static FormatArgAttr dyn_cast_FormatArgAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static FormatArgAttr dyn_cast_or_null_FormatArgAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FormatArgAttr(From) ? cast_FormatArgAttr(From) : null;
  }

  public static boolean isa_FormatAttr(Attr/*P*/ From) {
    assert From != null;
    return FormatAttr.classof(From);
  }

  public static FormatAttr cast_FormatAttr(Attr/*P*/ From) {
    assert isa_FormatAttr(From);
    return (FormatAttr) From;
  }

  public static FormatAttr cast_or_null_FormatAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_FormatAttr(From);
  }

  public static FormatAttr dyn_cast_FormatAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static FormatAttr dyn_cast_or_null_FormatAttr(Attr/*P*/ From) {
    return (From != null) && isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static boolean isa_FormatAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(FormatAttr.class, From.$star());
  }

  public static FormatAttr cast_FormatAttr(type$ptr<?>/*P*/ From) {
    assert isa_FormatAttr(From);
    return llvm.cast(FormatAttr.class, From.$star());
  }

  public static FormatAttr cast_or_null_FormatAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_FormatAttr(From);
  }

  public static FormatAttr dyn_cast_FormatAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static FormatAttr dyn_cast_or_null_FormatAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static boolean isa_FormatAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(FormatAttr.class, From.$deref());
  }

  public static FormatAttr cast_FormatAttr(type$ref<?>/*P*/ From) {
    assert isa_FormatAttr(From);
    return llvm.cast(FormatAttr.class, From.$deref());
  }

  public static FormatAttr cast_or_null_FormatAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_FormatAttr(From);
  }

  public static FormatAttr dyn_cast_FormatAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static FormatAttr dyn_cast_or_null_FormatAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_FormatAttr(From) ? cast_FormatAttr(From) : null;
  }

  public static boolean isa_GNUInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return GNUInlineAttr.classof(From);
  }

  public static GNUInlineAttr cast_GNUInlineAttr(Attr/*P*/ From) {
    assert isa_GNUInlineAttr(From);
    return (GNUInlineAttr) From;
  }

  public static GNUInlineAttr cast_or_null_GNUInlineAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_GNUInlineAttr(From);
  }

  public static GNUInlineAttr dyn_cast_GNUInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static GNUInlineAttr dyn_cast_or_null_GNUInlineAttr(Attr/*P*/ From) {
    return (From != null) && isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static boolean isa_GNUInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GNUInlineAttr.class, From.$deref());
  }

  public static GNUInlineAttr cast_GNUInlineAttr(type$ref<?>/*P*/ From) {
    assert isa_GNUInlineAttr(From);
    return llvm.cast(GNUInlineAttr.class, From.$deref());
  }

  public static GNUInlineAttr cast_or_null_GNUInlineAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GNUInlineAttr(From);
  }

  public static GNUInlineAttr dyn_cast_GNUInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static GNUInlineAttr dyn_cast_or_null_GNUInlineAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static boolean isa_GNUInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GNUInlineAttr.class, From.$star());
  }

  public static GNUInlineAttr cast_GNUInlineAttr(type$ptr<?>/*P*/ From) {
    assert isa_GNUInlineAttr(From);
    return llvm.cast(GNUInlineAttr.class, From.$star());
  }

  public static GNUInlineAttr cast_or_null_GNUInlineAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GNUInlineAttr(From);
  }

  public static GNUInlineAttr dyn_cast_GNUInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static GNUInlineAttr dyn_cast_or_null_GNUInlineAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GNUInlineAttr(From) ? cast_GNUInlineAttr(From) : null;
  }

  public static boolean isa_GuardedByAttr(Attr/*P*/ From) {
    assert From != null;
    return GuardedByAttr.classof(From);
  }

  public static GuardedByAttr cast_GuardedByAttr(Attr/*P*/ From) {
    assert isa_GuardedByAttr(From);
    return (GuardedByAttr) From;
  }

  public static GuardedByAttr cast_or_null_GuardedByAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_GuardedByAttr(From);
  }

  public static GuardedByAttr dyn_cast_GuardedByAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static GuardedByAttr dyn_cast_or_null_GuardedByAttr(Attr/*P*/ From) {
    return (From != null) && isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static boolean isa_GuardedByAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GuardedByAttr.class, From.$star());
  }

  public static GuardedByAttr cast_GuardedByAttr(type$ptr<?>/*P*/ From) {
    assert isa_GuardedByAttr(From);
    return llvm.cast(GuardedByAttr.class, From.$star());
  }

  public static GuardedByAttr cast_or_null_GuardedByAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GuardedByAttr(From);
  }

  public static GuardedByAttr dyn_cast_GuardedByAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static GuardedByAttr dyn_cast_or_null_GuardedByAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static boolean isa_GuardedByAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GuardedByAttr.class, From.$deref());
  }

  public static GuardedByAttr cast_GuardedByAttr(type$ref<?>/*P*/ From) {
    assert isa_GuardedByAttr(From);
    return llvm.cast(GuardedByAttr.class, From.$deref());
  }

  public static GuardedByAttr cast_or_null_GuardedByAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GuardedByAttr(From);
  }

  public static GuardedByAttr dyn_cast_GuardedByAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static GuardedByAttr dyn_cast_or_null_GuardedByAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GuardedByAttr(From) ? cast_GuardedByAttr(From) : null;
  }

  public static boolean isa_GuardedVarAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(GuardedVarAttr.class, From.$deref());
  }

  public static GuardedVarAttr cast_GuardedVarAttr(type$ref<?>/*P*/ From) {
    assert isa_GuardedVarAttr(From);
    return llvm.cast(GuardedVarAttr.class, From.$deref());
  }

  public static GuardedVarAttr cast_or_null_GuardedVarAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_GuardedVarAttr(From);
  }

  public static GuardedVarAttr dyn_cast_GuardedVarAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static GuardedVarAttr dyn_cast_or_null_GuardedVarAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static boolean isa_GuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(GuardedVarAttr.class, From.$star());
  }

  public static GuardedVarAttr cast_GuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert isa_GuardedVarAttr(From);
    return llvm.cast(GuardedVarAttr.class, From.$star());
  }

  public static GuardedVarAttr cast_or_null_GuardedVarAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_GuardedVarAttr(From);
  }

  public static GuardedVarAttr dyn_cast_GuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static GuardedVarAttr dyn_cast_or_null_GuardedVarAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static boolean isa_GuardedVarAttr(Attr/*P*/ From) {
    assert From != null;
    return GuardedVarAttr.classof(From);
  }

  public static GuardedVarAttr cast_GuardedVarAttr(Attr/*P*/ From) {
    assert isa_GuardedVarAttr(From);
    return (GuardedVarAttr) From;
  }

  public static GuardedVarAttr cast_or_null_GuardedVarAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_GuardedVarAttr(From);
  }

  public static GuardedVarAttr dyn_cast_GuardedVarAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static GuardedVarAttr dyn_cast_or_null_GuardedVarAttr(Attr/*P*/ From) {
    return (From != null) && isa_GuardedVarAttr(From) ? cast_GuardedVarAttr(From) : null;
  }

  public static boolean isa_HotAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(HotAttr.class, From.$deref());
  }

  public static HotAttr cast_HotAttr(type$ref<?>/*P*/ From) {
    assert isa_HotAttr(From);
    return llvm.cast(HotAttr.class, From.$deref());
  }

  public static HotAttr cast_or_null_HotAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_HotAttr(From);
  }

  public static HotAttr dyn_cast_HotAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static HotAttr dyn_cast_or_null_HotAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static boolean isa_HotAttr(Attr/*P*/ From) {
    assert From != null;
    return HotAttr.classof(From);
  }

  public static HotAttr cast_HotAttr(Attr/*P*/ From) {
    assert isa_HotAttr(From);
    return (HotAttr) From;
  }

  public static HotAttr cast_or_null_HotAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_HotAttr(From);
  }

  public static HotAttr dyn_cast_HotAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static HotAttr dyn_cast_or_null_HotAttr(Attr/*P*/ From) {
    return (From != null) && isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static boolean isa_HotAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(HotAttr.class, From.$star());
  }

  public static HotAttr cast_HotAttr(type$ptr<?>/*P*/ From) {
    assert isa_HotAttr(From);
    return llvm.cast(HotAttr.class, From.$star());
  }

  public static HotAttr cast_or_null_HotAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_HotAttr(From);
  }

  public static HotAttr dyn_cast_HotAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static HotAttr dyn_cast_or_null_HotAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_HotAttr(From) ? cast_HotAttr(From) : null;
  }

  public static boolean isa_IBActionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IBActionAttr.class, From.$deref());
  }

  public static IBActionAttr cast_IBActionAttr(type$ref<?>/*P*/ From) {
    assert isa_IBActionAttr(From);
    return llvm.cast(IBActionAttr.class, From.$deref());
  }

  public static IBActionAttr cast_or_null_IBActionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IBActionAttr(From);
  }

  public static IBActionAttr dyn_cast_IBActionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static IBActionAttr dyn_cast_or_null_IBActionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static boolean isa_IBActionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IBActionAttr.class, From.$star());
  }

  public static IBActionAttr cast_IBActionAttr(type$ptr<?>/*P*/ From) {
    assert isa_IBActionAttr(From);
    return llvm.cast(IBActionAttr.class, From.$star());
  }

  public static IBActionAttr cast_or_null_IBActionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IBActionAttr(From);
  }

  public static IBActionAttr dyn_cast_IBActionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static IBActionAttr dyn_cast_or_null_IBActionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static boolean isa_IBActionAttr(Attr/*P*/ From) {
    assert From != null;
    return IBActionAttr.classof(From);
  }

  public static IBActionAttr cast_IBActionAttr(Attr/*P*/ From) {
    assert isa_IBActionAttr(From);
    return (IBActionAttr) From;
  }

  public static IBActionAttr cast_or_null_IBActionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_IBActionAttr(From);
  }

  public static IBActionAttr dyn_cast_IBActionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static IBActionAttr dyn_cast_or_null_IBActionAttr(Attr/*P*/ From) {
    return (From != null) && isa_IBActionAttr(From) ? cast_IBActionAttr(From) : null;
  }

  public static boolean isa_IBOutletAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IBOutletAttr.class, From.$deref());
  }

  public static IBOutletAttr cast_IBOutletAttr(type$ref<?>/*P*/ From) {
    assert isa_IBOutletAttr(From);
    return llvm.cast(IBOutletAttr.class, From.$deref());
  }

  public static IBOutletAttr cast_or_null_IBOutletAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IBOutletAttr(From);
  }

  public static IBOutletAttr dyn_cast_IBOutletAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static IBOutletAttr dyn_cast_or_null_IBOutletAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static boolean isa_IBOutletAttr(Attr/*P*/ From) {
    assert From != null;
    return IBOutletAttr.classof(From);
  }

  public static IBOutletAttr cast_IBOutletAttr(Attr/*P*/ From) {
    assert isa_IBOutletAttr(From);
    return (IBOutletAttr) From;
  }

  public static IBOutletAttr cast_or_null_IBOutletAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_IBOutletAttr(From);
  }

  public static IBOutletAttr dyn_cast_IBOutletAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static IBOutletAttr dyn_cast_or_null_IBOutletAttr(Attr/*P*/ From) {
    return (From != null) && isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static boolean isa_IBOutletAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IBOutletAttr.class, From.$star());
  }

  public static IBOutletAttr cast_IBOutletAttr(type$ptr<?>/*P*/ From) {
    assert isa_IBOutletAttr(From);
    return llvm.cast(IBOutletAttr.class, From.$star());
  }

  public static IBOutletAttr cast_or_null_IBOutletAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IBOutletAttr(From);
  }

  public static IBOutletAttr dyn_cast_IBOutletAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static IBOutletAttr dyn_cast_or_null_IBOutletAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IBOutletAttr(From) ? cast_IBOutletAttr(From) : null;
  }

  public static boolean isa_IBOutletCollectionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IBOutletCollectionAttr.class, From.$star());
  }

  public static IBOutletCollectionAttr cast_IBOutletCollectionAttr(type$ptr<?>/*P*/ From) {
    assert isa_IBOutletCollectionAttr(From);
    return llvm.cast(IBOutletCollectionAttr.class, From.$star());
  }

  public static IBOutletCollectionAttr cast_or_null_IBOutletCollectionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IBOutletCollectionAttr(From);
  }

  public static IBOutletCollectionAttr dyn_cast_IBOutletCollectionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static IBOutletCollectionAttr dyn_cast_or_null_IBOutletCollectionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static boolean isa_IBOutletCollectionAttr(Attr/*P*/ From) {
    assert From != null;
    return IBOutletCollectionAttr.classof(From);
  }

  public static IBOutletCollectionAttr cast_IBOutletCollectionAttr(Attr/*P*/ From) {
    assert isa_IBOutletCollectionAttr(From);
    return (IBOutletCollectionAttr) From;
  }

  public static IBOutletCollectionAttr cast_or_null_IBOutletCollectionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_IBOutletCollectionAttr(From);
  }

  public static IBOutletCollectionAttr dyn_cast_IBOutletCollectionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static IBOutletCollectionAttr dyn_cast_or_null_IBOutletCollectionAttr(Attr/*P*/ From) {
    return (From != null) && isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static boolean isa_IBOutletCollectionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IBOutletCollectionAttr.class, From.$deref());
  }

  public static IBOutletCollectionAttr cast_IBOutletCollectionAttr(type$ref<?>/*P*/ From) {
    assert isa_IBOutletCollectionAttr(From);
    return llvm.cast(IBOutletCollectionAttr.class, From.$deref());
  }

  public static IBOutletCollectionAttr cast_or_null_IBOutletCollectionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IBOutletCollectionAttr(From);
  }

  public static IBOutletCollectionAttr dyn_cast_IBOutletCollectionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static IBOutletCollectionAttr dyn_cast_or_null_IBOutletCollectionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IBOutletCollectionAttr(From) ? cast_IBOutletCollectionAttr(From) : null;
  }

  public static boolean isa_IFuncAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IFuncAttr.class, From.$deref());
  }

  public static IFuncAttr cast_IFuncAttr(type$ref<?>/*P*/ From) {
    assert isa_IFuncAttr(From);
    return llvm.cast(IFuncAttr.class, From.$deref());
  }

  public static IFuncAttr cast_or_null_IFuncAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IFuncAttr(From);
  }

  public static IFuncAttr dyn_cast_IFuncAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static IFuncAttr dyn_cast_or_null_IFuncAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static boolean isa_IFuncAttr(Attr/*P*/ From) {
    assert From != null;
    return IFuncAttr.classof(From);
  }

  public static IFuncAttr cast_IFuncAttr(Attr/*P*/ From) {
    assert isa_IFuncAttr(From);
    return (IFuncAttr) From;
  }

  public static IFuncAttr cast_or_null_IFuncAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_IFuncAttr(From);
  }

  public static IFuncAttr dyn_cast_IFuncAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static IFuncAttr dyn_cast_or_null_IFuncAttr(Attr/*P*/ From) {
    return (From != null) && isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static boolean isa_IFuncAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IFuncAttr.class, From.$star());
  }

  public static IFuncAttr cast_IFuncAttr(type$ptr<?>/*P*/ From) {
    assert isa_IFuncAttr(From);
    return llvm.cast(IFuncAttr.class, From.$star());
  }

  public static IFuncAttr cast_or_null_IFuncAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IFuncAttr(From);
  }

  public static IFuncAttr dyn_cast_IFuncAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static IFuncAttr dyn_cast_or_null_IFuncAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IFuncAttr(From) ? cast_IFuncAttr(From) : null;
  }

  public static boolean isa_InheritableAttr(Attr/*P*/ From) {
    assert From != null;
    return InheritableAttr.classof(From);
  }

  public static InheritableAttr cast_InheritableAttr(Attr/*P*/ From) {
    assert isa_InheritableAttr(From);
    return (InheritableAttr) From;
  }

  public static InheritableAttr cast_or_null_InheritableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_InheritableAttr(From);
  }

  public static InheritableAttr dyn_cast_InheritableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static InheritableAttr dyn_cast_or_null_InheritableAttr(Attr/*P*/ From) {
    return (From != null) && isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static boolean isa_InheritableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InheritableAttr.class, From.$star());
  }

  public static InheritableAttr cast_InheritableAttr(type$ptr<?>/*P*/ From) {
    assert isa_InheritableAttr(From);
    return llvm.cast(InheritableAttr.class, From.$star());
  }

  public static InheritableAttr cast_or_null_InheritableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InheritableAttr(From);
  }

  public static InheritableAttr dyn_cast_InheritableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static InheritableAttr dyn_cast_or_null_InheritableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static boolean isa_InheritableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InheritableAttr.class, From.$deref());
  }

  public static InheritableAttr cast_InheritableAttr(type$ref<?>/*P*/ From) {
    assert isa_InheritableAttr(From);
    return llvm.cast(InheritableAttr.class, From.$deref());
  }

  public static InheritableAttr cast_or_null_InheritableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InheritableAttr(From);
  }

  public static InheritableAttr dyn_cast_InheritableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static InheritableAttr dyn_cast_or_null_InheritableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InheritableAttr(From) ? cast_InheritableAttr(From) : null;
  }

  public static boolean isa_InheritableParamAttr(Attr/*P*/ From) {
    assert From != null;
    return InheritableParamAttr.classof(From);
  }

  public static InheritableParamAttr cast_InheritableParamAttr(Attr/*P*/ From) {
    assert isa_InheritableParamAttr(From);
    return (InheritableParamAttr) From;
  }

  public static InheritableParamAttr cast_or_null_InheritableParamAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_InheritableParamAttr(From);
  }

  public static InheritableParamAttr dyn_cast_InheritableParamAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static InheritableParamAttr dyn_cast_or_null_InheritableParamAttr(Attr/*P*/ From) {
    return (From != null) && isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static boolean isa_InheritableParamAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InheritableParamAttr.class, From.$star());
  }

  public static InheritableParamAttr cast_InheritableParamAttr(type$ptr<?>/*P*/ From) {
    assert isa_InheritableParamAttr(From);
    return llvm.cast(InheritableParamAttr.class, From.$star());
  }

  public static InheritableParamAttr cast_or_null_InheritableParamAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InheritableParamAttr(From);
  }

  public static InheritableParamAttr dyn_cast_InheritableParamAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static InheritableParamAttr dyn_cast_or_null_InheritableParamAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static boolean isa_InheritableParamAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InheritableParamAttr.class, From.$deref());
  }

  public static InheritableParamAttr cast_InheritableParamAttr(type$ref<?>/*P*/ From) {
    assert isa_InheritableParamAttr(From);
    return llvm.cast(InheritableParamAttr.class, From.$deref());
  }

  public static InheritableParamAttr cast_or_null_InheritableParamAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InheritableParamAttr(From);
  }

  public static InheritableParamAttr dyn_cast_InheritableParamAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static InheritableParamAttr dyn_cast_or_null_InheritableParamAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InheritableParamAttr(From) ? cast_InheritableParamAttr(From) : null;
  }

  public static boolean isa_InitPriorityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InitPriorityAttr.class, From.$deref());
  }

  public static InitPriorityAttr cast_InitPriorityAttr(type$ref<?>/*P*/ From) {
    assert isa_InitPriorityAttr(From);
    return llvm.cast(InitPriorityAttr.class, From.$deref());
  }

  public static InitPriorityAttr cast_or_null_InitPriorityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InitPriorityAttr(From);
  }

  public static InitPriorityAttr dyn_cast_InitPriorityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static InitPriorityAttr dyn_cast_or_null_InitPriorityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static boolean isa_InitPriorityAttr(Attr/*P*/ From) {
    assert From != null;
    return InitPriorityAttr.classof(From);
  }

  public static InitPriorityAttr cast_InitPriorityAttr(Attr/*P*/ From) {
    assert isa_InitPriorityAttr(From);
    return (InitPriorityAttr) From;
  }

  public static InitPriorityAttr cast_or_null_InitPriorityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_InitPriorityAttr(From);
  }

  public static InitPriorityAttr dyn_cast_InitPriorityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static InitPriorityAttr dyn_cast_or_null_InitPriorityAttr(Attr/*P*/ From) {
    return (From != null) && isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static boolean isa_InitPriorityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InitPriorityAttr.class, From.$star());
  }

  public static InitPriorityAttr cast_InitPriorityAttr(type$ptr<?>/*P*/ From) {
    assert isa_InitPriorityAttr(From);
    return llvm.cast(InitPriorityAttr.class, From.$star());
  }

  public static InitPriorityAttr cast_or_null_InitPriorityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InitPriorityAttr(From);
  }

  public static InitPriorityAttr dyn_cast_InitPriorityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static InitPriorityAttr dyn_cast_or_null_InitPriorityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InitPriorityAttr(From) ? cast_InitPriorityAttr(From) : null;
  }

  public static boolean isa_InitSegAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InitSegAttr.class, From.$deref());
  }

  public static InitSegAttr cast_InitSegAttr(type$ref<?>/*P*/ From) {
    assert isa_InitSegAttr(From);
    return llvm.cast(InitSegAttr.class, From.$deref());
  }

  public static InitSegAttr cast_or_null_InitSegAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InitSegAttr(From);
  }

  public static InitSegAttr dyn_cast_InitSegAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static InitSegAttr dyn_cast_or_null_InitSegAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static boolean isa_InitSegAttr(Attr/*P*/ From) {
    assert From != null;
    return InitSegAttr.classof(From);
  }

  public static InitSegAttr cast_InitSegAttr(Attr/*P*/ From) {
    assert isa_InitSegAttr(From);
    return (InitSegAttr) From;
  }

  public static InitSegAttr cast_or_null_InitSegAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_InitSegAttr(From);
  }

  public static InitSegAttr dyn_cast_InitSegAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static InitSegAttr dyn_cast_or_null_InitSegAttr(Attr/*P*/ From) {
    return (From != null) && isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static boolean isa_InitSegAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InitSegAttr.class, From.$star());
  }

  public static InitSegAttr cast_InitSegAttr(type$ptr<?>/*P*/ From) {
    assert isa_InitSegAttr(From);
    return llvm.cast(InitSegAttr.class, From.$star());
  }

  public static InitSegAttr cast_or_null_InitSegAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InitSegAttr(From);
  }

  public static InitSegAttr dyn_cast_InitSegAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static InitSegAttr dyn_cast_or_null_InitSegAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InitSegAttr(From) ? cast_InitSegAttr(From) : null;
  }

  public static boolean isa_IntelOclBiccAttr(Attr/*P*/ From) {
    assert From != null;
    return IntelOclBiccAttr.classof(From);
  }

  public static IntelOclBiccAttr cast_IntelOclBiccAttr(Attr/*P*/ From) {
    assert isa_IntelOclBiccAttr(From);
    return (IntelOclBiccAttr) From;
  }

  public static IntelOclBiccAttr cast_or_null_IntelOclBiccAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_IntelOclBiccAttr(From);
  }

  public static IntelOclBiccAttr dyn_cast_IntelOclBiccAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static IntelOclBiccAttr dyn_cast_or_null_IntelOclBiccAttr(Attr/*P*/ From) {
    return (From != null) && isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static boolean isa_IntelOclBiccAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IntelOclBiccAttr.class, From.$star());
  }

  public static IntelOclBiccAttr cast_IntelOclBiccAttr(type$ptr<?>/*P*/ From) {
    assert isa_IntelOclBiccAttr(From);
    return llvm.cast(IntelOclBiccAttr.class, From.$star());
  }

  public static IntelOclBiccAttr cast_or_null_IntelOclBiccAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IntelOclBiccAttr(From);
  }

  public static IntelOclBiccAttr dyn_cast_IntelOclBiccAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static IntelOclBiccAttr dyn_cast_or_null_IntelOclBiccAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static boolean isa_IntelOclBiccAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IntelOclBiccAttr.class, From.$deref());
  }

  public static IntelOclBiccAttr cast_IntelOclBiccAttr(type$ref<?>/*P*/ From) {
    assert isa_IntelOclBiccAttr(From);
    return llvm.cast(IntelOclBiccAttr.class, From.$deref());
  }

  public static IntelOclBiccAttr cast_or_null_IntelOclBiccAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IntelOclBiccAttr(From);
  }

  public static IntelOclBiccAttr dyn_cast_IntelOclBiccAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static IntelOclBiccAttr dyn_cast_or_null_IntelOclBiccAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IntelOclBiccAttr(From) ? cast_IntelOclBiccAttr(From) : null;
  }

  public static boolean isa_InternalLinkageAttr(Attr/*P*/ From) {
    assert From != null;
    return InternalLinkageAttr.classof(From);
  }

  public static InternalLinkageAttr cast_InternalLinkageAttr(Attr/*P*/ From) {
    assert isa_InternalLinkageAttr(From);
    return (InternalLinkageAttr) From;
  }

  public static InternalLinkageAttr cast_or_null_InternalLinkageAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_InternalLinkageAttr(From);
  }

  public static InternalLinkageAttr dyn_cast_InternalLinkageAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static InternalLinkageAttr dyn_cast_or_null_InternalLinkageAttr(Attr/*P*/ From) {
    return (From != null) && isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static boolean isa_InternalLinkageAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InternalLinkageAttr.class, From.$deref());
  }

  public static InternalLinkageAttr cast_InternalLinkageAttr(type$ref<?>/*P*/ From) {
    assert isa_InternalLinkageAttr(From);
    return llvm.cast(InternalLinkageAttr.class, From.$deref());
  }

  public static InternalLinkageAttr cast_or_null_InternalLinkageAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InternalLinkageAttr(From);
  }

  public static InternalLinkageAttr dyn_cast_InternalLinkageAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static InternalLinkageAttr dyn_cast_or_null_InternalLinkageAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static boolean isa_InternalLinkageAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InternalLinkageAttr.class, From.$star());
  }

  public static InternalLinkageAttr cast_InternalLinkageAttr(type$ptr<?>/*P*/ From) {
    assert isa_InternalLinkageAttr(From);
    return llvm.cast(InternalLinkageAttr.class, From.$star());
  }

  public static InternalLinkageAttr cast_or_null_InternalLinkageAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InternalLinkageAttr(From);
  }

  public static InternalLinkageAttr dyn_cast_InternalLinkageAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static InternalLinkageAttr dyn_cast_or_null_InternalLinkageAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InternalLinkageAttr(From) ? cast_InternalLinkageAttr(From) : null;
  }

  public static boolean isa_LTOVisibilityPublicAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LTOVisibilityPublicAttr.class, From.$deref());
  }

  public static LTOVisibilityPublicAttr cast_LTOVisibilityPublicAttr(type$ref<?>/*P*/ From) {
    assert isa_LTOVisibilityPublicAttr(From);
    return llvm.cast(LTOVisibilityPublicAttr.class, From.$deref());
  }

  public static LTOVisibilityPublicAttr cast_or_null_LTOVisibilityPublicAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LTOVisibilityPublicAttr(From);
  }

  public static LTOVisibilityPublicAttr dyn_cast_LTOVisibilityPublicAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static LTOVisibilityPublicAttr dyn_cast_or_null_LTOVisibilityPublicAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static boolean isa_LTOVisibilityPublicAttr(Attr/*P*/ From) {
    assert From != null;
    return LTOVisibilityPublicAttr.classof(From);
  }

  public static LTOVisibilityPublicAttr cast_LTOVisibilityPublicAttr(Attr/*P*/ From) {
    assert isa_LTOVisibilityPublicAttr(From);
    return (LTOVisibilityPublicAttr) From;
  }

  public static LTOVisibilityPublicAttr cast_or_null_LTOVisibilityPublicAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_LTOVisibilityPublicAttr(From);
  }

  public static LTOVisibilityPublicAttr dyn_cast_LTOVisibilityPublicAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static LTOVisibilityPublicAttr dyn_cast_or_null_LTOVisibilityPublicAttr(Attr/*P*/ From) {
    return (From != null) && isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static boolean isa_LTOVisibilityPublicAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LTOVisibilityPublicAttr.class, From.$star());
  }

  public static LTOVisibilityPublicAttr cast_LTOVisibilityPublicAttr(type$ptr<?>/*P*/ From) {
    assert isa_LTOVisibilityPublicAttr(From);
    return llvm.cast(LTOVisibilityPublicAttr.class, From.$star());
  }

  public static LTOVisibilityPublicAttr cast_or_null_LTOVisibilityPublicAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LTOVisibilityPublicAttr(From);
  }

  public static LTOVisibilityPublicAttr dyn_cast_LTOVisibilityPublicAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static LTOVisibilityPublicAttr dyn_cast_or_null_LTOVisibilityPublicAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LTOVisibilityPublicAttr(From) ? cast_LTOVisibilityPublicAttr(From) : null;
  }

  public static boolean isa_LayoutVersionAttr(Attr/*P*/ From) {
    assert From != null;
    return LayoutVersionAttr.classof(From);
  }

  public static LayoutVersionAttr cast_LayoutVersionAttr(Attr/*P*/ From) {
    assert isa_LayoutVersionAttr(From);
    return (LayoutVersionAttr) From;
  }

  public static LayoutVersionAttr cast_or_null_LayoutVersionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_LayoutVersionAttr(From);
  }

  public static LayoutVersionAttr dyn_cast_LayoutVersionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static LayoutVersionAttr dyn_cast_or_null_LayoutVersionAttr(Attr/*P*/ From) {
    return (From != null) && isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static boolean isa_LayoutVersionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LayoutVersionAttr.class, From.$deref());
  }

  public static LayoutVersionAttr cast_LayoutVersionAttr(type$ref<?>/*P*/ From) {
    assert isa_LayoutVersionAttr(From);
    return llvm.cast(LayoutVersionAttr.class, From.$deref());
  }

  public static LayoutVersionAttr cast_or_null_LayoutVersionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LayoutVersionAttr(From);
  }

  public static LayoutVersionAttr dyn_cast_LayoutVersionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static LayoutVersionAttr dyn_cast_or_null_LayoutVersionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static boolean isa_LayoutVersionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LayoutVersionAttr.class, From.$star());
  }

  public static LayoutVersionAttr cast_LayoutVersionAttr(type$ptr<?>/*P*/ From) {
    assert isa_LayoutVersionAttr(From);
    return llvm.cast(LayoutVersionAttr.class, From.$star());
  }

  public static LayoutVersionAttr cast_or_null_LayoutVersionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LayoutVersionAttr(From);
  }

  public static LayoutVersionAttr dyn_cast_LayoutVersionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static LayoutVersionAttr dyn_cast_or_null_LayoutVersionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LayoutVersionAttr(From) ? cast_LayoutVersionAttr(From) : null;
  }

  public static boolean isa_LockReturnedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LockReturnedAttr.class, From.$deref());
  }

  public static LockReturnedAttr cast_LockReturnedAttr(type$ref<?>/*P*/ From) {
    assert isa_LockReturnedAttr(From);
    return llvm.cast(LockReturnedAttr.class, From.$deref());
  }

  public static LockReturnedAttr cast_or_null_LockReturnedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LockReturnedAttr(From);
  }

  public static LockReturnedAttr dyn_cast_LockReturnedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static LockReturnedAttr dyn_cast_or_null_LockReturnedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static boolean isa_LockReturnedAttr(Attr/*P*/ From) {
    assert From != null;
    return LockReturnedAttr.classof(From);
  }

  public static LockReturnedAttr cast_LockReturnedAttr(Attr/*P*/ From) {
    assert isa_LockReturnedAttr(From);
    return (LockReturnedAttr) From;
  }

  public static LockReturnedAttr cast_or_null_LockReturnedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_LockReturnedAttr(From);
  }

  public static LockReturnedAttr dyn_cast_LockReturnedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static LockReturnedAttr dyn_cast_or_null_LockReturnedAttr(Attr/*P*/ From) {
    return (From != null) && isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static boolean isa_LockReturnedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LockReturnedAttr.class, From.$star());
  }

  public static LockReturnedAttr cast_LockReturnedAttr(type$ptr<?>/*P*/ From) {
    assert isa_LockReturnedAttr(From);
    return llvm.cast(LockReturnedAttr.class, From.$star());
  }

  public static LockReturnedAttr cast_or_null_LockReturnedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LockReturnedAttr(From);
  }

  public static LockReturnedAttr dyn_cast_LockReturnedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static LockReturnedAttr dyn_cast_or_null_LockReturnedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LockReturnedAttr(From) ? cast_LockReturnedAttr(From) : null;
  }

  public static boolean isa_LocksExcludedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LocksExcludedAttr.class, From.$deref());
  }

  public static LocksExcludedAttr cast_LocksExcludedAttr(type$ref<?>/*P*/ From) {
    assert isa_LocksExcludedAttr(From);
    return llvm.cast(LocksExcludedAttr.class, From.$deref());
  }

  public static LocksExcludedAttr cast_or_null_LocksExcludedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LocksExcludedAttr(From);
  }

  public static LocksExcludedAttr dyn_cast_LocksExcludedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static LocksExcludedAttr dyn_cast_or_null_LocksExcludedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static boolean isa_LocksExcludedAttr(Attr/*P*/ From) {
    assert From != null;
    return LocksExcludedAttr.classof(From);
  }

  public static LocksExcludedAttr cast_LocksExcludedAttr(Attr/*P*/ From) {
    assert isa_LocksExcludedAttr(From);
    return (LocksExcludedAttr) From;
  }

  public static LocksExcludedAttr cast_or_null_LocksExcludedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_LocksExcludedAttr(From);
  }

  public static LocksExcludedAttr dyn_cast_LocksExcludedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static LocksExcludedAttr dyn_cast_or_null_LocksExcludedAttr(Attr/*P*/ From) {
    return (From != null) && isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static boolean isa_LocksExcludedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LocksExcludedAttr.class, From.$star());
  }

  public static LocksExcludedAttr cast_LocksExcludedAttr(type$ptr<?>/*P*/ From) {
    assert isa_LocksExcludedAttr(From);
    return llvm.cast(LocksExcludedAttr.class, From.$star());
  }

  public static LocksExcludedAttr cast_or_null_LocksExcludedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LocksExcludedAttr(From);
  }

  public static LocksExcludedAttr dyn_cast_LocksExcludedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static LocksExcludedAttr dyn_cast_or_null_LocksExcludedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LocksExcludedAttr(From) ? cast_LocksExcludedAttr(From) : null;
  }

  public static boolean isa_LoopHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(LoopHintAttr.class, From.$deref());
  }

  public static LoopHintAttr cast_LoopHintAttr(type$ref<?>/*P*/ From) {
    assert isa_LoopHintAttr(From);
    return llvm.cast(LoopHintAttr.class, From.$deref());
  }

  public static LoopHintAttr cast_or_null_LoopHintAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_LoopHintAttr(From);
  }

  public static LoopHintAttr dyn_cast_LoopHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static LoopHintAttr dyn_cast_or_null_LoopHintAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static boolean isa_LoopHintAttr(Attr/*P*/ From) {
    assert From != null;
    return LoopHintAttr.classof(From);
  }

  public static LoopHintAttr cast_LoopHintAttr(Attr/*P*/ From) {
    assert isa_LoopHintAttr(From);
    return (LoopHintAttr) From;
  }

  public static LoopHintAttr cast_or_null_LoopHintAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_LoopHintAttr(From);
  }

  public static LoopHintAttr dyn_cast_LoopHintAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static LoopHintAttr dyn_cast_or_null_LoopHintAttr(Attr/*P*/ From) {
    return (From != null) && isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static boolean isa_LoopHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(LoopHintAttr.class, From.$star());
  }

  public static LoopHintAttr cast_LoopHintAttr(type$ptr<?>/*P*/ From) {
    assert isa_LoopHintAttr(From);
    return llvm.cast(LoopHintAttr.class, From.$star());
  }

  public static LoopHintAttr cast_or_null_LoopHintAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_LoopHintAttr(From);
  }

  public static LoopHintAttr dyn_cast_LoopHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static LoopHintAttr dyn_cast_or_null_LoopHintAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_LoopHintAttr(From) ? cast_LoopHintAttr(From) : null;
  }

  public static boolean isa_MSABIAttr(Attr/*P*/ From) {
    assert From != null;
    return MSABIAttr.classof(From);
  }

  public static MSABIAttr cast_MSABIAttr(Attr/*P*/ From) {
    assert isa_MSABIAttr(From);
    return (MSABIAttr) From;
  }

  public static MSABIAttr cast_or_null_MSABIAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSABIAttr(From);
  }

  public static MSABIAttr dyn_cast_MSABIAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static MSABIAttr dyn_cast_or_null_MSABIAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static boolean isa_MSABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSABIAttr.class, From.$deref());
  }

  public static MSABIAttr cast_MSABIAttr(type$ref<?>/*P*/ From) {
    assert isa_MSABIAttr(From);
    return llvm.cast(MSABIAttr.class, From.$deref());
  }

  public static MSABIAttr cast_or_null_MSABIAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSABIAttr(From);
  }

  public static MSABIAttr dyn_cast_MSABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static MSABIAttr dyn_cast_or_null_MSABIAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static boolean isa_MSABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSABIAttr.class, From.$star());
  }

  public static MSABIAttr cast_MSABIAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSABIAttr(From);
    return llvm.cast(MSABIAttr.class, From.$star());
  }

  public static MSABIAttr cast_or_null_MSABIAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSABIAttr(From);
  }

  public static MSABIAttr dyn_cast_MSABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static MSABIAttr dyn_cast_or_null_MSABIAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSABIAttr(From) ? cast_MSABIAttr(From) : null;
  }

  public static boolean isa_MSInheritanceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSInheritanceAttr.class, From.$deref());
  }

  public static MSInheritanceAttr cast_MSInheritanceAttr(type$ref<?>/*P*/ From) {
    assert isa_MSInheritanceAttr(From);
    return llvm.cast(MSInheritanceAttr.class, From.$deref());
  }

  public static MSInheritanceAttr cast_or_null_MSInheritanceAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSInheritanceAttr(From);
  }

  public static MSInheritanceAttr dyn_cast_MSInheritanceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static MSInheritanceAttr dyn_cast_or_null_MSInheritanceAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static boolean isa_MSInheritanceAttr(Attr/*P*/ From) {
    assert From != null;
    return MSInheritanceAttr.classof(From);
  }

  public static MSInheritanceAttr cast_MSInheritanceAttr(Attr/*P*/ From) {
    assert isa_MSInheritanceAttr(From);
    return (MSInheritanceAttr) From;
  }

  public static MSInheritanceAttr cast_or_null_MSInheritanceAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSInheritanceAttr(From);
  }

  public static MSInheritanceAttr dyn_cast_MSInheritanceAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static MSInheritanceAttr dyn_cast_or_null_MSInheritanceAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static boolean isa_MSInheritanceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSInheritanceAttr.class, From.$star());
  }

  public static MSInheritanceAttr cast_MSInheritanceAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSInheritanceAttr(From);
    return llvm.cast(MSInheritanceAttr.class, From.$star());
  }

  public static MSInheritanceAttr cast_or_null_MSInheritanceAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSInheritanceAttr(From);
  }

  public static MSInheritanceAttr dyn_cast_MSInheritanceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static MSInheritanceAttr dyn_cast_or_null_MSInheritanceAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSInheritanceAttr(From) ? cast_MSInheritanceAttr(From) : null;
  }

  public static boolean isa_MSNoVTableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSNoVTableAttr.class, From.$deref());
  }

  public static MSNoVTableAttr cast_MSNoVTableAttr(type$ref<?>/*P*/ From) {
    assert isa_MSNoVTableAttr(From);
    return llvm.cast(MSNoVTableAttr.class, From.$deref());
  }

  public static MSNoVTableAttr cast_or_null_MSNoVTableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSNoVTableAttr(From);
  }

  public static MSNoVTableAttr dyn_cast_MSNoVTableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static MSNoVTableAttr dyn_cast_or_null_MSNoVTableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static boolean isa_MSNoVTableAttr(Attr/*P*/ From) {
    assert From != null;
    return MSNoVTableAttr.classof(From);
  }

  public static MSNoVTableAttr cast_MSNoVTableAttr(Attr/*P*/ From) {
    assert isa_MSNoVTableAttr(From);
    return (MSNoVTableAttr) From;
  }

  public static MSNoVTableAttr cast_or_null_MSNoVTableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSNoVTableAttr(From);
  }

  public static MSNoVTableAttr dyn_cast_MSNoVTableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static MSNoVTableAttr dyn_cast_or_null_MSNoVTableAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static boolean isa_MSNoVTableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSNoVTableAttr.class, From.$star());
  }

  public static MSNoVTableAttr cast_MSNoVTableAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSNoVTableAttr(From);
    return llvm.cast(MSNoVTableAttr.class, From.$star());
  }

  public static MSNoVTableAttr cast_or_null_MSNoVTableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSNoVTableAttr(From);
  }

  public static MSNoVTableAttr dyn_cast_MSNoVTableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static MSNoVTableAttr dyn_cast_or_null_MSNoVTableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSNoVTableAttr(From) ? cast_MSNoVTableAttr(From) : null;
  }

  public static boolean isa_MSP430InterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSP430InterruptAttr.class, From.$star());
  }

  public static MSP430InterruptAttr cast_MSP430InterruptAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSP430InterruptAttr(From);
    return llvm.cast(MSP430InterruptAttr.class, From.$star());
  }

  public static MSP430InterruptAttr cast_or_null_MSP430InterruptAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSP430InterruptAttr(From);
  }

  public static MSP430InterruptAttr dyn_cast_MSP430InterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static MSP430InterruptAttr dyn_cast_or_null_MSP430InterruptAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static boolean isa_MSP430InterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return MSP430InterruptAttr.classof(From);
  }

  public static MSP430InterruptAttr cast_MSP430InterruptAttr(Attr/*P*/ From) {
    assert isa_MSP430InterruptAttr(From);
    return (MSP430InterruptAttr) From;
  }

  public static MSP430InterruptAttr cast_or_null_MSP430InterruptAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSP430InterruptAttr(From);
  }

  public static MSP430InterruptAttr dyn_cast_MSP430InterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static MSP430InterruptAttr dyn_cast_or_null_MSP430InterruptAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static boolean isa_MSP430InterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSP430InterruptAttr.class, From.$deref());
  }

  public static MSP430InterruptAttr cast_MSP430InterruptAttr(type$ref<?>/*P*/ From) {
    assert isa_MSP430InterruptAttr(From);
    return llvm.cast(MSP430InterruptAttr.class, From.$deref());
  }

  public static MSP430InterruptAttr cast_or_null_MSP430InterruptAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSP430InterruptAttr(From);
  }

  public static MSP430InterruptAttr dyn_cast_MSP430InterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static MSP430InterruptAttr dyn_cast_or_null_MSP430InterruptAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSP430InterruptAttr(From) ? cast_MSP430InterruptAttr(From) : null;
  }

  public static boolean isa_MSStructAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSStructAttr.class, From.$star());
  }

  public static MSStructAttr cast_MSStructAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSStructAttr(From);
    return llvm.cast(MSStructAttr.class, From.$star());
  }

  public static MSStructAttr cast_or_null_MSStructAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSStructAttr(From);
  }

  public static MSStructAttr dyn_cast_MSStructAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static MSStructAttr dyn_cast_or_null_MSStructAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static boolean isa_MSStructAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSStructAttr.class, From.$deref());
  }

  public static MSStructAttr cast_MSStructAttr(type$ref<?>/*P*/ From) {
    assert isa_MSStructAttr(From);
    return llvm.cast(MSStructAttr.class, From.$deref());
  }

  public static MSStructAttr cast_or_null_MSStructAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSStructAttr(From);
  }

  public static MSStructAttr dyn_cast_MSStructAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static MSStructAttr dyn_cast_or_null_MSStructAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static boolean isa_MSStructAttr(Attr/*P*/ From) {
    assert From != null;
    return MSStructAttr.classof(From);
  }

  public static MSStructAttr cast_MSStructAttr(Attr/*P*/ From) {
    assert isa_MSStructAttr(From);
    return (MSStructAttr) From;
  }

  public static MSStructAttr cast_or_null_MSStructAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSStructAttr(From);
  }

  public static MSStructAttr dyn_cast_MSStructAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static MSStructAttr dyn_cast_or_null_MSStructAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSStructAttr(From) ? cast_MSStructAttr(From) : null;
  }

  public static boolean isa_MSVtorDispAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MSVtorDispAttr.class, From.$deref());
  }

  public static MSVtorDispAttr cast_MSVtorDispAttr(type$ref<?>/*P*/ From) {
    assert isa_MSVtorDispAttr(From);
    return llvm.cast(MSVtorDispAttr.class, From.$deref());
  }

  public static MSVtorDispAttr cast_or_null_MSVtorDispAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MSVtorDispAttr(From);
  }

  public static MSVtorDispAttr dyn_cast_MSVtorDispAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static MSVtorDispAttr dyn_cast_or_null_MSVtorDispAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static boolean isa_MSVtorDispAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MSVtorDispAttr.class, From.$star());
  }

  public static MSVtorDispAttr cast_MSVtorDispAttr(type$ptr<?>/*P*/ From) {
    assert isa_MSVtorDispAttr(From);
    return llvm.cast(MSVtorDispAttr.class, From.$star());
  }

  public static MSVtorDispAttr cast_or_null_MSVtorDispAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MSVtorDispAttr(From);
  }

  public static MSVtorDispAttr dyn_cast_MSVtorDispAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static MSVtorDispAttr dyn_cast_or_null_MSVtorDispAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static boolean isa_MSVtorDispAttr(Attr/*P*/ From) {
    assert From != null;
    return MSVtorDispAttr.classof(From);
  }

  public static MSVtorDispAttr cast_MSVtorDispAttr(Attr/*P*/ From) {
    assert isa_MSVtorDispAttr(From);
    return (MSVtorDispAttr) From;
  }

  public static MSVtorDispAttr cast_or_null_MSVtorDispAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MSVtorDispAttr(From);
  }

  public static MSVtorDispAttr dyn_cast_MSVtorDispAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static MSVtorDispAttr dyn_cast_or_null_MSVtorDispAttr(Attr/*P*/ From) {
    return (From != null) && isa_MSVtorDispAttr(From) ? cast_MSVtorDispAttr(From) : null;
  }

  public static boolean isa_MaxFieldAlignmentAttr(Attr/*P*/ From) {
    assert From != null;
    return MaxFieldAlignmentAttr.classof(From);
  }

  public static MaxFieldAlignmentAttr cast_MaxFieldAlignmentAttr(Attr/*P*/ From) {
    assert isa_MaxFieldAlignmentAttr(From);
    return (MaxFieldAlignmentAttr) From;
  }

  public static MaxFieldAlignmentAttr cast_or_null_MaxFieldAlignmentAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MaxFieldAlignmentAttr(From);
  }

  public static MaxFieldAlignmentAttr dyn_cast_MaxFieldAlignmentAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static MaxFieldAlignmentAttr dyn_cast_or_null_MaxFieldAlignmentAttr(Attr/*P*/ From) {
    return (From != null) && isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static boolean isa_MaxFieldAlignmentAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MaxFieldAlignmentAttr.class, From.$star());
  }

  public static MaxFieldAlignmentAttr cast_MaxFieldAlignmentAttr(type$ptr<?>/*P*/ From) {
    assert isa_MaxFieldAlignmentAttr(From);
    return llvm.cast(MaxFieldAlignmentAttr.class, From.$star());
  }

  public static MaxFieldAlignmentAttr cast_or_null_MaxFieldAlignmentAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MaxFieldAlignmentAttr(From);
  }

  public static MaxFieldAlignmentAttr dyn_cast_MaxFieldAlignmentAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static MaxFieldAlignmentAttr dyn_cast_or_null_MaxFieldAlignmentAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static boolean isa_MaxFieldAlignmentAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MaxFieldAlignmentAttr.class, From.$deref());
  }

  public static MaxFieldAlignmentAttr cast_MaxFieldAlignmentAttr(type$ref<?>/*P*/ From) {
    assert isa_MaxFieldAlignmentAttr(From);
    return llvm.cast(MaxFieldAlignmentAttr.class, From.$deref());
  }

  public static MaxFieldAlignmentAttr cast_or_null_MaxFieldAlignmentAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MaxFieldAlignmentAttr(From);
  }

  public static MaxFieldAlignmentAttr dyn_cast_MaxFieldAlignmentAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static MaxFieldAlignmentAttr dyn_cast_or_null_MaxFieldAlignmentAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MaxFieldAlignmentAttr(From) ? cast_MaxFieldAlignmentAttr(From) : null;
  }

  public static boolean isa_MayAliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MayAliasAttr.class, From.$deref());
  }

  public static MayAliasAttr cast_MayAliasAttr(type$ref<?>/*P*/ From) {
    assert isa_MayAliasAttr(From);
    return llvm.cast(MayAliasAttr.class, From.$deref());
  }

  public static MayAliasAttr cast_or_null_MayAliasAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MayAliasAttr(From);
  }

  public static MayAliasAttr dyn_cast_MayAliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static MayAliasAttr dyn_cast_or_null_MayAliasAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static boolean isa_MayAliasAttr(Attr/*P*/ From) {
    assert From != null;
    return MayAliasAttr.classof(From);
  }

  public static MayAliasAttr cast_MayAliasAttr(Attr/*P*/ From) {
    assert isa_MayAliasAttr(From);
    return (MayAliasAttr) From;
  }

  public static MayAliasAttr cast_or_null_MayAliasAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MayAliasAttr(From);
  }

  public static MayAliasAttr dyn_cast_MayAliasAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static MayAliasAttr dyn_cast_or_null_MayAliasAttr(Attr/*P*/ From) {
    return (From != null) && isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static boolean isa_MayAliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MayAliasAttr.class, From.$star());
  }

  public static MayAliasAttr cast_MayAliasAttr(type$ptr<?>/*P*/ From) {
    assert isa_MayAliasAttr(From);
    return llvm.cast(MayAliasAttr.class, From.$star());
  }

  public static MayAliasAttr cast_or_null_MayAliasAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MayAliasAttr(From);
  }

  public static MayAliasAttr dyn_cast_MayAliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static MayAliasAttr dyn_cast_or_null_MayAliasAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MayAliasAttr(From) ? cast_MayAliasAttr(From) : null;
  }

  public static boolean isa_MinSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return MinSizeAttr.classof(From);
  }

  public static MinSizeAttr cast_MinSizeAttr(Attr/*P*/ From) {
    assert isa_MinSizeAttr(From);
    return (MinSizeAttr) From;
  }

  public static MinSizeAttr cast_or_null_MinSizeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MinSizeAttr(From);
  }

  public static MinSizeAttr dyn_cast_MinSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static MinSizeAttr dyn_cast_or_null_MinSizeAttr(Attr/*P*/ From) {
    return (From != null) && isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static boolean isa_MinSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MinSizeAttr.class, From.$star());
  }

  public static MinSizeAttr cast_MinSizeAttr(type$ptr<?>/*P*/ From) {
    assert isa_MinSizeAttr(From);
    return llvm.cast(MinSizeAttr.class, From.$star());
  }

  public static MinSizeAttr cast_or_null_MinSizeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MinSizeAttr(From);
  }

  public static MinSizeAttr dyn_cast_MinSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static MinSizeAttr dyn_cast_or_null_MinSizeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static boolean isa_MinSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MinSizeAttr.class, From.$deref());
  }

  public static MinSizeAttr cast_MinSizeAttr(type$ref<?>/*P*/ From) {
    assert isa_MinSizeAttr(From);
    return llvm.cast(MinSizeAttr.class, From.$deref());
  }

  public static MinSizeAttr cast_or_null_MinSizeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MinSizeAttr(From);
  }

  public static MinSizeAttr dyn_cast_MinSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static MinSizeAttr dyn_cast_or_null_MinSizeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MinSizeAttr(From) ? cast_MinSizeAttr(From) : null;
  }

  public static boolean isa_Mips16Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Mips16Attr.class, From.$deref());
  }

  public static Mips16Attr cast_Mips16Attr(type$ref<?>/*P*/ From) {
    assert isa_Mips16Attr(From);
    return llvm.cast(Mips16Attr.class, From.$deref());
  }

  public static Mips16Attr cast_or_null_Mips16Attr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Mips16Attr(From);
  }

  public static Mips16Attr dyn_cast_Mips16Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static Mips16Attr dyn_cast_or_null_Mips16Attr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static boolean isa_Mips16Attr(Attr/*P*/ From) {
    assert From != null;
    return Mips16Attr.classof(From);
  }

  public static Mips16Attr cast_Mips16Attr(Attr/*P*/ From) {
    assert isa_Mips16Attr(From);
    return (Mips16Attr) From;
  }

  public static Mips16Attr cast_or_null_Mips16Attr(Attr/*P*/ From) {
    return (From == null) ? null : cast_Mips16Attr(From);
  }

  public static Mips16Attr dyn_cast_Mips16Attr(Attr/*P*/ From) {
    assert From != null;
    return isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static Mips16Attr dyn_cast_or_null_Mips16Attr(Attr/*P*/ From) {
    return (From != null) && isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static boolean isa_Mips16Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Mips16Attr.class, From.$star());
  }

  public static Mips16Attr cast_Mips16Attr(type$ptr<?>/*P*/ From) {
    assert isa_Mips16Attr(From);
    return llvm.cast(Mips16Attr.class, From.$star());
  }

  public static Mips16Attr cast_or_null_Mips16Attr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Mips16Attr(From);
  }

  public static Mips16Attr dyn_cast_Mips16Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static Mips16Attr dyn_cast_or_null_Mips16Attr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Mips16Attr(From) ? cast_Mips16Attr(From) : null;
  }

  public static boolean isa_MipsInterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MipsInterruptAttr.class, From.$deref());
  }

  public static MipsInterruptAttr cast_MipsInterruptAttr(type$ref<?>/*P*/ From) {
    assert isa_MipsInterruptAttr(From);
    return llvm.cast(MipsInterruptAttr.class, From.$deref());
  }

  public static MipsInterruptAttr cast_or_null_MipsInterruptAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MipsInterruptAttr(From);
  }

  public static MipsInterruptAttr dyn_cast_MipsInterruptAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static MipsInterruptAttr dyn_cast_or_null_MipsInterruptAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static boolean isa_MipsInterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return MipsInterruptAttr.classof(From);
  }

  public static MipsInterruptAttr cast_MipsInterruptAttr(Attr/*P*/ From) {
    assert isa_MipsInterruptAttr(From);
    return (MipsInterruptAttr) From;
  }

  public static MipsInterruptAttr cast_or_null_MipsInterruptAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_MipsInterruptAttr(From);
  }

  public static MipsInterruptAttr dyn_cast_MipsInterruptAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static MipsInterruptAttr dyn_cast_or_null_MipsInterruptAttr(Attr/*P*/ From) {
    return (From != null) && isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static boolean isa_MipsInterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MipsInterruptAttr.class, From.$star());
  }

  public static MipsInterruptAttr cast_MipsInterruptAttr(type$ptr<?>/*P*/ From) {
    assert isa_MipsInterruptAttr(From);
    return llvm.cast(MipsInterruptAttr.class, From.$star());
  }

  public static MipsInterruptAttr cast_or_null_MipsInterruptAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MipsInterruptAttr(From);
  }

  public static MipsInterruptAttr dyn_cast_MipsInterruptAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static MipsInterruptAttr dyn_cast_or_null_MipsInterruptAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MipsInterruptAttr(From) ? cast_MipsInterruptAttr(From) : null;
  }

  public static boolean isa_ModeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ModeAttr.class, From.$star());
  }

  public static ModeAttr cast_ModeAttr(type$ptr<?>/*P*/ From) {
    assert isa_ModeAttr(From);
    return llvm.cast(ModeAttr.class, From.$star());
  }

  public static ModeAttr cast_or_null_ModeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ModeAttr(From);
  }

  public static ModeAttr dyn_cast_ModeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static ModeAttr dyn_cast_or_null_ModeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static boolean isa_ModeAttr(Attr/*P*/ From) {
    assert From != null;
    return ModeAttr.classof(From);
  }

  public static ModeAttr cast_ModeAttr(Attr/*P*/ From) {
    assert isa_ModeAttr(From);
    return (ModeAttr) From;
  }

  public static ModeAttr cast_or_null_ModeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ModeAttr(From);
  }

  public static ModeAttr dyn_cast_ModeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static ModeAttr dyn_cast_or_null_ModeAttr(Attr/*P*/ From) {
    return (From != null) && isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static boolean isa_ModeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ModeAttr.class, From.$deref());
  }

  public static ModeAttr cast_ModeAttr(type$ref<?>/*P*/ From) {
    assert isa_ModeAttr(From);
    return llvm.cast(ModeAttr.class, From.$deref());
  }

  public static ModeAttr cast_or_null_ModeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ModeAttr(From);
  }

  public static ModeAttr dyn_cast_ModeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static ModeAttr dyn_cast_or_null_ModeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ModeAttr(From) ? cast_ModeAttr(From) : null;
  }

  public static boolean isa_NSConsumedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NSConsumedAttr.class, From.$deref());
  }

  public static NSConsumedAttr cast_NSConsumedAttr(type$ref<?>/*P*/ From) {
    assert isa_NSConsumedAttr(From);
    return llvm.cast(NSConsumedAttr.class, From.$deref());
  }

  public static NSConsumedAttr cast_or_null_NSConsumedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NSConsumedAttr(From);
  }

  public static NSConsumedAttr dyn_cast_NSConsumedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static NSConsumedAttr dyn_cast_or_null_NSConsumedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static boolean isa_NSConsumedAttr(Attr/*P*/ From) {
    assert From != null;
    return NSConsumedAttr.classof(From);
  }

  public static NSConsumedAttr cast_NSConsumedAttr(Attr/*P*/ From) {
    assert isa_NSConsumedAttr(From);
    return (NSConsumedAttr) From;
  }

  public static NSConsumedAttr cast_or_null_NSConsumedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NSConsumedAttr(From);
  }

  public static NSConsumedAttr dyn_cast_NSConsumedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static NSConsumedAttr dyn_cast_or_null_NSConsumedAttr(Attr/*P*/ From) {
    return (From != null) && isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static boolean isa_NSConsumedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NSConsumedAttr.class, From.$star());
  }

  public static NSConsumedAttr cast_NSConsumedAttr(type$ptr<?>/*P*/ From) {
    assert isa_NSConsumedAttr(From);
    return llvm.cast(NSConsumedAttr.class, From.$star());
  }

  public static NSConsumedAttr cast_or_null_NSConsumedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NSConsumedAttr(From);
  }

  public static NSConsumedAttr dyn_cast_NSConsumedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static NSConsumedAttr dyn_cast_or_null_NSConsumedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NSConsumedAttr(From) ? cast_NSConsumedAttr(From) : null;
  }

  public static boolean isa_NSConsumesSelfAttr(Attr/*P*/ From) {
    assert From != null;
    return NSConsumesSelfAttr.classof(From);
  }

  public static NSConsumesSelfAttr cast_NSConsumesSelfAttr(Attr/*P*/ From) {
    assert isa_NSConsumesSelfAttr(From);
    return (NSConsumesSelfAttr) From;
  }

  public static NSConsumesSelfAttr cast_or_null_NSConsumesSelfAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NSConsumesSelfAttr(From);
  }

  public static NSConsumesSelfAttr dyn_cast_NSConsumesSelfAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static NSConsumesSelfAttr dyn_cast_or_null_NSConsumesSelfAttr(Attr/*P*/ From) {
    return (From != null) && isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static boolean isa_NSConsumesSelfAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NSConsumesSelfAttr.class, From.$star());
  }

  public static NSConsumesSelfAttr cast_NSConsumesSelfAttr(type$ptr<?>/*P*/ From) {
    assert isa_NSConsumesSelfAttr(From);
    return llvm.cast(NSConsumesSelfAttr.class, From.$star());
  }

  public static NSConsumesSelfAttr cast_or_null_NSConsumesSelfAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NSConsumesSelfAttr(From);
  }

  public static NSConsumesSelfAttr dyn_cast_NSConsumesSelfAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static NSConsumesSelfAttr dyn_cast_or_null_NSConsumesSelfAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static boolean isa_NSConsumesSelfAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NSConsumesSelfAttr.class, From.$deref());
  }

  public static NSConsumesSelfAttr cast_NSConsumesSelfAttr(type$ref<?>/*P*/ From) {
    assert isa_NSConsumesSelfAttr(From);
    return llvm.cast(NSConsumesSelfAttr.class, From.$deref());
  }

  public static NSConsumesSelfAttr cast_or_null_NSConsumesSelfAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NSConsumesSelfAttr(From);
  }

  public static NSConsumesSelfAttr dyn_cast_NSConsumesSelfAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static NSConsumesSelfAttr dyn_cast_or_null_NSConsumesSelfAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NSConsumesSelfAttr(From) ? cast_NSConsumesSelfAttr(From) : null;
  }

  public static boolean isa_NSReturnsAutoreleasedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NSReturnsAutoreleasedAttr.class, From.$deref());
  }

  public static NSReturnsAutoreleasedAttr cast_NSReturnsAutoreleasedAttr(type$ref<?>/*P*/ From) {
    assert isa_NSReturnsAutoreleasedAttr(From);
    return llvm.cast(NSReturnsAutoreleasedAttr.class, From.$deref());
  }

  public static NSReturnsAutoreleasedAttr cast_or_null_NSReturnsAutoreleasedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NSReturnsAutoreleasedAttr(From);
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_NSReturnsAutoreleasedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_or_null_NSReturnsAutoreleasedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static boolean isa_NSReturnsAutoreleasedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NSReturnsAutoreleasedAttr.class, From.$star());
  }

  public static NSReturnsAutoreleasedAttr cast_NSReturnsAutoreleasedAttr(type$ptr<?>/*P*/ From) {
    assert isa_NSReturnsAutoreleasedAttr(From);
    return llvm.cast(NSReturnsAutoreleasedAttr.class, From.$star());
  }

  public static NSReturnsAutoreleasedAttr cast_or_null_NSReturnsAutoreleasedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NSReturnsAutoreleasedAttr(From);
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_NSReturnsAutoreleasedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_or_null_NSReturnsAutoreleasedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static boolean isa_NSReturnsAutoreleasedAttr(Attr/*P*/ From) {
    assert From != null;
    return NSReturnsAutoreleasedAttr.classof(From);
  }

  public static NSReturnsAutoreleasedAttr cast_NSReturnsAutoreleasedAttr(Attr/*P*/ From) {
    assert isa_NSReturnsAutoreleasedAttr(From);
    return (NSReturnsAutoreleasedAttr) From;
  }

  public static NSReturnsAutoreleasedAttr cast_or_null_NSReturnsAutoreleasedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NSReturnsAutoreleasedAttr(From);
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_NSReturnsAutoreleasedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static NSReturnsAutoreleasedAttr dyn_cast_or_null_NSReturnsAutoreleasedAttr(Attr/*P*/ From) {
    return (From != null) && isa_NSReturnsAutoreleasedAttr(From) ? cast_NSReturnsAutoreleasedAttr(From) : null;
  }

  public static boolean isa_NSReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NSReturnsNotRetainedAttr.class, From.$deref());
  }

  public static NSReturnsNotRetainedAttr cast_NSReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert isa_NSReturnsNotRetainedAttr(From);
    return llvm.cast(NSReturnsNotRetainedAttr.class, From.$deref());
  }

  public static NSReturnsNotRetainedAttr cast_or_null_NSReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NSReturnsNotRetainedAttr(From);
  }

  public static NSReturnsNotRetainedAttr dyn_cast_NSReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static NSReturnsNotRetainedAttr dyn_cast_or_null_NSReturnsNotRetainedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_NSReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return NSReturnsNotRetainedAttr.classof(From);
  }

  public static NSReturnsNotRetainedAttr cast_NSReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert isa_NSReturnsNotRetainedAttr(From);
    return (NSReturnsNotRetainedAttr) From;
  }

  public static NSReturnsNotRetainedAttr cast_or_null_NSReturnsNotRetainedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NSReturnsNotRetainedAttr(From);
  }

  public static NSReturnsNotRetainedAttr dyn_cast_NSReturnsNotRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static NSReturnsNotRetainedAttr dyn_cast_or_null_NSReturnsNotRetainedAttr(Attr/*P*/ From) {
    return (From != null) && isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_NSReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NSReturnsNotRetainedAttr.class, From.$star());
  }

  public static NSReturnsNotRetainedAttr cast_NSReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert isa_NSReturnsNotRetainedAttr(From);
    return llvm.cast(NSReturnsNotRetainedAttr.class, From.$star());
  }

  public static NSReturnsNotRetainedAttr cast_or_null_NSReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NSReturnsNotRetainedAttr(From);
  }

  public static NSReturnsNotRetainedAttr dyn_cast_NSReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static NSReturnsNotRetainedAttr dyn_cast_or_null_NSReturnsNotRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NSReturnsNotRetainedAttr(From) ? cast_NSReturnsNotRetainedAttr(From) : null;
  }

  public static boolean isa_NSReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NSReturnsRetainedAttr.class, From.$star());
  }

  public static NSReturnsRetainedAttr cast_NSReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert isa_NSReturnsRetainedAttr(From);
    return llvm.cast(NSReturnsRetainedAttr.class, From.$star());
  }

  public static NSReturnsRetainedAttr cast_or_null_NSReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NSReturnsRetainedAttr(From);
  }

  public static NSReturnsRetainedAttr dyn_cast_NSReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static NSReturnsRetainedAttr dyn_cast_or_null_NSReturnsRetainedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_NSReturnsRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return NSReturnsRetainedAttr.classof(From);
  }

  public static NSReturnsRetainedAttr cast_NSReturnsRetainedAttr(Attr/*P*/ From) {
    assert isa_NSReturnsRetainedAttr(From);
    return (NSReturnsRetainedAttr) From;
  }

  public static NSReturnsRetainedAttr cast_or_null_NSReturnsRetainedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NSReturnsRetainedAttr(From);
  }

  public static NSReturnsRetainedAttr dyn_cast_NSReturnsRetainedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static NSReturnsRetainedAttr dyn_cast_or_null_NSReturnsRetainedAttr(Attr/*P*/ From) {
    return (From != null) && isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_NSReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NSReturnsRetainedAttr.class, From.$deref());
  }

  public static NSReturnsRetainedAttr cast_NSReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert isa_NSReturnsRetainedAttr(From);
    return llvm.cast(NSReturnsRetainedAttr.class, From.$deref());
  }

  public static NSReturnsRetainedAttr cast_or_null_NSReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NSReturnsRetainedAttr(From);
  }

  public static NSReturnsRetainedAttr dyn_cast_NSReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static NSReturnsRetainedAttr dyn_cast_or_null_NSReturnsRetainedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NSReturnsRetainedAttr(From) ? cast_NSReturnsRetainedAttr(From) : null;
  }

  public static boolean isa_NakedAttr(Attr/*P*/ From) {
    assert From != null;
    return NakedAttr.classof(From);
  }

  public static NakedAttr cast_NakedAttr(Attr/*P*/ From) {
    assert isa_NakedAttr(From);
    return (NakedAttr) From;
  }

  public static NakedAttr cast_or_null_NakedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NakedAttr(From);
  }

  public static NakedAttr dyn_cast_NakedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static NakedAttr dyn_cast_or_null_NakedAttr(Attr/*P*/ From) {
    return (From != null) && isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static boolean isa_NakedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NakedAttr.class, From.$star());
  }

  public static NakedAttr cast_NakedAttr(type$ptr<?>/*P*/ From) {
    assert isa_NakedAttr(From);
    return llvm.cast(NakedAttr.class, From.$star());
  }

  public static NakedAttr cast_or_null_NakedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NakedAttr(From);
  }

  public static NakedAttr dyn_cast_NakedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static NakedAttr dyn_cast_or_null_NakedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static boolean isa_NakedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NakedAttr.class, From.$deref());
  }

  public static NakedAttr cast_NakedAttr(type$ref<?>/*P*/ From) {
    assert isa_NakedAttr(From);
    return llvm.cast(NakedAttr.class, From.$deref());
  }

  public static NakedAttr cast_or_null_NakedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NakedAttr(From);
  }

  public static NakedAttr dyn_cast_NakedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static NakedAttr dyn_cast_or_null_NakedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NakedAttr(From) ? cast_NakedAttr(From) : null;
  }

  public static boolean isa_NoAliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoAliasAttr.class, From.$deref());
  }

  public static NoAliasAttr cast_NoAliasAttr(type$ref<?>/*P*/ From) {
    assert isa_NoAliasAttr(From);
    return llvm.cast(NoAliasAttr.class, From.$deref());
  }

  public static NoAliasAttr cast_or_null_NoAliasAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoAliasAttr(From);
  }

  public static NoAliasAttr dyn_cast_NoAliasAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static NoAliasAttr dyn_cast_or_null_NoAliasAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static boolean isa_NoAliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoAliasAttr.class, From.$star());
  }

  public static NoAliasAttr cast_NoAliasAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoAliasAttr(From);
    return llvm.cast(NoAliasAttr.class, From.$star());
  }

  public static NoAliasAttr cast_or_null_NoAliasAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoAliasAttr(From);
  }

  public static NoAliasAttr dyn_cast_NoAliasAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static NoAliasAttr dyn_cast_or_null_NoAliasAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static boolean isa_NoAliasAttr(Attr/*P*/ From) {
    assert From != null;
    return NoAliasAttr.classof(From);
  }

  public static NoAliasAttr cast_NoAliasAttr(Attr/*P*/ From) {
    assert isa_NoAliasAttr(From);
    return (NoAliasAttr) From;
  }

  public static NoAliasAttr cast_or_null_NoAliasAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoAliasAttr(From);
  }

  public static NoAliasAttr dyn_cast_NoAliasAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static NoAliasAttr dyn_cast_or_null_NoAliasAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoAliasAttr(From) ? cast_NoAliasAttr(From) : null;
  }

  public static boolean isa_NoCommonAttr(Attr/*P*/ From) {
    assert From != null;
    return NoCommonAttr.classof(From);
  }

  public static NoCommonAttr cast_NoCommonAttr(Attr/*P*/ From) {
    assert isa_NoCommonAttr(From);
    return (NoCommonAttr) From;
  }

  public static NoCommonAttr cast_or_null_NoCommonAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoCommonAttr(From);
  }

  public static NoCommonAttr dyn_cast_NoCommonAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static NoCommonAttr dyn_cast_or_null_NoCommonAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static boolean isa_NoCommonAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoCommonAttr.class, From.$star());
  }

  public static NoCommonAttr cast_NoCommonAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoCommonAttr(From);
    return llvm.cast(NoCommonAttr.class, From.$star());
  }

  public static NoCommonAttr cast_or_null_NoCommonAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoCommonAttr(From);
  }

  public static NoCommonAttr dyn_cast_NoCommonAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static NoCommonAttr dyn_cast_or_null_NoCommonAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static boolean isa_NoCommonAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoCommonAttr.class, From.$deref());
  }

  public static NoCommonAttr cast_NoCommonAttr(type$ref<?>/*P*/ From) {
    assert isa_NoCommonAttr(From);
    return llvm.cast(NoCommonAttr.class, From.$deref());
  }

  public static NoCommonAttr cast_or_null_NoCommonAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoCommonAttr(From);
  }

  public static NoCommonAttr dyn_cast_NoCommonAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static NoCommonAttr dyn_cast_or_null_NoCommonAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoCommonAttr(From) ? cast_NoCommonAttr(From) : null;
  }

  public static boolean isa_NoDebugAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoDebugAttr.class, From.$star());
  }

  public static NoDebugAttr cast_NoDebugAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoDebugAttr(From);
    return llvm.cast(NoDebugAttr.class, From.$star());
  }

  public static NoDebugAttr cast_or_null_NoDebugAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoDebugAttr(From);
  }

  public static NoDebugAttr dyn_cast_NoDebugAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static NoDebugAttr dyn_cast_or_null_NoDebugAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static boolean isa_NoDebugAttr(Attr/*P*/ From) {
    assert From != null;
    return NoDebugAttr.classof(From);
  }

  public static NoDebugAttr cast_NoDebugAttr(Attr/*P*/ From) {
    assert isa_NoDebugAttr(From);
    return (NoDebugAttr) From;
  }

  public static NoDebugAttr cast_or_null_NoDebugAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoDebugAttr(From);
  }

  public static NoDebugAttr dyn_cast_NoDebugAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static NoDebugAttr dyn_cast_or_null_NoDebugAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static boolean isa_NoDebugAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoDebugAttr.class, From.$deref());
  }

  public static NoDebugAttr cast_NoDebugAttr(type$ref<?>/*P*/ From) {
    assert isa_NoDebugAttr(From);
    return llvm.cast(NoDebugAttr.class, From.$deref());
  }

  public static NoDebugAttr cast_or_null_NoDebugAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoDebugAttr(From);
  }

  public static NoDebugAttr dyn_cast_NoDebugAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static NoDebugAttr dyn_cast_or_null_NoDebugAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoDebugAttr(From) ? cast_NoDebugAttr(From) : null;
  }

  public static boolean isa_NoDuplicateAttr(Attr/*P*/ From) {
    assert From != null;
    return NoDuplicateAttr.classof(From);
  }

  public static NoDuplicateAttr cast_NoDuplicateAttr(Attr/*P*/ From) {
    assert isa_NoDuplicateAttr(From);
    return (NoDuplicateAttr) From;
  }

  public static NoDuplicateAttr cast_or_null_NoDuplicateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoDuplicateAttr(From);
  }

  public static NoDuplicateAttr dyn_cast_NoDuplicateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static NoDuplicateAttr dyn_cast_or_null_NoDuplicateAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static boolean isa_NoDuplicateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoDuplicateAttr.class, From.$deref());
  }

  public static NoDuplicateAttr cast_NoDuplicateAttr(type$ref<?>/*P*/ From) {
    assert isa_NoDuplicateAttr(From);
    return llvm.cast(NoDuplicateAttr.class, From.$deref());
  }

  public static NoDuplicateAttr cast_or_null_NoDuplicateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoDuplicateAttr(From);
  }

  public static NoDuplicateAttr dyn_cast_NoDuplicateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static NoDuplicateAttr dyn_cast_or_null_NoDuplicateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static boolean isa_NoDuplicateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoDuplicateAttr.class, From.$star());
  }

  public static NoDuplicateAttr cast_NoDuplicateAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoDuplicateAttr(From);
    return llvm.cast(NoDuplicateAttr.class, From.$star());
  }

  public static NoDuplicateAttr cast_or_null_NoDuplicateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoDuplicateAttr(From);
  }

  public static NoDuplicateAttr dyn_cast_NoDuplicateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static NoDuplicateAttr dyn_cast_or_null_NoDuplicateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoDuplicateAttr(From) ? cast_NoDuplicateAttr(From) : null;
  }

  public static boolean isa_NoInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoInlineAttr.class, From.$star());
  }

  public static NoInlineAttr cast_NoInlineAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoInlineAttr(From);
    return llvm.cast(NoInlineAttr.class, From.$star());
  }

  public static NoInlineAttr cast_or_null_NoInlineAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoInlineAttr(From);
  }

  public static NoInlineAttr dyn_cast_NoInlineAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static NoInlineAttr dyn_cast_or_null_NoInlineAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static boolean isa_NoInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return NoInlineAttr.classof(From);
  }

  public static NoInlineAttr cast_NoInlineAttr(Attr/*P*/ From) {
    assert isa_NoInlineAttr(From);
    return (NoInlineAttr) From;
  }

  public static NoInlineAttr cast_or_null_NoInlineAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoInlineAttr(From);
  }

  public static NoInlineAttr dyn_cast_NoInlineAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static NoInlineAttr dyn_cast_or_null_NoInlineAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static boolean isa_NoInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoInlineAttr.class, From.$deref());
  }

  public static NoInlineAttr cast_NoInlineAttr(type$ref<?>/*P*/ From) {
    assert isa_NoInlineAttr(From);
    return llvm.cast(NoInlineAttr.class, From.$deref());
  }

  public static NoInlineAttr cast_or_null_NoInlineAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoInlineAttr(From);
  }

  public static NoInlineAttr dyn_cast_NoInlineAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static NoInlineAttr dyn_cast_or_null_NoInlineAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoInlineAttr(From) ? cast_NoInlineAttr(From) : null;
  }

  public static boolean isa_NoInstrumentFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoInstrumentFunctionAttr.class, From.$deref());
  }

  public static NoInstrumentFunctionAttr cast_NoInstrumentFunctionAttr(type$ref<?>/*P*/ From) {
    assert isa_NoInstrumentFunctionAttr(From);
    return llvm.cast(NoInstrumentFunctionAttr.class, From.$deref());
  }

  public static NoInstrumentFunctionAttr cast_or_null_NoInstrumentFunctionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoInstrumentFunctionAttr(From);
  }

  public static NoInstrumentFunctionAttr dyn_cast_NoInstrumentFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static NoInstrumentFunctionAttr dyn_cast_or_null_NoInstrumentFunctionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static boolean isa_NoInstrumentFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoInstrumentFunctionAttr.class, From.$star());
  }

  public static NoInstrumentFunctionAttr cast_NoInstrumentFunctionAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoInstrumentFunctionAttr(From);
    return llvm.cast(NoInstrumentFunctionAttr.class, From.$star());
  }

  public static NoInstrumentFunctionAttr cast_or_null_NoInstrumentFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoInstrumentFunctionAttr(From);
  }

  public static NoInstrumentFunctionAttr dyn_cast_NoInstrumentFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static NoInstrumentFunctionAttr dyn_cast_or_null_NoInstrumentFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static boolean isa_NoInstrumentFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return NoInstrumentFunctionAttr.classof(From);
  }

  public static NoInstrumentFunctionAttr cast_NoInstrumentFunctionAttr(Attr/*P*/ From) {
    assert isa_NoInstrumentFunctionAttr(From);
    return (NoInstrumentFunctionAttr) From;
  }

  public static NoInstrumentFunctionAttr cast_or_null_NoInstrumentFunctionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoInstrumentFunctionAttr(From);
  }

  public static NoInstrumentFunctionAttr dyn_cast_NoInstrumentFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static NoInstrumentFunctionAttr dyn_cast_or_null_NoInstrumentFunctionAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoInstrumentFunctionAttr(From) ? cast_NoInstrumentFunctionAttr(From) : null;
  }

  public static boolean isa_NoMips16Attr(Attr/*P*/ From) {
    assert From != null;
    return NoMips16Attr.classof(From);
  }

  public static NoMips16Attr cast_NoMips16Attr(Attr/*P*/ From) {
    assert isa_NoMips16Attr(From);
    return (NoMips16Attr) From;
  }

  public static NoMips16Attr cast_or_null_NoMips16Attr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoMips16Attr(From);
  }

  public static NoMips16Attr dyn_cast_NoMips16Attr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static NoMips16Attr dyn_cast_or_null_NoMips16Attr(Attr/*P*/ From) {
    return (From != null) && isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static boolean isa_NoMips16Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoMips16Attr.class, From.$star());
  }

  public static NoMips16Attr cast_NoMips16Attr(type$ptr<?>/*P*/ From) {
    assert isa_NoMips16Attr(From);
    return llvm.cast(NoMips16Attr.class, From.$star());
  }

  public static NoMips16Attr cast_or_null_NoMips16Attr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoMips16Attr(From);
  }

  public static NoMips16Attr dyn_cast_NoMips16Attr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static NoMips16Attr dyn_cast_or_null_NoMips16Attr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static boolean isa_NoMips16Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoMips16Attr.class, From.$deref());
  }

  public static NoMips16Attr cast_NoMips16Attr(type$ref<?>/*P*/ From) {
    assert isa_NoMips16Attr(From);
    return llvm.cast(NoMips16Attr.class, From.$deref());
  }

  public static NoMips16Attr cast_or_null_NoMips16Attr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoMips16Attr(From);
  }

  public static NoMips16Attr dyn_cast_NoMips16Attr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static NoMips16Attr dyn_cast_or_null_NoMips16Attr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoMips16Attr(From) ? cast_NoMips16Attr(From) : null;
  }

  public static boolean isa_NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoReturnAttr.class, From.$deref());
  }

  public static NoReturnAttr cast_NoReturnAttr(type$ref<?>/*P*/ From) {
    assert isa_NoReturnAttr(From);
    return llvm.cast(NoReturnAttr.class, From.$deref());
  }

  public static NoReturnAttr cast_or_null_NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoReturnAttr(From);
  }

  public static NoReturnAttr dyn_cast_NoReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static NoReturnAttr dyn_cast_or_null_NoReturnAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static boolean isa_NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoReturnAttr.class, From.$star());
  }

  public static NoReturnAttr cast_NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoReturnAttr(From);
    return llvm.cast(NoReturnAttr.class, From.$star());
  }

  public static NoReturnAttr cast_or_null_NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoReturnAttr(From);
  }

  public static NoReturnAttr dyn_cast_NoReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static NoReturnAttr dyn_cast_or_null_NoReturnAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static boolean isa_NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return NoReturnAttr.classof(From);
  }

  public static NoReturnAttr cast_NoReturnAttr(Attr/*P*/ From) {
    assert isa_NoReturnAttr(From);
    return (NoReturnAttr) From;
  }

  public static NoReturnAttr cast_or_null_NoReturnAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoReturnAttr(From);
  }

  public static NoReturnAttr dyn_cast_NoReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static NoReturnAttr dyn_cast_or_null_NoReturnAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoReturnAttr(From) ? cast_NoReturnAttr(From) : null;
  }

  public static boolean isa_NoSanitizeAttr(Attr/*P*/ From) {
    assert From != null;
    return NoSanitizeAttr.classof(From);
  }

  public static NoSanitizeAttr cast_NoSanitizeAttr(Attr/*P*/ From) {
    assert isa_NoSanitizeAttr(From);
    return (NoSanitizeAttr) From;
  }

  public static NoSanitizeAttr cast_or_null_NoSanitizeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoSanitizeAttr(From);
  }

  public static NoSanitizeAttr dyn_cast_NoSanitizeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static NoSanitizeAttr dyn_cast_or_null_NoSanitizeAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static boolean isa_NoSanitizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoSanitizeAttr.class, From.$deref());
  }

  public static NoSanitizeAttr cast_NoSanitizeAttr(type$ref<?>/*P*/ From) {
    assert isa_NoSanitizeAttr(From);
    return llvm.cast(NoSanitizeAttr.class, From.$deref());
  }

  public static NoSanitizeAttr cast_or_null_NoSanitizeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoSanitizeAttr(From);
  }

  public static NoSanitizeAttr dyn_cast_NoSanitizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static NoSanitizeAttr dyn_cast_or_null_NoSanitizeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static boolean isa_NoSanitizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoSanitizeAttr.class, From.$star());
  }

  public static NoSanitizeAttr cast_NoSanitizeAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoSanitizeAttr(From);
    return llvm.cast(NoSanitizeAttr.class, From.$star());
  }

  public static NoSanitizeAttr cast_or_null_NoSanitizeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoSanitizeAttr(From);
  }

  public static NoSanitizeAttr dyn_cast_NoSanitizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static NoSanitizeAttr dyn_cast_or_null_NoSanitizeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoSanitizeAttr(From) ? cast_NoSanitizeAttr(From) : null;
  }

  public static boolean isa_NoSplitStackAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoSplitStackAttr.class, From.$star());
  }

  public static NoSplitStackAttr cast_NoSplitStackAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoSplitStackAttr(From);
    return llvm.cast(NoSplitStackAttr.class, From.$star());
  }

  public static NoSplitStackAttr cast_or_null_NoSplitStackAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoSplitStackAttr(From);
  }

  public static NoSplitStackAttr dyn_cast_NoSplitStackAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static NoSplitStackAttr dyn_cast_or_null_NoSplitStackAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static boolean isa_NoSplitStackAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoSplitStackAttr.class, From.$deref());
  }

  public static NoSplitStackAttr cast_NoSplitStackAttr(type$ref<?>/*P*/ From) {
    assert isa_NoSplitStackAttr(From);
    return llvm.cast(NoSplitStackAttr.class, From.$deref());
  }

  public static NoSplitStackAttr cast_or_null_NoSplitStackAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoSplitStackAttr(From);
  }

  public static NoSplitStackAttr dyn_cast_NoSplitStackAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static NoSplitStackAttr dyn_cast_or_null_NoSplitStackAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static boolean isa_NoSplitStackAttr(Attr/*P*/ From) {
    assert From != null;
    return NoSplitStackAttr.classof(From);
  }

  public static NoSplitStackAttr cast_NoSplitStackAttr(Attr/*P*/ From) {
    assert isa_NoSplitStackAttr(From);
    return (NoSplitStackAttr) From;
  }

  public static NoSplitStackAttr cast_or_null_NoSplitStackAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoSplitStackAttr(From);
  }

  public static NoSplitStackAttr dyn_cast_NoSplitStackAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static NoSplitStackAttr dyn_cast_or_null_NoSplitStackAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoSplitStackAttr(From) ? cast_NoSplitStackAttr(From) : null;
  }

  public static boolean isa_NoThreadSafetyAnalysisAttr(Attr/*P*/ From) {
    assert From != null;
    return NoThreadSafetyAnalysisAttr.classof(From);
  }

  public static NoThreadSafetyAnalysisAttr cast_NoThreadSafetyAnalysisAttr(Attr/*P*/ From) {
    assert isa_NoThreadSafetyAnalysisAttr(From);
    return (NoThreadSafetyAnalysisAttr) From;
  }

  public static NoThreadSafetyAnalysisAttr cast_or_null_NoThreadSafetyAnalysisAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoThreadSafetyAnalysisAttr(From);
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_NoThreadSafetyAnalysisAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_or_null_NoThreadSafetyAnalysisAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static boolean isa_NoThreadSafetyAnalysisAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoThreadSafetyAnalysisAttr.class, From.$star());
  }

  public static NoThreadSafetyAnalysisAttr cast_NoThreadSafetyAnalysisAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoThreadSafetyAnalysisAttr(From);
    return llvm.cast(NoThreadSafetyAnalysisAttr.class, From.$star());
  }

  public static NoThreadSafetyAnalysisAttr cast_or_null_NoThreadSafetyAnalysisAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoThreadSafetyAnalysisAttr(From);
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_NoThreadSafetyAnalysisAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_or_null_NoThreadSafetyAnalysisAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static boolean isa_NoThreadSafetyAnalysisAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoThreadSafetyAnalysisAttr.class, From.$deref());
  }

  public static NoThreadSafetyAnalysisAttr cast_NoThreadSafetyAnalysisAttr(type$ref<?>/*P*/ From) {
    assert isa_NoThreadSafetyAnalysisAttr(From);
    return llvm.cast(NoThreadSafetyAnalysisAttr.class, From.$deref());
  }

  public static NoThreadSafetyAnalysisAttr cast_or_null_NoThreadSafetyAnalysisAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoThreadSafetyAnalysisAttr(From);
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_NoThreadSafetyAnalysisAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static NoThreadSafetyAnalysisAttr dyn_cast_or_null_NoThreadSafetyAnalysisAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoThreadSafetyAnalysisAttr(From) ? cast_NoThreadSafetyAnalysisAttr(From) : null;
  }

  public static boolean isa_NoThrowAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NoThrowAttr.class, From.$deref());
  }

  public static NoThrowAttr cast_NoThrowAttr(type$ref<?>/*P*/ From) {
    assert isa_NoThrowAttr(From);
    return llvm.cast(NoThrowAttr.class, From.$deref());
  }

  public static NoThrowAttr cast_or_null_NoThrowAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NoThrowAttr(From);
  }

  public static NoThrowAttr dyn_cast_NoThrowAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static NoThrowAttr dyn_cast_or_null_NoThrowAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static boolean isa_NoThrowAttr(Attr/*P*/ From) {
    assert From != null;
    return NoThrowAttr.classof(From);
  }

  public static NoThrowAttr cast_NoThrowAttr(Attr/*P*/ From) {
    assert isa_NoThrowAttr(From);
    return (NoThrowAttr) From;
  }

  public static NoThrowAttr cast_or_null_NoThrowAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NoThrowAttr(From);
  }

  public static NoThrowAttr dyn_cast_NoThrowAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static NoThrowAttr dyn_cast_or_null_NoThrowAttr(Attr/*P*/ From) {
    return (From != null) && isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static boolean isa_NoThrowAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NoThrowAttr.class, From.$star());
  }

  public static NoThrowAttr cast_NoThrowAttr(type$ptr<?>/*P*/ From) {
    assert isa_NoThrowAttr(From);
    return llvm.cast(NoThrowAttr.class, From.$star());
  }

  public static NoThrowAttr cast_or_null_NoThrowAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NoThrowAttr(From);
  }

  public static NoThrowAttr dyn_cast_NoThrowAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static NoThrowAttr dyn_cast_or_null_NoThrowAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NoThrowAttr(From) ? cast_NoThrowAttr(From) : null;
  }

  public static boolean isa_NonNullAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NonNullAttr.class, From.$star());
  }

  public static NonNullAttr cast_NonNullAttr(type$ptr<?>/*P*/ From) {
    assert isa_NonNullAttr(From);
    return llvm.cast(NonNullAttr.class, From.$star());
  }

  public static NonNullAttr cast_or_null_NonNullAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NonNullAttr(From);
  }

  public static NonNullAttr dyn_cast_NonNullAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static NonNullAttr dyn_cast_or_null_NonNullAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static boolean isa_NonNullAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NonNullAttr.class, From.$deref());
  }

  public static NonNullAttr cast_NonNullAttr(type$ref<?>/*P*/ From) {
    assert isa_NonNullAttr(From);
    return llvm.cast(NonNullAttr.class, From.$deref());
  }

  public static NonNullAttr cast_or_null_NonNullAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NonNullAttr(From);
  }

  public static NonNullAttr dyn_cast_NonNullAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static NonNullAttr dyn_cast_or_null_NonNullAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static boolean isa_NonNullAttr(Attr/*P*/ From) {
    assert From != null;
    return NonNullAttr.classof(From);
  }

  public static NonNullAttr cast_NonNullAttr(Attr/*P*/ From) {
    assert isa_NonNullAttr(From);
    return (NonNullAttr) From;
  }

  public static NonNullAttr cast_or_null_NonNullAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NonNullAttr(From);
  }

  public static NonNullAttr dyn_cast_NonNullAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static NonNullAttr dyn_cast_or_null_NonNullAttr(Attr/*P*/ From) {
    return (From != null) && isa_NonNullAttr(From) ? cast_NonNullAttr(From) : null;
  }

  public static boolean isa_NotTailCalledAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(NotTailCalledAttr.class, From.$deref());
  }

  public static NotTailCalledAttr cast_NotTailCalledAttr(type$ref<?>/*P*/ From) {
    assert isa_NotTailCalledAttr(From);
    return llvm.cast(NotTailCalledAttr.class, From.$deref());
  }

  public static NotTailCalledAttr cast_or_null_NotTailCalledAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_NotTailCalledAttr(From);
  }

  public static NotTailCalledAttr dyn_cast_NotTailCalledAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static NotTailCalledAttr dyn_cast_or_null_NotTailCalledAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static boolean isa_NotTailCalledAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(NotTailCalledAttr.class, From.$star());
  }

  public static NotTailCalledAttr cast_NotTailCalledAttr(type$ptr<?>/*P*/ From) {
    assert isa_NotTailCalledAttr(From);
    return llvm.cast(NotTailCalledAttr.class, From.$star());
  }

  public static NotTailCalledAttr cast_or_null_NotTailCalledAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_NotTailCalledAttr(From);
  }

  public static NotTailCalledAttr dyn_cast_NotTailCalledAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static NotTailCalledAttr dyn_cast_or_null_NotTailCalledAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static boolean isa_NotTailCalledAttr(Attr/*P*/ From) {
    assert From != null;
    return NotTailCalledAttr.classof(From);
  }

  public static NotTailCalledAttr cast_NotTailCalledAttr(Attr/*P*/ From) {
    assert isa_NotTailCalledAttr(From);
    return (NotTailCalledAttr) From;
  }

  public static NotTailCalledAttr cast_or_null_NotTailCalledAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_NotTailCalledAttr(From);
  }

  public static NotTailCalledAttr dyn_cast_NotTailCalledAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static NotTailCalledAttr dyn_cast_or_null_NotTailCalledAttr(Attr/*P*/ From) {
    return (From != null) && isa_NotTailCalledAttr(From) ? cast_NotTailCalledAttr(From) : null;
  }

  public static boolean isa_OMPCaptureNoInitAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPCaptureNoInitAttr.class, From.$deref());
  }

  public static OMPCaptureNoInitAttr cast_OMPCaptureNoInitAttr(type$ref<?>/*P*/ From) {
    assert isa_OMPCaptureNoInitAttr(From);
    return llvm.cast(OMPCaptureNoInitAttr.class, From.$deref());
  }

  public static OMPCaptureNoInitAttr cast_or_null_OMPCaptureNoInitAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPCaptureNoInitAttr(From);
  }

  public static OMPCaptureNoInitAttr dyn_cast_OMPCaptureNoInitAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static OMPCaptureNoInitAttr dyn_cast_or_null_OMPCaptureNoInitAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static boolean isa_OMPCaptureNoInitAttr(Attr/*P*/ From) {
    assert From != null;
    return OMPCaptureNoInitAttr.classof(From);
  }

  public static OMPCaptureNoInitAttr cast_OMPCaptureNoInitAttr(Attr/*P*/ From) {
    assert isa_OMPCaptureNoInitAttr(From);
    return (OMPCaptureNoInitAttr) From;
  }

  public static OMPCaptureNoInitAttr cast_or_null_OMPCaptureNoInitAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OMPCaptureNoInitAttr(From);
  }

  public static OMPCaptureNoInitAttr dyn_cast_OMPCaptureNoInitAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static OMPCaptureNoInitAttr dyn_cast_or_null_OMPCaptureNoInitAttr(Attr/*P*/ From) {
    return (From != null) && isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static boolean isa_OMPCaptureNoInitAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPCaptureNoInitAttr.class, From.$star());
  }

  public static OMPCaptureNoInitAttr cast_OMPCaptureNoInitAttr(type$ptr<?>/*P*/ From) {
    assert isa_OMPCaptureNoInitAttr(From);
    return llvm.cast(OMPCaptureNoInitAttr.class, From.$star());
  }

  public static OMPCaptureNoInitAttr cast_or_null_OMPCaptureNoInitAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPCaptureNoInitAttr(From);
  }

  public static OMPCaptureNoInitAttr dyn_cast_OMPCaptureNoInitAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static OMPCaptureNoInitAttr dyn_cast_or_null_OMPCaptureNoInitAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPCaptureNoInitAttr(From) ? cast_OMPCaptureNoInitAttr(From) : null;
  }

  public static boolean isa_OMPDeclareSimdDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDeclareSimdDeclAttr.class, From.$star());
  }

  public static OMPDeclareSimdDeclAttr cast_OMPDeclareSimdDeclAttr(type$ptr<?>/*P*/ From) {
    assert isa_OMPDeclareSimdDeclAttr(From);
    return llvm.cast(OMPDeclareSimdDeclAttr.class, From.$star());
  }

  public static OMPDeclareSimdDeclAttr cast_or_null_OMPDeclareSimdDeclAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDeclareSimdDeclAttr(From);
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_OMPDeclareSimdDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_or_null_OMPDeclareSimdDeclAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static boolean isa_OMPDeclareSimdDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDeclareSimdDeclAttr.class, From.$deref());
  }

  public static OMPDeclareSimdDeclAttr cast_OMPDeclareSimdDeclAttr(type$ref<?>/*P*/ From) {
    assert isa_OMPDeclareSimdDeclAttr(From);
    return llvm.cast(OMPDeclareSimdDeclAttr.class, From.$deref());
  }

  public static OMPDeclareSimdDeclAttr cast_or_null_OMPDeclareSimdDeclAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDeclareSimdDeclAttr(From);
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_OMPDeclareSimdDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_or_null_OMPDeclareSimdDeclAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static boolean isa_OMPDeclareSimdDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return OMPDeclareSimdDeclAttr.classof(From);
  }

  public static OMPDeclareSimdDeclAttr cast_OMPDeclareSimdDeclAttr(Attr/*P*/ From) {
    assert isa_OMPDeclareSimdDeclAttr(From);
    return (OMPDeclareSimdDeclAttr) From;
  }

  public static OMPDeclareSimdDeclAttr cast_or_null_OMPDeclareSimdDeclAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareSimdDeclAttr(From);
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_OMPDeclareSimdDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static OMPDeclareSimdDeclAttr dyn_cast_or_null_OMPDeclareSimdDeclAttr(Attr/*P*/ From) {
    return (From != null) && isa_OMPDeclareSimdDeclAttr(From) ? cast_OMPDeclareSimdDeclAttr(From) : null;
  }

  public static boolean isa_OMPDeclareTargetDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPDeclareTargetDeclAttr.class, From.$star());
  }

  public static OMPDeclareTargetDeclAttr cast_OMPDeclareTargetDeclAttr(type$ptr<?>/*P*/ From) {
    assert isa_OMPDeclareTargetDeclAttr(From);
    return llvm.cast(OMPDeclareTargetDeclAttr.class, From.$star());
  }

  public static OMPDeclareTargetDeclAttr cast_or_null_OMPDeclareTargetDeclAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPDeclareTargetDeclAttr(From);
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_OMPDeclareTargetDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_or_null_OMPDeclareTargetDeclAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static boolean isa_OMPDeclareTargetDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return OMPDeclareTargetDeclAttr.classof(From);
  }

  public static OMPDeclareTargetDeclAttr cast_OMPDeclareTargetDeclAttr(Attr/*P*/ From) {
    assert isa_OMPDeclareTargetDeclAttr(From);
    return (OMPDeclareTargetDeclAttr) From;
  }

  public static OMPDeclareTargetDeclAttr cast_or_null_OMPDeclareTargetDeclAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareTargetDeclAttr(From);
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_OMPDeclareTargetDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_or_null_OMPDeclareTargetDeclAttr(Attr/*P*/ From) {
    return (From != null) && isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static boolean isa_OMPDeclareTargetDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPDeclareTargetDeclAttr.class, From.$deref());
  }

  public static OMPDeclareTargetDeclAttr cast_OMPDeclareTargetDeclAttr(type$ref<?>/*P*/ From) {
    assert isa_OMPDeclareTargetDeclAttr(From);
    return llvm.cast(OMPDeclareTargetDeclAttr.class, From.$deref());
  }

  public static OMPDeclareTargetDeclAttr cast_or_null_OMPDeclareTargetDeclAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPDeclareTargetDeclAttr(From);
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_OMPDeclareTargetDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static OMPDeclareTargetDeclAttr dyn_cast_or_null_OMPDeclareTargetDeclAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPDeclareTargetDeclAttr(From) ? cast_OMPDeclareTargetDeclAttr(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return OMPThreadPrivateDeclAttr.classof(From);
  }

  public static OMPThreadPrivateDeclAttr cast_OMPThreadPrivateDeclAttr(Attr/*P*/ From) {
    assert isa_OMPThreadPrivateDeclAttr(From);
    return (OMPThreadPrivateDeclAttr) From;
  }

  public static OMPThreadPrivateDeclAttr cast_or_null_OMPThreadPrivateDeclAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OMPThreadPrivateDeclAttr(From);
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_OMPThreadPrivateDeclAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_or_null_OMPThreadPrivateDeclAttr(Attr/*P*/ From) {
    return (From != null) && isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OMPThreadPrivateDeclAttr.class, From.$star());
  }

  public static OMPThreadPrivateDeclAttr cast_OMPThreadPrivateDeclAttr(type$ptr<?>/*P*/ From) {
    assert isa_OMPThreadPrivateDeclAttr(From);
    return llvm.cast(OMPThreadPrivateDeclAttr.class, From.$star());
  }

  public static OMPThreadPrivateDeclAttr cast_or_null_OMPThreadPrivateDeclAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OMPThreadPrivateDeclAttr(From);
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_OMPThreadPrivateDeclAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_or_null_OMPThreadPrivateDeclAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static boolean isa_OMPThreadPrivateDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OMPThreadPrivateDeclAttr.class, From.$deref());
  }

  public static OMPThreadPrivateDeclAttr cast_OMPThreadPrivateDeclAttr(type$ref<?>/*P*/ From) {
    assert isa_OMPThreadPrivateDeclAttr(From);
    return llvm.cast(OMPThreadPrivateDeclAttr.class, From.$deref());
  }

  public static OMPThreadPrivateDeclAttr cast_or_null_OMPThreadPrivateDeclAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OMPThreadPrivateDeclAttr(From);
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_OMPThreadPrivateDeclAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static OMPThreadPrivateDeclAttr dyn_cast_or_null_OMPThreadPrivateDeclAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OMPThreadPrivateDeclAttr(From) ? cast_OMPThreadPrivateDeclAttr(From) : null;
  }

  public static boolean isa_ObjCBoxableAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCBoxableAttr.classof(From);
  }

  public static ObjCBoxableAttr cast_ObjCBoxableAttr(Attr/*P*/ From) {
    assert isa_ObjCBoxableAttr(From);
    return (ObjCBoxableAttr) From;
  }

  public static ObjCBoxableAttr cast_or_null_ObjCBoxableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCBoxableAttr(From);
  }

  public static ObjCBoxableAttr dyn_cast_ObjCBoxableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static ObjCBoxableAttr dyn_cast_or_null_ObjCBoxableAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static boolean isa_ObjCBoxableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBoxableAttr.class, From.$deref());
  }

  public static ObjCBoxableAttr cast_ObjCBoxableAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBoxableAttr(From);
    return llvm.cast(ObjCBoxableAttr.class, From.$deref());
  }

  public static ObjCBoxableAttr cast_or_null_ObjCBoxableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBoxableAttr(From);
  }

  public static ObjCBoxableAttr dyn_cast_ObjCBoxableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static ObjCBoxableAttr dyn_cast_or_null_ObjCBoxableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static boolean isa_ObjCBoxableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBoxableAttr.class, From.$star());
  }

  public static ObjCBoxableAttr cast_ObjCBoxableAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBoxableAttr(From);
    return llvm.cast(ObjCBoxableAttr.class, From.$star());
  }

  public static ObjCBoxableAttr cast_or_null_ObjCBoxableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBoxableAttr(From);
  }

  public static ObjCBoxableAttr dyn_cast_ObjCBoxableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static ObjCBoxableAttr dyn_cast_or_null_ObjCBoxableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBoxableAttr(From) ? cast_ObjCBoxableAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCBridgeAttr.classof(From);
  }

  public static ObjCBridgeAttr cast_ObjCBridgeAttr(Attr/*P*/ From) {
    assert isa_ObjCBridgeAttr(From);
    return (ObjCBridgeAttr) From;
  }

  public static ObjCBridgeAttr cast_or_null_ObjCBridgeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCBridgeAttr(From);
  }

  public static ObjCBridgeAttr dyn_cast_ObjCBridgeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static ObjCBridgeAttr dyn_cast_or_null_ObjCBridgeAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBridgeAttr.class, From.$star());
  }

  public static ObjCBridgeAttr cast_ObjCBridgeAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBridgeAttr(From);
    return llvm.cast(ObjCBridgeAttr.class, From.$star());
  }

  public static ObjCBridgeAttr cast_or_null_ObjCBridgeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBridgeAttr(From);
  }

  public static ObjCBridgeAttr dyn_cast_ObjCBridgeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static ObjCBridgeAttr dyn_cast_or_null_ObjCBridgeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBridgeAttr.class, From.$deref());
  }

  public static ObjCBridgeAttr cast_ObjCBridgeAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBridgeAttr(From);
    return llvm.cast(ObjCBridgeAttr.class, From.$deref());
  }

  public static ObjCBridgeAttr cast_or_null_ObjCBridgeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBridgeAttr(From);
  }

  public static ObjCBridgeAttr dyn_cast_ObjCBridgeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static ObjCBridgeAttr dyn_cast_or_null_ObjCBridgeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBridgeAttr(From) ? cast_ObjCBridgeAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeMutableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBridgeMutableAttr.class, From.$star());
  }

  public static ObjCBridgeMutableAttr cast_ObjCBridgeMutableAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBridgeMutableAttr(From);
    return llvm.cast(ObjCBridgeMutableAttr.class, From.$star());
  }

  public static ObjCBridgeMutableAttr cast_or_null_ObjCBridgeMutableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBridgeMutableAttr(From);
  }

  public static ObjCBridgeMutableAttr dyn_cast_ObjCBridgeMutableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static ObjCBridgeMutableAttr dyn_cast_or_null_ObjCBridgeMutableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeMutableAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCBridgeMutableAttr.classof(From);
  }

  public static ObjCBridgeMutableAttr cast_ObjCBridgeMutableAttr(Attr/*P*/ From) {
    assert isa_ObjCBridgeMutableAttr(From);
    return (ObjCBridgeMutableAttr) From;
  }

  public static ObjCBridgeMutableAttr cast_or_null_ObjCBridgeMutableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCBridgeMutableAttr(From);
  }

  public static ObjCBridgeMutableAttr dyn_cast_ObjCBridgeMutableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static ObjCBridgeMutableAttr dyn_cast_or_null_ObjCBridgeMutableAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeMutableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBridgeMutableAttr.class, From.$deref());
  }

  public static ObjCBridgeMutableAttr cast_ObjCBridgeMutableAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBridgeMutableAttr(From);
    return llvm.cast(ObjCBridgeMutableAttr.class, From.$deref());
  }

  public static ObjCBridgeMutableAttr cast_or_null_ObjCBridgeMutableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBridgeMutableAttr(From);
  }

  public static ObjCBridgeMutableAttr dyn_cast_ObjCBridgeMutableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static ObjCBridgeMutableAttr dyn_cast_or_null_ObjCBridgeMutableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBridgeMutableAttr(From) ? cast_ObjCBridgeMutableAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeRelatedAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCBridgeRelatedAttr.classof(From);
  }

  public static ObjCBridgeRelatedAttr cast_ObjCBridgeRelatedAttr(Attr/*P*/ From) {
    assert isa_ObjCBridgeRelatedAttr(From);
    return (ObjCBridgeRelatedAttr) From;
  }

  public static ObjCBridgeRelatedAttr cast_or_null_ObjCBridgeRelatedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCBridgeRelatedAttr(From);
  }

  public static ObjCBridgeRelatedAttr dyn_cast_ObjCBridgeRelatedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static ObjCBridgeRelatedAttr dyn_cast_or_null_ObjCBridgeRelatedAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeRelatedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCBridgeRelatedAttr.class, From.$star());
  }

  public static ObjCBridgeRelatedAttr cast_ObjCBridgeRelatedAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCBridgeRelatedAttr(From);
    return llvm.cast(ObjCBridgeRelatedAttr.class, From.$star());
  }

  public static ObjCBridgeRelatedAttr cast_or_null_ObjCBridgeRelatedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCBridgeRelatedAttr(From);
  }

  public static ObjCBridgeRelatedAttr dyn_cast_ObjCBridgeRelatedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static ObjCBridgeRelatedAttr dyn_cast_or_null_ObjCBridgeRelatedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static boolean isa_ObjCBridgeRelatedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCBridgeRelatedAttr.class, From.$deref());
  }

  public static ObjCBridgeRelatedAttr cast_ObjCBridgeRelatedAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCBridgeRelatedAttr(From);
    return llvm.cast(ObjCBridgeRelatedAttr.class, From.$deref());
  }

  public static ObjCBridgeRelatedAttr cast_or_null_ObjCBridgeRelatedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCBridgeRelatedAttr(From);
  }

  public static ObjCBridgeRelatedAttr dyn_cast_ObjCBridgeRelatedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static ObjCBridgeRelatedAttr dyn_cast_or_null_ObjCBridgeRelatedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCBridgeRelatedAttr(From) ? cast_ObjCBridgeRelatedAttr(From) : null;
  }

  public static boolean isa_ObjCDesignatedInitializerAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCDesignatedInitializerAttr.classof(From);
  }

  public static ObjCDesignatedInitializerAttr cast_ObjCDesignatedInitializerAttr(Attr/*P*/ From) {
    assert isa_ObjCDesignatedInitializerAttr(From);
    return (ObjCDesignatedInitializerAttr) From;
  }

  public static ObjCDesignatedInitializerAttr cast_or_null_ObjCDesignatedInitializerAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCDesignatedInitializerAttr(From);
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_ObjCDesignatedInitializerAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_or_null_ObjCDesignatedInitializerAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static boolean isa_ObjCDesignatedInitializerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCDesignatedInitializerAttr.class, From.$star());
  }

  public static ObjCDesignatedInitializerAttr cast_ObjCDesignatedInitializerAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCDesignatedInitializerAttr(From);
    return llvm.cast(ObjCDesignatedInitializerAttr.class, From.$star());
  }

  public static ObjCDesignatedInitializerAttr cast_or_null_ObjCDesignatedInitializerAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCDesignatedInitializerAttr(From);
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_ObjCDesignatedInitializerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_or_null_ObjCDesignatedInitializerAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static boolean isa_ObjCDesignatedInitializerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCDesignatedInitializerAttr.class, From.$deref());
  }

  public static ObjCDesignatedInitializerAttr cast_ObjCDesignatedInitializerAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCDesignatedInitializerAttr(From);
    return llvm.cast(ObjCDesignatedInitializerAttr.class, From.$deref());
  }

  public static ObjCDesignatedInitializerAttr cast_or_null_ObjCDesignatedInitializerAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCDesignatedInitializerAttr(From);
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_ObjCDesignatedInitializerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static ObjCDesignatedInitializerAttr dyn_cast_or_null_ObjCDesignatedInitializerAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCDesignatedInitializerAttr(From) ? cast_ObjCDesignatedInitializerAttr(From) : null;
  }

  public static boolean isa_ObjCExceptionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCExceptionAttr.class, From.$deref());
  }

  public static ObjCExceptionAttr cast_ObjCExceptionAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCExceptionAttr(From);
    return llvm.cast(ObjCExceptionAttr.class, From.$deref());
  }

  public static ObjCExceptionAttr cast_or_null_ObjCExceptionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCExceptionAttr(From);
  }

  public static ObjCExceptionAttr dyn_cast_ObjCExceptionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static ObjCExceptionAttr dyn_cast_or_null_ObjCExceptionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static boolean isa_ObjCExceptionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCExceptionAttr.class, From.$star());
  }

  public static ObjCExceptionAttr cast_ObjCExceptionAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCExceptionAttr(From);
    return llvm.cast(ObjCExceptionAttr.class, From.$star());
  }

  public static ObjCExceptionAttr cast_or_null_ObjCExceptionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCExceptionAttr(From);
  }

  public static ObjCExceptionAttr dyn_cast_ObjCExceptionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static ObjCExceptionAttr dyn_cast_or_null_ObjCExceptionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static boolean isa_ObjCExceptionAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCExceptionAttr.classof(From);
  }

  public static ObjCExceptionAttr cast_ObjCExceptionAttr(Attr/*P*/ From) {
    assert isa_ObjCExceptionAttr(From);
    return (ObjCExceptionAttr) From;
  }

  public static ObjCExceptionAttr cast_or_null_ObjCExceptionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCExceptionAttr(From);
  }

  public static ObjCExceptionAttr dyn_cast_ObjCExceptionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static ObjCExceptionAttr dyn_cast_or_null_ObjCExceptionAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCExceptionAttr(From) ? cast_ObjCExceptionAttr(From) : null;
  }

  public static boolean isa_ObjCExplicitProtocolImplAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCExplicitProtocolImplAttr.class, From.$deref());
  }

  public static ObjCExplicitProtocolImplAttr cast_ObjCExplicitProtocolImplAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCExplicitProtocolImplAttr(From);
    return llvm.cast(ObjCExplicitProtocolImplAttr.class, From.$deref());
  }

  public static ObjCExplicitProtocolImplAttr cast_or_null_ObjCExplicitProtocolImplAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCExplicitProtocolImplAttr(From);
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_ObjCExplicitProtocolImplAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_or_null_ObjCExplicitProtocolImplAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static boolean isa_ObjCExplicitProtocolImplAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCExplicitProtocolImplAttr.class, From.$star());
  }

  public static ObjCExplicitProtocolImplAttr cast_ObjCExplicitProtocolImplAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCExplicitProtocolImplAttr(From);
    return llvm.cast(ObjCExplicitProtocolImplAttr.class, From.$star());
  }

  public static ObjCExplicitProtocolImplAttr cast_or_null_ObjCExplicitProtocolImplAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCExplicitProtocolImplAttr(From);
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_ObjCExplicitProtocolImplAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_or_null_ObjCExplicitProtocolImplAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static boolean isa_ObjCExplicitProtocolImplAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCExplicitProtocolImplAttr.classof(From);
  }

  public static ObjCExplicitProtocolImplAttr cast_ObjCExplicitProtocolImplAttr(Attr/*P*/ From) {
    assert isa_ObjCExplicitProtocolImplAttr(From);
    return (ObjCExplicitProtocolImplAttr) From;
  }

  public static ObjCExplicitProtocolImplAttr cast_or_null_ObjCExplicitProtocolImplAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCExplicitProtocolImplAttr(From);
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_ObjCExplicitProtocolImplAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static ObjCExplicitProtocolImplAttr dyn_cast_or_null_ObjCExplicitProtocolImplAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCExplicitProtocolImplAttr(From) ? cast_ObjCExplicitProtocolImplAttr(From) : null;
  }

  public static boolean isa_ObjCIndependentClassAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCIndependentClassAttr.class, From.$star());
  }

  public static ObjCIndependentClassAttr cast_ObjCIndependentClassAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCIndependentClassAttr(From);
    return llvm.cast(ObjCIndependentClassAttr.class, From.$star());
  }

  public static ObjCIndependentClassAttr cast_or_null_ObjCIndependentClassAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCIndependentClassAttr(From);
  }

  public static ObjCIndependentClassAttr dyn_cast_ObjCIndependentClassAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static ObjCIndependentClassAttr dyn_cast_or_null_ObjCIndependentClassAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static boolean isa_ObjCIndependentClassAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCIndependentClassAttr.classof(From);
  }

  public static ObjCIndependentClassAttr cast_ObjCIndependentClassAttr(Attr/*P*/ From) {
    assert isa_ObjCIndependentClassAttr(From);
    return (ObjCIndependentClassAttr) From;
  }

  public static ObjCIndependentClassAttr cast_or_null_ObjCIndependentClassAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCIndependentClassAttr(From);
  }

  public static ObjCIndependentClassAttr dyn_cast_ObjCIndependentClassAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static ObjCIndependentClassAttr dyn_cast_or_null_ObjCIndependentClassAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static boolean isa_ObjCIndependentClassAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCIndependentClassAttr.class, From.$deref());
  }

  public static ObjCIndependentClassAttr cast_ObjCIndependentClassAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCIndependentClassAttr(From);
    return llvm.cast(ObjCIndependentClassAttr.class, From.$deref());
  }

  public static ObjCIndependentClassAttr cast_or_null_ObjCIndependentClassAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCIndependentClassAttr(From);
  }

  public static ObjCIndependentClassAttr dyn_cast_ObjCIndependentClassAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static ObjCIndependentClassAttr dyn_cast_or_null_ObjCIndependentClassAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCIndependentClassAttr(From) ? cast_ObjCIndependentClassAttr(From) : null;
  }

  public static boolean isa_ObjCMethodFamilyAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCMethodFamilyAttr.classof(From);
  }

  public static ObjCMethodFamilyAttr cast_ObjCMethodFamilyAttr(Attr/*P*/ From) {
    assert isa_ObjCMethodFamilyAttr(From);
    return (ObjCMethodFamilyAttr) From;
  }

  public static ObjCMethodFamilyAttr cast_or_null_ObjCMethodFamilyAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodFamilyAttr(From);
  }

  public static ObjCMethodFamilyAttr dyn_cast_ObjCMethodFamilyAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static ObjCMethodFamilyAttr dyn_cast_or_null_ObjCMethodFamilyAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static boolean isa_ObjCMethodFamilyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCMethodFamilyAttr.class, From.$deref());
  }

  public static ObjCMethodFamilyAttr cast_ObjCMethodFamilyAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCMethodFamilyAttr(From);
    return llvm.cast(ObjCMethodFamilyAttr.class, From.$deref());
  }

  public static ObjCMethodFamilyAttr cast_or_null_ObjCMethodFamilyAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCMethodFamilyAttr(From);
  }

  public static ObjCMethodFamilyAttr dyn_cast_ObjCMethodFamilyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static ObjCMethodFamilyAttr dyn_cast_or_null_ObjCMethodFamilyAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static boolean isa_ObjCMethodFamilyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCMethodFamilyAttr.class, From.$star());
  }

  public static ObjCMethodFamilyAttr cast_ObjCMethodFamilyAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCMethodFamilyAttr(From);
    return llvm.cast(ObjCMethodFamilyAttr.class, From.$star());
  }

  public static ObjCMethodFamilyAttr cast_or_null_ObjCMethodFamilyAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCMethodFamilyAttr(From);
  }

  public static ObjCMethodFamilyAttr dyn_cast_ObjCMethodFamilyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static ObjCMethodFamilyAttr dyn_cast_or_null_ObjCMethodFamilyAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCMethodFamilyAttr(From) ? cast_ObjCMethodFamilyAttr(From) : null;
  }

  public static boolean isa_ObjCNSObjectAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCNSObjectAttr.class, From.$deref());
  }

  public static ObjCNSObjectAttr cast_ObjCNSObjectAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCNSObjectAttr(From);
    return llvm.cast(ObjCNSObjectAttr.class, From.$deref());
  }

  public static ObjCNSObjectAttr cast_or_null_ObjCNSObjectAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCNSObjectAttr(From);
  }

  public static ObjCNSObjectAttr dyn_cast_ObjCNSObjectAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static ObjCNSObjectAttr dyn_cast_or_null_ObjCNSObjectAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static boolean isa_ObjCNSObjectAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCNSObjectAttr.class, From.$star());
  }

  public static ObjCNSObjectAttr cast_ObjCNSObjectAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCNSObjectAttr(From);
    return llvm.cast(ObjCNSObjectAttr.class, From.$star());
  }

  public static ObjCNSObjectAttr cast_or_null_ObjCNSObjectAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCNSObjectAttr(From);
  }

  public static ObjCNSObjectAttr dyn_cast_ObjCNSObjectAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static ObjCNSObjectAttr dyn_cast_or_null_ObjCNSObjectAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static boolean isa_ObjCNSObjectAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCNSObjectAttr.classof(From);
  }

  public static ObjCNSObjectAttr cast_ObjCNSObjectAttr(Attr/*P*/ From) {
    assert isa_ObjCNSObjectAttr(From);
    return (ObjCNSObjectAttr) From;
  }

  public static ObjCNSObjectAttr cast_or_null_ObjCNSObjectAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCNSObjectAttr(From);
  }

  public static ObjCNSObjectAttr dyn_cast_ObjCNSObjectAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static ObjCNSObjectAttr dyn_cast_or_null_ObjCNSObjectAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCNSObjectAttr(From) ? cast_ObjCNSObjectAttr(From) : null;
  }

  public static boolean isa_ObjCPreciseLifetimeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCPreciseLifetimeAttr.class, From.$deref());
  }

  public static ObjCPreciseLifetimeAttr cast_ObjCPreciseLifetimeAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCPreciseLifetimeAttr(From);
    return llvm.cast(ObjCPreciseLifetimeAttr.class, From.$deref());
  }

  public static ObjCPreciseLifetimeAttr cast_or_null_ObjCPreciseLifetimeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCPreciseLifetimeAttr(From);
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_ObjCPreciseLifetimeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_or_null_ObjCPreciseLifetimeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static boolean isa_ObjCPreciseLifetimeAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCPreciseLifetimeAttr.classof(From);
  }

  public static ObjCPreciseLifetimeAttr cast_ObjCPreciseLifetimeAttr(Attr/*P*/ From) {
    assert isa_ObjCPreciseLifetimeAttr(From);
    return (ObjCPreciseLifetimeAttr) From;
  }

  public static ObjCPreciseLifetimeAttr cast_or_null_ObjCPreciseLifetimeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCPreciseLifetimeAttr(From);
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_ObjCPreciseLifetimeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_or_null_ObjCPreciseLifetimeAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static boolean isa_ObjCPreciseLifetimeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCPreciseLifetimeAttr.class, From.$star());
  }

  public static ObjCPreciseLifetimeAttr cast_ObjCPreciseLifetimeAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCPreciseLifetimeAttr(From);
    return llvm.cast(ObjCPreciseLifetimeAttr.class, From.$star());
  }

  public static ObjCPreciseLifetimeAttr cast_or_null_ObjCPreciseLifetimeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCPreciseLifetimeAttr(From);
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_ObjCPreciseLifetimeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static ObjCPreciseLifetimeAttr dyn_cast_or_null_ObjCPreciseLifetimeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCPreciseLifetimeAttr(From) ? cast_ObjCPreciseLifetimeAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresPropertyDefsAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCRequiresPropertyDefsAttr.classof(From);
  }

  public static ObjCRequiresPropertyDefsAttr cast_ObjCRequiresPropertyDefsAttr(Attr/*P*/ From) {
    assert isa_ObjCRequiresPropertyDefsAttr(From);
    return (ObjCRequiresPropertyDefsAttr) From;
  }

  public static ObjCRequiresPropertyDefsAttr cast_or_null_ObjCRequiresPropertyDefsAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCRequiresPropertyDefsAttr(From);
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_ObjCRequiresPropertyDefsAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_or_null_ObjCRequiresPropertyDefsAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresPropertyDefsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCRequiresPropertyDefsAttr.class, From.$star());
  }

  public static ObjCRequiresPropertyDefsAttr cast_ObjCRequiresPropertyDefsAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCRequiresPropertyDefsAttr(From);
    return llvm.cast(ObjCRequiresPropertyDefsAttr.class, From.$star());
  }

  public static ObjCRequiresPropertyDefsAttr cast_or_null_ObjCRequiresPropertyDefsAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCRequiresPropertyDefsAttr(From);
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_ObjCRequiresPropertyDefsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_or_null_ObjCRequiresPropertyDefsAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresPropertyDefsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCRequiresPropertyDefsAttr.class, From.$deref());
  }

  public static ObjCRequiresPropertyDefsAttr cast_ObjCRequiresPropertyDefsAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCRequiresPropertyDefsAttr(From);
    return llvm.cast(ObjCRequiresPropertyDefsAttr.class, From.$deref());
  }

  public static ObjCRequiresPropertyDefsAttr cast_or_null_ObjCRequiresPropertyDefsAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCRequiresPropertyDefsAttr(From);
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_ObjCRequiresPropertyDefsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static ObjCRequiresPropertyDefsAttr dyn_cast_or_null_ObjCRequiresPropertyDefsAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCRequiresPropertyDefsAttr(From) ? cast_ObjCRequiresPropertyDefsAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresSuperAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCRequiresSuperAttr.class, From.$deref());
  }

  public static ObjCRequiresSuperAttr cast_ObjCRequiresSuperAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCRequiresSuperAttr(From);
    return llvm.cast(ObjCRequiresSuperAttr.class, From.$deref());
  }

  public static ObjCRequiresSuperAttr cast_or_null_ObjCRequiresSuperAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCRequiresSuperAttr(From);
  }

  public static ObjCRequiresSuperAttr dyn_cast_ObjCRequiresSuperAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static ObjCRequiresSuperAttr dyn_cast_or_null_ObjCRequiresSuperAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresSuperAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCRequiresSuperAttr.class, From.$star());
  }

  public static ObjCRequiresSuperAttr cast_ObjCRequiresSuperAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCRequiresSuperAttr(From);
    return llvm.cast(ObjCRequiresSuperAttr.class, From.$star());
  }

  public static ObjCRequiresSuperAttr cast_or_null_ObjCRequiresSuperAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCRequiresSuperAttr(From);
  }

  public static ObjCRequiresSuperAttr dyn_cast_ObjCRequiresSuperAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static ObjCRequiresSuperAttr dyn_cast_or_null_ObjCRequiresSuperAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static boolean isa_ObjCRequiresSuperAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCRequiresSuperAttr.classof(From);
  }

  public static ObjCRequiresSuperAttr cast_ObjCRequiresSuperAttr(Attr/*P*/ From) {
    assert isa_ObjCRequiresSuperAttr(From);
    return (ObjCRequiresSuperAttr) From;
  }

  public static ObjCRequiresSuperAttr cast_or_null_ObjCRequiresSuperAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCRequiresSuperAttr(From);
  }

  public static ObjCRequiresSuperAttr dyn_cast_ObjCRequiresSuperAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static ObjCRequiresSuperAttr dyn_cast_or_null_ObjCRequiresSuperAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCRequiresSuperAttr(From) ? cast_ObjCRequiresSuperAttr(From) : null;
  }

  public static boolean isa_ObjCReturnsInnerPointerAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCReturnsInnerPointerAttr.classof(From);
  }

  public static ObjCReturnsInnerPointerAttr cast_ObjCReturnsInnerPointerAttr(Attr/*P*/ From) {
    assert isa_ObjCReturnsInnerPointerAttr(From);
    return (ObjCReturnsInnerPointerAttr) From;
  }

  public static ObjCReturnsInnerPointerAttr cast_or_null_ObjCReturnsInnerPointerAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCReturnsInnerPointerAttr(From);
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_ObjCReturnsInnerPointerAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_or_null_ObjCReturnsInnerPointerAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static boolean isa_ObjCReturnsInnerPointerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCReturnsInnerPointerAttr.class, From.$star());
  }

  public static ObjCReturnsInnerPointerAttr cast_ObjCReturnsInnerPointerAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCReturnsInnerPointerAttr(From);
    return llvm.cast(ObjCReturnsInnerPointerAttr.class, From.$star());
  }

  public static ObjCReturnsInnerPointerAttr cast_or_null_ObjCReturnsInnerPointerAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCReturnsInnerPointerAttr(From);
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_ObjCReturnsInnerPointerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_or_null_ObjCReturnsInnerPointerAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static boolean isa_ObjCReturnsInnerPointerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCReturnsInnerPointerAttr.class, From.$deref());
  }

  public static ObjCReturnsInnerPointerAttr cast_ObjCReturnsInnerPointerAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCReturnsInnerPointerAttr(From);
    return llvm.cast(ObjCReturnsInnerPointerAttr.class, From.$deref());
  }

  public static ObjCReturnsInnerPointerAttr cast_or_null_ObjCReturnsInnerPointerAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCReturnsInnerPointerAttr(From);
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_ObjCReturnsInnerPointerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static ObjCReturnsInnerPointerAttr dyn_cast_or_null_ObjCReturnsInnerPointerAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCReturnsInnerPointerAttr(From) ? cast_ObjCReturnsInnerPointerAttr(From) : null;
  }

  public static boolean isa_ObjCRootClassAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCRootClassAttr.class, From.$deref());
  }

  public static ObjCRootClassAttr cast_ObjCRootClassAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCRootClassAttr(From);
    return llvm.cast(ObjCRootClassAttr.class, From.$deref());
  }

  public static ObjCRootClassAttr cast_or_null_ObjCRootClassAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCRootClassAttr(From);
  }

  public static ObjCRootClassAttr dyn_cast_ObjCRootClassAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static ObjCRootClassAttr dyn_cast_or_null_ObjCRootClassAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static boolean isa_ObjCRootClassAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCRootClassAttr.class, From.$star());
  }

  public static ObjCRootClassAttr cast_ObjCRootClassAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCRootClassAttr(From);
    return llvm.cast(ObjCRootClassAttr.class, From.$star());
  }

  public static ObjCRootClassAttr cast_or_null_ObjCRootClassAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCRootClassAttr(From);
  }

  public static ObjCRootClassAttr dyn_cast_ObjCRootClassAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static ObjCRootClassAttr dyn_cast_or_null_ObjCRootClassAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static boolean isa_ObjCRootClassAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCRootClassAttr.classof(From);
  }

  public static ObjCRootClassAttr cast_ObjCRootClassAttr(Attr/*P*/ From) {
    assert isa_ObjCRootClassAttr(From);
    return (ObjCRootClassAttr) From;
  }

  public static ObjCRootClassAttr cast_or_null_ObjCRootClassAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCRootClassAttr(From);
  }

  public static ObjCRootClassAttr dyn_cast_ObjCRootClassAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static ObjCRootClassAttr dyn_cast_or_null_ObjCRootClassAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCRootClassAttr(From) ? cast_ObjCRootClassAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeNameAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCRuntimeNameAttr.class, From.$deref());
  }

  public static ObjCRuntimeNameAttr cast_ObjCRuntimeNameAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCRuntimeNameAttr(From);
    return llvm.cast(ObjCRuntimeNameAttr.class, From.$deref());
  }

  public static ObjCRuntimeNameAttr cast_or_null_ObjCRuntimeNameAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCRuntimeNameAttr(From);
  }

  public static ObjCRuntimeNameAttr dyn_cast_ObjCRuntimeNameAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static ObjCRuntimeNameAttr dyn_cast_or_null_ObjCRuntimeNameAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeNameAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCRuntimeNameAttr.class, From.$star());
  }

  public static ObjCRuntimeNameAttr cast_ObjCRuntimeNameAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCRuntimeNameAttr(From);
    return llvm.cast(ObjCRuntimeNameAttr.class, From.$star());
  }

  public static ObjCRuntimeNameAttr cast_or_null_ObjCRuntimeNameAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCRuntimeNameAttr(From);
  }

  public static ObjCRuntimeNameAttr dyn_cast_ObjCRuntimeNameAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static ObjCRuntimeNameAttr dyn_cast_or_null_ObjCRuntimeNameAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeNameAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCRuntimeNameAttr.classof(From);
  }

  public static ObjCRuntimeNameAttr cast_ObjCRuntimeNameAttr(Attr/*P*/ From) {
    assert isa_ObjCRuntimeNameAttr(From);
    return (ObjCRuntimeNameAttr) From;
  }

  public static ObjCRuntimeNameAttr cast_or_null_ObjCRuntimeNameAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCRuntimeNameAttr(From);
  }

  public static ObjCRuntimeNameAttr dyn_cast_ObjCRuntimeNameAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static ObjCRuntimeNameAttr dyn_cast_or_null_ObjCRuntimeNameAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCRuntimeNameAttr(From) ? cast_ObjCRuntimeNameAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeVisibleAttr(Attr/*P*/ From) {
    assert From != null;
    return ObjCRuntimeVisibleAttr.classof(From);
  }

  public static ObjCRuntimeVisibleAttr cast_ObjCRuntimeVisibleAttr(Attr/*P*/ From) {
    assert isa_ObjCRuntimeVisibleAttr(From);
    return (ObjCRuntimeVisibleAttr) From;
  }

  public static ObjCRuntimeVisibleAttr cast_or_null_ObjCRuntimeVisibleAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ObjCRuntimeVisibleAttr(From);
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_ObjCRuntimeVisibleAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_or_null_ObjCRuntimeVisibleAttr(Attr/*P*/ From) {
    return (From != null) && isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeVisibleAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjCRuntimeVisibleAttr.class, From.$deref());
  }

  public static ObjCRuntimeVisibleAttr cast_ObjCRuntimeVisibleAttr(type$ref<?>/*P*/ From) {
    assert isa_ObjCRuntimeVisibleAttr(From);
    return llvm.cast(ObjCRuntimeVisibleAttr.class, From.$deref());
  }

  public static ObjCRuntimeVisibleAttr cast_or_null_ObjCRuntimeVisibleAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjCRuntimeVisibleAttr(From);
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_ObjCRuntimeVisibleAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_or_null_ObjCRuntimeVisibleAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static boolean isa_ObjCRuntimeVisibleAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjCRuntimeVisibleAttr.class, From.$star());
  }

  public static ObjCRuntimeVisibleAttr cast_ObjCRuntimeVisibleAttr(type$ptr<?>/*P*/ From) {
    assert isa_ObjCRuntimeVisibleAttr(From);
    return llvm.cast(ObjCRuntimeVisibleAttr.class, From.$star());
  }

  public static ObjCRuntimeVisibleAttr cast_or_null_ObjCRuntimeVisibleAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjCRuntimeVisibleAttr(From);
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_ObjCRuntimeVisibleAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static ObjCRuntimeVisibleAttr dyn_cast_or_null_ObjCRuntimeVisibleAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjCRuntimeVisibleAttr(From) ? cast_ObjCRuntimeVisibleAttr(From) : null;
  }

  public static boolean isa_OpenCLAccessAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OpenCLAccessAttr.class, From.$deref());
  }

  public static OpenCLAccessAttr cast_OpenCLAccessAttr(type$ref<?>/*P*/ From) {
    assert isa_OpenCLAccessAttr(From);
    return llvm.cast(OpenCLAccessAttr.class, From.$deref());
  }

  public static OpenCLAccessAttr cast_or_null_OpenCLAccessAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OpenCLAccessAttr(From);
  }

  public static OpenCLAccessAttr dyn_cast_OpenCLAccessAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static OpenCLAccessAttr dyn_cast_or_null_OpenCLAccessAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static boolean isa_OpenCLAccessAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OpenCLAccessAttr.class, From.$star());
  }

  public static OpenCLAccessAttr cast_OpenCLAccessAttr(type$ptr<?>/*P*/ From) {
    assert isa_OpenCLAccessAttr(From);
    return llvm.cast(OpenCLAccessAttr.class, From.$star());
  }

  public static OpenCLAccessAttr cast_or_null_OpenCLAccessAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OpenCLAccessAttr(From);
  }

  public static OpenCLAccessAttr dyn_cast_OpenCLAccessAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static OpenCLAccessAttr dyn_cast_or_null_OpenCLAccessAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static boolean isa_OpenCLAccessAttr(Attr/*P*/ From) {
    assert From != null;
    return OpenCLAccessAttr.classof(From);
  }

  public static OpenCLAccessAttr cast_OpenCLAccessAttr(Attr/*P*/ From) {
    assert isa_OpenCLAccessAttr(From);
    return (OpenCLAccessAttr) From;
  }

  public static OpenCLAccessAttr cast_or_null_OpenCLAccessAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OpenCLAccessAttr(From);
  }

  public static OpenCLAccessAttr dyn_cast_OpenCLAccessAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static OpenCLAccessAttr dyn_cast_or_null_OpenCLAccessAttr(Attr/*P*/ From) {
    return (From != null) && isa_OpenCLAccessAttr(From) ? cast_OpenCLAccessAttr(From) : null;
  }

  public static boolean isa_OpenCLKernelAttr(Attr/*P*/ From) {
    assert From != null;
    return OpenCLKernelAttr.classof(From);
  }

  public static OpenCLKernelAttr cast_OpenCLKernelAttr(Attr/*P*/ From) {
    assert isa_OpenCLKernelAttr(From);
    return (OpenCLKernelAttr) From;
  }

  public static OpenCLKernelAttr cast_or_null_OpenCLKernelAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OpenCLKernelAttr(From);
  }

  public static OpenCLKernelAttr dyn_cast_OpenCLKernelAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static OpenCLKernelAttr dyn_cast_or_null_OpenCLKernelAttr(Attr/*P*/ From) {
    return (From != null) && isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static boolean isa_OpenCLKernelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OpenCLKernelAttr.class, From.$deref());
  }

  public static OpenCLKernelAttr cast_OpenCLKernelAttr(type$ref<?>/*P*/ From) {
    assert isa_OpenCLKernelAttr(From);
    return llvm.cast(OpenCLKernelAttr.class, From.$deref());
  }

  public static OpenCLKernelAttr cast_or_null_OpenCLKernelAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OpenCLKernelAttr(From);
  }

  public static OpenCLKernelAttr dyn_cast_OpenCLKernelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static OpenCLKernelAttr dyn_cast_or_null_OpenCLKernelAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static boolean isa_OpenCLKernelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OpenCLKernelAttr.class, From.$star());
  }

  public static OpenCLKernelAttr cast_OpenCLKernelAttr(type$ptr<?>/*P*/ From) {
    assert isa_OpenCLKernelAttr(From);
    return llvm.cast(OpenCLKernelAttr.class, From.$star());
  }

  public static OpenCLKernelAttr cast_or_null_OpenCLKernelAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OpenCLKernelAttr(From);
  }

  public static OpenCLKernelAttr dyn_cast_OpenCLKernelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static OpenCLKernelAttr dyn_cast_or_null_OpenCLKernelAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OpenCLKernelAttr(From) ? cast_OpenCLKernelAttr(From) : null;
  }

  public static boolean isa_OpenCLUnrollHintAttr(Attr/*P*/ From) {
    assert From != null;
    return OpenCLUnrollHintAttr.classof(From);
  }

  public static OpenCLUnrollHintAttr cast_OpenCLUnrollHintAttr(Attr/*P*/ From) {
    assert isa_OpenCLUnrollHintAttr(From);
    return (OpenCLUnrollHintAttr) From;
  }

  public static OpenCLUnrollHintAttr cast_or_null_OpenCLUnrollHintAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OpenCLUnrollHintAttr(From);
  }

  public static OpenCLUnrollHintAttr dyn_cast_OpenCLUnrollHintAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static OpenCLUnrollHintAttr dyn_cast_or_null_OpenCLUnrollHintAttr(Attr/*P*/ From) {
    return (From != null) && isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static boolean isa_OpenCLUnrollHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OpenCLUnrollHintAttr.class, From.$star());
  }

  public static OpenCLUnrollHintAttr cast_OpenCLUnrollHintAttr(type$ptr<?>/*P*/ From) {
    assert isa_OpenCLUnrollHintAttr(From);
    return llvm.cast(OpenCLUnrollHintAttr.class, From.$star());
  }

  public static OpenCLUnrollHintAttr cast_or_null_OpenCLUnrollHintAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OpenCLUnrollHintAttr(From);
  }

  public static OpenCLUnrollHintAttr dyn_cast_OpenCLUnrollHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static OpenCLUnrollHintAttr dyn_cast_or_null_OpenCLUnrollHintAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static boolean isa_OpenCLUnrollHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OpenCLUnrollHintAttr.class, From.$deref());
  }

  public static OpenCLUnrollHintAttr cast_OpenCLUnrollHintAttr(type$ref<?>/*P*/ From) {
    assert isa_OpenCLUnrollHintAttr(From);
    return llvm.cast(OpenCLUnrollHintAttr.class, From.$deref());
  }

  public static OpenCLUnrollHintAttr cast_or_null_OpenCLUnrollHintAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OpenCLUnrollHintAttr(From);
  }

  public static OpenCLUnrollHintAttr dyn_cast_OpenCLUnrollHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static OpenCLUnrollHintAttr dyn_cast_or_null_OpenCLUnrollHintAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OpenCLUnrollHintAttr(From) ? cast_OpenCLUnrollHintAttr(From) : null;
  }

  public static boolean isa_OptimizeNoneAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OptimizeNoneAttr.class, From.$deref());
  }

  public static OptimizeNoneAttr cast_OptimizeNoneAttr(type$ref<?>/*P*/ From) {
    assert isa_OptimizeNoneAttr(From);
    return llvm.cast(OptimizeNoneAttr.class, From.$deref());
  }

  public static OptimizeNoneAttr cast_or_null_OptimizeNoneAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OptimizeNoneAttr(From);
  }

  public static OptimizeNoneAttr dyn_cast_OptimizeNoneAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static OptimizeNoneAttr dyn_cast_or_null_OptimizeNoneAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static boolean isa_OptimizeNoneAttr(Attr/*P*/ From) {
    assert From != null;
    return OptimizeNoneAttr.classof(From);
  }

  public static OptimizeNoneAttr cast_OptimizeNoneAttr(Attr/*P*/ From) {
    assert isa_OptimizeNoneAttr(From);
    return (OptimizeNoneAttr) From;
  }

  public static OptimizeNoneAttr cast_or_null_OptimizeNoneAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OptimizeNoneAttr(From);
  }

  public static OptimizeNoneAttr dyn_cast_OptimizeNoneAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static OptimizeNoneAttr dyn_cast_or_null_OptimizeNoneAttr(Attr/*P*/ From) {
    return (From != null) && isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static boolean isa_OptimizeNoneAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OptimizeNoneAttr.class, From.$star());
  }

  public static OptimizeNoneAttr cast_OptimizeNoneAttr(type$ptr<?>/*P*/ From) {
    assert isa_OptimizeNoneAttr(From);
    return llvm.cast(OptimizeNoneAttr.class, From.$star());
  }

  public static OptimizeNoneAttr cast_or_null_OptimizeNoneAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OptimizeNoneAttr(From);
  }

  public static OptimizeNoneAttr dyn_cast_OptimizeNoneAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static OptimizeNoneAttr dyn_cast_or_null_OptimizeNoneAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OptimizeNoneAttr(From) ? cast_OptimizeNoneAttr(From) : null;
  }

  public static boolean isa_OverloadableAttr(Attr/*P*/ From) {
    assert From != null;
    return OverloadableAttr.classof(From);
  }

  public static OverloadableAttr cast_OverloadableAttr(Attr/*P*/ From) {
    assert isa_OverloadableAttr(From);
    return (OverloadableAttr) From;
  }

  public static OverloadableAttr cast_or_null_OverloadableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OverloadableAttr(From);
  }

  public static OverloadableAttr dyn_cast_OverloadableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static OverloadableAttr dyn_cast_or_null_OverloadableAttr(Attr/*P*/ From) {
    return (From != null) && isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static boolean isa_OverloadableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OverloadableAttr.class, From.$star());
  }

  public static OverloadableAttr cast_OverloadableAttr(type$ptr<?>/*P*/ From) {
    assert isa_OverloadableAttr(From);
    return llvm.cast(OverloadableAttr.class, From.$star());
  }

  public static OverloadableAttr cast_or_null_OverloadableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OverloadableAttr(From);
  }

  public static OverloadableAttr dyn_cast_OverloadableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static OverloadableAttr dyn_cast_or_null_OverloadableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static boolean isa_OverloadableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OverloadableAttr.class, From.$deref());
  }

  public static OverloadableAttr cast_OverloadableAttr(type$ref<?>/*P*/ From) {
    assert isa_OverloadableAttr(From);
    return llvm.cast(OverloadableAttr.class, From.$deref());
  }

  public static OverloadableAttr cast_or_null_OverloadableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OverloadableAttr(From);
  }

  public static OverloadableAttr dyn_cast_OverloadableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static OverloadableAttr dyn_cast_or_null_OverloadableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OverloadableAttr(From) ? cast_OverloadableAttr(From) : null;
  }

  public static boolean isa_OverrideAttr(Attr/*P*/ From) {
    assert From != null;
    return OverrideAttr.classof(From);
  }

  public static OverrideAttr cast_OverrideAttr(Attr/*P*/ From) {
    assert isa_OverrideAttr(From);
    return (OverrideAttr) From;
  }

  public static OverrideAttr cast_or_null_OverrideAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OverrideAttr(From);
  }

  public static OverrideAttr dyn_cast_OverrideAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static OverrideAttr dyn_cast_or_null_OverrideAttr(Attr/*P*/ From) {
    return (From != null) && isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static boolean isa_OverrideAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OverrideAttr.class, From.$star());
  }

  public static OverrideAttr cast_OverrideAttr(type$ptr<?>/*P*/ From) {
    assert isa_OverrideAttr(From);
    return llvm.cast(OverrideAttr.class, From.$star());
  }

  public static OverrideAttr cast_or_null_OverrideAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OverrideAttr(From);
  }

  public static OverrideAttr dyn_cast_OverrideAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static OverrideAttr dyn_cast_or_null_OverrideAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static boolean isa_OverrideAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OverrideAttr.class, From.$deref());
  }

  public static OverrideAttr cast_OverrideAttr(type$ref<?>/*P*/ From) {
    assert isa_OverrideAttr(From);
    return llvm.cast(OverrideAttr.class, From.$deref());
  }

  public static OverrideAttr cast_or_null_OverrideAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OverrideAttr(From);
  }

  public static OverrideAttr dyn_cast_OverrideAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static OverrideAttr dyn_cast_or_null_OverrideAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OverrideAttr(From) ? cast_OverrideAttr(From) : null;
  }

  public static boolean isa_OwnershipAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(OwnershipAttr.class, From.$deref());
  }

  public static OwnershipAttr cast_OwnershipAttr(type$ref<?>/*P*/ From) {
    assert isa_OwnershipAttr(From);
    return llvm.cast(OwnershipAttr.class, From.$deref());
  }

  public static OwnershipAttr cast_or_null_OwnershipAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_OwnershipAttr(From);
  }

  public static OwnershipAttr dyn_cast_OwnershipAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static OwnershipAttr dyn_cast_or_null_OwnershipAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static boolean isa_OwnershipAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(OwnershipAttr.class, From.$star());
  }

  public static OwnershipAttr cast_OwnershipAttr(type$ptr<?>/*P*/ From) {
    assert isa_OwnershipAttr(From);
    return llvm.cast(OwnershipAttr.class, From.$star());
  }

  public static OwnershipAttr cast_or_null_OwnershipAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_OwnershipAttr(From);
  }

  public static OwnershipAttr dyn_cast_OwnershipAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static OwnershipAttr dyn_cast_or_null_OwnershipAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static boolean isa_OwnershipAttr(Attr/*P*/ From) {
    assert From != null;
    return OwnershipAttr.classof(From);
  }

  public static OwnershipAttr cast_OwnershipAttr(Attr/*P*/ From) {
    assert isa_OwnershipAttr(From);
    return (OwnershipAttr) From;
  }

  public static OwnershipAttr cast_or_null_OwnershipAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_OwnershipAttr(From);
  }

  public static OwnershipAttr dyn_cast_OwnershipAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static OwnershipAttr dyn_cast_or_null_OwnershipAttr(Attr/*P*/ From) {
    return (From != null) && isa_OwnershipAttr(From) ? cast_OwnershipAttr(From) : null;
  }

  public static boolean isa_PackedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PackedAttr.class, From.$deref());
  }

  public static PackedAttr cast_PackedAttr(type$ref<?>/*P*/ From) {
    assert isa_PackedAttr(From);
    return llvm.cast(PackedAttr.class, From.$deref());
  }

  public static PackedAttr cast_or_null_PackedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PackedAttr(From);
  }

  public static PackedAttr dyn_cast_PackedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static PackedAttr dyn_cast_or_null_PackedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static boolean isa_PackedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PackedAttr.class, From.$star());
  }

  public static PackedAttr cast_PackedAttr(type$ptr<?>/*P*/ From) {
    assert isa_PackedAttr(From);
    return llvm.cast(PackedAttr.class, From.$star());
  }

  public static PackedAttr cast_or_null_PackedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PackedAttr(From);
  }

  public static PackedAttr dyn_cast_PackedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static PackedAttr dyn_cast_or_null_PackedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static boolean isa_PackedAttr(Attr/*P*/ From) {
    assert From != null;
    return PackedAttr.classof(From);
  }

  public static PackedAttr cast_PackedAttr(Attr/*P*/ From) {
    assert isa_PackedAttr(From);
    return (PackedAttr) From;
  }

  public static PackedAttr cast_or_null_PackedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PackedAttr(From);
  }

  public static PackedAttr dyn_cast_PackedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static PackedAttr dyn_cast_or_null_PackedAttr(Attr/*P*/ From) {
    return (From != null) && isa_PackedAttr(From) ? cast_PackedAttr(From) : null;
  }

  public static boolean isa_ParamTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParamTypestateAttr.class, From.$deref());
  }

  public static ParamTypestateAttr cast_ParamTypestateAttr(type$ref<?>/*P*/ From) {
    assert isa_ParamTypestateAttr(From);
    return llvm.cast(ParamTypestateAttr.class, From.$deref());
  }

  public static ParamTypestateAttr cast_or_null_ParamTypestateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParamTypestateAttr(From);
  }

  public static ParamTypestateAttr dyn_cast_ParamTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static ParamTypestateAttr dyn_cast_or_null_ParamTypestateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static boolean isa_ParamTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParamTypestateAttr.class, From.$star());
  }

  public static ParamTypestateAttr cast_ParamTypestateAttr(type$ptr<?>/*P*/ From) {
    assert isa_ParamTypestateAttr(From);
    return llvm.cast(ParamTypestateAttr.class, From.$star());
  }

  public static ParamTypestateAttr cast_or_null_ParamTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParamTypestateAttr(From);
  }

  public static ParamTypestateAttr dyn_cast_ParamTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static ParamTypestateAttr dyn_cast_or_null_ParamTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static boolean isa_ParamTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return ParamTypestateAttr.classof(From);
  }

  public static ParamTypestateAttr cast_ParamTypestateAttr(Attr/*P*/ From) {
    assert isa_ParamTypestateAttr(From);
    return (ParamTypestateAttr) From;
  }

  public static ParamTypestateAttr cast_or_null_ParamTypestateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ParamTypestateAttr(From);
  }

  public static ParamTypestateAttr dyn_cast_ParamTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static ParamTypestateAttr dyn_cast_or_null_ParamTypestateAttr(Attr/*P*/ From) {
    return (From != null) && isa_ParamTypestateAttr(From) ? cast_ParamTypestateAttr(From) : null;
  }

  public static boolean isa_ParameterABIAttr(Attr/*P*/ From) {
    assert From != null;
    return ParameterABIAttr.classof(From);
  }

  public static ParameterABIAttr cast_ParameterABIAttr(Attr/*P*/ From) {
    assert isa_ParameterABIAttr(From);
    return (ParameterABIAttr) From;
  }

  public static ParameterABIAttr cast_or_null_ParameterABIAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ParameterABIAttr(From);
  }

  public static ParameterABIAttr dyn_cast_ParameterABIAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static ParameterABIAttr dyn_cast_or_null_ParameterABIAttr(Attr/*P*/ From) {
    return (From != null) && isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static boolean isa_ParameterABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ParameterABIAttr.class, From.$deref());
  }

  public static ParameterABIAttr cast_ParameterABIAttr(type$ref<?>/*P*/ From) {
    assert isa_ParameterABIAttr(From);
    return llvm.cast(ParameterABIAttr.class, From.$deref());
  }

  public static ParameterABIAttr cast_or_null_ParameterABIAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ParameterABIAttr(From);
  }

  public static ParameterABIAttr dyn_cast_ParameterABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static ParameterABIAttr dyn_cast_or_null_ParameterABIAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static boolean isa_ParameterABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ParameterABIAttr.class, From.$star());
  }

  public static ParameterABIAttr cast_ParameterABIAttr(type$ptr<?>/*P*/ From) {
    assert isa_ParameterABIAttr(From);
    return llvm.cast(ParameterABIAttr.class, From.$star());
  }

  public static ParameterABIAttr cast_or_null_ParameterABIAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ParameterABIAttr(From);
  }

  public static ParameterABIAttr dyn_cast_ParameterABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static ParameterABIAttr dyn_cast_or_null_ParameterABIAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ParameterABIAttr(From) ? cast_ParameterABIAttr(From) : null;
  }

  public static boolean isa_PascalAttr(Attr/*P*/ From) {
    assert From != null;
    return PascalAttr.classof(From);
  }

  public static PascalAttr cast_PascalAttr(Attr/*P*/ From) {
    assert isa_PascalAttr(From);
    return (PascalAttr) From;
  }

  public static PascalAttr cast_or_null_PascalAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PascalAttr(From);
  }

  public static PascalAttr dyn_cast_PascalAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static PascalAttr dyn_cast_or_null_PascalAttr(Attr/*P*/ From) {
    return (From != null) && isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static boolean isa_PascalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PascalAttr.class, From.$star());
  }

  public static PascalAttr cast_PascalAttr(type$ptr<?>/*P*/ From) {
    assert isa_PascalAttr(From);
    return llvm.cast(PascalAttr.class, From.$star());
  }

  public static PascalAttr cast_or_null_PascalAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PascalAttr(From);
  }

  public static PascalAttr dyn_cast_PascalAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static PascalAttr dyn_cast_or_null_PascalAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static boolean isa_PascalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PascalAttr.class, From.$deref());
  }

  public static PascalAttr cast_PascalAttr(type$ref<?>/*P*/ From) {
    assert isa_PascalAttr(From);
    return llvm.cast(PascalAttr.class, From.$deref());
  }

  public static PascalAttr cast_or_null_PascalAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PascalAttr(From);
  }

  public static PascalAttr dyn_cast_PascalAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static PascalAttr dyn_cast_or_null_PascalAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PascalAttr(From) ? cast_PascalAttr(From) : null;
  }

  public static boolean isa_PassObjectSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return PassObjectSizeAttr.classof(From);
  }

  public static PassObjectSizeAttr cast_PassObjectSizeAttr(Attr/*P*/ From) {
    assert isa_PassObjectSizeAttr(From);
    return (PassObjectSizeAttr) From;
  }

  public static PassObjectSizeAttr cast_or_null_PassObjectSizeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PassObjectSizeAttr(From);
  }

  public static PassObjectSizeAttr dyn_cast_PassObjectSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static PassObjectSizeAttr dyn_cast_or_null_PassObjectSizeAttr(Attr/*P*/ From) {
    return (From != null) && isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static boolean isa_PassObjectSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PassObjectSizeAttr.class, From.$deref());
  }

  public static PassObjectSizeAttr cast_PassObjectSizeAttr(type$ref<?>/*P*/ From) {
    assert isa_PassObjectSizeAttr(From);
    return llvm.cast(PassObjectSizeAttr.class, From.$deref());
  }

  public static PassObjectSizeAttr cast_or_null_PassObjectSizeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PassObjectSizeAttr(From);
  }

  public static PassObjectSizeAttr dyn_cast_PassObjectSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static PassObjectSizeAttr dyn_cast_or_null_PassObjectSizeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static boolean isa_PassObjectSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PassObjectSizeAttr.class, From.$star());
  }

  public static PassObjectSizeAttr cast_PassObjectSizeAttr(type$ptr<?>/*P*/ From) {
    assert isa_PassObjectSizeAttr(From);
    return llvm.cast(PassObjectSizeAttr.class, From.$star());
  }

  public static PassObjectSizeAttr cast_or_null_PassObjectSizeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PassObjectSizeAttr(From);
  }

  public static PassObjectSizeAttr dyn_cast_PassObjectSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static PassObjectSizeAttr dyn_cast_or_null_PassObjectSizeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PassObjectSizeAttr(From) ? cast_PassObjectSizeAttr(From) : null;
  }

  public static boolean isa_PcsAttr(Attr/*P*/ From) {
    assert From != null;
    return PcsAttr.classof(From);
  }

  public static PcsAttr cast_PcsAttr(Attr/*P*/ From) {
    assert isa_PcsAttr(From);
    return (PcsAttr) From;
  }

  public static PcsAttr cast_or_null_PcsAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PcsAttr(From);
  }

  public static PcsAttr dyn_cast_PcsAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static PcsAttr dyn_cast_or_null_PcsAttr(Attr/*P*/ From) {
    return (From != null) && isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static boolean isa_PcsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PcsAttr.class, From.$deref());
  }

  public static PcsAttr cast_PcsAttr(type$ref<?>/*P*/ From) {
    assert isa_PcsAttr(From);
    return llvm.cast(PcsAttr.class, From.$deref());
  }

  public static PcsAttr cast_or_null_PcsAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PcsAttr(From);
  }

  public static PcsAttr dyn_cast_PcsAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static PcsAttr dyn_cast_or_null_PcsAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static boolean isa_PcsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PcsAttr.class, From.$star());
  }

  public static PcsAttr cast_PcsAttr(type$ptr<?>/*P*/ From) {
    assert isa_PcsAttr(From);
    return llvm.cast(PcsAttr.class, From.$star());
  }

  public static PcsAttr cast_or_null_PcsAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PcsAttr(From);
  }

  public static PcsAttr dyn_cast_PcsAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static PcsAttr dyn_cast_or_null_PcsAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PcsAttr(From) ? cast_PcsAttr(From) : null;
  }

  public static boolean isa_PreserveAllAttr(Attr/*P*/ From) {
    assert From != null;
    return PreserveAllAttr.classof(From);
  }

  public static PreserveAllAttr cast_PreserveAllAttr(Attr/*P*/ From) {
    assert isa_PreserveAllAttr(From);
    return (PreserveAllAttr) From;
  }

  public static PreserveAllAttr cast_or_null_PreserveAllAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PreserveAllAttr(From);
  }

  public static PreserveAllAttr dyn_cast_PreserveAllAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static PreserveAllAttr dyn_cast_or_null_PreserveAllAttr(Attr/*P*/ From) {
    return (From != null) && isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static boolean isa_PreserveAllAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PreserveAllAttr.class, From.$star());
  }

  public static PreserveAllAttr cast_PreserveAllAttr(type$ptr<?>/*P*/ From) {
    assert isa_PreserveAllAttr(From);
    return llvm.cast(PreserveAllAttr.class, From.$star());
  }

  public static PreserveAllAttr cast_or_null_PreserveAllAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PreserveAllAttr(From);
  }

  public static PreserveAllAttr dyn_cast_PreserveAllAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static PreserveAllAttr dyn_cast_or_null_PreserveAllAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static boolean isa_PreserveAllAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PreserveAllAttr.class, From.$deref());
  }

  public static PreserveAllAttr cast_PreserveAllAttr(type$ref<?>/*P*/ From) {
    assert isa_PreserveAllAttr(From);
    return llvm.cast(PreserveAllAttr.class, From.$deref());
  }

  public static PreserveAllAttr cast_or_null_PreserveAllAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PreserveAllAttr(From);
  }

  public static PreserveAllAttr dyn_cast_PreserveAllAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static PreserveAllAttr dyn_cast_or_null_PreserveAllAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PreserveAllAttr(From) ? cast_PreserveAllAttr(From) : null;
  }

  public static boolean isa_PreserveMostAttr(Attr/*P*/ From) {
    assert From != null;
    return PreserveMostAttr.classof(From);
  }

  public static PreserveMostAttr cast_PreserveMostAttr(Attr/*P*/ From) {
    assert isa_PreserveMostAttr(From);
    return (PreserveMostAttr) From;
  }

  public static PreserveMostAttr cast_or_null_PreserveMostAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PreserveMostAttr(From);
  }

  public static PreserveMostAttr dyn_cast_PreserveMostAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static PreserveMostAttr dyn_cast_or_null_PreserveMostAttr(Attr/*P*/ From) {
    return (From != null) && isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static boolean isa_PreserveMostAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PreserveMostAttr.class, From.$deref());
  }

  public static PreserveMostAttr cast_PreserveMostAttr(type$ref<?>/*P*/ From) {
    assert isa_PreserveMostAttr(From);
    return llvm.cast(PreserveMostAttr.class, From.$deref());
  }

  public static PreserveMostAttr cast_or_null_PreserveMostAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PreserveMostAttr(From);
  }

  public static PreserveMostAttr dyn_cast_PreserveMostAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static PreserveMostAttr dyn_cast_or_null_PreserveMostAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static boolean isa_PreserveMostAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PreserveMostAttr.class, From.$star());
  }

  public static PreserveMostAttr cast_PreserveMostAttr(type$ptr<?>/*P*/ From) {
    assert isa_PreserveMostAttr(From);
    return llvm.cast(PreserveMostAttr.class, From.$star());
  }

  public static PreserveMostAttr cast_or_null_PreserveMostAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PreserveMostAttr(From);
  }

  public static PreserveMostAttr dyn_cast_PreserveMostAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static PreserveMostAttr dyn_cast_or_null_PreserveMostAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PreserveMostAttr(From) ? cast_PreserveMostAttr(From) : null;
  }

  public static boolean isa_PtGuardedByAttr(Attr/*P*/ From) {
    assert From != null;
    return PtGuardedByAttr.classof(From);
  }

  public static PtGuardedByAttr cast_PtGuardedByAttr(Attr/*P*/ From) {
    assert isa_PtGuardedByAttr(From);
    return (PtGuardedByAttr) From;
  }

  public static PtGuardedByAttr cast_or_null_PtGuardedByAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PtGuardedByAttr(From);
  }

  public static PtGuardedByAttr dyn_cast_PtGuardedByAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static PtGuardedByAttr dyn_cast_or_null_PtGuardedByAttr(Attr/*P*/ From) {
    return (From != null) && isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static boolean isa_PtGuardedByAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PtGuardedByAttr.class, From.$deref());
  }

  public static PtGuardedByAttr cast_PtGuardedByAttr(type$ref<?>/*P*/ From) {
    assert isa_PtGuardedByAttr(From);
    return llvm.cast(PtGuardedByAttr.class, From.$deref());
  }

  public static PtGuardedByAttr cast_or_null_PtGuardedByAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PtGuardedByAttr(From);
  }

  public static PtGuardedByAttr dyn_cast_PtGuardedByAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static PtGuardedByAttr dyn_cast_or_null_PtGuardedByAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static boolean isa_PtGuardedByAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PtGuardedByAttr.class, From.$star());
  }

  public static PtGuardedByAttr cast_PtGuardedByAttr(type$ptr<?>/*P*/ From) {
    assert isa_PtGuardedByAttr(From);
    return llvm.cast(PtGuardedByAttr.class, From.$star());
  }

  public static PtGuardedByAttr cast_or_null_PtGuardedByAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PtGuardedByAttr(From);
  }

  public static PtGuardedByAttr dyn_cast_PtGuardedByAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static PtGuardedByAttr dyn_cast_or_null_PtGuardedByAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PtGuardedByAttr(From) ? cast_PtGuardedByAttr(From) : null;
  }

  public static boolean isa_PtGuardedVarAttr(Attr/*P*/ From) {
    assert From != null;
    return PtGuardedVarAttr.classof(From);
  }

  public static PtGuardedVarAttr cast_PtGuardedVarAttr(Attr/*P*/ From) {
    assert isa_PtGuardedVarAttr(From);
    return (PtGuardedVarAttr) From;
  }

  public static PtGuardedVarAttr cast_or_null_PtGuardedVarAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PtGuardedVarAttr(From);
  }

  public static PtGuardedVarAttr dyn_cast_PtGuardedVarAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static PtGuardedVarAttr dyn_cast_or_null_PtGuardedVarAttr(Attr/*P*/ From) {
    return (From != null) && isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static boolean isa_PtGuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PtGuardedVarAttr.class, From.$star());
  }

  public static PtGuardedVarAttr cast_PtGuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert isa_PtGuardedVarAttr(From);
    return llvm.cast(PtGuardedVarAttr.class, From.$star());
  }

  public static PtGuardedVarAttr cast_or_null_PtGuardedVarAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PtGuardedVarAttr(From);
  }

  public static PtGuardedVarAttr dyn_cast_PtGuardedVarAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static PtGuardedVarAttr dyn_cast_or_null_PtGuardedVarAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static boolean isa_PtGuardedVarAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PtGuardedVarAttr.class, From.$deref());
  }

  public static PtGuardedVarAttr cast_PtGuardedVarAttr(type$ref<?>/*P*/ From) {
    assert isa_PtGuardedVarAttr(From);
    return llvm.cast(PtGuardedVarAttr.class, From.$deref());
  }

  public static PtGuardedVarAttr cast_or_null_PtGuardedVarAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PtGuardedVarAttr(From);
  }

  public static PtGuardedVarAttr dyn_cast_PtGuardedVarAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static PtGuardedVarAttr dyn_cast_or_null_PtGuardedVarAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PtGuardedVarAttr(From) ? cast_PtGuardedVarAttr(From) : null;
  }

  public static boolean isa_PureAttr(Attr/*P*/ From) {
    assert From != null;
    return PureAttr.classof(From);
  }

  public static PureAttr cast_PureAttr(Attr/*P*/ From) {
    assert isa_PureAttr(From);
    return (PureAttr) From;
  }

  public static PureAttr cast_or_null_PureAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_PureAttr(From);
  }

  public static PureAttr dyn_cast_PureAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static PureAttr dyn_cast_or_null_PureAttr(Attr/*P*/ From) {
    return (From != null) && isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static boolean isa_PureAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(PureAttr.class, From.$deref());
  }

  public static PureAttr cast_PureAttr(type$ref<?>/*P*/ From) {
    assert isa_PureAttr(From);
    return llvm.cast(PureAttr.class, From.$deref());
  }

  public static PureAttr cast_or_null_PureAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_PureAttr(From);
  }

  public static PureAttr dyn_cast_PureAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static PureAttr dyn_cast_or_null_PureAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static boolean isa_PureAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(PureAttr.class, From.$star());
  }

  public static PureAttr cast_PureAttr(type$ptr<?>/*P*/ From) {
    assert isa_PureAttr(From);
    return llvm.cast(PureAttr.class, From.$star());
  }

  public static PureAttr cast_or_null_PureAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_PureAttr(From);
  }

  public static PureAttr dyn_cast_PureAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static PureAttr dyn_cast_or_null_PureAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_PureAttr(From) ? cast_PureAttr(From) : null;
  }

  public static boolean isa_ReleaseCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return ReleaseCapabilityAttr.classof(From);
  }

  public static ReleaseCapabilityAttr cast_ReleaseCapabilityAttr(Attr/*P*/ From) {
    assert isa_ReleaseCapabilityAttr(From);
    return (ReleaseCapabilityAttr) From;
  }

  public static ReleaseCapabilityAttr cast_or_null_ReleaseCapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ReleaseCapabilityAttr(From);
  }

  public static ReleaseCapabilityAttr dyn_cast_ReleaseCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static ReleaseCapabilityAttr dyn_cast_or_null_ReleaseCapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static boolean isa_ReleaseCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReleaseCapabilityAttr.class, From.$star());
  }

  public static ReleaseCapabilityAttr cast_ReleaseCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_ReleaseCapabilityAttr(From);
    return llvm.cast(ReleaseCapabilityAttr.class, From.$star());
  }

  public static ReleaseCapabilityAttr cast_or_null_ReleaseCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReleaseCapabilityAttr(From);
  }

  public static ReleaseCapabilityAttr dyn_cast_ReleaseCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static ReleaseCapabilityAttr dyn_cast_or_null_ReleaseCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static boolean isa_ReleaseCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReleaseCapabilityAttr.class, From.$deref());
  }

  public static ReleaseCapabilityAttr cast_ReleaseCapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_ReleaseCapabilityAttr(From);
    return llvm.cast(ReleaseCapabilityAttr.class, From.$deref());
  }

  public static ReleaseCapabilityAttr cast_or_null_ReleaseCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReleaseCapabilityAttr(From);
  }

  public static ReleaseCapabilityAttr dyn_cast_ReleaseCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static ReleaseCapabilityAttr dyn_cast_or_null_ReleaseCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReleaseCapabilityAttr(From) ? cast_ReleaseCapabilityAttr(From) : null;
  }

  public static boolean isa_RenderScriptKernelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RenderScriptKernelAttr.class, From.$deref());
  }

  public static RenderScriptKernelAttr cast_RenderScriptKernelAttr(type$ref<?>/*P*/ From) {
    assert isa_RenderScriptKernelAttr(From);
    return llvm.cast(RenderScriptKernelAttr.class, From.$deref());
  }

  public static RenderScriptKernelAttr cast_or_null_RenderScriptKernelAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RenderScriptKernelAttr(From);
  }

  public static RenderScriptKernelAttr dyn_cast_RenderScriptKernelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static RenderScriptKernelAttr dyn_cast_or_null_RenderScriptKernelAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static boolean isa_RenderScriptKernelAttr(Attr/*P*/ From) {
    assert From != null;
    return RenderScriptKernelAttr.classof(From);
  }

  public static RenderScriptKernelAttr cast_RenderScriptKernelAttr(Attr/*P*/ From) {
    assert isa_RenderScriptKernelAttr(From);
    return (RenderScriptKernelAttr) From;
  }

  public static RenderScriptKernelAttr cast_or_null_RenderScriptKernelAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_RenderScriptKernelAttr(From);
  }

  public static RenderScriptKernelAttr dyn_cast_RenderScriptKernelAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static RenderScriptKernelAttr dyn_cast_or_null_RenderScriptKernelAttr(Attr/*P*/ From) {
    return (From != null) && isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static boolean isa_RenderScriptKernelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RenderScriptKernelAttr.class, From.$star());
  }

  public static RenderScriptKernelAttr cast_RenderScriptKernelAttr(type$ptr<?>/*P*/ From) {
    assert isa_RenderScriptKernelAttr(From);
    return llvm.cast(RenderScriptKernelAttr.class, From.$star());
  }

  public static RenderScriptKernelAttr cast_or_null_RenderScriptKernelAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RenderScriptKernelAttr(From);
  }

  public static RenderScriptKernelAttr dyn_cast_RenderScriptKernelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static RenderScriptKernelAttr dyn_cast_or_null_RenderScriptKernelAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RenderScriptKernelAttr(From) ? cast_RenderScriptKernelAttr(From) : null;
  }

  public static boolean isa_ReqdWorkGroupSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReqdWorkGroupSizeAttr.class, From.$deref());
  }

  public static ReqdWorkGroupSizeAttr cast_ReqdWorkGroupSizeAttr(type$ref<?>/*P*/ From) {
    assert isa_ReqdWorkGroupSizeAttr(From);
    return llvm.cast(ReqdWorkGroupSizeAttr.class, From.$deref());
  }

  public static ReqdWorkGroupSizeAttr cast_or_null_ReqdWorkGroupSizeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReqdWorkGroupSizeAttr(From);
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_ReqdWorkGroupSizeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_or_null_ReqdWorkGroupSizeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static boolean isa_ReqdWorkGroupSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReqdWorkGroupSizeAttr.class, From.$star());
  }

  public static ReqdWorkGroupSizeAttr cast_ReqdWorkGroupSizeAttr(type$ptr<?>/*P*/ From) {
    assert isa_ReqdWorkGroupSizeAttr(From);
    return llvm.cast(ReqdWorkGroupSizeAttr.class, From.$star());
  }

  public static ReqdWorkGroupSizeAttr cast_or_null_ReqdWorkGroupSizeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReqdWorkGroupSizeAttr(From);
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_ReqdWorkGroupSizeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_or_null_ReqdWorkGroupSizeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static boolean isa_ReqdWorkGroupSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return ReqdWorkGroupSizeAttr.classof(From);
  }

  public static ReqdWorkGroupSizeAttr cast_ReqdWorkGroupSizeAttr(Attr/*P*/ From) {
    assert isa_ReqdWorkGroupSizeAttr(From);
    return (ReqdWorkGroupSizeAttr) From;
  }

  public static ReqdWorkGroupSizeAttr cast_or_null_ReqdWorkGroupSizeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ReqdWorkGroupSizeAttr(From);
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_ReqdWorkGroupSizeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static ReqdWorkGroupSizeAttr dyn_cast_or_null_ReqdWorkGroupSizeAttr(Attr/*P*/ From) {
    return (From != null) && isa_ReqdWorkGroupSizeAttr(From) ? cast_ReqdWorkGroupSizeAttr(From) : null;
  }

  public static boolean isa_RequiresCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return RequiresCapabilityAttr.classof(From);
  }

  public static RequiresCapabilityAttr cast_RequiresCapabilityAttr(Attr/*P*/ From) {
    assert isa_RequiresCapabilityAttr(From);
    return (RequiresCapabilityAttr) From;
  }

  public static RequiresCapabilityAttr cast_or_null_RequiresCapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_RequiresCapabilityAttr(From);
  }

  public static RequiresCapabilityAttr dyn_cast_RequiresCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static RequiresCapabilityAttr dyn_cast_or_null_RequiresCapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static boolean isa_RequiresCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RequiresCapabilityAttr.class, From.$star());
  }

  public static RequiresCapabilityAttr cast_RequiresCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_RequiresCapabilityAttr(From);
    return llvm.cast(RequiresCapabilityAttr.class, From.$star());
  }

  public static RequiresCapabilityAttr cast_or_null_RequiresCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RequiresCapabilityAttr(From);
  }

  public static RequiresCapabilityAttr dyn_cast_RequiresCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static RequiresCapabilityAttr dyn_cast_or_null_RequiresCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static boolean isa_RequiresCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RequiresCapabilityAttr.class, From.$deref());
  }

  public static RequiresCapabilityAttr cast_RequiresCapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_RequiresCapabilityAttr(From);
    return llvm.cast(RequiresCapabilityAttr.class, From.$deref());
  }

  public static RequiresCapabilityAttr cast_or_null_RequiresCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RequiresCapabilityAttr(From);
  }

  public static RequiresCapabilityAttr dyn_cast_RequiresCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static RequiresCapabilityAttr dyn_cast_or_null_RequiresCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RequiresCapabilityAttr(From) ? cast_RequiresCapabilityAttr(From) : null;
  }

  public static boolean isa_RestrictAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RestrictAttr.class, From.$deref());
  }

  public static RestrictAttr cast_RestrictAttr(type$ref<?>/*P*/ From) {
    assert isa_RestrictAttr(From);
    return llvm.cast(RestrictAttr.class, From.$deref());
  }

  public static RestrictAttr cast_or_null_RestrictAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RestrictAttr(From);
  }

  public static RestrictAttr dyn_cast_RestrictAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static RestrictAttr dyn_cast_or_null_RestrictAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static boolean isa_RestrictAttr(Attr/*P*/ From) {
    assert From != null;
    return RestrictAttr.classof(From);
  }

  public static RestrictAttr cast_RestrictAttr(Attr/*P*/ From) {
    assert isa_RestrictAttr(From);
    return (RestrictAttr) From;
  }

  public static RestrictAttr cast_or_null_RestrictAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_RestrictAttr(From);
  }

  public static RestrictAttr dyn_cast_RestrictAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static RestrictAttr dyn_cast_or_null_RestrictAttr(Attr/*P*/ From) {
    return (From != null) && isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static boolean isa_RestrictAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RestrictAttr.class, From.$star());
  }

  public static RestrictAttr cast_RestrictAttr(type$ptr<?>/*P*/ From) {
    assert isa_RestrictAttr(From);
    return llvm.cast(RestrictAttr.class, From.$star());
  }

  public static RestrictAttr cast_or_null_RestrictAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RestrictAttr(From);
  }

  public static RestrictAttr dyn_cast_RestrictAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static RestrictAttr dyn_cast_or_null_RestrictAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RestrictAttr(From) ? cast_RestrictAttr(From) : null;
  }

  public static boolean isa_ReturnTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReturnTypestateAttr.class, From.$star());
  }

  public static ReturnTypestateAttr cast_ReturnTypestateAttr(type$ptr<?>/*P*/ From) {
    assert isa_ReturnTypestateAttr(From);
    return llvm.cast(ReturnTypestateAttr.class, From.$star());
  }

  public static ReturnTypestateAttr cast_or_null_ReturnTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReturnTypestateAttr(From);
  }

  public static ReturnTypestateAttr dyn_cast_ReturnTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static ReturnTypestateAttr dyn_cast_or_null_ReturnTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static boolean isa_ReturnTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReturnTypestateAttr.class, From.$deref());
  }

  public static ReturnTypestateAttr cast_ReturnTypestateAttr(type$ref<?>/*P*/ From) {
    assert isa_ReturnTypestateAttr(From);
    return llvm.cast(ReturnTypestateAttr.class, From.$deref());
  }

  public static ReturnTypestateAttr cast_or_null_ReturnTypestateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReturnTypestateAttr(From);
  }

  public static ReturnTypestateAttr dyn_cast_ReturnTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static ReturnTypestateAttr dyn_cast_or_null_ReturnTypestateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static boolean isa_ReturnTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return ReturnTypestateAttr.classof(From);
  }

  public static ReturnTypestateAttr cast_ReturnTypestateAttr(Attr/*P*/ From) {
    assert isa_ReturnTypestateAttr(From);
    return (ReturnTypestateAttr) From;
  }

  public static ReturnTypestateAttr cast_or_null_ReturnTypestateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ReturnTypestateAttr(From);
  }

  public static ReturnTypestateAttr dyn_cast_ReturnTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static ReturnTypestateAttr dyn_cast_or_null_ReturnTypestateAttr(Attr/*P*/ From) {
    return (From != null) && isa_ReturnTypestateAttr(From) ? cast_ReturnTypestateAttr(From) : null;
  }

  public static boolean isa_ReturnsNonNullAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReturnsNonNullAttr.class, From.$star());
  }

  public static ReturnsNonNullAttr cast_ReturnsNonNullAttr(type$ptr<?>/*P*/ From) {
    assert isa_ReturnsNonNullAttr(From);
    return llvm.cast(ReturnsNonNullAttr.class, From.$star());
  }

  public static ReturnsNonNullAttr cast_or_null_ReturnsNonNullAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReturnsNonNullAttr(From);
  }

  public static ReturnsNonNullAttr dyn_cast_ReturnsNonNullAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static ReturnsNonNullAttr dyn_cast_or_null_ReturnsNonNullAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static boolean isa_ReturnsNonNullAttr(Attr/*P*/ From) {
    assert From != null;
    return ReturnsNonNullAttr.classof(From);
  }

  public static ReturnsNonNullAttr cast_ReturnsNonNullAttr(Attr/*P*/ From) {
    assert isa_ReturnsNonNullAttr(From);
    return (ReturnsNonNullAttr) From;
  }

  public static ReturnsNonNullAttr cast_or_null_ReturnsNonNullAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ReturnsNonNullAttr(From);
  }

  public static ReturnsNonNullAttr dyn_cast_ReturnsNonNullAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static ReturnsNonNullAttr dyn_cast_or_null_ReturnsNonNullAttr(Attr/*P*/ From) {
    return (From != null) && isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static boolean isa_ReturnsNonNullAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReturnsNonNullAttr.class, From.$deref());
  }

  public static ReturnsNonNullAttr cast_ReturnsNonNullAttr(type$ref<?>/*P*/ From) {
    assert isa_ReturnsNonNullAttr(From);
    return llvm.cast(ReturnsNonNullAttr.class, From.$deref());
  }

  public static ReturnsNonNullAttr cast_or_null_ReturnsNonNullAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReturnsNonNullAttr(From);
  }

  public static ReturnsNonNullAttr dyn_cast_ReturnsNonNullAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static ReturnsNonNullAttr dyn_cast_or_null_ReturnsNonNullAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReturnsNonNullAttr(From) ? cast_ReturnsNonNullAttr(From) : null;
  }

  public static boolean isa_ReturnsTwiceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ReturnsTwiceAttr.class, From.$deref());
  }

  public static ReturnsTwiceAttr cast_ReturnsTwiceAttr(type$ref<?>/*P*/ From) {
    assert isa_ReturnsTwiceAttr(From);
    return llvm.cast(ReturnsTwiceAttr.class, From.$deref());
  }

  public static ReturnsTwiceAttr cast_or_null_ReturnsTwiceAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ReturnsTwiceAttr(From);
  }

  public static ReturnsTwiceAttr dyn_cast_ReturnsTwiceAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static ReturnsTwiceAttr dyn_cast_or_null_ReturnsTwiceAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static boolean isa_ReturnsTwiceAttr(Attr/*P*/ From) {
    assert From != null;
    return ReturnsTwiceAttr.classof(From);
  }

  public static ReturnsTwiceAttr cast_ReturnsTwiceAttr(Attr/*P*/ From) {
    assert isa_ReturnsTwiceAttr(From);
    return (ReturnsTwiceAttr) From;
  }

  public static ReturnsTwiceAttr cast_or_null_ReturnsTwiceAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ReturnsTwiceAttr(From);
  }

  public static ReturnsTwiceAttr dyn_cast_ReturnsTwiceAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static ReturnsTwiceAttr dyn_cast_or_null_ReturnsTwiceAttr(Attr/*P*/ From) {
    return (From != null) && isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static boolean isa_ReturnsTwiceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ReturnsTwiceAttr.class, From.$star());
  }

  public static ReturnsTwiceAttr cast_ReturnsTwiceAttr(type$ptr<?>/*P*/ From) {
    assert isa_ReturnsTwiceAttr(From);
    return llvm.cast(ReturnsTwiceAttr.class, From.$star());
  }

  public static ReturnsTwiceAttr cast_or_null_ReturnsTwiceAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ReturnsTwiceAttr(From);
  }

  public static ReturnsTwiceAttr dyn_cast_ReturnsTwiceAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static ReturnsTwiceAttr dyn_cast_or_null_ReturnsTwiceAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ReturnsTwiceAttr(From) ? cast_ReturnsTwiceAttr(From) : null;
  }

  public static boolean isa_ScopedLockableAttr(Attr/*P*/ From) {
    assert From != null;
    return ScopedLockableAttr.classof(From);
  }

  public static ScopedLockableAttr cast_ScopedLockableAttr(Attr/*P*/ From) {
    assert isa_ScopedLockableAttr(From);
    return (ScopedLockableAttr) From;
  }

  public static ScopedLockableAttr cast_or_null_ScopedLockableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ScopedLockableAttr(From);
  }

  public static ScopedLockableAttr dyn_cast_ScopedLockableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static ScopedLockableAttr dyn_cast_or_null_ScopedLockableAttr(Attr/*P*/ From) {
    return (From != null) && isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static boolean isa_ScopedLockableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ScopedLockableAttr.class, From.$star());
  }

  public static ScopedLockableAttr cast_ScopedLockableAttr(type$ptr<?>/*P*/ From) {
    assert isa_ScopedLockableAttr(From);
    return llvm.cast(ScopedLockableAttr.class, From.$star());
  }

  public static ScopedLockableAttr cast_or_null_ScopedLockableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ScopedLockableAttr(From);
  }

  public static ScopedLockableAttr dyn_cast_ScopedLockableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static ScopedLockableAttr dyn_cast_or_null_ScopedLockableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static boolean isa_ScopedLockableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ScopedLockableAttr.class, From.$deref());
  }

  public static ScopedLockableAttr cast_ScopedLockableAttr(type$ref<?>/*P*/ From) {
    assert isa_ScopedLockableAttr(From);
    return llvm.cast(ScopedLockableAttr.class, From.$deref());
  }

  public static ScopedLockableAttr cast_or_null_ScopedLockableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ScopedLockableAttr(From);
  }

  public static ScopedLockableAttr dyn_cast_ScopedLockableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static ScopedLockableAttr dyn_cast_or_null_ScopedLockableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ScopedLockableAttr(From) ? cast_ScopedLockableAttr(From) : null;
  }

  public static boolean isa_SectionAttr(Attr/*P*/ From) {
    assert From != null;
    return SectionAttr.classof(From);
  }

  public static SectionAttr cast_SectionAttr(Attr/*P*/ From) {
    assert isa_SectionAttr(From);
    return (SectionAttr) From;
  }

  public static SectionAttr cast_or_null_SectionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SectionAttr(From);
  }

  public static SectionAttr dyn_cast_SectionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static SectionAttr dyn_cast_or_null_SectionAttr(Attr/*P*/ From) {
    return (From != null) && isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static boolean isa_SectionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SectionAttr.class, From.$star());
  }

  public static SectionAttr cast_SectionAttr(type$ptr<?>/*P*/ From) {
    assert isa_SectionAttr(From);
    return llvm.cast(SectionAttr.class, From.$star());
  }

  public static SectionAttr cast_or_null_SectionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SectionAttr(From);
  }

  public static SectionAttr dyn_cast_SectionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static SectionAttr dyn_cast_or_null_SectionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static boolean isa_SectionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SectionAttr.class, From.$deref());
  }

  public static SectionAttr cast_SectionAttr(type$ref<?>/*P*/ From) {
    assert isa_SectionAttr(From);
    return llvm.cast(SectionAttr.class, From.$deref());
  }

  public static SectionAttr cast_or_null_SectionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SectionAttr(From);
  }

  public static SectionAttr dyn_cast_SectionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static SectionAttr dyn_cast_or_null_SectionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SectionAttr(From) ? cast_SectionAttr(From) : null;
  }

  public static boolean isa_SelectAnyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SelectAnyAttr.class, From.$deref());
  }

  public static SelectAnyAttr cast_SelectAnyAttr(type$ref<?>/*P*/ From) {
    assert isa_SelectAnyAttr(From);
    return llvm.cast(SelectAnyAttr.class, From.$deref());
  }

  public static SelectAnyAttr cast_or_null_SelectAnyAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SelectAnyAttr(From);
  }

  public static SelectAnyAttr dyn_cast_SelectAnyAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static SelectAnyAttr dyn_cast_or_null_SelectAnyAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static boolean isa_SelectAnyAttr(Attr/*P*/ From) {
    assert From != null;
    return SelectAnyAttr.classof(From);
  }

  public static SelectAnyAttr cast_SelectAnyAttr(Attr/*P*/ From) {
    assert isa_SelectAnyAttr(From);
    return (SelectAnyAttr) From;
  }

  public static SelectAnyAttr cast_or_null_SelectAnyAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SelectAnyAttr(From);
  }

  public static SelectAnyAttr dyn_cast_SelectAnyAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static SelectAnyAttr dyn_cast_or_null_SelectAnyAttr(Attr/*P*/ From) {
    return (From != null) && isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static boolean isa_SelectAnyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SelectAnyAttr.class, From.$star());
  }

  public static SelectAnyAttr cast_SelectAnyAttr(type$ptr<?>/*P*/ From) {
    assert isa_SelectAnyAttr(From);
    return llvm.cast(SelectAnyAttr.class, From.$star());
  }

  public static SelectAnyAttr cast_or_null_SelectAnyAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SelectAnyAttr(From);
  }

  public static SelectAnyAttr dyn_cast_SelectAnyAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static SelectAnyAttr dyn_cast_or_null_SelectAnyAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SelectAnyAttr(From) ? cast_SelectAnyAttr(From) : null;
  }

  public static boolean isa_SentinelAttr(Attr/*P*/ From) {
    assert From != null;
    return SentinelAttr.classof(From);
  }

  public static SentinelAttr cast_SentinelAttr(Attr/*P*/ From) {
    assert isa_SentinelAttr(From);
    return (SentinelAttr) From;
  }

  public static SentinelAttr cast_or_null_SentinelAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SentinelAttr(From);
  }

  public static SentinelAttr dyn_cast_SentinelAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static SentinelAttr dyn_cast_or_null_SentinelAttr(Attr/*P*/ From) {
    return (From != null) && isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static boolean isa_SentinelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SentinelAttr.class, From.$star());
  }

  public static SentinelAttr cast_SentinelAttr(type$ptr<?>/*P*/ From) {
    assert isa_SentinelAttr(From);
    return llvm.cast(SentinelAttr.class, From.$star());
  }

  public static SentinelAttr cast_or_null_SentinelAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SentinelAttr(From);
  }

  public static SentinelAttr dyn_cast_SentinelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static SentinelAttr dyn_cast_or_null_SentinelAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static boolean isa_SentinelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SentinelAttr.class, From.$deref());
  }

  public static SentinelAttr cast_SentinelAttr(type$ref<?>/*P*/ From) {
    assert isa_SentinelAttr(From);
    return llvm.cast(SentinelAttr.class, From.$deref());
  }

  public static SentinelAttr cast_or_null_SentinelAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SentinelAttr(From);
  }

  public static SentinelAttr dyn_cast_SentinelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static SentinelAttr dyn_cast_or_null_SentinelAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SentinelAttr(From) ? cast_SentinelAttr(From) : null;
  }

  public static boolean isa_SetTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SetTypestateAttr.class, From.$deref());
  }

  public static SetTypestateAttr cast_SetTypestateAttr(type$ref<?>/*P*/ From) {
    assert isa_SetTypestateAttr(From);
    return llvm.cast(SetTypestateAttr.class, From.$deref());
  }

  public static SetTypestateAttr cast_or_null_SetTypestateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SetTypestateAttr(From);
  }

  public static SetTypestateAttr dyn_cast_SetTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static SetTypestateAttr dyn_cast_or_null_SetTypestateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static boolean isa_SetTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return SetTypestateAttr.classof(From);
  }

  public static SetTypestateAttr cast_SetTypestateAttr(Attr/*P*/ From) {
    assert isa_SetTypestateAttr(From);
    return (SetTypestateAttr) From;
  }

  public static SetTypestateAttr cast_or_null_SetTypestateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SetTypestateAttr(From);
  }

  public static SetTypestateAttr dyn_cast_SetTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static SetTypestateAttr dyn_cast_or_null_SetTypestateAttr(Attr/*P*/ From) {
    return (From != null) && isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static boolean isa_SetTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SetTypestateAttr.class, From.$star());
  }

  public static SetTypestateAttr cast_SetTypestateAttr(type$ptr<?>/*P*/ From) {
    assert isa_SetTypestateAttr(From);
    return llvm.cast(SetTypestateAttr.class, From.$star());
  }

  public static SetTypestateAttr cast_or_null_SetTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SetTypestateAttr(From);
  }

  public static SetTypestateAttr dyn_cast_SetTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static SetTypestateAttr dyn_cast_or_null_SetTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SetTypestateAttr(From) ? cast_SetTypestateAttr(From) : null;
  }

  public static boolean isa_SharedTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SharedTrylockFunctionAttr.class, From.$star());
  }

  public static SharedTrylockFunctionAttr cast_SharedTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert isa_SharedTrylockFunctionAttr(From);
    return llvm.cast(SharedTrylockFunctionAttr.class, From.$star());
  }

  public static SharedTrylockFunctionAttr cast_or_null_SharedTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SharedTrylockFunctionAttr(From);
  }

  public static SharedTrylockFunctionAttr dyn_cast_SharedTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static SharedTrylockFunctionAttr dyn_cast_or_null_SharedTrylockFunctionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_SharedTrylockFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return SharedTrylockFunctionAttr.classof(From);
  }

  public static SharedTrylockFunctionAttr cast_SharedTrylockFunctionAttr(Attr/*P*/ From) {
    assert isa_SharedTrylockFunctionAttr(From);
    return (SharedTrylockFunctionAttr) From;
  }

  public static SharedTrylockFunctionAttr cast_or_null_SharedTrylockFunctionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SharedTrylockFunctionAttr(From);
  }

  public static SharedTrylockFunctionAttr dyn_cast_SharedTrylockFunctionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static SharedTrylockFunctionAttr dyn_cast_or_null_SharedTrylockFunctionAttr(Attr/*P*/ From) {
    return (From != null) && isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_SharedTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SharedTrylockFunctionAttr.class, From.$deref());
  }

  public static SharedTrylockFunctionAttr cast_SharedTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert isa_SharedTrylockFunctionAttr(From);
    return llvm.cast(SharedTrylockFunctionAttr.class, From.$deref());
  }

  public static SharedTrylockFunctionAttr cast_or_null_SharedTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SharedTrylockFunctionAttr(From);
  }

  public static SharedTrylockFunctionAttr dyn_cast_SharedTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static SharedTrylockFunctionAttr dyn_cast_or_null_SharedTrylockFunctionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SharedTrylockFunctionAttr(From) ? cast_SharedTrylockFunctionAttr(From) : null;
  }

  public static boolean isa_StdCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StdCallAttr.class, From.$deref());
  }

  public static StdCallAttr cast_StdCallAttr(type$ref<?>/*P*/ From) {
    assert isa_StdCallAttr(From);
    return llvm.cast(StdCallAttr.class, From.$deref());
  }

  public static StdCallAttr cast_or_null_StdCallAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StdCallAttr(From);
  }

  public static StdCallAttr dyn_cast_StdCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static StdCallAttr dyn_cast_or_null_StdCallAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static boolean isa_StdCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StdCallAttr.class, From.$star());
  }

  public static StdCallAttr cast_StdCallAttr(type$ptr<?>/*P*/ From) {
    assert isa_StdCallAttr(From);
    return llvm.cast(StdCallAttr.class, From.$star());
  }

  public static StdCallAttr cast_or_null_StdCallAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StdCallAttr(From);
  }

  public static StdCallAttr dyn_cast_StdCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static StdCallAttr dyn_cast_or_null_StdCallAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static boolean isa_StdCallAttr(Attr/*P*/ From) {
    assert From != null;
    return StdCallAttr.classof(From);
  }

  public static StdCallAttr cast_StdCallAttr(Attr/*P*/ From) {
    assert isa_StdCallAttr(From);
    return (StdCallAttr) From;
  }

  public static StdCallAttr cast_or_null_StdCallAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_StdCallAttr(From);
  }

  public static StdCallAttr dyn_cast_StdCallAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static StdCallAttr dyn_cast_or_null_StdCallAttr(Attr/*P*/ From) {
    return (From != null) && isa_StdCallAttr(From) ? cast_StdCallAttr(From) : null;
  }

  public static boolean isa_StmtAttr(Attr/*P*/ From) {
    assert From != null;
    return StmtAttr.classof(From);
  }

  public static StmtAttr cast_StmtAttr(Attr/*P*/ From) {
    assert isa_StmtAttr(From);
    return (StmtAttr) From;
  }

  public static StmtAttr cast_or_null_StmtAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_StmtAttr(From);
  }

  public static StmtAttr dyn_cast_StmtAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static StmtAttr dyn_cast_or_null_StmtAttr(Attr/*P*/ From) {
    return (From != null) && isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static boolean isa_StmtAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(StmtAttr.class, From.$deref());
  }

  public static StmtAttr cast_StmtAttr(type$ref<?>/*P*/ From) {
    assert isa_StmtAttr(From);
    return llvm.cast(StmtAttr.class, From.$deref());
  }

  public static StmtAttr cast_or_null_StmtAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_StmtAttr(From);
  }

  public static StmtAttr dyn_cast_StmtAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static StmtAttr dyn_cast_or_null_StmtAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static boolean isa_StmtAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(StmtAttr.class, From.$star());
  }

  public static StmtAttr cast_StmtAttr(type$ptr<?>/*P*/ From) {
    assert isa_StmtAttr(From);
    return llvm.cast(StmtAttr.class, From.$star());
  }

  public static StmtAttr cast_or_null_StmtAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_StmtAttr(From);
  }

  public static StmtAttr dyn_cast_StmtAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static StmtAttr dyn_cast_or_null_StmtAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_StmtAttr(From) ? cast_StmtAttr(From) : null;
  }

  public static boolean isa_SwiftCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwiftCallAttr.class, From.$star());
  }

  public static SwiftCallAttr cast_SwiftCallAttr(type$ptr<?>/*P*/ From) {
    assert isa_SwiftCallAttr(From);
    return llvm.cast(SwiftCallAttr.class, From.$star());
  }

  public static SwiftCallAttr cast_or_null_SwiftCallAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwiftCallAttr(From);
  }

  public static SwiftCallAttr dyn_cast_SwiftCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static SwiftCallAttr dyn_cast_or_null_SwiftCallAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static boolean isa_SwiftCallAttr(Attr/*P*/ From) {
    assert From != null;
    return SwiftCallAttr.classof(From);
  }

  public static SwiftCallAttr cast_SwiftCallAttr(Attr/*P*/ From) {
    assert isa_SwiftCallAttr(From);
    return (SwiftCallAttr) From;
  }

  public static SwiftCallAttr cast_or_null_SwiftCallAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SwiftCallAttr(From);
  }

  public static SwiftCallAttr dyn_cast_SwiftCallAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static SwiftCallAttr dyn_cast_or_null_SwiftCallAttr(Attr/*P*/ From) {
    return (From != null) && isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static boolean isa_SwiftCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwiftCallAttr.class, From.$deref());
  }

  public static SwiftCallAttr cast_SwiftCallAttr(type$ref<?>/*P*/ From) {
    assert isa_SwiftCallAttr(From);
    return llvm.cast(SwiftCallAttr.class, From.$deref());
  }

  public static SwiftCallAttr cast_or_null_SwiftCallAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwiftCallAttr(From);
  }

  public static SwiftCallAttr dyn_cast_SwiftCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static SwiftCallAttr dyn_cast_or_null_SwiftCallAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwiftCallAttr(From) ? cast_SwiftCallAttr(From) : null;
  }

  public static boolean isa_SwiftContextAttr(Attr/*P*/ From) {
    assert From != null;
    return SwiftContextAttr.classof(From);
  }

  public static SwiftContextAttr cast_SwiftContextAttr(Attr/*P*/ From) {
    assert isa_SwiftContextAttr(From);
    return (SwiftContextAttr) From;
  }

  public static SwiftContextAttr cast_or_null_SwiftContextAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SwiftContextAttr(From);
  }

  public static SwiftContextAttr dyn_cast_SwiftContextAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static SwiftContextAttr dyn_cast_or_null_SwiftContextAttr(Attr/*P*/ From) {
    return (From != null) && isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static boolean isa_SwiftContextAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwiftContextAttr.class, From.$star());
  }

  public static SwiftContextAttr cast_SwiftContextAttr(type$ptr<?>/*P*/ From) {
    assert isa_SwiftContextAttr(From);
    return llvm.cast(SwiftContextAttr.class, From.$star());
  }

  public static SwiftContextAttr cast_or_null_SwiftContextAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwiftContextAttr(From);
  }

  public static SwiftContextAttr dyn_cast_SwiftContextAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static SwiftContextAttr dyn_cast_or_null_SwiftContextAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static boolean isa_SwiftContextAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwiftContextAttr.class, From.$deref());
  }

  public static SwiftContextAttr cast_SwiftContextAttr(type$ref<?>/*P*/ From) {
    assert isa_SwiftContextAttr(From);
    return llvm.cast(SwiftContextAttr.class, From.$deref());
  }

  public static SwiftContextAttr cast_or_null_SwiftContextAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwiftContextAttr(From);
  }

  public static SwiftContextAttr dyn_cast_SwiftContextAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static SwiftContextAttr dyn_cast_or_null_SwiftContextAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwiftContextAttr(From) ? cast_SwiftContextAttr(From) : null;
  }

  public static boolean isa_SwiftErrorResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwiftErrorResultAttr.class, From.$deref());
  }

  public static SwiftErrorResultAttr cast_SwiftErrorResultAttr(type$ref<?>/*P*/ From) {
    assert isa_SwiftErrorResultAttr(From);
    return llvm.cast(SwiftErrorResultAttr.class, From.$deref());
  }

  public static SwiftErrorResultAttr cast_or_null_SwiftErrorResultAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwiftErrorResultAttr(From);
  }

  public static SwiftErrorResultAttr dyn_cast_SwiftErrorResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static SwiftErrorResultAttr dyn_cast_or_null_SwiftErrorResultAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static boolean isa_SwiftErrorResultAttr(Attr/*P*/ From) {
    assert From != null;
    return SwiftErrorResultAttr.classof(From);
  }

  public static SwiftErrorResultAttr cast_SwiftErrorResultAttr(Attr/*P*/ From) {
    assert isa_SwiftErrorResultAttr(From);
    return (SwiftErrorResultAttr) From;
  }

  public static SwiftErrorResultAttr cast_or_null_SwiftErrorResultAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SwiftErrorResultAttr(From);
  }

  public static SwiftErrorResultAttr dyn_cast_SwiftErrorResultAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static SwiftErrorResultAttr dyn_cast_or_null_SwiftErrorResultAttr(Attr/*P*/ From) {
    return (From != null) && isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static boolean isa_SwiftErrorResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwiftErrorResultAttr.class, From.$star());
  }

  public static SwiftErrorResultAttr cast_SwiftErrorResultAttr(type$ptr<?>/*P*/ From) {
    assert isa_SwiftErrorResultAttr(From);
    return llvm.cast(SwiftErrorResultAttr.class, From.$star());
  }

  public static SwiftErrorResultAttr cast_or_null_SwiftErrorResultAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwiftErrorResultAttr(From);
  }

  public static SwiftErrorResultAttr dyn_cast_SwiftErrorResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static SwiftErrorResultAttr dyn_cast_or_null_SwiftErrorResultAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwiftErrorResultAttr(From) ? cast_SwiftErrorResultAttr(From) : null;
  }

  public static boolean isa_SwiftIndirectResultAttr(Attr/*P*/ From) {
    assert From != null;
    return SwiftIndirectResultAttr.classof(From);
  }

  public static SwiftIndirectResultAttr cast_SwiftIndirectResultAttr(Attr/*P*/ From) {
    assert isa_SwiftIndirectResultAttr(From);
    return (SwiftIndirectResultAttr) From;
  }

  public static SwiftIndirectResultAttr cast_or_null_SwiftIndirectResultAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SwiftIndirectResultAttr(From);
  }

  public static SwiftIndirectResultAttr dyn_cast_SwiftIndirectResultAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static SwiftIndirectResultAttr dyn_cast_or_null_SwiftIndirectResultAttr(Attr/*P*/ From) {
    return (From != null) && isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static boolean isa_SwiftIndirectResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SwiftIndirectResultAttr.class, From.$deref());
  }

  public static SwiftIndirectResultAttr cast_SwiftIndirectResultAttr(type$ref<?>/*P*/ From) {
    assert isa_SwiftIndirectResultAttr(From);
    return llvm.cast(SwiftIndirectResultAttr.class, From.$deref());
  }

  public static SwiftIndirectResultAttr cast_or_null_SwiftIndirectResultAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SwiftIndirectResultAttr(From);
  }

  public static SwiftIndirectResultAttr dyn_cast_SwiftIndirectResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static SwiftIndirectResultAttr dyn_cast_or_null_SwiftIndirectResultAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static boolean isa_SwiftIndirectResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SwiftIndirectResultAttr.class, From.$star());
  }

  public static SwiftIndirectResultAttr cast_SwiftIndirectResultAttr(type$ptr<?>/*P*/ From) {
    assert isa_SwiftIndirectResultAttr(From);
    return llvm.cast(SwiftIndirectResultAttr.class, From.$star());
  }

  public static SwiftIndirectResultAttr cast_or_null_SwiftIndirectResultAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SwiftIndirectResultAttr(From);
  }

  public static SwiftIndirectResultAttr dyn_cast_SwiftIndirectResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static SwiftIndirectResultAttr dyn_cast_or_null_SwiftIndirectResultAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SwiftIndirectResultAttr(From) ? cast_SwiftIndirectResultAttr(From) : null;
  }

  public static boolean isa_SysVABIAttr(Attr/*P*/ From) {
    assert From != null;
    return SysVABIAttr.classof(From);
  }

  public static SysVABIAttr cast_SysVABIAttr(Attr/*P*/ From) {
    assert isa_SysVABIAttr(From);
    return (SysVABIAttr) From;
  }

  public static SysVABIAttr cast_or_null_SysVABIAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_SysVABIAttr(From);
  }

  public static SysVABIAttr dyn_cast_SysVABIAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static SysVABIAttr dyn_cast_or_null_SysVABIAttr(Attr/*P*/ From) {
    return (From != null) && isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static boolean isa_SysVABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SysVABIAttr.class, From.$star());
  }

  public static SysVABIAttr cast_SysVABIAttr(type$ptr<?>/*P*/ From) {
    assert isa_SysVABIAttr(From);
    return llvm.cast(SysVABIAttr.class, From.$star());
  }

  public static SysVABIAttr cast_or_null_SysVABIAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SysVABIAttr(From);
  }

  public static SysVABIAttr dyn_cast_SysVABIAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static SysVABIAttr dyn_cast_or_null_SysVABIAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static boolean isa_SysVABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SysVABIAttr.class, From.$deref());
  }

  public static SysVABIAttr cast_SysVABIAttr(type$ref<?>/*P*/ From) {
    assert isa_SysVABIAttr(From);
    return llvm.cast(SysVABIAttr.class, From.$deref());
  }

  public static SysVABIAttr cast_or_null_SysVABIAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SysVABIAttr(From);
  }

  public static SysVABIAttr dyn_cast_SysVABIAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static SysVABIAttr dyn_cast_or_null_SysVABIAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SysVABIAttr(From) ? cast_SysVABIAttr(From) : null;
  }

  public static boolean isa_TLSModelAttr(Attr/*P*/ From) {
    assert From != null;
    return TLSModelAttr.classof(From);
  }

  public static TLSModelAttr cast_TLSModelAttr(Attr/*P*/ From) {
    assert isa_TLSModelAttr(From);
    return (TLSModelAttr) From;
  }

  public static TLSModelAttr cast_or_null_TLSModelAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TLSModelAttr(From);
  }

  public static TLSModelAttr dyn_cast_TLSModelAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static TLSModelAttr dyn_cast_or_null_TLSModelAttr(Attr/*P*/ From) {
    return (From != null) && isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static boolean isa_TLSModelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TLSModelAttr.class, From.$deref());
  }

  public static TLSModelAttr cast_TLSModelAttr(type$ref<?>/*P*/ From) {
    assert isa_TLSModelAttr(From);
    return llvm.cast(TLSModelAttr.class, From.$deref());
  }

  public static TLSModelAttr cast_or_null_TLSModelAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TLSModelAttr(From);
  }

  public static TLSModelAttr dyn_cast_TLSModelAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static TLSModelAttr dyn_cast_or_null_TLSModelAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static boolean isa_TLSModelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TLSModelAttr.class, From.$star());
  }

  public static TLSModelAttr cast_TLSModelAttr(type$ptr<?>/*P*/ From) {
    assert isa_TLSModelAttr(From);
    return llvm.cast(TLSModelAttr.class, From.$star());
  }

  public static TLSModelAttr cast_or_null_TLSModelAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TLSModelAttr(From);
  }

  public static TLSModelAttr dyn_cast_TLSModelAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static TLSModelAttr dyn_cast_or_null_TLSModelAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TLSModelAttr(From) ? cast_TLSModelAttr(From) : null;
  }

  public static boolean isa_TargetAttr(Attr/*P*/ From) {
    assert From != null;
    return TargetAttr.classof(From);
  }

  public static TargetAttr cast_TargetAttr(Attr/*P*/ From) {
    assert isa_TargetAttr(From);
    return (TargetAttr) From;
  }

  public static TargetAttr cast_or_null_TargetAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TargetAttr(From);
  }

  public static TargetAttr dyn_cast_TargetAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static TargetAttr dyn_cast_or_null_TargetAttr(Attr/*P*/ From) {
    return (From != null) && isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static boolean isa_TargetAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TargetAttr.class, From.$star());
  }

  public static TargetAttr cast_TargetAttr(type$ptr<?>/*P*/ From) {
    assert isa_TargetAttr(From);
    return llvm.cast(TargetAttr.class, From.$star());
  }

  public static TargetAttr cast_or_null_TargetAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TargetAttr(From);
  }

  public static TargetAttr dyn_cast_TargetAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static TargetAttr dyn_cast_or_null_TargetAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static boolean isa_TargetAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TargetAttr.class, From.$deref());
  }

  public static TargetAttr cast_TargetAttr(type$ref<?>/*P*/ From) {
    assert isa_TargetAttr(From);
    return llvm.cast(TargetAttr.class, From.$deref());
  }

  public static TargetAttr cast_or_null_TargetAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TargetAttr(From);
  }

  public static TargetAttr dyn_cast_TargetAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static TargetAttr dyn_cast_or_null_TargetAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TargetAttr(From) ? cast_TargetAttr(From) : null;
  }

  public static boolean isa_TestTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TestTypestateAttr.class, From.$deref());
  }

  public static TestTypestateAttr cast_TestTypestateAttr(type$ref<?>/*P*/ From) {
    assert isa_TestTypestateAttr(From);
    return llvm.cast(TestTypestateAttr.class, From.$deref());
  }

  public static TestTypestateAttr cast_or_null_TestTypestateAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TestTypestateAttr(From);
  }

  public static TestTypestateAttr dyn_cast_TestTypestateAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static TestTypestateAttr dyn_cast_or_null_TestTypestateAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static boolean isa_TestTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return TestTypestateAttr.classof(From);
  }

  public static TestTypestateAttr cast_TestTypestateAttr(Attr/*P*/ From) {
    assert isa_TestTypestateAttr(From);
    return (TestTypestateAttr) From;
  }

  public static TestTypestateAttr cast_or_null_TestTypestateAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TestTypestateAttr(From);
  }

  public static TestTypestateAttr dyn_cast_TestTypestateAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static TestTypestateAttr dyn_cast_or_null_TestTypestateAttr(Attr/*P*/ From) {
    return (From != null) && isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static boolean isa_TestTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TestTypestateAttr.class, From.$star());
  }

  public static TestTypestateAttr cast_TestTypestateAttr(type$ptr<?>/*P*/ From) {
    assert isa_TestTypestateAttr(From);
    return llvm.cast(TestTypestateAttr.class, From.$star());
  }

  public static TestTypestateAttr cast_or_null_TestTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TestTypestateAttr(From);
  }

  public static TestTypestateAttr dyn_cast_TestTypestateAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static TestTypestateAttr dyn_cast_or_null_TestTypestateAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TestTypestateAttr(From) ? cast_TestTypestateAttr(From) : null;
  }

  public static boolean isa_ThisCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ThisCallAttr.class, From.$deref());
  }

  public static ThisCallAttr cast_ThisCallAttr(type$ref<?>/*P*/ From) {
    assert isa_ThisCallAttr(From);
    return llvm.cast(ThisCallAttr.class, From.$deref());
  }

  public static ThisCallAttr cast_or_null_ThisCallAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ThisCallAttr(From);
  }

  public static ThisCallAttr dyn_cast_ThisCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static ThisCallAttr dyn_cast_or_null_ThisCallAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static boolean isa_ThisCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ThisCallAttr.class, From.$star());
  }

  public static ThisCallAttr cast_ThisCallAttr(type$ptr<?>/*P*/ From) {
    assert isa_ThisCallAttr(From);
    return llvm.cast(ThisCallAttr.class, From.$star());
  }

  public static ThisCallAttr cast_or_null_ThisCallAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ThisCallAttr(From);
  }

  public static ThisCallAttr dyn_cast_ThisCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static ThisCallAttr dyn_cast_or_null_ThisCallAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static boolean isa_ThisCallAttr(Attr/*P*/ From) {
    assert From != null;
    return ThisCallAttr.classof(From);
  }

  public static ThisCallAttr cast_ThisCallAttr(Attr/*P*/ From) {
    assert isa_ThisCallAttr(From);
    return (ThisCallAttr) From;
  }

  public static ThisCallAttr cast_or_null_ThisCallAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ThisCallAttr(From);
  }

  public static ThisCallAttr dyn_cast_ThisCallAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static ThisCallAttr dyn_cast_or_null_ThisCallAttr(Attr/*P*/ From) {
    return (From != null) && isa_ThisCallAttr(From) ? cast_ThisCallAttr(From) : null;
  }

  public static boolean isa_ThreadAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ThreadAttr.class, From.$deref());
  }

  public static ThreadAttr cast_ThreadAttr(type$ref<?>/*P*/ From) {
    assert isa_ThreadAttr(From);
    return llvm.cast(ThreadAttr.class, From.$deref());
  }

  public static ThreadAttr cast_or_null_ThreadAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ThreadAttr(From);
  }

  public static ThreadAttr dyn_cast_ThreadAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static ThreadAttr dyn_cast_or_null_ThreadAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static boolean isa_ThreadAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ThreadAttr.class, From.$star());
  }

  public static ThreadAttr cast_ThreadAttr(type$ptr<?>/*P*/ From) {
    assert isa_ThreadAttr(From);
    return llvm.cast(ThreadAttr.class, From.$star());
  }

  public static ThreadAttr cast_or_null_ThreadAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ThreadAttr(From);
  }

  public static ThreadAttr dyn_cast_ThreadAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static ThreadAttr dyn_cast_or_null_ThreadAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static boolean isa_ThreadAttr(Attr/*P*/ From) {
    assert From != null;
    return ThreadAttr.classof(From);
  }

  public static ThreadAttr cast_ThreadAttr(Attr/*P*/ From) {
    assert isa_ThreadAttr(From);
    return (ThreadAttr) From;
  }

  public static ThreadAttr cast_or_null_ThreadAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_ThreadAttr(From);
  }

  public static ThreadAttr dyn_cast_ThreadAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static ThreadAttr dyn_cast_or_null_ThreadAttr(Attr/*P*/ From) {
    return (From != null) && isa_ThreadAttr(From) ? cast_ThreadAttr(From) : null;
  }

  public static boolean isa_TransparentUnionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TransparentUnionAttr.class, From.$star());
  }

  public static TransparentUnionAttr cast_TransparentUnionAttr(type$ptr<?>/*P*/ From) {
    assert isa_TransparentUnionAttr(From);
    return llvm.cast(TransparentUnionAttr.class, From.$star());
  }

  public static TransparentUnionAttr cast_or_null_TransparentUnionAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TransparentUnionAttr(From);
  }

  public static TransparentUnionAttr dyn_cast_TransparentUnionAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static TransparentUnionAttr dyn_cast_or_null_TransparentUnionAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static boolean isa_TransparentUnionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TransparentUnionAttr.class, From.$deref());
  }

  public static TransparentUnionAttr cast_TransparentUnionAttr(type$ref<?>/*P*/ From) {
    assert isa_TransparentUnionAttr(From);
    return llvm.cast(TransparentUnionAttr.class, From.$deref());
  }

  public static TransparentUnionAttr cast_or_null_TransparentUnionAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TransparentUnionAttr(From);
  }

  public static TransparentUnionAttr dyn_cast_TransparentUnionAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static TransparentUnionAttr dyn_cast_or_null_TransparentUnionAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static boolean isa_TransparentUnionAttr(Attr/*P*/ From) {
    assert From != null;
    return TransparentUnionAttr.classof(From);
  }

  public static TransparentUnionAttr cast_TransparentUnionAttr(Attr/*P*/ From) {
    assert isa_TransparentUnionAttr(From);
    return (TransparentUnionAttr) From;
  }

  public static TransparentUnionAttr cast_or_null_TransparentUnionAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TransparentUnionAttr(From);
  }

  public static TransparentUnionAttr dyn_cast_TransparentUnionAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static TransparentUnionAttr dyn_cast_or_null_TransparentUnionAttr(Attr/*P*/ From) {
    return (From != null) && isa_TransparentUnionAttr(From) ? cast_TransparentUnionAttr(From) : null;
  }

  public static boolean isa_TryAcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TryAcquireCapabilityAttr.class, From.$deref());
  }

  public static TryAcquireCapabilityAttr cast_TryAcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert isa_TryAcquireCapabilityAttr(From);
    return llvm.cast(TryAcquireCapabilityAttr.class, From.$deref());
  }

  public static TryAcquireCapabilityAttr cast_or_null_TryAcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TryAcquireCapabilityAttr(From);
  }

  public static TryAcquireCapabilityAttr dyn_cast_TryAcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static TryAcquireCapabilityAttr dyn_cast_or_null_TryAcquireCapabilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_TryAcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TryAcquireCapabilityAttr.class, From.$star());
  }

  public static TryAcquireCapabilityAttr cast_TryAcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_TryAcquireCapabilityAttr(From);
    return llvm.cast(TryAcquireCapabilityAttr.class, From.$star());
  }

  public static TryAcquireCapabilityAttr cast_or_null_TryAcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TryAcquireCapabilityAttr(From);
  }

  public static TryAcquireCapabilityAttr dyn_cast_TryAcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static TryAcquireCapabilityAttr dyn_cast_or_null_TryAcquireCapabilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_TryAcquireCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return TryAcquireCapabilityAttr.classof(From);
  }

  public static TryAcquireCapabilityAttr cast_TryAcquireCapabilityAttr(Attr/*P*/ From) {
    assert isa_TryAcquireCapabilityAttr(From);
    return (TryAcquireCapabilityAttr) From;
  }

  public static TryAcquireCapabilityAttr cast_or_null_TryAcquireCapabilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TryAcquireCapabilityAttr(From);
  }

  public static TryAcquireCapabilityAttr dyn_cast_TryAcquireCapabilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static TryAcquireCapabilityAttr dyn_cast_or_null_TryAcquireCapabilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_TryAcquireCapabilityAttr(From) ? cast_TryAcquireCapabilityAttr(From) : null;
  }

  public static boolean isa_TypeTagForDatatypeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeTagForDatatypeAttr.class, From.$deref());
  }

  public static TypeTagForDatatypeAttr cast_TypeTagForDatatypeAttr(type$ref<?>/*P*/ From) {
    assert isa_TypeTagForDatatypeAttr(From);
    return llvm.cast(TypeTagForDatatypeAttr.class, From.$deref());
  }

  public static TypeTagForDatatypeAttr cast_or_null_TypeTagForDatatypeAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeTagForDatatypeAttr(From);
  }

  public static TypeTagForDatatypeAttr dyn_cast_TypeTagForDatatypeAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static TypeTagForDatatypeAttr dyn_cast_or_null_TypeTagForDatatypeAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static boolean isa_TypeTagForDatatypeAttr(Attr/*P*/ From) {
    assert From != null;
    return TypeTagForDatatypeAttr.classof(From);
  }

  public static TypeTagForDatatypeAttr cast_TypeTagForDatatypeAttr(Attr/*P*/ From) {
    assert isa_TypeTagForDatatypeAttr(From);
    return (TypeTagForDatatypeAttr) From;
  }

  public static TypeTagForDatatypeAttr cast_or_null_TypeTagForDatatypeAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TypeTagForDatatypeAttr(From);
  }

  public static TypeTagForDatatypeAttr dyn_cast_TypeTagForDatatypeAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static TypeTagForDatatypeAttr dyn_cast_or_null_TypeTagForDatatypeAttr(Attr/*P*/ From) {
    return (From != null) && isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static boolean isa_TypeTagForDatatypeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeTagForDatatypeAttr.class, From.$star());
  }

  public static TypeTagForDatatypeAttr cast_TypeTagForDatatypeAttr(type$ptr<?>/*P*/ From) {
    assert isa_TypeTagForDatatypeAttr(From);
    return llvm.cast(TypeTagForDatatypeAttr.class, From.$star());
  }

  public static TypeTagForDatatypeAttr cast_or_null_TypeTagForDatatypeAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeTagForDatatypeAttr(From);
  }

  public static TypeTagForDatatypeAttr dyn_cast_TypeTagForDatatypeAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static TypeTagForDatatypeAttr dyn_cast_or_null_TypeTagForDatatypeAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeTagForDatatypeAttr(From) ? cast_TypeTagForDatatypeAttr(From) : null;
  }

  public static boolean isa_TypeVisibilityAttr(Attr/*P*/ From) {
    assert From != null;
    return TypeVisibilityAttr.classof(From);
  }

  public static TypeVisibilityAttr cast_TypeVisibilityAttr(Attr/*P*/ From) {
    assert isa_TypeVisibilityAttr(From);
    return (TypeVisibilityAttr) From;
  }

  public static TypeVisibilityAttr cast_or_null_TypeVisibilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_TypeVisibilityAttr(From);
  }

  public static TypeVisibilityAttr dyn_cast_TypeVisibilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static TypeVisibilityAttr dyn_cast_or_null_TypeVisibilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static boolean isa_TypeVisibilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(TypeVisibilityAttr.class, From.$star());
  }

  public static TypeVisibilityAttr cast_TypeVisibilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_TypeVisibilityAttr(From);
    return llvm.cast(TypeVisibilityAttr.class, From.$star());
  }

  public static TypeVisibilityAttr cast_or_null_TypeVisibilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_TypeVisibilityAttr(From);
  }

  public static TypeVisibilityAttr dyn_cast_TypeVisibilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static TypeVisibilityAttr dyn_cast_or_null_TypeVisibilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static boolean isa_TypeVisibilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(TypeVisibilityAttr.class, From.$deref());
  }

  public static TypeVisibilityAttr cast_TypeVisibilityAttr(type$ref<?>/*P*/ From) {
    assert isa_TypeVisibilityAttr(From);
    return llvm.cast(TypeVisibilityAttr.class, From.$deref());
  }

  public static TypeVisibilityAttr cast_or_null_TypeVisibilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_TypeVisibilityAttr(From);
  }

  public static TypeVisibilityAttr dyn_cast_TypeVisibilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static TypeVisibilityAttr dyn_cast_or_null_TypeVisibilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_TypeVisibilityAttr(From) ? cast_TypeVisibilityAttr(From) : null;
  }

  public static boolean isa_UnavailableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnavailableAttr.class, From.$star());
  }

  public static UnavailableAttr cast_UnavailableAttr(type$ptr<?>/*P*/ From) {
    assert isa_UnavailableAttr(From);
    return llvm.cast(UnavailableAttr.class, From.$star());
  }

  public static UnavailableAttr cast_or_null_UnavailableAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnavailableAttr(From);
  }

  public static UnavailableAttr dyn_cast_UnavailableAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static UnavailableAttr dyn_cast_or_null_UnavailableAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static boolean isa_UnavailableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnavailableAttr.class, From.$deref());
  }

  public static UnavailableAttr cast_UnavailableAttr(type$ref<?>/*P*/ From) {
    assert isa_UnavailableAttr(From);
    return llvm.cast(UnavailableAttr.class, From.$deref());
  }

  public static UnavailableAttr cast_or_null_UnavailableAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnavailableAttr(From);
  }

  public static UnavailableAttr dyn_cast_UnavailableAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static UnavailableAttr dyn_cast_or_null_UnavailableAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static boolean isa_UnavailableAttr(Attr/*P*/ From) {
    assert From != null;
    return UnavailableAttr.classof(From);
  }

  public static UnavailableAttr cast_UnavailableAttr(Attr/*P*/ From) {
    assert isa_UnavailableAttr(From);
    return (UnavailableAttr) From;
  }

  public static UnavailableAttr cast_or_null_UnavailableAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_UnavailableAttr(From);
  }

  public static UnavailableAttr dyn_cast_UnavailableAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static UnavailableAttr dyn_cast_or_null_UnavailableAttr(Attr/*P*/ From) {
    return (From != null) && isa_UnavailableAttr(From) ? cast_UnavailableAttr(From) : null;
  }

  public static boolean isa_UnusedAttr(Attr/*P*/ From) {
    assert From != null;
    return UnusedAttr.classof(From);
  }

  public static UnusedAttr cast_UnusedAttr(Attr/*P*/ From) {
    assert isa_UnusedAttr(From);
    return (UnusedAttr) From;
  }

  public static UnusedAttr cast_or_null_UnusedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_UnusedAttr(From);
  }

  public static UnusedAttr dyn_cast_UnusedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static UnusedAttr dyn_cast_or_null_UnusedAttr(Attr/*P*/ From) {
    return (From != null) && isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static boolean isa_UnusedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UnusedAttr.class, From.$star());
  }

  public static UnusedAttr cast_UnusedAttr(type$ptr<?>/*P*/ From) {
    assert isa_UnusedAttr(From);
    return llvm.cast(UnusedAttr.class, From.$star());
  }

  public static UnusedAttr cast_or_null_UnusedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UnusedAttr(From);
  }

  public static UnusedAttr dyn_cast_UnusedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static UnusedAttr dyn_cast_or_null_UnusedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static boolean isa_UnusedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UnusedAttr.class, From.$deref());
  }

  public static UnusedAttr cast_UnusedAttr(type$ref<?>/*P*/ From) {
    assert isa_UnusedAttr(From);
    return llvm.cast(UnusedAttr.class, From.$deref());
  }

  public static UnusedAttr cast_or_null_UnusedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UnusedAttr(From);
  }

  public static UnusedAttr dyn_cast_UnusedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static UnusedAttr dyn_cast_or_null_UnusedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UnusedAttr(From) ? cast_UnusedAttr(From) : null;
  }

  public static boolean isa_UsedAttr(Attr/*P*/ From) {
    assert From != null;
    return UsedAttr.classof(From);
  }

  public static UsedAttr cast_UsedAttr(Attr/*P*/ From) {
    assert isa_UsedAttr(From);
    return (UsedAttr) From;
  }

  public static UsedAttr cast_or_null_UsedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_UsedAttr(From);
  }

  public static UsedAttr dyn_cast_UsedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static UsedAttr dyn_cast_or_null_UsedAttr(Attr/*P*/ From) {
    return (From != null) && isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static boolean isa_UsedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UsedAttr.class, From.$star());
  }

  public static UsedAttr cast_UsedAttr(type$ptr<?>/*P*/ From) {
    assert isa_UsedAttr(From);
    return llvm.cast(UsedAttr.class, From.$star());
  }

  public static UsedAttr cast_or_null_UsedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UsedAttr(From);
  }

  public static UsedAttr dyn_cast_UsedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static UsedAttr dyn_cast_or_null_UsedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static boolean isa_UsedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UsedAttr.class, From.$deref());
  }

  public static UsedAttr cast_UsedAttr(type$ref<?>/*P*/ From) {
    assert isa_UsedAttr(From);
    return llvm.cast(UsedAttr.class, From.$deref());
  }

  public static UsedAttr cast_or_null_UsedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UsedAttr(From);
  }

  public static UsedAttr dyn_cast_UsedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static UsedAttr dyn_cast_or_null_UsedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UsedAttr(From) ? cast_UsedAttr(From) : null;
  }

  public static boolean isa_UuidAttr(Attr/*P*/ From) {
    assert From != null;
    return UuidAttr.classof(From);
  }

  public static UuidAttr cast_UuidAttr(Attr/*P*/ From) {
    assert isa_UuidAttr(From);
    return (UuidAttr) From;
  }

  public static UuidAttr cast_or_null_UuidAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_UuidAttr(From);
  }

  public static UuidAttr dyn_cast_UuidAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static UuidAttr dyn_cast_or_null_UuidAttr(Attr/*P*/ From) {
    return (From != null) && isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static boolean isa_UuidAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(UuidAttr.class, From.$star());
  }

  public static UuidAttr cast_UuidAttr(type$ptr<?>/*P*/ From) {
    assert isa_UuidAttr(From);
    return llvm.cast(UuidAttr.class, From.$star());
  }

  public static UuidAttr cast_or_null_UuidAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_UuidAttr(From);
  }

  public static UuidAttr dyn_cast_UuidAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static UuidAttr dyn_cast_or_null_UuidAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static boolean isa_UuidAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(UuidAttr.class, From.$deref());
  }

  public static UuidAttr cast_UuidAttr(type$ref<?>/*P*/ From) {
    assert isa_UuidAttr(From);
    return llvm.cast(UuidAttr.class, From.$deref());
  }

  public static UuidAttr cast_or_null_UuidAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_UuidAttr(From);
  }

  public static UuidAttr dyn_cast_UuidAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static UuidAttr dyn_cast_or_null_UuidAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_UuidAttr(From) ? cast_UuidAttr(From) : null;
  }

  public static boolean isa_VecReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return VecReturnAttr.classof(From);
  }

  public static VecReturnAttr cast_VecReturnAttr(Attr/*P*/ From) {
    assert isa_VecReturnAttr(From);
    return (VecReturnAttr) From;
  }

  public static VecReturnAttr cast_or_null_VecReturnAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_VecReturnAttr(From);
  }

  public static VecReturnAttr dyn_cast_VecReturnAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static VecReturnAttr dyn_cast_or_null_VecReturnAttr(Attr/*P*/ From) {
    return (From != null) && isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static boolean isa_VecReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VecReturnAttr.class, From.$star());
  }

  public static VecReturnAttr cast_VecReturnAttr(type$ptr<?>/*P*/ From) {
    assert isa_VecReturnAttr(From);
    return llvm.cast(VecReturnAttr.class, From.$star());
  }

  public static VecReturnAttr cast_or_null_VecReturnAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VecReturnAttr(From);
  }

  public static VecReturnAttr dyn_cast_VecReturnAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static VecReturnAttr dyn_cast_or_null_VecReturnAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static boolean isa_VecReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VecReturnAttr.class, From.$deref());
  }

  public static VecReturnAttr cast_VecReturnAttr(type$ref<?>/*P*/ From) {
    assert isa_VecReturnAttr(From);
    return llvm.cast(VecReturnAttr.class, From.$deref());
  }

  public static VecReturnAttr cast_or_null_VecReturnAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VecReturnAttr(From);
  }

  public static VecReturnAttr dyn_cast_VecReturnAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static VecReturnAttr dyn_cast_or_null_VecReturnAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VecReturnAttr(From) ? cast_VecReturnAttr(From) : null;
  }

  public static boolean isa_VecTypeHintAttr(Attr/*P*/ From) {
    assert From != null;
    return VecTypeHintAttr.classof(From);
  }

  public static VecTypeHintAttr cast_VecTypeHintAttr(Attr/*P*/ From) {
    assert isa_VecTypeHintAttr(From);
    return (VecTypeHintAttr) From;
  }

  public static VecTypeHintAttr cast_or_null_VecTypeHintAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_VecTypeHintAttr(From);
  }

  public static VecTypeHintAttr dyn_cast_VecTypeHintAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static VecTypeHintAttr dyn_cast_or_null_VecTypeHintAttr(Attr/*P*/ From) {
    return (From != null) && isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static boolean isa_VecTypeHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VecTypeHintAttr.class, From.$star());
  }

  public static VecTypeHintAttr cast_VecTypeHintAttr(type$ptr<?>/*P*/ From) {
    assert isa_VecTypeHintAttr(From);
    return llvm.cast(VecTypeHintAttr.class, From.$star());
  }

  public static VecTypeHintAttr cast_or_null_VecTypeHintAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VecTypeHintAttr(From);
  }

  public static VecTypeHintAttr dyn_cast_VecTypeHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static VecTypeHintAttr dyn_cast_or_null_VecTypeHintAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static boolean isa_VecTypeHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VecTypeHintAttr.class, From.$deref());
  }

  public static VecTypeHintAttr cast_VecTypeHintAttr(type$ref<?>/*P*/ From) {
    assert isa_VecTypeHintAttr(From);
    return llvm.cast(VecTypeHintAttr.class, From.$deref());
  }

  public static VecTypeHintAttr cast_or_null_VecTypeHintAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VecTypeHintAttr(From);
  }

  public static VecTypeHintAttr dyn_cast_VecTypeHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static VecTypeHintAttr dyn_cast_or_null_VecTypeHintAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VecTypeHintAttr(From) ? cast_VecTypeHintAttr(From) : null;
  }

  public static boolean isa_VectorCallAttr(Attr/*P*/ From) {
    assert From != null;
    return VectorCallAttr.classof(From);
  }

  public static VectorCallAttr cast_VectorCallAttr(Attr/*P*/ From) {
    assert isa_VectorCallAttr(From);
    return (VectorCallAttr) From;
  }

  public static VectorCallAttr cast_or_null_VectorCallAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_VectorCallAttr(From);
  }

  public static VectorCallAttr dyn_cast_VectorCallAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static VectorCallAttr dyn_cast_or_null_VectorCallAttr(Attr/*P*/ From) {
    return (From != null) && isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static boolean isa_VectorCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VectorCallAttr.class, From.$star());
  }

  public static VectorCallAttr cast_VectorCallAttr(type$ptr<?>/*P*/ From) {
    assert isa_VectorCallAttr(From);
    return llvm.cast(VectorCallAttr.class, From.$star());
  }

  public static VectorCallAttr cast_or_null_VectorCallAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VectorCallAttr(From);
  }

  public static VectorCallAttr dyn_cast_VectorCallAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static VectorCallAttr dyn_cast_or_null_VectorCallAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static boolean isa_VectorCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VectorCallAttr.class, From.$deref());
  }

  public static VectorCallAttr cast_VectorCallAttr(type$ref<?>/*P*/ From) {
    assert isa_VectorCallAttr(From);
    return llvm.cast(VectorCallAttr.class, From.$deref());
  }

  public static VectorCallAttr cast_or_null_VectorCallAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VectorCallAttr(From);
  }

  public static VectorCallAttr dyn_cast_VectorCallAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static VectorCallAttr dyn_cast_or_null_VectorCallAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VectorCallAttr(From) ? cast_VectorCallAttr(From) : null;
  }

  public static boolean isa_VisibilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(VisibilityAttr.class, From.$deref());
  }

  public static VisibilityAttr cast_VisibilityAttr(type$ref<?>/*P*/ From) {
    assert isa_VisibilityAttr(From);
    return llvm.cast(VisibilityAttr.class, From.$deref());
  }

  public static VisibilityAttr cast_or_null_VisibilityAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_VisibilityAttr(From);
  }

  public static VisibilityAttr dyn_cast_VisibilityAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static VisibilityAttr dyn_cast_or_null_VisibilityAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static boolean isa_VisibilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(VisibilityAttr.class, From.$star());
  }

  public static VisibilityAttr cast_VisibilityAttr(type$ptr<?>/*P*/ From) {
    assert isa_VisibilityAttr(From);
    return llvm.cast(VisibilityAttr.class, From.$star());
  }

  public static VisibilityAttr cast_or_null_VisibilityAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_VisibilityAttr(From);
  }

  public static VisibilityAttr dyn_cast_VisibilityAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static VisibilityAttr dyn_cast_or_null_VisibilityAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static boolean isa_VisibilityAttr(Attr/*P*/ From) {
    assert From != null;
    return VisibilityAttr.classof(From);
  }

  public static VisibilityAttr cast_VisibilityAttr(Attr/*P*/ From) {
    assert isa_VisibilityAttr(From);
    return (VisibilityAttr) From;
  }

  public static VisibilityAttr cast_or_null_VisibilityAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_VisibilityAttr(From);
  }

  public static VisibilityAttr dyn_cast_VisibilityAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static VisibilityAttr dyn_cast_or_null_VisibilityAttr(Attr/*P*/ From) {
    return (From != null) && isa_VisibilityAttr(From) ? cast_VisibilityAttr(From) : null;
  }

  public static boolean isa_WarnUnusedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WarnUnusedAttr.class, From.$star());
  }

  public static WarnUnusedAttr cast_WarnUnusedAttr(type$ptr<?>/*P*/ From) {
    assert isa_WarnUnusedAttr(From);
    return llvm.cast(WarnUnusedAttr.class, From.$star());
  }

  public static WarnUnusedAttr cast_or_null_WarnUnusedAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WarnUnusedAttr(From);
  }

  public static WarnUnusedAttr dyn_cast_WarnUnusedAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static WarnUnusedAttr dyn_cast_or_null_WarnUnusedAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static boolean isa_WarnUnusedAttr(Attr/*P*/ From) {
    assert From != null;
    return WarnUnusedAttr.classof(From);
  }

  public static WarnUnusedAttr cast_WarnUnusedAttr(Attr/*P*/ From) {
    assert isa_WarnUnusedAttr(From);
    return (WarnUnusedAttr) From;
  }

  public static WarnUnusedAttr cast_or_null_WarnUnusedAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WarnUnusedAttr(From);
  }

  public static WarnUnusedAttr dyn_cast_WarnUnusedAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static WarnUnusedAttr dyn_cast_or_null_WarnUnusedAttr(Attr/*P*/ From) {
    return (From != null) && isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static boolean isa_WarnUnusedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WarnUnusedAttr.class, From.$deref());
  }

  public static WarnUnusedAttr cast_WarnUnusedAttr(type$ref<?>/*P*/ From) {
    assert isa_WarnUnusedAttr(From);
    return llvm.cast(WarnUnusedAttr.class, From.$deref());
  }

  public static WarnUnusedAttr cast_or_null_WarnUnusedAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WarnUnusedAttr(From);
  }

  public static WarnUnusedAttr dyn_cast_WarnUnusedAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static WarnUnusedAttr dyn_cast_or_null_WarnUnusedAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WarnUnusedAttr(From) ? cast_WarnUnusedAttr(From) : null;
  }

  public static boolean isa_WarnUnusedResultAttr(Attr/*P*/ From) {
    assert From != null;
    return WarnUnusedResultAttr.classof(From);
  }

  public static WarnUnusedResultAttr cast_WarnUnusedResultAttr(Attr/*P*/ From) {
    assert isa_WarnUnusedResultAttr(From);
    return (WarnUnusedResultAttr) From;
  }

  public static WarnUnusedResultAttr cast_or_null_WarnUnusedResultAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WarnUnusedResultAttr(From);
  }

  public static WarnUnusedResultAttr dyn_cast_WarnUnusedResultAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static WarnUnusedResultAttr dyn_cast_or_null_WarnUnusedResultAttr(Attr/*P*/ From) {
    return (From != null) && isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static boolean isa_WarnUnusedResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WarnUnusedResultAttr.class, From.$star());
  }

  public static WarnUnusedResultAttr cast_WarnUnusedResultAttr(type$ptr<?>/*P*/ From) {
    assert isa_WarnUnusedResultAttr(From);
    return llvm.cast(WarnUnusedResultAttr.class, From.$star());
  }

  public static WarnUnusedResultAttr cast_or_null_WarnUnusedResultAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WarnUnusedResultAttr(From);
  }

  public static WarnUnusedResultAttr dyn_cast_WarnUnusedResultAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static WarnUnusedResultAttr dyn_cast_or_null_WarnUnusedResultAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static boolean isa_WarnUnusedResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WarnUnusedResultAttr.class, From.$deref());
  }

  public static WarnUnusedResultAttr cast_WarnUnusedResultAttr(type$ref<?>/*P*/ From) {
    assert isa_WarnUnusedResultAttr(From);
    return llvm.cast(WarnUnusedResultAttr.class, From.$deref());
  }

  public static WarnUnusedResultAttr cast_or_null_WarnUnusedResultAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WarnUnusedResultAttr(From);
  }

  public static WarnUnusedResultAttr dyn_cast_WarnUnusedResultAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static WarnUnusedResultAttr dyn_cast_or_null_WarnUnusedResultAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WarnUnusedResultAttr(From) ? cast_WarnUnusedResultAttr(From) : null;
  }

  public static boolean isa_WeakAttr(Attr/*P*/ From) {
    assert From != null;
    return WeakAttr.classof(From);
  }

  public static WeakAttr cast_WeakAttr(Attr/*P*/ From) {
    assert isa_WeakAttr(From);
    return (WeakAttr) From;
  }

  public static WeakAttr cast_or_null_WeakAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WeakAttr(From);
  }

  public static WeakAttr dyn_cast_WeakAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static WeakAttr dyn_cast_or_null_WeakAttr(Attr/*P*/ From) {
    return (From != null) && isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static boolean isa_WeakAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WeakAttr.class, From.$star());
  }

  public static WeakAttr cast_WeakAttr(type$ptr<?>/*P*/ From) {
    assert isa_WeakAttr(From);
    return llvm.cast(WeakAttr.class, From.$star());
  }

  public static WeakAttr cast_or_null_WeakAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WeakAttr(From);
  }

  public static WeakAttr dyn_cast_WeakAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static WeakAttr dyn_cast_or_null_WeakAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static boolean isa_WeakAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WeakAttr.class, From.$deref());
  }

  public static WeakAttr cast_WeakAttr(type$ref<?>/*P*/ From) {
    assert isa_WeakAttr(From);
    return llvm.cast(WeakAttr.class, From.$deref());
  }

  public static WeakAttr cast_or_null_WeakAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WeakAttr(From);
  }

  public static WeakAttr dyn_cast_WeakAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static WeakAttr dyn_cast_or_null_WeakAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WeakAttr(From) ? cast_WeakAttr(From) : null;
  }

  public static boolean isa_WeakImportAttr(Attr/*P*/ From) {
    assert From != null;
    return WeakImportAttr.classof(From);
  }

  public static WeakImportAttr cast_WeakImportAttr(Attr/*P*/ From) {
    assert isa_WeakImportAttr(From);
    return (WeakImportAttr) From;
  }

  public static WeakImportAttr cast_or_null_WeakImportAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WeakImportAttr(From);
  }

  public static WeakImportAttr dyn_cast_WeakImportAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static WeakImportAttr dyn_cast_or_null_WeakImportAttr(Attr/*P*/ From) {
    return (From != null) && isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static boolean isa_WeakImportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WeakImportAttr.class, From.$star());
  }

  public static WeakImportAttr cast_WeakImportAttr(type$ptr<?>/*P*/ From) {
    assert isa_WeakImportAttr(From);
    return llvm.cast(WeakImportAttr.class, From.$star());
  }

  public static WeakImportAttr cast_or_null_WeakImportAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WeakImportAttr(From);
  }

  public static WeakImportAttr dyn_cast_WeakImportAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static WeakImportAttr dyn_cast_or_null_WeakImportAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static boolean isa_WeakImportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WeakImportAttr.class, From.$deref());
  }

  public static WeakImportAttr cast_WeakImportAttr(type$ref<?>/*P*/ From) {
    assert isa_WeakImportAttr(From);
    return llvm.cast(WeakImportAttr.class, From.$deref());
  }

  public static WeakImportAttr cast_or_null_WeakImportAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WeakImportAttr(From);
  }

  public static WeakImportAttr dyn_cast_WeakImportAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static WeakImportAttr dyn_cast_or_null_WeakImportAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WeakImportAttr(From) ? cast_WeakImportAttr(From) : null;
  }

  public static boolean isa_WeakRefAttr(Attr/*P*/ From) {
    assert From != null;
    return WeakRefAttr.classof(From);
  }

  public static WeakRefAttr cast_WeakRefAttr(Attr/*P*/ From) {
    assert isa_WeakRefAttr(From);
    return (WeakRefAttr) From;
  }

  public static WeakRefAttr cast_or_null_WeakRefAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WeakRefAttr(From);
  }

  public static WeakRefAttr dyn_cast_WeakRefAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static WeakRefAttr dyn_cast_or_null_WeakRefAttr(Attr/*P*/ From) {
    return (From != null) && isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static boolean isa_WeakRefAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WeakRefAttr.class, From.$star());
  }

  public static WeakRefAttr cast_WeakRefAttr(type$ptr<?>/*P*/ From) {
    assert isa_WeakRefAttr(From);
    return llvm.cast(WeakRefAttr.class, From.$star());
  }

  public static WeakRefAttr cast_or_null_WeakRefAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WeakRefAttr(From);
  }

  public static WeakRefAttr dyn_cast_WeakRefAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static WeakRefAttr dyn_cast_or_null_WeakRefAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static boolean isa_WeakRefAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WeakRefAttr.class, From.$deref());
  }

  public static WeakRefAttr cast_WeakRefAttr(type$ref<?>/*P*/ From) {
    assert isa_WeakRefAttr(From);
    return llvm.cast(WeakRefAttr.class, From.$deref());
  }

  public static WeakRefAttr cast_or_null_WeakRefAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WeakRefAttr(From);
  }

  public static WeakRefAttr dyn_cast_WeakRefAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static WeakRefAttr dyn_cast_or_null_WeakRefAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WeakRefAttr(From) ? cast_WeakRefAttr(From) : null;
  }

  public static boolean isa_WorkGroupSizeHintAttr(Attr/*P*/ From) {
    assert From != null;
    return WorkGroupSizeHintAttr.classof(From);
  }

  public static WorkGroupSizeHintAttr cast_WorkGroupSizeHintAttr(Attr/*P*/ From) {
    assert isa_WorkGroupSizeHintAttr(From);
    return (WorkGroupSizeHintAttr) From;
  }

  public static WorkGroupSizeHintAttr cast_or_null_WorkGroupSizeHintAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_WorkGroupSizeHintAttr(From);
  }

  public static WorkGroupSizeHintAttr dyn_cast_WorkGroupSizeHintAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static WorkGroupSizeHintAttr dyn_cast_or_null_WorkGroupSizeHintAttr(Attr/*P*/ From) {
    return (From != null) && isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static boolean isa_WorkGroupSizeHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(WorkGroupSizeHintAttr.class, From.$deref());
  }

  public static WorkGroupSizeHintAttr cast_WorkGroupSizeHintAttr(type$ref<?>/*P*/ From) {
    assert isa_WorkGroupSizeHintAttr(From);
    return llvm.cast(WorkGroupSizeHintAttr.class, From.$deref());
  }

  public static WorkGroupSizeHintAttr cast_or_null_WorkGroupSizeHintAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_WorkGroupSizeHintAttr(From);
  }

  public static WorkGroupSizeHintAttr dyn_cast_WorkGroupSizeHintAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static WorkGroupSizeHintAttr dyn_cast_or_null_WorkGroupSizeHintAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static boolean isa_WorkGroupSizeHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(WorkGroupSizeHintAttr.class, From.$star());
  }

  public static WorkGroupSizeHintAttr cast_WorkGroupSizeHintAttr(type$ptr<?>/*P*/ From) {
    assert isa_WorkGroupSizeHintAttr(From);
    return llvm.cast(WorkGroupSizeHintAttr.class, From.$star());
  }

  public static WorkGroupSizeHintAttr cast_or_null_WorkGroupSizeHintAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_WorkGroupSizeHintAttr(From);
  }

  public static WorkGroupSizeHintAttr dyn_cast_WorkGroupSizeHintAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static WorkGroupSizeHintAttr dyn_cast_or_null_WorkGroupSizeHintAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_WorkGroupSizeHintAttr(From) ? cast_WorkGroupSizeHintAttr(From) : null;
  }

  public static boolean isa_X86ForceAlignArgPointerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(X86ForceAlignArgPointerAttr.class, From.$deref());
  }

  public static X86ForceAlignArgPointerAttr cast_X86ForceAlignArgPointerAttr(type$ref<?>/*P*/ From) {
    assert isa_X86ForceAlignArgPointerAttr(From);
    return llvm.cast(X86ForceAlignArgPointerAttr.class, From.$deref());
  }

  public static X86ForceAlignArgPointerAttr cast_or_null_X86ForceAlignArgPointerAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_X86ForceAlignArgPointerAttr(From);
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_X86ForceAlignArgPointerAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_or_null_X86ForceAlignArgPointerAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static boolean isa_X86ForceAlignArgPointerAttr(Attr/*P*/ From) {
    assert From != null;
    return X86ForceAlignArgPointerAttr.classof(From);
  }

  public static X86ForceAlignArgPointerAttr cast_X86ForceAlignArgPointerAttr(Attr/*P*/ From) {
    assert isa_X86ForceAlignArgPointerAttr(From);
    return (X86ForceAlignArgPointerAttr) From;
  }

  public static X86ForceAlignArgPointerAttr cast_or_null_X86ForceAlignArgPointerAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_X86ForceAlignArgPointerAttr(From);
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_X86ForceAlignArgPointerAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_or_null_X86ForceAlignArgPointerAttr(Attr/*P*/ From) {
    return (From != null) && isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static boolean isa_X86ForceAlignArgPointerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(X86ForceAlignArgPointerAttr.class, From.$star());
  }

  public static X86ForceAlignArgPointerAttr cast_X86ForceAlignArgPointerAttr(type$ptr<?>/*P*/ From) {
    assert isa_X86ForceAlignArgPointerAttr(From);
    return llvm.cast(X86ForceAlignArgPointerAttr.class, From.$star());
  }

  public static X86ForceAlignArgPointerAttr cast_or_null_X86ForceAlignArgPointerAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_X86ForceAlignArgPointerAttr(From);
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_X86ForceAlignArgPointerAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static X86ForceAlignArgPointerAttr dyn_cast_or_null_X86ForceAlignArgPointerAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_X86ForceAlignArgPointerAttr(From) ? cast_X86ForceAlignArgPointerAttr(From) : null;
  }

  public static boolean isa_XRayInstrumentAttr(Attr/*P*/ From) {
    assert From != null;
    return XRayInstrumentAttr.classof(From);
  }

  public static XRayInstrumentAttr cast_XRayInstrumentAttr(Attr/*P*/ From) {
    assert isa_XRayInstrumentAttr(From);
    return (XRayInstrumentAttr) From;
  }

  public static XRayInstrumentAttr cast_or_null_XRayInstrumentAttr(Attr/*P*/ From) {
    return (From == null) ? null : cast_XRayInstrumentAttr(From);
  }

  public static XRayInstrumentAttr dyn_cast_XRayInstrumentAttr(Attr/*P*/ From) {
    assert From != null;
    return isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }

  public static XRayInstrumentAttr dyn_cast_or_null_XRayInstrumentAttr(Attr/*P*/ From) {
    return (From != null) && isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }

  public static boolean isa_XRayInstrumentAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(XRayInstrumentAttr.class, From.$star());
  }

  public static XRayInstrumentAttr cast_XRayInstrumentAttr(type$ptr<?>/*P*/ From) {
    assert isa_XRayInstrumentAttr(From);
    return llvm.cast(XRayInstrumentAttr.class, From.$star());
  }

  public static XRayInstrumentAttr cast_or_null_XRayInstrumentAttr(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_XRayInstrumentAttr(From);
  }

  public static XRayInstrumentAttr dyn_cast_XRayInstrumentAttr(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }

  public static XRayInstrumentAttr dyn_cast_or_null_XRayInstrumentAttr(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }

  public static boolean isa_XRayInstrumentAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(XRayInstrumentAttr.class, From.$deref());
  }

  public static XRayInstrumentAttr cast_XRayInstrumentAttr(type$ref<?>/*P*/ From) {
    assert isa_XRayInstrumentAttr(From);
    return llvm.cast(XRayInstrumentAttr.class, From.$deref());
  }

  public static XRayInstrumentAttr cast_or_null_XRayInstrumentAttr(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_XRayInstrumentAttr(From);
  }

  public static XRayInstrumentAttr dyn_cast_XRayInstrumentAttr(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }

  public static XRayInstrumentAttr dyn_cast_or_null_XRayInstrumentAttr(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_XRayInstrumentAttr(From) ? cast_XRayInstrumentAttr(From) : null;
  }
}
