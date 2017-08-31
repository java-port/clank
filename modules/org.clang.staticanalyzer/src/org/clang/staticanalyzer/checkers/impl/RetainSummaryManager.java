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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics.*;
import org.clang.analysis.domainspecific.ento.*;
import org.clang.staticanalyzer.checkers.ento.impl.EntoStatics;
import static org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.getKeywordSelector;
import org.llvm.adt.aliases.ImmutableMapUIntType;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 582,
 FQN="(anonymous namespace)::RetainSummaryManager", NM="_ZN12_GLOBAL__N_120RetainSummaryManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManagerE")
//</editor-fold>
public class RetainSummaryManager implements Destructors.ClassWithDestructor {
  
  //==-----------------------------------------------------------------==//
  //  Typedefs.
  //==-----------------------------------------------------------------==//
  // JAVA: typedef llvm::DenseMap<const FunctionDecl *, const RetainSummary *> FuncSummariesTy
//  public final class FuncSummariesTy extends DenseMap</*const*/ FunctionDecl /*P*/ , /*const*/ RetainSummary /*P*/ >{ };
  
  // JAVA: typedef ObjCSummaryCache ObjCMethodSummariesTy
//  public final class ObjCMethodSummariesTy extends ObjCSummaryCache{ };
  
  // JAVA: typedef llvm::FoldingSetNodeWrapper<RetainSummary> CachedSummaryNode
//  public final class CachedSummaryNode extends FoldingSetNodeWrapper<RetainSummary>{ };
  
  //==-----------------------------------------------------------------==//
  //  Data.
  //==-----------------------------------------------------------------==//
  
  /// Ctx - The ASTContext object for the analyzed ASTs.
  private final ASTContext /*&*/ Ctx;
  
  /// GCEnabled - Records whether or not the analyzed code runs in GC mode.
  private /*const*/boolean GCEnabled;
  
  /// Records whether or not the analyzed code runs in ARC mode.
  private /*const*/boolean ARCEnabled;
  
  /// FuncSummaries - A map from FunctionDecls to summaries.
  private DenseMap</*const*/ FunctionDecl /*P*/ , /*const*/ RetainSummary /*P*/ > FuncSummaries;
  
  /// ObjCClassMethodSummaries - A map from selectors (for instance methods)
  ///  to summaries.
  private ObjCSummaryCache ObjCClassMethodSummaries;
  
  /// ObjCMethodSummaries - A map from selectors to summaries.
  private ObjCSummaryCache ObjCMethodSummaries;
  
  /// BPAlloc - A BumpPtrAllocator used for allocating summaries, ArgEffects,
  ///  and all other data used by the checker.
  private BumpPtrAllocatorImpl BPAlloc;
  
  /// AF - A factory for ArgEffects objects.
  private ImmutableMapUIntType.Factory<objc_retain.ArgEffect> AF;
  
  /// ScratchArgs - A holding buffer for construct ArgEffects.
  private ImmutableMapUIntType<objc_retain.ArgEffect> ScratchArgs;
  
  /// ObjCAllocRetE - Default return effect for methods returning Objective-C
  ///  objects.
  private objc_retain.RetEffect ObjCAllocRetE;
  
  /// ObjCInitRetE - Default return effect for init methods returning
  ///   Objective-C objects.
  private objc_retain.RetEffect ObjCInitRetE;
  
  /// SimpleSummaries - Used for uniquing summaries that don't have special
  /// effects.
  private FoldingSet<FoldingSetNodeWrapper<RetainSummary>> SimpleSummaries;
  
  //==-----------------------------------------------------------------==//
  //  Methods.
  //==-----------------------------------------------------------------==//
  
  /// getArgEffects - Returns a persistent ArgEffects object based on the
  ///  data in ScratchArgs.
  // end anonymous namespace

  //===----------------------------------------------------------------------===//
  // Implementation of checker data structures.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getArgEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 851,
   FQN="(anonymous namespace)::RetainSummaryManager::getArgEffects", NM="_ZN12_GLOBAL__N_120RetainSummaryManager13getArgEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager13getArgEffectsEv")
  //</editor-fold>
  private ImmutableMapUIntType<objc_retain.ArgEffect> getArgEffects() {
    ImmutableMapUIntType<objc_retain.ArgEffect> AE = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AE = new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs);
      $c$.clean(ScratchArgs.$assign($c$.track(AF.getEmptyMap())));
      return new ImmutableMapUIntType<objc_retain.ArgEffect>(AE);
    } finally {
      if (AE != null) { AE.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::UnaryFuncKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 648,
   FQN="(anonymous namespace)::RetainSummaryManager::UnaryFuncKind", NM="_ZN12_GLOBAL__N_120RetainSummaryManager13UnaryFuncKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager13UnaryFuncKindE")
  //</editor-fold>
  private enum UnaryFuncKind implements Native.NativeUIntEnum {
    cfretain(0),
    cfrelease(cfretain.getValue() + 1),
    cfautorelease(cfrelease.getValue() + 1),
    cfmakecollectable(cfautorelease.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UnaryFuncKind valueOf(int val) {
      UnaryFuncKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UnaryFuncKind[] VALUES;
      private static final UnaryFuncKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UnaryFuncKind kind : UnaryFuncKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UnaryFuncKind[min < 0 ? (1-min) : 0];
        VALUES = new UnaryFuncKind[max >= 0 ? (1+max) : 0];
        for (UnaryFuncKind kind : UnaryFuncKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private UnaryFuncKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getUnarySummary">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1258,
   FQN="(anonymous namespace)::RetainSummaryManager::getUnarySummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager15getUnarySummaryEPKN5clang12FunctionTypeENS0_13UnaryFuncKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager15getUnarySummaryEPKN5clang12FunctionTypeENS0_13UnaryFuncKindE")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getUnarySummary(/*const*/ FunctionType /*P*/ FT, 
                 UnaryFuncKind func) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Sanity check that this is *really* a unary function.  This can
      // happen if people do weird things.
      /*const*/ FunctionProtoType /*P*/ FTP = dyn_cast_FunctionProtoType(FT);
      if (!(FTP != null) || FTP.getNumParams() != 1) {
        return getPersistentStopSummary();
      }
      assert (ScratchArgs.isEmpty());
      
    objc_retain.ArgEffect Effect = objc_retain.ArgEffect.DoNothing; // JAVA: in native it is not initialized
      switch (func) {
       case cfretain:
        Effect = ArgEffect.IncRef;
        break;
       case cfrelease:
        Effect = ArgEffect.DecRef;
        break;
       case cfautorelease:
        Effect = ArgEffect.Autorelease;
        break;
       case cfmakecollectable:
        Effect = ArgEffect.MakeCollectable;
        break;
      }
      
      $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 0, Effect))));
      return getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getCFSummaryCreateRule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1282,
   FQN="(anonymous namespace)::RetainSummaryManager::getCFSummaryCreateRule", NM="_ZN12_GLOBAL__N_120RetainSummaryManager22getCFSummaryCreateRuleEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager22getCFSummaryCreateRuleEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getCFSummaryCreateRule(/*const*/ FunctionDecl /*P*/ FD) {
    assert (ScratchArgs.isEmpty());
    
    return getPersistentSummary(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getCFSummaryGetRule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1289,
   FQN="(anonymous namespace)::RetainSummaryManager::getCFSummaryGetRule", NM="_ZN12_GLOBAL__N_120RetainSummaryManager19getCFSummaryGetRuleEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager19getCFSummaryGetRuleEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getCFSummaryGetRule(/*const*/ FunctionDecl /*P*/ FD) {
    assert (ScratchArgs.isEmpty());
    return getPersistentSummary(RetEffect.MakeNotOwned(RetEffect.ObjKind.CF), 
        ArgEffect.DoNothing, ArgEffect.DoNothing);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getCFCreateGetRuleSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1250,
   FQN="(anonymous namespace)::RetainSummaryManager::getCFCreateGetRuleSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager25getCFCreateGetRuleSummaryEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager25getCFCreateGetRuleSummaryEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getCFCreateGetRuleSummary(/*const*/ FunctionDecl /*P*/ FD) {
    if (coreFoundation.followsCreateRule(FD)) {
      return getCFSummaryCreateRule(FD);
    }
    
    return getCFSummaryGetRule(FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getPersistentSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone for FoldingSetNodeWrapper*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 857,
   FQN="(anonymous namespace)::RetainSummaryManager::getPersistentSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager20getPersistentSummaryERKNS_13RetainSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager20getPersistentSummaryERKNS_13RetainSummaryE")
  //</editor-fold>
  /*package*//*friend*//*private*/ /*const*/ RetainSummary /*P*/ getPersistentSummary(final /*const*/ RetainSummary /*&*/ OldSumm) {
    // Unique "simple" summaries -- those without ArgEffects.
    if (OldSumm.isSimple()) {
      FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
      OldSumm.Profile(ID);
      
      final type$ref<type$ptr<FoldingSetNodeWrapper<RetainSummary> /*P*/>/*void P*/ > Pos = create_type$ref(null);
      FoldingSetNodeWrapper<RetainSummary> /*P*/ N = SimpleSummaries.FindNodeOrInsertPos(ID, Pos);
      if (!(N != null)) {
        N = (FoldingSetNodeWrapper<RetainSummary> /*P*/ )BPAlloc.Allocate$T(FoldingSetNodeWrapper.class);
        /*NEW_EXPR [System]*/N = /*new (N)*/ $new_uint_voidPtr(N, (type$ptr<?> New$Mem)->{
            return new FoldingSetNodeWrapper<RetainSummary>($Clone(OldSumm));
         });
        SimpleSummaries.InsertNode(N, Pos.$deref());
      }
      
      return $AddrOf(N.getValue());
    }
    
    RetainSummary /*P*/ Summ = (RetainSummary /*P*/ )BPAlloc.<RetainSummary>Allocate$T(RetainSummary.class);
    /*NEW_EXPR [System]*/Summ = /*new (Summ)*/ $new_uint_voidPtr(Summ, (type$ptr<?> New$Mem)->{
        return new RetainSummary(OldSumm);
     });
    return Summ;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getPersistentSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 659,
   FQN="(anonymous namespace)::RetainSummaryManager::getPersistentSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager20getPersistentSummaryEN5clang4ento11objc_retain9RetEffectENS3_9ArgEffectES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager20getPersistentSummaryEN5clang4ento11objc_retain9RetEffectENS3_9ArgEffectES5_")
  //</editor-fold>
  /*package*//*friend*//*private*/ /*const*/ RetainSummary /*P*/ getPersistentSummary(objc_retain.RetEffect RetEff) {
    return getPersistentSummary(RetEff, 
                      ArgEffect.DoNothing, 
                      ArgEffect.MayEscape);
  }
  /*package*//*friend*//*private*/ /*const*/ RetainSummary /*P*/ getPersistentSummary(objc_retain.RetEffect RetEff, 
                      objc_retain.ArgEffect ReceiverEff/*= DoNothing*/) {
    return getPersistentSummary(RetEff, 
                      ReceiverEff, 
                      ArgEffect.MayEscape);
  }
  /*package*//*friend*//*private*/ /*const*/ RetainSummary /*P*/ getPersistentSummary(objc_retain.RetEffect RetEff, 
                      objc_retain.ArgEffect ReceiverEff/*= DoNothing*/, 
                      objc_retain.ArgEffect DefaultEff/*= MayEscape*/) {
    RetainSummary Summ = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Summ/*J*/= $c$.clean(new RetainSummary($c$.track(getArgEffects()), new objc_retain.RetEffect(RetEff), DefaultEff, ReceiverEff));
      return getPersistentSummary(Summ);
    } finally {
      if (Summ != null) { Summ.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getDoNothingSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 666,
   FQN="(anonymous namespace)::RetainSummaryManager::getDoNothingSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager19getDoNothingSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager19getDoNothingSummaryEv")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getDoNothingSummary() {
    return getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getDefaultSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 670,
   FQN="(anonymous namespace)::RetainSummaryManager::getDefaultSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager17getDefaultSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager17getDefaultSummaryEv")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getDefaultSummary() {
    return getPersistentSummary(RetEffect.MakeNoRet(), 
        ArgEffect.DoNothing, ArgEffect.MayEscape);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getPersistentStopSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 675,
   FQN="(anonymous namespace)::RetainSummaryManager::getPersistentStopSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager24getPersistentStopSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager24getPersistentStopSummaryEv")
  //</editor-fold>
  private /*const*/ RetainSummary /*P*/ getPersistentStopSummary() {
    return getPersistentSummary(RetEffect.MakeNoRet(), 
        ArgEffect.StopTracking, ArgEffect.StopTracking);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::InitializeClassMethodSummaries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1552,
   FQN="(anonymous namespace)::RetainSummaryManager::InitializeClassMethodSummaries", NM="_ZN12_GLOBAL__N_120RetainSummaryManager30InitializeClassMethodSummariesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager30InitializeClassMethodSummariesEv")
  //</editor-fold>
  private void InitializeClassMethodSummaries() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (ScratchArgs.isEmpty());
      // Create the [NSAssertionHandler currentHander] summary.
      addClassMethSummary($("NSAssertionHandler"), $("currentHandler"), 
          getPersistentSummary(RetEffect.MakeNotOwned(RetEffect.ObjKind.ObjC)));
      
      // Create the [NSAutoreleasePool addObject:] summary.
      $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 0, ArgEffect.Autorelease))));
      addClassMethSummary($("NSAutoreleasePool"), $("addObject"), 
          getPersistentSummary(RetEffect.MakeNoRet(), 
              ArgEffect.DoNothing, ArgEffect.Autorelease));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::InitializeMethodSummaries">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1565,
   FQN="(anonymous namespace)::RetainSummaryManager::InitializeMethodSummaries", NM="_ZN12_GLOBAL__N_120RetainSummaryManager25InitializeMethodSummariesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager25InitializeMethodSummariesEv")
  //</editor-fold>
  private void InitializeMethodSummaries() {
    assert (ScratchArgs.isEmpty());
    
    // Create the "init" selector.  It just acts as a pass-through for the
    // receiver.
    /*const*/ RetainSummary /*P*/ InitSumm = getPersistentSummary(new objc_retain.RetEffect(ObjCInitRetE), ArgEffect.DecRefMsg);
    addNSObjectMethSummary(GetNullarySelector(new StringRef(/*KEEP_STR*/"init"), Ctx), InitSumm);
    
    // awakeAfterUsingCoder: behaves basically like an 'init' method.  It
    // claims the receiver and returns a retained object.
    addNSObjectMethSummary(GetUnarySelector(new StringRef(/*KEEP_STR*/"awakeAfterUsingCoder"), Ctx), 
        InitSumm);
    
    // The next methods are allocators.
    /*const*/ RetainSummary /*P*/ AllocSumm = getPersistentSummary(new objc_retain.RetEffect(ObjCAllocRetE));
    /*const*/ RetainSummary /*P*/ CFAllocSumm = getPersistentSummary(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true));
    
    // Create the "retain" selector.
    objc_retain.RetEffect NoRet = RetEffect.MakeNoRet();
    /*const*/ RetainSummary /*P*/ Summ = getPersistentSummary(new objc_retain.RetEffect(NoRet), ArgEffect.IncRefMsg);
    addNSObjectMethSummary(GetNullarySelector(new StringRef(/*KEEP_STR*/"retain"), Ctx), Summ);
    
    // Create the "release" selector.
    Summ = getPersistentSummary(new objc_retain.RetEffect(NoRet), ArgEffect.DecRefMsg);
    addNSObjectMethSummary(GetNullarySelector(new StringRef(/*KEEP_STR*/"release"), Ctx), Summ);
    
    // Create the -dealloc summary.
    Summ = getPersistentSummary(new objc_retain.RetEffect(NoRet), ArgEffect.Dealloc);
    addNSObjectMethSummary(GetNullarySelector(new StringRef(/*KEEP_STR*/"dealloc"), Ctx), Summ);
    
    // Create the "autorelease" selector.
    Summ = getPersistentSummary(new objc_retain.RetEffect(NoRet), ArgEffect.Autorelease);
    addNSObjectMethSummary(GetNullarySelector(new StringRef(/*KEEP_STR*/"autorelease"), Ctx), Summ);
    
    // For NSWindow, allocated objects are (initially) self-owned.
    // FIXME: For now we opt for false negatives with NSWindow, as these objects
    //  self-own themselves.  However, they only do this once they are displayed.
    //  Thus, we need to track an NSWindow's display status.
    //  This is tracked in <rdar://problem/6062711>.
    //  See also http://llvm.org/bugs/show_bug.cgi?id=3714.
    /*const*/ RetainSummary /*P*/ NoTrackYet = getPersistentSummary(RetEffect.MakeNoRet(), 
        ArgEffect.StopTracking, 
        ArgEffect.StopTracking);
    
    addClassMethSummary($("NSWindow"), $("alloc"), NoTrackYet);
    
    // For NSPanel (which subclasses NSWindow), allocated objects are not
    //  self-owned.
    // FIXME: For now we don't track NSPanels. object for the same reason
    //   as for NSWindow objects.
    addClassMethSummary($("NSPanel"), $("alloc"), NoTrackYet);
    
    // For NSNull, objects returned by +null are singletons that ignore
    // retain/release semantics.  Just don't track them.
    // <rdar://problem/12858915>
    addClassMethSummary($("NSNull"), $("null"), NoTrackYet);
    
    // Don't track allocated autorelease pools, as it is okay to prematurely
    // exit a method.
    addClassMethSummary($("NSAutoreleasePool"), $("alloc"), NoTrackYet);
    addClassMethSummary($("NSAutoreleasePool"), $("allocWithZone"), NoTrackYet, false);
    addClassMethSummary($("NSAutoreleasePool"), $("new"), NoTrackYet);
    
    // Create summaries QCRenderer/QCView -createSnapShotImageOfType:
    addInstMethSummary($("QCRenderer"), AllocSumm, 
        $("createSnapshotImageOfType"), null);
    addInstMethSummary($("QCView"), AllocSumm, 
        $("createSnapshotImageOfType"), null);
    
    // Create summaries for CIContext, 'createCGImage' and
    // 'createCGLayerWithSize'.  These objects are CF objects, and are not
    // automatically garbage collected.
    addInstMethSummary($("CIContext"), CFAllocSumm, 
        $("createCGImage"), $("fromRect"), null);
    addInstMethSummary($("CIContext"), CFAllocSumm, $("createCGImage"), $("fromRect"), 
        $("format"), $("colorSpace"), null);
    addInstMethSummary($("CIContext"), CFAllocSumm, $("createCGLayerWithSize"), $("info"), 
        null);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addNSObjectClsMethSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 683,
   FQN="(anonymous namespace)::RetainSummaryManager::addNSObjectClsMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager25addNSObjectClsMethSummaryEN5clang8SelectorEPKNS_13RetainSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager25addNSObjectClsMethSummaryEN5clang8SelectorEPKNS_13RetainSummaryE")
  //</editor-fold>
  private void addNSObjectClsMethSummary(Selector S, /*const*/ RetainSummary /*P*/ Summ) {
    ObjCClassMethodSummaries.$set(/*NO_COPY*/S, Summ);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addNSObjectMethSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 687,
   FQN="(anonymous namespace)::RetainSummaryManager::addNSObjectMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager22addNSObjectMethSummaryEN5clang8SelectorEPKNS_13RetainSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager22addNSObjectMethSummaryEN5clang8SelectorEPKNS_13RetainSummaryE")
  //</editor-fold>
  private void addNSObjectMethSummary(Selector S, /*const*/ RetainSummary /*P*/ Summ) {
    ObjCMethodSummaries.$set(/*NO_COPY*/S, Summ);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addClassMethSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 691,
   FQN="(anonymous namespace)::RetainSummaryManager::addClassMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager19addClassMethSummaryEPKcS2_PKNS_13RetainSummaryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager19addClassMethSummaryEPKcS2_PKNS_13RetainSummaryEb")
  //</editor-fold>
  private void addClassMethSummary(/*const*/char$ptr/*char P*/ Cls, /*const*/char$ptr/*char P*/ name, 
                     /*const*/ RetainSummary /*P*/ Summ) {
    addClassMethSummary(Cls, name, 
                     Summ, true);
  }
  private void addClassMethSummary(/*const*/char$ptr/*char P*/ Cls, /*const*/char$ptr/*char P*/ name, 
                     /*const*/ RetainSummary /*P*/ Summ, boolean isNullary/*= true*/) {
    IdentifierInfo /*P*/ ClsII = $AddrOf(Ctx.Idents.get(new StringRef(Cls)));
    Selector S = isNullary ? GetNullarySelector(new StringRef(name), Ctx) : GetUnarySelector(new StringRef(name), Ctx);
    ObjCClassMethodSummaries.$set(new ObjCSummaryKey(ClsII, new Selector(S)), Summ);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addInstMethSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 699,
   FQN="(anonymous namespace)::RetainSummaryManager::addInstMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager18addInstMethSummaryEPKcS2_PKNS_13RetainSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager18addInstMethSummaryEPKcS2_PKNS_13RetainSummaryE")
  //</editor-fold>
  private void addInstMethSummary(/*const*/char$ptr/*char P*/ Cls, /*const*/char$ptr/*char P*/ nullaryName, 
                    /*const*/ RetainSummary /*P*/ Summ) {
    IdentifierInfo /*P*/ ClsII = $AddrOf(Ctx.Idents.get(new StringRef(Cls)));
    Selector S = GetNullarySelector(new StringRef(nullaryName), Ctx);
    ObjCMethodSummaries.$set(new ObjCSummaryKey(ClsII, new Selector(S)), Summ);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addMethodSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*char$ptr => type$ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 706,
   FQN="(anonymous namespace)::RetainSummaryManager::addMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager16addMethodSummaryEPN5clang14IdentifierInfoERNS_16ObjCSummaryCacheEPKNS_13RetainSummaryEPc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager16addMethodSummaryEPN5clang14IdentifierInfoERNS_16ObjCSummaryCacheEPKNS_13RetainSummaryEPc")
  //</editor-fold>
  private void addMethodSummary(IdentifierInfo /*P*/ ClsII, final ObjCSummaryCache /*&*/ Summaries, 
                  /*const*/ RetainSummary /*P*/ Summ, type$ptr argp) {
    Selector S = EntoStatics.getKeywordSelector(Ctx, argp);
    Summaries.$set(new ObjCSummaryKey(ClsII, new Selector(S)), Summ);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addInstMethSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 712,
   FQN="(anonymous namespace)::RetainSummaryManager::addInstMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager18addInstMethSummaryEPKcPKNS_13RetainSummaryEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager18addInstMethSummaryEPKcPKNS_13RetainSummaryEz")
  //</editor-fold>
  private void addInstMethSummary(/*const*/char$ptr/*char P*/ Cls, /*const*/ RetainSummary /*P*/ Summ, Object ... $VarArg) {
    type$ptr/*char P*/ argp = create_type$ptr();
    __builtin_va_start($VarArg, argp, Summ);
    addMethodSummary($AddrOf(Ctx.Idents.get(new StringRef(Cls))), ObjCMethodSummaries, Summ, argp);
    __builtin_va_end(argp);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addClsMethSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 719,
   FQN="(anonymous namespace)::RetainSummaryManager::addClsMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager17addClsMethSummaryEPKcPKNS_13RetainSummaryEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager17addClsMethSummaryEPKcPKNS_13RetainSummaryEz")
  //</editor-fold>
  private void addClsMethSummary(/*const*/char$ptr/*char P*/ Cls, /*const*/ RetainSummary /*P*/ Summ, Object ... $VarArg) {
    type$ptr/*char P*/ argp = create_type$ptr();
    __builtin_va_start($VarArg, argp, Summ);
    addMethodSummary($AddrOf(Ctx.Idents.get(new StringRef(Cls))), ObjCClassMethodSummaries, Summ, argp);
    __builtin_va_end(argp);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::addClsMethSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 726,
   FQN="(anonymous namespace)::RetainSummaryManager::addClsMethSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager17addClsMethSummaryEPN5clang14IdentifierInfoEPKNS_13RetainSummaryEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager17addClsMethSummaryEPN5clang14IdentifierInfoEPKNS_13RetainSummaryEz")
  //</editor-fold>
  private void addClsMethSummary(IdentifierInfo /*P*/ II, /*const*/ RetainSummary /*P*/ Summ, Object ... $VarArg) {
    type$ptr/*char P*/ argp = create_type$ptr();
    __builtin_va_start($VarArg, argp, Summ);
    addMethodSummary(II, ObjCClassMethodSummaries, Summ, argp);
    __builtin_va_end(argp);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::RetainSummaryManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 735,
   FQN="(anonymous namespace)::RetainSummaryManager::RetainSummaryManager", NM="_ZN12_GLOBAL__N_120RetainSummaryManagerC1ERN5clang10ASTContextEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManagerC1ERN5clang10ASTContextEbb")
  //</editor-fold>
  public RetainSummaryManager(final ASTContext /*&*/ ctx, boolean gcenabled, boolean usesARC) {
    // : Ctx(ctx), GCEnabled(gcenabled), ARCEnabled(usesARC), FuncSummaries(), ObjCClassMethodSummaries(), ObjCMethodSummaries(), BPAlloc(), AF(BPAlloc), ScratchArgs($c$.track(AF.getEmptyMap())), ObjCAllocRetE(gcenabled ? RetEffect::MakeGCNotOwned() : (usesARC ? RetEffect::MakeNotOwned(RetEffect::ObjC) : RetEffect::MakeOwned(RetEffect::ObjC, true))), ObjCInitRetE(gcenabled ? RetEffect::MakeGCNotOwned() : (usesARC ? RetEffect::MakeNotOwned(RetEffect::ObjC) : RetEffect::MakeOwnedWhenTrackedReceiver())), SimpleSummaries() 
    //START JInit
    this./*&*/Ctx=/*&*/ctx;
    this.GCEnabled = gcenabled;
    this.ARCEnabled = usesARC;
    this.FuncSummaries = new DenseMap</*const*/ FunctionDecl /*P*/ , /*const*/ RetainSummary /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ RetainSummary /*P*/ )null);
    this.ObjCClassMethodSummaries = new ObjCSummaryCache();
    this.ObjCMethodSummaries = new ObjCSummaryCache();
    this.BPAlloc = new BumpPtrAllocatorImpl(new MallocAllocator(), 4096, 4096);
    this.AF = new ImmutableMapUIntType.Factory<objc_retain.ArgEffect>(new ImutKeyValueInfo$UIntType<objc_retain.ArgEffect>(
            new ImutContainerInfo<objc_retain.ArgEffect>(new DefaultFoldingSetTrait<objc_retain.ArgEffect>())), 
            BPAlloc);
    this.ScratchArgs = AF.getEmptyMap();
    this.ObjCAllocRetE = gcenabled ? RetEffect.MakeGCNotOwned() : (usesARC ? RetEffect.MakeNotOwned(RetEffect.ObjKind.ObjC) : RetEffect.MakeOwned(RetEffect.ObjKind.ObjC, true));
    this.ObjCInitRetE = gcenabled ? RetEffect.MakeGCNotOwned() : (usesARC ? RetEffect.MakeNotOwned(RetEffect.ObjKind.ObjC) : RetEffect.MakeOwnedWhenTrackedReceiver());
    this.SimpleSummaries = new FoldingSet<FoldingSetNodeWrapper<RetainSummary>>(FoldingSetNodeWrapper.$Trait());
    //END JInit
    InitializeClassMethodSummaries();
    InitializeMethodSummaries();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getSummary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 993,
   FQN="(anonymous namespace)::RetainSummaryManager::getSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager10getSummaryERKN5clang4ento9CallEventEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager10getSummaryERKN5clang4ento9CallEventEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getSummary(final /*const*/ CallEvent /*&*/ Call) {
    // JAVA: Wrap into cleaner logic
    JavaCleaner $c$ = $createJavaCleaner();
    try {
    return $c$.clean(getSummary(Call, 
            $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))));
    } finally {
      $c$.$destroy();
    }
  }
  public /*const*/ RetainSummary /*P*/ getSummary(final /*const*/ CallEvent /*&*/ Call, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/) {
    type$ref</*const*/ RetainSummary /*P*/ > Summ = create_type$ref();
    switch (Call.getKind()) {
     case CE_Function:
      Summ.$set(getFunctionSummary(cast_SimpleFunctionCall(Call).getDecl()));
      break;
     case CE_CXXMember:
     case CE_CXXMemberOperator:
     case CE_Block:
     case CE_CXXConstructor:
     case CE_CXXDestructor:
     case CE_CXXAllocator:
      // FIXME: These calls are currently unsupported.
      return getPersistentStopSummary();
     case CE_ObjCMessage:
      {
        final /*const*/ ObjCMethodCall /*&*/ Msg = cast_ObjCMethodCall(Call);
        if (Msg.isInstanceMessage()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Summ.$set(getInstanceMethodSummary(Msg, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)))));
          } finally {
            $c$.$destroy();
          }
        } else {
          Summ.$set(getClassMethodSummary(Msg));
        }
        break;
      }
    }
    
    updateSummaryForCall(Summ, Call);
    assert ((Summ.$deref() != null)) : "Unknown call type?";
    return Summ.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getFunctionSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1025,
   FQN="(anonymous namespace)::RetainSummaryManager::getFunctionSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager18getFunctionSummaryEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager18getFunctionSummaryEPKN5clang12FunctionDeclE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getFunctionSummary(/*const*/ FunctionDecl /*P*/ FD) {
    // If we don't know what function we're calling, use our default summary.
    if (!(FD != null)) {
      return getDefaultSummary();
    }
    
    // Look up a summary in our cache of FunctionDecls -> Summaries.
    DenseMapIterator</*const*/ FunctionDecl /*P*/ , /*const*/ RetainSummary /*P*/ > I = FuncSummaries.find(FD);
    if (I.$noteq(/*NO_ITER_COPY*/FuncSummaries.end())) {
      return I.$arrow().second;
    }
    
    // No summary?  Generate one.
    type$ref</*const*/ RetainSummary /*P*/ > S = create_type$null$ref(null);
    boolean AllowAnnotations = true;
    
    do {
      // We generate "stop" summaries for implicitly defined functions.
      if (FD.isImplicit()) {
        S.$set(getPersistentStopSummary());
        break;
      }
      
      // [PR 3337] Use 'getAs<FunctionType>' to strip away any typedefs on the
      // function's type.
      /*const*/ FunctionType /*P*/ FT = FD.getType().$arrow().getAs(FunctionType.class);
      /*const*/ IdentifierInfo /*P*/ II = FD.getIdentifier();
      if (!(II != null)) {
        break;
      }
      
      StringRef FName = II.getName();
      
      // Strip away preceding '_'.  Doing this here will effect all the checks
      // down below.
      FName.$assignMove(FName.substr(FName.find_first_not_of($$UNDERSCORE)));
      
      // Inspect the result type.
      QualType RetTy = FT.getReturnType();
      
      // FIXME: This should all be refactored into a chain of "summary lookup"
      //  filters.
      assert (ScratchArgs.isEmpty());
      if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_create") || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_setspecific")) {
        // Part of: <rdar://problem/7299394> and <rdar://problem/11282706>.
        // This will be addressed better with IPA.
        S.$set(getPersistentStopSummary());
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"NSMakeCollectable")) {
        // Handle: id NSMakeCollectable(CFTypeRef)
        S.$set((RetTy.$arrow().isObjCIdType()) ? getUnarySummary(FT, UnaryFuncKind.cfmakecollectable) : getPersistentStopSummary());
        // The headers on OS X 10.8 use cf_consumed/ns_returns_retained,
        // but we can fully model NSMakeCollectable ourselves.
        AllowAnnotations = false;
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CFPlugInInstanceCreate")) {
        S.$set(getPersistentSummary(RetEffect.MakeNoRet()));
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOBSDNameMatching")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceMatching")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceNameMatching")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IORegistryEntrySearchCFProperty")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IORegistryEntryIDMatching")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOOpenFirmwarePathMatching")) {
        // Part of <rdar://problem/6961230>. (IOKit)
        // This should be addressed using a API table.
        S.$set(getPersistentSummary(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true), 
            ArgEffect.DoNothing, ArgEffect.DoNothing));
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceGetMatchingService")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceGetMatchingServices")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXES: <rdar://problem/6326900>
          // This should be addressed using a API table.  This strcmp is also
          // a little gross, but there is no need to super optimize here.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 1, ArgEffect.DecRef))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceAddNotification")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"IOServiceAddMatchingNotification")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Part of <rdar://problem/6961230>. (IOKit)
          // This should be addressed using a API table.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 2, ArgEffect.DecRef))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CVPixelBufferCreateWithBytes")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXES: <rdar://problem/7283567>
          // Eventually this can be improved by recognizing that the pixel
          // buffer passed to CVPixelBufferCreateWithBytes is released via
          // a callback and doing full IPA to make sure this is done correctly.
          // FIXME: This function has an out parameter that returns an
          // allocated object.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 7, ArgEffect.StopTracking))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CGBitmapContextCreateWithData")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXES: <rdar://problem/7358899>
          // Eventually this can be improved by recognizing that 'releaseInfo'
          // passed to CGBitmapContextCreateWithData is released via
          // a callback and doing full IPA to make sure this is done correctly.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 8, ArgEffect.StopTracking))));
          S.$set(getPersistentSummary(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true), 
              ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CVPixelBufferCreateWithPlanarBytes")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXES: <rdar://problem/7283567>
          // Eventually this can be improved by recognizing that the pixel
          // buffer passed to CVPixelBufferCreateWithPlanarBytes is released
          // via a callback and doing full IPA to make sure this is done
          // correctly.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 12, ArgEffect.StopTracking))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"dispatch_set_context")
         || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"xpc_connection_set_context")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // <rdar://problem/11059275> - The analyzer currently doesn't have
          // a good way to reason about the finalizer function for libdispatch.
          // If we pass a context object that is memory managed, stop tracking it.
          // <rdar://problem/13783514> - Same problem, but for XPC.
          // FIXME: this hack should possibly go away once we can handle
          // libdispatch and XPC finalizers.
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 1, ArgEffect.StopTracking))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      } else if (FName.startswith(/*STRINGREF_STR*/"NSLog")) {
        S.$set(getDoNothingSummary());
      } else if (FName.startswith(/*STRINGREF_STR*/"NS")
         && (FName.find(/*STRINGREF_STR*/"Insert") != StringRef.npos)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Whitelist NSXXInsertXX, for example NSMapInsertIfAbsent, since they can
          // be deallocated by NSMapRemove. (radar://11152419)
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 1, ArgEffect.StopTracking))));
          $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), 2, ArgEffect.StopTracking))));
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, ArgEffect.DoNothing));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Did we get a summary?
      if ((S.$deref() != null)) {
        break;
      }
      if (RetTy.$arrow().isPointerType()) {
        // For CoreFoundation ('CF') types.
        if (cocoa.isRefType(new QualType(RetTy), new StringRef(/*KEEP_STR*/"CF"), new StringRef(FName))) {
          if (RetainCountCheckerStatics.isRetain(FD, new StringRef(FName))) {
            S.$set(getUnarySummary(FT, UnaryFuncKind.cfretain));
          } else if (RetainCountCheckerStatics.isAutorelease(FD, new StringRef(FName))) {
            S.$set(getUnarySummary(FT, UnaryFuncKind.cfautorelease));
            // The headers use cf_consumed, but we can fully model CFAutorelease
            // ourselves.
            AllowAnnotations = false;
          } else if (RetainCountCheckerStatics.isMakeCollectable(FD, new StringRef(FName))) {
            S.$set(getUnarySummary(FT, UnaryFuncKind.cfmakecollectable));
            AllowAnnotations = false;
          } else {
            S.$set(getCFCreateGetRuleSummary(FD));
          }
          
          break;
        }
        
        // For CoreGraphics ('CG') types.
        if (cocoa.isRefType(new QualType(RetTy), new StringRef(/*KEEP_STR*/"CG"), new StringRef(FName))) {
          if (RetainCountCheckerStatics.isRetain(FD, new StringRef(FName))) {
            S.$set(getUnarySummary(FT, UnaryFuncKind.cfretain));
          } else {
            S.$set(getCFCreateGetRuleSummary(FD));
          }
          
          break;
        }
        
        // For the Disk Arbitration API (DiskArbitration/DADisk.h)
        if (cocoa.isRefType(new QualType(RetTy), new StringRef(/*KEEP_STR*/"DADisk"))
           || cocoa.isRefType(new QualType(RetTy), new StringRef(/*KEEP_STR*/"DADissenter"))
           || cocoa.isRefType(new QualType(RetTy), new StringRef(/*KEEP_STR*/"DASessionRef"))) {
          S.$set(getCFCreateGetRuleSummary(FD));
          break;
        }
        if (FD.hasAttr(CFAuditedTransferAttr.class)) {
          S.$set(getCFCreateGetRuleSummary(FD));
          break;
        }
        
        break;
      }
      
      // Check for release functions, the only kind of functions that we care
      // about that don't return a pointer type.
      if (FName.$at(0) == $$C && (FName.$at(1) == $$F || FName.$at(1) == $$G)) {
        // Test for 'CGCF'.
        FName.$assignMove(FName.substr(FName.startswith(/*STRINGREF_STR*/"CGCF") ? 4 : 2));
        if (RetainCountCheckerStatics.isRelease(FD, new StringRef(FName))) {
          S.$set(getUnarySummary(FT, UnaryFuncKind.cfrelease));
        } else {
          assert (ScratchArgs.isEmpty());
          // Remaining CoreFoundation and CoreGraphics functions.
          // We use to assume that they all strictly followed the ownership idiom
          // and that ownership cannot be transferred.  While this is technically
          // correct, many methods allow a tracked object to escape.  For example:
          //
          //   CFMutableDictionaryRef x = CFDictionaryCreateMutable(...);
          //   CFDictionaryAddValue(y, key, x);
          //   CFRelease(x);
          //   ... it is okay to use 'x' since 'y' has a reference to it
          //
          // We handle this and similar cases with the follow heuristic.  If the
          // function name contains "InsertValue", "SetValue", "AddValue",
          // "AppendValue", or "SetAttribute", then we assume that arguments may
          // "escape."  This means that something else holds on to the object,
          // allowing it be used even after its local retain count drops to 0.
          objc_retain.ArgEffect E = (StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"InsertValue")) != StringRef.npos
             || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"AddValue")) != StringRef.npos
             || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"SetValue")) != StringRef.npos
             || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"AppendValue")) != StringRef.npos
             || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"SetAttribute")) != StringRef.npos) ? ArgEffect.MayEscape : ArgEffect.DoNothing;
          
          S.$set(getPersistentSummary(RetEffect.MakeNoRet(), ArgEffect.DoNothing, E));
        }
      }
    } while (false);
    
    // If we got all the way here without any luck, use a default summary.
    if (!(S.$deref() != null)) {
      S.$set(getDefaultSummary());
    }
    
    // Annotations override defaults.
    if (AllowAnnotations) {
      updateSummaryFromAnnotations(S, FD);
    }
    
    FuncSummaries.$set(FD, S.$deref());
    return S.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getMethodSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1531,
   FQN="(anonymous namespace)::RetainSummaryManager::getMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager16getMethodSummaryEN5clang8SelectorEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclENS1_8QualTypeERNS_16ObjCSummaryCacheE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager16getMethodSummaryEN5clang8SelectorEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclENS1_8QualTypeERNS_16ObjCSummaryCacheE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getMethodSummary(Selector S, /*const*/ ObjCInterfaceDecl /*P*/ ID, 
                  /*const*/ ObjCMethodDecl /*P*/ MD, QualType RetTy, 
                  final ObjCSummaryCache /*&*/ CachedSummaries) {
    
    // Look up a summary in our summary cache.
    type$ref</*const*/ RetainSummary /*P*/ > Summ = create_type$ref(CachedSummaries.find(ID, /*NO_COPY*/S));
    if (!(Summ.$deref() != null)) {
      Summ.$set(getStandardMethodSummary(MD, new Selector(S), new QualType(RetTy)));
      
      // Annotations override defaults.
      updateSummaryFromAnnotations(Summ, MD);
      
      // Memoize the summary.
      CachedSummaries.$set(new ObjCSummaryKey(ID, new Selector(S)), Summ.$deref());
    }
    
    return Summ.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getInstanceMethodSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1497,
   FQN="(anonymous namespace)::RetainSummaryManager::getInstanceMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager24getInstanceMethodSummaryERKN5clang4ento14ObjCMethodCallEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager24getInstanceMethodSummaryERKN5clang4ento14ObjCMethodCallEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getInstanceMethodSummary(final /*const*/ ObjCMethodCall /*&*/ Msg, 
                          IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    /*const*/ ObjCInterfaceDecl /*P*/ ReceiverClass = null;
    
    // We do better tracking of the type of the object than the core ExprEngine.
    // See if we have its type in our private state.
    // FIXME: Eventually replace the use of state->get<RefBindings> with
    // a generic API for reasoning about the Objective-C types of symbolic
    // objects.
    SVal ReceiverV = Msg.getReceiverSVal();
    {
      /*const*/ SymExpr /*P*/ Sym = ReceiverV.getAsLocSymbol();
      if ((Sym != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          {
            /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym));
            if ((T != null)) {
              {
                /*const*/ ObjCObjectPointerType /*P*/ PT = T.getType().$arrow().getAs(ObjCObjectPointerType.class);
                if ((PT != null)) {
                  ReceiverClass = PT.getInterfaceDecl();
                }
              }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If we don't know what kind of object this is, fall back to its static type.
    if (!(ReceiverClass != null)) {
      ReceiverClass = Msg.getReceiverInterface();
    }
    
    // FIXME: The receiver could be a reference to a class, meaning that
    //  we should use the class method.
    // id x = [NSObject class];
    // [x performSelector:... withObject:... afterDelay:...];
    Selector S = Msg.getSelector();
    /*const*/ ObjCMethodDecl /*P*/ Method = Msg.getDecl();
    if (!(Method != null) && (ReceiverClass != null)) {
      Method = ReceiverClass.getInstanceMethod(new Selector(S));
    }
    
    return getMethodSummary(new Selector(S), ReceiverClass, Method, Msg.getResultType(), 
        ObjCMethodSummaries);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getClassMethodSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 765,
   FQN="(anonymous namespace)::RetainSummaryManager::getClassMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager21getClassMethodSummaryERKN5clang4ento14ObjCMethodCallE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager21getClassMethodSummaryERKN5clang4ento14ObjCMethodCallE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getClassMethodSummary(final /*const*/ ObjCMethodCall /*&*/ M) {
    assert (!M.isInstanceMessage());
    /*const*/ ObjCInterfaceDecl /*P*/ Class = M.getReceiverInterface();
    
    return getMethodSummary(M.getSelector(), Class, M.getDecl(), 
        M.getResultType(), ObjCClassMethodSummaries);
  }

  
  /// getMethodSummary - This version of getMethodSummary is used to query
  ///  the summary for the current method being analyzed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getMethodSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 775,
   FQN="(anonymous namespace)::RetainSummaryManager::getMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager16getMethodSummaryEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager16getMethodSummaryEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getMethodSummary(/*const*/ ObjCMethodDecl /*P*/ MD) {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = MD.getClassInterface$Const();
    Selector S = MD.getSelector();
    QualType ResultTy = MD.getReturnType();
    
    ObjCSummaryCache /*P*/ CachedSummaries;
    if (MD.isInstanceMethod()) {
      CachedSummaries = $AddrOf(ObjCMethodSummaries);
    } else {
      CachedSummaries = $AddrOf(ObjCClassMethodSummaries);
    }
    
    return getMethodSummary(new Selector(S), ID, MD, new QualType(ResultTy), $Deref(CachedSummaries));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getStandardMethodSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1401,
   FQN="(anonymous namespace)::RetainSummaryManager::getStandardMethodSummary", NM="_ZN12_GLOBAL__N_120RetainSummaryManager24getStandardMethodSummaryEPKN5clang14ObjCMethodDeclENS1_8SelectorENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager24getStandardMethodSummaryEPKN5clang14ObjCMethodDeclENS1_8SelectorENS1_8QualTypeE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ getStandardMethodSummary(/*const*/ ObjCMethodDecl /*P*/ MD, 
                          Selector S, QualType RetTy) {
    // Any special effects?
    objc_retain.ArgEffect ReceiverEff = ArgEffect.DoNothing;
    objc_retain.RetEffect ResultEff = RetEffect.MakeNoRet();
    
    // Check the method family, and apply any default annotations.
    switch ((MD != null) ? MD.getMethodFamily() : S.getMethodFamily()) {
     case OMF_None:
     case OMF_initialize:
     case OMF_performSelector:
      // Assume all Objective-C methods follow Cocoa Memory Management rules.
      // FIXME: Does the non-threaded performSelector family really belong here?
      // The selector could be, say, @selector(copy).
      if (cocoa.isCocoaObjectRef(new QualType(RetTy))) {
        ResultEff.$assignMove(RetEffect.MakeNotOwned(RetEffect.ObjKind.ObjC));
      } else if (coreFoundation.isCFObjectRef(new QualType(RetTy))) {
        // ObjCMethodDecl currently doesn't consider CF objects as valid return
        // values for alloc, new, copy, or mutableCopy, so we have to
        // double-check with the selector. This is ugly, but there aren't that
        // many Objective-C methods that return CF objects, right?
        if ((MD != null)) {
          switch (S.getMethodFamily()) {
           case OMF_alloc:
           case OMF_new:
           case OMF_copy:
           case OMF_mutableCopy:
            ResultEff.$assignMove(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true));
            break;
           default:
            ResultEff.$assignMove(RetEffect.MakeNotOwned(RetEffect.ObjKind.CF));
            break;
          }
        } else {
          ResultEff.$assignMove(RetEffect.MakeNotOwned(RetEffect.ObjKind.CF));
        }
      }
      break;
     case OMF_init:
      ResultEff.$assign(ObjCInitRetE);
      ReceiverEff = ArgEffect.DecRefMsg;
      break;
     case OMF_alloc:
     case OMF_new:
     case OMF_copy:
     case OMF_mutableCopy:
      if (cocoa.isCocoaObjectRef(new QualType(RetTy))) {
        ResultEff.$assign(ObjCAllocRetE);
      } else if (coreFoundation.isCFObjectRef(new QualType(RetTy))) {
        ResultEff.$assignMove(RetEffect.MakeOwned(RetEffect.ObjKind.CF, true));
      }
      break;
     case OMF_autorelease:
      ReceiverEff = ArgEffect.Autorelease;
      break;
     case OMF_retain:
      ReceiverEff = ArgEffect.IncRefMsg;
      break;
     case OMF_release:
      ReceiverEff = ArgEffect.DecRefMsg;
      break;
     case OMF_dealloc:
      ReceiverEff = ArgEffect.Dealloc;
      break;
     case OMF_self:
      // -self is handled specially by the ExprEngine to propagate the receiver.
      break;
     case OMF_retainCount:
     case OMF_finalize:
      // These methods don't return objects.
      break;
    }
    
    // If one of the arguments in the selector has the keyword 'delegate' we
    // should stop tracking the reference count for the receiver.  This is
    // because the reference count is quite possibly handled by a delegate
    // method.
    if (S.isKeywordSelector()) {
      for (/*uint*/int i = 0, e = S.getNumArgs(); i != e; ++i) {
        StringRef Slot = S.getNameForSlot(i);
        if (Slot.substr(Slot.size() - 8).equals_lower(/*STRINGREF_STR*/"delegate")) {
          if (ResultEff.$eq(ObjCInitRetE)) {
            ResultEff.$assignMove(RetEffect.MakeNoRetHard());
          } else {
            ReceiverEff = ArgEffect.StopTrackingHard;
          }
        }
      }
    }
    if (ScratchArgs.isEmpty() && ReceiverEff == ArgEffect.DoNothing
       && ResultEff.getKind() == RetEffect.Kind.NoRet) {
      return getDefaultSummary();
    }
    
    return getPersistentSummary(new objc_retain.RetEffect(ResultEff), ReceiverEff, ArgEffect.MayEscape);
  }

  
  /// Determine if there is a special return effect for this function or method.
  
  //===----------------------------------------------------------------------===//
  // Summary creation for Selectors.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getRetEffectFromAnnotations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1300,
   FQN="(anonymous namespace)::RetainSummaryManager::getRetEffectFromAnnotations", NM="_ZN12_GLOBAL__N_120RetainSummaryManager27getRetEffectFromAnnotationsEN5clang8QualTypeEPKNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager27getRetEffectFromAnnotationsEN5clang8QualTypeEPKNS1_4DeclE")
  //</editor-fold>
  public Optional<objc_retain.RetEffect> getRetEffectFromAnnotations(QualType RetTy, 
                             /*const*/ Decl /*P*/ D) {
    if (cocoa.isCocoaObjectRef(new QualType(RetTy))) {
      if (D.hasAttr(NSReturnsRetainedAttr.class)) {
        return new Optional<objc_retain.RetEffect>(JD$T$C$R.INSTANCE, ObjCAllocRetE);
      }
      if (D.hasAttr(NSReturnsNotRetainedAttr.class)
         || D.hasAttr(NSReturnsAutoreleasedAttr.class)) {
        return new Optional<objc_retain.RetEffect>(JD$T$RR.INSTANCE, RetEffect.MakeNotOwned(RetEffect.ObjKind.ObjC));
      }
    } else if (!RetTy.$arrow().isPointerType()) {
      return new Optional<objc_retain.RetEffect>(None);
    }
    if (D.hasAttr(CFReturnsRetainedAttr.class)) {
      return new Optional<objc_retain.RetEffect>(JD$T$RR.INSTANCE, RetEffect.MakeOwned(RetEffect.ObjKind.CF, true));
    }
    if (D.hasAttr(CFReturnsNotRetainedAttr.class)) {
      return new Optional<objc_retain.RetEffect>(JD$T$RR.INSTANCE, RetEffect.MakeNotOwned(RetEffect.ObjKind.CF));
    }
    
    return new Optional<objc_retain.RetEffect>(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::updateSummaryFromAnnotations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1360,
   FQN="(anonymous namespace)::RetainSummaryManager::updateSummaryFromAnnotations", NM="_ZN12_GLOBAL__N_120RetainSummaryManager28updateSummaryFromAnnotationsERPKNS_13RetainSummaryEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager28updateSummaryFromAnnotationsERPKNS_13RetainSummaryEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void updateSummaryFromAnnotations(final type$ref</*const*/ RetainSummary /*P*/ /*&*/> Summ, 
                              /*const*/ ObjCMethodDecl /*P*/ MD) {
    RetainSummaryTemplate Template = null;
    try {
      if (!(MD != null)) {
        return;
      }
      assert ((Summ.$deref() != null)) : "Must have a valid summary to add annotations to";
      Template/*J*/= new RetainSummaryTemplate(Summ, /*Deref*/this);
      
      // Effects on the receiver.
      if (MD.hasAttr(NSConsumesSelfAttr.class)) {
        Template.$arrow().setReceiverEffect(ArgEffect.DecRefMsg);
      }
      
      // Effects on the parameters.
      /*uint*/int parm_idx = 0;
      for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> pi = $tryClone(MD.param_begin$Const()), /*P*/ /*const*/ /*P*/ pe = $tryClone(MD.param_end$Const());
           $noteq_ptr(pi, pe); pi.$preInc() , ++parm_idx) {
        /*const*/ ParmVarDecl /*P*/ pd = pi.$star();
        if (pd.hasAttr(NSConsumedAttr.class)) {
          Template.$arrow().addArg(AF, parm_idx, ArgEffect.DecRefMsg);
        } else if (pd.hasAttr(CFConsumedAttr.class)) {
          Template.$arrow().addArg(AF, parm_idx, ArgEffect.DecRef);
        } else if (pd.hasAttr(CFReturnsRetainedAttr.class)) {
          QualType PointeeTy = pd.getType().$arrow().getPointeeType();
          if (!PointeeTy.isNull()) {
            if (coreFoundation.isCFObjectRef(new QualType(PointeeTy))) {
              Template.$arrow().addArg(AF, parm_idx, ArgEffect.RetainedOutParameter);
            }
          }
        } else if (pd.hasAttr(CFReturnsNotRetainedAttr.class)) {
          QualType PointeeTy = pd.getType().$arrow().getPointeeType();
          if (!PointeeTy.isNull()) {
            if (coreFoundation.isCFObjectRef(new QualType(PointeeTy))) {
              Template.$arrow().addArg(AF, parm_idx, ArgEffect.UnretainedOutParameter);
            }
          }
        }
      }
      
      QualType RetTy = MD.getReturnType();
      {
        Optional<objc_retain.RetEffect> RetE = getRetEffectFromAnnotations(new QualType(RetTy), MD);
        if (RetE.$bool()) {
          Template.$arrow().setRetEffect(new objc_retain.RetEffect(RetE.$star()));
        }
      }
    } finally {
      if (Template != null) { Template.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::updateSummaryFromAnnotations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1324,
   FQN="(anonymous namespace)::RetainSummaryManager::updateSummaryFromAnnotations", NM="_ZN12_GLOBAL__N_120RetainSummaryManager28updateSummaryFromAnnotationsERPKNS_13RetainSummaryEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager28updateSummaryFromAnnotationsERPKNS_13RetainSummaryEPKN5clang12FunctionDeclE")
  //</editor-fold>
  public void updateSummaryFromAnnotations(final type$ref</*const*/ RetainSummary /*P*/ /*&*/> Summ, 
                              /*const*/ FunctionDecl /*P*/ FD) {
    RetainSummaryTemplate Template = null;
    try {
      if (!(FD != null)) {
        return;
      }
      assert ((Summ.$deref() != null)) : "Must have a summary to add annotations to.";
      Template/*J*/= new RetainSummaryTemplate(Summ, /*Deref*/this);
      
      // Effects on the parameters.
      /*uint*/int parm_idx = 0;
      for (type$ptr<ParmVarDecl /*P*/ /*P*/> pi = $tryClone(FD.param_begin$Const()), 
          /*P*/ pe = $tryClone(FD.param_end$Const()); $noteq_ptr(pi, pe); pi.$preInc() , ++parm_idx) {
        /*const*/ ParmVarDecl /*P*/ pd = pi.$star();
        if (pd.hasAttr(NSConsumedAttr.class)) {
          Template.$arrow().addArg(AF, parm_idx, ArgEffect.DecRefMsg);
        } else if (pd.hasAttr(CFConsumedAttr.class)) {
          Template.$arrow().addArg(AF, parm_idx, ArgEffect.DecRef);
        } else if (pd.hasAttr(CFReturnsRetainedAttr.class)) {
          QualType PointeeTy = pd.getType().$arrow().getPointeeType();
          if (!PointeeTy.isNull()) {
            if (coreFoundation.isCFObjectRef(new QualType(PointeeTy))) {
              Template.$arrow().addArg(AF, parm_idx, ArgEffect.RetainedOutParameter);
            }
          }
        } else if (pd.hasAttr(CFReturnsNotRetainedAttr.class)) {
          QualType PointeeTy = pd.getType().$arrow().getPointeeType();
          if (!PointeeTy.isNull()) {
            if (coreFoundation.isCFObjectRef(new QualType(PointeeTy))) {
              Template.$arrow().addArg(AF, parm_idx, ArgEffect.UnretainedOutParameter);
            }
          }
        }
      }
      
      QualType RetTy = FD.getReturnType();
      {
        Optional<objc_retain.RetEffect> RetE = getRetEffectFromAnnotations(new QualType(RetTy), FD);
        if (RetE.$bool()) {
          Template.$arrow().setRetEffect(new objc_retain.RetEffect(RetE.$star()));
        }
      }
    } finally {
      if (Template != null) { Template.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::updateSummaryForCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 930,
   FQN="(anonymous namespace)::RetainSummaryManager::updateSummaryForCall", NM="_ZN12_GLOBAL__N_120RetainSummaryManager20updateSummaryForCallERPKNS_13RetainSummaryERKN5clang4ento9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManager20updateSummaryForCallERPKNS_13RetainSummaryERKN5clang4ento9CallEventE")
  //</editor-fold>
  public void updateSummaryForCall(final type$ref</*const*/ RetainSummary /*P*/ /*&*/> S, 
                      final /*const*/ CallEvent /*&*/ Call) {
    if (Call.hasNonZeroCallbackArg()) {
      ImmutableMapUIntType<objc_retain.ArgEffect> CustomArgEffects = null;
      try {
        objc_retain.ArgEffect RecEffect = RetainCountCheckerStatics.getStopTrackingHardEquivalent(S.$deref().getReceiverEffect());
        objc_retain.ArgEffect DefEffect = RetainCountCheckerStatics.getStopTrackingHardEquivalent(S.$deref().getDefaultArgEffect());
        
        CustomArgEffects = S.$deref().getArgEffects();
        ImmutableMapUIntType.iterator<objc_retain.ArgEffect> I = null;
        ImmutableMapUIntType.iterator<objc_retain.ArgEffect> E = null;
        try {
          for (I = CustomArgEffects.begin(), 
              E = CustomArgEffects.end();
               I.$noteq(E); I.$preInc()) {
            objc_retain.ArgEffect Translated = RetainCountCheckerStatics.getStopTrackingHardEquivalent(I.$arrow().second);
            if (Translated != DefEffect) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(ScratchArgs.$assign($c$.track(AF.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(ScratchArgs)), I.$arrow().first, Translated))));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } finally {
          if (E != null) { E.$destroy(); }
          if (I != null) { I.$destroy(); }
        }
        
        objc_retain.RetEffect RE = RetEffect.MakeNoRetHard();
        {
          
          // Special cases where the callback argument CANNOT free the return value.
          // This can generally only happen if we know that the callback will only be
          // called when the return value is already being deallocated.
          /*const*/ SimpleFunctionCall /*P*/ FC = dyn_cast_SimpleFunctionCall($AddrOf(Call));
          if ((FC != null)) {
            {
              IdentifierInfo /*P*/ Name = FC.getDecl().getIdentifier();
              if ((Name != null)) {
                // When the CGBitmapContext is deallocated, the callback here will free
                // the associated data buffer.
                if (Name.isStr(/*KEEP_STR*/"CGBitmapContextCreateWithData")) {
                  RE.$assignMove(S.$deref().getRetEffect());
                }
              }
            }
          }
        }
        
        S.$set(getPersistentSummary(new objc_retain.RetEffect(RE), RecEffect, DefEffect));
      } finally {
        if (CustomArgEffects != null) { CustomArgEffects.$destroy(); }
      }
    }
    {
      
      // Special case '[super init];' and '[self init];'
      //
      // Even though calling '[super init]' without assigning the result to self
      // and checking if the parent returns 'nil' is a bad pattern, it is common.
      // Additionally, our Self Init checker already warns about it. To avoid
      // overwhelming the user with messages from both checkers, we model the case
      // of '[super init]' in cases when it is not consumed by another expression
      // as if the call preserves the value of 'self'; essentially, assuming it can
      // never fail and return 'nil'.
      // Note, we don't want to just stop tracking the value since we want the
      // RetainCount checker to report leaks and use-after-free if SelfInit checker
      // is turned off.
      /*const*/ ObjCMethodCall /*P*/ MC = dyn_cast_ObjCMethodCall($AddrOf(Call));
      if ((MC != null)) {
        if (MC.getMethodFamily() == ObjCMethodFamily.OMF_init && MC.isReceiverSelfOrSuper()) {
          
          // Check if the message is not consumed, we know it will not be used in
          // an assignment, ex: "self = [super init]".
          /*const*/ Expr /*P*/ ME = MC.getOriginExpr();
          /*const*/ LocationContext /*P*/ LCtx = MC.getLocationContext();
          final ParentMap /*&*/ PM = LCtx.getAnalysisDeclContext().getParentMap();
          if (!PM.isConsumedExpr_Expr$C$P(ME)) {
            RetainSummaryTemplate ModifiableSummaryTemplate = null;
            try {
              ModifiableSummaryTemplate/*J*/= new RetainSummaryTemplate(S, /*Deref*/this);
              ModifiableSummaryTemplate.$arrow().setReceiverEffect(ArgEffect.DoNothing);
              ModifiableSummaryTemplate.$arrow().setRetEffect(RetEffect.MakeNoRet());
            } finally {
              if (ModifiableSummaryTemplate != null) { ModifiableSummaryTemplate.$destroy(); }
            }
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::isGCEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 805,
   FQN="(anonymous namespace)::RetainSummaryManager::isGCEnabled", NM="_ZNK12_GLOBAL__N_120RetainSummaryManager11isGCEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_120RetainSummaryManager11isGCEnabledEv")
  //</editor-fold>
  public boolean isGCEnabled() /*const*/ {
    return GCEnabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::isARCEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 807,
   FQN="(anonymous namespace)::RetainSummaryManager::isARCEnabled", NM="_ZNK12_GLOBAL__N_120RetainSummaryManager12isARCEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_120RetainSummaryManager12isARCEnabledEv")
  //</editor-fold>
  public boolean isARCEnabled() /*const*/ {
    return ARCEnabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::isARCorGCEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 809,
   FQN="(anonymous namespace)::RetainSummaryManager::isARCorGCEnabled", NM="_ZNK12_GLOBAL__N_120RetainSummaryManager16isARCorGCEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_120RetainSummaryManager16isARCorGCEnabledEv")
  //</editor-fold>
  public boolean isARCorGCEnabled() /*const*/ {
    return GCEnabled || ARCEnabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::getObjAllocRetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 811,
   FQN="(anonymous namespace)::RetainSummaryManager::getObjAllocRetEffect", NM="_ZNK12_GLOBAL__N_120RetainSummaryManager20getObjAllocRetEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_120RetainSummaryManager20getObjAllocRetEffectEv")
  //</editor-fold>
  public objc_retain.RetEffect getObjAllocRetEffect() /*const*/ {
    return new objc_retain.RetEffect(ObjCAllocRetE);
  }

  
  /*friend  class RetainSummaryTemplate*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryManager::~RetainSummaryManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 582,
   FQN="(anonymous namespace)::RetainSummaryManager::~RetainSummaryManager", NM="_ZN12_GLOBAL__N_120RetainSummaryManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120RetainSummaryManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SimpleSummaries.$destroy();
    ScratchArgs.$destroy();
    AF.$destroy();
    BPAlloc.$destroy();
    ObjCMethodSummaries.$destroy();
    ObjCClassMethodSummaries.$destroy();
    FuncSummaries.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", GCEnabled=" + GCEnabled // NOI18N
              + ", ARCEnabled=" + ARCEnabled // NOI18N
              + ", FuncSummaries=" + FuncSummaries // NOI18N
              + ", ObjCClassMethodSummaries=" + ObjCClassMethodSummaries // NOI18N
              + ", ObjCMethodSummaries=" + ObjCMethodSummaries // NOI18N
              + ", BPAlloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", AF=" + AF // NOI18N
              + ", ScratchArgs=" + ScratchArgs // NOI18N
              + ", ObjCAllocRetE=" + ObjCAllocRetE // NOI18N
              + ", ObjCInitRetE=" + ObjCInitRetE // NOI18N
              + ", SimpleSummaries=" + SimpleSummaries; // NOI18N
  }
}
