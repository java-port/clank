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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clank.java.std;


/// \brief Symbolic value. These values used to capture symbolic execution of
/// the program.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 29,
 FQN="clang::ento::SymExpr", NM="_ZN5clang4ento7SymExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExprE")
//</editor-fold>
public abstract class SymExpr extends FoldingSetImpl.NodeImpl$Tracker implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 24,
   FQN="clang::ento::SymExpr::anchor", NM="_ZN5clang4ento7SymExpr6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 33,
   FQN="clang::ento::SymExpr::Kind", NM="_ZN5clang4ento7SymExpr4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    IntSymExprKind(0),
    SymIntExprKind(IntSymExprKind.getValue() + 1),
    SymSymExprKind(SymIntExprKind.getValue() + 1),
    BEGIN_BINARYSYMEXPRS(Kind.IntSymExprKind.getValue()),
    END_BINARYSYMEXPRS(Kind.SymSymExprKind.getValue()),
    SymbolCastKind(END_BINARYSYMEXPRS.getValue() + 1),
    SymbolConjuredKind(SymbolCastKind.getValue() + 1),
    SymbolDerivedKind(SymbolConjuredKind.getValue() + 1),
    SymbolExtentKind(SymbolDerivedKind.getValue() + 1),
    SymbolMetadataKind(SymbolExtentKind.getValue() + 1),
    SymbolRegionValueKind(SymbolMetadataKind.getValue() + 1),
    BEGIN_SYMBOLS(Kind.SymbolConjuredKind.getValue()),
    END_SYMBOLS(Kind.SymbolRegionValueKind.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private Kind K;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::SymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 43,
   FQN="clang::ento::SymExpr::SymExpr", NM="_ZN5clang4ento7SymExprC1ENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExprC1ENS1_4KindE")
  //</editor-fold>
  protected SymExpr(Kind k) {
    // : FoldingSetNode(), K(k) 
    //START JInit
    $Node();
    this.K = k;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::~SymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 46,
   FQN="clang::ento::SymExpr::~SymExpr", NM="_ZN5clang4ento7SymExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExprD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 48,
   FQN="clang::ento::SymExpr::getKind", NM="_ZNK5clang4ento7SymExpr7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 26,
   FQN="clang::ento::SymExpr::dump", NM="_ZNK5clang4ento7SymExpr4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpToStream(llvm.errs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 52,
   FQN="clang::ento::SymExpr::dumpToStream", NM="_ZNK5clang4ento7SymExpr12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 54,
   FQN="clang::ento::SymExpr::getType", NM="_ZNK5clang4ento7SymExpr7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr7getTypeEv")
  //</editor-fold>
  public abstract /*virtual*/ QualType getType() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 55,
   FQN="clang::ento::SymExpr::Profile", NM="_ZN5clang4ento7SymExpr7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public abstract /*virtual*/ void Profile(final FoldingSetNodeID /*&*/ profile)/* = 0*/;

  
  /// \brief Iterator over symbols that the current symbol depends on.
  ///
  /// For SymbolData, it's the symbol itself; for expressions, it's the
  /// expression symbol and all the operands in it. Note, SymbolDerived is
  /// treated as SymbolData - the iterator will NOT visit the parent region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 62,
   FQN="clang::ento::SymExpr::symbol_iterator", NM="_ZN5clang4ento7SymExpr15symbol_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorE")
  //</editor-fold>
  public static class symbol_iterator implements Destructors.ClassWithDestructor, Native.NativeComparable<symbol_iterator> {
    private SmallVector</*const*/ SymExpr /*P*/ > itr;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::expand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 114,
     FQN="clang::ento::SymExpr::symbol_iterator::expand", NM="_ZN5clang4ento7SymExpr15symbol_iterator6expandEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iterator6expandEv")
    //</editor-fold>
    private void expand() {
      /*const*/ SymExpr /*P*/ SE = itr.pop_back_val();
      switch (SE.getKind()) {
       case SymbolRegionValueKind:
       case SymbolConjuredKind:
       case SymbolDerivedKind:
       case SymbolExtentKind:
       case SymbolMetadataKind:
        return;
       case SymbolCastKind:
        itr.push_back(cast_SymbolCast(SE).getOperand());
        return;
       case SymIntExprKind:
        itr.push_back(cast_SymIntExpr(SE).getLHS());
        return;
       case IntSymExprKind:
        itr.push_back(cast_IntSymExpr(SE).getRHS());
        return;
       case SymSymExprKind:
        {
          /*const*/ SymSymExpr /*P*/ x = cast_SymSymExpr(SE);
          itr.push_back(x.getLHS());
          itr.push_back(x.getRHS());
          return;
        }
      }
      throw new llvm_unreachable("unhandled expansion case");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 67,
     FQN="clang::ento::SymExpr::symbol_iterator::symbol_iterator", NM="_ZN5clang4ento7SymExpr15symbol_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorC1Ev")
    //</editor-fold>
    public symbol_iterator() {
      // : itr() 
      //START JInit
      this.itr = new SmallVector</*const*/ SymExpr /*P*/ >(5, (/*const*/ SymExpr /*P*/ )null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 99,
     FQN="clang::ento::SymExpr::symbol_iterator::symbol_iterator", NM="_ZN5clang4ento7SymExpr15symbol_iteratorC1EPKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorC1EPKS1_")
    //</editor-fold>
    public symbol_iterator(/*const*/ SymExpr /*P*/ SE) {
      // : itr() 
      //START JInit
      this.itr = new SmallVector</*const*/ SymExpr /*P*/ >(5, (/*const*/ SymExpr /*P*/ )null);
      //END JInit
      itr.push_back(SE);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 103,
     FQN="clang::ento::SymExpr::symbol_iterator::operator++", NM="_ZN5clang4ento7SymExpr15symbol_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorppEv")
    //</editor-fold>
    public SymExpr.symbol_iterator /*&*/ $preInc() {
      assert (!itr.empty()) : "attempting to iterate on an 'end' iterator";
      expand();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 109,
     FQN="clang::ento::SymExpr::symbol_iterator::operator*", NM="_ZN5clang4ento7SymExpr15symbol_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratordeEv")
    //</editor-fold>
    public /*const*/ SymExpr /*P*/ $star() {
      assert (!itr.empty()) : "attempting to dereference an 'end' iterator";
      return itr.back();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 91,
     FQN="clang::ento::SymExpr::symbol_iterator::operator==", NM="_ZNK5clang4ento7SymExpr15symbol_iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr15symbol_iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ symbol_iterator /*&*/ X) /*const*/ {
      return itr.$eq(X.itr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 95,
     FQN="clang::ento::SymExpr::symbol_iterator::operator!=", NM="_ZNK5clang4ento7SymExpr15symbol_iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr15symbol_iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ symbol_iterator /*&*/ X) /*const*/ {
      return itr.$noteq(X.itr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 62,
     FQN="clang::ento::SymExpr::symbol_iterator::symbol_iterator", NM="_ZN5clang4ento7SymExpr15symbol_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ symbol_iterator(JD$Move _dparam, final symbol_iterator /*&&*/$Prm0) {
      // : itr(static_cast<symbol_iterator &&>().itr) 
      //START JInit
      this.itr = new SmallVector</*const*/ SymExpr /*P*/ >(JD$Move.INSTANCE, $Prm0.itr);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_iterator::~symbol_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 62,
     FQN="clang::ento::SymExpr::symbol_iterator::~symbol_iterator", NM="_ZN5clang4ento7SymExpr15symbol_iteratorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr15symbol_iteratorD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      itr.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "itr=" + itr; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 77,
   FQN="clang::ento::SymExpr::symbol_begin", NM="_ZNK5clang4ento7SymExpr12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr12symbol_beginEv")
  //</editor-fold>
  public symbol_iterator symbol_begin() /*const*/ {
    return new symbol_iterator(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 78,
   FQN="clang::ento::SymExpr::symbol_end", NM="_ZN5clang4ento7SymExpr10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento7SymExpr10symbol_endEv")
  //</editor-fold>
  public static symbol_iterator symbol_end() {
    return new symbol_iterator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::computeComplexity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 143,
   FQN="clang::ento::SymExpr::computeComplexity", NM="_ZNK5clang4ento7SymExpr17computeComplexityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr17computeComplexityEv")
  //</editor-fold>
  public /*uint*/int computeComplexity() /*const*/ {
    /*uint*/int R = 0;
    symbol_iterator I = null;
    symbol_iterator E = null;
    try {
      for (I = symbol_begin(), E = symbol_end(); I.$noteq(E); I.$preInc())  {
        R++;
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
    return R;
  }

  
  /// \brief Find the region from which this symbol originates.
  ///
  /// Whenever the symbol was constructed to denote an unknown value of
  /// a certain memory region, return this region. This method
  /// allows checkers to make decisions depending on the origin of the symbol.
  /// Symbol classes for which the origin region is known include
  /// SymbolRegionValue which denotes the value of the region before
  /// the beginning of the analysis, and SymbolDerived which denotes the value
  /// of a certain memory region after its super region (a memory space or
  /// a larger record region) is default-bound with a certain symbol.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExpr::getOriginRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 92,
   FQN="clang::ento::SymExpr::getOriginRegion", NM="_ZNK5clang4ento7SymExpr15getOriginRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento7SymExpr15getOriginRegionEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ MemRegion /*P*/ getOriginRegion() /*const*/ {
    return null;
  }

  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dumpToStream(OS);
      OS.flush();      
      return Buf.toJavaString();
    }    
    return "" + "K=" + K // NOI18N
              + super.toString(); // NOI18N
  }
}
