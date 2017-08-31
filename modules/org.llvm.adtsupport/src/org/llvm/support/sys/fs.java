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

package org.llvm.support.sys;

import static org.clank.support.Native.$AddrOf;
import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.impl.FSEntity;
import org.llvm.support.sys.*;
import static org.llvm.support.sys.path.*;

//<editor-fold defaultstate="collapsed" desc="static type fs">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print  -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp ${LLVM_SRC}/llvm/lib/Support/Path.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm3sys2fs9file_typeE;_ZN4llvm3sys2fs10space_infoE;_ZN4llvm3sys2fs5permsE;_ZN4llvm3sys2fsorENS1_5permsES2_;_ZN4llvm3sys2fsanENS1_5permsES2_;_ZN4llvm3sys2fsoRERNS1_5permsES2_;_ZN4llvm3sys2fsaNERNS1_5permsES2_;_ZN4llvm3sys2fscoENS1_5permsE;_ZN4llvm3sys2fs8UniqueIDE;_ZN4llvm3sys2fs11file_statusE;_ZN4llvm3sys2fs10file_magicE;_ZN4llvm3sys2fs13make_absoluteERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb;_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb;_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_;_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs6removeERKNS_5TwineEb;_ZN4llvm3sys2fs6renameERKNS_5TwineES4_;_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_;_ZN4llvm3sys2fs11resize_fileEim;_ZN4llvm3sys2fs6existsENS1_11file_statusE;_ZN4llvm3sys2fs10AccessModeE;_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE;_ZN4llvm3sys2fs6existsERKNS_5TwineE;_ZN4llvm3sys2fs11can_executeERKNS_5TwineE;_ZN4llvm3sys2fs9can_writeERKNS_5TwineE;_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_;_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb;_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_;_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE;_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb;_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE;_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE;_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb;_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE;_ZN4llvm3sys2fs8is_otherENS1_11file_statusE;_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb;_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE;_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE;_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERm;_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE;_ZN4llvm3sys2fs12status_knownENS1_11file_statusE;_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb;_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj;_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs9OpenFlagsE;_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_;_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_;_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj;_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERi;_ZN4llvm3sys2fs14identify_magicENS_9StringRefE;_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE;_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE;_ZN4llvm3sys2fs18mapped_file_regionE;_ZN4llvm3sys2fs17getMainExecutableEPKcPv;_ZN4llvm3sys2fs15directory_entryE;_ZN4llvm3sys2fs6detailE;_ZN4llvm3sys2fs18directory_iteratorE;_ZN4llvm3sys2fs28recursive_directory_iteratorE;_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity;_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity;_ZN4llvm3sys2fsL8test_dirEPcPKcS4_;_ZN4llvm3sys2fsL11getprogpathEPcPKc;_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE;_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE; -static-type=fs")
//</editor-fold>
public final class fs {


/// An enumeration for the file system's view of the type.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_type">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 53,
 FQN="llvm::sys::fs::file_type", NM="_ZN4llvm3sys2fs9file_typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs9file_typeE")
//</editor-fold>
public enum /*class */file_type/* : int*/ implements Native.NativeComparable<file_type> {
  status_error(0),
  file_not_found(status_error.getValue() + 1),
  regular_file(file_not_found.getValue() + 1),
  directory_file(regular_file.getValue() + 1),
  symlink_file(directory_file.getValue() + 1),
  block_file(symlink_file.getValue() + 1),
  character_file(block_file.getValue() + 1),
  fifo_file(character_file.getValue() + 1),
  socket_file(fifo_file.getValue() + 1),
  type_unknown(socket_file.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static file_type valueOf(int val) {
    file_type out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final file_type[] VALUES;
    private static final file_type[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (file_type kind : file_type.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new file_type[min < 0 ? (1-min) : 0];
      VALUES = new file_type[max >= 0 ? (1+max) : 0];
      for (file_type kind : file_type.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private file_type(int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}

  @Override
  public boolean $noteq(file_type other) {
    return this != other;
  }

  @Override
  public boolean $eq(file_type other) {
    return this == other;
  }
  //</editor-fold>
}

/// space_info - Self explanatory.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::space_info">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 67,
 FQN="llvm::sys::fs::space_info", NM="_ZN4llvm3sys2fs10space_infoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10space_infoE")
//</editor-fold>
public static class/*struct*/ space_info {
  public long/*uint64_t*/ capacity;
  public long/*uint64_t*/ free;
  public long/*uint64_t*/ available;
  
  public String toString() {
    return "" + "capacity=" + capacity // NOI18N
              + ", free=" + free // NOI18N
              + ", available=" + available; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::perms">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 73,
 FQN="llvm::sys::fs::perms", NM="_ZN4llvm3sys2fs5permsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs5permsE")
//</editor-fold>
public static final class/*enum*/ perms {
  public static final int no_perms = 0;
  public static final int owner_read = 0400;
  public static final int owner_write = 0200;
  public static final int owner_exe = 0100;
  public static final int owner_all = perms.owner_read | perms.owner_write | perms.owner_exe;
  public static final int group_read = 040;
  public static final int group_write = 020;
  public static final int group_exe = 010;
  public static final int group_all = perms.group_read | perms.group_write | perms.group_exe;
  public static final int others_read = 04;
  public static final int others_write = 02;
  public static final int others_exe = 01;
  public static final int others_all = perms.others_read | perms.others_write | perms.others_exe;
  public static final int all_read = perms.owner_read | perms.group_read | perms.others_read;
  public static final int all_write = perms.owner_write | perms.group_write | perms.others_write;
  public static final int all_exe = perms.owner_exe | perms.group_exe | perms.others_exe;
  public static final int all_all = perms.owner_all | perms.group_all | perms.others_all;
  public static final int set_uid_on_exe = 04000;
  public static final int set_gid_on_exe = 02000;
  public static final int sticky_bit = 01000;
  public static final int perms_not_known = 0xFFFF;
}

// Helper functions so that you can use & and | to manipulate perms bits:
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 98,
 FQN="llvm::sys::fs::operator|", NM="_ZN4llvm3sys2fsorENS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsorENS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitor_perms(/*fs.prems*/int l, /*fs.prems*/int r) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $bitor_perms(l, r);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator&">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 102,
 FQN="llvm::sys::fs::operator&", NM="_ZN4llvm3sys2fsanENS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsanENS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitand_perms(/*fs.prems*/int l, /*fs.prems*/int r) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $bitand_perms(l, r);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|=">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 106,
 FQN="llvm::sys::fs::operator|=", NM="_ZN4llvm3sys2fsoRERNS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsoRERNS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int/*&*/ $orassign_perms(/*fs.prems*/int/*&*/ l, /*fs.prems*/int r) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $orassign_perms(l, r);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator&=">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 110,
 FQN="llvm::sys::fs::operator&=", NM="_ZN4llvm3sys2fsaNERNS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsaNERNS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int/*&*/ $andassign_perms(/*fs.prems*/int/*&*/ l, /*fs.prems*/int r) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $andassign_perms(l, r);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator~">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 114,
 FQN="llvm::sys::fs::operator~", NM="_ZN4llvm3sys2fscoENS1_5permsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fscoENS1_5permsE")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitnot_perms(/*fs.prems*/int x) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $bitnot_perms(x);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
 FQN="llvm::sys::fs::UniqueID", NM="_ZN4llvm3sys2fs8UniqueIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDE")
//</editor-fold>
public static class UniqueID implements Native.NativeComparable<UniqueID>,
        Native.ComparableLower, Native.NativePOD<UniqueID> {
  public static final Comparator<UniqueID> COMPARATOR = new Comparator<UniqueID>() {
    @Override
    public int compare(UniqueID o1, UniqueID o2) {
      if (o1.Device == o2.Device) {
        return Long.compare(o1.File, o2.File);
      } else {
        return Long.compare(o1.Device, o2.Device);
      }
    }
  };  
  
  private long/*uint64_t*/ Device;
  private long/*uint64_t*/ File;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::UniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 123,
   FQN="llvm::sys::fs::UniqueID::UniqueID", NM="_ZN4llvm3sys2fs8UniqueIDC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDC1Ev")
  //</editor-fold>
  public UniqueID() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::UniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 124,
   FQN = "llvm::sys::fs::UniqueID::UniqueID", NM = "_ZN4llvm3sys2fs8UniqueIDC1Eyy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDC1Eyy")
  //</editor-fold>
  public UniqueID(long/*uint64_t*/ Device, long/*uint64_t*/ File) {
    /* : Device(Device), File(File)*/ 
    //START JInit
    this.Device = Device;
    this.File = File;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 125,
   FQN="llvm::sys::fs::UniqueID::operator==", NM="_ZNK4llvm3sys2fs8UniqueIDeqERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs8UniqueIDeqERKS2_")
  //</editor-fold>
  public boolean $eq(/*const*/ UniqueID /*&*/ Other) /*const*/ {
    return Device == Other.Device && File == Other.File;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 128,
   FQN="llvm::sys::fs::UniqueID::operator!=", NM="_ZNK4llvm3sys2fs8UniqueIDneERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs8UniqueIDneERKS2_")
  //</editor-fold>
  public boolean $noteq(/*const*/ UniqueID /*&*/ Other) /*const*/ {
    return !(/*Deref*/this.$eq(Other));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::operator<">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 129,
   FQN="llvm::sys::fs::UniqueID::operator<", NM="_ZNK4llvm3sys2fs8UniqueIDltERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs8UniqueIDltERKS2_")
  //</editor-fold>
  public boolean $less(/*const*/Object /*&*/ Other) /*const*/ {
    return Device < ((UniqueID) Other).Device || (Device == ((UniqueID) Other).Device && File < ((UniqueID) Other).File);
  }

  @Override
  public boolean $lesseq(Object Other) {
    return Device < ((UniqueID) Other).Device || (Device == ((UniqueID) Other).Device && File <= ((UniqueID) Other).File);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::getDevice">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 132,
   FQN="llvm::sys::fs::UniqueID::getDevice", NM="_ZNK4llvm3sys2fs8UniqueID9getDeviceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs8UniqueID9getDeviceEv")
  //</editor-fold>
  public long/*uint64_t*/ getDevice() /*const*/ {
    return Device;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::getFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 133,
   FQN="llvm::sys::fs::UniqueID::getFile", NM="_ZNK4llvm3sys2fs8UniqueID7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs8UniqueID7getFileEv")
  //</editor-fold>
  public long/*uint64_t*/ getFile() /*const*/ {
    return File;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::UniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
   FQN="llvm::sys::fs::UniqueID::UniqueID", NM="_ZN4llvm3sys2fs8UniqueIDC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDC1ERKS2_")
  //</editor-fold>
  public /*inline*/ UniqueID(/*const*/ UniqueID /*&*/ $Prm0) {
    /* : Device(.Device), File(.File)*/ 
    //START JInit
    this.Device = $Prm0.Device;
    this.File = $Prm0.File;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::UniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
   FQN="llvm::sys::fs::UniqueID::UniqueID", NM="_ZN4llvm3sys2fs8UniqueIDC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDC1EOS2_")
  //</editor-fold>
  public /*inline*/ UniqueID(JD$Move _dparam, UniqueID /*&&*/$Prm0) {
    /* : Device(static_cast<UniqueID &&>().Device), File(static_cast<UniqueID &&>().File)*/ 
    //START JInit
    this.Device = $Prm0.Device;
    this.File = $Prm0.File;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
   FQN="llvm::sys::fs::UniqueID::operator=", NM="_ZN4llvm3sys2fs8UniqueIDaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs8UniqueIDaSERKS2_")
  //</editor-fold>
  public /*inline*/ UniqueID /*&*/ $assign(/*const*/ UniqueID /*&*/ $Prm0) {
    this.Device = $Prm0.Device;
    this.File = $Prm0.File;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::~UniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
   FQN="llvm::sys::fs::UniqueID::~UniqueID", NM="_ZN4llvm3sys2fs8UniqueIDD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8UniqueIDD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::UniqueID::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 118,
   FQN="llvm::sys::fs::UniqueID::operator=", NM="_ZN4llvm3sys2fs8UniqueIDaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8UniqueIDaSEOS2_")
  //</editor-fold>
  public /*inline*/ UniqueID /*&*/ $assignMove(UniqueID /*&&*/$Prm0) {
    this.Device = $Prm0.Device;
    this.File = $Prm0.File;
    return /*Deref*/this;
  }

  @Override
  public UniqueID clone() {
    return new UniqueID(this);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 23 * hash + (int) (this.Device ^ (this.Device >>> 32));
    hash = 23 * hash + (int) (this.File ^ (this.File >>> 32));
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final UniqueID other = (UniqueID) obj;
    return $eq(other);
  }  
  
  public String toString() {
    return "" + "Device=" + Device // NOI18N
              + ", File=" + File; // NOI18N
  }
}

// JAVA: access for clients to santinel value
public static final fs.UniqueID INVALID_UNIQUE_ID = new UniqueID(-1, -1) {
  @Override
  public UniqueID $assign(UniqueID $Prm0) {
    throw new UnsupportedOperationException("Can not change const object");
  }

  @Override
  public UniqueID $assignMove(UniqueID $Prm0) {
    throw new UnsupportedOperationException("Can not change const object");
  }          
};

/// file_status - Represents the result of a call to stat and friends. It has
///               a platform-specific member to store the result.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 138,
 FQN="llvm::sys::fs::file_status", NM="_ZN4llvm3sys2fs11file_statusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusE")
//</editor-fold>
public static class file_status {
  /*friend*/public long/*dev_t*/ fs_st_dev;
  /*friend*/public long/*ino_t*/ fs_st_ino;
  private long/*time_t*/ fs_st_mtime;
  private /*uint*/int fs_st_uid;
  private /*uint*/int fs_st_gid;
  private long/*off_t*/ fs_st_size;
  /*friend bool equivalent(file_status A, file_status B)*/
  private file_type Type;
  private /*fs.prems*/int Perms;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::file_status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 161,
   FQN = "llvm::sys::fs::file_status::file_status", NM = "_ZN4llvm3sys2fs11file_statusC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusC1Ev")
  //</editor-fold>
  public file_status() {
    /* : fs_st_dev(0), fs_st_ino(0), fs_st_mtime(0), fs_st_uid(0), fs_st_gid(0), fs_st_size(0), Type(file_type::status_error), Perms(perms_not_known)*/ 
    //START JInit
    this.fs_st_dev = 0;
    this.fs_st_ino = 0;
    this.fs_st_mtime = 0;
    this.fs_st_uid = 0;
    this.fs_st_gid = 0;
    this.fs_st_size = 0;
    this.Type = file_type.status_error;
    this.Perms = perms.perms_not_known;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::file_status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 165,
   FQN = "llvm::sys::fs::file_status::file_status", NM = "_ZN4llvm3sys2fs11file_statusC1ENS1_9file_typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusC1ENS1_9file_typeE")
  //</editor-fold>
  public file_status(file_type Type) {
    /* : fs_st_dev(0), fs_st_ino(0), fs_st_mtime(0), fs_st_uid(0), fs_st_gid(0), fs_st_size(0), Type(Type), Perms(perms_not_known)*/ 
    //START JInit
    this.fs_st_dev = 0;
    this.fs_st_ino = 0;
    this.fs_st_mtime = 0;
    this.fs_st_uid = 0;
    this.fs_st_gid = 0;
    this.fs_st_size = 0;
    this.Type = Type;
    this.Perms = perms.perms_not_known;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::file_status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 169,
   FQN = "llvm::sys::fs::file_status::file_status", NM = "_ZN4llvm3sys2fs11file_statusC1ENS1_9file_typeENS1_5permsEymljjl",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusC1ENS1_9file_typeENS1_5permsEymljjl")
  //</editor-fold>
  public file_status(file_type Type, /*fs.prems*/int Perms, long/*dev_t*/ Dev, long/*ino_t*/ Ino, long/*time_t*/ MTime, 
      /*uint*/int UID, /*uint*/int GID, long/*off_t*/ Size) {
    /* : fs_st_dev(Dev), fs_st_ino(Ino), fs_st_mtime(MTime), fs_st_uid(UID), fs_st_gid(GID), fs_st_size(Size), Type(Type), Perms(Perms)*/ 
    //START JInit
    this.fs_st_dev = Dev;
    this.fs_st_ino = Ino;
    this.fs_st_mtime = MTime;
    this.fs_st_uid = UID;
    this.fs_st_gid = GID;
    this.fs_st_size = Size;
    this.Type = Type;
    this.Perms = Perms;
    //END JInit
  }

  
  // getters
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::type">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 196,
   FQN = "llvm::sys::fs::file_status::type", NM = "_ZNK4llvm3sys2fs11file_status4typeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs11file_status4typeEv")
  //</editor-fold>
  public file_type type() /*const*/ {
    return Type;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::permissions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 197,
   FQN = "llvm::sys::fs::file_status::permissions", NM = "_ZNK4llvm3sys2fs11file_status11permissionsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs11file_status11permissionsEv")
  //</editor-fold>
  public /*fs.prems*/int permissions() /*const*/ {
    return Perms;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::getLastModificationTime">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 177,
   FQN="llvm::sys::fs::file_status::getLastModificationTime", NM="_ZNK4llvm3sys2fs11file_status23getLastModificationTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs11file_status23getLastModificationTimeEv")
  //</editor-fold>
  public TimeValue getLastModificationTime() /*const*/ {
    TimeValue Ret/*J*/= new TimeValue();
    Ret.fromEpochTime(fs_st_mtime);
    return Ret;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::getUniqueID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 183,
   FQN="llvm::sys::fs::file_status::getUniqueID", NM="_ZNK4llvm3sys2fs11file_status11getUniqueIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs11file_status11getUniqueIDEv")
  //</editor-fold>
  public UniqueID getUniqueID() /*const*/ {
    return new UniqueID(fs_st_dev, fs_st_ino);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::getUser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 202,
   FQN = "llvm::sys::fs::file_status::getUser", NM = "_ZNK4llvm3sys2fs11file_status7getUserEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs11file_status7getUserEv")
  //</editor-fold>
  public /*uint32_t*/int getUser() /*const*/ {
    return fs_st_uid;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::getGroup">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 204,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 203,
   FQN = "llvm::sys::fs::file_status::getGroup", NM = "_ZNK4llvm3sys2fs11file_status8getGroupEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs11file_status8getGroupEv")
  //</editor-fold>
  public /*uint32_t*/int getGroup() /*const*/ {
    return fs_st_gid;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::getSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 205,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 204,
   FQN = "llvm::sys::fs::file_status::getSize", NM = "_ZNK4llvm3sys2fs11file_status7getSizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs11file_status7getSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getSize() /*const*/ {
    return fs_st_size;
  }

  
  // setters
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::type">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 218,
   FQN = "llvm::sys::fs::file_status::type", NM = "_ZN4llvm3sys2fs11file_status4typeENS1_9file_typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_status4typeENS1_9file_typeE")
  //</editor-fold>
  public void type(file_type v) {
    Type = v;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::permissions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 220,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 219,
   FQN = "llvm::sys::fs::file_status::permissions", NM = "_ZN4llvm3sys2fs11file_status11permissionsENS1_5permsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_status11permissionsENS1_5permsE")
  //</editor-fold>
  public void permissions(/*fs.prems*/int p) {
    Perms = p;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::file_status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 138,
   FQN="llvm::sys::fs::file_status::file_status", NM="_ZN4llvm3sys2fs11file_statusC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusC1ERKS2_")
  //</editor-fold>
  public /*inline*/ file_status(/*const*/ file_status /*&*/ $Prm0) {
    /* : fs_st_dev(.fs_st_dev), fs_st_ino(.fs_st_ino), fs_st_mtime(.fs_st_mtime), fs_st_uid(.fs_st_uid), fs_st_gid(.fs_st_gid), fs_st_size(.fs_st_size), Type(.Type), Perms(.Perms)*/ 
    //START JInit
    this.fs_st_dev = $Prm0.fs_st_dev;
    this.fs_st_ino = $Prm0.fs_st_ino;
    this.fs_st_mtime = $Prm0.fs_st_mtime;
    this.fs_st_uid = $Prm0.fs_st_uid;
    this.fs_st_gid = $Prm0.fs_st_gid;
    this.fs_st_size = $Prm0.fs_st_size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::file_status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 138,
   FQN="llvm::sys::fs::file_status::file_status", NM="_ZN4llvm3sys2fs11file_statusC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusC1EOS2_")
  //</editor-fold>
  public /*inline*/ file_status(JD$Move _dparam, file_status /*&&*/$Prm0) {
    /* : fs_st_dev(static_cast<file_status &&>().fs_st_dev), fs_st_ino(static_cast<file_status &&>().fs_st_ino), fs_st_mtime(static_cast<file_status &&>().fs_st_mtime), fs_st_uid(static_cast<file_status &&>().fs_st_uid), fs_st_gid(static_cast<file_status &&>().fs_st_gid), fs_st_size(static_cast<file_status &&>().fs_st_size), Type(static_cast<file_status &&>().Type), Perms(static_cast<file_status &&>().Perms)*/ 
    //START JInit
    this.fs_st_dev = $Prm0.fs_st_dev;
    this.fs_st_ino = $Prm0.fs_st_ino;
    this.fs_st_mtime = $Prm0.fs_st_mtime;
    this.fs_st_uid = $Prm0.fs_st_uid;
    this.fs_st_gid = $Prm0.fs_st_gid;
    this.fs_st_size = $Prm0.fs_st_size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 138,
   FQN="llvm::sys::fs::file_status::operator=", NM="_ZN4llvm3sys2fs11file_statusaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11file_statusaSERKS2_")
  //</editor-fold>
  public /*inline*/ file_status /*&*/ $assign(/*const*/ file_status /*&*/ $Prm0) {
    this.fs_st_dev = $Prm0.fs_st_dev;
    this.fs_st_ino = $Prm0.fs_st_ino;
    this.fs_st_mtime = $Prm0.fs_st_mtime;
    this.fs_st_uid = $Prm0.fs_st_uid;
    this.fs_st_gid = $Prm0.fs_st_gid;
    this.fs_st_size = $Prm0.fs_st_size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_status::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 138,
   FQN="llvm::sys::fs::file_status::operator=", NM="_ZN4llvm3sys2fs11file_statusaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11file_statusaSEOS2_")
  //</editor-fold>
  public /*inline*/ file_status /*&*/ $assignMove(file_status /*&&*/$Prm0) {
    
    /// file_status - Represents the result of a call to stat and friends. It has
    ///               a platform-specific member to store the result.
    this.fs_st_dev = $Prm0.fs_st_dev;
    this.fs_st_ino = $Prm0.fs_st_ino;
    this.fs_st_mtime = $Prm0.fs_st_mtime;
    this.fs_st_uid = $Prm0.fs_st_uid;
    this.fs_st_gid = $Prm0.fs_st_gid;
    this.fs_st_size = $Prm0.fs_st_size;
    this.Type = $Prm0.Type;
    this.Perms = $Prm0.Perms;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "fs_st_dev=" + fs_st_dev // NOI18N
              + ", fs_st_ino=" + fs_st_ino // NOI18N
              + ", fs_st_mtime=" + fs_st_mtime // NOI18N
              + ", fs_st_uid=" + fs_st_uid // NOI18N
              + ", fs_st_gid=" + fs_st_gid // NOI18N
              + ", fs_st_size=" + fs_st_size // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Perms=" + Perms; // NOI18N
  }
}

/// file_magic - An "enum class" enumeration of file types based on magic (the first
///         N bytes of the file).
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 225,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 224,
 FQN = "llvm::sys::fs::file_magic", NM = "_ZN4llvm3sys2fs10file_magicE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10file_magicE")
//</editor-fold>
public static class/*struct*/ file_magic {
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::Impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 225,
   FQN = "llvm::sys::fs::file_magic::Impl", NM = "_ZN4llvm3sys2fs10file_magic4ImplE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10file_magic4ImplE")
  //</editor-fold>
  public enum Impl {
    unknown(0), ///< Unrecognized file
    bitcode(unknown.getValue() + 1), ///< Bitcode file
    archive(bitcode.getValue() + 1), ///< ar style archive file
    elf(archive.getValue() + 1), ///< ELF Unknown type
    elf_relocatable(elf.getValue() + 1), ///< ELF Relocatable object file
    elf_executable(elf_relocatable.getValue() + 1), ///< ELF Executable image
    elf_shared_object(elf_executable.getValue() + 1), ///< ELF dynamically linked shared lib
    elf_core(elf_shared_object.getValue() + 1), ///< ELF core image
    macho_object(elf_core.getValue() + 1), ///< Mach-O Object file
    macho_executable(macho_object.getValue() + 1), ///< Mach-O Executable
    macho_fixed_virtual_memory_shared_lib(macho_executable.getValue() + 1), ///< Mach-O Shared Lib, FVM
    macho_core(macho_fixed_virtual_memory_shared_lib.getValue() + 1), ///< Mach-O Core File
    macho_preload_executable(macho_core.getValue() + 1), ///< Mach-O Preloaded Executable
    macho_dynamically_linked_shared_lib(macho_preload_executable.getValue() + 1), ///< Mach-O dynlinked shared lib
    macho_dynamic_linker(macho_dynamically_linked_shared_lib.getValue() + 1), ///< The Mach-O dynamic linker
    macho_bundle(macho_dynamic_linker.getValue() + 1), ///< Mach-O Bundle file
    macho_dynamically_linked_shared_lib_stub(macho_bundle.getValue() + 1), ///< Mach-O Shared lib stub
    macho_dsym_companion(macho_dynamically_linked_shared_lib_stub.getValue() + 1), ///< Mach-O dSYM companion file
    macho_universal_binary(macho_dsym_companion.getValue() + 1), ///< Mach-O universal binary
    coff_object(macho_universal_binary.getValue() + 1), ///< COFF object file
    coff_import_library(coff_object.getValue() + 1), ///< COFF import library
    pecoff_executable(coff_import_library.getValue() + 1), ///< PECOFF executable file
    windows_resource(pecoff_executable.getValue() + 1); ///< Windows compiled resource file (.rc)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Impl valueOf(int val) {
      Impl out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final Impl[] VALUES;
      private static final Impl[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Impl kind : Impl.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Impl[min < 0 ? (1-min) : 0];
        VALUES = new Impl[max >= 0 ? (1+max) : 0];
        for (Impl kind : Impl.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Impl(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::is_object">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 251,
   FQN = "llvm::sys::fs::file_magic::is_object", NM = "_ZNK4llvm3sys2fs10file_magic9is_objectEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs10file_magic9is_objectEv")
  //</editor-fold>
  public boolean is_object() /*const*/ {
    return V == Impl.unknown ? false : true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::file_magic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 255,
   FQN = "llvm::sys::fs::file_magic::file_magic", NM = "_ZN4llvm3sys2fs10file_magicC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10file_magicC1Ev")
  //</editor-fold>
  public file_magic() {
    /* : V(unknown)*/ 
    //START JInit
    this.V = Impl.unknown;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::file_magic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 258,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 256,
   FQN = "llvm::sys::fs::file_magic::file_magic", NM = "_ZN4llvm3sys2fs10file_magicC1ENS2_4ImplE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10file_magicC1ENS2_4ImplE")
  //</editor-fold>
  public file_magic(Impl V) {
    /* : V(V)*/ 
    //START JInit
    this.V = V;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::operator Impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 257,
   FQN="llvm::sys::fs::file_magic::operator Impl", NM="_ZNK4llvm3sys2fs10file_magiccvNS2_4ImplEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs10file_magiccvNS2_4ImplEEv")
  //</editor-fold>
  public Impl $Impl() /*const*/ {
    return V;
  }

/*private:*/
  private Impl V;

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::file_magic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 224,
   FQN = "llvm::sys::fs::file_magic::file_magic", NM = "_ZN4llvm3sys2fs10file_magicC1EOS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10file_magicC1EOS2_")
  //</editor-fold>
  public /*inline*/ file_magic(JD$Move _dparam, file_magic /*&&*/$Prm0) {
    /* : V(static_cast<file_magic &&>().V)*/ 
    //START JInit
    this.V = $Prm0.
        /// file_magic - An "enum class" enumeration of file types based on magic (the first
        ///         N bytes of the file).
        V;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::~file_magic">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 224,
   FQN = "llvm::sys::fs::file_magic::~file_magic", NM = "_ZN4llvm3sys2fs10file_magicD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10file_magicD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_magic::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 224,
   FQN = "llvm::sys::fs::file_magic::operator=", NM = "_ZN4llvm3sys2fs10file_magicaSEOS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10file_magicaSEOS2_")
  //</editor-fold>
  public /*inline*/ file_magic /*&*/ $assignMove(file_magic /*&&*/$Prm0) {
    this.V = $Prm0.V;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "V=" + V; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::AccessMode">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 374,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 356,
 FQN = "llvm::sys::fs::AccessMode", NM = "_ZN4llvm3sys2fs10AccessModeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10AccessModeE")
//</editor-fold>
public enum /*class */AccessMode/* : int*/ {
  Exist(0),
  Write(Exist.getValue() + 1),
  Execute(Write.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AccessMode valueOf(int val) {
    AccessMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final AccessMode[] VALUES;
    private static final AccessMode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AccessMode kind : AccessMode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AccessMode[min < 0 ? (1-min) : 0];
      VALUES = new AccessMode[max >= 0 ? (1+max) : 0];
      for (AccessMode kind : AccessMode.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private AccessMode(int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
}

/// @brief Does file exist?
///
/// @param Path Input path.
/// @returns True if it exists, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::exists">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 387,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 369,
 FQN = "llvm::sys::fs::exists", NM = "_ZN4llvm3sys2fs6existsERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs6existsERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean exists(/*const*/ Twine /*&*/ Path) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    exists(Path);
}


/// @brief Can we execute this file?
///
/// @param Path Input path.
/// @returns True if we can execute it, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::can_execute">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 328,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 377,
 FQN = "llvm::sys::fs::can_execute", NM = "_ZN4llvm3sys2fs11can_executeERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs11can_executeERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean can_execute(/*const*/ Twine /*&*/ Path) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    can_execute(Path);
}


/// @brief Can we write this file?
///
/// @param Path Input path.
/// @returns True if we can write to it, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::can_write">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 401,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 385,
 FQN = "llvm::sys::fs::can_write", NM = "_ZN4llvm3sys2fs9can_writeERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs9can_writeERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean can_write(/*const*/ Twine /*&*/ Path) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    can_write(Path);
}


/// @brief Simpler version of equivalent for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 430,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 414,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_")
//</editor-fold>
public static /*inline*/ boolean equivalent(/*const*/ Twine /*&*/ A, /*const*/ Twine /*&*/ B) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    equivalent(A, B);
}


/// @brief Simpler version of is_directory for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 452,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 436,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean is_directory(/*const*/ Twine /*&*/ Path) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    is_directory(Path);
}


/// @brief Simpler version of is_regular_file for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 474,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 458,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean is_regular_file(/*const*/ Twine /*&*/ Path) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    is_regular_file(Path);
}


/// @brief Get file size.
///
/// @param Path Input path.
/// @param Result Set to the size of the file in \a Path.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_size">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 515,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 499,
 FQN = "llvm::sys::fs::file_size", NM = "_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERy")
//</editor-fold>
public static /*inline*/ std.error_code file_size(/*const*/ Twine /*&*/ Path, ulong$ref/*uint64_t &*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    file_size(Path, Result);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::OpenFlags">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 593,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 577,
 FQN = "llvm::sys::fs::OpenFlags", NM = "_ZN4llvm3sys2fs9OpenFlagsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs9OpenFlagsE")
//</editor-fold>
public static final class/*enum*/ OpenFlags/* : unsigned int*/ {
  public static final int F_None = 0;
  
  /// F_Excl - When opening a file, this flag makes raw_fd_ostream
  /// report an error if the file already exists.
  public static final int F_Excl = 1;
  
  /// F_Append - When opening a file, if it already exists append to the
  /// existing file instead of returning an error.  This may not be specified
  /// with F_Excl.
  public static final int F_Append = 2;
  
  /// The file should be opened in text mode on platforms that make this
  /// distinction.
  public static final int F_Text = 4;
  
  /// Open the file for read and write.
  public static final int F_RW = 8;
}
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 613,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 597,
 FQN = "llvm::sys::fs::operator|", NM = "_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_")
//</editor-fold>
public static /*inline*/ /*fs.OpenFlags*/int $bitor_OpenFlags(/*fs.OpenFlags*/int A, /*fs.OpenFlags*/int B) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $bitor_OpenFlags(A, B);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|=">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 617,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 601,
 FQN = "llvm::sys::fs::operator|=", NM = "_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_")
//</editor-fold>
public static /*inline*/ /*fs.OpenFlags*/int/*&*/ $orassign_OpenFlags(/*fs.OpenFlags*/int/*&*/ A, /*fs.OpenFlags*/int B) {
  return /*delegate*/org.llvm.support.sys.impl.FileSystemFsGlobals.
    $orassign_OpenFlags(A, B);
}


/// This class represents a memory mapped file. It is based on
/// boost::iostreams::mapped_file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 642,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 626,
 FQN = "llvm::sys::fs::mapped_file_region", NM = "_ZN4llvm3sys2fs18mapped_file_regionE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionE")
//</editor-fold>
public static class mapped_file_region implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::mapped_file_region">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 643,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 627,
   FQN = "llvm::sys::fs::mapped_file_region::mapped_file_region", NM = "_ZN4llvm3sys2fs18mapped_file_regionC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionC1Ev")
  //</editor-fold>
  private mapped_file_region() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::mapped_file_region">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 644,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 628,
   FQN = "llvm::sys::fs::mapped_file_region::mapped_file_region", NM = "_ZN4llvm3sys2fs18mapped_file_regionC1ERS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionC1ERS2_")
  //</editor-fold>
  private mapped_file_region(mapped_file_region /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 645,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 629,
   FQN = "llvm::sys::fs::mapped_file_region::operator=", NM = "_ZN4llvm3sys2fs18mapped_file_regionaSERS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionaSERS2_")
  //</editor-fold>
  private mapped_file_region /*&*/ $assign(mapped_file_region /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::mapmode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 648,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 632,
   FQN = "llvm::sys::fs::mapped_file_region::mapmode", NM = "_ZN4llvm3sys2fs18mapped_file_region7mapmodeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18mapped_file_region7mapmodeE")
  //</editor-fold>
  public enum mapmode {
    readonly(0), ///< May only access map via const_data as read only.
    readwrite(readonly.getValue() + 1), ///< May access map via data and modify it. Written to path.
    priv(readwrite.getValue() + 1); ///< May modify via data, but changes are lost on destruction.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static mapmode valueOf(int val) {
      mapmode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final mapmode[] VALUES;
      private static final mapmode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (mapmode kind : mapmode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new mapmode[min < 0 ? (1-min) : 0];
        VALUES = new mapmode[max >= 0 ? (1+max) : 0];
        for (mapmode kind : mapmode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private mapmode(int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
/*private:*/
  /// Platform-specific mapping state.
  private long/*uint64_t*/ Size;
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION)
  private char$ptr/*void P*/ Mapping;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::init">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 420,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 415,
   FQN = "llvm::sys::fs::mapped_file_region::init", NM = "_ZN4llvm3sys2fs18mapped_file_region4initEiyNS2_7mapmodeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18mapped_file_region4initEiyNS2_7mapmodeE")
  //</editor-fold>
  private std.error_code init(int FD, long/*uint64_t*/ Offset, 
      mapmode Mode) {
    assert (Size != 0);
    
    int flags = (Mode == mapmode.readwrite) ? MAP_SHARED : MAP_PRIVATE;
    int prot = (Mode == mapmode.readonly) ? PROT_READ : (PROT_READ | PROT_WRITE);
    Mapping = /*::*/mmap(null, Size, prot, flags, FD, Offset);
    if (Mapping.$eq(((Object/*void P*/ )MAP_FAILED))) {
      return new std.error_code(errno(), std.generic_category());
    }
    return new std.error_code();
  }


/*public:*/
  /// \param fd An open file descriptor to map. mapped_file_region takes
  ///   ownership if closefd is true. It must have been opended in the correct
  ///   mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::mapped_file_region">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 432,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 427,
   FQN = "llvm::sys::fs::mapped_file_region::mapped_file_region", NM = "_ZN4llvm3sys2fs18mapped_file_regionC1EiNS2_7mapmodeEyyRSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionC1EiNS2_7mapmodeEyyRSt10error_code")
  //</editor-fold>
  public mapped_file_region(int fd, mapmode mode, long/*uint64_t*/ length, 
      long/*uint64_t*/ offset, std.error_code /*&*/ ec) {
    /* : Size(length), Mapping(implicit void * ())*/ 
    //START JInit
    this.Size = length;
    this.Mapping = null;
    //END JInit
    // Make sure that the requested size fits within SIZE_T.
    if ($greater_ulong_uint(length, std.numeric_limitsUInt.max())) {
      ec.$assignMove(make_error_code(errc.invalid_argument));
      return;
    }
    
    ec.$assignMove(init(fd, offset, mode));
    if (ec.$bool()) {
      Mapping = null;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::~mapped_file_region">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 446,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 441,
   FQN = "llvm::sys::fs::mapped_file_region::~mapped_file_region", NM = "_ZN4llvm3sys2fs18mapped_file_regionD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18mapped_file_regionD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((Mapping != null)) {
      /*::*/munmap(Mapping, Size);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 451,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 446,
   FQN = "llvm::sys::fs::mapped_file_region::size", NM = "_ZNK4llvm3sys2fs18mapped_file_region4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs18mapped_file_region4sizeEv")
  //</editor-fold>
  public long/*uint64_t*/ size() /*const*/ {
    assert ((Mapping != null)) : "Mapping failed but used anyway!";
    return Size;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::data">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 456,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 451,
   FQN = "llvm::sys::fs::mapped_file_region::data", NM = "_ZNK4llvm3sys2fs18mapped_file_region4dataEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs18mapped_file_region4dataEv")
  //</editor-fold>
  public char$ptr/*char P*/ data() /*const*/ {
    assert ((Mapping != null)) : "Mapping failed but used anyway!";
    return Mapping;
  }


  
  /// Get a const view of the data. Modifying this memory has undefined
  /// behavior.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::const_data">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 461,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 456,
   FQN = "llvm::sys::fs::mapped_file_region::const_data", NM = "_ZNK4llvm3sys2fs18mapped_file_region10const_dataEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs18mapped_file_region10const_dataEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ const_data() /*const*/ {
    assert ((Mapping != null)) : "Mapping failed but used anyway!";
    return $toConst(Mapping);
  }


  
  /// \returns The minimum alignment offset must be.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::mapped_file_region::alignment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 466,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 461,
   FQN = "llvm::sys::fs::mapped_file_region::alignment", NM = "_ZN4llvm3sys2fs18mapped_file_region9alignmentEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18mapped_file_region9alignmentEv")
  //</editor-fold>
  public static int alignment() {
    return Process.getPageSize();
  }


  
  public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", Mapping=" + Mapping; // NOI18N
  }
}

/// @}
/// @name Iterators
/// @{

/// directory_entry - A single entry in a directory. Caches the status either
/// from the result of the iteration syscall, or the first time status is
/// called.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 693,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 677,
 FQN = "llvm::sys::fs::directory_entry", NM = "_ZN4llvm3sys2fs15directory_entryE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15directory_entryE")
//</editor-fold>
public static class directory_entry implements Destructors.ClassWithDestructor, Native.NativeComparable<directory_entry> {
  private std.string Path;
  private /*mutable */file_status Status;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::directory_entry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 698,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 682,
   FQN = "llvm::sys::fs::directory_entry::directory_entry", NM = "_ZN4llvm3sys2fs15directory_entryC1ERKNS_5TwineENS1_11file_statusE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15directory_entryC1ERKNS_5TwineENS1_11file_statusE")
  //</editor-fold>
  public /*explicit*/ directory_entry(/*const*/ Twine /*&*/ path) {
    this(path, new file_status());
  }
  public /*explicit*/ directory_entry(/*const*/ Twine /*&*/ path, file_status st/*= file_status()*/) {
    /* : Path(path.str()), Status(st)*/ 
    //START JInit
    this.Path = path.str();
    this.Status = new file_status(st);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::directory_entry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 702,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 686,
   FQN = "llvm::sys::fs::directory_entry::directory_entry", NM = "_ZN4llvm3sys2fs15directory_entryC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15directory_entryC1Ev")
  //</editor-fold>
  public directory_entry() {
    /* : Path(), Status()*/ 
    //START JInit
    this.Path = new std.string();
    this.Status = new file_status();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::assign">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 704,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 688,
   FQN = "llvm::sys::fs::directory_entry::assign", NM = "_ZN4llvm3sys2fs15directory_entry6assignERKNS_5TwineENS1_11file_statusE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15directory_entry6assignERKNS_5TwineENS1_11file_statusE")
  //</editor-fold>
  public void assign(/*const*/ Twine /*&*/ path) {
    assign(path, new file_status());
  }
  public void assign(/*const*/ Twine /*&*/ path, file_status st/*= file_status()*/) {
    Path.$assignMove(path.str());
    Status.$assign(st);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::replace_filename">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 946,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 899,
   FQN = "llvm::sys::fs::directory_entry::replace_filename", NM = "_ZN4llvm3sys2fs15directory_entry16replace_filenameERKNS_5TwineENS1_11file_statusE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15directory_entry16replace_filenameERKNS_5TwineENS1_11file_statusE")
  //</editor-fold>
  public void replace_filename(/*const*/ Twine /*&*/ filename) {
    replace_filename(filename, new file_status());
  }
  public void replace_filename(/*const*/ Twine /*&*/ filename, file_status st/*= file_status()*/) {
    SmallString/*128*/ path/*J*/= new SmallString/*128*/(Path.begin(), Path.end(), 128);
    remove_filename(path);
    append(path, filename);
    Path.$assignMove(path.str().$string());
    Status.$assign(st);
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::path">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 711,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 695,
   FQN = "llvm::sys::fs::directory_entry::path", NM = "_ZNK4llvm3sys2fs15directory_entry4pathEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entry4pathEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getPath() /*const*/ {
    return Path;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::status">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 1117,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 1070,
   FQN = "llvm::sys::fs::directory_entry::status", NM = "_ZNK4llvm3sys2fs15directory_entry6statusERNS1_11file_statusE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys2fs15directory_entry6statusERNS1_11file_statusE")
  //</editor-fold>
  public std.error_code status(file_status /*&*/ result) /*const*/ {
    return fs.status(new Twine(Path), result);
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 714,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 698,
   FQN = "llvm::sys::fs::directory_entry::operator==", NM = "_ZNK4llvm3sys2fs15directory_entryeqERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entryeqERKS2_")
  //</editor-fold>
  public boolean $eq(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    return $eq_str(Path, rhs.Path);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 715,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 699,
   FQN = "llvm::sys::fs::directory_entry::operator!=", NM = "_ZNK4llvm3sys2fs15directory_entryneERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entryneERKS2_")
  //</editor-fold>
  public boolean $noteq(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    return !(/*Deref*/this.$eq(rhs));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 716,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 700,
   FQN = "llvm::sys::fs::directory_entry::operator<", NM = "_ZNK4llvm3sys2fs15directory_entryltERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entryltERKS2_")
  //</editor-fold>
  public boolean $less(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator<=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 717,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 701,
   FQN = "llvm::sys::fs::directory_entry::operator<=", NM = "_ZNK4llvm3sys2fs15directory_entryleERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entryleERKS2_")
  //</editor-fold>
  public boolean $lesseq(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 718,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 702,
   FQN = "llvm::sys::fs::directory_entry::operator>", NM = "_ZNK4llvm3sys2fs15directory_entrygtERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entrygtERKS2_")
  //</editor-fold>
  public boolean $greater(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator>=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 719,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 703,
   FQN = "llvm::sys::fs::directory_entry::operator>=", NM = "_ZNK4llvm3sys2fs15directory_entrygeERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs15directory_entrygeERKS2_")
  //</editor-fold>
  public boolean $greatereq(/*const*/ directory_entry /*&*/ rhs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::~directory_entry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 693,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 677,
   FQN = "llvm::sys::fs::directory_entry::~directory_entry", NM = "_ZN4llvm3sys2fs15directory_entryD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15directory_entryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Path.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_entry::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 693,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 677,
   FQN = "llvm::sys::fs::directory_entry::operator=", NM = "_ZN4llvm3sys2fs15directory_entryaSEOS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15directory_entryaSEOS2_")
  //</editor-fold>
  public /*inline*/ directory_entry /*&*/ $assignMove(directory_entry /*&&*/$Prm0) {
    
    /// @}
    /// @name Iterators
    /// @{
    
    /// directory_entry - A single entry in a directory. Caches the status either
    /// from the result of the iteration syscall, or the first time status is
    /// called.
    this.Path.$assignMove($Prm0.Path);
    this.Status.$assignMove($Prm0.Status);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "Path=" + Path // NOI18N
              + ", Status=" + Status; // NOI18N
  }
}
//JAVA: namespace detail {
public static final class detail {
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::directory_iterator_construct">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 470,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 465,
   FQN = "llvm::sys::fs::detail::directory_iterator_construct", NM = "_ZN4llvm3sys2fs6detail28directory_iterator_constructERNS2_12DirIterStateENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6detail28directory_iterator_constructERNS2_12DirIterStateENS_9StringRefE")
  //</editor-fold>
  public static std.error_code directory_iterator_construct(detail.DirIterState /*&*/ it, 
                              StringRef path) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*128*/ path_null/*J*/= new SmallString/*128*/(new StringRef(path), 128);
       DIR /*P*/ directory = /*::*/opendir(path_null.c_str());
      if (!(directory != null)) {
        return new std.error_code(errno(), std.generic_category());
      }

      it.IterationHandle = reinterpret_cast_Object/*intptr_t*/(directory);
      // Add something for replace_filename to replace.
      append(path_null, new Twine($DOT));
      $c$.clean(it.CurrentEntry.$assignMove($c$.track(new directory_entry(new Twine(path_null.str())))));
      return directory_iterator_increment(it);
    } finally {
      $c$.$destroy();
    }
  }

  

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::directory_iterator_increment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 492,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 487,
   FQN = "llvm::sys::fs::detail::directory_iterator_increment", NM = "_ZN4llvm3sys2fs6detail28directory_iterator_incrementERNS2_12DirIterStateE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6detail28directory_iterator_incrementERNS2_12DirIterStateE")
  //</editor-fold>
  public static std.error_code directory_iterator_increment(detail.DirIterState /*&*/ it) {
    setErrno(0);
    dirent /*P*/ cur_dir = /*::*/readdir(reinterpret_cast( DIR /*P*/ .class, it.IterationHandle));
    if (cur_dir == null && errno() != 0) {
      return new std.error_code(errno(), std.generic_category());
    } else if (cur_dir != null) {
      StringRef name/*J*/= new StringRef(cur_dir.d_name, strlen((cur_dir).d_name));
      if ((name.size() == 1 && name.$at(0) == $$DOT)
         || (name.size() == 2 && name.$at(0) == $$DOT && name.$at(1) == $$DOT)) {
        return directory_iterator_increment(it);
      }
      it.CurrentEntry.replace_filename(new Twine(name));
    } else {
      return directory_iterator_destruct(it);
    }

    return new std.error_code();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::directory_iterator_destruct">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 484,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 479,
   FQN = "llvm::sys::fs::detail::directory_iterator_destruct", NM = "_ZN4llvm3sys2fs6detail27directory_iterator_destructERNS2_12DirIterStateE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6detail27directory_iterator_destructERNS2_12DirIterStateE")
  //</editor-fold>
  public static std.error_code directory_iterator_destruct(detail.DirIterState /*&*/ it) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ((it.IterationHandle != null)) {
        /*::*/closedir(reinterpret_cast( DIR /*P*/ .class, it.IterationHandle));
      }
      it.IterationHandle = 0;
      $c$.clean(it.CurrentEntry.$assignMove($c$.track(new directory_entry())));
      return new std.error_code();
    } finally {
      $c$.$destroy();
    }
  }

  
    
  /// DirIterState - Keeps state for the directory_iterator. It is reference
  /// counted in order to preserve InputIterator semantics on copy.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::DirIterState">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 731,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 715,
   FQN = "llvm::sys::fs::detail::DirIterState", NM = "_ZN4llvm3sys2fs6detail12DirIterStateE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs6detail12DirIterStateE")
  //</editor-fold>
  public static final class/*struct*/ DirIterState extends /*public*/ RefCountedBase<DirIterState> implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::DirIterState::DirIterState">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 732,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 716,
     FQN = "llvm::sys::fs::detail::DirIterState::DirIterState", NM = "_ZN4llvm3sys2fs6detail12DirIterStateC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs6detail12DirIterStateC1Ev")
    //</editor-fold>
    public DirIterState() {
      /* : RefCountedBase<DirIterState>(), IterationHandle(0), CurrentEntry()*/ 
      //START JInit
      super();
      this.IterationHandle = null;
      this.CurrentEntry = new directory_entry();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::DirIterState::~DirIterState">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 735,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 719,
     FQN = "llvm::sys::fs::detail::DirIterState::~DirIterState", NM = "_ZN4llvm3sys2fs6detail12DirIterStateD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs6detail12DirIterStateD0Ev")
    //</editor-fold>
    public void $destroy() {
      directory_iterator_destruct(/*Deref*/this);
      //START JDestroy
      CurrentEntry.$destroy();
      //~RefCountedBase<DirIterState>;
      super.$destroy();
      //END JDestroy
    }

    
    public Object/*intptr_t*/ IterationHandle;
    public directory_entry CurrentEntry;
    
    public String toString() {
      return "" + "IterationHandle=" + IterationHandle // NOI18N
                + ", CurrentEntry=" + CurrentEntry // NOI18N
                + super.toString(); // NOI18N
    }
  }

//}
//} JAVA: end of namespace detail
  //JAVA: namespace detail {
//  public static final class detail {
/// RecDirIterState - Keeps state for the recursive_directory_iterator. It is
/// reference counted in order to preserve InputIterator semantics on copy.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::RecDirIterState">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 795,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 779,
   FQN = "llvm::sys::fs::detail::RecDirIterState", NM = "_ZN4llvm3sys2fs6detail15RecDirIterStateE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FileOutputBuffer.cpp -nm=_ZN4llvm3sys2fs6detail15RecDirIterStateE")
  //</editor-fold>
  public static final class/*struct*/ RecDirIterState extends /*public*/ RefCountedBase<RecDirIterState> implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::RecDirIterState::RecDirIterState">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 796,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 780,
     FQN = "llvm::sys::fs::detail::RecDirIterState::RecDirIterState", NM = "_ZN4llvm3sys2fs6detail15RecDirIterStateC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FileOutputBuffer.cpp -nm=_ZN4llvm3sys2fs6detail15RecDirIterStateC1Ev")
    //</editor-fold>
    public RecDirIterState() {
      /* : RefCountedBase<RecDirIterState>(), Stack(), Level(0), HasNoPushRequest(false)*/ 
      //START JInit
      super();
      this.Stack = new std.stack<directory_iterator>(new directory_iterator());
      this.Level = 0;
      this.HasNoPushRequest = false;
      //END JInit
    }


    public std.stack<directory_iterator> Stack;
    public char/*uint16_t*/ Level;
    public boolean HasNoPushRequest;
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::detail::RecDirIterState::~RecDirIterState">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 795,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 779,
     FQN = "llvm::sys::fs::detail::RecDirIterState::~RecDirIterState", NM = "_ZN4llvm3sys2fs6detail15RecDirIterStateD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FileOutputBuffer.cpp -nm=_ZN4llvm3sys2fs6detail15RecDirIterStateD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Stack.$destroy();
      //~RefCountedBase<RecDirIterState>;
      //END JDestroy
    }


    public String toString() {
      return "" + "Stack=" + Stack // NOI18N
                + ", Level=" + Level // NOI18N
                + ", HasNoPushRequest=" + HasNoPushRequest // NOI18N
                + super.toString(); // NOI18N
    }
  }
}
//} JAVA: end of namespace detail

/// directory_iterator - Iterates through the entries in path. There is no
/// operator++ because we need an error_code. If it's really needed we can make
/// it call report_fatal_error on error.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 747,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 731,
 FQN = "llvm::sys::fs::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorE")
//</editor-fold>
public static class directory_iterator implements Destructors.ClassWithDestructor, Native.NativePOD<directory_iterator> {
  private IntrusiveRefCntPtr<detail.DirIterState> State;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 751,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 735,
   FQN = "llvm::sys::fs::directory_iterator::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorC1ERKNS_5TwineERSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorC1ERKNS_5TwineERSt10error_code")
  //</editor-fold>
  public /*explicit*/ directory_iterator(/*const*/ Twine /*&*/ path, std.error_code /*&*/ ec) {
    /* : State()*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.DirIterState>();
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr<detail.DirIterState>(new detail.DirIterState()))));
      SmallString/*128*/ path_storage/*J*/= new SmallString/*128*/(128);
      ec.$assignMove(detail.directory_iterator_construct(State.$star(), 
              path.toStringRef(path_storage)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 758,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 742,
   FQN = "llvm::sys::fs::directory_iterator::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorC1ERKNS1_15directory_entryERSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorC1ERKNS1_15directory_entryERSt10error_code")
  //</editor-fold>
  public /*explicit*/ directory_iterator(/*const*/ directory_entry /*&*/ de, std.error_code /*&*/ ec) {
    /* : State()*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.DirIterState>();
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr<detail.DirIterState>(new detail.DirIterState()))));
      ec.$assignMove(detail.directory_iterator_construct(State.$star(), new StringRef(de.getPath())));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Construct end iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 764,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 748,
   FQN = "llvm::sys::fs::directory_iterator::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorC1Ev")
  //</editor-fold>
  public directory_iterator() {
    /* : State(null)*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.DirIterState>((detail.DirIterState)null);
    //END JInit
  }

  
  // No operator++ because we need error_code.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::increment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 767,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 751,
   FQN = "llvm::sys::fs::directory_iterator::increment", NM = "_ZN4llvm3sys2fs18directory_iterator9incrementERSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iterator9incrementERSt10error_code")
  //</editor-fold>
  public directory_iterator /*&*/ increment(std.error_code /*&*/ ec) {
    ec.$assignMove(detail.directory_iterator_increment(State.$star()));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 772,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 756,
   FQN = "llvm::sys::fs::directory_iterator::operator*", NM = "_ZNK4llvm3sys2fs18directory_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs18directory_iteratordeEv")
  //</editor-fold>
  public /*const*/ directory_entry /*&*/ $star() /*const*/ {
    return State.$arrow().CurrentEntry;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 773,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 757,
   FQN = "llvm::sys::fs::directory_iterator::operator->", NM = "_ZNK4llvm3sys2fs18directory_iteratorptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs18directory_iteratorptEv")
  //</editor-fold>
  public /*const*/ directory_entry /*P*/ $arrow() /*const*/ {
    return $AddrOf(State.$arrow().CurrentEntry);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 775,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 759,
   FQN = "llvm::sys::fs::directory_iterator::operator==", NM = "_ZNK4llvm3sys2fs18directory_iteratoreqERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs18directory_iteratoreqERKS2_")
  //</editor-fold>
  public boolean $eq(/*const*/ directory_iterator /*&*/ RHS) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($eq_IntrusiveRefCntPtr(State, RHS.State)) {
        return true;
      }
      if (!RHS.State.$bool()) {
        return $c$.clean(State.$arrow().CurrentEntry.$eq($c$.track(new directory_entry())));
      }
      if (!State.$bool()) {
        return $c$.clean(RHS.State.$arrow().CurrentEntry.$eq($c$.track(new directory_entry())));
      }
      return State.$arrow().CurrentEntry.$eq(RHS.State.$arrow().CurrentEntry);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 785,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 769,
   FQN = "llvm::sys::fs::directory_iterator::operator!=", NM = "_ZNK4llvm3sys2fs18directory_iteratorneERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs18directory_iteratorneERKS2_")
  //</editor-fold>
  public boolean $noteq(/*const*/ directory_iterator /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 747,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 731,
   FQN = "llvm::sys::fs::directory_iterator::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorC1EOS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorC1EOS2_")
  //</editor-fold>
  public /*inline*/ directory_iterator(JD$Move _dparam, directory_iterator /*&&*/$Prm0) {
    /* : State(static_cast<directory_iterator &&>().State)*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.DirIterState>(JD$Move.INSTANCE, $Prm0.State);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::~directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 747,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 731,
   FQN = "llvm::sys::fs::directory_iterator::~directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    State.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 747,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 731,
   FQN = "llvm::sys::fs::directory_iterator::directory_iterator", NM = "_ZN4llvm3sys2fs18directory_iteratorC1ERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs18directory_iteratorC1ERKS2_")
  //</editor-fold>
  public /*inline*/ directory_iterator(/*const*/ directory_iterator /*&*/ $Prm0) {
    /* : State(.State)*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.DirIterState>($Prm0.State);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::directory_iterator::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 747,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 731,
   FQN = "llvm::sys::fs::directory_iterator::operator=", NM = "_ZN4llvm3sys2fs18directory_iteratoraSERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN4llvm3sys2fs18directory_iteratoraSERKS2_")
  //</editor-fold>
  public /*inline*/ directory_iterator /*&*/ $assign(/*const*/ directory_iterator /*&*/ $Prm0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /// directory_iterator - Iterates through the entries in path. There is no
      /// operator++ because we need an error_code. If it's really needed we can make
      /// it call report_fatal_error on error.
      $c$.clean(this.State.$assign($c$.track(new IntrusiveRefCntPtr<detail.DirIterState>($Prm0.State))));
      return /*Deref*/this;
    } finally {
      $c$.$destroy();
    }
  }

  @Override public directory_iterator clone() { return new directory_iterator(this); }
  
  public String toString() {
    return "" + "State=" + State; // NOI18N
  }
// Other members as required by
// C++ Std, 24.1.1 Input iterators [input.iterators]
}

/// recursive_directory_iterator - Same as directory_iterator except for it
/// recurses down into child directories.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 808,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 792,
 FQN = "llvm::sys::fs::recursive_directory_iterator", NM = "_ZN4llvm3sys2fs28recursive_directory_iteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iteratorE")
//</editor-fold>
public static class recursive_directory_iterator implements Destructors.ClassWithDestructor, Native.NativeComparable<recursive_directory_iterator> {
  private IntrusiveRefCntPtr<detail.RecDirIterState> State;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::recursive_directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 812,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 796,
   FQN = "llvm::sys::fs::recursive_directory_iterator::recursive_directory_iterator", NM = "_ZN4llvm3sys2fs28recursive_directory_iteratorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iteratorC1Ev")
  //</editor-fold>
  public recursive_directory_iterator() {
    /* : State()*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.RecDirIterState>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::recursive_directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 813,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 797,
   FQN = "llvm::sys::fs::recursive_directory_iterator::recursive_directory_iterator", NM = "_ZN4llvm3sys2fs28recursive_directory_iteratorC1ERKNS_5TwineERSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iteratorC1ERKNS_5TwineERSt10error_code")
  //</editor-fold>
  public /*explicit*/ recursive_directory_iterator(/*const*/ Twine /*&*/ path, std.error_code /*&*/ ec) {
    /* : State(new detail::RecDirIterState)*/ 
    //START JInit
    this.State = new IntrusiveRefCntPtr<detail.RecDirIterState>(new detail.RecDirIterState());
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State.$arrow().Stack.push($c$.track(new directory_iterator(path, ec))); $c$.clean();
      if ($c$.clean(State.$arrow().Stack.top().$eq($c$.track(new directory_iterator())))) {
        State.reset();
      }
    } finally {
      $c$.$destroy();
    }
  }

  // No operator++ because we need error_code.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::increment">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 820,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 804,
   FQN = "llvm::sys::fs::recursive_directory_iterator::increment", NM = "_ZN4llvm3sys2fs28recursive_directory_iterator9incrementERSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iterator9incrementERSt10error_code")
  //</editor-fold>
  public fs.recursive_directory_iterator/*&*/ increment(std.error_code /*&*/ ec) {
    /*const*/ directory_iterator end_itr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      end_itr/*J*/= new directory_iterator();
      if (State.$arrow().HasNoPushRequest) {
        State.$arrow().HasNoPushRequest = false;
      } else {
        file_status st/*J*/= new file_status();
        if ((ec.$assignMove(State.$arrow().Stack.top().$arrow().status(st))).$bool()) {
          return /*Deref*/this;
        }
        if (is_directory(new file_status(st))) {
          State.$arrow().Stack.push($c$.track(new directory_iterator(State.$arrow().Stack.top().$star(), ec))); $c$.clean();
          if (ec.$bool()) {
            return /*Deref*/this;
          }
          if (State.$arrow().Stack.top().$noteq(end_itr)) {
            ++State.$arrow().Level;
            return /*Deref*/this;
          }
          State.$arrow().Stack.pop();
        }
      }
      while (!State.$arrow().Stack.empty()
         && State.$arrow().Stack.top().increment(ec).$eq(end_itr)) {
        State.$arrow().Stack.pop();
        --State.$arrow().Level;
      }
      
      // Check if we are done. If so, create an end iterator.
      if (State.$arrow().Stack.empty()) {
        State.reset();
      }
      
      return /*Deref*/this;
    } finally {
      if (end_itr != null) { end_itr.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 852,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 836,
   FQN = "llvm::sys::fs::recursive_directory_iterator::operator*", NM = "_ZNK4llvm3sys2fs28recursive_directory_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iteratordeEv")
  //</editor-fold>
  public /*const*/ directory_entry /*&*/ $star() /*const*/ {
    return State.$arrow().Stack.top().$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 853,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 837,
   FQN = "llvm::sys::fs::recursive_directory_iterator::operator->", NM = "_ZNK4llvm3sys2fs28recursive_directory_iteratorptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iteratorptEv")
  //</editor-fold>
  public /*const*/ directory_entry /*P*/ $arrow() /*const*/ {
    return $AddrOf(State.$arrow().Stack.top().$star());
  }

  
  // observers
  /// Gets the current level. Starting path is at level 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::level">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 857,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 841,
   FQN = "llvm::sys::fs::recursive_directory_iterator::level", NM = "_ZNK4llvm3sys2fs28recursive_directory_iterator5levelEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iterator5levelEv")
  //</editor-fold>
  public int level() /*const*/ {
    return State.$arrow().Level;
  }

  
  /// Returns true if no_push has been called for this directory_entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::no_push_request">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 860,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 844,
   FQN = "llvm::sys::fs::recursive_directory_iterator::no_push_request", NM = "_ZNK4llvm3sys2fs28recursive_directory_iterator15no_push_requestEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iterator15no_push_requestEv")
  //</editor-fold>
  public boolean no_push_request() /*const*/ {
    return State.$arrow().HasNoPushRequest;
  }

  
  // modifiers
  /// Goes up one level if Level > 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::pop">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 864,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 848,
   FQN = "llvm::sys::fs::recursive_directory_iterator::pop", NM = "_ZN4llvm3sys2fs28recursive_directory_iterator3popEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iterator3popEv")
  //</editor-fold>
  public void pop() {
    /*const*/ directory_iterator end_itr = null;
    try {
      assert (State.$bool()) : "Cannot pop an end iterator!";
      assert (State.$arrow().Level > 0) : "Cannot pop an iterator with level < 1";
      
      end_itr/*J*/= new directory_iterator();
      std.error_code ec/*J*/= new std.error_code();
      do {
        if (ec.$bool()) {
          report_fatal_error($("Error incrementing directory iterator."));
        }
        State.$arrow().Stack.pop();
        --State.$arrow().Level;
      } while (!State.$arrow().Stack.empty()
         && State.$arrow().Stack.top().increment(ec).$eq(end_itr));
      
      // Check if we are done. If so, create an end iterator.
      if (State.$arrow().Stack.empty()) {
        State.reset();
      }
    } finally {
      if (end_itr != null) { end_itr.$destroy(); }
    }
  }

  
  /// Does not go down into the current directory_entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::no_push">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 884,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 868,
   FQN = "llvm::sys::fs::recursive_directory_iterator::no_push", NM = "_ZN4llvm3sys2fs28recursive_directory_iterator7no_pushEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iterator7no_pushEv")
  //</editor-fold>
  public void no_push() {
    State.$arrow().HasNoPushRequest = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 886,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 870,
   FQN = "llvm::sys::fs::recursive_directory_iterator::operator==", NM = "_ZNK4llvm3sys2fs28recursive_directory_iteratoreqERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iteratoreqERKS2_")
  //</editor-fold>
  public boolean $eq(/*const*/fs.recursive_directory_iterator/*&*/ RHS) /*const*/ {
    return $eq_IntrusiveRefCntPtr(State, RHS.State);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 890,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 874,
   FQN = "llvm::sys::fs::recursive_directory_iterator::operator!=", NM = "_ZNK4llvm3sys2fs28recursive_directory_iteratorneERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK4llvm3sys2fs28recursive_directory_iteratorneERKS2_")
  //</editor-fold>
  public boolean $noteq(/*const*/fs.recursive_directory_iterator/*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::~recursive_directory_iterator">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 792,
//   FQN="llvm::sys::fs::recursive_directory_iterator::~recursive_directory_iterator", NM="_ZN4llvm3sys2fs28recursive_directory_iteratorD0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iteratorD0Ev")
//  //</editor-fold>
//  public /*inline*/ void $destroy() {
//    /*<<<default destructor>>>*/
//  }



  //<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::recursive_directory_iterator::~recursive_directory_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 808,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 792,
   FQN = "llvm::sys::fs::recursive_directory_iterator::~recursive_directory_iterator", NM = "_ZN4llvm3sys2fs28recursive_directory_iteratorD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN4llvm3sys2fs28recursive_directory_iteratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /// recursive_directory_iterator - Same as directory_iterator except for it
    /// recurses down into child directories.
    //START JDestroy
    State.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "State=" + State; // NOI18N
  }
// Other members as required by
// C++ Std, 24.1.1 Input iterators [input.iterators]
}

/// @brief Make \a path an absolute path.
///
/// Makes \a path absolute using the current directory if it is not already. An
/// empty \a path will result in the current directory.
///
/// /absolute/path   => /absolute/path
/// relative/../path => <current-directory>/relative/../path
///
/// @param path A path that is modified to be an absolute path.
/// @returns errc::success if \a path has been made absolute, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::make_absolute">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 838,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 743,
 FQN="llvm::sys::fs::make_absolute", NM="_ZN4llvm3sys2fs13make_absoluteERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs13make_absoluteERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code make_absolute(SmallString/*&*/ _path) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    make_absolute(Twine.T$EMPTY, _path, false);
}

/// @brief Make \a path an absolute path.
///
/// Makes \a path absolute using the \a current_directory if it is not already.
/// An empty \a path will result in the \a current_directory.
///
/// /absolute/path   => /absolute/path
/// relative/../path => <current-directory>/relative/../path
///
/// @param path A path that is modified to be an absolute path.
/// @returns errc::success if \a path has been made absolute, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::make_absolute">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 833,
 FQN="llvm::sys::fs::make_absolute", NM="_ZN4llvm3sys2fs13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code make_absolute(/*const*/ Twine /*&*/ current_directory, 
             SmallString/*&*/ _path) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    make_absolute(current_directory, 
             _path, false);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::make_absolute">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 776,
 FQN="llvm::sys::fs::make_absolute", NM="_ZN4llvm3sys2fsL13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEEb",
 cmd="jclank.sh -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEEb")
//</editor-fold>
public static std.error_code make_absolute(/*const*/ Twine /*&*/ current_directory, 
             SmallString/*&*/ path, 
             boolean use_current_directory) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    make_absolute(current_directory, path, use_current_directory);  
}

/// @brief Create all the non-existent directories in path.
///
/// @param path Directories to create.
/// @returns errc::success if is_directory(path), otherwise a platform
///          specific error_code. If IgnoreExisting is false, also returns
///          error if the directory already existed.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_directories">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 796,
 FQN = "llvm::sys::fs::create_directories", NM = "_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb")
//</editor-fold>
public static std.error_code create_directories(/*const*/ Twine /*&*/ Path) {
  return create_directories(Path, true);
}
public static std.error_code create_directories(/*const*/ Twine /*&*/ Path, boolean IgnoreExisting/*= true*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    create_directories(Path, IgnoreExisting);
}


/// @brief Create the directory in path.
///
/// @param path Directory to create.
/// @returns errc::success if is_directory(path), otherwise a platform
///          specific error_code. If IgnoreExisting is false, also returns
///          error if the directory already existed.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_directory">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 222,
 FQN = "llvm::sys::fs::create_directory", NM = "_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb")
//</editor-fold>
public static std.error_code create_directory(/*const*/ Twine /*&*/ path) {
  return create_directory(path, true);
}
public static std.error_code create_directory(/*const*/ Twine /*&*/ path, boolean IgnoreExisting/*= true*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    create_directory(path, IgnoreExisting);
}


/// @brief Create a link from \a from to \a to.
///
/// The link may be a soft or a hard link, depending on the platform. The caller
/// may not assume which one. Currently on windows it creates a hard link since
/// soft links require extra privileges. On unix, it creates a soft link since
/// hard links don't work on SMB file systems.
///
/// @param to The path to hard link to.
/// @param from The path to hard link from. This is created.
/// @returns errc::success if the link was created, otherwise a platform
/// specific error_code.

// Note that we are using symbolic link because hard links are not supported by
// all filesystems (SMB doesn't).
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_link">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 237,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 236,
 FQN = "llvm::sys::fs::create_link", NM = "_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code create_link(/*const*/ Twine /*&*/ to, /*const*/ Twine /*&*/ from) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    create_link(to, from);
}


/// @brief Get the current path.
///
/// @param result Holds the current path on return.
/// @returns errc::success if the current path has been stored in result,
///          otherwise a platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::current_path">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 187,
 FQN="llvm::sys::fs::current_path", NM="_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code current_path(SmallString/*&*/ result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    current_path(result);
}


/// @brief Remove path. Equivalent to POSIX remove().
///
/// @param path Input path.
/// @returns errc::success if path has been removed or didn't exist, otherwise a
///          platform-specific error code. If IgnoreNonExisting is false, also
///          returns error if the file didn't exist.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::remove">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 250,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 249,
 FQN = "llvm::sys::fs::remove", NM = "_ZN4llvm3sys2fs6removeERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6removeERKNS_5TwineEb")
//</editor-fold>
public static std.error_code remove(/*const*/ Twine /*&*/ path) {
  return remove(path, true);
}
public static std.error_code remove(/*const*/ Twine /*&*/ path, boolean IgnoreNonExisting/*= true*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    remove(path, IgnoreNonExisting);
}


/// @brief Rename \a from to \a to. Files are renamed as if by POSIX rename().
///
/// @param from The path to rename from.
/// @param to The path to rename to. This is created.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::rename">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 277,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 276,
 FQN = "llvm::sys::fs::rename", NM = "_ZN4llvm3sys2fs6renameERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6renameERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code rename(/*const*/ Twine /*&*/ from, /*const*/ Twine /*&*/ to) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    rename(from, to);
}


/// @brief Copy the contents of \a From to \a To.
///
/// @param From The path to copy from.
/// @param To The path to copy to. This is created.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::copy_file">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 866,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 819,
 FQN = "llvm::sys::fs::copy_file", NM = "_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code copy_file(/*const*/ Twine /*&*/ From, /*const*/ Twine /*&*/ To) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    copy_file(From, To);
}


/// @brief Resize path to size. File is resized as if by POSIX truncate().
///
/// @param FD Input file descriptor.
/// @param Size Size to resize to.
/// @returns errc::success if \a path has been resized to \a size, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::resize_file">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 290,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 289,
 FQN = "llvm::sys::fs::resize_file", NM = "_ZN4llvm3sys2fs11resize_fileEiy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11resize_fileEiy")
//</editor-fold>
public static std.error_code resize_file(int FD, long/*uint64_t*/ Size) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    resize_file(FD, Size);
}


/// @brief Does file exist?
///
/// @param status A file_status previously returned from stat.
/// @returns True if the file represented by status exists, false if it does
///          not.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::exists">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 900,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 853,
 FQN = "llvm::sys::fs::exists", NM = "_ZN4llvm3sys2fs6existsENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6existsENS1_11file_statusE")
//</editor-fold>
public static boolean exists(file_status status) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    exists(status);
}


/// @brief Can the file be accessed?
///
/// @param Path Input path.
/// @returns errc::success if the path can be accessed, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::access">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 309,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 308,
 FQN = "llvm::sys::fs::access", NM = "_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE")
//</editor-fold>
public static std.error_code access(/*const*/ Twine /*&*/ Path, AccessMode Mode) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    access(Path, Mode);
}


/// @brief Do file_status's represent the same thing?
///
/// @param A Input file_status.
/// @param B Input file_status.
///
/// assert(status_known(A) || status_known(B));
///
/// @returns True if A and B both represent the same file system entity, false
///          otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 332,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 327,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_")
//</editor-fold>
public static boolean equivalent(file_status A, file_status B) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    equivalent(A, B);
}


/// @brief Do paths represent the same thing?
///
/// assert(status_known(A) || status_known(B));
///
/// @param A Input path A.
/// @param B Input path B.
/// @param result Set to true if stat(A) and stat(B) have the same device and
///               inode (or equivalent).
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 338,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 333,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb")
//</editor-fold>
public static std.error_code equivalent(/*const*/ Twine /*&*/ A, /*const*/ Twine /*&*/ B, bool$ref/*bool &*/ result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    equivalent(A, B, result);
}


/// @brief Does status represent a directory?
///
/// @param status A file_status previously returned from status.
/// @returns status.type() == file_type::directory_file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 908,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 861,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE")
//</editor-fold>
public static boolean is_directory(file_status status) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_directory(status);
}


/// @brief Is path a directory?
///
/// @param path Input path.
/// @param result Set to true if \a path is a directory, false if it is not.
///               Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 912,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 865,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_directory(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_directory(path, result);
}


/// @brief Does status represent a regular file?
///
/// @param status A file_status previously returned from status.
/// @returns status_known(status) && status.type() == file_type::regular_file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 920,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 873,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE")
//</editor-fold>
public static boolean is_regular_file(file_status status) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_regular_file(status);
}


/// @brief Is path a regular file?
///
/// @param path Input path.
/// @param result Set to true if \a path is a regular file, false if it is not.
///               Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 924,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 877,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_regular_file(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_regular_file(path, result);
}


/// @brief Does this status represent something that exists but is not a
///        directory, regular file, or symlink?
///
/// @param status A file_status previously returned from status.
/// @returns exists(s) && !is_regular_file(s) && !is_directory(s)
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_other">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 932,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 885,
 FQN = "llvm::sys::fs::is_other", NM = "_ZN4llvm3sys2fs8is_otherENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8is_otherENS1_11file_statusE")
//</editor-fold>
public static boolean is_other(file_status status) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_other(status);
}


/// @brief Is path something that exists but is not a directory,
///        regular file, or symlink?
///
/// @param path Input path.
/// @param result Set to true if \a path exists, but is not a directory, regular
///               file, or a symlink, false if it does not. Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_other">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 938,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 891,
 FQN = "llvm::sys::fs::is_other", NM = "_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_other(/*const*/ Twine /*&*/ Path, bool$ref/*bool &*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    is_other(Path, Result);
}


/// @brief Get file status as if by POSIX stat().
///
/// @param path Input path.
/// @param result Set to the file status.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 382,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 377,
 FQN = "llvm::sys::fs::status", NM = "_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE")
//</editor-fold>
public static std.error_code status(/*const*/ Twine /*&*/ Path, file_status /*&*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    status(Path, Result);
}


/// @brief A version for when a file descriptor is already available.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 391,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 386,
 FQN = "llvm::sys::fs::status", NM = "_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE")
//</editor-fold>
public static std.error_code status(int FD, file_status /*&*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    status(FD, Result);
}


/// @brief Set the file modification and access time.
///
/// @returns errc::success if the file times were successfully set, otherwise a
///          platform-specific error_code or errc::function_not_supported on
///          platforms where the functionality isn't available.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::setLastModificationAndAccessTime">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 397,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 392,
 FQN = "llvm::sys::fs::setLastModificationAndAccessTime", NM = "_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE")
//</editor-fold>
public static std.error_code setLastModificationAndAccessTime(int FD, TimeValue Time) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    setLastModificationAndAccessTime(FD, Time);
}


/// @brief Is status available?
///
/// @param s Input file status.
/// @returns True if status() != status_error.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status_known">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 904,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 857,
 FQN = "llvm::sys::fs::status_known", NM = "_ZN4llvm3sys2fs12status_knownENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12status_knownENS1_11file_statusE")
//</editor-fold>
public static boolean status_known(file_status s) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    status_known(s);
}


/// @brief Create a uniquely named file.
///
/// Generates a unique path suitable for a temporary file and then opens it as a
/// file. The name is based on \a model with '%' replaced by a random char in
/// [0-9a-f]. If \a model is not an absolute path, a suitable temporary
/// directory will be prepended.
///
/// Example: clang-%%-%%-%%-%%-%%.s => clang-a0-b1-c2-d3-e4.s
///
/// This is an atomic operation. Either the file is created and opened, or the
/// file system is left untouched.
///
/// The intendend use is for files that are to be kept, possibly after
/// renaming them. For example, when running 'clang -c foo.o', the file can
/// be first created as foo-abc123.o and then renamed.
///
/// @param Model Name to base unique path off of.
/// @param ResultFD Set to the opened file's file descriptor.
/// @param ResultPath Set to the opened file's absolute path.
/// @returns errc::success if Result{FD,Path} have been successfully set,
///          otherwise a platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 722,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 689,
 FQN = "llvm::sys::fs::createUniqueFile", NM = "_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj")
//</editor-fold>
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFd, 
                SmallString/*&*/ ResultPath) {
  return createUniqueFile(Model, ResultFd, 
                ResultPath, 
                $bitor_perms(perms.all_read, perms.all_write));
}
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFd, 
                SmallString/*&*/ ResultPath, 
                /*uint*/int Mode/*= all_read | all_write*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    createUniqueFile(Model, ResultFd, 
                ResultPath, 
                Mode);
}


/// @brief Simpler version for clients that don't want an open file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 728,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 695,
 FQN = "llvm::sys::fs::createUniqueFile", NM = "_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, 
                SmallString/*&*/ ResultPath) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    createUniqueFile(Model, 
                ResultPath);
}


/// @brief Create a file in the system temporary directory.
///
/// The filename is of the form prefix-random_chars.suffix. Since the directory
/// is not know to the caller, Prefix and Suffix cannot have path separators.
/// The files are created with mode 0600.
///
/// This should be used for things like a temporary .s that is removed after
/// running the assembler.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 754,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 721,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, 
                   int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    createTemporaryFile(Prefix, Suffix, 
                   ResultFD, 
                   ResultPath);
}


/// @brief Simpler version for clients that don't want an open file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 760,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 727,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, 
                   SmallString/*&*/ ResultPath) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    createTemporaryFile(Prefix, Suffix, 
                   ResultPath);
}


// This is a mkdtemp with a different pattern. We use createUniqueEntity mostly
// for consistency. We should try using mkdtemp.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueDirectory">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 769,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 736,
 FQN = "llvm::sys::fs::createUniqueDirectory", NM = "_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createUniqueDirectory(/*const*/ Twine /*&*/ Prefix, 
                     SmallString/*&*/ ResultPath) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    createUniqueDirectory(Prefix, 
                     ResultPath);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::openFileForWrite">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 519,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 514,
 FQN = "llvm::sys::fs::openFileForWrite", NM = "_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj")
//</editor-fold>
public static std.error_code openFileForWrite(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
                /*fs.OpenFlags*/int Flags) {
  return openFileForWrite(Name, ResultFD, 
                Flags, 0666);
}
public static std.error_code openFileForWrite(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
                /*fs.OpenFlags*/int Flags, /*uint*/int Mode/*= 0666*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    openFileForWrite(Name, ResultFD, 
                Flags, Mode);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::openFileForRead">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 560,
 FQN="llvm::sys::fs::openFileForRead", NM="_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERiPNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERiPNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code openFileForRead(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD) {
  return openFileForRead(Name, ResultFD, 
               (SmallString/*P*/ )null);
}
public static std.error_code openFileForRead(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
               SmallString/*P*/ RealPath/*= null*/) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    openFileForRead(Name, ResultFD, RealPath);
}


/// @brief Identify the type of a binary file based on how magical it is.

/// @brief Identify the magic in magic.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::identify_magic">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 954,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 908,
 FQN = "llvm::sys::fs::identify_magic", NM = "_ZN4llvm3sys2fs14identify_magicENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs14identify_magicENS_9StringRefE")
//</editor-fold>
public static file_magic identify_magic(StringRef Magic) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    identify_magic(Magic);
}


/// @brief Get and identify \a path's type based on its content.
///
/// @param path Input path.
/// @param result Set to the type of file, or file_magic::unknown.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::identify_magic">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 1103,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 1056,
 FQN = "llvm::sys::fs::identify_magic", NM = "_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE")
//</editor-fold>
public static std.error_code identify_magic(/*const*/ Twine /*&*/ Path, file_magic /*&*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    identify_magic(Path, Result);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getUniqueID">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 713,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 680,
 FQN = "llvm::sys::fs::getUniqueID", NM = "_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE")
//</editor-fold>
public static std.error_code getUniqueID(/*const*/ Twine Path, UniqueID /*&*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    getUniqueID(Path, Result);
}


/// Return the path to the main executable, given the value of argv[0] from
/// program startup and the address of main itself. In extremis, this function
/// may fail and return an empty path.
// __FreeBSD__ || __NetBSD__ || __FreeBSD_kernel__

/// GetMainExecutable - Return the path to the main executable, given the
/// value of argv[0] from program startup.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getMainExecutable">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 127,
 FQN="llvm::sys::fs::getMainExecutable", NM="_ZN4llvm3sys2fs17getMainExecutableEPKcPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs17getMainExecutableEPKcPv")
//</editor-fold>
public static std.string getMainExecutable(/*const*/char$ptr/*char P*/ argv0, Object/*void P*/ MainAddr) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsGlobals.
    getMainExecutable(argv0, MainAddr);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 734,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 701,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath, FSEntity Type) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    createTemporaryFile(Model, ResultFD, 
                   ResultPath, Type);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 746,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 713,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath, FSEntity Type) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    createTemporaryFile(Prefix, Suffix, ResultFD, 
                   ResultPath, Type);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::test_dir">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 71,
 FQN="llvm::sys::fs::test_dir", NM="_ZN4llvm3sys2fsL8test_dirEPcPKcS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL8test_dirEPcPKcS4_")
//</editor-fold>
public static int test_dir(/*char*/byte ret[/*4096*/], /*const*/char$ptr/*char P*/ dir, /*const*/char$ptr/*char P*/ bin) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    test_dir(ret, dir, bin);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getprogpath">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 86,
 FQN="llvm::sys::fs::getprogpath", NM="_ZN4llvm3sys2fsL11getprogpathEPcPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL11getprogpathEPcPKc")
//</editor-fold>
public static char$ptr/*char P*/ getprogpath(/*char*/byte ret[/*4096*/], /*const*/char$ptr/*char P*/ bin) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    getprogpath(ret, bin);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::convertAccessMode">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 297,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 296,
 FQN = "llvm::sys::fs::convertAccessMode", NM = "_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE")
//</editor-fold>
public static int convertAccessMode(AccessMode Mode) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    convertAccessMode(Mode);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::fillStatus">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 348,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 343,
 FQN = "llvm::sys::fs::fillStatus", NM = "_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE")
//</editor-fold>
public static std.error_code fillStatus(int StatRet, /*const*/  stat /*&*/ Status, 
          file_status /*&*/ Result) {
  return /*delegate*/org.llvm.support.sys.impl.PathFsStatics.
    fillStatus(StatRet, Status, 
          Result);
}

/// @brief Is status available?
///
/// @param path Input path.
/// @param result Set to true if status() != status_error.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status_known">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 543,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 527,
 FQN = "llvm::sys::fs::status_known", NM = "_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb")
//</editor-fold>
public static std.error_code status_known(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}
} // END OF class fs
