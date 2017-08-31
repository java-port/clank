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


/// A specialization of it's base class for read only access
/// to a gc.statepoint.
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableStatepoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 285,
 FQN="llvm::ImmutableStatepoint", NM="_ZN4llvm19ImmutableStatepointE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SelectionDAG/SelectionDAGBuilder.cpp -nm=_ZN4llvm19ImmutableStatepointE")
//</editor-fold>
public class ImmutableStatepoint extends /*public*/ StatepointBase</*const*/ Function, /*const*/ Instruction, /*const*/ Value, ImmutableCallSite> {
  // JAVA: typedef StatepointBase<const Function, const Instruction, const Value, ImmutableCallSite> Base
//  public final class Base extends StatepointBase</*const*/ Function, /*const*/ Instruction, /*const*/ Value, ImmutableCallSite>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableStatepoint::ImmutableStatepoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 292,
   FQN="llvm::ImmutableStatepoint::ImmutableStatepoint", NM="_ZN4llvm19ImmutableStatepointC1EPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SelectionDAG/SelectionDAGBuilder.cpp -nm=_ZN4llvm19ImmutableStatepointC1EPKNS_11InstructionE")
  //</editor-fold>
  public /*explicit*/ ImmutableStatepoint(/*const*/ Instruction /*P*/ I) {
    // : Base(I)
    //START JInit
    super(ImmutableCallSite.class, JD$T1$P.INSTANCE, I);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableStatepoint::ImmutableStatepoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 293,
   FQN="llvm::ImmutableStatepoint::ImmutableStatepoint", NM="_ZN4llvm19ImmutableStatepointC1ENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SelectionDAG/SelectionDAGBuilder.cpp -nm=_ZN4llvm19ImmutableStatepointC1ENS_17ImmutableCallSiteE")
  //</editor-fold>
  public /*explicit*/ ImmutableStatepoint(ImmutableCallSite CS) {
    // : Base(CS)
    //START JInit
    super(JD$T3.INSTANCE, new ImmutableCallSite(CS));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableStatepoint::ImmutableStatepoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 285,
   FQN="llvm::ImmutableStatepoint::ImmutableStatepoint", NM="_ZN4llvm19ImmutableStatepointC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SelectionDAG/SelectionDAGBuilder.cpp -nm=_ZN4llvm19ImmutableStatepointC1EOS0_")
  //</editor-fold>
  public /*inline*/ ImmutableStatepoint(JD$Move _dparam, final ImmutableStatepoint /*&&*/$Prm0) {
    // : StatepointBase<const Function, const Instruction, const Value, ImmutableCallSite>(static_cast<ImmutableStatepoint &&>())
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
