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
package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.cl.*;
import org.llvm.ir.java.*;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.DiagnosticInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L11PassRemarksB5cxx11E;_ZN12_GLOBAL__N_1L17PassRemarksMissedB5cxx11E;_ZN12_GLOBAL__N_1L17PassRemarksOptLocE;_ZN12_GLOBAL__N_1L19PassRemarksAnalysisB5cxx11E;_ZN12_GLOBAL__N_1L23PassRemarksMissedOptLocE;_ZN12_GLOBAL__N_1L25PassRemarksAnalysisOptLocE; -static-type=DiagnosticInfoStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class DiagnosticInfoStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarksOptLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 55,
 FQN="(anonymous namespace)::PassRemarksOptLoc", NM="_ZN12_GLOBAL__N_1L17PassRemarksOptLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L17PassRemarksOptLocE")
//</editor-fold>
public static PassRemarksOpt PassRemarksOptLoc/*J*/= new PassRemarksOpt();
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final type$ref<PassRemarksOpt> PassRemarksOptLoc$Ref/*J*/= new type$ref<PassRemarksOpt>(){
  @Override
  public PassRemarksOpt $deref() {
    return PassRemarksOptLoc;
  }

  @Override
  public PassRemarksOpt $set(PassRemarksOpt value) {
    PassRemarksOptLoc = value;
    return PassRemarksOptLoc;
  }
};//create_type$ref(PassRemarksOptLoc);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarksMissedOptLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 56,
 FQN="(anonymous namespace)::PassRemarksMissedOptLoc", NM="_ZN12_GLOBAL__N_1L23PassRemarksMissedOptLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L23PassRemarksMissedOptLocE")
//</editor-fold>
public static PassRemarksOpt PassRemarksMissedOptLoc/*J*/= new PassRemarksOpt();
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final type$ref<PassRemarksOpt> PassRemarksMissedOptLoc$Ref/*J*/= new type$ref<PassRemarksOpt>(){
  @Override
  public PassRemarksOpt $deref() {
    return PassRemarksMissedOptLoc;
  }

  @Override
  public PassRemarksOpt $set(PassRemarksOpt value) {
    PassRemarksMissedOptLoc = value;
    return PassRemarksMissedOptLoc;
  }
};//create_type$ref(PassRemarksMissedOptLoc);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarksAnalysisOptLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 57,
 FQN="(anonymous namespace)::PassRemarksAnalysisOptLoc", NM="_ZN12_GLOBAL__N_1L25PassRemarksAnalysisOptLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L25PassRemarksAnalysisOptLocE")
//</editor-fold>
public static PassRemarksOpt PassRemarksAnalysisOptLoc/*J*/= new PassRemarksOpt();
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final type$ref<PassRemarksOpt> PassRemarksAnalysisOptLoc$Ref/*J*/= new type$ref<PassRemarksOpt>(){
  @Override
  public PassRemarksOpt $deref() {
    return PassRemarksAnalysisOptLoc;
  }

  @Override
  public PassRemarksOpt $set(PassRemarksOpt value) {
    PassRemarksAnalysisOptLoc = value;
    return PassRemarksAnalysisOptLoc;
  }
};//create_type$ref(PassRemarksAnalysisOptLoc);

// -pass-remarks
//    Command line flag to enable emitOptimizationRemark()
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarks">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 61,
 FQN="(anonymous namespace)::PassRemarks", NM="_ZN12_GLOBAL__N_1L11PassRemarksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L11PassRemarksE")
//</editor-fold>
public static optPassRemarksOpt PassRemarks/*J*/= new optPassRemarksOpt(true, $("pass-remarks"), new value_desc($("pattern")), 
    new desc($("Enable optimization remarks from passes whose name match the given regular expression")), 
    OptionHidden.Hidden, ClGlobals.location(PassRemarksOptLoc$Ref), ValueExpected.ValueRequired, 
    NumOccurrencesFlag.ZeroOrMore);

// -pass-remarks-missed
//    Command line flag to enable emitOptimizationRemarkMissed()
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarksMissed">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 70,
 FQN="(anonymous namespace)::PassRemarksMissed", NM="_ZN12_GLOBAL__N_1L17PassRemarksMissedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L17PassRemarksMissedE")
//</editor-fold>
public static optPassRemarksOpt PassRemarksMissed/*J*/= new optPassRemarksOpt(true, $("pass-remarks-missed"), new value_desc($("pattern")), 
    new desc($("Enable missed optimization remarks from passes whose name match the given regular expression")), 
    OptionHidden.Hidden, ClGlobals.location(PassRemarksMissedOptLoc$Ref), ValueExpected.ValueRequired, 
    NumOccurrencesFlag.ZeroOrMore);

// -pass-remarks-analysis
//    Command line flag to enable emitOptimizationRemarkAnalysis()
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassRemarksAnalysis">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 79,
 FQN="(anonymous namespace)::PassRemarksAnalysis", NM="_ZN12_GLOBAL__N_1L19PassRemarksAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN12_GLOBAL__N_1L19PassRemarksAnalysisE")
//</editor-fold>
public static optPassRemarksOpt PassRemarksAnalysis/*J*/= new optPassRemarksOpt(true, $("pass-remarks-analysis"), new value_desc($("pattern")), 
    new desc($("Enable optimization analysis remarks from passes whose name match the given regular expression")), 
    OptionHidden.Hidden, ClGlobals.location(PassRemarksAnalysisOptLoc$Ref), ValueExpected.ValueRequired, 
    NumOccurrencesFlag.ZeroOrMore);
} // END OF class DiagnosticInfoStatics
