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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.java.CodegenRTTI.*;


/// \brief API for captured statement code generation in OpenMP constructs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 128,
 FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoE")
//</editor-fold>
public final class CGOpenMPTaskOutlinedRegionInfo extends /*public*/ CGOpenMPRegionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 130,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyE")
  //</editor-fold>
  public static final class UntiedTaskActionTy extends /*public*/ PrePostActionTy implements Destructors.ClassWithDestructor {
    private boolean Untied;
    private /*const*/ VarDecl /*P*/ PartIDVar;
    private /*const*/ RegionCodeGenTy UntiedCodeGen;
    private SwitchInst /*P*/ UntiedSwitch/* = null*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::UntiedTaskActionTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 137,
     FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::UntiedTaskActionTy", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyC1EbPKN5clang7VarDeclERKNS2_7CodeGen15RegionCodeGenTyE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyC1EbPKN5clang7VarDeclERKNS2_7CodeGen15RegionCodeGenTyE")
    //</editor-fold>
    public UntiedTaskActionTy(boolean Tied, /*const*/ VarDecl /*P*/ PartIDVar, 
        final /*const*/ RegionCodeGenTy /*&*/ UntiedCodeGen) {
      // : PrePostActionTy(), Untied(!Tied), PartIDVar(PartIDVar), UntiedCodeGen(UntiedCodeGen), UntiedSwitch(null) 
      //START JInit
      super();
      this.Untied = !Tied;
      this.PartIDVar = PartIDVar;
      this.UntiedCodeGen = new RegionCodeGenTy(UntiedCodeGen);
      /*InClass*/this.UntiedSwitch = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::Enter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 140,
     FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::Enter", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy5EnterERN5clang7CodeGen15CodeGenFunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy5EnterERN5clang7CodeGen15CodeGenFunctionE")
    //</editor-fold>
    @Override public void Enter(final CodeGenFunction /*&*/ CGF)/* override*/ {
      if (Untied) {
        // Emit task switching point.
        LValue PartIdLVal = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar(PartIDVar), 
            PartIDVar.getType().$arrow().castAs(org.clang.ast.PointerType.class));
        Value /*P*/ Res = CGF.EmitLoadOfScalar(new LValue(PartIdLVal), new SourceLocation());
        BasicBlock /*P*/ DoneBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".untied.done."));
        UntiedSwitch = CGF.Builder.CreateSwitch(Res, DoneBB);
        CGF.EmitBlock(DoneBB);
        CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CGF.ReturnBlock));
        CGF.EmitBlock(CGF.createBasicBlock(new Twine(/*KEEP_STR*/".untied.jmp.")));
        UntiedSwitch.addCase(CGF.Builder.getInt32(0), 
            CGF.Builder.GetInsertBlock());
        emitUntiedSwitch(CGF);
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::emitUntiedSwitch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 157,
     FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::emitUntiedSwitch", NM="_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE")
    //</editor-fold>
    public void emitUntiedSwitch(final CodeGenFunction /*&*/ CGF) /*const*/ {
      if (Untied) {
        LValue PartIdLVal = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar(PartIDVar), 
            PartIDVar.getType().$arrow().castAs(org.clang.ast.PointerType.class));
        CGF.EmitStoreOfScalar(CGF.Builder.getInt32(UntiedSwitch.getNumCases()), 
            new LValue(PartIdLVal));
        UntiedCodeGen.$call(CGF);
        CodeGenFunction.JumpDest CurPoint = CGF.getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/".untied.next."));
        CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CGF.ReturnBlock));
        CGF.EmitBlock(CGF.createBasicBlock(new Twine(/*KEEP_STR*/".untied.jmp.")));
        UntiedSwitch.addCase(CGF.Builder.getInt32(UntiedSwitch.getNumCases()), 
            CGF.Builder.GetInsertBlock());
        CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CurPoint));
        CGF.EmitBlock(CurPoint.getBlock());
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::getNumberOfParts">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 175,
     FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::getNumberOfParts", NM="_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy16getNumberOfPartsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTy16getNumberOfPartsEv")
    //</editor-fold>
    public /*uint*/int getNumberOfParts() /*const*/ {
      return UntiedSwitch.getNumCases();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::~UntiedTaskActionTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 130,
     FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::UntiedTaskActionTy::~UntiedTaskActionTy", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo18UntiedTaskActionTyD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "Untied=" + Untied // NOI18N
                + ", PartIDVar=" + "[VarDecl]" // NOI18N
                + ", UntiedCodeGen=" + UntiedCodeGen // NOI18N
                + ", UntiedSwitch=" + UntiedSwitch // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::CGOpenMPTaskOutlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 177,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::CGOpenMPTaskOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoC1ERKN5clang12CapturedStmtEPKNS1_7VarDeclERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEbRKNS0_18UntiedTaskActionTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoC1ERKN5clang12CapturedStmtEPKNS1_7VarDeclERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEbRKNS0_18UntiedTaskActionTyE")
  //</editor-fold>
  public CGOpenMPTaskOutlinedRegionInfo(final /*const*/ CapturedStmt /*&*/ CS, 
      /*const*/ VarDecl /*P*/ ThreadIDVar, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
      OpenMPDirectiveKind Kind, boolean HasCancel, 
      final /*const*/ UntiedTaskActionTy /*&*/ Action) {
    // : CGOpenMPRegionInfo(CS, TaskOutlinedRegion, CodeGen, Kind, HasCancel), ThreadIDVar(ThreadIDVar), Action(Action) 
    //START JInit
    super(CS, CGOpenMPRegionKind.TaskOutlinedRegion, CodeGen, Kind, HasCancel);
    this.ThreadIDVar = ThreadIDVar;
    this./*&*/Action=/*&*/Action;
    //END JInit
    assert (ThreadIDVar != null) : "No ThreadID in OpenMP region.";
  }

  
  /// \brief Get a variable or parameter for storing global thread id
  /// inside OpenMP construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 189,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo19getThreadIDVariableEv")
  //</editor-fold>
  @Override public /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* override*/ {
    return ThreadIDVar;
  }

  
  /// \brief Get an LValue for the current ThreadID variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getThreadIDVariableLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 716,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getThreadIDVariableLValue", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo25getThreadIDVariableLValueERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo25getThreadIDVariableLValueERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public LValue getThreadIDVariableLValue(final CodeGenFunction /*&*/ CGF)/* override*/ {
    return CGF.MakeAddrLValue(CGF.GetAddrOfLocalVar(getThreadIDVariable()), 
        getThreadIDVariable().getType(), 
        AlignmentSource.Decl);
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 195,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::getHelperName", NM="_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo13getHelperNameEv")
  //</editor-fold>
  @Override public StringRef getHelperName() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/".omp_outlined.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::emitUntiedSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 197,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::emitUntiedSwitch", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void emitUntiedSwitch(final CodeGenFunction /*&*/ CGF)/* override*/ {
    Action.emitUntiedSwitch(CGF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 201,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::classof", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return CGOpenMPRegionInfo.classof(Info)
       && cast_CGOpenMPRegionInfo(Info).getRegionKind()
       == CGOpenMPRegionKind.TaskOutlinedRegion;
  }

/*private:*/
  /// \brief A variable or parameter storing global thread id for OpenMP
  /// constructs.
  private /*const*/ VarDecl /*P*/ ThreadIDVar;
  /// Action for emitting code for untied tasks.
  private final /*const*/ UntiedTaskActionTy /*&*/ Action;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::~CGOpenMPTaskOutlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 128,
   FQN="(anonymous namespace)::CGOpenMPTaskOutlinedRegionInfo::~CGOpenMPTaskOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_130CGOpenMPTaskOutlinedRegionInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ThreadIDVar=" + "[VarDecl]" // NOI18N
              + ", Action=" + Action // NOI18N
              + super.toString(); // NOI18N
  }
}
