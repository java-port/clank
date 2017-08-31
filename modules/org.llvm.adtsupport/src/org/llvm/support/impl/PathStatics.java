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

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.sys.path.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.sys.Process;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="static type PathStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_1L10separatorsE;_ZN12_GLOBAL__N_1L19preferred_separatorE;_ZN12_GLOBAL__N_120find_first_componentEN4llvm9StringRefE;_ZN12_GLOBAL__N_112filename_posEN4llvm9StringRefE;_ZN12_GLOBAL__N_114root_dir_startEN4llvm9StringRefE;_ZN12_GLOBAL__N_115parent_path_endEN4llvm9StringRefE;_ZL18createUniqueEntityRKN4llvm5TwineERiRNS_15SmallVectorImplIcEEbj8FSEntity; -static-type=PathStatics")
//</editor-fold>
public final class PathStatics {

// FIXME: orignal code is
//#ifdef LLVM_ON_WIN32
//  const char *separators = "\\/";
//  const char preferred_separator = '\\';
//#else
//  const char  separators = '/';
//  const char preferred_separator = '/';
//#endif  
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::separators">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 41,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 42,
 FQN = "(anonymous namespace)::separators", NM = "_ZN12_GLOBAL__N_1L10separatorsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_1L10separatorsE")
//</editor-fold>
public static final /*const*//*char*/String separators;

static {
  if (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) { //JAVA:#ifdef LLVM_ON_WIN32
    separators = "\\/"; //NOI18N
  } else {
    separators = "/"; //NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::preferred_separator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 42,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 43,
 FQN = "(anonymous namespace)::preferred_separator", NM = "_ZN12_GLOBAL__N_1L19preferred_separatorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_1L19preferred_separatorE")
//</editor-fold>
public static final /*const*//*char*/byte preferred_separator = $$SLASH;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::find_first_component">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 45,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 46,
 FQN = "(anonymous namespace)::find_first_component", NM = "_ZN12_GLOBAL__N_120find_first_componentEN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_120find_first_componentEN4llvm9StringRefE")
//</editor-fold>
public static StringRef find_first_component(StringRef path) {

  int pathOffsetInURL = get_path_offset_in_url(path);
  if (pathOffsetInURL > 0) {
    // URL-like paths are always absolute
    if (path.size() == pathOffsetInURL) {
      return path;
    } else if (is_separator(path.$at(pathOffsetInURL))) {
      return path.substr(0, pathOffsetInURL+1);
    } else {
      //pathOffsetInURL = getPathOffsetInURL(path);
      NativeTrace.printStackTraceOnce(new AssertionError("Invalid URL-like path " + path)); //NOI18N
    }
  }

  // Look for this first component in the following order.
  // * empty (in this case we return an empty string)
  // * either C: or {//,\\}net.
  // * {/,\}
  // * {.,..}
  // * {file,directory}name
  if (path.empty()) {
    return path;
  }
  
  if (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) { //JAVA:#ifdef LLVM_ON_WIN32
    // C:
    if (path.size() >= 2 && (std.isalpha(((/*static_cast*//*uchar*/short)(path.$at(0)))) != 0)
       && path.$at(1) == $(':')) {
      return path.substr(0, 2);
    }
  }//JAVA:#endif

  // //net
  if ((path.size() > 2)
     && is_separator(path.$at(0))
     && path.$at(0) == path.$at(1)
     && !is_separator(path.$at(2))) {
    // Find the next directory separator.
    /*size_t*/int end = path.find_first_of(separators, 2);
    return path.substr(0, end);
  }
  
  // {/,\}
  if (is_separator(path.$at(0))) {
    return path.substr(0, 1);
  }
    if (path.startswith($DOT_DOT)) {
    return path.substr(0, 2);
  }
  if (path.$at(0) == $$DOT) {
    return path.substr(0, 1);
  }
  
  // * {file,directory}name
  /*size_t*/int end = path.find_first_of(separators);
  return path.substr(0, end);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::filename_pos">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 81,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 89,
 FQN = "(anonymous namespace)::filename_pos", NM = "_ZN12_GLOBAL__N_112filename_posEN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_112filename_posEN4llvm9StringRefE")
//</editor-fold>
public static /*size_t*/int filename_pos(StringRef str) {

  int pathOffsetInURL = get_path_offset_in_url(str);
  if (pathOffsetInURL > 0) {
    StringRef purePath = str.substr(pathOffsetInURL);
    int pos = filename_pos(purePath); // TODO: optimize
    return pos + pathOffsetInURL;
  }
  
  if (str.size() == 2
     && is_separator(str.$at(0))
     && str.$at(0) == str.$at(1)) {
    return 0;
  }
  if (str.size() > 0 && is_separator(str.$at(str.size() - 1))) {
    return str.size() - 1;
  }
  
  /*size_t*/int pos = str.find_last_of(separators, (str.size() > 0 ? str.size() - 1 : StringRef.npos));
  
  if (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) { //JAVA:#ifdef LLVM_ON_WIN32
    if (pos == StringRef.npos) { // JAVA: Windows TODO: better fix
      pos = str.find_last_of((byte)'\\', (str.size() > 0 ? str.size() - 1 : StringRef.npos));
    }
    if (pos == StringRef.npos) {
      pos = str.find_last_of($(':'), (str.size() > 1 ? str.size() - 2 : StringRef.npos));
    }
  }//JAVA:#endif
  
  if (pos == StringRef.npos
     || (pos == 1 && is_separator(str.$at(0)))) {
    return 0;
  }
  
  return pos + 1;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::root_dir_start">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 104,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 112,
 FQN = "(anonymous namespace)::root_dir_start", NM = "_ZN12_GLOBAL__N_114root_dir_startEN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_114root_dir_startEN4llvm9StringRefE")
//</editor-fold>
public static /*size_t*/int root_dir_start(StringRef str) {
  // case "c:/"
  if (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) { //JAVA:#ifdef LLVM_ON_WIN32
    if (str.size() > 2
       && str.$at(1) == $(':')
       && is_separator(str.$at(2))) {
      return 2;
    }
  } //JAVA:#endif
  
  // case "//"
  if (str.size() == 2
     && is_separator(str.$at(0))
     && str.$at(0) == str.$at(1)) {
    return StringRef.npos;
  }
  
  // case "//net"
  if (str.size() > 3
     && is_separator(str.$at(0))
     && str.$at(0) == str.$at(1)
     && !is_separator(str.$at(2))) {
    return str.find_first_of(separators, 2);
  }
  
  // case "/"
  if (str.size() > 0 && is_separator(str.$at(0))) {
    return 0;
  }
  
  return StringRef.npos;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::parent_path_end">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 134,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 142,
 FQN = "(anonymous namespace)::parent_path_end", NM = "_ZN12_GLOBAL__N_115parent_path_endEN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN12_GLOBAL__N_115parent_path_endEN4llvm9StringRefE")
//</editor-fold>
public static /*size_t*/int parent_path_end(StringRef path) {
  /*size_t*/int end_pos = filename_pos(path);
  
  if (end_pos >= path.size()) {
    // the path is empty, but the length can be non-zero if it is url-like
    return StringRef.npos;
  }

  boolean filename_was_sep = path.size() > 0 && is_separator(path.$at(end_pos));
  
  // Skip separators except for root dir.
  /*size_t*/int root_dir_pos = root_dir_start(path.substr(0, end_pos));
  while (end_pos > 0
     && (end_pos - 1) != root_dir_pos
     && is_separator(path.$at(end_pos - 1))) {
    --end_pos;
  }
  if (end_pos == 1 && root_dir_pos == 0 && filename_was_sep) {
    return StringRef.npos;
  }
  
  return end_pos;
}

//<editor-fold defaultstate="collapsed" desc="createUniqueEntity">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 160,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 168,
 FQN = "createUniqueEntity", NM = "_ZL18createUniqueEntityRKN4llvm5TwineERiRNS_15SmallVectorImplIcEEbj8FSEntity",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZL18createUniqueEntityRKN4llvm5TwineERiRNS_15SmallVectorImplIcEEbj8FSEntity")
//</editor-fold>
public static std.error_code createUniqueEntity(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFD, 
                  SmallString/*&*/ ResultPath, 
                  boolean MakeAbsolute, /*uint*/int Mode, 
                  FSEntity Type) {
  SmallString/*128*/ ModelStorage/*J*/= new SmallString/*128*/(128);
  Model.toVector(ModelStorage);
  if (MakeAbsolute) {
    // Make model absolute by prepending a temp directory if it's not already.
    if (!path.is_absolute(new Twine(ModelStorage.$StringRef()))) {
      SmallString/*128*/ TDir/*J*/= new SmallString/*128*/(128);
      path.system_temp_directory(true, TDir);
      path.append(TDir, new Twine(ModelStorage.$StringRef()));
      ModelStorage.swap(TDir);
    }
  }

  // From here on, DO NOT modify model. It may be needed if the randomly chosen
  // path already exists.
  ResultPath.$assign(ModelStorage);
  // Null terminate.
  ResultPath.push_back($$TERM);
  ResultPath.pop_back();
 retry_random_path: // JAVA: introduce infinite for loop to handle lable
  for (;;) {
  // Replace '%' with random chars.
  for (/*uint*/int i = 0, e = ModelStorage.size(); i != e; ++i) {
    if (ModelStorage.$at(i) == $$PERCENT) {
      ResultPath.$set(i, (byte) "0123456789abcdef".charAt((int)Process.GetRandomNumber() & 15));
    }
  }

  // Try to open + create the file.
  switch (Type) {
   case FS_File:
    {
      {
        std.error_code EC = fs.openFileForWrite(new Twine(ResultPath.begin()), ResultFD, 
            fs.$bitor_OpenFlags(fs.OpenFlags.F_RW, fs.OpenFlags.F_Excl), Mode);
        if (EC.$bool()) {
          if ($eq_error_code(EC, new error_code(errc.file_exists))) {
            continue retry_random_path;
          }
          return EC;
        }
      }

      return new std.error_code();
    }
   case FS_Name:
    {
      std.error_code EC = fs.access(new Twine(ResultPath.begin()), fs.AccessMode.Exist);
      if ($eq_error_code(EC, new error_code(errc.no_such_file_or_directory))) {
        return new std.error_code();
      }
      if (EC.$bool()) {
        return EC;
      }
      continue retry_random_path;
    }
   case FS_Dir:
    {
      {
        std.error_code EC = fs.create_directory(new Twine(ResultPath.begin()), false);
        if (EC.$bool()) {
          if ($eq_error_code(EC, new error_code(errc.file_exists))) {
            continue retry_random_path;
          }
          return EC;
        }
      }
      return new std.error_code();
    }
  }
  throw new llvm_unreachable("Invalid Type");
  }
}

} // END OF class PathStatics
