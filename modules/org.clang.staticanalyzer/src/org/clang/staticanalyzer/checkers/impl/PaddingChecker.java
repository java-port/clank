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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.ast.CharUnitsGlobals.*;
import org.clang.staticanalyzer.core.ento.check.ASTDecl;
import org.clank.java.std_ptr.unique_ptr;
import org.clank.support.aliases.type$ptr;
import static org.clank.support.literal_constants.*;
import org.llvm.adt.aliases.SmallVector;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 33,
 FQN="(anonymous namespace)::PaddingChecker", NM="_ZN12_GLOBAL__N_114PaddingCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN12_GLOBAL__N_114PaddingCheckerE")
//</editor-fold>
public class PaddingChecker extends /*public*/ Checker/*T<ASTDecl<TranslationUnitDecl> > */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<TranslationUnitDecl>, Destructors.ClassWithDestructor {
/*private:*/
  private /*mutable */std.unique_ptr<BugType> PaddingBug;
  private /*mutable */long/*int64_t*/ AllowedPad;
  private /*mutable */BugReporter /*P*/ BR;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 40,
   FQN="(anonymous namespace)::PaddingChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ TranslationUnitDecl /*P*/ TUD, final AnalysisManager /*&*/ MGR, 
              final BugReporter /*&*/ BRArg) /*const*/ {
    BR = $AddrOf(BRArg);
    AllowedPad
       = MGR.getAnalyzerOptions().getOptionAsInteger(new StringRef(/*KEEP_STR*/"AllowedPad"), 24, this);
    assert (AllowedPad >= 0) : "AllowedPad option should be non-negative";
    
    // The calls to checkAST* from AnalysisConsumer don't
    // visit template instantiations or lambda classes. We
    // want to visit those, so we make our own RecursiveASTVisitor.
    //<editor-fold defaultstate="collapsed" desc="LocalVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 50,
     FQN="LocalVisitor", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEE12LocalVisitor",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEE12LocalVisitor")
    //</editor-fold>
     class/*struct*/ LocalVisitor implements /*public*/ RecursiveASTVisitor<LocalVisitor> {
      public /*const*/ PaddingChecker /*P*/ Checker;
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::shouldVisitTemplateInstantiations">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 52,
       FQN="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::shouldVisitTemplateInstantiations", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEENK12LocalVisitor33shouldVisitTemplateInstantiationsEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEENK12LocalVisitor33shouldVisitTemplateInstantiationsEv")
      //</editor-fold>
      public boolean shouldVisitTemplateInstantiations() /*const*/ {
        return true;
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::shouldVisitImplicitCode">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 53,
       FQN="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::shouldVisitImplicitCode", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEENK12LocalVisitor23shouldVisitImplicitCodeEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEENK12LocalVisitor23shouldVisitImplicitCodeEv")
      //</editor-fold>
      public boolean shouldVisitImplicitCode() /*const*/ {
        return true;
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::LocalVisitor">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 54,
       FQN="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::LocalVisitor", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitorC1EPKS0_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitorC1EPKS0_")
      //</editor-fold>
      public /*explicit*/ LocalVisitor(/*const*/ PaddingChecker /*P*/ Checker) {
        // : RecursiveASTVisitor<LocalVisitor>(), Checker(Checker) 
        //START JInit
        $RecursiveASTVisitor();
        this.Checker = Checker;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::VisitRecordDecl">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 55,
       FQN="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::VisitRecordDecl", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitor15VisitRecordDeclEPKNS1_10RecordDeclE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitor15VisitRecordDeclEPKNS1_10RecordDeclE")
      //</editor-fold>
      public boolean VisitRecordDecl(/*const*/ RecordDecl /*P*/ RD) {
        Checker.visitRecord(RD);
        return true;
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::VisitVarDecl">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 59,
       FQN="(anonymous namespace)::PaddingChecker::checkASTDecl(const TranslationUnitDecl * , AnalysisManager & , BugReporter & )::LocalVisitor::VisitVarDecl", NM="_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitor12VisitVarDeclEPKNS1_7VarDeclE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZNK12_GLOBAL__N_114PaddingChecker12checkASTDeclEPKN5clang19TranslationUnitDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterEEN12LocalVisitor12VisitVarDeclEPKNS1_7VarDeclE")
      //</editor-fold>
      public boolean VisitVarDecl(/*const*/ VarDecl /*P*/ VD) {
        Checker.visitVariable(VD);
        return true;
      }

      @Override
      public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
        return false;
      }
      
      @Override public String toString() {
        return "" + "Checker=" + Checker // NOI18N
                  + super.toString(); // NOI18N
      }
    };
    
    // TODO: Visit array new and mallocs for arrays.
    LocalVisitor visitor/*J*/= new LocalVisitor(this);
    visitor.TraverseDecl(((/*const_cast*/TranslationUnitDecl /*P*/ )(TUD)));
  }

  
  /// \brief Look for records of overly padded types. If padding *
  /// PadMultiplier exceeds AllowedPad, then generate a report.
  /// PadMultiplier is used to share code with the array padding
  /// checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::visitRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 74,
   FQN="(anonymous namespace)::PaddingChecker::visitRecord", NM="_ZNK12_GLOBAL__N_114PaddingChecker11visitRecordEPKN5clang10RecordDeclEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZNK12_GLOBAL__N_114PaddingChecker11visitRecordEPKN5clang10RecordDeclEy")
  //</editor-fold>
  public void visitRecord(/*const*/ RecordDecl /*P*/ RD) /*const*/ {
    visitRecord(RD, $int2ulong(1));
  }
  public void visitRecord(/*const*/ RecordDecl /*P*/ RD, long/*uint64_t*/ PadMultiplier/*= 1*/) /*const*/ {
    if (shouldSkipDecl(RD)) {
      return;
    }
    
    final ASTContext /*&*/ $ASTContext = RD.getASTContext();
    final /*const*/ ASTRecordLayout /*&*/ RL = $ASTContext.getASTRecordLayout(RD);
    assert (llvm.isPowerOf2_64(RL.getAlignment().getQuantity()));
    
    CharUnits BaselinePad = PaddingChecker.calculateBaselinePad(RD, $ASTContext, RL);
    if (BaselinePad.isZero()) {
      return;
    }
    CharUnits OptimalPad = PaddingChecker.calculateOptimalPad(RD, $ASTContext, RL);
    
    CharUnits DiffPad = $star_long_CharUnits$C(PadMultiplier, (BaselinePad.$sub(OptimalPad)));
    if (DiffPad.getQuantity() <= AllowedPad) {
      assert (!DiffPad.isNegative()) : "DiffPad should not be negative";
      // There is not enough excess padding to trigger a warning.
      return;
    }
    reportRecord(RD, new CharUnits(BaselinePad), new CharUnits(OptimalPad));
  }

  
  /// \brief Look for arrays of overly padded types. If the padding of the
  /// array type exceeds AllowedPad, then generate a report.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::visitVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 98,
   FQN="(anonymous namespace)::PaddingChecker::visitVariable", NM="_ZNK12_GLOBAL__N_114PaddingChecker13visitVariableEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZNK12_GLOBAL__N_114PaddingChecker13visitVariableEPKN5clang7VarDeclE")
  //</editor-fold>
  public void visitVariable(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    /*const*/ ArrayType /*P*/ ArrTy = VD.getType().$arrow().getAsArrayTypeUnsafe();
    if (ArrTy == null) {
      return;
    }
    long/*uint64_t*/ Elts = $int2ulong(0);
    {
      /*const*/ ConstantArrayType /*P*/ CArrTy = dyn_cast_ConstantArrayType(ArrTy);
      if ((CArrTy != null)) {
        Elts = CArrTy.getSize().getZExtValue();
      }
    }
    if (Elts == $int2ullong(0)) {
      return;
    }
    /*const*/ RecordType /*P*/ RT = ArrTy.getElementType().$arrow().getAs$RecordType();
    if (RT == null) {
      return;
    }
    
    // TODO: Recurse into the fields and base classes to see if any
    // of those have excess padding.
    visitRecord(RT.getDecl(), Elts);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::shouldSkipDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 116,
   FQN="(anonymous namespace)::PaddingChecker::shouldSkipDecl", NM="_ZNK12_GLOBAL__N_114PaddingChecker14shouldSkipDeclEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZNK12_GLOBAL__N_114PaddingChecker14shouldSkipDeclEPKN5clang10RecordDeclE")
  //</editor-fold>
  public boolean shouldSkipDecl(/*const*/ RecordDecl /*P*/ RD) /*const*/ {
    SourceLocation Location = RD.getLocation();
    // If the construct doesn't have a source file, then it's not something
    // we want to diagnose.
    if (!Location.isValid()) {
      return true;
    }
    SrcMgr.CharacteristicKind Kind = BR.getSourceManager().getFileCharacteristic(/*NO_COPY*/Location);
    // Throw out all records that come from system headers.
    if (Kind != SrcMgr.CharacteristicKind.C_User) {
      return true;
    }
    
    // Not going to attempt to optimize unions.
    if (RD.isUnion()) {
      return true;
    }
    // How do you reorder fields if you haven't got any?
    if (RD.field_empty()) {
      return true;
    }
    {
      /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
      if ((CXXRD != null)) {
        // Tail padding with base classes ends up being very complicated.
        // We will skip objects with base classes for now.
        if (CXXRD.getNumBases() != 0) {
          return true;
        }
        // Virtual bases are complicated, skipping those for now.
        if (CXXRD.getNumVBases() != 0) {
          return true;
        }
        // Can't layout a template, so skip it. We do still layout the
        // instantiations though.
        if (CXXRD.getTypeForDecl().isDependentType()) {
          return true;
        }
        if (CXXRD.getTypeForDecl().isInstantiationDependentType()) {
          return true;
        }
      }
    }
    BoolPredicate<FieldDecl> IsTrickyField = /*[]*/ (/*const*/ FieldDecl /*P*/ FD) -> {
          // Bitfield layout is hard.
          if (FD.isBitField()) {
            return true;
          }
          
          // Variable length arrays are tricky too.
          QualType Ty = FD.getType();
          if (Ty.$arrow().isIncompleteArrayType()) {
            return true;
          }
          return false;
        };
    if (std.any_of(RD.field_begin(), RD.field_end(), IsTrickyField)) {
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateBaselinePad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 166,
   FQN="(anonymous namespace)::PaddingChecker::calculateBaselinePad", NM="_ZN12_GLOBAL__N_114PaddingChecker20calculateBaselinePadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN12_GLOBAL__N_114PaddingChecker20calculateBaselinePadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutE")
  //</editor-fold>
  public static CharUnits calculateBaselinePad(/*const*/ RecordDecl /*P*/ RD, 
                      final /*const*/ ASTContext /*&*/ $ASTContext, 
                      final /*const*/ ASTRecordLayout /*&*/ RL) {
    CharUnits PaddingSum/*J*/= new CharUnits();
    CharUnits Offset = $ASTContext.toCharUnitsFromBits(RL.getFieldOffset(0));
    for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
      // This checker only cares about the padded size of the
      // field, and not the data size. If the field is a record
      // with tail padding, then we won't put that number in our
      // total because reordering fields won't fix that problem.
      CharUnits FieldSize = $ASTContext.getTypeSizeInChars(FD.getType());
      long/*uint64_t*/ FieldOffsetBits = RL.getFieldOffset(FD.getFieldIndex());
      CharUnits FieldOffset = $ASTContext.toCharUnitsFromBits(FieldOffsetBits);
      PaddingSum.$addassign((FieldOffset.$sub(Offset)));
      Offset.$assignMove(FieldOffset.$add(FieldSize));
    }
    PaddingSum.$addassign(RL.getSize().$sub(Offset));
    return PaddingSum;
  }

  
  /// Optimal padding overview:
  /// 1.  Find a close approximation to where we can place our first field.
  ///     This will usually be at offset 0.
  /// 2.  Try to find the best field that can legally be placed at the current
  ///     offset.
  ///   a.  "Best" is the largest alignment that is legal, but smallest size.
  ///       This is to account for overly aligned types.
  /// 3.  If no fields can fit, pad by rounding the current offset up to the
  ///     smallest alignment requirement of our fields. Measure and track the
  //      amount of padding added. Go back to 2.
  /// 4.  Increment the current offset by the size of the chosen field.
  /// 5.  Remove the chosen field from the set of future possibilities.
  /// 6.  Go back to 2 if there are still unplaced fields.
  /// 7.  Add tail padding by rounding the current offset up to the structure
  ///     alignment. Track the amount of padding added.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateOptimalPad">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 202,
   FQN="(anonymous namespace)::PaddingChecker::calculateOptimalPad", NM="_ZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutE")
  //</editor-fold>
  public static CharUnits calculateOptimalPad(/*const*/ RecordDecl /*P*/ RD, 
                     final /*const*/ ASTContext /*&*/ $ASTContext, 
                     final /*const*/ ASTRecordLayout /*&*/ RL) {
    //<editor-fold defaultstate="collapsed" desc="CharUnitPair">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 205,
     FQN="CharUnitPair", NM="_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEE12CharUnitPair",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEE12CharUnitPair")
    //</editor-fold>
     class/*struct*/ CharUnitPair implements ComparableLower, NativeCloneable<CharUnitPair> {
      public CharUnits Align;
      public CharUnits Size;
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::operator<">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 208,
       FQN="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::operator<", NM="_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEENK12CharUnitPairltERKSB_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEENK12CharUnitPairltERKSB_")
      //</editor-fold>
      public boolean $less(final /*const*/ CharUnitPair /*&*/ RHS) /*const*/ {
        // Order from small alignments to large alignments,
        // then large sizes to small sizes.
        return std.$less_pair$_T1$_T2$C(std.make_pair(new CharUnits(Align), Size.$sub()), 
            std.make_pair(new CharUnits(RHS.Align), RHS.Size.$sub()));
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::CharUnitPair">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 205,
       FQN="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::CharUnitPair", NM="_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairC1Ev")
      //</editor-fold>
      public /*inline*/ CharUnitPair() {
        // : Align(), Size() 
        //START JInit
        this.Align = new CharUnits();
        this.Size = new CharUnits();
        //END JInit
      }
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::CharUnitPair">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 205,
       FQN="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::CharUnitPair", NM="_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairC1EOSB_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairC1EOSB_")
      //</editor-fold>
      public /*inline*/ CharUnitPair(JD$Move _dparam, final CharUnitPair /*&&*/$Prm0) {
        // : Align(static_cast<CharUnitPair &&>().Align), Size(static_cast<CharUnitPair &&>().Size) 
        //START JInit
        this.Align = new CharUnits(JD$Move.INSTANCE, $Prm0.Align);
        this.Size = new CharUnits(JD$Move.INSTANCE, $Prm0.Size);
        //END JInit
      }
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 205,
       FQN="(anonymous namespace)::PaddingChecker::calculateOptimalPad(const RecordDecl * , const ASTContext & , const ASTRecordLayout & )::CharUnitPair::operator=", NM="_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairaSEOSB_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZZN12_GLOBAL__N_114PaddingChecker19calculateOptimalPadEPKN5clang10RecordDeclERKNS1_10ASTContextERKNS1_15ASTRecordLayoutEEN12CharUnitPairaSEOSB_")
      //</editor-fold>
      public /*inline*/ CharUnitPair /*&*/ $assignMove(final CharUnitPair /*&&*/$Prm0) {
        this.Align.$assignMove($Prm0.Align);
        this.Size.$assignMove($Prm0.Size);
        return /*Deref*/this;
      }

      public CharUnitPair(CharUnits Align, CharUnits Size) { this.Align = new CharUnits(Align); this.Size = new CharUnits(Size); }

      public @Override boolean $less(Object obj) { return $less((CharUnitPair) obj); }

      @Override
      public CharUnitPair clone() {
        return new CharUnitPair(this.Align, this.Size);
      }
      
      @Override public String toString() {
        return "" + "Align=" + Align // NOI18N
                  + ", Size=" + Size; // NOI18N
      }
    }
;
    SmallVector<CharUnitPair> Fields/*J*/= new SmallVector<CharUnitPair>(20, new CharUnitPair());
    Type2RetType<FieldDecl, CharUnitPair> GatherSizesAndAlignments = /*[]*/ (/*const*/ FieldDecl /*P*/ FD) -> {
          CharUnitPair RetVal/*J*/= new CharUnitPair();
          final ASTContext /*&*/ Ctx = FD.getASTContext();
          // JAVA unfold std.tie
//          std.tie(RetVal.Size, RetVal.Align).$assign(
//              Ctx.getTypeInfoInChars(FD.getType())
//          );
          std.pairTypeType<CharUnits, CharUnits> $pair = Ctx.getTypeInfoInChars(FD.getType());
          RetVal.Size.$assign($pair.first);
          RetVal.Align.$assign($pair.second);
          assert (llvm.isPowerOf2_64(RetVal.Align.getQuantity()));
          {
            /*uint*/int Max = FD.getMaxAlignment();
            if ((Max != 0)) {
              RetVal.Align.$assign(std.max(Ctx.toCharUnitsFromBits($uint2long(Max)), RetVal.Align));
            }
          }
          return RetVal;
        };
    std.transform(RD.field_begin(), RD.field_end(), std.back_inserter(Fields), GatherSizesAndAlignments);
    std.sort(Fields.begin(), Fields.end());
    
    // This lets us skip over vptrs and non-virtual bases,
    // so that we can just worry about the fields in our object.
    // Note that this does cause us to miss some cases where we
    // could pack more bytes in to a base class's tail padding.
    CharUnits NewOffset = $ASTContext.toCharUnitsFromBits(RL.getFieldOffset(0));
    CharUnits NewPad/*J*/= new CharUnits();
    while (!Fields.empty()) {
      /*uint*/int TrailingZeros = llvm.countTrailingZeros_uint64_t_ZeroBehavior((/*ullong*/long)NewOffset.getQuantity());
      // If NewOffset is zero, then countTrailingZeros will be 64. Shifting
      // 64 will overflow our unsigned long long. Shifting 63 will turn
      // our long long (and CharUnits internal type) negative. So shift 62.
      /*llong*/long CurAlignmentBits = 1L/*ULL*/ << std.min_uint(TrailingZeros, 62/*U*/);
      CharUnits CurAlignment = CharUnits.fromQuantity(CurAlignmentBits);
      CharUnitPair InsertPoint = new CharUnitPair(CurAlignment, CharUnits.Zero());
      type$ptr<CharUnitPair /*P*/ > CurBegin = $tryClone(Fields.begin());
      type$ptr<CharUnitPair /*P*/ > CurEnd = $tryClone(Fields.end());
      
      // In the typical case, this will find the last element
      // of the vector. We won't find a middle element unless
      // we started on a poorly aligned address or have an overly
      // aligned field.
      type$ptr<CharUnitPair /*P*/ >Iter = std.upper_bound(CurBegin, CurEnd, InsertPoint);
      if (Iter != CurBegin) {
        // We found a field that we can layout with the current alignment.
        Iter.$preDec();
        NewOffset.$addassign(Iter.$arrow().Size);
        Fields.erase(Iter);
      } else {
        // We are poorly aligned, and we need to pad in order to layout another
        // field. Round up to at least the smallest field alignment that we
        // currently have.
        CharUnits NextOffset = NewOffset.alignTo(Fields.$at(0).Align);
        NewPad.$addassign(NextOffset.$sub(NewOffset));
        NewOffset.$assign(NextOffset);
      }
    }
    // Calculate tail padding.
    CharUnits NewSize = NewOffset.alignTo(RL.getAlignment());
    NewPad.$addassign(NewSize.$sub(NewOffset));
    return NewPad;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::reportRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 274,
   FQN="(anonymous namespace)::PaddingChecker::reportRecord", NM="_ZNK12_GLOBAL__N_114PaddingChecker12reportRecordEPKN5clang10RecordDeclENS1_9CharUnitsES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZNK12_GLOBAL__N_114PaddingChecker12reportRecordEPKN5clang10RecordDeclENS1_9CharUnitsES5_")
  //</editor-fold>
  public void reportRecord(/*const*/ RecordDecl /*P*/ RD, CharUnits BaselinePad, 
              CharUnits TargetPad) /*const*/ {
    raw_svector_ostream Os = null;
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!PaddingBug.$bool()) {
        $c$.clean(PaddingBug.$assignMove(
            $c$.track(llvm.make_unique(new BugType(this, $("Excessive Padding"), $("Performance"))))
        ));
      }
      
      SmallString/*100*/ Buf/*J*/= new SmallString/*100*/(100);
      Os/*J*/= new raw_svector_ostream(Buf);
      
      Os.$out(/*KEEP_STR*/"Excessive padding in '");
      Os.$out(QualType.getAsString(RD.getTypeForDecl(), new Qualifiers())).$out(/*KEEP_STR*/$SGL_QUOTE);
      {
        
        /*const*/ ClassTemplateSpecializationDecl /*P*/ TSD = dyn_cast_ClassTemplateSpecializationDecl(RD);
        if ((TSD != null)) {
          // TODO: make this show up better in the console output and in
          // the HTML. Maybe just make it show up in HTML like the path
          // diagnostics show.
          SourceLocation ILoc = TSD.getPointOfInstantiation();
          if (ILoc.isValid()) {
            Os.$out(/*KEEP_STR*/" instantiated here: ").$out(
                ILoc.printToString(BR.getSourceManager())
            );
          }
        }
      }
      
      Os.$out(/*KEEP_STR*/" (").$out_llong(BaselinePad.getQuantity()).$out(/*KEEP_STR*/" padding bytes, where ").$out_llong(
          TargetPad.getQuantity()
      ).$out(/*KEEP_STR*/" is optimal). Consider reordering ").$out(
          /*KEEP_STR*/"the fields or adding explicit padding members."
      );
      
      PathDiagnosticLocation CELoc = PathDiagnosticLocation.create(RD, BR.getSourceManager());
      
      Report = llvm.make_unique(new BugReport(PaddingBug.$star(), Os.str(), CELoc));
      Report.$arrow().setDeclWithIssue(RD);
      Report.$arrow().addRange(RD.getSourceRange());
      
      BR.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      if (Os != null) { Os.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::~PaddingChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 33,
   FQN="(anonymous namespace)::PaddingChecker::~PaddingChecker", NM="_ZN12_GLOBAL__N_114PaddingCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN12_GLOBAL__N_114PaddingCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    PaddingBug.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PaddingChecker::PaddingChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 33,
   FQN="(anonymous namespace)::PaddingChecker::PaddingChecker", NM="_ZN12_GLOBAL__N_114PaddingCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN12_GLOBAL__N_114PaddingCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ PaddingChecker() {
    // : Checker<ASTDecl<TranslationUnitDecl> >(), PaddingBug() 
    //START JInit
    super();
    this.PaddingBug = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final CheckBase $CHECKS[] = { new ASTDecl<TranslationUnitDecl>(TranslationUnitDecl.class)  };
  
  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PaddingBug=" + PaddingBug // NOI18N
              + ", AllowedPad=" + AllowedPad // NOI18N
              + ", BR=" + BR // NOI18N
              + super.toString(); // NOI18N
  }
}
