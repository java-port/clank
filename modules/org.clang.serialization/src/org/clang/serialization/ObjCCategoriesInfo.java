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
import static org.clank.support.Native.$Clone;
import org.clank.support.Native.NativePOD;
import static org.clank.support.NativePointer.create_type$ptr;
import static org.clank.support.NativePointer.new$T;
import static org.clank.support.NativeType.sizeof$uint32;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.type$ptr;
import org.llvm.support.llvm.support;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Describes the categories of an Objective-C class.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::ObjCCategoriesInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1543,
 FQN="clang::serialization::ObjCCategoriesInfo", NM="_ZN5clang13serialization18ObjCCategoriesInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization18ObjCCategoriesInfoE")
//</editor-fold>
public class/*struct*/ ObjCCategoriesInfo implements NativeType.SizeofCapable, NativeType.ToByteArray, NativePOD<ObjCCategoriesInfo>, Native.ComparableLower {
  public /*uint32_t*/int DefinitionID; // The ID of the definition
  public /*uint*/int Offset; // Offset into the array of category lists.
  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::serialization::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1547,
   FQN="clang::serialization::operator<", NM="_ZN5clang13serializationltERKNS0_18ObjCCategoriesInfoES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationltERKNS0_18ObjCCategoriesInfoES3_")
  //</editor-fold>
  public static boolean $less_ObjCCategoriesInfo$C(final /*const*/ ObjCCategoriesInfo /*&*/ X, 
                            final /*const*/ ObjCCategoriesInfo /*&*/ Y) {
    return $less_uint(X.DefinitionID, Y.DefinitionID);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::serialization::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1552,
   FQN="clang::serialization::operator>", NM="_ZN5clang13serializationgtERKNS0_18ObjCCategoriesInfoES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationgtERKNS0_18ObjCCategoriesInfoES3_")
  //</editor-fold>
  public static boolean $greater_ObjCCategoriesInfo$C(final /*const*/ ObjCCategoriesInfo /*&*/ X, 
                               final /*const*/ ObjCCategoriesInfo /*&*/ Y) {
    return $greater_uint(X.DefinitionID, Y.DefinitionID);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::serialization::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1557,
   FQN="clang::serialization::operator<=", NM="_ZN5clang13serializationleERKNS0_18ObjCCategoriesInfoES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationleERKNS0_18ObjCCategoriesInfoES3_")
  //</editor-fold>
  public static boolean $lesseq_ObjCCategoriesInfo$C(final /*const*/ ObjCCategoriesInfo /*&*/ X, 
                              final /*const*/ ObjCCategoriesInfo /*&*/ Y) {
    return $lesseq_uint(X.DefinitionID, Y.DefinitionID);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::serialization::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1562,
   FQN="clang::serialization::operator>=", NM="_ZN5clang13serializationgeERKNS0_18ObjCCategoriesInfoES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serializationgeERKNS0_18ObjCCategoriesInfoES3_")
  //</editor-fold>
  public static boolean $greatereq_ObjCCategoriesInfo$C(final /*const*/ ObjCCategoriesInfo /*&*/ X, 
                                 final /*const*/ ObjCCategoriesInfo /*&*/ Y) {
    return $greatereq_uint(X.DefinitionID, Y.DefinitionID);
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  public static int $sizeof_ObjCCategoriesInfo(){
    return 2*sizeof$uint32();
  }

  @Override
  public int $sizeof() {
    return $sizeof_ObjCCategoriesInfo();
  }

  @Override
  public byte[] toByteArray() {
    byte[] bytes = new byte[$sizeof_ObjCCategoriesInfo()];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = get$Char$At$Index(i, this);
    }
    return bytes;
  }

  public ObjCCategoriesInfo() {
  }
  
  public ObjCCategoriesInfo(int DefinitionID, int Offset) {
    this.DefinitionID = DefinitionID;
    this.Offset = Offset;
  }
  
  private ObjCCategoriesInfo(char$ptr Buf) {
    this.DefinitionID = endian.readNext_uint32(endianness.little, support.unaligned, Buf);
    this.Offset = endian.readNext_uint32(endianness.little, support.unaligned, Buf);
  }

  public static type$ptr<ObjCCategoriesInfo /*P*/> fromBytes(char$ptr Buf, int Num) {
    char$ptr ptr = $Clone(Buf);
    final ObjCCategoriesInfo[] array = new$T(new ObjCCategoriesInfo[Num],()->new ObjCCategoriesInfo(ptr));
    return create_type$ptr(array);
  }

  @Override
  public ObjCCategoriesInfo $assign(ObjCCategoriesInfo $Prm0) {
    this.DefinitionID = $Prm0.DefinitionID;
    this.Offset = $Prm0.Offset;
    return this;
  }

  @Override
  public ObjCCategoriesInfo clone() {
    return new ObjCCategoriesInfo(this.DefinitionID, this.Offset);
  }
  
  /**
   * little endian presentation of object as stream of chars
   * @param index
   * @param Obj
   * @return 
   */
  public static /*char*/byte get$Char$At$Index(int index, ObjCCategoriesInfo Obj) {
    assert index >= 0 : "index=" + index;
    assert index < $sizeof_ObjCCategoriesInfo() : "" + index + " vs. " + $sizeof_ObjCCategoriesInfo();
    switch (index) {
      case 0:
        return NativeType.ToByteArray.get0(Obj.DefinitionID);
      case 1:
        return NativeType.ToByteArray.get1(Obj.DefinitionID);
      case 2:
        return NativeType.ToByteArray.get2(Obj.DefinitionID);
      case 3:
        return NativeType.ToByteArray.get3(Obj.DefinitionID);
      case 4:
        return NativeType.ToByteArray.get0(Obj.Offset);
      case 5:
        return NativeType.ToByteArray.get1(Obj.Offset);
      case 6:
        return NativeType.ToByteArray.get2(Obj.Offset);
      case 7:
        return NativeType.ToByteArray.get3(Obj.Offset);
      default:
        throw new IllegalArgumentException("Invalid index " + index);
    }
  }

  @Override
  public boolean $less(Object obj) {
    return $less_ObjCCategoriesInfo$C(this, ((ObjCCategoriesInfo)obj));
  }

  @Override
  public boolean $lesseq(Object obj) {
    return $lesseq_ObjCCategoriesInfo$C(this, ((ObjCCategoriesInfo)obj));
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DefinitionID=" + DefinitionID // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
