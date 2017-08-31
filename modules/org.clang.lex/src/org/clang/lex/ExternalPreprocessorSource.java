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

package org.clang.lex;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Abstract interface for external sources of preprocessor 
/// information.
///
/// This abstract class allows an external sources (such as the \c ASTReader) 
/// to provide additional preprocessing information.
//<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 27,
 FQN="clang::ExternalPreprocessorSource", NM="_ZN5clang26ExternalPreprocessorSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSourceE")
//</editor-fold>
public abstract interface/*class*/ ExternalPreprocessorSource extends Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::~ExternalPreprocessorSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 60,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 57,
   FQN="clang::ExternalPreprocessorSource::~ExternalPreprocessorSource", NM="_ZN5clang26ExternalPreprocessorSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang26ExternalPreprocessorSourceD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$ExternalPreprocessorSource() {
  }


  
  /// \brief Read the set of macros defined by this external macro source.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::ReadDefinedMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 32,
   FQN="clang::ExternalPreprocessorSource::ReadDefinedMacros", NM="_ZN5clang26ExternalPreprocessorSource17ReadDefinedMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSource17ReadDefinedMacrosEv")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ void ReadDefinedMacros()/* = 0*/;

  
  /// \brief Update an out-of-date identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::updateOutOfDateIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 35,
   FQN="clang::ExternalPreprocessorSource::updateOutOfDateIdentifier", NM="_ZN5clang26ExternalPreprocessorSource25updateOutOfDateIdentifierERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSource25updateOutOfDateIdentifierERNS_14IdentifierInfoE")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ void updateOutOfDateIdentifier(final IdentifierInfo /*&*/ II)/* = 0*/;

  
  /// \brief Return the identifier associated with the given ID number.
  ///
  /// The ID 0 is associated with the NULL identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::GetIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 40,
   FQN="clang::ExternalPreprocessorSource::GetIdentifier", NM="_ZN5clang26ExternalPreprocessorSource13GetIdentifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSource13GetIdentifierEj")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ IdentifierInfo /*P*/ GetIdentifier(/*uint*/int ID)/* = 0*/;

  
  /// \brief Map a module ID to a module.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 43,
   FQN="clang::ExternalPreprocessorSource::getModule", NM="_ZN5clang26ExternalPreprocessorSource9getModuleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSource9getModuleEj")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ Module /*P*/ getModule(/*uint*/int ModuleID)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessorSource::ExternalPreprocessorSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ExternalPreprocessorSource.h", line = 27,
   FQN="clang::ExternalPreprocessorSource::ExternalPreprocessorSource", NM="_ZN5clang26ExternalPreprocessorSourceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang26ExternalPreprocessorSourceC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ExternalPreprocessorSource() {
  }

}
