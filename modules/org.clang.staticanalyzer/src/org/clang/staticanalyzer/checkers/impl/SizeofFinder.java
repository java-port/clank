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

package org.clang.staticanalyzer.checkers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 111,
 FQN="(anonymous namespace)::SizeofFinder", NM="_ZN12_GLOBAL__N_112SizeofFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinderE")
//</editor-fold>
public class SizeofFinder implements /*public*/ ConstStmtVisitorVoid<SizeofFinder>, Destructors.ClassWithDestructor {
/*public:*/
  public std.vector</*const*/ UnaryExprOrTypeTraitExpr /*P*/ > Sizeofs;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::VisitBinMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 115,
   FQN="(anonymous namespace)::SizeofFinder::VisitBinMul", NM="_ZN12_GLOBAL__N_112SizeofFinder11VisitBinMulEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinder11VisitBinMulEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinMul(/*const*/ BinaryOperator /*P*/ E) {
    Visit(E.getLHS());
    Visit(E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 120,
   FQN="(anonymous namespace)::SizeofFinder::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_112SizeofFinder21VisitImplicitCastExprEPKN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinder21VisitImplicitCastExprEPKN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(/*const*/ ImplicitCastExpr /*P*/ E) {
    Visit(E.getSubExpr$Const());
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 124,
   FQN="(anonymous namespace)::SizeofFinder::VisitParenExpr", NM="_ZN12_GLOBAL__N_112SizeofFinder14VisitParenExprEPKN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinder14VisitParenExprEPKN5clang9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(/*const*/ ParenExpr /*P*/ E) {
    Visit(E.getSubExpr$Const());
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 128,
   FQN="(anonymous namespace)::SizeofFinder::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_112SizeofFinder29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinder29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ E) {
    if (E.getKind() != UnaryExprOrTypeTrait.UETT_SizeOf) {
      return;
    }
    
    Sizeofs.push_back_T$C$R(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::~SizeofFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 111,
   FQN="(anonymous namespace)::SizeofFinder::~SizeofFinder", NM="_ZN12_GLOBAL__N_112SizeofFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Sizeofs.$destroy();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SizeofFinder::SizeofFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 111,
   FQN="(anonymous namespace)::SizeofFinder::SizeofFinder", NM="_ZN12_GLOBAL__N_112SizeofFinderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_112SizeofFinderC1Ev")
  //</editor-fold>
  public /*inline*/ SizeofFinder() {
    // : ConstStmtVisitor<SizeofFinder>(), Sizeofs() 
    //START JInit
    $ConstStmtVisitor();
    this.Sizeofs = new std.vector</*const*/ UnaryExprOrTypeTraitExpr /*P*/ >((/*const*/ UnaryExprOrTypeTraitExpr /*P*/ )null);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Sizeofs=" + Sizeofs // NOI18N
              + super.toString(); // NOI18N
  }
}
