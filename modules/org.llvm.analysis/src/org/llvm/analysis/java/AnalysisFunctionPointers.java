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

package org.llvm.analysis.java;

import org.clank.support.aliases.char$ptr;
import org.llvm.analysis.AAResults;
import org.llvm.analysis.BlockFrequencyInfo;
import org.llvm.analysis.BlockFrequencyInfoImplBase.BlockNode;
import org.llvm.analysis.Loop;
import org.llvm.analysis.SCEV;
import org.llvm.analysis.target.TargetTransformInfo;
import org.llvm.ir.AnalysisManager;
import org.llvm.ir.Function;
import static org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.Type;
import org.llvm.pass.Pass;
/**
 *
 * @author alex
 */
public class AnalysisFunctionPointers {
  

  @FunctionalInterface
  public static interface FunctionAnalysisManager$FunctionAAResults2Void {
    void $call(Function /*&*/  P1, AnalysisManager<Function>/*&*/  P2, AAResults /*&*/  P3);
  }

  @FunctionalInterface
  public static interface Function2TargetTransformInfo {
    TargetTransformInfo $call(/*const*/ Function /*&*/  P1);
  }

  @FunctionalInterface
  public static interface PassFunctionAAResults2Void {
    void $call(Pass /*&*/  P1, Function /*&*/  P2, AAResults /*&*/  P3);
  }

  @FunctionalInterface
  public static interface SCEVType2SCEV {
    /*const*/ SCEV /*P*/ $call(/*const*/ SCEV /*P*/  P1, Type /*P*/  P2);
  }

  @FunctionalInterface
  public static interface Double2Double {
    double $call(double P1);
  }

  @FunctionalInterface
  public static interface DoubleDouble2Double {
    double $call(double P1, double P2);
  }

  @FunctionalInterface
  public static interface Function2BlockFrequencyInfo {
    BlockFrequencyInfo /*P*/ $call(/*const*/ Function /*&*/  P1);
  }

  @FunctionalInterface
  public static interface LoopLoop2Bool {
    boolean $call(/*const*/ Loop /*P*/  P1, /*const*/ Loop /*P*/  P2);
  }

  @FunctionalInterface
  public static interface BlockNode2Bool {
    boolean $call(/*const*/ BlockNode /*&*/  P1);
  }

  @FunctionalInterface
  public static interface Char2Void {
    void $call(/*const*/char$ptr/*char P*/  P1);
  }

  @FunctionalInterface
  public static interface CharPrt2Void {
    void $call(/*const*/char$ptr/*char P*/  P1);
  }

  @FunctionalInterface
  public static interface UIntInt2Void {
    void $call(/*uint*/int P1, /*uint*/int P2);
  }
}
