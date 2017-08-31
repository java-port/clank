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

//<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 28,
 FQN="llvm::object::IRObjectFile", NM="_ZN4llvm6object12IRObjectFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFileE")
//</editor-fold>
public class IRObjectFile extends /*public*/ SymbolicFile implements Destructors.ClassWithDestructor {
  private std.unique_ptr<Module> M;
  private std.unique_ptr<Mangler> Mang;
  private std.vector<std.pairTypeUInt<std.string>> AsmSymbols;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::IRObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 34,
   FQN="llvm::object::IRObjectFile::IRObjectFile", NM="_ZN4llvm6object12IRObjectFileC1ENS_15MemoryBufferRefESt10unique_ptrINS_6ModuleESt14default_deleteIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFileC1ENS_15MemoryBufferRefESt10unique_ptrINS_6ModuleESt14default_deleteIS4_EE")
  //</editor-fold>
  public IRObjectFile(MemoryBufferRef Object, std.unique_ptr<Module> M) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::~IRObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 35,
   FQN="llvm::object::IRObjectFile::~IRObjectFile", NM="_ZN4llvm6object12IRObjectFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFileD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::moveSymbolNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 36,
   FQN="llvm::object::IRObjectFile::moveSymbolNext", NM="_ZNK4llvm6object12IRObjectFile14moveSymbolNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile14moveSymbolNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public void moveSymbolNext(final DataRefImpl /*&*/ Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::printSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 37,
   FQN="llvm::object::IRObjectFile::printSymbolName", NM="_ZNK4llvm6object12IRObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE")
  //</editor-fold>
  @Override public std.error_code printSymbolName(final raw_ostream /*&*/ OS, 
                 DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::getSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 39,
   FQN="llvm::object::IRObjectFile::getSymbolFlags", NM="_ZNK4llvm6object12IRObjectFile14getSymbolFlagsENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile14getSymbolFlagsENS0_11DataRefImplE")
  //</editor-fold>
  @Override public /*uint32_t*/int getSymbolFlags(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::getSymbolGV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 40,
   FQN="llvm::object::IRObjectFile::getSymbolGV", NM="_ZN4llvm6object12IRObjectFile11getSymbolGVENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile11getSymbolGVENS0_11DataRefImplE")
  //</editor-fold>
  public GlobalValue /*P*/ getSymbolGV(DataRefImpl Symb) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::getSymbolGV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 41,
   FQN="llvm::object::IRObjectFile::getSymbolGV", NM="_ZNK4llvm6object12IRObjectFile11getSymbolGVENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile11getSymbolGVENS0_11DataRefImplE")
  //</editor-fold>
  public /*const*/ GlobalValue /*P*/ getSymbolGV$Const(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::symbol_begin_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 44,
   FQN="llvm::object::IRObjectFile::symbol_begin_impl", NM="_ZNK4llvm6object12IRObjectFile17symbol_begin_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile17symbol_begin_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_begin_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::symbol_end_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 45,
   FQN="llvm::object::IRObjectFile::symbol_end_impl", NM="_ZNK4llvm6object12IRObjectFile15symbol_end_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile15symbol_end_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_end_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::getModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 47,
   FQN="llvm::object::IRObjectFile::getModule", NM="_ZNK4llvm6object12IRObjectFile9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZNK4llvm6object12IRObjectFile9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*&*/ getModule$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::getModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 50,
   FQN="llvm::object::IRObjectFile::getModule", NM="_ZN4llvm6object12IRObjectFile9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile9getModuleEv")
  //</editor-fold>
  public Module /*&*/ getModule() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::takeModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 53,
   FQN="llvm::object::IRObjectFile::takeModule", NM="_ZN4llvm6object12IRObjectFile10takeModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile10takeModuleEv")
  //</editor-fold>
  public std.unique_ptr<Module> takeModule() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 55,
   FQN="llvm::object::IRObjectFile::classof", NM="_ZN4llvm6object12IRObjectFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Finds and returns bitcode embedded in the given object file, or an
  /// error code if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::findBitcodeInObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 61,
   FQN="llvm::object::IRObjectFile::findBitcodeInObject", NM="_ZN4llvm6object12IRObjectFile19findBitcodeInObjectERKNS0_10ObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile19findBitcodeInObjectERKNS0_10ObjectFileE")
  //</editor-fold>
  public static ErrorOr<MemoryBufferRef> findBitcodeInObject(final /*const*/ ObjectFile /*&*/ Obj) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Parse inline ASM and collect the symbols that are not defined in
  /// the current module.
  ///
  /// For each found symbol, call \p AsmUndefinedRefs with the name of the
  /// symbol found and the associated flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::CollectAsmUndefinedRefs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 68,
   FQN="llvm::object::IRObjectFile::CollectAsmUndefinedRefs", NM="_ZN4llvm6object12IRObjectFile23CollectAsmUndefinedRefsERKNS_6TripleENS_9StringRefENS_12function_refIFvS5_NS0_14BasicSymbolRef5FlagsEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile23CollectAsmUndefinedRefsERKNS_6TripleENS_9StringRefENS_12function_refIFvS5_NS0_14BasicSymbolRef5FlagsEEEE")
  //</editor-fold>
  public static void CollectAsmUndefinedRefs(final /*const*/ Triple /*&*/ TheTriple, StringRef InlineAsm, 
                         StringRefFlags2Void AsmUndefinedRefs) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Finds and returns bitcode in the given memory buffer (which may
  /// be either a bitcode file or a native object file with embedded bitcode),
  /// or an error code if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::findBitcodeInMemBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 75,
   FQN="llvm::object::IRObjectFile::findBitcodeInMemBuffer", NM="_ZN4llvm6object12IRObjectFile22findBitcodeInMemBufferENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile22findBitcodeInMemBufferENS_15MemoryBufferRefE")
  //</editor-fold>
  public static ErrorOr<MemoryBufferRef> findBitcodeInMemBuffer(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::IRObjectFile::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/IRObjectFile.h", line = 78,
   FQN="llvm::object::IRObjectFile::create", NM="_ZN4llvm6object12IRObjectFile6createENS_15MemoryBufferRefERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm6object12IRObjectFile6createENS_15MemoryBufferRefERNS_11LLVMContextE")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<IRObjectFile> > create(MemoryBufferRef Object, 
        final LLVMContext /*&*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", Mang=" + Mang // NOI18N
              + ", AsmSymbols=" + AsmSymbols // NOI18N
              + super.toString(); // NOI18N
  }
}
