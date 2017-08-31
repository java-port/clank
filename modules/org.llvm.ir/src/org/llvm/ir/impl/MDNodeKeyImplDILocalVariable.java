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

package org.llvm.ir.impl;

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

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DILocalVariable>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 797,
 FQN="llvm::MDNodeKeyImpl<DILocalVariable>", NM="_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEE")
//</editor-fold>
public class/*struct*/ MDNodeKeyImplDILocalVariable implements MDNodeKeyImpl<DILocalVariable> {
  public Metadata /*P*/ Scope;
  public MDString /*P*/ Name;
  public Metadata /*P*/ File;
  public /*uint*/int Line;
  public Metadata /*P*/ Type;
  public /*uint*/int Arg;
  public /*uint*/int Flags;

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DILocalVariable>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 806,
   FQN="llvm::MDNodeKeyImpl<DILocalVariable>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEC1EPNS_8MetadataEPNS_8MDStringES4_jS4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEC1EPNS_8MetadataEPNS_8MDStringES4_jS4_jj")
  //</editor-fold>
  public MDNodeKeyImplDILocalVariable(Metadata /*P*/ Scope, MDString /*P*/ Name, Metadata /*P*/ File, /*uint*/int Line,
      Metadata /*P*/ Type, /*uint*/int Arg, /*uint*/int Flags) {
    // : Scope(Scope), Name(Name), File(File), Line(Line), Type(Type), Arg(Arg), Flags(Flags)
    //START JInit
    this.Scope = Scope;
    this.Name = Name;
    this.File = File;
    this.Line = Line;
    this.Type = Type;
    this.Arg = Arg;
    this.Flags = Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DILocalVariable>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 810,
   FQN="llvm::MDNodeKeyImpl<DILocalVariable>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_15DILocalVariableEEC1EPKS1_")
  //</editor-fold>
  public MDNodeKeyImplDILocalVariable(/*const*/ DILocalVariable /*P*/ N) {
    // : Scope(N->getRawScope()), Name(N->getRawName()), File(N->getRawFile()), Line(N->getLine()), Type(N->getRawType()), Arg(N->getArg()), Flags(N->getFlags())
    //START JInit
    this.Scope = N.getRawScope();
    this.Name = N.getRawName();
    this.File = N.getRawFile();
    this.Line = N.getLine();
    this.Type = N.getRawType();
    this.Arg = N.getArg();
    this.Flags = N.getFlags();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DILocalVariable>::isKeyOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 815,
   FQN="llvm::MDNodeKeyImpl<DILocalVariable>::isKeyOf", NM="_ZNK4llvm13MDNodeKeyImplINS_15DILocalVariableEE7isKeyOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_15DILocalVariableEE7isKeyOfEPKS1_")
  //</editor-fold>
  public boolean isKeyOf(/*const*/ DILocalVariable /*P*/ RHS) /*const*/ {
    return Scope == RHS.getRawScope() && Name == RHS.getRawName()
       && File == RHS.getRawFile() && Line == RHS.getLine()
       && Type == RHS.getRawType() && Arg == RHS.getArg()
       && Flags == RHS.getFlags();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DILocalVariable>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 821,
   FQN="llvm::MDNodeKeyImpl<DILocalVariable>::getHashValue", NM="_ZNK4llvm13MDNodeKeyImplINS_15DILocalVariableEE12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_15DILocalVariableEE12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    return hash_combine(hash_value_ptr(Scope), hash_value_ptr(Name), hash_value_ptr(File), Line, hash_value_ptr(Type), Arg, Flags).$uint();
  }


  @Override public String toString() {
    return "" + "Scope=" + Scope // NOI18N
              + ", Name=" + Name // NOI18N
              + ", File=" + File // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Arg=" + Arg // NOI18N
              + ", Flags=" + Flags; // NOI18N
  }
}
