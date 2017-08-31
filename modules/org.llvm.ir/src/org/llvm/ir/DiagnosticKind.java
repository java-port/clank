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

package org.llvm.ir;

import org.clank.support.*;


/// \brief Defines the different supported kind of a diagnostic.
/// This enum should be extended with a new ID for each added concrete subclass.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticKind">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 49,
 FQN="llvm::DiagnosticKind", NM="_ZN4llvm14DiagnosticKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm14DiagnosticKindE")
//</editor-fold>
public enum DiagnosticKind implements Native.ComparableLower, Native.NativeUIntEnum {
  DK_Bitcode(0),
  DK_InlineAsm(DK_Bitcode.getValue() + 1),
  DK_ResourceLimit(DK_InlineAsm.getValue() + 1),
  DK_StackSize(DK_ResourceLimit.getValue() + 1),
  DK_Linker(DK_StackSize.getValue() + 1),
  DK_DebugMetadataVersion(DK_Linker.getValue() + 1),
  DK_DebugMetadataInvalid(DK_DebugMetadataVersion.getValue() + 1),
  DK_SampleProfile(DK_DebugMetadataInvalid.getValue() + 1),
  DK_OptimizationRemark(DK_SampleProfile.getValue() + 1),
  DK_OptimizationRemarkMissed(DK_OptimizationRemark.getValue() + 1),
  DK_OptimizationRemarkAnalysis(DK_OptimizationRemarkMissed.getValue() + 1),
  DK_OptimizationRemarkAnalysisFPCommute(DK_OptimizationRemarkAnalysis.getValue() + 1),
  DK_OptimizationRemarkAnalysisAliasing(DK_OptimizationRemarkAnalysisFPCommute.getValue() + 1),
  DK_OptimizationFailure(DK_OptimizationRemarkAnalysisAliasing.getValue() + 1),
  DK_FirstRemark(DiagnosticKind.DK_OptimizationRemark.getValue()),
  DK_LastRemark(DiagnosticKind.DK_OptimizationFailure.getValue()),
  DK_MIRParser(DK_LastRemark.getValue() + 1),
  DK_PGOProfile(DK_MIRParser.getValue() + 1),
  DK_Unsupported(DK_PGOProfile.getValue() + 1),
  DK_FirstPluginKind(DK_Unsupported.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DiagnosticKind valueOf(int val) {
    DiagnosticKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DiagnosticKind[] VALUES;
    private static final DiagnosticKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DiagnosticKind kind : DiagnosticKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DiagnosticKind[min < 0 ? (1-min) : 0];
      VALUES = new DiagnosticKind[max >= 0 ? (1+max) : 0];
      for (DiagnosticKind kind : DiagnosticKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private DiagnosticKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  
  @Override public boolean $less(Object obj) {  
    return Unsigned.$less_uint(value, ((DiagnosticKind)obj).value);
  }

  @Override public boolean $lesseq(Object obj) {
    return Unsigned.$lesseq_uint(value, ((DiagnosticKind)obj).value);
  }

  //</editor-fold>
}
