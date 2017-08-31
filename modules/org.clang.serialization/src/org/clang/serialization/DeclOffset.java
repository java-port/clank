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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;
import org.clank.support.NativeType.*;


/// \brief Source range/offset of a preprocessed entity.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 187,
 FQN="clang::serialization::DeclOffset", NM="_ZN5clang13serialization10DeclOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13serialization10DeclOffsetE")
//</editor-fold>
public class/*struct*/ DeclOffset implements SizeofCapable, ToByteArray, NativePOD<DeclOffset> {
  /// \brief Raw source location.
  public /*uint*/int Loc;
  /// \brief Offset in the AST file.
  public /*uint32_t*/int BitOffset;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset::DeclOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 193,
   FQN="clang::serialization::DeclOffset::DeclOffset", NM="_ZN5clang13serialization10DeclOffsetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13serialization10DeclOffsetC1Ev")
  //</editor-fold>
  public DeclOffset() {
    // : Loc(0), BitOffset(0) 
    //START JInit
    this.Loc = 0;
    this.BitOffset = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset::DeclOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 194,
   FQN="clang::serialization::DeclOffset::DeclOffset", NM="_ZN5clang13serialization10DeclOffsetC1ENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13serialization10DeclOffsetC1ENS_14SourceLocationEj")
  //</editor-fold>
  public DeclOffset(SourceLocation Loc, /*uint32_t*/int BitOffset) {
    // : Loc(Loc.getRawEncoding()), BitOffset(BitOffset) 
    //START JInit
    this.Loc = Loc.getRawEncoding();
    this.BitOffset = BitOffset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 197,
   FQN="clang::serialization::DeclOffset::setLocation", NM="_ZN5clang13serialization10DeclOffset11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13serialization10DeclOffset11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc = L.getRawEncoding();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 200,
   FQN="clang::serialization::DeclOffset::getLocation", NM="_ZNK5clang13serialization10DeclOffset11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZNK5clang13serialization10DeclOffset11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return SourceLocation.getFromRawEncoding(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclOffset::DeclOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 187,
   FQN="clang::serialization::DeclOffset::DeclOffset", NM="_ZN5clang13serialization10DeclOffsetC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13serialization10DeclOffsetC1EOS1_")
  //</editor-fold>
  public /*inline*/ DeclOffset(JD$Move _dparam, final DeclOffset /*&&*/$Prm0) {
    // : Loc(static_cast<DeclOffset &&>().Loc), BitOffset(static_cast<DeclOffset &&>().BitOffset) 
    //START JInit
    this.Loc = $Prm0.Loc;
    this.BitOffset = $Prm0.BitOffset;
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public DeclOffset(int Loc, int BitOffset) {
    this.Loc = Loc;
    this.BitOffset = BitOffset;
  }
  
  public static final int $sizeof_DeclOffset(){
    return 8;
  }
  
  @Override
  public int $sizeof() {
    return $sizeof_DeclOffset();
  }
  
  @Override
  public byte[] toByteArray() {
    return new byte[]{
      ToByteArray.get0(Loc),
      ToByteArray.get1(Loc),
      ToByteArray.get2(Loc),
      ToByteArray.get3(Loc),
      ToByteArray.get0(BitOffset),
      ToByteArray.get1(BitOffset),
      ToByteArray.get2(BitOffset),
      ToByteArray.get3(BitOffset)
    };
  }
  
  @Override
  public DeclOffset $assign(DeclOffset value) {
    this.BitOffset = value.BitOffset;
    this.Loc = value.Loc;
    return this;
  }

  @Override
  public DeclOffset clone() {
    return new DeclOffset(Loc, BitOffset);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", BitOffset=" + BitOffset; // NOI18N
  }
}
