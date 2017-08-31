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

import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;


/// Class provides a way to call simple version of codegen for OpenMP region, or
/// an advanced with possible pre|post-actions in codegen.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 64,
 FQN="clang::CodeGen::RegionCodeGenTy", NM="_ZN5clang7CodeGen15RegionCodeGenTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15RegionCodeGenTyE")
//</editor-fold>
public final class RegionCodeGenTy {
  private Object/*intptr_t*/ CodeGen;
  // JAVA: typedef void (*CodeGenTy)(intptr_t, CodeGenFunction &, PrePostActionTy &);
  private CodeGenTy Callback;
  private /*mutable */PrePostActionTy /*P*/ PrePostAction;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 69,
   FQN="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy", NM="_ZN5clang7CodeGen15RegionCodeGenTyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15RegionCodeGenTyC1Ev")
  //</editor-fold>
  protected/*private*/ RegionCodeGenTy() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 70,
   FQN="clang::CodeGen::RegionCodeGenTy::operator=", NM="_ZN5clang7CodeGen15RegionCodeGenTyaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15RegionCodeGenTyaSERKS1_")
  //</editor-fold>
  protected/*private*/ RegionCodeGenTy /*&*/ $assign(final /*const*/ RegionCodeGenTy /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*template <typename Callable> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::CallbackFn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 72,
   FQN="clang::CodeGen::RegionCodeGenTy::CallbackFn", NM="Tpl__ZN5clang7CodeGen15RegionCodeGenTy10CallbackFnEiRNS0_15CodeGenFunctionERNS0_15PrePostActionTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=Tpl__ZN5clang7CodeGen15RegionCodeGenTy10CallbackFnEiRNS0_15CodeGenFunctionERNS0_15PrePostActionTyE")
  //</editor-fold>
  private static void CallbackFn(Object/*intptr_t*/ CodeGen, final CodeGenFunction /*&*/ CGF, 
            final PrePostActionTy /*&*/ Action) {
    reinterpret_cast(CodeGenFunctionPrePostActionTy2Void /*P*/ .class, CodeGen).$call(CGF, Action);
    /*JAVA:return*/return;
  }

/*public:*/
  /*template <typename Callable> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 79,
   FQN="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy", NM="Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE")
  //</editor-fold>
  public </*typename*/ Callable extends CodeGenTy> RegionCodeGenTy(JD$NotSameRegionCodeGenTy _dparam, final Callable /*&&*/CodeGen) {
    // : CodeGen(reinterpret_cast<intptr_t>(& CodeGen)), Callback(CallbackFn< std::remove_reference<Callable>::type>), PrePostAction(null) 
    //START JInit
    this.CodeGen = reinterpret_cast_Object/*intptr_t*/(Native.$addr(CodeGen));
    this.Callback = RegionCodeGenTy::CallbackFn; // /*ParenListExpr*/CallbackFn< std.remove_reference.type<Callable> >;
    this.PrePostAction = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::setAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 87,
   FQN="clang::CodeGen::RegionCodeGenTy::setAction", NM="_ZNK5clang7CodeGen15RegionCodeGenTy9setActionERNS0_15PrePostActionTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15RegionCodeGenTy9setActionERNS0_15PrePostActionTyE")
  //</editor-fold>
  public void setAction(final PrePostActionTy /*&*/ Action) /*const*/ {
    PrePostAction = /*AddrOf*/Action;
  }

  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::operator()">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 686,
   FQN="clang::CodeGen::RegionCodeGenTy::operator()", NM="_ZNK5clang7CodeGen15RegionCodeGenTyclERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15RegionCodeGenTyclERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public void $call(final CodeGenFunction /*&*/ CGF) /*const*/ {
    CodeGenFunction.RunCleanupsScope Scope = null;
    try {
      Scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      if ((PrePostAction != null)) {
        CGF.EHStack.pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CleanupTy(PrePostAction));
        Callback.$call(CodeGen, CGF, /*Deref*/PrePostAction);
      } else {
        PrePostActionTy Action = null;
        try {
          Action/*J*/= new PrePostActionTy();
          Callback.$call(CodeGen, CGF, Action);
        } finally {
          if (Action != null) { Action.$destroy(); }
        }
      }
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 64,
   FQN="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy", NM="_ZN5clang7CodeGen15RegionCodeGenTyC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15RegionCodeGenTyC1ERKS1_")
  //</editor-fold>
  public /*inline*/ RegionCodeGenTy(final /*const*/ RegionCodeGenTy /*&*/ $Prm0) {
    // : CodeGen(.CodeGen), Callback(.Callback), PrePostAction(.PrePostAction) 
    //START JInit
    this.CodeGen = $Prm0.CodeGen;
    this.Callback = $tryClone($Prm0.Callback);
    this.PrePostAction = $Prm0.PrePostAction;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  // typedef void (*CodeGenTy)(intptr_t, CodeGenFunction &, PrePostActionTy &);
  @FunctionalInterface public static interface CodeGenTy {
    void $call(Object/*intptr_t*/ p, CodeGenFunction /*&*/ f, PrePostActionTy /*&*/ a); 
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 79,
   FQN="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy", NM="Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE")
  //</editor-fold>
  public </*typename*/ Callable extends CodeGenTy> RegionCodeGenTy(final Callable /*&&*/CodeGenCallback) {
    this(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGenCallback);
  }
  
  public RegionCodeGenTy(JD$NotSameRegionCodeGenTy INSTANCE, CodeGenFunctionPrePostActionTy2Void CodeGen) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CodeGen=" + CodeGen // NOI18N
              + ", Callback=" + Callback // NOI18N
              + ", PrePostAction=" + PrePostAction; // NOI18N
  }
}
