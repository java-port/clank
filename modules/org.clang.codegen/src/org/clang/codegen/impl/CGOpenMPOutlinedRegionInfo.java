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


/// \brief API for captured statement code generation in OpenMP constructs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 97,
 FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoE")
//</editor-fold>
public final class CGOpenMPOutlinedRegionInfo extends /*public*/ CGOpenMPRegionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::CGOpenMPOutlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 99,
   FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::CGOpenMPOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoC1ERKN5clang12CapturedStmtEPKNS1_7VarDeclERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoC1ERKN5clang12CapturedStmtEPKNS1_7VarDeclERKNS1_7CodeGen15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb")
  //</editor-fold>
  public CGOpenMPOutlinedRegionInfo(final /*const*/ CapturedStmt /*&*/ CS, /*const*/ VarDecl /*P*/ ThreadIDVar, 
      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
      OpenMPDirectiveKind Kind, boolean HasCancel) {
    // : CGOpenMPRegionInfo(CS, ParallelOutlinedRegion, CodeGen, Kind, HasCancel), ThreadIDVar(ThreadIDVar) 
    //START JInit
    super(CS, CGOpenMPRegionKind.ParallelOutlinedRegion, CodeGen, Kind, 
        HasCancel);
    this.ThreadIDVar = ThreadIDVar;
    //END JInit
    assert (ThreadIDVar != null) : "No ThreadID in OpenMP region.";
  }

  
  /// \brief Get a variable or parameter for storing global thread id
  /// inside OpenMP construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 110,
   FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo19getThreadIDVariableEv")
  //</editor-fold>
  @Override public /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* override*/ {
    return ThreadIDVar;
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 113,
   FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::getHelperName", NM="_ZNK12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo13getHelperNameEv")
  //</editor-fold>
  @Override public StringRef getHelperName() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/".omp_outlined.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 115,
   FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::classof", NM="_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return CGOpenMPRegionInfo.classof(Info)
       && cast_CGOpenMPRegionInfo(Info).getRegionKind()
       == CGOpenMPRegionKind.ParallelOutlinedRegion;
  }

/*private:*/
  /// \brief A variable or parameter storing global thread id for OpenMP
  /// constructs.
  private /*const*/ VarDecl /*P*/ ThreadIDVar;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::~CGOpenMPOutlinedRegionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 97,
   FQN="(anonymous namespace)::CGOpenMPOutlinedRegionInfo::~CGOpenMPOutlinedRegionInfo", NM="_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_126CGOpenMPOutlinedRegionInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ThreadIDVar=" + "[VarDecl]" // NOI18N
              + super.toString(); // NOI18N
  }
}
