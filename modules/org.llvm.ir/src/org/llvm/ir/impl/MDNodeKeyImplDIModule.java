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

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIModule>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 692,
 FQN="llvm::MDNodeKeyImpl<DIModule>", NM="_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEE")
//</editor-fold>
public class/*struct*/ MDNodeKeyImplDIModule implements MDNodeKeyImpl<DIModule> {
  public Metadata /*P*/ Scope;
  public MDString /*P*/ Name;
  public MDString /*P*/ ConfigurationMacros;
  public MDString /*P*/ IncludePath;
  public MDString /*P*/ ISysRoot;
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIModule>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 698,
   FQN="llvm::MDNodeKeyImpl<DIModule>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEC1EPNS_8MetadataEPNS_8MDStringES6_S6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEC1EPNS_8MetadataEPNS_8MDStringES6_S6_S6_")
  //</editor-fold>
  public MDNodeKeyImplDIModule(Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ ConfigurationMacros,
      MDString /*P*/ IncludePath, MDString /*P*/ ISysRoot) {
    // : Scope(Scope), Name(Name), ConfigurationMacros(ConfigurationMacros), IncludePath(IncludePath), ISysRoot(ISysRoot)
    //START JInit
    this.Scope = Scope;
    this.Name = Name;
    this.ConfigurationMacros = ConfigurationMacros;
    this.IncludePath = IncludePath;
    this.ISysRoot = ISysRoot;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIModule>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 702,
   FQN="llvm::MDNodeKeyImpl<DIModule>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_8DIModuleEEC1EPKS1_")
  //</editor-fold>
  public MDNodeKeyImplDIModule(/*const*/ DIModule /*P*/ N) {
    // : Scope(N->getRawScope()), Name(N->getRawName()), ConfigurationMacros(N->getRawConfigurationMacros()), IncludePath(N->getRawIncludePath()), ISysRoot(N->getRawISysRoot())
    //START JInit
    this.Scope = N.getRawScope();
    this.Name = N.getRawName();
    this.ConfigurationMacros = N.getRawConfigurationMacros();
    this.IncludePath = N.getRawIncludePath();
    this.ISysRoot = N.getRawISysRoot();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIModule>::isKeyOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 707,
   FQN="llvm::MDNodeKeyImpl<DIModule>::isKeyOf", NM="_ZNK4llvm13MDNodeKeyImplINS_8DIModuleEE7isKeyOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_8DIModuleEE7isKeyOfEPKS1_")
  //</editor-fold>
  public boolean isKeyOf(/*const*/ DIModule /*P*/ RHS) /*const*/ {
    return Scope == RHS.getRawScope() && Name == RHS.getRawName()
       && ConfigurationMacros == RHS.getRawConfigurationMacros()
       && IncludePath == RHS.getRawIncludePath()
       && ISysRoot == RHS.getRawISysRoot();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIModule>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 713,
   FQN="llvm::MDNodeKeyImpl<DIModule>::getHashValue", NM="_ZNK4llvm13MDNodeKeyImplINS_8DIModuleEE12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_8DIModuleEE12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    return hash_combine_ptrs(Scope, Name,
        ConfigurationMacros, IncludePath, ISysRoot).$uint();
  }


  @Override public String toString() {
    return "" + "Scope=" + Scope // NOI18N
              + ", Name=" + Name // NOI18N
              + ", ConfigurationMacros=" + ConfigurationMacros // NOI18N
              + ", IncludePath=" + IncludePath // NOI18N
              + ", ISysRoot=" + ISysRoot; // NOI18N
  }
}
