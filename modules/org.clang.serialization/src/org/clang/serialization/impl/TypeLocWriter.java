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

package org.clang.serialization.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 486,
 FQN="(anonymous namespace)::TypeLocWriter", NM="_ZN12_GLOBAL__N_113TypeLocWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriterE")
//</editor-fold>
public class TypeLocWriter implements /*public*/ TypeLocVisitorVoid<TypeLocWriter> {
  private final ASTRecordWriter /*&*/ Record;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::TypeLocWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 490,
   FQN="(anonymous namespace)::TypeLocWriter::TypeLocWriter", NM="_ZN12_GLOBAL__N_113TypeLocWriterC1ERN5clang15ASTRecordWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriterC1ERN5clang15ASTRecordWriterE")
  //</editor-fold>
  public TypeLocWriter(final ASTRecordWriter /*&*/ Record) {
    // : TypeLocVisitor<TypeLocWriter>(), Record(Record) 
    //START JInit
    $TypeLocVisitor();
    this./*&*/Record=/*&*/Record;
    //END JInit
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 504,
   FQN="(anonymous namespace)::TypeLocWriter::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public void VisitQualifiedTypeLoc(QualifiedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 507,
   FQN="(anonymous namespace)::TypeLocWriter::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public void VisitBuiltinTypeLoc(BuiltinTypeLoc TL) {
    Record.AddSourceLocation(TL.getBuiltinLoc());
    if (TL.needsExtraLocalData()) {
      Record.push_back(TL.getWrittenTypeSpec().getValue());
      Record.push_back(TL.getWrittenSignSpec().getValue());
      Record.push_back(TL.getWrittenWidthSpec().getValue());
      Record.push_back((TL.hasModeAttr() ? 1 : 0));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 516,
   FQN="(anonymous namespace)::TypeLocWriter::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public void VisitComplexTypeLoc(ComplexTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 519,
   FQN="(anonymous namespace)::TypeLocWriter::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public void VisitPointerTypeLoc(PointerTypeLoc TL) {
    Record.AddSourceLocation(TL.getStarLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 528,
   FQN="(anonymous namespace)::TypeLocWriter::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public void VisitBlockPointerTypeLoc(BlockPointerTypeLoc TL) {
    Record.AddSourceLocation(TL.getCaretLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 531,
   FQN="(anonymous namespace)::TypeLocWriter::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TL) {
    Record.AddSourceLocation(TL.getAmpLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 534,
   FQN="(anonymous namespace)::TypeLocWriter::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TL) {
    Record.AddSourceLocation(TL.getAmpAmpLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 537,
   FQN="(anonymous namespace)::TypeLocWriter::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public void VisitMemberPointerTypeLoc(MemberPointerTypeLoc TL) {
    Record.AddSourceLocation(TL.getStarLoc());
    Record.AddTypeSourceInfo(TL.getClassTInfo());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 548,
   FQN="(anonymous namespace)::TypeLocWriter::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public void VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 551,
   FQN="(anonymous namespace)::TypeLocWriter::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public void VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 554,
   FQN="(anonymous namespace)::TypeLocWriter::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public void VisitVariableArrayTypeLoc(VariableArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 557,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 561,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 565,
   FQN="(anonymous namespace)::TypeLocWriter::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public void VisitVectorTypeLoc(VectorTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 568,
   FQN="(anonymous namespace)::TypeLocWriter::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public void VisitExtVectorTypeLoc(ExtVectorTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 579,
   FQN="(anonymous namespace)::TypeLocWriter::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TL) {
    VisitFunctionTypeLoc(new FunctionTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 582,
   FQN="(anonymous namespace)::TypeLocWriter::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TL) {
    VisitFunctionTypeLoc(new FunctionTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 585,
   FQN="(anonymous namespace)::TypeLocWriter::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 656,
   FQN="(anonymous namespace)::TypeLocWriter::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public void VisitParenTypeLoc(ParenTypeLoc TL) {
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 588,
   FQN="(anonymous namespace)::TypeLocWriter::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public void VisitTypedefTypeLoc(TypedefTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 525,
   FQN="(anonymous namespace)::TypeLocWriter::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public void VisitAdjustedTypeLoc(AdjustedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 522,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public void VisitDecayedTypeLoc(DecayedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 591,
   FQN="(anonymous namespace)::TypeLocWriter::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public void VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TL) {
    Record.AddSourceLocation(TL.getTypeofLoc());
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 596,
   FQN="(anonymous namespace)::TypeLocWriter::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public void VisitTypeOfTypeLoc(TypeOfTypeLoc TL) {
    Record.AddSourceLocation(TL.getTypeofLoc());
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
    Record.AddTypeSourceInfo(TL.getUnderlyingTInfo());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 602,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public void VisitDecltypeTypeLoc(DecltypeTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 605,
   FQN="(anonymous namespace)::TypeLocWriter::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public void VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TL) {
    Record.AddSourceLocation(TL.getKWLoc());
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
    Record.AddTypeSourceInfo(TL.getUnderlyingTInfo());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 614,
   FQN="(anonymous namespace)::TypeLocWriter::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public void VisitRecordTypeLoc(RecordTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 617,
   FQN="(anonymous namespace)::TypeLocWriter::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public void VisitEnumTypeLoc(EnumTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 660,
   FQN="(anonymous namespace)::TypeLocWriter::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public void VisitElaboratedTypeLoc(ElaboratedTypeLoc TL) {
    Record.AddSourceLocation(TL.getElaboratedKeywordLoc());
    Record.AddNestedNameSpecifierLoc(TL.getQualifierLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 620,
   FQN="(anonymous namespace)::TypeLocWriter::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public void VisitAttributedTypeLoc(AttributedTypeLoc TL) {
    Record.AddSourceLocation(TL.getAttrNameLoc());
    if (TL.hasAttrOperand()) {
      SourceRange range = TL.getAttrOperandParensRange();
      Record.AddSourceLocation(range.getBegin());
      Record.AddSourceLocation(range.getEnd());
    }
    if (TL.hasAttrExprOperand()) {
      Expr /*P*/ operand = TL.getAttrExprOperand();
      Record.push_back($int2ulong((operand != null) ? 1 : 0));
      if ((operand != null)) {
        Record.AddStmt(operand);
      }
    } else if (TL.hasAttrEnumOperand()) {
      Record.AddSourceLocation(TL.getAttrEnumOperandLoc());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 635,
   FQN="(anonymous namespace)::TypeLocWriter::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 638,
   FQN="(anonymous namespace)::TypeLocWriter::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 642,
   FQN="(anonymous namespace)::TypeLocWriter::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 646,
   FQN="(anonymous namespace)::TypeLocWriter::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TL) {
    Record.AddSourceLocation(TL.getTemplateKeywordLoc());
    Record.AddSourceLocation(TL.getTemplateNameLoc());
    Record.AddSourceLocation(TL.getLAngleLoc());
    Record.AddSourceLocation(TL.getRAngleLoc());
    for (/*uint*/int i = 0, e = TL.getNumArgs(); i != e; ++i)  {
      Record.AddTemplateArgumentLocInfo(TL.getArgLoc(i).getArgument().getKind(), 
          TL.getArgLoc(i).getLocInfo());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 611,
   FQN="(anonymous namespace)::TypeLocWriter::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public void VisitAutoTypeLoc(AutoTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 664,
   FQN="(anonymous namespace)::TypeLocWriter::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public void VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 667,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public void VisitDependentNameTypeLoc(DependentNameTypeLoc TL) {
    Record.AddSourceLocation(TL.getElaboratedKeywordLoc());
    Record.AddNestedNameSpecifierLoc(TL.getQualifierLoc());
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 672,
   FQN="(anonymous namespace)::TypeLocWriter::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TL) {
    Record.AddSourceLocation(TL.getElaboratedKeywordLoc());
    Record.AddNestedNameSpecifierLoc(TL.getQualifierLoc());
    Record.AddSourceLocation(TL.getTemplateKeywordLoc());
    Record.AddSourceLocation(TL.getTemplateNameLoc());
    Record.AddSourceLocation(TL.getLAngleLoc());
    Record.AddSourceLocation(TL.getRAngleLoc());
    for (/*uint*/int I = 0, E = TL.getNumArgs(); I != E; ++I)  {
      Record.AddTemplateArgumentLocInfo(TL.getArgLoc(I).getArgument().getKind(), 
          TL.getArgLoc(I).getLocInfo());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 684,
   FQN="(anonymous namespace)::TypeLocWriter::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public void VisitPackExpansionTypeLoc(PackExpansionTypeLoc TL) {
    Record.AddSourceLocation(TL.getEllipsisLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 690,
   FQN="(anonymous namespace)::TypeLocWriter::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TL) {
    Record.push_back((TL.hasBaseTypeAsWritten() ? 1 : 0));
    Record.AddSourceLocation(TL.getTypeArgsLAngleLoc());
    Record.AddSourceLocation(TL.getTypeArgsRAngleLoc());
    for (/*uint*/int i = 0, e = TL.getNumTypeArgs(); i != e; ++i)  {
      Record.AddTypeSourceInfo(TL.getTypeArgTInfo(i));
    }
    Record.AddSourceLocation(TL.getProtocolLAngleLoc());
    Record.AddSourceLocation(TL.getProtocolRAngleLoc());
    for (/*uint*/int i = 0, e = TL.getNumProtocols(); i != e; ++i)  {
      Record.AddSourceLocation(TL.getProtocolLoc(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 687,
   FQN="(anonymous namespace)::TypeLocWriter::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public void VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TL) {
    Record.AddSourceLocation(TL.getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 701,
   FQN="(anonymous namespace)::TypeLocWriter::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TL) {
    Record.AddSourceLocation(TL.getStarLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 709,
   FQN="(anonymous namespace)::TypeLocWriter::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public void VisitPipeTypeLoc(PipeTypeLoc TL) {
    Record.AddSourceLocation(TL.getKWLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 704,
   FQN="(anonymous namespace)::TypeLocWriter::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public void VisitAtomicTypeLoc(AtomicTypeLoc TL) {
    Record.AddSourceLocation(TL.getKWLoc());
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 541,
   FQN="(anonymous namespace)::TypeLocWriter::VisitArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter17VisitArrayTypeLocEN5clang12ArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter17VisitArrayTypeLocEN5clang12ArrayTypeLocE")
  //</editor-fold>
  public void VisitArrayTypeLoc(ArrayTypeLoc TL) {
    Record.AddSourceLocation(TL.getLBracketLoc());
    Record.AddSourceLocation(TL.getRBracketLoc());
    Record.push_back($int2ulong((TL.getSizeExpr() != null) ? 1 : 0));
    if ((TL.getSizeExpr() != null)) {
      Record.AddStmt(TL.getSizeExpr());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocWriter::VisitFunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 571,
   FQN="(anonymous namespace)::TypeLocWriter::VisitFunctionTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocWriter20VisitFunctionTypeLocEN5clang15FunctionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_113TypeLocWriter20VisitFunctionTypeLocEN5clang15FunctionTypeLocE")
  //</editor-fold>
  public void VisitFunctionTypeLoc(FunctionTypeLoc TL) {
    Record.AddSourceLocation(TL.getLocalRangeBegin());
    Record.AddSourceLocation(TL.getLParenLoc());
    Record.AddSourceLocation(TL.getRParenLoc());
    Record.AddSourceLocation(TL.getLocalRangeEnd());
    for (/*uint*/int i = 0, e = TL.getNumParams(); i != e; ++i)  {
      Record.AddDeclRef(TL.getParam(i));
    }
  }

  
  @Override public String toString() {
    return "" + "Record=" + Record // NOI18N
              + super.toString(); // NOI18N
  }
}
