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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaTemplateInstantiateStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 622,
 FQN="(anonymous namespace)::TemplateInstantiator", NM="_ZN12_GLOBAL__N_120TemplateInstantiatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiatorE")
//</editor-fold>
public class TemplateInstantiator extends /*public*/ TreeTransform<TemplateInstantiator> implements Destructors.ClassWithDestructor {
  private final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs;
  private SourceLocation Loc;
  private DeclarationName Entity;
/*public:*/
  /*typedef TreeTransform<TemplateInstantiator> inherited*/
//  public final class inherited extends TreeTransform<TemplateInstantiator>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TemplateInstantiator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 630,
   FQN="(anonymous namespace)::TemplateInstantiator::TemplateInstantiator", NM="_ZN12_GLOBAL__N_120TemplateInstantiatorC1ERN5clang4SemaERKNS1_30MultiLevelTemplateArgumentListENS1_14SourceLocationENS1_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiatorC1ERN5clang4SemaERKNS1_30MultiLevelTemplateArgumentListENS1_14SourceLocationENS1_15DeclarationNameE")
  //</editor-fold>
  public TemplateInstantiator(final Sema /*&*/ SemaRef, 
      final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
      SourceLocation Loc, 
      DeclarationName Entity) {
    // : inherited(SemaRef), TemplateArgs(TemplateArgs), Loc(Loc), Entity(Entity) 
    //START JInit
    super(SemaRef);
    this./*&*/TemplateArgs=/*&*/TemplateArgs;
    this.Loc = new SourceLocation(Loc);
    this.Entity = new DeclarationName(Entity);
    //END JInit
  }

  
  /// \brief Determine whether the given type \p T has already been
  /// transformed.
  ///
  /// For the purposes of template instantiation, a type has already been
  /// transformed if it is NULL or if it is not dependent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::AlreadyTransformed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 843,
   FQN="(anonymous namespace)::TemplateInstantiator::AlreadyTransformed", NM="_ZN12_GLOBAL__N_120TemplateInstantiator18AlreadyTransformedEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator18AlreadyTransformedEN5clang8QualTypeE")
  //</editor-fold>
  public boolean AlreadyTransformed(QualType T) {
    if (T.isNull()) {
      return true;
    }
    if (T.$arrow().isInstantiationDependentType() || T.$arrow().isVariablyModifiedType()) {
      return false;
    }
    
    getSema().MarkDeclarationsReferencedInType(new SourceLocation(Loc), new QualType(T));
    return true;
  }

  
  /// \brief Returns the location of the entity being instantiated, if known.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::getBaseLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 645,
   FQN="(anonymous namespace)::TemplateInstantiator::getBaseLocation", NM="_ZN12_GLOBAL__N_120TemplateInstantiator15getBaseLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator15getBaseLocationEv")
  //</editor-fold>
  public SourceLocation getBaseLocation() {
    return new SourceLocation(Loc);
  }

  
  /// \brief Returns the name of the entity being instantiated, if any.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::getBaseEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 648,
   FQN="(anonymous namespace)::TemplateInstantiator::getBaseEntity", NM="_ZN12_GLOBAL__N_120TemplateInstantiator13getBaseEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator13getBaseEntityEv")
  //</editor-fold>
  public DeclarationName getBaseEntity() {
    return new DeclarationName(Entity);
  }

  
  /// \brief Sets the "base" location and entity when that
  /// information is known based on another transformation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 652,
   FQN="(anonymous namespace)::TemplateInstantiator::setBase", NM="_ZN12_GLOBAL__N_120TemplateInstantiator7setBaseEN5clang14SourceLocationENS1_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator7setBaseEN5clang14SourceLocationENS1_15DeclarationNameE")
  //</editor-fold>
  public void setBase(SourceLocation Loc, DeclarationName Entity) {
    this.Loc.$assign(Loc);
    this.Entity.$assign(Entity);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TryExpandParameterPacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 657,
   FQN="(anonymous namespace)::TemplateInstantiator::TryExpandParameterPacks", NM="_ZN12_GLOBAL__N_120TemplateInstantiator23TryExpandParameterPacksEN5clang14SourceLocationENS1_11SourceRangeEN4llvm8ArrayRefISt4pairINS4_12PointerUnionIPKNS1_20TemplateTypeParmTypeEPNS1_9NamedDeclEEES2_EEERbSG_RNS4_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator23TryExpandParameterPacksEN5clang14SourceLocationENS1_11SourceRangeEN4llvm8ArrayRefISt4pairINS4_12PointerUnionIPKNS1_20TemplateTypeParmTypeEPNS1_9NamedDeclEEES2_EEERbSG_RNS4_8OptionalIjEE")
  //</editor-fold>
  public boolean TryExpandParameterPacks(SourceLocation EllipsisLoc, 
                         SourceRange PatternRange, 
                         ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded, 
                         final bool$ref/*bool &*/ ShouldExpand, final bool$ref/*bool &*/ RetainExpansion, 
                         final OptionalUInt /*&*/ NumExpansions) {
    return getSema().CheckParameterPacksForExpansion(new SourceLocation(EllipsisLoc), 
        new SourceRange(PatternRange), new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded), 
        TemplateArgs, 
        ShouldExpand, 
        RetainExpansion, 
        NumExpansions);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::ExpandingFunctionParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 670,
   FQN="(anonymous namespace)::TemplateInstantiator::ExpandingFunctionParameterPack", NM="_ZN12_GLOBAL__N_120TemplateInstantiator30ExpandingFunctionParameterPackEPN5clang11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator30ExpandingFunctionParameterPackEPN5clang11ParmVarDeclE")
  //</editor-fold>
  public void ExpandingFunctionParameterPack(ParmVarDecl /*P*/ Pack) {
    SemaRef.CurrentInstantiationScope.MakeInstantiatedLocalArgPack(Pack);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::ForgetPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 674,
   FQN="(anonymous namespace)::TemplateInstantiator::ForgetPartiallySubstitutedPack", NM="_ZN12_GLOBAL__N_120TemplateInstantiator30ForgetPartiallySubstitutedPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator30ForgetPartiallySubstitutedPackEv")
  //</editor-fold>
  public TemplateArgument ForgetPartiallySubstitutedPack() {
    TemplateArgument Result/*J*/= new TemplateArgument();
    {
      NamedDecl /*P*/ PartialPack = SemaRef.CurrentInstantiationScope.getPartiallySubstitutedPack();
      if ((PartialPack != null)) {
        final MultiLevelTemplateArgumentList /*&*/ TemplateArgs = ((/*const_cast*/MultiLevelTemplateArgumentList /*&*/ )(this.TemplateArgs));
        // JAVA: unfold tie
        std.pairUIntUInt $pair = getDepthAndIndex(PartialPack);
        /*uint*/int Depth = $pair.first;
        /*uint*/int Index = $pair.second;        
        if (TemplateArgs.hasTemplateArgument(Depth, Index)) {
          Result.$assign(TemplateArgs.$call(Depth, Index));
          TemplateArgs.setArgument(Depth, Index, new TemplateArgument());
        }
      }
    }
    
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::RememberPartiallySubstitutedPack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 691,
   FQN="(anonymous namespace)::TemplateInstantiator::RememberPartiallySubstitutedPack", NM="_ZN12_GLOBAL__N_120TemplateInstantiator32RememberPartiallySubstitutedPackEN5clang16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator32RememberPartiallySubstitutedPackEN5clang16TemplateArgumentE")
  //</editor-fold>
  public void RememberPartiallySubstitutedPack(TemplateArgument Arg) {
    if (Arg.isNull()) {
      return;
    }
    {
      
      NamedDecl /*P*/ PartialPack = SemaRef.CurrentInstantiationScope.getPartiallySubstitutedPack();
      if ((PartialPack != null)) {
        final MultiLevelTemplateArgumentList /*&*/ TemplateArgs = ((/*const_cast*/MultiLevelTemplateArgumentList /*&*/ )(this.TemplateArgs));
        std.pairUIntUInt $pair = getDepthAndIndex(PartialPack);
        // JAVA: unfold tie
        /*uint*/int Depth = $pair.first;
        /*uint*/int Index = $pair.second;
        TemplateArgs.setArgument(Depth, Index, new TemplateArgument(Arg));
      }
    }
  }
  
  
  /// \brief Transform the given declaration by instantiating a reference to
  /// this declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 864,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformDecl", NM="_ZN12_GLOBAL__N_120TemplateInstantiator13TransformDeclEN5clang14SourceLocationEPNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator13TransformDeclEN5clang14SourceLocationEPNS1_4DeclE")
  //</editor-fold>
  public Decl /*P*/ TransformDecl(SourceLocation Loc, Decl /*P*/ D) {
    if (!(D != null)) {
      return null;
    }
    {
      
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(D);
      if ((TTP != null)) {
        if ($less_uint(TTP.getDepth(), TemplateArgs.getNumLevels())) {
          // If the corresponding template argument is NULL or non-existent, it's
          // because we are performing instantiation from explicitly-specified
          // template arguments in a function template, but there were some
          // arguments left unspecified.
          if (!TemplateArgs.hasTemplateArgument(TTP.getDepth(), 
              TTP.getPosition())) {
            return D;
          }
          
          TemplateArgument Arg = new TemplateArgument(TemplateArgs.$call(TTP.getDepth(), TTP.getPosition()));
          if (TTP.isParameterPack()) {
            assert (Arg.getKind() == TemplateArgument.ArgKind.Pack) : "Missing argument pack";
            Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
          }
          
          TemplateName Template = Arg.getAsTemplate();
          assert (!Template.isNull() && (Template.getAsTemplateDecl() != null)) : "Wrong kind of template template argument";
          return Template.getAsTemplateDecl();
        }
        // Fall through to find the instantiated declaration for this template
        // template parameter.
      }
    }
    
    return SemaRef.FindInstantiatedDecl(new SourceLocation(Loc), cast_NamedDecl(D), TemplateArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::transformAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 709,
   FQN="(anonymous namespace)::TemplateInstantiator::transformAttrs", NM="_ZN12_GLOBAL__N_120TemplateInstantiator14transformAttrsEPN5clang4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator14transformAttrsEPN5clang4DeclES3_")
  //</editor-fold>
  public void transformAttrs(Decl /*P*/ Old, Decl /*P*/ New) {
    SemaRef.InstantiateAttrs(TemplateArgs, Old, New);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::transformedLocalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 713,
   FQN="(anonymous namespace)::TemplateInstantiator::transformedLocalDecl", NM="_ZN12_GLOBAL__N_120TemplateInstantiator20transformedLocalDeclEPN5clang4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator20transformedLocalDeclEPN5clang4DeclES3_")
  //</editor-fold>
  public void transformedLocalDecl(Decl /*P*/ Old, Decl /*P*/ New) {
    // If we've instantiated the call operator of a lambda or the call
    // operator template of a generic lambda, update the "instantiation of"
    // information.
    CXXMethodDecl /*P*/ NewMD = dyn_cast_CXXMethodDecl(New);
    if ((NewMD != null) && isLambdaCallOperator(NewMD)) {
      CXXMethodDecl /*P*/ OldMD = dyn_cast_CXXMethodDecl(Old);
      {
        FunctionTemplateDecl /*P*/ NewTD = NewMD.getDescribedFunctionTemplate();
        if ((NewTD != null)) {
          NewTD.setInstantiatedFromMemberTemplate(OldMD.getDescribedFunctionTemplate());
        } else {
          NewMD.setInstantiationOfMemberFunction(OldMD, 
              TemplateSpecializationKind.TSK_ImplicitInstantiation);
        }
      }
    }
    
    SemaRef.CurrentInstantiationScope.InstantiatedLocal(Old, New);
    {
      
      // We recreated a local declaration, but not by instantiating it. There
      // may be pending dependent diagnostics to produce.
      DeclContext /*P*/ DC = dyn_cast_DeclContext(Old);
      if ((DC != null)) {
        SemaRef.PerformDependentDiagnostics(DC, TemplateArgs);
      }
    }
  }

  
  /// \brief Transform the definition of the given declaration by
  /// instantiating it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 899,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformDefinition", NM="_ZN12_GLOBAL__N_120TemplateInstantiator19TransformDefinitionEN5clang14SourceLocationEPNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator19TransformDefinitionEN5clang14SourceLocationEPNS1_4DeclE")
  //</editor-fold>
  public Decl /*P*/ TransformDefinition(SourceLocation Loc, Decl /*P*/ D) {
    Decl /*P*/ Inst = getSema().SubstDecl(D, getSema().CurContext, TemplateArgs);
    if (!(Inst != null)) {
      return null;
    }
    
    getSema().CurrentInstantiationScope.InstantiatedLocal(D, Inst);
    return Inst;
  }

  
  /// \brief Transform the first qualifier within a scope by instantiating the
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFirstQualifierInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 908,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFirstQualifierInScope", NM="_ZN12_GLOBAL__N_120TemplateInstantiator30TransformFirstQualifierInScopeEPN5clang9NamedDeclENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator30TransformFirstQualifierInScopeEPN5clang9NamedDeclENS1_14SourceLocationE")
  //</editor-fold>
  public NamedDecl /*P*/ TransformFirstQualifierInScope(NamedDecl /*P*/ D, 
                                SourceLocation Loc) {
    {
      // If the first part of the nested-name-specifier was a template type 
      // parameter, instantiate that type parameter down to a tag type.
      TemplateTypeParmDecl /*P*/ TTPD = dyn_cast_or_null_TemplateTypeParmDecl(D);
      if ((TTPD != null)) {
        /*const*/ TemplateTypeParmType /*P*/ TTP = cast_TemplateTypeParmType(getSema().Context.getTypeDeclType(TTPD));
        if ($less_uint(TTP.getDepth(), TemplateArgs.getNumLevels())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: This needs testing w/ member access expressions.
            TemplateArgument Arg = new TemplateArgument(TemplateArgs.$call(TTP.getDepth(), TTP.getIndex()));
            if (TTP.isParameterPack()) {
              assert (Arg.getKind() == TemplateArgument.ArgKind.Pack) : "Missing argument pack";
              if (getSema().ArgumentPackSubstitutionIndex == -1) {
                return null;
              }
              
              Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
            }
            
            QualType T = Arg.getAsType();
            if (T.isNull()) {
              return cast_or_null_NamedDecl(TransformDecl(new SourceLocation(Loc), D));
            }
            {
              
              /*const*/ TagType /*P*/ Tag = T.$arrow().getAs(TagType.class);
              if ((Tag != null)) {
                return Tag.getDecl();
              }
            }
            
            // The resulting type is not a tag; complain.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(getSema().Diag(new SourceLocation(Loc), diag.err_nested_name_spec_non_tag)), T));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    return cast_or_null_NamedDecl(TransformDecl(new SourceLocation(Loc), D));
  }

  
  /// \brief Rebuild the exception declaration and register the declaration
  /// as an instantiated local.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::RebuildExceptionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 947,
   FQN="(anonymous namespace)::TemplateInstantiator::RebuildExceptionDecl", NM="_ZN12_GLOBAL__N_120TemplateInstantiator20RebuildExceptionDeclEPN5clang7VarDeclEPNS1_14TypeSourceInfoENS1_14SourceLocationES6_PNS1_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator20RebuildExceptionDeclEPN5clang7VarDeclEPNS1_14TypeSourceInfoENS1_14SourceLocationES6_PNS1_14IdentifierInfoE")
  //</editor-fold>
  public VarDecl /*P*/ RebuildExceptionDecl(VarDecl /*P*/ ExceptionDecl, 
                      TypeSourceInfo /*P*/ Declarator, 
                      SourceLocation StartLoc, 
                      SourceLocation NameLoc, 
                      IdentifierInfo /*P*/ Name) {
    VarDecl /*P*/ Var = super.RebuildExceptionDecl(ExceptionDecl, Declarator, 
        new SourceLocation(StartLoc), new SourceLocation(NameLoc), Name);
    if ((Var != null)) {
      getSema().CurrentInstantiationScope.InstantiatedLocal(ExceptionDecl, Var);
    }
    return Var;
  }

  
  /// \brief Rebuild the Objective-C exception declaration and register the 
  /// declaration as an instantiated local.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::RebuildObjCExceptionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 960,
   FQN="(anonymous namespace)::TemplateInstantiator::RebuildObjCExceptionDecl", NM="_ZN12_GLOBAL__N_120TemplateInstantiator24RebuildObjCExceptionDeclEPN5clang7VarDeclEPNS1_14TypeSourceInfoENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator24RebuildObjCExceptionDeclEPN5clang7VarDeclEPNS1_14TypeSourceInfoENS1_8QualTypeE")
  //</editor-fold>
  public VarDecl /*P*/ RebuildObjCExceptionDecl(VarDecl /*P*/ ExceptionDecl, 
                          TypeSourceInfo /*P*/ TSInfo, 
                          QualType T) {
    VarDecl /*P*/ Var = super.RebuildObjCExceptionDecl(ExceptionDecl, TSInfo, new QualType(T));
    if ((Var != null)) {
      getSema().CurrentInstantiationScope.InstantiatedLocal(ExceptionDecl, Var);
    }
    return Var;
  }

  
  /// \brief Check for tag mismatches when instantiating an
  /// elaborated type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::RebuildElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 969,
   FQN="(anonymous namespace)::TemplateInstantiator::RebuildElaboratedType", NM="_ZN12_GLOBAL__N_120TemplateInstantiator21RebuildElaboratedTypeEN5clang14SourceLocationENS1_21ElaboratedTypeKeywordENS1_22NestedNameSpecifierLocENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator21RebuildElaboratedTypeEN5clang14SourceLocationENS1_21ElaboratedTypeKeywordENS1_22NestedNameSpecifierLocENS1_8QualTypeE")
  //</editor-fold>
  public QualType RebuildElaboratedType(SourceLocation KeywordLoc, 
                       ElaboratedTypeKeyword Keyword, 
                       NestedNameSpecifierLoc QualifierLoc, 
                       QualType T) {
    {
      /*const*/ TagType /*P*/ TT = T.$arrow().getAs(TagType.class);
      if ((TT != null)) {
        TagDecl /*P*/ TD = TT.getDecl();
        
        SourceLocation TagLocation = new SourceLocation(KeywordLoc);
        
        IdentifierInfo /*P*/ Id = TD.getIdentifier();
        
        // TODO: should we even warn on struct/class mismatches for this?  Seems
        // like it's likely to produce a lot of spurious errors.
        if ((Id != null) && Keyword != ElaboratedTypeKeyword.ETK_None && Keyword != ElaboratedTypeKeyword.ETK_Typename) {
          TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForKeyword(Keyword);
          if (!SemaRef.isAcceptableTagRedeclaration(TD, Kind, /*isDefinition*/ false, 
              new SourceLocation(TagLocation), Id)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(TagLocation), diag.err_use_with_wrong_tag)), 
                      Id), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/TagLocation), 
                      TD.getKindName())));
              $c$.clean($c$.track(SemaRef.Diag(TD.getLocation(), diag.note_previous_use)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    return super.RebuildElaboratedType(new SourceLocation(KeywordLoc), 
        Keyword, 
        new NestedNameSpecifierLoc(QualifierLoc), 
        new QualType(T));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1002,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformTemplateName", NM="_ZN12_GLOBAL__N_120TemplateInstantiator21TransformTemplateNameERN5clang12CXXScopeSpecENS1_12TemplateNameENS1_14SourceLocationENS1_8QualTypeEPNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator21TransformTemplateNameERN5clang12CXXScopeSpecENS1_12TemplateNameENS1_14SourceLocationENS1_8QualTypeEPNS1_9NamedDeclE")
  //</editor-fold>
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, 
                       TemplateName Name, 
                       SourceLocation NameLoc) {
    return TransformTemplateName(SS, 
                       Name, 
                       NameLoc, 
                       new QualType(), 
                       (NamedDecl /*P*/ )null);
  }
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, 
                       TemplateName Name, 
                       SourceLocation NameLoc, 
                       QualType ObjectType/*= QualType()*/) {
    return TransformTemplateName(SS, 
                       Name, 
                       NameLoc, 
                       ObjectType, 
                       (NamedDecl /*P*/ )null);
  }
  public TemplateName TransformTemplateName(final CXXScopeSpec /*&*/ SS, 
                       TemplateName Name, 
                       SourceLocation NameLoc, 
                       QualType ObjectType/*= QualType()*/, 
                       NamedDecl /*P*/ FirstQualifierInScope/*= null*/) {
    {
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_or_null_TemplateTemplateParmDecl(Name.getAsTemplateDecl());
      if ((TTP != null)) {
        if ($less_uint(TTP.getDepth(), TemplateArgs.getNumLevels())) {
          // If the corresponding template argument is NULL or non-existent, it's
          // because we are performing instantiation from explicitly-specified
          // template arguments in a function template, but there were some
          // arguments left unspecified.
          if (!TemplateArgs.hasTemplateArgument(TTP.getDepth(), 
              TTP.getPosition())) {
            return new TemplateName(JD$Move.INSTANCE, Name);
          }
          
          TemplateArgument Arg = new TemplateArgument(TemplateArgs.$call(TTP.getDepth(), TTP.getPosition()));
          if (TTP.isParameterPack()) {
            assert (Arg.getKind() == TemplateArgument.ArgKind.Pack) : "Missing argument pack";
            if (getSema().ArgumentPackSubstitutionIndex == -1) {
              // We have the template argument pack to substitute, but we're not
              // actually expanding the enclosing pack expansion yet. So, just
              // keep the entire argument pack.
              return getSema().Context.getSubstTemplateTemplateParmPack(TTP, Arg);
            }
            
            Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
          }
          
          TemplateName Template = Arg.getAsTemplate();
          assert (!Template.isNull()) : "Null template template argument";
          {
            
            // We don't ever want to substitute for a qualified template name, since
            // the qualifier is handled separately. So, look through the qualified
            // template name to its underlying declaration.
            QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
            if ((QTN != null)) {
              Template.$assignMove(new TemplateName(QTN.getTemplateDecl()));
            }
          }
          
          Template.$assignMove(getSema().Context.getSubstTemplateTemplateParm(TTP, new TemplateName(Template)));
          return Template;
        }
      }
    }
    {
      
      SubstTemplateTemplateParmPackStorage /*P*/ SubstPack = Name.getAsSubstTemplateTemplateParmPack();
      if ((SubstPack != null)) {
        if (getSema().ArgumentPackSubstitutionIndex == -1) {
          return new TemplateName(JD$Move.INSTANCE, Name);
        }
        
        TemplateArgument Arg = SubstPack.getArgumentPack();
        Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
        return Arg.getAsTemplate();
      }
    }
    
    return super.TransformTemplateName(SS, new TemplateName(Name), new SourceLocation(NameLoc), new QualType(ObjectType), 
        FirstQualifierInScope);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformLoopHintAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1108,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformLoopHintAttr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator21TransformLoopHintAttrEPKN5clang12LoopHintAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator21TransformLoopHintAttrEPKN5clang12LoopHintAttrE")
  //</editor-fold>
  public /*const*/ LoopHintAttr /*P*/ TransformLoopHintAttr(/*const*/ LoopHintAttr /*P*/ LH) {
    Expr /*P*/ TransformedExpr = getDerived().TransformExpr(LH.getValue()).get();
    if (TransformedExpr == LH.getValue()) {
      return LH;
    }
    
    // Generate error if there is a problem with the value.
    if (getSema().CheckLoopHintExpr(TransformedExpr, LH.getLocation())) {
      return LH;
    }
    
    // Create new LoopHintValueAttr with integral expression in place of the
    // non-type template parameter.
    return LoopHintAttr.CreateImplicit(getSema().Context, LH.getSemanticSpelling(), LH.getOption(), 
        LH.getState(), TransformedExpr, LH.getRange());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1062,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformPredefinedExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator23TransformPredefinedExprEPN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator23TransformPredefinedExprEPN5clang14PredefinedExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformPredefinedExpr(PredefinedExpr /*P*/ E) {
    if (!E.isTypeDependent()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return getSema().BuildPredefinedExpr(E.getLocation(), E.getIdentType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1274,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformDeclRefExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator20TransformDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator20TransformDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDeclRefExpr(DeclRefExpr /*P*/ E) {
    NamedDecl /*P*/ D = E.getDecl();
    {
      
      // Handle references to non-type template parameters and non-type template
      // parameter packs.
      NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(D);
      if ((NTTP != null)) {
        if ($less_uint(NTTP.getDepth(), TemplateArgs.getNumLevels())) {
          return TransformTemplateParmRefExpr(E, NTTP);
        }
        // We have a non-type template parameter that isn't fully substituted;
        // FindInstantiatedDecl will find it in the local instantiation scope.
      }
    }
    {
      
      // Handle references to function parameter packs.
      ParmVarDecl /*P*/ PD = dyn_cast_ParmVarDecl(D);
      if ((PD != null)) {
        if (PD.isParameterPack()) {
          return TransformFunctionParmPackRefExpr(E, PD);
        }
      }
    }
    
    return super.TransformDeclRefExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1296,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator26TransformCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator26TransformCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ E) {
    assert (!(cast_FunctionDecl(E.getParam().getDeclContext()).getDescribedFunctionTemplate() != null)) : "Default arg expressions are never formed in dependent cases.";
    return SemaRef.BuildCXXDefaultArgExpr(E.getUsedLocation(), 
        cast_FunctionDecl(E.getParam().getDeclContext()), 
        E.getParam());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformTemplateParmRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1070,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformTemplateParmRefExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator28TransformTemplateParmRefExprEPN5clang11DeclRefExprEPNS1_23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator28TransformTemplateParmRefExprEPN5clang11DeclRefExprEPNS1_23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformTemplateParmRefExpr(DeclRefExpr /*P*/ E, 
                              NonTypeTemplateParmDecl /*P*/ NTTP) {
    // If the corresponding template argument is NULL or non-existent, it's
    // because we are performing instantiation from explicitly-specified
    // template arguments in a function template, but there were some
    // arguments left unspecified.
    if (!TemplateArgs.hasTemplateArgument(NTTP.getDepth(), 
        NTTP.getPosition())) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    TemplateArgument Arg = new TemplateArgument(TemplateArgs.$call(NTTP.getDepth(), NTTP.getPosition()));
    if (NTTP.isParameterPack()) {
      assert (Arg.getKind() == TemplateArgument.ArgKind.Pack) : "Missing argument pack";
      if (getSema().ArgumentPackSubstitutionIndex == -1) {
        // We have an argument pack, but we can't select a particular argument
        // out of it yet. Therefore, we'll build an expression to hold on to that
        // argument pack.
        QualType TargetType = SemaRef.SubstType(NTTP.getType(), TemplateArgs, 
            E.getLocation(), 
            NTTP.getDeclName());
        if (TargetType.isNull()) {
          return ExprError();
        }
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new SubstNonTypeTemplateParmPackExpr(new QualType(TargetType), 
                NTTP, 
                E.getLocation(), 
                Arg)));
      }
      
      Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
    }
    
    return transformNonTypeTemplateParmRef(NTTP, E.getLocation(), new TemplateArgument(Arg));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1189,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformSubstNonTypeTemplateParmPackExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator41TransformSubstNonTypeTemplateParmPackExprEPN5clang32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator41TransformSubstNonTypeTemplateParmPackExprEPN5clang32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr /*P*/ E) {
    if (getSema().ArgumentPackSubstitutionIndex == -1) {
      // We aren't expanding the parameter pack, so just return ourselves.
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    TemplateArgument Arg = E.getArgumentPack();
    Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
    return transformNonTypeTemplateParmRef(E.getParameterPack(), 
        E.getParameterPackLocation(), 
        new TemplateArgument(Arg));
  }

  
  /// \brief Rebuild a DeclRefExpr for a ParmVarDecl reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::RebuildParmVarDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1204,
   FQN="(anonymous namespace)::TemplateInstantiator::RebuildParmVarDeclRefExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator25RebuildParmVarDeclRefExprEPN5clang11ParmVarDeclENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator25RebuildParmVarDeclRefExprEPN5clang11ParmVarDeclENS1_14SourceLocationE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildParmVarDeclRefExpr(ParmVarDecl /*P*/ PD, 
                           SourceLocation Loc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(PD.getDeclName(), new SourceLocation(Loc));
      return $c$.clean(getSema().BuildDeclarationNameExpr($c$.track(new CXXScopeSpec()), NameInfo, PD));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Transform a reference to a function parameter pack.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFunctionParmPackRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1244,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFunctionParmPackRefExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator32TransformFunctionParmPackRefExprEPN5clang11DeclRefExprEPNS1_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator32TransformFunctionParmPackRefExprEPN5clang11DeclRefExprEPNS1_11ParmVarDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformFunctionParmPackRefExpr(DeclRefExpr /*P*/ E, 
                                  ParmVarDecl /*P*/ PD) {
    /*typedef LocalInstantiationScope::DeclArgumentPack DeclArgumentPack*/
//    final class DeclArgumentPack extends SmallVector<ParmVarDecl /*P*/ >{ };
    PointerUnion<Decl /*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*P*/ Found = getSema().CurrentInstantiationScope.findInstantiationOf(PD);
    assert ((Found != null)) : "no instantiation for parameter pack";
    
    Decl /*P*/ TransformedDecl;
    {
      SmallVector<ParmVarDecl /*P*/ > /*P*/ Pack = Found.dyn_cast(SmallVector /*P*/.class);
      if ((Pack != null)) {
        // If this is a reference to a function parameter pack which we can
        // substitute but can't yet expand, build a FunctionParmPackExpr for it.
        if (getSema().ArgumentPackSubstitutionIndex == -1) {
          QualType T = TransformType(E.getType());
          if (T.isNull()) {
            return ExprError();
          }
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, FunctionParmPackExpr.Create(getSema().Context, new QualType(T), PD, 
                  E.getExprLoc(), new ArrayRef<ParmVarDecl /*P*/ >($Deref(Pack), true)));
        }
        
        TransformedDecl = (/*Deref*/Pack).$at(getSema().ArgumentPackSubstitutionIndex);
      } else {
        TransformedDecl = Found.get(Decl /*P*/.class);
      }
    }
    
    // We have either an unexpanded pack or a specific expansion.
    return RebuildParmVarDeclRefExpr(cast_ParmVarDecl(TransformedDecl), 
        E.getExprLoc());
  }

  
  /// \brief Transform a FunctionParmPackExpr which was built when we couldn't
  /// expand a function parameter pack reference which refers to an expanded
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1211,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFunctionParmPackExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator29TransformFunctionParmPackExprEPN5clang20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator29TransformFunctionParmPackExprEPN5clang20FunctionParmPackExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformFunctionParmPackExpr(FunctionParmPackExpr /*P*/ E) {
    if (getSema().ArgumentPackSubstitutionIndex != -1) {
      // We can expand this parameter pack now.
      ParmVarDecl /*P*/ D = E.getExpansion(getSema().ArgumentPackSubstitutionIndex);
      ValueDecl /*P*/ VD = cast_or_null_ValueDecl(TransformDecl(E.getExprLoc(), D));
      if (!(VD != null)) {
        return ExprError();
      }
      return RebuildParmVarDeclRefExpr(cast_ParmVarDecl(VD), E.getExprLoc());
    }
    
    QualType T = TransformType(E.getType());
    if (T.isNull()) {
      return ExprError();
    }
    
    // Transform each of the parameter expansions into the corresponding
    // parameters in the instantiation of the function decl.
    SmallVector<ParmVarDecl /*P*/ > Parms/*J*/= new SmallVector<ParmVarDecl /*P*/ >(8, (ParmVarDecl /*P*/ )null);
    Parms.reserve(E.getNumExpansions());
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> I = $tryClone(E.begin()), /*P*/ /*const*/ /*P*/ End = $tryClone(E.end());
         $noteq_ptr(I, End); I.$preInc()) {
      ParmVarDecl /*P*/ D = cast_or_null_ParmVarDecl(TransformDecl(E.getExprLoc(), I.$star()));
      if (!(D != null)) {
        return ExprError();
      }
      Parms.push_back(D);
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, FunctionParmPackExpr.Create(getSema().Context, new QualType(T), 
            E.getParameterPack(), 
            E.getParameterPackLocation(), new ArrayRef<ParmVarDecl /*P*/ >(Parms, true)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 793,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFunctionProtoType", NM="_ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionProtoTypeERN5clang14TypeLocBuilderENS1_20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionProtoTypeERN5clang14TypeLocBuilderENS1_20FunctionProtoTypeLocE")
  //</editor-fold>
  public QualType TransformFunctionProtoType(final TypeLocBuilder /*&*/ TLB, 
                            FunctionProtoTypeLoc TL) {
    // Call the base version; it will forward to our overridden version below.
    return super.TransformFunctionProtoType(TLB, new FunctionProtoTypeLoc(TL));
  }

  
  /*template <typename Fn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFunctionProtoType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1307,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFunctionProtoType", NM="Tpl__ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionProtoTypeERN5clang14TypeLocBuilderENS1_20FunctionProtoTypeLocEPNS1_13CXXRecordDeclEjT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=Tpl__ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionProtoTypeERN5clang14TypeLocBuilderENS1_20FunctionProtoTypeLocEPNS1_13CXXRecordDeclEjT_")
  //</editor-fold>
  public QualType TransformFunctionProtoType(final TypeLocBuilder /*&*/ TLB, 
                              FunctionProtoTypeLoc TL, 
                              CXXRecordDecl /*P*/ ThisContext, 
                              /*uint*/int ThisTypeQuals, 
                              TwoTypes2Bool<ExceptionSpecInfo,bool$ref> TransformExceptionSpec) {
    LocalInstantiationScope Scope = null;
    try {
      // We need a local instantiation scope for this function prototype.
      Scope/*J*/= new LocalInstantiationScope(SemaRef, /*CombineWithOuterScope=*/ true);
      return super.TransformFunctionProtoType(TLB, TL, ThisContext, ThisTypeQuals, TransformExceptionSpec);
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformFunctionTypeParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1318,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformFunctionTypeParam", NM="_ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionTypeParamEPN5clang11ParmVarDeclEiN4llvm8OptionalIjEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator26TransformFunctionTypeParamEPN5clang11ParmVarDeclEiN4llvm8OptionalIjEEb")
  //</editor-fold>
  public ParmVarDecl /*P*/ TransformFunctionTypeParam(ParmVarDecl /*P*/ OldParm, 
                            int indexAdjustment, 
                            OptionalUInt NumExpansions, 
                            boolean ExpectParameterPack) {
    return SemaRef.SubstParmVarDecl(OldParm, TemplateArgs, indexAdjustment, 
        new OptionalUInt(NumExpansions), ExpectParameterPack);
  }

  
  /// \brief Transforms a template type parameter type by performing
  /// substitution of the corresponding template type argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1327,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformTemplateTypeParmType", NM="_ZN12_GLOBAL__N_120TemplateInstantiator29TransformTemplateTypeParmTypeERN5clang14TypeLocBuilderENS1_23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator29TransformTemplateTypeParmTypeERN5clang14TypeLocBuilderENS1_23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public QualType TransformTemplateTypeParmType(final TypeLocBuilder /*&*/ TLB, 
                               TemplateTypeParmTypeLoc TL) {
    /*const*/ TemplateTypeParmType /*P*/ T = TL.getTypePtr();
    if ($less_uint(T.getDepth(), TemplateArgs.getNumLevels())) {
      // Replace the template type parameter with its corresponding
      // template argument.
      
      // If the corresponding template argument is NULL or doesn't exist, it's
      // because we are performing instantiation from explicitly-specified
      // template arguments in a function template class, but there were some
      // arguments left unspecified.
      if (!TemplateArgs.hasTemplateArgument(T.getDepth(), T.getIndex())) {
        TemplateTypeParmTypeLoc NewTL = TLB.push(TemplateTypeParmTypeLoc.class, TL.getType());
        NewTL.setNameLoc(TL.getNameLoc());
        return TL.getType();
      }
      
      TemplateArgument Arg = new TemplateArgument(TemplateArgs.$call(T.getDepth(), T.getIndex()));
      if (T.isParameterPack()) {
        assert (Arg.getKind() == TemplateArgument.ArgKind.Pack) : "Missing argument pack";
        if (getSema().ArgumentPackSubstitutionIndex == -1) {
          // We have the template argument pack, but we're not expanding the
          // enclosing pack expansion yet. Just save the template argument
          // pack for later substitution.
          QualType Result = getSema().Context.getSubstTemplateTypeParmPackType(T, Arg);
          SubstTemplateTypeParmPackTypeLoc NewTL = TLB.push(SubstTemplateTypeParmPackTypeLoc.class, new QualType(Result));
          NewTL.setNameLoc(TL.getNameLoc());
          return Result;
        }
        
        Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
      }
      assert (Arg.getKind() == TemplateArgument.ArgKind.Type) : "Template argument kind mismatch";
      
      QualType Replacement = Arg.getAsType();
      
      // TODO: only do this uniquing once, at the start of instantiation.
      QualType Result = getSema().Context.getSubstTemplateTypeParmType(T, new QualType(Replacement));
      SubstTemplateTypeParmTypeLoc NewTL = TLB.push(SubstTemplateTypeParmTypeLoc.class, new QualType(Result));
      NewTL.setNameLoc(TL.getNameLoc());
      return Result;
    }
    
    // The template type parameter comes from an inner template (e.g.,
    // the template parameter list of a member template inside the
    // template we are instantiating). Create a new template type
    // parameter with the template "level" reduced by one.
    TemplateTypeParmDecl /*P*/ NewTTPDecl = null;
    {
      TemplateTypeParmDecl /*P*/ OldTTPDecl = T.getDecl();
      if ((OldTTPDecl != null)) {
        NewTTPDecl = cast_or_null_TemplateTypeParmDecl(TransformDecl(TL.getNameLoc(), OldTTPDecl));
      }
    }
    
    QualType Result = getSema().Context.getTemplateTypeParmType(T.getDepth()
           - TemplateArgs.getNumLevels(), 
        T.getIndex(), 
        T.isParameterPack(), 
        NewTTPDecl);
    TemplateTypeParmTypeLoc NewTL = TLB.push(TemplateTypeParmTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    return Result;
  }

  
  /// \brief Transforms an already-substituted template type parameter pack
  /// into either itself (if we aren't substituting into its pack expansion)
  /// or the appropriate substituted argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1401,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformSubstTemplateTypeParmPackType", NM="_ZN12_GLOBAL__N_120TemplateInstantiator38TransformSubstTemplateTypeParmPackTypeERN5clang14TypeLocBuilderENS1_32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator38TransformSubstTemplateTypeParmPackTypeERN5clang14TypeLocBuilderENS1_32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public QualType TransformSubstTemplateTypeParmPackType(final TypeLocBuilder /*&*/ TLB, 
                                        SubstTemplateTypeParmPackTypeLoc TL) {
    if (getSema().ArgumentPackSubstitutionIndex == -1) {
      // We aren't expanding the parameter pack, so just return ourselves.
      SubstTemplateTypeParmPackTypeLoc NewTL = TLB.push(SubstTemplateTypeParmPackTypeLoc.class, TL.getType());
      NewTL.setNameLoc(TL.getNameLoc());
      return TL.getType();
    }
    
    TemplateArgument Arg = TL.getTypePtr().getArgumentPack();
    Arg.$assignMove(getPackSubstitutedTemplateArgument(getSema(), new TemplateArgument(Arg)));
    QualType Result = Arg.getAsType();
    
    Result.$assignMove(getSema().Context.getSubstTemplateTypeParmType(TL.getTypePtr().getReplacedParameter(), 
            new QualType(Result)));
    SubstTemplateTypeParmTypeLoc NewTL = TLB.push(SubstTemplateTypeParmTypeLoc.class, new QualType(Result));
    NewTL.setNameLoc(TL.getNameLoc());
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 822,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformLambdaExpr", NM="_ZN12_GLOBAL__N_120TemplateInstantiator19TransformLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator19TransformLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E) {
    LocalInstantiationScope Scope = null;
    try {
      Scope/*J*/= new LocalInstantiationScope(SemaRef, /*CombineWithOuterScope=*/ true);
      return super.TransformLambdaExpr(E);
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::TransformTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 827,
   FQN="(anonymous namespace)::TemplateInstantiator::TransformTemplateParameterList", NM="_ZN12_GLOBAL__N_120TemplateInstantiator30TransformTemplateParameterListEPN5clang21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator30TransformTemplateParameterListEPN5clang21TemplateParameterListE")
  //</editor-fold>
  public TemplateParameterList /*P*/ TransformTemplateParameterList(TemplateParameterList /*P*/ OrigTPL) {
    TemplateDeclInstantiator DeclInstantiator = null;
    try {
      if (!(OrigTPL != null) || !(OrigTPL.size() != 0)) {
        return OrigTPL;
      }
      
      DeclContext /*P*/ Owner = OrigTPL.getParam(0).getDeclContext();
      DeclInstantiator/*J*/= new TemplateDeclInstantiator(getSema(), 
          /* DeclContext *Owner */ Owner, TemplateArgs);
      return DeclInstantiator.SubstTemplateParams(OrigTPL);
    } finally {
      if (DeclInstantiator != null) { DeclInstantiator.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::transformNonTypeTemplateParmRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1126,
   FQN="(anonymous namespace)::TemplateInstantiator::transformNonTypeTemplateParmRef", NM="_ZN12_GLOBAL__N_120TemplateInstantiator31transformNonTypeTemplateParmRefEPN5clang23NonTypeTemplateParmDeclENS1_14SourceLocationENS1_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiator31transformNonTypeTemplateParmRefEPN5clang23NonTypeTemplateParmDeclENS1_14SourceLocationENS1_16TemplateArgumentE")
  //</editor-fold>
  private ActionResultTTrue<Expr /*P*/ > transformNonTypeTemplateParmRef(NonTypeTemplateParmDecl /*P*/ parm, 
                                 SourceLocation loc, 
                                 TemplateArgument arg) {
    ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    QualType type/*J*/= new QualType();
    
    // The template argument itself might be an expression, in which
    // case we just return that expression.
    if (arg.getKind() == TemplateArgument.ArgKind.Expression) {
      Expr /*P*/ argExpr = arg.getAsExpr();
      result.$assign(argExpr);
      type.$assignMove(argExpr.getType());
    } else if (arg.getKind() == TemplateArgument.ArgKind.Declaration
       || arg.getKind() == TemplateArgument.ArgKind.NullPtr) {
      ValueDecl /*P*/ VD;
      if (arg.getKind() == TemplateArgument.ArgKind.Declaration) {
        VD = cast_ValueDecl(arg.getAsDecl());
        
        // Find the instantiation of the template argument.  This is
        // required for nested templates.
        VD = cast_or_null_ValueDecl(getSema().FindInstantiatedDecl(new SourceLocation(loc), VD, TemplateArgs));
        if (!(VD != null)) {
          return ExprError();
        }
      } else {
        // Propagate NULL template argument.
        VD = null;
      }
      
      // Derive the type we want the substituted decl to have.  This had
      // better be non-dependent, or these checks will have serious problems.
      if (parm.isExpandedParameterPack()) {
        type.$assignMove(parm.getExpansionType(SemaRef.ArgumentPackSubstitutionIndex));
      } else if (parm.isParameterPack()
         && isa_PackExpansionType(parm.getType())) {
        type.$assignMove(SemaRef.SubstType(cast_PackExpansionType(parm.getType()).getPattern(), 
                TemplateArgs, new SourceLocation(loc), parm.getDeclName()));
      } else {
        type.$assignMove(SemaRef.SubstType(parm.getType(), TemplateArgs, 
                new SourceLocation(loc), parm.getDeclName()));
      }
      assert (!type.isNull()) : "type substitution failed for param type";
      assert (!type.$arrow().isDependentType()) : "param type still dependent";
      result.$assignMove(SemaRef.BuildExpressionFromDeclTemplateArgument(arg, new QualType(type), new SourceLocation(loc)));
      if (!result.isInvalid()) {
        type.$assignMove(result.get().getType());
      }
    } else {
      result.$assignMove(SemaRef.BuildExpressionFromIntegralTemplateArgument(arg, new SourceLocation(loc)));
      
      // Note that this type can be different from the type of 'result',
      // e.g. if it's an enum type.
      type.$assignMove(arg.getIntegralType());
    }
    if (result.isInvalid()) {
      return ExprError();
    }
    
    Expr /*P*/ resultExpr = result.get();
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new SubstNonTypeTemplateParmExpr(new QualType(type), resultExpr.getValueKind(), new SourceLocation(loc), parm, resultExpr)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateInstantiator::~TemplateInstantiator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 622,
   FQN="(anonymous namespace)::TemplateInstantiator::~TemplateInstantiator", NM="_ZN12_GLOBAL__N_120TemplateInstantiatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_120TemplateInstantiatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TemplateArgs=" + TemplateArgs // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Entity=" + Entity // NOI18N
              + super.toString(); // NOI18N
  }
}
