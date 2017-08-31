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
import org.llvm.adt.*;


/// \brief Keeps track of the mangled names of lambda expressions and block
/// literals within a particular context.
//<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 33,
 FQN="clang::MangleNumberingContext", NM="_ZN5clang22MangleNumberingContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContextE")
//</editor-fold>
public abstract class MangleNumberingContext extends /*public*/ RefCountedBase<MangleNumberingContext> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::~MangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 35,
   FQN="clang::MangleNumberingContext::~MangleNumberingContext", NM="_ZN5clang22MangleNumberingContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContextD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    super.$destroy();
  }

  
  /// \brief Retrieve the mangling number of a new lambda expression with the
  /// given call operator within this context.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 39,
   FQN="clang::MangleNumberingContext::getManglingNumber", NM="_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getManglingNumber(/*const*/ CXXMethodDecl /*P*/ CallOperator)/* = 0*/;

  
  /// \brief Retrieve the mangling number of a new block literal within this
  /// context.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 43,
   FQN="clang::MangleNumberingContext::getManglingNumber", NM="_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_9BlockDeclE")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getManglingNumber(/*const*/ BlockDecl /*P*/ BD)/* = 0*/;

  
  /// Static locals are numbered by source order.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::getStaticLocalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 46,
   FQN="clang::MangleNumberingContext::getStaticLocalNumber", NM="_ZN5clang22MangleNumberingContext20getStaticLocalNumberEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContext20getStaticLocalNumberEPKNS_7VarDeclE")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getStaticLocalNumber(/*const*/ VarDecl /*P*/ VD)/* = 0*/;

  
  /// \brief Retrieve the mangling number of a static local variable within
  /// this context.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 50,
   FQN="clang::MangleNumberingContext::getManglingNumber", NM="_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_7VarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_7VarDeclEj")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getManglingNumber(/*const*/ VarDecl /*P*/ VD, 
                   /*uint*/int MSLocalManglingNumber)/* = 0*/;

  
  /// \brief Retrieve the mangling number of a static local variable within
  /// this context.
  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 55,
   FQN="clang::MangleNumberingContext::getManglingNumber", NM="_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_7TagDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContext17getManglingNumberEPKNS_7TagDeclEj")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getManglingNumber(/*const*/ TagDecl /*P*/ TD, 
                   /*uint*/int MSLocalManglingNumber)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MangleNumberingContext::MangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/MangleNumberingContext.h", line = 33,
   FQN="clang::MangleNumberingContext::MangleNumberingContext", NM="_ZN5clang22MangleNumberingContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang22MangleNumberingContextC1Ev")
  //</editor-fold>
  public /*inline*/ MangleNumberingContext() {
    // : RefCountedBase<MangleNumberingContext>() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
