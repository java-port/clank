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


/// ImmutableCallSite - establish a view to a call site for examination
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 623,
 FQN="llvm::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteE")
//</editor-fold>
public class ImmutableCallSite extends /*public*/ CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, type$ptr<Use/*P*/> > implements Native.NativeComparable<CallSite> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 625,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1Ev")
  //</editor-fold>
  public ImmutableCallSite() {
    // : CallSiteBase()
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 626,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1EPKNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1EPKNS_8CallInstE")
  //</editor-fold>
  public ImmutableCallSite(/*const*/ CallInst /*P*/ CI) {
    // : CallSiteBase<const Function, const BasicBlock, const Value, const User, const Use, const Instruction, const CallInst, const InvokeInst, const Use * >(CI)
    //START JInit
    super(JD$T6$P.INSTANCE, CI);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 627,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1EPKNS_10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1EPKNS_10InvokeInstE")
  //</editor-fold>
  public ImmutableCallSite(/*const*/ InvokeInst /*P*/ II) {
    // : CallSiteBase<const Function, const BasicBlock, const Value, const User, const Use, const Instruction, const CallInst, const InvokeInst, const Use * >(II)
    //START JInit
    super(JD$T7$P.INSTANCE, II);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 628,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1EPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1EPKNS_11InstructionE")
  //</editor-fold>
  public /*explicit*/ ImmutableCallSite(/*const*/ Instruction /*P*/ II) {
    // : CallSiteBase<const Function, const BasicBlock, const Value, const User, const Use, const Instruction, const CallInst, const InvokeInst, const Use * >(II)
    //START JInit
    super(JD$T2$P.INSTANCE, II);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 629,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1EPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1EPKNS_5ValueE")
  //</editor-fold>
  public /*explicit*/ ImmutableCallSite(/*const*/ Value /*P*/ V) {
    // : CallSiteBase<const Function, const BasicBlock, const Value, const User, const Use, const Instruction, const CallInst, const InvokeInst, const Use * >(V)
    //START JInit
    super(JD$T2$P.INSTANCE, V);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 630,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1ENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1ENS_8CallSiteE")
  //</editor-fold>
  public ImmutableCallSite(CallSite CS) {
    // : CallSiteBase<const Function, const BasicBlock, const Value, const User, const Use, const Instruction, const CallInst, const InvokeInst, const Use * >(CS.getInstruction())
    //START JInit
    super(JD$T2$P.INSTANCE, CS.getInstruction());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 623,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ImmutableCallSite(final /*const*/ ImmutableCallSite /*&*/ $Prm0) {
    // : CallSiteBase()
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::ImmutableCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 623,
   FQN="llvm::ImmutableCallSite::ImmutableCallSite", NM="_ZN4llvm17ImmutableCallSiteC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteC1EOS0_")
  //</editor-fold>
  public /*inline*/ ImmutableCallSite(JD$Move _dparam, final ImmutableCallSite /*&&*/$Prm0) {
    // : CallSiteBase(static_cast<ImmutableCallSite &&>())
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 623,
   FQN="llvm::ImmutableCallSite::operator=", NM="_ZN4llvm17ImmutableCallSiteaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteaSERKS0_")
  //</editor-fold>
  public /*inline*/ ImmutableCallSite /*&*/ $assign(final /*const*/ ImmutableCallSite /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableCallSite::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 623,
   FQN="llvm::ImmutableCallSite::operator=", NM="_ZN4llvm17ImmutableCallSiteaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm17ImmutableCallSiteaSEOS0_")
  //</editor-fold>
  public /*inline*/ ImmutableCallSite /*&*/ $assignMove(final ImmutableCallSite /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
