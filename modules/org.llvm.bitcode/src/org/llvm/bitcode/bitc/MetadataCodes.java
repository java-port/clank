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

//<editor-fold defaultstate="collapsed" desc="llvm::bitc::MetadataCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 224,
 FQN="llvm::bitc::MetadataCodes", NM="_ZN4llvm4bitc13MetadataCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc13MetadataCodesE")
//</editor-fold>
public enum MetadataCodes implements Native.ComparableLower {
  METADATA_STRING_OLD(1), // MDSTRING:      [values]
  METADATA_VALUE(2), // VALUE:         [type num, value num]
  METADATA_NODE(3), // NODE:          [n x md num]
  METADATA_NAME(4), // STRING:        [values]
  METADATA_DISTINCT_NODE(5), // DISTINCT_NODE: [n x md num]
  METADATA_KIND(6), // [n x [id, name]]
  METADATA_LOCATION(7), // [distinct, line, col, scope, inlined-at?]
  METADATA_OLD_NODE(8), // OLD_NODE:      [n x (type num, value num)]
  METADATA_OLD_FN_NODE(9), // OLD_FN_NODE:   [n x (type num, value num)]
  METADATA_NAMED_NODE(10), // NAMED_NODE:    [n x mdnodes]
  METADATA_ATTACHMENT(11), // [m x [value, [n x [id, mdnode]]]
  METADATA_GENERIC_DEBUG(12), // [distinct, tag, vers, header, n x md num]
  METADATA_SUBRANGE(13), // [distinct, count, lo]
  METADATA_ENUMERATOR(14), // [distinct, value, name]
  METADATA_BASIC_TYPE(15), // [distinct, tag, name, size, align, enc]
  METADATA_FILE(16), // [distinct, filename, directory]
  METADATA_DERIVED_TYPE(17), // [distinct, ...]
  METADATA_COMPOSITE_TYPE(18), // [distinct, ...]
  METADATA_SUBROUTINE_TYPE(19), // [distinct, flags, types, cc]
  METADATA_COMPILE_UNIT(20), // [distinct, ...]
  METADATA_SUBPROGRAM(21), // [distinct, ...]
  METADATA_LEXICAL_BLOCK(22), // [distinct, scope, file, line, column]
  METADATA_LEXICAL_BLOCK_FILE(23), //[distinct, scope, file, discriminator]
  METADATA_NAMESPACE(24), // [distinct, scope, file, name, line]
  METADATA_TEMPLATE_TYPE(25), // [distinct, scope, name, type, ...]
  METADATA_TEMPLATE_VALUE(26), // [distinct, scope, name, type, value, ...]
  METADATA_GLOBAL_VAR(27), // [distinct, ...]
  METADATA_LOCAL_VAR(28), // [distinct, ...]
  METADATA_EXPRESSION(29), // [distinct, n x element]
  METADATA_OBJC_PROPERTY(30), // [distinct, name, file, line, ...]
  METADATA_IMPORTED_ENTITY(31), // [distinct, tag, scope, entity, line, name]
  METADATA_MODULE(32), // [distinct, scope, name, ...]
  METADATA_MACRO(33), // [distinct, macinfo, line, name, value]
  METADATA_MACRO_FILE(34), // [distinct, macinfo, line, file, ...]
  METADATA_STRINGS(35), // [count, offset] blob([lengths][chars])
  METADATA_GLOBAL_DECL_ATTACHMENT(36); // [valueid, n x [id, mdnode]]

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static MetadataCodes valueOf(int val) {
    MetadataCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final MetadataCodes[] VALUES;
    private static final MetadataCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (MetadataCodes kind : MetadataCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new MetadataCodes[min < 0 ? (1-min) : 0];
      VALUES = new MetadataCodes[max >= 0 ? (1+max) : 0];
      for (MetadataCodes kind : MetadataCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private MetadataCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MetadataCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MetadataCodes)obj).value);}
  //</editor-fold>
}
