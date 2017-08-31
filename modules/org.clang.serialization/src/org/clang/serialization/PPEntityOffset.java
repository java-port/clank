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

package org.clang.serialization;

import org.clank.support.*;
import static org.clank.support.NativeType.*;
import org.clang.basic.*;


/// \brief Source range/offset of a preprocessed entity.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::PPEntityOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 166,
 FQN="clang::serialization::PPEntityOffset", NM="_ZN5clang13serialization14PPEntityOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization14PPEntityOffsetE")
//</editor-fold>
public class/*struct*/ PPEntityOffset implements SizeofCapable, ToByteArray, NativeCloneable<PPEntityOffset> {
  /// \brief Raw source location of beginning of range.
  public /*uint*/int Begin;
  /// \brief Raw source location of end of range.
  public /*uint*/int End;
  /// \brief Offset in the AST file.
  public /*uint32_t*/int BitOffset;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::PPEntityOffset::PPEntityOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 174,
   FQN="clang::serialization::PPEntityOffset::PPEntityOffset", NM="_ZN5clang13serialization14PPEntityOffsetC1ENS_11SourceRangeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization14PPEntityOffsetC1ENS_11SourceRangeEj")
  //</editor-fold>
  public PPEntityOffset(SourceRange R, /*uint32_t*/int BitOffset) {
    // : Begin(R.getBegin().getRawEncoding()), End(R.getEnd().getRawEncoding()), BitOffset(BitOffset) 
    //START JInit
    this.Begin = R.getBegin().getRawEncoding();
    this.End = R.getEnd().getRawEncoding();
    this.BitOffset = BitOffset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::PPEntityOffset::getBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 178,
   FQN="clang::serialization::PPEntityOffset::getBegin", NM="_ZNK5clang13serialization14PPEntityOffset8getBeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZNK5clang13serialization14PPEntityOffset8getBeginEv")
  //</editor-fold>
  public SourceLocation getBegin() /*const*/ {
    return SourceLocation.getFromRawEncoding(Begin);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::PPEntityOffset::getEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 181,
   FQN="clang::serialization::PPEntityOffset::getEnd", NM="_ZNK5clang13serialization14PPEntityOffset6getEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZNK5clang13serialization14PPEntityOffset6getEndEv")
  //</editor-fold>
  public SourceLocation getEnd() /*const*/ {
    return SourceLocation.getFromRawEncoding(End);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final int $sizeof_PPEntityOffset(){
    return sizeof$uint32() * 3/* 3 uint fields*/;
  }
  
  public PPEntityOffset(int Begin, int End, int BitOffset) {
    this.Begin = Begin;
    this.End = End;
    this.BitOffset = BitOffset;
  }
  
  public PPEntityOffset() {
  }

  @Override
  public int $sizeof() {
    return $sizeof_PPEntityOffset();
  }

  @Override
  public byte[] toByteArray() {    
    return new byte[]{
      ToByteArray.get0(Begin),
      ToByteArray.get1(Begin),
      ToByteArray.get2(Begin),
      ToByteArray.get3(Begin),
      ToByteArray.get0(End),
      ToByteArray.get1(End),
      ToByteArray.get2(End),
      ToByteArray.get3(End),
      ToByteArray.get0(BitOffset),
      ToByteArray.get1(BitOffset),
      ToByteArray.get2(BitOffset),
      ToByteArray.get3(BitOffset)
    };
  }

  @Override
  public PPEntityOffset clone() {
    return new PPEntityOffset(this.Begin, this.End, this.BitOffset);
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", BitOffset=" + BitOffset; // NOI18N
  }

}
