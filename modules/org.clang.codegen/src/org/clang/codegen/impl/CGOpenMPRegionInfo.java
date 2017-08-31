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
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;

/// \brief Base class for handling code generation inside OpenMP regions.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 35,
 FQN="(anonymous namespace)::CGOpenMPRegionInfo", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfoE")
//</editor-fold>
public abstract class CGOpenMPRegionInfo extends /*public*/ CodeGenFunction.CGCapturedStmtInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Kinds of OpenMP regions used in codegen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 38,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionKind", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfo18CGOpenMPRegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfo18CGOpenMPRegionKindE")
  //</editor-fold>
  public enum CGOpenMPRegionKind implements Native.NativeUIntEnum {
    /// \brief Region with outlined function for standalone 'parallel'
    /// directive.
    ParallelOutlinedRegion(0),
    /// \brief Region with outlined function for standalone 'task' directive.
    TaskOutlinedRegion(ParallelOutlinedRegion.getValue() + 1),
    /// \brief Region for constructs that do not require function outlining,
    /// like 'for', 'sections', 'atomic' etc. directives.
    InlinedRegion(TaskOutlinedRegion.getValue() + 1),
    /// \brief Region with outlined function for standalone 'target' directive.
    TargetRegion(InlinedRegion.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CGOpenMPRegionKind valueOf(int val) {
      CGOpenMPRegionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CGOpenMPRegionKind[] VALUES;
      private static final CGOpenMPRegionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CGOpenMPRegionKind kind : CGOpenMPRegionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CGOpenMPRegionKind[min < 0 ? (1-min) : 0];
        VALUES = new CGOpenMPRegionKind[max >= 0 ? (1+max) : 0];
        for (CGOpenMPRegionKind kind : CGOpenMPRegionKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private CGOpenMPRegionKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 51,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionInfo", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfoC1ERKN5clang12CapturedStmtENS0_18CGOpenMPRegionKindERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfoC1ERKN5clang12CapturedStmtENS0_18CGOpenMPRegionKindERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb")
  //</editor-fold>
  public CGOpenMPRegionInfo(final /*const*/ CapturedStmt /*&*/ CS, 
      /*const*/ CGOpenMPRegionKind RegionKind, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, OpenMPDirectiveKind Kind, 
      boolean HasCancel) {
    // : CGCapturedStmtInfo(CS, CR_OpenMP), RegionKind(RegionKind), CodeGen(CodeGen), Kind(Kind), HasCancel(HasCancel) 
    //START JInit
    super(CS, CapturedRegionKind.CR_OpenMP);
    this.RegionKind = RegionKind;
    this.CodeGen = new RegionCodeGenTy(CodeGen);
    this.Kind = Kind;
    this.HasCancel = HasCancel;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 58,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::CGOpenMPRegionInfo", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfoC1ENS0_18CGOpenMPRegionKindERKN5clang7CodeGen15RegionCodeGenTyENS2_19OpenMPDirectiveKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfoC1ENS0_18CGOpenMPRegionKindERKN5clang7CodeGen15RegionCodeGenTyENS2_19OpenMPDirectiveKindEb")
  //</editor-fold>
  public CGOpenMPRegionInfo(/*const*/ CGOpenMPRegionKind RegionKind, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, OpenMPDirectiveKind Kind, 
      boolean HasCancel) {
    // : CGCapturedStmtInfo(CR_OpenMP), RegionKind(RegionKind), CodeGen(CodeGen), Kind(Kind), HasCancel(HasCancel) 
    //START JInit
    super(CapturedRegionKind.CR_OpenMP);
    this.RegionKind = RegionKind;
    this.CodeGen = new RegionCodeGenTy(CodeGen);
    this.Kind = Kind;
    this.HasCancel = HasCancel;
    //END JInit
  }

  
  /// \brief Get a variable or parameter for storing global thread id
  /// inside OpenMP construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 66,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo19getThreadIDVariableEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* = 0*/;

  
  /// \brief Emit the captured statement body.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::EmitBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 703,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::EmitBody", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfo8EmitBodyERN5clang7CodeGen15CodeGenFunctionEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfo8EmitBodyERN5clang7CodeGen15CodeGenFunctionEPKNS1_4StmtE")
  //</editor-fold>
  @Override public void EmitBody(final CodeGenFunction /*&*/ CGF, /*const*/ Stmt /*P*/ $Prm1/*S*/)/* override*/ {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CGF.EHStack.pushTerminate();
    CodeGen.$call(CGF);
    CGF.EHStack.popTerminate();
  }

  
  /// \brief Get an LValue for the current ThreadID variable.
  /// \return LValue for thread id variable. This LValue always has type int32*.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::getThreadIDVariableLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 697,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::getThreadIDVariableLValue", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfo25getThreadIDVariableLValueERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfo25getThreadIDVariableLValueERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public LValue getThreadIDVariableLValue(final CodeGenFunction /*&*/ CGF) {
    return CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar(getThreadIDVariable()), 
        getThreadIDVariable().getType().$arrow().castAs(org.clang.ast.PointerType.class));
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::emitUntiedSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 75,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::emitUntiedSwitch", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public /*virtual*/ void emitUntiedSwitch(final CodeGenFunction /*&*/ $Prm0/*CGF*/) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::getRegionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 77,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::getRegionKind", NM="_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo13getRegionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo13getRegionKindEv")
  //</editor-fold>
  public CGOpenMPRegionKind getRegionKind() /*const*/ {
    return RegionKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::getDirectiveKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 79,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::getDirectiveKind", NM="_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo16getDirectiveKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo16getDirectiveKindEv")
  //</editor-fold>
  public OpenMPDirectiveKind getDirectiveKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::hasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 81,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::hasCancel", NM="_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo9hasCancelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_118CGOpenMPRegionInfo9hasCancelEv")
  //</editor-fold>
  public boolean hasCancel() /*const*/ {
    return HasCancel;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 83,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::classof", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return Info.getKind() == CapturedRegionKind.CR_OpenMP;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPRegionInfo::~CGOpenMPRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 87,
   FQN="(anonymous namespace)::CGOpenMPRegionInfo::~CGOpenMPRegionInfo", NM="_ZN12_GLOBAL__N_118CGOpenMPRegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_118CGOpenMPRegionInfoD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*//* = default*/ {
    super.$destroy();
  }

/*protected:*/
  protected CGOpenMPRegionKind RegionKind;
  protected RegionCodeGenTy CodeGen;
  protected OpenMPDirectiveKind Kind;
  protected boolean HasCancel;
  
  @Override public String toString() {
    return "" + "RegionKind=" + RegionKind // NOI18N
              + ", CodeGen=" + CodeGen // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", HasCancel=" + HasCancel // NOI18N
              + super.toString(); // NOI18N
  }
}
