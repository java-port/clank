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

import static org.clang.ast.java.AstDeclarationsRTTI.cast_NamedDecl;
import org.clank.support.*;
import org.clang.basic.*;


/// \brief An UnresolvedSet-like class that might not have been loaded from the
/// external AST source yet.
//<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 88,
 FQN="clang::LazyASTUnresolvedSet", NM="_ZN5clang20LazyASTUnresolvedSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20LazyASTUnresolvedSetE")
//</editor-fold>
public class LazyASTUnresolvedSet implements Destructors.ClassWithDestructor {
  private /*mutable */ASTUnresolvedSet Impl;
  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::getFromExternalSource">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 37,
   FQN="clang::LazyASTUnresolvedSet::getFromExternalSource", NM="_ZNK5clang20LazyASTUnresolvedSet21getFromExternalSourceERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang20LazyASTUnresolvedSet21getFromExternalSourceERNS_10ASTContextE")
  //</editor-fold>
  private void getFromExternalSource(final ASTContext /*&*/ C) /*const*/ {
    ExternalASTSource /*P*/ Source = C.getExternalSource();
    assert (Impl.Decls.isLazy()) : "getFromExternalSource for non-lazy set";
    assert ((Source != null)) : "getFromExternalSource with no external source";
    
    for (UnresolvedSetIterator I = Impl.begin(); I.$noteq(Impl.end()); I.$preInc())  {
      I.setDecl(cast_NamedDecl(Source.GetExternalDecl(/*reinterpret_cast_Object/*uintptr_t*/(I.getDecl$ID()) >>> 2)));
    }
    Impl.Decls.setLazy(false);
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 94,
   FQN="clang::LazyASTUnresolvedSet::get", NM="_ZNK5clang20LazyASTUnresolvedSet3getERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang20LazyASTUnresolvedSet3getERNS_10ASTContextE")
  //</editor-fold>
  public ASTUnresolvedSet /*&*/ get(final ASTContext /*&*/ C) /*const*/ {
    if (Impl.Decls.isLazy()) {
      getFromExternalSource(C);
    }
    return Impl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 100,
   FQN="clang::LazyASTUnresolvedSet::reserve", NM="_ZN5clang20LazyASTUnresolvedSet7reserveERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20LazyASTUnresolvedSet7reserveERNS_10ASTContextEj")
  //</editor-fold>
  public void reserve(final ASTContext /*&*/ C, /*uint*/int N) {
    Impl.reserve(C, N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::addLazyDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 101,
   FQN="clang::LazyASTUnresolvedSet::addLazyDecl", NM="_ZN5clang20LazyASTUnresolvedSet11addLazyDeclERNS_10ASTContextEjNS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20LazyASTUnresolvedSet11addLazyDeclERNS_10ASTContextEjNS_15AccessSpecifierE")
  //</editor-fold>
  public void addLazyDecl(final ASTContext /*&*/ C, /*uint32_t*/int/*uintptr_t*/ ID, AccessSpecifier AS) {
    assert (Impl.empty() || Impl.Decls.isLazy());
    Impl.Decls.setLazy(true);
    Impl.addDecl(C, /*reinterpret_cast(NamedDecl *.class, */(ID << 2), AS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 88,
   FQN="clang::LazyASTUnresolvedSet::operator=", NM="_ZN5clang20LazyASTUnresolvedSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20LazyASTUnresolvedSetaSEOS0_")
  //</editor-fold>
  public /*inline*/ LazyASTUnresolvedSet /*&*/ $assignMove(final LazyASTUnresolvedSet /*&&*/$Prm0) {
    this.Impl.$assignMove($Prm0.Impl);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::~LazyASTUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 88,
   FQN="clang::LazyASTUnresolvedSet::~LazyASTUnresolvedSet", NM="_ZN5clang20LazyASTUnresolvedSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20LazyASTUnresolvedSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Impl.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LazyASTUnresolvedSet::LazyASTUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 88,
   FQN="clang::LazyASTUnresolvedSet::LazyASTUnresolvedSet", NM="_ZN5clang20LazyASTUnresolvedSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang20LazyASTUnresolvedSetC1Ev")
  //</editor-fold>
  public /*inline*/ LazyASTUnresolvedSet() {
    // : Impl() 
    //START JInit
    this.Impl = new ASTUnresolvedSet();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
