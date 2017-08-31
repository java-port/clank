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
import org.clang.basic.*;


/// Pseudo declaration for capturing expressions. Also is used for capturing of
/// non-static data members in non-static member functions.
///
/// Clang supports capturing of variables only, but OpenMP 4.5 allows to
/// privatize non-static members of current class in non-static member
/// functions. This pseudo-declaration allows properly handle this kind of
/// capture by wrapping captured expression into a variable-like declaration.
//<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 171,
 FQN="clang::OMPCapturedExprDecl", NM="_ZN5clang19OMPCapturedExprDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDeclE")
//</editor-fold>
public final class OMPCapturedExprDecl extends /*public*/ VarDecl implements Destructors.ClassWithDestructor {
  /*friend  class ASTDeclReader*/
  
  //===----------------------------------------------------------------------===//
  // OMPCapturedExprDecl Implementation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 90,
   FQN="clang::OMPCapturedExprDecl::anchor", NM="_ZN5clang19OMPCapturedExprDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::OMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 175,
   FQN="clang::OMPCapturedExprDecl::OMPCapturedExprDecl", NM="_ZN5clang19OMPCapturedExprDeclC1ERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDeclC1ERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_8QualTypeE")
  //</editor-fold>
  private OMPCapturedExprDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, IdentifierInfo /*P*/ Id, 
      QualType Type) {
    // : VarDecl(OMPCapturedExpr, C, DC, SourceLocation(), SourceLocation(), Id, Type, null, SC_None) 
    //START JInit
    super(Kind.OMPCapturedExpr, C, DC, new SourceLocation(), new SourceLocation(), Id, 
        new QualType(Type), (TypeSourceInfo /*P*/ )null, StorageClass.SC_None);
    //END JInit
    setImplicit();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 92,
   FQN="clang::OMPCapturedExprDecl::Create", NM="_ZN5clang19OMPCapturedExprDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoENS_8QualTypeE")
  //</editor-fold>
  public static OMPCapturedExprDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        IdentifierInfo /*P*/ Id, 
        QualType T) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new OMPCapturedExprDecl(C, DC, Id, new QualType(T));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 98,
   FQN="clang::OMPCapturedExprDecl::CreateDeserialized", NM="_ZN5clang19OMPCapturedExprDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static OMPCapturedExprDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new OMPCapturedExprDecl(C, (DeclContext /*P*/ )null, (IdentifierInfo /*P*/ )null, new QualType());
     });
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 189,
   FQN="clang::OMPCapturedExprDecl::classof", NM="_ZN5clang19OMPCapturedExprDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 190,
   FQN="clang::OMPCapturedExprDecl::classofKind", NM="_ZN5clang19OMPCapturedExprDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.OMPCapturedExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCapturedExprDecl::~OMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 171,
   FQN="clang::OMPCapturedExprDecl::~OMPCapturedExprDecl", NM="_ZN5clang19OMPCapturedExprDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang19OMPCapturedExprDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
