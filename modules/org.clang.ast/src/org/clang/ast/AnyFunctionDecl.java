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
import org.clank.support.JavaDifferentiators.*;


/// \brief Represents any kind of function declaration, whether it is a
/// concrete function or a function template.
//<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 50,
 FQN="clang::AnyFunctionDecl", NM="_ZN5clang15AnyFunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDeclE")
//</editor-fold>
public class AnyFunctionDecl {
  private NamedDecl /*P*/ Function;
  
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::AnyFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 53,
   FQN="clang::AnyFunctionDecl::AnyFunctionDecl", NM="_ZN5clang15AnyFunctionDeclC1EPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDeclC1EPNS_9NamedDeclE")
  //</editor-fold>
  private AnyFunctionDecl(NamedDecl /*P*/ ND) {
    // : Function(ND) 
    //START JInit
    this.Function = ND;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::AnyFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 56,
   FQN="clang::AnyFunctionDecl::AnyFunctionDecl", NM="_ZN5clang15AnyFunctionDeclC1EPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDeclC1EPNS_12FunctionDeclE")
  //</editor-fold>
  public AnyFunctionDecl(FunctionDecl /*P*/ FD) {
    // : Function(FD) 
    //START JInit
    this.Function = FD;
    //END JInit
  }

  
  /// Implementation of inline functions that require the template declarations
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::AnyFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2358,
   FQN="clang::AnyFunctionDecl::AnyFunctionDecl", NM="_ZN5clang15AnyFunctionDeclC1EPNS_20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDeclC1EPNS_20FunctionTemplateDeclE")
  //</editor-fold>
  public /*inline*/ AnyFunctionDecl(FunctionTemplateDecl /*P*/ FTD) {
    // : Function(FTD) 
    //START JInit
    this.Function = FTD;
    //END JInit
  }

  
  /// \brief Implicily converts any function or function template into a
  /// named declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::operator NamedDecl * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 61,
   FQN="clang::AnyFunctionDecl::operator NamedDecl * ", NM="_ZNK5clang15AnyFunctionDeclcvPNS_9NamedDeclEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15AnyFunctionDeclcvPNS_9NamedDeclEEv")
  //</editor-fold>
  public NamedDecl /*P*/ $NamedDecl$P() /*const*/ {
    return Function;
  }

  
  /// \brief Retrieve the underlying function or function template.
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 64,
   FQN="clang::AnyFunctionDecl::get", NM="_ZNK5clang15AnyFunctionDecl3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15AnyFunctionDecl3getEv")
  //</editor-fold>
  public NamedDecl /*P*/ get() /*const*/ {
    return Function;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::getFromNamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 66,
   FQN="clang::AnyFunctionDecl::getFromNamedDecl", NM="_ZN5clang15AnyFunctionDecl16getFromNamedDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDecl16getFromNamedDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public static AnyFunctionDecl getFromNamedDecl(NamedDecl /*P*/ ND) {
    return new AnyFunctionDecl(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnyFunctionDecl::AnyFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 50,
   FQN="clang::AnyFunctionDecl::AnyFunctionDecl", NM="_ZN5clang15AnyFunctionDeclC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15AnyFunctionDeclC1EOS0_")
  //</editor-fold>
  public /*inline*/ AnyFunctionDecl(JD$Move _dparam, final AnyFunctionDecl /*&&*/$Prm0) {
    // : Function(static_cast<AnyFunctionDecl &&>().Function) 
    //START JInit
    this.Function = $Prm0.Function;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Function=" + Function; // NOI18N
  }
}
