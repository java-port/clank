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
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief A Use represents the edge between a Value definition and its users.
///
/// This is notionally a two-dimensional linked list. It supports traversing
/// all of the uses for a particular value definition. It also supports jumping
/// directly to the used value when we arrive from the User's operands, and
/// jumping directly to the User when we arrive from the Value's uses.
///
/// The pointer to the used Value is explicit, and the pointer to the User is
/// implicit. The implicit pointer is found via a waymarking algorithm
/// described in the programmer's manual:
///
///   http://www.llvm.org/docs/ProgrammersManual.html#the-waymarking-algorithm
///
/// This is essentially the single most memory intensive object in LLVM because
/// of the number of uses in the system. At the same time, the constant time
/// operations it allows are essential to many optimizations having reasonable
/// time complexity.
//<editor-fold defaultstate="collapsed" desc="llvm::Use">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 66,
 FQN="llvm::Use", NM="_ZN4llvm3UseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseE")
//</editor-fold>
public class Use implements LLVMOpaqueUse, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Provide a fast substitute to std::swap<Use>
  /// that also works with less standard-compliant compilers
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 17,
   FQN="llvm::Use::swap", NM="_ZN4llvm3Use4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use4swapERS0_")
  //</editor-fold>
  public void swap(final Use /*&*/ RHS) {
    if (Val == RHS.Val) {
      return;
    }
    if ((Val != null)) {
      removeFromList();
    }

    Value /*P*/ OldVal = Val;
    if ((RHS.Val != null)) {
      RHS.removeFromList();
      Val = RHS.Val;
      Val.addUse(/*Deref*/this);
    } else {
      Val = null;
    }
    if ((OldVal != null)) {
      RHS.Val = OldVal;
      RHS.Val.addUse(RHS);
    } else {
      RHS.Val = null;
    }
  }


  // A type for the word following an array of hung-off Uses in memory, which is
  // a pointer back to their User with the bottom bit set.
  // JAVA: typedef PointerIntPair<User *, 1, unsigned int> UserRef
//  public final class UserRef extends PointerUIntPair<User /*P*/ >{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::Use">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 77,
   FQN="llvm::Use::Use", NM="_ZN4llvm3UseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Use(final /*const*/ Use /*&*/ U) { throw new UnsupportedOperationException("Deleted");}


  /// Destructor - Only for zap()
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::~Use">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 80,
   FQN="llvm::Use::~Use", NM="_ZN4llvm3UseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    if ((Val != null)) {
      removeFromList();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Use::PrevPtrTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 85,
   FQN="llvm::Use::PrevPtrTag", NM="_ZN4llvm3Use10PrevPtrTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use10PrevPtrTagE")
  //</editor-fold>
  private enum PrevPtrTag implements Native.NativeUIntEnum {
    zeroDigitTag(0),
    oneDigitTag(zeroDigitTag.getValue() + 1),
    stopTag(oneDigitTag.getValue() + 1),
    fullStopTag(stopTag.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PrevPtrTag valueOf(int val) {
      PrevPtrTag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PrevPtrTag[] VALUES;
      private static final PrevPtrTag[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PrevPtrTag kind : PrevPtrTag.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PrevPtrTag[min < 0 ? (1-min) : 0];
        VALUES = new PrevPtrTag[max >= 0 ? (1+max) : 0];
        for (PrevPtrTag kind : PrevPtrTag.values()) {
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
    private PrevPtrTag(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  /// Constructor
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::Use">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 88,
   FQN="llvm::Use::Use", NM="_ZN4llvm3UseC1ENS0_10PrevPtrTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseC1ENS0_10PrevPtrTagE")
  //</editor-fold>
  private Use(PrevPtrTag tag) {
    // : Val(null), Prev()
    //START JInit
    this.Val = null;
    this.Prev = new PointerEnum2Pair<type$ref<Use /*P*/>/*P*/ , PrevPtrTag>();
    //END JInit
    Prev.setInt(tag);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::operator Value * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 91,
   FQN="llvm::Use::operator Value * ", NM="_ZNK4llvm3UsecvPNS_5ValueEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3UsecvPNS_5ValueEEv")
  //</editor-fold>
  public Value /*P*/ $Value$P() /*const*/ {
    return Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 92,
   FQN="llvm::Use::get", NM="_ZNK4llvm3Use3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3Use3getEv")
  //</editor-fold>
  public Value /*P*/ get() /*const*/ {
    return Val;
  }


  /// \brief Returns the User that contains this Use.
  ///
  /// For an instruction operand, for example, this will return the
  /// instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::getUser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 41,
   FQN="llvm::Use::getUser", NM="_ZNK4llvm3Use7getUserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3Use7getUserEv")
  //</editor-fold>
  public User /*P*/ getUser() /*const*/ {
    /*const*/type$ptr<Use /*P*/> End = $tryClone(getImpliedUser());
    Object $star = ((type$ptr)End).$star();
    if ($star instanceof PointerUIntPair) {
      /*const*/PointerUIntPair<User /*P*/ > /*P*/ ref = ((/*const*/PointerUIntPair<User /*P*/ > /*P*/)reinterpret_cast(/*const*/PointerUIntPair.class, $star));
      return (ref.getInt() != 0) ? ref.getPointer() : reinterpret_cast(User /*P*/ .class, $star/*((const_cast Use P> )(End))*/);
    } else {
      return (User) $star;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Use::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 613,
   FQN="llvm::Use::set", NM="_ZN4llvm3Use3setEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use3setEPNS_5ValueE")
  //</editor-fold>
  public void set(Value /*P*/ V) {
    if ((Val != null)) {
      removeFromList();
    }
    Val = V;
    if ((V != null)) {
      V.addUse(/*Deref*/this);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Use::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 619,
   FQN="llvm::Use::operator=", NM="_ZN4llvm3UseaSEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseaSEPNS_5ValueE")
  //</editor-fold>
  public Value /*P*/ $assign(Value /*P*/ RHS) {
    set(RHS);
    return RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 624,
   FQN="llvm::Use::operator=", NM="_ZN4llvm3UseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseaSERKS0_")
  //</editor-fold>
  public /*const*/ Use /*&*/ $assign(final /*const*/ Use /*&*/ RHS) {
    set(RHS.Val);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Use::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 105,
   FQN="llvm::Use::operator->", NM="_ZN4llvm3UseptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3UseptEv")
  //</editor-fold>
  public Value /*P*/ $arrow() {
    return Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 106,
   FQN="llvm::Use::operator->", NM="_ZNK4llvm3UseptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3UseptEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ $arrow$Const() /*const*/ {
    return Val;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Use::getNext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 108,
   FQN="llvm::Use::getNext", NM="_ZNK4llvm3Use7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3Use7getNextEv")
  //</editor-fold>
  public Use /*P*/ getNext() /*const*/ {
    return Next;
  }


  /// \brief Return the operand # of this use in its User.
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::getOperandNo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 48,
   FQN="llvm::Use::getOperandNo", NM="_ZNK4llvm3Use12getOperandNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3Use12getOperandNoEv")
  //</editor-fold>
  public /*uint*/int getOperandNo() /*const*/ {
    return $This$Ptr().$sub(getUser().op_begin());
  }


  /// \brief Initializes the waymarking tags on an array of Uses.
  ///
  /// This sets up the array of Uses such that getUser() can find the User from
  /// any of those Uses.

  // Sets up the waymarking algorithm's tags for a series of Uses. See the
  // algorithm details here:
  //
  //   http://www.llvm.org/docs/ProgrammersManual.html#the-waymarking-algorithm
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::initTags">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 57,
   FQN="llvm::Use::initTags", NM="_ZN4llvm3Use8initTagsEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use8initTagsEPS0_S1_")
  //</editor-fold>
  public static type$ptr<Use /*P*/> initTags(type$ptr<Use /*P*/>/*const*/ Start, type$ptr<Use /*P*/> Stop) {
    final int[] Done = new int[] {0};
    while (Done[0] < 20) {
      if ($eq_ptr(Start, Stop.$postDec())) {
        return Start;
      }
      final/*static*/ /*const*/ PrevPtrTag tags[/*20*/] = initTags$$.tags;
      // /*NEW_EXPR [System]*/Stop.$set(/*new (Stop)*/ $new_uint_voidPtr(Stop, (type$ptr<?> New$Mem)->{ return new Use(tags[Done[0]++]);}));
      $new(Stop, tags[Done[0]++]);
    }

    int Count = Done[0];
    while ($noteq_ptr(Start, Stop)) {
      Stop.$preDec();
      if (!(Count != 0)) {
        // /*NEW_EXPR [System]*/Stop.$set(/*new (Stop)*/ $new_uint_voidPtr(Stop, (type$ptr<?> New$Mem)->{ return new Use(PrevPtrTag.stopTag); }));
        $new(Stop, PrevPtrTag.stopTag);
        ++Done[0];
        Count = Done[0];
      } else {
        // /*NEW_EXPR [System]*/Stop.$set(/*new (Stop)*/ $new_uint_voidPtr(Stop, (type$ptr<?> New$Mem)->{ return new Use(PrevPtrTag.valueOf(Count$Final & 1)); }));
        $new(Stop, PrevPtrTag.valueOf(Count & 1));
        Count >>>= 1;
        ++Done[0];
      }
    }

    return Start;
  }
  private static final class initTags$$ {
    static final/*static*/ /*const*/ PrevPtrTag tags[/*20*/] = new /*const*/ PrevPtrTag [/*20*/] {
      PrevPtrTag.fullStopTag, PrevPtrTag.oneDigitTag, PrevPtrTag.stopTag, PrevPtrTag.oneDigitTag, PrevPtrTag.oneDigitTag,
      PrevPtrTag.stopTag, PrevPtrTag.zeroDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.stopTag,
      PrevPtrTag.zeroDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.zeroDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.stopTag,
      PrevPtrTag.oneDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.oneDigitTag, PrevPtrTag.stopTag};
  }


  /// \brief Destroys Use operands when the number of operands of
  /// a User changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::zap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 87,
   FQN="llvm::Use::zap", NM="_ZN4llvm3Use3zapEPS0_PKS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use3zapEPS0_PKS0_b")
  //</editor-fold>
  public static void zap(type$ptr<Use /*P*/> Start, /*const*/type$ptr<Use /*P*/> Stop) {
    zap(Start, Stop, false);
  }
  public static void zap(type$ptr<Use /*P*/> Start, /*const*/type$ptr<Use /*P*/> Stop, boolean del/*= false*/) {
    while ($noteq_ptr(Start, Stop)) {
      (Stop.$preDec()).$arrow().$destroy();
    }
    if (del) {
      // JAVA: we don't call $delete_voidPtr here because it will call $destroy for Use again
      ///*::*/$delete_voidPtr(Start);
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Use::getImpliedUser">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Use.cpp", line = 94,
   FQN="llvm::Use::getImpliedUser", NM="_ZNK4llvm3Use14getImpliedUserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZNK4llvm3Use14getImpliedUserEv")
  //</editor-fold>
  private /*const*/type$ptr<Use /*P*/> getImpliedUser() /*const*/ {
//    throw new UnsupportedOperationException("Empty body");
    /*const*/type$ptr<Use /*P*/> Current = $tryClone($This$Ptr());
    while (true) {
      /*uint*/int Tag = (Current.$postInc()).$arrow().Prev.getInt().getValue();
      switch (Use.PrevPtrTag.valueOf(Tag)) {
       case zeroDigitTag:
       case oneDigitTag:
        continue;
       case stopTag:
        {
          Current.$preInc();
          int Offset = 1;
          while (true) {
            /*uint*/int Tag$1 = Current./*->*/$star().Prev.getInt().getValue();
            switch (Use.PrevPtrTag.valueOf(Tag$1)) {
             case zeroDigitTag:
             case oneDigitTag:
              Current.$preInc();
              Offset = (Offset << 1) + Tag$1;
              continue;
             default:
              return Current.$add(Offset);
            }
          }
        }
       case fullStopTag:
        return Current;
      }
    }
  }


  private Value /*P*/ Val;
  private Use /*P*/ Next;
  private final PointerEnum2Pair<type$ref<Use /*P*/>/*P*/ , PrevPtrTag> Prev;

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::setPrev">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 130,
   FQN="llvm::Use::setPrev", NM="_ZN4llvm3Use7setPrevEPPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use7setPrevEPPS0_")
  //</editor-fold>
  private void setPrev(type$ref<Use /*P*/>/*P*/ NewPrev) {
    Prev.setPointer(NewPrev);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::addToList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 131,
   FQN="llvm::Use::addToList", NM="_ZN4llvm3Use9addToListEPPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use9addToListEPPS0_")
  //</editor-fold>
  /*friend*//*private*/ void addToList(final type$ref<Use /*P*/>/*P*/ List) {
    // JAVA: input List is address of UseList-field in Value class
    Next = List.$deref();
    if (Next != null) {
      Next./*->*/setPrev(Next$Ref);
    }
    setPrev(List);
    List.$set(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Use::removeFromList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 138,
   FQN="llvm::Use::removeFromList", NM="_ZN4llvm3Use14removeFromListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Use.cpp -nm=_ZN4llvm3Use14removeFromListEv")
  //</editor-fold>
  private void removeFromList() {
    final type$ref<Use /*P*/>/*P*/ StrippedPrev = Prev.getPointer();
    StrippedPrev.$set(Next);
    if (Next != null) {
      Next./*->*/setPrev(StrippedPrev);
    }
  }


  /*friend  class Value*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final ThreadLocalThisSupplier<Use> MemorySupplier = ThreadLocalThisSupplier.Create(Use::assertThisConsumedByCtor, Use.class.getName(), false);
  private final type$ptr<Use> $This = (type$ptr<Use>) $toConst(MemorySupplier.consumeAssignedMemory(this));

  /*package*/type$ptr<Use> $This$Ptr() {
    return $This;
  }

  private static Use $new(type$ptr<?> /*P*/ MemoryLocation, PrevPtrTag tag) {
    return $new(MemoryLocation, (type$ptr<?> New$Mem) -> new Use(tag));
  }

  private static Use $new(type$ptr<?> /*P*/ MemoryLocation, New$ConstructorCallback<Use> $Ctor) {
    MemoryLocation = $Clone(MemoryLocation);
    Use createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
    assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
    return createdInstance;
  }

  private static boolean assertThisConsumedByCtor(Use createdInstance, type$ptr Mem) {
    assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
    assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
    return true;
  }

  private Use() {
    Prev = new PointerEnum2Pair<>();
  }

  // JAVA: we need address of Next field for addToList/removeFromList
  private final type$ref<Use /*P*/> Next$Ref = new type$ptr$inout<Use/*P*/>(this) {
    @Override
    protected Use/*P*/ $star$impl() {
      return Next;
    }

    @Override
    protected Use/*P*/ $set$impl(Use u) {
      return Next = u;
    }
  };
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + ", Next=" + Next // NOI18N
              + ", Prev=" + Prev; // NOI18N
  }
}
