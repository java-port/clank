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

package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.detail.DirIterImpl;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFSDirIter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 251,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 234,
 FQN="(anonymous namespace)::RealFSDirIter", NM="_ZN12_GLOBAL__N_113RealFSDirIterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_113RealFSDirIterE")
//</editor-fold>
public class RealFSDirIter extends /*public*/ DirIterImpl implements Destructors.ClassWithDestructor, NativeCloneable<RealFSDirIter> {
  private final std.string Path;
  private final fs.directory_iterator Iter;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFSDirIter::RealFSDirIter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 238,
   FQN="(anonymous namespace)::RealFSDirIter::RealFSDirIter", NM="_ZN12_GLOBAL__N_113RealFSDirIterC1ERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_113RealFSDirIterC1ERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  public RealFSDirIter(/*const*/ Twine /*&*/ _Path, std.error_code /*&*/ EC) {
    /* : DirIterImpl(), Path(_Path.str()), Iter(Path, EC)*/ 
    //START JInit
    super();
    this.Path = _Path.str();
    this.Iter = new fs.directory_iterator(new Twine(Path), EC);
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($c$.clean(!EC.$bool() && Iter.$noteq($c$.track(new fs.directory_iterator())))) {
        fs.file_status S/*J*/= new fs.file_status();
        EC.$assignMove(Iter.$arrow().status(S));
        if (!EC.$bool()) {
          CurrentEntry.$assignMove(Status.copyWithNewName(S, new StringRef(Iter.$arrow().getPath())));
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFSDirIter::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 265,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 248,
   FQN="(anonymous namespace)::RealFSDirIter::increment", NM="_ZN12_GLOBAL__N_113RealFSDirIter9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_113RealFSDirIter9incrementEv")
  //</editor-fold>
  @Override public std.error_code increment()/* override*/ {
    std.error_code EC/*J*/= new std.error_code();
    Iter.increment(EC);
    if (EC.$bool()) {
      return EC;
    } else if (Iter.$eq(new fs.directory_iterator())) {
      CurrentEntry.$assignMove(new Status());
    } else {
      fs.file_status S/*J*/= new fs.file_status();
      EC.$assignMove(Iter.$arrow().status(S));
      CurrentEntry.$assignMove(Status.copyWithNewName(S, new StringRef(Iter.$arrow().getPath())));
    }
    return EC;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFSDirIter::~RealFSDirIter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 234,
   FQN="(anonymous namespace)::RealFSDirIter::~RealFSDirIter", NM="_ZN12_GLOBAL__N_113RealFSDirIterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_113RealFSDirIterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Iter.$destroy();
    Path.$destroy();
    super.$destroy();
    //END JDestroy
  }

  private RealFSDirIter(RealFSDirIter $Prm0) {
    super($Prm0);
    this.Iter = $tryClone($Prm0.Iter);
    this.Path = $Prm0.Path;
  }

  @Override public RealFSDirIter clone() { return new RealFSDirIter(this); }
  
  public String toString() {
    return "" + "Path=" + Path // NOI18N
              + ", Iter=" + Iter // NOI18N
              + super.toString(); // NOI18N
  }
}
