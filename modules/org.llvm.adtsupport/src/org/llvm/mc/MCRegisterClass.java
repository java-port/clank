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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;


/// MCRegisterClass - Base class of TargetRegisterClass.
//<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 30,
 FQN="llvm::MCRegisterClass", NM="_ZN4llvm15MCRegisterClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm15MCRegisterClassE")
//</editor-fold>
public class MCRegisterClass {
/*public:*/
  // JAVA: typedef const MCPhysReg *iterator;
  // JAVA: typedef const MCPhysReg *const_iterator;
  
  public /*const*//*uint16_t*/ushort$ptr/*const*/ RegsBegin;
  public /*const*/byte/*uint8_t*//*P*/ /*const*/ RegSet;
  public /*const*//*uint32_t*/int NameIdx;
  public /*const*//*uint16_t*/char RegsSize;
  public /*const*//*uint16_t*/char RegSetSize;
  public /*const*//*uint16_t*/char ID;
  public /*const*//*uint16_t*/char RegSize;
  public /*const*//*uint16_t*/char Alignment; // Size & Alignment of register in bytes
  public /*const*/byte/*int8_t*/ CopyCost;
  public /*const*/boolean Allocatable;
  
  /// getID() - Return the register class ID number.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 47,
   FQN="llvm::MCRegisterClass::getID", NM="_ZNK4llvm15MCRegisterClass5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// begin/end - Return all of the registers in this class.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 51,
   FQN="llvm::MCRegisterClass::begin", NM="_ZNK4llvm15MCRegisterClass5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass5beginEv")
  //</editor-fold>
  public /*const*//*uint16_t*/ushort$ptr begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 52,
   FQN="llvm::MCRegisterClass::end", NM="_ZNK4llvm15MCRegisterClass3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass3endEv")
  //</editor-fold>
  public /*const*//*uint16_t*/ushort$ptr end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getNumRegs - Return the number of registers in this class.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getNumRegs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 56,
   FQN="llvm::MCRegisterClass::getNumRegs", NM="_ZNK4llvm15MCRegisterClass10getNumRegsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass10getNumRegsEv")
  //</editor-fold>
  public /*uint*/int getNumRegs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getRegister - Return the specified register in the class.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getRegister">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 60,
   FQN="llvm::MCRegisterClass::getRegister", NM="_ZNK4llvm15MCRegisterClass11getRegisterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass11getRegisterEj")
  //</editor-fold>
  public /*uint*/int getRegister(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// contains - Return true if the specified register is included in this
  /// register class.  This does not include virtual registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 67,
   FQN="llvm::MCRegisterClass::contains", NM="_ZNK4llvm15MCRegisterClass8containsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass8containsEj")
  //</editor-fold>
  public boolean contains(/*uint*/int Reg) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// contains - Return true if both registers are in this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 76,
   FQN="llvm::MCRegisterClass::contains", NM="_ZNK4llvm15MCRegisterClass8containsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass8containsEjj")
  //</editor-fold>
  public boolean contains(/*uint*/int Reg1, /*uint*/int Reg2) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getSize - Return the size of the register in bytes, which is also the size
  /// of a stack slot allocated to hold a spilled copy of this register.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 82,
   FQN="llvm::MCRegisterClass::getSize", NM="_ZNK4llvm15MCRegisterClass7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass7getSizeEv")
  //</editor-fold>
  public /*uint*/int getSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getAlignment - Return the minimum required alignment for a register of
  /// this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 86,
   FQN="llvm::MCRegisterClass::getAlignment", NM="_ZNK4llvm15MCRegisterClass12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getCopyCost - Return the cost of copying a value between two registers in
  /// this class. A negative number means the register class is very expensive
  /// to copy e.g. status flag register classes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::getCopyCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 91,
   FQN="llvm::MCRegisterClass::getCopyCost", NM="_ZNK4llvm15MCRegisterClass11getCopyCostEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass11getCopyCostEv")
  //</editor-fold>
  public int getCopyCost() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isAllocatable - Return true if this register class may be used to create
  /// virtual registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterClass::isAllocatable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 95,
   FQN="llvm::MCRegisterClass::isAllocatable", NM="_ZNK4llvm15MCRegisterClass13isAllocatableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm15MCRegisterClass13isAllocatableEv")
  //</editor-fold>
  public boolean isAllocatable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RegsBegin=" + RegsBegin // NOI18N
              + ", RegSet=" + RegSet // NOI18N
              + ", NameIdx=" + NameIdx // NOI18N
              + ", RegsSize=" + $ushort2uint(RegsSize) // NOI18N
              + ", RegSetSize=" + $ushort2uint(RegSetSize) // NOI18N
              + ", ID=" + $ushort2uint(ID) // NOI18N
              + ", RegSize=" + $ushort2uint(RegSize) // NOI18N
              + ", Alignment=" + $ushort2uint(Alignment) // NOI18N
              + ", CopyCost=" + CopyCost // NOI18N
              + ", Allocatable=" + Allocatable; // NOI18N
  }
}
