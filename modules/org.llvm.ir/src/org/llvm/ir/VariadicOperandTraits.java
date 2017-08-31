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
//                          VariadicOperand Trait Class
//===----------------------------------------------------------------------===//

/// VariadicOperandTraits - determine the allocation regime of the Use array
/// when it is a prefix to the User object, and the number of Use objects is
/// only known at allocation time.
/*template <typename SubClass, unsigned int MINARITY = 0> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::VariadicOperandTraits">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 65,
 FQN="llvm::VariadicOperandTraits", NM="_ZN4llvm21VariadicOperandTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21VariadicOperandTraitsE")
//</editor-fold>
public class/*struct*/ VariadicOperandTraits</*typename*/ SubClass extends User> implements OperandTraits<SubClass> {//, /*uint*/int MINARITY/* = 0*/>  {

  //<editor-fold defaultstate="collapsed" desc="llvm::VariadicOperandTraits::op_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
          source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 67,
          FQN = "llvm::VariadicOperandTraits::op_begin", NM = "_ZN4llvm21VariadicOperandTraits8op_beginEPT_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21VariadicOperandTraits8op_beginEPT_")
  public static <SubClass> //, /*uint*/int MINARITY/* = 0*/>
          type$ptr<Use /*P*/> op_begin(IUser /*P*/ U) {
    return (type$ptr<Use>) U.$This$Ptr().$sub(U.getNumOperands$User());
  }

  @Override
  public type$ptr<Use> op_begin$$(IUser U) {
    return op_begin(U);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::VariadicOperandTraits::op_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 70,
   FQN="llvm::VariadicOperandTraits::op_end", NM="_ZN4llvm21VariadicOperandTraits6op_endEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21VariadicOperandTraits6op_endEPT_")
  //</editor-fold>
  public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
        type$ptr<Use /*P*/> op_end(IUser /*P*/ U) {
    // JAVA: the returned pointer should never be dereferenced: this will lead to class cast exception
    return (type$ptr<Use>) U.$This$Ptr();
  }

  @Override
  public type$ptr<Use> op_end$$(IUser U) {
    return op_end(U);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::VariadicOperandTraits::operands">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/OperandTraits.h", line = 73,
   FQN="llvm::VariadicOperandTraits::operands", NM="_ZN4llvm21VariadicOperandTraits8operandsEPKNS_4UserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21VariadicOperandTraits8operandsEPKNS_4UserE")
  //</editor-fold>
  public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
         /*uint*/int operands(/*const*/ User /*P*/ U) {
    return U.getNumOperands$User();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

    private final int MINARITY;
  
    public VariadicOperandTraits() {
      MINARITY = 0;
    }
  
    public VariadicOperandTraits(/*uint*/int MINARITY) {
      this.MINARITY = MINARITY;
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
            type$ptr<Use /*P*/> op_begin(/*uint*/int MINARITY, SubClass /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/> 
            type$ptr<Use /*P*/> op_end(/*uint*/int MINARITY, SubClass /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
            /*uint*/ int operands(/*uint*/int MINARITY, /*const*/ User /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
