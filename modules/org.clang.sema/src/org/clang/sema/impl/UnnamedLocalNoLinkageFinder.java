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

package org.clang.sema.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4029,
 FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinderE")
//</editor-fold>
public class UnnamedLocalNoLinkageFinder implements /*public*/ TypeVisitor<UnnamedLocalNoLinkageFinder, Boolean> {
  private final Sema /*&*/ S;
  private SourceRange SR;
  
  /*typedef TypeVisitor<UnnamedLocalNoLinkageFinder, bool> inherited*/
//  public final class inherited extends TypeVisitor<UnnamedLocalNoLinkageFinder, boolean>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::UnnamedLocalNoLinkageFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4038,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::UnnamedLocalNoLinkageFinder", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinderC1ERN5clang4SemaENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinderC1ERN5clang4SemaENS1_11SourceRangeE")
  //</editor-fold>
  public UnnamedLocalNoLinkageFinder(final Sema /*&*/ S, SourceRange SR) {
    // : TypeVisitor<UnnamedLocalNoLinkageFinder, bool>(), S(S), SR(SR) 
    //START JInit
    $TypeVisitor();
    this./*&*/S=/*&*/S;
    this.SR = new SourceRange(SR);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4040,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::Visit", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder5VisitEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder5VisitEN5clang8QualTypeE")
  //</editor-fold>
  public Boolean Visit(QualType T) {
    return Visit(T.getTypePtr());
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4057,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitBuiltinType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitBuiltinTypeEPKN5clang11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitBuiltinTypeEPKN5clang11BuiltinTypeE")
  //</editor-fold>
  public Boolean VisitBuiltinType(/*const*/ BuiltinType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4061,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitComplexType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitComplexTypeEPKN5clang11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitComplexTypeEPKN5clang11ComplexTypeE")
  //</editor-fold>
  public Boolean VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4065,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPointerType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitPointerTypeEPKN5clang11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitPointerTypeEPKN5clang11PointerTypeE")
  //</editor-fold>
  public Boolean VisitPointerType(/*const*/ PointerType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4069,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitBlockPointerType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE")
  //</editor-fold>
  public Boolean VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 66,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitReferenceType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder18VisitReferenceTypeEPKN5clang13ReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder18VisitReferenceTypeEPKN5clang13ReferenceTypeE")
  //</editor-fold>
  public Boolean VisitReferenceType(/*const*/ ReferenceType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4074,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitLValueReferenceType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitLValueReferenceTypeEPKN5clang19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitLValueReferenceTypeEPKN5clang19LValueReferenceTypeE")
  //</editor-fold>
  public Boolean VisitLValueReferenceType(/*const*/ LValueReferenceType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4079,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitRValueReferenceType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitRValueReferenceTypeEPKN5clang19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitRValueReferenceTypeEPKN5clang19RValueReferenceTypeE")
  //</editor-fold>
  public Boolean VisitRValueReferenceType(/*const*/ RValueReferenceType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4084,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitMemberPointerType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  public Boolean VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    return Visit(T.getPointeeType()) || Visit(new QualType(T.__getClass(), 0));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 70,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitArrayType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder14VisitArrayTypeEPKN5clang9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder14VisitArrayTypeEPKN5clang9ArrayTypeE")
  //</editor-fold>
  public Boolean VisitArrayType(/*const*/ ArrayType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4089,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitConstantArrayType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE")
  //</editor-fold>
  public Boolean VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4094,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitIncompleteArrayType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitIncompleteArrayTypeEPKN5clang19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitIncompleteArrayTypeEPKN5clang19IncompleteArrayTypeE")
  //</editor-fold>
  public Boolean VisitIncompleteArrayType(/*const*/ IncompleteArrayType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4099,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitVariableArrayType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE")
  //</editor-fold>
  public Boolean VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4104,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentSizedArrayType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE")
  //</editor-fold>
  public Boolean VisitDependentSizedArrayType(/*const*/ DependentSizedArrayType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4109,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentSizedExtVectorType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public Boolean VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4114,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitVectorType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  public Boolean VisitVectorType(/*const*/ VectorType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4118,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitExtVectorType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder18VisitExtVectorTypeEPKN5clang13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder18VisitExtVectorTypeEPKN5clang13ExtVectorTypeE")
  //</editor-fold>
  public Boolean VisitExtVectorType(/*const*/ ExtVectorType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 78,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitFunctionTypeEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitFunctionTypeEPKN5clang12FunctionTypeE")
  //</editor-fold>
  public Boolean VisitFunctionType(/*const*/ FunctionType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4122,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionProtoType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE")
  //</editor-fold>
  public Boolean VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    for (final /*const*/ QualType /*&*/ A : T.param_types()) {
      if (Visit(new QualType(A))) {
        return true;
      }
    }
    
    return Visit(T.getReturnType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4132,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitFunctionNoProtoType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitFunctionNoProtoTypeEPKN5clang19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitFunctionNoProtoTypeEPKN5clang19FunctionNoProtoTypeE")
  //</editor-fold>
  public Boolean VisitFunctionNoProtoType(/*const*/ FunctionNoProtoType /*P*/ T) {
    return Visit(T.getReturnType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4137,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitUnresolvedUsingType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE")
  //</editor-fold>
  public Boolean VisitUnresolvedUsingType(/*const*/ UnresolvedUsingType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitParenType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder14VisitParenTypeEPKN5clang9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder14VisitParenTypeEPKN5clang9ParenTypeE")
  //</editor-fold>
  public Boolean VisitParenType(/*const*/ ParenType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypedefType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitTypedefTypeEPKN5clang11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitTypedefTypeEPKN5clang11TypedefTypeE")
  //</editor-fold>
  public Boolean VisitTypedefType(/*const*/ TypedefType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAdjustedType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitAdjustedTypeEPKN5clang12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitAdjustedTypeEPKN5clang12AdjustedTypeE")
  //</editor-fold>
  public Boolean VisitAdjustedType(/*const*/ AdjustedType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDecayedType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitDecayedTypeEPKN5clang11DecayedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder16VisitDecayedTypeEPKN5clang11DecayedTypeE")
  //</editor-fold>
  public Boolean VisitDecayedType(/*const*/ DecayedType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4142,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypeOfExprType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE")
  //</editor-fold>
  public Boolean VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4146,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTypeOfType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitTypeOfTypeEPKN5clang10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitTypeOfTypeEPKN5clang10TypeOfTypeE")
  //</editor-fold>
  public Boolean VisitTypeOfType(/*const*/ TypeOfType /*P*/ T) {
    return Visit(T.getUnderlyingType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4150,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDecltypeType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitDecltypeTypeEPKN5clang12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder17VisitDecltypeTypeEPKN5clang12DecltypeTypeE")
  //</editor-fold>
  public Boolean VisitDecltypeType(/*const*/ DecltypeType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4154,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitUnaryTransformType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE")
  //</editor-fold>
  public Boolean VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTagType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 90,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTagType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder12VisitTagTypeEPKN5clang7TagTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder12VisitTagTypeEPKN5clang7TagTypeE")
  //</editor-fold>
  public Boolean VisitTagType(/*const*/ TagType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4163,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitRecordType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitRecordTypeEPKN5clang10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitRecordTypeEPKN5clang10RecordTypeE")
  //</editor-fold>
  public Boolean VisitRecordType(/*const*/ RecordType /*P*/ T) {
    return VisitTagDecl(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4167,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitEnumType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitEnumTypeEPKN5clang8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitEnumTypeEPKN5clang8EnumTypeE")
  //</editor-fold>
  public Boolean VisitEnumType(/*const*/ EnumType /*P*/ T) {
    return VisitTagDecl(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitElaboratedType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitElaboratedTypeEPKN5clang14ElaboratedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitElaboratedTypeEPKN5clang14ElaboratedTypeE")
  //</editor-fold>
  public Boolean VisitElaboratedType(/*const*/ ElaboratedType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAttributedType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitAttributedTypeEPKN5clang14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitAttributedTypeEPKN5clang14AttributedTypeE")
  //</editor-fold>
  public Boolean VisitAttributedType(/*const*/ AttributedType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4171,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTemplateTypeParmType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  public Boolean VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitSubstTemplateTypeParmType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public Boolean VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4176,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitSubstTemplateTypeParmPackType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public Boolean VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4181,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTemplateSpecializationType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE")
  //</editor-fold>
  public Boolean VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4159,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAutoType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitAutoTypeEPKN5clang8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitAutoTypeEPKN5clang8AutoTypeE")
  //</editor-fold>
  public Boolean VisitAutoType(/*const*/ AutoType /*P*/ T) {
    return Visit(T.getDeducedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4186,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitInjectedClassNameType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE")
  //</editor-fold>
  public Boolean VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    return VisitTagDecl(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4191,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentNameType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitDependentNameTypeEPKN5clang17DependentNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitDependentNameTypeEPKN5clang17DependentNameTypeE")
  //</editor-fold>
  public Boolean VisitDependentNameType(/*const*/ DependentNameType /*P*/ T) {
    return VisitNestedNameSpecifier(T.getQualifier());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4196,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitDependentTemplateSpecializationType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder40VisitDependentTemplateSpecializationTypeEPKN5clang35DependentTemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder40VisitDependentTemplateSpecializationTypeEPKN5clang35DependentTemplateSpecializationTypeE")
  //</editor-fold>
  public Boolean VisitDependentTemplateSpecializationType(/*const*/ DependentTemplateSpecializationType /*P*/ T) {
    return VisitNestedNameSpecifier(T.getQualifier());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4201,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPackExpansionType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE")
  //</editor-fold>
  public Boolean VisitPackExpansionType(/*const*/ PackExpansionType /*P*/ T) {
    return Visit(T.getPattern());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4206,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCObjectType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitObjCObjectTypeEPKN5clang14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder19VisitObjCObjectTypeEPKN5clang14ObjCObjectTypeE")
  //</editor-fold>
  public Boolean VisitObjCObjectType(/*const*/ ObjCObjectType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4210,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCInterfaceType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE")
  //</editor-fold>
  public Boolean VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4215,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitObjCObjectPointerType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE")
  //</editor-fold>
  public Boolean VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ $Prm0) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4224,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitPipeType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitPipeTypeEPKN5clang8PipeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder13VisitPipeTypeEPKN5clang8PipeTypeE")
  //</editor-fold>
  public Boolean VisitPipeType(/*const*/ PipeType /*P*/ T) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4220,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitAtomicType", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitAtomicTypeEPKN5clang10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder15VisitAtomicTypeEPKN5clang10AtomicTypeE")
  //</editor-fold>
  public Boolean VisitAtomicType(/*const*/ AtomicType /*P*/ T) {
    return Visit(T.getValueType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4228,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitTagDecl", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder12VisitTagDeclEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder12VisitTagDeclEPKN5clang7TagDeclE")
  //</editor-fold>
  public Boolean VisitTagDecl(/*const*/ TagDecl /*P*/ Tag) {
    if (Tag.getDeclContext$Const().isFunctionOrMethod()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SR.getBegin(), 
                    S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_arg_local_type : diag.ext_template_arg_local_type)), 
                S.Context.getTypeDeclType(Tag)), SR));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (!Tag.hasNameForLinkage()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SR.getBegin(), 
                S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_arg_unnamed_type : diag.ext_template_arg_unnamed_type)), SR));
        $c$.clean($c$.track(S.Diag(Tag.getLocation(), diag.note_template_unnamed_type_here)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4250,
   FQN="(anonymous namespace)::UnnamedLocalNoLinkageFinder::VisitNestedNameSpecifier", NM="_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitNestedNameSpecifierEPN5clang19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_127UnnamedLocalNoLinkageFinder24VisitNestedNameSpecifierEPN5clang19NestedNameSpecifierE")
  //</editor-fold>
  public Boolean VisitNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) {
    if ((NNS.getPrefix() != null) && VisitNestedNameSpecifier(NNS.getPrefix())) {
      return true;
    }
    switch (NNS.getKind()) {
     case Identifier:
     case Namespace:
     case NamespaceAlias:
     case Global:
     case Super:
      return false;
     case TypeSpec:
     case TypeSpecWithTemplate:
      return Visit(new QualType(NNS.getAsType(), 0));
    }
    throw new llvm_unreachable("Invalid NestedNameSpecifier::Kind!");
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SR=" + SR // NOI18N
              + super.toString(); // NOI18N
  }
}
