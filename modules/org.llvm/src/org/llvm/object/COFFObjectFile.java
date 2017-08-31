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
import org.llvm.mc.*;
import org.llvm.support.sys.*;

//<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 622,
 FQN="llvm::object::COFFObjectFile", NM="_ZN4llvm6object14COFFObjectFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFileE")
//</editor-fold>
public class COFFObjectFile extends /*public*/ ObjectFile implements Destructors.ClassWithDestructor {
/*private:*/
  /*friend  class ImportDirectoryEntryRef*/
  /*friend  class ExportDirectoryEntryRef*/
  private /*const*/ coff_file_header /*P*/ COFFHeader;
  private /*const*/ coff_bigobj_file_header /*P*/ COFFBigObjHeader;
  private /*const*/ pe32_header /*P*/ PE32Header;
  private /*const*/ pe32plus_header /*P*/ PE32PlusHeader;
  private /*const*/ data_directory /*P*/ DataDirectory;
  private /*const*/ coff_section /*P*/ SectionTable;
  private /*const*/ coff_symbol<llvm.support.ulittle16_t> /*P*/ SymbolTable16;
  private /*const*/ coff_symbol<llvm.support.ulittle32_t> /*P*/ SymbolTable32;
  private /*const*/char$ptr/*char P*/ StringTable;
  private /*uint32_t*/int StringTableSize;
  private /*const*/ import_directory_table_entry /*P*/ ImportDirectory;
  private /*const*/ delay_import_directory_table_entry /*P*/ DelayImportDirectory;
  private /*uint32_t*/int NumberOfDelayImportDirectory;
  private /*const*/ export_directory_table_entry /*P*/ ExportDirectory;
  private /*const*/ coff_base_reloc_block_header /*P*/ BaseRelocHeader;
  private /*const*/ coff_base_reloc_block_header /*P*/ BaseRelocEnd;
  private /*const*/ debug_directory /*P*/ DebugDirectoryBegin;
  private /*const*/ debug_directory /*P*/ DebugDirectoryEnd;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 645,
   FQN="llvm::object::COFFObjectFile::getString", NM="_ZNK4llvm6object14COFFObjectFile9getStringEjRNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile9getStringEjRNS_9StringRefE")
  //</editor-fold>
  private std.error_code getString(/*uint32_t*/int offset, final StringRef /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /*template <typename coff_symbol_type> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::toSymb">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 648,
   FQN="llvm::object::COFFObjectFile::toSymb", NM="Tpl__ZNK4llvm6object14COFFObjectFile6toSymbENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=Tpl__ZNK4llvm6object14COFFObjectFile6toSymbENS0_11DataRefImplE")
  //</editor-fold>
  private </*typename*/ coff_symbol_type> /*const*/ coff_symbol_type /*P*/ toSymb(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::toSec">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 649,
   FQN="llvm::object::COFFObjectFile::toSec", NM="_ZNK4llvm6object14COFFObjectFile5toSecENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile5toSecENS0_11DataRefImplE")
  //</editor-fold>
  private /*const*/ coff_section /*P*/ toSec(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::toRel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 650,
   FQN="llvm::object::COFFObjectFile::toRel", NM="_ZNK4llvm6object14COFFObjectFile5toRelENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile5toRelENS0_11DataRefImplE")
  //</editor-fold>
  private /*const*/ coff_relocation /*P*/ toRel(DataRefImpl Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initSymbolTablePtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 652,
   FQN="llvm::object::COFFObjectFile::initSymbolTablePtr", NM="_ZN4llvm6object14COFFObjectFile18initSymbolTablePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile18initSymbolTablePtrEv")
  //</editor-fold>
  private std.error_code initSymbolTablePtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initImportTablePtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 653,
   FQN="llvm::object::COFFObjectFile::initImportTablePtr", NM="_ZN4llvm6object14COFFObjectFile18initImportTablePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile18initImportTablePtrEv")
  //</editor-fold>
  private std.error_code initImportTablePtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initDelayImportTablePtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 654,
   FQN="llvm::object::COFFObjectFile::initDelayImportTablePtr", NM="_ZN4llvm6object14COFFObjectFile23initDelayImportTablePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile23initDelayImportTablePtrEv")
  //</editor-fold>
  private std.error_code initDelayImportTablePtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initExportTablePtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 655,
   FQN="llvm::object::COFFObjectFile::initExportTablePtr", NM="_ZN4llvm6object14COFFObjectFile18initExportTablePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile18initExportTablePtrEv")
  //</editor-fold>
  private std.error_code initExportTablePtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initBaseRelocPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 656,
   FQN="llvm::object::COFFObjectFile::initBaseRelocPtr", NM="_ZN4llvm6object14COFFObjectFile16initBaseRelocPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile16initBaseRelocPtrEv")
  //</editor-fold>
  private std.error_code initBaseRelocPtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::initDebugDirectoryPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 657,
   FQN="llvm::object::COFFObjectFile::initDebugDirectoryPtr", NM="_ZN4llvm6object14COFFObjectFile21initDebugDirectoryPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile21initDebugDirectoryPtrEv")
  //</editor-fold>
  private std.error_code initDebugDirectoryPtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 660,
   FQN="llvm::object::COFFObjectFile::getSymbolTable", NM="_ZNK4llvm6object14COFFObjectFile14getSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSymbolTableEv")
  //</editor-fold>
  public Object/*uintptr_t*/ getSymbolTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 667,
   FQN="llvm::object::COFFObjectFile::getMachine", NM="_ZNK4llvm6object14COFFObjectFile10getMachineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile10getMachineEv")
  //</editor-fold>
  public /*uint16_t*/char getMachine() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSizeOfOptionalHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 674,
   FQN="llvm::object::COFFObjectFile::getSizeOfOptionalHeader", NM="_ZNK4llvm6object14COFFObjectFile23getSizeOfOptionalHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile23getSizeOfOptionalHeaderEv")
  //</editor-fold>
  public /*uint16_t*/char getSizeOfOptionalHeader() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCharacteristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 683,
   FQN="llvm::object::COFFObjectFile::getCharacteristics", NM="_ZNK4llvm6object14COFFObjectFile18getCharacteristicsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getCharacteristicsEv")
  //</editor-fold>
  public /*uint16_t*/char getCharacteristics() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getTimeDateStamp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 692,
   FQN="llvm::object::COFFObjectFile::getTimeDateStamp", NM="_ZNK4llvm6object14COFFObjectFile16getTimeDateStampEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16getTimeDateStampEv")
  //</editor-fold>
  public /*uint32_t*/int getTimeDateStamp() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getNumberOfSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 699,
   FQN="llvm::object::COFFObjectFile::getNumberOfSections", NM="_ZNK4llvm6object14COFFObjectFile19getNumberOfSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19getNumberOfSectionsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumberOfSections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getPointerToSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 706,
   FQN="llvm::object::COFFObjectFile::getPointerToSymbolTable", NM="_ZNK4llvm6object14COFFObjectFile23getPointerToSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile23getPointerToSymbolTableEv")
  //</editor-fold>
  public /*uint32_t*/int getPointerToSymbolTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getNumberOfSymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 714,
   FQN="llvm::object::COFFObjectFile::getNumberOfSymbols", NM="_ZNK4llvm6object14COFFObjectFile18getNumberOfSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getNumberOfSymbolsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumberOfSymbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::moveSymbolNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 722,
   FQN="llvm::object::COFFObjectFile::moveSymbolNext", NM="_ZNK4llvm6object14COFFObjectFile14moveSymbolNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14moveSymbolNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public/*protected*/ void moveSymbolNext(final DataRefImpl /*&*/ Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 723,
   FQN="llvm::object::COFFObjectFile::getSymbolName", NM="_ZNK4llvm6object14COFFObjectFile13getSymbolNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getSymbolNameENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected Expected<StringRef> getSymbolName(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 724,
   FQN="llvm::object::COFFObjectFile::getSymbolAddress", NM="_ZNK4llvm6object14COFFObjectFile16getSymbolAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16getSymbolAddressENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected Expected<Long/*uint64_t*/> getSymbolAddress(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolValueImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 725,
   FQN="llvm::object::COFFObjectFile::getSymbolValueImpl", NM="_ZNK4llvm6object14COFFObjectFile18getSymbolValueImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getSymbolValueImplENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getSymbolValueImpl(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCommonSymbolSizeImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 726,
   FQN="llvm::object::COFFObjectFile::getCommonSymbolSizeImpl", NM="_ZNK4llvm6object14COFFObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getCommonSymbolSizeImpl(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 727,
   FQN="llvm::object::COFFObjectFile::getSymbolFlags", NM="_ZNK4llvm6object14COFFObjectFile14getSymbolFlagsENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSymbolFlagsENS0_11DataRefImplE")
  //</editor-fold>
  @Override public/*protected*/ /*uint32_t*/int getSymbolFlags(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 728,
   FQN="llvm::object::COFFObjectFile::getSymbolType", NM="_ZNK4llvm6object14COFFObjectFile13getSymbolTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getSymbolTypeENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected Expected<SymbolRef.Type> getSymbolType(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 729,
   FQN="llvm::object::COFFObjectFile::getSymbolSection", NM="_ZNK4llvm6object14COFFObjectFile16getSymbolSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16getSymbolSectionENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected Expected<content_iterator<SectionRef> > getSymbolSection(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::moveSectionNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 730,
   FQN="llvm::object::COFFObjectFile::moveSectionNext", NM="_ZNK4llvm6object14COFFObjectFile15moveSectionNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile15moveSectionNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override protected void moveSectionNext(final DataRefImpl /*&*/ Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 731,
   FQN="llvm::object::COFFObjectFile::getSectionName", NM="_ZNK4llvm6object14COFFObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  @Override protected std.error_code getSectionName(DataRefImpl Sec, 
                final StringRef /*&*/ Res) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 733,
   FQN="llvm::object::COFFObjectFile::getSectionAddress", NM="_ZNK4llvm6object14COFFObjectFile17getSectionAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getSectionAddressENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getSectionAddress(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 734,
   FQN="llvm::object::COFFObjectFile::getSectionSize", NM="_ZNK4llvm6object14COFFObjectFile14getSectionSizeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSectionSizeENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getSectionSize(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 735,
   FQN="llvm::object::COFFObjectFile::getSectionContents", NM="_ZNK4llvm6object14COFFObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  @Override protected std.error_code getSectionContents(DataRefImpl Sec, 
                    final StringRef /*&*/ Res) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 737,
   FQN="llvm::object::COFFObjectFile::getSectionAlignment", NM="_ZNK4llvm6object14COFFObjectFile19getSectionAlignmentENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19getSectionAlignmentENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getSectionAlignment(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isSectionCompressed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 738,
   FQN="llvm::object::COFFObjectFile::isSectionCompressed", NM="_ZNK4llvm6object14COFFObjectFile19isSectionCompressedENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19isSectionCompressedENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected boolean isSectionCompressed(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isSectionText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 739,
   FQN="llvm::object::COFFObjectFile::isSectionText", NM="_ZNK4llvm6object14COFFObjectFile13isSectionTextENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13isSectionTextENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected boolean isSectionText(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isSectionData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 740,
   FQN="llvm::object::COFFObjectFile::isSectionData", NM="_ZNK4llvm6object14COFFObjectFile13isSectionDataENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13isSectionDataENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected boolean isSectionData(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isSectionBSS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 741,
   FQN="llvm::object::COFFObjectFile::isSectionBSS", NM="_ZNK4llvm6object14COFFObjectFile12isSectionBSSENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile12isSectionBSSENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected boolean isSectionBSS(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isSectionVirtual">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 742,
   FQN="llvm::object::COFFObjectFile::isSectionVirtual", NM="_ZNK4llvm6object14COFFObjectFile16isSectionVirtualENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16isSectionVirtualENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected boolean isSectionVirtual(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::section_rel_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 743,
   FQN="llvm::object::COFFObjectFile::section_rel_begin", NM="_ZNK4llvm6object14COFFObjectFile17section_rel_beginENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17section_rel_beginENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected content_iterator<RelocationRef> section_rel_begin(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::section_rel_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 744,
   FQN="llvm::object::COFFObjectFile::section_rel_end", NM="_ZNK4llvm6object14COFFObjectFile15section_rel_endENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile15section_rel_endENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected content_iterator<RelocationRef> section_rel_end(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::moveRelocationNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 746,
   FQN="llvm::object::COFFObjectFile::moveRelocationNext", NM="_ZNK4llvm6object14COFFObjectFile18moveRelocationNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18moveRelocationNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override protected void moveRelocationNext(final DataRefImpl /*&*/ Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRelocationOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 747,
   FQN="llvm::object::COFFObjectFile::getRelocationOffset", NM="_ZNK4llvm6object14COFFObjectFile19getRelocationOffsetENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19getRelocationOffsetENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getRelocationOffset(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRelocationSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 748,
   FQN="llvm::object::COFFObjectFile::getRelocationSymbol", NM="_ZNK4llvm6object14COFFObjectFile19getRelocationSymbolENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19getRelocationSymbolENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected symbol_iterator getRelocationSymbol(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 749,
   FQN="llvm::object::COFFObjectFile::getRelocationType", NM="_ZNK4llvm6object14COFFObjectFile17getRelocationTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getRelocationTypeENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected long/*uint64_t*/ getRelocationType(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRelocationTypeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 750,
   FQN="llvm::object::COFFObjectFile::getRelocationTypeName", NM="_ZNK4llvm6object14COFFObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  @Override protected void getRelocationTypeName(DataRefImpl Rel, 
                       final SmallString/*&*/ Result) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::COFFObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 754,
   FQN="llvm::object::COFFObjectFile::COFFObjectFile", NM="_ZN4llvm6object14COFFObjectFileC1ENS_15MemoryBufferRefERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFileC1ENS_15MemoryBufferRefERSt10error_code")
  //</editor-fold>
  public COFFObjectFile(MemoryBufferRef Object, final std.error_code /*&*/ EC) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::symbol_begin_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 755,
   FQN="llvm::object::COFFObjectFile::symbol_begin_impl", NM="_ZNK4llvm6object14COFFObjectFile17symbol_begin_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17symbol_begin_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_begin_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::symbol_end_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 756,
   FQN="llvm::object::COFFObjectFile::symbol_end_impl", NM="_ZNK4llvm6object14COFFObjectFile15symbol_end_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile15symbol_end_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_end_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::section_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 757,
   FQN="llvm::object::COFFObjectFile::section_begin", NM="_ZNK4llvm6object14COFFObjectFile13section_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13section_beginEv")
  //</editor-fold>
  @Override public content_iterator<SectionRef> section_begin() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::section_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 758,
   FQN="llvm::object::COFFObjectFile::section_end", NM="_ZNK4llvm6object14COFFObjectFile11section_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile11section_endEv")
  //</editor-fold>
  @Override public content_iterator<SectionRef> section_end() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCOFFSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 760,
   FQN="llvm::object::COFFObjectFile::getCOFFSection", NM="_ZNK4llvm6object14COFFObjectFile14getCOFFSectionERKNS0_10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getCOFFSectionERKNS0_10SectionRefE")
  //</editor-fold>
  public /*const*/ coff_section /*P*/ getCOFFSection(final /*const*/ SectionRef /*&*/ Section) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCOFFSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 761,
   FQN="llvm::object::COFFObjectFile::getCOFFSymbol", NM="_ZNK4llvm6object14COFFObjectFile13getCOFFSymbolERKNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getCOFFSymbolERKNS0_11DataRefImplE")
  //</editor-fold>
  public COFFSymbolRef getCOFFSymbol(final /*const*/ DataRefImpl /*&*/ Ref) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCOFFSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 762,
   FQN="llvm::object::COFFObjectFile::getCOFFSymbol", NM="_ZNK4llvm6object14COFFObjectFile13getCOFFSymbolERKNS0_9SymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getCOFFSymbolERKNS0_9SymbolRefE")
  //</editor-fold>
  public COFFSymbolRef getCOFFSymbol(final /*const*/ SymbolRef /*&*/ Symbol) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getCOFFRelocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 763,
   FQN="llvm::object::COFFObjectFile::getCOFFRelocation", NM="_ZNK4llvm6object14COFFObjectFile17getCOFFRelocationERKNS0_13RelocationRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getCOFFRelocationERKNS0_13RelocationRefE")
  //</editor-fold>
  public /*const*/ coff_relocation /*P*/ getCOFFRelocation(final /*const*/ RelocationRef /*&*/ Reloc) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 764,
   FQN="llvm::object::COFFObjectFile::getSectionID", NM="_ZNK4llvm6object14COFFObjectFile12getSectionIDENS0_10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile12getSectionIDENS0_10SectionRefE")
  //</editor-fold>
  public /*uint*/int getSectionID(SectionRef Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolSectionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 765,
   FQN="llvm::object::COFFObjectFile::getSymbolSectionID", NM="_ZNK4llvm6object14COFFObjectFile18getSymbolSectionIDENS0_9SymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getSymbolSectionIDENS0_9SymbolRefE")
  //</editor-fold>
  public /*uint*/int getSymbolSectionID(SymbolRef Sym) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getBytesInAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 767,
   FQN="llvm::object::COFFObjectFile::getBytesInAddress", NM="_ZNK4llvm6object14COFFObjectFile17getBytesInAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getBytesInAddressEv")
  //</editor-fold>
  @Override public byte/*uint8_t*/ getBytesInAddress() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getFileFormatName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 768,
   FQN="llvm::object::COFFObjectFile::getFileFormatName", NM="_ZNK4llvm6object14COFFObjectFile17getFileFormatNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getFileFormatNameEv")
  //</editor-fold>
  @Override public StringRef getFileFormatName() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 769,
   FQN="llvm::object::COFFObjectFile::getArch", NM="_ZNK4llvm6object14COFFObjectFile7getArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile7getArchEv")
  //</editor-fold>
  @Override public /*uint*/int getArch() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getFeatures">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 770,
   FQN="llvm::object::COFFObjectFile::getFeatures", NM="_ZNK4llvm6object14COFFObjectFile11getFeaturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile11getFeaturesEv")
  //</editor-fold>
  @Override public SubtargetFeatures getFeatures() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::import_directory_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 772,
   FQN="llvm::object::COFFObjectFile::import_directory_begin", NM="_ZNK4llvm6object14COFFObjectFile22import_directory_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile22import_directory_beginEv")
  //</editor-fold>
  public content_iterator<ImportDirectoryEntryRef> import_directory_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::import_directory_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 773,
   FQN="llvm::object::COFFObjectFile::import_directory_end", NM="_ZNK4llvm6object14COFFObjectFile20import_directory_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile20import_directory_endEv")
  //</editor-fold>
  public content_iterator<ImportDirectoryEntryRef> import_directory_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::delay_import_directory_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 774,
   FQN="llvm::object::COFFObjectFile::delay_import_directory_begin", NM="_ZNK4llvm6object14COFFObjectFile28delay_import_directory_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile28delay_import_directory_beginEv")
  //</editor-fold>
  public content_iterator<DelayImportDirectoryEntryRef> delay_import_directory_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::delay_import_directory_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 775,
   FQN="llvm::object::COFFObjectFile::delay_import_directory_end", NM="_ZNK4llvm6object14COFFObjectFile26delay_import_directory_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile26delay_import_directory_endEv")
  //</editor-fold>
  public content_iterator<DelayImportDirectoryEntryRef> delay_import_directory_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::export_directory_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 776,
   FQN="llvm::object::COFFObjectFile::export_directory_begin", NM="_ZNK4llvm6object14COFFObjectFile22export_directory_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile22export_directory_beginEv")
  //</editor-fold>
  public content_iterator<ExportDirectoryEntryRef> export_directory_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::export_directory_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 777,
   FQN="llvm::object::COFFObjectFile::export_directory_end", NM="_ZNK4llvm6object14COFFObjectFile20export_directory_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile20export_directory_endEv")
  //</editor-fold>
  public content_iterator<ExportDirectoryEntryRef> export_directory_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::base_reloc_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 778,
   FQN="llvm::object::COFFObjectFile::base_reloc_begin", NM="_ZNK4llvm6object14COFFObjectFile16base_reloc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16base_reloc_beginEv")
  //</editor-fold>
  public content_iterator<BaseRelocRef> base_reloc_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::base_reloc_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 779,
   FQN="llvm::object::COFFObjectFile::base_reloc_end", NM="_ZNK4llvm6object14COFFObjectFile14base_reloc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14base_reloc_endEv")
  //</editor-fold>
  public content_iterator<BaseRelocRef> base_reloc_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::debug_directory_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 780,
   FQN="llvm::object::COFFObjectFile::debug_directory_begin", NM="_ZNK4llvm6object14COFFObjectFile21debug_directory_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile21debug_directory_beginEv")
  //</editor-fold>
  public /*const*/ debug_directory /*P*/ debug_directory_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::debug_directory_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 783,
   FQN="llvm::object::COFFObjectFile::debug_directory_end", NM="_ZNK4llvm6object14COFFObjectFile19debug_directory_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19debug_directory_endEv")
  //</editor-fold>
  public /*const*/ debug_directory /*P*/ debug_directory_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::import_directories">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 787,
   FQN="llvm::object::COFFObjectFile::import_directories", NM="_ZNK4llvm6object14COFFObjectFile18import_directoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18import_directoriesEv")
  //</editor-fold>
  public iterator_range<content_iterator<ImportDirectoryEntryRef> > import_directories() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::delay_import_directories">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 788,
   FQN="llvm::object::COFFObjectFile::delay_import_directories", NM="_ZNK4llvm6object14COFFObjectFile24delay_import_directoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile24delay_import_directoriesEv")
  //</editor-fold>
  public iterator_range<content_iterator<DelayImportDirectoryEntryRef> > delay_import_directories() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::export_directories">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 790,
   FQN="llvm::object::COFFObjectFile::export_directories", NM="_ZNK4llvm6object14COFFObjectFile18export_directoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18export_directoriesEv")
  //</editor-fold>
  public iterator_range<content_iterator<ExportDirectoryEntryRef> > export_directories() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::base_relocs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 791,
   FQN="llvm::object::COFFObjectFile::base_relocs", NM="_ZNK4llvm6object14COFFObjectFile11base_relocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile11base_relocsEv")
  //</editor-fold>
  public iterator_range<content_iterator<BaseRelocRef> > base_relocs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::debug_directories">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 792,
   FQN="llvm::object::COFFObjectFile::debug_directories", NM="_ZNK4llvm6object14COFFObjectFile17debug_directoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17debug_directoriesEv")
  //</editor-fold>
  public iterator_range</*const*/ debug_directory> debug_directories() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getDOSHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 796,
   FQN="llvm::object::COFFObjectFile::getDOSHeader", NM="_ZNK4llvm6object14COFFObjectFile12getDOSHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile12getDOSHeaderEv")
  //</editor-fold>
  public /*const*/ dos_header /*P*/ getDOSHeader() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getPE32Header">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 801,
   FQN="llvm::object::COFFObjectFile::getPE32Header", NM="_ZNK4llvm6object14COFFObjectFile13getPE32HeaderERPKNS0_11pe32_headerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getPE32HeaderERPKNS0_11pe32_headerE")
  //</editor-fold>
  public std.error_code getPE32Header(final type$ref</*const*/ pe32_header /*P*/ /*&*/> Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getPE32PlusHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 802,
   FQN="llvm::object::COFFObjectFile::getPE32PlusHeader", NM="_ZNK4llvm6object14COFFObjectFile17getPE32PlusHeaderERPKNS0_15pe32plus_headerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile17getPE32PlusHeaderERPKNS0_15pe32plus_headerE")
  //</editor-fold>
  public std.error_code getPE32PlusHeader(final type$ref</*const*/ pe32plus_header /*P*/ /*&*/> Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getDataDirectory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 803,
   FQN="llvm::object::COFFObjectFile::getDataDirectory", NM="_ZNK4llvm6object14COFFObjectFile16getDataDirectoryEjRPKNS0_14data_directoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16getDataDirectoryEjRPKNS0_14data_directoryE")
  //</editor-fold>
  public std.error_code getDataDirectory(/*uint32_t*/int index, 
                  final type$ref</*const*/ data_directory /*P*/ /*&*/> Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 805,
   FQN="llvm::object::COFFObjectFile::getSection", NM="_ZNK4llvm6object14COFFObjectFile10getSectionEiRPKNS0_12coff_sectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile10getSectionEiRPKNS0_12coff_sectionE")
  //</editor-fold>
  public std.error_code getSection(int/*int32_t*/ index, final type$ref</*const*/ coff_section /*P*/ /*&*/> Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /*template <typename coff_symbol_type> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 807,
   FQN="llvm::object::COFFObjectFile::getSymbol", NM="Tpl__ZNK4llvm6object14COFFObjectFile9getSymbolEjRPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=Tpl__ZNK4llvm6object14COFFObjectFile9getSymbolEjRPKT_")
  //</editor-fold>
  public </*typename*/ coff_symbol_type> std.error_code getSymbol$T(/*uint32_t*/int Index, 
             final /*const*/ coff_symbol_type /*P*/ /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 815,
   FQN="llvm::object::COFFObjectFile::getSymbol", NM="_ZNK4llvm6object14COFFObjectFile9getSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile9getSymbolEj")
  //</editor-fold>
  public ErrorOr<COFFSymbolRef> getSymbol(/*uint32_t*/int index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getAuxSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 831,
   FQN="llvm::object::COFFObjectFile::getAuxSymbol", NM="Tpl__ZNK4llvm6object14COFFObjectFile12getAuxSymbolEjRPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=Tpl__ZNK4llvm6object14COFFObjectFile12getAuxSymbolEjRPKT_")
  //</editor-fold>
  public </*typename*/ T> std.error_code getAuxSymbol(/*uint32_t*/int index, final /*const*/ T /*P*/ /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 838,
   FQN="llvm::object::COFFObjectFile::getSymbolName", NM="_ZNK4llvm6object14COFFObjectFile13getSymbolNameENS0_13COFFSymbolRefERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getSymbolNameENS0_13COFFSymbolRefERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getSymbolName(COFFSymbolRef Symbol, final StringRef /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 839,
   FQN="llvm::object::COFFObjectFile::getSymbolName", NM="_ZNK4llvm6object14COFFObjectFile13getSymbolNameEPKNS0_19coff_symbol_genericERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile13getSymbolNameEPKNS0_19coff_symbol_genericERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getSymbolName(/*const*/ coff_symbol_generic /*P*/ Symbol, 
               final StringRef /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolAuxData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 842,
   FQN="llvm::object::COFFObjectFile::getSymbolAuxData", NM="_ZNK4llvm6object14COFFObjectFile16getSymbolAuxDataENS0_13COFFSymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile16getSymbolAuxDataENS0_13COFFSymbolRefE")
  //</editor-fold>
  public ArrayRefUChar getSymbolAuxData(COFFSymbolRef Symbol) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSymbolTableEntrySize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 844,
   FQN="llvm::object::COFFObjectFile::getSymbolTableEntrySize", NM="_ZNK4llvm6object14COFFObjectFile23getSymbolTableEntrySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile23getSymbolTableEntrySizeEv")
  //</editor-fold>
  public /*size_t*/int getSymbolTableEntrySize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRelocations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 852,
   FQN="llvm::object::COFFObjectFile::getRelocations", NM="_ZNK4llvm6object14COFFObjectFile14getRelocationsEPKNS0_12coff_sectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getRelocationsEPKNS0_12coff_sectionE")
  //</editor-fold>
  public iterator_range</*const*/ coff_relocation> getRelocations(/*const*/ coff_section /*P*/ Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 855,
   FQN="llvm::object::COFFObjectFile::getSectionName", NM="_ZNK4llvm6object14COFFObjectFile14getSectionNameEPKNS0_12coff_sectionERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSectionNameEPKNS0_12coff_sectionERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getSectionName(/*const*/ coff_section /*P*/ Sec, final StringRef /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 856,
   FQN="llvm::object::COFFObjectFile::getSectionSize", NM="_ZNK4llvm6object14COFFObjectFile14getSectionSizeEPKNS0_12coff_sectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile14getSectionSizeEPKNS0_12coff_sectionE")
  //</editor-fold>
  public long/*uint64_t*/ getSectionSize(/*const*/ coff_section /*P*/ Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getSectionContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 857,
   FQN="llvm::object::COFFObjectFile::getSectionContents", NM="_ZNK4llvm6object14COFFObjectFile18getSectionContentsEPKNS0_12coff_sectionERNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile18getSectionContentsEPKNS0_12coff_sectionERNS_8ArrayRefIhEE")
  //</editor-fold>
  public std.error_code getSectionContents(/*const*/ coff_section /*P*/ Sec, 
                    final ArrayRefUChar/*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getImageBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 860,
   FQN="llvm::object::COFFObjectFile::getImageBase", NM="_ZNK4llvm6object14COFFObjectFile12getImageBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile12getImageBaseEv")
  //</editor-fold>
  public long/*uint64_t*/ getImageBase() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getVaPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 861,
   FQN="llvm::object::COFFObjectFile::getVaPtr", NM="_ZNK4llvm6object14COFFObjectFile8getVaPtrEyRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile8getVaPtrEyRj")
  //</editor-fold>
  public std.error_code getVaPtr(long/*uint64_t*/ VA, final Object/*uintptr_t*//*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRvaPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 862,
   FQN="llvm::object::COFFObjectFile::getRvaPtr", NM="_ZNK4llvm6object14COFFObjectFile9getRvaPtrEjRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile9getRvaPtrEjRj")
  //</editor-fold>
  public std.error_code getRvaPtr(/*uint32_t*/int Rva, final Object/*uintptr_t*//*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Given an RVA base and size, returns a valid array of bytes or an error
  /// code if the RVA and size is not contained completely within a valid
  /// section.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getRvaAndSizeAsBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 867,
   FQN="llvm::object::COFFObjectFile::getRvaAndSizeAsBytes", NM="_ZNK4llvm6object14COFFObjectFile20getRvaAndSizeAsBytesEjjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile20getRvaAndSizeAsBytesEjjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public std.error_code getRvaAndSizeAsBytes(/*uint32_t*/int RVA, /*uint32_t*/int Size, 
                      final ArrayRefUChar/*&*/ Contents) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getHintName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 870,
   FQN="llvm::object::COFFObjectFile::getHintName", NM="_ZNK4llvm6object14COFFObjectFile11getHintNameEjRtRNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile11getHintNameEjRtRNS_9StringRefE")
  //</editor-fold>
  public std.error_code getHintName(/*uint32_t*/int Rva, final /*uint16_t*/char/*&*/ Hint, 
             final StringRef /*&*/ Name) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get PDB information out of a codeview debug directory entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getDebugPDBInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 874,
   FQN="llvm::object::COFFObjectFile::getDebugPDBInfo", NM="_ZNK4llvm6object14COFFObjectFile15getDebugPDBInfoEPKNS0_15debug_directoryERPKNS0_14debug_pdb_infoERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile15getDebugPDBInfoEPKNS0_15debug_directoryERPKNS0_14debug_pdb_infoERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getDebugPDBInfo(/*const*/ debug_directory /*P*/ DebugDir, 
                 final type$ref</*const*/ debug_pdb_info /*P*/ /*&*/> Info, 
                 final StringRef /*&*/ PDBFileName) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get PDB information from an executable. If the information is not present,
  /// Info will be set to nullptr and PDBFileName will be empty. An error is
  /// returned only on corrupt object files. Convenience accessor that can be
  /// used if the debug directory is not already handy.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::getDebugPDBInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 882,
   FQN="llvm::object::COFFObjectFile::getDebugPDBInfo", NM="_ZNK4llvm6object14COFFObjectFile15getDebugPDBInfoERPKNS0_14debug_pdb_infoERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile15getDebugPDBInfoERPKNS0_14debug_pdb_infoERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getDebugPDBInfo(final type$ref</*const*/ debug_pdb_info /*P*/ /*&*/> Info, 
                 final StringRef /*&*/ PDBFileName) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::isRelocatableObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 885,
   FQN="llvm::object::COFFObjectFile::isRelocatableObject", NM="_ZNK4llvm6object14COFFObjectFile19isRelocatableObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile19isRelocatableObjectEv")
  //</editor-fold>
  @Override public boolean isRelocatableObject() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::is64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 886,
   FQN="llvm::object::COFFObjectFile::is64", NM="_ZNK4llvm6object14COFFObjectFile4is64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object14COFFObjectFile4is64Ev")
  //</editor-fold>
  public boolean is64() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 888,
   FQN="llvm::object::COFFObjectFile::classof", NM="_ZN4llvm6object14COFFObjectFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFObjectFile::~COFFObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 622,
   FQN="llvm::object::COFFObjectFile::~COFFObjectFile", NM="_ZN4llvm6object14COFFObjectFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object14COFFObjectFileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "COFFHeader=" + COFFHeader // NOI18N
              + ", COFFBigObjHeader=" + COFFBigObjHeader // NOI18N
              + ", PE32Header=" + PE32Header // NOI18N
              + ", PE32PlusHeader=" + PE32PlusHeader // NOI18N
              + ", DataDirectory=" + DataDirectory // NOI18N
              + ", SectionTable=" + SectionTable // NOI18N
              + ", SymbolTable16=" + SymbolTable16 // NOI18N
              + ", SymbolTable32=" + SymbolTable32 // NOI18N
              + ", StringTable=" + StringTable // NOI18N
              + ", StringTableSize=" + StringTableSize // NOI18N
              + ", ImportDirectory=" + ImportDirectory // NOI18N
              + ", DelayImportDirectory=" + DelayImportDirectory // NOI18N
              + ", NumberOfDelayImportDirectory=" + NumberOfDelayImportDirectory // NOI18N
              + ", ExportDirectory=" + ExportDirectory // NOI18N
              + ", BaseRelocHeader=" + BaseRelocHeader // NOI18N
              + ", BaseRelocEnd=" + BaseRelocEnd // NOI18N
              + ", DebugDirectoryBegin=" + DebugDirectoryBegin // NOI18N
              + ", DebugDirectoryEnd=" + DebugDirectoryEnd // NOI18N
              + super.toString(); // NOI18N
  }
}
