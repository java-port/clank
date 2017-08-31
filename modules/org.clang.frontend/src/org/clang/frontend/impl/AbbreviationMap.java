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
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbbreviationMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 35,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 34,
 FQN="(anonymous namespace)::AbbreviationMap", NM="_ZN12_GLOBAL__N_115AbbreviationMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_115AbbreviationMapE")
//</editor-fold>
public class AbbreviationMap implements Destructors.ClassWithDestructor {
  private DenseMapUIntUInt Abbrevs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbbreviationMap::AbbreviationMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 38,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 37,
   FQN="(anonymous namespace)::AbbreviationMap::AbbreviationMap", NM="_ZN12_GLOBAL__N_115AbbreviationMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_115AbbreviationMapC1Ev")
  //</editor-fold>
  public AbbreviationMap() {
    // : Abbrevs() 
    //START JInit
    this.Abbrevs = new DenseMapUIntUInt(DenseMapInfoUInt.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbbreviationMap::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 40,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 39,
   FQN="(anonymous namespace)::AbbreviationMap::set", NM="_ZN12_GLOBAL__N_115AbbreviationMap3setEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_115AbbreviationMap3setEjj")
  //</editor-fold>
  public void set(/*uint*/int recordID, /*uint*/int abbrevID) {
    assert (Abbrevs.find(recordID).$eq(/*NO_ITER_COPY*/Abbrevs.end())) : "Abbreviation already set.";
    Abbrevs.$set(recordID, abbrevID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbbreviationMap::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 46,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 45,
   FQN="(anonymous namespace)::AbbreviationMap::get", NM="_ZN12_GLOBAL__N_115AbbreviationMap3getEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_115AbbreviationMap3getEj")
  //</editor-fold>
  public /*uint*/int get(/*uint*/int recordID) {
    assert (Abbrevs.find(recordID).$noteq(/*NO_ITER_COPY*/Abbrevs.end())) : "Abbreviation not set.";
    return Abbrevs.$at(recordID);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AbbreviationMap::~AbbreviationMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 34,
   FQN="(anonymous namespace)::AbbreviationMap::~AbbreviationMap", NM="_ZN12_GLOBAL__N_115AbbreviationMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_115AbbreviationMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Abbrevs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Abbrevs=" + Abbrevs; // NOI18N
  }
}
