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

package org.clang.sema.impl;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.OMPClauseMappableExprCommon.*;

// Utility struct that gathers all the related lists associated with a mappable
// expression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableVarListInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10807,
 FQN="(anonymous namespace)::MappableVarListInfo", NM="_ZN12_GLOBAL__N_119MappableVarListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_119MappableVarListInfoE")
//</editor-fold>
public final class/*struct*/ MappableVarListInfo implements Destructors.ClassWithDestructor {
  // The list of expressions.
  public ArrayRef<Expr /*P*/ > VarList;
  // The list of processed expressions.
  public SmallVector<Expr /*P*/ > ProcessedVarList;
  // The mappble components for each expression.
  public SmallVector<SmallVector<MappableComponent>> VarComponents;
  // The base declaration of the variable.
  public SmallVector<ValueDecl /*P*/ > VarBaseDeclarations;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableVarListInfo::MappableVarListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10817,
   FQN="(anonymous namespace)::MappableVarListInfo::MappableVarListInfo", NM="_ZN12_GLOBAL__N_119MappableVarListInfoC1EN4llvm8ArrayRefIPN5clang4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_119MappableVarListInfoC1EN4llvm8ArrayRefIPN5clang4ExprEEE")
  //</editor-fold>
  public MappableVarListInfo(ArrayRef<Expr /*P*/ > VarList) {
    // : VarList(VarList), ProcessedVarList(), VarComponents(), VarBaseDeclarations() 
    //START JInit
    this.VarList = new ArrayRef<Expr /*P*/ >(VarList);
    this.ProcessedVarList = new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    this.VarComponents = new SmallVector<SmallVector<MappableComponent>>(8, new SmallVector<MappableComponent>(8, new MappableComponent()));
    this.VarBaseDeclarations = new SmallVector<ValueDecl /*P*/ >(16, (ValueDecl /*P*/ )null);
    //END JInit
    // We have a list of components and base declarations for each entry in the
    // variable list.
    VarComponents.reserve(VarList.size());
    VarBaseDeclarations.reserve(VarList.size());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableVarListInfo::~MappableVarListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10807,
   FQN="(anonymous namespace)::MappableVarListInfo::~MappableVarListInfo", NM="_ZN12_GLOBAL__N_119MappableVarListInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_119MappableVarListInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VarBaseDeclarations.$destroy();
    VarComponents.$destroy();
    ProcessedVarList.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VarList=" + VarList // NOI18N
              + ", ProcessedVarList=" + ProcessedVarList // NOI18N
              + ", VarComponents=" + VarComponents // NOI18N
              + ", VarBaseDeclarations=" + VarBaseDeclarations; // NOI18N
  }
}
