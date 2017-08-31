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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;


/// A symbol representing the value of a MemRegion whose parent region has
/// symbolic value.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 117,
 FQN="clang::ento::SymbolDerived", NM="_ZN5clang4ento13SymbolDerivedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerivedE")
//</editor-fold>
public class SymbolDerived extends /*public*/ SymbolData implements Destructors.ClassWithDestructor {
  private /*const*/ SymExpr /*P*/ parentSymbol;
  private /*const*/ TypedValueRegion /*P*/ R;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::SymbolDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 122,
   FQN="clang::ento::SymbolDerived::SymbolDerived", NM="_ZN5clang4ento13SymbolDerivedC1EjPKNS0_7SymExprEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerivedC1EjPKNS0_7SymExprEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public SymbolDerived(/*uint*/int sym, /*const*/ SymExpr /*P*/ parent, /*const*/ TypedValueRegion /*P*/ r) {
    // : SymbolData(SymbolDerivedKind, sym), parentSymbol(parent), R(r) 
    //START JInit
    super(Kind.SymbolDerivedKind, sym);
    this.parentSymbol = parent;
    this.R = r;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::getParentSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 125,
   FQN="clang::ento::SymbolDerived::getParentSymbol", NM="_ZNK5clang4ento13SymbolDerived15getParentSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolDerived15getParentSymbolEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getParentSymbol() /*const*/ {
    return parentSymbol;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 126,
   FQN="clang::ento::SymbolDerived::getRegion", NM="_ZNK5clang4ento13SymbolDerived9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolDerived9getRegionEv")
  //</editor-fold>
  public /*const*/ TypedValueRegion /*P*/ getRegion() /*const*/ {
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 311,
   FQN="clang::ento::SymbolDerived::getType", NM="_ZNK5clang4ento13SymbolDerived7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolDerived7getTypeEv")
  //</editor-fold>
  @Override public QualType getType() /*const*//* override*/ {
    return R.getValueType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 71,
   FQN="clang::ento::SymbolDerived::dumpToStream", NM="_ZNK5clang4ento13SymbolDerived12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolDerived12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_MemRegion$C$P($out_raw_ostream_SymExpr$C$P(os.$out(/*KEEP_STR*/"derived_$").$out_uint(getSymbolID()).$out_char($$LCURLY), 
            getParentSymbol()).$out_char($$COMMA), getRegion()).$out_char($$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::getOriginRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 131,
   FQN="clang::ento::SymbolDerived::getOriginRegion", NM="_ZNK5clang4ento13SymbolDerived15getOriginRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolDerived15getOriginRegionEv")
  //</editor-fold>
  @Override public /*const*/ MemRegion /*P*/ getOriginRegion() /*const*//* override*/ {
    return getRegion();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 133,
   FQN="clang::ento::SymbolDerived::Profile", NM="_ZN5clang4ento13SymbolDerived7ProfileERN4llvm16FoldingSetNodeIDEPKNS0_7SymExprEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerived7ProfileERN4llvm16FoldingSetNodeIDEPKNS0_7SymExprEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ profile, /*const*/ SymExpr /*P*/ parent, 
         /*const*/ TypedValueRegion /*P*/ r) {
    profile.AddInteger_uint((/*uint*/int)Kind.SymbolDerivedKind.getValue());
    profile.AddPointer(r);
    profile.AddPointer(parent);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 140,
   FQN="clang::ento::SymbolDerived::Profile", NM="_ZN5clang4ento13SymbolDerived7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerived7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ profile)/* override*/ {
    Profile(profile, parentSymbol, R);
  }

  
  // Implement isa<T> support.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 145,
   FQN="clang::ento::SymbolDerived::classof", NM="_ZN5clang4ento13SymbolDerived7classofEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerived7classofEPKNS0_7SymExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SymExpr /*P*/ SE) {
    return SE.getKind() == Kind.SymbolDerivedKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolDerived::~SymbolDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 117,
   FQN="clang::ento::SymbolDerived::~SymbolDerived", NM="_ZN5clang4ento13SymbolDerivedD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolDerivedD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "parentSymbol=" + parentSymbol // NOI18N
              + ", R=" + R // NOI18N
              + super.toString(); // NOI18N
  }
}
