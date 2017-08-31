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


/// TypeAliasDecl - Represents the declaration of a typedef-name via a C++0x
/// alias-declaration.
//<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2701,
 FQN="clang::TypeAliasDecl", NM="_ZN5clang13TypeAliasDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDeclE")
//</editor-fold>
public class TypeAliasDecl extends /*public*/ TypedefNameDecl implements Destructors.ClassWithDestructor {
  /// The template for which this is the pattern, if any.
  private TypeAliasTemplateDecl /*P*/ Template;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::TypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2705,
   FQN="clang::TypeAliasDecl::TypeAliasDecl", NM="_ZN5clang13TypeAliasDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  private TypeAliasDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, TypeSourceInfo /*P*/ TInfo) {
    // : TypedefNameDecl(TypeAlias, C, DC, StartLoc, IdLoc, Id, TInfo), Template(null) 
    //START JInit
    super(Kind.TypeAlias, C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, TInfo);
    this.Template = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4157,
   FQN="clang::TypeAliasDecl::Create", NM="_ZN5clang13TypeAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public static TypeAliasDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        TypeSourceInfo /*P*/ TInfo) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new TypeAliasDecl(C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, TInfo);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4164,
   FQN="clang::TypeAliasDecl::CreateDeserialized", NM="_ZN5clang13TypeAliasDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static TypeAliasDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new TypeAliasDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, (TypeSourceInfo /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4178,
   FQN="clang::TypeAliasDecl::getSourceRange", NM="_ZNK5clang13TypeAliasDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang13TypeAliasDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation RangeEnd = getLocStart();
    {
      TypeSourceInfo /*P*/ TInfo = getTypeSourceInfo();
      if ((TInfo != null)) {
        RangeEnd.$assignMove(TInfo.getTypeLoc().getSourceRange().getEnd());
      }
    }
    return new SourceRange(getLocStart(), /*NO_COPY*/RangeEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::getDescribedAliasTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2718,
   FQN="clang::TypeAliasDecl::getDescribedAliasTemplate", NM="_ZNK5clang13TypeAliasDecl25getDescribedAliasTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang13TypeAliasDecl25getDescribedAliasTemplateEv")
  //</editor-fold>
  public TypeAliasTemplateDecl /*P*/ getDescribedAliasTemplate() /*const*/ {
    return Template;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::setDescribedAliasTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2719,
   FQN="clang::TypeAliasDecl::setDescribedAliasTemplate", NM="_ZN5clang13TypeAliasDecl25setDescribedAliasTemplateEPNS_21TypeAliasTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDecl25setDescribedAliasTemplateEPNS_21TypeAliasTemplateDeclE")
  //</editor-fold>
  public void setDescribedAliasTemplate(TypeAliasTemplateDecl /*P*/ TAT) {
    Template = TAT;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2722,
   FQN="clang::TypeAliasDecl::classof", NM="_ZN5clang13TypeAliasDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2723,
   FQN="clang::TypeAliasDecl::classofKind", NM="_ZN5clang13TypeAliasDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.TypeAlias;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasDecl::~TypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2701,
   FQN="clang::TypeAliasDecl::~TypeAliasDecl", NM="_ZN5clang13TypeAliasDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang13TypeAliasDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Template=" + Template // NOI18N
              + super.toString(); // NOI18N
  }
}
