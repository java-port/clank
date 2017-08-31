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
package org.clang.driver.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type JobStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZL14ShouldFallbacki;_ZL8skipArgsPKcb; -static-type=JobStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class JobStatics {

//<editor-fold defaultstate="collapsed" desc="skipArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 40,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 39,
 FQN="skipArgs", NM="_ZL8skipArgsPKcb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZL8skipArgsPKcb")
//</editor-fold>
public static int skipArgs(/*const*/char$ptr/*char P*/ Flag, boolean HaveCrashVFS) {
  // These flags are all of the form -Flag <Arg> and are treated as two
  // arguments.  Therefore, we need to skip the flag and the next argument.
  boolean Res = new StringSwitchBool(/*STRINGREF_STR*/Flag).
      Cases(/*KEEP_STR*/"-MF", /*KEEP_STR*/"-MT", /*KEEP_STR*/"-MQ", /*KEEP_STR*/"-serialize-diagnostic-file", true).
      Cases(/*KEEP_STR*/"-o", /*KEEP_STR*/"-coverage-file", /*KEEP_STR*/"-dependency-file", true).
      Cases(/*KEEP_STR*/"-fdebug-compilation-dir", /*KEEP_STR*/"-idirafter", true).
      Cases(/*KEEP_STR*/"-include", /*KEEP_STR*/"-include-pch", /*KEEP_STR*/"-internal-isystem", true).
      Cases(/*KEEP_STR*/"-internal-externc-isystem", /*KEEP_STR*/"-iprefix", /*KEEP_STR*/"-iwithprefix", true).
      Cases(/*KEEP_STR*/"-iwithprefixbefore", /*KEEP_STR*/"-isystem", /*KEEP_STR*/"-iquote", true).
      Cases(/*KEEP_STR*/"-dwarf-debug-flags", /*KEEP_STR*/"-ivfsoverlay", true).
      Cases(/*KEEP_STR*/"-header-include-file", /*KEEP_STR*/"-diagnostic-log-file", true).
      // Some include flags shouldn't be skipped if we have a crash VFS
      Cases(/*KEEP_STR*/"-isysroot", /*KEEP_STR*/"-I", /*KEEP_STR*/"-F", /*KEEP_STR*/"-resource-dir", !HaveCrashVFS).
      Default(false);
  
  // Match found.
  if (Res) {
    return 2;
  }
  
  // The remaining flags are treated as a single argument.
  
  // These flags are all of the form -Flag and have no second argument.
  Res = new StringSwitchBool(/*STRINGREF_STR*/Flag).
      Cases(/*KEEP_STR*/"-M", /*KEEP_STR*/"-MM", /*KEEP_STR*/"-MG", /*KEEP_STR*/"-MP", /*KEEP_STR*/"-MD", true).
      Case(/*KEEP_STR*/"-MMD", true).
      Default(false);
  
  // Match found.
  if (Res) {
    return 1;
  }
  
  // These flags are treated as a single argument (e.g., -F<Dir>).
  StringRef FlagRef/*J*/= new StringRef(Flag);
  if ((!HaveCrashVFS
     && (FlagRef.startswith(/*STRINGREF_STR*/"-F") || FlagRef.startswith(/*STRINGREF_STR*/"-I")))
     || FlagRef.startswith(/*STRINGREF_STR*/"-fmodules-cache-path=")) {
    return 1;
  }
  
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="ShouldFallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 287,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 274,
 FQN="ShouldFallback", NM="_ZL14ShouldFallbacki",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZL14ShouldFallbacki")
//</editor-fold>
public static boolean ShouldFallback(int ExitCode) {
  // FIXME: We really just want to fall back for internal errors, such
  // as when some symbol cannot be mangled, when we should be able to
  // parse something but can't, etc.
  return ExitCode != 0;
}

} // END OF class JobStatics
