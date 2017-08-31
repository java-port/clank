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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.llvmc.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.impl.DataLayoutStatics.*;


/// \brief A parsed version of the target data layout string in and methods for
/// querying it.
///
/// The target data layout string is specified *by the target* - a frontend
/// generating LLVM IR is required to generate the right target data for the
/// target being codegen'd to.
//<editor-fold defaultstate="collapsed" desc="llvm::DataLayout">
@Converted(kind = Converted.Kind.MANUAL/*not all bodies are generated, only needed by tests*/,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 101,
 FQN="llvm::DataLayout", NM="_ZN4llvm10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutE")
//</editor-fold>
public class DataLayout implements Destructors.ClassWithDestructor, Native.NativeComparable<DataLayout>, LLVMOpaqueTargetData {
/*private:*/
  /// Defaults to false.
  private boolean BigEndian;
  
  private /*uint*/int StackNaturalAlign;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::ManglingModeT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 108,
   FQN="llvm::DataLayout::ManglingModeT", NM="_ZN4llvm10DataLayout13ManglingModeTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout13ManglingModeTE")
  //</editor-fold>
  private enum ManglingModeT implements Native.NativeUIntEnum {
    MM_None(0),
    MM_ELF(MM_None.getValue() + 1),
    MM_MachO(MM_ELF.getValue() + 1),
    MM_WinCOFF(MM_MachO.getValue() + 1),
    MM_WinCOFFX86(MM_WinCOFF.getValue() + 1),
    MM_Mips(MM_WinCOFFX86.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ManglingModeT valueOf(int val) {
      ManglingModeT out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ManglingModeT[] VALUES;
      private static final ManglingModeT[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ManglingModeT kind : ManglingModeT.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ManglingModeT[min < 0 ? (1-min) : 0];
        VALUES = new ManglingModeT[max >= 0 ? (1+max) : 0];
        for (ManglingModeT kind : ManglingModeT.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ManglingModeT(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private ManglingModeT ManglingMode;
  
  private SmallVectorUChar LegalIntWidths;
  
  /// \brief Primitive type alignment data.
  private SmallVector<LayoutAlignElem> Alignments;
  
  /// \brief The string representation used to create this DataLayout
  private std.string StringRepresentation;
  
  // JAVA: typedef SmallVector<PointerAlignElem, 8> PointersTy
//  public final class PointersTy extends SmallVector<PointerAlignElem>{ };
  private SmallVector<PointerAlignElem> Pointers;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::findPointerLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 129,
   FQN="llvm::DataLayout::findPointerLowerBound", NM="_ZNK4llvm10DataLayout21findPointerLowerBoundEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout21findPointerLowerBoundEj")
  //</editor-fold>
  private type$ptr</*const*/ PointerAlignElem /*P*/ > findPointerLowerBound$Const(/*uint32_t*/int AddressSpace) /*const*/ {
    return ((/*const_cast*/DataLayout /*P*/ )(this)).findPointerLowerBound(AddressSpace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::findPointerLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 429,
   FQN="llvm::DataLayout::findPointerLowerBound", NM="_ZN4llvm10DataLayout21findPointerLowerBoundEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout21findPointerLowerBoundEj")
  //</editor-fold>
  private type$ptr<PointerAlignElem> findPointerLowerBound(/*uint32_t*/int AddressSpace) {
    return std.lower_bound(Pointers.begin(), Pointers.end(), (Integer)AddressSpace, 
        /*[]*/ (final /*const*/ PointerAlignElem /*&*/ A, /*uint32_t*/Integer AddressSpace$1) -> {
              return $less_uint(A.AddressSpace, AddressSpace$1);
            });
  }

  
  /// This member is a signal that a requested alignment type and bit width were
  /// not found in the SmallVector.
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION)
  private static /*const*/ LayoutAlignElem InvalidAlignmentElem = new LayoutAlignElem(AlignTypeEnum.INVALID_ALIGN, 0, 0, 0);
  
  /// This member is a signal that a requested pointer type and bit width were
  /// not found in the DenseSet.
  private static /*const*/ PointerAlignElem InvalidPointerElem = new PointerAlignElem(0/*U*/, 0/*U*/, 0/*U*/, ~0/*U*/);
  
  // The StructType -> StructLayout map.
  private /*mutable */Object/*void P*/ LayoutMap;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 397,
   FQN="llvm::DataLayout::setAlignment", NM="_ZN4llvm10DataLayout12setAlignmentENS_13AlignTypeEnumEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout12setAlignmentENS_13AlignTypeEnumEjjj")
  //</editor-fold>
  private void setAlignment(/*AlignTypeEnum*/byte align_type, /*uint*/int abi_align, 
              /*uint*/int pref_align, /*uint32_t*/int bit_width) {
    if (!isUInt24($uint2ulong(bit_width))) {
      report_fatal_error($("Invalid bit width, must be a 24bit integer"));
    }
    if (!isUInt16($uint2ulong(abi_align))) {
      report_fatal_error($("Invalid ABI alignment, must be a 16bit integer"));
    }
    if (!isUInt16($uint2ulong(pref_align))) {
      report_fatal_error($("Invalid preferred alignment, must be a 16bit integer"));
    }
    if (abi_align != 0 && !isPowerOf2_64($uint2ulong(abi_align))) {
      report_fatal_error($("Invalid ABI alignment, must be a power of 2"));
    }
    if (pref_align != 0 && !isPowerOf2_64($uint2ulong(pref_align))) {
      report_fatal_error($("Invalid preferred alignment, must be a power of 2"));
    }
    if ($less_uint(pref_align, abi_align)) {
      report_fatal_error($("Preferred alignment cannot be less than the ABI alignment"));
    }
    
    for (final LayoutAlignElem /*&*/ Elem : Alignments) {
      if ($8bits_uint2uint(Elem.AlignType) == (/*uint*/int)align_type
         && Elem.TypeBitWidth == bit_width) {
        // Update the abi, preferred alignments.
        Elem.ABIAlign = $uint2uint_16bits(abi_align);
        Elem.PrefAlign = $uint2uint_16bits(pref_align);
        return;
      }
    }
    
    Alignments.push_back(LayoutAlignElem.get(align_type, abi_align, 
            pref_align, bit_width));
  }

  
  /// getAlignmentInfo - Return the alignment (either ABI if ABIInfo = true or
  /// preferred if ABIInfo = false) the layout wants for the specified datatype.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getAlignmentInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 457,
   FQN="llvm::DataLayout::getAlignmentInfo", NM="_ZNK4llvm10DataLayout16getAlignmentInfoENS_13AlignTypeEnumEjbPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout16getAlignmentInfoENS_13AlignTypeEnumEjbPNS_4TypeE")
  //</editor-fold>
  private /*uint*/int getAlignmentInfo(/*AlignTypeEnum*/byte AlignType, 
                  /*uint32_t*/int BitWidth, boolean ABIInfo, 
                  Type /*P*/ Ty) /*const*/ {
    // Check to see if we have an exact match and remember the best match we see.
    int BestMatchIdx = -1;
    int LargestInt = -1;
    for (/*uint*/int i = 0, e = Alignments.size(); i != e; ++i) {
      if ($8bits_uint2uint(Alignments.$at$Const(i).AlignType) == (/*uint*/int)AlignType
         && Alignments.$at$Const(i).TypeBitWidth == BitWidth) {
        return ABIInfo ? $16bits_uint2uint(Alignments.$at$Const(i).ABIAlign) : $16bits_uint2uint(Alignments.$at$Const(i).PrefAlign);
      }
      
      // The best match so far depends on what we're looking for.
      if (AlignType == AlignTypeEnum.INTEGER_ALIGN
         && $8bits_uint2uint(Alignments.$at$Const(i).AlignType) == AlignTypeEnum.INTEGER_ALIGN) {
        // The "best match" for integers is the smallest size that is larger than
        // the BitWidth requested.
        if ($greater_uint(Alignments.$at$Const(i).TypeBitWidth, BitWidth) && (BestMatchIdx == -1
           || Alignments.$at$Const(i).TypeBitWidth < Alignments.$at$Const(BestMatchIdx).TypeBitWidth)) {
          BestMatchIdx = i;
        }
        // However, if there isn't one that's larger, then we must use the
        // largest one we have (see below)
        if (LargestInt == -1
           || Alignments.$at$Const(i).TypeBitWidth > Alignments.$at$Const(LargestInt).TypeBitWidth) {
          LargestInt = i;
        }
      }
    }
    
    // Okay, we didn't find an exact solution.  Fall back here depending on what
    // is being looked for.
    if (BestMatchIdx == -1) {
      // If we didn't find an integer alignment, fall back on most conservative.
      if (AlignType == AlignTypeEnum.INTEGER_ALIGN) {
        BestMatchIdx = LargestInt;
      } else if (AlignType == AlignTypeEnum.VECTOR_ALIGN) {
        // By default, use natural alignment for vector types. This is consistent
        // with what clang and llvm-gcc do.
        /*uint*/int Align = $ulong2uint(getTypeAllocSize(cast_VectorType(Ty).getElementType()));
        Align *= cast_VectorType(Ty).getNumElements();
        // If the alignment is not a power of 2, round up to the next power of 2.
        // This happens for non-power-of-2 length vectors.
        if (((Align & (Align - 1)) != 0)) {
          Align = $ulong2uint(NextPowerOf2($uint2ulong(Align)));
        }
        return Align;
      }
    }
    
    // If we still couldn't find a reasonable default alignment, fall back
    // to a simple heuristic that the alignment is the first power of two
    // greater-or-equal to the store size of the type.  This is a reasonable
    // approximation of reality, and if the user wanted something less
    // less conservative, they should have specified it explicitly in the data
    // layout.
    if (BestMatchIdx == -1) {
      /*uint*/int Align = $ulong2uint(getTypeStoreSize(Ty));
      if (((Align & (Align - 1)) != 0)) {
        Align = $ulong2uint(NextPowerOf2($uint2ulong(Align)));
      }
      return Align;
    }
    
    // Since we got a "best match" index, just return it.
    return ABIInfo ? $16bits_uint2uint(Alignments.$at$Const(BestMatchIdx).ABIAlign) : $16bits_uint2uint(Alignments.$at$Const(BestMatchIdx).PrefAlign);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::setPointerAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 437,
   FQN="llvm::DataLayout::setPointerAlignment", NM="_ZN4llvm10DataLayout19setPointerAlignmentEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout19setPointerAlignmentEjjjj")
  //</editor-fold>
  private void setPointerAlignment(/*uint32_t*/int AddrSpace, /*uint*/int ABIAlign, 
                     /*uint*/int PrefAlign, 
                     /*uint32_t*/int TypeByteWidth) {
    if ($less_uint(PrefAlign, ABIAlign)) {
      report_fatal_error($("Preferred alignment cannot be less than the ABI alignment"));
    }
    
    type$ptr<PointerAlignElem /*P*/ > I = $tryClone(findPointerLowerBound(AddrSpace));
    if ($eq_ptr(I, Pointers.end()) || I./*->*/$star().AddressSpace != AddrSpace) {
      Pointers.insert(I, PointerAlignElem.get(AddrSpace, ABIAlign, PrefAlign, 
              TypeByteWidth));
    } else {
      I./*->*/$star().ABIAlign = ABIAlign;
      I./*->*/$star().PrefAlign = PrefAlign;
      I./*->*/$star().TypeByteWidth = TypeByteWidth;
    }
  }

  
  /// Internal helper method that returns requested alignment for type.
  
  /*!
  \param abi_or_pref Flag that determines which alignment is returned. true
  returns the ABI alignment, false returns the preferred alignment.
  \param Ty The underlying type for which alignment is determined.
  
  Get the ABI (\a abi_or_pref == true) or preferred alignment (\a abi_or_pref
  == false) for the requested type \a Ty.
  */
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 625,
   FQN="llvm::DataLayout::getAlignment", NM="_ZNK4llvm10DataLayout12getAlignmentEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout12getAlignmentEPNS_4TypeEb")
  //</editor-fold>
  private /*uint*/int getAlignment(Type /*P*/ Ty, boolean abi_or_pref) /*const*/ {
    int AlignType = -1;
    assert (Ty.isSized()) : "Cannot getTypeInfo() on a type that is unsized!";
    switch (Ty.getTypeID()) {
     case LabelTyID:
      // Early escape for the non-numeric types.
      return (abi_or_pref ? getPointerABIAlignment(0) : getPointerPrefAlignment(0));
     case PointerTyID:
      {
        /*uint*/int AS = cast_PointerType(Ty).getAddressSpace();
        return (abi_or_pref ? getPointerABIAlignment(AS) : getPointerPrefAlignment(AS));
      }
     case ArrayTyID:
      return getAlignment(cast_ArrayType(Ty).getElementType(), abi_or_pref);
     case StructTyID:
      {
        // Packed structure types always have an ABI alignment of one.
        if (cast_StructType(Ty).isPacked() && abi_or_pref) {
          return 1;
        }
        
        // Get the layout annotation... which is lazily created on demand.
        /*const*/ StructLayout /*P*/ Layout = getStructLayout(cast_StructType(Ty));
        /*uint*/int Align = getAlignmentInfo(AlignTypeEnum.AGGREGATE_ALIGN, 0, abi_or_pref, Ty);
        return std.max(Align, Layout.getAlignment());
      }
     case IntegerTyID:
      AlignType = AlignTypeEnum.INTEGER_ALIGN;
      break;
     case HalfTyID:
     case FloatTyID:
     case DoubleTyID:
     case PPC_FP128TyID:
     case FP128TyID:
     case X86_FP80TyID:
      // PPC_FP128TyID and FP128TyID have different data contents, but the
      // same size and alignment, so they look the same here.
      AlignType = AlignTypeEnum.FLOAT_ALIGN;
      break;
     case X86_MMXTyID:
     case VectorTyID:
      AlignType = AlignTypeEnum.VECTOR_ALIGN;
      break;
     default:
      throw new llvm_unreachable("Bad type for getAlignment!!!");
    }
    
    return getAlignmentInfo((/*AlignTypeEnum*/byte)AlignType, $ulong2uint(getTypeSizeInBits(Ty)), 
        abi_or_pref, Ty);
  }

  
  /// \brief Valid alignment predicate.
  ///
  /// Predicate that tests a LayoutAlignElem reference returned by get() against
  /// InvalidAlignmentElem.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::validAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 161,
   FQN="llvm::DataLayout::validAlignment", NM="_ZNK4llvm10DataLayout14validAlignmentERKNS_15LayoutAlignElemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout14validAlignmentERKNS_15LayoutAlignElemE")
  //</editor-fold>
  private boolean validAlignment(final /*const*/ LayoutAlignElem /*&*/ align) /*const*/ {
    return /*AddrOf*/align != /*AddrOf*/InvalidAlignmentElem;
  }

  
  /// \brief Valid pointer predicate.
  ///
  /// Predicate that tests a PointerAlignElem reference returned by get()
  /// against \c InvalidPointerElem.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::validPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 169,
   FQN="llvm::DataLayout::validPointer", NM="_ZNK4llvm10DataLayout12validPointerERKNS_16PointerAlignElemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout12validPointerERKNS_16PointerAlignElemE")
  //</editor-fold>
  private boolean validPointer(final /*const*/ PointerAlignElem /*&*/ align) /*const*/ {
    return /*AddrOf*/align != /*AddrOf*/InvalidPointerElem;
  }

  
  /// Parses a target data specification string. Assert if the string is
  /// malformed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::parseSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added asserts*/,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 223,
   FQN="llvm::DataLayout::parseSpecifier", NM="_ZN4llvm10DataLayout14parseSpecifierENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout14parseSpecifierENS_9StringRefE")
  //</editor-fold>
  private void parseSpecifier(StringRef Desc) {
    StringRepresentation.$assignMove(Desc.$string());
    while (!Desc.empty()) {
      // Split at '-'.
      std.pair<StringRef, StringRef> Split = split(new StringRef(Desc), $$MINUS);
      Desc.$assign(Split.second);
      
      // Split at ':'.
      Split.$assignMove(split(new StringRef(Split.first), $$COLON));
      
      // Aliases used below.
      final StringRef /*&*/ Tok = Split.first; // Current token.
      final StringRef /*&*/ Rest = Split.second; // The rest of the string.
      
      /*char*/char Specifier = $uchar2ushort(Tok.front());
      Tok.$assignMove(Tok.substr(1));
      switch (Specifier) {
       case 's':
        // Ignored for backward compatibility.
        // FIXME: remove this on LLVM 4.0.
        break;
       case 'E':
        BigEndian = true;
        break;
       case 'e':
        BigEndian = false;
        break;
       case 'p':
        {
          // Address space.
          /*uint*/int AddrSpace = Tok.empty() ? 0 : getInt(new StringRef(Tok));
          if (!isUInt24($uint2ulong(AddrSpace))) {
            report_fatal_error($("Invalid address space, must be a 24bit integer"));
          }
          
          // Size.
          if (Rest.empty()) {
            report_fatal_error($("Missing size specification for pointer in datalayout string"));
          }
          Split.$assignMove(split(new StringRef(Rest), $$COLON));
          assert Tok == Split.first;
          assert Rest == Split.second;
          /*uint*/int PointerMemSize = inBytes(getInt(new StringRef(Tok)));
          if (!(PointerMemSize != 0)) {
            report_fatal_error($("Invalid pointer size of 0 bytes"));
          }
          
          // ABI alignment.
          if (Rest.empty()) {
            report_fatal_error($("Missing alignment specification for pointer in datalayout string"));
          }
          Split.$assignMove(split(new StringRef(Rest), $$COLON));
          assert Tok == Split.first;
          assert Rest == Split.second;
          /*uint*/int PointerABIAlign = inBytes(getInt(new StringRef(Tok)));
          if (!isPowerOf2_64($uint2ulong(PointerABIAlign))) {
            report_fatal_error($("Pointer ABI alignment must be a power of 2"));
          }
          
          // Preferred alignment.
          /*uint*/int PointerPrefAlign = PointerABIAlign;
          if (!Rest.empty()) {
            Split.$assignMove(split(new StringRef(Rest), $$COLON));
            assert Tok == Split.first;
            assert Rest == Split.second;
            PointerPrefAlign = inBytes(getInt(new StringRef(Tok)));
            if (!isPowerOf2_64($uint2ulong(PointerPrefAlign))) {
              report_fatal_error($("Pointer preferred alignment must be a power of 2"));
            }
          }
          
          setPointerAlignment(AddrSpace, PointerABIAlign, PointerPrefAlign, 
              PointerMemSize);
          break;
        }
       case 'i':
       case 'v':
       case 'f':
       case 'a':
        {
          /*AlignTypeEnum*/byte AlignType;
          switch (Specifier) {
           default:
           case 'i':
            AlignType = AlignTypeEnum.INTEGER_ALIGN;
            break;
           case 'v':
            AlignType = AlignTypeEnum.VECTOR_ALIGN;
            break;
           case 'f':
            AlignType = AlignTypeEnum.FLOAT_ALIGN;
            break;
           case 'a':
            AlignType = AlignTypeEnum.AGGREGATE_ALIGN;
            break;
          }
          
          // Bit size.
          /*uint*/int Size = Tok.empty() ? 0 : getInt(new StringRef(Tok));
          if (AlignType == AlignTypeEnum.AGGREGATE_ALIGN && Size != 0) {
            report_fatal_error($("Sized aggregate specification in datalayout string"));
          }
          
          // ABI alignment.
          if (Rest.empty()) {
            report_fatal_error($("Missing alignment specification in datalayout string"));
          }
          Split.$assignMove(split(new StringRef(Rest), $$COLON));
          assert Tok == Split.first;
          assert Rest == Split.second;
          /*uint*/int ABIAlign = inBytes(getInt(new StringRef(Tok)));
          if (AlignType != AlignTypeEnum.AGGREGATE_ALIGN && !(ABIAlign != 0)) {
            report_fatal_error($("ABI alignment specification must be >0 for non-aggregate types"));
          }
          
          // Preferred alignment.
          /*uint*/int PrefAlign = ABIAlign;
          if (!Rest.empty()) {
            Split.$assignMove(split(new StringRef(Rest), $$COLON));
            assert Tok == Split.first;
            assert Rest == Split.second;
            PrefAlign = inBytes(getInt(new StringRef(Tok)));
          }
          
          setAlignment(AlignType, ABIAlign, PrefAlign, Size);
          
          break;
        }
       case 'n': // Native integer types.
        for (;;) {
          /*uint*/int Width = getInt(new StringRef(Tok));
          if (Width == 0) {
            report_fatal_error($("Zero width native integer type in datalayout string"));
          }
          LegalIntWidths.push_back($uint2uchar(Width));
          if (Rest.empty()) {
            break;
          }
          Split.$assignMove(split(new StringRef(Rest), $$COLON));
          assert Tok == Split.first;
          assert Rest == Split.second;
        }
        break;
       case 'S':
        { // Stack natural alignment.
          StackNaturalAlign = inBytes(getInt(new StringRef(Tok)));
          break;
        }
       case 'm':
        if (!Tok.empty()) {
          report_fatal_error($("Unexpected trailing characters after mangling specifier in datalayout string"));
        }
        if (Rest.empty()) {
          report_fatal_error($("Expected mangling specifier in datalayout string"));
        }
        if ($greater_uint(Rest.size(), 1)) {
          report_fatal_error($("Unknown mangling specifier in datalayout string"));
        }
        switch (Rest.$at(0)) {
         default:
          report_fatal_error($("Unknown mangling in datalayout string"));
         case 'e':
          ManglingMode = ManglingModeT.MM_ELF;
          break;
         case 'o':
          ManglingMode = ManglingModeT.MM_MachO;
          break;
         case 'm':
          ManglingMode = ManglingModeT.MM_Mips;
          break;
         case 'w':
          ManglingMode = ManglingModeT.MM_WinCOFF;
          break;
         case 'x':
          ManglingMode = ManglingModeT.MM_WinCOFFX86;
          break;
        }
        break;
       default:
        report_fatal_error($("Unknown specifier in datalayout string"));
        break;
      }
    }
  }

  
  // Free all internal data structures.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 544,
   FQN="llvm::DataLayout::clear", NM="_ZN4llvm10DataLayout5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout5clearEv")
  //</editor-fold>
  private void clear() {
    LegalIntWidths.clear();
    Alignments.clear();
    Pointers.clear();
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)((/*static_cast*/StructLayoutMap /*P*/ )(LayoutMap)));
    LayoutMap = null;
  }

/*public:*/
  /// Constructs a DataLayout from a specification string. See reset().
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::DataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 182,
   FQN="llvm::DataLayout::DataLayout", NM="_ZN4llvm10DataLayoutC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutC1ENS_9StringRefE")
  //</editor-fold>
  public /*explicit*/ DataLayout(StringRef LayoutDescription) {
    // : LegalIntWidths(), Alignments(), StringRepresentation(), Pointers(), LayoutMap(null) 
    //START JInit
    this.LegalIntWidths = new SmallVectorUChar(8, $$TERM);
    this.Alignments = new SmallVector<LayoutAlignElem>(16, new LayoutAlignElem());
    this.StringRepresentation = new std.string();
    this.Pointers = new SmallVector<PointerAlignElem>(8, new PointerAlignElem());
    this.LayoutMap = null;
    //END JInit
    reset(new StringRef(LayoutDescription));
  }

  
  /// Initialize target data from properties stored in the module.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::DataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 381,
   FQN="llvm::DataLayout::DataLayout", NM="_ZN4llvm10DataLayoutC1EPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutC1EPKNS_6ModuleE")
  //</editor-fold>
  public DataLayout(/*const*/ Module /*P*/ M) {
    // : LegalIntWidths(), Alignments(), StringRepresentation(), Pointers(), LayoutMap(null) 
    //START JInit
    this.LegalIntWidths = new SmallVectorUChar(8, $$TERM);
    this.Alignments = new SmallVector<LayoutAlignElem>(16, new LayoutAlignElem());
    this.StringRepresentation = new std.string();
    this.Pointers = new SmallVector<PointerAlignElem>(8, new PointerAlignElem());
    this.LayoutMap = null;
    //END JInit
    init(M);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 385,
   FQN="llvm::DataLayout::init", NM="_ZN4llvm10DataLayout4initEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout4initEPKNS_6ModuleE")
  //</editor-fold>
  public void init(/*const*/ Module /*P*/ M) {
    /*Deref*/this.$assign(M.getDataLayout());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::DataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 191,
   FQN="llvm::DataLayout::DataLayout", NM="_ZN4llvm10DataLayoutC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutC1ERKS0_")
  //</editor-fold>
  public DataLayout(final /*const*/ DataLayout /*&*/ DL) {
    // : LegalIntWidths(), Alignments(), StringRepresentation(), Pointers(), LayoutMap(null) 
    //START JInit
    this.LegalIntWidths = new SmallVectorUChar(8, $$TERM);
    this.Alignments = new SmallVector<LayoutAlignElem>(16, new LayoutAlignElem());
    this.StringRepresentation = new std.string();
    this.Pointers = new SmallVector<PointerAlignElem>(8, new PointerAlignElem());
    this.LayoutMap = null;
    //END JInit
    /*Deref*/this.$assign(DL);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 193,
   FQN="llvm::DataLayout::operator=", NM="_ZN4llvm10DataLayoutaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutaSERKS0_")
  //</editor-fold>
  public DataLayout /*&*/ $assign(final /*const*/ DataLayout /*&*/ DL) {
    clear();
    StringRepresentation.$assign(DL.StringRepresentation);
    BigEndian = DL.isBigEndian();
    StackNaturalAlign = DL.StackNaturalAlign;
    ManglingMode = DL.ManglingMode;
    LegalIntWidths.$assign(DL.LegalIntWidths);
    Alignments.$assign(DL.Alignments);
    Pointers.$assign(DL.Pointers);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 387,
   FQN="llvm::DataLayout::operator==", NM="_ZNK4llvm10DataLayouteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayouteqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DataLayout /*&*/ Other) /*const*/ {
    if (Other == null) { // JAVA
      return false;
    }
    boolean Ret = BigEndian == Other.BigEndian
       && StackNaturalAlign == Other.StackNaturalAlign
       && ManglingMode == Other.ManglingMode
       && LegalIntWidths.$eq(Other.LegalIntWidths)
       && Alignments.$eq(Other.Alignments) && Pointers.$eq(Other.Pointers);
    // Note: getStringRepresentation() might differs, it is not canonicalized
    return Ret;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 206,
   FQN="llvm::DataLayout::operator!=", NM="_ZNK4llvm10DataLayoutneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayoutneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ DataLayout /*&*/ Other) /*const*/ {
    return !(/*Deref*/this.$eq(Other));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::~DataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 552,
   FQN="llvm::DataLayout::~DataLayout", NM="_ZN4llvm10DataLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayoutD0Ev")
  //</editor-fold>
  public void $destroy() {
    clear();
    //START JDestroy
    Pointers.$destroy();
    StringRepresentation.$destroy();
    Alignments.$destroy();
    LegalIntWidths.$destroy();
    //END JDestroy
  }
 // Not virtual, do not subclass this class
  
  /// Parse a data layout string (with fallback to default values).
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 178,
   FQN="llvm::DataLayout::reset", NM="_ZN4llvm10DataLayout5resetENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout5resetENS_9StringRefE")
  //</editor-fold>
  public void reset(StringRef Desc) {
    clear();
    
    LayoutMap = null;
    BigEndian = false;
    StackNaturalAlign = 0;
    ManglingMode = ManglingModeT.MM_None;
    
    // Default alignments
    for (final /*const*/ LayoutAlignElem /*&*/ E : DefaultAlignments) {
      setAlignment((/*AlignTypeEnum*/byte)$8bits_uint2uint(E.AlignType), $16bits_uint2uint(E.ABIAlign), $16bits_uint2uint(E.PrefAlign), 
          E.TypeBitWidth);
    }
    setPointerAlignment(0, 8, 8, 8);
    
    parseSpecifier(new StringRef(Desc));
  }

  
  /// Layout endianness...
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 214,
   FQN="llvm::DataLayout::isLittleEndian", NM="_ZNK4llvm10DataLayout14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout14isLittleEndianEv")
  //</editor-fold>
  public boolean isLittleEndian() /*const*/ {
    return !BigEndian;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::isBigEndian">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 215,
   FQN="llvm::DataLayout::isBigEndian", NM="_ZNK4llvm10DataLayout11isBigEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout11isBigEndianEv")
  //</editor-fold>
  public boolean isBigEndian() /*const*/ {
    return BigEndian;
  }

  
  /// \brief Returns the string representation of the DataLayout.
  ///
  /// This representation is in the same format accepted by the string
  /// constructor above. This should not be used to compare two DataLayout as
  /// different string can represent the same layout.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getStringRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 222,
   FQN="llvm::DataLayout::getStringRepresentation", NM="_ZNK4llvm10DataLayout23getStringRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout23getStringRepresentationEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getStringRepresentation() /*const*/ {
    return StringRepresentation;
  }

  
  /// \brief Test if the DataLayout was constructed from an empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::isDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 227,
   FQN="llvm::DataLayout::isDefault", NM="_ZNK4llvm10DataLayout9isDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout9isDefaultEv")
  //</editor-fold>
  public boolean isDefault() /*const*/ {
    return StringRepresentation.empty();
  }

  
  /// \brief Returns true if the specified type is known to be a native integer
  /// type supported by the CPU.
  ///
  /// For example, i64 is not native on most 32-bit CPUs and i37 is not native
  /// on any known one. This returns false if the integer width is not legal.
  ///
  /// The width is specified in bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::isLegalInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 236,
   FQN="llvm::DataLayout::isLegalInteger", NM="_ZNK4llvm10DataLayout14isLegalIntegerEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout14isLegalIntegerEy")
  //</editor-fold>
  public boolean isLegalInteger(long/*uint64_t*/ Width) /*const*/ {
    for (/*uint*/int LegalIntWidth : LegalIntWidths)  {
      if ($uint2ullong(LegalIntWidth) == Width) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::isIllegalInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 243,
   FQN="llvm::DataLayout::isIllegalInteger", NM="_ZNK4llvm10DataLayout16isIllegalIntegerEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout16isIllegalIntegerEy")
  //</editor-fold>
  public boolean isIllegalInteger(long/*uint64_t*/ Width) /*const*/ {
    return !isLegalInteger(Width);
  }

  
  /// Returns true if the given alignment exceeds the natural stack alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::exceedsNaturalStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 246,
   FQN="llvm::DataLayout::exceedsNaturalStackAlignment", NM="_ZNK4llvm10DataLayout28exceedsNaturalStackAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout28exceedsNaturalStackAlignmentEj")
  //</editor-fold>
  public boolean exceedsNaturalStackAlignment(/*uint*/int Align) /*const*/ {
    return (StackNaturalAlign != 0) && ($greater_uint(Align, StackNaturalAlign));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 250,
   FQN="llvm::DataLayout::getStackAlignment", NM="_ZNK4llvm10DataLayout17getStackAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout17getStackAlignmentEv")
  //</editor-fold>
  public /*uint*/int getStackAlignment() /*const*/ {
    return StackNaturalAlign;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::hasMicrosoftFastStdCallMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 252,
   FQN="llvm::DataLayout::hasMicrosoftFastStdCallMangling", NM="_ZNK4llvm10DataLayout31hasMicrosoftFastStdCallManglingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout31hasMicrosoftFastStdCallManglingEv")
  //</editor-fold>
  public boolean hasMicrosoftFastStdCallMangling() /*const*/ {
    return ManglingMode == ManglingModeT.MM_WinCOFFX86;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::hasLinkerPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 256,
   FQN="llvm::DataLayout::hasLinkerPrivateGlobalPrefix", NM="_ZNK4llvm10DataLayout28hasLinkerPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout28hasLinkerPrivateGlobalPrefixEv")
  //</editor-fold>
  public boolean hasLinkerPrivateGlobalPrefix() /*const*/ {
    return ManglingMode == ManglingModeT.MM_MachO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getLinkerPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 258,
   FQN="llvm::DataLayout::getLinkerPrivateGlobalPrefix", NM="_ZNK4llvm10DataLayout28getLinkerPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout28getLinkerPrivateGlobalPrefixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getLinkerPrivateGlobalPrefix() /*const*/ {
    if (ManglingMode == ManglingModeT.MM_MachO) {
      return $l;
    }
    return $EMPTY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 264,
   FQN="llvm::DataLayout::getGlobalPrefix", NM="_ZNK4llvm10DataLayout15getGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout15getGlobalPrefixEv")
  //</editor-fold>
  public /*char*/byte getGlobalPrefix() /*const*/ {
    switch (ManglingMode) {
     case MM_None:
     case MM_ELF:
     case MM_Mips:
     case MM_WinCOFF:
      return $$TERM;
     case MM_MachO:
     case MM_WinCOFFX86:
      return $$UNDERSCORE;
    }
    throw new llvm_unreachable("invalid mangling mode");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 278,
   FQN="llvm::DataLayout::getPrivateGlobalPrefix", NM="_ZNK4llvm10DataLayout22getPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getPrivateGlobalPrefixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPrivateGlobalPrefix() /*const*/ {
    switch (ManglingMode) {
     case MM_None:
      return $EMPTY;
     case MM_ELF:
      return $(".L");
     case MM_Mips:
      return $DOLLAR;
     case MM_MachO:
     case MM_WinCOFF:
     case MM_WinCOFFX86:
      return $L;
    }
    throw new llvm_unreachable("invalid mangling mode");
  }

  
  
  //===----------------------------------------------------------------------===//
  //                       DataLayout Class Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getManglingComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 155,
   FQN="llvm::DataLayout::getManglingComponent", NM="_ZN4llvm10DataLayout20getManglingComponentERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZN4llvm10DataLayout20getManglingComponentERKNS_6TripleE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getManglingComponent(final /*const*/ Triple /*&*/ T) {
    if (T.isOSBinFormatMachO()) {
      return $("-m:o");
    }
    if (T.isOSWindows() && T.isOSBinFormatCOFF()) {
      return T.getArch() == Triple.ArchType.x86 ? $("-m:x") : $("-m:w");
    }
    return $("-m:e");
  }

  
  /// \brief Returns true if the specified type fits in a native integer type
  /// supported by the CPU.
  ///
  /// For example, if the CPU only supports i32 as a native integer type, then
  /// i27 fits in a legal integer type but i45 does not.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::fitsInLegalInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 301,
   FQN="llvm::DataLayout::fitsInLegalInteger", NM="_ZNK4llvm10DataLayout18fitsInLegalIntegerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout18fitsInLegalIntegerEj")
  //</editor-fold>
  public boolean fitsInLegalInteger(/*uint*/int Width) /*const*/ {
    for (/*uint*/int LegalIntWidth : LegalIntWidths)  {
      if ($lesseq_uint(Width, LegalIntWidth)) {
        return true;
      }
    }
    return false;
  }

  
  /// Layout pointer alignment
  /// FIXME: The defaults need to be removed once all of
  /// the backends/clients are updated.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerABIAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 580,
   FQN="llvm::DataLayout::getPointerABIAlignment", NM="_ZNK4llvm10DataLayout22getPointerABIAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getPointerABIAlignmentEj")
  //</editor-fold>
  public /*uint*/int getPointerABIAlignment() /*const*/ {
    return getPointerABIAlignment(0);
  }
  public /*uint*/int getPointerABIAlignment(/*uint*/int AS/*= 0*/) /*const*/ {
    type$ptr</*const*/ PointerAlignElem /*P*/ > I = $tryClone(findPointerLowerBound$Const(AS));
    if ($eq_ptr(I, Pointers.end$Const()) || I./*->*/$star().AddressSpace != AS) {
      I = $tryClone(findPointerLowerBound$Const(0));
      assert (I./*->*/$star().AddressSpace == 0);
    }
    return I./*->*/$star().ABIAlign;
  }

  
  /// Return target's alignment for stack-based pointers
  /// FIXME: The defaults need to be removed once all of
  /// the backends/clients are updated.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerPrefAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 589,
   FQN="llvm::DataLayout::getPointerPrefAlignment", NM="_ZNK4llvm10DataLayout23getPointerPrefAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout23getPointerPrefAlignmentEj")
  //</editor-fold>
  public /*uint*/int getPointerPrefAlignment() /*const*/ {
    return getPointerPrefAlignment(0);
  }
  public /*uint*/int getPointerPrefAlignment(/*uint*/int AS/*= 0*/) /*const*/ {
    type$ptr</*const*/ PointerAlignElem /*P*/ > I = $tryClone(findPointerLowerBound$Const(AS));
    if ($eq_ptr(I, Pointers.end$Const()) || I./*->*/$star().AddressSpace != AS) {
      I = $tryClone(findPointerLowerBound$Const(0));
      assert (I./*->*/$star().AddressSpace == 0);
    }
    return I./*->*/$star().PrefAlign;
  }

  
  /// Layout pointer size
  /// FIXME: The defaults need to be removed once all of
  /// the backends/clients are updated.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 598,
   FQN="llvm::DataLayout::getPointerSize", NM="_ZNK4llvm10DataLayout14getPointerSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout14getPointerSizeEj")
  //</editor-fold>
  public /*uint*/int getPointerSize() /*const*/ {
    return getPointerSize(0);
  }
  public /*uint*/int getPointerSize(/*uint*/int AS/*= 0*/) /*const*/ {
    type$ptr</*const*/ PointerAlignElem /*P*/ > I = $tryClone(findPointerLowerBound$Const(AS));
    if ($eq_ptr(I, Pointers.end$Const()) || I./*->*/$star().AddressSpace != AS) {
      I = $tryClone(findPointerLowerBound$Const(0));
      assert (I./*->*/$star().AddressSpace == 0);
    }
    return I./*->*/$star().TypeByteWidth;
  }

  
  /// Layout pointer size, in bits
  /// FIXME: The defaults need to be removed once all of
  /// the backends/clients are updated.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 326,
   FQN="llvm::DataLayout::getPointerSizeInBits", NM="_ZNK4llvm10DataLayout20getPointerSizeInBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout20getPointerSizeInBitsEj")
  //</editor-fold>
  public /*uint*/int getPointerSizeInBits() /*const*/ {
    return getPointerSizeInBits(0);
  }
  public /*uint*/int getPointerSizeInBits(/*uint*/int AS/*= 0*/) /*const*/ {
    return getPointerSize(AS) * 8;
  }

  
  /// Layout pointer size, in bits, based on the type.  If this function is
  /// called with a pointer type, then the type size of the pointer is returned.
  /// If this function is called with a vector of pointers, then the type size
  /// of the pointer is returned.  This should only be called with a pointer or
  /// vector of pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerTypeSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 607,
   FQN="llvm::DataLayout::getPointerTypeSizeInBits", NM="_ZNK4llvm10DataLayout24getPointerTypeSizeInBitsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout24getPointerTypeSizeInBitsEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getPointerTypeSizeInBits(Type /*P*/ Ty) /*const*/ {
    assert (Ty.isPtrOrPtrVectorTy()) : "This should only be called with a pointer or pointer vector type";
    if (Ty.isPointerTy()) {
      return $ulong2uint(getTypeSizeInBits(Ty));
    }
    
    return $ulong2uint(getTypeSizeInBits(Ty.getScalarType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPointerTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 337,
   FQN="llvm::DataLayout::getPointerTypeSize", NM="_ZNK4llvm10DataLayout18getPointerTypeSizeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout18getPointerTypeSizeEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getPointerTypeSize(Type /*P*/ Ty) /*const*/ {
    return $div_uint(getPointerTypeSizeInBits(Ty), 8);
  }

  
  /// Size examples:
  ///
  /// Type        SizeInBits  StoreSizeInBits  AllocSizeInBits[*]
  /// ----        ----------  ---------------  ---------------
  ///  i1            1           8                8
  ///  i8            8           8                8
  ///  i19          19          24               32
  ///  i32          32          32               32
  ///  i100        100         104              128
  ///  i128        128         128              128
  ///  Float        32          32               32
  ///  Double       64          64               64
  ///  X86_FP80     80          80               96
  ///
  /// [*] The alloc size depends on the alignment, and thus on the target.
  ///     These values are for x86-32 linux.
  
  /// \brief Returns the number of bits necessary to hold the specified type.
  ///
  /// For example, returns 36 for i36 and 80 for x86_fp80. The type passed must
  /// have a size (Type::isSized() must return true).
  
  // The implementation of this method is provided inline as it is particularly
  // well suited to constant folding when called on a specific Type subclass.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getTypeSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 510,
   FQN="llvm::DataLayout::getTypeSizeInBits", NM="_ZNK4llvm10DataLayout17getTypeSizeInBitsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout17getTypeSizeInBitsEPNS_4TypeE")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getTypeSizeInBits(Type /*P*/ Ty) /*const*/ {
    assert (Ty.isSized()) : "Cannot getTypeInfo() on a type that is unsized!";
    switch (Ty.getTypeID()) {
     case LabelTyID:
      return $uint2ulong(getPointerSizeInBits(0));
     case PointerTyID:
      return $uint2ulong(getPointerSizeInBits(Ty.getPointerAddressSpace()));
     case ArrayTyID:
      {
        ArrayType /*P*/ ATy = cast_ArrayType(Ty);
        return ATy.getNumElements()
           * getTypeAllocSizeInBits(ATy.getElementType());
      }
     case StructTyID:
      // Get the layout annotation... which is lazily created on demand.
      return getStructLayout(cast_StructType(Ty)).getSizeInBits();
     case IntegerTyID:
      return $uint2ulong(Ty.getIntegerBitWidth());
     case HalfTyID:
      return $int2ulong(16);
     case FloatTyID:
      return $int2ulong(32);
     case DoubleTyID:
     case X86_MMXTyID:
      return $int2ulong(64);
     case PPC_FP128TyID:
     case FP128TyID:
      return $int2ulong(128);
     case X86_FP80TyID:
      // In memory objects this is always aligned to a higher boundary, but
      // only 80 bits contain information.
      return $int2ulong(80);
     case VectorTyID:
      {
        VectorType /*P*/ VTy = cast_VectorType(Ty);
        return $uint2ullong(VTy.getNumElements()) * getTypeSizeInBits(VTy.getElementType());
      }
     default:
      throw new llvm_unreachable("DataLayout::getTypeSizeInBits(): Unsupported type");
    }
  }

  
  /// \brief Returns the maximum number of bytes that may be overwritten by
  /// storing the specified type.
  ///
  /// For example, returns 5 for i36 and 10 for x86_fp80.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getTypeStoreSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 368,
   FQN="llvm::DataLayout::getTypeStoreSize", NM="_ZNK4llvm10DataLayout16getTypeStoreSizeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout16getTypeStoreSizeEPNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeStoreSize(Type /*P*/ Ty) /*const*/ {
    return $div_ullong((getTypeSizeInBits(Ty) + $int2ullong(7)), $int2ullong(8));
  }

  
  /// \brief Returns the maximum number of bits that may be overwritten by
  /// storing the specified type; always a multiple of 8.
  ///
  /// For example, returns 40 for i36 and 80 for x86_fp80.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getTypeStoreSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 376,
   FQN="llvm::DataLayout::getTypeStoreSizeInBits", NM="_ZNK4llvm10DataLayout22getTypeStoreSizeInBitsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getTypeStoreSizeInBitsEPNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeStoreSizeInBits(Type /*P*/ Ty) /*const*/ {
    return $int2ullong(8) * getTypeStoreSize(Ty);
  }

  
  /// \brief Returns the offset in bytes between successive objects of the
  /// specified type, including alignment padding.
  ///
  /// This is the amount that alloca reserves for this type. For example,
  /// returns 12 or 16 for x86_fp80, depending on alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getTypeAllocSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 385,
   FQN="llvm::DataLayout::getTypeAllocSize", NM="_ZNK4llvm10DataLayout16getTypeAllocSizeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout16getTypeAllocSizeEPNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeAllocSize(Type /*P*/ Ty) /*const*/ {
    // Round up to the next alignment boundary.
    return alignTo(getTypeStoreSize(Ty), $uint2ulong(getABITypeAlignment(Ty)));
  }

  
  /// \brief Returns the offset in bits between successive objects of the
  /// specified type, including alignment padding; always a multiple of 8.
  ///
  /// This is the amount that alloca reserves for this type. For example,
  /// returns 96 or 128 for x86_fp80, depending on alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getTypeAllocSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 395,
   FQN="llvm::DataLayout::getTypeAllocSizeInBits", NM="_ZNK4llvm10DataLayout22getTypeAllocSizeInBitsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getTypeAllocSizeInBitsEPNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeAllocSizeInBits(Type /*P*/ Ty) /*const*/ {
    return $int2ullong(8) * getTypeAllocSize(Ty);
  }

  
  /// \brief Returns the minimum ABI-required alignment for the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getABITypeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 679,
   FQN="llvm::DataLayout::getABITypeAlignment", NM="_ZNK4llvm10DataLayout19getABITypeAlignmentEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout19getABITypeAlignmentEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getABITypeAlignment(Type /*P*/ Ty) /*const*/ {
    return getAlignment(Ty, true);
  }

  
  /// \brief Returns the minimum ABI-required alignment for an integer type of
  /// the specified bitwidth.
  
  /// getABIIntegerTypeAlignment - Return the minimum ABI-required alignment for
  /// an integer type of the specified bitwidth.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getABIIntegerTypeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 685,
   FQN="llvm::DataLayout::getABIIntegerTypeAlignment", NM="_ZNK4llvm10DataLayout26getABIIntegerTypeAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout26getABIIntegerTypeAlignmentEj")
  //</editor-fold>
  public /*uint*/int getABIIntegerTypeAlignment(/*uint*/int BitWidth) /*const*/ {
    return getAlignmentInfo(AlignTypeEnum.INTEGER_ALIGN, BitWidth, true, (Type /*P*/ )null);
  }

  
  /// \brief Returns the preferred stack/global alignment for the specified
  /// type.
  ///
  /// This is always at least as good as the ABI alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPrefTypeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 689,
   FQN="llvm::DataLayout::getPrefTypeAlignment", NM="_ZNK4llvm10DataLayout20getPrefTypeAlignmentEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout20getPrefTypeAlignmentEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getPrefTypeAlignment(Type /*P*/ Ty) /*const*/ {
    return getAlignment(Ty, false);
  }

  
  /// \brief Returns the preferred alignment for the specified type, returned as
  /// log2 of the value (a shift amount).
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPreferredTypeAlignmentShift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 693,
   FQN="llvm::DataLayout::getPreferredTypeAlignmentShift", NM="_ZNK4llvm10DataLayout30getPreferredTypeAlignmentShiftEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout30getPreferredTypeAlignmentShiftEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getPreferredTypeAlignmentShift(Type /*P*/ Ty) /*const*/ {
    /*uint*/int Align = getPrefTypeAlignment(Ty);
    assert (!((Align & (Align - 1)) != 0)) : "Alignment is not a power of two!";
    return Log2_32(Align);
  }

  
  /// \brief Returns an integer type with size at least as big as that of a
  /// pointer in the given address space.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getIntPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 699,
   FQN="llvm::DataLayout::getIntPtrType", NM="_ZNK4llvm10DataLayout13getIntPtrTypeERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout13getIntPtrTypeERNS_11LLVMContextEj")
  //</editor-fold>
  public IntegerType /*P*/ getIntPtrType(final LLVMContext /*&*/ C) /*const*/ {
    return getIntPtrType(C, 
               0);
  }
  public IntegerType /*P*/ getIntPtrType(final LLVMContext /*&*/ C, 
               /*uint*/int AddressSpace/*= 0*/) /*const*/ {
    return IntegerType.get(C, getPointerSizeInBits(AddressSpace));
  }

  
  /// \brief Returns an integer (vector of integer) type with size at least as
  /// big as that of a pointer of the given pointer (vector of pointer) type.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getIntPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 704,
   FQN="llvm::DataLayout::getIntPtrType", NM="_ZNK4llvm10DataLayout13getIntPtrTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout13getIntPtrTypeEPNS_4TypeE")
  //</editor-fold>
  public Type /*P*/ getIntPtrType(Type /*P*/ Ty) /*const*/ {
    assert (Ty.isPtrOrPtrVectorTy()) : "Expected a pointer or pointer vector type.";
    /*uint*/int NumBits = getPointerTypeSizeInBits(Ty);
    IntegerType /*P*/ IntTy = IntegerType.get(Ty.getContext(), NumBits);
    {
      VectorType /*P*/ VecTy = dyn_cast_VectorType(Ty);
      if ((VecTy != null)) {
        return VectorType.get(IntTy, VecTy.getNumElements());
      }
    }
    return IntTy;
  }

  
  /// \brief Returns the smallest integer type with size at least as big as
  /// Width bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getSmallestLegalIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 714,
   FQN="llvm::DataLayout::getSmallestLegalIntType", NM="_ZNK4llvm10DataLayout23getSmallestLegalIntTypeERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout23getSmallestLegalIntTypeERNS_11LLVMContextEj")
  //</editor-fold>
  public Type /*P*/ getSmallestLegalIntType(final LLVMContext /*&*/ C) /*const*/ {
    return getSmallestLegalIntType(C, 0);
  }
  public Type /*P*/ getSmallestLegalIntType(final LLVMContext /*&*/ C, /*uint*/int Width/*= 0*/) /*const*/ {
    for (/*uint*/int LegalIntWidth : LegalIntWidths)  {
      if ($lesseq_uint(Width, LegalIntWidth)) {
        return Type.getIntNTy(C, LegalIntWidth);
      }
    }
    return null;
  }

  
  /// \brief Returns the largest legal integer type, or null if none are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getLargestLegalIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 429,
   FQN="llvm::DataLayout::getLargestLegalIntType", NM="_ZNK4llvm10DataLayout22getLargestLegalIntTypeERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getLargestLegalIntTypeERNS_11LLVMContextE")
  //</editor-fold>
  public Type /*P*/ getLargestLegalIntType(final LLVMContext /*&*/ C) /*const*/ {
    /*uint*/int LargestSize = getLargestLegalIntTypeSizeInBits();
    return (LargestSize == 0) ? null : Type.getIntNTy(C, LargestSize);
  }

  
  /// \brief Returns the size of largest legal integer type size, or 0 if none
  /// are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getLargestLegalIntTypeSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 721,
   FQN="llvm::DataLayout::getLargestLegalIntTypeSizeInBits", NM="_ZNK4llvm10DataLayout32getLargestLegalIntTypeSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout32getLargestLegalIntTypeSizeInBitsEv")
  //</editor-fold>
  public /*uint*/int getLargestLegalIntTypeSizeInBits() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the offset from the beginning of the type for the specified
  /// indices.
  ///
  /// Note that this takes the element type, not the pointer type.
  /// This is used to implement getelementptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getIndexedOffsetInType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 726,
   FQN="llvm::DataLayout::getIndexedOffsetInType", NM="_ZNK4llvm10DataLayout22getIndexedOffsetInTypeEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout22getIndexedOffsetInTypeEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public long/*int64_t*/ getIndexedOffsetInType(Type /*P*/ ElemTy, 
                        ArrayRef<Value /*P*/ > Indices) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns a StructLayout object, indicating the alignment of the
  /// struct, its size, and the offsets of its fields.
  ///
  /// Note that this information is lazily cached.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getStructLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 556,
   FQN="llvm::DataLayout::getStructLayout", NM="_ZNK4llvm10DataLayout15getStructLayoutEPNS_10StructTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout15getStructLayoutEPNS_10StructTypeE")
  //</editor-fold>
  public /*const*/ StructLayout /*P*/ getStructLayout(StructType /*P*/ Ty) /*const*/ {
    if (!(LayoutMap != null)) {
      LayoutMap = new StructLayoutMap();
    }
    
    StructLayoutMap /*P*/ STM = ((/*static_cast*/StructLayoutMap /*P*/ )(LayoutMap));
    final type$ref<StructLayout /*P*/ /*&*/> SL = (/*Deref*/STM).$at(Ty);
    if ((SL.$deref() != null)) {
      return SL.$deref();
    }
    
    // Otherwise, create the struct layout.  Because it is variable length, we
    // malloc it, then use placement new.
    int NumElts = Ty.getNumElements();
    final type$ptr<StructLayout /*P*/> $L = std.<StructLayout /*P*/>malloc(/*JAVA $sizeof_StructLayout()*/1 + (NumElts - 1) * 1/*JAVA $sizeof_ULong()*/);
    
    // Set SL before calling StructLayout's ctor.  The ctor could cause other
    // entries to be added to TheMap, invalidating our reference.
    assert $L.$star() == null : "JAVA: can not be assigned yet, see code in StructLayout ctor";
    SL.$set($L.$star());
    
    /*NEW_EXPR [System]*/StructLayout /*P*/ L = /*new (L)*/ $new_uint_voidPtr($L, (type$ptr<?> New$Mem)->{
        assert New$Mem == $L;
        // JAVA: to make SL.$set($L.$star()) correct we need to pass SL and $This memory into ctor
        return new StructLayout(SL, $L, Ty, /*Deref*/this);
     });
    
    return L;
  }

  
  /// \brief Returns the preferred alignment of the specified global.
  ///
  /// This includes an explicitly requested alignment (if the global has one).
  
  /// getPreferredAlignment - Return the preferred alignment of the specified
  /// global.  This includes an explicitly requested alignment (if the global
  /// has one).
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPreferredAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 760,
   FQN="llvm::DataLayout::getPreferredAlignment", NM="_ZNK4llvm10DataLayout21getPreferredAlignmentEPKNS_14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout21getPreferredAlignmentEPKNS_14GlobalVariableE")
  //</editor-fold>
  public /*uint*/int getPreferredAlignment(/*const*/ GlobalVariable /*P*/ GV) /*const*/ {
    Type /*P*/ ElemType = GV.getValueType();
    /*uint*/int Alignment = getPrefTypeAlignment(ElemType);
    /*uint*/int GVAlignment = GV.getAlignment();
    if ($greatereq_uint(GVAlignment, Alignment)) {
      Alignment = GVAlignment;
    } else if (GVAlignment != 0) {
      Alignment = std.max(GVAlignment, getABITypeAlignment(ElemType));
    }
    if (GV.hasInitializer() && GVAlignment == 0) {
      if ($less_uint(Alignment, 16)) {
        // If the global is not external, see if it is large.  If so, give it a
        // larger alignment.
        if ($greater_ulong_ullong(getTypeSizeInBits(ElemType), $int2ullong(128))) {
          Alignment = 16; // 16-byte alignment.
        }
      }
    }
    return Alignment;
  }

  
  /// \brief Returns the preferred alignment of the specified global, returned
  /// in log form.
  ///
  /// This includes an explicitly requested alignment (if the global has one).
  
  /// getPreferredAlignmentLog - Return the preferred alignment of the
  /// specified global, returned in log form.  This includes an explicitly
  /// requested alignment (if the global has one).
  //<editor-fold defaultstate="collapsed" desc="llvm::DataLayout::getPreferredAlignmentLog">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 784,
   FQN="llvm::DataLayout::getPreferredAlignmentLog", NM="_ZNK4llvm10DataLayout24getPreferredAlignmentLogEPKNS_14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZNK4llvm10DataLayout24getPreferredAlignmentLogEPKNS_14GlobalVariableE")
  //</editor-fold>
  public /*uint*/int getPreferredAlignmentLog(/*const*/ GlobalVariable /*P*/ GV) /*const*/ {
    return Log2_32(getPreferredAlignment(GV));
  }

  
  @Override public String toString() {
    return "" + "BigEndian=" + BigEndian // NOI18N
              + ", StackNaturalAlign=" + StackNaturalAlign // NOI18N
              + ", ManglingMode=" + ManglingMode // NOI18N
              + ", LegalIntWidths=" + LegalIntWidths // NOI18N
              + ", Alignments=" + Alignments // NOI18N
              + ", StringRepresentation=" + StringRepresentation // NOI18N
              + ", Pointers=" + Pointers // NOI18N
              + ", LayoutMap=" + NativeTrace.getIdentityStr(LayoutMap); // NOI18N
  }
}
