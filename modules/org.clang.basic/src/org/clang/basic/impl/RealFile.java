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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.TimeValue;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.fs.*;
import org.llvm.support.sys.Process;

/// \brief Wrapper around a raw file descriptor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 140,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 120,
 FQN="(anonymous namespace)::RealFile", NM="_ZN12_GLOBAL__N_18RealFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFileE")
//</editor-fold>
public class RealFile extends /*public*/ File implements Destructors.ClassWithDestructor {
  private int FD;
  private Status S;
  private std.string RealName;
  /*friend  class RealFileSystem*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::RealFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 145,
   FQN="(anonymous namespace)::RealFile::RealFile", NM="_ZN12_GLOBAL__N_18RealFileC1EiN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFileC1EiN4llvm9StringRefES2_")
  //</editor-fold>
  /*friend*//*private*/ RealFile(int FD, StringRef NewName, StringRef NewRealPathName) {
    /* : File(), FD(FD), S(NewName, {  }, {  }, {}, {}, {}, fs::file_type::status_error, {}), RealName(NewRealPathName.str())*/ 
    //START JInit
    super();
    this.FD = FD;
    this.S = new Status(/*NO_COPY*/NewName, /*{ */new UniqueID()/* }*/, /*{ */new TimeValue()/* }*/, ((/*uint32_t*/int)/*zero-init*/0), ((/*uint32_t*/int)/*zero-init*/0), ((long/*uint64_t*/)/*zero-init*/0), 
        fs.file_type.status_error, ((/*fs.perms*/int)/*zero-init*/0));
    this.RealName = NewRealPathName.str();
    //END JInit
    assert (FD >= 0) : "Invalid or inactive file descriptor";
  }

/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::~RealFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 163,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 140,
   FQN="(anonymous namespace)::RealFile::~RealFile", NM="_ZN12_GLOBAL__N_18RealFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFileD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    close();
    //START JDestroy
    RealName.$destroy();
    S.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 165,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 142,
   FQN="(anonymous namespace)::RealFile::status", NM="_ZN12_GLOBAL__N_18RealFile6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFile6statusEv")
  //</editor-fold>
  @Override public ErrorOr<Status> status()/* override*/ {
    assert (FD != -1) : "cannot stat closed file";
    if (!S.isStatusKnown()) {
      file_status RealStatus/*J*/= new file_status();
      {
        std.error_code EC = fs.status(FD, RealStatus);
        if (EC.$bool()) {
          return new ErrorOr<Status>(new std.error_code(EC));
        }
      }
      S.$assignMove(Status.copyWithNewName(RealStatus, S.getName()));
    }
    return new ErrorOr<Status>(JD$Convertible.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 176,
   FQN="(anonymous namespace)::RealFile::getName", NM="_ZN12_GLOBAL__N_18RealFile7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFile7getNameEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getName()/* override*/ {
    return new ErrorOr<std.string>(JD$Convertible.INSTANCE, RealName.empty() ? S.getName().str() : new std.string(RealName));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 153,
   FQN="(anonymous namespace)::RealFile::getBuffer", NM="_ZN12_GLOBAL__N_18RealFile9getBufferERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFile9getBufferERKN4llvm5TwineExbb")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize, 
           boolean RequiresNullTerminator, boolean IsVolatile)/* override*/ {
    assert (FD != -1) : "cannot get buffer for closed file";
    return MemoryBuffer.getOpenFile(FD, Name, FileSize, RequiresNullTerminator, 
        IsVolatile);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFile::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 188,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 171,
   FQN="(anonymous namespace)::RealFile::close", NM="_ZN12_GLOBAL__N_18RealFile5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_18RealFile5closeEv")
  //</editor-fold>
  @Override public std.error_code close()/* override*/ {
    std.error_code EC = Process.SafelyCloseFileDescriptor(FD);
    FD = -1;
    return EC;
  }

  
  public String toString() {
    return "" + "FD=" + FD // NOI18N
              + ", S=" + S // NOI18N
              + ", RealName=" + RealName // NOI18N
              + super.toString(); // NOI18N
  }
}
