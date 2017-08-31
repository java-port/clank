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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.java.std;


/// FriendDecl - Represents the declaration of a friend entity,
/// which can be a function, a type, or a templated function or type.
//  For example:
///
/// @code
/// template <typename T> class A {
///   friend int foo(T);
///   friend class B;
///   friend T; // only in C++0x
///   template <typename U> friend class C;
///   template <typename U> friend A& operator+=(A&, const U&) { ... }
/// };
/// @endcode
///
/// The semantic context of a friend decl is its declaring class.
//<editor-fold defaultstate="collapsed" desc="clang::FriendDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 40,
 FQN="clang::FriendDecl", NM="_ZN5clang10FriendDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDeclE")
//</editor-fold>
public final class FriendDecl extends /*public*/ Decl implements /*private*/ TrailingObjects<FriendDecl, TemplateParameterList /*P*/ >, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp", line = 20,
   FQN="clang::FriendDecl::anchor", NM="_ZN5clang10FriendDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  /*typedef llvm::PointerUnion<NamedDecl *, TypeSourceInfo *> FriendUnion*/
//  public final class FriendUnion extends PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >{ };
/*private:*/
  // The declaration that's a friend of this class.
  /*friend*/public PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend;
  
  // A pointer to the next friend in the sequence.
  public/*private*/ LazyDeclPtr NextFriend;
  
  // Location of the 'friend' specifier.
  /*friend*/public SourceLocation FriendLoc;
  
  /// True if this 'friend' declaration is unsupported.  Eventually we
  /// will support every possible friend declaration, but for now we
  /// silently ignore some and set this flag to authorize all access.
  /*friend*/public /*JBIT unsigned int*/ boolean UnsupportedFriend /*: 1*/;
  
  // The number of "outer" template parameter lists in non-templatic
  // (currently unsupported) friend type declarations, such as
  //     template <class T> friend class A<T>::B;
  /*friend*/public /*uint*/int NumTPLists /*: 31*/;
  
  /*friend  class CXXRecordDecl::friend_iterator*/
  /*friend  class CXXRecordDecl*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::FriendDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 70,
   FQN="clang::FriendDecl::FriendDecl", NM="_ZN5clang10FriendDeclC1EPNS_11DeclContextENS_14SourceLocationEN4llvm12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES3_NS4_8ArrayRefIPNS_21TemplateParameterListEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDeclC1EPNS_11DeclContextENS_14SourceLocationEN4llvm12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES3_NS4_8ArrayRefIPNS_21TemplateParameterListEEE")
  //</editor-fold>
  private FriendDecl(DeclContext /*P*/ DC, SourceLocation L, PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend, 
      SourceLocation FriendL, 
      ArrayRef<TemplateParameterList /*P*/ > FriendTypeTPLists) {
    // : Decl(Decl::Friend, DC, L), TrailingObjects<FriendDecl, TemplateParameterList * >(), Friend(Friend), NextFriend(), FriendLoc(FriendL), UnsupportedFriend(false), NumTPLists(FriendTypeTPLists.size()) 
    //START JInit
    super(Decl.Kind.Friend, DC, new SourceLocation(L));
    $TrailingObjects();
    this.Friend = new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(Friend);
    this.NextFriend = new LazyDeclPtr();
    this.FriendLoc = new SourceLocation(FriendL);
    this.UnsupportedFriend = false;
    this.NumTPLists = FriendTypeTPLists.size();
    //END JInit
    for (/*uint*/int i = 0; $less_uint(i, NumTPLists); ++i)  {
      this.<TemplateParameterList /*P*/>getTrailingObjects(TemplateParameterList.class).$set(i, FriendTypeTPLists.$at(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::FriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 83,
   FQN="clang::FriendDecl::FriendDecl", NM="_ZN5clang10FriendDeclC1ENS_4Decl10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDeclC1ENS_4Decl10EmptyShellEj")
  //</editor-fold>
  private FriendDecl(EmptyShell Empty, /*uint*/int NumFriendTypeTPLists) {
    // : Decl(Decl::Friend, Empty), TrailingObjects<FriendDecl, TemplateParameterList * >(), Friend(), NextFriend(), FriendLoc(), NumTPLists(NumFriendTypeTPLists) 
    //START JInit
    super(Decl.Kind.Friend, new EmptyShell(Empty));
    $TrailingObjects();
    this.Friend = new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(NamedDecl /*P*/ .class);
    this.NextFriend = new LazyDeclPtr();
    this.FriendLoc = new SourceLocation();
    this.NumTPLists = NumFriendTypeTPLists;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getNextFriend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 87,
   FQN="clang::FriendDecl::getNextFriend", NM="_ZN5clang10FriendDecl13getNextFriendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl13getNextFriendEv")
  //</editor-fold>
  public/*private*/ FriendDecl /*P*/ getNextFriend() {
    if (!NextFriend.isOffset()) {
      return cast_or_null_FriendDecl(NextFriend.get((ExternalASTSource /*P*/ )null));
    }
    return getNextFriendSlowCase();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getNextFriendSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp", line = 22,
   FQN="clang::FriendDecl::getNextFriendSlowCase", NM="_ZN5clang10FriendDecl21getNextFriendSlowCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl21getNextFriendSlowCaseEv")
  //</editor-fold>
  private FriendDecl /*P*/ getNextFriendSlowCase() {
    return cast_or_null_FriendDecl(NextFriend.get(getASTContext().getExternalSource()));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp", line = 27,
   FQN="clang::FriendDecl::Create", NM="_ZN5clang10FriendDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES5_NS6_8ArrayRefIPNS_21TemplateParameterListEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES5_NS6_8ArrayRefIPNS_21TemplateParameterListEEE")
  //</editor-fold>
  public static FriendDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend, 
        SourceLocation FriendL) {
    return Create(C, DC, 
        L, 
        Friend, 
        FriendL, 
        new ArrayRef<TemplateParameterList /*P*/ >(None, true));
  }
  public static FriendDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend, 
        SourceLocation FriendL, 
        ArrayRef<TemplateParameterList /*P*/ > FriendTypeTPLists/*= None*/) {
    if ((Friend.is(NamedDecl /*P*/.class) != 0)) {
      NamedDecl /*P*/ D = Friend.get(NamedDecl /*P*/.class);
      assert (isa_FunctionDecl(D) || isa_CXXRecordDecl(D) || isa_FunctionTemplateDecl(D) || isa_ClassTemplateDecl(D));
      
      // As a temporary hack, we permit template instantiation to point
      // to the original declaration when instantiating members.
      assert ((D.getFriendObjectKind().getValue() != 0) || ((cast_CXXRecordDecl(DC).getTemplateSpecializationKind()).getValue() != 0));
      // These template parameters are for friend types only.
      assert (FriendTypeTPLists.size() == 0);
    }
    
    /*uint*/int Extra = TrailingObjects.additionalSizeToAlloc$Same(TemplateParameterList/*P*/.class, FriendTypeTPLists.size());
    FriendDecl /*P*/ FD = /*NEW_EXPR [Decl::new]*//*new (C, DC, Extra)*/ Decl.$new(C, DC, Extra, (type$ptr<?> Mem)->{
        return new FriendDecl(DC, new SourceLocation(L), new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(Friend), new SourceLocation(FriendL), 
                new ArrayRef<TemplateParameterList /*P*/ >(FriendTypeTPLists));
     },
        new std.pairIntPtr<>(Extra, ()->null) // for TemplateParameterList *
    );
    cast_CXXRecordDecl(DC).pushFriendDecl(FD);
    return FD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp", line = 58,
   FQN="clang::FriendDecl::CreateDeserialized", NM="_ZN5clang10FriendDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static FriendDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int FriendTypeNumTPLists) {
    /*uint*/int Extra = TrailingObjects.additionalSizeToAlloc$Same(TemplateParameterList/*P*/.class, FriendTypeNumTPLists);
    return /*NEW_EXPR [Decl::new]*//*new (C, ID, Extra)*/ Decl.$new(C, ID, Extra, (type$ptr<?> Mem)->{
        return new FriendDecl(new EmptyShell(), FriendTypeNumTPLists);
     }, 
        new std.pairIntPtr<>(Extra, ()->null) // for TemplateParameterList *
    );
  }

  
  /// If this friend declaration names an (untemplated but possibly
  /// dependent) type, return the type; otherwise return null.  This
  /// is used for elaborated-type-specifiers and, in C++0x, for
  /// arbitrary friend type declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getFriendType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 107,
   FQN="clang::FriendDecl::getFriendType", NM="_ZNK5clang10FriendDecl13getFriendTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl13getFriendTypeEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getFriendType() /*const*/ {
    return Friend.dyn_cast(TypeSourceInfo /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getFriendTypeNumTemplateParameterLists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 110,
   FQN="clang::FriendDecl::getFriendTypeNumTemplateParameterLists", NM="_ZNK5clang10FriendDecl38getFriendTypeNumTemplateParameterListsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl38getFriendTypeNumTemplateParameterListsEv")
  //</editor-fold>
  public /*uint*/int getFriendTypeNumTemplateParameterLists() /*const*/ {
    return NumTPLists;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getFriendTypeTemplateParameterList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 113,
   FQN="clang::FriendDecl::getFriendTypeTemplateParameterList", NM="_ZNK5clang10FriendDecl34getFriendTypeTemplateParameterListEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl34getFriendTypeTemplateParameterListEj")
  //</editor-fold>
  public TemplateParameterList /*P*/ getFriendTypeTemplateParameterList(/*uint*/int N) /*const*/ {
    assert ($less_uint(N, NumTPLists));
    return this.<TemplateParameterList /*P*/ >getTrailingObjects$Const(TemplateParameterList.class).$at(N);
  }

  
  /// If this friend declaration doesn't name a type, return the inner
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 120,
   FQN="clang::FriendDecl::getFriendDecl", NM="_ZNK5clang10FriendDecl13getFriendDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl13getFriendDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFriendDecl() /*const*/ {
    return Friend.dyn_cast(NamedDecl /*P*/.class);
  }

  
  /// Retrieves the location of the 'friend' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getFriendLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 125,
   FQN="clang::FriendDecl::getFriendLoc", NM="_ZNK5clang10FriendDecl12getFriendLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl12getFriendLocEv")
  //</editor-fold>
  public SourceLocation getFriendLoc() /*const*/ {
    return new SourceLocation(FriendLoc);
  }

  
  /// Retrieves the source range for the friend declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::getSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 130,
   FQN="clang::FriendDecl::getSourceRange", NM="_ZNK5clang10FriendDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    {
      NamedDecl /*P*/ ND = getFriendDecl();
      if ((ND != null)) {
        {
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
          if ((FD != null)) {
            return FD.getSourceRange();
          }
        }
        {
          FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ND);
          if ((FTD != null)) {
            return FTD.getSourceRange();
          }
        }
        {
          ClassTemplateDecl /*P*/ CTD = dyn_cast_ClassTemplateDecl(ND);
          if ((CTD != null)) {
            return CTD.getSourceRange();
          }
        }
        {
          DeclaratorDecl /*P*/ DD = dyn_cast_DeclaratorDecl(ND);
          if ((DD != null)) {
            if ($noteq_SourceLocation$C(DD.getOuterLocStart(), DD.getInnerLocStart())) {
              return DD.getSourceRange();
            }
          }
        }
        return new SourceRange(getFriendLoc(), ND.getLocEnd());
      } else {
        TypeSourceInfo /*P*/ TInfo = getFriendType();
        if ((TInfo != null)) {
          SourceLocation StartL = (NumTPLists == $int2uint_31bits(0)) ? getFriendLoc() : this.<TemplateParameterList /*P*/ >getTrailingObjects$Const(TemplateParameterList.class).$at(0).
              getTemplateLoc();
          return new SourceRange(/*NO_COPY*/StartL, TInfo.getTypeLoc().getEndLoc());
        } else {
          return new SourceRange(getFriendLoc(), getLocation());
        }
      }
    }
  }

  
  /// Determines if this friend kind is unsupported.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::isUnsupportedFriend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 156,
   FQN="clang::FriendDecl::isUnsupportedFriend", NM="_ZNK5clang10FriendDecl19isUnsupportedFriendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang10FriendDecl19isUnsupportedFriendEv")
  //</editor-fold>
  public boolean isUnsupportedFriend() /*const*/ {
    return UnsupportedFriend;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::setUnsupportedFriend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 159,
   FQN="clang::FriendDecl::setUnsupportedFriend", NM="_ZN5clang10FriendDecl20setUnsupportedFriendEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl20setUnsupportedFriendEb")
  //</editor-fold>
  public void setUnsupportedFriend(boolean Unsupported) {
    UnsupportedFriend = Unsupported;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 164,
   FQN="clang::FriendDecl::classof", NM="_ZN5clang10FriendDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 165,
   FQN="clang::FriendDecl::classofKind", NM="_ZN5clang10FriendDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Decl.Kind.Friend;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  /*friend  TrailingObjects<FriendDecl, TemplateParameterList *>*/
  //<editor-fold defaultstate="collapsed" desc="clang::FriendDecl::~FriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 40,
   FQN="clang::FriendDecl::~FriendDecl", NM="_ZN5clang10FriendDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZN5clang10FriendDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  @Override
  public type$ptr<?> $TrailingObjects() {
    return $This$Ptr().$add(1); // skip this class
  }
  
  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == TemplateParameterList.class : "unexpected class " + clazz;
    return 0;
  }
  
  @Override public String toString() {
    return "" + "Friend=" + Friend // NOI18N
              + ", NextFriend=" + NextFriend // NOI18N
              + ", FriendLoc=" + FriendLoc // NOI18N
              + ", UnsupportedFriend=" + UnsupportedFriend // NOI18N
              + ", NumTPLists=" + NumTPLists // NOI18N
              + super.toString(); // NOI18N
  }
}
