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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;


/// \brief LLVM Argument representation
///
/// This class represents an incoming formal argument to a Function. A formal
/// argument, since it is ``formal'', does not contain an actual value but
/// instead represents the type, argument number, and attributes of an argument
/// for a specific function. When used in the body of said function, the
/// argument of course represents the value of the actual argument that the
/// function was called with.
//<editor-fold defaultstate="collapsed" desc="llvm::Argument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 34,
 FQN="llvm::Argument", NM="_ZN4llvm8ArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8ArgumentE")
//</editor-fold>
public class Argument extends /*public*/ Value implements /*public*/ ilist_node<Argument>, IChild<Function>, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // Argument Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 44,
   FQN="llvm::Argument::anchor", NM="_ZN4llvm8Argument6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private Function /*P*/ Parent;
  
  /*friend  class SymbolTableListTraits<Argument>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 55,
   FQN="llvm::Argument::setParent", NM="_ZN4llvm8Argument9setParentEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument9setParentEPNS_8FunctionE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Function /*P*/ parent) {
    Parent = parent;
  }

/*public:*/
  /// \brief Constructor.
  ///
  /// If \p F is specified, the argument is inserted at the end of the argument
  /// list for \p F.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::Argument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 46,
   FQN="llvm::Argument::Argument", NM="_ZN4llvm8ArgumentC1EPNS_4TypeERKNS_5TwineEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8ArgumentC1EPNS_4TypeERKNS_5TwineEPNS_8FunctionE")
  //</editor-fold>
  public Argument(Type /*P*/ Ty) {
    this(Ty, new Twine(/*KEEP_STR*/$EMPTY), (Function /*P*/ )null);
  }
  public Argument(Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Ty, Name, (Function /*P*/ )null);
  }
  public Argument(Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name/*= ""*/, Function /*P*/ Par/*= null*/) {
    // : Value(Ty, Value::ArgumentVal), ilist_node<Argument>() 
    //START JInit
    super(Ty, Value.ValueTy.ArgumentVal.getValue());
    this.ilist_node$Flds = $ilist_node();
    //END JInit
    Parent = null;
    if ((Par != null)) {
      Par.getArgumentList().push_back(this);
    }
    setName(Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 48,
   FQN="llvm::Argument::getParent", NM="_ZNK4llvm8Argument9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument9getParentEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Function /*P*/ getParent$Const() /*const*/ {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 49,
   FQN="llvm::Argument::getParent", NM="_ZN4llvm8Argument9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument9getParentEv")
  //</editor-fold>
  public /*inline*/ Function /*P*/ getParent() {
    return Parent;
  }

  
  /// \brief Return the index of this formal argument in its containing
  /// function.
  ///
  /// For example in "void foo(int a, float b)" a is 0 and b is 1.
  
  /// getArgNo - Return the index of this formal argument in its containing
  /// function.  For example in "void foo(int a, float b)" a is 0 and b is 1.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getArgNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 61,
   FQN="llvm::Argument::getArgNo", NM="_ZNK4llvm8Argument8getArgNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument8getArgNoEv")
  //</editor-fold>
  public /*uint*/int getArgNo() /*const*/ {
    /*const*/ Function /*P*/ F = getParent$Const();
    assert ((F != null)) : "Argument is not in a function";
    
    ilist_iterator</*const*/ Argument> AI = F.arg_begin$Const();
    /*uint*/int ArgIdx = 0;
    for (; $AddrOf(AI.$star()) != this; AI.$preInc())  {
      ++ArgIdx;
    }
    
    return ArgIdx;
  }

  
  /// \brief Return true if this argument has the nonnull attribute on it in
  /// its containing function. Also returns true if at least one byte is known
  /// to be dereferenceable and the pointer is in addrspace(0).
  
  /// hasNonNullAttr - Return true if this argument has the nonnull attribute on
  /// it in its containing function. Also returns true if at least one byte is
  /// known to be dereferenceable and the pointer is in addrspace(0).
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasNonNullAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 76,
   FQN="llvm::Argument::hasNonNullAttr", NM="_ZNK4llvm8Argument14hasNonNullAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument14hasNonNullAttrEv")
  //</editor-fold>
  public boolean hasNonNullAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    if (getParent$Const().getAttributes().
        hasAttribute(getArgNo() + 1, Attribute.AttrKind.NonNull)) {
      return true;
    } else if ($greater_ulong_ullong(getDereferenceableBytes(), $int2ullong(0))
       && getType().getPointerAddressSpace() == 0) {
      return true;
    }
    return false;
  }

  
  /// \brief If this argument has the dereferenceable attribute on it in its
  /// containing function, return the number of bytes known to be
  /// dereferenceable. Otherwise, zero is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 124,
   FQN="llvm::Argument::getDereferenceableBytes", NM="_ZNK4llvm8Argument23getDereferenceableBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument23getDereferenceableBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes() /*const*/ {
    assert (getType().isPointerTy()) : "Only pointers have dereferenceable bytes";
    return getParent$Const().getDereferenceableBytes(getArgNo() + 1);
  }

  
  /// \brief If this argument has the dereferenceable_or_null attribute on
  /// it in its containing function, return the number of bytes known to be
  /// dereferenceable. Otherwise, zero is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 130,
   FQN="llvm::Argument::getDereferenceableOrNullBytes", NM="_ZNK4llvm8Argument29getDereferenceableOrNullBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument29getDereferenceableOrNullBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes() /*const*/ {
    assert (getType().isPointerTy()) : "Only pointers have dereferenceable bytes";
    return getParent$Const().getDereferenceableOrNullBytes(getArgNo() + 1);
  }

  
  /// \brief Return true if this argument has the byval attribute on it in its
  /// containing function.
  
  /// hasByValAttr - Return true if this argument has the byval attribute on it
  /// in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasByValAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 89,
   FQN="llvm::Argument::hasByValAttr", NM="_ZNK4llvm8Argument12hasByValAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument12hasByValAttrEv")
  //</editor-fold>
  public boolean hasByValAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.ByVal);
  }

  
  /// \brief Return true if this argument has the swiftself attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasSwiftSelfAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 94,
   FQN="llvm::Argument::hasSwiftSelfAttr", NM="_ZNK4llvm8Argument16hasSwiftSelfAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument16hasSwiftSelfAttrEv")
  //</editor-fold>
  public boolean hasSwiftSelfAttr() /*const*/ {
    return getParent$Const().getAttributes().
        hasAttribute(getArgNo() + 1, Attribute.AttrKind.SwiftSelf);
  }

  
  /// \brief Return true if this argument has the swifterror attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasSwiftErrorAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 99,
   FQN="llvm::Argument::hasSwiftErrorAttr", NM="_ZNK4llvm8Argument17hasSwiftErrorAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument17hasSwiftErrorAttrEv")
  //</editor-fold>
  public boolean hasSwiftErrorAttr() /*const*/ {
    return getParent$Const().getAttributes().
        hasAttribute(getArgNo() + 1, Attribute.AttrKind.SwiftError);
  }

  
  /// \brief Return true if this argument has the byval attribute or inalloca
  /// attribute on it in its containing function.  These attributes both
  /// represent arguments being passed by value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasByValOrInAllocaAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 111,
   FQN="llvm::Argument::hasByValOrInAllocaAttr", NM="_ZNK4llvm8Argument22hasByValOrInAllocaAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument22hasByValOrInAllocaAttrEv")
  //</editor-fold>
  public boolean hasByValOrInAllocaAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    AttributeSet Attrs = getParent$Const().getAttributes();
    return Attrs.hasAttribute(getArgNo() + 1, Attribute.AttrKind.ByVal)
       || Attrs.hasAttribute(getArgNo() + 1, Attribute.AttrKind.InAlloca);
  }

  
  /// \brief If this is a byval or inalloca argument, return its alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::getParamAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 118,
   FQN="llvm::Argument::getParamAlignment", NM="_ZNK4llvm8Argument17getParamAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument17getParamAlignmentEv")
  //</editor-fold>
  public /*uint*/int getParamAlignment() /*const*/ {
    assert (getType().isPointerTy()) : "Only pointers have alignments";
    return getParent$Const().getParamAlignment(getArgNo() + 1);
  }

  
  /// \brief Return true if this argument has the nest attribute on it in its
  /// containing function.
  
  /// hasNestAttr - Return true if this argument has the nest attribute on
  /// it in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasNestAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 138,
   FQN="llvm::Argument::hasNestAttr", NM="_ZNK4llvm8Argument11hasNestAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument11hasNestAttrEv")
  //</editor-fold>
  public boolean hasNestAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.Nest);
  }

  
  /// \brief Return true if this argument has the noalias attribute on it in its
  /// containing function.
  
  /// hasNoAliasAttr - Return true if this argument has the noalias attribute on
  /// it in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasNoAliasAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 145,
   FQN="llvm::Argument::hasNoAliasAttr", NM="_ZNK4llvm8Argument14hasNoAliasAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument14hasNoAliasAttrEv")
  //</editor-fold>
  public boolean hasNoAliasAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.NoAlias);
  }

  
  /// \brief Return true if this argument has the nocapture attribute on it in
  /// its containing function.
  
  /// hasNoCaptureAttr - Return true if this argument has the nocapture attribute
  /// on it in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasNoCaptureAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 152,
   FQN="llvm::Argument::hasNoCaptureAttr", NM="_ZNK4llvm8Argument16hasNoCaptureAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument16hasNoCaptureAttrEv")
  //</editor-fold>
  public boolean hasNoCaptureAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.NoCapture);
  }

  
  /// \brief Return true if this argument has the sret attribute on it in its
  /// containing function.
  
  /// hasSRetAttr - Return true if this argument has the sret attribute on
  /// it in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasStructRetAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 159,
   FQN="llvm::Argument::hasStructRetAttr", NM="_ZNK4llvm8Argument16hasStructRetAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument16hasStructRetAttrEv")
  //</editor-fold>
  public boolean hasStructRetAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.StructRet);
  }

  
  /// \brief Return true if this argument has the returned attribute on it in
  /// its containing function.
  
  /// hasReturnedAttr - Return true if this argument has the returned attribute on
  /// it in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasReturnedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 166,
   FQN="llvm::Argument::hasReturnedAttr", NM="_ZNK4llvm8Argument15hasReturnedAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument15hasReturnedAttrEv")
  //</editor-fold>
  public boolean hasReturnedAttr() /*const*/ {
    return hasAttribute(Attribute.AttrKind.Returned);
  }

  
  /// \brief Return true if this argument has the readonly or readnone attribute
  /// on it in its containing function.
  
  /// Return true if this argument has the readonly or readnone attribute on it
  /// in its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 184,
   FQN="llvm::Argument::onlyReadsMemory", NM="_ZNK4llvm8Argument15onlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument15onlyReadsMemoryEv")
  //</editor-fold>
  public boolean onlyReadsMemory() /*const*/ {
    return getParent$Const().getAttributes().
        hasAttribute(getArgNo() + 1, Attribute.AttrKind.ReadOnly)
       || getParent$Const().getAttributes().
        hasAttribute(getArgNo() + 1, Attribute.AttrKind.ReadNone);
  }

  
  /// \brief Return true if this argument has the inalloca attribute on it in
  /// its containing function.
  
  /// \brief Return true if this argument has the inalloca attribute on it in
  /// its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasInAllocaAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 106,
   FQN="llvm::Argument::hasInAllocaAttr", NM="_ZNK4llvm8Argument15hasInAllocaAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument15hasInAllocaAttrEv")
  //</editor-fold>
  public boolean hasInAllocaAttr() /*const*/ {
    if (!getType().isPointerTy()) {
      return false;
    }
    return hasAttribute(Attribute.AttrKind.InAlloca);
  }

  
  /// \brief Return true if this argument has the zext attribute on it in its
  /// containing function.
  
  /// hasZExtAttr - Return true if this argument has the zext attribute on it in
  /// its containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasZExtAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 172,
   FQN="llvm::Argument::hasZExtAttr", NM="_ZNK4llvm8Argument11hasZExtAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument11hasZExtAttrEv")
  //</editor-fold>
  public boolean hasZExtAttr() /*const*/ {
    return hasAttribute(Attribute.AttrKind.ZExt);
  }

  
  /// \brief Return true if this argument has the sext attribute on it in its
  /// containing function.
  
  /// hasSExtAttr Return true if this argument has the sext attribute on it in its
  /// containing function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasSExtAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 178,
   FQN="llvm::Argument::hasSExtAttr", NM="_ZNK4llvm8Argument11hasSExtAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument11hasSExtAttrEv")
  //</editor-fold>
  public boolean hasSExtAttr() /*const*/ {
    return hasAttribute(Attribute.AttrKind.SExt);
  }

  
  /// \brief Add a Attribute to an argument.
  
  /// addAttr - Add attributes to an argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::addAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 192,
   FQN="llvm::Argument::addAttr", NM="_ZN4llvm8Argument7addAttrENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument7addAttrENS_12AttributeSetE")
  //</editor-fold>
  public void addAttr(AttributeSet AS) {
    AttrBuilder B = null;
    try {
      assert ($lesseq_uint(AS.getNumSlots(), 1)) : "Trying to add more than one attribute set to an argument!";
      B/*J*/= new AttrBuilder(new AttributeSet(AS), AS.getSlotIndex(0));
      getParent().addAttributes(getArgNo() + 1, 
          AttributeSet.get(Parent.getContext(), 
              getArgNo() + 1, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::addAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 129,
   FQN="llvm::Argument::addAttr", NM="_ZN4llvm8Argument7addAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument7addAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addAttr(Attribute.AttrKind Kind) {
    addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(getContext(), getArgNo() + 1, new ArrayRef<Attribute.AttrKind>(Kind)));
  }

  
  /// \brief Remove a Attribute from an argument.
  
  /// removeAttr - Remove attributes from an argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::removeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 202,
   FQN="llvm::Argument::removeAttr", NM="_ZN4llvm8Argument10removeAttrENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument10removeAttrENS_12AttributeSetE")
  //</editor-fold>
  public void removeAttr(AttributeSet AS) {
    AttrBuilder B = null;
    try {
      assert ($lesseq_uint(AS.getNumSlots(), 1)) : "Trying to remove more than one attribute set from an argument!";
      B/*J*/= new AttrBuilder(new AttributeSet(AS), AS.getSlotIndex(0));
      getParent().removeAttributes(getArgNo() + 1, 
          AttributeSet.get(Parent.getContext(), 
              getArgNo() + 1, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::removeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 136,
   FQN="llvm::Argument::removeAttr", NM="_ZN4llvm8Argument10removeAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument10removeAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeAttr(Attribute.AttrKind Kind) {
    removeAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(getContext(), getArgNo() + 1, new ArrayRef<Attribute.AttrKind>(Kind)));
  }

  
  /// \brief Checks if an argument has a given attribute.
  
  /// hasAttribute - Checks if an argument has a given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 212,
   FQN="llvm::Argument::hasAttribute", NM="_ZNK4llvm8Argument12hasAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Argument12hasAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(Attribute.AttrKind Kind) /*const*/ {
    return getParent$Const().hasAttribute(getArgNo() + 1, Kind);
  }

  
  /// \brief Method for support type inquiry through isa, cast, and
  /// dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 145,
   FQN="llvm::Argument::classof", NM="_ZN4llvm8Argument7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Argument7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ArgumentVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Argument::~Argument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Argument.h", line = 34,
   FQN="llvm::Argument::~Argument", NM="_ZN4llvm8ArgumentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8ArgumentD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    ilist_node.super.$destroy$ilist_node();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public Argument() {
    this.ilist_node$Flds = $ilist_node();
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "Parent=" + Parent // NOI18N
              + super.toString(); // NOI18N
  }
}
