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
import static org.llvm.support.llvm.*;


// Defines an interface used to traverse SExprs.  Traversals have been made as
// generic as possible, and are intended to handle any kind of pass over the
// AST, e.g. visiters, copying, non-destructive rewriting, destructive
// (in-place) rewriting, hashing, typing, etc.
//
// Traversals implement the functional notion of a "fold" operation on SExprs.
// Each SExpr class provides a traverse method, which does the following:
//   * e->traverse(v):
//       // compute a result r_i for each subexpression e_i
//       for (i = 1..n)  r_i = v.traverse(e_i);
//       // combine results into a result for e,  where X is the class of e
//       return v.reduceX(*e, r_1, .. r_n).
//
// A visitor can control the traversal by overriding the following methods:
//   * v.traverse(e):
//       return v.traverseByCase(e), which returns v.traverseX(e)
//   * v.traverseX(e):   (X is the class of e)
//       return e->traverse(v).
//   * v.reduceX(*e, r_1, .. r_n):
//       compute a result for a node of type X
//
// The reduceX methods control the kind of traversal (visitor, copy, etc.).
// They are defined in derived classes.
//
// Class R defines the basic interface types (R_SExpr).
/*template <class Self, class R> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 52,
 FQN="clang::threadSafety::til::Traversal", NM="_ZN5clang12threadSafety3til9TraversalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9TraversalE")
//</editor-fold>
public interface Traversal</*class*/ Self extends VisitReducer, /*class*/ R>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::self">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 55,
   FQN="clang::threadSafety::til::Traversal::self", NM="_ZN5clang12threadSafety3til9Traversal4selfEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal4selfEv")
  //</editor-fold>
  default public Self /*P*/ self() {
    return ((/*static_cast*/Self /*P*/ )(this));
  }

  
  // Traverse an expression -- returning a result of type R_SExpr.
  // Override this method to do something for every expression, regardless
  // of which kind it is.
  // E is a reference, so this can be use for in-place updates.
  // The type T must be a subclass of SExpr.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 63,
   FQN="clang::threadSafety::til::Traversal::traverse", NM="Tpl__ZN5clang12threadSafety3til9Traversal8traverseERPT_NT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til9Traversal8traverseERPT_NT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverse(SExpr /*P*/ /*&*/ E, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return traverseSExpr(E, Ctx);
  }

  
  // Override this method to do something for every expression.
  // Does not allow in-place updates.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseSExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 69,
   FQN="clang::threadSafety::til::Traversal::traverseSExpr", NM="_ZN5clang12threadSafety3til9Traversal13traverseSExprEPNS1_5SExprENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal13traverseSExprEPNS1_5SExprENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseSExpr(SExpr /*P*/ E, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return traverseByCase(E, Ctx);
  }

  
  // Helper method to call traverseX(e) on the appropriate type.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseByCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 74,
   FQN="clang::threadSafety::til::Traversal::traverseByCase", NM="_ZN5clang12threadSafety3til9Traversal14traverseByCaseEPNS1_5SExprENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal14traverseByCaseEPNS1_5SExprENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseByCase(SExpr /*P*/ E, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    switch (E.opcode()) {
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
      return self().traverseFuture(cast(Future.class, E), Ctx);
     case COP_Undefined:
      return self().traverseUndefined(cast(Undefined.class, E), Ctx);
     case COP_Wildcard:
      return self().traverseWildcard(cast(Wildcard.class, E), Ctx);
     case COP_Literal:
      return self().traverseLiteral(cast(Literal.class, E), Ctx);
     case COP_LiteralPtr:
      return self().traverseLiteralPtr(cast(LiteralPtr.class, E), Ctx);
     case COP_Variable:
      return self().traverseVariable(cast(Variable.class, E), Ctx);
     case COP_Function:
      return self().traverseFunction(cast(Function.class, E), Ctx);
     case COP_SFunction:
      return self().traverseSFunction(cast(SFunction.class, E), Ctx);
     case COP_Code:
      return self().traverseCode(cast(Code.class, E), Ctx);
     case COP_Field:
      return self().traverseField(cast(Field.class, E), Ctx);
     case COP_Apply:
      return self().traverseApply(cast(Apply.class, E), Ctx);
     case COP_SApply:
      return self().traverseSApply(cast(SApply.class, E), Ctx);
     case COP_Project:
      return self().traverseProject(cast(Project.class, E), Ctx);
     case COP_Call:
      return self().traverseCall(cast(Call.class, E), Ctx);
     case COP_Alloc:
      return self().traverseAlloc(cast(Alloc.class, E), Ctx);
     case COP_Load:
      return self().traverseLoad(cast(Load.class, E), Ctx);
     case COP_Store:
      return self().traverseStore(cast(Store.class, E), Ctx);
     case COP_ArrayIndex:
      return self().traverseArrayIndex(cast(ArrayIndex.class, E), Ctx);
     case COP_ArrayAdd:
      return self().traverseArrayAdd(cast(ArrayAdd.class, E), Ctx);
     case COP_UnaryOp:
      return self().traverseUnaryOp(cast(UnaryOp.class, E), Ctx);
     case COP_BinaryOp:
      return self().traverseBinaryOp(cast(BinaryOp.class, E), Ctx);
     case COP_Cast:
      return self().traverseCast(cast(Cast.class, E), Ctx);
     case COP_SCFG:
      return self().traverseSCFG(cast(SCFG.class, E), Ctx);
     case COP_BasicBlock:
      return self().traverseBasicBlock(cast(BasicBlock.class, E), Ctx);
     case COP_Phi:
      return self().traversePhi(cast(Phi.class, E), Ctx);
     case COP_Goto:
      
      // Terminator instructions
      return self().traverseGoto(cast(Goto.class, E), Ctx);
     case COP_Branch:
      return self().traverseBranch(cast(Branch.class, E), Ctx);
     case COP_Return:
      return self().traverseReturn(cast(Return.class, E), Ctx);
     case COP_Identifier:
      
      // pseudo-terms
      return self().traverseIdentifier(cast(Identifier.class, E), Ctx);
     case COP_IfThenElse:
      return self().traverseIfThenElse(cast(IfThenElse.class, E), Ctx);
     case COP_Let:
      return self().traverseLet(cast(Let.class, E), Ctx);
    }
    //return self().reduceNull();
    new Exception("I don't know what to do; in C++ the code is: return self().reduceNull()").printStackTrace(System.err);
    return false;
  }

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
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseFuture">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 17,
   FQN="clang::threadSafety::til::Traversal::traverseFuture", NM="_ZN5clang12threadSafety3til9Traversal14traverseFutureEPNS1_6FutureENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal14traverseFutureEPNS1_6FutureENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseFuture(Future /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 18,
   FQN="clang::threadSafety::til::Traversal::traverseUndefined", NM="_ZN5clang12threadSafety3til9Traversal17traverseUndefinedEPNS1_9UndefinedENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal17traverseUndefinedEPNS1_9UndefinedENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseUndefined(Undefined /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseWildcard">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 19,
   FQN="clang::threadSafety::til::Traversal::traverseWildcard", NM="_ZN5clang12threadSafety3til9Traversal16traverseWildcardEPNS1_8WildcardENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal16traverseWildcardEPNS1_8WildcardENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseWildcard(Wildcard /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 21,
   FQN="clang::threadSafety::til::Traversal::traverseLiteral", NM="_ZN5clang12threadSafety3til9Traversal15traverseLiteralEPNS1_7LiteralENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal15traverseLiteralEPNS1_7LiteralENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseLiteral(Literal /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseLiteralPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 22,
   FQN="clang::threadSafety::til::Traversal::traverseLiteralPtr", NM="_ZN5clang12threadSafety3til9Traversal18traverseLiteralPtrEPNS1_10LiteralPtrENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal18traverseLiteralPtrEPNS1_10LiteralPtrENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseLiteralPtr(LiteralPtr /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseVariable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 23,
   FQN="clang::threadSafety::til::Traversal::traverseVariable", NM="_ZN5clang12threadSafety3til9Traversal16traverseVariableEPNS1_8VariableENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal16traverseVariableEPNS1_8VariableENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseVariable(Variable /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 24,
   FQN="clang::threadSafety::til::Traversal::traverseFunction", NM="_ZN5clang12threadSafety3til9Traversal16traverseFunctionEPNS1_8FunctionENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal16traverseFunctionEPNS1_8FunctionENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseFunction(Function /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseSFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 25,
   FQN="clang::threadSafety::til::Traversal::traverseSFunction", NM="_ZN5clang12threadSafety3til9Traversal17traverseSFunctionEPNS1_9SFunctionENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal17traverseSFunctionEPNS1_9SFunctionENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseSFunction(SFunction /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseCode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 26,
   FQN="clang::threadSafety::til::Traversal::traverseCode", NM="_ZN5clang12threadSafety3til9Traversal12traverseCodeEPNS1_4CodeENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseCodeEPNS1_4CodeENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseCode(Code /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseField">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 27,
   FQN="clang::threadSafety::til::Traversal::traverseField", NM="_ZN5clang12threadSafety3til9Traversal13traverseFieldEPNS1_5FieldENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal13traverseFieldEPNS1_5FieldENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseField(Field /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseApply">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 29,
   FQN="clang::threadSafety::til::Traversal::traverseApply", NM="_ZN5clang12threadSafety3til9Traversal13traverseApplyEPNS1_5ApplyENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal13traverseApplyEPNS1_5ApplyENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseApply(Apply /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseSApply">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 30,
   FQN="clang::threadSafety::til::Traversal::traverseSApply", NM="_ZN5clang12threadSafety3til9Traversal14traverseSApplyEPNS1_6SApplyENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal14traverseSApplyEPNS1_6SApplyENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseSApply(SApply /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseProject">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 31,
   FQN="clang::threadSafety::til::Traversal::traverseProject", NM="_ZN5clang12threadSafety3til9Traversal15traverseProjectEPNS1_7ProjectENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal15traverseProjectEPNS1_7ProjectENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseProject(Project /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 33,
   FQN="clang::threadSafety::til::Traversal::traverseCall", NM="_ZN5clang12threadSafety3til9Traversal12traverseCallEPNS1_4CallENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseCallEPNS1_4CallENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseCall(Call /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseAlloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 34,
   FQN="clang::threadSafety::til::Traversal::traverseAlloc", NM="_ZN5clang12threadSafety3til9Traversal13traverseAllocEPNS1_5AllocENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal13traverseAllocEPNS1_5AllocENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseAlloc(Alloc /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseLoad">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 35,
   FQN="clang::threadSafety::til::Traversal::traverseLoad", NM="_ZN5clang12threadSafety3til9Traversal12traverseLoadEPNS1_4LoadENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseLoadEPNS1_4LoadENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseLoad(Load /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseStore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 36,
   FQN="clang::threadSafety::til::Traversal::traverseStore", NM="_ZN5clang12threadSafety3til9Traversal13traverseStoreEPNS1_5StoreENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal13traverseStoreEPNS1_5StoreENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseStore(Store /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseArrayIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 37,
   FQN="clang::threadSafety::til::Traversal::traverseArrayIndex", NM="_ZN5clang12threadSafety3til9Traversal18traverseArrayIndexEPNS1_10ArrayIndexENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal18traverseArrayIndexEPNS1_10ArrayIndexENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseArrayIndex(ArrayIndex /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseArrayAdd">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 38,
   FQN="clang::threadSafety::til::Traversal::traverseArrayAdd", NM="_ZN5clang12threadSafety3til9Traversal16traverseArrayAddEPNS1_8ArrayAddENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal16traverseArrayAddEPNS1_8ArrayAddENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseArrayAdd(ArrayAdd /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseUnaryOp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 40,
   FQN="clang::threadSafety::til::Traversal::traverseUnaryOp", NM="_ZN5clang12threadSafety3til9Traversal15traverseUnaryOpEPNS1_7UnaryOpENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal15traverseUnaryOpEPNS1_7UnaryOpENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseUnaryOp(UnaryOp /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseBinaryOp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 41,
   FQN="clang::threadSafety::til::Traversal::traverseBinaryOp", NM="_ZN5clang12threadSafety3til9Traversal16traverseBinaryOpEPNS1_8BinaryOpENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal16traverseBinaryOpEPNS1_8BinaryOpENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseBinaryOp(BinaryOp /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseCast">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 42,
   FQN="clang::threadSafety::til::Traversal::traverseCast", NM="_ZN5clang12threadSafety3til9Traversal12traverseCastEPNS1_4CastENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseCastEPNS1_4CastENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseCast(Cast /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseSCFG">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 44,
   FQN="clang::threadSafety::til::Traversal::traverseSCFG", NM="_ZN5clang12threadSafety3til9Traversal12traverseSCFGEPNS1_4SCFGENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseSCFGEPNS1_4SCFGENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseSCFG(SCFG /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseBasicBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 45,
   FQN="clang::threadSafety::til::Traversal::traverseBasicBlock", NM="_ZN5clang12threadSafety3til9Traversal18traverseBasicBlockEPNS1_10BasicBlockENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal18traverseBasicBlockEPNS1_10BasicBlockENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseBasicBlock(BasicBlock /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traversePhi">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 46,
   FQN="clang::threadSafety::til::Traversal::traversePhi", NM="_ZN5clang12threadSafety3til9Traversal11traversePhiEPNS1_3PhiENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal11traversePhiEPNS1_3PhiENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traversePhi(Phi /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  
  // Terminator instructions
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseGoto">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 49,
   FQN="clang::threadSafety::til::Traversal::traverseGoto", NM="_ZN5clang12threadSafety3til9Traversal12traverseGotoEPNS1_4GotoENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal12traverseGotoEPNS1_4GotoENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseGoto(Goto /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseBranch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 50,
   FQN="clang::threadSafety::til::Traversal::traverseBranch", NM="_ZN5clang12threadSafety3til9Traversal14traverseBranchEPNS1_6BranchENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal14traverseBranchEPNS1_6BranchENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseBranch(Branch /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseReturn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 51,
   FQN="clang::threadSafety::til::Traversal::traverseReturn", NM="_ZN5clang12threadSafety3til9Traversal14traverseReturnEPNS1_6ReturnENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal14traverseReturnEPNS1_6ReturnENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseReturn(Return /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  
  // pseudo-terms
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 54,
   FQN="clang::threadSafety::til::Traversal::traverseIdentifier", NM="_ZN5clang12threadSafety3til9Traversal18traverseIdentifierEPNS1_10IdentifierENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal18traverseIdentifierEPNS1_10IdentifierENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseIdentifier(Identifier /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseIfThenElse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 55,
   FQN="clang::threadSafety::til::Traversal::traverseIfThenElse", NM="_ZN5clang12threadSafety3til9Traversal18traverseIfThenElseEPNS1_10IfThenElseENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal18traverseIfThenElseEPNS1_10IfThenElseENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseIfThenElse(IfThenElse /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Traversal::traverseLet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyOps.def", line = 56,
   FQN="clang::threadSafety::til::Traversal::traverseLet", NM="_ZN5clang12threadSafety3til9Traversal11traverseLetEPNS1_3LetENT0_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til9Traversal11traverseLetEPNS1_3LetENT0_5R_CtxE")
  //</editor-fold>
  default public boolean/*R.R_SExpr*/ traverseLet(Let /*P*/ e, SimpleReducerBase.TraversalKind/*R.R_Ctx*/ Ctx) {
    return e.traverse(Native.$star(self()), Ctx);
  }
}
