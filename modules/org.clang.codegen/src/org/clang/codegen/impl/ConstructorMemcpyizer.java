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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.codegen.impl.CGClassStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1127,
 FQN="(anonymous namespace)::ConstructorMemcpyizer", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizerE")
//</editor-fold>
public class ConstructorMemcpyizer extends /*public*/ FieldMemcpyizer implements Destructors.ClassWithDestructor {
/*private:*/
  /// Get source argument for copy constructor. Returns null if not a copy
  /// constructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::getTrivialCopySource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1131,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::getTrivialCopySource", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizer20getTrivialCopySourceERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizer20getTrivialCopySourceERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclERNS2_15FunctionArgListE")
  //</editor-fold>
  private static /*const*/ VarDecl /*P*/ getTrivialCopySource(final CodeGenFunction /*&*/ CGF, 
                      /*const*/ CXXConstructorDecl /*P*/ CD, 
                      final FunctionArgList /*&*/ Args) {
    if (CD.isCopyOrMoveConstructor() && CD.isDefaulted()) {
      return Args.$at(CGF.CGM.getCXXABI().getSrcArgforCopyCtor(CD, Args));
    }
    return null;
  }

  
  // Returns true if a CXXCtorInitializer represents a member initialization
  // that can be rolled into a memcpy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::isMemberInitMemcpyable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1141,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::isMemberInitMemcpyable", NM="_ZNK12_GLOBAL__N_121ConstructorMemcpyizer22isMemberInitMemcpyableEPN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK12_GLOBAL__N_121ConstructorMemcpyizer22isMemberInitMemcpyableEPN5clang18CXXCtorInitializerE")
  //</editor-fold>
  private boolean isMemberInitMemcpyable(CXXCtorInitializer /*P*/ MemberInit) /*const*/ {
    if (!MemcpyableCtor) {
      return false;
    }
    FieldDecl /*P*/ Field = MemberInit.getMember();
    assert ((Field != null)) : "No field for member init.";
    QualType FieldType = Field.getType();
    CXXConstructExpr /*P*/ CE = dyn_cast_CXXConstructExpr(MemberInit.getInit());
    
    // Bail out on non-memcpyable, not-trivially-copyable members.
    if (!((CE != null) && isMemcpyEquivalentSpecialMember(CE.getConstructor()))
       && !(FieldType.isTriviallyCopyableType(CGF.getContext())
       || FieldType.$arrow().isReferenceType())) {
      return false;
    }
    
    // Bail out on volatile fields.
    if (!isMemcpyableField(Field)) {
      return false;
    }
    
    // Otherwise we're good.
    return true;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::ConstructorMemcpyizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1164,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::ConstructorMemcpyizer", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizerC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclERNS2_15FunctionArgListE")
  //</editor-fold>
  public ConstructorMemcpyizer(final CodeGenFunction /*&*/ CGF, /*const*/ CXXConstructorDecl /*P*/ CD, 
      final FunctionArgList /*&*/ Args) {
    // : FieldMemcpyizer(CGF, CD->getParent(), getTrivialCopySource(CGF, CD, Args)), ConstructorDecl(CD), MemcpyableCtor(CD->isDefaulted() && CD->isCopyOrMoveConstructor() && CGF.getLangOpts().getGC() == LangOptions::NonGC), Args(Args), AggregatedInits() 
    //START JInit
    super(CGF, CD.getParent$Const(), ConstructorMemcpyizer.getTrivialCopySource(CGF, CD, Args));
    this.ConstructorDecl = CD;
    this.MemcpyableCtor = CD.isDefaulted()
       && CD.isCopyOrMoveConstructor()
       && CGF.getLangOpts().getGC() == LangOptions.GCMode.NonGC;
    this./*&*/Args=/*&*/Args;
    this.AggregatedInits = new SmallVector<CXXCtorInitializer /*P*/ >(16, (CXXCtorInitializer /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::addMemberInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1173,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::addMemberInitializer", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizer20addMemberInitializerEPN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizer20addMemberInitializerEPN5clang18CXXCtorInitializerE")
  //</editor-fold>
  public void addMemberInitializer(CXXCtorInitializer /*P*/ MemberInit) {
    if (isMemberInitMemcpyable(MemberInit)) {
      AggregatedInits.push_back(MemberInit);
      addMemcpyableField(MemberInit.getMember());
    } else {
      emitAggregatedInits();
      EmitMemberInitializer(CGF, ConstructorDecl.getParent$Const(), MemberInit, 
          ConstructorDecl, Args);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::emitAggregatedInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1184,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::emitAggregatedInits", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizer19emitAggregatedInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizer19emitAggregatedInitsEv")
  //</editor-fold>
  public void emitAggregatedInits() {
    if ($lesseq_uint(AggregatedInits.size(), 1)) {
      // This memcpy is too small to be worthwhile. Fall back on default
      // codegen.
      if (!AggregatedInits.empty()) {
        CopyingValueRepresentation CVR = null;
        try {
          CVR/*J*/= new CopyingValueRepresentation(CGF);
          EmitMemberInitializer(CGF, ConstructorDecl.getParent$Const(), 
              AggregatedInits.$at(0), ConstructorDecl, Args);
          AggregatedInits.clear();
        } finally {
          if (CVR != null) { CVR.$destroy(); }
        }
      }
      reset();
      return;
    }
    
    pushEHDestructors();
    emitMemcpy();
    AggregatedInits.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::pushEHDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1203,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::pushEHDestructors", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizer17pushEHDestructorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizer17pushEHDestructorsEv")
  //</editor-fold>
  public void pushEHDestructors() {
    Address ThisPtr = CGF.LoadCXXThisAddress();
    QualType RecordTy = CGF.getContext().getTypeDeclType(ClassDecl);
    LValue LHS = CGF.MakeAddrLValue(new Address(ThisPtr), new QualType(RecordTy));
    
    for (/*uint*/int i = 0; $less_uint(i, AggregatedInits.size()); ++i) {
      CXXCtorInitializer /*P*/ MemberInit = AggregatedInits.$at(i);
      QualType FieldType = MemberInit.getAnyMember().getType();
      QualType.DestructionKind dtorKind = FieldType.isDestructedType();
      if (!CGF.needsEHCleanup(dtorKind)) {
        continue;
      }
      LValue FieldLHS = new LValue(LHS);
      EmitLValueForAnyFieldInitialization(CGF, MemberInit, FieldLHS);
      CGF.pushEHDestroy(dtorKind, FieldLHS.getAddress(), new QualType(FieldType));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1220,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::finish", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizer6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizer6finishEv")
  //</editor-fold>
  public void finish() {
    emitAggregatedInits();
  }

/*private:*/
  private /*const*/ CXXConstructorDecl /*P*/ ConstructorDecl;
  private boolean MemcpyableCtor;
  private final FunctionArgList /*&*/ Args;
  private SmallVector<CXXCtorInitializer /*P*/ > AggregatedInits;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstructorMemcpyizer::~ConstructorMemcpyizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1127,
   FQN="(anonymous namespace)::ConstructorMemcpyizer::~ConstructorMemcpyizer", NM="_ZN12_GLOBAL__N_121ConstructorMemcpyizerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_121ConstructorMemcpyizerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AggregatedInits.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ConstructorDecl=" + "[CXXConstructorDecl]" // NOI18N
              + ", MemcpyableCtor=" + MemcpyableCtor // NOI18N
              + ", Args=" + Args // NOI18N
              + ", AggregatedInits=" + AggregatedInits // NOI18N
              + super.toString(); // NOI18N
  }
}
