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

import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clank.support.*;


/// Private scope for OpenMP loop-based directives, that supports capturing
/// of used expression from loop statement.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPLoopScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 86,
 FQN="(anonymous namespace)::OMPLoopScope", NM="_ZN12_GLOBAL__N_112OMPLoopScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN12_GLOBAL__N_112OMPLoopScopeE")
//</editor-fold>
public class OMPLoopScope extends /*public*/ CodeGenFunction.RunCleanupsScope implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPLoopScope::emitPreInitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 87,
   FQN="(anonymous namespace)::OMPLoopScope::emitPreInitStmt", NM="_ZN12_GLOBAL__N_112OMPLoopScope15emitPreInitStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN12_GLOBAL__N_112OMPLoopScope15emitPreInitStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_16OMPLoopDirectiveE")
  //</editor-fold>
  private void emitPreInitStmt(final CodeGenFunction /*&*/ CGF, final /*const*/ OMPLoopDirective /*&*/ S) {
    {
      /*const*/ OMPLoopDirective /*P*/ LD = AstRTTI.dyn_cast_OMPLoopDirective(/*AddrOf*/S);
      if ((LD != null)) {
        {
          /*const*/ DeclStmt /*P*/ PreInits = AstStatementsRTTI.cast_or_null_DeclStmt(LD.getPreInits$Const());
          if ((PreInits != null)) {
            for (/*const*/ Decl /*P*/ I : PreInits.decls$Const())  {
              CGF.EmitVarDecl(AstDeclarationsRTTI.cast_VarDecl(/*Deref*/I));
            }
          }
        }
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPLoopScope::OMPLoopScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 97,
   FQN="(anonymous namespace)::OMPLoopScope::OMPLoopScope", NM="_ZN12_GLOBAL__N_112OMPLoopScopeC1ERN5clang7CodeGen15CodeGenFunctionERKNS1_16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN12_GLOBAL__N_112OMPLoopScopeC1ERN5clang7CodeGen15CodeGenFunctionERKNS1_16OMPLoopDirectiveE")
  //</editor-fold>
  public OMPLoopScope(final CodeGenFunction /*&*/ CGF, final /*const*/ OMPLoopDirective /*&*/ S) {
    // : CodeGenFunction::RunCleanupsScope(CGF) 
    //START JInit
    super(CGF);
    //END JInit
    emitPreInitStmt(CGF, S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPLoopScope::~OMPLoopScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 86,
   FQN="(anonymous namespace)::OMPLoopScope::~OMPLoopScope", NM="_ZN12_GLOBAL__N_112OMPLoopScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN12_GLOBAL__N_112OMPLoopScopeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy_OMPLoopScope() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
