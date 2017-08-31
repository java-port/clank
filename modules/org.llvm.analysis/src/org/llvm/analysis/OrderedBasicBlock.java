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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::OrderedBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OrderedBasicBlock.h", line = 34,
 FQN="llvm::OrderedBasicBlock", NM="_ZN4llvm17OrderedBasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CaptureTracking.cpp -nm=_ZN4llvm17OrderedBasicBlockE")
//</editor-fold>
public class OrderedBasicBlock implements Destructors.ClassWithDestructor {
/*private:*/
  /// \brief Map a instruction to its position in a BasicBlock.
  private SmallDenseMapTypeUInt</*const*/ Instruction /*P*/ > NumberedInsts;
  
  /// \brief Keep track of last instruction inserted into \p NumberedInsts.
  /// It speeds up queries for uncached instructions by providing a start point
  /// for new queries in OrderedBasicBlock::comesBefore.
  private ilist_iterator</*const*/ Instruction> LastInstFound;
  
  /// \brief The position/number to tag the next instruction to be found.
  private /*uint*/int NextInstPos;
  
  /// \brief The source BasicBlock to map.
  private /*const*/ BasicBlock /*P*/ BB;
  
  /// \brief Given no cached results, find if \p A comes before \p B in \p BB.
  /// Cache and number out instruction while walking \p BB.
  
  /// \brief Given no cached results, find if \p A comes before \p B in \p BB.
  /// Cache and number out instruction while walking \p BB.
  
  /// \brief Given no cached results, find if \p A comes before \p B in \p BB.
  /// Cache and number out instruction while walking \p BB.
  //<editor-fold defaultstate="collapsed" desc="llvm::OrderedBasicBlock::comesBefore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp", line = 35,
   FQN="llvm::OrderedBasicBlock::comesBefore", NM="_ZN4llvm17OrderedBasicBlock11comesBeforeEPKNS_11InstructionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp -nm=_ZN4llvm17OrderedBasicBlock11comesBeforeEPKNS_11InstructionES3_")
  //</editor-fold>
  private boolean comesBefore(/*const*/ Instruction /*P*/ A, 
             /*const*/ Instruction /*P*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OrderedBasicBlock::OrderedBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp", line = 28,
   FQN="llvm::OrderedBasicBlock::OrderedBasicBlock", NM="_ZN4llvm17OrderedBasicBlockC1EPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp -nm=_ZN4llvm17OrderedBasicBlockC1EPKNS_10BasicBlockE")
  //</editor-fold>
  public OrderedBasicBlock(/*const*/ BasicBlock /*P*/ BasicB) {
    // : NumberedInsts(), LastInstFound(), NextInstPos(0), BB(BasicB) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Find out whether \p A dominates \p B, meaning whether \p A
  /// comes before \p B in \p BB. This is a simplification that considers
  /// cached instruction positions and ignores other basic blocks, being
  /// only relevant to compare relative instructions positions inside \p BB.
  
  /// \brief Find out whether \p A dominates \p B, meaning whether \p A
  /// comes before \p B in \p BB. This is a simplification that considers
  /// cached instruction positions and ignores other basic blocks, being
  /// only relevant to compare relative instructions positions inside \p BB.
  
  /// \brief Find out whether \p A dominates \p B, meaning whether \p A
  /// comes before \p B in \p BB. This is a simplification that considers
  /// cached instruction positions and ignores other basic blocks, being
  /// only relevant to compare relative instructions positions inside \p BB.
  //<editor-fold defaultstate="collapsed" desc="llvm::OrderedBasicBlock::dominates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp", line = 65,
   FQN="llvm::OrderedBasicBlock::dominates", NM="_ZN4llvm17OrderedBasicBlock9dominatesEPKNS_11InstructionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OrderedBasicBlock.cpp -nm=_ZN4llvm17OrderedBasicBlock9dominatesEPKNS_11InstructionES3_")
  //</editor-fold>
  public boolean dominates(/*const*/ Instruction /*P*/ A, /*const*/ Instruction /*P*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::OrderedBasicBlock::~OrderedBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OrderedBasicBlock.h", line = 34,
   FQN="llvm::OrderedBasicBlock::~OrderedBasicBlock", NM="_ZN4llvm17OrderedBasicBlockD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CaptureTracking.cpp -nm=_ZN4llvm17OrderedBasicBlockD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "NumberedInsts=" + NumberedInsts // NOI18N
              + ", LastInstFound=" + LastInstFound // NOI18N
              + ", NextInstPos=" + NextInstPos // NOI18N
              + ", BB=" + BB; // NOI18N
  }
}
