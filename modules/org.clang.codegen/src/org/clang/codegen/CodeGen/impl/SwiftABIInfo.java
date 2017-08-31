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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// A refining implementation of ABIInfo for targets that support swiftcall.
///
/// If we find ourselves wanting multiple such refinements, they'll probably
/// be independent refinements, and we should probably find another way
/// to do it than simple inheritance.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 131,
 FQN="clang::CodeGen::SwiftABIInfo", NM="_ZN5clang7CodeGen12SwiftABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen12SwiftABIInfoE")
//</editor-fold>
public abstract class SwiftABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::SwiftABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 133,
   FQN="clang::CodeGen::SwiftABIInfo::SwiftABIInfo", NM="_ZN5clang7CodeGen12SwiftABIInfoC1ERNS0_12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen12SwiftABIInfoC1ERNS0_12CodeGenTypesE")
  //</editor-fold>
  public SwiftABIInfo(final CodeGenTypes /*&*/ cgt) {
    // : ABIInfo(cgt) 
    //START JInit
    super(cgt);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::supportsSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 135,
   FQN="clang::CodeGen::SwiftABIInfo::supportsSwift", NM="_ZNK5clang7CodeGen12SwiftABIInfo13supportsSwiftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen12SwiftABIInfo13supportsSwiftEv")
  //</editor-fold>
  @Override public final boolean supportsSwift() /*const*//* override final*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 137,
   FQN="clang::CodeGen::SwiftABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK5clang7CodeGen12SwiftABIInfo28shouldPassIndirectlyForSwiftENS_9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen12SwiftABIInfo28shouldPassIndirectlyForSwiftENS_9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  public abstract /*virtual*/ boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<org.llvm.ir.Type /*P*/ > types, 
                              boolean asReturnValue) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::isLegalVectorTypeForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 104,
   FQN="clang::CodeGen::SwiftABIInfo::isLegalVectorTypeForSwift", NM="_ZNK5clang7CodeGen12SwiftABIInfo25isLegalVectorTypeForSwiftENS_9CharUnitsEPN4llvm4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen12SwiftABIInfo25isLegalVectorTypeForSwiftENS_9CharUnitsEPN4llvm4TypeEj")
  //</editor-fold>
  public boolean isLegalVectorTypeForSwift(CharUnits vectorSize, 
                           org.llvm.ir.Type /*P*/ eltTy, 
                           /*uint*/int numElts) /*const*/ {
    // The default implementation of this assumes that the target guarantees
    // 128-bit SIMD support but nothing more.
    return (vectorSize.getQuantity() > 8 && vectorSize.getQuantity() <= 16);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 145,
   FQN="clang::CodeGen::SwiftABIInfo::classof", NM="_ZN5clang7CodeGen12SwiftABIInfo7classofEPKNS0_7ABIInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen12SwiftABIInfo7classofEPKNS0_7ABIInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ ABIInfo /*P*/ info) {
    return info.supportsSwift();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SwiftABIInfo::~SwiftABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ABIInfo.h", line = 131,
   FQN="clang::CodeGen::SwiftABIInfo::~SwiftABIInfo", NM="_ZN5clang7CodeGen12SwiftABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen12SwiftABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
