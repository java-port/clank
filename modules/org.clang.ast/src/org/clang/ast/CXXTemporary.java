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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clang.ast.ASTContextGlobals.*;


/// \brief Represents a C++ temporary.
//<editor-fold defaultstate="collapsed" desc="clang::CXXTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1088,
 FQN="clang::CXXTemporary", NM="_ZN5clang12CXXTemporaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXTemporaryE")
//</editor-fold>
public class CXXTemporary {
  /// \brief The destructor that needs to be called.
  private /*const*/ CXXDestructorDecl /*P*/ Destructor;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporary::CXXTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1092,
   FQN="clang::CXXTemporary::CXXTemporary", NM="_ZN5clang12CXXTemporaryC1EPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXTemporaryC1EPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  private /*explicit*/ CXXTemporary(/*const*/ CXXDestructorDecl /*P*/ destructor) {
    // : Destructor(destructor) 
    //START JInit
    this.Destructor = destructor;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporary::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 704,
   FQN="clang::CXXTemporary::Create", NM="_ZN5clang12CXXTemporary6CreateERKNS_10ASTContextEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXTemporary6CreateERKNS_10ASTContextEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public static CXXTemporary /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        /*const*/ CXXDestructorDecl /*P*/ Destructor) {
    return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (C)*/ $new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new CXXTemporary(Destructor);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporary::getDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1099,
   FQN="clang::CXXTemporary::getDestructor", NM="_ZNK5clang12CXXTemporary13getDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXTemporary13getDestructorEv")
  //</editor-fold>
  public /*const*/ CXXDestructorDecl /*P*/ getDestructor() /*const*/ {
    return Destructor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTemporary::setDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1100,
   FQN="clang::CXXTemporary::setDestructor", NM="_ZN5clang12CXXTemporary13setDestructorEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXTemporary13setDestructorEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public void setDestructor(/*const*/ CXXDestructorDecl /*P*/ Dtor) {
    Destructor = Dtor;
  }

  
  @Override public String toString() {
    return "" + "Destructor=" + Destructor; // NOI18N
  }
}
