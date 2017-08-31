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
package org.llvm.ir.java;

import org.clank.java.std;
import org.clank.support.Native;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.StringRef;
import org.llvm.ir.BasicBlock;
import org.llvm.ir.DISubprogram;
import org.llvm.ir.DiagnosticInfo;
import org.llvm.ir.GlobalValue;
import org.llvm.ir.LLVMContext;
import org.llvm.ir.ProfileSummaryEntry;
import org.llvm.ir.Value;

/**
 *
 * @author Vladimir Voskresensky
 */
public interface IRFunctionPointers {
  // bool (const ProfileSummaryEntry & , uint64_t)
  @FunctionalInterface
  public static interface ProfileSummaryEntryULong2Bool extends Native.ComparatorLower<ProfileSummaryEntry, Long> {
  }
 
  // void (* )(const DiagnosticInfo & , void * )
  @FunctionalInterface
  public static interface DiagnosticInfoHandler {
    void $call(/*const*/ DiagnosticInfo /*&*/ DiagInfo, /*void P*/Object Context);
  }  
  
  // void (* )(const DiagnosticInfo &)
  // typedef std::function<void(const DiagnosticInfo &)> DiagnosticHandlerFunction;
  @FunctionalInterface
  public static interface DiagnosticHandlerFunction {
    void $call(/*const*/ DiagnosticInfo /*&*/ DiagInfo);
  }
  
  // void (* )(const DiagnosticInfo &)
  // typedef void (*YieldCallbackTy)(LLVMContext *Context, void *OpaqueHandle);
  @FunctionalInterface
  public static interface YieldCallbackTy {
    void $call(LLVMContext /*P*/ Context, Object/*void P*/ OpaqueHandle);
  }
  
  //typedef std::pointer_to_unary_function<Value *, BasicBlock *> DerefFnTy;
  @FunctionalInterface
  public static interface Value2BasicBlock {
    BasicBlock /*P*/ $call(Value /*P*/ value);
  }  
  
  @FunctionalInterface
  public static interface ConstChar2StdString {
    std.string $call(/*const*/char$ptr/*char P*/ s);
  }  

  @FunctionalInterface
  public static interface DISubprogram2Void {
    void $call(DISubprogram /*P*/  P1);
  }

  @FunctionalInterface
  public static interface CopyConstructor <T> {
    T $call(T other);
  }

  @FunctionalInterface
  public static interface CharPtrCharPtr2Bool {
    boolean $call(/*const*/char$ptr/*char P*/  P1, /*const*/char$ptr/*char P*/  P2);
  }

  @FunctionalInterface
  public static interface GlobalValue2Bool {
    boolean $call(/*const*/ GlobalValue /*P*/  P1);
  }

  @FunctionalInterface
  public static interface StringRefUInt2Bool {
    boolean $call(StringRef P1, /*uint*/int P2);
  }
}
