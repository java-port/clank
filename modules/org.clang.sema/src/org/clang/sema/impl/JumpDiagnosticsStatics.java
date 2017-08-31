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
package org.clang.sema.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type JumpDiagnosticsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZL20IsCXX98CompatWarningRN5clang4SemaEj;_ZL22IsMicrosoftJumpWarningjj;_ZL23GetDiagForGotoScopeDeclRN5clang4SemaEPKNS_4DeclE;_ZL24DiagnoseIndirectJumpStmtRN5clang4SemaEPNS_16IndirectGotoStmtEPNS_9LabelDeclERb; -static-type=JumpDiagnosticsStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class JumpDiagnosticsStatics {


/// GetDiagForGotoScopeDecl - If this decl induces a new goto scope, return a
/// diagnostic that should be emitted if control goes over it. If not, return 0.
//<editor-fold defaultstate="collapsed" desc="GetDiagForGotoScopeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 131,
 FQN="GetDiagForGotoScopeDecl", NM="_ZL23GetDiagForGotoScopeDeclRN5clang4SemaEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZL23GetDiagForGotoScopeDeclRN5clang4SemaEPKNS_4DeclE")
//</editor-fold>
public static std.pairUIntUInt GetDiagForGotoScopeDecl(final Sema /*&*/ S, /*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      /*uint*/int InDiag = 0;
      /*uint*/int OutDiag = 0;
      if (VD.getType().$arrow().isVariablyModifiedType()) {
        InDiag = diag.note_protected_by_vla;
      }
      if (VD.hasAttr(BlocksAttr.class)) {
        return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_protected_by___block, 
            diag.note_exits___block);
      }
      if (VD.hasAttr(CleanupAttr.class)) {
        return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_protected_by_cleanup, 
            diag.note_exits_cleanup);
      }
      if (VD.hasLocalStorage()) {
        switch (VD.getType().isDestructedType()) {
         case DK_objc_strong_lifetime:
          return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_protected_by_objc_strong_init, 
              diag.note_exits_objc_strong);
         case DK_objc_weak_lifetime:
          return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_protected_by_objc_weak_init, 
              diag.note_exits_objc_weak);
         case DK_cxx_destructor:
          OutDiag = diag.note_exits_dtor;
          break;
         case DK_none:
          break;
        }
      }
      
      /*const*/ Expr /*P*/ Init = VD.getInit$Const();
      if (S.Context.getLangOpts().CPlusPlus && VD.hasLocalStorage() && (Init != null)) {
        // C++11 [stmt.dcl]p3:
        //   A program that jumps from a point where a variable with automatic
        //   storage duration is not in scope to a point where it is in scope
        //   is ill-formed unless the variable has scalar type, class type with
        //   a trivial default constructor and a trivial destructor, a
        //   cv-qualified version of one of these types, or an array of one of
        //   the preceding types and is declared without an initializer.
        
        // C++03 [stmt.dcl.p3:
        //   A program that jumps from a point where a local variable
        //   with automatic storage duration is not in scope to a point
        //   where it is in scope is ill-formed unless the variable has
        //   POD type and is declared without an initializer.
        InDiag = diag.note_protected_by_variable_init;
        {
          
          // For a variable of (array of) class type declared without an
          // initializer, we will have call-style initialization and the initializer
          // will be the CXXConstructExpr with no intervening nodes.
          /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(Init);
          if ((CCE != null)) {
            /*const*/ CXXConstructorDecl /*P*/ Ctor = CCE.getConstructor();
            if (Ctor.isTrivial() && Ctor.isDefaultConstructor()
               && VD.getInitStyle() == VarDecl.InitializationStyle.CallInit) {
              if ((OutDiag != 0)) {
                InDiag = diag.note_protected_by_variable_nontriv_destructor;
              } else if (!Ctor.getParent$Const().isPOD()) {
                InDiag = diag.note_protected_by_variable_non_pod;
              } else {
                InDiag = 0;
              }
            }
          }
        }
      }
      
      return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, InDiag, OutDiag);
    }
  }
  {
    
    /*const*/ TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      if (TD.getUnderlyingType().$arrow().isVariablyModifiedType()) {
        return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, isa_TypedefDecl(TD) ? diag.note_protected_by_vla_typedef : diag.note_protected_by_vla_type_alias, 
            0);
      }
    }
  }
  
  return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, 0/*U*/, 0/*U*/);
}


/// Return true if a particular error+note combination must be downgraded to a
/// warning in Microsoft mode.
//<editor-fold defaultstate="collapsed" desc="IsMicrosoftJumpWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 762,
 FQN="IsMicrosoftJumpWarning", NM="_ZL22IsMicrosoftJumpWarningjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZL22IsMicrosoftJumpWarningjj")
//</editor-fold>
public static boolean IsMicrosoftJumpWarning(/*uint*/int JumpDiag, /*uint*/int InDiagNote) {
  return (JumpDiag == diag.err_goto_into_protected_scope
     && (InDiagNote == diag.note_protected_by_variable_init
     || InDiagNote == diag.note_protected_by_variable_nontriv_destructor));
}


/// Return true if a particular note should be downgraded to a compatibility
/// warning in C++11 mode.
//<editor-fold defaultstate="collapsed" desc="IsCXX98CompatWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 770,
 FQN="IsCXX98CompatWarning", NM="_ZL20IsCXX98CompatWarningRN5clang4SemaEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZL20IsCXX98CompatWarningRN5clang4SemaEj")
//</editor-fold>
public static boolean IsCXX98CompatWarning(final Sema /*&*/ S, /*uint*/int InDiagNote) {
  return S.getLangOpts().CPlusPlus11
     && InDiagNote == diag.note_protected_by_variable_non_pod;
}


/// Produce primary diagnostic for an indirect jump statement.
//<editor-fold defaultstate="collapsed" desc="DiagnoseIndirectJumpStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 776,
 FQN="DiagnoseIndirectJumpStmt", NM="_ZL24DiagnoseIndirectJumpStmtRN5clang4SemaEPNS_16IndirectGotoStmtEPNS_9LabelDeclERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZL24DiagnoseIndirectJumpStmtRN5clang4SemaEPNS_16IndirectGotoStmtEPNS_9LabelDeclERb")
//</editor-fold>
public static void DiagnoseIndirectJumpStmt(final Sema /*&*/ S, IndirectGotoStmt /*P*/ Jump, 
                        LabelDecl /*P*/ Target, final bool$ref/*bool &*/ Diagnosed) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Diagnosed.$deref()) {
      return;
    }
    $c$.clean($c$.track(S.Diag(Jump.getGotoLoc(), diag.err_indirect_goto_in_protected_scope)));
    $c$.clean($c$.track(S.Diag(Target.getStmt().getIdentLoc(), diag.note_indirect_goto_target)));
    Diagnosed.$set(true);
  } finally {
    $c$.$destroy();
  }
}

} // END OF class JumpDiagnosticsStatics
