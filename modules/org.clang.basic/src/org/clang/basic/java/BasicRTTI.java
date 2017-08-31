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
package org.clang.basic.java;

import org.clang.basic.impl.*;
import org.clang.basic.vfs.detail.impl.*;
import org.clank.support.aliases.*;
import org.llvm.support.llvm;

public class BasicRTTI {
  /*package*/BasicRTTI() {}

  public static boolean isa_Entry(Entry/*P*/ From) {
    assert From != null;
    return llvm.isa(Entry.class, From);
  }

  public static Entry cast_Entry(Entry/*P*/ From) {
    assert isa_Entry(From);
    return llvm.cast(Entry.class, From);
  }

  public static Entry cast_or_null_Entry(Entry/*P*/ From) {
    return (From == null) ? null : cast_Entry(From);
  }

  public static Entry dyn_cast_Entry(Entry/*P*/ From) {
    assert From != null;
    return isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static Entry dyn_cast_or_null_Entry(Entry/*P*/ From) {
    return (From != null) && isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static boolean isa_Entry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(Entry.class, From.$deref());
  }

  public static Entry cast_Entry(type$ref<?>/*P*/ From) {
    assert isa_Entry(From);
    return llvm.cast(Entry.class, From.$deref());
  }

  public static Entry cast_or_null_Entry(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_Entry(From);
  }

  public static Entry dyn_cast_Entry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static Entry dyn_cast_or_null_Entry(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static boolean isa_Entry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(Entry.class, From.$star());
  }

  public static Entry cast_Entry(type$ptr<?>/*P*/ From) {
    assert isa_Entry(From);
    return llvm.cast(Entry.class, From.$star());
  }

  public static Entry cast_or_null_Entry(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_Entry(From);
  }

  public static Entry dyn_cast_Entry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static Entry dyn_cast_or_null_Entry(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_Entry(From) ? cast_Entry(From) : null;
  }

  public static boolean isa_RedirectingDirectoryEntry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RedirectingDirectoryEntry.class, From.$deref());
  }

  public static RedirectingDirectoryEntry cast_RedirectingDirectoryEntry(type$ref<?>/*P*/ From) {
    assert isa_RedirectingDirectoryEntry(From);
    return llvm.cast(RedirectingDirectoryEntry.class, From.$deref());
  }

  public static RedirectingDirectoryEntry cast_or_null_RedirectingDirectoryEntry(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RedirectingDirectoryEntry(From);
  }

  public static RedirectingDirectoryEntry dyn_cast_RedirectingDirectoryEntry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static RedirectingDirectoryEntry dyn_cast_or_null_RedirectingDirectoryEntry(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static boolean isa_RedirectingDirectoryEntry(Entry/*P*/ From) {
    assert From != null;
    return llvm.isa(RedirectingDirectoryEntry.class, From);
  }

  public static RedirectingDirectoryEntry cast_RedirectingDirectoryEntry(Entry/*P*/ From) {
    assert isa_RedirectingDirectoryEntry(From);
    return llvm.cast(RedirectingDirectoryEntry.class, From);
  }

  public static RedirectingDirectoryEntry cast_or_null_RedirectingDirectoryEntry(Entry/*P*/ From) {
    return (From == null) ? null : cast_RedirectingDirectoryEntry(From);
  }

  public static RedirectingDirectoryEntry dyn_cast_RedirectingDirectoryEntry(Entry/*P*/ From) {
    assert From != null;
    return isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static RedirectingDirectoryEntry dyn_cast_or_null_RedirectingDirectoryEntry(Entry/*P*/ From) {
    return (From != null) && isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static boolean isa_RedirectingDirectoryEntry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RedirectingDirectoryEntry.class, From.$star());
  }

  public static RedirectingDirectoryEntry cast_RedirectingDirectoryEntry(type$ptr<?>/*P*/ From) {
    assert isa_RedirectingDirectoryEntry(From);
    return llvm.cast(RedirectingDirectoryEntry.class, From.$star());
  }

  public static RedirectingDirectoryEntry cast_or_null_RedirectingDirectoryEntry(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RedirectingDirectoryEntry(From);
  }

  public static RedirectingDirectoryEntry dyn_cast_RedirectingDirectoryEntry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static RedirectingDirectoryEntry dyn_cast_or_null_RedirectingDirectoryEntry(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RedirectingDirectoryEntry(From) ? cast_RedirectingDirectoryEntry(From) : null;
  }

  public static boolean isa_RedirectingFileEntry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(RedirectingFileEntry.class, From.$deref());
  }

  public static RedirectingFileEntry cast_RedirectingFileEntry(type$ref<?>/*P*/ From) {
    assert isa_RedirectingFileEntry(From);
    return llvm.cast(RedirectingFileEntry.class, From.$deref());
  }

  public static RedirectingFileEntry cast_or_null_RedirectingFileEntry(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_RedirectingFileEntry(From);
  }

  public static RedirectingFileEntry dyn_cast_RedirectingFileEntry(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static RedirectingFileEntry dyn_cast_or_null_RedirectingFileEntry(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static boolean isa_RedirectingFileEntry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(RedirectingFileEntry.class, From.$star());
  }

  public static RedirectingFileEntry cast_RedirectingFileEntry(type$ptr<?>/*P*/ From) {
    assert isa_RedirectingFileEntry(From);
    return llvm.cast(RedirectingFileEntry.class, From.$star());
  }

  public static RedirectingFileEntry cast_or_null_RedirectingFileEntry(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_RedirectingFileEntry(From);
  }

  public static RedirectingFileEntry dyn_cast_RedirectingFileEntry(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static RedirectingFileEntry dyn_cast_or_null_RedirectingFileEntry(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static boolean isa_RedirectingFileEntry(Entry/*P*/ From) {
    assert From != null;
    return llvm.isa(RedirectingFileEntry.class, From);
  }

  public static RedirectingFileEntry cast_RedirectingFileEntry(Entry/*P*/ From) {
    assert isa_RedirectingFileEntry(From);
    return llvm.cast(RedirectingFileEntry.class, From);
  }

  public static RedirectingFileEntry cast_or_null_RedirectingFileEntry(Entry/*P*/ From) {
    return (From == null) ? null : cast_RedirectingFileEntry(From);
  }

  public static RedirectingFileEntry dyn_cast_RedirectingFileEntry(Entry/*P*/ From) {
    assert From != null;
    return isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static RedirectingFileEntry dyn_cast_or_null_RedirectingFileEntry(Entry/*P*/ From) {
    return (From != null) && isa_RedirectingFileEntry(From) ? cast_RedirectingFileEntry(From) : null;
  }

  public static boolean isa_InMemoryDirectory(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InMemoryDirectory.class, From.$star());
  }

  public static InMemoryDirectory cast_InMemoryDirectory(type$ptr<?>/*P*/ From) {
    assert isa_InMemoryDirectory(From);
    return llvm.cast(InMemoryDirectory.class, From.$star());
  }

  public static InMemoryDirectory cast_or_null_InMemoryDirectory(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InMemoryDirectory(From);
  }

  public static InMemoryDirectory dyn_cast_InMemoryDirectory(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static InMemoryDirectory dyn_cast_or_null_InMemoryDirectory(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static boolean isa_InMemoryDirectory(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InMemoryDirectory.class, From.$deref());
  }

  public static InMemoryDirectory cast_InMemoryDirectory(type$ref<?>/*P*/ From) {
    assert isa_InMemoryDirectory(From);
    return llvm.cast(InMemoryDirectory.class, From.$deref());
  }

  public static InMemoryDirectory cast_or_null_InMemoryDirectory(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InMemoryDirectory(From);
  }

  public static InMemoryDirectory dyn_cast_InMemoryDirectory(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static InMemoryDirectory dyn_cast_or_null_InMemoryDirectory(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static boolean isa_InMemoryDirectory(InMemoryNode/*P*/ From) {
    assert From != null;
    return llvm.isa(InMemoryDirectory.class, From);
  }

  public static InMemoryDirectory cast_InMemoryDirectory(InMemoryNode/*P*/ From) {
    assert isa_InMemoryDirectory(From);
    return llvm.cast(InMemoryDirectory.class, From);
  }

  public static InMemoryDirectory cast_or_null_InMemoryDirectory(InMemoryNode/*P*/ From) {
    return (From == null) ? null : cast_InMemoryDirectory(From);
  }

  public static InMemoryDirectory dyn_cast_InMemoryDirectory(InMemoryNode/*P*/ From) {
    assert From != null;
    return isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static InMemoryDirectory dyn_cast_or_null_InMemoryDirectory(InMemoryNode/*P*/ From) {
    return (From != null) && isa_InMemoryDirectory(From) ? cast_InMemoryDirectory(From) : null;
  }

  public static boolean isa_InMemoryFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InMemoryFile.class, From.$star());
  }

  public static InMemoryFile cast_InMemoryFile(type$ptr<?>/*P*/ From) {
    assert isa_InMemoryFile(From);
    return llvm.cast(InMemoryFile.class, From.$star());
  }

  public static InMemoryFile cast_or_null_InMemoryFile(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InMemoryFile(From);
  }

  public static InMemoryFile dyn_cast_InMemoryFile(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static InMemoryFile dyn_cast_or_null_InMemoryFile(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static boolean isa_InMemoryFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InMemoryFile.class, From.$deref());
  }

  public static InMemoryFile cast_InMemoryFile(type$ref<?>/*P*/ From) {
    assert isa_InMemoryFile(From);
    return llvm.cast(InMemoryFile.class, From.$deref());
  }

  public static InMemoryFile cast_or_null_InMemoryFile(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InMemoryFile(From);
  }

  public static InMemoryFile dyn_cast_InMemoryFile(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static InMemoryFile dyn_cast_or_null_InMemoryFile(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static boolean isa_InMemoryFile(InMemoryNode/*P*/ From) {
    assert From != null;
    return llvm.isa(InMemoryFile.class, From);
  }

  public static InMemoryFile cast_InMemoryFile(InMemoryNode/*P*/ From) {
    assert isa_InMemoryFile(From);
    return llvm.cast(InMemoryFile.class, From);
  }

  public static InMemoryFile cast_or_null_InMemoryFile(InMemoryNode/*P*/ From) {
    return (From == null) ? null : cast_InMemoryFile(From);
  }

  public static InMemoryFile dyn_cast_InMemoryFile(InMemoryNode/*P*/ From) {
    assert From != null;
    return isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static InMemoryFile dyn_cast_or_null_InMemoryFile(InMemoryNode/*P*/ From) {
    return (From != null) && isa_InMemoryFile(From) ? cast_InMemoryFile(From) : null;
  }

  public static boolean isa_InMemoryNode(InMemoryNode/*P*/ From) {
    assert From != null;
    return llvm.isa(InMemoryNode.class, From);
  }

  public static InMemoryNode cast_InMemoryNode(InMemoryNode/*P*/ From) {
    assert isa_InMemoryNode(From);
    return llvm.cast(InMemoryNode.class, From);
  }

  public static InMemoryNode cast_or_null_InMemoryNode(InMemoryNode/*P*/ From) {
    return (From == null) ? null : cast_InMemoryNode(From);
  }

  public static InMemoryNode dyn_cast_InMemoryNode(InMemoryNode/*P*/ From) {
    assert From != null;
    return isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }

  public static InMemoryNode dyn_cast_or_null_InMemoryNode(InMemoryNode/*P*/ From) {
    return (From != null) && isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }

  public static boolean isa_InMemoryNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return llvm.isa(InMemoryNode.class, From.$star());
  }

  public static InMemoryNode cast_InMemoryNode(type$ptr<?>/*P*/ From) {
    assert isa_InMemoryNode(From);
    return llvm.cast(InMemoryNode.class, From.$star());
  }

  public static InMemoryNode cast_or_null_InMemoryNode(type$ptr<?>/*P*/ From) {
    return (From == null || From.$star() == null) ? null : cast_InMemoryNode(From);
  }

  public static InMemoryNode dyn_cast_InMemoryNode(type$ptr<?>/*P*/ From) {
    assert From != null && From.$star() != null;
    return isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }

  public static InMemoryNode dyn_cast_or_null_InMemoryNode(type$ptr<?>/*P*/ From) {
    return (From != null && From.$star() != null) && isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }

  public static boolean isa_InMemoryNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return llvm.isa(InMemoryNode.class, From.$deref());
  }

  public static InMemoryNode cast_InMemoryNode(type$ref<?>/*P*/ From) {
    assert isa_InMemoryNode(From);
    return llvm.cast(InMemoryNode.class, From.$deref());
  }

  public static InMemoryNode cast_or_null_InMemoryNode(type$ref<?>/*P*/ From) {
    return (From == null || From.$deref() == null) ? null : cast_InMemoryNode(From);
  }

  public static InMemoryNode dyn_cast_InMemoryNode(type$ref<?>/*P*/ From) {
    assert From != null && From.$deref() != null;
    return isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }

  public static InMemoryNode dyn_cast_or_null_InMemoryNode(type$ref<?>/*P*/ From) {
    return (From != null && From.$deref() != null) && isa_InMemoryNode(From) ? cast_InMemoryNode(From) : null;
  }
}
