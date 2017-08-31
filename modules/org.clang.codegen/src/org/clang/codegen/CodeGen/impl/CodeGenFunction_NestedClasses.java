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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.FunctionType;
import org.clang.codegen.java.CodegenRTTI;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_NestedClasses">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_NestedClasses",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_NestedEnums ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValueE;_ZN5clang7CodeGen15CodeGenFunction11FinallyInfoE;_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeE;_ZN5clang7CodeGen15CodeGenFunction13BreakContinueE;_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeE;_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndE;_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionE;_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeE;_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE;_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIIE;_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingE;_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionE;_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationE;_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluationE;_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeE;_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataE;_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeE;_ZN5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeaderE;_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeE;_ZN5clang7CodeGen15CodeGenFunction4VPtrE;_ZN5clang7CodeGen15CodeGenFunction8JumpDestE; -static-type=CodeGenFunction_NestedClasses -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_NestedClasses extends CodeGenFunction_NestedEnums {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_NestedClasses(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

/// A jump destination is an abstract label, branching to which may
/// require a jump out through normal cleanups.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 113,
 FQN="clang::CodeGen::CodeGenFunction::JumpDest", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestE")
//</editor-fold>
public static class/*struct*/ JumpDest implements NativePOD<JumpDest>, NativeMoveable<JumpDest> {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 114,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1Ev")
  //</editor-fold>
  public JumpDest() {
    // : Block(null), ScopeDepth(), Index(0) 
    //START JInit
    this.Block = null;
    this.ScopeDepth = new EHScopeStack.stable_iterator();
    this.Index = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 115,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1EPN4llvm10BasicBlockENS0_12EHScopeStack15stable_iteratorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1EPN4llvm10BasicBlockENS0_12EHScopeStack15stable_iteratorEj")
  //</editor-fold>
  public JumpDest(BasicBlock /*P*/ Block, 
      EHScopeStack.stable_iterator Depth, 
      /*uint*/int Index) {
    // : Block(Block), ScopeDepth(Depth), Index(Index) 
    //START JInit
    this.Block = Block;
    this.ScopeDepth = new EHScopeStack.stable_iterator(Depth);
    this.Index = Index;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 120,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::isValid", NM="_ZNK5clang7CodeGen15CodeGenFunction8JumpDest7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction8JumpDest7isValidEv")
  //</editor-fold>
  public final boolean isValid() /*const*/ {
    return Block != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 121,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::getBlock", NM="_ZNK5clang7CodeGen15CodeGenFunction8JumpDest8getBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction8JumpDest8getBlockEv")
  //</editor-fold>
  public final BasicBlock /*P*/ getBlock() /*const*/ {
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::getScopeDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 122,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::getScopeDepth", NM="_ZNK5clang7CodeGen15CodeGenFunction8JumpDest13getScopeDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction8JumpDest13getScopeDepthEv")
  //</editor-fold>
  public final EHScopeStack.stable_iterator getScopeDepth() /*const*/ {
    return new EHScopeStack.stable_iterator(ScopeDepth);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::getDestIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 123,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::getDestIndex", NM="_ZNK5clang7CodeGen15CodeGenFunction8JumpDest12getDestIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction8JumpDest12getDestIndexEv")
  //</editor-fold>
  public final /*uint*/int getDestIndex() /*const*/ {
    return Index;
  }

  
  // This should be used cautiously.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::setScopeDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 126,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::setScopeDepth", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDest13setScopeDepthENS0_12EHScopeStack15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDest13setScopeDepthENS0_12EHScopeStack15stable_iteratorE")
  //</editor-fold>
  public final void setScopeDepth(EHScopeStack.stable_iterator depth) {
    ScopeDepth.$assign(depth);
  }

/*private:*/
  protected/*private*/ BasicBlock /*P*/ Block;
  protected/*private*/ EHScopeStack.stable_iterator ScopeDepth;
  protected/*private*/ /*uint*/int Index;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 113,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1ERKS2_")
  //</editor-fold>
  public /*inline*/ JumpDest(final /*const*/ JumpDest /*&*/ $Prm0) {
    // : Block(.Block), ScopeDepth(.ScopeDepth), Index(.Index) 
    //START JInit
    this.Block = $Prm0.Block;
    this.ScopeDepth = new EHScopeStack.stable_iterator($Prm0.ScopeDepth);
    this.Index = $Prm0.Index;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 113,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::JumpDest", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestC1EOS2_")
  //</editor-fold>
  public /*inline*/ JumpDest(JD$Move _dparam, final JumpDest /*&&*/$Prm0) {
    // : Block(static_cast<JumpDest &&>().Block), ScopeDepth(static_cast<JumpDest &&>().ScopeDepth), Index(static_cast<JumpDest &&>().Index) 
    //START JInit
    this.Block = $Prm0.Block;
    this.ScopeDepth = new EHScopeStack.stable_iterator(JD$Move.INSTANCE, $Prm0.ScopeDepth);
    this.Index = $Prm0.Index;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 113,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestaSEOS2_")
  //</editor-fold>
  public final /*inline*/ JumpDest /*&*/ $assignMove(final JumpDest /*&&*/$Prm0) {
    this.Block = $Prm0.Block;
    this.ScopeDepth.$assignMove($Prm0.ScopeDepth);
    this.Index = $Prm0.Index;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::JumpDest::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 113,
   FQN="clang::CodeGen::CodeGenFunction::JumpDest::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction8JumpDestaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8JumpDestaSERKS2_")
  //</editor-fold>
  public final /*inline*/ JumpDest /*&*/ $assign(final /*const*/ JumpDest /*&*/ $Prm0) {
    this.Block = $Prm0.Block;
    this.ScopeDepth.$assign($Prm0.ScopeDepth);
    this.Index = $Prm0.Index;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public JumpDest clone() {
    return new JumpDest(this);
  }
  
  @Override public JumpDest move() {
    return new JumpDest(JD$Move.INSTANCE, this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + "Block=" + Block // NOI18N
              + ", ScopeDepth=" + ScopeDepth // NOI18N
              + ", Index=" + Index; // NOI18N
  }
}

/// \brief API for captured statement code generation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 177,
 FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
//</editor-fold>
public static class CGCapturedStmtInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::CGCapturedStmtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 179,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::CGCapturedStmtInfo", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoC1ENS_18CapturedRegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoC1ENS_18CapturedRegionKindE")
  //</editor-fold>
  public /*explicit*/ CGCapturedStmtInfo() {
    this(CapturedRegionKind.CR_Default);
  }
  public /*explicit*/ CGCapturedStmtInfo(CapturedRegionKind K/*= CR_Default*/) {
    // : Kind(K), CaptureFields(), ThisValue(null), CXXThisFieldDecl(null) 
    //START JInit
    this.Kind = K;
    this.CaptureFields = new SmallDenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    this.ThisValue = null;
    this.CXXThisFieldDecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::CGCapturedStmtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 181,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::CGCapturedStmtInfo", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoC1ERKNS_12CapturedStmtENS_18CapturedRegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoC1ERKNS_12CapturedStmtENS_18CapturedRegionKindE")
  //</editor-fold>
  public /*explicit*/ CGCapturedStmtInfo(final /*const*/ CapturedStmt /*&*/ S) {
    this(S, 
      CapturedRegionKind.CR_Default);
  }
  public /*explicit*/ CGCapturedStmtInfo(final /*const*/ CapturedStmt /*&*/ S, 
      CapturedRegionKind K/*= CR_Default*/) {
    // : Kind(K), CaptureFields(), ThisValue(null), CXXThisFieldDecl(null) 
    //START JInit
    this.Kind = K;
    this.CaptureFields = new SmallDenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    this.ThisValue = null;
    this.CXXThisFieldDecl = null;
    //END JInit

    DeclContext.specific_decl_iterator<FieldDecl> Field = S.getCapturedRecordDecl().field_begin();
    for (type$ptr</*const*/ CapturedStmt.Capture /*P*/ > I = $tryClone(S.capture_begin$Const()), 
        /*P*/ E = $tryClone(S.capture_end());
         $noteq_ptr(I, E); I.$preInc() , Field.$preInc()) {
      if (I./*->*/$star().capturesThis()) {
        CXXThisFieldDecl = Field.$star();
      } else if (I./*->*/$star().capturesVariable()) {
        CaptureFields.$set(I./*->*/$star().getCapturedVar(), Field.$star());
      } else if (I./*->*/$star().capturesVariableByCopy()) {
        CaptureFields.$set(I./*->*/$star().getCapturedVar(), Field.$star());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::~CGCapturedStmtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1896,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::~CGCapturedStmtInfo", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    CaptureFields.$destroy();
    //END JDestroy
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 201,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getKind", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo7getKindEv")
  //</editor-fold>
  public final CapturedRegionKind getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::setContextValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 203,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::setContextValue", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo15setContextValueEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo15setContextValueEPN4llvm5ValueE")
  //</editor-fold>
  public /*virtual*/ void setContextValue(Value /*P*/ V) {
    ThisValue = V;
  }

  // \brief Retrieve the value of the context parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getContextValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 205,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getContextValue", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo15getContextValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo15getContextValueEv")
  //</editor-fold>
  public /*virtual*/ Value /*P*/ getContextValue() /*const*/ {
    return ThisValue;
  }

  
  /// \brief Lookup the captured field decl for a variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 208,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::lookup", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo6lookupEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo6lookupEPKNS_7VarDeclE")
  //</editor-fold>
  public /*virtual*/ /*const*/ FieldDecl /*P*/ lookup(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    return CaptureFields.lookup(VD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::isCXXThisExprCaptured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 212,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::isCXXThisExprCaptured", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo21isCXXThisExprCapturedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo21isCXXThisExprCapturedEv")
  //</editor-fold>
  public final boolean isCXXThisExprCaptured() /*const*/ {
    return getThisFieldDecl() != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getThisFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 213,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getThisFieldDecl", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo16getThisFieldDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo16getThisFieldDeclEv")
  //</editor-fold>
  public /*virtual*/ FieldDecl /*P*/ getThisFieldDecl() /*const*/ {
    return CXXThisFieldDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 215,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::classof", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo7classofEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo7classofEPKS2_")
  //</editor-fold>
  public static boolean classof(/*const*/ CGCapturedStmtInfo /*P*/ $Prm0) {
    return true;
  }

  
  /// \brief Emit the captured statement body.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::EmitBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 220,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::EmitBody", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo8EmitBodyERS1_PKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo8EmitBodyERS1_PKNS_4StmtE")
  //</editor-fold>
  public /*virtual*/ void EmitBody(final CodeGenFunction /*&*/ CGF, /*const*/ Stmt /*P*/ S) {
    CGF.incrementProfileCounter(S);
    CGF.EmitStmt(S);
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 226,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtInfo::getHelperName", NM="_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfo13getHelperNameEv")
  //</editor-fold>
  public /*virtual*/ StringRef getHelperName() /*const*/ {
    return new StringRef(/*KEEP_STR*/"__captured_stmt");
  }

/*private:*/
  /// \brief The kind of captured statement being generated.
  protected/*private*/ CapturedRegionKind Kind;
  
  /// \brief Keep the map between VarDecl and FieldDecl.
  protected/*private*/ SmallDenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ > CaptureFields;
  
  /// \brief The base address of the captured record, passed in as the first
  /// argument of the parallel region function.
  protected/*private*/ Value /*P*/ ThisValue;
  
  /// \brief Captured 'this' type.
  protected/*private*/ FieldDecl /*P*/ CXXThisFieldDecl;
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", CaptureFields=" + "[SmallDenseMap$VarDecl$FieldDecl]" // NOI18N
              + ", ThisValue=" + ThisValue // NOI18N
              + ", CXXThisFieldDecl=" + "[FieldDecl]"; // NOI18N
  }
}

/// \brief RAII for correct setting/restoring of CapturedStmtInfo.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 245,
 FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIIE")
//</editor-fold>
public static class CGCapturedStmtRAII implements Destructors.ClassWithDestructor {
/*private:*/
  protected/*private*/ final CodeGenFunction /*&*/ CGF;
  protected/*private*/ CGCapturedStmtInfo /*P*/ PrevCapturedStmtInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII::CGCapturedStmtRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 250,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII::CGCapturedStmtRAII", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIIC1ERS1_PNS1_18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIIC1ERS1_PNS1_18CGCapturedStmtInfoE")
  //</editor-fold>
  public CGCapturedStmtRAII(final CodeGenFunction /*&*/ CGF, 
      CGCapturedStmtInfo /*P*/ NewCapturedStmtInfo) {
    // : CGF(CGF), PrevCapturedStmtInfo(CGF.CapturedStmtInfo) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.PrevCapturedStmtInfo = CGF.CapturedStmtInfo;
    //END JInit
    CGF.CapturedStmtInfo = NewCapturedStmtInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII::~CGCapturedStmtRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 255,
   FQN="clang::CodeGen::CodeGenFunction::CGCapturedStmtRAII::~CGCapturedStmtRAII", NM="_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18CGCapturedStmtRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.CapturedStmtInfo = PrevCapturedStmtInfo;
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", PrevCapturedStmtInfo=" + PrevCapturedStmtInfo; // NOI18N
  }
}

/// \brief RAII object to set/unset CodeGenFunction::IsSanitizerScope.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::SanitizerScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 265,
 FQN="clang::CodeGen::CodeGenFunction::SanitizerScope", NM="_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeE")
//</editor-fold>
public static class SanitizerScope implements Destructors.ClassWithDestructor {
  protected/*private*/ CodeGenFunction /*P*/ CGF;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::SanitizerScope::SanitizerScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1898,
   FQN="clang::CodeGen::CodeGenFunction::SanitizerScope::SanitizerScope", NM="_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeC1EPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeC1EPS1_")
  //</editor-fold>
  public SanitizerScope(CodeGenFunction /*P*/ CGF) {
    // : CGF(CGF) 
    //START JInit
    this.CGF = CGF;
    //END JInit
    assert (!CGF.IsSanitizerScope);
    CGF.IsSanitizerScope = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::SanitizerScope::~SanitizerScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1904,
   FQN="clang::CodeGen::CodeGenFunction::SanitizerScope::~SanitizerScope", NM="_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14SanitizerScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.IsSanitizerScope = false;
  }


  
  @Override public String toString() {
    return "" + "CGF=" + CGF; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CallLifetimeEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 305,
 FQN="clang::CodeGen::CodeGenFunction::CallLifetimeEnd", NM="_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndE")
//</editor-fold>
public static final class CallLifetimeEnd extends /*public*/ EHScopeStack.Cleanup {
  protected/*private*/ Value /*P*/ Addr;
  protected/*private*/ Value /*P*/ Size;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::CallLifetimeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 310,
   FQN="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::CallLifetimeEnd", NM="_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndC1ENS0_7AddressEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndC1ENS0_7AddressEPN4llvm5ValueE")
  //</editor-fold>
  public CallLifetimeEnd(Address addr, Value /*P*/ size) {
    // : EHScopeStack::Cleanup(), Addr(addr.getPointer()), Size(size) 
    //START JInit
    super();
    this.Addr = addr.getPointer();
    this.Size = size;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 313,
   FQN="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::Emit", NM="_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEnd4EmitERS1_NS0_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEnd4EmitERS1_NS0_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    CGF.EmitLifetimeEnd(Size, Addr);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::CallLifetimeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 305,
   FQN="clang::CodeGen::CodeGenFunction::CallLifetimeEnd::CallLifetimeEnd", NM="_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15CallLifetimeEndC1EOS2_")
  //</editor-fold>
  public /*inline*/ CallLifetimeEnd(JD$Move _dparam, final CallLifetimeEnd /*&&*/$Prm0) {
    // : EHScopeStack::Cleanup(static_cast<CallLifetimeEnd &&>()), Addr(static_cast<CallLifetimeEnd &&>().Addr), Size(static_cast<CallLifetimeEnd &&>().Size) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Addr = $Prm0.Addr;
    this.Size = $Prm0.Size;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Addr=" + Addr // NOI18N
              + ", Size=" + Size // NOI18N
              + super.toString(); // NOI18N
  }
}

/// Header for data within LifetimeExtendedCleanupStack.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 319,
 FQN="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader", NM="_ZN5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeaderE")
//</editor-fold>
public static class/*struct*/ LifetimeExtendedCleanupHeader {
  /// The size of the following cleanup object.
  public /*uint*/int Size;
  /// The kind of cleanup to push: a value from the CleanupKind enumeration.
  public /*CleanupKind*//*uint*/int Kind;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 325,
   FQN="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::getSize", NM="_ZNK5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeader7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeader7getSizeEv")
  //</editor-fold>
  public final /*size_t*/int getSize() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 326,
   FQN="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::getKind", NM="_ZNK5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeader7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeader7getKindEv")
  //</editor-fold>
  public final /*CleanupKind*//*uint*/int getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::LifetimeExtendedCleanupHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 319,
   FQN="clang::CodeGen::CodeGenFunction::LifetimeExtendedCleanupHeader::LifetimeExtendedCleanupHeader", NM="_ZN5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeaderC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29LifetimeExtendedCleanupHeaderC1ERKS2_")
  //</editor-fold>
  public /*inline*/ LifetimeExtendedCleanupHeader(final /*const*/ LifetimeExtendedCleanupHeader /*&*/ $Prm0) {
    // : Size(.Size), Kind(.Kind) 
    //START JInit
    this.Size = $Prm0.Size;
    this.Kind = $Prm0.Kind;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public LifetimeExtendedCleanupHeader(int Size, int Kind) {
    this.Size = Size;
    this.Kind = Kind;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
  }

/// A class controlling the emission of a finally block.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinallyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 372,
 FQN="clang::CodeGen::CodeGenFunction::FinallyInfo", NM="_ZN5clang7CodeGen15CodeGenFunction11FinallyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11FinallyInfoE")
//</editor-fold>
public static class FinallyInfo {
  /// Where the catchall's edge through the cleanup should go.
  protected/*private*/ JumpDest RethrowDest;
  
  /// A function to call to enter the catch.
  protected/*private*/ Constant /*P*/ BeginCatchFn;
  
  /// An i1 variable indicating whether or not the @finally is
  /// running for an exception.
  protected/*private*/ AllocaInst /*P*/ ForEHVar;
  
  /// An i8* variable into which the exception pointer to rethrow
  /// has been saved.
  protected/*private*/ AllocaInst /*P*/ SavedExnVar;
/*public:*/
  // end anonymous namespace
  
  /// Enters a finally block for an implementation using zero-cost
  /// exceptions.  This is mostly general, but hard-codes some
  /// language/ABI-specific behavior in the catch-all sections.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinallyInfo::enter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1189,
   FQN="clang::CodeGen::CodeGenFunction::FinallyInfo::enter", NM="_ZN5clang7CodeGen15CodeGenFunction11FinallyInfo5enterERS1_PKNS_4StmtEPN4llvm8ConstantES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11FinallyInfo5enterERS1_PKNS_4StmtEPN4llvm8ConstantES9_S9_")
  //</editor-fold>
  public final void enter(final CodeGenFunction /*&*/ CGF, 
       /*const*/ Stmt /*P*/ body, 
       Constant /*P*/ beginCatchFn, 
       Constant /*P*/ endCatchFn, 
       Constant /*P*/ rethrowFn) {
    assert ((beginCatchFn != null) == (endCatchFn != null)) : "begin/end catch functions not paired";
    assert ((rethrowFn != null)) : "rethrow function is required";
    
    BeginCatchFn = beginCatchFn;
    
    // The rethrow function has one of the following two types:
    //   void (*)()
    //   void (*)(void*)
    // In the latter case we need to pass it the exception object.
    // But we can't use the exception slot because the @finally might
    // have a landing pad (which would overwrite the exception slot).
    org.llvm.ir.FunctionType /*P*/ rethrowFnTy = IrRTTI.cast_FunctionType(IrRTTI.cast_PointerType(rethrowFn.getType()).getElementType());
    SavedExnVar = null;
    if ((rethrowFnTy.getNumParams() != 0)) {
      SavedExnVar = CGF.CreateTempAlloca(CGF.Unnamed_field9.Int8PtrTy, new Twine(/*KEEP_STR*/"finally.exn"));
    }
    
    // A finally block is a statement which must be executed on any edge
    // out of a given scope.  Unlike a cleanup, the finally block may
    // contain arbitrary control flow leading out of itself.  In
    // addition, finally blocks should always be executed, even if there
    // are no catch handlers higher on the stack.  Therefore, we
    // surround the protected scope with a combination of a normal
    // cleanup (to catch attempts to break out of the block via normal
    // control flow) and an EH catch-all (semantically "outside" any try
    // statement to which the finally block might have been attached).
    // The finally block itself is generated in the context of a cleanup
    // which conditionally leaves the catch-all.
    
    // Jump destination for performing the finally block on an exception
    // edge.  We'll never actually reach this block, so unreachable is
    // fine.
    RethrowDest.$assignMove(CGF.getJumpDestInCurrentScope(CGF.getUnreachableBlock()));
    
    // Whether the finally block is being executed for EH purposes.
    ForEHVar = CGF.CreateTempAlloca(CGF.Builder.getInt1Ty(), new Twine(/*KEEP_STR*/"finally.for-eh"));
    CGF.Builder.CreateFlagStore(false, ForEHVar);
    
    // Enter a normal cleanup which will perform the @finally block.
    CGF.EHStack.<PerformFinally>pushCleanup$T(CleanupKind.NormalCleanup, () -> new PerformFinally(body, 
        ForEHVar, endCatchFn, 
        rethrowFn, SavedExnVar));
    
    // Enter a catch-all scope.
    BasicBlock /*P*/ catchBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"finally.catchall"));
    EHCatchScope /*P*/ catchScope = CGF.EHStack.pushCatch(1);
    catchScope.setCatchAllHandler(0, catchBB);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinallyInfo::exit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1245,
   FQN="clang::CodeGen::CodeGenFunction::FinallyInfo::exit", NM="_ZN5clang7CodeGen15CodeGenFunction11FinallyInfo4exitERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11FinallyInfo4exitERS1_")
  //</editor-fold>
  public final void exit(final CodeGenFunction /*&*/ CGF) {
    // Leave the finally catch-all.
    final EHCatchScope /*&*/ catchScope = CodegenRTTI.cast_EHCatchScope(CGF.EHStack.begin().$star());
    BasicBlock /*P*/ catchBB = catchScope.getHandler(0).Block;
    
    CGF.popCatchScope();
    
    // If there are any references to the catch-all block, emit it.
    if (catchBB.use_empty()) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)catchBB);
    } else {
      CGBuilderTy.InsertPoint savedIP = CGF.Builder.saveAndClearIP();
      CGF.EmitBlock(catchBB);
      
      Value /*P*/ exn = null;
      
      // If there's a begin-catch function, call it.
      if ((BeginCatchFn != null)) {
        exn = CGF.getExceptionFromSlot();
        CGF.EmitNounwindRuntimeCall(BeginCatchFn, new ArrayRef<Value /*P*/ >(exn, true));
      }
      
      // If we need to remember the exception pointer to rethrow later, do so.
      if ((SavedExnVar != null)) {
        if (!(exn != null)) {
          exn = CGF.getExceptionFromSlot();
        }
        CGF.Builder.CreateAlignedStore(exn, SavedExnVar, CGF.getPointerAlign());
      }
      
      // Tell the cleanups in the finally block that we're do this for EH.
      CGF.Builder.CreateFlagStore(true, ForEHVar);
      
      // Thread a jump through the finally cleanup.
      CGF.EmitBranchThroughCleanup(new JumpDest(RethrowDest));
      
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(savedIP));
    }
    
    // Finally, leave the @finally cleanup.
    CGF.PopCleanupBlock();
  }



  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinallyInfo::FinallyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 372,
   FQN="clang::CodeGen::CodeGenFunction::FinallyInfo::FinallyInfo", NM="_ZN5clang7CodeGen15CodeGenFunction11FinallyInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11FinallyInfoC1Ev")
  //</editor-fold>
  public /*inline*/ FinallyInfo() {
    // : RethrowDest() 
    //START JInit
    this.RethrowDest = new JumpDest();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "RethrowDest=" + RethrowDest // NOI18N
              + ", BeginCatchFn=" + BeginCatchFn // NOI18N
              + ", ForEHVar=" + ForEHVar // NOI18N
              + ", SavedExnVar=" + SavedExnVar; // NOI18N
  }
}

/// \brief Enters a new scope for capturing cleanups, all of which
/// will be executed once the scope is exited.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 482,
 FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeE")
//</editor-fold>
public static class RunCleanupsScope implements Destructors.ClassWithDestructor {
  protected/*private*/ EHScopeStack.stable_iterator CleanupStackDepth;
  protected/*private*/ /*size_t*/int LifetimeExtendedCleanupStackSize;
  protected/*private*/ boolean OldDidCallStackSave;
/*protected:*/
  protected boolean PerformCleanup;
/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::RunCleanupsScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 490,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::RunCleanupsScope", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeC1ERKS2_")
  //</editor-fold>
  protected/*private*/ RunCleanupsScope(final /*const*/ RunCleanupsScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 491,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeaSERKS2_")
  //</editor-fold>
  protected/*private*/ final void $assign(final /*const*/ RunCleanupsScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  protected final CodeGenFunction /*&*/ CGF;
/*public:*/
  /// \brief Enter a new cleanup scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::RunCleanupsScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 498,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::RunCleanupsScope", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeC1ERS1_")
  //</editor-fold>
  public /*explicit*/ RunCleanupsScope(final CodeGenFunction /*&*/ CGF) {
    // : CleanupStackDepth(), PerformCleanup(true), CGF(CGF) 
    //START JInit
    this.CleanupStackDepth = new EHScopeStack.stable_iterator();
    this.PerformCleanup = true;
    this./*&*/CGF=/*&*/CGF;
    //END JInit
    CleanupStackDepth.$assignMove(CGF.EHStack.stable_begin());
    LifetimeExtendedCleanupStackSize
       = CGF.LifetimeExtendedCleanupStack.size();
    OldDidCallStackSave = CGF.DidCallStackSave;
    CGF.DidCallStackSave = false;
  }

  
  /// \brief Exit this cleanup scope, emitting any accumulated
  /// cleanups.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::~RunCleanupsScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 510,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::~RunCleanupsScope", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (PerformCleanup) {
      CGF.DidCallStackSave = OldDidCallStackSave;
      CGF.PopCleanupBlocks(new EHScopeStack.stable_iterator(CleanupStackDepth), 
          LifetimeExtendedCleanupStackSize);
    }
  }

  
  /// \brief Determine whether this scope requires any cleanups.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::requiresCleanups">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 519,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::requiresCleanups", NM="_ZNK5clang7CodeGen15CodeGenFunction16RunCleanupsScope16requiresCleanupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction16RunCleanupsScope16requiresCleanupsEv")
  //</editor-fold>
  public final boolean requiresCleanups() /*const*/ {
    return EHScopeStack.stable_iterator.$noteq_stable_iterator(CGF.EHStack.stable_begin(), /*NO_COPY*/CleanupStackDepth);
  }

  
  /// \brief Force the emission of cleanups now, instead of waiting
  /// until this object is destroyed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::RunCleanupsScope::ForceCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 525,
   FQN="clang::CodeGen::CodeGenFunction::RunCleanupsScope::ForceCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScope12ForceCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16RunCleanupsScope12ForceCleanupEv")
  //</editor-fold>
  public final void ForceCleanup() {
    assert (PerformCleanup) : "Already forced cleanup";
    CGF.DidCallStackSave = OldDidCallStackSave;
    CGF.PopCleanupBlocks(new EHScopeStack.stable_iterator(CleanupStackDepth), 
        LifetimeExtendedCleanupStackSize);
    PerformCleanup = false;
  }

  
  @Override public String toString() {
    return "" + "CleanupStackDepth=" + CleanupStackDepth // NOI18N
              + ", LifetimeExtendedCleanupStackSize=" + LifetimeExtendedCleanupStackSize // NOI18N
              + ", OldDidCallStackSave=" + OldDidCallStackSave // NOI18N
              + ", PerformCleanup=" + PerformCleanup // NOI18N
              + ", CGF=" + CGF; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 534,
 FQN="clang::CodeGen::CodeGenFunction::LexicalScope", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeE")
//</editor-fold>
public static class LexicalScope extends /*public*/ RunCleanupsScope implements Destructors.ClassWithDestructor {
  protected/*private*/ SourceRange Range;
  protected/*private*/ SmallVector</*const*/ LabelDecl /*P*/ > Labels;
  protected/*private*/ LexicalScope /*P*/ ParentScope;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::LexicalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 539,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::LexicalScope", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeC1ERKS2_")
  //</editor-fold>
  protected/*private*/ LexicalScope(final /*const*/ LexicalScope /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 540,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeaSERKS2_")
  //</editor-fold>
  protected/*private*/ final void $assign(final /*const*/ LexicalScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Enter a new cleanup scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::LexicalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 544,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::LexicalScope", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeC1ERS1_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeC1ERS1_NS_11SourceRangeE")
  //</editor-fold>
  public /*explicit*/ LexicalScope(final CodeGenFunction /*&*/ CGF, SourceRange Range) {
    // : RunCleanupsScope(CGF), Range(Range), Labels(), ParentScope(CGF.CurLexicalScope) 
    //START JInit
    super(CGF);
    this.Range = new SourceRange(Range);
    this.Labels = new SmallVector</*const*/ LabelDecl /*P*/ >(4, (/*const*/ LabelDecl /*P*/ )null);
    this.ParentScope = CGF.CurLexicalScope;
    //END JInit
    CGF.CurLexicalScope = this;
    {
      CGDebugInfo /*P*/ DI = CGF.getDebugInfo();
      if ((DI != null)) {
        DI.EmitLexicalBlockStart(CGF.Builder, Range.getBegin());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::addLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 551,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::addLabel", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScope8addLabelEPKNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScope8addLabelEPKNS_9LabelDeclE")
  //</editor-fold>
  public final void addLabel(/*const*/ LabelDecl /*P*/ label) {
    assert (PerformCleanup) : "adding label to dead scope?";
    Labels.push_back(label);
  }

  
  /// \brief Exit this cleanup scope, emitting any accumulated
  /// cleanups.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::~LexicalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 558,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::~LexicalScope", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScopeD0Ev")
  //</editor-fold>
  public final void $destroy_LexicalScope() {
    {
      CGDebugInfo /*P*/ DI = CGF.getDebugInfo();
      if ((DI != null)) {
        DI.EmitLexicalBlockEnd(CGF.Builder, Range.getEnd());
      }
    }
    
    // If we should perform a cleanup, force them now.  Note that
    // this ends the cleanup scope before rescoping any labels.
    if (PerformCleanup) {
      ApplyDebugLocation DL = null;
      try {
        DL/*J*/= new ApplyDebugLocation(CGF, Range.getEnd());
        ForceCleanup_LexicalScope();
      } finally {
        if (DL != null) { DL.$destroy(); }
      }
    }
    //START JDestroy
    Labels.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// \brief Force the emission of cleanups now, instead of waiting
  /// until this object is destroyed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::ForceCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 572,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::ForceCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScope12ForceCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScope12ForceCleanupEv")
  //</editor-fold>
  public final void ForceCleanup_LexicalScope() {
    CGF.CurLexicalScope = ParentScope;
    super.ForceCleanup();
    if (!Labels.empty()) {
      rescopeLabels();
    }
  }

  
  /// Change the cleanup scope of the labels in this lexical scope to
  /// match the scope of the enclosing context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LexicalScope::rescopeLabels">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 491,
   FQN="clang::CodeGen::CodeGenFunction::LexicalScope::rescopeLabels", NM="_ZN5clang7CodeGen15CodeGenFunction12LexicalScope13rescopeLabelsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LexicalScope13rescopeLabelsEv")
  //</editor-fold>
  public final void rescopeLabels() {
    assert (!Labels.empty());
    EHScopeStack.stable_iterator innermostScope = CGF.EHStack.getInnermostNormalCleanup();
    
    // Change the scope depth of all the labels.
    for (type$ptr</*const*/ LabelDecl /*P*/ /*P*/> i = $tryClone(Labels.begin()), /*P*/ e = $tryClone(Labels.end()); $noteq_ptr(i, e); i.$preInc()) {
      assert Native.$bool(CGF.LabelMap.count(i.$star()));
      final JumpDest /*&*/ dest = CGF.LabelMap.find(i.$star()).$arrow().second;
      assert (dest.getScopeDepth().isValid());
      assert (innermostScope.encloses(dest.getScopeDepth()));
      dest.setScopeDepth(new EHScopeStack.stable_iterator(innermostScope));
    }
    
    // Reparent the labels if the new scope also has cleanups.
    if (EHScopeStack.stable_iterator.$noteq_stable_iterator(/*NO_COPY*/innermostScope, EHScopeStack.stable_end()) && (ParentScope != null)) {
      ParentScope.Labels.append_T(Labels.begin(), Labels.end());
    }
  }


  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", Labels=" + "[SmallVector$LabelDecl]" // NOI18N
              + ", ParentScope=" + ParentScope // NOI18N
              + super.toString(); // NOI18N
  }
}

/// \brief The scope used to remap some variables as private in the OpenMP
/// loop body (or other captured region emitted without outlining), and to
/// restore old vars back on exit.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 588,
 FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeE")
//</editor-fold>
public static class OMPPrivateScope extends /*public*/ RunCleanupsScope implements Destructors.ClassWithDestructor {
  protected/*private*/ DenseMap</*const*/ Decl /*P*/ , Address> SavedLocals;
  protected/*private*/ DenseMap</*const*/ Decl /*P*/ , Address> SavedPrivates;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::OMPPrivateScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 593,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::OMPPrivateScope", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeC1ERKS2_")
  //</editor-fold>
  protected/*private*/ OMPPrivateScope(final /*const*/ OMPPrivateScope /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 594,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeaSERKS2_")
  //</editor-fold>
  protected/*private*/ final void $assign(final /*const*/ OMPPrivateScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Enter a new OpenMP private scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::OMPPrivateScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 598,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::OMPPrivateScope", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeC1ERS1_")
  //</editor-fold>
  public /*explicit*/ OMPPrivateScope(final CodeGenFunction /*&*/ CGF) {
    // : RunCleanupsScope(CGF), SavedLocals(), SavedPrivates() 
    //START JInit
    super(CGF);
    this.SavedLocals = new DenseMap</*const*/ Decl /*P*/ , Address>(DenseMapInfo$LikePtr.$Info(), new Address());
    this.SavedPrivates = new DenseMap</*const*/ Decl /*P*/ , Address>(DenseMapInfo$LikePtr.$Info(), new Address());
    //END JInit
  }

  
  /// \brief Registers \a LocalVD variable as a private and apply \a
  /// PrivateGen function for it to generate corresponding private variable.
  /// \a PrivateGen returns an address of the generated private variable.
  /// \return true if the variable is registered as private, false if it has
  /// been privatized already.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::addPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 605,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::addPrivate", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope10addPrivateEPKNS_7VarDeclEN4llvm12function_refIFNS0_7AddressEvEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope10addPrivateEPKNS_7VarDeclEN4llvm12function_refIFNS0_7AddressEvEEE")
  //</editor-fold>
  public final boolean addPrivate(/*const*/ VarDecl /*P*/ LocalVD, 
            Void2RetType<Address> PrivateGen) {
    assert (PerformCleanup) : "adding private to dead scope";
    
    // Only save it once.
    if ((SavedLocals.count(LocalVD) != 0)) {
      return false;
    }
    
    // Copy the existing local entry to SavedLocals.
    DenseMapIterator</*const*/ Decl /*P*/ , Address> it = CGF.LocalDeclMap.find(LocalVD);
    if (it.$noteq(/*NO_ITER_COPY*/CGF.LocalDeclMap.end())) {
      SavedLocals.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ Decl /*P*/ , Address>(JD$T$RR_T1$RR.INSTANCE, LocalVD, new Address(/*Fwd*/it.$arrow().second))/* }*/);
    } else {
      SavedLocals.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ Decl /*P*/ , Address>(JD$T$RR_T1$RR.INSTANCE, LocalVD, new Address(JD$Move.INSTANCE, /*Fwd*/Address.invalid()))/* }*/);
    }
    
    // Generate the private entry.
    Address Addr = PrivateGen.$call();
    QualType VarTy = LocalVD.getType();
    if (VarTy.$arrow().isReferenceType()) {
      Address Temp = CGF.CreateMemTemp(new QualType(VarTy));
      CGF.Builder.CreateStore(Addr.getPointer(), new Address(Temp));
      Addr.$assign(Temp);
    }
    SavedPrivates.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ Decl /*P*/ , Address>(JD$T$RR_T1$RR.INSTANCE, LocalVD, new Address(/*Fwd*/Addr))/* }*/);
    
    return true;
  }

  
  /// \brief Privatizes local variables previously registered as private.
  /// Registration is separate from the actual privatization to allow
  /// initializers use values of the original variables, not the private one.
  /// This is important, for example, if the private variable is a class
  /// variable initialized by a constructor that references other private
  /// variables. But at initialization original variables must be used, not
  /// private copies.
  /// \return true if at least one variable was privatized, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::Privatize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 642,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::Privatize", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope9PrivatizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope9PrivatizeEv")
  //</editor-fold>
  public final boolean Privatize() {
    OMPPrivateScope.copyInto(SavedPrivates, CGF.LocalDeclMap);
    SavedPrivates.clear();
    return !SavedLocals.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::ForceCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 648,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::ForceCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope12ForceCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope12ForceCleanupEv")
  //</editor-fold>
  public final void ForceCleanup_OMPPrivateScope() {
    super.ForceCleanup();
    OMPPrivateScope.copyInto(SavedLocals, CGF.LocalDeclMap);
    SavedLocals.clear();
  }

  
  /// \brief Exit scope - all the mapped variables are restored.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::~OMPPrivateScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 655,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::~OMPPrivateScope", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScopeD0Ev")
  //</editor-fold>
  public final void $destroy_OMPPrivateScope() {
    if (PerformCleanup) {
      ForceCleanup_OMPPrivateScope();
    }
    //START JDestroy
    SavedPrivates.$destroy();
    SavedLocals.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// Checks if the global variable is captured in current function. 
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::isGlobalVarCaptured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 661,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::isGlobalVarCaptured", NM="_ZNK5clang7CodeGen15CodeGenFunction15OMPPrivateScope19isGlobalVarCapturedEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15OMPPrivateScope19isGlobalVarCapturedEPKNS_7VarDeclE")
  //</editor-fold>
  public final boolean isGlobalVarCaptured(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    return !VD.isLocalVarDeclOrParm() && $greater_uint(CGF.LocalDeclMap.count(VD), 0);
  }

/*private:*/
  /// Copy all the entries in the source map over the corresponding
  /// entries in the destination, which must exist.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OMPPrivateScope::copyInto">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 668,
   FQN="clang::CodeGen::CodeGenFunction::OMPPrivateScope::copyInto", NM="_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope8copyIntoERKN4llvm8DenseMapIPKNS_4DeclENS0_7AddressENS3_12DenseMapInfoIS7_EENS3_6detail12DenseMapPairIS7_S8_EEEERSE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15OMPPrivateScope8copyIntoERKN4llvm8DenseMapIPKNS_4DeclENS0_7AddressENS3_12DenseMapInfoIS7_EENS3_6detail12DenseMapPairIS7_S8_EEEERSE_")
  //</editor-fold>
  protected/*private*/ static void copyInto(final /*const*/DenseMap</*const*/ Decl /*P*/ , Address> /*&*/ src, final DenseMap</*const*/ Decl /*P*/ , Address> /*&*/ dest) {
    for (final /*constconst*/std.pair</*const*/ Decl /*P*/ , Address> /*&*/ pair : src) {
      if (!pair.second.isValid()) {
        dest.erase(pair.first);
        continue;
      }
      
      DenseMapIterator</*const*/ Decl /*P*/ , Address> it = dest.find(pair.first);
      if (it.$noteq(/*NO_ITER_COPY*/dest.end())) {
        it.$arrow().second.$assign(pair.second);
      } else {
        dest.insert_pair$KeyT$ValueT(pair);
      }
    }
  }

  
  @Override public String toString() {
    return "" + "SavedLocals=" + SavedLocals // NOI18N
              + ", SavedPrivates=" + SavedPrivates // NOI18N
              + super.toString(); // NOI18N
  }
}

/// An object to manage conditionally-evaluated expressions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConditionalEvaluation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 733,
 FQN="clang::CodeGen::CodeGenFunction::ConditionalEvaluation", NM="_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluationE")
//</editor-fold>
public static class ConditionalEvaluation {
  protected/*private*/ BasicBlock /*P*/ StartBB;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::ConditionalEvaluation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 737,
   FQN="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::ConditionalEvaluation", NM="_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluationC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluationC1ERS1_")
  //</editor-fold>
  public ConditionalEvaluation(final CodeGenFunction /*&*/ CGF) {
    // : StartBB(CGF.Builder.GetInsertBlock()) 
    //START JInit
    this.StartBB = CGF.Builder.GetInsertBlock();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 740,
   FQN="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::begin", NM="_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluation5beginERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluation5beginERS1_")
  //</editor-fold>
  public final void begin(final CodeGenFunction /*&*/ CGF) {
    assert (CGF.OutermostConditional != this);
    if (!(CGF.OutermostConditional != null)) {
      CGF.OutermostConditional = this;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 746,
   FQN="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::end", NM="_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluation3endERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21ConditionalEvaluation3endERS1_")
  //</editor-fold>
  public final void end(final CodeGenFunction /*&*/ CGF) {
    assert (CGF.OutermostConditional != null);
    if (CGF.OutermostConditional == this) {
      CGF.OutermostConditional = null;
    }
  }

  
  /// Returns a block which will be executed prior to each
  /// evaluation of the conditional code.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::getStartingBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 754,
   FQN="clang::CodeGen::CodeGenFunction::ConditionalEvaluation::getStartingBlock", NM="_ZNK5clang7CodeGen15CodeGenFunction21ConditionalEvaluation16getStartingBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction21ConditionalEvaluation16getStartingBlockEv")
  //</editor-fold>
  public final BasicBlock /*P*/ getStartingBlock() /*const*/ {
    return StartBB;
  }

  
  @Override public String toString() {
    return "" + "StartBB=" + StartBB; // NOI18N
  }
}

/// An RAII object to record that we're evaluating a statement
/// expression.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StmtExprEvaluation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 772,
 FQN="clang::CodeGen::CodeGenFunction::StmtExprEvaluation", NM="_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationE")
//</editor-fold>
public static class StmtExprEvaluation implements Destructors.ClassWithDestructor {
  protected/*private*/ final CodeGenFunction /*&*/ CGF;
  
  /// We have to save the outermost conditional: cleanups in a
  /// statement expression aren't conditional just because the
  /// StmtExpr is.
  protected/*private*/ ConditionalEvaluation /*P*/ SavedOutermostConditional;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StmtExprEvaluation::StmtExprEvaluation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 781,
   FQN="clang::CodeGen::CodeGenFunction::StmtExprEvaluation::StmtExprEvaluation", NM="_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationC1ERS1_")
  //</editor-fold>
  public StmtExprEvaluation(final CodeGenFunction /*&*/ CGF) {
    // : CGF(CGF), SavedOutermostConditional(CGF.OutermostConditional) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.SavedOutermostConditional = CGF.OutermostConditional;
    //END JInit
    CGF.OutermostConditional = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StmtExprEvaluation::~StmtExprEvaluation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 786,
   FQN="clang::CodeGen::CodeGenFunction::StmtExprEvaluation::~StmtExprEvaluation", NM="_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18StmtExprEvaluationD0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.OutermostConditional = SavedOutermostConditional;
    CGF.EnsureInsertPoint();
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", SavedOutermostConditional=" + SavedOutermostConditional; // NOI18N
  }
}

/// An object which temporarily prevents a value from being
/// destroyed by aggressive peephole optimizations that assume that
/// all uses of a value have been realized in the IR.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PeepholeProtection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 795,
 FQN="clang::CodeGen::CodeGenFunction::PeepholeProtection", NM="_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionE")
//</editor-fold>
public static class PeepholeProtection {
  protected/*private*/ Instruction /*P*/ Inst;
  /*friend  class CodeGenFunction*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 800,
   FQN="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection", NM="_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1Ev")
  //</editor-fold>
  public PeepholeProtection() {
    // : Inst(null) 
    //START JInit
    this.Inst = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 795,
   FQN="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection", NM="_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1ERKS2_")
  //</editor-fold>
  public /*inline*/ PeepholeProtection(final /*const*/ PeepholeProtection /*&*/ $Prm0) {
    // : Inst(.Inst) 
    //START JInit
    this.Inst = $Prm0.Inst;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 795,
   FQN="clang::CodeGen::CodeGenFunction::PeepholeProtection::PeepholeProtection", NM="_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionC1EOS2_")
  //</editor-fold>
  public /*inline*/ PeepholeProtection(JD$Move _dparam, final PeepholeProtection /*&&*/$Prm0) {
    // : Inst(static_cast<PeepholeProtection &&>().Inst) 
    //START JInit
    this.Inst = $Prm0.Inst;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PeepholeProtection::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 795,
   FQN="clang::CodeGen::CodeGenFunction::PeepholeProtection::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18PeepholeProtectionaSEOS2_")
  //</editor-fold>
  public final /*inline*/ PeepholeProtection /*&*/ $assignMove(final PeepholeProtection /*&&*/$Prm0) {
    this.Inst = $Prm0.Inst;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Inst=" + Inst; // NOI18N
  }
}

/// A non-RAII class containing all the information about a bound
/// opaque value.  OpaqueValueMapping, below, is a RAII wrapper for
/// this which makes individual mappings very simple; using this
/// class directly is useful when you have a variable number of
/// opaque values or don't want the RAII functionality for some
/// reason.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 809,
 FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataE")
//</editor-fold>
public static class OpaqueValueMappingData {
  protected/*private*/ /*const*/ OpaqueValueExpr /*P*/ OpaqueValue;
  protected/*private*/ boolean BoundLValue;
  protected/*private*/ CodeGenFunction.PeepholeProtection Protection;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 814,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1EPKNS_15OpaqueValueExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1EPKNS_15OpaqueValueExprEb")
  //</editor-fold>
  protected/*private*/ OpaqueValueMappingData(/*const*/ OpaqueValueExpr /*P*/ ov, 
      boolean boundLValue) {
    // : OpaqueValue(ov), BoundLValue(boundLValue), Protection() 
    //START JInit
    this.OpaqueValue = ov;
    this.BoundLValue = boundLValue;
    this.Protection = new CodeGenFunction.PeepholeProtection();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 818,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1Ev")
  //</editor-fold>
  public OpaqueValueMappingData() {
    // : OpaqueValue(null), Protection() 
    //START JInit
    this.OpaqueValue = null;
    this.Protection = new CodeGenFunction.PeepholeProtection();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::shouldBindAsLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 820,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::shouldBindAsLValue", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData18shouldBindAsLValueEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData18shouldBindAsLValueEPKNS_4ExprE")
  //</editor-fold>
  public static boolean shouldBindAsLValue(/*const*/ Expr /*P*/ expr) {
    // gl-values should be bound as l-values for obvious reasons.
    // Records should be bound as l-values because IR generation
    // always keeps them in memory.  Expressions of function type
    // act exactly like l-values but are formally required to be
    // r-values in C.
    return expr.isGLValue()
       || expr.getType().$arrow().isFunctionType()
       || CodeGenFunction.hasAggregateEvaluationKind(expr.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 831,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprEPKNS_4ExprE")
  //</editor-fold>
  public static OpaqueValueMappingData bind(final CodeGenFunction /*&*/ CGF, 
      /*const*/ OpaqueValueExpr /*P*/ ov, 
      /*const*/ Expr /*P*/ e) {
    if (OpaqueValueMappingData.shouldBindAsLValue(ov)) {
      return OpaqueValueMappingData.bind(CGF, ov, CGF.EmitLValue(e));
    }
    return OpaqueValueMappingData.bind(CGF, ov, CGF.EmitAnyExpr(e));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 839,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprERKNS0_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprERKNS0_6LValueE")
  //</editor-fold>
  public static OpaqueValueMappingData bind(final CodeGenFunction /*&*/ CGF, 
      /*const*/ OpaqueValueExpr /*P*/ ov, 
      final /*const*/ LValue /*&*/ lv) {
    assert (OpaqueValueMappingData.shouldBindAsLValue(ov));
    CGF.OpaqueLValues.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(ov, $Clone(lv)));
    return new OpaqueValueMappingData(ov, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 847,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::bind", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprERKNS0_6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData4bindERS1_PKNS_15OpaqueValueExprERKNS0_6RValueE")
  //</editor-fold>
  public static OpaqueValueMappingData bind(final CodeGenFunction /*&*/ CGF, 
      /*const*/ OpaqueValueExpr /*P*/ ov, 
      final /*const*/ RValue /*&*/ rv) {
    assert (!OpaqueValueMappingData.shouldBindAsLValue(ov));
    CGF.OpaqueRValues.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(ov, $Clone(rv)));
    
    OpaqueValueMappingData data/*J*/= new OpaqueValueMappingData(ov, false);
    
    // Work around an extremely aggressive peephole optimization in
    // EmitScalarConversion which assumes that all other uses of a
    // value are extant.
    data.Protection.$assignMove(CGF.protectFromPeepholes(new RValue(rv)));
    
    return data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 863,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::isValid", NM="_ZNK5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData7isValidEv")
  //</editor-fold>
  public final boolean isValid() /*const*/ {
    return OpaqueValue != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 864,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::clear", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData5clearEv")
  //</editor-fold>
  public final void clear() {
    OpaqueValue = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::unbind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 866,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::unbind", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData6unbindERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingData6unbindERS1_")
  //</editor-fold>
  public final void unbind(final CodeGenFunction /*&*/ CGF) {
    assert ((OpaqueValue != null)) : "no data to unbind!";
    if (BoundLValue) {
      CGF.OpaqueLValues.erase(OpaqueValue);
    } else {
      CGF.OpaqueRValues.erase(OpaqueValue);
      CGF.unprotectFromPeepholes(new PeepholeProtection(Protection));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 809,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::OpaqueValueMappingData", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataC1EOS2_")
  //</editor-fold>
  public /*inline*/ OpaqueValueMappingData(JD$Move _dparam, final OpaqueValueMappingData /*&&*/$Prm0) {
    // : OpaqueValue(static_cast<OpaqueValueMappingData &&>().OpaqueValue), BoundLValue(static_cast<OpaqueValueMappingData &&>().BoundLValue), Protection(static_cast<OpaqueValueMappingData &&>().Protection) 
    //START JInit
    this.OpaqueValue = $Prm0.OpaqueValue;
    this.BoundLValue = $Prm0.BoundLValue;
    this.Protection = new CodeGenFunction.PeepholeProtection(JD$Move.INSTANCE, $Prm0.Protection);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 809,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMappingData::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22OpaqueValueMappingDataaSEOS2_")
  //</editor-fold>
  public final /*inline*/ OpaqueValueMappingData /*&*/ $assignMove(final OpaqueValueMappingData /*&&*/$Prm0) {
    this.OpaqueValue = $Prm0.OpaqueValue;
    this.BoundLValue = $Prm0.BoundLValue;
    this.Protection.$assignMove($Prm0.Protection);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "OpaqueValue=" + "[OpaqueValueExpr]" // NOI18N
              + ", BoundLValue=" + BoundLValue // NOI18N
              + ", Protection=" + Protection; // NOI18N
  }
}

/// An RAII object to set (and then clear) a mapping for an OpaqueValueExpr.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 879,
 FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingE")
//</editor-fold>
public static class OpaqueValueMapping implements Destructors.ClassWithDestructor {
  protected/*private*/ final CodeGenFunction /*&*/ CGF;
  protected/*private*/ OpaqueValueMappingData Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::shouldBindAsLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 884,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::shouldBindAsLValue", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMapping18shouldBindAsLValueEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMapping18shouldBindAsLValueEPKNS_4ExprE")
  //</editor-fold>
  public static boolean shouldBindAsLValue(/*const*/ Expr /*P*/ expr) {
    return OpaqueValueMappingData.shouldBindAsLValue(expr);
  }

  
  /// Build the opaque value mapping for the given conditional
  /// operator if it's the GNU ?: extension.  This is a common
  /// enough pattern that the convenience operator is really
  /// helpful.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 893,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_27AbstractConditionalOperatorE")
  //</editor-fold>
  public OpaqueValueMapping(final CodeGenFunction /*&*/ CGF, 
      /*const*/ AbstractConditionalOperator /*P*/ op) {
    // : CGF(CGF), Data() 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.Data = new OpaqueValueMappingData();
    //END JInit
    if (AstRTTI.isa_ConditionalOperator(op)) {
      // Leave Data empty.
      return;
    }
    
    /*const*/ BinaryConditionalOperator /*P*/ e = AstRTTI.cast_BinaryConditionalOperator(op);
    Data.$assignMove(OpaqueValueMappingData.bind(CGF, e.getOpaqueValue(), 
            e.getCommon()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 904,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_15OpaqueValueExprENS0_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_15OpaqueValueExprENS0_6LValueE")
  //</editor-fold>
  public OpaqueValueMapping(final CodeGenFunction /*&*/ CGF, 
      /*const*/ OpaqueValueExpr /*P*/ opaqueValue, 
      LValue lvalue) {
    // : CGF(CGF), Data(OpaqueValueMappingData::bind(CGF, opaqueValue, lvalue)) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.Data = OpaqueValueMappingData.bind(CGF, opaqueValue, lvalue);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 910,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::OpaqueValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_15OpaqueValueExprENS0_6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingC1ERS1_PKNS_15OpaqueValueExprENS0_6RValueE")
  //</editor-fold>
  public OpaqueValueMapping(final CodeGenFunction /*&*/ CGF, 
      /*const*/ OpaqueValueExpr /*P*/ opaqueValue, 
      RValue rvalue) {
    // : CGF(CGF), Data(OpaqueValueMappingData::bind(CGF, opaqueValue, rvalue)) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.Data = OpaqueValueMappingData.bind(CGF, opaqueValue, rvalue);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 916,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::pop", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMapping3popEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMapping3popEv")
  //</editor-fold>
  public final void pop() {
    Data.unbind(CGF);
    Data.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::~OpaqueValueMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 921,
   FQN="clang::CodeGen::CodeGenFunction::OpaqueValueMapping::~OpaqueValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18OpaqueValueMappingD0Ev")
  //</editor-fold>
  public final void $destroy() {
    if (Data.isValid()) {
      Data.unbind(CGF);
    }
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}

// BreakContinueStack - This keeps track of where break and continue
// statements should jump to.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BreakContinue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 959,
 FQN="clang::CodeGen::CodeGenFunction::BreakContinue", NM="_ZN5clang7CodeGen15CodeGenFunction13BreakContinueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13BreakContinueE")
//</editor-fold>
protected/*private*/ static class/*struct*/ BreakContinue implements NativePOD<BreakContinue> {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BreakContinue::BreakContinue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 960,
   FQN="clang::CodeGen::CodeGenFunction::BreakContinue::BreakContinue", NM="_ZN5clang7CodeGen15CodeGenFunction13BreakContinueC1ENS1_8JumpDestES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13BreakContinueC1ENS1_8JumpDestES3_")
  //</editor-fold>
  public BreakContinue(JumpDest Break, JumpDest Continue) {
    // : BreakBlock(Break), ContinueBlock(Continue) 
    //START JInit
    this.BreakBlock = new JumpDest(Break);
    this.ContinueBlock = new JumpDest(Continue);
    //END JInit
  }

  
  public final/*public*/ JumpDest BreakBlock;
  public final/*public*/ JumpDest ContinueBlock;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public BreakContinue() { 
    BreakBlock = new JumpDest();
    ContinueBlock = new JumpDest();
  }

  @Override public BreakContinue clone() {
    return new BreakContinue(this.BreakBlock, this.ContinueBlock);
  }

  @Override 
  public BreakContinue $assign(BreakContinue Other) { 
    this.BreakBlock.$assign(Other.BreakBlock); 
    this.ContinueBlock.$assign(Other.ContinueBlock); 
    return this; 
  }   

  @Override 
  public BreakContinue $assignMove(BreakContinue Other) { 
    this.BreakBlock.$assignMove(Other.BreakBlock); 
    this.ContinueBlock.$assignMove(Other.ContinueBlock); 
    return this; 
  }   


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BreakBlock=" + BreakBlock // NOI18N
              + ", ContinueBlock=" + ContinueBlock; // NOI18N
  }
}
/// A scope within which we are constructing the fields of an object which
/// might use a CXXDefaultInitExpr. This stashes away a 'this' value to use
/// if we need to evaluate a CXXDefaultInitExpr within the evaluation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FieldConstructionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1045,
 FQN="clang::CodeGen::CodeGenFunction::FieldConstructionScope", NM="_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeE")
//</editor-fold>
public static class FieldConstructionScope implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FieldConstructionScope::FieldConstructionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1047,
   FQN="clang::CodeGen::CodeGenFunction::FieldConstructionScope::FieldConstructionScope", NM="_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeC1ERS1_NS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeC1ERS1_NS0_7AddressE")
  //</editor-fold>
  public FieldConstructionScope(final CodeGenFunction /*&*/ CGF, Address This) {
    // : CGF(CGF), OldCXXDefaultInitExprThis(CGF.CXXDefaultInitExprThis) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.OldCXXDefaultInitExprThis = new Address(CGF.CXXDefaultInitExprThis);
    //END JInit
    CGF.CXXDefaultInitExprThis.$assign(This);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FieldConstructionScope::~FieldConstructionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1051,
   FQN="clang::CodeGen::CodeGenFunction::FieldConstructionScope::~FieldConstructionScope", NM="_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22FieldConstructionScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.CXXDefaultInitExprThis.$assign(OldCXXDefaultInitExprThis);
  }

/*private:*/
  protected/*private*/ final CodeGenFunction /*&*/ CGF;
  protected/*private*/ Address OldCXXDefaultInitExprThis;
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", OldCXXDefaultInitExprThis=" + OldCXXDefaultInitExprThis; // NOI18N
  }
}

/// The scope of a CXXDefaultInitExpr. Within this scope, the value of 'this'
/// is overridden to be the object under construction.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1062,
 FQN="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope", NM="_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeE")
//</editor-fold>
public static class CXXDefaultInitExprScope implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope::CXXDefaultInitExprScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1064,
   FQN="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope::CXXDefaultInitExprScope", NM="_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeC1ERS1_")
  //</editor-fold>
  public CXXDefaultInitExprScope(final CodeGenFunction /*&*/ CGF) {
    // : CGF(CGF), OldCXXThisValue(CGF.CXXThisValue), OldCXXThisAlignment(CGF.CXXThisAlignment) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.OldCXXThisValue = CGF.CXXThisValue;
    this.OldCXXThisAlignment = new CharUnits(CGF.CXXThisAlignment);
    //END JInit
    CGF.CXXThisValue = CGF.CXXDefaultInitExprThis.getPointer();
    CGF.CXXThisAlignment.$assignMove(CGF.CXXDefaultInitExprThis.getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope::~CXXDefaultInitExprScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1070,
   FQN="clang::CodeGen::CodeGenFunction::CXXDefaultInitExprScope::~CXXDefaultInitExprScope", NM="_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23CXXDefaultInitExprScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.CXXThisValue = OldCXXThisValue;
    CGF.CXXThisAlignment.$assign(OldCXXThisAlignment);
  }

/*public:*/
  public final CodeGenFunction /*&*/ CGF;
  public Value /*P*/ OldCXXThisValue;
  public CharUnits OldCXXThisAlignment;
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", OldCXXThisValue=" + OldCXXThisValue // NOI18N
              + ", OldCXXThisAlignment=" + OldCXXThisAlignment; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1081,
 FQN="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope", NM="_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeE")
//</editor-fold>
public static class InlinedInheritingConstructorScope implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope::InlinedInheritingConstructorScope">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1083,
   FQN="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope::InlinedInheritingConstructorScope", NM="_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeC1ERS1_NS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeC1ERS1_NS_10GlobalDeclE")
  //</editor-fold>
  public InlinedInheritingConstructorScope(final CodeGenFunction /*&*/ CGF, GlobalDecl GD) {
    // : CGF(CGF), OldCurGD(CGF.CurGD), OldCurFuncDecl(CGF.CurFuncDecl), OldCurCodeDecl(CGF.CurCodeDecl), OldCXXABIThisDecl(CGF.CXXABIThisDecl), OldCXXABIThisValue(CGF.CXXABIThisValue), OldCXXThisValue(CGF.CXXThisValue), OldCXXABIThisAlignment(CGF.CXXABIThisAlignment), OldCXXThisAlignment(CGF.CXXThisAlignment), OldReturnValue(CGF.ReturnValue), OldFnRetTy(CGF.FnRetTy), OldCXXInheritedCtorInitExprArgs(std::move(CGF.CXXInheritedCtorInitExprArgs)) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.OldCurGD = new GlobalDecl(CGF.CurGD);
    this.OldCurFuncDecl = CGF.CurFuncDecl;
    this.OldCurCodeDecl = CGF.CurCodeDecl;
    this.OldCXXABIThisDecl = CGF.CXXABIThisDecl;
    this.OldCXXABIThisValue = CGF.CXXABIThisValue;
    this.OldCXXThisValue = CGF.CXXThisValue;
    this.OldCXXABIThisAlignment = new CharUnits(CGF.CXXABIThisAlignment);
    this.OldCXXThisAlignment = new CharUnits(CGF.CXXThisAlignment);
    this.OldReturnValue = new Address(CGF.ReturnValue);
    this.OldFnRetTy = new QualType(CGF.FnRetTy);
    this.OldCXXInheritedCtorInitExprArgs = new CallArgList(JD$Move.INSTANCE, std.move(CGF.CXXInheritedCtorInitExprArgs));
    //END JInit
    CGF.CurGD.$assign(GD);
    CGF.CurFuncDecl = CGF.CurCodeDecl
       = AstDeclarationsRTTI.cast_CXXConstructorDecl(GD.getDecl());
    CGF.CXXABIThisDecl = null;
    CGF.CXXABIThisValue = null;
    CGF.CXXThisValue = null;
    CGF.CXXABIThisAlignment.$assignMove(new CharUnits());
    CGF.CXXThisAlignment.$assignMove(new CharUnits());
    CGF.ReturnValue.$assignMove(Address.invalid());
    CGF.FnRetTy.$assignMove(new QualType());
    CGF.CXXInheritedCtorInitExprArgs.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope::~InlinedInheritingConstructorScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1106,
   FQN="clang::CodeGen::CodeGenFunction::InlinedInheritingConstructorScope::~InlinedInheritingConstructorScope", NM="_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33InlinedInheritingConstructorScopeD0Ev")
  //</editor-fold>
  public final void $destroy() {
    CGF.CurGD.$assign(OldCurGD);
    CGF.CurFuncDecl = OldCurFuncDecl;
    CGF.CurCodeDecl = OldCurCodeDecl;
    CGF.CXXABIThisDecl = OldCXXABIThisDecl;
    CGF.CXXABIThisValue = OldCXXABIThisValue;
    CGF.CXXThisValue = OldCXXThisValue;
    CGF.CXXABIThisAlignment.$assign(OldCXXABIThisAlignment);
    CGF.CXXThisAlignment.$assign(OldCXXThisAlignment);
    CGF.ReturnValue.$assign(OldReturnValue);
    CGF.FnRetTy.$assign(OldFnRetTy);
    CGF.CXXInheritedCtorInitExprArgs.$assignMove(
        std.move(OldCXXInheritedCtorInitExprArgs)
    );
    //START JDestroy
    OldCXXInheritedCtorInitExprArgs.$destroy();
    //END JDestroy
  }

/*private:*/
  protected/*private*/ final CodeGenFunction /*&*/ CGF;
  protected/*private*/ GlobalDecl OldCurGD;
  protected/*private*/ /*const*/ Decl /*P*/ OldCurFuncDecl;
  protected/*private*/ /*const*/ Decl /*P*/ OldCurCodeDecl;
  protected/*private*/ ImplicitParamDecl /*P*/ OldCXXABIThisDecl;
  protected/*private*/ Value /*P*/ OldCXXABIThisValue;
  protected/*private*/ Value /*P*/ OldCXXThisValue;
  protected/*private*/ CharUnits OldCXXABIThisAlignment;
  protected/*private*/ CharUnits OldCXXThisAlignment;
  protected/*private*/ Address OldReturnValue;
  protected/*private*/ QualType OldFnRetTy;
  protected/*private*/ CallArgList OldCXXInheritedCtorInitExprArgs;
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", OldCurGD=" + "[GlobalDecl]" // NOI18N
              + ", OldCurFuncDecl=" + "[Decl]" // NOI18N
              + ", OldCurCodeDecl=" + "[Decl]" // NOI18N
              + ", OldCXXABIThisDecl=" + "[ImplicitParamDecl]" // NOI18N
              + ", OldCXXABIThisValue=" + OldCXXABIThisValue // NOI18N
              + ", OldCXXThisValue=" + OldCXXThisValue // NOI18N
              + ", OldCXXABIThisAlignment=" + OldCXXABIThisAlignment // NOI18N
              + ", OldCXXThisAlignment=" + OldCXXThisAlignment // NOI18N
              + ", OldReturnValue=" + OldReturnValue // NOI18N
              + ", OldFnRetTy=" + OldFnRetTy // NOI18N
              + ", OldCXXInheritedCtorInitExprArgs=" + OldCXXInheritedCtorInitExprArgs; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2124,
 FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionE")
//</editor-fold>
public static class AutoVarEmission {
  /*friend  class CodeGenFunction*/
  
  protected/*private*/ /*const*/ VarDecl /*P*/ Variable;
  
  /// The address of the alloca.  Invalid if the variable was emitted
  /// as a global constant.
  protected/*private*/ Address Addr;
  
  protected/*private*/ Value /*P*/ NRVOFlag;
  
  /// True if the variable is a __block variable.
  protected/*private*/ boolean IsByRef;
  
  /// True if the variable is of aggregate type and has a constant
  /// initializer.
  protected/*private*/ boolean IsConstantAggregate;
  
  /// Non-null if we should use lifetime annotations.
  protected/*private*/ Value /*P*/ SizeForLifetimeMarkers;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::Invalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2145,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::Invalid", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7InvalidE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7InvalidE")
  //</editor-fold>
  protected/*private*/ static class/*struct*/ Invalid {
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::Invalid::Invalid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2145,
     FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::Invalid::Invalid", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7InvalidC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7InvalidC1EOS3_")
    //</editor-fold>
    public /*inline*/ Invalid(JD$Move _dparam, final Invalid /*&&*/$Prm0) {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Invalid() { }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2146,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1ENS2_7InvalidE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1ENS2_7InvalidE")
  //</editor-fold>
  protected/*private*/ AutoVarEmission(Invalid $Prm0) {
    // : Variable(null), Addr(Address::invalid()) 
    //START JInit
    this.Variable = null;
    this.Addr = Address.invalid();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2148,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1ERKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1ERKNS_7VarDeclE")
  //</editor-fold>
  protected/*private*/ AutoVarEmission(final /*const*/ VarDecl /*&*/ variable) {
    // : Variable(&variable), Addr(Address::invalid()), NRVOFlag(null), IsByRef(false), IsConstantAggregate(false), SizeForLifetimeMarkers(null) 
    //START JInit
    this.Variable = $AddrOf(variable);
    this.Addr = Address.invalid();
    this.NRVOFlag = null;
    this.IsByRef = false;
    this.IsConstantAggregate = false;
    this.SizeForLifetimeMarkers = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::wasEmittedAsGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2153,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::wasEmittedAsGlobal", NM="_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission18wasEmittedAsGlobalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission18wasEmittedAsGlobalEv")
  //</editor-fold>
  protected/*private*/ final boolean wasEmittedAsGlobal() /*const*/ {
    return !Addr.isValid();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::invalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2156,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::invalid", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7invalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmission7invalidEv")
  //</editor-fold>
  public static AutoVarEmission invalid() {
    return new AutoVarEmission(new Invalid());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::useLifetimeMarkers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2158,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::useLifetimeMarkers", NM="_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission18useLifetimeMarkersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission18useLifetimeMarkersEv")
  //</editor-fold>
  public final boolean useLifetimeMarkers() /*const*/ {
    return SizeForLifetimeMarkers != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::getSizeForLifetimeMarkers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2161,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::getSizeForLifetimeMarkers", NM="_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission25getSizeForLifetimeMarkersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission25getSizeForLifetimeMarkersEv")
  //</editor-fold>
  public final Value /*P*/ getSizeForLifetimeMarkers() /*const*/ {
    assert (useLifetimeMarkers());
    return SizeForLifetimeMarkers;
  }

  
  /// Returns the raw, allocated address, which is not necessarily
  /// the address of the object itself.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::getAllocatedAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2168,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::getAllocatedAddress", NM="_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission19getAllocatedAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission19getAllocatedAddressEv")
  //</editor-fold>
  public final Address getAllocatedAddress() /*const*/ {
    return new Address(Addr);
  }

  
  /// Returns the address of the object within this declaration.
  /// Note that this does not chase the forwarding pointer for
  /// __block decls.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::getObjectAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2175,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::getObjectAddress", NM="_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission16getObjectAddressERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15AutoVarEmission16getObjectAddressERS1_")
  //</editor-fold>
  public final Address getObjectAddress(final CodeGenFunction /*&*/ CGF) /*const*/ {
    if (!IsByRef) {
      return new Address(Addr);
    }
    
    return CGF.emitBlockByrefAddress(new Address(Addr), Variable, /*forward*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2124,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::AutoVarEmission", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionC1EOS2_")
  //</editor-fold>
  public /*inline*/ AutoVarEmission(JD$Move _dparam, final AutoVarEmission /*&&*/$Prm0) {
    // : Variable(static_cast<AutoVarEmission &&>().Variable), Addr(static_cast<AutoVarEmission &&>().Addr), NRVOFlag(static_cast<AutoVarEmission &&>().NRVOFlag), IsByRef(static_cast<AutoVarEmission &&>().IsByRef), IsConstantAggregate(static_cast<AutoVarEmission &&>().IsConstantAggregate), SizeForLifetimeMarkers(static_cast<AutoVarEmission &&>().SizeForLifetimeMarkers) 
    //START JInit
    this.Variable = $Prm0.Variable;
    this.Addr = new Address(JD$Move.INSTANCE, $Prm0.Addr);
    this.NRVOFlag = $Prm0.NRVOFlag;
    this.IsByRef = $Prm0.IsByRef;
    this.IsConstantAggregate = $Prm0.IsConstantAggregate;
    this.SizeForLifetimeMarkers = $Prm0.SizeForLifetimeMarkers;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AutoVarEmission::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2124,
   FQN="clang::CodeGen::CodeGenFunction::AutoVarEmission::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15AutoVarEmissionaSEOS2_")
  //</editor-fold>
  public final /*inline*/ AutoVarEmission /*&*/ $assignMove(final AutoVarEmission /*&&*/$Prm0) {
    this.Variable = $Prm0.Variable;
    this.Addr.$assignMove($Prm0.Addr);
    this.NRVOFlag = $Prm0.NRVOFlag;
    this.IsByRef = $Prm0.IsByRef;
    this.IsConstantAggregate = $Prm0.IsConstantAggregate;
    this.SizeForLifetimeMarkers = $Prm0.SizeForLifetimeMarkers;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Variable=" + "[VarDecl]" // NOI18N
              + ", Addr=" + Addr // NOI18N
              + ", NRVOFlag=" + NRVOFlag // NOI18N
              + ", IsByRef=" + IsByRef // NOI18N
              + ", IsConstantAggregate=" + IsConstantAggregate // NOI18N
              + ", SizeForLifetimeMarkers=" + SizeForLifetimeMarkers; // NOI18N
  }
}

/// Struct with all informations about dynamic [sub]class needed to set vptr.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::VPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1441,
 FQN="clang::CodeGen::CodeGenFunction::VPtr", NM="_ZN5clang7CodeGen15CodeGenFunction4VPtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction4VPtrE")
//</editor-fold>
public static class/*struct*/ VPtr {
  public BaseSubobject Base;
  public /*const*/ CXXRecordDecl /*P*/ NearestVBase;
  public CharUnits OffsetFromNearestVBase;
  public /*const*/ CXXRecordDecl /*P*/ VTableClass;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::VPtr::VPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1441,
   FQN="clang::CodeGen::CodeGenFunction::VPtr::VPtr", NM="_ZN5clang7CodeGen15CodeGenFunction4VPtrC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction4VPtrC1ERKS2_")
  //</editor-fold>
  public /*inline*/ VPtr(final /*const*/ VPtr /*&*/ $Prm0) {
    // : Base(.Base), NearestVBase(.NearestVBase), OffsetFromNearestVBase(.OffsetFromNearestVBase), VTableClass(.VTableClass) 
    //START JInit
    this.Base = new BaseSubobject($Prm0.Base);
    this.NearestVBase = $Prm0.NearestVBase;
    this.OffsetFromNearestVBase = new CharUnits($Prm0.OffsetFromNearestVBase);
    this.VTableClass = $Prm0.VTableClass;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::VPtr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1441,
   FQN="clang::CodeGen::CodeGenFunction::VPtr::operator=", NM="_ZN5clang7CodeGen15CodeGenFunction4VPtraSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction4VPtraSEOS2_")
  //</editor-fold>
  public final /*inline*/ VPtr /*&*/ $assignMove(final VPtr /*&&*/$Prm0) {
    this.Base.$assignMove($Prm0.Base);
    this.NearestVBase = $Prm0.NearestVBase;
    this.OffsetFromNearestVBase.$assignMove($Prm0.OffsetFromNearestVBase);
    this.VTableClass = $Prm0.VTableClass;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public VPtr() {
  }

  public VPtr(BaseSubobject Base, CXXRecordDecl NearestVBase, CharUnits OffsetFromNearestVBase, CXXRecordDecl VTableClass) {
    this.Base = Base;
    this.NearestVBase = NearestVBase;
    this.OffsetFromNearestVBase = OffsetFromNearestVBase;
    this.VTableClass = VTableClass;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", NearestVBase=" + "[CXXRecordDecl]" // NOI18N
              + ", OffsetFromNearestVBase=" + OffsetFromNearestVBase // NOI18N
              + ", VTableClass=" + "[CXXRecordDecl]"; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2190,
 FQN="clang::CodeGen::CodeGenFunction::ParamValue", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValueE")
//</editor-fold>
public static class ParamValue implements NativeCloneable<ParamValue>, NativeMoveable<ParamValue> {
  protected/*private*/ Value /*P*/ Value;
  protected/*private*/ /*uint*/int Alignment;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2193,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1EPN4llvm5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1EPN4llvm5ValueEj")
  //</editor-fold>
  protected/*private*/ ParamValue(Value /*P*/ V, /*uint*/int A) {
    // : Value(V), Alignment(A) 
    //START JInit
    this.Value = V;
    this.Alignment = A;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::forDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2195,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::forDirect", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValue9forDirectEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValue9forDirectEPN4llvm5ValueE")
  //</editor-fold>
  public static ParamValue forDirect(Value /*P*/ value) {
    return new ParamValue(value, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::forIndirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2198,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::forIndirect", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValue11forIndirectENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValue11forIndirectENS0_7AddressE")
  //</editor-fold>
  public static ParamValue forIndirect(Address addr) {
    assert (!addr.getAlignment().isZero());
    return new ParamValue(addr.getPointer(), $long2uint(addr.getAlignment().getQuantity()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::isIndirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2203,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::isIndirect", NM="_ZNK5clang7CodeGen15CodeGenFunction10ParamValue10isIndirectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction10ParamValue10isIndirectEv")
  //</editor-fold>
  public final boolean isIndirect() /*const*/ {
    return Alignment != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::getAnyValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2204,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::getAnyValue", NM="_ZNK5clang7CodeGen15CodeGenFunction10ParamValue11getAnyValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction10ParamValue11getAnyValueEv")
  //</editor-fold>
  public final Value /*P*/ getAnyValue() /*const*/ {
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::getDirectValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2206,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::getDirectValue", NM="_ZNK5clang7CodeGen15CodeGenFunction10ParamValue14getDirectValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction10ParamValue14getDirectValueEv")
  //</editor-fold>
  public final Value /*P*/ getDirectValue() /*const*/ {
    assert (!isIndirect());
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::getIndirectAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2211,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::getIndirectAddress", NM="_ZNK5clang7CodeGen15CodeGenFunction10ParamValue18getIndirectAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction10ParamValue18getIndirectAddressEv")
  //</editor-fold>
  public final Address getIndirectAddress() /*const*/ {
    assert (isIndirect());
    return new Address(Value, CharUnits.fromQuantity($uint2long(Alignment)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2190,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ParamValue(final /*const*/ ParamValue /*&*/ $Prm0) {
    // : Value(.Value), Alignment(.Alignment) 
    //START JInit
    this.Value = $Prm0.Value;
    this.Alignment = $Prm0.Alignment;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2190,
   FQN="clang::CodeGen::CodeGenFunction::ParamValue::ParamValue", NM="_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10ParamValueC1EOS2_")
  //</editor-fold>
  public /*inline*/ ParamValue(JD$Move _dparam, final ParamValue /*&&*/$Prm0) {
    // : Value(static_cast<ParamValue &&>().Value), Alignment(static_cast<ParamValue &&>().Alignment) 
    //START JInit
    this.Value = $Prm0.Value;
    this.Alignment = $Prm0.Alignment;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ParamValue() {
  }

  @Override
  public ParamValue clone() {
    return new ParamValue(this);
  }

  @Override
  public ParamValue move() {
    return new ParamValue(JD$Move.INSTANCE, this);
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Alignment=" + Alignment; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2746,
 FQN="clang::CodeGen::CodeGenFunction::ConstantEmission", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionE")
//</editor-fold>
public static class ConstantEmission implements Native.Native$Bool {
  protected/*private*/ PointerBoolPair<Constant /*P*/ > ValueAndIsReference;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2748,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1EPN4llvm8ConstantEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1EPN4llvm8ConstantEb")
  //</editor-fold>
  protected/*private*/ ConstantEmission(Constant /*P*/ C, boolean isReference) {
    // : ValueAndIsReference(C, isReference) 
    //START JInit
    this.ValueAndIsReference = new PointerBoolPair<Constant /*P*/ >(C, isReference);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2751,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1Ev")
  //</editor-fold>
  public ConstantEmission() {
    // : ValueAndIsReference() 
    //START JInit
    this.ValueAndIsReference = new PointerBoolPair<Constant /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::forReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2752,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::forReference", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmission12forReferenceEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmission12forReferenceEPN4llvm8ConstantE")
  //</editor-fold>
  public static ConstantEmission forReference(Constant /*P*/ C) {
    return new ConstantEmission(C, true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::forValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2755,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::forValue", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmission8forValueEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmission8forValueEPN4llvm8ConstantE")
  //</editor-fold>
  public static ConstantEmission forValue(Constant /*P*/ C) {
    return new ConstantEmission(C, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2759,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::operator bool", NM="_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmissioncvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmissioncvbEv")
  //</editor-fold>
  public final boolean $bool() /*const*/ {
    return $noteq_ptr(ValueAndIsReference.getOpaqueValue(), null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::isReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2763,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::isReference", NM="_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission11isReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission11isReferenceEv")
  //</editor-fold>
  public final boolean isReference() /*const*/ {
    return ValueAndIsReference.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::getReferenceLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2764,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::getReferenceLValue", NM="_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission18getReferenceLValueERS1_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission18getReferenceLValueERS1_PNS_4ExprE")
  //</editor-fold>
  public final LValue getReferenceLValue(final CodeGenFunction /*&*/ CGF, Expr /*P*/ refExpr) /*const*/ {
    assert (isReference());
    return CGF.MakeNaturalAlignAddrLValue(ValueAndIsReference.getPointer(), 
        refExpr.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2770,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::getValue", NM="_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction16ConstantEmission8getValueEv")
  //</editor-fold>
  public final Constant /*P*/ getValue() /*const*/ {
    assert (!isReference());
    return ValueAndIsReference.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2746,
   FQN="clang::CodeGen::CodeGenFunction::ConstantEmission::ConstantEmission", NM="_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ConstantEmissionC1EOS2_")
  //</editor-fold>
  public /*inline*/ ConstantEmission(JD$Move _dparam, final ConstantEmission /*&&*/$Prm0) {
    // : ValueAndIsReference(static_cast<ConstantEmission &&>().ValueAndIsReference) 
    //START JInit
    this.ValueAndIsReference = new PointerBoolPair<Constant /*P*/ >(JD$Move.INSTANCE, $Prm0.ValueAndIsReference);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "ValueAndIsReference=" + ValueAndIsReference; // NOI18N
  }
}
} // END OF class CodeGenFunction_NestedClasses
