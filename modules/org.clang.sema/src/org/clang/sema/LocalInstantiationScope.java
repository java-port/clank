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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.sema.impl.SemaTemplateInstantiateStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clank.support.Native.$tryClone;


/// \brief A stack-allocated class that identifies which local
/// variable declaration instantiations are present in this scope.
///
/// A new instance of this class type will be created whenever we
/// instantiate a new function declaration, which will have its own
/// set of parameter declarations.
//<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 178,
 FQN="clang::LocalInstantiationScope", NM="_ZN5clang23LocalInstantiationScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScopeE")
//</editor-fold>
public class LocalInstantiationScope implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief A set of declarations.
  /*typedef SmallVector<ParmVarDecl *, 4> DeclArgumentPack*/
//  public final class DeclArgumentPack extends SmallVector<ParmVarDecl /*P*/ >{ };
/*private:*/
  /// \brief Reference to the semantic analysis that is performing
  /// this template instantiation.
  private final Sema /*&*/ SemaRef;
  
  /*typedef llvm::SmallDenseMap<const Decl *, llvm::PointerUnion<Decl *, DeclArgumentPack *>, 4> LocalDeclsMap*/
//  public final class LocalDeclsMap extends SmallDenseMap</*const*/Decl/*P*/ , PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/>>{ };
  
  /// \brief A mapping from local declarations that occur
  /// within a template to their instantiations.
  ///
  /// This mapping is used during instantiation to keep track of,
  /// e.g., function parameter and variable declarations. For example,
  /// given:
  ///
  /// \code
  ///   template<typename T> T add(T x, T y) { return x + y; }
  /// \endcode
  ///
  /// when we instantiate add<int>, we will introduce a mapping from
  /// the ParmVarDecl for 'x' that occurs in the template to the
  /// instantiated ParmVarDecl for 'x'.
  ///
  /// For a parameter pack, the local instantiation scope may contain a
  /// set of instantiated parameters. This is stored as a DeclArgumentPack
  /// pointer.
  private SmallDenseMap</*const*/Decl/*P*/ , PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/>> LocalDecls;
  
  /// \brief The set of argument packs we've allocated.
  private SmallVector<SmallVector<ParmVarDecl /*P*/ > /*P*/> ArgumentPacks;
  
  /// \brief The outer scope, which contains local variable
  /// definitions from some other instantiation (that may not be
  /// relevant to this particular scope).
  private LocalInstantiationScope /*P*/ Outer;
  
  /// \brief Whether we have already exited this scope.
  private boolean Exited;
  
  /// \brief Whether to combine this scope with the outer scope, such that
  /// lookup will search our outer scope.
  private boolean CombineWithOuterScope;
  
  /// \brief If non-NULL, the template parameter pack that has been
  /// partially substituted per C++0x [temp.arg.explicit]p9.
  private NamedDecl/*P*/ PartiallySubstitutedPack;
  
  /// \brief If \c PartiallySubstitutedPack is non-null, the set of
  /// explicitly-specified template arguments in that pack.
  private /*const*/ type$ptr<TemplateArgument /*P*/> ArgsInPartiallySubstitutedPack;
  
  /// \brief If \c PartiallySubstitutedPack, the number of 
  /// explicitly-specified template arguments in 
  /// ArgsInPartiallySubstitutedPack.
  private /*uint*/int NumArgsInPartiallySubstitutedPack;
  
  // This class is non-copyable
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::LocalInstantiationScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 241,
   FQN="clang::LocalInstantiationScope::LocalInstantiationScope", NM="_ZN5clang23LocalInstantiationScopeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScopeC1ERKS0_")
  //</editor-fold>
  private LocalInstantiationScope(final /*const*/ LocalInstantiationScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 243,
   FQN="clang::LocalInstantiationScope::operator=", NM="_ZN5clang23LocalInstantiationScopeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScopeaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ LocalInstantiationScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::LocalInstantiationScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 246,
   FQN="clang::LocalInstantiationScope::LocalInstantiationScope", NM="_ZN5clang23LocalInstantiationScopeC1ERNS_4SemaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScopeC1ERNS_4SemaEb")
  //</editor-fold>
  public LocalInstantiationScope(final Sema /*&*/ SemaRef) {
    this(SemaRef, false);
  }
  public LocalInstantiationScope(final Sema /*&*/ SemaRef, boolean CombineWithOuterScope/*= false*/) {
    // : SemaRef(SemaRef), LocalDecls(), ArgumentPacks(), Outer(SemaRef.CurrentInstantiationScope), Exited(false), CombineWithOuterScope(CombineWithOuterScope), PartiallySubstitutedPack(null) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.LocalDecls = new SmallDenseMap</*const*/Decl/*P*/ , PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/>>(DenseMapInfo$LikePtr.$Info(), 4, new PointerUnion(Decl/*P*/.class));
    this.ArgumentPacks = new SmallVector<SmallVector<ParmVarDecl /*P*/ > /*P*/>(1, (SmallVector<ParmVarDecl /*P*/ > /*P*/)null);
    this.Outer = SemaRef.CurrentInstantiationScope;
    this.Exited = false;
    this.CombineWithOuterScope = CombineWithOuterScope;
    this.PartiallySubstitutedPack = null;
    //END JInit
    SemaRef.CurrentInstantiationScope = this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::~LocalInstantiationScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 254,
   FQN="clang::LocalInstantiationScope::~LocalInstantiationScope", NM="_ZN5clang23LocalInstantiationScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScopeD0Ev")
  //</editor-fold>
  public void $destroy() {
    Exit();
    //START JDestroy
    ArgumentPacks.$destroy();
    LocalDecls.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 258,
   FQN="clang::LocalInstantiationScope::getSema", NM="_ZNK5clang23LocalInstantiationScope7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZNK5clang23LocalInstantiationScope7getSemaEv")
  //</editor-fold>
  public /*const*/ Sema /*&*/ getSema() /*const*/ {
    return SemaRef;
  }

  
  /// \brief Exit this local instantiation scope early.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::Exit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 261,
   FQN="clang::LocalInstantiationScope::Exit", NM="_ZN5clang23LocalInstantiationScope4ExitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope4ExitEv")
  //</editor-fold>
  public void Exit() {
    if (Exited) {
      return;
    }
    
    for (/*uint*/int I = 0, N = ArgumentPacks.size(); I != N; ++I)  {
      if (ArgumentPacks.$at(I) != null) { ArgumentPacks.$at(I).$destroy();};
    }
    
    SemaRef.CurrentInstantiationScope = Outer;
    Exited = true;
  }

  
  /// \brief Clone this scope, and all outer scopes, down to the given
  /// outermost scope.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::cloneScopes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 274,
   FQN="clang::LocalInstantiationScope::cloneScopes", NM="_ZN5clang23LocalInstantiationScope11cloneScopesEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope11cloneScopesEPS0_")
  //</editor-fold>
  public LocalInstantiationScope /*P*/ cloneScopes(LocalInstantiationScope /*P*/ Outermost) {
    if (this == Outermost) {
      return this;
    }
    
    // Save the current scope from SemaRef since the LocalInstantiationScope
    // will overwrite it on construction
    LocalInstantiationScope /*P*/ oldScope = SemaRef.CurrentInstantiationScope;
    
    LocalInstantiationScope /*P*/ newScope = new LocalInstantiationScope(SemaRef, CombineWithOuterScope);
    
    newScope.Outer = null;
    if ((Outer != null)) {
      newScope.Outer = Outer.cloneScopes(Outermost);
    }
    
    newScope.PartiallySubstitutedPack = PartiallySubstitutedPack;
    newScope.ArgsInPartiallySubstitutedPack = $tryClone(ArgsInPartiallySubstitutedPack);
    newScope.NumArgsInPartiallySubstitutedPack
       = NumArgsInPartiallySubstitutedPack;
    
    for (DenseMapIterator</*const*/Decl/*P*/ , PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/>> I = LocalDecls.begin(), E = LocalDecls.end();
         I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      /*const*/Decl/*P*/ D = I.$arrow().first;
      final PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*&*/ Stored = newScope.LocalDecls.$at_T1$C$R(D);
      if ((I.$arrow().second.is(Decl.class) != 0)) {
        Stored.$assign_T$C$R(Decl/*P*/.class, I.$arrow().second.get(Decl.class));
      } else {
        SmallVector<ParmVarDecl /*P*/ > /*P*/ OldPack = I.$arrow().second.get(SmallVector /*<ParmVarDecl>*/ /*P*/  /*P*/.class);
        SmallVector<ParmVarDecl /*P*/ > /*P*/ NewPack = new SmallVector<ParmVarDecl /*P*/ >($Deref(OldPack));
        ((PointerUnion)Stored).$assign_T1$C$R(SmallVector /*P*/.class, NewPack);
        newScope.ArgumentPacks.push_back(NewPack);
      }
    }
    // Restore the saved scope to SemaRef
    SemaRef.CurrentInstantiationScope = oldScope;
    return newScope;
  }

  
  /// \brief deletes the given scope, and all otuer scopes, down to the
  /// given outermost scope.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::deleteScopes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 314,
   FQN="clang::LocalInstantiationScope::deleteScopes", NM="_ZN5clang23LocalInstantiationScope12deleteScopesEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope12deleteScopesEPS0_S1_")
  //</editor-fold>
  public static void deleteScopes(LocalInstantiationScope /*P*/ Scope, 
              LocalInstantiationScope /*P*/ Outermost) {
    while ((Scope != null) && Scope != Outermost) {
      LocalInstantiationScope /*P*/ Out = Scope.Outer;
      if (Scope != null) { Scope.$destroy();};
      Scope = Out;
    }
  }

  
  /// \brief Find the instantiation of the declaration D within the current
  /// instantiation scope.
  ///
  /// \param D The declaration whose instantiation we are searching for.
  ///
  /// \returns A pointer to the declaration or argument pack of declarations
  /// to which the declaration \c D is instantiated, if found. Otherwise,
  /// returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::findInstantiationOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2764,
   FQN="clang::LocalInstantiationScope::findInstantiationOf", NM="_ZN5clang23LocalInstantiationScope19findInstantiationOfEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope19findInstantiationOfEPKNS_4DeclE")
  //</editor-fold>
  public PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*P*/ findInstantiationOf(/*const*/Decl/*P*/ D) {
    D = getCanonicalParmVarDecl(D);
    for (LocalInstantiationScope /*P*/ Current = this; (Current != null);
         Current = Current.Outer) {
      
      // Check if we found something within this scope.
      /*const*/Decl/*P*/ CheckD = D;
      do {
        DenseMapIterator</*const*/Decl/*P*/ , PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/>> Found = Current.LocalDecls.find(CheckD);
        if (Found.$noteq(/*NO_ITER_COPY*/Current.LocalDecls.end())) {
          return $AddrOf(Found.$arrow().second);
        }
        {
          
          // If this is a tag declaration, it's possible that we need to look for
          // a previous declaration.
          /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(CheckD);
          if ((Tag != null)) {
            CheckD = Tag.getPreviousDecl$Const();
          } else {
            CheckD = null;
          }
        }
      } while ((CheckD != null));
      
      // If we aren't combined with our outer scope, we're done. 
      if (!Current.CombineWithOuterScope) {
        break;
      }
    }
    
    // If we're performing a partial substitution during template argument
    // deduction, we may not have values for template parameters yet.
    if (isa_NonTypeTemplateParmDecl(D) || isa_TemplateTypeParmDecl(D)
       || isa_TemplateTemplateParmDecl(D)) {
      return null;
    }
    {
      
      // Local types referenced prior to definition may require instantiation.
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
      if ((RD != null)) {
        if ((RD.isLocalClass$Const() != null)) {
          return null;
        }
      }
    }
    
    // Enumeration types referenced prior to definition may appear as a result of
    // error recovery.
    if (isa_EnumDecl(D)) {
      return null;
    }
    
    // If we didn't find the decl, then we either have a sema bug, or we have a
    // forward reference to a label declaration.  Return null to indicate that
    // we have an uninstantiated label.
    assert (isa_LabelDecl(D)) : "declaration not instantiated in this scope";
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::InstantiatedLocal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2813,
   FQN="clang::LocalInstantiationScope::InstantiatedLocal", NM="_ZN5clang23LocalInstantiationScope17InstantiatedLocalEPKNS_4DeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope17InstantiatedLocalEPKNS_4DeclEPS1_")
  //</editor-fold>
  public void InstantiatedLocal(/*const*/Decl/*P*/ D, Decl/*P*/ Inst) {
    D = getCanonicalParmVarDecl(D);
    final PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*&*/ Stored = LocalDecls.$at_T1$C$R(D);
    if (Stored.isNull()) {
      // It should not be present in any surrounding scope either.
      LocalInstantiationScope /*P*/ Current = this;
      while (Current.CombineWithOuterScope && (Current.Outer != null)) {
        Current = Current.Outer;
        assert (Current.LocalDecls.find(D).$eq(/*NO_ITER_COPY*/Current.LocalDecls.end())) : "Instantiated local in inner and outer scopes";
      }
      Stored.$assign_T$C$R(Decl/*P*/.class, Inst);
    } else {
      SmallVector<ParmVarDecl /*P*/ > /*P*/ Pack = Stored.dyn_cast(SmallVector/*<ParmVarDecl>*/ /*P*/  /*P*/.class);
      if ((Pack != null)) {
        Pack.push_back(cast_ParmVarDecl(Inst));
      } else {
        assert (Stored.get(Decl.class) == Inst) : "Already instantiated this local";
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::InstantiatedLocalPackArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2834,
   FQN="clang::LocalInstantiationScope::InstantiatedLocalPackArg", NM="_ZN5clang23LocalInstantiationScope24InstantiatedLocalPackArgEPKNS_4DeclEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope24InstantiatedLocalPackArgEPKNS_4DeclEPNS_11ParmVarDeclE")
  //</editor-fold>
  public void InstantiatedLocalPackArg(/*const*/Decl/*P*/ D, 
                          ParmVarDecl /*P*/ Inst) {
    D = getCanonicalParmVarDecl(D);
    SmallVector<ParmVarDecl /*P*/ > /*P*/ Pack = LocalDecls.$at_T1$C$R(D).get(SmallVector/*<ParmVarDecl>*/ /*P*/  /*P*/.class);
    Pack.push_back(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::MakeInstantiatedLocalArgPack">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2841,
   FQN="clang::LocalInstantiationScope::MakeInstantiatedLocalArgPack", NM="_ZN5clang23LocalInstantiationScope28MakeInstantiatedLocalArgPackEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope28MakeInstantiatedLocalArgPackEPKNS_4DeclE")
  //</editor-fold>
  public void MakeInstantiatedLocalArgPack(/*const*/Decl/*P*/ D) {
    if (NativeTrace.isDebugMode()) {
      // This should be the first time we've been told about this decl.
      for (LocalInstantiationScope /*P*/ Current = this;
           (Current != null) && Current.CombineWithOuterScope; Current = Current.Outer)  {
        assert (Current.LocalDecls.find(D).$eq(/*NO_ITER_COPY*/Current.LocalDecls.end())) : "Creating local pack after instantiation of local";
      }
    }
    
    D = getCanonicalParmVarDecl(D);
    final PointerUnion<Decl/*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*&*/ Stored = LocalDecls.$at_T1$C$R(D);
    SmallVector<ParmVarDecl /*P*/ > /*P*/ Pack = new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
    ((PointerUnion)Stored).$assign_T1$C$R(SmallVector /*P*/.class, Pack);
    ArgumentPacks.push_back(Pack);
  }

  
  /// \brief Note that the given parameter pack has been partially substituted
  /// via explicit specification of template arguments 
  /// (C++0x [temp.arg.explicit]p9).
  ///
  /// \param Pack The parameter pack, which will always be a template
  /// parameter pack.
  ///
  /// \param ExplicitArgs The explicitly-specified template arguments provided
  /// for this parameter pack.
  ///
  /// \param NumExplicitArgs The number of explicitly-specified template
  /// arguments provided for this parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::SetPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2857,
   FQN="clang::LocalInstantiationScope::SetPartiallySubstitutedPack", NM="_ZN5clang23LocalInstantiationScope27SetPartiallySubstitutedPackEPNS_9NamedDeclEPKNS_16TemplateArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope27SetPartiallySubstitutedPackEPNS_9NamedDeclEPKNS_16TemplateArgumentEj")
  //</editor-fold>
  public void SetPartiallySubstitutedPack(NamedDecl/*P*/ Pack, 
                             /*const*/ type$ptr<TemplateArgument /*P*/> ExplicitArgs, 
                             /*uint*/int NumExplicitArgs) {
    assert ((!(PartiallySubstitutedPack != null) || PartiallySubstitutedPack == Pack)) : "Already have a partially-substituted pack";
    assert ((!(PartiallySubstitutedPack != null) || NumArgsInPartiallySubstitutedPack == NumExplicitArgs)) : "Wrong number of arguments in partially-substituted pack";
    PartiallySubstitutedPack = Pack;
    ArgsInPartiallySubstitutedPack = $tryClone(ExplicitArgs);
    NumArgsInPartiallySubstitutedPack = NumExplicitArgs;
  }

  
  /// \brief Reset the partially-substituted pack when it is no longer of
  /// interest.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::ResetPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 356,
   FQN="clang::LocalInstantiationScope::ResetPartiallySubstitutedPack", NM="_ZN5clang23LocalInstantiationScope29ResetPartiallySubstitutedPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang23LocalInstantiationScope29ResetPartiallySubstitutedPackEv")
  //</editor-fold>
  public void ResetPartiallySubstitutedPack() {
    assert ((PartiallySubstitutedPack != null)) : "No partially-substituted pack";
    PartiallySubstitutedPack = null;
    ArgsInPartiallySubstitutedPack = null;
    NumArgsInPartiallySubstitutedPack = 0;
  }

  
  /// \brief Retrieve the partially-substitued template parameter pack.
  ///
  /// If there is no partially-substituted parameter pack, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::LocalInstantiationScope::getPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*type$ptr<type$ptr>>*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2870,
   FQN="clang::LocalInstantiationScope::getPartiallySubstitutedPack", NM="_ZNK5clang23LocalInstantiationScope27getPartiallySubstitutedPackEPPKNS_16TemplateArgumentEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZNK5clang23LocalInstantiationScope27getPartiallySubstitutedPackEPPKNS_16TemplateArgumentEPj")
  //</editor-fold>
  public NamedDecl/*P*/ getPartiallySubstitutedPack() /*const*/ {
    return getPartiallySubstitutedPack((/*const*/ type$ptr<type$ptr<TemplateArgument>> /*P*/ /*P*/ )null, 
                             (uint$ptr/*uint P*/ )null);
  }
  public NamedDecl/*P*/ getPartiallySubstitutedPack(/*const*/ type$ptr<type$ptr<TemplateArgument>> /*P*/ /*P*/ ExplicitArgs/*= null*/) /*const*/ {
    return getPartiallySubstitutedPack(ExplicitArgs, 
                             (uint$ptr/*uint P*/ )null);
  }
  public NamedDecl/*P*/ getPartiallySubstitutedPack(/*const*/ type$ptr<type$ptr<TemplateArgument>> /*P*/ /*P*/ ExplicitArgs/*= null*/, 
                             uint$ptr/*uint P*/ NumExplicitArgs/*= null*/) /*const*/ {
    if ((ExplicitArgs != null)) {
      ExplicitArgs.$set(null);
    }
    if ((NumExplicitArgs != null)) {
      NumExplicitArgs.$set(0);
    }
    
    for (/*const*/ LocalInstantiationScope /*P*/ Current = this; (Current != null);
         Current = Current.Outer) {
      if ((Current.PartiallySubstitutedPack != null)) {
        if ((ExplicitArgs != null)) {
          ExplicitArgs.$set($tryClone(Current.ArgsInPartiallySubstitutedPack));
        }
        if ((NumExplicitArgs != null)) {
          NumExplicitArgs.$set(Current.NumArgsInPartiallySubstitutedPack);
        }
        
        return Current.PartiallySubstitutedPack;
      }
      if (!Current.CombineWithOuterScope) {
        break;
      }
    }
    
    return null;
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", LocalDecls=" + LocalDecls // NOI18N
              + ", ArgumentPacks=" + ArgumentPacks // NOI18N
              + ", Outer=" + Outer // NOI18N
              + ", Exited=" + Exited // NOI18N
              + ", CombineWithOuterScope=" + CombineWithOuterScope // NOI18N
              + ", PartiallySubstitutedPack=" + PartiallySubstitutedPack // NOI18N
              + ", ArgsInPartiallySubstitutedPack=" + ArgsInPartiallySubstitutedPack // NOI18N
              + ", NumArgsInPartiallySubstitutedPack=" + NumArgsInPartiallySubstitutedPack; // NOI18N
  }
}
