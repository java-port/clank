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
import static org.clank.java.built_in.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;


/// Class to represent struct types. There are two different kinds of struct
/// types: Literal structs and Identified structs.
///
/// Literal struct types (e.g. { i32, i32 }) are uniqued structurally, and must
/// always have a body when created.  You can get one of these by using one of
/// the StructType::get() forms.
///
/// Identified structs (e.g. %foo or %42) may optionally have a name and are not
/// uniqued.  The names for identified structs are managed at the LLVMContext
/// level, so there can only be a single identified struct with a given name in
/// a particular LLVMContext.  Identified structs may also optionally be opaque
/// (have no body specified).  You get one of these by using one of the
/// StructType::create() forms.
///
/// Independent of what kind of struct you have, the body of a struct type are
/// laid out in memory consequtively with the elements directly one after the
/// other (if the struct is packed) or (if not packed) with padding between the
/// elements as defined by DataLayout (which is required to match what the code
/// generator for a target expects).
///
//<editor-fold defaultstate="collapsed" desc="llvm::StructType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 196,
 FQN="llvm::StructType", NM="_ZN4llvm10StructTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructTypeE")
//</editor-fold>
public class StructType extends /*public*/ CompositeType {
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::StructType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 197,
   FQN="llvm::StructType::StructType", NM="_ZN4llvm10StructTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructTypeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ StructType(final /*const*/ StructType /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 198,
   FQN="llvm::StructType::operator=", NM="_ZN4llvm10StructTypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructTypeaSERKS0_")
  //</editor-fold>
  protected/*private*/ /*const*/ StructType /*&*/ $assign(final /*const*/ StructType /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::StructType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 199,
   FQN="llvm::StructType::StructType", NM="_ZN4llvm10StructTypeC1ERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructTypeC1ERNS_11LLVMContextE")
  //</editor-fold>
  private StructType(final LLVMContext /*&*/ C) {
    // : CompositeType(C, StructTyID), SymbolTableEntry(null) 
    //START JInit
    super(C, TypeID.StructTyID);
    this.SymbolTableEntry = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 201,
   FQN="llvm::StructType::(anonymous)", NM="_ZN4llvm10StructTypeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructTypeE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.NativeUIntEnum {
    /// This is the contents of the SubClassData field.
    SCDB_HasBody(1),
    SCDB_Packed(2),
    SCDB_IsLiteral(4),
    SCDB_IsSized(8);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// For a named struct that actually has a name, this is a pointer to the
  /// symbol table entry (maintained by LLVMContext) for the struct.
  /// This is null if the type is an literal struct or if it is a identified
  /// type that has an empty name.
  private Object/*void P*/ SymbolTableEntry;
/*public:*/
  /// This creates an identified struct.
  
  //===----------------------------------------------------------------------===//
  // StructType Helper functions.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 417,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createERNS_11LLVMContextENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createERNS_11LLVMContextENS_9StringRefE")
  //</editor-fold>
  public static StructType /*P*/ create(final LLVMContext /*&*/ Context, StringRef Name) {
    StructType /*P*/ ST = ((/*JCast*/StructType /*P*/ )(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
    /*Context.pImpl.TypeAllocator = new (Context.pImpl->TypeAllocator)*/ $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(Context.pImpl.TypeAllocator, (type$ptr<?> New$Mem)->{
        return new StructType(Context);
     })));
    if (!Name.empty()) {
      ST.setName(new StringRef(Name));
    }
    return ST;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 454,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createERNS_11LLVMContextE")
  //</editor-fold>
  public static StructType /*P*/ create(final LLVMContext /*&*/ Context) {
    return create(Context, new StringRef());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 458,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createENS_8ArrayRefIPNS_4TypeEEENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createENS_8ArrayRefIPNS_4TypeEEENS_9StringRefEb")
  //</editor-fold>
  public static StructType /*P*/ create(ArrayRef<Type /*P*/ > Elements, StringRef Name) {
    return create(Elements, Name, 
        false);
  }
  public static StructType /*P*/ create(ArrayRef<Type /*P*/ > Elements, StringRef Name, 
        boolean isPacked/*= false*/) {
    assert (!Elements.empty()) : "This method may not be invoked with an empty list";
    return create(Elements.$at(0).getContext(), new ArrayRef<Type /*P*/ >(Elements), new StringRef(Name), isPacked);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 465,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createENS_8ArrayRefIPNS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createENS_8ArrayRefIPNS_4TypeEEE")
  //</editor-fold>
  public static StructType /*P*/ create(ArrayRef<Type /*P*/ > Elements) {
    assert (!Elements.empty()) : "This method may not be invoked with an empty list";
    return create(Elements.$at(0).getContext(), new ArrayRef<Type /*P*/ >(Elements), new StringRef());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 443,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEENS_9StringRefEb")
  //</editor-fold>
  public static StructType /*P*/ create(final LLVMContext /*&*/ Context, ArrayRef<Type /*P*/ > Elements, 
        StringRef Name) {
    return create(Context, Elements, 
        Name, false);
  }
  public static StructType /*P*/ create(final LLVMContext /*&*/ Context, ArrayRef<Type /*P*/ > Elements, 
        StringRef Name, boolean isPacked/*= false*/) {
    StructType /*P*/ ST = create(Context, new StringRef(Name));
    ST.setBody(new ArrayRef<Type /*P*/ >(Elements), isPacked);
    return ST;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 450,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEE")
  //</editor-fold>
  public static StructType /*P*/ create(final LLVMContext /*&*/ Context, ArrayRef<Type /*P*/ > Elements) {
    return create(Context, new ArrayRef<Type /*P*/ >(Elements), new StringRef());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 471,
   FQN="llvm::StructType::create", NM="_ZN4llvm10StructType6createENS_9StringRefEPNS_4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType6createENS_9StringRefEPNS_4TypeEz")
  //</editor-fold>
  public static StructType /*P*/ create(StringRef Name, Type /*P*/ type, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    assert ((type != null)) : "Cannot create a struct type with no elements with this";
    final LLVMContext /*&*/ Ctx = type.getContext();
    type$ptr ap = create_type$ptr();
    SmallVector<Type /*P*/ > StructFields/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    __builtin_va_start($VarArg, ap, type);
    while ((type != null)) {
      StructFields.push_back(type);
      type = __builtin_va_arg(ap, Type /*P*/ .class);
    }
    StructType /*P*/ Ret = StructType.create(Ctx, new ArrayRef<Type /*P*/ >(StructFields, true), new StringRef(Name));
    __builtin_va_end(ap);
    return Ret;
  }

  
  /// This static method is the primary way to create a literal StructType.
  
  //===----------------------------------------------------------------------===//
  //                       StructType Implementation
  //===----------------------------------------------------------------------===//
  
  // Primitive Constructors.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 330,
   FQN="llvm::StructType::get", NM="_ZN4llvm10StructType3getERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType3getERNS_11LLVMContextENS_8ArrayRefIPNS_4TypeEEEb")
  //</editor-fold>
  public static StructType /*P*/ get(final LLVMContext /*&*/ Context, ArrayRef<Type /*P*/ > ETypes) {
    return get(Context, ETypes, 
     false);
  }
  public static StructType /*P*/ get(final LLVMContext /*&*/ Context, ArrayRef<Type /*P*/ > ETypes, 
     boolean isPacked/*= false*/) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    AnonStructTypeKeyInfo.KeyTy Key/*J*/= new AnonStructTypeKeyInfo.KeyTy(ETypes, isPacked);
    DenseSet.iterator<StructType> I = pImpl.AnonStructTypes.find_as_T$C$R(Key);
    StructType /*P*/ ST;
    if (I.$eq(pImpl.AnonStructTypes.end())) {
      // Value not found.  Create a new type!
      ST = ((/*JCast*/StructType /*P*/ )(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
      /*Context.pImpl.TypeAllocator = new (Context.pImpl->TypeAllocator)*/ $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(Context.pImpl.TypeAllocator, (type$ptr<?> New$Mem)->{
          return new StructType(Context);
       })));
      ST.setSubclassData(Unnamed_enum.SCDB_IsLiteral.getValue()); // Literal struct.
      ST.setBody(new ArrayRef<Type /*P*/ >(ETypes), isPacked);
      Context.pImpl.AnonStructTypes.insert(ST);
    } else {
      ST = I.$star();
    }
    
    return ST;
  }

  
  /// Create an empty structure type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 424,
   FQN="llvm::StructType::get", NM="_ZN4llvm10StructType3getERNS_11LLVMContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType3getERNS_11LLVMContextEb")
  //</editor-fold>
  public static StructType /*P*/ get(final LLVMContext /*&*/ Context) {
    return get(Context, false);
  }
  public static StructType /*P*/ get(final LLVMContext /*&*/ Context, boolean isPacked/*= false*/) {
    return get(Context, new ArrayRef<Type /*P*/ >(None, true), isPacked);
  }

  
  /// This static method is a convenience method for creating structure types by
  /// specifying the elements as arguments. Note that this method always returns
  /// a non-packed struct, and requires at least one element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 428,
   FQN="llvm::StructType::get", NM="_ZN4llvm10StructType3getEPNS_4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType3getEPNS_4TypeEz")
  //</editor-fold>
  public static StructType /*P*/ get(Type /*P*/ type, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    assert ((type != null)) : "Cannot create a struct type with no elements with this";
    final LLVMContext /*&*/ Ctx = type.getContext();
    type$ptr ap = create_type$ptr();
    SmallVector<Type /*P*/ > StructFields/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    __builtin_va_start($VarArg, ap, type);
    while ((type != null)) {
      StructFields.push_back(type);
      type = __builtin_va_arg(ap, Type /*P*/ .class);
    }
    StructType /*P*/ Ret = StructType.get(Ctx, new ArrayRef<Type /*P*/ >(StructFields, true));
    __builtin_va_end(ap);
    return Ret;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isPacked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 240,
   FQN="llvm::StructType::isPacked", NM="_ZNK4llvm10StructType8isPackedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType8isPackedEv")
  //</editor-fold>
  public boolean isPacked() /*const*/ {
    return (getSubclassData() & Unnamed_enum.SCDB_Packed.getValue()) != 0;
  }

  
  /// Return true if this type is uniqued by structural equivalence, false if it
  /// is a struct definition.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 244,
   FQN="llvm::StructType::isLiteral", NM="_ZNK4llvm10StructType9isLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType9isLiteralEv")
  //</editor-fold>
  public boolean isLiteral() /*const*/ {
    return (getSubclassData() & Unnamed_enum.SCDB_IsLiteral.getValue()) != 0;
  }

  
  /// Return true if this is a type with an identity that has no body specified
  /// yet. These prints as 'opaque' in .ll files.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isOpaque">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 248,
   FQN="llvm::StructType::isOpaque", NM="_ZNK4llvm10StructType8isOpaqueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType8isOpaqueEv")
  //</editor-fold>
  public boolean isOpaque() /*const*/ {
    return (getSubclassData() & Unnamed_enum.SCDB_HasBody.getValue()) == 0;
  }

  
  /// isSized - Return true if this is a sized type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isSized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 486,
   FQN="llvm::StructType::isSized", NM="_ZNK4llvm10StructType7isSizedEPNS_15SmallPtrSetImplIPNS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType7isSizedEPNS_15SmallPtrSetImplIPNS_4TypeEEE")
  //</editor-fold>
  public boolean isSized() /*const*/ {
    return isSized((SmallPtrSetImpl<Type /*P*/ > /*P*/ )null);
  }
  public boolean isSized(SmallPtrSetImpl<Type /*P*/ > /*P*/ Visited/*= null*/) /*const*/ {
    if ((getSubclassData() & Unnamed_enum.SCDB_IsSized.getValue()) != 0) {
      return true;
    }
    if (isOpaque()) {
      return false;
    }
    if ((Visited != null) && !Visited.insert(((/*const_cast*/StructType /*P*/ )(this))).second) {
      return false;
    }
    
    // Okay, our struct is sized if all of the elements are, but if one of the
    // elements is opaque, the struct isn't sized *yet*, but may become sized in
    // the future, so just bail out without caching.
    for (type$ptr<Type /*P*/ /*const*/ /*P*/> I = $tryClone(element_begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(element_end()); $noteq_ptr(I, E); I.$preInc())  {
      if (!(I.$star()).isSized(Visited)) {
        return false;
      }
    }
    
    // Here we cheat a bit and cast away const-ness. The goal is to memoize when
    // we find a sized type, as types can only move from opaque to sized, not the
    // other way.
    ((/*const_cast*/StructType /*P*/ )(this)).setSubclassData(getSubclassData() | Unnamed_enum.SCDB_IsSized.getValue());
    return true;
  }

  
  /// Return true if this is a named struct that has a non-empty name.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::hasName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 254,
   FQN="llvm::StructType::hasName", NM="_ZNK4llvm10StructType7hasNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType7hasNameEv")
  //</editor-fold>
  public boolean hasName() /*const*/ {
    return SymbolTableEntry != null;
  }

  
  /// Return the name for this struct type if it has an identity.
  /// This may return an empty string for an unnamed struct type.  Do not call
  /// this on an literal type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 510,
   FQN="llvm::StructType::getName", NM="_ZNK4llvm10StructType7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    assert (!isLiteral()) : "Literal structs never have names";
    if (!(SymbolTableEntry != null)) {
      return new StringRef();
    }
    
    return ((StringMapEntry<StructType /*P*/ > /*P*/ )SymbolTableEntry).getKey();
  }

  
  /// Change the name of this type to the specified name, or to a name with a
  /// suffix if there is a collision. Do not call this on an literal type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 367,
   FQN="llvm::StructType::setName", NM="_ZN4llvm10StructType7setNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType7setNameENS_9StringRefE")
  //</editor-fold>
  public void setName(StringRef Name) {
    if ($eq_StringRef(/*NO_COPY*/Name, getName())) {
      return;
    }
    
    final StringMap<StructType /*P*/ > /*&*/ SymbolTable = getContext().pImpl.NamedStructTypes;
    // JAVA: typedef StringMap<StructType *>::MapEntryTy EntryTy
//    final class EntryTy extends StringMapEntry<StructType /*P*/ >{ };
    
    // If this struct already had a name, remove its symbol table entry. Don't
    // delete the data yet because it may be part of the new name.
    if ((SymbolTableEntry != null)) {
      SymbolTable.remove((StringMapEntry<StructType /*P*/ > /*P*/ )SymbolTableEntry);
    }
    
    // If this is just removing the name, we're done.
    if (Name.empty()) {
      if ((SymbolTableEntry != null)) {
        // Delete the old string data.
        ((StringMapEntry<StructType /*P*/ > /*P*/ )SymbolTableEntry).Destroy$T(SymbolTable.getAllocator());
        SymbolTableEntry = null;
      }
      return;
    }
    
    // Look up the entry for the name.
    std.pairTypeBool<StringMapIterator<StructType /*P*/ >> IterBool = getContext().pImpl.NamedStructTypes.insert(std.make_pair_T_Ptr($Clone(Name), this));
    
    // While we have a name collision, try a random rename.
    if (!IterBool.second) {
      raw_svector_ostream TmpStream = null;
      try {
        SmallString/*<64>*/ TempStr/*J*/= new SmallString/*<64>*/(64, new StringRef(Name));
        TempStr.push_back($$DOT);
        TmpStream/*J*/= new raw_svector_ostream(TempStr);
        /*uint*/int NameSize = Name.size();
        
        do {
          TempStr.resize(NameSize + 1);
          TmpStream.$out_uint(getContext().pImpl.NamedStructTypesUniqueID++);
          
          IterBool.$assignMove(getContext().pImpl.NamedStructTypes.insert(std.make_pair_T_Ptr($Move(TmpStream.str()), this)));
        } while (!IterBool.second);
      } finally {
        if (TmpStream != null) { TmpStream.$destroy(); }
      }
    }
    
    // Delete the old string data.
    if ((SymbolTableEntry != null)) {
      ((StringMapEntry<StructType /*P*/ > /*P*/ )SymbolTableEntry).Destroy$T(SymbolTable.getAllocator());
    }
    SymbolTableEntry = $AddrOf(IterBool.first.$star());
  }

  
  /// Specify a body for an opaque identified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::setBody">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 350,
   FQN="llvm::StructType::setBody", NM="_ZN4llvm10StructType7setBodyENS_8ArrayRefIPNS_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType7setBodyENS_8ArrayRefIPNS_4TypeEEEb")
  //</editor-fold>
  public void setBody(ArrayRef<Type /*P*/ > Elements) {
    setBody(Elements, false);
  }
  public void setBody(ArrayRef<Type /*P*/ > Elements, boolean isPacked/*= false*/) {
    assert (isOpaque()) : "Struct body already set!";
    
    setSubclassData(getSubclassData() | Unnamed_enum.SCDB_HasBody.getValue());
    if (isPacked) {
      setSubclassData(getSubclassData() | Unnamed_enum.SCDB_Packed.getValue());
    }
    
    NumContainedTys = Elements.size();
    if (Elements.empty()) {
      ContainedTys = null;
      return;
    }
    
    ContainedTys = $tryClone(Elements.copy(Type /*P*/.class, getContext().pImpl.TypeAllocator).data());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 517,
   FQN="llvm::StructType::setBody", NM="_ZN4llvm10StructType7setBodyEPNS_4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType7setBodyEPNS_4TypeEz")
  //</editor-fold>
  public void setBody(Type /*P*/ type, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    assert ((type != null)) : "Cannot create a struct type with no elements with this";
    type$ptr ap = create_type$ptr();
    SmallVector<Type /*P*/ > StructFields/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    __builtin_va_start($VarArg, ap, type);
    while ((type != null)) {
      StructFields.push_back(type);
      type = __builtin_va_arg(ap, Type /*P*/ .class);
    }
    setBody(new ArrayRef<Type /*P*/ >(StructFields, true));
    __builtin_va_end(ap);
  }

  
  /// Return true if the specified type is valid as a element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isValidElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 530,
   FQN="llvm::StructType::isValidElementType", NM="_ZN4llvm10StructType18isValidElementTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType18isValidElementTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isValidElementType(Type /*P*/ ElemTy) {
    return !ElemTy.isVoidTy() && !ElemTy.isLabelTy()
       && !ElemTy.isMetadataTy() && !ElemTy.isFunctionTy()
       && !ElemTy.isTokenTy();
  }

  
  // Iterator access to the elements.
  // JAVA: typedef Type::subtype_iterator element_iterator
//  public final class element_iterator extends type$ptr<Type /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::element_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 274,
   FQN="llvm::StructType::element_begin", NM="_ZNK4llvm10StructType13element_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType13element_beginEv")
  //</editor-fold>
  public type$ptr<Type /*P*/ /*const*/ /*P*/> element_begin() /*const*/ {
    return ContainedTys;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::element_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 275,
   FQN="llvm::StructType::element_end", NM="_ZNK4llvm10StructType11element_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType11element_endEv")
  //</editor-fold>
  public type$ptr<Type /*P*/ /*const*/ /*P*/> element_end() /*const*/ {
    return ContainedTys.$add(NumContainedTys);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::elements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 276,
   FQN="llvm::StructType::elements", NM="_ZNK4llvm10StructType8elementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType8elementsEv")
  //</editor-fold>
  public /*const*/ArrayRef<Type /*P*/ > elements() /*const*/ {
    return makeArrayRef(element_begin(), element_end());
  }

  
  /// Return true if this is layout identical to the specified struct.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::isLayoutIdentical">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 536,
   FQN="llvm::StructType::isLayoutIdentical", NM="_ZNK4llvm10StructType17isLayoutIdenticalEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType17isLayoutIdenticalEPS0_")
  //</editor-fold>
  public boolean isLayoutIdentical(StructType /*P*/ Other) /*const*/ {
    if (this == Other) {
      return true;
    }
    if (isPacked() != Other.isPacked()) {
      return false;
    }
    
    return $eq_ArrayRef$T(elements(), Other.elements());
  }

  
  /// Random access to the elements
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 284,
   FQN="llvm::StructType::getNumElements", NM="_ZNK4llvm10StructType14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    return NumContainedTys;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 285,
   FQN="llvm::StructType::getElementType", NM="_ZNK4llvm10StructType14getElementTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm10StructType14getElementTypeEj")
  //</editor-fold>
  public Type /*P*/ getElementType(/*uint*/int N) /*const*/ {
    assert ($less_uint(N, NumContainedTys)) : "Element number out of range!";
    return ContainedTys.$at(N);
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::StructType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 291,
   FQN="llvm::StructType::classof", NM="_ZN4llvm10StructType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm10StructType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.StructTyID;
  }

  
  @Override public String toString() {
    return "" + "SymbolTableEntry=[" + NativeTrace.getIdentityStr(SymbolTableEntry) + "]" // NOI18N
              + super.toString(); // NOI18N
  }
}
