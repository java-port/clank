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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.staticanalyzer.checkers.impl.LLVMConventionsCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTFieldVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 216,
 FQN="(anonymous namespace)::ASTFieldVisitor", NM="_ZN12_GLOBAL__N_115ASTFieldVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_115ASTFieldVisitorE")
//</editor-fold>
public class ASTFieldVisitor implements Destructors.ClassWithDestructor {
  private SmallVector<FieldDecl /*P*/ > FieldChain;
  private /*const*/ CXXRecordDecl /*P*/ Root;
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTFieldVisitor::ASTFieldVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 223,
   FQN="(anonymous namespace)::ASTFieldVisitor::ASTFieldVisitor", NM="_ZN12_GLOBAL__N_115ASTFieldVisitorC1EPKN5clang13CXXRecordDeclERNS1_4ento11BugReporterEPKNS5_11CheckerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_115ASTFieldVisitorC1EPKN5clang13CXXRecordDeclERNS1_4ento11BugReporterEPKNS5_11CheckerBaseE")
  //</editor-fold>
  public ASTFieldVisitor(/*const*/ CXXRecordDecl /*P*/ root, final BugReporter /*&*/ br, 
      /*const*/ CheckerBase /*P*/ checker) {
    // : FieldChain(), Root(root), BR(br), Checker(checker) 
    //START JInit
    this.FieldChain = new SmallVector<FieldDecl /*P*/ >(10, (FieldDecl /*P*/ )null);
    this.Root = root;
    this./*&*/BR=/*&*/br;
    this.Checker = checker;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTFieldVisitor::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 243,
   FQN="(anonymous namespace)::ASTFieldVisitor::Visit", NM="_ZN12_GLOBAL__N_115ASTFieldVisitor5VisitEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_115ASTFieldVisitor5VisitEPN5clang9FieldDeclE")
  //</editor-fold>
  public void Visit(FieldDecl /*P*/ D) {
    FieldChain.push_back(D);
    
    QualType T = D.getType();
    if (AllocatesMemory(new QualType(T))) {
      ReportError(new QualType(T));
    }
    {
      
      /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
      if ((RT != null)) {
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl().getDefinition();
        for (FieldDecl /*P*/ I : RD.fields())  {
          Visit(I);
        }
      }
    }
    
    FieldChain.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTFieldVisitor::ReportError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 260,
   FQN="(anonymous namespace)::ASTFieldVisitor::ReportError", NM="_ZN12_GLOBAL__N_115ASTFieldVisitor11ReportErrorEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_115ASTFieldVisitor11ReportErrorEN5clang8QualTypeE")
  //</editor-fold>
  public void ReportError(QualType T) {
    raw_svector_ostream os = null;
    try {
      SmallString/*1024*/ buf/*J*/= new SmallString/*1024*/(1024);
      os/*J*/= new raw_svector_ostream(buf);
      
      os.$out(/*KEEP_STR*/"AST class '").$out(Root.getName()).$out(/*KEEP_STR*/"' has a field '").$out(
          FieldChain.front().getName()
      ).$out(/*KEEP_STR*/"' that allocates heap memory");
      if ($greater_uint(FieldChain.size(), 1)) {
        os.$out(/*KEEP_STR*/" via the following chain: ");
        boolean isFirst = true;
        for (type$ptr<FieldDecl /*P*/ /*P*/> I = $tryClone(FieldChain.begin()), 
            /*P*/ E = $tryClone(FieldChain.end()); $noteq_ptr(I, E); I.$preInc()) {
          if (!isFirst) {
            os.$out_char($$DOT);
          } else {
            isFirst = false;
          }
          os.$out((I.$star()).getName());
        }
      }
      os.$out(/*KEEP_STR*/" (type ").$out(FieldChain.back().getType().getAsString()).$out(/*KEEP_STR*/$RPAREN);
      
      // Note that this will fire for every translation unit that uses this
      // class.  This is suboptimal, but at least scan-build will merge
      // duplicate HTML reports.  In the future we need a unified way of merging
      // duplicate reports across translation units.  For C++ classes we cannot
      // just report warnings when we see an out-of-line method definition for a
      // class, as that heuristic doesn't always work (the complete definition of
      // the class may be in the header file, for example).
      PathDiagnosticLocation L = PathDiagnosticLocation.createBegin(FieldChain.front(), BR.getSourceManager());
      BR.EmitBasicReport(Root, Checker, new StringRef(/*KEEP_STR*/"AST node allocates heap memory"), 
          new StringRef(/*KEEP_STR*/"LLVM Conventions"), os.str(), new PathDiagnosticLocation(L));
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTFieldVisitor::~ASTFieldVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 216,
   FQN="(anonymous namespace)::ASTFieldVisitor::~ASTFieldVisitor", NM="_ZN12_GLOBAL__N_115ASTFieldVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_115ASTFieldVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FieldChain.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "FieldChain=" + FieldChain // NOI18N
              + ", Root=" + Root // NOI18N
              + ", BR=" + BR // NOI18N
              + ", Checker=" + Checker; // NOI18N
  }
}
