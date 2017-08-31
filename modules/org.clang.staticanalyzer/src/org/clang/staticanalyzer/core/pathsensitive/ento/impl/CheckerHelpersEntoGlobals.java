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
package org.clang.staticanalyzer.core.pathsensitive.ento.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CheckerHelpersEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE;_ZN5clang4ento12containsEnumEPKNS_4StmtE;_ZN5clang4ento13containsMacroEPKNS_4StmtE;_ZN5clang4ento15parseAssignmentEPKNS_4StmtE;_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE;_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE; -static-type=CheckerHelpersEntoGlobals -package=org.clang.staticanalyzer.core.pathsensitive.ento.impl")
//</editor-fold>
public final class CheckerHelpersEntoGlobals {


// Recursively find any substatements containing macros
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 19,
 FQN="clang::ento::containsMacro", NM="_ZN5clang4ento13containsMacroEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento13containsMacroEPKNS_4StmtE")
//</editor-fold>
public static boolean containsMacro(/*const*/ Stmt /*P*/ S) {
  if (S.getLocStart().isMacroID()) {
    return true;
  }
  if (S.getLocEnd().isMacroID()) {
    return true;
  }
  
  for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
    if ((Child != null) && containsMacro(Child)) {
      return true;
    }
  }
  
  return false;
}


// Recursively find any substatements containing enum constants
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 34,
 FQN="clang::ento::containsEnum", NM="_ZN5clang4ento12containsEnumEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento12containsEnumEPKNS_4StmtE")
//</editor-fold>
public static boolean containsEnum(/*const*/ Stmt /*P*/ S) {
  /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(S);
  if ((DR != null) && isa_EnumConstantDecl(DR.getDecl$Const())) {
    return true;
  }
  
  for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
    if ((Child != null) && containsEnum(Child)) {
      return true;
    }
  }
  
  return false;
}


// Recursively find any substatements containing static vars
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsStaticLocal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 48,
 FQN="clang::ento::containsStaticLocal", NM="_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE")
//</editor-fold>
public static boolean containsStaticLocal(/*const*/ Stmt /*P*/ S) {
  /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(S);
  if ((DR != null)) {
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
      if ((VD != null)) {
        if (VD.isStaticLocal()) {
          return true;
        }
      }
    }
  }
  
  for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
    if ((Child != null) && containsStaticLocal(Child)) {
      return true;
    }
  }
  
  return false;
}


// Recursively find any substatements containing __builtin_offsetof
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsBuiltinOffsetOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 64,
 FQN="clang::ento::containsBuiltinOffsetOf", NM="_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE")
//</editor-fold>
public static boolean containsBuiltinOffsetOf(/*const*/ Stmt /*P*/ S) {
  if (isa_OffsetOfExpr(S)) {
    return true;
  }
  
  for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
    if ((Child != null) && containsBuiltinOffsetOf(Child)) {
      return true;
    }
  }
  
  return false;
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerHelpers.h", line = 31,
 FQN="clang::ento::containsStmt", NM="Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE")
//</editor-fold>
public static </*class*/ T extends Stmt> boolean containsStmt(Class<T> clazz, /*const*/ Stmt /*P*/ S) {
  if (isa/*<T>*/(clazz, S)) {
    return true;
  }
  
  for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
    if (Native.$bool(Child) && Native.$bool(CheckerHelpersEntoGlobals.<T>containsStmt(clazz, Child))) {
      return true;
    }
  }
  
  return false;
}


// Extract lhs and rhs from assignment statement
//<editor-fold defaultstate="collapsed" desc="clang::ento::parseAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 76,
 FQN="clang::ento::parseAssignment", NM="_ZN5clang4ento15parseAssignmentEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento15parseAssignmentEPKNS_4StmtE")
//</editor-fold>
public static std.pairPtrPtr</*const*/ VarDecl /*P*/ , /*const*/ Expr /*P*/ > parseAssignment(/*const*/ Stmt /*P*/ S) {
  /*const*/ VarDecl /*P*/ VD = null;
  /*const*/ Expr /*P*/ RHS = null;
  {
    
    /*const*/ BinaryOperator /*P*/ Assign = dyn_cast_or_null_BinaryOperator(S);
    if ((Assign != null)) {
      if (Assign.isAssignmentOp()) {
        // Ordinary assignment
        RHS = Assign.getRHS();
        {
          DeclRefExpr /*P*/ DE = dyn_cast_or_null_DeclRefExpr(Assign.getLHS());
          if ((DE != null)) {
            VD = dyn_cast_or_null_VarDecl(DE.getDecl());
          }
        }
      }
    } else {
      /*const*/ DeclStmt /*P*/ PD = dyn_cast_or_null_DeclStmt(S);
      if ((PD != null)) {
        // Initialization
        assert (PD.isSingleDecl()) : "We process decls one by one";
        VD = dyn_cast_or_null_VarDecl(PD.getSingleDecl$Const());
        RHS = VD.getAnyInitializer();
      }
    }
  }
  
  return std.make_pair_Ptr_Ptr(VD, RHS);
}

} // END OF class CheckerHelpersEntoGlobals
