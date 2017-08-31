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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import org.llvm.adt.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// Basic class for comparison operations over expressions.
/*template <typename Self> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Comparator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 283,
 FQN="clang::threadSafety::til::Comparator", NM="_ZN5clang12threadSafety3til10ComparatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ComparatorE")
//</editor-fold>
abstract public class Comparator</*typename*/ Self>  {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Comparator::self">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 286,
   FQN="clang::threadSafety::til::Comparator::self", NM="_ZN5clang12threadSafety3til10Comparator4selfEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10Comparator4selfEv")
  //</editor-fold>
  protected Comparator /*P*/ self() {
    return this;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Comparator::compareByCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 289,
   FQN="clang::threadSafety::til::Comparator::compareByCase", NM="_ZN5clang12threadSafety3til10Comparator13compareByCaseEPKNS1_5SExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10Comparator13compareByCaseEPKNS1_5SExprES5_")
  //</editor-fold>
  public boolean compareByCase(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
    switch (E1.opcode()) {
     case COP_Future:
      //===- ThreadSafetyTIL.h ---------------------------------------*- C++ --*-===//
      //
      //                     The LLVM Compiler Infrastructure
      //
      // This file is distributed under the University of Illinois Open Source
      // License. See LICENSE.TXT for details.
      //
      //===----------------------------------------------------------------------===//
      //
      // This file defines the list of core opcodes for the Thread Safety
      // Typed Intermediate language.  Please see ThreadSafetyTIL.h for more
      // information.
      //
      //===----------------------------------------------------------------------===//
      return cast_Future(E1).compare(cast_Future(E2), Native.$star(self()));
     case COP_Undefined:
      return cast_Undefined(E1).compare(cast_Undefined(E2), Native.$star(self()));
     case COP_Wildcard:
      return cast_Wildcard(E1).compare(cast_Wildcard(E2), Native.$star(self()));
     case COP_Literal:
      return cast_Literal(E1).compare(cast_Literal(E2), Native.$star(self()));
     case COP_LiteralPtr:
      return cast_LiteralPtr(E1).compare(cast_LiteralPtr(E2), Native.$star(self()));
     case COP_Variable:
      return cast_Variable(E1).compare(cast_Variable(E2), Native.$star(self()));
     case COP_Function:
      return cast_Function(E1).compare(cast_Function(E2), Native.$star(self()));
     case COP_SFunction:
      return cast_SFunction(E1).compare(cast_SFunction(E2), Native.$star(self()));
     case COP_Code:
      return cast_Code(E1).compare(cast_Code(E2), Native.$star(self()));
     case COP_Field:
      return cast_Field(E1).compare(cast_Field(E2), Native.$star(self()));
     case COP_Apply:
      return cast_Apply(E1).compare(cast_Apply(E2), Native.$star(self()));
     case COP_SApply:
      return cast_SApply(E1).compare(cast_SApply(E2), Native.$star(self()));
     case COP_Project:
      return cast_Project(E1).compare(cast_Project(E2), Native.$star(self()));
     case COP_Call:
      return cast_Call(E1).compare(cast_Call(E2), Native.$star(self()));
     case COP_Alloc:
      return cast_Alloc(E1).compare(cast_Alloc(E2), Native.$star(self()));
     case COP_Load:
      return cast_Load(E1).compare(cast_Load(E2), Native.$star(self()));
     case COP_Store:
      return cast_Store(E1).compare(cast_Store(E2), Native.$star(self()));
     case COP_ArrayIndex:
      return cast_ArrayIndex(E1).compare(cast_ArrayIndex(E2), Native.$star(self()));
     case COP_ArrayAdd:
      return cast_ArrayAdd(E1).compare(cast_ArrayAdd(E2), Native.$star(self()));
     case COP_UnaryOp:
      return cast_UnaryOp(E1).compare(cast_UnaryOp(E2), Native.$star(self()));
     case COP_BinaryOp:
      return cast_BinaryOp(E1).compare(cast_BinaryOp(E2), Native.$star(self()));
     case COP_Cast:
      return cast_Cast(E1).compare(cast_Cast(E2), Native.$star(self()));
     case COP_SCFG:
      return cast_SCFG(E1).compare(cast_SCFG(E2), Native.$star(self()));
     case COP_BasicBlock:
      return cast_BasicBlock(E1).compare(cast_BasicBlock(E2), Native.$star(self()));
     case COP_Phi:
      return cast_Phi(E1).compare(cast_Phi(E2), Native.$star(self()));
     case COP_Goto:
      
      // Terminator instructions
      return cast_Goto(E1).compare(cast_Goto(E2), Native.$star(self()));
     case COP_Branch:
      return cast_Branch(E1).compare(cast_Branch(E2), Native.$star(self()));
     case COP_Return:
      return cast_Return(E1).compare(cast_Return(E2), Native.$star(self()));
     case COP_Identifier:
      
      // pseudo-terms
      return cast_Identifier(E1).compare(cast_Identifier(E2), Native.$star(self()));
     case COP_IfThenElse:
      return cast_IfThenElse(E1).compare(cast_IfThenElse(E2), Native.$star(self()));
     case COP_Let:
      return cast_Let(E1).compare(cast_Let(E2), Native.$star(self()));
    }
    return false;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  abstract public boolean compareVariableRefs(/*const*/ Variable /*P*/ V1, /*const*/ Variable /*P*/ V2);
  
  abstract public boolean compare(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2);
  
  abstract public boolean compareIntegers(/*uint*/int i, /*uint*/int j);
  
  abstract public boolean comparePointers(/*const*/Object/*void P*/ P, /*const*/Object/*void P*/ Q);
  
  abstract public boolean compareStrings(StringRef s, StringRef r);
  
  abstract public void enterScope(/*const*/ Variable /*P*/ V1, /*const*/ Variable /*P*/ V2);
  
  abstract public boolean notTrue(boolean ct);
  
  abstract public void leaveScope();
  
  abstract public boolean trueResult();

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
