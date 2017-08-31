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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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


/// PassManagerPrettyStackEntry - This is used to print informative information
/// about what pass is running when/if a stack trace is generated.
//<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 117,
 FQN="llvm::PassManagerPrettyStackEntry", NM="_ZN4llvm27PassManagerPrettyStackEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm27PassManagerPrettyStackEntryE")
//</editor-fold>
public class PassManagerPrettyStackEntry extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private Pass /*P*/ P;
  private Value /*P*/ V;
  private Module /*P*/ M;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 123,
   FQN="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry", NM="_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassE")
  //</editor-fold>
  public /*explicit*/ PassManagerPrettyStackEntry(Pass /*P*/ p) {
    // : PrettyStackTraceEntry(), P(p), V(null), M(null) 
    //START JInit
    super();
    this.P = p;
    this.V = null;
    this.M = null;
    //END JInit
  } // When P is releaseMemory'd.

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 125,
   FQN="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry", NM="_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassERNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassERNS_5ValueE")
  //</editor-fold>
  public PassManagerPrettyStackEntry(Pass /*P*/ p, final Value /*&*/ v) {
    // : PrettyStackTraceEntry(), P(p), V(&v), M(null) 
    //START JInit
    super();
    this.P = p;
    this.V = $AddrOf(v);
    this.M = null;
    //END JInit
  } // When P is run on V

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 127,
   FQN="llvm::PassManagerPrettyStackEntry::PassManagerPrettyStackEntry", NM="_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm27PassManagerPrettyStackEntryC1EPNS_4PassERNS_6ModuleE")
  //</editor-fold>
  public PassManagerPrettyStackEntry(Pass /*P*/ p, final Module /*&*/ m) {
    // : PrettyStackTraceEntry(), P(p), V(null), M(&m) 
    //START JInit
    super();
    this.P = p;
    this.V = null;
    this.M = $AddrOf(m);
    //END JInit
  } // When P is run on M

  
  /// print - Emit information about this stack frame to OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 134,
   FQN="llvm::PassManagerPrettyStackEntry::print", NM="_ZNK4llvm27PassManagerPrettyStackEntry5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm27PassManagerPrettyStackEntry5printERNS_11raw_ostreamE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    if (!(V != null) && !(M != null)) {
      OS.$out(/*KEEP_STR*/"Releasing pass '");
    } else {
      OS.$out(/*KEEP_STR*/"Running pass '");
    }
    
    OS.$out(P.getPassName()).$out(/*KEEP_STR*/$SGL_QUOTE);
    if ((M != null)) {
      OS.$out(/*KEEP_STR*/" on module '").$out(M.getModuleIdentifier()).$out(/*KEEP_STR*/"'.\n");
      return;
    }
    if (!(V != null)) {
      OS.$out_char($$LF);
      return;
    }
    
    OS.$out(/*KEEP_STR*/" on ");
    if (isa_Function(V)) {
      OS.$out(/*KEEP_STR*/"function");
    } else if (isa_BasicBlock(V)) {
      OS.$out(/*KEEP_STR*/"basic block");
    } else {
      OS.$out(/*KEEP_STR*/"value");
    }
    
    OS.$out(/*KEEP_STR*/" '");
    V.printAsOperand(OS, /*PrintTy=*/ false, M);
    OS.$out(/*KEEP_STR*/"'\n");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerPrettyStackEntry::~PassManagerPrettyStackEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 117,
   FQN="llvm::PassManagerPrettyStackEntry::~PassManagerPrettyStackEntry", NM="_ZN4llvm27PassManagerPrettyStackEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm27PassManagerPrettyStackEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "P=" + P // NOI18N
              + ", V=" + V // NOI18N
              + ", M=" + M // NOI18N
              + super.toString(); // NOI18N
  }
}
