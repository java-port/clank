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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// This class represents a composition of other SCEV predicates, and is the
/// class that most clients will interact with.  This is equivalent to a
/// logical "AND" of all the predicates in the union.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 372,
 FQN="llvm::SCEVUnionPredicate", NM="_ZN4llvm18SCEVUnionPredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateE")
//</editor-fold>
public final class SCEVUnionPredicate extends /*public*/ SCEVPredicate implements Destructors.ClassWithDestructor {
/*private:*/
  // JAVA: typedef DenseMap<const SCEV *, SmallVector<const SCEVPredicate *, 4> > PredicateMap
//  public final class PredicateMap extends DenseMap</*const*/ SCEV /*P*/ , SmallVector</*const*/ SCEVPredicate /*P*/ >>{ };
  
  /// Vector with references to all predicates in this union.
  private SmallVector</*const*/ SCEVPredicate /*P*/ > Preds;
  /// Maps SCEVs to predicates for quick look-ups.
  private DenseMap</*const*/ SCEV /*P*/ , SmallVector</*const*/ SCEVPredicate /*P*/ >> SCEVToPreds;
/*public:*/
  
  /// Union predicates don't get cached so create a dummy set ID for it.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::SCEVUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10286,
   FQN="llvm::SCEVUnionPredicate::SCEVUnionPredicate", NM="_ZN4llvm18SCEVUnionPredicateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateC1Ev")
  //</editor-fold>
  public SCEVUnionPredicate() {
    // : SCEVPredicate(FoldingSetNodeIDRef(null, 0), P_Union), Preds(), SCEVToPreds() 
    /*ExprWithCleanups*/super(new FoldingSetNodeIDRef((/*const*/uint$ptr/*uint P*/ )null, 0), SCEVPredicateKind.P_Union);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::getPredicates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 385,
   FQN="llvm::SCEVUnionPredicate::getPredicates", NM="_ZNK4llvm18SCEVUnionPredicate13getPredicatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate13getPredicatesEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl</*const*/ SCEVPredicate /*P*/ > /*&*/ getPredicates() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Adds a predicate to this union.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::add">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10323,
   FQN="llvm::SCEVUnionPredicate::add", NM="_ZN4llvm18SCEVUnionPredicate3addEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicate3addEPKNS_13SCEVPredicateE")
  //</editor-fold>
  public void add(/*const*/ SCEVPredicate /*P*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns a reference to a vector containing all predicates which apply to
  /// \p Expr.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::getPredicatesForExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10294,
   FQN="llvm::SCEVUnionPredicate::getPredicatesForExpr", NM="_ZN4llvm18SCEVUnionPredicate20getPredicatesForExprEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicate20getPredicatesForExprEPKNS_4SCEVE")
  //</editor-fold>
  public ArrayRef</*const*/ SCEVPredicate /*P*/ > getPredicatesForExpr(/*const*/ SCEV /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Implementation of the SCEVPredicate interface
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::isAlwaysTrue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10289,
   FQN="llvm::SCEVUnionPredicate::isAlwaysTrue", NM="_ZNK4llvm18SCEVUnionPredicate12isAlwaysTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate12isAlwaysTrueEv")
  //</editor-fold>
  @Override public boolean isAlwaysTrue() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::implies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10302,
   FQN="llvm::SCEVUnionPredicate::implies", NM="_ZNK4llvm18SCEVUnionPredicate7impliesEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate7impliesEPKNS_13SCEVPredicateE")
  //</editor-fold>
  @Override public boolean implies(/*const*/ SCEVPredicate /*P*/ N) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10318,
   FQN="llvm::SCEVUnionPredicate::print", NM="_ZNK4llvm18SCEVUnionPredicate5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate5printERNS_11raw_ostreamEj")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::getExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10316,
   FQN="llvm::SCEVUnionPredicate::getExpr", NM="_ZNK4llvm18SCEVUnionPredicate7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate7getExprEv")
  //</editor-fold>
  @Override public /*const*/ SCEV /*P*/ getExpr() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// We estimate the complexity of a union predicate as the size number of
  /// predicates in the union.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::getComplexity">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 404,
   FQN="llvm::SCEVUnionPredicate::getComplexity", NM="_ZNK4llvm18SCEVUnionPredicate13getComplexityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVUnionPredicate13getComplexityEv")
  //</editor-fold>
  @Override public /*uint*/int getComplexity() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 407,
   FQN="llvm::SCEVUnionPredicate::classof", NM="_ZN4llvm18SCEVUnionPredicate7classofEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicate7classofEPKNS_13SCEVPredicateE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SCEVPredicate /*P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::SCEVUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 372,
   FQN="llvm::SCEVUnionPredicate::SCEVUnionPredicate", NM="_ZN4llvm18SCEVUnionPredicateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateC1EOS0_")
  //</editor-fold>
  public /*inline*/ SCEVUnionPredicate(JD$Move _dparam, final SCEVUnionPredicate /*&&*/$Prm0) {
    // : SCEVPredicate(static_cast<SCEVUnionPredicate &&>()), Preds(static_cast<SCEVUnionPredicate &&>().Preds), SCEVToPreds(static_cast<SCEVUnionPredicate &&>().SCEVToPreds) 
    super($Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 372,
   FQN="llvm::SCEVUnionPredicate::operator=", NM="_ZN4llvm18SCEVUnionPredicateaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateaSEOS0_")
  //</editor-fold>
  public /*inline*/ SCEVUnionPredicate /*&*/ $assignMove(final SCEVUnionPredicate /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::~SCEVUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 372,
   FQN="llvm::SCEVUnionPredicate::~SCEVUnionPredicate", NM="_ZN4llvm18SCEVUnionPredicateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVUnionPredicate::SCEVUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 372,
   FQN="llvm::SCEVUnionPredicate::SCEVUnionPredicate", NM="_ZN4llvm18SCEVUnionPredicateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVUnionPredicateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SCEVUnionPredicate(final /*const*/ SCEVUnionPredicate /*&*/ $Prm0) {
    // : SCEVPredicate(), Preds(.Preds), SCEVToPreds(.SCEVToPreds) 
    super($Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Preds=" + Preds // NOI18N
              + ", SCEVToPreds=" + SCEVToPreds // NOI18N
              + super.toString(); // NOI18N
  }

  @Override
  public void print(raw_ostream OS) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
