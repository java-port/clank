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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type ELF">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.ELF",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm3ELF10Elf32_ChdrE;_ZN4llvm3ELF10Elf32_EhdrE;_ZN4llvm3ELF10Elf32_PhdrE;_ZN4llvm3ELF10Elf32_RelaE;_ZN4llvm3ELF10Elf32_ShdrE;_ZN4llvm3ELF10Elf64_ChdrE;_ZN4llvm3ELF10Elf64_EhdrE;_ZN4llvm3ELF10Elf64_PhdrE;_ZN4llvm3ELF10Elf64_RelaE;_ZN4llvm3ELF10Elf64_ShdrE;_ZN4llvm3ELF9Elf32_DynE;_ZN4llvm3ELF9Elf32_RelE;_ZN4llvm3ELF9Elf32_SymE;_ZN4llvm3ELF9Elf64_DynE;_ZN4llvm3ELF9Elf64_RelE;_ZN4llvm3ELF9Elf64_SymE;_ZN4llvm3ELFE_ELF_h_Unnamed_enum;_ZN4llvm3ELFE_ELF_h_Unnamed_enum1;_ZN4llvm3ELFE_ELF_h_Unnamed_enum10;_ZN4llvm3ELFE_ELF_h_Unnamed_enum11;_ZN4llvm3ELFE_ELF_h_Unnamed_enum12;_ZN4llvm3ELFE_ELF_h_Unnamed_enum13;_ZN4llvm3ELFE_ELF_h_Unnamed_enum14;_ZN4llvm3ELFE_ELF_h_Unnamed_enum15;_ZN4llvm3ELFE_ELF_h_Unnamed_enum16;_ZN4llvm3ELFE_ELF_h_Unnamed_enum17;_ZN4llvm3ELFE_ELF_h_Unnamed_enum18;_ZN4llvm3ELFE_ELF_h_Unnamed_enum19;_ZN4llvm3ELFE_ELF_h_Unnamed_enum2;_ZN4llvm3ELFE_ELF_h_Unnamed_enum20;_ZN4llvm3ELFE_ELF_h_Unnamed_enum21;_ZN4llvm3ELFE_ELF_h_Unnamed_enum22;_ZN4llvm3ELFE_ELF_h_Unnamed_enum23;_ZN4llvm3ELFE_ELF_h_Unnamed_enum24;_ZN4llvm3ELFE_ELF_h_Unnamed_enum25;_ZN4llvm3ELFE_ELF_h_Unnamed_enum26;_ZN4llvm3ELFE_ELF_h_Unnamed_enum27;_ZN4llvm3ELFE_ELF_h_Unnamed_enum28;_ZN4llvm3ELFE_ELF_h_Unnamed_enum29;_ZN4llvm3ELFE_ELF_h_Unnamed_enum3;_ZN4llvm3ELFE_ELF_h_Unnamed_enum30;_ZN4llvm3ELFE_ELF_h_Unnamed_enum31;_ZN4llvm3ELFE_ELF_h_Unnamed_enum32;_ZN4llvm3ELFE_ELF_h_Unnamed_enum33;_ZN4llvm3ELFE_ELF_h_Unnamed_enum34;_ZN4llvm3ELFE_ELF_h_Unnamed_enum35;_ZN4llvm3ELFE_ELF_h_Unnamed_enum36;_ZN4llvm3ELFE_ELF_h_Unnamed_enum37;_ZN4llvm3ELFE_ELF_h_Unnamed_enum38;_ZN4llvm3ELFE_ELF_h_Unnamed_enum39;_ZN4llvm3ELFE_ELF_h_Unnamed_enum4;_ZN4llvm3ELFE_ELF_h_Unnamed_enum40;_ZN4llvm3ELFE_ELF_h_Unnamed_enum41;_ZN4llvm3ELFE_ELF_h_Unnamed_enum42;_ZN4llvm3ELFE_ELF_h_Unnamed_enum43;_ZN4llvm3ELFE_ELF_h_Unnamed_enum44;_ZN4llvm3ELFE_ELF_h_Unnamed_enum45;_ZN4llvm3ELFE_ELF_h_Unnamed_enum46;_ZN4llvm3ELFE_ELF_h_Unnamed_enum47;_ZN4llvm3ELFE_ELF_h_Unnamed_enum48;_ZN4llvm3ELFE_ELF_h_Unnamed_enum49;_ZN4llvm3ELFE_ELF_h_Unnamed_enum5;_ZN4llvm3ELFE_ELF_h_Unnamed_enum50;_ZN4llvm3ELFE_ELF_h_Unnamed_enum51;_ZN4llvm3ELFE_ELF_h_Unnamed_enum52;_ZN4llvm3ELFE_ELF_h_Unnamed_enum6;_ZN4llvm3ELFE_ELF_h_Unnamed_enum7;_ZN4llvm3ELFE_ELF_h_Unnamed_enum8;_ZN4llvm3ELFE_ELF_h_Unnamed_enum9;_ZN4llvm3ELFL27decodePPC64LocalEntryOffsetEj;_ZN4llvm3ELFL27encodePPC64LocalEntryOffsetEx;_ZN4llvm3ELFL8ElfMagicE; -static-type=ELF -package=org.llvm.support")
//</editor-fold>
public final class ELF {


// Object file magic string.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::ElfMagic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 46,
 FQN="llvm::ELF::ElfMagic", NM="_ZN4llvm3ELFL8ElfMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFL8ElfMagicE")
//</editor-fold>
public static /*const*//*char*/byte ElfMagic[/*5*/] = new byte[]{0x7f, $$E, $$L, $$F, $$TERM};//new$char(5, 0x7f, $$E, $$L, $$F, $$TERM);

// e_ident size and indices.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 49,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int EI_MAG0 = 0; // File identification index.
  public static final /*uint*/int EI_MAG1 = 1; // File identification index.
  public static final /*uint*/int EI_MAG2 = 2; // File identification index.
  public static final /*uint*/int EI_MAG3 = 3; // File identification index.
  public static final /*uint*/int EI_CLASS = 4; // File class.
  public static final /*uint*/int EI_DATA = 5; // Data encoding.
  public static final /*uint*/int EI_VERSION = 6; // File version.
  public static final /*uint*/int EI_OSABI = 7; // OS/ABI identification.
  public static final /*uint*/int EI_ABIVERSION = 8; // ABI version.
  public static final /*uint*/int EI_PAD = 9; // Start of padding bytes.
  public static final /*uint*/int EI_NIDENT = 16; // Number of bytes in e_ident.
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Ehdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 63,
 FQN="llvm::ELF::Elf32_Ehdr", NM="_ZN4llvm3ELF10Elf32_EhdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_EhdrE")
//</editor-fold>
public static class/*struct*/ Elf32_Ehdr {
  public /*uchar*/byte e_ident[/*16*/] = new /*uchar*/byte [16]; // ELF Identification bytes
  public /*uint16_t*/char e_type; // Type of file (see ET_* below)
  public /*uint16_t*/char e_machine; // Required architecture for this file (see EM_*)
  public /*uint32_t*/int e_version; // Must be equal to 1
  public /*uint32_t*/int e_entry; // Address to jump to in order to start program
  public /*uint32_t*/int e_phoff; // Program header table's file offset, in bytes
  public /*uint32_t*/int e_shoff; // Section header table's file offset, in bytes
  public /*uint32_t*/int e_flags; // Processor-specific flags
  public /*uint16_t*/char e_ehsize; // Size of ELF header, in bytes
  public /*uint16_t*/char e_phentsize; // Size of an entry in the program header table
  public /*uint16_t*/char e_phnum; // Number of entries in the program header table
  public /*uint16_t*/char e_shentsize; // Size of an entry in the section header table
  public /*uint16_t*/char e_shnum; // Number of entries in the section header table
  public /*uint16_t*/char e_shstrndx; // Sect hdr table index of sect name string table
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Ehdr::checkMagic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 78,
   FQN="llvm::ELF::Elf32_Ehdr::checkMagic", NM="_ZNK4llvm3ELF10Elf32_Ehdr10checkMagicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf32_Ehdr10checkMagicEv")
  //</editor-fold>
  public boolean checkMagic() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Ehdr::getFileClass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 81,
   FQN="llvm::ELF::Elf32_Ehdr::getFileClass", NM="_ZNK4llvm3ELF10Elf32_Ehdr12getFileClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf32_Ehdr12getFileClassEv")
  //</editor-fold>
  public /*uchar*/byte getFileClass() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Ehdr::getDataEncoding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 82,
   FQN="llvm::ELF::Elf32_Ehdr::getDataEncoding", NM="_ZNK4llvm3ELF10Elf32_Ehdr15getDataEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf32_Ehdr15getDataEncodingEv")
  //</editor-fold>
  public /*uchar*/byte getDataEncoding() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "e_ident=" + e_ident // NOI18N
              + ", e_type=" + $ushort2uint(e_type) // NOI18N
              + ", e_machine=" + $ushort2uint(e_machine) // NOI18N
              + ", e_version=" + e_version // NOI18N
              + ", e_entry=" + e_entry // NOI18N
              + ", e_phoff=" + e_phoff // NOI18N
              + ", e_shoff=" + e_shoff // NOI18N
              + ", e_flags=" + e_flags // NOI18N
              + ", e_ehsize=" + $ushort2uint(e_ehsize) // NOI18N
              + ", e_phentsize=" + $ushort2uint(e_phentsize) // NOI18N
              + ", e_phnum=" + $ushort2uint(e_phnum) // NOI18N
              + ", e_shentsize=" + $ushort2uint(e_shentsize) // NOI18N
              + ", e_shnum=" + $ushort2uint(e_shnum) // NOI18N
              + ", e_shstrndx=" + $ushort2uint(e_shstrndx); // NOI18N
  }
}

// 64-bit ELF header. Fields are the same as for ELF32, but with different
// types (see above).
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Ehdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 87,
 FQN="llvm::ELF::Elf64_Ehdr", NM="_ZN4llvm3ELF10Elf64_EhdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_EhdrE")
//</editor-fold>
public static class/*struct*/ Elf64_Ehdr {
  public /*uchar*/byte e_ident[/*16*/] = new /*uchar*/byte [16];
  public /*uint16_t*/char e_type;
  public /*uint16_t*/char e_machine;
  public /*uint32_t*/int e_version;
  public long/*uint64_t*/ e_entry;
  public long/*uint64_t*/ e_phoff;
  public long/*uint64_t*/ e_shoff;
  public /*uint32_t*/int e_flags;
  public /*uint16_t*/char e_ehsize;
  public /*uint16_t*/char e_phentsize;
  public /*uint16_t*/char e_phnum;
  public /*uint16_t*/char e_shentsize;
  public /*uint16_t*/char e_shnum;
  public /*uint16_t*/char e_shstrndx;
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Ehdr::checkMagic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 102,
   FQN="llvm::ELF::Elf64_Ehdr::checkMagic", NM="_ZNK4llvm3ELF10Elf64_Ehdr10checkMagicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf64_Ehdr10checkMagicEv")
  //</editor-fold>
  public boolean checkMagic() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Ehdr::getFileClass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 105,
   FQN="llvm::ELF::Elf64_Ehdr::getFileClass", NM="_ZNK4llvm3ELF10Elf64_Ehdr12getFileClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf64_Ehdr12getFileClassEv")
  //</editor-fold>
  public /*uchar*/byte getFileClass() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Ehdr::getDataEncoding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 106,
   FQN="llvm::ELF::Elf64_Ehdr::getDataEncoding", NM="_ZNK4llvm3ELF10Elf64_Ehdr15getDataEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf64_Ehdr15getDataEncodingEv")
  //</editor-fold>
  public /*uchar*/byte getDataEncoding() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "e_ident=" + e_ident // NOI18N
              + ", e_type=" + $ushort2uint(e_type) // NOI18N
              + ", e_machine=" + $ushort2uint(e_machine) // NOI18N
              + ", e_version=" + e_version // NOI18N
              + ", e_entry=" + e_entry // NOI18N
              + ", e_phoff=" + e_phoff // NOI18N
              + ", e_shoff=" + e_shoff // NOI18N
              + ", e_flags=" + e_flags // NOI18N
              + ", e_ehsize=" + $ushort2uint(e_ehsize) // NOI18N
              + ", e_phentsize=" + $ushort2uint(e_phentsize) // NOI18N
              + ", e_phnum=" + $ushort2uint(e_phnum) // NOI18N
              + ", e_shentsize=" + $ushort2uint(e_shentsize) // NOI18N
              + ", e_shnum=" + $ushort2uint(e_shnum) // NOI18N
              + ", e_shstrndx=" + $ushort2uint(e_shstrndx); // NOI18N
  }
}

// File types
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 110,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum1")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ET_NONE = 0; // No file type
  public static final /*uint*/int ET_REL = 1; // Relocatable file
  public static final /*uint*/int ET_EXEC = 2; // Executable file
  public static final /*uint*/int ET_DYN = 3; // Shared object file
  public static final /*uint*/int ET_CORE = 4; // Core file
  public static final /*uint*/int ET_LOPROC = 0xff00; // Beginning of processor-specific codes
  public static final /*uint*/int ET_HIPROC = 0xffff; // Processor-specific
/*}*/

// Versioning
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 121,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum2")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int EV_NONE = 0;
  public static final /*uint*/int EV_CURRENT = 1;
/*}*/

// Machine architectures
// See current registered ELF machine architectures at:
//    http://www.uxsglobal.com/developers/gabi/latest/ch4.eheader.html
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 129,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum3",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum3")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int EM_NONE = 0; // No machine
  public static final /*uint*/int EM_M32 = 1; // AT&T WE 32100
  public static final /*uint*/int EM_SPARC = 2; // SPARC
  public static final /*uint*/int EM_386 = 3; // Intel 386
  public static final /*uint*/int EM_68K = 4; // Motorola 68000
  public static final /*uint*/int EM_88K = 5; // Motorola 88000
  public static final /*uint*/int EM_IAMCU = 6; // Intel MCU
  public static final /*uint*/int EM_860 = 7; // Intel 80860
  public static final /*uint*/int EM_MIPS = 8; // MIPS R3000
  public static final /*uint*/int EM_S370 = 9; // IBM System/370
  public static final /*uint*/int EM_MIPS_RS3_LE = 10; // MIPS RS3000 Little-endian
  public static final /*uint*/int EM_PARISC = 15; // Hewlett-Packard PA-RISC
  public static final /*uint*/int EM_VPP500 = 17; // Fujitsu VPP500
  public static final /*uint*/int EM_SPARC32PLUS = 18; // Enhanced instruction set SPARC
  public static final /*uint*/int EM_960 = 19; // Intel 80960
  public static final /*uint*/int EM_PPC = 20; // PowerPC
  public static final /*uint*/int EM_PPC64 = 21; // PowerPC64
  public static final /*uint*/int EM_S390 = 22; // IBM System/390
  public static final /*uint*/int EM_SPU = 23; // IBM SPU/SPC
  public static final /*uint*/int EM_V800 = 36; // NEC V800
  public static final /*uint*/int EM_FR20 = 37; // Fujitsu FR20
  public static final /*uint*/int EM_RH32 = 38; // TRW RH-32
  public static final /*uint*/int EM_RCE = 39; // Motorola RCE
  public static final /*uint*/int EM_ARM = 40; // ARM
  public static final /*uint*/int EM_ALPHA = 41; // DEC Alpha
  public static final /*uint*/int EM_SH = 42; // Hitachi SH
  public static final /*uint*/int EM_SPARCV9 = 43; // SPARC V9
  public static final /*uint*/int EM_TRICORE = 44; // Siemens TriCore
  public static final /*uint*/int EM_ARC = 45; // Argonaut RISC Core
  public static final /*uint*/int EM_H8_300 = 46; // Hitachi H8/300
  public static final /*uint*/int EM_H8_300H = 47; // Hitachi H8/300H
  public static final /*uint*/int EM_H8S = 48; // Hitachi H8S
  public static final /*uint*/int EM_H8_500 = 49; // Hitachi H8/500
  public static final /*uint*/int EM_IA_64 = 50; // Intel IA-64 processor architecture
  public static final /*uint*/int EM_MIPS_X = 51; // Stanford MIPS-X
  public static final /*uint*/int EM_COLDFIRE = 52; // Motorola ColdFire
  public static final /*uint*/int EM_68HC12 = 53; // Motorola M68HC12
  public static final /*uint*/int EM_MMA = 54; // Fujitsu MMA Multimedia Accelerator
  public static final /*uint*/int EM_PCP = 55; // Siemens PCP
  public static final /*uint*/int EM_NCPU = 56; // Sony nCPU embedded RISC processor
  public static final /*uint*/int EM_NDR1 = 57; // Denso NDR1 microprocessor
  public static final /*uint*/int EM_STARCORE = 58; // Motorola Star*Core processor
  public static final /*uint*/int EM_ME16 = 59; // Toyota ME16 processor
  public static final /*uint*/int EM_ST100 = 60; // STMicroelectronics ST100 processor
  public static final /*uint*/int EM_TINYJ = 61; // Advanced Logic Corp. TinyJ embedded processor family
  public static final /*uint*/int EM_X86_64 = 62; // AMD x86-64 architecture
  public static final /*uint*/int EM_PDSP = 63; // Sony DSP Processor
  public static final /*uint*/int EM_PDP10 = 64; // Digital Equipment Corp. PDP-10
  public static final /*uint*/int EM_PDP11 = 65; // Digital Equipment Corp. PDP-11
  public static final /*uint*/int EM_FX66 = 66; // Siemens FX66 microcontroller
  public static final /*uint*/int EM_ST9PLUS = 67; // STMicroelectronics ST9+ 8/16 bit microcontroller
  public static final /*uint*/int EM_ST7 = 68; // STMicroelectronics ST7 8-bit microcontroller
  public static final /*uint*/int EM_68HC16 = 69; // Motorola MC68HC16 Microcontroller
  public static final /*uint*/int EM_68HC11 = 70; // Motorola MC68HC11 Microcontroller
  public static final /*uint*/int EM_68HC08 = 71; // Motorola MC68HC08 Microcontroller
  public static final /*uint*/int EM_68HC05 = 72; // Motorola MC68HC05 Microcontroller
  public static final /*uint*/int EM_SVX = 73; // Silicon Graphics SVx
  public static final /*uint*/int EM_ST19 = 74; // STMicroelectronics ST19 8-bit microcontroller
  public static final /*uint*/int EM_VAX = 75; // Digital VAX
  public static final /*uint*/int EM_CRIS = 76; // Axis Communications 32-bit embedded processor
  public static final /*uint*/int EM_JAVELIN = 77; // Infineon Technologies 32-bit embedded processor
  public static final /*uint*/int EM_FIREPATH = 78; // Element 14 64-bit DSP Processor
  public static final /*uint*/int EM_ZSP = 79; // LSI Logic 16-bit DSP Processor
  public static final /*uint*/int EM_MMIX = 80; // Donald Knuth's educational 64-bit processor
  public static final /*uint*/int EM_HUANY = 81; // Harvard University machine-independent object files
  public static final /*uint*/int EM_PRISM = 82; // SiTera Prism
  public static final /*uint*/int EM_AVR = 83; // Atmel AVR 8-bit microcontroller
  public static final /*uint*/int EM_FR30 = 84; // Fujitsu FR30
  public static final /*uint*/int EM_D10V = 85; // Mitsubishi D10V
  public static final /*uint*/int EM_D30V = 86; // Mitsubishi D30V
  public static final /*uint*/int EM_V850 = 87; // NEC v850
  public static final /*uint*/int EM_M32R = 88; // Mitsubishi M32R
  public static final /*uint*/int EM_MN10300 = 89; // Matsushita MN10300
  public static final /*uint*/int EM_MN10200 = 90; // Matsushita MN10200
  public static final /*uint*/int EM_PJ = 91; // picoJava
  public static final /*uint*/int EM_OPENRISC = 92; // OpenRISC 32-bit embedded processor
  public static final /*uint*/int EM_ARC_COMPACT = 93; // ARC International ARCompact processor (old
  // spelling/synonym: EM_ARC_A5)
  public static final /*uint*/int EM_XTENSA = 94; // Tensilica Xtensa Architecture
  public static final /*uint*/int EM_VIDEOCORE = 95; // Alphamosaic VideoCore processor
  public static final /*uint*/int EM_TMM_GPP = 96; // Thompson Multimedia General Purpose Processor
  public static final /*uint*/int EM_NS32K = 97; // National Semiconductor 32000 series
  public static final /*uint*/int EM_TPC = 98; // Tenor Network TPC processor
  public static final /*uint*/int EM_SNP1K = 99; // Trebia SNP 1000 processor
  public static final /*uint*/int EM_ST200 = 100; // STMicroelectronics (www.st.com) ST200
  public static final /*uint*/int EM_IP2K = 101; // Ubicom IP2xxx microcontroller family
  public static final /*uint*/int EM_MAX = 102; // MAX Processor
  public static final /*uint*/int EM_CR = 103; // National Semiconductor CompactRISC microprocessor
  public static final /*uint*/int EM_F2MC16 = 104; // Fujitsu F2MC16
  public static final /*uint*/int EM_MSP430 = 105; // Texas Instruments embedded microcontroller msp430
  public static final /*uint*/int EM_BLACKFIN = 106; // Analog Devices Blackfin (DSP) processor
  public static final /*uint*/int EM_SE_C33 = 107; // S1C33 Family of Seiko Epson processors
  public static final /*uint*/int EM_SEP = 108; // Sharp embedded microprocessor
  public static final /*uint*/int EM_ARCA = 109; // Arca RISC Microprocessor
  public static final /*uint*/int EM_UNICORE = 110; // Microprocessor series from PKU-Unity Ltd. and MPRC
  // of Peking University
  public static final /*uint*/int EM_EXCESS = 111; // eXcess: 16/32/64-bit configurable embedded CPU
  public static final /*uint*/int EM_DXP = 112; // Icera Semiconductor Inc. Deep Execution Processor
  public static final /*uint*/int EM_ALTERA_NIOS2 = 113; // Altera Nios II soft-core processor
  public static final /*uint*/int EM_CRX = 114; // National Semiconductor CompactRISC CRX
  public static final /*uint*/int EM_XGATE = 115; // Motorola XGATE embedded processor
  public static final /*uint*/int EM_C166 = 116; // Infineon C16x/XC16x processor
  public static final /*uint*/int EM_M16C = 117; // Renesas M16C series microprocessors
  public static final /*uint*/int EM_DSPIC30F = 118; // Microchip Technology dsPIC30F Digital Signal
  // Controller
  public static final /*uint*/int EM_CE = 119; // Freescale Communication Engine RISC core
  public static final /*uint*/int EM_M32C = 120; // Renesas M32C series microprocessors
  public static final /*uint*/int EM_TSK3000 = 131; // Altium TSK3000 core
  public static final /*uint*/int EM_RS08 = 132; // Freescale RS08 embedded processor
  public static final /*uint*/int EM_SHARC = 133; // Analog Devices SHARC family of 32-bit DSP
  // processors
  public static final /*uint*/int EM_ECOG2 = 134; // Cyan Technology eCOG2 microprocessor
  public static final /*uint*/int EM_SCORE7 = 135; // Sunplus S+core7 RISC processor
  public static final /*uint*/int EM_DSP24 = 136; // New Japan Radio (NJR) 24-bit DSP Processor
  public static final /*uint*/int EM_VIDEOCORE3 = 137; // Broadcom VideoCore III processor
  public static final /*uint*/int EM_LATTICEMICO32 = 138; // RISC processor for Lattice FPGA architecture
  public static final /*uint*/int EM_SE_C17 = 139; // Seiko Epson C17 family
  public static final /*uint*/int EM_TI_C6000 = 140; // The Texas Instruments TMS320C6000 DSP family
  public static final /*uint*/int EM_TI_C2000 = 141; // The Texas Instruments TMS320C2000 DSP family
  public static final /*uint*/int EM_TI_C5500 = 142; // The Texas Instruments TMS320C55x DSP family
  public static final /*uint*/int EM_MMDSP_PLUS = 160; // STMicroelectronics 64bit VLIW Data Signal Processor
  public static final /*uint*/int EM_CYPRESS_M8C = 161; // Cypress M8C microprocessor
  public static final /*uint*/int EM_R32C = 162; // Renesas R32C series microprocessors
  public static final /*uint*/int EM_TRIMEDIA = 163; // NXP Semiconductors TriMedia architecture family
  public static final /*uint*/int EM_HEXAGON = 164; // Qualcomm Hexagon processor
  public static final /*uint*/int EM_8051 = 165; // Intel 8051 and variants
  public static final /*uint*/int EM_STXP7X = 166; // STMicroelectronics STxP7x family of configurable
  // and extensible RISC processors
  public static final /*uint*/int EM_NDS32 = 167; // Andes Technology compact code size embedded RISC
  // processor family
  public static final /*uint*/int EM_ECOG1 = 168; // Cyan Technology eCOG1X family
  public static final /*uint*/int EM_ECOG1X = 168; // Cyan Technology eCOG1X family
  public static final /*uint*/int EM_MAXQ30 = 169; // Dallas Semiconductor MAXQ30 Core Micro-controllers
  public static final /*uint*/int EM_XIMO16 = 170; // New Japan Radio (NJR) 16-bit DSP Processor
  public static final /*uint*/int EM_MANIK = 171; // M2000 Reconfigurable RISC Microprocessor
  public static final /*uint*/int EM_CRAYNV2 = 172; // Cray Inc. NV2 vector architecture
  public static final /*uint*/int EM_RX = 173; // Renesas RX family
  public static final /*uint*/int EM_METAG = 174; // Imagination Technologies META processor
  // architecture
  public static final /*uint*/int EM_MCST_ELBRUS = 175; // MCST Elbrus general purpose hardware architecture
  public static final /*uint*/int EM_ECOG16 = 176; // Cyan Technology eCOG16 family
  public static final /*uint*/int EM_CR16 = 177; // National Semiconductor CompactRISC CR16 16-bit
  // microprocessor
  public static final /*uint*/int EM_ETPU = 178; // Freescale Extended Time Processing Unit
  public static final /*uint*/int EM_SLE9X = 179; // Infineon Technologies SLE9X core
  public static final /*uint*/int EM_L10M = 180; // Intel L10M
  public static final /*uint*/int EM_K10M = 181; // Intel K10M
  public static final /*uint*/int EM_AARCH64 = 183; // ARM AArch64
  public static final /*uint*/int EM_AVR32 = 185; // Atmel Corporation 32-bit microprocessor family
  public static final /*uint*/int EM_STM8 = 186; // STMicroeletronics STM8 8-bit microcontroller
  public static final /*uint*/int EM_TILE64 = 187; // Tilera TILE64 multicore architecture family
  public static final /*uint*/int EM_TILEPRO = 188; // Tilera TILEPro multicore architecture family
  public static final /*uint*/int EM_CUDA = 190; // NVIDIA CUDA architecture
  public static final /*uint*/int EM_TILEGX = 191; // Tilera TILE-Gx multicore architecture family
  public static final /*uint*/int EM_CLOUDSHIELD = 192; // CloudShield architecture family
  public static final /*uint*/int EM_COREA_1ST = 193; // KIPO-KAIST Core-A 1st generation processor family
  public static final /*uint*/int EM_COREA_2ND = 194; // KIPO-KAIST Core-A 2nd generation processor family
  public static final /*uint*/int EM_ARC_COMPACT2 = 195; // Synopsys ARCompact V2
  public static final /*uint*/int EM_OPEN8 = 196; // Open8 8-bit RISC soft processor core
  public static final /*uint*/int EM_RL78 = 197; // Renesas RL78 family
  public static final /*uint*/int EM_VIDEOCORE5 = 198; // Broadcom VideoCore V processor
  public static final /*uint*/int EM_78KOR = 199; // Renesas 78KOR family
  public static final /*uint*/int EM_56800EX = 200; // Freescale 56800EX Digital Signal Controller (DSC)
  public static final /*uint*/int EM_BA1 = 201; // Beyond BA1 CPU architecture
  public static final /*uint*/int EM_BA2 = 202; // Beyond BA2 CPU architecture
  public static final /*uint*/int EM_XCORE = 203; // XMOS xCORE processor family
  public static final /*uint*/int EM_MCHP_PIC = 204; // Microchip 8-bit PIC(r) family
  public static final /*uint*/int EM_INTEL205 = 205; // Reserved by Intel
  public static final /*uint*/int EM_INTEL206 = 206; // Reserved by Intel
  public static final /*uint*/int EM_INTEL207 = 207; // Reserved by Intel
  public static final /*uint*/int EM_INTEL208 = 208; // Reserved by Intel
  public static final /*uint*/int EM_INTEL209 = 209; // Reserved by Intel
  public static final /*uint*/int EM_KM32 = 210; // KM211 KM32 32-bit processor
  public static final /*uint*/int EM_KMX32 = 211; // KM211 KMX32 32-bit processor
  public static final /*uint*/int EM_KMX16 = 212; // KM211 KMX16 16-bit processor
  public static final /*uint*/int EM_KMX8 = 213; // KM211 KMX8 8-bit processor
  public static final /*uint*/int EM_KVARC = 214; // KM211 KVARC processor
  public static final /*uint*/int EM_CDP = 215; // Paneve CDP architecture family
  public static final /*uint*/int EM_COGE = 216; // Cognitive Smart Memory Processor
  public static final /*uint*/int EM_COOL = 217; // iCelero CoolEngine
  public static final /*uint*/int EM_NORC = 218; // Nanoradio Optimized RISC
  public static final /*uint*/int EM_CSR_KALIMBA = 219; // CSR Kalimba architecture family
  public static final /*uint*/int EM_AMDGPU = 224; // AMD GPU architecture
  public static final /*uint*/int EM_LANAI = 244; // Lanai 32-bit processor
  public static final /*uint*/int EM_BPF = 247; // Linux kernel bpf virtual machine
  
  // A request has been made to the maintainer of the official registry for
  // such numbers for an official value for WebAssembly. As soon as one is
  // allocated, this enum will be updated to use it.
  public static final /*uint*/int EM_WEBASSEMBLY = 0x4157; // WebAssembly architecture
/*}*/

// Object file classes.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 323,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 321,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum4",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum4")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ELFCLASSNONE = 0;
  public static final /*uint*/int ELFCLASS32 = 1; // 32-bit object file
  public static final /*uint*/int ELFCLASS64 = 2; // 64-bit object file
/*}*/

// Object file byte orderings.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 330,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 328,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum5",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum5")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ELFDATANONE = 0; // Invalid data encoding.
  public static final /*uint*/int ELFDATA2LSB = 1; // Little-endian object file
  public static final /*uint*/int ELFDATA2MSB = 2; // Big-endian object file
/*}*/

// OS ABI identification.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 337,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 335,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum6",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum6")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ELFOSABI_NONE = 0; // UNIX System V ABI
  public static final /*uint*/int ELFOSABI_HPUX = 1; // HP-UX operating system
  public static final /*uint*/int ELFOSABI_NETBSD = 2; // NetBSD
  public static final /*uint*/int ELFOSABI_GNU = 3; // GNU/Linux
  public static final /*uint*/int ELFOSABI_LINUX = 3; // Historical alias for ELFOSABI_GNU.
  public static final /*uint*/int ELFOSABI_HURD = 4; // GNU/Hurd
  public static final /*uint*/int ELFOSABI_SOLARIS = 6; // Solaris
  public static final /*uint*/int ELFOSABI_AIX = 7; // AIX
  public static final /*uint*/int ELFOSABI_IRIX = 8; // IRIX
  public static final /*uint*/int ELFOSABI_FREEBSD = 9; // FreeBSD
  public static final /*uint*/int ELFOSABI_TRU64 = 10; // TRU64 UNIX
  public static final /*uint*/int ELFOSABI_MODESTO = 11; // Novell Modesto
  public static final /*uint*/int ELFOSABI_OPENBSD = 12; // OpenBSD
  public static final /*uint*/int ELFOSABI_OPENVMS = 13; // OpenVMS
  public static final /*uint*/int ELFOSABI_NSK = 14; // Hewlett-Packard Non-Stop Kernel
  public static final /*uint*/int ELFOSABI_AROS = 15; // AROS
  public static final /*uint*/int ELFOSABI_FENIXOS = 16; // FenixOS
  public static final /*uint*/int ELFOSABI_CLOUDABI = 17; // Nuxi CloudABI
  public static final /*uint*/int ELFOSABI_C6000_ELFABI = 64; // Bare-metal TMS320C6000
  public static final /*uint*/int ELFOSABI_AMDGPU_HSA = 64; // AMD HSA runtime
  public static final /*uint*/int ELFOSABI_C6000_LINUX = 65; // Linux TMS320C6000
  public static final /*uint*/int ELFOSABI_ARM = 97; // ARM
  public static final /*uint*/int ELFOSABI_STANDALONE = 255; // Standalone (embedded) application
/*}*/

// X86_64 relocations.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 366,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 364,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum7",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum7")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_X86_64_NONE = 0;
  public static final /*uint*/int R_X86_64_64 = 1;
  public static final /*uint*/int R_X86_64_PC32 = 2;
  public static final /*uint*/int R_X86_64_GOT32 = 3;
  public static final /*uint*/int R_X86_64_PLT32 = 4;
  public static final /*uint*/int R_X86_64_COPY = 5;
  public static final /*uint*/int R_X86_64_GLOB_DAT = 6;
  public static final /*uint*/int R_X86_64_JUMP_SLOT = 7;
  public static final /*uint*/int R_X86_64_RELATIVE = 8;
  public static final /*uint*/int R_X86_64_GOTPCREL = 9;
  public static final /*uint*/int R_X86_64_32 = 10;
  public static final /*uint*/int R_X86_64_32S = 11;
  public static final /*uint*/int R_X86_64_16 = 12;
  public static final /*uint*/int R_X86_64_PC16 = 13;
  public static final /*uint*/int R_X86_64_8 = 14;
  public static final /*uint*/int R_X86_64_PC8 = 15;
  public static final /*uint*/int R_X86_64_DTPMOD64 = 16;
  public static final /*uint*/int R_X86_64_DTPOFF64 = 17;
  public static final /*uint*/int R_X86_64_TPOFF64 = 18;
  public static final /*uint*/int R_X86_64_TLSGD = 19;
  public static final /*uint*/int R_X86_64_TLSLD = 20;
  public static final /*uint*/int R_X86_64_DTPOFF32 = 21;
  public static final /*uint*/int R_X86_64_GOTTPOFF = 22;
  public static final /*uint*/int R_X86_64_TPOFF32 = 23;
  public static final /*uint*/int R_X86_64_PC64 = 24;
  public static final /*uint*/int R_X86_64_GOTOFF64 = 25;
  public static final /*uint*/int R_X86_64_GOTPC32 = 26;
  public static final /*uint*/int R_X86_64_GOT64 = 27;
  public static final /*uint*/int R_X86_64_GOTPCREL64 = 28;
  public static final /*uint*/int R_X86_64_GOTPC64 = 29;
  public static final /*uint*/int R_X86_64_GOTPLT64 = 30;
  public static final /*uint*/int R_X86_64_PLTOFF64 = 31;
  public static final /*uint*/int R_X86_64_SIZE32 = 32;
  public static final /*uint*/int R_X86_64_SIZE64 = 33;
  public static final /*uint*/int R_X86_64_GOTPC32_TLSDESC = 34;
  public static final /*uint*/int R_X86_64_TLSDESC_CALL = 35;
  public static final /*uint*/int R_X86_64_TLSDESC = 36;
  public static final /*uint*/int R_X86_64_IRELATIVE = 37;
  public static final /*uint*/int R_X86_64_GOTPCRELX = 41;
  public static final /*uint*/int R_X86_64_REX_GOTPCRELX = 42;
/*}*/

// i386 relocations.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 371,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 369,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum8",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum8")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // TODO: this is just a subset
  public static final /*uint*/int R_386_NONE = 0;
  public static final /*uint*/int R_386_32 = 1;
  public static final /*uint*/int R_386_PC32 = 2;
  public static final /*uint*/int R_386_GOT32 = 3;
  public static final /*uint*/int R_386_PLT32 = 4;
  public static final /*uint*/int R_386_COPY = 5;
  public static final /*uint*/int R_386_GLOB_DAT = 6;
  public static final /*uint*/int R_386_JUMP_SLOT = 7;
  public static final /*uint*/int R_386_RELATIVE = 8;
  public static final /*uint*/int R_386_GOTOFF = 9;
  public static final /*uint*/int R_386_GOTPC = 10;
  public static final /*uint*/int R_386_32PLT = 11;
  public static final /*uint*/int R_386_TLS_TPOFF = 14;
  public static final /*uint*/int R_386_TLS_IE = 15;
  public static final /*uint*/int R_386_TLS_GOTIE = 16;
  public static final /*uint*/int R_386_TLS_LE = 17;
  public static final /*uint*/int R_386_TLS_GD = 18;
  public static final /*uint*/int R_386_TLS_LDM = 19;
  public static final /*uint*/int R_386_16 = 20;
  public static final /*uint*/int R_386_PC16 = 21;
  public static final /*uint*/int R_386_8 = 22;
  public static final /*uint*/int R_386_PC8 = 23;
  public static final /*uint*/int R_386_TLS_GD_32 = 24;
  public static final /*uint*/int R_386_TLS_GD_PUSH = 25;
  public static final /*uint*/int R_386_TLS_GD_CALL = 26;
  public static final /*uint*/int R_386_TLS_GD_POP = 27;
  public static final /*uint*/int R_386_TLS_LDM_32 = 28;
  public static final /*uint*/int R_386_TLS_LDM_PUSH = 29;
  public static final /*uint*/int R_386_TLS_LDM_CALL = 30;
  public static final /*uint*/int R_386_TLS_LDM_POP = 31;
  public static final /*uint*/int R_386_TLS_LDO_32 = 32;
  public static final /*uint*/int R_386_TLS_IE_32 = 33;
  public static final /*uint*/int R_386_TLS_LE_32 = 34;
  public static final /*uint*/int R_386_TLS_DTPMOD32 = 35;
  public static final /*uint*/int R_386_TLS_DTPOFF32 = 36;
  public static final /*uint*/int R_386_TLS_TPOFF32 = 37;
  public static final /*uint*/int R_386_TLS_GOTDESC = 39;
  public static final /*uint*/int R_386_TLS_DESC_CALL = 40;
  public static final /*uint*/int R_386_TLS_DESC = 41;
  public static final /*uint*/int R_386_IRELATIVE = 42;
  public static final /*uint*/int R_386_GOT32X = 43;
/*}*/

// ELF Relocation types for PPC32
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 376,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 374,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum9",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum9")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_PPC_NONE = 0/* No relocation. */;
  public static final /*uint*/int R_PPC_ADDR32 = 1;
  public static final /*uint*/int R_PPC_ADDR24 = 2;
  public static final /*uint*/int R_PPC_ADDR16 = 3;
  public static final /*uint*/int R_PPC_ADDR16_LO = 4;
  public static final /*uint*/int R_PPC_ADDR16_HI = 5;
  public static final /*uint*/int R_PPC_ADDR16_HA = 6;
  public static final /*uint*/int R_PPC_ADDR14 = 7;
  public static final /*uint*/int R_PPC_ADDR14_BRTAKEN = 8;
  public static final /*uint*/int R_PPC_ADDR14_BRNTAKEN = 9;
  public static final /*uint*/int R_PPC_REL24 = 10;
  public static final /*uint*/int R_PPC_REL14 = 11;
  public static final /*uint*/int R_PPC_REL14_BRTAKEN = 12;
  public static final /*uint*/int R_PPC_REL14_BRNTAKEN = 13;
  public static final /*uint*/int R_PPC_GOT16 = 14;
  public static final /*uint*/int R_PPC_GOT16_LO = 15;
  public static final /*uint*/int R_PPC_GOT16_HI = 16;
  public static final /*uint*/int R_PPC_GOT16_HA = 17;
  public static final /*uint*/int R_PPC_PLTREL24 = 18;
  public static final /*uint*/int R_PPC_JMP_SLOT = 21;
  public static final /*uint*/int R_PPC_LOCAL24PC = 23;
  public static final /*uint*/int R_PPC_REL32 = 26;
  public static final /*uint*/int R_PPC_TLS = 67;
  public static final /*uint*/int R_PPC_DTPMOD32 = 68;
  public static final /*uint*/int R_PPC_TPREL16 = 69;
  public static final /*uint*/int R_PPC_TPREL16_LO = 70;
  public static final /*uint*/int R_PPC_TPREL16_HI = 71;
  public static final /*uint*/int R_PPC_TPREL16_HA = 72;
  public static final /*uint*/int R_PPC_TPREL32 = 73;
  public static final /*uint*/int R_PPC_DTPREL16 = 74;
  public static final /*uint*/int R_PPC_DTPREL16_LO = 75;
  public static final /*uint*/int R_PPC_DTPREL16_HI = 76;
  public static final /*uint*/int R_PPC_DTPREL16_HA = 77;
  public static final /*uint*/int R_PPC_DTPREL32 = 78;
  public static final /*uint*/int R_PPC_GOT_TLSGD16 = 79;
  public static final /*uint*/int R_PPC_GOT_TLSGD16_LO = 80;
  public static final /*uint*/int R_PPC_GOT_TLSGD16_HI = 81;
  public static final /*uint*/int R_PPC_GOT_TLSGD16_HA = 82;
  public static final /*uint*/int R_PPC_GOT_TLSLD16 = 83;
  public static final /*uint*/int R_PPC_GOT_TLSLD16_LO = 84;
  public static final /*uint*/int R_PPC_GOT_TLSLD16_HI = 85;
  public static final /*uint*/int R_PPC_GOT_TLSLD16_HA = 86;
  public static final /*uint*/int R_PPC_GOT_TPREL16 = 87;
  public static final /*uint*/int R_PPC_GOT_TPREL16_LO = 88;
  public static final /*uint*/int R_PPC_GOT_TPREL16_HI = 89;
  public static final /*uint*/int R_PPC_GOT_TPREL16_HA = 90;
  public static final /*uint*/int R_PPC_GOT_DTPREL16 = 91;
  public static final /*uint*/int R_PPC_GOT_DTPREL16_LO = 92;
  public static final /*uint*/int R_PPC_GOT_DTPREL16_HI = 93;
  public static final /*uint*/int R_PPC_GOT_DTPREL16_HA = 94;
  public static final /*uint*/int R_PPC_TLSGD = 95;
  public static final /*uint*/int R_PPC_TLSLD = 96;
  public static final /*uint*/int R_PPC_REL16 = 249;
  public static final /*uint*/int R_PPC_REL16_LO = 250;
  public static final /*uint*/int R_PPC_REL16_HI = 251;
  public static final /*uint*/int R_PPC_REL16_HA = 252;
/*}*/

// Specific e_flags for PPC64
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 381,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 379,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum10",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum10")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // e_flags bits specifying ABI:
  // 1 for original ABI using function descriptors,
  // 2 for revised ABI without function descriptors,
  // 0 for unspecified or not using any features affected by the differences.
  public static final /*uint*/int EF_PPC64_ABI = 3;
/*}*/

// Special values for the st_other field in the symbol table entry for PPC64.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 390,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 388,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum11")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STO_PPC64_LOCAL_BIT = 5;
  public static final /*uint*/int STO_PPC64_LOCAL_MASK = (7 << STO_PPC64_LOCAL_BIT);
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::decodePPC64LocalEntryOffset">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 394,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 392,
 FQN="llvm::ELF::decodePPC64LocalEntryOffset", NM="_ZN4llvm3ELFL27decodePPC64LocalEntryOffsetEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFL27decodePPC64LocalEntryOffsetEj")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ decodePPC64LocalEntryOffset(/*uint*/int Other) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::ELF::encodePPC64LocalEntryOffset">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 399,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 397,
 FQN="llvm::ELF::encodePPC64LocalEntryOffset", NM="_ZN4llvm3ELFL27encodePPC64LocalEntryOffsetEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFL27encodePPC64LocalEntryOffsetEx")
//</editor-fold>
public static /*inline*/ /*uint*/int encodePPC64LocalEntryOffset(long/*int64_t*/ Offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


// ELF Relocation types for PPC64
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 412,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 410,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum12",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum12")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_PPC64_NONE = 0;
  public static final /*uint*/int R_PPC64_ADDR32 = 1;
  public static final /*uint*/int R_PPC64_ADDR24 = 2;
  public static final /*uint*/int R_PPC64_ADDR16 = 3;
  public static final /*uint*/int R_PPC64_ADDR16_LO = 4;
  public static final /*uint*/int R_PPC64_ADDR16_HI = 5;
  public static final /*uint*/int R_PPC64_ADDR16_HA = 6;
  public static final /*uint*/int R_PPC64_ADDR14 = 7;
  public static final /*uint*/int R_PPC64_ADDR14_BRTAKEN = 8;
  public static final /*uint*/int R_PPC64_ADDR14_BRNTAKEN = 9;
  public static final /*uint*/int R_PPC64_REL24 = 10;
  public static final /*uint*/int R_PPC64_REL14 = 11;
  public static final /*uint*/int R_PPC64_REL14_BRTAKEN = 12;
  public static final /*uint*/int R_PPC64_REL14_BRNTAKEN = 13;
  public static final /*uint*/int R_PPC64_GOT16 = 14;
  public static final /*uint*/int R_PPC64_GOT16_LO = 15;
  public static final /*uint*/int R_PPC64_GOT16_HI = 16;
  public static final /*uint*/int R_PPC64_GOT16_HA = 17;
  public static final /*uint*/int R_PPC64_GLOB_DAT = 20;
  public static final /*uint*/int R_PPC64_JMP_SLOT = 21;
  public static final /*uint*/int R_PPC64_RELATIVE = 22;
  public static final /*uint*/int R_PPC64_REL32 = 26;
  public static final /*uint*/int R_PPC64_ADDR64 = 38;
  public static final /*uint*/int R_PPC64_ADDR16_HIGHER = 39;
  public static final /*uint*/int R_PPC64_ADDR16_HIGHERA = 40;
  public static final /*uint*/int R_PPC64_ADDR16_HIGHEST = 41;
  public static final /*uint*/int R_PPC64_ADDR16_HIGHESTA = 42;
  public static final /*uint*/int R_PPC64_REL64 = 44;
  public static final /*uint*/int R_PPC64_TOC16 = 47;
  public static final /*uint*/int R_PPC64_TOC16_LO = 48;
  public static final /*uint*/int R_PPC64_TOC16_HI = 49;
  public static final /*uint*/int R_PPC64_TOC16_HA = 50;
  public static final /*uint*/int R_PPC64_TOC = 51;
  public static final /*uint*/int R_PPC64_ADDR16_DS = 56;
  public static final /*uint*/int R_PPC64_ADDR16_LO_DS = 57;
  public static final /*uint*/int R_PPC64_GOT16_DS = 58;
  public static final /*uint*/int R_PPC64_GOT16_LO_DS = 59;
  public static final /*uint*/int R_PPC64_TOC16_DS = 63;
  public static final /*uint*/int R_PPC64_TOC16_LO_DS = 64;
  public static final /*uint*/int R_PPC64_TLS = 67;
  public static final /*uint*/int R_PPC64_DTPMOD64 = 68;
  public static final /*uint*/int R_PPC64_TPREL16 = 69;
  public static final /*uint*/int R_PPC64_TPREL16_LO = 70;
  public static final /*uint*/int R_PPC64_TPREL16_HI = 71;
  public static final /*uint*/int R_PPC64_TPREL16_HA = 72;
  public static final /*uint*/int R_PPC64_TPREL64 = 73;
  public static final /*uint*/int R_PPC64_DTPREL16 = 74;
  public static final /*uint*/int R_PPC64_DTPREL16_LO = 75;
  public static final /*uint*/int R_PPC64_DTPREL16_HI = 76;
  public static final /*uint*/int R_PPC64_DTPREL16_HA = 77;
  public static final /*uint*/int R_PPC64_DTPREL64 = 78;
  public static final /*uint*/int R_PPC64_GOT_TLSGD16 = 79;
  public static final /*uint*/int R_PPC64_GOT_TLSGD16_LO = 80;
  public static final /*uint*/int R_PPC64_GOT_TLSGD16_HI = 81;
  public static final /*uint*/int R_PPC64_GOT_TLSGD16_HA = 82;
  public static final /*uint*/int R_PPC64_GOT_TLSLD16 = 83;
  public static final /*uint*/int R_PPC64_GOT_TLSLD16_LO = 84;
  public static final /*uint*/int R_PPC64_GOT_TLSLD16_HI = 85;
  public static final /*uint*/int R_PPC64_GOT_TLSLD16_HA = 86;
  public static final /*uint*/int R_PPC64_GOT_TPREL16_DS = 87;
  public static final /*uint*/int R_PPC64_GOT_TPREL16_LO_DS = 88;
  public static final /*uint*/int R_PPC64_GOT_TPREL16_HI = 89;
  public static final /*uint*/int R_PPC64_GOT_TPREL16_HA = 90;
  public static final /*uint*/int R_PPC64_GOT_DTPREL16_DS = 91;
  public static final /*uint*/int R_PPC64_GOT_DTPREL16_LO_DS = 92;
  public static final /*uint*/int R_PPC64_GOT_DTPREL16_HI = 93;
  public static final /*uint*/int R_PPC64_GOT_DTPREL16_HA = 94;
  public static final /*uint*/int R_PPC64_TPREL16_DS = 95;
  public static final /*uint*/int R_PPC64_TPREL16_LO_DS = 96;
  public static final /*uint*/int R_PPC64_TPREL16_HIGHER = 97;
  public static final /*uint*/int R_PPC64_TPREL16_HIGHERA = 98;
  public static final /*uint*/int R_PPC64_TPREL16_HIGHEST = 99;
  public static final /*uint*/int R_PPC64_TPREL16_HIGHESTA = 100;
  public static final /*uint*/int R_PPC64_DTPREL16_DS = 101;
  public static final /*uint*/int R_PPC64_DTPREL16_LO_DS = 102;
  public static final /*uint*/int R_PPC64_DTPREL16_HIGHER = 103;
  public static final /*uint*/int R_PPC64_DTPREL16_HIGHERA = 104;
  public static final /*uint*/int R_PPC64_DTPREL16_HIGHEST = 105;
  public static final /*uint*/int R_PPC64_DTPREL16_HIGHESTA = 106;
  public static final /*uint*/int R_PPC64_TLSGD = 107;
  public static final /*uint*/int R_PPC64_TLSLD = 108;
  public static final /*uint*/int R_PPC64_REL16 = 249;
  public static final /*uint*/int R_PPC64_REL16_LO = 250;
  public static final /*uint*/int R_PPC64_REL16_HI = 251;
  public static final /*uint*/int R_PPC64_REL16_HA = 252;
/*}*/

// ELF Relocation types for AArch64
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 417,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 415,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum13",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum13")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // ABI release 1.0
  public static final /*uint*/int R_AARCH64_NONE = 0;
  public static final /*uint*/int R_AARCH64_ABS64 = 0x101;
  public static final /*uint*/int R_AARCH64_ABS32 = 0x102;
  public static final /*uint*/int R_AARCH64_ABS16 = 0x103;
  public static final /*uint*/int R_AARCH64_PREL64 = 0x104;
  public static final /*uint*/int R_AARCH64_PREL32 = 0x105;
  public static final /*uint*/int R_AARCH64_PREL16 = 0x106;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G0 = 0x107;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G0_NC = 0x108;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G1 = 0x109;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G1_NC = 0x10A;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G2 = 0x10B;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G2_NC = 0x10C;
  public static final /*uint*/int R_AARCH64_MOVW_UABS_G3 = 0x10D;
  public static final /*uint*/int R_AARCH64_MOVW_SABS_G0 = 0x10E;
  public static final /*uint*/int R_AARCH64_MOVW_SABS_G1 = 0x10F;
  public static final /*uint*/int R_AARCH64_MOVW_SABS_G2 = 0x110;
  public static final /*uint*/int R_AARCH64_LD_PREL_LO19 = 0x111;
  public static final /*uint*/int R_AARCH64_ADR_PREL_LO21 = 0x112;
  public static final /*uint*/int R_AARCH64_ADR_PREL_PG_HI21 = 0x113;
  public static final /*uint*/int R_AARCH64_ADR_PREL_PG_HI21_NC = 0x114;
  public static final /*uint*/int R_AARCH64_ADD_ABS_LO12_NC = 0x115;
  public static final /*uint*/int R_AARCH64_LDST8_ABS_LO12_NC = 0x116;
  public static final /*uint*/int R_AARCH64_TSTBR14 = 0x117;
  public static final /*uint*/int R_AARCH64_CONDBR19 = 0x118;
  public static final /*uint*/int R_AARCH64_JUMP26 = 0x11A;
  public static final /*uint*/int R_AARCH64_CALL26 = 0x11B;
  public static final /*uint*/int R_AARCH64_LDST16_ABS_LO12_NC = 0x11C;
  public static final /*uint*/int R_AARCH64_LDST32_ABS_LO12_NC = 0x11D;
  public static final /*uint*/int R_AARCH64_LDST64_ABS_LO12_NC = 0x11E;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G0 = 0x11F;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G0_NC = 0x120;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G1 = 0x121;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G1_NC = 0x122;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G2 = 0x123;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G2_NC = 0x124;
  public static final /*uint*/int R_AARCH64_MOVW_PREL_G3 = 0x125;
  public static final /*uint*/int R_AARCH64_LDST128_ABS_LO12_NC = 0x12B;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G0 = 0x12C;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G0_NC = 0x12D;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G1 = 0x12E;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G1_NC = 0x12F;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G2 = 0x130;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G2_NC = 0x131;
  public static final /*uint*/int R_AARCH64_MOVW_GOTOFF_G3 = 0x132;
  public static final /*uint*/int R_AARCH64_GOTREL64 = 0x133;
  public static final /*uint*/int R_AARCH64_GOTREL32 = 0x134;
  public static final /*uint*/int R_AARCH64_GOT_LD_PREL19 = 0x135;
  public static final /*uint*/int R_AARCH64_LD64_GOTOFF_LO15 = 0x136;
  public static final /*uint*/int R_AARCH64_ADR_GOT_PAGE = 0x137;
  public static final /*uint*/int R_AARCH64_LD64_GOT_LO12_NC = 0x138;
  public static final /*uint*/int R_AARCH64_LD64_GOTPAGE_LO15 = 0x139;
  public static final /*uint*/int R_AARCH64_TLSGD_ADR_PREL21 = 0x200;
  public static final /*uint*/int R_AARCH64_TLSGD_ADR_PAGE21 = 0x201;
  public static final /*uint*/int R_AARCH64_TLSGD_ADD_LO12_NC = 0x202;
  public static final /*uint*/int R_AARCH64_TLSGD_MOVW_G1 = 0x203;
  public static final /*uint*/int R_AARCH64_TLSGD_MOVW_G0_NC = 0x204;
  public static final /*uint*/int R_AARCH64_TLSLD_ADR_PREL21 = 0x205;
  public static final /*uint*/int R_AARCH64_TLSLD_ADR_PAGE21 = 0x206;
  public static final /*uint*/int R_AARCH64_TLSLD_ADD_LO12_NC = 0x207;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_G1 = 0x208;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_G0_NC = 0x209;
  public static final /*uint*/int R_AARCH64_TLSLD_LD_PREL19 = 0x20A;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_DTPREL_G2 = 0x20B;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_DTPREL_G1 = 0x20C;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_DTPREL_G1_NC = 0x20D;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_DTPREL_G0 = 0x20E;
  public static final /*uint*/int R_AARCH64_TLSLD_MOVW_DTPREL_G0_NC = 0x20F;
  public static final /*uint*/int R_AARCH64_TLSLD_ADD_DTPREL_HI12 = 0x210;
  public static final /*uint*/int R_AARCH64_TLSLD_ADD_DTPREL_LO12 = 0x211;
  public static final /*uint*/int R_AARCH64_TLSLD_ADD_DTPREL_LO12_NC = 0x212;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST8_DTPREL_LO12 = 0x213;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST8_DTPREL_LO12_NC = 0x214;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST16_DTPREL_LO12 = 0x215;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST16_DTPREL_LO12_NC = 0x216;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST32_DTPREL_LO12 = 0x217;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST32_DTPREL_LO12_NC = 0x218;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST64_DTPREL_LO12 = 0x219;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST64_DTPREL_LO12_NC = 0x21A;
  public static final /*uint*/int R_AARCH64_TLSIE_MOVW_GOTTPREL_G1 = 0x21B;
  public static final /*uint*/int R_AARCH64_TLSIE_MOVW_GOTTPREL_G0_NC = 0x21C;
  public static final /*uint*/int R_AARCH64_TLSIE_ADR_GOTTPREL_PAGE21 = 0x21D;
  public static final /*uint*/int R_AARCH64_TLSIE_LD64_GOTTPREL_LO12_NC = 0x21E;
  public static final /*uint*/int R_AARCH64_TLSIE_LD_GOTTPREL_PREL19 = 0x21F;
  public static final /*uint*/int R_AARCH64_TLSLE_MOVW_TPREL_G2 = 0x220;
  public static final /*uint*/int R_AARCH64_TLSLE_MOVW_TPREL_G1 = 0x221;
  public static final /*uint*/int R_AARCH64_TLSLE_MOVW_TPREL_G1_NC = 0x222;
  public static final /*uint*/int R_AARCH64_TLSLE_MOVW_TPREL_G0 = 0x223;
  public static final /*uint*/int R_AARCH64_TLSLE_MOVW_TPREL_G0_NC = 0x224;
  public static final /*uint*/int R_AARCH64_TLSLE_ADD_TPREL_HI12 = 0x225;
  public static final /*uint*/int R_AARCH64_TLSLE_ADD_TPREL_LO12 = 0x226;
  public static final /*uint*/int R_AARCH64_TLSLE_ADD_TPREL_LO12_NC = 0x227;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST8_TPREL_LO12 = 0x228;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST8_TPREL_LO12_NC = 0x229;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST16_TPREL_LO12 = 0x22A;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST16_TPREL_LO12_NC = 0x22B;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST32_TPREL_LO12 = 0x22C;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST32_TPREL_LO12_NC = 0x22D;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST64_TPREL_LO12 = 0x22E;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST64_TPREL_LO12_NC = 0x22F;
  public static final /*uint*/int R_AARCH64_TLSDESC_LD_PREL19 = 0x230;
  public static final /*uint*/int R_AARCH64_TLSDESC_ADR_PREL21 = 0x231;
  public static final /*uint*/int R_AARCH64_TLSDESC_ADR_PAGE21 = 0x232;
  public static final /*uint*/int R_AARCH64_TLSDESC_LD64_LO12_NC = 0x233;
  public static final /*uint*/int R_AARCH64_TLSDESC_ADD_LO12_NC = 0x234;
  public static final /*uint*/int R_AARCH64_TLSDESC_OFF_G1 = 0x235;
  public static final /*uint*/int R_AARCH64_TLSDESC_OFF_G0_NC = 0x236;
  public static final /*uint*/int R_AARCH64_TLSDESC_LDR = 0x237;
  public static final /*uint*/int R_AARCH64_TLSDESC_ADD = 0x238;
  public static final /*uint*/int R_AARCH64_TLSDESC_CALL = 0x239;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST128_TPREL_LO12 = 0x23A;
  public static final /*uint*/int R_AARCH64_TLSLE_LDST128_TPREL_LO12_NC = 0x23B;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST128_DTPREL_LO12 = 0x23C;
  public static final /*uint*/int R_AARCH64_TLSLD_LDST128_DTPREL_LO12_NC = 0x23D;
  public static final /*uint*/int R_AARCH64_COPY = 0x400;
  public static final /*uint*/int R_AARCH64_GLOB_DAT = 0x401;
  public static final /*uint*/int R_AARCH64_JUMP_SLOT = 0x402;
  public static final /*uint*/int R_AARCH64_RELATIVE = 0x403;
  public static final /*uint*/int R_AARCH64_TLS_DTPREL64 = 0x404;
  public static final /*uint*/int R_AARCH64_TLS_DTPMOD64 = 0x405;
  public static final /*uint*/int R_AARCH64_TLS_TPREL64 = 0x406;
  public static final /*uint*/int R_AARCH64_TLSDESC = 0x407;
  public static final /*uint*/int R_AARCH64_IRELATIVE = 0x408;
/*}*/

// ARM Specific e_flags
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 422,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 420,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum14",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum14")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int EF_ARM_SOFT_FLOAT = 0x00000200/*U*/;
  public static final /*uint*/int EF_ARM_VFP_FLOAT = 0x00000400/*U*/;
  public static final /*uint*/int EF_ARM_EABI_UNKNOWN = 0x00000000/*U*/;
  public static final /*uint*/int EF_ARM_EABI_VER1 = 0x01000000/*U*/;
  public static final /*uint*/int EF_ARM_EABI_VER2 = 0x02000000/*U*/;
  public static final /*uint*/int EF_ARM_EABI_VER3 = 0x03000000/*U*/;
  public static final /*uint*/int EF_ARM_EABI_VER4 = 0x04000000/*U*/;
  public static final /*uint*/int EF_ARM_EABI_VER5 = 0x05000000/*U*/;
  public static final /*uint*/int EF_ARM_EABIMASK = 0xFF000000/*U*/;
/*}*/

// ELF Relocation types for ARM
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 435,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 433,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum15",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum15")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // Meets 2.09 ABI Specs.
  public static final /*uint*/int R_ARM_NONE = 0x0;
  public static final /*uint*/int R_ARM_PC24 = 0x1;
  public static final /*uint*/int R_ARM_ABS32 = 0x2;
  public static final /*uint*/int R_ARM_REL32 = 0x3;
  public static final /*uint*/int R_ARM_LDR_PC_G0 = 0x4;
  public static final /*uint*/int R_ARM_ABS16 = 0x5;
  public static final /*uint*/int R_ARM_ABS12 = 0x6;
  public static final /*uint*/int R_ARM_THM_ABS5 = 0x7;
  public static final /*uint*/int R_ARM_ABS8 = 0x8;
  public static final /*uint*/int R_ARM_SBREL32 = 0x9;
  public static final /*uint*/int R_ARM_THM_CALL = 0xA;
  public static final /*uint*/int R_ARM_THM_PC8 = 0xB;
  public static final /*uint*/int R_ARM_BREL_ADJ = 0xC;
  public static final /*uint*/int R_ARM_TLS_DESC = 0xD;
  public static final /*uint*/int R_ARM_THM_SWI8 = 0xE;
  public static final /*uint*/int R_ARM_XPC25 = 0xF;
  public static final /*uint*/int R_ARM_THM_XPC22 = 0x10;
  public static final /*uint*/int R_ARM_TLS_DTPMOD32 = 0x11;
  public static final /*uint*/int R_ARM_TLS_DTPOFF32 = 0x12;
  public static final /*uint*/int R_ARM_TLS_TPOFF32 = 0x13;
  public static final /*uint*/int R_ARM_COPY = 0x14;
  public static final /*uint*/int R_ARM_GLOB_DAT = 0x15;
  public static final /*uint*/int R_ARM_JUMP_SLOT = 0x16;
  public static final /*uint*/int R_ARM_RELATIVE = 0x17;
  public static final /*uint*/int R_ARM_GOTOFF32 = 0x18;
  public static final /*uint*/int R_ARM_BASE_PREL = 0x19;
  public static final /*uint*/int R_ARM_GOT_BREL = 0x1A;
  public static final /*uint*/int R_ARM_PLT32 = 0x1B;
  public static final /*uint*/int R_ARM_CALL = 0x1C;
  public static final /*uint*/int R_ARM_JUMP24 = 0x1D;
  public static final /*uint*/int R_ARM_THM_JUMP24 = 0x1E;
  public static final /*uint*/int R_ARM_BASE_ABS = 0x1F;
  public static final /*uint*/int R_ARM_ALU_PCREL_7_0 = 0x20;
  public static final /*uint*/int R_ARM_ALU_PCREL_15_8 = 0x21;
  public static final /*uint*/int R_ARM_ALU_PCREL_23_15 = 0x22;
  public static final /*uint*/int R_ARM_LDR_SBREL_11_0_NC = 0x23;
  public static final /*uint*/int R_ARM_ALU_SBREL_19_12_NC = 0x24;
  public static final /*uint*/int R_ARM_ALU_SBREL_27_20_CK = 0x25;
  public static final /*uint*/int R_ARM_TARGET1 = 0x26;
  public static final /*uint*/int R_ARM_SBREL31 = 0x27;
  public static final /*uint*/int R_ARM_V4BX = 0x28;
  public static final /*uint*/int R_ARM_TARGET2 = 0x29;
  public static final /*uint*/int R_ARM_PREL31 = 0x2A;
  public static final /*uint*/int R_ARM_MOVW_ABS_NC = 0x2B;
  public static final /*uint*/int R_ARM_MOVT_ABS = 0x2C;
  public static final /*uint*/int R_ARM_MOVW_PREL_NC = 0x2D;
  public static final /*uint*/int R_ARM_MOVT_PREL = 0x2E;
  public static final /*uint*/int R_ARM_THM_MOVW_ABS_NC = 0x2F;
  public static final /*uint*/int R_ARM_THM_MOVT_ABS = 0x30;
  public static final /*uint*/int R_ARM_THM_MOVW_PREL_NC = 0x31;
  public static final /*uint*/int R_ARM_THM_MOVT_PREL = 0x32;
  public static final /*uint*/int R_ARM_THM_JUMP19 = 0x33;
  public static final /*uint*/int R_ARM_THM_JUMP6 = 0x34;
  public static final /*uint*/int R_ARM_THM_ALU_PREL_11_0 = 0x35;
  public static final /*uint*/int R_ARM_THM_PC12 = 0x36;
  public static final /*uint*/int R_ARM_ABS32_NOI = 0x37;
  public static final /*uint*/int R_ARM_REL32_NOI = 0x38;
  public static final /*uint*/int R_ARM_ALU_PC_G0_NC = 0x39;
  public static final /*uint*/int R_ARM_ALU_PC_G0 = 0x3A;
  public static final /*uint*/int R_ARM_ALU_PC_G1_NC = 0x3B;
  public static final /*uint*/int R_ARM_ALU_PC_G1 = 0x3C;
  public static final /*uint*/int R_ARM_ALU_PC_G2 = 0x3D;
  public static final /*uint*/int R_ARM_LDR_PC_G1 = 0x3E;
  public static final /*uint*/int R_ARM_LDR_PC_G2 = 0x3F;
  public static final /*uint*/int R_ARM_LDRS_PC_G0 = 0x40;
  public static final /*uint*/int R_ARM_LDRS_PC_G1 = 0x41;
  public static final /*uint*/int R_ARM_LDRS_PC_G2 = 0x42;
  public static final /*uint*/int R_ARM_LDC_PC_G0 = 0x43;
  public static final /*uint*/int R_ARM_LDC_PC_G1 = 0x44;
  public static final /*uint*/int R_ARM_LDC_PC_G2 = 0x45;
  public static final /*uint*/int R_ARM_ALU_SB_G0_NC = 0x46;
  public static final /*uint*/int R_ARM_ALU_SB_G0 = 0x47;
  public static final /*uint*/int R_ARM_ALU_SB_G1_NC = 0x48;
  public static final /*uint*/int R_ARM_ALU_SB_G1 = 0x49;
  public static final /*uint*/int R_ARM_ALU_SB_G2 = 0x4A;
  public static final /*uint*/int R_ARM_LDR_SB_G0 = 0x4B;
  public static final /*uint*/int R_ARM_LDR_SB_G1 = 0x4C;
  public static final /*uint*/int R_ARM_LDR_SB_G2 = 0x4D;
  public static final /*uint*/int R_ARM_LDRS_SB_G0 = 0x4E;
  public static final /*uint*/int R_ARM_LDRS_SB_G1 = 0x4F;
  public static final /*uint*/int R_ARM_LDRS_SB_G2 = 0x50;
  public static final /*uint*/int R_ARM_LDC_SB_G0 = 0x51;
  public static final /*uint*/int R_ARM_LDC_SB_G1 = 0x52;
  public static final /*uint*/int R_ARM_LDC_SB_G2 = 0x53;
  public static final /*uint*/int R_ARM_MOVW_BREL_NC = 0x54;
  public static final /*uint*/int R_ARM_MOVT_BREL = 0x55;
  public static final /*uint*/int R_ARM_MOVW_BREL = 0x56;
  public static final /*uint*/int R_ARM_THM_MOVW_BREL_NC = 0x57;
  public static final /*uint*/int R_ARM_THM_MOVT_BREL = 0x58;
  public static final /*uint*/int R_ARM_THM_MOVW_BREL = 0x59;
  public static final /*uint*/int R_ARM_TLS_GOTDESC = 0x5A;
  public static final /*uint*/int R_ARM_TLS_CALL = 0x5B;
  public static final /*uint*/int R_ARM_TLS_DESCSEQ = 0x5C;
  public static final /*uint*/int R_ARM_THM_TLS_CALL = 0x5D;
  public static final /*uint*/int R_ARM_PLT32_ABS = 0x5E;
  public static final /*uint*/int R_ARM_GOT_ABS = 0x5F;
  public static final /*uint*/int R_ARM_GOT_PREL = 0x60;
  public static final /*uint*/int R_ARM_GOT_BREL12 = 0x61;
  public static final /*uint*/int R_ARM_GOTOFF12 = 0x62;
  public static final /*uint*/int R_ARM_GOTRELAX = 0x63;
  public static final /*uint*/int R_ARM_GNU_VTENTRY = 0x64;
  public static final /*uint*/int R_ARM_GNU_VTINHERIT = 0x65;
  public static final /*uint*/int R_ARM_THM_JUMP11 = 0x66;
  public static final /*uint*/int R_ARM_THM_JUMP8 = 0x67;
  public static final /*uint*/int R_ARM_TLS_GD32 = 0x68;
  public static final /*uint*/int R_ARM_TLS_LDM32 = 0x69;
  public static final /*uint*/int R_ARM_TLS_LDO32 = 0x6A;
  public static final /*uint*/int R_ARM_TLS_IE32 = 0x6B;
  public static final /*uint*/int R_ARM_TLS_LE32 = 0x6C;
  public static final /*uint*/int R_ARM_TLS_LDO12 = 0x6D;
  public static final /*uint*/int R_ARM_TLS_LE12 = 0x6E;
  public static final /*uint*/int R_ARM_TLS_IE12GP = 0x6F;
  public static final /*uint*/int R_ARM_PRIVATE_0 = 0x70;
  public static final /*uint*/int R_ARM_PRIVATE_1 = 0x71;
  public static final /*uint*/int R_ARM_PRIVATE_2 = 0x72;
  public static final /*uint*/int R_ARM_PRIVATE_3 = 0x73;
  public static final /*uint*/int R_ARM_PRIVATE_4 = 0x74;
  public static final /*uint*/int R_ARM_PRIVATE_5 = 0x75;
  public static final /*uint*/int R_ARM_PRIVATE_6 = 0x76;
  public static final /*uint*/int R_ARM_PRIVATE_7 = 0x77;
  public static final /*uint*/int R_ARM_PRIVATE_8 = 0x78;
  public static final /*uint*/int R_ARM_PRIVATE_9 = 0x79;
  public static final /*uint*/int R_ARM_PRIVATE_10 = 0x7A;
  public static final /*uint*/int R_ARM_PRIVATE_11 = 0x7B;
  public static final /*uint*/int R_ARM_PRIVATE_12 = 0x7C;
  public static final /*uint*/int R_ARM_PRIVATE_13 = 0x7D;
  public static final /*uint*/int R_ARM_PRIVATE_14 = 0x7E;
  public static final /*uint*/int R_ARM_PRIVATE_15 = 0x7F;
  public static final /*uint*/int R_ARM_ME_TOO = 0x80;
  public static final /*uint*/int R_ARM_THM_TLS_DESCSEQ16 = 0x81;
  public static final /*uint*/int R_ARM_THM_TLS_DESCSEQ32 = 0x82;
  public static final /*uint*/int R_ARM_IRELATIVE = 0xA0;
/*}*/

// AVR specific e_flags
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 440,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 438,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum16",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum16")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int EF_AVR_ARCH_AVR1 = 1;
  public static final /*uint*/int EF_AVR_ARCH_AVR2 = 2;
  public static final /*uint*/int EF_AVR_ARCH_AVR25 = 25;
  public static final /*uint*/int EF_AVR_ARCH_AVR3 = 3;
  public static final /*uint*/int EF_AVR_ARCH_AVR31 = 31;
  public static final /*uint*/int EF_AVR_ARCH_AVR35 = 35;
  public static final /*uint*/int EF_AVR_ARCH_AVR4 = 4;
  public static final /*uint*/int EF_AVR_ARCH_AVR5 = 5;
  public static final /*uint*/int EF_AVR_ARCH_AVR51 = 51;
  public static final /*uint*/int EF_AVR_ARCH_AVR6 = 6;
  public static final /*uint*/int EF_AVR_ARCH_AVRTINY = 100;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA1 = 101;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA2 = 102;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA3 = 103;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA4 = 104;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA5 = 105;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA6 = 106;
  public static final /*uint*/int EF_AVR_ARCH_XMEGA7 = 107;
/*}*/

// ELF Relocation types for AVR
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 462,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 460,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum17",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum17")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_AVR_NONE = 0;
  public static final /*uint*/int R_AVR_32 = 1;
  public static final /*uint*/int R_AVR_7_PCREL = 2;
  public static final /*uint*/int R_AVR_13_PCREL = 3;
  public static final /*uint*/int R_AVR_16 = 4;
  public static final /*uint*/int R_AVR_16_PM = 5;
  public static final /*uint*/int R_AVR_LO8_LDI = 6;
  public static final /*uint*/int R_AVR_HI8_LDI = 7;
  public static final /*uint*/int R_AVR_HH8_LDI = 8;
  public static final /*uint*/int R_AVR_LO8_LDI_NEG = 9;
  public static final /*uint*/int R_AVR_HI8_LDI_NEG = 10;
  public static final /*uint*/int R_AVR_HH8_LDI_NEG = 11;
  public static final /*uint*/int R_AVR_LO8_LDI_PM = 12;
  public static final /*uint*/int R_AVR_HI8_LDI_PM = 13;
  public static final /*uint*/int R_AVR_HH8_LDI_PM = 14;
  public static final /*uint*/int R_AVR_LO8_LDI_PM_NEG = 15;
  public static final /*uint*/int R_AVR_HI8_LDI_PM_NEG = 16;
  public static final /*uint*/int R_AVR_HH8_LDI_PM_NEG = 17;
  public static final /*uint*/int R_AVR_CALL = 18;
  public static final /*uint*/int R_AVR_LDI = 19;
  public static final /*uint*/int R_AVR_6 = 20;
  public static final /*uint*/int R_AVR_6_ADIW = 21;
  public static final /*uint*/int R_AVR_MS8_LDI = 22;
  public static final /*uint*/int R_AVR_MS8_LDI_NEG = 23;
  public static final /*uint*/int R_AVR_LO8_LDI_GS = 24;
  public static final /*uint*/int R_AVR_HI8_LDI_GS = 25;
  public static final /*uint*/int R_AVR_8 = 26;
  public static final /*uint*/int R_AVR_8_LO8 = 27;
  public static final /*uint*/int R_AVR_8_HI8 = 28;
  public static final /*uint*/int R_AVR_8_HLO8 = 29;
  public static final /*uint*/int R_AVR_SYM_DIFF = 30;
  public static final /*uint*/int R_AVR_16_LDST = 31;
  public static final /*uint*/int R_AVR_LDS_STS_16 = 33;
  public static final /*uint*/int R_AVR_PORT6 = 34;
  public static final /*uint*/int R_AVR_PORT5 = 35;
/*}*/

// Mips Specific e_flags
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 467,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 465,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum18",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum18")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int EF_MIPS_NOREORDER = 0x00000001; // Don't reorder instructions
  public static final /*uint*/int EF_MIPS_PIC = 0x00000002; // Position independent code
  public static final /*uint*/int EF_MIPS_CPIC = 0x00000004; // Call object with Position independent code
  public static final /*uint*/int EF_MIPS_ABI2 = 0x00000020; // File uses N32 ABI
  public static final /*uint*/int EF_MIPS_32BITMODE = 0x00000100; // Code compiled for a 64-bit machine
  // in 32-bit mode
  public static final /*uint*/int EF_MIPS_FP64 = 0x00000200; // Code compiled for a 32-bit machine
  // but uses 64-bit FP registers
  public static final /*uint*/int EF_MIPS_NAN2008 = 0x00000400; // Uses IEE 754-2008 NaN encoding
  
  // ABI flags
  public static final /*uint*/int EF_MIPS_ABI_O32 = 0x00001000; // This file follows the first MIPS 32 bit ABI
  public static final /*uint*/int EF_MIPS_ABI_O64 = 0x00002000; // O32 ABI extended for 64-bit architecture.
  public static final /*uint*/int EF_MIPS_ABI_EABI32 = 0x00003000; // EABI in 32 bit mode.
  public static final /*uint*/int EF_MIPS_ABI_EABI64 = 0x00004000; // EABI in 64 bit mode.
  public static final /*uint*/int EF_MIPS_ABI = 0x0000f000; // Mask for selecting EF_MIPS_ABI_ variant.
  
  // MIPS machine variant
  public static final /*uint*/int EF_MIPS_MACH_NONE = 0x00000000; // A standard MIPS implementation.
  public static final /*uint*/int EF_MIPS_MACH_3900 = 0x00810000; // Toshiba R3900
  public static final /*uint*/int EF_MIPS_MACH_4010 = 0x00820000; // LSI R4010
  public static final /*uint*/int EF_MIPS_MACH_4100 = 0x00830000; // NEC VR4100
  public static final /*uint*/int EF_MIPS_MACH_4650 = 0x00850000; // MIPS R4650
  public static final /*uint*/int EF_MIPS_MACH_4120 = 0x00870000; // NEC VR4120
  public static final /*uint*/int EF_MIPS_MACH_4111 = 0x00880000; // NEC VR4111/VR4181
  public static final /*uint*/int EF_MIPS_MACH_SB1 = 0x008a0000; // Broadcom SB-1
  public static final /*uint*/int EF_MIPS_MACH_OCTEON = 0x008b0000; // Cavium Networks Octeon
  public static final /*uint*/int EF_MIPS_MACH_XLR = 0x008c0000; // RMI Xlr
  public static final /*uint*/int EF_MIPS_MACH_OCTEON2 = 0x008d0000; // Cavium Networks Octeon2
  public static final /*uint*/int EF_MIPS_MACH_OCTEON3 = 0x008e0000; // Cavium Networks Octeon3
  public static final /*uint*/int EF_MIPS_MACH_5400 = 0x00910000; // NEC VR5400
  public static final /*uint*/int EF_MIPS_MACH_5900 = 0x00920000; // MIPS R5900
  public static final /*uint*/int EF_MIPS_MACH_5500 = 0x00980000; // NEC VR5500
  public static final /*uint*/int EF_MIPS_MACH_9000 = 0x00990000; // Unknown
  public static final /*uint*/int EF_MIPS_MACH_LS2E = 0x00a00000; // ST Microelectronics Loongson 2E
  public static final /*uint*/int EF_MIPS_MACH_LS2F = 0x00a10000; // ST Microelectronics Loongson 2F
  public static final /*uint*/int EF_MIPS_MACH_LS3A = 0x00a20000; // Loongson 3A
  public static final /*uint*/int EF_MIPS_MACH = 0x00ff0000; // EF_MIPS_MACH_xxx selection mask
  
  // ARCH_ASE
  public static final /*uint*/int EF_MIPS_MICROMIPS = 0x02000000; // microMIPS
  public static final /*uint*/int EF_MIPS_ARCH_ASE_M16 = 0x04000000; // Has Mips-16 ISA extensions
  public static final /*uint*/int EF_MIPS_ARCH_ASE_MDMX = 0x08000000; // Has MDMX multimedia extensions
  public static final /*uint*/int EF_MIPS_ARCH_ASE = 0x0f000000; // Mask for EF_MIPS_ARCH_ASE_xxx flags
  
  // ARCH
  public static final /*uint*/int EF_MIPS_ARCH_1 = 0x00000000; // MIPS1 instruction set
  public static final /*uint*/int EF_MIPS_ARCH_2 = 0x10000000; // MIPS2 instruction set
  public static final /*uint*/int EF_MIPS_ARCH_3 = 0x20000000; // MIPS3 instruction set
  public static final /*uint*/int EF_MIPS_ARCH_4 = 0x30000000; // MIPS4 instruction set
  public static final /*uint*/int EF_MIPS_ARCH_5 = 0x40000000; // MIPS5 instruction set
  public static final /*uint*/int EF_MIPS_ARCH_32 = 0x50000000; // MIPS32 instruction set per linux not elf.h
  public static final /*uint*/int EF_MIPS_ARCH_64 = 0x60000000; // MIPS64 instruction set per linux not elf.h
  public static final /*uint*/int EF_MIPS_ARCH_32R2 = 0x70000000; // mips32r2, mips32r3, mips32r5
  public static final /*uint*/int EF_MIPS_ARCH_64R2 = 0x80000000/*U*/; // mips64r2, mips64r3, mips64r5
  public static final /*uint*/int EF_MIPS_ARCH_32R6 = 0x90000000/*U*/; // mips32r6
  public static final /*uint*/int EF_MIPS_ARCH_64R6 = 0xa0000000/*U*/; // mips64r6
  public static final /*uint*/int EF_MIPS_ARCH = 0xf0000000/*U*/; // Mask for applying EF_MIPS_ARCH_ variant
/*}*/

// ELF Relocation types for Mips
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 531,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 528,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum19",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum19")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_MIPS_NONE = 0;
  public static final /*uint*/int R_MIPS_16 = 1;
  public static final /*uint*/int R_MIPS_32 = 2;
  public static final /*uint*/int R_MIPS_REL32 = 3;
  public static final /*uint*/int R_MIPS_26 = 4;
  public static final /*uint*/int R_MIPS_HI16 = 5;
  public static final /*uint*/int R_MIPS_LO16 = 6;
  public static final /*uint*/int R_MIPS_GPREL16 = 7;
  public static final /*uint*/int R_MIPS_LITERAL = 8;
  public static final /*uint*/int R_MIPS_GOT16 = 9;
  public static final /*uint*/int R_MIPS_PC16 = 10;
  public static final /*uint*/int R_MIPS_CALL16 = 11;
  public static final /*uint*/int R_MIPS_GPREL32 = 12;
  public static final /*uint*/int R_MIPS_UNUSED1 = 13;
  public static final /*uint*/int R_MIPS_UNUSED2 = 14;
  public static final /*uint*/int R_MIPS_UNUSED3 = 15;
  public static final /*uint*/int R_MIPS_SHIFT5 = 16;
  public static final /*uint*/int R_MIPS_SHIFT6 = 17;
  public static final /*uint*/int R_MIPS_64 = 18;
  public static final /*uint*/int R_MIPS_GOT_DISP = 19;
  public static final /*uint*/int R_MIPS_GOT_PAGE = 20;
  public static final /*uint*/int R_MIPS_GOT_OFST = 21;
  public static final /*uint*/int R_MIPS_GOT_HI16 = 22;
  public static final /*uint*/int R_MIPS_GOT_LO16 = 23;
  public static final /*uint*/int R_MIPS_SUB = 24;
  public static final /*uint*/int R_MIPS_INSERT_A = 25;
  public static final /*uint*/int R_MIPS_INSERT_B = 26;
  public static final /*uint*/int R_MIPS_DELETE = 27;
  public static final /*uint*/int R_MIPS_HIGHER = 28;
  public static final /*uint*/int R_MIPS_HIGHEST = 29;
  public static final /*uint*/int R_MIPS_CALL_HI16 = 30;
  public static final /*uint*/int R_MIPS_CALL_LO16 = 31;
  public static final /*uint*/int R_MIPS_SCN_DISP = 32;
  public static final /*uint*/int R_MIPS_REL16 = 33;
  public static final /*uint*/int R_MIPS_ADD_IMMEDIATE = 34;
  public static final /*uint*/int R_MIPS_PJUMP = 35;
  public static final /*uint*/int R_MIPS_RELGOT = 36;
  public static final /*uint*/int R_MIPS_JALR = 37;
  public static final /*uint*/int R_MIPS_TLS_DTPMOD32 = 38;
  public static final /*uint*/int R_MIPS_TLS_DTPREL32 = 39;
  public static final /*uint*/int R_MIPS_TLS_DTPMOD64 = 40;
  public static final /*uint*/int R_MIPS_TLS_DTPREL64 = 41;
  public static final /*uint*/int R_MIPS_TLS_GD = 42;
  public static final /*uint*/int R_MIPS_TLS_LDM = 43;
  public static final /*uint*/int R_MIPS_TLS_DTPREL_HI16 = 44;
  public static final /*uint*/int R_MIPS_TLS_DTPREL_LO16 = 45;
  public static final /*uint*/int R_MIPS_TLS_GOTTPREL = 46;
  public static final /*uint*/int R_MIPS_TLS_TPREL32 = 47;
  public static final /*uint*/int R_MIPS_TLS_TPREL64 = 48;
  public static final /*uint*/int R_MIPS_TLS_TPREL_HI16 = 49;
  public static final /*uint*/int R_MIPS_TLS_TPREL_LO16 = 50;
  public static final /*uint*/int R_MIPS_GLOB_DAT = 51;
  public static final /*uint*/int R_MIPS_PC21_S2 = 60;
  public static final /*uint*/int R_MIPS_PC26_S2 = 61;
  public static final /*uint*/int R_MIPS_PC18_S3 = 62;
  public static final /*uint*/int R_MIPS_PC19_S2 = 63;
  public static final /*uint*/int R_MIPS_PCHI16 = 64;
  public static final /*uint*/int R_MIPS_PCLO16 = 65;
  public static final /*uint*/int R_MIPS16_26 = 100;
  public static final /*uint*/int R_MIPS16_GPREL = 101;
  public static final /*uint*/int R_MIPS16_GOT16 = 102;
  public static final /*uint*/int R_MIPS16_CALL16 = 103;
  public static final /*uint*/int R_MIPS16_HI16 = 104;
  public static final /*uint*/int R_MIPS16_LO16 = 105;
  public static final /*uint*/int R_MIPS16_TLS_GD = 106;
  public static final /*uint*/int R_MIPS16_TLS_LDM = 107;
  public static final /*uint*/int R_MIPS16_TLS_DTPREL_HI16 = 108;
  public static final /*uint*/int R_MIPS16_TLS_DTPREL_LO16 = 109;
  public static final /*uint*/int R_MIPS16_TLS_GOTTPREL = 110;
  public static final /*uint*/int R_MIPS16_TLS_TPREL_HI16 = 111;
  public static final /*uint*/int R_MIPS16_TLS_TPREL_LO16 = 112;
  public static final /*uint*/int R_MIPS_COPY = 126;
  public static final /*uint*/int R_MIPS_JUMP_SLOT = 127;
  public static final /*uint*/int R_MICROMIPS_26_S1 = 133;
  public static final /*uint*/int R_MICROMIPS_HI16 = 134;
  public static final /*uint*/int R_MICROMIPS_LO16 = 135;
  public static final /*uint*/int R_MICROMIPS_GPREL16 = 136;
  public static final /*uint*/int R_MICROMIPS_LITERAL = 137;
  public static final /*uint*/int R_MICROMIPS_GOT16 = 138;
  public static final /*uint*/int R_MICROMIPS_PC7_S1 = 139;
  public static final /*uint*/int R_MICROMIPS_PC10_S1 = 140;
  public static final /*uint*/int R_MICROMIPS_PC16_S1 = 141;
  public static final /*uint*/int R_MICROMIPS_CALL16 = 142;
  public static final /*uint*/int R_MICROMIPS_GOT_DISP = 145;
  public static final /*uint*/int R_MICROMIPS_GOT_PAGE = 146;
  public static final /*uint*/int R_MICROMIPS_GOT_OFST = 147;
  public static final /*uint*/int R_MICROMIPS_GOT_HI16 = 148;
  public static final /*uint*/int R_MICROMIPS_GOT_LO16 = 149;
  public static final /*uint*/int R_MICROMIPS_SUB = 150;
  public static final /*uint*/int R_MICROMIPS_HIGHER = 151;
  public static final /*uint*/int R_MICROMIPS_HIGHEST = 152;
  public static final /*uint*/int R_MICROMIPS_CALL_HI16 = 153;
  public static final /*uint*/int R_MICROMIPS_CALL_LO16 = 154;
  public static final /*uint*/int R_MICROMIPS_SCN_DISP = 155;
  public static final /*uint*/int R_MICROMIPS_JALR = 156;
  public static final /*uint*/int R_MICROMIPS_HI0_LO16 = 157;
  public static final /*uint*/int R_MICROMIPS_TLS_GD = 162;
  public static final /*uint*/int R_MICROMIPS_TLS_LDM = 163;
  public static final /*uint*/int R_MICROMIPS_TLS_DTPREL_HI16 = 164;
  public static final /*uint*/int R_MICROMIPS_TLS_DTPREL_LO16 = 165;
  public static final /*uint*/int R_MICROMIPS_TLS_GOTTPREL = 166;
  public static final /*uint*/int R_MICROMIPS_TLS_TPREL_HI16 = 169;
  public static final /*uint*/int R_MICROMIPS_TLS_TPREL_LO16 = 170;
  public static final /*uint*/int R_MICROMIPS_GPREL7_S2 = 172;
  public static final /*uint*/int R_MICROMIPS_PC23_S2 = 173;
  public static final /*uint*/int R_MICROMIPS_PC21_S1 = 174;
  public static final /*uint*/int R_MICROMIPS_PC26_S1 = 175;
  public static final /*uint*/int R_MICROMIPS_PC18_S3 = 176;
  public static final /*uint*/int R_MICROMIPS_PC19_S2 = 177;
  public static final /*uint*/int R_MIPS_NUM = 218;
  public static final /*uint*/int R_MIPS_PC32 = 248;
  public static final /*uint*/int R_MIPS_EH = 249;
/*}*/

// Special values for the st_other field in the symbol table entry for MIPS.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 536,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 533,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum20",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum20")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STO_MIPS_OPTIONAL = 0x04; // Symbol whose definition is optional
  public static final /*uint*/int STO_MIPS_PLT = 0x08; // PLT entry related dynamic table record
  public static final /*uint*/int STO_MIPS_PIC = 0x20; // PIC func in an object mixes PIC/non-PIC
  public static final /*uint*/int STO_MIPS_MICROMIPS = 0x80; // MIPS Specific ISA for MicroMips
  public static final /*uint*/int STO_MIPS_MIPS16 = 0xf0; // MIPS Specific ISA for Mips16
/*}*/

// .MIPS.options section descriptor kinds
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 545,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 542,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum21",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum21")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ODK_NULL = 0; // Undefined
  public static final /*uint*/int ODK_REGINFO = 1; // Register usage information
  public static final /*uint*/int ODK_EXCEPTIONS = 2; // Exception processing options
  public static final /*uint*/int ODK_PAD = 3; // Section padding options
  public static final /*uint*/int ODK_HWPATCH = 4; // Hardware patches applied
  public static final /*uint*/int ODK_FILL = 5; // Linker fill value
  public static final /*uint*/int ODK_TAGS = 6; // Space for tool identification
  public static final /*uint*/int ODK_HWAND = 7; // Hardware AND patches applied
  public static final /*uint*/int ODK_HWOR = 8; // Hardware OR patches applied
  public static final /*uint*/int ODK_GP_GROUP = 9; // GP group to use for text/data sections
  public static final /*uint*/int ODK_IDENT = 10; // ID information
  public static final /*uint*/int ODK_PAGESIZE = 11; // Page size information
/*}*/

// Hexagon-specific e_flags
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 561,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 558,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum22",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum22")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // Object processor version flags, bits[11:0]
  public static final /*uint*/int EF_HEXAGON_MACH_V2 = 0x00000001; // Hexagon V2
  public static final /*uint*/int EF_HEXAGON_MACH_V3 = 0x00000002; // Hexagon V3
  public static final /*uint*/int EF_HEXAGON_MACH_V4 = 0x00000003; // Hexagon V4
  public static final /*uint*/int EF_HEXAGON_MACH_V5 = 0x00000004; // Hexagon V5
  public static final /*uint*/int EF_HEXAGON_MACH_V55 = 0x00000005; // Hexagon V55
  public static final /*uint*/int EF_HEXAGON_MACH_V60 = 0x00000060; // Hexagon V60
  
  // Highest ISA version flags
  public static final /*uint*/int EF_HEXAGON_ISA_MACH = 0x00000000; // Same as specified in bits[11:0]
  // of e_flags
  public static final /*uint*/int EF_HEXAGON_ISA_V2 = 0x00000010; // Hexagon V2 ISA
  public static final /*uint*/int EF_HEXAGON_ISA_V3 = 0x00000020; // Hexagon V3 ISA
  public static final /*uint*/int EF_HEXAGON_ISA_V4 = 0x00000030; // Hexagon V4 ISA
  public static final /*uint*/int EF_HEXAGON_ISA_V5 = 0x00000040; // Hexagon V5 ISA
  public static final /*uint*/int EF_HEXAGON_ISA_V55 = 0x00000050; // Hexagon V55 ISA
  public static final /*uint*/int EF_HEXAGON_ISA_V60 = 0x00000060; // Hexagon V60 ISA
/*}*/

// Hexagon-specific section indexes for common small data
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 582,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 579,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum23",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum23")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int SHN_HEXAGON_SCOMMON = 0xff00; // Other access sizes
  public static final /*uint*/int SHN_HEXAGON_SCOMMON_1 = 0xff01; // Byte-sized access
  public static final /*uint*/int SHN_HEXAGON_SCOMMON_2 = 0xff02; // Half-word-sized access
  public static final /*uint*/int SHN_HEXAGON_SCOMMON_4 = 0xff03; // Word-sized access
  public static final /*uint*/int SHN_HEXAGON_SCOMMON_8 = 0xff04; // Double-word-size access
/*}*/

// ELF Relocation types for Hexagon
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 591,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 588,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum24",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum24")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // Release 5 ABI
  public static final /*uint*/int R_HEX_NONE = 0;
  public static final /*uint*/int R_HEX_B22_PCREL = 1;
  public static final /*uint*/int R_HEX_B15_PCREL = 2;
  public static final /*uint*/int R_HEX_B7_PCREL = 3;
  public static final /*uint*/int R_HEX_LO16 = 4;
  public static final /*uint*/int R_HEX_HI16 = 5;
  public static final /*uint*/int R_HEX_32 = 6;
  public static final /*uint*/int R_HEX_16 = 7;
  public static final /*uint*/int R_HEX_8 = 8;
  public static final /*uint*/int R_HEX_GPREL16_0 = 9;
  public static final /*uint*/int R_HEX_GPREL16_1 = 10;
  public static final /*uint*/int R_HEX_GPREL16_2 = 11;
  public static final /*uint*/int R_HEX_GPREL16_3 = 12;
  public static final /*uint*/int R_HEX_HL16 = 13;
  public static final /*uint*/int R_HEX_B13_PCREL = 14;
  public static final /*uint*/int R_HEX_B9_PCREL = 15;
  public static final /*uint*/int R_HEX_B32_PCREL_X = 16;
  public static final /*uint*/int R_HEX_32_6_X = 17;
  public static final /*uint*/int R_HEX_B22_PCREL_X = 18;
  public static final /*uint*/int R_HEX_B15_PCREL_X = 19;
  public static final /*uint*/int R_HEX_B13_PCREL_X = 20;
  public static final /*uint*/int R_HEX_B9_PCREL_X = 21;
  public static final /*uint*/int R_HEX_B7_PCREL_X = 22;
  public static final /*uint*/int R_HEX_16_X = 23;
  public static final /*uint*/int R_HEX_12_X = 24;
  public static final /*uint*/int R_HEX_11_X = 25;
  public static final /*uint*/int R_HEX_10_X = 26;
  public static final /*uint*/int R_HEX_9_X = 27;
  public static final /*uint*/int R_HEX_8_X = 28;
  public static final /*uint*/int R_HEX_7_X = 29;
  public static final /*uint*/int R_HEX_6_X = 30;
  public static final /*uint*/int R_HEX_32_PCREL = 31;
  public static final /*uint*/int R_HEX_COPY = 32;
  public static final /*uint*/int R_HEX_GLOB_DAT = 33;
  public static final /*uint*/int R_HEX_JMP_SLOT = 34;
  public static final /*uint*/int R_HEX_RELATIVE = 35;
  public static final /*uint*/int R_HEX_PLT_B22_PCREL = 36;
  public static final /*uint*/int R_HEX_GOTREL_LO16 = 37;
  public static final /*uint*/int R_HEX_GOTREL_HI16 = 38;
  public static final /*uint*/int R_HEX_GOTREL_32 = 39;
  public static final /*uint*/int R_HEX_GOT_LO16 = 40;
  public static final /*uint*/int R_HEX_GOT_HI16 = 41;
  public static final /*uint*/int R_HEX_GOT_32 = 42;
  public static final /*uint*/int R_HEX_GOT_16 = 43;
  public static final /*uint*/int R_HEX_DTPMOD_32 = 44;
  public static final /*uint*/int R_HEX_DTPREL_LO16 = 45;
  public static final /*uint*/int R_HEX_DTPREL_HI16 = 46;
  public static final /*uint*/int R_HEX_DTPREL_32 = 47;
  public static final /*uint*/int R_HEX_DTPREL_16 = 48;
  public static final /*uint*/int R_HEX_GD_PLT_B22_PCREL = 49;
  public static final /*uint*/int R_HEX_GD_GOT_LO16 = 50;
  public static final /*uint*/int R_HEX_GD_GOT_HI16 = 51;
  public static final /*uint*/int R_HEX_GD_GOT_32 = 52;
  public static final /*uint*/int R_HEX_GD_GOT_16 = 53;
  public static final /*uint*/int R_HEX_IE_LO16 = 54;
  public static final /*uint*/int R_HEX_IE_HI16 = 55;
  public static final /*uint*/int R_HEX_IE_32 = 56;
  public static final /*uint*/int R_HEX_IE_GOT_LO16 = 57;
  public static final /*uint*/int R_HEX_IE_GOT_HI16 = 58;
  public static final /*uint*/int R_HEX_IE_GOT_32 = 59;
  public static final /*uint*/int R_HEX_IE_GOT_16 = 60;
  public static final /*uint*/int R_HEX_TPREL_LO16 = 61;
  public static final /*uint*/int R_HEX_TPREL_HI16 = 62;
  public static final /*uint*/int R_HEX_TPREL_32 = 63;
  public static final /*uint*/int R_HEX_TPREL_16 = 64;
  public static final /*uint*/int R_HEX_6_PCREL_X = 65;
  public static final /*uint*/int R_HEX_GOTREL_32_6_X = 66;
  public static final /*uint*/int R_HEX_GOTREL_16_X = 67;
  public static final /*uint*/int R_HEX_GOTREL_11_X = 68;
  public static final /*uint*/int R_HEX_GOT_32_6_X = 69;
  public static final /*uint*/int R_HEX_GOT_16_X = 70;
  public static final /*uint*/int R_HEX_GOT_11_X = 71;
  public static final /*uint*/int R_HEX_DTPREL_32_6_X = 72;
  public static final /*uint*/int R_HEX_DTPREL_16_X = 73;
  public static final /*uint*/int R_HEX_DTPREL_11_X = 74;
  public static final /*uint*/int R_HEX_GD_GOT_32_6_X = 75;
  public static final /*uint*/int R_HEX_GD_GOT_16_X = 76;
  public static final /*uint*/int R_HEX_GD_GOT_11_X = 77;
  public static final /*uint*/int R_HEX_IE_32_6_X = 78;
  public static final /*uint*/int R_HEX_IE_16_X = 79;
  public static final /*uint*/int R_HEX_IE_GOT_32_6_X = 80;
  public static final /*uint*/int R_HEX_IE_GOT_16_X = 81;
  public static final /*uint*/int R_HEX_IE_GOT_11_X = 82;
  public static final /*uint*/int R_HEX_TPREL_32_6_X = 83;
  public static final /*uint*/int R_HEX_TPREL_16_X = 84;
  public static final /*uint*/int R_HEX_TPREL_11_X = 85;
  public static final /*uint*/int R_HEX_LD_PLT_B22_PCREL = 86;
  public static final /*uint*/int R_HEX_LD_GOT_LO16 = 87;
  public static final /*uint*/int R_HEX_LD_GOT_HI16 = 88;
  public static final /*uint*/int R_HEX_LD_GOT_32 = 89;
  public static final /*uint*/int R_HEX_LD_GOT_16 = 90;
  public static final /*uint*/int R_HEX_LD_GOT_32_6_X = 91;
  public static final /*uint*/int R_HEX_LD_GOT_16_X = 92;
  public static final /*uint*/int R_HEX_LD_GOT_11_X = 93;
  public static final /*uint*/int R_HEX_23_REG = 94;
/*}*/

// ELF Relocation type for Lanai.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 596,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 593,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum25",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum25")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // No relocation
  public static final /*uint*/int R_LANAI_NONE = 0;
  // 21-bit symbol relocation
  public static final /*uint*/int R_LANAI_21 = 1;
  // 21-bit symbol relocation with last two bits masked to 0
  public static final /*uint*/int R_LANAI_21_F = 2;
  // 25-bit branch targets
  public static final /*uint*/int R_LANAI_25 = 3;
  // General 32-bit relocation
  public static final /*uint*/int R_LANAI_32 = 4;
  // Upper 16-bits of a symbolic relocation
  public static final /*uint*/int R_LANAI_HI16 = 5;
  // Lower 16-bits of a symbolic relocation
  public static final /*uint*/int R_LANAI_LO16 = 6;
/*}*/

// ELF Relocation types for S390/zSeries
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 601,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 598,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum26",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum26")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_390_NONE = 0;
  public static final /*uint*/int R_390_8 = 1;
  public static final /*uint*/int R_390_12 = 2;
  public static final /*uint*/int R_390_16 = 3;
  public static final /*uint*/int R_390_32 = 4;
  public static final /*uint*/int R_390_PC32 = 5;
  public static final /*uint*/int R_390_GOT12 = 6;
  public static final /*uint*/int R_390_GOT32 = 7;
  public static final /*uint*/int R_390_PLT32 = 8;
  public static final /*uint*/int R_390_COPY = 9;
  public static final /*uint*/int R_390_GLOB_DAT = 10;
  public static final /*uint*/int R_390_JMP_SLOT = 11;
  public static final /*uint*/int R_390_RELATIVE = 12;
  public static final /*uint*/int R_390_GOTOFF = 13;
  public static final /*uint*/int R_390_GOTPC = 14;
  public static final /*uint*/int R_390_GOT16 = 15;
  public static final /*uint*/int R_390_PC16 = 16;
  public static final /*uint*/int R_390_PC16DBL = 17;
  public static final /*uint*/int R_390_PLT16DBL = 18;
  public static final /*uint*/int R_390_PC32DBL = 19;
  public static final /*uint*/int R_390_PLT32DBL = 20;
  public static final /*uint*/int R_390_GOTPCDBL = 21;
  public static final /*uint*/int R_390_64 = 22;
  public static final /*uint*/int R_390_PC64 = 23;
  public static final /*uint*/int R_390_GOT64 = 24;
  public static final /*uint*/int R_390_PLT64 = 25;
  public static final /*uint*/int R_390_GOTENT = 26;
  public static final /*uint*/int R_390_GOTOFF16 = 27;
  public static final /*uint*/int R_390_GOTOFF64 = 28;
  public static final /*uint*/int R_390_GOTPLT12 = 29;
  public static final /*uint*/int R_390_GOTPLT16 = 30;
  public static final /*uint*/int R_390_GOTPLT32 = 31;
  public static final /*uint*/int R_390_GOTPLT64 = 32;
  public static final /*uint*/int R_390_GOTPLTENT = 33;
  public static final /*uint*/int R_390_PLTOFF16 = 34;
  public static final /*uint*/int R_390_PLTOFF32 = 35;
  public static final /*uint*/int R_390_PLTOFF64 = 36;
  public static final /*uint*/int R_390_TLS_LOAD = 37;
  public static final /*uint*/int R_390_TLS_GDCALL = 38;
  public static final /*uint*/int R_390_TLS_LDCALL = 39;
  public static final /*uint*/int R_390_TLS_GD32 = 40;
  public static final /*uint*/int R_390_TLS_GD64 = 41;
  public static final /*uint*/int R_390_TLS_GOTIE12 = 42;
  public static final /*uint*/int R_390_TLS_GOTIE32 = 43;
  public static final /*uint*/int R_390_TLS_GOTIE64 = 44;
  public static final /*uint*/int R_390_TLS_LDM32 = 45;
  public static final /*uint*/int R_390_TLS_LDM64 = 46;
  public static final /*uint*/int R_390_TLS_IE32 = 47;
  public static final /*uint*/int R_390_TLS_IE64 = 48;
  public static final /*uint*/int R_390_TLS_IEENT = 49;
  public static final /*uint*/int R_390_TLS_LE32 = 50;
  public static final /*uint*/int R_390_TLS_LE64 = 51;
  public static final /*uint*/int R_390_TLS_LDO32 = 52;
  public static final /*uint*/int R_390_TLS_LDO64 = 53;
  public static final /*uint*/int R_390_TLS_DTPMOD = 54;
  public static final /*uint*/int R_390_TLS_DTPOFF = 55;
  public static final /*uint*/int R_390_TLS_TPOFF = 56;
  public static final /*uint*/int R_390_20 = 57;
  public static final /*uint*/int R_390_GOT20 = 58;
  public static final /*uint*/int R_390_GOTPLT20 = 59;
  public static final /*uint*/int R_390_TLS_GOTIE20 = 60;
  public static final /*uint*/int R_390_IRELATIVE = 61;
/*}*/

// ELF Relocation type for Sparc.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 606,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 603,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum27",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum27")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_SPARC_NONE = 0;
  public static final /*uint*/int R_SPARC_8 = 1;
  public static final /*uint*/int R_SPARC_16 = 2;
  public static final /*uint*/int R_SPARC_32 = 3;
  public static final /*uint*/int R_SPARC_DISP8 = 4;
  public static final /*uint*/int R_SPARC_DISP16 = 5;
  public static final /*uint*/int R_SPARC_DISP32 = 6;
  public static final /*uint*/int R_SPARC_WDISP30 = 7;
  public static final /*uint*/int R_SPARC_WDISP22 = 8;
  public static final /*uint*/int R_SPARC_HI22 = 9;
  public static final /*uint*/int R_SPARC_22 = 10;
  public static final /*uint*/int R_SPARC_13 = 11;
  public static final /*uint*/int R_SPARC_LO10 = 12;
  public static final /*uint*/int R_SPARC_GOT10 = 13;
  public static final /*uint*/int R_SPARC_GOT13 = 14;
  public static final /*uint*/int R_SPARC_GOT22 = 15;
  public static final /*uint*/int R_SPARC_PC10 = 16;
  public static final /*uint*/int R_SPARC_PC22 = 17;
  public static final /*uint*/int R_SPARC_WPLT30 = 18;
  public static final /*uint*/int R_SPARC_COPY = 19;
  public static final /*uint*/int R_SPARC_GLOB_DAT = 20;
  public static final /*uint*/int R_SPARC_JMP_SLOT = 21;
  public static final /*uint*/int R_SPARC_RELATIVE = 22;
  public static final /*uint*/int R_SPARC_UA32 = 23;
  public static final /*uint*/int R_SPARC_PLT32 = 24;
  public static final /*uint*/int R_SPARC_HIPLT22 = 25;
  public static final /*uint*/int R_SPARC_LOPLT10 = 26;
  public static final /*uint*/int R_SPARC_PCPLT32 = 27;
  public static final /*uint*/int R_SPARC_PCPLT22 = 28;
  public static final /*uint*/int R_SPARC_PCPLT10 = 29;
  public static final /*uint*/int R_SPARC_10 = 30;
  public static final /*uint*/int R_SPARC_11 = 31;
  public static final /*uint*/int R_SPARC_64 = 32;
  public static final /*uint*/int R_SPARC_OLO10 = 33;
  public static final /*uint*/int R_SPARC_HH22 = 34;
  public static final /*uint*/int R_SPARC_HM10 = 35;
  public static final /*uint*/int R_SPARC_LM22 = 36;
  public static final /*uint*/int R_SPARC_PC_HH22 = 37;
  public static final /*uint*/int R_SPARC_PC_HM10 = 38;
  public static final /*uint*/int R_SPARC_PC_LM22 = 39;
  public static final /*uint*/int R_SPARC_WDISP16 = 40;
  public static final /*uint*/int R_SPARC_WDISP19 = 41;
  public static final /*uint*/int R_SPARC_7 = 43;
  public static final /*uint*/int R_SPARC_5 = 44;
  public static final /*uint*/int R_SPARC_6 = 45;
  public static final /*uint*/int R_SPARC_DISP64 = 46;
  public static final /*uint*/int R_SPARC_PLT64 = 47;
  public static final /*uint*/int R_SPARC_HIX22 = 48;
  public static final /*uint*/int R_SPARC_LOX10 = 49;
  public static final /*uint*/int R_SPARC_H44 = 50;
  public static final /*uint*/int R_SPARC_M44 = 51;
  public static final /*uint*/int R_SPARC_L44 = 52;
  public static final /*uint*/int R_SPARC_REGISTER = 53;
  public static final /*uint*/int R_SPARC_UA64 = 54;
  public static final /*uint*/int R_SPARC_UA16 = 55;
  public static final /*uint*/int R_SPARC_TLS_GD_HI22 = 56;
  public static final /*uint*/int R_SPARC_TLS_GD_LO10 = 57;
  public static final /*uint*/int R_SPARC_TLS_GD_ADD = 58;
  public static final /*uint*/int R_SPARC_TLS_GD_CALL = 59;
  public static final /*uint*/int R_SPARC_TLS_LDM_HI22 = 60;
  public static final /*uint*/int R_SPARC_TLS_LDM_LO10 = 61;
  public static final /*uint*/int R_SPARC_TLS_LDM_ADD = 62;
  public static final /*uint*/int R_SPARC_TLS_LDM_CALL = 63;
  public static final /*uint*/int R_SPARC_TLS_LDO_HIX22 = 64;
  public static final /*uint*/int R_SPARC_TLS_LDO_LOX10 = 65;
  public static final /*uint*/int R_SPARC_TLS_LDO_ADD = 66;
  public static final /*uint*/int R_SPARC_TLS_IE_HI22 = 67;
  public static final /*uint*/int R_SPARC_TLS_IE_LO10 = 68;
  public static final /*uint*/int R_SPARC_TLS_IE_LD = 69;
  public static final /*uint*/int R_SPARC_TLS_IE_LDX = 70;
  public static final /*uint*/int R_SPARC_TLS_IE_ADD = 71;
  public static final /*uint*/int R_SPARC_TLS_LE_HIX22 = 72;
  public static final /*uint*/int R_SPARC_TLS_LE_LOX10 = 73;
  public static final /*uint*/int R_SPARC_TLS_DTPMOD32 = 74;
  public static final /*uint*/int R_SPARC_TLS_DTPMOD64 = 75;
  public static final /*uint*/int R_SPARC_TLS_DTPOFF32 = 76;
  public static final /*uint*/int R_SPARC_TLS_DTPOFF64 = 77;
  public static final /*uint*/int R_SPARC_TLS_TPOFF32 = 78;
  public static final /*uint*/int R_SPARC_TLS_TPOFF64 = 79;
  public static final /*uint*/int R_SPARC_GOTDATA_HIX22 = 80;
  public static final /*uint*/int R_SPARC_GOTDATA_LOX10 = 81;
  public static final /*uint*/int R_SPARC_GOTDATA_OP_HIX22 = 82;
  public static final /*uint*/int R_SPARC_GOTDATA_OP_LOX10 = 83;
  public static final /*uint*/int R_SPARC_GOTDATA_OP = 84;
/*}*/

// ELF Relocation types for WebAssembly
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 611,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 638,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum28",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum28")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_WEBASSEMBLY_NONE = 0;
  public static final /*uint*/int R_WEBASSEMBLY_DATA = 1;
  public static final /*uint*/int R_WEBASSEMBLY_FUNCTION = 2;
/*}*/

// ELF Relocation types for AMDGPU
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 616,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 652,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum29",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum29")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int R_AMDGPU_NONE = 0;
  public static final /*uint*/int R_AMDGPU_ABS32_LO = 1;
  public static final /*uint*/int R_AMDGPU_ABS32_HI = 2;
  public static final /*uint*/int R_AMDGPU_ABS64 = 3;
  public static final /*uint*/int R_AMDGPU_REL32 = 4;
  public static final /*uint*/int R_AMDGPU_REL64 = 5;
  public static final /*uint*/int R_AMDGPU_ABS32 = 6;
  public static final /*uint*/int R_AMDGPU_GOTPCREL = 7;
/*}*/

// ELF Relocation types for BPF
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 621,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 701,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum30",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum30")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  
  // No relocation
  public static final /*uint*/int R_BPF_NONE = 0;
  // Map index in "maps" section to file descriptor
  // within ld_64 instruction.
  public static final /*uint*/int R_BPF_MAP_FD = 1;
/*}*/

// Section header.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Shdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 628,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 610,
 FQN="llvm::ELF::Elf32_Shdr", NM="_ZN4llvm3ELF10Elf32_ShdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_ShdrE")
//</editor-fold>
public static class/*struct*/ Elf32_Shdr {
  public /*uint32_t*/int sh_name; // Section name (index into string table)
  public /*uint32_t*/int sh_type; // Section type (SHT_*)
  public /*uint32_t*/int sh_flags; // Section flags (SHF_*)
  public /*uint32_t*/int sh_addr; // Address where section is to be loaded
  public /*uint32_t*/int sh_offset; // File offset of section data, in bytes
  public /*uint32_t*/int sh_size; // Size of section, in bytes
  public /*uint32_t*/int sh_link; // Section type-specific header table index link
  public /*uint32_t*/int sh_info; // Section type-specific extra information
  public /*uint32_t*/int sh_addralign; // Section address alignment
  public /*uint32_t*/int sh_entsize; // Size of records contained within the section
  
  @Override public String toString() {
    return "" + "sh_name=" + sh_name // NOI18N
              + ", sh_type=" + sh_type // NOI18N
              + ", sh_flags=" + sh_flags // NOI18N
              + ", sh_addr=" + sh_addr // NOI18N
              + ", sh_offset=" + sh_offset // NOI18N
              + ", sh_size=" + sh_size // NOI18N
              + ", sh_link=" + sh_link // NOI18N
              + ", sh_info=" + sh_info // NOI18N
              + ", sh_addralign=" + sh_addralign // NOI18N
              + ", sh_entsize=" + sh_entsize; // NOI18N
  }
}

// Section header for ELF64 - same fields as ELF32, different types.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Shdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 642,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 624,
 FQN="llvm::ELF::Elf64_Shdr", NM="_ZN4llvm3ELF10Elf64_ShdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_ShdrE")
//</editor-fold>
public static class/*struct*/ Elf64_Shdr {
  public /*uint32_t*/int sh_name;
  public /*uint32_t*/int sh_type;
  public long/*uint64_t*/ sh_flags;
  public long/*uint64_t*/ sh_addr;
  public long/*uint64_t*/ sh_offset;
  public long/*uint64_t*/ sh_size;
  public /*uint32_t*/int sh_link;
  public /*uint32_t*/int sh_info;
  public long/*uint64_t*/ sh_addralign;
  public long/*uint64_t*/ sh_entsize;
  
  @Override public String toString() {
    return "" + "sh_name=" + sh_name // NOI18N
              + ", sh_type=" + sh_type // NOI18N
              + ", sh_flags=" + sh_flags // NOI18N
              + ", sh_addr=" + sh_addr // NOI18N
              + ", sh_offset=" + sh_offset // NOI18N
              + ", sh_size=" + sh_size // NOI18N
              + ", sh_link=" + sh_link // NOI18N
              + ", sh_info=" + sh_info // NOI18N
              + ", sh_addralign=" + sh_addralign // NOI18N
              + ", sh_entsize=" + sh_entsize; // NOI18N
  }
}

// Special section indices.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 656,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 798,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum31",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum31")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int SHN_UNDEF = 0; // Undefined, missing, irrelevant, or meaningless
  public static final /*uint*/int SHN_LORESERVE = 0xff00; // Lowest reserved index
  public static final /*uint*/int SHN_LOPROC = 0xff00; // Lowest processor-specific index
  public static final /*uint*/int SHN_HIPROC = 0xff1f; // Highest processor-specific index
  public static final /*uint*/int SHN_LOOS = 0xff20; // Lowest operating system-specific index
  public static final /*uint*/int SHN_HIOS = 0xff3f; // Highest operating system-specific index
  public static final /*uint*/int SHN_ABS = 0xfff1; // Symbol has absolute value; does not need relocation
  public static final /*uint*/int SHN_COMMON = 0xfff2; // FORTRAN COMMON or C external global variables
  public static final /*uint*/int SHN_XINDEX = 0xffff; // Mark that the index is >= SHN_LORESERVE
  public static final /*uint*/int SHN_HIRESERVE = 0xffff; // Highest reserved index
/*}*/

// Section types.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 670,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 845,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum32",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum32")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int SHT_NULL = 0; // No associated section (inactive entry).
  public static final /*uint*/int SHT_PROGBITS = 1; // Program-defined contents.
  public static final /*uint*/int SHT_SYMTAB = 2; // Symbol table.
  public static final /*uint*/int SHT_STRTAB = 3; // String table.
  public static final /*uint*/int SHT_RELA = 4; // Relocation entries; explicit addends.
  public static final /*uint*/int SHT_HASH = 5; // Symbol hash table.
  public static final /*uint*/int SHT_DYNAMIC = 6; // Information for dynamic linking.
  public static final /*uint*/int SHT_NOTE = 7; // Information about the file.
  public static final /*uint*/int SHT_NOBITS = 8; // Data occupies no space in the file.
  public static final /*uint*/int SHT_REL = 9; // Relocation entries; no explicit addends.
  public static final /*uint*/int SHT_SHLIB = 10; // Reserved.
  public static final /*uint*/int SHT_DYNSYM = 11; // Symbol table.
  public static final /*uint*/int SHT_INIT_ARRAY = 14; // Pointers to initialization functions.
  public static final /*uint*/int SHT_FINI_ARRAY = 15; // Pointers to termination functions.
  public static final /*uint*/int SHT_PREINIT_ARRAY = 16; // Pointers to pre-init functions.
  public static final /*uint*/int SHT_GROUP = 17; // Section group.
  public static final /*uint*/int SHT_SYMTAB_SHNDX = 18; // Indices for SHN_XINDEX entries.
  public static final /*uint*/int SHT_LOOS = 0x60000000; // Lowest operating system-specific type.
  public static final /*uint*/int SHT_GNU_ATTRIBUTES = 0x6ffffff5; // Object attributes.
  public static final /*uint*/int SHT_GNU_HASH = 0x6ffffff6; // GNU-style hash table.
  public static final /*uint*/int SHT_GNU_verdef = 0x6ffffffd; // GNU version definitions.
  public static final /*uint*/int SHT_GNU_verneed = 0x6ffffffe; // GNU version references.
  public static final /*uint*/int SHT_GNU_versym = 0x6fffffff; // GNU symbol versions table.
  public static final /*uint*/int SHT_HIOS = 0x6fffffff; // Highest operating system-specific type.
  public static final /*uint*/int SHT_LOPROC = 0x70000000; // Lowest processor arch-specific type.
  // Fixme: All this is duplicated in MCSectionELF. Why??
  // Exception Index table
  public static final /*uint*/int SHT_ARM_EXIDX = 0x70000001/*U*/;
  // BPABI DLL dynamic linking pre-emption map
  public static final /*uint*/int SHT_ARM_PREEMPTMAP = 0x70000002/*U*/;
  //  Object file compatibility attributes
  public static final /*uint*/int SHT_ARM_ATTRIBUTES = 0x70000003/*U*/;
  public static final /*uint*/int SHT_ARM_DEBUGOVERLAY = 0x70000004/*U*/;
  public static final /*uint*/int SHT_ARM_OVERLAYSECTION = 0x70000005/*U*/;
  public static final /*uint*/int SHT_HEX_ORDERED = 0x70000000; // Link editor is to sort the entries in
  // this section based on their sizes
  public static final /*uint*/int SHT_X86_64_UNWIND = 0x70000001; // Unwind information
  
  public static final /*uint*/int SHT_MIPS_REGINFO = 0x70000006; // Register usage information
  public static final /*uint*/int SHT_MIPS_OPTIONS = 0x7000000d; // General options
  public static final /*uint*/int SHT_MIPS_ABIFLAGS = 0x7000002a; // ABI information.
  
  public static final /*uint*/int SHT_HIPROC = 0x7fffffff; // Highest processor arch-specific type.
  public static final /*uint*/int SHT_LOUSER = 0x80000000/*U*/; // Lowest type reserved for applications.
  public static final /*uint*/int SHT_HIUSER = 0xffffffff/*U*/; // Highest type reserved for applications.
/*}*/

// Section flags.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 719,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 851,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum33",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum33")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  // Section data should be writable during execution.
  public static final /*uint*/int SHF_WRITE = 0x1;
  
  // Section occupies memory during program execution.
  public static final /*uint*/int SHF_ALLOC = 0x2;
  
  // Section contains executable machine instructions.
  public static final /*uint*/int SHF_EXECINSTR = 0x4;
  
  // The data in this section may be merged.
  public static final /*uint*/int SHF_MERGE = 0x10;
  
  // The data in this section is null-terminated strings.
  public static final /*uint*/int SHF_STRINGS = 0x20;
  
  // A field in this section holds a section header table index.
  public static final /*uint*/int SHF_INFO_LINK = 0x40/*U*/;
  
  // Adds special ordering requirements for link editors.
  public static final /*uint*/int SHF_LINK_ORDER = 0x80/*U*/;
  
  // This section requires special OS-specific processing to avoid incorrect
  // behavior.
  public static final /*uint*/int SHF_OS_NONCONFORMING = 0x100/*U*/;
  
  // This section is a member of a section group.
  public static final /*uint*/int SHF_GROUP = 0x200/*U*/;
  
  // This section holds Thread-Local Storage.
  public static final /*uint*/int SHF_TLS = 0x400/*U*/;
  
  // Identifies a section containing compressed data.
  public static final /*uint*/int SHF_COMPRESSED = 0x800/*U*/;
  
  // This section is excluded from the final executable or shared library.
  public static final /*uint*/int SHF_EXCLUDE = 0x80000000/*U*/;
  
  // Start of target-specific flags.
  
  /// XCORE_SHF_CP_SECTION - All sections with the "c" flag are grouped
  /// together by the linker to form the constant pool and the cp register is
  /// set to the start of the constant pool by the boot code.
  public static final /*uint*/int XCORE_SHF_CP_SECTION = 0x800/*U*/;
  
  /// XCORE_SHF_DP_SECTION - All sections with the "d" flag are grouped
  /// together by the linker to form the data section and the dp register is
  /// set to the start of the section by the boot code.
  public static final /*uint*/int XCORE_SHF_DP_SECTION = 0x1000/*U*/;
  
  public static final /*uint*/int SHF_MASKOS = 0x0ff00000;
  
  // Bits indicating processor-specific flags.
  public static final /*uint*/int SHF_MASKPROC = 0xf0000000/*U*/;
  
  // If an object file section does not have this flag set, then it may not hold
  // more than 2GB and can be freely referred to in objects using smaller code
  // models. Otherwise, only objects using larger code models can refer to them.
  // For example, a medium code model object can refer to data in a section that
  // sets this flag besides being able to refer to data in a section that does
  // not set it; likewise, a small code model object can refer only to code in a
  // section that does not set this flag.
  public static final /*uint*/int SHF_X86_64_LARGE = 0x10000000;
  
  // All sections with the GPREL flag are grouped into a global data area
  // for faster accesses
  public static final /*uint*/int SHF_HEX_GPREL = 0x10000000;
  
  // Section contains text/data which may be replicated in other sections.
  // Linker must retain only one copy.
  public static final /*uint*/int SHF_MIPS_NODUPES = 0x01000000;
  
  // Linker must generate implicit hidden weak names.
  public static final /*uint*/int SHF_MIPS_NAMES = 0x02000000;
  
  // Section data local to process.
  public static final /*uint*/int SHF_MIPS_LOCAL = 0x04000000;
  
  // Do not strip this section.
  public static final /*uint*/int SHF_MIPS_NOSTRIP = 0x08000000;
  
  // Section must be part of global data area.
  public static final /*uint*/int SHF_MIPS_GPREL = 0x10000000;
  
  // This section should be merged.
  public static final /*uint*/int SHF_MIPS_MERGE = 0x20000000;
  
  // Address size to be inferred from section entry size.
  public static final /*uint*/int SHF_MIPS_ADDR = 0x40000000;
  
  // Section data is string data by default.
  public static final /*uint*/int SHF_MIPS_STRING = 0x80000000/*U*/;
  
  public static final /*uint*/int SHF_AMDGPU_HSA_GLOBAL = 0x00100000;
  public static final /*uint*/int SHF_AMDGPU_HSA_READONLY = 0x00200000;
  public static final /*uint*/int SHF_AMDGPU_HSA_CODE = 0x00400000;
  public static final /*uint*/int SHF_AMDGPU_HSA_AGENT = 0x00800000;
/*}*/

// Section Group Flags
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 819,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 863,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum34",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum34")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int GRP_COMDAT = 0x1;
  public static final /*uint*/int GRP_MASKOS = 0x0ff00000;
  public static final /*uint*/int GRP_MASKPROC = 0xf0000000/*U*/;
/*}*/

// Symbol table entries for ELF32.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 826,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 805,
 FQN="llvm::ELF::Elf32_Sym", NM="_ZN4llvm3ELF9Elf32_SymE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_SymE")
//</editor-fold>
public static class/*struct*/ Elf32_Sym {
  public /*uint32_t*/int st_name; // Symbol name (index into string table)
  public /*uint32_t*/int st_value; // Value or address associated with the symbol
  public /*uint32_t*/int st_size; // Size of the symbol
  public /*uchar*/byte st_info; // Symbol's type and binding attributes
  public /*uchar*/byte st_other; // Must be zero; reserved
  public /*uint16_t*/char st_shndx; // Which section (header table index) it's defined in
  
  // These accessors and mutators correspond to the ELF32_ST_BIND,
  // ELF32_ST_TYPE, and ELF32_ST_INFO macros defined in the ELF specification:
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym::getBinding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 836,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 815,
   FQN="llvm::ELF::Elf32_Sym::getBinding", NM="_ZNK4llvm3ELF9Elf32_Sym10getBindingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf32_Sym10getBindingEv")
  //</editor-fold>
  public /*uchar*/byte getBinding() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 837,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 816,
   FQN="llvm::ELF::Elf32_Sym::getType", NM="_ZNK4llvm3ELF9Elf32_Sym7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf32_Sym7getTypeEv")
  //</editor-fold>
  public /*uchar*/byte getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym::setBinding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 838,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 817,
   FQN="llvm::ELF::Elf32_Sym::setBinding", NM="_ZN4llvm3ELF9Elf32_Sym10setBindingEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Sym10setBindingEh")
  //</editor-fold>
  public void setBinding(/*uchar*/byte b) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 839,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 818,
   FQN="llvm::ELF::Elf32_Sym::setType", NM="_ZN4llvm3ELF9Elf32_Sym7setTypeEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Sym7setTypeEh")
  //</editor-fold>
  public void setType(/*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Sym::setBindingAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 840,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 819,
   FQN="llvm::ELF::Elf32_Sym::setBindingAndType", NM="_ZN4llvm3ELF9Elf32_Sym17setBindingAndTypeEhh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Sym17setBindingAndTypeEhh")
  //</editor-fold>
  public void setBindingAndType(/*uchar*/byte b, /*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "st_name=" + st_name // NOI18N
              + ", st_value=" + st_value // NOI18N
              + ", st_size=" + st_size // NOI18N
              + ", st_info=" + $uchar2uint(st_info) // NOI18N
              + ", st_other=" + $uchar2uint(st_other) // NOI18N
              + ", st_shndx=" + $ushort2uint(st_shndx); // NOI18N
  }
}

// Symbol table entries for ELF64.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 846,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 825,
 FQN="llvm::ELF::Elf64_Sym", NM="_ZN4llvm3ELF9Elf64_SymE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_SymE")
//</editor-fold>
public static class/*struct*/ Elf64_Sym {
  public /*uint32_t*/int st_name; // Symbol name (index into string table)
  public /*uchar*/byte st_info; // Symbol's type and binding attributes
  public /*uchar*/byte st_other; // Must be zero; reserved
  public /*uint16_t*/char st_shndx; // Which section (header tbl index) it's defined in
  public long/*uint64_t*/ st_value; // Value or address associated with the symbol
  public long/*uint64_t*/ st_size; // Size of the symbol
  
  // These accessors and mutators are identical to those defined for ELF32
  // symbol table entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym::getBinding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 856,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 835,
   FQN="llvm::ELF::Elf64_Sym::getBinding", NM="_ZNK4llvm3ELF9Elf64_Sym10getBindingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf64_Sym10getBindingEv")
  //</editor-fold>
  public /*uchar*/byte getBinding() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 857,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 836,
   FQN="llvm::ELF::Elf64_Sym::getType", NM="_ZNK4llvm3ELF9Elf64_Sym7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf64_Sym7getTypeEv")
  //</editor-fold>
  public /*uchar*/byte getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym::setBinding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 858,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 837,
   FQN="llvm::ELF::Elf64_Sym::setBinding", NM="_ZN4llvm3ELF9Elf64_Sym10setBindingEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Sym10setBindingEh")
  //</editor-fold>
  public void setBinding(/*uchar*/byte b) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 859,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 838,
   FQN="llvm::ELF::Elf64_Sym::setType", NM="_ZN4llvm3ELF9Elf64_Sym7setTypeEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Sym7setTypeEh")
  //</editor-fold>
  public void setType(/*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Sym::setBindingAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 860,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 839,
   FQN="llvm::ELF::Elf64_Sym::setBindingAndType", NM="_ZN4llvm3ELF9Elf64_Sym17setBindingAndTypeEhh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Sym17setBindingAndTypeEhh")
  //</editor-fold>
  public void setBindingAndType(/*uchar*/byte b, /*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "st_name=" + st_name // NOI18N
              + ", st_info=" + $uchar2uint(st_info) // NOI18N
              + ", st_other=" + $uchar2uint(st_other) // NOI18N
              + ", st_shndx=" + $ushort2uint(st_shndx) // NOI18N
              + ", st_value=" + st_value // NOI18N
              + ", st_size=" + st_size; // NOI18N
  }
}

// The size (in bytes) of symbol table entries.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 866,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 883,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum35",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum35")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int SYMENTRY_SIZE32 = 16; // 32-bit symbol entry size
  public static final /*uint*/int SYMENTRY_SIZE64 = 24; // 64-bit symbol entry size.
/*}*/

// Symbol bindings.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 872,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 891,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum36",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum36")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STB_LOCAL = 0; // Local symbol, not visible outside obj file containing def
  public static final /*uint*/int STB_GLOBAL = 1; // Global symbol, visible to all object files being combined
  public static final /*uint*/int STB_WEAK = 2; // Weak symbol, like global but lower-precedence
  public static final /*uint*/int STB_GNU_UNIQUE = 10;
  public static final /*uint*/int STB_LOOS = 10; // Lowest operating system-specific binding type
  public static final /*uint*/int STB_HIOS = 12; // Highest operating system-specific binding type
  public static final /*uint*/int STB_LOPROC = 13; // Lowest processor-specific binding type
  public static final /*uint*/int STB_HIPROC = 15; // Highest processor-specific binding type
/*}*/

// Symbol types.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 884,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 896,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum37",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum37")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STT_NOTYPE = 0; // Symbol's type is not specified
  public static final /*uint*/int STT_OBJECT = 1; // Symbol is a data object (variable, array, etc.)
  public static final /*uint*/int STT_FUNC = 2; // Symbol is executable code (function, etc.)
  public static final /*uint*/int STT_SECTION = 3; // Symbol refers to a section
  public static final /*uint*/int STT_FILE = 4; // Local, absolute symbol that refers to a file
  public static final /*uint*/int STT_COMMON = 5; // An uninitialized common block
  public static final /*uint*/int STT_TLS = 6; // Thread local data object
  public static final /*uint*/int STT_GNU_IFUNC = 10; // GNU indirect function
  public static final /*uint*/int STT_LOOS = 10; // Lowest operating system-specific symbol type
  public static final /*uint*/int STT_HIOS = 12; // Highest operating system-specific symbol type
  public static final /*uint*/int STT_LOPROC = 13; // Lowest processor-specific symbol type
  public static final /*uint*/int STT_HIPROC = 15; // Highest processor-specific symbol type
  
  // AMDGPU symbol types
  public static final /*uint*/int STT_AMDGPU_HSA_KERNEL = 10;
  public static final /*uint*/int STT_AMDGPU_HSA_INDIRECT_FUNCTION = 11;
  public static final /*uint*/int STT_AMDGPU_HSA_METADATA = 12;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 904,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 998,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum38",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum38")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STV_DEFAULT = 0; // Visibility is specified by binding type
  public static final /*uint*/int STV_INTERNAL = 1; // Defined by processor supplements
  public static final /*uint*/int STV_HIDDEN = 2; // Not visible to other components
  public static final /*uint*/int STV_PROTECTED = 3; // Visible in other components but not preemptable
/*}*/

// Symbol number.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 912,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1044,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum39",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum39")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int STN_UNDEF = 0;
/*}*/

// Special relocation symbols used in the MIPS64 ELF relocation entries
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 917,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1075,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum40",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum40")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int RSS_UNDEF = 0; // None
  public static final /*uint*/int RSS_GP = 1; // Value of gp
  public static final /*uint*/int RSS_GP0 = 2; // Value of gp used to create object being relocated
  public static final /*uint*/int RSS_LOC = 3; // Address of location being relocated
/*}*/

// Relocation entry, without explicit addend.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 925,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 904,
 FQN="llvm::ELF::Elf32_Rel", NM="_ZN4llvm3ELF9Elf32_RelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_RelE")
//</editor-fold>
public static class/*struct*/ Elf32_Rel {
  public /*uint32_t*/int r_offset; // Location (file byte offset, or program virtual addr)
  public /*uint32_t*/int r_info; // Symbol table index and type of relocation to apply
  
  // These accessors and mutators correspond to the ELF32_R_SYM, ELF32_R_TYPE,
  // and ELF32_R_INFO macros defined in the ELF specification:
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 931,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 910,
   FQN="llvm::ELF::Elf32_Rel::getSymbol", NM="_ZNK4llvm3ELF9Elf32_Rel9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf32_Rel9getSymbolEv")
  //</editor-fold>
  public /*uint32_t*/int getSymbol() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 932,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 911,
   FQN="llvm::ELF::Elf32_Rel::getType", NM="_ZNK4llvm3ELF9Elf32_Rel7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf32_Rel7getTypeEv")
  //</editor-fold>
  public /*uchar*/byte getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel::setSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 933,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 912,
   FQN="llvm::ELF::Elf32_Rel::setSymbol", NM="_ZN4llvm3ELF9Elf32_Rel9setSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Rel9setSymbolEj")
  //</editor-fold>
  public void setSymbol(/*uint32_t*/int s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 934,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 913,
   FQN="llvm::ELF::Elf32_Rel::setType", NM="_ZN4llvm3ELF9Elf32_Rel7setTypeEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Rel7setTypeEh")
  //</editor-fold>
  public void setType(/*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rel::setSymbolAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 935,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 914,
   FQN="llvm::ELF::Elf32_Rel::setSymbolAndType", NM="_ZN4llvm3ELF9Elf32_Rel16setSymbolAndTypeEjh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_Rel16setSymbolAndTypeEjh")
  //</editor-fold>
  public void setSymbolAndType(/*uint32_t*/int s, /*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "r_offset=" + r_offset // NOI18N
              + ", r_info=" + r_info; // NOI18N
  }
}

// Relocation entry with explicit addend.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 941,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 920,
 FQN="llvm::ELF::Elf32_Rela", NM="_ZN4llvm3ELF10Elf32_RelaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_RelaE")
//</editor-fold>
public static class/*struct*/ Elf32_Rela {
  public /*uint32_t*/int r_offset; // Location (file byte offset, or program virtual addr)
  public /*uint32_t*/int r_info; // Symbol table index and type of relocation to apply
  public int/*int32_t*/ r_addend; // Compute value for relocatable field by adding this
  
  // These accessors and mutators correspond to the ELF32_R_SYM, ELF32_R_TYPE,
  // and ELF32_R_INFO macros defined in the ELF specification:
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 948,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 927,
   FQN="llvm::ELF::Elf32_Rela::getSymbol", NM="_ZNK4llvm3ELF10Elf32_Rela9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf32_Rela9getSymbolEv")
  //</editor-fold>
  public /*uint32_t*/int getSymbol() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 949,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 928,
   FQN="llvm::ELF::Elf32_Rela::getType", NM="_ZNK4llvm3ELF10Elf32_Rela7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf32_Rela7getTypeEv")
  //</editor-fold>
  public /*uchar*/byte getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::setSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 950,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 929,
   FQN="llvm::ELF::Elf32_Rela::setSymbol", NM="_ZN4llvm3ELF10Elf32_Rela9setSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_Rela9setSymbolEj")
  //</editor-fold>
  public void setSymbol(/*uint32_t*/int s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 951,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 930,
   FQN="llvm::ELF::Elf32_Rela::setType", NM="_ZN4llvm3ELF10Elf32_Rela7setTypeEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_Rela7setTypeEh")
  //</editor-fold>
  public void setType(/*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::setSymbolAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 952,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 931,
   FQN="llvm::ELF::Elf32_Rela::setSymbolAndType", NM="_ZN4llvm3ELF10Elf32_Rela16setSymbolAndTypeEjh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_Rela16setSymbolAndTypeEjh")
  //</editor-fold>
  public void setSymbolAndType(/*uint32_t*/int s, /*uchar*/byte t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Rela::Elf32_Rela">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 941,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 920,
   FQN="llvm::ELF::Elf32_Rela::Elf32_Rela", NM="_ZN4llvm3ELF10Elf32_RelaC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_RelaC1Ev")
  //</editor-fold>
  public /*inline*/ Elf32_Rela() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "r_offset=" + r_offset // NOI18N
              + ", r_info=" + r_info // NOI18N
              + ", r_addend=" + r_addend; // NOI18N
  }
}

// Relocation entry, without explicit addend.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 958,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 937,
 FQN="llvm::ELF::Elf64_Rel", NM="_ZN4llvm3ELF9Elf64_RelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_RelE")
//</editor-fold>
public static class/*struct*/ Elf64_Rel {
  public long/*uint64_t*/ r_offset; // Location (file byte offset, or program virtual addr).
  public long/*uint64_t*/ r_info; // Symbol table index and type of relocation to apply.
  
  // These accessors and mutators correspond to the ELF64_R_SYM, ELF64_R_TYPE,
  // and ELF64_R_INFO macros defined in the ELF specification:
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 964,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 943,
   FQN="llvm::ELF::Elf64_Rel::getSymbol", NM="_ZNK4llvm3ELF9Elf64_Rel9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf64_Rel9getSymbolEv")
  //</editor-fold>
  public /*uint32_t*/int getSymbol() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 965,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 944,
   FQN="llvm::ELF::Elf64_Rel::getType", NM="_ZNK4llvm3ELF9Elf64_Rel7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF9Elf64_Rel7getTypeEv")
  //</editor-fold>
  public /*uint32_t*/int getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel::setSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 968,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 947,
   FQN="llvm::ELF::Elf64_Rel::setSymbol", NM="_ZN4llvm3ELF9Elf64_Rel9setSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Rel9setSymbolEj")
  //</editor-fold>
  public void setSymbol(/*uint32_t*/int s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 969,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 948,
   FQN="llvm::ELF::Elf64_Rel::setType", NM="_ZN4llvm3ELF9Elf64_Rel7setTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Rel7setTypeEj")
  //</editor-fold>
  public void setType(/*uint32_t*/int t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rel::setSymbolAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 970,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 949,
   FQN="llvm::ELF::Elf64_Rel::setSymbolAndType", NM="_ZN4llvm3ELF9Elf64_Rel16setSymbolAndTypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_Rel16setSymbolAndTypeEjj")
  //</editor-fold>
  public void setSymbolAndType(/*uint32_t*/int s, /*uint32_t*/int t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "r_offset=" + r_offset // NOI18N
              + ", r_info=" + r_info; // NOI18N
  }
}

// Relocation entry with explicit addend.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 976,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 955,
 FQN="llvm::ELF::Elf64_Rela", NM="_ZN4llvm3ELF10Elf64_RelaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_RelaE")
//</editor-fold>
public static class/*struct*/ Elf64_Rela {
  public long/*uint64_t*/ r_offset; // Location (file byte offset, or program virtual addr).
  public long/*uint64_t*/ r_info; // Symbol table index and type of relocation to apply.
  public long/*int64_t*/ r_addend; // Compute value for relocatable field by adding this.
  
  // These accessors and mutators correspond to the ELF64_R_SYM, ELF64_R_TYPE,
  // and ELF64_R_INFO macros defined in the ELF specification:
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 983,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 962,
   FQN="llvm::ELF::Elf64_Rela::getSymbol", NM="_ZNK4llvm3ELF10Elf64_Rela9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf64_Rela9getSymbolEv")
  //</editor-fold>
  public /*uint32_t*/int getSymbol() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 984,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 963,
   FQN="llvm::ELF::Elf64_Rela::getType", NM="_ZNK4llvm3ELF10Elf64_Rela7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm3ELF10Elf64_Rela7getTypeEv")
  //</editor-fold>
  public /*uint32_t*/int getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::setSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 987,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 966,
   FQN="llvm::ELF::Elf64_Rela::setSymbol", NM="_ZN4llvm3ELF10Elf64_Rela9setSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_Rela9setSymbolEj")
  //</editor-fold>
  public void setSymbol(/*uint32_t*/int s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::setType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 988,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 967,
   FQN="llvm::ELF::Elf64_Rela::setType", NM="_ZN4llvm3ELF10Elf64_Rela7setTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_Rela7setTypeEj")
  //</editor-fold>
  public void setType(/*uint32_t*/int t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::setSymbolAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 989,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 968,
   FQN="llvm::ELF::Elf64_Rela::setSymbolAndType", NM="_ZN4llvm3ELF10Elf64_Rela16setSymbolAndTypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_Rela16setSymbolAndTypeEjj")
  //</editor-fold>
  public void setSymbolAndType(/*uint32_t*/int s, /*uint32_t*/int t) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Rela::Elf64_Rela">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 976,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 955,
   FQN="llvm::ELF::Elf64_Rela::Elf64_Rela", NM="_ZN4llvm3ELF10Elf64_RelaC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_RelaC1Ev")
  //</editor-fold>
  public /*inline*/ Elf64_Rela() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "r_offset=" + r_offset // NOI18N
              + ", r_info=" + r_info // NOI18N
              + ", r_addend=" + r_addend; // NOI18N
  }
}

// Program header for ELF32.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Phdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 995,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 974,
 FQN="llvm::ELF::Elf32_Phdr", NM="_ZN4llvm3ELF10Elf32_PhdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_PhdrE")
//</editor-fold>
public static class/*struct*/ Elf32_Phdr {
  public /*uint32_t*/int p_type; // Type of segment
  public /*uint32_t*/int p_offset; // File offset where segment is located, in bytes
  public /*uint32_t*/int p_vaddr; // Virtual address of beginning of segment
  public /*uint32_t*/int p_paddr; // Physical address of beginning of segment (OS-specific)
  public /*uint32_t*/int p_filesz; // Num. of bytes in file image of segment (may be zero)
  public /*uint32_t*/int p_memsz; // Num. of bytes in mem image of segment (may be zero)
  public /*uint32_t*/int p_flags; // Segment flags
  public /*uint32_t*/int p_align; // Segment alignment constraint
  
  @Override public String toString() {
    return "" + "p_type=" + p_type // NOI18N
              + ", p_offset=" + p_offset // NOI18N
              + ", p_vaddr=" + p_vaddr // NOI18N
              + ", p_paddr=" + p_paddr // NOI18N
              + ", p_filesz=" + p_filesz // NOI18N
              + ", p_memsz=" + p_memsz // NOI18N
              + ", p_flags=" + p_flags // NOI18N
              + ", p_align=" + p_align; // NOI18N
  }
}

// Program header for ELF64.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Phdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1007,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 986,
 FQN="llvm::ELF::Elf64_Phdr", NM="_ZN4llvm3ELF10Elf64_PhdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_PhdrE")
//</editor-fold>
public static class/*struct*/ Elf64_Phdr {
  public /*uint32_t*/int p_type; // Type of segment
  public /*uint32_t*/int p_flags; // Segment flags
  public long/*uint64_t*/ p_offset; // File offset where segment is located, in bytes
  public long/*uint64_t*/ p_vaddr; // Virtual address of beginning of segment
  public long/*uint64_t*/ p_paddr; // Physical addr of beginning of segment (OS-specific)
  public long/*uint64_t*/ p_filesz; // Num. of bytes in file image of segment (may be zero)
  public long/*uint64_t*/ p_memsz; // Num. of bytes in mem image of segment (may be zero)
  public long/*uint64_t*/ p_align; // Segment alignment constraint
  
  @Override public String toString() {
    return "" + "p_type=" + p_type // NOI18N
              + ", p_flags=" + p_flags // NOI18N
              + ", p_offset=" + p_offset // NOI18N
              + ", p_vaddr=" + p_vaddr // NOI18N
              + ", p_paddr=" + p_paddr // NOI18N
              + ", p_filesz=" + p_filesz // NOI18N
              + ", p_memsz=" + p_memsz // NOI18N
              + ", p_align=" + p_align; // NOI18N
  }
}

// Segment types.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1019,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1207,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum41",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum41")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int PT_NULL = 0; // Unused segment.
  public static final /*uint*/int PT_LOAD = 1; // Loadable segment.
  public static final /*uint*/int PT_DYNAMIC = 2; // Dynamic linking information.
  public static final /*uint*/int PT_INTERP = 3; // Interpreter pathname.
  public static final /*uint*/int PT_NOTE = 4; // Auxiliary information.
  public static final /*uint*/int PT_SHLIB = 5; // Reserved.
  public static final /*uint*/int PT_PHDR = 6; // The program header table itself.
  public static final /*uint*/int PT_TLS = 7; // The thread-local storage template.
  public static final /*uint*/int PT_LOOS = 0x60000000; // Lowest operating system-specific pt entry type.
  public static final /*uint*/int PT_HIOS = 0x6fffffff; // Highest operating system-specific pt entry type.
  public static final /*uint*/int PT_LOPROC = 0x70000000; // Lowest processor-specific program hdr entry type.
  public static final /*uint*/int PT_HIPROC = 0x7fffffff; // Highest processor-specific program hdr entry type.
  
  // x86-64 program header types.
  // These all contain stack unwind tables.
  public static final /*uint*/int PT_GNU_EH_FRAME = 0x6474e550;
  public static final /*uint*/int PT_SUNW_EH_FRAME = 0x6474e550;
  public static final /*uint*/int PT_SUNW_UNWIND = 0x6464e550;
  
  public static final /*uint*/int PT_GNU_STACK = 0x6474e551; // Indicates stack executability.
  public static final /*uint*/int PT_GNU_RELRO = 0x6474e552; // Read-only after relocation.
  
  // ARM program header types.
  public static final /*uint*/int PT_ARM_ARCHEXT = 0x70000000; // Platform architecture compatibility info
  // These all contain stack unwind tables.
  public static final /*uint*/int PT_ARM_EXIDX = 0x70000001;
  public static final /*uint*/int PT_ARM_UNWIND = 0x70000001;
  
  // MIPS program header types.
  public static final /*uint*/int PT_MIPS_REGINFO = 0x70000000; // Register usage information.
  public static final /*uint*/int PT_MIPS_RTPROC = 0x70000001; // Runtime procedure table.
  public static final /*uint*/int PT_MIPS_OPTIONS = 0x70000002; // Options segment.
  public static final /*uint*/int PT_MIPS_ABIFLAGS = 0x70000003; // Abiflags segment.
  
  // AMDGPU program header types.
  public static final /*uint*/int PT_AMDGPU_HSA_LOAD_GLOBAL_PROGRAM = 0x60000000;
  public static final /*uint*/int PT_AMDGPU_HSA_LOAD_GLOBAL_AGENT = 0x60000001;
  public static final /*uint*/int PT_AMDGPU_HSA_LOAD_READONLY_AGENT = 0x60000002;
  public static final /*uint*/int PT_AMDGPU_HSA_LOAD_CODE_AGENT = 0x60000003;
  
  // WebAssembly program header types.
  public static final /*uint*/int PT_WEBASSEMBLY_FUNCTIONS = PT_LOPROC + 0; // Function definitions.
/*}*/

// Segment flag bits.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1065,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1216,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum42",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum42")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
  public static final /*uint*/int PF_X = 1; // Execute
  public static final /*uint*/int PF_W = 2; // Write
  public static final /*uint*/int PF_R = 4; // Read
  public static final /*uint*/int PF_MASKOS = 0x0ff00000; // Bits for operating system-specific semantics.
  public static final /*uint*/int PF_MASKPROC = 0xf0000000/*U*/; // Bits for processor-specific semantics.
/*}*/

// Dynamic table entry for ELF32.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Dyn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1074,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1053,
 FQN="llvm::ELF::Elf32_Dyn", NM="_ZN4llvm3ELF9Elf32_DynE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_DynE")
//</editor-fold>
public static class/*struct*/ Elf32_Dyn {
  public int/*int32_t*/ d_tag; // Type of dynamic table entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Dyn::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1077,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1056,
   FQN="llvm::ELF::Elf32_Dyn::(anonymous)", NM="_ZN4llvm3ELF9Elf32_DynE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf32_DynE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public /*uint32_t*/int d_val; // Integer value of entry.
    public /*uint32_t*/int d_ptr; // Pointer value of entry.
    
    @Override public String toString() {
      return "" + "d_val=" + d_val // NOI18N
                + ", d_ptr=" + d_ptr; // NOI18N
    }
  };
  public Unnamed_union1 d_un = new Unnamed_union1();
  
  @Override public String toString() {
    return "" + "d_tag=" + d_tag // NOI18N
              + ", d_un=" + d_un; // NOI18N
  }
}

// Dynamic table entry for ELF64.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Dyn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1085,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1064,
 FQN="llvm::ELF::Elf64_Dyn", NM="_ZN4llvm3ELF9Elf64_DynE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_DynE")
//</editor-fold>
public static class/*struct*/ Elf64_Dyn {
  public long/*int64_t*/ d_tag; // Type of dynamic table entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Dyn::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1088,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1067,
   FQN="llvm::ELF::Elf64_Dyn::(anonymous)", NM="_ZN4llvm3ELF9Elf64_DynE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF9Elf64_DynE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public long/*uint64_t*/ d_val; // Integer value of entry.
    public long/*uint64_t*/ d_ptr; // Pointer value of entry.
    
    @Override public String toString() {
      return "" + "d_val=" + d_val // NOI18N
                + ", d_ptr=" + d_ptr; // NOI18N
    }
  };
  public Unnamed_union1 d_un = new Unnamed_union1();
  
  @Override public String toString() {
    return "" + "d_tag=" + d_tag // NOI18N
              + ", d_un=" + d_un; // NOI18N
  }
}

// Dynamic table entry tags.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1096,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1246,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum43",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum43")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int DT_NULL = 0; // Marks end of dynamic array.
  public static final /*uint*/int DT_NEEDED = 1; // String table offset of needed library.
  public static final /*uint*/int DT_PLTRELSZ = 2; // Size of relocation entries in PLT.
  public static final /*uint*/int DT_PLTGOT = 3; // Address associated with linkage table.
  public static final /*uint*/int DT_HASH = 4; // Address of symbolic hash table.
  public static final /*uint*/int DT_STRTAB = 5; // Address of dynamic string table.
  public static final /*uint*/int DT_SYMTAB = 6; // Address of dynamic symbol table.
  public static final /*uint*/int DT_RELA = 7; // Address of relocation table (Rela entries).
  public static final /*uint*/int DT_RELASZ = 8; // Size of Rela relocation table.
  public static final /*uint*/int DT_RELAENT = 9; // Size of a Rela relocation entry.
  public static final /*uint*/int DT_STRSZ = 10; // Total size of the string table.
  public static final /*uint*/int DT_SYMENT = 11; // Size of a symbol table entry.
  public static final /*uint*/int DT_INIT = 12; // Address of initialization function.
  public static final /*uint*/int DT_FINI = 13; // Address of termination function.
  public static final /*uint*/int DT_SONAME = 14; // String table offset of a shared objects name.
  public static final /*uint*/int DT_RPATH = 15; // String table offset of library search path.
  public static final /*uint*/int DT_SYMBOLIC = 16; // Changes symbol resolution algorithm.
  public static final /*uint*/int DT_REL = 17; // Address of relocation table (Rel entries).
  public static final /*uint*/int DT_RELSZ = 18; // Size of Rel relocation table.
  public static final /*uint*/int DT_RELENT = 19; // Size of a Rel relocation entry.
  public static final /*uint*/int DT_PLTREL = 20; // Type of relocation entry used for linking.
  public static final /*uint*/int DT_DEBUG = 21; // Reserved for debugger.
  public static final /*uint*/int DT_TEXTREL = 22; // Relocations exist for non-writable segments.
  public static final /*uint*/int DT_JMPREL = 23; // Address of relocations associated with PLT.
  public static final /*uint*/int DT_BIND_NOW = 24; // Process all relocations before execution.
  public static final /*uint*/int DT_INIT_ARRAY = 25; // Pointer to array of initialization functions.
  public static final /*uint*/int DT_FINI_ARRAY = 26; // Pointer to array of termination functions.
  public static final /*uint*/int DT_INIT_ARRAYSZ = 27; // Size of DT_INIT_ARRAY.
  public static final /*uint*/int DT_FINI_ARRAYSZ = 28; // Size of DT_FINI_ARRAY.
  public static final /*uint*/int DT_RUNPATH = 29; // String table offset of lib search path.
  public static final /*uint*/int DT_FLAGS = 30; // Flags.
  public static final /*uint*/int DT_ENCODING = 32; // Values from here to DT_LOOS follow the rules
  // for the interpretation of the d_un union.
  
  public static final /*uint*/int DT_PREINIT_ARRAY = 32; // Pointer to array of preinit functions.
  public static final /*uint*/int DT_PREINIT_ARRAYSZ = 33; // Size of the DT_PREINIT_ARRAY array.
  
  public static final /*uint*/int DT_LOOS = 0x60000000; // Start of environment specific tags.
  public static final /*uint*/int DT_HIOS = 0x6FFFFFFF; // End of environment specific tags.
  public static final /*uint*/int DT_LOPROC = 0x70000000; // Start of processor specific tags.
  public static final /*uint*/int DT_HIPROC = 0x7FFFFFFF; // End of processor specific tags.
  
  public static final /*uint*/int DT_GNU_HASH = 0x6FFFFEF5; // Reference to the GNU hash table.
  public static final /*uint*/int DT_TLSDESC_PLT = 0x6FFFFEF6; // Location of PLT entry for TLS descriptor resolver calls.
  public static final /*uint*/int DT_TLSDESC_GOT = 0x6FFFFEF7; // Location of GOT entry used by TLS descriptor resolver PLT entry.
  public static final /*uint*/int DT_RELACOUNT = 0x6FFFFFF9; // ELF32_Rela count.
  public static final /*uint*/int DT_RELCOUNT = 0x6FFFFFFA; // ELF32_Rel count.
  
  public static final /*uint*/int DT_FLAGS_1 = 0X6FFFFFFB; // Flags_1.
  public static final /*uint*/int DT_VERSYM = 0x6FFFFFF0; // The address of .gnu.version section.
  public static final /*uint*/int DT_VERDEF = 0X6FFFFFFC; // The address of the version definition table.
  public static final /*uint*/int DT_VERDEFNUM = 0X6FFFFFFD; // The number of entries in DT_VERDEF.
  public static final /*uint*/int DT_VERNEED = 0X6FFFFFFE; // The address of the version Dependency table.
  public static final /*uint*/int DT_VERNEEDNUM = 0X6FFFFFFF; // The number of entries in DT_VERNEED.
  
  // Mips specific dynamic table entry tags.
  public static final /*uint*/int DT_MIPS_RLD_VERSION = 0x70000001; // 32 bit version number for runtime
  // linker interface.
  public static final /*uint*/int DT_MIPS_TIME_STAMP = 0x70000002; // Time stamp.
  public static final /*uint*/int DT_MIPS_ICHECKSUM = 0x70000003; // Checksum of external strings
  // and common sizes.
  public static final /*uint*/int DT_MIPS_IVERSION = 0x70000004; // Index of version string
  // in string table.
  public static final /*uint*/int DT_MIPS_FLAGS = 0x70000005; // 32 bits of flags.
  public static final /*uint*/int DT_MIPS_BASE_ADDRESS = 0x70000006; // Base address of the segment.
  public static final /*uint*/int DT_MIPS_MSYM = 0x70000007; // Address of .msym section.
  public static final /*uint*/int DT_MIPS_CONFLICT = 0x70000008; // Address of .conflict section.
  public static final /*uint*/int DT_MIPS_LIBLIST = 0x70000009; // Address of .liblist section.
  public static final /*uint*/int DT_MIPS_LOCAL_GOTNO = 0x7000000a; // Number of local global offset
  // table entries.
  public static final /*uint*/int DT_MIPS_CONFLICTNO = 0x7000000b; // Number of entries
  // in the .conflict section.
  public static final /*uint*/int DT_MIPS_LIBLISTNO = 0x70000010; // Number of entries
  // in the .liblist section.
  public static final /*uint*/int DT_MIPS_SYMTABNO = 0x70000011; // Number of entries
  // in the .dynsym section.
  public static final /*uint*/int DT_MIPS_UNREFEXTNO = 0x70000012; // Index of first external dynamic symbol
  // not referenced locally.
  public static final /*uint*/int DT_MIPS_GOTSYM = 0x70000013; // Index of first dynamic symbol
  // in global offset table.
  public static final /*uint*/int DT_MIPS_HIPAGENO = 0x70000014; // Number of page table entries
  // in global offset table.
  public static final /*uint*/int DT_MIPS_RLD_MAP = 0x70000016; // Address of run time loader map,
  // used for debugging.
  public static final /*uint*/int DT_MIPS_DELTA_CLASS = 0x70000017; // Delta C++ class definition.
  public static final /*uint*/int DT_MIPS_DELTA_CLASS_NO = 0x70000018; // Number of entries
  // in DT_MIPS_DELTA_CLASS.
  public static final /*uint*/int DT_MIPS_DELTA_INSTANCE = 0x70000019; // Delta C++ class instances.
  public static final /*uint*/int DT_MIPS_DELTA_INSTANCE_NO = 0x7000001A; // Number of entries
  // in DT_MIPS_DELTA_INSTANCE.
  public static final /*uint*/int DT_MIPS_DELTA_RELOC = 0x7000001B; // Delta relocations.
  public static final /*uint*/int DT_MIPS_DELTA_RELOC_NO = 0x7000001C; // Number of entries
  // in DT_MIPS_DELTA_RELOC.
  public static final /*uint*/int DT_MIPS_DELTA_SYM = 0x7000001D; // Delta symbols that Delta
  // relocations refer to.
  public static final /*uint*/int DT_MIPS_DELTA_SYM_NO = 0x7000001E; // Number of entries
  // in DT_MIPS_DELTA_SYM.
  public static final /*uint*/int DT_MIPS_DELTA_CLASSSYM = 0x70000020; // Delta symbols that hold
  // class declarations.
  public static final /*uint*/int DT_MIPS_DELTA_CLASSSYM_NO = 0x70000021; // Number of entries
  // in DT_MIPS_DELTA_CLASSSYM.
  public static final /*uint*/int DT_MIPS_CXX_FLAGS = 0x70000022; // Flags indicating information
  // about C++ flavor.
  public static final /*uint*/int DT_MIPS_PIXIE_INIT = 0x70000023; // Pixie information.
  public static final /*uint*/int DT_MIPS_SYMBOL_LIB = 0x70000024; // Address of .MIPS.symlib
  public static final /*uint*/int DT_MIPS_LOCALPAGE_GOTIDX = 0x70000025; // The GOT index of the first PTE
  // for a segment
  public static final /*uint*/int DT_MIPS_LOCAL_GOTIDX = 0x70000026; // The GOT index of the first PTE
  // for a local symbol
  public static final /*uint*/int DT_MIPS_HIDDEN_GOTIDX = 0x70000027; // The GOT index of the first PTE
  // for a hidden symbol
  public static final /*uint*/int DT_MIPS_PROTECTED_GOTIDX = 0x70000028; // The GOT index of the first PTE
  // for a protected symbol
  public static final /*uint*/int DT_MIPS_OPTIONS = 0x70000029; // Address of `.MIPS.options'.
  public static final /*uint*/int DT_MIPS_INTERFACE = 0x7000002A; // Address of `.interface'.
  public static final /*uint*/int DT_MIPS_DYNSTR_ALIGN = 0x7000002B; // Unknown.
  public static final /*uint*/int DT_MIPS_INTERFACE_SIZE = 0x7000002C; // Size of the .interface section.
  public static final /*uint*/int DT_MIPS_RLD_TEXT_RESOLVE_ADDR = 0x7000002D; // Size of rld_text_resolve
  // function stored in the GOT.
  public static final /*uint*/int DT_MIPS_PERF_SUFFIX = 0x7000002E; // Default suffix of DSO to be added
  // by rld on dlopen() calls.
  public static final /*uint*/int DT_MIPS_COMPACT_SIZE = 0x7000002F; // Size of compact relocation
  // section (O32).
  public static final /*uint*/int DT_MIPS_GP_VALUE = 0x70000030; // GP value for auxiliary GOTs.
  public static final /*uint*/int DT_MIPS_AUX_DYNAMIC = 0x70000031; // Address of auxiliary .dynamic.
  public static final /*uint*/int DT_MIPS_PLTGOT = 0x70000032; // Address of the base of the PLTGOT.
  public static final /*uint*/int DT_MIPS_RWPLT = 0x70000034; // Points to the base
  // of a writable PLT.
  public static final /*uint*/int DT_MIPS_RLD_MAP_REL = 0x70000035; // Relative offset of run time loader
  // map, used for debugging.
  
  // Sun machine-independent extensions.
  public static final /*uint*/int DT_AUXILIARY = 0x7FFFFFFD; // Shared object to load before self
  public static final /*uint*/int DT_FILTER = 0x7FFFFFFF; // Shared object to get values from
/*}*/

// DT_FLAGS values.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1234,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1271,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum44",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum44")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int DF_ORIGIN = 0x01; // The object may reference $ORIGIN.
  public static final /*uint*/int DF_SYMBOLIC = 0x02; // Search the shared lib before searching the exe.
  public static final /*uint*/int DF_TEXTREL = 0x04; // Relocations may modify a non-writable segment.
  public static final /*uint*/int DF_BIND_NOW = 0x08; // Process all relocations on load.
  public static final /*uint*/int DF_STATIC_TLS = 0x10; // Reject attempts to load dynamically.
/*}*/

// State flags selectable in the `d_un.d_val' element of the DT_FLAGS_1 entry.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1243,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1277,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum45",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum45")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int DF_1_NOW = 0x00000001; // Set RTLD_NOW for this object.
  public static final /*uint*/int DF_1_GLOBAL = 0x00000002; // Set RTLD_GLOBAL for this object.
  public static final /*uint*/int DF_1_GROUP = 0x00000004; // Set RTLD_GROUP for this object.
  public static final /*uint*/int DF_1_NODELETE = 0x00000008; // Set RTLD_NODELETE for this object.
  public static final /*uint*/int DF_1_LOADFLTR = 0x00000010; // Trigger filtee loading at runtime.
  public static final /*uint*/int DF_1_INITFIRST = 0x00000020; // Set RTLD_INITFIRST for this object.
  public static final /*uint*/int DF_1_NOOPEN = 0x00000040; // Set RTLD_NOOPEN for this object.
  public static final /*uint*/int DF_1_ORIGIN = 0x00000080; // $ORIGIN must be handled.
  public static final /*uint*/int DF_1_DIRECT = 0x00000100; // Direct binding enabled.
  public static final /*uint*/int DF_1_TRANS = 0x00000200;
  public static final /*uint*/int DF_1_INTERPOSE = 0x00000400; // Object is used to interpose.
  public static final /*uint*/int DF_1_NODEFLIB = 0x00000800; // Ignore default lib search path.
  public static final /*uint*/int DF_1_NODUMP = 0x00001000; // Object can't be dldump'ed.
  public static final /*uint*/int DF_1_CONFALT = 0x00002000; // Configuration alternative created.
  public static final /*uint*/int DF_1_ENDFILTEE = 0x00004000; // Filtee terminates filters search.
  public static final /*uint*/int DF_1_DISPRELDNE = 0x00008000; // Disp reloc applied at build time.
  public static final /*uint*/int DF_1_DISPRELPND = 0x00010000; // Disp reloc applied at run-time.
  public static final /*uint*/int DF_1_NODIRECT = 0x00020000; // Object has no-direct binding.
  public static final /*uint*/int DF_1_IGNMULDEF = 0x00040000;
  public static final /*uint*/int DF_1_NOKSYMS = 0x00080000;
  public static final /*uint*/int DF_1_NOHDR = 0x00100000;
  public static final /*uint*/int DF_1_EDITED = 0x00200000; // Object is modified after built.
  public static final /*uint*/int DF_1_NORELOC = 0x00400000;
  public static final /*uint*/int DF_1_SYMINTPOSE = 0x00800000; // Object has individual interposers.
  public static final /*uint*/int DF_1_GLOBAUDIT = 0x01000000; // Global auditing required.
  public static final /*uint*/int DF_1_SINGLETON = 0x02000000; // Singleton symbols are used.
/*}*/

// DT_MIPS_FLAGS values.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1273,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1284,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum46",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum46")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int RHF_NONE = 0x00000000; // No flags.
  public static final /*uint*/int RHF_QUICKSTART = 0x00000001; // Uses shortcut pointers.
  public static final /*uint*/int RHF_NOTPOT = 0x00000002; // Hash size is not a power of two.
  public static final /*uint*/int RHS_NO_LIBRARY_REPLACEMENT = 0x00000004; // Ignore LD_LIBRARY_PATH.
  public static final /*uint*/int RHF_NO_MOVE = 0x00000008; // DSO address may not be relocated.
  public static final /*uint*/int RHF_SGI_ONLY = 0x00000010; // SGI specific features.
  public static final /*uint*/int RHF_GUARANTEE_INIT = 0x00000020; // Guarantee that .init will finish
  // executing before any non-init
  // code in DSO is called.
  public static final /*uint*/int RHF_DELTA_C_PLUS_PLUS = 0x00000040; // Contains Delta C++ code.
  public static final /*uint*/int RHF_GUARANTEE_START_INIT = 0x00000080; // Guarantee that .init will start
  // executing before any non-init
  // code in DSO is called.
  public static final /*uint*/int RHF_PIXIE = 0x00000100; // Generated by pixie.
  public static final /*uint*/int RHF_DEFAULT_DELAY_LOAD = 0x00000200; // Delay-load DSO by default.
  public static final /*uint*/int RHF_REQUICKSTART = 0x00000400; // Object may be requickstarted
  public static final /*uint*/int RHF_REQUICKSTARTED = 0x00000800; // Object has been requickstarted
  public static final /*uint*/int RHF_CORD = 0x00001000; // Generated by cord.
  public static final /*uint*/int RHF_NO_UNRES_UNDEF = 0x00002000; // Object contains no unresolved
  // undef symbols.
  public static final /*uint*/int RHF_RLD_ORDER_SAFE = 0x00004000; // Symbol table is in a safe order.
/*}*/

// ElfXX_VerDef structure version (GNU versioning)
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1298,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", old_line = 1292,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum47",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum47")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VER_DEF_NONE = 0;
  public static final /*uint*/int VER_DEF_CURRENT = 1;
/*}*/

// VerDef Flags (ElfXX_VerDef::vd_flags)
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1304,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum48",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum48")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VER_FLG_BASE = 0x1;
  public static final /*uint*/int VER_FLG_WEAK = 0x2;
  public static final /*uint*/int VER_FLG_INFO = 0x4;
/*}*/

// Special constants for the version table. (SHT_GNU_versym/.gnu.version)
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1311,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum49",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum49")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VER_NDX_LOCAL = 0; // Unversioned local symbol
  public static final /*uint*/int VER_NDX_GLOBAL = 1; // Unversioned global symbol
  public static final /*uint*/int VERSYM_VERSION = 0x7fff; // Version Index mask
  public static final /*uint*/int VERSYM_HIDDEN = 0x8000; // Hidden bit (non-default version)
/*}*/

// ElfXX_VerNeed structure version (GNU versioning)
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1319,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum50",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum50")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VER_NEED_NONE = 0;
  public static final /*uint*/int VER_NEED_CURRENT = 1;
/*}*/

// SHT_NOTE section types
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1325,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum51",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum51")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int NT_GNU_BUILD_ID = 3;
/*}*/

// Compressed section header for ELF32.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf32_Chdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1330,
 FQN="llvm::ELF::Elf32_Chdr", NM="_ZN4llvm3ELF10Elf32_ChdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf32_ChdrE")
//</editor-fold>
public static class/*struct*/ Elf32_Chdr {
  public /*uint32_t*/int ch_type;
  public /*uint32_t*/int ch_size;
  public /*uint32_t*/int ch_addralign;
  
  @Override public String toString() {
    return "" + "ch_type=" + ch_type // NOI18N
              + ", ch_size=" + ch_size // NOI18N
              + ", ch_addralign=" + ch_addralign; // NOI18N
  }
}

// Compressed section header for ELF64.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::Elf64_Chdr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1337,
 FQN="llvm::ELF::Elf64_Chdr", NM="_ZN4llvm3ELF10Elf64_ChdrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELF10Elf64_ChdrE")
//</editor-fold>
public static class/*struct*/ Elf64_Chdr {
  public /*uint32_t*/int ch_type;
  public /*uint32_t*/int ch_reserved;
  public long/*uint64_t*/ ch_size;
  public long/*uint64_t*/ ch_addralign;
  
  @Override public String toString() {
    return "" + "ch_type=" + ch_type // NOI18N
              + ", ch_reserved=" + ch_reserved // NOI18N
              + ", ch_size=" + ch_size // NOI18N
              + ", ch_addralign=" + ch_addralign; // NOI18N
  }
}

// Legal values for ch_type field of compressed section header.
//<editor-fold defaultstate="collapsed" desc="llvm::ELF::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ELF.h", line = 1345,
 FQN="llvm::ELF::(anonymous)", NM="_ZN4llvm3ELFE_ELF_h_Unnamed_enum52",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm3ELFE_ELF_h_Unnamed_enum52")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ELFCOMPRESS_ZLIB = 1; // ZLIB/DEFLATE algorithm.
  public static final /*uint*/int ELFCOMPRESS_LOOS = 0x60000000; // Start of OS-specific.
  public static final /*uint*/int ELFCOMPRESS_HIOS = 0x6fffffff; // End of OS-specific.
  public static final /*uint*/int ELFCOMPRESS_LOPROC = 0x70000000; // Start of processor-specific.
  public static final /*uint*/int ELFCOMPRESS_HIPROC = 0x7fffffff; // End of processor-specific.
/*}*/
} // END OF class ELF
