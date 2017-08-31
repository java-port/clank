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


package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.java.std;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.SMDiagnostic;
import org.llvm.support.yaml.impl.Scanner;

/**
 *
 * @author vvoskres
 */
public final class ADTFunctionPointers {

  private ADTFunctionPointers() {
  }
  
  /// An error handler callback.
//  typedef void (*fatal_error_handler_t)(void *user_data,
//                                        const std::string& reason,
//                                        bool gen_crash_diag);
  public interface fatal_error_handler_t {
    void $call(Object/*void P*/ user_data, std.string reason, boolean gen_crash_diag);
  }
  
//  public interface comparator<T> {
//    int $call(void$ptr p1, void$ptr p2);
//  }
  
  // void (* )(const SMDiagnostic & , void * )
  @FunctionalInterface
  public static interface DiagHandlerTy {
    void $call(/*const*/ SMDiagnostic /*&*/ SMDiag, /*void P*/Object Context);
  }
  
  // void (* )(const SMDiagnostic & , void * , unsigned int)
  @FunctionalInterface
  public static interface SMDiagnosticHandler {
    void $call(/*const*/ SMDiagnostic /*&*/ SMDiag, /*void P*/Object Context, /*uint*/int $Param);
  }
  
  /*typedef StringRef::iterator (Scanner::*SkipWhileFunc)(StringRef::iterator)*/
  @FunctionalInterface
  public static interface Scanner$SkipWhileFunc {
    /*StringRef::iterator*/char$ptr $call(Scanner $this, /*StringRef::iterator*/char$ptr $Prm0);
  }
  
  // ResultT (* )(ArrayRef</*const*/ ArgT /*P*/ >)
  @FunctionalInterface
  public static interface ArrayRefOfPtrs2ResultType<ArgType, ResultType> {
    ResultType $call(ArrayRef<ArgType/*P*/> array);
  }
}
