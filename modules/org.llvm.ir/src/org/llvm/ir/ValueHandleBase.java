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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.pass.*;


/// \brief This is the common base class of value handles.
///
/// ValueHandle's are smart pointers to Value's that have special behavior when
/// the value is deleted or ReplaceAllUsesWith'd.  See the specific handles
/// below for details.
//<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 41,
 FQN="llvm::ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseE")
//</editor-fold>
public class ValueHandleBase implements NativeCloneable<ValueHandleBase>, NativeMoveable<ValueHandleBase>, Destructors.ClassWithDestructor {
  /*friend  class Value*/
/*protected:*/
  /// \brief This indicates what sub class the handle actually is.
  ///
  /// This is to avoid having a vtable for the light-weight handle pointers. The
  /// fully general Callback version does have a vtable.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::HandleBaseKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 48,
   FQN="llvm::ValueHandleBase::HandleBaseKind", NM="_ZN4llvm15ValueHandleBase14HandleBaseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase14HandleBaseKindE")
  //</editor-fold>
  protected enum HandleBaseKind implements Native.NativeUIntEnum {
    Assert(0),
    Callback(Assert.getValue() + 1),
    Tracking(Callback.getValue() + 1),
    Weak(Tracking.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static HandleBaseKind valueOf(int val) {
      HandleBaseKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final HandleBaseKind[] VALUES;
      private static final HandleBaseKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (HandleBaseKind kind : HandleBaseKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new HandleBaseKind[min < 0 ? (1-min) : 0];
        VALUES = new HandleBaseKind[max >= 0 ? (1+max) : 0];
        for (HandleBaseKind kind : HandleBaseKind.values()) {
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
    private HandleBaseKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueHandleBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 55,
   FQN="llvm::ValueHandleBase::ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseC1ERKS0_")
  //</editor-fold>
  protected ValueHandleBase(final /*const*/ ValueHandleBase /*&*/ RHS) {
    // : ValueHandleBase(RHS.PrevPair.getInt(), RHS) 
    //START JInit
    this(RHS.PrevPair.getInt(), RHS);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueHandleBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 58,
   FQN="llvm::ValueHandleBase::ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindERKS0_")
  //</editor-fold>
  protected ValueHandleBase(HandleBaseKind Kind, final /*const*/ ValueHandleBase /*&*/ RHS) {
    // : PrevPair(null, Kind), Next(null), V(RHS.V) 
    //START JInit
    this.PrevPair = new PointerEnum2Pair<type$ref<ValueHandleBase /*P*/ /*P*/>, HandleBaseKind>((type$ref<ValueHandleBase /*P*/ /*P*/>)null, Kind);
    this.Next = null;
    this.V = RHS.V;
    //END JInit
    if (ValueHandleBase.isValid(V)) {
      AddToExistingUseList(RHS.getPrevPtr());
    }
  }

/*private:*/
  private final PointerEnum2Pair<type$ref<ValueHandleBase /*P*/ /*P*/>, HandleBaseKind> PrevPair;
  private ValueHandleBase /*P*/ Next;
  
  private Value /*P*/ V;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueHandleBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 71,
   FQN="llvm::ValueHandleBase::ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindE")
  //</editor-fold>
  public /*explicit*/ ValueHandleBase(HandleBaseKind Kind) {
    // : PrevPair(null, Kind), Next(null), V(null) 
    //START JInit
    this.PrevPair = new PointerEnum2Pair<type$ref<ValueHandleBase /*P*/ /*P*/>, HandleBaseKind>((type$ref<ValueHandleBase /*P*/ /*P*/>)null, Kind);
    this.Next = null;
    this.V = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueHandleBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 73,
   FQN="llvm::ValueHandleBase::ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseC1ENS0_14HandleBaseKindEPNS_5ValueE")
  //</editor-fold>
  public ValueHandleBase(HandleBaseKind Kind, Value /*P*/ V) {
    // : PrevPair(null, Kind), Next(null), V(V) 
    //START JInit
    this.PrevPair = new PointerEnum2Pair<type$ref<ValueHandleBase /*P*/ /*P*/>, HandleBaseKind>((type$ref<ValueHandleBase /*P*/ /*P*/>)null, Kind);
    this.Next = null;
    this.V = V;
    //END JInit
    if (ValueHandleBase.isValid(V)) {
      AddToUseList();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::~ValueHandleBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 79,
   FQN="llvm::ValueHandleBase::~ValueHandleBase", NM="_ZN4llvm15ValueHandleBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (ValueHandleBase.isValid(V)) {
      RemoveFromUseList();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 84,
   FQN="llvm::ValueHandleBase::operator=", NM="_ZN4llvm15ValueHandleBaseaSEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseaSEPNS_5ValueE")
  //</editor-fold>
  public Value /*P*/ $assign(Value /*P*/ RHS) {
    if (V == RHS) {
      return RHS;
    }
    if (ValueHandleBase.isValid(V)) {
      RemoveFromUseList();
    }
    V = RHS;
    if (ValueHandleBase.isValid(V)) {
      AddToUseList();
    }
    return RHS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 92,
   FQN="llvm::ValueHandleBase::operator=", NM="_ZN4llvm15ValueHandleBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBaseaSERKS0_")
  //</editor-fold>
  public Value /*P*/ $assign(final /*const*/ ValueHandleBase /*&*/ RHS) {
    if (V == RHS.V) {
      return RHS.V;
    }
    if (ValueHandleBase.isValid(V)) {
      RemoveFromUseList();
    }
    V = RHS.V;
    if (ValueHandleBase.isValid(V)) {
      AddToExistingUseList(RHS.getPrevPtr());
    }
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 100,
   FQN="llvm::ValueHandleBase::operator->", NM="_ZNK4llvm15ValueHandleBaseptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm15ValueHandleBaseptEv")
  //</editor-fold>
  public Value /*P*/ $arrow() /*const*/ {
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 101,
   FQN="llvm::ValueHandleBase::operator*", NM="_ZNK4llvm15ValueHandleBasedeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm15ValueHandleBasedeEv")
  //</editor-fold>
  public Value /*&*/ $star() /*const*/ {
    return $Deref(V);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::getValPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 104,
   FQN="llvm::ValueHandleBase::getValPtr", NM="_ZNK4llvm15ValueHandleBase9getValPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm15ValueHandleBase9getValPtrEv")
  //</editor-fold>
  protected Value /*P*/ getValPtr() /*const*/ {
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::isValid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 106,
   FQN="llvm::ValueHandleBase::isValid", NM="_ZN4llvm15ValueHandleBase7isValidEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase7isValidEPNS_5ValueE")
  //</editor-fold>
  protected static boolean isValid(Value /*P*/ V) {
    return (V != null)
       && V != DenseMapInfo$LikePtr.<Value /*P*/ >$Info().getEmptyKey()
       && V != DenseMapInfo$LikePtr.<Value /*P*/ >$Info().getTombstoneKey();
  }

/*public:*/
  // Callbacks made from Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueIsDeleted">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 763,
   FQN="llvm::ValueHandleBase::ValueIsDeleted", NM="_ZN4llvm15ValueHandleBase14ValueIsDeletedEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase14ValueIsDeletedEPNS_5ValueE")
  //</editor-fold>
  public static void ValueIsDeleted(Value /*P*/ V) {
    assert (V.HasValueHandle) : "Should only be called if ValueHandles present";
    
    // Get the linked list base, which is guaranteed to exist since the
    // HasValueHandle flag is set.
    LLVMContextImpl /*P*/ pImpl = V.getContext().pImpl;
    ValueHandleBase /*P*/ Entry = pImpl.ValueHandles.$at_T1$C$R(V);
    assert ((Entry != null)) : "Value bit set but no entries exist";
    ValueHandleBase Iterator = null;
    try {
      
      // We use a local ValueHandleBase as an iterator so that ValueHandles can add
      // and remove themselves from the list without breaking our iteration.  This
      // is not really an AssertingVH; we just have to give ValueHandleBase a kind.
      // Note that we deliberately do not the support the case when dropping a value
      // handle results in a new value handle being permanently added to the list
      // (as might occur in theory for CallbackVH's): the new value handle will not
      // be processed and the checking code will mete out righteous punishment if
      // the handle is still present once we have finished processing all the other
      // value handles (it is fine to momentarily add then remove a value handle).
      for (Iterator/*J*/= new ValueHandleBase(HandleBaseKind.Assert, $Deref(Entry)); (Entry != null); Entry = Iterator.Next) {
        Iterator.RemoveFromUseList();
        Iterator.AddToExistingUseListAfter(Entry);
        assert (Entry.Next == $AddrOf(Iterator)) : "Loop invariant broken.";
        switch (Entry.getKind()) {
         case Assert:
          break;
         case Tracking:
          // Mark that this value has been deleted by setting it to an invalid Value
          // pointer.
          Entry.$arrow().$assign((Value /*P*/ )DenseMapInfo$LikePtr.<Value /*P*/ >$Info().getTombstoneKey());
          break;
         case Weak:
          // Weak just goes to null, which will unlink it from the list.
          Entry.$arrow().$assign((Value /*P*/ )null);
          break;
         case Callback:
          // Forward to the subclass's implementation.
          ((/*static_cast*/CallbackVH /*P*/ )(Entry)).deleted();
          break;
        }
      }
    } finally {
      if (Iterator != null) { Iterator.$destroy(); }
    }
    
    // All callbacks, weak references, and assertingVHs should be dropped by now.
    if (V.HasValueHandle) {
      // Only in +Asserts mode...
//#ifndef NDEBUG      
     if (!NativeTrace.NDEBUG()) {
      IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/"While deleting: "), $Deref(V.getType())).$out(/*KEEP_STR*/" %").$out(V.getName()).$out(
          /*KEEP_STR*/$LF
      );
      if (pImpl.ValueHandles.$at_T1$C$R(V).getKind() == HandleBaseKind.Assert) {
        throw new llvm_unreachable("An asserting value handle still pointed to this value!");
      }
     }
//#endif      
      throw new llvm_unreachable("All references to V were not removed?");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::ValueIsRAUWd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 819,
   FQN="llvm::ValueHandleBase::ValueIsRAUWd", NM="_ZN4llvm15ValueHandleBase12ValueIsRAUWdEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase12ValueIsRAUWdEPNS_5ValueES2_")
  //</editor-fold>
  public static void ValueIsRAUWd(Value /*P*/ Old, Value /*P*/ New) {
    assert (Old.HasValueHandle) : "Should only be called if ValueHandles present";
    assert (Old != New) : "Changing value into itself!";
    assert (Old.getType() == New.getType()) : "replaceAllUses of value with new value of different type!";
    
    // Get the linked list base, which is guaranteed to exist since the
    // HasValueHandle flag is set.
    LLVMContextImpl /*P*/ pImpl = Old.getContext().pImpl;
    ValueHandleBase /*P*/ Entry = pImpl.ValueHandles.$at_T1$C$R(Old);
    assert ((Entry != null)) : "Value bit set but no entries exist";
    ValueHandleBase Iterator = null;
    try {
      
      // We use a local ValueHandleBase as an iterator so that
      // ValueHandles can add and remove themselves from the list without
      // breaking our iteration.  This is not really an AssertingVH; we
      // just have to give ValueHandleBase some kind.
      for (Iterator/*J*/= new ValueHandleBase(HandleBaseKind.Assert, $Deref(Entry)); (Entry != null); Entry = Iterator.Next) {
        Iterator.RemoveFromUseList();
        Iterator.AddToExistingUseListAfter(Entry);
        assert (Entry.Next == $AddrOf(Iterator)) : "Loop invariant broken.";
        switch (Entry.getKind()) {
         case Assert:
          // Asserting handle does not follow RAUW implicitly.
          break;
         case Tracking:
         case Weak:
          // Weak goes to the new value, which will unlink it from Old's list.
          Entry.$assign(New);
          break;
         case Callback:
          // Forward to the subclass's implementation.
          ((/*static_cast*/CallbackVH /*P*/ )(Entry)).allUsesReplacedWith(New);
          break;
        }
      }
    } finally {
      if (Iterator != null) { Iterator.$destroy(); }
    }
//#ifndef NDEBUG    
   if (!NativeTrace.NDEBUG()) {
    // If any new tracking or weak value handles were added while processing the
    // list, then complain about it now.
    if (Old.HasValueHandle) {
      for (Entry = pImpl.ValueHandles.$at_T1$C$R(Old); (Entry != null); Entry = Entry.Next)  {
        switch (Entry.getKind()) {
         case Tracking:
         case Weak:
          IrLlvmGlobals.$out_raw_ostream_Type(IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/"After RAUW from "), $Deref(Old.getType())).$out(/*KEEP_STR*/" %").$out(
                  Old.getName()
              ).$out(/*KEEP_STR*/" to "), $Deref(New.getType())).$out(/*KEEP_STR*/" %").$out(
              New.getName()
          ).$out(/*KEEP_STR*/$LF);
          throw new llvm_unreachable("A tracking or weak value handle still pointed to the old value!\n");
         default:
          break;
        }
      }
    }
   }
//#endif    
  }

/*private:*/
  // Internal implementation details.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::getPrevPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 119,
   FQN="llvm::ValueHandleBase::getPrevPtr", NM="_ZNK4llvm15ValueHandleBase10getPrevPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm15ValueHandleBase10getPrevPtrEv")
  //</editor-fold>
  private type$ref<ValueHandleBase /*P*/ /*P*/> getPrevPtr() /*const*/ {
    return PrevPair.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 120,
   FQN="llvm::ValueHandleBase::getKind", NM="_ZNK4llvm15ValueHandleBase7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm15ValueHandleBase7getKindEv")
  //</editor-fold>
  private HandleBaseKind getKind() /*const*/ {
    return PrevPair.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::setPrevPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 121,
   FQN="llvm::ValueHandleBase::setPrevPtr", NM="_ZN4llvm15ValueHandleBase10setPrevPtrEPPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase10setPrevPtrEPPS0_")
  //</editor-fold>
  private void setPrevPtr(final type$ref<ValueHandleBase /*P*/ /*P*/> Ptr) {
    PrevPair.setPointer(Ptr);
  }

  
  /// \brief Add this ValueHandle to the use list for V.
  ///
  /// List is the address of either the head of the list or a Next node within
  /// the existing use list.
  
  //===----------------------------------------------------------------------===//
  //                             ValueHandleBase Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::AddToExistingUseList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 671,
   FQN="llvm::ValueHandleBase::AddToExistingUseList", NM="_ZN4llvm15ValueHandleBase20AddToExistingUseListEPPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase20AddToExistingUseListEPPS0_")
  //</editor-fold>
  private void AddToExistingUseList(final type$ref<ValueHandleBase /*P*/ /*P*/> List) {
    assert ((List != null)) : "Handle list is null?";
    
    // Splice ourselves into the list.
    Next = List.$deref();
    List.$set(this);
    setPrevPtr(List);
    if ((Next != null)) {
//      Next.setPrevPtr($AddrOf(create_type$ptr2ConstT(Next)));
      Next.setPrevPtr(Next$Ref);
      assert (V == Next.V) : "Added to wrong list?";
    }
  }

  
  /// \brief Add this ValueHandle to the use list after Node.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::AddToExistingUseListAfter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 684,
   FQN="llvm::ValueHandleBase::AddToExistingUseListAfter", NM="_ZN4llvm15ValueHandleBase25AddToExistingUseListAfterEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase25AddToExistingUseListAfterEPS0_")
  //</editor-fold>
  private void AddToExistingUseListAfter(ValueHandleBase /*P*/ List) {
    assert ((List != null)) : "Must insert after existing node";
    
    Next = List.Next;
    setPrevPtr($AddrOf(/*create_type$ptr2ConstT*/(List.Next$Ref)));
    List.Next = this;
    if ((Next != null)) {
      Next.setPrevPtr($AddrOf(/*create_type$ptr2ConstT*/(List.Next$Ref)));
    }
  }

  
  /// \brief Add this ValueHandle to the use list for V.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::AddToUseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 694,
   FQN="llvm::ValueHandleBase::AddToUseList", NM="_ZN4llvm15ValueHandleBase12AddToUseListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase12AddToUseListEv")
  //</editor-fold>
  private void AddToUseList() {
    assert ((V != null)) : "Null pointer doesn't have a use list!";
    
    LLVMContextImpl /*P*/ pImpl = V.getContext().pImpl;
    if (V.HasValueHandle) {
      // If this value already has a ValueHandle, then it must be in the
      // ValueHandles map already.
      final type$ref<ValueHandleBase /*P*/ /*&*/> Entry = pImpl.ValueHandles.ref$at(V);
      assert ((Entry.$deref() != null)) : "Value doesn't have any handles?";
      AddToExistingUseList(Entry);
      return;
    }
    
    // Ok, it doesn't have any handles yet, so we must insert it into the
    // DenseMap.  However, doing this insertion could cause the DenseMap to
    // reallocate itself, which would invalidate all of the PrevP pointers that
    // point into the old table.  Handle this by checking for reallocation and
    // updating the stale pointers only if needed.
    final DenseMap<Value /*P*/ , ValueHandleBase /*P*/ > /*&*/ Handles = pImpl.ValueHandles;
    /*const*/Object/*void P*/ OldBucketPtr = Handles.getPointerIntoBucketsArray();
    
    final type$ref<ValueHandleBase /*P*/ /*&*/> Entry = Handles.ref$at(V);
    assert (!(Entry.$deref() != null)) : "Value really did already have handles?";
    AddToExistingUseList(Entry);
    V.HasValueHandle = true;
    
    // If reallocation didn't happen or if this was the first insertion, don't
    // walk the table.
    if (Handles.isPointerIntoBucketsArray(OldBucketPtr)
       || Handles.size() == 1) {
      return;
    }
    
    // Okay, reallocation did happen.  Fix the Prev Pointers.
    for (DenseMapIterator<Value /*P*/ , ValueHandleBase /*P*/ > I = Handles.begin(), 
        E = Handles.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      assert ((I.$arrow().second != null) && I.$arrow().first == I.$arrow().second.V) : "List invariant broken!";
      I.$arrow().second.setPrevPtr($AddrOf(/*create_type$ptr2ConstT*/(I.$arrow().second$ref())));
    }
  }

  /// \brief Remove this ValueHandle from its current use list.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueHandleBase::RemoveFromUseList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 737,
   FQN="llvm::ValueHandleBase::RemoveFromUseList", NM="_ZN4llvm15ValueHandleBase17RemoveFromUseListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm15ValueHandleBase17RemoveFromUseListEv")
  //</editor-fold>
  private void RemoveFromUseList() {
    assert ((V != null) && V.HasValueHandle) : "Pointer doesn't have a use list!";
    
    // Unlink this from its use list.
    final type$ref<ValueHandleBase /*P*/ /*P*/> PrevPtr = $noClone(getPrevPtr());
    assert (PrevPtr.$deref() == this) : "List invariant broken";
    
    PrevPtr.$set(Next);
    if ((Next != null)) {
      assert ($eq_ptr(Next.getPrevPtr(), $AddrOf(/*create_type$ptr2ConstT*/(Next$Ref)))) : "List invariant broken";
      Next.setPrevPtr(PrevPtr);
      return;
    }
    
    // If the Next pointer was null, then it is possible that this was the last
    // ValueHandle watching VP.  If so, delete its entry from the ValueHandles
    // map.
    LLVMContextImpl /*P*/ pImpl = V.getContext().pImpl;
    final DenseMap<Value /*P*/ , ValueHandleBase /*P*/ > /*&*/ Handles = pImpl.ValueHandles;
    if (Handles.isPointerIntoBucketsArray(PrevPtr)) {
      Handles.erase(V);
      V.HasValueHandle = false;
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ValueHandleBase clone() {
    throw new UnsupportedOperationException("why not overridden in derived " + this.getClass());
  }
  
  @Override public ValueHandleBase move() {
    throw new UnsupportedOperationException("why not overridden in derived " + this.getClass());
  }

  // JAVA: we need address of Next field for addToList/removeFromList
  private final type$ref<ValueHandleBase /*P*/> Next$Ref = new type$ptr$inout<ValueHandleBase /*P*/>(this) {
    @Override
    protected ValueHandleBase /*P*/ $star$impl() {
      return Next;
    }

    @Override
    protected ValueHandleBase /*P*/ $set$impl(ValueHandleBase /*P*/ u) {
      return Next = u;
    }
  };
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PrevPair=" + PrevPair // NOI18N
              + ", Next=" + Next // NOI18N
              + ", V=" + V; // NOI18N
  }
}
