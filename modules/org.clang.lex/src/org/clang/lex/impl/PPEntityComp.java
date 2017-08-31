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

import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.SourceRange;
import org.clang.lex.PreprocessedEntity;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clang.basic.java.BasicMemberPointers;

/*template <SourceLocation (SourceRange::*)() __attribute__((cdecl)) const getRangeLoc> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 170,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 172,
 FQN="(anonymous namespace)::PPEntityComp", NM="_ZN12_GLOBAL__N_112PPEntityCompE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompE")
//</editor-fold>
public class/*struct*/ PPEntityComp/*<SourceLocation (SourceRange::*)() __attribute__((cdecl)) const getRangeLoc>*/ implements Native.ComparatorLower {
  public /*const*/SourceManager /*&*/ SM;
  private final BasicMemberPointers.SourceRange$GetSourceLocation getRangeLoc;
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp::PPEntityComp<getRangeLoc>">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 176,
   FQN="(anonymous namespace)::PPEntityComp::PPEntityComp<getRangeLoc>", NM="_ZN12_GLOBAL__N_112PPEntityCompC1ERKN5clang13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN12_GLOBAL__N_112PPEntityCompC1ERKN5clang13SourceManagerE")
  //</editor-fold>
  public /*explicit*/ PPEntityComp(/*const*/SourceManager /*&*/ SM, BasicMemberPointers.SourceRange$GetSourceLocation getRangeLoc) {
    /* : SM(SM)*/ 
    //START JInit
    this.SM = SM;
    this.getRangeLoc = getRangeLoc;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 178,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclEPN5clang18PreprocessedEntityES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclEPN5clang18PreprocessedEntityES3_")
  //</editor-fold>
  public boolean $call(PreprocessedEntity /*P*/ L, PreprocessedEntity /*P*/ R) /*const*/ {
    SourceLocation LHS = getLoc(L);
    SourceLocation RHS = getLoc(R);
    return SM.isBeforeInTranslationUnit(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 184,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclEPN5clang18PreprocessedEntityENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclEPN5clang18PreprocessedEntityENS1_14SourceLocationE")
  //</editor-fold>
  public boolean $call(PreprocessedEntity /*P*/ L, SourceLocation RHS) /*const*/ {
    SourceLocation LHS = getLoc(L);
    return SM.isBeforeInTranslationUnit(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 187,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 189,
   FQN="(anonymous namespace)::PPEntityComp::operator()", NM="_ZNK12_GLOBAL__N_112PPEntityCompclEN5clang14SourceLocationEPNS1_18PreprocessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityCompclEN5clang14SourceLocationEPNS1_18PreprocessedEntityE")
  //</editor-fold>
  public boolean $call(SourceLocation LHS, PreprocessedEntity /*P*/ R) /*const*/ {
    SourceLocation RHS = getLoc(R);
    return SM.isBeforeInTranslationUnit(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPEntityComp::getLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 192,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 194,
   FQN="(anonymous namespace)::PPEntityComp::getLoc", NM="_ZNK12_GLOBAL__N_112PPEntityComp6getLocEPN5clang18PreprocessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK12_GLOBAL__N_112PPEntityComp6getLocEPN5clang18PreprocessedEntityE")
  //</editor-fold>
  public SourceLocation getLoc(PreprocessedEntity /*P*/ PPE) /*const*/ {
    SourceRange Range = PPE.getSourceRange();
    return getRangeLoc.$call(Range);
  }

    @Override
    public boolean $less(Object LHS, Object RHS) {
      if (LHS instanceof PreprocessedEntity) {
        if (RHS instanceof PreprocessedEntity) {
          return $call((PreprocessedEntity)LHS, (PreprocessedEntity)RHS);
        }
        return $call((PreprocessedEntity)LHS, (SourceLocation)RHS);
      } else {
        return $call((SourceLocation)LHS, (PreprocessedEntity)RHS);
      }
    }

}