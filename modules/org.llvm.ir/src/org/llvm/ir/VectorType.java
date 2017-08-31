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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.impl.*;
import org.llvm.support.BumpPtrAllocatorImpl;


/// Class to represent vector types.
//<editor-fold defaultstate="collapsed" desc="llvm::VectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 365,
 FQN="llvm::VectorType", NM="_ZN4llvm10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorTypeE")
//</editor-fold>
public class VectorType extends /*public*/ SequentialType {
  private /*uint*/int NumElements;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::VectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 368,
   FQN="llvm::VectorType::VectorType", NM="_ZN4llvm10VectorTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorTypeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ VectorType(final /*const*/ VectorType /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 369,
   FQN="llvm::VectorType::operator=", NM="_ZN4llvm10VectorTypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorTypeaSERKS0_")
  //</editor-fold>
  protected/*private*/ /*const*/ VectorType /*&*/ $assign(final /*const*/ VectorType /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //===----------------------------------------------------------------------===//
  //                          VectorType Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::VectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 630,
   FQN="llvm::VectorType::VectorType", NM="_ZN4llvm10VectorTypeC1EPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorTypeC1EPNS_4TypeEj")
  //</editor-fold>
  private VectorType(Type /*P*/ ElType, /*uint*/int NumEl) {
    // : SequentialType(VectorTyID, ElType) 
    //START JInit
    super(TypeID.VectorTyID, ElType);
    //END JInit
    NumElements = NumEl;
  }

/*public:*/
  /// This static method is the primary way to construct an VectorType.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 635,
   FQN="llvm::VectorType::get", NM="_ZN4llvm10VectorType3getEPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType3getEPNS_4TypeEj")
  //</editor-fold>
  public static VectorType /*P*/ get(Type /*P*/ ElementType, /*uint*/int NumElements) {
    assert ($greater_uint(NumElements, 0)) : "#Elements of a VectorType must be greater than 0";
    assert (isValidElementType(ElementType)) : "Element type of a VectorType must be an integer, floating point, or pointer type.";
    
    LLVMContextImpl /*P*/ pImpl = ElementType.getContext().pImpl;
    final type$ref<VectorType /*P*/ /*&*/> Entry = ElementType.getContext().pImpl.
        VectorTypes.ref$at(std.make_pair_Ptr_uint(ElementType, NumElements));
    if (!(Entry.$deref() != null)) {
      Entry.$set(((/*JCast*/VectorType /*P*/ )(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
      /*pImpl.TypeAllocator =*/ /*new (pImpl->TypeAllocator)*/ VectorType.$new_uint_BumpPtrAllocatorImpl$AllocatorT(pImpl.TypeAllocator, (type$ptr<?> New$Mem)->{
          return new VectorType(ElementType, NumElements);
       }))));
    }
    return Entry.$deref();
  }

  
  /// This static method gets a VectorType with the same number of elements as
  /// the input type, and the element type is an integer type of the same width
  /// as the input element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 379,
   FQN="llvm::VectorType::getInteger", NM="_ZN4llvm10VectorType10getIntegerEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType10getIntegerEPS0_")
  //</editor-fold>
  public static VectorType /*P*/ getInteger(VectorType /*P*/ VTy) {
    /*uint*/int EltBits = VTy.getElementType().getPrimitiveSizeInBits();
    assert ((EltBits != 0)) : "Element size must be of a non-zero size";
    Type /*P*/ EltTy = IntegerType.get(VTy.getContext(), EltBits);
    return VectorType.get(EltTy, VTy.getNumElements());
  }

  
  /// This static method is like getInteger except that the element types are
  /// twice as wide as the elements in the input type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getExtendedElementVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 388,
   FQN="llvm::VectorType::getExtendedElementVectorType", NM="_ZN4llvm10VectorType28getExtendedElementVectorTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType28getExtendedElementVectorTypeEPS0_")
  //</editor-fold>
  public static VectorType /*P*/ getExtendedElementVectorType(VectorType /*P*/ VTy) {
    /*uint*/int EltBits = VTy.getElementType().getPrimitiveSizeInBits();
    Type /*P*/ EltTy = IntegerType.get(VTy.getContext(), EltBits * 2);
    return VectorType.get(EltTy, VTy.getNumElements());
  }

  
  /// This static method is like getInteger except that the element types are
  /// half as wide as the elements in the input type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getTruncatedElementVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 396,
   FQN="llvm::VectorType::getTruncatedElementVectorType", NM="_ZN4llvm10VectorType29getTruncatedElementVectorTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType29getTruncatedElementVectorTypeEPS0_")
  //</editor-fold>
  public static VectorType /*P*/ getTruncatedElementVectorType(VectorType /*P*/ VTy) {
    /*uint*/int EltBits = VTy.getElementType().getPrimitiveSizeInBits();
    assert ((EltBits & 1) == 0) : "Cannot truncate vector element with odd bit-width";
    Type /*P*/ EltTy = IntegerType.get(VTy.getContext(), $div_uint(EltBits, 2));
    return VectorType.get(EltTy, VTy.getNumElements());
  }

  
  /// This static method returns a VectorType with half as many elements as the
  /// input type and the same element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getHalfElementsVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 406,
   FQN="llvm::VectorType::getHalfElementsVectorType", NM="_ZN4llvm10VectorType25getHalfElementsVectorTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType25getHalfElementsVectorTypeEPS0_")
  //</editor-fold>
  public static VectorType /*P*/ getHalfElementsVectorType(VectorType /*P*/ VTy) {
    /*uint*/int NumElts = VTy.getNumElements();
    assert ((NumElts & 1) == 0) : "Cannot halve vector with odd number of elements.";
    return VectorType.get(VTy.getElementType(), $div_uint(NumElts, 2));
  }

  
  /// This static method returns a VectorType with twice as many elements as the
  /// input type and the same element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getDoubleElementsVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 415,
   FQN="llvm::VectorType::getDoubleElementsVectorType", NM="_ZN4llvm10VectorType27getDoubleElementsVectorTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType27getDoubleElementsVectorTypeEPS0_")
  //</editor-fold>
  public static VectorType /*P*/ getDoubleElementsVectorType(VectorType /*P*/ VTy) {
    /*uint*/int NumElts = VTy.getNumElements();
    return VectorType.get(VTy.getElementType(), NumElts * 2);
  }

  
  /// Return true if the specified type is valid as a element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::isValidElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 650,
   FQN="llvm::VectorType::isValidElementType", NM="_ZN4llvm10VectorType18isValidElementTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType18isValidElementTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isValidElementType(Type /*P*/ ElemTy) {
    return ElemTy.isIntegerTy() || ElemTy.isFloatingPointTy()
       || ElemTy.isPointerTy();
  }

  
  /// Return the number of elements in the Vector type.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 424,
   FQN="llvm::VectorType::getNumElements", NM="_ZNK4llvm10VectorType14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10VectorType14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return NumElements;
  }

  
  /// Return the number of bits in the Vector type.
  /// Returns zero when the vector is a vector of pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 428,
   FQN="llvm::VectorType::getBitWidth", NM="_ZNK4llvm10VectorType11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10VectorType11getBitWidthEv")
  //</editor-fold>
  public /*uint*/int getBitWidth() /*const*/ {
    return NumElements * getElementType().getPrimitiveSizeInBits();
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::VectorType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 433,
   FQN="llvm::VectorType::classof", NM="_ZN4llvm10VectorType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10VectorType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.VectorTyID;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected static <T> T $new_uint_BumpPtrAllocatorImpl$AllocatorT(BumpPtrAllocatorImpl alloc, NativeCallback.New$ConstructorCallback<T/*P*/> New$Type) {
    return New$Type.$call(null);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumElements=" + NumElements // NOI18N
              + super.toString(); // NOI18N
  }
}
