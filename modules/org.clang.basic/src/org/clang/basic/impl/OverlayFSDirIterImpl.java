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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.detail.DirIterImpl;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 338,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 321,
 FQN="(anonymous namespace)::OverlayFSDirIterImpl", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImplE")
//</editor-fold>
public class OverlayFSDirIterImpl extends /*public*/ DirIterImpl implements Destructors.ClassWithDestructor {
  private final OverlayFileSystem /*&*/ Overlays;
  private final std.string Path;
  private final std.reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem>> CurrentFS;
  private final directory_iterator CurrentDirIter;
  private final StringSet/*<MallocAllocator>*/ SeenNames;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::incrementFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 345,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 328,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::incrementFS", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImpl11incrementFSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImpl11incrementFSEv")
  //</editor-fold>
  private std.error_code incrementFS() {
    assert ($noteq_reverse_iterator$C(CurrentFS, Overlays.overlays_end())) : "incrementing past end";
    CurrentFS.$preInc();
    for (reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem> /*P*/ > E = Overlays.overlays_end(); $noteq_reverse_iterator$C(CurrentFS, E); CurrentFS.$preInc()) {
      std.error_code EC/*J*/= new std.error_code();
      CurrentDirIter.$assignMove((CurrentFS.$star()).$arrow().dir_begin(new Twine(Path), EC));
      if (EC.$bool() && $noteq_error_code(EC, new error_code(errc.no_such_file_or_directory))) {
        return EC;
      }
      if (CurrentDirIter.$noteq(new directory_iterator())) {
        break; // found
      }
    }
    return new std.error_code();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::incrementDirIter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 342,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::incrementDirIter", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImpl16incrementDirIterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImpl16incrementDirIterEb")
  //</editor-fold>
  private std.error_code incrementDirIter(boolean IsFirstTime) {
    assert ((IsFirstTime || CurrentDirIter.$noteq(new directory_iterator()))) : "incrementing past end";
    std.error_code EC/*J*/= new std.error_code();
    if (!IsFirstTime) {
      CurrentDirIter.increment(EC);
    }
    if (!EC.$bool() && CurrentDirIter.$eq(new directory_iterator())) {
      EC.$assignMove(incrementFS());
    }
    return EC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::incrementImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 370,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 353,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::incrementImpl", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImpl13incrementImplEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImpl13incrementImplEb")
  //</editor-fold>
  private std.error_code incrementImpl(boolean IsFirstTime) {
    while (true) {
      std.error_code EC = incrementDirIter(IsFirstTime);
      if (EC.$bool() || CurrentDirIter.$eq(new directory_iterator())) {
        CurrentEntry.$assignMove(new Status());
        return EC;
      }
      CurrentEntry.$assign(CurrentDirIter.$star());
      StringRef Name = org.llvm.support.sys.path.filename(CurrentEntry.getName());
      if (SeenNames.insert(/*NO_COPY*/Name).second) {
        return EC; // name not seen before
      }
    }
    //throw new llvm_unreachable("returned above");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::OverlayFSDirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 386,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 369,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::OverlayFSDirIterImpl", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImplC1ERKN4llvm5TwineERN5clang3vfs17OverlayFileSystemERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImplC1ERKN4llvm5TwineERN5clang3vfs17OverlayFileSystemERSt10error_code")
  //</editor-fold>
  public OverlayFSDirIterImpl(/*const*/ Twine /*&*/ Path, OverlayFileSystem /*&*/ FS, 
      std.error_code /*&*/ EC) {
    /* : DirIterImpl(), Overlays(FS), Path(Path.str()), CurrentFS(Overlays.overlays_begin()), CurrentDirIter(), SeenNames()*/ 
    //START JInit
    super();
    this./*&*/Overlays=/*&*/FS;
    this.Path = Path.str();
    this.CurrentFS = Overlays.overlays_begin();
    this.CurrentDirIter = new directory_iterator();
    this.SeenNames = new StringSet/*<MallocAllocator>*/();
    //END JInit
    CurrentDirIter.$assignMove((CurrentFS.$star()).$arrow().dir_begin(Path, EC));
    EC.$assignMove(incrementImpl(true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 376,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::increment", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImpl9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImpl9incrementEv")
  //</editor-fold>
  @Override public std.error_code increment()/* override*/ {
    return incrementImpl(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverlayFSDirIterImpl::~OverlayFSDirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 321,
   FQN="(anonymous namespace)::OverlayFSDirIterImpl::~OverlayFSDirIterImpl", NM="_ZN12_GLOBAL__N_120OverlayFSDirIterImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120OverlayFSDirIterImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    SeenNames.$destroy();
    CurrentDirIter.$destroy();
    Path.$destroy();
    super.$destroy();
    //END JDestroy
  }

  private OverlayFSDirIterImpl(OverlayFSDirIterImpl $Prm0) {
    super($Prm0);
    this.Overlays = $Prm0.Overlays;
    this.Path = $Prm0.Path;
    this.CurrentFS = $tryClone($Prm0.CurrentFS);
    this.CurrentDirIter = $tryClone($Prm0.CurrentDirIter);
    this.SeenNames = $tryClone($Prm0.SeenNames);
  }

  @Override public DirIterImpl clone() { return new OverlayFSDirIterImpl(this); }
  
  public String toString() {
    return "" + "Overlays=" + Overlays // NOI18N
              + ", Path=" + Path // NOI18N
              + ", CurrentFS=" + CurrentFS // NOI18N
              + ", CurrentDirIter=" + CurrentDirIter // NOI18N
              + ", SeenNames=" + SeenNames // NOI18N
              + super.toString(); // NOI18N
  }
}
