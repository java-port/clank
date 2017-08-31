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

//<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 970,
 FQN="llvm::object::ImportedSymbolRef", NM="_ZN4llvm6object17ImportedSymbolRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object17ImportedSymbolRefE")
//</editor-fold>
public class ImportedSymbolRef implements Native.NativeComparable<ImportedSymbolRef> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::ImportedSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 972,
   FQN="llvm::object::ImportedSymbolRef::ImportedSymbolRef", NM="_ZN4llvm6object17ImportedSymbolRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object17ImportedSymbolRefC1Ev")
  //</editor-fold>
  public ImportedSymbolRef() {
    // : OwningObject(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::ImportedSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 973,
   FQN="llvm::object::ImportedSymbolRef::ImportedSymbolRef", NM="_ZN4llvm6object17ImportedSymbolRefC1EPKNS0_25import_lookup_table_entryINS_7support6detail31packed_endian_specific_integralIiLNS3_10endiannessE1ELj1EEEEEjPKNS0_14COFFObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object17ImportedSymbolRefC1EPKNS0_25import_lookup_table_entryINS_7support6detail31packed_endian_specific_integralIiLNS3_10endiannessE1ELj1EEEEEjPKNS0_14COFFObjectFileE")
  //</editor-fold>
  public ImportedSymbolRef(JD$Import_lookup_table_entry$unaligned_int32_t$C$P_UInt_COFFObjectFile$C$P _dparam, /*const*/ import_lookup_table_entry<llvm.support.unaligned_int32_t> /*P*/ Entry, /*uint32_t*/int I, 
      /*const*/ COFFObjectFile /*P*/ Owner) {
    // : Entry32(Entry), Entry64(null), Index(I), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::ImportedSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 976,
   FQN="llvm::object::ImportedSymbolRef::ImportedSymbolRef", NM="_ZN4llvm6object17ImportedSymbolRefC1EPKNS0_25import_lookup_table_entryINS_7support6detail31packed_endian_specific_integralIxLNS3_10endiannessE1ELj1EEEEEjPKNS0_14COFFObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object17ImportedSymbolRefC1EPKNS0_25import_lookup_table_entryINS_7support6detail31packed_endian_specific_integralIxLNS3_10endiannessE1ELj1EEEEEjPKNS0_14COFFObjectFileE")
  //</editor-fold>
  public ImportedSymbolRef(JD$Import_lookup_table_entry$unaligned_int64_t$C$P_UInt_COFFObjectFile$C$P _dparam, /*const*/ import_lookup_table_entry<llvm.support.unaligned_int64_t> /*P*/ Entry, /*uint32_t*/int I, 
      /*const*/ COFFObjectFile /*P*/ Owner) {
    // : Entry32(null), Entry64(Entry), Index(I), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 980,
   FQN="llvm::object::ImportedSymbolRef::operator==", NM="_ZNK4llvm6object17ImportedSymbolRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object17ImportedSymbolRefeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ImportedSymbolRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 981,
   FQN="llvm::object::ImportedSymbolRef::moveNext", NM="_ZN4llvm6object17ImportedSymbolRef8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object17ImportedSymbolRef8moveNextEv")
  //</editor-fold>
  public void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 983,
   FQN="llvm::object::ImportedSymbolRef::getSymbolName", NM="_ZNK4llvm6object17ImportedSymbolRef13getSymbolNameERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object17ImportedSymbolRef13getSymbolNameERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getSymbolName(final StringRef /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::isOrdinal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 984,
   FQN="llvm::object::ImportedSymbolRef::isOrdinal", NM="_ZNK4llvm6object17ImportedSymbolRef9isOrdinalERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object17ImportedSymbolRef9isOrdinalERb")
  //</editor-fold>
  public std.error_code isOrdinal(final bool$ref/*bool &*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::getOrdinal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 985,
   FQN="llvm::object::ImportedSymbolRef::getOrdinal", NM="_ZNK4llvm6object17ImportedSymbolRef10getOrdinalERt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object17ImportedSymbolRef10getOrdinalERt")
  //</editor-fold>
  public std.error_code getOrdinal(final /*uint16_t*/char/*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ImportedSymbolRef::getHintNameRVA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 986,
   FQN="llvm::object::ImportedSymbolRef::getHintNameRVA", NM="_ZNK4llvm6object17ImportedSymbolRef14getHintNameRVAERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object17ImportedSymbolRef14getHintNameRVAERj")
  //</editor-fold>
  public std.error_code getHintNameRVA(final /*uint32_t &*/uint$ref Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  private /*const*/ import_lookup_table_entry<llvm.support.unaligned_int32_t> /*P*/ Entry32;
  private /*const*/ import_lookup_table_entry<llvm.support.unaligned_int64_t> /*P*/ Entry64;
  private /*uint32_t*/int Index;
  private /*const*/ COFFObjectFile /*P*/ OwningObject;
  
  @Override public String toString() {
    return "" + "Entry32=" + Entry32 // NOI18N
              + ", Entry64=" + Entry64 // NOI18N
              + ", Index=" + Index // NOI18N
              + ", OwningObject=" + OwningObject; // NOI18N
  }
}
