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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clank.support.Native.Comparator$JavaRef;


/// A stack frame in the constexpr call stack.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallStackFrame">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 307,
 FQN="(anonymous namespace)::CallStackFrame", NM="_ZN12_GLOBAL__N_114CallStackFrameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CallStackFrameE")
//</editor-fold>
public class/*struct*/ CallStackFrame implements Destructors.ClassWithDestructor {
  public final EvalInfo /*&*/ Info;
  
  /// Parent - The caller of this stack frame.
  public CallStackFrame /*P*/ Caller;
  
  /// CallLoc - The location of the call expression for this call.
  public SourceLocation CallLoc;
  
  /// Callee - The function which was called.
  public /*const*/ FunctionDecl /*P*/ Callee;
  
  /// Index - The call index of this call.
  public /*uint*/int Index;
  
  /// This - The binding for the this pointer in this call, if any.
  public /*const*/ LValue /*P*/ This;
  
  /// Arguments - Parameter bindings for this function call, indexed by
  /// parameters' function scope indices.
  public type$ptr<APValue> /*P*/ Arguments;
  
  // Note that we intentionally use std::map here so that references to
  // values are stable.
  /*typedef std::map<const void *, APValue> MapTy*/
//  public final class MapTy extends std.map</*const*/Object/*void P*/ , APValue>{ };
  /*typedef MapTy::const_iterator temp_iterator*/
//  public final class temp_iterator extends _Rb_tree_const_iterator<pair</*const*/Object/*void P*//*const*/, APValue> >{ };
  /// Temporaries - Temporary lvalues materialized within this stack frame.
  public std.mapPtrType</*const*/Object/*void P*/ , APValue> Temporaries;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallStackFrame::CallStackFrame">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 961,
   FQN="(anonymous namespace)::CallStackFrame::CallStackFrame", NM="_ZN12_GLOBAL__N_114CallStackFrameC1ERNS_8EvalInfoEN5clang14SourceLocationEPKNS3_12FunctionDeclEPKNS_6LValueEPNS3_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CallStackFrameC1ERNS_8EvalInfoEN5clang14SourceLocationEPKNS3_12FunctionDeclEPKNS_6LValueEPNS3_7APValueE")
  //</editor-fold>
  public CallStackFrame(final EvalInfo /*&*/ Info, SourceLocation CallLoc, 
      /*const*/ FunctionDecl /*P*/ Callee, /*const*/ LValue /*P*/ This, 
      type$ptr<APValue> Arguments) {
    // : Info(Info), Caller(Info.CurrentCall), CallLoc(CallLoc), Callee(Callee), Index(Info.NextCallIndex++), This(This), Arguments(Arguments), Temporaries() 
    //START JInit
    this./*&*/Info=/*&*/Info;
    this.Caller = Info.CurrentCall;
    this.CallLoc = new SourceLocation(CallLoc);
    this.Callee = Callee;
    this.Index = Info.NextCallIndex++;
    this.This = This;
    this.Arguments = Arguments;
    this.Temporaries = new std.mapPtrType</*const*/Object/*void P*/ , APValue>(Comparator$JavaRef(), new APValue());
    //END JInit
    Info.CurrentCall = this;
    ++Info.CallStackDepth;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallStackFrame::~CallStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 970,
   FQN="(anonymous namespace)::CallStackFrame::~CallStackFrame", NM="_ZN12_GLOBAL__N_114CallStackFrameD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CallStackFrameD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (Info.CurrentCall == this) : "calls retired out of order";
    --Info.CallStackDepth;
    Info.CurrentCall = Caller;
    //START JDestroy
    Temporaries.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallStackFrame::getTemporary">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 341,
   FQN="(anonymous namespace)::CallStackFrame::getTemporary", NM="_ZN12_GLOBAL__N_114CallStackFrame12getTemporaryEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CallStackFrame12getTemporaryEPKv")
  //</editor-fold>
  public APValue /*P*/ getTemporary(/*const*/Object/*void P*/ Key) {
    std.mapPtrType.iterator</*const*/Object/*void P*/ , APValue> I = Temporaries.find(Key);
    return I.$eq(Temporaries.end()) ? null : $AddrOf(I.$arrow().second);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallStackFrame::createTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 976,
   FQN="(anonymous namespace)::CallStackFrame::createTemporary", NM="_ZN12_GLOBAL__N_114CallStackFrame15createTemporaryEPKvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CallStackFrame15createTemporaryEPKvb")
  //</editor-fold>
  public APValue /*&*/ createTemporary(/*const*/Object/*void P*/ Key, 
                 boolean IsLifetimeExtended) {
    final APValue /*&*/ Result = Temporaries.$at_T$C$R(Key);
    assert (Result.isUninit()) : "temporary created multiple times";
    Info.CleanupStack.push_back(new Cleanup($AddrOf(Result), IsLifetimeExtended));
    return Result;
  }

  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", Caller=" + Caller // NOI18N
              + ", CallLoc=" + CallLoc // NOI18N
              + ", Callee=" + Callee // NOI18N
              + ", Index=" + Index // NOI18N
              + ", This=" + This // NOI18N
              + ", Arguments=" + Arguments // NOI18N
              + ", Temporaries=" + Temporaries; // NOI18N
  }
}
