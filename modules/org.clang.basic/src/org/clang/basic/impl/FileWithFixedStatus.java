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

/// Provide a file wrapper with an overriden status.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1536,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1319,
 FQN="(anonymous namespace)::FileWithFixedStatus", NM="_ZN12_GLOBAL__N_119FileWithFixedStatusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatusE")
//</editor-fold>
public class FileWithFixedStatus extends /*public*/ File implements Destructors.ClassWithDestructor {
  private std.unique_ptr<File> InnerFile;
  private Status S;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus::FileWithFixedStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1541,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1324,
   FQN="(anonymous namespace)::FileWithFixedStatus::FileWithFixedStatus", NM="_ZN12_GLOBAL__N_119FileWithFixedStatusC1ESt10unique_ptrIN5clang3vfs4FileESt14default_deleteIS4_EENS3_6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatusC1ESt10unique_ptrIN5clang3vfs4FileESt14default_deleteIS4_EENS3_6StatusE")
  //</editor-fold>
  public FileWithFixedStatus(std.unique_ptr<File> InnerFile, Status S) {
    /* : File(), InnerFile(std::move(InnerFile)), S(std::move(S))*/ 
    //START JInit
    super();
    this.InnerFile = new std.unique_ptr<File>(JD$Move.INSTANCE, std.move(InnerFile));
    this.S = new Status(JD$Move.INSTANCE, std.move(S));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1544,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1327,
   FQN="(anonymous namespace)::FileWithFixedStatus::status", NM="_ZN12_GLOBAL__N_119FileWithFixedStatus6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatus6statusEv")
  //</editor-fold>
  @Override public ErrorOr<Status> status()/* override*/ {
    return new ErrorOr<Status>(JD$Convertible.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1545,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1328,
   FQN="(anonymous namespace)::FileWithFixedStatus::getBuffer", NM="_ZN12_GLOBAL__N_119FileWithFixedStatus9getBufferERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatus9getBufferERKN4llvm5TwineExbb")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize, boolean RequiresNullTerminator, 
           boolean IsVolatile)/* override*/ {
    return InnerFile.$arrow().getBuffer(Name, FileSize, RequiresNullTerminator, 
        IsVolatile);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1551,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1334,
   FQN="(anonymous namespace)::FileWithFixedStatus::close", NM="_ZN12_GLOBAL__N_119FileWithFixedStatus5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatus5closeEv")
  //</editor-fold>
  @Override public std.error_code close()/* override*/ {
    return InnerFile.$arrow().close();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileWithFixedStatus::~FileWithFixedStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1536,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1319,
   FQN="(anonymous namespace)::FileWithFixedStatus::~FileWithFixedStatus", NM="_ZN12_GLOBAL__N_119FileWithFixedStatusD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_119FileWithFixedStatusD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    S.$destroy();
    InnerFile.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "InnerFile=" + InnerFile // NOI18N
              + ", S=" + S // NOI18N
              + super.toString(); // NOI18N
  }
}
