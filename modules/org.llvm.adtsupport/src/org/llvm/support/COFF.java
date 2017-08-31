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
package org.llvm.support;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type COFF">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.COFF",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF10COMDATTypeE;_ZN4llvm4COFF10ImportTypeE;_ZN4llvm4COFF10PE32HeaderE;_ZN4llvm4COFF10relocationE;_ZN4llvm4COFF12BigObjHeaderE;_ZN4llvm4COFF12ImportHeaderE;_ZN4llvm4COFF12MachineTypesE;_ZN4llvm4COFF13AuxSymbolTypeE;_ZN4llvm4COFF13DataDirectoryE;_ZN4llvm4COFF14ImportNameTypeE;_ZN4llvm4COFF14SymbolBaseTypeE;_ZN4llvm4COFF15CharacteristicsE;_ZN4llvm4COFF16WindowsSubsystemE;_ZN4llvm4COFF17AuxiliaryCLRTokenE;_ZN4llvm4COFF17SymbolComplexTypeE;_ZN4llvm4COFF18BaseRelocationTypeE;_ZN4llvm4COFF18DLLCharacteristicsE;_ZN4llvm4COFF18DataDirectoryIndexE;_ZN4llvm4COFF18RelocationTypeI386E;_ZN4llvm4COFF18RelocationTypesARME;_ZN4llvm4COFF18SymbolStorageClassE;_ZN4llvm4COFF19CodeViewIdentifiersE;_ZN4llvm4COFF19RelocationTypeAMD64E;_ZN4llvm4COFF19SymbolSectionNumberE;_ZN4llvm4COFF21AuxiliaryWeakExternalE;_ZN4llvm4COFF22AuxiliarybfAndefSymbolE;_ZN4llvm4COFF22SectionCharacteristicsE;_ZN4llvm4COFF23isReservedSectionNumberEi;_ZN4llvm4COFF24ImportLookupTableEntry32E;_ZN4llvm4COFF25ImportDirectoryTableEntryE;_ZN4llvm4COFF26AuxiliarySectionDefinitionE;_ZN4llvm4COFF27AuxiliaryFunctionDefinitionE;_ZN4llvm4COFF27WeakExternalCharacteristicsE;_ZN4llvm4COFF6headerE;_ZN4llvm4COFF6symbolE;_ZN4llvm4COFF7sectionE;_ZN4llvm4COFF9AuxiliaryE;_ZN4llvm4COFF9DOSHeaderE;_ZN4llvm4COFF9DebugTypeE;_ZN4llvm4COFFE_COFF_h_Unnamed_enum;_ZN4llvm4COFFL11BigObjMagicE;_ZN4llvm4COFFL21MaxNumberOfSections16E;_ZN4llvm4COFFL7PEMagicE; -static-type=COFF -package=org.llvm.support")
//</editor-fold>
public final class COFF {


// The maximum number of sections that a COFF object can have (inclusive).
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::MaxNumberOfSections16">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 34,
 FQN="llvm::COFF::MaxNumberOfSections16", NM="_ZN4llvm4COFFL21MaxNumberOfSections16E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFFL21MaxNumberOfSections16E")
//</editor-fold>
public static /*const*/int/*int32_t*/ MaxNumberOfSections16 = 65279;

// The PE signature bytes that follows the DOS stub header.
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::PEMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 37,
 FQN="llvm::COFF::PEMagic", NM="_ZN4llvm4COFFL7PEMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFFL7PEMagicE")
//</editor-fold>
public static /*const*//*char*/byte PEMagic[/*4*/] = new$char(4, $$P, $$E, $$TERM, $$TERM);
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::BigObjMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 39,
 FQN="llvm::COFF::BigObjMagic", NM="_ZN4llvm4COFFL11BigObjMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFFL11BigObjMagicE")
//</editor-fold>
public static /*const*//*char*/byte BigObjMagic[/*16*/] = new$char(16, 
  $$0xC7, $$0xA1, $$0xBA, $$0xD1, $$0xEE, $$0xBA, $$0xA9, $$K, 
  $$0xAF, $$SPACE, $$0xFA, $$0xF6, $$j, $$0xA4, $$0xDC, $$0xB8
);

// Sizes in bytes of various things in the COFF format.
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 45,
 FQN="llvm::COFF::(anonymous)", NM="_ZN4llvm4COFFE_COFF_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFFE_COFF_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int Header16Size = 20;
  public static final /*uint*/int Header32Size = 56;
  public static final /*uint*/int NameSize = 8;
  public static final /*uint*/int Symbol16Size = 18;
  public static final /*uint*/int Symbol32Size = 20;
  public static final /*uint*/int SectionSize = 40;
  public static final /*uint*/int RelocationSize = 10;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::header">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 55,
 FQN="llvm::COFF::header", NM="_ZN4llvm4COFF6headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF6headerE")
//</editor-fold>
public static class/*struct*/ header {
  public /*uint16_t*/char Machine;
  public int/*int32_t*/ NumberOfSections;
  public /*uint32_t*/int TimeDateStamp;
  public /*uint32_t*/int PointerToSymbolTable;
  public /*uint32_t*/int NumberOfSymbols;
  public /*uint16_t*/char SizeOfOptionalHeader;
  public /*uint16_t*/char Characteristics;

  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::header::header">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 55,
   FQN="llvm::COFF::header::header", NM="_ZN4llvm4COFF6headerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF6headerC1Ev")
  //</editor-fold>
  public /*inline*/ header() {
  }

  
  @Override public String toString() {
    return "" + "Machine=" + $ushort2uint(Machine) // NOI18N
              + ", NumberOfSections=" + NumberOfSections // NOI18N
              + ", TimeDateStamp=" + TimeDateStamp // NOI18N
              + ", PointerToSymbolTable=" + PointerToSymbolTable // NOI18N
              + ", NumberOfSymbols=" + NumberOfSymbols // NOI18N
              + ", SizeOfOptionalHeader=" + $ushort2uint(SizeOfOptionalHeader) // NOI18N
              + ", Characteristics=" + $ushort2uint(Characteristics); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::BigObjHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 65,
 FQN="llvm::COFF::BigObjHeader", NM="_ZN4llvm4COFF12BigObjHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF12BigObjHeaderE")
//</editor-fold>
public static class/*struct*/ BigObjHeader {
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::BigObjHeader::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 66,
   FQN="llvm::COFF::BigObjHeader::(anonymous)", NM="_ZN4llvm4COFF12BigObjHeaderE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF12BigObjHeaderE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : uint16_t {*/
    public static final /*uint16_t*/char MinBigObjectVersion = $int2ushort(2);
  /*}*/;
  
  public /*uint16_t*/char Sig1; ///< Must be IMAGE_FILE_MACHINE_UNKNOWN (0).
  public /*uint16_t*/char Sig2; ///< Must be 0xFFFF.
  public /*uint16_t*/char Version;
  public /*uint16_t*/char Machine;
  public /*uint32_t*/int TimeDateStamp;
  public byte/*uint8_t*/ UUID[/*16*/] = new$char(16);
  public /*uint32_t*/int unused1;
  public /*uint32_t*/int unused2;
  public /*uint32_t*/int unused3;
  public /*uint32_t*/int unused4;
  public /*uint32_t*/int NumberOfSections;
  public /*uint32_t*/int PointerToSymbolTable;
  public /*uint32_t*/int NumberOfSymbols;
  
  @Override public String toString() {
    return "" + "Sig1=" + $ushort2uint(Sig1) // NOI18N
              + ", Sig2=" + $ushort2uint(Sig2) // NOI18N
              + ", Version=" + $ushort2uint(Version) // NOI18N
              + ", Machine=" + $ushort2uint(Machine) // NOI18N
              + ", TimeDateStamp=" + TimeDateStamp // NOI18N
              + ", UUID=" + UUID // NOI18N
              + ", unused1=" + unused1 // NOI18N
              + ", unused2=" + unused2 // NOI18N
              + ", unused3=" + unused3 // NOI18N
              + ", unused4=" + unused4 // NOI18N
              + ", NumberOfSections=" + NumberOfSections // NOI18N
              + ", PointerToSymbolTable=" + PointerToSymbolTable // NOI18N
              + ", NumberOfSymbols=" + NumberOfSymbols; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::MachineTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 83,
 FQN="llvm::COFF::MachineTypes", NM="_ZN4llvm4COFF12MachineTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF12MachineTypesE")
//</editor-fold>
public static final class/*enum*/ MachineTypes {
  public static final /*uint*/int MT_Invalid = 0xffff;
  
  public static final /*uint*/int IMAGE_FILE_MACHINE_UNKNOWN = 0x0;
  public static final /*uint*/int IMAGE_FILE_MACHINE_AM33 = 0x13;
  public static final /*uint*/int IMAGE_FILE_MACHINE_AMD64 = 0x8664;
  public static final /*uint*/int IMAGE_FILE_MACHINE_ARM = 0x1C0;
  public static final /*uint*/int IMAGE_FILE_MACHINE_ARMNT = 0x1C4;
  public static final /*uint*/int IMAGE_FILE_MACHINE_ARM64 = 0xAA64;
  public static final /*uint*/int IMAGE_FILE_MACHINE_EBC = 0xEBC;
  public static final /*uint*/int IMAGE_FILE_MACHINE_I386 = 0x14C;
  public static final /*uint*/int IMAGE_FILE_MACHINE_IA64 = 0x200;
  public static final /*uint*/int IMAGE_FILE_MACHINE_M32R = 0x9041;
  public static final /*uint*/int IMAGE_FILE_MACHINE_MIPS16 = 0x266;
  public static final /*uint*/int IMAGE_FILE_MACHINE_MIPSFPU = 0x366;
  public static final /*uint*/int IMAGE_FILE_MACHINE_MIPSFPU16 = 0x466;
  public static final /*uint*/int IMAGE_FILE_MACHINE_POWERPC = 0x1F0;
  public static final /*uint*/int IMAGE_FILE_MACHINE_POWERPCFP = 0x1F1;
  public static final /*uint*/int IMAGE_FILE_MACHINE_R4000 = 0x166;
  public static final /*uint*/int IMAGE_FILE_MACHINE_SH3 = 0x1A2;
  public static final /*uint*/int IMAGE_FILE_MACHINE_SH3DSP = 0x1A3;
  public static final /*uint*/int IMAGE_FILE_MACHINE_SH4 = 0x1A6;
  public static final /*uint*/int IMAGE_FILE_MACHINE_SH5 = 0x1A8;
  public static final /*uint*/int IMAGE_FILE_MACHINE_THUMB = 0x1C2;
  public static final /*uint*/int IMAGE_FILE_MACHINE_WCEMIPSV2 = 0x169;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::Characteristics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 110,
 FQN="llvm::COFF::Characteristics", NM="_ZN4llvm4COFF15CharacteristicsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF15CharacteristicsE")
//</editor-fold>
public static final class/*enum*/ Characteristics {
  public static final /*uint*/int C_Invalid = 0;
  
  /// The file does not contain base relocations and must be loaded at its
  /// preferred base. If this cannot be done, the loader will error.
  public static final /*uint*/int IMAGE_FILE_RELOCS_STRIPPED = 0x0001;
  /// The file is valid and can be run.
  public static final /*uint*/int IMAGE_FILE_EXECUTABLE_IMAGE = 0x0002;
  /// COFF line numbers have been stripped. This is deprecated and should be
  /// 0.
  public static final /*uint*/int IMAGE_FILE_LINE_NUMS_STRIPPED = 0x0004;
  /// COFF symbol table entries for local symbols have been removed. This is
  /// deprecated and should be 0.
  public static final /*uint*/int IMAGE_FILE_LOCAL_SYMS_STRIPPED = 0x0008;
  /// Aggressively trim working set. This is deprecated and must be 0.
  public static final /*uint*/int IMAGE_FILE_AGGRESSIVE_WS_TRIM = 0x0010;
  /// Image can handle > 2GiB addresses.
  public static final /*uint*/int IMAGE_FILE_LARGE_ADDRESS_AWARE = 0x0020;
  /// Little endian: the LSB precedes the MSB in memory. This is deprecated
  /// and should be 0.
  public static final /*uint*/int IMAGE_FILE_BYTES_REVERSED_LO = 0x0080;
  /// Machine is based on a 32bit word architecture.
  public static final /*uint*/int IMAGE_FILE_32BIT_MACHINE = 0x0100;
  /// Debugging info has been removed.
  public static final /*uint*/int IMAGE_FILE_DEBUG_STRIPPED = 0x0200;
  /// If the image is on removable media, fully load it and copy it to swap.
  public static final /*uint*/int IMAGE_FILE_REMOVABLE_RUN_FROM_SWAP = 0x0400;
  /// If the image is on network media, fully load it and copy it to swap.
  public static final /*uint*/int IMAGE_FILE_NET_RUN_FROM_SWAP = 0x0800;
  /// The image file is a system file, not a user program.
  public static final /*uint*/int IMAGE_FILE_SYSTEM = 0x1000;
  /// The image file is a DLL.
  public static final /*uint*/int IMAGE_FILE_DLL = 0x2000;
  /// This file should only be run on a uniprocessor machine.
  public static final /*uint*/int IMAGE_FILE_UP_SYSTEM_ONLY = 0x4000;
  /// Big endian: the MSB precedes the LSB in memory. This is deprecated
  /// and should be 0.
  public static final /*uint*/int IMAGE_FILE_BYTES_REVERSED_HI = 0x8000;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::symbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 150,
 FQN="llvm::COFF::symbol", NM="_ZN4llvm4COFF6symbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF6symbolE")
//</editor-fold>
public static class/*struct*/ symbol {
  public /*char*/byte Name[/*8*/] = new$char(8);
  public /*uint32_t*/int Value;
  public int/*int32_t*/ SectionNumber;
  public /*uint16_t*/char Type;
  public byte/*uint8_t*/ StorageClass;
  public byte/*uint8_t*/ NumberOfAuxSymbols;

  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::symbol::symbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 150,
   FQN="llvm::COFF::symbol::symbol", NM="_ZN4llvm4COFF6symbolC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF6symbolC1Ev")
  //</editor-fold>
  public /*inline*/ symbol() {
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Value=" + Value // NOI18N
              + ", SectionNumber=" + SectionNumber // NOI18N
              + ", Type=" + $ushort2uint(Type) // NOI18N
              + ", StorageClass=" + $uchar2uint(StorageClass) // NOI18N
              + ", NumberOfAuxSymbols=" + $uchar2uint(NumberOfAuxSymbols); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::SymbolSectionNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 159,
 FQN="llvm::COFF::SymbolSectionNumber", NM="_ZN4llvm4COFF19SymbolSectionNumberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF19SymbolSectionNumberE")
//</editor-fold>
public enum SymbolSectionNumber/* : int32_t*/ implements Native.NativeIntEnum {
  IMAGE_SYM_DEBUG(-2),
  IMAGE_SYM_ABSOLUTE(-1),
  IMAGE_SYM_UNDEFINED(0);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SymbolSectionNumber valueOf(int val) {
    SymbolSectionNumber out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SymbolSectionNumber[] VALUES;
    private static final SymbolSectionNumber[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SymbolSectionNumber kind : SymbolSectionNumber.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SymbolSectionNumber[min < 0 ? (1-min) : 0];
      VALUES = new SymbolSectionNumber[max >= 0 ? (1+max) : 0];
      for (SymbolSectionNumber kind : SymbolSectionNumber.values()) {
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

  private final int/*int32_t*/ value;
  private SymbolSectionNumber(int val) { this.value = (int/*int32_t*/)val;}
  @Override public final int/*int32_t*/ getValue() { return value;}
  //</editor-fold>
}

/// Storage class tells where and what the symbol represents
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::SymbolStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 166,
 FQN="llvm::COFF::SymbolStorageClass", NM="_ZN4llvm4COFF18SymbolStorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18SymbolStorageClassE")
//</editor-fold>
public static final class/*enum*/ SymbolStorageClass {
  public static final int SSC_Invalid = 0xff;
  
  public static final int IMAGE_SYM_CLASS_END_OF_FUNCTION = -1; ///< Physical end of function
  public static final int IMAGE_SYM_CLASS_NULL = 0; ///< No symbol
  public static final int IMAGE_SYM_CLASS_AUTOMATIC = 1; ///< Stack variable
  public static final int IMAGE_SYM_CLASS_EXTERNAL = 2; ///< External symbol
  public static final int IMAGE_SYM_CLASS_STATIC = 3; ///< Static
  public static final int IMAGE_SYM_CLASS_REGISTER = 4; ///< Register variable
  public static final int IMAGE_SYM_CLASS_EXTERNAL_DEF = 5; ///< External definition
  public static final int IMAGE_SYM_CLASS_LABEL = 6; ///< Label
  public static final int IMAGE_SYM_CLASS_UNDEFINED_LABEL = 7; ///< Undefined label
  public static final int IMAGE_SYM_CLASS_MEMBER_OF_STRUCT = 8; ///< Member of structure
  public static final int IMAGE_SYM_CLASS_ARGUMENT = 9; ///< Function argument
  public static final int IMAGE_SYM_CLASS_STRUCT_TAG = 10; ///< Structure tag
  public static final int IMAGE_SYM_CLASS_MEMBER_OF_UNION = 11; ///< Member of union
  public static final int IMAGE_SYM_CLASS_UNION_TAG = 12; ///< Union tag
  public static final int IMAGE_SYM_CLASS_TYPE_DEFINITION = 13; ///< Type definition
  public static final int IMAGE_SYM_CLASS_UNDEFINED_STATIC = 14; ///< Undefined static
  public static final int IMAGE_SYM_CLASS_ENUM_TAG = 15; ///< Enumeration tag
  public static final int IMAGE_SYM_CLASS_MEMBER_OF_ENUM = 16; ///< Member of enumeration
  public static final int IMAGE_SYM_CLASS_REGISTER_PARAM = 17; ///< Register parameter
  public static final int IMAGE_SYM_CLASS_BIT_FIELD = 18; ///< Bit field
  /// ".bb" or ".eb" - beginning or end of block
  public static final int IMAGE_SYM_CLASS_BLOCK = 100;
  /// ".bf" or ".ef" - beginning or end of function
  public static final int IMAGE_SYM_CLASS_FUNCTION = 101;
  public static final int IMAGE_SYM_CLASS_END_OF_STRUCT = 102; ///< End of structure
  public static final int IMAGE_SYM_CLASS_FILE = 103; ///< File name
  /// Line number, reformatted as symbol
  public static final int IMAGE_SYM_CLASS_SECTION = 104;
  public static final int IMAGE_SYM_CLASS_WEAK_EXTERNAL = 105; ///< Duplicate tag
  /// External symbol in dmert public lib
  public static final int IMAGE_SYM_CLASS_CLR_TOKEN = 107;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::SymbolBaseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 202,
 FQN="llvm::COFF::SymbolBaseType", NM="_ZN4llvm4COFF14SymbolBaseTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF14SymbolBaseTypeE")
//</editor-fold>
public enum SymbolBaseType implements Native.NativeUIntEnum {
  IMAGE_SYM_TYPE_NULL(0), ///< No type information or unknown base type.
  IMAGE_SYM_TYPE_VOID(1), ///< Used with void pointers and functions.
  IMAGE_SYM_TYPE_CHAR(2), ///< A character (signed byte).
  IMAGE_SYM_TYPE_SHORT(3), ///< A 2-byte signed integer.
  IMAGE_SYM_TYPE_INT(4), ///< A natural integer type on the target.
  IMAGE_SYM_TYPE_LONG(5), ///< A 4-byte signed integer.
  IMAGE_SYM_TYPE_FLOAT(6), ///< A 4-byte floating-point number.
  IMAGE_SYM_TYPE_DOUBLE(7), ///< An 8-byte floating-point number.
  IMAGE_SYM_TYPE_STRUCT(8), ///< A structure.
  IMAGE_SYM_TYPE_UNION(9), ///< An union.
  IMAGE_SYM_TYPE_ENUM(10), ///< An enumerated type.
  IMAGE_SYM_TYPE_MOE(11), ///< A member of enumeration (a specific value).
  IMAGE_SYM_TYPE_BYTE(12), ///< A byte; unsigned 1-byte integer.
  IMAGE_SYM_TYPE_WORD(13), ///< A word; unsigned 2-byte integer.
  IMAGE_SYM_TYPE_UINT(14), ///< An unsigned integer of natural size.
  IMAGE_SYM_TYPE_DWORD(15); ///< An unsigned 4-byte integer.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SymbolBaseType valueOf(int val) {
    SymbolBaseType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SymbolBaseType[] VALUES;
    private static final SymbolBaseType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SymbolBaseType kind : SymbolBaseType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SymbolBaseType[min < 0 ? (1-min) : 0];
      VALUES = new SymbolBaseType[max >= 0 ? (1+max) : 0];
      for (SymbolBaseType kind : SymbolBaseType.values()) {
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
  private SymbolBaseType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::SymbolComplexType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 221,
 FQN="llvm::COFF::SymbolComplexType", NM="_ZN4llvm4COFF17SymbolComplexTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF17SymbolComplexTypeE")
//</editor-fold>
public enum SymbolComplexType implements Native.NativeUIntEnum {
  IMAGE_SYM_DTYPE_NULL(0), ///< No complex type; simple scalar variable.
  IMAGE_SYM_DTYPE_POINTER(1), ///< A pointer to base type.
  IMAGE_SYM_DTYPE_FUNCTION(2), ///< A function that returns a base type.
  IMAGE_SYM_DTYPE_ARRAY(3), ///< An array of base type.
  
  /// Type is formed as (base + (derived << SCT_COMPLEX_TYPE_SHIFT))
  SCT_COMPLEX_TYPE_SHIFT(4);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SymbolComplexType valueOf(int val) {
    SymbolComplexType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SymbolComplexType[] VALUES;
    private static final SymbolComplexType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SymbolComplexType kind : SymbolComplexType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SymbolComplexType[min < 0 ? (1-min) : 0];
      VALUES = new SymbolComplexType[max >= 0 ? (1+max) : 0];
      for (SymbolComplexType kind : SymbolComplexType.values()) {
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
  private SymbolComplexType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxSymbolType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 231,
 FQN="llvm::COFF::AuxSymbolType", NM="_ZN4llvm4COFF13AuxSymbolTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF13AuxSymbolTypeE")
//</editor-fold>
public enum AuxSymbolType implements Native.NativeUIntEnum {
  IMAGE_AUX_SYMBOL_TYPE_TOKEN_DEF(1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AuxSymbolType valueOf(int val) {
    AuxSymbolType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AuxSymbolType[] VALUES;
    private static final AuxSymbolType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AuxSymbolType kind : AuxSymbolType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AuxSymbolType[min < 0 ? (1-min) : 0];
      VALUES = new AuxSymbolType[max >= 0 ? (1+max) : 0];
      for (AuxSymbolType kind : AuxSymbolType.values()) {
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
  private AuxSymbolType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::section">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 235,
 FQN="llvm::COFF::section", NM="_ZN4llvm4COFF7sectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF7sectionE")
//</editor-fold>
public static class/*struct*/ section {
  public /*char*/byte Name[/*8*/] = new$char(8);
  public /*uint32_t*/int VirtualSize;
  public /*uint32_t*/int VirtualAddress;
  public /*uint32_t*/int SizeOfRawData;
  public /*uint32_t*/int PointerToRawData;
  public /*uint32_t*/int PointerToRelocations;
  public /*uint32_t*/int PointerToLineNumbers;
  public /*uint16_t*/char NumberOfRelocations;
  public /*uint16_t*/char NumberOfLineNumbers;
  public /*uint32_t*/int Characteristics;

  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::section::section">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 235,
   FQN="llvm::COFF::section::section", NM="_ZN4llvm4COFF7sectionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF7sectionC1Ev")
  //</editor-fold>
  public /*inline*/ section() {
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", VirtualSize=" + VirtualSize // NOI18N
              + ", VirtualAddress=" + VirtualAddress // NOI18N
              + ", SizeOfRawData=" + SizeOfRawData // NOI18N
              + ", PointerToRawData=" + PointerToRawData // NOI18N
              + ", PointerToRelocations=" + PointerToRelocations // NOI18N
              + ", PointerToLineNumbers=" + PointerToLineNumbers // NOI18N
              + ", NumberOfRelocations=" + $ushort2uint(NumberOfRelocations) // NOI18N
              + ", NumberOfLineNumbers=" + $ushort2uint(NumberOfLineNumbers) // NOI18N
              + ", Characteristics=" + Characteristics; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::SectionCharacteristics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 248,
 FQN="llvm::COFF::SectionCharacteristics", NM="_ZN4llvm4COFF22SectionCharacteristicsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF22SectionCharacteristicsE")
//</editor-fold>
public static final class/*enum*/ SectionCharacteristics/* : uint32_t*/ {
  public static final /*uint32_t*/int SC_Invalid = 0xffffffff/*U*/;
  
  public static final /*uint32_t*/int IMAGE_SCN_TYPE_NOLOAD = 0x00000002;
  public static final /*uint32_t*/int IMAGE_SCN_TYPE_NO_PAD = 0x00000008;
  public static final /*uint32_t*/int IMAGE_SCN_CNT_CODE = 0x00000020;
  public static final /*uint32_t*/int IMAGE_SCN_CNT_INITIALIZED_DATA = 0x00000040;
  public static final /*uint32_t*/int IMAGE_SCN_CNT_UNINITIALIZED_DATA = 0x00000080;
  public static final /*uint32_t*/int IMAGE_SCN_LNK_OTHER = 0x00000100;
  public static final /*uint32_t*/int IMAGE_SCN_LNK_INFO = 0x00000200;
  public static final /*uint32_t*/int IMAGE_SCN_LNK_REMOVE = 0x00000800;
  public static final /*uint32_t*/int IMAGE_SCN_LNK_COMDAT = 0x00001000;
  public static final /*uint32_t*/int IMAGE_SCN_GPREL = 0x00008000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_PURGEABLE = 0x00020000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_16BIT = 0x00020000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_LOCKED = 0x00040000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_PRELOAD = 0x00080000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_1BYTES = 0x00100000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_2BYTES = 0x00200000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_4BYTES = 0x00300000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_8BYTES = 0x00400000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_16BYTES = 0x00500000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_32BYTES = 0x00600000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_64BYTES = 0x00700000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_128BYTES = 0x00800000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_256BYTES = 0x00900000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_512BYTES = 0x00A00000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_1024BYTES = 0x00B00000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_2048BYTES = 0x00C00000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_4096BYTES = 0x00D00000;
  public static final /*uint32_t*/int IMAGE_SCN_ALIGN_8192BYTES = 0x00E00000;
  public static final /*uint32_t*/int IMAGE_SCN_LNK_NRELOC_OVFL = 0x01000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_DISCARDABLE = 0x02000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_NOT_CACHED = 0x04000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_NOT_PAGED = 0x08000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_SHARED = 0x10000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_EXECUTE = 0x20000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_READ = 0x40000000;
  public static final /*uint32_t*/int IMAGE_SCN_MEM_WRITE = 0x80000000/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::relocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 289,
 FQN="llvm::COFF::relocation", NM="_ZN4llvm4COFF10relocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF10relocationE")
//</editor-fold>
public static class/*struct*/ relocation {
  public /*uint32_t*/int VirtualAddress;
  public /*uint32_t*/int SymbolTableIndex;
  public /*uint16_t*/char Type;

  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::relocation::relocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 289,
   FQN="llvm::COFF::relocation::relocation", NM="_ZN4llvm4COFF10relocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF10relocationC1Ev")
  //</editor-fold>
  public /*inline*/ relocation() {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::relocation::relocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 289,
   FQN="llvm::COFF::relocation::relocation", NM="_ZN4llvm4COFF10relocationC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF10relocationC1ERKS1_")
  //</editor-fold>
  public /*inline*/ relocation(final /*const*/ relocation /*&*/ $Prm0) {
    // : VirtualAddress(.VirtualAddress), SymbolTableIndex(.SymbolTableIndex), Type(.Type) 
    //START JInit
    this.VirtualAddress = $Prm0.VirtualAddress;
    this.SymbolTableIndex = $Prm0.SymbolTableIndex;
    this.Type = $Prm0.Type;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::relocation::relocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 289,
   FQN="llvm::COFF::relocation::relocation", NM="_ZN4llvm4COFF10relocationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm4COFF10relocationC1EOS1_")
  //</editor-fold>
  public /*inline*/ relocation(JD$Move _dparam, final relocation /*&&*/$Prm0) {
    // : VirtualAddress(static_cast<relocation &&>().VirtualAddress), SymbolTableIndex(static_cast<relocation &&>().SymbolTableIndex), Type(static_cast<relocation &&>().Type) 
    //START JInit
    this.VirtualAddress = $Prm0.VirtualAddress;
    this.SymbolTableIndex = $Prm0.SymbolTableIndex;
    this.Type = $Prm0.Type;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "VirtualAddress=" + VirtualAddress // NOI18N
              + ", SymbolTableIndex=" + SymbolTableIndex // NOI18N
              + ", Type=" + $ushort2uint(Type); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::RelocationTypeI386">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 295,
 FQN="llvm::COFF::RelocationTypeI386", NM="_ZN4llvm4COFF18RelocationTypeI386E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18RelocationTypeI386E")
//</editor-fold>
public static final class/*enum*/ RelocationTypeI386 {
  public static final /*uint*/int IMAGE_REL_I386_ABSOLUTE = 0x0000;
  public static final /*uint*/int IMAGE_REL_I386_DIR16 = 0x0001;
  public static final /*uint*/int IMAGE_REL_I386_REL16 = 0x0002;
  public static final /*uint*/int IMAGE_REL_I386_DIR32 = 0x0006;
  public static final /*uint*/int IMAGE_REL_I386_DIR32NB = 0x0007;
  public static final /*uint*/int IMAGE_REL_I386_SEG12 = 0x0009;
  public static final /*uint*/int IMAGE_REL_I386_SECTION = 0x000A;
  public static final /*uint*/int IMAGE_REL_I386_SECREL = 0x000B;
  public static final /*uint*/int IMAGE_REL_I386_TOKEN = 0x000C;
  public static final /*uint*/int IMAGE_REL_I386_SECREL7 = 0x000D;
  public static final /*uint*/int IMAGE_REL_I386_REL32 = 0x0014;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::RelocationTypeAMD64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 309,
 FQN="llvm::COFF::RelocationTypeAMD64", NM="_ZN4llvm4COFF19RelocationTypeAMD64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF19RelocationTypeAMD64E")
//</editor-fold>
public static final class/*enum*/ RelocationTypeAMD64 {
  public static final /*uint*/int IMAGE_REL_AMD64_ABSOLUTE = 0x0000;
  public static final /*uint*/int IMAGE_REL_AMD64_ADDR64 = 0x0001;
  public static final /*uint*/int IMAGE_REL_AMD64_ADDR32 = 0x0002;
  public static final /*uint*/int IMAGE_REL_AMD64_ADDR32NB = 0x0003;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32 = 0x0004;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32_1 = 0x0005;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32_2 = 0x0006;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32_3 = 0x0007;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32_4 = 0x0008;
  public static final /*uint*/int IMAGE_REL_AMD64_REL32_5 = 0x0009;
  public static final /*uint*/int IMAGE_REL_AMD64_SECTION = 0x000A;
  public static final /*uint*/int IMAGE_REL_AMD64_SECREL = 0x000B;
  public static final /*uint*/int IMAGE_REL_AMD64_SECREL7 = 0x000C;
  public static final /*uint*/int IMAGE_REL_AMD64_TOKEN = 0x000D;
  public static final /*uint*/int IMAGE_REL_AMD64_SREL32 = 0x000E;
  public static final /*uint*/int IMAGE_REL_AMD64_PAIR = 0x000F;
  public static final /*uint*/int IMAGE_REL_AMD64_SSPAN32 = 0x0010;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::RelocationTypesARM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 329,
 FQN="llvm::COFF::RelocationTypesARM", NM="_ZN4llvm4COFF18RelocationTypesARME",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18RelocationTypesARME")
//</editor-fold>
public static final class/*enum*/ RelocationTypesARM {
  public static final /*uint*/int IMAGE_REL_ARM_ABSOLUTE = 0x0000;
  public static final /*uint*/int IMAGE_REL_ARM_ADDR32 = 0x0001;
  public static final /*uint*/int IMAGE_REL_ARM_ADDR32NB = 0x0002;
  public static final /*uint*/int IMAGE_REL_ARM_BRANCH24 = 0x0003;
  public static final /*uint*/int IMAGE_REL_ARM_BRANCH11 = 0x0004;
  public static final /*uint*/int IMAGE_REL_ARM_TOKEN = 0x0005;
  public static final /*uint*/int IMAGE_REL_ARM_BLX24 = 0x0008;
  public static final /*uint*/int IMAGE_REL_ARM_BLX11 = 0x0009;
  public static final /*uint*/int IMAGE_REL_ARM_SECTION = 0x000E;
  public static final /*uint*/int IMAGE_REL_ARM_SECREL = 0x000F;
  public static final /*uint*/int IMAGE_REL_ARM_MOV32A = 0x0010;
  public static final /*uint*/int IMAGE_REL_ARM_MOV32T = 0x0011;
  public static final /*uint*/int IMAGE_REL_ARM_BRANCH20T = 0x0012;
  public static final /*uint*/int IMAGE_REL_ARM_BRANCH24T = 0x0014;
  public static final /*uint*/int IMAGE_REL_ARM_BLX23T = 0x0015;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::COMDATType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 347,
 FQN="llvm::COFF::COMDATType", NM="_ZN4llvm4COFF10COMDATTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF10COMDATTypeE")
//</editor-fold>
public enum COMDATType implements Native.NativeUIntEnum {
  IMAGE_COMDAT_SELECT_NODUPLICATES(1),
  IMAGE_COMDAT_SELECT_ANY(IMAGE_COMDAT_SELECT_NODUPLICATES.getValue() + 1),
  IMAGE_COMDAT_SELECT_SAME_SIZE(IMAGE_COMDAT_SELECT_ANY.getValue() + 1),
  IMAGE_COMDAT_SELECT_EXACT_MATCH(IMAGE_COMDAT_SELECT_SAME_SIZE.getValue() + 1),
  IMAGE_COMDAT_SELECT_ASSOCIATIVE(IMAGE_COMDAT_SELECT_EXACT_MATCH.getValue() + 1),
  IMAGE_COMDAT_SELECT_LARGEST(IMAGE_COMDAT_SELECT_ASSOCIATIVE.getValue() + 1),
  IMAGE_COMDAT_SELECT_NEWEST(IMAGE_COMDAT_SELECT_LARGEST.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static COMDATType valueOf(int val) {
    COMDATType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final COMDATType[] VALUES;
    private static final COMDATType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (COMDATType kind : COMDATType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new COMDATType[min < 0 ? (1-min) : 0];
      VALUES = new COMDATType[max >= 0 ? (1+max) : 0];
      for (COMDATType kind : COMDATType.values()) {
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
  private COMDATType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

// Auxiliary Symbol Formats
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxiliaryFunctionDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 358,
 FQN="llvm::COFF::AuxiliaryFunctionDefinition", NM="_ZN4llvm4COFF27AuxiliaryFunctionDefinitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF27AuxiliaryFunctionDefinitionE")
//</editor-fold>
public static class/*struct*/ AuxiliaryFunctionDefinition {
  public /*uint32_t*/int TagIndex;
  public /*uint32_t*/int TotalSize;
  public /*uint32_t*/int PointerToLinenumber;
  public /*uint32_t*/int PointerToNextFunction;
  public /*char*/byte unused[/*2*/] = new$char(2);
  
  @Override public String toString() {
    return "" + "TagIndex=" + TagIndex // NOI18N
              + ", TotalSize=" + TotalSize // NOI18N
              + ", PointerToLinenumber=" + PointerToLinenumber // NOI18N
              + ", PointerToNextFunction=" + PointerToNextFunction // NOI18N
              + ", unused=" + unused; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxiliarybfAndefSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 366,
 FQN="llvm::COFF::AuxiliarybfAndefSymbol", NM="_ZN4llvm4COFF22AuxiliarybfAndefSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF22AuxiliarybfAndefSymbolE")
//</editor-fold>
public static class/*struct*/ AuxiliarybfAndefSymbol {
  public byte/*uint8_t*/ unused1[/*4*/] = new$char(4);
  public /*uint16_t*/char Linenumber;
  public byte/*uint8_t*/ unused2[/*6*/] = new$char(6);
  public /*uint32_t*/int PointerToNextFunction;
  public byte/*uint8_t*/ unused3[/*2*/] = new$char(2);
  
  @Override public String toString() {
    return "" + "unused1=" + unused1 // NOI18N
              + ", Linenumber=" + $ushort2uint(Linenumber) // NOI18N
              + ", unused2=" + unused2 // NOI18N
              + ", PointerToNextFunction=" + PointerToNextFunction // NOI18N
              + ", unused3=" + unused3; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxiliaryWeakExternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 374,
 FQN="llvm::COFF::AuxiliaryWeakExternal", NM="_ZN4llvm4COFF21AuxiliaryWeakExternalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF21AuxiliaryWeakExternalE")
//</editor-fold>
public static class/*struct*/ AuxiliaryWeakExternal {
  public /*uint32_t*/int TagIndex;
  public /*uint32_t*/int Characteristics;
  public byte/*uint8_t*/ unused[/*10*/] = new$char(10);
  
  @Override public String toString() {
    return "" + "TagIndex=" + TagIndex // NOI18N
              + ", Characteristics=" + Characteristics // NOI18N
              + ", unused=" + unused; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::WeakExternalCharacteristics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 380,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 381,
 FQN="llvm::COFF::WeakExternalCharacteristics", NM="_ZN4llvm4COFF27WeakExternalCharacteristicsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF27WeakExternalCharacteristicsE")
//</editor-fold>
public enum WeakExternalCharacteristics implements Native.NativeUIntEnum {
  IMAGE_WEAK_EXTERN_SEARCH_NOLIBRARY(1),
  IMAGE_WEAK_EXTERN_SEARCH_LIBRARY(2),
  IMAGE_WEAK_EXTERN_SEARCH_ALIAS(3);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static WeakExternalCharacteristics valueOf(int val) {
    WeakExternalCharacteristics out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final WeakExternalCharacteristics[] VALUES;
    private static final WeakExternalCharacteristics[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (WeakExternalCharacteristics kind : WeakExternalCharacteristics.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new WeakExternalCharacteristics[min < 0 ? (1-min) : 0];
      VALUES = new WeakExternalCharacteristics[max >= 0 ? (1+max) : 0];
      for (WeakExternalCharacteristics kind : WeakExternalCharacteristics.values()) {
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
  private WeakExternalCharacteristics(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxiliarySectionDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 386,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 387,
 FQN="llvm::COFF::AuxiliarySectionDefinition", NM="_ZN4llvm4COFF26AuxiliarySectionDefinitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF26AuxiliarySectionDefinitionE")
//</editor-fold>
public static class/*struct*/ AuxiliarySectionDefinition {
  public /*uint32_t*/int Length;
  public /*uint16_t*/char NumberOfRelocations;
  public /*uint16_t*/char NumberOfLinenumbers;
  public /*uint32_t*/int CheckSum;
  public /*uint32_t*/int Number;
  public byte/*uint8_t*/ Selection;
  public /*char*/byte unused;
  
  @Override public String toString() {
    return "" + "Length=" + Length // NOI18N
              + ", NumberOfRelocations=" + $ushort2uint(NumberOfRelocations) // NOI18N
              + ", NumberOfLinenumbers=" + $ushort2uint(NumberOfLinenumbers) // NOI18N
              + ", CheckSum=" + CheckSum // NOI18N
              + ", Number=" + Number // NOI18N
              + ", Selection=" + $uchar2uint(Selection) // NOI18N
              + ", unused=" + unused; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::AuxiliaryCLRToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 396,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 397,
 FQN="llvm::COFF::AuxiliaryCLRToken", NM="_ZN4llvm4COFF17AuxiliaryCLRTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF17AuxiliaryCLRTokenE")
//</editor-fold>
public static class/*struct*/ AuxiliaryCLRToken {
  public byte/*uint8_t*/ AuxType;
  public byte/*uint8_t*/ unused1;
  public /*uint32_t*/int SymbolTableIndex;
  public /*char*/byte unused2[/*12*/] = new$char(12);
  
  @Override public String toString() {
    return "" + "AuxType=" + $uchar2uint(AuxType) // NOI18N
              + ", unused1=" + $uchar2uint(unused1) // NOI18N
              + ", SymbolTableIndex=" + SymbolTableIndex // NOI18N
              + ", unused2=" + unused2; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::Auxiliary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 403,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 404,
 FQN="llvm::COFF::Auxiliary", NM="_ZN4llvm4COFF9AuxiliaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF9AuxiliaryE")
//</editor-fold>
public static class/*union*/ Auxiliary {
  public AuxiliaryFunctionDefinition FunctionDefinition;
  public AuxiliarybfAndefSymbol bfAndefSymbol;
  public AuxiliaryWeakExternal WeakExternal;
  public AuxiliarySectionDefinition SectionDefinition;
  
  @Override public String toString() {
    return "" + "FunctionDefinition=" + FunctionDefinition // NOI18N
              + ", bfAndefSymbol=" + bfAndefSymbol // NOI18N
              + ", WeakExternal=" + WeakExternal // NOI18N
              + ", SectionDefinition=" + SectionDefinition; // NOI18N
  }
}

/// @brief The Import Directory Table.
///
/// There is a single array of these and one entry per imported DLL.
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportDirectoryTableEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 413,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 414,
 FQN="llvm::COFF::ImportDirectoryTableEntry", NM="_ZN4llvm4COFF25ImportDirectoryTableEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF25ImportDirectoryTableEntryE")
//</editor-fold>
public static class/*struct*/ ImportDirectoryTableEntry {
  public /*uint32_t*/int ImportLookupTableRVA;
  public /*uint32_t*/int TimeDateStamp;
  public /*uint32_t*/int ForwarderChain;
  public /*uint32_t*/int NameRVA;
  public /*uint32_t*/int ImportAddressTableRVA;
  
  @Override public String toString() {
    return "" + "ImportLookupTableRVA=" + ImportLookupTableRVA // NOI18N
              + ", TimeDateStamp=" + TimeDateStamp // NOI18N
              + ", ForwarderChain=" + ForwarderChain // NOI18N
              + ", NameRVA=" + NameRVA // NOI18N
              + ", ImportAddressTableRVA=" + ImportAddressTableRVA; // NOI18N
  }
}

/// @brief The PE32 Import Lookup Table.
///
/// There is an array of these for each imported DLL. It represents either
/// the ordinal to import from the target DLL, or a name to lookup and import
/// from the target DLL.
///
/// This also happens to be the same format used by the Import Address Table
/// when it is initially written out to the image.
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 429,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 430,
 FQN="llvm::COFF::ImportLookupTableEntry32", NM="_ZN4llvm4COFF24ImportLookupTableEntry32E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF24ImportLookupTableEntry32E")
//</editor-fold>
public static class/*struct*/ ImportLookupTableEntry32 {
  public /*uint32_t*/int data;
  
  /// @brief Is this entry specified by ordinal, or name?
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32::isOrdinal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 433,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 434,
   FQN="llvm::COFF::ImportLookupTableEntry32::isOrdinal", NM="_ZNK4llvm4COFF24ImportLookupTableEntry329isOrdinalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm4COFF24ImportLookupTableEntry329isOrdinalEv")
  //</editor-fold>
  public boolean isOrdinal() /*const*/ {
    return ((data & 0x80000000/*U*/) != 0);
  }

  
  /// @brief Get the ordinal value of this entry. isOrdinal must be true.
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32::getOrdinal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 437,
   FQN="llvm::COFF::ImportLookupTableEntry32::getOrdinal", NM="_ZNK4llvm4COFF24ImportLookupTableEntry3210getOrdinalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm4COFF24ImportLookupTableEntry3210getOrdinalEv")
  //</editor-fold>
  public /*uint16_t*/char getOrdinal() /*const*/ {
    assert (isOrdinal()) : "ILT entry is not an ordinal!";
    return $uint2ushort(data & 0xFFFF);
  }

  
  /// @brief Set the ordinal value and set isOrdinal to true.
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32::setOrdinal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 443,
   FQN="llvm::COFF::ImportLookupTableEntry32::setOrdinal", NM="_ZN4llvm4COFF24ImportLookupTableEntry3210setOrdinalEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF24ImportLookupTableEntry3210setOrdinalEt")
  //</editor-fold>
  public void setOrdinal(/*uint16_t*/char o) {
    data = $ushort2uint(o);
    data |= 0x80000000/*U*/;
  }

  
  /// @brief Get the Hint/Name entry RVA. isOrdinal must be false.
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32::getHintNameRVA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 449,
   FQN="llvm::COFF::ImportLookupTableEntry32::getHintNameRVA", NM="_ZNK4llvm4COFF24ImportLookupTableEntry3214getHintNameRVAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm4COFF24ImportLookupTableEntry3214getHintNameRVAEv")
  //</editor-fold>
  public /*uint32_t*/int getHintNameRVA() /*const*/ {
    assert (!isOrdinal()) : "ILT entry is not a Hint/Name RVA!";
    return data;
  }

  
  /// @brief Set the Hint/Name entry RVA and set isOrdinal to false.
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportLookupTableEntry32::setHintNameRVA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 454,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 455,
   FQN="llvm::COFF::ImportLookupTableEntry32::setHintNameRVA", NM="_ZN4llvm4COFF24ImportLookupTableEntry3214setHintNameRVAEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF24ImportLookupTableEntry3214setHintNameRVAEj")
  //</editor-fold>
  public void setHintNameRVA(/*uint32_t*/int rva) {
    data = rva;
  }

  
  @Override public String toString() {
    return "" + "data=" + data; // NOI18N
  }
}

/// @brief The DOS compatible header at the front of all PEs.
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::DOSHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 458,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 459,
 FQN="llvm::COFF::DOSHeader", NM="_ZN4llvm4COFF9DOSHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF9DOSHeaderE")
//</editor-fold>
public static class/*struct*/ DOSHeader {
  public /*uint16_t*/char Magic;
  public /*uint16_t*/char UsedBytesInTheLastPage;
  public /*uint16_t*/char FileSizeInPages;
  public /*uint16_t*/char NumberOfRelocationItems;
  public /*uint16_t*/char HeaderSizeInParagraphs;
  public /*uint16_t*/char MinimumExtraParagraphs;
  public /*uint16_t*/char MaximumExtraParagraphs;
  public /*uint16_t*/char InitialRelativeSS;
  public /*uint16_t*/char InitialSP;
  public /*uint16_t*/char Checksum;
  public /*uint16_t*/char InitialIP;
  public /*uint16_t*/char InitialRelativeCS;
  public /*uint16_t*/char AddressOfRelocationTable;
  public /*uint16_t*/char OverlayNumber;
  public /*uint16_t*/char Reserved[/*4*/] = new$ushort(4);
  public /*uint16_t*/char OEMid;
  public /*uint16_t*/char OEMinfo;
  public /*uint16_t*/char Reserved2[/*10*/] = new$ushort(10);
  public /*uint32_t*/int AddressOfNewExeHeader;
  
  @Override public String toString() {
    return "" + "Magic=" + $ushort2uint(Magic) // NOI18N
              + ", UsedBytesInTheLastPage=" + $ushort2uint(UsedBytesInTheLastPage) // NOI18N
              + ", FileSizeInPages=" + $ushort2uint(FileSizeInPages) // NOI18N
              + ", NumberOfRelocationItems=" + $ushort2uint(NumberOfRelocationItems) // NOI18N
              + ", HeaderSizeInParagraphs=" + $ushort2uint(HeaderSizeInParagraphs) // NOI18N
              + ", MinimumExtraParagraphs=" + $ushort2uint(MinimumExtraParagraphs) // NOI18N
              + ", MaximumExtraParagraphs=" + $ushort2uint(MaximumExtraParagraphs) // NOI18N
              + ", InitialRelativeSS=" + $ushort2uint(InitialRelativeSS) // NOI18N
              + ", InitialSP=" + $ushort2uint(InitialSP) // NOI18N
              + ", Checksum=" + $ushort2uint(Checksum) // NOI18N
              + ", InitialIP=" + $ushort2uint(InitialIP) // NOI18N
              + ", InitialRelativeCS=" + $ushort2uint(InitialRelativeCS) // NOI18N
              + ", AddressOfRelocationTable=" + $ushort2uint(AddressOfRelocationTable) // NOI18N
              + ", OverlayNumber=" + $ushort2uint(OverlayNumber) // NOI18N
              + ", Reserved=" + Reserved // NOI18N
              + ", OEMid=" + $ushort2uint(OEMid) // NOI18N
              + ", OEMinfo=" + $ushort2uint(OEMinfo) // NOI18N
              + ", Reserved2=" + Reserved2 // NOI18N
              + ", AddressOfNewExeHeader=" + AddressOfNewExeHeader; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::PE32Header">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 480,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 481,
 FQN="llvm::COFF::PE32Header", NM="_ZN4llvm4COFF10PE32HeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF10PE32HeaderE")
//</editor-fold>
public static class/*struct*/ PE32Header {
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::PE32Header::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 481,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 482,
   FQN="llvm::COFF::PE32Header::(anonymous)", NM="_ZN4llvm4COFF10PE32HeaderE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF10PE32HeaderE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int PE32 = 0x10b;
    public static final /*uint*/int PE32_PLUS = 0x20b;
  /*}*/;
  
  public /*uint16_t*/char Magic;
  public byte/*uint8_t*/ MajorLinkerVersion;
  public byte/*uint8_t*/ MinorLinkerVersion;
  public /*uint32_t*/int SizeOfCode;
  public /*uint32_t*/int SizeOfInitializedData;
  public /*uint32_t*/int SizeOfUninitializedData;
  public /*uint32_t*/int AddressOfEntryPoint; // RVA
  public /*uint32_t*/int BaseOfCode; // RVA
  public /*uint32_t*/int BaseOfData; // RVA
  public /*uint32_t*/int ImageBase;
  public /*uint32_t*/int SectionAlignment;
  public /*uint32_t*/int FileAlignment;
  public /*uint16_t*/char MajorOperatingSystemVersion;
  public /*uint16_t*/char MinorOperatingSystemVersion;
  public /*uint16_t*/char MajorImageVersion;
  public /*uint16_t*/char MinorImageVersion;
  public /*uint16_t*/char MajorSubsystemVersion;
  public /*uint16_t*/char MinorSubsystemVersion;
  public /*uint32_t*/int Win32VersionValue;
  public /*uint32_t*/int SizeOfImage;
  public /*uint32_t*/int SizeOfHeaders;
  public /*uint32_t*/int CheckSum;
  public /*uint16_t*/char Subsystem;
  // FIXME: This should be DllCharacteristics to match the COFF spec.
  public /*uint16_t*/char DLLCharacteristics;
  public /*uint32_t*/int SizeOfStackReserve;
  public /*uint32_t*/int SizeOfStackCommit;
  public /*uint32_t*/int SizeOfHeapReserve;
  public /*uint32_t*/int SizeOfHeapCommit;
  public /*uint32_t*/int LoaderFlags;
  // FIXME: This should be NumberOfRvaAndSizes to match the COFF spec.
  public /*uint32_t*/int NumberOfRvaAndSize;
  
  @Override public String toString() {
    return "" + "Magic=" + $ushort2uint(Magic) // NOI18N
              + ", MajorLinkerVersion=" + $uchar2uint(MajorLinkerVersion) // NOI18N
              + ", MinorLinkerVersion=" + $uchar2uint(MinorLinkerVersion) // NOI18N
              + ", SizeOfCode=" + SizeOfCode // NOI18N
              + ", SizeOfInitializedData=" + SizeOfInitializedData // NOI18N
              + ", SizeOfUninitializedData=" + SizeOfUninitializedData // NOI18N
              + ", AddressOfEntryPoint=" + AddressOfEntryPoint // NOI18N
              + ", BaseOfCode=" + BaseOfCode // NOI18N
              + ", BaseOfData=" + BaseOfData // NOI18N
              + ", ImageBase=" + ImageBase // NOI18N
              + ", SectionAlignment=" + SectionAlignment // NOI18N
              + ", FileAlignment=" + FileAlignment // NOI18N
              + ", MajorOperatingSystemVersion=" + $ushort2uint(MajorOperatingSystemVersion) // NOI18N
              + ", MinorOperatingSystemVersion=" + $ushort2uint(MinorOperatingSystemVersion) // NOI18N
              + ", MajorImageVersion=" + $ushort2uint(MajorImageVersion) // NOI18N
              + ", MinorImageVersion=" + $ushort2uint(MinorImageVersion) // NOI18N
              + ", MajorSubsystemVersion=" + $ushort2uint(MajorSubsystemVersion) // NOI18N
              + ", MinorSubsystemVersion=" + $ushort2uint(MinorSubsystemVersion) // NOI18N
              + ", Win32VersionValue=" + Win32VersionValue // NOI18N
              + ", SizeOfImage=" + SizeOfImage // NOI18N
              + ", SizeOfHeaders=" + SizeOfHeaders // NOI18N
              + ", CheckSum=" + CheckSum // NOI18N
              + ", Subsystem=" + $ushort2uint(Subsystem) // NOI18N
              + ", DLLCharacteristics=" + $ushort2uint(DLLCharacteristics) // NOI18N
              + ", SizeOfStackReserve=" + SizeOfStackReserve // NOI18N
              + ", SizeOfStackCommit=" + SizeOfStackCommit // NOI18N
              + ", SizeOfHeapReserve=" + SizeOfHeapReserve // NOI18N
              + ", SizeOfHeapCommit=" + SizeOfHeapCommit // NOI18N
              + ", LoaderFlags=" + LoaderFlags // NOI18N
              + ", NumberOfRvaAndSize=" + NumberOfRvaAndSize; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::DataDirectory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 520,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 521,
 FQN="llvm::COFF::DataDirectory", NM="_ZN4llvm4COFF13DataDirectoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF13DataDirectoryE")
//</editor-fold>
public static class/*struct*/ DataDirectory {
  public /*uint32_t*/int RelativeVirtualAddress;
  public /*uint32_t*/int Size;
  
  @Override public String toString() {
    return "" + "RelativeVirtualAddress=" + RelativeVirtualAddress // NOI18N
              + ", Size=" + Size; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::DataDirectoryIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 525,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 526,
 FQN="llvm::COFF::DataDirectoryIndex", NM="_ZN4llvm4COFF18DataDirectoryIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18DataDirectoryIndexE")
//</editor-fold>
public enum DataDirectoryIndex implements Native.NativeUIntEnum {
  EXPORT_TABLE(0),
  IMPORT_TABLE(EXPORT_TABLE.getValue() + 1),
  RESOURCE_TABLE(IMPORT_TABLE.getValue() + 1),
  EXCEPTION_TABLE(RESOURCE_TABLE.getValue() + 1),
  CERTIFICATE_TABLE(EXCEPTION_TABLE.getValue() + 1),
  BASE_RELOCATION_TABLE(CERTIFICATE_TABLE.getValue() + 1),
  DEBUG_DIRECTORY(BASE_RELOCATION_TABLE.getValue() + 1),
  ARCHITECTURE(DEBUG_DIRECTORY.getValue() + 1),
  GLOBAL_PTR(ARCHITECTURE.getValue() + 1),
  TLS_TABLE(GLOBAL_PTR.getValue() + 1),
  LOAD_CONFIG_TABLE(TLS_TABLE.getValue() + 1),
  BOUND_IMPORT(LOAD_CONFIG_TABLE.getValue() + 1),
  IAT(BOUND_IMPORT.getValue() + 1),
  DELAY_IMPORT_DESCRIPTOR(IAT.getValue() + 1),
  CLR_RUNTIME_HEADER(DELAY_IMPORT_DESCRIPTOR.getValue() + 1),
  
  NUM_DATA_DIRECTORIES(CLR_RUNTIME_HEADER.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DataDirectoryIndex valueOf(int val) {
    DataDirectoryIndex out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DataDirectoryIndex[] VALUES;
    private static final DataDirectoryIndex[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DataDirectoryIndex kind : DataDirectoryIndex.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DataDirectoryIndex[min < 0 ? (1-min) : 0];
      VALUES = new DataDirectoryIndex[max >= 0 ? (1+max) : 0];
      for (DataDirectoryIndex kind : DataDirectoryIndex.values()) {
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
  private DataDirectoryIndex(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::WindowsSubsystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 545,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 546,
 FQN="llvm::COFF::WindowsSubsystem", NM="_ZN4llvm4COFF16WindowsSubsystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF16WindowsSubsystemE")
//</editor-fold>
public enum WindowsSubsystem implements Native.NativeUIntEnum {
  IMAGE_SUBSYSTEM_UNKNOWN(0), ///< An unknown subsystem.
  IMAGE_SUBSYSTEM_NATIVE(1), ///< Device drivers and native Windows processes
  IMAGE_SUBSYSTEM_WINDOWS_GUI(2), ///< The Windows GUI subsystem.
  IMAGE_SUBSYSTEM_WINDOWS_CUI(3), ///< The Windows character subsystem.
  IMAGE_SUBSYSTEM_OS2_CUI(5), ///< The OS/2 character subsytem.
  IMAGE_SUBSYSTEM_POSIX_CUI(7), ///< The POSIX character subsystem.
  IMAGE_SUBSYSTEM_NATIVE_WINDOWS(8), ///< Native Windows 9x driver.
  IMAGE_SUBSYSTEM_WINDOWS_CE_GUI(9), ///< Windows CE.
  IMAGE_SUBSYSTEM_EFI_APPLICATION(10), ///< An EFI application.
  IMAGE_SUBSYSTEM_EFI_BOOT_SERVICE_DRIVER(11), ///< An EFI driver with boot
  ///  services.
  IMAGE_SUBSYSTEM_EFI_RUNTIME_DRIVER(12), ///< An EFI driver with run-time
  ///  services.
  IMAGE_SUBSYSTEM_EFI_ROM(13), ///< An EFI ROM image.
  IMAGE_SUBSYSTEM_XBOX(14), ///< XBOX.
  IMAGE_SUBSYSTEM_WINDOWS_BOOT_APPLICATION(16); ///< A BCD application.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static WindowsSubsystem valueOf(int val) {
    WindowsSubsystem out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final WindowsSubsystem[] VALUES;
    private static final WindowsSubsystem[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (WindowsSubsystem kind : WindowsSubsystem.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new WindowsSubsystem[min < 0 ? (1-min) : 0];
      VALUES = new WindowsSubsystem[max >= 0 ? (1+max) : 0];
      for (WindowsSubsystem kind : WindowsSubsystem.values()) {
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
  private WindowsSubsystem(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::DLLCharacteristics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 564,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 565,
 FQN="llvm::COFF::DLLCharacteristics", NM="_ZN4llvm4COFF18DLLCharacteristicsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18DLLCharacteristicsE")
//</editor-fold>
public static final class/*enum*/ DLLCharacteristics {
  /// ASLR with 64 bit address space.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_HIGH_ENTROPY_VA = 0x0020;
  /// DLL can be relocated at load time.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_DYNAMIC_BASE = 0x0040;
  /// Code integrity checks are enforced.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_FORCE_INTEGRITY = 0x0080;
  ///< Image is NX compatible.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_NX_COMPAT = 0x0100;
  /// Isolation aware, but do not isolate the image.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_NO_ISOLATION = 0x0200;
  /// Does not use structured exception handling (SEH). No SEH handler may be
  /// called in this image.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_NO_SEH = 0x0400;
  /// Do not bind the image.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_NO_BIND = 0x0800;
  ///< Image should execute in an AppContainer.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_APPCONTAINER = 0x1000;
  ///< A WDM driver.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_WDM_DRIVER = 0x2000;
  ///< Image supports Control Flow Guard.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_GUARD_CF = 0x4000;
  /// Terminal Server aware.
  public static final /*uint*/int IMAGE_DLL_CHARACTERISTICS_TERMINAL_SERVER_AWARE = 0x8000;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::DebugType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 590,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 591,
 FQN="llvm::COFF::DebugType", NM="_ZN4llvm4COFF9DebugTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF9DebugTypeE")
//</editor-fold>
public enum DebugType implements Native.NativeUIntEnum {
  IMAGE_DEBUG_TYPE_UNKNOWN(0),
  IMAGE_DEBUG_TYPE_COFF(1),
  IMAGE_DEBUG_TYPE_CODEVIEW(2),
  IMAGE_DEBUG_TYPE_FPO(3),
  IMAGE_DEBUG_TYPE_MISC(4),
  IMAGE_DEBUG_TYPE_EXCEPTION(5),
  IMAGE_DEBUG_TYPE_FIXUP(6),
  IMAGE_DEBUG_TYPE_OMAP_TO_SRC(7),
  IMAGE_DEBUG_TYPE_OMAP_FROM_SRC(8),
  IMAGE_DEBUG_TYPE_BORLAND(9),
  IMAGE_DEBUG_TYPE_RESERVED10(10),
  IMAGE_DEBUG_TYPE_CLSID(11),
  IMAGE_DEBUG_TYPE_VC_FEATURE(12),
  IMAGE_DEBUG_TYPE_POGO(13),
  IMAGE_DEBUG_TYPE_ILTCG(14),
  IMAGE_DEBUG_TYPE_MPX(15),
  IMAGE_DEBUG_TYPE_REPRO(16);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DebugType valueOf(int val) {
    DebugType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DebugType[] VALUES;
    private static final DebugType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DebugType kind : DebugType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DebugType[min < 0 ? (1-min) : 0];
      VALUES = new DebugType[max >= 0 ? (1+max) : 0];
      for (DebugType kind : DebugType.values()) {
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
  private DebugType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::BaseRelocationType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 610,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 605,
 FQN="llvm::COFF::BaseRelocationType", NM="_ZN4llvm4COFF18BaseRelocationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF18BaseRelocationTypeE")
//</editor-fold>
public enum BaseRelocationType implements Native.NativeUIntEnum {
  IMAGE_REL_BASED_ABSOLUTE(0),
  IMAGE_REL_BASED_HIGH(1),
  IMAGE_REL_BASED_LOW(2),
  IMAGE_REL_BASED_HIGHLOW(3),
  IMAGE_REL_BASED_HIGHADJ(4),
  IMAGE_REL_BASED_MIPS_JMPADDR(5),
  IMAGE_REL_BASED_ARM_MOV32A(5),
  IMAGE_REL_BASED_ARM_MOV32T(7),
  IMAGE_REL_BASED_MIPS_JMPADDR16(9),
  IMAGE_REL_BASED_DIR64(10);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static BaseRelocationType valueOf(int val) {
    BaseRelocationType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final BaseRelocationType[] VALUES;
    private static final BaseRelocationType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (BaseRelocationType kind : BaseRelocationType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new BaseRelocationType[min < 0 ? (1-min) : 0];
      VALUES = new BaseRelocationType[max >= 0 ? (1+max) : 0];
      for (BaseRelocationType kind : BaseRelocationType.values()) {
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
  private BaseRelocationType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 623,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 618,
 FQN="llvm::COFF::ImportType", NM="_ZN4llvm4COFF10ImportTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF10ImportTypeE")
//</editor-fold>
public enum ImportType implements Native.NativeUIntEnum {
  IMPORT_CODE(0),
  IMPORT_DATA(1),
  IMPORT_CONST(2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ImportType valueOf(int val) {
    ImportType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ImportType[] VALUES;
    private static final ImportType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ImportType kind : ImportType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ImportType[min < 0 ? (1-min) : 0];
      VALUES = new ImportType[max >= 0 ? (1+max) : 0];
      for (ImportType kind : ImportType.values()) {
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
  private ImportType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportNameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 629,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 624,
 FQN="llvm::COFF::ImportNameType", NM="_ZN4llvm4COFF14ImportNameTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF14ImportNameTypeE")
//</editor-fold>
public enum ImportNameType implements Native.NativeUIntEnum {
  /// Import is by ordinal. This indicates that the value in the Ordinal/Hint
  /// field of the import header is the import's ordinal. If this constant is
  /// not specified, then the Ordinal/Hint field should always be interpreted
  /// as the import's hint.
  IMPORT_ORDINAL(0),
  /// The import name is identical to the public symbol name
  IMPORT_NAME(1),
  /// The import name is the public symbol name, but skipping the leading ?,
  /// @, or optionally _.
  IMPORT_NAME_NOPREFIX(2),
  /// The import name is the public symbol name, but skipping the leading ?,
  /// @, or optionally _, and truncating at the first @.
  IMPORT_NAME_UNDECORATE(3);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ImportNameType valueOf(int val) {
    ImportNameType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ImportNameType[] VALUES;
    private static final ImportNameType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ImportNameType kind : ImportNameType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ImportNameType[min < 0 ? (1-min) : 0];
      VALUES = new ImportNameType[max >= 0 ? (1+max) : 0];
      for (ImportNameType kind : ImportNameType.values()) {
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
  private ImportNameType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 645,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 640,
 FQN="llvm::COFF::ImportHeader", NM="_ZN4llvm4COFF12ImportHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF12ImportHeaderE")
//</editor-fold>
public static class/*struct*/ ImportHeader {
  public /*uint16_t*/char Sig1; ///< Must be IMAGE_FILE_MACHINE_UNKNOWN (0).
  public /*uint16_t*/char Sig2; ///< Must be 0xFFFF.
  public /*uint16_t*/char Version;
  public /*uint16_t*/char Machine;
  public /*uint32_t*/int TimeDateStamp;
  public /*uint32_t*/int SizeOfData;
  public /*uint16_t*/char OrdinalHint;
  public /*uint16_t*/char TypeInfo;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportHeader::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 655,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 650,
   FQN="llvm::COFF::ImportHeader::getType", NM="_ZNK4llvm4COFF12ImportHeader7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm4COFF12ImportHeader7getTypeEv")
  //</editor-fold>
  public ImportType getType() /*const*/ {
    return /*static_cast*/ImportType.valueOf($ushort2int(TypeInfo) & 0x3);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::COFF::ImportHeader::getNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 659,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 654,
   FQN="llvm::COFF::ImportHeader::getNameType", NM="_ZNK4llvm4COFF12ImportHeader11getNameTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm4COFF12ImportHeader11getNameTypeEv")
  //</editor-fold>
  public ImportNameType getNameType() /*const*/ {
    return /*static_cast*/ImportNameType.valueOf(($ushort2int(TypeInfo) & 0x1C) >> 3);
  }

  
  @Override public String toString() {
    return "" + "Sig1=" + $ushort2uint(Sig1) // NOI18N
              + ", Sig2=" + $ushort2uint(Sig2) // NOI18N
              + ", Version=" + $ushort2uint(Version) // NOI18N
              + ", Machine=" + $ushort2uint(Machine) // NOI18N
              + ", TimeDateStamp=" + TimeDateStamp // NOI18N
              + ", SizeOfData=" + SizeOfData // NOI18N
              + ", OrdinalHint=" + $ushort2uint(OrdinalHint) // NOI18N
              + ", TypeInfo=" + $ushort2uint(TypeInfo); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::CodeViewIdentifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 664,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 668,
 FQN="llvm::COFF::CodeViewIdentifiers", NM="_ZN4llvm4COFF19CodeViewIdentifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF19CodeViewIdentifiersE")
//</editor-fold>
public static final class/*enum*/ CodeViewIdentifiers {
  public static final /*uint*/int DEBUG_SECTION_MAGIC = 0x4;
}
//<editor-fold defaultstate="collapsed" desc="llvm::COFF::isReservedSectionNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", line = 668,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/COFF.h", old_line = 681,
 FQN="llvm::COFF::isReservedSectionNumber", NM="_ZN4llvm4COFF23isReservedSectionNumberEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm4COFF23isReservedSectionNumberEi")
//</editor-fold>
public static /*inline*/ boolean isReservedSectionNumber(int/*int32_t*/ SectionNumber) {
  return SectionNumber <= 0;
}

} // END OF class COFF
