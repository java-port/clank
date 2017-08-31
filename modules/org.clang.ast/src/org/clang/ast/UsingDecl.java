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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.UsingDecl.shadow_iterator.*;


/// \brief Represents a C++ using-declaration.
///
/// For example:
/// \code
///    using someNameSpace::someIdentifier;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::UsingDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3039,
 FQN="clang::UsingDecl", NM="_ZN5clang9UsingDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDeclE")
//</editor-fold>
public class UsingDecl extends /*public*/ NamedDecl implements /*public*/ Mergeable<UsingDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2204,
   FQN="clang::UsingDecl::anchor", NM="_ZN5clang9UsingDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The source location of the 'using' keyword itself.
  private SourceLocation UsingLocation;
  
  /// \brief The nested-name-specifier that precedes the name.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief Provides source/type location info for the declaration name
  /// embedded in the ValueDecl base class.
  /*friend*/public DeclarationNameLoc DNLoc;
  
  /// \brief The first shadow declaration of the shadow decl chain associated
  /// with this using declaration.
  ///
  /// The bool member of the pair store whether this decl has the \c typename
  /// keyword.
  /*friend*/public PointerBoolPair<UsingShadowDecl /*P*/ > FirstUsingShadow;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::UsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3059,
   FQN="clang::UsingDecl::UsingDecl", NM="_ZN5clang9UsingDeclC1EPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDeclC1EPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEb")
  //</editor-fold>
  private UsingDecl(DeclContext /*P*/ DC, SourceLocation UL, 
      NestedNameSpecifierLoc QualifierLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, boolean HasTypenameKeyword) {
    // : NamedDecl(Using, DC, NameInfo.getLoc(), NameInfo.getName()), Mergeable<UsingDecl>(), UsingLocation(UL), QualifierLoc(QualifierLoc), DNLoc(NameInfo.getInfo()), FirstUsingShadow(null, HasTypenameKeyword) 
    //START JInit
    super(Kind.Using, DC, NameInfo.getLoc(), NameInfo.getName());
    $Mergeable();
    this.UsingLocation = new SourceLocation(UL);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.DNLoc = new DeclarationNameLoc(NameInfo.getInfo$Const());
    this.FirstUsingShadow = new PointerBoolPair<UsingShadowDecl /*P*/ >((UsingShadowDecl /*P*/ )null, HasTypenameKeyword);
    //END JInit
  }

/*public:*/
  /// \brief Return the source location of the 'using' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3069,
   FQN="clang::UsingDecl::getUsingLoc", NM="_ZNK5clang9UsingDecl11getUsingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl11getUsingLocEv")
  //</editor-fold>
  public SourceLocation getUsingLoc() /*const*/ {
    return new SourceLocation(UsingLocation);
  }

  
  /// \brief Set the source location of the 'using' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::setUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3072,
   FQN="clang::UsingDecl::setUsingLoc", NM="_ZN5clang9UsingDecl11setUsingLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl11setUsingLocENS_14SourceLocationE")
  //</editor-fold>
  public void setUsingLoc(SourceLocation L) {
    UsingLocation.$assign(L);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name,
  /// with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3076,
   FQN="clang::UsingDecl::getQualifierLoc", NM="_ZNK5clang9UsingDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3079,
   FQN="clang::UsingDecl::getQualifier", NM="_ZNK5clang9UsingDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3083,
   FQN="clang::UsingDecl::getNameInfo", NM="_ZNK5clang9UsingDecl11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl11getNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getNameInfo() /*const*/ {
    return new DeclarationNameInfo(getDeclName(), getLocation(), new DeclarationNameLoc(DNLoc));
  }

  
  /// \brief Return true if it is a C++03 access declaration (no 'using').
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::isAccessDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3088,
   FQN="clang::UsingDecl::isAccessDeclaration", NM="_ZNK5clang9UsingDecl19isAccessDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl19isAccessDeclarationEv")
  //</editor-fold>
  public boolean isAccessDeclaration() /*const*/ {
    return UsingLocation.isInvalid();
  }

  
  /// \brief Return true if the using declaration has 'typename'.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::hasTypename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3091,
   FQN="clang::UsingDecl::hasTypename", NM="_ZNK5clang9UsingDecl11hasTypenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl11hasTypenameEv")
  //</editor-fold>
  public boolean hasTypename() /*const*/ {
    return FirstUsingShadow.getInt();
  }

  
  /// \brief Sets whether the using declaration has 'typename'.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::setTypename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3094,
   FQN="clang::UsingDecl::setTypename", NM="_ZN5clang9UsingDecl11setTypenameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl11setTypenameEb")
  //</editor-fold>
  public void setTypename(boolean TN) {
    FirstUsingShadow.setInt(TN);
  }

  
  /// \brief Iterates through the using shadow declarations associated with
  /// this using declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3098,
   FQN="clang::UsingDecl::shadow_iterator", NM="_ZN5clang9UsingDecl15shadow_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorE")
  //</editor-fold>
  public static class shadow_iterator implements type$iterator<shadow_iterator, UsingShadowDecl> {
    /// \brief The current using shadow declaration.
    private UsingShadowDecl /*P*/ Current;
  /*public:*/
    /*typedef UsingShadowDecl *value_type*/
//    public final class value_type extends UsingShadowDecl /*P*/ { };
    /*typedef UsingShadowDecl *reference*/
//    public final class reference extends UsingShadowDecl /*P*/ { };
    /*typedef UsingShadowDecl *pointer*/
//    public final class pointer extends UsingShadowDecl /*P*/ { };
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    /*typedef std::ptrdiff_t difference_type*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::shadow_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3109,
     FQN="clang::UsingDecl::shadow_iterator::shadow_iterator", NM="_ZN5clang9UsingDecl15shadow_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorC1Ev")
    //</editor-fold>
    public shadow_iterator() {
      // : Current(null) 
      //START JInit
      this.Current = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::shadow_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3110,
     FQN="clang::UsingDecl::shadow_iterator::shadow_iterator", NM="_ZN5clang9UsingDecl15shadow_iteratorC1EPNS_15UsingShadowDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorC1EPNS_15UsingShadowDeclE")
    //</editor-fold>
    public /*explicit*/ shadow_iterator(UsingShadowDecl /*P*/ C) {
      // : Current(C) 
      //START JInit
      this.Current = C;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3112,
     FQN="clang::UsingDecl::shadow_iterator::operator*", NM="_ZNK5clang9UsingDecl15shadow_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl15shadow_iteratordeEv")
    //</editor-fold>
    public UsingShadowDecl /*P*/ $star() /*const*/ {
      return Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3113,
     FQN="clang::UsingDecl::shadow_iterator::operator->", NM="_ZNK5clang9UsingDecl15shadow_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl15shadow_iteratorptEv")
    //</editor-fold>
    public UsingShadowDecl /*P*/ $arrow() /*const*/ {
      return Current;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3115,
     FQN="clang::UsingDecl::shadow_iterator::operator++", NM="_ZN5clang9UsingDecl15shadow_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorppEv")
    //</editor-fold>
    public shadow_iterator /*&*/ $preInc() {
      Current = Current.getNextUsingShadowDecl();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3120,
     FQN="clang::UsingDecl::shadow_iterator::operator++", NM="_ZN5clang9UsingDecl15shadow_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorppEi")
    //</editor-fold>
    public shadow_iterator $postInc(int $Prm0) {
      shadow_iterator tmp/*J*/= new shadow_iterator(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3126,
     FQN="clang::operator==", NM="_ZN5clangeqENS_9UsingDecl15shadow_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clangeqENS_9UsingDecl15shadow_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_shadow_iterator(shadow_iterator x, shadow_iterator y) {
      return x.Current == y.Current;
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3129,
     FQN="clang::operator!=", NM="_ZN5clangneENS_9UsingDecl15shadow_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clangneENS_9UsingDecl15shadow_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_shadow_iterator(shadow_iterator x, shadow_iterator y) {
      return x.Current != y.Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::shadow_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3098,
     FQN="clang::UsingDecl::shadow_iterator::shadow_iterator", NM="_ZN5clang9UsingDecl15shadow_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ shadow_iterator(final /*const*/ shadow_iterator /*&*/ $Prm0) {
      // : Current(.Current) 
      //START JInit
      this.Current = $Prm0.Current;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_iterator::shadow_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3098,
     FQN="clang::UsingDecl::shadow_iterator::shadow_iterator", NM="_ZN5clang9UsingDecl15shadow_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl15shadow_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ shadow_iterator(JD$Move _dparam, final shadow_iterator /*&&*/$Prm0) {
      // : Current(static_cast<shadow_iterator &&>().Current) 
      //START JInit
      this.Current = $Prm0.Current;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override 
    public shadow_iterator clone() { 
      return new shadow_iterator(this); 
    }

    @Override
    public boolean $eq(Object other) {
      return $eq_shadow_iterator(this, (shadow_iterator) other);
    }

    @Override
    public boolean $noteq(Object other) {
      return $noteq_shadow_iterator(this, (shadow_iterator) other);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current; // NOI18N
    }
  };
  
  /*typedef llvm::iterator_range<shadow_iterator> shadow_range*/
//  public final class shadow_range extends iterator_range<UsingShadowDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadows">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3136,
   FQN="clang::UsingDecl::shadows", NM="_ZNK5clang9UsingDecl7shadowsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl7shadowsEv")
  //</editor-fold>
  public iterator_range<UsingShadowDecl /*P*/ > shadows() /*const*/ {
    return new iterator_range<UsingShadowDecl /*P*/ >(shadow_begin(), shadow_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3139,
   FQN="clang::UsingDecl::shadow_begin", NM="_ZNK5clang9UsingDecl12shadow_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl12shadow_beginEv")
  //</editor-fold>
  public shadow_iterator shadow_begin() /*const*/ {
    return new shadow_iterator(FirstUsingShadow.getPointer());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3142,
   FQN="clang::UsingDecl::shadow_end", NM="_ZNK5clang9UsingDecl10shadow_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl10shadow_endEv")
  //</editor-fold>
  public shadow_iterator shadow_end() /*const*/ {
    return new shadow_iterator();
  }

  
  /// \brief Return the number of shadowed declarations associated with this
  /// using declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::shadow_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3146,
   FQN="clang::UsingDecl::shadow_size", NM="_ZNK5clang9UsingDecl11shadow_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl11shadow_sizeEv")
  //</editor-fold>
  public /*uint*/int shadow_size() /*const*/ {
    return std.distance(shadow_begin(), shadow_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::addShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2206,
   FQN="clang::UsingDecl::addShadowDecl", NM="_ZN5clang9UsingDecl13addShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl13addShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public void addShadowDecl(UsingShadowDecl /*P*/ S) {
    assert ($eq_shadow_iterator(std.find(shadow_begin(), shadow_end(), S, true), shadow_end())) : "declaration already in set";
    assert (S.getUsingDecl() == this);
    if ((FirstUsingShadow.getPointer() != null)) {
      S.UsingOrNextShadow = FirstUsingShadow.getPointer();
    }
    FirstUsingShadow.setPointer(S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::removeShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2216,
   FQN="clang::UsingDecl::removeShadowDecl", NM="_ZN5clang9UsingDecl16removeShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl16removeShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public void removeShadowDecl(UsingShadowDecl /*P*/ S) {
    assert ($noteq_shadow_iterator(std.find(shadow_begin(), shadow_end(), S, true), shadow_end())) : "declaration not in set";
    assert (S.getUsingDecl() == this);
    
    // Remove S from the shadow decl chain. This is O(n) but hopefully rare.
    if (FirstUsingShadow.getPointer() == S) {
      FirstUsingShadow.setPointer(dyn_cast_UsingShadowDecl(S.UsingOrNextShadow));
      S.UsingOrNextShadow = this;
      return;
    }
    
    UsingShadowDecl /*P*/ Prev = FirstUsingShadow.getPointer();
    while (Prev.UsingOrNextShadow != S) {
      Prev = cast_UsingShadowDecl(Prev.UsingOrNextShadow);
    }
    Prev.UsingOrNextShadow = S.UsingOrNextShadow;
    S.UsingOrNextShadow = this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2237,
   FQN="clang::UsingDecl::Create", NM="_ZN5clang9UsingDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEb")
  //</editor-fold>
  public static UsingDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation UL, 
        NestedNameSpecifierLoc QualifierLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        boolean HasTypename) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new UsingDecl(DC, new SourceLocation(UL), new NestedNameSpecifierLoc(QualifierLoc), NameInfo, HasTypename);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2244,
   FQN="clang::UsingDecl::CreateDeserialized", NM="_ZN5clang9UsingDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static UsingDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new UsingDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new NestedNameSpecifierLoc(), new DeclarationNameInfo(), 
                false);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2250,
   FQN="clang::UsingDecl::getSourceRange", NM="_ZNK5clang9UsingDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation Begin = isAccessDeclaration() ? getQualifierLoc().getBeginLoc() : new SourceLocation(UsingLocation);
    return new SourceRange(/*NO_COPY*/Begin, getNameInfo().getEndLoc());
  }

  
  /// Retrieves the canonical declaration of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3164,
   FQN="clang::UsingDecl::getCanonicalDecl", NM="_ZN5clang9UsingDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public UsingDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3165,
   FQN="clang::UsingDecl::getCanonicalDecl", NM="_ZNK5clang9UsingDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang9UsingDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ UsingDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3167,
   FQN="clang::UsingDecl::classof", NM="_ZN5clang9UsingDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3168,
   FQN="clang::UsingDecl::classofKind", NM="_ZN5clang9UsingDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Using;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDecl::~UsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3039,
   FQN="clang::UsingDecl::~UsingDecl", NM="_ZN5clang9UsingDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang9UsingDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final UsingDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ UsingDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends UsingDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "UsingLocation=" + UsingLocation // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", DNLoc=" + DNLoc // NOI18N
              + ", FirstUsingShadow=" + FirstUsingShadow // NOI18N
              + super.toString(); // NOI18N
  }
}
