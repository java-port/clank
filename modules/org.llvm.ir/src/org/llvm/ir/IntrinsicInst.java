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

/// A wrapper class for inspecting calls to intrinsic functions.
/// This allows the standard isa/dyncast/cast functionality to work with calls
/// to intrinsic functions.
//<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 37,
 FQN="llvm::IntrinsicInst", NM="_ZN4llvm13IntrinsicInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInstE")
//</editor-fold>
public class IntrinsicInst extends /*public*/ CallInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::IntrinsicInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 38,
   FQN="llvm::IntrinsicInst::IntrinsicInst", NM="_ZN4llvm13IntrinsicInstC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInstC1Ev")
  //</editor-fold>
  protected/*private*/ IntrinsicInst() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::IntrinsicInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 39,
   FQN="llvm::IntrinsicInst::IntrinsicInst", NM="_ZN4llvm13IntrinsicInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInstC1ERKS0_")
  //</editor-fold>
  protected/*private*/ IntrinsicInst(final /*const*/ IntrinsicInst /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 40,
   FQN="llvm::IntrinsicInst::operator=", NM="_ZN4llvm13IntrinsicInstaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInstaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ IntrinsicInst /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// Return the intrinsic ID of this intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::getIntrinsicID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 43,
   FQN="llvm::IntrinsicInst::getIntrinsicID", NM="_ZNK4llvm13IntrinsicInst14getIntrinsicIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZNK4llvm13IntrinsicInst14getIntrinsicIDEv")
  //</editor-fold>
  public /*Intrinsic.ID*/int getIntrinsicID() /*const*/ {
    return getCalledFunction().getIntrinsicID();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 48,
   FQN="llvm::IntrinsicInst::classof", NM="_ZN4llvm13IntrinsicInst7classofEPKNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInst7classofEPKNS_8CallInstE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ CallInst /*P*/ I) {
    {
      /*const*/ Function /*P*/ CF = I.getCalledFunction();
      if ((CF != null)) {
        return CF.isIntrinsic();
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 53,
   FQN="llvm::IntrinsicInst::classof", NM="_ZN4llvm13IntrinsicInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_CallInst(V) && IntrinsicInst.classof(cast_CallInst(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicInst::~IntrinsicInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IntrinsicInst.h", line = 37,
   FQN="llvm::IntrinsicInst::~IntrinsicInst", NM="_ZN4llvm13IntrinsicInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IntrinsicInst.cpp -nm=_ZN4llvm13IntrinsicInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
