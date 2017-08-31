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

package org.clang.staticanalyzer.core.bugreporter.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clank.support.aliases.type$ptr;
import org.llvm.adt.aliases.SmallVector;


//===----------------------------------------------------------------------===//
// BugTypes (collections of related reports).
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use SmallVector vs ilist*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 343,
 FQN="clang::ento::BugReportEquivClass", NM="_ZN5clang4ento19BugReportEquivClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClassE")
//</editor-fold>
public class BugReportEquivClass extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  /// List of *owned* BugReport objects.
//  private ilist<BugReport> Reports;
  private SmallVector<BugReport> Reports;
  
  /*friend  class BugReporter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::AddReport">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 348,
   FQN="clang::ento::BugReportEquivClass::AddReport", NM="_ZN5clang4ento19BugReportEquivClass9AddReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClass9AddReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE")
  //</editor-fold>
  /*package*//*friend*/ void AddReport(std.unique_ptr<BugReport> R) {
    Reports.push_back(R.release());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::BugReportEquivClass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 353,
   FQN="clang::ento::BugReportEquivClass::BugReportEquivClass", NM="_ZN5clang4ento19BugReportEquivClassC1ESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClassC1ESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE")
  //</editor-fold>
  public BugReportEquivClass(std.unique_ptr<BugReport> R) {
    // : FoldingSetNode(), Reports() 
    //START JInit
    $Node();
//    this.Reports = new ilist<BugReport>();
    this.Reports = new SmallVector<BugReport>(0);
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AddReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Methods for BugReporter and subclasses.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::~BugReportEquivClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2733,
   FQN="clang::ento::BugReportEquivClass::~BugReportEquivClass", NM="_ZN5clang4ento19BugReportEquivClassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClassD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Reports.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 356,
   FQN="clang::ento::BugReportEquivClass::Profile", NM="_ZNK5clang4ento19BugReportEquivClass7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento19BugReportEquivClass7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert (!Reports.empty());
    Reports.front$Const().Profile(ID);
  }

  
  /*typedef llvm::ilist<BugReport>::iterator iterator*/
//  public final class iterator extends ilist_iterator<BugReport>{ };
  /*typedef llvm::ilist<BugReport>::const_iterator const_iterator*/
//  public final class const_iterator extends ilist_iterator</*const*/ BugReport>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 364,
   FQN="clang::ento::BugReportEquivClass::begin", NM="_ZN5clang4ento19BugReportEquivClass5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClass5beginEv")
  //</editor-fold>
  public /*ilist_iterator*/type$ptr<BugReport> begin() {
    return Reports.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 365,
   FQN="clang::ento::BugReportEquivClass::end", NM="_ZN5clang4ento19BugReportEquivClass3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento19BugReportEquivClass3endEv")
  //</editor-fold>
  public /*ilist_iterator*/type$ptr<BugReport> end() {
    return Reports.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 367,
   FQN="clang::ento::BugReportEquivClass::begin", NM="_ZNK5clang4ento19BugReportEquivClass5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento19BugReportEquivClass5beginEv")
  //</editor-fold>
  public /*ilist_iterator*/type$ptr</*const*/ BugReport> begin$Const() /*const*/ {
    return Reports.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReportEquivClass::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 368,
   FQN="clang::ento::BugReportEquivClass::end", NM="_ZNK5clang4ento19BugReportEquivClass3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento19BugReportEquivClass3endEv")
  //</editor-fold>
  public /*ilist_iterator*/type$ptr</*const*/ BugReport> end$Const() /*const*/ {
    return Reports.end$Const();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final FoldingSetTrait<BugReportEquivClass> $Trait = new DefaultFoldingSetTrait<BugReportEquivClass>();  

  public static FoldingSetTrait<BugReportEquivClass> $Trait() { return $Trait;  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Reports=" + Reports // NOI18N
              + super.toString(); // NOI18N
  }
}
