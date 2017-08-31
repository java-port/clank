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

package org.clang.frontend.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 39,
 FQN="(anonymous namespace)::DelegatingDeserializationListener", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListenerE")
//</editor-fold>
public class DelegatingDeserializationListener implements /*public*/ ASTDeserializationListener, Destructors.ClassWithDestructor {
  private ASTDeserializationListener /*P*/ Previous;
  private boolean DeletePrevious;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::DelegatingDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 44,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::DelegatingDeserializationListener", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListenerC1EPN5clang26ASTDeserializationListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListenerC1EPN5clang26ASTDeserializationListenerEb")
  //</editor-fold>
  public /*explicit*/ DelegatingDeserializationListener(ASTDeserializationListener /*P*/ Previous, boolean DeletePrevious) {
    // : ASTDeserializationListener(), Previous(Previous), DeletePrevious(DeletePrevious) 
    //START JInit
    $ASTDeserializationListener();
    this.Previous = Previous;
    this.DeletePrevious = DeletePrevious;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::~DelegatingDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 47,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::~DelegatingDeserializationListener", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListenerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (DeletePrevious) {
      if (Previous != null) { Previous.$destroy();};
    }
    //~ASTDeserializationListener;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::ReaderInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 52,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::ReaderInitialized", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener17ReaderInitializedEPN5clang9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener17ReaderInitializedEPN5clang9ASTReaderE")
  //</editor-fold>
  @Override public void ReaderInitialized(ASTReader /*P*/ Reader)/* override*/ {
    if ((Previous != null)) {
      Previous.ReaderInitialized(Reader);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::IdentifierRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 56,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::IdentifierRead", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener14IdentifierReadEjPN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener14IdentifierReadEjPN5clang14IdentifierInfoE")
  //</editor-fold>
  @Override public void IdentifierRead(/*uint32_t*/int ID, 
                IdentifierInfo /*P*/ II)/* override*/ {
    if ((Previous != null)) {
      Previous.IdentifierRead(ID, II);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::TypeRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 61,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::TypeRead", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener8TypeReadEN5clang13serialization7TypeIdxENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener8TypeReadEN5clang13serialization7TypeIdxENS1_8QualTypeE")
  //</editor-fold>
  @Override public void TypeRead(TypeIdx Idx, QualType T)/* override*/ {
    if ((Previous != null)) {
      Previous.TypeRead(new TypeIdx(Idx), new QualType(T));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::DeclRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 65,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::DeclRead", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener8DeclReadEjPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener8DeclReadEjPKN5clang4DeclE")
  //</editor-fold>
  @Override public void DeclRead(/*uint32_t*/int ID, /*const*/ Decl /*P*/ D)/* override*/ {
    if ((Previous != null)) {
      Previous.DeclRead(ID, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::SelectorRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 69,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::SelectorRead", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener12SelectorReadEjN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener12SelectorReadEjN5clang8SelectorE")
  //</editor-fold>
  @Override public void SelectorRead(/*uint32_t*/int ID, Selector Sel)/* override*/ {
    if ((Previous != null)) {
      Previous.SelectorRead(ID, new Selector(Sel));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DelegatingDeserializationListener::MacroDefinitionRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 73,
   FQN="(anonymous namespace)::DelegatingDeserializationListener::MacroDefinitionRead", NM="_ZN12_GLOBAL__N_133DelegatingDeserializationListener19MacroDefinitionReadEjPN5clang21MacroDefinitionRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_133DelegatingDeserializationListener19MacroDefinitionReadEjPN5clang21MacroDefinitionRecordE")
  //</editor-fold>
  @Override public void MacroDefinitionRead(/*uint32_t*/int PPID, 
                     MacroDefinitionRecord /*P*/ MD)/* override*/ {
    if ((Previous != null)) {
      Previous.MacroDefinitionRead(PPID, MD);
    }
  }

  
  @Override public String toString() {
    return "" + "Previous=" + Previous // NOI18N
              + ", DeletePrevious=" + DeletePrevious // NOI18N
              + super.toString(); // NOI18N
  }
}
