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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// A specialization of Address that requires the address to be an
/// LLVM Constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 75,
 FQN="clang::CodeGen::ConstantAddress", NM="_ZN5clang7CodeGen15ConstantAddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddressE")
//</editor-fold>
public class ConstantAddress extends /*public*/ Address {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::ConstantAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 77,
   FQN="clang::CodeGen::ConstantAddress::ConstantAddress", NM="_ZN5clang7CodeGen15ConstantAddressC1EPN4llvm8ConstantENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddressC1EPN4llvm8ConstantENS_9CharUnitsE")
  //</editor-fold>
  public ConstantAddress(Constant /*P*/ pointer, CharUnits alignment) {
    // : Address(pointer, alignment) 
    //START JInit
    super(pointer, new CharUnits(alignment));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::invalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 80,
   FQN="clang::CodeGen::ConstantAddress::invalid", NM="_ZN5clang7CodeGen15ConstantAddress7invalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddress7invalidEv")
  //</editor-fold>
  public static ConstantAddress invalid() {
    return new ConstantAddress((Constant /*P*/ )null, new CharUnits());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 84,
   FQN="clang::CodeGen::ConstantAddress::getPointer", NM="_ZNK5clang7CodeGen15ConstantAddress10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen15ConstantAddress10getPointerEv")
  //</editor-fold>
  public Constant /*P*/ getPointer() /*const*/ {
    return cast_Constant(super.getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::getBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 88,
   FQN="clang::CodeGen::ConstantAddress::getBitCast", NM="_ZNK5clang7CodeGen15ConstantAddress10getBitCastEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen15ConstantAddress10getBitCastEPN4llvm4TypeE")
  //</editor-fold>
  public ConstantAddress getBitCast(org.llvm.ir.Type /*P*/ ty) /*const*/ {
    return new ConstantAddress(ConstantExpr.getBitCast(getPointer(), ty), 
        getAlignment());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::getElementBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 93,
   FQN="clang::CodeGen::ConstantAddress::getElementBitCast", NM="_ZNK5clang7CodeGen15ConstantAddress17getElementBitCastEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen15ConstantAddress17getElementBitCastEPN4llvm4TypeE")
  //</editor-fold>
  public ConstantAddress getElementBitCast(org.llvm.ir.Type /*P*/ ty) /*const*/ {
    return getBitCast(ty.getPointerTo(getAddressSpace()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::isaImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 97,
   FQN="clang::CodeGen::ConstantAddress::isaImpl", NM="_ZN5clang7CodeGen15ConstantAddress7isaImplENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddress7isaImplENS0_7AddressE")
  //</editor-fold>
  public static boolean isaImpl(Address addr) {
    return isa_Constant(addr.getPointer());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::castImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 100,
   FQN="clang::CodeGen::ConstantAddress::castImpl", NM="_ZN5clang7CodeGen15ConstantAddress8castImplENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddress8castImplENS0_7AddressE")
  //</editor-fold>
  public static ConstantAddress castImpl(Address addr) {
    return new ConstantAddress(cast_Constant(addr.getPointer()), 
        addr.getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::ConstantAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 75,
   FQN="clang::CodeGen::ConstantAddress::ConstantAddress", NM="_ZN5clang7CodeGen15ConstantAddressC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddressC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ConstantAddress(final /*const*/ ConstantAddress /*&*/ $Prm0) {
    // : Address() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ConstantAddress::ConstantAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/Address.h", line = 75,
   FQN="clang::CodeGen::ConstantAddress::ConstantAddress", NM="_ZN5clang7CodeGen15ConstantAddressC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15ConstantAddressC1EOS1_")
  //</editor-fold>
  public /*inline*/ ConstantAddress(JD$Move _dparam, final ConstantAddress /*&&*/$Prm0) {
    // : Address(static_cast<ConstantAddress &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public ConstantAddress clone() {
    return new ConstantAddress(this);
  }
  
  @Override public ConstantAddress move() {
    return new ConstantAddress(JD$Move.INSTANCE, this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
