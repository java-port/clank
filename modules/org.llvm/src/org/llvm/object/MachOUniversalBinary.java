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
import org.llvm.java.LlvmJavaDifferentiators.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.mc.*;
import org.llvm.support.sys.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 29,
 FQN="llvm::object::MachOUniversalBinary", NM="_ZN4llvm6object20MachOUniversalBinaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinaryE")
//</editor-fold>
public class MachOUniversalBinary extends /*public*/ Binary implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 30,
   FQN="llvm::object::MachOUniversalBinary::anchor", NM="_ZN4llvm6object20MachOUniversalBinary6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary6anchorEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  private /*uint32_t*/int Magic;
  private /*uint32_t*/int NumberOfObjects;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 35,
   FQN="llvm::object::MachOUniversalBinary::ObjectForArch", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArchE")
  //</editor-fold>
  public static class ObjectForArch implements Native.NativeComparable<ObjectForArch> {
    private /*const*/ MachOUniversalBinary /*P*/ Parent;
    /// \brief Index of object in the universal binary.
    private /*uint32_t*/int Index;
    /// \brief Descriptor of the object.
    private MachO.fat_arch Header;
    private MachO.fat_arch_64 Header64;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 44,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1EPKS1_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1EPKS1_j")
    //</editor-fold>
    public ObjectForArch(/*const*/ MachOUniversalBinary /*P*/ Parent, /*uint32_t*/int Index) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::clear">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 46,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::clear", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArch5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArch5clearEv")
    //</editor-fold>
    public void clear() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 51,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::operator==", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArcheqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArcheqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ ObjectForArch /*&*/ Other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getNext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 55,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getNext", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch7getNextEv")
    //</editor-fold>
    public ObjectForArch getNext() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getCPUType">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 56,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getCPUType", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch10getCPUTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch10getCPUTypeEv")
    //</editor-fold>
    public /*uint32_t*/int getCPUType() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getCPUSubType">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 62,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getCPUSubType", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch13getCPUSubTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch13getCPUSubTypeEv")
    //</editor-fold>
    public /*uint32_t*/int getCPUSubType() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getOffset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 68,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getOffset", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch9getOffsetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch9getOffsetEv")
    //</editor-fold>
    public /*uint32_t*/int getOffset() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getSize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 74,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getSize", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch7getSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch7getSizeEv")
    //</editor-fold>
    public /*uint32_t*/int getSize() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getAlign">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 80,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getAlign", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch8getAlignEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch8getAlignEv")
    //</editor-fold>
    public /*uint32_t*/int getAlign() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getReserved">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 86,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getReserved", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch11getReservedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch11getReservedEv")
    //</editor-fold>
    public /*uint32_t*/int getReserved() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getArchTypeName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 92,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getArchTypeName", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch15getArchTypeNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch15getArchTypeNameEv")
    //</editor-fold>
    public std.string getArchTypeName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getAsObjectFile">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 105,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getAsObjectFile", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch15getAsObjectFileEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch15getAsObjectFileEv")
    //</editor-fold>
    public Expected<std.unique_ptr<MachOObjectFile> > getAsObjectFile() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::getAsArchive">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 107,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::getAsArchive", NM="_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch12getAsArchiveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13ObjectForArch12getAsArchiveEv")
    //</editor-fold>
    public Expected<std.unique_ptr<Archive> > getAsArchive() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 35,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1ERKS2_")
    //</editor-fold>
    public /*inline*/ ObjectForArch(final /*const*/ ObjectForArch /*&*/ $Prm0) {
      // : Parent(.Parent), Index(.Index), Header(.Header), Header64(.Header64) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 35,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::ObjectForArch", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArchC1EOS2_")
    //</editor-fold>
    public /*inline*/ ObjectForArch(JD$Move _dparam, final ObjectForArch /*&&*/$Prm0) {
      // : Parent(static_cast<ObjectForArch &&>().Parent), Index(static_cast<ObjectForArch &&>().Index), Header(static_cast<ObjectForArch &&>().Header), Header64(static_cast<ObjectForArch &&>().Header64) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::ObjectForArch::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 35,
     FQN="llvm::object::MachOUniversalBinary::ObjectForArch::operator=", NM="_ZN4llvm6object20MachOUniversalBinary13ObjectForArchaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary13ObjectForArchaSEOS2_")
    //</editor-fold>
    public /*inline*/ ObjectForArch /*&*/ $assignMove(final ObjectForArch /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Parent=" + Parent // NOI18N
                + ", Index=" + Index // NOI18N
                + ", Header=" + Header // NOI18N
                + ", Header64=" + Header64; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 110,
   FQN="llvm::object::MachOUniversalBinary::object_iterator", NM="_ZN4llvm6object20MachOUniversalBinary15object_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary15object_iteratorE")
  //</editor-fold>
  public static class object_iterator implements Native.NativeComparable<object_iterator> {
    private ObjectForArch Obj;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::object_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 113,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::object_iterator", NM="_ZN4llvm6object20MachOUniversalBinary15object_iteratorC1ERKNS1_13ObjectForArchE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary15object_iteratorC1ERKNS1_13ObjectForArchE")
    //</editor-fold>
    public object_iterator(final /*const*/ ObjectForArch /*&*/ Obj) {
      // : Obj(Obj) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 114,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::operator->", NM="_ZNK4llvm6object20MachOUniversalBinary15object_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary15object_iteratorptEv")
    //</editor-fold>
    public /*const*/ ObjectForArch /*P*/ $arrow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 115,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::operator*", NM="_ZNK4llvm6object20MachOUniversalBinary15object_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary15object_iteratordeEv")
    //</editor-fold>
    public /*const*/ ObjectForArch /*&*/ $star() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 117,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::operator==", NM="_ZNK4llvm6object20MachOUniversalBinary15object_iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary15object_iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ object_iterator /*&*/ Other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 120,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::operator!=", NM="_ZNK4llvm6object20MachOUniversalBinary15object_iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary15object_iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ object_iterator /*&*/ Other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 124,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::operator++", NM="_ZN4llvm6object20MachOUniversalBinary15object_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary15object_iteratorppEv")
    //</editor-fold>
    public object_iterator /*&*/ $preInc() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::object_iterator::object_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 110,
     FQN="llvm::object::MachOUniversalBinary::object_iterator::object_iterator", NM="_ZN4llvm6object20MachOUniversalBinary15object_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary15object_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ object_iterator(JD$Move _dparam, final object_iterator /*&&*/$Prm0) {
      // : Obj(static_cast<object_iterator &&>().Obj) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Obj=" + Obj; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::MachOUniversalBinary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 130,
   FQN="llvm::object::MachOUniversalBinary::MachOUniversalBinary", NM="_ZN4llvm6object20MachOUniversalBinaryC1ENS_15MemoryBufferRefERNS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinaryC1ENS_15MemoryBufferRefERNS_5ErrorE")
  //</editor-fold>
  public MachOUniversalBinary(MemoryBufferRef Souce, final Error /*&*/ Err) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 131,
   FQN="llvm::object::MachOUniversalBinary::create", NM="_ZN4llvm6object20MachOUniversalBinary6createENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary6createENS_15MemoryBufferRefE")
  //</editor-fold>
  public static Expected<std.unique_ptr<MachOUniversalBinary> > create(MemoryBufferRef Source) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::begin_objects">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 134,
   FQN="llvm::object::MachOUniversalBinary::begin_objects", NM="_ZNK4llvm6object20MachOUniversalBinary13begin_objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary13begin_objectsEv")
  //</editor-fold>
  public object_iterator begin_objects() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::end_objects">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 137,
   FQN="llvm::object::MachOUniversalBinary::end_objects", NM="_ZNK4llvm6object20MachOUniversalBinary11end_objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary11end_objectsEv")
  //</editor-fold>
  public object_iterator end_objects() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::objects">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 141,
   FQN="llvm::object::MachOUniversalBinary::objects", NM="_ZNK4llvm6object20MachOUniversalBinary7objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary7objectsEv")
  //</editor-fold>
  public iterator_range</*const*/ ObjectForArch /*&*/ > objects() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::getMagic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 145,
   FQN="llvm::object::MachOUniversalBinary::getMagic", NM="_ZNK4llvm6object20MachOUniversalBinary8getMagicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary8getMagicEv")
  //</editor-fold>
  public /*uint32_t*/int getMagic() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::getNumberOfObjects">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 146,
   FQN="llvm::object::MachOUniversalBinary::getNumberOfObjects", NM="_ZNK4llvm6object20MachOUniversalBinary18getNumberOfObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary18getNumberOfObjectsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumberOfObjects() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Cast methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 149,
   FQN="llvm::object::MachOUniversalBinary::classof", NM="_ZN4llvm6object20MachOUniversalBinary7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinary7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::getObjectForArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 153,
   FQN="llvm::object::MachOUniversalBinary::getObjectForArch", NM="_ZNK4llvm6object20MachOUniversalBinary16getObjectForArchENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object20MachOUniversalBinary16getObjectForArchENS_9StringRefE")
  //</editor-fold>
  public Expected<std.unique_ptr<MachOObjectFile> > getObjectForArch(StringRef ArchName) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOUniversalBinary::~MachOUniversalBinary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachOUniversal.h", line = 29,
   FQN="llvm::object::MachOUniversalBinary::~MachOUniversalBinary", NM="_ZN4llvm6object20MachOUniversalBinaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object20MachOUniversalBinaryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Magic=" + Magic // NOI18N
              + ", NumberOfObjects=" + NumberOfObjects // NOI18N
              + super.toString(); // NOI18N
  }
}
