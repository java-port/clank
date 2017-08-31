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

package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.support.sys.TimeValue;

//<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 28,
 FQN="llvm::object::ArchiveMemberHeader", NM="_ZN4llvm6object19ArchiveMemberHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object19ArchiveMemberHeaderE")
//</editor-fold>
public class/*struct*/ ArchiveMemberHeader {
  public /*char*/byte Name[/*16*/] = new$char(16);
  public /*char*/byte LastModified[/*12*/] = new$char(12);
  public /*char*/byte UID[/*6*/] = new$char(6);
  public /*char*/byte GID[/*6*/] = new$char(6);
  public /*char*/byte AccessMode[/*8*/] = new$char(8);
  public /*char*/byte Size[/*10*/] = new$char(10); ///< Size of data, not including header or padding.
  public /*char*/byte Terminator[/*2*/] = new$char(2);
  
  /// Get the name without looking up long names.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 38,
   FQN="llvm::object::ArchiveMemberHeader::getName", NM="_ZNK4llvm6object19ArchiveMemberHeader7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Members are not larger than 4GB.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 41,
   FQN="llvm::object::ArchiveMemberHeader::getSize", NM="_ZNK4llvm6object19ArchiveMemberHeader7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader7getSizeEv")
  //</editor-fold>
  public ErrorOrUInt getSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getAccessMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 43,
   FQN="llvm::object::ArchiveMemberHeader::getAccessMode", NM="_ZNK4llvm6object19ArchiveMemberHeader13getAccessModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader13getAccessModeEv")
  //</editor-fold>
  public /*fs.perms*/int getAccessMode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getLastModified">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 44,
   FQN="llvm::object::ArchiveMemberHeader::getLastModified", NM="_ZNK4llvm6object19ArchiveMemberHeader15getLastModifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader15getLastModifiedEv")
  //</editor-fold>
  public TimeValue getLastModified() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getRawLastModified">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 45,
   FQN="llvm::object::ArchiveMemberHeader::getRawLastModified", NM="_ZNK4llvm6object19ArchiveMemberHeader18getRawLastModifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader18getRawLastModifiedEv")
  //</editor-fold>
  public StringRef getRawLastModified() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getUID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 48,
   FQN="llvm::object::ArchiveMemberHeader::getUID", NM="_ZNK4llvm6object19ArchiveMemberHeader6getUIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader6getUIDEv")
  //</editor-fold>
  public /*uint*/int getUID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ArchiveMemberHeader::getGID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 49,
   FQN="llvm::object::ArchiveMemberHeader::getGID", NM="_ZNK4llvm6object19ArchiveMemberHeader6getGIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object19ArchiveMemberHeader6getGIDEv")
  //</editor-fold>
  public /*uint*/int getGID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", LastModified=" + LastModified // NOI18N
              + ", UID=" + UID // NOI18N
              + ", GID=" + GID // NOI18N
              + ", AccessMode=" + AccessMode // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Terminator=" + Terminator; // NOI18N
  }
}
