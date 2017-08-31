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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.checkers.llvm.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 518,
 FQN="(anonymous namespace)::ObjCSummaryCache", NM="_ZN12_GLOBAL__N_116ObjCSummaryCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCacheE")
//</editor-fold>
public class ObjCSummaryCache implements Destructors.ClassWithDestructor {
  /*typedef llvm::DenseMap<ObjCSummaryKey, const RetainSummary *> MapTy*/
//  public final class MapTy extends DenseMap<ObjCSummaryKey, /*const*/ RetainSummary /*P*/ >{ };
  private DenseMap<ObjCSummaryKey, /*const*/ RetainSummary /*P*/ > M;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::ObjCSummaryCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 522,
   FQN="(anonymous namespace)::ObjCSummaryCache::ObjCSummaryCache", NM="_ZN12_GLOBAL__N_116ObjCSummaryCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCacheC1Ev")
  //</editor-fold>
  public ObjCSummaryCache() {
    // : M() 
    //START JInit
    this.M = new DenseMap<ObjCSummaryKey, /*const*/ RetainSummary /*P*/ >(DenseMapInfoObjCSummaryKey.$Info(), (/*const*/ RetainSummary /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 524,
   FQN="(anonymous namespace)::ObjCSummaryCache::find", NM="_ZN12_GLOBAL__N_116ObjCSummaryCache4findEPKN5clang17ObjCInterfaceDeclENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCache4findEPKN5clang17ObjCInterfaceDeclENS1_8SelectorE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ find(/*const*/ ObjCInterfaceDecl /*P*/ D, Selector S) {
    // Do a lookup with the (D,S) pair.  If we find a match return
    // the iterator.
    ObjCSummaryKey K/*J*/= new ObjCSummaryKey(D, new Selector(S));
    DenseMapIterator<ObjCSummaryKey, /*const*/ RetainSummary /*P*/ > I = M.find(K);
    if (I.$noteq(/*NO_ITER_COPY*/M.end())) {
      return I.$arrow().second;
    }
    if (!(D != null)) {
      return null;
    }
    
    // Walk the super chain.  If we find a hit with a parent, we'll end
    // up returning that summary.  We actually allow that key (null,S), as
    // we cache summaries for the null ObjCInterfaceDecl* to allow us to
    // generate initial summaries without having to worry about NSObject
    // being declared.
    // FIXME: We may change this at some point.
    for (ObjCInterfaceDecl /*P*/ C = D.getSuperClass();; C = C.getSuperClass()) {
      if ((I.$assignMove(M.find(new ObjCSummaryKey(C, new Selector(S))))).$noteq(/*NO_ITER_COPY*/M.end())) {
        break;
      }
      if (!(C != null)) {
        return null;
      }
    }
    
    // Cache the summary with original key to make the next lookup faster
    // and return the iterator.
    /*const*/ RetainSummary /*P*/ Summ = I.$arrow().second;
    M.$set(K, Summ);
    return Summ;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 556,
   FQN="(anonymous namespace)::ObjCSummaryCache::find", NM="_ZN12_GLOBAL__N_116ObjCSummaryCache4findEPN5clang14IdentifierInfoENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCache4findEPN5clang14IdentifierInfoENS1_8SelectorE")
  //</editor-fold>
  public /*const*/ RetainSummary /*P*/ find(IdentifierInfo /*P*/ II, Selector S) {
    // FIXME: Class method lookup.  Right now we dont' have a good way
    // of going between IdentifierInfo* and the class hierarchy.
    DenseMapIterator<ObjCSummaryKey, /*const*/ RetainSummary /*P*/ > I = M.find(new ObjCSummaryKey(II, new Selector(S)));
    if (I.$eq(/*NO_ITER_COPY*/M.end())) {
      I.$assignMove(M.find(new ObjCSummaryKey(new Selector(S))));
    }
    
    return I.$eq(/*NO_ITER_COPY*/M.end()) ? null : I.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 567,
   FQN="(anonymous namespace)::ObjCSummaryCache::operator[]", NM="_ZN12_GLOBAL__N_116ObjCSummaryCacheixENS_14ObjCSummaryKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCacheixENS_14ObjCSummaryKeyE")
  //</editor-fold>
  public type$ref</*const*/ RetainSummary /*P*/ /*&*/> $at(ObjCSummaryKey K) {
    return M.ref$at(K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 571,
   FQN="(anonymous namespace)::ObjCSummaryCache::operator[]", NM="_ZN12_GLOBAL__N_116ObjCSummaryCacheixEN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCacheixEN5clang8SelectorE")
  //</editor-fold>
  public type$ref</*const*/ RetainSummary /*P*/ /*&*/> $at(Selector S) {
    return M.ref$at(new ObjCSummaryKey(new Selector(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSummaryCache::~ObjCSummaryCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 518,
   FQN="(anonymous namespace)::ObjCSummaryCache::~ObjCSummaryCache", NM="_ZN12_GLOBAL__N_116ObjCSummaryCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_116ObjCSummaryCacheD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    M.$destroy();
    //END JDestroy
  }

  void $set(Selector Key, RetainSummary Val) {
    $at(Key).$set(Val);
  }

  void $set(ObjCSummaryKey Key, RetainSummary Val) {
    $at(Key).$set(Val);
  }
  
  @Override public String toString() {
    return "" + "M=" + M; // NOI18N
  }
}
