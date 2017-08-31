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
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ModuleDependencyCollectorStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZL19isCaseSensitivePathN4llvm9StringRefE;_ZL9real_pathN4llvm9StringRefERNS_15SmallVectorImplIcEE; -static-type=ModuleDependencyCollectorStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class ModuleDependencyCollectorStatics {


// TODO: move this to Support/Path.h and check for HAVE_REALPATH?
//<editor-fold defaultstate="collapsed" desc="real_path">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 84,
 FQN="real_path", NM="_ZL9real_pathN4llvm9StringRefERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZL9real_pathN4llvm9StringRefERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static boolean real_path(StringRef SrcPath, SmallString/*&*/ RealPath) {
  /*char*/byte CanonicalPath[/*4096*/] = new$char(4096);
  
  // TODO: emit a warning in case this fails...?
  if (!(realpath(SrcPath.str().c_str(), CanonicalPath) != null)) {
    return false;
  }
  
  SmallString/*256*/ RPath/*J*/= new SmallString/*256*/(new StringRef(CanonicalPath), 256);
  RealPath.swap(RPath);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isCaseSensitivePath">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 110,
 FQN="isCaseSensitivePath", NM="_ZL19isCaseSensitivePathN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZL19isCaseSensitivePathN4llvm9StringRefE")
//</editor-fold>
public static boolean isCaseSensitivePath(StringRef Path) {
  SmallString/*256*/ TmpDest = new SmallString/*256*/(new StringRef(Path), 256), UpperDest/*J*/= new SmallString/*256*/(256), RealDest/*J*/= new SmallString/*256*/(256);
  // Remove component traversals, links, etc.
  if (!real_path(new StringRef(Path), TmpDest)) {
    return true; // Current default value in vfs.yaml
  }
  Path.$assignMove(TmpDest.$StringRef());
  
  // Change path to all upper case and ask for its real path, if the latter
  // exists and is equal to Path, it's not case sensitive. Default to case
  // sensitive in the absense of realpath, since this is what the VFSWriter
  // already expects when sensitivity isn't setup.
  for (int i = 0; i < Path.size(); i++) {
    /*char*/byte C = Path.$at(i);
    UpperDest.push_back(toUppercase(C));
  }
  if (real_path(UpperDest.$StringRef(), RealDest) && Path.equals(RealDest.$StringRef())) {
    return false;
  }
  return true;
}

} // END OF class ModuleDependencyCollectorStatics
