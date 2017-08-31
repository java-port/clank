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

package org.llvm.bitcode.bitc;

import org.clank.support.*;


/// MODULE blocks have a number of optional fields and subblocks.
//<editor-fold defaultstate="collapsed" desc="llvm::bitc::ModuleCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 74,
 FQN="llvm::bitc::ModuleCodes", NM="_ZN4llvm4bitc11ModuleCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc11ModuleCodesE")
//</editor-fold>
public enum ModuleCodes implements Native.ComparableLower {
  MODULE_CODE_VERSION(1), // VERSION:     [version#]
  MODULE_CODE_TRIPLE(2), // TRIPLE:      [strchr x N]
  MODULE_CODE_DATALAYOUT(3), // DATALAYOUT:  [strchr x N]
  MODULE_CODE_ASM(4), // ASM:         [strchr x N]
  MODULE_CODE_SECTIONNAME(5), // SECTIONNAME: [strchr x N]
  
  // FIXME: Remove DEPLIB in 4.0.
  MODULE_CODE_DEPLIB(6), // DEPLIB:      [strchr x N]
  
  // GLOBALVAR: [pointer type, isconst, initid,
  //             linkage, alignment, section, visibility, threadlocal]
  MODULE_CODE_GLOBALVAR(7),
  
  // FUNCTION:  [type, callingconv, isproto, linkage, paramattrs, alignment,
  //             section, visibility, gc, unnamed_addr]
  MODULE_CODE_FUNCTION(8),
  
  // ALIAS: [alias type, aliasee val#, linkage, visibility]
  MODULE_CODE_ALIAS_OLD(9),
  
  // MODULE_CODE_PURGEVALS: [numvals]
  MODULE_CODE_PURGEVALS(10),
  
  MODULE_CODE_GCNAME(11), // GCNAME: [strchr x N]
  MODULE_CODE_COMDAT(12), // COMDAT: [selection_kind, name]
  
  MODULE_CODE_VSTOFFSET(13), // VSTOFFSET: [offset]
  
  // ALIAS: [alias value type, addrspace, aliasee val#, linkage, visibility]
  MODULE_CODE_ALIAS(14),
  
  MODULE_CODE_METADATA_VALUES_UNUSED(15),
  
  // SOURCE_FILENAME: [namechar x N]
  MODULE_CODE_SOURCE_FILENAME(16),
  
  // HASH: [5*i32]
  MODULE_CODE_HASH(17),
  
  // IFUNC: [ifunc value type, addrspace, resolver val#, linkage, visibility]
  MODULE_CODE_IFUNC(18);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ModuleCodes valueOf(int val) {
    ModuleCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ModuleCodes[] VALUES;
    private static final ModuleCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ModuleCodes kind : ModuleCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ModuleCodes[min < 0 ? (1-min) : 0];
      VALUES = new ModuleCodes[max >= 0 ? (1+max) : 0];
      for (ModuleCodes kind : ModuleCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ModuleCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ModuleCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ModuleCodes)obj).value);}
  //</editor-fold>
}
