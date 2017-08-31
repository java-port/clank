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

//<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 61,
 FQN="clang::ento::BuiltinBug", NM="_ZN5clang4ento10BuiltinBugE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBugE")
//</editor-fold>
public class BuiltinBug extends /*public*/ BugType implements Destructors.ClassWithDestructor {
  private /*const*/std.string desc;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2527,
   FQN="clang::ento::BuiltinBug::anchor", NM="_ZN5clang4ento10BuiltinBug6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBug6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::BuiltinBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 65,
   FQN="clang::ento::BuiltinBug::BuiltinBug", NM="_ZN5clang4ento10BuiltinBugC1ENS0_9CheckNameEPKcS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBugC1ENS0_9CheckNameEPKcS4_")
  //</editor-fold>
  public BuiltinBug( CheckName check, /*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ description) {
    // : BugType(check, name, categories::LogicError), desc(description) 
    //START JInit
    super(new  CheckName(check), new StringRef(name), new StringRef(categories.LogicError));
    this.desc = new std.string(description);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::BuiltinBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 68,
   FQN="clang::ento::BuiltinBug::BuiltinBug", NM="_ZN5clang4ento10BuiltinBugC1EPKNS0_11CheckerBaseEPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBugC1EPKNS0_11CheckerBaseEPKcS6_")
  //</editor-fold>
  public BuiltinBug(/*const*/ CheckerBase /*P*/ checker, /*const*/char$ptr/*char P*/ name, 
      /*const*/char$ptr/*char P*/ description) {
    // : BugType(checker, name, categories::LogicError), desc(description) 
    //START JInit
    super(checker, new StringRef(name), new StringRef(categories.LogicError));
    this.desc = new std.string(description);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::BuiltinBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 72,
   FQN="clang::ento::BuiltinBug::BuiltinBug", NM="_ZN5clang4ento10BuiltinBugC1EPKNS0_11CheckerBaseEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBugC1EPKNS0_11CheckerBaseEPKc")
  //</editor-fold>
  public BuiltinBug(/*const*/ CheckerBase /*P*/ checker, /*const*/char$ptr/*char P*/ name) {
    // : BugType(checker, name, categories::LogicError), desc(name) 
    //START JInit
    super(checker, new StringRef(name), new StringRef(categories.LogicError));
    this.desc = new std.string(name);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::getDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 75,
   FQN="clang::ento::BuiltinBug::getDescription", NM="_ZNK5clang4ento10BuiltinBug14getDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento10BuiltinBug14getDescriptionEv")
  //</editor-fold>
  public StringRef getDescription() /*const*/ {
    return new StringRef(desc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BuiltinBug::~BuiltinBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugType.h", line = 61,
   FQN="clang::ento::BuiltinBug::~BuiltinBug", NM="_ZN5clang4ento10BuiltinBugD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10BuiltinBugD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    desc.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "desc=" + desc // NOI18N
              + super.toString(); // NOI18N
  }
}
