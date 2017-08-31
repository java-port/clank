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


/// \brief Represents a template name that was expressed as a
/// qualified name.
///
/// This kind of template name refers to a template name that was
/// preceded by a nested name specifier, e.g., \c std::vector. Here,
/// the nested name specifier is "std::" and the template name is the
/// declaration for "vector". The QualifiedTemplateName class is only
/// used to provide "sugar" for template names that were expressed
/// with a qualified name, and has no semantic meaning. In this
/// manner, it is to TemplateName what ElaboratedType is to Type,
/// providing extra syntactic sugar for downstream clients.
//<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 355,
 FQN="clang::QualifiedTemplateName", NM="_ZN5clang21QualifiedTemplateNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21QualifiedTemplateNameE")
//</editor-fold>
public class QualifiedTemplateName extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {

  /// \brief The nested name specifier that qualifies the template name.
  ///
  /// The bit is used to indicate whether the "template" keyword was
  /// present before the template name itself. Note that the
  /// "template" keyword is always redundant in this case (otherwise,
  /// the template name would be a dependent name and we would express
  /// this name with DependentTemplateName).
  private PointerIntPair<NestedNameSpecifier /*P*/ > Qualifier;
  
  /// \brief The template declaration or set of overloaded function templates
  /// that this qualified name refers to.
  private TemplateDecl /*P*/ Template;
  
  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::QualifiedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 371,
   FQN="clang::QualifiedTemplateName::QualifiedTemplateName", NM="_ZN5clang21QualifiedTemplateNameC1EPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21QualifiedTemplateNameC1EPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE")
  //</editor-fold>
  /*friend*//*package*/ QualifiedTemplateName(NestedNameSpecifier /*P*/ NNS, boolean TemplateKeyword, 
      TemplateDecl /*P*/ Template) {
    // : FoldingSetNode(), Qualifier(NNS, TemplateKeyword ? 1 : 0), Template(Template) 
    //START JInit
    $Node();
    this.Qualifier = new PointerIntPair<NestedNameSpecifier /*P*/ >(NNS, TemplateKeyword ? 1 : 0);
    this.Template = Template;
    //END JInit
  }

/*public:*/
  /// \brief Return the nested name specifier that qualifies this name.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 378,
   FQN="clang::QualifiedTemplateName::getQualifier", NM="_ZNK5clang21QualifiedTemplateName12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21QualifiedTemplateName12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return Qualifier.getPointer();
  }

  
  /// \brief Whether the template name was prefixed by the "template"
  /// keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 382,
   FQN="clang::QualifiedTemplateName::hasTemplateKeyword", NM="_ZNK5clang21QualifiedTemplateName18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21QualifiedTemplateName18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return (Qualifier.getInt() != 0);
  }

  
  /// \brief The template declaration that this qualified name refers
  /// to.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 386,
   FQN="clang::QualifiedTemplateName::getDecl", NM="_ZNK5clang21QualifiedTemplateName7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21QualifiedTemplateName7getDeclEv")
  //</editor-fold>
  public TemplateDecl /*P*/ getDecl() /*const*/ {
    return Template;
  }

  
  /// \brief The template declaration to which this qualified name
  /// refers.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::getTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 390,
   FQN="clang::QualifiedTemplateName::getTemplateDecl", NM="_ZNK5clang21QualifiedTemplateName15getTemplateDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21QualifiedTemplateName15getTemplateDeclEv")
  //</editor-fold>
  public TemplateDecl /*P*/ getTemplateDecl() /*const*/ {
    return Template;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 392,
   FQN="clang::QualifiedTemplateName::Profile", NM="_ZN5clang21QualifiedTemplateName7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21QualifiedTemplateName7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getQualifier(), hasTemplateKeyword(), getTemplateDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 396,
   FQN="clang::QualifiedTemplateName::Profile", NM="_ZN5clang21QualifiedTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21QualifiedTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, NestedNameSpecifier /*P*/ NNS, 
         boolean TemplateKeyword, TemplateDecl /*P*/ Template) {
    ID.AddPointer(NNS);
    ID.AddBoolean(TemplateKeyword);
    ID.AddPointer(Template);
  }

  
  @Override public String toString() {
    return "" + "Qualifier=" + Qualifier // NOI18N
              + ", Template=" + Template // NOI18N
              + super.toString(); // NOI18N
  }
}
