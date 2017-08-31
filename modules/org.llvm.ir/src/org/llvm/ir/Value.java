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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.T2Void;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.mdconst.MdconstGlobals;
import org.llvm.pass.*;
import org.llvm.llvmc.LLVMOpaqueValue;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;


//===----------------------------------------------------------------------===//
//                                 Value Class
//===----------------------------------------------------------------------===//

/// \brief LLVM Value Representation
///
/// This is a very important LLVM class. It is the base class of all values
/// computed by a program that may be used as operands to other values. Value is
/// the super class of other important classes such as Instruction and Function.
/// All Values have a Type. Type is not a subclass of Value. Some values can
/// have a name and they belong to some Module.  Setting the name on the Value
/// automatically updates the module's symbol table.
///
/// Every value has a "use list" that keeps track of which other Values are
/// using this Value.  A Value can also have an arbitrary number of ValueHandle
/// objects that watch it and listen to RAUW and Destroy events.  See
/// llvm/IR/ValueHandle.h for details.
//<editor-fold defaultstate="collapsed" desc="llvm::Value">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 71,
 FQN="llvm::Value", NM="_ZN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5ValueE")
//</editor-fold>
public class Value implements LLVMOpaqueValue, Destructors.ClassWithDestructor {
  private Type /*P*/ VTy;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final type$ref<Use /*P*/> UseList; // JAVA: keep it as reference to field. Need to pass reference into addToList
  
  /*friend  class ValueAsMetadata*/ // Allow access to IsUsedByMD.
  /*friend  class ValueHandleBase*/
  
  private /*const*//*uchar*/byte SubclassID; // Subclass identifier (for isa/dyn_cast)
  /*friend*//*private*/ /*JBIT unsigned char*/ boolean HasValueHandle /*: 1*/; // Has a ValueHandle pointing to this?
/*protected:*/
  /// \brief Hold subclass data that can be dropped.
  ///
  /// This member is similar to SubclassData, however it is for holding
  /// information which may be used to aid optimization, but which may be
  /// cleared to zero without affecting conservative interpretation.
  protected /*JBYTE unsigned char*/ byte SubclassOptionalData /*: 7*/;
/*private:*/
  /// \brief Hold arbitrary subclass data.
  ///
  /// This member is defined by this class, but is not used for anything.
  /// Subclasses can use it to hold whatever state they find useful.  This
  /// field is initialized to zero by the ctor.
  private /*ushort*/char SubclassData;
/*protected:*/
  /// \brief The number of operands in the subclass.
  ///
  /// This member is defined by this class, but not used for anything.
  /// Subclasses can use it to store their number of operands, if they have
  /// any.
  ///
  /// This is stored here to save space in User on 64-bit hosts.  Since most
  /// instances of Value have operands, 32-bit hosts aren't significantly
  /// affected.
  ///
  /// Note, this should *NOT* be used directly by any class other than User.
  /// User uses this value to find the Use list.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 109,
   FQN="llvm::Value::(anonymous)", NM="_ZN4llvm5ValueE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5ValueE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    public static final /*uint*/int NumUserOperandsBits = 28;
  /*}*/;
  protected /*uint*/int NumUserOperands /*: NumUserOperandsBits*/;
  
  // Use the same type as the bitfield above so that MSVC will pack them.
  protected /*JBIT unsigned int*/ boolean IsUsedByMD /*: 1*/;
  protected /*JBIT unsigned int*/ boolean HasName /*: 1*/;
  protected /*JBIT unsigned int*/ boolean HasHungOffUses /*: 1*/;
  protected /*JBIT unsigned int*/ boolean HasDescriptor /*: 1*/;
/*private:*/
  /*template <typename UseT> TEMPLATE*/
  // UseT == 'Use' or 'const Use'
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 119,
   FQN="llvm::Value::use_iterator_impl", NM="_ZN4llvm5Value17use_iterator_implE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17use_iterator_implE")
  //</editor-fold>
  public static class use_iterator_impl</*typename*/ UseT extends Use>  implements /*public*/ std.iterator<std.forward_iterator_tag, UseT /*P*/ >, type$iterator<use_iterator_impl<UseT>, UseT> {
    private UseT /*P*/ U;
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::use_iterator_impl<UseT>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 123,
     FQN="llvm::Value::use_iterator_impl::use_iterator_impl<UseT>", NM="_ZN4llvm5Value17use_iterator_implC1EPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17use_iterator_implC1EPT_")
    //</editor-fold>
    private /*explicit*/ use_iterator_impl(UseT /*P*/ u) {
      // : U(u) 
      //START JInit
      this.U = /*ParenListExpr*/u;
      //END JInit
    }

    /*friend  class Value*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::use_iterator_impl<UseT>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 127,
     FQN="llvm::Value::use_iterator_impl::use_iterator_impl<UseT>", NM="_ZN4llvm5Value17use_iterator_implC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17use_iterator_implC1Ev")
    //</editor-fold>
    public use_iterator_impl() {
      // : U() 
      //START JInit
      this.U = /*ParenListExpr*/null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 129,
     FQN="llvm::Value::use_iterator_impl::operator==", NM="_ZNK4llvm5Value17use_iterator_impleqERKNS0_17use_iterator_implIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17use_iterator_impleqERKNS0_17use_iterator_implIT_EE")
    //</editor-fold>
    public boolean $eq(final /*const*/ use_iterator_impl<UseT> /*&*/ x) /*const*/ {
      return U == x.U;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 130,
     FQN="llvm::Value::use_iterator_impl::operator!=", NM="_ZNK4llvm5Value17use_iterator_implneERKNS0_17use_iterator_implIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17use_iterator_implneERKNS0_17use_iterator_implIT_EE")
    //</editor-fold>
    public boolean $noteq(final /*const*/ use_iterator_impl<UseT> /*&*/ x) /*const*/ {
      return Native.$not($eq(x));
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 132,
     FQN="llvm::Value::use_iterator_impl::operator++", NM="_ZN4llvm5Value17use_iterator_implppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17use_iterator_implppEv")
    //</editor-fold>
    public use_iterator_impl<UseT> /*&*/ $preInc() {
      // Preincrement
      assert Native.$bool(U) : "Cannot increment end iterator!";
      U = (UseT)U.getNext();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 137,
     FQN="llvm::Value::use_iterator_impl::operator++", NM="_ZN4llvm5Value17use_iterator_implppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17use_iterator_implppEi")
    //</editor-fold>
    public use_iterator_impl<UseT> $postInc(int $Prm0) {
      // Postincrement
      /*<dependent type>*/use_iterator_impl<UseT> tmp = /*Deref*/$Clone(this);
      /*Deref*/this.$preInc();
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 143,
     FQN="llvm::Value::use_iterator_impl::operator*", NM="_ZNK4llvm5Value17use_iterator_impldeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17use_iterator_impldeEv")
    //</editor-fold>
    public UseT /*&*/ $star() /*const*/ {
      assert Native.$bool(U) : "Cannot dereference end iterator!";
      return $Deref(U);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 148,
     FQN="llvm::Value::use_iterator_impl::operator->", NM="_ZNK4llvm5Value17use_iterator_implptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17use_iterator_implptEv")
    //</editor-fold>
    public UseT /*P*/ $arrow() /*const*/ {
      return $AddrOf($star());
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_iterator_impl::operator use_iterator_impl<const type-parameter-0-0>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 150,
     FQN="llvm::Value::use_iterator_impl::operator use_iterator_impl<const type-parameter-0-0>", NM="_ZNK4llvm5Value17use_iterator_implcvNS0_17use_iterator_implIKT_EEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17use_iterator_implcvNS0_17use_iterator_implIKT_EEEv")
    //</editor-fold>
    public use_iterator_impl</*const*/ UseT> $use_iterator_impl$UseT$C() /*const*/ {
      return new use_iterator_impl</*const*/ UseT>(U);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public type$ptr<UseT> getPtr() {
      return (type$ptr<UseT>)U.$This$Ptr();
    }

    @Override
    public use_iterator_impl<UseT> clone() {
      return new use_iterator_impl<UseT>(this.U);
    }

    int $sub(type$ptr<UseT> other) {
      return getPtr().$sub(other);
    }

    @Override
    public boolean $eq(Object other) {
      return $eq((use_iterator_impl<UseT>)other);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "U=" + U // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /*template <typename UserTy> TEMPLATE*/
  // UserTy == 'User' or 'const User'
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 155,
   FQN="llvm::Value::user_iterator_impl", NM="_ZN4llvm5Value18user_iterator_implE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18user_iterator_implE")
  //</editor-fold>
  public static class user_iterator_impl</*typename*/ UserTy extends User>  implements /*public*/ std.iterator<std.forward_iterator_tag, UserTy /*P*/ >, type$iterator<user_iterator_impl<UserTy>, UserTy> {
    private use_iterator_impl<Use> UI;
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::user_iterator_impl<UserTy>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 159,
     FQN="llvm::Value::user_iterator_impl::user_iterator_impl<UserTy>", NM="_ZN4llvm5Value18user_iterator_implC1EPNS_3UseE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18user_iterator_implC1EPNS_3UseE")
    //</editor-fold>
    private /*explicit*/ user_iterator_impl(Use /*P*/ U) {
      // : UI(U) 
      //START JInit
      this.UI = new use_iterator_impl<Use>(U);
      //END JInit
    }

    /*friend  class Value*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::user_iterator_impl<UserTy>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 163,
     FQN="llvm::Value::user_iterator_impl::user_iterator_impl<UserTy>", NM="_ZN4llvm5Value18user_iterator_implC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18user_iterator_implC1Ev")
    //</editor-fold>
    public user_iterator_impl() {
      this.UI = new use_iterator_impl();
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 165,
     FQN="llvm::Value::user_iterator_impl::operator==", NM="_ZNK4llvm5Value18user_iterator_impleqERKNS0_18user_iterator_implIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_impleqERKNS0_18user_iterator_implIT_EE")
    //</editor-fold>
    public boolean $eq(final /*const*/ user_iterator_impl<UserTy> /*&*/ x) /*const*/ {
      return UI.$eq(x.UI);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 166,
     FQN="llvm::Value::user_iterator_impl::operator!=", NM="_ZNK4llvm5Value18user_iterator_implneERKNS0_18user_iterator_implIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_implneERKNS0_18user_iterator_implIT_EE")
    //</editor-fold>
    public boolean $noteq(final /*const*/ user_iterator_impl<UserTy> /*&*/ x) /*const*/ {
      return Native.$not($eq(x));
    }

    
    /// \brief Returns true if this iterator is equal to user_end() on the value.
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::atEnd">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 169,
     FQN="llvm::Value::user_iterator_impl::atEnd", NM="_ZNK4llvm5Value18user_iterator_impl5atEndEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_impl5atEndEv")
    //</editor-fold>
    public boolean atEnd() /*const*/ {
      return Native.$eq_ptr(/*Deref*/this, new user_iterator_impl<UserTy>());
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 171,
     FQN="llvm::Value::user_iterator_impl::operator++", NM="_ZN4llvm5Value18user_iterator_implppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18user_iterator_implppEv")
    //</editor-fold>
    public user_iterator_impl<UserTy> /*&*/ $preInc() {
      // Preincrement
      UI.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 175,
     FQN="llvm::Value::user_iterator_impl::operator++", NM="_ZN4llvm5Value18user_iterator_implppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18user_iterator_implppEi")
    //</editor-fold>
    public user_iterator_impl<UserTy> $postInc(int $Prm0) {
      // Postincrement
      /*<dependent type>*/user_iterator_impl<UserTy> tmp = $Clone(/*Deref*/this);
      /*Deref*/this.$preInc();
      return tmp;
    }

    
    // Retrieve a pointer to the current User.
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 182,
     FQN="llvm::Value::user_iterator_impl::operator*", NM="_ZNK4llvm5Value18user_iterator_impldeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_impldeEv")
    //</editor-fold>
    public UserTy /*P*/ $star() /*const*/ {
      return (UserTy)UI.$arrow().getUser();
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 186,
     FQN="llvm::Value::user_iterator_impl::operator->", NM="_ZNK4llvm5Value18user_iterator_implptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_implptEv")
    //</editor-fold>
    public UserTy /*P*/ $arrow() /*const*/ {
      return $star();
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::operator user_iterator_impl<const type-parameter-0-0>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 188,
     FQN="llvm::Value::user_iterator_impl::operator user_iterator_impl<const type-parameter-0-0>", NM="_ZNK4llvm5Value18user_iterator_implcvNS0_18user_iterator_implIKT_EEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_implcvNS0_18user_iterator_implIKT_EEEv")
    //</editor-fold>
    public user_iterator_impl</*const*/ UserTy> $user_iterator_impl$UserTy$C() /*const*/ {
      return new user_iterator_impl</*const*/ UserTy>(UI.U);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_iterator_impl::getUse">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 192,
     FQN="llvm::Value::user_iterator_impl::getUse", NM="_ZNK4llvm5Value18user_iterator_impl6getUseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18user_iterator_impl6getUseEv")
    //</editor-fold>
    public Use /*&*/ getUse() /*const*/ {
      return $Deref(UI);
    }
    
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public type$ptr<Use> getUsePtr() {
      return UI.getPtr();
    }

    public user_iterator_impl(user_iterator_impl<UserTy> $Prm0) {
      this.UI = $Clone($Prm0.UI);
    }
    
    @Override
    public user_iterator_impl<UserTy> clone() {
      return new user_iterator_impl<UserTy>(this);
    }

    @Override
    public boolean $eq(Object other) {
      return $eq((user_iterator_impl<UserTy>)other);
    }
    
    void $assign(user_iterator_impl<UserTy> other) {
      this.UI = $Clone(other.UI);
    }

    void $assignMove(user_iterator_impl<UserTy> other) {
      this.UI = other.UI;
      other.UI = null;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "UI=" + UI // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 195,
   FQN="llvm::Value::operator=", NM="_ZN4llvm5ValueaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5ValueaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ Value /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 196,
   FQN="llvm::Value::Value", NM="_ZN4llvm5ValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5ValueC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Value(final /*const*/ Value /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::Value">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 48,
   FQN="llvm::Value::Value", NM="_ZN4llvm5ValueC1EPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5ValueC1EPNS_4TypeEj")
  //</editor-fold>
  protected/*protected*/ Value(Type /*P*/ ty, /*uint*/int scid) {
    // : VTy(checkType(ty)), UseList(null), SubclassID(scid), HasValueHandle(0), SubclassOptionalData(0), SubclassData(0), NumUserOperands(0), IsUsedByMD(false), HasName(false) 
    //START JInit
    this.VTy = ValueStatics.checkType(ty);
    this.UseList = create_type$null$ref();
    this.SubclassID = $uint2uchar(scid);
    this.HasValueHandle = false;
    this.SubclassOptionalData = $uchar2uchar_7bits($int2uchar(0));
    this.SubclassData = $int2ushort(0);
    this.NumUserOperands = 0;
    this.IsUsedByMD = false;
    this.HasName = false;
    //END JInit
    // FIXME: Why isn't this in the subclass gunk??
    // Note, we cannot call isa<CallInst> before the CallInst has been
    // constructed.
    if ($uchar2int(SubclassID) == Instruction.OtherOps.Call || $uchar2int(SubclassID) == Instruction.TermOps.Invoke) {
      assert ((VTy.isFirstClassType() || VTy.isVoidTy() || VTy.isStructTy())) : "invalid CallInst type!";
    } else if ($uchar2int(SubclassID) != ValueTy.BasicBlockVal.getValue()
       && ($uchar2int(SubclassID) < ValueTy.ConstantFirstVal.getValue() || $uchar2int(SubclassID) > ValueTy.ConstantLastVal.getValue())) {
      assert ((VTy.isFirstClassType() || VTy.isVoidTy())) : "Cannot create non-first-class values except for constants!";
    }
    static_assert($sizeof_Value() == 3 * $sizeof_ptr(/*Object */) + 2 * $sizeof_UInt(), $("Value too big"));
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::~Value">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 66,
   FQN="llvm::Value::~Value", NM="_ZN4llvm5ValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5ValueD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Notify all ValueHandles (if present) that this value is going away.
    if (HasValueHandle) {
      ValueHandleBase.ValueIsDeleted(this);
    }
    if (isUsedByMetadata()) {
      ValueAsMetadata.handleDeletion(this);
    }
//#ifndef NDEBUG     
    if (!NativeTrace.NDEBUG()) {
      // Only in -g mode...
      // Check to make sure that there are no uses of this value that are still
      // around when the value is destroyed.  If there are, then we have a dangling
      // reference and something is wrong.  This code is here to print out where
      // the value is still being referenced.
      //
      if (!use_empty()) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/"While deleting: "), $Deref(VTy)).$out(/*KEEP_STR*/" %").$out(getName()).$out(/*KEEP_STR*/$LF);
        for (User /*P*/ U : users())  {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"Use still stuck around after Def is destroyed:"), $Deref(U)).$out(/*KEEP_STR*/$LF);
        }
      }
    }
//#endif
    assert (use_empty()) : "Uses remain when a value is destroyed!";
    
    // If this value is named, destroy the name.  This should not be in a symtab
    // at this point.
    destroyValueName();
  }


  
  /// \brief Support for debugging, callable in GDB: V->dump()
  
  // Value::dump - allow easy printing of Values from the debugger.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3534,
   FQN="llvm::Value::dump", NM="_ZNK4llvm5Value4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), /*IsForDebug=*/ true);
    dbgs().$out_char($$LF);
  }

  
  /// \brief Implement operator<< on Value.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3389,
   FQN="llvm::Value::print", NM="_ZNK4llvm5Value5printERNS_11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value5printERNS_11raw_ostreamEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS) /*const*/ {
    print(ROS, false);
  }
  public void print(final raw_ostream /*&*/ ROS, boolean IsForDebug/*= false*/) /*const*/ {
    ModuleSlotTracker MST = null;
    try {
      boolean ShouldInitializeAllMetadata = false;
      {
        /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(this);
        if ((I != null)) {
          ShouldInitializeAllMetadata = AsmWriterStatics.isReferencingMDNode($Deref(I));
        } else if (isa_Function(this) || isa_MetadataAsValue(this)) {
          ShouldInitializeAllMetadata = true;
        }
      }
      
      MST/*J*/= new ModuleSlotTracker(AsmWriterStatics.getModuleFromVal(this), ShouldInitializeAllMetadata);
      print(ROS, MST, IsForDebug);
    } finally {
      if (MST != null) { MST.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3400,
   FQN="llvm::Value::print", NM="_ZNK4llvm5Value5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS, final ModuleSlotTracker /*&*/ MST) /*const*/ {
    print(ROS, MST, 
       false);
  }
  public void print(final raw_ostream /*&*/ ROS, final ModuleSlotTracker /*&*/ MST, 
       boolean IsForDebug/*= false*/) /*const*/ {
    formatted_raw_ostream OS = null;
    SlotTracker EmptySlotTable = null;
    try {
      OS/*J*/= new formatted_raw_ostream(ROS);
      EmptySlotTable/*J*/= new SlotTracker(((/*static_cast*//*const*/ Module /*P*/ )((/*const*/ Module /*P*/ )null)));
      final SlotTracker /*&*/ SlotTable = (MST.getMachine() != null) ? $Deref(MST.getMachine()) : EmptySlotTable;
      T2Void<Function/*P*/>/*const*/ incorporateFunction = /*[&, &MST]*/ (/*const*/ Function /*P*/ F) -> {
            if ((F != null)) {
              MST.incorporateFunction($Deref(F));
            }
          };
      {

        /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(this);
        if ((I != null)) {
          AssemblyWriter W = null;
          try {
            incorporateFunction.$call((I.getParent$Const() != null) ? I.getParent$Const().getParent$Const() : (/*const*/ Function /*P*/ )null);
            W/*J*/= new AssemblyWriter(OS, SlotTable, AsmWriterStatics.getModuleFromVal(I), (AssemblyAnnotationWriter /*P*/ )null, IsForDebug);
            W.printInstruction($Deref(I));
          } finally {
            if (W != null) { W.$destroy(); }
          }
        } else {
          /*const*/ BasicBlock /*P*/ BB = dyn_cast_BasicBlock(this);
          if ((BB != null)) {
            AssemblyWriter W = null;
            try {
              incorporateFunction.$call(BB.getParent$Const());
              W/*J*/= new AssemblyWriter(OS, SlotTable, AsmWriterStatics.getModuleFromVal(BB), (AssemblyAnnotationWriter /*P*/ )null, IsForDebug);
              W.printBasicBlock(BB);
            } finally {
              if (W != null) { W.$destroy(); }
            }
          } else {
            /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(this);
            if ((GV != null)) {
              AssemblyWriter W = null;
              try {
                W/*J*/= new AssemblyWriter(OS, SlotTable, GV.getParent$Const(), (AssemblyAnnotationWriter /*P*/ )null, IsForDebug);
                {
                  /*const*/ GlobalVariable /*P*/ V = dyn_cast_GlobalVariable(GV);
                  if ((V != null)) {
                    W.printGlobal(V);
                  } else {
                    /*const*/ Function /*P*/ F = dyn_cast_Function(GV);
                    if ((F != null)) {
                      W.printFunction(F);
                    } else {
                      W.printIndirectSymbol(cast_GlobalIndirectSymbol(GV));
                    }
                  }
                }
              } finally {
                if (W != null) { W.$destroy(); }
              }
            } else {
              /*const*/ MetadataAsValue /*P*/ V = dyn_cast_MetadataAsValue(this);
              if ((V != null)) {
                V.getMetadata().print(ROS, MST, AsmWriterStatics.getModuleFromVal(V));
              } else {
                /*const*/ Constant /*P*/ C = dyn_cast_Constant(this);
                if ((C != null)) {
                  TypePrinting TypePrinter = null;
                  try {
                    TypePrinter/*J*/= new TypePrinting();
                    TypePrinter.print(C.getType(), OS);
                    OS.$out_char($$SPACE);
                    AsmWriterStatics.WriteConstantInternal(OS, C, TypePrinter, MST.getMachine(), (/*const*/ Module /*P*/ )null);
                  } finally {
                    if (TypePrinter != null) { TypePrinter.$destroy(); }
                  }
                } else if (isa_InlineAsm(this) || isa_Argument(this)) {
                  this.printAsOperand(OS, /* PrintType */ true, MST);
                } else {
                  throw new llvm_unreachable("Unknown value to print out!");
                }
              }
            }
          }
        }
      }
    } finally {
      if (EmptySlotTable != null) { EmptySlotTable.$destroy(); }
      if (OS != null) { OS.$destroy(); }
    }
  }

  /// @}
  
  /// \brief Print the name of this Value out to the specified raw_ostream.
  ///
  /// This is useful when you just want to print 'int %reg126', not the
  /// instruction that generated it. If you specify a Module for context, then
  /// even constanst get pretty-printed; for example, the type of a null
  /// pointer is printed symbolically.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::printAsOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3468,
   FQN="llvm::Value::printAsOperand", NM="_ZNK4llvm5Value14printAsOperandERNS_11raw_ostreamEbPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value14printAsOperandERNS_11raw_ostreamEbPKNS_6ModuleE")
  //</editor-fold>
  public void printAsOperand(final raw_ostream /*&*/ O) /*const*/ {
    printAsOperand(O, true, 
                (/*const*/ Module /*P*/ )null);
  }
  public void printAsOperand(final raw_ostream /*&*/ O, boolean PrintType/*= true*/) /*const*/ {
    printAsOperand(O, PrintType, 
                (/*const*/ Module /*P*/ )null);
  }
  public void printAsOperand(final raw_ostream /*&*/ O, boolean PrintType/*= true*/, 
                /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    SlotTracker Machine = null;
    ModuleSlotTracker MST = null;
    try {
      if (!(M != null)) {
        M = AsmWriterStatics.getModuleFromVal(this);
      }
      if (!PrintType) {
        if (AsmWriterStatics.printWithoutType(/*Deref*/this, O, (SlotTracker /*P*/ )null, M)) {
          return;
        }
      }
      
      Machine/*J*/= new SlotTracker(M, /* ShouldInitializeAllMetadata */ isa_MetadataAsValue(this));
      MST/*J*/= new ModuleSlotTracker(Machine, M);
      AsmWriterStatics.printAsOperandImpl(/*Deref*/this, O, PrintType, MST);
    } finally {
      if (MST != null) { MST.$destroy(); }
      if (Machine != null) { Machine.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::printAsOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3483,
   FQN="llvm::Value::printAsOperand", NM="_ZNK4llvm5Value14printAsOperandERNS_11raw_ostreamEbRNS_17ModuleSlotTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value14printAsOperandERNS_11raw_ostreamEbRNS_17ModuleSlotTrackerE")
  //</editor-fold>
  public void printAsOperand(final raw_ostream /*&*/ O, boolean PrintType, 
                final ModuleSlotTracker /*&*/ MST) /*const*/ {
    if (!PrintType) {
      if (AsmWriterStatics.printWithoutType(/*Deref*/this, O, MST.getMachine(), MST.getModule())) {
        return;
      }
    }
    
    AsmWriterStatics.printAsOperandImpl(/*Deref*/this, O, PrintType, MST);
  }

  /// @}
  
  /// \brief All values are typed, get the type of this value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 227,
   FQN="llvm::Value::getType", NM="_ZNK4llvm5Value7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value7getTypeEv")
  //</editor-fold>
  public Type /*P*/ getType() /*const*/ {
    return VTy;
  }

  
  /// \brief All values hold a context through their type.
  
  /// \brief All values hold a context through their type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 646,
   FQN="llvm::Value::getContext", NM="_ZNK4llvm5Value10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return VTy.getContext();
  }


  
  // \brief All values can potentially be named.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 233,
   FQN="llvm::Value::hasName", NM="_ZNK4llvm5Value7hasNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value7hasNameEv")
  //</editor-fold>
  public boolean hasName() /*const*/ {
    return HasName;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getValueName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 163,
   FQN="llvm::Value::getValueName", NM="_ZNK4llvm5Value12getValueNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value12getValueNameEv")
  //</editor-fold>
  public StringMapEntry<Value /*P*/ > /*P*/ getValueName() /*const*/ {
    if (!HasName) {
      return null;
    }
    
    final LLVMContext /*&*/ Ctx = getContext();
    DenseMapIterator</*const*/ Value /*P*/ , StringMapEntry<Value /*P*/ > /*P*/ > I = Ctx.pImpl.ValueNames.find(this);
    assert (I.$noteq(/*NO_ITER_COPY*/Ctx.pImpl.ValueNames.end())) : "No name entry found!";
    
    return I.$arrow().second;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::setValueName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 174,
   FQN="llvm::Value::setValueName", NM="_ZN4llvm5Value12setValueNameEPNS_14StringMapEntryIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value12setValueNameEPNS_14StringMapEntryIPS0_EE")
  //</editor-fold>
  public void setValueName(StringMapEntry<Value /*P*/ > /*P*/ VN) {
    final LLVMContext /*&*/ Ctx = getContext();
    assert ((HasName ? 1 : 0) == Ctx.pImpl.ValueNames.count(this)) : "HasName bit out of sync!";
    if (!(VN != null)) {
      if (HasName) {
        Ctx.pImpl.ValueNames.erase(this);
      }
      HasName = false;
      return;
    }
    
    HasName = true;
    Ctx.pImpl.ValueNames.$set(this, VN);
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::destroyValueName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 92,
   FQN="llvm::Value::destroyValueName", NM="_ZN4llvm5Value16destroyValueNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value16destroyValueNameEv")
  //</editor-fold>
  private void destroyValueName() {
    StringMapEntry<Value /*P*/ > /*P*/ Name = getValueName();
    if ((Name != null)) {
      Name.Destroy();
    }
    setValueName((StringMapEntry<Value /*P*/ > /*P*/ )null);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::setNameImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 200,
   FQN="llvm::Value::setNameImpl", NM="_ZN4llvm5Value11setNameImplERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value11setNameImplERKNS_5TwineE")
  //</editor-fold>
  private void setNameImpl(final /*const*/ Twine /*&*/ NewName) {
    // Fast-path: LLVMContext can be set to strip out non-GlobalValue names
    if (getContext().shouldDiscardValueNames() && !isa_GlobalValue(this)) {
      return;
    }
    
    // Fast path for common IRBuilder case of setName("") when there is no name.
    if (NewName.isTriviallyEmpty() && !hasName()) {
      return;
    }
    
    SmallString/*<256>*/ NameData/*J*/= new SmallString/*<256>*/(256);
    StringRef NameRef = NewName.toStringRef(NameData);
    assert (NameRef.find_first_of($$TERM) == StringRef.npos) : "Null bytes are not allowed in names";
    
    // Name isn't changing?
    if ($eq_StringRef(getName(), /*NO_COPY*/NameRef)) {
      return;
    }
    assert (!getType().isVoidTy()) : "Cannot assign a name to void values!";
    
    // Get the symbol table to update for this object.
    type$ref<ValueSymbolTable /*P*/ > ST = create_type$ref();
    if (ValueStatics.getSymTab(this, ST)) {
      return; // Cannot set a name on this value (e.g. constant).
    }
    if (!(ST.$deref() != null)) { // No symbol table to update?  Just do the change.
      if (NameRef.empty()) {
        // Free the name for this value.
        destroyValueName();
        return;
      }
      
      // NOTE: Could optimize for the case the name is shrinking to not deallocate
      // then reallocated.
      destroyValueName();
      
      // Create the new name.
      setValueName(StringMapEntry.<Value /*P*/ >Create(NameRef, (Value /*P*/)null));
      getValueName().setValue(this);
      return;
    }
    
    // NOTE: Could optimize for the case the name is shrinking to not deallocate
    // then reallocated.
    if (hasName()) {
      // Remove old name.
      ST.$deref().removeValueName(getValueName());
      destroyValueName();
      if (NameRef.empty()) {
        return;
      }
    }
    
    // Name is changing to something new.
    setValueName(ST.$deref().createValueName(new StringRef(NameRef), this));
  }


/*public:*/
  /// \brief Return a constant reference to the value's name.
  ///
  /// This is cheap and guaranteed to return the same reference as long as the
  /// value is not modified.
  /// \brief Return a constant reference to the value's name.
  ///
  /// This is cheap and guaranteed to return the same reference as long as the
  /// value is not modified.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 191,
   FQN="llvm::Value::getName", NM="_ZNK4llvm5Value7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    // Make sure the empty string is still a C string. For historical reasons,
    // some clients want to call .data() on the result and expect it to be null
    // terminated.
    if (!hasName()) {
      return new StringRef(/*KEEP_STR*/$EMPTY, 0);
    }
    return getValueName().getKey();
  }


  
  /// \brief Change the name of the value.
  ///
  /// Choose a new unique name if the provided name is taken.
  ///
  /// \param Name The new name; or "" if the value's name should be removed.
  
  /// \brief Change the name of the value.
  ///
  /// Choose a new unique name if the provided name is taken.
  ///
  /// \param Name The new name; or "" if the value's name should be removed.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 257,
   FQN="llvm::Value::setName", NM="_ZN4llvm5Value7setNameERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value7setNameERKNS_5TwineE")
  //</editor-fold>
  public void setName(final /*const*/ Twine /*&*/ NewName) {
    setNameImpl(NewName);
    {
      Function /*P*/ F = dyn_cast_Function(this);
      if ((F != null)) {
        F.recalculateIntrinsicID();
      }
    }
  }


  
  /// \brief Transfer the name from V to this value.
  ///
  /// After taking V's name, sets V's name to empty.
  ///
  /// \note It is an error to call V->takeName(V).
  
  /// \brief Transfer the name from V to this value.
  ///
  /// After taking V's name, sets V's name to empty.
  ///
  /// \note It is an error to call V->takeName(V).
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::takeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 263,
   FQN="llvm::Value::takeName", NM="_ZN4llvm5Value8takeNameEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value8takeNameEPS0_")
  //</editor-fold>
  public void takeName(Value /*P*/ V) {
    type$ref<ValueSymbolTable /*P*/ > ST = create_type$null$ref(null);
    // If this value has a name, drop it.
    if (hasName()) {
      // Get the symtab this is in.
      if (ValueStatics.getSymTab(this, ST)) {
        // We can't set a name on this value, but we need to clear V's name if
        // it has one.
        if (V.hasName()) {
          V.setName(new Twine(/*KEEP_STR*/$EMPTY));
        }
        return; // Cannot set a name on this value (e.g. constant).
      }
      
      // Remove old name.
      if ((ST.$deref() != null)) {
        ST.$deref().removeValueName(getValueName());
      }
      destroyValueName();
    }
    
    // Now we know that this has no name.
    
    // If V has no name either, we're done.
    if (!V.hasName()) {
      return;
    }
    
    // Get this's symtab if we didn't before.
    if (!(ST.$deref() != null)) {
      if (ValueStatics.getSymTab(this, ST)) {
        // Clear V's name.
        V.setName(new Twine(/*KEEP_STR*/$EMPTY));
        return; // Cannot set a name on this value (e.g. constant).
      }
    }
    
    // Get V's ST, this should always succed, because V has a name.
    type$ref<ValueSymbolTable /*P*/ > VST = create_type$ref();
    boolean Failure = ValueStatics.getSymTab(V, VST);
    assert (!Failure) : "V has a name, so it should have a ST!";
    ///*J:(void)*/Failure;
    
    // If these values are both in the same symtab, we can do this very fast.
    // This works even if both values have no symtab yet.
    if (ST.$deref() == VST.$deref()) {
      // Take the name!
      setValueName(V.getValueName());
      V.setValueName((StringMapEntry<Value /*P*/ > /*P*/ )null);
      getValueName().setValue(this);
      return;
    }
    
    // Otherwise, things are slightly more complex.  Remove V's name from VST and
    // then reinsert it into ST.
    if ((VST.$deref() != null)) {
      VST.$deref().removeValueName(V.getValueName());
    }
    setValueName(V.getValueName());
    V.setValueName((StringMapEntry<Value /*P*/ > /*P*/ )null);
    getValueName().setValue(this);
    if ((ST.$deref() != null)) {
      ST.$deref().reinsertValue(this);
    }
  }


  
  /// \brief Change all uses of this to point to a new Value.
  ///
  /// Go through the uses list for this definition and make each use point to
  /// "V" instead of "this".  After this completes, 'this's use list is
  /// guaranteed to be empty.
  
  /// \brief Change all uses of this to point to a new Value.
  ///
  /// Go through the uses list for this definition and make each use point to
  /// "V" instead of "this".  After this completes, 'this's use list is
  /// guaranteed to be empty.
  // NDEBUG
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::replaceAllUsesWith">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 370,
   FQN="llvm::Value::replaceAllUsesWith", NM="_ZN4llvm5Value18replaceAllUsesWithEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value18replaceAllUsesWithEPS0_")
  //</editor-fold>
  public void replaceAllUsesWith(Value /*P*/ New) {
    assert ((New != null)) : "Value::replaceAllUsesWith(<null>) is invalid!";
    assert (!ValueStatics.contains(New, this)) : "this->replaceAllUsesWith(expr(this)) is NOT valid!";
    assert (New.getType() == getType()) : "replaceAllUses of value with new value of different type!";
    
    // Notify all ValueHandles (if present) that this value is going away.
    if (HasValueHandle) {
      ValueHandleBase.ValueIsRAUWd(this, New);
    }
    if (isUsedByMetadata()) {
      ValueAsMetadata.handleRAUW(this, New);
    }
    while (!use_empty()) {
      final Use /*&*/ U = UseList.$deref();
      {
        // Must handle Constants specially, we cannot call replaceUsesOfWith on a
        // constant because they are uniqued.
        Constant /*P*/ C = dyn_cast_Constant(U.getUser());
        if ((C != null)) {
          if (!isa_GlobalValue(C)) {
            C.handleOperandChange(this, New);
            continue;
          }
        }
      }
      
      U.set(New);
    }
    {
      
      BasicBlock /*P*/ BB = dyn_cast_BasicBlock(this);
      if ((BB != null)) {
        BB.replaceSuccessorsPhiUsesWith(cast_BasicBlock(New));
      }
    }
  }


  
  /// replaceUsesOutsideBlock - Go through the uses list for this definition and
  /// make each use point to "V" instead of "this" when the use is outside the
  /// block. 'This's use list is expected to have at least one element.
  /// Unlike replaceAllUsesWith this function does not support basic block
  /// values or constant users.
  
  /// replaceUsesOutsideBlock - Go through the uses list for this definition and
  /// make each use point to "V" instead of "this" when the use is outside the
  /// block. 'This's use list is expected to have at least one element.
  /// Unlike replaceAllUsesWith this function does not support basic block
  /// values or constant users.
  
  // Like replaceAllUsesWith except it does not handle constants or basic blocks.
  // This routine leaves uses within BB.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::replaceUsesOutsideBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 403,
   FQN="llvm::Value::replaceUsesOutsideBlock", NM="_ZN4llvm5Value23replaceUsesOutsideBlockEPS0_PNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value23replaceUsesOutsideBlockEPS0_PNS_10BasicBlockE")
  //</editor-fold>
  public void replaceUsesOutsideBlock(Value /*P*/ New, BasicBlock /*P*/ BB) {
    assert ((New != null)) : "Value::replaceUsesOutsideBlock(<null>, BB) is invalid!";
    assert (!ValueStatics.contains(New, this)) : "this->replaceUsesOutsideBlock(expr(this), BB) is NOT valid!";
    assert (New.getType() == getType()) : "replaceUses of value with new value of different type!";
    assert ((BB != null)) : "Basic block that may contain a use of 'New' must be defined\n";
    
    use_iterator_impl<Use> UI = use_begin();
    use_iterator_impl<Use> E = use_end();
    for (; UI.$noteq(E);) {
      final Use /*&*/ U = UI.$star();
      UI.$preInc();
      Instruction /*P*/ Usr = dyn_cast_Instruction(U.getUser());
      if ((Usr != null) && Usr.getParent() == BB) {
        continue;
      }
      U.set(New);
    }
  }


  
  //----------------------------------------------------------------------
  // Methods for handling the chain of uses of this Value.
  //
  // Materializing a function can introduce new uses, so these methods come in
  // two variants:
  // The methods that start with materialized_ check the uses that are
  // currently known given which functions are materialized. Be very careful
  // when using them since you might not get all uses.
  // The methods that don't start with materialized_ assert that modules is
  // fully materialized.
  
  //----------------------------------------------------------------------
  // Methods for handling the chain of uses of this Value.
  //
  // Materializing a function can introduce new uses, so these methods come in
  // two variants:
  // The methods that start with materialized_ check the uses that are
  // currently known given which functions are materialized. Be very careful
  // when using them since you might not get all uses.
  // The methods that don't start with materialized_ assert that modules is
  // fully materialized.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::assertModuleIsMaterialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 323,
   FQN="llvm::Value::assertModuleIsMaterialized", NM="_ZNK4llvm5Value26assertModuleIsMaterializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value26assertModuleIsMaterializedEv")
  //</editor-fold>
  public void assertModuleIsMaterialized() /*const*/ {
//#ifndef NDEBUG
    if (!NativeTrace.NDEBUG()) {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(this);
      if (!(GV != null)) {
        return;
      }
      /*const*/ Module /*P*/ M = GV.getParent$Const();
      if (!(M != null)) {
        return;
      }
      assert (M.isMaterialized());
    }
//#endif
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_empty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 289,
   FQN="llvm::Value::use_empty", NM="_ZNK4llvm5Value9use_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value9use_emptyEv")
  //</editor-fold>
  public boolean use_empty() /*const*/ {
    assertModuleIsMaterialized();
    return UseList.$deref() == null;
  }

  
  // JAVA: typedef use_iterator_impl<Use> use_iterator
//  public final class use_iterator extends use_iterator_impl<Use>{ };
  // JAVA: typedef use_iterator_impl<const Use> const_use_iterator
//  public final class const_use_iterator extends use_iterator_impl</*const*/ Use>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_use_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 296,
   FQN="llvm::Value::materialized_use_begin", NM="_ZN4llvm5Value22materialized_use_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value22materialized_use_beginEv")
  //</editor-fold>
  public use_iterator_impl<Use> materialized_use_begin() {
    return new use_iterator_impl<Use>(UseList.$deref());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_use_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 297,
   FQN="llvm::Value::materialized_use_begin", NM="_ZNK4llvm5Value22materialized_use_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value22materialized_use_beginEv")
  //</editor-fold>
  public use_iterator_impl</*const*/ Use> materialized_use_begin$Const() /*const*/ {
    return new use_iterator_impl</*const*/ Use>(UseList.$deref());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 300,
   FQN="llvm::Value::use_begin", NM="_ZN4llvm5Value9use_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value9use_beginEv")
  //</editor-fold>
  public use_iterator_impl<Use> use_begin() {
    assertModuleIsMaterialized();
    return materialized_use_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 304,
   FQN="llvm::Value::use_begin", NM="_ZNK4llvm5Value9use_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value9use_beginEv")
  //</editor-fold>
  public use_iterator_impl</*const*/ Use> use_begin$Const() /*const*/ {
    assertModuleIsMaterialized();
    return materialized_use_begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 308,
   FQN="llvm::Value::use_end", NM="_ZN4llvm5Value7use_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value7use_endEv")
  //</editor-fold>
  public use_iterator_impl<Use> use_end() {
    return new use_iterator_impl<Use>();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::use_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 309,
   FQN="llvm::Value::use_end", NM="_ZNK4llvm5Value7use_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value7use_endEv")
  //</editor-fold>
  public use_iterator_impl</*const*/ Use> use_end$Const() /*const*/ {
    return new use_iterator_impl</*const*/ Use>();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_uses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 310,
   FQN="llvm::Value::materialized_uses", NM="_ZN4llvm5Value17materialized_usesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value17materialized_usesEv")
  //</editor-fold>
  public iterator_range<Use /*&*/ > materialized_uses() {
    return make_range(materialized_use_begin(), use_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_uses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 313,
   FQN="llvm::Value::materialized_uses", NM="_ZNK4llvm5Value17materialized_usesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17materialized_usesEv")
  //</editor-fold>
  public iterator_range</*const*/ Use /*&*/ > materialized_uses$Const() /*const*/ {
    return make_range(materialized_use_begin$Const(), use_end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::uses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 316,
   FQN="llvm::Value::uses", NM="_ZN4llvm5Value4usesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value4usesEv")
  //</editor-fold>
  public iterator_range<Use /*&*/ > uses() {
    assertModuleIsMaterialized();
    return materialized_uses();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::uses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 320,
   FQN="llvm::Value::uses", NM="_ZNK4llvm5Value4usesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value4usesEv")
  //</editor-fold>
  public iterator_range</*const*/ Use /*&*/ > uses$Const() /*const*/ {
    assertModuleIsMaterialized();
    return materialized_uses$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 325,
   FQN="llvm::Value::user_empty", NM="_ZNK4llvm5Value10user_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value10user_emptyEv")
  //</editor-fold>
  public boolean user_empty() /*const*/ {
    assertModuleIsMaterialized();
    return $eq_ptr(UseList, null);
  }

  
  // JAVA: typedef user_iterator_impl<User> user_iterator
//  public final class user_iterator extends user_iterator_impl<User>{ };
  // JAVA: typedef user_iterator_impl<const User> const_user_iterator
//  public final class const_user_iterator extends user_iterator_impl</*const*/ User>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_user_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 332,
   FQN="llvm::Value::materialized_user_begin", NM="_ZN4llvm5Value23materialized_user_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value23materialized_user_beginEv")
  //</editor-fold>
  public user_iterator_impl<User> materialized_user_begin() {
    return new user_iterator_impl<User>(UseList.$deref());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_user_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 333,
   FQN="llvm::Value::materialized_user_begin", NM="_ZNK4llvm5Value23materialized_user_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value23materialized_user_beginEv")
  //</editor-fold>
  public user_iterator_impl</*const*/ User> materialized_user_begin$Const() /*const*/ {
    return new user_iterator_impl</*const*/ User>(UseList.$deref());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 336,
   FQN="llvm::Value::user_begin", NM="_ZN4llvm5Value10user_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value10user_beginEv")
  //</editor-fold>
  public user_iterator_impl<User> user_begin() {
    assertModuleIsMaterialized();
    return materialized_user_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 340,
   FQN="llvm::Value::user_begin", NM="_ZNK4llvm5Value10user_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value10user_beginEv")
  //</editor-fold>
  public user_iterator_impl</*const*/ User> user_begin$Const() /*const*/ {
    assertModuleIsMaterialized();
    return materialized_user_begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 344,
   FQN="llvm::Value::user_end", NM="_ZN4llvm5Value8user_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value8user_endEv")
  //</editor-fold>
  public user_iterator_impl<User> user_end() {
    return new user_iterator_impl<User>();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 345,
   FQN="llvm::Value::user_end", NM="_ZNK4llvm5Value8user_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value8user_endEv")
  //</editor-fold>
  public user_iterator_impl</*const*/ User> user_end$Const() /*const*/ {
    return new user_iterator_impl</*const*/ User>();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 346,
   FQN="llvm::Value::user_back", NM="_ZN4llvm5Value9user_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value9user_backEv")
  //</editor-fold>
  public final/*public*/ User /*P*/ user_back$Value() {
    assertModuleIsMaterialized();
    return materialized_user_begin().$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::user_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 350,
   FQN="llvm::Value::user_back", NM="_ZNK4llvm5Value9user_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value9user_backEv")
  //</editor-fold>
  public final/*public*/ /*const*/ User /*P*/ user_back$Value$Const() /*const*/ {
    assertModuleIsMaterialized();
    return materialized_user_begin$Const().$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_users">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 354,
   FQN="llvm::Value::materialized_users", NM="_ZN4llvm5Value18materialized_usersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value18materialized_usersEv")
  //</editor-fold>
  public iterator_range<User /*P*/ > materialized_users() {
    return make_range(materialized_user_begin(), user_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::materialized_users">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 357,
   FQN="llvm::Value::materialized_users", NM="_ZNK4llvm5Value18materialized_usersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value18materialized_usersEv")
  //</editor-fold>
  public iterator_range</*const*/ User /*P*/ > materialized_users$Const() /*const*/ {
    return make_range(materialized_user_begin$Const(), user_end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::users">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 360,
   FQN="llvm::Value::users", NM="_ZN4llvm5Value5usersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value5usersEv")
  //</editor-fold>
  public iterator_range<User /*P*/ > users() {
    assertModuleIsMaterialized();
    return materialized_users();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::users">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 364,
   FQN="llvm::Value::users", NM="_ZNK4llvm5Value5usersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value5usersEv")
  //</editor-fold>
  public iterator_range</*const*/ User /*P*/ > users$Const() /*const*/ {
    assertModuleIsMaterialized();
    return materialized_users$Const();
  }

  
  /// \brief Return true if there is exactly one user of this value.
  ///
  /// This is specialized because it is a common request and does not require
  /// traversing the whole use list.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasOneUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 373,
   FQN="llvm::Value::hasOneUse", NM="_ZNK4llvm5Value9hasOneUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value9hasOneUseEv")
  //</editor-fold>
  public boolean hasOneUse() /*const*/ {
    use_iterator_impl</*const*/ Use> I = use_begin$Const();
    use_iterator_impl</*const*/ Use> E = use_end$Const();
    if (I.$eq(E)) {
      return false;
    }
    return I.$preInc().$eq(E);
  }

  
  /// \brief Return true if this Value has exactly N users.
  
  /// \brief Return true if this Value has exactly N users.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasNUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 99,
   FQN="llvm::Value::hasNUses", NM="_ZNK4llvm5Value8hasNUsesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value8hasNUsesEj")
  //</editor-fold>
  public boolean hasNUses(/*uint*/int N) /*const*/ {
    use_iterator_impl</*const*/ Use> UI = use_begin$Const();
    use_iterator_impl</*const*/ Use> E = use_end$Const();
    
    for (; (N != 0); --N , UI.$preInc())  {
      if (UI.$eq(E)) {
        return false; // Too few.
      }
    }
    return UI.$eq(E);
  }


  
  /// \brief Return true if this value has N users or more.
  ///
  /// This is logically equivalent to getNumUses() >= N.
  
  /// \brief Return true if this value has N users or more.
  ///
  /// This is logically equivalent to getNumUses() >= N.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasNUsesOrMore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 107,
   FQN="llvm::Value::hasNUsesOrMore", NM="_ZNK4llvm5Value14hasNUsesOrMoreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value14hasNUsesOrMoreEj")
  //</editor-fold>
  public boolean hasNUsesOrMore(/*uint*/int N) /*const*/ {
    use_iterator_impl</*const*/ Use> UI = use_begin$Const();
    use_iterator_impl</*const*/ Use> E = use_end$Const();
    
    for (; (N != 0); --N , UI.$preInc())  {
      if (UI.$eq(E)) {
        return false; // Too few.
      }
    }
    
    return true;
  }


  
  /// \brief Check if this value is used in the specified basic block.
  
  /// \brief Check if this value is used in the specified basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::isUsedInBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 116,
   FQN="llvm::Value::isUsedInBasicBlock", NM="_ZNK4llvm5Value18isUsedInBasicBlockEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value18isUsedInBasicBlockEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean isUsedInBasicBlock(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    // This can be computed either by scanning the instructions in BB, or by
    // scanning the use list of this Value. Both lists can be very long, but
    // usually one is quite short.
    //
    // Scan both lists simultaneously until one is exhausted. This limits the
    // search to the shorter list.
    ilist_iterator</*const*/ Instruction> BI = BB.begin$Const();
    ilist_iterator</*const*/ Instruction> BE = BB.end$Const();
    user_iterator_impl</*const*/ User> UI = user_begin$Const();
    user_iterator_impl</*const*/ User> UE = user_end$Const();
    for (; BI.$noteq(BE) && UI.$noteq(UE); BI.$preInc() , UI.$preInc()) {
      // Scan basic block: Check if this Value is used by the instruction at BI.
      if ($noteq_ptr(std.find(BI.$arrow().op_begin$Const(), BI.$arrow().op_end$Const(), this), BI.$arrow().op_end$Const())) {
        return true;
      }
      // Scan use list: Check if the use at UI is in BB.
      /*const*/ Instruction /*P*/ User = dyn_cast_Instruction(UI.$star());
      if ((User != null) && User.getParent$Const() == BB) {
        return true;
      }
    }
    return false;
  }


  
  /// \brief This method computes the number of uses of this Value.
  ///
  /// This is a linear time operation.  Use hasOneUse, hasNUses, or
  /// hasNUsesOrMore to check for specific values.
  
  /// \brief This method computes the number of uses of this Value.
  ///
  /// This is a linear time operation.  Use hasOneUse, hasNUses, or
  /// hasNUsesOrMore to check for specific values.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getNumUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 137,
   FQN="llvm::Value::getNumUses", NM="_ZNK4llvm5Value10getNumUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value10getNumUsesEv")
  //</editor-fold>
  public /*uint*/int getNumUses() /*const*/ {
    return (/*uint*/int)std.distance(use_begin$Const(), use_end$Const());
  }


  
  /// \brief This method should only be used by the Use class.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::addUse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 397,
   FQN="llvm::Value::addUse", NM="_ZN4llvm5Value6addUseERNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value6addUseERNS_3UseE")
  //</editor-fold>
  public void addUse(final Use /*&*/ U) {
    U.addToList(UseList/*.$addr()*/);
  }

  
  /// \brief Concrete subclass of this.
  ///
  /// An enumeration for keeping track of the concrete subclass of Value that
  /// is actually instantiated. Values of this enumeration are kept in the
  /// Value classes SubclassID field. They are used for concrete type
  /// identification.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::ValueTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 405,
   FQN="llvm::Value::ValueTy", NM="_ZN4llvm5Value7ValueTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value7ValueTyE")
  //</editor-fold>
  public enum ValueTy implements Native.NativeUIntEnum {
    ArgumentVal(0),
    BasicBlockVal(ArgumentVal.getValue() + 1),
    MemoryUseVal(BasicBlockVal.getValue() + 1),
    MemoryDefVal(MemoryUseVal.getValue() + 1),
    MemoryPhiVal(MemoryDefVal.getValue() + 1),
    FunctionVal(MemoryPhiVal.getValue() + 1),
    GlobalAliasVal(FunctionVal.getValue() + 1),
    GlobalIFuncVal(GlobalAliasVal.getValue() + 1),
    GlobalVariableVal(GlobalIFuncVal.getValue() + 1),
    BlockAddressVal(GlobalVariableVal.getValue() + 1),
    ConstantExprVal(BlockAddressVal.getValue() + 1),
    
    // ConstantAggregate.
    ConstantArrayVal(ConstantExprVal.getValue() + 1),
    ConstantStructVal(ConstantArrayVal.getValue() + 1),
    ConstantVectorVal(ConstantStructVal.getValue() + 1),
    
    // ConstantData.
    UndefValueVal(ConstantVectorVal.getValue() + 1),
    ConstantAggregateZeroVal(UndefValueVal.getValue() + 1),
    ConstantDataArrayVal(ConstantAggregateZeroVal.getValue() + 1),
    ConstantDataVectorVal(ConstantDataArrayVal.getValue() + 1),
    ConstantIntVal(ConstantDataVectorVal.getValue() + 1),
    ConstantFPVal(ConstantIntVal.getValue() + 1),
    ConstantPointerNullVal(ConstantFPVal.getValue() + 1),
    ConstantTokenNoneVal(ConstantPointerNullVal.getValue() + 1),
    MetadataAsValueVal(ConstantTokenNoneVal.getValue() + 1),
    InlineAsmVal(MetadataAsValueVal.getValue() + 1),
    InstructionVal(InlineAsmVal.getValue() + 1),
    // Enum values starting at InstructionVal are used for Instructions;
    // don't add new values here!
    ConstantFirstVal(ValueTy.FunctionVal.getValue()),
    ConstantLastVal(ValueTy.ConstantTokenNoneVal.getValue()),
    ConstantDataFirstVal(ValueTy.UndefValueVal.getValue()),
    ConstantDataLastVal(ValueTy.ConstantTokenNoneVal.getValue()),
    ConstantAggregateFirstVal(ValueTy.ConstantArrayVal.getValue()),
    ConstantAggregateLastVal(ValueTy.ConstantVectorVal.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ValueTy valueOf(int val) {
      ValueTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ValueTy[] VALUES;
      private static final ValueTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ValueTy kind : ValueTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ValueTy[min < 0 ? (1-min) : 0];
        VALUES = new ValueTy[max >= 0 ? (1+max) : 0];
        for (ValueTy kind : ValueTy.values()) {
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
    private ValueTy(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Return an ID for the concrete type of this object.
  ///
  /// This is used to implement the classof checks.  This should not be used
  /// for any other purpose, as the values may change as LLVM evolves.  Also,
  /// note that for instructions, the Instruction's opcode is added to
  /// InstructionVal. So this means three things:
  /// # there is no value with code InstructionVal (no opcode==0).
  /// # there are more possible values for the value type than in ValueTy enum.
  /// # the InstructionVal enumerator must be the highest valued enumerator in
  ///   the ValueTy enum.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getValueID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 424,
   FQN="llvm::Value::getValueID", NM="_ZNK4llvm5Value10getValueIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value10getValueIDEv")
  //</editor-fold>
  public /*uint*/int getValueID() /*const*/ {
    return $uchar2uint(SubclassID);
  }

  
  /// \brief Return the raw optional flags value contained in this value.
  ///
  /// This should only be used when testing two Values for equivalence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getRawSubclassOptionalData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 431,
   FQN="llvm::Value::getRawSubclassOptionalData", NM="_ZNK4llvm5Value26getRawSubclassOptionalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value26getRawSubclassOptionalDataEv")
  //</editor-fold>
  public /*uint*/int getRawSubclassOptionalData() /*const*/ {
    return $uchar2uint($7bits_uchar2uchar(SubclassOptionalData));
  }

  
  /// \brief Clear the optional flags contained in this value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::clearSubclassOptionalData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 436,
   FQN="llvm::Value::clearSubclassOptionalData", NM="_ZN4llvm5Value25clearSubclassOptionalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value25clearSubclassOptionalDataEv")
  //</editor-fold>
  public void clearSubclassOptionalData() {
    SubclassOptionalData = $uchar2uchar_7bits($int2uchar(0));
  }

  
  /// \brief Check the optional flags for equality.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasSameSubclassOptionalData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 441,
   FQN="llvm::Value::hasSameSubclassOptionalData", NM="_ZNK4llvm5Value27hasSameSubclassOptionalDataEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value27hasSameSubclassOptionalDataEPKS0_")
  //</editor-fold>
  public boolean hasSameSubclassOptionalData(/*const*/ Value /*P*/ V) /*const*/ {
    return $uchar2int($7bits_uchar2uchar(SubclassOptionalData)) == $uchar2int($7bits_uchar2uchar(V.SubclassOptionalData));
  }

  
  /// \brief Clear any optional flags not set in the given Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::intersectOptionalDataWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 446,
   FQN="llvm::Value::intersectOptionalDataWith", NM="_ZN4llvm5Value25intersectOptionalDataWithEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value25intersectOptionalDataWithEPKS0_")
  //</editor-fold>
  public void intersectOptionalDataWith(/*const*/ Value /*P*/ V) {
    SubclassOptionalData &= $int2uchar_7bits($uchar2int($7bits_uchar2uchar(V.SubclassOptionalData)));
  }

  
  /// \brief Return true if there is a value handle associated with this value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::hasValueHandle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 451,
   FQN="llvm::Value::hasValueHandle", NM="_ZNK4llvm5Value14hasValueHandleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value14hasValueHandleEv")
  //</editor-fold>
  public boolean hasValueHandle() /*const*/ {
    return HasValueHandle;
  }

  
  /// \brief Return true if there is metadata referencing this value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::isUsedByMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 454,
   FQN="llvm::Value::isUsedByMetadata", NM="_ZNK4llvm5Value16isUsedByMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value16isUsedByMetadataEv")
  //</editor-fold>
  public boolean isUsedByMetadata() /*const*/ {
    return IsUsedByMD;
  }

  
  /// \brief Strip off pointer casts, all-zero GEPs, and aliases.
  ///
  /// Returns the original uncasted value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  
  /// \brief Strip off pointer casts, all-zero GEPs, and aliases.
  ///
  /// Returns the original uncasted value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripPointerCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 482,
   FQN="llvm::Value::stripPointerCasts", NM="_ZN4llvm5Value17stripPointerCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value17stripPointerCastsEv")
  //</editor-fold>
  public Value /*P*/ stripPointerCasts() {
    return ValueStatics./*<PointerStripKind.PSK_ZeroIndicesAndAliases>*/stripPointerCastsAndOffsets(PointerStripKind.PSK_ZeroIndicesAndAliases, this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripPointerCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 461,
   FQN="llvm::Value::stripPointerCasts", NM="_ZNK4llvm5Value17stripPointerCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value17stripPointerCastsEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ stripPointerCasts$Const() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).stripPointerCasts();
  }

  
  /// \brief Strip off pointer casts and all-zero GEPs.
  ///
  /// Returns the original uncasted value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  
  /// \brief Strip off pointer casts and all-zero GEPs.
  ///
  /// Returns the original uncasted value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripPointerCastsNoFollowAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 486,
   FQN="llvm::Value::stripPointerCastsNoFollowAliases", NM="_ZN4llvm5Value32stripPointerCastsNoFollowAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value32stripPointerCastsNoFollowAliasesEv")
  //</editor-fold>
  public Value /*P*/ stripPointerCastsNoFollowAliases() {
    return ValueStatics./*<PointerStripKind.PSK_ZeroIndices>*/stripPointerCastsAndOffsets(PointerStripKind.PSK_ZeroIndices, this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripPointerCastsNoFollowAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 470,
   FQN="llvm::Value::stripPointerCastsNoFollowAliases", NM="_ZNK4llvm5Value32stripPointerCastsNoFollowAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value32stripPointerCastsNoFollowAliasesEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ stripPointerCastsNoFollowAliases$Const() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).stripPointerCastsNoFollowAliases();
  }

  
  /// \brief Strip off pointer casts and all-constant inbounds GEPs.
  ///
  /// Returns the original pointer value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  
  /// \brief Strip off pointer casts and all-constant inbounds GEPs.
  ///
  /// Returns the original pointer value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripInBoundsConstantOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 490,
   FQN="llvm::Value::stripInBoundsConstantOffsets", NM="_ZN4llvm5Value28stripInBoundsConstantOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value28stripInBoundsConstantOffsetsEv")
  //</editor-fold>
  public Value /*P*/ stripInBoundsConstantOffsets() {
    return ValueStatics./*<PointerStripKind.PSK_InBoundsConstantIndices>*/stripPointerCastsAndOffsets(PointerStripKind.PSK_InBoundsConstantIndices, this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripInBoundsConstantOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 479,
   FQN="llvm::Value::stripInBoundsConstantOffsets", NM="_ZNK4llvm5Value28stripInBoundsConstantOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value28stripInBoundsConstantOffsetsEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ stripInBoundsConstantOffsets$Const() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).stripInBoundsConstantOffsets();
  }

  
  /// \brief Accumulate offsets from \a stripInBoundsConstantOffsets().
  ///
  /// Stores the resulting constant offset stripped into the APInt provided.
  /// The provided APInt will be extended or truncated as needed to be the
  /// correct bitwidth for an offset of this pointer type.
  ///
  /// If this is called on a non-pointer value, it returns 'this'.
  
  /// \brief Accumulate offsets from \a stripInBoundsConstantOffsets().
  ///
  /// Stores the resulting constant offset stripped into the APInt provided.
  /// The provided APInt will be extended or truncated as needed to be the
  /// correct bitwidth for an offset of this pointer type.
  ///
  /// If this is called on a non-pointer value, it returns 'this'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripAndAccumulateInBoundsConstantOffsets">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 494,
   FQN="llvm::Value::stripAndAccumulateInBoundsConstantOffsets", NM="_ZN4llvm5Value41stripAndAccumulateInBoundsConstantOffsetsERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value41stripAndAccumulateInBoundsConstantOffsetsERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public Value /*P*/ stripAndAccumulateInBoundsConstantOffsets(final /*const*/ DataLayout /*&*/ DL, 
                                           final APInt /*&*/ Offset) {
    if (!getType().isPointerTy()) {
      return this;
    }
    assert (Offset.getBitWidth() == DL.getPointerSizeInBits(cast_PointerType(getType()).getAddressSpace())) : "The offset must have exactly as many bits as our pointer.";
    
    // Even though we don't look through PHI nodes, we could be called on an
    // instruction in an unreachable block, which may be on a cycle.
    SmallPtrSet<Value /*P*/ > Visited/*J*/= new SmallPtrSet<Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    Visited.insert(this);
    Value /*P*/ V = this;
    do {
      {
        GEPOperator /*P*/ GEP = dyn_cast_GEPOperator(V);
        if ((GEP != null)) {
          if (!GEP.isInBounds()) {
            return V;
          }
          APInt GEPOffset/*J*/= new APInt(Offset);
          if (!GEP.accumulateConstantOffset(DL, GEPOffset)) {
            return V;
          }
          Offset.$assign(GEPOffset);
          V = GEP.getPointerOperand();
        } else if (Operator.getOpcode(V) == Instruction.CastOps.BitCast) {
          //JAVA: cast_User is enough, because not all is Operator, but only getOperand(0)
          // is needed here. In C++ it's OK to const_cast to anything
          V = /*cast_Operator*/cast_User(V).getOperand(0);
        } else {
          GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(V);
          if ((GA != null)) {
            V = GA.getAliasee();
          } else {
            {
              CallSite CS = new CallSite(V);
              if (CS.$bool()) {
                {
                  Value /*P*/ RV = CS.getReturnedArgOperand();
                  if ((RV != null)) {
                    V = RV;
                    continue;
                  }
                }
              }
            }
            
            return V;
          }
        }
      }
      assert (V.getType().isPointerTy()) : "Unexpected operand type!";
    } while (Visited.insert(V).second);
    
    return V;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripAndAccumulateInBoundsConstantOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 492,
   FQN="llvm::Value::stripAndAccumulateInBoundsConstantOffsets", NM="_ZNK4llvm5Value41stripAndAccumulateInBoundsConstantOffsetsERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value41stripAndAccumulateInBoundsConstantOffsetsERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public /*const*/ Value /*P*/ stripAndAccumulateInBoundsConstantOffsets$Const(final /*const*/ DataLayout /*&*/ DL, 
                                                 final APInt /*&*/ Offset) /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).
        stripAndAccumulateInBoundsConstantOffsets(DL, Offset);
  }

  
  /// \brief Strip off pointer casts and inbounds GEPs.
  ///
  /// Returns the original pointer value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  
  /// \brief Strip off pointer casts and inbounds GEPs.
  ///
  /// Returns the original pointer value.  If this is called on a non-pointer
  /// value, it returns 'this'.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripInBoundsOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 536,
   FQN="llvm::Value::stripInBoundsOffsets", NM="_ZN4llvm5Value20stripInBoundsOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value20stripInBoundsOffsetsEv")
  //</editor-fold>
  public Value /*P*/ stripInBoundsOffsets() {
    return ValueStatics./*<PointerStripKind.PSK_InBounds>*/stripPointerCastsAndOffsets(PointerStripKind.PSK_InBounds, this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Value::stripInBoundsOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 503,
   FQN="llvm::Value::stripInBoundsOffsets", NM="_ZNK4llvm5Value20stripInBoundsOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value20stripInBoundsOffsetsEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ stripInBoundsOffsets$Const() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).stripInBoundsOffsets();
  }

  
  /// \brief Returns the number of bytes known to be dereferenceable for the
  /// pointer value.
  ///
  /// If CanBeNull is set by this function the pointer can either be null or be
  /// dereferenceable up to the returned number of bytes.
  
  /// \brief Returns the number of bytes known to be dereferenceable for the
  /// pointer value.
  ///
  /// If CanBeNull is set by this function the pointer can either be null or be
  /// dereferenceable up to the returned number of bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getPointerDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 540,
   FQN="llvm::Value::getPointerDereferenceableBytes", NM="_ZNK4llvm5Value30getPointerDereferenceableBytesERKNS_10DataLayoutERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value30getPointerDereferenceableBytesERKNS_10DataLayoutERb")
  //</editor-fold>
  public /*uint*/int getPointerDereferenceableBytes(final /*const*/ DataLayout /*&*/ DL, 
                                final bool$ref/*bool &*/ CanBeNull) /*const*/ {
    assert (getType().isPointerTy()) : "must be pointer";
    
    /*uint*/int DerefBytes = 0;
    CanBeNull.$set(false);
    {
      /*const*/ Argument /*P*/ A = dyn_cast_Argument(this);
      if ((A != null)) {
        DerefBytes = $ulong2uint(A.getDereferenceableBytes());
        if (DerefBytes == 0 && A.hasByValAttr() && A.getType().isSized()) {
          DerefBytes = $ulong2uint(DL.getTypeStoreSize(A.getType()));
          CanBeNull.$set(false);
        }
        if (DerefBytes == 0) {
          DerefBytes = $ulong2uint(A.getDereferenceableOrNullBytes());
          CanBeNull.$set(true);
        }
      } else {
        ImmutableCallSite CS = new ImmutableCallSite(this);
        if (CS.$bool()) {
          DerefBytes = $ulong2uint(CS.getDereferenceableBytes($int2ushort(0)));
          if (DerefBytes == 0) {
            DerefBytes = $ulong2uint(CS.getDereferenceableOrNullBytes($int2ushort(0)));
            CanBeNull.$set(true);
          }
        } else {
          /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(this);
          if ((LI != null)) {
            {
              MDNode /*P*/ MD = LI.getMetadata(LLVMContext.Unnamed_enum.MD_dereferenceable.getValue());
              if ((MD != null)) {
                ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >extract$ValidPointer(ConstantInt.class, MD.getOperand(0));
                DerefBytes = $ulong2uint(CI.getLimitedValue());
              }
            }
            if (DerefBytes == 0) {
              {
                MDNode /*P*/ MD = LI.getMetadata(LLVMContext.Unnamed_enum.MD_dereferenceable_or_null.getValue());
                if ((MD != null)) {
                  ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >extract$ValidPointer(ConstantInt.class, MD.getOperand(0));
                  DerefBytes = $ulong2uint(CI.getLimitedValue());
                }
              }
              CanBeNull.$set(true);
            }
          } else {
            /*const*/ AllocaInst /*P*/ AI = dyn_cast_AllocaInst(this);
            if ((AI != null)) {
              if (AI.getAllocatedType().isSized()) {
                DerefBytes = $ulong2uint(DL.getTypeStoreSize(AI.getAllocatedType()));
                CanBeNull.$set(false);
              }
            } else {
              /*const*/ GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(this);
              if ((GV != null)) {
                if (GV.getValueType().isSized() && !GV.hasExternalWeakLinkage()) {
                  // TODO: Don't outright reject hasExternalWeakLinkage but set the
                  // CanBeNull flag.
                  DerefBytes = $ulong2uint(DL.getTypeStoreSize(GV.getValueType()));
                  CanBeNull.$set(false);
                }
              }
            }
          }
        }
      }
    }
    return DerefBytes;
  }


  
  /// \brief Returns an alignment of the pointer value.
  ///
  /// Returns an alignment which is either specified explicitly, e.g. via
  /// align attribute of a function argument, or guaranteed by DataLayout.
  
  /// \brief Returns an alignment of the pointer value.
  ///
  /// Returns an alignment which is either specified explicitly, e.g. via
  /// align attribute of a function argument, or guaranteed by DataLayout.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getPointerAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 591,
   FQN="llvm::Value::getPointerAlignment", NM="_ZNK4llvm5Value19getPointerAlignmentERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm5Value19getPointerAlignmentERKNS_10DataLayoutE")
  //</editor-fold>
  public /*uint*/int getPointerAlignment(final /*const*/ DataLayout /*&*/ DL) /*const*/ {
    assert (getType().isPointerTy()) : "must be pointer";
    
    /*uint*/int Align = 0;
    {
      /*const*/ GlobalObject /*P*/ GO = dyn_cast_GlobalObject(this);
      if ((GO != null)) {
        Align = GO.getAlignment();
        if (Align == 0) {
          {
            /*const*/ GlobalVariable /*P*/ GVar = dyn_cast_GlobalVariable(GO);
            if ((GVar != null)) {
              Type /*P*/ ObjectType = GVar.getValueType();
              if (ObjectType.isSized()) {
                // If the object is defined in the current Module, we'll be giving
                // it the preferred alignment. Otherwise, we have to assume that it
                // may only have the minimum ABI alignment.
                if (GVar.isStrongDefinitionForLinker()) {
                  Align = DL.getPreferredAlignment(GVar);
                } else {
                  Align = DL.getABITypeAlignment(ObjectType);
                }
              }
            }
          }
        }
      } else {
        /*const*/ Argument /*P*/ A = dyn_cast_Argument(this);
        if ((A != null)) {
          Align = A.getParamAlignment();
          if (!(Align != 0) && A.hasStructRetAttr()) {
            // An sret parameter has at least the ABI alignment of the return type.
            Type /*P*/ EltTy = cast_PointerType(A.getType()).getElementType();
            if (EltTy.isSized()) {
              Align = DL.getABITypeAlignment(EltTy);
            }
          }
        } else {
          /*const*/ AllocaInst /*P*/ AI = dyn_cast_AllocaInst(this);
          if ((AI != null)) {
            Align = AI.getAlignment();
            if (Align == 0) {
              Type /*P*/ AllocatedType = AI.getAllocatedType();
              if (AllocatedType.isSized()) {
                Align = DL.getPrefTypeAlignment(AllocatedType);
              }
            }
          } else {
            ImmutableCallSite CS = new ImmutableCallSite(this);
            if (CS.$bool()) {
              Align = CS.getAttributes().getParamAlignment(AttributeSet.AttrIndex.ReturnIndex.getValue());
            } else {
              /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(this);
              if ((LI != null)) {
                {
                  MDNode /*P*/ MD = LI.getMetadata(LLVMContext.Unnamed_enum.MD_align.getValue());
                  if ((MD != null)) {
                    ConstantInt /*P*/ CI = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >extract$ValidPointer(ConstantInt.class, MD.getOperand(0));
                    Align = $ulong2uint(CI.getLimitedValue());
                  }
                }
              }
            }
          }
        }
      }
    }
    
    return Align;
  }


  
  /// \brief Translate PHI node to its predecessor from the given basic block.
  ///
  /// If this value is a PHI node with CurBB as its parent, return the value in
  /// the PHI node corresponding to PredBB.  If not, return ourself.  This is
  /// useful if you want to know the value something has in a predecessor
  /// block.
  
  /// \brief Translate PHI node to its predecessor from the given basic block.
  ///
  /// If this value is a PHI node with CurBB as its parent, return the value in
  /// the PHI node corresponding to PredBB.  If not, return ourself.  This is
  /// useful if you want to know the value something has in a predecessor
  /// block.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::DoPHITranslation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 638,
   FQN="llvm::Value::DoPHITranslation", NM="_ZN4llvm5Value16DoPHITranslationEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value16DoPHITranslationEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public Value /*P*/ DoPHITranslation(/*const*/ BasicBlock /*P*/ CurBB, 
                  /*const*/ BasicBlock /*P*/ PredBB) {
    PHINode /*P*/ PN = dyn_cast_PHINode(this);
    if ((PN != null) && PN.getParent() == CurBB) {
      return PN.getIncomingValueForBlock(PredBB);
    }
    return this;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::DoPHITranslation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 529,
   FQN="llvm::Value::DoPHITranslation", NM="_ZNK4llvm5Value16DoPHITranslationEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value16DoPHITranslationEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public /*const*/ Value /*P*/ DoPHITranslation$Const(/*const*/ BasicBlock /*P*/ CurBB, 
                        /*const*/ BasicBlock /*P*/ PredBB) /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(this)).DoPHITranslation(CurBB, PredBB);
  }

  
  /// \brief The maximum alignment for instructions.
  ///
  /// This is the greatest alignment value supported by load, store, and alloca
  /// instructions, and global values.
  public static /*const*//*uint*/int MaxAlignmentExponent = 29;
  public static /*const*//*uint*/int MaximumAlignment = 1/*U*/ << MaxAlignmentExponent;
  
  /// \brief Mutate the type of this Value to be of the specified type.
  ///
  /// Note that this is an extremely dangerous operation which can create
  /// completely invalid IR very easily.  It is strongly recommended that you
  /// recreate IR objects with the right types instead of mutating them in
  /// place.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::mutateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 547,
   FQN="llvm::Value::mutateType", NM="_ZN4llvm5Value10mutateTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value10mutateTypeEPNS_4TypeE")
  //</editor-fold>
  public void mutateType(Type /*P*/ Ty) {
    VTy = Ty;
  }

  
  /// \brief Sort the use-list.
  ///
  /// Sorts the Value's use-list by Cmp using a stable mergesort.  Cmp is
  /// expected to compare two \a Use references.
  /*template <class Compare> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::sortUseList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 629,
   FQN="llvm::Value::sortUseList", NM="Tpl__ZN4llvm5Value11sortUseListET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN4llvm5Value11sortUseListET_")
  //</editor-fold>
  public </*class*/ Compare> void sortUseList(Compare Cmp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Reverse the use-list.
  
  /// \brief Reverse the use-list.
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::reverseUseList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 648,
   FQN="llvm::Value::reverseUseList", NM="_ZN4llvm5Value14reverseUseListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm5Value14reverseUseListEv")
  //</editor-fold>
  public void reverseUseList() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /// \brief Merge two lists together.
  ///
  /// Merges \c L and \c R using \c Cmp.  To enable stable sorts, always pushes
  /// "equal" items from L before items from R.
  ///
  /// \return the first element in the list.
  ///
  /// \note Completely ignores \a Use::Prev (doesn't read, doesn't update).
  /*template <class Compare> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::mergeUseLists">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 570,
   FQN="llvm::Value::mergeUseLists", NM="Tpl__ZN4llvm5Value13mergeUseListsEPNS_3UseES2_T_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN4llvm5Value13mergeUseListsEPNS_3UseES2_T_")
  //</editor-fold>
  private static </*class*/ Compare> type$ptr<Use /*P*/> mergeUseLists(type$ptr<Use /*P*/> L, type$ptr<Use /*P*/> R, Compare Cmp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Tail-recursive helper for \a mergeUseLists().
  ///
  /// \param[out] Next the first element in the list.
  /*template <class Compare> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::mergeUseListsImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 601,
   FQN="llvm::Value::mergeUseListsImpl", NM="Tpl__ZN4llvm5Value17mergeUseListsImplEPNS_3UseES2_PS2_T_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN4llvm5Value17mergeUseListsImplEPNS_3UseES2_PS2_T_")
  //</editor-fold>
  private static </*class*/ Compare> void mergeUseListsImpl(type$ptr<Use /*P*/> L, type$ptr<Use /*P*/> R, type$ptr<Use /*P*/>/*P*/ Next, Compare Cmp) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Value::getSubclassDataFromValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 604,
   FQN="llvm::Value::getSubclassDataFromValue", NM="_ZNK4llvm5Value24getSubclassDataFromValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm5Value24getSubclassDataFromValueEv")
  //</editor-fold>
  protected /*ushort*/char getSubclassDataFromValue() /*const*/ {
    return SubclassData;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Value::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 605,
   FQN="llvm::Value::setValueSubclassData", NM="_ZN4llvm5Value20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm5Value20setValueSubclassDataEt")
  //</editor-fold>
  protected void setValueSubclassData(/*ushort*/char D) {
    SubclassData = D;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Value() { 
    /*for descendants deleted ctors + for sentinels */ 
    UseList = null;
  }

  private int $sizeof_Value() {
    return 3 * $sizeof_ptr(/*Object */) + 2 * $sizeof_UInt();
  }  
  
  public boolean $isSentinel() {
    return UseList == null;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if ($isSentinel()) {
      return "Sentinel " + this.getClass().getSimpleName();
    }
    return " Name=[" + (HasName ? getName().toJavaString() : "<no name>") // NOI18N
              + "], VTy=[" + VTy // NOI18N
              + "], EmptyUseList=" + (UseList == null || UseList.$deref() == null) // NOI18N
              + ", SubclassID=" + $uchar2uint(SubclassID) // NOI18N
              + ", HasValueHandle=" + HasValueHandle // NOI18N
              + ", SubclassOptionalData=" + $uchar2uint(SubclassOptionalData) // NOI18N
              + ", SubclassData=" + $ushort2uint(SubclassData) // NOI18N
              + ", NumUserOperands=" + NumUserOperands // NOI18N
              + ", IsUsedByMD=" + IsUsedByMD // NOI18N
              + ", HasHungOffUses=" + HasHungOffUses // NOI18N
              + ", HasDescriptor=" + HasDescriptor; // NOI18N
  }
}
