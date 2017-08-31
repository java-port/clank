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
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$$LF;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.llvmc.LLVMOpaqueType;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


/// The instances of the Type class are immutable: once they are created,
/// they are never changed.  Also note that only one instance of a particular
/// type is ever created.  Thus seeing if two types are equal is a matter of
/// doing a trivial pointer comparison. To enforce that no two equal instances
/// are created, Type instances can only be created via static factory methods
/// in class Type and in derived classes.  Once allocated, Types are never
/// free'd.
///
//<editor-fold defaultstate="collapsed" desc="llvm::Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 45,
 FQN="llvm::Type", NM="_ZN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4TypeE")
//</editor-fold>
public class Type implements Destructors.ClassWithDestructor, LLVMOpaqueType {
/*public:*/
  //===--------------------------------------------------------------------===//
  /// Definitions of all of the base types for the Type system.  Based on this
  /// value, you can cast to a class defined in DerivedTypes.h.
  /// Note: If you add an element to this, you need to add an element to the
  /// Type::getPrimitiveType function, or else things will break!
  /// Also update LLVMTypeKind and LLVMGetTypeKind () in the C binding.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::TypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 54,
   FQN="llvm::Type::TypeID", NM="_ZN4llvm4Type6TypeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4Type6TypeIDE")
  //</editor-fold>
  public enum TypeID implements Native.NativeUIntEnum {
    // PrimitiveTypes - make sure LastPrimitiveTyID stays up to date.
    VoidTyID(0), ///<  0: type with no size
    HalfTyID(VoidTyID.getValue() + 1), ///<  1: 16-bit floating point type
    FloatTyID(HalfTyID.getValue() + 1), ///<  2: 32-bit floating point type
    DoubleTyID(FloatTyID.getValue() + 1), ///<  3: 64-bit floating point type
    X86_FP80TyID(DoubleTyID.getValue() + 1), ///<  4: 80-bit floating point type (X87)
    FP128TyID(X86_FP80TyID.getValue() + 1), ///<  5: 128-bit floating point type (112-bit mantissa)
    PPC_FP128TyID(FP128TyID.getValue() + 1), ///<  6: 128-bit floating point type (two 64-bits, PowerPC)
    LabelTyID(PPC_FP128TyID.getValue() + 1), ///<  7: Labels
    MetadataTyID(LabelTyID.getValue() + 1), ///<  8: Metadata
    X86_MMXTyID(MetadataTyID.getValue() + 1), ///<  9: MMX vectors (64 bits, X86 specific)
    TokenTyID(X86_MMXTyID.getValue() + 1), ///< 10: Tokens
    
    // Derived types... see DerivedTypes.h file.
    // Make sure FirstDerivedTyID stays up to date!
    IntegerTyID(TokenTyID.getValue() + 1), ///< 11: Arbitrary bit width integers
    FunctionTyID(IntegerTyID.getValue() + 1), ///< 12: Functions
    StructTyID(FunctionTyID.getValue() + 1), ///< 13: Structures
    ArrayTyID(StructTyID.getValue() + 1), ///< 14: Arrays
    PointerTyID(ArrayTyID.getValue() + 1), ///< 15: Pointers
    VectorTyID(PointerTyID.getValue() + 1); ///< 16: SIMD 'packed' format, or other vector type

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TypeID valueOf(int val) {
      TypeID out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TypeID[] VALUES;
      private static final TypeID[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TypeID kind : TypeID.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TypeID[min < 0 ? (1-min) : 0];
        VALUES = new TypeID[max >= 0 ? (1+max) : 0];
        for (TypeID kind : TypeID.values()) {
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
    private TypeID(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  /// This refers to the LLVMContext in which this type was uniqued.
  private final LLVMContext /*&*/ Context;
  
  private TypeID ID /*: 8*/; // The current base type of this type.
  private /*uint*/int SubclassData /*: 24*/; // Space for subclasses to store data.
/*protected:*/
  /*friend  class LLVMContextImpl*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 87,
   FQN="llvm::Type::Type", NM="_ZN4llvm4TypeC1ERNS_11LLVMContextENS0_6TypeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4TypeC1ERNS_11LLVMContextENS0_6TypeIDE")
  //</editor-fold>
  /*friend*/public/*protected*/ /*explicit*/ Type(final LLVMContext /*&*/ C, TypeID tid) {
    // : Context(C), ID(tid), SubclassData(0), NumContainedTys(0), ContainedTys(null) 
    //START JInit
    this./*&*/Context=/*&*/C;
    this.ID = tid;
    this.SubclassData = 0;
    this.NumContainedTys = 0;
    this.ContainedTys = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::~Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 90,
   FQN="llvm::Type::~Type", NM="_ZN4llvm4TypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4TypeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 92,
   FQN="llvm::Type::getSubclassData", NM="_ZNK4llvm4Type15getSubclassDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type15getSubclassDataEv")
  //</editor-fold>
  protected /*uint*/int getSubclassData() /*const*/ {
    return SubclassData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::setSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 94,
   FQN="llvm::Type::setSubclassData", NM="_ZN4llvm4Type15setSubclassDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4Type15setSubclassDataEj")
  //</editor-fold>
  protected void setSubclassData(/*uint*/int val) {
    SubclassData = val;
    // Ensure we don't have any accidental truncation.
    assert (getSubclassData() == val) : "Subclass data too large for field";
  }

  
  /// Keeps track of how many Type*'s there are in the ContainedTys list.
  protected /*uint*/int NumContainedTys;
  
  /// A pointer to the array of Types contained by this Type. For example, this
  /// includes the arguments of a function type, the elements of a structure,
  /// the pointee of a pointer, the element type of an array, etc. This pointer
  /// may be 0 for types that don't contain other types (Integer, Double,
  /// Float).
  protected type$ptr<Type /*P*/ /*const*/ /*P*/> ContainedTys;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isSequentialType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 110,
   FQN="llvm::Type::isSequentialType", NM="_ZN4llvm4Type16isSequentialTypeENS0_6TypeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm4Type16isSequentialTypeENS0_6TypeIDE")
  //</editor-fold>
  protected static boolean isSequentialType(TypeID TyID) {
    return TyID == TypeID.ArrayTyID || TyID == TypeID.PointerTyID || TyID == TypeID.VectorTyID;
  }

/*public:*/
  /// Print the current type.
  /// Omit the type details if \p NoDetails == true.
  /// E.g., let %st = type { i32, i16 }
  /// When \p NoDetails is true, we only print %st.
  /// Put differently, \p NoDetails prints the type as if
  /// inlined with the operands when printing an instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3363,
   FQN="llvm::Type::print", NM="_ZNK4llvm4Type5printERNS_11raw_ostreamEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type5printERNS_11raw_ostreamEbb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, false, false);
  }
  public void print(final raw_ostream /*&*/ OS, boolean $Prm1/*= false*//*IsForDebug*/) /*const*/ {
    print(OS, $Prm1, false);
  }
  public void print(final raw_ostream /*&*/ OS, boolean $Prm1/*= false*/, boolean NoDetails/*= false*/) /*const*/ {
    TypePrinting TP = null;
    try {
      TP/*J*/= new TypePrinting();
      TP.print(((/*const_cast*/Type /*P*/ )(this)), OS);
      if (NoDetails) {
        return;
      }
      {
        
        // If the type is a named struct type, print the body as well.
        StructType /*P*/ STy = dyn_cast_StructType(((/*const_cast*/Type /*P*/ )(this)));
        if ((STy != null)) {
          if (!STy.isLiteral()) {
            OS.$out(/*KEEP_STR*/" = type ");
            TP.printStructBody(STy, OS);
          }
        }
      }
    } finally {
      if (TP != null) { TP.$destroy(); }
    }
  }

  
  // Type::dump - allow easy printing of Types from the debugger.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3538,
   FQN="llvm::Type::dump", NM="_ZNK4llvm4Type4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), /*IsForDebug=*/ true);
    dbgs().$out_char($$LF);
  }

  
  /// Return the LLVMContext in which this type was uniqued.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 126,
   FQN="llvm::Type::getContext", NM="_ZNK4llvm4Type10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  
  //===--------------------------------------------------------------------===//
  // Accessors for working with types.
  //
  
  /// Return the type id for the type. This will return one of the TypeID enum
  /// elements defined above.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 134,
   FQN="llvm::Type::getTypeID", NM="_ZNK4llvm4Type9getTypeIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9getTypeIDEv")
  //</editor-fold>
  public TypeID getTypeID() /*const*/ {
    return ID;
  }

  
  /// Return true if this is 'void'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isVoidTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 137,
   FQN="llvm::Type::isVoidTy", NM="_ZNK4llvm4Type8isVoidTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type8isVoidTyEv")
  //</editor-fold>
  public boolean isVoidTy() /*const*/ {
    return getTypeID() == TypeID.VoidTyID;
  }

  
  /// Return true if this is 'half', a 16-bit IEEE fp type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isHalfTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 140,
   FQN="llvm::Type::isHalfTy", NM="_ZNK4llvm4Type8isHalfTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type8isHalfTyEv")
  //</editor-fold>
  public boolean isHalfTy() /*const*/ {
    return getTypeID() == TypeID.HalfTyID;
  }

  
  /// Return true if this is 'float', a 32-bit IEEE fp type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFloatTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 143,
   FQN="llvm::Type::isFloatTy", NM="_ZNK4llvm4Type9isFloatTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9isFloatTyEv")
  //</editor-fold>
  public boolean isFloatTy() /*const*/ {
    return getTypeID() == TypeID.FloatTyID;
  }

  
  /// Return true if this is 'double', a 64-bit IEEE fp type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isDoubleTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 146,
   FQN="llvm::Type::isDoubleTy", NM="_ZNK4llvm4Type10isDoubleTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type10isDoubleTyEv")
  //</editor-fold>
  public boolean isDoubleTy() /*const*/ {
    return getTypeID() == TypeID.DoubleTyID;
  }

  
  /// Return true if this is x86 long double.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isX86_FP80Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 149,
   FQN="llvm::Type::isX86_FP80Ty", NM="_ZNK4llvm4Type12isX86_FP80TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type12isX86_FP80TyEv")
  //</editor-fold>
  public boolean isX86_FP80Ty() /*const*/ {
    return getTypeID() == TypeID.X86_FP80TyID;
  }

  
  /// Return true if this is 'fp128'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFP128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 152,
   FQN="llvm::Type::isFP128Ty", NM="_ZNK4llvm4Type9isFP128TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9isFP128TyEv")
  //</editor-fold>
  public boolean isFP128Ty() /*const*/ {
    return getTypeID() == TypeID.FP128TyID;
  }

  
  /// Return true if this is powerpc long double.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isPPC_FP128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 155,
   FQN="llvm::Type::isPPC_FP128Ty", NM="_ZNK4llvm4Type13isPPC_FP128TyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type13isPPC_FP128TyEv")
  //</editor-fold>
  public boolean isPPC_FP128Ty() /*const*/ {
    return getTypeID() == TypeID.PPC_FP128TyID;
  }

  
  /// Return true if this is one of the six floating-point types
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFloatingPointTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 158,
   FQN="llvm::Type::isFloatingPointTy", NM="_ZNK4llvm4Type17isFloatingPointTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type17isFloatingPointTyEv")
  //</editor-fold>
  public boolean isFloatingPointTy() /*const*/ {
    return getTypeID() == TypeID.HalfTyID || getTypeID() == TypeID.FloatTyID
       || getTypeID() == TypeID.DoubleTyID
       || getTypeID() == TypeID.X86_FP80TyID || getTypeID() == TypeID.FP128TyID
       || getTypeID() == TypeID.PPC_FP128TyID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFltSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 165,
   FQN="llvm::Type::getFltSemantics", NM="_ZNK4llvm4Type15getFltSemanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type15getFltSemanticsEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getFltSemantics() /*const*/ {
    switch (getTypeID()) {
     case HalfTyID:
      return APFloat.IEEEhalf;
     case FloatTyID:
      return APFloat.IEEEsingle;
     case DoubleTyID:
      return APFloat.IEEEdouble;
     case X86_FP80TyID:
      return APFloat.x87DoubleExtended;
     case FP128TyID:
      return APFloat.IEEEquad;
     case PPC_FP128TyID:
      return APFloat.PPCDoubleDouble;
     default:
      throw new llvm_unreachable("Invalid floating type");
    }
  }

  
  /// Return true if this is X86 MMX.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isX86_MMXTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 178,
   FQN="llvm::Type::isX86_MMXTy", NM="_ZNK4llvm4Type11isX86_MMXTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type11isX86_MMXTyEv")
  //</editor-fold>
  public boolean isX86_MMXTy() /*const*/ {
    return getTypeID() == TypeID.X86_MMXTyID;
  }

  
  /// Return true if this is a FP type or a vector of FP.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFPOrFPVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 181,
   FQN="llvm::Type::isFPOrFPVectorTy", NM="_ZNK4llvm4Type16isFPOrFPVectorTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type16isFPOrFPVectorTyEv")
  //</editor-fold>
  public boolean isFPOrFPVectorTy() /*const*/ {
    return getScalarType().isFloatingPointTy();
  }

  
  /// Return true if this is 'label'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isLabelTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 184,
   FQN="llvm::Type::isLabelTy", NM="_ZNK4llvm4Type9isLabelTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9isLabelTyEv")
  //</editor-fold>
  public boolean isLabelTy() /*const*/ {
    return getTypeID() == TypeID.LabelTyID;
  }

  
  /// Return true if this is 'metadata'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isMetadataTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 187,
   FQN="llvm::Type::isMetadataTy", NM="_ZNK4llvm4Type12isMetadataTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type12isMetadataTyEv")
  //</editor-fold>
  public boolean isMetadataTy() /*const*/ {
    return getTypeID() == TypeID.MetadataTyID;
  }

  
  /// Return true if this is 'token'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isTokenTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 190,
   FQN="llvm::Type::isTokenTy", NM="_ZNK4llvm4Type9isTokenTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9isTokenTyEv")
  //</editor-fold>
  public boolean isTokenTy() /*const*/ {
    return getTypeID() == TypeID.TokenTyID;
  }

  
  /// True if this is an instance of IntegerType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isIntegerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 193,
   FQN="llvm::Type::isIntegerTy", NM="_ZNK4llvm4Type11isIntegerTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type11isIntegerTyEv")
  //</editor-fold>
  public boolean isIntegerTy() /*const*/ {
    return getTypeID() == TypeID.IntegerTyID;
  }

  
  /// Return true if this is an IntegerType of the given width.
  
  /// Return true if this is an IntegerType of the given width.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isIntegerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 50,
   FQN="llvm::Type::isIntegerTy", NM="_ZNK4llvm4Type11isIntegerTyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type11isIntegerTyEj")
  //</editor-fold>
  public boolean isIntegerTy(/*uint*/int Bitwidth) /*const*/ {
    return isIntegerTy() && cast_IntegerType(this).getBitWidth() == Bitwidth;
  }


  
  /// Return true if this is an integer type or a vector of integer types.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isIntOrIntVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 199,
   FQN="llvm::Type::isIntOrIntVectorTy", NM="_ZNK4llvm4Type18isIntOrIntVectorTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type18isIntOrIntVectorTyEv")
  //</editor-fold>
  public boolean isIntOrIntVectorTy() /*const*/ {
    return getScalarType().isIntegerTy();
  }

  
  /// True if this is an instance of FunctionType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFunctionTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 202,
   FQN="llvm::Type::isFunctionTy", NM="_ZNK4llvm4Type12isFunctionTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type12isFunctionTyEv")
  //</editor-fold>
  public boolean isFunctionTy() /*const*/ {
    return getTypeID() == TypeID.FunctionTyID;
  }

  
  /// True if this is an instance of StructType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isStructTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 205,
   FQN="llvm::Type::isStructTy", NM="_ZNK4llvm4Type10isStructTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type10isStructTyEv")
  //</editor-fold>
  public boolean isStructTy() /*const*/ {
    return getTypeID() == TypeID.StructTyID;
  }

  
  /// True if this is an instance of ArrayType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isArrayTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 208,
   FQN="llvm::Type::isArrayTy", NM="_ZNK4llvm4Type9isArrayTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type9isArrayTyEv")
  //</editor-fold>
  public boolean isArrayTy() /*const*/ {
    return getTypeID() == TypeID.ArrayTyID;
  }

  
  /// True if this is an instance of PointerType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isPointerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 211,
   FQN="llvm::Type::isPointerTy", NM="_ZNK4llvm4Type11isPointerTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type11isPointerTyEv")
  //</editor-fold>
  public boolean isPointerTy() /*const*/ {
    return getTypeID() == TypeID.PointerTyID;
  }

  
  /// Return true if this is a pointer type or a vector of pointer types.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isPtrOrPtrVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 214,
   FQN="llvm::Type::isPtrOrPtrVectorTy", NM="_ZNK4llvm4Type18isPtrOrPtrVectorTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type18isPtrOrPtrVectorTyEv")
  //</editor-fold>
  public boolean isPtrOrPtrVectorTy() /*const*/ {
    return getScalarType().isPointerTy();
  }

  
  /// True if this is an instance of VectorType.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 217,
   FQN="llvm::Type::isVectorTy", NM="_ZNK4llvm4Type10isVectorTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type10isVectorTyEv")
  //</editor-fold>
  public boolean isVectorTy() /*const*/ {
    return getTypeID() == TypeID.VectorTyID;
  }

  
  /// Return true if this type could be converted with a lossless BitCast to
  /// type 'Ty'. For example, i8* to i32*. BitCasts are valid for types of the
  /// same size only where no re-interpretation of the bits is done.
  /// @brief Determine if this type could be losslessly bitcast to Ty
  
  /// Return true if this type could be converted with a lossless BitCast to
  /// type 'Ty'. For example, i8* to i32*. BitCasts are valid for types of the
  /// same size only where no re-interpretation of the bits is done.
  /// @brief Determine if this type could be losslessly bitcast to Ty
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::canLosslesslyBitCastTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 54,
   FQN="llvm::Type::canLosslesslyBitCastTo", NM="_ZNK4llvm4Type22canLosslesslyBitCastToEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type22canLosslesslyBitCastToEPS0_")
  //</editor-fold>
  public boolean canLosslesslyBitCastTo(Type /*P*/ Ty) /*const*/ {
    // Identity cast means no change so return true
    if (this == Ty) {
      return true;
    }
    
    // They are not convertible unless they are at least first class types
    if (!this.isFirstClassType() || !Ty.isFirstClassType()) {
      return false;
    }
    {
      
      // Vector -> Vector conversions are always lossless if the two vector types
      // have the same size, otherwise not.  Also, 64-bit vector types can be
      // converted to x86mmx.
      /*const*/ VectorType /*P*/ thisPTy = dyn_cast_VectorType(this);
      if ((thisPTy != null)) {
        {
          VectorType /*P*/ thatPTy = dyn_cast_VectorType(Ty);
          if ((thatPTy != null)) {
            return thisPTy.getBitWidth() == thatPTy.getBitWidth();
          }
        }
        if (Ty.getTypeID() == Type.TypeID.X86_MMXTyID
           && thisPTy.getBitWidth() == 64) {
          return true;
        }
      }
    }
    if (this.getTypeID() == Type.TypeID.X86_MMXTyID) {
      {
        VectorType /*P*/ thatPTy = dyn_cast_VectorType(Ty);
        if ((thatPTy != null)) {
          if (thatPTy.getBitWidth() == 64) {
            return true;
          }
        }
      }
    }
    {
      
      // At this point we have only various mismatches of the first class types
      // remaining and ptr->ptr. Just select the lossless conversions. Everything
      // else is not lossless. Conservatively assume we can't losslessly convert
      // between pointers with different address spaces.
      /*const*/ PointerType /*P*/ PTy = dyn_cast_PointerType(this);
      if ((PTy != null)) {
        {
          PointerType /*P*/ OtherPTy = dyn_cast_PointerType(Ty);
          if ((OtherPTy != null)) {
            return PTy.getAddressSpace() == OtherPTy.getAddressSpace();
          }
        }
        return false;
      }
    }
    return false; // Other types have no identity values
  }


  
  /// Return true if this type is empty, that is, it has no elements or all of
  /// its elements are empty.
  
  /// Return true if this type is empty, that is, it has no elements or all of
  /// its elements are empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isEmptyTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 91,
   FQN="llvm::Type::isEmptyTy", NM="_ZNK4llvm4Type9isEmptyTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type9isEmptyTyEv")
  //</editor-fold>
  public boolean isEmptyTy() /*const*/ {
    {
      /*const*/ ArrayType /*P*/ ATy = dyn_cast_ArrayType(this);
      if ((ATy != null)) {
        /*uint*/int NumElements = $ulong2uint(ATy.getNumElements());
        return NumElements == 0 || ATy.getElementType().isEmptyTy();
      }
    }
    {
      
      /*const*/ StructType /*P*/ STy = dyn_cast_StructType(this);
      if ((STy != null)) {
        /*uint*/int NumElements = STy.getNumElements();
        for (/*uint*/int i = 0; $less_uint(i, NumElements); ++i)  {
          if (!STy.getElementType(i).isEmptyTy()) {
            return false;
          }
        }
        return true;
      }
    }
    
    return false;
  }


  
  /// Return true if the type is "first class", meaning it is a valid type for a
  /// Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFirstClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 231,
   FQN="llvm::Type::isFirstClassType", NM="_ZNK4llvm4Type16isFirstClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type16isFirstClassTypeEv")
  //</editor-fold>
  public boolean isFirstClassType() /*const*/ {
    return getTypeID() != TypeID.FunctionTyID && getTypeID() != TypeID.VoidTyID;
  }

  
  /// Return true if the type is a valid type for a register in codegen. This
  /// includes all first-class types except struct and array types.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isSingleValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 237,
   FQN="llvm::Type::isSingleValueType", NM="_ZNK4llvm4Type17isSingleValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type17isSingleValueTypeEv")
  //</editor-fold>
  public boolean isSingleValueType() /*const*/ {
    return isFloatingPointTy() || isX86_MMXTy() || isIntegerTy()
       || isPointerTy() || isVectorTy();
  }

  
  /// Return true if the type is an aggregate type. This means it is valid as
  /// the first operand of an insertvalue or extractvalue instruction. This
  /// includes struct and array types, but does not include vector types.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isAggregateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 245,
   FQN="llvm::Type::isAggregateType", NM="_ZNK4llvm4Type15isAggregateTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type15isAggregateTypeEv")
  //</editor-fold>
  public boolean isAggregateType() /*const*/ {
    return getTypeID() == TypeID.StructTyID || getTypeID() == TypeID.ArrayTyID;
  }

  
  /// Return true if it makes sense to take the size of this type. To get the
  /// actual size for a particular target, it is reasonable to use the
  /// DataLayout subsystem to do this.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isSized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 252,
   FQN="llvm::Type::isSized", NM="_ZNK4llvm4Type7isSizedEPNS_15SmallPtrSetImplIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type7isSizedEPNS_15SmallPtrSetImplIPS0_EE")
  //</editor-fold>
  public boolean isSized() /*const*/ {
    return isSized((SmallPtrSetImpl<Type /*P*/ > /*P*/ )null);
  }
  public boolean isSized(SmallPtrSetImpl<Type /*P*/ > /*P*/ Visited/*= null*/) /*const*/ {
    // If it's a primitive, it is always sized.
    if (getTypeID() == TypeID.IntegerTyID || isFloatingPointTy()
       || getTypeID() == TypeID.PointerTyID
       || getTypeID() == TypeID.X86_MMXTyID) {
      return true;
    }
    // If it is not something that can have a size (e.g. a function or label),
    // it doesn't have a size.
    if (getTypeID() != TypeID.StructTyID && getTypeID() != TypeID.ArrayTyID
       && getTypeID() != TypeID.VectorTyID) {
      return false;
    }
    // Otherwise we have to try harder to decide.
    return isSizedDerivedType(Visited);
  }

  
  /// Return the basic size of this type if it is a primitive type. These are
  /// fixed by LLVM and are not target-dependent.
  /// This will return zero if the type does not have a size or is not a
  /// primitive type.
  ///
  /// Note that this may not reflect the size of memory allocated for an
  /// instance of the type or the number of bytes that are written when an
  /// instance of the type is stored to memory. The DataLayout class provides
  /// additional query functions to provide this information.
  ///
  
  /// Return the basic size of this type if it is a primitive type. These are
  /// fixed by LLVM and are not target-dependent.
  /// This will return zero if the type does not have a size or is not a
  /// primitive type.
  ///
  /// Note that this may not reflect the size of memory allocated for an
  /// instance of the type or the number of bytes that are written when an
  /// instance of the type is stored to memory. The DataLayout class provides
  /// additional query functions to provide this information.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPrimitiveSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 108,
   FQN="llvm::Type::getPrimitiveSizeInBits", NM="_ZNK4llvm4Type22getPrimitiveSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type22getPrimitiveSizeInBitsEv")
  //</editor-fold>
  public /*uint*/int getPrimitiveSizeInBits() /*const*//* __attribute__((pure))*/ {
    switch (getTypeID()) {
     case HalfTyID:
      return 16;
     case FloatTyID:
      return 32;
     case DoubleTyID:
      return 64;
     case X86_FP80TyID:
      return 80;
     case FP128TyID:
      return 128;
     case PPC_FP128TyID:
      return 128;
     case X86_MMXTyID:
      return 64;
     case IntegerTyID:
      return cast_IntegerType(this).getBitWidth();
     case VectorTyID:
      return cast_VectorType(this).getBitWidth();
     default:
      return 0;
    }
  }


  
  /// If this is a vector type, return the getPrimitiveSizeInBits value for the
  /// element type. Otherwise return the getPrimitiveSizeInBits value for this
  /// type.
  
  /// If this is a vector type, return the getPrimitiveSizeInBits value for the
  /// element type. Otherwise return the getPrimitiveSizeInBits value for this
  /// type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getScalarSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 123,
   FQN="llvm::Type::getScalarSizeInBits", NM="_ZNK4llvm4Type19getScalarSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type19getScalarSizeInBitsEv")
  //</editor-fold>
  public /*uint*/int getScalarSizeInBits() /*const*//* __attribute__((pure))*/ {
    return getScalarType().getPrimitiveSizeInBits();
  }


  
  /// Return the width of the mantissa of this type. This is only valid on
  /// floating-point types. If the FP type does not have a stable mantissa (e.g.
  /// ppc long double), this method returns -1.
  
  /// Return the width of the mantissa of this type. This is only valid on
  /// floating-point types. If the FP type does not have a stable mantissa (e.g.
  /// ppc long double), this method returns -1.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFPMantissaWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 127,
   FQN="llvm::Type::getFPMantissaWidth", NM="_ZNK4llvm4Type18getFPMantissaWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type18getFPMantissaWidthEv")
  //</editor-fold>
  public int getFPMantissaWidth() /*const*/ {
    {
      /*const*/ VectorType /*P*/ VTy = dyn_cast_VectorType(this);
      if ((VTy != null)) {
        return VTy.getElementType().getFPMantissaWidth();
      }
    }
    assert (isFloatingPointTy()) : "Not a floating point type!";
    if (getTypeID() == TypeID.HalfTyID) {
      return 11;
    }
    if (getTypeID() == TypeID.FloatTyID) {
      return 24;
    }
    if (getTypeID() == TypeID.DoubleTyID) {
      return 53;
    }
    if (getTypeID() == TypeID.X86_FP80TyID) {
      return 64;
    }
    if (getTypeID() == TypeID.FP128TyID) {
      return 113;
    }
    assert (getTypeID() == TypeID.PPC_FP128TyID) : "unknown fp type";
    return -1;
  }


  
  /// If this is a vector type, return the element type, otherwise return
  /// 'this'.
  
  /// If this is a vector type, return the element type, otherwise return
  /// 'this'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getScalarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 44,
   FQN="llvm::Type::getScalarType", NM="_ZNK4llvm4Type13getScalarTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type13getScalarTypeEv")
  //</editor-fold>
  public Type /*P*/ getScalarType() /*const*//* __attribute__((pure))*/ {
    {
      /*const*/ VectorType /*P*/ VTy = dyn_cast_VectorType(this);
      if ((VTy != null)) {
        return VTy.getElementType();
      }
    }
    return ((/*const_cast*/Type /*P*/ )(this));
  }


  
  //===--------------------------------------------------------------------===//
  // Type Iteration support.
  //
  // JAVA: typedef Type *const *subtype_iterator
//  public final class subtype_iterator extends type$ptr<Type /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::subtype_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 297,
   FQN="llvm::Type::subtype_begin", NM="_ZNK4llvm4Type13subtype_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type13subtype_beginEv")
  //</editor-fold>
  public type$ptr<Type /*P*/ /*const*/ /*P*/> subtype_begin() /*const*/ {
    return ContainedTys;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::subtype_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 298,
   FQN="llvm::Type::subtype_end", NM="_ZNK4llvm4Type11subtype_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type11subtype_endEv")
  //</editor-fold>
  public type$ptr<Type /*P*/ /*const*/ /*P*/> subtype_end() /*const*/ {
    return NumContainedTys == 0 ? ContainedTys : ContainedTys.$add(NumContainedTys);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::subtypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 299,
   FQN="llvm::Type::subtypes", NM="_ZNK4llvm4Type8subtypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type8subtypesEv")
  //</editor-fold>
  public ArrayRef<Type /*P*/ > subtypes() /*const*/ {
    return makeArrayRef(subtype_begin(), subtype_end());
  }

  
  // JAVA: typedef std::reverse_iterator<subtype_iterator> subtype_reverse_iterator
//  public final class subtype_reverse_iterator extends std.reverse_iterator<Type /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::subtype_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 304,
   FQN="llvm::Type::subtype_rbegin", NM="_ZNK4llvm4Type14subtype_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type14subtype_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Type /*P*/ /*const*/> subtype_rbegin() /*const*/ {
    return new std.reverse_iterator<Type /*P*/ /*const*/>(subtype_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::subtype_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 307,
   FQN="llvm::Type::subtype_rend", NM="_ZNK4llvm4Type12subtype_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type12subtype_rendEv")
  //</editor-fold>
  public std.reverse_iterator<Type /*P*/ /*const*/> subtype_rend() /*const*/ {
    return new std.reverse_iterator<Type /*P*/ /*const*/>(subtype_begin());
  }

  
  /// This method is used to implement the type iterator (defined at the end of
  /// the file). For derived types, this returns the types 'contained' in the
  /// derived type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getContainedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 314,
   FQN="llvm::Type::getContainedType", NM="_ZNK4llvm4Type16getContainedTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type16getContainedTypeEj")
  //</editor-fold>
  public Type /*P*/ getContainedType(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumContainedTys)) : "Index out of range!";
    return ContainedTys.$at(i);
  }

  
  /// Return the number of types in the derived type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getNumContainedTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 320,
   FQN="llvm::Type::getNumContainedTypes", NM="_ZNK4llvm4Type20getNumContainedTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getNumContainedTypesEv")
  //</editor-fold>
  public /*uint*/int getNumContainedTypes() /*const*/ {
    return NumContainedTys;
  }

  
  //===--------------------------------------------------------------------===//
  // Helper methods corresponding to subclass methods.  This forces a cast to
  // the specified subclass and calls its accessor.  "getVectorNumElements" (for
  // example) is shorthand for cast<VectorType>(Ty)->getNumElements().  This is
  // only intended to cover the core methods that are frequently used, helper
  // methods should not be added here.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getIntegerBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 93,
   FQN="llvm::Type::getIntegerBitWidth", NM="_ZNK4llvm4Type18getIntegerBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type18getIntegerBitWidthEv")
  //</editor-fold>
  public /*uint*/int getIntegerBitWidth() /*const*/ {
    return cast_IntegerType(this).getBitWidth();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFunctionParamType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 147,
   FQN="llvm::Type::getFunctionParamType", NM="_ZNK4llvm4Type20getFunctionParamTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getFunctionParamTypeEj")
  //</editor-fold>
  public Type /*P*/ getFunctionParamType(/*uint*/int i) /*const*/ {
    return cast_FunctionType(this).getParamType(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFunctionNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 151,
   FQN="llvm::Type::getFunctionNumParams", NM="_ZNK4llvm4Type20getFunctionNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getFunctionNumParamsEv")
  //</editor-fold>
  public /*uint*/int getFunctionNumParams() /*const*/ {
    return cast_FunctionType(this).getNumParams();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isFunctionVarArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 143,
   FQN="llvm::Type::isFunctionVarArg", NM="_ZNK4llvm4Type16isFunctionVarArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type16isFunctionVarArgEv")
  //</editor-fold>
  public boolean isFunctionVarArg() /*const*/ {
    return cast_FunctionType(this).isVarArg();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getStructName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 296,
   FQN="llvm::Type::getStructName", NM="_ZNK4llvm4Type13getStructNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type13getStructNameEv")
  //</editor-fold>
  public StringRef getStructName() /*const*/ {
    return cast_StructType(this).getName();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getStructNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 300,
   FQN="llvm::Type::getStructNumElements", NM="_ZNK4llvm4Type20getStructNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getStructNumElementsEv")
  //</editor-fold>
  public /*uint*/int getStructNumElements() /*const*/ {
    return cast_StructType(this).getNumElements();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getStructElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 304,
   FQN="llvm::Type::getStructElementType", NM="_ZNK4llvm4Type20getStructElementTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getStructElementTypeEj")
  //</editor-fold>
  public Type /*P*/ getStructElementType(/*uint*/int N) /*const*/ {
    return cast_StructType(this).getElementType(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getSequentialElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 339,
   FQN="llvm::Type::getSequentialElementType", NM="_ZNK4llvm4Type24getSequentialElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type24getSequentialElementTypeEv")
  //</editor-fold>
  public /*inline*/ Type /*P*/ getSequentialElementType() /*const*/ {
    assert (Type.isSequentialType(getTypeID())) : "Not a sequential type!";
    return ContainedTys.$at(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getArrayNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 360,
   FQN="llvm::Type::getArrayNumElements", NM="_ZNK4llvm4Type19getArrayNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type19getArrayNumElementsEv")
  //</editor-fold>
  public long/*uint64_t*/ getArrayNumElements() /*const*/ {
    return cast_ArrayType(this).getNumElements();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getArrayElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 345,
   FQN="llvm::Type::getArrayElementType", NM="_ZNK4llvm4Type19getArrayElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type19getArrayElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getArrayElementType() /*const*/ {
    return getSequentialElementType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getVectorNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 438,
   FQN="llvm::Type::getVectorNumElements", NM="_ZNK4llvm4Type20getVectorNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getVectorNumElementsEv")
  //</editor-fold>
  public /*uint*/int getVectorNumElements() /*const*/ {
    return cast_VectorType(this).getNumElements();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getVectorElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 348,
   FQN="llvm::Type::getVectorElementType", NM="_ZNK4llvm4Type20getVectorElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type20getVectorElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getVectorElementType() /*const*/ {
    return getSequentialElementType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPointerElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 350,
   FQN="llvm::Type::getPointerElementType", NM="_ZNK4llvm4Type21getPointerElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type21getPointerElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getPointerElementType() /*const*/ {
    return getSequentialElementType();
  }

  
  /// Get the address space of this pointer or pointer vector type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 474,
   FQN="llvm::Type::getPointerAddressSpace", NM="_ZNK4llvm4Type22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm4Type22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return cast_PointerType(getScalarType()).getAddressSpace();
  }

  
  //===--------------------------------------------------------------------===//
  // Static members exported by the Type class itself.  Useful for getting
  // instances of Type.
  //
  
  /// Return a type based on an identifier.
  
  //===--------------------------------------------------------------------===//
  // Static members exported by the Type class itself.  Useful for getting
  // instances of Type.
  //
  
  /// Return a type based on an identifier.
  
  //===----------------------------------------------------------------------===//
  //                         Type Class Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPrimitiveType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 26,
   FQN="llvm::Type::getPrimitiveType", NM="_ZN4llvm4Type16getPrimitiveTypeERNS_11LLVMContextENS0_6TypeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type16getPrimitiveTypeERNS_11LLVMContextENS0_6TypeIDE")
  //</editor-fold>
  public static Type /*P*/ getPrimitiveType(final LLVMContext /*&*/ C, TypeID IDNumber) {
    switch (IDNumber) {
     case VoidTyID:
      return Type.getVoidTy(C);
     case HalfTyID:
      return Type.getHalfTy(C);
     case FloatTyID:
      return Type.getFloatTy(C);
     case DoubleTyID:
      return Type.getDoubleTy(C);
     case X86_FP80TyID:
      return Type.getX86_FP80Ty(C);
     case FP128TyID:
      return Type.getFP128Ty(C);
     case PPC_FP128TyID:
      return Type.getPPC_FP128Ty(C);
     case LabelTyID:
      return Type.getLabelTy(C);
     case MetadataTyID:
      return Type.getMetadataTy(C);
     case X86_MMXTyID:
      return Type.getX86_MMXTy(C);
     case TokenTyID:
      return Type.getTokenTy(C);
     default:
      return null;
    }
  }


  
  //===--------------------------------------------------------------------===//
  // These are the builtin types that are always available.
  //
  
  //===--------------------------------------------------------------------===//
  // These are the builtin types that are always available.
  //
  
  //===----------------------------------------------------------------------===//
  //                          Primitive 'Type' data
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getVoidTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 154,
   FQN="llvm::Type::getVoidTy", NM="_ZN4llvm4Type9getVoidTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type9getVoidTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getVoidTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.VoidTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getLabelTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 155,
   FQN="llvm::Type::getLabelTy", NM="_ZN4llvm4Type10getLabelTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getLabelTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getLabelTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.LabelTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getHalfTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 156,
   FQN="llvm::Type::getHalfTy", NM="_ZN4llvm4Type9getHalfTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type9getHalfTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getHalfTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.HalfTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFloatTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 157,
   FQN="llvm::Type::getFloatTy", NM="_ZN4llvm4Type10getFloatTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getFloatTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getFloatTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.FloatTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getDoubleTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 158,
   FQN="llvm::Type::getDoubleTy", NM="_ZN4llvm4Type11getDoubleTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type11getDoubleTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getDoubleTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.DoubleTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getMetadataTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 159,
   FQN="llvm::Type::getMetadataTy", NM="_ZN4llvm4Type13getMetadataTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getMetadataTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getMetadataTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.MetadataTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getX86_FP80Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 161,
   FQN="llvm::Type::getX86_FP80Ty", NM="_ZN4llvm4Type13getX86_FP80TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getX86_FP80TyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getX86_FP80Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.X86_FP80Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFP128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 162,
   FQN="llvm::Type::getFP128Ty", NM="_ZN4llvm4Type10getFP128TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getFP128TyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getFP128Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.FP128Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPPC_FP128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 163,
   FQN="llvm::Type::getPPC_FP128Ty", NM="_ZN4llvm4Type14getPPC_FP128TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type14getPPC_FP128TyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getPPC_FP128Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.PPC_FP128Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getX86_MMXTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 164,
   FQN="llvm::Type::getX86_MMXTy", NM="_ZN4llvm4Type12getX86_MMXTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type12getX86_MMXTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getX86_MMXTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.X86_MMXTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getTokenTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 160,
   FQN="llvm::Type::getTokenTy", NM="_ZN4llvm4Type10getTokenTyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getTokenTyERNS_11LLVMContextE")
  //</editor-fold>
  public static Type /*P*/ getTokenTy(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.TokenTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getIntNTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 173,
   FQN="llvm::Type::getIntNTy", NM="_ZN4llvm4Type9getIntNTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type9getIntNTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static IntegerType /*P*/ getIntNTy(final LLVMContext /*&*/ C, /*uint*/int N) {
    return IntegerType.get(C, N);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt1Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 166,
   FQN="llvm::Type::getInt1Ty", NM="_ZN4llvm4Type9getInt1TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type9getInt1TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt1Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int1Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt8Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 167,
   FQN="llvm::Type::getInt8Ty", NM="_ZN4llvm4Type9getInt8TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type9getInt8TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt8Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int8Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt16Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 168,
   FQN="llvm::Type::getInt16Ty", NM="_ZN4llvm4Type10getInt16TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getInt16TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt16Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int16Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt32Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 169,
   FQN="llvm::Type::getInt32Ty", NM="_ZN4llvm4Type10getInt32TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getInt32TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt32Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int32Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt64Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 170,
   FQN="llvm::Type::getInt64Ty", NM="_ZN4llvm4Type10getInt64TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type10getInt64TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt64Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int64Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt128Ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 171,
   FQN="llvm::Type::getInt128Ty", NM="_ZN4llvm4Type11getInt128TyERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type11getInt128TyERNS_11LLVMContextE")
  //</editor-fold>
  public static IntegerType /*P*/ getInt128Ty(final LLVMContext /*&*/ C) {
    return /*AddrOf*/C.pImpl.Int128Ty;
  }


  
  //===--------------------------------------------------------------------===//
  // Convenience methods for getting pointer types with one of the above builtin
  // types as pointee.
  //
  
  //===--------------------------------------------------------------------===//
  // Convenience methods for getting pointer types with one of the above builtin
  // types as pointee.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getHalfPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 177,
   FQN="llvm::Type::getHalfPtrTy", NM="_ZN4llvm4Type12getHalfPtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type12getHalfPtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getHalfPtrTy(final LLVMContext /*&*/ C) {
    return getHalfPtrTy(C, 0);
  }
  public static PointerType /*P*/ getHalfPtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getHalfTy(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFloatPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 181,
   FQN="llvm::Type::getFloatPtrTy", NM="_ZN4llvm4Type13getFloatPtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getFloatPtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getFloatPtrTy(final LLVMContext /*&*/ C) {
    return getFloatPtrTy(C, 0);
  }
  public static PointerType /*P*/ getFloatPtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getFloatTy(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getDoublePtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 185,
   FQN="llvm::Type::getDoublePtrTy", NM="_ZN4llvm4Type14getDoublePtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type14getDoublePtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getDoublePtrTy(final LLVMContext /*&*/ C) {
    return getDoublePtrTy(C, 0);
  }
  public static PointerType /*P*/ getDoublePtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getDoubleTy(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getX86_FP80PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 189,
   FQN="llvm::Type::getX86_FP80PtrTy", NM="_ZN4llvm4Type16getX86_FP80PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type16getX86_FP80PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getX86_FP80PtrTy(final LLVMContext /*&*/ C) {
    return getX86_FP80PtrTy(C, 0);
  }
  public static PointerType /*P*/ getX86_FP80PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getX86_FP80Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getFP128PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 193,
   FQN="llvm::Type::getFP128PtrTy", NM="_ZN4llvm4Type13getFP128PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getFP128PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getFP128PtrTy(final LLVMContext /*&*/ C) {
    return getFP128PtrTy(C, 0);
  }
  public static PointerType /*P*/ getFP128PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getFP128Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPPC_FP128PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 197,
   FQN="llvm::Type::getPPC_FP128PtrTy", NM="_ZN4llvm4Type17getPPC_FP128PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type17getPPC_FP128PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getPPC_FP128PtrTy(final LLVMContext /*&*/ C) {
    return getPPC_FP128PtrTy(C, 0);
  }
  public static PointerType /*P*/ getPPC_FP128PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getPPC_FP128Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getX86_MMXPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 201,
   FQN="llvm::Type::getX86_MMXPtrTy", NM="_ZN4llvm4Type15getX86_MMXPtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type15getX86_MMXPtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getX86_MMXPtrTy(final LLVMContext /*&*/ C) {
    return getX86_MMXPtrTy(C, 0);
  }
  public static PointerType /*P*/ getX86_MMXPtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getX86_MMXTy(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getIntNPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 205,
   FQN="llvm::Type::getIntNPtrTy", NM="_ZN4llvm4Type12getIntNPtrTyERNS_11LLVMContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type12getIntNPtrTyERNS_11LLVMContextEjj")
  //</editor-fold>
  public static PointerType /*P*/ getIntNPtrTy(final LLVMContext /*&*/ C, /*uint*/int N) {
    return getIntNPtrTy(C, N, 0);
  }
  public static PointerType /*P*/ getIntNPtrTy(final LLVMContext /*&*/ C, /*uint*/int N, /*uint*/int AS/*= 0*/) {
    return getIntNTy(C, N).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt1PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 209,
   FQN="llvm::Type::getInt1PtrTy", NM="_ZN4llvm4Type12getInt1PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type12getInt1PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getInt1PtrTy(final LLVMContext /*&*/ C) {
    return getInt1PtrTy(C, 0);
  }
  public static PointerType /*P*/ getInt1PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getInt1Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt8PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 213,
   FQN="llvm::Type::getInt8PtrTy", NM="_ZN4llvm4Type12getInt8PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type12getInt8PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getInt8PtrTy(final LLVMContext /*&*/ C) {
    return getInt8PtrTy(C, 0);
  }
  public static PointerType /*P*/ getInt8PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getInt8Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt16PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 217,
   FQN="llvm::Type::getInt16PtrTy", NM="_ZN4llvm4Type13getInt16PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getInt16PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getInt16PtrTy(final LLVMContext /*&*/ C) {
    return getInt16PtrTy(C, 0);
  }
  public static PointerType /*P*/ getInt16PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getInt16Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt32PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 221,
   FQN="llvm::Type::getInt32PtrTy", NM="_ZN4llvm4Type13getInt32PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getInt32PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getInt32PtrTy(final LLVMContext /*&*/ C) {
    return getInt32PtrTy(C, 0);
  }
  public static PointerType /*P*/ getInt32PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getInt32Ty(C).getPointerTo(AS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getInt64PtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 225,
   FQN="llvm::Type::getInt64PtrTy", NM="_ZN4llvm4Type13getInt64PtrTyERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4Type13getInt64PtrTyERNS_11LLVMContextEj")
  //</editor-fold>
  public static PointerType /*P*/ getInt64PtrTy(final LLVMContext /*&*/ C) {
    return getInt64PtrTy(C, 0);
  }
  public static PointerType /*P*/ getInt64PtrTy(final LLVMContext /*&*/ C, /*uint*/int AS/*= 0*/) {
    return getInt64Ty(C).getPointerTo(AS);
  }


  
  /// Return a pointer to the current type. This is equivalent to
  /// PointerType::get(Foo, AddrSpace).
  
  /// Return a pointer to the current type. This is equivalent to
  /// PointerType::get(Foo, AddrSpace).
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::getPointerTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 685,
   FQN="llvm::Type::getPointerTo", NM="_ZNK4llvm4Type12getPointerToEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type12getPointerToEj")
  //</editor-fold>
  public PointerType /*P*/ getPointerTo() /*const*/ {
    return getPointerTo(0);
  }
  public PointerType /*P*/ getPointerTo(/*uint*/int addrs/*= 0*/) /*const*/ {
    return PointerType.get(((/*const_cast*/Type /*P*/ )(this)), addrs);
  }


/*private:*/
  /// Derived types like structures and arrays are sized iff all of the members
  /// of the type are sized as well. Since asking for their size is relatively
  /// uncommon, move this operation out-of-line.
  /// Derived types like structures and arrays are sized iff all of the members
  /// of the type are sized as well. Since asking for their size is relatively
  /// uncommon, move this operation out-of-line.
  //<editor-fold defaultstate="collapsed" desc="llvm::Type::isSizedDerivedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 140,
   FQN="llvm::Type::isSizedDerivedType", NM="_ZNK4llvm4Type18isSizedDerivedTypeEPNS_15SmallPtrSetImplIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm4Type18isSizedDerivedTypeEPNS_15SmallPtrSetImplIPS0_EE")
  //</editor-fold>
  private boolean isSizedDerivedType() /*const*/ {
    return isSizedDerivedType((SmallPtrSetImpl<Type /*P*/ > /*P*/ )null);
  }
  private boolean isSizedDerivedType(SmallPtrSetImpl<Type /*P*/ > /*P*/ Visited/*= null*/) /*const*/ {
    {
      /*const*/ ArrayType /*P*/ ATy = dyn_cast_ArrayType(this);
      if ((ATy != null)) {
        return ATy.getElementType().isSized(Visited);
      }
    }
    {
      
      /*const*/ VectorType /*P*/ VTy = dyn_cast_VectorType(this);
      if ((VTy != null)) {
        return VTy.getElementType().isSized(Visited);
      }
    }
    
    return cast_StructType(this).isSized(Visited);
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Type(Type $Prm0) { 
    this.Context = $Prm0.Context; 
    this.ID = $Prm0.ID;
    this.SubclassData = $Prm0.SubclassData;
    this.NumContainedTys = $Prm0.NumContainedTys;
    this.ContainedTys = Native.$Clone($Prm0.ContainedTys);
  }

  protected static <T> T $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(NativeMemory.BumpAllocator alloc, NativeCallback.New$ConstructorCallback<T/*P*/> New$Type) {
    return New$Type.$call(null);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    String printedType = "";
    if (true) {
      // TypePrinting is not yet converted
      printedType = llvm.DumpJavaString(this, (Type $this, raw_ostream OS)->$this.print(OS, true, false));
      return printedType;
    }
    return "" + "Context=" + "[LLVMContext]" // NOI18N
              + ", ID=" + ID // NOI18N
              + ", SubclassData=" + SubclassData // NOI18N
              + ", NumContainedTys=" + NumContainedTys // NOI18N
              + ", ContainedTys=" + ContainedTys; // NOI18N
  }
}
