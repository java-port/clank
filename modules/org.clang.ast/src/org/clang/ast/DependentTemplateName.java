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
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents a dependent template name that cannot be
/// resolved prior to template instantiation.
///
/// This kind of template name refers to a dependent template name,
/// including its nested name specifier (if any). For example,
/// DependentTemplateName can refer to "MetaFun::template apply",
/// where "MetaFun::" is the nested name specifier and "apply" is the
/// template name referenced. The "template" keyword is implied.
//<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 412,
 FQN="clang::DependentTemplateName", NM="_ZN5clang21DependentTemplateNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameE")
//</editor-fold>
public class DependentTemplateName extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {

  /// \brief The nested name specifier that qualifies the template
  /// name.
  ///
  /// The bit stored in this qualifier describes whether the \c Name field
  /// is interpreted as an IdentifierInfo pointer (when clear) or as an
  /// overloaded operator kind (when set).
  private PointerBoolPair<NestedNameSpecifier /*P*/ > Qualifier;
  
  /// \brief The dependent template name.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 422,
   FQN="clang::DependentTemplateName::(anonymous)", NM="_ZN5clang21DependentTemplateNameE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    /// \brief The identifier template name.
    ///
    /// Only valid when the bit on \c Qualifier is clear.
    public /*const*/ IdentifierInfo /*P*/ Identifier;
    
    /// \brief The overloaded operator name.
    ///
    /// Only valid when the bit on \c Qualifier is set.
    public OverloadedOperatorKind Operator = OverloadedOperatorKind.OO_None;
    
    @Override public String toString() {
      return "" + "Identifier=" + Identifier // NOI18N
                + ", Operator=" + Operator; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
  
  /// \brief The canonical template name to which this dependent
  /// template name refers.
  ///
  /// The canonical template name for a dependent template name is
  /// another dependent template name whose nested name specifier is
  /// canonical.
  /*friend*/protected/*private*/ TemplateName CanonicalTemplateName;
  
  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::DependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 444,
   FQN="clang::DependentTemplateName::DependentTemplateName", NM="_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE")
  //</editor-fold>
  /*friend*//*package*/ DependentTemplateName(NestedNameSpecifier /*P*/ Qualifier, 
      /*const*/ IdentifierInfo /*P*/ Identifier) {
    // : FoldingSetNode(), Qualifier(Qualifier, false), Identifier(Identifier), CanonicalTemplateName(this) 
    //START JInit
    $Node();
    this.Qualifier = new PointerBoolPair<NestedNameSpecifier /*P*/ >(Qualifier, false);
    /*Indirect*/this.Unnamed_field1.Identifier = Identifier;
    this.CanonicalTemplateName = new TemplateName(this);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::DependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 449,
   FQN="clang::DependentTemplateName::DependentTemplateName", NM="_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_12TemplateNameE")
  //</editor-fold>
  /*friend*//*package*/ DependentTemplateName(NestedNameSpecifier /*P*/ Qualifier, 
      /*const*/ IdentifierInfo /*P*/ Identifier, 
      TemplateName Canon) {
    // : FoldingSetNode(), Qualifier(Qualifier, false), Identifier(Identifier), CanonicalTemplateName(Canon) 
    //START JInit
    $Node();
    this.Qualifier = new PointerBoolPair<NestedNameSpecifier /*P*/ >(Qualifier, false);
    /*Indirect*/this.Unnamed_field1.Identifier = Identifier;
    this.CanonicalTemplateName = new TemplateName(Canon);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::DependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 455,
   FQN="clang::DependentTemplateName::DependentTemplateName", NM="_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE")
  //</editor-fold>
  /*friend*//*package*/ DependentTemplateName(NestedNameSpecifier /*P*/ Qualifier, 
      OverloadedOperatorKind Operator) {
    // : FoldingSetNode(), Qualifier(Qualifier, true), Operator(Operator), CanonicalTemplateName(this) 
    //START JInit
    $Node();
    this.Qualifier = new PointerBoolPair<NestedNameSpecifier /*P*/ >(Qualifier, true);
    /*Indirect*/this.Unnamed_field1.Operator = Operator;
    this.CanonicalTemplateName = new TemplateName(this);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::DependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 460,
   FQN="clang::DependentTemplateName::DependentTemplateName", NM="_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateNameC1EPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindENS_12TemplateNameE")
  //</editor-fold>
  /*friend*//*package*/ DependentTemplateName(NestedNameSpecifier /*P*/ Qualifier, 
      OverloadedOperatorKind Operator, 
      TemplateName Canon) {
    // : FoldingSetNode(), Qualifier(Qualifier, true), Operator(Operator), CanonicalTemplateName(Canon) 
    //START JInit
    $Node();
    this.Qualifier = new PointerBoolPair<NestedNameSpecifier /*P*/ >(Qualifier, true);
    /*Indirect*/this.Unnamed_field1.Operator = Operator;
    this.CanonicalTemplateName = new TemplateName(Canon);
    //END JInit
  }

/*public:*/
  /// \brief Return the nested name specifier that qualifies this name.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 468,
   FQN="clang::DependentTemplateName::getQualifier", NM="_ZNK5clang21DependentTemplateName12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21DependentTemplateName12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return Qualifier.getPointer();
  }

  
  /// \brief Determine whether this template name refers to an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::isIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 471,
   FQN="clang::DependentTemplateName::isIdentifier", NM="_ZNK5clang21DependentTemplateName12isIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21DependentTemplateName12isIdentifierEv")
  //</editor-fold>
  public boolean isIdentifier() /*const*/ {
    return !Qualifier.getInt();
  }

  
  /// \brief Returns the identifier to which this template name refers.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 474,
   FQN="clang::DependentTemplateName::getIdentifier", NM="_ZNK5clang21DependentTemplateName13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21DependentTemplateName13getIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    assert (isIdentifier()) : "Template name isn't an identifier?";
    return Unnamed_field1.Identifier;
  }

  
  /// \brief Determine whether this template name refers to an overloaded
  /// operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::isOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 481,
   FQN="clang::DependentTemplateName::isOverloadedOperator", NM="_ZNK5clang21DependentTemplateName20isOverloadedOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21DependentTemplateName20isOverloadedOperatorEv")
  //</editor-fold>
  public boolean isOverloadedOperator() /*const*/ {
    return Qualifier.getInt();
  }

  
  /// \brief Return the overloaded operator to which this template name refers.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::getOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 484,
   FQN="clang::DependentTemplateName::getOperator", NM="_ZNK5clang21DependentTemplateName11getOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang21DependentTemplateName11getOperatorEv")
  //</editor-fold>
  public OverloadedOperatorKind getOperator() /*const*/ {
    assert (isOverloadedOperator()) : "Template name isn't an overloaded operator?";
    return Unnamed_field1.Operator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 490,
   FQN="clang::DependentTemplateName::Profile", NM="_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    if (isIdentifier()) {
      Profile(ID, getQualifier(), getIdentifier());
    } else {
      Profile(ID, getQualifier(), getOperator());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 497,
   FQN="clang::DependentTemplateName::Profile", NM="_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, NestedNameSpecifier /*P*/ NNS, 
         /*const*/ IdentifierInfo /*P*/ Identifier) {
    ID.AddPointer(NNS);
    ID.AddBoolean(false);
    ID.AddPointer(Identifier);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 504,
   FQN="clang::DependentTemplateName::Profile", NM="_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang21DependentTemplateName7ProfileERN4llvm16FoldingSetNodeIDEPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, NestedNameSpecifier /*P*/ NNS, 
         OverloadedOperatorKind Operator) {
    ID.AddPointer(NNS);
    ID.AddBoolean(true);
    ID.AddInteger_int(Operator.getValue());
  }

  
  @Override public String toString() {
    return "" + "Qualifier=" + Qualifier // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + ", CanonicalTemplateName=" + CanonicalTemplateName // NOI18N
              + super.toString(); // NOI18N
  }
}
