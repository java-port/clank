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
import org.llvm.adt.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 266,
 FQN="clang::ento::NonLoc", NM="_ZN5clang4ento6NonLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocE")
//</editor-fold>
public class NonLoc extends /*public*/ DefinedSVal {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::NonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 268,
   FQN="clang::ento::NonLoc::NonLoc", NM="_ZN5clang4ento6NonLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocC1Ev")
  //</editor-fold>
  protected NonLoc() {
    // : DefinedSVal() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::NonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 269,
   FQN="clang::ento::NonLoc::NonLoc", NM="_ZN5clang4ento6NonLocC1EjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocC1EjPKv")
  //</editor-fold>
  protected /*explicit*/ NonLoc(/*uint*/int SubKind, /*const*/Object/*void P*/ d) {
    // : DefinedSVal(d, false, SubKind) 
    //START JInit
    super(d, false, SubKind);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::dumpToStream">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 258,
   FQN="clang::ento::NonLoc::dumpToStream", NM="_ZNK5clang4ento6NonLoc12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6NonLoc12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    switch (NsNonloc.Kind.valueOf(getSubKind())) {
     case ConcreteIntKind:
      {
        final /*const*/NsNonloc.ConcreteInt/*&*/ C = castAs(NsNonloc.ConcreteInt.class);
        if (C.getValue().isUnsigned()) {
          os.$out_ullong(C.getValue().getZExtValue());
        } else {
          os.$out_llong(C.getValue().getSExtValue());
        }
        os.$out_char($$SPACE).$out_char((C.getValue().isUnsigned() ? $$U : $$S)).$out_uint(
            C.getValue().getBitWidth()
        ).$out_char($$b);
        break;
      }
     case SymbolValKind:
      {
        $out_raw_ostream_SymExpr$C$P(os, castAs(NsNonloc.SymbolVal.class).getSymbol());
        break;
      }
     case LocAsIntegerKind:
      {
        final /*const*/NsNonloc.LocAsInteger/*&*/ C = castAs(NsNonloc.LocAsInteger.class);
        $out_raw_ostream_SVal(os, /*NO_COPY*/C.getLoc()).$out(/*KEEP_STR*/" [as ").$out_uint(C.getNumBits()).$out(/*KEEP_STR*/" bit integer]");
        break;
      }
     case CompoundValKind:
      {
        final /*const*/NsNonloc.CompoundVal/*&*/ C = castAs(NsNonloc.CompoundVal.class);
        os.$out(/*KEEP_STR*/"compoundVal{");
        boolean first = true;
        for (ImmutableList.iterator<SVal> I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
          if (first) {
            os.$out_char($$SPACE);
            first = false;
          } else {
            os.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          
          (I.$star()).dumpToStream(os);
        }
        os.$out(/*KEEP_STR*/$RCURLY);
        break;
      }
     case LazyCompoundValKind:
      {
        final /*const*/NsNonloc.LazyCompoundVal/*&*/ C = castAs(NsNonloc.LazyCompoundVal.class);
        $out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"lazyCompoundVal{").$out(((/*const_cast*/Object/*void P*/ )(C.getStore()))).$out_char(
                $$COMMA
            ), C.getRegion()).$out_char(
            $$RCURLY
        );
        break;
      }
     default:
      assert (false) : "Pretty-printed not implemented for this NonLoc.";
      break;
    }
  }


/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 277,
   FQN="clang::ento::NonLoc::isKind", NM="_ZN5clang4ento6NonLoc6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLoc6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::NonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 266,
   FQN="clang::ento::NonLoc::NonLoc", NM="_ZN5clang4ento6NonLocC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocC1ERKS1_")
  //</editor-fold>
  public /*inline*/ NonLoc(final /*const*/ NonLoc /*&*/ $Prm0) {
    // : DefinedSVal() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::NonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 266,
   FQN="clang::ento::NonLoc::NonLoc", NM="_ZN5clang4ento6NonLocC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocC1EOS1_")
  //</editor-fold>
  public /*inline*/ NonLoc(JD$Move _dparam, final NonLoc /*&&*/$Prm0) {
    // : DefinedSVal(static_cast<NonLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 266,
   FQN="clang::ento::NonLoc::operator=", NM="_ZN5clang4ento6NonLocaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento6NonLocaSERKS1_")
  //</editor-fold>
  public /*inline*/ NonLoc /*&*/ $assign(final /*const*/ NonLoc /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::NonLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 266,
   FQN="clang::ento::NonLoc::operator=", NM="_ZN5clang4ento6NonLocaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento6NonLocaSEOS1_")
  //</editor-fold>
  public /*inline*/ NonLoc /*&*/ $assignMove(final NonLoc /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public NonLoc clone() {
    assert this.getClass() == NonLoc.class : "Why not overridden in " + this.getClass();
    return new NonLoc(this);
  }

  @Override
  public NonLoc move() {
    assert this.getClass() == NonLoc.class : "Why not overridden in " + this.getClass();
    return new NonLoc(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
