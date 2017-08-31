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

package org.clang.frontend.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.serialization.ModuleKind;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 93,
 FQN="(anonymous namespace)::DepCollectorASTListener", NM="_ZN12_GLOBAL__N_123DepCollectorASTListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListenerE")
//</editor-fold>
public class/*struct*/ DepCollectorASTListener extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  public DependencyCollector /*&*/ DepCollector;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::DepCollectorASTListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 95,
   FQN="(anonymous namespace)::DepCollectorASTListener::DepCollectorASTListener", NM="_ZN12_GLOBAL__N_123DepCollectorASTListenerC1ERN5clang19DependencyCollectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListenerC1ERN5clang19DependencyCollectorE")
  //</editor-fold>
  public DepCollectorASTListener(DependencyCollector /*&*/ L) {
    // : ASTReaderListener(), DepCollector(L) 
    //START JInit
    super();
    this./*&*/DepCollector=/*&*/L;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::needsInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 96,
   FQN="(anonymous namespace)::DepCollectorASTListener::needsInputFileVisitation", NM="_ZN12_GLOBAL__N_123DepCollectorASTListener24needsInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListener24needsInputFileVisitationEv")
  //</editor-fold>
  @Override public boolean needsInputFileVisitation()/* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::needsSystemInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 97,
   FQN="(anonymous namespace)::DepCollectorASTListener::needsSystemInputFileVisitation", NM="_ZN12_GLOBAL__N_123DepCollectorASTListener30needsSystemInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListener30needsSystemInputFileVisitationEv")
  //</editor-fold>
  @Override public boolean needsSystemInputFileVisitation()/* override*/ {
    return DepCollector.needSystemDependencies();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::visitModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 100,
   FQN="(anonymous namespace)::DepCollectorASTListener::visitModuleFile", NM="_ZN12_GLOBAL__N_123DepCollectorASTListener15visitModuleFileEN4llvm9StringRefEN5clang13serialization10ModuleKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListener15visitModuleFileEN4llvm9StringRefEN5clang13serialization10ModuleKindE")
  //</editor-fold>
  @Override public void visitModuleFile(StringRef Filename, 
                 ModuleKind Kind)/* override*/ {
    DepCollector.maybeAddDependency(new StringRef(Filename), /*FromModule*/ true, 
        /*IsSystem*/ false, /*IsModuleFile*/ true, 
        /*IsMissing*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::visitInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 106,
   FQN="(anonymous namespace)::DepCollectorASTListener::visitInputFile", NM="_ZN12_GLOBAL__N_123DepCollectorASTListener14visitInputFileEN4llvm9StringRefEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListener14visitInputFileEN4llvm9StringRefEbbb")
  //</editor-fold>
  @Override public boolean visitInputFile(StringRef Filename, boolean IsSystem, 
                boolean IsOverridden, boolean IsExplicitModule)/* override*/ {
    if (IsOverridden || IsExplicitModule) {
      return true;
    }
    
    DepCollector.maybeAddDependency(new StringRef(Filename), /*FromModule*/ true, IsSystem, 
        /*IsModuleFile*/ false, /*IsMissing*/ false);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorASTListener::~DepCollectorASTListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 93,
   FQN="(anonymous namespace)::DepCollectorASTListener::~DepCollectorASTListener", NM="_ZN12_GLOBAL__N_123DepCollectorASTListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorASTListenerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "DepCollector=" + DepCollector // NOI18N
              + super.toString(); // NOI18N
  }
}
