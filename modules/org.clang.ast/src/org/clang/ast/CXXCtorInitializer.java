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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Represents a C++ base or member initializer.
///
/// This is part of a constructor initializer that
/// initializes one non-static member variable or one base class. For
/// example, in the following, both 'A(a)' and 'f(3.14159)' are member
/// initializers:
///
/// \code
/// class A { };
/// class B : public A {
///   float f;
/// public:
///   B(A& a) : A(a), f(3.14159) { }
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1922,
 FQN="clang::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerE")
//</editor-fold>
public final class CXXCtorInitializer implements /*private*/ TrailingObjects<CXXCtorInitializer, VarDecl /*P*/ > {
  /// \brief Either the base class name/delegating constructor type (stored as
  /// a TypeSourceInfo*), an normal field (FieldDecl), or an anonymous field
  /// (IndirectFieldDecl*) being initialized.
  private PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ > Initializee;
  
  /// \brief The source location for the field name or, for a base initializer
  /// pack expansion, the location of the ellipsis.
  ///
  /// In the case of a delegating
  /// constructor, it will still include the type's source location as the
  /// Initializee points to the CXXConstructorDecl (to allow loop detection).
  private SourceLocation MemberOrEllipsisLocation;
  
  /// \brief The argument used to initialize the base or member, which may
  /// end up constructing an object (when multiple arguments are involved).
  private Stmt /*P*/ Init;
  
  /// \brief Location of the left paren of the ctor-initializer.
  private SourceLocation LParenLoc;
  
  /// \brief Location of the right paren of the ctor-initializer.
  private SourceLocation RParenLoc;
  
  /// \brief If the initializee is a type, whether that type makes this
  /// a delegating initialization.
  private /*JBIT unsigned int*/ boolean IsDelegating /*: 1*/;
  
  /// \brief If the initializer is a base initializer, this keeps track
  /// of whether the base is virtual or not.
  private /*JBIT unsigned int*/ boolean IsVirtual /*: 1*/;
  
  /// \brief Whether or not the initializer is explicitly written
  /// in the sources.
  private /*JBIT unsigned int*/ boolean IsWritten /*: 1*/;
  
  /// If IsWritten is true, then this number keeps track of the textual order
  /// of this initializer in the original sources, counting from 0; otherwise,
  /// it stores the number of array index variables stored after this object
  /// in memory.
  private /*JCHAR unsigned int*/ char SourceOrderOrNumArrayIndices /*: 13*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::CXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1753,
   FQN="clang::CXXCtorInitializer::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_PPNS_7VarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_PPNS_7VarDeclEj")
  //</editor-fold>
  private CXXCtorInitializer(type$ptr<?> $this, final ASTContext /*&*/ Context, 
      FieldDecl /*P*/ Member, 
      SourceLocation MemberLoc, 
      SourceLocation L, Expr /*P*/ Init, 
      SourceLocation R, 
      type$ptr<VarDecl /*P*/ /*P*/> Indices, 
      /*uint*/int NumIndices) {
    // : TrailingObjects<CXXCtorInitializer, VarDecl * >(), Initializee(Member), MemberOrEllipsisLocation(MemberLoc), Init(Init), LParenLoc(L), RParenLoc(R), IsDelegating(false), IsVirtual(false), IsWritten(false), SourceOrderOrNumArrayIndices(NumIndices) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = TrailingObjectsUtils.$putThisAndShift(this, $this);
    this.Initializee = new PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ >(JD$T1.INSTANCE, FieldDecl /*P*/.class, Member);
    this.MemberOrEllipsisLocation = new SourceLocation(MemberLoc);
    this.Init = Init;
    this.LParenLoc = new SourceLocation(L);
    this.RParenLoc = new SourceLocation(R);
    this.IsDelegating = false;
    this.IsVirtual = false;
    this.IsWritten = false;
    this.SourceOrderOrNumArrayIndices = $uint2uint_13bits(NumIndices);
    //END JInit
    std.uninitialized_copy(Indices, Indices.$add(NumIndices), 
        getTrailingObjects(VarDecl /*P*/.class));
  }

/*public:*/
  /// \brief Creates a new base-class initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::CXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*$TrailingObjects*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1710,
   FQN="clang::CXXCtorInitializer::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_14TypeSourceInfoEbNS_14SourceLocationEPNS_4ExprES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_14TypeSourceInfoEbNS_14SourceLocationEPNS_4ExprES5_S5_")
  //</editor-fold>
  public CXXCtorInitializer(final ASTContext /*&*/ Context, 
      TypeSourceInfo /*P*/ TInfo, boolean IsVirtual, 
      SourceLocation L, Expr /*P*/ Init, 
      SourceLocation R, 
      SourceLocation EllipsisLoc) {
    // : TrailingObjects<CXXCtorInitializer, VarDecl * >(), Initializee(TInfo), MemberOrEllipsisLocation(EllipsisLoc), Init(Init), LParenLoc(L), RParenLoc(R), IsDelegating(false), IsVirtual(IsVirtual), IsWritten(false), SourceOrderOrNumArrayIndices(0) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = null;
    this.Initializee = new PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ >(JD$T.INSTANCE, TypeSourceInfo /*P*/.class, TInfo);
    this.MemberOrEllipsisLocation = new SourceLocation(EllipsisLoc);
    this.Init = Init;
    this.LParenLoc = new SourceLocation(L);
    this.RParenLoc = new SourceLocation(R);
    this.IsDelegating = false;
    this.IsVirtual = IsVirtual;
    this.IsWritten = false;
    this.SourceOrderOrNumArrayIndices = $uint2uint_13bits(0);
    //END JInit
  }

  
  /// \brief Creates a new member initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::CXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*$TrailingObjects*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1721,
   FQN="clang::CXXCtorInitializer::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_")
  //</editor-fold>
  public CXXCtorInitializer(final ASTContext /*&*/ Context, 
      FieldDecl /*P*/ Member, 
      SourceLocation MemberLoc, 
      SourceLocation L, Expr /*P*/ Init, 
      SourceLocation R) {
    // : TrailingObjects<CXXCtorInitializer, VarDecl * >(), Initializee(Member), MemberOrEllipsisLocation(MemberLoc), Init(Init), LParenLoc(L), RParenLoc(R), IsDelegating(false), IsVirtual(false), IsWritten(false), SourceOrderOrNumArrayIndices(0) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = null;
    this.Initializee = new PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ >(JD$T1.INSTANCE, FieldDecl /*P*/.class, Member);
    this.MemberOrEllipsisLocation = new SourceLocation(MemberLoc);
    this.Init = Init;
    this.LParenLoc = new SourceLocation(L);
    this.RParenLoc = new SourceLocation(R);
    this.IsDelegating = false;
    this.IsVirtual = false;
    this.IsWritten = false;
    this.SourceOrderOrNumArrayIndices = $uint2uint_13bits(0);
    //END JInit
  }

  
  /// \brief Creates a new anonymous field initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::CXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*$TrailingObjects*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1732,
   FQN="clang::CXXCtorInitializer::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_17IndirectFieldDeclENS_14SourceLocationES5_PNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_17IndirectFieldDeclENS_14SourceLocationES5_PNS_4ExprES5_")
  //</editor-fold>
  public CXXCtorInitializer(final ASTContext /*&*/ Context, 
      IndirectFieldDecl /*P*/ Member, 
      SourceLocation MemberLoc, 
      SourceLocation L, Expr /*P*/ Init, 
      SourceLocation R) {
    // : TrailingObjects<CXXCtorInitializer, VarDecl * >(), Initializee(Member), MemberOrEllipsisLocation(MemberLoc), Init(Init), LParenLoc(L), RParenLoc(R), IsDelegating(false), IsVirtual(false), IsWritten(false), SourceOrderOrNumArrayIndices(0) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = null;
    this.Initializee = new PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ >(JD$T2.INSTANCE, IndirectFieldDecl /*P*/.class, Member);
    this.MemberOrEllipsisLocation = new SourceLocation(MemberLoc);
    this.Init = Init;
    this.LParenLoc = new SourceLocation(L);
    this.RParenLoc = new SourceLocation(R);
    this.IsDelegating = false;
    this.IsVirtual = false;
    this.IsWritten = false;
    this.SourceOrderOrNumArrayIndices = $uint2uint_13bits(0);
    //END JInit
  }

  
  /// \brief Creates a new delegating initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::CXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*$TrailingObjects*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1743,
   FQN="clang::CXXCtorInitializer::CXXCtorInitializer", NM="_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializerC1ERNS_10ASTContextEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES5_")
  //</editor-fold>
  public CXXCtorInitializer(final ASTContext /*&*/ Context, 
      TypeSourceInfo /*P*/ TInfo, 
      SourceLocation L, Expr /*P*/ Init, 
      SourceLocation R) {
    // : TrailingObjects<CXXCtorInitializer, VarDecl * >(), Initializee(TInfo), MemberOrEllipsisLocation(), Init(Init), LParenLoc(L), RParenLoc(R), IsDelegating(true), IsVirtual(false), IsWritten(false), SourceOrderOrNumArrayIndices(0) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = null;
    this.Initializee = new PointerUnion3<TypeSourceInfo /*P*/ , FieldDecl /*P*/ , IndirectFieldDecl /*P*/ >(JD$T.INSTANCE, TypeSourceInfo /*P*/.class, TInfo);
    this.MemberOrEllipsisLocation = new SourceLocation();
    this.Init = Init;
    this.LParenLoc = new SourceLocation(L);
    this.RParenLoc = new SourceLocation(R);
    this.IsDelegating = true;
    this.IsVirtual = false;
    this.IsWritten = false;
    this.SourceOrderOrNumArrayIndices = $uint2uint_13bits(0);
    //END JInit
  }

  
  /// \brief Creates a new member initializer that optionally contains
  /// array indices used to describe an elementwise initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1768,
   FQN="clang::CXXCtorInitializer::Create", NM="_ZN5clang18CXXCtorInitializer6CreateERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_PPNS_7VarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializer6CreateERNS_10ASTContextEPNS_9FieldDeclENS_14SourceLocationES5_PNS_4ExprES5_PPNS_7VarDeclEj")
  //</editor-fold>
  public static CXXCtorInitializer /*P*/ Create(final ASTContext /*&*/ Context, 
        FieldDecl /*P*/ Member, 
        SourceLocation MemberLoc, 
        SourceLocation L, Expr /*P*/ Init, 
        SourceLocation R, 
        type$ptr<VarDecl /*P*/ /*P*/> Indices, 
        /*uint*/int NumIndices) {
    Object/*void P*/ Mem;
    if (false) {
      Mem = Context.Allocate(TrailingObjects.totalSizeToAlloc$Same(VarDecl.class, NumIndices), 
          alignOf(CXXCtorInitializer.class));
    } else {
      Mem = Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(VarDecl.class, NumIndices), 
          alignOf(CXXCtorInitializer.class));
    }
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new CXXCtorInitializer(New$Mem, Context, Member, new SourceLocation(MemberLoc), new SourceLocation(L), Init, new SourceLocation(R), 
                Indices, NumIndices);
     });
  }

  
  /// \brief Determine whether this initializer is initializing a base class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isBaseInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2002,
   FQN="clang::CXXCtorInitializer::isBaseInitializer", NM="_ZNK5clang18CXXCtorInitializer17isBaseInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer17isBaseInitializerEv")
  //</editor-fold>
  public boolean isBaseInitializer() /*const*/ {
    return (Initializee.is(TypeSourceInfo /*P*/.class) != 0) && !IsDelegating;
  }

  
  /// \brief Determine whether this initializer is initializing a non-static
  /// data member.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isMemberInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2008,
   FQN="clang::CXXCtorInitializer::isMemberInitializer", NM="_ZNK5clang18CXXCtorInitializer19isMemberInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer19isMemberInitializerEv")
  //</editor-fold>
  public boolean isMemberInitializer() /*const*/ {
    return (Initializee.is(FieldDecl /*P*/.class) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isAnyMemberInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2010,
   FQN="clang::CXXCtorInitializer::isAnyMemberInitializer", NM="_ZNK5clang18CXXCtorInitializer22isAnyMemberInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer22isAnyMemberInitializerEv")
  //</editor-fold>
  public boolean isAnyMemberInitializer() /*const*/ {
    return isMemberInitializer() || isIndirectMemberInitializer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isIndirectMemberInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2014,
   FQN="clang::CXXCtorInitializer::isIndirectMemberInitializer", NM="_ZNK5clang18CXXCtorInitializer27isIndirectMemberInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer27isIndirectMemberInitializerEv")
  //</editor-fold>
  public boolean isIndirectMemberInitializer() /*const*/ {
    return (Initializee.is(IndirectFieldDecl /*P*/.class) != 0);
  }

  
  /// \brief Determine whether this initializer is an implicit initializer
  /// generated for a field with an initializer defined on the member
  /// declaration.
  ///
  /// In-class member initializers (also known as "non-static data member
  /// initializations", NSDMIs) were introduced in C++11.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isInClassMemberInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2024,
   FQN="clang::CXXCtorInitializer::isInClassMemberInitializer", NM="_ZNK5clang18CXXCtorInitializer26isInClassMemberInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer26isInClassMemberInitializerEv")
  //</editor-fold>
  public boolean isInClassMemberInitializer() /*const*/ {
    return Init.getStmtClass() == Stmt.StmtClass.CXXDefaultInitExprClass;
  }

  
  /// \brief Determine whether this initializer is creating a delegating
  /// constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isDelegatingInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2030,
   FQN="clang::CXXCtorInitializer::isDelegatingInitializer", NM="_ZNK5clang18CXXCtorInitializer23isDelegatingInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer23isDelegatingInitializerEv")
  //</editor-fold>
  public boolean isDelegatingInitializer() /*const*/ {
    return (Initializee.is(TypeSourceInfo /*P*/.class) != 0) && IsDelegating;
  }

  
  /// \brief Determine whether this initializer is a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2035,
   FQN="clang::CXXCtorInitializer::isPackExpansion", NM="_ZNK5clang18CXXCtorInitializer15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return isBaseInitializer() && MemberOrEllipsisLocation.isValid();
  }

  
  // \brief For a pack expansion, returns the location of the ellipsis.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2040,
   FQN="clang::CXXCtorInitializer::getEllipsisLoc", NM="_ZNK5clang18CXXCtorInitializer14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    assert (isPackExpansion()) : "Initializer is not a pack expansion";
    return new SourceLocation(MemberOrEllipsisLocation);
  }

  
  /// If this is a base class initializer, returns the type of the
  /// base class with location information. Otherwise, returns an NULL
  /// type location.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getBaseClassLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1781,
   FQN="clang::CXXCtorInitializer::getBaseClassLoc", NM="_ZNK5clang18CXXCtorInitializer15getBaseClassLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer15getBaseClassLocEv")
  //</editor-fold>
  public TypeLoc getBaseClassLoc() /*const*/ {
    if (isBaseInitializer()) {
      return Initializee.get(TypeSourceInfo /*P*/.class).getTypeLoc();
    } else {
      return new TypeLoc();
    }
  }

  
  /// If this is a base class initializer, returns the type of the base class.
  /// Otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1788,
   FQN="clang::CXXCtorInitializer::getBaseClass", NM="_ZNK5clang18CXXCtorInitializer12getBaseClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer12getBaseClassEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getBaseClass() /*const*/ {
    if (isBaseInitializer()) {
      return Initializee.get(TypeSourceInfo /*P*/.class).getType().getTypePtr();
    } else {
      return null;
    }
  }

  
  /// Returns whether the base is virtual or not.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isBaseVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2055,
   FQN="clang::CXXCtorInitializer::isBaseVirtual", NM="_ZNK5clang18CXXCtorInitializer13isBaseVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer13isBaseVirtualEv")
  //</editor-fold>
  public boolean isBaseVirtual() /*const*/ {
    assert (isBaseInitializer()) : "Must call this on base initializer!";
    
    return IsVirtual;
  }

  
  /// \brief Returns the declarator information for a base class or delegating
  /// initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2063,
   FQN="clang::CXXCtorInitializer::getTypeSourceInfo", NM="_ZNK5clang18CXXCtorInitializer17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return Initializee.dyn_cast(TypeSourceInfo /*P*/.class);
  }

  
  /// \brief If this is a member initializer, returns the declaration of the
  /// non-static data member being initialized. Otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2069,
   FQN="clang::CXXCtorInitializer::getMember", NM="_ZNK5clang18CXXCtorInitializer9getMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer9getMemberEv")
  //</editor-fold>
  public FieldDecl /*P*/ getMember() /*const*/ {
    if (isMemberInitializer()) {
      return Initializee.get(FieldDecl /*P*/.class);
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getAnyMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2074,
   FQN="clang::CXXCtorInitializer::getAnyMember", NM="_ZNK5clang18CXXCtorInitializer12getAnyMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer12getAnyMemberEv")
  //</editor-fold>
  public FieldDecl /*P*/ getAnyMember() /*const*/ {
    if (isMemberInitializer()) {
      return Initializee.get(FieldDecl /*P*/.class);
    }
    if (isIndirectMemberInitializer()) {
      return Initializee.get(IndirectFieldDecl /*P*/.class).getAnonField();
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getIndirectMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2082,
   FQN="clang::CXXCtorInitializer::getIndirectMember", NM="_ZNK5clang18CXXCtorInitializer17getIndirectMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer17getIndirectMemberEv")
  //</editor-fold>
  public IndirectFieldDecl /*P*/ getIndirectMember() /*const*/ {
    if (isIndirectMemberInitializer()) {
      return Initializee.get(IndirectFieldDecl /*P*/.class);
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getMemberLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2088,
   FQN="clang::CXXCtorInitializer::getMemberLocation", NM="_ZNK5clang18CXXCtorInitializer17getMemberLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer17getMemberLocationEv")
  //</editor-fold>
  public SourceLocation getMemberLocation() /*const*/ {
    return new SourceLocation(MemberOrEllipsisLocation);
  }

  
  /// \brief Determine the source location of the initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1795,
   FQN="clang::CXXCtorInitializer::getSourceLocation", NM="_ZNK5clang18CXXCtorInitializer17getSourceLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer17getSourceLocationEv")
  //</editor-fold>
  public SourceLocation getSourceLocation() /*const*/ {
    if (isInClassMemberInitializer()) {
      return getAnyMember().getLocation();
    }
    if (isAnyMemberInitializer()) {
      return getMemberLocation();
    }
    {
      
      TypeSourceInfo /*P*/ TSInfo = Initializee.get(TypeSourceInfo /*P*/.class);
      if ((TSInfo != null)) {
        return TSInfo.getTypeLoc().getLocalSourceRange().getBegin();
      }
    }
    
    return new SourceLocation();
  }

  
  /// \brief Determine the source range covering the entire initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1808,
   FQN="clang::CXXCtorInitializer::getSourceRange", NM="_ZNK5clang18CXXCtorInitializer14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    if (isInClassMemberInitializer()) {
      FieldDecl /*P*/ D = getAnyMember();
      {
        Expr /*P*/ I = D.getInClassInitializer();
        if ((I != null)) {
          return I.getSourceRange();
        }
      }
      return new SourceRange();
    }
    
    return new SourceRange(getSourceLocation(), getRParenLoc());
  }

  
  /// \brief Determine whether this initializer is explicitly written
  /// in the source code.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::isWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2100,
   FQN="clang::CXXCtorInitializer::isWritten", NM="_ZNK5clang18CXXCtorInitializer9isWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer9isWrittenEv")
  //</editor-fold>
  public boolean isWritten() /*const*/ {
    return IsWritten;
  }

  
  /// \brief Return the source position of the initializer, counting from 0.
  /// If the initializer was implicit, -1 is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getSourceOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2104,
   FQN="clang::CXXCtorInitializer::getSourceOrder", NM="_ZNK5clang18CXXCtorInitializer14getSourceOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer14getSourceOrderEv")
  //</editor-fold>
  public int getSourceOrder() /*const*/ {
    return IsWritten ? ((/*static_cast*/int)(SourceOrderOrNumArrayIndices)) : -1;
  }

  
  /// \brief Set the source order of this initializer.
  ///
  /// This can only be called once for each initializer; it cannot be called
  /// on an initializer having a positive number of (implicit) array indices.
  ///
  /// This assumes that the initializer was written in the source code, and
  /// ensures that isWritten() returns true.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::setSourceOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2115,
   FQN="clang::CXXCtorInitializer::setSourceOrder", NM="_ZN5clang18CXXCtorInitializer14setSourceOrderEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializer14setSourceOrderEi")
  //</editor-fold>
  public void setSourceOrder(int pos) {
    assert (!IsWritten) : "calling twice setSourceOrder() on the same initializer";
    assert (SourceOrderOrNumArrayIndices == $int2uint_13bits(0)) : "setSourceOrder() used when there are implicit array indices";
    assert (pos >= 0) : "setSourceOrder() used to make an initializer implicit";
    IsWritten = true;
    SourceOrderOrNumArrayIndices = $uint2uint_13bits(((/*static_cast*//*uint*/int)(pos)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2126,
   FQN="clang::CXXCtorInitializer::getLParenLoc", NM="_ZNK5clang18CXXCtorInitializer12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2127,
   FQN="clang::CXXCtorInitializer::getRParenLoc", NM="_ZNK5clang18CXXCtorInitializer12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  /// \brief Determine the number of implicit array indices used while
  /// described an array member initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getNumArrayIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2131,
   FQN="clang::CXXCtorInitializer::getNumArrayIndices", NM="_ZNK5clang18CXXCtorInitializer18getNumArrayIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer18getNumArrayIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumArrayIndices() /*const*/ {
    return IsWritten ? 0 : SourceOrderOrNumArrayIndices;
  }

  
  /// \brief Retrieve a particular array index variable used to
  /// describe an array member initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2137,
   FQN="clang::CXXCtorInitializer::getArrayIndex", NM="_ZN5clang18CXXCtorInitializer13getArrayIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializer13getArrayIndexEj")
  //</editor-fold>
  public VarDecl /*P*/ getArrayIndex(/*uint*/int I) {
    assert ($less_uint(I, getNumArrayIndices())) : "Out of bounds member array index";
    return getTrailingObjects(VarDecl /*P*/.class).$at(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2141,
   FQN="clang::CXXCtorInitializer::getArrayIndex", NM="_ZNK5clang18CXXCtorInitializer13getArrayIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer13getArrayIndexEj")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getArrayIndex$Const(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumArrayIndices())) : "Out of bounds member array index";
    return getTrailingObjects$Const(VarDecl /*P*/.class).$at(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::setArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2145,
   FQN="clang::CXXCtorInitializer::setArrayIndex", NM="_ZN5clang18CXXCtorInitializer13setArrayIndexEjPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializer13setArrayIndexEjPNS_7VarDeclE")
  //</editor-fold>
  public void setArrayIndex(/*uint*/int I, VarDecl /*P*/ Index) {
    assert ($less_uint(I, getNumArrayIndices())) : "Out of bounds member array index";
    getTrailingObjects(VarDecl /*P*/.class).$set(I, Index);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getArrayIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2149,
   FQN="clang::CXXCtorInitializer::getArrayIndices", NM="_ZN5clang18CXXCtorInitializer15getArrayIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXCtorInitializer15getArrayIndicesEv")
  //</editor-fold>
  public ArrayRef<VarDecl /*P*/ > getArrayIndices() {
    return llvm.makeArrayRef(getTrailingObjects(VarDecl /*P*/.class), 
        getNumArrayIndices());
  }

  
  /// \brief Get the initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCtorInitializer::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2155,
   FQN="clang::CXXCtorInitializer::getInit", NM="_ZNK5clang18CXXCtorInitializer7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXCtorInitializer7getInitEv")
  //</editor-fold>
  public Expr /*P*/ getInit() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(Init));
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<?> $TrailingObjects;
    
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return $TrailingObjects;
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == VarDecl.class;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Initializee=" + Initializee // NOI18N
              + ", MemberOrEllipsisLocation=" + MemberOrEllipsisLocation // NOI18N
              + ", Init=" + Init // NOI18N
              + ", LParenLoc=" + LParenLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", IsDelegating=" + IsDelegating // NOI18N
              + ", IsVirtual=" + IsVirtual // NOI18N
              + ", IsWritten=" + IsWritten // NOI18N
              + ", SourceOrderOrNumArrayIndices=" + $ushort2uint(SourceOrderOrNumArrayIndices) // NOI18N
              + super.toString(); // NOI18N
  }
}
