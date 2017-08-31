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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;

/// A simple registry entry which provides only a name, description, and
/// no-argument constructor.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SimpleRegistryEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 26,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 25,
 FQN="llvm::SimpleRegistryEntry", NM="_ZN4llvm19SimpleRegistryEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm19SimpleRegistryEntryE")
//</editor-fold>
public class SimpleRegistryEntry</*typename*/ T>  implements Native.NativeComparable<SimpleRegistryEntry<T>> {
  private /*const*/char$ptr/*char P*/ Name;
  private /*const*/char$ptr/*char P*/ Desc;
  private UniquePtrConstructorCallback<T> Ctor;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleRegistryEntry::SimpleRegistryEntry<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 32,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 31,
   FQN="llvm::SimpleRegistryEntry::SimpleRegistryEntry<T>", NM="_ZN4llvm19SimpleRegistryEntryC1EPKcS2_PFSt10unique_ptrIT_St14default_deleteIS4_EEvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm19SimpleRegistryEntryC1EPKcS2_PFSt10unique_ptrIT_St14default_deleteIS4_EEvE")
  //</editor-fold>
  public SimpleRegistryEntry(/*const*/char$ptr/*char P*/ N, /*const*/char$ptr/*char P*/ D, UniquePtrConstructorCallback<T> C) {
    /* : Name(N), Desc(D), Ctor(C)*/ 
    //START JInit
    this.Name = $tryClone(N);
    this.Desc = $tryClone(D);
    this.Ctor = /*ParenListExpr*/C;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleRegistryEntry::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 36,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 35,
   FQN="llvm::SimpleRegistryEntry::getName", NM="_ZNK4llvm19SimpleRegistryEntry7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm19SimpleRegistryEntry7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return Name;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleRegistryEntry::getDesc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 36,
   FQN="llvm::SimpleRegistryEntry::getDesc", NM="_ZNK4llvm19SimpleRegistryEntry7getDescEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm19SimpleRegistryEntry7getDescEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDesc() /*const*/ {
    return Desc;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleRegistryEntry::instantiate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 38,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 37,
   FQN="llvm::SimpleRegistryEntry::instantiate", NM="_ZNK4llvm19SimpleRegistryEntry11instantiateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm19SimpleRegistryEntry11instantiateEv")
  //</editor-fold>
  public std.unique_ptr<T> instantiate() /*const*/ {
    return Ctor.$call();
  }

  
  public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Desc=" + Desc // NOI18N
              + ", Ctor=" + Ctor; // NOI18N
  }

  @Override
  public boolean $eq(SimpleRegistryEntry<T> other) {
    return strcmp(this.Name, other.Name) == 0 && 
            strcmp(this.Desc, other.Desc) == 0;
  }
}
