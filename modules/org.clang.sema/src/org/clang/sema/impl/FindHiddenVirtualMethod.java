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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindHiddenVirtualMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6432,
 FQN="(anonymous namespace)::FindHiddenVirtualMethod", NM="_ZN12_GLOBAL__N_123FindHiddenVirtualMethodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123FindHiddenVirtualMethodE")
//</editor-fold>
public class/*struct*/ FindHiddenVirtualMethod implements Destructors.ClassWithDestructor, BaseMatchesCallback {
  public Sema /*P*/ S;
  public CXXMethodDecl /*P*/ Method;
  public SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > OverridenAndUsingBaseMethods;
  public SmallVector<CXXMethodDecl /*P*/ > OverloadedMethods;
/*private:*/
  /// Check whether any most overriden method from MD in Methods
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindHiddenVirtualMethod::CheckMostOverridenMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6440,
   FQN="(anonymous namespace)::FindHiddenVirtualMethod::CheckMostOverridenMethods", NM="_ZN12_GLOBAL__N_123FindHiddenVirtualMethod25CheckMostOverridenMethodsEPKN5clang13CXXMethodDeclERKN4llvm15SmallPtrSetImplIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123FindHiddenVirtualMethod25CheckMostOverridenMethodsEPKN5clang13CXXMethodDeclERKN4llvm15SmallPtrSetImplIS4_EE")
  //</editor-fold>
  private static boolean CheckMostOverridenMethods(/*const*/ CXXMethodDecl /*P*/ MD, 
                           final /*const*/ SmallPtrSetImpl</*const*/ CXXMethodDecl /*P*/ > /*&*/ Methods) {
    if (MD.size_overridden_methods() == 0) {
      return (Methods.count(MD.getCanonicalDecl$Const()) != 0);
    }
    for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods());
         $noteq_ptr(I, E); I.$preInc())  {
      if (CheckMostOverridenMethods(I.$star(), Methods)) {
        return true;
      }
    }
    return false;
  }

/*public:*/
  /// Member lookup function that determines whether a given C++
  /// method overloads virtual methods in a base class without overriding any,
  /// to be used with CXXRecordDecl::lookupInBases().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindHiddenVirtualMethod::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6457,
   FQN="(anonymous namespace)::FindHiddenVirtualMethod::operator()", NM="_ZN12_GLOBAL__N_123FindHiddenVirtualMethodclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123FindHiddenVirtualMethodclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE")
  //</editor-fold>
  public boolean $call(/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>getAs$RecordType().getDecl();
    
    DeclarationName Name = Method.getDeclName();
    assert (Name.getNameKind() == DeclarationName.NameKind.Identifier);
    
    boolean foundSameNameMethod = false;
    SmallVector<CXXMethodDecl /*P*/ > overloadedMethods/*J*/= new SmallVector<CXXMethodDecl /*P*/ >(8, (CXXMethodDecl /*P*/ )null);
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name))); !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      NamedDecl /*P*/ D = Path.Decls.front();
      {
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
        if ((MD != null)) {
          MD = MD.getCanonicalDecl();
          foundSameNameMethod = true;
          // Interested only in hidden virtual methods.
          if (!MD.isVirtual()) {
            continue;
          }
          // If the method we are checking overrides a method from its base
          // don't warn about the other overloaded methods. Clang deviates from
          // GCC by only diagnosing overloads of inherited virtual functions that
          // do not override any other virtual functions in the base. GCC's
          // -Woverloaded-virtual diagnoses any derived function hiding a virtual
          // function from a base class. These cases may be better served by a
          // warning (not specific to virtual functions) on call sites when the
          // call would select a different function from the base class, were it
          // visible.
          // See FIXME in test/SemaCXX/warn-overload-virtual.cpp for an example.
          if (!S.IsOverload(Method, MD, false)) {
            return true;
          }
          // Collect the overload only if its hidden.
          if (!CheckMostOverridenMethods(MD, OverridenAndUsingBaseMethods)) {
            overloadedMethods.push_back(MD);
          }
        }
      }
    }
    if (foundSameNameMethod) {
      OverloadedMethods.append_T(overloadedMethods.begin(), 
          overloadedMethods.end());
    }
    return foundSameNameMethod;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindHiddenVirtualMethod::FindHiddenVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6432,
   FQN="(anonymous namespace)::FindHiddenVirtualMethod::FindHiddenVirtualMethod", NM="_ZN12_GLOBAL__N_123FindHiddenVirtualMethodC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123FindHiddenVirtualMethodC1Ev")
  //</editor-fold>
  public /*inline*/ FindHiddenVirtualMethod() {
    // : OverridenAndUsingBaseMethods(), OverloadedMethods() 
    //START JInit
    this.OverridenAndUsingBaseMethods = new SmallPtrSet</*const*/ CXXMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.OverloadedMethods = new SmallVector<CXXMethodDecl /*P*/ >(8, (CXXMethodDecl /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindHiddenVirtualMethod::~FindHiddenVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6432,
   FQN="(anonymous namespace)::FindHiddenVirtualMethod::~FindHiddenVirtualMethod", NM="_ZN12_GLOBAL__N_123FindHiddenVirtualMethodD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123FindHiddenVirtualMethodD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OverloadedMethods.$destroy();
    OverridenAndUsingBaseMethods.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Method=" + Method // NOI18N
              + ", OverridenAndUsingBaseMethods=" + OverridenAndUsingBaseMethods // NOI18N
              + ", OverloadedMethods=" + OverloadedMethods; // NOI18N
  }
}
