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

package org.clang.sema;

import org.clank.support.*;
import org.clang.ast.*;


/// \brief Consumes visible declarations found when searching for
/// all visible names within a given scope or context.
///
/// This abstract class is meant to be subclassed by clients of \c
/// Sema::LookupVisibleDecls(), each of which should override the \c
/// FoundDecl() function to process declarations as they are found.
//<editor-fold defaultstate="collapsed" desc="clang::VisibleDeclConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 742,
 FQN="clang::VisibleDeclConsumer", NM="_ZN5clang19VisibleDeclConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang19VisibleDeclConsumerE")
//</editor-fold>
public abstract class VisibleDeclConsumer implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Destroys the visible declaration consumer.
  
  //----------------------------------------------------------------------------
  // Search for all visible declarations.
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleDeclConsumer::~VisibleDeclConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3326,
   FQN="clang::VisibleDeclConsumer::~VisibleDeclConsumer", NM="_ZN5clang19VisibleDeclConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang19VisibleDeclConsumerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief Determine whether hidden declarations (from unimported
  /// modules) should be given to this consumer. By default, they
  /// are not included.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleDeclConsumer::includeHiddenDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3328,
   FQN="clang::VisibleDeclConsumer::includeHiddenDecls", NM="_ZNK5clang19VisibleDeclConsumer18includeHiddenDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang19VisibleDeclConsumer18includeHiddenDeclsEv")
  //</editor-fold>
  public boolean includeHiddenDecls() /*const*/ {
    return false;
  }

  
  /// \brief Invoked each time \p Sema::LookupVisibleDecls() finds a
  /// declaration visible from the current scope or context.
  ///
  /// \param ND the declaration found.
  ///
  /// \param Hiding a declaration that hides the declaration \p ND,
  /// or NULL if no such declaration exists.
  ///
  /// \param Ctx the original context from which the lookup started.
  ///
  /// \param InBaseClass whether this declaration was found in base
  /// class of the context we searched.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleDeclConsumer::FoundDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 764,
   FQN="clang::VisibleDeclConsumer::FoundDecl", NM="_ZN5clang19VisibleDeclConsumer9FoundDeclEPNS_9NamedDeclES2_PNS_11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang19VisibleDeclConsumer9FoundDeclEPNS_9NamedDeclES2_PNS_11DeclContextEb")
  //</editor-fold>
  public abstract /*virtual*/ void FoundDecl(NamedDecl /*P*/ ND, NamedDecl /*P*/ Hiding, DeclContext /*P*/ Ctx, 
           boolean InBaseClass)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::VisibleDeclConsumer::VisibleDeclConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 742,
   FQN="clang::VisibleDeclConsumer::VisibleDeclConsumer", NM="_ZN5clang19VisibleDeclConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang19VisibleDeclConsumerC1Ev")
  //</editor-fold>
  public /*inline*/ VisibleDeclConsumer() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
