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
import org.clang.ast.DeclContext.*;


/// TranslationUnitDecl - The top declaration context.
//<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 80,
 FQN="clang::TranslationUnitDecl", NM="_ZN5clang19TranslationUnitDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDeclE")
//</editor-fold>
public class TranslationUnitDecl extends /*public*/ Decl implements /*public*/ DeclContext, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // Other Decl Allocation/Deallocation Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3918,
   FQN="clang::TranslationUnitDecl::anchor", NM="_ZN5clang19TranslationUnitDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private final ASTContext /*&*/ Ctx;
  
  /// The (most recently entered) anonymous namespace for this
  /// translation unit, if one has been created.
  private NamespaceDecl /*P*/ AnonymousNamespace;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::TranslationUnitDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*keep $DeclContext$Fields in field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 48,
   FQN="clang::TranslationUnitDecl::TranslationUnitDecl", NM="_ZN5clang19TranslationUnitDeclC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDeclC1ERNS_10ASTContextE")
  //</editor-fold>
  private TranslationUnitDecl(final ASTContext /*&*/ ctx) {
    // : Decl(TranslationUnit, null, SourceLocation()), DeclContext(TranslationUnit), Ctx(ctx), AnonymousNamespace(null) 
    //START JInit
    super(Kind.TranslationUnit, (DeclContext /*P*/ )null, new SourceLocation());
    this.DeclContext$FieldsImpl = $DeclContext(Kind.TranslationUnit);
    this./*&*/Ctx=/*&*/ctx;
    this.AnonymousNamespace = null;
    //END JInit
    Hidden = Ctx.getLangOpts().ModulesLocalVisibility;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 90,
   FQN="clang::TranslationUnitDecl::getASTContext", NM="_ZNK5clang19TranslationUnitDecl13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang19TranslationUnitDecl13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*/ {
    return Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::getAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 92,
   FQN="clang::TranslationUnitDecl::getAnonymousNamespace", NM="_ZNK5clang19TranslationUnitDecl21getAnonymousNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang19TranslationUnitDecl21getAnonymousNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getAnonymousNamespace() /*const*/ {
    return AnonymousNamespace;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::setAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 93,
   FQN="clang::TranslationUnitDecl::setAnonymousNamespace", NM="_ZN5clang19TranslationUnitDecl21setAnonymousNamespaceEPNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl21setAnonymousNamespaceEPNS_13NamespaceDeclE")
  //</editor-fold>
  public void setAnonymousNamespace(NamespaceDecl /*P*/ D) {
    AnonymousNamespace = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3920,
   FQN="clang::TranslationUnitDecl::Create", NM="_ZN5clang19TranslationUnitDecl6CreateERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl6CreateERNS_10ASTContextE")
  //</editor-fold>
  public static TranslationUnitDecl /*P*/ Create(final ASTContext /*&*/ C) {
    return /*NEW_EXPR [Decl::new]*//*new (C, (DeclContext *)null)*/ Decl.$new(C, (DeclContext /*P*/ )null, (type$ptr<?> Mem)->{
        return new TranslationUnitDecl(C);
     });
  }

  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 97,
   FQN="clang::TranslationUnitDecl::classof", NM="_ZN5clang19TranslationUnitDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 98,
   FQN="clang::TranslationUnitDecl::classofKind", NM="_ZN5clang19TranslationUnitDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.TranslationUnit;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 99,
   FQN="clang::TranslationUnitDecl::castToDeclContext", NM="_ZN5clang19TranslationUnitDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ TranslationUnitDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/TranslationUnitDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 102,
   FQN="clang::TranslationUnitDecl::castFromDeclContext", NM="_ZN5clang19TranslationUnitDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static TranslationUnitDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/TranslationUnitDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TranslationUnitDecl::~TranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 80,
   FQN="clang::TranslationUnitDecl::~TranslationUnitDecl", NM="_ZN5clang19TranslationUnitDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang19TranslationUnitDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final DeclContext$Fields DeclContext$FieldsImpl;
  @Override public DeclContext$Fields $DeclContext$Fields() { return DeclContext$FieldsImpl; }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return " As$TU{" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", AnonymousNamespace=" + AnonymousNamespace + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}
