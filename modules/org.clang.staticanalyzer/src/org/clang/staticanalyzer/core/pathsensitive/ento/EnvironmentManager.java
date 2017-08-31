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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 103,
 FQN="clang::ento::EnvironmentManager", NM="_ZN5clang4ento18EnvironmentManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento18EnvironmentManagerE")
//</editor-fold>
public class EnvironmentManager implements Destructors.ClassWithDestructor {
/*private:*/
  // JAVA: typedef Environment::BindingsTy::Factory FactoryTy
//  public final class FactoryTy extends ImmutableMap.Factory<EnvironmentEntry, SVal>{ };
  private ImmutableMap.Factory<EnvironmentEntry, SVal> F;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager::EnvironmentManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 109,
   FQN="clang::ento::EnvironmentManager::EnvironmentManager", NM="_ZN5clang4ento18EnvironmentManagerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento18EnvironmentManagerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public EnvironmentManager(final BumpPtrAllocatorImpl /*&*/ Allocator) {
    // : F(Allocator) 
    //START JInit
    this.F = new ImmutableMap.Factory<EnvironmentEntry, SVal>(
            new ImutKeyValueInfo<>(
                    new ImutContainerInfo<EnvironmentEntry>(new DefaultFoldingSetTrait<EnvironmentEntry>()),
                    new ImutContainerInfo<SVal>(new DefaultFoldingSetTrait<SVal>())
            ),
            Allocator);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager::getInitialEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 111,
   FQN="clang::ento::EnvironmentManager::getInitialEnvironment", NM="_ZN5clang4ento18EnvironmentManager21getInitialEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento18EnvironmentManager21getInitialEnvironmentEv")
  //</editor-fold>
  public Environment getInitialEnvironment() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new Environment($c$.track(F.getEmptyMap())));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Bind a symbolic value to the given environment entry.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager::bindExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 110,
   FQN="clang::ento::EnvironmentManager::bindExpr", NM="_ZN5clang4ento18EnvironmentManager8bindExprENS0_11EnvironmentERKNS0_16EnvironmentEntryENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento18EnvironmentManager8bindExprENS0_11EnvironmentERKNS0_16EnvironmentEntryENS0_4SValEb")
  //</editor-fold>
  public Environment bindExpr(Environment Env, 
          final /*const*/ EnvironmentEntry /*&*/ E, 
          SVal V, 
          boolean Invalidate) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (V.isUnknown$SVal()) {
        if (Invalidate) {
          return $c$.clean(new Environment($c$.track(F.remove($c$.track(new ImmutableMap<EnvironmentEntry, SVal>(Env.ExprBindings)), E))));
        } else {
          return new Environment(JD$Move.INSTANCE, Env);
        }
      }
      return $c$.clean(new Environment($c$.track(F.add($c$.track(new ImmutableMap<EnvironmentEntry, SVal>(Env.ExprBindings)), E, V))));
    } finally {
      $c$.$destroy();
    }
  }

  
  // end anonymous namespace
  
  // removeDeadBindings:
  //  - Remove subexpression bindings.
  //  - Remove dead block expression bindings.
  //  - Keep live block expression bindings:
  //   - Mark their reachable symbols live in SymbolReaper,
  //     see ScanReachableSymbols.
  //   - Mark the region in DRoots if the binding is a loc::MemRegionVal.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 146,
   FQN="clang::ento::EnvironmentManager::removeDeadBindings", NM="_ZN5clang4ento18EnvironmentManager18removeDeadBindingsENS0_11EnvironmentERNS0_12SymbolReaperEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento18EnvironmentManager18removeDeadBindingsENS0_11EnvironmentERNS0_12SymbolReaperEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public Environment removeDeadBindings(Environment Env, 
                    final SymbolReaper /*&*/ SymReaper, 
                    IntrusiveRefCntPtr</*const*/ ProgramState> ST) {
    Environment NewEnv = null;
    ScanReachableSymbols RSScaner = null;
    ImmutableMapRef<EnvironmentEntry, SVal> EBMapRef = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {

      // We construct a new Environment object entirely, as this is cheaper than
      // individually removing all the subexpression bindings (which will greatly
      // outnumber block-level expression bindings).
      NewEnv = getInitialEnvironment();

      MarkLiveCallback CB/*J*/= new MarkLiveCallback(SymReaper);
      RSScaner/*J*/= $c$.clean(new ScanReachableSymbols($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ST)), CB));

      EBMapRef/*J*/= new ImmutableMapRef<EnvironmentEntry, SVal>(NewEnv.ExprBindings.getRootWithoutRetain(), 
          F.getTreeFactory());
      ImmutableMap.iterator<EnvironmentEntry, SVal> I = null;
      ImmutableMap.iterator<EnvironmentEntry, SVal> E = null;
      try {

        // Iterate over the block-expr bindings.
        for (I = Env.begin(), E = Env.end();
             I.$noteq(E); I.$preInc()) {

          final /*const*/ EnvironmentEntry /*&*/ BlkExpr = I.getKey();
          final /*const*/ SVal /*&*/ X = I.getData();
          if (SymReaper.isLive(BlkExpr.getStmt(), BlkExpr.getLocationContext())) {
            // Copy the binding to the new map.
            $c$.clean(EBMapRef.$assign($c$.track(EBMapRef.add(BlkExpr, X))));

            // Mark all symbols in the block expr's value live.
            RSScaner.scan(new SVal(X));
            continue;
          } else {
            SymExpr.symbol_iterator SI = null;
            SymExpr.symbol_iterator SE = null;
            try {
              SI = X.symbol_begin();
              SE = X.symbol_end();
              for (; SI.$noteq(SE); SI.$preInc())  {
                SymReaper.maybeDead(SI.$star());
              }
            } finally {
              if (SE != null) { SE.$destroy(); }
              if (SI != null) { SI.$destroy(); }
            }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }

      $c$.clean(NewEnv.ExprBindings.$assign($c$.track(EBMapRef.asImmutableMap())));
      return new Environment(JD$Move.INSTANCE, NewEnv);
    } finally {
      if (EBMapRef != null) { EBMapRef.$destroy(); }
      if (RSScaner != null) { RSScaner.$destroy(); }
      if (NewEnv != null) { NewEnv.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentManager::~EnvironmentManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 103,
   FQN="clang::ento::EnvironmentManager::~EnvironmentManager", NM="_ZN5clang4ento18EnvironmentManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento18EnvironmentManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    F.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "F=" + F; // NOI18N
  }
}
