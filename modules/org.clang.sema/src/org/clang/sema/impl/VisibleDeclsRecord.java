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

package org.clang.sema.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.DenseMapInfoDeclarationName;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3334,
 FQN="(anonymous namespace)::VisibleDeclsRecord", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecordE")
//</editor-fold>
public class VisibleDeclsRecord implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief An entry in the shadow map, which is optimized to store a
  /// single declaration (the common case) but can also store a list
  /// of declarations.
  /*typedef llvm::TinyPtrVector<NamedDecl *> ShadowMapEntry*/
//  public final class ShadowMapEntry extends TinyPtrVector<NamedDecl /*P*/ >{ };
/*private:*/
  /// \brief A mapping from declaration names to the declarations that have
  /// this name within a particular scope.
  /*typedef llvm::DenseMap<DeclarationName, ShadowMapEntry> ShadowMap*/
//  public final class ShadowMap extends DenseMap<DeclarationName, TinyPtrVector<NamedDecl /*P*/ >>{ };
  
  /// \brief A list of shadow maps, which is used to model name hiding.
  /*friend*//*private*/ std.list<DenseMap<DeclarationName, TinyPtrVector<NamedDecl /*P*/ >> > ShadowMaps;
  
  /// \brief The declaration contexts we have already visited.
  private SmallPtrSet<DeclContext /*P*/ > VisitedContexts;
  
  /*friend  class ShadowContextRAII*/
/*public:*/
  /// \brief Determine whether we have already visited this context
  /// (and, if not, note that we are going to visit that context now).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::visitedContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3357,
   FQN="(anonymous namespace)::VisibleDeclsRecord::visitedContext", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecord14visitedContextEPN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecord14visitedContextEPN5clang11DeclContextE")
  //</editor-fold>
  public boolean visitedContext(DeclContext /*P*/ Ctx) {
    return !VisitedContexts.insert(Ctx).second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::alreadyVisitedContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3361,
   FQN="(anonymous namespace)::VisibleDeclsRecord::alreadyVisitedContext", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecord21alreadyVisitedContextEPN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecord21alreadyVisitedContextEPN5clang11DeclContextE")
  //</editor-fold>
  public boolean alreadyVisitedContext(DeclContext /*P*/ Ctx) {
    return (VisitedContexts.count(Ctx) != 0);
  }

  
  /// \brief Determine whether the given declaration is hidden in the
  /// current scope.
  ///
  /// \returns the declaration that hides the given declaration, or
  /// NULL if no such declaration exists.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::checkHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3396,
   FQN="(anonymous namespace)::VisibleDeclsRecord::checkHidden", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecord11checkHiddenEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecord11checkHiddenEPN5clang9NamedDeclE")
  //</editor-fold>
  public NamedDecl /*P*/ checkHidden(NamedDecl /*P*/ ND) {
    /*uint*/int IDNS = ND.getIdentifierNamespace();
    reverse_iterator<DenseMap<DeclarationName, TinyPtrVector<NamedDecl>>> SM = ShadowMaps.rbegin();
    for (reverse_iterator<DenseMap<DeclarationName, TinyPtrVector<NamedDecl>>> SMEnd = ShadowMaps.rend();
         $noteq_reverse_iterator$C(SM, SMEnd); SM.$preInc()) {
      DenseMapIterator<DeclarationName, TinyPtrVector<NamedDecl /*P*/ >> Pos = SM.$arrow().find(ND.getDeclName());
      if (Pos.$eq(/*NO_ITER_COPY*/SM.$arrow().end())) {
        continue;
      }
      
      for (NamedDecl /*P*/ D : Pos.$arrow().second) {
        // A tag declaration does not hide a non-tag declaration.
        if (D.hasTagIdentifierNamespace()
           && ((IDNS & (Decl.IdentifierNamespace.IDNS_Member | Decl.IdentifierNamespace.IDNS_Ordinary
           | Decl.IdentifierNamespace.IDNS_ObjCProtocol)) != 0)) {
          continue;
        }
        
        // Protocols are in distinct namespaces from everything else.
        if ((((D.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_ObjCProtocol) != 0)
           || ((IDNS & Decl.IdentifierNamespace.IDNS_ObjCProtocol) != 0))
           && D.getIdentifierNamespace() != IDNS) {
          continue;
        }
        
        // Functions and function templates in the same scope overload
        // rather than hide.  FIXME: Look for hiding based on function
        // signatures!
        if (D.getUnderlyingDecl().isFunctionOrFunctionTemplate()
           && ND.getUnderlyingDecl().isFunctionOrFunctionTemplate()
           && $eq_reverse_iterator$C(SM, ShadowMaps.rbegin())) {
          continue;
        }
        
        // We've found a declaration that hides this one.
        return D;
      }
    }
    
    return null;
  }

  
  /// \brief Add a declaration to the current shadow map.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3373,
   FQN="(anonymous namespace)::VisibleDeclsRecord::add", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecord3addEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecord3addEPN5clang9NamedDeclE")
  //</editor-fold>
  public void add(NamedDecl /*P*/ ND) {
    ShadowMaps.back().$at_T1$RR(ND.getDeclName()).push_back(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::VisibleDeclsRecord">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3334,
   FQN="(anonymous namespace)::VisibleDeclsRecord::VisibleDeclsRecord", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecordC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecordC1Ev")
  //</editor-fold>
  public /*inline*/ VisibleDeclsRecord() {
    // : ShadowMaps(), VisitedContexts() 
    //START JInit
    this.ShadowMaps = new std.list<DenseMap<DeclarationName, TinyPtrVector<NamedDecl /*P*/ >> >(
            new DenseMap<>(DenseMapInfoDeclarationName.$Info(), new TinyPtrVector<>()));
    this.VisitedContexts = new SmallPtrSet<DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VisibleDeclsRecord::~VisibleDeclsRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3334,
   FQN="(anonymous namespace)::VisibleDeclsRecord::~VisibleDeclsRecord", NM="_ZN12_GLOBAL__N_118VisibleDeclsRecordD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_118VisibleDeclsRecordD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VisitedContexts.$destroy();
    ShadowMaps.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ShadowMaps=" + ShadowMaps // NOI18N
              + ", VisitedContexts=" + "[SmallPtrSet$DeclContext]"; // NOI18N
  }
}
