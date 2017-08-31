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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clank.support.Native.NativePOD;
import org.llvm.ir.Type;


/// \brief Structure with information about how a bitfield should be accessed.
///
/// Often we layout a sequence of bitfields as a contiguous sequence of bits.
/// When the AST record layout does this, we represent it in the LLVM IR's type
/// as either a sequence of i8 members or a byte array to reserve the number of
/// bytes touched without forcing any particular alignment beyond the basic
/// character alignment.
///
/// Then accessing a particular bitfield involves converting this byte array
/// into a single integer of that size (i24 or i40 -- may not be power-of-two
/// size), loading it, and shifting and masking to extract the particular
/// subsequence of bits which make up that particular bitfield. This structure
/// encodes the information used to construct the extraction code sequences.
/// The CGRecordLayout also has a field index which encodes which byte-sequence
/// this bitfield falls within. Let's assume the following C struct:
///
///   struct S {
///     char a, b, c;
///     unsigned bits : 3;
///     unsigned more_bits : 4;
///     unsigned still_more_bits : 7;
///   };
///
/// This will end up as the following LLVM type. The first array is the
/// bitfield, and the second is the padding out to a 4-byte alignmnet.
///
///   %t = type { i8, i8, i8, i8, i8, [3 x i8] }
///
/// When generating code to access more_bits, we'll generate something
/// essentially like this:
///
///   define i32 @foo(%t* %base) {
///     %0 = gep %t* %base, i32 0, i32 3
///     %2 = load i8* %1
///     %3 = lshr i8 %2, 3
///     %4 = and i8 %3, 15
///     %5 = zext i8 %4 to i32
///     ret i32 %i
///   }
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 66,
 FQN="clang::CodeGen::CGBitFieldInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoE")
//</editor-fold>
public class/*struct*/ CGBitFieldInfo implements NativePOD<CGBitFieldInfo> {
  /// The offset within a contiguous run of bitfields that are represented as
  /// a single "field" within the LLVM struct type. This offset is in bits.
  public /*JCHAR unsigned int*/ char Offset /*: 16*/;
  
  /// The total size of the bit-field, in bits.
  public /*JCHAR unsigned int*/ char Size /*: 15*/;
  
  /// Whether the bit-field is signed.
  public /*JBIT unsigned int*/ boolean IsSigned /*: 1*/;
  
  /// The storage size in bits which should be used when accessing this
  /// bitfield.
  public /*uint*/int StorageSize;
  
  /// The offset of the bitfield storage from the start of the struct.
  public CharUnits StorageOffset;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 84,
   FQN="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoC1Ev")
  //</editor-fold>
  public CGBitFieldInfo() {
    // : Offset(implicit unsigned int()), Size(implicit unsigned int()), IsSigned(implicit unsigned int()), StorageSize(implicit unsigned int()), StorageOffset() 
    //START JInit
    this.Offset = $uint2uint_16bits(/*implicit-init*/((/*uint*/int)/*zero-init*/0));
    this.Size = $uint2uint_15bits(/*implicit-init*/((/*uint*/int)/*zero-init*/0));
    this.IsSigned = $uint2uint_1bit(/*implicit-init*/((/*uint*/int)/*zero-init*/0));
    this.StorageSize = /*implicit-init*/((/*uint*/int)/*zero-init*/0);
    this.StorageOffset = new CharUnits();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 87,
   FQN="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfoC1EjjbjNS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoC1EjjbjNS_9CharUnitsE")
  //</editor-fold>
  public CGBitFieldInfo(/*uint*/int Offset, /*uint*/int Size, boolean IsSigned, 
      /*uint*/int StorageSize, CharUnits StorageOffset) {
    // : Offset(Offset), Size(Size), IsSigned(IsSigned), StorageSize(StorageSize), StorageOffset(StorageOffset) 
    //START JInit
    this.Offset = $uint2uint_16bits(Offset);
    this.Size = $uint2uint_15bits(Size);
    this.IsSigned = IsSigned;
    this.StorageSize = StorageSize;
    this.StorageOffset = new CharUnits(StorageOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 849,
   FQN="clang::CodeGen::CGBitFieldInfo::print", NM="_ZNK5clang7CodeGen14CGBitFieldInfo5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGBitFieldInfo5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"<CGBitFieldInfo").$out(
        /*KEEP_STR*/" Offset:"
    ).$out_uint($16bits_uint2uint(Offset)).$out(
        /*KEEP_STR*/" Size:"
    ).$out_uint($15bits_uint2uint(Size)).$out(
        /*KEEP_STR*/" IsSigned:"
    ).$out_uint(IsSigned).$out(
        /*KEEP_STR*/" StorageSize:"
    ).$out_uint(StorageSize).$out(
        /*KEEP_STR*/" StorageOffset:"
    ).$out_llong(StorageOffset.getQuantity()).$out(/*KEEP_STR*/$GT);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 858,
   FQN="clang::CodeGen::CGBitFieldInfo::dump", NM="_ZNK5clang7CodeGen14CGBitFieldInfo4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK5clang7CodeGen14CGBitFieldInfo4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs());
  }


  
  /// \brief Given a bit-field decl, build an appropriate helper object for
  /// accessing that field (which is expected to have the given offset and
  /// size).
  
  /// \brief Given a bit-field decl, build an appropriate helper object for
  /// accessing that field (which is expected to have the given offset and
  /// size).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::MakeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 646,
   FQN="clang::CodeGen::CGBitFieldInfo::MakeInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfo8MakeInfoERNS0_12CodeGenTypesEPKNS_9FieldDeclEyyyNS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfo8MakeInfoERNS0_12CodeGenTypesEPKNS_9FieldDeclEyyyNS_9CharUnitsE")
  //</editor-fold>
  public static CGBitFieldInfo MakeInfo(final CodeGenTypes /*&*/ Types, 
          /*const*/ FieldDecl /*P*/ FD, 
          long/*uint64_t*/ Offset, long/*uint64_t*/ Size, 
          long/*uint64_t*/ StorageSize, 
          CharUnits StorageOffset) {
    // This function is vestigial from CGRecordLayoutBuilder days but is still 
    // used in GCObjCRuntime.cpp.  That usage has a "fixme" attached to it that
    // when addressed will allow for the removal of this function.
    Type /*P*/ Ty = Types.ConvertTypeForMem(FD.getType());
    CharUnits TypeSizeInBytes = CharUnits.fromQuantity(Types.getDataLayout().getTypeAllocSize(Ty));
    long/*uint64_t*/ TypeSizeInBits = Types.getContext().toBits(new CharUnits(TypeSizeInBytes));
    
    boolean IsSigned = FD.getType().$arrow().isSignedIntegerOrEnumerationType();
    if ($greater_ulong(Size, TypeSizeInBits)) {
      // We have a wide bit-field. The extra bits are only used for padding, so
      // if we have a bitfield of type T, with size N:
      //
      // T t : N;
      //
      // We can just assume that it's:
      //
      // T t : sizeof(T);
      //
      Size = TypeSizeInBits;
    }
    
    // Reverse the bit offsets for big endian machines. Because we represent
    // a bitfield as a single large integer load, we can imagine the bits
    // counting from the most-significant-bit instead of the
    // least-significant-bit.
    if (Types.getDataLayout().isBigEndian()) {
      Offset = StorageSize - (Offset + Size);
    }
    
    return new CGBitFieldInfo($ulong2uint(Offset), $ulong2uint(Size), IsSigned, $ulong2uint(StorageSize), new CharUnits(StorageOffset));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 66,
   FQN="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CGBitFieldInfo(final /*const*/ CGBitFieldInfo /*&*/ $Prm0) {
    // : Offset(.Offset), Size(.Size), IsSigned(.IsSigned), StorageSize(.StorageSize), StorageOffset(.StorageOffset) 
    //START JInit
    this.Offset = $uint2uint_16bits($16bits_uint2uint($Prm0.Offset));
    this.Size = $uint2uint_15bits($15bits_uint2uint($Prm0.Size));
    this.IsSigned = $Prm0.IsSigned;
    this.StorageSize = $Prm0.StorageSize;
    this.StorageOffset = new CharUnits($Prm0.StorageOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 66,
   FQN="clang::CodeGen::CGBitFieldInfo::CGBitFieldInfo", NM="_ZN5clang7CodeGen14CGBitFieldInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ CGBitFieldInfo(JD$Move _dparam, final CGBitFieldInfo /*&&*/$Prm0) {
    // : Offset(static_cast<CGBitFieldInfo &&>().Offset), Size(static_cast<CGBitFieldInfo &&>().Size), IsSigned(static_cast<CGBitFieldInfo &&>().IsSigned), StorageSize(static_cast<CGBitFieldInfo &&>().StorageSize), StorageOffset(static_cast<CGBitFieldInfo &&>().StorageOffset) 
    //START JInit
    this.Offset = $uint2uint_16bits($16bits_uint2uint($Prm0.Offset));
    this.Size = $uint2uint_15bits($15bits_uint2uint($Prm0.Size));
    this.IsSigned = $Prm0.IsSigned;
    this.StorageSize = $Prm0.StorageSize;
    this.StorageOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.StorageOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBitFieldInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayout.h", line = 66,
   FQN="clang::CodeGen::CGBitFieldInfo::operator=", NM="_ZN5clang7CodeGen14CGBitFieldInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen14CGBitFieldInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ CGBitFieldInfo /*&*/ $assign(final /*const*/ CGBitFieldInfo /*&*/ $Prm0) {
    this.Offset = $uint2uint_16bits($16bits_uint2uint($Prm0.Offset));
    this.Size = $uint2uint_15bits($15bits_uint2uint($Prm0.Size));
    this.IsSigned = $Prm0.IsSigned;
    this.StorageSize = $Prm0.StorageSize;
    this.StorageOffset.$assign($Prm0.StorageOffset);
    return /*Deref*/this;
  }

  @Override
  public CGBitFieldInfo clone() {
    return new CGBitFieldInfo(this);
  }

  @Override public String toString() {
    return "" + "Offset=" + $ushort2uint(Offset) // NOI18N
              + ", Size=" + $ushort2uint(Size) // NOI18N
              + ", IsSigned=" + IsSigned // NOI18N
              + ", StorageSize=" + StorageSize // NOI18N
              + ", StorageOffset=" + StorageOffset; // NOI18N
  }
}
