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
import static org.llvm.adt.ADTAliases.*;
import org.clang.basic.*;


//===----------------------------------------------------------------------===//
// Kinds of Templates
//===----------------------------------------------------------------------===//

/// \brief The base class of all kinds of template declarations (e.g.,
/// class, function, etc.).
///
/// The TemplateDecl class stores the list of template parameters and a
/// reference to the templated scoped declaration: the underlying AST node.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 330,
 FQN="clang::TemplateDecl", NM="_ZN5clang12TemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDeclE")
//</editor-fold>
public class TemplateDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // TemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 699,
   FQN="clang::TemplateDecl::anchor", NM="_ZN5clang12TemplateDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*protected:*/
  // This is probably never used.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::TemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 334,
   FQN="clang::TemplateDecl::TemplateDecl", NM="_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameE")
  //</editor-fold>
  protected TemplateDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, DeclarationName Name) {
    // : NamedDecl(DK, DC, L, Name), TemplatedDecl(null, false), TemplateParams(null) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Name));
    this.TemplatedDecl = new PointerBoolPair<NamedDecl /*P*/ >((NamedDecl /*P*/ )null, false);
    this.TemplateParams = null;
    //END JInit
  }

  
  // Construct a template decl with the given name and parameters.
  // Used when there is not templated element (tt-params).
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::TemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 340,
   FQN="clang::TemplateDecl::TemplateDecl", NM="_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListE")
  //</editor-fold>
  protected TemplateDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, DeclarationName Name, 
      TemplateParameterList /*P*/ Params) {
    // : NamedDecl(DK, DC, L, Name), TemplatedDecl(null, false), TemplateParams(Params) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Name));
    this.TemplatedDecl = new PointerBoolPair<NamedDecl /*P*/ >((NamedDecl /*P*/ )null, false);
    this.TemplateParams = Params;
    //END JInit
  }

  
  // Construct a template decl with name, parameters, and templated element.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::TemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 346,
   FQN="clang::TemplateDecl::TemplateDecl", NM="_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected TemplateDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, DeclarationName Name, 
      TemplateParameterList /*P*/ Params, NamedDecl /*P*/ Decl) {
    // : NamedDecl(DK, DC, L, Name), TemplatedDecl(Decl, false), TemplateParams(Params) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Name));
    this.TemplatedDecl = new PointerBoolPair<NamedDecl /*P*/ >(Decl, false);
    this.TemplateParams = Params;
    //END JInit
  }

/*public:*/
  /// Get the list of template parameters
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::getTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 353,
   FQN="clang::TemplateDecl::getTemplateParameters", NM="_ZNK5clang12TemplateDecl21getTemplateParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang12TemplateDecl21getTemplateParametersEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameters() /*const*/ {
    return TemplateParams;
  }

  
  /// Get the underlying, templated declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::getTemplatedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 358,
   FQN="clang::TemplateDecl::getTemplatedDecl", NM="_ZNK5clang12TemplateDecl16getTemplatedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang12TemplateDecl16getTemplatedDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getTemplatedDecl() /*const*/ {
    return TemplatedDecl.getPointer();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 361,
   FQN="clang::TemplateDecl::classof", NM="_ZN5clang12TemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 362,
   FQN="clang::TemplateDecl::classofKind", NM="_ZN5clang12TemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstTemplate.getValue() && K.getValue() <= Kind.lastTemplate.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 366,
   FQN="clang::TemplateDecl::getSourceRange", NM="_ZNK5clang12TemplateDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang12TemplateDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(TemplateParams.getTemplateLoc(), 
        TemplatedDecl.getPointer().getSourceRange().getEnd());
  }

  
  /// Whether this is a (C++ Concepts TS) function or variable concept.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::isConcept">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 372,
   FQN="clang::TemplateDecl::isConcept", NM="_ZNK5clang12TemplateDecl9isConceptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang12TemplateDecl9isConceptEv")
  //</editor-fold>
  public boolean isConcept() /*const*/ {
    return TemplatedDecl.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::setConcept">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 373,
   FQN="clang::TemplateDecl::setConcept", NM="_ZN5clang12TemplateDecl10setConceptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDecl10setConceptEv")
  //</editor-fold>
  public void setConcept() {
    TemplatedDecl.setInt(true);
  }

/*protected:*/
  /// \brief The named declaration from which this template was instantiated.
  /// (or null).
  ///
  /// The boolean value will be true to indicate that this template
  /// (function or variable) is a concept.
  protected PointerBoolPair<NamedDecl /*P*/ > TemplatedDecl;
  
  protected TemplateParameterList /*P*/ TemplateParams;
/*public:*/
  /// \brief Initialize the underlying templated declaration and
  /// template parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 388,
   FQN="clang::TemplateDecl::init", NM="_ZN5clang12TemplateDecl4initEPNS_9NamedDeclEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDecl4initEPNS_9NamedDeclEPNS_21TemplateParameterListE")
  //</editor-fold>
  public void init(NamedDecl /*P*/ templatedDecl, TemplateParameterList /*P*/ templateParams) {
    assert (!(TemplatedDecl.getPointer() != null)) : "TemplatedDecl already set!";
    assert (!(TemplateParams != null)) : "TemplateParams already set!";
    TemplatedDecl.setPointer(templatedDecl);
    TemplateParams = templateParams;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDecl::~TemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 330,
   FQN="clang::TemplateDecl::~TemplateDecl", NM="_ZN5clang12TemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang12TemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TemplatedDecl=" + TemplatedDecl // NOI18N
              + ", TemplateParams=" + TemplateParams // NOI18N
              + super.toString(); // NOI18N
  }
}
