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

package org.clang.frontend.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 149,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 146,
 FQN="(anonymous namespace)::ASTViewer", NM="_ZN12_GLOBAL__N_19ASTViewerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewerE")
//</editor-fold>
public class ASTViewer extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private ASTContext /*P*/ Context;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 152,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 149,
   FQN="(anonymous namespace)::ASTViewer::Initialize", NM="_ZN12_GLOBAL__N_19ASTViewer10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewer10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(ASTContext /*&*/ Context)/* override*/ {
    this.Context = /*AddrOf*/Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 153,
   FQN="(anonymous namespace)::ASTViewer::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_19ASTViewer18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewer18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(D.begin()), E = D.end(); $noteq_ptr(I, E); I.$preInc())  {
      HandleTopLevelSingleDecl(I.$star());
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer::HandleTopLevelSingleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 163,
   FQN="(anonymous namespace)::ASTViewer::HandleTopLevelSingleDecl", NM="_ZN12_GLOBAL__N_19ASTViewer24HandleTopLevelSingleDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewer24HandleTopLevelSingleDeclEPN5clang4DeclE")
  //</editor-fold>
  public void HandleTopLevelSingleDecl(Decl /*P*/ D) {
    if (isa(FunctionDecl.class, D) || isa(ObjCMethodDecl.class, D)) {
      D.print(llvm.errs());
      {
        
        Stmt /*P*/ Body = D.getBody();
        if ((Body != null)) {
          llvm.errs().$out_char($$LF);
          Body.viewAST();
          llvm.errs().$out_char($$LF);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer::~ASTViewer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 146,
   FQN="(anonymous namespace)::ASTViewer::~ASTViewer", NM="_ZN12_GLOBAL__N_19ASTViewerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTViewer::ASTViewer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 146,
   FQN="(anonymous namespace)::ASTViewer::ASTViewer", NM="_ZN12_GLOBAL__N_19ASTViewerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_19ASTViewerC1Ev")
  //</editor-fold>
  public /*inline*/ ASTViewer() {
    // : ASTConsumer() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + super.toString(); // NOI18N
  }
}
