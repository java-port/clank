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
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::BugType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 31,
 FQN="clang::ento::BugType", NM="_ZN5clang4ento7BugTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugTypeE")
//</editor-fold>
public class BugType implements Destructors.ClassWithDestructor {
/*private:*/
  private /*const*/ CheckName Check;
  private /*const*/std.string Name;
  private /*const*/std.string Category;
  private boolean SuppressonSink;
  
  
  //===----------------------------------------------------------------------===//
  // Methods for BugType and subclasses.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2523,
   FQN="clang::ento::BugType::anchor", NM="_ZN5clang4ento7BugType6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugType6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::BugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 40,
   FQN="clang::ento::BugType::BugType", NM="_ZN5clang4ento7BugTypeC1ENS0_9CheckNameEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugTypeC1ENS0_9CheckNameEN4llvm9StringRefES4_")
  //</editor-fold>
  public BugType( CheckName check, StringRef name, StringRef cat) {
    // : Check(check), Name(name.operator basic_string()), Category(cat.operator basic_string()), SuppressonSink(false) 
    //START JInit
    this.Check = new CheckName(check);
    this.Name = name.$string();
    this.Category = cat.$string();
    this.SuppressonSink = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::BugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 42,
   FQN="clang::ento::BugType::BugType", NM="_ZN5clang4ento7BugTypeC1EPKNS0_11CheckerBaseEN4llvm9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugTypeC1EPKNS0_11CheckerBaseEN4llvm9StringRefES6_")
  //</editor-fold>
  public BugType(/*const*/ CheckerBase /*P*/ checker, StringRef name, StringRef cat) {
    // : Check(checker->getCheckName()), Name(name.operator basic_string()), Category(cat.operator basic_string()), SuppressonSink(false) 
    //START JInit
    this.Check = checker.getCheckName();
    this.Name = name.$string();
    this.Category = cat.$string();
    this.SuppressonSink = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::~BugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 45,
   FQN="clang::ento::BugType::~BugType", NM="_ZN5clang4ento7BugTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugTypeD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    Category.$destroy();
    Name.$destroy();
    //END JDestroy
  }

  
  // FIXME: Should these be made strings as well?
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 48,
   FQN="clang::ento::BugType::getName", NM="_ZNK5clang4ento7BugType7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento7BugType7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::getCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 49,
   FQN="clang::ento::BugType::getCategory", NM="_ZNK5clang4ento7BugType11getCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento7BugType11getCategoryEv")
  //</editor-fold>
  public StringRef getCategory() /*const*/ {
    return new StringRef(Category);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::getCheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 50,
   FQN="clang::ento::BugType::getCheckName", NM="_ZNK5clang4ento7BugType12getCheckNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento7BugType12getCheckNameEv")
  //</editor-fold>
  public StringRef getCheckName() /*const*/ {
    return Check.getName();
  }

  
  /// isSuppressOnSink - Returns true if bug reports associated with this bug
  ///  type should be suppressed if the end node of the report is post-dominated
  ///  by a sink node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::isSuppressOnSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 55,
   FQN="clang::ento::BugType::isSuppressOnSink", NM="_ZNK5clang4ento7BugType16isSuppressOnSinkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento7BugType16isSuppressOnSinkEv")
  //</editor-fold>
  public boolean isSuppressOnSink() /*const*/ {
    return SuppressonSink;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::setSuppressOnSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 56,
   FQN="clang::ento::BugType::setSuppressOnSink", NM="_ZN5clang4ento7BugType17setSuppressOnSinkEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugType17setSuppressOnSinkEb")
  //</editor-fold>
  public void setSuppressOnSink(boolean x) {
    SuppressonSink = x;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugType::FlushReports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2525,
   FQN="clang::ento::BugType::FlushReports", NM="_ZN5clang4ento7BugType12FlushReportsERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento7BugType12FlushReportsERNS0_11BugReporterE")
  //</editor-fold>
  public void FlushReports(final BugReporter /*&*/ BR) {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public BugType(CheckName check, char$ptr name, char$ptr cat) { this(check, new StringRef(name), new StringRef(cat)); }

  public BugType(/*const*/ CheckerBase /*P*/ checker, char$ptr name, char$ptr cat) { this(checker, new StringRef(name), new StringRef(cat)); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Check=" + Check // NOI18N
              + ", Name=" + Name // NOI18N
              + ", Category=" + Category // NOI18N
              + ", SuppressonSink=" + SuppressonSink; // NOI18N
  }
}
