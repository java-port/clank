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

package org.clang.lex.impl;

import org.clank.java.std;
import static org.clank.java.std_pair.*;
import static org.clank.java.stdimpl.StdString.TERM;
import static org.clank.support.Casts.$char;
import org.clank.support.Converted;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.support.OnDiskChainedHashTable;
import org.llvm.support.llvm;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileLookupCommonTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 319,
 optimized = Converted.Optimization.VALUE_TYPE,       
 FQN="(anonymous namespace)::PTHFileLookupCommonTrait", NM="_ZN12_GLOBAL__N_124PTHFileLookupCommonTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_124PTHFileLookupCommonTraitE")
//</editor-fold>
public abstract class PTHFileLookupCommonTrait<external_key_type, data_type> implements OnDiskChainedHashTable.InfoInterface<external_key_type, std.pairUCharType<char$ptr>, data_type> {

  /*public:*/
  /*typedef std::pair<unsigned char, const char *> internal_key_type*/
  //  public final class internal_key_type extends std.pairUCharType</*const*/char$ptr/*char P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileLookupCommonTrait::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 325,
   FQN = "(anonymous namespace)::PTHFileLookupCommonTrait::ComputeHash", NM = "_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait11ComputeHashESt4pairIhPKcE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait11ComputeHashESt4pairIhPKcE")
  //</editor-fold>
  @Override
  public /*uint32_t*/int ComputeHash( /*const*/ /*char P*/ std.pairUCharType<char$ptr> x) {
    return llvm.HashString(x.second, std.strlen(x.second));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileLookupCommonTrait::ReadKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 329,
   FQN = "(anonymous namespace)::PTHFileLookupCommonTrait::ReadKeyDataLength", NM = "_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait17ReadKeyDataLengthERPKh",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait17ReadKeyDataLengthERPKh")
  //</editor-fold>
  @Override
  public /*std.pair<uint, uint>*/long ReadKeyDataLength( /*const uchar P&*/ char$ptr /*const uchar P&*/ d, int OffsetInBuf) {
    /*uint*/char keyLen = endian.read_uint16(endianness.little, unaligned, d, OffsetInBuf);
                                 OffsetInBuf+=sizeof$uint16(); 
    /*uint*/int dataLen = $char(d.$at(OffsetInBuf));
    return wrap_int_int_pair(keyLen, dataLen);
  }

  @Override
  public /*uint*/int getReadKeyDataLengthBytes() {
    return sizeof$uint16() + 1;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileLookupCommonTrait::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 338,
   FQN = "(anonymous namespace)::PTHFileLookupCommonTrait::ReadKey", NM = "_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait7ReadKeyEPKhj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_124PTHFileLookupCommonTrait7ReadKeyEPKhj")
  //</editor-fold>
  @Override
  public std.pairUCharType<char$ptr> ReadKey( /*const*/ /*uchar P*/ char$ptr Buf, int OffsetInBuf, /*uint*/int $Prm1) {
    /*uchar*/byte k = Buf.$at(OffsetInBuf);
    $Key.first = k;
    // Read the entry kind.
    $Key.second = Buf.$add(OffsetInBuf + 1);
    return $Key;
  }
  private final std.pairUCharType<char$ptr> $Key = new std.pairUCharType<char$ptr>(TERM, null);

  @Override public abstract data_type ReadData(std.pairUCharType<char$ptr> Key, char$ptr Buf, int OffsetInBuf, int DataLength);
  
  /*inline*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHFileLookupCommonTrait::PTHFileLookupCommonTrait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 319,
   FQN = "(anonymous namespace)::PTHFileLookupCommonTrait::PTHFileLookupCommonTrait", NM = "_ZN12_GLOBAL__N_124PTHFileLookupCommonTraitC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_124PTHFileLookupCommonTraitC1ERKS0_")
  //</editor-fold>
  public PTHFileLookupCommonTrait( /*const*/ /*&*/ PTHFileLookupCommonTrait $Prm0) /* throw()*/ {
  }

  public PTHFileLookupCommonTrait() /* throw()*/ {
  } /* throw()*/
  
}
