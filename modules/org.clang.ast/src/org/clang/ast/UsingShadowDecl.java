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
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Represents a shadow declaration introduced into a scope by a
/// (resolved) using declaration.
///
/// For example,
/// \code
/// namespace A {
///   void foo();
/// }
/// namespace B {
///   using A::foo; // <- a UsingDecl
///                 // Also creates a UsingShadowDecl for A::foo() in B
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2835,
 FQN="clang::UsingShadowDecl", NM="_ZN5clang15UsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDeclE")
//</editor-fold>
public class UsingShadowDecl extends /*public*/ NamedDecl implements /*public*/ Redeclarable<UsingShadowDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2155,
   FQN="clang::UsingShadowDecl::anchor", NM="_ZN5clang15UsingShadowDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// The referenced declaration.
  protected/*private*/ NamedDecl /*P*/ Underlying;
  
  /// \brief The using declaration which introduced this decl or the next using
  /// shadow declaration contained in the aforementioned using declaration.
  /*friend*/public/*private*/ NamedDecl /*P*/ UsingOrNextShadow;
  /*friend  class UsingDecl*/
  
  /*typedef Redeclarable<UsingShadowDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<UsingShadowDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2847,
   FQN="clang::UsingShadowDecl::getNextRedeclarationImpl", NM="_ZN5clang15UsingShadowDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ UsingShadowDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2850,
   FQN="clang::UsingShadowDecl::getPreviousDeclImpl", NM="_ZN5clang15UsingShadowDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ UsingShadowDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2853,
   FQN="clang::UsingShadowDecl::getMostRecentDeclImpl", NM="_ZN5clang15UsingShadowDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ UsingShadowDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::UsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2157,
   FQN="clang::UsingShadowDecl::UsingShadowDecl", NM="_ZN5clang15UsingShadowDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclE")
  //</editor-fold>
  protected UsingShadowDecl(Kind K, final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation Loc, UsingDecl /*P*/ Using, 
      NamedDecl /*P*/ Target) {
    // : NamedDecl(K, DC, Loc, Using ? Using->getDeclName() : DeclarationName()), redeclarable_base(C), Underlying(Target), UsingOrNextShadow(cast<NamedDecl>(Using)) 
    //START JInit
    super(K, DC, new SourceLocation(Loc), (Using != null) ? Using.getDeclName() : new DeclarationName());
    this.Redeclarable$Flds = $Redeclarable(C);
    this.Underlying = Target;
    this.UsingOrNextShadow = cast_NamedDecl(Using);
    //END JInit
    if ((Target != null)) {
      IdentifierNamespace_field = $uint2uint_13bits(Target.getIdentifierNamespace());
    }
    setImplicit();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::UsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2168,
   FQN="clang::UsingShadowDecl::UsingShadowDecl", NM="_ZN5clang15UsingShadowDeclC1ENS_4Decl4KindERNS_10ASTContextENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDeclC1ENS_4Decl4KindERNS_10ASTContextENS1_10EmptyShellE")
  //</editor-fold>
  protected UsingShadowDecl(Kind K, final ASTContext /*&*/ C, EmptyShell Empty) {
    // : NamedDecl(K, null, SourceLocation(), DeclarationName()), redeclarable_base(C), Underlying(implicit NamedDecl * ()), UsingOrNextShadow(implicit NamedDecl * ()) 
    //START JInit
    super(K, (DeclContext /*P*/ )null, new SourceLocation(), new DeclarationName());
    this.Redeclarable$Flds = $Redeclarable(C);
    this.Underlying = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
    this.UsingOrNextShadow = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2863,
   FQN="clang::UsingShadowDecl::Create", NM="_ZN5clang15UsingShadowDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public static UsingShadowDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation Loc, UsingDecl /*P*/ Using, 
        NamedDecl /*P*/ Target) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new UsingShadowDecl(Kind.UsingShadow, C, DC, new SourceLocation(Loc), Using, Target);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2172,
   FQN="clang::UsingShadowDecl::CreateDeserialized", NM="_ZN5clang15UsingShadowDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static UsingShadowDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new UsingShadowDecl(Kind.UsingShadow, C, new EmptyShell());
     });
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<redecl_iterator>{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<UsingShadowDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<UsingShadowDecl>::redecls_begin;
  //JAVA: using Redeclarable<UsingShadowDecl>::redecls_end;
  //JAVA: using Redeclarable<UsingShadowDecl>::redecls;
  //JAVA: using Redeclarable<UsingShadowDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<UsingShadowDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<UsingShadowDecl>::isFirstDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2880,
   FQN="clang::UsingShadowDecl::getCanonicalDecl", NM="_ZN5clang15UsingShadowDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public UsingShadowDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2883,
   FQN="clang::UsingShadowDecl::getCanonicalDecl", NM="_ZNK5clang15UsingShadowDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15UsingShadowDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ UsingShadowDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  /// \brief Gets the underlying declaration which has been brought into the
  /// local scope.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getTargetDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2889,
   FQN="clang::UsingShadowDecl::getTargetDecl", NM="_ZNK5clang15UsingShadowDecl13getTargetDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15UsingShadowDecl13getTargetDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getTargetDecl() /*const*/ {
    return Underlying;
  }

  
  /// \brief Sets the underlying declaration which has been brought into the
  /// local scope.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::setTargetDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2893,
   FQN="clang::UsingShadowDecl::setTargetDecl", NM="_ZN5clang15UsingShadowDecl13setTargetDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl13setTargetDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void setTargetDecl(NamedDecl /*P*/ ND) {
    assert ((ND != null)) : "Target decl is null!";
    Underlying = ND;
    IdentifierNamespace_field = $uint2uint_13bits(ND.getIdentifierNamespace());
  }

  
  /// \brief Gets the using declaration to which this declaration is tied.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2177,
   FQN="clang::UsingShadowDecl::getUsingDecl", NM="_ZNK5clang15UsingShadowDecl12getUsingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15UsingShadowDecl12getUsingDeclEv")
  //</editor-fold>
  public UsingDecl /*P*/ getUsingDecl() /*const*/ {
    /*const*/ UsingShadowDecl /*P*/ Shadow = this;
    {
      /*const*/ UsingShadowDecl /*P*/ NextShadow;
      while (((/*P*/ NextShadow = dyn_cast_UsingShadowDecl(Shadow.UsingOrNextShadow)) != null)) {
        Shadow = NextShadow;
      }
    }
    return cast_UsingDecl(Shadow.UsingOrNextShadow);
  }

  
  /// \brief The next using shadow declaration contained in the shadow decl
  /// chain of the using declaration which introduced this decl.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::getNextUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2904,
   FQN="clang::UsingShadowDecl::getNextUsingShadowDecl", NM="_ZNK5clang15UsingShadowDecl22getNextUsingShadowDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15UsingShadowDecl22getNextUsingShadowDeclEv")
  //</editor-fold>
  public UsingShadowDecl /*P*/ getNextUsingShadowDecl() /*const*/ {
    return dyn_cast_or_null_UsingShadowDecl(UsingOrNextShadow);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2908,
   FQN="clang::UsingShadowDecl::classof", NM="_ZN5clang15UsingShadowDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2909,
   FQN="clang::UsingShadowDecl::classofKind", NM="_ZN5clang15UsingShadowDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Decl.Kind.UsingShadow || K == Decl.Kind.ConstructorUsingShadow;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::UsingShadowDecl::~UsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2835,
   FQN="clang::UsingShadowDecl::~UsingShadowDecl", NM="_ZN5clang15UsingShadowDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15UsingShadowDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final UsingShadowDecl getPreviousDecl() { 
    return (UsingShadowDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final UsingShadowDecl getPreviousDecl$Const() { 
    return (UsingShadowDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final UsingShadowDecl getMostRecentDecl() { 
    return (UsingShadowDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final UsingShadowDecl getMostRecentDecl$Const() { 
    return (UsingShadowDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "Underlying=" + Underlying // NOI18N
              + ", UsingOrNextShadow=" + UsingOrNextShadow // NOI18N
              + super.toString(); // NOI18N
  }
}
