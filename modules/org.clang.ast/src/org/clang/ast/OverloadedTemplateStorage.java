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

package org.clang.ast;

import java.util.Iterator;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;


/// \brief A structure for storing the information associated with an
/// overloaded template name.
//<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 93,
 FQN="clang::OverloadedTemplateStorage", NM="_ZN5clang25OverloadedTemplateStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang25OverloadedTemplateStorageE")
//</editor-fold>
public class OverloadedTemplateStorage extends /*public*/ UncommonTemplateNameStorage implements Iterable<NamedDecl /*P*/> {
  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage::OverloadedTemplateStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 96,
   FQN="clang::OverloadedTemplateStorage::OverloadedTemplateStorage", NM="_ZN5clang25OverloadedTemplateStorageC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang25OverloadedTemplateStorageC1Ej")
  //</editor-fold>
  /*friend*//*package*/ OverloadedTemplateStorage(/*uint*/int size) {
    // : UncommonTemplateNameStorage(Overloaded, size) 
    //START JInit
    super(Kind.Overloaded, size);
    Storage = create_type$ptr(new NamedDecl[size]);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 99,
   FQN="clang::OverloadedTemplateStorage::getStorage", NM="_ZN5clang25OverloadedTemplateStorage10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang25OverloadedTemplateStorage10getStorageEv")
  //</editor-fold>
  /*friend*/protected/*private*/ type$ptr<NamedDecl /*P*/ /*P*/> getStorage() {
    return $tryClone(Storage);//((type$ptr<NamedDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 102,
   FQN="clang::OverloadedTemplateStorage::getStorage", NM="_ZNK5clang25OverloadedTemplateStorage10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang25OverloadedTemplateStorage10getStorageEv")
  //</editor-fold>
  /*friend*/protected/*private*/ type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> getStorage$Const() /*const*/ {
    return $tryClone(Storage);//((type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

/*public:*/
  /*typedef NamedDecl *const *iterator*/
//  public final class iterator extends type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 109,
   FQN="clang::OverloadedTemplateStorage::begin", NM="_ZNK5clang25OverloadedTemplateStorage5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang25OverloadedTemplateStorage5beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> begin() /*const*/ {
    return getStorage$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadedTemplateStorage::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 110,
   FQN="clang::OverloadedTemplateStorage::end", NM="_ZNK5clang25OverloadedTemplateStorage3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang25OverloadedTemplateStorage3endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> end() /*const*/ {
    return getStorage$Const().$add(size());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> Storage;

  @Override
  public Iterator<NamedDecl> iterator() {
    return new JavaIterator<NamedDecl>(begin(), end());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
