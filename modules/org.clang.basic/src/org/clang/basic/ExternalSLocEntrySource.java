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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

// end SrcMgr namespace.

/// \brief External source of source location entries.
//<editor-fold defaultstate="collapsed" desc="clang::ExternalSLocEntrySource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 439,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 440,
 FQN="clang::ExternalSLocEntrySource", NM="_ZN5clang23ExternalSLocEntrySourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang23ExternalSLocEntrySourceE")
//</editor-fold>
public abstract interface/*class*/ ExternalSLocEntrySource extends Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSLocEntrySource::~ExternalSLocEntrySource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2216,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2201,
   FQN="clang::ExternalSLocEntrySource::~ExternalSLocEntrySource", NM="_ZN5clang23ExternalSLocEntrySourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang23ExternalSLocEntrySourceD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$ExternalSLocEntrySource() {
  }


  
  /// \brief Read the source location entry with index ID, which will always be
  /// less than -1.
  ///
  /// \returns true if an error occurred that prevented the source-location
  /// entry from being loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSLocEntrySource::ReadSLocEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 449,
   FQN="clang::ExternalSLocEntrySource::ReadSLocEntry", NM="_ZN5clang23ExternalSLocEntrySource13ReadSLocEntryEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang23ExternalSLocEntrySource13ReadSLocEntryEi")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ boolean ReadSLocEntry(int ID)/* = 0*/;

  
  /// \brief Retrieve the module import location and name for the given ID, if
  /// in fact it was loaded from a module (rather than, say, a precompiled
  /// header).
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSLocEntrySource::getModuleImportLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 453,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 454,
   FQN="clang::ExternalSLocEntrySource::getModuleImportLoc", NM="_ZN5clang23ExternalSLocEntrySource18getModuleImportLocEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang23ExternalSLocEntrySource18getModuleImportLocEi")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ std.pairTypeType<SourceLocation, StringRef> getModuleImportLoc(int ID)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSLocEntrySource::ExternalSLocEntrySource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 439,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 440,
   FQN="clang::ExternalSLocEntrySource::ExternalSLocEntrySource", NM="_ZN5clang23ExternalSLocEntrySourceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang23ExternalSLocEntrySourceC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ExternalSLocEntrySource() {
  }

}
