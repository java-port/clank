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

package org.clang.basic.vfs;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clank.support.Native.NativePOD;

//<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 331,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 316,
 FQN="clang::vfs::YAMLVFSEntry", NM="_ZN5clang3vfs12YAMLVFSEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12YAMLVFSEntryE")
//</editor-fold>
public class/*struct*/ YAMLVFSEntry implements Destructors.ClassWithDestructor, NativePOD<YAMLVFSEntry>, NativeMoveable<YAMLVFSEntry> {
  /*template <typename T1, typename T2> TEMPLATE*/
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final YAMLVFSEntry EMPTY = new YAMLVFSEntry(std.string.EMPTY, std.string.EMPTY);
  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSEntry::YAMLVFSEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 317,
   FQN="clang::vfs::YAMLVFSEntry::YAMLVFSEntry", NM="Tpl__ZN5clang3vfs12YAMLVFSEntryC1EOT_OT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=Tpl__ZN5clang3vfs12YAMLVFSEntryC1EOT_OT0_")
  //</editor-fold>
  public </*typename*/ T1, /*typename*/ T2> YAMLVFSEntry(T1 /*&&*/VPath, T2 /*&&*/RPath) {
    /* : VPath(std::forward<T1>(VPath)), RPath(std::forward<T2>(RPath))*/ 
    //START JInit
    this.VPath = $makeString(VPath);
    this.RPath = $makeString(RPath);
    //END JInit
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private static std.string $makeString(Object From) {
    if (From instanceof char$iterator) {
      return new std.string((char$iterator) From, std.strlen((char$iterator) From));
    } else if (From instanceof std.string) {
      return new std.string((std.string) From);
    } else if (From instanceof StringRef) {
      return ((StringRef) From).$string();
    } else if (From instanceof SmallString) {
      return ((SmallString) From).$StringRef().$string();
    } else if (From instanceof CharSequence) {
      return new std.string((CharSequence) From);
    }
    throw new IllegalArgumentException("Unknown string class: " + From.getClass().getSimpleName());
  }

  public std.string VPath;
  public std.string RPath;
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSEntry::YAMLVFSEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 331,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 316,
   FQN="clang::vfs::YAMLVFSEntry::YAMLVFSEntry", NM="_ZN5clang3vfs12YAMLVFSEntryC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12YAMLVFSEntryC1EOS1_")
  //</editor-fold>
  public /*inline*/ YAMLVFSEntry(JD$Move _dparam, YAMLVFSEntry /*&&*/$Prm0) {
    assert $Prm0 != EMPTY;
    /* : VPath(static_cast<YAMLVFSEntry &&>().VPath), RPath(static_cast<YAMLVFSEntry &&>().RPath)*/ 
    //START JInit
    this.VPath = new std.string(JD$Move.INSTANCE, $Prm0.VPath);
    this.RPath = new std.string(JD$Move.INSTANCE, $Prm0.RPath);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSEntry::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 331,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 316,
   FQN="clang::vfs::YAMLVFSEntry::operator=", NM="_ZN5clang3vfs12YAMLVFSEntryaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12YAMLVFSEntryaSEOS1_")
  //</editor-fold>
  public /*inline*/ YAMLVFSEntry /*&*/ $assignMove(YAMLVFSEntry /*&&*/$Prm0) {
    assert this != EMPTY;
    this.VPath.$assignMove($Prm0.VPath);
    this.RPath.$assignMove($Prm0.RPath);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSEntry::~YAMLVFSEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 331,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 316,
   FQN="clang::vfs::YAMLVFSEntry::~YAMLVFSEntry", NM="_ZN5clang3vfs12YAMLVFSEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12YAMLVFSEntryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    assert this != EMPTY;
    //START JDestroy
    RPath.$destroy();
    VPath.$destroy();
    //END JDestroy
  }

  public /*inline*/ YAMLVFSEntry /*&*/ $assign(YAMLVFSEntry /*&&*/$Prm0) {
    assert this != EMPTY;
    this.VPath.$assign($Prm0.VPath);
    this.RPath.$assign($Prm0.RPath);
    return /*Deref*/this;
  }
  
  @Override public YAMLVFSEntry clone() {
    return new YAMLVFSEntry(this.VPath, this.RPath);
  }
  
  @Override public YAMLVFSEntry move() {
    return new YAMLVFSEntry(JD$Move.INSTANCE, this);
  }
  
  
  public String toString() {
    return "" + "VPath=" + VPath // NOI18N
              + ", RPath=" + RPath; // NOI18N
  }
}
