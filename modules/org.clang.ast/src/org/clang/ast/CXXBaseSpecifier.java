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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// \brief Represents a base class of a C++ class.
///
/// Each CXXBaseSpecifier represents a single, direct base class (or
/// struct) of a C++ class (or struct). It specifies the type of that
/// base class, whether it is a virtual or non-virtual base, and what
/// level of access (public, protected, private) is used for the
/// derivation. For example:
///
/// \code
///   class A { };
///   class B { };
///   class C : public virtual A, protected B { };
/// \endcode
///
/// In this code, C will have two CXXBaseSpecifiers, one for "public
/// virtual A" and the other for "protected B".
//<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 159,
 FQN="clang::CXXBaseSpecifier", NM="_ZN5clang16CXXBaseSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifierE")
//</editor-fold>
public class CXXBaseSpecifier {
  /// \brief The source code range that covers the full base
  /// specifier, including the "virtual" (if present) and access
  /// specifier (if present).
  private SourceRange Range;
  
  /// \brief The source location of the ellipsis, if this is a pack
  /// expansion.
  private SourceLocation EllipsisLoc;
  
  /// \brief Whether this is a virtual base class or not.
  private /*JBIT unsigned int*/ boolean Virtual /*: 1*/;
  
  /// \brief Whether this is the base of a class (true) or of a struct (false).
  ///
  /// This determines the mapping from the access specifier as written in the
  /// source code to the access specifier used for semantic analysis.
  private /*JBIT unsigned int*/ boolean BaseOfClass /*: 1*/;
  
  /// \brief Access specifier as written in the source code (may be AS_none).
  ///
  /// The actual type of data stored here is an AccessSpecifier, but we use
  /// "unsigned" here to work around a VC++ bug.
  private /*JBYTE unsigned int*/ byte Access /*: 2*/;
  
  /// \brief Whether the class contains a using declaration
  /// to inherit the named class's constructors.
  private /*JBIT unsigned int*/ boolean InheritConstructors /*: 1*/;
  
  /// \brief The type of the base class.
  ///
  /// This will be a class or struct (or a typedef of such). The source code
  /// range does not include the \c virtual or the access specifier.
  private TypeSourceInfo /*P*/ BaseTypeInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::CXXBaseSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 195,
   FQN="clang::CXXBaseSpecifier::CXXBaseSpecifier", NM="_ZN5clang16CXXBaseSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifierC1Ev")
  //</editor-fold>
  public CXXBaseSpecifier() {
    // : Range(), EllipsisLoc() 
    //START JInit
    this.Range = new SourceRange();
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::CXXBaseSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 197,
   FQN="clang::CXXBaseSpecifier::CXXBaseSpecifier", NM="_ZN5clang16CXXBaseSpecifierC1ENS_11SourceRangeEbbNS_15AccessSpecifierEPNS_14TypeSourceInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifierC1ENS_11SourceRangeEbbNS_15AccessSpecifierEPNS_14TypeSourceInfoENS_14SourceLocationE")
  //</editor-fold>
  public CXXBaseSpecifier(SourceRange R, boolean V, boolean BC, AccessSpecifier A, 
      TypeSourceInfo /*P*/ TInfo, SourceLocation EllipsisLoc) {
    // : Range(R), EllipsisLoc(EllipsisLoc), Virtual(V), BaseOfClass(BC), Access(A), InheritConstructors(false), BaseTypeInfo(TInfo) 
    //START JInit
    this.Range = new SourceRange(R);
    this.EllipsisLoc = new SourceLocation(EllipsisLoc);
    this.Virtual = V;
    this.BaseOfClass = BC;
    this.Access = $uint2uint_2bits(A.getValue());
    this.InheritConstructors = false;
    this.BaseTypeInfo = TInfo;
    //END JInit
  }

  
  /// \brief Retrieves the source range that contains the entire base specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 203,
   FQN="clang::CXXBaseSpecifier::getSourceRange", NM="_ZNK5clang16CXXBaseSpecifier14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 204,
   FQN="clang::CXXBaseSpecifier::getLocStart", NM="_ZNK5clang16CXXBaseSpecifier11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 205,
   FQN="clang::CXXBaseSpecifier::getLocEnd", NM="_ZNK5clang16CXXBaseSpecifier9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  
  /// \brief Determines whether the base class is a virtual base class (or not).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::isVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 208,
   FQN="clang::CXXBaseSpecifier::isVirtual", NM="_ZNK5clang16CXXBaseSpecifier9isVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier9isVirtualEv")
  //</editor-fold>
  public boolean isVirtual() /*const*/ {
    return Virtual;
  }

  
  /// \brief Determine whether this base class is a base of a class declared
  /// with the 'class' keyword (vs. one declared with the 'struct' keyword).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::isBaseOfClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 212,
   FQN="clang::CXXBaseSpecifier::isBaseOfClass", NM="_ZNK5clang16CXXBaseSpecifier13isBaseOfClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier13isBaseOfClassEv")
  //</editor-fold>
  public boolean isBaseOfClass() /*const*/ {
    return BaseOfClass;
  }

  
  /// \brief Determine whether this base specifier is a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 215,
   FQN="clang::CXXBaseSpecifier::isPackExpansion", NM="_ZNK5clang16CXXBaseSpecifier15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return EllipsisLoc.isValid();
  }

  
  /// \brief Determine whether this base class's constructors get inherited.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getInheritConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 218,
   FQN="clang::CXXBaseSpecifier::getInheritConstructors", NM="_ZNK5clang16CXXBaseSpecifier22getInheritConstructorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier22getInheritConstructorsEv")
  //</editor-fold>
  public boolean getInheritConstructors() /*const*/ {
    return InheritConstructors;
  }

  
  /// \brief Set that this base class's constructors should be inherited.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::setInheritConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 221,
   FQN="clang::CXXBaseSpecifier::setInheritConstructors", NM="_ZN5clang16CXXBaseSpecifier22setInheritConstructorsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifier22setInheritConstructorsEb")
  //</editor-fold>
  public void setInheritConstructors() {
    setInheritConstructors(true);
  }
  public void setInheritConstructors(boolean Inherit/*= true*/) {
    InheritConstructors = Inherit;
  }

  
  /// \brief For a pack expansion, determine the location of the ellipsis.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 226,
   FQN="clang::CXXBaseSpecifier::getEllipsisLoc", NM="_ZNK5clang16CXXBaseSpecifier14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  
  /// \brief Returns the access specifier for this base specifier. 
  ///
  /// This is the actual base specifier as used for semantic analysis, so
  /// the result can never be AS_none. To retrieve the access specifier as
  /// written in the source code, use getAccessSpecifierAsWritten().
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getAccessSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 235,
   FQN="clang::CXXBaseSpecifier::getAccessSpecifier", NM="_ZNK5clang16CXXBaseSpecifier18getAccessSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier18getAccessSpecifierEv")
  //</editor-fold>
  public AccessSpecifier getAccessSpecifier() /*const*/ {
    if (AccessSpecifier.valueOf(Access) == AccessSpecifier.AS_none) {
      return BaseOfClass ? AccessSpecifier.AS_private : AccessSpecifier.AS_public;
    } else {
      return AccessSpecifier.valueOf(Access);
    }
  }

  
  /// \brief Retrieves the access specifier as written in the source code
  /// (which may mean that no access specifier was explicitly written).
  ///
  /// Use getAccessSpecifier() to retrieve the access specifier for use in
  /// semantic analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getAccessSpecifierAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 247,
   FQN="clang::CXXBaseSpecifier::getAccessSpecifierAsWritten", NM="_ZNK5clang16CXXBaseSpecifier27getAccessSpecifierAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier27getAccessSpecifierAsWrittenEv")
  //</editor-fold>
  public AccessSpecifier getAccessSpecifierAsWritten() /*const*/ {
    return AccessSpecifier.valueOf(Access);
  }

  
  /// \brief Retrieves the type of the base class.
  ///
  /// This type will always be an unqualified class type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 254,
   FQN="clang::CXXBaseSpecifier::getType", NM="_ZNK5clang16CXXBaseSpecifier7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return BaseTypeInfo.getType().getUnqualifiedType();
  }

  
  /// \brief Retrieves the type and source location of the base class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 259,
   FQN="clang::CXXBaseSpecifier::getTypeSourceInfo", NM="_ZNK5clang16CXXBaseSpecifier17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang16CXXBaseSpecifier17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return BaseTypeInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::CXXBaseSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 159,
   FQN="clang::CXXBaseSpecifier::CXXBaseSpecifier", NM="_ZN5clang16CXXBaseSpecifierC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifierC1EOS0_")
  //</editor-fold>
  public /*inline*/ CXXBaseSpecifier(JD$Move _dparam, final CXXBaseSpecifier /*&&*/$Prm0) {
    // : Range(static_cast<CXXBaseSpecifier &&>().Range), EllipsisLoc(static_cast<CXXBaseSpecifier &&>().EllipsisLoc), Virtual(static_cast<CXXBaseSpecifier &&>().Virtual), BaseOfClass(static_cast<CXXBaseSpecifier &&>().BaseOfClass), Access(static_cast<CXXBaseSpecifier &&>().Access), InheritConstructors(static_cast<CXXBaseSpecifier &&>().InheritConstructors), BaseTypeInfo(static_cast<CXXBaseSpecifier &&>().BaseTypeInfo) 
    //START JInit
    this.Range = new SourceRange(JD$Move.INSTANCE, $Prm0.Range);
    this.EllipsisLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EllipsisLoc);
    this.Virtual = $Prm0.Virtual;
    this.BaseOfClass = $Prm0.BaseOfClass;
    this.Access = $uint2uint_2bits($Prm0.Access);
    this.InheritConstructors = $Prm0.InheritConstructors;
    this.BaseTypeInfo = $Prm0.BaseTypeInfo;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 159,
   FQN="clang::CXXBaseSpecifier::operator=", NM="_ZN5clang16CXXBaseSpecifieraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang16CXXBaseSpecifieraSEOS0_")
  //</editor-fold>
  public /*inline*/ CXXBaseSpecifier /*&*/ $assignMove(final CXXBaseSpecifier /*&&*/$Prm0) {
    this.Range.$assignMove($Prm0.Range);
    this.EllipsisLoc.$assignMove($Prm0.EllipsisLoc);
    this.Virtual = $Prm0.Virtual;
    this.BaseOfClass = $Prm0.BaseOfClass;
    this.Access = $uint2uint_2bits($Prm0.Access);
    this.InheritConstructors = $Prm0.InheritConstructors;
    this.BaseTypeInfo = $Prm0.BaseTypeInfo;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 159,
   FQN="clang::CXXBaseSpecifier::operator=", NM="_ZN5clang16CXXBaseSpecifieraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16CXXBaseSpecifieraSERKS0_")
  //</editor-fold>
  public /*inline*/ CXXBaseSpecifier /*&*/ $assign(final /*const*/ CXXBaseSpecifier /*&*/ $Prm0) {
    this.Range.$assign($Prm0.Range);
    this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
    this.Virtual = $Prm0.Virtual;
    this.BaseOfClass = $Prm0.BaseOfClass;
    this.Access = $uint2uint_2bits($Prm0.Access);
    this.InheritConstructors = $Prm0.InheritConstructors;
    this.BaseTypeInfo = $Prm0.BaseTypeInfo;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXBaseSpecifier::CXXBaseSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 159,
   FQN="clang::CXXBaseSpecifier::CXXBaseSpecifier", NM="_ZN5clang16CXXBaseSpecifierC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang16CXXBaseSpecifierC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CXXBaseSpecifier(final /*const*/ CXXBaseSpecifier /*&*/ $Prm0) {
    // : Range(.Range), EllipsisLoc(.EllipsisLoc), Virtual(.Virtual), BaseOfClass(.BaseOfClass), Access(.Access), InheritConstructors(.InheritConstructors), BaseTypeInfo(.BaseTypeInfo) 
    //START JInit
    this.Range = new SourceRange($Prm0.Range);
    this.EllipsisLoc = new SourceLocation($Prm0.EllipsisLoc);
    this.Virtual = $Prm0.Virtual;
    this.BaseOfClass = $Prm0.BaseOfClass;
    this.Access = $uint2uint_2bits($Prm0.Access);
    this.InheritConstructors = $Prm0.InheritConstructors;
    this.BaseTypeInfo = $Prm0.BaseTypeInfo;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", Virtual=" + Virtual // NOI18N
              + ", BaseOfClass=" + BaseOfClass // NOI18N
              + ", Access=" + $uchar2uint(Access) // NOI18N
              + ", InheritConstructors=" + InheritConstructors // NOI18N
              + ", BaseTypeInfo=" + BaseTypeInfo; // NOI18N
  }
}
