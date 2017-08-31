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

import org.clank.java.*;
import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;


// This ASTDeserializationListener forwards its notifications to a set of
// child listeners.
//<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 27,
 FQN="clang::MultiplexASTDeserializationListener", NM="_ZN5clang35MultiplexASTDeserializationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListenerE")
//</editor-fold>
public class MultiplexASTDeserializationListener implements /*public*/ ASTDeserializationListener, Destructors.ClassWithDestructor {
/*public:*/
  // Does NOT take ownership of the elements in L.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::MultiplexASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 48,
   FQN="clang::MultiplexASTDeserializationListener::MultiplexASTDeserializationListener", NM="_ZN5clang35MultiplexASTDeserializationListenerC1ERKSt6vectorIPNS_26ASTDeserializationListenerESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListenerC1ERKSt6vectorIPNS_26ASTDeserializationListenerESaIS3_EE")
  //</editor-fold>
  public MultiplexASTDeserializationListener(/*const*/std.vector<ASTDeserializationListener /*P*/ > /*&*/ L) {
    // : ASTDeserializationListener(), Listeners(L) 
    //START JInit
    $ASTDeserializationListener();
    this.Listeners = new std.vector<ASTDeserializationListener /*P*/ >(L);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::ReaderInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 53,
   FQN="clang::MultiplexASTDeserializationListener::ReaderInitialized", NM="_ZN5clang35MultiplexASTDeserializationListener17ReaderInitializedEPNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener17ReaderInitializedEPNS_9ASTReaderE")
  //</editor-fold>
  @Override public void ReaderInitialized(ASTReader /*P*/ Reader)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).ReaderInitialized(Reader);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::IdentifierRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 59,
   FQN="clang::MultiplexASTDeserializationListener::IdentifierRead", NM="_ZN5clang35MultiplexASTDeserializationListener14IdentifierReadEjPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener14IdentifierReadEjPNS_14IdentifierInfoE")
  //</editor-fold>
  @Override public void IdentifierRead(/*uint32_t*/int ID, IdentifierInfo /*P*/ II)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).IdentifierRead(ID, II);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::MacroRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 65,
   FQN="clang::MultiplexASTDeserializationListener::MacroRead", NM="_ZN5clang35MultiplexASTDeserializationListener9MacroReadEjPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener9MacroReadEjPNS_9MacroInfoE")
  //</editor-fold>
  @Override public void MacroRead(/*uint32_t*/int ID, MacroInfo /*P*/ MI)/* override*/ {
    for (ASTDeserializationListener /*P*/ /*&*/ Listener : Listeners)  {
      Listener.MacroRead(ID, MI);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::TypeRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 71,
   FQN="clang::MultiplexASTDeserializationListener::TypeRead", NM="_ZN5clang35MultiplexASTDeserializationListener8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE")
  //</editor-fold>
  @Override public void TypeRead(TypeIdx Idx, QualType T)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).TypeRead(new TypeIdx(Idx), new QualType(T));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::DeclRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 77,
   FQN="clang::MultiplexASTDeserializationListener::DeclRead", NM="_ZN5clang35MultiplexASTDeserializationListener8DeclReadEjPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener8DeclReadEjPKNS_4DeclE")
  //</editor-fold>
  @Override public void DeclRead(/*uint32_t*/int ID, /*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).DeclRead(ID, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::SelectorRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 83,
   FQN="clang::MultiplexASTDeserializationListener::SelectorRead", NM="_ZN5clang35MultiplexASTDeserializationListener12SelectorReadEjNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener12SelectorReadEjNS_8SelectorE")
  //</editor-fold>
  @Override public void SelectorRead(/*uint32_t*/int ID, Selector Sel)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).SelectorRead(ID, new Selector(Sel));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::MacroDefinitionRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 89,
   FQN="clang::MultiplexASTDeserializationListener::MacroDefinitionRead", NM="_ZN5clang35MultiplexASTDeserializationListener19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE")
  //</editor-fold>
  @Override public void MacroDefinitionRead(/*uint32_t*/int ID, MacroDefinitionRecord /*P*/ MD)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).MacroDefinitionRead(ID, MD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::ModuleRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 95,
   FQN="clang::MultiplexASTDeserializationListener::ModuleRead", NM="_ZN5clang35MultiplexASTDeserializationListener10ModuleReadEjPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListener10ModuleReadEjPNS_6ModuleE")
  //</editor-fold>
  @Override public void ModuleRead(/*uint32_t*/int ID, Module /*P*/ Mod)/* override*/ {
    for (ASTDeserializationListener /*P*/ /*&*/ Listener : Listeners)  {
      Listener.ModuleRead(ID, Mod);
    }
  }

/*private:*/
  private std.vector<ASTDeserializationListener /*P*/ > Listeners;
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTDeserializationListener::~MultiplexASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 27,
   FQN="clang::MultiplexASTDeserializationListener::~MultiplexASTDeserializationListener", NM="_ZN5clang35MultiplexASTDeserializationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang35MultiplexASTDeserializationListenerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Listeners.$destroy();
    //~ASTDeserializationListener;
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Listeners=" + Listeners // NOI18N
              + super.toString(); // NOI18N
  }
}
