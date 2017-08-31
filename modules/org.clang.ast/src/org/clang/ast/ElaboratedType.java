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


/// \brief Represents a type that was referred to using an elaborated type
/// keyword, e.g., struct S, or via a qualified name, e.g., N::M::type,
/// or both.
///
/// This type is used to keep track of a type name as written in the
/// source code, including tag keywords and any nested-name-specifiers.
/// The type itself is always "sugar", used to express what was written
/// in the source code but containing no additional semantic information.
//<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4430,
 FQN="clang::ElaboratedType", NM="_ZN5clang14ElaboratedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedTypeE")
//</editor-fold>
public class ElaboratedType extends /*public*/ TypeWithKeyword implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  
  /// The nested name specifier containing the qualifier.
  private NestedNameSpecifier /*P*/ NNS;
  
  /// The type that this qualified name refers to.
  private QualType NamedType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::ElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4438,
   FQN="clang::ElaboratedType::ElaboratedType", NM="_ZN5clang14ElaboratedTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeES4_")
  //</editor-fold>
  /*friend*//*package*/ ElaboratedType(ElaboratedTypeKeyword Keyword, NestedNameSpecifier /*P*/ NNS, 
      QualType NamedType, QualType CanonType) {
    // : TypeWithKeyword(Keyword, Elaborated, CanonType, NamedType->isDependentType(), NamedType->isInstantiationDependentType(), NamedType->isVariablyModifiedType(), NamedType->containsUnexpandedParameterPack()), FoldingSetNode(), NNS(NNS), NamedType(NamedType) 
    //START JInit
    super(Keyword, TypeClass.Elaborated, new QualType(CanonType), 
        NamedType.$arrow().isDependentType(), 
        NamedType.$arrow().isInstantiationDependentType(), 
        NamedType.$arrow().isVariablyModifiedType(), 
        NamedType.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.NNS = NNS;
    this.NamedType = new QualType(NamedType);
    //END JInit
    assert (!(Keyword == ElaboratedTypeKeyword.ETK_None && NNS == null)) : "ElaboratedType cannot have elaborated type keyword and name qualifier both null.";
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::~ElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4454,
   FQN="clang::ElaboratedType::~ElaboratedType", NM="_ZN5clang14ElaboratedTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedTypeD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// Retrieve the qualification on this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4457,
   FQN="clang::ElaboratedType::getQualifier", NM="_ZNK5clang14ElaboratedType12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ElaboratedType12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return NNS;
  }

  
  /// Retrieve the type named by the qualified-id.
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::getNamedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4460,
   FQN="clang::ElaboratedType::getNamedType", NM="_ZNK5clang14ElaboratedType12getNamedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ElaboratedType12getNamedTypeEv")
  //</editor-fold>
  public QualType getNamedType() /*const*/ {
    return new QualType(NamedType);
  }

  
  /// Remove a single level of sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4463,
   FQN="clang::ElaboratedType::desugar", NM="_ZNK5clang14ElaboratedType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ElaboratedType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getNamedType();
  }

  
  /// Returns whether this type directly provides sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4466,
   FQN="clang::ElaboratedType::isSugared", NM="_ZNK5clang14ElaboratedType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14ElaboratedType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4468,
   FQN="clang::ElaboratedType::Profile", NM="_ZN5clang14ElaboratedType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getKeyword(), NNS, /*NO_COPY*/NamedType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4472,
   FQN="clang::ElaboratedType::Profile", NM="_ZN5clang14ElaboratedType7ProfileERN4llvm16FoldingSetNodeIDENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedType7ProfileERN4llvm16FoldingSetNodeIDENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, ElaboratedTypeKeyword Keyword, 
         NestedNameSpecifier /*P*/ NNS, QualType NamedType) {
    ID.AddInteger_int(Keyword.getValue());
    ID.AddPointer(NNS);
    NamedType.Profile(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4479,
   FQN="clang::ElaboratedType::classof", NM="_ZN5clang14ElaboratedType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14ElaboratedType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Elaborated;
  }

  @Override public String toString() {
    return "" + "NNS=" + NNS // NOI18N
              + ", NamedType=" + NamedType // NOI18N
              + super.toString(); // NOI18N
  }
}
