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


/// Represents an array type, per C99 6.7.5.2 - Array Declarators.
///
//<editor-fold defaultstate="collapsed" desc="clang::ArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2456,
 FQN="clang::ArrayType", NM="_ZN5clang9ArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ArrayTypeE")
//</editor-fold>
public class ArrayType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
/*public:*/
  /// Capture whether this is a normal array (e.g. int X[4])
  /// an array with a static size (e.g. int X[static 4]), or an array
  /// with a star size (e.g. int X[*]).
  /// 'static' is only allowed on function parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::ArraySizeModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2462,
   FQN="clang::ArrayType::ArraySizeModifier", NM="_ZN5clang9ArrayType17ArraySizeModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ArrayType17ArraySizeModifierE")
  //</editor-fold>
  public enum ArraySizeModifier implements Native.ComparableLower, Native.NativeUIntEnum {
    Normal(0),
    Static(Normal.getValue() + 1),
    Star(Static.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ArraySizeModifier valueOf(int val) {
      ArraySizeModifier out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ArraySizeModifier[] VALUES;
      private static final ArraySizeModifier[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ArraySizeModifier kind : ArraySizeModifier.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ArraySizeModifier[min < 0 ? (1-min) : 0];
        VALUES = new ArraySizeModifier[max >= 0 ? (1+max) : 0];
        for (ArraySizeModifier kind : ArraySizeModifier.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ArraySizeModifier(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ArraySizeModifier)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ArraySizeModifier)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// The element type of the array.
  private QualType ElementType;
/*protected:*/
  // C++ [temp.dep.type]p1:
  //   A type is dependent if it is...
  //     - an array type constructed from any dependent type or whose
  //       size is specified by a constant expression that is
  //       value-dependent,
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::ArrayType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*JAVAFIX*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2475,
   FQN="clang::ArrayType::ArrayType", NM="_ZN5clang9ArrayTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_NS0_17ArraySizeModifierEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ArrayTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_NS0_17ArraySizeModifierEjb")
  //</editor-fold>
  protected ArrayType(TypeClass tc, QualType et, QualType can, 
      ArraySizeModifier sm, /*uint*/int tq, 
      boolean ContainsUnexpandedParameterPack) {
    // : Type(tc, can, et->isDependentType() || tc == DependentSizedArray, et->isInstantiationDependentType() || tc == DependentSizedArray, (tc == VariableArray || et->isVariablyModifiedType()), ContainsUnexpandedParameterPack), FoldingSetNode(), ElementType(et) 
    //START JInit
    super(tc, new QualType(can), et.$arrow().isDependentType() || tc == TypeClass.DependentSizedArray, 
        et.$arrow().isInstantiationDependentType() || tc == TypeClass.DependentSizedArray, 
        (tc == TypeClass.VariableArray || et.$arrow().isVariablyModifiedType()), 
        ContainsUnexpandedParameterPack);
    $Node();
    this.ElementType = new QualType(et);
    //END JInit
    Unnamed_field.ArrayTypeBits.IndexTypeQuals = $uint2uint_3bits(tq & Qualifiers.TQ.CVRMask); // JAVAFIX: need to mask to fit 3 bits
    Unnamed_field.ArrayTypeBits.SizeModifier = $uint2uint_3bits(sm.getValue());
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2490,
   FQN="clang::ArrayType::getElementType", NM="_ZNK5clang9ArrayType14getElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ArrayType14getElementTypeEv")
  //</editor-fold>
  public QualType getElementType() /*const*/ {
    return new QualType(ElementType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::getSizeModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2491,
   FQN="clang::ArrayType::getSizeModifier", NM="_ZNK5clang9ArrayType15getSizeModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ArrayType15getSizeModifierEv")
  //</editor-fold>
  public ArraySizeModifier getSizeModifier() /*const*/ {
    return ArraySizeModifier.valueOf(Unnamed_field.ArrayTypeBits.SizeModifier);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::getIndexTypeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2494,
   FQN="clang::ArrayType::getIndexTypeQualifiers", NM="_ZNK5clang9ArrayType22getIndexTypeQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ArrayType22getIndexTypeQualifiersEv")
  //</editor-fold>
  public Qualifiers getIndexTypeQualifiers() /*const*/ {
    return Qualifiers.fromCVRMask(getIndexTypeCVRQualifiers());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::getIndexTypeCVRQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2497,
   FQN="clang::ArrayType::getIndexTypeCVRQualifiers", NM="_ZNK5clang9ArrayType25getIndexTypeCVRQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ArrayType25getIndexTypeCVRQualifiersEv")
  //</editor-fold>
  public /*uint*/int getIndexTypeCVRQualifiers() /*const*/ {
    return $uchar2uint(Unnamed_field.ArrayTypeBits.IndexTypeQuals);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2501,
   FQN="clang::ArrayType::classof", NM="_ZN5clang9ArrayType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ArrayType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ConstantArray
       || T.getTypeClass() == TypeClass.VariableArray
       || T.getTypeClass() == TypeClass.IncompleteArray
       || T.getTypeClass() == TypeClass.DependentSizedArray;
  }

  @Override public String toString() {
    return "" + "ElementType=" + ElementType // NOI18N
              + super.toString(); // NOI18N
  }
}
