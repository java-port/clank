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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.java.OptionalNotes;


/// \brief Provides information about an attempted template argument
/// deduction, whose success or failure was described by a
/// TemplateDeductionResult value.
//<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 31,
 FQN="clang::sema::TemplateDeductionInfo", NM="_ZN5clang4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoE")
//</editor-fold>
public class TemplateDeductionInfo implements Destructors.ClassWithDestructor {
  /// \brief The deduced template argument list.
  ///
  private TemplateArgumentList /*P*/ Deduced;
  
  /// \brief The source location at which template argument
  /// deduction is occurring.
  private SourceLocation Loc;
  
  /// \brief Have we suppressed an error during deduction?
  private boolean HasSFINAEDiagnostic;
  
  /// \brief Warnings (and follow-on notes) that were suppressed due to
  /// SFINAE while performing template argument deduction.
  private OptionalNotes SuppressedDiagnostics;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::TemplateDeductionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 47,
   FQN="clang::sema::TemplateDeductionInfo::TemplateDeductionInfo", NM="_ZN5clang4sema21TemplateDeductionInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoC1ERKS1_")
  //</editor-fold>
  private TemplateDeductionInfo(final /*const*/ TemplateDeductionInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 48,
   FQN="clang::sema::TemplateDeductionInfo::operator=", NM="_ZN5clang4sema21TemplateDeductionInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ TemplateDeductionInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::TemplateDeductionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 51,
   FQN="clang::sema::TemplateDeductionInfo::TemplateDeductionInfo", NM="_ZN5clang4sema21TemplateDeductionInfoC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoC1ENS_14SourceLocationE")
  //</editor-fold>
  public TemplateDeductionInfo(SourceLocation Loc) {
    // : Deduced(null), Loc(Loc), HasSFINAEDiagnostic(false), SuppressedDiagnostics(), Param(), FirstArg(), SecondArg(), Expression(null), PendingDeducedPacks() 
    //START JInit
    this.Deduced = null;
    this.Loc = new SourceLocation(Loc);
    this.HasSFINAEDiagnostic = false;
    this.SuppressedDiagnostics = new OptionalNotes(4);
    this.Param = new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(TemplateTypeParmDecl /*P*/.class);
    this.FirstArg = new TemplateArgument();
    this.SecondArg = new TemplateArgument();
    /*Indirect*/this.Unnamed_field7.Expression = null;
    this.PendingDeducedPacks = new SmallVector<DeducedPack /*P*/ >(8, (DeducedPack /*P*/ )null);
    //END JInit
  }

  
  /// \brief Returns the location at which template argument is
  /// occurring.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 57,
   FQN="clang::sema::TemplateDeductionInfo::getLocation", NM="_ZNK5clang4sema21TemplateDeductionInfo11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang4sema21TemplateDeductionInfo11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Take ownership of the deduced template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::take">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 62,
   FQN="clang::sema::TemplateDeductionInfo::take", NM="_ZN5clang4sema21TemplateDeductionInfo4takeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfo4takeEv")
  //</editor-fold>
  public TemplateArgumentList /*P*/ take() {
    TemplateArgumentList /*P*/ Result = Deduced;
    Deduced = null;
    return Result;
  }

  
  /// \brief Take ownership of the SFINAE diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::takeSFINAEDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 69,
   FQN="clang::sema::TemplateDeductionInfo::takeSFINAEDiagnostic", NM="_ZN5clang4sema21TemplateDeductionInfo20takeSFINAEDiagnosticERSt4pairINS_14SourceLocationENS_17PartialDiagnosticEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfo20takeSFINAEDiagnosticERSt4pairINS_14SourceLocationENS_17PartialDiagnosticEE")
  //</editor-fold>
  public void takeSFINAEDiagnostic(final std.pair<SourceLocation, PartialDiagnostic> /*&*/ PD) {
    assert (HasSFINAEDiagnostic);
    PD.first.$assign(SuppressedDiagnostics.front().first);
    PD.second.swap(SuppressedDiagnostics.front().second);
    SuppressedDiagnostics.clear();
    HasSFINAEDiagnostic = false;
  }

  
  /// \brief Provide a new template argument list that contains the
  /// results of template argument deduction.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 79,
   FQN="clang::sema::TemplateDeductionInfo::reset", NM="_ZN5clang4sema21TemplateDeductionInfo5resetEPNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfo5resetEPNS_20TemplateArgumentListE")
  //</editor-fold>
  public void reset(TemplateArgumentList /*P*/ NewDeduced) {
    Deduced = NewDeduced;
  }

  
  /// \brief Is a SFINAE diagnostic available?
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::hasSFINAEDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 84,
   FQN="clang::sema::TemplateDeductionInfo::hasSFINAEDiagnostic", NM="_ZNK5clang4sema21TemplateDeductionInfo19hasSFINAEDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang4sema21TemplateDeductionInfo19hasSFINAEDiagnosticEv")
  //</editor-fold>
  public boolean hasSFINAEDiagnostic() /*const*/ {
    return HasSFINAEDiagnostic;
  }

  
  /// \brief Set the diagnostic which caused the SFINAE failure.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::addSFINAEDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL/*emplace back Clone*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 89,
   FQN="clang::sema::TemplateDeductionInfo::addSFINAEDiagnostic", NM="_ZN5clang4sema21TemplateDeductionInfo19addSFINAEDiagnosticENS_14SourceLocationENS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfo19addSFINAEDiagnosticENS_14SourceLocationENS_17PartialDiagnosticE")
  //</editor-fold>
  public void addSFINAEDiagnostic(SourceLocation Loc, PartialDiagnostic PD) {
    // Only collect the first diagnostic.
    if (HasSFINAEDiagnostic) {
      return;
    }
    SuppressedDiagnostics.clear();
    SuppressedDiagnostics.emplace_back(new std.pairTypeType(Native.$Clone(Loc), Native.$Move(std.move(PD))));
    HasSFINAEDiagnostic = true;
  }

  
  /// \brief Add a new diagnostic to the set of diagnostics
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::addSuppressedDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL/*emplace back Clone*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 99,
   FQN="clang::sema::TemplateDeductionInfo::addSuppressedDiagnostic", NM="_ZN5clang4sema21TemplateDeductionInfo23addSuppressedDiagnosticENS_14SourceLocationENS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfo23addSuppressedDiagnosticENS_14SourceLocationENS_17PartialDiagnosticE")
  //</editor-fold>
  public void addSuppressedDiagnostic(SourceLocation Loc, 
                         PartialDiagnostic PD) {
    if (HasSFINAEDiagnostic) {
      return;
    }
    SuppressedDiagnostics.emplace_back(new std.pairTypeType<>(Native.$Clone(Loc), Native.$Move(std.move(PD))));
  }

  
  /// \brief Iterator over the set of suppressed diagnostics.
  /*typedef SmallVectorImpl<PartialDiagnosticAt>::const_iterator diag_iterator*/
//  public final class diag_iterator extends type$ptr<std.pair<SourceLocation, PartialDiagnostic> > { };
  
  /// \brief Returns an iterator at the beginning of the sequence of suppressed
  /// diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::diag_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 112,
   FQN="clang::sema::TemplateDeductionInfo::diag_begin", NM="_ZNK5clang4sema21TemplateDeductionInfo10diag_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang4sema21TemplateDeductionInfo10diag_beginEv")
  //</editor-fold>
  public type$ptr<std.pairTypeType<SourceLocation, PartialDiagnostic> >  diag_begin() /*const*/ {
    return SuppressedDiagnostics.begin$Const();
  }

  
  /// \brief Returns an iterator at the end of the sequence of suppressed
  /// diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::diag_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 116,
   FQN="clang::sema::TemplateDeductionInfo::diag_end", NM="_ZNK5clang4sema21TemplateDeductionInfo8diag_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang4sema21TemplateDeductionInfo8diag_endEv")
  //</editor-fold>
  public type$ptr<std.pairTypeType<SourceLocation, PartialDiagnostic> >  diag_end() /*const*/ {
    return SuppressedDiagnostics.end$Const();
  }

  
  /// \brief The template parameter to which a template argument
  /// deduction failure refers.
  ///
  /// Depending on the result of template argument deduction, this
  /// template parameter may have different meanings:
  ///
  ///   TDK_Incomplete: this is the first template parameter whose
  ///   corresponding template argument was not deduced.
  ///
  ///   TDK_Inconsistent: this is the template parameter for which
  ///   two different template argument values were deduced.
  public PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ > Param;
  
  /// \brief The first template argument to which the template
  /// argument deduction failure refers.
  ///
  /// Depending on the result of the template argument deduction,
  /// this template argument may have different meanings:
  ///
  ///   TDK_Inconsistent: this argument is the first value deduced
  ///   for the corresponding template parameter.
  ///
  ///   TDK_SubstitutionFailure: this argument is the template
  ///   argument we were instantiating when we encountered an error.
  ///
  ///   TDK_DeducedMismatch: this is the parameter type, after substituting
  ///   deduced arguments.
  ///
  ///   TDK_NonDeducedMismatch: this is the component of the 'parameter'
  ///   of the deduction, directly provided in the source code.
  public TemplateArgument FirstArg;
  
  /// \brief The second template argument to which the template
  /// argument deduction failure refers.
  ///
  ///   TDK_Inconsistent: this argument is the second value deduced
  ///   for the corresponding template parameter.
  ///
  ///   TDK_DeducedMismatch: this is the (adjusted) call argument type.
  ///
  ///   TDK_NonDeducedMismatch: this is the mismatching component of the
  ///   'argument' of the deduction, from which we are deducing arguments.
  ///
  /// FIXME: Finish documenting this.
  public TemplateArgument SecondArg;
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 164,
   FQN="clang::sema::TemplateDeductionInfo::(anonymous)", NM="_ZN5clang4sema21TemplateDeductionInfoE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    /// \brief The expression which caused a deduction failure.
    ///
    ///   TDK_FailedOverloadResolution: this argument is the reference to
    ///   an overloaded function which could not be resolved to a specific
    ///   function.
    public Expr /*P*/ Expression;
    
    /// \brief The index of the function argument that caused a deduction
    /// failure.
    ///
    ///   TDK_DeducedMismatch: this is the index of the argument that had a
    ///   different argument type from its substituted parameter type.
    public /*uint*/int CallArgIndex;
    
    @Override public String toString() {
      return "" + "Expression=" + Expression // NOI18N
                + ", CallArgIndex=" + CallArgIndex; // NOI18N
    }
  };
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC) // JAVA: init field
  public final Unnamed_union1 Unnamed_field7 = new Unnamed_union1();
  
  /// \brief Information on packs that we're currently expanding.
  ///
  /// FIXME: This should be kept internal to SemaTemplateDeduction.
  public SmallVector<DeducedPack /*P*/ > PendingDeducedPacks;
  //<editor-fold defaultstate="collapsed" desc="clang::sema::TemplateDeductionInfo::~TemplateDeductionInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*destroy diags*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 31,
   FQN="clang::sema::TemplateDeductionInfo::~TemplateDeductionInfo", NM="_ZN5clang4sema21TemplateDeductionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4sema21TemplateDeductionInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PendingDeducedPacks.$destroy();
//    SuppressedDiagnostics.$destroy();
    //END JDestroy
    // JAVA
    for (std.pair<SourceLocation, PartialDiagnostic> P : SuppressedDiagnostics) {
      Destructors.$destroy(P.second);
    }
  }

  
  @Override public String toString() {
    return "" + "Deduced=" + Deduced // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", HasSFINAEDiagnostic=" + HasSFINAEDiagnostic // NOI18N
              + ", SuppressedDiagnostics=" + SuppressedDiagnostics // NOI18N
              + ", Param=" + Param // NOI18N
              + ", FirstArg=" + FirstArg // NOI18N
              + ", SecondArg=" + SecondArg // NOI18N
              + ", Unnamed_field7=" + Unnamed_field7 // NOI18N
              + ", PendingDeducedPacks=" + PendingDeducedPacks; // NOI18N
  }
}
