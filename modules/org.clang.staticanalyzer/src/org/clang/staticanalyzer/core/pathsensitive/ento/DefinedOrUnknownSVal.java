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

//<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 202,
 FQN="clang::ento::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValE")
//</editor-fold>
public class DefinedOrUnknownSVal extends /*public*/ SVal {
/*private:*/
  // We want calling these methods to be a compiler error since they are
  // tautologically false.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::isUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 206,
   FQN="clang::ento::DefinedOrUnknownSVal::isUndef", NM="_ZNK5clang4ento20DefinedOrUnknownSVal7isUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento20DefinedOrUnknownSVal7isUndefEv")
  //</editor-fold>
  public/*private*/ boolean isUndef$DefinedOrUnknownSVal() /*const*/ { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 207,
   FQN="clang::ento::DefinedOrUnknownSVal::isValid", NM="_ZNK5clang4ento20DefinedOrUnknownSVal7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento20DefinedOrUnknownSVal7isValidEv")
  //</editor-fold>
  public/*private*/ boolean isValid$DefinedOrUnknownSVal() /*const*/ { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 210,
   FQN="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValC1Ev")
  //</editor-fold>
  protected DefinedOrUnknownSVal() {
    // : SVal() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 211,
   FQN="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValC1EPKvbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValC1EPKvbj")
  //</editor-fold>
  protected /*explicit*/ DefinedOrUnknownSVal(/*const*/Object/*void P*/ d, boolean isLoc, /*uint*/int ValKind) {
    // : SVal(d, isLoc, ValKind) 
    //START JInit
    super(d, isLoc, ValKind);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 214,
   FQN="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValC1ENS0_4SVal8BaseKindEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValC1ENS0_4SVal8BaseKindEPv")
  //</editor-fold>
  protected /*explicit*/ DefinedOrUnknownSVal(SVal.BaseKind k) {
    this(k, (Object/*void P*/ )null);
  }
  protected /*explicit*/ DefinedOrUnknownSVal(SVal.BaseKind k, Object/*void P*/ D/*= null*/) {
    // : SVal(k, D) 
    //START JInit
    super(k, D);
    //END JInit
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 219,
   FQN="clang::ento::DefinedOrUnknownSVal::isKind", NM="_ZN5clang4ento20DefinedOrUnknownSVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return !V.isUndef$SVal();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 202,
   FQN="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DefinedOrUnknownSVal(final /*const*/ DefinedOrUnknownSVal /*&*/ $Prm0) {
    // : SVal() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 202,
   FQN="clang::ento::DefinedOrUnknownSVal::DefinedOrUnknownSVal", NM="_ZN5clang4ento20DefinedOrUnknownSValC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValC1EOS1_")
  //</editor-fold>
  public /*inline*/ DefinedOrUnknownSVal(JD$Move _dparam, final DefinedOrUnknownSVal /*&&*/$Prm0) {
    // : SVal(static_cast<DefinedOrUnknownSVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 202,
   FQN="clang::ento::DefinedOrUnknownSVal::operator=", NM="_ZN5clang4ento20DefinedOrUnknownSValaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValaSERKS1_")
  //</editor-fold>
  public /*inline*/ DefinedOrUnknownSVal /*&*/ $assign(final /*const*/ DefinedOrUnknownSVal /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedOrUnknownSVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 202,
   FQN="clang::ento::DefinedOrUnknownSVal::operator=", NM="_ZN5clang4ento20DefinedOrUnknownSValaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento20DefinedOrUnknownSValaSEOS1_")
  //</editor-fold>
  public /*inline*/ DefinedOrUnknownSVal /*&*/ $assignMove(final DefinedOrUnknownSVal /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public DefinedOrUnknownSVal clone() {
    assert this.getClass() == DefinedOrUnknownSVal.class : "Why not overridden in " + this.getClass();
    return new DefinedOrUnknownSVal(this);
  }

  @Override
  public DefinedOrUnknownSVal move() {
    assert this.getClass() == DefinedOrUnknownSVal.class : "Why not overridden in " + this.getClass();
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
