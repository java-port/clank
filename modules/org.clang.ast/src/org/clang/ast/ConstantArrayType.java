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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// Represents the canonical version of C arrays with a specified constant size.
/// For example, the canonical type for 'int A[4 + 4*100]' is a
/// ConstantArrayType where the element type is 'int' and the size is 404.
//<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2512,
 FQN="clang::ConstantArrayType", NM="_ZN5clang17ConstantArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayTypeE")
//</editor-fold>
public class ConstantArrayType extends /*public*/ ArrayType implements Destructors.ClassWithDestructor {
  private APInt Size; // Allows us to unique the type.
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::ConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2515,
   FQN="clang::ConstantArrayType::ConstantArrayType", NM="_ZN5clang17ConstantArrayTypeC1ENS_8QualTypeES1_RKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayTypeC1ENS_8QualTypeES1_RKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj")
  //</editor-fold>
  /*friend*/protected/*private*/ ConstantArrayType(QualType et, QualType can, final /*const*/ APInt /*&*/ size, 
      ArraySizeModifier sm, /*uint*/int tq) {
    // : ArrayType(ConstantArray, et, can, sm, tq, et->containsUnexpandedParameterPack()), Size(size) 
    //START JInit
    super(TypeClass.ConstantArray, new QualType(et), new QualType(can), sm, tq, 
        et.$arrow().containsUnexpandedParameterPack());
    this.Size = new APInt(size);
    //END JInit
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::ConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2521,
   FQN="clang::ConstantArrayType::ConstantArrayType", NM="_ZN5clang17ConstantArrayTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_RKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_RKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj")
  //</editor-fold>
  protected ConstantArrayType(TypeClass tc, QualType et, QualType can, 
      final /*const*/ APInt /*&*/ size, ArraySizeModifier sm, /*uint*/int tq) {
    // : ArrayType(tc, et, can, sm, tq, et->containsUnexpandedParameterPack()), Size(size) 
    //START JInit
    super(tc, new QualType(et), new QualType(can), sm, tq, et.$arrow().containsUnexpandedParameterPack());
    this.Size = new APInt(size);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2527,
   FQN="clang::ConstantArrayType::getSize", NM="_ZNK5clang17ConstantArrayType7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ConstantArrayType7getSizeEv")
  //</editor-fold>
  public /*const*/ APInt /*&*/ getSize() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2528,
   FQN="clang::ConstantArrayType::isSugared", NM="_ZNK5clang17ConstantArrayType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ConstantArrayType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2529,
   FQN="clang::ConstantArrayType::desugar", NM="_ZNK5clang17ConstantArrayType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ConstantArrayType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  /// \brief Determine the number of bits required to address a member of
  // an array with the given element type and number of elements.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::getNumAddressingBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 77,
   FQN="clang::ConstantArrayType::getNumAddressingBits", NM="_ZN5clang17ConstantArrayType20getNumAddressingBitsERKNS_10ASTContextENS_8QualTypeERKN4llvm5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayType20getNumAddressingBitsERKNS_10ASTContextENS_8QualTypeERKN4llvm5APIntE")
  //</editor-fold>
  public static /*uint*/int getNumAddressingBits(final /*const*/ ASTContext /*&*/ Context, 
                      QualType ElementType, 
                      final /*const*/ APInt /*&*/ NumElements) {
    long/*uint64_t*/ ElementSize = Context.getTypeSizeInChars(new QualType(ElementType)).getQuantity();
    
    // Fast path the common cases so we can avoid the conservative computation
    // below, which in common cases allocates "large" APSInt values, which are
    // slow.
    
    // If the element size is a power of 2, we can directly compute the additional
    // number of addressing bits beyond those required for the element count.
    if (llvm.isPowerOf2_64(ElementSize)) {
      return NumElements.getActiveBits() + llvm.Log2_64(ElementSize);
    }
    
    // If both the element count and element size fit in 32-bits, we can do the
    // computation directly in 64-bits.
    if ((ElementSize >>> 32) == 0 && $lesseq_uint(NumElements.getBitWidth(), 64)
       && (NumElements.getZExtValue() >>> 32) == 0) {
      long/*uint64_t*/ TotalSize = NumElements.getZExtValue() * ElementSize;
      return 64 - llvm.countLeadingZeros(TotalSize);
    }
    
    // Otherwise, use APSInt to handle arbitrary sized values.
    APSInt SizeExtended/*J*/= new APSInt(new APInt(NumElements), true);
    /*uint*/int SizeTypeBits = $ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType()));
    SizeExtended.$assignMove(SizeExtended.extend(std.max(SizeTypeBits, 
                SizeExtended.getBitWidth()) * 2));
    
    APSInt TotalSize/*J*/= new APSInt(new APInt(SizeExtended.getBitWidth(), ElementSize));
    TotalSize.$starassign(SizeExtended);
    
    return TotalSize.getActiveBits();
  }

  
  /// \brief Determine the maximum number of active bits that an array's size
  /// can require, which limits the maximum size of the array.
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::getMaxSizeBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 112,
   FQN="clang::ConstantArrayType::getMaxSizeBits", NM="_ZN5clang17ConstantArrayType14getMaxSizeBitsERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayType14getMaxSizeBitsERKNS_10ASTContextE")
  //</editor-fold>
  public static /*uint*/int getMaxSizeBits(final /*const*/ ASTContext /*&*/ Context) {
    /*uint*/int Bits = $ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType()));
    
    // Limit the number of bits in size_t so that maximal bit size fits 64 bit
    // integer (see PR8256).  We can do this as currently there is no hardware
    // that supports full 64-bit virtual space.
    if ($greater_uint(Bits, 61)) {
      Bits = 61;
    }
    
    return Bits;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2542,
   FQN="clang::ConstantArrayType::Profile", NM="_ZN5clang17ConstantArrayType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getElementType(), getSize(), 
        getSizeModifier(), getIndexTypeCVRQualifiers());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2546,
   FQN="clang::ConstantArrayType::Profile", NM="_ZN5clang17ConstantArrayType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeERKNS1_5APIntENS_9ArrayType17ArraySizeModifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeERKNS1_5APIntENS_9ArrayType17ArraySizeModifierEj")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType ET, 
         final /*const*/ APInt /*&*/ ArraySize, ArraySizeModifier SizeMod, 
         /*uint*/int TypeQuals) {
    ID.AddPointer(ET.getAsOpaquePtr());
    ID.AddInteger_ullong(ArraySize.getZExtValue());
    ID.AddInteger_int(SizeMod.getValue());
    ID.AddInteger_uint(TypeQuals);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2554,
   FQN="clang::ConstantArrayType::classof", NM="_ZN5clang17ConstantArrayType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ConstantArray;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstantArrayType::~ConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2512,
   FQN="clang::ConstantArrayType::~ConstantArrayType", NM="_ZN5clang17ConstantArrayTypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ConstantArrayTypeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + super.toString(); // NOI18N
  }
}
