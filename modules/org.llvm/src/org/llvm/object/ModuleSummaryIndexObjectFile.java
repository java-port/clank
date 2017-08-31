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
import org.llvm.ir.java.IRFunctionPointers.*;


/// This class is used to read just the module summary index related
/// sections out of the given object (which may contain a single module's
/// bitcode or be a combined index bitcode file). It builds a ModuleSummaryIndex
/// object.
//<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 31,
 FQN="llvm::object::ModuleSummaryIndexObjectFile", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFileE")
//</editor-fold>
public class ModuleSummaryIndexObjectFile extends /*public*/ SymbolicFile implements Destructors.ClassWithDestructor {
  private std.unique_ptr<ModuleSummaryIndex> Index;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::ModuleSummaryIndexObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 35,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::ModuleSummaryIndexObjectFile", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFileC1ENS_15MemoryBufferRefESt10unique_ptrINS_18ModuleSummaryIndexESt14default_deleteIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFileC1ENS_15MemoryBufferRefESt10unique_ptrINS_18ModuleSummaryIndexESt14default_deleteIS4_EE")
  //</editor-fold>
  public ModuleSummaryIndexObjectFile(MemoryBufferRef Object, 
      std.unique_ptr<ModuleSummaryIndex> I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::~ModuleSummaryIndexObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 37,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::~ModuleSummaryIndexObjectFile", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFileD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // TODO: Walk through GlobalValueMap entries for symbols.
  // However, currently these interfaces are not used by any consumers.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::moveSymbolNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 41,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::moveSymbolNext", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile14moveSymbolNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile14moveSymbolNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public void moveSymbolNext(final DataRefImpl /*&*/ Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::printSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 44,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::printSymbolName", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE")
  //</editor-fold>
  @Override public std.error_code printSymbolName(final raw_ostream /*&*/ OS, 
                 DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::getSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 49,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::getSymbolFlags", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile14getSymbolFlagsENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile14getSymbolFlagsENS0_11DataRefImplE")
  //</editor-fold>
  @Override public /*uint32_t*/int getSymbolFlags(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::symbol_begin_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 53,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::symbol_begin_impl", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile17symbol_begin_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile17symbol_begin_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_begin_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::symbol_end_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 57,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::symbol_end_impl", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile15symbol_end_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile15symbol_end_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_end_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::getIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 62,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::getIndex", NM="_ZNK4llvm6object28ModuleSummaryIndexObjectFile8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object28ModuleSummaryIndexObjectFile8getIndexEv")
  //</editor-fold>
  public /*const*/ ModuleSummaryIndex /*&*/ getIndex$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::getIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 65,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::getIndex", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile8getIndexEv")
  //</editor-fold>
  public ModuleSummaryIndex /*&*/ getIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::takeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 66,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::takeIndex", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile9takeIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile9takeIndexEv")
  //</editor-fold>
  public std.unique_ptr<ModuleSummaryIndex> takeIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 68,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::classof", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Finds and returns bitcode embedded in the given object file, or an
  /// error code if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::findBitcodeInObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 74,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::findBitcodeInObject", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile19findBitcodeInObjectERKNS0_10ObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile19findBitcodeInObjectERKNS0_10ObjectFileE")
  //</editor-fold>
  public static ErrorOr<MemoryBufferRef> findBitcodeInObject(final /*const*/ ObjectFile /*&*/ Obj) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Finds and returns bitcode in the given memory buffer (which may
  /// be either a bitcode file or a native object file with embedded bitcode),
  /// or an error code if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::findBitcodeInMemBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 79,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::findBitcodeInMemBuffer", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile22findBitcodeInMemBufferENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile22findBitcodeInMemBufferENS_15MemoryBufferRefE")
  //</editor-fold>
  public static ErrorOr<MemoryBufferRef> findBitcodeInMemBuffer(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Looks for summary sections in the given memory buffer,
  /// returns true if found, else false.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::hasGlobalValueSummaryInMemBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 84,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::hasGlobalValueSummaryInMemBuffer", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile32hasGlobalValueSummaryInMemBufferENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile32hasGlobalValueSummaryInMemBufferENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
  //</editor-fold>
  public static boolean hasGlobalValueSummaryInMemBuffer(MemoryBufferRef Object, 
                                  final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Parse module summary index in the given memory buffer.
  /// Return new ModuleSummaryIndexObjectFile instance containing parsed module
  /// summary/index.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ModuleSummaryIndexObjectFile::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ModuleSummaryIndexObjectFile.h", line = 91,
   FQN="llvm::object::ModuleSummaryIndexObjectFile::create", NM="_ZN4llvm6object28ModuleSummaryIndexObjectFile6createENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object28ModuleSummaryIndexObjectFile6createENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<ModuleSummaryIndexObjectFile> > create(MemoryBufferRef Object, 
        final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Index=" + Index // NOI18N
              + super.toString(); // NOI18N
  }
}
