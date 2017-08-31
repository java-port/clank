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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.analysis.analyses.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.impl.AnalysisBasedWarningsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1360,
 FQN="(anonymous namespace)::UninitValsDiagReporter", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporterE")
//</editor-fold>
public class UninitValsDiagReporter extends /*public*/ UninitVariablesHandler implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  /*typedef SmallVector<UninitUse, 2> UsesVec*/
//  public final class UsesVec extends SmallVector<UninitUse>{ };
  /*typedef llvm::PointerIntPair<UsesVec *, 1, bool> MappedType*/
//  public final class MappedType extends PointerBoolPair<SmallVector<UninitUse> /*P*/>{ };
  // Prefer using MapVector to DenseMap, so that iteration order will be
  // the same as insertion order. This is needed to obtain a deterministic
  // order of diagnostics when calling flushDiagnostics().
  /*typedef llvm::MapVector<const VarDecl *, MappedType> UsesMap*/
//  public final class UsesMap extends MapVector</*const*/ VarDecl /*P*/ , PointerBoolPair<SmallVector<UninitUse> /*P*/> >{ };
  private MapVectorPtrType</*const*/ VarDecl /*P*/ , PointerBoolPair<SmallVector<UninitUse> /*P*/> > uses;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::UninitValsDiagReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1371,
   FQN="(anonymous namespace)::UninitValsDiagReporter::UninitValsDiagReporter", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporterC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporterC1ERN5clang4SemaE")
  //</editor-fold>
  public UninitValsDiagReporter(final Sema /*&*/ S) {
    // : UninitVariablesHandler(), S(S), uses() 
    //START JInit
    super();
    this./*&*/S=/*&*/S;
    this.uses = new MapVectorPtrType</*const*/ VarDecl /*P*/ , PointerBoolPair<SmallVector<UninitUse> /*P*/> >(DenseMapInfo$LikePtr.$Info(), new PointerBoolPair<SmallVector<UninitUse> /*P*/>());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::~UninitValsDiagReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1372,
   FQN="(anonymous namespace)::UninitValsDiagReporter::~UninitValsDiagReporter", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    flushDiagnostics();
    //START JDestroy
    uses.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::getUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1374,
   FQN="(anonymous namespace)::UninitValsDiagReporter::getUses", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporter7getUsesEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporter7getUsesEPKN5clang7VarDeclE")
  //</editor-fold>
  public PointerBoolPair<SmallVector<UninitUse> /*P*/> /*&*/ getUses(/*const*/ VarDecl /*P*/ vd) {
    final PointerBoolPair<SmallVector<UninitUse> /*P*/> /*&*/ V = uses.$at(vd);
    if (!(V.getPointer() != null)) {
      V.setPointer(new SmallVector<UninitUse>(2, new UninitUse()));
    }
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::handleUseOfUninitVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1381,
   FQN="(anonymous namespace)::UninitValsDiagReporter::handleUseOfUninitVariable", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporter25handleUseOfUninitVariableEPKN5clang7VarDeclERKNS1_9UninitUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporter25handleUseOfUninitVariableEPKN5clang7VarDeclERKNS1_9UninitUseE")
  //</editor-fold>
  @Override public void handleUseOfUninitVariable(/*const*/ VarDecl /*P*/ vd, 
                           final /*const*/ UninitUse /*&*/ use)/* override*/ {
    getUses(vd).getPointer().push_back_T$C$R(use);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::handleSelfInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1386,
   FQN="(anonymous namespace)::UninitValsDiagReporter::handleSelfInit", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporter14handleSelfInitEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporter14handleSelfInitEPKN5clang7VarDeclE")
  //</editor-fold>
  @Override public void handleSelfInit(/*const*/ VarDecl /*P*/ vd)/* override*/ {
    getUses(vd).setInt(true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::flushDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1390,
   FQN="(anonymous namespace)::UninitValsDiagReporter::flushDiagnostics", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporter16flushDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporter16flushDiagnosticsEv")
  //</editor-fold>
  public void flushDiagnostics() {
    for (final /*const*/ pair</*const*/ VarDecl /*P*/ , PointerBoolPair<SmallVector<UninitUse> /*P*/> > /*&*/ P : uses) {
      /*const*/ VarDecl /*P*/ vd = P.first;
      final /*const*/PointerBoolPair<SmallVector<UninitUse> /*P*/> /*&*/ V = P.second;
      
      SmallVector<UninitUse> /*P*/ vec = V.getPointer();
      boolean hasSelfInit = V.getInt();
      
      // Specially handle the case where we have uses of an uninitialized 
      // variable, but the root cause is an idiomatic self-init.  We want
      // to report the diagnostic at the self-init since that is the root cause.
      if (!vec.empty() && hasSelfInit && hasAlwaysUninitializedUse(vec)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(DiagnoseUninitializedUse(S, vd, 
              $c$.track(new UninitUse(vd.getInit$Const().IgnoreParenCasts$Const(), 
                  /* isAlwaysUninit */ true)), 
              /* alwaysReportSelfInit */ true));
        } finally {
          $c$.$destroy();
        }
      } else {
        // Sort the uses by their SourceLocations.  While not strictly
        // guaranteed to produce them in line/column order, this will provide
        // a stable ordering.
        std.sort(vec.begin(), vec.end(), 
            /*[]*/ (final /*const*/ UninitUse /*&*/ a, final /*const*/ UninitUse /*&*/ b) -> {
                  // Prefer a more confident report over a less confident one.
                  if (a.getKind() != b.getKind()) {
                    return a.getKind().getValue() > b.getKind().getValue();
                  }
                  return $less_SourceLocation$C(a.getUser().getLocStart(), b.getUser().getLocStart());
                });
        
        for (final /*const*/ UninitUse /*&*/ U : $Deref(vec)) {
          UninitUse Use = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If we have self-init, downgrade all uses to 'may be uninitialized'.
            Use = $c$.clean(hasSelfInit ? $c$.track(new UninitUse(U.getUser(), false)) : $c$.track(new UninitUse(U)));
            if (DiagnoseUninitializedUse(S, vd, Use)) {
              // Skip further diagnostics for this variable. We try to warn only
              // on the first point at which a variable is used uninitialized.
              break;
            }
          } finally {
            if (Use != null) { Use.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      
      // Release the uses vector.
      if (vec != null) { vec.$destroy();};
    }
    
    uses.clear();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UninitValsDiagReporter::hasAlwaysUninitializedUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1437,
   FQN="(anonymous namespace)::UninitValsDiagReporter::hasAlwaysUninitializedUse", NM="_ZN12_GLOBAL__N_122UninitValsDiagReporter25hasAlwaysUninitializedUseEPKN4llvm11SmallVectorIN5clang9UninitUseELj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UninitValsDiagReporter25hasAlwaysUninitializedUseEPKN4llvm11SmallVectorIN5clang9UninitUseELj2EEE")
  //</editor-fold>
  private static boolean hasAlwaysUninitializedUse(/*const*/SmallVector<UninitUse> /*P*/ vec) {
    return std.any_of(vec.begin$Const(), vec.end$Const(), /*[]*/ (final /*const*/ UninitUse /*&*/ U) -> {
              return U.getKind() == UninitUse.Kind.Always
                 || U.getKind() == UninitUse.Kind.AfterCall
                 || U.getKind() == UninitUse.Kind.AfterDecl;
            });
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", uses=" + uses // NOI18N
              + super.toString(); // NOI18N
  }
}
