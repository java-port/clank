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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.CodegenRTTI;


/// \brief RAII for emitting code of OpenMP constructs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InlinedOpenMPRegionRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 385,
 FQN="(anonymous namespace)::InlinedOpenMPRegionRAII", NM="_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIIE")
//</editor-fold>
public class InlinedOpenMPRegionRAII implements Destructors.ClassWithDestructor {
  private final CodeGenFunction /*&*/ CGF;
  private DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ > LambdaCaptureFields;
  private FieldDecl /*P*/ LambdaThisCaptureField/* = null*/;
/*public:*/
  /// \brief Constructs region for combined constructs.
  /// \param CodeGen Code generation sequence for combined directives. Includes
  /// a list of functions used for code generation of implicitly inlined
  /// regions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InlinedOpenMPRegionRAII::InlinedOpenMPRegionRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 395,
   FQN="(anonymous namespace)::InlinedOpenMPRegionRAII::InlinedOpenMPRegionRAII", NM="_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIIC1ERN5clang7CodeGen15CodeGenFunctionERKNS2_15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIIC1ERN5clang7CodeGen15CodeGenFunctionERKNS2_15RegionCodeGenTyENS1_19OpenMPDirectiveKindEb")
  //</editor-fold>
  public InlinedOpenMPRegionRAII(final CodeGenFunction /*&*/ CGF, final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
      OpenMPDirectiveKind Kind, boolean HasCancel) {
    // : CGF(CGF), LambdaCaptureFields(), LambdaThisCaptureField(null) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.LambdaCaptureFields = new DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    /*InClass*/this.LambdaThisCaptureField = null;
    //END JInit
    // Start emission for the construct.
    CGF.CapturedStmtInfo = new CGOpenMPInlinedRegionInfo(CGF.CapturedStmtInfo, CodeGen, Kind, HasCancel);
    { //std.swap(CGF.LambdaCaptureFields, LambdaCaptureFields);
      DenseMap<VarDecl, FieldDecl> tmp = CGF.LambdaCaptureFields;
      CGF.LambdaCaptureFields = LambdaCaptureFields;
      LambdaCaptureFields = tmp;
    }
    LambdaThisCaptureField = CGF.LambdaThisCaptureField;
    CGF.LambdaThisCaptureField = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InlinedOpenMPRegionRAII::~InlinedOpenMPRegionRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 406,
   FQN="(anonymous namespace)::InlinedOpenMPRegionRAII::~InlinedOpenMPRegionRAII", NM="_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_123InlinedOpenMPRegionRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    // Restore original CapturedStmtInfo only if we're done with code emission.
    CodeGenFunction.CGCapturedStmtInfo /*P*/ OldCSI = CodegenRTTI.cast_CGOpenMPInlinedRegionInfo(CGF.CapturedStmtInfo).getOldCSI();
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)CGF.CapturedStmtInfo);
    CGF.CapturedStmtInfo = OldCSI;
    { // std.swap(CGF.LambdaCaptureFields, LambdaCaptureFields);
      DenseMap<VarDecl, FieldDecl> tmp = CGF.LambdaCaptureFields;
      CGF.LambdaCaptureFields = LambdaCaptureFields;
      LambdaCaptureFields = tmp;
    }
    CGF.LambdaThisCaptureField = LambdaThisCaptureField;
    //START JDestroy
    LambdaCaptureFields.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", LambdaCaptureFields=" + "[DenseMap$VarDecl$FieldDecl]" // NOI18N
              + ", LambdaThisCaptureField=" + "[FieldDecl]"; // NOI18N
  }
}
