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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Stores additional source code information like skipped ranges which
/// is required by the coverage mapping generator and is obtained from
/// the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::CoverageSourceInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 38,
 FQN="clang::CoverageSourceInfo", NM="_ZN5clang18CoverageSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang18CoverageSourceInfoE")
//</editor-fold>
public class CoverageSourceInfo extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private std.vector<SourceRange> SkippedRanges;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CoverageSourceInfo::getSkippedRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 41,
   FQN="clang::CoverageSourceInfo::getSkippedRanges", NM="_ZNK5clang18CoverageSourceInfo16getSkippedRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang18CoverageSourceInfo16getSkippedRangesEv")
  //</editor-fold>
  public ArrayRef<SourceRange> getSkippedRanges() /*const*/ {
    return new ArrayRef<SourceRange>(SkippedRanges, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoverageSourceInfo::SourceRangeSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 31,
   FQN="clang::CoverageSourceInfo::SourceRangeSkipped", NM="_ZN5clang18CoverageSourceInfo18SourceRangeSkippedENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang18CoverageSourceInfo18SourceRangeSkippedENS_11SourceRangeE")
  //</editor-fold>
  @Override public void SourceRangeSkipped(SourceRange Range)/* override*/ {
    SkippedRanges.push_back_T$C$R(Range);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CoverageSourceInfo::~CoverageSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 38,
   FQN="clang::CoverageSourceInfo::~CoverageSourceInfo", NM="_ZN5clang18CoverageSourceInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang18CoverageSourceInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    SkippedRanges.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CoverageSourceInfo::CoverageSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 38,
   FQN="clang::CoverageSourceInfo::CoverageSourceInfo", NM="_ZN5clang18CoverageSourceInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang18CoverageSourceInfoC1Ev")
  //</editor-fold>
  public /*inline*/ CoverageSourceInfo() {
    // : PPCallbacks(), SkippedRanges() 
    //START JInit
    super();
    this.SkippedRanges = new std.vector<SourceRange>(new SourceRange());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SkippedRanges=" + SkippedRanges // NOI18N
              + super.toString(); // NOI18N
  }
}
