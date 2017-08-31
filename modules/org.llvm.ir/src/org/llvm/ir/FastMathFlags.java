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


/// Convenience struct for specifying and reasoning about fast-math flags.
//<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 164,
 FQN="llvm::FastMathFlags", NM="_ZN4llvm13FastMathFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsE")
//</editor-fold>
public class FastMathFlags {
/*private:*/
  /*friend  class FPMathOperator*/
  /*friend*/public/*private*/ /*uint*/int Flags;
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::FastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 168,
   FQN="llvm::FastMathFlags::FastMathFlags", NM="_ZN4llvm13FastMathFlagsC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsC1Ej")
  //</editor-fold>
  /*friend*/public/*private*/ FastMathFlags(/*uint*/int F) {
    // : Flags(F)
    //START JInit
    this.Flags = F;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 171,
   FQN="llvm::FastMathFlags::(anonymous)", NM="_ZN4llvm13FastMathFlagsE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int UnsafeAlgebra = (1 << 0);
    public static final /*uint*/int NoNaNs = (1 << 1);
    public static final /*uint*/int NoInfs = (1 << 2);
    public static final /*uint*/int NoSignedZeros = (1 << 3);
    public static final /*uint*/int AllowReciprocal = (1 << 4);
  /*}*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::FastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 179,
   FQN="llvm::FastMathFlags::FastMathFlags", NM="_ZN4llvm13FastMathFlagsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsC1Ev")
  //</editor-fold>
  /*friend*/public/*public*/ FastMathFlags() {
    // : Flags(0)
    //START JInit
    this.Flags = 0;
    //END JInit
  }


  /// Whether any flag is set
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::any">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 183,
   FQN="llvm::FastMathFlags::any", NM="_ZNK4llvm13FastMathFlags3anyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags3anyEv")
  //</editor-fold>
  public boolean any() /*const*/ {
    return Flags != 0;
  }


  /// Set all the flags to false
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 186,
   FQN="llvm::FastMathFlags::clear", NM="_ZN4llvm13FastMathFlags5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags5clearEv")
  //</editor-fold>
  public void clear() {
    Flags = 0;
  }


  /// Flag queries
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::noNaNs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 189,
   FQN="llvm::FastMathFlags::noNaNs", NM="_ZNK4llvm13FastMathFlags6noNaNsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags6noNaNsEv")
  //</editor-fold>
  public boolean noNaNs() /*const*/ {
    return 0 != (Flags & NoNaNs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::noInfs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 190,
   FQN="llvm::FastMathFlags::noInfs", NM="_ZNK4llvm13FastMathFlags6noInfsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags6noInfsEv")
  //</editor-fold>
  public boolean noInfs() /*const*/ {
    return 0 != (Flags & NoInfs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::noSignedZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 191,
   FQN="llvm::FastMathFlags::noSignedZeros", NM="_ZNK4llvm13FastMathFlags13noSignedZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags13noSignedZerosEv")
  //</editor-fold>
  public boolean noSignedZeros() /*const*/ {
    return 0 != (Flags & NoSignedZeros);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::allowReciprocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 192,
   FQN="llvm::FastMathFlags::allowReciprocal", NM="_ZNK4llvm13FastMathFlags15allowReciprocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags15allowReciprocalEv")
  //</editor-fold>
  public boolean allowReciprocal() /*const*/ {
    return 0 != (Flags & AllowReciprocal);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::unsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 193,
   FQN="llvm::FastMathFlags::unsafeAlgebra", NM="_ZNK4llvm13FastMathFlags13unsafeAlgebraEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZNK4llvm13FastMathFlags13unsafeAlgebraEv")
  //</editor-fold>
  public boolean unsafeAlgebra() /*const*/ {
    return 0 != (Flags & UnsafeAlgebra);
  }


  /// Flag setters
  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::setNoNaNs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 196,
   FQN="llvm::FastMathFlags::setNoNaNs", NM="_ZN4llvm13FastMathFlags9setNoNaNsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags9setNoNaNsEv")
  //</editor-fold>
  public void setNoNaNs() {
    Flags |= NoNaNs;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::setNoInfs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 197,
   FQN="llvm::FastMathFlags::setNoInfs", NM="_ZN4llvm13FastMathFlags9setNoInfsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags9setNoInfsEv")
  //</editor-fold>
  public void setNoInfs() {
    Flags |= NoInfs;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::setNoSignedZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 198,
   FQN="llvm::FastMathFlags::setNoSignedZeros", NM="_ZN4llvm13FastMathFlags16setNoSignedZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags16setNoSignedZerosEv")
  //</editor-fold>
  public void setNoSignedZeros() {
    Flags |= NoSignedZeros;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::setAllowReciprocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 199,
   FQN="llvm::FastMathFlags::setAllowReciprocal", NM="_ZN4llvm13FastMathFlags18setAllowReciprocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags18setAllowReciprocalEv")
  //</editor-fold>
  public void setAllowReciprocal() {
    Flags |= AllowReciprocal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::setUnsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 200,
   FQN="llvm::FastMathFlags::setUnsafeAlgebra", NM="_ZN4llvm13FastMathFlags16setUnsafeAlgebraEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlags16setUnsafeAlgebraEv")
  //</editor-fold>
  public void setUnsafeAlgebra() {
    Flags |= UnsafeAlgebra;
    setNoNaNs();
    setNoInfs();
    setNoSignedZeros();
    setAllowReciprocal();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::operator&=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 208,
   FQN="llvm::FastMathFlags::operator&=", NM="_ZN4llvm13FastMathFlagsaNERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsaNERKS0_")
  //</editor-fold>
  public void $andassign(final /*const*/ FastMathFlags /*&*/ OtherFlags) {
    Flags &= OtherFlags.Flags;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::FastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 164,
   FQN="llvm::FastMathFlags::FastMathFlags", NM="_ZN4llvm13FastMathFlagsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsC1ERKS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ FastMathFlags(final /*const*/ FastMathFlags /*&*/ $Prm0) {
    // : Flags(.Flags)
    //START JInit
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::FastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 164,
   FQN="llvm::FastMathFlags::FastMathFlags", NM="_ZN4llvm13FastMathFlagsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsC1EOS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ FastMathFlags(JD$Move _dparam, final FastMathFlags /*&&*/$Prm0) {
    // : Flags(static_cast<FastMathFlags &&>().Flags)
    //START JInit
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 164,
   FQN="llvm::FastMathFlags::operator=", NM="_ZN4llvm13FastMathFlagsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsaSERKS0_")
  //</editor-fold>
  public /*inline*/ FastMathFlags /*&*/ $assign(final /*const*/ FastMathFlags /*&*/ $Prm0) {
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FastMathFlags::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 164,
   FQN="llvm::FastMathFlags::operator=", NM="_ZN4llvm13FastMathFlagsaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm13FastMathFlagsaSEOS0_")
  //</editor-fold>
  public /*inline*/ FastMathFlags /*&*/ $assignMove(final FastMathFlags /*&&*/$Prm0) {
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }


  @Override public String toString() {
    return "" + "Flags=" + Flags; // NOI18N
  }
}
