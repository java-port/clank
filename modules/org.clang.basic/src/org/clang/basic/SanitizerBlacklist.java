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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SanitizerBlacklist.h", line = 26,
 FQN="clang::SanitizerBlacklist", NM="_ZN5clang18SanitizerBlacklistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18SanitizerBlacklistE")
//</editor-fold>
public class SanitizerBlacklist implements Destructors.ClassWithDestructor {
  private std.unique_ptr<SpecialCaseList> SCL;
  private SourceManager /*&*/ SM;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::SanitizerBlacklist">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 18,
   FQN="clang::SanitizerBlacklist::SanitizerBlacklist", NM="_ZN5clang18SanitizerBlacklistC1ERKSt6vectorISsSaISsEERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZN5clang18SanitizerBlacklistC1ERKSt6vectorISsSaISsEERNS_13SourceManagerE")
  //</editor-fold>
  public SanitizerBlacklist(/*const*/std.vectorString/*&*/ BlacklistPaths, SourceManager /*&*/ SM) {
    /* : SCL(SpecialCaseList::createOrDie(BlacklistPaths)), SM(SM)*/ 
    //START JInit
    this.SCL = SpecialCaseList.createOrDie(BlacklistPaths);
    this./*&*/SM=/*&*/SM;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::isBlacklistedGlobal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 22,
   FQN="clang::SanitizerBlacklist::isBlacklistedGlobal", NM="_ZNK5clang18SanitizerBlacklist19isBlacklistedGlobalEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZNK5clang18SanitizerBlacklist19isBlacklistedGlobalEN4llvm9StringRefES2_")
  //</editor-fold>
  public boolean isBlacklistedGlobal(StringRef GlobalName) /*const*/ {
    return isBlacklistedGlobal(GlobalName, 
                     new StringRef());
  }
  public boolean isBlacklistedGlobal(StringRef GlobalName, 
                     StringRef Category/*= StringRef()*/) /*const*/ {
    return SCL.$arrow().inSection(/*STRINGREF_STR*/"global", /*NO_COPY*/GlobalName, /*NO_COPY*/Category);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::isBlacklistedType">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 27,
   FQN="clang::SanitizerBlacklist::isBlacklistedType", NM="_ZNK5clang18SanitizerBlacklist17isBlacklistedTypeEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZNK5clang18SanitizerBlacklist17isBlacklistedTypeEN4llvm9StringRefES2_")
  //</editor-fold>
  public boolean isBlacklistedType(StringRef MangledTypeName) /*const*/ {
    return isBlacklistedType(MangledTypeName, 
                   new StringRef());
  }
  public boolean isBlacklistedType(StringRef MangledTypeName, 
                   StringRef Category/*= StringRef()*/) /*const*/ {
    return SCL.$arrow().inSection(/*STRINGREF_STR*/"type", /*NO_COPY*/MangledTypeName, /*NO_COPY*/Category);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::isBlacklistedFunction">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 32,
   FQN="clang::SanitizerBlacklist::isBlacklistedFunction", NM="_ZNK5clang18SanitizerBlacklist21isBlacklistedFunctionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZNK5clang18SanitizerBlacklist21isBlacklistedFunctionEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isBlacklistedFunction(StringRef FunctionName) /*const*/ {
    return SCL.$arrow().inSection(/*STRINGREF_STR*/"fun", /*NO_COPY*/FunctionName);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::isBlacklistedFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 36,
   FQN="clang::SanitizerBlacklist::isBlacklistedFile", NM="_ZNK5clang18SanitizerBlacklist17isBlacklistedFileEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZNK5clang18SanitizerBlacklist17isBlacklistedFileEN4llvm9StringRefES2_")
  //</editor-fold>
  public boolean isBlacklistedFile(StringRef FileName) /*const*/ {
    return isBlacklistedFile(FileName, 
                   new StringRef());
  }
  public boolean isBlacklistedFile(StringRef FileName, 
                   StringRef Category/*= StringRef()*/) /*const*/ {
    return SCL.$arrow().inSection(/*STRINGREF_STR*/"src", /*NO_COPY*/FileName, /*NO_COPY*/Category);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::isBlacklistedLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp", line = 41,
   FQN="clang::SanitizerBlacklist::isBlacklistedLocation", NM="_ZNK5clang18SanitizerBlacklist21isBlacklistedLocationENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SanitizerBlacklist.cpp -nm=_ZNK5clang18SanitizerBlacklist21isBlacklistedLocationENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isBlacklistedLocation(SourceLocation Loc) /*const*/ {
    return isBlacklistedLocation(Loc, 
                       new StringRef());
  }
  public boolean isBlacklistedLocation(SourceLocation Loc, 
                       StringRef Category/*= StringRef()*/) /*const*/ {
    return Loc.isValid()
       && isBlacklistedFile(SM.getFilename(SM.getFileLoc(/*NO_COPY*/Loc)), new StringRef(Category));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SanitizerBlacklist::~SanitizerBlacklist">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SanitizerBlacklist.h", line = 26,
   FQN="clang::SanitizerBlacklist::~SanitizerBlacklist", NM="_ZN5clang18SanitizerBlacklistD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18SanitizerBlacklistD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SCL.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "SCL=" + SCL // NOI18N
              + ", SM=" + SM; // NOI18N
  }
}
