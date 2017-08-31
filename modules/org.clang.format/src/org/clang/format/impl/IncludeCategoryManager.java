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

package org.clang.format.impl;

import org.clank.support.*;
import static org.clank.java.io.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.format.*;
import org.llvm.support.sys.path;


// This class manages priorities of #include categories and calculates
// priorities for headers.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeCategoryManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1268,
 FQN="clang::format::(anonymous namespace)::IncludeCategoryManager", NM="_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerE")
//</editor-fold>
public class IncludeCategoryManager implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeCategoryManager::IncludeCategoryManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1270,
   FQN="clang::format::(anonymous namespace)::IncludeCategoryManager::IncludeCategoryManager", NM="_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerC1ERKNS0_11FormatStyleEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerC1ERKNS0_11FormatStyleEN4llvm9StringRefE")
  //</editor-fold>
  public IncludeCategoryManager(final /*const*/ FormatStyle /*&*/ Style, StringRef FileName) {
    // : Style(Style), FileName(FileName), FileStem(), CategoryRegexs() 
    //START JInit
    this./*&*/Style=/*&*/Style;
    this.FileName = new StringRef(FileName);
    this.FileStem = new StringRef();
    this.CategoryRegexs = new SmallVector<Regex>(4, null);//new Regex());
    //END JInit
    FileStem.$assignMove(path.stem(/*NO_COPY*/FileName));
    for (final /*const*/ FormatStyle.IncludeCategory /*&*/ Category : Style.IncludeCategories)  {
      CategoryRegexs.emplace_back(new Regex(new StringRef(Category.Regex)));
    }
    IsMainFile = FileName.endswith(/*STRINGREF_STR*/".c") || FileName.endswith(/*STRINGREF_STR*/".cc")
       || FileName.endswith(/*STRINGREF_STR*/".cpp") || FileName.endswith(/*STRINGREF_STR*/".c++")
       || FileName.endswith(/*STRINGREF_STR*/".cxx") || FileName.endswith(/*STRINGREF_STR*/".m")
       || FileName.endswith(/*STRINGREF_STR*/".mm");
  }

  
  // Returns the priority of the category which \p IncludeName belongs to.
  // If \p CheckMainHeader is true and \p IncludeName is a main header, returns
  // 0. Otherwise, returns the priority of the matching category or INT_MAX.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeCategoryManager::getIncludePriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1284,
   FQN="clang::format::(anonymous namespace)::IncludeCategoryManager::getIncludePriority", NM="_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManager18getIncludePriorityEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManager18getIncludePriorityEN4llvm9StringRefEb")
  //</editor-fold>
  public int getIncludePriority(StringRef IncludeName, boolean CheckMainHeader) {
    int Ret = INT_MAX;
    for (/*uint*/int i = 0, e = CategoryRegexs.size(); i != e; ++i)  {
      if (CategoryRegexs.$at(i).find(/*match(*//*NO_COPY*/IncludeName)) {
        Ret = Style.IncludeCategories.$at$Const(i).Priority;
        break;
      }
    }
    if (CheckMainHeader && IsMainFile && Ret > 0 && isMainHeader(new StringRef(IncludeName))) {
      Ret = 0;
    }
    return Ret;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeCategoryManager::isMainHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1297,
   FQN="clang::format::(anonymous namespace)::IncludeCategoryManager::isMainHeader", NM="_ZNK5clang6format12_GLOBAL__N_122IncludeCategoryManager12isMainHeaderEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZNK5clang6format12_GLOBAL__N_122IncludeCategoryManager12isMainHeaderEN4llvm9StringRefE")
  //</editor-fold>
  private boolean isMainHeader(StringRef IncludeName) /*const*/ {
    if (!IncludeName.startswith(/*STRINGREF_STR*/"\"")) {
      return false;
    }
    StringRef HeaderStem = path.stem(IncludeName.drop_front(1).drop_back(1));
    if (FileStem.startswith(/*NO_COPY*/HeaderStem)) {
      Regex MainIncludeRegex = null;
      try {
        MainIncludeRegex/*J*/= new Regex(new StringRef(($add_Twine$C(new Twine(HeaderStem), new Twine(Style.IncludeIsMainRegex))).str()));
        if (MainIncludeRegex.find(/*match(*//*NO_COPY*/FileStem)) {
          return true;
        }
      } finally {
        if (MainIncludeRegex != null) { MainIncludeRegex.$destroy(); }
      }
    }
    return false;
  }

  
  private final /*const*/ FormatStyle /*&*/ Style;
  private boolean IsMainFile;
  private StringRef FileName;
  private StringRef FileStem;
  private SmallVector<Regex> CategoryRegexs;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::IncludeCategoryManager::~IncludeCategoryManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1268,
   FQN="clang::format::(anonymous namespace)::IncludeCategoryManager::~IncludeCategoryManager", NM="_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_122IncludeCategoryManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CategoryRegexs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", IsMainFile=" + IsMainFile // NOI18N
              + ", FileName=" + FileName // NOI18N
              + ", FileStem=" + FileStem // NOI18N
              + ", CategoryRegexs=" + CategoryRegexs; // NOI18N
  }
}
