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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import static org.clank.support.Casts.toCharSequence;
import static org.clank.support.Native.$tryClone;


/// \brief Cached information about one directory (either on disk or in
/// the virtual file system).
//<editor-fold defaultstate="collapsed" desc="clang::DirectoryEntry">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 40,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 48,
 FQN = "clang::DirectoryEntry", NM = "_ZN5clang14DirectoryEntryE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang14DirectoryEntryE")
//</editor-fold>
public final class DirectoryEntry implements Native.NativePOD<DirectoryEntry> {
  
  /*const*/char$ptr/*char P*/ Name; // Name of the directory.
  /*JAVA PERF:*/int NameLen; // Cache Name Length of the directory.
  /*friend  class FileManager*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryEntry::DirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 44,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 52,
   FQN = "clang::DirectoryEntry::DirectoryEntry", NM = "_ZN5clang14DirectoryEntryC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang14DirectoryEntryC1Ev")
  //</editor-fold>
  public DirectoryEntry() {
    /* : Name(0)*/ 
    //START JInit
    this.Name = null;    
    //END JInit
    this.NameLen = 0;/*JAVA PERF:*/
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryEntry::getName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 53,
   FQN = "clang::DirectoryEntry::getName", NM = "_ZNK5clang14DirectoryEntry7getNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang14DirectoryEntry7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    assert Name == null || std.strlen(Name) == NameLen : NameLen + " vs. " + std.strlen(Name);
    return Name;
  }

  /*JAVA PERF:*/
  public /*const*/int getNameLen() /*const*/ {
    assert Name == null || std.strlen(Name) == NameLen : NameLen + " vs. " + std.strlen(Name);
    return NameLen;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryEntry::DirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 40,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 48,
   FQN = "clang::DirectoryEntry::DirectoryEntry", NM = "_ZN5clang14DirectoryEntryC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang14DirectoryEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DirectoryEntry(/*const*/DirectoryEntry /*&*/ $Prm0)/* throw()*/ {
    /* : Name(.Name)*/ 
    //START JInit
    this.Name = $tryClone($Prm0.Name);
    //END JInit
    this.NameLen = $Prm0.NameLen;/*JAVA PERF:*/
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryEntry::DirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 40,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 48,
   FQN="clang::DirectoryEntry::DirectoryEntry", NM="_ZN5clang14DirectoryEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang14DirectoryEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ DirectoryEntry(JD$Move _dparam, DirectoryEntry /*&&*/$Prm0) {
    /* : Name(static_cast<DirectoryEntry &&>().Name)*/ 
    //START JInit
    this.Name = $tryClone($Prm0.Name);
    //END JInit
  }

  @Override
  public DirectoryEntry $assign(DirectoryEntry value) {
    this.Name = $tryClone(value.Name);
    this.NameLen = value.NameLen;/*JAVA PERF:*/
//    if (!(this.Name instanceof Native.assignable)) {
//    } else {
//      ((Native.assignable)this.Name).$assign(value.Name);
//    }
    return this;
  }

  @Override
  public DirectoryEntry clone() {
    return new DirectoryEntry(this);
  }

  @Override
  public boolean $noteq(DirectoryEntry other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(DirectoryEntry other) {
    return (other != null) && (this.NameLen == other.NameLen) && Native.$eq_ptr(this.Name, other.Name);
  }

  @Override
  public String toString() {
    return "DirectoryEntry{" + "Name=" + toCharSequence(Name, NameLen) + '}';
  } 
}
