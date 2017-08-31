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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Provides information about a function template specialization,
/// which is a FunctionDecl that has been explicitly specialization or
/// instantiated from a function template.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 399,
 FQN="clang::FunctionTemplateSpecializationInfo", NM="_ZN5clang34FunctionTemplateSpecializationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfoE")
//</editor-fold>
public class FunctionTemplateSpecializationInfo extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, FoldingSetTrait.Profilable {
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::FunctionTemplateSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 400,
   FQN="clang::FunctionTemplateSpecializationInfo::FunctionTemplateSpecializationInfo", NM="_ZN5clang34FunctionTemplateSpecializationInfoC1EPNS_12FunctionDeclEPNS_20FunctionTemplateDeclENS_26TemplateSpecializationKindEPKNS_20TemplateArgumentListEPKNS_27ASTTemplateArgumentListInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfoC1EPNS_12FunctionDeclEPNS_20FunctionTemplateDeclENS_26TemplateSpecializationKindEPKNS_20TemplateArgumentListEPKNS_27ASTTemplateArgumentListInfoENS_14SourceLocationE")
  //</editor-fold>
  private FunctionTemplateSpecializationInfo(FunctionDecl /*P*/ FD, 
      FunctionTemplateDecl /*P*/ Template, 
      TemplateSpecializationKind TSK, 
      /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
      /*const*/ ASTTemplateArgumentListInfo /*P*/ TemplateArgsAsWritten, 
      SourceLocation POI) {
    // : FoldingSetNode(), Function(FD), Template(Template, TSK - 1), TemplateArguments(TemplateArgs), TemplateArgumentsAsWritten(TemplateArgsAsWritten), PointOfInstantiation(POI) 
    //START JInit
    $Node();
    this.Function = FD;
    this.Template = new PointerIntPair<FunctionTemplateDecl /*P*/ >(Template, TSK.getValue() - 1);
    this.TemplateArguments = TemplateArgs;
    this.TemplateArgumentsAsWritten = TemplateArgsAsWritten;
    this.PointOfInstantiation = new SourceLocation(POI);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 677,
   FQN="clang::FunctionTemplateSpecializationInfo::Create", NM="_ZN5clang34FunctionTemplateSpecializationInfo6CreateERNS_10ASTContextEPNS_12FunctionDeclEPNS_20FunctionTemplateDeclENS_26TemplateSpecializationKindEPKNS_20TemplateArgumentListEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfo6CreateERNS_10ASTContextEPNS_12FunctionDeclEPNS_20FunctionTemplateDeclENS_26TemplateSpecializationKindEPKNS_20TemplateArgumentListEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE")
  //</editor-fold>
  public static FunctionTemplateSpecializationInfo /*P*/ Create(final ASTContext /*&*/ C, FunctionDecl /*P*/ FD, 
        FunctionTemplateDecl /*P*/ Template, 
        TemplateSpecializationKind TSK, 
        /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgsAsWritten, 
        SourceLocation POI) {
    /*const*/ ASTTemplateArgumentListInfo /*P*/ ArgsAsWritten = null;
    if ((TemplateArgsAsWritten != null)) {
      ArgsAsWritten = ASTTemplateArgumentListInfo.Create(C, 
          $Deref(TemplateArgsAsWritten));
    }
    
    return /*FIXME:NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (C)*/ new FunctionTemplateSpecializationInfo(FD, Template, TSK, 
        TemplateArgs, 
        ArgsAsWritten, 
        new SourceLocation(POI));
  }

  
  /// \brief The function template specialization that this structure
  /// describes.
  public FunctionDecl /*P*/ Function;
  
  /// \brief The function template from which this function template
  /// specialization was generated.
  ///
  /// The two bits contain the top 4 values of TemplateSpecializationKind.
  public PointerIntPair<FunctionTemplateDecl /*P*/ > Template;
  
  /// \brief The template arguments used to produce the function template
  /// specialization from the function template.
  public /*const*/ TemplateArgumentList /*P*/ TemplateArguments;
  
  /// \brief The template arguments as written in the sources, if provided.
  public /*const*/ ASTTemplateArgumentListInfo /*P*/ TemplateArgumentsAsWritten;
  
  /// \brief The point at which this function template specialization was
  /// first instantiated.
  public SourceLocation PointOfInstantiation;
  
  /// \brief Retrieve the template from which this function was specialized.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::getTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 442,
   FQN="clang::FunctionTemplateSpecializationInfo::getTemplate", NM="_ZNK5clang34FunctionTemplateSpecializationInfo11getTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang34FunctionTemplateSpecializationInfo11getTemplateEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getTemplate() /*const*/ {
    return Template.getPointer();
  }

  
  /// \brief Determine what kind of template specialization this is.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 445,
   FQN="clang::FunctionTemplateSpecializationInfo::getTemplateSpecializationKind", NM="_ZNK5clang34FunctionTemplateSpecializationInfo29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang34FunctionTemplateSpecializationInfo29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    return TemplateSpecializationKind.valueOf((Template.getInt() + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::isExplicitSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 449,
   FQN="clang::FunctionTemplateSpecializationInfo::isExplicitSpecialization", NM="_ZNK5clang34FunctionTemplateSpecializationInfo24isExplicitSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang34FunctionTemplateSpecializationInfo24isExplicitSpecializationEv")
  //</editor-fold>
  public boolean isExplicitSpecialization() /*const*/ {
    return getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization;
  }

  
  /// \brief True if this declaration is an explicit specialization,
  /// explicit instantiation declaration, or explicit instantiation
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::isExplicitInstantiationOrSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 456,
   FQN="clang::FunctionTemplateSpecializationInfo::isExplicitInstantiationOrSpecialization", NM="_ZNK5clang34FunctionTemplateSpecializationInfo39isExplicitInstantiationOrSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang34FunctionTemplateSpecializationInfo39isExplicitInstantiationOrSpecializationEv")
  //</editor-fold>
  public boolean isExplicitInstantiationOrSpecialization() /*const*/ {
    return isTemplateExplicitInstantiationOrSpecialization(getTemplateSpecializationKind());
  }

  
  /// \brief Set the template specialization kind.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 462,
   FQN="clang::FunctionTemplateSpecializationInfo::setTemplateSpecializationKind", NM="_ZN5clang34FunctionTemplateSpecializationInfo29setTemplateSpecializationKindENS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfo29setTemplateSpecializationKindENS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    assert (TSK != TemplateSpecializationKind.TSK_Undeclared) : "Cannot encode TSK_Undeclared for a function template specialization";
    Template.setInt(TSK.getValue() - 1);
  }

  
  /// \brief Retrieve the first point of instantiation of this function
  /// template specialization.
  ///
  /// The point of instantiation may be an invalid source location if this
  /// function has yet to be instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 473,
   FQN="clang::FunctionTemplateSpecializationInfo::getPointOfInstantiation", NM="_ZNK5clang34FunctionTemplateSpecializationInfo23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang34FunctionTemplateSpecializationInfo23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    return new SourceLocation(PointOfInstantiation);
  }

  
  /// \brief Set the (first) point of instantiation of this function template
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::setPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 479,
   FQN="clang::FunctionTemplateSpecializationInfo::setPointOfInstantiation", NM="_ZN5clang34FunctionTemplateSpecializationInfo23setPointOfInstantiationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfo23setPointOfInstantiationENS_14SourceLocationE")
  //</editor-fold>
  public void setPointOfInstantiation(SourceLocation POI) {
    PointOfInstantiation.$assign(POI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 483,
   FQN="clang::FunctionTemplateSpecializationInfo::Profile", NM="_ZN5clang34FunctionTemplateSpecializationInfo7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfo7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, TemplateArguments.asArray(), 
        Function.getASTContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateSpecializationInfo::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 488,
   FQN="clang::FunctionTemplateSpecializationInfo::Profile", NM="_ZN5clang34FunctionTemplateSpecializationInfo7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang34FunctionTemplateSpecializationInfo7ProfileERN4llvm16FoldingSetNodeIDENS1_8ArrayRefINS_16TemplateArgumentEEERNS_10ASTContextE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, ArrayRef<TemplateArgument> TemplateArgs, 
         final ASTContext /*&*/ Context) {
    ID.AddInteger_uint(TemplateArgs.size());
    for (final /*const*/ TemplateArgument /*&*/ TemplateArg : TemplateArgs)  {
      TemplateArg.Profile(ID, Context);
    }
  }

  
  @Override public String toString() {
    return "" + "Function=" + Function // NOI18N
              + ", Template=" + Template // NOI18N
              + ", TemplateArguments=" + TemplateArguments // NOI18N
              + ", TemplateArgumentsAsWritten=" + TemplateArgumentsAsWritten // NOI18N
              + ", PointOfInstantiation=" + PointOfInstantiation // NOI18N
              + super.toString(); // NOI18N
  }
}
