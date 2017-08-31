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

//<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 919,
 FQN="llvm::object::DelayImportDirectoryEntryRef", NM="_ZN4llvm6object28DelayImportDirectoryEntryRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object28DelayImportDirectoryEntryRefE")
//</editor-fold>
public class DelayImportDirectoryEntryRef implements Native.NativeComparable<DelayImportDirectoryEntryRef> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::DelayImportDirectoryEntryRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 921,
   FQN="llvm::object::DelayImportDirectoryEntryRef::DelayImportDirectoryEntryRef", NM="_ZN4llvm6object28DelayImportDirectoryEntryRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object28DelayImportDirectoryEntryRefC1Ev")
  //</editor-fold>
  public DelayImportDirectoryEntryRef() {
    // : OwningObject(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::DelayImportDirectoryEntryRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 922,
   FQN="llvm::object::DelayImportDirectoryEntryRef::DelayImportDirectoryEntryRef", NM="_ZN4llvm6object28DelayImportDirectoryEntryRefC1EPKNS0_34delay_import_directory_table_entryEjPKNS0_14COFFObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object28DelayImportDirectoryEntryRefC1EPKNS0_34delay_import_directory_table_entryEjPKNS0_14COFFObjectFileE")
  //</editor-fold>
  public DelayImportDirectoryEntryRef(/*const*/ delay_import_directory_table_entry /*P*/ T, 
      /*uint32_t*/int I, /*const*/ COFFObjectFile /*P*/ Owner) {
    // : Table(T), Index(I), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 926,
   FQN="llvm::object::DelayImportDirectoryEntryRef::operator==", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRefeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DelayImportDirectoryEntryRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 927,
   FQN="llvm::object::DelayImportDirectoryEntryRef::moveNext", NM="_ZN4llvm6object28DelayImportDirectoryEntryRef8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object28DelayImportDirectoryEntryRef8moveNextEv")
  //</editor-fold>
  public void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::imported_symbol_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 929,
   FQN="llvm::object::DelayImportDirectoryEntryRef::imported_symbol_begin", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef21imported_symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef21imported_symbol_beginEv")
  //</editor-fold>
  public content_iterator<ImportedSymbolRef> imported_symbol_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::imported_symbol_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 930,
   FQN="llvm::object::DelayImportDirectoryEntryRef::imported_symbol_end", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef19imported_symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef19imported_symbol_endEv")
  //</editor-fold>
  public content_iterator<ImportedSymbolRef> imported_symbol_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::imported_symbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 931,
   FQN="llvm::object::DelayImportDirectoryEntryRef::imported_symbols", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef16imported_symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef16imported_symbolsEv")
  //</editor-fold>
  public iterator_range<content_iterator<ImportedSymbolRef> > imported_symbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 933,
   FQN="llvm::object::DelayImportDirectoryEntryRef::getName", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef7getNameERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef7getNameERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getName(final StringRef /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::getDelayImportTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 934,
   FQN="llvm::object::DelayImportDirectoryEntryRef::getDelayImportTable", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef19getDelayImportTableERPKNS0_34delay_import_directory_table_entryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef19getDelayImportTableERPKNS0_34delay_import_directory_table_entryE")
  //</editor-fold>
  public std.error_code getDelayImportTable(final type$ref</*const*/ delay_import_directory_table_entry /*P*/ /*&*/> Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::DelayImportDirectoryEntryRef::getImportAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 936,
   FQN="llvm::object::DelayImportDirectoryEntryRef::getImportAddress", NM="_ZNK4llvm6object28DelayImportDirectoryEntryRef16getImportAddressEiRy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object28DelayImportDirectoryEntryRef16getImportAddressEiRy")
  //</editor-fold>
  public std.error_code getImportAddress(int AddrIndex, final ulong$ref/*uint64_t &*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  private /*const*/ delay_import_directory_table_entry /*P*/ Table;
  private /*uint32_t*/int Index;
  private /*const*/ COFFObjectFile /*P*/ OwningObject;
  
  @Override public String toString() {
    return "" + "Table=" + Table // NOI18N
              + ", Index=" + Index // NOI18N
              + ", OwningObject=" + OwningObject; // NOI18N
  }
}
