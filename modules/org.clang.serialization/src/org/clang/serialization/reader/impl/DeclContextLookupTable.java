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

package org.clang.serialization.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.serialization.*;
import org.clang.serialization.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::DeclContextLookupTable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 113,
 FQN="clang::serialization::reader::DeclContextLookupTable", NM="_ZN5clang13serialization6reader22DeclContextLookupTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader22DeclContextLookupTableE")
//</editor-fold>
public class/*struct*/ DeclContextLookupTable implements Destructors.ClassWithDestructor, NativeCloneable<DeclContextLookupTable>, NativeMoveable<DeclContextLookupTable> {
  public MultiOnDiskHashTable<DeclarationName, DeclarationNameKey, SmallVectorUInt, ASTDeclContextNameLookupTrait.data_type_builder, ModuleFile> Table;
  
  // These look redundant, but don't remove them -- they work around MSVC 2013's
  // inability to synthesize move operations. Without them, the
  // MultiOnDiskHashTable will be copied (despite being move-only!).
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::DeclContextLookupTable::DeclContextLookupTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 119,
   FQN="clang::serialization::reader::DeclContextLookupTable::DeclContextLookupTable", NM="_ZN5clang13serialization6reader22DeclContextLookupTableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader22DeclContextLookupTableC1Ev")
  //</editor-fold>
  private/*use EMPTY_VALUE for default value in collections*/ DeclContextLookupTable() {
    // : Table() 
    //START JInit
    this.Table = new MultiOnDiskHashTable<>(new ASTDeclContextNameLookupTrait());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::DeclContextLookupTable::DeclContextLookupTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 120,
   FQN="clang::serialization::reader::DeclContextLookupTable::DeclContextLookupTable", NM="_ZN5clang13serialization6reader22DeclContextLookupTableC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader22DeclContextLookupTableC1EOS2_")
  //</editor-fold>
  public DeclContextLookupTable(JD$Move _dparam, final DeclContextLookupTable /*&&*/O) {
    // : Table(std::move(O.Table)) 
    //START JInit
    this.Table = new MultiOnDiskHashTable<>(JD$Move.INSTANCE, std.move(O.Table));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::DeclContextLookupTable::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 122,
   FQN="clang::serialization::reader::DeclContextLookupTable::operator=", NM="_ZN5clang13serialization6reader22DeclContextLookupTableaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader22DeclContextLookupTableaSEOS2_")
  //</editor-fold>
  public DeclContextLookupTable /*&*/ $assignMove(final DeclContextLookupTable /*&&*/O) {
    Table.$assignMove(std.move(O.Table));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::DeclContextLookupTable::~DeclContextLookupTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 113,
   FQN="clang::serialization::reader::DeclContextLookupTable::~DeclContextLookupTable", NM="_ZN5clang13serialization6reader22DeclContextLookupTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13serialization6reader22DeclContextLookupTableD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Table.$destroy();
    //END JDestroy
  }
  
  public static final DeclContextLookupTable EMPTY_VALUE = new DeclContextLookupTable();
  @Override
  public DeclContextLookupTable clone() {
    assert this == EMPTY_VALUE : "only empty tables can be cloned from collections. Forgot to use DeclContextLookupTable.EMPTY vs new DeclContextLookupTable()?";
    return new DeclContextLookupTable();
  }

  @Override
  public DeclContextLookupTable move() {
    return new DeclContextLookupTable(JD$Move.INSTANCE, this);
  }

  
  @Override public String toString() {
    return "" + "Table=" + Table; // NOI18N
  }
}
