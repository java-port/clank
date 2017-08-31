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
import org.clank.support.*;
import org.clank.support.aliases.type$ptr;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clank.support.Native.$createJavaCleaner;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 384,
 FQN="(anonymous namespace)::RetainSummary", NM="_ZN12_GLOBAL__N_113RetainSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummaryE")
//</editor-fold>
public class RetainSummary implements Destructors.ClassWithDestructor, Native.NativeComparable<RetainSummary>,
        FoldingSetTrait.Profilable, NativeCloneable<RetainSummary> {
  /// Args - a map of (index, ArgEffect) pairs, where index
  ///  specifies the argument (starting from 0).  This can be sparsely
  ///  populated; arguments with no entry in Args use 'DefaultArgEffect'.
  private ImmutableMapUIntType</*uint, */ArgEffect> Args;
  
  /// DefaultArgEffect - The default ArgEffect to apply to arguments that
  ///  do not have an entry in Args.
  private objc_retain.ArgEffect DefaultArgEffect;
  
  /// Receiver - If this summary applies to an Objective-C message expression,
  ///  this is the effect applied to the state of the receiver.
  private objc_retain.ArgEffect Receiver;
  
  /// Ret - The effect on the return value.  Used to indicate if the
  ///  function/method call returns a new tracked symbol.
  private objc_retain.RetEffect Ret;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::RetainSummary">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 403,
   FQN="(anonymous namespace)::RetainSummary::RetainSummary", NM="_ZN12_GLOBAL__N_113RetainSummaryC1EN4llvm12ImmutableMapIjN5clang4ento11objc_retain9ArgEffectENS1_16ImutKeyValueInfoIjS6_EEEENS5_9RetEffectES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummaryC1EN4llvm12ImmutableMapIjN5clang4ento11objc_retain9ArgEffectENS1_16ImutKeyValueInfoIjS6_EEEENS5_9RetEffectES6_S6_")
  //</editor-fold>
  public RetainSummary(ImmutableMapUIntType<objc_retain.ArgEffect> A, objc_retain.RetEffect R, objc_retain.ArgEffect defaultEff, 
      objc_retain.ArgEffect ReceiverEff) {
    // : Args(A), DefaultArgEffect(defaultEff), Receiver(ReceiverEff), Ret(R) 
    //START JInit
    this.Args = new ImmutableMapUIntType<objc_retain.ArgEffect>(A);
    this.DefaultArgEffect = defaultEff;
    this.Receiver = ReceiverEff;
    this.Ret = new objc_retain.RetEffect(R);
    //END JInit
  }

  
  /// getArg - Return the argument effect on the argument specified by
  ///  idx (starting from 0).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::getArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 409,
   FQN="(anonymous namespace)::RetainSummary::getArg", NM="_ZNK12_GLOBAL__N_113RetainSummary6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary6getArgEj")
  //</editor-fold>
  public objc_retain.ArgEffect getArg(/*uint*/int idx) /*const*/ {
    {
      /*const*/ type$ptr<objc_retain.ArgEffect> /*P*/ AE = Args.lookup(idx);
      if ((AE != null)) {
        return $Deref(AE.$star());
      }
    }
    
    return DefaultArgEffect;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::addArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 416,
   FQN="(anonymous namespace)::RetainSummary::addArg", NM="_ZN12_GLOBAL__N_113RetainSummary6addArgERN4llvm12ImmutableMapIjN5clang4ento11objc_retain9ArgEffectENS1_16ImutKeyValueInfoIjS6_EEE7FactoryEjS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummary6addArgERN4llvm12ImmutableMapIjN5clang4ento11objc_retain9ArgEffectENS1_16ImutKeyValueInfoIjS6_EEE7FactoryEjS6_")
  //</editor-fold>
  public void addArg(final ImmutableMapUIntType.Factory<objc_retain.ArgEffect> /*&*/ af, /*uint*/int idx, objc_retain.ArgEffect e) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Args.$assign($c$.track(af.add($c$.track(new ImmutableMapUIntType<objc_retain.ArgEffect>(Args)), idx, e))));
    } finally {
      $c$.$destroy();
    }
  }
  
  /// setDefaultArgEffect - Set the default argument effect.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::setDefaultArgEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 421,
   FQN="(anonymous namespace)::RetainSummary::setDefaultArgEffect", NM="_ZN12_GLOBAL__N_113RetainSummary19setDefaultArgEffectEN5clang4ento11objc_retain9ArgEffectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummary19setDefaultArgEffectEN5clang4ento11objc_retain9ArgEffectE")
  //</editor-fold>
  public void setDefaultArgEffect(objc_retain.ArgEffect E) {
    DefaultArgEffect = E;
  }

  
  /// getRetEffect - Returns the effect on the return value of the call.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::getRetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 426,
   FQN="(anonymous namespace)::RetainSummary::getRetEffect", NM="_ZNK12_GLOBAL__N_113RetainSummary12getRetEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary12getRetEffectEv")
  //</editor-fold>
  public objc_retain.RetEffect getRetEffect() /*const*/ {
    return new objc_retain.RetEffect(Ret);
  }

  
  /// setRetEffect - Set the effect of the return value of the call.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::setRetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 429,
   FQN="(anonymous namespace)::RetainSummary::setRetEffect", NM="_ZN12_GLOBAL__N_113RetainSummary12setRetEffectEN5clang4ento11objc_retain9RetEffectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummary12setRetEffectEN5clang4ento11objc_retain9RetEffectE")
  //</editor-fold>
  public void setRetEffect(objc_retain.RetEffect E) {
    Ret.$assign(E);
  }

  
  /// Sets the effect on the receiver of the message.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::setReceiverEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 433,
   FQN="(anonymous namespace)::RetainSummary::setReceiverEffect", NM="_ZN12_GLOBAL__N_113RetainSummary17setReceiverEffectEN5clang4ento11objc_retain9ArgEffectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummary17setReceiverEffectEN5clang4ento11objc_retain9ArgEffectE")
  //</editor-fold>
  public void setReceiverEffect(objc_retain.ArgEffect e) {
    Receiver = e;
  }

  
  /// getReceiverEffect - Returns the effect on the receiver of the call.
  ///  This is only meaningful if the summary applies to an ObjCMessageExpr*.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::getReceiverEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 437,
   FQN="(anonymous namespace)::RetainSummary::getReceiverEffect", NM="_ZNK12_GLOBAL__N_113RetainSummary17getReceiverEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary17getReceiverEffectEv")
  //</editor-fold>
  public objc_retain.ArgEffect getReceiverEffect() /*const*/ {
    return Receiver;
  }

  
  /// Test if two retain summaries are identical. Note that merely equivalent
  /// summaries are not necessarily identical (for example, if an explicit
  /// argument effect matches the default effect).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 442,
   FQN="(anonymous namespace)::RetainSummary::operator==", NM="_ZNK12_GLOBAL__N_113RetainSummaryeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummaryeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ RetainSummary /*&*/ Other) /*const*/ {
    return Args.$eq(Other.Args) && DefaultArgEffect == Other.DefaultArgEffect
       && Receiver == Other.Receiver && Ret.$eq(Other.Ret);
  }

  
  /// Profile this summary for inclusion in a FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 448,
   FQN="(anonymous namespace)::RetainSummary::Profile", NM="_ZNK12_GLOBAL__N_113RetainSummary7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.Add(Args);
    ID.Add(DefaultArgEffect);
    ID.Add(Receiver);
    ID.Add(Ret);
  }

  
  /// A retain summary is simple if it has no ArgEffects other than the default.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 456,
   FQN="(anonymous namespace)::RetainSummary::isSimple", NM="_ZNK12_GLOBAL__N_113RetainSummary8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    return Args.isEmpty();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::getArgEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 461,
   FQN="(anonymous namespace)::RetainSummary::getArgEffects", NM="_ZNK12_GLOBAL__N_113RetainSummary13getArgEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary13getArgEffectsEv")
  //</editor-fold>
  /*package*//*friend*/ ImmutableMapUIntType<objc_retain.ArgEffect> getArgEffects() /*const*/ {
    return new ImmutableMapUIntType<objc_retain.ArgEffect>(Args);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::getDefaultArgEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 462,
   FQN="(anonymous namespace)::RetainSummary::getDefaultArgEffect", NM="_ZNK12_GLOBAL__N_113RetainSummary19getDefaultArgEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_113RetainSummary19getDefaultArgEffectEv")
  //</editor-fold>
  /*package*//*friend*/ objc_retain.ArgEffect getDefaultArgEffect() /*const*/ {
    return DefaultArgEffect;
  }

  
  /*friend  class RetainSummaryManager*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::~RetainSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 384,
   FQN="(anonymous namespace)::RetainSummary::~RetainSummary", NM="_ZN12_GLOBAL__N_113RetainSummaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummaryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Args.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummary::RetainSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 384,
   FQN="(anonymous namespace)::RetainSummary::RetainSummary", NM="_ZN12_GLOBAL__N_113RetainSummaryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_113RetainSummaryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RetainSummary(final /*const*/ RetainSummary /*&*/ $Prm0) {
    // : Args(.Args), DefaultArgEffect(.DefaultArgEffect), Receiver(.Receiver), Ret(.Ret) 
    //START JInit
    this.Args = new ImmutableMapUIntType<objc_retain.ArgEffect>($Prm0.Args);
    this.DefaultArgEffect = $Prm0.DefaultArgEffect;
    this.Receiver = $Prm0.Receiver;
    this.Ret = new objc_retain.RetEffect($Prm0.Ret);
    //END JInit
  }

  @Override public RetainSummary clone() {
    return new RetainSummary(this);
  }
  
  @Override public String toString() {
    return "" + "Args=" + Args // NOI18N
              + ", DefaultArgEffect=" + DefaultArgEffect // NOI18N
              + ", Receiver=" + Receiver // NOI18N
              + ", Ret=" + Ret; // NOI18N
  }
}
