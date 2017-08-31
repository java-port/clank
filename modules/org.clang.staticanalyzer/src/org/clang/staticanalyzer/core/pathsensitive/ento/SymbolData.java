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
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

/// \brief A symbol representing data which can be stored in a memory location
/// (region).
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 101,
 FQN="clang::ento::SymbolData", NM="_ZN5clang4ento10SymbolDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10SymbolDataE")
//</editor-fold>
public abstract class SymbolData extends /*public*/ SymExpr implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 85,
   FQN="clang::ento::SymbolData::anchor", NM="_ZN5clang4ento10SymbolData6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10SymbolData6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  private /*const*//*uint*/int Sym;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData::SymbolData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 106,
   FQN="clang::ento::SymbolData::SymbolData", NM="_ZN5clang4ento10SymbolDataC1ENS0_7SymExpr4KindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10SymbolDataC1ENS0_7SymExpr4KindEj")
  //</editor-fold>
  protected SymbolData(SymExpr.Kind k, /*uint*/int sym) {
    // : SymExpr(k), Sym(sym) 
    //START JInit
    super(k);
    this.Sym = sym;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData::~SymbolData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 109,
   FQN="clang::ento::SymbolData::~SymbolData", NM="_ZN5clang4ento10SymbolDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10SymbolDataD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData::getSymbolID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 111,
   FQN="clang::ento::SymbolData::getSymbolID", NM="_ZNK5clang4ento10SymbolData11getSymbolIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento10SymbolData11getSymbolIDEv")
  //</editor-fold>
  public /*uint*/int getSymbolID() /*const*/ {
    return Sym;
  }

  
  // Implement isa<T> support.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolData::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymExpr.h", line = 114,
   FQN="clang::ento::SymbolData::classof", NM="_ZN5clang4ento10SymbolData7classofEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10SymbolData7classofEPKNS0_7SymExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SymExpr /*P*/ SE) {
    SymExpr.Kind k = SE.getKind();
    return k.getValue() >= Kind.BEGIN_SYMBOLS.getValue() && k.getValue() <= Kind.END_SYMBOLS.getValue();
  }

  
  @Override public String toString() {
    return "" + "Sym=" + Sym // NOI18N
              + super.toString(); // NOI18N
  }
}
