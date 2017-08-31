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
package org.llvm.support.sys.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.sys.path.append;
import static org.llvm.support.sys.path.home_directory;


//<editor-fold defaultstate="collapsed" desc="static type PathStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL11remove_dotsENS_9StringRefEb;_ZN4llvm3sys4pathL13getEnvTempDirEv;_ZN4llvm3sys4pathL15getUserCacheDirERNS_15SmallVectorImplIcEE;_ZN4llvm3sys4pathL16getDarwinConfDirEbRNS_15SmallVectorImplIcEE;_ZN4llvm3sys4pathL17getDefaultTempDirEb;_ZN4llvm3sys4pathL26preferred_separator_stringE; -static-type=PathStatics -package=org.llvm.support.sys.impl")
//</editor-fold>
public final class PathStatics {

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::preferred_separator_string">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 586,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 596,
 FQN="llvm::sys::path::preferred_separator_string", NM="_ZN4llvm3sys4pathL26preferred_separator_stringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL26preferred_separator_stringE")
//</editor-fold>
public static /*const*//*char*/byte preferred_separator_string[/*2*/] = new$char(2, org.llvm.support.impl.PathStatics.preferred_separator, $$TERM);
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::remove_dots">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 674,
 FQN="llvm::sys::path::remove_dots", NM="_ZN4llvm3sys4pathL11remove_dotsENS_9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL11remove_dotsENS_9StringRefEb")
//</editor-fold>
public static SmallString/*256*/ remove_dots(StringRef path, boolean remove_dot_dot) {
  SmallVector<StringRef> components/*J*/= new SmallVector<StringRef>(16, new StringRef());
  
  // Skip the root path, then look for traversal in the components.
  StringRef rel = org.llvm.support.sys.path.relative_path(new StringRef(path));
  for (StringRef C : llvm.make_range(org.llvm.support.sys.path.begin(new StringRef(rel)), org.llvm.support.sys.path.end(new StringRef(rel)))) {
    if ($eq_StringRef(/*NO_COPY*/C, /*NO_COPY,STRINGREF_STR*/".")) {
      continue;
    }
    if (remove_dot_dot) {
      if ($eq_StringRef(/*NO_COPY*/C, /*NO_COPY,STRINGREF_STR*/"..")) {
        if (!components.empty()) {
          components.pop_back();
        }
        continue;
      }
    }
    components.push_back(C);
  }
  
  SmallString/*256*/ buffer = new SmallString/*256*/(org.llvm.support.sys.path.root_path(new StringRef(path)), 256);
  for (StringRef C : components)  {
    org.llvm.support.sys.path.append(buffer, new Twine(C));
  }
  return buffer;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getDarwinConfDir">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 563,
 FQN="llvm::sys::path::getDarwinConfDir", NM="_ZN4llvm3sys4pathL16getDarwinConfDirEbRNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL16getDarwinConfDirEbRNS_15SmallVectorImplIcEE")
//</editor-fold>
public static boolean getDarwinConfDir(boolean TempDir, SmallString/*&*/ Result) {
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getUserCacheDir">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 588,
 FQN="llvm::sys::path::getUserCacheDir", NM="_ZN4llvm3sys4pathL15getUserCacheDirERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL15getUserCacheDirERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static boolean getUserCacheDir(SmallString/*&*/ Result) {
  {
    // First try using XDS_CACHE_HOME env variable,
    // as specified in XDG Base Directory Specification at
    // http://standards.freedesktop.org/basedir-spec/basedir-spec-latest.html
    /*const*/char$ptr/*char P*/ XdsCacheDir = $tryClone(std.getenv($("XDS_CACHE_HOME")));
    if ((XdsCacheDir != null)) {
      Result.clear();
      Result.append(XdsCacheDir, /*XdsCacheDir.$add*/(strlen(XdsCacheDir))); // JAVA
      return true;
    }
  }
  
  // Try Darwin configuration query
  if (getDarwinConfDir(false, Result)) {
    return true;
  }
  
  // Use "$HOME/.cache" if $HOME is available
  if (home_directory(Result)) {
    append(Result, new Twine(/*KEEP_STR*/".cache"));
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getEnvTempDir">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 611,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 558,
 FQN="llvm::sys::path::getEnvTempDir", NM="_ZN4llvm3sys4pathL13getEnvTempDirEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL13getEnvTempDirEv")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getEnvTempDir() {
  // Check whether the temporary directory is specified by an environment
  // variable.
  /*const*/char$ptr/*char P*/ EnvironmentVariables[/*4*/] = (new /*const*/char$ptr/*char P*/ [/*4*/] {$("TMPDIR"), $("TMP"), $("TEMP"), $("TEMPDIR")});
  for (/*const*/char$ptr/*char P*/ Env : EnvironmentVariables) {
    {
      /*const*/char$ptr/*char P*/ Dir = $tryClone(std.getenv(Env));
      if ((Dir != null)) {
        return Dir;
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getDefaultTempDir">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 623,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 570,
 FQN="llvm::sys::path::getDefaultTempDir", NM="_ZN4llvm3sys4pathL17getDefaultTempDirEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL17getDefaultTempDirEb")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getDefaultTempDir(boolean ErasedOnReboot) {
  if (P_tmpdir != null) {
    return $SLASH_TMP;
  }
  if (ErasedOnReboot) {
    return $SLASH_TMP;
  }
  return $SLASH_VAR_SLASH_TMP;
}

} // END OF class PathStatics
