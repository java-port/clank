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

//<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 127,
 FQN="llvm::object::SymbolicFile", NM="_ZN4llvm6object12SymbolicFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFileE")
//</editor-fold>
public abstract class SymbolicFile extends /*public*/ Binary implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::~SymbolicFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 129,
   FQN="llvm::object::SymbolicFile::~SymbolicFile", NM="_ZN4llvm6object12SymbolicFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFileD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::SymbolicFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 130,
   FQN="llvm::object::SymbolicFile::SymbolicFile", NM="_ZN4llvm6object12SymbolicFileC1EjNS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFileC1EjNS_15MemoryBufferRefE")
  //</editor-fold>
  public SymbolicFile(/*uint*/int Type, MemoryBufferRef Source) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // virtual interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::moveSymbolNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 133,
   FQN="llvm::object::SymbolicFile::moveSymbolNext", NM="_ZNK4llvm6object12SymbolicFile14moveSymbolNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile14moveSymbolNextERNS0_11DataRefImplE")
  //</editor-fold>
  public abstract /*virtual*/ void moveSymbolNext(final DataRefImpl /*&*/ Symb) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::printSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 135,
   FQN="llvm::object::SymbolicFile::printSymbolName", NM="_ZNK4llvm6object12SymbolicFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE")
  //</editor-fold>
  public abstract /*virtual*/ std.error_code printSymbolName(final raw_ostream /*&*/ OS, 
                 DataRefImpl Symb) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::getSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 138,
   FQN="llvm::object::SymbolicFile::getSymbolFlags", NM="_ZNK4llvm6object12SymbolicFile14getSymbolFlagsENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile14getSymbolFlagsENS0_11DataRefImplE")
  //</editor-fold>
  public abstract /*virtual*/ /*uint32_t*/int getSymbolFlags(DataRefImpl Symb) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::symbol_begin_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 140,
   FQN="llvm::object::SymbolicFile::symbol_begin_impl", NM="_ZNK4llvm6object12SymbolicFile17symbol_begin_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile17symbol_begin_implEv")
  //</editor-fold>
  public abstract /*virtual*/ content_iterator<BasicSymbolRef> symbol_begin_impl() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::symbol_end_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 142,
   FQN="llvm::object::SymbolicFile::symbol_end_impl", NM="_ZNK4llvm6object12SymbolicFile15symbol_end_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile15symbol_end_implEv")
  //</editor-fold>
  public abstract /*virtual*/ content_iterator<BasicSymbolRef> symbol_end_impl() /*const*//* = 0*/;

  
  // convenience wrappers.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 145,
   FQN="llvm::object::SymbolicFile::symbol_begin", NM="_ZNK4llvm6object12SymbolicFile12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile12symbol_beginEv")
  //</editor-fold>
  public content_iterator<BasicSymbolRef> symbol_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::symbol_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 148,
   FQN="llvm::object::SymbolicFile::symbol_end", NM="_ZNK4llvm6object12SymbolicFile10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile10symbol_endEv")
  //</editor-fold>
  public content_iterator<BasicSymbolRef> symbol_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // JAVA: typedef iterator_range<basic_symbol_iterator> basic_symbol_iterator_range
//  public final class basic_symbol_iterator_range extends iterator_range</*const*/ BasicSymbolRef /*&*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::symbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 152,
   FQN="llvm::object::SymbolicFile::symbols", NM="_ZNK4llvm6object12SymbolicFile7symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm6object12SymbolicFile7symbolsEv")
  //</editor-fold>
  public iterator_range</*const*/ BasicSymbolRef /*&*/ > symbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // construction aux.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::createSymbolicFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 157,
   FQN="llvm::object::SymbolicFile::createSymbolicFile", NM="_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_15MemoryBufferRefENS_3sys2fs10file_magicEPNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_15MemoryBufferRefENS_3sys2fs10file_magicEPNS_11LLVMContextE")
  //</editor-fold>
  public static Expected<std.unique_ptr<SymbolicFile> > createSymbolicFile(MemoryBufferRef Object, fs.file_magic Type, 
                    LLVMContext /*P*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::createSymbolicFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 161,
   FQN="llvm::object::SymbolicFile::createSymbolicFile", NM="_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_15MemoryBufferRefE")
  //</editor-fold>
  public static Expected<std.unique_ptr<SymbolicFile> > createSymbolicFile(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::createSymbolicFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 165,
   FQN="llvm::object::SymbolicFile::createSymbolicFile", NM="_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFile18createSymbolicFileENS_9StringRefE")
  //</editor-fold>
  public static Expected<OwningBinary<SymbolicFile> > createSymbolicFile(StringRef ObjectPath) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolicFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 168,
   FQN="llvm::object::SymbolicFile::classof", NM="_ZN4llvm6object12SymbolicFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object12SymbolicFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public SymbolicFile() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
