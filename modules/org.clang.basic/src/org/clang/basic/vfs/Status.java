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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.clank.support.Native.NativePOD;
import org.llvm.support.sys.TimeValue;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.fs.*;


/// \brief The result of a \p status operation.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::Status">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
 FQN="clang::vfs::Status", NM="_ZN5clang3vfs6StatusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusE")
//</editor-fold>
public class Status implements Destructors.ClassWithDestructor, NativePOD<Status> {
  private std.string Name;
  private fs.UniqueID UID;
  private TimeValue MTime;
  private /*uint32_t*/int User;
  private /*uint32_t*/int Group;
  private long/*uint64_t*/ Size;
  private fs.file_type Type;
  private /*fs.prems*/int Perms;
/*public:*/
  public boolean IsVFSMapped; // FIXME: remove when files support multiple names
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 46,
   FQN="clang::vfs::Status::Status", NM="_ZN5clang3vfs6StatusC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusC1Ev")
  //</editor-fold>
  public Status() {
    /* : Name(), UID(), MTime(), Type(fs::file_type::status_error)*/ 
    //START JInit
    this.Name = new std.string();
    this.UID = new fs.UniqueID();
    this.MTime = new TimeValue();
    this.Type = fs.file_type.status_error;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 42,
   FQN="clang::vfs::Status::Status", NM="_ZN5clang3vfs6StatusC1ERKN4llvm3sys2fs11file_statusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusC1ERKN4llvm3sys2fs11file_statusE")
  //</editor-fold>
  public Status(/*const*/ file_status /*&*/ Status) {
    /* : Name(), UID(Status.getUniqueID()), MTime(Status.getLastModificationTime()), User(Status.getUser()), Group(Status.getGroup()), Size(Status.getSize()), Type(Status.type()), Perms(Status.permissions()), IsVFSMapped(false)*/ 
    //START JInit
    this.Name = new std.string();
    this.UID = Status.getUniqueID();
    this.MTime = Status.getLastModificationTime();
    this.User = Status.getUser();
    this.Group = Status.getGroup();
    this.Size = Status.getSize();
    this.Type = Status.type();
    this.Perms = Status.permissions();
    this.IsVFSMapped = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 47,
   FQN="clang::vfs::Status::Status", NM="_ZN5clang3vfs6StatusC1EN4llvm9StringRefENS2_3sys2fs8UniqueIDENS4_9TimeValueEjjyNS5_9file_typeENS5_5permsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusC1EN4llvm9StringRefENS2_3sys2fs8UniqueIDENS4_9TimeValueEjjyNS5_9file_typeENS5_5permsE")
  //</editor-fold>
  public Status(StringRef Name, UniqueID UID, TimeValue MTime, 
      /*uint32_t*/int User, /*uint32_t*/int Group, long/*uint64_t*/ Size, file_type Type, 
      /*fs.prems*/int Perms) {
    /* : Name(Name.operator basic_string()), UID(UID), MTime(MTime), User(User), Group(Group), Size(Size), Type(Type), Perms(Perms), IsVFSMapped(false)*/ 
    //START JInit
    this.Name = Name.$string();
    this.UID = new fs.UniqueID(UID);
    this.MTime = new TimeValue(MTime);
    this.User = User;
    this.Group = Group;
    this.Size = Size;
    this.Type = Type;
    this.Perms = Perms;
    this.IsVFSMapped = false;
    //END JInit
  }

  
  /// Get a copy of a Status with a different name.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::copyWithNewName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 53,
   FQN="clang::vfs::Status::copyWithNewName", NM="_ZN5clang3vfs6Status15copyWithNewNameERKS1_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6Status15copyWithNewNameERKS1_N4llvm9StringRefE")
  //</editor-fold>
  public static Status copyWithNewName(/*const*/ Status /*&*/ In, StringRef NewName) {
    return new Status(/*NO_COPY*/NewName, In.getUniqueID(), In.getLastModificationTime(), 
        In.getUser(), In.getGroup(), In.getSize(), In.getType(), 
        In.getPermissions());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::copyWithNewName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 62,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 59,
   FQN="clang::vfs::Status::copyWithNewName", NM="_ZN5clang3vfs6Status15copyWithNewNameERKN4llvm3sys2fs11file_statusENS2_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6Status15copyWithNewNameERKN4llvm3sys2fs11file_statusENS2_9StringRefE")
  //</editor-fold>
  public static Status copyWithNewName(/*const*/ file_status /*&*/ In, StringRef NewName) {
    return new Status(/*NO_COPY*/NewName, In.getUniqueID(), In.getLastModificationTime(), 
        In.getUser(), In.getGroup(), In.getSize(), In.type(), 
        In.permissions());
  }

  
  /// \brief Returns the name that should be used for this file or directory.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 60,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 59,
   FQN="clang::vfs::Status::getName", NM="_ZNK5clang3vfs6Status7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }

  
  /// @name Status interface from llvm::sys::fs
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 63,
   FQN="clang::vfs::Status::getType", NM="_ZNK5clang3vfs6Status7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status7getTypeEv")
  //</editor-fold>
  public fs.file_type getType() /*const*/ {
    return Type;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getPermissions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 64,
   FQN="clang::vfs::Status::getPermissions", NM="_ZNK5clang3vfs6Status14getPermissionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status14getPermissionsEv")
  //</editor-fold>
  public /*fs.prems*/int getPermissions() /*const*/ {
    return Perms;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getLastModificationTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 65,
   FQN="clang::vfs::Status::getLastModificationTime", NM="_ZNK5clang3vfs6Status23getLastModificationTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status23getLastModificationTimeEv")
  //</editor-fold>
  public TimeValue getLastModificationTime() /*const*/ {
    return new TimeValue(MTime);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getUniqueID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 66,
   FQN="clang::vfs::Status::getUniqueID", NM="_ZNK5clang3vfs6Status11getUniqueIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status11getUniqueIDEv")
  //</editor-fold>
  public fs.UniqueID getUniqueID() /*const*/ {
    return new fs.UniqueID(UID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getUser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 67,
   FQN="clang::vfs::Status::getUser", NM="_ZNK5clang3vfs6Status7getUserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status7getUserEv")
  //</editor-fold>
  public /*uint32_t*/int getUser() /*const*/ {
    return User;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 68,
   FQN="clang::vfs::Status::getGroup", NM="_ZNK5clang3vfs6Status8getGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status8getGroupEv")
  //</editor-fold>
  public /*uint32_t*/int getGroup() /*const*/ {
    return Group;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 69,
   FQN="clang::vfs::Status::getSize", NM="_ZNK5clang3vfs6Status7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status7getSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getSize() /*const*/ {
    return Size;
  }

  /// @}
  /// @name Status queries
  /// These are static queries in llvm::sys::fs.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::equivalent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 65,
   FQN="clang::vfs::Status::equivalent", NM="_ZNK5clang3vfs6Status10equivalentERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status10equivalentERKS1_")
  //</editor-fold>
  public boolean equivalent(/*const*/ Status /*&*/ Other) /*const*/ {
    return getUniqueID().$eq(Other.getUniqueID());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::isDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 71,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 68,
   FQN="clang::vfs::Status::isDirectory", NM="_ZNK5clang3vfs6Status11isDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status11isDirectoryEv")
  //</editor-fold>
  public boolean isDirectory() /*const*/ {
    return Type == file_type.directory_file;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::isRegularFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 74,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 71,
   FQN="clang::vfs::Status::isRegularFile", NM="_ZNK5clang3vfs6Status13isRegularFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status13isRegularFileEv")
  //</editor-fold>
  public boolean isRegularFile() /*const*/ {
    return Type == file_type.regular_file;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::isOther">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 74,
   FQN="clang::vfs::Status::isOther", NM="_ZNK5clang3vfs6Status7isOtherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status7isOtherEv")
  //</editor-fold>
  public boolean isOther() /*const*/ {
    return exists() && !isRegularFile() && !isDirectory() && !isSymlink();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::isSymlink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 77,
   FQN="clang::vfs::Status::isSymlink", NM="_ZNK5clang3vfs6Status9isSymlinkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status9isSymlinkEv")
  //</editor-fold>
  public boolean isSymlink() /*const*/ {
    return Type == file_type.symlink_file;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::isStatusKnown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 80,
   FQN="clang::vfs::Status::isStatusKnown", NM="_ZNK5clang3vfs6Status13isStatusKnownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status13isStatusKnownEv")
  //</editor-fold>
  public boolean isStatusKnown() /*const*/ {
    return Type != file_type.status_error;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::exists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 83,
   FQN="clang::vfs::Status::exists", NM="_ZNK5clang3vfs6Status6existsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6Status6existsEv")
  //</editor-fold>
  public boolean exists() /*const*/ {
    return isStatusKnown() && Type != file_type.file_not_found;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
   FQN="clang::vfs::Status::Status", NM="_ZN5clang3vfs6StatusC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Status(/*const*/ Status /*&*/ $Prm0) {
    /* : Name(.Name), UID(.UID), MTime(.MTime), User(.User), Group(.Group), Size(.Size), Type(.Type), Perms(.Perms), IsVFSMapped(.IsVFSMapped)*/ 
    //START JInit
    this.Name = new std.string($Prm0.Name);
    this.UID = new fs.UniqueID($Prm0.UID);
    this.MTime = new TimeValue($Prm0.MTime);
    this.User = $Prm0.User;
    this.Group = $Prm0.Group;
    this.Size = $Prm0.Size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
   FQN="clang::vfs::Status::Status", NM="_ZN5clang3vfs6StatusC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusC1EOS1_")
  //</editor-fold>
  public /*inline*/ Status(JD$Move _dparam, Status /*&&*/$Prm0) {
    /* : Name(static_cast<Status &&>().Name), UID(static_cast<Status &&>().UID), MTime(static_cast<Status &&>().MTime), User(static_cast<Status &&>().User), Group(static_cast<Status &&>().Group), Size(static_cast<Status &&>().Size), Type(static_cast<Status &&>().Type), Perms(static_cast<Status &&>().Perms), IsVFSMapped(static_cast<Status &&>().IsVFSMapped)*/ 
    //START JInit
    this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
    this.UID = new fs.UniqueID(JD$Move.INSTANCE, $Prm0.UID);
    this.MTime = new TimeValue(JD$Move.INSTANCE, $Prm0.MTime);
    this.User = $Prm0.User;
    this.Group = $Prm0.Group;
    this.Size = $Prm0.Size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
   FQN="clang::vfs::Status::operator=", NM="_ZN5clang3vfs6StatusaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusaSERKS1_")
  //</editor-fold>
  public /*inline*/ Status /*&*/ $assign(/*const*/ Status /*&*/ $Prm0) {
    this.Name.$assign($Prm0.Name);
    this.UID.$assign($Prm0.UID);
    this.MTime.$assign($Prm0.MTime);
    this.User = $Prm0.User;
    this.Group = $Prm0.Group;
    this.Size = $Prm0.Size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
   FQN="clang::vfs::Status::operator=", NM="_ZN5clang3vfs6StatusaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusaSEOS1_")
  //</editor-fold>
  public /*inline*/ Status /*&*/ $assignMove(Status /*&&*/$Prm0) {
    this.Name.$assignMove($Prm0.Name);
    this.UID.$assignMove($Prm0.UID);
    this.MTime.$assignMove($Prm0.MTime);
    this.User = $Prm0.User;
    this.Group = $Prm0.Group;
    this.Size = $Prm0.Size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    this.IsVFSMapped = $Prm0.IsVFSMapped;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::Status::~Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 32,
   FQN="clang::vfs::Status::~Status", NM="_ZN5clang3vfs6StatusD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6StatusD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Name.$destroy();
    //END JDestroy
  }

  @Override public Status clone() { return new Status(this); }
  
  public String toString() {
    return "" + "Name=[" + Name.toJavaString() // NOI18N
              + "], UID=" + UID // NOI18N
              + ", MTime=" + MTime // NOI18N
              + ", User=" + User // NOI18N
              + ", Group=" + Group // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Perms=" + Perms // NOI18N
              + ", IsVFSMapped=" + IsVFSMapped; // NOI18N
  }
/// @}
}
