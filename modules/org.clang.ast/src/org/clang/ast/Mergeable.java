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

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clang.ast.AstClangGlobals.*;


/// \brief Provides common interface for the Decls that cannot be redeclared,
/// but can be merged if the same declaration is brought in from multiple
/// modules.
/*template <typename decl_type> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Mergeable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 256,
 FQN="clang::Mergeable", NM="_ZN5clang9MergeableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang9MergeableE")
//</editor-fold>
public interface/*class*/ Mergeable</*typename*/ decl_type extends Decl & Mergeable>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Mergeable::Mergeable<decl_type>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 259,
   FQN="clang::Mergeable::Mergeable<decl_type>", NM="_ZN5clang9MergeableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang9MergeableC1Ev")
  //</editor-fold>
  public default/*interface*/ void $Mergeable() {
    assert !(this instanceof Redeclarable) : "can not be Mergeable and Redeclarable at the same time" + this.getClass();
  }

  
  /// \brief Return the first declaration of this declaration or itself if this
  /// is the only declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Mergeable::getFirstDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 263,
   FQN="clang::Mergeable::getFirstDecl", NM="_ZN5clang9Mergeable12getFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang9Mergeable12getFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ decl_type /*P*/ getFirstDecl() {
    decl_type /*P*/ D = ((/*static_cast*/decl_type /*P*/ )(this));
    if (Native.$not(D.isFromASTFile())) {
      return D;
    }
    return cast(getDeclType$Mergeable(), getPrimaryMergedDecl(((/*const_cast*/decl_type /*P*/ )(D))));
  }

  
  /// \brief Return the first declaration of this declaration or itself if this
  /// is the only declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Mergeable::getFirstDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 272,
   FQN="clang::Mergeable::getFirstDecl", NM="_ZNK5clang9Mergeable12getFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang9Mergeable12getFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ decl_type /*P*/ getFirstDecl$Const() /*const*/ {
    /*const*/ decl_type /*P*/ D = ((/*static_cast*//*const*/ decl_type /*P*/ )(this));
    if (Native.$not(D.isFromASTFile())) {
      return D;
    }
    return cast(getDeclType$Mergeable(), getPrimaryMergedDecl(((/*const_cast*/decl_type /*P*/ )(D))));
  }

  
  /// \brief Returns true if this is the first declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Mergeable::isFirstDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 280,
   FQN="clang::Mergeable::isFirstDecl", NM="_ZNK5clang9Mergeable11isFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang9Mergeable11isFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ boolean isFirstDecl$Mergeable() /*const*/ {
    return getFirstDecl() == this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $destroy$Mergeable() { /*for derived classes*/ }
  
  //public default/*interface*/ decl_type /*P*/ getFirstDecl() { return getFirstDecl$Mergeable(); }
  
  //public default/*interface*/ /*const*/ decl_type /*P*/ getFirstDecl$Const() /*const*/ { return getFirstDecl$Mergeable$Const(); }
  
  public default/*interface*/ boolean isFirstDecl() /*const*/ { return isFirstDecl$Mergeable(); }
  
  public abstract Class<? extends decl_type> getDeclType$Mergeable();

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
