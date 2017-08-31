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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
;


//<editor-fold defaultstate="collapsed" desc="static type ObjCUnusedIVarsCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL19checkObjCUnusedIvarPKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE;_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_11DeclContextENS1_6FileIDERNS1_13SourceManagerE;_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_17ObjCContainerDeclE;_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_20ObjCPropertyImplDeclE;_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_4StmtE; -static-type=ObjCUnusedIVarsCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class ObjCUnusedIVarsCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="Scan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 33,
 FQN="Scan", NM="_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_4StmtE")
//</editor-fold>
public static void Scan(final DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState>/*&*/ M, /*const*/ Stmt /*P*/ S) {
  if (!(S != null)) {
    return;
  }
  {
    
    /*const*/ ObjCIvarRefExpr /*P*/ Ex = dyn_cast_ObjCIvarRefExpr(S);
    if ((Ex != null)) {
      /*const*/ ObjCIvarDecl /*P*/ D = Ex.getDecl$Const();
      DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , IVarState> I = M.find(D);
      if (I.$noteq(/*NO_ITER_COPY*/M.end())) {
        I.$arrow().second = IVarState.Used;
      }
      return;
    }
  }
  {
    
    // Blocks can reference an instance variable of a class.
    /*const*/ BlockExpr /*P*/ BE = dyn_cast_BlockExpr(S);
    if ((BE != null)) {
      Scan(M, BE.getBody$Const());
      return;
    }
  }
  {
    
    /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(S);
    if ((POE != null)) {
      for (type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> i = $tryClone(POE.semantics_begin$Const()), /*P*/ /*const*/ /*P*/ e = $tryClone(POE.semantics_end$Const()); $noteq_ptr(i, e); i.$preInc()) {
        /*const*/ Expr /*P*/ sub = i.$star();
        {
          /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(sub);
          if ((OVE != null)) {
            sub = OVE.getSourceExpr();
          }
        }
        Scan(M, sub);
      }
    }
  }
  
  for (/*const*/ Stmt /*P*/ SubStmt : S.children$Const())  {
    Scan(M, SubStmt);
  }
}

//<editor-fold defaultstate="collapsed" desc="Scan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 64,
 FQN="Scan", NM="_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_20ObjCPropertyImplDeclE")
//</editor-fold>
public static void Scan(final DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState>/*&*/ M, /*const*/ ObjCPropertyImplDecl /*P*/ D) {
  if (!(D != null)) {
    return;
  }
  
  /*const*/ ObjCIvarDecl /*P*/ ID = D.getPropertyIvarDecl();
  if (!(ID != null)) {
    return;
  }
  
  DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , IVarState> I = M.find(ID);
  if (I.$noteq(/*NO_ITER_COPY*/M.end())) {
    I.$arrow().second = IVarState.Used;
  }
}

//<editor-fold defaultstate="collapsed" desc="Scan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 78,
 FQN="Scan", NM="_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_17ObjCContainerDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_17ObjCContainerDeclE")
//</editor-fold>
public static void Scan(final DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState>/*&*/ M, /*const*/ ObjCContainerDecl /*P*/ D) {
  // Scan the methods for accesses.
  for (/*const*/ ObjCMethodDecl /*P*/ I : D.instance_methods())  {
    Scan(M, I.getBody());
  }
  {
    
    /*const*/ ObjCImplementationDecl /*P*/ ID = dyn_cast_ObjCImplementationDecl(D);
    if ((ID != null)) {
      // Scan for @synthesized property methods that act as setters/getters
      // to an ivar.
      for (/*const*/ ObjCPropertyImplDecl /*P*/ I : ID.property_impls())  {
        Scan(M, I);
      }
      
      // Scan the associated categories as well.
      for (/*const*/ ObjCCategoryDecl /*P*/ Cat : ID.getClassInterface$Const().visible_categories()) {
        {
          /*const*/ ObjCCategoryImplDecl /*P*/ CID = Cat.getImplementation();
          if ((CID != null)) {
            Scan(M, CID);
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="Scan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 97,
 FQN="Scan", NM="_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_11DeclContextENS1_6FileIDERNS1_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL4ScanRN4llvm8DenseMapIPKN5clang12ObjCIvarDeclE9IVarStateNS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_S5_EEEEPKNS1_11DeclContextENS1_6FileIDERNS1_13SourceManagerE")
//</editor-fold>
public static void Scan(final DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState>/*&*/ M, /*const*/ DeclContext /*P*/ C, /*const*/ FileID FID, 
    final SourceManager /*&*/ SM) {
  for (/*const*/ Decl /*P*/ I : C.decls())  {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(I);
      if ((FD != null)) {
        SourceLocation L = FD.getLocStart();
        if (SM.getFileID(/*NO_COPY*/L).$eq(FID)) {
          Scan(M, FD.getBody());
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkObjCUnusedIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 107,
 FQN="checkObjCUnusedIvar", NM="_ZL19checkObjCUnusedIvarPKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZL19checkObjCUnusedIvarPKN5clang22ObjCImplementationDeclERNS_4ento11BugReporterEPKNS3_11CheckerBaseE")
//</editor-fold>
public static void checkObjCUnusedIvar(/*const*/ ObjCImplementationDecl /*P*/ D, 
                   final BugReporter /*&*/ BR, 
                   /*const*/ CheckerBase /*P*/ Checker) {
  
  /*const*/ ObjCInterfaceDecl /*P*/ ID = D.getClassInterface$Const();
  DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState> M/*J*/= new DenseMap</*const*/ ObjCIvarDecl /*P*/ , IVarState>(DenseMapInfo$LikePtr.$Info(), IVarState.Unused);
  
  // Iterate over the ivars.
  for (/*const*/ ObjCIvarDecl /*P*/ Ivar : ID.ivars()) {
    // Ignore ivars that...
    // (a) aren't private
    // (b) explicitly marked unused
    // (c) are iboutlets
    // (d) are unnamed bitfields
    if (Ivar.getAccessControl() != ObjCIvarDecl.AccessControl.Private
       || Ivar.hasAttr(UnusedAttr.class) || Ivar.hasAttr(IBOutletAttr.class)
       || Ivar.hasAttr(IBOutletCollectionAttr.class)
       || Ivar.isUnnamedBitfield()) {
      continue;
    }
    
    M.$set(Ivar, IVarState.Unused);
  }
  if (M.empty()) {
    return;
  }
  
  // Now scan the implementation declaration.
  Scan(M, D);
  
  // Any potentially unused ivars?
  boolean hasUnused = false;
  for (DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , IVarState> I = M.begin(), E = M.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
    if (I.$arrow().second == IVarState.Unused) {
      hasUnused = true;
      break;
    }
  }
  if (!hasUnused) {
    return;
  }
  
  // We found some potentially unused ivars.  Scan the entire translation unit
  // for functions inside the @implementation that reference these ivars.
  // FIXME: In the future hopefully we can just use the lexical DeclContext
  // to go from the ObjCImplementationDecl to the lexically "nested"
  // C functions.
  final SourceManager /*&*/ SM = BR.getSourceManager();
  Scan(M, D.getDeclContext$Const(), SM.getFileID(D.getLocation()), SM);
  
  // Find ivars that are unused.
  for (DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , IVarState> I = M.begin(), E = M.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
    if (I.$arrow().second == IVarState.Unused) {
      raw_string_ostream os = null;
      try {
        std.string sbuf/*J*/= new std.string();
        os/*J*/= new raw_string_ostream(sbuf);
        $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"Instance variable '"), $Deref(I.$arrow().first)).$out(/*KEEP_STR*/"' in class '"), $Deref(ID)).$out(
            /*KEEP_STR*/"' is never used by the methods in its @implementation (although it may be used by category methods)."
        );
        
        PathDiagnosticLocation L = PathDiagnosticLocation.create(I.$arrow().first, BR.getSourceManager());
        BR.EmitBasicReport(D, Checker, new StringRef(/*KEEP_STR*/"Unused instance variable"), new StringRef(/*KEEP_STR*/"Optimization"), 
            new StringRef(os.str()), new PathDiagnosticLocation(L));
      } finally {
        if (os != null) { os.$destroy(); }
      }
    }
  }
}

} // END OF class ObjCUnusedIVarsCheckerStatics
