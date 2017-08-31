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

package org.clang.ast.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.basic.*;
import org.clang.ast.*;


/// Implements C++ ABI-specific semantic analysis functions.
//<editor-fold defaultstate="collapsed" desc="clang::CXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 30,
 FQN="clang::CXXABI", NM="_ZN5clang6CXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABIE")
//</editor-fold>
public abstract class CXXABI implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::~CXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8712,
   FQN="clang::CXXABI::~CXXABI", NM="_ZN5clang6CXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABID0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Returns the width and alignment of a member pointer in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getMemberPointerWidthAndAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 35,
   FQN="clang::CXXABI::getMemberPointerWidthAndAlign", NM="_ZNK5clang6CXXABI29getMemberPointerWidthAndAlignEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang6CXXABI29getMemberPointerWidthAndAlignEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public abstract /*virtual*/ std.pairULongUInt getMemberPointerWidthAndAlign(/*const*/ MemberPointerType /*P*/ MPT) /*const*//* = 0*/;

  
  /// Returns the default calling convention for C++ methods.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getDefaultMethodCallConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 39,
   FQN="clang::CXXABI::getDefaultMethodCallConv", NM="_ZNK5clang6CXXABI24getDefaultMethodCallConvEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang6CXXABI24getDefaultMethodCallConvEb")
  //</editor-fold>
  public abstract /*virtual*/ CallingConv getDefaultMethodCallConv(boolean isVariadic) /*const*//* = 0*/;

  
  /// Returns whether the given class is nearly empty, with just virtual
  /// pointers and no data except possibly virtual bases.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::isNearlyEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 43,
   FQN="clang::CXXABI::isNearlyEmpty", NM="_ZNK5clang6CXXABI13isNearlyEmptyEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang6CXXABI13isNearlyEmptyEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ boolean isNearlyEmpty(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* = 0*/;

  
  /// Returns a new mangling number context for this C++ ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::createMangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 46,
   FQN="clang::CXXABI::createMangleNumberingContext", NM="_ZNK5clang6CXXABI28createMangleNumberingContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang6CXXABI28createMangleNumberingContextEv")
  //</editor-fold>
  public abstract /*virtual*/ MangleNumberingContext /*P*/ createMangleNumberingContext() /*const*//* = 0*/;

  
  /// Adds a mapping from class to copy constructor for this C++ ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::addCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 49,
   FQN="clang::CXXABI::addCopyConstructorForExceptionObject", NM="_ZN5clang6CXXABI36addCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI36addCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void addCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ $Prm0, 
                                      CXXConstructorDecl /*P*/ $Prm1)/* = 0*/;

  
  /// Retrieves the mapping from class to copy constructor for this C++ ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 53,
   FQN="clang::CXXABI::getCopyConstructorForExceptionObject", NM="_ZN5clang6CXXABI36getCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI36getCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ CXXConstructorDecl /*P*/ getCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ $Prm0)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::addDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 56,
   FQN="clang::CXXABI::addDefaultArgExprForConstructor", NM="_ZN5clang6CXXABI31addDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI31addDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEjPNS_4ExprE")
  //</editor-fold>
  public abstract /*virtual*/ void addDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx, Expr /*P*/ DAE)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 59,
   FQN="clang::CXXABI::getDefaultArgExprForConstructor", NM="_ZN5clang6CXXABI31getDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI31getDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEj")
  //</editor-fold>
  public abstract /*virtual*/ Expr /*P*/ getDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::addTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 62,
   FQN="clang::CXXABI::addTypedefNameForUnnamedTagDecl", NM="_ZN5clang6CXXABI31addTypedefNameForUnnamedTagDeclEPNS_7TagDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI31addTypedefNameForUnnamedTagDeclEPNS_7TagDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void addTypedefNameForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                 TypedefNameDecl /*P*/ DD)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 65,
   FQN="clang::CXXABI::getTypedefNameForUnnamedTagDecl", NM="_ZN5clang6CXXABI31getTypedefNameForUnnamedTagDeclEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI31getTypedefNameForUnnamedTagDeclEPKNS_7TagDeclE")
  //</editor-fold>
  public abstract /*virtual*/ TypedefNameDecl /*P*/ getTypedefNameForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::addDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 68,
   FQN="clang::CXXABI::addDeclaratorForUnnamedTagDecl", NM="_ZN5clang6CXXABI30addDeclaratorForUnnamedTagDeclEPNS_7TagDeclEPNS_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI30addDeclaratorForUnnamedTagDeclEPNS_7TagDeclEPNS_14DeclaratorDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void addDeclaratorForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                DeclaratorDecl /*P*/ DD)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::getDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 71,
   FQN="clang::CXXABI::getDeclaratorForUnnamedTagDecl", NM="_ZN5clang6CXXABI30getDeclaratorForUnnamedTagDeclEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang6CXXABI30getDeclaratorForUnnamedTagDeclEPKNS_7TagDeclE")
  //</editor-fold>
  public abstract /*virtual*/ DeclaratorDecl /*P*/ getDeclaratorForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* = 0*/;


  //<editor-fold defaultstate="collapsed" desc="clang::CXXABI::CXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXABI.h", line = 30,
   FQN="clang::CXXABI::CXXABI", NM="_ZN5clang6CXXABIC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN5clang6CXXABIC1Ev")
  //</editor-fold>
  public /*inline*/ CXXABI() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
