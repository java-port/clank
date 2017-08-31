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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.staticanalyzer.checkers.impl.CheckObjCInstMethSignatureStatics.*;
import org.clang.basic.llvm.DenseMapInfoSelector;


//<editor-fold defaultstate="collapsed" desc="static type CheckObjCInstMethSignatureStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=_ZL18AreTypesCompatibleN5clang8QualTypeES0_RNS_10ASTContextE;_ZL18CompareReturnTypesPKN5clang14ObjCMethodDeclES2_RNS_4ento11BugReporterERNS_10ASTContextEPKNS_22ObjCImplementationDeclEPKNS3_11CheckerBaseE;_ZL26CheckObjCInstMethSignaturePKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE; -static-type=CheckObjCInstMethSignatureStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class CheckObjCInstMethSignatureStatics {

//<editor-fold defaultstate="collapsed" desc="AreTypesCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp", line = 29,
 FQN="AreTypesCompatible", NM="_ZL18AreTypesCompatibleN5clang8QualTypeES0_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=_ZL18AreTypesCompatibleN5clang8QualTypeES0_RNS_10ASTContextE")
//</editor-fold>
public static boolean AreTypesCompatible(QualType Derived, QualType Ancestor, 
                  final ASTContext /*&*/ C) {
  
  // Right now don't compare the compatibility of pointers.  That involves
  // looking at subtyping relationships.  FIXME: Future patch.
  if (Derived.$arrow().isAnyPointerType() && Ancestor.$arrow().isAnyPointerType()) {
    return true;
  }
  
  return C.typesAreCompatible(new QualType(Derived), new QualType(Ancestor));
}

//<editor-fold defaultstate="collapsed" desc="CompareReturnTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp", line = 40,
 FQN="CompareReturnTypes", NM="_ZL18CompareReturnTypesPKN5clang14ObjCMethodDeclES2_RNS_4ento11BugReporterERNS_10ASTContextEPKNS_22ObjCImplementationDeclEPKNS3_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=_ZL18CompareReturnTypesPKN5clang14ObjCMethodDeclES2_RNS_4ento11BugReporterERNS_10ASTContextEPKNS_22ObjCImplementationDeclEPKNS3_11CheckerBaseE")
//</editor-fold>
public static void CompareReturnTypes(/*const*/ ObjCMethodDecl /*P*/ MethDerived, 
                  /*const*/ ObjCMethodDecl /*P*/ MethAncestor, 
                  final BugReporter /*&*/ BR, final ASTContext /*&*/ Ctx, 
                  /*const*/ ObjCImplementationDecl /*P*/ ID, 
                  /*const*/ CheckerBase /*P*/ Checker) {
  
  QualType ResDerived = MethDerived.getReturnType();
  QualType ResAncestor = MethAncestor.getReturnType();
  if (!AreTypesCompatible(new QualType(ResDerived), new QualType(ResAncestor), Ctx)) {
    raw_string_ostream os = null;
    try {
      std.string sbuf/*J*/= new std.string();
      os/*J*/= new raw_string_ostream(sbuf);
      
      $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"The Objective-C class '"), 
              $Deref(MethDerived.getClassInterface$Const())).$out(
              /*KEEP_STR*/"', which is derived from class '"
          ), 
          $Deref(MethAncestor.getClassInterface$Const())).$out(
          /*KEEP_STR*/"', defines the instance method '"
      );
      MethDerived.getSelector().print(os);
      $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"' whose return type is '").$out(
              ResDerived.getAsString()
          ).$out(
              /*KEEP_STR*/"'.  A method with the same name (same selector) is also defined in class '"
          ), 
          $Deref(MethAncestor.getClassInterface$Const())).$out(
          /*KEEP_STR*/"' and has a return type of '"
      ).$out(
          ResAncestor.getAsString()
      ).$out(
          /*KEEP_STR*/"'.  These two types are incompatible, and may result in undefined behavior for clients of these classes."
      );
      
      PathDiagnosticLocation MethDLoc = PathDiagnosticLocation.createBegin(MethDerived, 
          BR.getSourceManager());
      
      BR.EmitBasicReport(MethDerived, Checker, new StringRef(/*KEEP_STR*/"Incompatible instance method return type"), 
          new StringRef(categories.CoreFoundationObjectiveC), new StringRef(os.str()), new PathDiagnosticLocation(MethDLoc));
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckObjCInstMethSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp", line = 79,
 FQN="CheckObjCInstMethSignature", NM="_ZL26CheckObjCInstMethSignaturePKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=_ZL26CheckObjCInstMethSignaturePKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE")
//</editor-fold>
public static void CheckObjCInstMethSignature(/*const*/ ObjCImplementationDecl /*P*/ ID, 
                          final BugReporter /*&*/ BR, 
                          /*const*/ CheckerBase /*P*/ Checker) {
  
  /*const*/ ObjCInterfaceDecl /*P*/ D = ID.getClassInterface$Const();
  /*const*/ ObjCInterfaceDecl /*P*/ C = D.getSuperClass();
  if (!(C != null)) {
    return;
  }
  
  final ASTContext /*&*/ Ctx = BR.getContext();
  
  // Build a DenseMap of the methods for quick querying.
  /*typedef llvm::DenseMap<Selector, ObjCMethodDecl *> MapTy*/
//  final class MapTy extends DenseMap<Selector, ObjCMethodDecl /*P*/ >{ };
  DenseMap<Selector, ObjCMethodDecl /*P*/ > IMeths/*J*/= new DenseMap<Selector, ObjCMethodDecl /*P*/ >(DenseMapInfoSelector.$Info(), (ObjCMethodDecl /*P*/ )null);
  /*uint*/int NumMethods = 0;
  
  for (ObjCMethodDecl /*P*/ M : ID.instance_methods()) {
    IMeths.$set(M.getSelector(), M);
    ++NumMethods;
  }
  
  // Now recurse the class hierarchy chain looking for methods with the
  // same signatures.
  while ((C != null) && (NumMethods != 0)) {
    for (/*const*/ ObjCMethodDecl /*P*/ M : C.instance_methods()) {
      Selector S = M.getSelector();
      
      DenseMapIterator<Selector, ObjCMethodDecl /*P*/ > MI = IMeths.find(S);
      if (MI.$eq(/*NO_ITER_COPY*/IMeths.end()) || MI.$arrow().second == null) {
        continue;
      }
      
      --NumMethods;
      ObjCMethodDecl /*P*/ MethDerived = MI.$arrow().second;
      MI.$arrow().second = null;
      
      CompareReturnTypes(MethDerived, M, BR, Ctx, ID, Checker);
    }
    
    C = C.getSuperClass();
  }
}

} // END OF class CheckObjCInstMethSignatureStatics
