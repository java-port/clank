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
import org.llvm.ir.LLVMContext;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.support.sys.TimeValue;

//<editor-fold defaultstate="collapsed" desc="llvm::object::Archive">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 52,
 FQN="llvm::object::Archive", NM="_ZN4llvm6object7ArchiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7ArchiveE")
//</editor-fold>
public class Archive extends /*public*/ Binary implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 53,
   FQN="llvm::object::Archive::anchor", NM="_ZN4llvm6object7Archive6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6anchorEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 55,
   FQN="llvm::object::Archive::Child", NM="_ZN4llvm6object7Archive5ChildE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildE")
  //</editor-fold>
  public static class Child implements Native.NativeComparable<Child> {
    /*friend  Archive*/
    private /*const*/ Archive /*P*/ Parent;
    /// \brief Includes header but not padding byte.
    private StringRef Data;
    /// \brief Offset from Data to the start of the file.
    private /*uint16_t*/char StartOfFile;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getHeader">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 63,
     FQN="llvm::object::Archive::Child::getHeader", NM="_ZNK4llvm6object7Archive5Child9getHeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child9getHeaderEv")
    //</editor-fold>
    private /*const*/ ArchiveMemberHeader /*P*/ getHeader() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::isThinMember">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 67,
     FQN="llvm::object::Archive::Child::isThinMember", NM="_ZNK4llvm6object7Archive5Child12isThinMemberEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child12isThinMemberEv")
    //</editor-fold>
    private boolean isThinMember() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::Child">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 70,
     FQN="llvm::object::Archive::Child::Child", NM="_ZN4llvm6object7Archive5ChildC1EPKS1_PKcPSt10error_code",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildC1EPKS1_PKcPSt10error_code")
    //</editor-fold>
    public Child(/*const*/ Archive /*P*/ Parent, /*const*/char$ptr/*char P*/ Start, std.error_code /*P*/ EC) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::Child">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 71,
     FQN="llvm::object::Archive::Child::Child", NM="_ZN4llvm6object7Archive5ChildC1EPKS1_NS_9StringRefEt",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildC1EPKS1_NS_9StringRefEt")
    //</editor-fold>
    public Child(/*const*/ Archive /*P*/ Parent, StringRef Data, /*uint16_t*/char StartOfFile) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 73,
     FQN="llvm::object::Archive::Child::operator==", NM="_ZNK4llvm6object7Archive5ChildeqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5ChildeqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ Child /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getParent">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 78,
     FQN="llvm::object::Archive::Child::getParent", NM="_ZNK4llvm6object7Archive5Child9getParentEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child9getParentEv")
    //</editor-fold>
    public /*const*/ Archive /*P*/ getParent() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getNext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 79,
     FQN="llvm::object::Archive::Child::getNext", NM="_ZNK4llvm6object7Archive5Child7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child7getNextEv")
    //</editor-fold>
    public ErrorOr<Child> getNext() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 81,
     FQN="llvm::object::Archive::Child::getName", NM="_ZNK4llvm6object7Archive5Child7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child7getNameEv")
    //</editor-fold>
    public ErrorOr<StringRef> getName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getFullName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 82,
     FQN="llvm::object::Archive::Child::getFullName", NM="_ZNK4llvm6object7Archive5Child11getFullNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child11getFullNameEv")
    //</editor-fold>
    public ErrorOr<std.string> getFullName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getRawName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 83,
     FQN="llvm::object::Archive::Child::getRawName", NM="_ZNK4llvm6object7Archive5Child10getRawNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child10getRawNameEv")
    //</editor-fold>
    public StringRef getRawName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getLastModified">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 84,
     FQN="llvm::object::Archive::Child::getLastModified", NM="_ZNK4llvm6object7Archive5Child15getLastModifiedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child15getLastModifiedEv")
    //</editor-fold>
    public TimeValue getLastModified() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getRawLastModified">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 87,
     FQN="llvm::object::Archive::Child::getRawLastModified", NM="_ZNK4llvm6object7Archive5Child18getRawLastModifiedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child18getRawLastModifiedEv")
    //</editor-fold>
    public StringRef getRawLastModified() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getUID">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 90,
     FQN="llvm::object::Archive::Child::getUID", NM="_ZNK4llvm6object7Archive5Child6getUIDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child6getUIDEv")
    //</editor-fold>
    public /*uint*/int getUID() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getGID">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 91,
     FQN="llvm::object::Archive::Child::getGID", NM="_ZNK4llvm6object7Archive5Child6getGIDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child6getGIDEv")
    //</editor-fold>
    public /*uint*/int getGID() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getAccessMode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 92,
     FQN="llvm::object::Archive::Child::getAccessMode", NM="_ZNK4llvm6object7Archive5Child13getAccessModeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child13getAccessModeEv")
    //</editor-fold>
    public /*fs.perms*/int getAccessMode() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// \return the size of the archive member without the header or padding.
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getSize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 96,
     FQN="llvm::object::Archive::Child::getSize", NM="_ZNK4llvm6object7Archive5Child7getSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child7getSizeEv")
    //</editor-fold>
    public ErrorOrULong getSize() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    /// \return the size in the archive header for this member.
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getRawSize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 98,
     FQN="llvm::object::Archive::Child::getRawSize", NM="_ZNK4llvm6object7Archive5Child10getRawSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child10getRawSizeEv")
    //</editor-fold>
    public ErrorOrULong getRawSize() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getBuffer">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 100,
     FQN="llvm::object::Archive::Child::getBuffer", NM="_ZNK4llvm6object7Archive5Child9getBufferEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child9getBufferEv")
    //</editor-fold>
    public ErrorOr<StringRef> getBuffer() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getChildOffset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 101,
     FQN="llvm::object::Archive::Child::getChildOffset", NM="_ZNK4llvm6object7Archive5Child14getChildOffsetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child14getChildOffsetEv")
    //</editor-fold>
    public long/*uint64_t*/ getChildOffset() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getMemoryBufferRef">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 103,
     FQN="llvm::object::Archive::Child::getMemoryBufferRef", NM="_ZNK4llvm6object7Archive5Child18getMemoryBufferRefEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child18getMemoryBufferRefEv")
    //</editor-fold>
    public ErrorOr<MemoryBufferRef> getMemoryBufferRef() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::getAsBinary">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 105,
     FQN="llvm::object::Archive::Child::getAsBinary", NM="_ZNK4llvm6object7Archive5Child11getAsBinaryEPNS_11LLVMContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive5Child11getAsBinaryEPNS_11LLVMContextE")
    //</editor-fold>
    public Expected<std.unique_ptr<Binary> > getAsBinary() /*const*/ {
      return getAsBinary((LLVMContext /*P*/ )null);
    }
    public Expected<std.unique_ptr<Binary> > getAsBinary(LLVMContext /*P*/ Context/*= null*/) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::Child">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 55,
     FQN="llvm::object::Archive::Child::Child", NM="_ZN4llvm6object7Archive5ChildC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Child(final /*const*/ Child /*&*/ $Prm0) {
      // : Parent(.Parent), Data(.Data), StartOfFile(.StartOfFile) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::Child">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 55,
     FQN="llvm::object::Archive::Child::Child", NM="_ZN4llvm6object7Archive5ChildC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildC1EOS2_")
    //</editor-fold>
    public /*inline*/ Child(JD$Move _dparam, final Child /*&&*/$Prm0) {
      // : Parent(static_cast<Child &&>().Parent), Data(static_cast<Child &&>().Data), StartOfFile(static_cast<Child &&>().StartOfFile) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 55,
     FQN="llvm::object::Archive::Child::operator=", NM="_ZN4llvm6object7Archive5ChildaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildaSERKS2_")
    //</editor-fold>
    public /*inline*/ Child /*&*/ $assign(final /*const*/ Child /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Child::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 55,
     FQN="llvm::object::Archive::Child::operator=", NM="_ZN4llvm6object7Archive5ChildaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive5ChildaSEOS2_")
    //</editor-fold>
    public /*inline*/ Child /*&*/ $assignMove(final Child /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Parent=" + Parent // NOI18N
                + ", Data=" + Data // NOI18N
                + ", StartOfFile=" + $ushort2uint(StartOfFile); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 109,
   FQN="llvm::object::Archive::child_iterator", NM="_ZN4llvm6object7Archive14child_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive14child_iteratorE")
  //</editor-fold>
  public static class child_iterator implements Native.NativeComparable<child_iterator> {
    private Child C;
    private Error /*P*/ E;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::child_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 114,
     FQN="llvm::object::Archive::child_iterator::child_iterator", NM="_ZN4llvm6object7Archive14child_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive14child_iteratorC1Ev")
    //</editor-fold>
    public child_iterator() {
      // : C(Child(null, null, null)), E(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::child_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 115,
     FQN="llvm::object::Archive::child_iterator::child_iterator", NM="_ZN4llvm6object7Archive14child_iteratorC1ERKNS1_5ChildEPNS_5ErrorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive14child_iteratorC1ERKNS1_5ChildEPNS_5ErrorE")
    //</editor-fold>
    public child_iterator(final /*const*/ Child /*&*/ C, Error /*P*/ E) {
      // : C(C), E(E) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 116,
     FQN="llvm::object::Archive::child_iterator::operator->", NM="_ZNK4llvm6object7Archive14child_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14child_iteratorptEv")
    //</editor-fold>
    public /*const*/ Child /*P*/ $arrow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 117,
     FQN="llvm::object::Archive::child_iterator::operator*", NM="_ZNK4llvm6object7Archive14child_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14child_iteratordeEv")
    //</editor-fold>
    public /*const*/ Child /*&*/ $star() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 119,
     FQN="llvm::object::Archive::child_iterator::operator==", NM="_ZNK4llvm6object7Archive14child_iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14child_iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ child_iterator /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 126,
     FQN="llvm::object::Archive::child_iterator::operator!=", NM="_ZNK4llvm6object7Archive14child_iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14child_iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ child_iterator /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    // Code in loops with child_iterators must check for errors on each loop
    // iteration.  And if there is an error break out of the loop.
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 132,
     FQN="llvm::object::Archive::child_iterator::operator++", NM="_ZN4llvm6object7Archive14child_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive14child_iteratorppEv")
    //</editor-fold>
    public child_iterator /*&*/ $preInc() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_iterator::child_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 109,
     FQN="llvm::object::Archive::child_iterator::child_iterator", NM="_ZN4llvm6object7Archive14child_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive14child_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ child_iterator(JD$Move _dparam, final child_iterator /*&&*/$Prm0) {
      // : C(static_cast<child_iterator &&>().C), E(static_cast<child_iterator &&>().E) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "C=" + C // NOI18N
                + ", E=" + E; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 146,
   FQN="llvm::object::Archive::Symbol", NM="_ZN4llvm6object7Archive6SymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6SymbolE")
  //</editor-fold>
  public static class Symbol implements Native.NativeComparable<Symbol> {
    private /*const*/ Archive /*P*/ Parent;
    private /*uint32_t*/int SymbolIndex;
    private /*uint32_t*/int StringIndex; // Extra index to the string.
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 152,
     FQN="llvm::object::Archive::Symbol::operator==", NM="_ZNK4llvm6object7Archive6SymboleqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive6SymboleqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ Symbol /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::Symbol">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 156,
     FQN="llvm::object::Archive::Symbol::Symbol", NM="_ZN4llvm6object7Archive6SymbolC1EPKS1_jj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6SymbolC1EPKS1_jj")
    //</editor-fold>
    public Symbol(/*const*/ Archive /*P*/ p, /*uint32_t*/int symi, /*uint32_t*/int stri) {
      // : Parent(p), SymbolIndex(symi), StringIndex(stri) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::getName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 160,
     FQN="llvm::object::Archive::Symbol::getName", NM="_ZNK4llvm6object7Archive6Symbol7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive6Symbol7getNameEv")
    //</editor-fold>
    public StringRef getName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::getMember">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 161,
     FQN="llvm::object::Archive::Symbol::getMember", NM="_ZNK4llvm6object7Archive6Symbol9getMemberEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive6Symbol9getMemberEv")
    //</editor-fold>
    public ErrorOr<Child> getMember() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::getNext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 162,
     FQN="llvm::object::Archive::Symbol::getNext", NM="_ZNK4llvm6object7Archive6Symbol7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive6Symbol7getNextEv")
    //</editor-fold>
    public Symbol getNext() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::Symbol">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 146,
     FQN="llvm::object::Archive::Symbol::Symbol", NM="_ZN4llvm6object7Archive6SymbolC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6SymbolC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Symbol(final /*const*/ Symbol /*&*/ $Prm0) {
      // : Parent(.Parent), SymbolIndex(.SymbolIndex), StringIndex(.StringIndex) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::Symbol">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 146,
     FQN="llvm::object::Archive::Symbol::Symbol", NM="_ZN4llvm6object7Archive6SymbolC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6SymbolC1EOS2_")
    //</editor-fold>
    public /*inline*/ Symbol(JD$Move _dparam, final Symbol /*&&*/$Prm0) {
      // : Parent(static_cast<Symbol &&>().Parent), SymbolIndex(static_cast<Symbol &&>().SymbolIndex), StringIndex(static_cast<Symbol &&>().StringIndex) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Symbol::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 146,
     FQN="llvm::object::Archive::Symbol::operator=", NM="_ZN4llvm6object7Archive6SymbolaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6SymbolaSEOS2_")
    //</editor-fold>
    public /*inline*/ Symbol /*&*/ $assignMove(final Symbol /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Parent=" + Parent // NOI18N
                + ", SymbolIndex=" + SymbolIndex // NOI18N
                + ", StringIndex=" + StringIndex; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 165,
   FQN="llvm::object::Archive::symbol_iterator", NM="_ZN4llvm6object7Archive15symbol_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15symbol_iteratorE")
  //</editor-fold>
  public static class symbol_iterator implements Native.NativeComparable<symbol_iterator> {
    private Symbol symbol;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 168,
     FQN="llvm::object::Archive::symbol_iterator::symbol_iterator", NM="_ZN4llvm6object7Archive15symbol_iteratorC1ERKNS1_6SymbolE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15symbol_iteratorC1ERKNS1_6SymbolE")
    //</editor-fold>
    public symbol_iterator(final /*const*/ Symbol /*&*/ s) {
      // : symbol(s) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 169,
     FQN="llvm::object::Archive::symbol_iterator::operator->", NM="_ZNK4llvm6object7Archive15symbol_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive15symbol_iteratorptEv")
    //</editor-fold>
    public /*const*/ Symbol /*P*/ $arrow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 170,
     FQN="llvm::object::Archive::symbol_iterator::operator*", NM="_ZNK4llvm6object7Archive15symbol_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive15symbol_iteratordeEv")
    //</editor-fold>
    public /*const*/ Symbol /*&*/ $star() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 172,
     FQN="llvm::object::Archive::symbol_iterator::operator==", NM="_ZNK4llvm6object7Archive15symbol_iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive15symbol_iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ symbol_iterator /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 176,
     FQN="llvm::object::Archive::symbol_iterator::operator!=", NM="_ZNK4llvm6object7Archive15symbol_iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive15symbol_iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ symbol_iterator /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 180,
     FQN="llvm::object::Archive::symbol_iterator::operator++", NM="_ZN4llvm6object7Archive15symbol_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15symbol_iteratorppEv")
    //</editor-fold>
    public symbol_iterator /*&*/ $preInc() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_iterator::symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 165,
     FQN="llvm::object::Archive::symbol_iterator::symbol_iterator", NM="_ZN4llvm6object7Archive15symbol_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15symbol_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ symbol_iterator(JD$Move _dparam, final symbol_iterator /*&&*/$Prm0) {
      // : symbol(static_cast<symbol_iterator &&>().symbol) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "symbol=" + symbol; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Archive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 186,
   FQN="llvm::object::Archive::Archive", NM="_ZN4llvm6object7ArchiveC1ENS_15MemoryBufferRefERNS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7ArchiveC1ENS_15MemoryBufferRefERNS_5ErrorE")
  //</editor-fold>
  public Archive(MemoryBufferRef Source, final Error /*&*/ Err) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 187,
   FQN="llvm::object::Archive::create", NM="_ZN4llvm6object7Archive6createENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive6createENS_15MemoryBufferRefE")
  //</editor-fold>
  public static Expected<std.unique_ptr<Archive> > create(MemoryBufferRef Source) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 189,
   FQN="llvm::object::Archive::Kind", NM="_ZN4llvm6object7Archive4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive4KindE")
  //</editor-fold>
  public enum Kind implements Native.NativeUIntEnum {
    K_GNU(0),
    K_MIPS64(K_GNU.getValue() + 1),
    K_BSD(K_MIPS64.getValue() + 1),
    K_DARWIN64(K_BSD.getValue() + 1),
    K_COFF(K_DARWIN64.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::kind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 197,
   FQN="llvm::object::Archive::kind", NM="_ZNK4llvm6object7Archive4kindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive4kindEv")
  //</editor-fold>
  public Kind kind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::isThin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 198,
   FQN="llvm::object::Archive::isThin", NM="_ZNK4llvm6object7Archive6isThinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive6isThinEv")
  //</editor-fold>
  public boolean isThin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 200,
   FQN="llvm::object::Archive::child_begin", NM="_ZNK4llvm6object7Archive11child_beginERNS_5ErrorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive11child_beginERNS_5ErrorEb")
  //</editor-fold>
  public child_iterator child_begin(final Error /*&*/ Err) /*const*/ {
    return child_begin(Err, true);
  }
  public child_iterator child_begin(final Error /*&*/ Err, boolean SkipInternal/*= true*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::child_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 201,
   FQN="llvm::object::Archive::child_end", NM="_ZNK4llvm6object7Archive9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive9child_endEv")
  //</editor-fold>
  public child_iterator child_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::children">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 202,
   FQN="llvm::object::Archive::children", NM="_ZNK4llvm6object7Archive8childrenERNS_5ErrorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive8childrenERNS_5ErrorEb")
  //</editor-fold>
  public iterator_range</*const*/ Child /*&*/ > children(final Error /*&*/ Err) /*const*/ {
    return children(Err, 
          true);
  }
  public iterator_range</*const*/ Child /*&*/ > children(final Error /*&*/ Err, 
          boolean SkipInternal/*= true*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 207,
   FQN="llvm::object::Archive::symbol_begin", NM="_ZNK4llvm6object7Archive12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive12symbol_beginEv")
  //</editor-fold>
  public symbol_iterator symbol_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbol_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 208,
   FQN="llvm::object::Archive::symbol_end", NM="_ZNK4llvm6object7Archive10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive10symbol_endEv")
  //</editor-fold>
  public symbol_iterator symbol_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::symbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 209,
   FQN="llvm::object::Archive::symbols", NM="_ZNK4llvm6object7Archive7symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive7symbolsEv")
  //</editor-fold>
  public iterator_range</*const*/ Symbol /*&*/ > symbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Cast methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 214,
   FQN="llvm::object::Archive::classof", NM="_ZN4llvm6object7Archive7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // check if a symbol is in the archive
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::findSym">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 219,
   FQN="llvm::object::Archive::findSym", NM="_ZNK4llvm6object7Archive7findSymENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive7findSymENS_9StringRefE")
  //</editor-fold>
  public Expected<Optional<Child> > findSym(StringRef name) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::hasSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 221,
   FQN="llvm::object::Archive::hasSymbolTable", NM="_ZNK4llvm6object7Archive14hasSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14hasSymbolTableEv")
  //</editor-fold>
  public boolean hasSymbolTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::getSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 222,
   FQN="llvm::object::Archive::getSymbolTable", NM="_ZNK4llvm6object7Archive14getSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive14getSymbolTableEv")
  //</editor-fold>
  public StringRef getSymbolTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::getNumberOfSymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 223,
   FQN="llvm::object::Archive::getNumberOfSymbols", NM="_ZNK4llvm6object7Archive18getNumberOfSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object7Archive18getNumberOfSymbolsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumberOfSymbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::takeThinBuffers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 225,
   FQN="llvm::object::Archive::takeThinBuffers", NM="_ZN4llvm6object7Archive15takeThinBuffersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15takeThinBuffersEv")
  //</editor-fold>
  public std.vector<std.unique_ptr<MemoryBuffer>> takeThinBuffers() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private StringRef SymbolTable;
  private StringRef StringTable;
  
  private StringRef FirstRegularData;
  private /*uint16_t*/char FirstRegularStartOfFile/* = -1*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::setFirstRegular">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 235,
   FQN="llvm::object::Archive::setFirstRegular", NM="_ZN4llvm6object7Archive15setFirstRegularERKNS1_5ChildE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7Archive15setFirstRegularERKNS1_5ChildE")
  //</editor-fold>
  private void setFirstRegular(final /*const*/ Child /*&*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  private /*JBYTE unsigned int*/ byte Format /*: 3*/;
  private /*JBIT unsigned int*/ boolean IsThin /*: 1*/;
  private /*mutable */std.vector<std.unique_ptr<MemoryBuffer>> ThinBuffers;
  //<editor-fold defaultstate="collapsed" desc="llvm::object::Archive::~Archive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/Archive.h", line = 52,
   FQN="llvm::object::Archive::~Archive", NM="_ZN4llvm6object7ArchiveD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object7ArchiveD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "SymbolTable=" + SymbolTable // NOI18N
              + ", StringTable=" + StringTable // NOI18N
              + ", FirstRegularData=" + FirstRegularData // NOI18N
              + ", FirstRegularStartOfFile=" + $ushort2uint(FirstRegularStartOfFile) // NOI18N
              + ", Format=" + $uchar2uint(Format) // NOI18N
              + ", IsThin=" + IsThin // NOI18N
              + ", ThinBuffers=" + ThinBuffers // NOI18N
              + super.toString(); // NOI18N
  }
}
