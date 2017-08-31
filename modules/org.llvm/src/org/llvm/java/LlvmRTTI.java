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
package org.llvm.java;

import org.clank.support.aliases.*;
import org.llvm.debuginfo.*;
import org.llvm.debuginfo.dwarf.*;
import org.llvm.object.*;
import org.llvm.support.llvm;

public class LlvmRTTI {
  /*package*/LlvmRTTI() {}

  public static boolean isa_DIContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DIContext.class, From.$star());
  }

  public static DIContext cast_DIContext(type$ptr<?>/*P*/ From) {
    assert isa_DIContext(From);
    return llvm.cast(DIContext.class, From.$star());
  }

  public static DIContext cast_or_null_DIContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DIContext(From);
  }

  public static DIContext dyn_cast_DIContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static DIContext dyn_cast_or_null_DIContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static boolean isa_DIContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DIContext.class, From.$deref());
  }

  public static DIContext cast_DIContext(type$ref<?>/*P*/ From) {
    assert isa_DIContext(From);
    return llvm.cast(DIContext.class, From.$deref());
  }

  public static DIContext cast_or_null_DIContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DIContext(From);
  }

  public static DIContext dyn_cast_DIContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static DIContext dyn_cast_or_null_DIContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static boolean isa_DIContext(DIContext/*P*/ From) {
    assert From != null;
    return llvm.isa(DIContext.class, From);
  }

  public static DIContext cast_DIContext(DIContext/*P*/ From) {
    assert isa_DIContext(From);
    return llvm.cast(DIContext.class, From);
  }

  public static DIContext cast_or_null_DIContext(DIContext/*P*/ From) {
    return (From == null) ? null : cast_DIContext(From);
  }

  public static DIContext dyn_cast_DIContext(DIContext/*P*/ From) {
    assert From != null;
    return isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static DIContext dyn_cast_or_null_DIContext(DIContext/*P*/ From) {
    return (From != null) && isa_DIContext(From) ? cast_DIContext(From) : null;
  }

  public static boolean isa_DWARFContext(DIContext/*P*/ From) {
    assert From != null;
    return llvm.isa(DWARFContext.class, From);
  }

  public static DWARFContext cast_DWARFContext(DIContext/*P*/ From) {
    assert isa_DWARFContext(From);
    return llvm.cast(DWARFContext.class, From);
  }

  public static DWARFContext cast_or_null_DWARFContext(DIContext/*P*/ From) {
    return (From == null) ? null : cast_DWARFContext(From);
  }

  public static DWARFContext dyn_cast_DWARFContext(DIContext/*P*/ From) {
    assert From != null;
    return isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static DWARFContext dyn_cast_or_null_DWARFContext(DIContext/*P*/ From) {
    return (From != null) && isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static boolean isa_DWARFContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DWARFContext.class, From.$star());
  }

  public static DWARFContext cast_DWARFContext(type$ptr<?>/*P*/ From) {
    assert isa_DWARFContext(From);
    return llvm.cast(DWARFContext.class, From.$star());
  }

  public static DWARFContext cast_or_null_DWARFContext(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DWARFContext(From);
  }

  public static DWARFContext dyn_cast_DWARFContext(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static DWARFContext dyn_cast_or_null_DWARFContext(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static boolean isa_DWARFContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DWARFContext.class, From.$deref());
  }

  public static DWARFContext cast_DWARFContext(type$ref<?>/*P*/ From) {
    assert isa_DWARFContext(From);
    return llvm.cast(DWARFContext.class, From.$deref());
  }

  public static DWARFContext cast_or_null_DWARFContext(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DWARFContext(From);
  }

  public static DWARFContext dyn_cast_DWARFContext(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static DWARFContext dyn_cast_or_null_DWARFContext(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DWARFContext(From) ? cast_DWARFContext(From) : null;
  }

  public static boolean isa_DWARFContextInMemory(DIContext/*P*/ From) {
    assert From != null;
    return llvm.isa(DWARFContextInMemory.class, From);
  }

  public static DWARFContextInMemory cast_DWARFContextInMemory(DIContext/*P*/ From) {
    assert isa_DWARFContextInMemory(From);
    return llvm.cast(DWARFContextInMemory.class, From);
  }

  public static DWARFContextInMemory cast_or_null_DWARFContextInMemory(DIContext/*P*/ From) {
    return (From == null) ? null : cast_DWARFContextInMemory(From);
  }

  public static DWARFContextInMemory dyn_cast_DWARFContextInMemory(DIContext/*P*/ From) {
    assert From != null;
    return isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static DWARFContextInMemory dyn_cast_or_null_DWARFContextInMemory(DIContext/*P*/ From) {
    return (From != null) && isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static boolean isa_DWARFContextInMemory(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(DWARFContextInMemory.class, From.$star());
  }

  public static DWARFContextInMemory cast_DWARFContextInMemory(type$ptr<?>/*P*/ From) {
    assert isa_DWARFContextInMemory(From);
    return llvm.cast(DWARFContextInMemory.class, From.$star());
  }

  public static DWARFContextInMemory cast_or_null_DWARFContextInMemory(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_DWARFContextInMemory(From);
  }

  public static DWARFContextInMemory dyn_cast_DWARFContextInMemory(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static DWARFContextInMemory dyn_cast_or_null_DWARFContextInMemory(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static boolean isa_DWARFContextInMemory(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(DWARFContextInMemory.class, From.$deref());
  }

  public static DWARFContextInMemory cast_DWARFContextInMemory(type$ref<?>/*P*/ From) {
    assert isa_DWARFContextInMemory(From);
    return llvm.cast(DWARFContextInMemory.class, From.$deref());
  }

  public static DWARFContextInMemory cast_or_null_DWARFContextInMemory(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_DWARFContextInMemory(From);
  }

  public static DWARFContextInMemory dyn_cast_DWARFContextInMemory(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static DWARFContextInMemory dyn_cast_or_null_DWARFContextInMemory(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_DWARFContextInMemory(From) ? cast_DWARFContextInMemory(From) : null;
  }

  public static boolean isa_Archive(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Archive.class, From.$deref());
  }

  public static Archive cast_Archive(type$ref<?>/*P*/ From) {
    assert isa_Archive(From);
    return llvm.cast(Archive.class, From.$deref());
  }

  public static Archive cast_or_null_Archive(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Archive(From);
  }

  public static Archive dyn_cast_Archive(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static Archive dyn_cast_or_null_Archive(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static boolean isa_Archive(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(Archive.class, From);
  }

  public static Archive cast_Archive(Binary/*P*/ From) {
    assert isa_Archive(From);
    return llvm.cast(Archive.class, From);
  }

  public static Archive cast_or_null_Archive(Binary/*P*/ From) {
    return (From == null) ? null : cast_Archive(From);
  }

  public static Archive dyn_cast_Archive(Binary/*P*/ From) {
    assert From != null;
    return isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static Archive dyn_cast_or_null_Archive(Binary/*P*/ From) {
    return (From != null) && isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static boolean isa_Archive(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Archive.class, From.$star());
  }

  public static Archive cast_Archive(type$ptr<?>/*P*/ From) {
    assert isa_Archive(From);
    return llvm.cast(Archive.class, From.$star());
  }

  public static Archive cast_or_null_Archive(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Archive(From);
  }

  public static Archive dyn_cast_Archive(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static Archive dyn_cast_or_null_Archive(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Archive(From) ? cast_Archive(From) : null;
  }

  public static boolean isa_Binary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Binary.class, From.$star());
  }

  public static Binary cast_Binary(type$ptr<?>/*P*/ From) {
    assert isa_Binary(From);
    return llvm.cast(Binary.class, From.$star());
  }

  public static Binary cast_or_null_Binary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Binary(From);
  }

  public static Binary dyn_cast_Binary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static Binary dyn_cast_or_null_Binary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static boolean isa_Binary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Binary.class, From.$deref());
  }

  public static Binary cast_Binary(type$ref<?>/*P*/ From) {
    assert isa_Binary(From);
    return llvm.cast(Binary.class, From.$deref());
  }

  public static Binary cast_or_null_Binary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Binary(From);
  }

  public static Binary dyn_cast_Binary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static Binary dyn_cast_or_null_Binary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static boolean isa_Binary(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(Binary.class, From);
  }

  public static Binary cast_Binary(Binary/*P*/ From) {
    assert isa_Binary(From);
    return llvm.cast(Binary.class, From);
  }

  public static Binary cast_or_null_Binary(Binary/*P*/ From) {
    return (From == null) ? null : cast_Binary(From);
  }

  public static Binary dyn_cast_Binary(Binary/*P*/ From) {
    assert From != null;
    return isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static Binary dyn_cast_or_null_Binary(Binary/*P*/ From) {
    return (From != null) && isa_Binary(From) ? cast_Binary(From) : null;
  }

  public static boolean isa_COFFObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(COFFObjectFile.class, From.$star());
  }

  public static COFFObjectFile cast_COFFObjectFile(type$ptr<?>/*P*/ From) {
    assert isa_COFFObjectFile(From);
    return llvm.cast(COFFObjectFile.class, From.$star());
  }

  public static COFFObjectFile cast_or_null_COFFObjectFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_COFFObjectFile(From);
  }

  public static COFFObjectFile dyn_cast_COFFObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static COFFObjectFile dyn_cast_or_null_COFFObjectFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static boolean isa_COFFObjectFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(COFFObjectFile.class, From);
  }

  public static COFFObjectFile cast_COFFObjectFile(Binary/*P*/ From) {
    assert isa_COFFObjectFile(From);
    return llvm.cast(COFFObjectFile.class, From);
  }

  public static COFFObjectFile cast_or_null_COFFObjectFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_COFFObjectFile(From);
  }

  public static COFFObjectFile dyn_cast_COFFObjectFile(Binary/*P*/ From) {
    assert From != null;
    return isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static COFFObjectFile dyn_cast_or_null_COFFObjectFile(Binary/*P*/ From) {
    return (From != null) && isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static boolean isa_COFFObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(COFFObjectFile.class, From.$deref());
  }

  public static COFFObjectFile cast_COFFObjectFile(type$ref<?>/*P*/ From) {
    assert isa_COFFObjectFile(From);
    return llvm.cast(COFFObjectFile.class, From.$deref());
  }

  public static COFFObjectFile cast_or_null_COFFObjectFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_COFFObjectFile(From);
  }

  public static COFFObjectFile dyn_cast_COFFObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static COFFObjectFile dyn_cast_or_null_COFFObjectFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_COFFObjectFile(From) ? cast_COFFObjectFile(From) : null;
  }

  public static boolean isa_IRObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(IRObjectFile.class, From.$deref());
  }

  public static IRObjectFile cast_IRObjectFile(type$ref<?>/*P*/ From) {
    assert isa_IRObjectFile(From);
    return llvm.cast(IRObjectFile.class, From.$deref());
  }

  public static IRObjectFile cast_or_null_IRObjectFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_IRObjectFile(From);
  }

  public static IRObjectFile dyn_cast_IRObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static IRObjectFile dyn_cast_or_null_IRObjectFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static boolean isa_IRObjectFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(IRObjectFile.class, From);
  }

  public static IRObjectFile cast_IRObjectFile(Binary/*P*/ From) {
    assert isa_IRObjectFile(From);
    return llvm.cast(IRObjectFile.class, From);
  }

  public static IRObjectFile cast_or_null_IRObjectFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_IRObjectFile(From);
  }

  public static IRObjectFile dyn_cast_IRObjectFile(Binary/*P*/ From) {
    assert From != null;
    return isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static IRObjectFile dyn_cast_or_null_IRObjectFile(Binary/*P*/ From) {
    return (From != null) && isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static boolean isa_IRObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(IRObjectFile.class, From.$star());
  }

  public static IRObjectFile cast_IRObjectFile(type$ptr<?>/*P*/ From) {
    assert isa_IRObjectFile(From);
    return llvm.cast(IRObjectFile.class, From.$star());
  }

  public static IRObjectFile cast_or_null_IRObjectFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_IRObjectFile(From);
  }

  public static IRObjectFile dyn_cast_IRObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static IRObjectFile dyn_cast_or_null_IRObjectFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_IRObjectFile(From) ? cast_IRObjectFile(From) : null;
  }

  public static boolean isa_MachOObjectFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(MachOObjectFile.class, From);
  }

  public static MachOObjectFile cast_MachOObjectFile(Binary/*P*/ From) {
    assert isa_MachOObjectFile(From);
    return llvm.cast(MachOObjectFile.class, From);
  }

  public static MachOObjectFile cast_or_null_MachOObjectFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_MachOObjectFile(From);
  }

  public static MachOObjectFile dyn_cast_MachOObjectFile(Binary/*P*/ From) {
    assert From != null;
    return isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static MachOObjectFile dyn_cast_or_null_MachOObjectFile(Binary/*P*/ From) {
    return (From != null) && isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static boolean isa_MachOObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MachOObjectFile.class, From.$star());
  }

  public static MachOObjectFile cast_MachOObjectFile(type$ptr<?>/*P*/ From) {
    assert isa_MachOObjectFile(From);
    return llvm.cast(MachOObjectFile.class, From.$star());
  }

  public static MachOObjectFile cast_or_null_MachOObjectFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MachOObjectFile(From);
  }

  public static MachOObjectFile dyn_cast_MachOObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static MachOObjectFile dyn_cast_or_null_MachOObjectFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static boolean isa_MachOObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MachOObjectFile.class, From.$deref());
  }

  public static MachOObjectFile cast_MachOObjectFile(type$ref<?>/*P*/ From) {
    assert isa_MachOObjectFile(From);
    return llvm.cast(MachOObjectFile.class, From.$deref());
  }

  public static MachOObjectFile cast_or_null_MachOObjectFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MachOObjectFile(From);
  }

  public static MachOObjectFile dyn_cast_MachOObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static MachOObjectFile dyn_cast_or_null_MachOObjectFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MachOObjectFile(From) ? cast_MachOObjectFile(From) : null;
  }

  public static boolean isa_MachOUniversalBinary(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(MachOUniversalBinary.class, From);
  }

  public static MachOUniversalBinary cast_MachOUniversalBinary(Binary/*P*/ From) {
    assert isa_MachOUniversalBinary(From);
    return llvm.cast(MachOUniversalBinary.class, From);
  }

  public static MachOUniversalBinary cast_or_null_MachOUniversalBinary(Binary/*P*/ From) {
    return (From == null) ? null : cast_MachOUniversalBinary(From);
  }

  public static MachOUniversalBinary dyn_cast_MachOUniversalBinary(Binary/*P*/ From) {
    assert From != null;
    return isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static MachOUniversalBinary dyn_cast_or_null_MachOUniversalBinary(Binary/*P*/ From) {
    return (From != null) && isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static boolean isa_MachOUniversalBinary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(MachOUniversalBinary.class, From.$star());
  }

  public static MachOUniversalBinary cast_MachOUniversalBinary(type$ptr<?>/*P*/ From) {
    assert isa_MachOUniversalBinary(From);
    return llvm.cast(MachOUniversalBinary.class, From.$star());
  }

  public static MachOUniversalBinary cast_or_null_MachOUniversalBinary(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_MachOUniversalBinary(From);
  }

  public static MachOUniversalBinary dyn_cast_MachOUniversalBinary(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static MachOUniversalBinary dyn_cast_or_null_MachOUniversalBinary(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static boolean isa_MachOUniversalBinary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(MachOUniversalBinary.class, From.$deref());
  }

  public static MachOUniversalBinary cast_MachOUniversalBinary(type$ref<?>/*P*/ From) {
    assert isa_MachOUniversalBinary(From);
    return llvm.cast(MachOUniversalBinary.class, From.$deref());
  }

  public static MachOUniversalBinary cast_or_null_MachOUniversalBinary(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_MachOUniversalBinary(From);
  }

  public static MachOUniversalBinary dyn_cast_MachOUniversalBinary(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static MachOUniversalBinary dyn_cast_or_null_MachOUniversalBinary(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_MachOUniversalBinary(From) ? cast_MachOUniversalBinary(From) : null;
  }

  public static boolean isa_ModuleSummaryIndexObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ModuleSummaryIndexObjectFile.class, From.$deref());
  }

  public static ModuleSummaryIndexObjectFile cast_ModuleSummaryIndexObjectFile(type$ref<?>/*P*/ From) {
    assert isa_ModuleSummaryIndexObjectFile(From);
    return llvm.cast(ModuleSummaryIndexObjectFile.class, From.$deref());
  }

  public static ModuleSummaryIndexObjectFile cast_or_null_ModuleSummaryIndexObjectFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ModuleSummaryIndexObjectFile(From);
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_ModuleSummaryIndexObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_or_null_ModuleSummaryIndexObjectFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static boolean isa_ModuleSummaryIndexObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ModuleSummaryIndexObjectFile.class, From.$star());
  }

  public static ModuleSummaryIndexObjectFile cast_ModuleSummaryIndexObjectFile(type$ptr<?>/*P*/ From) {
    assert isa_ModuleSummaryIndexObjectFile(From);
    return llvm.cast(ModuleSummaryIndexObjectFile.class, From.$star());
  }

  public static ModuleSummaryIndexObjectFile cast_or_null_ModuleSummaryIndexObjectFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ModuleSummaryIndexObjectFile(From);
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_ModuleSummaryIndexObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_or_null_ModuleSummaryIndexObjectFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static boolean isa_ModuleSummaryIndexObjectFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(ModuleSummaryIndexObjectFile.class, From);
  }

  public static ModuleSummaryIndexObjectFile cast_ModuleSummaryIndexObjectFile(Binary/*P*/ From) {
    assert isa_ModuleSummaryIndexObjectFile(From);
    return llvm.cast(ModuleSummaryIndexObjectFile.class, From);
  }

  public static ModuleSummaryIndexObjectFile cast_or_null_ModuleSummaryIndexObjectFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_ModuleSummaryIndexObjectFile(From);
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_ModuleSummaryIndexObjectFile(Binary/*P*/ From) {
    assert From != null;
    return isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static ModuleSummaryIndexObjectFile dyn_cast_or_null_ModuleSummaryIndexObjectFile(Binary/*P*/ From) {
    return (From != null) && isa_ModuleSummaryIndexObjectFile(From) ? cast_ModuleSummaryIndexObjectFile(From) : null;
  }

  public static boolean isa_ObjectFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(ObjectFile.class, From);
  }

  public static ObjectFile cast_ObjectFile(Binary/*P*/ From) {
    assert isa_ObjectFile(From);
    return llvm.cast(ObjectFile.class, From);
  }

  public static ObjectFile cast_or_null_ObjectFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_ObjectFile(From);
  }

  public static ObjectFile dyn_cast_ObjectFile(Binary/*P*/ From) {
    assert From != null;
    return isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static ObjectFile dyn_cast_or_null_ObjectFile(Binary/*P*/ From) {
    return (From != null) && isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static boolean isa_ObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(ObjectFile.class, From.$deref());
  }

  public static ObjectFile cast_ObjectFile(type$ref<?>/*P*/ From) {
    assert isa_ObjectFile(From);
    return llvm.cast(ObjectFile.class, From.$deref());
  }

  public static ObjectFile cast_or_null_ObjectFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_ObjectFile(From);
  }

  public static ObjectFile dyn_cast_ObjectFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static ObjectFile dyn_cast_or_null_ObjectFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static boolean isa_ObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(ObjectFile.class, From.$star());
  }

  public static ObjectFile cast_ObjectFile(type$ptr<?>/*P*/ From) {
    assert isa_ObjectFile(From);
    return llvm.cast(ObjectFile.class, From.$star());
  }

  public static ObjectFile cast_or_null_ObjectFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_ObjectFile(From);
  }

  public static ObjectFile dyn_cast_ObjectFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static ObjectFile dyn_cast_or_null_ObjectFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_ObjectFile(From) ? cast_ObjectFile(From) : null;
  }

  public static boolean isa_SymbolicFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(SymbolicFile.class, From.$star());
  }

  public static SymbolicFile cast_SymbolicFile(type$ptr<?>/*P*/ From) {
    assert isa_SymbolicFile(From);
    return llvm.cast(SymbolicFile.class, From.$star());
  }

  public static SymbolicFile cast_or_null_SymbolicFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_SymbolicFile(From);
  }

  public static SymbolicFile dyn_cast_SymbolicFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }

  public static SymbolicFile dyn_cast_or_null_SymbolicFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }

  public static boolean isa_SymbolicFile(Binary/*P*/ From) {
    assert From != null;
    return llvm.isa(SymbolicFile.class, From);
  }

  public static SymbolicFile cast_SymbolicFile(Binary/*P*/ From) {
    assert isa_SymbolicFile(From);
    return llvm.cast(SymbolicFile.class, From);
  }

  public static SymbolicFile cast_or_null_SymbolicFile(Binary/*P*/ From) {
    return (From == null) ? null : cast_SymbolicFile(From);
  }

  public static SymbolicFile dyn_cast_SymbolicFile(Binary/*P*/ From) {
    assert From != null;
    return isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }

  public static SymbolicFile dyn_cast_or_null_SymbolicFile(Binary/*P*/ From) {
    return (From != null) && isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }

  public static boolean isa_SymbolicFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(SymbolicFile.class, From.$deref());
  }

  public static SymbolicFile cast_SymbolicFile(type$ref<?>/*P*/ From) {
    assert isa_SymbolicFile(From);
    return llvm.cast(SymbolicFile.class, From.$deref());
  }

  public static SymbolicFile cast_or_null_SymbolicFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_SymbolicFile(From);
  }

  public static SymbolicFile dyn_cast_SymbolicFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }

  public static SymbolicFile dyn_cast_or_null_SymbolicFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_SymbolicFile(From) ? cast_SymbolicFile(From) : null;
  }
}
