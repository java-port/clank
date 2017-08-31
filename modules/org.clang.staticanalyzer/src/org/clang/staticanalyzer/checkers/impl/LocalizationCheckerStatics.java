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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type LocalizationCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE;_ZL15isDebuggingNameNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZL15isDebuggingNameSs;_ZL18isDebuggingContextRN5clang4ento14CheckerContextE; -static-type=LocalizationCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class LocalizationCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="isDebuggingName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 647,
 FQN="isDebuggingName", NM="_ZL15isDebuggingNameSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZL15isDebuggingNameSs")
//</editor-fold>
public static boolean isDebuggingName(std.string name) {
  return new StringRef(name).lower().find_T$C$P_size_type$_CharT(/*KEEP_STR*/"debug") != StringRef.npos;
}


/// Returns true when, heuristically, the analyzer may be analyzing debugging
/// code. We use this to suppress localization diagnostics in un-localized user
/// interfaces that are only used for debugging and are therefore not user
/// facing.
//<editor-fold defaultstate="collapsed" desc="isDebuggingContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 655,
 FQN="isDebuggingContext", NM="_ZL18isDebuggingContextRN5clang4ento14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZL18isDebuggingContextRN5clang4ento14CheckerContextE")
//</editor-fold>
public static boolean isDebuggingContext(final CheckerContext /*&*/ C) {
  /*const*/ Decl /*P*/ D = C.getCurrentAnalysisDeclContext().getDecl();
  if (!(D != null)) {
    return false;
  }
  {
    
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
    if ((ND != null)) {
      if (isDebuggingName(ND.getNameAsString())) {
        return true;
      }
    }
  }
  
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  {
    
    /*const*/ ObjCContainerDecl /*P*/ CD = dyn_cast_ObjCContainerDecl(DC);
    if ((CD != null)) {
      if (isDebuggingName(CD.getNameAsString())) {
        return true;
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isNSStringType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 800,
 FQN="isNSStringType", NM="_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean isNSStringType(QualType T, final ASTContext /*&*/ Ctx) {
  
  /*const*/ ObjCObjectPointerType /*P*/ PT = T.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(PT != null)) {
    return false;
  }
  
  ObjCInterfaceDecl /*P*/ Cls = PT.getObjectType().getInterface();
  if (!(Cls != null)) {
    return false;
  }
  
  IdentifierInfo /*P*/ ClsName = Cls.getIdentifier();
  
  // FIXME: Should we walk the chain of classes?
  return ClsName == $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSString")))
     || ClsName == $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSMutableString")));
}

} // END OF class LocalizationCheckerStatics
