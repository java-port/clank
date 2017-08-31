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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.impl.*;
import static org.clang.frontend.impl.DependencyFileStatics.*;


/// An interface for collecting the dependencies of a compilation. Users should
/// use \c attachToPreprocessor and \c attachToASTReader to get all of the
/// dependencies.
/// FIXME: Migrate DependencyFileGen and DependencyGraphGen to use this
/// interface.
//<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 79,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 78,
 FQN="clang::DependencyCollector", NM="_ZN5clang19DependencyCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollectorE")
//</editor-fold>
public class DependencyCollector implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::attachToPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 141,
   FQN="clang::DependencyCollector::attachToPreprocessor", NM="_ZN5clang19DependencyCollector20attachToPreprocessorERNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector20attachToPreprocessorERNS_12PreprocessorE")
  //</editor-fold>
  public void attachToPreprocessor(Preprocessor /*&*/ PP) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DepCollectorPPCallbacks(/*Deref*/this, PP.getSourceManager())))))); $c$.clean();
      PP.getHeaderSearchInfo().getModuleMap().addModuleMapCallbacks($c$.track(new std.unique_ptr<ModuleMapCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DepCollectorMMCallbacks(/*Deref*/this)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::attachToASTReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 147,
   FQN="clang::DependencyCollector::attachToASTReader", NM="_ZN5clang19DependencyCollector17attachToASTReaderERNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector17attachToASTReaderERNS_9ASTReaderE")
  //</editor-fold>
  public void attachToASTReader(ASTReader /*&*/ R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      R.addListener($c$.track(new std.unique_ptr<ASTReaderListener>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DepCollectorASTListener(/*Deref*/this)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::getDependencies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 82,
   FQN="clang::DependencyCollector::getDependencies", NM="_ZNK5clang19DependencyCollector15getDependenciesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZNK5clang19DependencyCollector15getDependenciesEv")
  //</editor-fold>
  public ArrayRef<std.string> getDependencies() /*const*/ {
    return new ArrayRef<std.string>(Dependencies);
  }

  
  /// Called when a new file is seen. Return true if \p Filename should be added
  /// to the list of dependencies.
  ///
  /// The default implementation ignores <built-in> and system files.
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::sawDependency">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 133,
   FQN="clang::DependencyCollector::sawDependency", NM="_ZN5clang19DependencyCollector13sawDependencyEN4llvm9StringRefEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector13sawDependencyEN4llvm9StringRefEbbbb")
  //</editor-fold>
  public boolean sawDependency(StringRef Filename, boolean FromModule, 
               boolean IsSystem, boolean IsModuleFile, 
               boolean IsMissing) {
    return !isSpecialFilename(new StringRef(Filename))
       && (needSystemDependencies() || !IsSystem);
  }

  /// Called when the end of the main file is reached.
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::finishedMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 91,
   FQN="clang::DependencyCollector::finishedMainFile", NM="_ZN5clang19DependencyCollector16finishedMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector16finishedMainFileEv")
  //</editor-fold>
  public /*virtual*/ void finishedMainFile() {
  }

  /// Return true if system files should be passed to sawDependency().
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::needSystemDependencies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 93,
   FQN="clang::DependencyCollector::needSystemDependencies", NM="_ZN5clang19DependencyCollector22needSystemDependenciesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector22needSystemDependenciesEv")
  //</editor-fold>
  public /*virtual*/ boolean needSystemDependencies() {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::~DependencyCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 140,
   FQN="clang::DependencyCollector::~DependencyCollector", NM="_ZN5clang19DependencyCollectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Dependencies.$destroy();
    Seen.$destroy();
    //END JDestroy
  }

/*public:*/
  // implementation detail
  /// Add a dependency \p Filename if it has not been seen before and
  /// sawDependency() returns true.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::maybeAddDependency">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 118,
   FQN="clang::DependencyCollector::maybeAddDependency", NM="_ZN5clang19DependencyCollector18maybeAddDependencyEN4llvm9StringRefEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollector18maybeAddDependencyEN4llvm9StringRefEbbbb")
  //</editor-fold>
  public void maybeAddDependency(StringRef Filename, boolean FromModule, 
                    boolean IsSystem, boolean IsModuleFile, 
                    boolean IsMissing) {
    if (Seen.insert(/*NO_COPY*/Filename).second
       && sawDependency(new StringRef(Filename), FromModule, IsSystem, IsModuleFile, IsMissing)) {
      Dependencies.push_back_T$RR(Filename.$string());
    }
  }

/*private:*/
  private StringSet/*<MallocAllocator>*/ Seen;
  private std.vectorString Dependencies;
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyCollector::DependencyCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 78,
   FQN="clang::DependencyCollector::DependencyCollector", NM="_ZN5clang19DependencyCollectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang19DependencyCollectorC1Ev")
  //</editor-fold>
  public /*inline*/ DependencyCollector() {
    // : Seen(), Dependencies() 
    //START JInit
    this.Seen = new StringSet/*<MallocAllocator>*/();
    this.Dependencies = new std.vectorString(std.string.EMPTY);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Seen=" + Seen // NOI18N
              + ", Dependencies=" + Dependencies; // NOI18N
  }
}
