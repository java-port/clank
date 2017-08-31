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
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;


/// SymbolicRegion - A special, "non-concrete" region. Unlike other region
///  classes, SymbolicRegion represents a region that serves as an alias for
///  either a real region, a NULL pointer, etc.  It essentially is used to
///  map the concept of symbolic values into the domain of regions.  Symbolic
///  regions do not need to be typed.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 707,
 FQN="clang::ento::SymbolicRegion", NM="_ZN5clang4ento14SymbolicRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14SymbolicRegionE")
//</editor-fold>
public class SymbolicRegion extends /*public*/ SubRegion implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/ SymExpr /*P*/ /*const*/ sym;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::SymbolicRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 712,
   FQN="clang::ento::SymbolicRegion::SymbolicRegion", NM="_ZN5clang4ento14SymbolicRegionC1EPKNS0_7SymExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14SymbolicRegionC1EPKNS0_7SymExprEPKNS0_9MemRegionE")
  //</editor-fold>
  public SymbolicRegion(/*const*/ SymExpr /*P*/ /*const*/ s, /*const*/ MemRegion /*P*/ sreg) {
    // : SubRegion(sreg, SymbolicRegionKind), sym(s) 
    //START JInit
    super(sreg, Kind.SymbolicRegionKind);
    this.sym = s;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::getSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 715,
   FQN="clang::ento::SymbolicRegion::getSymbol", NM="_ZNK5clang4ento14SymbolicRegion9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14SymbolicRegion9getSymbolEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getSymbol() /*const*/ {
    return sym;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 719,
   FQN="clang::ento::SymbolicRegion::isBoundable", NM="_ZNK5clang4ento14SymbolicRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14SymbolicRegion11isBoundableEv")
  //</editor-fold>
  @Override public boolean isBoundable() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 216,
   FQN="clang::ento::SymbolicRegion::getExtent", NM="_ZNK5clang4ento14SymbolicRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14SymbolicRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*//* override*/ {
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(svalBuilder.getSymbolManager().getExtentSymbol(this)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 339,
   FQN="clang::ento::SymbolicRegion::Profile", NM="_ZNK5clang4ento14SymbolicRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14SymbolicRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    SymbolicRegion.ProfileRegion(ID, sym, getSuperRegion());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 332,
   FQN="clang::ento::SymbolicRegion::ProfileRegion", NM="_ZN5clang4ento14SymbolicRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS0_7SymExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14SymbolicRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS0_7SymExprEPKNS0_9MemRegionE")
  //</editor-fold>
  public static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, /*const*/ SymExpr /*P*/ sym, 
               /*const*/ MemRegion /*P*/ sreg) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(MemRegion.Kind.SymbolicRegionKind.getValue())));
    ID.Add(sym);
    ID.AddPointer(sreg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 516,
   FQN="clang::ento::SymbolicRegion::dumpToStream", NM="_ZNK5clang4ento14SymbolicRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14SymbolicRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_SymExpr$C$P(os.$out(/*KEEP_STR*/"SymRegion{"), sym).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 731,
   FQN="clang::ento::SymbolicRegion::classof", NM="_ZN5clang4ento14SymbolicRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14SymbolicRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.SymbolicRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolicRegion::~SymbolicRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 707,
   FQN="clang::ento::SymbolicRegion::~SymbolicRegion", NM="_ZN5clang4ento14SymbolicRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14SymbolicRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "sym=" + sym // NOI18N
              + super.toString(); // NOI18N
  }
}
