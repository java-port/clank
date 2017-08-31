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
import static org.clank.support.Native.*;
import org.clang.basic.*;


/// \brief Declaration of a function specialization at template class scope.
///
/// This is a non-standard extension needed to support MSVC.
///
/// For example:
/// \code
/// template <class T>
/// class A {
///    template <class U> void foo(U a) { }
///    template<> void foo(int a) { }
/// }
/// \endcode
///
/// "template<> foo(int a)" will be saved in Specialization as a normal
/// CXXMethodDecl. Then during an instantiation of class A, it will be
/// transformed into an actual function specialization.
//<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2312,
 FQN="clang::ClassScopeFunctionSpecializationDecl", NM="_ZN5clang36ClassScopeFunctionSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDeclE")
//</editor-fold>
public class ClassScopeFunctionSpecializationDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ClassScopeFunctionSpecializationDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 921,
   FQN="clang::ClassScopeFunctionSpecializationDecl::anchor", NM="_ZN5clang36ClassScopeFunctionSpecializationDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::ClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2315,
   FQN="clang::ClassScopeFunctionSpecializationDecl::ClassScopeFunctionSpecializationDecl", NM="_ZN5clang36ClassScopeFunctionSpecializationDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_13CXXMethodDeclEbNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_13CXXMethodDeclEbNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  private ClassScopeFunctionSpecializationDecl(DeclContext /*P*/ DC, SourceLocation Loc, 
      CXXMethodDecl /*P*/ FD, boolean Args, 
      TemplateArgumentListInfo TemplArgs) {
    // : Decl(Decl::ClassScopeFunctionSpecialization, DC, Loc), Specialization(FD), HasExplicitTemplateArgs(Args), TemplateArgs(std::move(TemplArgs)) 
    //START JInit
    super(Decl.Kind.ClassScopeFunctionSpecialization, DC, new SourceLocation(Loc));
    this.Specialization = FD;
    this.HasExplicitTemplateArgs = Args;
    this.TemplateArgs = new TemplateArgumentListInfo(JD$Move.INSTANCE, std.move(TemplArgs));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::ClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2322,
   FQN="clang::ClassScopeFunctionSpecializationDecl::ClassScopeFunctionSpecializationDecl", NM="_ZN5clang36ClassScopeFunctionSpecializationDeclC1ENS_4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDeclC1ENS_4Decl10EmptyShellE")
  //</editor-fold>
  private ClassScopeFunctionSpecializationDecl(EmptyShell Empty) {
    // : Decl(Decl::ClassScopeFunctionSpecialization, Empty), TemplateArgs() 
    //START JInit
    super(Decl.Kind.ClassScopeFunctionSpecialization, new EmptyShell(Empty));
    this.TemplateArgs = new TemplateArgumentListInfo();
    //END JInit
  }

  
  /*friend*/public CXXMethodDecl /*P*/ Specialization;
  private boolean HasExplicitTemplateArgs;
  private TemplateArgumentListInfo TemplateArgs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::getSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2330,
   FQN="clang::ClassScopeFunctionSpecializationDecl::getSpecialization", NM="_ZNK5clang36ClassScopeFunctionSpecializationDecl17getSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36ClassScopeFunctionSpecializationDecl17getSpecializationEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getSpecialization() /*const*/ {
    return Specialization;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2331,
   FQN="clang::ClassScopeFunctionSpecializationDecl::hasExplicitTemplateArgs", NM="_ZNK5clang36ClassScopeFunctionSpecializationDecl23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36ClassScopeFunctionSpecializationDecl23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return HasExplicitTemplateArgs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::templateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2332,
   FQN="clang::ClassScopeFunctionSpecializationDecl::templateArgs", NM="_ZNK5clang36ClassScopeFunctionSpecializationDecl12templateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36ClassScopeFunctionSpecializationDecl12templateArgsEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentListInfo /*&*/ templateArgs() /*const*/ {
    return TemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2334,
   FQN="clang::ClassScopeFunctionSpecializationDecl::Create", NM="_ZN5clang36ClassScopeFunctionSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_13CXXMethodDeclEbNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_13CXXMethodDeclEbNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static ClassScopeFunctionSpecializationDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation Loc, 
        CXXMethodDecl /*P*/ FD, 
        boolean HasExplicitTemplateArgs, 
        TemplateArgumentListInfo TemplateArgs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(/*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
          return new ClassScopeFunctionSpecializationDecl(DC, new SourceLocation(Loc), FD, HasExplicitTemplateArgs, $c$.track(new TemplateArgumentListInfo(JD$Move.INSTANCE, std.move(TemplateArgs))));
       }));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 923,
   FQN="clang::ClassScopeFunctionSpecializationDecl::CreateDeserialized", NM="_ZN5clang36ClassScopeFunctionSpecializationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ClassScopeFunctionSpecializationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(/*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
          return new ClassScopeFunctionSpecializationDecl((DeclContext /*P*/ )null, new SourceLocation(), (CXXMethodDecl /*P*/ )null, false, $c$.track(new TemplateArgumentListInfo()));
       }));
    } finally {
      $c$.$destroy();
    }
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2348,
   FQN="clang::ClassScopeFunctionSpecializationDecl::classof", NM="_ZN5clang36ClassScopeFunctionSpecializationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2349,
   FQN="clang::ClassScopeFunctionSpecializationDecl::classofKind", NM="_ZN5clang36ClassScopeFunctionSpecializationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Decl.Kind.ClassScopeFunctionSpecialization;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassScopeFunctionSpecializationDecl::~ClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2312,
   FQN="clang::ClassScopeFunctionSpecializationDecl::~ClassScopeFunctionSpecializationDecl", NM="_ZN5clang36ClassScopeFunctionSpecializationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36ClassScopeFunctionSpecializationDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TemplateArgs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Specialization=" + Specialization // NOI18N
              + ", HasExplicitTemplateArgs=" + HasExplicitTemplateArgs // NOI18N
              + ", TemplateArgs=" + TemplateArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
