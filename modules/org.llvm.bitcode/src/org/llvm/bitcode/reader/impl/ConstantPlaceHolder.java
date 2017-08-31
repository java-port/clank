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

package org.llvm.bitcode.reader.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.*;

/// \brief A class for maintaining the slot number definition
/// as a placeholder for the actual definition for forward constants defs.
//<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 911,
 FQN="llvm::(anonymous namespace)::ConstantPlaceHolder", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderE")
//</editor-fold>
public class ConstantPlaceHolder extends /*public*/ ConstantExpr implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 912,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::operator=", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderaSERKS1_")
  //</editor-fold>
  private void $assign(/*const*/ ConstantPlaceHolder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  // allocate space for exactly one operand
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::operator new">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 916,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::operator new", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHoldernwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHoldernwEj")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::ConstantPlaceHolder">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 917,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::ConstantPlaceHolder", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderC1EPNS_4TypeERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderC1EPNS_4TypeERNS_11LLVMContextE")
  //</editor-fold>
  public /*explicit*/ ConstantPlaceHolder(Type /*P*/ Ty, LLVMContext /*&*/ Context) {
    // : ConstantExpr(Ty, Instruction::UserOp1, &Op<0>(), 1) 
    super(Ty, Instruction.OtherOps.UserOp1, /*AddrOf*/null/*JAVA Op<0>()*/, 1);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Methods to support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 923,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::classof", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::getOperand">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::getOperand", NM="_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder10getOperandEj")
  //</editor-fold>
  public Constant /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::setOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::setOperand", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::op_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::op_begin", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::op_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::op_begin", NM="_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::op_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::op_end", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::op_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::op_end", NM="_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::Op">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::Op", NM="Tpl__ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=Tpl__ZN4llvm12_GLOBAL__N_119ConstantPlaceHolder2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::Op">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::Op", NM="Tpl__ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=Tpl__ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 938,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::getNumOperands", NM="_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm12_GLOBAL__N_119ConstantPlaceHolder14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::ConstantPlaceHolder::~ConstantPlaceHolder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 911,
   FQN="llvm::(anonymous namespace)::ConstantPlaceHolder::~ConstantPlaceHolder", NM="_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm12_GLOBAL__N_119ConstantPlaceHolderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
