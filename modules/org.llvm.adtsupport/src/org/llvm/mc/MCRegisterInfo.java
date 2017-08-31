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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;


/// MCRegisterInfo base class - We assume that the target defines a static
/// array of MCRegisterDesc objects that represent all of the machine
/// registers that the target has.  As such, we simply have to track a pointer
/// to this array so that we can turn register number into a register
/// descriptor.
///
/// Note this class is designed to be a base class of TargetRegisterInfo, which
/// is the interface used by codegen. However, specific targets *should never*
/// specialize this class. MCRegisterInfo should only contain getters to access
/// TableGen generated physical register data. It must not be extended with
/// virtual methods.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 135,
 FQN="llvm::MCRegisterInfo", NM="_ZN4llvm14MCRegisterInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfoE")
//</editor-fold>
public class MCRegisterInfo implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef const MCRegisterClass *regclass_iterator
//  public final class regclass_iterator extends /*const*/ MCRegisterClass /*P*/ { };
  
  /// DwarfLLVMRegPair - Emitted by tablegen so Dwarf<->LLVM reg mappings can be
  /// performed with a binary search.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DwarfLLVMRegPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 141,
   FQN="llvm::MCRegisterInfo::DwarfLLVMRegPair", NM="_ZN4llvm14MCRegisterInfo16DwarfLLVMRegPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DwarfLLVMRegPairE")
  //</editor-fold>
  public static class/*struct*/ DwarfLLVMRegPair {
    public /*uint*/int FromReg;
    public /*uint*/int ToReg;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DwarfLLVMRegPair::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 145,
     FQN="llvm::MCRegisterInfo::DwarfLLVMRegPair::operator<", NM="_ZNK4llvm14MCRegisterInfo16DwarfLLVMRegPairltES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16DwarfLLVMRegPairltES1_")
    //</editor-fold>
    public boolean $less(DwarfLLVMRegPair RHS) /*const*/ {
      return $less_uint(FromReg, RHS.FromReg);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DwarfLLVMRegPair::DwarfLLVMRegPair">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 141,
     FQN="llvm::MCRegisterInfo::DwarfLLVMRegPair::DwarfLLVMRegPair", NM="_ZN4llvm14MCRegisterInfo16DwarfLLVMRegPairC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DwarfLLVMRegPairC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DwarfLLVMRegPair(final /*const*/ DwarfLLVMRegPair /*&*/ $Prm0) {
      // : FromReg(.FromReg), ToReg(.ToReg) 
      //START JInit
      this.FromReg = $Prm0.FromReg;
      this.ToReg = $Prm0.ToReg;
      //END JInit
    }

    public DwarfLLVMRegPair(int FromReg, int ToReg) {
      this.FromReg = FromReg;
      this.ToReg = ToReg;
    }

    
    @Override public String toString() {
      return "" + "FromReg=" + FromReg // NOI18N
                + ", ToReg=" + ToReg; // NOI18N
    }
  };
  
  /// SubRegCoveredBits - Emitted by tablegen: bit range covered by a subreg
  /// index, -1 in any being invalid.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::SubRegCoveredBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 150,
   FQN="llvm::MCRegisterInfo::SubRegCoveredBits", NM="_ZN4llvm14MCRegisterInfo17SubRegCoveredBitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo17SubRegCoveredBitsE")
  //</editor-fold>
  public static class/*struct*/ SubRegCoveredBits {
    public /*uint16_t*/char Offset;
    public /*uint16_t*/char Size;
    
    @Override public String toString() {
      return "" + "Offset=" + $ushort2uint(Offset) // NOI18N
                + ", Size=" + $ushort2uint(Size); // NOI18N
    }
  };
/*private:*/
  private /*const*/ type$ptr<MCRegisterDesc /*P*/> Desc; // Pointer to the descriptor array
  private /*uint*/int NumRegs; // Number of entries in the array
  private /*uint*/int RAReg; // Return address register
  private /*uint*/int PCReg; // Program counter register
  private /*const*/ type$ptr<MCRegisterClass /*P*/> Classes; // Pointer to the regclass array
  private /*uint*/int NumClasses; // Number of entries in the array
  private /*uint*/int NumRegUnits; // Number of regunits.
  public /*const*/ char RegUnitRoots[] = new char[2]; // Pointer to regunit root table.
  public /*const*//*uint16_t*/ushort$ptr DiffLists; // Pointer to the difflists array
  private /*const*/uint$ptr/*uint P*/ RegUnitMaskSequences; // Pointer to lane mask sequences
  // for register units.
  private /*const*/char$ptr/*char P*/ RegStrings; // Pointer to the string table.
  private /*const*/char$ptr/*char P*/ RegClassStrings; // Pointer to the class strings.
  private /*const*//*uint16_t*/ushort$ptr SubRegIndices; // Pointer to the subreg lookup
  // array.
  private /*const*/ type$ptr<SubRegCoveredBits /*P*/> SubRegIdxRanges; // Pointer to the subreg covered
  // bit ranges array.
  private /*uint*/int NumSubRegIndices; // Number of subreg indices.
  private /*const*//*uint16_t*/ushort$ptr RegEncodingTable; // Pointer to array of register
  // encodings.
  
  private /*uint*/int L2DwarfRegsSize;
  private /*uint*/int EHL2DwarfRegsSize;
  private /*uint*/int Dwarf2LRegsSize;
  private /*uint*/int EHDwarf2LRegsSize;
  private /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> L2DwarfRegs; // LLVM to Dwarf regs mapping
  private /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> EHL2DwarfRegs; // LLVM to Dwarf regs mapping EH
  private /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> Dwarf2LRegs; // Dwarf to LLVM regs mapping
  private /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> EHDwarf2LRegs; // Dwarf to LLVM regs mapping EH
  private DenseMapIntInt L2SEHRegs; // LLVM to SEH regs mapping
  private DenseMapIntInt L2CVRegs; // LLVM to CV regs mapping
/*public:*/
  /// DiffListIterator - Base iterator class that can traverse the
  /// differentially encoded register and regunit lists in DiffLists.
  /// Don't use this class directly, use one of the specialized sub-classes
  /// defined below.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 191,
   FQN="llvm::MCRegisterInfo::DiffListIterator", NM="_ZN4llvm14MCRegisterInfo16DiffListIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIteratorE")
  //</editor-fold>
  public static class DiffListIterator {
    private /*uint16_t*/char Val;
    private /*const*//*uint16_t*/ushort$ptr List;
  /*protected:*/
    /// Create an invalid iterator. Call init() to point to something useful.
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::DiffListIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 198,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 197,
     FQN="llvm::MCRegisterInfo::DiffListIterator::DiffListIterator", NM="_ZN4llvm14MCRegisterInfo16DiffListIteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIteratorC1Ev")
    //</editor-fold>
    protected DiffListIterator() {
      // : Val(0), List(null) 
      //START JInit
      this.Val = $int2ushort(0);
      this.List = null;
      //END JInit
    }

    
    /// init - Point the iterator to InitVal, decoding subsequent values from
    /// DiffList. The iterator will initially point to InitVal, sub-classes are
    /// responsible for skipping the seed value if it is not part of the list.
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::init">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 203,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 202,
     FQN="llvm::MCRegisterInfo::DiffListIterator::init", NM="_ZN4llvm14MCRegisterInfo16DiffListIterator4initEtPKt",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIterator4initEtPKt")
    //</editor-fold>
    protected void init(/*uint16_t*/char InitVal, /*const*//*uint16_t*/ushort$ptr DiffList) {
      Val = InitVal;
      List = $tryClone(DiffList);
    }

    
    /// advance - Move to the next list position, return the applied
    /// differential. This function does not detect the end of the list, that
    /// is the caller's responsibility (by checking for a 0 return value).
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::advance">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 211,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 210,
     FQN="llvm::MCRegisterInfo::DiffListIterator::advance", NM="_ZN4llvm14MCRegisterInfo16DiffListIterator7advanceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIterator7advanceEv")
    //</editor-fold>
    protected /*uint*/int advance() {
      assert (isValid()) : "Cannot move off the end of the list.";
      /*uint16_t*/char D = List.$postInc().$star();
      Val += $ushort2int(D);
      return $ushort2uint(D);
    }

  /*public:*/
    
    /// isValid - returns true if this iterator is not yet at the end.
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 221,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 220,
     FQN="llvm::MCRegisterInfo::DiffListIterator::isValid", NM="_ZNK4llvm14MCRegisterInfo16DiffListIterator7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16DiffListIterator7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return Native.$bool(List);
    }

    
    /// Dereference the iterator to get the value at the current position.
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 224,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 223,
     FQN="llvm::MCRegisterInfo::DiffListIterator::operator*", NM="_ZNK4llvm14MCRegisterInfo16DiffListIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16DiffListIteratordeEv")
    //</editor-fold>
    public /*uint*/int $star() /*const*/ {
      return $ushort2uint(Val);
    }

    
    /// Pre-increment to move to the next position.
    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 227,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 226,
     FQN="llvm::MCRegisterInfo::DiffListIterator::operator++", NM="_ZN4llvm14MCRegisterInfo16DiffListIteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIteratorppEv")
    //</editor-fold>
    public void $preInc() {
      // The end of the list is encoded as a 0 differential.
      if (!(advance() != 0)) {
        List = null;
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::DiffListIterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 192,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 191,
     FQN="llvm::MCRegisterInfo::DiffListIterator::operator=", NM="_ZN4llvm14MCRegisterInfo16DiffListIteratoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo16DiffListIteratoraSEOS1_")
    //</editor-fold>
    public /*inline*/ DiffListIterator /*&*/ $assignMove(final DiffListIterator /*&&*/$Prm0) {
      this.Val = $Prm0.Val;
      this.List = $tryClone($Prm0.List);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Val=" + $ushort2uint(Val) // NOI18N
                + ", List=" + List; // NOI18N
    }
  };
  
  // These iterators are allowed to sub-class DiffListIterator and access
  // internal list pointers.
  /*friend  class MCSubRegIterator*/
  /*friend  class MCSubRegIndexIterator*/
  /*friend  class MCSuperRegIterator*/
  /*friend  class MCRegUnitIterator*/
  /*friend  class MCRegUnitMaskIterator*/
  /*friend  class MCRegUnitRootIterator*/
  
  /// \brief Initialize MCRegisterInfo, called by TableGen
  /// auto-generated routines. *DO NOT USE*.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::InitMCRegisterInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 244,
   FQN="llvm::MCRegisterInfo::InitMCRegisterInfo", NM="_ZN4llvm14MCRegisterInfo18InitMCRegisterInfoEPKNS_14MCRegisterDescEjjjPKNS_15MCRegisterClassEjPA2_KtjPS7_PKjPKcSE_SA_jPKNS0_17SubRegCoveredBitsESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo18InitMCRegisterInfoEPKNS_14MCRegisterDescEjjjPKNS_15MCRegisterClassEjPA2_KtjPS7_PKjPKcSE_SA_jPKNS0_17SubRegCoveredBitsESA_")
  //</editor-fold>
  public void InitMCRegisterInfo(/*const*/ type$ptr<MCRegisterDesc /*P*/> D, /*uint*/int NR, /*uint*/int RA, 
                    /*uint*/int PC, 
                    /*const*/ type$ptr<MCRegisterClass /*P*/> C, /*uint*/int NC, 
                    /*const*/ char RURoots[], 
                    /*uint*/int NRU, 
                    /*const*//*uint16_t*/ushort$ptr DL, 
                    /*const*/uint$ptr/*uint P*/ RUMS, 
                    /*const*/char$ptr/*char P*/ Strings, 
                    /*const*/char$ptr/*char P*/ ClassStrings, 
                    /*const*//*uint16_t*/ushort$ptr SubIndices, 
                    /*uint*/int NumIndices, 
                    /*const*/ type$ptr<SubRegCoveredBits /*P*/> SubIdxRanges, 
                    /*const*//*uint16_t*/ushort$ptr RET) {
    Desc = D;
    NumRegs = NR;
    RAReg = RA;
    PCReg = PC;
    Classes = C;
    DiffLists = $tryClone(DL);
    RegUnitMaskSequences = $tryClone(RUMS);
    RegStrings = $tryClone(Strings);
    RegClassStrings = $tryClone(ClassStrings);
    NumClasses = NC;
    RegUnitRoots = RURoots;
    NumRegUnits = NRU;
    SubRegIndices = $tryClone(SubIndices);
    NumSubRegIndices = NumIndices;
    SubRegIdxRanges = SubIdxRanges;
    RegEncodingTable = $tryClone(RET);
  }

  
  /// \brief Used to initialize LLVM register to Dwarf
  /// register number mapping. Called by TableGen auto-generated routines.
  /// *DO NOT USE*.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::mapLLVMRegsToDwarfRegs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 278,
   FQN="llvm::MCRegisterInfo::mapLLVMRegsToDwarfRegs", NM="_ZN4llvm14MCRegisterInfo22mapLLVMRegsToDwarfRegsEPKNS0_16DwarfLLVMRegPairEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo22mapLLVMRegsToDwarfRegsEPKNS0_16DwarfLLVMRegPairEjb")
  //</editor-fold>
  public void mapLLVMRegsToDwarfRegs(/*const*/ type$ptr<DwarfLLVMRegPair /*P*/> Map, /*uint*/int Size, 
                        boolean isEH) {
    if (isEH) {
      EHL2DwarfRegs = Map;
      EHL2DwarfRegsSize = Size;
    } else {
      L2DwarfRegs = Map;
      L2DwarfRegsSize = Size;
    }
  }

  
  /// \brief Used to initialize Dwarf register to LLVM
  /// register number mapping. Called by TableGen auto-generated routines.
  /// *DO NOT USE*.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::mapDwarfRegsToLLVMRegs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 292,
   FQN="llvm::MCRegisterInfo::mapDwarfRegsToLLVMRegs", NM="_ZN4llvm14MCRegisterInfo22mapDwarfRegsToLLVMRegsEPKNS0_16DwarfLLVMRegPairEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo22mapDwarfRegsToLLVMRegsEPKNS0_16DwarfLLVMRegPairEjb")
  //</editor-fold>
  public void mapDwarfRegsToLLVMRegs(/*const*/ type$ptr<DwarfLLVMRegPair /*P*/> Map, /*uint*/int Size, 
                        boolean isEH) {
    if (isEH) {
      EHDwarf2LRegs = Map;
      EHDwarf2LRegsSize = Size;
    } else {
      Dwarf2LRegs = Map;
      Dwarf2LRegsSize = Size;
    }
  }

  
  /// mapLLVMRegToSEHReg - Used to initialize LLVM register to SEH register
  /// number mapping. By default the SEH register number is just the same
  /// as the LLVM register number.
  /// FIXME: TableGen these numbers. Currently this requires target specific
  /// initialization code.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::mapLLVMRegToSEHReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 308,
   FQN="llvm::MCRegisterInfo::mapLLVMRegToSEHReg", NM="_ZN4llvm14MCRegisterInfo18mapLLVMRegToSEHRegEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo18mapLLVMRegToSEHRegEji")
  //</editor-fold>
  public void mapLLVMRegToSEHReg(/*uint*/int LLVMReg, int SEHReg) {
    L2SEHRegs.$set(LLVMReg, SEHReg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::mapLLVMRegToCVReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 313,
   FQN="llvm::MCRegisterInfo::mapLLVMRegToCVReg", NM="_ZN4llvm14MCRegisterInfo17mapLLVMRegToCVRegEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZN4llvm14MCRegisterInfo17mapLLVMRegToCVRegEji")
  //</editor-fold>
  public void mapLLVMRegToCVReg(/*uint*/int LLVMReg, int CVReg) {
    L2CVRegs.$set(LLVMReg, CVReg);
  }

  
  /// \brief This method should return the register where the return
  /// address can be found.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getRARegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 314,
   FQN="llvm::MCRegisterInfo::getRARegister", NM="_ZNK4llvm14MCRegisterInfo13getRARegisterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo13getRARegisterEv")
  //</editor-fold>
  public /*uint*/int getRARegister() /*const*/ {
    return RAReg;
  }

  
  /// Return the register which is the program counter.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getProgramCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 319,
   FQN="llvm::MCRegisterInfo::getProgramCounter", NM="_ZNK4llvm14MCRegisterInfo17getProgramCounterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo17getProgramCounterEv")
  //</editor-fold>
  public /*uint*/int getProgramCounter() /*const*/ {
    return PCReg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 323,
   FQN="llvm::MCRegisterInfo::operator[]", NM="_ZNK4llvm14MCRegisterInfoixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfoixEj")
  //</editor-fold>
  public /*const*/ MCRegisterDesc /*&*/ $at(/*uint*/int RegNo) /*const*/ {
    assert ($less_uint(RegNo, NumRegs)) : "Attempting to access record for invalid register number!";
    return Desc.$at(RegNo);
  }

  
  /// \brief Provide a get method, equivalent to [], but more useful with a
  /// pointer to this object.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 331,
   FQN="llvm::MCRegisterInfo::get", NM="_ZNK4llvm14MCRegisterInfo3getEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo3getEj")
  //</editor-fold>
  public /*const*/ MCRegisterDesc /*&*/ get(/*uint*/int RegNo) /*const*/ {
    return $at(RegNo);
  }

  
  /// \brief Returns the physical register number of sub-register "Index"
  /// for physical register RegNo. Return zero if the sub-register does not
  /// exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getSubReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 26,
   FQN="llvm::MCRegisterInfo::getSubReg", NM="_ZNK4llvm14MCRegisterInfo9getSubRegEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo9getSubRegEjj")
  //</editor-fold>
  public /*uint*/int getSubReg(/*uint*/int Reg, /*uint*/int Idx) /*const*/ {
    assert ((Idx != 0) && $less_uint(Idx, getNumSubRegIndices())) : "This is not a subregister index";
    // Get a pointer to the corresponding SubRegIndices list. This list has the
    // name of each sub-register in the same order as MCSubRegIterator.
    /*const*//*uint16_t*/ushort$ptr SRI = $tryClone(SubRegIndices.$add(get(Reg).SubRegIndices));
    for (MCSubRegIterator Subs/*J*/= new MCSubRegIterator(Reg, this); Subs.isValid(); Subs.$preInc() , SRI.$preInc())  {
      if ($ushort2uint(SRI.$star()) == Idx) {
        return Subs.$star();
      }
    }
    return 0;
  }

  
  /// \brief Return a super-register of the specified register
  /// Reg so its sub-register of index SubIdx is Reg.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getMatchingSuperReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 18,
   FQN="llvm::MCRegisterInfo::getMatchingSuperReg", NM="_ZNK4llvm14MCRegisterInfo19getMatchingSuperRegEjjPKNS_15MCRegisterClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo19getMatchingSuperRegEjjPKNS_15MCRegisterClassE")
  //</editor-fold>
  public /*uint*/int getMatchingSuperReg(/*uint*/int Reg, /*uint*/int SubIdx, 
                     /*const*/ MCRegisterClass /*P*/ RC) /*const*/ {
    for (MCSuperRegIterator Supers/*J*/= new MCSuperRegIterator(Reg, this); Supers.isValid(); Supers.$preInc())  {
      if (RC.contains(Supers.$star()) && Reg == getSubReg(Supers.$star(), SubIdx)) {
        return Supers.$star();
      }
    }
    return 0;
  }

  
  /// \brief For a given register pair, return the sub-register index
  /// if the second register is a sub-register of the first. Return zero
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getSubRegIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 38,
   FQN="llvm::MCRegisterInfo::getSubRegIndex", NM="_ZNK4llvm14MCRegisterInfo14getSubRegIndexEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo14getSubRegIndexEjj")
  //</editor-fold>
  public /*uint*/int getSubRegIndex(/*uint*/int Reg, /*uint*/int SubReg) /*const*/ {
    assert ((SubReg != 0) && $less_uint(SubReg, getNumRegs())) : "This is not a register";
    // Get a pointer to the corresponding SubRegIndices list. This list has the
    // name of each sub-register in the same order as MCSubRegIterator.
    /*const*//*uint16_t*/ushort$ptr SRI = $tryClone(SubRegIndices.$add(get(Reg).SubRegIndices));
    for (MCSubRegIterator Subs/*J*/= new MCSubRegIterator(Reg, this); Subs.isValid(); Subs.$preInc() , SRI.$preInc())  {
      if (Subs.$star() == SubReg) {
        return $ushort2uint(SRI.$star());
      }
    }
    return 0;
  }

  
  /// \brief Get the size of the bit range covered by a sub-register index.
  /// If the index isn't continuous, return the sum of the sizes of its parts.
  /// If the index is used to access subregisters of different sizes, return -1.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getSubRegIdxSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 49,
   FQN="llvm::MCRegisterInfo::getSubRegIdxSize", NM="_ZNK4llvm14MCRegisterInfo16getSubRegIdxSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16getSubRegIdxSizeEj")
  //</editor-fold>
  public /*uint*/int getSubRegIdxSize(/*uint*/int Idx) /*const*/ {
    assert ((Idx != 0) && $less_uint(Idx, getNumSubRegIndices())) : "This is not a subregister index";
    return $ushort2uint(SubRegIdxRanges.$at(Idx).Size);
  }

  
  /// \brief Get the offset of the bit range covered by a sub-register index.
  /// If an Offset doesn't make sense (the index isn't continuous, or is used to
  /// access sub-registers at different offsets), return -1.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getSubRegIdxOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 55,
   FQN="llvm::MCRegisterInfo::getSubRegIdxOffset", NM="_ZNK4llvm14MCRegisterInfo18getSubRegIdxOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo18getSubRegIdxOffsetEj")
  //</editor-fold>
  public /*uint*/int getSubRegIdxOffset(/*uint*/int Idx) /*const*/ {
    assert ((Idx != 0) && $less_uint(Idx, getNumSubRegIndices())) : "This is not a subregister index";
    return $ushort2uint(SubRegIdxRanges.$at(Idx).Offset);
  }

  
  /// \brief Return the human-readable symbolic target-specific name for the
  /// specified physical register.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 367,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 362,
   FQN="llvm::MCRegisterInfo::getName", NM="_ZNK4llvm14MCRegisterInfo7getNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo7getNameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName(/*uint*/int RegNo) /*const*/ {
    return RegStrings.$add(get(RegNo).Name);
  }

  
  /// \brief Return the number of registers this target has (useful for
  /// sizing arrays holding per register information)
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getNumRegs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 373,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 368,
   FQN="llvm::MCRegisterInfo::getNumRegs", NM="_ZNK4llvm14MCRegisterInfo10getNumRegsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo10getNumRegsEv")
  //</editor-fold>
  public /*uint*/int getNumRegs() /*const*/ {
    return NumRegs;
  }

  
  /// \brief Return the number of sub-register indices
  /// understood by the target. Index 0 is reserved for the no-op sub-register,
  /// while 1 to getNumSubRegIndices() - 1 represent real sub-registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getNumSubRegIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 380,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 375,
   FQN="llvm::MCRegisterInfo::getNumSubRegIndices", NM="_ZNK4llvm14MCRegisterInfo19getNumSubRegIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo19getNumSubRegIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumSubRegIndices() /*const*/ {
    return NumSubRegIndices;
  }

  
  /// \brief Return the number of (native) register units in the
  /// target. Register units are numbered from 0 to getNumRegUnits() - 1. They
  /// can be accessed through MCRegUnitIterator defined below.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getNumRegUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 387,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 382,
   FQN="llvm::MCRegisterInfo::getNumRegUnits", NM="_ZNK4llvm14MCRegisterInfo14getNumRegUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo14getNumRegUnitsEv")
  //</editor-fold>
  public /*uint*/int getNumRegUnits() /*const*/ {
    return NumRegUnits;
  }

  
  /// \brief Map a target register to an equivalent dwarf register
  /// number.  Returns -1 if there is no equivalent value.  The second
  /// parameter allows targets to use different numberings for EH info and
  /// debugging info.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getDwarfRegNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 61,
   FQN="llvm::MCRegisterInfo::getDwarfRegNum", NM="_ZNK4llvm14MCRegisterInfo14getDwarfRegNumEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo14getDwarfRegNumEjb")
  //</editor-fold>
  public int getDwarfRegNum(/*uint*/int RegNum, boolean isEH) /*const*/ {
    /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> M = isEH ? EHL2DwarfRegs : L2DwarfRegs;
    /*uint*/int Size = isEH ? EHL2DwarfRegsSize : L2DwarfRegsSize;
    
    DwarfLLVMRegPair Key = new DwarfLLVMRegPair(RegNum, 0);
    /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> I = std.lower_bound(M, M.$add(Size), Key);
    if (I.$eq(M.$add(Size)) || I.$star().FromReg != RegNum) {
      return -1;
    }
    return I.$star().ToReg;
  }

  
  /// \brief Map a dwarf register back to a target register.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getLLVMRegNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 72,
   FQN="llvm::MCRegisterInfo::getLLVMRegNum", NM="_ZNK4llvm14MCRegisterInfo13getLLVMRegNumEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo13getLLVMRegNumEjb")
  //</editor-fold>
  public int getLLVMRegNum(/*uint*/int RegNum, boolean isEH) /*const*/ {
    /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> M = isEH ? EHDwarf2LRegs : Dwarf2LRegs;
    /*uint*/int Size = isEH ? EHDwarf2LRegsSize : Dwarf2LRegsSize;
    
    DwarfLLVMRegPair Key = new DwarfLLVMRegPair(RegNum, 0);
    /*const*/ type$ptr<DwarfLLVMRegPair /*P*/> I = std.lower_bound(M, M.$add(Size), Key);
    assert (!I.$eq(M.$add(Size)) && I.$star().FromReg == RegNum) : "Invalid RegNum";
    return I.$star().ToReg;
  }

  
  /// \brief Map a target register to an equivalent SEH register
  /// number.  Returns LLVM register number if there is no equivalent value.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getSEHRegNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 82,
   FQN="llvm::MCRegisterInfo::getSEHRegNum", NM="_ZNK4llvm14MCRegisterInfo12getSEHRegNumEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo12getSEHRegNumEj")
  //</editor-fold>
  public int getSEHRegNum(/*uint*/int RegNum) /*const*/ {
    /*const*/ DenseMapIteratorIntInt I = L2SEHRegs.find$Const(RegNum);
    if (I.$eq(L2SEHRegs.end$Const())) {
      return (int)RegNum;
    }
    return I.$arrow().second;
  }

  
  /// \brief Map a target register to an equivalent CodeView register
  /// number.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getCodeViewRegNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp", line = 88,
   FQN="llvm::MCRegisterInfo::getCodeViewRegNum", NM="_ZNK4llvm14MCRegisterInfo17getCodeViewRegNumEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo17getCodeViewRegNumEj")
  //</editor-fold>
  public int getCodeViewRegNum(/*uint*/int RegNum) /*const*/ {
    if (L2CVRegs.empty()) {
      report_fatal_error($("target does not implement codeview register mapping"));
    }
    /*const*/ DenseMapIteratorIntInt I = L2CVRegs.find$Const(RegNum);
    if (I.$eq(L2CVRegs.end$Const())) {
      report_fatal_error($("unknown codeview register"));
    }
    return I.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::regclass_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 408,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 399,
   FQN="llvm::MCRegisterInfo::regclass_begin", NM="_ZNK4llvm14MCRegisterInfo14regclass_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo14regclass_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ MCRegisterClass /*P*/ > regclass_begin() /*const*/ {
    return Classes;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::regclass_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 400,
   FQN="llvm::MCRegisterInfo::regclass_end", NM="_ZNK4llvm14MCRegisterInfo12regclass_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo12regclass_endEv")
  //</editor-fold>
  public type$ptr</*const*/ MCRegisterClass /*P*/ > regclass_end() /*const*/ {
    return Classes.$add(NumClasses);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getNumRegClasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 411,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 402,
   FQN="llvm::MCRegisterInfo::getNumRegClasses", NM="_ZNK4llvm14MCRegisterInfo16getNumRegClassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16getNumRegClassesEv")
  //</editor-fold>
  public /*uint*/int getNumRegClasses() /*const*/ {
    return (/*uint*/int)(regclass_end().$sub(regclass_begin()));
  }

  
  /// \brief Returns the register class associated with the enumeration
  /// value.  See class MCOperandInfo.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getRegClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 417,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 408,
   FQN="llvm::MCRegisterInfo::getRegClass", NM="_ZNK4llvm14MCRegisterInfo11getRegClassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo11getRegClassEj")
  //</editor-fold>
  public /*const*/ MCRegisterClass /*&*/ getRegClass(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumRegClasses())) : "Register Class ID out of range";
    return Classes.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getRegClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 422,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 413,
   FQN="llvm::MCRegisterInfo::getRegClassName", NM="_ZNK4llvm14MCRegisterInfo15getRegClassNameEPKNS_15MCRegisterClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo15getRegClassNameEPKNS_15MCRegisterClassE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getRegClassName(/*const*/ MCRegisterClass /*P*/ Class) /*const*/ {
    return RegClassStrings.$add(Class.NameIdx);
  }

  
  /// \brief Returns the encoding for RegNo
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::getEncodingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 427,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 418,
   FQN="llvm::MCRegisterInfo::getEncodingValue", NM="_ZNK4llvm14MCRegisterInfo16getEncodingValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo16getEncodingValueEj")
  //</editor-fold>
  public /*uint16_t*/char getEncodingValue(/*uint*/int RegNo) /*const*/ {
    assert ($less_uint(RegNo, NumRegs)) : "Attempting to get encoding for invalid register number!";
    return RegEncodingTable.$at(RegNo);
  }

  
  /// \brief Returns true if RegB is a sub-register of RegA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::isSubRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 434,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 425,
   FQN="llvm::MCRegisterInfo::isSubRegister", NM="_ZNK4llvm14MCRegisterInfo13isSubRegisterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo13isSubRegisterEjj")
  //</editor-fold>
  public boolean isSubRegister(/*uint*/int RegA, /*uint*/int RegB) /*const*/ {
    return isSuperRegister(RegB, RegA);
  }

  
  /// \brief Returns true if RegB is a super-register of RegA.
  
  // Definition for isSuperRegister. Put it down here since it needs the
  // iterator defined above in addition to the MCRegisterInfo class itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::isSuperRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 527,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 513,
   FQN="llvm::MCRegisterInfo::isSuperRegister", NM="_ZNK4llvm14MCRegisterInfo15isSuperRegisterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo15isSuperRegisterEjj")
  //</editor-fold>
  public /*inline*/ boolean isSuperRegister(/*uint*/int RegA, /*uint*/int RegB) /*const*/ {
    for (MCSuperRegIterator I/*J*/= new MCSuperRegIterator(RegA, this); I.isValid(); I.$preInc())  {
      if (I.$star() == RegB) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Returns true if RegB is a sub-register of RegA or if RegB == RegA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::isSubRegisterEq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 433,
   FQN="llvm::MCRegisterInfo::isSubRegisterEq", NM="_ZNK4llvm14MCRegisterInfo15isSubRegisterEqEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo15isSubRegisterEqEjj")
  //</editor-fold>
  public boolean isSubRegisterEq(/*uint*/int RegA, /*uint*/int RegB) /*const*/ {
    return isSuperRegisterEq(RegB, RegA);
  }

  
  /// \brief Returns true if RegB is a super-register of RegA or if
  /// RegB == RegA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::isSuperRegisterEq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", old_line = 439,
   FQN="llvm::MCRegisterInfo::isSuperRegisterEq", NM="_ZNK4llvm14MCRegisterInfo17isSuperRegisterEqEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo17isSuperRegisterEqEjj")
  //</editor-fold>
  public boolean isSuperRegisterEq(/*uint*/int RegA, /*uint*/int RegB) /*const*/ {
    return RegA == RegB || isSuperRegister(RegA, RegB);
  }

  
  /// \brief Returns true if RegB is a super-register or sub-register of RegA
  /// or if RegB == RegA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::isSuperOrSubRegisterEq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 454,
   FQN="llvm::MCRegisterInfo::isSuperOrSubRegisterEq", NM="_ZNK4llvm14MCRegisterInfo22isSuperOrSubRegisterEqEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCRegisterInfo.cpp -nm=_ZNK4llvm14MCRegisterInfo22isSuperOrSubRegisterEqEjj")
  //</editor-fold>
  public boolean isSuperOrSubRegisterEq(/*uint*/int RegA, /*uint*/int RegB) /*const*/ {
    return isSubRegisterEq(RegA, RegB) || isSuperRegister(RegA, RegB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCRegisterInfo::~MCRegisterInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCRegisterInfo.h", line = 135,
   FQN="llvm::MCRegisterInfo::~MCRegisterInfo", NM="_ZN4llvm14MCRegisterInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN4llvm14MCRegisterInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    L2CVRegs.$destroy();
    L2SEHRegs.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "Desc=" + Desc // NOI18N
              + ", NumRegs=" + NumRegs // NOI18N
              + ", RAReg=" + RAReg // NOI18N
              + ", PCReg=" + PCReg // NOI18N
              + ", Classes=" + Classes // NOI18N
              + ", NumClasses=" + NumClasses // NOI18N
              + ", NumRegUnits=" + NumRegUnits // NOI18N
              + ", RegUnitRoots=" + RegUnitRoots // NOI18N
              + ", DiffLists=" + DiffLists // NOI18N
              + ", RegUnitMaskSequences=" + RegUnitMaskSequences // NOI18N
              + ", RegStrings=" + RegStrings // NOI18N
              + ", RegClassStrings=" + RegClassStrings // NOI18N
              + ", SubRegIndices=" + SubRegIndices // NOI18N
              + ", SubRegIdxRanges=" + SubRegIdxRanges // NOI18N
              + ", NumSubRegIndices=" + NumSubRegIndices // NOI18N
              + ", RegEncodingTable=" + RegEncodingTable // NOI18N
              + ", L2DwarfRegsSize=" + L2DwarfRegsSize // NOI18N
              + ", EHL2DwarfRegsSize=" + EHL2DwarfRegsSize // NOI18N
              + ", Dwarf2LRegsSize=" + Dwarf2LRegsSize // NOI18N
              + ", EHDwarf2LRegsSize=" + EHDwarf2LRegsSize // NOI18N
              + ", L2DwarfRegs=" + L2DwarfRegs // NOI18N
              + ", EHL2DwarfRegs=" + EHL2DwarfRegs // NOI18N
              + ", Dwarf2LRegs=" + Dwarf2LRegs // NOI18N
              + ", EHDwarf2LRegs=" + EHDwarf2LRegs // NOI18N
              + ", L2SEHRegs=" + L2SEHRegs // NOI18N
              + ", L2CVRegs=" + L2CVRegs; // NOI18N
  }
}
