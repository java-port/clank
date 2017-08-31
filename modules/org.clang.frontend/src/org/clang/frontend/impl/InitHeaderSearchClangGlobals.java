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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type InitHeaderSearchClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE; -static-type=InitHeaderSearchClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class InitHeaderSearchClangGlobals {


/// Apply the header search options to get given HeaderSearch object.
//<editor-fold defaultstate="collapsed" desc="clang::ApplyHeaderSearchOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 645,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 644,
 FQN="clang::ApplyHeaderSearchOptions", NM="_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE")
//</editor-fold>
public static void ApplyHeaderSearchOptions(HeaderSearch /*&*/ HS, 
                        /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                        /*const*/ LangOptions /*&*/ Lang, 
                        /*const*/ Triple /*&*/ Triple) {
  InitHeaderSearch Init = null;
  try {
    Init/*J*/= new InitHeaderSearch(HS, HSOpts.Verbose, new StringRef(HSOpts.Sysroot));
    
    // Add the user defined entries.
    for (/*uint*/int i = 0, e = HSOpts.UserEntries.size(); i != e; ++i) {
      /*const*/ HeaderSearchOptions.Entry /*&*/ E = HSOpts.UserEntries.$at$Const(i);
      if (E.IgnoreSysRoot) {
        Init.AddUnmappedPath(new Twine(E.Path), E.Group, E.IsFramework);
      } else {
        Init.AddPath(new Twine(E.Path), E.Group, E.IsFramework);
      }
    }
    
    Init.AddDefaultIncludePaths(Lang, Triple, HSOpts);
    
    for (/*uint*/int i = 0, e = HSOpts.SystemHeaderPrefixes.size(); i != e; ++i)  {
      Init.AddSystemHeaderPrefix(new StringRef(HSOpts.SystemHeaderPrefixes.$at$Const(i).Prefix), 
          HSOpts.SystemHeaderPrefixes.$at$Const(i).IsSystemHeader);
    }
    if (HSOpts.UseBuiltinIncludes) {
      // Set up the builtin include directory in the module map.
      SmallString/*128*/ P = new SmallString/*128*/(new StringRef(HSOpts.ResourceDir), 128);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      {
        /*const*/ DirectoryEntry /*P*/ Dir = HS.getFileMgr().getDirectory(P.$StringRef());
        if ((Dir != null)) {
          HS.getModuleMap().setBuiltinIncludeDir(Dir);
        }
      }
    }
    
    Init.Realize(Lang);
  } finally {
    if (Init != null) { Init.$destroy(); }
  }
}

} // END OF class InitHeaderSearchClangGlobals
