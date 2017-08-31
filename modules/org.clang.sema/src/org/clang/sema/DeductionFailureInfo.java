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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;

// end namespace sema

/// A structure used to record information about a failed
/// template argument deduction, for diagnosis.
//<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 190,
 FQN="clang::DeductionFailureInfo", NM="_ZN5clang20DeductionFailureInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoE")
//</editor-fold>
public class/*struct*/ DeductionFailureInfo {
  /// A Sema::TemplateDeductionResult.
  public /*JBYTE unsigned int*/ byte Result /*: 8*/;
  
  /// \brief Indicates whether a diagnostic is stored in Diagnostic.
  public /*JBIT unsigned int*/ boolean HasDiagnostic /*: 1*/;
  
  /// \brief Opaque pointer containing additional data about
  /// this deduction failure.
  public Object/*void P*/ Data;
  
  /// \brief A diagnostic indicating why deduction failed.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*byte[16] replaced with PartialDiagnosticAt*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 202,
   FQN="clang::DeductionFailureInfo::(anonymous)", NM="_ZN5clang20DeductionFailureInfoE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public Object/*void P*/ Align;
    // JAVA: use explicit type and $MemCopy
    public final std.pair<SourceLocation, PartialDiagnostic> Diagnostic = new std.pairTypeType<>(new SourceLocation(), new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic()));
    //public /*char*/byte Diagnostic[/*16*/] = new$char(16);
    //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Diagnostic*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 202,
     FQN="clang::DeductionFailureInfo::(anonymous union)::operator=", NM="_ZN5clang20DeductionFailureInfoUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
      this.Align = $Prm0.Align;
      // JAVA: $MemCopy
      this.Diagnostic.first.$assign($Prm0.Diagnostic.first);
      this.Diagnostic.second.$MemoryCopy($Prm0.Diagnostic.second);
      //__builtin_memcpy(/*AddrOf*/this.Diagnostic, /*AddrOf*/$Prm0.Diagnostic/*, SKIP_ARG*/);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Diagnostic*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 202,
     FQN="clang::DeductionFailureInfo::(anonymous union)::operator=", NM="_ZN5clang20DeductionFailureInfoUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      this.Align = $Prm0.Align;
      // JAVA: $MemCopy
      this.Diagnostic.first.$assign($Prm0.Diagnostic.first);
      this.Diagnostic.second.$MemoryCopy($Prm0.Diagnostic.second);
      //__builtin_memcpy(/*AddrOf*/this.Diagnostic, /*AddrOf*/$Prm0.Diagnostic/*, SKIP_ARG*/);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 202,
     FQN="clang::DeductionFailureInfo::(anonymous union)::", NM="_ZN5clang20DeductionFailureInfoUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
      $assignMove($Prm0);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED) public Unnamed_union1() {}
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED) public Unnamed_union1(final Unnamed_union1 $Prm0) { $assign($Prm0); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Align=" + Align // NOI18N
                + ", Diagnostic=" + Diagnostic; // NOI18N
    }
  };
  public Unnamed_union1 Unnamed_field3 = new Unnamed_union1();
  
  /// \brief Retrieve the diagnostic which caused this deduction failure,
  /// if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getSFINAEDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 670,
   FQN="clang::DeductionFailureInfo::getSFINAEDiagnostic", NM="_ZN5clang20DeductionFailureInfo19getSFINAEDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo19getSFINAEDiagnosticEv")
  //</editor-fold>
  public std.pair<SourceLocation, PartialDiagnostic> /*P*/ getSFINAEDiagnostic() {
    if (HasDiagnostic) {
      return ((/*static_cast*/std.pair<SourceLocation, PartialDiagnostic> /*P*/ )((reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Unnamed_field3.Diagnostic)))));
    }
    return null;
  }

  
  /// \brief Retrieve the template parameter this deduction failure
  /// refers to, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getTemplateParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 676,
   FQN="clang::DeductionFailureInfo::getTemplateParameter", NM="_ZN5clang20DeductionFailureInfo20getTemplateParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo20getTemplateParameterEv")
  //</editor-fold>
  public PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ > getTemplateParameter() {
    switch (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))) {
     case TDK_Success:
     case TDK_Invalid:
     case TDK_InstantiationDepth:
     case TDK_TooManyArguments:
     case TDK_TooFewArguments:
     case TDK_SubstitutionFailure:
     case TDK_DeducedMismatch:
     case TDK_NonDeducedMismatch:
     case TDK_FailedOverloadResolution:
      return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(TemplateTypeParmDecl /*P*/.class);
     case TDK_Incomplete:
     case TDK_InvalidExplicitArguments:
      return PointerUnion3.<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >getFromOpaqueValue(Data);
     case TDK_Inconsistent:
     case TDK_Underqualified:
      return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(((/*static_cast*/DFIParamWithArguments /*P*/ )(Data)).Param);
     case TDK_MiscellaneousDeductionFailure:
      
      // Unhandled
      break;
    }
    
    return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(TemplateTypeParmDecl /*P*/.class);
  }

  
  /// \brief Retrieve the template argument list associated with this
  /// deduction failure, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 705,
   FQN="clang::DeductionFailureInfo::getTemplateArgumentList", NM="_ZN5clang20DeductionFailureInfo23getTemplateArgumentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo23getTemplateArgumentListEv")
  //</editor-fold>
  public TemplateArgumentList /*P*/ getTemplateArgumentList() {
    switch (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))) {
     case TDK_Success:
     case TDK_Invalid:
     case TDK_InstantiationDepth:
     case TDK_TooManyArguments:
     case TDK_TooFewArguments:
     case TDK_Incomplete:
     case TDK_InvalidExplicitArguments:
     case TDK_Inconsistent:
     case TDK_Underqualified:
     case TDK_NonDeducedMismatch:
     case TDK_FailedOverloadResolution:
      return null;
     case TDK_DeducedMismatch:
      return ((/*static_cast*/DFIDeducedMismatchArgs /*P*/ )(Data)).TemplateArgs;
     case TDK_SubstitutionFailure:
      return ((/*static_cast*/TemplateArgumentList /*P*/ )(Data));
     case TDK_MiscellaneousDeductionFailure:
      
      // Unhandled
      break;
    }
    
    return null;
  }

  
  /// \brief Return the first template argument this deduction failure
  /// refers to, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getFirstArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 734,
   FQN="clang::DeductionFailureInfo::getFirstArg", NM="_ZN5clang20DeductionFailureInfo11getFirstArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo11getFirstArgEv")
  //</editor-fold>
  public /*const*/ TemplateArgument /*P*/ getFirstArg() {
    switch (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))) {
     case TDK_Success:
     case TDK_Invalid:
     case TDK_InstantiationDepth:
     case TDK_Incomplete:
     case TDK_TooManyArguments:
     case TDK_TooFewArguments:
     case TDK_InvalidExplicitArguments:
     case TDK_SubstitutionFailure:
     case TDK_FailedOverloadResolution:
      return null;
     case TDK_Inconsistent:
     case TDK_Underqualified:
     case TDK_DeducedMismatch:
     case TDK_NonDeducedMismatch:
      return $AddrOf(((/*static_cast*/DFIArguments /*P*/ )(Data)).FirstArg);
     case TDK_MiscellaneousDeductionFailure:
      
      // Unhandled
      break;
    }
    
    return null;
  }

  
  /// \brief Return the second template argument this deduction failure
  /// refers to, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getSecondArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 761,
   FQN="clang::DeductionFailureInfo::getSecondArg", NM="_ZN5clang20DeductionFailureInfo12getSecondArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo12getSecondArgEv")
  //</editor-fold>
  public /*const*/ TemplateArgument /*P*/ getSecondArg() {
    switch (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))) {
     case TDK_Success:
     case TDK_Invalid:
     case TDK_InstantiationDepth:
     case TDK_Incomplete:
     case TDK_TooManyArguments:
     case TDK_TooFewArguments:
     case TDK_InvalidExplicitArguments:
     case TDK_SubstitutionFailure:
     case TDK_FailedOverloadResolution:
      return null;
     case TDK_Inconsistent:
     case TDK_Underqualified:
     case TDK_DeducedMismatch:
     case TDK_NonDeducedMismatch:
      return $AddrOf(((/*static_cast*/DFIArguments /*P*/ )(Data)).SecondArg);
     case TDK_MiscellaneousDeductionFailure:
      
      // Unhandled
      break;
    }
    
    return null;
  }

  
  /// \brief Return the expression this deduction failure refers to,
  /// if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 788,
   FQN="clang::DeductionFailureInfo::getExpr", NM="_ZN5clang20DeductionFailureInfo7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() {
    if (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))
       == Sema.TemplateDeductionResult.TDK_FailedOverloadResolution) {
      return ((/*static_cast*/Expr /*P*/ )(Data));
    }
    
    return null;
  }

  
  /// \brief Return the index of the call argument that this deduction
  /// failure refers to, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::getCallArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 796,
   FQN="clang::DeductionFailureInfo::getCallArgIndex", NM="_ZN5clang20DeductionFailureInfo15getCallArgIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo15getCallArgIndexEv")
  //</editor-fold>
  public OptionalUInt getCallArgIndex() {
    if (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))
       == Sema.TemplateDeductionResult.TDK_DeducedMismatch) {
      return new OptionalUInt(JD$T$C$R.INSTANCE, ((/*static_cast*/DFIDeducedMismatchArgs /*P*/ )(Data)).CallArgIndex);
    }
    
    return new OptionalUInt(llvm.None);
  }

  
  /// \brief Free any memory associated with this deduction failure.
  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 635,
   FQN="clang::DeductionFailureInfo::Destroy", NM="_ZN5clang20DeductionFailureInfo7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfo7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    switch (/*static_cast*/Sema.TemplateDeductionResult.valueOf($8bits_uint2uint(Result))) {
     case TDK_Success:
     case TDK_Invalid:
     case TDK_InstantiationDepth:
     case TDK_Incomplete:
     case TDK_TooManyArguments:
     case TDK_TooFewArguments:
     case TDK_InvalidExplicitArguments:
     case TDK_FailedOverloadResolution:
      break;
     case TDK_Inconsistent:
     case TDK_Underqualified:
     case TDK_DeducedMismatch:
     case TDK_NonDeducedMismatch:
      // FIXME: Destroy the data?
      Data = null;
      break;
     case TDK_SubstitutionFailure:
      // FIXME: Destroy the template argument list?
      Data = null;
      {
        std.pair<SourceLocation, PartialDiagnostic> /*P*/ Diag = getSFINAEDiagnostic();
        if ((Diag != null)) {
          Diag.$destroy();
          HasDiagnostic = false;
        }
      }
      break;
     case TDK_MiscellaneousDeductionFailure:
      
      // Unhandled
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 190,
   FQN="clang::DeductionFailureInfo::operator=", NM="_ZN5clang20DeductionFailureInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeductionFailureInfo /*&*/ $assign(final /*const*/ DeductionFailureInfo /*&*/ $Prm0) {
    this.Result = $uint2uint_8bits($8bits_uint2uint($Prm0.Result));
    this.HasDiagnostic = $Prm0.HasDiagnostic;
    this.Data = $Prm0.Data;
    this.Unnamed_field3.$assign($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 190,
   FQN="clang::DeductionFailureInfo::operator=", NM="_ZN5clang20DeductionFailureInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeductionFailureInfo /*&*/ $assignMove(final DeductionFailureInfo /*&&*/$Prm0) {
    this.Result = $uint2uint_8bits($8bits_uint2uint($Prm0.Result));
    this.HasDiagnostic = $Prm0.HasDiagnostic;
    this.Data = $Prm0.Data;
    this.Unnamed_field3.$assignMove($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::DeductionFailureInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 190,
   FQN="clang::DeductionFailureInfo::DeductionFailureInfo", NM="_ZN5clang20DeductionFailureInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoC1Ev")
  //</editor-fold>
  public /*inline*/ DeductionFailureInfo() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeductionFailureInfo::DeductionFailureInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 190,
   FQN="clang::DeductionFailureInfo::DeductionFailureInfo", NM="_ZN5clang20DeductionFailureInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang20DeductionFailureInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeductionFailureInfo(JD$Move _dparam, final DeductionFailureInfo /*&&*/$Prm0) {
    // : Result(static_cast<DeductionFailureInfo &&>().Result), HasDiagnostic(static_cast<DeductionFailureInfo &&>().HasDiagnostic), Data(static_cast<DeductionFailureInfo &&>().Data), Unnamed_field3(static_cast<DeductionFailureInfo &&>().) 
    //START JInit
    this.Result = $uint2uint_8bits($8bits_uint2uint($Prm0.Result));
    this.HasDiagnostic = $Prm0.HasDiagnostic;
    this.Data = $Prm0.Data;
    this.Unnamed_field3 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*inline*/ DeductionFailureInfo(final DeductionFailureInfo /*&*/$Prm0) {
    this.Result = $uint2uint_8bits($8bits_uint2uint($Prm0.Result));
    this.HasDiagnostic = $Prm0.HasDiagnostic;
    this.Data = $Prm0.Data;
    this.Unnamed_field3 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Result=" + $uchar2uint(Result) // NOI18N
              + ", HasDiagnostic=" + HasDiagnostic // NOI18N
              + ", Data=" + Data // NOI18N
              + ", Unnamed_field3=" + Unnamed_field3; // NOI18N
  }
}
