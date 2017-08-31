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


/// This class represents an analyzed expression in the program.  These are
/// opaque objects that the client is not allowed to do much with directly.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SCEV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 64,
 FQN="llvm::SCEV", NM="_ZN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm4SCEVE")
//</editor-fold>
public class SCEV implements /*public*/ FoldingSetImpl.Node {
  /*friend  struct FoldingSetTrait<SCEV>*/
  
  /// A reference to an Interned FoldingSetNodeID for this node.  The
  /// ScalarEvolution's BumpPtrAllocator holds the data.
  private FoldingSetNodeIDRef FastID;
  
  // The SCEV baseclass this node corresponds to
  private /*const*//*ushort*/char SCEVType;
/*protected:*/
  /// This field is initialized to zero and may be used in subclasses to store
  /// miscellaneous information.
  protected /*ushort*/char SubclassData;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::SCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 80,
   FQN="llvm::SCEV::SCEV", NM="_ZN4llvm4SCEVC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm4SCEVC1ERKS0_")
  //</editor-fold>
  protected/*private*/ SCEV(final /*const*/ SCEV /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 81,
   FQN="llvm::SCEV::operator=", NM="_ZN4llvm4SCEVaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm4SCEVaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ SCEV /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// NoWrapFlags are bitfield indices into SubclassData.
  ///
  /// Add and Mul expressions may have no-unsigned-wrap <NUW> or
  /// no-signed-wrap <NSW> properties, which are derived from the IR
  /// operator. NSW is a misnomer that we use to mean no signed overflow or
  /// underflow.
  ///
  /// AddRec expressions may have a no-self-wraparound <NW> property if, in
  /// the integer domain, abs(step) * max-iteration(loop) <=
  /// unsigned-max(bitwidth).  This means that the recurrence will never reach
  /// its start value if the step is non-zero.  Computing the same value on
  /// each iteration is not considered wrapping, and recurrences with step = 0
  /// are trivially <NW>.  <NW> is independent of the sign of step and the
  /// value the add recurrence starts with.
  ///
  /// Note that NUW and NSW are also valid properties of a recurrence, and
  /// either implies NW. For convenience, NW will be set for a recurrence
  /// whenever either NUW or NSW are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::NoWrapFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 102,
   FQN="llvm::SCEV::NoWrapFlags", NM="_ZN4llvm4SCEV11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm4SCEV11NoWrapFlagsE")
  //</editor-fold>
  public static final class/*enum*/ NoWrapFlags {
    public static final /*uint*/int FlagAnyWrap = 0; // No guarantee.
    public static final /*uint*/int FlagNW = (1 << 0); // No self-wrap.
    public static final /*uint*/int FlagNUW = (1 << 1); // No unsigned wrap.
    public static final /*uint*/int FlagNSW = (1 << 2); // No signed wrap.
    public static final /*uint*/int NoWrapMask = (1 << 3) - 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::SCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 108,
   FQN="llvm::SCEV::SCEV", NM="_ZN4llvm4SCEVC1ENS_19FoldingSetNodeIDRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm4SCEVC1ENS_19FoldingSetNodeIDRefEj")
  //</editor-fold>
  public /*explicit*/ SCEV(/*const*/ FoldingSetNodeIDRef ID, /*uint*/int SCEVTy) {
    // : FoldingSetNode(), FastID(ID), SCEVType(SCEVTy), SubclassData(0) 
    $Node();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::getSCEVType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 111,
   FQN="llvm::SCEV::getSCEVType", NM="_ZNK4llvm4SCEV11getSCEVTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV11getSCEVTypeEv")
  //</editor-fold>
  public /*uint*/int getSCEVType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the LLVM type of this SCEV expression.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 247,
   FQN="llvm::SCEV::getType", NM="_ZNK4llvm4SCEV7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV7getTypeEv")
  //</editor-fold>
  public Type /*P*/ getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the expression is a constant zero.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::isZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 272,
   FQN="llvm::SCEV::isZero", NM="_ZNK4llvm4SCEV6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the expression is a constant one.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::isOne">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 278,
   FQN="llvm::SCEV::isOne", NM="_ZNK4llvm4SCEV5isOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV5isOneEv")
  //</editor-fold>
  public boolean isOne() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the expression is a constant all-ones value.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::isAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 284,
   FQN="llvm::SCEV::isAllOnesValue", NM="_ZNK4llvm4SCEV14isAllOnesValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV14isAllOnesValueEv")
  //</editor-fold>
  public boolean isAllOnesValue() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified scev is negated, but not a constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::isNonConstantNegative">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 290,
   FQN="llvm::SCEV::isNonConstantNegative", NM="_ZNK4llvm4SCEV21isNonConstantNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV21isNonConstantNegativeEv")
  //</editor-fold>
  public boolean isNonConstantNegative() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Print out the internal representation of this scalar to the specified
  /// stream.  This should really only be used for debugging purposes.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 137,
   FQN="llvm::SCEV::print", NM="_ZNK4llvm4SCEV5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method is used for debugging.
  ///
  
  //===----------------------------------------------------------------------===//
  //                           SCEV class definitions
  //===----------------------------------------------------------------------===//
  
  //===----------------------------------------------------------------------===//
  // Implementation of the SCEV class.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEV::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 131,
   FQN="llvm::SCEV::dump", NM="_ZNK4llvm4SCEV4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm4SCEV4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "FastID=" + FastID // NOI18N
              + ", SCEVType=" + $ushort2uint(SCEVType) // NOI18N
              + ", SubclassData=" + $ushort2uint(SubclassData) // NOI18N
              + super.toString(); // NOI18N
  }
}
