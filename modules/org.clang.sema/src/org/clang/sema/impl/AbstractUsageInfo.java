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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbstractUsageInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4484,
 FQN="(anonymous namespace)::AbstractUsageInfo", NM="_ZN12_GLOBAL__N_117AbstractUsageInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117AbstractUsageInfoE")
//</editor-fold>
public class/*struct*/ AbstractUsageInfo {
  public final Sema /*&*/ S;
  public CXXRecordDecl /*P*/ Record;
  public CanQual<Type> AbstractType;
  public boolean Invalid;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbstractUsageInfo::AbstractUsageInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4490,
   FQN="(anonymous namespace)::AbstractUsageInfo::AbstractUsageInfo", NM="_ZN12_GLOBAL__N_117AbstractUsageInfoC1ERN5clang4SemaEPNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117AbstractUsageInfoC1ERN5clang4SemaEPNS1_13CXXRecordDeclE")
  //</editor-fold>
  public AbstractUsageInfo(final Sema /*&*/ S, CXXRecordDecl /*P*/ Record) {
    // : S(S), Record(Record), AbstractType(S.Context.getCanonicalType(S.Context.getTypeDeclType(Record))), Invalid(false) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Record = Record;
    this.AbstractType = S.Context.getCanonicalType(S.Context.getTypeDeclType(Record));
    this.Invalid = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbstractUsageInfo::DiagnoseAbstractType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4496,
   FQN="(anonymous namespace)::AbstractUsageInfo::DiagnoseAbstractType", NM="_ZN12_GLOBAL__N_117AbstractUsageInfo20DiagnoseAbstractTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117AbstractUsageInfo20DiagnoseAbstractTypeEv")
  //</editor-fold>
  public void DiagnoseAbstractType() {
    if (Invalid) {
      return;
    }
    S.DiagnoseAbstractType(Record);
    Invalid = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbstractUsageInfo::CheckType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4592,
   FQN="(anonymous namespace)::AbstractUsageInfo::CheckType", NM="_ZN12_GLOBAL__N_117AbstractUsageInfo9CheckTypeEPKN5clang9NamedDeclENS1_7TypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117AbstractUsageInfo9CheckTypeEPKN5clang9NamedDeclENS1_7TypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void CheckType(/*const*/ NamedDecl /*P*/ D, TypeLoc TL, 
           Sema.AbstractDiagSelID Sel) {
    new CheckAbstractUsage(/*Deref*/this, D).Visit(new TypeLoc(TL), Sel);
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Record=" + Record // NOI18N
              + ", AbstractType=" + AbstractType // NOI18N
              + ", Invalid=" + Invalid; // NOI18N
  }
}
