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
import org.clank.support.Converted;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatLookupTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 646,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 647,
 FQN = "(anonymous namespace)::PTHStatLookupTrait", NM = "_ZN12_GLOBAL__N_118PTHStatLookupTraitE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_118PTHStatLookupTraitE")
//</editor-fold>
public class PTHStatLookupTrait extends /*public*/ PTHFileLookupCommonTrait<char$ptr, PTHStatData> {

  // const char*
  /*typedef PTHStatData data_type*/
  //  public final class data_type extends PTHStatData{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatLookupTrait::GetInternalKey">
  @Converted(kind = Converted.Kind.MANUAL, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 651,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 652,
   FQN = "(anonymous namespace)::PTHStatLookupTrait::GetInternalKey", NM = "_ZN12_GLOBAL__N_118PTHStatLookupTrait14GetInternalKeyEPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_118PTHStatLookupTrait14GetInternalKeyEPKc")
  //</editor-fold>  
  @Override
  public std.pairUCharType<char$ptr> GetInternalKey( /*const*/ /*char P*/ char$ptr path) {
    // The key 'kind' doesn't matter here because it is ignored in EqualKey.
    $IKey.first = (byte)0x0;
    $IKey.second = path;
    return $IKey;
  }
  private final std.pairUCharType<char$ptr> $IKey = new std.pairUCharType<char$ptr>((byte)0xFF, null);
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatLookupTrait::EqualKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 656,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 657,
   FQN = "(anonymous namespace)::PTHStatLookupTrait::EqualKey", NM = "_ZN12_GLOBAL__N_118PTHStatLookupTrait8EqualKeyESt4pairIhPKcES4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_118PTHStatLookupTrait8EqualKeyESt4pairIhPKcES4_")
  //</editor-fold>  
  @Override
  public boolean EqualKey( /*const*/ /*char P*/ std.pairUCharType<char$ptr> a, /*const*/ /*char P*/ std.pairUCharType<char$ptr> b) {
    // When doing 'stat' lookups we don't care about the kind of 'a' and 'b',
    // just the paths.
    return std.strcmp(a.second, b.second) == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatLookupTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 662,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 663,
   FQN = "(anonymous namespace)::PTHStatLookupTrait::ReadData", NM = "_ZN12_GLOBAL__N_118PTHStatLookupTrait8ReadDataERKSt4pairIhPKcEPKhj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_118PTHStatLookupTrait8ReadDataERKSt4pairIhPKcEPKhj")
  //</editor-fold>  
  @Override
  public PTHStatData ReadData( /*const*/ /*const*/ /*char P*/ /*&*/ std.pairUCharType<char$ptr> /*&*/ k, /*const*/ /*uchar P*/ char$ptr d, int OffsetInBuf, /*uint*/int $Prm2) {
    assert k.first != 0xFF : "unexpected or invalid?" + k;
    
    if (k.first != 0/* File or Directory */) {
      boolean IsDirectory = true;
      if (k.first == 0x1/* File */) {
        IsDirectory = false;
        OffsetInBuf += /*d.$inc*/(sizeof$uint32() * 2); // Skip the first 2 words.
      }
      //JAVA: using namespace llvm::support;

      long/*uint64_t*/ File = endian.read_uint64(endianness.little, unaligned, d, OffsetInBuf);
                                      OffsetInBuf+=sizeof$uint64(); // shift index
      long/*uint64_t*/ Device = endian.read_uint64(endianness.little, unaligned, d, OffsetInBuf);
                                      OffsetInBuf+=sizeof$uint64(); // shift index
      fs.UniqueID UniqueID/*J*/= new fs.UniqueID(Device, File);
      long/*time_t*/ ModTime = endian.read_uint64(endianness.little, unaligned, d, OffsetInBuf);
                                      OffsetInBuf+=sizeof$uint64(); // shift index
      long/*uint64_t*/ Size = endian.read_uint64(endianness.little, unaligned, d, OffsetInBuf);
                                      //PERF: OffsetInBuf+=sizeof$uint64(); // shift index
      return new PTHStatData(Size, ModTime, UniqueID, IsDirectory);
    }
    // Negative stat.  Don't read anything.
    return new PTHStatData();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHStatLookupTrait::PTHStatLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 646,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 647,
   FQN="(anonymous namespace)::PTHStatLookupTrait::PTHStatLookupTrait", NM="_ZN12_GLOBAL__N_118PTHStatLookupTraitC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN12_GLOBAL__N_118PTHStatLookupTraitC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PTHStatLookupTrait(/*const*/ PTHStatLookupTrait /*&*/ $Prm0) {
    /* : PTHFileLookupCommonTrait()*/ 
    //START JInit
    super($Prm0);
    //END JInit
  }

  public PTHStatLookupTrait() {
  }

  @Override
  public char$ptr GetExternalKey(std.pairUCharType<char$ptr> x) {
    throw new UnsupportedOperationException("Must Not Be Called for this class");
  }
  
}
