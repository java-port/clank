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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clank.support.Native.$tryClone;


/// \brief Represents a C++ constructor within a class.
///
/// For example:
///
/// \code
/// class X {
/// public:
///   explicit X(int); // represented by a CXXConstructorDecl.
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2187,
 FQN="clang::CXXConstructorDecl", NM="_ZN5clang18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDeclE")
//</editor-fold>
public final class CXXConstructorDecl extends /*public*/ CXXMethodDecl implements /*private*/ TrailingObjects<CXXConstructorDecl, InheritedConstructor>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1819,
   FQN="clang::CXXConstructorDecl::anchor", NM="_ZN5clang18CXXConstructorDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \name Support for base and member initializers.
  /// \{
  /// \brief The arguments used to initialize the base or member.
  /*friend*/public LazyCXXCtorInitializersPtr CtorInitializers;
  /*friend*/public /*uint*/int NumCtorInitializers /*: 30*/;
  /// \}
  
  /// \brief Whether this constructor declaration has the \c explicit keyword
  /// specified.
  /*friend*/public /*JBIT unsigned int*/ boolean IsExplicitSpecified /*: 1*/;
  
  /// \brief Whether this constructor declaration is an implicitly-declared
  /// inheriting constructor.
  private /*JBIT unsigned int*/ boolean IsInheritingConstructor /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::CXXConstructorDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*setting InheritedConstructor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2207,
   FQN="clang::CXXConstructorDecl::CXXConstructorDecl", NM="_ZN5clang18CXXConstructorDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbbNS_20InheritedConstructorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbbNS_20InheritedConstructorE")
  //</editor-fold>
  private CXXConstructorDecl(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, SourceLocation StartLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType T, TypeSourceInfo /*P*/ TInfo, 
      boolean isExplicitSpecified, boolean isInline, 
      boolean isImplicitlyDeclared, boolean isConstexpr, 
      InheritedConstructor Inherited) {
    // : CXXMethodDecl(CXXConstructor, C, RD, StartLoc, NameInfo, T, TInfo, SC_None, isInline, isConstexpr, SourceLocation()), TrailingObjects<CXXConstructorDecl, InheritedConstructor>(), CtorInitializers(null), NumCtorInitializers(0), IsExplicitSpecified(isExplicitSpecified), IsInheritingConstructor((bool)Inherited.operator bool()) 
    //START JInit
    super(Kind.CXXConstructor, C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
        StorageClass.SC_None, isInline, isConstexpr, new SourceLocation());
    $TrailingObjects();
    this.CtorInitializers = new LazyCXXCtorInitializersPtr((type$ptr<CXXCtorInitializer /*P*/ /*P*/>)null);
    this.NumCtorInitializers = 0;
    this.IsExplicitSpecified = isExplicitSpecified;
    this.IsInheritingConstructor = (boolean)Inherited.$bool();
    //END JInit
    setImplicit(isImplicitlyDeclared);
    if (Inherited.$bool()) {
      /*Deref*/this.<InheritedConstructor>getTrailingObjects(InheritedConstructor.class).$set($tryClone(Inherited));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1821,
   FQN="clang::CXXConstructorDecl::CreateDeserialized", NM="_ZN5clang18CXXConstructorDecl18CreateDeserializedERNS_10ASTContextEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl18CreateDeserializedERNS_10ASTContextEjb")
  //</editor-fold>
  public static CXXConstructorDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID, 
                    boolean Inherited) {
    /*uint*/int Extra = TrailingObjects.additionalSizeToAlloc$Same(InheritedConstructor.class, (Inherited ? 1 : 0));
    CXXConstructorDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, ID, Extra)*/ Decl.$new(C, ID, Extra, (type$ptr<?> Mem)->{
        return new CXXConstructorDecl(C, (CXXRecordDecl /*P*/ )null, new SourceLocation(), new DeclarationNameInfo(), new QualType(), (TypeSourceInfo /*P*/ )null, 
                false, false, false, false, new InheritedConstructor());
     },
        new std.pairIntPtr<>(Extra, InheritedConstructor::new) // for InheritedConstructor
    );
    Result.IsInheritingConstructor = Inherited;
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1832,
   FQN="clang::CXXConstructorDecl::Create", NM="_ZN5clang18CXXConstructorDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbbNS_20InheritedConstructorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbbNS_20InheritedConstructorE")
  //</editor-fold>
  public static CXXConstructorDecl /*P*/ Create(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        boolean isExplicit, boolean isInline, 
        boolean isImplicitlyDeclared, boolean isConstexpr) {
    return Create(C, RD, 
        StartLoc, 
        NameInfo, 
        T, TInfo, 
        isExplicit, isInline, 
        isImplicitlyDeclared, isConstexpr, 
        new InheritedConstructor());
  }
  public static CXXConstructorDecl /*P*/ Create(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        boolean isExplicit, boolean isInline, 
        boolean isImplicitlyDeclared, boolean isConstexpr, 
        InheritedConstructor Inherited/*= InheritedConstructor()*/) {
    assert (NameInfo.getName().getNameKind() == DeclarationName.NameKind.CXXConstructorName) : "Name must refer to a constructor";
    /*uint*/int Extra = TrailingObjects.additionalSizeToAlloc$Same(InheritedConstructor.class, Inherited.$bool() ? 1 : 0);
    return /*NEW_EXPR [Decl::new]*//*new (C, RD, Extra)*/ Decl.$new(C, RD, Extra, (type$ptr<?> Mem)->{
        return new CXXConstructorDecl(C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, isExplicit, isInline, 
                isImplicitlyDeclared, isConstexpr, new InheritedConstructor(Inherited));
     },
        new std.pairIntPtr<>(Extra, InheritedConstructor::new) // for InheritedConstructor
    );
  }

  
  /// \brief Determine whether this constructor declaration has the
  /// \c explicit keyword specified.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isExplicitSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2235,
   FQN="clang::CXXConstructorDecl::isExplicitSpecified", NM="_ZNK5clang18CXXConstructorDecl19isExplicitSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl19isExplicitSpecifiedEv")
  //</editor-fold>
  public boolean isExplicitSpecified() /*const*/ {
    return IsExplicitSpecified;
  }

  
  /// \brief Determine whether this constructor was marked "explicit" or not.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2238,
   FQN="clang::CXXConstructorDecl::isExplicit", NM="_ZNK5clang18CXXConstructorDecl10isExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl10isExplicitEv")
  //</editor-fold>
  public boolean isExplicit() /*const*/ {
    return cast_CXXConstructorDecl(getFirstDecl$Const()).isExplicitSpecified();
  }

  
  /// \brief Iterates through the member/base initializer list.
  /*typedef CXXCtorInitializer **init_iterator*/
//  public final class init_iterator extends type$ptr<CXXCtorInitializer /*P*/ /*P*/>{ };
  
  /// \brief Iterates through the member/base initializer list.
  /*typedef CXXCtorInitializer *const *init_const_iterator*/
//  public final class init_const_iterator extends type$ptr<CXXCtorInitializer /*P*/ /*const*/ /*P*/>{ };
  
  /*typedef llvm::iterator_range<init_iterator> init_range*/
//  public final class init_range extends iterator_range<CXXCtorInitializer /*P*/ >{ };
  /*typedef llvm::iterator_range<init_const_iterator> init_const_range*/
//  public final class init_const_range extends iterator_range<CXXCtorInitializer /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2251,
   FQN="clang::CXXConstructorDecl::inits", NM="_ZN5clang18CXXConstructorDecl5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl5initsEv")
  //</editor-fold>
  public iterator_range<CXXCtorInitializer /*P*/ > inits() {
    return new iterator_range<CXXCtorInitializer /*P*/ >(init_begin(), init_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2252,
   FQN="clang::CXXConstructorDecl::inits", NM="_ZNK5clang18CXXConstructorDecl5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl5initsEv")
  //</editor-fold>
  public iterator_range<CXXCtorInitializer /*P*/ /*const*/> inits$Const() /*const*/ {
    return new iterator_range<CXXCtorInitializer /*P*/ /*const*/>(init_begin$Const(), init_end$Const());
  }

  
  /// \brief Retrieve an iterator to the first initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2257,
   FQN="clang::CXXConstructorDecl::init_begin", NM="_ZN5clang18CXXConstructorDecl10init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl10init_beginEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> init_begin() {
    /*const*/ CXXConstructorDecl /*P*/ ConstThis = this;
    return ((/*const_cast*/type$ptr<CXXCtorInitializer /*P*/ /*P*/>)(ConstThis.init_begin$Const()));
  }

  /// \brief Retrieve an iterator to the first initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1850,
   FQN="clang::CXXConstructorDecl::init_begin", NM="_ZNK5clang18CXXConstructorDecl10init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl10init_beginEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer/*P*/> init_begin$Const() /*const*/ {
    return CtorInitializers.get(getASTContext().getExternalSource());
  }

  
  /// \brief Retrieve an iterator past the last initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2265,
   FQN="clang::CXXConstructorDecl::init_end", NM="_ZN5clang18CXXConstructorDecl8init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl8init_endEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> init_end() {
    return init_begin().$add(NumCtorInitializers);
  }

  /// \brief Retrieve an iterator past the last initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2269,
   FQN="clang::CXXConstructorDecl::init_end", NM="_ZNK5clang18CXXConstructorDecl8init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl8init_endEv")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*const*/ /*P*/> init_end$Const() /*const*/ {
    return init_begin$Const().$add(NumCtorInitializers);
  }

  
  /*typedef std::reverse_iterator<init_iterator> init_reverse_iterator*/
//  public final class init_reverse_iterator extends std.reverse_iterator<CXXCtorInitializer /*P*/ >{ };
  /*typedef std::reverse_iterator<init_const_iterator> init_const_reverse_iterator*/
//  public final class init_const_reverse_iterator extends std.reverse_iterator<CXXCtorInitializer /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2277,
   FQN="clang::CXXConstructorDecl::init_rbegin", NM="_ZN5clang18CXXConstructorDecl11init_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl11init_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<CXXCtorInitializer /*P*/ > init_rbegin() {
    return new std.reverse_iterator<CXXCtorInitializer /*P*/ >(init_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2280,
   FQN="clang::CXXConstructorDecl::init_rbegin", NM="_ZNK5clang18CXXConstructorDecl11init_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl11init_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<CXXCtorInitializer /*P*/ /*const*/> init_rbegin$Const() /*const*/ {
    return new std.reverse_iterator<CXXCtorInitializer /*P*/ /*const*/>(init_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2284,
   FQN="clang::CXXConstructorDecl::init_rend", NM="_ZN5clang18CXXConstructorDecl9init_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl9init_rendEv")
  //</editor-fold>
  public std.reverse_iterator<CXXCtorInitializer /*P*/ > init_rend() {
    return new std.reverse_iterator<CXXCtorInitializer /*P*/ >(init_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::init_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2287,
   FQN="clang::CXXConstructorDecl::init_rend", NM="_ZNK5clang18CXXConstructorDecl9init_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl9init_rendEv")
  //</editor-fold>
  public std.reverse_iterator<CXXCtorInitializer /*P*/ /*const*/> init_rend$Const() /*const*/ {
    return new std.reverse_iterator<CXXCtorInitializer /*P*/ /*const*/>(init_begin$Const());
  }

  
  /// \brief Determine the number of arguments used to initialize the member
  /// or base.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::getNumCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2293,
   FQN="clang::CXXConstructorDecl::getNumCtorInitializers", NM="_ZNK5clang18CXXConstructorDecl22getNumCtorInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl22getNumCtorInitializersEv")
  //</editor-fold>
  public /*uint*/int getNumCtorInitializers() /*const*/ {
    return NumCtorInitializers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::setNumCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2297,
   FQN="clang::CXXConstructorDecl::setNumCtorInitializers", NM="_ZN5clang18CXXConstructorDecl22setNumCtorInitializersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl22setNumCtorInitializersEj")
  //</editor-fold>
  public void setNumCtorInitializers(/*uint*/int numCtorInitializers) {
    NumCtorInitializers = numCtorInitializers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::setCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2301,
   FQN="clang::CXXConstructorDecl::setCtorInitializers", NM="_ZN5clang18CXXConstructorDecl19setCtorInitializersEPPNS_18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl19setCtorInitializersEPPNS_18CXXCtorInitializerE")
  //</editor-fold>
  public void setCtorInitializers(type$ptr<CXXCtorInitializer /*P*/ /*P*/> Initializers) {
    CtorInitializers.$assign(Initializers);
  }

  
  /// \brief Determine whether this constructor is a delegating constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isDelegatingConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2306,
   FQN="clang::CXXConstructorDecl::isDelegatingConstructor", NM="_ZNK5clang18CXXConstructorDecl23isDelegatingConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23isDelegatingConstructorEv")
  //</editor-fold>
  public boolean isDelegatingConstructor() /*const*/ {
    return (getNumCtorInitializers() == 1)
       && init_begin$Const().$at(0).isDelegatingInitializer();
  }

  
  /// \brief When this constructor delegates to another, retrieve the target.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::getTargetConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1854,
   FQN="clang::CXXConstructorDecl::getTargetConstructor", NM="_ZNK5clang18CXXConstructorDecl20getTargetConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl20getTargetConstructorEv")
  //</editor-fold>
  public CXXConstructorDecl /*P*/ getTargetConstructor() /*const*/ {
    assert (isDelegatingConstructor()) : "Not a delegating constructor!";
    Expr /*P*/ E = (init_begin$Const().$star()).getInit().IgnoreImplicit();
    {
      CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(E);
      if ((Construct != null)) {
        return Construct.getConstructor();
      }
    }
    
    return null;
  }

  
  /// Whether this constructor is a default
  /// constructor (C++ [class.ctor]p5), which can be used to
  /// default-initialize a class of this type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1863,
   FQN="clang::CXXConstructorDecl::isDefaultConstructor", NM="_ZNK5clang18CXXConstructorDecl20isDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl20isDefaultConstructorEv")
  //</editor-fold>
  public boolean isDefaultConstructor() /*const*/ {
    // C++ [class.ctor]p5:
    //   A default constructor for a class X is a constructor of class
    //   X that can be called without an argument.
    return (getNumParams() == 0)
       || ($greater_uint(getNumParams(), 0) && getParamDecl$Const(0).hasDefaultArg());
  }

  
  /// \brief Whether this constructor is a copy constructor (C++ [class.copy]p2,
  /// which can be used to copy the class.
  ///
  /// \p TypeQuals will be set to the qualifiers on the
  /// argument type. For example, \p TypeQuals would be set to \c
  /// Qualifiers::Const for the following copy constructor:
  ///
  /// \code
  /// class X {
  /// public:
  ///   X(const X&);
  /// };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1871,
   FQN="clang::CXXConstructorDecl::isCopyConstructor", NM="_ZNK5clang18CXXConstructorDecl17isCopyConstructorERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl17isCopyConstructorERj")
  //</editor-fold>
  public boolean isCopyConstructor(final uint$ref/*uint &*/ TypeQuals) /*const*/ {
    return isCopyOrMoveConstructor(TypeQuals)
       && getParamDecl$Const(0).getType().$arrow().isLValueReferenceType();
  }

  
  /// Whether this constructor is a copy
  /// constructor (C++ [class.copy]p2, which can be used to copy the
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2337,
   FQN="clang::CXXConstructorDecl::isCopyConstructor", NM="_ZNK5clang18CXXConstructorDecl17isCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl17isCopyConstructorEv")
  //</editor-fold>
  public boolean isCopyConstructor() /*const*/ {
    uint$ref TypeQuals = create_uint$ref(0);
    return isCopyConstructor(TypeQuals);
  }

  
  /// \brief Determine whether this constructor is a move constructor
  /// (C++11 [class.copy]p3), which can be used to move values of the class.
  ///
  /// \param TypeQuals If this constructor is a move constructor, will be set
  /// to the type qualifiers on the referent of the first parameter's type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1877,
   FQN="clang::CXXConstructorDecl::isMoveConstructor", NM="_ZNK5clang18CXXConstructorDecl17isMoveConstructorERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl17isMoveConstructorERj")
  //</editor-fold>
  public boolean isMoveConstructor(final uint$ref/*uint &*/ TypeQuals) /*const*/ {
    return isCopyOrMoveConstructor(TypeQuals)
       && getParamDecl$Const(0).getType().$arrow().isRValueReferenceType();
  }

  
  /// \brief Determine whether this constructor is a move constructor
  /// (C++11 [class.copy]p3), which can be used to move values of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2351,
   FQN="clang::CXXConstructorDecl::isMoveConstructor", NM="_ZNK5clang18CXXConstructorDecl17isMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl17isMoveConstructorEv")
  //</editor-fold>
  public boolean isMoveConstructor() /*const*/ {
    uint$ref TypeQuals = create_uint$ref(0);
    return isMoveConstructor(TypeQuals);
  }

  
  /// \brief Determine whether this is a copy or move constructor.
  ///
  /// \param TypeQuals Will be set to the type qualifiers on the reference
  /// parameter, if in fact this is a copy or move constructor.
  
  /// \brief Determine whether this is a copy or move constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isCopyOrMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1883,
   FQN="clang::CXXConstructorDecl::isCopyOrMoveConstructor", NM="_ZNK5clang18CXXConstructorDecl23isCopyOrMoveConstructorERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23isCopyOrMoveConstructorERj")
  //</editor-fold>
  public boolean isCopyOrMoveConstructor(final uint$ref/*uint &*/ TypeQuals) /*const*/ {
    // C++ [class.copy]p2:
    //   A non-template constructor for class X is a copy constructor
    //   if its first parameter is of type X&, const X&, volatile X& or
    //   const volatile X&, and either there are no other parameters
    //   or else all other parameters have default arguments (8.3.6).
    // C++0x [class.copy]p3:
    //   A non-template constructor for class X is a move constructor if its
    //   first parameter is of type X&&, const X&&, volatile X&&, or 
    //   const volatile X&&, and either there are no other parameters or else 
    //   all other parameters have default arguments.
    if (($less_uint(getNumParams(), 1))
       || ($greater_uint(getNumParams(), 1) && !getParamDecl$Const(1).hasDefaultArg())
       || (getPrimaryTemplate() != null)
       || (getDescribedFunctionTemplate() != null)) {
      return false;
    }
    
    /*const*/ ParmVarDecl /*P*/ Param = getParamDecl$Const(0);
    
    // Do we have a reference type? 
    /*const*/ ReferenceType /*P*/ ParamRefType = Param.getType().$arrow().getAs(ReferenceType.class);
    if (!(ParamRefType != null)) {
      return false;
    }
    
    // Is it a reference to our class type?
    final ASTContext /*&*/ Context = getASTContext();
    
    CanQual<Type> PointeeType = Context.getCanonicalType(ParamRefType.getPointeeType());
    CanQual<Type> ClassTy = Context.getCanonicalType(Context.getTagDeclType(getParent$Const()));
    if ($noteq_CanQual$T_CanQual$U(PointeeType.getUnqualifiedType(), /*NO_COPY*/ClassTy)) {
      return false;
    }
    
    // FIXME: other qualifiers?
    
    // We have a copy or move constructor.
    TypeQuals.$set(PointeeType.getCVRQualifiers());
    return true;
  }

  
  /// \brief Determine whether this a copy or move constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isCopyOrMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2363,
   FQN="clang::CXXConstructorDecl::isCopyOrMoveConstructor", NM="_ZNK5clang18CXXConstructorDecl23isCopyOrMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23isCopyOrMoveConstructorEv")
  //</editor-fold>
  public boolean isCopyOrMoveConstructor() /*const*/ {
    uint$ref Quals = create_uint$ref();
    return isCopyOrMoveConstructor(Quals);
  }

  
  /// Whether this constructor is a
  /// converting constructor (C++ [class.conv.ctor]), which can be
  /// used for user-defined conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isConvertingConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1924,
   FQN="clang::CXXConstructorDecl::isConvertingConstructor", NM="_ZNK5clang18CXXConstructorDecl23isConvertingConstructorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23isConvertingConstructorEb")
  //</editor-fold>
  public boolean isConvertingConstructor(boolean AllowExplicit) /*const*/ {
    // C++ [class.conv.ctor]p1:
    //   A constructor declared without the function-specifier explicit
    //   that can be called with a single parameter specifies a
    //   conversion from the type of its first parameter to the type of
    //   its class. Such a constructor is called a converting
    //   constructor.
    if (isExplicit() && !AllowExplicit) {
      return false;
    }
    
    return (getNumParams() == 0
       && getType().$arrow().getAs(FunctionProtoType.class).isVariadic())
       || (getNumParams() == 1)
       || ($greater_uint(getNumParams(), 1)
       && (getParamDecl$Const(1).hasDefaultArg()
       || getParamDecl$Const(1).isParameterPack()));
  }

  
  /// \brief Determine whether this is a member template specialization that
  /// would copy the object to itself. Such constructors are never used to copy
  /// an object.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isSpecializationCopyingObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1942,
   FQN="clang::CXXConstructorDecl::isSpecializationCopyingObject", NM="_ZNK5clang18CXXConstructorDecl29isSpecializationCopyingObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl29isSpecializationCopyingObjectEv")
  //</editor-fold>
  public boolean isSpecializationCopyingObject() /*const*/ {
    if (($less_uint(getNumParams(), 1))
       || ($greater_uint(getNumParams(), 1) && !getParamDecl$Const(1).hasDefaultArg())
       || (getDescribedFunctionTemplate() != null)) {
      return false;
    }
    
    /*const*/ ParmVarDecl /*P*/ Param = getParamDecl$Const(0);
    
    final ASTContext /*&*/ Context = getASTContext();
    CanQual<Type> ParamType = Context.getCanonicalType(Param.getType());
    
    // Is it the same as our our class type?
    CanQual<Type> ClassTy = Context.getCanonicalType(Context.getTagDeclType(getParent$Const()));
    if ($noteq_CanQual$T_CanQual$U(ParamType.getUnqualifiedType(), /*NO_COPY*/ClassTy)) {
      return false;
    }
    
    return true;
  }

  
  /// \brief Determine whether this is an implicit constructor synthesized to
  /// model a call to a constructor inherited from a base class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::isInheritingConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2380,
   FQN="clang::CXXConstructorDecl::isInheritingConstructor", NM="_ZNK5clang18CXXConstructorDecl23isInheritingConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23isInheritingConstructorEv")
  //</editor-fold>
  public boolean isInheritingConstructor() /*const*/ {
    return IsInheritingConstructor;
  }

  
  /// \brief Get the constructor that this inheriting constructor is based on.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::getInheritedConstructor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2383,
   FQN="clang::CXXConstructorDecl::getInheritedConstructor", NM="_ZNK5clang18CXXConstructorDecl23getInheritedConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl23getInheritedConstructorEv")
  //</editor-fold>
  public InheritedConstructor getInheritedConstructor() /*const*/ {
    return IsInheritingConstructor ? new InheritedConstructor($Deref(this.<InheritedConstructor>getTrailingObjects$Const(InheritedConstructor.class).$star())) : new InheritedConstructor();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2388,
   FQN="clang::CXXConstructorDecl::getCanonicalDecl", NM="_ZN5clang18CXXConstructorDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public CXXConstructorDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_CXXConstructorDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2391,
   FQN="clang::CXXConstructorDecl::getCanonicalDecl", NM="_ZNK5clang18CXXConstructorDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18CXXConstructorDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ CXXConstructorDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXConstructorDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2396,
   FQN="clang::CXXConstructorDecl::classof", NM="_ZN5clang18CXXConstructorDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2397,
   FQN="clang::CXXConstructorDecl::classofKind", NM="_ZN5clang18CXXConstructorDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.CXXConstructor;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  /*friend  TrailingObjects<CXXConstructorDecl, InheritedConstructor>*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructorDecl::~CXXConstructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2187,
   FQN="clang::CXXConstructorDecl::~CXXConstructorDecl", NM="_ZN5clang18CXXConstructorDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18CXXConstructorDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public type$ptr<?> $TrailingObjects() {
    return $This$Ptr().$add(1); // skip this class
  }
  
  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == InheritedConstructor.class : "unexpected class " + clazz;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CtorInitializers=" + CtorInitializers // NOI18N
              + ", NumCtorInitializers=" + NumCtorInitializers // NOI18N
              + ", IsExplicitSpecified=" + IsExplicitSpecified // NOI18N
              + ", IsInheritingConstructor=" + IsInheritingConstructor // NOI18N
              + super.toString(); // NOI18N
  }
}
