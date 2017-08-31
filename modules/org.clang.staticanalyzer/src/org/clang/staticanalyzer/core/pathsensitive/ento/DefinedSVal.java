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

//<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 235,
 FQN="clang::ento::DefinedSVal", NM="_ZN5clang4ento11DefinedSValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValE")
//</editor-fold>
public class DefinedSVal extends /*public*/ DefinedOrUnknownSVal {
/*private:*/
  // We want calling these methods to be a compiler error since they are
  // tautologically true/false.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::isUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 239,
   FQN="clang::ento::DefinedSVal::isUnknown", NM="_ZNK5clang4ento11DefinedSVal9isUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento11DefinedSVal9isUnknownEv")
  //</editor-fold>
  public/*private*/ boolean isUnknown$DefinedSVal() /*const*/ { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::isUnknownOrUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 240,
   FQN="clang::ento::DefinedSVal::isUnknownOrUndef", NM="_ZNK5clang4ento11DefinedSVal16isUnknownOrUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento11DefinedSVal16isUnknownOrUndefEv")
  //</editor-fold>
  public/*private*/ boolean isUnknownOrUndef$DefinedSVal() /*const*/ { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 241,
   FQN="clang::ento::DefinedSVal::isValid", NM="_ZNK5clang4ento11DefinedSVal7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento11DefinedSVal7isValidEv")
  //</editor-fold>
  public/*private*/ boolean isValid$DefinedSVal() /*const*/ { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::DefinedSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 243,
   FQN="clang::ento::DefinedSVal::DefinedSVal", NM="_ZN5clang4ento11DefinedSValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValC1Ev")
  //</editor-fold>
  protected DefinedSVal() {
    // : DefinedOrUnknownSVal() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::DefinedSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 244,
   FQN="clang::ento::DefinedSVal::DefinedSVal", NM="_ZN5clang4ento11DefinedSValC1EPKvbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValC1EPKvbj")
  //</editor-fold>
  protected /*explicit*/ DefinedSVal(/*const*/Object/*void P*/ d, boolean isLoc, /*uint*/int ValKind) {
    // : DefinedOrUnknownSVal(d, isLoc, ValKind) 
    //START JInit
    super(d, isLoc, ValKind);
    //END JInit
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 248,
   FQN="clang::ento::DefinedSVal::isKind", NM="_ZN5clang4ento11DefinedSVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return !V.isUnknownOrUndef$SVal();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::DefinedSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 235,
   FQN="clang::ento::DefinedSVal::DefinedSVal", NM="_ZN5clang4ento11DefinedSValC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DefinedSVal(final /*const*/ DefinedSVal /*&*/ $Prm0) {
    // : DefinedOrUnknownSVal() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::DefinedSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 235,
   FQN="clang::ento::DefinedSVal::DefinedSVal", NM="_ZN5clang4ento11DefinedSValC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValC1EOS1_")
  //</editor-fold>
  public /*inline*/ DefinedSVal(JD$Move _dparam, final DefinedSVal /*&&*/$Prm0) {
    // : DefinedOrUnknownSVal(static_cast<DefinedSVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 235,
   FQN="clang::ento::DefinedSVal::operator=", NM="_ZN5clang4ento11DefinedSValaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValaSERKS1_")
  //</editor-fold>
  public /*inline*/ DefinedSVal /*&*/ $assign(final /*const*/ DefinedSVal /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DefinedSVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 235,
   FQN="clang::ento::DefinedSVal::operator=", NM="_ZN5clang4ento11DefinedSValaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento11DefinedSValaSEOS1_")
  //</editor-fold>
  public /*inline*/ DefinedSVal /*&*/ $assignMove(final DefinedSVal /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public DefinedSVal clone() {
    assert this.getClass() == DefinedSVal.class : "Why not overridden in " + this.getClass();
    return new DefinedSVal(this);
  }

  @Override
  public DefinedSVal move() {
    assert this.getClass() == DefinedSVal.class : "Why not overridden in " + this.getClass();
    return new DefinedSVal(JD$Move.INSTANCE, this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
