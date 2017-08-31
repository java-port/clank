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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// A helper class for Type nodes having an ElaboratedTypeKeyword.
/// The keyword in stored in the free bits of the base class.
/// Also provides a few static helpers for converting and printing
/// elaborated type keyword and tag type kind enumerations.
//<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4379,
 FQN="clang::TypeWithKeyword", NM="_ZN5clang15TypeWithKeywordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeywordE")
//</editor-fold>
public class TypeWithKeyword extends /*public*/ Type {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::TypeWithKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4381,
   FQN="clang::TypeWithKeyword::TypeWithKeyword", NM="_ZN5clang15TypeWithKeywordC1ENS_21ElaboratedTypeKeywordENS_4Type9TypeClassENS_8QualTypeEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeywordC1ENS_21ElaboratedTypeKeywordENS_4Type9TypeClassENS_8QualTypeEbbbb")
  //</editor-fold>
  protected TypeWithKeyword(ElaboratedTypeKeyword Keyword, TypeClass tc, 
      QualType Canonical, boolean Dependent, 
      boolean InstantiationDependent, boolean VariablyModified, 
      boolean ContainsUnexpandedParameterPack) {
    // : Type(tc, Canonical, Dependent, InstantiationDependent, VariablyModified, ContainsUnexpandedParameterPack) 
    //START JInit
    super(tc, new QualType(Canonical), Dependent, InstantiationDependent, VariablyModified, 
        ContainsUnexpandedParameterPack);
    //END JInit
    Unnamed_field.TypeWithKeywordBits.Keyword = $uint2uint_8bits(Keyword.getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4391,
   FQN="clang::TypeWithKeyword::getKeyword", NM="_ZNK5clang15TypeWithKeyword10getKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang15TypeWithKeyword10getKeywordEv")
  //</editor-fold>
  public ElaboratedTypeKeyword getKeyword() /*const*/ {
    return /*static_cast*/ElaboratedTypeKeyword.valueOf($8bits_uint2uint(Unnamed_field.TypeWithKeywordBits.Keyword));
  }

  
  /// Converts a type specifier (DeclSpec::TST) into an elaborated type keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getKeywordForTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2377,
   FQN="clang::TypeWithKeyword::getKeywordForTypeSpec", NM="_ZN5clang15TypeWithKeyword21getKeywordForTypeSpecEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword21getKeywordForTypeSpecEj")
  //</editor-fold>
  public static ElaboratedTypeKeyword getKeywordForTypeSpec(/*uint*/int TypeSpec) {
    switch (TypeSpecifierType.valueOf(TypeSpec)) {
     default:
      return ElaboratedTypeKeyword.ETK_None;
     case TST_typename:
      return ElaboratedTypeKeyword.ETK_Typename;
     case TST_class:
      return ElaboratedTypeKeyword.ETK_Class;
     case TST_struct:
      return ElaboratedTypeKeyword.ETK_Struct;
     case TST_interface:
      return ElaboratedTypeKeyword.ETK_Interface;
     case TST_union:
      return ElaboratedTypeKeyword.ETK_Union;
     case TST_enum:
      return ElaboratedTypeKeyword.ETK_Enum;
    }
  }

  
  /// Converts a type specifier (DeclSpec::TST) into a tag type kind.
  /// It is an error to provide a type specifier which *isn't* a tag kind here.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getTagTypeKindForTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2390,
   FQN="clang::TypeWithKeyword::getTagTypeKindForTypeSpec", NM="_ZN5clang15TypeWithKeyword25getTagTypeKindForTypeSpecEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword25getTagTypeKindForTypeSpecEj")
  //</editor-fold>
  public static TagTypeKind getTagTypeKindForTypeSpec(/*uint*/int TypeSpec) {
    switch (TypeSpecifierType.valueOf(TypeSpec)) {
     case TST_class:
      return TagTypeKind.TTK_Class;
     case TST_struct:
      return TagTypeKind.TTK_Struct;
     case TST_interface:
      return TagTypeKind.TTK_Interface;
     case TST_union:
      return TagTypeKind.TTK_Union;
     case TST_enum:
      return TagTypeKind.TTK_Enum;
    }
    throw new llvm_unreachable("Type specifier is not a tag type kind.");
  }

  
  /// Converts a TagTypeKind into an elaborated type keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getKeywordForTagTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2403,
   FQN="clang::TypeWithKeyword::getKeywordForTagTypeKind", NM="_ZN5clang15TypeWithKeyword24getKeywordForTagTypeKindENS_11TagTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword24getKeywordForTagTypeKindENS_11TagTypeKindE")
  //</editor-fold>
  public static ElaboratedTypeKeyword getKeywordForTagTypeKind(TagTypeKind Kind) {
    switch (Kind) {
     case TTK_Class:
      return ElaboratedTypeKeyword.ETK_Class;
     case TTK_Struct:
      return ElaboratedTypeKeyword.ETK_Struct;
     case TTK_Interface:
      return ElaboratedTypeKeyword.ETK_Interface;
     case TTK_Union:
      return ElaboratedTypeKeyword.ETK_Union;
     case TTK_Enum:
      return ElaboratedTypeKeyword.ETK_Enum;
    }
    throw new llvm_unreachable("Unknown tag type kind.");
  }

  
  /// Converts an elaborated type keyword into a TagTypeKind.
  /// It is an error to provide an elaborated type keyword
  /// which *isn't* a tag kind here.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getTagTypeKindForKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2415,
   FQN="clang::TypeWithKeyword::getTagTypeKindForKeyword", NM="_ZN5clang15TypeWithKeyword24getTagTypeKindForKeywordENS_21ElaboratedTypeKeywordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword24getTagTypeKindForKeywordENS_21ElaboratedTypeKeywordE")
  //</editor-fold>
  public static TagTypeKind getTagTypeKindForKeyword(ElaboratedTypeKeyword Keyword) {
    switch (Keyword) {
     case ETK_Class:
      return TagTypeKind.TTK_Class;
     case ETK_Struct:
      return TagTypeKind.TTK_Struct;
     case ETK_Interface:
      return TagTypeKind.TTK_Interface;
     case ETK_Union:
      return TagTypeKind.TTK_Union;
     case ETK_Enum:
      return TagTypeKind.TTK_Enum;
     case ETK_None: // Fall through.
     case ETK_Typename:
      throw new llvm_unreachable("Elaborated type keyword is not a tag type kind.");
    }
    throw new llvm_unreachable("Unknown elaborated type keyword.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::KeywordIsTagTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2430,
   FQN="clang::TypeWithKeyword::KeywordIsTagTypeKind", NM="_ZN5clang15TypeWithKeyword20KeywordIsTagTypeKindENS_21ElaboratedTypeKeywordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword20KeywordIsTagTypeKindENS_21ElaboratedTypeKeywordE")
  //</editor-fold>
  public static boolean KeywordIsTagTypeKind(ElaboratedTypeKeyword Keyword) {
    switch (Keyword) {
     case ETK_None:
     case ETK_Typename:
      return false;
     case ETK_Class:
     case ETK_Struct:
     case ETK_Interface:
     case ETK_Union:
     case ETK_Enum:
      return true;
    }
    throw new llvm_unreachable("Unknown elaborated type keyword.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getKeywordName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2446,
   FQN="clang::TypeWithKeyword::getKeywordName", NM="_ZN5clang15TypeWithKeyword14getKeywordNameENS_21ElaboratedTypeKeywordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword14getKeywordNameENS_21ElaboratedTypeKeywordE")
  //</editor-fold>
  public static StringRef getKeywordName(ElaboratedTypeKeyword Keyword) {
    switch (Keyword) {
     case ETK_None:
      return new StringRef(/*KEEP_STR*/$EMPTY);
     case ETK_Typename:
      return new StringRef(/*KEEP_STR*/$typename);
     case ETK_Class:
      return new StringRef(/*KEEP_STR*/$class);
     case ETK_Struct:
      return new StringRef(/*KEEP_STR*/$struct);
     case ETK_Interface:
      return new StringRef(/*KEEP_STR*/$__interface);
     case ETK_Union:
      return new StringRef(/*KEEP_STR*/$union);
     case ETK_Enum:
      return new StringRef(/*KEEP_STR*/$enum);
    }
    throw new llvm_unreachable("Unknown elaborated type keyword.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::getTagTypeKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4414,
   FQN="clang::TypeWithKeyword::getTagTypeKindName", NM="_ZN5clang15TypeWithKeyword18getTagTypeKindNameENS_11TagTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword18getTagTypeKindNameENS_11TagTypeKindE")
  //</editor-fold>
  public static StringRef getTagTypeKindName(TagTypeKind Kind) {
    return getKeywordName(getKeywordForTagTypeKind(Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::CannotCastToThisType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4418,
   FQN="clang::TypeWithKeyword::CannotCastToThisType", NM="_ZN5clang15TypeWithKeyword20CannotCastToThisTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword20CannotCastToThisTypeE")
  //</editor-fold>
  public static class CannotCastToThisType {
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TypeWithKeyword::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4419,
   FQN="clang::TypeWithKeyword::classof", NM="_ZN5clang15TypeWithKeyword7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang15TypeWithKeyword7classofEPKNS_4TypeE")
  //</editor-fold>
  public static CannotCastToThisType classof$CannotCastToThisType(/*const*/ Type /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
