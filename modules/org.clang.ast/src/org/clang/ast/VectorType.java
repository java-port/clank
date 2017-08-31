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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


/// Represents a GCC generic vector type. This type is created using
/// __attribute__((vector_size(n)), where "n" specifies the vector size in
/// bytes; or from an Altivec __vector or vector declaration.
/// Since the constructor takes the number of vector elements, the
/// client is responsible for converting the size into the number of elements.
//<editor-fold defaultstate="collapsed" desc="clang::VectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2756,
 FQN="clang::VectorType", NM="_ZN5clang10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorTypeE")
//</editor-fold>
public class VectorType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::VectorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2758,
   FQN="clang::VectorType::VectorKind", NM="_ZN5clang10VectorType10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorType10VectorKindE")
  //</editor-fold>
  public enum VectorKind implements Native.ComparableLower {
    GenericVector(0), ///< not a target-specific vector type
    AltiVecVector(GenericVector.getValue() + 1), ///< is AltiVec vector
    AltiVecPixel(AltiVecVector.getValue() + 1), ///< is AltiVec 'vector Pixel'
    AltiVecBool(AltiVecPixel.getValue() + 1), ///< is AltiVec 'vector bool ...'
    NeonVector(AltiVecBool.getValue() + 1), ///< is ARM Neon vector
    NeonPolyVector(NeonVector.getValue() + 1); ///< is ARM Neon polynomial vector

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VectorKind valueOf(int val) {
      VectorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VectorKind[] VALUES;
      private static final VectorKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VectorKind kind : VectorKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VectorKind[min < 0 ? (1-min) : 0];
        VALUES = new VectorKind[max >= 0 ? (1+max) : 0];
        for (VectorKind kind : VectorKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VectorKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VectorKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VectorKind)obj).value);}
    //</editor-fold>
  };
/*protected:*/
  /// The element type of the vector.
  protected QualType ElementType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::VectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 172,
   FQN="clang::VectorType::VectorType", NM="_ZN5clang10VectorTypeC1ENS_8QualTypeEjS1_NS0_10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorTypeC1ENS_8QualTypeEjS1_NS0_10VectorKindE")
  //</editor-fold>
  protected VectorType(QualType vecType, /*uint*/int nElements, QualType canonType, 
      VectorKind vecKind) {
    // : VectorType(Vector, vecType, nElements, canonType, vecKind) 
    //START JInit
    this(TypeClass.Vector, new QualType(vecType), nElements, new QualType(canonType), vecKind);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::VectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 176,
   FQN="clang::VectorType::VectorType", NM="_ZN5clang10VectorTypeC1ENS_4Type9TypeClassENS_8QualTypeEjS3_NS0_10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorTypeC1ENS_4Type9TypeClassENS_8QualTypeEjS3_NS0_10VectorKindE")
  //</editor-fold>
  protected VectorType(TypeClass tc, QualType vecType, /*uint*/int nElements, 
      QualType canonType, VectorKind vecKind) {
    // : Type(tc, canonType, vecType->isDependentType(), vecType->isInstantiationDependentType(), vecType->isVariablyModifiedType(), vecType->containsUnexpandedParameterPack()), FoldingSetNode(), ElementType(vecType) 
    //START JInit
    super(tc, new QualType(canonType), vecType.$arrow().isDependentType(), 
        vecType.$arrow().isInstantiationDependentType(), 
        vecType.$arrow().isVariablyModifiedType(), 
        vecType.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.ElementType = new QualType(vecType);
    //END JInit
    Unnamed_field.VectorTypeBits.VecKind = $uint2uint_3bits(vecKind.getValue());
    Unnamed_field.VectorTypeBits.NumElements = $uint2uint_11bits(nElements);
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2780,
   FQN="clang::VectorType::getElementType", NM="_ZNK5clang10VectorType14getElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10VectorType14getElementTypeEv")
  //</editor-fold>
  public QualType getElementType() /*const*/ {
    return new QualType(ElementType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2781,
   FQN="clang::VectorType::getNumElements", NM="_ZNK5clang10VectorType14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10VectorType14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return Unnamed_field.VectorTypeBits.NumElements;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::isVectorSizeTooLarge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2782,
   FQN="clang::VectorType::isVectorSizeTooLarge", NM="_ZN5clang10VectorType20isVectorSizeTooLargeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorType20isVectorSizeTooLargeEj")
  //</editor-fold>
  public static boolean isVectorSizeTooLarge(/*uint*/int NumElements) {
    return $greater_uint(NumElements, VectorTypeBitfields.MaxNumElements);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2786,
   FQN="clang::VectorType::isSugared", NM="_ZNK5clang10VectorType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10VectorType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2787,
   FQN="clang::VectorType::desugar", NM="_ZNK5clang10VectorType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10VectorType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::getVectorKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2789,
   FQN="clang::VectorType::getVectorKind", NM="_ZNK5clang10VectorType13getVectorKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10VectorType13getVectorKindEv")
  //</editor-fold>
  public VectorKind getVectorKind() /*const*/ {
    return VectorKind.valueOf($uchar2uint(Unnamed_field.VectorTypeBits.VecKind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2793,
   FQN="clang::VectorType::Profile", NM="_ZN5clang10VectorType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getElementType(), getNumElements(), 
        getTypeClass(), getVectorKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2797,
   FQN="clang::VectorType::Profile", NM="_ZN5clang10VectorType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEjNS_4Type9TypeClassENS0_10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEjNS_4Type9TypeClassENS0_10VectorKindE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType ElementType, 
         /*uint*/int NumElements, TypeClass $TypeClass, 
         VectorKind VecKind) {
    ID.AddPointer(ElementType.getAsOpaquePtr());
    ID.AddInteger_uint(NumElements);
    ID.AddInteger_int($TypeClass.getValue());
    ID.AddInteger_int(VecKind.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VectorType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2806,
   FQN="clang::VectorType::classof", NM="_ZN5clang10VectorType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10VectorType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Vector || T.getTypeClass() == TypeClass.ExtVector;
  }

  @Override public String toString() {
    return "" + "ElementType=" + ElementType // NOI18N
              + super.toString(); // NOI18N
  }
}
