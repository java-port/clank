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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Represents a variable template specialization, which refers to
/// a variable template with a given set of template arguments.
///
/// Variable template specializations represent both explicit
/// specializations of variable templates, as in the example below, and
/// implicit instantiations of variable templates.
///
/// \code
/// template<typename T> constexpr T pi = T(3.1415926535897932385);
///
/// template<>
/// constexpr float pi<float>; // variable template specialization pi<float>
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2374,
 FQN="clang::VarTemplateSpecializationDecl", NM="_ZN5clang29VarTemplateSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDeclE")
//</editor-fold>
public class VarTemplateSpecializationDecl extends /*public*/ VarDecl implements /*public*/ FoldingSetImpl.Node, 
        HasGetTemplateArgs$TemplateArgumentList, HasGetSpecializedTemplate<VarTemplateDecl>, Destructors.ClassWithDestructor {
  
  /// \brief Structure that stores information about a variable template
  /// specialization that was instantiated from a variable template partial
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::SpecializedPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2380,
   FQN="clang::VarTemplateSpecializationDecl::SpecializedPartialSpecialization", NM="_ZN5clang29VarTemplateSpecializationDecl32SpecializedPartialSpecializationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl32SpecializedPartialSpecializationE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ SpecializedPartialSpecialization {
    /// \brief The variable template partial specialization from which this
    /// variable template specialization was instantiated.
    public VarTemplatePartialSpecializationDecl /*P*/ PartialSpecialization;
    
    /// \brief The template argument list deduced for the variable template
    /// partial specialization itself.
    public /*const*/ TemplateArgumentList /*P*/ TemplateArgs;
    
    @Override public String toString() {
      return "" + "PartialSpecialization=" + PartialSpecialization // NOI18N
                + ", TemplateArgs=" + TemplateArgs; // NOI18N
    }
  };
  
  /// \brief The template that this specialization specializes.
  /*friend*/public PointerUnion<VarTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ > SpecializedTemplate;
  
  /// \brief Further info for explicit template specialization/instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::ExplicitSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2395,
   FQN="clang::VarTemplateSpecializationDecl::ExplicitSpecializationInfo", NM="_ZN5clang29VarTemplateSpecializationDecl26ExplicitSpecializationInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl26ExplicitSpecializationInfoE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ ExplicitSpecializationInfo {
    /// \brief The type-as-written.
    public TypeSourceInfo /*P*/ TypeAsWritten;
    /// \brief The location of the extern keyword.
    public SourceLocation ExternLoc;
    /// \brief The location of the template keyword.
    public SourceLocation TemplateKeywordLoc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::ExplicitSpecializationInfo::ExplicitSpecializationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2403,
     FQN="clang::VarTemplateSpecializationDecl::ExplicitSpecializationInfo::ExplicitSpecializationInfo", NM="_ZN5clang29VarTemplateSpecializationDecl26ExplicitSpecializationInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl26ExplicitSpecializationInfoC1Ev")
    //</editor-fold>
    public ExplicitSpecializationInfo() {
      // : TypeAsWritten(null), ExternLoc(), TemplateKeywordLoc() 
      //START JInit
      this.TypeAsWritten = null;
      this.ExternLoc = new SourceLocation();
      this.TemplateKeywordLoc = new SourceLocation();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "TypeAsWritten=" + TypeAsWritten // NOI18N
                + ", ExternLoc=" + ExternLoc // NOI18N
                + ", TemplateKeywordLoc=" + TemplateKeywordLoc; // NOI18N
    }
  };
  
  /// \brief Further info for explicit template specialization/instantiation.
  /// Does not apply to implicit specializations.
  /*friend*/public ExplicitSpecializationInfo /*P*/ ExplicitInfo;
  
  /// \brief The template arguments used to describe this specialization.
  /*friend*/public /*const*/ TemplateArgumentList /*P*/ TemplateArgs;
  private TemplateArgumentListInfo TemplateArgsInfo;
  
  /// \brief The point where this template was instantiated (if any).
  /*friend*/public SourceLocation PointOfInstantiation;
  
  /// \brief The kind of specialization this declaration refers to.
  /// Really a value of type TemplateSpecializationKind.
  /*friend*/public /*JBYTE unsigned int*/ byte SpecializationKind /*: 3*/;
/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // VarTemplateSpecializationDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::VarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1054,
   FQN="clang::VarTemplateSpecializationDecl::VarTemplateSpecializationDecl", NM="_ZN5clang29VarTemplateSpecializationDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  protected VarTemplateSpecializationDecl(Kind DK, final ASTContext /*&*/ Context, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, VarTemplateDecl /*P*/ SpecializedTemplate, QualType T, 
      TypeSourceInfo /*P*/ TInfo, StorageClass S, ArrayRef<TemplateArgument> Args) {
    // : VarDecl(DK, Context, DC, StartLoc, IdLoc, SpecializedTemplate->getIdentifier(), T, TInfo, S), FoldingSetNode(), SpecializedTemplate(SpecializedTemplate), ExplicitInfo(null), TemplateArgs(TemplateArgumentList::CreateCopy(Context, Args)), TemplateArgsInfo(), PointOfInstantiation(), SpecializationKind(TSK_Undeclared) 
    //START JInit
    super(DK, Context, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
        SpecializedTemplate.getIdentifier(), new QualType(T), TInfo, S);
    $Node();
    this.SpecializedTemplate = new PointerUnion<VarTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ >(JD$T.INSTANCE, VarTemplateDecl /*P*/ .class, SpecializedTemplate);
    this.ExplicitInfo = null;
    this.TemplateArgs = TemplateArgumentList.CreateCopy(Context, new ArrayRef<TemplateArgument>(Args));
    this.TemplateArgsInfo = new TemplateArgumentListInfo();
    this.PointOfInstantiation = new SourceLocation();
    this.SpecializationKind = $uint2uint_3bits(TemplateSpecializationKind.TSK_Undeclared.getValue());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::VarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1064,
   FQN="clang::VarTemplateSpecializationDecl::VarTemplateSpecializationDecl", NM="_ZN5clang29VarTemplateSpecializationDeclC1ENS_4Decl4KindERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDeclC1ENS_4Decl4KindERNS_10ASTContextE")
  //</editor-fold>
  protected VarTemplateSpecializationDecl(Kind DK, 
      final ASTContext /*&*/ C) {
    // : VarDecl(DK, C, null, SourceLocation(), SourceLocation(), null, QualType(), null, SC_None), FoldingSetNode(), SpecializedTemplate(), ExplicitInfo(null), TemplateArgsInfo(), PointOfInstantiation(), SpecializationKind(TSK_Undeclared) 
    //START JInit
    super(DK, C, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        new QualType(), (TypeSourceInfo /*P*/ )null, StorageClass.SC_None);
    $Node();
    this.SpecializedTemplate = new PointerUnion<VarTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ >(VarTemplateDecl /*P*/ .class);
    this.ExplicitInfo = null;
    this.TemplateArgsInfo = new TemplateArgumentListInfo();
    this.PointOfInstantiation = new SourceLocation();
    this.SpecializationKind = $uint2uint_3bits(TemplateSpecializationKind.TSK_Undeclared.getValue());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1070,
   FQN="clang::VarTemplateSpecializationDecl::Create", NM="_ZN5clang29VarTemplateSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public static VarTemplateSpecializationDecl /*P*/ Create(final ASTContext /*&*/ Context, DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, VarTemplateDecl /*P*/ SpecializedTemplate, QualType T, 
        TypeSourceInfo /*P*/ TInfo, StorageClass S, ArrayRef<TemplateArgument> Args) {
    return /*NEW_EXPR [Decl::new]*//*new (Context, DC)*/ Decl.$new(Context, DC, (type$ptr<?> Mem)->{
        return new VarTemplateSpecializationDecl(Kind.VarTemplateSpecialization, Context, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
                SpecializedTemplate, new QualType(T), TInfo, S, new ArrayRef<TemplateArgument>(Args));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1079,
   FQN="clang::VarTemplateSpecializationDecl::CreateDeserialized", NM="_ZN5clang29VarTemplateSpecializationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static VarTemplateSpecializationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new VarTemplateSpecializationDecl(Kind.VarTemplateSpecialization, C);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getNameForDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1085,
   FQN="clang::VarTemplateSpecializationDecl::getNameForDiagnostic", NM="_ZNK5clang29VarTemplateSpecializationDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  @Override public void getNameForDiagnostic(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, boolean Qualified) /*const*//* override*/ {
    super.getNameForDiagnostic(OS, Policy, Qualified);
    
    final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = getTemplateArgs();
    TemplateSpecializationType.PrintTemplateArgumentList1(OS, TemplateArgs.asArray(), Policy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2444,
   FQN="clang::VarTemplateSpecializationDecl::getMostRecentDecl", NM="_ZN5clang29VarTemplateSpecializationDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl17getMostRecentDeclEv")
  //</editor-fold>
  public VarTemplateSpecializationDecl /*P*/ getMostRecentDecl() {
    VarDecl /*P*/ Recent = /*JCast:VarDecl * */super.getMostRecentDecl$Redeclarable();
    return cast_VarTemplateSpecializationDecl(Recent);
  }

  
  /// \brief Retrieve the template that this specialization specializes.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getSpecializedTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1094,
   FQN="clang::VarTemplateSpecializationDecl::getSpecializedTemplate", NM="_ZNK5clang29VarTemplateSpecializationDecl22getSpecializedTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl22getSpecializedTemplateEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getSpecializedTemplate() /*const*/ {
    {
      SpecializedPartialSpecialization /*P*/ PartialSpec = SpecializedTemplate.dyn_cast(SpecializedPartialSpecialization /*P*/.class);
      if ((PartialSpec != null)) {
        return PartialSpec.PartialSpecialization.getSpecializedTemplate();
      }
    }
    return SpecializedTemplate.get(VarTemplateDecl /*P*/.class);
  }

  
  /// \brief Retrieve the template arguments of the variable template
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2454,
   FQN="clang::VarTemplateSpecializationDecl::getTemplateArgs", NM="_ZNK5clang29VarTemplateSpecializationDecl15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentList /*&*/ getTemplateArgs() /*const*/ {
    return $Deref(TemplateArgs);
  }

  
  // TODO: Always set this when creating the new specialization?
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setTemplateArgsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1101,
   FQN="clang::VarTemplateSpecializationDecl::setTemplateArgsInfo", NM="_ZN5clang29VarTemplateSpecializationDecl19setTemplateArgsInfoERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl19setTemplateArgsInfoERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void setTemplateArgsInfo(final /*const*/ TemplateArgumentListInfo /*&*/ ArgsInfo) {
    TemplateArgsInfo.setLAngleLoc(ArgsInfo.getLAngleLoc());
    TemplateArgsInfo.setRAngleLoc(ArgsInfo.getRAngleLoc());
    for (final /*const*/ TemplateArgumentLoc /*&*/ Loc : ArgsInfo.arguments())  {
      TemplateArgsInfo.addArgument(Loc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getTemplateArgsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2459,
   FQN="clang::VarTemplateSpecializationDecl::getTemplateArgsInfo", NM="_ZNK5clang29VarTemplateSpecializationDecl19getTemplateArgsInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl19getTemplateArgsInfoEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentListInfo /*&*/ getTemplateArgsInfo() /*const*/ {
    return TemplateArgsInfo;
  }

  
  /// \brief Determine the kind of specialization that this
  /// declaration represents.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2465,
   FQN="clang::VarTemplateSpecializationDecl::getSpecializationKind", NM="_ZNK5clang29VarTemplateSpecializationDecl21getSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl21getSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getSpecializationKind() /*const*/ {
    return /*static_cast*/TemplateSpecializationKind.valueOf(SpecializationKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::isExplicitSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2469,
   FQN="clang::VarTemplateSpecializationDecl::isExplicitSpecialization", NM="_ZNK5clang29VarTemplateSpecializationDecl24isExplicitSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl24isExplicitSpecializationEv")
  //</editor-fold>
  public boolean isExplicitSpecialization() /*const*/ {
    return getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization;
  }

  
  /// \brief True if this declaration is an explicit specialization,
  /// explicit instantiation declaration, or explicit instantiation
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::isExplicitInstantiationOrSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2476,
   FQN="clang::VarTemplateSpecializationDecl::isExplicitInstantiationOrSpecialization", NM="_ZNK5clang29VarTemplateSpecializationDecl39isExplicitInstantiationOrSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl39isExplicitInstantiationOrSpecializationEv")
  //</editor-fold>
  public boolean isExplicitInstantiationOrSpecialization() /*const*/ {
    return isTemplateExplicitInstantiationOrSpecialization(getTemplateSpecializationKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2481,
   FQN="clang::VarTemplateSpecializationDecl::setSpecializationKind", NM="_ZN5clang29VarTemplateSpecializationDecl21setSpecializationKindENS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl21setSpecializationKindENS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setSpecializationKind(TemplateSpecializationKind TSK) {
    SpecializationKind = $uint2uint_3bits(TSK.getValue());
  }

  
  /// \brief Get the point of instantiation (if any), or null if none.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2486,
   FQN="clang::VarTemplateSpecializationDecl::getPointOfInstantiation", NM="_ZNK5clang29VarTemplateSpecializationDecl23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    return new SourceLocation(PointOfInstantiation);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2490,
   FQN="clang::VarTemplateSpecializationDecl::setPointOfInstantiation", NM="_ZN5clang29VarTemplateSpecializationDecl23setPointOfInstantiationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl23setPointOfInstantiationENS_14SourceLocationE")
  //</editor-fold>
  public void setPointOfInstantiation(SourceLocation Loc) {
    assert (Loc.isValid()) : "point of instantiation must be valid!";
    PointOfInstantiation.$assign(Loc);
  }

  
  /// \brief If this variable template specialization is an instantiation of
  /// a template (rather than an explicit specialization), return the
  /// variable template or variable template partial specialization from which
  /// it was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getInstantiatedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2499,
   FQN="clang::VarTemplateSpecializationDecl::getInstantiatedFrom", NM="_ZNK5clang29VarTemplateSpecializationDecl19getInstantiatedFromEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl19getInstantiatedFromEv")
  //</editor-fold>
  public PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > getInstantiatedFrom() /*const*/ {
    if (!isTemplateInstantiation(getSpecializationKind())) {
      return new PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >(VarTemplateDecl /*P*/ .class);
    }
    
    return getSpecializedTemplateOrPartial();
  }

  
  /// \brief Retrieve the variable template or variable template partial
  /// specialization which was specialized by this.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getSpecializedTemplateOrPartial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2510,
   FQN="clang::VarTemplateSpecializationDecl::getSpecializedTemplateOrPartial", NM="_ZNK5clang29VarTemplateSpecializationDecl31getSpecializedTemplateOrPartialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl31getSpecializedTemplateOrPartialEv")
  //</editor-fold>
  public PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > getSpecializedTemplateOrPartial() /*const*/ {
    {
      SpecializedPartialSpecialization /*P*/ PartialSpec = SpecializedTemplate.dyn_cast(SpecializedPartialSpecialization /*P*/.class);
      if ((PartialSpec != null)) {
        return new PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >(JD$T1.INSTANCE, VarTemplatePartialSpecializationDecl /*P*/ .class, PartialSpec.PartialSpecialization);
      }
    }
    
    return new PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >(JD$T.INSTANCE, VarTemplateDecl /*P*/ .class, SpecializedTemplate.get(VarTemplateDecl /*P*/.class));
  }

  
  /// \brief Retrieve the set of template arguments that should be used
  /// to instantiate the initializer of the variable template or variable
  /// template partial specialization from which this variable template
  /// specialization was instantiated.
  ///
  /// \returns For a variable template specialization instantiated from the
  /// primary template, this function will return the same template arguments
  /// as getTemplateArgs(). For a variable template specialization instantiated
  /// from a variable template partial specialization, this function will the
  /// return deduced template arguments for the variable template partial
  /// specialization itself.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getTemplateInstantiationArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2530,
   FQN="clang::VarTemplateSpecializationDecl::getTemplateInstantiationArgs", NM="_ZNK5clang29VarTemplateSpecializationDecl28getTemplateInstantiationArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl28getTemplateInstantiationArgsEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentList /*&*/ getTemplateInstantiationArgs() /*const*/ {
    {
      SpecializedPartialSpecialization /*P*/ PartialSpec = SpecializedTemplate.dyn_cast(SpecializedPartialSpecialization /*P*/.class);
      if ((PartialSpec != null)) {
        return $Deref(PartialSpec.TemplateArgs);
      }
    }
    
    return getTemplateArgs();
  }

  
  /// \brief Note that this variable template specialization is actually an
  /// instantiation of the given variable template partial specialization whose
  /// template arguments have been deduced.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setInstantiationOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2541,
   FQN="clang::VarTemplateSpecializationDecl::setInstantiationOf", NM="_ZN5clang29VarTemplateSpecializationDecl18setInstantiationOfEPNS_36VarTemplatePartialSpecializationDeclEPKNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl18setInstantiationOfEPNS_36VarTemplatePartialSpecializationDeclEPKNS_20TemplateArgumentListE")
  //</editor-fold>
  public void setInstantiationOf(VarTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
                    /*const*/ TemplateArgumentList /*P*/ TemplateArgs) {
    assert (!(SpecializedTemplate.is(SpecializedPartialSpecialization /*P*/.class) != 0)) : "Already set to a variable template partial specialization!";
    SpecializedPartialSpecialization /*P*/ PS = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new SpecializedPartialSpecialization();
    PS.PartialSpecialization = PartialSpec;
    PS.TemplateArgs = TemplateArgs;
    SpecializedTemplate.$assign_T1$C$R(SpecializedPartialSpecialization /*P*/.class, PS);
  }

  
  /// \brief Note that this variable template specialization is an instantiation
  /// of the given variable template.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setInstantiationOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2554,
   FQN="clang::VarTemplateSpecializationDecl::setInstantiationOf", NM="_ZN5clang29VarTemplateSpecializationDecl18setInstantiationOfEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl18setInstantiationOfEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public void setInstantiationOf(VarTemplateDecl /*P*/ TemplDecl) {
    assert (!(SpecializedTemplate.is(SpecializedPartialSpecialization /*P*/.class) != 0)) : "Previously set to a variable template partial specialization!";
    SpecializedTemplate.$assign_T$C$R(VarTemplateDecl /*P*/.class, TemplDecl);
  }

  
  /// \brief Sets the type of this specialization as it was written by
  /// the user.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2562,
   FQN="clang::VarTemplateSpecializationDecl::setTypeAsWritten", NM="_ZN5clang29VarTemplateSpecializationDecl16setTypeAsWrittenEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl16setTypeAsWrittenEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeAsWritten(TypeSourceInfo /*P*/ T) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.TypeAsWritten = T;
  }

  /// \brief Gets the type of this specialization as it was written by
  /// the user, if it was so written.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2569,
   FQN="clang::VarTemplateSpecializationDecl::getTypeAsWritten", NM="_ZNK5clang29VarTemplateSpecializationDecl16getTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl16getTypeAsWrittenEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeAsWritten() /*const*/ {
    return (ExplicitInfo != null) ? ExplicitInfo.TypeAsWritten : null;
  }

  
  /// \brief Gets the location of the extern keyword, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2574,
   FQN="clang::VarTemplateSpecializationDecl::getExternLoc", NM="_ZNK5clang29VarTemplateSpecializationDecl12getExternLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl12getExternLocEv")
  //</editor-fold>
  public SourceLocation getExternLoc() /*const*/ {
    return (ExplicitInfo != null) ? new SourceLocation(ExplicitInfo.ExternLoc) : new SourceLocation();
  }

  /// \brief Sets the location of the extern keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2578,
   FQN="clang::VarTemplateSpecializationDecl::setExternLoc", NM="_ZN5clang29VarTemplateSpecializationDecl12setExternLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl12setExternLocENS_14SourceLocationE")
  //</editor-fold>
  public void setExternLoc(SourceLocation Loc) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.ExternLoc.$assign(Loc);
  }

  
  /// \brief Sets the location of the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::setTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2585,
   FQN="clang::VarTemplateSpecializationDecl::setTemplateKeywordLoc", NM="_ZN5clang29VarTemplateSpecializationDecl21setTemplateKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl21setTemplateKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateKeywordLoc(SourceLocation Loc) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.TemplateKeywordLoc.$assign(Loc);
  }

  /// \brief Gets the location of the template keyword, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2591,
   FQN="clang::VarTemplateSpecializationDecl::getTemplateKeywordLoc", NM="_ZNK5clang29VarTemplateSpecializationDecl21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    return (ExplicitInfo != null) ? new SourceLocation(ExplicitInfo.TemplateKeywordLoc) : new SourceLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2595,
   FQN="clang::VarTemplateSpecializationDecl::Profile", NM="_ZNK5clang29VarTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang29VarTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, TemplateArgs.asArray(), getASTContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2599,
   FQN="clang::VarTemplateSpecializationDecl::Profile", NM="_ZN5clang29VarTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         ArrayRef<TemplateArgument> TemplateArgs, 
         final ASTContext /*&*/ Context) {
    ID.AddInteger_uint(TemplateArgs.size());
    for (final /*const*/ TemplateArgument /*&*/ TemplateArg : TemplateArgs)  {
      TemplateArg.Profile(ID, Context);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2607,
   FQN="clang::VarTemplateSpecializationDecl::classof", NM="_ZN5clang29VarTemplateSpecializationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2608,
   FQN="clang::VarTemplateSpecializationDecl::classofKind", NM="_ZN5clang29VarTemplateSpecializationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstVarTemplateSpecialization.getValue()
       && K.getValue() <= Kind.lastVarTemplateSpecialization.getValue();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateSpecializationDecl::~VarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2374,
   FQN="clang::VarTemplateSpecializationDecl::~VarTemplateSpecializationDecl", NM="_ZN5clang29VarTemplateSpecializationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang29VarTemplateSpecializationDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TemplateArgsInfo.$destroy();
    super.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SpecializedTemplate=" + SpecializedTemplate // NOI18N
              + ", ExplicitInfo=" + ExplicitInfo // NOI18N
              + ", TemplateArgs=" + TemplateArgs // NOI18N
              + ", TemplateArgsInfo=" + TemplateArgsInfo // NOI18N
              + ", PointOfInstantiation=" + PointOfInstantiation // NOI18N
              + ", SpecializationKind=" + $uchar2uint(SpecializationKind) // NOI18N
              + super.toString(); // NOI18N
  }
}
