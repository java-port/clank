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
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Marks all typedefs in all local classes in a type referenced.
///
/// In a function like
/// auto f() {
///   struct S { typedef int a; };
///   return S();
/// }
///
/// the local type escapes and could be referenced in some TUs but not in
/// others. Pretend that all local typedefs are always referenced, to not warn
/// on this. This isn't necessary if f has internal linkage, or the typedef
/// is private.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalTypedefNameReferencer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3031,
 FQN="(anonymous namespace)::LocalTypedefNameReferencer", NM="_ZN12_GLOBAL__N_126LocalTypedefNameReferencerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_126LocalTypedefNameReferencerE")
//</editor-fold>
public class LocalTypedefNameReferencer implements /*public*/ RecursiveASTVisitor<LocalTypedefNameReferencer> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalTypedefNameReferencer::LocalTypedefNameReferencer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3034,
   FQN="(anonymous namespace)::LocalTypedefNameReferencer::LocalTypedefNameReferencer", NM="_ZN12_GLOBAL__N_126LocalTypedefNameReferencerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_126LocalTypedefNameReferencerC1ERN5clang4SemaE")
  //</editor-fold>
  public LocalTypedefNameReferencer(final Sema /*&*/ S) {
    // : RecursiveASTVisitor<LocalTypedefNameReferencer>(), S(S) 
    //START JInit
    $RecursiveASTVisitor();
    this./*&*/S=/*&*/S;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalTypedefNameReferencer::VisitRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3039,
   FQN="(anonymous namespace)::LocalTypedefNameReferencer::VisitRecordType", NM="_ZN12_GLOBAL__N_126LocalTypedefNameReferencer15VisitRecordTypeEPKN5clang10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_126LocalTypedefNameReferencer15VisitRecordTypeEPKN5clang10RecordTypeE")
  //</editor-fold>
  public boolean VisitRecordType(/*const*/ RecordType /*P*/ RT) {
    CXXRecordDecl /*P*/ R = dyn_cast_CXXRecordDecl(RT.getDecl());
    if (!(R != null) || !(R.isLocalClass() != null) || !R.isLocalClass().isExternallyVisible()
       || R.isDependentType()) {
      return true;
    }
    for (Decl /*P*/ TmpD : R.decls())  {
      {
        TypedefNameDecl /*P*/ T = dyn_cast_TypedefNameDecl(TmpD);
        if ((T != null)) {
          if (T.getAccess() != AccessSpecifier.AS_private || R.hasFriends()) {
            S.MarkAnyDeclReferenced(T.getLocation(), T, /*OdrUse=*/ false);
          }
        }
      }
    }
    return true;
  }

/*private:*/
  private final Sema /*&*/ S;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + super.toString(); // NOI18N
  }
}
