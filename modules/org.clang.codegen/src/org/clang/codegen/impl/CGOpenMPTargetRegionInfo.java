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
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.java.CodegenRTTI.*;


/// \brief API for captured statement code generation in OpenMP target
/// constructs. For this captures, implicit parameters are used instead of the
/// captured fields. The name of the target region has to be unique in a given
/// application so it is provided by the client, because only the client has
/// the information to generate that.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 296,
 FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo", NM="_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoE")
//</editor-fold>
public final class CGOpenMPTargetRegionInfo extends /*public*/ CGOpenMPRegionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo::CGOpenMPTargetRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 298,
   FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo::CGOpenMPTargetRegionInfo", NM="_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoC1ERKN5clang12CapturedStmtERKNS1_7CodeGen15RegionCodeGenTyEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoC1ERKN5clang12CapturedStmtERKNS1_7CodeGen15RegionCodeGenTyEN4llvm9StringRefE")
  //</editor-fold>
  public CGOpenMPTargetRegionInfo(final /*const*/ CapturedStmt /*&*/ CS, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, StringRef HelperName) {
    // : CGOpenMPRegionInfo(CS, TargetRegion, CodeGen, OMPD_target, /*HasCancel=*/ false), HelperName(HelperName) 
    //START JInit
    super(CS, CGOpenMPRegionKind.TargetRegion, CodeGen, OpenMPDirectiveKind.OMPD_target, 
        false);
    this.HelperName = new StringRef(HelperName);
    //END JInit
  }

  
  /// \brief This is unused for target regions because each starts executing
  /// with a single thread.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 306,
   FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_124CGOpenMPTargetRegionInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_124CGOpenMPTargetRegionInfo19getThreadIDVariableEv")
  //</editor-fold>
  @Override public /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* override*/ {
    return null;
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 309,
   FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo::getHelperName", NM="_ZNK12_GLOBAL__N_124CGOpenMPTargetRegionInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_124CGOpenMPTargetRegionInfo13getHelperNameEv")
  //</editor-fold>
  @Override public StringRef getHelperName() /*const*//* override*/ {
    return new StringRef(HelperName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 311,
   FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo::classof", NM="_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return CGOpenMPRegionInfo.classof(Info)
       && cast_CGOpenMPRegionInfo(Info).getRegionKind() == CGOpenMPRegionKind.TargetRegion;
  }

/*private:*/
  private StringRef HelperName;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPTargetRegionInfo::~CGOpenMPTargetRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 296,
   FQN="(anonymous namespace)::CGOpenMPTargetRegionInfo::~CGOpenMPTargetRegionInfo", NM="_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_124CGOpenMPTargetRegionInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "HelperName=" + HelperName // NOI18N
              + super.toString(); // NOI18N
  }
}
