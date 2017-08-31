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

//<editor-fold defaultstate="collapsed" desc="llvm::bitc::AttributeKindCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 472,
 FQN="llvm::bitc::AttributeKindCodes", NM="_ZN4llvm4bitc18AttributeKindCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc18AttributeKindCodesE")
//</editor-fold>
public enum AttributeKindCodes implements Native.ComparableLower {
  // = 0 is unused
  ATTR_KIND_ALIGNMENT(1),
  ATTR_KIND_ALWAYS_INLINE(2),
  ATTR_KIND_BY_VAL(3),
  ATTR_KIND_INLINE_HINT(4),
  ATTR_KIND_IN_REG(5),
  ATTR_KIND_MIN_SIZE(6),
  ATTR_KIND_NAKED(7),
  ATTR_KIND_NEST(8),
  ATTR_KIND_NO_ALIAS(9),
  ATTR_KIND_NO_BUILTIN(10),
  ATTR_KIND_NO_CAPTURE(11),
  ATTR_KIND_NO_DUPLICATE(12),
  ATTR_KIND_NO_IMPLICIT_FLOAT(13),
  ATTR_KIND_NO_INLINE(14),
  ATTR_KIND_NON_LAZY_BIND(15),
  ATTR_KIND_NO_RED_ZONE(16),
  ATTR_KIND_NO_RETURN(17),
  ATTR_KIND_NO_UNWIND(18),
  ATTR_KIND_OPTIMIZE_FOR_SIZE(19),
  ATTR_KIND_READ_NONE(20),
  ATTR_KIND_READ_ONLY(21),
  ATTR_KIND_RETURNED(22),
  ATTR_KIND_RETURNS_TWICE(23),
  ATTR_KIND_S_EXT(24),
  ATTR_KIND_STACK_ALIGNMENT(25),
  ATTR_KIND_STACK_PROTECT(26),
  ATTR_KIND_STACK_PROTECT_REQ(27),
  ATTR_KIND_STACK_PROTECT_STRONG(28),
  ATTR_KIND_STRUCT_RET(29),
  ATTR_KIND_SANITIZE_ADDRESS(30),
  ATTR_KIND_SANITIZE_THREAD(31),
  ATTR_KIND_SANITIZE_MEMORY(32),
  ATTR_KIND_UW_TABLE(33),
  ATTR_KIND_Z_EXT(34),
  ATTR_KIND_BUILTIN(35),
  ATTR_KIND_COLD(36),
  ATTR_KIND_OPTIMIZE_NONE(37),
  ATTR_KIND_IN_ALLOCA(38),
  ATTR_KIND_NON_NULL(39),
  ATTR_KIND_JUMP_TABLE(40),
  ATTR_KIND_DEREFERENCEABLE(41),
  ATTR_KIND_DEREFERENCEABLE_OR_NULL(42),
  ATTR_KIND_CONVERGENT(43),
  ATTR_KIND_SAFESTACK(44),
  ATTR_KIND_ARGMEMONLY(45),
  ATTR_KIND_SWIFT_SELF(46),
  ATTR_KIND_SWIFT_ERROR(47),
  ATTR_KIND_NO_RECURSE(48),
  ATTR_KIND_INACCESSIBLEMEM_ONLY(49),
  ATTR_KIND_INACCESSIBLEMEM_OR_ARGMEMONLY(50),
  ATTR_KIND_ALLOC_SIZE(51),
  ATTR_KIND_WRITEONLY(52);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AttributeKindCodes valueOf(int val) {
    AttributeKindCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AttributeKindCodes[] VALUES;
    private static final AttributeKindCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AttributeKindCodes kind : AttributeKindCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AttributeKindCodes[min < 0 ? (1-min) : 0];
      VALUES = new AttributeKindCodes[max >= 0 ? (1+max) : 0];
      for (AttributeKindCodes kind : AttributeKindCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private AttributeKindCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AttributeKindCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AttributeKindCodes)obj).value);}
  //</editor-fold>
}
