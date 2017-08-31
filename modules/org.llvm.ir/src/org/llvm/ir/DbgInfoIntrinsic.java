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
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;


/// This is the common base class for debug info intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::DbgInfoIntrinsic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 59,
 FQN="llvm::DbgInfoIntrinsic", NM="_ZN4llvm16DbgInfoIntrinsicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm16DbgInfoIntrinsicE")
//</editor-fold>
public class DbgInfoIntrinsic extends /*public*/ IntrinsicInst implements Destructors.ClassWithDestructor {
/*public:*/
  /// Get the location corresponding to the variable referenced by the debug
  /// info intrinsic.  Depending on the intrinsic, this could be the
  /// variable's value or its address.

  //===----------------------------------------------------------------------===//
  /// DbgInfoIntrinsic - This is the common base class for debug info intrinsics
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DbgInfoIntrinsic::getVariableLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp", line = 35,
   FQN="llvm::DbgInfoIntrinsic::getVariableLocation", NM="_ZNK4llvm16DbgInfoIntrinsic19getVariableLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm16DbgInfoIntrinsic19getVariableLocationEb")
  //</editor-fold>
  public Value /*P*/ getVariableLocation() /*const*/ {
    return getVariableLocation(true);
  }
  public Value /*P*/ getVariableLocation(boolean AllowNullOp/*= true*/) /*const*/ {
    Value /*P*/ Op = getArgOperand(0);
    if (AllowNullOp && !(Op != null)) {
      return null;
    }

    Metadata /*P*/ MD = cast_MetadataAsValue(Op).getMetadata();
    {
      ValueAsMetadata /*P*/ V = dyn_cast_ValueAsMetadata(MD);
      if ((V != null)) {
        return V.getValue();
      }
    }

    // When the value goes to null, it gets replaced by an empty MDNode.
    assert (!(cast_MDNode(MD).getNumOperands() != 0)) : "Expected an empty MDNode";
    return null;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::DbgInfoIntrinsic::classof">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 67,
   FQN="llvm::DbgInfoIntrinsic::classof", NM="_ZN4llvm16DbgInfoIntrinsic7classofEPKNS_13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm16DbgInfoIntrinsic7classofEPKNS_13IntrinsicInstE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ IntrinsicInst /*P*/ I) {
    switch (I.getIntrinsicID()) {
     case ID.dbg_declare:
     case ID.dbg_value:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgInfoIntrinsic::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 75,
   FQN="llvm::DbgInfoIntrinsic::classof", NM="_ZN4llvm16DbgInfoIntrinsic7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm16DbgInfoIntrinsic7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_IntrinsicInst(V) && DbgInfoIntrinsic.classof(cast_IntrinsicInst(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgInfoIntrinsic::~DbgInfoIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 59,
   FQN="llvm::DbgInfoIntrinsic::~DbgInfoIntrinsic", NM="_ZN4llvm16DbgInfoIntrinsicD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm16DbgInfoIntrinsicD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
