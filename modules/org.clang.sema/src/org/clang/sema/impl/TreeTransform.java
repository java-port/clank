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

package org.clang.sema.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.ast.NestedNameSpecifierLoc.*;
import static org.clang.ast.UsingDecl.shadow_iterator.$eq_shadow_iterator;
import static org.clang.sema.impl.TreeTransformClangStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief A semantic tree transformation that allows one to transform one
/// abstract syntax tree into another.
///
/// A new tree transformation is defined by creating a new subclass \c X of
/// \c TreeTransform<X> and then overriding certain operations to provide
/// behavior specific to that transformation. For example, template
/// instantiation is implemented as a tree transformation where the
/// transformation of TemplateTypeParmType nodes involves substituting the
/// template arguments for their corresponding template parameters; a similar
/// transformation is performed for non-type template parameters and
/// template template parameters.
///
/// This tree-transformation template uses static polymorphism to allow
/// subclasses to customize any of its operations. Thus, a subclass can
/// override any of the transformation or rebuild operators by providing an
/// operation with the same signature as the default implementation. The
/// overridding function should not be virtual.
///
/// Semantic tree transformations are split into two stages, either of which
/// can be replaced by a subclass. The "transform" step transforms an AST node
/// or the parts of an AST node using the various transformation functions,
/// then passes the pieces on to the "rebuild" step, which constructs a new AST
/// node of the appropriate kind from the pieces. The default transformation
/// routines recursively transform the operands to composite AST nodes (e.g.,
/// the pointee type of a PointerType node) and, if any of those operand nodes
/// were changed by the transformation, invokes the rebuild operation to create
/// a new AST node.
///
/// Subclasses can customize the transformation at various levels. The
/// most coarse-grained transformations involve replacing TransformType(),
/// TransformExpr(), TransformDecl(), TransformNestedNameSpecifierLoc(),
/// TransformTemplateName(), or TransformTemplateArgument() with entirely
/// new implementations.
///
/// For more fine-grained transformations, subclasses can replace any of the
/// \c TransformXXX functions (where XXX is the name of an AST node, e.g.,
/// PointerType, StmtExpr) to alter the transformation. As mentioned previously,
/// replacing TransformTemplateTypeParmType() allows template instantiation
/// to substitute template arguments for their corresponding template
/// parameters. Additionally, subclasses can override the \c RebuildXXX
/// functions to control how AST nodes are rebuilt when their operands change.
/// By default, \c TreeTransform will invoke semantic analysis to rebuild
/// AST nodes. However, certain other tree transformations (e.g, cloning) may
/// be able to use more efficient rebuild steps.
///
/// There are a handful of other functions that can be overridden, allowing one
/// to avoid traversing nodes that don't need any transformation
/// (\c AlreadyTransformed()), force rebuilding AST nodes even when their
/// operands have not changed (\c AlwaysRebuild()), and customize the
/// default locations and entity names used for type-checking
/// (\c getBaseLocation(), \c getBaseEntity()).
//<editor-fold defaultstate="collapsed" desc="clang::TreeTransform">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 94,
 FQN="clang::TreeTransform", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEEE")
//</editor-fold>
public class TreeTransform<Derived extends TreeTransform> implements Destructors.ClassWithDestructor {
  /// \brief Private RAII object that helps us forget and then re-remember
  /// the template argument corresponding to a partially-substituted parameter
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 99,
   FQN="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIIE")
  //</editor-fold>
  private static class ForgetPartiallySubstitutedPackRAII<Derived extends TreeTransform> implements Destructors.ClassWithDestructor {
    private final Derived /*&*/ Self;
    private TemplateArgument Old;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII::ForgetPartiallySubstitutedPackRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 104,
     FQN="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII::ForgetPartiallySubstitutedPackRAII", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIIC1ERS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIIC1ERS2_")
    //</editor-fold>
    public ForgetPartiallySubstitutedPackRAII(final Derived /*&*/ Self) {
      // : Self(Self), Old() 
      //START JInit
      this./*&*/Self=/*&*/Self;
      this.Old = new TemplateArgument();
      //END JInit
      Old.$assignMove(Self.ForgetPartiallySubstitutedPack());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII::~ForgetPartiallySubstitutedPackRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 108,
     FQN="clang::TreeTransform::ForgetPartiallySubstitutedPackRAII::~ForgetPartiallySubstitutedPackRAII", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIID0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34ForgetPartiallySubstitutedPackRAIID0Ev")
    //</editor-fold>
    public void $destroy() {
      Self.RememberPartiallySubstitutedPack(new TemplateArgument(Old));
    }

    
    @Override public String toString() {
      return "" + "Self=" + Self // NOI18N
                + ", Old=" + Old; // NOI18N
    }
  };
/*protected:*/
  protected final Sema /*&*/ SemaRef;
  
  /// \brief The set of local declarations that have been transformed, for
  /// cases where we are forced to build new declarations within the transformer
  /// rather than in the subclass (e.g., lambda closure types).
  protected DenseMap<Decl /*P*/ , Decl /*P*/ > TransformedLocalDecls;
/*public:*/
  /// \brief Initializes a new tree transformer.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TreeTransform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 123,
   FQN="clang::TreeTransform::TreeTransform", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEEC1ERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEEC1ERNS_4SemaE")
  //</editor-fold>
  public TreeTransform(final Sema /*&*/ SemaRef) {
    // : SemaRef(SemaRef), TransformedLocalDecls() 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.TransformedLocalDecls = new DenseMap<Decl /*P*/ , Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl /*P*/ )null);
    //END JInit
  }

  
  /// \brief Retrieves a reference to the derived class.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::getDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 126,
   FQN="clang::TreeTransform::getDerived", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE10getDerivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE10getDerivedEv")
  //</editor-fold>
  public Derived /*&*/ getDerived() {
    return ((/*static_cast*/Derived /*&*/ )(/*Deref*/this));
  }

  
  /// \brief Retrieves a reference to the derived class.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::getDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 129,
   FQN="clang::TreeTransform::getDerived", NM="_ZNK5clang13TreeTransform10getDerivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang13TreeTransform10getDerivedEv")
  //</editor-fold>
  public /*const*/ Derived /*&*/ getDerived$Const() /*const*/ {
    return ((/*static_cast*//*const*/ Derived /*&*/ )(Native.$star(this)));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::Owned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 133,
   FQN="clang::TreeTransform::Owned", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE5OwnedEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE5OwnedEPNS_4ExprE")
  //</editor-fold>
  public static /*inline*/ ActionResultTTrue<Expr /*P*/ > Owned(Expr /*P*/ E) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::Owned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 134,
   FQN="clang::TreeTransform::Owned", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE5OwnedEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE5OwnedEPNS_4StmtE")
  //</editor-fold>
  public static /*inline*/ ActionResultTTrue<Stmt /*P*/ > Owned(Stmt /*P*/ S) {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  
  /// \brief Retrieves a reference to the semantic analysis object used for
  /// this tree transform.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 138,
   FQN="clang::TreeTransform::getSema", NM="_ZNK5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZNK5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    return SemaRef;
  }

  
  /// \brief Whether the transformation should always rebuild AST nodes, even
  /// if none of the children have changed.
  ///
  /// Subclasses may override this function to specify when the transformation
  /// should rebuild all AST nodes.
  ///
  /// We must always rebuild all AST nodes when performing variadic template
  /// pack expansion, in order to avoid violating the AST invariant that each
  /// statement node appears at most once in its containing declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::AlwaysRebuild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 149,
   FQN="clang::TreeTransform::AlwaysRebuild", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13AlwaysRebuildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13AlwaysRebuildEv")
  //</editor-fold>
  public boolean AlwaysRebuild() {
    return SemaRef.ArgumentPackSubstitutionIndex != -1;
  }

  
  /// \brief Returns the location of the entity being transformed, if that
  /// information was not available elsewhere in the AST.
  ///
  /// By default, returns no source-location information. Subclasses can
  /// provide an alternative implementation that provides better location
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::getBaseLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 157,
   FQN="clang::TreeTransform::getBaseLocation", NM="_ZN5clang13TreeTransform15getBaseLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform15getBaseLocationEv")
  //</editor-fold>
  public SourceLocation getBaseLocation() {
    return new SourceLocation();
  }


  
  /// \brief Returns the name of the entity being transformed, if that
  /// information was not available elsewhere in the AST.
  ///
  /// By default, returns an empty name. Subclasses can provide an alternative
  /// implementation with a more precise name.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::getBaseEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 164,
   FQN="clang::TreeTransform::getBaseEntity", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13getBaseEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13getBaseEntityEv")
  //</editor-fold>
  public DeclarationName getBaseEntity() {
    return new DeclarationName();
  }

  
  /// \brief Sets the "base" location and entity when that
  /// information is known based on another transformation.
  ///
  /// By default, the source location and entity are ignored. Subclasses can
  /// override this function to provide a customized implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 171,
   FQN="clang::TreeTransform::setBase", NM="_ZN5clang13TreeTransform7setBaseENS_14SourceLocationENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform7setBaseENS_14SourceLocationENS_15DeclarationNameE")
  //</editor-fold>
  public void setBase(SourceLocation Loc, DeclarationName Entity) {
  }


  
  /// \brief RAII object that temporarily sets the base location and entity
  /// used for reporting diagnostics in types.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TemporaryBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 175,
   FQN="clang::TreeTransform::TemporaryBase", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseE")
  //</editor-fold>
  public static class TemporaryBase<Derived extends TreeTransform> implements Destructors.ClassWithDestructor {
    private final TreeTransform<Derived> /*&*/ Self;
    private SourceLocation OldLocation;
    private DeclarationName OldEntity;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TemporaryBase::TemporaryBase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 181,
     FQN="clang::TreeTransform::TemporaryBase::TemporaryBase", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseC1ERS3_NS_14SourceLocationENS_15DeclarationNameE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseC1ERS3_NS_14SourceLocationENS_15DeclarationNameE")
    //</editor-fold>
    public TemporaryBase(final TreeTransform<Derived> /*&*/ Self, SourceLocation Location,
        DeclarationName Entity) {
      // : Self(Self), OldLocation(), OldEntity() 
      //START JInit
      this./*&*/Self=/*&*/Self;
      this.OldLocation = new SourceLocation();
      this.OldEntity = new DeclarationName();
      //END JInit
      OldLocation.$assignMove(Self.getDerived().getBaseLocation());
      OldEntity.$assignMove(Self.getDerived().getBaseEntity());
      if (Location.isValid()) {
        Self.getDerived().setBase(new SourceLocation(Location), new DeclarationName(Entity));
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TemporaryBase::~TemporaryBase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 190,
     FQN="clang::TreeTransform::TemporaryBase::~TemporaryBase", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TemporaryBaseD0Ev")
    //</editor-fold>
    public void $destroy() {
      Self.getDerived().setBase(new SourceLocation(OldLocation), new DeclarationName(OldEntity));
    }

    
    @Override public String toString() {
      return "" + "Self=" + Self // NOI18N
                + ", OldLocation=" + OldLocation // NOI18N
                + ", OldEntity=" + OldEntity; // NOI18N
    }
  };
  
  /// \brief Determine whether the given type \p T has already been
  /// transformed.
  ///
  /// Subclasses can provide an alternative implementation of this routine
  /// to short-circuit evaluation when it is known that a given type will
  /// not change. For example, template instantiation need not traverse
  /// non-dependent types.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::AlreadyTransformed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 202,
   FQN="clang::TreeTransform::AlreadyTransformed", NM="_ZN5clang13TreeTransform18AlreadyTransformedENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform18AlreadyTransformedENS_8QualTypeE")
  //</editor-fold>
  public boolean AlreadyTransformed(QualType T) {
    return T.isNull();
  }


  
  /// \brief Determine whether the given call argument should be dropped, e.g.,
  /// because it is a default argument.
  ///
  /// Subclasses can provide an alternative implementation of this routine to
  /// determine which kinds of call arguments get dropped. By default,
  /// CXXDefaultArgument nodes are dropped (prior to transformation).
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::DropCallArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 212,
   FQN="clang::TreeTransform::DropCallArgument", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16DropCallArgumentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16DropCallArgumentEPNS_4ExprE")
  //</editor-fold>
  public boolean DropCallArgument(Expr /*P*/ E) {
    return E.isDefaultArgument();
  }

  
  /// \brief Determine whether we should expand a pack expansion with the
  /// given set of parameter packs into separate arguments by repeatedly
  /// transforming the pattern.
  ///
  /// By default, the transformer never tries to expand pack expansions.
  /// Subclasses can override this routine to provide different behavior.
  ///
  /// \param EllipsisLoc The location of the ellipsis that identifies the
  /// pack expansion.
  ///
  /// \param PatternRange The source range that covers the entire pattern of
  /// the pack expansion.
  ///
  /// \param Unexpanded The set of unexpanded parameter packs within the
  /// pattern.
  ///
  /// \param ShouldExpand Will be set to \c true if the transformer should
  /// expand the corresponding pack expansions into separate arguments. When
  /// set, \c NumExpansions must also be set.
  ///
  /// \param RetainExpansion Whether the caller should add an unexpanded
  /// pack expansion after all of the expanded arguments. This is used
  /// when extending explicitly-specified template argument packs per
  /// C++0x [temp.arg.explicit]p9.
  ///
  /// \param NumExpansions The number of separate arguments that will be in
  /// the expanded form of the corresponding pack expansion. This is both an
  /// input and an output parameter, which can be set by the caller if the
  /// number of expansions is known a priori (e.g., due to a prior substitution)
  /// and will be set by the callee when the number of expansions is known.
  /// The callee must set this value when \c ShouldExpand is \c true; it may
  /// set this value in other cases.
  ///
  /// \returns true if an error occurred (e.g., because the parameter packs
  /// are to be instantiated with arguments of different lengths), false
  /// otherwise. If false, \c ShouldExpand (and possibly \c NumExpansions)
  /// must be set.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TryExpandParameterPacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 253,
   FQN="clang::TreeTransform::TryExpandParameterPacks", NM="_ZN5clang13TreeTransform23TryExpandParameterPacksENS_14SourceLocationENS_11SourceRangeEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEERbSF_RNS3_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform23TryExpandParameterPacksENS_14SourceLocationENS_11SourceRangeEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEERbSF_RNS3_8OptionalIjEE")
  //</editor-fold>
  public boolean TryExpandParameterPacks(SourceLocation EllipsisLoc, 
                         SourceRange PatternRange, 
                         ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded, 
                         final bool$ref/*bool &*/ ShouldExpand, 
                         final bool$ref/*bool &*/ RetainExpansion, 
                         final OptionalUInt /*&*/ NumExpansions) {
    ShouldExpand.$set(false);
    return false;
  }


  
  /// \brief "Forget" about the partially-substituted pack template argument,
  /// when performing an instantiation that must preserve the parameter pack
  /// use.
  ///
  /// This routine is meant to be overridden by the template instantiator.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::ForgetPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 268,
   FQN="clang::TreeTransform::ForgetPartiallySubstitutedPack", NM="_ZN5clang13TreeTransform30ForgetPartiallySubstitutedPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform30ForgetPartiallySubstitutedPackEv")
  //</editor-fold>
  public TemplateArgument ForgetPartiallySubstitutedPack() {
    return new TemplateArgument();
  }


  
  /// \brief "Remember" the partially-substituted pack template argument
  /// after performing an instantiation that must preserve the parameter pack
  /// use.
  ///
  /// This routine is meant to be overridden by the template instantiator.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RememberPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 277,
   FQN="clang::TreeTransform::RememberPartiallySubstitutedPack", NM="_ZN5clang13TreeTransform32RememberPartiallySubstitutedPackENS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform32RememberPartiallySubstitutedPackENS_16TemplateArgumentE")
  //</editor-fold>
  public void RememberPartiallySubstitutedPack(TemplateArgument Arg) {
  }


  
  /// \brief Note to the derived class when a function parameter pack is
  /// being expanded.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::ExpandingFunctionParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 281,
   FQN="clang::TreeTransform::ExpandingFunctionParameterPack", NM="_ZN5clang13TreeTransform30ExpandingFunctionParameterPackEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform30ExpandingFunctionParameterPackEPNS_11ParmVarDeclE")
  //</editor-fold>
  public void ExpandingFunctionParameterPack(ParmVarDecl /*P*/ Pack) {
  }


  /// \brief Transforms the given type into another type.
  ///
  /// By default, this routine transforms a type by creating a
  /// TypeSourceInfo for it and delegating to the appropriate
  /// function.  This is expensive, but we don't mind, because
  /// this method is deprecated anyway;  all users should be
  /// switched to storing TypeSourceInfos.
  ///
  /// \returns the transformed type.
  
  //===----------------------------------------------------------------------===//
  // Type transformation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3975,
   FQN="clang::TreeTransform::TransformType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType TransformType(QualType T) {
    if (getDerived().AlreadyTransformed(new QualType(T))) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    
    // Temporary workaround.  All of these transformations should
    // eventually turn into transformations on TypeLocs.
    TypeSourceInfo /*P*/ DI = getSema().Context.getTrivialTypeSourceInfo(new QualType(T), 
        getDerived().getBaseLocation());
    
    TypeSourceInfo /*P*/ NewDI = getDerived().TransformType(DI);
    if (!(NewDI != null)) {
      return new QualType();
    }
    
    return NewDI.getType();
  }

  
  /// \brief Transforms the given type-with-location into a new
  /// type-with-location.
  ///
  /// By default, this routine transforms a type by delegating to the
  /// appropriate TransformXXXType to build a new type.  Subclasses
  /// may override this function (to take over all type
  /// transformations) or some set of the TransformXXXType functions
  /// to alter the transformation.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3993,
   FQN="clang::TreeTransform::TransformType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ TransformType(TypeSourceInfo /*P*/ DI) {
    TemporaryBase Rebase = null;
    TypeLocBuilder TLB = null;
    try {
      // Refine the base location to the type's location.
      Rebase/*J*/= new TemporaryBase(/*Deref*/this, DI.getTypeLoc().getBeginLoc(), 
          getDerived().getBaseEntity());
      if (getDerived().AlreadyTransformed(DI.getType())) {
        return DI;
      }
      
      TLB/*J*/= new TypeLocBuilder();
      
      TypeLoc TL = DI.getTypeLoc();
      TLB.reserve(TL.getFullDataSize());
      
      QualType Result = getDerived().TransformType(TLB, new TypeLoc(TL));
      if (Result.isNull()) {
        return null;
      }
      
      return TLB.getTypeSourceInfo(SemaRef.Context, new QualType(Result));
    } finally {
      if (TLB != null) { TLB.$destroy(); }
      if (Rebase != null) { Rebase.$destroy(); }
    }
  }

  
  /// \brief Transform the given type-with-location into a new
  /// type, collecting location information in the given builder
  /// as necessary.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4013,
   FQN="clang::TreeTransform::TransformType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeERNS_14TypeLocBuilderENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformTypeERNS_14TypeLocBuilderENS_7TypeLocE")
  //</editor-fold>
  public QualType TransformType(final TypeLocBuilder /*&*/ TLB, TypeLoc T) {
    switch (T.getTypeLocClass()) {
     case Qualified:
      return getDerived().TransformQualifiedType(TLB, T.castAs(QualifiedTypeLoc.class));
     case Builtin:
      return getDerived().TransformBuiltinType(TLB, T.castAs(BuiltinTypeLoc.class));
     case Complex:
      return getDerived().TransformComplexType(TLB, T.castAs(ComplexTypeLoc.class));
     case Pointer:
      return getDerived().TransformPointerType(TLB, T.castAs(PointerTypeLoc.class));
     case BlockPointer:
      return getDerived().TransformBlockPointerType(TLB, T.castAs(BlockPointerTypeLoc.class));
     case LValueReference:
      return getDerived().TransformLValueReferenceType(TLB, T.castAs(LValueReferenceTypeLoc.class));
     case RValueReference:
      return getDerived().TransformRValueReferenceType(TLB, T.castAs(RValueReferenceTypeLoc.class));
     case MemberPointer:
      return getDerived().TransformMemberPointerType(TLB, T.castAs(MemberPointerTypeLoc.class));
     case ConstantArray:
      return getDerived().TransformConstantArrayType(TLB, T.castAs(ConstantArrayTypeLoc.class));
     case IncompleteArray:
      return getDerived().TransformIncompleteArrayType(TLB, T.castAs(IncompleteArrayTypeLoc.class));
     case VariableArray:
      return getDerived().TransformVariableArrayType(TLB, T.castAs(VariableArrayTypeLoc.class));
     case DependentSizedArray:
      return getDerived().TransformDependentSizedArrayType(TLB, T.castAs(DependentSizedArrayTypeLoc.class));
     case DependentSizedExtVector:
      return getDerived().TransformDependentSizedExtVectorType(TLB, T.castAs(DependentSizedExtVectorTypeLoc.class));
     case Vector:
      return getDerived().TransformVectorType(TLB, T.castAs(VectorTypeLoc.class));
     case ExtVector:
      return getDerived().TransformExtVectorType(TLB, T.castAs(ExtVectorTypeLoc.class));
     case FunctionProto:
      return getDerived().TransformFunctionProtoType(TLB, T.castAs(FunctionProtoTypeLoc.class));
     case FunctionNoProto:
      return getDerived().TransformFunctionNoProtoType(TLB, T.castAs(FunctionNoProtoTypeLoc.class));
     case UnresolvedUsing:
      return getDerived().TransformUnresolvedUsingType(TLB, T.castAs(UnresolvedUsingTypeLoc.class));
     case Paren:
      return getDerived().TransformParenType(TLB, T.castAs(ParenTypeLoc.class));
     case Typedef:
      return getDerived().TransformTypedefType(TLB, T.castAs(TypedefTypeLoc.class));
     case Adjusted:
      return getDerived().TransformAdjustedType(TLB, T.castAs(AdjustedTypeLoc.class));
     case Decayed:
      return getDerived().TransformDecayedType(TLB, T.castAs(DecayedTypeLoc.class));
     case TypeOfExpr:
      return getDerived().TransformTypeOfExprType(TLB, T.castAs(TypeOfExprTypeLoc.class));
     case TypeOf:
      return getDerived().TransformTypeOfType(TLB, T.castAs(TypeOfTypeLoc.class));
     case Decltype:
      return getDerived().TransformDecltypeType(TLB, T.castAs(DecltypeTypeLoc.class));
     case UnaryTransform:
      return getDerived().TransformUnaryTransformType(TLB, T.castAs(UnaryTransformTypeLoc.class));
     case Record:
      return getDerived().TransformRecordType(TLB, T.castAs(RecordTypeLoc.class));
     case Enum:
      return getDerived().TransformEnumType(TLB, T.castAs(EnumTypeLoc.class));
     case Elaborated:
      return getDerived().TransformElaboratedType(TLB, T.castAs(ElaboratedTypeLoc.class));
     case Attributed:
      return getDerived().TransformAttributedType(TLB, T.castAs(AttributedTypeLoc.class));
     case TemplateTypeParm:
      return getDerived().TransformTemplateTypeParmType(TLB, T.castAs(TemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParm:
      return getDerived().TransformSubstTemplateTypeParmType(TLB, T.castAs(SubstTemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParmPack:
      return getDerived().TransformSubstTemplateTypeParmPackType(TLB, T.castAs(SubstTemplateTypeParmPackTypeLoc.class));
     case TemplateSpecialization:
      return getDerived().TransformTemplateSpecializationType(TLB, T.castAs(TemplateSpecializationTypeLoc.class));
     case Auto:
      return getDerived().TransformAutoType(TLB, T.castAs(AutoTypeLoc.class));
     case InjectedClassName:
      return getDerived().TransformInjectedClassNameType(TLB, T.castAs(InjectedClassNameTypeLoc.class));
     case DependentName:
      return getDerived().TransformDependentNameType(TLB, T.castAs(DependentNameTypeLoc.class));
     case DependentTemplateSpecialization:
      return getDerived().TransformDependentTemplateSpecializationType(TLB, T.castAs(DependentTemplateSpecializationTypeLoc.class));
     case PackExpansion:
      return getDerived().TransformPackExpansionType(TLB, T.castAs(PackExpansionTypeLoc.class));
     case ObjCObject:
      return getDerived().TransformObjCObjectType(TLB, T.castAs(ObjCObjectTypeLoc.class));
     case ObjCInterface:
      return getDerived().TransformObjCInterfaceType(TLB, T.castAs(ObjCInterfaceTypeLoc.class));
     case ObjCObjectPointer:
      return getDerived().TransformObjCObjectPointerType(TLB, T.castAs(ObjCObjectPointerTypeLoc.class));
     case Pipe:
      return getDerived().TransformPipeType(TLB, T.castAs(PipeTypeLoc.class));
     case Atomic:
      return getDerived().TransformAtomicType(TLB, T.castAs(AtomicTypeLoc.class));
    }
    throw new llvm_unreachable("unhandled type loc!");
  }

  
  /// \brief Transform the given statement.
  ///
  /// By default, this routine transforms a statement by delegating to the
  /// appropriate TransformXXXStmt function to transform a specific kind of
  /// statement or the TransformExpr() function to transform an expression.
  /// Subclasses may override this function to transform statements using some
  /// other mechanism.
  ///
  /// \returns the transformed statement.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3142,
   FQN="clang::TreeTransform::TransformStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformStmtEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformStmt(Stmt /*P*/ S) {
    if (!(S != null)) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    switch (S.getStmtClass()) {
     case NoStmtClass:
      break;
     case GCCAsmStmtClass:
      return getDerived().TransformGCCAsmStmt(cast_GCCAsmStmt(S));
     case MSAsmStmtClass:
      return getDerived().TransformMSAsmStmt(cast_MSAsmStmt(S));
     case AttributedStmtClass:
      return getDerived().TransformAttributedStmt(cast_AttributedStmt(S));
     case BreakStmtClass:
      return getDerived().TransformBreakStmt(cast_BreakStmt(S));
     case CXXCatchStmtClass:
      return getDerived().TransformCXXCatchStmt(cast_CXXCatchStmt(S));
     case CXXForRangeStmtClass:
      return getDerived().TransformCXXForRangeStmt(cast_CXXForRangeStmt(S));
     case CXXTryStmtClass:
      return getDerived().TransformCXXTryStmt(cast_CXXTryStmt(S));
     case CapturedStmtClass:
      return getDerived().TransformCapturedStmt(cast_CapturedStmt(S));
     case CompoundStmtClass:
      return getDerived().TransformCompoundStmt(cast_CompoundStmt(S));
     case ContinueStmtClass:
      return getDerived().TransformContinueStmt(cast_ContinueStmt(S));
     case CoreturnStmtClass:
      return getDerived().TransformCoreturnStmt(cast_CoreturnStmt(S));
     case CoroutineBodyStmtClass:
      return getDerived().TransformCoroutineBodyStmt(cast_CoroutineBodyStmt(S));
     case DeclStmtClass:
      return getDerived().TransformDeclStmt(cast_DeclStmt(S));
     case DoStmtClass:
      return getDerived().TransformDoStmt(cast_DoStmt(S));
     case ForStmtClass:
      return getDerived().TransformForStmt(cast_ForStmt(S));
     case GotoStmtClass:
      return getDerived().TransformGotoStmt(cast_GotoStmt(S));
     case IfStmtClass:
      return getDerived().TransformIfStmt(cast_IfStmt(S));
     case IndirectGotoStmtClass:
      return getDerived().TransformIndirectGotoStmt(cast_IndirectGotoStmt(S));
     case LabelStmtClass:
      return getDerived().TransformLabelStmt(cast_LabelStmt(S));
     case MSDependentExistsStmtClass:
      return getDerived().TransformMSDependentExistsStmt(cast_MSDependentExistsStmt(S));
     case NullStmtClass:
      return getDerived().TransformNullStmt(cast_NullStmt(S));
     case OMPAtomicDirectiveClass:
      return getDerived().TransformOMPAtomicDirective(cast_OMPAtomicDirective(S));
     case OMPBarrierDirectiveClass:
      return getDerived().TransformOMPBarrierDirective(cast_OMPBarrierDirective(S));
     case OMPCancelDirectiveClass:
      return getDerived().TransformOMPCancelDirective(cast_OMPCancelDirective(S));
     case OMPCancellationPointDirectiveClass:
      return getDerived().TransformOMPCancellationPointDirective(cast_OMPCancellationPointDirective(S));
     case OMPCriticalDirectiveClass:
      return getDerived().TransformOMPCriticalDirective(cast_OMPCriticalDirective(S));
     case OMPFlushDirectiveClass:
      return getDerived().TransformOMPFlushDirective(cast_OMPFlushDirective(S));
     case OMPDistributeDirectiveClass:
      return getDerived().TransformOMPDistributeDirective(cast_OMPDistributeDirective(S));
     case OMPDistributeParallelForDirectiveClass:
      return getDerived().TransformOMPDistributeParallelForDirective(cast_OMPDistributeParallelForDirective(S));
     case OMPDistributeParallelForSimdDirectiveClass:
      return getDerived().TransformOMPDistributeParallelForSimdDirective(cast_OMPDistributeParallelForSimdDirective(S));
     case OMPDistributeSimdDirectiveClass:
      return getDerived().TransformOMPDistributeSimdDirective(cast_OMPDistributeSimdDirective(S));
     case OMPForDirectiveClass:
      return getDerived().TransformOMPForDirective(cast_OMPForDirective(S));
     case OMPForSimdDirectiveClass:
      return getDerived().TransformOMPForSimdDirective(cast_OMPForSimdDirective(S));
     case OMPParallelForDirectiveClass:
      return getDerived().TransformOMPParallelForDirective(cast_OMPParallelForDirective(S));
     case OMPParallelForSimdDirectiveClass:
      return getDerived().TransformOMPParallelForSimdDirective(cast_OMPParallelForSimdDirective(S));
     case OMPSimdDirectiveClass:
      return getDerived().TransformOMPSimdDirective(cast_OMPSimdDirective(S));
     case OMPTargetParallelForSimdDirectiveClass:
      return getDerived().TransformOMPTargetParallelForSimdDirective(cast_OMPTargetParallelForSimdDirective(S));
     case OMPTaskLoopDirectiveClass:
      return getDerived().TransformOMPTaskLoopDirective(cast_OMPTaskLoopDirective(S));
     case OMPTaskLoopSimdDirectiveClass:
      return getDerived().TransformOMPTaskLoopSimdDirective(cast_OMPTaskLoopSimdDirective(S));
     case OMPMasterDirectiveClass:
      return getDerived().TransformOMPMasterDirective(cast_OMPMasterDirective(S));
     case OMPOrderedDirectiveClass:
      return getDerived().TransformOMPOrderedDirective(cast_OMPOrderedDirective(S));
     case OMPParallelDirectiveClass:
      return getDerived().TransformOMPParallelDirective(cast_OMPParallelDirective(S));
     case OMPParallelSectionsDirectiveClass:
      return getDerived().TransformOMPParallelSectionsDirective(cast_OMPParallelSectionsDirective(S));
     case OMPSectionDirectiveClass:
      return getDerived().TransformOMPSectionDirective(cast_OMPSectionDirective(S));
     case OMPSectionsDirectiveClass:
      return getDerived().TransformOMPSectionsDirective(cast_OMPSectionsDirective(S));
     case OMPSingleDirectiveClass:
      return getDerived().TransformOMPSingleDirective(cast_OMPSingleDirective(S));
     case OMPTargetDataDirectiveClass:
      return getDerived().TransformOMPTargetDataDirective(cast_OMPTargetDataDirective(S));
     case OMPTargetDirectiveClass:
      return getDerived().TransformOMPTargetDirective(cast_OMPTargetDirective(S));
     case OMPTargetEnterDataDirectiveClass:
      return getDerived().TransformOMPTargetEnterDataDirective(cast_OMPTargetEnterDataDirective(S));
     case OMPTargetExitDataDirectiveClass:
      return getDerived().TransformOMPTargetExitDataDirective(cast_OMPTargetExitDataDirective(S));
     case OMPTargetParallelDirectiveClass:
      return getDerived().TransformOMPTargetParallelDirective(cast_OMPTargetParallelDirective(S));
     case OMPTargetParallelForDirectiveClass:
      return getDerived().TransformOMPTargetParallelForDirective(cast_OMPTargetParallelForDirective(S));
     case OMPTargetUpdateDirectiveClass:
      return getDerived().TransformOMPTargetUpdateDirective(cast_OMPTargetUpdateDirective(S));
     case OMPTaskDirectiveClass:
      return getDerived().TransformOMPTaskDirective(cast_OMPTaskDirective(S));
     case OMPTaskgroupDirectiveClass:
      return getDerived().TransformOMPTaskgroupDirective(cast_OMPTaskgroupDirective(S));
     case OMPTaskwaitDirectiveClass:
      return getDerived().TransformOMPTaskwaitDirective(cast_OMPTaskwaitDirective(S));
     case OMPTaskyieldDirectiveClass:
      return getDerived().TransformOMPTaskyieldDirective(cast_OMPTaskyieldDirective(S));
     case OMPTeamsDirectiveClass:
      return getDerived().TransformOMPTeamsDirective(cast_OMPTeamsDirective(S));
     case ObjCAtCatchStmtClass:
      return getDerived().TransformObjCAtCatchStmt(cast_ObjCAtCatchStmt(S));
     case ObjCAtFinallyStmtClass:
      return getDerived().TransformObjCAtFinallyStmt(cast_ObjCAtFinallyStmt(S));
     case ObjCAtSynchronizedStmtClass:
      return getDerived().TransformObjCAtSynchronizedStmt(cast_ObjCAtSynchronizedStmt(S));
     case ObjCAtThrowStmtClass:
      return getDerived().TransformObjCAtThrowStmt(cast_ObjCAtThrowStmt(S));
     case ObjCAtTryStmtClass:
      return getDerived().TransformObjCAtTryStmt(cast_ObjCAtTryStmt(S));
     case ObjCAutoreleasePoolStmtClass:
      return getDerived().TransformObjCAutoreleasePoolStmt(cast_ObjCAutoreleasePoolStmt(S));
     case ObjCForCollectionStmtClass:
      return getDerived().TransformObjCForCollectionStmt(cast_ObjCForCollectionStmt(S));
     case ReturnStmtClass:
      return getDerived().TransformReturnStmt(cast_ReturnStmt(S));
     case SEHExceptStmtClass:
      return getDerived().TransformSEHExceptStmt(cast_SEHExceptStmt(S));
     case SEHFinallyStmtClass:
      return getDerived().TransformSEHFinallyStmt(cast_SEHFinallyStmt(S));
     case SEHLeaveStmtClass:
      return getDerived().TransformSEHLeaveStmt(cast_SEHLeaveStmt(S));
     case SEHTryStmtClass:
      return getDerived().TransformSEHTryStmt(cast_SEHTryStmt(S));
     case CaseStmtClass:
      return getDerived().TransformCaseStmt(cast_CaseStmt(S));
     case DefaultStmtClass:
      return getDerived().TransformDefaultStmt(cast_DefaultStmt(S));
     case SwitchStmtClass:
      return getDerived().TransformSwitchStmt(cast_SwitchStmt(S));
     case WhileStmtClass:
      return getDerived().TransformWhileStmt(cast_WhileStmt(S));
     case BinaryConditionalOperatorClass:
     case ConditionalOperatorClass:
     case AddrLabelExprClass:
     case ArraySubscriptExprClass:
     case ArrayTypeTraitExprClass:
     case AsTypeExprClass:
     case AtomicExprClass:
     case BinaryOperatorClass:
     case CompoundAssignOperatorClass:
     case BlockExprClass:
     case CXXBindTemporaryExprClass:
     case CXXBoolLiteralExprClass:
     case CXXConstructExprClass:
     case CXXTemporaryObjectExprClass:
     case CXXDefaultArgExprClass:
     case CXXDefaultInitExprClass:
     case CXXDeleteExprClass:
     case CXXDependentScopeMemberExprClass:
     case CXXFoldExprClass:
     case CXXInheritedCtorInitExprClass:
     case CXXNewExprClass:
     case CXXNoexceptExprClass:
     case CXXNullPtrLiteralExprClass:
     case CXXPseudoDestructorExprClass:
     case CXXScalarValueInitExprClass:
     case CXXStdInitializerListExprClass:
     case CXXThisExprClass:
     case CXXThrowExprClass:
     case CXXTypeidExprClass:
     case CXXUnresolvedConstructExprClass:
     case CXXUuidofExprClass:
     case CallExprClass:
     case CUDAKernelCallExprClass:
     case CXXMemberCallExprClass:
     case CXXOperatorCallExprClass:
     case UserDefinedLiteralClass:
     case CStyleCastExprClass:
     case CXXFunctionalCastExprClass:
     case CXXConstCastExprClass:
     case CXXDynamicCastExprClass:
     case CXXReinterpretCastExprClass:
     case CXXStaticCastExprClass:
     case ObjCBridgedCastExprClass:
     case ImplicitCastExprClass:
     case CharacterLiteralClass:
     case ChooseExprClass:
     case CompoundLiteralExprClass:
     case ConvertVectorExprClass:
     case CoawaitExprClass:
     case CoyieldExprClass:
     case DeclRefExprClass:
     case DependentScopeDeclRefExprClass:
     case DesignatedInitExprClass:
     case DesignatedInitUpdateExprClass:
     case ExprWithCleanupsClass:
     case ExpressionTraitExprClass:
     case ExtVectorElementExprClass:
     case FloatingLiteralClass:
     case FunctionParmPackExprClass:
     case GNUNullExprClass:
     case GenericSelectionExprClass:
     case ImaginaryLiteralClass:
     case ImplicitValueInitExprClass:
     case InitListExprClass:
     case IntegerLiteralClass:
     case LambdaExprClass:
     case MSPropertyRefExprClass:
     case MSPropertySubscriptExprClass:
     case MaterializeTemporaryExprClass:
     case MemberExprClass:
     case NoInitExprClass:
     case OMPArraySectionExprClass:
     case ObjCArrayLiteralClass:
     case ObjCAvailabilityCheckExprClass:
     case ObjCBoolLiteralExprClass:
     case ObjCBoxedExprClass:
     case ObjCDictionaryLiteralClass:
     case ObjCEncodeExprClass:
     case ObjCIndirectCopyRestoreExprClass:
     case ObjCIsaExprClass:
     case ObjCIvarRefExprClass:
     case ObjCMessageExprClass:
     case ObjCPropertyRefExprClass:
     case ObjCProtocolExprClass:
     case ObjCSelectorExprClass:
     case ObjCStringLiteralClass:
     case ObjCSubscriptRefExprClass:
     case OffsetOfExprClass:
     case OpaqueValueExprClass:
     case UnresolvedLookupExprClass:
     case UnresolvedMemberExprClass:
     case PackExpansionExprClass:
     case ParenExprClass:
     case ParenListExprClass:
     case PredefinedExprClass:
     case PseudoObjectExprClass:
     case ShuffleVectorExprClass:
     case SizeOfPackExprClass:
     case StmtExprClass:
     case StringLiteralClass:
     case SubstNonTypeTemplateParmExprClass:
     case SubstNonTypeTemplateParmPackExprClass:
     case TypeTraitExprClass:
     case TypoExprClass:
     case UnaryExprOrTypeTraitExprClass:
     case UnaryOperatorClass:
     case VAArgExprClass:
      {
        ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(cast_Expr(S));
        if (E.isInvalid()) {
          return StmtError();
        }
        
        return getSema().ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(E));
      }
    }
    
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  
  /// \brief Transform the given statement.
  ///
  /// By default, this routine transforms a statement by delegating to the
  /// appropriate TransformOMPXXXClause function to transform a specific kind
  /// of clause. Subclasses may override this function to transform statements
  /// using some other mechanism.
  ///
  /// \returns the transformed OpenMP clause.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3174,
   FQN="clang::TreeTransform::TransformOMPClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformOMPClauseEPNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformOMPClauseEPNS_9OMPClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPClause(OMPClause /*P*/ S) {
    if (!(S != null)) {
      return S;
    }
    switch (S.getClauseKind()) {
     default:
      break;
     case OMPC_if:
      
      // OpenMP clauses.
      return getDerived().TransformOMPIfClause(cast_OMPIfClause(S));
     case OMPC_final:
      return getDerived().TransformOMPFinalClause(cast_OMPFinalClause(S));
     case OMPC_num_threads:
      return getDerived().TransformOMPNumThreadsClause(cast_OMPNumThreadsClause(S));
     case OMPC_safelen:
      return getDerived().TransformOMPSafelenClause(cast_OMPSafelenClause(S));
     case OMPC_simdlen:
      return getDerived().TransformOMPSimdlenClause(cast_OMPSimdlenClause(S));
     case OMPC_collapse:
      return getDerived().TransformOMPCollapseClause(cast_OMPCollapseClause(S));
     case OMPC_default:
      return getDerived().TransformOMPDefaultClause(cast_OMPDefaultClause(S));
     case OMPC_private:
      return getDerived().TransformOMPPrivateClause(cast_OMPPrivateClause(S));
     case OMPC_firstprivate:
      return getDerived().TransformOMPFirstprivateClause(cast_OMPFirstprivateClause(S));
     case OMPC_lastprivate:
      return getDerived().TransformOMPLastprivateClause(cast_OMPLastprivateClause(S));
     case OMPC_shared:
      return getDerived().TransformOMPSharedClause(cast_OMPSharedClause(S));
     case OMPC_reduction:
      return getDerived().TransformOMPReductionClause(cast_OMPReductionClause(S));
     case OMPC_linear:
      return getDerived().TransformOMPLinearClause(cast_OMPLinearClause(S));
     case OMPC_aligned:
      return getDerived().TransformOMPAlignedClause(cast_OMPAlignedClause(S));
     case OMPC_copyin:
      return getDerived().TransformOMPCopyinClause(cast_OMPCopyinClause(S));
     case OMPC_copyprivate:
      return getDerived().TransformOMPCopyprivateClause(cast_OMPCopyprivateClause(S));
     case OMPC_proc_bind:
      return getDerived().TransformOMPProcBindClause(cast_OMPProcBindClause(S));
     case OMPC_schedule:
      return getDerived().TransformOMPScheduleClause(cast_OMPScheduleClause(S));
     case OMPC_ordered:
      return getDerived().TransformOMPOrderedClause(cast_OMPOrderedClause(S));
     case OMPC_nowait:
      return getDerived().TransformOMPNowaitClause(cast_OMPNowaitClause(S));
     case OMPC_untied:
      return getDerived().TransformOMPUntiedClause(cast_OMPUntiedClause(S));
     case OMPC_mergeable:
      return getDerived().TransformOMPMergeableClause(cast_OMPMergeableClause(S));
     case OMPC_flush:
      return getDerived().TransformOMPFlushClause(cast_OMPFlushClause(S));
     case OMPC_read:
      return getDerived().TransformOMPReadClause(cast_OMPReadClause(S));
     case OMPC_write:
      return getDerived().TransformOMPWriteClause(cast_OMPWriteClause(S));
     case OMPC_update:
      return getDerived().TransformOMPUpdateClause(cast_OMPUpdateClause(S));
     case OMPC_capture:
      return getDerived().TransformOMPCaptureClause(cast_OMPCaptureClause(S));
     case OMPC_seq_cst:
      return getDerived().TransformOMPSeqCstClause(cast_OMPSeqCstClause(S));
     case OMPC_depend:
      return getDerived().TransformOMPDependClause(cast_OMPDependClause(S));
     case OMPC_device:
      return getDerived().TransformOMPDeviceClause(cast_OMPDeviceClause(S));
     case OMPC_threads:
      return getDerived().TransformOMPThreadsClause(cast_OMPThreadsClause(S));
     case OMPC_simd:
      return getDerived().TransformOMPSIMDClause(cast_OMPSIMDClause(S));
     case OMPC_map:
      return getDerived().TransformOMPMapClause(cast_OMPMapClause(S));
     case OMPC_num_teams:
      return getDerived().TransformOMPNumTeamsClause(cast_OMPNumTeamsClause(S));
     case OMPC_thread_limit:
      return getDerived().TransformOMPThreadLimitClause(cast_OMPThreadLimitClause(S));
     case OMPC_priority:
      return getDerived().TransformOMPPriorityClause(cast_OMPPriorityClause(S));
     case OMPC_grainsize:
      return getDerived().TransformOMPGrainsizeClause(cast_OMPGrainsizeClause(S));
     case OMPC_nogroup:
      return getDerived().TransformOMPNogroupClause(cast_OMPNogroupClause(S));
     case OMPC_num_tasks:
      return getDerived().TransformOMPNumTasksClause(cast_OMPNumTasksClause(S));
     case OMPC_hint:
      return getDerived().TransformOMPHintClause(cast_OMPHintClause(S));
     case OMPC_dist_schedule:
      return getDerived().TransformOMPDistScheduleClause(cast_OMPDistScheduleClause(S));
     case OMPC_defaultmap:
      return getDerived().TransformOMPDefaultmapClause(cast_OMPDefaultmapClause(S));
     case OMPC_to:
      return getDerived().TransformOMPToClause(cast_OMPToClause(S));
     case OMPC_from:
      return getDerived().TransformOMPFromClause(cast_OMPFromClause(S));
     case OMPC_use_device_ptr:
      return getDerived().TransformOMPUseDevicePtrClause(cast_OMPUseDevicePtrClause(S));
     case OMPC_is_device_ptr:
      return getDerived().TransformOMPIsDevicePtrClause(cast_OMPIsDevicePtrClause(S));
    }
    
    return S;
  }

  
  /// \brief Transform the given attribute.
  ///
  /// By default, this routine transforms a statement by delegating to the
  /// appropriate TransformXXXAttr function to transform a specific kind
  /// of attribute. Subclasses may override this function to transform
  /// attributed statements using some other mechanism.
  ///
  /// \returns the transformed attribute
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6227,
   FQN="clang::TreeTransform::TransformAttr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformAttrEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformAttrEPKNS_4AttrE")
  //</editor-fold>
  public /*const*/ Attr /*P*/ TransformAttr(/*const*/ Attr /*P*/ R) {
    if (!(R != null)) {
      return R;
    }
    switch (R.getKind()) {
     case InitSeg:
      return getDerived().TransformInitSegAttr(cast_InitSegAttr(R));
     case LoopHint:
      return getDerived().TransformLoopHintAttr(cast_LoopHintAttr(R));
     case OMPDeclareSimdDecl:
      return getDerived().TransformOMPDeclareSimdDeclAttr(cast_OMPDeclareSimdDeclAttr(R));
     case OMPDeclareTargetDecl:
      return getDerived().TransformOMPDeclareTargetDeclAttr(cast_OMPDeclareTargetDeclAttr(R));
     default:
      return R;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformInitSegAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/AttrList.inc", line = 227,
   FQN="clang::TreeTransform::TransformInitSegAttr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformInitSegAttrEPKNS_11InitSegAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformInitSegAttrEPKNS_11InitSegAttrE")
  //</editor-fold>
  public /*const*/ InitSegAttr /*P*/ TransformInitSegAttr(/*const*/ InitSegAttr /*P*/ R) {
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformLoopHintAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/AttrList.inc", line = 228,
   FQN="clang::TreeTransform::TransformLoopHintAttr", NM="_ZN5clang13TreeTransform21TransformLoopHintAttrEPKNS_12LoopHintAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform21TransformLoopHintAttrEPKNS_12LoopHintAttrE")
  //</editor-fold>
  public /*const*/ LoopHintAttr /*P*/ TransformLoopHintAttr(/*const*/ LoopHintAttr /*P*/ R) {
    return R;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDeclareSimdDeclAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/AttrList.inc", line = 229,
   FQN="clang::TreeTransform::TransformOMPDeclareSimdDeclAttr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPDeclareSimdDeclAttrEPKNS_22OMPDeclareSimdDeclAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPDeclareSimdDeclAttrEPKNS_22OMPDeclareSimdDeclAttrE")
  //</editor-fold>
  public /*const*/ OMPDeclareSimdDeclAttr /*P*/ TransformOMPDeclareSimdDeclAttr(/*const*/ OMPDeclareSimdDeclAttr /*P*/ R) {
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDeclareTargetDeclAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/AttrList.inc", line = 230,
   FQN="clang::TreeTransform::TransformOMPDeclareTargetDeclAttr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPDeclareTargetDeclAttrEPKNS_24OMPDeclareTargetDeclAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPDeclareTargetDeclAttrEPKNS_24OMPDeclareTargetDeclAttrE")
  //</editor-fold>
  public /*const*/ OMPDeclareTargetDeclAttr /*P*/ TransformOMPDeclareTargetDeclAttr(/*const*/ OMPDeclareTargetDeclAttr /*P*/ R) {
    return R;
  }

  
  /// \brief Transform the given expression.
  ///
  /// By default, this routine transforms an expression by delegating to the
  /// appropriate TransformXXXExpr function to build a new expression.
  /// Subclasses may override this function to transform expressions using some
  /// other mechanism.
  ///
  /// \returns the transformed expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3192,
   FQN="clang::TreeTransform::TransformExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13TransformExprEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformExpr(Expr /*P*/ E) {
    if (!(E != null)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    switch (E.getStmtClass()) {
     case NoStmtClass:
      break;
     case GCCAsmStmtClass:
      break;
     case MSAsmStmtClass:
      break;
     case AttributedStmtClass:
      break;
     case BreakStmtClass:
      break;
     case CXXCatchStmtClass:
      break;
     case CXXForRangeStmtClass:
      break;
     case CXXTryStmtClass:
      break;
     case CapturedStmtClass:
      break;
     case CompoundStmtClass:
      break;
     case ContinueStmtClass:
      break;
     case CoreturnStmtClass:
      break;
     case CoroutineBodyStmtClass:
      break;
     case DeclStmtClass:
      break;
     case DoStmtClass:
      break;
     case BinaryConditionalOperatorClass:
      return getDerived().TransformBinaryConditionalOperator(cast_BinaryConditionalOperator(E));
     case ConditionalOperatorClass:
      return getDerived().TransformConditionalOperator(cast_ConditionalOperator(E));
     case AddrLabelExprClass:
      return getDerived().TransformAddrLabelExpr(cast_AddrLabelExpr(E));
     case ArraySubscriptExprClass:
      return getDerived().TransformArraySubscriptExpr(cast_ArraySubscriptExpr(E));
     case ArrayTypeTraitExprClass:
      return getDerived().TransformArrayTypeTraitExpr(cast_ArrayTypeTraitExpr(E));
     case AsTypeExprClass:
      return getDerived().TransformAsTypeExpr(cast_AsTypeExpr(E));
     case AtomicExprClass:
      return getDerived().TransformAtomicExpr(cast_AtomicExpr(E));
     case BinaryOperatorClass:
      return getDerived().TransformBinaryOperator(cast_BinaryOperator(E));
     case CompoundAssignOperatorClass:
      return getDerived().TransformCompoundAssignOperator(cast_CompoundAssignOperator(E));
     case BlockExprClass:
      return getDerived().TransformBlockExpr(cast_BlockExpr(E));
     case CXXBindTemporaryExprClass:
      return getDerived().TransformCXXBindTemporaryExpr(cast_CXXBindTemporaryExpr(E));
     case CXXBoolLiteralExprClass:
      return getDerived().TransformCXXBoolLiteralExpr(cast_CXXBoolLiteralExpr(E));
     case CXXConstructExprClass:
      return getDerived().TransformCXXConstructExpr(cast_CXXConstructExpr(E));
     case CXXTemporaryObjectExprClass:
      return getDerived().TransformCXXTemporaryObjectExpr(cast_CXXTemporaryObjectExpr(E));
     case CXXDefaultArgExprClass:
      return getDerived().TransformCXXDefaultArgExpr(cast_CXXDefaultArgExpr(E));
     case CXXDefaultInitExprClass:
      return getDerived().TransformCXXDefaultInitExpr(cast_CXXDefaultInitExpr(E));
     case CXXDeleteExprClass:
      return getDerived().TransformCXXDeleteExpr(cast_CXXDeleteExpr(E));
     case CXXDependentScopeMemberExprClass:
      return getDerived().TransformCXXDependentScopeMemberExpr(cast_CXXDependentScopeMemberExpr(E));
     case CXXFoldExprClass:
      return getDerived().TransformCXXFoldExpr(cast_CXXFoldExpr(E));
     case CXXInheritedCtorInitExprClass:
      return getDerived().TransformCXXInheritedCtorInitExpr(cast_CXXInheritedCtorInitExpr(E));
     case CXXNewExprClass:
      return getDerived().TransformCXXNewExpr(cast_CXXNewExpr(E));
     case CXXNoexceptExprClass:
      return getDerived().TransformCXXNoexceptExpr(cast_CXXNoexceptExpr(E));
     case CXXNullPtrLiteralExprClass:
      return getDerived().TransformCXXNullPtrLiteralExpr(cast_CXXNullPtrLiteralExpr(E));
     case CXXPseudoDestructorExprClass:
      return getDerived().TransformCXXPseudoDestructorExpr(cast_CXXPseudoDestructorExpr(E));
     case CXXScalarValueInitExprClass:
      return getDerived().TransformCXXScalarValueInitExpr(cast_CXXScalarValueInitExpr(E));
     case CXXStdInitializerListExprClass:
      return getDerived().TransformCXXStdInitializerListExpr(cast_CXXStdInitializerListExpr(E));
     case CXXThisExprClass:
      return getDerived().TransformCXXThisExpr(cast_CXXThisExpr(E));
     case CXXThrowExprClass:
      return getDerived().TransformCXXThrowExpr(cast_CXXThrowExpr(E));
     case CXXTypeidExprClass:
      return getDerived().TransformCXXTypeidExpr(cast_CXXTypeidExpr(E));
     case CXXUnresolvedConstructExprClass:
      return getDerived().TransformCXXUnresolvedConstructExpr(cast_CXXUnresolvedConstructExpr(E));
     case CXXUuidofExprClass:
      return getDerived().TransformCXXUuidofExpr(cast_CXXUuidofExpr(E));
     case CallExprClass:
      return getDerived().TransformCallExpr(cast_CallExpr(E));
     case CUDAKernelCallExprClass:
      return getDerived().TransformCUDAKernelCallExpr(cast_CUDAKernelCallExpr(E));
     case CXXMemberCallExprClass:
      return getDerived().TransformCXXMemberCallExpr(cast_CXXMemberCallExpr(E));
     case CXXOperatorCallExprClass:
      return getDerived().TransformCXXOperatorCallExpr(cast_CXXOperatorCallExpr(E));
     case UserDefinedLiteralClass:
      return getDerived().TransformUserDefinedLiteral(cast_UserDefinedLiteral(E));
     case CStyleCastExprClass:
      return getDerived().TransformCStyleCastExpr(cast_CStyleCastExpr(E));
     case CXXFunctionalCastExprClass:
      return getDerived().TransformCXXFunctionalCastExpr(cast_CXXFunctionalCastExpr(E));
     case CXXConstCastExprClass:
      return getDerived().TransformCXXConstCastExpr(cast_CXXConstCastExpr(E));
     case CXXDynamicCastExprClass:
      return getDerived().TransformCXXDynamicCastExpr(cast_CXXDynamicCastExpr(E));
     case CXXReinterpretCastExprClass:
      return getDerived().TransformCXXReinterpretCastExpr(cast_CXXReinterpretCastExpr(E));
     case CXXStaticCastExprClass:
      return getDerived().TransformCXXStaticCastExpr(cast_CXXStaticCastExpr(E));
     case ObjCBridgedCastExprClass:
      return getDerived().TransformObjCBridgedCastExpr(cast_ObjCBridgedCastExpr(E));
     case ImplicitCastExprClass:
      return getDerived().TransformImplicitCastExpr(cast_ImplicitCastExpr(E));
     case CharacterLiteralClass:
      return getDerived().TransformCharacterLiteral(cast_CharacterLiteral(E));
     case ChooseExprClass:
      return getDerived().TransformChooseExpr(cast_ChooseExpr(E));
     case CompoundLiteralExprClass:
      return getDerived().TransformCompoundLiteralExpr(cast_CompoundLiteralExpr(E));
     case ConvertVectorExprClass:
      return getDerived().TransformConvertVectorExpr(cast_ConvertVectorExpr(E));
     case CoawaitExprClass:
      return getDerived().TransformCoawaitExpr(cast_CoawaitExpr(E));
     case CoyieldExprClass:
      return getDerived().TransformCoyieldExpr(cast_CoyieldExpr(E));
     case DeclRefExprClass:
      return getDerived().TransformDeclRefExpr(cast_DeclRefExpr(E));
     case DependentScopeDeclRefExprClass:
      return getDerived().TransformDependentScopeDeclRefExpr(cast_DependentScopeDeclRefExpr(E));
     case DesignatedInitExprClass:
      return getDerived().TransformDesignatedInitExpr(cast_DesignatedInitExpr(E));
     case DesignatedInitUpdateExprClass:
      return getDerived().TransformDesignatedInitUpdateExpr(cast_DesignatedInitUpdateExpr(E));
     case ExprWithCleanupsClass:
      return getDerived().TransformExprWithCleanups(cast_ExprWithCleanups(E));
     case ExpressionTraitExprClass:
      return getDerived().TransformExpressionTraitExpr(cast_ExpressionTraitExpr(E));
     case ExtVectorElementExprClass:
      return getDerived().TransformExtVectorElementExpr(cast_ExtVectorElementExpr(E));
     case FloatingLiteralClass:
      return getDerived().TransformFloatingLiteral(cast_FloatingLiteral(E));
     case FunctionParmPackExprClass:
      return getDerived().TransformFunctionParmPackExpr(cast_FunctionParmPackExpr(E));
     case GNUNullExprClass:
      return getDerived().TransformGNUNullExpr(cast_GNUNullExpr(E));
     case GenericSelectionExprClass:
      return getDerived().TransformGenericSelectionExpr(cast_GenericSelectionExpr(E));
     case ImaginaryLiteralClass:
      return getDerived().TransformImaginaryLiteral(cast_ImaginaryLiteral(E));
     case ImplicitValueInitExprClass:
      return getDerived().TransformImplicitValueInitExpr(cast_ImplicitValueInitExpr(E));
     case InitListExprClass:
      return getDerived().TransformInitListExpr(cast_InitListExpr(E));
     case IntegerLiteralClass:
      return getDerived().TransformIntegerLiteral(cast_IntegerLiteral(E));
     case LambdaExprClass:
      return getDerived().TransformLambdaExpr(cast_LambdaExpr(E));
     case MSPropertyRefExprClass:
      return getDerived().TransformMSPropertyRefExpr(cast_MSPropertyRefExpr(E));
     case MSPropertySubscriptExprClass:
      return getDerived().TransformMSPropertySubscriptExpr(cast_MSPropertySubscriptExpr(E));
     case MaterializeTemporaryExprClass:
      return getDerived().TransformMaterializeTemporaryExpr(cast_MaterializeTemporaryExpr(E));
     case MemberExprClass:
      return getDerived().TransformMemberExpr(cast_MemberExpr(E));
     case NoInitExprClass:
      return getDerived().TransformNoInitExpr(cast_NoInitExpr(E));
     case OMPArraySectionExprClass:
      return getDerived().TransformOMPArraySectionExpr(cast_OMPArraySectionExpr(E));
     case ObjCArrayLiteralClass:
      return getDerived().TransformObjCArrayLiteral(cast_ObjCArrayLiteral(E));
     case ObjCAvailabilityCheckExprClass:
      return getDerived().TransformObjCAvailabilityCheckExpr(cast_ObjCAvailabilityCheckExpr(E));
     case ObjCBoolLiteralExprClass:
      return getDerived().TransformObjCBoolLiteralExpr(cast_ObjCBoolLiteralExpr(E));
     case ObjCBoxedExprClass:
      return getDerived().TransformObjCBoxedExpr(cast_ObjCBoxedExpr(E));
     case ObjCDictionaryLiteralClass:
      return getDerived().TransformObjCDictionaryLiteral(cast_ObjCDictionaryLiteral(E));
     case ObjCEncodeExprClass:
      return getDerived().TransformObjCEncodeExpr(cast_ObjCEncodeExpr(E));
     case ObjCIndirectCopyRestoreExprClass:
      return getDerived().TransformObjCIndirectCopyRestoreExpr(cast_ObjCIndirectCopyRestoreExpr(E));
     case ObjCIsaExprClass:
      return getDerived().TransformObjCIsaExpr(cast_ObjCIsaExpr(E));
     case ObjCIvarRefExprClass:
      return getDerived().TransformObjCIvarRefExpr(cast_ObjCIvarRefExpr(E));
     case ObjCMessageExprClass:
      return getDerived().TransformObjCMessageExpr(cast_ObjCMessageExpr(E));
     case ObjCPropertyRefExprClass:
      return getDerived().TransformObjCPropertyRefExpr(cast_ObjCPropertyRefExpr(E));
     case ObjCProtocolExprClass:
      return getDerived().TransformObjCProtocolExpr(cast_ObjCProtocolExpr(E));
     case ObjCSelectorExprClass:
      return getDerived().TransformObjCSelectorExpr(cast_ObjCSelectorExpr(E));
     case ObjCStringLiteralClass:
      return getDerived().TransformObjCStringLiteral(cast_ObjCStringLiteral(E));
     case ObjCSubscriptRefExprClass:
      return getDerived().TransformObjCSubscriptRefExpr(cast_ObjCSubscriptRefExpr(E));
     case OffsetOfExprClass:
      return getDerived().TransformOffsetOfExpr(cast_OffsetOfExpr(E));
     case OpaqueValueExprClass:
      return getDerived().TransformOpaqueValueExpr(cast_OpaqueValueExpr(E));
     case UnresolvedLookupExprClass:
      return getDerived().TransformUnresolvedLookupExpr(cast_UnresolvedLookupExpr(E));
     case UnresolvedMemberExprClass:
      return getDerived().TransformUnresolvedMemberExpr(cast_UnresolvedMemberExpr(E));
     case PackExpansionExprClass:
      return getDerived().TransformPackExpansionExpr(cast_PackExpansionExpr(E));
     case ParenExprClass:
      return getDerived().TransformParenExpr(cast_ParenExpr(E));
     case ParenListExprClass:
      return getDerived().TransformParenListExpr(cast_ParenListExpr(E));
     case PredefinedExprClass:
      return getDerived().TransformPredefinedExpr(cast_PredefinedExpr(E));
     case PseudoObjectExprClass:
      return getDerived().TransformPseudoObjectExpr(cast_PseudoObjectExpr(E));
     case ShuffleVectorExprClass:
      return getDerived().TransformShuffleVectorExpr(cast_ShuffleVectorExpr(E));
     case SizeOfPackExprClass:
      return getDerived().TransformSizeOfPackExpr(cast_SizeOfPackExpr(E));
     case StmtExprClass:
      return getDerived().TransformStmtExpr(cast_StmtExpr(E));
     case StringLiteralClass:
      return getDerived().TransformStringLiteral(cast_StringLiteral(E));
     case SubstNonTypeTemplateParmExprClass:
      return getDerived().TransformSubstNonTypeTemplateParmExpr(cast_SubstNonTypeTemplateParmExpr(E));
     case SubstNonTypeTemplateParmPackExprClass:
      return getDerived().TransformSubstNonTypeTemplateParmPackExpr(cast_SubstNonTypeTemplateParmPackExpr(E));
     case TypeTraitExprClass:
      return getDerived().TransformTypeTraitExpr(cast_TypeTraitExpr(E));
     case TypoExprClass:
      return getDerived().TransformTypoExpr(cast_TypoExpr(E));
     case UnaryExprOrTypeTraitExprClass:
      return getDerived().TransformUnaryExprOrTypeTraitExpr(cast_UnaryExprOrTypeTraitExpr(E));
     case UnaryOperatorClass:
      return getDerived().TransformUnaryOperator(cast_UnaryOperator(E));
     case VAArgExprClass:
      return getDerived().TransformVAArgExpr(cast_VAArgExpr(E));
     case ForStmtClass:
      break;
     case GotoStmtClass:
      break;
     case IfStmtClass:
      break;
     case IndirectGotoStmtClass:
      break;
     case LabelStmtClass:
      break;
     case MSDependentExistsStmtClass:
      break;
     case NullStmtClass:
      break;
     case OMPAtomicDirectiveClass:
      break;
     case OMPBarrierDirectiveClass:
      break;
     case OMPCancelDirectiveClass:
      break;
     case OMPCancellationPointDirectiveClass:
      break;
     case OMPCriticalDirectiveClass:
      break;
     case OMPFlushDirectiveClass:
      break;
     case OMPDistributeDirectiveClass:
      break;
     case OMPDistributeParallelForDirectiveClass:
      break;
     case OMPDistributeParallelForSimdDirectiveClass:
      break;
     case OMPDistributeSimdDirectiveClass:
      break;
     case OMPForDirectiveClass:
      break;
     case OMPForSimdDirectiveClass:
      break;
     case OMPParallelForDirectiveClass:
      break;
     case OMPParallelForSimdDirectiveClass:
      break;
     case OMPSimdDirectiveClass:
      break;
     case OMPTargetParallelForSimdDirectiveClass:
      break;
     case OMPTaskLoopDirectiveClass:
      break;
     case OMPTaskLoopSimdDirectiveClass:
      break;
     case OMPMasterDirectiveClass:
      break;
     case OMPOrderedDirectiveClass:
      break;
     case OMPParallelDirectiveClass:
      break;
     case OMPParallelSectionsDirectiveClass:
      break;
     case OMPSectionDirectiveClass:
      break;
     case OMPSectionsDirectiveClass:
      break;
     case OMPSingleDirectiveClass:
      break;
     case OMPTargetDataDirectiveClass:
      break;
     case OMPTargetDirectiveClass:
      break;
     case OMPTargetEnterDataDirectiveClass:
      break;
     case OMPTargetExitDataDirectiveClass:
      break;
     case OMPTargetParallelDirectiveClass:
      break;
     case OMPTargetParallelForDirectiveClass:
      break;
     case OMPTargetUpdateDirectiveClass:
      break;
     case OMPTaskDirectiveClass:
      break;
     case OMPTaskgroupDirectiveClass:
      break;
     case OMPTaskwaitDirectiveClass:
      break;
     case OMPTaskyieldDirectiveClass:
      break;
     case OMPTeamsDirectiveClass:
      break;
     case ObjCAtCatchStmtClass:
      break;
     case ObjCAtFinallyStmtClass:
      break;
     case ObjCAtSynchronizedStmtClass:
      break;
     case ObjCAtThrowStmtClass:
      break;
     case ObjCAtTryStmtClass:
      break;
     case ObjCAutoreleasePoolStmtClass:
      break;
     case ObjCForCollectionStmtClass:
      break;
     case ReturnStmtClass:
      break;
     case SEHExceptStmtClass:
      break;
     case SEHFinallyStmtClass:
      break;
     case SEHLeaveStmtClass:
      break;
     case SEHTryStmtClass:
      break;
     case CaseStmtClass:
      break;
     case DefaultStmtClass:
      break;
     case SwitchStmtClass:
      break;
     case WhileStmtClass:
      break;
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  /// \brief Transform the given initializer.
  ///
  /// By default, this routine transforms an initializer by stripping off the
  /// semantic nodes added by initialization, then passing the result to
  /// TransformExpr or TransformExprs.
  ///
  /// \returns the transformed initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3209,
   FQN="clang::TreeTransform::TransformInitializer", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformInitializerEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformInitializerEPNS_4ExprEb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformInitializer(Expr /*P*/ Init, boolean NotCopyInit) {
    // Initializers are instantiated like expressions, except that various outer
    // layers are stripped.
    if (!(Init != null)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Init);
    }
    {
      
      ExprWithCleanups /*P*/ ExprTemp = dyn_cast_ExprWithCleanups(Init);
      if ((ExprTemp != null)) {
        Init = ExprTemp.getSubExpr();
      }
    }
    {
      
      MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(Init);
      if ((MTE != null)) {
        Init = MTE.GetTemporaryExpr();
      }
    }
    {
      
      CXXBindTemporaryExpr /*P*/ Binder;
      while (((/*P*/ Binder = dyn_cast_CXXBindTemporaryExpr(Init)) != null)) {
        Init = Binder.getSubExpr();
      }
    }
    {
      
      ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(Init);
      if ((ICE != null)) {
        Init = ICE.getSubExprAsWritten();
      }
    }
    {
      
      CXXStdInitializerListExpr /*P*/ ILE = dyn_cast_CXXStdInitializerListExpr(Init);
      if ((ILE != null)) {
        return TransformInitializer(ILE.getSubExpr(), NotCopyInit);
      }
    }
    
    // If this is copy-initialization, we only need to reconstruct
    // InitListExprs. Other forms of copy-initialization will be a no-op if
    // the initializer is already the right type.
    CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(Init);
    if (!NotCopyInit && !((Construct != null) && Construct.isListInitialization())) {
      return getDerived().TransformExpr(Init);
    }
    {
      
      // Revert value-initialization back to empty parens.
      CXXScalarValueInitExpr /*P*/ VIE = dyn_cast_CXXScalarValueInitExpr(Init);
      if ((VIE != null)) {
        SourceRange Parens = VIE.getSourceRange();
        return getDerived().RebuildParenListExpr(Parens.getBegin(), new MutableArrayRef<Expr /*P*/ >(None, true), 
            Parens.getEnd());
      }
    }
    
    // FIXME: We shouldn't build ImplicitValueInitExprs for direct-initialization.
    if (isa_ImplicitValueInitExpr(Init)) {
      return getDerived().RebuildParenListExpr(new SourceLocation(), new MutableArrayRef<Expr /*P*/ >(None, true), 
          new SourceLocation());
    }
    
    // Revert initialization by constructor back to a parenthesized or braced list
    // of expressions. Any other form of initializer can just be reused directly.
    if (!(Construct != null) || isa_CXXTemporaryObjectExpr(Construct)) {
      return getDerived().TransformExpr(Init);
    }
    
    // If the initialization implicitly converted an initializer list to a
    // std::initializer_list object, unwrap the std::initializer_list too.
    if ((Construct != null) && Construct.isStdInitListInitialization()) {
      return TransformInitializer(Construct.getArg(0), NotCopyInit);
    }
    
    SmallVector<Expr /*P*/ > NewArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    bool$ptr ArgChanged = create_bool$ptr(false);
    if (getDerived().TransformExprs(Construct.getArgs(), Construct.getNumArgs(), 
        /*IsCall*/ true, NewArgs, $AddrOf(ArgChanged))) {
      return ExprError();
    }
    
    // If this was list initialization, revert to list form.
    if (Construct.isListInitialization()) {
      return getDerived().RebuildInitList(Construct.getLocStart(), new MutableArrayRef<Expr /*P*/ >(NewArgs, true), 
          Construct.getLocEnd(), 
          Construct.getType());
    }
    
    // Build a ParenListExpr to represent anything else.
    SourceRange Parens = Construct.getParenOrBraceRange();
    if (Parens.isInvalid()) {
      // This was a variable declaration's initialization for which no initializer
      // was specified.
      assert (NewArgs.empty()) : "no parens or braces but have direct init with arguments?";
      return ExprEmpty();
    }
    return getDerived().RebuildParenListExpr(Parens.getBegin(), new MutableArrayRef<Expr /*P*/ >(NewArgs, true), 
        Parens.getEnd());
  }

  
  /// \brief Transform the given list of expressions.
  ///
  /// This routine transforms a list of expressions by invoking
  /// \c TransformExpr() for each subexpression. However, it also provides
  /// support for variadic templates by expanding any pack expansions (if the
  /// derived class permits such expansion) along the way. When pack expansions
  /// are present, the number of outputs may not equal the number of inputs.
  ///
  /// \param Inputs The set of expressions to be transformed.
  ///
  /// \param NumInputs The number of expressions in \c Inputs.
  ///
  /// \param IsCall If \c true, then this transform is being performed on
  /// function-call arguments, and any arguments that should be dropped, will
  /// be.
  ///
  /// \param Outputs The transformed input expressions will be added to this
  /// vector.
  ///
  /// \param ArgChanged If non-NULL, will be set \c true if any argument changed
  /// due to transformation.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3286,
   FQN="clang::TreeTransform::TransformExprs", NM="_ZN5clang13TreeTransform14TransformExprsEPKPNS_4ExprEjbRN4llvm15SmallVectorImplIS2_EEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransform14TransformExprsEPKPNS_4ExprEjbRN4llvm15SmallVectorImplIS2_EEPb")
  //</editor-fold>
  public boolean TransformExprs(type$ptr<Expr /*P*/ /*const*/ /*P*/> Inputs, 
                /*uint*/int NumInputs, 
                boolean IsCall, 
                final SmallVectorImpl<Expr /*P*/ > /*&*/ Outputs) {
    return TransformExprs(Inputs, 
                NumInputs, 
                IsCall, 
                Outputs, 
                (bool$ptr/*bool P*/ )null);
  }
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExprs">
  @Converted(kind = Converted.Kind.MANUAL/*printed based on intstantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3287,
   FQN="clang::TreeTransform::TransformExprs", NM="_ZN5clang13TreeTransform14TransformExprsEPKPNS_4ExprEjbRN4llvm15SmallVectorImplIS2_EEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransform14TransformExprsEPKPNS_4ExprEjbRN4llvm15SmallVectorImplIS2_EEPb")
  //</editor-fold>
  public boolean TransformExprs(type$ptr<Expr /*P*/ /*const*/ /*P*/> Inputs, /*uint*/int NumInputs, boolean IsCall, 
                final SmallVectorImpl<Expr /*P*/ > /*&*/ Outputs, 
                bool$ptr/*bool P*/ ArgChanged) {
    for (/*uint*/int I = 0; I != NumInputs; ++I) {
      // If requested, drop call arguments that need to be dropped.
      if (IsCall && getDerived().DropCallArgument(Inputs.$at(I))) {
        if (Native.$bool(ArgChanged)) {
          ArgChanged.$set(true);
        }
        
        break;
      }
      {
        
        PackExpansionExpr /*P*/ Expansion = dyn_cast_PackExpansionExpr(Inputs.$at(I));
        if ((Expansion != null)) {
          Expr /*P*/ Pattern = Expansion.getPattern();
          
          SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
          getSema().collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(Pattern), Unexpanded);
          assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
          
          // Determine whether the set of unexpanded parameter packs can and should
          // be expanded.
          bool$ref Expand = create_bool$ref(true);
          bool$ref RetainExpansion = create_bool$ref(false);
          OptionalUInt OrigNumExpansions = Expansion.getNumExpansions();
          OptionalUInt NumExpansions = new OptionalUInt(OrigNumExpansions);
          if (getDerived().TryExpandParameterPacks(Expansion.getEllipsisLoc(), 
              Pattern.getSourceRange(), 
              new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
              Expand, RetainExpansion, 
              NumExpansions)) {
            return true;
          }
          if (!Expand.$deref()) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
            try {
              // The transform has determined that we should perform a simple
              // transformation on the pack expansion, producing another pack
              // expansion.
              SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
              ActionResultTTrue<Expr /*P*/ > OutPattern = getDerived().TransformExpr(Pattern);
              if (OutPattern.isInvalid()) {
                return true;
              }
              
              ActionResultTTrue<Expr /*P*/ > Out = getDerived().RebuildPackExpansion(OutPattern.get(), 
                  Expansion.getEllipsisLoc(), 
                  new OptionalUInt(NumExpansions));
              if (Out.isInvalid()) {
                return true;
              }
              if (Native.$bool(ArgChanged)) {
                ArgChanged.$set(true);
              }
              Outputs.push_back(Out.get());
              continue;
            } finally {
              if (SubstIndex != null) { SubstIndex.$destroy(); }
            }
          }
          
          // Record right away that the argument was changed.  This needs
          // to happen even if the array expands to nothing.
          if (Native.$bool(ArgChanged)) {
            ArgChanged.$set(true);
          }
          
          // The transform has determined that we should perform an elementwise
          // expansion of the pattern. Do so.
          for (/*uint*/int I$1 = 0; I$1 != NumExpansions.$star(); ++I$1) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
            try {
              SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I$1);
              ActionResultTTrue<Expr /*P*/ > Out = getDerived().TransformExpr(Pattern);
              if (Out.isInvalid()) {
                return true;
              }
              if (Out.get().containsUnexpandedParameterPack()) {
                Out.$assignMove(getDerived().RebuildPackExpansion(Out.get(), Expansion.getEllipsisLoc(), new OptionalUInt(OrigNumExpansions)));
                if (Out.isInvalid()) {
                  return true;
                }
              }
              
              Outputs.push_back(Out.get());
            } finally {
              if (SubstIndex != null) { SubstIndex.$destroy(); }
            }
          }
          
          // If we're supposed to retain a pack expansion, do so by temporarily
          // forgetting the partially-substituted parameter pack.
          if (RetainExpansion.$deref()) {
            ForgetPartiallySubstitutedPackRAII Forget = null;
            try {
              Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
              
              ActionResultTTrue<Expr /*P*/ > Out = getDerived().TransformExpr(Pattern);
              if (Out.isInvalid()) {
                return true;
              }
              
              Out.$assignMove(getDerived().RebuildPackExpansion(Out.get(), Expansion.getEllipsisLoc(), new OptionalUInt(OrigNumExpansions)));
              if (Out.isInvalid()) {
                return true;
              }
              
              Outputs.push_back(Out.get());
            } finally {
              if (Forget != null) { Forget.$destroy(); }
            }
          }
          
          continue;
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > Result = IsCall ? getDerived().TransformInitializer(Inputs.$at(I), /*DirectInit*/ false) : getDerived().TransformExpr(Inputs.$at(I));
      if (Result.isInvalid()) {
        return true;
      }
      if (Result.get() != Inputs.$at(I) && Native.$bool(ArgChanged)) {
        ArgChanged.$set(true);
      }
      
      Outputs.push_back(Result.get());
    }
    
    return false;
  }

  
  /// \brief Transform the given declaration, which is referenced from a type
  /// or expression.
  ///
  /// By default, acts as the identity function on declarations, unless the
  /// transformer has had to transform the declaration itself. Subclasses
  /// may override this function to provide alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 404,
   FQN="clang::TreeTransform::TransformDecl", NM="_ZN5clang13TreeTransform13TransformDeclENS_14SourceLocationEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform13TransformDeclENS_14SourceLocationEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ TransformDecl(SourceLocation Loc, Decl /*P*/ D) {
    DenseMapIterator<Decl /*P*/ , Decl /*P*/ > Known = TransformedLocalDecls.find(D);
    if (Native.$noteq_iter(Known, TransformedLocalDecls.end())) {
      return Known.$arrow().second;
    }
    return D;
  }

  
  /// \brief Transform the specified condition.
  ///
  /// By default, this transforms the variable and expression and rebuilds
  /// the condition.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3400,
   FQN="clang::TreeTransform::TransformCondition", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformConditionENS_14SourceLocationEPNS_7VarDeclEPNS_4ExprENS_4Sema13ConditionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformConditionENS_14SourceLocationEPNS_7VarDeclEPNS_4ExprENS_4Sema13ConditionKindE")
  //</editor-fold>
  public Sema.ConditionResult TransformCondition(SourceLocation Loc, VarDecl /*P*/ Var, 
                    Expr /*P*/ $Expr, 
                    Sema.ConditionKind Kind) {
    if ((Var != null)) {
      VarDecl /*P*/ ConditionVar = cast_or_null_VarDecl(getDerived().TransformDefinition(Var.getLocation(), Var));
      if (!(ConditionVar != null)) {
        return Sema.ConditionError();
      }
      
      return getSema().ActOnConditionVariable(ConditionVar, new SourceLocation(Loc), Kind);
    }
    if (($Expr != null)) {
      ActionResultTTrue<Expr /*P*/ > CondExpr = getDerived().TransformExpr($Expr);
      if (CondExpr.isInvalid()) {
        return Sema.ConditionError();
      }
      
      return getSema().ActOnCondition((Scope /*P*/ )null, new SourceLocation(Loc), CondExpr.get(), Kind);
    }
    
    return new Sema.ConditionResult();
  }

  
  /// \brief Transform the attributes associated with the given declaration and
  /// place them on the new declaration.
  ///
  /// By default, this operation does nothing. Subclasses may override this
  /// behavior to transform attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::transformAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 426,
   FQN="clang::TreeTransform::transformAttrs", NM="_ZN5clang13TreeTransform14transformAttrsEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform14transformAttrsEPNS_4DeclES2_")
  //</editor-fold>
  public void transformAttrs(Decl /*P*/ Old, Decl /*P*/ New) {
  }


  
  /// \brief Note that a local declaration has been transformed by this
  /// transformer.
  ///
  /// Local declarations are typically transformed via a call to
  /// TransformDefinition. However, in some cases (e.g., lambda expressions),
  /// the transformer itself has to transform the declarations. This routine
  /// can be overridden by a subclass that keeps track of such mappings.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::transformedLocalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 435,
   FQN="clang::TreeTransform::transformedLocalDecl", NM="_ZN5clang13TreeTransform20transformedLocalDeclEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform20transformedLocalDeclEPNS_4DeclES2_")
  //</editor-fold>
  public void transformedLocalDecl(Decl /*P*/ Old, Decl /*P*/ New) {
    TransformedLocalDecls.$set(Old, New);
  }


  
  /// \brief Transform the definition of the given declaration.
  ///
  /// By default, invokes TransformDecl() to transform the declaration.
  /// Subclasses may override this function to provide alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 443,
   FQN="clang::TreeTransform::TransformDefinition", NM="_ZN5clang13TreeTransform19TransformDefinitionENS_14SourceLocationEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform19TransformDefinitionENS_14SourceLocationEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ TransformDefinition(SourceLocation Loc, Decl /*P*/ D) {
    return getDerived().TransformDecl(Loc, D);
  }


  
  /// \brief Transform the given declaration, which was the first part of a
  /// nested-name-specifier in a member access expression.
  ///
  /// This specific declaration transformation only applies to the first
  /// identifier in a nested-name-specifier of a member access expression, e.g.,
  /// the \c T in \c x->T::member
  ///
  /// By default, invokes TransformDecl() to transform the declaration.
  /// Subclasses may override this function to provide alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFirstQualifierInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 456,
   FQN="clang::TreeTransform::TransformFirstQualifierInScope", NM="_ZN5clang13TreeTransform30TransformFirstQualifierInScopeEPNS_9NamedDeclENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform30TransformFirstQualifierInScopeEPNS_9NamedDeclENS_14SourceLocationE")
  //</editor-fold>
  public NamedDecl /*P*/ TransformFirstQualifierInScope(NamedDecl /*P*/ D, SourceLocation Loc) {
    return cast_or_null_NamedDecl(getDerived().TransformDecl(Loc, D));
  }


  /// \brief Transform the given nested-name-specifier with source-location
  /// information.
  ///
  /// By default, transforms all of the types and declarations within the
  /// nested-name-specifier. Subclasses may override this function to provide
  /// alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformNestedNameSpecifierLoc">
  
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 466,
   FQN="clang::TreeTransform::TransformNestedNameSpecifierLoc")
  public NestedNameSpecifierLoc TransformNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS) {
    return TransformNestedNameSpecifierLoc(NNS, new QualType());
  }
  public NestedNameSpecifierLoc TransformNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS, QualType ObjectType) {
    return TransformNestedNameSpecifierLoc(NNS, ObjectType, null);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3425,
   FQN="clang::TreeTransform::TransformNestedNameSpecifierLoc", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformNestedNameSpecifierLocENS_22NestedNameSpecifierLocENS_8QualTypeEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformNestedNameSpecifierLocENS_22NestedNameSpecifierLocENS_8QualTypeEPNS_9NamedDeclE")
  //</editor-fold>
  public NestedNameSpecifierLoc TransformNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS, 
                                 QualType ObjectType, 
                                 NamedDecl /*P*/ FirstQualifierInScope) {
    CXXScopeSpec SS = null;
    try {
      SmallVector<NestedNameSpecifierLoc> Qualifiers/*J*/= new SmallVector<NestedNameSpecifierLoc>(4, new NestedNameSpecifierLoc());
      for (NestedNameSpecifierLoc Qualifier = new NestedNameSpecifierLoc(NNS); Qualifier.$bool();
           Qualifier.$assignMove(Qualifier.getPrefix()))  {
        Qualifiers.push_back(Qualifier);
      }
      
      SS/*J*/= new CXXScopeSpec();
      while (!Qualifiers.empty()) {
        NestedNameSpecifierLoc Q = Qualifiers.pop_back_val();
        NestedNameSpecifier /*P*/ QNNS = Q.getNestedNameSpecifier();
        switch (QNNS.getKind()) {
         case Identifier:
          if (SemaRef.BuildCXXNestedNameSpecifier(/*Scope=*/ (Scope /*P*/ )null, 
              $Deref(QNNS.getAsIdentifier()), 
              Q.getLocalBeginLoc(), 
              Q.getLocalEndLoc(), 
              new QualType(ObjectType), false, SS, 
              FirstQualifierInScope, false)) {
            return new NestedNameSpecifierLoc();
          }
          
          break;
         case Namespace:
          {
            NamespaceDecl /*P*/ NS = cast_or_null_NamespaceDecl(getDerived().TransformDecl(Q.getLocalBeginLoc(), 
    QNNS.getAsNamespace()));
            SS.Extend(SemaRef.Context, NS, Q.getLocalBeginLoc(), Q.getLocalEndLoc());
            break;
          }
         case NamespaceAlias:
          {
            NamespaceAliasDecl /*P*/ Alias = cast_or_null_NamespaceAliasDecl(getDerived().TransformDecl(Q.getLocalBeginLoc(), 
    QNNS.getAsNamespaceAlias()));
            SS.Extend(SemaRef.Context, Alias, Q.getLocalBeginLoc(), 
                Q.getLocalEndLoc());
            break;
          }
         case Global:
          // There is no meaningful transformation that one could perform on the
          // global scope.
          SS.MakeGlobal(SemaRef.Context, Q.getBeginLoc());
          break;
         case Super:
          {
            CXXRecordDecl /*P*/ RD = cast_or_null_CXXRecordDecl(getDerived().TransformDecl(new SourceLocation(), QNNS.getAsRecordDecl()));
            SS.MakeSuper(SemaRef.Context, RD, Q.getBeginLoc(), Q.getEndLoc());
            break;
          }
         case TypeSpecWithTemplate:
         case TypeSpec:
          {
            TypeLoc TL = TransformTypeInObjectScope(Q.getTypeLoc(), new QualType(ObjectType), 
                FirstQualifierInScope, SS);
            if (!TL.$bool()) {
              return new NestedNameSpecifierLoc();
            }
            if (TL.getType().$arrow().isDependentType() || TL.getType().$arrow().isRecordType()
               || (SemaRef.getLangOpts().CPlusPlus11
               && TL.getType().$arrow().isEnumeralType())) {
              assert (!TL.getType().hasLocalQualifiers()) : "Can't get cv-qualifiers here";
              if (TL.getType().$arrow().isEnumeralType()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track(SemaRef.Diag(TL.getBeginLoc(), 
                      diag.warn_cxx98_compat_enum_nested_name_spec)));
                } finally {
                  $c$.$destroy();
                }
              }
              SS.Extend(SemaRef.Context, /*FIXME:*/ new SourceLocation(), new TypeLoc(TL), 
                  Q.getLocalEndLoc());
              break;
            }
            // If the nested-name-specifier is an invalid type def, don't emit an
            // error because a previous error should have already been emitted.
            TypedefTypeLoc TTL = TL.getAs(TypedefTypeLoc.class);
            if (!TTL.$bool() || !TTL.getTypedefNameDecl().isInvalidDecl()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TL.getBeginLoc(), diag.err_nested_name_spec_non_tag)), 
                        TL.getType()), SS.getRange()));
              } finally {
                $c$.$destroy();
              }
            }
            return new NestedNameSpecifierLoc();
          }
        }
        
        // The qualifier-in-scope and object type only apply to the leftmost entity.
        FirstQualifierInScope = null;
        ObjectType.$assignMove(new QualType());
      }
      
      // Don't rebuild the nested-name-specifier if we don't have to.
      if (SS.getScopeRep() == NNS.getNestedNameSpecifier()
         && !getDerived().AlwaysRebuild()) {
        return new NestedNameSpecifierLoc(JD$Move.INSTANCE, NNS);
      }
      
      // If we can re-use the source-location data from the original
      // nested-name-specifier, do so.
      if (SS.location_size() == NNS.getDataLength()
         && /*JAVA*/memcmp_eq(SS.location_data(), NNS.getOpaqueData(), SS.location_size())) {
        return new NestedNameSpecifierLoc(SS.getScopeRep(), NNS.getOpaqueData());
      }
      
      // Allocate new nested-name-specifier location information.
      return SS.getWithLocInContext(SemaRef.Context);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Transform the given declaration name.
  ///
  /// By default, transforms the types of conversion function, constructor,
  /// and destructor names and then (if needed) rebuilds the declaration name.
  /// Identifiers and selectors are returned unmodified. Sublcasses may
  /// override this function to provide alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3538,
   FQN="clang::TreeTransform::TransformDeclarationNameInfo", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformDeclarationNameInfoERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformDeclarationNameInfoERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  public DeclarationNameInfo TransformDeclarationNameInfo(final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    DeclarationName Name = NameInfo.getName();
    if (!Name.$bool()) {
      return new DeclarationNameInfo();
    }
    switch (Name.getNameKind()) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXOperatorName:
     case CXXLiteralOperatorName:
     case CXXUsingDirective:
      return new DeclarationNameInfo(NameInfo);
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ NewTInfo;
        CanQual<Type> NewCanTy/*J*/= new CanQual<Type>();
        {
          TypeSourceInfo /*P*/ OldTInfo = NameInfo.getNamedTypeInfo();
          if ((OldTInfo != null)) {
            NewTInfo = getDerived().TransformType(OldTInfo);
            if (!(NewTInfo != null)) {
              return new DeclarationNameInfo();
            }
            NewCanTy.$assignMove(SemaRef.Context.getCanonicalType(NewTInfo.getType()));
          } else {
            TemporaryBase Rebase = null;
            try {
              NewTInfo = null;
              Rebase/*J*/= /*ParenList*/new TemporaryBase(Native.$star(this), NameInfo.getLoc(), Name);
              QualType NewT = getDerived().TransformType(Name.getCXXNameType());
              if (NewT.isNull()) {
                return new DeclarationNameInfo();
              }
              NewCanTy.$assignMove(SemaRef.Context.getCanonicalType(new QualType(NewT)));
            } finally {
              if (Rebase != null) { Rebase.$destroy(); }
            }
          }
        }
        
        DeclarationName NewName = SemaRef.Context.DeclarationNames.getCXXSpecialName(Name.getNameKind(), 
            new CanQual<Type>(NewCanTy));
        DeclarationNameInfo NewNameInfo/*J*/= new DeclarationNameInfo(NameInfo);
        NewNameInfo.setName(new DeclarationName(NewName));
        NewNameInfo.setNamedTypeInfo(NewTInfo);
        return NewNameInfo;
      }
    }
    throw new llvm_unreachable("Unknown name kind.");
  }

  
  /// \brief Transform the given template name.
  ///
  /// \param SS The nested-name-specifier that qualifies the template
  /// name. This nested-name-specifier must already have been transformed.
  ///
  /// \param Name The template name to transform.
  ///
  /// \param NameLoc The source location of the template name.
  ///
  /// \param ObjectType If we're translating a template name within a member
  /// access expression, this is the type of the object whose member template
  /// is being referenced.
  ///
  /// \param FirstQualifierInScope If the first part of a nested-name-specifier
  /// also refers to a name within the current (lexical) scope, this is the
  /// declaration it refers to.
  ///
  /// By default, transforms the template name by transforming the declarations
  /// and nested-name-specifiers that occur within the template name.
  /// Subclasses may override this function to provide alternate behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateName">

  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 466,
   FQN="clang::TreeTransform::TransformNestedNameSpecifierLoc")
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, TemplateName Name, SourceLocation NameLoc) {
    return TransformTemplateName(SS, Name, NameLoc, new QualType());
  }
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, TemplateName Name, SourceLocation NameLoc, QualType ObjectType) {
    return TransformTemplateName(SS, Name, NameLoc, ObjectType, (NamedDecl) null);
  }
  
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3589,
   FQN="clang::TreeTransform::TransformTemplateName", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformTemplateNameERNS_12CXXScopeSpecENS_12TemplateNameENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformTemplateNameERNS_12CXXScopeSpecENS_12TemplateNameENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclE")
  //</editor-fold>
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, TemplateName Name, 
                       SourceLocation NameLoc, 
                       QualType ObjectType, 
                       NamedDecl /*P*/ FirstQualifierInScope) {
    {
      QualifiedTemplateName /*P*/ QTN = Name.getAsQualifiedTemplateName();
      if ((QTN != null)) {
        TemplateDecl /*P*/ Template = QTN.getTemplateDecl();
        assert ((Template != null)) : "qualified template name must refer to a template";
        
        TemplateDecl /*P*/ TransTemplate = cast_or_null_TemplateDecl(getDerived().TransformDecl(new SourceLocation(NameLoc), 
    Template));
        if (!(TransTemplate != null)) {
          return new TemplateName();
        }
        if (!getDerived().AlwaysRebuild()
           && SS.getScopeRep() == QTN.getQualifier()
           && TransTemplate == Template) {
          return new TemplateName(JD$Move.INSTANCE, Name);
        }
        
        return getDerived().RebuildTemplateName(SS, QTN.hasTemplateKeyword(), 
            TransTemplate);
      }
    }
    {
      
      DependentTemplateName /*P*/ DTN = Name.getAsDependentTemplateName();
      if ((DTN != null)) {
        if ((SS.getScopeRep() != null)) {
          // These apply to the scope specifier, not the template.
          ObjectType.$assignMove(new QualType());
          FirstQualifierInScope = null;
        }
        if (!getDerived().AlwaysRebuild()
           && SS.getScopeRep() == DTN.getQualifier()
           && ObjectType.isNull()) {
          return new TemplateName(JD$Move.INSTANCE, Name);
        }
        if (DTN.isIdentifier()) {
          return getDerived().RebuildTemplateName(SS, 
              $Deref(DTN.getIdentifier()), 
              new SourceLocation(NameLoc), 
              new QualType(ObjectType), 
              FirstQualifierInScope);
        }
        
        return getDerived().RebuildTemplateName(SS, DTN.getOperator(), new SourceLocation(NameLoc), 
            new QualType(ObjectType));
      }
    }
    {
      
      TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
      if ((Template != null)) {
        TemplateDecl /*P*/ TransTemplate = cast_or_null_TemplateDecl(getDerived().TransformDecl(new SourceLocation(NameLoc), 
    Template));
        if (!(TransTemplate != null)) {
          return new TemplateName();
        }
        if (!getDerived().AlwaysRebuild()
           && TransTemplate == Template) {
          return new TemplateName(JD$Move.INSTANCE, Name);
        }
        
        return new TemplateName(TransTemplate);
      }
    }
    {
      
      SubstTemplateTemplateParmPackStorage /*P*/ SubstPack = Name.getAsSubstTemplateTemplateParmPack();
      if ((SubstPack != null)) {
        TemplateTemplateParmDecl /*P*/ TransParam = cast_or_null_TemplateTemplateParmDecl(getDerived().TransformDecl(new SourceLocation(NameLoc), SubstPack.getParameterPack()));
        if (!(TransParam != null)) {
          return new TemplateName();
        }
        if (!getDerived().AlwaysRebuild()
           && TransParam == SubstPack.getParameterPack()) {
          return new TemplateName(JD$Move.INSTANCE, Name);
        }
        
        return getDerived().RebuildTemplateName(TransParam, 
            SubstPack.getArgumentPack());
      }
    }
    
    // These should be getting filtered out before they reach the AST.
    throw new llvm_unreachable("overloaded function decl survived to here");
  }

  
  /// \brief Transform the given template argument.
  ///
  /// By default, this operation transforms the type, expression, or
  /// declaration stored within the template argument and constructs a
  /// new template argument from the transformed result. Subclasses may
  /// override this function to provide alternate behavior.
  ///
  /// Returns true if there was an error.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3723,
   FQN="clang::TreeTransform::TransformTemplateArgument", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformTemplateArgumentERKNS_19TemplateArgumentLocERS4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformTemplateArgumentERKNS_19TemplateArgumentLocERS4_b")
  //</editor-fold>
  public boolean TransformTemplateArgument(final /*const*/ TemplateArgumentLoc /*&*/ Input, 
                           final TemplateArgumentLoc /*&*/ Output, 
                           boolean Uneval) {
    final /*const*/ TemplateArgument /*&*/ Arg = Input.getArgument();
    switch (Arg.getKind()) {
     case Null:
     case Integral:
     case Pack:
     case Declaration:
     case NullPtr:
      throw new llvm_unreachable("Unexpected TemplateArgument");
     case Type:
      {
        TypeSourceInfo /*P*/ DI = Input.getTypeSourceInfo();
        if (!(DI != null)) {
          DI = InventTypeSourceInfo(Input.getArgument().getAsType());
        }
        
        DI = getDerived().TransformType(DI);
        if (!(DI != null)) {
          return true;
        }
        
        Output.$assignMove(new TemplateArgumentLoc(new TemplateArgument(DI.getType()), DI));
        return false;
      }
     case Template:
      {
        CXXScopeSpec SS = null;
        try {
          NestedNameSpecifierLoc QualifierLoc = Input.getTemplateQualifierLoc();
          if (QualifierLoc.$bool()) {
            QualifierLoc.$assignMove(getDerived().TransformNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc)));
            if (!QualifierLoc.$bool()) {
              return true;
            }
          }
          
          SS/*J*/= new CXXScopeSpec();
          SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
          TemplateName Template = getDerived().TransformTemplateName(SS, Arg.getAsTemplate(), 
              Input.getTemplateNameLoc());
          if (Template.isNull()) {
            return true;
          }
          
          Output.$assignMove(new TemplateArgumentLoc(new TemplateArgument(new TemplateName(Template)), new NestedNameSpecifierLoc(QualifierLoc), 
                  Input.getTemplateNameLoc()));
          return false;
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
     case TemplateExpansion:
      throw new llvm_unreachable("Caller should expand pack expansions");
     case Expression:
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          // Template argument expressions are constant expressions.
          Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(getSema(), Uneval ? Sema.ExpressionEvaluationContext.Unevaluated : Sema.ExpressionEvaluationContext.ConstantEvaluated);
          
          Expr /*P*/ InputExpr = Input.getSourceExpression();
          if (!(InputExpr != null)) {
            InputExpr = Input.getArgument().getAsExpr();
          }
          
          ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(InputExpr);
          E.$assignMove(SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(E)));
          if (E.isInvalid()) {
            return true;
          }
          Output.$assignMove(new TemplateArgumentLoc(new TemplateArgument(E.get()), E.get()));
          return false;
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
    }
    
    // Work around bogus GCC warning
    return true;
  }

  
  /// \brief Transform the given set of template arguments.
  ///
  /// By default, this operation transforms all of the template arguments
  /// in the input set using \c TransformTemplateArgument(), and appends
  /// the transformed arguments to the output list.
  ///
  /// Note that this overload of \c TransformTemplateArguments() is merely
  /// a convenience function. Subclasses that wish to override this behavior
  /// should override the iterator-based member template version.
  ///
  /// \param Inputs The set of template arguments to be transformed.
  ///
  /// \param NumInputs The number of template arguments in \p Inputs.
  ///
  /// \param Outputs The set of transformed template arguments output by this
  /// routine.
  ///
  /// Returns true if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 536,
   FQN="clang::TreeTransform::TransformTemplateArguments", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTemplateArgumentsEPKNS_19TemplateArgumentLocEjRNS_24TemplateArgumentListInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTemplateArgumentsEPKNS_19TemplateArgumentLocEjRNS_24TemplateArgumentListInfoEb")
  //</editor-fold>
  public boolean TransformTemplateArguments(/*const*/ type$ptr<TemplateArgumentLoc> /*P*/ Inputs, 
                            /*uint*/int NumInputs, 
                            final TemplateArgumentListInfo /*&*/ Outputs, 
                            boolean Uneval) {
    return TransformTemplateArguments(Inputs, Inputs.$add(NumInputs), Outputs, 
        Uneval);
  }

  @Converted(kind = Converted.Kind.MANUAL, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 536,
   FQN="clang::TreeTransform::TransformTemplateArguments")
  public boolean TransformTemplateArguments(/*const*/ type$ptr<TemplateArgumentLoc> /*P*/ Inputs, 
                            /*uint*/int NumInputs, 
                            final TemplateArgumentListInfo /*&*/ Outputs) {
    return TransformTemplateArguments(Inputs, Inputs.$add(NumInputs), Outputs, false);
  }
  
  /// \brief Transform the given set of template arguments.
  ///
  /// By default, this operation transforms all of the template arguments
  /// in the input set using \c TransformTemplateArgument(), and appends
  /// the transformed arguments to the output list.
  ///
  /// \param First An iterator to the first template argument.
  ///
  /// \param Last An iterator one step past the last template argument.
  ///
  /// \param Outputs The set of transformed template arguments output by this
  /// routine.
  ///
  /// Returns true if an error occurred.
  /*template <typename InputIterator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateArguments">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3850,
   FQN="clang::TreeTransform::TransformTemplateArguments", NM="Tpl__ZN5clang13TreeTransform26TransformTemplateArgumentsET_S1_RNS_24TemplateArgumentListInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZN5clang13TreeTransform26TransformTemplateArgumentsET_S1_RNS_24TemplateArgumentListInfoEb")
  //</editor-fold>
  public </*typename*/ InputIterator extends type$iterator<?, TemplateArgumentLoc>> boolean TransformTemplateArguments(InputIterator First, 
                            InputIterator Last, 
                            final TemplateArgumentListInfo /*&*/ Outputs) {
    return TransformTemplateArguments(First, Last, Outputs, false);  
  }
  public </*typename*/ InputIterator extends type$iterator<?, TemplateArgumentLoc>> boolean TransformTemplateArguments(InputIterator _First, InputIterator Last, final TemplateArgumentListInfo /*&*/ Outputs, 
                              boolean Uneval/*= false*/) {
    InputIterator First = $tryClone(_First);
    for (; Native.$noteq_iter(First, Last); First.$preInc()) {
      TemplateArgumentLoc Out/*J*/= new TemplateArgumentLoc();
      TemplateArgumentLoc In = Native.$star(First);
      if (In.getArgument().getKind() == TemplateArgument.ArgKind.Pack) {
        // Unpack argument packs, which we translate them into separate
        // arguments.
        // FIXME: We could do much better if we could guarantee that the
        // TemplateArgumentLocInfo for the pack expansion would be usable for
        // all of the template arguments in the argument pack.
        /*typedef TemplateArgumentLocInventIterator<Derived, TemplateArgument::pack_iterator> PackLocIterator*/
//        final class PackLocIterator extends TemplateArgumentLocInventIterator<Derived, type$ptr<TemplateArgument>/*pack_iterator*/>{ };
        if (TransformTemplateArguments(
                new TemplateArgumentLocInventIterator<Derived, type$ptr<TemplateArgument>/*pack_iterator*/>(Native.$star(this), In.getArgument().pack_begin()), 
                new TemplateArgumentLocInventIterator<Derived, type$ptr<TemplateArgument>/*pack_iterator*/>(Native.$star(this), In.getArgument().pack_end()), 
                Outputs, Uneval)) {
          return true;
        }

        continue;
      }
      if (In.getArgument().isPackExpansion()) {
        // We have a pack expansion, for which we will be substituting into
        // the pattern.
        SourceLocation Ellipsis/*J*/= new SourceLocation();
        OptionalUInt OrigNumExpansions/*J*/= new OptionalUInt();
        TemplateArgumentLoc Pattern = getSema().getTemplateArgumentPackExpansionPattern(In, Ellipsis, OrigNumExpansions);
        
        SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
        getSema().collectUnexpandedParameterPacks_TemplateArgumentLoc(Pattern, Unexpanded);
        assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
        
        // Determine whether the set of unexpanded parameter packs can and should
        // be expanded.
        bool$ref Expand = create_bool$ref();
        bool$ref RetainExpansion = create_bool$ref();
        OptionalUInt NumExpansions = new OptionalUInt(OrigNumExpansions);
        if (getDerived().TryExpandParameterPacks(Ellipsis, 
            Pattern.getSourceRange(), 
            new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false),             
            Expand, 
            RetainExpansion, 
            NumExpansions)) {
          return true;
        }
        if (!Expand.$deref()) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          try {
            // The transform has determined that we should perform a simple
            // transformation on the pack expansion, producing another pack
            // expansion.
            TemplateArgumentLoc OutPattern/*J*/= new TemplateArgumentLoc();
            SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
            if (getDerived().TransformTemplateArgument(Pattern, OutPattern, Uneval)) {
              return true;
            }
            
            Out = getDerived().RebuildPackExpansion(OutPattern, Ellipsis, 
                NumExpansions);
            if (Out.getArgument().isNull()) {
              return true;
            }
            
            Outputs.addArgument(Out);
            continue;
          } finally {
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        
        // The transform has determined that we should perform an elementwise
        // expansion of the pattern. Do so.
        for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          try {
            SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I);
            if (getDerived().TransformTemplateArgument(Pattern, Out, Uneval)) {
              return true;
            }
            if (Out.getArgument().containsUnexpandedParameterPack()) {
              Out = getDerived().RebuildPackExpansion(Out, Ellipsis, 
                  OrigNumExpansions);
              if (Out.getArgument().isNull()) {
                return true;
              }
            }
            
            Outputs.addArgument(Out);
          } finally {
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        
        // If we're supposed to retain a pack expansion, do so by temporarily
        // forgetting the partially-substituted parameter pack.
        if (RetainExpansion.$deref()) {
          ForgetPartiallySubstitutedPackRAII Forget = null;
          try {
            Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
            if (getDerived().TransformTemplateArgument(Pattern, Out, Uneval)) {
              return true;
            }
            
            Out = getDerived().RebuildPackExpansion(Out, Ellipsis, 
                OrigNumExpansions);
            if (Out.getArgument().isNull()) {
              return true;
            }
            
            Outputs.addArgument(Out);
          } finally {
            if (Forget != null) { Forget.$destroy(); }
          }
        }
        
        continue;
      }
      
      // The simple case:
      if (getDerived().TransformTemplateArgument(In, Out, Uneval)) {
        return true;
      }
      
      Outputs.addArgument(Out);
    }
    
    return false;
  }

  
  /// \brief Fakes up a TemplateArgumentLoc for a given TemplateArgument.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::InventTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3673,
   FQN="clang::TreeTransform::InventTemplateArgumentLoc", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25InventTemplateArgumentLocERKNS_16TemplateArgumentERNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25InventTemplateArgumentLocERKNS_16TemplateArgumentERNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void InventTemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Arg, 
                           final TemplateArgumentLoc /*&*/ Output) {
    SourceLocation Loc = getDerived().getBaseLocation();
    switch (Arg.getKind()) {
     case Null:
      throw new llvm_unreachable("null template argument in TreeTransform");
//      break;
     case Type:
      Output.$assignMove(new TemplateArgumentLoc(Arg, 
              SemaRef.Context.getTrivialTypeSourceInfo(Arg.getAsType(), new SourceLocation(Loc))));
      
      break;
     case Template:
     case TemplateExpansion:
      {
        NestedNameSpecifierLocBuilder Builder = null;
        try {
          Builder/*J*/= new NestedNameSpecifierLocBuilder();
          TemplateName Template = Arg.getAsTemplateOrTemplatePattern();
          {
            DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
            if ((DTN != null)) {
              Builder.MakeTrivial(SemaRef.Context, DTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
            } else {
              QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
              if ((QTN != null)) {
                Builder.MakeTrivial(SemaRef.Context, QTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
              }
            }
          }
          if (Arg.getKind() == TemplateArgument.ArgKind.Template) {
            Output.$assignMove(new TemplateArgumentLoc(Arg, 
                    Builder.getWithLocInContext(SemaRef.Context), 
                    new SourceLocation(Loc)));
          } else {
            Output.$assignMove(new TemplateArgumentLoc(Arg, 
                    Builder.getWithLocInContext(SemaRef.Context), 
                    new SourceLocation(Loc), new SourceLocation(Loc)));
          }
          
          break;
        } finally {
          if (Builder != null) { Builder.$destroy(); }
        }
      }
     case Expression:
      Output.$assignMove(new TemplateArgumentLoc(Arg, Arg.getAsExpr()));
      break;
     case Declaration:
     case Integral:
     case Pack:
     case NullPtr:
      Output.$assignMove(new TemplateArgumentLoc(Arg, new TemplateArgumentLocInfo()));
      break;
    }
  }

  
  /// \brief Fakes up a TypeSourceInfo for a type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::InventTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 569,
   FQN="clang::TreeTransform::InventTypeSourceInfo", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20InventTypeSourceInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20InventTypeSourceInfoENS_8QualTypeE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ InventTypeSourceInfo(QualType T) {
    return SemaRef.Context.getTrivialTypeSourceInfo(new QualType(T), 
        getDerived().getBaseLocation());
  }

  
  /// FIXME: By default, this routine adds type qualifiers only to types
  /// that can have qualifiers, and silently suppresses those qualifiers
  /// that are not permitted (e.g., qualifiers on reference or function
  /// types). This is the right thing for template instantiation, but
  /// probably not for other clients.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4033,
   FQN="clang::TreeTransform::TransformQualifiedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformQualifiedTypeERNS_14TypeLocBuilderENS_16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformQualifiedTypeERNS_14TypeLocBuilderENS_16QualifiedTypeLocE")
  //</editor-fold>
  public QualType TransformQualifiedType(final TypeLocBuilder /*&*/ TLB, QualifiedTypeLoc T) {
    Qualifiers Quals = T.getType().getLocalQualifiers();
    
    QualType Result = getDerived().TransformType(TLB, new TypeLoc(JD$Move.INSTANCE, T.getUnqualifiedLoc()));
    if (Result.isNull()) {
      return new QualType();
    }
    
    // Silently suppress qualifiers if the result type can't be qualified.
    // FIXME: this is the right thing for template instantiation, but
    // probably not for other clients.
    if (Result.$arrow().isFunctionType() || Result.$arrow().isReferenceType()) {
      return Result;
    }
    
    // Suppress Objective-C lifetime qualifiers if they don't make sense for the
    // resulting type.
    if (Quals.hasObjCLifetime()) {
      if (!Result.$arrow().isObjCLifetimeType() && !Result.$arrow().isDependentType()) {
        Quals.removeObjCLifetime();
      } else if ((Result.getObjCLifetime().getValue() != 0)) {
        // Objective-C ARC:
        //   A lifetime qualifier applied to a substituted template parameter
        //   overrides the lifetime qualifier from the template argument.
        /*const*/ AutoType /*P*/ AutoTy;
        {
          /*const*/ SubstTemplateTypeParmType /*P*/ SubstTypeParam = dyn_cast_SubstTemplateTypeParmType(Result);
          if ((SubstTypeParam != null)) {
            QualType Replacement = SubstTypeParam.getReplacementType();
            Qualifiers Qs = Replacement.getQualifiers();
            Qs.removeObjCLifetime();
            Replacement.$assignMove(
                SemaRef.Context.getQualifiedType(Replacement.getUnqualifiedType(), 
                    new Qualifiers(Qs))
            );
            Result.$assignMove(SemaRef.Context.getSubstTemplateTypeParmType(SubstTypeParam.getReplacedParameter(), 
                    new QualType(Replacement)));
            TLB.TypeWasModifiedSafely(new QualType(Result));
          } else if (((AutoTy = dyn_cast_AutoType(Result)) != null) && AutoTy.isDeduced()) {
            // 'auto' types behave the same way as template parameters.
            QualType Deduced = AutoTy.getDeducedType();
            Qualifiers Qs = Deduced.getQualifiers();
            Qs.removeObjCLifetime();
            Deduced.$assignMove(SemaRef.Context.getQualifiedType(Deduced.getUnqualifiedType(), 
                    new Qualifiers(Qs)));
            Result.$assignMove(SemaRef.Context.getAutoType(new QualType(Deduced), AutoTy.getKeyword(), 
                    AutoTy.isDependentType()));
            TLB.TypeWasModifiedSafely(new QualType(Result));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Otherwise, complain about the addition of a qualifier to an
              // already-qualified type.
              SourceRange R = T.getUnqualifiedLoc().getSourceRange();
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(R.getBegin(), diag.err_attr_objc_ownership_redundant)), 
                      Result), R));
              
              Quals.removeObjCLifetime();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    if (!Quals.empty()) {
      Result.$assignMove(SemaRef.BuildQualifiedType(new QualType(Result), T.getBeginLoc(), new Qualifiers(Quals)));
      // BuildQualifiedType might not add qualifiers if they are invalid.
      if (Result.hasLocalQualifiers()) {
        TLB.push(QualifiedTypeLoc.class, new QualType(Result));
      }
      // No location information to preserve.
    }
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4190,
   FQN="clang::TreeTransform::TransformBuiltinType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformBuiltinTypeERNS_14TypeLocBuilderENS_14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformBuiltinTypeERNS_14TypeLocBuilderENS_14BuiltinTypeLocE")
  //</editor-fold>
  public QualType TransformBuiltinType(final TypeLocBuilder /*&*/ TLB, BuiltinTypeLoc T) {
    BuiltinTypeLoc NewT = TLB.push(BuiltinTypeLoc.class, T.getType());
    NewT.setBuiltinLoc(T.getBuiltinLoc());
    if (T.needsExtraLocalData()) {
      NewT.getWrittenBuiltinSpecs().$assign(T.getWrittenBuiltinSpecs());
    }
    return T.getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4200,
   FQN="clang::TreeTransform::TransformComplexType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformComplexTypeERNS_14TypeLocBuilderENS_14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformComplexTypeERNS_14TypeLocBuilderENS_14ComplexTypeLocE")
  //</editor-fold>
  public QualType TransformComplexType(final TypeLocBuilder /*&*/ TLB, ComplexTypeLoc T) {
    // FIXME: recurse?
    return TransformTypeSpecType(TLB, new ComplexTypeLoc(T));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4230,
   FQN="clang::TreeTransform::TransformPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformPointerTypeERNS_14TypeLocBuilderENS_14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformPointerTypeERNS_14TypeLocBuilderENS_14PointerTypeLocE")
  //</editor-fold>
  public QualType TransformPointerType(final TypeLocBuilder /*&*/ TLB, PointerTypeLoc TL) {
    QualType PointeeType = getDerived().TransformType(TLB, TL.getPointeeLoc());
    if (PointeeType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if ((PointeeType.$arrow().getAs(ObjCObjectType.class) != null)) {
      // A dependent pointer type 'T *' has is being transformed such
      // that an Objective-C class type is being replaced for 'T'. The
      // resulting pointer type is an ObjCObjectPointerType, not a
      // PointerType.
      Result.$assignMove(SemaRef.Context.getObjCObjectPointerType(new QualType(PointeeType)));
      
      ObjCObjectPointerTypeLoc NewT = TLB.push(ObjCObjectPointerTypeLoc.class, new QualType(Result));
      NewT.setStarLoc(TL.getStarLoc());
      return Result;
    }
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(PointeeType, TL.getPointeeLoc().getType())) {
      Result.$assignMove(getDerived().RebuildPointerType(new QualType(PointeeType), TL.getSigilLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // Objective-C ARC can add lifetime qualifiers to the type that we're
    // pointing to.
    TLB.TypeWasModifiedSafely(Result.$arrow().getPointeeType());
    
    PointerTypeLoc NewT = TLB.push(PointerTypeLoc.class, new QualType(Result));
    NewT.setSigilLoc(TL.getSigilLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4267,
   FQN="clang::TreeTransform::TransformBlockPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformBlockPointerTypeERNS_14TypeLocBuilderENS_19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformBlockPointerTypeERNS_14TypeLocBuilderENS_19BlockPointerTypeLocE")
  //</editor-fold>
  public QualType TransformBlockPointerType(final TypeLocBuilder /*&*/ TLB, BlockPointerTypeLoc TL) {
    QualType PointeeType = getDerived().TransformType(TLB, TL.getPointeeLoc());
    if (PointeeType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(PointeeType, TL.getPointeeLoc().getType())) {
      Result.$assignMove(getDerived().RebuildBlockPointerType(new QualType(PointeeType), 
              TL.getSigilLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    BlockPointerTypeLoc NewT = TLB.push(BlockPointerTypeLoc.class, new QualType(Result));
    NewT.setSigilLoc(TL.getSigilLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4331,
   FQN="clang::TreeTransform::TransformLValueReferenceType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformLValueReferenceTypeERNS_14TypeLocBuilderENS_22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformLValueReferenceTypeERNS_14TypeLocBuilderENS_22LValueReferenceTypeLocE")
  //</editor-fold>
  public QualType TransformLValueReferenceType(final TypeLocBuilder /*&*/ TLB, LValueReferenceTypeLoc TL) {
    return TransformReferenceType(TLB, new ReferenceTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4338,
   FQN="clang::TreeTransform::TransformRValueReferenceType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformRValueReferenceTypeERNS_14TypeLocBuilderENS_22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformRValueReferenceTypeERNS_14TypeLocBuilderENS_22RValueReferenceTypeLocE")
  //</editor-fold>
  public QualType TransformRValueReferenceType(final TypeLocBuilder /*&*/ TLB, RValueReferenceTypeLoc TL) {
    return TransformReferenceType(TLB, new ReferenceTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4345,
   FQN="clang::TreeTransform::TransformMemberPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformMemberPointerTypeERNS_14TypeLocBuilderENS_20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformMemberPointerTypeERNS_14TypeLocBuilderENS_20MemberPointerTypeLocE")
  //</editor-fold>
  public QualType TransformMemberPointerType(final TypeLocBuilder /*&*/ TLB, MemberPointerTypeLoc TL) {
    QualType PointeeType = getDerived().TransformType(TLB, TL.getPointeeLoc());
    if (PointeeType.isNull()) {
      return new QualType();
    }
    
    TypeSourceInfo /*P*/ OldClsTInfo = TL.getClassTInfo();
    TypeSourceInfo /*P*/ NewClsTInfo = null;
    if ((OldClsTInfo != null)) {
      NewClsTInfo = getDerived().TransformType(OldClsTInfo);
      if (!(NewClsTInfo != null)) {
        return new QualType();
      }
    }
    
    /*const*/ MemberPointerType /*P*/ T = TL.getTypePtr();
    QualType OldClsType = new QualType(T.__getClass(), 0);
    QualType NewClsType/*J*/= new QualType();
    if ((NewClsTInfo != null)) {
      NewClsType.$assignMove(NewClsTInfo.getType());
    } else {
      NewClsType.$assignMove(getDerived().TransformType(new QualType(OldClsType)));
      if (NewClsType.isNull()) {
        return new QualType();
      }
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(PointeeType, T.getPointeeType())
       || $noteq_QualType$C(NewClsType, OldClsType)) {
      Result.$assignMove(getDerived().RebuildMemberPointerType(new QualType(PointeeType), new QualType(NewClsType), 
              TL.getStarLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // If we had to adjust the pointee type when building a member pointer, make
    // sure to push TypeLoc info for it.
    /*const*/ MemberPointerType /*P*/ MPT = Result.$arrow().getAs(MemberPointerType.class);
    if ((MPT != null) && $noteq_QualType$C(PointeeType, MPT.getPointeeType())) {
      assert (isa_AdjustedType(MPT.getPointeeType()));
      TLB.push(AdjustedTypeLoc.class, MPT.getPointeeType());
    }
    
    MemberPointerTypeLoc NewTL = TLB.push(MemberPointerTypeLoc.class, new QualType(Result));
    NewTL.setSigilLoc(TL.getSigilLoc());
    NewTL.setClassTInfo(NewClsTInfo);
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4397,
   FQN="clang::TreeTransform::TransformConstantArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformConstantArrayTypeERNS_14TypeLocBuilderENS_20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformConstantArrayTypeERNS_14TypeLocBuilderENS_20ConstantArrayTypeLocE")
  //</editor-fold>
  public QualType TransformConstantArrayType(final TypeLocBuilder /*&*/ TLB, ConstantArrayTypeLoc TL) {
    /*const*/ ConstantArrayType /*P*/ T = TL.getTypePtr();
    QualType ElementType = getDerived().TransformType(TLB, TL.getElementLoc());
    if (ElementType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ElementType, T.getElementType())) {
      Result.$assignMove(getDerived().RebuildConstantArrayType(new QualType(ElementType), 
              T.getSizeModifier(), 
              T.getSize(), 
              T.getIndexTypeCVRQualifiers(), 
              TL.getBracketsRange()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // We might have either a ConstantArrayType or a VariableArrayType now:
    // a ConstantArrayType is allowed to have an element type which is a
    // VariableArrayType if the type is dependent.  Fortunately, all array
    // types have the same location layout.
    ArrayTypeLoc NewTL = TLB.push(ArrayTypeLoc.class, new QualType(Result));
    NewTL.setLBracketLoc(TL.getLBracketLoc());
    NewTL.setRBracketLoc(TL.getRBracketLoc());
    
    Expr /*P*/ Size = TL.getSizeExpr();
    if ((Size != null)) {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
            Sema.ExpressionEvaluationContext.ConstantEvaluated);
        //JAVA/IDE: cast to (ActionResultTTrue<Expr>) below is just for the IDE; otherwse it marks an error
        Size = ((ActionResultTTrue<Expr>) getDerived().TransformExpr(Size)).getAs(Expr.class);
        Size = SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Size)).get();
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    NewTL.setSizeExpr(Size);
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4438,
   FQN="clang::TreeTransform::TransformIncompleteArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformIncompleteArrayTypeERNS_14TypeLocBuilderENS_22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformIncompleteArrayTypeERNS_14TypeLocBuilderENS_22IncompleteArrayTypeLocE")
  //</editor-fold>
  public QualType TransformIncompleteArrayType(final TypeLocBuilder /*&*/ TLB, IncompleteArrayTypeLoc TL) {
    /*const*/ IncompleteArrayType /*P*/ T = TL.getTypePtr();
    QualType ElementType = getDerived().TransformType(TLB, TL.getElementLoc());
    if (ElementType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ElementType, T.getElementType())) {
      Result.$assignMove(getDerived().RebuildIncompleteArrayType(new QualType(ElementType), 
              T.getSizeModifier(), 
              T.getIndexTypeCVRQualifiers(), 
              TL.getBracketsRange()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    IncompleteArrayTypeLoc NewTL = TLB.push(IncompleteArrayTypeLoc.class, new QualType(Result));
    NewTL.setLBracketLoc(TL.getLBracketLoc());
    NewTL.setRBracketLoc(TL.getRBracketLoc());
    NewTL.setSizeExpr((Expr /*P*/ )null);
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4466,
   FQN="clang::TreeTransform::TransformVariableArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformVariableArrayTypeERNS_14TypeLocBuilderENS_20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformVariableArrayTypeERNS_14TypeLocBuilderENS_20VariableArrayTypeLocE")
  //</editor-fold>
  public QualType TransformVariableArrayType(final TypeLocBuilder /*&*/ TLB, VariableArrayTypeLoc TL) {
    /*const*/ VariableArrayType /*P*/ T = TL.getTypePtr();
    QualType ElementType = getDerived().TransformType(TLB, TL.getElementLoc());
    if (ElementType.isNull()) {
      return new QualType();
    }
    
    ActionResultTTrue<Expr /*P*/ > SizeResult = getDerived().TransformExpr(T.getSizeExpr());
    if (SizeResult.isInvalid()) {
      return new QualType();
    }
    
    Expr /*P*/ Size = SizeResult.get();
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ElementType, T.getElementType())
       || Size != T.getSizeExpr()) {
      Result.$assignMove(getDerived().RebuildVariableArrayType(new QualType(ElementType), 
              T.getSizeModifier(), 
              Size, 
              T.getIndexTypeCVRQualifiers(), 
              TL.getBracketsRange()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // We might have constant size array now, but fortunately it has the same
    // location layout.
    ArrayTypeLoc NewTL = TLB.push(ArrayTypeLoc.class, new QualType(Result));
    NewTL.setLBracketLoc(TL.getLBracketLoc());
    NewTL.setRBracketLoc(TL.getRBracketLoc());
    NewTL.setSizeExpr(Size);
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4505,
   FQN="clang::TreeTransform::TransformDependentSizedArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformDependentSizedArrayTypeERNS_14TypeLocBuilderENS_26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformDependentSizedArrayTypeERNS_14TypeLocBuilderENS_26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public QualType TransformDependentSizedArrayType(final TypeLocBuilder /*&*/ TLB, DependentSizedArrayTypeLoc TL) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      /*const*/ DependentSizedArrayType /*P*/ T = TL.getTypePtr();
      QualType ElementType = getDerived().TransformType(TLB, TL.getElementLoc());
      if (ElementType.isNull()) {
        return new QualType();
      }
      
      // Array bounds are constant expressions.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
          Sema.ExpressionEvaluationContext.ConstantEvaluated);
      
      // Prefer the expression from the TypeLoc;  the other may have been uniqued.
      Expr /*P*/ origSize = TL.getSizeExpr();
      if (!(origSize != null)) {
        origSize = T.getSizeExpr();
      }
      
      ActionResultTTrue<Expr /*P*/ > sizeResult = getDerived().TransformExpr(origSize);
      sizeResult.$assignMove(SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(sizeResult)));
      if (sizeResult.isInvalid()) {
        return new QualType();
      }
      
      Expr /*P*/ size = sizeResult.get();
      
      QualType Result = TL.getType();
      if (getDerived().AlwaysRebuild()
         || $noteq_QualType$C(ElementType, T.getElementType())
         || size != origSize) {
        Result.$assignMove(getDerived().RebuildDependentSizedArrayType(new QualType(ElementType), 
                T.getSizeModifier(), 
                size, 
                T.getIndexTypeCVRQualifiers(), 
                TL.getBracketsRange()));
        if (Result.isNull()) {
          return new QualType();
        }
      }
      
      // We might have any sort of array type now, but fortunately they
      // all have the same location layout.
      ArrayTypeLoc NewTL = TLB.push(ArrayTypeLoc.class, new QualType(Result));
      NewTL.setLBracketLoc(TL.getLBracketLoc());
      NewTL.setRBracketLoc(TL.getRBracketLoc());
      NewTL.setSizeExpr(size);
      
      return Result;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4553,
   FQN="clang::TreeTransform::TransformDependentSizedExtVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformDependentSizedExtVectorTypeERNS_14TypeLocBuilderENS_30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformDependentSizedExtVectorTypeERNS_14TypeLocBuilderENS_30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public QualType TransformDependentSizedExtVectorType(final TypeLocBuilder /*&*/ TLB, DependentSizedExtVectorTypeLoc TL) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      /*const*/ DependentSizedExtVectorType /*P*/ T = TL.getTypePtr();
      
      // FIXME: ext vector locs should be nested
      QualType ElementType = getDerived().TransformType(T.getElementType());
      if (ElementType.isNull()) {
        return new QualType();
      }
      
      // Vector sizes are constant expressions.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
          Sema.ExpressionEvaluationContext.ConstantEvaluated);
      
      ActionResultTTrue<Expr /*P*/ > Size = getDerived().TransformExpr(T.getSizeExpr());
      Size.$assignMove(SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(Size)));
      if (Size.isInvalid()) {
        return new QualType();
      }
      
      QualType Result = TL.getType();
      if (getDerived().AlwaysRebuild()
         || $noteq_QualType$C(ElementType, T.getElementType())
         || Size.get() != T.getSizeExpr()) {
        Result.$assignMove(getDerived().RebuildDependentSizedExtVectorType(new QualType(ElementType), 
                Size.get(), 
                T.getAttributeLoc()));
        if (Result.isNull()) {
          return new QualType();
        }
      }
      
      // Result might be dependent or not.
      if (isa_DependentSizedExtVectorType(Result)) {
        DependentSizedExtVectorTypeLoc NewTL = TLB.push(DependentSizedExtVectorTypeLoc.class, new QualType(Result));
        NewTL.setNameLoc(TL.getNameLoc());
      } else {
        ExtVectorTypeLoc NewTL = TLB.push(ExtVectorTypeLoc.class, new QualType(Result));
        NewTL.setNameLoc(TL.getNameLoc());
      }
      
      return Result;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4597,
   FQN="clang::TreeTransform::TransformVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformVectorTypeERNS_14TypeLocBuilderENS_13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformVectorTypeERNS_14TypeLocBuilderENS_13VectorTypeLocE")
  //</editor-fold>
  public QualType TransformVectorType(final TypeLocBuilder /*&*/ TLB, VectorTypeLoc TL) {
    /*const*/ VectorType /*P*/ T = TL.getTypePtr();
    QualType ElementType = getDerived().TransformType(T.getElementType());
    if (ElementType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ElementType, T.getElementType())) {
      Result.$assignMove(getDerived().RebuildVectorType(new QualType(ElementType), T.getNumElements(), 
              T.getVectorKind()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    VectorTypeLoc NewTL = TLB.push(VectorTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4620,
   FQN="clang::TreeTransform::TransformExtVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformExtVectorTypeERNS_14TypeLocBuilderENS_16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformExtVectorTypeERNS_14TypeLocBuilderENS_16ExtVectorTypeLocE")
  //</editor-fold>
  public QualType TransformExtVectorType(final TypeLocBuilder /*&*/ TLB, ExtVectorTypeLoc TL) {
    /*const*/ VectorType /*P*/ T = TL.getTypePtr();
    QualType ElementType = getDerived().TransformType(T.getElementType());
    if (ElementType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ElementType, T.getElementType())) {
      Result.$assignMove(getDerived().RebuildExtVectorType(new QualType(ElementType), 
              T.getNumElements(), 
              /*FIXME*/ new SourceLocation()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    ExtVectorTypeLoc NewTL = TLB.push(ExtVectorTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4917,
   FQN="clang::TreeTransform::TransformFunctionProtoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionProtoTypeERNS_14TypeLocBuilderENS_20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionProtoTypeERNS_14TypeLocBuilderENS_20FunctionProtoTypeLocE")
  //</editor-fold>
  public QualType TransformFunctionProtoType(final TypeLocBuilder /*&*/ TLB, FunctionProtoTypeLoc TL) {
    SmallVector<QualType> ExceptionStorage/*J*/= new SmallVector<QualType>(4, new QualType());
    TreeTransform<Derived> /*P*/ This = this; // Work around gcc.gnu.org/PR56135.
    // For some reasons Java does not compile without the cast (TwoTypes2Bool<ExceptionSpecInfo, bool$ref>) below
    return getDerived().TransformFunctionProtoType(TLB, new FunctionProtoTypeLoc(TL), (CXXRecordDecl /*P*/ )null, 0, 
        /*[&, &This, &TL, &ExceptionStorage]*/ (TwoTypes2Bool<ExceptionSpecInfo, bool$ref>) (final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, final bool$ref/*bool &*/ Changed) -> {
              return This.TransformExceptionSpec(TL.getBeginLoc(), ESI, 
                  ExceptionStorage, Changed);
            });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5125,
   FQN="clang::TreeTransform::TransformFunctionNoProtoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformFunctionNoProtoTypeERNS_14TypeLocBuilderENS_22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformFunctionNoProtoTypeERNS_14TypeLocBuilderENS_22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public QualType TransformFunctionNoProtoType(final TypeLocBuilder /*&*/ TLB, FunctionNoProtoTypeLoc TL) {
    /*const*/ FunctionNoProtoType /*P*/ T = TL.getTypePtr();
    QualType ResultType = getDerived().TransformType(TLB, TL.getReturnLoc());
    if (ResultType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || $noteq_QualType$C(ResultType, T.getReturnType())) {
      Result.$assignMove(getDerived().RebuildFunctionNoProtoType(new QualType(ResultType)));
    }
    
    FunctionNoProtoTypeLoc NewTL = TLB.push(FunctionNoProtoTypeLoc.class, new QualType(Result));
    NewTL.setLocalRangeBegin(TL.getLocalRangeBegin());
    NewTL.setLParenLoc(TL.getLParenLoc());
    NewTL.setRParenLoc(TL.getRParenLoc());
    NewTL.setLocalRangeEnd(TL.getLocalRangeEnd());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5146,
   FQN="clang::TreeTransform::TransformUnresolvedUsingType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformUnresolvedUsingTypeERNS_14TypeLocBuilderENS_22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformUnresolvedUsingTypeERNS_14TypeLocBuilderENS_22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public QualType TransformUnresolvedUsingType(final TypeLocBuilder /*&*/ TLB, UnresolvedUsingTypeLoc TL) {
    /*const*/ UnresolvedUsingType /*P*/ T = TL.getTypePtr();
    Decl /*P*/ D = getDerived().TransformDecl(TL.getNameLoc(), T.getDecl());
    if (!(D != null)) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || D != T.getDecl()) {
      Result.$assignMove(getDerived().RebuildUnresolvedUsingType(D));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // We might get an arbitrary type spec type back.  We should at
    // least always get a type spec type, though.
    TypeSpecTypeLoc NewTL = TLB.pushTypeSpec(new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5774,
   FQN="clang::TreeTransform::TransformParenType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformParenTypeERNS_14TypeLocBuilderENS_12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformParenTypeERNS_14TypeLocBuilderENS_12ParenTypeLocE")
  //</editor-fold>
  public QualType TransformParenType(final TypeLocBuilder /*&*/ TLB, ParenTypeLoc TL) {
    QualType Inner = getDerived().TransformType(TLB, TL.getInnerLoc());
    if (Inner.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(Inner, TL.getInnerLoc().getType())) {
      Result.$assignMove(getDerived().RebuildParenType(new QualType(Inner)));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    ParenTypeLoc NewTL = TLB.push(ParenTypeLoc.class, new QualType(Result));
    NewTL.setLParenLoc(TL.getLParenLoc());
    NewTL.setRParenLoc(TL.getRParenLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5170,
   FQN="clang::TreeTransform::TransformTypedefType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformTypedefTypeERNS_14TypeLocBuilderENS_14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformTypedefTypeERNS_14TypeLocBuilderENS_14TypedefTypeLocE")
  //</editor-fold>
  public QualType TransformTypedefType(final TypeLocBuilder /*&*/ TLB, TypedefTypeLoc TL) {
    /*const*/ TypedefType /*P*/ T = TL.getTypePtr();
    TypedefNameDecl /*P*/ Typedef = cast_or_null_TypedefNameDecl(getDerived().TransformDecl(TL.getNameLoc(), 
    T.getDecl()));
    if (!(Typedef != null)) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || Typedef != T.getDecl()) {
      Result.$assignMove(getDerived().RebuildTypedefType(Typedef));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    TypedefTypeLoc NewTL = TLB.push(TypedefTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4207,
   FQN="clang::TreeTransform::TransformAdjustedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformAdjustedTypeERNS_14TypeLocBuilderENS_15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformAdjustedTypeERNS_14TypeLocBuilderENS_15AdjustedTypeLocE")
  //</editor-fold>
  public QualType TransformAdjustedType(final TypeLocBuilder /*&*/ TLB, AdjustedTypeLoc TL) {
    // Adjustments applied during transformation are handled elsewhere.
    return getDerived().TransformType(TLB, TL.getOriginalLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4214,
   FQN="clang::TreeTransform::TransformDecayedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDecayedTypeERNS_14TypeLocBuilderENS_14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDecayedTypeERNS_14TypeLocBuilderENS_14DecayedTypeLocE")
  //</editor-fold>
  public QualType TransformDecayedType(final TypeLocBuilder /*&*/ TLB, DecayedTypeLoc TL) {
    QualType OriginalType = getDerived().TransformType(TLB, TL.getOriginalLoc());
    if (OriginalType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(OriginalType, TL.getOriginalLoc().getType())) {
      Result.$assignMove(SemaRef.Context.getDecayedType(new QualType(OriginalType)));
    }
    TLB.push(DecayedTypeLoc.class, new QualType(Result));
    // Nothing to set for DecayedTypeLoc.
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5194,
   FQN="clang::TreeTransform::TransformTypeOfExprType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformTypeOfExprTypeERNS_14TypeLocBuilderENS_17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformTypeOfExprTypeERNS_14TypeLocBuilderENS_17TypeOfExprTypeLocE")
  //</editor-fold>
  public QualType TransformTypeOfExprType(final TypeLocBuilder /*&*/ TLB, TypeOfExprTypeLoc TL) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      // typeof expressions are not potentially evaluated contexts
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      
      ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(TL.getUnderlyingExpr());
      if (E.isInvalid()) {
        return new QualType();
      }
      
      E.$assignMove(SemaRef.HandleExprEvaluationContextForTypeof(E.get()));
      if (E.isInvalid()) {
        return new QualType();
      }
      
      QualType Result = TL.getType();
      if (getDerived().AlwaysRebuild()
         || E.get() != TL.getUnderlyingExpr()) {
        Result.$assignMove(getDerived().RebuildTypeOfExprType(E.get(), TL.getTypeofLoc()));
        if (Result.isNull()) {
          return new QualType();
        }
      } else {
        E.get();
      }
      
      TypeOfExprTypeLoc NewTL = TLB.push(TypeOfExprTypeLoc.class, new QualType(Result));
      NewTL.setTypeofLoc(TL.getTypeofLoc());
      NewTL.setLParenLoc(TL.getLParenLoc());
      NewTL.setRParenLoc(TL.getRParenLoc());
      
      return Result;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5226,
   FQN="clang::TreeTransform::TransformTypeOfType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformTypeOfTypeERNS_14TypeLocBuilderENS_13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformTypeOfTypeERNS_14TypeLocBuilderENS_13TypeOfTypeLocE")
  //</editor-fold>
  public QualType TransformTypeOfType(final TypeLocBuilder /*&*/ TLB, TypeOfTypeLoc TL) {
    TypeSourceInfo /*P*/ Old_Under_TI = TL.getUnderlyingTInfo();
    TypeSourceInfo /*P*/ New_Under_TI = getDerived().TransformType(Old_Under_TI);
    if (!(New_Under_TI != null)) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || New_Under_TI != Old_Under_TI) {
      Result.$assignMove(getDerived().RebuildTypeOfType(New_Under_TI.getType()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    TypeOfTypeLoc NewTL = TLB.push(TypeOfTypeLoc.class, new QualType(Result));
    NewTL.setTypeofLoc(TL.getTypeofLoc());
    NewTL.setLParenLoc(TL.getLParenLoc());
    NewTL.setRParenLoc(TL.getRParenLoc());
    NewTL.setUnderlyingTInfo(New_Under_TI);
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5250,
   FQN="clang::TreeTransform::TransformDecltypeType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformDecltypeTypeERNS_14TypeLocBuilderENS_15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformDecltypeTypeERNS_14TypeLocBuilderENS_15DecltypeTypeLocE")
  //</editor-fold>
  public QualType TransformDecltypeType(final TypeLocBuilder /*&*/ TLB, DecltypeTypeLoc TL) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      /*const*/ DecltypeType /*P*/ T = TL.getTypePtr();
      
      // decltype expressions are not potentially evaluated contexts
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated, 
          (Decl /*P*/ )null, /*IsDecltype=*/ true);
      
      ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(T.getUnderlyingExpr());
      if (E.isInvalid()) {
        return new QualType();
      }
      
      E.$assignMove(getSema().ActOnDecltypeExpression(E.get()));
      if (E.isInvalid()) {
        return new QualType();
      }
      
      QualType Result = TL.getType();
      if (getDerived().AlwaysRebuild()
         || E.get() != T.getUnderlyingExpr()) {
        Result.$assignMove(getDerived().RebuildDecltypeType(E.get(), TL.getNameLoc()));
        if (Result.isNull()) {
          return new QualType();
        }
      } else {
        E.get();
      }
      
      DecltypeTypeLoc NewTL = TLB.push(DecltypeTypeLoc.class, new QualType(Result));
      NewTL.setNameLoc(TL.getNameLoc());
      
      return Result;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5282,
   FQN="clang::TreeTransform::TransformUnaryTransformType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformUnaryTransformTypeERNS_14TypeLocBuilderENS_21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformUnaryTransformTypeERNS_14TypeLocBuilderENS_21UnaryTransformTypeLocE")
  //</editor-fold>
  public QualType TransformUnaryTransformType(final TypeLocBuilder /*&*/ TLB, UnaryTransformTypeLoc TL) {
    QualType Result = TL.getType();
    if (Result.$arrow().isDependentType()) {
      /*const*/ UnaryTransformType /*P*/ T = TL.getTypePtr();
      QualType NewBase = getDerived().TransformType(TL.getUnderlyingTInfo()).getType();
      Result.$assignMove(getDerived().RebuildUnaryTransformType(new QualType(NewBase), 
              T.getUTTKind(), 
              TL.getKWLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    UnaryTransformTypeLoc NewTL = TLB.push(UnaryTransformTypeLoc.class, new QualType(Result));
    NewTL.setKWLoc(TL.getKWLoc());
    NewTL.setParensRange(TL.getParensRange());
    NewTL.setUnderlyingTInfo(TL.getUnderlyingTInfo());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5331,
   FQN="clang::TreeTransform::TransformRecordType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformRecordTypeERNS_14TypeLocBuilderENS_13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformRecordTypeERNS_14TypeLocBuilderENS_13RecordTypeLocE")
  //</editor-fold>
  public QualType TransformRecordType(final TypeLocBuilder /*&*/ TLB, RecordTypeLoc TL) {
    /*const*/ RecordType /*P*/ T = TL.getTypePtr();
    RecordDecl /*P*/ Record = cast_or_null_RecordDecl(getDerived().TransformDecl(TL.getNameLoc(), 
    T.getDecl()));
    if (!(Record != null)) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || Record != T.getDecl()) {
      Result.$assignMove(getDerived().RebuildRecordType(Record));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    RecordTypeLoc NewTL = TLB.push(RecordTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5355,
   FQN="clang::TreeTransform::TransformEnumType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformEnumTypeERNS_14TypeLocBuilderENS_11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformEnumTypeERNS_14TypeLocBuilderENS_11EnumTypeLocE")
  //</editor-fold>
  public QualType TransformEnumType(final TypeLocBuilder /*&*/ TLB, EnumTypeLoc TL) {
    /*const*/ EnumType /*P*/ T = TL.getTypePtr();
    EnumDecl /*P*/ Enum = cast_or_null_EnumDecl(getDerived().TransformDecl(TL.getNameLoc(), 
    T.getDecl()));
    if (!(Enum != null)) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || Enum != T.getDecl()) {
      Result.$assignMove(getDerived().RebuildEnumType(Enum));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    EnumTypeLoc NewTL = TLB.push(EnumTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5673,
   FQN="clang::TreeTransform::TransformElaboratedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformElaboratedTypeERNS_14TypeLocBuilderENS_17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformElaboratedTypeERNS_14TypeLocBuilderENS_17ElaboratedTypeLocE")
  //</editor-fold>
  public QualType TransformElaboratedType(final TypeLocBuilder /*&*/ TLB, ElaboratedTypeLoc TL) {
    /*const*/ ElaboratedType /*P*/ T = TL.getTypePtr();
    
    NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
    // NOTE: the qualifier in an ElaboratedType is optional.
    if (TL.getQualifierLoc().$bool()) {
      QualifierLoc.$assignMove(
          getDerived().TransformNestedNameSpecifierLoc(TL.getQualifierLoc())
      );
      if (!QualifierLoc.$bool()) {
        return new QualType();
      }
    }
    
    QualType NamedT = getDerived().TransformType(TLB, TL.getNamedTypeLoc());
    if (NamedT.isNull()) {
      return new QualType();
    }
    
    // C++0x [dcl.type.elab]p2:
    //   If the identifier resolves to a typedef-name or the simple-template-id
    //   resolves to an alias template specialization, the
    //   elaborated-type-specifier is ill-formed.
    if (T.getKeyword() != ElaboratedTypeKeyword.ETK_None && T.getKeyword() != ElaboratedTypeKeyword.ETK_Typename) {
      {
        /*const*/ TemplateSpecializationType /*P*/ TST = NamedT.$arrow().<TemplateSpecializationType>getAs$TemplateSpecializationType();
        if ((TST != null)) {
          TemplateName Template = TST.getTemplateName();
          {
            TypeAliasTemplateDecl /*P*/ TAT = dyn_cast_or_null_TypeAliasTemplateDecl(Template.getAsTemplateDecl());
            if ((TAT != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TL.getNamedTypeLoc().getBeginLoc(), 
                        diag.err_tag_reference_non_tag)), 4));
                $c$.clean($c$.track(SemaRef.Diag(TAT.getLocation(), diag.note_declared_at)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, TL.getQualifierLoc())
       || $noteq_QualType$C(NamedT, T.getNamedType())) {
      Result.$assignMove(getDerived().RebuildElaboratedType(TL.getElaboratedKeywordLoc(), 
              T.getKeyword(), 
              new NestedNameSpecifierLoc(QualifierLoc), new QualType(NamedT)));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    ElaboratedTypeLoc NewTL = TLB.push(ElaboratedTypeLoc.class, new QualType(Result));
    NewTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
    NewTL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5726,
   FQN="clang::TreeTransform::TransformAttributedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformAttributedTypeERNS_14TypeLocBuilderENS_17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformAttributedTypeERNS_14TypeLocBuilderENS_17AttributedTypeLocE")
  //</editor-fold>
  public QualType TransformAttributedType(final TypeLocBuilder /*&*/ TLB, AttributedTypeLoc TL) {
    /*const*/ AttributedType /*P*/ oldType = TL.getTypePtr();
    QualType modifiedType = getDerived().TransformType(TLB, TL.getModifiedLoc());
    if (modifiedType.isNull()) {
      return new QualType();
    }
    
    QualType result = TL.getType();
    
    // FIXME: dependent operand expressions?
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(modifiedType, oldType.getModifiedType())) {
      // TODO: this is really lame; we should really be rebuilding the
      // equivalent type from first principles.
      QualType equivalentType = getDerived().TransformType(oldType.getEquivalentType());
      if (equivalentType.isNull()) {
        return new QualType();
      }
      {
        
        // Check whether we can add nullability; it is only represented as
        // type sugar, and therefore cannot be diagnosed in any other way.
        Optional<NullabilityKind> nullability = oldType.getImmediateNullability();
        if (nullability.$bool()) {
          if (!modifiedType.$arrow().canHaveNullability()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TL.getAttrNameLoc(), diag.err_nullability_nonpointer)), 
                      new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability.$star(), false)), modifiedType));
              return new QualType();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      result.$assignMove(SemaRef.Context.getAttributedType(oldType.getAttrKind(), 
              new QualType(modifiedType), 
              new QualType(equivalentType)));
    }
    
    AttributedTypeLoc newTL = TLB.push(AttributedTypeLoc.class, new QualType(result));
    newTL.setAttrNameLoc(TL.getAttrNameLoc());
    if (TL.hasAttrOperand()) {
      newTL.setAttrOperandParensRange(TL.getAttrOperandParensRange());
    }
    if (TL.hasAttrExprOperand()) {
      newTL.setAttrExprOperand(TL.getAttrExprOperand());
    } else if (TL.hasAttrEnumOperand()) {
      newTL.setAttrEnumOperandLoc(TL.getAttrEnumOperandLoc());
    }
    
    return result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5391,
   FQN="clang::TreeTransform::TransformTemplateTypeParmType", NM="_ZN5clang13TreeTransform29TransformTemplateTypeParmTypeERNS_14TypeLocBuilderENS_23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang13TreeTransform29TransformTemplateTypeParmTypeERNS_14TypeLocBuilderENS_23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public QualType TransformTemplateTypeParmType(final TypeLocBuilder /*&*/ TLB, 
                               TemplateTypeParmTypeLoc TL) {
    return TransformTypeSpecType(TLB, new TemplateTypeParmTypeLoc(TL));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5399,
   FQN="clang::TreeTransform::TransformSubstTemplateTypeParmType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformSubstTemplateTypeParmTypeERNS_14TypeLocBuilderENS_28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformSubstTemplateTypeParmTypeERNS_14TypeLocBuilderENS_28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public QualType TransformSubstTemplateTypeParmType(final TypeLocBuilder /*&*/ TLB, SubstTemplateTypeParmTypeLoc TL) {
    TemporaryBase Rebase = null;
    try {
      /*const*/ SubstTemplateTypeParmType /*P*/ T = TL.getTypePtr();
      
      // Substitute into the replacement type, which itself might involve something
      // that needs to be transformed. This only tends to occur with default
      // template arguments of template template parameters.
      Rebase/*J*/= /*ParenList*/new TemporaryBase(Native.$star(this), TL.getNameLoc(), new DeclarationName());
      QualType Replacement = getDerived().TransformType(T.getReplacementType());
      if (Replacement.isNull()) {
        return new QualType();
      }
      
      // Always canonicalize the replacement type.
      Replacement.$assignMove(SemaRef.Context.getCanonicalType(new QualType(Replacement)).$QualType());
      QualType Result = SemaRef.Context.getSubstTemplateTypeParmType(T.getReplacedParameter(), 
          new QualType(Replacement));
      
      // Propagate type-source information.
      SubstTemplateTypeParmTypeLoc NewTL = TLB.push(SubstTemplateTypeParmTypeLoc.class, new QualType(Result));
      NewTL.setNameLoc(TL.getNameLoc());
      return Result;
    } finally {
      if (Rebase != null) { Rebase.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="clang::TreeTransform::TransformSubstTemplateTypeParmPackType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformSubstTemplateTypeParmPackTypeERNS_14TypeLocBuilderENS_32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformSubstTemplateTypeParmPackTypeERNS_14TypeLocBuilderENS_32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public QualType TransformSubstTemplateTypeParmPackType(final TypeLocBuilder /*&*/ TLB, SubstTemplateTypeParmPackTypeLoc T) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5434,
   FQN="clang::TreeTransform::TransformTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformTemplateSpecializationTypeERNS_14TypeLocBuilderENS_29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformTemplateSpecializationTypeERNS_14TypeLocBuilderENS_29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public QualType TransformTemplateSpecializationType(final TypeLocBuilder /*&*/ TLB, TemplateSpecializationTypeLoc TL) {
    CXXScopeSpec SS = null;
    try {
      /*const*/ TemplateSpecializationType /*P*/ T = TL.getTypePtr();
      
      // The nested-name-specifier never matters in a TemplateSpecializationType,
      // because we can't have a dependent nested-name-specifier anyway.
      SS/*J*/= new CXXScopeSpec();
      TemplateName Template = getDerived().TransformTemplateName(SS, T.getTemplateName(),
          TL.getTemplateNameLoc());
      if (Template.isNull()) {
        return new QualType();
      }
      
      return getDerived().TransformTemplateSpecializationType(TLB, new TemplateSpecializationTypeLoc(TL), new TemplateName(Template));
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5305,
   FQN="clang::TreeTransform::TransformAutoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformAutoTypeERNS_14TypeLocBuilderENS_11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformAutoTypeERNS_14TypeLocBuilderENS_11AutoTypeLocE")
  //</editor-fold>
  public QualType TransformAutoType(final TypeLocBuilder /*&*/ TLB, AutoTypeLoc TL) {
    /*const*/ AutoType /*P*/ T = TL.getTypePtr();
    QualType OldDeduced = T.getDeducedType();
    QualType NewDeduced/*J*/= new QualType();
    if (!OldDeduced.isNull()) {
      NewDeduced.$assignMove(getDerived().TransformType(new QualType(OldDeduced)));
      if (NewDeduced.isNull()) {
        return new QualType();
      }
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || $noteq_QualType$C(NewDeduced, OldDeduced)
       || T.isDependentType()) {
      Result.$assignMove(getDerived().RebuildAutoType(new QualType(NewDeduced), T.getKeyword()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    AutoTypeLoc NewTL = TLB.push(AutoTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5379,
   FQN="clang::TreeTransform::TransformInjectedClassNameType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformInjectedClassNameTypeERNS_14TypeLocBuilderENS_24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformInjectedClassNameTypeERNS_14TypeLocBuilderENS_24InjectedClassNameTypeLocE")
  //</editor-fold>
  public QualType TransformInjectedClassNameType(final TypeLocBuilder /*&*/ TLB, InjectedClassNameTypeLoc TL) {
    Decl /*P*/ D = getDerived().TransformDecl(TL.getNameLoc(), 
        TL.getTypePtr().getDecl());
    if (!(D != null)) {
      return new QualType();
    }
    
    QualType T = SemaRef.Context.getTypeDeclType(cast_TypeDecl(D));
    TLB.pushTypeSpec(new QualType(T)).setNameLoc(TL.getNameLoc());
    return T;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5796,
   FQN="clang::TreeTransform::TransformDependentNameType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformDependentNameTypeERNS_14TypeLocBuilderENS_20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformDependentNameTypeERNS_14TypeLocBuilderENS_20DependentNameTypeLocE")
  //</editor-fold>
  public QualType TransformDependentNameType(final TypeLocBuilder /*&*/ TLB, DependentNameTypeLoc TL) {
    /*const*/ DependentNameType /*P*/ T = TL.getTypePtr();
    
    NestedNameSpecifierLoc QualifierLoc = getDerived().TransformNestedNameSpecifierLoc(TL.getQualifierLoc());
    if (!QualifierLoc.$bool()) {
      return new QualType();
    }
    
    QualType Result = getDerived().RebuildDependentNameType(T.getKeyword(), 
        TL.getElaboratedKeywordLoc(), 
        new NestedNameSpecifierLoc(QualifierLoc), 
        T.getIdentifier(), 
        TL.getNameLoc());
    if (Result.isNull()) {
      return new QualType();
    }
    {
      
      /*const*/ ElaboratedType /*P*/ ElabT = Result.$arrow().getAs(ElaboratedType.class);
      if ((ElabT != null)) {
        QualType NamedT = ElabT.getNamedType();
        TLB.pushTypeSpec(new QualType(NamedT)).setNameLoc(TL.getNameLoc());
        
        ElaboratedTypeLoc NewTL = TLB.push(ElaboratedTypeLoc.class, new QualType(Result));
        NewTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
        NewTL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
      } else {
        DependentNameTypeLoc NewTL = TLB.push(DependentNameTypeLoc.class, new QualType(Result));
        NewTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
        NewTL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
        NewTL.setNameLoc(TL.getNameLoc());
      }
    }
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5831,
   FQN="clang::TreeTransform::TransformDependentTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public QualType TransformDependentTemplateSpecializationType(final TypeLocBuilder /*&*/ TLB, DependentTemplateSpecializationTypeLoc TL) {
    NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
    if (TL.getQualifierLoc().$bool()) {
      QualifierLoc.$assignMove(
          getDerived().TransformNestedNameSpecifierLoc(TL.getQualifierLoc())
      );
      if (!QualifierLoc.$bool()) {
        return new QualType();
      }
    }
    
    return getDerived().
        TransformDependentTemplateSpecializationType(TLB, new DependentTemplateSpecializationTypeLoc(TL), new NestedNameSpecifierLoc(QualifierLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5915,
   FQN="clang::TreeTransform::TransformPackExpansionType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformPackExpansionTypeERNS_14TypeLocBuilderENS_20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformPackExpansionTypeERNS_14TypeLocBuilderENS_20PackExpansionTypeLocE")
  //</editor-fold>
  public QualType TransformPackExpansionType(final TypeLocBuilder /*&*/ TLB, PackExpansionTypeLoc TL) {
    QualType Pattern = getDerived().TransformType(TLB, TL.getPatternLoc());
    if (Pattern.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(Pattern, TL.getPatternLoc().getType())) {
      Result.$assignMove(getDerived().RebuildPackExpansionType(new QualType(Pattern), 
              TL.getPatternLoc().getSourceRange(), 
              TL.getEllipsisLoc(), 
              TL.getTypePtr().getNumExpansions()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    PackExpansionTypeLoc NewT = TLB.push(PackExpansionTypeLoc.class, new QualType(Result));
    NewT.setEllipsisLoc(TL.getEllipsisLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5948,
   FQN="clang::TreeTransform::TransformObjCObjectType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformObjCObjectTypeERNS_14TypeLocBuilderENS_17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformObjCObjectTypeERNS_14TypeLocBuilderENS_17ObjCObjectTypeLocE")
  //</editor-fold>
  public QualType TransformObjCObjectType(final TypeLocBuilder /*&*/ TLB, ObjCObjectTypeLoc TL) {
    // Transform base type.
    QualType BaseType = getDerived().TransformType(TLB, TL.getBaseLoc());
    if (BaseType.isNull()) {
      return new QualType();
    }
    
    boolean AnyChanged = $noteq_QualType$C(BaseType, TL.getBaseLoc().getType());
    
    // Transform type arguments.
    SmallVector<TypeSourceInfo /*P*/ > NewTypeArgInfos/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
    for (/*uint*/int i = 0, n = TL.getNumTypeArgs(); i != n; ++i) {
      TypeLocBuilder TypeArgBuilder = null;
      try {
        TypeSourceInfo /*P*/ TypeArgInfo = TL.getTypeArgTInfo(i);
        TypeLoc TypeArgLoc = TypeArgInfo.getTypeLoc();
        QualType TypeArg = TypeArgInfo.getType();
        {
          PackExpansionTypeLoc PackExpansionLoc = TypeArgLoc.getAs(PackExpansionTypeLoc.class);
          if (PackExpansionLoc.$bool()) {
            AnyChanged = true;
            
            // We have a pack expansion. Instantiate it.
            /*const*/ PackExpansionType /*P*/ PackExpansion = PackExpansionLoc.getType().$arrow().castAs(PackExpansionType.class);
            SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
            SemaRef.collectUnexpandedParameterPacks_QualType(PackExpansion.getPattern(), 
                Unexpanded);
            assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
            
            // Determine whether the set of unexpanded parameter packs can
            // and should be expanded.
            TypeLoc PatternLoc = PackExpansionLoc.getPatternLoc();
            bool$ref Expand = create_bool$ref(false);
            bool$ref RetainExpansion = create_bool$ref(false);
            OptionalUInt NumExpansions = PackExpansion.getNumExpansions();
            if (getDerived().TryExpandParameterPacks(PackExpansionLoc.getEllipsisLoc(), PatternLoc.getSourceRange(), 
                new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), Expand, RetainExpansion, NumExpansions)) {
              return new QualType();
            }
            if (!Expand.$deref()) {
              Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
              TypeLocBuilder TypeArgBuilder$1 = null;
              try {
                // We can't expand this pack expansion into separate arguments yet;
                // just substitute into the pattern and create a new pack expansion
                // type.
                SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
                
                TypeArgBuilder$1/*J*/= new TypeLocBuilder();
                TypeArgBuilder$1.reserve(PatternLoc.getFullDataSize());
                QualType NewPatternType = getDerived().TransformType(TypeArgBuilder$1, 
                    new TypeLoc(PatternLoc));
                if (NewPatternType.isNull()) {
                  return new QualType();
                }
                
                QualType NewExpansionType = SemaRef.Context.getPackExpansionType(new QualType(NewPatternType), new OptionalUInt(NumExpansions));
                PackExpansionTypeLoc NewExpansionLoc = TLB.push(PackExpansionTypeLoc.class, new QualType(NewExpansionType));
                NewExpansionLoc.setEllipsisLoc(PackExpansionLoc.getEllipsisLoc());
                NewTypeArgInfos.push_back(TypeArgBuilder$1.getTypeSourceInfo(SemaRef.Context, new QualType(NewExpansionType)));
                continue;
              } finally {
                if (TypeArgBuilder$1 != null) { TypeArgBuilder$1.$destroy(); }
                if (SubstIndex != null) { SubstIndex.$destroy(); }
              }
            }
            
            // Substitute into the pack expansion pattern for each slice of the
            // pack.
            for (/*uint*/int ArgIdx = 0; ArgIdx != NumExpansions.$star(); ++ArgIdx) {
              Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
              TypeLocBuilder TypeArgBuilder$1 = null;
              try {
                SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), ArgIdx);
                
                TypeArgBuilder$1/*J*/= new TypeLocBuilder();
                TypeArgBuilder$1.reserve(PatternLoc.getFullDataSize());
                
                QualType NewTypeArg = getDerived().TransformType(TypeArgBuilder$1, 
                    new TypeLoc(PatternLoc));
                if (NewTypeArg.isNull()) {
                  return new QualType();
                }
                
                NewTypeArgInfos.push_back(TypeArgBuilder$1.getTypeSourceInfo(SemaRef.Context, new QualType(NewTypeArg)));
              } finally {
                if (TypeArgBuilder$1 != null) { TypeArgBuilder$1.$destroy(); }
                if (SubstIndex != null) { SubstIndex.$destroy(); }
              }
            }
            
            continue;
          }
        }
        
        TypeArgBuilder/*J*/= new TypeLocBuilder();
        TypeArgBuilder.reserve(TypeArgLoc.getFullDataSize());
        QualType NewTypeArg = getDerived().TransformType(TypeArgBuilder, new TypeLoc(TypeArgLoc));
        if (NewTypeArg.isNull()) {
          return new QualType();
        }
        
        // If nothing changed, just keep the old TypeSourceInfo.
        if ($eq_QualType$C(NewTypeArg, TypeArg)) {
          NewTypeArgInfos.push_back(TypeArgInfo);
          continue;
        }
        
        NewTypeArgInfos.push_back(TypeArgBuilder.getTypeSourceInfo(SemaRef.Context, new QualType(NewTypeArg)));
        AnyChanged = true;
      } finally {
        if (TypeArgBuilder != null) { TypeArgBuilder.$destroy(); }
      }
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || AnyChanged) {
      // Rebuild the type.
      Result.$assignMove(getDerived().RebuildObjCObjectType(new QualType(BaseType), 
              TL.getLocStart(), 
              TL.getTypeArgsLAngleLoc(), 
              new ArrayRef<TypeSourceInfo /*P*/ >(NewTypeArgInfos, true), 
              TL.getTypeArgsRAngleLoc(), 
              TL.getProtocolLAngleLoc(), 
              //JAVA/IDE: cast to (ObjCObjectType) below is just for the IDE; otherwse it marks an error
              llvm.makeArrayRef(((ObjCObjectType)TL.getTypePtr()).qual_begin(), 
                  TL.getNumProtocols()), 
              TL.getProtocolLocs(), 
              TL.getProtocolRAngleLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    ObjCObjectTypeLoc NewT = TLB.push(ObjCObjectTypeLoc.class, new QualType(Result));
    NewT.setHasBaseTypeAsWritten(true);
    NewT.setTypeArgsLAngleLoc(TL.getTypeArgsLAngleLoc());
    for (/*uint*/int i = 0, n = TL.getNumTypeArgs(); i != n; ++i)  {
      NewT.setTypeArgTInfo(i, NewTypeArgInfos.$at(i));
    }
    NewT.setTypeArgsRAngleLoc(TL.getTypeArgsRAngleLoc());
    NewT.setProtocolLAngleLoc(TL.getProtocolLAngleLoc());
    for (/*uint*/int i = 0, n = TL.getNumProtocols(); i != n; ++i)  {
      NewT.setProtocolLoc(i, TL.getProtocolLoc(i));
    }
    NewT.setProtocolRAngleLoc(TL.getProtocolRAngleLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5939,
   FQN="clang::TreeTransform::TransformObjCInterfaceType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCInterfaceTypeERNS_14TypeLocBuilderENS_20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCInterfaceTypeERNS_14TypeLocBuilderENS_20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public QualType TransformObjCInterfaceType(final TypeLocBuilder /*&*/ TLB, ObjCInterfaceTypeLoc TL) {
    // ObjCInterfaceType is never dependent.
    TLB.pushFullCopy(new TypeLoc(TL));
    return TL.getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6078,
   FQN="clang::TreeTransform::TransformObjCObjectPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCObjectPointerTypeERNS_14TypeLocBuilderENS_24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCObjectPointerTypeERNS_14TypeLocBuilderENS_24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public QualType TransformObjCObjectPointerType(final TypeLocBuilder /*&*/ TLB, ObjCObjectPointerTypeLoc TL) {
    QualType PointeeType = getDerived().TransformType(TLB, TL.getPointeeLoc());
    if (PointeeType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(PointeeType, TL.getPointeeLoc().getType())) {
      Result.$assignMove(getDerived().RebuildObjCObjectPointerType(new QualType(PointeeType), 
              TL.getStarLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    ObjCObjectPointerTypeLoc NewT = TLB.push(ObjCObjectPointerTypeLoc.class, new QualType(Result));
    NewT.setStarLoc(TL.getStarLoc());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5475,
   FQN="clang::TreeTransform::TransformPipeType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformPipeTypeERNS_14TypeLocBuilderENS_11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformPipeTypeERNS_14TypeLocBuilderENS_11PipeTypeLocE")
  //</editor-fold>
  public QualType TransformPipeType(final TypeLocBuilder /*&*/ TLB, PipeTypeLoc TL) {
    QualType ValueType = getDerived().TransformType(TLB, TL.getValueLoc());
    if (ValueType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild() || $noteq_QualType$C(ValueType, TL.getValueLoc().getType())) {
      Result.$assignMove(getDerived().RebuildPipeType(new QualType(ValueType), TL.getKWLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    PipeTypeLoc NewTL = TLB.push(PipeTypeLoc.class, new QualType(Result));
    NewTL.setKWLoc(TL.getKWLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5452,
   FQN="clang::TreeTransform::TransformAtomicType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAtomicTypeERNS_14TypeLocBuilderENS_13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAtomicTypeERNS_14TypeLocBuilderENS_13AtomicTypeLocE")
  //</editor-fold>
  public QualType TransformAtomicType(final TypeLocBuilder /*&*/ TLB, AtomicTypeLoc TL) {
    QualType ValueType = getDerived().TransformType(TLB, TL.getValueLoc());
    if (ValueType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(ValueType, TL.getValueLoc().getType())) {
      Result.$assignMove(getDerived().RebuildAtomicType(new QualType(ValueType), TL.getKWLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    AtomicTypeLoc NewTL = TLB.push(AtomicTypeLoc.class, new QualType(Result));
    NewTL.setKWLoc(TL.getKWLoc());
    NewTL.setLParenLoc(TL.getLParenLoc());
    NewTL.setRParenLoc(TL.getRParenLoc());
    
    return Result;
  }

  
  /*template <typename Fn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 580,
   FQN="clang::TreeTransform::TransformFunctionProtoType", NM="Tpl__ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionProtoTypeERNS_14TypeLocBuilderENS_20FunctionProtoTypeLocEPNS_13CXXRecordDeclEjT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=Tpl__ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionProtoTypeERNS_14TypeLocBuilderENS_20FunctionProtoTypeLocEPNS_13CXXRecordDeclEjT_")
  //</editor-fold>
  public QualType TransformFunctionProtoType$TreeTransform(final TypeLocBuilder /*&*/ TLB, 
                            FunctionProtoTypeLoc TL, 
                            CXXRecordDecl /*P*/ ThisContext, 
                            /*uint*/int ThisTypeQuals, 
                            TwoTypes2Bool<ExceptionSpecInfo, bool$ref> TransformExceptionSpec) {
    Sema.ExtParameterInfoBuilder ExtParamInfos = null;
    try {
      
      // Transform the parameters and return type.
      //
      // We are required to instantiate the params and return type in source order.
      // When the function has a trailing return type, we instantiate the
      // parameters before the return type,  since the return type can then refer
      // to the parameters themselves (via decltype, sizeof, etc.).
      //
      SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(4, new QualType());
      SmallVector<ParmVarDecl /*P*/ > ParamDecls/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
      ExtParamInfos/*J*/= new Sema.ExtParameterInfoBuilder();
      /*const*/ FunctionProtoType /*P*/ T = TL.getTypePtr();
      
      QualType ResultType/*J*/= new QualType();
      if (T.hasTrailingReturn()) {
        if (getDerived().TransformFunctionTypeParams(TL.getBeginLoc(), TL.getParams(), 
            TL.getTypePtr().param_type_begin(), 
            T.getExtParameterInfosOrNull(), 
            ParamTypes, $AddrOf(ParamDecls), ExtParamInfos)) {
          return new QualType();
        }
        {
          Sema.CXXThisScopeRAII ThisScope = null;
          try {
            // C++11 [expr.prim.general]p3:
            //   If a declaration declares a member function or member function
            //   template of a class X, the expression this is a prvalue of type
            //   "pointer to cv-qualifier-seq X" between the optional cv-qualifer-seq
            //   and the end of the function-definition, member-declarator, or
            //   declarator.
            ThisScope/*J*/= /*ParenList*/new Sema.CXXThisScopeRAII(SemaRef, ThisContext, ThisTypeQuals);
            
            ResultType = getDerived().TransformType(TLB, TL.getReturnLoc());
            if (ResultType.isNull()) {
              return new QualType();
            }
          } finally {
            if (ThisScope != null) { ThisScope.$destroy(); }
          }
        }
      } else {
        ResultType = getDerived().TransformType(TLB, TL.getReturnLoc());
        if (ResultType.isNull()) {
          return new QualType();
        }
        if (getDerived().TransformFunctionTypeParams(TL.getBeginLoc(), TL.getParams(), 
            TL.getTypePtr().param_type_begin(), 
            T.getExtParameterInfosOrNull(), 
            ParamTypes, $AddrOf(ParamDecls), ExtParamInfos)) {
          return new QualType();
        }
      }
      
      FunctionProtoType.ExtProtoInfo EPI = T.getExtProtoInfo();
      
      bool$ref EPIChanged = create_bool$ref(false);
      if (TransformExceptionSpec.$call(EPI.ExceptionSpec, EPIChanged)) {
        return new QualType();
      }
      {
        
        // Handle extended parameter information.
        /*const*/ type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/ NewExtParamInfos = ExtParamInfos.getPointerOrNull(ParamTypes.size());
        if ((NewExtParamInfos != null)) {
          if (!(EPI.ExtParameterInfos != null)
             || $noteq_ArrayRef$T(llvm.makeArrayRef(EPI.ExtParameterInfos, TL.getNumParams()), 
              llvm.makeArrayRef(NewExtParamInfos, ParamTypes.size()))) {
            EPIChanged.$set(true);
          }
          EPI.ExtParameterInfos = NewExtParamInfos;
        } else if ((EPI.ExtParameterInfos != null)) {
          EPIChanged.$set(true);
          EPI.ExtParameterInfos = null;
        }
      }
      
      QualType Result = TL.getType();
      if (Native.$bool(Native.$bool(Native.$bool(getDerived().AlwaysRebuild()) || $noteq_QualType$C(ResultType, T.getReturnType()))
         || $noteq_ArrayRef$T(T.getParamTypes(), llvm.makeArrayRef(ParamTypes))) || EPIChanged.$deref()) {
        Result = getDerived().RebuildFunctionProtoType(ResultType, new MutableArrayRef(ParamTypes), EPI);
        if (Result.isNull()) {
          return new QualType();
        }
      }
      
      FunctionProtoTypeLoc NewTL = TLB.push(FunctionProtoTypeLoc.class, new QualType(Result));
      NewTL.setLocalRangeBegin(TL.getLocalRangeBegin());
      NewTL.setLParenLoc(TL.getLParenLoc());
      NewTL.setRParenLoc(TL.getRParenLoc());
      NewTL.setLocalRangeEnd(TL.getLocalRangeEnd());
      for (/*uint*/int i = 0, e = NewTL.getNumParams(); i != e; ++i)  {
        NewTL.setParam(i, ParamDecls.$at(i));
      }
      
      return Result;
    } finally {
      if (ExtParamInfos != null) { ExtParamInfos.$destroy(); }
    }
    
    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5024,
   FQN="clang::TreeTransform::TransformExceptionSpec", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformExceptionSpecENS_14SourceLocationERNS_17FunctionProtoType17ExceptionSpecInfoERN4llvm15SmallVectorImplINS_8QualTypeEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformExceptionSpecENS_14SourceLocationERNS_17FunctionProtoType17ExceptionSpecInfoERN4llvm15SmallVectorImplINS_8QualTypeEEERb")
  //</editor-fold>
  public boolean TransformExceptionSpec(SourceLocation Loc, 
                        final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, 
                        final SmallVectorImpl<QualType> /*&*/ Exceptions, 
                        final bool$ref/*bool &*/ Changed) {
    assert (ESI.Type != ExceptionSpecificationType.EST_Uninstantiated && ESI.Type != ExceptionSpecificationType.EST_Unevaluated);
    
    // Instantiate a dynamic noexcept expression, if any.
    if (ESI.Type == ExceptionSpecificationType.EST_ComputedNoexcept) {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(getSema(), 
            Sema.ExpressionEvaluationContext.ConstantEvaluated);
        ActionResultTTrue<Expr /*P*/ > NoexceptExpr = getDerived().TransformExpr(ESI.NoexceptExpr);
        if (NoexceptExpr.isInvalid()) {
          return true;
        }
        
        // FIXME: This is bogus, a noexcept expression is not a condition.
        NoexceptExpr.$assignMove(getSema().CheckBooleanCondition(new SourceLocation(Loc), NoexceptExpr.get()));
        if (NoexceptExpr.isInvalid()) {
          return true;
        }
        if (!NoexceptExpr.get().isValueDependent()) {
          NoexceptExpr.$assignMove(getSema().VerifyIntegerConstantExpression(NoexceptExpr.get(), (APSInt /*P*/ )null, 
                  diag.err_noexcept_needs_constant_expression, 
                  /*AllowFold*/ false));
          if (NoexceptExpr.isInvalid()) {
            return true;
          }
        }
        if (ESI.NoexceptExpr != NoexceptExpr.get()) {
          Changed.$set(true);
        }
        ESI.NoexceptExpr = NoexceptExpr.get();
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    if (ESI.Type != ExceptionSpecificationType.EST_Dynamic) {
      return false;
    }
    
    // Instantiate a dynamic exception specification's type.
    for (QualType T : ESI.Exceptions) {
      {
        /*const*/ PackExpansionType /*P*/ PackExpansion = T.$arrow().getAs(PackExpansionType.class);
        if ((PackExpansion != null)) {
          Changed.$set(true);
          
          // We have a pack expansion. Instantiate it.
          SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
          SemaRef.collectUnexpandedParameterPacks_QualType(PackExpansion.getPattern(), 
              Unexpanded);
          assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
          
          // Determine whether the set of unexpanded parameter packs can and
          // should
          // be expanded.
          bool$ref Expand = create_bool$ref(false);
          bool$ref RetainExpansion = create_bool$ref(false);
          OptionalUInt NumExpansions = PackExpansion.getNumExpansions();
          // FIXME: Track the location of the ellipsis (and track source location
          // information for the types in the exception specification in general).
          if (getDerived().TryExpandParameterPacks(new SourceLocation(Loc), new SourceRange(), new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), Expand, 
              RetainExpansion, NumExpansions)) {
            return true;
          }
          if (!Expand.$deref()) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
            try {
              // We can't expand this pack expansion into separate arguments yet;
              // just substitute into the pattern and create a new pack expansion
              // type.
              SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
              QualType U = getDerived().TransformType(PackExpansion.getPattern());
              if (U.isNull()) {
                return true;
              }
              
              U.$assignMove(SemaRef.Context.getPackExpansionType(new QualType(U), new OptionalUInt(NumExpansions)));
              Exceptions.push_back(U);
              continue;
            } finally {
              if (SubstIndex != null) { SubstIndex.$destroy(); }
            }
          }
          
          // Substitute into the pack expansion pattern for each slice of the
          // pack.
          for (/*uint*/int ArgIdx = 0; ArgIdx != NumExpansions.$star(); ++ArgIdx) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
            try {
              SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), ArgIdx);
              
              QualType U = getDerived().TransformType(PackExpansion.getPattern());
              if (U.isNull() || SemaRef.CheckSpecifiedExceptionType(U, new SourceRange(/*NO_COPY*/Loc))) {
                return true;
              }
              
              Exceptions.push_back(U);
            } finally {
              if (SubstIndex != null) { SubstIndex.$destroy(); }
            }
          }
        } else {
          QualType U = getDerived().TransformType(new QualType(T));
          if (U.isNull() || SemaRef.CheckSpecifiedExceptionType(U, new SourceRange(/*NO_COPY*/Loc))) {
            return true;
          }
          if ($noteq_QualType$C(T, U)) {
            Changed.$set(true);
          }
          
          Exceptions.push_back(U);
        }
      }
    }
    
    ESI.Exceptions.$assignMove(new ArrayRef<QualType>(Exceptions, false));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSEHHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7147,
   FQN="clang::TreeTransform::TransformSEHHandler", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSEHHandlerEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSEHHandlerEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSEHHandler(Stmt /*P*/ Handler) {
    if (isa_SEHFinallyStmt(Handler)) {
      return getDerived().TransformSEHFinallyStmt(cast_SEHFinallyStmt(Handler));
    } else {
      return getDerived().TransformSEHExceptStmt(cast_SEHExceptStmt(Handler));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5560,
   FQN="clang::TreeTransform::TransformTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformTemplateSpecializationTypeERNS_14TypeLocBuilderENS_29TemplateSpecializationTypeLocENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformTemplateSpecializationTypeERNS_14TypeLocBuilderENS_29TemplateSpecializationTypeLocENS_12TemplateNameE")
  //</editor-fold>
  public QualType TransformTemplateSpecializationType(final TypeLocBuilder /*&*/ TLB, 
                                     TemplateSpecializationTypeLoc TL, 
                                     TemplateName Template) {
    TemplateArgumentListInfo NewTemplateArgs = null;
    try {
      NewTemplateArgs/*J*/= new TemplateArgumentListInfo();
      NewTemplateArgs.setLAngleLoc(TL.getLAngleLoc());
      NewTemplateArgs.setRAngleLoc(TL.getRAngleLoc());
      /*typedef TemplateArgumentLocContainerIterator<TemplateSpecializationTypeLoc> ArgIterator*/
//      final class ArgIterator extends TemplateArgumentLocContainerIterator<TemplateSpecializationTypeLoc>{ };
      if (getDerived().TransformTemplateArguments(new TemplateArgumentLocContainerIterator<TemplateSpecializationTypeLoc>(TL, 0), 
          new TemplateArgumentLocContainerIterator<TemplateSpecializationTypeLoc>(TL, TL.getNumArgs()), 
          NewTemplateArgs)) {
        return new QualType();
      }
      
      // FIXME: maybe don't rebuild if all the template arguments are the same.
      QualType Result = getDerived().RebuildTemplateSpecializationType(new TemplateName(Template), 
          TL.getTemplateNameLoc(), 
          NewTemplateArgs);
      if (!Result.isNull()) {
        // Specializations of template template parameters are represented as
        // TemplateSpecializationTypes, and substitution of type alias templates
        // within a dependent context can transform them into
        // DependentTemplateSpecializationTypes.
        if (isa_DependentTemplateSpecializationType(Result)) {
          DependentTemplateSpecializationTypeLoc NewTL = TLB.push(DependentTemplateSpecializationTypeLoc.class, new QualType(Result));
          NewTL.setElaboratedKeywordLoc(new SourceLocation());
          NewTL.setQualifierLoc(new NestedNameSpecifierLoc());
          NewTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
          NewTL.setTemplateNameLoc(TL.getTemplateNameLoc());
          NewTL.setLAngleLoc(TL.getLAngleLoc());
          NewTL.setRAngleLoc(TL.getRAngleLoc());
          for (/*uint*/int i = 0, e = NewTemplateArgs.size(); i != e; ++i)  {
            NewTL.setArgLocInfo(i, NewTemplateArgs.$at(i).getLocInfo());
          }
          return Result;
        }
        
        TemplateSpecializationTypeLoc NewTL = TLB.push(TemplateSpecializationTypeLoc.class, new QualType(Result));
        NewTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
        NewTL.setTemplateNameLoc(TL.getTemplateNameLoc());
        NewTL.setLAngleLoc(TL.getLAngleLoc());
        NewTL.setRAngleLoc(TL.getRAngleLoc());
        for (/*uint*/int i = 0, e = NewTemplateArgs.size(); i != e; ++i)  {
          NewTL.setArgLocInfo(i, NewTemplateArgs.$at(i).getLocInfo());
        }
      }
      
      return Result;
    } finally {
      if (NewTemplateArgs != null) { NewTemplateArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5614,
   FQN="clang::TreeTransform::TransformDependentTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocENS_12TemplateNameERNS_12CXXScopeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocENS_12TemplateNameERNS_12CXXScopeSpecE")
  //</editor-fold>
  public QualType TransformDependentTemplateSpecializationType(final TypeLocBuilder /*&*/ TLB, 
                                              DependentTemplateSpecializationTypeLoc TL, 
                                              TemplateName Template, 
                                              final CXXScopeSpec /*&*/ SS) {
    TemplateArgumentListInfo NewTemplateArgs = null;
    try {
      NewTemplateArgs/*J*/= new TemplateArgumentListInfo();
      NewTemplateArgs.setLAngleLoc(TL.getLAngleLoc());
      NewTemplateArgs.setRAngleLoc(TL.getRAngleLoc());
      /*typedef TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc> ArgIterator*/
//      final class ArgIterator extends TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>{ };
      if (getDerived().TransformTemplateArguments(new TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>(TL, 0), 
          new TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>(TL, TL.getNumArgs()), 
          NewTemplateArgs)) {
        return new QualType();
      }
      {
        
        // FIXME: maybe don't rebuild if all the template arguments are the same.
        DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
        if ((DTN != null)) {
          QualType Result = getSema().Context.getDependentTemplateSpecializationType(TL.getTypePtr().getKeyword(), 
              DTN.getQualifier(), 
              DTN.getIdentifier(), 
              NewTemplateArgs);
          
          DependentTemplateSpecializationTypeLoc NewTL = TLB.push(DependentTemplateSpecializationTypeLoc.class, new QualType(Result));
          NewTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
          NewTL.setQualifierLoc(SS.getWithLocInContext(SemaRef.Context));
          NewTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
          NewTL.setTemplateNameLoc(TL.getTemplateNameLoc());
          NewTL.setLAngleLoc(TL.getLAngleLoc());
          NewTL.setRAngleLoc(TL.getRAngleLoc());
          for (/*uint*/int i = 0, e = NewTemplateArgs.size(); i != e; ++i)  {
            NewTL.setArgLocInfo(i, NewTemplateArgs.$at(i).getLocInfo());
          }
          return Result;
        }
      }
      
      QualType Result = getDerived().RebuildTemplateSpecializationType(new TemplateName(Template), 
          TL.getTemplateNameLoc(), 
          NewTemplateArgs);
      if (!Result.isNull()) {
        /// FIXME: Wrap this in an elaborated-type-specifier?
        TemplateSpecializationTypeLoc NewTL = TLB.push(TemplateSpecializationTypeLoc.class, new QualType(Result));
        NewTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
        NewTL.setTemplateNameLoc(TL.getTemplateNameLoc());
        NewTL.setLAngleLoc(TL.getLAngleLoc());
        NewTL.setRAngleLoc(TL.getRAngleLoc());
        for (/*uint*/int i = 0, e = NewTemplateArgs.size(); i != e; ++i)  {
          NewTL.setArgLocInfo(i, NewTemplateArgs.$at(i).getLocInfo());
        }
      }
      
      return Result;
    } finally {
      if (NewTemplateArgs != null) { NewTemplateArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5847,
   FQN="clang::TreeTransform::TransformDependentTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE44TransformDependentTemplateSpecializationTypeERNS_14TypeLocBuilderENS_38DependentTemplateSpecializationTypeLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public QualType TransformDependentTemplateSpecializationType(final TypeLocBuilder /*&*/ TLB, DependentTemplateSpecializationTypeLoc TL, 
                                              NestedNameSpecifierLoc QualifierLoc) {
    TemplateArgumentListInfo NewTemplateArgs = null;
    try {
      /*const*/ DependentTemplateSpecializationType /*P*/ T = TL.getTypePtr();
      
      NewTemplateArgs/*J*/= new TemplateArgumentListInfo();
      NewTemplateArgs.setLAngleLoc(TL.getLAngleLoc());
      NewTemplateArgs.setRAngleLoc(TL.getRAngleLoc());
      
      /*typedef TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc> ArgIterator*/
//      final class ArgIterator extends TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>{ };
      if (getDerived().TransformTemplateArguments(new TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>(TL, 0), 
          new TemplateArgumentLocContainerIterator<DependentTemplateSpecializationTypeLoc>(TL, TL.getNumArgs()), 
          NewTemplateArgs)) {
        return new QualType();
      }
      
      QualType Result = getDerived().RebuildDependentTemplateSpecializationType(T.getKeyword(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          T.getIdentifier(), 
          TL.getTemplateNameLoc(), 
          NewTemplateArgs);
      if (Result.isNull()) {
        return new QualType();
      }
      {
        
        /*const*/ ElaboratedType /*P*/ ElabT = dyn_cast_ElaboratedType(Result);
        if ((ElabT != null)) {
          QualType NamedT = ElabT.getNamedType();
          
          // Copy information relevant to the template specialization.
          TemplateSpecializationTypeLoc NamedTL = TLB.push(TemplateSpecializationTypeLoc.class, new QualType(NamedT));
          NamedTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
          NamedTL.setTemplateNameLoc(TL.getTemplateNameLoc());
          NamedTL.setLAngleLoc(TL.getLAngleLoc());
          NamedTL.setRAngleLoc(TL.getRAngleLoc());
          for (/*uint*/int I = 0, E = NewTemplateArgs.size(); I != E; ++I)  {
            NamedTL.setArgLocInfo(I, NewTemplateArgs.$at(I).getLocInfo());
          }
          
          // Copy information relevant to the elaborated type.
          ElaboratedTypeLoc NewTL = TLB.push(ElaboratedTypeLoc.class, new QualType(Result));
          NewTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
          NewTL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
        } else if (isa_DependentTemplateSpecializationType(Result)) {
          DependentTemplateSpecializationTypeLoc SpecTL = TLB.push(DependentTemplateSpecializationTypeLoc.class, new QualType(Result));
          SpecTL.setElaboratedKeywordLoc(TL.getElaboratedKeywordLoc());
          SpecTL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
          SpecTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
          SpecTL.setTemplateNameLoc(TL.getTemplateNameLoc());
          SpecTL.setLAngleLoc(TL.getLAngleLoc());
          SpecTL.setRAngleLoc(TL.getRAngleLoc());
          for (/*uint*/int I = 0, E = NewTemplateArgs.size(); I != E; ++I)  {
            SpecTL.setArgLocInfo(I, NewTemplateArgs.$at(I).getLocInfo());
          }
        } else {
          TemplateSpecializationTypeLoc SpecTL = TLB.push(TemplateSpecializationTypeLoc.class, new QualType(Result));
          SpecTL.setTemplateKeywordLoc(TL.getTemplateKeywordLoc());
          SpecTL.setTemplateNameLoc(TL.getTemplateNameLoc());
          SpecTL.setLAngleLoc(TL.getLAngleLoc());
          SpecTL.setRAngleLoc(TL.getRAngleLoc());
          for (/*uint*/int I = 0, E = NewTemplateArgs.size(); I != E; ++I)  {
            SpecTL.setArgLocInfo(I, NewTemplateArgs.$at(I).getLocInfo());
          }
        }
      }
      return Result;
    } finally {
      if (NewTemplateArgs != null) { NewTemplateArgs.$destroy(); }
    }
  }

  
  /// \brief Transforms the parameters of a function type into the
  /// given vectors.
  ///
  /// The result vectors should be kept in sync; null entries in the
  /// variables vector are acceptable.
  ///
  /// Return true on error.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionTypeParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4699,
   FQN="clang::TreeTransform::TransformFunctionTypeParams", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformFunctionTypeParamsENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEPKNS_8QualTypeEPKNS_17FunctionProtoType16ExtParameterInfoERNS5_15SmallVectorImplISA_EEPNSH_IS8_EERNS_4Sema23ExtParameterInfoBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformFunctionTypeParamsENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEPKNS_8QualTypeEPKNS_17FunctionProtoType16ExtParameterInfoERNS5_15SmallVectorImplISA_EEPNSH_IS8_EERNS_4Sema23ExtParameterInfoBuilderE")
  //</editor-fold>
  public boolean TransformFunctionTypeParams(SourceLocation Loc, ArrayRef<ParmVarDecl /*P*/ > Params, 
                             /*const*/type$ptr<QualType /*P*/> ParamTypes, 
                             /*const*/ type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/ ParamInfos, 
                             final SmallVectorImpl<QualType> /*&*/ OutParamTypes, SmallVectorImpl<ParmVarDecl /*P*/ > /*P*/ PVars, 
                             final Sema.ExtParameterInfoBuilder /*&*/ PInfos) {
    int indexAdjustment = 0;
    
    /*uint*/int NumParams = Params.size();
    for (/*uint*/int i = 0; i != NumParams; ++i) {
      {
        ParmVarDecl /*P*/ OldParm = Params.$at(i);
        if ((OldParm != null)) {
          assert (OldParm.getFunctionScopeIndex() == i);
          
          OptionalUInt NumExpansions/*J*/= new OptionalUInt();
          ParmVarDecl /*P*/ NewParm = null;
          if (OldParm.isParameterPack()) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
            try {
              // We have a function parameter pack that may need to be expanded.
              SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
              
              // Find the parameter packs that could be expanded.
              TypeLoc TL = OldParm.getTypeSourceInfo().getTypeLoc();
              PackExpansionTypeLoc ExpansionTL = TL.castAs(PackExpansionTypeLoc.class);
              TypeLoc Pattern = ExpansionTL.getPatternLoc();
              SemaRef.collectUnexpandedParameterPacks_TypeLoc(new TypeLoc(Pattern), Unexpanded);
              assert ($greater_uint(Unexpanded.size(), 0)) : "Could not find parameter packs!";
              
              // Determine whether we should expand the parameter packs.
              bool$ref ShouldExpand = create_bool$ref(false);
              bool$ref RetainExpansion = create_bool$ref(false);
              OptionalUInt OrigNumExpansions = ExpansionTL.getTypePtr().getNumExpansions();
              NumExpansions.$assign(OrigNumExpansions);
              if (getDerived().TryExpandParameterPacks(ExpansionTL.getEllipsisLoc(), 
                  Pattern.getSourceRange(), 
                  new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
                  ShouldExpand, 
                  RetainExpansion, 
                  NumExpansions)) {
                return true;
              }
              if (ShouldExpand.$deref()) {
                // Expand the function parameter pack into multiple, separate
                // parameters.
                getDerived().ExpandingFunctionParameterPack(OldParm);
                for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
                  Sema.ArgumentPackSubstitutionIndexRAII SubstIndex$1 = null;
                  try {
                    SubstIndex$1/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I);
                    ParmVarDecl /*P*/ NewParm$1 = getDerived().TransformFunctionTypeParam(OldParm, 
                        indexAdjustment++, 
                        new OptionalUInt(OrigNumExpansions), 
                        /*ExpectParameterPack=*/ false);
                    if (!(NewParm$1 != null)) {
                      return true;
                    }
                    if ((ParamInfos != null)) {
                      PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
                    }
                    OutParamTypes.push_back(NewParm$1.getType());
                    if ((PVars != null)) {
                      PVars.push_back(NewParm$1);
                    }
                  } finally {
                    if (SubstIndex$1 != null) { SubstIndex$1.$destroy(); }
                  }
                }
                
                // If we're supposed to retain a pack expansion, do so by temporarily
                // forgetting the partially-substituted parameter pack.
                if (RetainExpansion.$deref()) {
                  ForgetPartiallySubstitutedPackRAII Forget = null;
                  try {
                    Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
                    ParmVarDecl /*P*/ NewParm$1 = getDerived().TransformFunctionTypeParam(OldParm, 
                        indexAdjustment++, 
                        new OptionalUInt(OrigNumExpansions), 
                        /*ExpectParameterPack=*/ false);
                    if (!(NewParm$1 != null)) {
                      return true;
                    }
                    if ((ParamInfos != null)) {
                      PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
                    }
                    OutParamTypes.push_back(NewParm$1.getType());
                    if ((PVars != null)) {
                      PVars.push_back(NewParm$1);
                    }
                  } finally {
                    if (Forget != null) { Forget.$destroy(); }
                  }
                }
                
                // The next parameter should have the same adjustment as the
                // last thing we pushed, but we post-incremented indexAdjustment
                // on every push.  Also, if we push nothing, the adjustment should
                // go down by one.
                indexAdjustment--;
                
                // We're done with the pack expansion.
                continue;
              }
              
              // We'll substitute the parameter now without expanding the pack
              // expansion.
              SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
              NewParm = getDerived().TransformFunctionTypeParam(OldParm, 
                  indexAdjustment, 
                  new OptionalUInt(NumExpansions), 
                  /*ExpectParameterPack=*/ true);
            } finally {
              if (SubstIndex != null) { SubstIndex.$destroy(); }
            }
          } else {
            NewParm = getDerived().TransformFunctionTypeParam(OldParm, indexAdjustment, new OptionalUInt(None), /*ExpectParameterPack=*/ false);
          }
          if (!(NewParm != null)) {
            return true;
          }
          if ((ParamInfos != null)) {
            PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
          }
          OutParamTypes.push_back(NewParm.getType());
          if ((PVars != null)) {
            PVars.push_back(NewParm);
          }
          continue;
        }
      }
      
      // Deal with the possibility that we don't have a parameter
      // declaration for this parameter.
      QualType OldType = new QualType(ParamTypes.$at(i));
      boolean IsPackExpansion = false;
      OptionalUInt NumExpansions/*J*/= new OptionalUInt();
      QualType NewType/*J*/= new QualType();
      {
        /*const*/ PackExpansionType /*P*/ Expansion = dyn_cast_PackExpansionType(OldType);
        if ((Expansion != null)) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          try {
            // We have a function parameter pack that may need to be expanded.
            QualType Pattern = Expansion.getPattern();
            SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
            getSema().collectUnexpandedParameterPacks_QualType(new QualType(Pattern), Unexpanded);
            
            // Determine whether we should expand the parameter packs.
            bool$ref ShouldExpand = create_bool$ref(false);
            bool$ref RetainExpansion = create_bool$ref(false);
            if (getDerived().TryExpandParameterPacks(new SourceLocation(Loc), new SourceRange(), 
                new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
                ShouldExpand, 
                RetainExpansion, 
                NumExpansions)) {
              return true;
            }
            if (ShouldExpand.$deref()) {
              // Expand the function parameter pack into multiple, separate
              // parameters.
              for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
                Sema.ArgumentPackSubstitutionIndexRAII SubstIndex$1 = null;
                try {
                  SubstIndex$1/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I);
                  QualType NewType$1 = getDerived().TransformType(Pattern);
                  if (NewType$1.isNull()) {
                    return true;
                  }
                  if (NewType$1.$arrow().containsUnexpandedParameterPack()) {
                    NewType$1.$assignMove(
                        getSema().getASTContext().getPackExpansionType(new QualType(NewType$1), new OptionalUInt(None))
                    );
                    if (NewType$1.isNull()) {
                      return true;
                    }
                  }
                  if ((ParamInfos != null)) {
                    PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
                  }
                  OutParamTypes.push_back(NewType$1);
                  if ((PVars != null)) {
                    PVars.push_back((ParmVarDecl /*P*/ /*const*/)null);
                  }
                } finally {
                  if (SubstIndex$1 != null) { SubstIndex$1.$destroy(); }
                }
              }
              
              // We're done with the pack expansion.
              continue;
            }
            
            // If we're supposed to retain a pack expansion, do so by temporarily
            // forgetting the partially-substituted parameter pack.
            if (RetainExpansion.$deref()) {
              ForgetPartiallySubstitutedPackRAII Forget = null;
              try {
                Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
                QualType NewType$1 = getDerived().TransformType(Pattern);
                if (NewType$1.isNull()) {
                  return true;
                }
                if ((ParamInfos != null)) {
                  PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
                }
                OutParamTypes.push_back(NewType$1);
                if ((PVars != null)) {
                  PVars.push_back((ParmVarDecl /*P*/ /*const*/)null);
                }
              } finally {
                if (Forget != null) { Forget.$destroy(); }
              }
            }
            
            // We'll substitute the parameter now without expanding the pack
            // expansion.
            OldType.$assignMove(Expansion.getPattern());
            IsPackExpansion = true;
            SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
            NewType = getDerived().TransformType(OldType);
          } finally {
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        } else {
          NewType.$assignMove(getDerived().TransformType(new QualType(OldType)));
        }
      }
      if (NewType.isNull()) {
        return true;
      }
      if (IsPackExpansion) {
        NewType.$assignMove(getSema().Context.getPackExpansionType(new QualType(NewType), 
                new OptionalUInt(NumExpansions)));
      }
      if ((ParamInfos != null)) {
        PInfos.set(OutParamTypes.size(), new FunctionProtoType.ExtParameterInfo(ParamInfos.$at(i)));
      }
      OutParamTypes.push_back(NewType);
      if ((PVars != null)) {
        PVars.push_back((ParmVarDecl /*P*/ /*const*/)null);
      }
    }
    if ((PVars != null)) {
      for (/*uint*/int i = 0, e = PVars.size(); i != e; ++i)  {
        {
          ParmVarDecl /*P*/ parm = (/*Deref*/PVars).$at(i);
          if ((parm != null)) {
            assert (parm.getFunctionScopeIndex() == i);
          }
        }
      }
    }
    
    return false;
  }

  
  /// \brief Transforms a single function-type parameter.  Return null
  /// on error.
  ///
  /// \param indexAdjustment - A number to add to the parameter's
  ///   scope index;  can be negative
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionTypeParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 627,
   FQN="clang::TreeTransform::TransformFunctionTypeParam", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionTypeParamEPNS_11ParmVarDeclEiN4llvm8OptionalIjEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformFunctionTypeParamEPNS_11ParmVarDeclEiN4llvm8OptionalIjEEb")
  //</editor-fold>
  public ParmVarDecl /*P*/ TransformFunctionTypeParam(ParmVarDecl /*P*/ OldParm, 
                            int indexAdjustment, 
                            OptionalUInt NumExpansions, 
                            boolean ExpectParameterPack) {
    TypeSourceInfo OldDI = OldParm.getTypeSourceInfo();
    TypeSourceInfo NewDI = null;
    if (NumExpansions.$bool() && isa_PackExpansionType(OldDI.getType())) {
      TypeLocBuilder TLB = null;
      try {
        // If we're substituting into a pack expansion type and we know the
        // length we want to expand to, just substitute for the pattern.
        TypeLoc OldTL = OldDI.getTypeLoc();
        PackExpansionTypeLoc OldExpansionTL = OldTL.castAs(PackExpansionTypeLoc.class);
        
        TLB/*J*/= new TypeLocBuilder();
        TypeLoc NewTL = OldDI.getTypeLoc();
        TLB.reserve(NewTL.getFullDataSize());
        
        QualType Result = getDerived().TransformType(TLB, 
            OldExpansionTL.getPatternLoc());
        if (Result.isNull()) {
          return null;
        }
        
        Result = RebuildPackExpansionType(Result, 
            OldExpansionTL.getPatternLoc().getSourceRange(), 
            OldExpansionTL.getEllipsisLoc(), 
            NumExpansions);
        if (Result.isNull()) {
          return null;
        }
        
        PackExpansionTypeLoc NewExpansionTL = TLB.push(PackExpansionTypeLoc.class, new QualType(Result));
        NewExpansionTL.setEllipsisLoc(OldExpansionTL.getEllipsisLoc());
        NewDI = TLB.getTypeSourceInfo(SemaRef.Context, Result);
      } finally {
        if (TLB != null) { TLB.$destroy(); }
      }
    } else {
      NewDI = getDerived().TransformType(OldDI);
    }
    if (!(NewDI != null)) {
      return null;
    }
    if (NewDI == OldDI && indexAdjustment == 0) {
      return OldParm;
    }
    
    ParmVarDecl /*P*/ newParm = ParmVarDecl.Create(SemaRef.Context, 
        OldParm.getDeclContext(), 
        OldParm.getInnerLocStart(), 
        OldParm.getLocation(), 
        OldParm.getIdentifier(), 
        NewDI.getType(),
        NewDI,
        OldParm.getStorageClass(), 
        /* DefArg */ null);
    newParm.setScopeInfo(OldParm.getFunctionScopeDepth(), 
        OldParm.getFunctionScopeIndex() + indexAdjustment);
    return newParm;    
  }


  
  /// Transforms a reference type.  Note that somewhat paradoxically we
  /// don't care whether the type itself is an l-value type or an r-value
  /// type;  we only care if the type was *written* as an l-value type
  /// or an r-value type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4294,
   FQN="clang::TreeTransform::TransformReferenceType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformReferenceTypeERNS_14TypeLocBuilderENS_16ReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformReferenceTypeERNS_14TypeLocBuilderENS_16ReferenceTypeLocE")
  //</editor-fold>
  public QualType TransformReferenceType(final TypeLocBuilder /*&*/ TLB, ReferenceTypeLoc TL) {
    /*const*/ ReferenceType /*P*/ T = TL.getTypePtr();
    
    // Note that this works with the pointee-as-written.
    QualType PointeeType = getDerived().TransformType(TLB, TL.getPointeeLoc());
    if (PointeeType.isNull()) {
      return new QualType();
    }
    
    QualType Result = TL.getType();
    if (getDerived().AlwaysRebuild()
       || $noteq_QualType$C(PointeeType, T.getPointeeTypeAsWritten())) {
      Result.$assignMove(getDerived().RebuildReferenceType(new QualType(PointeeType), 
              T.isSpelledAsLValue(), 
              TL.getSigilLoc()));
      if (Result.isNull()) {
        return new QualType();
      }
    }
    
    // Objective-C ARC can add lifetime qualifiers to the type that we're
    // referring to.
    TLB.TypeWasModifiedSafely(Result.$arrow().getAs(ReferenceType.class).getPointeeTypeAsWritten());
    
    // r-value references can be rebuilt as l-value references.
    ReferenceTypeLoc NewTL/*J*/= new ReferenceTypeLoc();
    if (isa_LValueReferenceType(Result)) {
      NewTL.$assignMove(TLB.push(LValueReferenceTypeLoc.class, new QualType(Result)));
    } else {
      NewTL.$assignMove(TLB.push(RValueReferenceTypeLoc.class, new QualType(Result)));
    }
    NewTL.setSigilLoc(TL.getSigilLoc());
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6115,
   FQN="clang::TreeTransform::TransformCompoundStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCompoundStmtEPNS_12CompoundStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCompoundStmtEPNS_12CompoundStmtEb")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCompoundStmt(CompoundStmt /*P*/ S, boolean IsStmtExpr) {
    Sema.CompoundScopeRAII CompoundScope = null;
    try {
      CompoundScope/*J*/= /*ParenList*/new Sema.CompoundScopeRAII(getSema());
      
      boolean SubStmtInvalid = false;
      boolean SubStmtChanged = false;
      SmallVector<Stmt /*P*/ > Statements/*J*/= new SmallVector<Stmt /*P*/ >(8, (Stmt /*P*/ )null);
      for (Stmt /*P*/ B : S.body()) {
        ActionResultTTrue<Stmt /*P*/ > Result = getDerived().TransformStmt(B);
        if (Result.isInvalid()) {
          // Immediately fail if this was a DeclStmt, since it's very
          // likely that this will cause problems for future statements.
          if (isa_DeclStmt(B)) {
            return StmtError();
          }
          
          // Otherwise, just keep processing substatements and fail later.
          SubStmtInvalid = true;
          continue;
        }
        
        SubStmtChanged = SubStmtChanged || Result.get() != B;
        Statements.push_back(Result.getAs(Stmt.class));
      }
      if (SubStmtInvalid) {
        return StmtError();
      }
      if (!getDerived().AlwaysRebuild()
         && !SubStmtChanged) {
        return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
      }
      
      return getDerived().RebuildCompoundStmt(S.getLBracLoc(), 
          new MutableArrayRef<Stmt /*P*/ >(Statements, true), 
          S.getRBracLoc(), 
          IsStmtExpr);
    } finally {
      if (CompoundScope != null) { CompoundScope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9186,
   FQN="clang::TreeTransform::TransformCXXNamedCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXNamedCastExprEPNS_16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXNamedCastExprEPNS_16CXXNamedCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXNamedCastExpr(CXXNamedCastExpr /*P*/ E) {
    TypeSourceInfo /*P*/ Type = getDerived().TransformType(E.getTypeInfoAsWritten());
    if (!(Type != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExprAsWritten());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Type == E.getTypeInfoAsWritten()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    return getDerived().RebuildCXXNamedCastExpr(E.getOperatorLoc(), E.getStmtClass(), E.getAngleBrackets().getBegin(), 
        Type, E.getAngleBrackets().getEnd(), 
        // FIXME. this should be '(' location
        E.getAngleBrackets().getEnd(), SubExpr.get(), E.getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 637,
   FQN="clang::TreeTransform::TransformTemplateParameterList", NM="_ZN5clang13TreeTransform30TransformTemplateParameterListEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform30TransformTemplateParameterListEPNS_21TemplateParameterListE")
  //</editor-fold>
  public TemplateParameterList /*P*/ TransformTemplateParameterList(TemplateParameterList /*P*/ TPL) {
    return TPL;
  }


  
  /// \brief The operand of a unary address-of operator has special rules: it's
  /// allowed to refer to a non-static member of a class even if there's no 'this'
  /// object available.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAddressOfOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8328,
   FQN="clang::TreeTransform::TransformAddressOfOperand", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformAddressOfOperandEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformAddressOfOperandEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformAddressOfOperand(Expr /*P*/ E) {
    {
      DependentScopeDeclRefExpr /*P*/ DRE = dyn_cast_DependentScopeDeclRefExpr(E);
      if ((DRE != null)) {
        return getDerived().TransformDependentScopeDeclRefExpr(DRE, true, (type$ptr<TypeSourceInfo /*P*/ /*P*/>)null);
      } else {
        return getDerived().TransformExpr(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9962,
   FQN="clang::TreeTransform::TransformDependentScopeDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprEbPPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprEbPPNS_14TypeSourceInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDependentScopeDeclRefExpr(DependentScopeDeclRefExpr /*P*/ E, 
                                    boolean IsAddressOfOperand, 
                                    type$ptr<TypeSourceInfo /*P*/ /*P*/> RecoveryTSI) {
    TemplateArgumentListInfo TransArgs = null;
    try {
      assert ((E.getQualifierLoc()).$bool());
      NestedNameSpecifierLoc QualifierLoc = getDerived().TransformNestedNameSpecifierLoc(E.getQualifierLoc());
      if (!QualifierLoc.$bool()) {
        return ExprError();
      }
      SourceLocation TemplateKWLoc = E.getTemplateKeywordLoc();
      
      // TODO: If this is a conversion-function-id, verify that the
      // destination type name (if present) resolves the same way after
      // instantiation as it did in the local scope.
      DeclarationNameInfo NameInfo = getDerived().TransformDeclarationNameInfo(E.getNameInfo());
      if (!NameInfo.getName().$bool()) {
        return ExprError();
      }
      if (!E.hasExplicitTemplateArgs()) {
        if (!getDerived().AlwaysRebuild()
           && $eq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, E.getQualifierLoc())
          // Note: it is sufficient to compare the Name component of NameInfo:
          // if name has not changed, DNLoc has not changed either.
           && $eq_DeclarationName(NameInfo.getName(), E.getDeclName())) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildDependentScopeDeclRefExpr(new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), NameInfo, /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
            IsAddressOfOperand, RecoveryTSI);
      }
      
      TransArgs/*J*/= new TemplateArgumentListInfo(E.getLAngleLoc(), E.getRAngleLoc());
      if (getDerived().TransformTemplateArguments(E.getTemplateArgs(), 
          E.getNumTemplateArgs(), 
          TransArgs)) {
        return ExprError();
      }
      
      return getDerived().RebuildDependentScopeDeclRefExpr(new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), NameInfo, $AddrOf(TransArgs), IsAddressOfOperand, 
          RecoveryTSI);
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformParenDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9937,
   FQN="clang::TreeTransform::TransformParenDependentScopeDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE39TransformParenDependentScopeDeclRefExprEPNS_9ParenExprEPNS_25DependentScopeDeclRefExprEbPPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE39TransformParenDependentScopeDeclRefExprEPNS_9ParenExprEPNS_25DependentScopeDeclRefExprEbPPNS_14TypeSourceInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformParenDependentScopeDeclRefExpr(ParenExpr /*P*/ PE, DependentScopeDeclRefExpr /*P*/ DRE, boolean AddrTaken, 
                                         type$ptr<TypeSourceInfo /*P*/ /*P*/> RecoveryTSI) {
    ActionResultTTrue<Expr /*P*/ > NewDRE = getDerived().TransformDependentScopeDeclRefExpr(DRE, AddrTaken, RecoveryTSI);
    
    // Propagate both errors and recovered types, which return ExprEmpty.
    if (!NewDRE.isUsable()) {
      return NewDRE;
    }
    
    // We got an expr, wrap it up in parens.
    if (!getDerived().AlwaysRebuild() && NewDRE.get() == DRE) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, PE);
    }
    return getDerived().RebuildParenExpr(NewDRE.get(), PE.getLParen(), 
        PE.getRParen());
  }

  
  //===----------------------------------------------------------------------===//
  // OpenMP directive transformation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7164,
   FQN="clang::TreeTransform::TransformOMPExecutableDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPExecutableDirective(OMPExecutableDirective /*P*/ D) {
    
    // Transform the clauses
    SmallVector<OMPClause /*P*/ > TClauses/*J*/= new SmallVector<OMPClause /*P*/ >(16, (OMPClause /*P*/ )null);
    ArrayRef<OMPClause /*P*/ > Clauses = D.clauses();
    TClauses.reserve(Clauses.size());
    for (type$ptr<OMPClause /*P*/ /*P*/> I = $tryClone(Clauses.begin()), /*P*/ E = $tryClone(Clauses.end());
         $noteq_ptr(I, E); I.$preInc()) {
      if ((I.$star() != null)) {
        getDerived().getSema().StartOpenMPClause((I.$star()).getClauseKind());
        OMPClause /*P*/ Clause = getDerived().TransformOMPClause(I.$star());
        getDerived().getSema().EndOpenMPClause();
        if ((Clause != null)) {
          TClauses.push_back(Clause);
        }
      } else {
        TClauses.push_back((OMPClause /*P*/ /*const*/)null);
      }
    }
    ActionResultTTrue<Stmt /*P*/ > AssociatedStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if (D.hasAssociatedStmt() && (D.getAssociatedStmt() != null)) {
      getDerived().getSema().ActOnOpenMPRegionStart(D.getDirectiveKind(), 
          /*CurScope=*/ (Scope /*P*/ )null);
      ActionResultTTrue<Stmt /*P*/ > Body/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      {
        Sema.CompoundScopeRAII CompoundScope = null;
        try {
          CompoundScope/*J*/= /*ParenList*/new Sema.CompoundScopeRAII(getSema());
          Body = getDerived().TransformStmt(cast_CapturedStmt(D.getAssociatedStmt()).getCapturedStmt());
        } finally {
          if (CompoundScope != null) { CompoundScope.$destroy(); }
        }
      }
      AssociatedStmt.$assignMove(
          getDerived().getSema().ActOnOpenMPRegionEnd(new ActionResultTTrue<Stmt /*P*/ >(Body), new ArrayRef<OMPClause /*P*/ >(TClauses, true))
      );
      if (AssociatedStmt.isInvalid()) {
        return StmtError();
      }
    }
    if (TClauses.size() != Clauses.size()) {
      return StmtError();
    }
    
    // Transform directive name for 'omp critical' directive.
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    if (D.getDirectiveKind() == OpenMPDirectiveKind.OMPD_critical) {
      DirName.$assignMove(cast_OMPCriticalDirective(D).getDirectiveName());
      DirName = getDerived().TransformDeclarationNameInfo(DirName);
    }
    OpenMPDirectiveKind CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
    if (D.getDirectiveKind() == OpenMPDirectiveKind.OMPD_cancellation_point) {
      CancelRegion = cast_OMPCancellationPointDirective(D).getCancelRegion();
    } else if (D.getDirectiveKind() == OpenMPDirectiveKind.OMPD_cancel) {
      CancelRegion = cast_OMPCancelDirective(D).getCancelRegion();
    }
    
    return getDerived().RebuildOMPExecutableDirective(D.getDirectiveKind(), new DeclarationNameInfo(DirName), CancelRegion, new ArrayRef<OMPClause /*P*/ >(TClauses, true), 
        AssociatedStmt.get(), D.getLocStart(), D.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6518,
   FQN="clang::TreeTransform::TransformGCCAsmStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformGCCAsmStmtEPNS_10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformGCCAsmStmtEPNS_10GCCAsmStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformGCCAsmStmt(GCCAsmStmt /*P*/ S)/* __attribute__((noinline))*/ {
    
    SmallVector<Expr /*P*/ > Constraints/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    SmallVector<IdentifierInfo /*P*/> Names/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    
    ActionResultTTrue<Expr /*P*/ > AsmString/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    SmallVector<Expr /*P*/ > Clobbers/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    
    boolean ExprsChanged = false;
    
    // Go through the outputs.
    for (/*uint*/int I = 0, E = S.getNumOutputs(); I != E; ++I) {
      Names.push_back(S.getOutputIdentifier(I));
      
      // No need to transform the constraint literal.
      Constraints.push_back(S.getOutputConstraintLiteral(I));
      
      // Transform the output expr.
      Expr /*P*/ OutputExpr = S.getOutputExpr(I);
      ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformExpr(OutputExpr);
      if (Result.isInvalid()) {
        return StmtError();
      }
      
      ExprsChanged |= Result.get() != OutputExpr;
      
      Exprs.push_back(Result.get());
    }
    
    // Go through the inputs.
    for (/*uint*/int I = 0, E = S.getNumInputs(); I != E; ++I) {
      Names.push_back(S.getInputIdentifier(I));
      
      // No need to transform the constraint literal.
      Constraints.push_back(S.getInputConstraintLiteral(I));
      
      // Transform the input expr.
      Expr /*P*/ InputExpr = S.getInputExpr(I);
      ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformExpr(InputExpr);
      if (Result.isInvalid()) {
        return StmtError();
      }
      
      ExprsChanged |= Result.get() != InputExpr;
      
      Exprs.push_back(Result.get());
    }
    if (!getDerived().AlwaysRebuild() && !ExprsChanged) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Go through the clobbers.
    for (/*uint*/int I = 0, E = S.getNumClobbers(); I != E; ++I)  {
      Clobbers.push_back(S.getClobberStringLiteral(I));
    }
    
    // No need to transform the asm string literal.
    AsmString.$assign(S.getAsmString());
    return getDerived().RebuildGCCAsmStmt(S.getAsmLoc(), S.isSimple(), 
        S.isVolatile(), S.getNumOutputs(), 
        S.getNumInputs(), Names.data(), 
        new MutableArrayRef<Expr /*P*/ >(Constraints, true), new MutableArrayRef<Expr /*P*/ >(Exprs, true), AsmString.get(), 
        new MutableArrayRef<Expr /*P*/ >(Clobbers, true), S.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6583,
   FQN="clang::TreeTransform::TransformMSAsmStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformMSAsmStmtEPNS_9MSAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformMSAsmStmtEPNS_9MSAsmStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformMSAsmStmt(MSAsmStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ArrayRefToken AsmToks = new ArrayRefToken(S.getAsmToks(), S.getNumAsmToks());
    
    boolean HadError = false;
    boolean HadChange = false;
    
    ArrayRef<Expr /*P*/ > SrcExprs = S.getAllExprs();
    SmallVector<Expr /*P*/ > TransformedExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    TransformedExprs.reserve(SrcExprs.size());
    for (/*uint*/int i = 0, e = SrcExprs.size(); i != e; ++i) {
      ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformExpr(SrcExprs.$at(i));
      if (!Result.isUsable()) {
        HadError = true;
      } else {
        HadChange |= (Result.get() != SrcExprs.$at(i));
        TransformedExprs.push_back(Result.get());
      }
    }
    if (HadError) {
      return StmtError();
    }
    if (!HadChange && !getDerived().AlwaysRebuild()) {
      return Owned(S);
    }
    
    return getDerived().RebuildMSAsmStmt(S.getAsmLoc(), S.getLBraceLoc(), 
        new ArrayRefToken(AsmToks), S.getAsmString(), 
        S.getNumOutputs(), S.getNumInputs(), 
        S.getAllConstraints(), S.getClobbers(), 
        new ArrayRef<Expr /*P*/ >(TransformedExprs, true), S.getEndLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6244,
   FQN="clang::TreeTransform::TransformAttributedStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformAttributedStmtEPNS_14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformAttributedStmtEPNS_14AttributedStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformAttributedStmt(AttributedStmt /*P*/ S)/* __attribute__((noinline))*/ {
    boolean AttrsChanged = false;
    SmallVector</*const*/ Attr /*P*/ > Attrs/*J*/= new SmallVector</*const*/ Attr /*P*/ >(1, (/*const*/ Attr /*P*/ )null);
    
    // Visit attributes and keep track if any are transformed.
    for (/*const*/ Attr /*P*/ I : S.getAttrs()) {
      /*const*/ Attr /*P*/ R = getDerived().TransformAttr(I);
      AttrsChanged |= (I != R);
      Attrs.push_back(R);
    }
    
    ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformStmt(S.getSubStmt());
    if (SubStmt.isInvalid()) {
      return StmtError();
    }
    if (SubStmt.get() == S.getSubStmt() && !AttrsChanged) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildAttributedStmt(S.getAttrLoc(), new ArrayRef</*const*/ Attr /*P*/ >(Attrs, true), 
        SubStmt.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6477,
   FQN="clang::TreeTransform::TransformBreakStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformBreakStmtEPNS_9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformBreakStmtEPNS_9BreakStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformBreakStmt(BreakStmt /*P*/ S)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6859,
   FQN="clang::TreeTransform::TransformCXXCatchStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCXXCatchStmtEPNS_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCXXCatchStmtEPNS_12CXXCatchStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCXXCatchStmt(CXXCatchStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the exception declaration, if any.
    VarDecl /*P*/ Var = null;
    {
      VarDecl /*P*/ ExceptionDecl = S.getExceptionDecl();
      if ((ExceptionDecl != null)) {
        TypeSourceInfo /*P*/ T = getDerived().TransformType(ExceptionDecl.getTypeSourceInfo());
        if (!(T != null)) {
          return StmtError();
        }
        
        Var = getDerived().RebuildExceptionDecl(ExceptionDecl, T, ExceptionDecl.getInnerLocStart(), 
            ExceptionDecl.getLocation(), ExceptionDecl.getIdentifier());
        if (!(Var != null) || Var.isInvalidDecl()) {
          return StmtError();
        }
      }
    }
    
    // Transform the actual exception handler.
    ActionResultTTrue<Stmt /*P*/ > Handler = getDerived().TransformStmt(S.getHandlerBlock());
    if (Handler.isInvalid()) {
      return StmtError();
    }
    if (!getDerived().AlwaysRebuild() && !(Var != null)
       && Handler.get() == S.getHandlerBlock()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildCXXCatchStmt(S.getCatchLoc(), Var, Handler.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6915,
   FQN="clang::TreeTransform::TransformCXXForRangeStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformCXXForRangeStmtEPNS_15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformCXXForRangeStmtEPNS_15CXXForRangeStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCXXForRangeStmt(CXXForRangeStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Stmt /*P*/ > Range = getDerived().TransformStmt(S.getRangeStmt());
    if (Range.isInvalid()) {
      return StmtError();
    }
    
    ActionResultTTrue<Stmt /*P*/ > Begin = getDerived().TransformStmt(S.getBeginStmt());
    if (Begin.isInvalid()) {
      return StmtError();
    }
    ActionResultTTrue<Stmt /*P*/ > End = getDerived().TransformStmt(S.getEndStmt());
    if (End.isInvalid()) {
      return StmtError();
    }
    
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(S.getCond());
    if (Cond.isInvalid()) {
      return StmtError();
    }
    if ((Cond.get() != null)) {
      Cond.$assignMove(SemaRef.CheckBooleanCondition(S.getColonLoc(), Cond.get()));
    }
    if (Cond.isInvalid()) {
      return StmtError();
    }
    if ((Cond.get() != null)) {
      Cond.$assign(SemaRef.MaybeCreateExprWithCleanups(Cond.get()));
    }
    
    ActionResultTTrue<Expr /*P*/ > Inc = getDerived().TransformExpr(S.getInc());
    if (Inc.isInvalid()) {
      return StmtError();
    }
    if ((Inc.get() != null)) {
      Inc.$assign(SemaRef.MaybeCreateExprWithCleanups(Inc.get()));
    }
    
    ActionResultTTrue<Stmt /*P*/ > LoopVar = getDerived().TransformStmt(S.getLoopVarStmt());
    if (LoopVar.isInvalid()) {
      return StmtError();
    }
    
    ActionResultTTrue<Stmt /*P*/ > NewStmt = new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    if (getDerived().AlwaysRebuild()
       || Range.get() != S.getRangeStmt()
       || Begin.get() != S.getBeginStmt()
       || End.get() != S.getEndStmt()
       || Cond.get() != S.getCond()
       || Inc.get() != S.getInc()
       || LoopVar.get() != S.getLoopVarStmt()) {
      NewStmt.$assignMove(getDerived().RebuildCXXForRangeStmt(S.getForLoc(), 
              S.getCoawaitLoc(), 
              S.getColonLoc(), Range.get(), 
              Begin.get(), End.get(), 
              Cond.get(), 
              Inc.get(), LoopVar.get(), 
              S.getRParenLoc()));
      if (NewStmt.isInvalid()) {
        return StmtError();
      }
    }
    
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // Body has changed but we didn't rebuild the for-range statement. Rebuild
    // it now so we have a new statement to attach the body to.
    if (Body.get() != S.getBody() && NewStmt.get() == S) {
      NewStmt.$assignMove(getDerived().RebuildCXXForRangeStmt(S.getForLoc(), 
              S.getCoawaitLoc(), 
              S.getColonLoc(), Range.get(), 
              Begin.get(), End.get(), 
              Cond.get(), 
              Inc.get(), LoopVar.get(), 
              S.getRParenLoc()));
      if (NewStmt.isInvalid()) {
        return StmtError();
      }
    }
    if (NewStmt.get() == S) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return FinishCXXForRangeStmt(NewStmt.get(), Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6888,
   FQN="clang::TreeTransform::TransformCXXTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformCXXTryStmtEPNS_10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformCXXTryStmtEPNS_10CXXTryStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCXXTryStmt(CXXTryStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the try block itself.
    ActionResultTTrue<Stmt /*P*/ > TryBlock = getDerived().TransformCompoundStmt(S.getTryBlock());
    if (TryBlock.isInvalid()) {
      return StmtError();
    }
    
    // Transform the handlers.
    boolean HandlerChanged = false;
    SmallVector<Stmt /*P*/ > Handlers/*J*/= new SmallVector<Stmt /*P*/ >(8, (Stmt /*P*/ )null);
    for (/*uint*/int I = 0, N = S.getNumHandlers(); I != N; ++I) {
      ActionResultTTrue<Stmt /*P*/ > Handler = getDerived().TransformCXXCatchStmt(S.getHandler(I));
      if (Handler.isInvalid()) {
        return StmtError();
      }
      
      HandlerChanged = HandlerChanged || Handler.get() != S.getHandler(I);
      Handlers.push_back(Handler.getAs(Stmt.class));
    }
    if (!getDerived().AlwaysRebuild() && TryBlock.get() == S.getTryBlock()
       && !HandlerChanged) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildCXXTryStmt(S.getTryLoc(), TryBlock.get(), 
        new ArrayRef<Stmt /*P*/ >(Handlers, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11915,
   FQN="clang::TreeTransform::TransformCapturedStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCapturedStmtEPNS_12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCapturedStmtEPNS_12CapturedStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCapturedStmt(CapturedStmt /*P*/ S)/* __attribute__((noinline))*/ {
    SourceLocation Loc = S.getLocStart();
    CapturedDecl /*P*/ CD = S.getCapturedDecl();
    /*uint*/int NumParams = CD.getNumParams();
    /*uint*/int ContextParamPos = CD.getContextParamPosition();
    SmallVector<std.pair<StringRef, QualType>> Params/*J*/= new SmallVector<std.pair<StringRef, QualType>>(4, new std.pairTypeType<StringRef, QualType>(new StringRef(), new QualType()));
    for (/*uint*/int I = 0; $less_uint(I, NumParams); ++I) {
      if (I != ContextParamPos) {
        Params.push_back(std.make_pair(CD.getParam(I).getName(), 
                getDerived().TransformType(CD.getParam(I).getType())));
      } else {
        Params.push_back(std.make_pair(new StringRef(), new QualType()));
      }
    }
    getSema().ActOnCapturedRegionStart(new SourceLocation(Loc), /*CurScope*/ (Scope /*P*/ )null, 
        S.getCapturedRegionKind(), new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
    ActionResultTTrue<Stmt /*P*/ > Body/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    {
      Sema.CompoundScopeRAII CompoundScope = null;
      try {
        CompoundScope/*J*/= /*ParenList*/new Sema.CompoundScopeRAII(getSema());
        Body = getDerived().TransformStmt(S.getCapturedStmt());
      } finally {
        if (CompoundScope != null) { CompoundScope.$destroy(); }
      }
    }
    if (Body.isInvalid()) {
      getSema().ActOnCapturedRegionError();
      return StmtError();
    }
    
    return getSema().ActOnCapturedRegionEnd(Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6109,
   FQN="clang::TreeTransform::TransformCompoundStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCompoundStmtEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCompoundStmtEPNS_12CompoundStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCompoundStmt(CompoundStmt /*P*/ S)/* __attribute__((noinline))*/ {
    return getDerived().TransformCompoundStmt(S, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6471,
   FQN="clang::TreeTransform::TransformContinueStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformContinueStmtEPNS_12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformContinueStmtEPNS_12ContinueStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformContinueStmt(ContinueStmt /*P*/ S)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6624,
   FQN="clang::TreeTransform::TransformCoreturnStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCoreturnStmtEPNS_12CoreturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCoreturnStmtEPNS_12CoreturnStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCoreturnStmt(CoreturnStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformInitializer(S.getOperand(), 
        /*NotCopyInit*/ false);
    if (Result.isInvalid()) {
      return StmtError();
    }
    
    // Always rebuild; we don't know if this needs to be injected into a new
    // context or if the promise type has changed.
    return getDerived().RebuildCoreturnStmt(S.getKeywordLoc(), Result.get());
  }

  
  // C++ Coroutines TS
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6617,
   FQN="clang::TreeTransform::TransformCoroutineBodyStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCoroutineBodyStmtEPNS_17CoroutineBodyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCoroutineBodyStmtEPNS_17CoroutineBodyStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCoroutineBodyStmt(CoroutineBodyStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // The coroutine body should be re-formed by the caller if necessary.
    return getDerived().TransformStmt(S.getBody());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6496,
   FQN="clang::TreeTransform::TransformDeclStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformDeclStmtEPNS_8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformDeclStmtEPNS_8DeclStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformDeclStmt(DeclStmt /*P*/ S)/* __attribute__((noinline))*/ {
    boolean DeclChanged = false;
    SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(4, null);
    for (Decl /*P*/ D : S.decls()) {
      Decl /*P*/ Transformed = getDerived().TransformDefinition(D.getLocation(), D);
      if (!(Transformed != null)) {
        return StmtError();
      }
      if (Transformed != D) {
        DeclChanged = true;
      }
      
      Decls.push_back(Transformed);
    }
    if (!getDerived().AlwaysRebuild() && !DeclChanged) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildDeclStmt(new MutableArrayRef<Decl /*P*/ >(Decls, true), S.getStartLoc(), S.getEndLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6373,
   FQN="clang::TreeTransform::TransformDoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15TransformDoStmtEPNS_6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15TransformDoStmtEPNS_6DoStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformDoStmt(DoStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the body
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // Transform the condition
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(S.getCond());
    if (Cond.isInvalid()) {
      return StmtError();
    }
    if (!getDerived().AlwaysRebuild()
       && Cond.get() == S.getCond()
       && Body.get() == S.getBody()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildDoStmt(S.getDoLoc(), Body.get(), S.getWhileLoc(), 
        /*FIXME:*/ S.getWhileLoc(), Cond.get(), 
        S.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8698,
   FQN="clang::TreeTransform::TransformBinaryConditionalOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformBinaryConditionalOperator(BinaryConditionalOperator /*P*/ e)/* __attribute__((noinline))*/ {
    // Just rebuild the common and RHS expressions and see whether we
    // get any changes.
    ActionResultTTrue<Expr /*P*/ > commonExpr = getDerived().TransformExpr(e.getCommon());
    if (commonExpr.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > rhs = getDerived().TransformExpr(e.getFalseExpr());
    if (rhs.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && commonExpr.get() == e.getCommon()
       && rhs.get() == e.getFalseExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, e);
    }
    
    return getDerived().RebuildConditionalOperator(commonExpr.get(), 
        e.getQuestionLoc(), 
        (Expr /*P*/ )null, 
        e.getColonLoc(), 
        rhs.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8724,
   FQN="clang::TreeTransform::TransformConditionalOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformConditionalOperatorEPNS_19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformConditionalOperatorEPNS_19ConditionalOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformConditionalOperator(ConditionalOperator /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(E.getCond());
    if (Cond.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > LHS = getDerived().TransformExpr(E.getLHS());
    if (LHS.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > RHS = getDerived().TransformExpr(E.getRHS());
    if (RHS.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Cond.get() == E.getCond()
       && LHS.get() == E.getLHS()
       && RHS.get() == E.getRHS()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildConditionalOperator(Cond.get(), 
        E.getQuestionLoc(), 
        LHS.get(), 
        E.getColonLoc(), 
        RHS.get());
  }

  
  /// \brief Transform an address-of-label expression.
  ///
  /// By default, the transformation of an address-of-label expression always
  /// rebuilds the expression, so that the label identifier can be resolved to
  /// the corresponding label statement by semantic analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8995,
   FQN="clang::TreeTransform::TransformAddrLabelExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformAddrLabelExprEPNS_13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformAddrLabelExprEPNS_13AddrLabelExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformAddrLabelExpr(AddrLabelExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Decl /*P*/ LD = getDerived().TransformDecl(E.getLabel().getLocation(), 
        E.getLabel());
    if (!(LD != null)) {
      return ExprError();
    }
    
    return getDerived().RebuildAddrLabelExpr(E.getAmpAmpLoc(), E.getLabelLoc(), 
        cast_LabelDecl(LD));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8508,
   FQN="clang::TreeTransform::TransformArraySubscriptExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformArraySubscriptExprEPNS_18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformArraySubscriptExprEPNS_18ArraySubscriptExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformArraySubscriptExpr(ArraySubscriptExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > LHS = getDerived().TransformExpr(E.getLHS());
    if (LHS.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > RHS = getDerived().TransformExpr(E.getRHS());
    if (RHS.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && LHS.get() == E.getLHS()
       && RHS.get() == E.getRHS()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildArraySubscriptExpr(LHS.get(), 
        /*FIXME:*/ E.getLHS().getLocStart(), 
        RHS.get(), 
        E.getRBracketLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9890,
   FQN="clang::TreeTransform::TransformArrayTypeTraitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformArrayTypeTraitExpr(ArrayTypeTraitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ T = getDerived().TransformType(E.getQueriedTypeSourceInfo());
    if (!(T != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && T == E.getQueriedTypeSourceInfo()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    ActionResultTTrue<Expr /*P*/ > SubExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated);
        SubExpr.$assignMove(getDerived().TransformExpr(E.getDimensionExpression()));
        if (SubExpr.isInvalid()) {
          return ExprError();
        }
        if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getDimensionExpression()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    
    return getDerived().RebuildArrayTypeTrait(E.getTrait(), 
        E.getLocStart(), 
        T, 
        SubExpr.get(), 
        E.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11418,
   FQN="clang::TreeTransform::TransformAsTypeExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAsTypeExprEPNS_10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAsTypeExprEPNS_10AsTypeExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformAsTypeExpr(AsTypeExpr /*P*/ E)/* __attribute__((noinline))*/ {
    throw new llvm_unreachable("Cannot transform asType expressions yet");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11424,
   FQN="clang::TreeTransform::TransformAtomicExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAtomicExprEPNS_10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformAtomicExprEPNS_10AtomicExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformAtomicExpr(AtomicExpr /*P*/ E)/* __attribute__((noinline))*/ {
    QualType RetTy = getDerived().TransformType(E.getType());
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > SubExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    SubExprs.reserve(E.getNumSubExprs());
    if (getDerived().TransformExprs(E.getSubExprs(), E.getNumSubExprs(), false, 
        SubExprs, $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && !ArgumentChanged.$star()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildAtomicExpr(E.getBuiltinLoc(), new MutableArrayRef<Expr /*P*/ >(SubExprs, true), 
        new QualType(RetTy), E.getOp(), E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8668,
   FQN="clang::TreeTransform::TransformBinaryOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformBinaryOperatorEPNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformBinaryOperatorEPNS_14BinaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformBinaryOperator(BinaryOperator /*P*/ E)/* __attribute__((noinline))*/ {
    Sema.FPContractStateRAII FPContractState = null;
    try {
      ActionResultTTrue<Expr /*P*/ > LHS = getDerived().TransformExpr(E.getLHS());
      if (LHS.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > RHS = getDerived().TransformExpr(E.getRHS());
      if (RHS.isInvalid()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild()
         && LHS.get() == E.getLHS()
         && RHS.get() == E.getRHS()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      FPContractState/*J*/= /*ParenList*/new Sema.FPContractStateRAII(getSema());
      getSema().FPFeatures.fp_contract = E.isFPContractable();
      
      return getDerived().RebuildBinaryOperator(E.getOperatorLoc(), E.getOpcode(), 
          LHS.get(), RHS.get());
    } finally {
      if (FPContractState != null) { FPContractState.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8691,
   FQN="clang::TreeTransform::TransformCompoundAssignOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCompoundAssignOperatorEPNS_22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCompoundAssignOperatorEPNS_22CompoundAssignOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCompoundAssignOperator(CompoundAssignOperator /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformBinaryOperator(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11340,
   FQN="clang::TreeTransform::TransformBlockExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformBlockExprEPNS_9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformBlockExprEPNS_9BlockExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformBlockExpr(BlockExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Sema.ExtParameterInfoBuilder extParamInfos = null;
    try {
      BlockDecl /*P*/ oldBlock = E.getBlockDecl();
      
      SemaRef.ActOnBlockStart(E.getCaretLocation(), /*Scope=*/ (Scope /*P*/ )null);
      BlockScopeInfo /*P*/ blockScope = SemaRef.getCurBlock();
      
      blockScope.TheDecl.setIsVariadic(oldBlock.isVariadic());
      blockScope.TheDecl.setBlockMissingReturnType(oldBlock.blockMissingReturnType());
      
      SmallVector<ParmVarDecl /*P*/ > params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
      SmallVector<QualType> paramTypes/*J*/= new SmallVector<QualType>(4, new QualType());
      
      /*const*/ FunctionProtoType /*P*/ exprFunctionType = E.getFunctionType();
      
      // Parameter substitution.
      extParamInfos/*J*/= new Sema.ExtParameterInfoBuilder();
      if (getDerived().TransformFunctionTypeParams(E.getCaretLocation(), new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, oldBlock.parameters()), (/*const*/type$ptr<QualType /*P*/> )null, 
          exprFunctionType.getExtParameterInfosOrNull(), paramTypes, $AddrOf(params), 
          extParamInfos)) {
        getSema().ActOnBlockError(E.getCaretLocation(), /*Scope=*/ (Scope /*P*/ )null);
        return ExprError();
      }
      
      QualType exprResultType = getDerived().TransformType(exprFunctionType.getReturnType());
      
      ExtProtoInfo epi = exprFunctionType.getExtProtoInfo();
      epi.ExtParameterInfos = extParamInfos.getPointerOrNull(paramTypes.size());
      
      QualType functionType = getDerived().RebuildFunctionProtoType(new QualType(exprResultType), new MutableArrayRef<QualType>(paramTypes, false), epi);
      blockScope.FunctionType.$assign(functionType);
      
      // Set the parameters on the block decl.
      if (!params.empty()) {
        blockScope.TheDecl.setParams(new ArrayRef<ParmVarDecl /*P*/ >(params, true));
      }
      if (!oldBlock.blockMissingReturnType()) {
        blockScope.HasImplicitReturnType = false;
        blockScope.ReturnType.$assign(exprResultType);
      }
      
      // Transform the body
      ActionResultTTrue<Stmt /*P*/ > body = getDerived().TransformStmt(E.getBody());
      if (body.isInvalid()) {
        getSema().ActOnBlockError(E.getCaretLocation(), /*Scope=*/ (Scope /*P*/ )null);
        return ExprError();
      }
      // In builds with assertions, make sure that we captured everything we
      // captured before.
      if (!SemaRef.getDiagnostics().hasErrorOccurred()) {
        for (final /*const*/ BlockDecl.Capture /*&*/ I : oldBlock.captures()) {
          VarDecl /*P*/ oldCapture = I.getVariable();
          
          // Ignore parameter packs.
          if (isa_ParmVarDecl(oldCapture)
             && cast_ParmVarDecl(oldCapture).isParameterPack()) {
            continue;
          }
          
          VarDecl /*P*/ newCapture = cast_VarDecl(getDerived().TransformDecl(E.getCaretLocation(), 
    oldCapture));
          assert Native.$bool(blockScope.CaptureMap.count(newCapture));
        }
        assert (oldBlock.capturesCXXThis() == blockScope.isCXXThisCaptured());
      }
      
      return SemaRef.ActOnBlockStmtExpr(E.getCaretLocation(), body.get(), 
          /*Scope=*/ (Scope /*P*/ )null);
    } finally {
      if (extParamInfos != null) { extParamInfos.$destroy(); }
    }
  }

  
  /// \brief Transform a C++ temporary-binding expression.
  ///
  /// Since CXXBindTemporaryExpr nodes are implicitly generated, we just
  /// transform the subexpression and return that.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10090,
   FQN="clang::TreeTransform::TransformCXXBindTemporaryExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9333,
   FQN="clang::TreeTransform::TransformCXXBoolLiteralExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10008,
   FQN="clang::TreeTransform::TransformCXXConstructExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXConstructExprEPNS_16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXConstructExprEPNS_16CXXConstructExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXConstructExpr(CXXConstructExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TemporaryBase Rebase = null;
    try {
      // CXXConstructExprs other than for list-initialization and
      // CXXTemporaryObjectExpr are always implicit, so when we have
      // a 1-argument construction we just transform that argument.
      if ((E.getNumArgs() == 1
         || ($greater_uint(E.getNumArgs(), 1) && getDerived().DropCallArgument(E.getArg(1))))
         && (!getDerived().DropCallArgument(E.getArg(0)))
         && !E.isListInitialization()) {
        return getDerived().TransformExpr(E.getArg(0));
      }
      
      Rebase/*J*/= /*ParenList*/new TemporaryBase(Native.$star(this), /*FIXME*/ E.getLocStart(), new DeclarationName());
      
      QualType T = getDerived().TransformType(E.getType());
      if (T.isNull()) {
        return ExprError();
      }
      
      CXXConstructorDecl /*P*/ Constructor = cast_or_null_CXXConstructorDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getConstructor()));
      if (!(Constructor != null)) {
        return ExprError();
      }
      
      bool$ptr ArgumentChanged = create_bool$ptr(false);
      SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
      if (getDerived().TransformExprs(E.getArgs(), E.getNumArgs(), true, Args, 
          $AddrOf(ArgumentChanged))) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild()
         && $eq_QualType$C(T, E.getType())
         && Constructor == E.getConstructor()
         && !ArgumentChanged.$star()) {
        // Mark the constructor as referenced.
        // FIXME: Instantiation-specific
        SemaRef.MarkFunctionReferenced(E.getLocStart(), Constructor);
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildCXXConstructExpr(new QualType(T), /*FIXME:*/ E.getLocStart(), 
          Constructor, 
          E.isElidable(), new MutableArrayRef<Expr /*P*/ >(Args, true), 
          E.hadMultipleCandidates(), 
          E.isListInitialization(), 
          E.isStdInitListInitialization(), 
          E.requiresZeroInitialization(), 
          E.getConstructionKind(), 
          E.getParenOrBraceRange());
    } finally {
      if (Rebase != null) { Rebase.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10107,
   FQN="clang::TreeTransform::TransformCXXTemporaryObjectExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXTemporaryObjectExpr(CXXTemporaryObjectExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ T = getDerived().TransformType(E.getTypeSourceInfo());
    if (!(T != null)) {
      return ExprError();
    }
    
    CXXConstructorDecl /*P*/ Constructor = cast_or_null_CXXConstructorDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getConstructor()));
    if (!(Constructor != null)) {
      return ExprError();
    }
    
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    Args.reserve(E.getNumArgs());
    if (TransformExprs(E.getArgs(), E.getNumArgs(), true, Args, 
        $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && T == E.getTypeSourceInfo()
       && Constructor == E.getConstructor()
       && !ArgumentChanged.$star()) {
      // FIXME: Instantiation-specific
      SemaRef.MarkFunctionReferenced(E.getLocStart(), Constructor);
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    // FIXME: Pass in E->isListInitialization().
    return getDerived().RebuildCXXTemporaryObjectExpr(T, 
        /*FIXME:*/ T.getTypeLoc().getEndLoc(), 
        new MutableArrayRef<Expr /*P*/ >(Args, true), 
        E.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9374,
   FQN="clang::TreeTransform::TransformCXXDefaultArgExpr", NM="_ZN5clang13TreeTransform26TransformCXXDefaultArgExprEPNS_17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform26TransformCXXDefaultArgExprEPNS_17CXXDefaultArgExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ParmVarDecl /*P*/ Param = cast_or_null_ParmVarDecl(getDerived().TransformDecl(E.getLocStart(), 
            E.getParam()));
    if (!(Param != null)) {
      return ExprError();
    }
    if (Native.$not(getDerived().AlwaysRebuild())
       && Param == E.getParam()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXDefaultArgExpr(E.getUsedLocation(), Param);    
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9391,
   FQN="clang::TreeTransform::TransformCXXDefaultInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXDefaultInitExprEPNS_18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXDefaultInitExprEPNS_18CXXDefaultInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    FieldDecl /*P*/ Field = cast_or_null_FieldDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getField()));
    if (!(Field != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && Field == E.getField()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXDefaultInitExpr(E.getExprLoc(), Field);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9538,
   FQN="clang::TreeTransform::TransformCXXDeleteExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXDeleteExprEPNS_13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXDeleteExprEPNS_13CXXDeleteExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDeleteExpr(CXXDeleteExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Operand = getDerived().TransformExpr(E.getArgument());
    if (Operand.isInvalid()) {
      return ExprError();
    }
    
    // Transform the delete operator, if known.
    FunctionDecl /*P*/ OperatorDelete = null;
    if ((E.getOperatorDelete() != null)) {
      OperatorDelete = cast_or_null_FunctionDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getOperatorDelete()));
      if (!(OperatorDelete != null)) {
        return ExprError();
      }
    }
    if (!getDerived().AlwaysRebuild()
       && Operand.get() == E.getArgument()
       && OperatorDelete == E.getOperatorDelete()) {
      // Mark any declarations we need as referenced.
      // FIXME: instantiation-specific.
      if ((OperatorDelete != null)) {
        SemaRef.MarkFunctionReferenced(E.getLocStart(), OperatorDelete);
      }
      if (!E.getArgument().isTypeDependent()) {
        QualType Destroyed = SemaRef.Context.getBaseElementType(E.getDestroyedType());
        {
          /*const*/ RecordType /*P*/ DestroyedRec = Destroyed.$arrow().<RecordType>getAs$RecordType();
          if ((DestroyedRec != null)) {
            CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(DestroyedRec.getDecl());
            SemaRef.MarkFunctionReferenced(E.getLocStart(), 
                SemaRef.LookupDestructor(Record));
          }
        }
      }
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXDeleteExpr(E.getLocStart(), 
        E.isGlobalDelete(), 
        E.isArrayForm(), 
        Operand.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10417,
   FQN="clang::TreeTransform::TransformCXXDependentScopeMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TemplateArgumentListInfo TransArgs = null;
    try {
      // Transform the base of the expression.
      ActionResultTTrue<Expr /*P*/ > Base/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
      Expr /*P*/ OldBase;
      QualType BaseType/*J*/= new QualType();
      QualType ObjectType/*J*/= new QualType();
      if (!E.isImplicitAccess()) {
        OldBase = E.getBase();
        Base.$assignMove(getDerived().TransformExpr(OldBase));
        if (Base.isInvalid()) {
          return ExprError();
        }
        
        // Start the member reference and compute the object's type.
        OpaquePtr<QualType> ObjectTy/*J*/= new OpaquePtr<QualType>();
        bool$ref MayBePseudoDestructor = create_bool$ref(false);
        Base.$assignMove(SemaRef.ActOnStartCXXMemberReference((Scope /*P*/ )null, Base.get(), 
                E.getOperatorLoc(), 
                E.isArrow() ? tok.TokenKind.arrow : tok.TokenKind.period, 
                ObjectTy, 
                MayBePseudoDestructor));
        if (Base.isInvalid()) {
          return ExprError();
        }
        
        ObjectType.$assignMove(ObjectTy.getQualType());
        BaseType.$assignMove(((Expr /*P*/ )Base.get()).getType());
      } else {
        OldBase = null;
        BaseType.$assignMove(getDerived().TransformType(E.getBaseType()));
        ObjectType.$assignMove(BaseType.$arrow().getAs(PointerType.class).getPointeeType());
      }
      
      // Transform the first part of the nested-name-specifier that qualifies
      // the member name.
      NamedDecl /*P*/ FirstQualifierInScope = getDerived().TransformFirstQualifierInScope(E.getFirstQualifierFoundInScope(), 
          E.getQualifierLoc().getBeginLoc());
      
      NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
      if ((E.getQualifier() != null)) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(E.getQualifierLoc(), 
                new QualType(ObjectType), 
                FirstQualifierInScope)
        );
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
      }
      
      SourceLocation TemplateKWLoc = E.getTemplateKeywordLoc();
      
      // TODO: If this is a conversion-function-id, verify that the
      // destination type name (if present) resolves the same way after
      // instantiation as it did in the local scope.
      DeclarationNameInfo NameInfo = getDerived().TransformDeclarationNameInfo(E.getMemberNameInfo());
      if (!NameInfo.getName().$bool()) {
        return ExprError();
      }
      if (!E.hasExplicitTemplateArgs()) {
        // This is a reference to a member without an explicitly-specified
        // template argument list. Optimize for this common case.
        if (!getDerived().AlwaysRebuild()
           && Base.get() == OldBase
           && $eq_QualType$C(BaseType, E.getBaseType())
           && $eq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, E.getQualifierLoc())
           && $eq_DeclarationName(NameInfo.getName(), E.getMember())
           && FirstQualifierInScope == E.getFirstQualifierFoundInScope()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildCXXDependentScopeMemberExpr(Base.get(), 
            new QualType(BaseType), 
            E.isArrow(), 
            E.getOperatorLoc(), 
            new NestedNameSpecifierLoc(QualifierLoc), 
            new SourceLocation(TemplateKWLoc), 
            FirstQualifierInScope, 
            NameInfo, 
            /*TemplateArgs*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null);
      }
      
      TransArgs/*J*/= new TemplateArgumentListInfo(E.getLAngleLoc(), E.getRAngleLoc());
      if (getDerived().TransformTemplateArguments(E.getTemplateArgs(), 
          E.getNumTemplateArgs(), 
          TransArgs)) {
        return ExprError();
      }
      
      return getDerived().RebuildCXXDependentScopeMemberExpr(Base.get(), 
          new QualType(BaseType), 
          E.isArrow(), 
          E.getOperatorLoc(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          new SourceLocation(TemplateKWLoc), 
          FirstQualifierInScope, 
          NameInfo, 
          $AddrOf(TransArgs));
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10768,
   FQN="clang::TreeTransform::TransformCXXFoldExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCXXFoldExprEPNS_11CXXFoldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCXXFoldExprEPNS_11CXXFoldExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXFoldExpr(CXXFoldExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Expr /*P*/ Pattern = E.getPattern();
    
    SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
    getSema().collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(Pattern), Unexpanded);
    assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
    
    // Determine whether the set of unexpanded parameter packs can and should
    // be expanded.
    bool$ref Expand = create_bool$ref(true);
    bool$ref RetainExpansion = create_bool$ref(false);
    OptionalUInt NumExpansions/*J*/= new OptionalUInt();
    if (getDerived().TryExpandParameterPacks(E.getEllipsisLoc(), 
        Pattern.getSourceRange(), 
        new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
        Expand, RetainExpansion, 
        NumExpansions)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    if (!Expand.$deref()) {
      Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
      try {
        // Do not expand any packs here, just transform and rebuild a fold
        // expression.
        SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
        
        ActionResultTTrue<Expr /*P*/ > LHS = (E.getLHS() != null) ? getDerived().TransformExpr(E.getLHS()) : new ActionResultTTrue<Expr /*P*/ >();
        if (LHS.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        
        ActionResultTTrue<Expr /*P*/ > RHS = (E.getRHS() != null) ? getDerived().TransformExpr(E.getRHS()) : new ActionResultTTrue<Expr /*P*/ >();
        if (RHS.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        if (!getDerived().AlwaysRebuild()
           && LHS.get() == E.getLHS() && RHS.get() == E.getRHS()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildCXXFoldExpr(E.getLocStart(), LHS.get(), E.getOperator(), E.getEllipsisLoc(), 
            RHS.get(), E.getLocEnd());
      } finally {
        if (SubstIndex != null) { SubstIndex.$destroy(); }
      }
    }
    
    // The transform has determined that we should perform an elementwise
    // expansion of the pattern. Do so.
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformExpr(E.getInit());
    if (Result.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    boolean LeftFold = E.isLeftFold();
    
    // If we're retaining an expansion for a right fold, it is the innermost
    // component and takes the init (if any).
    if (!LeftFold && RetainExpansion.$deref()) {
      ForgetPartiallySubstitutedPackRAII Forget = null;
      try {
        Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
        
        ActionResultTTrue<Expr /*P*/ > Out = getDerived().TransformExpr(Pattern);
        if (Out.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        
        Result.$assignMove(getDerived().RebuildCXXFoldExpr(E.getLocStart(), Out.get(), E.getOperator(), E.getEllipsisLoc(), 
                Result.get(), E.getLocEnd()));
        if (Result.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
      } finally {
        if (Forget != null) { Forget.$destroy(); }
      }
    }
    
    for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
      Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
      try {
        SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), LeftFold ? I : NumExpansions.$star() - I - 1);
        ActionResultTTrue<Expr /*P*/ > Out = getDerived().TransformExpr(Pattern);
        if (Out.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        if (Out.get().containsUnexpandedParameterPack()) {
          // We still have a pack; retain a pack expansion for this slice.
          Result.$assignMove(getDerived().RebuildCXXFoldExpr(E.getLocStart(), 
                  LeftFold ? Result.get() : Out.get(), 
                  E.getOperator(), E.getEllipsisLoc(), 
                  LeftFold ? Out.get() : Result.get(), 
                  E.getLocEnd()));
        } else if (Result.isUsable()) {
          // We've got down to a single element; build a binary operator.
          Result.$assignMove(getDerived().RebuildBinaryOperator(E.getEllipsisLoc(), E.getOperator(), 
                  LeftFold ? Result.get() : Out.get(), 
                  LeftFold ? Out.get() : Result.get()));
        } else {
          Result.$assign(Out);
        }
        if (Result.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
      } finally {
        if (SubstIndex != null) { SubstIndex.$destroy(); }
      }
    }
    
    // If we're retaining an expansion for a left fold, it is the outermost
    // component and takes the complete expansion so far as its init (if any).
    if (LeftFold && RetainExpansion.$deref()) {
      ForgetPartiallySubstitutedPackRAII Forget = null;
      try {
        Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
        
        ActionResultTTrue<Expr /*P*/ > Out = getDerived().TransformExpr(Pattern);
        if (Out.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        
        Result.$assignMove(getDerived().RebuildCXXFoldExpr(E.getLocStart(), Result.get(), 
                E.getOperator(), E.getEllipsisLoc(), 
                Out.get(), E.getLocEnd()));
        if (Result.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
      } finally {
        if (Forget != null) { Forget.$destroy(); }
      }
    }
    
    // If we had no init and an empty pack, and we're not retaining an expansion,
    // then produce a fallback value or error.
    if (Result.isUnset()) {
      return getDerived().RebuildEmptyCXXFoldExpr(E.getEllipsisLoc(), 
          E.getOperator());
    }
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10060,
   FQN="clang::TreeTransform::TransformCXXInheritedCtorInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXInheritedCtorInitExpr(CXXInheritedCtorInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    QualType T = getDerived().TransformType(E.getType());
    if (T.isNull()) {
      return ExprError();
    }
    
    CXXConstructorDecl /*P*/ Constructor = cast_or_null_CXXConstructorDecl(getDerived().TransformDecl(E.getLocStart(), E.getConstructor()));
    if (!(Constructor != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && $eq_QualType$C(T, E.getType())
       && Constructor == E.getConstructor()) {
      // Mark the constructor as referenced.
      // FIXME: Instantiation-specific
      SemaRef.MarkFunctionReferenced(E.getLocStart(), Constructor);
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXInheritedCtorInitExpr(new QualType(T), E.getLocation(), Constructor, 
        E.constructsVBase(), E.inheritedFromVBase());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9423,
   FQN="clang::TreeTransform::TransformCXXNewExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformCXXNewExprEPNS_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformCXXNewExprEPNS_10CXXNewExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXNewExpr(CXXNewExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the type that we're allocating
    TypeSourceInfo /*P*/ AllocTypeInfo = getDerived().TransformType(E.getAllocatedTypeSourceInfo());
    if (!(AllocTypeInfo != null)) {
      return ExprError();
    }
    
    // Transform the size of the array we're allocating (if any).
    ActionResultTTrue<Expr /*P*/ > ArraySize = getDerived().TransformExpr(E.getArraySize());
    if (ArraySize.isInvalid()) {
      return ExprError();
    }
    
    // Transform the placement arguments (if any).
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > PlacementArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    if (getDerived().TransformExprs(E.getPlacementArgs(), 
        E.getNumPlacementArgs(), true, 
        PlacementArgs, $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    
    // Transform the initializer (if any).
    Expr /*P*/ OldInit = E.getInitializer();
    ActionResultTTrue<Expr /*P*/ > NewInit/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((OldInit != null)) {
      NewInit.$assignMove(getDerived().TransformInitializer(OldInit, true));
    }
    if (NewInit.isInvalid()) {
      return ExprError();
    }
    
    // Transform new operator and delete operator.
    FunctionDecl /*P*/ OperatorNew = null;
    if ((E.getOperatorNew() != null)) {
      OperatorNew = cast_or_null_FunctionDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getOperatorNew()));
      if (!(OperatorNew != null)) {
        return ExprError();
      }
    }
    
    FunctionDecl /*P*/ OperatorDelete = null;
    if ((E.getOperatorDelete() != null)) {
      OperatorDelete = cast_or_null_FunctionDecl(getDerived().TransformDecl(E.getLocStart(), 
    E.getOperatorDelete()));
      if (!(OperatorDelete != null)) {
        return ExprError();
      }
    }
    if (!getDerived().AlwaysRebuild()
       && AllocTypeInfo == E.getAllocatedTypeSourceInfo()
       && ArraySize.get() == E.getArraySize()
       && NewInit.get() == OldInit
       && OperatorNew == E.getOperatorNew()
       && OperatorDelete == E.getOperatorDelete()
       && !ArgumentChanged.$star()) {
      // Mark any declarations we need as referenced.
      // FIXME: instantiation-specific.
      if ((OperatorNew != null)) {
        SemaRef.MarkFunctionReferenced(E.getLocStart(), OperatorNew);
      }
      if ((OperatorDelete != null)) {
        SemaRef.MarkFunctionReferenced(E.getLocStart(), OperatorDelete);
      }
      if (E.isArray() && !E.getAllocatedType().$arrow().isDependentType()) {
        QualType ElementType = SemaRef.Context.getBaseElementType(E.getAllocatedType());
        {
          /*const*/ RecordType /*P*/ RecordT = ElementType.$arrow().<RecordType>getAs$RecordType();
          if ((RecordT != null)) {
            CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(RecordT.getDecl());
            {
              CXXDestructorDecl /*P*/ Destructor = SemaRef.LookupDestructor(Record);
              if ((Destructor != null)) {
                SemaRef.MarkFunctionReferenced(E.getLocStart(), Destructor);
              }
            }
          }
        }
      }
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    QualType AllocType = AllocTypeInfo.getType();
    if (!(ArraySize.get() != null)) {
      // If no array size was specified, but the new expression was
      // instantiated with an array type (e.g., "new T" where T is
      // instantiated with "int[4]"), extract the outer bound from the
      // array type as our array size. We do this with constant and
      // dependently-sized array types.
      /*const*/ ArrayType /*P*/ ArrayT = SemaRef.Context.getAsArrayType(new QualType(AllocType));
      if (!(ArrayT != null)) {
        // Do nothing
      } else {
        /*const*/ ConstantArrayType /*P*/ ConsArrayT = dyn_cast_ConstantArrayType(ArrayT);
        if ((ConsArrayT != null)) {
          ArraySize.$assign(IntegerLiteral.Create(SemaRef.Context, ConsArrayT.getSize(), 
                  SemaRef.Context.getSizeType().$QualType(), 
                  /*FIXME:*/ E.getLocStart()));
          AllocType.$assignMove(ConsArrayT.getElementType());
        } else {
          /*const*/ DependentSizedArrayType /*P*/ DepArrayT = dyn_cast_DependentSizedArrayType(ArrayT);
          if ((DepArrayT != null)) {
            if ((DepArrayT.getSizeExpr() != null)) {
              ArraySize.$assign(DepArrayT.getSizeExpr());
              AllocType.$assignMove(DepArrayT.getElementType());
            }
          }
        }
      }
    }
    
    return getDerived().RebuildCXXNewExpr(E.getLocStart(), 
        E.isGlobalNew(), 
        /*FIXME:*/ E.getLocStart(), 
        new MutableArrayRef<Expr /*P*/ >(PlacementArgs, true), 
        /*FIXME:*/ E.getLocStart(), 
        E.getTypeIdParens(), 
        new QualType(AllocType), 
        AllocTypeInfo, 
        ArraySize.get(), 
        E.getDirectInitRange(), 
        NewInit.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10620,
   FQN="clang::TreeTransform::TransformCXXNoexceptExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformCXXNoexceptExprEPNS_15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformCXXNoexceptExprEPNS_15CXXNoexceptExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXNoexceptExpr(CXXNoexceptExpr /*P*/ E)/* __attribute__((noinline))*/ {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated);
      ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getOperand());
      if (SubExpr.isInvalid()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getOperand()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildCXXNoexceptExpr(E.getSourceRange(), SubExpr.get());
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9339,
   FQN="clang::TreeTransform::TransformCXXNullPtrLiteralExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9582,
   FQN="clang::TreeTransform::TransformCXXPseudoDestructorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXPseudoDestructorExpr(CXXPseudoDestructorExpr /*P*/ E)/* __attribute__((noinline))*/ {
    CXXScopeSpec SS = null;
    try {
      ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
      if (Base.isInvalid()) {
        return ExprError();
      }
      
      OpaquePtr<QualType> ObjectTypePtr/*J*/= new OpaquePtr<QualType>();
      bool$ref MayBePseudoDestructor = create_bool$ref(false);
      Base.$assignMove(SemaRef.ActOnStartCXXMemberReference((Scope /*P*/ )null, Base.get(), 
              E.getOperatorLoc(), 
              E.isArrow() ? tok.TokenKind.arrow : tok.TokenKind.period, 
              ObjectTypePtr, 
              MayBePseudoDestructor));
      if (Base.isInvalid()) {
        return ExprError();
      }
      
      QualType ObjectType = ObjectTypePtr.getQualType();
      NestedNameSpecifierLoc QualifierLoc = E.getQualifierLoc();
      if (QualifierLoc.$bool()) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), new QualType(ObjectType))
        );
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
      }
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      PseudoDestructorTypeStorage Destroyed/*J*/= new PseudoDestructorTypeStorage();
      if ((E.getDestroyedTypeInfo() != null)) {
        TypeSourceInfo /*P*/ DestroyedTypeInfo = getDerived().TransformTypeInObjectScope(E.getDestroyedTypeInfo(), 
            new QualType(ObjectType), (NamedDecl /*P*/ )null, SS);
        if (!(DestroyedTypeInfo != null)) {
          return ExprError();
        }
        Destroyed.$assignMove(new PseudoDestructorTypeStorage(DestroyedTypeInfo));
      } else if (!ObjectType.isNull() && ObjectType.$arrow().isDependentType()) {
        // We aren't likely to be able to resolve the identifier down to a type
        // now anyway, so just retain the identifier.
        Destroyed.$assignMove(new PseudoDestructorTypeStorage(E.getDestroyedTypeIdentifier(), 
                E.getDestroyedTypeLoc()));
      } else {
        // Look for a destructor known with the given name.
        OpaquePtr<QualType> T = SemaRef.getDestructorName(E.getTildeLoc(), 
            $Deref(E.getDestroyedTypeIdentifier()), 
            E.getDestroyedTypeLoc(), 
            /*Scope=*/ (Scope /*P*/ )null, 
            SS, new OpaquePtr<QualType>(ObjectTypePtr), 
            false);
        if (!T.$bool()) {
          return ExprError();
        }
        
        Destroyed.$assignMove(
            new PseudoDestructorTypeStorage(SemaRef.Context.getTrivialTypeSourceInfo(SemaRef.GetTypeFromParser(new OpaquePtr<QualType>(T)), 
                    E.getDestroyedTypeLoc()))
        );
      }
      
      TypeSourceInfo /*P*/ ScopeTypeInfo = null;
      if ((E.getScopeTypeInfo() != null)) {
        CXXScopeSpec EmptySS = null;
        try {
          EmptySS/*J*/= new CXXScopeSpec();
          ScopeTypeInfo = getDerived().TransformTypeInObjectScope(E.getScopeTypeInfo(), new QualType(ObjectType), (NamedDecl /*P*/ )null, EmptySS);
          if (!(ScopeTypeInfo != null)) {
            return ExprError();
          }
        } finally {
          if (EmptySS != null) { EmptySS.$destroy(); }
        }
      }
      
      return getDerived().RebuildCXXPseudoDestructorExpr(Base.get(), 
          E.getOperatorLoc(), 
          E.isArrow(), 
          SS, 
          ScopeTypeInfo, 
          E.getColonColonLoc(), 
          E.getTildeLoc(), 
          new PseudoDestructorTypeStorage(Destroyed));
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9406,
   FQN="clang::TreeTransform::TransformCXXScalarValueInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ T = getDerived().TransformType(E.getTypeSourceInfo());
    if (!(T != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && T == E.getTypeSourceInfo()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXScalarValueInitExpr(T, 
        /*FIXME:*/ T.getTypeLoc().getEndLoc(), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10890,
   FQN="clang::TreeTransform::TransformCXXStdInitializerListExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXStdInitializerListExpr(CXXStdInitializerListExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9346,
   FQN="clang::TreeTransform::TransformCXXThisExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCXXThisExprEPNS_11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCXXThisExprEPNS_11CXXThisExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXThisExpr(CXXThisExpr /*P*/ E)/* __attribute__((noinline))*/ {
    QualType T = getSema().getCurrentThisType();
    if (!getDerived().AlwaysRebuild() && $eq_QualType$C(T, E.getType())) {
      // Make sure that we capture 'this'.
      getSema().CheckCXXThisCapture(E.getLocStart());
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXThisExpr(E.getLocStart(), new QualType(T), E.isImplicit());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9360,
   FQN="clang::TreeTransform::TransformCXXThrowExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCXXThrowExprEPNS_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformCXXThrowExprEPNS_12CXXThrowExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXThrowExpr(CXXThrowExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExpr());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXThrowExpr(E.getThrowLoc(), SubExpr.get(), 
        E.isThrownVariableInScope());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9258,
   FQN="clang::TreeTransform::TransformCXXTypeidExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXTypeidExprEPNS_13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXTypeidExprEPNS_13CXXTypeidExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXTypeidExpr(CXXTypeidExpr /*P*/ E)/* __attribute__((noinline))*/ {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      if (E.isTypeOperand()) {
        TypeSourceInfo /*P*/ TInfo = getDerived().TransformType(E.getTypeOperandSourceInfo());
        if (!(TInfo != null)) {
          return ExprError();
        }
        if (!getDerived().AlwaysRebuild()
           && TInfo == E.getTypeOperandSourceInfo()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildCXXTypeidExpr(E.getType(), 
            E.getLocStart(), 
            TInfo, 
            E.getLocEnd());
      }
      
      // We don't know whether the subexpression is potentially evaluated until
      // after we perform semantic analysis.  We speculatively assume it is
      // unevaluated; it will get fixed later if the subexpression is in fact
      // potentially evaluated.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      
      ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getExprOperand());
      if (SubExpr.isInvalid()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild()
         && SubExpr.get() == E.getExprOperand()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildCXXTypeidExpr(E.getType(), 
          E.getLocStart(), 
          SubExpr.get(), 
          E.getLocEnd());
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10390,
   FQN="clang::TreeTransform::TransformCXXUnresolvedConstructExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXUnresolvedConstructExpr(CXXUnresolvedConstructExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ T = getDerived().TransformType(E.getTypeSourceInfo());
    if (!(T != null)) {
      return ExprError();
    }
    
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    Args.reserve(E.arg_size());
    if (getDerived().TransformExprs(E.arg_begin(), E.arg_size(), true, Args, 
        $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && T == E.getTypeSourceInfo()
       && !ArgumentChanged.$star()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    // FIXME: we're faking the locations of the commas
    return getDerived().RebuildCXXUnresolvedConstructExpr(T, 
        E.getLParenLoc(), 
        new MutableArrayRef<Expr /*P*/ >(Args, true), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9298,
   FQN="clang::TreeTransform::TransformCXXUuidofExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXUuidofExprEPNS_13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformCXXUuidofExprEPNS_13CXXUuidofExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXUuidofExpr(CXXUuidofExpr /*P*/ E)/* __attribute__((noinline))*/ {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      if (E.isTypeOperand()) {
        TypeSourceInfo /*P*/ TInfo = getDerived().TransformType(E.getTypeOperandSourceInfo());
        if (!(TInfo != null)) {
          return ExprError();
        }
        if (!getDerived().AlwaysRebuild()
           && TInfo == E.getTypeOperandSourceInfo()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildCXXUuidofExpr(E.getType(), 
            E.getLocStart(), 
            TInfo, 
            E.getLocEnd());
      }
      
      Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated);
      
      ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getExprOperand());
      if (SubExpr.isInvalid()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild()
         && SubExpr.get() == E.getExprOperand()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildCXXUuidofExpr(E.getType(), 
          E.getLocStart(), 
          SubExpr.get(), 
          E.getLocEnd());
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8561,
   FQN="clang::TreeTransform::TransformCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformCallExprEPNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformCallExprEPNS_8CallExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCallExpr(CallExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the callee.
    ActionResultTTrue<Expr /*P*/ > Callee = getDerived().TransformExpr(E.getCallee());
    if (Callee.isInvalid()) {
      return ExprError();
    }
    
    // Transform arguments.
    bool$ptr ArgChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    if (getDerived().TransformExprs(E.getArgs(), E.getNumArgs(), true, Args, 
        $AddrOf(ArgChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Callee.get() == E.getCallee()
       && !ArgChanged.$star()) {
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    // FIXME: Wrong source location information for the '('.
    SourceLocation FakeLParenLoc = ((Expr /*P*/ )Callee.get()).getSourceRange().getBegin();
    return getDerived().RebuildCallExpr(Callee.get(), new SourceLocation(FakeLParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(Args, true), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9153,
   FQN="clang::TreeTransform::TransformCUDAKernelCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCUDAKernelCallExprEPNS_18CUDAKernelCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCUDAKernelCallExprEPNS_18CUDAKernelCallExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCUDAKernelCallExpr(CUDAKernelCallExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the callee.
    ActionResultTTrue<Expr /*P*/ > Callee = getDerived().TransformExpr(E.getCallee());
    if (Callee.isInvalid()) {
      return ExprError();
    }
    
    // Transform exec config.
    ActionResultTTrue<Expr /*P*/ > EC = getDerived().TransformCallExpr(E.getConfig());
    if (EC.isInvalid()) {
      return ExprError();
    }
    
    // Transform arguments.
    bool$ptr ArgChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    if (getDerived().TransformExprs(E.getArgs(), E.getNumArgs(), true, Args,  
        $AddrOf(ArgChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Callee.get() == E.getCallee()
       && !ArgChanged.$star()) {
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    // FIXME: Wrong source location information for the '('.
    SourceLocation FakeLParenLoc = ((Expr /*P*/ )Callee.get()).getSourceRange().getBegin();
    return getDerived().RebuildCallExpr(Callee.get(), new SourceLocation(FakeLParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(Args, true), 
        E.getRParenLoc(), EC.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9147,
   FQN="clang::TreeTransform::TransformCXXMemberCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCXXMemberCallExprEPNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCXXMemberCallExprEPNS_17CXXMemberCallExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXMemberCallExpr(CXXMemberCallExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformCallExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9062,
   FQN="clang::TreeTransform::TransformCXXOperatorCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformCXXOperatorCallExprEPNS_19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformCXXOperatorCallExprEPNS_19CXXOperatorCallExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Sema.FPContractStateRAII FPContractState = null;
    try {
      switch (E.getOperator()) {
       case OO_New:
       case OO_Delete:
       case OO_Array_New:
       case OO_Array_Delete:
        throw new llvm_unreachable("new and delete operators cannot use CXXOperatorCallExpr");
       case OO_Call:
        {
          // This is a call to an object's operator().
          assert ($greatereq_uint(E.getNumArgs(), 1)) : "Object call is missing arguments";
          
          // Transform the object itself.
          ActionResultTTrue<Expr /*P*/ > Object = getDerived().TransformExpr(E.getArg(0));
          if (Object.isInvalid()) {
            return ExprError();
          }
          
          // FIXME: Poor location information
          SourceLocation FakeLParenLoc = SemaRef.getLocForEndOfToken(((/*static_cast*/Expr /*P*/ )(Object.get())).getLocEnd());
          
          // Transform the call arguments.
          SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
          if (getDerived().TransformExprs(E.getArgs().$add(1), E.getNumArgs() - 1, true, 
              Args)) {
            return ExprError();
          }
          
          return getDerived().RebuildCallExpr(Object.get(), new SourceLocation(FakeLParenLoc), 
              new MutableArrayRef<Expr /*P*/ >(Args, true), 
              E.getLocEnd());
        }
       case OO_Plus:
       case OO_Minus:
       case OO_Star:
       case OO_Slash:
       case OO_Percent:
       case OO_Caret:
       case OO_Amp:
       case OO_Pipe:
       case OO_Tilde:
       case OO_Exclaim:
       case OO_Equal:
       case OO_Less:
       case OO_Greater:
       case OO_PlusEqual:
       case OO_MinusEqual:
       case OO_StarEqual:
       case OO_SlashEqual:
       case OO_PercentEqual:
       case OO_CaretEqual:
       case OO_AmpEqual:
       case OO_PipeEqual:
       case OO_LessLess:
       case OO_GreaterGreater:
       case OO_LessLessEqual:
       case OO_GreaterGreaterEqual:
       case OO_EqualEqual:
       case OO_ExclaimEqual:
       case OO_LessEqual:
       case OO_GreaterEqual:
       case OO_AmpAmp:
       case OO_PipePipe:
       case OO_PlusPlus:
       case OO_MinusMinus:
       case OO_Comma:
       case OO_ArrowStar:
       case OO_Arrow:
       case OO_Coawait:
       case OO_Subscript:
        // Handled below.
        break;
       case OO_Conditional:
        throw new llvm_unreachable("conditional operator is not actually overloadable");
       case OO_None:
       case NUM_OVERLOADED_OPERATORS:
        throw new llvm_unreachable("not an overloaded operator?");
      }
      
      ActionResultTTrue<Expr /*P*/ > Callee = getDerived().TransformExpr(E.getCallee());
      if (Callee.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > First/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if (E.getOperator() == OverloadedOperatorKind.OO_Amp) {
        First.$assignMove(getDerived().TransformAddressOfOperand(E.getArg(0)));
      } else {
        First.$assignMove(getDerived().TransformExpr(E.getArg(0)));
      }
      if (First.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Second/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if (E.getNumArgs() == 2) {
        Second.$assignMove(getDerived().TransformExpr(E.getArg(1)));
        if (Second.isInvalid()) {
          return ExprError();
        }
      }
      if (!getDerived().AlwaysRebuild()
         && Callee.get() == E.getCallee()
         && First.get() == E.getArg(0)
         && (E.getNumArgs() != 2 || Second.get() == E.getArg(1))) {
        return SemaRef.MaybeBindToTemporary(E);
      }
      
      FPContractState/*J*/= /*ParenList*/new Sema.FPContractStateRAII(getSema());
      getSema().FPFeatures.fp_contract = E.isFPContractable();
      
      return getDerived().RebuildCXXOperatorCallExpr(E.getOperator(), 
          E.getOperatorLoc(), 
          Callee.get(), 
          First.get(), 
          Second.get());
    } finally {
      if (FPContractState != null) { FPContractState.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8268,
   FQN="clang::TreeTransform::TransformUserDefinedLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformUserDefinedLiteralEPNS_18UserDefinedLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformUserDefinedLiteralEPNS_18UserDefinedLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUserDefinedLiteral(UserDefinedLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    {
      FunctionDecl /*P*/ FD = E.getDirectCallee();
      if ((FD != null)) {
        SemaRef.MarkFunctionReferenced(E.getLocStart(), FD);
      }
    }
    return SemaRef.MaybeBindToTemporary(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8760,
   FQN="clang::TreeTransform::TransformCStyleCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformCStyleCastExprEPNS_14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformCStyleCastExprEPNS_14CStyleCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCStyleCastExpr(CStyleCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ Type = getDerived().TransformType(E.getTypeInfoAsWritten());
    if (!(Type != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExprAsWritten());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Type == E.getTypeInfoAsWritten()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCStyleCastExpr(E.getLParenLoc(), 
        Type, 
        E.getRParenLoc(), 
        SubExpr.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9234,
   FQN="clang::TreeTransform::TransformCXXFunctionalCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXFunctionalCastExpr(CXXFunctionalCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ Type = getDerived().TransformType(E.getTypeInfoAsWritten());
    if (!(Type != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExprAsWritten());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Type == E.getTypeInfoAsWritten()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildCXXFunctionalCastExpr(Type, 
        E.getLParenLoc(), 
        SubExpr.get(), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9228,
   FQN="clang::TreeTransform::TransformCXXConstCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXConstCastExprEPNS_16CXXConstCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCXXConstCastExprEPNS_16CXXConstCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXConstCastExpr(CXXConstCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformCXXNamedCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9215,
   FQN="clang::TreeTransform::TransformCXXDynamicCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXDynamicCastExprEPNS_18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformCXXDynamicCastExprEPNS_18CXXDynamicCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDynamicCastExpr(CXXDynamicCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformCXXNamedCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9221,
   FQN="clang::TreeTransform::TransformCXXReinterpretCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXReinterpretCastExpr(CXXReinterpretCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformCXXNamedCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9209,
   FQN="clang::TreeTransform::TransformCXXStaticCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCXXStaticCastExprEPNS_17CXXStaticCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformCXXStaticCastExprEPNS_17CXXStaticCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXStaticCastExpr(CXXStaticCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformCXXNamedCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11092,
   FQN="clang::TreeTransform::TransformObjCBridgedCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCBridgedCastExpr(ObjCBridgedCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ TSInfo = getDerived().TransformType(E.getTypeInfoAsWritten());
    if (!(TSInfo != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformExpr(E.getSubExpr());
    if (Result.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && TSInfo == E.getTypeInfoAsWritten()
       && Result.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return SemaRef.BuildObjCBridgedCast(E.getLParenLoc(), E.getBridgeKind(), 
        E.getBridgeKeywordLoc(), TSInfo, 
        Result.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8752,
   FQN="clang::TreeTransform::TransformImplicitCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformImplicitCastExprEPNS_16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformImplicitCastExprEPNS_16ImplicitCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformImplicitCastExpr(ImplicitCastExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Implicit casts are eliminated during transformation, since they
    // will be recomputed by semantic analysis after transformation.
    return getDerived().TransformExpr(E.getSubExprAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8262,
   FQN="clang::TreeTransform::TransformCharacterLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCharacterLiteralEPNS_16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformCharacterLiteralEPNS_16CharacterLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCharacterLiteral(CharacterLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9030,
   FQN="clang::TreeTransform::TransformChooseExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformChooseExprEPNS_10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformChooseExprEPNS_10ChooseExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformChooseExpr(ChooseExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(E.getCond());
    if (Cond.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > LHS = getDerived().TransformExpr(E.getLHS());
    if (LHS.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > RHS = getDerived().TransformExpr(E.getRHS());
    if (RHS.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Cond.get() == E.getCond()
       && LHS.get() == E.getLHS()
       && RHS.get() == E.getRHS()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildChooseExpr(E.getBuiltinLoc(), 
        Cond.get(), LHS.get(), RHS.get(), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8783,
   FQN="clang::TreeTransform::TransformCompoundLiteralExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformCompoundLiteralExprEPNS_19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformCompoundLiteralExprEPNS_19CompoundLiteralExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ OldT = E.getTypeSourceInfo();
    TypeSourceInfo /*P*/ NewT = getDerived().TransformType(OldT);
    if (!(NewT != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > Init = getDerived().TransformExpr(E.getInitializer());
    if (Init.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && OldT == NewT
       && Init.get() == E.getInitializer()) {
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    // Note: the expression type doesn't necessarily match the
    // type-as-written, but that's okay, because it should always be
    // derivable from the initializer.
    return getDerived().RebuildCompoundLiteralExpr(E.getLParenLoc(), NewT, 
        /*FIXME:*/ E.getInitializer().getLocEnd(), 
        Init.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11319,
   FQN="clang::TreeTransform::TransformConvertVectorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformConvertVectorExprEPNS_17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformConvertVectorExprEPNS_17ConvertVectorExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformConvertVectorExpr(ConvertVectorExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SrcExpr = getDerived().TransformExpr(E.getSrcExpr());
    if (SrcExpr.isInvalid()) {
      return ExprError();
    }
    
    TypeSourceInfo /*P*/ Type = getDerived().TransformType(E.getTypeSourceInfo());
    if (!(Type != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Type == E.getTypeSourceInfo()
       && SrcExpr.get() == E.getSrcExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildConvertVectorExpr(E.getBuiltinLoc(), 
        SrcExpr.get(), Type, 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6637,
   FQN="clang::TreeTransform::TransformCoawaitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCoawaitExprEPNS_11CoawaitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCoawaitExprEPNS_11CoawaitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCoawaitExpr(CoawaitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformInitializer(E.getOperand(), 
        /*NotCopyInit*/ false);
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    // Always rebuild; we don't know if this needs to be injected into a new
    // context or if the promise type has changed.
    return getDerived().RebuildCoawaitExpr(E.getKeywordLoc(), Result.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6650,
   FQN="clang::TreeTransform::TransformCoyieldExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCoyieldExprEPNS_11CoyieldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformCoyieldExprEPNS_11CoyieldExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCoyieldExpr(CoyieldExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformInitializer(E.getOperand(), 
        /*NotCopyInit*/ false);
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    // Always rebuild; we don't know if this needs to be injected into a new
    // context or if the promise type has changed.
    return getDerived().RebuildCoyieldExpr(E.getKeywordLoc(), Result.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8186,
   FQN="clang::TreeTransform::TransformDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDeclRefExprEPNS_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDeclRefExprEPNS_11DeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDeclRefExpr(DeclRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TemplateArgumentListInfo TransArgs = null;
    try {
      NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
      if (E.getQualifierLoc().$bool()) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(E.getQualifierLoc())
        );
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
      }
      
      ValueDecl /*P*/ ND = cast_or_null_ValueDecl(getDerived().TransformDecl(E.getLocation(), 
    E.getDecl()));
      if (!(ND != null)) {
        return ExprError();
      }
      
      DeclarationNameInfo NameInfo = E.getNameInfo();
      if (NameInfo.getName().$bool()) {
        NameInfo.$assignMove(getDerived().TransformDeclarationNameInfo(NameInfo));
        if (!NameInfo.getName().$bool()) {
          return ExprError();
        }
      }
      if (!getDerived().AlwaysRebuild()
         && $eq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, E.getQualifierLoc())
         && ND == E.getDecl()
         && $eq_DeclarationName(NameInfo.getName(), E.getDecl().getDeclName())
         && !E.hasExplicitTemplateArgs()) {
        
        // Mark it referenced in the new context regardless.
        // FIXME: this is a bit instantiation-specific.
        SemaRef.MarkDeclRefReferenced(E);
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      TransArgs/*J*/= new TemplateArgumentListInfo();
      TemplateArgumentListInfo /*P*/ TemplateArgs = null;
      if (E.hasExplicitTemplateArgs()) {
        TemplateArgs = $AddrOf(TransArgs);
        TransArgs.setLAngleLoc(E.getLAngleLoc());
        TransArgs.setRAngleLoc(E.getRAngleLoc());
        if (getDerived().TransformTemplateArguments(E.getTemplateArgs(), 
            E.getNumTemplateArgs(), 
            TransArgs)) {
          return ExprError();
        }
      }
      
      return getDerived().RebuildDeclRefExpr(new NestedNameSpecifierLoc(QualifierLoc), ND, NameInfo, 
          TemplateArgs);
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9955,
   FQN="clang::TreeTransform::TransformDependentScopeDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDependentScopeDeclRefExpr(DependentScopeDeclRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return TransformDependentScopeDeclRefExpr(E, /*IsAddressOfOperand=*/ false, 
        (type$ptr<TypeSourceInfo /*P*/ /*P*/>)null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8852,
   FQN="clang::TreeTransform::TransformDesignatedInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformDesignatedInitExprEPNS_18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformDesignatedInitExprEPNS_18DesignatedInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDesignatedInitExpr(DesignatedInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Designation Desig = null;
    try {
      Desig/*J*/= new Designation();
      
      // transform the initializer value
      ActionResultTTrue<Expr /*P*/ > Init = getDerived().TransformExpr(E.getInit());
      if (Init.isInvalid()) {
        return ExprError();
      }
      
      // transform the designators.
      SmallVector<Expr /*P*/ > ArrayExprs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      boolean ExprChanged = false;
      for (final /*const*/ DesignatedInitExpr.Designator /*&*/ D : E.designators()) {
        if (D.isFieldDesignator()) {
          Desig.AddDesignator(Designator.getField(D.getFieldName(), 
                  D.getDotLoc(), 
                  D.getFieldLoc()));
          continue;
        }
        if (D.isArrayDesignator()) {
          ActionResultTTrue<Expr /*P*/ > Index = getDerived().TransformExpr(E.getArrayIndex(D));
          if (Index.isInvalid()) {
            return ExprError();
          }
          
          Desig.AddDesignator(Designator.getArray(Index.get(), D.getLBracketLoc()));
          
          ExprChanged = ExprChanged || Init.get() != E.getArrayIndex(D);
          ArrayExprs.push_back(Index.get());
          continue;
        }
        assert (D.isArrayRangeDesignator()) : "New kind of designator?";
        ActionResultTTrue<Expr /*P*/ > Start = getDerived().TransformExpr(E.getArrayRangeStart(D));
        if (Start.isInvalid()) {
          return ExprError();
        }
        
        ActionResultTTrue<Expr /*P*/ > End = getDerived().TransformExpr(E.getArrayRangeEnd(D));
        if (End.isInvalid()) {
          return ExprError();
        }
        
        Desig.AddDesignator(Designator.getArrayRange(Start.get(), 
                End.get(), 
                D.getLBracketLoc(), 
                D.getEllipsisLoc()));
        
        ExprChanged = ExprChanged || Start.get() != E.getArrayRangeStart(D)
           || End.get() != E.getArrayRangeEnd(D);
        
        ArrayExprs.push_back(Start.get());
        ArrayExprs.push_back(End.get());
      }
      if (!getDerived().AlwaysRebuild()
         && Init.get() == E.getInit()
         && !ExprChanged) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildDesignatedInitExpr(Desig, new MutableArrayRef<Expr /*P*/ >(ArrayExprs, true), 
          E.getEqualOrColonLoc(), 
          E.usesGNUSyntax(), Init.get());
    } finally {
      if (Desig != null) { Desig.$destroy(); }
    }
  }

  
  // Seems that if TransformInitListExpr() only works on the syntactic form of an
  // InitListExpr, then a DesignatedInitUpdateExpr is not encountered.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8920,
   FQN="clang::TreeTransform::TransformDesignatedInitUpdateExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ E)/* __attribute__((noinline))*/ {
    throw new llvm_unreachable("Unexpected DesignatedInitUpdateExpr in syntactic form of initializer");
//    return ExprError();
  }

  
  /// \brief Transform a C++ expression that contains cleanups that should
  /// be run after the expression is evaluated.
  ///
  /// Since ExprWithCleanups nodes are implicitly generated, we
  /// just transform the subexpression and return that.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10101,
   FQN="clang::TreeTransform::TransformExprWithCleanups", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformExprWithCleanupsEPNS_16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformExprWithCleanupsEPNS_16ExprWithCleanupsE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformExprWithCleanups(ExprWithCleanups /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9919,
   FQN="clang::TreeTransform::TransformExpressionTraitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformExpressionTraitExprEPNS_19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformExpressionTraitExprEPNS_19ExpressionTraitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformExpressionTraitExpr(ExpressionTraitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SubExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated);
        SubExpr = getDerived().TransformExpr(E.getQueriedExpression());
        if (SubExpr.isInvalid()) {
          return ExprError();
        }
        if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getQueriedExpression()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    
    return getDerived().RebuildExpressionTrait(E.getTrait(), E.getLocStart(), SubExpr.get(), E.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8809,
   FQN="clang::TreeTransform::TransformExtVectorElementExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformExtVectorElementExprEPNS_20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformExtVectorElementExprEPNS_20ExtVectorElementExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformExtVectorElementExpr(ExtVectorElementExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
    if (Base.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && Base.get() == E.getBase()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    // FIXME: Bad source location
    SourceLocation FakeOperatorLoc = SemaRef.getLocForEndOfToken(E.getBase().getLocEnd());
    return getDerived().RebuildExtVectorElementExpr(Base.get(), new SourceLocation(FakeOperatorLoc), 
        E.getAccessorLoc(), 
        E.getAccessor());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8244,
   FQN="clang::TreeTransform::TransformFloatingLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformFloatingLiteralEPNS_15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformFloatingLiteralEPNS_15FloatingLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformFloatingLiteral(FloatingLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10753,
   FQN="clang::TreeTransform::TransformFunctionParmPackExpr", NM="_ZN5clang13TreeTransform29TransformFunctionParmPackExprEPNS_20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform29TransformFunctionParmPackExprEPNS_20FunctionParmPackExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformFunctionParmPackExpr(FunctionParmPackExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Default behavior is to do nothing with this transformation.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9056,
   FQN="clang::TreeTransform::TransformGNUNullExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformGNUNullExprEPNS_11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformGNUNullExprEPNS_11GNUNullExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformGNUNullExpr(GNUNullExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8276,
   FQN="clang::TreeTransform::TransformGenericSelectionExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformGenericSelectionExprEPNS_20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformGenericSelectionExprEPNS_20GenericSelectionExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformGenericSelectionExpr(GenericSelectionExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > ControllingExpr = getDerived().TransformExpr(E.getControllingExpr());
    if (ControllingExpr.isInvalid()) {
      return ExprError();
    }
    
    SmallVector<Expr /*P*/ > AssocExprs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    SmallVector<TypeSourceInfo /*P*/ > AssocTypes/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
    for (/*uint*/int i = 0; i != E.getNumAssocs(); ++i) {
      TypeSourceInfo /*P*/ TS = E.getAssocTypeSourceInfo(i);
      if ((TS != null)) {
        TypeSourceInfo /*P*/ AssocType = getDerived().TransformType(TS);
        if (!(AssocType != null)) {
          return ExprError();
        }
        AssocTypes.push_back(AssocType);
      } else {
        AssocTypes.push_back((TypeSourceInfo /*P*/ /*const*/)null);
      }
      
      ActionResultTTrue<Expr /*P*/ > AssocExpr = getDerived().TransformExpr(E.getAssocExpr(i));
      if (AssocExpr.isInvalid()) {
        return ExprError();
      }
      AssocExprs.push_back(AssocExpr.get());
    }
    
    return getDerived().RebuildGenericSelectionExpr(E.getGenericLoc(), 
        E.getDefaultLoc(), 
        E.getRParenLoc(), 
        ControllingExpr.get(), 
        new ArrayRef<TypeSourceInfo /*P*/ >(AssocTypes, true), 
        new ArrayRef<Expr /*P*/ >(AssocExprs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8250,
   FQN="clang::TreeTransform::TransformImaginaryLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformImaginaryLiteralEPNS_16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformImaginaryLiteralEPNS_16ImaginaryLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformImaginaryLiteral(ImaginaryLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8937,
   FQN="clang::TreeTransform::TransformImplicitValueInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformImplicitValueInitExprEPNS_21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformImplicitValueInitExprEPNS_21ImplicitValueInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TemporaryBase Rebase = null;
    try {
      Rebase/*J*/= /*ParenList*/new TemporaryBase(Native.$star(this), E.getLocStart(), new DeclarationName());
      
      // FIXME: Will we ever have proper type location here? Will we actually
      // need to transform the type?
      QualType T = getDerived().TransformType(E.getType());
      if (T.isNull()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild()
         && $eq_QualType$C(T, E.getType())) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildImplicitValueInitExpr(new QualType(T));
    } finally {
      if (Rebase != null) { Rebase.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8828,
   FQN="clang::TreeTransform::TransformInitListExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformInitListExprEPNS_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformInitListExprEPNS_12InitListExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformInitListExpr(InitListExpr /*P*/ E)/* __attribute__((noinline))*/ {
    {
      InitListExpr /*P*/ Syntactic = E.getSyntacticForm();
      if ((Syntactic != null)) {
        E = Syntactic;
      }
    }
    
    bool$ptr InitChanged = create_bool$ptr(false);
    
    SmallVector<Expr /*P*/ > Inits/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    if (getDerived().TransformExprs(E.getInits(), E.getNumInits(), false, 
        Inits, $AddrOf(InitChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && !InitChanged.$star()) {
      // FIXME: Attempt to reuse the existing syntactic form of the InitListExpr
      // in some cases. We can't reuse it in general, because the syntactic and
      // semantic forms are linked, and we can't know that semantic form will
      // match even if the syntactic form does.
    }
    
    return getDerived().RebuildInitList(E.getLBraceLoc(), new MutableArrayRef<Expr /*P*/ >(Inits, true), 
        E.getRBraceLoc(), E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8238,
   FQN="clang::TreeTransform<(anonymous)::TemplateInstantiator>::TransformIntegerLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformIntegerLiteralEPNS_14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformIntegerLiteralEPNS_14IntegerLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformIntegerLiteral(IntegerLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform<TemplateInstantiator>::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10145,
   FQN="clang::TreeTransform<TemplateInstantiator>::TransformLambdaExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformLambdaExprEPNS_10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformLambdaExprEPNS_10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E)/* __attribute__((noinline))*/ {
    Sema.FunctionScopeRAII FuncScopeCleanup = null;
    Sema.ContextRAII SavedContext = null;
    LambdaScopeInfo LSICopy = null;
    try {
      // Transform any init-capture expressions before entering the scope of the
      // lambda body, because they are not semantically within that scope.
      // JAVA: typedef std::pair<ExprResult, QualType> InitCaptureInfoTy
  //    final class InitCaptureInfoTy extends std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType>{ };
      SmallVector<std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType>> InitCaptureExprsAndTypes/*J*/= new SmallVector<std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType>>(8, new std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType>(new ActionResultTTrue(), new QualType()));
      InitCaptureExprsAndTypes.resize(E.explicit_capture_end().$sub(E.explicit_capture_begin()));
      for (type$ptr<LambdaCapture> C = $tryClone(E.capture_begin()), 
          /*P*/ CEnd = $tryClone(E.capture_end());
           $noteq_ptr(C, CEnd); C.$preInc()) {
        EnterExpressionEvaluationContext EEEC = null;
        try {
          if (!E.isInitCapture($Deref(C))) {
            continue;
          }
          EEEC/*J*/= new EnterExpressionEvaluationContext(getSema(), 
              Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
          ActionResultTTrue<Expr /*P*/ > NewExprInitResult = getDerived().TransformInitializer(C./*->*/$star().getCapturedVar().getInit(), 
              C./*->*/$star().getCapturedVar().getInitStyle() == VarDecl.InitializationStyle.CallInit);
          if (NewExprInitResult.isInvalid()) {
            return SemaClangGlobals.ExprError();
          }
          type$ref<Expr /*P*/ > NewExprInit = create_type$ref(NewExprInitResult.get());

          VarDecl /*P*/ OldVD = C./*->*/$star().getCapturedVar();
          QualType NewInitCaptureType = getSema().buildLambdaInitCaptureInitialization(C./*->*/$star().getLocation(), OldVD.getType().$arrow().isReferenceType(), 
              OldVD.getIdentifier(), 
              C./*->*/$star().getCapturedVar().getInitStyle() != VarDecl.InitializationStyle.CInit, NewExprInit);
          NewExprInitResult.$assign(NewExprInit.$deref());
          InitCaptureExprsAndTypes.$at(C.$sub(E.capture_begin())).$assignMove(
              std.make_pair($Clone(NewExprInitResult), $Clone(NewInitCaptureType))
          );
        } finally {
          if (EEEC != null) { EEEC.$destroy(); }
        }
      }

      // Transform the template parameters, and add them to the current
      // instantiation scope. The null case is handled correctly.
      TemplateParameterList /*P*/ TPL = getDerived().TransformTemplateParameterList(E.getTemplateParameterList());

      // Transform the type of the original lambda's call operator.
      // The transformation MUST be done in the CurrentInstantiationScope since
      // it introduces a mapping of the original to the newly created
      // transformed parameters.
      TypeSourceInfo /*P*/ NewCallOpTSI = null;
      {
        TypeLocBuilder NewCallOpTLBuilder = null;
        try {
          TypeSourceInfo /*P*/ OldCallOpTSI = E.getCallOperator().getTypeSourceInfo();
          FunctionProtoTypeLoc OldCallOpFPTL = OldCallOpTSI.getTypeLoc().getAs(FunctionProtoTypeLoc.class);

          NewCallOpTLBuilder/*J*/= new TypeLocBuilder();
          SmallVector<QualType> ExceptionStorage/*J*/= new SmallVector<QualType>(4, new QualType());
          TreeTransform<Derived> /*P*/ This = this; // Work around gcc.gnu.org/PR56135.
          QualType NewCallOpType = TransformFunctionProtoType$TreeTransform(NewCallOpTLBuilder, new FunctionProtoTypeLoc(OldCallOpFPTL), (CXXRecordDecl /*P*/ )null, 0, 
              /*[&, &This, &OldCallOpFPTL, &ExceptionStorage]*/ (final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, final bool$ref/*bool &*/ Changed) -> {
                    return This.TransformExceptionSpec(OldCallOpFPTL.getBeginLoc(), ESI, 
                        ExceptionStorage, Changed);
                  });
          if (NewCallOpType.isNull()) {
            return SemaClangGlobals.ExprError();
          }
          NewCallOpTSI = NewCallOpTLBuilder.getTypeSourceInfo(getSema().Context, 
              new QualType(NewCallOpType));
        } finally {
          if (NewCallOpTLBuilder != null) { NewCallOpTLBuilder.$destroy(); }
        }
      }

      LambdaScopeInfo /*P*/ LSI = getSema().PushLambdaScope();
      FuncScopeCleanup/*J*/= new Sema.FunctionScopeRAII(getSema());
      LSI.GLTemplateParameterList = TPL;

      // Create the local class that will describe the lambda.
      CXXRecordDecl /*P*/ Class = getSema().createLambdaClosureType(E.getIntroducerRange(), 
          NewCallOpTSI, 
          /*KnownDependent=*/ false, 
          E.getCaptureDefault());
      getDerived().transformedLocalDecl(E.getLambdaClass(), Class);

      // Build the call operator.
      CXXMethodDecl /*P*/ NewCallOperator = getSema().startLambdaDefinition(Class, E.getIntroducerRange(), NewCallOpTSI, 
          E.getCallOperator().getLocEnd(), 
          NewCallOpTSI.getTypeLoc().castAs(FunctionProtoTypeLoc.class).getParams());
      LSI.CallOperator = NewCallOperator;

      getDerived().transformAttrs(E.getCallOperator(), NewCallOperator);
      getDerived().transformedLocalDecl(E.getCallOperator(), NewCallOperator);

      // Introduce the context of the call operator.
      SavedContext/*J*/= new Sema.ContextRAII(getSema(), NewCallOperator, 
          /*NewThisContext*/ false);

      // Enter the scope of the lambda.
      getSema().buildLambdaScope(LSI, NewCallOperator, 
          E.getIntroducerRange(), 
          E.getCaptureDefault(), 
          E.getCaptureDefaultLoc(), 
          E.hasExplicitParameters(), 
          E.hasExplicitResultType(), 
          E.isMutable());

      boolean Invalid = false;

      // Transform captures.
      boolean FinishedExplicitCaptures = false;
      for (type$ptr<LambdaCapture> C = $tryClone(E.capture_begin()), 
          /*P*/ CEnd = $tryClone(E.capture_end());
           $noteq_ptr(C, CEnd); C.$preInc()) {
        // When we hit the first implicit capture, tell Sema that we've finished
        // the list of explicit captures.
        if (!FinishedExplicitCaptures && C./*->*/$star().isImplicit()) {
          getSema().finishLambdaExplicitCaptures(LSI);
          FinishedExplicitCaptures = true;
        }

        // Capturing 'this' is trivial.
        if (C./*->*/$star().capturesThis()) {
          getSema().CheckCXXThisCapture(C./*->*/$star().getLocation(), C./*->*/$star().isExplicit(), 
              /*BuildAndDiagnose*/ true, (/*const*/uint$ptr/*uint P*/ )null, 
              C./*->*/$star().getCaptureKind() == LambdaCaptureKind.LCK_StarThis);
          continue;
        }
        // Captured expression will be recaptured during captured variables
        // rebuilding.
        if (C./*->*/$star().capturesVLAType()) {
          continue;
        }

        // Rebuild init-captures, including the implied field declaration.
        if (E.isInitCapture($Deref(C))) {
          std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType> InitExprTypePair = new std.pairTypeType<ActionResultTTrue<Expr /*P*/ >, QualType>(InitCaptureExprsAndTypes.$at(C.$sub(E.capture_begin())));
          ActionResultTTrue<Expr /*P*/ > Init = new ActionResultTTrue<Expr /*P*/ >(InitExprTypePair.first);
          QualType InitQualType = new QualType(InitExprTypePair.second);
          if (Init.isInvalid() || InitQualType.isNull()) {
            Invalid = true;
            continue;
          }
          VarDecl /*P*/ OldVD = C./*->*/$star().getCapturedVar();
          VarDecl /*P*/ NewVD = getSema().createLambdaInitCaptureVarDecl(OldVD.getLocation(), new QualType(InitExprTypePair.second), OldVD.getIdentifier(), 
              OldVD.getInitStyle().getValue(), Init.get());
          if (!(NewVD != null)) {
            Invalid = true;
          } else {
            getDerived().transformedLocalDecl(OldVD, NewVD);
          }
          getSema().buildInitCaptureField(LSI, NewVD);
          continue;
        }
        assert (C./*->*/$star().capturesVariable()) : "unexpected kind of lambda capture";

        // Determine the capture kind for Sema.
        Sema.TryCaptureKind Kind = C./*->*/$star().isImplicit() ? Sema.TryCaptureKind.TryCapture_Implicit : C./*->*/$star().getCaptureKind() == LambdaCaptureKind.LCK_ByCopy ? Sema.TryCaptureKind.TryCapture_ExplicitByVal : Sema.TryCaptureKind.TryCapture_ExplicitByRef;
        SourceLocation EllipsisLoc/*J*/= new SourceLocation();
        if (C./*->*/$star().isPackExpansion()) {
          std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> Unexpanded/*J*/
                  = new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, 
                          new PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >(JD$T1.INSTANCE, NamedDecl /*P*/.class, /*Fwd*/C./*->*/$star().getCapturedVar()), new SourceLocation(JD$Move.INSTANCE, /*Fwd*/C./*->*/$star().getLocation()));
          bool$ref ShouldExpand = create_bool$ref(false);
          bool$ref RetainExpansion = create_bool$ref(false);
          OptionalUInt NumExpansions/*J*/= new OptionalUInt();
          if (getDerived().TryExpandParameterPacks(C./*->*/$star().getEllipsisLoc(), 
              new SourceRange(C./*->*/$star().getLocation()), 
              new ArrayRef<std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
              ShouldExpand, RetainExpansion, 
              NumExpansions)) {
            Invalid = true;
            continue;
          }
          if (ShouldExpand.$deref()) {
            // The transform has determined that we should perform an expansion;
            // transform and capture each of the arguments.
            // expansion of the pattern. Do so.
            VarDecl /*P*/ Pack = C./*->*/$star().getCapturedVar();
            for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
              Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
              try {
                SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I);
                VarDecl /*P*/ CapturedVar = cast_or_null_VarDecl(getDerived().TransformDecl(C./*->*/$star().getLocation(), 
      Pack));
                if (!(CapturedVar != null)) {
                  Invalid = true;
                  continue;
                }

                // Capture the transformed variable.
                getSema().tryCaptureVariable(CapturedVar, C./*->*/$star().getLocation(), Kind);
              } finally {
                if (SubstIndex != null) { SubstIndex.$destroy(); }
              }
            }

            // FIXME: Retain a pack expansion if RetainExpansion is true.
            continue;
          }

          EllipsisLoc.$assignMove(C./*->*/$star().getEllipsisLoc());
        }

        // Transform the captured variable.
        VarDecl /*P*/ CapturedVar = cast_or_null_VarDecl(getDerived().TransformDecl(C./*->*/$star().getLocation(), 
      C./*->*/$star().getCapturedVar()));
        if (!(CapturedVar != null) || CapturedVar.isInvalidDecl()) {
          Invalid = true;
          continue;
        }

        // Capture the transformed variable.
        getSema().tryCaptureVariable(CapturedVar, C./*->*/$star().getLocation(), Kind, 
            new SourceLocation(EllipsisLoc));
      }
      if (!FinishedExplicitCaptures) {
        getSema().finishLambdaExplicitCaptures(LSI);
      }

      // Enter a new evaluation context to insulate the lambda from any
      // cleanups from the enclosing full-expression.
      getSema().PushExpressionEvaluationContext(Sema.ExpressionEvaluationContext.PotentiallyEvaluated);

      // Instantiate the body of the lambda expression.
      ActionResultTTrue<Stmt /*P*/ > Body = Invalid ? SemaClangGlobals.StmtError() : getDerived().TransformStmt(E.getBody());

      // ActOnLambda* will pop the function scope for us.
      FuncScopeCleanup.disable();
      if (Body.isInvalid()) {
        SavedContext.pop();
        getSema().ActOnLambdaError(E.getLocStart(), /*CurScope=*/ (Scope /*P*/ )null, 
            /*IsInstantiation=*/ true);
        return SemaClangGlobals.ExprError();
      }

      // Copy the LSI before ActOnFinishFunctionBody removes it.
      // FIXME: This is dumb. Store the lambda information somewhere that outlives
      // the call operator.
      LSICopy = new LambdaScopeInfo($Deref(LSI));
      getSema().ActOnFinishFunctionBody(NewCallOperator, Body.get(), 
          /*IsInstantiation*/ true);
      SavedContext.pop();

      return getSema().BuildLambdaExpr(E.getLocStart(), Body.get().getLocEnd(), 
          $AddrOf(LSICopy));
    } finally {
      if (LSICopy != null) { LSICopy.$destroy(); }
      if (SavedContext != null) { SavedContext.$destroy(); }
      if (FuncScopeCleanup != null) { FuncScopeCleanup.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7061,
   FQN="clang::TreeTransform::TransformMSPropertyRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformMSPropertyRefExprEPNS_17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformMSPropertyRefExprEPNS_17MSPropertyRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformMSPropertyRefExpr(MSPropertyRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
    if (E.getQualifierLoc().$bool()) {
      QualifierLoc.$assignMove(
          getDerived().TransformNestedNameSpecifierLoc(E.getQualifierLoc())
      );
      if (!QualifierLoc.$bool()) {
        return ExprError();
      }
    }
    
    MSPropertyDecl /*P*/ PD = cast_or_null_MSPropertyDecl(getDerived().TransformDecl(E.getMemberLoc(), E.getPropertyDecl()));
    if (!(PD != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBaseExpr());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.getASTContext())*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.getASTContext(), (type$ptr<?> New$Mem)->{
            return new MSPropertyRefExpr(Base.get(), PD, E.isArrow(), 
                    SemaRef.getASTContext().PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                    new NestedNameSpecifierLoc(QualifierLoc), E.getMemberLoc());
         }));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7087,
   FQN="clang::TreeTransform::TransformMSPropertySubscriptExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformMSPropertySubscriptExpr(MSPropertySubscriptExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > BaseRes = getDerived().TransformExpr(E.getBase());
    if (BaseRes.isInvalid()) {
      return ExprError();
    }
    ActionResultTTrue<Expr /*P*/ > IdxRes = getDerived().TransformExpr(E.getIdx());
    if (IdxRes.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && BaseRes.get() == E.getBase()
       && IdxRes.get() == E.getIdx()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildArraySubscriptExpr(BaseRes.get(), new SourceLocation(), IdxRes.get(), E.getRBracketLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10761,
   FQN="clang::TreeTransform::TransformMaterializeTemporaryExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return getDerived().TransformExpr(E.GetTemporaryExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8589,
   FQN="clang::TreeTransform::TransformMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformMemberExprEPNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformMemberExprEPNS_10MemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformMemberExpr(MemberExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TemplateArgumentListInfo TransArgs = null;
    try {
      ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
      if (Base.isInvalid()) {
        return ExprError();
      }
      
      NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
      if (E.hasQualifier()) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(E.getQualifierLoc())
        );
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
      }
      SourceLocation TemplateKWLoc = E.getTemplateKeywordLoc();
      
      ValueDecl /*P*/ Member = cast_or_null_ValueDecl(getDerived().TransformDecl(E.getMemberLoc(), 
    E.getMemberDecl()));
      if (!(Member != null)) {
        return ExprError();
      }
      
      NamedDecl /*P*/ FoundDecl = E.getFoundDecl().$NamedDecl$P();
      if (FoundDecl == E.getMemberDecl()) {
        FoundDecl = Member;
      } else {
        FoundDecl = cast_or_null_NamedDecl(getDerived().TransformDecl(E.getMemberLoc(), FoundDecl));
        if (!(FoundDecl != null)) {
          return ExprError();
        }
      }
      if (!getDerived().AlwaysRebuild()
         && Base.get() == E.getBase()
         && $eq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, E.getQualifierLoc())
         && Member == E.getMemberDecl()
         && FoundDecl == E.getFoundDecl().$NamedDecl$P()
         && !E.hasExplicitTemplateArgs()) {
        
        // Mark it referenced in the new context regardless.
        // FIXME: this is a bit instantiation-specific.
        SemaRef.MarkMemberReferenced(E);
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      TransArgs/*J*/= new TemplateArgumentListInfo();
      if (E.hasExplicitTemplateArgs()) {
        TransArgs.setLAngleLoc(E.getLAngleLoc());
        TransArgs.setRAngleLoc(E.getRAngleLoc());
        if (getDerived().TransformTemplateArguments(E.getTemplateArgs(), 
            E.getNumTemplateArgs(), 
            TransArgs)) {
          return ExprError();
        }
      }
      
      // FIXME: Bogus source location for the operator
      SourceLocation FakeOperatorLoc = SemaRef.getLocForEndOfToken(E.getBase().getSourceRange().getEnd());
      
      // FIXME: to do this check properly, we will need to preserve the
      // first-qualifier-in-scope here, just in case we had a dependent
      // base (and therefore couldn't do the check) and a
      // nested-name-qualifier (and therefore could do the lookup).
      NamedDecl /*P*/ FirstQualifierInScope = null;
      
      return getDerived().RebuildMemberExpr(Base.get(), new SourceLocation(FakeOperatorLoc), 
          E.isArrow(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          new SourceLocation(TemplateKWLoc), 
          E.getMemberNameInfo(), 
          Member, 
          FoundDecl, 
          (E.hasExplicitTemplateArgs() ? $AddrOf(TransArgs) : (TemplateArgumentListInfo /*P*/ )null), 
          FirstQualifierInScope);
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8929,
   FQN="clang::TreeTransform::TransformNoInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformNoInitExprEPNS_10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformNoInitExprEPNS_10NoInitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformNoInitExpr(NoInitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    throw new llvm_unreachable("Unexpected NoInitExpr in syntactic form of initializer");
//    return ExprError();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8531,
   FQN="clang::TreeTransform::TransformOMPArraySectionExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPArraySectionExprEPNS_19OMPArraySectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPArraySectionExprEPNS_19OMPArraySectionExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformOMPArraySectionExpr(OMPArraySectionExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > LowerBound/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((E.getLowerBound() != null)) {
      LowerBound.$assignMove(getDerived().TransformExpr(E.getLowerBound()));
      if (LowerBound.isInvalid()) {
        return ExprError();
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > Length/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((E.getLength() != null)) {
      Length.$assignMove(getDerived().TransformExpr(E.getLength()));
      if (Length.isInvalid()) {
        return ExprError();
      }
    }
    if (!getDerived().AlwaysRebuild() && Base.get() == E.getBase()
       && LowerBound.get() == E.getLowerBound() && Length.get() == E.getLength()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildOMPArraySectionExpr(Base.get(), E.getBase().getLocEnd(), LowerBound.get(), E.getColonLoc(), 
        Length.get(), E.getRBracketLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10923,
   FQN="clang::TreeTransform::TransformObjCArrayLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCArrayLiteralEPNS_16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCArrayLiteralEPNS_16ObjCArrayLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCArrayLiteral(ObjCArrayLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform each of the elements.
    SmallVector<Expr /*P*/ > Elements/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    bool$ptr ArgChanged = create_bool$ptr(false);
    if (getDerived().TransformExprs(E.getElements(), E.getNumElements(), 
        /*IsCall=*/ false, Elements, $AddrOf(ArgChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && !ArgChanged.$star()) {
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    return getDerived().RebuildObjCArrayLiteral(E.getSourceRange(), 
        Elements.data(), 
        Elements.size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11114,
   FQN="clang::TreeTransform::TransformObjCAvailabilityCheckExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34TransformObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCAvailabilityCheckExpr(ObjCAvailabilityCheckExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10903,
   FQN="clang::TreeTransform::TransformObjCBoolLiteralExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCBoolLiteralExpr(ObjCBoolLiteralExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10909,
   FQN="clang::TreeTransform::TransformObjCBoxedExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformObjCBoxedExprEPNS_13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformObjCBoxedExprEPNS_13ObjCBoxedExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCBoxedExpr(ObjCBoxedExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExpr());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildObjCBoxedExpr(E.getSourceRange(), SubExpr.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10941,
   FQN="clang::TreeTransform::TransformObjCDictionaryLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    SmallVector<ObjCDictionaryElement> Elements = null;
    try {
      // Transform each of the elements.
      Elements/*J*/= new SmallVector<ObjCDictionaryElement>(8, new ObjCDictionaryElement());
      boolean ArgChanged = false;
      for (/*uint*/int I = 0, N = E.getNumElements(); I != N; ++I) {
        ObjCDictionaryElement OrigElement = null;
        try {
          OrigElement = E.getKeyValueElement(I);
          if (OrigElement.isPackExpansion()) {
            // This key/value element is a pack expansion.
            SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
            getSema().collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(OrigElement.Key), Unexpanded);
            getSema().collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(OrigElement.Value), Unexpanded);
            assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
            
            // Determine whether the set of unexpanded parameter packs can
            // and should be expanded.
            bool$ref Expand = create_bool$ref(true);
            bool$ref RetainExpansion = create_bool$ref(false);
            OptionalUInt OrigNumExpansions = new OptionalUInt(OrigElement.NumExpansions);
            OptionalUInt NumExpansions = new OptionalUInt(OrigNumExpansions);
            SourceRange PatternRange/*J*/= new SourceRange(OrigElement.Key.getLocStart(), 
                OrigElement.Value.getLocEnd());
            if (getDerived().TryExpandParameterPacks(new SourceLocation(OrigElement.EllipsisLoc), 
                new SourceRange(PatternRange), 
                new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
                Expand, RetainExpansion, 
                NumExpansions)) {
              return ExprError();
            }
            if (!Expand.$deref()) {
              Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
              try {
                // The transform has determined that we should perform a simple
                // transformation on the pack expansion, producing another pack
                // expansion.
                SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
                ActionResultTTrue<Expr /*P*/ > Key = getDerived().TransformExpr(OrigElement.Key);
                if (Key.isInvalid()) {
                  return ExprError();
                }
                if (Key.get() != OrigElement.Key) {
                  ArgChanged = true;
                }
                
                ActionResultTTrue<Expr /*P*/ > Value = getDerived().TransformExpr(OrigElement.Value);
                if (Value.isInvalid()) {
                  return ExprError();
                }
                if (Value.get() != OrigElement.Value) {
                  ArgChanged = true;
                }
                
                ObjCDictionaryElement Expansion = new ObjCDictionaryElement(
                  Key.get(), Value.get(), OrigElement.EllipsisLoc, NumExpansions
                );
                Elements.push_back(Expansion);
                continue;
              } finally {
                if (SubstIndex != null) { SubstIndex.$destroy(); }
              }
            }
            
            // Record right away that the argument was changed.  This needs
            // to happen even if the array expands to nothing.
            ArgChanged = true;
            
            // The transform has determined that we should perform an elementwise
            // expansion of the pattern. Do so.
            for (/*uint*/int I$1 = 0; I$1 != NumExpansions.$star(); ++I$1) {
              Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
              try {
                SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), I$1);
                ActionResultTTrue<Expr /*P*/ > Key = getDerived().TransformExpr(OrigElement.Key);
                if (Key.isInvalid()) {
                  return ExprError();
                }
                
                ActionResultTTrue<Expr /*P*/ > Value = getDerived().TransformExpr(OrigElement.Value);
                if (Value.isInvalid()) {
                  return ExprError();
                }
                
                ObjCDictionaryElement Element = new ObjCDictionaryElement(
                  Key.get(), Value.get(), new SourceLocation(), NumExpansions
                );
                
                // If any unexpanded parameter packs remain, we still have a
                // pack expansion.
                // FIXME: Can this really happen?
                if (Key.get().containsUnexpandedParameterPack()
                   || Value.get().containsUnexpandedParameterPack()) {
                  Element.EllipsisLoc.$assign(OrigElement.EllipsisLoc);
                }
                
                Elements.push_back(Element);
              } finally {
                if (SubstIndex != null) { SubstIndex.$destroy(); }
              }
            }
            
            // FIXME: Retain a pack expansion if RetainExpansion is true.
            
            // We've finished with this pack expansion.
            continue;
          }
          
          // Transform and check key.
          ActionResultTTrue<Expr /*P*/ > Key = getDerived().TransformExpr(OrigElement.Key);
          if (Key.isInvalid()) {
            return ExprError();
          }
          if (Key.get() != OrigElement.Key) {
            ArgChanged = true;
          }
          
          // Transform and check value.
          ActionResultTTrue<Expr /*P*/ > Value = getDerived().TransformExpr(OrigElement.Value);
          if (Value.isInvalid()) {
            return ExprError();
          }
          if (Value.get() != OrigElement.Value) {
            ArgChanged = true;
          }
          
          ObjCDictionaryElement Element = new ObjCDictionaryElement(
            Key.get(), Value.get(), new SourceLocation(), new OptionalUInt(None)
          );
          Elements.push_back(Element);
        } finally {
          if (OrigElement != null) { OrigElement.$destroy(); }
        }
      }
      if (!getDerived().AlwaysRebuild() && !ArgChanged) {
        return SemaRef.MaybeBindToTemporary(E);
      }
      
      return getDerived().RebuildObjCDictionaryLiteral(E.getSourceRange(), 
          new MutableArrayRef<ObjCDictionaryElement>(Elements, false));
    } finally {
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11065,
   FQN="clang::TreeTransform::TransformObjCEncodeExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformObjCEncodeExprEPNS_14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformObjCEncodeExprEPNS_14ObjCEncodeExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCEncodeExpr(ObjCEncodeExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ EncodedTypeInfo = getDerived().TransformType(E.getEncodedTypeSourceInfo());
    if (!(EncodedTypeInfo != null)) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && EncodedTypeInfo == E.getEncodedTypeSourceInfo()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildObjCEncodeExpr(E.getAtLoc(), 
        EncodedTypeInfo, 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11082,
   FQN="clang::TreeTransform::TransformObjCIndirectCopyRestoreExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCIndirectCopyRestoreExpr(ObjCIndirectCopyRestoreExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // This is a kind of implicit conversion, and it needs to get dropped
    // and recomputed for the same general reasons that ImplicitCastExprs
    // do, as well a more specific one: this expression is only valid when
    // it appears *immediately* as an argument expression.
    return getDerived().TransformExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11282,
   FQN="clang::TreeTransform::TransformObjCIsaExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformObjCIsaExprEPNS_11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformObjCIsaExprEPNS_11ObjCIsaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCIsaExpr(ObjCIsaExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the base expression.
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    // If nothing changed, just retain the existing expression.
    if (!getDerived().AlwaysRebuild()
       && Base.get() == E.getBase()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildObjCIsaExpr(Base.get(), E.getIsaMemberLoc(), 
        E.getOpLoc(), 
        E.isArrow());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11206,
   FQN="clang::TreeTransform::TransformObjCIvarRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCIvarRefExprEPNS_15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCIvarRefExprEPNS_15ObjCIvarRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the base expression.
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    // We don't need to transform the ivar; it will never change.
    
    // If nothing changed, just retain the existing expression.
    if (!getDerived().AlwaysRebuild()
       && Base.get() == E.getBase()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildObjCIvarRefExpr(Base.get(), E.getDecl(), 
        E.getLocation(), 
        E.isArrow(), E.isFreeIvar());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11120,
   FQN="clang::TreeTransform::TransformObjCMessageExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCMessageExprEPNS_15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCMessageExprEPNS_15ObjCMessageExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCMessageExpr(ObjCMessageExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform arguments.
    bool$ptr ArgChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    Args.reserve(E.getNumArgs());
    if (getDerived().TransformExprs(E.getArgs(), E.getNumArgs(), false, Args, 
        $AddrOf(ArgChanged))) {
      return ExprError();
    }
    if (E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Class) {
      // Class message: transform the receiver type.
      TypeSourceInfo /*P*/ ReceiverTypeInfo = getDerived().TransformType(E.getClassReceiverTypeInfo());
      if (!(ReceiverTypeInfo != null)) {
        return ExprError();
      }
      
      // If nothing changed, just retain the existing message send.
      if (!getDerived().AlwaysRebuild()
         && ReceiverTypeInfo == E.getClassReceiverTypeInfo() && !ArgChanged.$star()) {
        return SemaRef.MaybeBindToTemporary(E);
      }
      
      // Build a new class message send.
      SmallVector<SourceLocation> SelLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
      E.getSelectorLocs(SelLocs);
      return getDerived().RebuildObjCMessageExpr_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_ObjCMethodDecl$P_SourceLocation_MutableArrayRef$Expr$P_SourceLocation(ReceiverTypeInfo, 
          E.getSelector(), 
          new ArrayRef<SourceLocation>(SelLocs, false), 
          E.getMethodDecl(), 
          E.getLeftLoc(), 
          new MutableArrayRef<Expr /*P*/ >(Args, true), 
          E.getRightLoc());
    } else if (E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperClass
       || E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance) {
      // Build a new class message send to 'super'.
      SmallVector<SourceLocation> SelLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
      E.getSelectorLocs(SelLocs);
      return getDerived().RebuildObjCMessageExpr(E.getSuperLoc(), 
          E.getSelector(), 
          new ArrayRef<SourceLocation>(SelLocs, false), 
          E.getReceiverType(), 
          E.getMethodDecl(), 
          E.getLeftLoc(), 
          new MutableArrayRef<Expr /*P*/ >(Args, true), 
          E.getRightLoc());
    }
    
    // Instance message: transform the receiver
    assert (E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance) : "Only class and instance messages may be instantiated";
    ActionResultTTrue<Expr /*P*/ > Receiver = getDerived().TransformExpr(E.getInstanceReceiver());
    if (Receiver.isInvalid()) {
      return ExprError();
    }
    
    // If nothing changed, just retain the existing message send.
    if (!getDerived().AlwaysRebuild()
       && Receiver.get() == E.getInstanceReceiver() && !ArgChanged.$star()) {
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    // Build a new instance message send.
    SmallVector<SourceLocation> SelLocs/*J*/= new SmallVector<SourceLocation>(16, new SourceLocation());
    E.getSelectorLocs(SelLocs);
    return getDerived().RebuildObjCMessageExpr_Expr$P_Selector_ArrayRef$SourceLocation_ObjCMethodDecl$P_SourceLocation_MutableArrayRef$Expr$P_SourceLocation(Receiver.get(), 
        E.getSelector(), 
        new ArrayRef<SourceLocation>(SelLocs, false), 
        E.getMethodDecl(), 
        E.getLeftLoc(), 
        new MutableArrayRef<Expr /*P*/ >(Args, true), 
        E.getRightLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11226,
   FQN="clang::TreeTransform::TransformObjCPropertyRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // 'super' and types never change. Property never changes. Just
    // retain the existing expression.
    if (!E.isObjectReceiver()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    // Transform the base expression.
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBase());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    // We don't need to transform the property; it will never change.
    
    // If nothing changed, just retain the existing expression.
    if (!getDerived().AlwaysRebuild()
       && Base.get() == E.getBase()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    if (E.isExplicitProperty()) {
      return getDerived().RebuildObjCPropertyRefExpr(Base.get(), 
          E.getExplicitProperty(), 
          E.getLocation());
    }
    
    return getDerived().RebuildObjCPropertyRefExpr(Base.get(), 
        SemaRef.Context.PseudoObjectTy.$QualType(), 
        E.getImplicitPropertyGetter(), 
        E.getImplicitPropertySetter(), 
        E.getLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11200,
   FQN="clang::TreeTransform::TransformObjCProtocolExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCProtocolExprEPNS_16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCProtocolExprEPNS_16ObjCProtocolExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCProtocolExpr(ObjCProtocolExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11194,
   FQN="clang::TreeTransform::TransformObjCSelectorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCSelectorExprEPNS_16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformObjCSelectorExprEPNS_16ObjCSelectorExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCSelectorExpr(ObjCSelectorExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10897,
   FQN="clang::TreeTransform::TransformObjCStringLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCStringLiteralEPNS_17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCStringLiteralEPNS_17ObjCStringLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCStringLiteral(ObjCStringLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return SemaRef.MaybeBindToTemporary(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11258,
   FQN="clang::TreeTransform::TransformObjCSubscriptRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCSubscriptRefExpr(ObjCSubscriptRefExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the base expression.
    ActionResultTTrue<Expr /*P*/ > Base = getDerived().TransformExpr(E.getBaseExpr());
    if (Base.isInvalid()) {
      return ExprError();
    }
    
    // Transform the key expression.
    ActionResultTTrue<Expr /*P*/ > Key = getDerived().TransformExpr(E.getKeyExpr());
    if (Key.isInvalid()) {
      return ExprError();
    }
    
    // If nothing changed, just retain the existing expression.
    if (!getDerived().AlwaysRebuild()
       && Key.get() == E.getKeyExpr() && Base.get() == E.getBaseExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildObjCSubscriptRefExpr(E.getRBracket(), 
        Base.get(), Key.get(), 
        E.getAtIndexMethodDecl(), 
        E.setAtIndexMethodDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8356,
   FQN="clang::TreeTransform::TransformOffsetOfExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformOffsetOfExprEPNS_12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformOffsetOfExprEPNS_12OffsetOfExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformOffsetOfExpr(OffsetOfExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Transform the type.
    TypeSourceInfo /*P*/ Type = getDerived().TransformType(E.getTypeSourceInfo());
    if (!(Type != null)) {
      return ExprError();
    }
    
    // Transform all of the components into components similar to what the
    // parser uses.
    // FIXME: It would be slightly more efficient in the non-dependent case to
    // just map FieldDecls, rather than requiring the rebuilder to look for
    // the fields again. However, __builtin_offsetof is rare enough in
    // template code that we don't care.
    boolean ExprChanged = false;
    /*typedef Sema::OffsetOfComponent Component*/
//    final class Component extends Sema.OffsetOfComponent{ };
    SmallVector<Sema.OffsetOfComponent> Components/*J*/= new SmallVector<Sema.OffsetOfComponent>(4, new Sema.OffsetOfComponent());
    for (/*uint*/int I = 0, N = E.getNumComponents(); I != N; ++I) {
      final /*const*/ OffsetOfNode /*&*/ ON = E.getComponent(I);
      Sema.OffsetOfComponent Comp/*J*/= new Sema.OffsetOfComponent();
      Comp.isBrackets = true;
      Comp.LocStart.$assignMove(ON.getSourceRange().getBegin());
      Comp.LocEnd.$assignMove(ON.getSourceRange().getEnd());
      switch (ON.getKind()) {
       case OffsetOfNode.Kind.Array:
        {
          Expr /*P*/ FromIndex = E.getIndexExpr(ON.getArrayExprIndex());
          ActionResultTTrue<Expr /*P*/ > Index = getDerived().TransformExpr(FromIndex);
          if (Index.isInvalid()) {
            return ExprError();
          }
          
          ExprChanged = ExprChanged || Index.get() != FromIndex;
          Comp.isBrackets = true;
          Comp.U.E = Index.get();
          break;
        }
       case OffsetOfNode.Kind.Field:
       case OffsetOfNode.Kind.Identifier:
        Comp.isBrackets = false;
        Comp.U.IdentInfo = ON.getFieldName();
        if (!(Comp.U.IdentInfo != null)) {
          continue;
        }
        
        break;
       case OffsetOfNode.Kind.Base:
        // Will be recomputed during the rebuild.
        continue;
      }
      
      Components.push_back(Comp);
    }
    
    // If nothing changed, retain the existing expression.
    if (!getDerived().AlwaysRebuild()
       && Type == E.getTypeSourceInfo()
       && !ExprChanged) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    // Build a new offsetof expression.
    return getDerived().RebuildOffsetOfExpr(E.getOperatorLoc(), Type, 
        new ArrayRef<Sema.OffsetOfComponent>(Components, false), E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8420,
   FQN="clang::TreeTransform::TransformOpaqueValueExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOpaqueValueExprEPNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOpaqueValueExprEPNS_15OpaqueValueExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformOpaqueValueExpr(OpaqueValueExpr /*P*/ E)/* __attribute__((noinline))*/ {
    assert ((!(E.getSourceExpr() != null) || getDerived().AlreadyTransformed(E.getType()))) : "opaque value expression requires transformation";
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9659,
   FQN="clang::TreeTransform::TransformUnresolvedLookupExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformUnresolvedLookupExprEPNS_20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformUnresolvedLookupExprEPNS_20UnresolvedLookupExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUnresolvedLookupExpr(UnresolvedLookupExpr /*P*/ Old)/* __attribute__((noinline))*/ {
    LookupResult R = null;
    CXXScopeSpec SS = null;
    TemplateArgumentListInfo TransArgs = null;
    try {
      R/*J*/= new LookupResult(SemaRef, Old.getName(), Old.getNameLoc(), 
          Sema.LookupNameKind.LookupOrdinaryName);
      
      // Transform all the decls.
      for (UnresolvedSetIterator I = Old.decls_begin(), 
          E = Old.decls_end(); I.$noteq(E); I.$preInc()) {
        NamedDecl /*P*/ InstD = ((/*static_cast*/NamedDecl /*P*/ )(getDerived().TransformDecl(Old.getNameLoc(), 
            I.$star())));
        if (!(InstD != null)) {
          // Silently ignore these if a UsingShadowDecl instantiated to nothing.
          // This can happen because of dependent hiding.
          if (isa_UsingShadowDecl(I.$star())) {
            continue;
          } else {
            R.clear();
            return ExprError();
          }
        }
        
        // Expand using declarations.
        if (isa_UsingDecl(InstD)) {
          UsingDecl /*P*/ UD = cast_UsingDecl(InstD);
          for (UsingShadowDecl /*P*/ I$1 : UD.shadows())  {
            R.addDecl(I$1);
          }
          continue;
        }
        
        R.addDecl(InstD);
      }
      
      // Resolve a kind, but don't do any further analysis.  If it's
      // ambiguous, the callee needs to deal with it.
      R.resolveKind();
      
      // Rebuild the nested-name qualifier, if present.
      SS/*J*/= new CXXScopeSpec();
      if (Old.getQualifierLoc().$bool()) {
        NestedNameSpecifierLoc QualifierLoc = getDerived().TransformNestedNameSpecifierLoc(Old.getQualifierLoc());
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
        
        SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      }
      if ((Old.getNamingClass() != null)) {
        CXXRecordDecl /*P*/ NamingClass = cast_or_null_CXXRecordDecl(getDerived().TransformDecl(Old.getNameLoc(), 
    Old.getNamingClass()));
        if (!(NamingClass != null)) {
          R.clear();
          return ExprError();
        }
        
        R.setNamingClass(NamingClass);
      }
      
      SourceLocation TemplateKWLoc = Old.getTemplateKeywordLoc();
      
      // If we have neither explicit template arguments, nor the template keyword,
      // it's a normal declaration name or member reference.
      if (!Old.hasExplicitTemplateArgs() && !TemplateKWLoc.isValid()) {
        NamedDecl /*P*/ D = R.<NamedDecl>getAsSingle(NamedDecl.class);
        // In a C++11 unevaluated context, an UnresolvedLookupExpr might refer to an
        // instance member. In other contexts, BuildPossibleImplicitMemberExpr will
        // give a good diagnostic.
        if ((D != null) && D.isCXXInstanceMember()) {
          return SemaRef.BuildPossibleImplicitMemberExpr(SS, new SourceLocation(TemplateKWLoc), R, 
              /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
              /*Scope=*/ (/*const*/ Scope /*P*/ )null);
        }
        
        return getDerived().RebuildDeclarationNameExpr(SS, R, Old.requiresADL());
      }
      
      // If we have template arguments, rebuild them, then rebuild the
      // templateid expression.
      TransArgs/*J*/= new TemplateArgumentListInfo(Old.getLAngleLoc(), Old.getRAngleLoc());
      if (Old.hasExplicitTemplateArgs()
         && getDerived().TransformTemplateArguments(Old.getTemplateArgs(), 
          Old.getNumTemplateArgs(), 
          TransArgs)) {
        R.clear();
        return ExprError();
      }
      
      return getDerived().RebuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, 
          Old.requiresADL(), $AddrOf(TransArgs));
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
      if (SS != null) { SS.$destroy(); }
      if (R != null) { R.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10518,
   FQN="clang::TreeTransform::TransformUnresolvedMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformUnresolvedMemberExprEPNS_20UnresolvedMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformUnresolvedMemberExprEPNS_20UnresolvedMemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUnresolvedMemberExpr(UnresolvedMemberExpr /*P*/ Old)/* __attribute__((noinline))*/ {
    LookupResult R = null;
    TemplateArgumentListInfo TransArgs = null;
    try {
      // Transform the base of the expression.
      ActionResultTTrue<Expr /*P*/ > Base/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
      QualType BaseType/*J*/= new QualType();
      if (!Old.isImplicitAccess()) {
        Base.$assignMove(getDerived().TransformExpr(Old.getBase()));
        if (Base.isInvalid()) {
          return ExprError();
        }
        Base.$assignMove(getSema().PerformMemberExprBaseConversion(Base.get(), 
                Old.isArrow()));
        if (Base.isInvalid()) {
          return ExprError();
        }
        BaseType.$assignMove(Base.get().getType());
      } else {
        BaseType.$assignMove(getDerived().TransformType(Old.getBaseType()));
      }
      
      NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
      if (Old.getQualifierLoc().$bool()) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(Old.getQualifierLoc())
        );
        if (!QualifierLoc.$bool()) {
          return ExprError();
        }
      }
      
      SourceLocation TemplateKWLoc = Old.getTemplateKeywordLoc();
      
      R/*J*/= new LookupResult(SemaRef, Old.getMemberNameInfo(), 
          Sema.LookupNameKind.LookupOrdinaryName);
      
      // Transform all the decls.
      for (UnresolvedSetIterator I = Old.decls_begin(), 
          E = Old.decls_end(); I.$noteq(E); I.$preInc()) {
        NamedDecl /*P*/ InstD = ((/*static_cast*/NamedDecl /*P*/ )(getDerived().TransformDecl(Old.getMemberLoc(), 
            I.$star())));
        if (!(InstD != null)) {
          // Silently ignore these if a UsingShadowDecl instantiated to nothing.
          // This can happen because of dependent hiding.
          if (isa_UsingShadowDecl(I.$star())) {
            continue;
          } else {
            R.clear();
            return ExprError();
          }
        }
        
        // Expand using declarations.
        if (isa_UsingDecl(InstD)) {
          UsingDecl /*P*/ UD = cast_UsingDecl(InstD);
          for (UsingShadowDecl /*P*/ I$1 : UD.shadows())  {
            R.addDecl(I$1);
          }
          continue;
        }
        
        R.addDecl(InstD);
      }
      
      R.resolveKind();
      
      // Determine the naming class.
      if ((Old.getNamingClass() != null)) {
        CXXRecordDecl /*P*/ NamingClass = cast_or_null_CXXRecordDecl(getDerived().TransformDecl(Old.getMemberLoc(), 
    Old.getNamingClass()));
        if (!(NamingClass != null)) {
          return ExprError();
        }
        
        R.setNamingClass(NamingClass);
      }
      
      TransArgs/*J*/= new TemplateArgumentListInfo();
      if (Old.hasExplicitTemplateArgs()) {
        TransArgs.setLAngleLoc(Old.getLAngleLoc());
        TransArgs.setRAngleLoc(Old.getRAngleLoc());
        if (getDerived().TransformTemplateArguments(Old.getTemplateArgs(), 
            Old.getNumTemplateArgs(),
            TransArgs)) {
          return ExprError();
        }
      }
      
      // FIXME: to do this check properly, we will need to preserve the
      // first-qualifier-in-scope here, just in case we had a dependent
      // base (and therefore couldn't do the check) and a
      // nested-name-qualifier (and therefore could do the lookup).
      NamedDecl /*P*/ FirstQualifierInScope = null;
      
      return getDerived().RebuildUnresolvedMemberExpr(Base.get(), 
          new QualType(BaseType), 
          Old.getOperatorLoc(), 
          Old.isArrow(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          new SourceLocation(TemplateKWLoc), 
          FirstQualifierInScope, 
          R, 
          (Old.hasExplicitTemplateArgs() ? $AddrOf(TransArgs) : (TemplateArgumentListInfo /*P*/ )null));
    } finally {
      if (TransArgs != null) { TransArgs.$destroy(); }
      if (R != null) { R.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10634,
   FQN="clang::TreeTransform::TransformPackExpansionExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformPackExpansionExprEPNS_17PackExpansionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformPackExpansionExprEPNS_17PackExpansionExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformPackExpansionExpr(PackExpansionExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Pattern = getDerived().TransformExpr(E.getPattern());
    if (Pattern.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && Pattern.get() == E.getPattern()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildPackExpansion(Pattern.get(), E.getEllipsisLoc(), 
        E.getNumExpansions());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8311,
   FQN="clang::TreeTransform::TransformParenExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformParenExprEPNS_9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformParenExprEPNS_9ParenExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformParenExpr(ParenExpr /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExpr());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildParenExpr(SubExpr.get(), E.getLParen(), 
        E.getRParen());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8976,
   FQN="clang::TreeTransform::TransformParenListExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformParenListExprEPNS_13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformParenListExprEPNS_13ParenListExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformParenListExpr(ParenListExpr /*P*/ E)/* __attribute__((noinline))*/ {
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > Inits/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    if (TransformExprs(E.getExprs(), E.getNumExprs(), true, Inits, 
        $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    
    return getDerived().RebuildParenListExpr(E.getLParenLoc(), 
        new MutableArrayRef<Expr /*P*/ >(Inits, true), 
        E.getRParenLoc());
  }

  
  //===----------------------------------------------------------------------===//
  // Expression transformation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8175,
   FQN="clang::TreeTransform::TransformPredefinedExpr", NM="_ZN5clang13TreeTransform23TransformPredefinedExprEPNS_14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform23TransformPredefinedExprEPNS_14PredefinedExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformPredefinedExpr(PredefinedExpr /*P*/ E)/* __attribute__((noinline))*/ {
    if (!E.isTypeDependent()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }

    return getDerived().RebuildPredefinedExpr(E.getLocation(), 
        E.getIdentType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8434,
   FQN="clang::TreeTransform::TransformPseudoObjectExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformPseudoObjectExprEPNS_16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformPseudoObjectExprEPNS_16PseudoObjectExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformPseudoObjectExpr(PseudoObjectExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Rebuild the syntactic form.  The original syntactic form has
    // opaque-value expressions in it, so strip those away and rebuild
    // the result.  This is a really awful way of doing this, but the
    // better solution (rebuilding the semantic expressions and
    // rebinding OVEs as necessary) doesn't work; we'd need
    // TreeTransform to not strip away implicit conversions.
    Expr /*P*/ newSyntacticForm = SemaRef.recreateSyntacticForm(E);
    ActionResultTTrue<Expr /*P*/ > result = getDerived().TransformExpr(newSyntacticForm);
    if (result.isInvalid()) {
      return ExprError();
    }
    
    // If that gives us a pseudo-object result back, the pseudo-object
    // expression must have been an lvalue-to-rvalue conversion which we
    // should reapply.
    if (result.get().hasPlaceholderType(BuiltinType.Kind.PseudoObject)) {
      result.$assignMove(SemaRef.checkPseudoObjectRValue(result.get()));
    }
    
    return result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11300,
   FQN="clang::TreeTransform::TransformShuffleVectorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformShuffleVectorExprEPNS_17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformShuffleVectorExprEPNS_17ShuffleVectorExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformShuffleVectorExpr(ShuffleVectorExpr /*P*/ E)/* __attribute__((noinline))*/ {
    bool$ptr ArgumentChanged = create_bool$ptr(false);
    SmallVector<Expr /*P*/ > SubExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    SubExprs.reserve(E.getNumSubExprs());
    if (getDerived().TransformExprs(E.getSubExprs(), E.getNumSubExprs(), false, 
        SubExprs, $AddrOf(ArgumentChanged))) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && !ArgumentChanged.$star()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildShuffleVectorExpr(E.getBuiltinLoc(), 
        new MutableArrayRef<Expr /*P*/ >(SubExprs, true), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10648,
   FQN="clang::TreeTransform::TransformSizeOfPackExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformSizeOfPackExprEPNS_14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformSizeOfPackExprEPNS_14SizeOfPackExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformSizeOfPackExpr(SizeOfPackExpr /*P*/ E)/* __attribute__((noinline))*/ {
    EnterExpressionEvaluationContext Unevaluated = null;
    TemplateArgumentListInfo TransformedPackArgs = null;
    try {
      // If E is not value-dependent, then nothing will change when we transform it.
      // Note: This is an instantiation-centric view.
      if (!E.isValueDependent()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      Unevaluated/*J*/= /*ParenList*/new EnterExpressionEvaluationContext(getSema(), Sema.ExpressionEvaluationContext.Unevaluated);
      
      ArrayRef<TemplateArgument> PackArgs/*J*/= new ArrayRef<TemplateArgument>(false);
      TemplateArgument ArgStorage/*J*/= new TemplateArgument();
      
      // Find the argument list to transform.
      if (E.isPartiallySubstituted()) {
        PackArgs.$assignMove(E.getPartialArguments());
      } else if (E.isValueDependent()) {
        std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> Unexpanded/*J*/= 
                new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, 
                        new PointerUnion<TemplateTypeParmType, NamedDecl>(JD$T1.INSTANCE, NamedDecl.class, E.getPack()), E.getPackLoc());
        bool$ref ShouldExpand = create_bool$ref(false);
        bool$ref RetainExpansion = create_bool$ref(false);
        OptionalUInt NumExpansions/*J*/= new OptionalUInt();
        if (getDerived().TryExpandParameterPacks(E.getOperatorLoc(), new SourceRange(E.getPackLoc()), 
            new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
            ShouldExpand, RetainExpansion, 
            NumExpansions)) {
          return ExprError();
        }
        
        // If we need to expand the pack, build a template argument from it and
        // expand that.
        if (ShouldExpand.$deref()) {
          NamedDecl /*P*/ Pack = E.getPack();
          {
            TemplateTypeParmDecl /*P*/ TTPD = dyn_cast_TemplateTypeParmDecl(Pack);
            if ((TTPD != null)) {
              ArgStorage.$assignMove(new TemplateArgument(getSema().Context.getPackExpansionType(getSema().Context.getTypeDeclType(TTPD), new OptionalUInt(None))));
            } else {
              TemplateTemplateParmDecl /*P*/ TTPD$1 = dyn_cast_TemplateTemplateParmDecl(Pack);
              if ((TTPD$1 != null)) {
                ArgStorage.$assignMove(new TemplateArgument(new TemplateName(TTPD$1), new OptionalUInt(None)));
              } else {
                ValueDecl /*P*/ VD = cast_ValueDecl(Pack);
                ActionResultTTrue<Expr /*P*/ > DRE = getSema().BuildDeclRefExpr(VD, VD.getType(), 
                    ExprValueKind.VK_RValue, E.getPackLoc());
                if (DRE.isInvalid()) {
                  return ExprError();
                }
                ArgStorage.$assignMove(new TemplateArgument(/*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new PackExpansionExpr(getSema().Context.DependentTy.$QualType(), DRE.get(), E.getPackLoc(), new OptionalUInt(None)))));
              }
            }
          }
          PackArgs.$assignMove(new ArrayRef<TemplateArgument>(ArgStorage, false));
        }
      }
      
      // If we're not expanding the pack, just transform the decl.
      if (!(PackArgs.size() != 0)) {
        NamedDecl /*P*/ Pack = cast_or_null_NamedDecl(getDerived().TransformDecl(E.getPackLoc(), E.getPack()));
        if (!(Pack != null)) {
          return ExprError();
        }
        return getDerived().RebuildSizeOfPackExpr(E.getOperatorLoc(), Pack, 
            E.getPackLoc(), 
            E.getRParenLoc(), new OptionalUInt(None), new ArrayRef<TemplateArgument>(None, false));
      }
      
      TransformedPackArgs/*J*/= new TemplateArgumentListInfo(E.getPackLoc(), 
          E.getPackLoc());
      {
        TemporaryBase Rebase = null;
        try {
          Rebase/*J*/= /*ParenList*/new TemporaryBase(Native.$star(this), E.getPackLoc(), getBaseEntity());
          /*typedef TemplateArgumentLocInventIterator<Derived, const TemplateArgument *> PackLocIterator*/
//          final class PackLocIterator extends TemplateArgumentLocInventIterator<Derived, /*const*/ TemplateArgument /*P*/ >{ };
          if (TransformTemplateArguments(new TemplateArgumentLocInventIterator<Derived, /*const*/ type$ptr<TemplateArgument> /*P*/ >(/*Deref*/this, PackArgs.begin()), 
              new TemplateArgumentLocInventIterator<Derived, /*const*/ type$ptr<TemplateArgument> /*P*/ >(/*Deref*/this, PackArgs.end()), 
              TransformedPackArgs, /*Uneval*/ true)) {
            return ExprError();
          }
        } finally {
          if (Rebase != null) { Rebase.$destroy(); }
        }
      }
      
      SmallVector<TemplateArgument> Args/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
      boolean PartialSubstitution = false;
      for (final /*const*/ TemplateArgumentLoc /*&*/ Loc : TransformedPackArgs.arguments()) {
        Args.push_back(Loc.getArgument());
        if (Loc.getArgument().isPackExpansion()) {
          PartialSubstitution = true;
        }
      }
      if (PartialSubstitution) {
        return getDerived().RebuildSizeOfPackExpr(E.getOperatorLoc(), E.getPack(), 
            E.getPackLoc(), 
            E.getRParenLoc(), new OptionalUInt(None), new ArrayRef<TemplateArgument>(Args, false));
      }
      
      return getDerived().RebuildSizeOfPackExpr(E.getOperatorLoc(), E.getPack(), 
          E.getPackLoc(), E.getRParenLoc(), 
          new OptionalUInt(JD$T$RR.INSTANCE, Args.size()), new ArrayRef<TemplateArgument>(None, false));
    } finally {
      if (TransformedPackArgs != null) { TransformedPackArgs.$destroy(); }
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9007,
   FQN="clang::TreeTransform::TransformStmtExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformStmtExprEPNS_8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformStmtExprEPNS_8StmtExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformStmtExpr(StmtExpr /*P*/ E)/* __attribute__((noinline))*/ {
    SemaRef.ActOnStartStmtExpr();
    ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformCompoundStmt(E.getSubStmt(), true);
    if (SubStmt.isInvalid()) {
      SemaRef.ActOnStmtExprError();
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && SubStmt.get() == E.getSubStmt()) {
      // Calling this an 'error' is unintuitive, but it does the right thing.
      SemaRef.ActOnStmtExprError();
      return SemaRef.MaybeBindToTemporary(E);
    }
    
    return getDerived().RebuildStmtExpr(E.getLParenLoc(), 
        SubStmt.get(), 
        E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8256,
   FQN="clang::TreeTransform::TransformStringLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformStringLiteralEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformStringLiteralEPNS_13StringLiteralE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformStringLiteral(StringLiteral /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10746,
   FQN="clang::TreeTransform::TransformSubstNonTypeTemplateParmExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE37TransformSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE37TransformSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Default behavior is to do nothing with this transformation.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 10737,
   FQN="clang::TreeTransform::TransformSubstNonTypeTemplateParmPackExpr", NM="_ZN5clang13TreeTransform41TransformSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform41TransformSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr /*P*/ E)/* __attribute__((noinline))*/ {
    // Default behavior is to do nothing with this transformation.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 9755,
   FQN="clang::TreeTransform::TransformTypeTraitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformTypeTraitExprEPNS_13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformTypeTraitExprEPNS_13TypeTraitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformTypeTraitExpr(TypeTraitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    boolean ArgChanged = false;
    SmallVector<TypeSourceInfo /*P*/ > Args/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I) {
      ForgetPartiallySubstitutedPackRAII Forget = null;
      TypeLocBuilder TLB = null;
      try {
        TypeSourceInfo /*P*/ From = E.getArg(I);
        TypeLoc FromTL = From.getTypeLoc();
        if (!FromTL.getAs(PackExpansionTypeLoc.class).$bool()) {
          TypeLocBuilder TLB$1 = null;
          try {
            TLB$1/*J*/= new TypeLocBuilder();
            TLB$1.reserve(FromTL.getFullDataSize());
            QualType To = getDerived().TransformType(TLB$1, new TypeLoc(FromTL));
            if (To.isNull()) {
              return ExprError();
            }
            if ($eq_QualType$C(To, From.getType())) {
              Args.push_back(From);
            } else {
              Args.push_back(TLB$1.getTypeSourceInfo(SemaRef.Context, new QualType(To)));
              ArgChanged = true;
            }
            continue;
          } finally {
            if (TLB$1 != null) { TLB$1.$destroy(); }
          }
        }
        
        ArgChanged = true;
        
        // We have a pack expansion. Instantiate it.
        PackExpansionTypeLoc ExpansionTL = FromTL.castAs(PackExpansionTypeLoc.class);
        TypeLoc PatternTL = ExpansionTL.getPatternLoc();
        SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
        SemaRef.collectUnexpandedParameterPacks_TypeLoc(new TypeLoc(PatternTL), Unexpanded);
        
        // Determine whether the set of unexpanded parameter packs can and should
        // be expanded.
        bool$ref Expand = create_bool$ref(true);
        bool$ref RetainExpansion = create_bool$ref(false);
        OptionalUInt OrigNumExpansions = ExpansionTL.getTypePtr().getNumExpansions();
        OptionalUInt NumExpansions = new OptionalUInt(OrigNumExpansions);
        if (getDerived().TryExpandParameterPacks(ExpansionTL.getEllipsisLoc(), 
            PatternTL.getSourceRange(), 
            new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
            Expand, RetainExpansion, 
            NumExpansions)) {
          return ExprError();
        }
        if (!Expand.$deref()) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          TypeLocBuilder TLB$1 = null;
          try {
            // The transform has determined that we should perform a simple
            // transformation on the pack expansion, producing another pack
            // expansion.
            SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(getSema(), -1);
            
            TLB$1/*J*/= new TypeLocBuilder();
            TLB$1.reserve(From.getTypeLoc().getFullDataSize());
            
            QualType To = getDerived().TransformType(TLB$1, new TypeLoc(PatternTL));
            if (To.isNull()) {
              return ExprError();
            }
            
            To.$assignMove(getDerived().RebuildPackExpansionType(new QualType(To), 
                    PatternTL.getSourceRange(), 
                    ExpansionTL.getEllipsisLoc(), 
                    new OptionalUInt(NumExpansions)));
            if (To.isNull()) {
              return ExprError();
            }
            
            PackExpansionTypeLoc ToExpansionTL = TLB$1.push(PackExpansionTypeLoc.class, new QualType(To));
            ToExpansionTL.setEllipsisLoc(ExpansionTL.getEllipsisLoc());
            Args.push_back(TLB$1.getTypeSourceInfo(SemaRef.Context, new QualType(To)));
            continue;
          } finally {
            if (TLB$1 != null) { TLB$1.$destroy(); }
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        
        // Expand the pack expansion by substituting for each argument in the
        // pack(s).
        for (/*uint*/int I$1 = 0; I$1 != NumExpansions.$star(); ++I$1) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          TypeLocBuilder TLB$1 = null;
          try {
            SubstIndex/*J*/= /*ParenList*/new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, I$1);
            TLB$1/*J*/= new TypeLocBuilder();
            TLB$1.reserve(PatternTL.getFullDataSize());
            QualType To = getDerived().TransformType(TLB$1, new TypeLoc(PatternTL));
            if (To.isNull()) {
              return ExprError();
            }
            if (To.$arrow().containsUnexpandedParameterPack()) {
              To.$assignMove(getDerived().RebuildPackExpansionType(new QualType(To), 
                      PatternTL.getSourceRange(), 
                      ExpansionTL.getEllipsisLoc(), 
                      new OptionalUInt(NumExpansions)));
              if (To.isNull()) {
                return ExprError();
              }
              
              PackExpansionTypeLoc ToExpansionTL = TLB$1.push(PackExpansionTypeLoc.class, new QualType(To));
              ToExpansionTL.setEllipsisLoc(ExpansionTL.getEllipsisLoc());
            }
            
            Args.push_back(TLB$1.getTypeSourceInfo(SemaRef.Context, new QualType(To)));
          } finally {
            if (TLB$1 != null) { TLB$1.$destroy(); }
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        if (!RetainExpansion.$deref()) {
          continue;
        }
        
        // If we're supposed to retain a pack expansion, do so by temporarily
        // forgetting the partially-substituted parameter pack.
        Forget/*J*/= /*ParenList*/new ForgetPartiallySubstitutedPackRAII(getDerived());
        
        TLB/*J*/= new TypeLocBuilder();
        TLB.reserve(From.getTypeLoc().getFullDataSize());
        
        QualType To = getDerived().TransformType(TLB, new TypeLoc(PatternTL));
        if (To.isNull()) {
          return ExprError();
        }
        
        To.$assignMove(getDerived().RebuildPackExpansionType(new QualType(To), 
                PatternTL.getSourceRange(), 
                ExpansionTL.getEllipsisLoc(), 
                new OptionalUInt(NumExpansions)));
        if (To.isNull()) {
          return ExprError();
        }
        
        PackExpansionTypeLoc ToExpansionTL = TLB.push(PackExpansionTypeLoc.class, new QualType(To));
        ToExpansionTL.setEllipsisLoc(ExpansionTL.getEllipsisLoc());
        Args.push_back(TLB.getTypeSourceInfo(SemaRef.Context, new QualType(To)));
      } finally {
        if (TLB != null) { TLB.$destroy(); }
        if (Forget != null) { Forget.$destroy(); }
      }
    }
    if (!getDerived().AlwaysRebuild() && !ArgChanged) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildTypeTrait(E.getTrait(), 
        E.getLocStart(), 
        new ArrayRef<TypeSourceInfo /*P*/ >(Args, true), 
        E.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8428,
   FQN="clang::TreeTransform::TransformTypoExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformTypoExprEPNS_8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformTypoExprEPNS_8TypoExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformTypoExpr(TypoExpr /*P*/ E)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8456,
   FQN="clang::TreeTransform::TransformUnaryExprOrTypeTraitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E)/* __attribute__((noinline))*/ {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      if (E.isArgumentType()) {
        TypeSourceInfo /*P*/ OldT = E.getArgumentTypeInfo();
        
        TypeSourceInfo /*P*/ NewT = getDerived().TransformType(OldT);
        if (!(NewT != null)) {
          return ExprError();
        }
        if (!getDerived().AlwaysRebuild() && OldT == NewT) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        
        return getDerived().RebuildUnaryExprOrTypeTrait(NewT, E.getOperatorLoc(), 
            E.getKind(), 
            E.getSourceRange());
      }
      
      // C++0x [expr.sizeof]p1:
      //   The operand is either an expression, which is an unevaluated operand
      //   [...]
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      
      // Try to recover if we have something like sizeof(T::X) where X is a type.
      // Notably, there must be *exactly* one set of parens if X is a type.
      type$ptr<TypeSourceInfo /*P*/ > RecoveryTSI = create_type$null$ptr(null);
      ActionResultTTrue<Expr /*P*/ > SubExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E.getArgumentExpr());
      {
        DependentScopeDeclRefExpr /*P*/ DRE = (PE != null) ? dyn_cast_DependentScopeDeclRefExpr(PE.getSubExpr()) : null;
        if ((DRE != null)) {
          SubExpr.$assignMove(getDerived().TransformParenDependentScopeDeclRefExpr(PE, DRE, false, $AddrOf(RecoveryTSI)));
        } else {
          SubExpr.$assignMove(getDerived().TransformExpr(E.getArgumentExpr()));
        }
      }
      if ((RecoveryTSI.$star() != null)) {
        return getDerived().RebuildUnaryExprOrTypeTrait(RecoveryTSI.$star(), E.getOperatorLoc(), E.getKind(), E.getSourceRange());
      } else if (SubExpr.isInvalid()) {
        return ExprError();
      }
      if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getArgumentExpr()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      return getDerived().RebuildUnaryExprOrTypeTrait(SubExpr.get(), 
          E.getOperatorLoc(), 
          E.getKind(), 
          E.getSourceRange());
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8337,
   FQN="clang::TreeTransform::TransformUnaryOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformUnaryOperatorEPNS_13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformUnaryOperatorEPNS_13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUnaryOperator(UnaryOperator /*P*/ E)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > SubExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (E.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
      SubExpr.$assignMove(TransformAddressOfOperand(E.getSubExpr()));
    } else {
      SubExpr.$assignMove(TransformExpr(E.getSubExpr()));
    }
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild() && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildUnaryOperator(E.getOperatorLoc(), 
        E.getOpcode(), 
        SubExpr.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8956,
   FQN="clang::TreeTransform::TransformVAArgExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformVAArgExprEPNS_9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformVAArgExprEPNS_9VAArgExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformVAArgExpr(VAArgExpr /*P*/ E)/* __attribute__((noinline))*/ {
    TypeSourceInfo /*P*/ TInfo = getDerived().TransformType(E.getWrittenTypeInfo());
    if (!(TInfo != null)) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > SubExpr = getDerived().TransformExpr(E.getSubExpr());
    if (SubExpr.isInvalid()) {
      return ExprError();
    }
    if (!getDerived().AlwaysRebuild()
       && TInfo == E.getWrittenTypeInfo()
       && SubExpr.get() == E.getSubExpr()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getDerived().RebuildVAArgExpr(E.getBuiltinLoc(), SubExpr.get(), 
        TInfo, E.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6396,
   FQN="clang::TreeTransform::TransformForStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16TransformForStmtEPNS_7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16TransformForStmtEPNS_7ForStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformForStmt(ForStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the initialization statement
    ActionResultTTrue<Stmt /*P*/ > Init = getDerived().TransformStmt(S.getInit());
    if (Init.isInvalid()) {
      return StmtError();
    }
    
    // In OpenMP loop region loop control variable must be captured and be
    // private. Perform analysis of first part (if any).
    if ((getSema().getLangOpts().OpenMP != 0) && Init.isUsable()) {
      getSema().ActOnOpenMPLoopInitialization(S.getForLoc(), Init.get());
    }
    
    // Transform the condition
    Sema.ConditionResult Cond = getDerived().TransformCondition(S.getForLoc(), S.getConditionVariable(), S.getCond(), 
        Sema.ConditionKind.Boolean);
    if (Cond.isInvalid()) {
      return StmtError();
    }
    
    // Transform the increment
    ActionResultTTrue<Expr /*P*/ > Inc = getDerived().TransformExpr(S.getInc());
    if (Inc.isInvalid()) {
      return StmtError();
    }
    
    Sema.FullExprArg FullInc/*J*/= /*ParenList*/getSema().MakeFullDiscardedValueExpr(Inc.get());
    if ((S.getInc() != null) && !(FullInc.get() != null)) {
      return StmtError();
    }
    
    // Transform the body
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    if (!getDerived().AlwaysRebuild()
       && Init.get() == S.getInit()
       && $eq_pair$_T1$_T2$C(Cond.get(), std.make_pair_Ptr_Ptr(S.getConditionVariable(), S.getCond()))
       && Inc.get() == S.getInc()
       && Body.get() == S.getBody()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildForStmt(S.getForLoc(), S.getLParenLoc(), 
        Init.get(), new Sema.ConditionResult(Cond), new Sema.FullExprArg(FullInc), 
        S.getRParenLoc(), Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6442,
   FQN="clang::TreeTransform::TransformGotoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformGotoStmtEPNS_8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformGotoStmtEPNS_8GotoStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformGotoStmt(GotoStmt /*P*/ S)/* __attribute__((noinline))*/ {
    Decl /*P*/ LD = getDerived().TransformDecl(S.getLabel().getLocation(), 
        S.getLabel());
    if (!(LD != null)) {
      return StmtError();
    }
    
    // Goto statements must always be rebuilt, to resolve the label.
    return getDerived().RebuildGotoStmt(S.getGotoLoc(), S.getLabelLoc(), 
        cast_LabelDecl(LD));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6267,
   FQN="clang::TreeTransform::TransformIfStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15TransformIfStmtEPNS_6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15TransformIfStmtEPNS_6IfStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformIfStmt(IfStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the initialization statement
    ActionResultTTrue<Stmt /*P*/ > Init = getDerived().TransformStmt(S.getInit());
    if (Init.isInvalid()) {
      return StmtError();
    }
    
    // Transform the condition
    Sema.ConditionResult Cond = getDerived().TransformCondition(S.getIfLoc(), S.getConditionVariable(), S.getCond(), 
        S.isConstexpr() ? Sema.ConditionKind.ConstexprIf : Sema.ConditionKind.Boolean);
    if (Cond.isInvalid()) {
      return StmtError();
    }
    
    // If this is a constexpr if, determine which arm we should instantiate.
    OptionalBool ConstexprConditionValue/*J*/= new OptionalBool();
    if (S.isConstexpr()) {
      ConstexprConditionValue.$assignMove(Cond.getKnownValue());
    }
    
    // Transform the "then" branch.
    ActionResultTTrue<Stmt /*P*/ > Then/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if (!ConstexprConditionValue.$bool() || ConstexprConditionValue.$star()) {
      Then.$assignMove(getDerived().TransformStmt(S.getThen()));
      if (Then.isInvalid()) {
        return StmtError();
      }
    } else {
      Then.$assign(/*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new NullStmt(S.getThen().getLocStart())));
    }
    
    // Transform the "else" branch.
    ActionResultTTrue<Stmt /*P*/ > Else/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if (!ConstexprConditionValue.$bool() || !ConstexprConditionValue.$star()) {
      Else.$assignMove(getDerived().TransformStmt(S.getElse()));
      if (Else.isInvalid()) {
        return StmtError();
      }
    }
    if (!getDerived().AlwaysRebuild()
       && Init.get() == S.getInit()
       && $eq_pair$_T1$_T2$C(Cond.get(), std.make_pair_Ptr_Ptr(S.getConditionVariable(), S.getCond()))
       && Then.get() == S.getThen()
       && Else.get() == S.getElse()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildIfStmt(S.getIfLoc(), S.isConstexpr(), new Sema.ConditionResult(Cond), 
        Init.get(), Then.get(), S.getElseLoc(), 
        Else.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6455,
   FQN="clang::TreeTransform::TransformIndirectGotoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformIndirectGotoStmtEPNS_16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformIndirectGotoStmtEPNS_16IndirectGotoStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformIndirectGotoStmt(IndirectGotoStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Target = getDerived().TransformExpr(S.getTarget());
    if (Target.isInvalid()) {
      return StmtError();
    }
    Target.$assign(SemaRef.MaybeCreateExprWithCleanups(Target.get()));
    if (!getDerived().AlwaysRebuild()
       && Target.get() == S.getTarget()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildIndirectGotoStmt(S.getGotoLoc(), S.getStarLoc(), 
        Target.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6208,
   FQN="clang::TreeTransform::TransformLabelStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformLabelStmtEPNS_9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformLabelStmtEPNS_9LabelStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformLabelStmt(LabelStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformStmt(S.getSubStmt());
    if (SubStmt.isInvalid()) {
      return StmtError();
    }
    
    Decl /*P*/ LD = getDerived().TransformDecl(S.getDecl().getLocation(), 
        S.getDecl());
    if (!(LD != null)) {
      return StmtError();
    }
    
    // FIXME: Pass the real colon location in.
    return getDerived().RebuildLabelStmt(S.getIdentLoc(), 
        cast_LabelDecl(LD), new SourceLocation(), 
        SubStmt.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6992,
   FQN="clang::TreeTransform::TransformMSDependentExistsStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformMSDependentExistsStmtEPNS_21MSDependentExistsStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformMSDependentExistsStmtEPNS_21MSDependentExistsStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformMSDependentExistsStmt(MSDependentExistsStmt /*P*/ S)/* __attribute__((noinline))*/ {
    CXXScopeSpec SS = null;
    try {
      // Transform the nested-name-specifier, if any.
      NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
      if (S.getQualifierLoc().$bool()) {
        QualifierLoc.$assignMove(
            getDerived().TransformNestedNameSpecifierLoc(S.getQualifierLoc())
        );
        if (!QualifierLoc.$bool()) {
          return StmtError();
        }
      }
      
      // Transform the declaration name.
      DeclarationNameInfo NameInfo = S.getNameInfo();
      if (NameInfo.getName().$bool()) {
        NameInfo.$assignMove(getDerived().TransformDeclarationNameInfo(NameInfo));
        if (!NameInfo.getName().$bool()) {
          return StmtError();
        }
      }
      
      // Check whether anything changed.
      if (!getDerived().AlwaysRebuild()
         && $eq_NestedNameSpecifierLoc(/*NO_COPY*/QualifierLoc, S.getQualifierLoc())
         && $eq_DeclarationName(NameInfo.getName(), S.getNameInfo().getName())) {
        return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
      }
      
      // Determine whether this name exists, if we can.
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      boolean Dependent = false;
      switch (getSema().CheckMicrosoftIfExistsSymbol(/*S=*/ (Scope /*P*/ )null, SS, NameInfo)) {
       case IER_Exists:
        if (S.isIfExists()) {
          break;
        }
        
        return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new NullStmt(S.getKeywordLoc())));
       case IER_DoesNotExist:
        if (S.isIfNotExists()) {
          break;
        }
        
        return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new NullStmt(S.getKeywordLoc())));
       case IER_Dependent:
        Dependent = true;
        break;
       case IER_Error:
        return StmtError();
      }
      
      // We need to continue with the instantiation, so do so now.
      ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformCompoundStmt(S.getSubStmt());
      if (SubStmt.isInvalid()) {
        return StmtError();
      }
      
      // If we have resolved the name, just transform to the substatement.
      if (!Dependent) {
        return SubStmt;
      }
      
      // The name is still dependent, so build a dependent expression again.
      return getDerived().RebuildMSDependentExistsStmt(S.getKeywordLoc(), 
          S.isIfExists(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          new DeclarationNameInfo(NameInfo), 
          SubStmt.get());
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Statement transformation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6103,
   FQN="clang::TreeTransform::TransformNullStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformNullStmtEPNS_8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformNullStmtEPNS_8NullStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformNullStmt(NullStmt /*P*/ S)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPAtomicDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7430,
   FQN="clang::TreeTransform::TransformOMPAtomicDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPAtomicDirective(OMPAtomicDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_atomic, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPBarrierDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7375,
   FQN="clang::TreeTransform::TransformOMPBarrierDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPBarrierDirective(OMPBarrierDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_barrier, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCancelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7540,
   FQN="clang::TreeTransform::TransformOMPCancelDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPCancelDirectiveEPNS_18OMPCancelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPCancelDirectiveEPNS_18OMPCancelDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPCancelDirective(OMPCancelDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_cancel, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7529,
   FQN="clang::TreeTransform::TransformOMPCancellationPointDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPCancellationPointDirective(OMPCancellationPointDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_cancellation_point, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7310,
   FQN="clang::TreeTransform::TransformOMPCriticalDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPCriticalDirective(OMPCriticalDirective /*P*/ D)/* __attribute__((noinline))*/ {
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_critical, D.getDirectiveName(), (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPFlushDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7408,
   FQN="clang::TreeTransform::TransformOMPFlushDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPFlushDirectiveEPNS_17OMPFlushDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPFlushDirectiveEPNS_17OMPFlushDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPFlushDirective(OMPFlushDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_flush, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDistributeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7573,
   FQN="clang::TreeTransform::TransformOMPDistributeDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPDistributeDirective(OMPDistributeDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_distribute, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7584,
   FQN="clang::TreeTransform::TransformOMPDistributeParallelForDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42TransformOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42TransformOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPDistributeParallelForDirective(OMPDistributeParallelForDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_distribute_parallel_for, DirName, (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7595,
   FQN="clang::TreeTransform::TransformOMPDistributeParallelForSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE46TransformOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE46TransformOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPDistributeParallelForSimdDirective(OMPDistributeParallelForSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd, DirName, (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7607,
   FQN="clang::TreeTransform::TransformOMPDistributeSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPDistributeSimdDirective(OMPDistributeSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_distribute_simd, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7244,
   FQN="clang::TreeTransform::TransformOMPForDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPForDirectiveEPNS_15OMPForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPForDirectiveEPNS_15OMPForDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPForDirective(OMPForDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_for, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7255,
   FQN="clang::TreeTransform::TransformOMPForSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPForSimdDirective(OMPForSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_for_simd, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7320,
   FQN="clang::TreeTransform::TransformOMPParallelForDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPParallelForDirective(OMPParallelForDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_parallel_for, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7331,
   FQN="clang::TreeTransform::TransformOMPParallelForSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPParallelForSimdDirective(OMPParallelForSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_parallel_for_simd, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7233,
   FQN="clang::TreeTransform::TransformOMPSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSimdDirectiveEPNS_16OMPSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSimdDirectiveEPNS_16OMPSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPSimdDirective(OMPSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_simd, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7618,
   FQN="clang::TreeTransform::TransformOMPTargetParallelForSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42TransformOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42TransformOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetParallelForSimdDirective(OMPTargetParallelForSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_parallel_for_simd, 
        DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7551,
   FQN="clang::TreeTransform::TransformOMPTaskLoopDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskLoopDirective(OMPTaskLoopDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_taskloop, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7562,
   FQN="clang::TreeTransform::TransformOMPTaskLoopSimdDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskLoopSimdDirective(OMPTaskLoopSimdDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_taskloop_simd, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPMasterDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7299,
   FQN="clang::TreeTransform::TransformOMPMasterDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPMasterDirectiveEPNS_18OMPMasterDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPMasterDirectiveEPNS_18OMPMasterDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPMasterDirective(OMPMasterDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_master, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPOrderedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7419,
   FQN="clang::TreeTransform::TransformOMPOrderedDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPOrderedDirective(OMPOrderedDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_ordered, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7222,
   FQN="clang::TreeTransform::TransformOMPParallelDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPParallelDirectiveEPNS_20OMPParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPParallelDirectiveEPNS_20OMPParallelDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPParallelDirective(OMPParallelDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_parallel, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7342,
   FQN="clang::TreeTransform::TransformOMPParallelSectionsDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE37TransformOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE37TransformOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPParallelSectionsDirective(OMPParallelSectionsDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_parallel_sections, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7277,
   FQN="clang::TreeTransform::TransformOMPSectionDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPSectionDirectiveEPNS_19OMPSectionDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPSectionDirectiveEPNS_19OMPSectionDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPSectionDirective(OMPSectionDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_section, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7266,
   FQN="clang::TreeTransform::TransformOMPSectionsDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPSectionsDirective(OMPSectionsDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_sections, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSingleDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7288,
   FQN="clang::TreeTransform::TransformOMPSingleDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPSingleDirectiveEPNS_18OMPSingleDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPSingleDirectiveEPNS_18OMPSingleDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPSingleDirective(OMPSingleDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_single, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7452,
   FQN="clang::TreeTransform::TransformOMPTargetDataDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetDataDirective(OMPTargetDataDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_data, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7441,
   FQN="clang::TreeTransform::TransformOMPTargetDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPTargetDirectiveEPNS_18OMPTargetDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPTargetDirectiveEPNS_18OMPTargetDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetDirective(OMPTargetDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7463,
   FQN="clang::TreeTransform::TransformOMPTargetEnterDataDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE36TransformOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetEnterDataDirective(OMPTargetEnterDataDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_enter_data, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7474,
   FQN="clang::TreeTransform::TransformOMPTargetExitDataDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetExitDataDirective(OMPTargetExitDataDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_exit_data, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7485,
   FQN="clang::TreeTransform::TransformOMPTargetParallelDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE35TransformOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetParallelDirective(OMPTargetParallelDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_parallel, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7496,
   FQN="clang::TreeTransform::TransformOMPTargetParallelForDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE38TransformOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetParallelForDirective(OMPTargetParallelForDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_parallel_for, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7507,
   FQN="clang::TreeTransform::TransformOMPTargetUpdateDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33TransformOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTargetUpdateDirective(OMPTargetUpdateDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_target_update, DirName, 
        (Scope /*P*/ )null, D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7353,
   FQN="clang::TreeTransform::TransformOMPTaskDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPTaskDirectiveEPNS_16OMPTaskDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPTaskDirectiveEPNS_16OMPTaskDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskDirective(OMPTaskDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_task, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7397,
   FQN="clang::TreeTransform::TransformOMPTaskgroupDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskgroupDirective(OMPTaskgroupDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_taskgroup, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7386,
   FQN="clang::TreeTransform::TransformOMPTaskwaitDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskwaitDirective(OMPTaskwaitDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_taskwait, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7364,
   FQN="clang::TreeTransform::TransformOMPTaskyieldDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTaskyieldDirective(OMPTaskyieldDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_taskyield, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPTeamsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7518,
   FQN="clang::TreeTransform::TransformOMPTeamsDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformOMPTeamsDirective(OMPTeamsDirective /*P*/ D)/* __attribute__((noinline))*/ {
    DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
    getDerived().getSema().StartOpenMPDSABlock(OpenMPDirectiveKind.OMPD_teams, DirName, (Scope /*P*/ )null, 
        D.getLocStart());
    ActionResultTTrue<Stmt /*P*/ > Res = getDerived().TransformOMPExecutableDirective(D);
    getDerived().getSema().EndOpenMPDSABlock(Res.get());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6705,
   FQN="clang::TreeTransform::TransformObjCAtCatchStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the @catch parameter, if there is one.
    VarDecl /*P*/ Var = null;
    {
      VarDecl /*P*/ FromVar = S.getCatchParamDecl();
      if ((FromVar != null)) {
        TypeSourceInfo /*P*/ TSInfo = null;
        if ((FromVar.getTypeSourceInfo() != null)) {
          TSInfo = getDerived().TransformType(FromVar.getTypeSourceInfo());
          if (!(TSInfo != null)) {
            return StmtError();
          }
        }
        
        QualType T/*J*/= new QualType();
        if ((TSInfo != null)) {
          T.$assignMove(TSInfo.getType());
        } else {
          T.$assignMove(getDerived().TransformType(FromVar.getType()));
          if (T.isNull()) {
            return StmtError();
          }
        }
        
        Var = getDerived().RebuildObjCExceptionDecl(FromVar, TSInfo, new QualType(T));
        if (!(Var != null)) {
          return StmtError();
        }
      }
    }
    
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getCatchBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    return getDerived().RebuildObjCAtCatchStmt(S.getAtCatchLoc(), 
        S.getRParenLoc(), 
        Var, Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6741,
   FQN="clang::TreeTransform::TransformObjCAtFinallyStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the body.
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getFinallyBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // If nothing changed, just retain this statement.
    if (!getDerived().AlwaysRebuild()
       && Body.get() == S.getFinallyBody()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Build a new statement.
    return getDerived().RebuildObjCAtFinallyStmt(S.getAtFinallyLoc(), 
        Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6776,
   FQN="clang::TreeTransform::TransformObjCAtSynchronizedStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31TransformObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the object we are locking.
    ActionResultTTrue<Expr /*P*/ > Object = getDerived().TransformExpr(S.getSynchExpr());
    if (Object.isInvalid()) {
      return StmtError();
    }
    Object.$assignMove(
        getDerived().RebuildObjCAtSynchronizedOperand(S.getAtSynchronizedLoc(), 
            Object.get())
    );
    if (Object.isInvalid()) {
      return StmtError();
    }
    
    // Transform the body.
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getSynchBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // If nothing change, just retain the current statement.
    if (!getDerived().AlwaysRebuild()
       && Object.get() == S.getSynchExpr()
       && Body.get() == S.getSynchBody()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Build a new statement.
    return getDerived().RebuildObjCAtSynchronizedStmt(S.getAtSynchronizedLoc(), 
        Object.get(), Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6759,
   FQN="clang::TreeTransform::TransformObjCAtThrowStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Operand/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((S.getThrowExpr() != null)) {
      Operand.$assignMove(getDerived().TransformExpr(S.getThrowExpr()));
      if (Operand.isInvalid()) {
        return StmtError();
      }
    }
    if (!getDerived().AlwaysRebuild()
       && Operand.get() == S.getThrowExpr()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildObjCAtThrowStmt(S.getThrowLoc(), Operand.get());
  }

  
  // Objective-C Statements.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6665,
   FQN="clang::TreeTransform::TransformObjCAtTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformObjCAtTryStmtEPNS_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformObjCAtTryStmtEPNS_13ObjCAtTryStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAtTryStmt(ObjCAtTryStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the body of the @try.
    ActionResultTTrue<Stmt /*P*/ > TryBody = getDerived().TransformStmt(S.getTryBody());
    if (TryBody.isInvalid()) {
      return StmtError();
    }
    
    // Transform the @catch statements (if present).
    boolean AnyCatchChanged = false;
    SmallVector<Stmt /*P*/ > CatchStmts/*J*/= new SmallVector<Stmt /*P*/ >(8, (Stmt /*P*/ )null);
    for (/*uint*/int I = 0, N = S.getNumCatchStmts(); I != N; ++I) {
      ActionResultTTrue<Stmt /*P*/ > Catch = getDerived().TransformStmt(S.getCatchStmt(I));
      if (Catch.isInvalid()) {
        return StmtError();
      }
      if (Catch.get() != S.getCatchStmt(I)) {
        AnyCatchChanged = true;
      }
      CatchStmts.push_back(Catch.get());
    }
    
    // Transform the @finally statement (if present).
    ActionResultTTrue<Stmt /*P*/ > Finally/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ((S.getFinallyStmt() != null)) {
      Finally.$assignMove(getDerived().TransformStmt(S.getFinallyStmt()));
      if (Finally.isInvalid()) {
        return StmtError();
      }
    }
    
    // If nothing changed, just retain this statement.
    if (!getDerived().AlwaysRebuild()
       && TryBody.get() == S.getTryBody()
       && !AnyCatchChanged
       && Finally.get() == S.getFinallyStmt()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Build a new statement.
    return getDerived().RebuildObjCAtTryStmt(S.getAtTryLoc(), TryBody.get(), 
        new MutableArrayRef<Stmt /*P*/ >(CatchStmts, true), Finally.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6806,
   FQN="clang::TreeTransform::TransformObjCAutoreleasePoolStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32TransformObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the body.
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getSubStmt());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // If nothing changed, just retain this statement.
    if (!getDerived().AlwaysRebuild()
       && Body.get() == S.getSubStmt()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Build a new statement.
    return getDerived().RebuildObjCAutoreleasePoolStmt(S.getAtLoc(), Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6825,
   FQN="clang::TreeTransform::TransformObjCForCollectionStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the element statement.
    ActionResultTTrue<Stmt /*P*/ > Element = getDerived().TransformStmt(S.getElement());
    if (Element.isInvalid()) {
      return StmtError();
    }
    
    // Transform the collection expression.
    ActionResultTTrue<Expr /*P*/ > Collection = getDerived().TransformExpr(S.getCollection());
    if (Collection.isInvalid()) {
      return StmtError();
    }
    
    // Transform the body.
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // If nothing changed, just retain this statement.
    if (!getDerived().AlwaysRebuild()
       && Element.get() == S.getElement()
       && Collection.get() == S.getCollection()
       && Body.get() == S.getBody()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    // Build a new statement.
    return getDerived().RebuildObjCForCollectionStmt(S.getForLoc(), 
        Element.get(), 
        Collection.get(), 
        S.getRParenLoc(), 
        Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6483,
   FQN="clang::TreeTransform::TransformReturnStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformReturnStmtEPNS_10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformReturnStmtEPNS_10ReturnStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformReturnStmt(ReturnStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Result = getDerived().TransformInitializer(S.getRetValue(), 
        /*NotCopyInit*/ false);
    if (Result.isInvalid()) {
      return StmtError();
    }
    
    // FIXME: We always rebuild the return statement because there is no way
    // to tell whether the return type of the function has changed.
    return getDerived().RebuildReturnStmt(S.getReturnLoc(), Result.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7133,
   FQN="clang::TreeTransform::TransformSEHExceptStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformSEHExceptStmtEPNS_13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformSEHExceptStmtEPNS_13SEHExceptStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSEHExceptStmt(SEHExceptStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > FilterExpr = getDerived().TransformExpr(S.getFilterExpr());
    if (FilterExpr.isInvalid()) {
      return StmtError();
    }
    
    ActionResultTTrue<Stmt /*P*/ > Block = getDerived().TransformCompoundStmt(S.getBlock());
    if (Block.isInvalid()) {
      return StmtError();
    }
    
    return getDerived().RebuildSEHExceptStmt(S.getExceptLoc(), FilterExpr.get(), 
        Block.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7124,
   FQN="clang::TreeTransform::TransformSEHFinallyStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformSEHFinallyStmtEPNS_14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformSEHFinallyStmtEPNS_14SEHFinallyStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSEHFinallyStmt(SEHFinallyStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Stmt /*P*/ > Block = getDerived().TransformCompoundStmt(S.getBlock());
    if (Block.isInvalid()) {
      return StmtError();
    }
    
    return getDerived().RebuildSEHFinallyStmt(S.getFinallyLoc(), Block.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSEHLeaveStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7155,
   FQN="clang::TreeTransform::TransformSEHLeaveStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformSEHLeaveStmtEPNS_12SEHLeaveStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformSEHLeaveStmtEPNS_12SEHLeaveStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSEHLeaveStmt(SEHLeaveStmt /*P*/ S)/* __attribute__((noinline))*/ {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7106,
   FQN="clang::TreeTransform::TransformSEHTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSEHTryStmtEPNS_10SEHTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSEHTryStmtEPNS_10SEHTryStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSEHTryStmt(SEHTryStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Stmt /*P*/ > TryBlock = getDerived().TransformCompoundStmt(S.getTryBlock());
    if (TryBlock.isInvalid()) {
      return StmtError();
    }
    
    ActionResultTTrue<Stmt /*P*/ > Handler = getDerived().TransformSEHHandler(S.getHandler());
    if (Handler.isInvalid()) {
      return StmtError();
    }
    if (!getDerived().AlwaysRebuild() && TryBlock.get() == S.getTryBlock()
       && Handler.get() == S.getHandler()) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    return getDerived().RebuildSEHTryStmt(S.getIsCXXTry(), S.getTryLoc(), 
        TryBlock.get(), Handler.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6154,
   FQN="clang::TreeTransform::TransformCaseStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformCaseStmtEPNS_8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17TransformCaseStmtEPNS_8CaseStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformCaseStmt(CaseStmt /*P*/ S)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > LHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    ActionResultTTrue<Expr /*P*/ > RHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
            Sema.ExpressionEvaluationContext.ConstantEvaluated);
        
        // Transform the left-hand case value.
        LHS.$assignMove(getDerived().TransformExpr(S.getLHS()));
        LHS.$assignMove(SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(LHS)));
        if (LHS.isInvalid()) {
          return StmtError();
        }
        
        // Transform the right-hand case value (for the GNU case-range extension).
        RHS.$assignMove(getDerived().TransformExpr(S.getRHS()));
        RHS.$assignMove(SemaRef.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(RHS)));
        if (RHS.isInvalid()) {
          return StmtError();
        }
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    
    // Build the case statement.
    // Case statements are always rebuilt so that they will attached to their
    // transformed switch statement.
    ActionResultTTrue<Stmt /*P*/ > Case = getDerived().RebuildCaseStmt(S.getCaseLoc(), 
        LHS.get(), 
        S.getEllipsisLoc(), 
        RHS.get(), 
        S.getColonLoc());
    if (Case.isInvalid()) {
      return StmtError();
    }
    
    // Transform the statement following the case
    ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformStmt(S.getSubStmt());
    if (SubStmt.isInvalid()) {
      return StmtError();
    }
    
    // Attach the body to the case statement
    return getDerived().RebuildCaseStmtBody(Case.get(), SubStmt.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6195,
   FQN="clang::TreeTransform::TransformDefaultStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDefaultStmtEPNS_11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformDefaultStmtEPNS_11DefaultStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformDefaultStmt(DefaultStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the statement following the default case
    ActionResultTTrue<Stmt /*P*/ > SubStmt = getDerived().TransformStmt(S.getSubStmt());
    if (SubStmt.isInvalid()) {
      return StmtError();
    }
    
    // Default statements are always rebuilt
    return getDerived().RebuildDefaultStmt(S.getDefaultLoc(), S.getColonLoc(), 
        SubStmt.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6318,
   FQN="clang::TreeTransform::TransformSwitchStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSwitchStmtEPNS_10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19TransformSwitchStmtEPNS_10SwitchStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformSwitchStmt(SwitchStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the initialization statement
    ActionResultTTrue<Stmt /*P*/ > Init = getDerived().TransformStmt(S.getInit());
    if (Init.isInvalid()) {
      return StmtError();
    }
    
    // Transform the condition.
    Sema.ConditionResult Cond = getDerived().TransformCondition(S.getSwitchLoc(), S.getConditionVariable(), S.getCond(), 
        Sema.ConditionKind.Switch);
    if (Cond.isInvalid()) {
      return StmtError();
    }
    
    // Rebuild the switch statement.
    ActionResultTTrue<Stmt /*P*/ > Switch = getDerived().RebuildSwitchStmtStart(S.getSwitchLoc(), 
        S.getInit(), new Sema.ConditionResult(Cond));
    if (Switch.isInvalid()) {
      return StmtError();
    }
    
    // Transform the body of the switch statement.
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    
    // Complete the switch statement.
    return getDerived().RebuildSwitchStmtBody(S.getSwitchLoc(), Switch.get(), 
        Body.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 6350,
   FQN="clang::TreeTransform::TransformWhileStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformWhileStmtEPNS_9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18TransformWhileStmtEPNS_9WhileStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformWhileStmt(WhileStmt /*P*/ S)/* __attribute__((noinline))*/ {
    // Transform the condition
    Sema.ConditionResult Cond = getDerived().TransformCondition(S.getWhileLoc(), S.getConditionVariable(), S.getCond(), 
        Sema.ConditionKind.Boolean);
    if (Cond.isInvalid()) {
      return StmtError();
    }
    
    // Transform the body
    ActionResultTTrue<Stmt /*P*/ > Body = getDerived().TransformStmt(S.getBody());
    if (Body.isInvalid()) {
      return StmtError();
    }
    if (!getDerived().AlwaysRebuild()
       && $eq_pair$_T1$_T2$C(Cond.get(), std.make_pair_Ptr_Ptr(S.getConditionVariable(), S.getCond()))
       && Body.get() == S.getBody()) {
      return Owned(S);
    }
    
    return getDerived().RebuildWhileStmt(S.getWhileLoc(), new Sema.ConditionResult(Cond), Body.get());
  }

  
  // OpenMP clauses.
  
  //===----------------------------------------------------------------------===//
  // OpenMP clause transformation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7633,
   FQN="clang::TreeTransform::TransformOMPIfClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformOMPIfClauseEPNS_11OMPIfClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformOMPIfClauseEPNS_11OMPIfClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPIfClause(
    // OpenMP clauses.
    OMPIfClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(C.getCondition());
    if (Cond.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPIfClause(C.getNameModifier(), Cond.get(), C.getLocStart(), C.getLParenLoc(), 
        C.getNameModifierLoc(), C.getColonLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7643,
   FQN="clang::TreeTransform::TransformOMPFinalClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPFinalClauseEPNS_14OMPFinalClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPFinalClauseEPNS_14OMPFinalClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPFinalClause(OMPFinalClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > Cond = getDerived().TransformExpr(C.getCondition());
    if (Cond.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPFinalClause(Cond.get(), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7652,
   FQN="clang::TreeTransform::TransformOMPNumThreadsClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPNumThreadsClause(OMPNumThreadsClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > NumThreads = getDerived().TransformExpr(C.getNumThreads());
    if (NumThreads.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPNumThreadsClause(NumThreads.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7662,
   FQN="clang::TreeTransform::TransformOMPSafelenClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSafelenClauseEPNS_16OMPSafelenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSafelenClauseEPNS_16OMPSafelenClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPSafelenClause(OMPSafelenClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getSafelen());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPSafelenClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7672,
   FQN="clang::TreeTransform::TransformOMPSimdlenClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSimdlenClauseEPNS_16OMPSimdlenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPSimdlenClauseEPNS_16OMPSimdlenClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPSimdlenClause(OMPSimdlenClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getSimdlen());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPSimdlenClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7682,
   FQN="clang::TreeTransform::TransformOMPCollapseClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPCollapseClauseEPNS_17OMPCollapseClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPCollapseClauseEPNS_17OMPCollapseClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPCollapseClause(OMPCollapseClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getNumForLoops());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPCollapseClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7692,
   FQN="clang::TreeTransform::TransformOMPDefaultClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPDefaultClauseEPNS_16OMPDefaultClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPDefaultClauseEPNS_16OMPDefaultClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPDefaultClause(OMPDefaultClause /*P*/ C)/* __attribute__((noinline))*/ {
    return getDerived().RebuildOMPDefaultClause(C.getDefaultKind(), C.getDefaultKindKwLoc(), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7808,
   FQN="clang::TreeTransform::TransformOMPPrivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPPrivateClauseEPNS_16OMPPrivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPPrivateClauseEPNS_16OMPPrivateClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPPrivateClause(OMPPrivateClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPPrivateClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7823,
   FQN="clang::TreeTransform::TransformOMPFirstprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPFirstprivateClause(OMPFirstprivateClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPFirstprivateClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7838,
   FQN="clang::TreeTransform::TransformOMPLastprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPLastprivateClauseEPNS_20OMPLastprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPLastprivateClauseEPNS_20OMPLastprivateClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPLastprivateClause(OMPLastprivateClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPLastprivateClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7853,
   FQN="clang::TreeTransform::TransformOMPSharedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPSharedClauseEPNS_15OMPSharedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPSharedClauseEPNS_15OMPSharedClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPSharedClause(OMPSharedClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPSharedClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7868,
   FQN="clang::TreeTransform::TransformOMPReductionClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPReductionClauseEPNS_18OMPReductionClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPReductionClauseEPNS_18OMPReductionClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPReductionClause(OMPReductionClause /*P*/ C)/* __attribute__((noinline))*/ {
    CXXScopeSpec ReductionIdScopeSpec = null;
    try {
      SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
      Vars.reserve(C.varlist_size());
      for (Expr /*P*/ VE : C.varlists()) {
        ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
        if (EVar.isInvalid()) {
          return null;
        }
        Vars.push_back(EVar.get());
      }
      ReductionIdScopeSpec/*J*/= new CXXScopeSpec();
      ReductionIdScopeSpec.Adopt(C.getQualifierLoc());
      
      DeclarationNameInfo NameInfo = new DeclarationNameInfo(C.getNameInfo());
      if (NameInfo.getName().$bool()) {
        NameInfo.$assignMove(getDerived().TransformDeclarationNameInfo(NameInfo));
        if (!NameInfo.getName().$bool()) {
          return null;
        }
      }
      // Build a list of all UDR decls with the same names ranged by the Scopes.
      // The Scope boundary is a duplication of the previous decl.
      SmallVector<Expr /*P*/ > UnresolvedReductions/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
      for (Expr /*P*/ E : C.reduction_ops()) {
        // Transform all the decls.
        if ((E != null)) {
          UnresolvedLookupExpr /*P*/ ULE = cast_UnresolvedLookupExpr(E);
          UnresolvedSet Decls/*J*/= new UnresolvedSet(8);
          for (NamedDecl /*P*/ D : ULE.decls()) {
            NamedDecl /*P*/ InstD = cast_NamedDecl(getDerived().TransformDecl(E.getExprLoc(), D));
            Decls.addDecl(InstD, InstD.getAccess());
          }
          UnresolvedReductions.push_back(UnresolvedLookupExpr.Create(SemaRef.Context, /*NamingClass=*/ (CXXRecordDecl /*P*/ )null, 
                  ReductionIdScopeSpec.getWithLocInContext(SemaRef.Context), 
                  NameInfo, /*ADL=*/ true, ULE.isOverloaded(), 
                  Decls.begin(), Decls.end()));
        } else {
          UnresolvedReductions.push_back((Expr /*P*/ /*const*/)null);
        }
      }
      return getDerived().RebuildOMPReductionClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getColonLoc(), 
          C.getLocEnd(), ReductionIdScopeSpec, NameInfo, new ArrayRef<Expr /*P*/ >(UnresolvedReductions, true));
    } finally {
      if (ReductionIdScopeSpec != null) { ReductionIdScopeSpec.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7915,
   FQN="clang::TreeTransform::TransformOMPLinearClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPLinearClauseEPNS_15OMPLinearClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPLinearClauseEPNS_15OMPLinearClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPLinearClause(OMPLinearClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    ActionResultTTrue<Expr /*P*/ > Step = getDerived().TransformExpr(C.getStep());
    if (Step.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPLinearClause(new ArrayRef<Expr /*P*/ >(Vars, true), Step.get(), C.getLocStart(), C.getLParenLoc(), C.getModifier(), 
        C.getModifierLoc(), C.getColonLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7934,
   FQN="clang::TreeTransform::TransformOMPAlignedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPAlignedClauseEPNS_16OMPAlignedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPAlignedClauseEPNS_16OMPAlignedClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPAlignedClause(OMPAlignedClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    ActionResultTTrue<Expr /*P*/ > Alignment = getDerived().TransformExpr(C.getAlignment());
    if (Alignment.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPAlignedClause(new ArrayRef<Expr /*P*/ >(Vars, true), Alignment.get(), C.getLocStart(), C.getLParenLoc(), 
        C.getColonLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7953,
   FQN="clang::TreeTransform::TransformOMPCopyinClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPCopyinClauseEPNS_15OMPCopyinClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPCopyinClauseEPNS_15OMPCopyinClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPCopyinClause(OMPCopyinClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPCopyinClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7968,
   FQN="clang::TreeTransform::TransformOMPCopyprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPCopyprivateClause(OMPCopyprivateClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPCopyprivateClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7700,
   FQN="clang::TreeTransform::TransformOMPProcBindClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPProcBindClauseEPNS_17OMPProcBindClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPProcBindClauseEPNS_17OMPProcBindClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPProcBindClause(OMPProcBindClause /*P*/ C)/* __attribute__((noinline))*/ {
    return getDerived().RebuildOMPProcBindClause(C.getProcBindKind(), C.getProcBindKindKwLoc(), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7708,
   FQN="clang::TreeTransform::TransformOMPScheduleClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPScheduleClauseEPNS_17OMPScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPScheduleClauseEPNS_17OMPScheduleClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPScheduleClause(OMPScheduleClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getChunkSize());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPScheduleClause(C.getFirstScheduleModifier(), C.getSecondScheduleModifier(), 
        C.getScheduleKind(), E.get(), C.getLocStart(), C.getLParenLoc(), 
        C.getFirstScheduleModifierLoc(), C.getSecondScheduleModifierLoc(), 
        C.getScheduleKindLoc(), C.getCommaLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7721,
   FQN="clang::TreeTransform::TransformOMPOrderedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPOrderedClauseEPNS_16OMPOrderedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPOrderedClauseEPNS_16OMPOrderedClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPOrderedClause(OMPOrderedClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      Expr /*P*/ Num = C.getNumForLoops();
      if ((Num != null)) {
        E.$assignMove(getDerived().TransformExpr(Num));
        if (E.isInvalid()) {
          return null;
        }
      }
    }
    return getDerived().RebuildOMPOrderedClause(C.getLocStart(), C.getLocEnd(), 
        C.getLParenLoc(), E.get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPNowaitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7734,
   FQN="clang::TreeTransform::TransformOMPNowaitClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPNowaitClauseEPNS_15OMPNowaitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPNowaitClauseEPNS_15OMPNowaitClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPNowaitClause(OMPNowaitClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPUntiedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7741,
   FQN="clang::TreeTransform::TransformOMPUntiedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPUntiedClauseEPNS_15OMPUntiedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPUntiedClauseEPNS_15OMPUntiedClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPUntiedClause(OMPUntiedClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPMergeableClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7748,
   FQN="clang::TreeTransform::TransformOMPMergeableClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPMergeableClauseEPNS_18OMPMergeableClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPMergeableClauseEPNS_18OMPMergeableClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPMergeableClause(OMPMergeableClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7983,
   FQN="clang::TreeTransform::TransformOMPFlushClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPFlushClauseEPNS_14OMPFlushClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPFlushClauseEPNS_14OMPFlushClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPFlushClause(OMPFlushClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPFlushClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPReadClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7755,
   FQN="clang::TreeTransform::TransformOMPReadClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPReadClauseEPNS_13OMPReadClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPReadClauseEPNS_13OMPReadClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPReadClause(OMPReadClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPWriteClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7761,
   FQN="clang::TreeTransform::TransformOMPWriteClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPWriteClauseEPNS_14OMPWriteClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23TransformOMPWriteClauseEPNS_14OMPWriteClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPWriteClause(OMPWriteClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPUpdateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7767,
   FQN="clang::TreeTransform::TransformOMPUpdateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPUpdateClauseEPNS_15OMPUpdateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPUpdateClauseEPNS_15OMPUpdateClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPUpdateClause(OMPUpdateClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPCaptureClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7774,
   FQN="clang::TreeTransform::TransformOMPCaptureClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPCaptureClauseEPNS_16OMPCaptureClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPCaptureClauseEPNS_16OMPCaptureClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPCaptureClause(OMPCaptureClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSeqCstClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7781,
   FQN="clang::TreeTransform::TransformOMPSeqCstClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPSeqCstClauseEPNS_15OMPSeqCstClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPSeqCstClauseEPNS_15OMPSeqCstClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPSeqCstClause(OMPSeqCstClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7997,
   FQN="clang::TreeTransform::TransformOMPDependClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPDependClauseEPNS_15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPDependClauseEPNS_15OMPDependClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPDependClause(OMPDependClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPDependClause(C.getDependencyKind(), C.getDependencyLoc(), C.getColonLoc(), new ArrayRef<Expr /*P*/ >(Vars, true), 
        C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8013,
   FQN="clang::TreeTransform::TransformOMPDeviceClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPDeviceClauseEPNS_15OMPDeviceClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24TransformOMPDeviceClauseEPNS_15OMPDeviceClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPDeviceClause(OMPDeviceClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getDevice());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPDeviceClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7788,
   FQN="clang::TreeTransform::TransformOMPThreadsClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPThreadsClauseEPNS_16OMPThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPThreadsClauseEPNS_16OMPThreadsClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPThreadsClause(OMPThreadsClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPSIMDClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7795,
   FQN="clang::TreeTransform::TransformOMPSIMDClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPSIMDClauseEPNS_13OMPSIMDClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPSIMDClauseEPNS_13OMPSIMDClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPSIMDClause(OMPSIMDClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8023,
   FQN="clang::TreeTransform::TransformOMPMapClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformOMPMapClauseEPNS_12OMPMapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21TransformOMPMapClauseEPNS_12OMPMapClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPMapClause(OMPMapClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPMapClause(C.getMapTypeModifier(), C.getMapType(), C.isImplicitMapType(), 
        C.getMapLoc(), C.getColonLoc(), new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8039,
   FQN="clang::TreeTransform::TransformOMPNumTeamsClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPNumTeamsClause(OMPNumTeamsClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getNumTeams());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPNumTeamsClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8049,
   FQN="clang::TreeTransform::TransformOMPThreadLimitClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPThreadLimitClause(OMPThreadLimitClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getThreadLimit());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPThreadLimitClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8059,
   FQN="clang::TreeTransform::TransformOMPPriorityClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPPriorityClauseEPNS_17OMPPriorityClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPPriorityClauseEPNS_17OMPPriorityClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPPriorityClause(OMPPriorityClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getPriority());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPPriorityClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8069,
   FQN="clang::TreeTransform::TransformOMPGrainsizeClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27TransformOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPGrainsizeClause(OMPGrainsizeClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getGrainsize());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPGrainsizeClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPNogroupClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 7801,
   FQN="clang::TreeTransform::TransformOMPNogroupClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPNogroupClauseEPNS_16OMPNogroupClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformOMPNogroupClauseEPNS_16OMPNogroupClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPNogroupClause(OMPNogroupClause /*P*/ C)/* __attribute__((noinline))*/ {
    // No need to rebuild this clause, no template-dependent parameters.
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8079,
   FQN="clang::TreeTransform::TransformOMPNumTasksClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPNumTasksClauseEPNS_17OMPNumTasksClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformOMPNumTasksClauseEPNS_17OMPNumTasksClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPNumTasksClause(OMPNumTasksClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getNumTasks());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPNumTasksClause(E.get(), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8089,
   FQN="clang::TreeTransform::TransformOMPHintClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPHintClauseEPNS_13OMPHintClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPHintClauseEPNS_13OMPHintClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPHintClause(OMPHintClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getHint());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPHintClause(E.get(), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8098,
   FQN="clang::TreeTransform::TransformOMPDistScheduleClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPDistScheduleClause(OMPDistScheduleClause /*P*/ C)/* __attribute__((noinline))*/ {
    ActionResultTTrue<Expr /*P*/ > E = getDerived().TransformExpr(C.getChunkSize());
    if (E.isInvalid()) {
      return null;
    }
    return getDerived().RebuildOMPDistScheduleClause(C.getDistScheduleKind(), E.get(), C.getLocStart(), C.getLParenLoc(), 
        C.getDistScheduleKindLoc(), C.getCommaLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8109,
   FQN="clang::TreeTransform::TransformOMPDefaultmapClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28TransformOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPDefaultmapClause(OMPDefaultmapClause /*P*/ C)/* __attribute__((noinline))*/ {
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8115,
   FQN="clang::TreeTransform::TransformOMPToClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformOMPToClauseEPNS_11OMPToClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20TransformOMPToClauseEPNS_11OMPToClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPToClause(OMPToClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPToClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8129,
   FQN="clang::TreeTransform::TransformOMPFromClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPFromClauseEPNS_13OMPFromClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22TransformOMPFromClauseEPNS_13OMPFromClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPFromClause(OMPFromClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPFromClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), 
        C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8143,
   FQN="clang::TreeTransform::TransformOMPUseDevicePtrClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30TransformOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPUseDevicePtrClause(OMPUseDevicePtrClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPUseDevicePtrClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 8158,
   FQN="clang::TreeTransform::TransformOMPIsDevicePtrClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29TransformOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE")
  //</editor-fold>
  public OMPClause /*P*/ TransformOMPIsDevicePtrClause(OMPIsDevicePtrClause /*P*/ C)/* __attribute__((noinline))*/ {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(C.varlist_size());
    for (Expr /*P*/ VE : C.varlists()) {
      ActionResultTTrue<Expr /*P*/ > EVar = getDerived().TransformExpr(cast_Expr(VE));
      if (EVar.isInvalid()) {
        return null;
      }
      Vars.push_back(EVar.get());
    }
    return getDerived().RebuildOMPIsDevicePtrClause(new ArrayRef<Expr /*P*/ >(Vars, true), C.getLocStart(), C.getLParenLoc(), C.getLocEnd());
  }

  
  /// \brief Build a new pointer type given its pointee type.
  ///
  /// By default, performs semantic analysis when building the pointer type.
  /// Subclasses may override this routine to provide different behavior.
  
  //===----------------------------------------------------------------------===//
  // Type reconstruction
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11447,
   FQN="clang::TreeTransform::RebuildPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildPointerTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildPointerTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildPointerType(QualType PointeeType, SourceLocation Star) {
    return SemaRef.BuildPointerType(new QualType(PointeeType), new SourceLocation(Star), 
        getDerived().getBaseEntity());
  }

  
  /// \brief Build a new block pointer type given its pointee type.
  ///
  /// By default, performs semantic analysis when building the block pointer
  /// type. Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11454,
   FQN="clang::TreeTransform::RebuildBlockPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildBlockPointerTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildBlockPointerTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildBlockPointerType(QualType PointeeType, SourceLocation Star) {
    return SemaRef.BuildBlockPointerType(new QualType(PointeeType), new SourceLocation(Star), 
        getDerived().getBaseEntity());
  }

  
  /// \brief Build a new reference type given the type it references.
  ///
  /// By default, performs semantic analysis when building the
  /// reference type. Subclasses may override this routine to provide
  /// different behavior.
  ///
  /// \param LValue whether the type was written with an lvalue sigil
  /// or an rvalue sigil.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11461,
   FQN="clang::TreeTransform::RebuildReferenceType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildReferenceTypeENS_8QualTypeEbNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildReferenceTypeENS_8QualTypeEbNS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildReferenceType(QualType ReferentType, 
                      boolean WrittenAsLValue, 
                      SourceLocation Sigil) {
    return SemaRef.BuildReferenceType(new QualType(ReferentType), WrittenAsLValue, 
        new SourceLocation(Sigil), getDerived().getBaseEntity());
  }

  
  /// \brief Build a new member pointer type given the pointee type and the
  /// class type it refers into.
  ///
  /// By default, performs semantic analysis when building the member pointer
  /// type. Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11470,
   FQN="clang::TreeTransform::RebuildMemberPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildMemberPointerTypeENS_8QualTypeES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildMemberPointerTypeENS_8QualTypeES4_NS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildMemberPointerType(QualType PointeeType, QualType ClassType, 
                          SourceLocation Sigil) {
    return SemaRef.BuildMemberPointerType(new QualType(PointeeType), new QualType(ClassType), new SourceLocation(Sigil), 
        getDerived().getBaseEntity());
  }

  
  /// \brief Build an Objective-C object type.
  ///
  /// By default, performs semantic analysis when building the object type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11479,
   FQN="clang::TreeTransform::RebuildObjCObjectType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildObjCObjectTypeENS_8QualTypeENS_14SourceLocationES5_N4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_S5_NS7_IPNS_16ObjCProtocolDeclEEENS7_IS5_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildObjCObjectTypeENS_8QualTypeENS_14SourceLocationES5_N4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_S5_NS7_IPNS_16ObjCProtocolDeclEEENS7_IS5_EES5_")
  //</editor-fold>
  public QualType RebuildObjCObjectType(QualType BaseType, 
                       SourceLocation Loc, 
                       SourceLocation TypeArgsLAngleLoc, 
                       ArrayRef<TypeSourceInfo /*P*/ > TypeArgs, 
                       SourceLocation TypeArgsRAngleLoc, 
                       SourceLocation ProtocolLAngleLoc, 
                       ArrayRef<ObjCProtocolDecl /*P*/ > Protocols, 
                       ArrayRef<SourceLocation> ProtocolLocs, 
                       SourceLocation ProtocolRAngleLoc) {
    return SemaRef.BuildObjCObjectType(new QualType(BaseType), new SourceLocation(Loc), new SourceLocation(TypeArgsLAngleLoc), 
        new ArrayRef<TypeSourceInfo /*P*/ >(TypeArgs), new SourceLocation(TypeArgsRAngleLoc), 
        new SourceLocation(ProtocolLAngleLoc), new ArrayRef<ObjCProtocolDecl /*P*/ >(Protocols), new ArrayRef<SourceLocation>(ProtocolLocs), 
        new SourceLocation(ProtocolRAngleLoc), 
        /*FailOnError=*/ true);
  }

  
  /// \brief Build a new Objective-C object pointer type given the pointee type.
  ///
  /// By default, directly builds the pointer type, with no additional semantic
  /// analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11497,
   FQN="clang::TreeTransform::RebuildObjCObjectPointerType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCObjectPointerTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCObjectPointerTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildObjCObjectPointerType(QualType PointeeType, 
                              SourceLocation Star) {
    return SemaRef.Context.getObjCObjectPointerType(new QualType(PointeeType));
  }

  
  /// \brief Build a new array type given the element type, size
  /// modifier, size of the array (if known), size expression, and index type
  /// qualifiers.
  ///
  /// By default, performs semantic analysis when building the array type.
  /// Subclasses may override this routine to provide different behavior.
  /// Also by default, all of the other Rebuild*Array
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11504,
   FQN="clang::TreeTransform::RebuildArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPKN4llvm5APIntEPNS_4ExprEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPKN4llvm5APIntEPNS_4ExprEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType RebuildArrayType(QualType ElementType, 
                  ArrayType.ArraySizeModifier SizeMod, 
                  /*const*/ APInt /*P*/ Size, 
                  Expr /*P*/ SizeExpr, 
                  /*uint*/int IndexTypeQuals, 
                  SourceRange BracketsRange) {
    if ((SizeExpr != null) || !(Size != null)) {
      return SemaRef.BuildArrayType(new QualType(ElementType), SizeMod, SizeExpr, 
          IndexTypeQuals, new SourceRange(BracketsRange), 
          getDerived().getBaseEntity());
    }
    
    QualType Types[/*6*/] = new QualType [/*6*/] {
      SemaRef.Context.UnsignedCharTy.$QualType(), SemaRef.Context.UnsignedShortTy.$QualType(), 
      SemaRef.Context.UnsignedIntTy.$QualType(), SemaRef.Context.UnsignedLongTy.$QualType(), 
      SemaRef.Context.UnsignedLongLongTy.$QualType(), SemaRef.Context.UnsignedInt128Ty.$QualType()
    };
    /*const*//*uint*/int NumTypes = llvm.array_lengthof(Types);
    QualType SizeType/*J*/= new QualType();
    for (/*uint*/int I = 0; I != NumTypes; ++I)  {
      if (Size.getBitWidth() == SemaRef.Context.getIntWidth(new QualType(Types[I]))) {
        SizeType.$assign(Types[I]);
        break;
      }
    }
    
    // Note that we can return a VariableArrayType here in the case where
    // the element type was a dependent VariableArrayType.
    IntegerLiteral /*P*/ ArraySize = IntegerLiteral.Create(SemaRef.Context, $Deref(Size), new QualType(SizeType), 
        /*FIXME*/ BracketsRange.getBegin());
    return SemaRef.BuildArrayType(new QualType(ElementType), SizeMod, ArraySize, 
        IndexTypeQuals, new SourceRange(BracketsRange), 
        getDerived().getBaseEntity());
  }

  
  /// \brief Build a new constant array type given the element type, size
  /// modifier, (known) size of the array, and index type qualifiers.
  ///
  /// By default, performs semantic analysis when building the array type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11540,
   FQN="clang::TreeTransform::RebuildConstantArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildConstantArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierERKN4llvm5APIntEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildConstantArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierERKN4llvm5APIntEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType RebuildConstantArrayType(QualType ElementType, 
                          ArrayType.ArraySizeModifier SizeMod, 
                          final /*const*/ APInt /*&*/ Size, 
                          /*uint*/int IndexTypeQuals, 
                          SourceRange BracketsRange) {
    return getDerived().RebuildArrayType(new QualType(ElementType), SizeMod, $AddrOf(Size), (Expr /*P*/ )null, 
        IndexTypeQuals, new SourceRange(BracketsRange));
  }

  
  /// \brief Build a new incomplete array type given the element type, size
  /// modifier, and index type qualifiers.
  ///
  /// By default, performs semantic analysis when building the array type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11551,
   FQN="clang::TreeTransform::RebuildIncompleteArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildIncompleteArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildIncompleteArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType RebuildIncompleteArrayType(QualType ElementType, 
                            ArrayType.ArraySizeModifier SizeMod, 
                            /*uint*/int IndexTypeQuals, 
                            SourceRange BracketsRange) {
    return getDerived().RebuildArrayType(new QualType(ElementType), SizeMod, (/*const*/ APInt /*P*/ )null, (Expr /*P*/ )null, 
        IndexTypeQuals, new SourceRange(BracketsRange));
  }

  
  /// \brief Build a new variable-length array type given the element type,
  /// size modifier, size expression, and index type qualifiers.
  ///
  /// By default, performs semantic analysis when building the array type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11561,
   FQN="clang::TreeTransform::RebuildVariableArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildVariableArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildVariableArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType RebuildVariableArrayType(QualType ElementType, 
                          ArrayType.ArraySizeModifier SizeMod, 
                          Expr /*P*/ SizeExpr, 
                          /*uint*/int IndexTypeQuals, 
                          SourceRange BracketsRange) {
    return getDerived().RebuildArrayType(new QualType(ElementType), SizeMod, (/*const*/ APInt /*P*/ )null, 
        SizeExpr, 
        IndexTypeQuals, new SourceRange(BracketsRange));
  }

  
  /// \brief Build a new dependent-sized array type given the element type,
  /// size modifier, size expression, and index type qualifiers.
  ///
  /// By default, performs semantic analysis when building the array type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11573,
   FQN="clang::TreeTransform::RebuildDependentSizedArrayType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildDependentSizedArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildDependentSizedArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType RebuildDependentSizedArrayType(QualType ElementType, 
                                ArrayType.ArraySizeModifier SizeMod, 
                                Expr /*P*/ SizeExpr, 
                                /*uint*/int IndexTypeQuals, 
                                SourceRange BracketsRange) {
    return getDerived().RebuildArrayType(new QualType(ElementType), SizeMod, (/*const*/ APInt /*P*/ )null, 
        SizeExpr, 
        IndexTypeQuals, new SourceRange(BracketsRange));
  }

  
  /// \brief Build a new vector type given the element type and
  /// number of elements.
  ///
  /// By default, performs semantic analysis when building the vector type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11585,
   FQN="clang::TreeTransform::RebuildVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildVectorTypeENS_8QualTypeEjNS_10VectorType10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildVectorTypeENS_8QualTypeEjNS_10VectorType10VectorKindE")
  //</editor-fold>
  public QualType RebuildVectorType(QualType ElementType, /*uint*/int NumElements, 
                   VectorType.VectorKind VecKind) {
    // FIXME: semantic checking!
    return SemaRef.Context.getVectorType(new QualType(ElementType), NumElements, VecKind);
  }

  
  /// \brief Build a new extended vector type given the element type and
  /// number of elements.
  ///
  /// By default, performs semantic analysis when building the vector type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11593,
   FQN="clang::TreeTransform::RebuildExtVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildExtVectorTypeENS_8QualTypeEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildExtVectorTypeENS_8QualTypeEjNS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildExtVectorType(QualType ElementType, /*uint*/int NumElements, 
                      SourceLocation AttributeLoc) {
    APInt numElements/*J*/= new APInt(JD$UInt_ULong.INSTANCE,  SemaRef.Context.getIntWidth(SemaRef.Context.IntTy.$QualType()), 
        $uint2ulong(NumElements), true);
    IntegerLiteral /*P*/ VectorSize = IntegerLiteral.Create(SemaRef.Context, numElements, SemaRef.Context.IntTy.$QualType(), 
        new SourceLocation(AttributeLoc));
    return SemaRef.BuildExtVectorType(new QualType(ElementType), VectorSize, new SourceLocation(AttributeLoc));
  }

  
  /// \brief Build a new potentially dependently-sized extended vector type
  /// given the element type and number of elements.
  ///
  /// By default, performs semantic analysis when building the vector type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11605,
   FQN="clang::TreeTransform::RebuildDependentSizedExtVectorType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34RebuildDependentSizedExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34RebuildDependentSizedExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildDependentSizedExtVectorType(QualType ElementType, 
                                    Expr /*P*/ SizeExpr, 
                                    SourceLocation AttributeLoc) {
    return SemaRef.BuildExtVectorType(new QualType(ElementType), SizeExpr, new SourceLocation(AttributeLoc));
  }

  
  /// \brief Build a new function type.
  ///
  /// By default, performs semantic analysis when building the function type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11613,
   FQN="clang::TreeTransform::RebuildFunctionProtoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildFunctionProtoTypeENS_8QualTypeEN4llvm15MutableArrayRefIS4_EERKNS_17FunctionProtoType12ExtProtoInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildFunctionProtoTypeENS_8QualTypeEN4llvm15MutableArrayRefIS4_EERKNS_17FunctionProtoType12ExtProtoInfoE")
  //</editor-fold>
  public QualType RebuildFunctionProtoType(QualType T, 
                          MutableArrayRef<QualType> ParamTypes, 
                          final /*const*/ FunctionProtoType.ExtProtoInfo /*&*/ EPI) {
    return SemaRef.BuildFunctionType(new QualType(T), new MutableArrayRef<QualType>(ParamTypes), 
        getDerived().getBaseLocation(), 
        getDerived().getBaseEntity(), 
        EPI);
  }

  
  /// \brief Build a new unprototyped function type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11624,
   FQN="clang::TreeTransform::RebuildFunctionNoProtoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildFunctionNoProtoTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildFunctionNoProtoTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType RebuildFunctionNoProtoType(QualType T) {
    return SemaRef.Context.getFunctionNoProtoType(new QualType(T));
  }

  
  /// \brief Rebuild an unresolved typename type, given the decl that
  /// the UnresolvedUsingTypenameDecl was transformed to.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11629,
   FQN="clang::TreeTransform::RebuildUnresolvedUsingType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildUnresolvedUsingTypeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildUnresolvedUsingTypeEPNS_4DeclE")
  //</editor-fold>
  public QualType RebuildUnresolvedUsingType(Decl /*P*/ D) {
    assert ((D != null)) : "no decl found";
    if (D.isInvalidDecl()) {
      return new QualType();
    }
    
    // FIXME: Doesn't account for ObjCInterfaceDecl!
    TypeDecl /*P*/ Ty;
    if (isa_UsingDecl(D)) {
      UsingDecl /*P*/ Using = cast_UsingDecl(D);
      assert (Using.hasTypename()) : "UnresolvedUsingTypenameDecl transformed to non-typename using";
      
      // A valid resolved using typename decl points to exactly one type decl.
      assert ($eq_shadow_iterator(/*NO_COPY*/Using.shadow_begin().$preInc(), Using.shadow_end()));
      Ty = cast_TypeDecl((Using.shadow_begin().$star()).getTargetDecl());
    } else {
      assert (isa_UnresolvedUsingTypenameDecl(D)) : "UnresolvedUsingTypenameDecl transformed to non-using decl";
      Ty = cast_UnresolvedUsingTypenameDecl(D);
    }
    
    return SemaRef.Context.getTypeDeclType(Ty);
  }

  
  /// \brief Build a new typedef type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 821,
   FQN="clang::TreeTransform::RebuildTypedefType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildTypedefTypeEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildTypedefTypeEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public QualType RebuildTypedefType(TypedefNameDecl /*P*/ Typedef) {
    return SemaRef.Context.getTypeDeclType(Typedef);
  }

  
  /// \brief Build a new class/struct/union type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 826,
   FQN="clang::TreeTransform::RebuildRecordType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildRecordTypeEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildRecordTypeEPNS_10RecordDeclE")
  //</editor-fold>
  public QualType RebuildRecordType(RecordDecl /*P*/ Record) {
    return SemaRef.Context.getTypeDeclType(Record);
  }

  
  /// \brief Build a new Enum type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 831,
   FQN="clang::TreeTransform::RebuildEnumType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildEnumTypeEPNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildEnumTypeEPNS_8EnumDeclE")
  //</editor-fold>
  public QualType RebuildEnumType(EnumDecl /*P*/ Enum) {
    return SemaRef.Context.getTypeDeclType(Enum);
  }

  
  /// \brief Build a new typeof(expr) type.
  ///
  /// By default, performs semantic analysis when building the typeof type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11654,
   FQN="clang::TreeTransform::RebuildTypeOfExprType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildTypeOfExprTypeEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildTypeOfExprTypeEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildTypeOfExprType(Expr /*P*/ E, SourceLocation Loc) {
    return SemaRef.BuildTypeofExprType(E, new SourceLocation(Loc));
  }

  
  /// \brief Build a new typeof(type) type.
  ///
  /// By default, builds a new TypeOfType with the given underlying type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11660,
   FQN="clang::TreeTransform::RebuildTypeOfType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildTypeOfTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildTypeOfTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType RebuildTypeOfType(QualType Underlying) {
    return SemaRef.Context.getTypeOfType(new QualType(Underlying));
  }

  
  /// \brief Build a new unary transform type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11671,
   FQN="clang::TreeTransform::RebuildUnaryTransformType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildUnaryTransformTypeENS_8QualTypeENS_18UnaryTransformType7UTTKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildUnaryTransformTypeENS_8QualTypeENS_18UnaryTransformType7UTTKindENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildUnaryTransformType(QualType BaseType, 
                           UnaryTransformType.UTTKind UKind, 
                           SourceLocation Loc) {
    return SemaRef.BuildUnaryTransformType(new QualType(BaseType), UKind, new SourceLocation(Loc));
  }

  
  /// \brief Build a new C++11 decltype type.
  ///
  /// By default, performs semantic analysis when building the decltype type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11665,
   FQN="clang::TreeTransform::RebuildDecltypeType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildDecltypeTypeEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildDecltypeTypeEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildDecltypeType(Expr /*P*/ E, SourceLocation Loc) {
    return SemaRef.BuildDecltypeType(E, new SourceLocation(Loc));
  }

  
  /// \brief Build a new C++11 auto type.
  ///
  /// By default, builds a new AutoType with the given deduced type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 860,
   FQN="clang::TreeTransform::RebuildAutoType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildAutoTypeENS_8QualTypeENS_15AutoTypeKeywordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildAutoTypeENS_8QualTypeENS_15AutoTypeKeywordE")
  //</editor-fold>
  public QualType RebuildAutoType(QualType Deduced, AutoTypeKeyword Keyword) {
    // Note, IsDependent is always false here: we implicitly convert an 'auto'
    // which has been deduced to a dependent type into an undeduced 'auto', so
    // that we'll retry deduction after the transformation.
    return SemaRef.Context.getAutoType(new QualType(Deduced), Keyword, 
        /*IsDependent*/ false);
  }

  
  /// \brief Build a new template specialization type.
  ///
  /// By default, performs semantic analysis when building the template
  /// specialization type. Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11678,
   FQN="clang::TreeTransform::RebuildTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33RebuildTemplateSpecializationTypeENS_12TemplateNameENS_14SourceLocationERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33RebuildTemplateSpecializationTypeENS_12TemplateNameENS_14SourceLocationERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public QualType RebuildTemplateSpecializationType(TemplateName Template, 
                                   SourceLocation TemplateNameLoc, 
                                   final TemplateArgumentListInfo /*&*/ TemplateArgs) {
    return SemaRef.CheckTemplateIdType(new TemplateName(Template), new SourceLocation(TemplateNameLoc), TemplateArgs);
  }

  
  /// \brief Build a new parenthesized type.
  ///
  /// By default, builds a new ParenType type from the inner type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 881,
   FQN="clang::TreeTransform::RebuildParenType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildParenTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildParenTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType RebuildParenType(QualType InnerType) {
    return SemaRef.Context.getParenType(new QualType(InnerType));
  }

  
  /// \brief Build a new qualified name type.
  ///
  /// By default, builds a new ElaboratedType type from the keyword,
  /// the nested-name-specifier and the named type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 890,
   FQN="clang::TreeTransform::RebuildElaboratedType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildElaboratedTypeENS_14SourceLocationENS_21ElaboratedTypeKeywordENS_22NestedNameSpecifierLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildElaboratedTypeENS_14SourceLocationENS_21ElaboratedTypeKeywordENS_22NestedNameSpecifierLocENS_8QualTypeE")
  //</editor-fold>
  public QualType RebuildElaboratedType(SourceLocation KeywordLoc, 
                       ElaboratedTypeKeyword Keyword, 
                       NestedNameSpecifierLoc QualifierLoc, 
                       QualType Named) {
    return SemaRef.Context.getElaboratedType(Keyword, 
        QualifierLoc.getNestedNameSpecifier(), 
        new QualType(Named));
  }

  
  /// \brief Build a new typename type that refers to a template-id.
  ///
  /// By default, builds a new DependentNameType type from the
  /// nested-name-specifier and the given type. Subclasses may override
  /// this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 904,
   FQN="clang::TreeTransform::RebuildDependentTemplateSpecializationType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42RebuildDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordENS_22NestedNameSpecifierLocEPKNS_14IdentifierInfoENS_14SourceLocationERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE42RebuildDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordENS_22NestedNameSpecifierLocEPKNS_14IdentifierInfoENS_14SourceLocationERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public QualType RebuildDependentTemplateSpecializationType(ElaboratedTypeKeyword Keyword, 
                                            NestedNameSpecifierLoc QualifierLoc, 
                                            /*const*/ IdentifierInfo /*P*/ Name, 
                                            SourceLocation NameLoc, 
                                            final TemplateArgumentListInfo /*&*/ Args) {
    CXXScopeSpec SS = null;
    try {
      // Rebuild the template name.
      // TODO: avoid TemplateName abstraction
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      TemplateName InstName = getDerived().RebuildTemplateName(SS, $Deref(Name), new SourceLocation(NameLoc), new QualType(), 
          (NamedDecl /*P*/ )null);
      if (InstName.isNull()) {
        return new QualType();
      }
      
      // If it's still dependent, make a dependent specialization.
      if ((InstName.getAsDependentTemplateName() != null)) {
        return SemaRef.Context.getDependentTemplateSpecializationType(Keyword, 
            QualifierLoc.getNestedNameSpecifier(), 
            Name, 
            Args);
      }
      
      // Otherwise, make an elaborated type wrapping a non-dependent
      // specialization.
      QualType T = getDerived().RebuildTemplateSpecializationType(new TemplateName(InstName), new SourceLocation(NameLoc), Args);
      if (T.isNull()) {
        return new QualType();
      }
      if (Keyword == ElaboratedTypeKeyword.ETK_None && QualifierLoc.getNestedNameSpecifier() == null) {
        return T;
      }
      
      return SemaRef.Context.getElaboratedType(Keyword, 
          QualifierLoc.getNestedNameSpecifier(), 
          new QualType(T));
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new typename type that refers to an identifier.
  ///
  /// By default, performs semantic analysis when building the typename type
  /// (or elaborated type). Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 947,
   FQN="clang::TreeTransform::RebuildDependentNameType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildDependentNameTypeENS_21ElaboratedTypeKeywordENS_14SourceLocationENS_22NestedNameSpecifierLocEPKNS_14IdentifierInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildDependentNameTypeENS_21ElaboratedTypeKeywordENS_14SourceLocationENS_22NestedNameSpecifierLocEPKNS_14IdentifierInfoES5_")
  //</editor-fold>
  public QualType RebuildDependentNameType(ElaboratedTypeKeyword Keyword, 
                          SourceLocation KeywordLoc, 
                          NestedNameSpecifierLoc QualifierLoc, 
                          /*const*/ IdentifierInfo /*P*/ Id, 
                          SourceLocation IdLoc) {
    CXXScopeSpec SS = null;
    LookupResult Result = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      if (QualifierLoc.getNestedNameSpecifier().isDependent()) {
        // If the name is still dependent, just build a new dependent name type.
        if (!(SemaRef.computeDeclContext(SS) != null)) {
          return SemaRef.Context.getDependentNameType(Keyword, 
              QualifierLoc.getNestedNameSpecifier(), 
              Id);
        }
      }
      if (Keyword == ElaboratedTypeKeyword.ETK_None || Keyword == ElaboratedTypeKeyword.ETK_Typename) {
        return SemaRef.CheckTypenameType(Keyword, new SourceLocation(KeywordLoc), new NestedNameSpecifierLoc(QualifierLoc), 
            $Deref(Id), new SourceLocation(IdLoc));
      }
      
      TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForKeyword(Keyword);
      
      // We had a dependent elaborated-type-specifier that has been transformed
      // into a non-dependent elaborated-type-specifier. Find the tag we're
      // referring to.
      Result/*J*/= /*ParenList*/new LookupResult(SemaRef, new DeclarationName(Id), IdLoc, Sema.LookupNameKind.LookupTagName);
      DeclContext /*P*/ DC = SemaRef.computeDeclContext(SS, false);
      if (!(DC != null)) {
        return new QualType();
      }
      if (SemaRef.RequireCompleteDeclContext(SS, DC)) {
        return new QualType();
      }
      
      TagDecl /*P*/ Tag = null;
      SemaRef.LookupQualifiedName(Result, DC);
      switch (Result.getResultKind()) {
       case NotFound:
       case NotFoundInCurrentInstantiation:
        break;
       case Found:
        Tag = Result.<TagDecl>getAsSingle(TagDecl.class);
        break;
       case FoundOverloaded:
       case FoundUnresolvedValue:
        throw new llvm_unreachable("Tag lookup cannot find non-tags");
       case Ambiguous:
        // Let the LookupResult structure handle ambiguities.
        return new QualType();
      }
      if (!(Tag != null)) {
        LookupResult Result$1 = null;
        try {
          // Check where the name exists but isn't a tag type and use that to emit
          // better diagnostics.
          Result$1/*J*/= /*ParenList*/new LookupResult(SemaRef, new DeclarationName(Id), IdLoc, Sema.LookupNameKind.LookupTagName);
          SemaRef.LookupQualifiedName(Result$1, DC);
          switch (Result$1.getResultKind()) {
           case Found:
           case FoundOverloaded:
           case FoundUnresolvedValue:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                NamedDecl /*P*/ SomeDecl = Result$1.getRepresentativeDecl();
                /*uint*/int Kind$1 = 0;
              if (isa_TypedefDecl(SomeDecl)) {
                  Kind$1 = 1;
              } else if (isa_TypeAliasDecl(SomeDecl)) {
                  Kind$1 = 2;
              } else if (isa_ClassTemplateDecl(SomeDecl)) {
                  Kind$1 = 3;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(IdLoc), diag.err_tag_reference_non_tag)), Kind$1));
                $c$.clean($c$.track(SemaRef.Diag(SomeDecl.getLocation(), diag.note_declared_at)));
                break;
              } finally {
                $c$.$destroy();
              }
            }
           default:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(IdLoc), diag.err_not_tag_in_scope)), 
                                Kind), Id), DC), QualifierLoc.getSourceRange()));
                break;
              } finally {
                $c$.$destroy();
              }
            }
          }
          return new QualType();
        } finally {
          if (Result$1 != null) { Result$1.$destroy(); }
        }
      }
      if (!SemaRef.isAcceptableTagRedeclaration(Tag, Kind, /*isDefinition*/ false, 
          new SourceLocation(IdLoc), Id)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(KeywordLoc), diag.err_use_with_wrong_tag)), Id));
          $c$.clean($c$.track(SemaRef.Diag(Tag.getLocation(), diag.note_previous_use)));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Build the elaborated-type-specifier type.
      QualType T = SemaRef.Context.getTypeDeclType(Tag);
      return SemaRef.Context.getElaboratedType(Keyword, 
          QualifierLoc.getNestedNameSpecifier(), 
          new QualType(T));
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new pack expansion type.
  ///
  /// By default, builds a new PackExpansionType type from the given pattern.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1044,
   FQN="clang::TreeTransform::RebuildPackExpansionType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildPackExpansionTypeENS_8QualTypeENS_11SourceRangeENS_14SourceLocationEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildPackExpansionTypeENS_8QualTypeENS_11SourceRangeENS_14SourceLocationEN4llvm8OptionalIjEE")
  //</editor-fold>
  public QualType RebuildPackExpansionType(QualType Pattern, 
                          SourceRange PatternRange, 
                          SourceLocation EllipsisLoc, 
                          OptionalUInt NumExpansions) {
    return getSema().CheckPackExpansion(new QualType(Pattern), new SourceRange(PatternRange), new SourceLocation(EllipsisLoc), 
        new OptionalUInt(NumExpansions));
  }

  
  /// \brief Build a new atomic type given its value type.
  ///
  /// By default, performs semantic analysis when building the atomic type.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11686,
   FQN="clang::TreeTransform::RebuildAtomicType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildAtomicTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildAtomicTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildAtomicType(QualType ValueType, SourceLocation KWLoc) {
    return SemaRef.BuildAtomicType(new QualType(ValueType), new SourceLocation(KWLoc));
  }

  
  /// \brief Build a new pipe type given its value type.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11692,
   FQN="clang::TreeTransform::RebuildPipeType", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildPipeTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildPipeTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public QualType RebuildPipeType(QualType ValueType, SourceLocation KWLoc) {
    return SemaRef.BuildPipeType(new QualType(ValueType), new SourceLocation(KWLoc));
  }

  
  /// \brief Build a new template name given a nested name specifier, a flag
  /// indicating whether the "template" keyword was provided, and the template
  /// that the template name refers to.
  ///
  /// By default, builds the new template name directly. Subclasses may override
  /// this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11698,
   FQN="clang::TreeTransform::RebuildTemplateName", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecEbPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecEbPNS_12TemplateDeclE")
  //</editor-fold>
  public TemplateName RebuildTemplateName(final CXXScopeSpec /*&*/ SS, 
                     boolean TemplateKW, 
                     TemplateDecl /*P*/ Template) {
    return SemaRef.Context.getQualifiedTemplateName(SS.getScopeRep(), TemplateKW, 
        Template);
  }

  
  /// \brief Build a new template name given a nested name specifier and the
  /// name that is referred to as a template.
  ///
  /// By default, performs semantic analysis to determine whether the name can
  /// be resolved to a specific template, then builds the appropriate kind of
  /// template name. Subclasses may override this routine to provide different
  /// behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11707,
   FQN="clang::TreeTransform::RebuildTemplateName", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecERKNS_14IdentifierInfoENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecERKNS_14IdentifierInfoENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclE")
  //</editor-fold>
  public TemplateName RebuildTemplateName(final CXXScopeSpec /*&*/ SS, 
                     final /*const*/ IdentifierInfo /*&*/ Name, 
                     SourceLocation NameLoc, 
                     QualType ObjectType, 
                     NamedDecl /*P*/ FirstQualifierInScope) {
    UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
    TemplateName.setIdentifier($AddrOf(Name), new SourceLocation(NameLoc));
    OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
    SourceLocation TemplateKWLoc/*J*/= new SourceLocation(); // FIXME: retrieve it from caller.
    getSema().ActOnDependentTemplateName(/*Scope=*/ (Scope /*P*/ )null, 
        SS, new SourceLocation(TemplateKWLoc), TemplateName, 
        OpaquePtr.<QualType>make(new QualType(ObjectType)), 
        /*EnteringContext=*/ false, 
        Template);
    return Template.getTemplateName();
  }

  
  /// \brief Build a new template name given a nested name specifier and the
  /// overloaded operator name that is referred to as a template.
  ///
  /// By default, performs semantic analysis to determine whether the name can
  /// be resolved to a specific template, then builds the appropriate kind of
  /// template name. Subclasses may override this routine to provide different
  /// behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11726,
   FQN="clang::TreeTransform::RebuildTemplateName", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecENS_22OverloadedOperatorKindENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameERNS_12CXXScopeSpecENS_22OverloadedOperatorKindENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public TemplateName RebuildTemplateName(final CXXScopeSpec /*&*/ SS, 
                     OverloadedOperatorKind Operator, 
                     SourceLocation NameLoc, 
                     QualType ObjectType) {
    UnqualifiedId Name/*J*/= new UnqualifiedId();
    // FIXME: Bogus location information.
    SourceLocation SymbolLocations[/*3*/] = new SourceLocation [/*3*/] {NameLoc, NameLoc, NameLoc};
    Name.setOperatorFunctionId(new SourceLocation(NameLoc), Operator, SymbolLocations);
    SourceLocation TemplateKWLoc/*J*/= new SourceLocation(); // FIXME: retrieve it from caller.
    OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
    getSema().ActOnDependentTemplateName(/*Scope=*/ (Scope /*P*/ )null, 
        SS, new SourceLocation(TemplateKWLoc), Name, 
        OpaquePtr.<QualType>make(new QualType(ObjectType)), 
        /*EnteringContext=*/ false, 
        Template);
    return Template.getTemplateName();
  }

  
  /// \brief Build a new template name given a template template parameter pack
  /// and the
  ///
  /// By default, performs semantic analysis to determine whether the name can
  /// be resolved to a specific template, then builds the appropriate kind of
  /// template name. Subclasses may override this routine to provide different
  /// behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1103,
   FQN="clang::TreeTransform::RebuildTemplateName", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildTemplateNameEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE")
  //</editor-fold>
  public TemplateName RebuildTemplateName(TemplateTemplateParmDecl /*P*/ Param, 
                     final /*const*/ TemplateArgument /*&*/ ArgPack) {
    return getSema().Context.getSubstTemplateTemplateParmPack(Param, ArgPack);
  }

  
  /// \brief Build a new compound statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1112,
   FQN="clang::TreeTransform::RebuildCompoundStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCompoundStmtENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4StmtEEES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCompoundStmtENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4StmtEEES4_b")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCompoundStmt(SourceLocation LBraceLoc, 
                     MutableArrayRef<Stmt /*P*/ > Statements, 
                     SourceLocation RBraceLoc, 
                     boolean IsStmtExpr) {
    return getSema().ActOnCompoundStmt(new SourceLocation(LBraceLoc), new SourceLocation(RBraceLoc), new ArrayRef<Stmt /*P*/ >(Statements), 
        IsStmtExpr);
  }

  
  /// \brief Build a new case statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1124,
   FQN="clang::TreeTransform::RebuildCaseStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildCaseStmtENS_14SourceLocationEPNS_4ExprES4_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildCaseStmtENS_14SourceLocationEPNS_4ExprES4_S6_S4_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCaseStmt(SourceLocation CaseLoc, 
                 Expr /*P*/ LHS, 
                 SourceLocation EllipsisLoc, 
                 Expr /*P*/ RHS, 
                 SourceLocation ColonLoc) {
    return getSema().ActOnCaseStmt(new SourceLocation(CaseLoc), LHS, new SourceLocation(EllipsisLoc), RHS, 
        new SourceLocation(ColonLoc));
  }

  
  /// \brief Attach the body to a new case statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCaseStmtBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1137,
   FQN="clang::TreeTransform::RebuildCaseStmtBody", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCaseStmtBodyEPNS_4StmtES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCaseStmtBodyEPNS_4StmtES5_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCaseStmtBody(Stmt /*P*/ S, Stmt /*P*/ Body) {
    getSema().ActOnCaseStmtBody(S, Body);
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
  }

  
  /// \brief Build a new default statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1146,
   FQN="clang::TreeTransform::RebuildDefaultStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildDefaultStmtENS_14SourceLocationES4_PNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildDefaultStmtENS_14SourceLocationES4_PNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildDefaultStmt(SourceLocation DefaultLoc, 
                    SourceLocation ColonLoc, 
                    Stmt /*P*/ SubStmt) {
    return getSema().ActOnDefaultStmt(new SourceLocation(DefaultLoc), new SourceLocation(ColonLoc), SubStmt, 
        /*CurScope=*/ (Scope /*P*/ )null);
  }

  
  /// \brief Build a new label statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1157,
   FQN="clang::TreeTransform::RebuildLabelStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildLabelStmtENS_14SourceLocationEPNS_9LabelDeclES4_PNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildLabelStmtENS_14SourceLocationEPNS_9LabelDeclES4_PNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildLabelStmt(SourceLocation IdentLoc, LabelDecl /*P*/ L, 
                  SourceLocation ColonLoc, Stmt /*P*/ SubStmt) {
    return SemaRef.ActOnLabelStmt(new SourceLocation(IdentLoc), L, new SourceLocation(ColonLoc), SubStmt);
  }

  
  /// \brief Build a new label statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1166,
   FQN="clang::TreeTransform::RebuildAttributedStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildAttributedStmtENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildAttributedStmtENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildAttributedStmt(SourceLocation AttrLoc, 
                       ArrayRef</*const*/ Attr /*P*/ > Attrs, 
                       Stmt /*P*/ SubStmt) {
    return SemaRef.ActOnAttributedStmt(new SourceLocation(AttrLoc), new ArrayRef</*const*/ Attr /*P*/ >(Attrs), SubStmt);
  }

  
  /// \brief Build a new "if" statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1176,
   FQN="clang::TreeTransform::RebuildIfStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13RebuildIfStmtENS_14SourceLocationEbNS_4Sema15ConditionResultEPNS_4StmtES8_S4_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13RebuildIfStmtENS_14SourceLocationEbNS_4Sema15ConditionResultEPNS_4StmtES8_S4_S8_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildIfStmt(SourceLocation IfLoc, boolean IsConstexpr, 
               Sema.ConditionResult Cond, Stmt /*P*/ Init, Stmt /*P*/ Then, 
               SourceLocation ElseLoc, Stmt /*P*/ Else) {
    return getSema().ActOnIfStmt(new SourceLocation(IfLoc), IsConstexpr, Init, new ConditionResult(Cond), Then, 
        new SourceLocation(ElseLoc), Else);
  }

  
  /// \brief Start building a new switch statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSwitchStmtStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1187,
   FQN="clang::TreeTransform::RebuildSwitchStmtStart", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildSwitchStmtStartENS_14SourceLocationEPNS_4StmtENS_4Sema15ConditionResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildSwitchStmtStartENS_14SourceLocationEPNS_4StmtENS_4Sema15ConditionResultE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildSwitchStmtStart(SourceLocation SwitchLoc, Stmt /*P*/ Init, 
                        Sema.ConditionResult Cond) {
    return getSema().ActOnStartOfSwitchStmt(new SourceLocation(SwitchLoc), Init, new ConditionResult(Cond));
  }

  
  /// \brief Attach the body to the switch statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSwitchStmtBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1196,
   FQN="clang::TreeTransform::RebuildSwitchStmtBody", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSwitchStmtBodyENS_14SourceLocationEPNS_4StmtES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSwitchStmtBodyENS_14SourceLocationEPNS_4StmtES6_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildSwitchStmtBody(SourceLocation SwitchLoc, 
                       Stmt /*P*/ Switch, Stmt /*P*/ Body) {
    return getSema().ActOnFinishSwitchStmt(new SourceLocation(SwitchLoc), Switch, Body);
  }

  
  /// \brief Build a new while statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1205,
   FQN="clang::TreeTransform::RebuildWhileStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildWhileStmtENS_14SourceLocationENS_4Sema15ConditionResultEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildWhileStmtENS_14SourceLocationENS_4Sema15ConditionResultEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildWhileStmt(SourceLocation WhileLoc, 
                  Sema.ConditionResult Cond, Stmt /*P*/ Body) {
    return getSema().ActOnWhileStmt(new SourceLocation(WhileLoc), new ConditionResult(Cond), Body);
  }

  
  /// \brief Build a new do-while statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1214,
   FQN="clang::TreeTransform::RebuildDoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13RebuildDoStmtENS_14SourceLocationEPNS_4StmtES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE13RebuildDoStmtENS_14SourceLocationEPNS_4StmtES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildDoStmt(SourceLocation DoLoc, Stmt /*P*/ Body, 
               SourceLocation WhileLoc, SourceLocation LParenLoc, 
               Expr /*P*/ Cond, SourceLocation RParenLoc) {
    return getSema().ActOnDoStmt(new SourceLocation(DoLoc), Body, new SourceLocation(WhileLoc), new SourceLocation(LParenLoc), 
        Cond, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new for statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1225,
   FQN="clang::TreeTransform::RebuildForStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE14RebuildForStmtENS_14SourceLocationES4_PNS_4StmtENS_4Sema15ConditionResultENS7_11FullExprArgES4_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE14RebuildForStmtENS_14SourceLocationES4_PNS_4StmtENS_4Sema15ConditionResultENS7_11FullExprArgES4_S6_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildForStmt(SourceLocation ForLoc, SourceLocation LParenLoc, 
                Stmt /*P*/ Init, Sema.ConditionResult Cond, 
                Sema.FullExprArg Inc, SourceLocation RParenLoc, 
                Stmt /*P*/ Body) {
    return getSema().ActOnForStmt(new SourceLocation(ForLoc), new SourceLocation(LParenLoc), Init, new ConditionResult(Cond), 
        new FullExprArg(Inc), new SourceLocation(RParenLoc), Body);
  }

  
  /// \brief Build a new goto statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1237,
   FQN="clang::TreeTransform::RebuildGotoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildGotoStmtENS_14SourceLocationES4_PNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildGotoStmtENS_14SourceLocationES4_PNS_9LabelDeclE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildGotoStmt(SourceLocation GotoLoc, SourceLocation LabelLoc, 
                 LabelDecl /*P*/ Label) {
    return getSema().ActOnGotoStmt(new SourceLocation(GotoLoc), new SourceLocation(LabelLoc), Label);
  }

  
  /// \brief Build a new indirect goto statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1246,
   FQN="clang::TreeTransform::RebuildIndirectGotoStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildIndirectGotoStmtENS_14SourceLocationES4_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildIndirectGotoStmtENS_14SourceLocationES4_PNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildIndirectGotoStmt(SourceLocation GotoLoc, 
                         SourceLocation StarLoc, 
                         Expr /*P*/ Target) {
    return getSema().ActOnIndirectGotoStmt(new SourceLocation(GotoLoc), new SourceLocation(StarLoc), Target);
  }

  
  /// \brief Build a new return statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1256,
   FQN="clang::TreeTransform::RebuildReturnStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildReturnStmtENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildReturnStmtENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildReturnStmt(SourceLocation ReturnLoc, Expr /*P*/ Result) {
    return getSema().BuildReturnStmt(new SourceLocation(ReturnLoc), create_type$ptr(Result));
  }

  
  /// \brief Build a new declaration statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1264,
   FQN="clang::TreeTransform::RebuildDeclStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildDeclStmtEN4llvm15MutableArrayRefIPNS_4DeclEEENS_14SourceLocationES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildDeclStmtEN4llvm15MutableArrayRefIPNS_4DeclEEENS_14SourceLocationES9_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildDeclStmt(MutableArrayRef<Decl /*P*/ > Decls, 
                 SourceLocation StartLoc, SourceLocation EndLoc) {
    OpaquePtr<DeclGroupRef> DG = getSema().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(Decls));
    return getSema().ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(DG), new SourceLocation(StartLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new inline asm statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1274,
   FQN="clang::TreeTransform::RebuildGCCAsmStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildGCCAsmStmtENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEN4llvm15MutableArrayRefIPNS_4ExprEEESC_SB_SC_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildGCCAsmStmtENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEN4llvm15MutableArrayRefIPNS_4ExprEEESC_SB_SC_S4_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildGCCAsmStmt(SourceLocation AsmLoc, boolean IsSimple, 
                   boolean IsVolatile, /*uint*/int NumOutputs, 
                   /*uint*/int NumInputs, type$ptr<IdentifierInfo /*P*/ /*P*/> Names, 
                   MutableArrayRef<Expr /*P*/ > Constraints, MutableArrayRef<Expr /*P*/ > Exprs, 
                   Expr /*P*/ AsmString, MutableArrayRef<Expr /*P*/ > Clobbers, 
                   SourceLocation RParenLoc) {
    return getSema().ActOnGCCAsmStmt(new SourceLocation(AsmLoc), IsSimple, IsVolatile, NumOutputs, 
        NumInputs, Names, new MutableArrayRef<Expr /*P*/ >(Constraints), new MutableArrayRef<Expr /*P*/ >(Exprs), 
        AsmString, new MutableArrayRef<Expr /*P*/ >(Clobbers), new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new MS style inline asm statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1289,
   FQN="clang::TreeTransform::RebuildMSAsmStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildMSAsmStmtENS_14SourceLocationES4_N4llvm8ArrayRefINS_5TokenEEENS5_9StringRefEjjNS6_IS9_EESA_NS6_IPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildMSAsmStmtENS_14SourceLocationES4_N4llvm8ArrayRefINS_5TokenEEENS5_9StringRefEjjNS6_IS9_EESA_NS6_IPNS_4ExprEEES4_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildMSAsmStmt(SourceLocation AsmLoc, SourceLocation LBraceLoc, 
                  ArrayRefToken AsmToks, 
                  StringRef AsmString, 
                  /*uint*/int NumOutputs, /*uint*/int NumInputs, 
                  ArrayRef<StringRef> Constraints, 
                  ArrayRef<StringRef> Clobbers, 
                  ArrayRef<Expr /*P*/ > Exprs, 
                  SourceLocation EndLoc) {
    return getSema().ActOnMSAsmStmt(new SourceLocation(AsmLoc), new SourceLocation(LBraceLoc), new ArrayRefToken(AsmToks), new StringRef(AsmString), 
        NumOutputs, NumInputs, 
        new ArrayRef<StringRef>(Constraints), new ArrayRef<StringRef>(Clobbers), new ArrayRef<Expr /*P*/ >(Exprs), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new co_return statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1306,
   FQN="clang::TreeTransform::RebuildCoreturnStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCoreturnStmtENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCoreturnStmtENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCoreturnStmt(SourceLocation CoreturnLoc, Expr /*P*/ Result) {
    return getSema().BuildCoreturnStmt(new SourceLocation(CoreturnLoc), Result);
  }

  
  /// \brief Build a new co_await expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1314,
   FQN="clang::TreeTransform::RebuildCoawaitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCoawaitExprENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCoawaitExprENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCoawaitExpr(SourceLocation CoawaitLoc, Expr /*P*/ Result) {
    return getSema().BuildCoawaitExpr(new SourceLocation(CoawaitLoc), Result);
  }

  
  /// \brief Build a new co_yield expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1322,
   FQN="clang::TreeTransform::RebuildCoyieldExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCoyieldExprENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCoyieldExprENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCoyieldExpr(SourceLocation CoyieldLoc, Expr /*P*/ Result) {
    return getSema().BuildCoyieldExpr(new SourceLocation(CoyieldLoc), Result);
  }

  
  /// \brief Build a new Objective-C \@try statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1330,
   FQN="clang::TreeTransform::RebuildObjCAtTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildObjCAtTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm15MutableArrayRefIS6_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildObjCAtTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm15MutableArrayRefIS6_EES6_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAtTryStmt(SourceLocation AtLoc, 
                      Stmt /*P*/ TryBody, 
                      MutableArrayRef<Stmt /*P*/ > CatchStmts, 
                      Stmt /*P*/ Finally) {
    return getSema().ActOnObjCAtTryStmt(new SourceLocation(AtLoc), TryBody, new MutableArrayRef<Stmt /*P*/ >(CatchStmts), 
        Finally);
  }

  
  /// \brief Rebuild an Objective-C exception declaration.
  ///
  /// By default, performs semantic analysis to build the new declaration.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCExceptionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1342,
   FQN="clang::TreeTransform::RebuildObjCExceptionDecl", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildObjCExceptionDeclEPNS_7VarDeclEPNS_14TypeSourceInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildObjCExceptionDeclEPNS_7VarDeclEPNS_14TypeSourceInfoENS_8QualTypeE")
  //</editor-fold>
  public VarDecl /*P*/ RebuildObjCExceptionDecl(VarDecl /*P*/ ExceptionDecl, 
                          TypeSourceInfo /*P*/ TInfo, QualType T) {
    return getSema().BuildObjCExceptionDecl(TInfo, new QualType(T), 
        ExceptionDecl.getInnerLocStart(), 
        ExceptionDecl.getLocation(), 
        ExceptionDecl.getIdentifier());
  }

  
  /// \brief Build a new Objective-C \@catch statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1354,
   FQN="clang::TreeTransform::RebuildObjCAtCatchStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCAtCatchStmtENS_14SourceLocationES4_PNS_7VarDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCAtCatchStmtENS_14SourceLocationES4_PNS_7VarDeclEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAtCatchStmt(SourceLocation AtLoc, 
                        SourceLocation RParenLoc, 
                        VarDecl /*P*/ Var, 
                        Stmt /*P*/ Body) {
    return getSema().ActOnObjCAtCatchStmt(new SourceLocation(AtLoc), new SourceLocation(RParenLoc), 
        Var, Body);
  }

  
  /// \brief Build a new Objective-C \@finally statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1366,
   FQN="clang::TreeTransform::RebuildObjCAtFinallyStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildObjCAtFinallyStmtENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildObjCAtFinallyStmtENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAtFinallyStmt(SourceLocation AtLoc, 
                          Stmt /*P*/ Body) {
    return getSema().ActOnObjCAtFinallyStmt(new SourceLocation(AtLoc), Body);
  }

  
  /// \brief Build a new Objective-C \@throw statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1375,
   FQN="clang::TreeTransform::RebuildObjCAtThrowStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAtThrowStmt(SourceLocation AtLoc, 
                        Expr /*P*/ Operand) {
    return getSema().BuildObjCAtThrowStmt(new SourceLocation(AtLoc), Operand);
  }

  
  /// \brief Build a new OpenMP executable directive.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1384,
   FQN="clang::TreeTransform::RebuildOMPExecutableDirective", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildOMPExecutableDirectiveENS_19OpenMPDirectiveKindENS_19DeclarationNameInfoES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildOMPExecutableDirectiveENS_19OpenMPDirectiveKindENS_19DeclarationNameInfoES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESD_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildOMPExecutableDirective(OpenMPDirectiveKind Kind, 
                               DeclarationNameInfo DirName, 
                               OpenMPDirectiveKind CancelRegion, 
                               ArrayRef<OMPClause /*P*/ > Clauses, 
                               Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                               SourceLocation EndLoc) {
    return getSema().ActOnOpenMPExecutableDirective(Kind, DirName, CancelRegion, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'if' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1398,
   FQN="clang::TreeTransform::RebuildOMPIfClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildOMPIfClauseENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES7_S7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildOMPIfClauseENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES7_S7_S7_S7_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPIfClause(OpenMPDirectiveKind NameModifier, 
                    Expr /*P*/ Condition, SourceLocation StartLoc, 
                    SourceLocation LParenLoc, 
                    SourceLocation NameModifierLoc, 
                    SourceLocation ColonLoc, 
                    SourceLocation EndLoc) {
    return getSema().ActOnOpenMPIfClause(NameModifier, Condition, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(NameModifierLoc), new SourceLocation(ColonLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'final' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1413,
   FQN="clang::TreeTransform::RebuildOMPFinalClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildOMPFinalClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildOMPFinalClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPFinalClause(Expr /*P*/ Condition, SourceLocation StartLoc, 
                       SourceLocation LParenLoc, 
                       SourceLocation EndLoc) {
    return getSema().ActOnOpenMPFinalClause(Condition, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'num_threads' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1424,
   FQN="clang::TreeTransform::RebuildOMPNumThreadsClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildOMPNumThreadsClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildOMPNumThreadsClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPNumThreadsClause(Expr /*P*/ NumThreads, 
                            SourceLocation StartLoc, 
                            SourceLocation LParenLoc, 
                            SourceLocation EndLoc) {
    return getSema().ActOnOpenMPNumThreadsClause(NumThreads, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'safelen' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1436,
   FQN="clang::TreeTransform::RebuildOMPSafelenClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPSafelenClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPSafelenClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPSafelenClause(Expr /*P*/ Len, SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
    return getSema().ActOnOpenMPSafelenClause(Len, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'simdlen' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1446,
   FQN="clang::TreeTransform::RebuildOMPSimdlenClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPSimdlenClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPSimdlenClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPSimdlenClause(Expr /*P*/ Len, SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
    return getSema().ActOnOpenMPSimdlenClause(Len, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'collapse' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1456,
   FQN="clang::TreeTransform::RebuildOMPCollapseClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPCollapseClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPCollapseClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPCollapseClause(Expr /*P*/ Num, SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
    return getSema().ActOnOpenMPCollapseClause(Num, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'default' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1467,
   FQN="clang::TreeTransform::RebuildOMPDefaultClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPDefaultClauseENS_23OpenMPDefaultClauseKindENS_14SourceLocationES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPDefaultClauseENS_23OpenMPDefaultClauseKindENS_14SourceLocationES5_S5_S5_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPDefaultClause(OpenMPDefaultClauseKind Kind, 
                         SourceLocation KindKwLoc, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
    return getSema().ActOnOpenMPDefaultClause(Kind, new SourceLocation(KindKwLoc), 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'proc_bind' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1480,
   FQN="clang::TreeTransform::RebuildOMPProcBindClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPProcBindClauseENS_24OpenMPProcBindClauseKindENS_14SourceLocationES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPProcBindClauseENS_24OpenMPProcBindClauseKindENS_14SourceLocationES5_S5_S5_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPProcBindClause(OpenMPProcBindClauseKind Kind, 
                          SourceLocation KindKwLoc, 
                          SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
    return getSema().ActOnOpenMPProcBindClause(Kind, new SourceLocation(KindKwLoc), 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'schedule' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1493,
   FQN="clang::TreeTransform::RebuildOMPScheduleClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPScheduleClauseENS_28OpenMPScheduleClauseModifierES4_NS_24OpenMPScheduleClauseKindEPNS_4ExprENS_14SourceLocationES8_S8_S8_S8_S8_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPScheduleClauseENS_28OpenMPScheduleClauseModifierES4_NS_24OpenMPScheduleClauseKindEPNS_4ExprENS_14SourceLocationES8_S8_S8_S8_S8_S8_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPScheduleClause(/*OpenMPScheduleClauseModifier*/int M1, /*OpenMPScheduleClauseModifier*/int M2, 
                          /*OpenMPScheduleClauseKind*/int Kind, Expr /*P*/ ChunkSize, SourceLocation StartLoc, 
                          SourceLocation LParenLoc, SourceLocation M1Loc, SourceLocation M2Loc, 
                          SourceLocation KindLoc, SourceLocation CommaLoc, SourceLocation EndLoc) {
    return getSema().ActOnOpenMPScheduleClause(M1, M2, Kind, ChunkSize, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(M1Loc), new SourceLocation(M2Loc), new SourceLocation(KindLoc), 
        new SourceLocation(CommaLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'ordered' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1507,
   FQN="clang::TreeTransform::RebuildOMPOrderedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPOrderedClauseENS_14SourceLocationES4_S4_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPOrderedClauseENS_14SourceLocationES4_S4_PNS_4ExprE")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPOrderedClause(SourceLocation StartLoc, 
                         SourceLocation EndLoc, 
                         SourceLocation LParenLoc, Expr /*P*/ Num) {
    return getSema().ActOnOpenMPOrderedClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc), new SourceLocation(LParenLoc), Num);
  }

  
  /// \brief Build a new OpenMP 'private' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1517,
   FQN="clang::TreeTransform::RebuildOMPPrivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPPrivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPPrivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPPrivateClause(ArrayRef<Expr /*P*/ > VarList, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
    return getSema().ActOnOpenMPPrivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'firstprivate' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1529,
   FQN="clang::TreeTransform::RebuildOMPFirstprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPFirstprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPFirstprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPFirstprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                              SourceLocation StartLoc, 
                              SourceLocation LParenLoc, 
                              SourceLocation EndLoc) {
    return getSema().ActOnOpenMPFirstprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'lastprivate' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1541,
   FQN="clang::TreeTransform::RebuildOMPLastprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPLastprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPLastprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPLastprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
    return getSema().ActOnOpenMPLastprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'shared' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1553,
   FQN="clang::TreeTransform::RebuildOMPSharedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPSharedClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPSharedClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPSharedClause(ArrayRef<Expr /*P*/ > VarList, 
                        SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
    return getSema().ActOnOpenMPSharedClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'reduction' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1565,
   FQN="clang::TreeTransform::RebuildOMPReductionClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildOMPReductionClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_S9_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildOMPReductionClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_S9_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES8_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPReductionClause(ArrayRef<Expr /*P*/ > VarList, 
                           SourceLocation StartLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation ColonLoc, 
                           SourceLocation EndLoc, 
                           final CXXScopeSpec /*&*/ ReductionIdScopeSpec, 
                           final /*const*/ DeclarationNameInfo /*&*/ ReductionId, 
                           ArrayRef<Expr /*P*/ > UnresolvedReductions) {
    return getSema().ActOnOpenMPReductionClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc), ReductionIdScopeSpec, 
        ReductionId, new ArrayRef<Expr /*P*/ >(UnresolvedReductions));
  }

  
  /// \brief Build a new OpenMP 'linear' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1582,
   FQN="clang::TreeTransform::RebuildOMPLinearClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPLinearClauseEN4llvm8ArrayRefIPNS_4ExprEEES7_NS_14SourceLocationES9_NS_22OpenMPLinearClauseKindES9_S9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPLinearClauseEN4llvm8ArrayRefIPNS_4ExprEEES7_NS_14SourceLocationES9_NS_22OpenMPLinearClauseKindES9_S9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPLinearClause(ArrayRef<Expr /*P*/ > VarList, Expr /*P*/ Step, 
                        SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        OpenMPLinearClauseKind Modifier, 
                        SourceLocation ModifierLoc, 
                        SourceLocation ColonLoc, 
                        SourceLocation EndLoc) {
    return getSema().ActOnOpenMPLinearClause(new ArrayRef<Expr /*P*/ >(VarList), Step, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        Modifier, new SourceLocation(ModifierLoc), new SourceLocation(ColonLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'aligned' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1598,
   FQN="clang::TreeTransform::RebuildOMPAlignedClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPAlignedClauseEN4llvm8ArrayRefIPNS_4ExprEEES7_NS_14SourceLocationES9_S9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildOMPAlignedClauseEN4llvm8ArrayRefIPNS_4ExprEEES7_NS_14SourceLocationES9_S9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPAlignedClause(ArrayRef<Expr /*P*/ > VarList, Expr /*P*/ Alignment, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation ColonLoc, 
                         SourceLocation EndLoc) {
    return getSema().ActOnOpenMPAlignedClause(new ArrayRef<Expr /*P*/ >(VarList), Alignment, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'copyin' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1611,
   FQN="clang::TreeTransform::RebuildOMPCopyinClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPCopyinClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPCopyinClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPCopyinClause(ArrayRef<Expr /*P*/ > VarList, 
                        SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
    return getSema().ActOnOpenMPCopyinClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'copyprivate' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1623,
   FQN="clang::TreeTransform::RebuildOMPCopyprivateClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPCopyprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPCopyprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPCopyprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
    return getSema().ActOnOpenMPCopyprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'flush' pseudo clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1635,
   FQN="clang::TreeTransform::RebuildOMPFlushClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildOMPFlushClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildOMPFlushClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPFlushClause(ArrayRef<Expr /*P*/ > VarList, 
                       SourceLocation StartLoc, 
                       SourceLocation LParenLoc, 
                       SourceLocation EndLoc) {
    return getSema().ActOnOpenMPFlushClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'depend' pseudo clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1647,
   FQN="clang::TreeTransform::RebuildOMPDependClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPDependClauseENS_22OpenMPDependClauseKindENS_14SourceLocationES5_N4llvm8ArrayRefIPNS_4ExprEEES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPDependClauseENS_22OpenMPDependClauseKindENS_14SourceLocationES5_N4llvm8ArrayRefIPNS_4ExprEEES5_S5_S5_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPDependClause(OpenMPDependClauseKind DepKind, SourceLocation DepLoc, 
                        SourceLocation ColonLoc, ArrayRef<Expr /*P*/ > VarList, 
                        SourceLocation StartLoc, SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
    return getSema().ActOnOpenMPDependClause(DepKind, new SourceLocation(DepLoc), new SourceLocation(ColonLoc), new ArrayRef<Expr /*P*/ >(VarList), 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'device' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1660,
   FQN="clang::TreeTransform::RebuildOMPDeviceClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPDeviceClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildOMPDeviceClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPDeviceClause(Expr /*P*/ Device, SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
    return getSema().ActOnOpenMPDeviceClause(Device, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'map' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1671,
   FQN="clang::TreeTransform::RebuildOMPMapClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildOMPMapClauseENS_19OpenMPMapClauseKindES4_bNS_14SourceLocationES5_N4llvm8ArrayRefIPNS_4ExprEEES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildOMPMapClauseENS_19OpenMPMapClauseKindES4_bNS_14SourceLocationES5_N4llvm8ArrayRefIPNS_4ExprEEES5_S5_S5_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPMapClause(OpenMPMapClauseKind MapTypeModifier, 
                     OpenMPMapClauseKind MapType, boolean IsMapTypeImplicit, 
                     SourceLocation MapLoc, SourceLocation ColonLoc, 
                     ArrayRef<Expr /*P*/ > VarList, SourceLocation StartLoc, 
                     SourceLocation LParenLoc, SourceLocation EndLoc) {
    return getSema().ActOnOpenMPMapClause(MapTypeModifier, MapType, 
        IsMapTypeImplicit, new SourceLocation(MapLoc), new SourceLocation(ColonLoc), 
        new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'num_teams' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1686,
   FQN="clang::TreeTransform::RebuildOMPNumTeamsClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPNumTeamsClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPNumTeamsClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPNumTeamsClause(Expr /*P*/ NumTeams, SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
    return getSema().ActOnOpenMPNumTeamsClause(NumTeams, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'thread_limit' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1697,
   FQN="clang::TreeTransform::RebuildOMPThreadLimitClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPThreadLimitClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPThreadLimitClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPThreadLimitClause(Expr /*P*/ ThreadLimit, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
    return getSema().ActOnOpenMPThreadLimitClause(ThreadLimit, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'priority' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1709,
   FQN="clang::TreeTransform::RebuildOMPPriorityClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPPriorityClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPPriorityClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPPriorityClause(Expr /*P*/ Priority, SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
    return getSema().ActOnOpenMPPriorityClause(Priority, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'grainsize' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1720,
   FQN="clang::TreeTransform::RebuildOMPGrainsizeClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildOMPGrainsizeClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildOMPGrainsizeClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPGrainsizeClause(Expr /*P*/ Grainsize, SourceLocation StartLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation EndLoc) {
    return getSema().ActOnOpenMPGrainsizeClause(Grainsize, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'num_tasks' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1731,
   FQN="clang::TreeTransform::RebuildOMPNumTasksClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPNumTasksClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildOMPNumTasksClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPNumTasksClause(Expr /*P*/ NumTasks, SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
    return getSema().ActOnOpenMPNumTasksClause(NumTasks, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'hint' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1742,
   FQN="clang::TreeTransform::RebuildOMPHintClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildOMPHintClauseEPNS_4ExprENS_14SourceLocationES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildOMPHintClauseEPNS_4ExprENS_14SourceLocationES6_S6_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPHintClause(Expr /*P*/ Hint, SourceLocation StartLoc, 
                      SourceLocation LParenLoc, 
                      SourceLocation EndLoc) {
    return getSema().ActOnOpenMPHintClause(Hint, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'dist_schedule' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1752,
   FQN="clang::TreeTransform::RebuildOMPDistScheduleClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPDistScheduleClauseENS_28OpenMPDistScheduleClauseKindEPNS_4ExprENS_14SourceLocationES7_S7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPDistScheduleClauseENS_28OpenMPDistScheduleClauseKindEPNS_4ExprENS_14SourceLocationES7_S7_S7_S7_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPDistScheduleClause(/*OpenMPDistScheduleClauseKind*/int Kind, 
                              Expr /*P*/ ChunkSize, SourceLocation StartLoc, 
                              SourceLocation LParenLoc, SourceLocation KindLoc, 
                              SourceLocation CommaLoc, SourceLocation EndLoc) {
    return getSema().ActOnOpenMPDistScheduleClause(Kind, ChunkSize, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(KindLoc), new SourceLocation(CommaLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'to' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1765,
   FQN="clang::TreeTransform::RebuildOMPToClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildOMPToClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildOMPToClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPToClause(ArrayRef<Expr /*P*/ > VarList, 
                    SourceLocation StartLoc, 
                    SourceLocation LParenLoc, 
                    SourceLocation EndLoc) {
    return getSema().ActOnOpenMPToClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
  }

  
  /// \brief Build a new OpenMP 'from' clause.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1776,
   FQN="clang::TreeTransform::RebuildOMPFromClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildOMPFromClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildOMPFromClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPFromClause(ArrayRef<Expr /*P*/ > VarList, 
                      SourceLocation StartLoc, 
                      SourceLocation LParenLoc, 
                      SourceLocation EndLoc) {
    return getSema().ActOnOpenMPFromClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// Build a new OpenMP 'use_device_ptr' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1788,
   FQN="clang::TreeTransform::RebuildOMPUseDevicePtrClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPUseDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildOMPUseDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPUseDevicePtrClause(ArrayRef<Expr /*P*/ > VarList, 
                              SourceLocation StartLoc, 
                              SourceLocation LParenLoc, 
                              SourceLocation EndLoc) {
    return getSema().ActOnOpenMPUseDevicePtrClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// Build a new OpenMP 'is_device_ptr' clause.
  ///
  /// By default, performs semantic analysis to build the new OpenMP clause.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1800,
   FQN="clang::TreeTransform::RebuildOMPIsDevicePtrClause", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPIsDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildOMPIsDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public OMPClause /*P*/ RebuildOMPIsDevicePtrClause(ArrayRef<Expr /*P*/ > VarList, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
    return getSema().ActOnOpenMPIsDevicePtrClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc));
  }

  
  /// \brief Rebuild the operand to an Objective-C \@synchronized statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtSynchronizedOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1812,
   FQN="clang::TreeTransform::RebuildObjCAtSynchronizedOperand", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32RebuildObjCAtSynchronizedOperandENS_14SourceLocationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32RebuildObjCAtSynchronizedOperandENS_14SourceLocationEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCAtSynchronizedOperand(SourceLocation atLoc, 
                                  Expr /*P*/ object) {
    return getSema().ActOnObjCAtSynchronizedOperand(new SourceLocation(atLoc), object);
  }

  
  /// \brief Build a new Objective-C \@synchronized statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1821,
   FQN="clang::TreeTransform::RebuildObjCAtSynchronizedStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildObjCAtSynchronizedStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildObjCAtSynchronizedStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAtSynchronizedStmt(SourceLocation AtLoc, 
                               Expr /*P*/ Object, Stmt /*P*/ Body) {
    return getSema().ActOnObjCAtSynchronizedStmt(new SourceLocation(AtLoc), Object, Body);
  }

  
  /// \brief Build a new Objective-C \@autoreleasepool statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1830,
   FQN="clang::TreeTransform::RebuildObjCAutoreleasePoolStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildObjCAutoreleasePoolStmtENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildObjCAutoreleasePoolStmtENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCAutoreleasePoolStmt(SourceLocation AtLoc, 
                                Stmt /*P*/ Body) {
    return getSema().ActOnObjCAutoreleasePoolStmt(new SourceLocation(AtLoc), Body);
  }

  
  /// \brief Build a new Objective-C fast enumeration statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1839,
   FQN="clang::TreeTransform::RebuildObjCForCollectionStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCForCollectionStmtENS_14SourceLocationEPNS_4StmtEPNS_4ExprES4_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCForCollectionStmtENS_14SourceLocationEPNS_4StmtEPNS_4ExprES4_S6_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildObjCForCollectionStmt(SourceLocation ForLoc, 
                              Stmt /*P*/ Element, 
                              Expr /*P*/ Collection, 
                              SourceLocation RParenLoc, 
                              Stmt /*P*/ Body) {
    ActionResultTTrue<Stmt /*P*/ > ForEachStmt = getSema().ActOnObjCForCollectionStmt(new SourceLocation(ForLoc), 
        Element, 
        Collection, 
        new SourceLocation(RParenLoc));
    if (ForEachStmt.isInvalid()) {
      return StmtError();
    }
    
    return getSema().FinishObjCForCollectionStmt(ForEachStmt.get(), Body);
  }

  
  /// \brief Build a new C++ exception declaration.
  ///
  /// By default, performs semantic analysis to build the new decaration.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildExceptionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1858,
   FQN="clang::TreeTransform::RebuildExceptionDecl", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildExceptionDeclEPNS_7VarDeclEPNS_14TypeSourceInfoENS_14SourceLocationES8_PNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildExceptionDeclEPNS_7VarDeclEPNS_14TypeSourceInfoENS_14SourceLocationES8_PNS_14IdentifierInfoE")
  //</editor-fold>
  public VarDecl /*P*/ RebuildExceptionDecl(VarDecl /*P*/ ExceptionDecl, 
                      TypeSourceInfo /*P*/ Declarator, 
                      SourceLocation StartLoc, 
                      SourceLocation IdLoc, 
                      IdentifierInfo /*P*/ Id) {
    VarDecl /*P*/ Var = getSema().BuildExceptionDeclaration((Scope /*P*/ )null, Declarator, 
        new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id);
    if ((Var != null)) {
      getSema().CurContext.addDecl(Var);
    }
    return Var;
  }

  
  /// \brief Build a new C++ catch statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1874,
   FQN="clang::TreeTransform::RebuildCXXCatchStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCXXCatchStmtENS_14SourceLocationEPNS_7VarDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCXXCatchStmtENS_14SourceLocationEPNS_7VarDeclEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCXXCatchStmt(SourceLocation CatchLoc, 
                     VarDecl /*P*/ ExceptionDecl, 
                     Stmt /*P*/ Handler) {
    return Owned(/*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new CXXCatchStmt(new SourceLocation(CatchLoc), ExceptionDecl, 
            Handler)));
  }

  
  /// \brief Build a new C++ try statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1885,
   FQN="clang::TreeTransform::RebuildCXXTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildCXXTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildCXXTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS6_EE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCXXTryStmt(SourceLocation TryLoc, Stmt /*P*/ TryBlock, 
                   ArrayRef<Stmt /*P*/ > Handlers) {
    return getSema().ActOnCXXTryBlock(new SourceLocation(TryLoc), TryBlock, new ArrayRef<Stmt /*P*/ >(Handlers));
  }

  
  /// \brief Build a new C++0x range-based for statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1894,
   FQN="clang::TreeTransform::RebuildCXXForRangeStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildCXXForRangeStmtENS_14SourceLocationES4_S4_PNS_4StmtES6_S6_PNS_4ExprES8_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildCXXForRangeStmtENS_14SourceLocationES4_S4_PNS_4StmtES6_S6_PNS_4ExprES8_S6_S4_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildCXXForRangeStmt(SourceLocation ForLoc, 
                        SourceLocation CoawaitLoc, 
                        SourceLocation ColonLoc, 
                        Stmt /*P*/ Range, Stmt /*P*/ Begin, Stmt /*P*/ End, 
                        Expr /*P*/ Cond, Expr /*P*/ Inc, 
                        Stmt /*P*/ LoopVar, 
                        SourceLocation RParenLoc) {
    {
      // If we've just learned that the range is actually an Objective-C
      // collection, treat this as an Objective-C fast enumeration loop.
      DeclStmt /*P*/ RangeStmt = dyn_cast_DeclStmt(Range);
      if ((RangeStmt != null)) {
        if (RangeStmt.isSingleDecl()) {
          {
            VarDecl /*P*/ RangeVar = dyn_cast_VarDecl(RangeStmt.getSingleDecl());
            if ((RangeVar != null)) {
              if (RangeVar.isInvalidDecl()) {
                return StmtError();
              }
              
              Expr /*P*/ RangeExpr = RangeVar.getInit();
              if (!RangeExpr.isTypeDependent()
                 && RangeExpr.getType().$arrow().isObjCObjectPointerType()) {
                return getSema().ActOnObjCForCollectionStmt(new SourceLocation(ForLoc), LoopVar, RangeExpr, 
                    new SourceLocation(RParenLoc));
              }
            }
          }
        }
      }
    }
    
    return getSema().BuildCXXForRangeStmt(new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), new SourceLocation(ColonLoc), 
        Range, Begin, End, 
        Cond, Inc, LoopVar, new SourceLocation(RParenLoc), 
        Sema.BuildForRangeKind.BFRK_Rebuild);
  }

  
  /// \brief Build a new C++0x range-based for statement.
  ///
  /// By default, performs semantic analysis to build the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1928,
   FQN="clang::TreeTransform::RebuildMSDependentExistsStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildMSDependentExistsStmtENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildMSDependentExistsStmtENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildMSDependentExistsStmt(SourceLocation KeywordLoc, 
                              boolean IsIfExists, 
                              NestedNameSpecifierLoc QualifierLoc, 
                              DeclarationNameInfo NameInfo, 
                              Stmt /*P*/ Nested) {
    return getSema().BuildMSDependentExistsStmt(new SourceLocation(KeywordLoc), IsIfExists, 
        new NestedNameSpecifierLoc(QualifierLoc), new DeclarationNameInfo(NameInfo), Nested);
  }

  
  /// \brief Attach body to a C++0x range-based for statement.
  ///
  /// By default, performs semantic analysis to finish the new statement.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::FinishCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1941,
   FQN="clang::TreeTransform::FinishCXXForRangeStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21FinishCXXForRangeStmtEPNS_4StmtES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21FinishCXXForRangeStmtEPNS_4StmtES5_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > FinishCXXForRangeStmt(Stmt /*P*/ ForRange, Stmt /*P*/ Body) {
    return getSema().FinishCXXForRangeStmt(ForRange, Body);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1945,
   FQN="clang::TreeTransform::RebuildSEHTryStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildSEHTryStmtEbNS_14SourceLocationEPNS_4StmtES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildSEHTryStmtEbNS_14SourceLocationEPNS_4StmtES6_")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildSEHTryStmt(boolean IsCXXTry, SourceLocation TryLoc, 
                   Stmt /*P*/ TryBlock, Stmt /*P*/ Handler) {
    return getSema().ActOnSEHTryBlock(IsCXXTry, new SourceLocation(TryLoc), TryBlock, Handler);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1950,
   FQN="clang::TreeTransform::RebuildSEHExceptStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildSEHExceptStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildSEHExceptStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildSEHExceptStmt(SourceLocation Loc, Expr /*P*/ FilterExpr, 
                      Stmt /*P*/ Block) {
    return getSema().ActOnSEHExceptBlock(new SourceLocation(Loc), FilterExpr, Block);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1955,
   FQN="clang::TreeTransform::RebuildSEHFinallyStmt", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSEHFinallyStmtENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSEHFinallyStmtENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > RebuildSEHFinallyStmt(SourceLocation Loc, Stmt /*P*/ Block) {
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SEHFinallyStmt.Create(getSema().getASTContext(), new SourceLocation(Loc), Block));
  }

  
  /// \brief Build a new predefined expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1963,
   FQN="clang::TreeTransform::RebuildPredefinedExpr", NM="_ZN5clang13TreeTransform21RebuildPredefinedExprENS_14SourceLocationENS_14PredefinedExpr9IdentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang13TreeTransform21RebuildPredefinedExprENS_14SourceLocationENS_14PredefinedExpr9IdentTypeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildPredefinedExpr(SourceLocation Loc, 
                       PredefinedExpr.IdentType IT) {
    return getSema().BuildPredefinedExpr(Loc, IT);
  }


  
  /// \brief Build a new expression that references a declaration.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDeclarationNameExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1972,
   FQN="clang::TreeTransform::RebuildDeclarationNameExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildDeclarationNameExprERKNS_12CXXScopeSpecERNS_12LookupResultEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildDeclarationNameExprERKNS_12CXXScopeSpecERNS_12LookupResultEb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                            final LookupResult /*&*/ R, 
                            boolean RequiresADL) {
    return getSema().BuildDeclarationNameExpr(SS, R, RequiresADL);
  }

  
  /// \brief Build a new expression that references a declaration.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1983,
   FQN="clang::TreeTransform::RebuildDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildDeclRefExprENS_22NestedNameSpecifierLocEPNS_9ValueDeclERKNS_19DeclarationNameInfoEPNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildDeclRefExprENS_22NestedNameSpecifierLocEPNS_9ValueDeclERKNS_19DeclarationNameInfoEPNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildDeclRefExpr(NestedNameSpecifierLoc QualifierLoc, 
                    ValueDecl /*P*/ VD, 
                    final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                    TemplateArgumentListInfo /*P*/ TemplateArgs) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      // FIXME: loses template args.
      return getSema().BuildDeclarationNameExpr(SS, NameInfo, VD);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new expression in parentheses.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 1999,
   FQN="clang::TreeTransform::RebuildParenExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildParenExprEPNS_4ExprENS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildParenExprEPNS_4ExprENS_14SourceLocationES6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildParenExpr(Expr /*P*/ SubExpr, SourceLocation LParen, 
                  SourceLocation RParen) {
    return getSema().ActOnParenExpr(new SourceLocation(LParen), new SourceLocation(RParen), SubExpr);
  }

  
  /// \brief Build a new pseudo-destructor expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11864,
   FQN="clang::TreeTransform::RebuildCXXPseudoDestructorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildCXXPseudoDestructorExprEPNS_4ExprENS_14SourceLocationEbRNS_12CXXScopeSpecEPNS_14TypeSourceInfoES6_S6_NS_27PseudoDestructorTypeStorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE30RebuildCXXPseudoDestructorExprEPNS_4ExprENS_14SourceLocationEbRNS_12CXXScopeSpecEPNS_14TypeSourceInfoES6_S6_NS_27PseudoDestructorTypeStorageE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXPseudoDestructorExpr(Expr /*P*/ Base, 
                                SourceLocation OperatorLoc, 
                                boolean isArrow, 
                                final CXXScopeSpec /*&*/ SS, 
                                TypeSourceInfo /*P*/ ScopeType, 
                                SourceLocation CCLoc, 
                                SourceLocation TildeLoc, 
                                PseudoDestructorTypeStorage Destroyed) {
    QualType BaseType = Base.getType();
    if (Base.isTypeDependent() || (Destroyed.getIdentifier() != null)
       || (!isArrow && !(BaseType.$arrow().<RecordType>getAs$RecordType() != null))
       || (isArrow && (BaseType.$arrow().getAs(PointerType.class) != null)
       && !(BaseType.$arrow().getAs(PointerType.class).getPointeeType().$arrow()./*template */
        <RecordType>getAs$RecordType() != null))) {
      // This pseudo-destructor expression is still a pseudo-destructor.
      return SemaRef.BuildPseudoDestructorExpr(Base, new SourceLocation(OperatorLoc), isArrow ? tok.TokenKind.arrow : tok.TokenKind.period, SS, ScopeType, 
          new SourceLocation(CCLoc), new SourceLocation(TildeLoc), new PseudoDestructorTypeStorage(Destroyed));
    }
    
    TypeSourceInfo /*P*/ DestroyedType = Destroyed.getTypeSourceInfo();
    DeclarationName Name/*J*/= /*ParenList*/new DeclarationName(SemaRef.Context.DeclarationNames.getCXXDestructorName(SemaRef.Context.getCanonicalType(DestroyedType.getType())));
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), Destroyed.getLocation());
    NameInfo.setNamedTypeInfo(DestroyedType);
    
    // The scope type is now known to be a valid nested name specifier
    // component. Tack it on to the end of the nested name specifier.
    if ((ScopeType != null)) {
      if (!(ScopeType.getType().$arrow().getAs(TagType.class) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(getSema().Diag(ScopeType.getTypeLoc().getBeginLoc(), 
                      diag.err_expected_class_or_namespace)), 
                  ScopeType.getType()), getSema().getLangOpts().CPlusPlus));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      SS.Extend(SemaRef.Context, new SourceLocation(), ScopeType.getTypeLoc(), 
          new SourceLocation(CCLoc));
    }
    
    SourceLocation TemplateKWLoc/*J*/= new SourceLocation(); // FIXME: retrieve it from caller.
    return getSema().BuildMemberReferenceExpr1(Base, new QualType(BaseType), 
        new SourceLocation(OperatorLoc), isArrow, 
        SS, new SourceLocation(TemplateKWLoc), 
        /*FIXME: FirstQualifier*/ (NamedDecl /*P*/ )null, 
        NameInfo, 
        /*TemplateArgs*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
        /*S*/ (/*const*/ Scope /*P*/ )null);
  }

  
  /// \brief Build a new unary operator expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2021,
   FQN="clang::TreeTransform::RebuildUnaryOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildUnaryOperatorENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildUnaryOperatorENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildUnaryOperator(SourceLocation OpLoc, 
                      UnaryOperatorKind Opc, 
                      Expr /*P*/ SubExpr) {
    return getSema().BuildUnaryOp(/*Scope=*/ (Scope /*P*/ )null, new SourceLocation(OpLoc), Opc, SubExpr);
  }

  
  /// \brief Build a new builtin offsetof expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2031,
   FQN="clang::TreeTransform::RebuildOffsetOfExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildOffsetOfExprENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_4Sema17OffsetOfComponentEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildOffsetOfExprENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_4Sema17OffsetOfComponentEEES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildOffsetOfExpr(SourceLocation OperatorLoc, 
                     TypeSourceInfo /*P*/ Type, 
                     ArrayRef<Sema.OffsetOfComponent> Components, 
                     SourceLocation RParenLoc) {
    return getSema().BuildBuiltinOffsetOf(new SourceLocation(OperatorLoc), Type, new ArrayRef<OffsetOfComponent>(Components), 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new sizeof, alignof or vec_step expression with a
  /// type argument.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnaryExprOrTypeTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2044,
   FQN="clang::TreeTransform::RebuildUnaryExprOrTypeTrait", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnaryExprOrTypeTraitEPNS_14TypeSourceInfoENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnaryExprOrTypeTraitEPNS_14TypeSourceInfoENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildUnaryExprOrTypeTrait(TypeSourceInfo /*P*/ TInfo, 
                             SourceLocation OpLoc, 
                             UnaryExprOrTypeTrait ExprKind, 
                             SourceRange R) {
    return getSema().CreateUnaryExprOrTypeTraitExpr(TInfo, new SourceLocation(OpLoc), ExprKind, new SourceRange(R));
  }

  
  /// \brief Build a new sizeof, alignof or vec step expression with an
  /// expression argument.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnaryExprOrTypeTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2056,
   FQN="clang::TreeTransform::RebuildUnaryExprOrTypeTrait", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnaryExprOrTypeTraitEPNS_4ExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnaryExprOrTypeTraitEPNS_4ExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildUnaryExprOrTypeTrait(Expr /*P*/ SubExpr, SourceLocation OpLoc, 
                             UnaryExprOrTypeTrait ExprKind, 
                             SourceRange R) {
    ActionResultTTrue<Expr /*P*/ > Result = getSema().CreateUnaryExprOrTypeTraitExpr(SubExpr, new SourceLocation(OpLoc), ExprKind);
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    return Result;
  }

  
  /// \brief Build a new array subscript expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2071,
   FQN="clang::TreeTransform::RebuildArraySubscriptExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildArraySubscriptExprEPNS_4ExprENS_14SourceLocationES5_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildArraySubscriptExprEPNS_4ExprENS_14SourceLocationES5_S6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildArraySubscriptExpr(Expr /*P*/ LHS, 
                           SourceLocation LBracketLoc, 
                           Expr /*P*/ RHS, 
                           SourceLocation RBracketLoc) {
    return getSema().ActOnArraySubscriptExpr(/*Scope=*/ (Scope /*P*/ )null, LHS, 
        new SourceLocation(LBracketLoc), RHS, 
        new SourceLocation(RBracketLoc));
  }

  
  /// \brief Build a new array section expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2084,
   FQN="clang::TreeTransform::RebuildOMPArraySectionExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildOMPArraySectionExprEPNS_4ExprENS_14SourceLocationES5_S6_S5_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildOMPArraySectionExprEPNS_4ExprENS_14SourceLocationES5_S6_S5_S6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildOMPArraySectionExpr(Expr /*P*/ Base, SourceLocation LBracketLoc, 
                            Expr /*P*/ LowerBound, 
                            SourceLocation ColonLoc, Expr /*P*/ Length, 
                            SourceLocation RBracketLoc) {
    return getSema().ActOnOMPArraySectionExpr(Base, new SourceLocation(LBracketLoc), LowerBound, 
        new SourceLocation(ColonLoc), Length, new SourceLocation(RBracketLoc));
  }

  
  /// \brief Build a new call expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2096,
   FQN="clang::TreeTransform::RebuildCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildCallExprEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES6_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildCallExprEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES6_S5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCallExpr(Expr /*P*/ Callee, SourceLocation LParenLoc, 
                 MutableArrayRef<Expr /*P*/ > Args, 
                 SourceLocation RParenLoc) {
    return RebuildCallExpr(Callee, LParenLoc, Args, RParenLoc, null);
  }
  public ActionResultTTrue<Expr /*P*/ > RebuildCallExpr(Expr /*P*/ Callee, SourceLocation LParenLoc, 
                 MutableArrayRef<Expr /*P*/ > Args, 
                 SourceLocation RParenLoc, 
                 Expr /*P*/ ExecConfig/*= null*/) {
    return getSema().ActOnCallExpr(/*Scope=*/ null, Callee, LParenLoc, 
        Args, RParenLoc, ExecConfig);
  }

  
  /// \brief Build a new member access expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2108,
   FQN="clang::TreeTransform::RebuildMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildMemberExprEPNS_4ExprENS_14SourceLocationEbNS_22NestedNameSpecifierLocES6_RKNS_19DeclarationNameInfoEPNS_9ValueDeclEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoESE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildMemberExprEPNS_4ExprENS_14SourceLocationEbNS_22NestedNameSpecifierLocES6_RKNS_19DeclarationNameInfoEPNS_9ValueDeclEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoESE_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildMemberExpr(Expr /*P*/ Base, SourceLocation OpLoc, 
                   boolean isArrow, 
                   NestedNameSpecifierLoc QualifierLoc, 
                   SourceLocation TemplateKWLoc, 
                   final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, 
                   ValueDecl /*P*/ Member, 
                   NamedDecl /*P*/ FoundDecl, 
                   /*const*/ TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                   NamedDecl /*P*/ FirstQualifierInScope) {
    CXXScopeSpec SS = null;
    LookupResult R = null;
    try {
      ActionResultTTrue<Expr /*P*/ > BaseResult = getSema().PerformMemberExprBaseConversion(Base, 
          isArrow);
      if (!Member.getDeclName().$bool()) {
        // We have a reference to an unnamed field.  This is always the
        // base of an anonymous struct/union member access, i.e. the
        // field is always of record type.
        assert (!QualifierLoc.$bool()) : "Can't have an unnamed field with a qualifier!";
        assert (Member.getType().$arrow().isRecordType()) : "unnamed member not of record type?";
        
        BaseResult.$assignMove(
            getSema().PerformObjectMemberConversion(BaseResult.get(), 
                QualifierLoc.getNestedNameSpecifier(), 
                FoundDecl, Member)
        );
        if (BaseResult.isInvalid()) {
          return ExprError();
        }
        Base = BaseResult.get();
        ExprValueKind VK = isArrow ? ExprValueKind.VK_LValue : Base.getValueKind();
        final Expr /*P*/ L$Base = Base;
        MemberExpr /*P*/ ME = /*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new MemberExpr(L$Base, isArrow, new SourceLocation(OpLoc), Member, MemberNameInfo, 
            cast_FieldDecl(Member).getType(), VK, ExprObjectKind.OK_Ordinary));
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ME);
      }
      
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      Base = BaseResult.get();
      QualType BaseType = Base.getType();
      
      // FIXME: this involves duplicating earlier analysis in a lot of
      // cases; we should avoid this when possible.
      R/*J*/= /*ParenList*/new LookupResult(getSema(), MemberNameInfo, Sema.LookupNameKind.LookupMemberName);
      R.addDecl(FoundDecl);
      R.resolveKind();
      
      return getSema().BuildMemberReferenceExpr2(Base, new QualType(BaseType), new SourceLocation(OpLoc), isArrow, 
          SS, new SourceLocation(TemplateKWLoc), 
          FirstQualifierInScope, 
          R, ExplicitTemplateArgs, 
          /*S*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (R != null) { R.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new binary operator expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2164,
   FQN="clang::TreeTransform::RebuildBinaryOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildBinaryOperatorENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildBinaryOperatorENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES7_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildBinaryOperator(SourceLocation OpLoc, 
                       BinaryOperatorKind Opc, 
                       Expr /*P*/ LHS, Expr /*P*/ RHS) {
    return getSema().BuildBinOp(/*Scope=*/ (Scope /*P*/ )null, new SourceLocation(OpLoc), Opc, LHS, RHS);
  }

  
  /// \brief Build a new conditional operator expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2174,
   FQN="clang::TreeTransform::RebuildConditionalOperator", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildConditionalOperatorEPNS_4ExprENS_14SourceLocationES5_S6_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildConditionalOperatorEPNS_4ExprENS_14SourceLocationES5_S6_S5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildConditionalOperator(Expr /*P*/ Cond, 
                            SourceLocation QuestionLoc, 
                            Expr /*P*/ LHS, 
                            SourceLocation ColonLoc, 
                            Expr /*P*/ RHS) {
    return getSema().ActOnConditionalOp(new SourceLocation(QuestionLoc), new SourceLocation(ColonLoc), Cond, 
        LHS, RHS);
  }

  
  /// \brief Build a new C-style cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2187,
   FQN="clang::TreeTransform::RebuildCStyleCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildCStyleCastExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildCStyleCastExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_PNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCStyleCastExpr(SourceLocation LParenLoc, 
                       TypeSourceInfo /*P*/ TInfo, 
                       SourceLocation RParenLoc, 
                       Expr /*P*/ SubExpr) {
    return getSema().BuildCStyleCastExpr(new SourceLocation(LParenLoc), TInfo, new SourceLocation(RParenLoc), 
        SubExpr);
  }

  
  /// \brief Build a new compound literal expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2199,
   FQN="clang::TreeTransform::RebuildCompoundLiteralExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildCompoundLiteralExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildCompoundLiteralExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_PNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCompoundLiteralExpr(SourceLocation LParenLoc, 
                            TypeSourceInfo /*P*/ TInfo, 
                            SourceLocation RParenLoc, 
                            Expr /*P*/ Init) {
    return getSema().BuildCompoundLiteralExpr(new SourceLocation(LParenLoc), TInfo, new SourceLocation(RParenLoc), 
        Init);
  }

  
  /// \brief Build a new extended vector element access expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2211,
   FQN="clang::TreeTransform::RebuildExtVectorElementExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildExtVectorElementExprEPNS_4ExprENS_14SourceLocationES6_RNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildExtVectorElementExprEPNS_4ExprENS_14SourceLocationES6_RNS_14IdentifierInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildExtVectorElementExpr(Expr /*P*/ Base, 
                             SourceLocation OpLoc, 
                             SourceLocation AccessorLoc, 
                             final IdentifierInfo /*&*/ Accessor) {
    CXXScopeSpec SS = null;
    try {
      
      SS/*J*/= new CXXScopeSpec();
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName($AddrOf(Accessor)), new SourceLocation(AccessorLoc));
      return getSema().BuildMemberReferenceExpr1(Base, Base.getType(), 
          new SourceLocation(OpLoc), /*IsArrow*/ false, 
          SS, new SourceLocation(), 
          /*FirstQualifierInScope*/ (NamedDecl /*P*/ )null, 
          NameInfo, 
          /* TemplateArgs */ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
          /*S*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new initializer list expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildInitList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2231,
   FQN="clang::TreeTransform::RebuildInitList", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildInitListENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildInitListENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_NS_8QualTypeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildInitList(SourceLocation LBraceLoc, 
                 MutableArrayRef<Expr /*P*/ > Inits, 
                 SourceLocation RBraceLoc, 
                 QualType ResultTy) {
    ActionResultTTrue<Expr /*P*/ > Result = SemaRef.ActOnInitList(new SourceLocation(LBraceLoc), new MutableArrayRef<Expr /*P*/ >(Inits), new SourceLocation(RBraceLoc));
    if (Result.isInvalid() || ResultTy.$arrow().isDependentType()) {
      return Result;
    }
    
    // Patch in the result type we were given, which may have been computed
    // when the initial InitListExpr was built.
    InitListExpr /*P*/ ILE = cast_InitListExpr((Expr /*P*/ )Result.get());
    ILE.setType(new QualType(ResultTy));
    return Result;
  }

  
  /// \brief Build a new designated initializer expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2251,
   FQN="clang::TreeTransform::RebuildDesignatedInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildDesignatedInitExprERNS_11DesignationEN4llvm15MutableArrayRefIPNS_4ExprEEENS_14SourceLocationEbS9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildDesignatedInitExprERNS_11DesignationEN4llvm15MutableArrayRefIPNS_4ExprEEENS_14SourceLocationEbS9_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildDesignatedInitExpr(final Designation /*&*/ Desig, 
                           MutableArrayRef<Expr /*P*/ > ArrayExprs, 
                           SourceLocation EqualOrColonLoc, 
                           boolean GNUSyntax, 
                           Expr /*P*/ Init) {
    ActionResultTTrue<Expr /*P*/ > Result = SemaRef.ActOnDesignatedInitializer(Desig, new SourceLocation(EqualOrColonLoc), GNUSyntax, 
        new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Init));
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    return Result;
  }

  
  /// \brief Build a new value-initialized expression.
  ///
  /// By default, builds the implicit value initialization without performing
  /// any semantic analysis. Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2270,
   FQN="clang::TreeTransform::RebuildImplicitValueInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildImplicitValueInitExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildImplicitValueInitExprENS_8QualTypeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildImplicitValueInitExpr(QualType T) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new ImplicitValueInitExpr(new QualType(T))));
  }

  
  /// \brief Build a new \c va_arg expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2278,
   FQN="clang::TreeTransform::RebuildVAArgExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildVAArgExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildVAArgExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildVAArgExpr(SourceLocation BuiltinLoc, 
                  Expr /*P*/ SubExpr, TypeSourceInfo /*P*/ TInfo, 
                  SourceLocation RParenLoc) {
    return getSema().BuildVAArgExpr(new SourceLocation(BuiltinLoc), 
        SubExpr, TInfo, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new expression list in parentheses.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2290,
   FQN="clang::TreeTransform::RebuildParenListExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildParenListExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildParenListExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildParenListExpr(SourceLocation LParenLoc, 
                      MutableArrayRef<Expr /*P*/ > SubExprs, 
                      SourceLocation RParenLoc) {
    return getSema().ActOnParenListExpr(new SourceLocation(LParenLoc), new SourceLocation(RParenLoc), new MutableArrayRef<Expr /*P*/ >(SubExprs));
  }

  
  /// \brief Build a new address-of-label expression.
  ///
  /// By default, performs semantic analysis, using the name of the label
  /// rather than attempting to map the label statement itself.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2301,
   FQN="clang::TreeTransform::RebuildAddrLabelExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildAddrLabelExprENS_14SourceLocationES4_PNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildAddrLabelExprENS_14SourceLocationES4_PNS_9LabelDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildAddrLabelExpr(SourceLocation AmpAmpLoc, 
                      SourceLocation LabelLoc, LabelDecl /*P*/ Label) {
    return getSema().ActOnAddrLabel(new SourceLocation(AmpAmpLoc), new SourceLocation(LabelLoc), Label);
  }

  
  /// \brief Build a new GNU statement expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2310,
   FQN="clang::TreeTransform::RebuildStmtExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildStmtExprENS_14SourceLocationEPNS_4StmtES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE15RebuildStmtExprENS_14SourceLocationEPNS_4StmtES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildStmtExpr(SourceLocation LParenLoc, 
                 Stmt /*P*/ SubStmt, 
                 SourceLocation RParenLoc) {
    return getSema().ActOnStmtExpr(new SourceLocation(LParenLoc), SubStmt, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new __builtin_choose_expr expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2320,
   FQN="clang::TreeTransform::RebuildChooseExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildChooseExprENS_14SourceLocationEPNS_4ExprES6_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildChooseExprENS_14SourceLocationEPNS_4ExprES6_S6_S4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildChooseExpr(SourceLocation BuiltinLoc, 
                   Expr /*P*/ Cond, Expr /*P*/ LHS, Expr /*P*/ RHS, 
                   SourceLocation RParenLoc) {
    return SemaRef.ActOnChooseExpr(new SourceLocation(BuiltinLoc), 
        Cond, LHS, RHS, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new generic selection expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2332,
   FQN="clang::TreeTransform::RebuildGenericSelectionExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildGenericSelectionExprENS_14SourceLocationES4_S4_PNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildGenericSelectionExprENS_14SourceLocationES4_S4_PNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildGenericSelectionExpr(SourceLocation KeyLoc, 
                             SourceLocation DefaultLoc, 
                             SourceLocation RParenLoc, 
                             Expr /*P*/ ControllingExpr, 
                             ArrayRef<TypeSourceInfo /*P*/ > Types, 
                             ArrayRef<Expr /*P*/ > Exprs) {
    return getSema().CreateGenericSelectionExpr(new SourceLocation(KeyLoc), new SourceLocation(DefaultLoc), new SourceLocation(RParenLoc), 
        ControllingExpr, new ArrayRef<TypeSourceInfo /*P*/ >(Types), new ArrayRef<Expr /*P*/ >(Exprs));
  }

  
  /// \brief Build a new overloaded operator call expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// The semantic analysis provides the behavior of template instantiation,
  /// copying with transformations that turn what looks like an overloaded
  /// operator call into a use of a builtin operator, performing
  /// argument-dependent lookup, etc. Subclasses may override this routine to
  /// provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 11746,
   FQN="clang::TreeTransform::RebuildCXXOperatorCallExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildCXXOperatorCallExprENS_22OverloadedOperatorKindENS_14SourceLocationEPNS_4ExprES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildCXXOperatorCallExprENS_22OverloadedOperatorKindENS_14SourceLocationEPNS_4ExprES7_S7_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXOperatorCallExpr(OverloadedOperatorKind Op, 
                            SourceLocation OpLoc, 
                            Expr /*P*/ OrigCallee, 
                            Expr /*P*/ First, 
                            Expr /*P*/ Second) {
    Expr /*P*/ Callee = OrigCallee.IgnoreParenCasts();
    boolean isPostIncDec = (Second != null) && (Op == OverloadedOperatorKind.OO_PlusPlus || Op == OverloadedOperatorKind.OO_MinusMinus);
    if (First.getObjectKind() == ExprObjectKind.OK_ObjCProperty) {
      BinaryOperatorKind Opc = BinaryOperator.getOverloadedOpcode(Op);
      if (BinaryOperator.isAssignmentOp(Opc)) {
        return SemaRef.checkPseudoObjectAssignment(/*Scope=*/ (Scope /*P*/ )null, new SourceLocation(OpLoc), Opc, 
            First, Second);
      }
      ActionResultTTrue<Expr /*P*/ > Result = SemaRef.CheckPlaceholderExpr(First);
      if (Result.isInvalid()) {
        return ExprError();
      }
      First = Result.get();
    }
    if ((Second != null) && Second.getObjectKind() == ExprObjectKind.OK_ObjCProperty) {
      ActionResultTTrue<Expr /*P*/ > Result = SemaRef.CheckPlaceholderExpr(Second);
      if (Result.isInvalid()) {
        return ExprError();
      }
      Second = Result.get();
    }
    
    // Determine whether this should be a builtin operation.
    if (Op == OverloadedOperatorKind.OO_Subscript) {
      if (!First.getType().$arrow().isOverloadableType()
         && !Second.getType().$arrow().isOverloadableType()) {
        return getSema().CreateBuiltinArraySubscriptExpr(First, 
            Callee.getLocStart(), 
            Second, new SourceLocation(OpLoc));
      }
    } else if (Op == OverloadedOperatorKind.OO_Arrow) {
      // -> is never a builtin operation.
      return SemaRef.BuildOverloadedArrowExpr((Scope /*P*/ )null, First, new SourceLocation(OpLoc));
    } else if (Second == null || isPostIncDec) {
      if (!First.getType().$arrow().isOverloadableType()) {
        // The argument is not of overloadable type, so try to create a
        // built-in unary operation.
        UnaryOperatorKind Opc = UnaryOperator.getOverloadedOpcode(Op, isPostIncDec);
        
        return getSema().CreateBuiltinUnaryOp(new SourceLocation(OpLoc), Opc, First);
      }
    } else {
      if (!First.getType().$arrow().isOverloadableType()
         && !Second.getType().$arrow().isOverloadableType()) {
        // Neither of the arguments is an overloadable type, so try to
        // create a built-in binary operation.
        BinaryOperatorKind Opc = BinaryOperator.getOverloadedOpcode(Op);
        ActionResultTTrue<Expr /*P*/ > Result = SemaRef.CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, First, Second);
        if (Result.isInvalid()) {
          return ExprError();
        }
        
        return Result;
      }
    }
    
    // Compute the transformed set of functions (and function templates) to be
    // used during overload resolution.
    UnresolvedSet Functions/*J*/= new UnresolvedSet(16);
    {
      
      UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(Callee);
      if ((ULE != null)) {
        assert (ULE.requiresADL());
        Functions.append(ULE.decls_begin(), ULE.decls_end());
      } else {
        // If we've resolved this to a particular non-member function, just call
        // that function. If we resolved it to a member function,
        // CreateOverloaded* will find that function for us.
        NamedDecl /*P*/ ND = cast_DeclRefExpr(Callee).getDecl();
        if (!isa_CXXMethodDecl(ND)) {
          Functions.addDecl(ND);
        }
      }
    }
    
    // Add any functions found via argument-dependent lookup.
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/ [/*2*/] {First, Second};
    /*uint*/int NumArgs = 1 + ((Second != null) ? 1 : 0);
    
    // Create the overloaded operator invocation for unary operators.
    if (NumArgs == 1 || isPostIncDec) {
      UnaryOperatorKind Opc = UnaryOperator.getOverloadedOpcode(Op, isPostIncDec);
      return SemaRef.CreateOverloadedUnaryOp(new SourceLocation(OpLoc), Opc, Functions, First);
    }
    if (Op == OverloadedOperatorKind.OO_Subscript) {
      SourceLocation LBrace/*J*/= new SourceLocation();
      SourceLocation RBrace/*J*/= new SourceLocation();
      {
        
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Callee);
        if ((DRE != null)) {
          DeclarationNameLoc NameLoc = new DeclarationNameLoc(DRE.getNameInfo().getInfo());
          LBrace.$assignMove(SourceLocation.getFromRawEncoding(NameLoc.Unnamed_field.CXXOperatorName.BeginOpNameLoc));
          RBrace.$assignMove(SourceLocation.getFromRawEncoding(NameLoc.Unnamed_field.CXXOperatorName.EndOpNameLoc));
        } else {
          LBrace.$assignMove(Callee.getLocStart());
          RBrace.$assign(OpLoc);
        }
      }
      
      return SemaRef.CreateOverloadedArraySubscriptExpr(new SourceLocation(LBrace), new SourceLocation(RBrace), 
          First, Second);
    }
    
    // Create the overloaded operator invocation for binary operators.
    BinaryOperatorKind Opc = BinaryOperator.getOverloadedOpcode(Op);
    ActionResultTTrue<Expr /*P*/ > Result = SemaRef.CreateOverloadedBinOp(new SourceLocation(OpLoc), Opc, Functions, Args[0], Args[1]);
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    return Result;
  }

  
  /// \brief Build a new C++ "named" cast expression, such as static_cast or
  /// reinterpret_cast.
  ///
  /// By default, this routine dispatches to one of the more-specific routines
  /// for a particular named case, e.g., RebuildCXXStaticCastExpr().
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2362,
   FQN="clang::TreeTransform::RebuildCXXNamedCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXNamedCastExprENS_14SourceLocationENS_4Stmt9StmtClassES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXNamedCastExprENS_14SourceLocationENS_4Stmt9StmtClassES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXNamedCastExpr(SourceLocation OpLoc, 
                         Stmt.StmtClass Class, 
                         SourceLocation LAngleLoc, 
                         TypeSourceInfo /*P*/ TInfo, 
                         SourceLocation RAngleLoc, 
                         SourceLocation LParenLoc, 
                         Expr /*P*/ SubExpr, 
                         SourceLocation RParenLoc) {
    switch (Class) {
     case CXXStaticCastExprClass:
      return getDerived().RebuildCXXStaticCastExpr(new SourceLocation(OpLoc), new SourceLocation(LAngleLoc), TInfo, 
          new SourceLocation(RAngleLoc), new SourceLocation(LParenLoc), 
          SubExpr, new SourceLocation(RParenLoc));
     case CXXDynamicCastExprClass:
      return getDerived().RebuildCXXDynamicCastExpr(new SourceLocation(OpLoc), new SourceLocation(LAngleLoc), TInfo, 
          new SourceLocation(RAngleLoc), new SourceLocation(LParenLoc), 
          SubExpr, new SourceLocation(RParenLoc));
     case CXXReinterpretCastExprClass:
      return getDerived().RebuildCXXReinterpretCastExpr(new SourceLocation(OpLoc), new SourceLocation(LAngleLoc), TInfo, 
          new SourceLocation(RAngleLoc), new SourceLocation(LParenLoc), 
          SubExpr, 
          new SourceLocation(RParenLoc));
     case CXXConstCastExprClass:
      return getDerived().RebuildCXXConstCastExpr(new SourceLocation(OpLoc), new SourceLocation(LAngleLoc), TInfo, 
          new SourceLocation(RAngleLoc), new SourceLocation(LParenLoc), 
          SubExpr, new SourceLocation(RParenLoc));
     default:
      throw new llvm_unreachable("Invalid C++ named cast");
    }
  }

  
  /// \brief Build a new C++ static_cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2401,
   FQN="clang::TreeTransform::RebuildCXXStaticCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildCXXStaticCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildCXXStaticCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXStaticCastExpr(SourceLocation OpLoc, 
                          SourceLocation LAngleLoc, 
                          TypeSourceInfo /*P*/ TInfo, 
                          SourceLocation RAngleLoc, 
                          SourceLocation LParenLoc, 
                          Expr /*P*/ SubExpr, 
                          SourceLocation RParenLoc) {
    return getSema().BuildCXXNamedCast(new SourceLocation(OpLoc), tok.TokenKind.kw_static_cast, 
        TInfo, SubExpr, 
        new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  }

  
  /// \brief Build a new C++ dynamic_cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2418,
   FQN="clang::TreeTransform::RebuildCXXDynamicCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildCXXDynamicCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildCXXDynamicCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXDynamicCastExpr(SourceLocation OpLoc, 
                           SourceLocation LAngleLoc, 
                           TypeSourceInfo /*P*/ TInfo, 
                           SourceLocation RAngleLoc, 
                           SourceLocation LParenLoc, 
                           Expr /*P*/ SubExpr, 
                           SourceLocation RParenLoc) {
    return getSema().BuildCXXNamedCast(new SourceLocation(OpLoc), tok.TokenKind.kw_dynamic_cast, 
        TInfo, SubExpr, 
        new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  }

  
  /// \brief Build a new C++ reinterpret_cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2435,
   FQN="clang::TreeTransform::RebuildCXXReinterpretCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXReinterpretCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXReinterpretCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXReinterpretCastExpr(SourceLocation OpLoc, 
                               SourceLocation LAngleLoc, 
                               TypeSourceInfo /*P*/ TInfo, 
                               SourceLocation RAngleLoc, 
                               SourceLocation LParenLoc, 
                               Expr /*P*/ SubExpr, 
                               SourceLocation RParenLoc) {
    return getSema().BuildCXXNamedCast(new SourceLocation(OpLoc), tok.TokenKind.kw_reinterpret_cast, 
        TInfo, SubExpr, 
        new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  }

  
  /// \brief Build a new C++ const_cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2452,
   FQN="clang::TreeTransform::RebuildCXXConstCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXConstCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXConstCastExprENS_14SourceLocationES4_PNS_14TypeSourceInfoES4_S4_PNS_4ExprES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXConstCastExpr(SourceLocation OpLoc, 
                         SourceLocation LAngleLoc, 
                         TypeSourceInfo /*P*/ TInfo, 
                         SourceLocation RAngleLoc, 
                         SourceLocation LParenLoc, 
                         Expr /*P*/ SubExpr, 
                         SourceLocation RParenLoc) {
    return getSema().BuildCXXNamedCast(new SourceLocation(OpLoc), tok.TokenKind.kw_const_cast, 
        TInfo, SubExpr, 
        new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  }

  
  /// \brief Build a new C++ functional-style cast expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2469,
   FQN="clang::TreeTransform::RebuildCXXFunctionalCastExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildCXXFunctionalCastExprEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildCXXFunctionalCastExprEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXFunctionalCastExpr(TypeSourceInfo /*P*/ TInfo, 
                              SourceLocation LParenLoc, 
                              Expr /*P*/ Sub, 
                              SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeConstructExpr(TInfo, new SourceLocation(LParenLoc), 
        new MutableArrayRef<Expr /*P*/ >($AddrOf(Sub), 1, true), 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ typeid(type) expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2482,
   FQN="clang::TreeTransform::RebuildCXXTypeidExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXTypeidExprENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXTypeidExprENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXTypeidExpr(QualType TypeInfoType, 
                      SourceLocation TypeidLoc, 
                      TypeSourceInfo /*P*/ Operand, 
                      SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeId(new QualType(TypeInfoType), new SourceLocation(TypeidLoc), Operand, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ typeid(expr) expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2495,
   FQN="clang::TreeTransform::RebuildCXXTypeidExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXTypeidExprENS_8QualTypeENS_14SourceLocationEPNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXTypeidExprENS_8QualTypeENS_14SourceLocationEPNS_4ExprES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXTypeidExpr(QualType TypeInfoType, 
                      SourceLocation TypeidLoc, 
                      Expr /*P*/ Operand, 
                      SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeId(new QualType(TypeInfoType), new SourceLocation(TypeidLoc), Operand, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ __uuidof(type) expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2507,
   FQN="clang::TreeTransform::RebuildCXXUuidofExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXUuidofExprENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXUuidofExprENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXUuidofExpr(QualType TypeInfoType, 
                      SourceLocation TypeidLoc, 
                      TypeSourceInfo /*P*/ Operand, 
                      SourceLocation RParenLoc) {
    return getSema().BuildCXXUuidof(new QualType(TypeInfoType), new SourceLocation(TypeidLoc), Operand, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ __uuidof(expr) expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2519,
   FQN="clang::TreeTransform::RebuildCXXUuidofExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXUuidofExprENS_8QualTypeENS_14SourceLocationEPNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXUuidofExprENS_8QualTypeENS_14SourceLocationEPNS_4ExprES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXUuidofExpr(QualType TypeInfoType, 
                      SourceLocation TypeidLoc, 
                      Expr /*P*/ Operand, 
                      SourceLocation RParenLoc) {
    return getSema().BuildCXXUuidof(new QualType(TypeInfoType), new SourceLocation(TypeidLoc), Operand, 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ "this" expression.
  ///
  /// By default, builds a new "this" expression without performing any
  /// semantic analysis. Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2532,
   FQN="clang::TreeTransform::RebuildCXXThisExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCXXThisExprENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCXXThisExprENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXThisExpr(SourceLocation ThisLoc, 
                    QualType ThisType, 
                    boolean isImplicit) {
    getSema().CheckCXXThisCapture(new SourceLocation(ThisLoc));
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(ThisLoc), new QualType(ThisType), isImplicit)));
  }

  
  /// \brief Build a new C++ throw expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2543,
   FQN="clang::TreeTransform::RebuildCXXThrowExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCXXThrowExprENS_14SourceLocationEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE19RebuildCXXThrowExprENS_14SourceLocationEPNS_4ExprEb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXThrowExpr(SourceLocation ThrowLoc, Expr /*P*/ Sub, 
                     boolean IsThrownVariableInScope) {
    return getSema().BuildCXXThrow(new SourceLocation(ThrowLoc), Sub, IsThrownVariableInScope);
  }

  
  /// \brief Build a new C++ default-argument expression.
  ///
  /// By default, builds a new default-argument expression, which does not
  /// require any semantic analysis. Subclasses may override this routine to
  /// provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2553,
   FQN="clang::TreeTransform::RebuildCXXDefaultArgExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildCXXDefaultArgExprENS_14SourceLocationEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildCXXDefaultArgExprENS_14SourceLocationEPNS_11ParmVarDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXDefaultArgExpr(SourceLocation Loc, 
                          ParmVarDecl /*P*/ Param) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// \brief Build a new C++11 default-initialization expression.
  ///
  /// By default, builds a new default field initialization expression, which
  /// does not require any semantic analysis. Subclasses may override this
  /// routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2563,
   FQN="clang::TreeTransform::RebuildCXXDefaultInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildCXXDefaultInitExprENS_14SourceLocationEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25RebuildCXXDefaultInitExprENS_14SourceLocationEPNS_9FieldDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXDefaultInitExpr(SourceLocation Loc, 
                           FieldDecl /*P*/ Field) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDefaultInitExpr.Create(getSema().Context, new SourceLocation(Loc), Field));
  }

  
  /// \brief Build a new C++ zero-initialization expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2572,
   FQN="clang::TreeTransform::RebuildCXXScalarValueInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXScalarValueInitExprEPNS_14TypeSourceInfoENS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXScalarValueInitExprEPNS_14TypeSourceInfoENS_14SourceLocationES6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXScalarValueInitExpr(TypeSourceInfo /*P*/ TSInfo, 
                               SourceLocation LParenLoc, 
                               SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeConstructExpr(TSInfo, new SourceLocation(LParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(None, true), new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new C++ "new" expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2583,
   FQN="clang::TreeTransform::RebuildCXXNewExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildCXXNewExprENS_14SourceLocationEbS4_N4llvm15MutableArrayRefIPNS_4ExprEEES4_NS_11SourceRangeENS_8QualTypeEPNS_14TypeSourceInfoES8_SA_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildCXXNewExprENS_14SourceLocationEbS4_N4llvm15MutableArrayRefIPNS_4ExprEEES4_NS_11SourceRangeENS_8QualTypeEPNS_14TypeSourceInfoES8_SA_S8_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXNewExpr(SourceLocation StartLoc, 
                   boolean UseGlobal, 
                   SourceLocation PlacementLParen, 
                   MutableArrayRef<Expr /*P*/ > PlacementArgs, 
                   SourceLocation PlacementRParen, 
                   SourceRange TypeIdParens, 
                   QualType AllocatedType, 
                   TypeSourceInfo /*P*/ AllocatedTypeInfo, 
                   Expr /*P*/ ArraySize, 
                   SourceRange DirectInitRange, 
                   Expr /*P*/ Initializer) {
    return getSema().BuildCXXNew(new SourceRange(/*NO_COPY*/StartLoc), UseGlobal, 
        new SourceLocation(PlacementLParen), 
        new MutableArrayRef<Expr /*P*/ >(PlacementArgs), 
        new SourceLocation(PlacementRParen), 
        new SourceRange(TypeIdParens), 
        new QualType(AllocatedType), 
        AllocatedTypeInfo, 
        ArraySize, 
        new SourceRange(DirectInitRange), 
        Initializer);
  }

  
  /// \brief Build a new C++ "delete" expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2610,
   FQN="clang::TreeTransform::RebuildCXXDeleteExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXDeleteExprENS_14SourceLocationEbbPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildCXXDeleteExprENS_14SourceLocationEbbPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXDeleteExpr(SourceLocation StartLoc, 
                      boolean IsGlobalDelete, 
                      boolean IsArrayForm, 
                      Expr /*P*/ Operand) {
    return getSema().ActOnCXXDelete(new SourceLocation(StartLoc), IsGlobalDelete, IsArrayForm, 
        Operand);
  }

  
  /// \brief Build a new type trait expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTypeTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2622,
   FQN="clang::TreeTransform::RebuildTypeTrait", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE16RebuildTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildTypeTrait(TypeTrait Trait, 
                  SourceLocation StartLoc, 
                  ArrayRef<TypeSourceInfo /*P*/ > Args, 
                  SourceLocation RParenLoc) {
    return getSema().BuildTypeTrait(Trait, new SourceLocation(StartLoc), new ArrayRef<TypeSourceInfo /*P*/ >(Args), new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new array type trait expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildArrayTypeTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2633,
   FQN="clang::TreeTransform::RebuildArrayTypeTrait", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationEPNS_14TypeSourceInfoEPNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationEPNS_14TypeSourceInfoEPNS_4ExprES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildArrayTypeTrait(ArrayTypeTrait Trait, 
                       SourceLocation StartLoc, 
                       TypeSourceInfo /*P*/ TSInfo, 
                       Expr /*P*/ DimExpr, 
                       SourceLocation RParenLoc) {
    return getSema().BuildArrayTypeTrait(Trait, new SourceLocation(StartLoc), TSInfo, DimExpr, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new expression trait expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildExpressionTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2645,
   FQN="clang::TreeTransform::RebuildExpressionTrait", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES5_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildExpressionTrait(ExpressionTrait Trait, 
                        SourceLocation StartLoc, 
                        Expr /*P*/ Queried, 
                        SourceLocation RParenLoc) {
    return getSema().BuildExpressionTrait(Trait, new SourceLocation(StartLoc), Queried, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new (previously unresolved) declaration reference
  /// expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2657,
   FQN="clang::TreeTransform::RebuildDependentScopeDeclRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32RebuildDependentScopeDeclRefExprENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoEbPPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE32RebuildDependentScopeDeclRefExprENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoEbPPNS_14TypeSourceInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildDependentScopeDeclRefExpr(NestedNameSpecifierLoc QualifierLoc, 
                                  SourceLocation TemplateKWLoc, 
                                  final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                                  /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                                  boolean IsAddressOfOperand, 
                                  type$ptr<TypeSourceInfo /*P*/ /*P*/> RecoveryTSI) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      if ((TemplateArgs != null) || TemplateKWLoc.isValid()) {
        return getSema().BuildQualifiedTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), NameInfo, 
            TemplateArgs);
      }
      
      return getSema().BuildQualifiedDeclarationNameExpr(SS, NameInfo, IsAddressOfOperand, /*S*/ (/*const*/ Scope /*P*/ )null, RecoveryTSI);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new template-id expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildTemplateIdExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2679,
   FQN="clang::TreeTransform::RebuildTemplateIdExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildTemplateIdExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEbPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildTemplateIdExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEbPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildTemplateIdExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                       SourceLocation TemplateKWLoc, 
                       final LookupResult /*&*/ R, 
                       boolean RequiresADL, 
                       /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
    return getSema().BuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, RequiresADL, 
        TemplateArgs);
  }

  
  /// \brief Build a new object-construction expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2692,
   FQN="clang::TreeTransform::RebuildCXXConstructExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXConstructExprENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbNS_16CXXConstructExpr16ConstructionKindENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildCXXConstructExprENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbNS_16CXXConstructExpr16ConstructionKindENS_11SourceRangeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXConstructExpr(QualType T, 
                         SourceLocation Loc, 
                         CXXConstructorDecl /*P*/ Constructor, 
                         boolean IsElidable, 
                         MutableArrayRef<Expr /*P*/ > Args, 
                         boolean HadMultipleCandidates, 
                         boolean ListInitialization, 
                         boolean StdInitListInitialization, 
                         boolean RequiresZeroInit, 
                         CXXConstructExpr.ConstructionKind ConstructKind, 
                         SourceRange ParenRange) {
    SmallVector<Expr /*P*/ > ConvertedArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    if (getSema().CompleteConstructorCall(Constructor, new MutableArrayRef<Expr /*P*/ >(Args), new SourceLocation(Loc), 
        ConvertedArgs)) {
      return ExprError();
    }
    
    return getSema().BuildCXXConstructExpr(new SourceLocation(Loc), new QualType(T), Constructor, 
        IsElidable, 
        new MutableArrayRef<Expr /*P*/ >(ConvertedArgs, true), 
        HadMultipleCandidates, 
        ListInitialization, 
        StdInitListInitialization, 
        RequiresZeroInit, ConstructKind.getValue(), 
        new SourceRange(ParenRange));
  }

  
  /// \brief Build a new implicit construction via inherited constructor
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2720,
   FQN="clang::TreeTransform::RebuildCXXInheritedCtorInitExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31RebuildCXXInheritedCtorInitExprENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE31RebuildCXXInheritedCtorInitExprENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXInheritedCtorInitExpr(QualType T, SourceLocation Loc, 
                                 CXXConstructorDecl /*P*/ Constructor, 
                                 boolean ConstructsVBase, 
                                 boolean InheritedFromVBase) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new CXXInheritedCtorInitExpr(new SourceLocation(Loc), new QualType(T), Constructor, ConstructsVBase, InheritedFromVBase)));
  }

  
  /// \brief Build a new object-construction expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2732,
   FQN="clang::TreeTransform::RebuildCXXTemporaryObjectExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXTemporaryObjectExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE29RebuildCXXTemporaryObjectExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXTemporaryObjectExpr(TypeSourceInfo /*P*/ TSInfo, 
                               SourceLocation LParenLoc, 
                               MutableArrayRef<Expr /*P*/ > Args, 
                               SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeConstructExpr(TSInfo, 
        new SourceLocation(LParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new object-construction expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2746,
   FQN="clang::TreeTransform::RebuildCXXUnresolvedConstructExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33RebuildCXXUnresolvedConstructExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE33RebuildCXXUnresolvedConstructExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES6_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXUnresolvedConstructExpr(TypeSourceInfo /*P*/ TSInfo, 
                                   SourceLocation LParenLoc, 
                                   MutableArrayRef<Expr /*P*/ > Args, 
                                   SourceLocation RParenLoc) {
    return getSema().BuildCXXTypeConstructExpr(TSInfo, 
        new SourceLocation(LParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new member reference expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2760,
   FQN="clang::TreeTransform::RebuildCXXDependentScopeMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34RebuildCXXDependentScopeMemberExprEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE34RebuildCXXDependentScopeMemberExprEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXDependentScopeMemberExpr(Expr /*P*/ BaseE, 
                                    QualType BaseType, 
                                    boolean IsArrow, 
                                    SourceLocation OperatorLoc, 
                                    NestedNameSpecifierLoc QualifierLoc, 
                                    SourceLocation TemplateKWLoc, 
                                    NamedDecl /*P*/ FirstQualifierInScope, 
                                    final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, 
                                    /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      return SemaRef.BuildMemberReferenceExpr1(BaseE, new QualType(BaseType), 
          new SourceLocation(OperatorLoc), IsArrow, 
          SS, new SourceLocation(TemplateKWLoc), 
          FirstQualifierInScope, 
          MemberNameInfo, 
          TemplateArgs, /*S*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new member reference expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2784,
   FQN="clang::TreeTransform::RebuildUnresolvedMemberExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnresolvedMemberExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbNS_22NestedNameSpecifierLocES7_PNS_9NamedDeclERNS_12LookupResultEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildUnresolvedMemberExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbNS_22NestedNameSpecifierLocES7_PNS_9NamedDeclERNS_12LookupResultEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildUnresolvedMemberExpr(Expr /*P*/ BaseE, QualType BaseType, 
                             SourceLocation OperatorLoc, 
                             boolean IsArrow, 
                             NestedNameSpecifierLoc QualifierLoc, 
                             SourceLocation TemplateKWLoc, 
                             NamedDecl /*P*/ FirstQualifierInScope, 
                             final LookupResult /*&*/ R, 
                             /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      return SemaRef.BuildMemberReferenceExpr2(BaseE, new QualType(BaseType), 
          new SourceLocation(OperatorLoc), IsArrow, 
          SS, new SourceLocation(TemplateKWLoc), 
          FirstQualifierInScope, 
          R, TemplateArgs, /*S*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new noexcept expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2806,
   FQN="clang::TreeTransform::RebuildCXXNoexceptExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildCXXNoexceptExprENS_11SourceRangeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildCXXNoexceptExprENS_11SourceRangeEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXNoexceptExpr(SourceRange Range, Expr /*P*/ Arg) {
    return SemaRef.BuildCXXNoexceptExpr(Range.getBegin(), Arg, Range.getEnd());
  }

  
  /// \brief Build a new expression to compute the length of a parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2811,
   FQN="clang::TreeTransform::RebuildSizeOfPackExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSizeOfPackExprENS_14SourceLocationEPNS_9NamedDeclES4_S4_N4llvm8OptionalIjEENS7_8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildSizeOfPackExprENS_14SourceLocationEPNS_9NamedDeclES4_S4_N4llvm8OptionalIjEENS7_8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildSizeOfPackExpr(SourceLocation OperatorLoc, 
                       NamedDecl /*P*/ Pack, 
                       SourceLocation PackLoc, 
                       SourceLocation RParenLoc, 
                       OptionalUInt Length, 
                       ArrayRef<TemplateArgument> PartialArgs) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, SizeOfPackExpr.Create(SemaRef.Context, new SourceLocation(OperatorLoc), Pack, new SourceLocation(PackLoc), 
            new SourceLocation(RParenLoc), new OptionalUInt(Length), new ArrayRef<TemplateArgument>(PartialArgs)));
  }

  
  /// \brief Build a new Objective-C boxed expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2825,
   FQN="clang::TreeTransform::RebuildObjCBoxedExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildObjCBoxedExprENS_11SourceRangeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildObjCBoxedExprENS_11SourceRangeEPNS_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCBoxedExpr(SourceRange SR, Expr /*P*/ ValueExpr) {
    return getSema().BuildObjCBoxedExpr(new SourceRange(SR), ValueExpr);
  }

  
  /// \brief Build a new Objective-C array literal.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2833,
   FQN="clang::TreeTransform::RebuildObjCArrayLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildObjCArrayLiteralENS_11SourceRangeEPPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildObjCArrayLiteralENS_11SourceRangeEPPNS_4ExprEj")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCArrayLiteral(SourceRange Range, 
                         type$ptr<Expr /*P*/ /*P*/> Elements, /*uint*/int NumElements) {
    return getSema().BuildObjCArrayLiteral(new SourceRange(Range), 
        new MutableArrayRef<Expr /*P*/ >(Elements, NumElements, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2839,
   FQN="clang::TreeTransform::RebuildObjCSubscriptRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildObjCSubscriptRefExprENS_14SourceLocationEPNS_4ExprES6_PNS_14ObjCMethodDeclES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE27RebuildObjCSubscriptRefExprENS_14SourceLocationEPNS_4ExprES6_PNS_14ObjCMethodDeclES8_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCSubscriptRefExpr(SourceLocation RB, 
                             Expr /*P*/ Base, Expr /*P*/ Key, 
                             ObjCMethodDecl /*P*/ getterMethod, 
                             ObjCMethodDecl /*P*/ setterMethod) {
    return getSema().BuildObjCSubscriptExpression(new SourceLocation(RB), Base, Key, 
        getterMethod, setterMethod);
  }

  
  /// \brief Build a new Objective-C dictionary literal.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2851,
   FQN="clang::TreeTransform::RebuildObjCDictionaryLiteral", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCDictionaryLiteralENS_11SourceRangeEN4llvm15MutableArrayRefINS_21ObjCDictionaryElementEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE28RebuildObjCDictionaryLiteralENS_11SourceRangeEN4llvm15MutableArrayRefINS_21ObjCDictionaryElementEEE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCDictionaryLiteral(SourceRange Range, 
                              MutableArrayRef<ObjCDictionaryElement> Elements) {
    return getSema().BuildObjCDictionaryLiteral(new SourceRange(Range), new MutableArrayRef<ObjCDictionaryElement>(Elements));
  }

  
  /// \brief Build a new Objective-C \@encode expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2860,
   FQN="clang::TreeTransform::RebuildObjCEncodeExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildObjCEncodeExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE21RebuildObjCEncodeExprENS_14SourceLocationEPNS_14TypeSourceInfoES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCEncodeExpr(SourceLocation AtLoc, 
                       TypeSourceInfo /*P*/ EncodeTypeInfo, 
                       SourceLocation RParenLoc) {
    return SemaRef.BuildObjCEncodeExpression(new SourceLocation(AtLoc), EncodeTypeInfo, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new Objective-C class message.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2867,
   FQN="clang::TreeTransform::RebuildObjCMessageExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclES9_NS7_15MutableArrayRefIPNS_4ExprEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprEPNS_14TypeSourceInfoENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclES9_NS7_15MutableArrayRefIPNS_4ExprEEES9_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCMessageExpr_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_ObjCMethodDecl$P_SourceLocation_MutableArrayRef$Expr$P_SourceLocation(TypeSourceInfo /*P*/ ReceiverTypeInfo, 
                                                                                                                                                Selector Sel, 
                                                                                                                                                ArrayRef<SourceLocation> SelectorLocs, 
                                                                                                                                                ObjCMethodDecl /*P*/ Method, 
                                                                                                                                                SourceLocation LBracLoc, 
                                                                                                                                                MutableArrayRef<Expr /*P*/ > Args, 
                                                                                                                                                SourceLocation RBracLoc) {
    return SemaRef.BuildClassMessage(ReceiverTypeInfo, 
        ReceiverTypeInfo.getType(), 
        /*SuperLoc=*/ new SourceLocation(), 
        new Selector(Sel), Method, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), 
        new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
  }

  
  /// \brief Build a new Objective-C instance message.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2882,
   FQN="clang::TreeTransform::RebuildObjCMessageExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclES9_NS7_15MutableArrayRefIS5_EES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprEPNS_4ExprENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclES9_NS7_15MutableArrayRefIS5_EES9_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCMessageExpr_Expr$P_Selector_ArrayRef$SourceLocation_ObjCMethodDecl$P_SourceLocation_MutableArrayRef$Expr$P_SourceLocation(Expr /*P*/ Receiver, 
                                                                                                                                      Selector Sel, 
                                                                                                                                      ArrayRef<SourceLocation> SelectorLocs, 
                                                                                                                                      ObjCMethodDecl /*P*/ Method, 
                                                                                                                                      SourceLocation LBracLoc, 
                                                                                                                                      MutableArrayRef<Expr /*P*/ > Args, 
                                                                                                                                      SourceLocation RBracLoc) {
    return SemaRef.BuildInstanceMessage(Receiver, 
        Receiver.getType(), 
        /*SuperLoc=*/ new SourceLocation(), 
        new Selector(Sel), Method, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), 
        new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
  }

  
  /// \brief Build a new Objective-C instance/class message to 'super'.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2897,
   FQN="clang::TreeTransform::RebuildObjCMessageExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprENS_14SourceLocationENS_8SelectorEN4llvm8ArrayRefIS4_EENS_8QualTypeEPNS_14ObjCMethodDeclES4_NS6_15MutableArrayRefIPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCMessageExprENS_14SourceLocationENS_8SelectorEN4llvm8ArrayRefIS4_EENS_8QualTypeEPNS_14ObjCMethodDeclES4_NS6_15MutableArrayRefIPNS_4ExprEEES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCMessageExpr(SourceLocation SuperLoc, 
                        Selector Sel, 
                        ArrayRef<SourceLocation> SelectorLocs, 
                        QualType SuperType, 
                        ObjCMethodDecl /*P*/ Method, 
                        SourceLocation LBracLoc, 
                        MutableArrayRef<Expr /*P*/ > Args, 
                        SourceLocation RBracLoc) {
    return Method.isInstanceMethod() ? SemaRef.BuildInstanceMessage((Expr /*P*/ )null, 
        new QualType(SuperType), 
        new SourceLocation(SuperLoc), 
        new Selector(Sel), Method, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), 
        new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args)) : SemaRef.BuildClassMessage((TypeSourceInfo /*P*/ )null, 
        new QualType(SuperType), 
        new SourceLocation(SuperLoc), 
        new Selector(Sel), Method, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), 
        new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
  }

  
  /// \brief Build a new Objective-C ivar reference expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2923,
   FQN="clang::TreeTransform::RebuildObjCIvarRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCIvarRefExprEPNS_4ExprEPNS_12ObjCIvarDeclENS_14SourceLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE22RebuildObjCIvarRefExprEPNS_4ExprEPNS_12ObjCIvarDeclENS_14SourceLocationEbb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCIvarRefExpr(Expr /*P*/ BaseArg, ObjCIvarDecl /*P*/ Ivar, 
                        SourceLocation IvarLoc, 
                        boolean IsArrow, boolean IsFreeIvar) {
    CXXScopeSpec SS = null;
    try {
      // FIXME: We lose track of the IsFreeIvar bit.
      SS/*J*/= new CXXScopeSpec();
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(Ivar.getDeclName(), new SourceLocation(IvarLoc));
      return getSema().BuildMemberReferenceExpr1(BaseArg, BaseArg.getType(), 
          /*FIXME:*/ new SourceLocation(IvarLoc), IsArrow, 
          SS, new SourceLocation(), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
          NameInfo, 
          /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
          /*S=*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new Objective-C property reference expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2942,
   FQN="clang::TreeTransform::RebuildObjCPropertyRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildObjCPropertyRefExprEPNS_4ExprEPNS_16ObjCPropertyDeclENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildObjCPropertyRefExprEPNS_4ExprEPNS_16ObjCPropertyDeclENS_14SourceLocationE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCPropertyRefExpr(Expr /*P*/ BaseArg, 
                            ObjCPropertyDecl /*P*/ Property, 
                            SourceLocation PropertyLoc) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(Property.getDeclName(), new SourceLocation(PropertyLoc));
      return getSema().BuildMemberReferenceExpr1(BaseArg, BaseArg.getType(), 
          /*FIXME:*/ new SourceLocation(PropertyLoc), 
          /*IsArrow=*/ false, 
          SS, new SourceLocation(), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
          NameInfo, 
          /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
          /*S=*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new Objective-C property reference expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2961,
   FQN="clang::TreeTransform::RebuildObjCPropertyRefExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildObjCPropertyRefExprEPNS_4ExprENS_8QualTypeEPNS_14ObjCMethodDeclES8_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26RebuildObjCPropertyRefExprEPNS_4ExprENS_8QualTypeEPNS_14ObjCMethodDeclES8_NS_14SourceLocationE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCPropertyRefExpr(Expr /*P*/ Base, QualType T, 
                            ObjCMethodDecl /*P*/ Getter, 
                            ObjCMethodDecl /*P*/ Setter, 
                            SourceLocation PropertyLoc) {
    // Since these expressions can only be value-dependent, we do not
    // need to perform semantic analysis again.
    return Owned(/*NEW_EXPR [Stmt::new]*//*new (getSema().Context)*/ Stmt.$new_uint_ASTContext$C_uint(getSema().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(Getter, Setter, new QualType(T), 
            ExprValueKind.VK_LValue, ExprObjectKind.OK_ObjCProperty, 
            new SourceLocation(PropertyLoc), Base)));
  }

  
  /// \brief Build a new Objective-C "isa" expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform<(anonymous)::TemplateInstantiator>::RebuildObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2977,
   FQN="clang::TreeTransform<(anonymous)::TemplateInstantiator>::RebuildObjCIsaExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildObjCIsaExprEPNS_4ExprENS_14SourceLocationES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildObjCIsaExprEPNS_4ExprENS_14SourceLocationES6_b")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildObjCIsaExpr(Expr /*P*/ BaseArg, SourceLocation IsaLoc, 
                    SourceLocation OpLoc, boolean IsArrow) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName($AddrOf(getSema().Context.Idents.get(new StringRef(/*KEEP_STR*/"isa")))), new SourceLocation(IsaLoc));
      return getSema().BuildMemberReferenceExpr1(BaseArg, BaseArg.getType(), 
          new SourceLocation(OpLoc), IsArrow, 
          SS, new SourceLocation(), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
          NameInfo, 
          /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
          /*S=*/ (/*const*/ Scope /*P*/ )null);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  
  /// \brief Build a new shuffle vector expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 2994,
   FQN="clang::TreeTransform::RebuildShuffleVectorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildShuffleVectorExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildShuffleVectorExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildShuffleVectorExpr(SourceLocation BuiltinLoc, 
                          MutableArrayRef<Expr /*P*/ > SubExprs, 
                          SourceLocation RParenLoc) {
    // Find the declaration for __builtin_shufflevector
    final /*const*/ IdentifierInfo /*&*/ Name = SemaRef.Context.Idents.get(new StringRef(/*KEEP_STR*/"__builtin_shufflevector"));
    TranslationUnitDecl /*P*/ TUDecl = SemaRef.Context.getTranslationUnitDecl();
    DeclContextLookupResult Lookup = TUDecl.lookup(new DeclarationName($AddrOf(Name)));
    assert (!Lookup.empty()) : "No __builtin_shufflevector?";
    
    // Build a reference to the __builtin_shufflevector builtin
    FunctionDecl /*P*/ Builtin = cast_FunctionDecl(Lookup.front());
    Expr /*P*/ Callee = /*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C$P_uint(SemaRef.Context, (type$ptr<?> Mem)->
            new DeclRefExpr(Builtin, false, 
        SemaRef.Context.BuiltinFnTy.$QualType(), 
        ExprValueKind.VK_RValue, new SourceLocation(BuiltinLoc))
    );
    QualType CalleePtrTy = SemaRef.Context.getPointerType(Builtin.getType());
    Callee = SemaRef.ImpCastExprToType(Callee, new QualType(CalleePtrTy), 
        CastKind.CK_BuiltinFnToFnPtr).get();
    
    // Build the CallExpr
    final Expr /*P*/ L$Callee = Callee;
    ActionResultTTrue<Expr /*P*/ > TheCall = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new CallExpr(SemaRef.Context, L$Callee, new ArrayRef<Expr /*P*/ >(SubExprs), Builtin.getCallResultType(), 
            Expr.getValueKindForType(Builtin.getReturnType()), new SourceLocation(RParenLoc))));
    
    // Type-check the __builtin_shufflevector expression.
    return SemaRef.SemaBuiltinShuffleVector(cast_CallExpr(TheCall.get()));
  }

  
  /// \brief Build a new convert vector expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3023,
   FQN="clang::TreeTransform::RebuildConvertVectorExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildConvertVectorExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE24RebuildConvertVectorExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildConvertVectorExpr(SourceLocation BuiltinLoc, 
                          Expr /*P*/ SrcExpr, TypeSourceInfo /*P*/ DstTInfo, 
                          SourceLocation RParenLoc) {
    return SemaRef.SemaConvertVectorExpr(SrcExpr, DstTInfo, 
        new SourceLocation(BuiltinLoc), new SourceLocation(RParenLoc));
  }

  
  /// \brief Build a new template argument pack expansion.
  ///
  /// By default, performs semantic analysis to build a new pack expansion
  /// for a template argument. Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3035,
   FQN="clang::TreeTransform::RebuildPackExpansion", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildPackExpansionENS_19TemplateArgumentLocENS_14SourceLocationEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildPackExpansionENS_19TemplateArgumentLocENS_14SourceLocationEN4llvm8OptionalIjEE")
  //</editor-fold>
  public TemplateArgumentLoc RebuildPackExpansion(TemplateArgumentLoc Pattern, 
                      SourceLocation EllipsisLoc, 
                      OptionalUInt NumExpansions) {
    switch (Pattern.getArgument().getKind()) {
     case Expression:
      {
        ActionResultTTrue<Expr /*P*/ > Result = getSema().CheckPackExpansion_Expr$P_SourceLocation_OptionalUInt(Pattern.getSourceExpression(), 
            new SourceLocation(EllipsisLoc), new OptionalUInt(NumExpansions));
        if (Result.isInvalid()) {
          return new TemplateArgumentLoc();
        }
        
        return new TemplateArgumentLoc(new TemplateArgument(Result.get()), Result.get());
      }
     case Template:
      return new TemplateArgumentLoc(new TemplateArgument(Pattern.getArgument().getAsTemplate(), 
              new OptionalUInt(NumExpansions)), 
          Pattern.getTemplateQualifierLoc(), 
          Pattern.getTemplateNameLoc(), 
          new SourceLocation(EllipsisLoc));
     case Null:
     case Integral:
     case Declaration:
     case Pack:
     case TemplateExpansion:
     case NullPtr:
      throw new llvm_unreachable("Pack expansion pattern has no parameter packs");
     case Type:
      {
        TypeSourceInfo /*P*/ Expansion = getSema().CheckPackExpansion_TypeSourceInfo$P_SourceLocation_OptionalUInt(Pattern.getTypeSourceInfo(), 
            new SourceLocation(EllipsisLoc), 
            new OptionalUInt(NumExpansions));
        if ((Expansion != null)) {
          return new TemplateArgumentLoc(new TemplateArgument(Expansion.getType()), 
              Expansion);
        }
      }
      break;
    }
    
    return new TemplateArgumentLoc();
  }

  
  /// \brief Build a new expression pack expansion.
  ///
  /// By default, performs semantic analysis to build a new pack expansion
  /// for an expression. Subclasses may override this routine to provide
  /// different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3083,
   FQN="clang::TreeTransform::RebuildPackExpansion", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildPackExpansionEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE20RebuildPackExpansionEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildPackExpansion(Expr /*P*/ Pattern, SourceLocation EllipsisLoc, 
                      OptionalUInt NumExpansions) {
    return getSema().CheckPackExpansion_Expr$P_SourceLocation_OptionalUInt(Pattern, new SourceLocation(EllipsisLoc), new OptionalUInt(NumExpansions));
  }

  
  /// \brief Build a new C++1z fold-expression.
  ///
  /// By default, performs semantic analysis in order to build a new fold
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3092,
   FQN="clang::TreeTransform::RebuildCXXFoldExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES4_S6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE18RebuildCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES4_S6_S4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCXXFoldExpr(SourceLocation LParenLoc, Expr /*P*/ LHS, 
                    BinaryOperatorKind Operator, 
                    SourceLocation EllipsisLoc, Expr /*P*/ RHS, 
                    SourceLocation RParenLoc) {
    return getSema().BuildCXXFoldExpr(new SourceLocation(LParenLoc), LHS, Operator, new SourceLocation(EllipsisLoc), 
        RHS, new SourceLocation(RParenLoc));
  }

  
  /// \brief Build an empty C++1z fold-expression with the given operator.
  ///
  /// By default, produces the fallback value for the fold-expression, or
  /// produce an error if there is no fallback value.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildEmptyCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3104,
   FQN="clang::TreeTransform::RebuildEmptyCXXFoldExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildEmptyCXXFoldExprENS_14SourceLocationENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE23RebuildEmptyCXXFoldExprENS_14SourceLocationENS_18BinaryOperatorKindE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildEmptyCXXFoldExpr(SourceLocation EllipsisLoc, 
                         BinaryOperatorKind Operator) {
    return getSema().BuildEmptyCXXFoldExpr(new SourceLocation(EllipsisLoc), Operator);
  }

  
  /// \brief Build a new atomic operation expression.
  ///
  /// By default, performs semantic analysis to build the new expression.
  /// Subclasses may override this routine to provide different behavior.
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::RebuildAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3113,
   FQN="clang::TreeTransform::RebuildAtomicExpr", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildAtomicExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8QualTypeENS_10AtomicExpr8AtomicOpES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE17RebuildAtomicExprENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8QualTypeENS_10AtomicExpr8AtomicOpES4_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildAtomicExpr(SourceLocation BuiltinLoc, 
                   MutableArrayRef<Expr /*P*/ > SubExprs, 
                   QualType RetTy, 
                   AtomicExpr.AtomicOp Op, 
                   SourceLocation RParenLoc) {
    // Just create the expression; there is not any interesting semantic
    // analysis here because we can't actually build an AtomicExpr until
    // we are sure it is semantically sound.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new AtomicExpr(new SourceLocation(BuiltinLoc), new ArrayRef<Expr /*P*/ >(SubExprs), new QualType(RetTy), Op, 
            new SourceLocation(RParenLoc))));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypeInObjectScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4103,
   FQN="clang::TreeTransform::TransformTypeInObjectScope", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTypeInObjectScopeENS_7TypeLocENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTypeInObjectScopeENS_7TypeLocENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE")
  //</editor-fold>
  private TypeLoc TransformTypeInObjectScope(TypeLoc TL, 
                            QualType ObjectType, 
                            NamedDecl /*P*/ UnqualLookup, 
                            final CXXScopeSpec /*&*/ SS) {
    if (getDerived().AlreadyTransformed(TL.getType())) {
      return new TypeLoc(JD$Move.INSTANCE, TL);
    }
    
    TypeSourceInfo /*P*/ TSI = TransformTSIInObjectScope(new TypeLoc(TL), new QualType(ObjectType), UnqualLookup, SS);
    if ((TSI != null)) {
      return TSI.getTypeLoc();
    }
    return new TypeLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTypeInObjectScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4119,
   FQN="clang::TreeTransform::TransformTypeInObjectScope", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTypeInObjectScopeEPNS_14TypeSourceInfoENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE26TransformTypeInObjectScopeEPNS_14TypeSourceInfoENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE")
  //</editor-fold>
  protected TypeSourceInfo /*P*/ TransformTypeInObjectScope(TypeSourceInfo /*P*/ TSInfo, 
                            QualType ObjectType, 
                            NamedDecl /*P*/ UnqualLookup, 
                            final CXXScopeSpec /*&*/ SS) {
    if (getDerived().AlreadyTransformed(TSInfo.getType())) {
      return TSInfo;
    }
    
    return TransformTSIInObjectScope(TSInfo.getTypeLoc(), new QualType(ObjectType), 
        UnqualLookup, SS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::TransformTSIInObjectScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4132,
   FQN="clang::TreeTransform::TransformTSIInObjectScope", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformTSIInObjectScopeENS_7TypeLocENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEE25TransformTSIInObjectScopeENS_7TypeLocENS_8QualTypeEPNS_9NamedDeclERNS_12CXXScopeSpecE")
  //</editor-fold>
  private TypeSourceInfo /*P*/ TransformTSIInObjectScope(TypeLoc TL, QualType ObjectType, 
                           NamedDecl /*P*/ UnqualLookup, 
                           final CXXScopeSpec /*&*/ SS) {
    TypeLocBuilder TLB = null;
    try {
      QualType T = TL.getType();
      assert (!getDerived().AlreadyTransformed(new QualType(T)));
      
      TLB/*J*/= new TypeLocBuilder();
      QualType Result/*J*/= new QualType();
      if (isa_TemplateSpecializationType(T)) {
        TemplateSpecializationTypeLoc SpecTL = TL.castAs(TemplateSpecializationTypeLoc.class);
        
        TemplateName Template = getDerived().TransformTemplateName(SS, 
            SpecTL.getTypePtr().getTemplateName(), 
            SpecTL.getTemplateNameLoc(),
            new QualType(ObjectType), UnqualLookup);
        if (Template.isNull()) {
          return null;
        }
        
        Result.$assignMove(getDerived().TransformTemplateSpecializationType(TLB, new TemplateSpecializationTypeLoc(SpecTL), 
                new TemplateName(Template)));
      } else if (isa_DependentTemplateSpecializationType(T)) {
        DependentTemplateSpecializationTypeLoc SpecTL = TL.castAs(DependentTemplateSpecializationTypeLoc.class);
        
        TemplateName Template = getDerived().RebuildTemplateName(SS, 
            $Deref(SpecTL.getTypePtr().getIdentifier()), 
            SpecTL.getTemplateNameLoc(), 
            new QualType(ObjectType), UnqualLookup);
        if (Template.isNull()) {
          return null;
        }
        
        Result.$assignMove(getDerived().TransformDependentTemplateSpecializationType(TLB, 
                new DependentTemplateSpecializationTypeLoc(SpecTL), 
                new TemplateName(Template), 
                SS));
      } else {
        // Nothing special needs to be done for these.
        Result.$assignMove(getDerived().TransformType(TLB, new TypeLoc(TL)));
      }
      if (Result.isNull()) {
        return null;
      }
      
      return TLB.getTypeSourceInfo(SemaRef.Context, new QualType(Result));
    } finally {
      if (TLB != null) { TLB.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TreeTransform::~TreeTransform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 95,
   FQN="clang::TreeTransform::~TreeTransform", NM="_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang13TreeTransformIN12_GLOBAL__N_120TemplateInstantiatorEED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TransformedLocalDecls.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public QualType TransformFunctionProtoType(final TypeLocBuilder /*&*/ TLB, 
                              FunctionProtoTypeLoc TL, 
                              CXXRecordDecl /*P*/ ThisContext, 
                              /*uint*/int ThisTypeQuals, 
                              TwoTypes2Bool<ExceptionSpecInfo, bool$ref> TransformExceptionSpec) {
    return TransformFunctionProtoType$TreeTransform(
      TLB, TL, ThisContext, ThisTypeQuals, TransformExceptionSpec
    );
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", TransformedLocalDecls=" + TransformedLocalDecls; // NOI18N
  }  
}
