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

package org.clang.codegen.CodeGen.impl;

import org.clang.ast.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native.NativePOD;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;


/// An aligned address.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 25,
 FQN="clang::CodeGen::Address", NM="_ZN5clang7CodeGen7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressE")
//</editor-fold>
public class Address implements NativePOD<Address>, NativeMoveable<Address> {
  private Value /*P*/ Pointer;
  private CharUnits Alignment;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::Address">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 29,
   FQN="clang::CodeGen::Address::Address", NM="_ZN5clang7CodeGen7AddressC1EPN4llvm5ValueENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressC1EPN4llvm5ValueENS_9CharUnitsE")
  //</editor-fold>
  public Address(Value /*P*/ pointer, CharUnits alignment) {
    // : Pointer(pointer), Alignment(alignment) 
    //START JInit
    this.Pointer = pointer;
    this.Alignment = new CharUnits(alignment);
    //END JInit
    assert ((!alignment.isZero() || pointer == null)) : "creating valid address with invalid alignment";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::invalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 35,
   FQN="clang::CodeGen::Address::invalid", NM="_ZN5clang7CodeGen7Address7invalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7Address7invalidEv")
  //</editor-fold>
  public static Address invalid() {
    return new Address((Value /*P*/ )null, new CharUnits());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 36,
   FQN="clang::CodeGen::Address::isValid", NM="_ZNK5clang7CodeGen7Address7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Pointer != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 38,
   FQN="clang::CodeGen::Address::getPointer", NM="_ZNK5clang7CodeGen7Address10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address10getPointerEv")
  //</editor-fold>
  public Value /*P*/ getPointer() /*const*/ {
    assert (isValid());
    return Pointer;
  }

  
  /// Return the type of the pointer value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 44,
   FQN="clang::CodeGen::Address::getType", NM="_ZNK5clang7CodeGen7Address7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address7getTypeEv")
  //</editor-fold>
  public PointerType /*P*/ getType() /*const*/ {
    return IrRTTI.cast_PointerType(getPointer().getType());
  }

  
  /// Return the type of the values stored in this address.
  ///
  /// When IR pointer types lose their element type, we should simply
  /// store it in Address instead for the convenience of writing code.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 52,
   FQN="clang::CodeGen::Address::getElementType", NM="_ZNK5clang7CodeGen7Address14getElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address14getElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getElementType() /*const*/ {
    return getType().getElementType();
  }

  
  /// Return the address space that this address resides in.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 57,
   FQN="clang::CodeGen::Address::getAddressSpace", NM="_ZNK5clang7CodeGen7Address15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address15getAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getAddressSpace() /*const*/ {
    return getType().getAddressSpace();
  }

  
  /// Return the IR name of the pointer value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 62,
   FQN="clang::CodeGen::Address::getName", NM="_ZNK5clang7CodeGen7Address7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getPointer().getName();
  }

  
  /// Return the alignment of this pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 67,
   FQN="clang::CodeGen::Address::getAlignment", NM="_ZNK5clang7CodeGen7Address12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen7Address12getAlignmentEv")
  //</editor-fold>
  public CharUnits getAlignment() /*const*/ {
    assert (isValid());
    return new CharUnits(Alignment);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::Address">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 25,
   FQN="clang::CodeGen::Address::Address", NM="_ZN5clang7CodeGen7AddressC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Address(final /*const*/ Address /*&*/ $Prm0) {
    // : Pointer(.Pointer), Alignment(.Alignment) 
    //START JInit
    this.Pointer = $Prm0.Pointer;
    this.Alignment = new CharUnits($Prm0.Alignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::Address">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 25,
   FQN="clang::CodeGen::Address::Address", NM="_ZN5clang7CodeGen7AddressC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressC1EOS1_")
  //</editor-fold>
  public /*inline*/ Address(JD$Move _dparam, final Address /*&&*/$Prm0) {
    // : Pointer(static_cast<Address &&>().Pointer), Alignment(static_cast<Address &&>().Alignment) 
    //START JInit
    this.Pointer = $Prm0.Pointer;
    this.Alignment = new CharUnits(JD$Move.INSTANCE, $Prm0.Alignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 25,
   FQN="clang::CodeGen::Address::operator=", NM="_ZN5clang7CodeGen7AddressaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressaSERKS1_")
  //</editor-fold>
  public /*inline*/ Address /*&*/ $assign(final /*const*/ Address /*&*/ $Prm0) {
    this.Pointer = $Prm0.Pointer;
    this.Alignment.$assign($Prm0.Alignment);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::Address::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 25,
   FQN="clang::CodeGen::Address::operator=", NM="_ZN5clang7CodeGen7AddressaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen7AddressaSEOS1_")
  //</editor-fold>
  public /*inline*/ Address /*&*/ $assignMove(final Address /*&&*/$Prm0) {
    this.Pointer = $Prm0.Pointer;
    this.Alignment.$assignMove($Prm0.Alignment);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public Address() { 
    this.Alignment = new CharUnits();
  }

  @Override public Address clone() {
    return new Address(this);
  }
  
  @Override public Address move() {
    return new Address(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Pointer=" + Pointer // NOI18N
              + ", Alignment=" + Alignment; // NOI18N
  }
}
