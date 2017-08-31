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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.Module.HeaderKind;
import org.clang.basic.vfs.*;
import org.clang.lex.*;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="static type FrontendActionsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZL16addHeaderIncludeN4llvm9StringRefERNS_15SmallVectorImplIcEERKN5clang11LangOptionsEb;_ZL27collectModuleHeaderIncludesRKN5clang11LangOptionsERNS_11FileManagerERNS_9ModuleMapEPNS_6ModuleERN4llvm15SmallVectorImplIcEE;_ZpLRN4llvm15SmallVectorImplIcEENS_9StringRefE; -static-type=FrontendActionsStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class FrontendActionsStatics {

//<editor-fold defaultstate="collapsed" desc="operator+=">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 155,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 149,
 FQN="operator+=", NM="_ZpLRN4llvm15SmallVectorImplIcEENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZpLRN4llvm15SmallVectorImplIcEENS_9StringRefE")
//</editor-fold>
public static SmallString/*&*/ $addassign_SmallString_StringRef(SmallString/*&*/ Includes, StringRef RHS) {
  Includes.append(RHS);
  return Includes;
}
public static SmallString/*&*/ $addassign_SmallString_StringRef(SmallString/*&*/ Includes, String RHS) {
  Includes.append(RHS);
  return Includes;
}

//<editor-fold defaultstate="collapsed" desc="addHeaderInclude">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 161,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 155,
 FQN="addHeaderInclude", NM="_ZL16addHeaderIncludeN4llvm9StringRefERNS_15SmallVectorImplIcEERKN5clang11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZL16addHeaderIncludeN4llvm9StringRefERNS_15SmallVectorImplIcEERKN5clang11LangOptionsEb")
//</editor-fold>
public static void addHeaderInclude(StringRef HeaderName, 
                SmallString/*&*/ Includes, 
                /*const*/ LangOptions /*&*/ LangOpts, 
                boolean IsExternC) {
  if (IsExternC && LangOpts.CPlusPlus) {
    $addassign_SmallString_StringRef(Includes, /*STRINGREF_STR*/"extern \"C\" {\n");
  }
  if (LangOpts.ObjC1) {
    $addassign_SmallString_StringRef(Includes, /*STRINGREF_STR*/"#import \"");
  } else {
    $addassign_SmallString_StringRef(Includes, /*STRINGREF_STR*/"#include \"");
  }
  
  $addassign_SmallString_StringRef(Includes, /*NO_COPY*/HeaderName);
  
  $addassign_SmallString_StringRef(Includes, /*STRINGREF_STR*/"\"\n");
  if (IsExternC && LangOpts.CPlusPlus) {
    $addassign_SmallString_StringRef(Includes, /*STRINGREF_STR*/"}\n");
  }
}


/// \brief Collect the set of header includes needed to construct the given 
/// module and update the TopHeaders file set of the module.
///
/// \param Module The module we're collecting includes from.
///
/// \param Includes Will be augmented with the set of \#includes or \#imports
/// needed to load all of the named headers.
//<editor-fold defaultstate="collapsed" desc="collectModuleHeaderIncludes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 186,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 181,
 FQN="collectModuleHeaderIncludes", NM="_ZL27collectModuleHeaderIncludesRKN5clang11LangOptionsERNS_11FileManagerERNS_9ModuleMapEPNS_6ModuleERN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZL27collectModuleHeaderIncludesRKN5clang11LangOptionsERNS_11FileManagerERNS_9ModuleMapEPNS_6ModuleERN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code collectModuleHeaderIncludes(/*const*/ LangOptions /*&*/ LangOpts, FileManager /*&*/ FileMgr, 
                           ModuleMap /*&*/ ModMap, Module /*P*/ _Module, 
                           SmallString/*&*/ Includes) {
  // Don't collect any headers for unavailable modules.
  if (!_Module.isAvailable()) {
    return new std.error_code();
  }
  
  // Add includes for each of these headers.
  for (HeaderKind HK : new /*const*/ HeaderKind [/*2*/] {Module.HeaderKind.HK_Normal, Module.HeaderKind.HK_Private}) {
    for (Module.Header /*&*/ H : _Module.Headers[HK.getValue()]) {
      _Module.addTopHeader(H.Entry);
      // Use the path as specified in the module map file. We'll look for this
      // file relative to the module build directory (the directory containing
      // the module map file) so this will find the same file that we found
      // while parsing the module map.
      addHeaderInclude(new StringRef(H.NameAsWritten), Includes, LangOpts, _Module.IsExternC);
    }
  }
  {
    Module.Header UmbrellaHeader = null;
    try {
      // Note that Module->PrivateHeaders will not be a TopHeader.
      UmbrellaHeader = _Module.getUmbrellaHeader();
      if (UmbrellaHeader.$bool()) {
        _Module.addTopHeader(UmbrellaHeader.Entry);
        if ((_Module.Parent != null)) {
          // Include the umbrella header for submodules.
          addHeaderInclude(new StringRef(UmbrellaHeader.NameAsWritten), Includes, LangOpts, 
              _Module.IsExternC);
        }
      } else {
        Module.DirectoryName UmbrellaDir = null;
        try {
          UmbrellaDir = _Module.getUmbrellaDir();
          if (UmbrellaDir.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Add all of the headers we find in this subdirectory.
              std.error_code EC/*J*/= new std.error_code();
              SmallString/*128*/ DirNative/*J*/= new SmallString/*128*/(128);
              path.__native(new Twine(UmbrellaDir.Entry.getName()), DirNative);
              
              FileSystem /*&*/ FS = $c$.clean($c$.track(FileMgr.getVirtualFileSystem()).$star());
              for (recursive_directory_iterator Dir/*J*/= new recursive_directory_iterator(FS, new Twine(DirNative), EC), End/*J*/= new recursive_directory_iterator();
                   Dir.$noteq(End) && !EC.$bool(); Dir.increment(EC)) {
                // Check whether this entry has an extension typically associated with 
                // headers.
                if (!new StringSwitchBool(path.extension(Dir.$arrow().getName())).
                    Cases(/*KEEP_STR*/".h", /*KEEP_STR*/".H", /*KEEP_STR*/".hh", /*KEEP_STR*/".hpp", true).
                    Default(false)) {
                  continue;
                }
                
                /*const*/ FileEntry /*P*/ Header = FileMgr.getFile(Dir.$arrow().getName());
                // FIXME: This shouldn't happen unless there is a file system race. Is
                // that worth diagnosing?
                if (!(Header != null)) {
                  continue;
                }
                
                // If this header is marked 'unavailable' in this module, don't include 
                // it.
                if (ModMap.isHeaderUnavailableInModule(Header, _Module)) {
                  continue;
                }
                
                // Compute the relative path from the directory to this file.
                SmallVector<StringRef> Components/*J*/= new SmallVector<StringRef>(16, new StringRef());
                path.reverse_iterator PathIt = path.rbegin(Dir.$arrow().getName());
                for (int I = 0; I != Dir.level() + 1; ++I , PathIt.$preInc())  {
                  Components.push_back(PathIt.$star());
                }
                SmallString/*128*/ RelativeHeader/*J*/= new SmallString/*128*/(new StringRef(UmbrellaDir.NameAsWritten), 128);
                for (std.reverse_iterator<StringRef /*P*/ > It = Components.rbegin(), _End = Components.rend(); $noteq_reverse_iterator$C(It, _End);
                     It.$preInc())  {
                  path.append(RelativeHeader, new Twine(It.$star()));
                }
                
                // Include this header as part of the umbrella directory.
                _Module.addTopHeader(Header);
                addHeaderInclude(RelativeHeader.$StringRef(), Includes, LangOpts, _Module.IsExternC);
              }
              if (EC.$bool()) {
                return EC;
              }
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (UmbrellaDir != null) { UmbrellaDir.$destroy(); }
        }
      }
    } finally {
      if (UmbrellaHeader != null) { UmbrellaHeader.$destroy(); }
    }
  }
  
  // Recurse into submodules.
  for (std.vector.iterator<Module /*P*/ > Sub = _Module.submodule_begin(), 
      SubEnd = _Module.submodule_end();
       $noteq___normal_iterator$C(Sub, SubEnd); Sub.$preInc())  {
    {
      std.error_code Err = collectModuleHeaderIncludes(LangOpts, FileMgr, ModMap, Sub.$star(), Includes);
      if (Err.$bool()) {
        return Err;
      }
    }
  }
  
  return new std.error_code();
}

} // END OF class FrontendActionsStatics
