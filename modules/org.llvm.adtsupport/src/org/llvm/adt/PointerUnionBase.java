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

package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

/**
 *
 * @author vv159170
 */

/// A discriminated union of two pointer types, with the discriminator in the
/// low bit of the pointer.
///
/// This implementation is extremely efficient in space due to leveraging the
/// low bits of the pointer, while exposing a natural and type-safe API.
///
/// Common use patterns would be something like this:
///    PointerUnion<int*, float*> P;
///    P = (int*)0;
///    printf("%d %d", P.is<int*>(), P.is<float*>());  // prints "1 0"
///    X = P.get<int*>();     // ok.
///    Y = P.get<float*>();   // runtime assertion failure.
///    Z = P.get<double*>();  // compile time failure.
///    P = (float*)0;
///    Y = P.get<float*>();   // ok.
///    X = P.get<int*>();     // runtime assertion failure.
/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 83,
 FQN="llvm::PointerUnion", NM="_ZN4llvm12PointerUnionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionE")
//</editor-fold>
public abstract class PointerUnionBase<Derived extends PointerUnionBase> implements Native.NativePOD<Derived>, Native.Native$Bool, NativeHashable, NativePointerLike  {
///*public:*/
//  /*typedef PointerIntPair<void *, 1, bool, PointerUnionUIntTraits<PT1, PT2> > ValTy*/
////  public final class ValTy extends PointerIntPair<Object/*void P*/ , 1, boolean, PointerUnionUIntTraits<PT1, PT2> >{ };
///*private:*/
//  private PointerIntPair<Object/*void P*/ , 1, boolean, PointerUnionUIntTraits<PT1, PT2> > Val;
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::IsPT1">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 91,
//   FQN="llvm::PointerUnion::IsPT1", NM="_ZN4llvm12PointerUnion5IsPT1E",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion5IsPT1E")
//  //</editor-fold>
//  private static class/*struct*/ IsPT1 {
//    public static /*const*/int Num = 0;
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::IsPT2">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 94,
//   FQN="llvm::PointerUnion::IsPT2", NM="_ZN4llvm12PointerUnion5IsPT2E",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion5IsPT2E")
//  //</editor-fold>
//  private static class/*struct*/ IsPT2 {
//    public static /*const*/int Num = 1;
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::UNION_DOESNT_CONTAIN_TYPE">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 97,
//   FQN="llvm::PointerUnion::UNION_DOESNT_CONTAIN_TYPE", NM="_ZN4llvm12PointerUnion25UNION_DOESNT_CONTAIN_TYPEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnion25UNION_DOESNT_CONTAIN_TYPEE")
//  //</editor-fold>
//  public static class/*struct*/ UNION_DOESNT_CONTAIN_TYPE</*typename*/ T>  {
//    
//    @Override public String toString() {
//      return ""; // NOI18N
//    }
//  };
  
  protected Object Val;
  
  protected <T> PointerUnionBase(Class<T> cls, T val) {
    assign_impl(cls, val);
  }

  /// Test if the pointer held in the union is null, regardless of
  /// which type it is.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::isNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 111,
   FQN="llvm::PointerUnion::isNull", NM="_ZNK4llvm12PointerUnion6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZNK4llvm12PointerUnion6isNullEv")
  //</editor-fold>
  public final boolean isNull() /*const*/ {
    // Convert from the void* to one of the pointer types, to make sure that
    // we recursively strip off low bits if we have a nested PointerUnion.    
    return isJavaNullMarker() || Native.$not(Val);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 116,
   FQN="llvm::PointerUnion::operator bool", NM="_ZNK4llvm12PointerUnioncvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZNK4llvm12PointerUnioncvbEv")
  //</editor-fold>
  public final boolean $bool() {
    return !isNull();
  }
  
  
  /// Test if the Union currently holds the type matching T.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::is">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 119,
   FQN="llvm::PointerUnion::is", NM="Tpl__ZNK4llvm12PointerUnion2isEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=Tpl__ZNK4llvm12PointerUnion2isEv")
  //</editor-fold>
  public final <T> int is(Class<T> cls) {
    assert cls != null;
    assert Val != null : "To implement native behaviour we must store class of the first template parameter!";
    return (cls == Val) || cls.isInstance(Val) ? 1 : 0;
  }
  
  
  /// Returns the value of the specified pointer type.
  ///
  /// If the specified pointer type is incorrect, assert.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 131,
   FQN="llvm::PointerUnion::get", NM="Tpl__ZNK4llvm12PointerUnion3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=Tpl__ZNK4llvm12PointerUnion3getEv")
  //</editor-fold>
  public final </*typename*/ T> T get(Class<T> cls) {
    assert Native.$bool(is(cls)) : "Invalid accessor called: " + cls + " vs. " + Val;
    // cls is marker for null value of class
    if (Val == cls) { return null; }
    return (T) Val;
  }  
  
  
  /// Returns the current pointer if it is of the specified pointer type,
  /// otherwises returns null.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::dyn_cast">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 138,
   FQN="llvm::PointerUnion::dyn_cast", NM="Tpl__ZNK4llvm12PointerUnion8dyn_castEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=Tpl__ZNK4llvm12PointerUnion8dyn_castEv")
  //</editor-fold>
  public final </*typename*/ T> T dyn_cast(Class<T> cls) /*const*/ {
    if (is(cls) != 0) {
      return get(cls);
    }
    return (T)null;
  }    
  
  /// Assignment from nullptr which just clears the union.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 161,
   FQN="llvm::PointerUnion::operator=", NM="_ZN4llvm12PointerUnionaSEDn",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm12PointerUnionaSEDn")
  //</editor-fold>
  public final /*const*/ Derived /*&*/ $assign_nullptr_t(/*nullptr_t*/Object $Prm0) {
    if (Val instanceof PointerUnion) {
      ((PointerUnion)Val).$assign_nullptr_t($Prm0);
    } else if (Val instanceof PointerIntPair) {
      ((PointerIntPair)Val).initWithPointer(null);
    } else {
      assert Val != null : "we have lost class type here...";
      Val = isJavaNullMarker() ? Val : Val.getClass();
    }
    return (Derived)this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::getOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 180,
   FQN="llvm::PointerUnion::getOpaqueValue", NM="_ZNK4llvm12PointerUnion14getOpaqueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZNK4llvm12PointerUnion14getOpaqueValueEv")
  //</editor-fold>
  public final Object/*void P*/ getOpaqueValue() /*const*/ {
    return Val/*.getOpaqueValue()*/;
  }
  
  protected PointerUnionBase(Object /*void*/ VP) { 
    assert VP != null;
    this.Val = VP instanceof NativePointerLike ? $Clone((NativeCloneable)VP) : VP;
  }  
  
  public final Derived $assignMove(Derived RHS) {
    assert this != RHS;
    this.Val = RHS.Val instanceof NativePointerLike ? $tryMove(RHS.Val) : RHS.Val;
//    RHS.Val = null;
    return (Derived)this;
  }
  
  protected PointerUnionBase(Derived /*&*/ RHS) {
    this.Val = RHS.Val instanceof NativePointerLike ? $Clone((NativeCloneable)RHS.Val) : RHS.Val;
  }

  protected PointerUnionBase(JD$Move INSTANCE, Derived /*&*/ RHS) {
    this.Val = RHS.Val instanceof NativePointerLike ? $tryMove(RHS.Val) : RHS.Val;
//    RHS.Val = null;
  }  
  
  /// Assignment operators - Allow assigning into this union from either
  /// pointer type, setting the discriminator to remember what it came from.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion::operator=">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 168,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 166,
   FQN="llvm::PointerUnion::operator=", NM="_ZN4llvm12PointerUnionaSERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN4llvm12PointerUnionaSERKT_")
  //</editor-fold>
  public final /*const*/ Derived /*&*/ $assign(/*const*/Derived /*&*/ RHS) {
    // usual assign for all except possible type$ptr<?> 
    this.Val = RHS.Val instanceof NativePointerLike ? $Clone((NativeCloneable)RHS.Val) : RHS.Val;
    return (Derived)this;
  }
  
  protected final <T> T assign_impl(Class<T> cls, T value) {
    assert cls != null : "we need class to keep nulls";
    assert !(value instanceof Class) : "value can not be of java.lang.Class type " + value;
    this.Val = value == null ? cls : value;
    return value;
  }
  
  protected final boolean validClasses(Class<?>... classes) {
    for (int i = 0; i < classes.length; i++) {
      Class<?> cls1 = classes[i];
      assert cls1 != null;
      for (int j = i+1; j < classes.length; j++) {
        Class<?> cls2 = classes[j];
        assert cls2 != null;
        assert cls1 != cls2 : "Similar classes! That case is not handled in PointerUnion!";
      }
    }
    return true;
  }

  ///////////////////////////

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{#" + System.identityHashCode(Val) + ":Val=" + (isJavaNullMarker()?"NULL of " : "") + Val + '}';
  }

  @Override
  public abstract Derived clone();

  @Override
  public final boolean $eq(Derived other) {
    if (isNull()) {
      return other == null || other.isNull();
    }
    if (other == null) {
      return false;
    }
    return (this.Val == other.Val);
  }

  public final void ProfilePointerUnion(final FoldingSetNodeID /*&*/ ID) {
    ID.AddPointer(Val);
  }

  protected final <T> type$ptr<T> $getAddrOfPointer(final Class<T> cls) {
    assert Native.$bool(is(cls)) : "Val is not the first pointer";
    assert Native.$bool((get(cls) == Val) || (Val == cls)) : "Can't get the address because PointerLikeTypeTraits changes the ptr";
    return new type$ptr$inout<T>(this) {
      @Override public T $star$impl() { return PointerUnionBase.this.get(cls); }
      @Override public T $set$impl(T value) { return PointerUnionBase.this.assign_impl(cls, value); }
    };
  }

  @Override
  public boolean $eqPointerLike(Object other) {
    if (this == other) {
      return true;
    }
    if (Val == other) {
      return true;
    }
    if (other instanceof PointerUnionBase) {
      return Native.$eq_ptr(Val, ((PointerUnionBase) other).Val);
    }
    assert !(other instanceof NativePointerLike) 
            : "Pointer like comparizon of " + getClass().getCanonicalName() + " with " + other.getClass().getCanonicalName() 
            + " is not implemented!";
    return false;
  }
  
  @Override public int $hashcode() {
    return (this.Val instanceof NativeHashable) ? ((NativeHashable)this.Val).$hashcode() : System.identityHashCode(this.Val);
  }
  
  protected final boolean isJavaNullMarker() {
    return Val instanceof Class;
  }
}
