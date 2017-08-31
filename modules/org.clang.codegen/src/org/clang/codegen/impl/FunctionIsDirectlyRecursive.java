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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionIsDirectlyRecursive">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1648,
 FQN="(anonymous namespace)::FunctionIsDirectlyRecursive", NM="_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursiveE")
//</editor-fold>
public class/*struct*/ FunctionIsDirectlyRecursive implements /*public*/ RecursiveASTVisitor<FunctionIsDirectlyRecursive> {
  public /*const*/ StringRef Name;
  public final /*const*/ Builtin.Context /*&*/ BI;
  public boolean Result;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionIsDirectlyRecursive::FunctionIsDirectlyRecursive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1653,
   FQN="(anonymous namespace)::FunctionIsDirectlyRecursive::FunctionIsDirectlyRecursive", NM="_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursiveC1EN4llvm9StringRefERKN5clang7Builtin7ContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursiveC1EN4llvm9StringRefERKN5clang7Builtin7ContextE")
  //</editor-fold>
  public FunctionIsDirectlyRecursive(StringRef N, final /*const*/ Builtin.Context /*&*/ C) {
    // : RecursiveASTVisitor<FunctionIsDirectlyRecursive>(), Name(N), BI(C), Result(false) 
    //START JInit
    $RecursiveASTVisitor();
    this.Name = new StringRef(N);
    this./*&*/BI=/*&*/C;
    this.Result = false;
    //END JInit
  }

  // JAVA: typedef RecursiveASTVisitor<FunctionIsDirectlyRecursive> Base
//  public final class Base extends RecursiveASTVisitor<FunctionIsDirectlyRecursive>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionIsDirectlyRecursive::TraverseCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1658,
   FQN="(anonymous namespace)::FunctionIsDirectlyRecursive::TraverseCallExpr", NM="_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursive16TraverseCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_127FunctionIsDirectlyRecursive16TraverseCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public boolean TraverseCallExpr(CallExpr /*P*/ E) {
    /*const*/ FunctionDecl /*P*/ FD = E.getDirectCallee();
    if (!(FD != null)) {
      return true;
    }
    AsmLabelAttr /*P*/ Attr = FD.getAttr(AsmLabelAttr.class);
    if ((Attr != null) && $eq_StringRef(/*NO_COPY*/Name, Attr.getLabel())) {
      Result = true;
      return false;
    }
    /*uint*/int BuiltinID = FD.getBuiltinID();
    if (!(BuiltinID != 0) || !BI.isLibFunction(BuiltinID)) {
      return true;
    }
    StringRef BuiltinName = new StringRef(BI.getName(BuiltinID));
    if (BuiltinName.startswith(/*STRINGREF_STR*/"__builtin_")
       && $eq_StringRef(/*NO_COPY*/Name, BuiltinName.slice(strlen(/*KEEP_STR*/"__builtin_"), StringRef.npos))) {
      Result = true;
      return false;
    }
    return true;
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", BI=" + "[Context]" // NOI18N
              + ", Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
