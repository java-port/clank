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

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2514,
 FQN="(anonymous namespace)::ExtractSubobjectHandler", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandlerE")
//</editor-fold>
public class/*struct*/ ExtractSubobjectHandler implements SubobjectHandler {
  public final EvalInfo /*&*/ Info;
  public final APValue /*&*/ Result;
  
  // end anonymous namespace
  public static /*const*/ AccessKinds AccessKind = AccessKinds.AK_Read;
  
  /*typedef bool result_type*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2521,
   FQN="(anonymous namespace)::ExtractSubobjectHandler::failed", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandler6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandler6failedEv")
  //</editor-fold>
  public boolean failed() {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2522,
   FQN="(anonymous namespace)::ExtractSubobjectHandler::found", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  public boolean found(final APValue /*&*/ Subobj, QualType SubobjType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assign($c$.track(new APValue(Subobj))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2526,
   FQN="(anonymous namespace)::ExtractSubobjectHandler::found", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APSInt /*&*/ Value, QualType SubobjType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assign($c$.track(new APValue(new APSInt(Value)))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2530,
   FQN="(anonymous namespace)::ExtractSubobjectHandler::found", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APFloat /*&*/ Value, QualType SubobjType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assign($c$.track(new APValue(new APFloat(Value)))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExtractSubobjectHandler::foundString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2534,
   FQN="(anonymous namespace)::ExtractSubobjectHandler::foundString", NM="_ZN12_GLOBAL__N_123ExtractSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123ExtractSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy")
  //</editor-fold>
  public boolean foundString(final APValue /*&*/ Subobj, QualType SubobjType, long/*uint64_t*/ Character) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assign($c$.track(new APValue(extractStringLiteralCharacter(Info, Subobj.getLValueBase().get(/*const*/ Expr /*P*/.class), Character)))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public AccessKinds AccessKind() {return AccessKind;}
  
  public ExtractSubobjectHandler(EvalInfo I, APValue R) { this.Info = I; this.Result = R; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", Result=" + Result; // NOI18N
  }
}
