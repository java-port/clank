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
import static org.clang.ast.impl.DeclTemplateStatics.*;


/// \brief Represents the builtin template declaration which is used to
/// implement __make_integer_seq and other builtin templates.  It serves
/// no real purpose beyond existing as a place to hold template parameters.
//<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1490,
 FQN="clang::BuiltinTemplateDecl", NM="_ZN5clang19BuiltinTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDeclE")
//</editor-fold>
public class BuiltinTemplateDecl extends /*public*/ TemplateDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1233,
   FQN="clang::BuiltinTemplateDecl::anchor", NM="_ZN5clang19BuiltinTemplateDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::BuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1235,
   FQN="clang::BuiltinTemplateDecl::BuiltinTemplateDecl", NM="_ZN5clang19BuiltinTemplateDeclC1ERKNS_10ASTContextEPNS_11DeclContextENS_15DeclarationNameENS_19BuiltinTemplateKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDeclC1ERKNS_10ASTContextEPNS_11DeclContextENS_15DeclarationNameENS_19BuiltinTemplateKindE")
  //</editor-fold>
  private BuiltinTemplateDecl(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      DeclarationName Name, 
      BuiltinTemplateKind BTK) {
    // : TemplateDecl(BuiltinTemplate, DC, SourceLocation(), Name, createBuiltinTemplateParameterList(C, DC, BTK)), BTK(BTK) 
    //START JInit
    super(Kind.BuiltinTemplate, DC, new SourceLocation(), new DeclarationName(Name), 
        createBuiltinTemplateParameterList(C, DC, BTK));
    this.BTK = BTK;
    //END JInit
  }

  
  private BuiltinTemplateKind BTK;
/*public:*/
  // Implement isa/cast/dyncast support
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1500,
   FQN="clang::BuiltinTemplateDecl::classof", NM="_ZN5clang19BuiltinTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1501,
   FQN="clang::BuiltinTemplateDecl::classofKind", NM="_ZN5clang19BuiltinTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.BuiltinTemplate;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1503,
   FQN="clang::BuiltinTemplateDecl::Create", NM="_ZN5clang19BuiltinTemplateDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_15DeclarationNameENS_19BuiltinTemplateKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_15DeclarationNameENS_19BuiltinTemplateKindE")
  //</editor-fold>
  public static BuiltinTemplateDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        DeclarationName Name, 
        BuiltinTemplateKind BTK) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new BuiltinTemplateDecl(C, DC, new DeclarationName(Name), BTK);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1509,
   FQN="clang::BuiltinTemplateDecl::getSourceRange", NM="_ZNK5clang19BuiltinTemplateDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang19BuiltinTemplateDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::getBuiltinTemplateKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1513,
   FQN="clang::BuiltinTemplateDecl::getBuiltinTemplateKind", NM="_ZNK5clang19BuiltinTemplateDecl22getBuiltinTemplateKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang19BuiltinTemplateDecl22getBuiltinTemplateKindEv")
  //</editor-fold>
  public BuiltinTemplateKind getBuiltinTemplateKind() /*const*/ {
    return BTK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTemplateDecl::~BuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1490,
   FQN="clang::BuiltinTemplateDecl::~BuiltinTemplateDecl", NM="_ZN5clang19BuiltinTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang19BuiltinTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "BTK=" + BTK // NOI18N
              + super.toString(); // NOI18N
  }
}
