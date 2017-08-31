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

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeSubsetEqualImpl<DIDerivedType>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 396,
 FQN="llvm::MDNodeSubsetEqualImpl<DIDerivedType>", NM="_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEEE")
//</editor-fold>
public class/*struct*/ MDNodeSubsetEqualImplDIDerivedType {
  // JAVA: typedef MDNodeKeyImpl<DIDerivedType> KeyTy
//  public final class KeyTy extends MDNodeKeyImplDIDerivedType{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isSubsetEqual">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 398,
   FQN="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isSubsetEqual", NM="_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE13isSubsetEqualERKNS_13MDNodeKeyImplIS1_EEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE13isSubsetEqualERKNS_13MDNodeKeyImplIS1_EEPKS1_")
  //</editor-fold>
  public static boolean isSubsetEqual(final /*const*/ MDNodeKeyImplDIDerivedType /*&*/ LHS, /*const*/ DIDerivedType /*P*/ RHS) {
    return MDNodeSubsetEqualImplDIDerivedType.isODRMember(LHS._Tag, LHS.Scope, LHS.Name, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isSubsetEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 401,
   FQN="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isSubsetEqual", NM="_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE13isSubsetEqualEPKS1_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE13isSubsetEqualEPKS1_S4_")
  //</editor-fold>
  public static boolean isSubsetEqual(/*const*/ DIDerivedType /*P*/ LHS, /*const*/ DIDerivedType /*P*/ RHS) {
    return MDNodeSubsetEqualImplDIDerivedType.isODRMember(LHS.getTag(), LHS.getRawScope(), LHS.getRawName(),
        RHS);
  }


  /// Subprograms compare equal if they declare the same function in an ODR
  /// type.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isODRMember">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 408,
   FQN="llvm::MDNodeSubsetEqualImpl<DIDerivedType>::isODRMember", NM="_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE11isODRMemberEjPKNS_8MetadataEPKNS_8MDStringEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21MDNodeSubsetEqualImplINS_13DIDerivedTypeEE11isODRMemberEjPKNS_8MetadataEPKNS_8MDStringEPKS1_")
  //</editor-fold>
  public static boolean isODRMember(/*uint*/int _Tag, /*const*/ Metadata /*P*/ Scope,
             /*const*/ MDString /*P*/ Name, /*const*/ DIDerivedType /*P*/ RHS) {
    // Check whether the LHS is eligible.
    if (_Tag != $ushort2uint(Tag.DW_TAG_member) || !(Name != null)) {
      return false;
    }

    /*const*/ DICompositeType /*P*/ CT = dyn_cast_or_null_DICompositeType(Scope);
    if (!(CT != null) || !(CT.getRawIdentifier() != null)) {
      return false;
    }

    // Compare to the RHS.
    return _Tag == RHS.getTag() && Name == RHS.getRawName()
       && Scope == RHS.getRawScope();
  }


  @Override public String toString() {
    return ""; // NOI18N
  }
}
