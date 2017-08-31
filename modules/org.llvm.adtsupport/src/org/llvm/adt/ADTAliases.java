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

import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$tryAssign;
import org.clank.support.NativeSwappable;
import org.clank.support.NativeTrace;
import org.clank.support.abstract_iterator;
import org.clank.support.aliases.*;
import org.clank.support.void$ptr;

/**
 *
 * @author vvoskres
 */
public class ADTAliases {
  
  // JavaDifferentiators
  public static final class JD$IntrusiveRefCntPtr$X$C {
    public static final JD$IntrusiveRefCntPtr$X$C INSTANCE = new JD$IntrusiveRefCntPtr$X$C();
    private JD$IntrusiveRefCntPtr$X$C() {}
  }
  
  public static final class JD$IntrusiveRefCntPtr$X {
    public static final JD$IntrusiveRefCntPtr$X INSTANCE = new JD$IntrusiveRefCntPtr$X();
    private JD$IntrusiveRefCntPtr$X() {}
  }
  
  // llvm::PointerIntPair<T , 2>
  public static class PointerInt2Pair<T> extends PointerIntPair<T> {

    public PointerInt2Pair() {}
    
    public PointerInt2Pair(PointerInt2Pair<T> other) {
      super(other);
    }
    
    public PointerInt2Pair(JD$Move _dparam, PointerInt2Pair<T> other) {
      super(_dparam, other);
    }
    
    public PointerInt2Pair(T object, boolean b) {
      super(object, b ? 1 : 0);
    }

    public PointerInt2Pair(T object, int val) {
      super(object, val);
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerInt2Pair<T> clone() {
      return new PointerInt2Pair<>(this);
    }   
  }
  
  // llvm::PointerIntPair<T , 2, unsigned int>
  public static class PointerUInt2Pair<T> extends PointerIntPair<T> {

    public PointerUInt2Pair() {}

    public PointerUInt2Pair(PointerUInt2Pair<T> other) {
      super(other);
    }

    public PointerUInt2Pair(JD$Move _dparam, PointerUInt2Pair<T> other) {
      super(_dparam, other);
    }

    public PointerUInt2Pair(T object, boolean b) {
      super(object, b ? 1 : 0);
    }

    public PointerUInt2Pair(T object, /*uint*/int val) {
      super(object, val);
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerUInt2Pair<T> clone() {
      return new PointerUInt2Pair<>(this);
    }
  }

  public static class PointerUIntPair<T> extends PointerIntPair<T> {

    public PointerUIntPair() {}

    public PointerUIntPair(PointerUIntPair<T> other) {
      super(other);
    }

    public PointerUIntPair(JD$Move _dparam, PointerUIntPair<T> other) {
      super(_dparam, other);
    }

    public PointerUIntPair(T object, boolean b) {
      super(object, b ? 1 : 0);
    }

    public PointerUIntPair(T object, /*uint*/int val) {
      super(object, val);
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerUIntPair<T> clone() {
      return new PointerUIntPair<>(this);
    }
  }

  // llvm::PointerIntPair<T , 1, bool> 
  public static class PointerBoolPair<T> implements Native.NativePOD<PointerBoolPair<T>>, NativeSwappable {
    private T ptr;
    private boolean boolVal;
    
    private static final PointerBoolPair NULL = new PointerBoolPair();
    public static <T> PointerBoolPair<T> Null() {
      return (PointerBoolPair<T>)NULL;
    }
    
    public PointerBoolPair() {
      this((T) null, false);
    }

    public PointerBoolPair(PointerBoolPair<T> other) {
      this(other.ptr, other.boolVal);
    }
    
    public PointerBoolPair(int Bits, T ptr, boolean e) {
      this(ptr, e);
      assert Bits == 1;
    }
    public PointerBoolPair(T ptr, boolean e) {
      this.ptr = ptr;
      this.boolVal = e;
    }
    
    public PointerBoolPair(JD$Move _dparam, PointerBoolPair<T> other) {
      exchange(other);
    }
        
    @Override
    public PointerBoolPair<T> $assign(PointerBoolPair<T> other) {
      this.ptr = other.ptr;
      this.boolVal = other.boolVal;
      return this;
    }
    
    public PointerBoolPair<T> $assignMove(PointerBoolPair<T> other) {
      exchange(other);
      return this;
    }
    
    public Object/*P*/ getOpaqueValue() {
      // we use PointerBoolPair as state
      return new PointerBoolPair(this);
    }
    
    public final void ProfilePointerIntPair(final FoldingSetNodeID /*&*/ ID) {
      ID.AddPointer(this.ptr);
      ID.AddBoolean(this.boolVal);
    } 
    
    public void setFromOpaqueValue(Object Val) {
      this.$assign((PointerBoolPair<T>)Val);
    }    
    public static <T> PointerBoolPair<T/*P*/> getFromOpaqueValue_voidPtr(Object P) {
      return new PointerBoolPair((PointerBoolPair<T>)P);
    }
    
    public static <T> PointerBoolPair<T/*P*/> getFromOpaqueValue_ConstVoidPtr(Object P) {
      return new PointerBoolPair((PointerBoolPair<T>)P);
    }
    
    public T getPointer() {
      return this.ptr;
    }

    public boolean getBool() {
      return this.boolVal;
    }

    public boolean getInt() {
      return this.getBool();
    }

    public void setInt(boolean val) {
      this.boolVal = val;
    }
    
    public void setPointer(T val) {
      this.ptr = val;
    }
    
    public void setPointerAndInt(T PtrVal, boolean IntVal) {
      this.ptr = PtrVal;
      this.boolVal = IntVal;
    }

    @Override
    public String toString() {
      return "PointerBoolPair{" + "ptr=" + NativeTrace.getIdentityStr(ptr) + ", val=" + boolVal + '}';
    }        
    
    private void exchange(PointerBoolPair<T> other) {
      T tmpPtr = this.ptr;
      boolean tmpEnumVal = this.boolVal;
      this.ptr = other.ptr;
      this.boolVal = other.boolVal;
      other.ptr = tmpPtr;
      other.boolVal = tmpEnumVal;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerBoolPair<T> clone() {
      return new PointerBoolPair<>(this);
    }

    @Override
    public boolean $noteq(PointerBoolPair<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(PointerBoolPair<T> other) {
      return this.ptr == other.ptr && this.boolVal == other.boolVal;
    }

    @Override
    public void swap(NativeSwappable RHS) {
      exchange((PointerBoolPair<T>) RHS);
    }
  }
  // llvm::PointerIntPair<T , 1, V> where V is enum
  public static class PointerEnumPair<T, E extends Enum> implements Native.NativePOD<PointerEnumPair<T, E>> {
    private T ptr;
    private E enumVal;

    
    public PointerEnumPair() {
      this((T) null, (E) null);
    }

    public PointerEnumPair(PointerEnumPair<T, E> other) {
      this(other.ptr, other.enumVal);
    }
    
    public PointerEnumPair(T ptr, E e) {
      this.ptr = ptr;
      this.enumVal = e;
    }
    
    public PointerEnumPair(JD$Move _dparam, PointerEnumPair<T, E> other) {
      exchange(other);
    }
        
    @Override
    public PointerEnumPair<T, E> $assign(PointerEnumPair<T, E> other) {
      this.ptr = other.ptr;
      this.enumVal = other.enumVal;
      return this;
    }
    
    public PointerEnumPair<T, E> $assignMove(PointerEnumPair<T, E> other) {
      exchange(other);
      return this;
    }
    
    public T getPointer() {
      return this.ptr;
    }

    public E getInt() {
      return this.enumVal;
    }

    @Override
    public String toString() {
      return "PointerEnumPair{" + "ptr=" + NativeTrace.getIdentityStr(ptr) + ", val=" + enumVal + '}';
    }        
    
    private void exchange(PointerEnumPair<T, E> other) {
      T tmpPtr = this.ptr;
      E tmpEnumVal = this.enumVal;
      this.ptr = other.ptr;
      this.enumVal = other.enumVal;
      other.ptr = tmpPtr;
      other.enumVal = tmpEnumVal;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerEnumPair<T, E> clone() {
      return new PointerEnumPair<>(this);
    }

    @Override
    public boolean $noteq(PointerEnumPair<T, E> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(PointerEnumPair<T, E> other) {
      return this.ptr == other.ptr && this.enumVal == other.enumVal;
    }

    public void setPointer(T D) {
      this.ptr = D;
    }

    public void setInt(E V) {
      this.enumVal = V;
    }
  }    
  
  // llvm::PointerIntPair<T , 2, V> where V is enum
  public static class PointerEnum2Pair<T, E extends Enum> implements Native.NativePOD<PointerEnum2Pair<T, E>> {
    private T ptr;
    private E enumVal;

    
    public PointerEnum2Pair() {
      this((T) null, (E) null);
    }

    public PointerEnum2Pair(PointerEnum2Pair<T, E> other) {
      this(other.ptr, other.enumVal);
    }
    
    public PointerEnum2Pair(T ptr, E e) {
      this.ptr = ptr;
      this.enumVal = e;
    }
    
    public PointerEnum2Pair(JD$Move _dparam, PointerEnum2Pair<T, E> other) {
      exchange(other);
    }
        
    @Override
    public PointerEnum2Pair<T, E> $assign(PointerEnum2Pair<T, E> other) {
      this.ptr = other.ptr;
      this.enumVal = other.enumVal;
      return this;
    }
    
    public PointerEnum2Pair<T, E> $assignMove(PointerEnum2Pair<T, E> other) {
      exchange(other);
      return this;
    }
    
    public T getPointer() {
      return this.ptr;
    }

    public E getInt() {
      return this.enumVal;
    }

    @Override
    public String toString() {
      return "PointerEnum2Pair{" + "ptr=" + NativeTrace.getIdentityStr(ptr) + ", val=" + enumVal + '}';
    }        
    
    private void exchange(PointerEnum2Pair<T, E> other) {
      T tmpPtr = this.ptr;
      E tmpEnumVal = this.enumVal;
      this.ptr = other.ptr;
      this.enumVal = other.enumVal;
      other.ptr = tmpPtr;
      other.enumVal = tmpEnumVal;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public PointerEnum2Pair<T, E> clone() {
      return new PointerEnum2Pair<>(this);
    }

    @Override
    public boolean $noteq(PointerEnum2Pair<T, E> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(PointerEnum2Pair<T, E> other) {
      return this.ptr == other.ptr && this.enumVal == other.enumVal;
    }

    public void setPointerAndInt(T Width, E Kind) {
      this.ptr = Width;
      this.enumVal = Kind;
    }

    public void setPointer(T Width) {
      this.ptr = Width;
    }

    public void setInt(E Val) {
      this.enumVal = Val;
    }

    public Object/*P*/ getOpaqueValue() {
      // we use PointerBoolPair as state
      return new PointerEnum2Pair(this);
    }
    
    public final void ProfilePointerIntPair(final FoldingSetNodeID /*&*/ ID) {
      ID.AddPointer(this.ptr);
      ID.AddInteger_int(this.enumVal.hashCode());
    }        
  }    
  
  public static <T> boolean $noteq_reverse_iterator$C(abstract_iterator __lhs, abstract_iterator __rhs) {
    return $noteq_reverse_iterator(__lhs, __rhs);
  }
  public static <T> boolean $noteq_reverse_iterator(abstract_iterator __lhs, abstract_iterator __rhs) {
    return !$eq_reverse_iterator(__lhs, __rhs);
  }

  public static <T> boolean $eq_reverse_iterator$C(abstract_iterator __lhs, abstract_iterator __rhs) {
    return $eq_reverse_iterator(__lhs, __rhs);
  }
  public static <T> boolean $eq_reverse_iterator(abstract_iterator __lhs, abstract_iterator __rhs) {
    return __lhs.$eq(__rhs);
  }
  
  // Optional<unsigned> (in java Optional</*uint*/int>)
  public static final class OptionalUInt implements Destructors.ClassWithDestructor, Native.Native$Bool  {
    private /*uint*/int value;
    private boolean hasVal;
    public OptionalUInt() {
      this.hasVal = false;
      this.value = 0;
    }
    
    public OptionalUInt(OptionalUInt other) {
      this.hasVal = other.hasVal;
      this.value = other.value;
    }
    
    public OptionalUInt(JD$Move _diff, OptionalUInt other) {
      this.hasVal = other.hasVal;
      this.value = other.value;
    }

    public OptionalUInt(JD$T$C$R _dparm, /*uint*/int value) {
      this.value = value;
      this.hasVal = true;
    }
    
    public OptionalUInt(JD$T$RR _dparm, /*uint*/int value) {
      this.value = value;
      this.hasVal = true;
    }
    
    public OptionalUInt(/*uint*/int value) {
      this.value = value;
      this.hasVal = true;
    }

    private static final OptionalUInt NONE = new OptionalUInt(NoneType.None);
    public static OptionalUInt None() {
      return NONE;
    }
    public OptionalUInt(NoneType noneType) {
      hasVal = false;
      value = 0;
    }    

    public OptionalUInt(JD$T$C$R INSTANCE, uint$ptr value) {
      this.value = $Deref(value);
      this.hasVal = true;
    }
    
    public /*uint*/int $star() {
      return value;
    }
        
    public /*uint*/int getValue() {
      return value;
    }

    public int getValue$Const() {
      return value;
    }
    
    public /*uint*/int getValueOr(/*uint*/int value) {
      return hasValue() ? getValue() : value;
    }
    
    public /*uint*/int getValueOr_T$RR(/*uint*/int value) {
      return hasValue() ? getValue() : value;
    }
    
    public boolean hasValue() {
      return hasVal;
    }
    
    public boolean $bool() {
      return hasVal;
    }
    
    // FIXME: these assignments (& the equivalent const T&/const Optional& ctors)
    // could be made more efficient by passing by value, possibly unifying them
    // with the rvalue versions above - but this could place a different set of
    // requirements (notably: the existence of a default ctor) when implemented
    // in that way. Careful SFINAE to avoid such pitfalls would be required.
    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 90,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 137,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKT_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKT_")
    //</editor-fold>
    public OptionalUInt /*&*/ $assign(/*const*//*uint*/int /*&*/ y) {
      this.value = y;
      hasVal = true;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 100,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 147,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalUInt /*&*/ $assign(final /*const*/OptionalUInt /*&*/ O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
      }
      return /*Deref*/this;
    }
    
    public OptionalUInt $assign_T$C$R(int second) {
      return $assign(second);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 63,
     FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEONS_8OptionalIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEONS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalUInt /*&*/ $assignMove(final OptionalUInt /*&&*/O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
        O.hasVal = false;
        O.value = 0;
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::reset">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 108,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 155,
     FQN = "llvm::Optional::reset", NM = "_ZN4llvm8Optional5resetEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8Optional5resetEv")
    //</editor-fold>
    public void reset() {
      if (hasVal) {
  //      (/*Deref*//*Deref*/this).~T();
        value = 0;
        hasVal = false;
      }
    }
    
    @Override
    public void $destroy() {
      reset();
    }
    
    @Override
    public String toString() {
      if (!hasVal) {
        return "NO_VALUE";
      } else {
        return "Value=[" + value + "]";
      }
    }         

    public void $assign_T$RR(int $ullong2uint) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  // Optional<int> (in java Optional<int>)
  public static final class OptionalInt implements Destructors.ClassWithDestructor, Native.Native$Bool  {
    private int value;
    private boolean hasVal;
    public OptionalInt() {
      this.hasVal = false;
      this.value = 0;
    }
    
    public OptionalInt(OptionalInt other) {
      this.hasVal = other.hasVal;
      this.value = other.value;
    }

    public OptionalInt(int value) {
      this.value = value;
      this.hasVal = true;
    }

    public OptionalInt(NoneType noneType) {
      hasVal = false;
      value = 0;
    }    

    public OptionalInt(JD$T$RR INSTANCE, int i) {
      this(i);
    }
    
    public int $star() {
      return value;
    }
        
    public int getValue() {
      return value;
    }
    
    public int getValueOr(int value) {
      return hasValue() ? getValue() : value;
    }
    
    public boolean hasValue() {
      return hasVal;
    }
    
    public boolean $bool() {
      return hasVal;
    }
    
     // FIXME: these assignments (& the equivalent const T&/const Optional& ctors)
    // could be made more efficient by passing by value, possibly unifying them
    // with the rvalue versions above - but this could place a different set of
    // requirements (notably: the existence of a default ctor) when implemented
    // in that way. Careful SFINAE to avoid such pitfalls would be required.
    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 90,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 137,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKT_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKT_")
    //</editor-fold>
    public OptionalInt /*&*/ $assign(/*const*/int /*&*/ y) {
      this.value = y;
      hasVal = true;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 100,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 147,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalInt /*&*/ $assign(final /*const*/OptionalInt /*&*/ O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 63,
     FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEONS_8OptionalIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEONS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalInt /*&*/ $assignMove(final OptionalInt /*&&*/O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
        O.hasVal = false;
        O.value = 0;
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::reset">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 108,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 155,
     FQN = "llvm::Optional::reset", NM = "_ZN4llvm8Optional5resetEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8Optional5resetEv")
    //</editor-fold>
    public void reset() {
      if (hasVal) {
  //      (/*Deref*//*Deref*/this).~T();
        value = 0;
        hasVal = false;
      }
    }
    
    @Override
    public void $destroy() {
      reset();
    }
    
    @Override
    public String toString() {
      if (!hasVal) {
        return "NO_VALUE";
      } else {
        return "Value=[" + value + "]";
      }
    }         
  }
  
  // Optional<uint64_t> (in java Optional<long/*uint64_t*/>)
  public static final class OptionalULong implements Destructors.ClassWithDestructor, Native.Native$Bool  {
    private long/*uint64_t*/ value;
    private boolean hasVal;
    public OptionalULong() {
      this.hasVal = false;
      this.value = 0;
    }
    
    public OptionalULong(OptionalULong other) {
      this.hasVal = other.hasVal;
      this.value = other.value;
    }
    
    public OptionalULong(JD$Move _diff, OptionalULong other) {
      this.hasVal = other.hasVal;
      this.value = other.value;
    }

    public OptionalULong(JD$T$C$R _dparm, long/*uint64_t*/ value) {
      this.value = value;
      this.hasVal = true;
    }
    
    public OptionalULong(JD$T$RR _dparm, long/*uint64_t*/ value) {
      this.value = value;
      this.hasVal = true;
    }
    
    public OptionalULong(long/*uint64_t*/ value) {
      this.value = value;
      this.hasVal = true;
    }

    private static final OptionalULong NONE = new OptionalULong(NoneType.None);
    public static OptionalULong None() {
      return NONE;
    }
    public OptionalULong(NoneType noneType) {
      hasVal = false;
      value = 0;
    }    
    
    public long/*uint64_t*/ $star() {
      return value;
    }

    public long/*uint64_t*/ $star$Const() {
      return value;
    }

    public long/*uint64_t*/ getValue() {
      return value;
    }
    
    public long/*uint64_t*/ getValueOr(long/*uint64_t*/ value) {
      return hasValue() ? getValue() : value;
    }
    
    public long/*uint64_t*/ getValueOr_T$RR(long/*uint64_t*/ value) {
      return hasValue() ? getValue() : value;
    }
    
    public boolean hasValue() {
      return hasVal;
    }
    
    public boolean $bool() {
      return hasVal;
    }
    
    // FIXME: these assignments (& the equivalent const T&/const Optional& ctors)
    // could be made more efficient by passing by value, possibly unifying them
    // with the rvalue versions above - but this could place a different set of
    // requirements (notably: the existence of a default ctor) when implemented
    // in that way. Careful SFINAE to avoid such pitfalls would be required.
    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 90,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 137,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKT_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKT_")
    //</editor-fold>
    public OptionalULong /*&*/ $assign(/*const*/long/*uint64_t*/ /*&*/ y) {
      this.value = y;
      hasVal = true;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 100,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 147,
     FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalULong /*&*/ $assign(final /*const*/OptionalULong /*&*/ O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
      }
      return /*Deref*/this;
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 54,
     FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEOT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEOT_")
    //</editor-fold>
    public OptionalULong /*&*/ $assign_T$RR(final long /*&&*/y) {
      if (hasVal) {
        /*Deref*/this.value = std.move(y);
      } else {
        ///*FIXME: NEW_EXPR [NoNewFun]*/storage.buffer = /*new (storage.buffer)*/ new T(( std.move(y) ));
        this.value = std.move(y);
        hasVal = true;
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 63,
     FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEONS_8OptionalIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEONS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalULong /*&*/ $assignMove(final OptionalULong /*&&*/O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
        O.hasVal = false;
        O.value = 0;
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::reset">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 108,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 155,
     FQN = "llvm::Optional::reset", NM = "_ZN4llvm8Optional5resetEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8Optional5resetEv")
    //</editor-fold>
    public void reset() {
      if (hasVal) {
  //      (/*Deref*//*Deref*/this).~T();
        value = 0;
        hasVal = false;
      }
    }
    
    @Override
    public void $destroy() {
      reset();
    }
    
    @Override
    public String toString() {
      if (!hasVal) {
        return "NO_VALUE";
      } else {
        return "Value=[" + value + "]";
      }
    }     
  }
    
  // Optional<bool>
  public static final class OptionalBool implements Destructors.ClassWithDestructor, Native.Native$Bool  {
    private boolean value;
    private boolean hasVal;
    
    public OptionalBool() {
      hasVal = false;
      value = false;
    }

    public OptionalBool(boolean value) {
      this.value = value;
      this.hasVal = true;
    }

    public OptionalBool(NoneType noneType) {
      hasVal = false;
      value = false;
    }    
    
    public OptionalBool(OptionalBool Other) {
      this.hasVal = Other.hasVal;
      this.value = Other.value;
    }

    public OptionalBool(JD$T$C$R INSTANCE, boolean Value) {
      this(Value);
    }
    
    public OptionalBool(JD$T$RR INSTANCE, boolean Value) {
      this(Value);
    }

    public OptionalBool(JD$Move INSTANCE, OptionalBool Other) {
      this.hasVal = Other.hasVal;
      this.value = Other.value;
    }
    
    public boolean $star() {
      return value;
    }
    
    public boolean getValue() {
      return value;
    }
    
    public boolean getValueOr(boolean value) {
      return hasValue() ? getValue() : value;
    }
    
    public boolean hasValue() {
      return hasVal;
    }
    
    public boolean $bool() {
      return hasVal;
    }
    
    public OptionalBool $assign_T$RR(boolean value) {
      return $assign(value);
    }
    
    public OptionalBool $assign(OptionalBool value) {
      if (!value.$bool()) {
        reset();
      } else {
        $assign(value.$star());
      }
      return this;
    }
    
    public void reset() {
      if (hasVal) {
        Native.destroy(this.value);
        hasVal = false;
      }
    }
  
    public OptionalBool $assign(boolean value) {
      hasVal = true;
      this.value = value;
      return this;
    }

    public OptionalBool $assign_T$C$R(boolean prunable) {
      hasVal = true;
      this.value = value;
      return this;
    }
  
    //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 63,
     FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEONS_8OptionalIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEONS_8OptionalIT_EE")
    //</editor-fold>
    public OptionalBool /*&*/ $assignMove(final OptionalBool /*&&*/O) {
      if (!O.$bool()) {
        reset();
      } else {
        this.value = O.value;
        this.hasVal = O.hasVal;
        O.hasVal = false;
        O.value = false;
      }
      return /*Deref*/this;
    }
        
    @Override
    public void $destroy() {
      reset();
    }    

    public boolean getValue$Const() {
      return value;
    }
    
    @Override
    public String toString() {
      if (!hasVal) {
        return "NO_VALUE";
      } else {
        return "Value=[" + value + "]";
      }
    }     
  }

}
