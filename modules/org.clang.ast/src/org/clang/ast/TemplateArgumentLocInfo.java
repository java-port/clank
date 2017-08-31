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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;


/// Location information for a TemplateArgument.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 368,
 FQN="clang::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoE")
//</editor-fold>
public class/*struct*/ TemplateArgumentLocInfo implements NativePOD<TemplateArgumentLocInfo> {
/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::T">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 371,
   FQN="clang::TemplateArgumentLocInfo::T", NM="_ZN5clang23TemplateArgumentLocInfo1TE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfo1TE")
  //</editor-fold>
  private static class/*struct*/ T {
    // FIXME: We'd like to just use the qualifier in the TemplateName,
    // but template arguments get canonicalized too quickly.
    public NestedNameSpecifier /*P*/ Qualifier;
    public type$ptr<?>/*void P*/ QualifierLocData;
    public /*uint*/int TemplateNameLoc;
    public /*uint*/int EllipsisLoc;

    public T() { }
    public T(final /*const*/ T /*&*/ $Prm0) { $assign($Prm0); }
        
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::T::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 371,
     FQN="clang::TemplateArgumentLocInfo::T::operator=", NM="_ZN5clang23TemplateArgumentLocInfo1TaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfo1TaSERKS1_")
    //</editor-fold>
    public /*inline*/ T /*&*/ $assign(final /*const*/ T /*&*/ $Prm0) {
      this.Qualifier = $Prm0.Qualifier;
      this.QualifierLocData = $toConst($tryClone($Prm0.QualifierLocData));
      this.TemplateNameLoc = $Prm0.TemplateNameLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::T::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 371,
     FQN="clang::TemplateArgumentLocInfo::T::operator=", NM="_ZN5clang23TemplateArgumentLocInfo1TaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfo1TaSEOS1_")
    //</editor-fold>
    public /*inline*/ T /*&*/ $assignMove(final T /*&&*/$Prm0) {
      this.Qualifier = $Prm0.Qualifier;
      this.QualifierLocData = $Prm0.QualifierLocData;
      this.TemplateNameLoc = $Prm0.TemplateNameLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Qualifier=" + Qualifier // NOI18N
                + ", QualifierLocData=" + QualifierLocData // NOI18N
                + ", TemplateNameLoc=" + TemplateNameLoc // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 380,
   FQN="clang::TemplateArgumentLocInfo::(anonymous)", NM="_ZN5clang23TemplateArgumentLocInfoE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    public  T Template;
    public Expr /*P*/ Expression;
    public TypeSourceInfo /*P*/ Declarator;

    public Unnamed_union2() {
      this.Template = new T();
      this.Expression = null;
      this.Declarator = null;
    }
        
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 380,
     FQN="clang::TemplateArgumentLocInfo::(anonymous union)::", NM="_ZN5clang23TemplateArgumentLocInfoUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(final Unnamed_union2 $Prm0) {
      this.Template = new T($Prm0.Template);
      this.Expression = $Prm0.Expression;
      this.Declarator = $Prm0.Declarator;      
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 380,
     FQN="clang::TemplateArgumentLocInfo::(anonymous union)::", NM="_ZN5clang23TemplateArgumentLocInfoUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(JD$Move _dparam, final Unnamed_union2 $Prm0) {
      this.Template = $Prm0.Template;
      this.Expression = $Prm0.Expression;
      this.Declarator = $Prm0.Declarator;        
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 380,
     FQN="clang::TemplateArgumentLocInfo::(anonymous union)::operator=", NM="_ZN5clang23TemplateArgumentLocInfoUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2 $assign(final Unnamed_union2 $Prm0) {
      
      this.Template.$assign($Prm0.Template);
      
      this.Expression = $Prm0.Expression;
      
      this.Declarator = $Prm0.Declarator;
      
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 380,
     FQN="clang::TemplateArgumentLocInfo::(anonymous union)::operator=", NM="_ZN5clang23TemplateArgumentLocInfoUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2 $assignMove(final Unnamed_union2 $Prm0) {
      
      this.Template.$assignMove($Prm0.Template);
      
      this.Expression = $Prm0.Expression;
      
      this.Declarator = $Prm0.Declarator;
      
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Template=" + Template // NOI18N
                + ", Expression=" + Expression // NOI18N
                + ", Declarator=" + Declarator; // NOI18N
    }
  };
  private Unnamed_union2 Unnamed_field;
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // TemplateArgumentLoc Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 431,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1Ev")
  //</editor-fold>
  public TemplateArgumentLocInfo() {
//    memset(reinterpret_cast(Object/*void P*/ .class, this), 0, $sizeof_TemplateArgumentLocInfo());
    this.Unnamed_field = new Unnamed_union2();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 389,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1EPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1EPNS_14TypeSourceInfoE")
  //</editor-fold>
  public TemplateArgumentLocInfo(TypeSourceInfo /*P*/ TInfo) {
    // : Declarator(TInfo) 
    this.Unnamed_field = new Unnamed_union2();
    //START JInit
    /*Indirect*/this.Unnamed_field.Declarator = TInfo;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 391,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1EPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1EPNS_4ExprE")
  //</editor-fold>
  public TemplateArgumentLocInfo(Expr /*P*/ E) {
    // : Expression(E) 
    this.Unnamed_field = new Unnamed_union2();
    //START JInit
    /*Indirect*/this.Unnamed_field.Expression = E;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 393,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1ENS_22NestedNameSpecifierLocENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1ENS_22NestedNameSpecifierLocENS_14SourceLocationES2_")
  //</editor-fold>
  public TemplateArgumentLocInfo(NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateNameLoc, 
      SourceLocation EllipsisLoc) {
    this.Unnamed_field = new Unnamed_union2();
    Unnamed_field.Template.Qualifier = QualifierLoc.getNestedNameSpecifier();
    Unnamed_field.Template.QualifierLocData = QualifierLoc.getOpaqueData();
    Unnamed_field.Template.TemplateNameLoc = TemplateNameLoc.getRawEncoding();
    Unnamed_field.Template.EllipsisLoc = EllipsisLoc.getRawEncoding();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::getAsTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 403,
   FQN="clang::TemplateArgumentLocInfo::getAsTypeSourceInfo", NM="_ZNK5clang23TemplateArgumentLocInfo19getAsTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang23TemplateArgumentLocInfo19getAsTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getAsTypeSourceInfo() /*const*/ {
    return Unnamed_field.Declarator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::getAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 407,
   FQN="clang::TemplateArgumentLocInfo::getAsExpr", NM="_ZNK5clang23TemplateArgumentLocInfo9getAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang23TemplateArgumentLocInfo9getAsExprEv")
  //</editor-fold>
  public Expr /*P*/ getAsExpr() /*const*/ {
    return Unnamed_field.Expression;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::getTemplateQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 411,
   FQN="clang::TemplateArgumentLocInfo::getTemplateQualifierLoc", NM="_ZNK5clang23TemplateArgumentLocInfo23getTemplateQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang23TemplateArgumentLocInfo23getTemplateQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getTemplateQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(Unnamed_field.Template.Qualifier, 
        Unnamed_field.Template.QualifierLocData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::getTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 416,
   FQN="clang::TemplateArgumentLocInfo::getTemplateNameLoc", NM="_ZNK5clang23TemplateArgumentLocInfo18getTemplateNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang23TemplateArgumentLocInfo18getTemplateNameLocEv")
  //</editor-fold>
  public SourceLocation getTemplateNameLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(Unnamed_field.Template.TemplateNameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::getTemplateEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 420,
   FQN="clang::TemplateArgumentLocInfo::getTemplateEllipsisLoc", NM="_ZNK5clang23TemplateArgumentLocInfo22getTemplateEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang23TemplateArgumentLocInfo22getTemplateEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getTemplateEllipsisLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(Unnamed_field.Template.EllipsisLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 368,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLocInfo(final /*const*/ TemplateArgumentLocInfo /*&*/ $Prm0) {
    // : Unnamed_field(.) 
    //START JInit
    this.Unnamed_field = new Unnamed_union2($Prm0.Unnamed_field);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 368,
   FQN="clang::TemplateArgumentLocInfo::TemplateArgumentLocInfo", NM="_ZN5clang23TemplateArgumentLocInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLocInfo(JD$Move _dparam, final TemplateArgumentLocInfo /*&&*/$Prm0) {
    // : Unnamed_field(static_cast<TemplateArgumentLocInfo &&>().) 
    //START JInit
    this.Unnamed_field = new Unnamed_union2(JD$Move.INSTANCE, $Prm0.Unnamed_field);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 368,
   FQN="clang::TemplateArgumentLocInfo::operator=", NM="_ZN5clang23TemplateArgumentLocInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLocInfo /*&*/ $assign(final /*const*/ TemplateArgumentLocInfo /*&*/ $Prm0) {
    this.Unnamed_field.$assign($Prm0.Unnamed_field);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 368,
   FQN="clang::TemplateArgumentLocInfo::operator=", NM="_ZN5clang23TemplateArgumentLocInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang23TemplateArgumentLocInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLocInfo /*&*/ $assignMove(final TemplateArgumentLocInfo /*&&*/$Prm0) {
    this.Unnamed_field.$assignMove($Prm0.Unnamed_field);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public TemplateArgumentLocInfo clone() { return new TemplateArgumentLocInfo(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field; // NOI18N
  }
}
