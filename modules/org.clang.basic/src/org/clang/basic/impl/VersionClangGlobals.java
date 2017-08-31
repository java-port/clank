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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.config.config.*;


//<editor-fold defaultstate="collapsed" desc="static type VersionClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang15getLLVMRevisionEv;_ZN5clang16getClangRevisionEv;_ZN5clang19getClangFullVersionEv;_ZN5clang21getLLVMRepositoryPathEv;_ZN5clang22getClangFullCPPVersionEv;_ZN5clang22getClangRepositoryPathEv;_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE;_ZN5clang29getClangFullRepositoryVersionEv; -static-type=VersionClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class VersionClangGlobals {

/// \brief Retrieves the repository path (e.g., Subversion path) that
/// identifies the particular Clang branch, tag, or trunk from which this
/// Clang was built.
//<editor-fold defaultstate="collapsed" desc="clang::getClangRepositoryPath">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 27,
 FQN="clang::getClangRepositoryPath", NM="_ZN5clang22getClangRepositoryPathEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang22getClangRepositoryPathEv")
//</editor-fold>
public static std.string getClangRepositoryPath() {
//#if defined(CLANG_REPOSITORY_STRING)
//  return CLANG_REPOSITORY_STRING;
//#else
//#ifdef SVN_REPOSITORY
//  StringRef URL(SVN_REPOSITORY);
//#else
  StringRef URL/*J*/= new StringRef(SVN_REPOSITORY);/*do not use StringRef.EMPTY here!*/
//#endif
  
  // If the SVN_REPOSITORY is empty, try to use the SVN keyword. This helps us
  // pick up a tag in an SVN export, for example.
  StringRef SVNRepository/*J*/= new StringRef(/*KEEP_STR*/"$URL: http://llvm.org/svn/llvm-project/cfe/tags/RELEASE_390/final/lib/Basic/Version.cpp $");
  if (URL.empty()) {
    URL.$assignMove(SVNRepository.slice(SVNRepository.find($$COLON), 
            SVNRepository.find(/*STRINGREF_STR*/"/lib/Basic")));
  }
  
  // Strip off version from a build from an integration branch.
  URL.$assignMove(URL.slice(0, URL.find(/*STRINGREF_STR*/"/src/tools/clang")));
  
  // Trim path prefix off, assuming path came from standard cfe path.
  /*size_t*/int Start = URL.find(/*STRINGREF_STR*/"cfe/");
  if (Start != StringRef.npos) {
    URL.$assignMove(URL.substr(Start + 4));
  }
  
  return URL.$string();
}


/// \brief Retrieves the repository path from which LLVM was built.
///
/// This supports LLVM residing in a separate repository from clang.
//<editor-fold defaultstate="collapsed" desc="clang::getLLVMRepositoryPath">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 57,
 FQN="clang::getLLVMRepositoryPath", NM="_ZN5clang21getLLVMRepositoryPathEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang21getLLVMRepositoryPathEv")
//</editor-fold>
public static std.string getLLVMRepositoryPath() {
//#ifdef LLVM_REPOSITORY
//  StringRef URL(LLVM_REPOSITORY);
//#else
  StringRef URL = new StringRef(LLVM_REPOSITORY);/*do not use StringRef.EMPTY here!*/
//#endif  
  
  // Trim path prefix off, assuming path came from standard llvm path.
  // Leave "llvm/" prefix to distinguish the following llvm revision from the
  // clang revision.
  /*size_t*/int Start = URL.find(/*STRINGREF_STR*/"llvm/");
  if (Start != StringRef.npos) {
    URL.$assignMove(URL.substr(Start));
  }
  
  return URL.$string();
}


/// \brief Retrieves the repository revision number (or identifer) from which
/// this Clang was built.
//<editor-fold defaultstate="collapsed" desc="clang::getClangRevision">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 74,
 FQN="clang::getClangRevision", NM="_ZN5clang16getClangRevisionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang16getClangRevisionEv")
//</editor-fold>
public static std.string getClangRevision() {
  return new std.string(/*KEEP_STR*/SVN_REVISION);
}


/// \brief Retrieves the repository revision number (or identifer) from which
/// LLVM was built.
///
/// If Clang and LLVM are in the same repository, this returns the same
/// string as getClangRevision.
//<editor-fold defaultstate="collapsed" desc="clang::getLLVMRevision">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 82,
 FQN="clang::getLLVMRevision", NM="_ZN5clang15getLLVMRevisionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang15getLLVMRevisionEv")
//</editor-fold>
public static std.string getLLVMRevision() {
  return new std.string(/*KEEP_STR*/LLVM_REVISION);
}


/// \brief Retrieves the full repository version that is an amalgamation of
/// the information in getClangRepositoryPath() and getClangRevision().
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullRepositoryVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 90,
 FQN="clang::getClangFullRepositoryVersion", NM="_ZN5clang29getClangFullRepositoryVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang29getClangFullRepositoryVersionEv")
//</editor-fold>
public static std.string getClangFullRepositoryVersion() {
  raw_string_ostream OS = null;
  try {
    std.string buf/*J*/= new std.string();
    OS/*J*/= new raw_string_ostream(buf);
    std.string Path = getClangRepositoryPath();
    std.string Revision = getClangRevision();
    if (!Path.empty() || !Revision.empty()) {
      OS.$out_char($$LPAREN);
      if (!Path.empty()) {
        OS.$out(Path);
      }
      if (!Revision.empty()) {
        if (!Path.empty()) {
          OS.$out_char($$SPACE);
        }
        OS.$out(Revision);
      }
      OS.$out_char($$RPAREN);
    }
    // Support LLVM in a separate repository.
    std.string LLVMRev = getLLVMRevision();
    if (!LLVMRev.empty() && $noteq_str$C(LLVMRev, Revision)) {
      OS.$out(/*KEEP_STR*/" (");
      std.string LLVMRepo = getLLVMRepositoryPath();
      if (!LLVMRepo.empty()) {
        OS.$out(LLVMRepo).$out_char($$SPACE);
      }
      OS.$out(LLVMRev).$out_char($$RPAREN);
    }
    return new std.string(OS.str());
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}


/// \brief Retrieves a string representing the complete clang version,
/// which includes the clang version number, the repository version,
/// and the vendor tag.
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 118,
 FQN="clang::getClangFullVersion", NM="_ZN5clang19getClangFullVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang19getClangFullVersionEv")
//</editor-fold>
public static std.string getClangFullVersion() {
  return getClangToolFullVersion(new StringRef(/*KEEP_STR*/"clang"));
}


/// \brief Like getClangFullVersion(), but with a custom tool name.
//<editor-fold defaultstate="collapsed" desc="clang::getClangToolFullVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 122,
 FQN="clang::getClangToolFullVersion", NM="_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE")
//</editor-fold>
public static std.string getClangToolFullVersion(StringRef ToolName) {
  raw_string_ostream OS = null;
  try {
    std.string buf/*J*/= new std.string();
    OS/*J*/= new raw_string_ostream(buf);
    OS.$out(/*NO_COPY*/ToolName).$out(/*KEEP_STR*/" version " + CLANG_VERSION_STRING + " ").$out(getClangFullRepositoryVersion());
    
    return new std.string(OS.str());
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}


/// \brief Retrieves a string representing the complete clang version suitable
/// for use in the CPP __VERSION__ macro, which includes the clang version
/// number, the repository version, and the vendor tag.
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullCPPVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 139,
 FQN="clang::getClangFullCPPVersion", NM="_ZN5clang22getClangFullCPPVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang22getClangFullCPPVersionEv")
//</editor-fold>
public static std.string getClangFullCPPVersion() {
  raw_string_ostream OS = null;
  try {
    // The version string we report in __VERSION__ is just a compacted version of
    // the one we report on the command line.
    std.string buf/*J*/= new std.string();
    OS/*J*/= new raw_string_ostream(buf);
    OS.$out(/*KEEP_STR*/"Clang " + CLANG_VERSION_STRING + " ").$out(getClangFullRepositoryVersion());
    return new std.string(OS.str());
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}

} // END OF class VersionClangGlobals
