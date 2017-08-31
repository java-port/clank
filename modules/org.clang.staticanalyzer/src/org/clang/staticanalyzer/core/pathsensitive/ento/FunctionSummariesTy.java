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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 31,
 FQN="clang::ento::FunctionSummariesTy", NM="_ZN5clang4ento19FunctionSummariesTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTyE")
//</editor-fold>
public class FunctionSummariesTy implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::FunctionSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 32,
   FQN="clang::ento::FunctionSummariesTy::FunctionSummary", NM="_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryE")
  //</editor-fold>
  private static class FunctionSummary implements Destructors.ClassWithDestructor, NativeCloneable<FunctionSummary> {
  /*public:*/
    /// Marks the IDs of the basic blocks visited during the analyzes.
    public SmallBitVector VisitedBasicBlocks;
    
    /// Total number of blocks in the function.
    public /*uint*/int TotalBasicBlocks /*: 30*/;
    
    /// True if this function has been checked against the rules for which
    /// functions may be inlined.
    public /*JBIT unsigned int*/ boolean InlineChecked /*: 1*/;
    
    /// True if this function may be inlined.
    public /*JBIT unsigned int*/ boolean MayInline /*: 1*/;
    
    /// The number of times the function has been inlined.
    public /*uint*/int TimesInlined /*: 32*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::FunctionSummary::FunctionSummary">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 50,
     FQN="clang::ento::FunctionSummariesTy::FunctionSummary::FunctionSummary", NM="_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryC1Ev")
    //</editor-fold>
    public FunctionSummary() {
      // : VisitedBasicBlocks(), TotalBasicBlocks(0), InlineChecked(0), TimesInlined(0) 
      //START JInit
      this.VisitedBasicBlocks = new SmallBitVector();
      this.TotalBasicBlocks = 0;
      this.InlineChecked = false;
      this.TimesInlined = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::FunctionSummary::FunctionSummary">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 32,
     FQN="clang::ento::FunctionSummariesTy::FunctionSummary::FunctionSummary", NM="_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryC1EOS2_")
    //</editor-fold>
    public /*inline*/ FunctionSummary(JD$Move _dparam, final FunctionSummary /*&&*/$Prm0) {
      // : VisitedBasicBlocks(static_cast<FunctionSummary &&>().VisitedBasicBlocks), TotalBasicBlocks(static_cast<FunctionSummary &&>().TotalBasicBlocks), InlineChecked(static_cast<FunctionSummary &&>().InlineChecked), MayInline(static_cast<FunctionSummary &&>().MayInline), TimesInlined(static_cast<FunctionSummary &&>().TimesInlined) 
      //START JInit
      this.VisitedBasicBlocks = new SmallBitVector(JD$Move.INSTANCE, $Prm0.VisitedBasicBlocks);
      this.TotalBasicBlocks = $Prm0.TotalBasicBlocks;
      this.InlineChecked = $Prm0.InlineChecked;
      this.MayInline = $Prm0.MayInline;
      this.TimesInlined = $Prm0.TimesInlined;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::FunctionSummary::~FunctionSummary">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 32,
     FQN="clang::ento::FunctionSummariesTy::FunctionSummary::~FunctionSummary", NM="_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy15FunctionSummaryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      VisitedBasicBlocks.$destroy();
      //END JDestroy
    }

    public /*inline*/ FunctionSummary(final FunctionSummary /*&&*/$Prm0) {
      // : VisitedBasicBlocks(static_cast<FunctionSummary &&>().VisitedBasicBlocks), TotalBasicBlocks(static_cast<FunctionSummary &&>().TotalBasicBlocks), InlineChecked(static_cast<FunctionSummary &&>().InlineChecked), MayInline(static_cast<FunctionSummary &&>().MayInline), TimesInlined(static_cast<FunctionSummary &&>().TimesInlined) 
      //START JInit
      this.VisitedBasicBlocks = new SmallBitVector($Prm0.VisitedBasicBlocks);
      this.TotalBasicBlocks = $Prm0.TotalBasicBlocks;
      this.InlineChecked = $Prm0.InlineChecked;
      this.MayInline = $Prm0.MayInline;
      this.TimesInlined = $Prm0.TimesInlined;
      //END JInit
    }
    
    @Override public FunctionSummary clone() { return new FunctionSummary(this); }
    
    @Override public String toString() {
      return "" + "VisitedBasicBlocks=" + VisitedBasicBlocks // NOI18N
                + ", TotalBasicBlocks=" + TotalBasicBlocks // NOI18N
                + ", InlineChecked=" + InlineChecked // NOI18N
                + ", MayInline=" + MayInline // NOI18N
                + ", TimesInlined=" + TimesInlined; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const Decl *, FunctionSummary> MapTy*/
//  public final class MapTy extends DenseMap</*const*/ Decl /*P*/ , FunctionSummary>{ };
  private DenseMap</*const*/ Decl /*P*/ , FunctionSummary> Map;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::findOrInsertSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 60,
   FQN="clang::ento::FunctionSummariesTy::findOrInsertSummary", NM="_ZN5clang4ento19FunctionSummariesTy19findOrInsertSummaryEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy19findOrInsertSummaryEPKNS_4DeclE")
  //</editor-fold>
  public DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> findOrInsertSummary(/*const*/ Decl /*P*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = Map.find(D);
      if (I.$noteq(/*NO_ITER_COPY*/Map.end())) {
        return I;
      }
      
      /*typedef std::pair<const Decl *, FunctionSummary> KVPair*/
//      final class KVPair extends std.pair</*const*/ Decl /*P*/ , FunctionSummary>{ };
      $c$.clean(I.$assignMove(Map.insert_pair$KeyT$ValueT($c$.track(new std.pairPtrType</*const*/ Decl /*P*/ , FunctionSummary>(JD$T$RR_T1$RR.INSTANCE, D, $c$.track(new FunctionSummary())))).first));
      assert (I.$noteq(/*NO_ITER_COPY*/Map.end()));
      return I;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::markMayInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 71,
   FQN="clang::ento::FunctionSummariesTy::markMayInline", NM="_ZN5clang4ento19FunctionSummariesTy13markMayInlineEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy13markMayInlineEPKNS_4DeclE")
  //</editor-fold>
  public void markMayInline(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = findOrInsertSummary(D);
    I.$arrow().second.InlineChecked = true;
    I.$arrow().second.MayInline = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::markShouldNotInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 77,
   FQN="clang::ento::FunctionSummariesTy::markShouldNotInline", NM="_ZN5clang4ento19FunctionSummariesTy19markShouldNotInlineEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy19markShouldNotInlineEPKNS_4DeclE")
  //</editor-fold>
  public void markShouldNotInline(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = findOrInsertSummary(D);
    I.$arrow().second.InlineChecked = true;
    I.$arrow().second.MayInline = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::markReachedMaxBlockCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 83,
   FQN="clang::ento::FunctionSummariesTy::markReachedMaxBlockCount", NM="_ZN5clang4ento19FunctionSummariesTy24markReachedMaxBlockCountEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy24markReachedMaxBlockCountEPKNS_4DeclE")
  //</editor-fold>
  public void markReachedMaxBlockCount(/*const*/ Decl /*P*/ D) {
    markShouldNotInline(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::mayInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 87,
   FQN="clang::ento::FunctionSummariesTy::mayInline", NM="_ZN5clang4ento19FunctionSummariesTy9mayInlineEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy9mayInlineEPKNS_4DeclE")
  //</editor-fold>
  public OptionalBool mayInline(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = new DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary>(Map.find(D));
    if (I.$noteq(/*NO_ITER_COPY*/Map.end()) && I.$arrow().second.InlineChecked) {
      return new OptionalBool(JD$T$RR.INSTANCE, I.$arrow().second.MayInline);
    }
    return new OptionalBool(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::markVisitedBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 94,
   FQN="clang::ento::FunctionSummariesTy::markVisitedBasicBlock", NM="_ZN5clang4ento19FunctionSummariesTy21markVisitedBasicBlockEjPKNS_4DeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy21markVisitedBasicBlockEjPKNS_4DeclEj")
  //</editor-fold>
  public void markVisitedBasicBlock(/*uint*/int ID, /*const*/ Decl /*P*/ D, /*uint*/int TotalIDs) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = findOrInsertSummary(D);
    final SmallBitVector /*&*/ Blocks = I.$arrow().second.VisitedBasicBlocks;
    assert ($less_uint(ID, TotalIDs));
    if ($greater_uint(TotalIDs, Blocks.size())) {
      Blocks.resize(TotalIDs);
      I.$arrow().second.TotalBasicBlocks = TotalIDs;
    }
    Blocks.set(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::getNumVisitedBasicBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 105,
   FQN="clang::ento::FunctionSummariesTy::getNumVisitedBasicBlocks", NM="_ZN5clang4ento19FunctionSummariesTy24getNumVisitedBasicBlocksEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy24getNumVisitedBasicBlocksEPKNS_4DeclE")
  //</editor-fold>
  public /*uint*/int getNumVisitedBasicBlocks(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = new DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary>(Map.find(D));
    if (I.$noteq(/*NO_ITER_COPY*/Map.end())) {
      return I.$arrow().second.VisitedBasicBlocks.count();
    }
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::getNumTimesInlined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 112,
   FQN="clang::ento::FunctionSummariesTy::getNumTimesInlined", NM="_ZN5clang4ento19FunctionSummariesTy18getNumTimesInlinedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy18getNumTimesInlinedEPKNS_4DeclE")
  //</editor-fold>
  public /*uint*/int getNumTimesInlined(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = new DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary>(Map.find(D));
    if (I.$noteq(/*NO_ITER_COPY*/Map.end())) {
      return I.$arrow().second.TimesInlined;
    }
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::bumpNumTimesInlined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 119,
   FQN="clang::ento::FunctionSummariesTy::bumpNumTimesInlined", NM="_ZN5clang4ento19FunctionSummariesTy19bumpNumTimesInlinedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy19bumpNumTimesInlinedEPKNS_4DeclE")
  //</editor-fold>
  public void bumpNumTimesInlined(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = findOrInsertSummary(D);
    I.$arrow().second.TimesInlined++;
  }

  
  /// Get the percentage of the reachable blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::getPercentBlocksReachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 125,
   FQN="clang::ento::FunctionSummariesTy::getPercentBlocksReachable", NM="_ZN5clang4ento19FunctionSummariesTy25getPercentBlocksReachableEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTy25getPercentBlocksReachableEPKNS_4DeclE")
  //</editor-fold>
  public /*uint*/int getPercentBlocksReachable(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = new DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary>(Map.find(D));
    if (I.$noteq(/*NO_ITER_COPY*/Map.end())) {
      return ($div_uint((I.$arrow().second.VisitedBasicBlocks.count() * 100)
        , I.$arrow().second.TotalBasicBlocks));
    }
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::getTotalNumBasicBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/FunctionSummary.cpp", line = 18,
   FQN="clang::ento::FunctionSummariesTy::getTotalNumBasicBlocks", NM="_ZN5clang4ento19FunctionSummariesTy22getTotalNumBasicBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/FunctionSummary.cpp -nm=_ZN5clang4ento19FunctionSummariesTy22getTotalNumBasicBlocksEv")
  //</editor-fold>
  public /*uint*/int getTotalNumBasicBlocks() {
    /*uint*/int Total = 0;
    for (DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = Map.begin(), E = Map.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      Total += I.$arrow().second.TotalBasicBlocks;
    }
    return Total;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::getTotalNumVisitedBasicBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/FunctionSummary.cpp", line = 26,
   FQN="clang::ento::FunctionSummariesTy::getTotalNumVisitedBasicBlocks", NM="_ZN5clang4ento19FunctionSummariesTy29getTotalNumVisitedBasicBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/FunctionSummary.cpp -nm=_ZN5clang4ento19FunctionSummariesTy29getTotalNumVisitedBasicBlocksEv")
  //</editor-fold>
  public /*uint*/int getTotalNumVisitedBasicBlocks() {
    /*uint*/int Total = 0;
    for (DenseMapIterator</*const*/ Decl /*P*/ , FunctionSummary> I = Map.begin(), E = Map.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      Total += I.$arrow().second.VisitedBasicBlocks.count();
    }
    return Total;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::~FunctionSummariesTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 31,
   FQN="clang::ento::FunctionSummariesTy::~FunctionSummariesTy", NM="_ZN5clang4ento19FunctionSummariesTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTyD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Map.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionSummariesTy::FunctionSummariesTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/FunctionSummary.h", line = 31,
   FQN="clang::ento::FunctionSummariesTy::FunctionSummariesTy", NM="_ZN5clang4ento19FunctionSummariesTyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento19FunctionSummariesTyC1Ev")
  //</editor-fold>
  public /*inline*/ FunctionSummariesTy() {
    // : Map() 
    //START JInit
    this.Map = new DenseMap</*const*/ Decl /*P*/ , FunctionSummary>(DenseMapInfo$LikePtr.$Info(), new FunctionSummary());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Map=" + Map; // NOI18N
  }
}
