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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 83,
 FQN="(anonymous namespace)::OnDiskData", NM="_ZN12_GLOBAL__N_110OnDiskDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskDataE")
//</editor-fold>
public class/*struct*/ OnDiskData implements Destructors.ClassWithDestructor {
  /// \brief The file in which the precompiled preamble is stored.
  public std.string PreambleFile;
  
  /// \brief Temporary files that should be removed when the ASTUnit is
  /// destroyed.
  public SmallVector<std.string> TemporaryFiles;
  
  /// \brief Erase temporary files.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData::CleanTemporaryFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 166,
   FQN="(anonymous namespace)::OnDiskData::CleanTemporaryFiles", NM="_ZN12_GLOBAL__N_110OnDiskData19CleanTemporaryFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskData19CleanTemporaryFilesEv")
  //</editor-fold>
  public void CleanTemporaryFiles() {
    for (std.string File : TemporaryFiles)  {
      fs.remove(new Twine(File));
    }
    TemporaryFiles.clear();
  }

  
  /// \brief Erase the preamble file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData::CleanPreambleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 172,
   FQN="(anonymous namespace)::OnDiskData::CleanPreambleFile", NM="_ZN12_GLOBAL__N_110OnDiskData17CleanPreambleFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskData17CleanPreambleFileEv")
  //</editor-fold>
  public void CleanPreambleFile() {
    if (!PreambleFile.empty()) {
      fs.remove(new Twine(PreambleFile));
      PreambleFile.clear();
    }
  }

  
  /// \brief Erase temporary files and the preamble file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData::Cleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 179,
   FQN="(anonymous namespace)::OnDiskData::Cleanup", NM="_ZN12_GLOBAL__N_110OnDiskData7CleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskData7CleanupEv")
  //</editor-fold>
  public void Cleanup() {
    CleanTemporaryFiles();
    CleanPreambleFile();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData::~OnDiskData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 83,
   FQN="(anonymous namespace)::OnDiskData::~OnDiskData", NM="_ZN12_GLOBAL__N_110OnDiskDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskDataD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TemporaryFiles.$destroy();
    PreambleFile.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OnDiskData::OnDiskData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 83,
   FQN="(anonymous namespace)::OnDiskData::OnDiskData", NM="_ZN12_GLOBAL__N_110OnDiskDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_110OnDiskDataC1Ev")
  //</editor-fold>
  public /*inline*/ OnDiskData() {
    // : PreambleFile(), TemporaryFiles() 
    //START JInit
    this.PreambleFile = new std.string();
    this.TemporaryFiles = new SmallVector<std.string>(4, new std.string());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "PreambleFile=" + PreambleFile // NOI18N
              + ", TemporaryFiles=" + TemporaryFiles; // NOI18N
  }
}
