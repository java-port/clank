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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.impl.BodyFarm;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.Selector;
import org.clang.basic.llvm.DenseMapInfoSelector;
import org.llvm.adt.DenseMapInfoPairPtrType;
import org.llvm.adt.OptionalPtr;


//<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 408,
 FQN="clang::AnalysisDeclContextManager", NM="_ZN5clang26AnalysisDeclContextManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManagerE")
//</editor-fold>
public class AnalysisDeclContextManager implements Destructors.ClassWithDestructor {
  /*typedef llvm::DenseMap<const Decl *, AnalysisDeclContext *> ContextMap*/
//  public final class ContextMap extends DenseMap</*const*/ Decl /*P*/ , AnalysisDeclContext /*P*/ >{ };
  
  private DenseMap</*const*/ Decl /*P*/ , AnalysisDeclContext /*P*/ > Contexts;
  private LocationContextManager LocContexts;
  private CFG.BuildOptions cfgBuildOptions;
  
  /// Pointer to an interface that can provide function bodies for
  /// declarations from external source.
  /*friend*/public/*private*/ std.unique_ptr<CodeInjector> Injector;
  
  /// Flag to indicate whether or not bodies should be synthesized
  /// for well-known functions.
  private boolean SynthesizeBodies;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::AnalysisDeclContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 66,
   FQN="clang::AnalysisDeclContextManager::AnalysisDeclContextManager", NM="_ZN5clang26AnalysisDeclContextManagerC1EbbbbbbbPNS_12CodeInjectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManagerC1EbbbbbbbPNS_12CodeInjectorE")
  //</editor-fold>
  public AnalysisDeclContextManager() {
    this(false, 
      false, 
      false, 
      false, 
      false, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/) {
    this(useUnoptimizedCFG, 
      false, 
      false, 
      false, 
      false, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      false, 
      false, 
      false, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      addInitializers, 
      false, 
      false, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/, 
      boolean addTemporaryDtors/*= false*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      addInitializers, 
      addTemporaryDtors, 
      false, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/, 
      boolean addTemporaryDtors/*= false*/, 
      boolean synthesizeBodies/*= false*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      addInitializers, 
      addTemporaryDtors, 
      synthesizeBodies, 
      false, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/, 
      boolean addTemporaryDtors/*= false*/, 
      boolean synthesizeBodies/*= false*/, 
      boolean addStaticInitBranch/*= false*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      addInitializers, 
      addTemporaryDtors, 
      synthesizeBodies, 
      addStaticInitBranch, 
      true, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/, 
      boolean addTemporaryDtors/*= false*/, 
      boolean synthesizeBodies/*= false*/, 
      boolean addStaticInitBranch/*= false*/, 
      boolean addCXXNewAllocator/*= true*/) {
    this(useUnoptimizedCFG, 
      addImplicitDtors, 
      addInitializers, 
      addTemporaryDtors, 
      synthesizeBodies, 
      addStaticInitBranch, 
      addCXXNewAllocator, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisDeclContextManager(boolean useUnoptimizedCFG/*= false*/, 
      boolean addImplicitDtors/*= false*/, 
      boolean addInitializers/*= false*/, 
      boolean addTemporaryDtors/*= false*/, 
      boolean synthesizeBodies/*= false*/, 
      boolean addStaticInitBranch/*= false*/, 
      boolean addCXXNewAllocator/*= true*/, 
      CodeInjector /*P*/ injector/*= null*/) {
    // : Contexts(), LocContexts(), cfgBuildOptions(), Injector(injector), SynthesizeBodies(synthesizeBodies) 
    //START JInit
    this.Contexts = new DenseMap</*const*/ Decl /*P*/ , AnalysisDeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), (AnalysisDeclContext /*P*/ )null);
    this.LocContexts = new LocationContextManager();
    this.cfgBuildOptions = new CFG.BuildOptions();
    this.Injector = new std.unique_ptr<CodeInjector>(injector);
    this.SynthesizeBodies = synthesizeBodies;
    //END JInit
    cfgBuildOptions.PruneTriviallyFalseEdges = !useUnoptimizedCFG;
    cfgBuildOptions.AddImplicitDtors = addImplicitDtors;
    cfgBuildOptions.AddInitializers = addInitializers;
    cfgBuildOptions.AddTemporaryDtors = addTemporaryDtors;
    cfgBuildOptions.AddStaticInitBranches = addStaticInitBranch;
    cfgBuildOptions.AddCXXNewAllocator = addCXXNewAllocator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::~AnalysisDeclContextManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 609,
   FQN="clang::AnalysisDeclContextManager::~AnalysisDeclContextManager", NM="_ZN5clang26AnalysisDeclContextManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.DeleteContainerSeconds(Contexts);
    //START JDestroy
    Injector.$destroy();
    LocContexts.$destroy();
    Contexts.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 302,
   FQN="clang::AnalysisDeclContextManager::getContext", NM="_ZN5clang26AnalysisDeclContextManager10getContextEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager10getContextEPKNS_4DeclE")
  //</editor-fold>
  public AnalysisDeclContext /*P*/ getContext(/*const*/ Decl /*P*/ D) {
    {
      type$ref</*const*/ FunctionDecl /*P*/ > FD = create_type$ref(dyn_cast_FunctionDecl(D));
      if ((FD.$deref() != null)) {
        // Calling 'hasBody' replaces 'FD' in place with the FunctionDecl
        // that has the body.
        FD.$deref().hasBody(FD);
        D = FD.$deref();
      }
    }
    
    final type$ref<AnalysisDeclContext /*P*/ /*&*/> AC = Contexts.ref$at(D);
    if (!(AC.$deref() != null)) {
      AC.$set(new AnalysisDeclContext(this, D, cfgBuildOptions));
    }
    return AC.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getUseUnoptimizedCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 437,
   FQN="clang::AnalysisDeclContextManager::getUseUnoptimizedCFG", NM="_ZNK5clang26AnalysisDeclContextManager20getUseUnoptimizedCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang26AnalysisDeclContextManager20getUseUnoptimizedCFGEv")
  //</editor-fold>
  public boolean getUseUnoptimizedCFG() /*const*/ {
    return !cfgBuildOptions.PruneTriviallyFalseEdges;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getCFGBuildOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 441,
   FQN="clang::AnalysisDeclContextManager::getCFGBuildOptions", NM="_ZN5clang26AnalysisDeclContextManager18getCFGBuildOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager18getCFGBuildOptionsEv")
  //</editor-fold>
  public CFG.BuildOptions /*&*/ getCFGBuildOptions() {
    return cfgBuildOptions;
  }

  
  /// Return true if faux bodies should be synthesized for well-known
  /// functions.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::synthesizeBodies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 447,
   FQN="clang::AnalysisDeclContextManager::synthesizeBodies", NM="_ZNK5clang26AnalysisDeclContextManager16synthesizeBodiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang26AnalysisDeclContextManager16synthesizeBodiesEv")
  //</editor-fold>
  public boolean synthesizeBodies() /*const*/ {
    return SynthesizeBodies;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 449,
   FQN="clang::AnalysisDeclContextManager::getStackFrame", NM="_ZN5clang26AnalysisDeclContextManager13getStackFrameEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager13getStackFrameEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame(AnalysisDeclContext /*P*/ Ctx, 
               /*const*/ LocationContext /*P*/ Parent, 
               /*const*/ Stmt /*P*/ S, 
               /*const*/ CFGBlock /*P*/ Blk, 
               /*uint*/int Idx) {
    return LocContexts.getStackFrame(Ctx, Parent, S, Blk, Idx);
  }

  
  // Get the top level stack frame.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 458,
   FQN="clang::AnalysisDeclContextManager::getStackFrame", NM="_ZN5clang26AnalysisDeclContextManager13getStackFrameEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager13getStackFrameEPKNS_4DeclE")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame(/*const*/ Decl /*P*/ D) {
    return LocContexts.getStackFrame(getContext(D), (/*const*/ LocationContext /*P*/ )null, (/*const*/ Stmt /*P*/ )null, (/*const*/ CFGBlock /*P*/ )null, 
        0);
  }

  
  // Get a stack frame with parent.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 464,
   FQN="clang::AnalysisDeclContextManager::getStackFrame", NM="_ZN5clang26AnalysisDeclContextManager13getStackFrameEPKNS_4DeclEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager13getStackFrameEPKNS_4DeclEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame(/*const*/ Decl /*P*/ D, 
               /*const*/ LocationContext /*P*/ Parent, 
               /*const*/ Stmt /*P*/ S, 
               /*const*/ CFGBlock /*P*/ Blk, 
               /*uint*/int Idx) {
    return LocContexts.getStackFrame(getContext(D), Parent, S, Blk, Idx);
  }

  
  /// Discard all previously created AnalysisDeclContexts.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 84,
   FQN="clang::AnalysisDeclContextManager::clear", NM="_ZN5clang26AnalysisDeclContextManager5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager5clearEv")
  //</editor-fold>
  public void clear() {
    llvm.DeleteContainerSeconds(Contexts);
  }

/*private:*/
  /*friend  class AnalysisDeclContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContextManager::getLocationContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 478,
   FQN="clang::AnalysisDeclContextManager::getLocationContextManager", NM="_ZN5clang26AnalysisDeclContextManager25getLocationContextManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang26AnalysisDeclContextManager25getLocationContextManagerEv")
  //</editor-fold>
  /*friend*/public/*private*/ LocationContextManager /*&*/ getLocationContextManager() {
    return LocContexts;
  }

  private ASTContext $BF$ASTContext = null;
  private BodyFarm/*P*/ $BF = null;
  // return Object vs real BodyFarm to prevent API visibility of impl BodyFarm class
  public final Object/*BodyFarm*/ $getBodyFarm(final ASTContext /*&*/ C) {
    if ($BF == null) {
      assert $BF$ASTContext == null;
      $BF$ASTContext = C;
      $BF = new BodyFarm(C, this.Injector.get());
    }
    assert $BF$ASTContext == C;
    return $BF;
  }

  // return cache to be used by ObjCMethodCall vs static function-local variable from ObjCMethodCall.getRuntimeDefinition
  public final DenseMap<std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, 
                        OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >> $getObjCInterfaceDecl$Selector$Cache() {
    if (ObjCInterfaceDecl$Selector$Cache == null) {
      ObjCInterfaceDecl$Selector$Cache/*J*/ = 
          new DenseMap<std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>,
                    OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >>(
                            new DenseMapInfoPairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoSelector.$Info()),
                            new OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >());
    }                      
    return ObjCInterfaceDecl$Selector$Cache;
  }                      
  // JAVA: see comment in ObjCMethodCall.getRuntimeDefinition about concurrent access
  private DenseMap<std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, 
                        OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >> ObjCInterfaceDecl$Selector$Cache;
  
  @Override public String toString() {
    return "" + "Contexts=" + "[DenseMap$Decl$AnalysisDeclContext]" // NOI18N
              + ", LocContexts=" + "[LocationContextManager]" // NOI18N
              + ", cfgBuildOptions=" + cfgBuildOptions // NOI18N
              + ", Injector=" + Injector // NOI18N
              + ", SynthesizeBodies=" + SynthesizeBodies; // NOI18N
  }
}
