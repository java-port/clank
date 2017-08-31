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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.serialization.reader.impl.*;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InterestingASTIdentifierLookupTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 478,
 FQN="(anonymous namespace)::InterestingASTIdentifierLookupTrait", NM="_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTraitE")
//</editor-fold>
public class InterestingASTIdentifierLookupTrait extends /*public*/ ASTIdentifierLookupTraitBase<std.pairTypeBool<StringRef>> {
/*public:*/
  /// \brief The identifier and whether it is "interesting".
  // JAVA: typedef std::pair<StringRef, bool> data_type
//  public final class data_type extends std.pairTypeBool<StringRef>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InterestingASTIdentifierLookupTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 485,
   FQN="(anonymous namespace)::InterestingASTIdentifierLookupTrait::ReadData", NM="_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTrait8ReadDataERKN4llvm9StringRefEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTrait8ReadDataERKN4llvm9StringRefEPKhj")
  //</editor-fold>
  @Override public final std.pairTypeBool<StringRef> ReadData(final /*const*/ StringRef /*&*/ k, 
          /*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf,
          /*uint*/int DataLen) {
    // The first bit indicates whether this identifier is interesting.
    // That's all we care about.
    //JAVA: using namespace llvm::support;
    /*uint*/int RawID = endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInBuf);
//                               PERF: OffsetInBuf += NativeType.sizeof$uint32();
    boolean IsInteresting = ((RawID & 0x01) != 0);
    return std.make_pair_T_bool($Clone(k), IsInteresting);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InterestingASTIdentifierLookupTrait::InterestingASTIdentifierLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 478,
   FQN="(anonymous namespace)::InterestingASTIdentifierLookupTrait::InterestingASTIdentifierLookupTrait", NM="_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTraitC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTraitC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InterestingASTIdentifierLookupTrait(final /*const*/ InterestingASTIdentifierLookupTrait /*&*/ $Prm0) {
    // : ASTIdentifierLookupTraitBase() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  public InterestingASTIdentifierLookupTrait() {
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
