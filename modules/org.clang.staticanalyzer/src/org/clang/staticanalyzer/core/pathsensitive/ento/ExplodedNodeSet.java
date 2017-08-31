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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 407,
 FQN="clang::ento::ExplodedNodeSet", NM="_ZN5clang4ento15ExplodedNodeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSetE")
//</editor-fold>
public class ExplodedNodeSet implements  Iterable<ExplodedNode>, Destructors.ClassWithDestructor {
  /*typedef llvm::SmallPtrSet<ExplodedNode *, 5> ImplTy*/
//  public final class ImplTy extends SmallPtrSet<ExplodedNode /*P*/ >{ };
  private SmallPtrSet<ExplodedNode /*P*/ > Impl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::ExplodedNodeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 412,
   FQN="clang::ento::ExplodedNodeSet::ExplodedNodeSet", NM="_ZN5clang4ento15ExplodedNodeSetC1EPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSetC1EPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNodeSet(ExplodedNode /*P*/ N) {
    // : Impl() 
    //START JInit
    this.Impl = new SmallPtrSet<ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 5);
    //END JInit
    assert ((N != null) && !((/*static_cast*/ExplodedNode /*P*/ )(N)).isSink());
    Impl.insert(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::ExplodedNodeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 417,
   FQN="clang::ento::ExplodedNodeSet::ExplodedNodeSet", NM="_ZN5clang4ento15ExplodedNodeSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSetC1Ev")
  //</editor-fold>
  public ExplodedNodeSet() {
    // : Impl() 
    //START JInit
    this.Impl = new SmallPtrSet<ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 5);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::Add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 419,
   FQN="clang::ento::ExplodedNodeSet::Add", NM="_ZN5clang4ento15ExplodedNodeSet3AddEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet3AddEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public /*inline*/ void Add(ExplodedNode /*P*/ N) {
    if ((N != null) && !((/*static_cast*/ExplodedNode /*P*/ )(N)).isSink()) {
      Impl.insert(N);
    }
  }

  
  /*typedef ImplTy::iterator iterator*/
//  public final class iterator extends SmallPtrSetIterator<ExplodedNode /*P*/ >{ };
  /*typedef ImplTy::const_iterator const_iterator*/
//  public final class const_iterator extends SmallPtrSetIterator<ExplodedNode /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 426,
   FQN="clang::ento::ExplodedNodeSet::size", NM="_ZNK5clang4ento15ExplodedNodeSet4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento15ExplodedNodeSet4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Impl.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 427,
   FQN="clang::ento::ExplodedNodeSet::empty", NM="_ZNK5clang4ento15ExplodedNodeSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento15ExplodedNodeSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Impl.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 428,
   FQN="clang::ento::ExplodedNodeSet::erase", NM="_ZN5clang4ento15ExplodedNodeSet5eraseEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet5eraseEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public boolean erase(ExplodedNode /*P*/ N) {
    return Impl.erase(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 430,
   FQN="clang::ento::ExplodedNodeSet::clear", NM="_ZN5clang4ento15ExplodedNodeSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet5clearEv")
  //</editor-fold>
  public void clear() {
    Impl.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 431,
   FQN="clang::ento::ExplodedNodeSet::insert", NM="_ZN5clang4ento15ExplodedNodeSet6insertERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet6insertERKS1_")
  //</editor-fold>
  public void insert(final /*const*/ ExplodedNodeSet /*&*/ S) {
    assert ($AddrOf(S) != this);
    if (empty()) {
      Impl.$assign(S.Impl);
    } else {
      Impl.insert$T(S.begin$Const(), S.end$Const());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 439,
   FQN="clang::ento::ExplodedNodeSet::begin", NM="_ZN5clang4ento15ExplodedNodeSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet5beginEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > begin() {
    return Impl.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 440,
   FQN="clang::ento::ExplodedNodeSet::end", NM="_ZN5clang4ento15ExplodedNodeSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSet3endEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > end() {
    return Impl.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 442,
   FQN="clang::ento::ExplodedNodeSet::begin", NM="_ZNK5clang4ento15ExplodedNodeSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento15ExplodedNodeSet5beginEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > begin$Const() /*const*/ {
    return Impl.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 443,
   FQN="clang::ento::ExplodedNodeSet::end", NM="_ZNK5clang4ento15ExplodedNodeSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento15ExplodedNodeSet3endEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > end$Const() /*const*/ {
    return Impl.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::~ExplodedNodeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 407,
   FQN="clang::ento::ExplodedNodeSet::~ExplodedNodeSet", NM="_ZN5clang4ento15ExplodedNodeSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Impl.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNodeSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 407,
   FQN="clang::ento::ExplodedNodeSet::operator=", NM="_ZN5clang4ento15ExplodedNodeSetaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento15ExplodedNodeSetaSERKS1_")
  //</editor-fold>
  public /*inline*/ ExplodedNodeSet /*&*/ $assign(final /*const*/ ExplodedNodeSet /*&*/ $Prm0) {
    this.Impl.$assign($Prm0.Impl);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<ExplodedNode> iterator() {return new JavaIterator(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
