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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clank.support.Native.$noteq_ptr;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 80,
 FQN="(anonymous namespace)::EffectiveContext", NM="_ZN12_GLOBAL__N_116EffectiveContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_116EffectiveContextE")
//</editor-fold>
public class/*struct*/ EffectiveContext implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::EffectiveContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 81,
   FQN="(anonymous namespace)::EffectiveContext::EffectiveContext", NM="_ZN12_GLOBAL__N_116EffectiveContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_116EffectiveContextC1Ev")
  //</editor-fold>
  public EffectiveContext() {
    // : Inner(null), Functions(), Records(), Dependent(false) 
    //START JInit
    this.Inner = null;
    this.Functions = new SmallVector<FunctionDecl /*P*/ >(4, (FunctionDecl /*P*/ )null);
    this.Records = new SmallVector<CXXRecordDecl /*P*/ >(4, (CXXRecordDecl /*P*/ )null);
    this.Dependent = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::EffectiveContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 83,
   FQN="(anonymous namespace)::EffectiveContext::EffectiveContext", NM="_ZN12_GLOBAL__N_116EffectiveContextC1EPN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_116EffectiveContextC1EPN5clang11DeclContextE")
  //</editor-fold>
  public /*explicit*/ EffectiveContext(DeclContext /*P*/ DC) {
    // : Inner(DC), Functions(), Records(), Dependent(DC->isDependentContext()) 
    //START JInit
    this.Inner = DC;
    this.Functions = new SmallVector<FunctionDecl /*P*/ >(4, (FunctionDecl /*P*/ )null);
    this.Records = new SmallVector<CXXRecordDecl /*P*/ >(4, (CXXRecordDecl /*P*/ )null);
    this.Dependent = DC.isDependentContext();
    //END JInit
    
    // C++11 [class.access.nest]p1:
    //   A nested class is a member and as such has the same access
    //   rights as any other member.
    // C++11 [class.access]p2:
    //   A member of a class can also access all the names to which
    //   the class has access.  A local class of a member function
    //   may access the same names that the member function itself
    //   may access.
    // This almost implies that the privileges of nesting are transitive.
    // Technically it says nothing about the local classes of non-member
    // functions (which can gain privileges through friendship), but we
    // take that as an oversight.
    while (true) {
      // We want to add canonical declarations to the EC lists for
      // simplicity of checking, but we need to walk up through the
      // actual current DC chain.  Otherwise, something like a local
      // extern or friend which happens to be the canonical
      // declaration will really mess us up.
      if (isa(CXXRecordDecl.class, DC)) {
        CXXRecordDecl /*P*/ Record = cast(CXXRecordDecl.class, DC);
        Records.push_back(Record.getCanonicalDecl());
        DC = Record.getDeclContext();
      } else if (isa(FunctionDecl.class, DC)) {
        FunctionDecl /*P*/ Function = cast(FunctionDecl.class, DC);
        Functions.push_back(Function.getCanonicalDecl());
        if ((Function.getFriendObjectKind().getValue() != 0)) {
          DC = Function.getLexicalDeclContext();
        } else {
          DC = Function.getDeclContext();
        }
      } else if (DC.isFileContext()) {
        break;
      } else {
        DC = DC.getParent();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::isDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 125,
   FQN="(anonymous namespace)::EffectiveContext::isDependent", NM="_ZNK12_GLOBAL__N_116EffectiveContext11isDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_116EffectiveContext11isDependentEv")
  //</editor-fold>
  public boolean isDependent() /*const*/ {
    return Dependent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::includesClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 127,
   FQN="(anonymous namespace)::EffectiveContext::includesClass", NM="_ZNK12_GLOBAL__N_116EffectiveContext13includesClassEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_116EffectiveContext13includesClassEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public boolean includesClass(/*const*/ CXXRecordDecl /*P*/ R) /*const*/ {
    R = R.getCanonicalDecl$Const();
    return $noteq_ptr(std.find(Records.begin$Const(), Records.end$Const(), R, true), Records.end$Const());
  }

  
  /// Retrieves the innermost "useful" context.  Can be null if we're
  /// doing access-control without privileges.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::getInnerContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 135,
   FQN="(anonymous namespace)::EffectiveContext::getInnerContext", NM="_ZNK12_GLOBAL__N_116EffectiveContext15getInnerContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_116EffectiveContext15getInnerContextEv")
  //</editor-fold>
  public DeclContext /*P*/ getInnerContext() /*const*/ {
    return Inner;
  }

  
  /*typedef SmallVectorImpl<CXXRecordDecl *>::const_iterator record_iterator*/
//  public final class record_iterator extends type$ptr<CXXRecordDecl /*P*/ /*P*/>{ };
  
  public DeclContext /*P*/ Inner;
  public SmallVector<FunctionDecl /*P*/ > Functions;
  public SmallVector<CXXRecordDecl /*P*/ > Records;
  public boolean Dependent;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EffectiveContext::~EffectiveContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 80,
   FQN="(anonymous namespace)::EffectiveContext::~EffectiveContext", NM="_ZN12_GLOBAL__N_116EffectiveContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_116EffectiveContextD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Records.$destroy();
    Functions.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Inner=" + Inner // NOI18N
              + ", Functions=" + Functions // NOI18N
              + ", Records=" + Records // NOI18N
              + ", Dependent=" + Dependent; // NOI18N
  }
}
