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

package org.clang.codegen;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import org.clang.frontend.*;


/// A PCHContainerWriter implementation that uses LLVM to
/// wraps Clang modules inside a COFF, ELF, or Mach-O container.
//<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 19,
 FQN="clang::ObjectFilePCHContainerWriter", NM="_ZN5clang28ObjectFilePCHContainerWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN5clang28ObjectFilePCHContainerWriterE")
//</editor-fold>
public class ObjectFilePCHContainerWriter extends /*public*/ PCHContainerWriter implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerWriter::getFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 20,
   FQN="clang::ObjectFilePCHContainerWriter::getFormat", NM="_ZNK5clang28ObjectFilePCHContainerWriter9getFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK5clang28ObjectFilePCHContainerWriter9getFormatEv")
  //</editor-fold>
  @Override public/*private*/ StringRef getFormat() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"obj");
  }

  
  /// Return an ASTConsumer that can be chained with a
  /// PCHGenerator that produces a wrapper file format
  /// that also contains full debug info for the module.
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerWriter::CreatePCHContainerGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 305,
   FQN="clang::ObjectFilePCHContainerWriter::CreatePCHContainerGenerator", NM="_ZNK5clang28ObjectFilePCHContainerWriter27CreatePCHContainerGeneratorERNS_16CompilerInstanceERKSsS4_St10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS7_EESt10shared_ptrINS_9PCHBufferEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK5clang28ObjectFilePCHContainerWriter27CreatePCHContainerGeneratorERNS_16CompilerInstanceERKSsS4_St10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS7_EESt10shared_ptrINS_9PCHBufferEE")
  //</editor-fold>
  @Override public/*private*/ std.unique_ptr<ASTConsumer> CreatePCHContainerGenerator(final CompilerInstance /*&*/ CI, final /*const*/std.string/*&*/ MainFileName, 
                             final /*const*/std.string/*&*/ OutputFileName, 
                             std.unique_ptr<raw_pwrite_stream> OS, 
                             std.shared_ptr<PCHBuffer> Buffer) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PCHContainerGenerator(CI, MainFileName, OutputFileName, std.move(OS), Buffer)))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerWriter::~ObjectFilePCHContainerWriter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 19,
   FQN="clang::ObjectFilePCHContainerWriter::~ObjectFilePCHContainerWriter", NM="_ZN5clang28ObjectFilePCHContainerWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN5clang28ObjectFilePCHContainerWriterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
//    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerWriter::ObjectFilePCHContainerWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 19,
   FQN="clang::ObjectFilePCHContainerWriter::ObjectFilePCHContainerWriter", NM="_ZN5clang28ObjectFilePCHContainerWriterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN5clang28ObjectFilePCHContainerWriterC1Ev")
  //</editor-fold>
  public /*inline*/ ObjectFilePCHContainerWriter() {
    // : PCHContainerWriter() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
