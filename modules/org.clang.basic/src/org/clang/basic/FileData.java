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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.llvm.support.sys.fs;


// FIXME: should probably replace this with vfs::Status
//<editor-fold defaultstate="collapsed" desc="clang::FileData">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 31,
 FQN="clang::FileData", NM="_ZN5clang8FileDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang8FileDataE")
//</editor-fold>
public class/*struct*/ FileData implements Destructors.ClassWithDestructor,
        Native.NativePOD<FileData> {
  public std.string Name;
  public long/*uint64_t*/ Size;
  public long/*time_t*/ ModTime;
  public fs.UniqueID UniqueID;
  public boolean IsDirectory;
  public boolean IsNamedPipe;
  public boolean InPCH;
  public boolean IsVFSMapped; // FIXME: remove this when files support multiple names
  //<editor-fold defaultstate="collapsed" desc="clang::FileData::FileData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 40,
   FQN="clang::FileData::FileData", NM="_ZN5clang8FileDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang8FileDataC1Ev")
  //</editor-fold>
  public FileData() {
    /* : Name(), Size(0), ModTime(0), UniqueID(), IsDirectory(false), IsNamedPipe(false), InPCH(false), IsVFSMapped(false)*/ 
    //START JInit
    this.Name = new std.string();
    this.Size = 0;
    this.ModTime = 0;
    this.UniqueID = new fs.UniqueID();
    this.IsDirectory = false;
    this.IsNamedPipe = false;
    this.InPCH = false;
    this.IsVFSMapped = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileData::FileData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 31,
   FQN="clang::FileData::FileData", NM="_ZN5clang8FileDataC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang8FileDataC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FileData(/*const*/ FileData /*&*/ $Prm0) {
    /* : Name(.Name), Size(.Size), ModTime(.ModTime), UniqueID(.UniqueID), IsDirectory(.IsDirectory), IsNamedPipe(.IsNamedPipe), InPCH(.InPCH), IsVFSMapped(.IsVFSMapped)*/ 
    //START JInit
    this.Name = new std.string($Prm0.Name);
    this.Size = $Prm0.Size;
    this.ModTime = $Prm0.ModTime;
    this.UniqueID = new fs.UniqueID($Prm0.UniqueID);
    this.IsDirectory = $Prm0.IsDirectory;
    this.IsNamedPipe = $Prm0.IsNamedPipe;
    this.InPCH = $Prm0.InPCH;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileData::~FileData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 31,
   FQN="clang::FileData::~FileData", NM="_ZN5clang8FileDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang8FileDataD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Name.$destroy();
    //END JDestroy
  }

  @Override
  public FileData clone() {
    return new FileData(this);
  }
  
  @Override
  public boolean $noteq(FileData other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(FileData other) {
    if (this.Size != other.Size) {
      return false;
    }
    if (this.ModTime != other.ModTime) {
      return false;
    }
    if (this.IsDirectory != other.IsDirectory) {
      return false;
    }
    if (this.IsNamedPipe != other.IsNamedPipe) {
      return false;
    }
    if (this.InPCH != other.InPCH) {
      return false;
    }
    if (this.IsVFSMapped != other.IsVFSMapped) {
      return false;
    }
    // FIXME: we don't compare Name?
    return this.UniqueID.equals(other.UniqueID);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileData::FileData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 31,
   FQN="clang::FileData::FileData", NM="_ZN5clang8FileDataC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang8FileDataC1EOS0_")
  //</editor-fold>
  public /*inline*/ FileData(JD$Move _dparam, FileData /*&&*/$Prm0) {
    /* : Name(static_cast<FileData &&>().Name), Size(static_cast<FileData &&>().Size), ModTime(static_cast<FileData &&>().ModTime), UniqueID(static_cast<FileData &&>().UniqueID), IsDirectory(static_cast<FileData &&>().IsDirectory), IsNamedPipe(static_cast<FileData &&>().IsNamedPipe), InPCH(static_cast<FileData &&>().InPCH), IsVFSMapped(static_cast<FileData &&>().IsVFSMapped)*/ 
    //START JInit
    this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
    this.Size = $Prm0.Size;
    this.ModTime = $Prm0.ModTime;
    this.UniqueID = new fs.UniqueID(JD$Move.INSTANCE, $Prm0.UniqueID);
    this.IsDirectory = $Prm0.IsDirectory;
    this.IsNamedPipe = $Prm0.IsNamedPipe;
    this.InPCH = $Prm0.InPCH;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FileData::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 31,
   FQN="clang::FileData::operator=", NM="_ZN5clang8FileDataaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang8FileDataaSERKS0_")
  //</editor-fold>
  public /*inline*/ FileData /*&*/ $assign(/*const*/ FileData /*&*/ $Prm0) {
    this.Name.$assign($Prm0.Name);
    this.Size = $Prm0.Size;
    this.ModTime = $Prm0.ModTime;
    this.UniqueID.$assign($Prm0.UniqueID);
    this.IsDirectory = $Prm0.IsDirectory;
    this.IsNamedPipe = $Prm0.IsNamedPipe;
    this.InPCH = $Prm0.InPCH;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Size=" + Size // NOI18N
              + ", ModTime=" + ModTime // NOI18N
              + ", UniqueID=" + UniqueID // NOI18N
              + ", IsDirectory=" + IsDirectory // NOI18N
              + ", IsNamedPipe=" + IsNamedPipe // NOI18N
              + ", InPCH=" + InPCH // NOI18N
              + ", IsVFSMapped=" + IsVFSMapped; // NOI18N
  }
}
