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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.llvm.support.sys.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleDependencyMMCallbacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 42,
 FQN="(anonymous namespace)::ModuleDependencyMMCallbacks", NM="_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksE")
//</editor-fold>
public class/*struct*/ ModuleDependencyMMCallbacks extends /*public*/ ModuleMapCallbacks implements Destructors.ClassWithDestructor {
  public ModuleDependencyCollector /*&*/ Collector;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleDependencyMMCallbacks::ModuleDependencyMMCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 44,
   FQN="(anonymous namespace)::ModuleDependencyMMCallbacks::ModuleDependencyMMCallbacks", NM="_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksC1ERN5clang25ModuleDependencyCollectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksC1ERN5clang25ModuleDependencyCollectorE")
  //</editor-fold>
  public ModuleDependencyMMCallbacks(ModuleDependencyCollector /*&*/ Collector) {
    // : ModuleMapCallbacks(), Collector(Collector) 
    //START JInit
    super();
    this./*&*/Collector=/*&*/Collector;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleDependencyMMCallbacks::moduleMapAddHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 47,
   FQN="(anonymous namespace)::ModuleDependencyMMCallbacks::moduleMapAddHeader", NM="_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacks18moduleMapAddHeaderEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacks18moduleMapAddHeaderEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void moduleMapAddHeader(StringRef HeaderPath)/* override*/ {
    if (path.is_absolute(new Twine(HeaderPath))) {
      Collector.addFile(new StringRef(HeaderPath));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleDependencyMMCallbacks::moduleMapAddUmbrellaHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 51,
   FQN="(anonymous namespace)::ModuleDependencyMMCallbacks::moduleMapAddUmbrellaHeader", NM="_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacks26moduleMapAddUmbrellaHeaderEPN5clang11FileManagerEPKNS1_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacks26moduleMapAddUmbrellaHeaderEPN5clang11FileManagerEPKNS1_9FileEntryE")
  //</editor-fold>
  @Override public void moduleMapAddUmbrellaHeader(FileManager /*P*/ FileMgr, 
                            /*const*/ FileEntry /*P*/ Header)/* override*/ {
    StringRef HeaderFilename = new StringRef(Header.getName());
    moduleMapAddHeader(new StringRef(HeaderFilename));
    // The FileManager can find and cache the symbolic link for a framework
    // header before its real path, this means a module can have some of its
    // headers to use other paths. Although this is usually not a problem, it's
    // inconsistent, and not collecting the original path header leads to
    // umbrella clashes while rebuilding modules in the crash reproducer. For
    // example:
    //    ApplicationServices.framework/Frameworks/ImageIO.framework/ImageIO.h
    // instead of:
    //    ImageIO.framework/ImageIO.h
    //
    // FIXME: this shouldn't be necessary once we have FileName instances
    // around instead of FileEntry ones. For now, make sure we collect all
    // that we need for the reproducer to work correctly.
    StringRef UmbreallDirFromHeader = path.parent_path(/*NO_COPY*/HeaderFilename);
    StringRef UmbrellaDir = new StringRef(Header.getDir().getName());
    if (!UmbrellaDir.equals(/*NO_COPY*/UmbreallDirFromHeader)) {
      SmallString/*128*/ AltHeaderFilename/*J*/= new SmallString/*128*/(128);
      path.append(AltHeaderFilename, new Twine(UmbrellaDir), 
          new Twine(path.filename(/*NO_COPY*/HeaderFilename)));
      if ((FileMgr.getFile(AltHeaderFilename.$StringRef()) != null)) {
        moduleMapAddHeader(AltHeaderFilename.$StringRef());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleDependencyMMCallbacks::~ModuleDependencyMMCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 42,
   FQN="(anonymous namespace)::ModuleDependencyMMCallbacks::~ModuleDependencyMMCallbacks", NM="_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN12_GLOBAL__N_127ModuleDependencyMMCallbacksD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Collector=" + Collector // NOI18N
              + super.toString(); // NOI18N
  }
}
