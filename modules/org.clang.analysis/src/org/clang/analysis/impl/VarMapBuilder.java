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

package org.clang.analysis.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// Visitor which builds a LocalVariableMap
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VarMapBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 550,
 FQN="(anonymous namespace)::VarMapBuilder", NM="_ZN12_GLOBAL__N_113VarMapBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_113VarMapBuilderE")
//</editor-fold>
public class VarMapBuilder implements /*public*/ StmtVisitorVoid<VarMapBuilder>, Destructors.ClassWithDestructor {
/*public:*/
  public LocalVariableMap /*P*/ VMap;
  public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VarMapBuilder::VarMapBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 555,
   FQN="(anonymous namespace)::VarMapBuilder::VarMapBuilder", NM="_ZN12_GLOBAL__N_113VarMapBuilderC1EPNS_16LocalVariableMapEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS3_16ImutKeyValueInfoIS8_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_113VarMapBuilderC1EPNS_16LocalVariableMapEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS3_16ImutKeyValueInfoIS8_jEEEE")
  //</editor-fold>
  public VarMapBuilder(LocalVariableMap /*P*/ VM, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
    // : StmtVisitor<VarMapBuilder>(), VMap(VM), Ctx(C) 
    //START JInit
    $StmtVisitor();
    this.VMap = VM;
    this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C);
    //END JInit
  }

  
  
  // Add new local variables to the variable map
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VarMapBuilder::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 564,
   FQN="(anonymous namespace)::VarMapBuilder::VisitDeclStmt", NM="_ZN12_GLOBAL__N_113VarMapBuilder13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_113VarMapBuilder13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ S) {
    boolean modifiedCtx = false;
    DeclGroupRef DGrp = S.getDeclGroup();
    for (/*const*/ Decl /*P*/ D : DGrp) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(D);
        if ((VD != null)) {
          /*const*/ Expr /*P*/ E = VD.getInit$Const();
          
          // Add local variables with trivial type to the variable map
          QualType T = VD.getType();
          if (T.isTrivialType(VD.getASTContext())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Ctx.$assign($c$.track(VMap.addDefinition(VD, E, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))));
              modifiedCtx = true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    if (modifiedCtx) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        VMap.saveContext(S, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  // Update local variable definitions in variable map
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VarMapBuilder::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 584,
   FQN="(anonymous namespace)::VarMapBuilder::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_113VarMapBuilder19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_113VarMapBuilder19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ BO) {
    if (!BO.isAssignmentOp()) {
      return;
    }
    
    Expr /*P*/ LHSExp = BO.getLHS().IgnoreParenCasts();
    {
      
      // Update the variable map and current context.
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(LHSExp);
      if ((DRE != null)) {
        ValueDecl /*P*/ VDec = DRE.getDecl();
        if (Native.$bool(Ctx.lookup(VDec))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
              $c$.clean(Ctx.$assign($c$.track(VMap.updateDefinition(VDec, BO.getRHS(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))));
            } else {
              // FIXME -- handle compound assignment operators
              $c$.clean(Ctx.$assign($c$.track(VMap.clearDefinition(VDec, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))));
            }
            VMap.saveContext(BO, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VarMapBuilder::~VarMapBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 550,
   FQN="(anonymous namespace)::VarMapBuilder::~VarMapBuilder", NM="_ZN12_GLOBAL__N_113VarMapBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_113VarMapBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Ctx.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VMap=" + VMap // NOI18N
              + ", Ctx=" + Ctx // NOI18N
              + super.toString(); // NOI18N
  }
}
