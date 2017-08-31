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
import org.clang.basic.*;


/// \brief Represents a qualified type name for which the type name is
/// dependent.
///
/// DependentNameType represents a class of dependent types that involve a
/// possibly dependent nested-name-specifier (e.g., "T::") followed by a
/// name of a type. The DependentNameType may start with a "typename" (for a
/// typename-specifier), "class", "struct", "union", or "enum" (for a
/// dependent elaborated-type-specifier), or nothing (in contexts where we
/// know that we must be referring to a type, e.g., in a base class specifier).
/// Typically the nested-name-specifier is dependent, but in MSVC compatibility
/// mode, this type is used with non-dependent names to delay name lookup until
/// instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::DependentNameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4496,
 FQN="clang::DependentNameType", NM="_ZN5clang17DependentNameTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17DependentNameTypeE")
//</editor-fold>
public class DependentNameType extends /*public*/ TypeWithKeyword implements /*public*/ FoldingSetImpl.Node {
  
  /// \brief The nested name specifier containing the qualifier.
  private NestedNameSpecifier /*P*/ NNS;
  
  /// \brief The type that this typename specifier refers to.
  private /*const*/ IdentifierInfo /*P*/ Name;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::DependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4504,
   FQN="clang::DependentNameType::DependentNameType", NM="_ZN5clang17DependentNameTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17DependentNameTypeC1ENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_8QualTypeE")
  //</editor-fold>
  /*friend*//*package*/ DependentNameType(ElaboratedTypeKeyword Keyword, NestedNameSpecifier /*P*/ NNS, 
      /*const*/ IdentifierInfo /*P*/ Name, QualType CanonType) {
    // : TypeWithKeyword(Keyword, DependentName, CanonType, /*Dependent=*/ true, /*InstantiationDependent=*/ true, /*VariablyModified=*/ false, NNS->containsUnexpandedParameterPack()), FoldingSetNode(), NNS(NNS), Name(Name) 
    //START JInit
    super(Keyword, TypeClass.DependentName, new QualType(CanonType), true, 
        true, 
        false, 
        NNS.containsUnexpandedParameterPack());
    $Node();
    this.NNS = NNS;
    this.Name = Name;
    //END JInit
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
/*public:*/
  /// Retrieve the qualification on this type.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4516,
   FQN="clang::DependentNameType::getQualifier", NM="_ZNK5clang17DependentNameType12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17DependentNameType12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return NNS;
  }

  
  /// Retrieve the type named by the typename specifier as an identifier.
  ///
  /// This routine will return a non-NULL identifier pointer when the
  /// form of the original typename was terminated by an identifier,
  /// e.g., "typename T::type".
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4523,
   FQN="clang::DependentNameType::getIdentifier", NM="_ZNK5clang17DependentNameType13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17DependentNameType13getIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Name;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4527,
   FQN="clang::DependentNameType::isSugared", NM="_ZNK5clang17DependentNameType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17DependentNameType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4528,
   FQN="clang::DependentNameType::desugar", NM="_ZNK5clang17DependentNameType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17DependentNameType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4530,
   FQN="clang::DependentNameType::Profile", NM="_ZN5clang17DependentNameType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17DependentNameType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getKeyword(), NNS, Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4534,
   FQN="clang::DependentNameType::Profile", NM="_ZN5clang17DependentNameType7ProfileERN4llvm16FoldingSetNodeIDENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17DependentNameType7ProfileERN4llvm16FoldingSetNodeIDENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, ElaboratedTypeKeyword Keyword, 
         NestedNameSpecifier /*P*/ NNS, /*const*/ IdentifierInfo /*P*/ Name) {
    ID.AddInteger_int(Keyword.getValue());
    ID.AddPointer(NNS);
    ID.AddPointer(Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4541,
   FQN="clang::DependentNameType::classof", NM="_ZN5clang17DependentNameType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17DependentNameType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.DependentName;
  }

  @Override public String toString() {
    return "" + "NNS=" + NNS // NOI18N
              + ", Name=" + Name // NOI18N
              + super.toString(); // NOI18N
  }
}
