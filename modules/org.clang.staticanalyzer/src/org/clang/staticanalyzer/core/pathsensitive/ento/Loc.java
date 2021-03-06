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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::Loc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 282,
 FQN="clang::ento::Loc", NM="_ZN5clang4ento3LocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocE")
//</editor-fold>
public class Loc extends /*public*/ DefinedSVal {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::Loc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 284,
   FQN="clang::ento::Loc::Loc", NM="_ZN5clang4ento3LocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocC1Ev")
  //</editor-fold>
  protected Loc() {
    // : DefinedSVal() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::Loc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 285,
   FQN="clang::ento::Loc::Loc", NM="_ZN5clang4ento3LocC1EjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocC1EjPKv")
  //</editor-fold>
  protected /*explicit*/ Loc(/*uint*/int SubKind, /*const*/Object/*void P*/ D) {
    // : DefinedSVal(const_cast<void * >(D), true, SubKind) 
    //START JInit
    super(((/*const_cast*/Object/*void P*/ )(D)), true, SubKind);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::dumpToStream">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 308,
   FQN="clang::ento::Loc::dumpToStream", NM="_ZNK5clang4ento3Loc12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento3Loc12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    switch (NsLoc.Kind.valueOf(getSubKind())) {
     case ConcreteIntKind:
      os.$out_ullong(castAs(NsLoc.ConcreteInt.class).getValue().getZExtValue()).$out(/*KEEP_STR*/" (Loc)");
      break;
     case GotoLabelKind:
      os.$out(/*KEEP_STR*/$AMP_AMP).$out(castAs(NsLoc.GotoLabel.class).getLabel().getName());
      break;
     case MemRegionValKind:
      os.$out_char($$AMP).$out(castAs(NsLoc.MemRegionVal.class).getRegion().getString());
      break;
     default:
      throw new llvm_unreachable("Pretty-printing not implemented for this Loc.");
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::isLocType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 291,
   FQN="clang::ento::Loc::isLocType", NM="_ZN5clang4ento3Loc9isLocTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3Loc9isLocTypeENS_8QualTypeE")
  //</editor-fold>
  public static /*inline*/ boolean isLocType(QualType T) {
    return T.$arrow().isAnyPointerType() || T.$arrow().isBlockPointerType()
       || T.$arrow().isReferenceType() || T.$arrow().isNullPtrType();
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 298,
   FQN="clang::ento::Loc::isKind", NM="_ZN5clang4ento3Loc6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3Loc6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.LocKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::Loc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 282,
   FQN="clang::ento::Loc::Loc", NM="_ZN5clang4ento3LocC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Loc(final /*const*/ Loc /*&*/ $Prm0) {
    // : DefinedSVal() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::Loc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 282,
   FQN="clang::ento::Loc::Loc", NM="_ZN5clang4ento3LocC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocC1EOS1_")
  //</editor-fold>
  public /*inline*/ Loc(JD$Move _dparam, final Loc /*&&*/$Prm0) {
    // : DefinedSVal(static_cast<Loc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Loc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 282,
   FQN="clang::ento::Loc::operator=", NM="_ZN5clang4ento3LocaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento3LocaSEOS1_")
  //</editor-fold>
  public /*inline*/ Loc /*&*/ $assignMove(final Loc /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Loc clone() {
    assert this.getClass() == Loc.class : "Why not overridden in " + this.getClass();
    return new Loc(this);
  }

  @Override
  public Loc move() {
    assert this.getClass() == Loc.class : "Why not overridden in " + this.getClass();
    return new Loc(JD$Move.INSTANCE, this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
