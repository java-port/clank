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


/// A unary type transform, which is a type constructed from another.
//<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3631,
 FQN="clang::UnaryTransformType", NM="_ZN5clang18UnaryTransformTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18UnaryTransformTypeE")
//</editor-fold>
public class UnaryTransformType extends /*public*/ Type {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::UTTKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3633,
   FQN="clang::UnaryTransformType::UTTKind", NM="_ZN5clang18UnaryTransformType7UTTKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18UnaryTransformType7UTTKindE")
  //</editor-fold>
  public enum UTTKind implements Native.ComparableLower {
    EnumUnderlyingType(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UTTKind valueOf(int val) {
      UTTKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UTTKind[] VALUES;
      private static final UTTKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UTTKind kind : UTTKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UTTKind[min < 0 ? (1-min) : 0];
        VALUES = new UTTKind[max >= 0 ? (1+max) : 0];
        for (UTTKind kind : UTTKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private UTTKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((UTTKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((UTTKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// The untransformed type.
  private QualType BaseType;
  /// The transformed type if not dependent, otherwise the same as BaseType.
  private QualType UnderlyingType;
  
  private UTTKind UKind;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::UnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2926,
   FQN="clang::UnaryTransformType::UnaryTransformType", NM="_ZN5clang18UnaryTransformTypeC1ENS_8QualTypeES1_NS0_7UTTKindES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18UnaryTransformTypeC1ENS_8QualTypeES1_NS0_7UTTKindES1_")
  //</editor-fold>
  protected UnaryTransformType(QualType BaseType, 
      QualType UnderlyingType, 
      UTTKind UKind, 
      QualType CanonicalType) {
    // : Type(UnaryTransform, CanonicalType, BaseType->isDependentType(), BaseType->isInstantiationDependentType(), BaseType->isVariablyModifiedType(), BaseType->containsUnexpandedParameterPack()), BaseType(BaseType), UnderlyingType(UnderlyingType), UKind(UKind) 
    //START JInit
    super(TypeClass.UnaryTransform, new QualType(CanonicalType), BaseType.$arrow().isDependentType(), 
        BaseType.$arrow().isInstantiationDependentType(), 
        BaseType.$arrow().isVariablyModifiedType(), 
        BaseType.$arrow().containsUnexpandedParameterPack());
    this.BaseType = new QualType(BaseType);
    this.UnderlyingType = new QualType(UnderlyingType);
    this.UKind = UKind;
    //END JInit
  }

  /*friend  class ASTContext*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3649,
   FQN="clang::UnaryTransformType::isSugared", NM="_ZNK5clang18UnaryTransformType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18UnaryTransformType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return !isDependentType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3650,
   FQN="clang::UnaryTransformType::desugar", NM="_ZNK5clang18UnaryTransformType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18UnaryTransformType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(UnderlyingType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::getUnderlyingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3652,
   FQN="clang::UnaryTransformType::getUnderlyingType", NM="_ZNK5clang18UnaryTransformType17getUnderlyingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18UnaryTransformType17getUnderlyingTypeEv")
  //</editor-fold>
  public QualType getUnderlyingType() /*const*/ {
    return new QualType(UnderlyingType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3653,
   FQN="clang::UnaryTransformType::getBaseType", NM="_ZNK5clang18UnaryTransformType11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18UnaryTransformType11getBaseTypeEv")
  //</editor-fold>
  public QualType getBaseType() /*const*/ {
    return new QualType(BaseType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::getUTTKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3655,
   FQN="clang::UnaryTransformType::getUTTKind", NM="_ZNK5clang18UnaryTransformType10getUTTKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18UnaryTransformType10getUTTKindEv")
  //</editor-fold>
  public UTTKind getUTTKind() /*const*/ {
    return UKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3657,
   FQN="clang::UnaryTransformType::classof", NM="_ZN5clang18UnaryTransformType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18UnaryTransformType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.UnaryTransform;
  }

  @Override public String toString() {
    return "" + "BaseType=" + BaseType // NOI18N
              + ", UnderlyingType=" + UnderlyingType // NOI18N
              + ", UKind=" + UKind // NOI18N
              + super.toString(); // NOI18N
  }
}
