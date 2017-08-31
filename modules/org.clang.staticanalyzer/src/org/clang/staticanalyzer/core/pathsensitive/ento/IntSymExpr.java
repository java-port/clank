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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief Represents a symbolic expression like 3 - 'x'.
//<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 321,
 FQN="clang::ento::IntSymExpr", NM="_ZN5clang4ento10IntSymExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExprE")
//</editor-fold>
public class IntSymExpr extends /*public*/ BinarySymExpr implements Destructors.ClassWithDestructor {
  private final /*const*/ APSInt /*&*/ LHS;
  private /*const*/ SymExpr /*P*/ RHS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::IntSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 326,
   FQN="clang::ento::IntSymExpr::IntSymExpr", NM="_ZN5clang4ento10IntSymExprC1ERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExprC1ERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE")
  //</editor-fold>
  public IntSymExpr(final /*const*/ APSInt /*&*/ lhs, BinaryOperatorKind op, 
      /*const*/ SymExpr /*P*/ rhs, QualType t) {
    // : BinarySymExpr(IntSymExprKind, op, t), LHS(lhs), RHS(rhs) 
    //START JInit
    super(Kind.IntSymExprKind, op, new QualType(t));
    this./*&*/LHS=/*&*/lhs;
    this.RHS = rhs;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 40,
   FQN="clang::ento::IntSymExpr::dumpToStream", NM="_ZNK5clang4ento10IntSymExpr12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento10IntSymExpr12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out_ullong(getLHS().getZExtValue());
    if (getLHS().isUnsigned()) {
      os.$out_char($$U);
    }
    os.$out_char($$SPACE).$out(
        BinaryOperator.getOpcodeStr(getOpcode())
    ).$out(
        /*KEEP_STR*/" ("
    );
    getRHS().dumpToStream(os);
    os.$out_char($$RPAREN);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 332,
   FQN="clang::ento::IntSymExpr::getRHS", NM="_ZNK5clang4ento10IntSymExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento10IntSymExpr6getRHSEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getRHS() /*const*/ {
    return RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 333,
   FQN="clang::ento::IntSymExpr::getLHS", NM="_ZNK5clang4ento10IntSymExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento10IntSymExpr6getLHSEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getLHS() /*const*/ {
    return LHS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 335,
   FQN="clang::ento::IntSymExpr::Profile", NM="_ZN5clang4ento10IntSymExpr7ProfileERN4llvm16FoldingSetNodeIDERKNS2_6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExpr7ProfileERN4llvm16FoldingSetNodeIDERKNS2_6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ APSInt /*&*/ lhs, 
         BinaryOperatorKind op, /*const*/ SymExpr /*P*/ rhs, 
         QualType t) {
    ID.AddInteger_uint((/*uint*/int)Kind.IntSymExprKind.getValue());
    ID.AddPointer($AddrOf(lhs));
    ID.AddInteger_int(op.getValue());
    ID.AddPointer(rhs);
    ID.Add(t);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 345,
   FQN="clang::ento::IntSymExpr::Profile", NM="_ZN5clang4ento10IntSymExpr7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExpr7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID)/* override*/ {
    Profile(ID, LHS, getOpcode(), RHS, getType());
  }

  
  // Implement isa<T> support.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 350,
   FQN="clang::ento::IntSymExpr::classof", NM="_ZN5clang4ento10IntSymExpr7classofEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExpr7classofEPKNS0_7SymExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SymExpr /*P*/ SE) {
    return SE.getKind() == Kind.IntSymExprKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::IntSymExpr::~IntSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 321,
   FQN="clang::ento::IntSymExpr::~IntSymExpr", NM="_ZN5clang4ento10IntSymExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento10IntSymExprD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "LHS=" + LHS // NOI18N
              + ", RHS=" + RHS // NOI18N
              + super.toString(); // NOI18N
  }
}
