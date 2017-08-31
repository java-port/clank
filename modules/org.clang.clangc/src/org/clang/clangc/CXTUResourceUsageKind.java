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

package org.clang.clangc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.cl.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.basic.target.*;;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.clangc.api.*;
import org.clang.clangc.api.buildsystem.*;
import org.clang.clangc.java.ClangCFunctionPointers.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.IndexGlobals.*;


/**
* \brief Categorizes how memory is being used by a translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="CXTUResourceUsageKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 1484,
 FQN="CXTUResourceUsageKind", NM="_Z21CXTUResourceUsageKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21CXTUResourceUsageKind")
//</editor-fold>
public enum CXTUResourceUsageKind implements Native.ComparableLower {
  CXTUResourceUsage_AST(1),
  CXTUResourceUsage_Identifiers(2),
  CXTUResourceUsage_Selectors(3),
  CXTUResourceUsage_GlobalCompletionResults(4),
  CXTUResourceUsage_SourceManagerContentCache(5),
  CXTUResourceUsage_AST_SideTables(6),
  CXTUResourceUsage_SourceManager_Membuffer_Malloc(7),
  CXTUResourceUsage_SourceManager_Membuffer_MMap(8),
  CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc(9),
  CXTUResourceUsage_ExternalASTSource_Membuffer_MMap(10),
  CXTUResourceUsage_Preprocessor(11),
  CXTUResourceUsage_PreprocessingRecord(12),
  CXTUResourceUsage_SourceManager_DataStructures(13),
  CXTUResourceUsage_Preprocessor_HeaderSearch(14),
  CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN(CXTUResourceUsageKind.CXTUResourceUsage_AST.getValue()),
  CXTUResourceUsage_MEMORY_IN_BYTES_END(CXTUResourceUsageKind.CXTUResourceUsage_Preprocessor_HeaderSearch.getValue()),
  
  CXTUResourceUsage_First(CXTUResourceUsageKind.CXTUResourceUsage_AST.getValue()),
  CXTUResourceUsage_Last(CXTUResourceUsageKind.CXTUResourceUsage_Preprocessor_HeaderSearch.getValue());

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXTUResourceUsageKind valueOf(int val) {
    CXTUResourceUsageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXTUResourceUsageKind[] VALUES;
    private static final CXTUResourceUsageKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXTUResourceUsageKind kind : CXTUResourceUsageKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXTUResourceUsageKind[min < 0 ? (1-min) : 0];
      VALUES = new CXTUResourceUsageKind[max >= 0 ? (1+max) : 0];
      for (CXTUResourceUsageKind kind : CXTUResourceUsageKind.values()) {
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
  private CXTUResourceUsageKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXTUResourceUsageKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXTUResourceUsageKind)obj).value);}
  //</editor-fold>
}
