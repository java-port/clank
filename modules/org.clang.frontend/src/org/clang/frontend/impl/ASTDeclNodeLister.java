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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 103,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 102,
 FQN="(anonymous namespace)::ASTDeclNodeLister", NM="_ZN12_GLOBAL__N_117ASTDeclNodeListerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_117ASTDeclNodeListerE")
//</editor-fold>
public class ASTDeclNodeLister extends /*public*/ ASTConsumer implements /*public*/ RecursiveASTVisitor<ASTDeclNodeLister>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister::ASTDeclNodeLister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 105,
   FQN="(anonymous namespace)::ASTDeclNodeLister::ASTDeclNodeLister", NM="_ZN12_GLOBAL__N_117ASTDeclNodeListerC1EPN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_117ASTDeclNodeListerC1EPN4llvm11raw_ostreamE")
  //</editor-fold>
  public ASTDeclNodeLister() {
    this((raw_ostream /*P*/ )null);
  }
  public ASTDeclNodeLister(raw_ostream /*P*/ Out/*= null*/) {
    // : ASTConsumer(), RecursiveASTVisitor<ASTDeclNodeLister>(), Out(Out ? *Out : llvm::outs()) 
    //START JInit
    super();
    $RecursiveASTVisitor();
    this./*&*/Out=/*&*/(Out != null) ? /*Deref*/Out : llvm.outs();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 108,
   FQN="(anonymous namespace)::ASTDeclNodeLister::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_117ASTDeclNodeLister21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_117ASTDeclNodeLister21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Context)/* override*/ {
    TraverseDecl(Context.getTranslationUnitDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 112,
   FQN="(anonymous namespace)::ASTDeclNodeLister::shouldWalkTypesOfTypeLocs", NM="_ZNK12_GLOBAL__N_117ASTDeclNodeLister25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZNK12_GLOBAL__N_117ASTDeclNodeLister25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister::VisitNamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 114,
   FQN="(anonymous namespace)::ASTDeclNodeLister::VisitNamedDecl", NM="_ZN12_GLOBAL__N_117ASTDeclNodeLister14VisitNamedDeclEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_117ASTDeclNodeLister14VisitNamedDeclEPN5clang9NamedDeclE")
  //</editor-fold>
  public boolean VisitNamedDecl(NamedDecl /*P*/ D) {
    D.printQualifiedName(Out);
    Out.$out_char($$LF);
    return true;
  }

/*private:*/
  private raw_ostream /*&*/ Out;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDeclNodeLister::~ASTDeclNodeLister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 102,
   FQN="(anonymous namespace)::ASTDeclNodeLister::~ASTDeclNodeLister", NM="_ZN12_GLOBAL__N_117ASTDeclNodeListerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_117ASTDeclNodeListerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    //~RecursiveASTVisitor<ASTDeclNodeLister>;
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + super.toString(); // NOI18N
  }
}
