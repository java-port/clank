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


/// This node is a base class providing common functionality for
/// n'ary operators.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 123,
 FQN="llvm::SCEVNAryExpr", NM="_ZN4llvm12SCEVNAryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVNAryExprE")
//</editor-fold>
public class SCEVNAryExpr extends /*public*/ SCEV {
/*protected:*/
  // Since SCEVs are immutable, ScalarEvolution allocates operand
  // arrays with its SCEVAllocator, so this class just needs a simple
  // pointer rather than a more elaborate vector-like data structure.
  // This also avoids the need for a non-trivial destructor.
  protected type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> Operands;
  protected /*size_t*/int NumOperands;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::SCEVNAryExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 132,
   FQN="llvm::SCEVNAryExpr::SCEVNAryExpr", NM="_ZN4llvm12SCEVNAryExprC1ENS_19FoldingSetNodeIDRefENS_9SCEVTypesEPKPKNS_4SCEVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVNAryExprC1ENS_19FoldingSetNodeIDRefENS_9SCEVTypesEPKPKNS_4SCEVEj")
  //</editor-fold>
  protected SCEVNAryExpr(/*const*/ FoldingSetNodeIDRef ID, 
       SCEVTypes T, type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> O, /*size_t*/int N) {
    // : SCEV(ID, T), Operands(O), NumOperands(N) 
    super(new FoldingSetNodeIDRef(ID), T.getValue());
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 137,
   FQN="llvm::SCEVNAryExpr::getNumOperands", NM="_ZNK4llvm12SCEVNAryExpr14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr14getNumOperandsEv")
  //</editor-fold>
  public /*size_t*/int getNumOperands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 138,
   FQN="llvm::SCEVNAryExpr::getOperand", NM="_ZNK4llvm12SCEVNAryExpr10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr10getOperandEj")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getOperand(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef const SCEV *const *op_iterator
//  public final class op_iterator extends type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/>{ };
  // JAVA: typedef iterator_range<op_iterator> op_range
//  public final class op_range extends iterator_range</*const*/ SCEV /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::op_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 145,
   FQN="llvm::SCEVNAryExpr::op_begin", NM="_ZNK4llvm12SCEVNAryExpr8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr8op_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> op_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::op_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 146,
   FQN="llvm::SCEVNAryExpr::op_end", NM="_ZNK4llvm12SCEVNAryExpr6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr6op_endEv")
  //</editor-fold>
  public type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> op_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::operands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 147,
   FQN="llvm::SCEVNAryExpr::operands", NM="_ZNK4llvm12SCEVNAryExpr8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr8operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ SCEV /*P*/ /*const*/> operands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 151,
   FQN="llvm::SCEVNAryExpr::getType", NM="_ZNK4llvm12SCEVNAryExpr7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr7getTypeEv")
  //</editor-fold>
  public Type /*P*/ getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::getNoWrapFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 153,
   FQN="llvm::SCEVNAryExpr::getNoWrapFlags", NM="_ZNK4llvm12SCEVNAryExpr14getNoWrapFlagsENS_4SCEV11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr14getNoWrapFlagsENS_4SCEV11NoWrapFlagsE")
  //</editor-fold>
  public /*NoWrapFlags*//*uint*/int getNoWrapFlags() /*const*/ {
    return getNoWrapFlags(NoWrapFlags.NoWrapMask);
  }
  public /*NoWrapFlags*//*uint*/int getNoWrapFlags(/*NoWrapFlags*//*uint*/int Mask/*= NoWrapMask*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::hasNoUnsignedWrap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 157,
   FQN="llvm::SCEVNAryExpr::hasNoUnsignedWrap", NM="_ZNK4llvm12SCEVNAryExpr17hasNoUnsignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr17hasNoUnsignedWrapEv")
  //</editor-fold>
  public boolean hasNoUnsignedWrap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::hasNoSignedWrap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 161,
   FQN="llvm::SCEVNAryExpr::hasNoSignedWrap", NM="_ZNK4llvm12SCEVNAryExpr15hasNoSignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr15hasNoSignedWrapEv")
  //</editor-fold>
  public boolean hasNoSignedWrap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::hasNoSelfWrap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 165,
   FQN="llvm::SCEVNAryExpr::hasNoSelfWrap", NM="_ZNK4llvm12SCEVNAryExpr13hasNoSelfWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVNAryExpr13hasNoSelfWrapEv")
  //</editor-fold>
  public boolean hasNoSelfWrap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVNAryExpr::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 170,
   FQN="llvm::SCEVNAryExpr::classof", NM="_ZN4llvm12SCEVNAryExpr7classofEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVNAryExpr7classofEPKNS_4SCEVE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Operands=" + Operands // NOI18N
              + ", NumOperands=" + NumOperands // NOI18N
              + super.toString(); // NOI18N
  }
}
