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
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;
import static org.clank.support.Native.$AddrOf;

/// \brief API for generation of expressions captured in a innermost OpenMP
/// region.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 325,
 FQN="(anonymous namespace)::CGOpenMPInnerExprInfo", NM="_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoE")
//</editor-fold>
public final class CGOpenMPInnerExprInfo extends /*public*/ CGOpenMPInlinedRegionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::CGOpenMPInnerExprInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 327,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::CGOpenMPInnerExprInfo", NM="_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoC1ERN5clang7CodeGen15CodeGenFunctionERKNS1_12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoC1ERN5clang7CodeGen15CodeGenFunctionERKNS1_12CapturedStmtE")
  //</editor-fold>
  public CGOpenMPInnerExprInfo(final CodeGenFunction /*&*/ CGF, final /*const*/ CapturedStmt /*&*/ CS) {
    // : CGOpenMPInlinedRegionInfo(CGF.CapturedStmtInfo, EmptyCodeGen, OMPD_unknown, /*HasCancel=*/ false), PrivScope(CGF) 
    //START JInit
    /*ExprWithCleanups*/super(CGF.CapturedStmtInfo, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CGOpenMPRuntimeStatics::EmptyCodeGen), 
        OpenMPDirectiveKind.OMPD_unknown, 
        false);
    this.PrivScope = new CodeGenFunction.OMPPrivateScope(CGF);
    //END JInit
    // Make sure the globals captured in the provided statement are local by
    // using the privatization logic. We assume the same variable is not
    // captured more than once.
    for (final CapturedStmt./*const*/ Capture /*&*/ C : CS.captures$Const()) {
      if (!C.capturesVariable() && !C.capturesVariableByCopy()) {
        continue;
      }
      
      /*const*/ VarDecl /*P*/ VD = C.getCapturedVar();
      if (VD.isLocalVarDeclOrParm()) {
        continue;
      }
      
      DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(VD)), 
          /*RefersToEnclosingVariableOrCapture=*/ false, 
          VD.getType().getNonReferenceType(), ExprValueKind.VK_LValue, 
          new SourceLocation());
      PrivScope.addPrivate(VD, /*FuncArg*//*[&CGF, &DRE]*/ () -> {
                return CGF.EmitLValue($AddrOf(DRE)).getAddress();
              });
    }
    /*J:(void)*/PrivScope.Privatize();
  }

  
  /// \brief Lookup the captured field decl for a variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 355,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::lookup", NM="_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo6lookupEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo6lookupEPKN5clang7VarDeclE")
  //</editor-fold>
  @Override public /*const*/ FieldDecl /*P*/ lookup(/*const*/ VarDecl /*P*/ VD) /*const*//* override*/ {
    {
      /*const*/ FieldDecl /*P*/ FD = super.lookup(VD);
      if ((FD != null)) {
        return FD;
      }
    }
    return null;
  }

  
  /// \brief Emit the captured statement body.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::EmitBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 362,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::EmitBody", NM="_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfo8EmitBodyERN5clang7CodeGen15CodeGenFunctionEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfo8EmitBodyERN5clang7CodeGen15CodeGenFunctionEPKNS1_4StmtE")
  //</editor-fold>
  @Override public void EmitBody(final CodeGenFunction /*&*/ CGF, /*const*/ Stmt /*P*/ S)/* override*/ {
    throw new llvm_unreachable("No body for expressions");
  }

  
  /// \brief Get a variable or parameter for storing global thread id
  /// inside OpenMP construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::getThreadIDVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 368,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::getThreadIDVariable", NM="_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo19getThreadIDVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo19getThreadIDVariableEv")
  //</editor-fold>
  @Override public /*const*/ VarDecl /*P*/ getThreadIDVariable() /*const*//* override*/ {
    throw new llvm_unreachable("No thread id for expressions");
  }

  
  /// \brief Get the name of the capture helper.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::getHelperName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 373,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::getHelperName", NM="_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo13getHelperNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_121CGOpenMPInnerExprInfo13getHelperNameEv")
  //</editor-fold>
  @Override public StringRef getHelperName() /*const*//* override*/ {
    throw new llvm_unreachable("No helper name for expressions");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 377,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::classof", NM="_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfo7classofEPKN5clang7CodeGen15CodeGenFunction18CGCapturedStmtInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ CodeGenFunction.CGCapturedStmtInfo /*P*/ Info) {
    return false;
  }

/*private:*/
  /// Private scope to capture global variables.
  private CodeGenFunction.OMPPrivateScope PrivScope;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGOpenMPInnerExprInfo::~CGOpenMPInnerExprInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 325,
   FQN="(anonymous namespace)::CGOpenMPInnerExprInfo::~CGOpenMPInnerExprInfo", NM="_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_121CGOpenMPInnerExprInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    PrivScope.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PrivScope=" + PrivScope // NOI18N
              + super.toString(); // NOI18N
  }
}
