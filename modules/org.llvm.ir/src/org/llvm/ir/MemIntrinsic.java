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


/// This is the common base class for memset/memcpy/memmove.
//<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 141,
 FQN="llvm::MemIntrinsic", NM="_ZN4llvm12MemIntrinsicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsicE")
//</editor-fold>
public class MemIntrinsic extends /*public*/ IntrinsicInst implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getRawDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 143,
   FQN="llvm::MemIntrinsic::getRawDest", NM="_ZNK4llvm12MemIntrinsic10getRawDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic10getRawDestEv")
  //</editor-fold>
  public Value /*P*/ getRawDest() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(getArgOperand(0)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getRawDestUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 144,
   FQN="llvm::MemIntrinsic::getRawDestUse", NM="_ZNK4llvm12MemIntrinsic13getRawDestUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic13getRawDestUseEv")
  //</editor-fold>
  public /*const*/ Use /*&*/ getRawDestUse$Const() /*const*/ {
    return getArgOperandUse$Const(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getRawDestUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 145,
   FQN="llvm::MemIntrinsic::getRawDestUse", NM="_ZN4llvm12MemIntrinsic13getRawDestUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic13getRawDestUseEv")
  //</editor-fold>
  public Use /*&*/ getRawDestUse() {
    return getArgOperandUse(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 147,
   FQN="llvm::MemIntrinsic::getLength", NM="_ZNK4llvm12MemIntrinsic9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic9getLengthEv")
  //</editor-fold>
  public Value /*P*/ getLength() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )(getArgOperand(2)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getLengthUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 148,
   FQN="llvm::MemIntrinsic::getLengthUse", NM="_ZNK4llvm12MemIntrinsic12getLengthUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic12getLengthUseEv")
  //</editor-fold>
  public /*const*/ Use /*&*/ getLengthUse$Const() /*const*/ {
    return getArgOperandUse$Const(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getLengthUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 149,
   FQN="llvm::MemIntrinsic::getLengthUse", NM="_ZN4llvm12MemIntrinsic12getLengthUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic12getLengthUseEv")
  //</editor-fold>
  public Use /*&*/ getLengthUse() {
    return getArgOperandUse(2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getAlignmentCst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 151,
   FQN="llvm::MemIntrinsic::getAlignmentCst", NM="_ZNK4llvm12MemIntrinsic15getAlignmentCstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic15getAlignmentCstEv")
  //</editor-fold>
  public ConstantInt /*P*/ getAlignmentCst() /*const*/ {
    return cast_ConstantInt(((/*const_cast*/Value /*P*/ )(getArgOperand(3))));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 155,
   FQN="llvm::MemIntrinsic::getAlignment", NM="_ZNK4llvm12MemIntrinsic12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return $ulong2uint(getAlignmentCst().getZExtValue());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getVolatileCst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 159,
   FQN="llvm::MemIntrinsic::getVolatileCst", NM="_ZNK4llvm12MemIntrinsic14getVolatileCstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic14getVolatileCstEv")
  //</editor-fold>
  public ConstantInt /*P*/ getVolatileCst() /*const*/ {
    return cast_ConstantInt(((/*const_cast*/Value /*P*/ )(getArgOperand(4))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 162,
   FQN="llvm::MemIntrinsic::isVolatile", NM="_ZNK4llvm12MemIntrinsic10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return !getVolatileCst().isZero();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getDestAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 166,
   FQN="llvm::MemIntrinsic::getDestAddressSpace", NM="_ZNK4llvm12MemIntrinsic19getDestAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic19getDestAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getDestAddressSpace() /*const*/ {
    return cast_PointerType(getRawDest().getType()).getAddressSpace();
  }


  /// This is just like getRawDest, but it strips off any cast
  /// instructions that feed it, giving the original input.  The returned
  /// value is guaranteed to be a pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 173,
   FQN="llvm::MemIntrinsic::getDest", NM="_ZNK4llvm12MemIntrinsic7getDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic7getDestEv")
  //</editor-fold>
  public Value /*P*/ getDest() /*const*/ {
    return getRawDest().stripPointerCasts();
  }


  /// Set the specified arguments of the instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::setDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 176,
   FQN="llvm::MemIntrinsic::setDest", NM="_ZN4llvm12MemIntrinsic7setDestEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic7setDestEPNS_5ValueE")
  //</editor-fold>
  public void setDest(Value /*P*/ Ptr) {
    assert (getRawDest().getType() == Ptr.getType()) : "setDest called with pointer of wrong type!";
    setArgOperand(0, Ptr);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::setLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 182,
   FQN="llvm::MemIntrinsic::setLength", NM="_ZN4llvm12MemIntrinsic9setLengthEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic9setLengthEPNS_5ValueE")
  //</editor-fold>
  public void setLength(Value /*P*/ L) {
    assert (getLength().getType() == L.getType()) : "setLength called with value of wrong type!";
    setArgOperand(2, L);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 188,
   FQN="llvm::MemIntrinsic::setAlignment", NM="_ZN4llvm12MemIntrinsic12setAlignmentEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic12setAlignmentEPNS_8ConstantE")
  //</editor-fold>
  public void setAlignment(Constant /*P*/ A) {
    setArgOperand(3, A);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 192,
   FQN="llvm::MemIntrinsic::setVolatile", NM="_ZN4llvm12MemIntrinsic11setVolatileEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic11setVolatileEPNS_8ConstantE")
  //</editor-fold>
  public void setVolatile(Constant /*P*/ V) {
    setArgOperand(4, V);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::getAlignmentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 196,
   FQN="llvm::MemIntrinsic::getAlignmentType", NM="_ZNK4llvm12MemIntrinsic16getAlignmentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm12MemIntrinsic16getAlignmentTypeEv")
  //</editor-fold>
  public Type /*P*/ getAlignmentType() /*const*/ {
    return getArgOperand(3).getType();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::classof">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 201,
   FQN="llvm::MemIntrinsic::classof", NM="_ZN4llvm12MemIntrinsic7classofEPKNS_13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic7classofEPKNS_13IntrinsicInstE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ IntrinsicInst /*P*/ I) {
    switch (I.getIntrinsicID()) {
     case ID.memcpy:
     case ID.memmove:
     case ID.memset:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 210,
   FQN="llvm::MemIntrinsic::classof", NM="_ZN4llvm12MemIntrinsic7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsic7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_IntrinsicInst(V) && MemIntrinsic.classof(cast_IntrinsicInst(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemIntrinsic::~MemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 141,
   FQN="llvm::MemIntrinsic::~MemIntrinsic", NM="_ZN4llvm12MemIntrinsicD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm12MemIntrinsicD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
