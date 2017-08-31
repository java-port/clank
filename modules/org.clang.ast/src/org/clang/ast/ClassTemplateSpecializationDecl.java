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
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Represents a class template specialization, which refers to
/// a class template with a given set of template arguments.
///
/// Class template specializations represent both explicit
/// specialization of class templates, as in the example below, and
/// implicit instantiations of class templates.
///
/// \code
/// template<typename T> class array;
///
/// template<>
/// class array<bool> { }; // class template specialization array<bool>
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1529,
 FQN="clang::ClassTemplateSpecializationDecl", NM="_ZN5clang31ClassTemplateSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDeclE")
//</editor-fold>
public class ClassTemplateSpecializationDecl extends /*public*/ CXXRecordDecl implements /*public*/ FoldingSetImpl.Node, 
        HasGetTemplateArgs$TemplateArgumentList, HasGetSpecializedTemplate<ClassTemplateDecl>, Destructors.ClassWithDestructor {
  
  /// \brief Structure that stores information about a class template
  /// specialization that was instantiated from a class template partial
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::SpecializedPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1535,
   FQN="clang::ClassTemplateSpecializationDecl::SpecializedPartialSpecialization", NM="_ZN5clang31ClassTemplateSpecializationDecl32SpecializedPartialSpecializationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl32SpecializedPartialSpecializationE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ SpecializedPartialSpecialization {
    /// \brief The class template partial specialization from which this
    /// class template specialization was instantiated.
    public ClassTemplatePartialSpecializationDecl /*P*/ PartialSpecialization;
    
    /// \brief The template argument list deduced for the class template
    /// partial specialization itself.
    public /*const*/ TemplateArgumentList /*P*/ TemplateArgs;
    
    @Override public String toString() {
      return "" + "PartialSpecialization=" + PartialSpecialization // NOI18N
                + ", TemplateArgs=" + TemplateArgs; // NOI18N
    }
  };
  
  /// \brief The template that this specialization specializes
  /*friend*/public PointerUnion<ClassTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ > SpecializedTemplate;
  
  /// \brief Further info for explicit template specialization/instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::ExplicitSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1550,
   FQN="clang::ClassTemplateSpecializationDecl::ExplicitSpecializationInfo", NM="_ZN5clang31ClassTemplateSpecializationDecl26ExplicitSpecializationInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl26ExplicitSpecializationInfoE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ ExplicitSpecializationInfo {
    /// \brief The type-as-written.
    public TypeSourceInfo /*P*/ TypeAsWritten;
    /// \brief The location of the extern keyword.
    public SourceLocation ExternLoc;
    /// \brief The location of the template keyword.
    public SourceLocation TemplateKeywordLoc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::ExplicitSpecializationInfo::ExplicitSpecializationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1558,
     FQN="clang::ClassTemplateSpecializationDecl::ExplicitSpecializationInfo::ExplicitSpecializationInfo", NM="_ZN5clang31ClassTemplateSpecializationDecl26ExplicitSpecializationInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl26ExplicitSpecializationInfoC1Ev")
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
  
  /// \brief The point where this template was instantiated (if any)
  /*friend*/public SourceLocation PointOfInstantiation;
  
  /// \brief The kind of specialization this declaration refers to.
  /// Really a value of type TemplateSpecializationKind.
  /*friend*/public /*JBYTE unsigned int*/ byte SpecializationKind /*: 3*/;
/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // ClassTemplateSpecializationDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::ClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 704,
   FQN="clang::ClassTemplateSpecializationDecl::ClassTemplateSpecializationDecl", NM="_ZN5clang31ClassTemplateSpecializationDeclC1ERNS_10ASTContextENS_4Decl4KindENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES8_PNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDeclC1ERNS_10ASTContextENS_4Decl4KindENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES8_PNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPS0_")
  //</editor-fold>
  protected ClassTemplateSpecializationDecl(final ASTContext /*&*/ Context, Kind DK, TagTypeKind TK, 
      DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, 
      ClassTemplateDecl /*P*/ SpecializedTemplate, 
      ArrayRef<TemplateArgument> Args, 
      ClassTemplateSpecializationDecl /*P*/ PrevDecl) {
    // : CXXRecordDecl(DK, TK, Context, DC, StartLoc, IdLoc, SpecializedTemplate->getIdentifier(), PrevDecl), FoldingSetNode(), SpecializedTemplate(SpecializedTemplate), ExplicitInfo(null), TemplateArgs(TemplateArgumentList::CreateCopy(Context, Args)), PointOfInstantiation(), SpecializationKind(TSK_Undeclared) 
    //START JInit
    super(DK, TK, Context, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
        SpecializedTemplate.getIdentifier(), 
        PrevDecl);
    $Node();
    this.SpecializedTemplate = new PointerUnion<ClassTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ >(JD$T.INSTANCE, ClassTemplateDecl /*P*/ .class, SpecializedTemplate);
    this.ExplicitInfo = null;
    this.TemplateArgs = TemplateArgumentList.CreateCopy(Context, new ArrayRef<TemplateArgument>(Args));
    this.PointOfInstantiation = new SourceLocation();
    this.SpecializationKind = $uint2uint_3bits(TemplateSpecializationKind.TSK_Undeclared.getValue());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::ClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 720,
   FQN="clang::ClassTemplateSpecializationDecl::ClassTemplateSpecializationDecl", NM="_ZN5clang31ClassTemplateSpecializationDeclC1ERNS_10ASTContextENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDeclC1ERNS_10ASTContextENS_4Decl4KindE")
  //</editor-fold>
  protected ClassTemplateSpecializationDecl(final ASTContext /*&*/ C, 
      Kind DK) {
    // : CXXRecordDecl(DK, TTK_Struct, C, null, SourceLocation(), SourceLocation(), null, null), FoldingSetNode(), SpecializedTemplate(), ExplicitInfo(null), PointOfInstantiation(), SpecializationKind(TSK_Undeclared) 
    //START JInit
    super(DK, TagTypeKind.TTK_Struct, C, (DeclContext /*P*/ )null, new SourceLocation(), 
        new SourceLocation(), (IdentifierInfo /*P*/ )null, (CXXRecordDecl /*P*/ )null);
    $Node();
    this.SpecializedTemplate = new PointerUnion<ClassTemplateDecl /*P*/ , SpecializedPartialSpecialization /*P*/ >(ClassTemplateDecl /*P*/ .class);
    this.ExplicitInfo = null;
    this.PointOfInstantiation = new SourceLocation();
    this.SpecializationKind = $uint2uint_3bits(TemplateSpecializationKind.TSK_Undeclared.getValue());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 726,
   FQN="clang::ClassTemplateSpecializationDecl::Create", NM="_ZN5clang31ClassTemplateSpecializationDecl6CreateERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl6CreateERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPS0_")
  //</editor-fold>
  public static ClassTemplateSpecializationDecl /*P*/ Create(final ASTContext /*&*/ Context, TagTypeKind TK, 
        DeclContext /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, 
        ClassTemplateDecl /*P*/ SpecializedTemplate, 
        ArrayRef<TemplateArgument> Args, 
        ClassTemplateSpecializationDecl /*P*/ PrevDecl) {
    ClassTemplateSpecializationDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (Context, DC)*/ Decl.$new(Context, DC, (type$ptr<?> Mem)->{
        return new ClassTemplateSpecializationDecl(Context, Kind.ClassTemplateSpecialization, TK, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
                SpecializedTemplate, new ArrayRef<TemplateArgument>(Args), PrevDecl);
     });
    Result.MayHaveOutOfDateDef = false;
    
    Context.getTypeDeclType(Result, PrevDecl);
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 744,
   FQN="clang::ClassTemplateSpecializationDecl::CreateDeserialized", NM="_ZN5clang31ClassTemplateSpecializationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ClassTemplateSpecializationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    ClassTemplateSpecializationDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ClassTemplateSpecializationDecl(C, Kind.ClassTemplateSpecialization);
     });
    Result.MayHaveOutOfDateDef = false;
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getNameForDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 753,
   FQN="clang::ClassTemplateSpecializationDecl::getNameForDiagnostic", NM="_ZNK5clang31ClassTemplateSpecializationDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  @Override public void getNameForDiagnostic(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, boolean Qualified) /*const*//* override*/ {
    super.getNameForDiagnostic(OS, Policy, Qualified);
    
    final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = getTemplateArgs();
    TemplateSpecializationType.PrintTemplateArgumentList1(OS, TemplateArgs.asArray(), Policy);
  }

  
  // FIXME: This is broken. CXXRecordDecl::getMostRecentDecl() returns a
  // different "most recent" declaration from this function for the same
  // declaration, because we don't override getMostRecentDeclImpl(). But
  // it's not clear that we should override that, because the most recent
  // declaration as a CXXRecordDecl sometimes is the injected-class-name.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1604,
   FQN="clang::ClassTemplateSpecializationDecl::getMostRecentDecl", NM="_ZN5clang31ClassTemplateSpecializationDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl17getMostRecentDeclEv")
  //</editor-fold>
  public ClassTemplateSpecializationDecl /*P*/ getMostRecentDecl() {
    CXXRecordDecl /*P*/ Recent = /*JCast:CXXRecordDecl * */super.getMostRecentDecl();
    while (!isa_ClassTemplateSpecializationDecl(Recent)) {
      // FIXME: Does injected class name need to be in the redeclarations chain?
      assert (Recent.isInjectedClassName() && (Recent.getPreviousDecl() != null));
      Recent = Recent.getPreviousDecl();
    }
    return cast_ClassTemplateSpecializationDecl(Recent);
  }

  
  /// \brief Retrieve the template that this specialization specializes.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getSpecializedTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 762,
   FQN="clang::ClassTemplateSpecializationDecl::getSpecializedTemplate", NM="_ZNK5clang31ClassTemplateSpecializationDecl22getSpecializedTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl22getSpecializedTemplateEv")
  //</editor-fold>
  public ClassTemplateDecl /*P*/ getSpecializedTemplate() /*const*/ {
    {
      SpecializedPartialSpecialization /*P*/ PartialSpec = SpecializedTemplate.dyn_cast(SpecializedPartialSpecialization /*P*/.class);
      if ((PartialSpec != null)) {
        return PartialSpec.PartialSpecialization.getSpecializedTemplate();
      }
    }
    return SpecializedTemplate.get(ClassTemplateDecl /*P*/.class);
  }

  
  /// \brief Retrieve the template arguments of the class template
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1620,
   FQN="clang::ClassTemplateSpecializationDecl::getTemplateArgs", NM="_ZNK5clang31ClassTemplateSpecializationDecl15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentList /*&*/ getTemplateArgs() /*const*/ {
    return $Deref(TemplateArgs);
  }

  
  /// \brief Determine the kind of specialization that this
  /// declaration represents.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1626,
   FQN="clang::ClassTemplateSpecializationDecl::getSpecializationKind", NM="_ZNK5clang31ClassTemplateSpecializationDecl21getSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl21getSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getSpecializationKind() /*const*/ {
    return /*static_cast*/TemplateSpecializationKind.valueOf(SpecializationKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::isExplicitSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1630,
   FQN="clang::ClassTemplateSpecializationDecl::isExplicitSpecialization", NM="_ZNK5clang31ClassTemplateSpecializationDecl24isExplicitSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl24isExplicitSpecializationEv")
  //</editor-fold>
  public boolean isExplicitSpecialization() /*const*/ {
    return getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization;
  }

  
  /// \brief True if this declaration is an explicit specialization,
  /// explicit instantiation declaration, or explicit instantiation
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::isExplicitInstantiationOrSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1637,
   FQN="clang::ClassTemplateSpecializationDecl::isExplicitInstantiationOrSpecialization", NM="_ZNK5clang31ClassTemplateSpecializationDecl39isExplicitInstantiationOrSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl39isExplicitInstantiationOrSpecializationEv")
  //</editor-fold>
  public boolean isExplicitInstantiationOrSpecialization() /*const*/ {
    return isTemplateExplicitInstantiationOrSpecialization(getTemplateSpecializationKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1642,
   FQN="clang::ClassTemplateSpecializationDecl::setSpecializationKind", NM="_ZN5clang31ClassTemplateSpecializationDecl21setSpecializationKindENS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl21setSpecializationKindENS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setSpecializationKind(TemplateSpecializationKind TSK) {
    SpecializationKind = $uint2uint_3bits(TSK.getValue());
  }

  
  /// \brief Get the point of instantiation (if any), or null if none.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1647,
   FQN="clang::ClassTemplateSpecializationDecl::getPointOfInstantiation", NM="_ZNK5clang31ClassTemplateSpecializationDecl23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    return new SourceLocation(PointOfInstantiation);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1651,
   FQN="clang::ClassTemplateSpecializationDecl::setPointOfInstantiation", NM="_ZN5clang31ClassTemplateSpecializationDecl23setPointOfInstantiationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl23setPointOfInstantiationENS_14SourceLocationE")
  //</editor-fold>
  public void setPointOfInstantiation(SourceLocation Loc) {
    assert (Loc.isValid()) : "point of instantiation must be valid!";
    PointOfInstantiation.$assign(Loc);
  }

  
  /// \brief If this class template specialization is an instantiation of
  /// a template (rather than an explicit specialization), return the
  /// class template or class template partial specialization from which it
  /// was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getInstantiatedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1660,
   FQN="clang::ClassTemplateSpecializationDecl::getInstantiatedFrom", NM="_ZNK5clang31ClassTemplateSpecializationDecl19getInstantiatedFromEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl19getInstantiatedFromEv")
  //</editor-fold>
  public PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > getInstantiatedFrom() /*const*/ {
    if (!isTemplateInstantiation(getSpecializationKind())) {
      return new PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >(ClassTemplateDecl /*P*/ .class);
    }
    
    return getSpecializedTemplateOrPartial();
  }

  
  /// \brief Retrieve the class template or class template partial
  /// specialization which was specialized by this.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getSpecializedTemplateOrPartial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1672,
   FQN="clang::ClassTemplateSpecializationDecl::getSpecializedTemplateOrPartial", NM="_ZNK5clang31ClassTemplateSpecializationDecl31getSpecializedTemplateOrPartialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl31getSpecializedTemplateOrPartialEv")
  //</editor-fold>
  public PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > getSpecializedTemplateOrPartial() /*const*/ {
    {
      SpecializedPartialSpecialization /*P*/ PartialSpec = SpecializedTemplate.dyn_cast(SpecializedPartialSpecialization /*P*/.class);
      if ((PartialSpec != null)) {
        return new PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >(JD$T1.INSTANCE, ClassTemplatePartialSpecializationDecl /*P*/ .class, PartialSpec.PartialSpecialization);
      }
    }
    
    return new PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >(JD$T.INSTANCE, ClassTemplateDecl /*P*/ .class, SpecializedTemplate.get(ClassTemplateDecl /*P*/.class));
  }

  
  /// \brief Retrieve the set of template arguments that should be used
  /// to instantiate members of the class template or class template partial
  /// specialization from which this class template specialization was
  /// instantiated.
  ///
  /// \returns For a class template specialization instantiated from the primary
  /// template, this function will return the same template arguments as
  /// getTemplateArgs(). For a class template specialization instantiated from
  /// a class template partial specialization, this function will return the
  /// deduced template arguments for the class template partial specialization
  /// itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getTemplateInstantiationArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1693,
   FQN="clang::ClassTemplateSpecializationDecl::getTemplateInstantiationArgs", NM="_ZNK5clang31ClassTemplateSpecializationDecl28getTemplateInstantiationArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl28getTemplateInstantiationArgsEv")
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

  
  /// \brief Note that this class template specialization is actually an
  /// instantiation of the given class template partial specialization whose
  /// template arguments have been deduced.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setInstantiationOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1704,
   FQN="clang::ClassTemplateSpecializationDecl::setInstantiationOf", NM="_ZN5clang31ClassTemplateSpecializationDecl18setInstantiationOfEPNS_38ClassTemplatePartialSpecializationDeclEPKNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl18setInstantiationOfEPNS_38ClassTemplatePartialSpecializationDeclEPKNS_20TemplateArgumentListE")
  //</editor-fold>
  public void setInstantiationOf(ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec, 
                    /*const*/ TemplateArgumentList /*P*/ TemplateArgs) {
    assert (!(SpecializedTemplate.is(SpecializedPartialSpecialization /*P*/.class) != 0)) : "Already set to a class template partial specialization!";
    SpecializedPartialSpecialization /*P*/ PS = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new SpecializedPartialSpecialization();
    PS.PartialSpecialization = PartialSpec;
    PS.TemplateArgs = TemplateArgs;
    SpecializedTemplate.$assign_T1$C$R(SpecializedPartialSpecialization /*P*/.class, PS);
  }

  
  /// \brief Note that this class template specialization is an instantiation
  /// of the given class template.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setInstantiationOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1717,
   FQN="clang::ClassTemplateSpecializationDecl::setInstantiationOf", NM="_ZN5clang31ClassTemplateSpecializationDecl18setInstantiationOfEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl18setInstantiationOfEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public void setInstantiationOf(ClassTemplateDecl /*P*/ TemplDecl) {
    assert (!(SpecializedTemplate.is(SpecializedPartialSpecialization /*P*/.class) != 0)) : "Previously set to a class template partial specialization!";
    SpecializedTemplate.$assign_T$C$R(ClassTemplateDecl /*P*/.class, TemplDecl);
  }

  
  /// \brief Sets the type of this specialization as it was written by
  /// the user. This will be a class template specialization type.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1725,
   FQN="clang::ClassTemplateSpecializationDecl::setTypeAsWritten", NM="_ZN5clang31ClassTemplateSpecializationDecl16setTypeAsWrittenEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl16setTypeAsWrittenEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeAsWritten(TypeSourceInfo /*P*/ T) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.TypeAsWritten = T;
  }

  /// \brief Gets the type of this specialization as it was written by
  /// the user, if it was so written.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1732,
   FQN="clang::ClassTemplateSpecializationDecl::getTypeAsWritten", NM="_ZNK5clang31ClassTemplateSpecializationDecl16getTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl16getTypeAsWrittenEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeAsWritten() /*const*/ {
    return (ExplicitInfo != null) ? ExplicitInfo.TypeAsWritten : null;
  }

  
  /// \brief Gets the location of the extern keyword, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1737,
   FQN="clang::ClassTemplateSpecializationDecl::getExternLoc", NM="_ZNK5clang31ClassTemplateSpecializationDecl12getExternLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl12getExternLocEv")
  //</editor-fold>
  public SourceLocation getExternLoc() /*const*/ {
    return (ExplicitInfo != null) ? new SourceLocation(ExplicitInfo.ExternLoc) : new SourceLocation();
  }

  /// \brief Sets the location of the extern keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1741,
   FQN="clang::ClassTemplateSpecializationDecl::setExternLoc", NM="_ZN5clang31ClassTemplateSpecializationDecl12setExternLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl12setExternLocENS_14SourceLocationE")
  //</editor-fold>
  public void setExternLoc(SourceLocation Loc) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.ExternLoc.$assign(Loc);
  }

  
  /// \brief Sets the location of the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::setTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1748,
   FQN="clang::ClassTemplateSpecializationDecl::setTemplateKeywordLoc", NM="_ZN5clang31ClassTemplateSpecializationDecl21setTemplateKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl21setTemplateKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateKeywordLoc(SourceLocation Loc) {
    if (!(ExplicitInfo != null)) {
      ExplicitInfo = /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExplicitSpecializationInfo();
    }
    ExplicitInfo.TemplateKeywordLoc.$assign(Loc);
  }

  /// \brief Gets the location of the template keyword, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1754,
   FQN="clang::ClassTemplateSpecializationDecl::getTemplateKeywordLoc", NM="_ZNK5clang31ClassTemplateSpecializationDecl21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    return (ExplicitInfo != null) ? new SourceLocation(ExplicitInfo.TemplateKeywordLoc) : new SourceLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 770,
   FQN="clang::ClassTemplateSpecializationDecl::getSourceRange", NM="_ZNK5clang31ClassTemplateSpecializationDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if ((ExplicitInfo != null)) {
      SourceLocation Begin = getTemplateKeywordLoc();
      if (Begin.isValid()) {
        // Here we have an explicit (partial) specialization or instantiation.
        assert (getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization || getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration || getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition);
        if (getExternLoc().isValid()) {
          Begin.$assignMove(getExternLoc());
        }
        SourceLocation End = getBraceRange().getEnd();
        if (End.isInvalid()) {
          End.$assignMove(getTypeAsWritten().getTypeLoc().getEndLoc());
        }
        return new SourceRange(/*NO_COPY*/Begin, /*NO_COPY*/End);
      }
      // An implicit instantiation of a class template partial specialization
      // uses ExplicitInfo to record the TypeAsWritten, but the source
      // locations should be retrieved from the instantiation pattern.
      /*typedef ClassTemplatePartialSpecializationDecl CTPSDecl*/
//      final class CTPSDecl extends ClassTemplatePartialSpecializationDecl{ };
      ClassTemplatePartialSpecializationDecl /*P*/ ctpsd = ((/*const_cast*/ClassTemplatePartialSpecializationDecl /*P*/ )(cast_ClassTemplatePartialSpecializationDecl(this)));
      ClassTemplatePartialSpecializationDecl /*P*/ inst_from = ctpsd.getInstantiatedFromMember();
      assert (inst_from != null);
      return inst_from.getSourceRange();
    } else {
      // No explicit info available.
      PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > inst_from = getInstantiatedFrom();
      if (inst_from.isNull()) {
        return getSpecializedTemplate().getSourceRange();
      }
      {
        ClassTemplateDecl /*P*/ ctd = inst_from.dyn_cast(ClassTemplateDecl /*P*/.class);
        if ((ctd != null)) {
          return ctd.getSourceRange();
        }
      }
      return inst_from.get(ClassTemplatePartialSpecializationDecl /*P*/.class).
          getSourceRange();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1760,
   FQN="clang::ClassTemplateSpecializationDecl::Profile", NM="_ZNK5clang31ClassTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang31ClassTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, TemplateArgs.asArray(), getASTContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1764,
   FQN="clang::ClassTemplateSpecializationDecl::Profile", NM="_ZN5clang31ClassTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, ArrayRef<TemplateArgument> TemplateArgs, 
         final ASTContext /*&*/ Context) {
    ID.AddInteger_uint(TemplateArgs.size());
    for (final /*const*/ TemplateArgument /*&*/ TemplateArg : TemplateArgs)  {
      TemplateArg.Profile(ID, Context);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1772,
   FQN="clang::ClassTemplateSpecializationDecl::classof", NM="_ZN5clang31ClassTemplateSpecializationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1773,
   FQN="clang::ClassTemplateSpecializationDecl::classofKind", NM="_ZN5clang31ClassTemplateSpecializationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstClassTemplateSpecialization.getValue()
       && K.getValue() <= Kind.lastClassTemplateSpecialization.getValue();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateSpecializationDecl::~ClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1529,
   FQN="clang::ClassTemplateSpecializationDecl::~ClassTemplateSpecializationDecl", NM="_ZN5clang31ClassTemplateSpecializationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang31ClassTemplateSpecializationDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  @Override public String toString() {
    return "" + "SpecializedTemplate=" + SpecializedTemplate // NOI18N
              + ", ExplicitInfo=" + ExplicitInfo // NOI18N
              + ", TemplateArgs=" + TemplateArgs // NOI18N
              + ", PointOfInstantiation=" + PointOfInstantiation // NOI18N
              + ", SpecializationKind=" + $uchar2uint(SpecializationKind) // NOI18N
              + super.toString(); // NOI18N
  }
}
