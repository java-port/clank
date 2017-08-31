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


/// ExportEntry encapsulates the current-state-of-the-walk used when doing a
/// non-recursive walk of the trie data structure.  This allows you to iterate
/// across all exported symbols using:
///      for (const llvm::object::ExportEntry &AnExport : Obj->exports()) {
///      }
//<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 57,
 FQN="llvm::object::ExportEntry", NM="_ZN4llvm6object11ExportEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntryE")
//</editor-fold>
public class ExportEntry implements Destructors.ClassWithDestructor, Native.NativeComparable<ExportEntry> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::ExportEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 59,
   FQN="llvm::object::ExportEntry::ExportEntry", NM="_ZN4llvm6object11ExportEntryC1ENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntryC1ENS_8ArrayRefIhEE")
  //</editor-fold>
  public ExportEntry(ArrayRefUChar Trie) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::name">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 61,
   FQN="llvm::object::ExportEntry::name", NM="_ZNK4llvm6object11ExportEntry4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry4nameEv")
  //</editor-fold>
  public StringRef name() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::flags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 62,
   FQN="llvm::object::ExportEntry::flags", NM="_ZNK4llvm6object11ExportEntry5flagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry5flagsEv")
  //</editor-fold>
  public long/*uint64_t*/ flags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::address">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 63,
   FQN="llvm::object::ExportEntry::address", NM="_ZNK4llvm6object11ExportEntry7addressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry7addressEv")
  //</editor-fold>
  public long/*uint64_t*/ address() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::other">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 64,
   FQN="llvm::object::ExportEntry::other", NM="_ZNK4llvm6object11ExportEntry5otherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry5otherEv")
  //</editor-fold>
  public long/*uint64_t*/ other() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::otherName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 65,
   FQN="llvm::object::ExportEntry::otherName", NM="_ZNK4llvm6object11ExportEntry9otherNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry9otherNameEv")
  //</editor-fold>
  public StringRef otherName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::nodeOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 66,
   FQN="llvm::object::ExportEntry::nodeOffset", NM="_ZNK4llvm6object11ExportEntry10nodeOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntry10nodeOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int nodeOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 68,
   FQN="llvm::object::ExportEntry::operator==", NM="_ZNK4llvm6object11ExportEntryeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object11ExportEntryeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ExportEntry /*&*/ $Prm0) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 70,
   FQN="llvm::object::ExportEntry::moveNext", NM="_ZN4llvm6object11ExportEntry8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry8moveNextEv")
  //</editor-fold>
  public void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /*friend  class MachOObjectFile*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::moveToFirst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 74,
   FQN="llvm::object::ExportEntry::moveToFirst", NM="_ZN4llvm6object11ExportEntry11moveToFirstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry11moveToFirstEv")
  //</editor-fold>
  private void moveToFirst() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::moveToEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 75,
   FQN="llvm::object::ExportEntry::moveToEnd", NM="_ZN4llvm6object11ExportEntry9moveToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry9moveToEndEv")
  //</editor-fold>
  private void moveToEnd() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::readULEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 76,
   FQN="llvm::object::ExportEntry::readULEB128", NM="_ZN4llvm6object11ExportEntry11readULEB128ERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry11readULEB128ERPKh")
  //</editor-fold>
  private long/*uint64_t*/ readULEB128(final /*const*/byte/*uint8_t*//*P*/ /*&*/ p) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::pushDownUntilBottom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 77,
   FQN="llvm::object::ExportEntry::pushDownUntilBottom", NM="_ZN4llvm6object11ExportEntry19pushDownUntilBottomEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry19pushDownUntilBottomEv")
  //</editor-fold>
  private void pushDownUntilBottom() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::pushNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 78,
   FQN="llvm::object::ExportEntry::pushNode", NM="_ZN4llvm6object11ExportEntry8pushNodeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry8pushNodeEy")
  //</editor-fold>
  private void pushNode(long/*uint64_t*/ Offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Represents a node in the mach-o exports trie.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::NodeState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 81,
   FQN="llvm::object::ExportEntry::NodeState", NM="_ZN4llvm6object11ExportEntry9NodeStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry9NodeStateE")
  //</editor-fold>
  private static class/*struct*/ NodeState {
    //<editor-fold defaultstate="collapsed" desc="llvm::object::ExportEntry::NodeState::NodeState">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 82,
     FQN="llvm::object::ExportEntry::NodeState::NodeState", NM="_ZN4llvm6object11ExportEntry9NodeStateC1EPKh",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object11ExportEntry9NodeStateC1EPKh")
    //</editor-fold>
    public NodeState(/*const*/byte/*uint8_t*//*P*/ Ptr) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    public /*const*/byte/*uint8_t*//*P*/ Start;
    public /*const*/byte/*uint8_t*//*P*/ Current;
    public long/*uint64_t*/ Flags;
    public long/*uint64_t*/ Address;
    public long/*uint64_t*/ Other;
    public /*const*/char$ptr/*char P*/ ImportName;
    public /*uint*/int ChildCount;
    public /*uint*/int NextChildIndex;
    public /*uint*/int ParentStringLength;
    public boolean IsExportNode;
    
    @Override public String toString() {
      return "" + "Start=" + Start // NOI18N
                + ", Current=" + Current // NOI18N
                + ", Flags=" + Flags // NOI18N
                + ", Address=" + Address // NOI18N
                + ", Other=" + Other // NOI18N
                + ", ImportName=" + ImportName // NOI18N
                + ", ChildCount=" + ChildCount // NOI18N
                + ", NextChildIndex=" + NextChildIndex // NOI18N
                + ", ParentStringLength=" + ParentStringLength // NOI18N
                + ", IsExportNode=" + IsExportNode; // NOI18N
    }
  };
  
  private ArrayRefUChar Trie;
  private SmallString/*256*/ CumulativeString;
  private SmallVector<NodeState> Stack;
  private boolean Malformed;
  private boolean Done;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $destroy() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Trie=" + Trie // NOI18N
              + ", CumulativeString=" + CumulativeString // NOI18N
              + ", Stack=" + Stack // NOI18N
              + ", Malformed=" + Malformed // NOI18N
              + ", Done=" + Done; // NOI18N
  }
}
