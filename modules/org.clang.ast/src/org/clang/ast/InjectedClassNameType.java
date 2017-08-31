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
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.impl.TypeStatics.getInterestingTagDecl;


/// The injected class name of a C++ class template or class
/// template partial specialization.  Used to record that a type was
/// spelled with a bare identifier rather than as a template-id; the
/// equivalent for non-templated classes is just RecordType.
///
/// Injected class name types are always dependent.  Template
/// instantiation turns these into RecordTypes.
///
/// Injected class name types are always canonical.  This works
/// because it is impossible to compare an injected class name type
/// with the corresponding non-injected template type, for the same
/// reason that it is impossible to directly compare template
/// parameters from different dependent contexts: injected class name
/// types can only occur within the scope of a particular templated
/// declaration, and within that scope every template specialization
/// will canonicalize to the injected class name (when appropriate
/// according to the rules of the language).
//<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4294,
 FQN="clang::InjectedClassNameType", NM="_ZN5clang21InjectedClassNameTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21InjectedClassNameTypeE")
//</editor-fold>
public class InjectedClassNameType extends /*public*/ Type {
  private CXXRecordDecl /*P*/ Decl;
  
  /// The template specialization which this type represents.
  /// For example, in
  ///   template <class T> class A { ... };
  /// this is A<T>, whereas in
  ///   template <class X, class Y> class A<B<X,Y> > { ... };
  /// this is A<B<X,Y> >.
  ///
  /// It is always unqualified, always a template specialization type,
  /// and always dependent.
  private QualType InjectedType;
  
  /*friend  class ASTContext*/ // ASTContext creates these.
  /*friend  class ASTReader*/ // FIXME: ASTContext::getInjectedClassNameType is not
  // currently suitable for AST reading, too much
  // interdependencies.
  /*friend  class ASTNodeImporter*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::InjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4314,
   FQN="clang::InjectedClassNameType::InjectedClassNameType", NM="_ZN5clang21InjectedClassNameTypeC1EPNS_13CXXRecordDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21InjectedClassNameTypeC1EPNS_13CXXRecordDeclENS_8QualTypeE")
  //</editor-fold>
  /*friend*/public/*private*/ InjectedClassNameType(CXXRecordDecl /*P*/ D, QualType TST) {
    // : Type(InjectedClassName, QualType(), /*Dependent=*/ true, /*InstantiationDependent=*/ true, /*VariablyModified=*/ false, /*ContainsUnexpandedParameterPack=*/ false), Decl(D), InjectedType(TST) 
    //START JInit
    super(TypeClass.InjectedClassName, new QualType(), true, 
        true, 
        false, 
        false);
    this.Decl = D;
    this.InjectedType = new QualType(TST);
    //END JInit
    assert (isa_TemplateSpecializationType(TST));
    assert (!TST.hasQualifiers());
    assert (TST.$arrow().isDependentType());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::getInjectedSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4326,
   FQN="clang::InjectedClassNameType::getInjectedSpecializationType", NM="_ZNK5clang21InjectedClassNameType29getInjectedSpecializationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21InjectedClassNameType29getInjectedSpecializationTypeEv")
  //</editor-fold>
  public QualType getInjectedSpecializationType() /*const*/ {
    return new QualType(InjectedType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::getInjectedTST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4327,
   FQN="clang::InjectedClassNameType::getInjectedTST", NM="_ZNK5clang21InjectedClassNameType14getInjectedTSTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21InjectedClassNameType14getInjectedTSTEv")
  //</editor-fold>
  public /*const*/ TemplateSpecializationType /*P*/ getInjectedTST() /*const*/ {
    return cast_TemplateSpecializationType(InjectedType.getTypePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3065,
   FQN="clang::InjectedClassNameType::getDecl", NM="_ZNK5clang21InjectedClassNameType7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21InjectedClassNameType7getDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getDecl() /*const*/ {
    return cast_CXXRecordDecl(getInterestingTagDecl(Decl));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4333,
   FQN="clang::InjectedClassNameType::isSugared", NM="_ZNK5clang21InjectedClassNameType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21InjectedClassNameType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4334,
   FQN="clang::InjectedClassNameType::desugar", NM="_ZNK5clang21InjectedClassNameType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21InjectedClassNameType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InjectedClassNameType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4336,
   FQN="clang::InjectedClassNameType::classof", NM="_ZN5clang21InjectedClassNameType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21InjectedClassNameType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.InjectedClassName;
  }

  @Override public String toString() {
    return "" + "Decl=" + Decl // NOI18N
              + ", InjectedType=" + InjectedType // NOI18N
              + super.toString(); // NOI18N
  }
}
