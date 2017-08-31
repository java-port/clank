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
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindOverriddenMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7002,
 FQN="(anonymous namespace)::FindOverriddenMethod", NM="_ZN12_GLOBAL__N_120FindOverriddenMethodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120FindOverriddenMethodE")
//</editor-fold>
public class/*struct*/ FindOverriddenMethod implements BaseMatchesCallback {
  public Sema /*P*/ S;
  public CXXMethodDecl /*P*/ Method;
  
  /// Member lookup function that determines whether a given C++
  /// method overrides a method in a base class, to be used with
  /// CXXRecordDecl::lookupInBases().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindOverriddenMethod::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7009,
   FQN="(anonymous namespace)::FindOverriddenMethod::operator()", NM="_ZN12_GLOBAL__N_120FindOverriddenMethodclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120FindOverriddenMethodclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE")
  //</editor-fold>
  public boolean $call(/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>getAs$RecordType().getDecl();
    
    DeclarationName Name = Method.getDeclName();
    
    // FIXME: Do we care about other names here too?
    if (Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName) {
      // We really want to find the base class destructor here.
      QualType T = S.Context.getTypeDeclType(BaseRecord);
      CanQual<Type> CT = S.Context.getCanonicalType(new QualType(T));
      
      Name.$assignMove(S.Context.DeclarationNames.getCXXDestructorName(new CanQual<Type>(CT)));
    }
    
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name))); !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      NamedDecl /*P*/ D = Path.Decls.front();
      {
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
        if ((MD != null)) {
          if (MD.isVirtual() && !S.IsOverload(Method, MD, false)) {
            return true;
          }
        }
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindOverriddenMethod::FindOverriddenMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7002,
   FQN="(anonymous namespace)::FindOverriddenMethod::FindOverriddenMethod", NM="_ZN12_GLOBAL__N_120FindOverriddenMethodC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120FindOverriddenMethodC1Ev")
  //</editor-fold>
  public /*inline*/ FindOverriddenMethod() {
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Method=" + Method; // NOI18N
  }
}
