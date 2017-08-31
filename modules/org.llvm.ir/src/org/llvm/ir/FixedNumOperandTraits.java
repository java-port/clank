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
import org.clank.support.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IUser;


//===----------------------------------------------------------------------===//
//                          FixedNumOperand Trait Class
//===----------------------------------------------------------------------===//

/// FixedNumOperandTraits - determine the allocation regime of the Use array
/// when it is a prefix to the User object, and the number of Use objects is
/// known at compile time.
/*template <typename SubClass, unsigned int ARITY> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FixedNumOperandTraits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*static to instance methods*/,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 30,
 FQN="llvm::FixedNumOperandTraits", NM="_ZN4llvm21FixedNumOperandTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21FixedNumOperandTraitsE")
//</editor-fold>
public interface/*struct*/ FixedNumOperandTraits</*typename*/ SubClass extends IUser/*, uintint ARITY*/> extends OperandTraits<SubClass>  {
//  //<editor-fold defaultstate="collapsed" desc="llvm::FixedNumOperandTraits::op_begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 32,
//   FQN="llvm::FixedNumOperandTraits::op_begin", NM="_ZN4llvm21FixedNumOperandTraits8op_beginEPT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21FixedNumOperandTraits8op_beginEPT_")
//  //</editor-fold>
//  public /*interface*/ default type$ptr<Use /*P*/> op_begin(SubClass /*P*/ U) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::FixedNumOperandTraits::op_end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 35,
//   FQN="llvm::FixedNumOperandTraits::op_end", NM="_ZN4llvm21FixedNumOperandTraits6op_endEPT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21FixedNumOperandTraits6op_endEPT_")
//  //</editor-fold>
//  public /*interface*/ default type$ptr<Use /*P*/> op_end(SubClass /*P*/ U) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::FixedNumOperandTraits::operands">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
//   source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 38,
//   FQN="llvm::FixedNumOperandTraits::operands", NM="_ZN4llvm21FixedNumOperandTraits8operandsEPKNS_4UserE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21FixedNumOperandTraits8operandsEPKNS_4UserE")
//  //</editor-fold>
//  public /*interface*/ default /*uint*/int operands(/*const*/ User /*P*/ $Prm0) {
//    throw new UnsupportedOperationException("" + this.getClass() + " must override and specify number of operands ");
//  }  
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 32)
  public /*interface*/ static <SubClass extends User> type$ptr<Use /*P*/> op_begin(int Count, IUser /*P*/ U) {
    return (type$ptr<Use>) U.$This$Ptr().$sub(Count);
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 35)
  public /*interface*/ static <SubClass extends User> type$ptr<Use /*P*/> op_end(int Count, IUser /*P*/ U) {
    // JAVA: the returned pointer should never be dereferenced: this will lead to class cast exception
    return (type$ptr<Use>) U.$This$Ptr();
  }
}
