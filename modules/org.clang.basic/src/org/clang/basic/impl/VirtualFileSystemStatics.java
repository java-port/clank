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
package org.clang.basic.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="static type VirtualFileSystemStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZL16pathHasTraversalN4llvm9StringRefE;_ZL20isTraversalComponentN4llvm9StringRefE;_ZL23getRedirectedFileStatusRKN4llvm5TwineEbN5clang3vfs6StatusE; -static-type=VirtualFileSystemStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class VirtualFileSystemStatics {

//<editor-fold defaultstate="collapsed" desc="isTraversalComponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 121,
 FQN="isTraversalComponent", NM="_ZL20isTraversalComponentN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZL20isTraversalComponentN4llvm9StringRefE")
//</editor-fold>
public static boolean isTraversalComponent(StringRef Component) {
  return Component.equals(/*STRINGREF_STR*/$DOT_DOT) || Component.equals(/*STRINGREF_STR*/$DOT);
}

//<editor-fold defaultstate="collapsed" desc="pathHasTraversal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 125,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1380,
 FQN="pathHasTraversal", NM="_ZL16pathHasTraversalN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZL16pathHasTraversalN4llvm9StringRefE")
//</editor-fold>
public static boolean pathHasTraversal(StringRef Path) {
  //JAVA: using namespace llvm::sys;
  for (StringRef Comp : llvm.make_range(path.begin(/*NO_COPY*/Path), path.end(/*NO_COPY*/Path)))  {
    if (isTraversalComponent(/*NO_COPY*/Comp)) {
      return true;
    }
  }
  return false;
}

  
//<editor-fold defaultstate="collapsed" desc="getRedirectedFileStatus">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1503,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1286,
 FQN="getRedirectedFileStatus", NM="_ZL23getRedirectedFileStatusRKN4llvm5TwineEbN5clang3vfs6StatusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZL23getRedirectedFileStatusRKN4llvm5TwineEbN5clang3vfs6StatusE")
//</editor-fold>
public static Status getRedirectedFileStatus(/*const*/ Twine /*&*/ Path, boolean UseExternalNames, 
                       Status ExternalStatus) {
  Status S = new Status(ExternalStatus);
  if (!UseExternalNames) {
    S.$assignMove(Status.copyWithNewName(S, new StringRef(Path.str())));
  }
  S.IsVFSMapped = true;
  return S;
}

} // END OF class VirtualFileSystemStatics
