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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.java.CodegenRTTI.*;


/// \brief API for inlined captured statement code generation in OpenMP
/// constructs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 217,
 FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoE")
//</editor-fold>
public class CGOpenMPInlinedRegionInfo extends /*public*/ CGOpenMPRegionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::CGOpenMPInlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 219,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::CGOpenMPInlinedRegionInfo", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoC1EPN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoERKNS2_15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoC1EPN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoERKNS2_15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb")
  //</editor-fold>
  public CGOpenMPInlinedRegionInfo(CodeGenFunction.CGCapturedStmtInfo /*P*/ OldCSI, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
      OpenMPDirectiveKind Kind, boolean HasCancel) {
    // : CGOpenMPRegionInfo(InlinedRegion, CodeGen, Kind, HasCancel), OldCSI(OldCSI), OuterRegionInfo(dyn_cast_or_null<CGOpenMPRegionInfo>(OldCSI)) 
    //START JInit
    super(CGOpenMPRegionKind.InlinedRegion, CodeGen, Kind, HasCancel);
    this.OldCSI = OldCSI;
    this.OuterRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(OldCSI);
    //END JInit
  }

  
  // \brief Retrieve the value of the context parameter.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getContextValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 227,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getContextValue", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo15getContextValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo15getContextValueEv")
  //</editor-fold>
  @Override public Value /*P*/ getContextValue() /*const*//* override*/ {
    if ((OuterRegionInfo != null)) {
      return OuterRegionInfo.getContextValue();
    }
    throw new llvm_unreachable("No context value for inlined OpenMP region");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::setContextValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 233,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::setContextValue", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo15setContextValueEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo15setContextValueEPN4llvm5ValueE")
  //</editor-fold>
  @Override public void setContextValue(Value /*P*/ V)/* override*/ {
    if ((OuterRegionInfo != null)) {
      OuterRegionInfo.setContextValue(V);
      return;
    }
    throw new llvm_unreachable("No context value for inlined OpenMP region");
  }

  
  /// \brief Lookup the captured field decl for a variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 242,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::lookup", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo6lookupEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo6lookupEPKN5clang7VarDeclE")
  //</editor-fold>
  @Override public /*const*/ FieldDecl /*P*/ lookup(/*const*/ VarDecl /*P*/ VD) /*const*//* override*/ {
    if ((OuterRegionInfo != null)) {
      return OuterRegionInfo.lookup(VD);
    }
    // If there is no outer outlined region,no need to lookup in a list of
    // captured variables, we can use the original one.
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getThisFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 250,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getThisFieldDecl", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo16getThisFieldDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo16getThisFieldDeclEv")
  //</editor-fold>
  @Override public FieldDecl /*P*/ getThisFieldDecl() /*const*//* override*/ {
    if ((OuterRegionInfo != null)) {
      return OuterRegionInfo.getThisFieldDecl();
    }
    return null;
  }

  
  /// \brief Get a variable or parameter for storing global thread id
  /// inside OpenMP construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 258,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo19getThreadIDVariableEv")
  //</editor-fold>
  @Override public /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* override*/ {
    if ((OuterRegionInfo != null)) {
      return OuterRegionInfo.getThreadIDVariable();
    }
    return null;
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 265,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getHelperName", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo13getHelperNameEv")
  //</editor-fold>
  @Override public StringRef getHelperName() /*const*//* override*/ {
    {
      CodeGenFunction.CGCapturedStmtInfo /*P*/ OuterRegionInfo = getOldCSI();
      if ((OuterRegionInfo != null)) {
        return OuterRegionInfo.getHelperName();
      }
    }
    throw new llvm_unreachable("No helper name for inlined OpenMP construct");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::emitUntiedSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 271,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::emitUntiedSwitch", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo16emitUntiedSwitchERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void emitUntiedSwitch(final CodeGenFunction /*&*/ CGF)/* override*/ {
    if ((OuterRegionInfo != null)) {
      OuterRegionInfo.emitUntiedSwitch(CGF);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getOldCSI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 276,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::getOldCSI", NM="_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo9getOldCSIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_125CGOpenMPInlinedRegionInfo9getOldCSIEv")
  //</editor-fold>
  public CodeGenFunction.CGCapturedStmtInfo /*P*/ getOldCSI() /*const*/ {
    return OldCSI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 278,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::classof", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return CGOpenMPRegionInfo.classof(Info)
       && cast_CGOpenMPRegionInfo(Info).getRegionKind() == CGOpenMPRegionKind.InlinedRegion;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInlinedRegionInfo::~CGOpenMPInlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 283,
   FQN="(anonymous namespace)::CGOpenMPInlinedRegionInfo::~CGOpenMPInlinedRegionInfo", NM="_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_125CGOpenMPInlinedRegionInfoD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*//* = default*/ {
    super.$destroy();
  }

/*private:*/
  /// \brief CodeGen info about outer OpenMP region.
  private CodeGenFunction.CGCapturedStmtInfo /*P*/ OldCSI;
  private CGOpenMPRegionInfo /*P*/ OuterRegionInfo;
  
  @Override public String toString() {
    return "" + "OldCSI=" + OldCSI // NOI18N
              + ", OuterRegionInfo=" + OuterRegionInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
