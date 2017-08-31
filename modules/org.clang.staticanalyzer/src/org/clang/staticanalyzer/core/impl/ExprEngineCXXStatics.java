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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprEngineCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.ExprEngineCXXStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZL21makeZeroElementRegionN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS1_8QualTypeE;_ZL24canHaveDirectConstructorN5clang10CFGElementE; -static-type=ExprEngineCXXStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class ExprEngineCXXStatics {


/// Returns a region representing the first element of a (possibly
/// multi-dimensional) array.
///
/// On return, \p Ty will be set to the base type of the array.
///
/// If the type is not an array type at all, the original value is returned.
//<editor-fold defaultstate="collapsed" desc="makeZeroElementRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 92,
 FQN="makeZeroElementRegion", NM="_ZL21makeZeroElementRegionN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS1_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZL21makeZeroElementRegionN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS1_8QualTypeE")
//</editor-fold>
public static SVal makeZeroElementRegion(IntrusiveRefCntPtr</*const*/ ProgramState> State, SVal LValue, 
                     final QualType /*&*/ Ty) {
  final SValBuilder /*&*/ SVB = State.$arrow().getStateManager().getSValBuilder();
  final ASTContext /*&*/ Ctx = SVB.getContext();
  {
    
    /*const*/ ArrayType /*P*/ AT;
    while (((/*P*/ AT = Ctx.getAsArrayType(new QualType(Ty))) != null)) {
      Ty.$assignMove(AT.getElementType());
      LValue.$assignMove(State.$arrow().getLValue(new QualType(Ty), new SVal(JD$Move.INSTANCE, SVB.makeZeroArrayIndex()), new SVal(LValue)));
    }
  }
  
  return new SVal(JD$Move.INSTANCE, LValue);
}


/// Returns true if the initializer for \Elem can be a direct
/// constructor.
//<editor-fold defaultstate="collapsed" desc="canHaveDirectConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 161,
 FQN="canHaveDirectConstructor", NM="_ZL24canHaveDirectConstructorN5clang10CFGElementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZL24canHaveDirectConstructorN5clang10CFGElementE")
//</editor-fold>
public static boolean canHaveDirectConstructor(CFGElement Elem) {
  {
    // DeclStmts and CXXCtorInitializers for fields can be directly constructed.
    Optional<CFGStmt> StmtElem = Elem.getAs(CFGStmt.class);
    if (StmtElem.$bool()) {
      if (isa_DeclStmt(StmtElem.$arrow().getStmt())) {
        return true;
      }
    }
  }
  if (Elem.getKind() == CFGElement.Kind.Initializer) {
    return true;
  }
  
  return false;
}

} // END OF class ExprEngineCXXStatics
