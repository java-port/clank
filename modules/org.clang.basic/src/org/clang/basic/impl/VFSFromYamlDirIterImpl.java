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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.detail.DirIterImpl;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFSFromYamlDirIterImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 771,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 747,
 FQN="(anonymous namespace)::VFSFromYamlDirIterImpl", NM="_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplE")
//</editor-fold>
public class VFSFromYamlDirIterImpl extends /*public*/ DirIterImpl implements Destructors.ClassWithDestructor, NativeCloneable<VFSFromYamlDirIterImpl> {
  private final std.string Dir;
  private final RedirectingFileSystem /*&*/ FS;
  private final std.vector.iterator<unique_ptr<Entry>> Current;
  private final std.vector.iterator<unique_ptr<Entry>> End;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFSFromYamlDirIterImpl::VFSFromYamlDirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1754,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1513,
   FQN="(anonymous namespace)::VFSFromYamlDirIterImpl::VFSFromYamlDirIterImpl", NM="_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplC1ERKN4llvm5TwineERNS_21RedirectingFileSystemEN9__gnu_cxx17__normal_iteratorIPSt10unique_ptrINS_5EntryESt14default_deleteISA_EESt6vectorISD_SaISD_EEEESI_RSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplC1ERKN4llvm5TwineERNS_21RedirectingFileSystemEN9__gnu_cxx17__normal_iteratorIPSt10unique_ptrINS_5EntryESt14default_deleteISA_EESt6vectorISD_SaISD_EEEESI_RSt10error_code")
  //</editor-fold>
  public VFSFromYamlDirIterImpl(/*const*/ Twine /*&*/ _Path, RedirectingFileSystem /*&*/ FS, 
      std.vector.iterator<unique_ptr<Entry>> Begin, 
      std.vector.iterator<unique_ptr<Entry>> End, std.error_code /*&*/ EC) {
    /* : DirIterImpl(), Dir(_Path.str()), FS(FS), Current(Begin), End(End)*/ 
    //START JInit
    super();
    this.Dir = _Path.str();
    this./*&*/FS=/*&*/FS;
    this.Current = new std.vector.iterator<unique_ptr<Entry>>(Begin);
    this.End = new std.vector.iterator<unique_ptr<Entry>>(End);
    //END JInit
    if ($noteq___normal_iterator$C(Current, End)) {
      SmallString/*128*/ PathStr/*J*/= new SmallString/*128*/(128, new StringRef(Dir));
      path.append(PathStr, new Twine((Current.$star()).$arrow().getName()));
      ErrorOr<Status> S = FS.status(new Twine(PathStr));
      if (S.$bool()) {
        CurrentEntry.$assign(S.$star());
      } else {
        EC.$assignMove(S.getError());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFSFromYamlDirIterImpl::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1770,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1529,
   FQN="(anonymous namespace)::VFSFromYamlDirIterImpl::increment", NM="_ZN12_GLOBAL__N_122VFSFromYamlDirIterImpl9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_122VFSFromYamlDirIterImpl9incrementEv")
  //</editor-fold>
  @Override public std.error_code increment()/* override*/ {
    assert ($noteq___normal_iterator$C(Current, End)) : "cannot iterate past end";
    if ($noteq___normal_iterator$C(Current.$preInc(), End)) {
      SmallString/*128*/ PathStr/*J*/= new SmallString/*128*/(128, new StringRef(Dir));
      path.append(PathStr, new Twine((Current.$star()).$arrow().getName()));
      ErrorOr<Status> S = FS.status(new Twine(PathStr));
      if (!S.$bool()) {
        return S.getError();
      }
      CurrentEntry.$assign(S.$star());
    } else {
      CurrentEntry.$assignMove(new Status());
    }
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFSFromYamlDirIterImpl::~VFSFromYamlDirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 771,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 747,
   FQN="(anonymous namespace)::VFSFromYamlDirIterImpl::~VFSFromYamlDirIterImpl", NM="_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_122VFSFromYamlDirIterImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Dir.$destroy();
    super.$destroy();
    //END JDestroy
  }

  private VFSFromYamlDirIterImpl(VFSFromYamlDirIterImpl $Prm0) {
    super($Prm0);
    this.FS = $Prm0.FS;
    this.Dir = $Prm0.Dir;
    this.End = $Prm0.End;
    this.Current = $tryClone($Prm0.Current);
  }

  @Override public VFSFromYamlDirIterImpl clone() { return new VFSFromYamlDirIterImpl(this); }
  
  public String toString() {
    return "" + "Dir=" + Dir // NOI18N
              + ", FS=" + FS // NOI18N
              + ", Current=" + Current // NOI18N
              + ", End=" + End // NOI18N
              + super.toString(); // NOI18N
  }
}
