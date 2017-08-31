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

package org.clang.analysis;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 379,
 FQN="clang::LocationContextManager", NM="_ZN5clang22LocationContextManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManagerE")
//</editor-fold>
public class LocationContextManager implements Destructors.ClassWithDestructor {
  private FoldingSet<LocationContext> Contexts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::~LocationContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 615,
   FQN="clang::LocationContextManager::~LocationContextManager", NM="_ZN5clang22LocationContextManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    clear();
    //START JDestroy
    Contexts.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::getStackFrame">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 400,
   FQN="clang::LocationContextManager::getStackFrame", NM="_ZN5clang22LocationContextManager13getStackFrameEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManager13getStackFrameEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame(AnalysisDeclContext /*P*/ ctx, 
               /*const*/ LocationContext /*P*/ parent, 
               /*const*/ Stmt /*P*/ s, 
               /*const*/ CFGBlock /*P*/ blk, /*uint*/int idx) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    StackFrameContext.Profile(ID, ctx, parent, s, blk, idx);
    final type$ref<type$ptr<StackFrameContext /*P*/>/*void P*/ > InsertPos = create_type$ref();
    StackFrameContext /*P*/ L = cast_or_null_StackFrameContext(Contexts.FindNodeOrInsertPos(ID, InsertPos));
    if (!(L != null)) {
      L = new StackFrameContext(ctx, parent, s, blk, idx);
      Contexts.InsertNode(L, InsertPos.$deref());
    }
    return L;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::getScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 417,
   FQN="clang::LocationContextManager::getScope", NM="_ZN5clang22LocationContextManager8getScopeEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManager8getScopeEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ ScopeContext /*P*/ getScope(AnalysisDeclContext /*P*/ ctx, 
          /*const*/ LocationContext /*P*/ parent, 
          /*const*/ Stmt /*P*/ s) {
    return this.</*ScopeContext,*/ Stmt>getLocationContext(ctx, parent, s);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::getBlockInvocationContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 424,
   FQN="clang::LocationContextManager::getBlockInvocationContext", NM="_ZN5clang22LocationContextManager25getBlockInvocationContextEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManager25getBlockInvocationContextEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv")
  //</editor-fold>
  public /*const*/ BlockInvocationContext /*P*/ getBlockInvocationContext(AnalysisDeclContext /*P*/ ctx, 
                           /*const*/ LocationContext /*P*/ parent, 
                           /*const*/ BlockDecl /*P*/ BD, 
                           /*const*/Object/*void P*/ ContextData) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    BlockInvocationContext.Profile(ID, ctx, parent, BD, ContextData);
    final type$ref<type$ptr<BlockInvocationContext /*P*/>/*void P*/ > InsertPos = create_type$ref();
    BlockInvocationContext /*P*/ L = cast_or_null_BlockInvocationContext(Contexts.FindNodeOrInsertPos(ID, 
    InsertPos));
    if (!(L != null)) {
      L = new BlockInvocationContext(ctx, parent, BD, ContextData);
      Contexts.InsertNode(L, InsertPos.$deref());
    }
    return L;
  }

  
  /// Discard all previously created LocationContext objects.
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 619,
   FQN="clang::LocationContextManager::clear", NM="_ZN5clang22LocationContextManager5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManager5clearEv")
  //</editor-fold>
  public void clear() {
    for (FoldingSetIterator<LocationContext> I = Contexts.begin(), 
        E = Contexts.end(); I.$noteq(E);) {
      LocationContext /*P*/ LC = $AddrOf(I.$star());
      I.$preInc();
      if (LC != null) { LC.$destroy();};
    }
    
    Contexts.clear();
  }

/*private:*/
  /*template <typename LOC, typename DATA> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::getLocationContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 383,
   FQN="clang::LocationContextManager::getLocationContext", NM="Tpl__ZN5clang22LocationContextManager18getLocationContextEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=Tpl__ZN5clang22LocationContextManager18getLocationContextEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKT0_")
  //</editor-fold>
  private </*typename LOC extends ScopeContext,*/ /*typename*/ DATA extends Stmt> /*const*/ ScopeContext /*P*/ getLocationContext(AnalysisDeclContext /*P*/ ctx, 
                    /*const*/ LocationContext /*P*/ parent, 
                    /*const*/ DATA /*P*/ d) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ScopeContext.Profile(ID, ctx, parent, d);
    final type$ref<type$ptr<ScopeContext /*P*/>/*void P*/ > InsertPos = create_type$ref();
    
    ScopeContext /*P*/ L = cast_or_null_ScopeContext(Contexts.FindNodeOrInsertPos(ID, InsertPos));
    if (Native.$not(L)) {
      L = new ScopeContext( ctx, parent, d );
      Contexts.InsertNode(L, InsertPos.$deref());
    }
    return L;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LocationContextManager::LocationContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 379,
   FQN="clang::LocationContextManager::LocationContextManager", NM="_ZN5clang22LocationContextManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22LocationContextManagerC1Ev")
  //</editor-fold>
  public /*inline*/ LocationContextManager() {
    // : Contexts() 
    //START JInit
    this.Contexts = new FoldingSet<LocationContext>(LocationContext.$Trait());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Contexts=" + "[FoldingSet$LocationContext]"; // NOI18N
  }
}
