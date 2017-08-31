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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clang.serialization.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4982,
 FQN="(anonymous namespace)::PPEntityComp", NM="_ZN12_GLOBAL__N_112PPEntityCompE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompE")
//</editor-fold>
public class/*struct*/ PPEntityComp implements Native.ComparatorLower<SourceLocation,PPEntityOffset> {
  public final /*const*/ ASTReader /*&*/ Reader;
  public final ModuleFile /*&*/ M;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::PPEntityComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4986,
   FQN="(anonymous namespace)::PPEntityComp::PPEntityComp", NM="_ZN12_GLOBAL__N_112PPEntityCompC1ERKN5clang9ASTReaderERNS1_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompC1ERKN5clang9ASTReaderERNS1_13serialization10ModuleFileE")
  //</editor-fold>
  public PPEntityComp(final /*const*/ ASTReader /*&*/ Reader, final ModuleFile /*&*/ M) {
    // : Reader(Reader), M(M) 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this./*&*/M=/*&*/M;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4988,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclERKN5clang13serialization14PPEntityOffsetES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclERKN5clang13serialization14PPEntityOffsetES5_")
  //</editor-fold>
  public boolean $call(final /*const*/ PPEntityOffset /*&*/ L, final /*const*/ PPEntityOffset /*&*/ R) /*const*/ {
    SourceLocation LHS = getLoc(L);
    SourceLocation RHS = getLoc(R);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4994,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclERKN5clang13serialization14PPEntityOffsetENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclERKN5clang13serialization14PPEntityOffsetENS1_14SourceLocationE")
  //</editor-fold>
  public boolean $call(final /*const*/ PPEntityOffset /*&*/ L, SourceLocation RHS) /*const*/ {
    SourceLocation LHS = getLoc(L);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4999,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclEN5clang14SourceLocationERKNS1_13serialization14PPEntityOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclEN5clang14SourceLocationERKNS1_13serialization14PPEntityOffsetE")
  //</editor-fold>
  public boolean $call(SourceLocation LHS, final /*const*/ PPEntityOffset /*&*/ R) /*const*/ {
    SourceLocation RHS = getLoc(R);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5004,
   FQN="(anonymous namespace)::PPEntityComp::getLoc", NM="_ZNK12_GLOBAL__N_112PPEntityComp6getLocERKN5clang13serialization14PPEntityOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityComp6getLocERKN5clang13serialization14PPEntityOffsetE")
  //</editor-fold>
  public SourceLocation getLoc(final /*const*/ PPEntityOffset /*&*/ PPE) /*const*/ {
    return Reader.TranslateSourceLocation(M, PPE.getBegin());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::PPEntityComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4982,
   FQN="(anonymous namespace)::PPEntityComp::PPEntityComp", NM="_ZN12_GLOBAL__N_112PPEntityCompC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PPEntityComp(final /*const*/ PPEntityComp /*&*/ $Prm0) {
    // : Reader(.Reader), M(.M) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/M=/*&*/$Prm0.M;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPEntityComp::PPEntityComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4982,
   FQN="(anonymous namespace)::PPEntityComp::PPEntityComp", NM="_ZN12_GLOBAL__N_112PPEntityCompC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompC1EOS0_")
  //</editor-fold>
  public /*inline*/ PPEntityComp(JD$Move _dparam, final PPEntityComp /*&&*/$Prm0) {
    // : Reader(static_cast<PPEntityComp &&>().Reader), M(static_cast<PPEntityComp &&>().M) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/M=/*&*/$Prm0.M;
    //END JInit
  }

  @Override
  public boolean $less(SourceLocation L, PPEntityOffset R) {
    return $call(L, R);
  }

  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", M=" + M; // NOI18N
  }
}
