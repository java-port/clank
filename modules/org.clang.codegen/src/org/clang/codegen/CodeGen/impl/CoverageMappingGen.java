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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;


/// \brief Organizes the per-function state that is used while generating
/// code coverage mapping data.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingGen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 87,
 FQN="clang::CodeGen::CoverageMappingGen", NM="_ZN5clang7CodeGen18CoverageMappingGenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen18CoverageMappingGenE")
//</editor-fold>
public class CoverageMappingGen {
  private final CoverageMappingModuleGen /*&*/ CVM;
  private final SourceManager /*&*/ SM;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  private DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*P*/ CounterMap;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingGen::CoverageMappingGen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 94,
   FQN="clang::CodeGen::CoverageMappingGen::CoverageMappingGen", NM="_ZN5clang7CodeGen18CoverageMappingGenC1ERNS0_24CoverageMappingModuleGenERNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen18CoverageMappingGenC1ERNS0_24CoverageMappingModuleGenERNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public CoverageMappingGen(final CoverageMappingModuleGen /*&*/ CVM, final SourceManager /*&*/ SM, 
      final /*const*/ LangOptions /*&*/ LangOpts) {
    // : CVM(CVM), SM(SM), LangOpts(LangOpts), CounterMap(null) 
    //START JInit
    this./*&*/CVM=/*&*/CVM;
    this./*&*/SM=/*&*/SM;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.CounterMap = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingGen::CoverageMappingGen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 98,
   FQN="clang::CodeGen::CoverageMappingGen::CoverageMappingGen", NM="_ZN5clang7CodeGen18CoverageMappingGenC1ERNS0_24CoverageMappingModuleGenERNS_13SourceManagerERKNS_11LangOptionsEPN4llvm8DenseMapIPKNS_4StmtEjNS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen18CoverageMappingGenC1ERNS0_24CoverageMappingModuleGenERNS_13SourceManagerERKNS_11LangOptionsEPN4llvm8DenseMapIPKNS_4StmtEjNS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_jEEEE")
  //</editor-fold>
  public CoverageMappingGen(final CoverageMappingModuleGen /*&*/ CVM, final SourceManager /*&*/ SM, 
      final /*const*/ LangOptions /*&*/ LangOpts, 
      DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*P*/ CounterMap) {
    // : CVM(CVM), SM(SM), LangOpts(LangOpts), CounterMap(CounterMap) 
    //START JInit
    this./*&*/CVM=/*&*/CVM;
    this./*&*/SM=/*&*/SM;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.CounterMap = CounterMap;
    //END JInit
  }

  
  /// \brief Emit the coverage mapping data which maps the regions of
  /// code to counters that will be used to find the execution
  /// counts for those regions.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingGen::emitCounterMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 1112,
   FQN="clang::CodeGen::CoverageMappingGen::emitCounterMapping", NM="_ZN5clang7CodeGen18CoverageMappingGen18emitCounterMappingEPKNS_4DeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen18CoverageMappingGen18emitCounterMappingEPKNS_4DeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void emitCounterMapping(/*const*/ Decl /*P*/ D, 
                    final raw_ostream /*&*/ OS) {
    CounterCoverageMappingBuilder Walker = null;
    try {
      assert Native.$bool(CounterMap);
      Walker/*J*/= new CounterCoverageMappingBuilder(CVM, /*Deref*/CounterMap, SM, LangOpts);
      Walker.VisitDecl(D);
      Walker.write(OS);
    } finally {
      if (Walker != null) { Walker.$destroy(); }
    }
  }

  
  /// \brief Emit the coverage mapping data for an unused function.
  /// It creates mapping regions with the counter of zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingGen::emitEmptyMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 1120,
   FQN="clang::CodeGen::CoverageMappingGen::emitEmptyMapping", NM="_ZN5clang7CodeGen18CoverageMappingGen16emitEmptyMappingEPKNS_4DeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen18CoverageMappingGen16emitEmptyMappingEPKNS_4DeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void emitEmptyMapping(/*const*/ Decl /*P*/ D, 
                  final raw_ostream /*&*/ OS) {
    EmptyCoverageMappingBuilder Walker = null;
    try {
      Walker/*J*/= new EmptyCoverageMappingBuilder(CVM, SM, LangOpts);
      Walker.VisitDecl(D);
      Walker.write(OS);
    } finally {
      if (Walker != null) { Walker.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "CVM=" + CVM // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", CounterMap=" + "[DenseMapTypeUInt$Stmt]"; // NOI18N
  }
}
