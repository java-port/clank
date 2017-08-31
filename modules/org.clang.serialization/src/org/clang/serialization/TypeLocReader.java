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

package org.clang.serialization;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5703,
 FQN="clang::TypeLocReader", NM="_ZN5clang13TypeLocReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReaderE")
//</editor-fold>
public class TypeLocReader implements /*public*/ TypeLocVisitorVoid<TypeLocReader> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ F;
  private final /*const*/SmallVectorULong /*&*/ Record;
  private final uint$ref/*uint &*/ Idx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::ReadSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5709,
   FQN="clang::TypeLocReader::ReadSourceLocation", NM="_ZN5clang13TypeLocReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private SourceLocation ReadSourceLocation(final /*const*/SmallVectorULong /*&*/ R, 
                    final uint$ref/*uint &*/ I) {
    return Reader.ReadSourceLocation(F, R, I);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::ReadDeclAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5715,
   FQN="clang::TypeLocReader::ReadDeclAs", NM="Tpl__ZN5clang13TypeLocReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang13TypeLocReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private </*typename*/ T> T /*P*/ ReadDeclAs(Class<T> cls, final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    return Reader.<T>ReadDeclAs(cls, F, Record, Idx);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::TypeLocReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5720,
   FQN="clang::TypeLocReader::TypeLocReader", NM="_ZN5clang13TypeLocReaderC1ERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReaderC1ERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TypeLocReader(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F, 
      final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    // : TypeLocVisitor<TypeLocReader>(), Reader(Reader), F(F), Record(Record), Idx(Idx) 
    //START JInit
    $TypeLocVisitor();
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/F;
    this./*&*/Record=/*&*/Record;
    this./*&*/Idx=/*&*/Idx;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5737,
   FQN="clang::TypeLocReader::VisitQualifiedTypeLoc", NM="_ZN5clang13TypeLocReader21VisitQualifiedTypeLocENS_16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader21VisitQualifiedTypeLocENS_16QualifiedTypeLocE")
  //</editor-fold>
  public void VisitQualifiedTypeLoc(QualifiedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5740,
   FQN="clang::TypeLocReader::VisitBuiltinTypeLoc", NM="_ZN5clang13TypeLocReader19VisitBuiltinTypeLocENS_14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader19VisitBuiltinTypeLocENS_14BuiltinTypeLocE")
  //</editor-fold>
  public void VisitBuiltinTypeLoc(BuiltinTypeLoc TL) {
    TL.setBuiltinLoc(ReadSourceLocation(Record, Idx));
    if (TL.needsExtraLocalData()) {
      TL.setWrittenTypeSpec(/*static_cast*/TypeSpecifierType.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
      TL.setWrittenSignSpec(/*static_cast*/TypeSpecifierSign.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
      TL.setWrittenWidthSpec(/*static_cast*/TypeSpecifierWidth.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
      TL.setModeAttr((Record.$at$Const(Idx.$set$postInc()) != 0));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5749,
   FQN="clang::TypeLocReader::VisitComplexTypeLoc", NM="_ZN5clang13TypeLocReader19VisitComplexTypeLocENS_14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader19VisitComplexTypeLocENS_14ComplexTypeLocE")
  //</editor-fold>
  public void VisitComplexTypeLoc(ComplexTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5752,
   FQN="clang::TypeLocReader::VisitPointerTypeLoc", NM="_ZN5clang13TypeLocReader19VisitPointerTypeLocENS_14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader19VisitPointerTypeLocENS_14PointerTypeLocE")
  //</editor-fold>
  public void VisitPointerTypeLoc(PointerTypeLoc TL) {
    TL.setStarLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5761,
   FQN="clang::TypeLocReader::VisitBlockPointerTypeLoc", NM="_ZN5clang13TypeLocReader24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE")
  //</editor-fold>
  public void VisitBlockPointerTypeLoc(BlockPointerTypeLoc TL) {
    TL.setCaretLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5764,
   FQN="clang::TypeLocReader::VisitLValueReferenceTypeLoc", NM="_ZN5clang13TypeLocReader27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TL) {
    TL.setAmpLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5767,
   FQN="clang::TypeLocReader::VisitRValueReferenceTypeLoc", NM="_ZN5clang13TypeLocReader27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TL) {
    TL.setAmpAmpLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5770,
   FQN="clang::TypeLocReader::VisitMemberPointerTypeLoc", NM="_ZN5clang13TypeLocReader25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE")
  //</editor-fold>
  public void VisitMemberPointerTypeLoc(MemberPointerTypeLoc TL) {
    TL.setStarLoc(ReadSourceLocation(Record, Idx));
    TL.setClassTInfo(Reader.GetTypeSourceInfo(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5782,
   FQN="clang::TypeLocReader::VisitConstantArrayTypeLoc", NM="_ZN5clang13TypeLocReader25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE")
  //</editor-fold>
  public void VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5785,
   FQN="clang::TypeLocReader::VisitIncompleteArrayTypeLoc", NM="_ZN5clang13TypeLocReader27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE")
  //</editor-fold>
  public void VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5788,
   FQN="clang::TypeLocReader::VisitVariableArrayTypeLoc", NM="_ZN5clang13TypeLocReader25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE")
  //</editor-fold>
  public void VisitVariableArrayTypeLoc(VariableArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5791,
   FQN="clang::TypeLocReader::VisitDependentSizedArrayTypeLoc", NM="_ZN5clang13TypeLocReader31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TL) {
    VisitArrayTypeLoc(new ArrayTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5795,
   FQN="clang::TypeLocReader::VisitDependentSizedExtVectorTypeLoc", NM="_ZN5clang13TypeLocReader35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5799,
   FQN="clang::TypeLocReader::VisitVectorTypeLoc", NM="_ZN5clang13TypeLocReader18VisitVectorTypeLocENS_13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader18VisitVectorTypeLocENS_13VectorTypeLocE")
  //</editor-fold>
  public void VisitVectorTypeLoc(VectorTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5802,
   FQN="clang::TypeLocReader::VisitExtVectorTypeLoc", NM="_ZN5clang13TypeLocReader21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE")
  //</editor-fold>
  public void VisitExtVectorTypeLoc(ExtVectorTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5814,
   FQN="clang::TypeLocReader::VisitFunctionProtoTypeLoc", NM="_ZN5clang13TypeLocReader25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TL) {
    VisitFunctionTypeLoc(new FunctionTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5817,
   FQN="clang::TypeLocReader::VisitFunctionNoProtoTypeLoc", NM="_ZN5clang13TypeLocReader27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TL) {
    VisitFunctionTypeLoc(new FunctionTypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5820,
   FQN="clang::TypeLocReader::VisitUnresolvedUsingTypeLoc", NM="_ZN5clang13TypeLocReader27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5894,
   FQN="clang::TypeLocReader::VisitParenTypeLoc", NM="_ZN5clang13TypeLocReader17VisitParenTypeLocENS_12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader17VisitParenTypeLocENS_12ParenTypeLocE")
  //</editor-fold>
  public void VisitParenTypeLoc(ParenTypeLoc TL) {
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5823,
   FQN="clang::TypeLocReader::VisitTypedefTypeLoc", NM="_ZN5clang13TypeLocReader19VisitTypedefTypeLocENS_14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader19VisitTypedefTypeLocENS_14TypedefTypeLocE")
  //</editor-fold>
  public void VisitTypedefTypeLoc(TypedefTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5758,
   FQN="clang::TypeLocReader::VisitAdjustedTypeLoc", NM="_ZN5clang13TypeLocReader20VisitAdjustedTypeLocENS_15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader20VisitAdjustedTypeLocENS_15AdjustedTypeLocE")
  //</editor-fold>
  public void VisitAdjustedTypeLoc(AdjustedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5755,
   FQN="clang::TypeLocReader::VisitDecayedTypeLoc", NM="_ZN5clang13TypeLocReader19VisitDecayedTypeLocENS_14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader19VisitDecayedTypeLocENS_14DecayedTypeLocE")
  //</editor-fold>
  public void VisitDecayedTypeLoc(DecayedTypeLoc TL) {
    // nothing to do
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5826,
   FQN="clang::TypeLocReader::VisitTypeOfExprTypeLoc", NM="_ZN5clang13TypeLocReader22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE")
  //</editor-fold>
  public void VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TL) {
    TL.setTypeofLoc(ReadSourceLocation(Record, Idx));
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5831,
   FQN="clang::TypeLocReader::VisitTypeOfTypeLoc", NM="_ZN5clang13TypeLocReader18VisitTypeOfTypeLocENS_13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader18VisitTypeOfTypeLocENS_13TypeOfTypeLocE")
  //</editor-fold>
  public void VisitTypeOfTypeLoc(TypeOfTypeLoc TL) {
    TL.setTypeofLoc(ReadSourceLocation(Record, Idx));
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
    TL.setUnderlyingTInfo(Reader.GetTypeSourceInfo(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5837,
   FQN="clang::TypeLocReader::VisitDecltypeTypeLoc", NM="_ZN5clang13TypeLocReader20VisitDecltypeTypeLocENS_15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader20VisitDecltypeTypeLocENS_15DecltypeTypeLocE")
  //</editor-fold>
  public void VisitDecltypeTypeLoc(DecltypeTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5840,
   FQN="clang::TypeLocReader::VisitUnaryTransformTypeLoc", NM="_ZN5clang13TypeLocReader26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE")
  //</editor-fold>
  public void VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TL) {
    TL.setKWLoc(ReadSourceLocation(Record, Idx));
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
    TL.setUnderlyingTInfo(Reader.GetTypeSourceInfo(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5849,
   FQN="clang::TypeLocReader::VisitRecordTypeLoc", NM="_ZN5clang13TypeLocReader18VisitRecordTypeLocENS_13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader18VisitRecordTypeLocENS_13RecordTypeLocE")
  //</editor-fold>
  public void VisitRecordTypeLoc(RecordTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5852,
   FQN="clang::TypeLocReader::VisitEnumTypeLoc", NM="_ZN5clang13TypeLocReader16VisitEnumTypeLocENS_11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader16VisitEnumTypeLocENS_11EnumTypeLocE")
  //</editor-fold>
  public void VisitEnumTypeLoc(EnumTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5898,
   FQN="clang::TypeLocReader::VisitElaboratedTypeLoc", NM="_ZN5clang13TypeLocReader22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE")
  //</editor-fold>
  public void VisitElaboratedTypeLoc(ElaboratedTypeLoc TL) {
    TL.setElaboratedKeywordLoc(ReadSourceLocation(Record, Idx));
    TL.setQualifierLoc(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5855,
   FQN="clang::TypeLocReader::VisitAttributedTypeLoc", NM="_ZN5clang13TypeLocReader22VisitAttributedTypeLocENS_17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader22VisitAttributedTypeLocENS_17AttributedTypeLocE")
  //</editor-fold>
  public void VisitAttributedTypeLoc(AttributedTypeLoc TL) {
    TL.setAttrNameLoc(ReadSourceLocation(Record, Idx));
    if (TL.hasAttrOperand()) {
      SourceRange range/*J*/= new SourceRange();
      range.setBegin(ReadSourceLocation(Record, Idx));
      range.setEnd(ReadSourceLocation(Record, Idx));
      TL.setAttrOperandParensRange(/*NO_COPY*/range);
    }
    if (TL.hasAttrExprOperand()) {
      if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
        TL.setAttrExprOperand(Reader.ReadExpr(F));
      } else {
        TL.setAttrExprOperand((Expr /*P*/ )null);
      }
    } else if (TL.hasAttrEnumOperand()) {
      TL.setAttrEnumOperandLoc(ReadSourceLocation(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5871,
   FQN="clang::TypeLocReader::VisitTemplateTypeParmTypeLoc", NM="_ZN5clang13TypeLocReader28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5874,
   FQN="clang::TypeLocReader::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN5clang13TypeLocReader33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5878,
   FQN="clang::TypeLocReader::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN5clang13TypeLocReader37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5882,
   FQN="clang::TypeLocReader::VisitTemplateSpecializationTypeLoc", NM="_ZN5clang13TypeLocReader34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TL) {
    TL.setTemplateKeywordLoc(ReadSourceLocation(Record, Idx));
    TL.setTemplateNameLoc(ReadSourceLocation(Record, Idx));
    TL.setLAngleLoc(ReadSourceLocation(Record, Idx));
    TL.setRAngleLoc(ReadSourceLocation(Record, Idx));
    for (/*uint*/int i = 0, e = TL.getNumArgs(); i != e; ++i)  {
      TL.setArgLocInfo(i, 
          Reader.GetTemplateArgumentLocInfo(F, 
              TL.getTypePtr().getArg(i).getKind(), 
              Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5846,
   FQN="clang::TypeLocReader::VisitAutoTypeLoc", NM="_ZN5clang13TypeLocReader16VisitAutoTypeLocENS_11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader16VisitAutoTypeLocENS_11AutoTypeLocE")
  //</editor-fold>
  public void VisitAutoTypeLoc(AutoTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5902,
   FQN="clang::TypeLocReader::VisitInjectedClassNameTypeLoc", NM="_ZN5clang13TypeLocReader29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE")
  //</editor-fold>
  public void VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5905,
   FQN="clang::TypeLocReader::VisitDependentNameTypeLoc", NM="_ZN5clang13TypeLocReader25VisitDependentNameTypeLocENS_20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitDependentNameTypeLocENS_20DependentNameTypeLocE")
  //</editor-fold>
  public void VisitDependentNameTypeLoc(DependentNameTypeLoc TL) {
    TL.setElaboratedKeywordLoc(ReadSourceLocation(Record, Idx));
    TL.setQualifierLoc(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5910,
   FQN="clang::TypeLocReader::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN5clang13TypeLocReader43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TL) {
    TL.setElaboratedKeywordLoc(ReadSourceLocation(Record, Idx));
    TL.setQualifierLoc(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    TL.setTemplateKeywordLoc(ReadSourceLocation(Record, Idx));
    TL.setTemplateNameLoc(ReadSourceLocation(Record, Idx));
    TL.setLAngleLoc(ReadSourceLocation(Record, Idx));
    TL.setRAngleLoc(ReadSourceLocation(Record, Idx));
    for (/*uint*/int I = 0, E = TL.getNumArgs(); I != E; ++I)  {
      TL.setArgLocInfo(I, 
          Reader.GetTemplateArgumentLocInfo(F, 
              TL.getTypePtr().getArg(I).getKind(), 
              Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5924,
   FQN="clang::TypeLocReader::VisitPackExpansionTypeLoc", NM="_ZN5clang13TypeLocReader25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE")
  //</editor-fold>
  public void VisitPackExpansionTypeLoc(PackExpansionTypeLoc TL) {
    TL.setEllipsisLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5930,
   FQN="clang::TypeLocReader::VisitObjCObjectTypeLoc", NM="_ZN5clang13TypeLocReader22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TL) {
    TL.setHasBaseTypeAsWritten((Record.$at$Const(Idx.$set$postInc()) != 0));
    TL.setTypeArgsLAngleLoc(ReadSourceLocation(Record, Idx));
    TL.setTypeArgsRAngleLoc(ReadSourceLocation(Record, Idx));
    for (/*uint*/int i = 0, e = TL.getNumTypeArgs(); i != e; ++i)  {
      TL.setTypeArgTInfo(i, Reader.GetTypeSourceInfo(F, Record, Idx));
    }
    TL.setProtocolLAngleLoc(ReadSourceLocation(Record, Idx));
    TL.setProtocolRAngleLoc(ReadSourceLocation(Record, Idx));
    for (/*uint*/int i = 0, e = TL.getNumProtocols(); i != e; ++i)  {
      TL.setProtocolLoc(i, ReadSourceLocation(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5927,
   FQN="clang::TypeLocReader::VisitObjCInterfaceTypeLoc", NM="_ZN5clang13TypeLocReader25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public void VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TL) {
    TL.setNameLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5941,
   FQN="clang::TypeLocReader::VisitObjCObjectPointerTypeLoc", NM="_ZN5clang13TypeLocReader29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TL) {
    TL.setStarLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5949,
   FQN="clang::TypeLocReader::VisitPipeTypeLoc", NM="_ZN5clang13TypeLocReader16VisitPipeTypeLocENS_11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader16VisitPipeTypeLocENS_11PipeTypeLocE")
  //</editor-fold>
  public void VisitPipeTypeLoc(PipeTypeLoc TL) {
    TL.setKWLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5944,
   FQN="clang::TypeLocReader::VisitAtomicTypeLoc", NM="_ZN5clang13TypeLocReader18VisitAtomicTypeLocENS_13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader18VisitAtomicTypeLocENS_13AtomicTypeLocE")
  //</editor-fold>
  public void VisitAtomicTypeLoc(AtomicTypeLoc TL) {
    TL.setKWLoc(ReadSourceLocation(Record, Idx));
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitFunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5805,
   FQN="clang::TypeLocReader::VisitFunctionTypeLoc", NM="_ZN5clang13TypeLocReader20VisitFunctionTypeLocENS_15FunctionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader20VisitFunctionTypeLocENS_15FunctionTypeLocE")
  //</editor-fold>
  public void VisitFunctionTypeLoc(FunctionTypeLoc TL) {
    TL.setLocalRangeBegin(ReadSourceLocation(Record, Idx));
    TL.setLParenLoc(ReadSourceLocation(Record, Idx));
    TL.setRParenLoc(ReadSourceLocation(Record, Idx));
    TL.setLocalRangeEnd(ReadSourceLocation(Record, Idx));
    for (/*uint*/int i = 0, e = TL.getNumParams(); i != e; ++i) {
      TL.setParam(i, this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocReader::VisitArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5774,
   FQN="clang::TypeLocReader::VisitArrayTypeLoc", NM="_ZN5clang13TypeLocReader17VisitArrayTypeLocENS_12ArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13TypeLocReader17VisitArrayTypeLocENS_12ArrayTypeLocE")
  //</editor-fold>
  public void VisitArrayTypeLoc(ArrayTypeLoc TL) {
    TL.setLBracketLoc(ReadSourceLocation(Record, Idx));
    TL.setRBracketLoc(ReadSourceLocation(Record, Idx));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      TL.setSizeExpr(Reader.ReadExpr(F));
    } else {
      TL.setSizeExpr((Expr /*P*/ )null);
    }
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", F=" + F // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Idx=" + Idx // NOI18N
              + super.toString(); // NOI18N
  }
}
