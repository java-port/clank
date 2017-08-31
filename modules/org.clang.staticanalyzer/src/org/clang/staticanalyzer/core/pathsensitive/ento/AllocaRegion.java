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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//===----------------------------------------------------------------------===//
// MemRegion subclasses.
//===----------------------------------------------------------------------===//

/// AllocaRegion - A region that represents an untyped blob of bytes created
///  by a call to 'alloca'.
//<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 441,
 FQN="clang::ento::AllocaRegion", NM="_ZN5clang4ento12AllocaRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12AllocaRegionE")
//</editor-fold>
public class AllocaRegion extends /*public*/ SubRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
/*protected:*/
  protected /*uint*/int Cnt; // Block counter.  Used to distinguish different pieces of
  // memory allocated by alloca at the same call site.
  protected /*const*/ Expr /*P*/ Ex;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::AllocaRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 448,
   FQN="clang::ento::AllocaRegion::AllocaRegion", NM="_ZN5clang4ento12AllocaRegionC1EPKNS_4ExprEjPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12AllocaRegionC1EPKNS_4ExprEjPKNS0_9MemRegionE")
  //</editor-fold>
  protected AllocaRegion(/*const*/ Expr /*P*/ ex, /*uint*/int cnt, /*const*/ MemRegion /*P*/ superRegion) {
    // : SubRegion(superRegion, AllocaRegionKind), Cnt(cnt), Ex(ex) 
    //START JInit
    super(superRegion, Kind.AllocaRegionKind);
    this.Cnt = cnt;
    this.Ex = ex;
    //END JInit
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 453,
   FQN="clang::ento::AllocaRegion::getExpr", NM="_ZNK5clang4ento12AllocaRegion7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12AllocaRegion7getExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr() /*const*/ {
    return Ex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 455,
   FQN="clang::ento::AllocaRegion::isBoundable", NM="_ZNK5clang4ento12AllocaRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12AllocaRegion11isBoundableEv")
  //</editor-fold>
  @Override public boolean isBoundable() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 212,
   FQN="clang::ento::AllocaRegion::getExtent", NM="_ZNK5clang4ento12AllocaRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12AllocaRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*//* override*/ {
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(svalBuilder.getSymbolManager().getExtentSymbol(this)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 283,
   FQN="clang::ento::AllocaRegion::Profile", NM="_ZNK5clang4ento12AllocaRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12AllocaRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ProfileRegion(ID, Ex, Cnt, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 274,
   FQN="clang::ento::AllocaRegion::ProfileRegion", NM="_ZN5clang4ento12AllocaRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4ExprEjPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12AllocaRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4ExprEjPKNS0_9MemRegionE")
  //</editor-fold>
  public static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ Expr /*P*/ Ex, /*uint*/int cnt, 
               /*const*/ MemRegion /*P*/ superRegion) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(Kind.AllocaRegionKind.getValue())));
    ID.AddPointer(Ex);
    ID.AddInteger_uint(cnt);
    ID.AddPointer(superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 452,
   FQN="clang::ento::AllocaRegion::dumpToStream", NM="_ZNK5clang4ento12AllocaRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12AllocaRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(/*KEEP_STR*/"alloca{").$out((reinterpret_cast(/*static_cast*//*const*/Object/*void P*/ .class, (Ex)))).$out_char($$COMMA).$out_uint(Cnt).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 466,
   FQN="clang::ento::AllocaRegion::classof", NM="_ZN5clang4ento12AllocaRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12AllocaRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.AllocaRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::AllocaRegion::~AllocaRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 441,
   FQN="clang::ento::AllocaRegion::~AllocaRegion", NM="_ZN5clang4ento12AllocaRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12AllocaRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Cnt=" + Cnt // NOI18N
              + ", Ex=" + Ex // NOI18N
              + super.toString(); // NOI18N
  }
}
