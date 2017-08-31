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

import java.util.LinkedList;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clank.support.Native.$delete_voidPtr;
import org.llvm.ir.java.IUser;
import org.llvm.ir.java.OperandTraitsRegistry;

//<editor-fold defaultstate="collapsed" desc="llvm::User">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 39,
 FQN="llvm::User", NM="_ZN4llvm4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserE")
//</editor-fold>
public class User extends /*public*/ Value implements IUser, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::User::User">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 40,
   FQN="llvm::User::User", NM="_ZN4llvm4UserC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserC1ERKS0_")
  //</editor-fold>
  protected/*private*/ User(final /*const*/ User /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  /*friend template <unsigned int> struct HungoffOperandTraits*/

  //===----------------------------------------------------------------------===//
  //                                 User Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::User::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 22,
   FQN="llvm::User::anchor", NM="_ZN4llvm4User6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }



  //===----------------------------------------------------------------------===//
  //                         User operator new Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::User::allocateFixedOperandUser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 117,
   FQN="llvm::User::allocateFixedOperandUser", NM="_ZN4llvm4User24allocateFixedOperandUserEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User24allocateFixedOperandUserEjjj")
  //</editor-fold>
  private static <T extends User> T  /*void P*/ allocateFixedOperandUser(/*size_tint UnusedSizeOf, *//*uint*/int Us,
                          /*uint*/int DescBytes, New$ConstructorCallback<T> $Ctor)/* __attribute__((always_inline))*/ {
    assert ($less_uint(Us, (1/*U*/ << NumUserOperandsBits))) : "Too many operands";

    //static_assert($rem_uint($sizeof_DescriptorInfo(), $sizeof_ptr(/*Object */)) == 0, $("Required below"));
    boolean hasDescription = (DescBytes > 0);
    int $ExtraJavaObjectsToAlloc = Us + (hasDescription ? 1 : 0);
    Object[] data = new Object[1 + $ExtraJavaObjectsToAlloc];

    type$ptr/*uint8_t*//*P*/ Storage = create_type$ptr(data);
    type$ptr<Use /*P*/> Start = (type$ptr<Use /*P*/>) Storage.$add(hasDescription ? 1 : 0);
    type$ptr<Use /*P*/> End = $tryClone(Start.$add(Us));
    type$ptr<?> /*P*/ Result = End.clone();

    UserCreationData Obj = new UserCreationData();
    Obj.NumUserOperands = Us;
    Obj.HasHungOffUses = false;
    Obj.HasDescriptor = DescBytes != 0;
    Obj.$this = Result;
    // we support stack of assigned memories for creation of inner objects
    final LinkedList<UserCreationData> stack = creationData.get();
    assert stack != null : "creationData list should be prepared!";
    stack.addLast(Obj);

    Use.initTags(Start, End); // we do not clone Start and End since we'll never use them below
    if (DescBytes != 0) {
      DescriptorInfo /*P*/ DescInfo = new DescriptorInfo(DescBytes);
      Storage.$assign(DescInfo);
    }

    T out = callConstructorImpl(Result, $Ctor);
    assert out == Obj.$this.$star() : "created object " + NativeTrace.getIdentityStr(out) + " must be the same as assigned into $this " + NativeTrace.getIdentityStr(Obj.$this.$star());
    return out;
  }


///*protected:*/
//  /// Allocate a User with an operand pointer co-allocated.
//  ///
//  /// This is used for subclasses which need to allocate a variable number
//  /// of operands, ie, 'hung off uses'.
//  /// Allocate a User with an operand pointer co-allocated.
//  ///
//  /// This is used for subclasses which need to allocate a variable number
//  /// of operands, ie, 'hung off uses'.
//  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 154,
//   FQN="llvm::User::operator new", NM="_ZN4llvm4UsernwEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UsernwEj")
//  //</editor-fold>
//  protected static Object/*void P*/ $new(/*size_t*/int Size) {
//    // Allocate space for a single Use*
//    Object/*void P*/ Storage = /*::*/$new_uint(Size + $sizeof_ptr(/*type$ptr<Use > */));
//    type$ptr<Use /*P*/>/*P*/ HungOffOperandList = $tryClone(((/*static_cast*/type$ptr<Use /*P*/>/*P*/ )(Storage)));
//    User /*P*/ Obj = reinterpret_cast(User /*P*/ .class, HungOffOperandList.$add(1));
//    Obj.NumUserOperands = 0;
//    Obj.HasHungOffUses = true;
//    Obj.HasDescriptor = false;
//    HungOffOperandList.$set(null);
//    return Obj;
//  }



  /// Allocate a User with the operands co-allocated.
  ///
  /// This is used for subclasses which have a fixed number of operands.

  /// Allocate a User with the operands co-allocated.
  ///
  /// This is used for subclasses which have a fixed number of operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 146,
//   FQN="llvm::User::operator new", NM="_ZN4llvm4UsernwEjj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UsernwEjj")
//  //</editor-fold>
//  protected static Object/*void P*/ $new(/*size_t*/int Size, /*uint*/int Us) {
//    return allocateFixedOperandUser(Size, Us, 0);
//  }



  /// Allocate a User with the operands co-allocated.  If DescBytes is non-zero
  /// then allocate an additional DescBytes bytes before the operands. These
  /// bytes can be accessed by calling getDescriptor.
  ///
  /// DescBytes needs to be divisible by sizeof(void *).  The allocated
  /// descriptor, if any, is aligned to sizeof(void *) bytes.
  ///
  /// This is used for subclasses which have a fixed number of operands.

  /// Allocate a User with the operands co-allocated.  If DescBytes is non-zero
  /// then allocate an additional DescBytes bytes before the operands. These
  /// bytes can be accessed by calling getDescriptor.
  ///
  /// DescBytes needs to be divisible by sizeof(void *).  The allocated
  /// descriptor, if any, is aligned to sizeof(void *) bytes.
  ///
  /// This is used for subclasses which have a fixed number of operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 150,
//   FQN="llvm::User::operator new", NM="_ZN4llvm4UsernwEjjj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UsernwEjjj")
//  //</editor-fold>
//  protected static Object/*void P*/ $new(/*size_t*/int Size, /*uint*/int Us, /*uint*/int DescBytes) {
//    return allocateFixedOperandUser(Size, Us, DescBytes);
//  }



  //<editor-fold defaultstate="collapsed" desc="llvm::User::User">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 70,
   FQN="llvm::User::User", NM="_ZN4llvm4UserC1EPNS_4TypeEjPNS_3UseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserC1EPNS_4TypeEjPNS_3UseEj")
  //</editor-fold>
  protected User(Type /*P*/ ty, /*uint*/int vty, type$ptr<Use /*P*/> $Prm2, /*uint*/int NumOps) {
    // : Value(ty, vty)
    //START JInit
    super(ty, vty);
    $init();
    //END JInit
    assert ($less_uint(NumOps, (1/*U*/ << NumUserOperandsBits))) : "Too many operands";
    NumUserOperands = NumOps;
    // If we have hung off uses, then the operand list should initially be
    // null.
    assert ((!HasHungOffUses || !Native.$bool(getOperandList()))) : "Error in initializing hung off uses for User";
  }


  /// \brief Allocate the array of Uses, followed by a pointer
  /// (with bottom bit set) to the User.
  /// \param IsPhi identifies callers which are phi nodes and which need
  /// N BasicBlock* allocated along with N

  /// \brief Allocate the array of Uses, followed by a pointer
  /// (with bottom bit set) to the User.
  /// \param IsPhi identifies callers which are phi nodes and which need
  /// N BasicBlock* allocated along with N

  //===----------------------------------------------------------------------===//
  //                         User allocHungoffUses Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::User::allocHungoffUses">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 43,
   FQN="llvm::User::allocHungoffUses", NM="_ZN4llvm4User16allocHungoffUsesEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User16allocHungoffUsesEjb")
  //</editor-fold>
  protected void allocHungoffUses(/*uint*/int N) {
    allocHungoffUses(N, false);
  }
  protected void allocHungoffUses(/*uint*/int N, boolean IsPhi/*= false*/) {
    assert (HasHungOffUses) : "alloc must have hung off uses";

    static_assert($greatereq_uint(AlignOf.<Use>Unnamed_enum.Alignment$Java, AlignOf.<PointerUIntPair<User/*P*/>>Unnamed_enum.Alignment$Java), $("Alignment is insufficient for 'hung-off-uses' pieces"));
    static_assert($greatereq_uint(AlignOf.<PointerUIntPair<User /*P*/ > >Unnamed_enum.Alignment$Java
      , AlignOf.<BasicBlock /*P*/ >Unnamed_enum.Alignment$Java), $("Alignment is insufficient for 'hung-off-uses' pieces"));

    // Allocate the array of Uses, followed by a pointer (with bottom bit set) to
    // the User.
    /*size_t*/int size = N * $sizeof_Use() + $sizeof_PointerUIntPair$User$P();
    if (IsPhi) {
      size += N * $sizeof_ptr(/*BasicBlock  */);
    }
    Use[] $data = new Use[size];
    type$ptr<Object/*Use*/ /*P*/> Begin = create_type$ptr($data); //$tryClone(((/*static_cast*/type$ptr<Use /*P*/> )(/*::*/$new_uint(size))));
    type$ptr<Object/*Use*/ /*P*/> End = $tryClone(Begin.$add(N));
    /*J:(void)*//*NEW_EXPR [System]*/End.$set((Object)/*new (End)*/ $new_uint_voidPtr(End, (type$ptr<?> New$Mem)->{
        return new PointerIntPair<User /*P*/ >(((/*const_cast*/User /*P*/ )(this)), 1);
     }));
    //setOperandList(Use.initTags(Begin, End);
    setOperandList(Use.initTags(create_type$ptr($data), create_type$ptr($data, size)));
  }



  /// \brief Grow the number of hung off uses.  Note that allocHungoffUses
  /// should be called if there are no uses.

  /// \brief Grow the number of hung off uses.  Note that allocHungoffUses
  /// should be called if there are no uses.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::growHungoffUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 63,
   FQN="llvm::User::growHungoffUses", NM="_ZN4llvm4User15growHungoffUsesEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User15growHungoffUsesEjb")
  //</editor-fold>
  protected void growHungoffUses(/*uint*/int NewNumUses) {
    growHungoffUses(NewNumUses, false);
  }
  protected void growHungoffUses(/*uint*/int NewNumUses, boolean IsPhi/*= false*/) {
    assert (HasHungOffUses) : "realloc must have hung off uses";

    /*uint*/int OldNumUses = getNumOperands();

    // We don't support shrinking the number of uses.  We wouldn't have enough
    // space to copy the old uses in to the new space.
    assert ($greater_uint(NewNumUses, OldNumUses)) : "realloc must grow num uses";

    type$ptr<Use /*P*/> OldOps = $tryClone(getOperandList());
    allocHungoffUses(NewNumUses, IsPhi);
    type$ptr<Use /*P*/> NewOps = $tryClone(getOperandList());

    // Now copy from the old operands list to the new one.
    std.copy(OldOps, OldOps.$add(OldNumUses), NewOps);

    // If this is a Phi, then we need to copy the BB pointers too.
    if (IsPhi) {
      char$ptr/*char P*/ OldPtr = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, OldOps.$add(OldNumUses)).$add($sizeof_PointerUIntPair$User$P()));
      char$ptr/*char P*/ NewPtr = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, NewOps.$add(NewNumUses)).$add($sizeof_PointerUIntPair$User$P()));
      std.copy(OldPtr, OldPtr.$add((OldNumUses * $sizeof_ptr(/*BasicBlock  */))), NewPtr);
  }
    Use.zap(OldOps, OldOps.$add(OldNumUses), true);
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::~User">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 91,
   FQN="llvm::User::~User", NM="_ZN4llvm4UserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  /// \brief Free memory allocated for User and Use objects.
  /// \brief Free memory allocated for User and Use objects.

  //===----------------------------------------------------------------------===//
  //                         User operator delete Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 170,
   FQN="llvm::User::operator delete", NM="_ZN4llvm4UserdlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UserdlEPv")
  //</editor-fold>
  public static void $delete(User/*void P*/ Usr) {
    // Hung off uses use a single Use* before the User, while other subclasses
    // use a Use[] allocated prior to the user.
    User /*P*/ Obj = ((/*static_cast*/User /*P*/ )(Usr));
    if (Obj.HasHungOffUses) {
      assert (!Obj.HasDescriptor) : "not supported!";

      type$ptr<Use /*P*/>/*P*/ HungOffOperandList = $tryClone(((/*static_cast*/type$ptr<Use /*P*/>/*P*/ )(Usr.$This)).$sub(1));
      // drop the hung off uses.
      Use.zap(HungOffOperandList, HungOffOperandList.$add(Obj.NumUserOperands),
          /* Delete */ true);
      // JAVA: we don't call $delete_voidPtr here because it will call $destroy for Use again
      ///*::*/$delete_voidPtr(HungOffOperandList);
    } else if (Obj.HasDescriptor) {
      type$ptr<Use /*P*/> UseBegin = $tryClone(((/*static_cast*/type$ptr<Use /*P*/> )(Usr.$This)).$sub(Obj.NumUserOperands));
      Use.zap(UseBegin, UseBegin.$add(Obj.NumUserOperands), /* Delete */ false);

      //DescriptorInfo /*P*/ DI = reinterpret_cast(DescriptorInfo /*P*/ .class, UseBegin) - 1;
      type$ptr<DescriptorInfo> /*P*/ DI = (type$ptr<DescriptorInfo>) ((type$ptr<?>)UseBegin.$sub(1));
      /*byte*/type$ptr<?>/*uint8_t*//*P*/ Storage = $tryClone(/*reinterpret_cast(byte/*uint8_t*//*P*/ DI.$sub(DI.$arrow().SizeInBytes));
      // JAVA: we don't call $delete_voidPtr here because it will call $destroy for Use again
      ///*::*/$delete_voidPtr(Storage);
    } else {
      type$ptr<Use /*P*/> Storage = $tryClone(((/*static_cast*/type$ptr<Use /*P*/> )(Usr.$This)).$sub(Obj.NumUserOperands));
      Use.zap(Storage, Storage.$add(Obj.NumUserOperands),
          /* Delete */ false);
      // JAVA: we don't call $delete_voidPtr here because it will call $destroy for Use again
      ///*::*/$delete_voidPtr(Storage);
    }
  }


  /// \brief Placement delete - required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 96,
   FQN="llvm::User::operator delete", NM="_ZN4llvm4UserdlEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserdlEPvj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1) {
    throw new llvm_unreachable("Constructor throws?");
  }

  /// \brief Placement delete - required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 100,
   FQN="llvm::User::operator delete", NM="_ZN4llvm4UserdlEPvjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4UserdlEPvjb")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1, boolean $Prm2) {
    throw new llvm_unreachable("Constructor throws?");
  }

/*protected:*/
  /*template <int Idx, typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::OpFrom">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 104,
   FQN="llvm::User::OpFrom", NM="Tpl__ZN4llvm4User6OpFromEPKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=Tpl__ZN4llvm4User6OpFromEPKT0_")
  //</editor-fold>
  protected </*int Idx,*/ /*typename*/ U extends User> Use /*&*/ OpFrom(int Idx, /*const*/ U /*P*/ that) {
    return Idx < 0 ? that.$OperandTraits().op_end$$(that).$at(Idx) : that.$OperandTraits().op_begin$$(that).$at(Idx);
  }
  protected </*int Idx,*/ /*typename*/ U extends User> type$ptr<Use> /*&*/ OpFrom$Addr(int Idx, /*const*/ U /*P*/ that) {
    return Idx < 0 ? that.$OperandTraits().op_end$$(that).$add(Idx) : that.$OperandTraits().op_begin$$(that).$add(Idx);
  }
  protected static </*int Idx,*/ /*typename*/ U extends IUser> type$ptr<Use> /*&*/ OpFrom$Addr(int Idx, /*const*/ IUser that, OperandTraits<U> $traits) {
    return Idx < 0 ? $traits.op_end$$(that).$add(Idx) : $traits.op_begin$$(that).$add(Idx);
  }
  protected static <U extends User> type$ptr<Use> /*&*/ OpFrom$Addr(int Idx, /*const*/ IUser that, Class<U> clazz) {
    OperandTraits<User> $traits = OperandTraitsRegistry.get(clazz);
    return Idx < 0 ? $traits.op_end$$(that).$add(Idx) : $traits.op_begin$$(that).$add(Idx);
  }

  /*template <int Idx> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 109,
   FQN="llvm::User::Op", NM="Tpl__ZN4llvm4User2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=Tpl__ZN4llvm4User2OpEv")
  //</editor-fold>
  protected /*<int Idx>*/ Use /*&*/ Op(int Idx) {
    return OpFrom(Idx, this);
  }
  protected type$ptr<Use> /*&*/ Op$Addr(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom$Addr(Idx_nocapture, this);
  }

  /*template <int Idx> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 112,
   FQN="llvm::User::Op", NM="Tpl__ZNK4llvm4User2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=Tpl__ZNK4llvm4User2OpEv")
  //</editor-fold>
  protected /*<int Idx>*/ /*const*/ Use /*&*/ Op$Const(int Idx) /*const*/ {
    return OpFrom(Idx, this);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::getHungOffOperands">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 116,
   FQN="llvm::User::getHungOffOperands", NM="_ZN4llvm4User18getHungOffOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User18getHungOffOperandsEv")
  //</editor-fold>
  /*IUser*/public/*private*/ type$ptr<Use /*P*/>/*&*/ getHungOffOperands() {
    //return (((type$ptr<Use /*P*/>/*P*/ )reinterpret_cast(type$ptr.class, this)).$sub(1)).$star();
    type$ptr<?> p = $This$Ptr().$sub(1);
    if (p.$star() == null) {
      type$ptr res = create_type$ptr();
      p.$assign(res);
      return res;
    } else {
      return (type$ptr<Use>) p.$star();
    }
    //return (type$ptr<Use /*P*/>/*P*/ )/*reinterpret_cast(type$ptr.class, this))*/$This$Ptr().$sub(1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::User::getIntrusiveOperands">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 118,
   FQN="llvm::User::getIntrusiveOperands", NM="_ZN4llvm4User20getIntrusiveOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User20getIntrusiveOperandsEv")
  //</editor-fold>
  /*IUser*/public/*private*/ type$ptr<Use /*P*/> getIntrusiveOperands() {
    return ((type$ptr<Use /*P*/> )reinterpret_cast(type$ptr.class, this.$This)).$sub(NumUserOperands);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::User::setOperandList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 122,
   FQN="llvm::User::setOperandList", NM="_ZN4llvm4User14setOperandListEPNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User14setOperandListEPNS_3UseE")
  //</editor-fold>
  private void setOperandList(type$ptr<Use /*P*/> NewList) {
    assert (HasHungOffUses) : "Setting operand list only required for hung off uses";
    getHungOffOperands().$assign(NewList);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::User::getOperandList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 128,
   FQN="llvm::User::getOperandList", NM="_ZN4llvm4User14getOperandListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User14getOperandListEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> getOperandList() {
    return HasHungOffUses ? getHungOffOperands() : getIntrusiveOperands();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::getOperandList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 131,
   FQN="llvm::User::getOperandList", NM="_ZNK4llvm4User14getOperandListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User14getOperandListEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> getOperandList$Const() /*const*/ {
    return ((/*const_cast*/User /*P*/ )(this)).getOperandList();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 134,
   FQN="llvm::User::getOperand", NM="_ZNK4llvm4User10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumUserOperands)) : "getOperand() out of range!";
    return getOperandList$Const().$at(i).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 138,
   FQN="llvm::User::setOperand", NM="_ZN4llvm4User10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i, Value /*P*/ Val) {
    assert ($less_uint(i, NumUserOperands)) : "setOperand() out of range!";
    assert ((!isa_Constant((/*const*/ Value /*P*/ )this) || isa_GlobalValue((/*const*/ Value /*P*/ )this))) : "Cannot mutate a constant with setOperand!";
    getOperandList().$at(i).$assign(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::getOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 145,
   FQN="llvm::User::getOperandUse", NM="_ZNK4llvm4User13getOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User13getOperandUseEj")
  //</editor-fold>
  public /*const*/ Use /*&*/ getOperandUse$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumUserOperands)) : "getOperandUse() out of range!";
    return getOperandList$Const().$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::getOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 149,
   FQN="llvm::User::getOperandUse", NM="_ZN4llvm4User13getOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User13getOperandUseEj")
  //</editor-fold>
  public Use /*&*/ getOperandUse(/*uint*/int i) {
    assert ($less_uint(i, NumUserOperands)) : "getOperandUse() out of range!";
    return getOperandList().$at(i);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::User::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 154,
   FQN="llvm::User::getNumOperands", NM="_ZNK4llvm4User14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return NumUserOperands;
  }


  /// Returns the descriptor co-allocated with this User instance.

  /// Returns the descriptor co-allocated with this User instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::getDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 97,
   FQN="llvm::User::getDescriptor", NM="_ZNK4llvm4User13getDescriptorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZNK4llvm4User13getDescriptorEv")
  //</editor-fold>
  public ArrayRefByte$C getDescriptor$Const() /*const*/ {
    MutableArrayRefUChar MutableARef = ((/*const_cast*/User /*P*/ )(this)).getDescriptor();
    return /*{ */new ArrayRefByte$C(MutableARef.begin(), MutableARef.end())/* }*/;
  }



  /// Returns the descriptor co-allocated with this User instance.

  /// Returns the descriptor co-allocated with this User instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::getDescriptor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 102,
   FQN="llvm::User::getDescriptor", NM="_ZN4llvm4User13getDescriptorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User13getDescriptorEv")
  //</editor-fold>
  public MutableArrayRefUChar getDescriptor() {
    assert (HasDescriptor) : "Don't call otherwise!";
    assert (!HasHungOffUses) : "Invariant!";

    type$ptr<DescriptorInfo> /*P*/ DI =  (type$ptr<DescriptorInfo>) reinterpret_cast(type$ptr.class, getIntrusiveOperands().$sub(1));
    assert (DI.$star() != null) : "Null descriptor!";
    assert (DI.$star().SizeInBytes != 0) : "Should not have had a descriptor otherwise!";

    return new MutableArrayRefUChar(DI.$star().data);
  }



  /// Set the number of operands on a GlobalVariable.
  ///
  /// GlobalVariable always allocates space for a single operands, but
  /// doesn't always use it.
  ///
  /// FIXME: As that the number of operands is used to find the start of
  /// the allocated memory in operator delete, we need to always think we have
  /// 1 operand before delete.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::setGlobalVariableNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 170,
   FQN="llvm::User::setGlobalVariableNumOperands", NM="_ZN4llvm4User28setGlobalVariableNumOperandsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User28setGlobalVariableNumOperandsEj")
  //</editor-fold>
  public void setGlobalVariableNumOperands(/*uint*/int NumOps) {
    assert ($lesseq_uint(NumOps, 1)) : "GlobalVariable can only have 0 or 1 operands";
    NumUserOperands = NumOps;
  }


  /// \brief Subclasses with hung off uses need to manage the operand count
  /// themselves.  In these instances, the operand count isn't used to find the
  /// OperandList, so there's no issue in having the operand count change.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::setNumHungOffUseOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 178,
   FQN="llvm::User::setNumHungOffUseOperands", NM="_ZN4llvm4User24setNumHungOffUseOperandsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User24setNumHungOffUseOperandsEj")
  //</editor-fold>
  public void setNumHungOffUseOperands(/*uint*/int NumOps) {
    assert (HasHungOffUses) : "Must have hung off uses to use this method";
    assert ($less_uint(NumOps, (1/*U*/ << NumUserOperandsBits))) : "Too many operands";
    NumUserOperands = NumOps;
  }


  // ---------------------------------------------------------------------------
  // Operand Iterator interface...
  //
  // JAVA: typedef Use *op_iterator
//  public final class op_iterator extends type$ptr<Use /*P*/> { };
  // JAVA: typedef const Use *const_op_iterator
//  public final class const_op_iterator extends /*const*/type$ptr<Use /*P*/> { };
  // JAVA: typedef iterator_range<op_iterator> op_range
//  public final class op_range extends iterator_range<Use>{ };
  // JAVA: typedef iterator_range<const_op_iterator> const_op_range
//  public final class const_op_range extends iterator_range</*const*/ Use>{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::User::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 192,
   FQN="llvm::User::op_begin", NM="_ZN4llvm4User8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return getOperandList();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 193,
   FQN="llvm::User::op_begin", NM="_ZNK4llvm4User8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return getOperandList$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 194,
   FQN="llvm::User::op_end", NM="_ZN4llvm4User6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return getOperandList().$add(NumUserOperands);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 197,
   FQN="llvm::User::op_end", NM="_ZNK4llvm4User6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return getOperandList$Const().$add(NumUserOperands);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 200,
   FQN="llvm::User::operands", NM="_ZN4llvm4User8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User8operandsEv")
  //</editor-fold>
  public iterator_range<Use> operands() {
    return new iterator_range<Use>(op_begin(), op_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 203,
   FQN="llvm::User::operands", NM="_ZNK4llvm4User8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User8operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ Use> operands$Const() /*const*/ {
    return new iterator_range</*const*/ Use>(op_begin$Const(), op_end$Const());
  }


  /// \brief Iterator for directly iterating over the operand Values.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 208,
   FQN="llvm::User::value_op_iterator", NM="_ZN4llvm4User17value_op_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User17value_op_iteratorE")
  //</editor-fold>
  public static class/*struct*/ value_op_iterator extends /**/ iterator_adaptor_base<value_op_iterator, type$ptr<Use /*P*/> , std.random_access_iterator_tag, Value /*P*/ , Value /*P*/ > {
    //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator::value_op_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 212,
     FQN="llvm::User::value_op_iterator::value_op_iterator", NM="_ZN4llvm4User17value_op_iteratorC1EPNS_3UseE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User17value_op_iteratorC1EPNS_3UseE")
    //</editor-fold>
    public /*explicit*/ value_op_iterator() {
      this((type$ptr<Use /*P*/> )null);
    }
    public /*explicit*/ value_op_iterator(type$ptr<Use /*P*/> U/*= null*/) {
      // : iterator_adaptor_base<value_op_iterator, Use * , random_access_iterator_tag, Value * , int, Value * , Value * , iterator_traitsT$P<Use> >(U)
      //START JInit
      super(U);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 214,
     FQN="llvm::User::value_op_iterator::operator*", NM="_ZNK4llvm4User17value_op_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User17value_op_iteratordeEv")
    //</editor-fold>
    public Value /*P*/ $star() /*const*/ {
      return I.$star().$Value$P();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 215,
     FQN="llvm::User::value_op_iterator::operator->", NM="_ZNK4llvm4User17value_op_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZNK4llvm4User17value_op_iteratorptEv")
    //</editor-fold>
    public Value /*P*/ $arrow() /*const*/ {
      return $star();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator::value_op_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 208,
     FQN="llvm::User::value_op_iterator::value_op_iterator", NM="_ZN4llvm4User17value_op_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User17value_op_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ value_op_iterator(final /*const*/ value_op_iterator /*&*/ $Prm0) {
      // : iterator_adaptor_base<value_op_iterator, op_iterator, std::random_access_iterator_tag, Value * , ptrdiff_t, Value * , Value * >()
      //START JInit
      super($Prm0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_iterator::value_op_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 208,
     FQN="llvm::User::value_op_iterator::value_op_iterator", NM="_ZN4llvm4User17value_op_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User17value_op_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ value_op_iterator(JD$Move _dparam, final value_op_iterator /*&&*/$Prm0) {
      // : iterator_adaptor_base<value_op_iterator, op_iterator, std::random_access_iterator_tag, Value * , ptrdiff_t, Value * , Value * >(static_cast<value_op_iterator &&>())
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

      @Override
      public value_op_iterator clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };

  //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 218,
   FQN="llvm::User::value_op_begin", NM="_ZN4llvm4User14value_op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User14value_op_beginEv")
  //</editor-fold>
  public value_op_iterator value_op_begin() {
    return new value_op_iterator(op_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::value_op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 221,
   FQN="llvm::User::value_op_end", NM="_ZN4llvm4User12value_op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User12value_op_endEv")
  //</editor-fold>
  public value_op_iterator value_op_end() {
    return new value_op_iterator(op_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::User::operand_values">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 224,
   FQN="llvm::User::operand_values", NM="_ZN4llvm4User14operand_valuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User14operand_valuesEv")
  //</editor-fold>
  public iterator_range<Value /*P*/ > operand_values() {
    return make_range(value_op_begin(), value_op_end());
  }


  /// \brief Drop all references to operands.
  ///
  /// This function is in charge of "letting go" of all objects that this User
  /// refers to.  This allows one to 'delete' a whole class at a time, even
  /// though there may be circular references...  First all references are
  /// dropped, and all use counts go to zero.  Then everything is deleted for
  /// real.  Note that no operations are valid on an object that has "dropped
  /// all references", except operator delete.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 236,
   FQN="llvm::User::dropAllReferences", NM="_ZN4llvm4User17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    for (final Use /*&*/ U : operands())  {
      U.set((Value /*P*/ )null);
    }
  }


  /// \brief Replace uses of one Value with another.
  ///
  /// Replaces all references to the "From" definition with references to the
  /// "To" definition.

  /// \brief Replace uses of one Value with another.
  ///
  /// Replaces all references to the "From" definition with references to the
  /// "To" definition.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::replaceUsesOfWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 24,
   FQN="llvm::User::replaceUsesOfWith", NM="_ZN4llvm4User17replaceUsesOfWithEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4User17replaceUsesOfWithEPNS_5ValueES2_")
  //</editor-fold>
  public void replaceUsesOfWith(Value /*P*/ From, Value /*P*/ To) {
    if (From == To) {
      return; // Duh what?
    }
    assert ((!isa_Constant(this) || isa_GlobalValue(this))) : "Cannot call User::replaceUsesOfWith on a constant!";

    for (/*uint*/int i = 0, E = getNumOperands(); i != E; ++i)  {
      if (getOperand(i) == From) { // Is This operand is pointing to oldval?
        // The side effects of this setOperand call include linking to
        // "To", adding "this" to the uses list of To, and
        // most importantly, removing "this" from the use list of "From".
        setOperand(i, To); // Fix it now...
      }
    }
  }



  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::User::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/User.h", line = 248,
   FQN="llvm::User::classof", NM="_ZN4llvm4User7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm4User7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) || isa_Constant(V);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final ThreadLocal<java.util.LinkedList<UserCreationData>> creationData;
  private static final ThreadLocalThisSupplier<User> MemorySupplier;

  static {
    // the initialization is moved to the static block in order for fields to be initialized in correct order
    creationData = ThreadLocal.withInitial(()->new java.util.LinkedList<UserCreationData>());
    MemorySupplier = ThreadLocalThisSupplier.Create(User::assertThisConsumedByCtor, User.class.getName(), false);
  }

/*protected:*/
  /// Allocate a User with an operand pointer co-allocated.
  ///
  /// This is used for subclasses which need to allocate a variable number
  /// of operands, ie, 'hung off uses'.
  /// Allocate a User with an operand pointer co-allocated.
  ///
  /// This is used for subclasses which need to allocate a variable number
  /// of operands, ie, 'hung off uses'.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 154)
  public static <T extends User> T $new_HangOffUses(New$ConstructorCallback<T> $Ctor) {
    int $UsePtr = 1; // sizeof(Use *)
    Object[] data = new Object[1 + $UsePtr];
    type$ptr<?>/*void P*/ Start = create_type$ptr(data);
    type$ptr<?>/*void P*/ Result = Start.$add($UsePtr);
    UserCreationData Obj = new UserCreationData();
    Obj.NumUserOperands = 0;
    Obj.HasHungOffUses = true;
    Obj.HasDescriptor = false;
    Obj.$this = Result;
    // we support stack of assigned memories for creation of inner objects
    final LinkedList<UserCreationData> stack = creationData.get();
    assert stack != null : "creationData list should be prepared!";
    stack.addLast(Obj);
    T out = callConstructorImpl(Result, $Ctor);
    assert out == Obj.$this.$star() : "created object " + NativeTrace.getIdentityStr(out) + " must be the same as assigned into $this " + NativeTrace.getIdentityStr(Obj.$this.$star());
    return out;
  }
  /// Allocate a User with the operands co-allocated.
  ///
  /// This is used for subclasses which have a fixed number of operands.

  /// Allocate a User with the operands co-allocated.
  ///
  /// This is used for subclasses which have a fixed number of operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 146,
   FQN="llvm::User::operator new", NM="_ZN4llvm4UsernwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UsernwEjj")
  //</editor-fold>
  /*friend*/public static <T extends User> T /*void P*/ $new_FixedUses(/*size_tint UnusedSizeOf, *//*uint*/int Us, New$ConstructorCallback<T> $Ctor) {
    return allocateFixedOperandUser(/*s,*/Us, 0, $Ctor);
  }
  protected static <T extends User> T /*void P*/ $new_FixedUsesAndDesc(/*size_tint UnusedSizeOf, *//*uint*/int Us, /*uint*/int DescBytes, New$ConstructorCallback<T> $Ctor) {
    return allocateFixedOperandUser(/*s,*/Us, DescBytes, $Ctor);
  }

  private void $init() {
    final LinkedList<UserCreationData> stack = creationData.get();
    assert stack != null : "creationData list should be prepared!";
    assert !stack.isEmpty() : "creationData memory should be prepared!";
    UserCreationData d = stack.removeLast();
    assert d != null : "creationData should not be null!";
    NumUserOperands = d.NumUserOperands;
    HasHungOffUses = d.HasHungOffUses;
    HasDescriptor = d.HasDescriptor;
  }

  public static type$ptr<Use /*P*/> getOperandList$beingCreated() {
    return peek$UserCreationData().getOperandList();
  }

  private static UserCreationData peek$UserCreationData() {
    final LinkedList<UserCreationData> stack = creationData.get();
    assert stack != null : "creationData list should be prepared!";
    assert !stack.isEmpty() : "forgot to wrap constructor call in one of UserDerivedClass.$new_UserDerivedClass new operator calls?";
    UserCreationData d = stack.getLast();
    assert d != null : "creationData should not be null!";
    return d;
  }
  
  private static <T extends User> T callConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> $Ctor) {
    T createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
    assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
    return createdInstance;
  }

  private static boolean assertThisConsumedByCtor(User createdInstance, type$ptr Mem) {
    assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
    assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
    return true;
  }

  /**
   * In C++, these 3 fields are initialized not in ctor but in operator new.
   * An we need these fields before constructor is called.
   */
  private static class UserCreationData implements IUser {
    public int NumUserOperands;
    public boolean HasHungOffUses;
    public boolean HasDescriptor;
    private type$ptr<?> $this;
    public type$ptr<Use> getOperandList() {
      return HasHungOffUses ? getHungOffOperands() : getIntrusiveOperands();
    }
    public type$ptr<Use /*P*/>/*&*/ getHungOffOperands() {
      UserCreationData d = peek$UserCreationData();
      return (type$ptr<Use /*P*/>/*P*/) d.$this.$sub(1);
    }
    public type$ptr<Use /*P*/> getIntrusiveOperands() {
      UserCreationData d = peek$UserCreationData();
      return (type$ptr<Use /*P*/>) d.$this.$sub(NumUserOperands);
    }
    public type$ptr<?> $This$Ptr() {
      return $this;
    }
    public int getNumOperands() {
      return NumUserOperands;
    }
    public int getNumOperands$User() {
      return NumUserOperands;
    }
  }

  private final type$ptr<?> $This = $toConst(MemorySupplier.consumeAssignedMemory(this));

  public type$ptr<?> $This$Ptr() {
    return $This;
  }
  protected static IUser $BEING_CREATED() {
    UserCreationData out = peek$UserCreationData();
    return out;
  }

  protected User() { /*for descendants deleted ctors + for sentinels */ $init(); }
  protected static int $sizeof_PointerUIntPair$User$P() { return 1; };
  protected static int $sizeof_Use() { return 1; };
  protected static int $sizeof_DescriptorInfo() { return 1; };

  protected final OperandTraits<User> $OperandTraits() {
    OperandTraits<User> traits = OperandTraitsRegistry.<User>get(this.getClass());
    assert (traits != null) : "OperandTraits for " + getClass().getName() + " not registered";
    return traits;
  };

  public /*uint*/int getNumOperands$User() /*const*/ {
    return NumUserOperands;
  }

  @Override
  public void $delete() {
    User.$delete(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
