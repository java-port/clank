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
import org.llvm.ir.java.IVariableAndExprOwner;


/// This represents the llvm.dbg.declare instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 81,
 FQN="llvm::DbgDeclareInst", NM="_ZN4llvm14DbgDeclareInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm14DbgDeclareInstE")
//</editor-fold>
public class DbgDeclareInst extends /*public*/ DbgInfoIntrinsic implements IVariableAndExprOwner, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::getAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 83,
   FQN="llvm::DbgDeclareInst::getAddress", NM="_ZNK4llvm14DbgDeclareInst10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm14DbgDeclareInst10getAddressEv")
  //</editor-fold>
  public Value /*P*/ getAddress() /*const*/ {
    return getVariableLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::getVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 84,
   FQN="llvm::DbgDeclareInst::getVariable", NM="_ZNK4llvm14DbgDeclareInst11getVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm14DbgDeclareInst11getVariableEv")
  //</editor-fold>
  public DILocalVariable /*P*/ getVariable() /*const*/ {
    return cast_DILocalVariable(getRawVariable());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::getExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 87,
   FQN="llvm::DbgDeclareInst::getExpression", NM="_ZNK4llvm14DbgDeclareInst13getExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm14DbgDeclareInst13getExpressionEv")
  //</editor-fold>
  public DIExpression /*P*/ getExpression() /*const*/ {
    return cast_DIExpression(getRawExpression());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::getRawVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 91,
   FQN="llvm::DbgDeclareInst::getRawVariable", NM="_ZNK4llvm14DbgDeclareInst14getRawVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm14DbgDeclareInst14getRawVariableEv")
  //</editor-fold>
  public Metadata /*P*/ getRawVariable() /*const*/ {
    return cast_MetadataAsValue(getArgOperand(1)).getMetadata();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::getRawExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 94,
   FQN="llvm::DbgDeclareInst::getRawExpression", NM="_ZNK4llvm14DbgDeclareInst16getRawExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm14DbgDeclareInst16getRawExpressionEv")
  //</editor-fold>
  public Metadata /*P*/ getRawExpression() /*const*/ {
    return cast_MetadataAsValue(getArgOperand(2)).getMetadata();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::classof">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 99,
   FQN="llvm::DbgDeclareInst::classof", NM="_ZN4llvm14DbgDeclareInst7classofEPKNS_13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm14DbgDeclareInst7classofEPKNS_13IntrinsicInstE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ IntrinsicInst /*P*/ I) {
    return I.getIntrinsicID() == ID.dbg_declare;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 102,
   FQN="llvm::DbgDeclareInst::classof", NM="_ZN4llvm14DbgDeclareInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm14DbgDeclareInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_IntrinsicInst(V) && DbgDeclareInst.classof(cast_IntrinsicInst(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DbgDeclareInst::~DbgDeclareInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 81,
   FQN="llvm::DbgDeclareInst::~DbgDeclareInst", NM="_ZN4llvm14DbgDeclareInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm14DbgDeclareInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
