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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// ConstantDataSequential - A vector or array constant whose element type is a
/// simple 1/2/4/8-byte integer or float/double, and whose elements are just
/// simple data values (i.e. ConstantInt/ConstantFP).  This Constant node has no
/// operands because it stores all of the elements of the constant as densely
/// packed data, instead of as Value*'s.
///
/// This is the common base class of ConstantDataArray and ConstantDataVector.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 542,
 FQN="llvm::ConstantDataSequential", NM="_ZN4llvm22ConstantDataSequentialE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequentialE")
//</editor-fold>
public class ConstantDataSequential extends /*public*/ ConstantData implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /// A pointer to the bytes underlying this constant (which is owned by the
  /// uniquing StringMap).
  private /*const*/char$ptr/*char P*/ DataElements;
  
  /// This forms a link list of ConstantDataSequential nodes that have
  /// the same value but different type.  For example, 0,0,0,1 could be a 4
  /// element array of i8, or a 1-element array of i32.  They'll both end up in
  /// the same StringMap bucket, linked up.
  private ConstantDataSequential /*P*/ Next;
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::ConstantDataSequential">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 553,
   FQN="llvm::ConstantDataSequential::ConstantDataSequential", NM="_ZN4llvm22ConstantDataSequentialC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequentialC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantDataSequential(final /*const*/ ConstantDataSequential /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  
  /*friend  class Constant*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::destroyConstantImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2376,
   FQN="llvm::ConstantDataSequential::destroyConstantImpl", NM="_ZN4llvm22ConstantDataSequential19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequential19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    // Remove the constant from the StringMap.
    final StringMap<ConstantDataSequential /*P*/ > /*&*/ CDSConstants = getType().getContext().pImpl.CDSConstants;
    
    StringMapIterator<ConstantDataSequential /*P*/ > Slot = CDSConstants.find(getRawDataValues());
    assert (Slot.$noteq(CDSConstants.end())) : "CDS not found in uniquing table";
    
    type$ptr<ConstantDataSequential /*P*/ /*P*/> Entry = /*create_type$ptr*/($AddrOf(Slot.$arrow().getValue$Ptr()));
    
    // Remove the entry from the hash table.
    if (!((Entry.$star()).Next != null)) {
      // If there is only one value in the bucket (common case) it must be this
      // entry, and removing the entry should remove the bucket completely.
      assert ((Entry.$star()) == this) : "Hash mismatch in ConstantDataSequential";
      getContext().pImpl.CDSConstants.erase(/*NO_COPY*/Slot);
    } else {
      // Otherwise, there are multiple entries linked off the bucket, unlink the 
      // node we care about but keep the bucket around.
      for (ConstantDataSequential /*P*/ Node = Entry.$star();; Entry = $tryClone($AddrOf(/*create_type$ptr2ConstT*/(Node.Next$Ptr))) , Node = Entry.$star()) {
        assert ((Node != null)) : "Didn't find entry in its uniquing hash table!";
        // If we found our entry, unlink it from the list and we're done.
        if (Node == this) {
          Entry.$set(Node.Next);
          break;
        }
      }
    }
    
    // If we were part of a list, make sure that we don't delete the list that is
    // still owned by the uniquing map.
    Next = null;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::ConstantDataSequential">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 559,
   FQN="llvm::ConstantDataSequential::ConstantDataSequential", NM="_ZN4llvm22ConstantDataSequentialC1EPNS_4TypeENS_5Value7ValueTyEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequentialC1EPNS_4TypeENS_5Value7ValueTyEPKc")
  //</editor-fold>
  protected /*explicit*/ ConstantDataSequential(Type /*P*/ ty, Value.ValueTy VT, /*const*/char$ptr/*char P*/ Data) {
    // : ConstantData(ty, VT), DataElements(Data), Next(null) 
    //START JInit
    super(ty, VT);
    this.DataElements = $tryClone(Data);
    this.Next = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::~ConstantDataSequential">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 561,
   FQN="llvm::ConstantDataSequential::~ConstantDataSequential", NM="_ZN4llvm22ConstantDataSequentialD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequentialD0Ev")
  //</editor-fold>
  @Override public/*protected*/ void $destroy()/* override*/ {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Next);
    super.$destroy();
  }

  
  
  /// This is the underlying implementation of all of the
  /// ConstantDataSequential::get methods.  They all thunk down to here, providing
  /// the correct element type.  We take the bytes in as a StringRef because
  /// we *want* an underlying "char*" to avoid TBAA type punning violations.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2344,
   FQN="llvm::ConstantDataSequential::getImpl", NM="_ZN4llvm22ConstantDataSequential7getImplENS_9StringRefEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequential7getImplENS_9StringRefEPNS_4TypeE")
  //</editor-fold>
  protected static Constant /*P*/ getImpl(StringRef Elements, Type /*P*/ Ty) {
    assert (isElementTypeCompatible(Ty.getSequentialElementType()));
    // If the elements are all zero or there are no elements, return a CAZ, which
    // is more dense and canonical.
    if (ConstantsStatics.isAllZeros(new StringRef(Elements))) {
      return ConstantAggregateZero.get(Ty);
    }
    
    // Do a lookup to see if we have already formed one of these.
    final StringMapEntry<ConstantDataSequential /*P*/ > /*&*/ Slot = Ty.getContext().
        pImpl.CDSConstants.insert(new std.pairTypePtr<StringRef, ConstantDataSequential /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(/*Fwd2*/Elements)), (ConstantDataSequential /*P*/ )null)).
        first.$star();
    
    // The bucket can point to a linked list of different CDS's that have the same
    // body but different types.  For example, 0,0,0,1 could be a 4 element array
    // of i8, or a 1-element array of i32.  They'll both end up in the same
    /// StringMap bucket, linked up by their Next pointers.  Walk the list.
    type$ptr<ConstantDataSequential /*P*/ /*P*/> Entry = $tryClone($AddrOf(/*create_type$ptr2ConstT*/(Slot.getValue$Ptr())));
    for (ConstantDataSequential /*P*/ Node = Entry.$star(); (Node != null);
         Entry = $tryClone($AddrOf(/*create_type$ptr2ConstT*/(Node.Next$Ptr))) , Node = Entry.$star())  {
      if (Node.getType() == Ty) {
        return Node;
      }
    }
    
    // Okay, we didn't get a hit.  Create a node of the right class, link it in,
    // and return it.
    if (isa_ArrayType(Ty)) {
      return Entry.$set(/*NEW_EXPR [ConstantDataArray::new]*/ConstantDataArray.$new_ConstantDataArray((type$ptr<?> New$Mem)->{
          return new ConstantDataArray(Ty, Slot.first().data());
       }));
    }
    assert (isa_VectorType(Ty));
    return Entry.$set(/*NEW_EXPR [ConstantDataVector::new]*/ConstantDataVector.$new_ConstantDataVector((type$ptr<?> New$Mem)->{
        return new ConstantDataVector(Ty, Slot.first().data());
     }));
  }

/*public:*/
  /// Return true if a ConstantDataSequential can be formed with a vector or
  /// array of the specified element type.
  /// ConstantDataArray only works with normal float and int types that are
  /// stored densely in memory, not with things like i42 or x86_f80.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::isElementTypeCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2299,
   FQN="llvm::ConstantDataSequential::isElementTypeCompatible", NM="_ZN4llvm22ConstantDataSequential23isElementTypeCompatibleEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequential23isElementTypeCompatibleEPNS_4TypeE")
  //</editor-fold>
  public static boolean isElementTypeCompatible(Type /*P*/ Ty) {
    if (Ty.isHalfTy() || Ty.isFloatTy() || Ty.isDoubleTy()) {
      return true;
    }
    {
      IntegerType /*P*/ IT = dyn_cast_IntegerType(Ty);
      if ((IT != null)) {
        switch (IT.getBitWidth()) {
         case 8:
         case 16:
         case 32:
         case 64:
          return true;
         default:
          break;
        }
      }
    }
    return false;
  }

  
  /// If this is a sequential container of integers (of any size), return the
  /// specified element in the low bits of a uint64_t.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2585,
   FQN="llvm::ConstantDataSequential::getElementAsInteger", NM="_ZNK4llvm22ConstantDataSequential19getElementAsIntegerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential19getElementAsIntegerEj")
  //</editor-fold>
  public long/*uint64_t*/ getElementAsInteger(/*uint*/int Elt) /*const*/ {
    assert (isa_IntegerType(getElementType())) : "Accessor can only be used when element is an integer";
    /*const*/char$ptr/*char P*/ EltPtr = $tryClone(getElementPointer(Elt));
    
    // The data is stored in host byte order, make sure to cast back to the right
    // type to load with the right endianness.
    switch (getElementType().getIntegerBitWidth()) {
     default:
      throw new llvm_unreachable("Invalid bitwidth for CDS");
     case 8:
      return $uchar2ulong(((/*const_cast*//*uint8_t*/uchar$ptr )(reinterpret_cast(/*const*//*uint8_t*/uchar$ptr .class, EltPtr))).$star());
     case 16:
      return $ushort2ulong(((/*const_cast*//*uint16_t*/ushort$ptr )(reinterpret_cast(/*const*//*uint16_t*/ushort$ptr .class, EltPtr))).$star());
     case 32:
      return $uint2ulong(((/*const_cast*//*uint32_t P*/uint$ptr )(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, EltPtr))).$star());
     case 64:
      return ((/*const_cast*/ulong$ptr/*uint64_t P*/ )(reinterpret_cast(/*const*/ulong$ptr/*uint64_t P*/ .class, EltPtr))).$star();
    }
  }

  
  /// If this is a sequential container of floating point type, return the
  /// specified element as an APFloat.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementAsAPFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2605,
   FQN="llvm::ConstantDataSequential::getElementAsAPFloat", NM="_ZNK4llvm22ConstantDataSequential19getElementAsAPFloatEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential19getElementAsAPFloatEj")
  //</editor-fold>
  public APFloat getElementAsAPFloat(/*uint*/int Elt) /*const*/ {
    /*const*/char$ptr/*char P*/ EltPtr = $tryClone(getElementPointer(Elt));
    switch (getElementType().getTypeID()) {
     default:
      throw new llvm_unreachable("Accessor can only be used when element is float/double!");
     case HalfTyID:
      {
        /*uint16_t*/char EltVal = reinterpret_cast(/*const*//*uint16_t*/ushort$ptr .class, EltPtr).$star();
        return new APFloat(APFloat.IEEEhalf, new APInt(JD$UInt_ULong.INSTANCE, 16, $ushort2ulong(EltVal)));
      }
     case FloatTyID:
      {
        /*uint32_t*/int EltVal = reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, EltPtr).$star();
        return new APFloat(APFloat.IEEEsingle, new APInt(JD$UInt_ULong.INSTANCE, 32, $uint2ulong(EltVal)));
      }
     case DoubleTyID:
      {
        long/*uint64_t*/ EltVal = reinterpret_cast(/*const*/ulong$ptr/*uint64_t P*/ .class, EltPtr).$star();
        return new APFloat(APFloat.IEEEdouble, new APInt(JD$UInt_ULong.INSTANCE, 64, EltVal));
      }
    }
  }

  
  /// If this is an sequential container of floats, return the specified element
  /// as a float.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementAsFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2626,
   FQN="llvm::ConstantDataSequential::getElementAsFloat", NM="_ZNK4llvm22ConstantDataSequential17getElementAsFloatEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential17getElementAsFloatEj")
  //</editor-fold>
  public float getElementAsFloat(/*uint*/int Elt) /*const*/ {
    assert (getElementType().isFloatTy()) : "Accessor can only be used when element is a 'float'";
    /*const*//*float P*/float$ptr EltPtr = $tryClone(reinterpret_cast(/*const*//*float P*/float$ptr .class, getElementPointer(Elt)));
    return ((/*const_cast*//*float P*/float$ptr )(EltPtr)).$star();
  }

  
  /// If this is an sequential container of doubles, return the specified
  /// element as a double.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementAsDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2633,
   FQN="llvm::ConstantDataSequential::getElementAsDouble", NM="_ZNK4llvm22ConstantDataSequential18getElementAsDoubleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential18getElementAsDoubleEj")
  //</editor-fold>
  public double getElementAsDouble(/*uint*/int Elt) /*const*/ {
    assert (getElementType().isDoubleTy()) : "Accessor can only be used when element is a 'float'";
    /*const*//*double P*/double$ptr EltPtr = $tryClone(reinterpret_cast(/*const*//*double P*/double$ptr .class, getElementPointer(Elt)));
    return ((/*const_cast*//*double P*/double$ptr )(EltPtr)).$star();
  }

  
  /// Return a Constant for a specified index's element.
  /// Note that this has to compute a new constant to return, so it isn't as
  /// efficient as getElementAsInteger/Float/Double.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementAsConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2641,
   FQN="llvm::ConstantDataSequential::getElementAsConstant", NM="_ZNK4llvm22ConstantDataSequential20getElementAsConstantEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential20getElementAsConstantEj")
  //</editor-fold>
  public Constant /*P*/ getElementAsConstant(/*uint*/int Elt) /*const*/ {
    if (getElementType().isHalfTy() || getElementType().isFloatTy()
       || getElementType().isDoubleTy()) {
      return ConstantFP.get(getContext(), getElementAsAPFloat(Elt));
    }
    
    return ConstantInt.get(getElementType(), getElementAsInteger(Elt));
  }

  
  /// Specialize the getType() method to always return a SequentialType, which
  /// reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 595,
   FQN="llvm::ConstantDataSequential::getType", NM="_ZNK4llvm22ConstantDataSequential7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential7getTypeEv")
  //</editor-fold>
  public /*inline*/ SequentialType /*P*/ getType() /*const*/ {
    return cast_SequentialType(super.getType());
  }

  
  /// Return the element type of the array/vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2291,
   FQN="llvm::ConstantDataSequential::getElementType", NM="_ZNK4llvm22ConstantDataSequential14getElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential14getElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getElementType() /*const*/ {
    return getType().getElementType();
  }

  
  /// Return the number of elements in the array or vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2314,
   FQN="llvm::ConstantDataSequential::getNumElements", NM="_ZNK4llvm22ConstantDataSequential14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    {
      ArrayType /*P*/ AT = dyn_cast_ArrayType(getType());
      if ((AT != null)) {
        return $ulong2uint(AT.getNumElements());
      }
    }
    return getType().getVectorNumElements();
  }

  
  /// Return the size (in bytes) of each element in the array/vector.
  /// The size of the elements is known to be a multiple of one byte.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementByteSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2321,
   FQN="llvm::ConstantDataSequential::getElementByteSize", NM="_ZNK4llvm22ConstantDataSequential18getElementByteSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential18getElementByteSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getElementByteSize() /*const*/ {
    return $uint2ulong($div_uint(getElementType().getPrimitiveSizeInBits(), 8));
  }

  
  /// This method returns true if this is an array of i8.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::isString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2649,
   FQN="llvm::ConstantDataSequential::isString", NM="_ZNK4llvm22ConstantDataSequential8isStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential8isStringEv")
  //</editor-fold>
  public boolean isString() /*const*/ {
    return isa_ArrayType(getType()) && getElementType().isIntegerTy(8);
  }

  
  /// This method returns true if the array "isString", ends with a null byte,
  /// and does not contains any other null bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::isCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2653,
   FQN="llvm::ConstantDataSequential::isCString", NM="_ZNK4llvm22ConstantDataSequential9isCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential9isCStringEv")
  //</editor-fold>
  public boolean isCString() /*const*/ {
    if (!isString()) {
      return false;
    }
    
    StringRef Str = getAsString();
    
    // The last value must be nul.
    if (Str.back() != 0) {
      return false;
    }
    
    // Other elements must be non-nul.
    return Str.drop_back().find($int2char(0)) == StringRef.npos;
  }

  
  /// If this array is isString(), then this method returns the array as a
  /// StringRef. Otherwise, it asserts out.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 618,
   FQN="llvm::ConstantDataSequential::getAsString", NM="_ZNK4llvm22ConstantDataSequential11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential11getAsStringEv")
  //</editor-fold>
  public StringRef getAsString() /*const*/ {
    assert (isString()) : "Not a string";
    return getRawDataValues();
  }

  
  /// If this array is isCString(), then this method returns the array (without
  /// the trailing null byte) as a StringRef. Otherwise, it asserts out.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getAsCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 625,
   FQN="llvm::ConstantDataSequential::getAsCString", NM="_ZNK4llvm22ConstantDataSequential12getAsCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential12getAsCStringEv")
  //</editor-fold>
  public StringRef getAsCString() /*const*/ {
    assert (isCString()) : "Isn't a C string";
    StringRef Str = getAsString();
    return Str.substr(0, Str.size() - 1);
  }

  
  /// Return the raw, underlying, bytes of this data. Note that this is an
  /// extremely tricky thing to work with, as it exposes the host endianness of
  /// the data elements.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getRawDataValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2295,
   FQN="llvm::ConstantDataSequential::getRawDataValues", NM="_ZNK4llvm22ConstantDataSequential16getRawDataValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential16getRawDataValuesEv")
  //</editor-fold>
  public StringRef getRawDataValues() /*const*/ {
    return new StringRef(DataElements, $ullong2uint($uint2ullong(getNumElements()) * getElementByteSize()));
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 637,
   FQN="llvm::ConstantDataSequential::classof", NM="_ZN4llvm22ConstantDataSequential7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm22ConstantDataSequential7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantDataArrayVal.getValue()
       || V.getValueID() == ValueTy.ConstantDataVectorVal.getValue();
  }

/*private:*/
  
  /// Return the start of the specified element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataSequential::getElementPointer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2326,
   FQN="llvm::ConstantDataSequential::getElementPointer", NM="_ZNK4llvm22ConstantDataSequential17getElementPointerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm22ConstantDataSequential17getElementPointerEj")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ getElementPointer(/*uint*/int Elt) /*const*/ {
    assert ($less_uint(Elt, getNumElements())) : "Invalid Elt";
    return DataElements.$add($ulong2uint($uint2ullong(Elt) * getElementByteSize()));
  }

  private final type$ptr<ConstantDataSequential/*P*/> /*P*/ Next$Ptr = new type$ptr$inout<ConstantDataSequential/*P*/>() {
    @Override
    protected ConstantDataSequential/*P*/ $star$impl() {
      return Next;
    }

    @Override
    protected ConstantDataSequential/*P*/ $set$impl(ConstantDataSequential/*P*/ value) {
      return Next = value;
    }
  };
  
  @Override public String toString() {
    return "" + "DataElements=" + DataElements // NOI18N
              + ", Next=" + Next // NOI18N
              + super.toString(); // NOI18N
  }
}
