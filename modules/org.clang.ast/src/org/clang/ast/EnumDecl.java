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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.basic.BasicClangGlobals.*;


/// EnumDecl - Represents an enum.  In C++11, enums can be forward-declared
/// with a fixed underlying type, and in C we allow them to be forward-declared
/// with no underlying type as an extension.
//<editor-fold defaultstate="collapsed" desc="clang::EnumDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3013,
 FQN="clang::EnumDecl", NM="_ZN5clang8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDeclE")
//</editor-fold>
public class EnumDecl extends /*public*/ TagDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // EnumDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3625,
   FQN="clang::EnumDecl::anchor", NM="_ZN5clang8EnumDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// IntegerType - This represent the integer type that the enum corresponds
  /// to for code generation purposes.  Note that the enumerator constants may
  /// have a different type than this does.
  ///
  /// If the underlying integer type was explicitly stated in the source
  /// code, this is a TypeSourceInfo* for that type. Otherwise this type
  /// was automatically deduced somehow, and this is a Type*.
  ///
  /// Normally if IsFixed(), this would contain a TypeSourceInfo*, but in
  /// some cases it won't.
  ///
  /// The underlying type of an enumeration never has any qualifiers, so
  /// we can get away with just storing a raw Type*, and thus save an
  /// extra pointer when TypeSourceInfo is needed.
  private PointerUnion</*const*/ Type /*P*/ , TypeSourceInfo /*P*/ > IntegerType;
  
  /// PromotionType - The integer type that values of this type should
  /// promote to.  In C, enumerators are generally of an integer type
  /// directly, but gcc-style large enumerators (and all enumerators
  /// in C++) are of the enum type instead.
  private QualType PromotionType;
  
  /// \brief If this enumeration is an instantiation of a member enumeration
  /// of a class template specialization, this is the member specialization
  /// information.
  private MemberSpecializationInfo /*P*/ SpecializationInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::EnumDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3043,
   FQN="clang::EnumDecl::EnumDecl", NM="_ZN5clang8EnumDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_bbb")
  //</editor-fold>
  private EnumDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, EnumDecl /*P*/ PrevDecl, 
      boolean Scoped, boolean ScopedUsingClassTag, boolean Fixed) {
    // : TagDecl(Enum, TTK_Enum, C, DC, IdLoc, Id, PrevDecl, StartLoc), IntegerType(), PromotionType(), SpecializationInfo(null) 
    //START JInit
    super(Kind.Enum, TagTypeKind.TTK_Enum, C, DC, new SourceLocation(IdLoc), Id, PrevDecl, new SourceLocation(StartLoc));
    this.IntegerType = new PointerUnion</*const*/ Type /*P*/ , TypeSourceInfo /*P*/ >(/*const*/ Type /*P*/ .class);
    this.PromotionType = new QualType();
    this.SpecializationInfo = null;
    //END JInit
    assert (Scoped || !ScopedUsingClassTag);
    IntegerType.$assign_T$C$R(/*const*/ Type /*P*/.class, (/*const*/ Type /*P*/ )null);
    NumNegativeBits = $uint2uint_8bits(0);
    NumPositiveBits = $uint2uint_8bits(0);
    IsScoped = Scoped;
    IsScopedUsingClassTag = ScopedUsingClassTag;
    IsFixed = Fixed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setInstantiationOfMemberEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3706,
   FQN="clang::EnumDecl::setInstantiationOfMemberEnum", NM="_ZN5clang8EnumDecl28setInstantiationOfMemberEnumERNS_10ASTContextEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl28setInstantiationOfMemberEnumERNS_10ASTContextEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  /*friend*/public void setInstantiationOfMemberEnum(final ASTContext /*&*/ C, EnumDecl /*P*/ ED, 
                              TemplateSpecializationKind TSK) {
    assert (!(SpecializationInfo != null)) : "Member enum is already a specialization";
    SpecializationInfo = /*FIXME:NEW_EXPR*//*new (C)*/ new MemberSpecializationInfo(ED, TSK);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3060,
   FQN="clang::EnumDecl::getCanonicalDecl", NM="_ZN5clang8EnumDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public EnumDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_EnumDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3063,
   FQN="clang::EnumDecl::getCanonicalDecl", NM="_ZNK5clang8EnumDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ EnumDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/EnumDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3067,
   FQN="clang::EnumDecl::getPreviousDecl", NM="_ZN5clang8EnumDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl15getPreviousDeclEv")
  //</editor-fold>
  public EnumDecl /*P*/ getPreviousDecl() {
    return cast_or_null_EnumDecl(/*JCast:TagDecl * */super.getPreviousDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3071,
   FQN="clang::EnumDecl::getPreviousDecl", NM="_ZNK5clang8EnumDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ EnumDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return ((/*const_cast*/EnumDecl /*P*/ )(this)).getPreviousDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3075,
   FQN="clang::EnumDecl::getMostRecentDecl", NM="_ZN5clang8EnumDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl17getMostRecentDeclEv")
  //</editor-fold>
  public EnumDecl /*P*/ getMostRecentDecl() {
    return cast_EnumDecl(/*JCast:TagDecl * */super.getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3078,
   FQN="clang::EnumDecl::getMostRecentDecl", NM="_ZNK5clang8EnumDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ EnumDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/EnumDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3082,
   FQN="clang::EnumDecl::getDefinition", NM="_ZNK5clang8EnumDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl13getDefinitionEv")
  //</editor-fold>
  public EnumDecl /*P*/ getDefinition() /*const*/ {
    return cast_or_null_EnumDecl(super.getDefinition());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3627,
   FQN="clang::EnumDecl::Create", NM="_ZN5clang8EnumDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_bbb")
  //</editor-fold>
  public static EnumDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        IdentifierInfo /*P*/ Id, 
        EnumDecl /*P*/ PrevDecl, boolean IsScoped, 
        boolean IsScopedUsingClassTag, boolean IsFixed) {
    EnumDecl /*P*/ Enum = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new EnumDecl(C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, PrevDecl, 
                IsScoped, IsScopedUsingClassTag, IsFixed);
     });
    Enum.MayHaveOutOfDateDef = C.getLangOpts().Modules;
    C.getTypeDeclType(Enum, PrevDecl);
    return Enum;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3639,
   FQN="clang::EnumDecl::CreateDeserialized", NM="_ZN5clang8EnumDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static EnumDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    EnumDecl /*P*/ Enum = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new EnumDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, (EnumDecl /*P*/ )null, false, false, false);
     });
    Enum.MayHaveOutOfDateDef = C.getLangOpts().Modules;
    return Enum;
  }

  
  /// completeDefinition - When created, the EnumDecl corresponds to a
  /// forward-declared enum. This method is used to mark the
  /// declaration as being defined; it's enumerators have already been
  /// added (via DeclContext::addDecl). NewType is the new underlying
  /// type of the enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::completeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3653,
   FQN="clang::EnumDecl::completeDefinition", NM="_ZN5clang8EnumDecl18completeDefinitionENS_8QualTypeES1_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl18completeDefinitionENS_8QualTypeES1_jj")
  //</editor-fold>
  public void completeDefinition(QualType NewType, 
                    QualType NewPromotionType, 
                    /*uint*/int NumPositiveBits, 
                    /*uint*/int NumNegativeBits) {
    assert (!isCompleteDefinition()) : "Cannot redefine enums!";
    if (!IntegerType.$bool()) {
      IntegerType.$assign_T$C$R(Type /*P*/.class, NewType.getTypePtr());
    }
    PromotionType.$assign(NewPromotionType);
    setNumPositiveBits(NumPositiveBits);
    setNumNegativeBits(NumNegativeBits);
    super.completeDefinition();
  }

  
  // enumerator_iterator - Iterates through the enumerators of this
  // enumeration.
  /*typedef specific_decl_iterator<EnumConstantDecl> enumerator_iterator*/
//  public final class enumerator_iterator extends specific_decl_iterator<EnumConstantDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<EnumConstantDecl> > enumerator_range*/
//  public final class enumerator_range extends iterator_range<EnumConstantDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::enumerators">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3109,
   FQN="clang::EnumDecl::enumerators", NM="_ZNK5clang8EnumDecl11enumeratorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl11enumeratorsEv")
  //</editor-fold>
  public iterator_range<EnumConstantDecl /*P*/ > enumerators() /*const*/ {
    return new iterator_range<EnumConstantDecl /*P*/ >(enumerator_begin(), enumerator_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::enumerator_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3113,
   FQN="clang::EnumDecl::enumerator_begin", NM="_ZNK5clang8EnumDecl16enumerator_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl16enumerator_beginEv")
  //</editor-fold>
  public specific_decl_iterator<EnumConstantDecl> enumerator_begin() /*const*/ {
    /*const*/ EnumDecl /*P*/ E = getDefinition();
    if (!(E != null)) {
      E = this;
    }
    return new specific_decl_iterator<EnumConstantDecl>(EnumConstantDecl.class, E.decls_begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::enumerator_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3120,
   FQN="clang::EnumDecl::enumerator_end", NM="_ZNK5clang8EnumDecl14enumerator_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl14enumerator_endEv")
  //</editor-fold>
  public specific_decl_iterator<EnumConstantDecl> enumerator_end() /*const*/ {
    /*const*/ EnumDecl /*P*/ E = getDefinition();
    if (!(E != null)) {
      E = this;
    }
    return new specific_decl_iterator<EnumConstantDecl>(EnumConstantDecl.class, E.decls_end());
  }

  
  /// getPromotionType - Return the integer type that enumerators
  /// should promote to.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getPromotionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3129,
   FQN="clang::EnumDecl::getPromotionType", NM="_ZNK5clang8EnumDecl16getPromotionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl16getPromotionTypeEv")
  //</editor-fold>
  public QualType getPromotionType() /*const*/ {
    return new QualType(PromotionType);
  }

  
  /// \brief Set the promotion type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setPromotionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3132,
   FQN="clang::EnumDecl::setPromotionType", NM="_ZN5clang8EnumDecl16setPromotionTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl16setPromotionTypeENS_8QualTypeE")
  //</editor-fold>
  public void setPromotionType(QualType T) {
    PromotionType.$assign(T);
  }

  
  /// getIntegerType - Return the integer type this enum decl corresponds to.
  /// This returns a null QualType for an enum forward definition with no fixed
  /// underlying type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3137,
   FQN="clang::EnumDecl::getIntegerType", NM="_ZNK5clang8EnumDecl14getIntegerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl14getIntegerTypeEv")
  //</editor-fold>
  public QualType getIntegerType() /*const*/ {
    if (!IntegerType.$bool()) {
      return new QualType();
    }
    {
      /*const*/ Type /*P*/ T = IntegerType.dyn_cast(/*const*/ Type /*P*/.class);
      if ((T != null)) {
        return new QualType(T, 0);
      }
    }
    return IntegerType.get(TypeSourceInfo /*P*/.class).getType().getUnqualifiedType();
  }

  
  /// \brief Set the underlying integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setIntegerType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3146,
   FQN="clang::EnumDecl::setIntegerType", NM="_ZN5clang8EnumDecl14setIntegerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl14setIntegerTypeENS_8QualTypeE")
  //</editor-fold>
  public void setIntegerType(QualType T) {
    IntegerType.$assign_T$C$R(Type /*P*/.class, T.getTypePtrOrNull());
  }

  
  /// \brief Set the underlying integer type source info.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setIntegerTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3149,
   FQN="clang::EnumDecl::setIntegerTypeSourceInfo", NM="_ZN5clang8EnumDecl24setIntegerTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl24setIntegerTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setIntegerTypeSourceInfo(TypeSourceInfo /*P*/ TInfo) {
    IntegerType.$assign_T1$C$R(TypeSourceInfo /*P*/.class, TInfo);
  }

  
  /// \brief Return the type source info for the underlying integer type,
  /// if no type source info exists, return 0.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getIntegerTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3153,
   FQN="clang::EnumDecl::getIntegerTypeSourceInfo", NM="_ZNK5clang8EnumDecl24getIntegerTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl24getIntegerTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getIntegerTypeSourceInfo() /*const*/ {
    return IntegerType.dyn_cast(TypeSourceInfo /*P*/.class);
  }

  
  /// \brief Retrieve the source range that covers the underlying type if
  /// specified.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getIntegerTypeRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3647,
   FQN="clang::EnumDecl::getIntegerTypeRange", NM="_ZNK5clang8EnumDecl19getIntegerTypeRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl19getIntegerTypeRangeEv")
  //</editor-fold>
  public SourceRange getIntegerTypeRange() /*const*//* __attribute__((pure))*/ {
    {
      /*const*/ TypeSourceInfo /*P*/ TI = getIntegerTypeSourceInfo();
      if ((TI != null)) {
        return TI.getTypeLoc().getSourceRange();
      }
    }
    return new SourceRange();
  }

  
  /// \brief Returns the width in bits required to store all the
  /// non-negative enumerators of this enum.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getNumPositiveBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3163,
   FQN="clang::EnumDecl::getNumPositiveBits", NM="_ZNK5clang8EnumDecl18getNumPositiveBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl18getNumPositiveBitsEv")
  //</editor-fold>
  public /*uint*/int getNumPositiveBits() /*const*/ {
    return $8bits_uint2uint(NumPositiveBits);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setNumPositiveBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3166,
   FQN="clang::EnumDecl::setNumPositiveBits", NM="_ZN5clang8EnumDecl18setNumPositiveBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl18setNumPositiveBitsEj")
  //</editor-fold>
  public void setNumPositiveBits(/*uint*/int Num) {
    NumPositiveBits = $uint2uint_8bits(Num);
    assert ($8bits_uint2uint(NumPositiveBits) == Num) : "can't store this bitcount";
  }

  
  /// \brief Returns the width in bits required to store all the
  /// negative enumerators of this enum.  These widths include
  /// the rightmost leading 1;  that is:
  ///
  /// MOST NEGATIVE ENUMERATOR     PATTERN     NUM NEGATIVE BITS
  /// ------------------------     -------     -----------------
  ///                       -1     1111111                     1
  ///                      -10     1110110                     5
  ///                     -101     1001011                     8
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getNumNegativeBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3180,
   FQN="clang::EnumDecl::getNumNegativeBits", NM="_ZNK5clang8EnumDecl18getNumNegativeBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl18getNumNegativeBitsEv")
  //</editor-fold>
  public /*uint*/int getNumNegativeBits() /*const*/ {
    return $8bits_uint2uint(NumNegativeBits);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setNumNegativeBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3183,
   FQN="clang::EnumDecl::setNumNegativeBits", NM="_ZN5clang8EnumDecl18setNumNegativeBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl18setNumNegativeBitsEj")
  //</editor-fold>
  public void setNumNegativeBits(/*uint*/int Num) {
    NumNegativeBits = $uint2uint_8bits(Num);
  }

  
  /// \brief Returns true if this is a C++11 scoped enumeration.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::isScoped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3188,
   FQN="clang::EnumDecl::isScoped", NM="_ZNK5clang8EnumDecl8isScopedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl8isScopedEv")
  //</editor-fold>
  public boolean isScoped() /*const*/ {
    return IsScoped;
  }

  
  /// \brief Returns true if this is a C++11 scoped enumeration.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::isScopedUsingClassTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3193,
   FQN="clang::EnumDecl::isScopedUsingClassTag", NM="_ZNK5clang8EnumDecl21isScopedUsingClassTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl21isScopedUsingClassTagEv")
  //</editor-fold>
  public boolean isScopedUsingClassTag() /*const*/ {
    return IsScopedUsingClassTag;
  }

  
  /// \brief Returns true if this is an Objective-C, C++11, or
  /// Microsoft-style enumeration with a fixed underlying type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::isFixed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3199,
   FQN="clang::EnumDecl::isFixed", NM="_ZNK5clang8EnumDecl7isFixedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl7isFixedEv")
  //</editor-fold>
  public boolean isFixed() /*const*/ {
    return IsFixed;
  }

  
  /// \brief Returns true if this can be considered a complete type.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::isComplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3204,
   FQN="clang::EnumDecl::isComplete", NM="_ZNK5clang8EnumDecl10isCompleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl10isCompleteEv")
  //</editor-fold>
  public boolean isComplete() /*const*/ {
    return isCompleteDefinition() || isFixed();
  }

  
  /// \brief Retrieve the enum definition from which this enumeration could
  /// be instantiated, if it is an instantiation (rather than a non-template).
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getTemplateInstantiationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3684,
   FQN="clang::EnumDecl::getTemplateInstantiationPattern", NM="_ZNK5clang8EnumDecl31getTemplateInstantiationPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl31getTemplateInstantiationPatternEv")
  //</editor-fold>
  public EnumDecl /*P*/ getTemplateInstantiationPattern() /*const*/ {
    {
      MemberSpecializationInfo /*P*/ MSInfo = getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        if (isTemplateInstantiation(MSInfo.getTemplateSpecializationKind())) {
          EnumDecl /*P*/ ED = getInstantiatedFromMemberEnum();
          {
            EnumDecl /*P*/ NewED;
            while (((/*P*/ NewED = ED.getInstantiatedFromMemberEnum()) != null)) {
              ED = NewED;
            }
          }
          return ED;
        }
      }
    }
    assert (!isTemplateInstantiation(getTemplateSpecializationKind())) : "couldn't find pattern for enum instantiation";
    return null;
  }

  
  /// \brief Returns the enumeration (declared within the template)
  /// from which this enumeration type was instantiated, or NULL if
  /// this enumeration was not instantiated from any template.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getInstantiatedFromMemberEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3699,
   FQN="clang::EnumDecl::getInstantiatedFromMemberEnum", NM="_ZNK5clang8EnumDecl29getInstantiatedFromMemberEnumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl29getInstantiatedFromMemberEnumEv")
  //</editor-fold>
  public EnumDecl /*P*/ getInstantiatedFromMemberEnum() /*const*/ {
    if ((SpecializationInfo != null)) {
      return cast_EnumDecl(SpecializationInfo.getInstantiatedFrom());
    }
    
    return null;
  }

  
  /// \brief If this enumeration is a member of a specialization of a
  /// templated class, determine what kind of template specialization
  /// or instantiation this is.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3666,
   FQN="clang::EnumDecl::getTemplateSpecializationKind", NM="_ZNK5clang8EnumDecl29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    {
      MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
      if ((MSI != null)) {
        return MSI.getTemplateSpecializationKind();
      }
    }
    
    return TemplateSpecializationKind.TSK_Undeclared;
  }

  
  /// \brief For an enumeration member that was instantiated from a member
  /// enumeration of a templated class, set the template specialiation kind.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3673,
   FQN="clang::EnumDecl::setTemplateSpecializationKind", NM="_ZN5clang8EnumDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    setTemplateSpecializationKind(TSK, 
                               new SourceLocation());
  }
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK, 
                               SourceLocation PointOfInstantiation/*= SourceLocation()*/) {
    MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
    assert ((MSI != null)) : "Not an instantiated member enumeration?";
    MSI.setTemplateSpecializationKind(TSK);
    if (TSK != TemplateSpecializationKind.TSK_ExplicitSpecialization
       && PointOfInstantiation.isValid()
       && MSI.getPointOfInstantiation().isInvalid()) {
      MSI.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
    }
  }

  
  /// \brief If this enumeration is an instantiation of a member enumeration of
  /// a class template specialization, retrieves the member specialization
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::getMemberSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3230,
   FQN="clang::EnumDecl::getMemberSpecializationInfo", NM="_ZNK5clang8EnumDecl27getMemberSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8EnumDecl27getMemberSpecializationInfoEv")
  //</editor-fold>
  public MemberSpecializationInfo /*P*/ getMemberSpecializationInfo() /*const*/ {
    return SpecializationInfo;
  }

  
  /// \brief Specify that this enumeration is an instantiation of the
  /// member enumeration ED.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::setInstantiationOfMemberEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3236,
   FQN="clang::EnumDecl::setInstantiationOfMemberEnum", NM="_ZN5clang8EnumDecl28setInstantiationOfMemberEnumEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl28setInstantiationOfMemberEnumEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setInstantiationOfMemberEnum(EnumDecl /*P*/ ED, 
                              TemplateSpecializationKind TSK) {
    setInstantiationOfMemberEnum(getASTContext(), ED, TSK);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3241,
   FQN="clang::EnumDecl::classof", NM="_ZN5clang8EnumDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3242,
   FQN="clang::EnumDecl::classofKind", NM="_ZN5clang8EnumDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Enum;
  }

  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnumDecl::~EnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3013,
   FQN="clang::EnumDecl::~EnumDecl", NM="_ZN5clang8EnumDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8EnumDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IntegerType=" + IntegerType // NOI18N
              + ", PromotionType=" + PromotionType // NOI18N
              + ", SpecializationInfo=" + SpecializationInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
