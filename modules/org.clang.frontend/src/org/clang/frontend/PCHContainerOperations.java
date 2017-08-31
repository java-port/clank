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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.frontend.*;


/// A registry of PCHContainerWriter and -Reader objects for different formats.
//<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 96,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 92,
 FQN="clang::PCHContainerOperations", NM="_ZN5clang22PCHContainerOperationsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperationsE")
//</editor-fold>
public class PCHContainerOperations implements Destructors.ClassWithDestructor {
  private StringMap<std.unique_ptr<PCHContainerWriter>> Writers;
  private StringMap<std.unique_ptr<PCHContainerReader>> Readers;
/*public:*/
  /// Automatically registers a RawPCHContainerWriter and
  /// RawPCHContainerReader.
  /// Automatically registers a RawPCHContainerWriter and
  /// RawPCHContainerReader.
  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::PCHContainerOperations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp", old_line = 63,
   FQN="clang::PCHContainerOperations::PCHContainerOperations", NM="_ZN5clang22PCHContainerOperationsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PCHContainerOperations.cpp -nm=_ZN5clang22PCHContainerOperationsC1Ev")
  //</editor-fold>
  public PCHContainerOperations() {
    // : Writers(), Readers() 
    //START JInit
    this.Writers = new StringMap<std.unique_ptr<PCHContainerWriter>>(new std.unique_ptr<PCHContainerWriter>());
    this.Readers = new StringMap<std.unique_ptr<PCHContainerReader>>(new std.unique_ptr<PCHContainerReader>());
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      registerWriter($c$.track(new std.unique_ptr<PCHContainerWriter>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RawPCHContainerWriter()))))); $c$.clean();
      registerReader($c$.track(new std.unique_ptr<PCHContainerReader>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RawPCHContainerReader()))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::registerWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 99,
   FQN="clang::PCHContainerOperations::registerWriter", NM="_ZN5clang22PCHContainerOperations14registerWriterESt10unique_ptrINS_18PCHContainerWriterESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperations14registerWriterESt10unique_ptrINS_18PCHContainerWriterESt14default_deleteIS2_EE")
  //</editor-fold>
  public void registerWriter(std.unique_ptr<PCHContainerWriter> Writer) {
    Writers.$at(Writer.$arrow().getFormat()).$assignMove(std.move(Writer));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::registerReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 102,
   FQN="clang::PCHContainerOperations::registerReader", NM="_ZN5clang22PCHContainerOperations14registerReaderESt10unique_ptrINS_18PCHContainerReaderESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperations14registerReaderESt10unique_ptrINS_18PCHContainerReaderESt14default_deleteIS2_EE")
  //</editor-fold>
  public void registerReader(std.unique_ptr<PCHContainerReader> Reader) {
    Readers.$at(Reader.$arrow().getFormat()).$assignMove(std.move(Reader));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::getWriterOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 105,
   FQN="clang::PCHContainerOperations::getWriterOrNull", NM="_ZN5clang22PCHContainerOperations15getWriterOrNullEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperations15getWriterOrNullEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ PCHContainerWriter /*P*/ getWriterOrNull(StringRef Format) {
    return Writers.$at(/*NO_COPY*/Format).get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::getReaderOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 108,
   FQN="clang::PCHContainerOperations::getReaderOrNull", NM="_ZN5clang22PCHContainerOperations15getReaderOrNullEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperations15getReaderOrNullEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ PCHContainerReader /*P*/ getReaderOrNull(StringRef Format) {
    return Readers.$at(/*NO_COPY*/Format).get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::getRawReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 111,
   FQN="clang::PCHContainerOperations::getRawReader", NM="_ZN5clang22PCHContainerOperations12getRawReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperations12getRawReaderEv")
  //</editor-fold>
  public /*const*/ PCHContainerReader /*&*/ getRawReader() {
    return /*Deref*/getReaderOrNull(new StringRef(/*KEEP_STR*/"raw"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHContainerOperations::~PCHContainerOperations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/PCHContainerOperations.h", old_line = 92,
   FQN="clang::PCHContainerOperations::~PCHContainerOperations", NM="_ZN5clang22PCHContainerOperationsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN5clang22PCHContainerOperationsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Readers.$destroy();
    Writers.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writers=" + Writers // NOI18N
              + ", Readers=" + Readers; // NOI18N
  }
}
