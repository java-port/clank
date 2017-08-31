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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;


/// A collection of using directives, as used by C++ unqualified
/// lookup.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 95,
 FQN="(anonymous namespace)::UnqualUsingDirectiveSet", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetE")
//</editor-fold>
public class UnqualUsingDirectiveSet implements Destructors.ClassWithDestructor {
  /*typedef SmallVector<UnqualUsingEntry, 8> ListTy*/
//  public final class ListTy extends SmallVector<UnqualUsingEntry>{ };
  
  private SmallVector<UnqualUsingEntry> list;
  private SmallPtrSet<DeclContext /*P*/ > visited;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::UnqualUsingDirectiveSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 102,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::UnqualUsingDirectiveSet", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetC1Ev")
  //</editor-fold>
  public UnqualUsingDirectiveSet() {
    // : list(), visited() 
    //START JInit
    this.list = new SmallVector<UnqualUsingEntry>(8, new UnqualUsingEntry());
    this.visited = new SmallPtrSet<DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::visitScopeChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 104,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::visitScopeChain", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet15visitScopeChainEPN5clang5ScopeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet15visitScopeChainEPN5clang5ScopeES3_")
  //</editor-fold>
  public void visitScopeChain(Scope /*P*/ S, Scope /*P*/ InnermostFileScope) {
    // C++ [namespace.udir]p1:
    //   During unqualified name lookup, the names appear as if they
    //   were declared in the nearest enclosing namespace which contains
    //   both the using-directive and the nominated namespace.
    DeclContext /*P*/ InnermostFileDC = InnermostFileScope.getEntity();
    assert ((InnermostFileDC != null) && InnermostFileDC.isFileContext());
    
    for (; (S != null); S = S.getParent()) {
      // C++ [namespace.udir]p1:
      //   A using-directive shall not appear in class scope, but may
      //   appear in namespace scope or in block scope.
      DeclContext /*P*/ Ctx = S.getEntity();
      if ((Ctx != null) && Ctx.isFileContext()) {
        visit(Ctx, Ctx);
      } else if (!(Ctx != null) || Ctx.isFunctionOrMethod()) {
        for (UsingDirectiveDecl /*P*/ I : S.using_directives())  {
          visit(I, InnermostFileDC);
        }
      }
    }
  }

  
  // Visits a context and collect all of its using directives
  // recursively.  Treats all using directives as if they were
  // declared in the context.
  //
  // A given context is only every visited once, so it is important
  // that contexts be visited from the inside out in order to get
  // the effective DCs right.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 133,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::visit", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet5visitEPN5clang11DeclContextES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet5visitEPN5clang11DeclContextES3_")
  //</editor-fold>
  public void visit(DeclContext /*P*/ DC, DeclContext /*P*/ EffectiveDC) {
    if (!visited.insert(DC).second) {
      return;
    }
    
    addUsingDirectives(DC, EffectiveDC);
  }

  
  // Visits a using directive and collects all of its using
  // directives recursively.  Treats all using directives as if they
  // were declared in the effective DC.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 143,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::visit", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet5visitEPN5clang18UsingDirectiveDeclEPNS1_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet5visitEPN5clang18UsingDirectiveDeclEPNS1_11DeclContextE")
  //</editor-fold>
  public void visit(UsingDirectiveDecl /*P*/ UD, DeclContext /*P*/ EffectiveDC) {
    DeclContext /*P*/ NS = UD.getNominatedNamespace();
    if (!visited.insert(NS).second) {
      return;
    }
    
    addUsingDirective(UD, EffectiveDC);
    addUsingDirectives(NS, EffectiveDC);
  }

  
  // Adds all the using directives in a context (and those nominated
  // by its using directives, transitively) as if they appeared in
  // the given effective context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::addUsingDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 155,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::addUsingDirectives", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet18addUsingDirectivesEPN5clang11DeclContextES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet18addUsingDirectivesEPN5clang11DeclContextES3_")
  //</editor-fold>
  public void addUsingDirectives(DeclContext /*P*/ DC, DeclContext /*P*/ EffectiveDC) {
    SmallVector<DeclContext /*P*/ > queue/*J*/= new SmallVector<DeclContext /*P*/ >(4, (DeclContext /*P*/ )null);
    while (true) {
      for (UsingDirectiveDecl /*P*/ UD : DC.using_directives()) {
        DeclContext /*P*/ NS = UD.getNominatedNamespace();
        if (visited.insert(NS).second) {
          addUsingDirective(UD, EffectiveDC);
          queue.push_back(NS);
        }
      }
      if (queue.empty()) {
        return;
      }
      
      DC = queue.pop_back_val();
    }
  }

  
  // Add a using directive as if it had been declared in the given
  // context.  This helps implement C++ [namespace.udir]p3:
  //   The using-directive is transitive: if a scope contains a
  //   using-directive that nominates a second namespace that itself
  //   contains using-directives, the effect is as if the
  //   using-directives from the second namespace also appeared in
  //   the first.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::addUsingDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 180,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::addUsingDirective", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet17addUsingDirectiveEPN5clang18UsingDirectiveDeclEPNS1_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet17addUsingDirectiveEPN5clang18UsingDirectiveDeclEPNS1_11DeclContextE")
  //</editor-fold>
  public void addUsingDirective(UsingDirectiveDecl /*P*/ UD, DeclContext /*P*/ EffectiveDC) {
    // Find the common ancestor between the effective context and
    // the nominated namespace.
    DeclContext /*P*/ Common = UD.getNominatedNamespace();
    while (!Common.Encloses(EffectiveDC)) {
      Common = Common.getParent();
    }
    Common = Common.getPrimaryContext();
    
    list.push_back(new UnqualUsingEntry(UD.getNominatedNamespace(), Common));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::done">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 191,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::done", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet4doneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSet4doneEv")
  //</editor-fold>
  public void done() {
    std.sort(list.begin(), list.end(), new UnqualUsingEntry.Comparator());
  }

  
  /*typedef ListTy::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr</*const*/ UnqualUsingEntry /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 197,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::begin", NM="_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ UnqualUsingEntry /*P*/ > begin() /*const*/ {
    return list.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 198,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::end", NM="_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet3endEv")
  //</editor-fold>
  public type$ptr</*const*/ UnqualUsingEntry /*P*/ > end() /*const*/ {
    return list.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::getNamespacesFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 200,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::getNamespacesFor", NM="_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet16getNamespacesForEPN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK12_GLOBAL__N_123UnqualUsingDirectiveSet16getNamespacesForEPN5clang11DeclContextE")
  //</editor-fold>
  public iterator_range</*const*/ UnqualUsingEntry> getNamespacesFor(DeclContext /*P*/ DC) /*const*/ {
    return llvm.make_range(std.equal_range(begin(), end(), 
            DC.getPrimaryContext(), 
            new UnqualUsingEntry.Comparator()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingDirectiveSet::~UnqualUsingDirectiveSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 95,
   FQN="(anonymous namespace)::UnqualUsingDirectiveSet::~UnqualUsingDirectiveSet", NM="_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_123UnqualUsingDirectiveSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    visited.$destroy();
    list.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "list=" + list // NOI18N
              + ", visited=" + "[SmallPtrSet$DeclContext]"; // NOI18N
  }
}
