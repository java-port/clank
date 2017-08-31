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
import static org.llvm.adt.ADTAliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// ReturnValueSlot - Contains the address where the return value of a 
/// function can be stored, and whether the address is volatile or not.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 151,
 FQN="clang::CodeGen::ReturnValueSlot", NM="_ZN5clang7CodeGen15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotE")
//</editor-fold>
public class ReturnValueSlot {
  private PointerUInt2Pair<Value /*P*/ > Value;
  private CharUnits Alignment;
  
  // Return value slot flags
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::Flags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 156,
   FQN="clang::CodeGen::ReturnValueSlot::Flags", NM="_ZN5clang7CodeGen15ReturnValueSlot5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlot5FlagsE")
  //</editor-fold>
  private static final class/*enum*/ Flags {
    public static final /*uint*/int IS_VOLATILE = 0x1;
    public static final /*uint*/int IS_UNUSED = 0x2;
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::ReturnValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 162,
   FQN="clang::CodeGen::ReturnValueSlot::ReturnValueSlot", NM="_ZN5clang7CodeGen15ReturnValueSlotC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotC1Ev")
  //</editor-fold>
  public ReturnValueSlot() {
    // : Value(), Alignment() 
    //START JInit
    this.Value = new PointerUInt2Pair<Value /*P*/ >();
    this.Alignment = new CharUnits();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::ReturnValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 163,
   FQN="clang::CodeGen::ReturnValueSlot::ReturnValueSlot", NM="_ZN5clang7CodeGen15ReturnValueSlotC1ENS0_7AddressEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotC1ENS0_7AddressEbb")
  //</editor-fold>
  public ReturnValueSlot(Address Addr, boolean IsVolatile) {
    this(Addr, IsVolatile, false);
  }
  public ReturnValueSlot(Address Addr, boolean IsVolatile, boolean IsUnused/*= false*/) {
    // : Value(Addr.isValid() ? Addr.getPointer() : null, (IsVolatile ? IS_VOLATILE : 0) | (IsUnused ? IS_UNUSED : 0)), Alignment(Addr.isValid() ? Addr.getAlignment() : CharUnits::Zero()) 
    //START JInit
    this.Value = new PointerUInt2Pair<Value /*P*/ >(Addr.isValid() ? Addr.getPointer() : (Value /*P*/ )null, 
        (IsVolatile ? Flags.IS_VOLATILE : 0) | (IsUnused ? Flags.IS_UNUSED : 0));
    this.Alignment = Addr.isValid() ? Addr.getAlignment() : CharUnits.Zero();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 168,
   FQN="clang::CodeGen::ReturnValueSlot::isNull", NM="_ZNK5clang7CodeGen15ReturnValueSlot6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen15ReturnValueSlot6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return !getValue().isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 170,
   FQN="clang::CodeGen::ReturnValueSlot::isVolatile", NM="_ZNK5clang7CodeGen15ReturnValueSlot10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen15ReturnValueSlot10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((Value.getInt() & Flags.IS_VOLATILE) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 171,
   FQN="clang::CodeGen::ReturnValueSlot::getValue", NM="_ZNK5clang7CodeGen15ReturnValueSlot8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen15ReturnValueSlot8getValueEv")
  //</editor-fold>
  public Address getValue() /*const*/ {
    return new Address(Value.getPointer(), new CharUnits(Alignment));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::isUnused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 172,
   FQN="clang::CodeGen::ReturnValueSlot::isUnused", NM="_ZNK5clang7CodeGen15ReturnValueSlot8isUnusedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZNK5clang7CodeGen15ReturnValueSlot8isUnusedEv")
  //</editor-fold>
  public boolean isUnused() /*const*/ {
    return ((Value.getInt() & Flags.IS_UNUSED) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::ReturnValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 151,
   FQN="clang::CodeGen::ReturnValueSlot::ReturnValueSlot", NM="_ZN5clang7CodeGen15ReturnValueSlotC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ReturnValueSlot(final /*const*/ ReturnValueSlot /*&*/ $Prm0) {
    // : Value(.Value), Alignment(.Alignment) 
    //START JInit
    this.Value = new PointerUInt2Pair<Value /*P*/ >($Prm0.Value);
    this.Alignment = new CharUnits($Prm0.Alignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::ReturnValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 151,
   FQN="clang::CodeGen::ReturnValueSlot::ReturnValueSlot", NM="_ZN5clang7CodeGen15ReturnValueSlotC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotC1EOS1_")
  //</editor-fold>
  public /*inline*/ ReturnValueSlot(JD$Move _dparam, final ReturnValueSlot /*&&*/$Prm0) {
    // : Value(static_cast<ReturnValueSlot &&>().Value), Alignment(static_cast<ReturnValueSlot &&>().Alignment) 
    //START JInit
    this.Value = new PointerUInt2Pair<Value /*P*/ >(JD$Move.INSTANCE, $Prm0.Value);
    this.Alignment = new CharUnits(JD$Move.INSTANCE, $Prm0.Alignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ReturnValueSlot::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 151,
   FQN="clang::CodeGen::ReturnValueSlot::operator=", NM="_ZN5clang7CodeGen15ReturnValueSlotaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15ReturnValueSlotaSEOS1_")
  //</editor-fold>
  public /*inline*/ ReturnValueSlot /*&*/ $assignMove(final ReturnValueSlot /*&&*/$Prm0) {
    this.Value.$assignMove($Prm0.Value);
    this.Alignment.$assignMove($Prm0.Alignment);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Alignment=" + Alignment; // NOI18N
  }
}
