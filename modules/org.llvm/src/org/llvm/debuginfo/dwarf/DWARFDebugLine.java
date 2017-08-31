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

package org.llvm.debuginfo.dwarf;

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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 24,
 FQN="llvm::DWARFDebugLine", NM="_ZN4llvm14DWARFDebugLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLineE")
//</editor-fold>
public class DWARFDebugLine implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::DWARFDebugLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 26,
   FQN="llvm::DWARFDebugLine::DWARFDebugLine", NM="_ZN4llvm14DWARFDebugLineC1EPKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS3_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLineC1EPKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS3_EEEE")
  //</editor-fold>
  public DWARFDebugLine(/*const*/DenseMapULongType<std.pairUCharLong> /*P*/ LineInfoRelocMap) {
    // : RelocMap(LineInfoRelocMap), LineTableMap() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::FileNameEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 27,
   FQN="llvm::DWARFDebugLine::FileNameEntry", NM="_ZN4llvm14DWARFDebugLine13FileNameEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine13FileNameEntryE")
  //</editor-fold>
  public static class/*struct*/ FileNameEntry {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::FileNameEntry::FileNameEntry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 28,
     FQN="llvm::DWARFDebugLine::FileNameEntry::FileNameEntry", NM="_ZN4llvm14DWARFDebugLine13FileNameEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine13FileNameEntryC1Ev")
    //</editor-fold>
    public FileNameEntry() {
      // : Name(null), DirIdx(0), ModTime(0), Length(0) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    public /*const*/char$ptr/*char P*/ Name;
    public long/*uint64_t*/ DirIdx;
    public long/*uint64_t*/ ModTime;
    public long/*uint64_t*/ Length;
    
    @Override public String toString() {
      return "" + "Name=" + Name // NOI18N
                + ", DirIdx=" + DirIdx // NOI18N
                + ", ModTime=" + ModTime // NOI18N
                + ", Length=" + Length; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 36,
   FQN="llvm::DWARFDebugLine::Prologue", NM="_ZN4llvm14DWARFDebugLine8PrologueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8PrologueE")
  //</editor-fold>
  public static class/*struct*/ Prologue implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::Prologue">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 37,
     FQN="llvm::DWARFDebugLine::Prologue::Prologue", NM="_ZN4llvm14DWARFDebugLine8PrologueC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8PrologueC1Ev")
    //</editor-fold>
    public Prologue() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    // The size in bytes of the statement information for this compilation unit
    // (not including the total_length field itself).
    public long/*uint64_t*/ TotalLength;
    // Version identifier for the statement information format.
    public /*uint16_t*/char Version;
    // The number of bytes following the prologue_length field to the beginning
    // of the first byte of the statement program itself.
    public long/*uint64_t*/ PrologueLength;
    // The size in bytes of the smallest target machine instruction. Statement
    // program opcodes that alter the address register first multiply their
    // operands by this value.
    public byte/*uint8_t*/ MinInstLength;
    // The maximum number of individual operations that may be encoded in an
    // instruction.
    public byte/*uint8_t*/ MaxOpsPerInst;
    // The initial value of theis_stmtregister.
    public byte/*uint8_t*/ DefaultIsStmt;
    // This parameter affects the meaning of the special opcodes. See below.
    public byte/*int8_t*/ LineBase;
    // This parameter affects the meaning of the special opcodes. See below.
    public byte/*uint8_t*/ LineRange;
    // The number assigned to the first special opcode.
    public byte/*uint8_t*/ OpcodeBase;
    public std.vectorUChar StandardOpcodeLengths;
    public vectorCharPtr IncludeDirectories;
    public std.vector<FileNameEntry> FileNames;
    
    public boolean IsDWARF64;
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::sizeofTotalLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 67,
     FQN="llvm::DWARFDebugLine::Prologue::sizeofTotalLength", NM="_ZNK4llvm14DWARFDebugLine8Prologue17sizeofTotalLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue17sizeofTotalLengthEv")
    //</editor-fold>
    public /*uint32_t*/int sizeofTotalLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::sizeofPrologueLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 70,
     FQN="llvm::DWARFDebugLine::Prologue::sizeofPrologueLength", NM="_ZNK4llvm14DWARFDebugLine8Prologue20sizeofPrologueLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue20sizeofPrologueLengthEv")
    //</editor-fold>
    public /*uint32_t*/int sizeofPrologueLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    // Length of the prologue in bytes.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::getLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 75,
     FQN="llvm::DWARFDebugLine::Prologue::getLength", NM="_ZNK4llvm14DWARFDebugLine8Prologue9getLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue9getLengthEv")
    //</editor-fold>
    public /*uint32_t*/int getLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    // Length of the line table data in bytes (not including the prologue).
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::getStatementTableLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 80,
     FQN="llvm::DWARFDebugLine::Prologue::getStatementTableLength", NM="_ZNK4llvm14DWARFDebugLine8Prologue23getStatementTableLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue23getStatementTableLengthEv")
    //</editor-fold>
    public /*uint32_t*/int getStatementTableLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::getMaxLineIncrementForSpecialOpcode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 83,
     FQN="llvm::DWARFDebugLine::Prologue::getMaxLineIncrementForSpecialOpcode", NM="_ZNK4llvm14DWARFDebugLine8Prologue35getMaxLineIncrementForSpecialOpcodeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue35getMaxLineIncrementForSpecialOpcodeEv")
    //</editor-fold>
    public int/*int32_t*/ getMaxLineIncrementForSpecialOpcode() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::clear">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 87,
     FQN="llvm::DWARFDebugLine::Prologue::clear", NM="_ZN4llvm14DWARFDebugLine8Prologue5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8Prologue5clearEv")
    //</editor-fold>
    public void clear() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 88,
     FQN="llvm::DWARFDebugLine::Prologue::dump", NM="_ZNK4llvm14DWARFDebugLine8Prologue4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Prologue4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::parse">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 89,
     FQN="llvm::DWARFDebugLine::Prologue::parse", NM="_ZN4llvm14DWARFDebugLine8Prologue5parseENS_13DataExtractorEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8Prologue5parseENS_13DataExtractorEPj")
    //</editor-fold>
    public boolean parse(DataExtractor debug_line_data, /*uint32_t P*/uint$ptr offset_ptr) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Prologue::~Prologue">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 36,
     FQN="llvm::DWARFDebugLine::Prologue::~Prologue", NM="_ZN4llvm14DWARFDebugLine8PrologueD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8PrologueD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "TotalLength=" + TotalLength // NOI18N
                + ", Version=" + $ushort2uint(Version) // NOI18N
                + ", PrologueLength=" + PrologueLength // NOI18N
                + ", MinInstLength=" + $uchar2uint(MinInstLength) // NOI18N
                + ", MaxOpsPerInst=" + $uchar2uint(MaxOpsPerInst) // NOI18N
                + ", DefaultIsStmt=" + $uchar2uint(DefaultIsStmt) // NOI18N
                + ", LineBase=" + LineBase // NOI18N
                + ", LineRange=" + $uchar2uint(LineRange) // NOI18N
                + ", OpcodeBase=" + $uchar2uint(OpcodeBase) // NOI18N
                + ", StandardOpcodeLengths=" + StandardOpcodeLengths // NOI18N
                + ", IncludeDirectories=" + IncludeDirectories // NOI18N
                + ", FileNames=" + FileNames // NOI18N
                + ", IsDWARF64=" + IsDWARF64; // NOI18N
    }
  };
  
  // Standard .debug_line state machine structure.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 93,
   FQN="llvm::DWARFDebugLine::Row", NM="_ZN4llvm14DWARFDebugLine3RowE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3RowE")
  //</editor-fold>
  public static class/*struct*/ Row {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::Row">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 94,
     FQN="llvm::DWARFDebugLine::Row::Row", NM="_ZN4llvm14DWARFDebugLine3RowC1Eb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3RowC1Eb")
    //</editor-fold>
    public /*explicit*/ Row() {
      this(false);
    }
    public /*explicit*/ Row(boolean default_is_stmt/*= false*/) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    /// Called after a row is appended to the matrix.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::postAppend">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 97,
     FQN="llvm::DWARFDebugLine::Row::postAppend", NM="_ZN4llvm14DWARFDebugLine3Row10postAppendEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3Row10postAppendEv")
    //</editor-fold>
    public void postAppend() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::reset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 98,
     FQN="llvm::DWARFDebugLine::Row::reset", NM="_ZN4llvm14DWARFDebugLine3Row5resetEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3Row5resetEb")
    //</editor-fold>
    public void reset(boolean default_is_stmt) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 99,
     FQN="llvm::DWARFDebugLine::Row::dump", NM="_ZNK4llvm14DWARFDebugLine3Row4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine3Row4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::orderByAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 101,
     FQN="llvm::DWARFDebugLine::Row::orderByAddress", NM="_ZN4llvm14DWARFDebugLine3Row14orderByAddressERKS1_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3Row14orderByAddressERKS1_S3_")
    //</editor-fold>
    public static boolean orderByAddress(final /*const*/ Row /*&*/ LHS, final /*const*/ Row /*&*/ RHS) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    // The program-counter value corresponding to a machine instruction
    // generated by the compiler.
    public long/*uint64_t*/ Address;
    // An unsigned integer indicating a source line number. Lines are numbered
    // beginning at 1. The compiler may emit the value 0 in cases where an
    // instruction cannot be attributed to any source line.
    public /*uint32_t*/int Line;
    // An unsigned integer indicating a column number within a source line.
    // Columns are numbered beginning at 1. The value 0 is reserved to indicate
    // that a statement begins at the 'left edge' of the line.
    public /*uint16_t*/char Column;
    // An unsigned integer indicating the identity of the source file
    // corresponding to a machine instruction.
    public /*uint16_t*/char File;
    // An unsigned integer whose value encodes the applicable instruction set
    // architecture for the current instruction.
    public byte/*uint8_t*/ Isa;
    // An unsigned integer representing the DWARF path discriminator value
    // for this location.
    public /*uint32_t*/int Discriminator;
    // A boolean indicating that the current instruction is the beginning of a
    // statement.
    public /*JBIT uint8_t*/ boolean IsStmt /*: 1*/;
    public /*JBIT uint8_t*/ boolean BasicBlock /*: 1*/;
    public /*JBIT uint8_t*/ boolean EndSequence /*: 1*/;
    public /*JBIT uint8_t*/ boolean PrologueEnd /*: 1*/;
    public /*JBIT uint8_t*/ boolean EpilogueBegin /*: 1*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::Row">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 93,
     FQN="llvm::DWARFDebugLine::Row::Row", NM="_ZN4llvm14DWARFDebugLine3RowC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3RowC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Row(final /*const*/ Row /*&*/ $Prm0) {
      // : Address(.Address), Line(.Line), Column(.Column), File(.File), Isa(.Isa), Discriminator(.Discriminator), IsStmt(.IsStmt), BasicBlock(.BasicBlock), EndSequence(.EndSequence), PrologueEnd(.PrologueEnd), EpilogueBegin(.EpilogueBegin) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Row::Row">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 93,
     FQN="llvm::DWARFDebugLine::Row::Row", NM="_ZN4llvm14DWARFDebugLine3RowC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine3RowC1EOS1_")
    //</editor-fold>
    public /*inline*/ Row(JD$Move _dparam, final Row /*&&*/$Prm0) {
      // : Address(static_cast<Row &&>().Address), Line(static_cast<Row &&>().Line), Column(static_cast<Row &&>().Column), File(static_cast<Row &&>().File), Isa(static_cast<Row &&>().Isa), Discriminator(static_cast<Row &&>().Discriminator), IsStmt(static_cast<Row &&>().IsStmt), BasicBlock(static_cast<Row &&>().BasicBlock), EndSequence(static_cast<Row &&>().EndSequence), PrologueEnd(static_cast<Row &&>().PrologueEnd), EpilogueBegin(static_cast<Row &&>().EpilogueBegin) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Address=" + Address // NOI18N
                + ", Line=" + Line // NOI18N
                + ", Column=" + $ushort2uint(Column) // NOI18N
                + ", File=" + $ushort2uint(File) // NOI18N
                + ", Isa=" + $uchar2uint(Isa) // NOI18N
                + ", Discriminator=" + Discriminator // NOI18N
                + ", IsStmt=" + IsStmt // NOI18N
                + ", BasicBlock=" + BasicBlock // NOI18N
                + ", EndSequence=" + EndSequence // NOI18N
                + ", PrologueEnd=" + PrologueEnd // NOI18N
                + ", EpilogueBegin=" + EpilogueBegin; // NOI18N
    }
  };
  
  // Represents a series of contiguous machine instructions. Line table for each
  // compilation unit may consist of multiple sequences, which are not
  // guaranteed to be in the order of ascending instruction address.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 148,
   FQN="llvm::DWARFDebugLine::Sequence", NM="_ZN4llvm14DWARFDebugLine8SequenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8SequenceE")
  //</editor-fold>
  public static class/*struct*/ Sequence {
    // Sequence describes instructions at address range [LowPC, HighPC)
    // and is described by line table rows [FirstRowIndex, LastRowIndex).
    public long/*uint64_t*/ LowPC;
    public long/*uint64_t*/ HighPC;
    public /*uint*/int FirstRowIndex;
    public /*uint*/int LastRowIndex;
    public boolean Empty;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::Sequence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 157,
     FQN="llvm::DWARFDebugLine::Sequence::Sequence", NM="_ZN4llvm14DWARFDebugLine8SequenceC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8SequenceC1Ev")
    //</editor-fold>
    public Sequence() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::reset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 158,
     FQN="llvm::DWARFDebugLine::Sequence::reset", NM="_ZN4llvm14DWARFDebugLine8Sequence5resetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8Sequence5resetEv")
    //</editor-fold>
    public void reset() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::orderByLowPC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 160,
     FQN="llvm::DWARFDebugLine::Sequence::orderByLowPC", NM="_ZN4llvm14DWARFDebugLine8Sequence12orderByLowPCERKS1_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8Sequence12orderByLowPCERKS1_S3_")
    //</editor-fold>
    public static boolean orderByLowPC(final /*const*/ Sequence /*&*/ LHS, final /*const*/ Sequence /*&*/ RHS) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::isValid">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 163,
     FQN="llvm::DWARFDebugLine::Sequence::isValid", NM="_ZNK4llvm14DWARFDebugLine8Sequence7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Sequence7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::containsPC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 166,
     FQN="llvm::DWARFDebugLine::Sequence::containsPC", NM="_ZNK4llvm14DWARFDebugLine8Sequence10containsPCEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine8Sequence10containsPCEy")
    //</editor-fold>
    public boolean containsPC(long/*uint64_t*/ pc) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::Sequence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 148,
     FQN="llvm::DWARFDebugLine::Sequence::Sequence", NM="_ZN4llvm14DWARFDebugLine8SequenceC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8SequenceC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Sequence(final /*const*/ Sequence /*&*/ $Prm0) {
      // : LowPC(.LowPC), HighPC(.HighPC), FirstRowIndex(.FirstRowIndex), LastRowIndex(.LastRowIndex), Empty(.Empty) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::Sequence::Sequence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 148,
     FQN="llvm::DWARFDebugLine::Sequence::Sequence", NM="_ZN4llvm14DWARFDebugLine8SequenceC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine8SequenceC1EOS1_")
    //</editor-fold>
    public /*inline*/ Sequence(JD$Move _dparam, final Sequence /*&&*/$Prm0) {
      // : LowPC(static_cast<Sequence &&>().LowPC), HighPC(static_cast<Sequence &&>().HighPC), FirstRowIndex(static_cast<Sequence &&>().FirstRowIndex), LastRowIndex(static_cast<Sequence &&>().LastRowIndex), Empty(static_cast<Sequence &&>().Empty) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "LowPC=" + LowPC // NOI18N
                + ", HighPC=" + HighPC // NOI18N
                + ", FirstRowIndex=" + FirstRowIndex // NOI18N
                + ", LastRowIndex=" + LastRowIndex // NOI18N
                + ", Empty=" + Empty; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 171,
   FQN="llvm::DWARFDebugLine::LineTable", NM="_ZN4llvm14DWARFDebugLine9LineTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTableE")
  //</editor-fold>
  public static class/*struct*/ LineTable implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::LineTable">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 172,
     FQN="llvm::DWARFDebugLine::LineTable::LineTable", NM="_ZN4llvm14DWARFDebugLine9LineTableC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTableC1Ev")
    //</editor-fold>
    public LineTable() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    // Represents an invalid row
    public /*const*//*uint32_t*/int UnknownRowIndex/* = (4294967295U)*/;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::appendRow">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 177,
     FQN="llvm::DWARFDebugLine::LineTable::appendRow", NM="_ZN4llvm14DWARFDebugLine9LineTable9appendRowERKNS0_3RowE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTable9appendRowERKNS0_3RowE")
    //</editor-fold>
    public void appendRow(final /*const*/ DWARFDebugLine.Row /*&*/ R) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::appendSequence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 180,
     FQN="llvm::DWARFDebugLine::LineTable::appendSequence", NM="_ZN4llvm14DWARFDebugLine9LineTable14appendSequenceERKNS0_8SequenceE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTable14appendSequenceERKNS0_8SequenceE")
    //</editor-fold>
    public void appendSequence(final /*const*/ DWARFDebugLine.Sequence /*&*/ S) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    // Returns the index of the row with file/line info for a given address,
    // or UnknownRowIndex if there is no such row.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::lookupAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 186,
     FQN="llvm::DWARFDebugLine::LineTable::lookupAddress", NM="_ZNK4llvm14DWARFDebugLine9LineTable13lookupAddressEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable13lookupAddressEy")
    //</editor-fold>
    public /*uint32_t*/int lookupAddress(long/*uint64_t*/ address) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::lookupAddressRange">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 188,
     FQN="llvm::DWARFDebugLine::LineTable::lookupAddressRange", NM="_ZNK4llvm14DWARFDebugLine9LineTable18lookupAddressRangeEyyRSt6vectorIjSaIjEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable18lookupAddressRangeEyyRSt6vectorIjSaIjEE")
    //</editor-fold>
    public boolean lookupAddressRange(long/*uint64_t*/ address, long/*uint64_t*/ size, 
                      final std.vectorUInt/*&*/ result) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    // Extracts filename by its index in filename table in prologue.
    // Returns true on success.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::getFileNameByIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 193,
     FQN="llvm::DWARFDebugLine::LineTable::getFileNameByIndex", NM="_ZNK4llvm14DWARFDebugLine9LineTable18getFileNameByIndexEyPKcNS_19DILineInfoSpecifier16FileLineInfoKindERSs",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable18getFileNameByIndexEyPKcNS_19DILineInfoSpecifier16FileLineInfoKindERSs")
    //</editor-fold>
    public boolean getFileNameByIndex(long/*uint64_t*/ FileIndex, /*const*/char$ptr/*char P*/ CompDir, 
                      DILineInfoSpecifier.FileLineInfoKind Kind, 
                      final std.string/*&*/ Result) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    // Fills the Result argument with the file and line information
    // corresponding to Address. Returns true on success.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::getFileLineInfoForAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 199,
     FQN="llvm::DWARFDebugLine::LineTable::getFileLineInfoForAddress", NM="_ZNK4llvm14DWARFDebugLine9LineTable25getFileLineInfoForAddressEyPKcNS_19DILineInfoSpecifier16FileLineInfoKindERNS_10DILineInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable25getFileLineInfoForAddressEyPKcNS_19DILineInfoSpecifier16FileLineInfoKindERNS_10DILineInfoE")
    //</editor-fold>
    public boolean getFileLineInfoForAddress(long/*uint64_t*/ Address, /*const*/char$ptr/*char P*/ CompDir, 
                             DILineInfoSpecifier.FileLineInfoKind Kind, 
                             final DILineInfo /*&*/ Result) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 203,
     FQN="llvm::DWARFDebugLine::LineTable::dump", NM="_ZNK4llvm14DWARFDebugLine9LineTable4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::clear">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 204,
     FQN="llvm::DWARFDebugLine::LineTable::clear", NM="_ZN4llvm14DWARFDebugLine9LineTable5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTable5clearEv")
    //</editor-fold>
    public void clear() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    /// Parse prologue and all rows.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::parse">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 207,
     FQN="llvm::DWARFDebugLine::LineTable::parse", NM="_ZN4llvm14DWARFDebugLine9LineTable5parseENS_13DataExtractorEPKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS5_EEEEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTable5parseENS_13DataExtractorEPKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS5_EEEEPj")
    //</editor-fold>
    public boolean parse(DataExtractor debug_line_data, /*const*/DenseMapULongType<std.pairUCharLong> /*P*/ RMap, 
         /*uint32_t P*/uint$ptr offset_ptr) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    public  Prologue Prologue;
    // JAVA: typedef std::vector<Row> RowVector
//    public final class RowVector extends std.vector<Row>{ };
    // JAVA: typedef RowVector::const_iterator RowIter
//    public final class RowIter extends std.vector.iterator</*const*/ Row /*P*/ >{ };
    // JAVA: typedef std::vector<Sequence> SequenceVector
//    public final class SequenceVector extends std.vector<Sequence>{ };
    // JAVA: typedef SequenceVector::const_iterator SequenceIter
//    public final class SequenceIter extends std.vector.iterator</*const*/ Sequence /*P*/ >{ };
    public std.vector<Row> Rows;
    public std.vector<Sequence> Sequences;
  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::findRowInSeq">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 219,
     FQN="llvm::DWARFDebugLine::LineTable::findRowInSeq", NM="_ZNK4llvm14DWARFDebugLine9LineTable12findRowInSeqERKNS0_8SequenceEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine9LineTable12findRowInSeqERKNS0_8SequenceEy")
    //</editor-fold>
    private /*uint32_t*/int findRowInSeq(final /*const*/ DWARFDebugLine.Sequence /*&*/ seq, 
                long/*uint64_t*/ address) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::LineTable::~LineTable">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 171,
     FQN="llvm::DWARFDebugLine::LineTable::~LineTable", NM="_ZN4llvm14DWARFDebugLine9LineTableD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine9LineTableD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "UnknownRowIndex=" + UnknownRowIndex // NOI18N
                + ", Prologue=" + Prologue // NOI18N
                + ", Rows=" + Rows // NOI18N
                + ", Sequences=" + Sequences; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::getLineTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 223,
   FQN="llvm::DWARFDebugLine::getLineTable", NM="_ZNK4llvm14DWARFDebugLine12getLineTableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFDebugLine12getLineTableEj")
  //</editor-fold>
  public /*const*/ LineTable /*P*/ getLineTable(/*uint32_t*/int offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::getOrParseLineTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 224,
   FQN="llvm::DWARFDebugLine::getOrParseLineTable", NM="_ZN4llvm14DWARFDebugLine19getOrParseLineTableENS_13DataExtractorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine19getOrParseLineTableENS_13DataExtractorEj")
  //</editor-fold>
  public /*const*/ LineTable /*P*/ getOrParseLineTable(DataExtractor debug_line_data, 
                     /*uint32_t*/int offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::ParsingState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 228,
   FQN="llvm::DWARFDebugLine::ParsingState", NM="_ZN4llvm14DWARFDebugLine12ParsingStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine12ParsingStateE")
  //</editor-fold>
  private static class/*struct*/ ParsingState {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::ParsingState::ParsingState">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 229,
     FQN="llvm::DWARFDebugLine::ParsingState::ParsingState", NM="_ZN4llvm14DWARFDebugLine12ParsingStateC1EPNS0_9LineTableE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine12ParsingStateC1EPNS0_9LineTableE")
    //</editor-fold>
    public ParsingState( LineTable /*P*/ LT) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::ParsingState::resetRowAndSequence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 231,
     FQN="llvm::DWARFDebugLine::ParsingState::resetRowAndSequence", NM="_ZN4llvm14DWARFDebugLine12ParsingState19resetRowAndSequenceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine12ParsingState19resetRowAndSequenceEv")
    //</editor-fold>
    public void resetRowAndSequence() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::ParsingState::appendRowToMatrix">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 232,
     FQN="llvm::DWARFDebugLine::ParsingState::appendRowToMatrix", NM="_ZN4llvm14DWARFDebugLine12ParsingState17appendRowToMatrixEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLine12ParsingState17appendRowToMatrixEj")
    //</editor-fold>
    public void appendRowToMatrix(/*uint32_t*/int offset) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    // Line table we're currently parsing.
    public  LineTable /*P*/ LineTable;
    // The row number that starts at zero for the prologue, and increases for
    // each row added to the matrix.
    public /*uint*/int RowNumber;
    public  Row Row;
    public  Sequence Sequence;
    
    @Override public String toString() {
      return "" + "LineTable=" + LineTable // NOI18N
                + ", RowNumber=" + RowNumber // NOI18N
                + ", Row=" + Row // NOI18N
                + ", Sequence=" + Sequence; // NOI18N
    }
  };
  
  // JAVA: typedef std::map<uint32_t, LineTable> LineTableMapTy
//  public final class LineTableMapTy extends std.mapUIntType<LineTable>{ };
  // JAVA: typedef LineTableMapTy::iterator LineTableIter
//  public final class LineTableIter extends std.mapUIntType.iterator<LineTable>{ };
  // JAVA: typedef LineTableMapTy::const_iterator LineTableConstIter
//  public final class LineTableConstIter extends std.mapUIntType<LineTable>{ };
  
  private /*const*/DenseMapULongType<std.pairUCharLong> /*P*/ RelocMap;
  private std.mapUIntType<LineTable> LineTableMap;
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLine::~DWARFDebugLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLine.h", line = 24,
   FQN="llvm::DWARFDebugLine::~DWARFDebugLine", NM="_ZN4llvm14DWARFDebugLineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFDebugLineD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RelocMap=" + RelocMap // NOI18N
              + ", LineTableMap=" + LineTableMap; // NOI18N
  }
}
