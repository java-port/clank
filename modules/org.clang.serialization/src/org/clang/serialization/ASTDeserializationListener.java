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

package org.clang.serialization;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;

//<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 30,
 FQN="clang::ASTDeserializationListener", NM="_ZN5clang26ASTDeserializationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListenerE")
//</editor-fold>
public interface/*class*/ ASTDeserializationListener extends org.clang.ast.ASTDeserializationListenerImplementation, Destructors.ClassWithDestructor {
/*public:*/
  
  // Give ASTDeserializationListener's VTable a home.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::~ASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 24,
   FQN="clang::ASTDeserializationListener::~ASTDeserializationListener", NM="_ZN5clang26ASTDeserializationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListenerD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$ASTDeserializationListener() {
  }

  
  /// \brief The ASTReader was initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::ReaderInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 35,
   FQN="clang::ASTDeserializationListener::ReaderInitialized", NM="_ZN5clang26ASTDeserializationListener17ReaderInitializedEPNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener17ReaderInitializedEPNS_9ASTReaderE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void ReaderInitialized(ASTReader /*P*/ Reader) {
  }

  
  /// \brief An identifier was deserialized from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::IdentifierRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 38,
   FQN="clang::ASTDeserializationListener::IdentifierRead", NM="_ZN5clang26ASTDeserializationListener14IdentifierReadEjPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener14IdentifierReadEjPNS_14IdentifierInfoE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void IdentifierRead(/*uint32_t*/int ID, 
                IdentifierInfo /*P*/ II) {
  }

  /// \brief A macro was read from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::MacroRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 41,
   FQN="clang::ASTDeserializationListener::MacroRead", NM="_ZN5clang26ASTDeserializationListener9MacroReadEjPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener9MacroReadEjPNS_9MacroInfoE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void MacroRead(/*uint32_t*/int ID, MacroInfo /*P*/ MI) {
  }

  /// \brief A type was deserialized from the AST file. The ID here has the
  ///        qualifier bits already removed, and T is guaranteed to be locally
  ///        unqualified.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::TypeRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 45,
   FQN="clang::ASTDeserializationListener::TypeRead", NM="_ZN5clang26ASTDeserializationListener8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void TypeRead(TypeIdx Idx, QualType T) {
  }

  /// \brief A decl was deserialized from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::DeclRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 47,
   FQN="clang::ASTDeserializationListener::DeclRead", NM="_ZN5clang26ASTDeserializationListener8DeclReadEjPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener8DeclReadEjPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void DeclRead(/*uint32_t*/int ID, /*const*/ Decl /*P*/ D) {
  }

  /// \brief A selector was read from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::SelectorRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 49,
   FQN="clang::ASTDeserializationListener::SelectorRead", NM="_ZN5clang26ASTDeserializationListener12SelectorReadEjNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener12SelectorReadEjNS_8SelectorE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void SelectorRead(/*uint32_t*/int iD, Selector Sel) {
  }

  /// \brief A macro definition was read from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::MacroDefinitionRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 51,
   FQN="clang::ASTDeserializationListener::MacroDefinitionRead", NM="_ZN5clang26ASTDeserializationListener19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void MacroDefinitionRead(/*uint32_t*/int $Prm0, 
                     MacroDefinitionRecord /*P*/ MD) {
  }

  /// \brief A module definition was read from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::ModuleRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 54,
   FQN="clang::ASTDeserializationListener::ModuleRead", NM="_ZN5clang26ASTDeserializationListener10ModuleReadEjPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang26ASTDeserializationListener10ModuleReadEjPNS_6ModuleE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void ModuleRead(/*uint32_t*/int ID, Module /*P*/ Mod) {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeserializationListener::ASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTDeserializationListener.h", line = 30,
   FQN="clang::ASTDeserializationListener::ASTDeserializationListener", NM="_ZN5clang26ASTDeserializationListenerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang26ASTDeserializationListenerC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ASTDeserializationListener() {
  }

}
