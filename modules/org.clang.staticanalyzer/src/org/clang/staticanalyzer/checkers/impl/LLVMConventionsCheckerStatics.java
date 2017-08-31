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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.LLVMConventionsCheckerStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type LLVMConventionsCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11InNamespacePKN5clang4DeclEN4llvm9StringRefE;_ZL11IsClangAttrPKN5clang10RecordDeclE;_ZL11IsClangDeclPKN5clang10RecordDeclE;_ZL11IsClangStmtPKN5clang10RecordDeclE;_ZL11IsClangTypePKN5clang10RecordDeclE;_ZL11IsPartOfASTPKN5clang13CXXRecordDeclE;_ZL11IsStdStringN5clang8QualTypeE;_ZL11IsStdVectorN5clang8QualTypeE;_ZL13IsSmallVectorN5clang8QualTypeE;_ZL14CheckASTMemoryPKN5clang13CXXRecordDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE;_ZL15AllocatesMemoryN5clang8QualTypeE;_ZL15IsLLVMStringRefN5clang8QualTypeE;_ZL31CheckStringRefAssignedTemporaryPKN5clang4DeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE; -static-type=LLVMConventionsCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class LLVMConventionsCheckerStatics {


//===----------------------------------------------------------------------===//
// Generic type checking routines.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="IsLLVMStringRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 30,
 FQN="IsLLVMStringRef", NM="_ZL15IsLLVMStringRefN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL15IsLLVMStringRefN5clang8QualTypeE")
//</editor-fold>
public static boolean IsLLVMStringRef(QualType T) {
  /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  return $eq_StringRef(new StringRef(new QualType(RT, 0).getAsString()), 
      /*STRINGREF_STR*/"class StringRef");
}


/// Check whether the declaration is semantically inside the top-level
/// namespace named by ns.
//<editor-fold defaultstate="collapsed" desc="InNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 41,
 FQN="InNamespace", NM="_ZL11InNamespacePKN5clang4DeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11InNamespacePKN5clang4DeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean InNamespace(/*const*/ Decl /*P*/ D, StringRef NS) {
  /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(D.getDeclContext$Const());
  if (!(ND != null)) {
    return false;
  }
  /*const*/ IdentifierInfo /*P*/ II = ND.getIdentifier();
  if (!(II != null) || !II.getName().equals(/*NO_COPY*/NS)) {
    return false;
  }
  return isa_TranslationUnitDecl(ND.getDeclContext$Const());
}

//<editor-fold defaultstate="collapsed" desc="IsStdString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 51,
 FQN="IsStdString", NM="_ZL11IsStdStringN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsStdStringN5clang8QualTypeE")
//</editor-fold>
public static boolean IsStdString(QualType T) {
  {
    /*const*/ ElaboratedType /*P*/ QT = T.$arrow().getAs(ElaboratedType.class);
    if ((QT != null)) {
      T.$assignMove(QT.getNamedType());
    }
  }
  
  /*const*/ TypedefType /*P*/ TT = T.$arrow().getAs$TypedefType();
  if (!(TT != null)) {
    return false;
  }
  
  /*const*/ TypedefNameDecl /*P*/ TD = TT.getDecl();
  if (!TD.isInStdNamespace()) {
    return false;
  }
  
  return $eq_StringRef(TD.getName(), /*STRINGREF_STR*/"string");
}

//<editor-fold defaultstate="collapsed" desc="IsClangType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 67,
 FQN="IsClangType", NM="_ZL11IsClangTypePKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsClangTypePKN5clang10RecordDeclE")
//</editor-fold>
public static boolean IsClangType(/*const*/ RecordDecl /*P*/ RD) {
  return $eq_StringRef(RD.getName(), /*STRINGREF_STR*/"Type") && InNamespace(RD, new StringRef(/*KEEP_STR*/"clang"));
}

//<editor-fold defaultstate="collapsed" desc="IsClangDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 71,
 FQN="IsClangDecl", NM="_ZL11IsClangDeclPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsClangDeclPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean IsClangDecl(/*const*/ RecordDecl /*P*/ RD) {
  return $eq_StringRef(RD.getName(), /*STRINGREF_STR*/"Decl") && InNamespace(RD, new StringRef(/*KEEP_STR*/"clang"));
}

//<editor-fold defaultstate="collapsed" desc="IsClangStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 75,
 FQN="IsClangStmt", NM="_ZL11IsClangStmtPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsClangStmtPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean IsClangStmt(/*const*/ RecordDecl /*P*/ RD) {
  return $eq_StringRef(RD.getName(), /*STRINGREF_STR*/"Stmt") && InNamespace(RD, new StringRef(/*KEEP_STR*/"clang"));
}

//<editor-fold defaultstate="collapsed" desc="IsClangAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 79,
 FQN="IsClangAttr", NM="_ZL11IsClangAttrPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsClangAttrPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean IsClangAttr(/*const*/ RecordDecl /*P*/ RD) {
  return $eq_StringRef(RD.getName(), /*STRINGREF_STR*/"Attr") && InNamespace(RD, new StringRef(/*KEEP_STR*/"clang"));
}

//<editor-fold defaultstate="collapsed" desc="IsStdVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 83,
 FQN="IsStdVector", NM="_ZL11IsStdVectorN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsStdVectorN5clang8QualTypeE")
//</editor-fold>
public static boolean IsStdVector(QualType T) {
  /*const*/ TemplateSpecializationType /*P*/ TS = T.$arrow().getAs$TemplateSpecializationType();
  if (!(TS != null)) {
    return false;
  }
  
  TemplateName TM = TS.getTemplateName();
  TemplateDecl /*P*/ TD = TM.getAsTemplateDecl();
  if (!(TD != null) || !InNamespace(TD, new StringRef(/*KEEP_STR*/"std"))) {
    return false;
  }
  
  return $eq_StringRef(TD.getName(), /*STRINGREF_STR*/"vector");
}

//<editor-fold defaultstate="collapsed" desc="IsSmallVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 97,
 FQN="IsSmallVector", NM="_ZL13IsSmallVectorN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL13IsSmallVectorN5clang8QualTypeE")
//</editor-fold>
public static boolean IsSmallVector(QualType T) {
  /*const*/ TemplateSpecializationType /*P*/ TS = T.$arrow().getAs$TemplateSpecializationType();
  if (!(TS != null)) {
    return false;
  }
  
  TemplateName TM = TS.getTemplateName();
  TemplateDecl /*P*/ TD = TM.getAsTemplateDecl();
  if (!(TD != null) || !InNamespace(TD, new StringRef(/*KEEP_STR*/"llvm"))) {
    return false;
  }
  
  return $eq_StringRef(TD.getName(), /*STRINGREF_STR*/"SmallVector");
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="CheckStringRefAssignedTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 138,
 FQN="CheckStringRefAssignedTemporary", NM="_ZL31CheckStringRefAssignedTemporaryPKN5clang4DeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL31CheckStringRefAssignedTemporaryPKN5clang4DeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE")
//</editor-fold>
public static void CheckStringRefAssignedTemporary(/*const*/ Decl /*P*/ D, final BugReporter /*&*/ BR, 
                               /*const*/ CheckerBase /*P*/ Checker) {
  StringRefCheckerVisitor walker/*J*/= new StringRefCheckerVisitor(D, BR, Checker);
  walker.Visit(D.getBody());
}


//===----------------------------------------------------------------------===//
// CHECK: Clang AST nodes should not have fields that can allocate
//   memory.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="AllocatesMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 194,
 FQN="AllocatesMemory", NM="_ZL15AllocatesMemoryN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL15AllocatesMemoryN5clang8QualTypeE")
//</editor-fold>
public static boolean AllocatesMemory(QualType T) {
  return IsStdVector(new QualType(T)) || IsStdString(new QualType(T)) || IsSmallVector(new QualType(T));
}


// This type checking could be sped up via dynamic programming.
//<editor-fold defaultstate="collapsed" desc="IsPartOfAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 199,
 FQN="IsPartOfAST", NM="_ZL11IsPartOfASTPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL11IsPartOfASTPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static boolean IsPartOfAST(/*const*/ CXXRecordDecl /*P*/ R) {
  if (IsClangStmt(R) || IsClangType(R) || IsClangDecl(R) || IsClangAttr(R)) {
    return true;
  }
  
  for (final /*const*/ CXXBaseSpecifier /*&*/ BS : R.bases$Const()) {
    QualType T = BS.getType();
    {
      /*const*/ RecordType /*P*/ baseT = T.$arrow().getAs$RecordType();
      if ((baseT != null)) {
        CXXRecordDecl /*P*/ baseD = cast_CXXRecordDecl(baseT.getDecl());
        if (IsPartOfAST(baseD)) {
          return true;
        }
      }
    }
  }
  
  return false;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="CheckASTMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 232,
 FQN="CheckASTMemory", NM="_ZL14CheckASTMemoryPKN5clang13CXXRecordDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZL14CheckASTMemoryPKN5clang13CXXRecordDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE")
//</editor-fold>
public static void CheckASTMemory(/*const*/ CXXRecordDecl /*P*/ R, final BugReporter /*&*/ BR, 
              /*const*/ CheckerBase /*P*/ Checker) {
  if (!IsPartOfAST(R)) {
    return;
  }
  
  for (FieldDecl /*P*/ I : R.fields()) {
    ASTFieldVisitor walker = null;
    try {
      walker/*J*/= new ASTFieldVisitor(R, BR, Checker);
      walker.Visit(I);
    } finally {
      if (walker != null) { walker.$destroy(); }
    }
  }
}

} // END OF class LLVMConventionsCheckerStatics
