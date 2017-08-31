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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// Implements a traversal that visits each subexpression, and returns either
// true or false.
/*template <class Self> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 175,
 FQN="clang::threadSafety::til::VisitReducer", NM="_ZN5clang12threadSafety3til12VisitReducerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducerE")
//</editor-fold>
public class VisitReducer extends /*public*/ VisitReducerBase implements /*public*/ Traversal<VisitReducer, VisitReducerBase> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::VisitReducer<Self>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 179,
   FQN="clang::threadSafety::til::VisitReducer::VisitReducer<Self>", NM="_ZN5clang12threadSafety3til12VisitReducerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducerC1Ev")
  //</editor-fold>
  public VisitReducer() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 182,
   FQN="clang::threadSafety::til::VisitReducer::reduceNull", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceNullEv")
  //</editor-fold>
  public boolean reduceNull() {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceUndefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 183,
   FQN="clang::threadSafety::til::VisitReducer::reduceUndefined", NM="_ZN5clang12threadSafety3til12VisitReducer15reduceUndefinedERNS1_9UndefinedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer15reduceUndefinedERNS1_9UndefinedE")
  //</editor-fold>
  public boolean reduceUndefined(final Undefined /*&*/ Orig) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceWildcard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 184,
   FQN="clang::threadSafety::til::VisitReducer::reduceWildcard", NM="_ZN5clang12threadSafety3til12VisitReducer14reduceWildcardERNS1_8WildcardE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer14reduceWildcardERNS1_8WildcardE")
  //</editor-fold>
  public boolean reduceWildcard(final Wildcard /*&*/ Orig) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 186,
   FQN="clang::threadSafety::til::VisitReducer::reduceLiteral", NM="_ZN5clang12threadSafety3til12VisitReducer13reduceLiteralERNS1_7LiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer13reduceLiteralERNS1_7LiteralE")
  //</editor-fold>
  public boolean reduceLiteral(final Literal /*&*/ Orig) {
    return true;
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceLiteralT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 188,
   FQN="clang::threadSafety::til::VisitReducer::reduceLiteralT", NM="Tpl__ZN5clang12threadSafety3til12VisitReducer14reduceLiteralTERNS1_8LiteralTIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til12VisitReducer14reduceLiteralTERNS1_8LiteralTIT_EE")
  //</editor-fold>
  public </*class*/ T> boolean reduceLiteralT(final LiteralT<T> /*&*/ Orig) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceLiteralPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 189,
   FQN="clang::threadSafety::til::VisitReducer::reduceLiteralPtr", NM="_ZN5clang12threadSafety3til12VisitReducer16reduceLiteralPtrERNS1_7LiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer16reduceLiteralPtrERNS1_7LiteralE")
  //</editor-fold>
  public boolean reduceLiteralPtr(final LiteralPtr /*&*/ Orig) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 191,
   FQN="clang::threadSafety::til::VisitReducer::reduceFunction", NM="_ZN5clang12threadSafety3til12VisitReducer14reduceFunctionERNS1_8FunctionEPNS1_8VariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer14reduceFunctionERNS1_8FunctionEPNS1_8VariableEb")
  //</editor-fold>
  public boolean reduceFunction(final Function /*&*/ Orig, Variable /*P*/ Nvd, boolean E0) {
    return (Nvd != null) && E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceSFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 194,
   FQN="clang::threadSafety::til::VisitReducer::reduceSFunction", NM="_ZN5clang12threadSafety3til12VisitReducer15reduceSFunctionERNS1_9SFunctionEPNS1_8VariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer15reduceSFunctionERNS1_9SFunctionEPNS1_8VariableEb")
  //</editor-fold>
  public boolean reduceSFunction(final SFunction /*&*/ Orig, Variable /*P*/ Nvd, boolean E0) {
    return (Nvd != null) && E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 197,
   FQN="clang::threadSafety::til::VisitReducer::reduceCode", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceCodeERNS1_4CodeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceCodeERNS1_4CodeEbb")
  //</editor-fold>
  public boolean reduceCode(final Code /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 200,
   FQN="clang::threadSafety::til::VisitReducer::reduceField", NM="_ZN5clang12threadSafety3til12VisitReducer11reduceFieldERNS1_5FieldEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer11reduceFieldERNS1_5FieldEbb")
  //</editor-fold>
  public boolean reduceField(final Field /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceApply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 203,
   FQN="clang::threadSafety::til::VisitReducer::reduceApply", NM="_ZN5clang12threadSafety3til12VisitReducer11reduceApplyERNS1_5ApplyEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer11reduceApplyERNS1_5ApplyEbb")
  //</editor-fold>
  public boolean reduceApply(final Apply /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceSApply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 206,
   FQN="clang::threadSafety::til::VisitReducer::reduceSApply", NM="_ZN5clang12threadSafety3til12VisitReducer12reduceSApplyERNS1_6SApplyEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer12reduceSApplyERNS1_6SApplyEbb")
  //</editor-fold>
  public boolean reduceSApply(final SApply /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceProject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 209,
   FQN="clang::threadSafety::til::VisitReducer::reduceProject", NM="_ZN5clang12threadSafety3til12VisitReducer13reduceProjectERNS1_7ProjectEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer13reduceProjectERNS1_7ProjectEb")
  //</editor-fold>
  public boolean reduceProject(final Project /*&*/ Orig, boolean E0) {
    return E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 210,
   FQN="clang::threadSafety::til::VisitReducer::reduceCall", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceCallERNS1_4CallEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceCallERNS1_4CallEb")
  //</editor-fold>
  public boolean reduceCall(final Call /*&*/ Orig, boolean E0) {
    return E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceAlloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 211,
   FQN="clang::threadSafety::til::VisitReducer::reduceAlloc", NM="_ZN5clang12threadSafety3til12VisitReducer11reduceAllocERNS1_5AllocEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer11reduceAllocERNS1_5AllocEb")
  //</editor-fold>
  public boolean reduceAlloc(final Alloc /*&*/ Orig, boolean E0) {
    return E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 212,
   FQN="clang::threadSafety::til::VisitReducer::reduceLoad", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceLoadERNS1_4LoadEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceLoadERNS1_4LoadEb")
  //</editor-fold>
  public boolean reduceLoad(final Load /*&*/ Orig, boolean E0) {
    return E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 213,
   FQN="clang::threadSafety::til::VisitReducer::reduceStore", NM="_ZN5clang12threadSafety3til12VisitReducer11reduceStoreERNS1_5StoreEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer11reduceStoreERNS1_5StoreEbb")
  //</editor-fold>
  public boolean reduceStore(final Store /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceArrayIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 214,
   FQN="clang::threadSafety::til::VisitReducer::reduceArrayIndex", NM="_ZN5clang12threadSafety3til12VisitReducer16reduceArrayIndexERNS1_5StoreEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer16reduceArrayIndexERNS1_5StoreEbb")
  //</editor-fold>
  public boolean reduceArrayIndex(final ArrayIndex /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceArrayAdd">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 217,
   FQN="clang::threadSafety::til::VisitReducer::reduceArrayAdd", NM="_ZN5clang12threadSafety3til12VisitReducer14reduceArrayAddERNS1_5StoreEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer14reduceArrayAddERNS1_5StoreEbb")
  //</editor-fold>
  public boolean reduceArrayAdd(final ArrayAdd /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceUnaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 220,
   FQN="clang::threadSafety::til::VisitReducer::reduceUnaryOp", NM="_ZN5clang12threadSafety3til12VisitReducer13reduceUnaryOpERNS1_7UnaryOpEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer13reduceUnaryOpERNS1_7UnaryOpEb")
  //</editor-fold>
  public boolean reduceUnaryOp(final UnaryOp /*&*/ Orig, boolean E0) {
    return E0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceBinaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 221,
   FQN="clang::threadSafety::til::VisitReducer::reduceBinaryOp", NM="_ZN5clang12threadSafety3til12VisitReducer14reduceBinaryOpERNS1_8BinaryOpEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer14reduceBinaryOpERNS1_8BinaryOpEbb")
  //</editor-fold>
  public boolean reduceBinaryOp(final BinaryOp /*&*/ Orig, boolean E0, boolean E1) {
    return E0 && E1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 224,
   FQN="clang::threadSafety::til::VisitReducer::reduceCast", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceCastERNS1_4CastEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceCastERNS1_4CastEb")
  //</editor-fold>
  public boolean reduceCast(final Cast /*&*/ Orig, boolean E0) {
    return E0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceSCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 226,
   FQN="clang::threadSafety::til::VisitReducer::reduceSCFG", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceSCFGERNS1_4SCFGENS1_16VisitReducerBase9ContainerIPNS1_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceSCFGERNS1_4SCFGENS1_16VisitReducerBase9ContainerIPNS1_10BasicBlockEEE")
  //</editor-fold>
  public boolean reduceSCFG(final SCFG /*&*/ Orig, VisitReducerBase.Container<BasicBlock /*P*/ > Bbs) {
    return Bbs.Success;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceBasicBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 229,
   FQN="clang::threadSafety::til::VisitReducer::reduceBasicBlock", NM="_ZN5clang12threadSafety3til12VisitReducer16reduceBasicBlockERNS1_10BasicBlockERNS1_16VisitReducerBase9ContainerIbEES8_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer16reduceBasicBlockERNS1_10BasicBlockERNS1_16VisitReducerBase9ContainerIbEES8_b")
  //</editor-fold>
  public boolean reduceBasicBlock(final BasicBlock /*&*/ Orig, final VisitReducerBase.Container<Boolean> /*&*/ As, 
                  final VisitReducerBase.Container<Boolean> /*&*/ Is, boolean T) {
    return (As.Success && Is.Success && T);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reducePhi">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 233,
   FQN="clang::threadSafety::til::VisitReducer::reducePhi", NM="_ZN5clang12threadSafety3til12VisitReducer9reducePhiERNS1_3PhiERNS1_16VisitReducerBase9ContainerIbEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer9reducePhiERNS1_3PhiERNS1_16VisitReducerBase9ContainerIbEE")
  //</editor-fold>
  public boolean reducePhi(final Phi /*&*/ Orig, final VisitReducerBase.Container<Boolean> /*&*/ As) {
    return As.Success;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceGoto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 236,
   FQN="clang::threadSafety::til::VisitReducer::reduceGoto", NM="_ZN5clang12threadSafety3til12VisitReducer10reduceGotoERNS1_4GotoEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10reduceGotoERNS1_4GotoEPNS1_10BasicBlockE")
  //</editor-fold>
  public boolean reduceGoto(final Goto /*&*/ Orig, BasicBlock /*P*/ B) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 239,
   FQN="clang::threadSafety::til::VisitReducer::reduceBranch", NM="_ZN5clang12threadSafety3til12VisitReducer12reduceBranchERNS1_6BranchEbPNS1_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer12reduceBranchERNS1_6BranchEbPNS1_10BasicBlockES6_")
  //</editor-fold>
  public boolean reduceBranch(final Branch /*&*/ O, boolean C, BasicBlock /*P*/ B0, BasicBlock /*P*/ B1) {
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 242,
   FQN="clang::threadSafety::til::VisitReducer::reduceReturn", NM="_ZN5clang12threadSafety3til12VisitReducer12reduceReturnERNS1_6ReturnEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer12reduceReturnERNS1_6ReturnEb")
  //</editor-fold>
  public boolean reduceReturn(final Return /*&*/ O, boolean E) {
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 246,
   FQN="clang::threadSafety::til::VisitReducer::reduceIdentifier", NM="_ZN5clang12threadSafety3til12VisitReducer16reduceIdentifierERNS1_10IdentifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer16reduceIdentifierERNS1_10IdentifierE")
  //</editor-fold>
  public boolean reduceIdentifier(final Identifier /*&*/ Orig) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceIfThenElse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 249,
   FQN="clang::threadSafety::til::VisitReducer::reduceIfThenElse", NM="_ZN5clang12threadSafety3til12VisitReducer16reduceIfThenElseERNS1_10IfThenElseEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer16reduceIfThenElseERNS1_10IfThenElseEbbb")
  //</editor-fold>
  public boolean reduceIfThenElse(final IfThenElse /*&*/ Orig, boolean C, boolean T, boolean E) {
    return C && T && E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceLet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 252,
   FQN="clang::threadSafety::til::VisitReducer::reduceLet", NM="_ZN5clang12threadSafety3til12VisitReducer9reduceLetERNS1_3LetEPNS1_8VariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer9reduceLetERNS1_3LetEPNS1_8VariableEb")
  //</editor-fold>
  public boolean reduceLet(final Let /*&*/ Orig, Variable /*P*/ Nvd, boolean B) {
    return (Nvd != null) && B;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::enterScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 256,
   FQN="clang::threadSafety::til::VisitReducer::enterScope", NM="_ZN5clang12threadSafety3til12VisitReducer10enterScopeERNS1_8VariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer10enterScopeERNS1_8VariableEb")
  //</editor-fold>
  public Variable /*P*/ enterScope(final Variable /*&*/ Orig, boolean E0) {
    return $AddrOf(Orig);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::exitScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 257,
   FQN="clang::threadSafety::til::VisitReducer::exitScope", NM="_ZN5clang12threadSafety3til12VisitReducer9exitScopeERKNS1_8VariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer9exitScopeERKNS1_8VariableE")
  //</editor-fold>
  public void exitScope(final /*const*/ Variable /*&*/ Orig) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::enterCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 258,
   FQN="clang::threadSafety::til::VisitReducer::enterCFG", NM="_ZN5clang12threadSafety3til12VisitReducer8enterCFGERNS1_4SCFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer8enterCFGERNS1_4SCFGE")
  //</editor-fold>
  public void enterCFG(final SCFG /*&*/ Cfg) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::exitCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 259,
   FQN="clang::threadSafety::til::VisitReducer::exitCFG", NM="_ZN5clang12threadSafety3til12VisitReducer7exitCFGERNS1_4SCFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer7exitCFGERNS1_4SCFGE")
  //</editor-fold>
  public void exitCFG(final SCFG /*&*/ Cfg) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::enterBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 260,
   FQN="clang::threadSafety::til::VisitReducer::enterBasicBlock", NM="_ZN5clang12threadSafety3til12VisitReducer15enterBasicBlockERNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer15enterBasicBlockERNS1_10BasicBlockE")
  //</editor-fold>
  public void enterBasicBlock(final BasicBlock /*&*/ BB) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::exitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 261,
   FQN="clang::threadSafety::til::VisitReducer::exitBasicBlock", NM="_ZN5clang12threadSafety3til12VisitReducer14exitBasicBlockERNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer14exitBasicBlockERNS1_10BasicBlockE")
  //</editor-fold>
  public void exitBasicBlock(final BasicBlock /*&*/ BB) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceVariableRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 263,
   FQN="clang::threadSafety::til::VisitReducer::reduceVariableRef", NM="_ZN5clang12threadSafety3til12VisitReducer17reduceVariableRefEPNS1_8VariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer17reduceVariableRefEPNS1_8VariableE")
  //</editor-fold>
  public Variable /*P*/ reduceVariableRef(Variable /*P*/ Ovd) {
    return Ovd;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::reduceBasicBlockRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 264,
   FQN="clang::threadSafety::til::VisitReducer::reduceBasicBlockRef", NM="_ZN5clang12threadSafety3til12VisitReducer19reduceBasicBlockRefEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer19reduceBasicBlockRefEPNS1_10BasicBlockE")
  //</editor-fold>
  public BasicBlock /*P*/ reduceBasicBlockRef(BasicBlock /*P*/ Obb) {
    return Obb;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 267,
   FQN="clang::threadSafety::til::VisitReducer::traverse", NM="_ZN5clang12threadSafety3til12VisitReducer8traverseEPNS1_5SExprENS1_17SimpleReducerBase13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer8traverseEPNS1_5SExprENS1_17SimpleReducerBase13TraversalKindE")
  //</editor-fold>
  public boolean VisitReducer$traverse(SExpr /*P*/ E) {
    return VisitReducer$traverse(E, TraversalKind.TRV_Normal);
  }
  public boolean VisitReducer$traverse(SExpr /*P*/ E, SimpleReducerBase.TraversalKind K/*= TRV_Normal*/) {
    Success = Success && this.traverseByCase(E, K);
    return Success;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::VisitReducer::visit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 272,
   FQN="clang::threadSafety::til::VisitReducer::visit", NM="_ZN5clang12threadSafety3til12VisitReducer5visitEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til12VisitReducer5visitEPNS1_5SExprE")
  //</editor-fold>
  public static </*class*/ Self> boolean visit(SExpr /*P*/ E) {
    VisitReducer Visitor = new VisitReducer();
    return Visitor.traverse(E, TraversalKind.TRV_Normal);
  }

/*private:*/
  private boolean Success;
  
  @Override public String toString() {
    return "" + "Success=" + Success // NOI18N
              + super.toString(); // NOI18N
  }
}
