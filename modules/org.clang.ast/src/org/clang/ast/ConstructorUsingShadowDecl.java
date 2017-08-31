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
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Represents a shadow constructor declaration introduced into a
/// class by a C++11 using-declaration that names a constructor.
///
/// For example:
/// \code
/// struct Base { Base(int); };
/// struct Derived {
///    using Base::Base; // creates a UsingDecl and a ConstructorUsingShadowDecl
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2927,
 FQN="clang::ConstructorUsingShadowDecl", NM="_ZN5clang26ConstructorUsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDeclE")
//</editor-fold>
public final class ConstructorUsingShadowDecl extends /*public*/ UsingShadowDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2185,
   FQN="clang::ConstructorUsingShadowDecl::anchor", NM="_ZN5clang26ConstructorUsingShadowDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief If this constructor using declaration inherted the constructor
  /// from an indirect base class, this is the ConstructorUsingShadowDecl
  /// in the named direct base class from which the declaration was inherited.
  /*friend*/public ConstructorUsingShadowDecl /*P*/ NominatedBaseClassShadowDecl;
  
  /// \brief If this constructor using declaration inherted the constructor
  /// from an indirect base class, this is the ConstructorUsingShadowDecl
  /// that will be used to construct the unique direct or virtual base class
  /// that receives the constructor arguments.
  /*friend*/public ConstructorUsingShadowDecl /*P*/ ConstructedBaseClassShadowDecl;
  
  /// \brief \c true if the constructor ultimately named by this using shadow
  /// declaration is within a virtual base class subobject of the class that
  /// contains this declaration.
  /*friend*/public /*JBIT unsigned int*/ boolean IsVirtual /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::ConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2946,
   FQN="clang::ConstructorUsingShadowDecl::ConstructorUsingShadowDecl", NM="_ZN5clang26ConstructorUsingShadowDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclEb")
  //</editor-fold>
  private ConstructorUsingShadowDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation Loc, 
      UsingDecl /*P*/ Using, NamedDecl /*P*/ Target, 
      boolean TargetInVirtualBase) {
    // : UsingShadowDecl(ConstructorUsingShadow, C, DC, Loc, Using, Target->getUnderlyingDecl()), NominatedBaseClassShadowDecl(dyn_cast<ConstructorUsingShadowDecl>(Target)), ConstructedBaseClassShadowDecl(NominatedBaseClassShadowDecl), IsVirtual(TargetInVirtualBase) 
    //START JInit
    super(Kind.ConstructorUsingShadow, C, DC, new SourceLocation(Loc), Using, 
        Target.getUnderlyingDecl());
    this.NominatedBaseClassShadowDecl = dyn_cast_ConstructorUsingShadowDecl(Target);
    this.ConstructedBaseClassShadowDecl = NominatedBaseClassShadowDecl;
    this.IsVirtual = TargetInVirtualBase;
    //END JInit
    // If we found a constructor for a non-virtual base class, but it chains to
    // a constructor for a virtual base, we should directly call the virtual
    // base constructor instead.
    // FIXME: This logic belongs in Sema.
    if (!TargetInVirtualBase && (NominatedBaseClassShadowDecl != null)
       && NominatedBaseClassShadowDecl.constructsVirtualBase()) {
      ConstructedBaseClassShadowDecl
         = NominatedBaseClassShadowDecl.ConstructedBaseClassShadowDecl;
      IsVirtual = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::ConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2966,
   FQN="clang::ConstructorUsingShadowDecl::ConstructorUsingShadowDecl", NM="_ZN5clang26ConstructorUsingShadowDeclC1ERNS_10ASTContextENS_4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDeclC1ERNS_10ASTContextENS_4Decl10EmptyShellE")
  //</editor-fold>
  private ConstructorUsingShadowDecl(final ASTContext /*&*/ C, EmptyShell Empty) {
    // : UsingShadowDecl(ConstructorUsingShadow, C, Empty) 
    //START JInit
    super(Kind.ConstructorUsingShadow, C, new EmptyShell(Empty));
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2187,
   FQN="clang::ConstructorUsingShadowDecl::Create", NM="_ZN5clang26ConstructorUsingShadowDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_9UsingDeclEPNS_9NamedDeclEb")
  //</editor-fold>
  public static ConstructorUsingShadowDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation Loc, UsingDecl /*P*/ Using, 
        NamedDecl /*P*/ Target, boolean IsVirtual) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ConstructorUsingShadowDecl(C, DC, new SourceLocation(Loc), Using, Target, 
                IsVirtual);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2195,
   FQN="clang::ConstructorUsingShadowDecl::CreateDeserialized", NM="_ZN5clang26ConstructorUsingShadowDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ConstructorUsingShadowDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ConstructorUsingShadowDecl(C, new EmptyShell());
     });
  }

  
  /// Returns the parent of this using shadow declaration, which
  /// is the class in which this is declared.
  //@{
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2980,
   FQN="clang::ConstructorUsingShadowDecl::getParent", NM="_ZNK5clang26ConstructorUsingShadowDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl9getParentEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getParent$Const() /*const*/ {
    return cast_CXXRecordDecl(getDeclContext$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2983,
   FQN="clang::ConstructorUsingShadowDecl::getParent", NM="_ZN5clang26ConstructorUsingShadowDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl9getParentEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getParent() {
    return cast_CXXRecordDecl(getDeclContext());
  }

  //@}
  
  /// \brief Get the inheriting constructor declaration for the direct base
  /// class from which this using shadow declaration was inherited, if there is
  /// one. This can be different for each redeclaration of the same shadow decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getNominatedBaseClassShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2991,
   FQN="clang::ConstructorUsingShadowDecl::getNominatedBaseClassShadowDecl", NM="_ZNK5clang26ConstructorUsingShadowDecl31getNominatedBaseClassShadowDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl31getNominatedBaseClassShadowDeclEv")
  //</editor-fold>
  public ConstructorUsingShadowDecl /*P*/ getNominatedBaseClassShadowDecl() /*const*/ {
    return NominatedBaseClassShadowDecl;
  }

  
  /// \brief Get the inheriting constructor declaration for the base class
  /// for which we don't have an explicit initializer, if there is one.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getConstructedBaseClassShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2997,
   FQN="clang::ConstructorUsingShadowDecl::getConstructedBaseClassShadowDecl", NM="_ZNK5clang26ConstructorUsingShadowDecl33getConstructedBaseClassShadowDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl33getConstructedBaseClassShadowDeclEv")
  //</editor-fold>
  public ConstructorUsingShadowDecl /*P*/ getConstructedBaseClassShadowDecl() /*const*/ {
    return ConstructedBaseClassShadowDecl;
  }

  
  /// \brief Get the base class that was named in the using declaration. This
  /// can be different for each redeclaration of this same shadow decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getNominatedBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2200,
   FQN="clang::ConstructorUsingShadowDecl::getNominatedBaseClass", NM="_ZNK5clang26ConstructorUsingShadowDecl21getNominatedBaseClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl21getNominatedBaseClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNominatedBaseClass() /*const*/ {
    return getUsingDecl().getQualifier().getAsRecordDecl();
  }

  
  /// \brief Get the base class whose constructor or constructor shadow
  /// declaration is passed the constructor arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getConstructedBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3007,
   FQN="clang::ConstructorUsingShadowDecl::getConstructedBaseClass", NM="_ZNK5clang26ConstructorUsingShadowDecl23getConstructedBaseClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl23getConstructedBaseClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getConstructedBaseClass() /*const*/ {
    return cast_CXXRecordDecl(((ConstructedBaseClassShadowDecl != null) ? ConstructedBaseClassShadowDecl : getTargetDecl()).
    getDeclContext());
  }

  
  /// \brief Returns \c true if the constructed base class is a virtual base
  /// class subobject of this declaration's class.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::constructsVirtualBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3016,
   FQN="clang::ConstructorUsingShadowDecl::constructsVirtualBase", NM="_ZNK5clang26ConstructorUsingShadowDecl21constructsVirtualBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl21constructsVirtualBaseEv")
  //</editor-fold>
  public boolean constructsVirtualBase() /*const*/ {
    return IsVirtual;
  }

  
  /// \brief Get the constructor or constructor template in the derived class
  /// correspnding to this using shadow declaration, if it has been implicitly
  /// declared already.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::getConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3023,
   FQN="clang::ConstructorUsingShadowDecl::getConstructor", NM="_ZNK5clang26ConstructorUsingShadowDecl14getConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang26ConstructorUsingShadowDecl14getConstructorEv")
  //</editor-fold>
  public CXXConstructorDecl /*P*/ getConstructor() /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::setConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3024,
   FQN="clang::ConstructorUsingShadowDecl::setConstructor", NM="_ZN5clang26ConstructorUsingShadowDecl14setConstructorEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl14setConstructorEPNS_9NamedDeclE")
  //</editor-fold>
  public void setConstructor(NamedDecl /*P*/ Ctor) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3026,
   FQN="clang::ConstructorUsingShadowDecl::classof", NM="_ZN5clang26ConstructorUsingShadowDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3027,
   FQN="clang::ConstructorUsingShadowDecl::classofKind", NM="_ZN5clang26ConstructorUsingShadowDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ConstructorUsingShadow;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorUsingShadowDecl::~ConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2927,
   FQN="clang::ConstructorUsingShadowDecl::~ConstructorUsingShadowDecl", NM="_ZN5clang26ConstructorUsingShadowDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang26ConstructorUsingShadowDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NominatedBaseClassShadowDecl=" + NominatedBaseClassShadowDecl // NOI18N
              + ", ConstructedBaseClassShadowDecl=" + ConstructedBaseClassShadowDecl // NOI18N
              + ", IsVirtual=" + IsVirtual // NOI18N
              + super.toString(); // NOI18N
  }
}
