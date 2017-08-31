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
import org.clang.ast.*;
import org.clank.support.Native.NativePOD;


/// \brief A type index; the type ID with the qualifier bits removed.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 83,
 FQN="clang::serialization::TypeIdx", NM="_ZN5clang13serialization7TypeIdxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxE")
//</editor-fold>
public class TypeIdx implements NativePOD<TypeIdx> {
  private /*uint32_t*/int Idx;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::TypeIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 86,
   FQN="clang::serialization::TypeIdx::TypeIdx", NM="_ZN5clang13serialization7TypeIdxC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxC1Ev")
  //</editor-fold>
  public TypeIdx() {
    // : Idx(0) 
    //START JInit
    this.Idx = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::TypeIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 87,
   FQN="clang::serialization::TypeIdx::TypeIdx", NM="_ZN5clang13serialization7TypeIdxC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxC1Ej")
  //</editor-fold>
  public /*explicit*/ TypeIdx(/*uint32_t*/int index) {
    // : Idx(index) 
    //START JInit
    this.Idx = index;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 89,
   FQN="clang::serialization::TypeIdx::getIndex", NM="_ZNK5clang13serialization7TypeIdx8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang13serialization7TypeIdx8getIndexEv")
  //</editor-fold>
  public /*uint32_t*/int getIndex() /*const*/ {
    return Idx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::asTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 90,
   FQN="clang::serialization::TypeIdx::asTypeID", NM="_ZNK5clang13serialization7TypeIdx8asTypeIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang13serialization7TypeIdx8asTypeIDEj")
  //</editor-fold>
  public /*uint32_t*/int asTypeID(/*uint*/int FastQuals) /*const*/ {
    if (Idx == ((/*uint32_t*/int)(-1))) {
      return ((/*uint32_t*/int)(-1));
    }
    
    return (Idx << Qualifiers.FastWidth) | FastQuals;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::fromTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 96,
   FQN="clang::serialization::TypeIdx::fromTypeID", NM="_ZN5clang13serialization7TypeIdx10fromTypeIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdx10fromTypeIDEj")
  //</editor-fold>
  public static TypeIdx fromTypeID(/*uint32_t*/int ID) {
    if (ID == ((/*uint32_t*/int)(-1))) {
      return new TypeIdx(-1);
    }
    
    return new TypeIdx(ID >>> Qualifiers.FastWidth);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::TypeIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 83,
   FQN="clang::serialization::TypeIdx::TypeIdx", NM="_ZN5clang13serialization7TypeIdxC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TypeIdx(final /*const*/ TypeIdx /*&*/ $Prm0) {
    // : Idx(.Idx) 
    //START JInit
    this.Idx = $Prm0.Idx;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::TypeIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 83,
   FQN="clang::serialization::TypeIdx::TypeIdx", NM="_ZN5clang13serialization7TypeIdxC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxC1EOS1_")
  //</editor-fold>
  public /*inline*/ TypeIdx(JD$Move _dparam, final TypeIdx /*&&*/$Prm0) {
    // : Idx(static_cast<TypeIdx &&>().Idx) 
    //START JInit
    this.Idx = $Prm0.Idx;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 83,
   FQN="clang::serialization::TypeIdx::operator=", NM="_ZN5clang13serialization7TypeIdxaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxaSERKS1_")
  //</editor-fold>
  public /*inline*/ TypeIdx /*&*/ $assign(final /*const*/ TypeIdx /*&*/ $Prm0) {
    this.Idx = $Prm0.Idx;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdx::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 83,
   FQN="clang::serialization::TypeIdx::operator=", NM="_ZN5clang13serialization7TypeIdxaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13serialization7TypeIdxaSEOS1_")
  //</editor-fold>
  public /*inline*/ TypeIdx /*&*/ $assignMove(final TypeIdx /*&&*/$Prm0) {
    this.Idx = $Prm0.Idx;
    return /*Deref*/this;
  }

  @Override
  public TypeIdx clone() {
    return new TypeIdx(Idx);
  }

  @Override public String toString() {
    return "" + "Idx=" + Idx; // NOI18N
  }
}
