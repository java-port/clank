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

package org.clang.lex.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.support.sys.path;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type HeaderSearchStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL10copyStringN4llvm9StringRefERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE;_ZL18getTopFrameworkDirRN5clang11FileManagerEN4llvm9StringRefERNS2_15SmallVectorImplISsEE;_ZL19getPrivateModuleMapPKN5clang9FileEntryERNS_11FileManagerE;_ZL19mergeHeaderFileInfoRN5clang14HeaderFileInfoERKS0_;_ZL21checkMSVCHeaderSearchRN5clang17DiagnosticsEngineEPKNS_9FileEntryES4_NS_14SourceLocationE; -static-type=HeaderSearchStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class HeaderSearchStatics {


/// \brief Given a framework directory, find the top-most framework directory.
///
/// \param FileMgr The file manager to use for directory lookups.
/// \param DirName The name of the framework directory.
/// \param SubmodulePath Will be populated with the submodule path from the
/// returned top-level module to the originally named framework.
//<editor-fold defaultstate="collapsed" desc="getTopFrameworkDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 355,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 353,
 FQN="getTopFrameworkDir", NM="_ZL18getTopFrameworkDirRN5clang11FileManagerEN4llvm9StringRefERNS2_15SmallVectorImplISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL18getTopFrameworkDirRN5clang11FileManagerEN4llvm9StringRefERNS2_15SmallVectorImplISsEE")
//</editor-fold>
public static /*const*/ DirectoryEntry /*P*/ getTopFrameworkDir(FileManager /*&*/ FileMgr, StringRef/*CHANGED INSIDE*/ DirName, 
                  SmallVectorImpl<std.string> /*&*/ SubmodulePath) {
  assert ($eq_StringRef(path.extension(/*NO_COPY*/DirName), /*STRINGREF_STR*/".framework")) : "Not a framework directory";
    
  // Note: as an egregious but useful hack we use the real path here, because
  // frameworks moving between top-level frameworks to embedded frameworks tend
  // to be symlinked, and we base the logical structure of modules on the
  // physical layout. In particular, we need to deal with crazy includes like
  //
  //   #include <Foo/Frameworks/Bar.framework/Headers/Wibble.h>
  //
  // where 'Bar' used to be embedded in 'Foo', is now a top-level framework
  // which one should access with, e.g.,
  //
  //   #include <Bar/Wibble.h>
  //
  // Similar issues occur when a top-level framework has moved into an
  // embedded framework.
  /*const*/ DirectoryEntry /*P*/ TopFrameworkDir = FileMgr.getDirectory(/*NO_COPY*/DirName);
  DirName.$assignMove(FileMgr.getCanonicalName(TopFrameworkDir));
  do {
    // Get the parent directory name.
    DirName.$assignMove(path.parent_path(/*NO_COPY*/DirName));
    if (DirName.empty()) {
      break;
    }

    // Determine whether this directory exists.
    /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(/*NO_COPY*/DirName);
    if (!(Dir != null)) {
      break;
    }

    // If this is a framework directory, then we're a subframework of this
    // framework.
    if ($eq_StringRef(path.extension(/*NO_COPY*/DirName), /*STRINGREF_STR*/".framework")) {
      SubmodulePath.push_back(path.stem(/*NO_COPY*/DirName).$string());
      TopFrameworkDir = Dir;
    }
  } while (true);

  return TopFrameworkDir;
}


//===----------------------------------------------------------------------===//
// Header File Location.
//===----------------------------------------------------------------------===//

/// \brief Return true with a diagnostic if the file that MSVC would have found
/// fails to match the one that Clang would have found with MSVC header search
/// disabled.
//<editor-fold defaultstate="collapsed" desc="checkMSVCHeaderSearch">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 543,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 541,
 FQN="checkMSVCHeaderSearch", NM="_ZL21checkMSVCHeaderSearchRN5clang17DiagnosticsEngineEPKNS_9FileEntryES4_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL21checkMSVCHeaderSearchRN5clang17DiagnosticsEngineEPKNS_9FileEntryES4_NS_14SourceLocationE")
//</editor-fold>
public static boolean checkMSVCHeaderSearch(DiagnosticsEngine /*&*/ Diags, 
                     /*const*/ FileEntry /*P*/ MSFE, /*const*/ FileEntry /*P*/ FE, 
                     SourceLocation IncludeLoc) {
  // PERF: remove JavaCleaner
  if ((MSFE != null) && FE != MSFE) {
    $out_DiagnosticBuilder$C_char$ptr$C(Diags.Report(IncludeLoc, diag.ext_pp_include_search_ms), MSFE.getName()).$destroy();
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="copyString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 553,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 551,
 FQN="copyString", NM="_ZL10copyStringN4llvm9StringRefERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL10copyStringN4llvm9StringRefERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ copyString(StringRef Str, BumpPtrAllocatorImpl/*&*/ Alloc) {
  assert (!Str.empty());
  char$ptr/*char P*/ CopyStr = $tryClone(Alloc.Allocate(Str.size() + 1));
  std.copy(Str.begin(), Str.end(), CopyStr);
  CopyStr.$set(Str.size(), $$TERM);
  return CopyStr;
}


//===----------------------------------------------------------------------===//
// File Info Management.
//===----------------------------------------------------------------------===//

/// \brief Merge the header file info provided by \p OtherHFI into the current
/// header file info (\p HFI)
//<editor-fold defaultstate="collapsed" desc="mergeHeaderFileInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 929,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 926,
 FQN="mergeHeaderFileInfo", NM="_ZL19mergeHeaderFileInfoRN5clang14HeaderFileInfoERKS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL19mergeHeaderFileInfoRN5clang14HeaderFileInfoERKS0_")
//</editor-fold>
public static void mergeHeaderFileInfo(HeaderFileInfo /*&*/ HFI, 
                   /*const*/ HeaderFileInfo /*&*/ OtherHFI) {
  assert (OtherHFI.External) : "expected to merge external HFI";
  
  HFI.isImport |= OtherHFI.isImport;
  HFI.isPragmaOnce |= OtherHFI.isPragmaOnce;
  HFI.isModuleHeader |= OtherHFI.isModuleHeader;
  HFI.NumIncludes += $ushort2int(OtherHFI.NumIncludes);
  if (!(HFI.ControllingMacro != null) && !(HFI.ControllingMacroID != 0)) {
    HFI.ControllingMacro = OtherHFI.ControllingMacro;
    HFI.ControllingMacroID = OtherHFI.ControllingMacroID;
  }
  
  HFI.DirInfo = OtherHFI.DirInfo;
  HFI.External = (!HFI.IsValid || HFI.External);
  HFI.IsValid = true;
  HFI.IndexHeaderMapHeader = OtherHFI.IndexHeaderMapHeader;
  // JAVA: check if need to copy, otherwise assign to const StringRef exception
  if (HFI.Framework.empty() && !OtherHFI.Framework.empty()) {
    HFI.Framework = new StringRef(OtherHFI.Framework);
  }
}

//<editor-fold defaultstate="collapsed" desc="getPrivateModuleMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1188,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1185,
 FQN="getPrivateModuleMap", NM="_ZL19getPrivateModuleMapPKN5clang9FileEntryERNS_11FileManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZL19getPrivateModuleMapPKN5clang9FileEntryERNS_11FileManagerE")
//</editor-fold>
public static /*const*/ FileEntry /*P*/ getPrivateModuleMap(/*const*/ FileEntry /*P*/ File, 
                   FileManager /*&*/ FileMgr) {
  StringRef Filename = path.filename(new StringRef(File.getName()));
  SmallString/*128*/ PrivateFilename/*J*/= new SmallString/*128*/(new StringRef(File.getDir().getName()), 128);
  if ($eq_StringRef(/*NO_COPY*/Filename, /*STRINGREF_STR*/"module.map")) {
    path.append(PrivateFilename, new Twine(/*KEEP_STR*/"module_private.map"));
  } else if ($eq_StringRef(/*NO_COPY*/Filename, /*STRINGREF_STR*/"module.modulemap")) {
    path.append(PrivateFilename, new Twine(/*KEEP_STR*/"module.private.modulemap"));
  } else {
    return null;
  }
  return FileMgr.getFile(PrivateFilename.$StringRef());
}

} // END OF class HeaderSearchStatics
